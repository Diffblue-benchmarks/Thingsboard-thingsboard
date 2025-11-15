/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.link.Link;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.node.LwM2mMultipleResource;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.device.profile.DeviceProfileAlarm;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileProvisionConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.SessionMsgListener;
import org.thingsboard.server.common.transport.TransportDeviceProfileCache;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.common.TbRuleEngineProducerService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.attributes.LwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigServiceImpl;
import org.thingsboard.server.transport.lwm2m.server.rpc.LwM2MRpcRequestHandler;
import org.thingsboard.server.transport.lwm2m.server.session.DefaultLwM2MSessionManager;
import org.thingsboard.server.transport.lwm2m.server.session.LwM2MSessionManager;
import org.thingsboard.server.transport.lwm2m.server.store.TbDummyLwM2MClientStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbInMemorySecurityStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MClientStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2mSecurityStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbRedisLwM2MClientStore;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mUplinkMsgHandler;

class LwM2mClientContextImplDiffblueTest {
  /**
   * Method under test: {@link LwM2mClientContextImpl#init()}
   */
  @Test
  void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();

    // Act
    (new LwM2mClientContextImpl(context, config, securityStore2, clientStore, sessionManager, deviceProfileCache,
        new LwM2MModelConfigServiceImpl())).init();

    // Assert that nothing has changed
    verify(context).getNodeId();
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  void testGetClientByEndpoint() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    TbLwM2MClientStore clientStore = mock(TbLwM2MClientStore.class);
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    when(clientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act
    LwM2mClient actualClientByEndpoint = lwM2mClientContextImpl
        .getClientByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(context).getNodeId();
    verify(clientStore).get(eq("https://config.us-east-2.amazonaws.com"));
    assertEquals(1, lwM2mClientContextImpl.getLwM2mClients().size());
    assertSame(lwM2mClient, actualClientByEndpoint);
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  void testGetClientByEndpoint2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doNothing().when(lwM2mClient).refreshSessionId(Mockito.<String>any());
    when(lwM2mClient.getRegistration()).thenReturn(null);
    when(lwM2mClient.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TbLwM2MClientStore clientStore = mock(TbLwM2MClientStore.class);
    doNothing().when(clientStore).put(Mockito.<LwM2mClient>any());
    when(clientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);
    TransportService transportService = mock(TransportService.class);
    when(transportService.registerAsyncSession(Mockito.<TransportProtos.SessionInfoProto>any(),
        Mockito.<SessionMsgListener>any())).thenReturn(null);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.TransportToDeviceActorMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService,
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act
    lwM2mClientContextImpl.getClientByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(context).getNodeId();
    verify(transportService).process(isA(TransportProtos.TransportToDeviceActorMsg.class),
        (TransportServiceCallback<Void>) isNull());
    verify(transportService).registerAsyncSession(isA(TransportProtos.SessionInfoProto.class),
        isA(SessionMsgListener.class));
    verify(lwM2mClient).getRegistration();
    verify(lwM2mClient, atLeast(1)).getSession();
    verify(lwM2mClient).refreshSessionId(eq("42"));
    verify(clientStore).get(eq("https://config.us-east-2.amazonaws.com"));
    verify(clientStore).put(isA(LwM2mClient.class));
    assertEquals(1, lwM2mClientContextImpl.getLwM2mClients().size());
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  void testGetClientByEndpoint3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    Registration registration = mock(Registration.class);
    when(registration.getId()).thenReturn("42");
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doNothing().when(lwM2mClient).refreshSessionId(Mockito.<String>any());
    when(lwM2mClient.getRegistration()).thenReturn(registration);
    when(lwM2mClient.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TbLwM2MClientStore clientStore = mock(TbLwM2MClientStore.class);
    doNothing().when(clientStore).put(Mockito.<LwM2mClient>any());
    when(clientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);
    TransportService transportService = mock(TransportService.class);
    when(transportService.registerAsyncSession(Mockito.<TransportProtos.SessionInfoProto>any(),
        Mockito.<SessionMsgListener>any())).thenReturn(null);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.TransportToDeviceActorMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService,
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act
    lwM2mClientContextImpl.getClientByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(registration).getId();
    verify(context).getNodeId();
    verify(transportService).process(isA(TransportProtos.TransportToDeviceActorMsg.class),
        (TransportServiceCallback<Void>) isNull());
    verify(transportService).registerAsyncSession(isA(TransportProtos.SessionInfoProto.class),
        isA(SessionMsgListener.class));
    verify(lwM2mClient, atLeast(1)).getRegistration();
    verify(lwM2mClient, atLeast(1)).getSession();
    verify(lwM2mClient).refreshSessionId(eq("42"));
    verify(clientStore).get(eq("https://config.us-east-2.amazonaws.com"));
    verify(clientStore).put(isA(LwM2mClient.class));
    assertEquals(1, lwM2mClientContextImpl.getLwM2mClients().size());
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  void testGetClientByEndpoint4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    Registration registration = mock(Registration.class);
    when(registration.getId()).thenReturn("42");
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doNothing().when(lwM2mClient).refreshSessionId(Mockito.<String>any());
    when(lwM2mClient.getRegistration()).thenReturn(registration);
    when(lwM2mClient.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TbLwM2MClientStore clientStore = mock(TbLwM2MClientStore.class);
    doNothing().when(clientStore).put(Mockito.<LwM2mClient>any());
    when(clientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    doNothing().when(sessionManager).register(Mockito.<TransportProtos.SessionInfoProto>any());
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act
    lwM2mClientContextImpl.getClientByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(registration).getId();
    verify(context).getNodeId();
    verify(lwM2mClient, atLeast(1)).getRegistration();
    verify(lwM2mClient, atLeast(1)).getSession();
    verify(lwM2mClient).refreshSessionId(eq("42"));
    verify(sessionManager).register(isA(TransportProtos.SessionInfoProto.class));
    verify(clientStore).get(eq("https://config.us-east-2.amazonaws.com"));
    verify(clientStore).put(isA(LwM2mClient.class));
    assertEquals(1, lwM2mClientContextImpl.getLwM2mClients().size());
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#register(LwM2mClient, Registration)}
   */
  @Test
  void testRegister() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.UNREGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(LwM2MClientStateException.class, () -> lwM2mClientContextImpl.register(client, null));
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  void testAsleep() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(true);

    // Act
    boolean actualAsleepResult = lwM2mClientContextImpl.asleep(client);

    // Assert
    verify(client).getEndpoint();
    verify(client, atLeast(1)).isAsleep();
    assertFalse(actualAsleepResult);
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  void testAsleep2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint())
        .thenThrow(new RuntimeException("[{}] Client is already at sleeping: {}, ignoring event: {}"));
    when(client.isAsleep()).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(client).getEndpoint();
    verify(client).isAsleep();
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  void testAsleep3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new RuntimeException("[{}] Switch sleeping from: {} to: {}"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getSession();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(eq(true));
    verify(client, atLeast(1)).unlock();
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  void testAsleep4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache2, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    boolean actualAsleepResult = lwM2mClientContextImpl.asleep(client);

    // Assert
    verify(context).getTransportService();
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getSession();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(eq(true));
    verify(client, atLeast(1)).unlock();
    assertTrue(actualAsleepResult);
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  void testAsleep5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache2, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    boolean actualAsleepResult = lwM2mClientContextImpl.asleep(client);

    // Assert
    verify(context).getTransportService();
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getSession();
    verify(client).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(eq(true));
    verify(client, atLeast(1)).unlock();
    assertTrue(actualAsleepResult);
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  void testAsleep6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.DRX);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    boolean actualAsleepResult = lwM2mClientContextImpl.asleep(client);

    // Assert
    verify(client).getPowerMode();
    verify(client, atLeast(1)).isAsleep();
    verify(client).lock();
    verify(client).unlock();
    assertFalse(actualAsleepResult);
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  void testAsleep7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache2, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    boolean actualAsleepResult = lwM2mClientContextImpl.asleep(client);

    // Assert
    verify(context).getTransportService();
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getSession();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(eq(true));
    verify(client, atLeast(1)).unlock();
    assertTrue(actualAsleepResult);
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  void testAwake() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertFalse(lwM2mClientContextImpl.awake(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  void testAwake2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new IllegalArgumentException("foo")).when(client).lock();
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(client).getPowerMode();
    verify(client).lock();
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  void testAwake3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.isAsleep()).thenReturn(true);
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.DRX);

    // Act
    boolean actualAwakeResult = lwM2mClientContextImpl.awake(client);

    // Assert
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).isAsleep();
    verify(client).lock();
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
    assertFalse(actualAwakeResult);
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  void testAwake4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPagingTransmissionWindow()).thenThrow(new RuntimeException("foo"));
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).lock();
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}
   */
  @Test
  void testUpdateRegistration() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertThrows(LwM2MClientStateException.class, () -> lwM2mClientContextImpl
        .updateRegistration(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null));
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}
   */
  @Test
  void testUpdateRegistration2() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(LwM2MClientStateException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}
   */
  @Test
  void testUpdateRegistration3() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPsmActivityTimer()).thenThrow(new IllegalArgumentException("foo"));
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getState();
    verify(client, atLeast(1)).lock();
    verify(client).setRegistration(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}
   */
  @Test
  void testUpdateRegistration4() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isAsleep()).thenReturn(true);
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.DRX);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.updateRegistration(client, null);

    // Assert that nothing has changed
    verify(client, atLeast(1)).getPowerMode();
    verify(client).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setRegistration(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}
   */
  @Test
  void testUpdateRegistration5() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPagingTransmissionWindow()).thenThrow(new RuntimeException("foo"));
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getState();
    verify(client, atLeast(1)).lock();
    verify(client).setRegistration(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}
   */
  @Test
  void testUnregister() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertThrows(LwM2MClientStateException.class,
        () -> lwM2mClientContextImpl.unregister(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null));
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}
   */
  @Test
  void testUnregister2() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(LwM2MClientStateException.class, () -> lwM2mClientContextImpl.unregister(client, null));
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#getClientBySessionInfo(TransportProtos.SessionInfoProto)}
   */
  @Test
  void testGetClientBySessionInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertNull(lwM2mClientContextImpl.getClientBySessionInfo(TransportProtos.SessionInfoProto.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#getObjectIdByKeyNameFromProfile(LwM2mClient, String)}
   */
  @Test
  void testGetObjectIdByKeyNameFromProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException("Fetching profile [{}]"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> lwM2mClientContextImpl.getObjectIdByKeyNameFromProfile(client, "Key Name"));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getProfileId();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#registerClient(Registration, ValidateDeviceCredentialsResponse)}
   */
  @Test
  void testRegisterClient() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doNothing().when(lwM2mClient).refreshSessionId(Mockito.<String>any());
    when(lwM2mClient.getRegistration()).thenReturn(null);
    when(lwM2mClient.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    doNothing().when(lwM2mClient).init(Mockito.<ValidateDeviceCredentialsResponse>any(), Mockito.<UUID>any());
    TbLwM2MClientStore clientStore = mock(TbLwM2MClientStore.class);
    doNothing().when(clientStore).put(Mockito.<LwM2mClient>any());
    when(clientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);
    TransportService transportService = mock(TransportService.class);
    when(transportService.registerAsyncSession(Mockito.<TransportProtos.SessionInfoProto>any(),
        Mockito.<SessionMsgListener>any())).thenReturn(null);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.TransportToDeviceActorMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService,
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    Registration registration = mock(Registration.class);
    when(registration.getId()).thenThrow(new RuntimeException("[{}] fetched client from store: {}"));
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.registerClient(registration, null));
    verify(registration).getEndpoint();
    verify(registration).getId();
    verify(context).getNodeId();
    verify(transportService).process(isA(TransportProtos.TransportToDeviceActorMsg.class),
        (TransportServiceCallback<Void>) isNull());
    verify(transportService).registerAsyncSession(isA(TransportProtos.SessionInfoProto.class),
        isA(SessionMsgListener.class));
    verify(lwM2mClient).getRegistration();
    verify(lwM2mClient, atLeast(1)).getSession();
    verify(lwM2mClient).init(isNull(), isA(UUID.class));
    verify(lwM2mClient).refreshSessionId(eq("42"));
    verify(clientStore).get(eq("https://config.us-east-2.amazonaws.com"));
    verify(clientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#registerClient(Registration, ValidateDeviceCredentialsResponse)}
   */
  @Test
  void testRegisterClient2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    Registration registration = mock(Registration.class);
    when(registration.getId()).thenReturn("42");
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doNothing().when(lwM2mClient).refreshSessionId(Mockito.<String>any());
    when(lwM2mClient.getRegistration()).thenReturn(registration);
    when(lwM2mClient.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TbLwM2MClientStore clientStore = mock(TbLwM2MClientStore.class);
    when(clientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    doThrow(new RuntimeException("[{}] fetched client from store: {}")).when(sessionManager)
        .register(Mockito.<TransportProtos.SessionInfoProto>any());
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    Registration registration2 = mock(Registration.class);
    when(registration2.getId()).thenReturn("42");
    when(registration2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.registerClient(registration2, null));
    verify(registration2).getEndpoint();
    verify(registration).getId();
    verify(context).getNodeId();
    verify(lwM2mClient, atLeast(1)).getRegistration();
    verify(lwM2mClient, atLeast(1)).getSession();
    verify(lwM2mClient).refreshSessionId(eq("42"));
    verify(sessionManager).register(isA(TransportProtos.SessionInfoProto.class));
    verify(clientStore).get(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#registerClient(Registration, ValidateDeviceCredentialsResponse)}
   */
  @Test
  void testRegisterClient3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    Registration registration = mock(Registration.class);
    when(registration.getId()).thenThrow(new RuntimeException("[{}] fetched client from store: {}"));
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getRegistration()).thenReturn(registration);
    TbLwM2MClientStore clientStore = mock(TbLwM2MClientStore.class);
    when(clientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    Registration registration2 = mock(Registration.class);
    when(registration2.getId()).thenReturn("42");
    when(registration2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.registerClient(registration2, null));
    verify(registration2).getEndpoint();
    verify(registration).getId();
    verify(context).getNodeId();
    verify(lwM2mClient, atLeast(1)).getRegistration();
    verify(clientStore).get(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  void testUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert that nothing has changed
    verify(client).getEndpoint();
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  void testUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenThrow(new RuntimeException("[{}] Client is in invalid state: {}!"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.update(client));
    verify(client).getEndpoint();
    verify(client).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  void testUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert that nothing has changed
    verify(client).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  void testUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbRedisLwM2MClientStore clientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(UUID.randomUUID());
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger(1));
    when(client.getLastUplinkTime()).thenReturn(1L);
    when(client.getRegistration()).thenReturn(null);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert
    verify(client).getDefaultObjectIDVer();
    verify(client, atLeast(1)).getDeviceId();
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getLastSentRpcId();
    verify(client).getLastUplinkTime();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client).getRegistration();
    verify(client).getResources();
    verify(client).getRetryAttempts();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
    verify(client).isAsleep();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  void testUpdate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbRedisLwM2MClientStore clientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    stringResourceValueMap.put("nodeId",
        new ResourceValue(lwM2mResource, new ResourceModel(1, "nodeId", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "nodeId", "nodeId", "The characteristics of someone or something")));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert
    verify(client).getEndpoint();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  void testUpdate6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbRedisLwM2MClientStore clientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    HashMap<String, TransportProtos.TsKvProto> stringTsKvProtoMap = new HashMap<>();
    stringTsKvProtoMap.put("nodeId", TransportProtos.TsKvProto.getDefaultInstance());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(UUID.randomUUID());
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger(1));
    when(client.getLastUplinkTime()).thenReturn(1L);
    when(client.getRegistration()).thenReturn(null);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(stringTsKvProtoMap);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert
    verify(client).getDefaultObjectIDVer();
    verify(client, atLeast(1)).getDeviceId();
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getLastSentRpcId();
    verify(client).getLastUplinkTime();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client).getRegistration();
    verify(client).getResources();
    verify(client).getRetryAttempts();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
    verify(client).isAsleep();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  void testSendMsgsAfterSleeping() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient);

    // Assert that nothing has changed
    verify(lwM2MClient).getState();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  void testSendMsgsAfterSleeping2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, new DefaultTransportDeviceProfileCache(), mock(LwM2MModelConfigServiceImpl.class));
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getPowerMode()).thenReturn(PowerMode.DRX);
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.REGISTERED);

    // Act
    lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient);

    // Assert that nothing has changed
    verify(lwM2MClient).getPowerMode();
    verify(lwM2MClient).getState();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  void testSendMsgsAfterSleeping3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MModelConfigServiceImpl modelConfigService = mock(LwM2MModelConfigServiceImpl.class);
    doThrow(new RuntimeException("foo")).when(modelConfigService).sendUpdates(Mockito.<LwM2mClient>any());
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, new DefaultTransportDeviceProfileCache(), modelConfigService);
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getPowerMode()).thenReturn(PowerMode.E_DRX);
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.REGISTERED);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient));
    verify(lwM2MClient).getPowerMode();
    verify(lwM2MClient).getState();
    verify(modelConfigService).sendUpdates(isA(LwM2mClient.class));
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#getLwM2mClients()}
   */
  @Test
  void testGetLwM2mClients() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();

    // Act and Assert
    assertTrue((new LwM2mClientContextImpl(context, config, securityStore2, clientStore, sessionManager,
        deviceProfileCache, new LwM2MModelConfigServiceImpl())).getLwM2mClients().isEmpty());
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#getProfile(UUID)}
   */
  @Test
  void testGetProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(null);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act
    Lwm2mDeviceProfileTransportConfiguration actualProfile = lwM2mClientContextImpl.getProfile(UUID.randomUUID());

    // Assert
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
    assertNull(actualProfile);
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#getProfile(UUID)}
   */
  @Test
  void testGetProfile2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException("Fetching profile [{}]"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getProfile(UUID.randomUUID()));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#getProfile(Registration)}
   */
  @Test
  void testGetProfile3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doNothing().when(lwM2mClient).refreshSessionId(Mockito.<String>any());
    when(lwM2mClient.getProfileId()).thenReturn(UUID.randomUUID());
    when(lwM2mClient.getRegistration()).thenReturn(null);
    when(lwM2mClient.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TbLwM2MClientStore clientStore = mock(TbLwM2MClientStore.class);
    doNothing().when(clientStore).put(Mockito.<LwM2mClient>any());
    when(clientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    doNothing().when(sessionManager).register(Mockito.<TransportProtos.SessionInfoProto>any());
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(null);
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    Lwm2mDeviceProfileTransportConfiguration actualProfile = lwM2mClientContextImpl.getProfile(registration);

    // Assert
    verify(registration).getEndpoint();
    verify(context).getNodeId();
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
    verify(lwM2mClient).getProfileId();
    verify(lwM2mClient).getRegistration();
    verify(lwM2mClient, atLeast(1)).getSession();
    verify(lwM2mClient).refreshSessionId(eq("42"));
    verify(sessionManager).register(isA(TransportProtos.SessionInfoProto.class));
    verify(clientStore).get(eq("https://config.us-east-2.amazonaws.com"));
    verify(clientStore).put(isA(LwM2mClient.class));
    assertNull(actualProfile);
    assertEquals(1, lwM2mClientContextImpl.getLwM2mClients().size());
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#getProfile(Registration)}
   */
  @Test
  void testGetProfile4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doNothing().when(lwM2mClient).refreshSessionId(Mockito.<String>any());
    when(lwM2mClient.getProfileId()).thenReturn(UUID.randomUUID());
    when(lwM2mClient.getRegistration()).thenReturn(null);
    when(lwM2mClient.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TbLwM2MClientStore clientStore = mock(TbLwM2MClientStore.class);
    doNothing().when(clientStore).put(Mockito.<LwM2mClient>any());
    when(clientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    doNothing().when(sessionManager).register(Mockito.<TransportProtos.SessionInfoProto>any());
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException("[{}] fetched client from store: {}"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getProfile(registration));
    verify(registration).getEndpoint();
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(context).getNodeId();
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
    verify(lwM2mClient).getProfileId();
    verify(lwM2mClient).getRegistration();
    verify(lwM2mClient, atLeast(1)).getSession();
    verify(lwM2mClient).refreshSessionId(eq("42"));
    verify(sessionManager).register(isA(TransportProtos.SessionInfoProto.class));
    verify(clientStore).get(eq("https://config.us-east-2.amazonaws.com"));
    verify(clientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#getProfile(Registration)}
   */
  @Test
  void testGetProfile5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    Registration registration = mock(Registration.class);
    when(registration.getId()).thenReturn("42");
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doNothing().when(lwM2mClient).refreshSessionId(Mockito.<String>any());
    when(lwM2mClient.getProfileId()).thenReturn(UUID.randomUUID());
    when(lwM2mClient.getRegistration()).thenReturn(registration);
    when(lwM2mClient.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TbLwM2MClientStore clientStore = mock(TbLwM2MClientStore.class);
    doNothing().when(clientStore).put(Mockito.<LwM2mClient>any());
    when(clientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    doNothing().when(sessionManager).register(Mockito.<TransportProtos.SessionInfoProto>any());
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException("[{}] fetched client from store: {}"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    Registration registration2 = mock(Registration.class);
    when(registration2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getProfile(registration2));
    verify(registration2).getEndpoint();
    verify(registration).getId();
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(context).getNodeId();
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
    verify(lwM2mClient).getProfileId();
    verify(lwM2mClient, atLeast(1)).getRegistration();
    verify(lwM2mClient, atLeast(1)).getSession();
    verify(lwM2mClient).refreshSessionId(eq("42"));
    verify(sessionManager).register(isA(TransportProtos.SessionInfoProto.class));
    verify(clientStore).get(eq("https://config.us-east-2.amazonaws.com"));
    verify(clientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#profileUpdate(DeviceProfile)}
   */
  @Test
  void testProfileUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId())
        .thenThrow(new RuntimeException("[{}] Received profile with invalid transport configuration: {}"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.profileUpdate(deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#getSupportedIdVerInClient(LwM2mClient)}
   */
  @Test
  void testGetSupportedIdVerInClient() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    Registration registration = mock(Registration.class);
    when(registration.getObjectLinks()).thenReturn(new Link[]{new Link("42", new ArrayList<>())});
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);

    // Act
    Set<String> actualSupportedIdVerInClient = lwM2mClientContextImpl.getSupportedIdVerInClient(client);

    // Assert
    verify(registration).getObjectLinks();
    verify(client).getRegistration();
    assertEquals(1, actualSupportedIdVerInClient.size());
    assertTrue(actualSupportedIdVerInClient.contains("42"));
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#getSupportedIdVerInClient(LwM2mClient)}
   */
  @Test
  void testGetSupportedIdVerInClient2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    Registration registration = mock(Registration.class);
    when(registration.getObjectLinks()).thenReturn(new Link[]{new Link("", new ArrayList<>())});
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);

    // Act
    Set<String> actualSupportedIdVerInClient = lwM2mClientContextImpl.getSupportedIdVerInClient(client);

    // Assert
    verify(registration).getObjectLinks();
    verify(client).getRegistration();
    assertNull(actualSupportedIdVerInClient);
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#getSupportedIdVerInClient(LwM2mClient)}
   */
  @Test
  void testGetSupportedIdVerInClient3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    Registration registration = mock(Registration.class);
    when(registration.getObjectLinks()).thenReturn(new Link[]{});
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);

    // Act
    Set<String> actualSupportedIdVerInClient = lwM2mClientContextImpl.getSupportedIdVerInClient(client);

    // Assert
    verify(registration).getObjectLinks();
    verify(client).getRegistration();
    assertNull(actualSupportedIdVerInClient);
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#getClientByDeviceId(UUID)}
   */
  @Test
  void testGetClientByDeviceId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertNull(lwM2mClientContextImpl.getClientByDeviceId(UUID.randomUUID()));
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}
   */
  @Test
  void testIsDownlinkAllowed() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertTrue(
        lwM2mClientContextImpl.isDownlinkAllowed(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}
   */
  @Test
  void testIsDownlinkAllowed2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException("Fetching profile [{}]"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.isDownlinkAllowed(client));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}
   */
  @Test
  void testIsDownlinkAllowed3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPowerMode()).thenReturn(PowerMode.DRX);

    // Act
    boolean actualIsDownlinkAllowedResult = lwM2mClientContextImpl.isDownlinkAllowed(client);

    // Assert
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(client).getPowerMode();
    assertTrue(actualIsDownlinkAllowedResult);
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  void testOnUplink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new IllegalArgumentException("foo")).when(client).lock();
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClientContextImpl.onUplink(client));
    verify(client).getPowerMode();
    verify(client).lock();
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  void testOnUplink2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.DRX);

    // Act
    lwM2mClientContextImpl.onUplink(client);

    // Assert that nothing has changed
    verify(client).getPowerMode();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  void testOnUplink3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPagingTransmissionWindow()).thenThrow(new RuntimeException("foo"));
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.onUplink(client));
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).lock();
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  void testGetRequestTimeout() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException("Fetching profile [{}]"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getRequestTimeout(client));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client).getProfileId();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  void testGetRequestTimeout2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act
    Long actualRequestTimeout = lwM2mClientContextImpl.getRequestTimeout(client);

    // Assert
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getPowerMode();
    assertEquals(1L, actualRequestTimeout.longValue());
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  void testGetRequestTimeout3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEdrxCycle()).thenReturn(0L);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act
    Long actualRequestTimeout = lwM2mClientContextImpl.getRequestTimeout(client);

    // Assert
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getPowerMode();
    assertNull(actualRequestTimeout);
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  void testGetRequestTimeout4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceProfileTransportConfiguration deviceProfileTransportConfiguration = mock(
        DeviceProfileTransportConfiguration.class);
    when(deviceProfileTransportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getTransportConfiguration()).thenReturn(deviceProfileTransportConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException("Fetching profile [{}]"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getRequestTimeout(client));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(deviceProfileData).getTransportConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(deviceProfileTransportConfiguration).getType();
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getEdrxCycle();
    verify(client).getPowerMode();
    verify(client).getProfileId();
  }

  /**
   * Method under test:
   * {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  void testGetRequestTimeout5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEdrxCycle()).thenThrow(new RuntimeException("foo"));
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getRequestTimeout(client));
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(client).getEdrxCycle();
    verify(client).getPowerMode();
  }
}
