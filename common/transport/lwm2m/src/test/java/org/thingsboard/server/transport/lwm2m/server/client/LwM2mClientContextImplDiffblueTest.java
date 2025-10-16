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
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.netty.shaded.io.netty.channel.DefaultChannelProgressivePromise;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportDeviceProfileCache;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
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
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigService;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MClientStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbMainSecurityStore;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class LwM2mClientContextImplDiffblueTest {
  @Mock private LwM2MModelConfigService lwM2MModelConfigService;

  @InjectMocks private LwM2mClientContextImpl lwM2mClientContextImpl;

  @Mock private LwM2mTransportContext lwM2mTransportContext;

  @Mock private TbLwM2MClientStore tbLwM2MClientStore;

  @Mock private TbMainSecurityStore tbMainSecurityStore;

  @Mock private TransportDeviceProfileCache transportDeviceProfileCache;

  /**
   * Test {@link LwM2mClientContextImpl#init()}.
   *
   * <ul>
   *   <li>Given {@link LwM2mClient} {@link LwM2mClient#lock()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#init()}
   */
  @Test
  @DisplayName(
      "Test init(); given LwM2mClient lock() throw RuntimeException(); then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.init()"})
  void testInit_givenLwM2mClientLockThrowRuntimeException_thenCallsGetEndpoint() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");

    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doThrow(new RuntimeException()).when(lwM2mClient).lock();
    doThrow(new RuntimeException()).when(lwM2mClient).unlock();
    when(lwM2mClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashSet<LwM2mClient> lwM2mClientSet = new HashSet<>();
    lwM2mClientSet.add(lwM2mClient);
    when(tbLwM2MClientStore.getAll()).thenReturn(lwM2mClientSet);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.init());
    verify(lwM2mTransportContext).getNodeId();
    verify(lwM2mClient).getEndpoint();
    verify(lwM2mClient).lock();
    verify(lwM2mClient).unlock();
    verify(tbLwM2MClientStore).getAll();
  }

  /**
   * Test {@link LwM2mClientContextImpl#init()}.
   *
   * <ul>
   *   <li>Given {@link LwM2mClient} {@link LwM2mClient#lock()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#init()}
   */
  @Test
  @DisplayName(
      "Test init(); given LwM2mClient lock() throw RuntimeException(); then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.init()"})
  void testInit_givenLwM2mClientLockThrowRuntimeException_thenCallsGetEndpoint2() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");

    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doThrow(new RuntimeException()).when(lwM2mClient).lock();
    doThrow(new RuntimeException()).when(lwM2mClient).unlock();
    when(lwM2mClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashSet<LwM2mClient> lwM2mClientSet = new HashSet<>();
    lwM2mClientSet.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    lwM2mClientSet.add(lwM2mClient);
    when(tbLwM2MClientStore.getAll()).thenReturn(lwM2mClientSet);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.init());
    verify(lwM2mTransportContext).getNodeId();
    verify(lwM2mClient).getEndpoint();
    verify(lwM2mClient).lock();
    verify(lwM2mClient).unlock();
    verify(tbLwM2MClientStore).getAll();
  }

  /**
   * Test {@link LwM2mClientContextImpl#init()}.
   *
   * <ul>
   *   <li>Given {@link LwM2mTransportContext} {@link LwM2mTransportContext#getNodeId()} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#init()}
   */
  @Test
  @DisplayName("Test init(); given LwM2mTransportContext getNodeId() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.init()"})
  void testInit_givenLwM2mTransportContextGetNodeIdThrowRuntimeException() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.init());
    verify(lwM2mTransportContext).getNodeId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#init()}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientStore} {@link TbLwM2MClientStore#getAll()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#init()}
   */
  @Test
  @DisplayName("Test init(); given TbLwM2MClientStore getAll() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.init()"})
  void testInit_givenTbLwM2MClientStoreGetAllThrowRuntimeException() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");
    when(tbLwM2MClientStore.getAll()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.init());
    verify(lwM2mTransportContext).getNodeId();
    verify(tbLwM2MClientStore).getAll();
  }

  /**
   * Test {@link LwM2mClientContextImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link LwM2mClientContextImpl} LwM2mClients Empty.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#init()}
   */
  @Test
  @DisplayName("Test init(); then LwM2mClientContextImpl LwM2mClients Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.init()"})
  void testInit_thenLwM2mClientContextImplLwM2mClientsEmpty() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");
    when(tbLwM2MClientStore.getAll()).thenReturn(new HashSet<>());

    // Act
    lwM2mClientContextImpl.init();

    // Assert that nothing has changed
    verify(lwM2mTransportContext).getNodeId();
    verify(tbLwM2MClientStore).getAll();
    assertTrue(lwM2mClientContextImpl.getLwM2mClients().isEmpty());
  }

  /**
   * Test {@link LwM2mClientContextImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link LwM2mClientContextImpl} LwM2mClients size is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#init()}
   */
  @Test
  @DisplayName("Test init(); then LwM2mClientContextImpl LwM2mClients size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.init()"})
  void testInit_thenLwM2mClientContextImplLwM2mClientsSizeIsOne() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");

    HashSet<LwM2mClient> lwM2mClientSet = new HashSet<>();
    lwM2mClientSet.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    when(tbLwM2MClientStore.getAll()).thenReturn(lwM2mClientSet);

    // Act
    lwM2mClientContextImpl.init();

    // Assert
    verify(lwM2mTransportContext).getNodeId();
    verify(tbLwM2MClientStore).getAll();
    assertEquals(1, lwM2mClientContextImpl.getLwM2mClients().size());
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByEndpoint(String)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getClientByEndpoint(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2mClient LwM2mClientContextImpl.getClientByEndpoint(String)"})
  void testGetClientByEndpoint() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);

    // Act
    LwM2mClient actualClientByEndpoint =
        lwM2mClientContextImpl.getClientByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mTransportContext).getNodeId();
    verify(tbLwM2MClientStore).get("https://config.us-east-2.amazonaws.com");
    assertEquals(1, lwM2mClientContextImpl.getLwM2mClients().size());
    assertSame(lwM2mClient, actualClientByEndpoint);
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByEndpoint(String)}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientStore} {@link TbLwM2MClientStore#get(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  @DisplayName(
      "Test getClientByEndpoint(String); given TbLwM2MClientStore get(String) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2mClient LwM2mClientContextImpl.getClientByEndpoint(String)"})
  void testGetClientByEndpoint_givenTbLwM2MClientStoreGetThrowRuntimeException() {
    // Arrange
    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> lwM2mClientContextImpl.getClientByEndpoint("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientStore).get("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByEndpoint(String)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getRegistration()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getClientByEndpoint(String); then calls getRegistration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2mClient LwM2mClientContextImpl.getClientByEndpoint(String)"})
  void testGetClientByEndpoint_thenCallsGetRegistration() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");

    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getRegistration()).thenThrow(new RuntimeException());
    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> lwM2mClientContextImpl.getClientByEndpoint("https://config.us-east-2.amazonaws.com"));
    verify(lwM2mTransportContext).getNodeId();
    verify(lwM2mClient).getRegistration();
    verify(tbLwM2MClientStore).get("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByEndpoint(String)}.
   *
   * <ul>
   *   <li>Then return NodeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getClientByEndpoint(String); then return NodeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2mClient LwM2mClientContextImpl.getClientByEndpoint(String)"})
  void testGetClientByEndpoint_thenReturnNodeIdIs42() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");
    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenReturn(null);

    // Act
    LwM2mClient actualClientByEndpoint =
        lwM2mClientContextImpl.getClientByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mTransportContext).getNodeId();
    verify(tbLwM2MClientStore).get("https://config.us-east-2.amazonaws.com");
    assertEquals("42", actualClientByEndpoint.getNodeId());
    assertEquals("https://config.us-east-2.amazonaws.com", actualClientByEndpoint.getEndpoint());
    assertNull(actualClientByEndpoint.getEdrxCycle());
    assertNull(actualClientByEndpoint.getPagingTransmissionWindow());
    assertNull(actualClientByEndpoint.getPsmActivityTimer());
    assertNull(actualClientByEndpoint.getSupportedClientObjects());
    assertNull(actualClientByEndpoint.getClientSupportContentFormats());
    assertNull(actualClientByEndpoint.getDeviceId());
    assertNull(actualClientByEndpoint.getLastSentRpcId());
    assertNull(actualClientByEndpoint.getProfileId());
    assertNull(actualClientByEndpoint.getSleepTask());
    assertNull(actualClientByEndpoint.getDefaultContentFormat());
    assertNull(actualClientByEndpoint.getRegistration());
    assertNull(actualClientByEndpoint.getPowerMode());
    assertNull(actualClientByEndpoint.getTenantId());
    assertNull(actualClientByEndpoint.getSession());
    assertEquals(0L, actualClientByEndpoint.getLastUplinkTime());
    assertEquals(1, lwM2mClientContextImpl.getLwM2mClients().size());
    assertEquals(LwM2MClientState.CREATED, actualClientByEndpoint.getState());
    assertFalse(actualClientByEndpoint.isAsleep());
    assertTrue(actualClientByEndpoint.getKeyTsLatestMap().isEmpty());
    assertTrue(actualClientByEndpoint.getResources().isEmpty());
    assertTrue(actualClientByEndpoint.getSharedAttributes().isEmpty());
  }

  /**
   * Test {@link LwM2mClientContextImpl#register(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#register(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName("Test register(LwM2mClient, Registration); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Optional LwM2mClientContextImpl.register(LwM2mClient, Registration)"
  })
  void testRegister_thenThrowRuntimeException() throws LwM2MClientStateException {
    // Arrange
    when(tbMainSecurityStore.getTbLwM2MSecurityInfoByEndpoint(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            lwM2mClientContextImpl.register(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null));
    verify(tbMainSecurityStore)
        .getTbLwM2MSecurityInfoByEndpoint("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code CREATED}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return {@code CREATED}.
   *   <li>Then calls {@link LwM2mClient#getSession()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test asleep(LwM2mClient); given 'CREATED'; when LwM2mClient getState() return 'CREATED'; then calls getSession()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_givenCreated_whenLwM2mClientGetStateReturnCreated_thenCallsGetSession() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService defaultTransportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    when(lwM2mTransportContext.getTransportService()).thenReturn(defaultTransportService);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new RuntimeException());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(lwM2mTransportContext).getTransportService();
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getSession();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(true);
    verify(client, atLeast(1)).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code DRX}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPowerMode()} return {@code DRX}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test asleep(LwM2mClient); given 'DRX'; when LwM2mClient getPowerMode() return 'DRX'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_givenDrx_whenLwM2mClientGetPowerModeReturnDrx_thenReturnFalse() {
    // Arrange
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
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code E_DRX}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPowerMode()} return {@code E_DRX}.
   *   <li>Then calls {@link LwM2mClient#getSession()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test asleep(LwM2mClient); given 'E_DRX'; when LwM2mClient getPowerMode() return 'E_DRX'; then calls getSession()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_givenEDrx_whenLwM2mClientGetPowerModeReturnEDrx_thenCallsGetSession() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService defaultTransportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    when(lwM2mTransportContext.getTransportService()).thenReturn(defaultTransportService);
    doNothing().when(tbLwM2MClientStore).put(Mockito.<LwM2mClient>any());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new RuntimeException());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(lwM2mTransportContext).getTransportService();
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getSession();
    verify(client).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(true);
    verify(client, atLeast(1)).unlock();
    verify(tbLwM2MClientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mTransportContext} {@link LwM2mTransportContext#getTransportService()}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test asleep(LwM2mClient); given LwM2mTransportContext getTransportService() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_givenLwM2mTransportContextGetTransportServiceThrowRuntimeException() {
    // Arrange
    when(lwM2mTransportContext.getTransportService()).thenThrow(new RuntimeException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(lwM2mTransportContext).getTransportService();
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(true);
    verify(client, atLeast(1)).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientStore} {@link TbLwM2MClientStore#put(LwM2mClient)} does
   *       nothing.
   *   <li>Then calls {@link LwM2mClient#getSession()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test asleep(LwM2mClient); given TbLwM2MClientStore put(LwM2mClient) does nothing; then calls getSession()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_givenTbLwM2MClientStorePutDoesNothing_thenCallsGetSession() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService defaultTransportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    when(lwM2mTransportContext.getTransportService()).thenReturn(defaultTransportService);
    doNothing().when(tbLwM2MClientStore).put(Mockito.<LwM2mClient>any());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new RuntimeException());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(lwM2mTransportContext).getTransportService();
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getSession();
    verify(client).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(true);
    verify(client, atLeast(1)).unlock();
    verify(tbLwM2MClientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientStore} {@link TbLwM2MClientStore#put(LwM2mClient)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link TbLwM2MClientStore#put(LwM2mClient)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test asleep(LwM2mClient); given TbLwM2MClientStore put(LwM2mClient) throw RuntimeException(); then calls put(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_givenTbLwM2MClientStorePutThrowRuntimeException_thenCallsPut() {
    // Arrange
    doThrow(new RuntimeException()).when(tbLwM2MClientStore).put(Mockito.<LwM2mClient>any());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(client).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(true);
    verify(client, atLeast(1)).unlock();
    verify(tbLwM2MClientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TransportDeviceProfileCache} {@link
   *       TransportDeviceProfileCache#get(DeviceProfileId)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link TransportDeviceProfileCache#get(DeviceProfileId)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test asleep(LwM2mClient); given TransportDeviceProfileCache get(DeviceProfileId) throw RuntimeException(); then calls get(DeviceProfileId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_givenTransportDeviceProfileCacheGetThrowRuntimeException_thenCallsGet() {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any()))
        .thenThrow(new RuntimeException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client, atLeast(1)).isAsleep();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getEndpoint()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test asleep(LwM2mClient); given 'true'; when LwM2mClient getEndpoint() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_givenTrue_whenLwM2mClientGetEndpointThrowRuntimeException() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenThrow(new RuntimeException());
    when(client.isAsleep()).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(client).getEndpoint();
    verify(client).isAsleep();
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#isAsleep()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test asleep(LwM2mClient); given 'true'; when LwM2mClient isAsleep() return 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_givenTrue_whenLwM2mClientIsAsleepReturnTrue_thenReturnFalse() {
    // Arrange
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
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName("Test asleep(LwM2mClient); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_thenCallsGetId() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client, atLeast(1)).isAsleep();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#setAsleep(boolean)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link LwM2mClient#setAsleep(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test asleep(LwM2mClient); when LwM2mClient setAsleep(boolean) throw RuntimeException(); then calls setAsleep(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_whenLwM2mClientSetAsleepThrowRuntimeException_thenCallsSetAsleep() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new RuntimeException()).when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(client).getEndpoint();
    verify(client).getPowerMode();
    verify(client, atLeast(1)).isAsleep();
    verify(client).lock();
    verify(client).setAsleep(true);
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName("Test awake(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake() {
    // Arrange, Act and Assert
    assertFalse(
        lwM2mClientContextImpl.awake(
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code CREATED}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return {@code CREATED}.
   *   <li>Then calls {@link LwM2mClient#getSession()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test awake(LwM2mClient); given 'CREATED'; when LwM2mClient getState() return 'CREATED'; then calls getSession()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_givenCreated_whenLwM2mClientGetStateReturnCreated_thenCallsGetSession() {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    when(defaultSchedulerComponent.schedule(
            Mockito.<Callable<Object>>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService defaultTransportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    when(lwM2mTransportContext.getTransportService()).thenReturn(defaultTransportService);
    when(lwM2mTransportContext.getScheduler()).thenReturn(defaultSchedulerComponent);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new RuntimeException());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).setAsleep(anyBoolean());
    doNothing().when(client).setSleepTask(Mockito.<Future<Void>>any());
    when(client.getSleepTask()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.isAsleep()).thenReturn(true);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(lwM2mTransportContext).getScheduler();
    verify(lwM2mTransportContext).getTransportService();
    verify(defaultSchedulerComponent)
        .schedule(isA(Callable.class), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSession();
    verify(client).getSleepTask();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(false);
    verify(client).setSleepTask(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#isAsleep()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test awake(LwM2mClient); given 'false'; when LwM2mClient isAsleep() return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_givenFalse_whenLwM2mClientIsAsleepReturnFalse_thenReturnFalse() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isAsleep()).thenReturn(false);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.updateLastUplinkTime()).thenReturn(1L);

    // Act
    boolean actualAwakeResult = lwM2mClientContextImpl.awake(client);

    // Assert
    verify(client).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client, atLeast(1)).isAsleep();
    verify(client).updateLastUplinkTime();
    assertFalse(actualAwakeResult);
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mTransportContext} {@link LwM2mTransportContext#getTransportService()}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test awake(LwM2mClient); given LwM2mTransportContext getTransportService() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_givenLwM2mTransportContextGetTransportServiceThrowRuntimeException() {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    when(defaultSchedulerComponent.schedule(
            Mockito.<Callable<Object>>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    when(lwM2mTransportContext.getTransportService()).thenThrow(new RuntimeException());
    when(lwM2mTransportContext.getScheduler()).thenReturn(defaultSchedulerComponent);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).setAsleep(anyBoolean());
    doNothing().when(client).setSleepTask(Mockito.<Future<Void>>any());
    when(client.getSleepTask()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.isAsleep()).thenReturn(true);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(lwM2mTransportContext).getScheduler();
    verify(lwM2mTransportContext).getTransportService();
    verify(defaultSchedulerComponent)
        .schedule(isA(Callable.class), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSleepTask();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(false);
    verify(client).setSleepTask(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientStore} {@link TbLwM2MClientStore#put(LwM2mClient)} does
   *       nothing.
   *   <li>Then calls {@link LwM2mClient#getSession()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test awake(LwM2mClient); given TbLwM2MClientStore put(LwM2mClient) does nothing; then calls getSession()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_givenTbLwM2MClientStorePutDoesNothing_thenCallsGetSession() {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    when(defaultSchedulerComponent.schedule(
            Mockito.<Callable<Object>>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService defaultTransportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    when(lwM2mTransportContext.getTransportService()).thenReturn(defaultTransportService);
    when(lwM2mTransportContext.getScheduler()).thenReturn(defaultSchedulerComponent);
    doNothing().when(tbLwM2MClientStore).put(Mockito.<LwM2mClient>any());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new RuntimeException());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).setAsleep(anyBoolean());
    doNothing().when(client).setSleepTask(Mockito.<Future<Void>>any());
    when(client.getSleepTask()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.isAsleep()).thenReturn(true);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(lwM2mTransportContext).getScheduler();
    verify(lwM2mTransportContext).getTransportService();
    verify(defaultSchedulerComponent)
        .schedule(isA(Callable.class), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSession();
    verify(client).getSleepTask();
    verify(client).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(false);
    verify(client).setSleepTask(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
    verify(tbLwM2MClientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientStore} {@link TbLwM2MClientStore#put(LwM2mClient)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link TbLwM2MClientStore#put(LwM2mClient)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test awake(LwM2mClient); given TbLwM2MClientStore put(LwM2mClient) throw RuntimeException(); then calls put(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_givenTbLwM2MClientStorePutThrowRuntimeException_thenCallsPut() {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    when(defaultSchedulerComponent.schedule(
            Mockito.<Callable<Object>>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    when(lwM2mTransportContext.getScheduler()).thenReturn(defaultSchedulerComponent);
    doThrow(new RuntimeException()).when(tbLwM2MClientStore).put(Mockito.<LwM2mClient>any());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).setAsleep(anyBoolean());
    doNothing().when(client).setSleepTask(Mockito.<Future<Void>>any());
    when(client.getSleepTask()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.isAsleep()).thenReturn(true);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(lwM2mTransportContext).getScheduler();
    verify(defaultSchedulerComponent)
        .schedule(isA(Callable.class), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(client).getEndpoint();
    verify(client, atLeast(1)).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSleepTask();
    verify(client).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(false);
    verify(client).setSleepTask(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
    verify(tbLwM2MClientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TransportDeviceProfileCache} {@link
   *       TransportDeviceProfileCache#get(DeviceProfileId)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link TransportDeviceProfileCache#get(DeviceProfileId)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test awake(LwM2mClient); given TransportDeviceProfileCache get(DeviceProfileId) throw RuntimeException(); then calls get(DeviceProfileId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_givenTransportDeviceProfileCacheGetThrowRuntimeException_thenCallsGet() {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any()))
        .thenThrow(new RuntimeException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName("Test awake(LwM2mClient); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_thenCallsGetId() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getSleepTask()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName("Test awake(LwM2mClient); when LwM2mClient getSleepTask() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_whenLwM2mClientGetSleepTaskThrowRuntimeException() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSleepTask()).thenThrow(new RuntimeException());
    when(client.getPsmActivityTimer()).thenReturn(1L);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSleepTask();
    verify(client).lock();
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#lock()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link LwM2mClient#lock()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test awake(LwM2mClient); when LwM2mClient lock() throw RuntimeException(); then calls lock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_whenLwM2mClientLockThrowRuntimeException_thenCallsLock() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new RuntimeException()).when(client).lock();
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(client).getPowerMode();
    verify(client).lock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#setSleepTask(Future)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link LwM2mTransportContext#getScheduler()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test awake(LwM2mClient); when LwM2mClient setSleepTask(Future) throw RuntimeException(); then calls getScheduler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_whenLwM2mClientSetSleepTaskThrowRuntimeException_thenCallsGetScheduler() {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    when(defaultSchedulerComponent.schedule(
            Mockito.<Callable<Object>>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    when(lwM2mTransportContext.getScheduler()).thenReturn(defaultSchedulerComponent);

    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new RuntimeException()).when(client).setSleepTask(Mockito.<Future<Void>>any());
    when(client.getSleepTask()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(lwM2mTransportContext).getScheduler();
    verify(defaultSchedulerComponent)
        .schedule(isA(Callable.class), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSleepTask();
    verify(client).lock();
    verify(client).setSleepTask(isNull());
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName("Test updateRegistration(LwM2mClient, Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration() throws LwM2MClientStateException {
    // Arrange, Act and Assert
    assertThrows(
        LwM2MClientStateException.class,
        () ->
            lwM2mClientContextImpl.updateRegistration(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null));
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>Given {@code CREATED}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return {@code CREATED}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName(
      "Test updateRegistration(LwM2mClient, Registration); given 'CREATED'; when LwM2mClient getState() return 'CREATED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration_givenCreated_whenLwM2mClientGetStateReturnCreated()
      throws LwM2MClientStateException {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(
        LwM2MClientStateException.class,
        () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName(
      "Test updateRegistration(LwM2mClient, Registration); given 'false'; then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration_givenFalse_thenCallsGetEndpoint() throws LwM2MClientStateException {
    // Arrange
    doNothing().when(tbLwM2MClientStore).put(Mockito.<LwM2mClient>any());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isAsleep()).thenReturn(false);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.updateLastUplinkTime()).thenReturn(1L);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.updateRegistration(client, null);

    // Assert
    verify(client).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client).lock();
    verify(client).setRegistration(isNull());
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
    verify(tbLwM2MClientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>Given {@link TransportDeviceProfileCache} {@link
   *       TransportDeviceProfileCache#get(DeviceProfileId)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName(
      "Test updateRegistration(LwM2mClient, Registration); given TransportDeviceProfileCache get(DeviceProfileId) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration_givenTransportDeviceProfileCacheGetThrowRuntimeException()
      throws LwM2MClientStateException {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any()))
        .thenThrow(new RuntimeException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(null);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client).getState();
    verify(client).lock();
    verify(client).setRegistration(isNull());
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName("Test updateRegistration(LwM2mClient, Registration); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration_thenCallsGetId() throws LwM2MClientStateException {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(null);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client).getState();
    verify(client).lock();
    verify(client).setRegistration(isNull());
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mTransportContext#getScheduler()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName("Test updateRegistration(LwM2mClient, Registration); then calls getScheduler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration_thenCallsGetScheduler() throws LwM2MClientStateException {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    when(defaultSchedulerComponent.schedule(
            Mockito.<Callable<Object>>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    when(lwM2mTransportContext.getScheduler()).thenReturn(defaultSchedulerComponent);

    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new RuntimeException()).when(client).setSleepTask(Mockito.<Future<Void>>any());
    when(client.getSleepTask()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(lwM2mTransportContext).getScheduler();
    verify(defaultSchedulerComponent)
        .schedule(isA(Callable.class), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSleepTask();
    verify(client).getState();
    verify(client, atLeast(1)).lock();
    verify(client).setRegistration(isNull());
    verify(client).setSleepTask(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPsmActivityTimer()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName(
      "Test updateRegistration(LwM2mClient, Registration); when LwM2mClient getPsmActivityTimer() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration_whenLwM2mClientGetPsmActivityTimerThrowRuntimeException()
      throws LwM2MClientStateException {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPsmActivityTimer()).thenThrow(new RuntimeException());
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getState();
    verify(client, atLeast(1)).lock();
    verify(client).setRegistration(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getSleepTask()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName(
      "Test updateRegistration(LwM2mClient, Registration); when LwM2mClient getSleepTask() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration_whenLwM2mClientGetSleepTaskThrowRuntimeException()
      throws LwM2MClientStateException {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSleepTask()).thenThrow(new RuntimeException());
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSleepTask();
    verify(client).getState();
    verify(client, atLeast(1)).lock();
    verify(client).setRegistration(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#setRegistration(Registration)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName(
      "Test updateRegistration(LwM2mClient, Registration); when LwM2mClient setRegistration(Registration) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration_whenLwM2mClientSetRegistrationThrowRuntimeException()
      throws LwM2MClientStateException {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new RuntimeException()).when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client).getState();
    verify(client).lock();
    verify(client).setRegistration(isNull());
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName("Test unregister(LwM2mClient, Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.unregister(LwM2mClient, Registration)"})
  void testUnregister() throws LwM2MClientStateException {
    // Arrange, Act and Assert
    assertThrows(
        LwM2MClientStateException.class,
        () ->
            lwM2mClientContextImpl.unregister(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null));
  }

  /**
   * Test {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>Given {@code CREATED}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return {@code CREATED}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName(
      "Test unregister(LwM2mClient, Registration); given 'CREATED'; when LwM2mClient getState() return 'CREATED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.unregister(LwM2mClient, Registration)"})
  void testUnregister_givenCreated_whenLwM2mClientGetStateReturnCreated()
      throws LwM2MClientStateException {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(
        LwM2MClientStateException.class, () -> lwM2mClientContextImpl.unregister(client, null));
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName(
      "Test unregister(LwM2mClient, Registration); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.unregister(LwM2mClient, Registration)"})
  void testUnregister_givenRuntimeException_thenThrowRuntimeException()
      throws LwM2MClientStateException {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenThrow(new RuntimeException());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    Registration registration = mock(Registration.class);
    when(registration.getId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.unregister(client, registration));
    verify(registration).getId();
    verify(client).getRegistration();
    verify(client).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientBySessionInfo(SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link TransportProtos.SessionInfoProto#getSessionIdLSB()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mClientContextImpl#getClientBySessionInfo(TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test getClientBySessionInfo(SessionInfoProto); given one; then calls getSessionIdLSB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2mClient LwM2mClientContextImpl.getClientBySessionInfo(TransportProtos.SessionInfoProto)"
  })
  void testGetClientBySessionInfo_givenOne_thenCallsGetSessionIdLSB() {
    // Arrange
    SessionInfoProto sessionInfo = mock(SessionInfoProto.class);
    when(sessionInfo.getSessionIdLSB()).thenReturn(1L);
    when(sessionInfo.getSessionIdMSB()).thenReturn(1L);

    // Act
    LwM2mClient actualClientBySessionInfo =
        lwM2mClientContextImpl.getClientBySessionInfo(sessionInfo);

    // Assert
    verify(sessionInfo).getSessionIdLSB();
    verify(sessionInfo).getSessionIdMSB();
    assertNull(actualClientBySessionInfo);
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientBySessionInfo(SessionInfoProto)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mClientContextImpl#getClientBySessionInfo(TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test getClientBySessionInfo(SessionInfoProto); when DefaultInstance; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2mClient LwM2mClientContextImpl.getClientBySessionInfo(TransportProtos.SessionInfoProto)"
  })
  void testGetClientBySessionInfo_whenDefaultInstance_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        lwM2mClientContextImpl.getClientBySessionInfo(SessionInfoProto.getDefaultInstance()));
  }

  /**
   * Test {@link LwM2mClientContextImpl#getObjectIdByKeyNameFromProfile(LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * LwM2mClientContextImpl#getObjectIdByKeyNameFromProfile(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test getObjectIdByKeyNameFromProfile(LwM2mClient, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String LwM2mClientContextImpl.getObjectIdByKeyNameFromProfile(LwM2mClient, String)"
  })
  void testGetObjectIdByKeyNameFromProfile() {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any()))
        .thenThrow(new RuntimeException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> lwM2mClientContextImpl.getObjectIdByKeyNameFromProfile(client, "Key Name"));
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getObjectIdByKeyNameFromProfile(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mClientContextImpl#getObjectIdByKeyNameFromProfile(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test getObjectIdByKeyNameFromProfile(LwM2mClient, String); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String LwM2mClientContextImpl.getObjectIdByKeyNameFromProfile(LwM2mClient, String)"
  })
  void testGetObjectIdByKeyNameFromProfile_thenCallsGetId() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> lwM2mClientContextImpl.getObjectIdByKeyNameFromProfile(client, "Key Name"));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#registerClient(Registration,
   * ValidateDeviceCredentialsResponse)}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientStore} {@link TbLwM2MClientStore#get(String)} return {@code
   *       null}.
   *   <li>Then calls {@link ValidateDeviceCredentialsResponse#getDeviceInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#registerClient(Registration,
   * ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test registerClient(Registration, ValidateDeviceCredentialsResponse); given TbLwM2MClientStore get(String) return 'null'; then calls getDeviceInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mClientContextImpl.registerClient(Registration, ValidateDeviceCredentialsResponse)"
  })
  void testRegisterClient_givenTbLwM2MClientStoreGetReturnNull_thenCallsGetDeviceInfo() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");
    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenReturn(null);

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    ValidateDeviceCredentialsResponse credentials = mock(ValidateDeviceCredentialsResponse.class);
    when(credentials.getDeviceInfo()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> lwM2mClientContextImpl.registerClient(registration, credentials));
    verify(registration).getEndpoint();
    verify(lwM2mTransportContext).getNodeId();
    verify(credentials).getDeviceInfo();
    verify(tbLwM2MClientStore).get("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link LwM2mClientContextImpl#registerClient(Registration,
   * ValidateDeviceCredentialsResponse)}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientStore} {@link TbLwM2MClientStore#get(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#registerClient(Registration,
   * ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test registerClient(Registration, ValidateDeviceCredentialsResponse); given TbLwM2MClientStore get(String) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mClientContextImpl.registerClient(Registration, ValidateDeviceCredentialsResponse)"
  })
  void testRegisterClient_givenTbLwM2MClientStoreGetThrowRuntimeException() {
    // Arrange
    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenThrow(new RuntimeException());

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.registerClient(registration, null));
    verify(registration).getEndpoint();
    verify(tbLwM2MClientStore).get("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link LwM2mClientContextImpl#registerClient(Registration,
   * ValidateDeviceCredentialsResponse)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getRegistration()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#registerClient(Registration,
   * ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test registerClient(Registration, ValidateDeviceCredentialsResponse); then calls getRegistration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mClientContextImpl.registerClient(Registration, ValidateDeviceCredentialsResponse)"
  })
  void testRegisterClient_thenCallsGetRegistration() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");

    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getRegistration()).thenThrow(new RuntimeException());
    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            lwM2mClientContextImpl.registerClient(
                registration, mock(ValidateDeviceCredentialsResponse.class)));
    verify(registration).getEndpoint();
    verify(lwM2mTransportContext).getNodeId();
    verify(lwM2mClient).getRegistration();
    verify(tbLwM2MClientStore).get("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code https://config.us-east-2.amazonaws.com}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName("Test update(LwM2mClient); given 'https://config.us-east-2.amazonaws.com'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.update(LwM2mClient)"})
  void testUpdate_givenHttpsConfigUsEast2AmazonawsCom() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert
    verify(client).getEndpoint();
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getEndpoint()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test update(LwM2mClient); given RuntimeException(); when LwM2mClient getEndpoint() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.update(LwM2mClient)"})
  void testUpdate_givenRuntimeException_whenLwM2mClientGetEndpointThrowRuntimeException() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenThrow(new RuntimeException());
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
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientStore} {@link TbLwM2MClientStore#put(LwM2mClient)} does
   *       nothing.
   *   <li>Then calls {@link TbLwM2MClientStore#put(LwM2mClient)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test update(LwM2mClient); given TbLwM2MClientStore put(LwM2mClient) does nothing; then calls put(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.update(LwM2mClient)"})
  void testUpdate_givenTbLwM2MClientStorePutDoesNothing_thenCallsPut() {
    // Arrange
    doNothing().when(tbLwM2MClientStore).put(Mockito.<LwM2mClient>any());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert
    verify(client).getState();
    verify(client).lock();
    verify(client).unlock();
    verify(tbLwM2MClientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientStore} {@link TbLwM2MClientStore#put(LwM2mClient)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test update(LwM2mClient); given TbLwM2MClientStore put(LwM2mClient) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.update(LwM2mClient)"})
  void testUpdate_givenTbLwM2MClientStorePutThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(tbLwM2MClientStore).put(Mockito.<LwM2mClient>any());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.update(client));
    verify(client).getState();
    verify(client).lock();
    verify(client).unlock();
    verify(tbLwM2MClientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  @DisplayName("Test sendMsgsAfterSleeping(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.sendMsgsAfterSleeping(LwM2mClient)"})
  void testSendMsgsAfterSleeping() {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any()))
        .thenThrow(new RuntimeException());

    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getPowerMode()).thenReturn(null);
    when(lwM2MClient.getProfileId()).thenReturn(UUID.randomUUID());
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.REGISTERED);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient));
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(lwM2MClient).getPowerMode();
    verify(lwM2MClient).getProfileId();
    verify(lwM2MClient).getState();
  }

  /**
   * Test {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code CREATED}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return {@code CREATED}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test sendMsgsAfterSleeping(LwM2mClient); given 'CREATED'; when LwM2mClient getState() return 'CREATED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.sendMsgsAfterSleeping(LwM2mClient)"})
  void testSendMsgsAfterSleeping_givenCreated_whenLwM2mClientGetStateReturnCreated() {
    // Arrange
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient);

    // Assert
    verify(lwM2MClient).getState();
  }

  /**
   * Test {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code DRX}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPowerMode()} return {@code DRX}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test sendMsgsAfterSleeping(LwM2mClient); given 'DRX'; when LwM2mClient getPowerMode() return 'DRX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.sendMsgsAfterSleeping(LwM2mClient)"})
  void testSendMsgsAfterSleeping_givenDrx_whenLwM2mClientGetPowerModeReturnDrx() {
    // Arrange
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getPowerMode()).thenReturn(PowerMode.DRX);
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.REGISTERED);

    // Act
    lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient);

    // Assert
    verify(lwM2MClient).getPowerMode();
    verify(lwM2MClient).getState();
  }

  /**
   * Test {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  @DisplayName("Test sendMsgsAfterSleeping(LwM2mClient); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.sendMsgsAfterSleeping(LwM2mClient)"})
  void testSendMsgsAfterSleeping_givenRuntimeException() {
    // Arrange
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getPowerMode()).thenThrow(new RuntimeException());
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.REGISTERED);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient));
    verify(lwM2MClient).getPowerMode();
    verify(lwM2MClient).getState();
  }

  /**
   * Test {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  @DisplayName("Test sendMsgsAfterSleeping(LwM2mClient); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.sendMsgsAfterSleeping(LwM2mClient)"})
  void testSendMsgsAfterSleeping_thenCallsGetId() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getPowerMode()).thenReturn(null);
    when(lwM2MClient.getProfileId()).thenReturn(UUID.randomUUID());
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.REGISTERED);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(lwM2MClient).getPowerMode();
    verify(lwM2MClient).getProfileId();
    verify(lwM2MClient).getState();
  }

  /**
   * Test {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MModelConfigService#sendUpdates(LwM2mClient)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  @DisplayName("Test sendMsgsAfterSleeping(LwM2mClient); then calls sendUpdates(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.sendMsgsAfterSleeping(LwM2mClient)"})
  void testSendMsgsAfterSleeping_thenCallsSendUpdates() {
    // Arrange
    doThrow(new RuntimeException())
        .when(lwM2MModelConfigService)
        .sendUpdates(Mockito.<LwM2mClient>any());

    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getPowerMode()).thenReturn(PowerMode.PSM);
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.REGISTERED);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient));
    verify(lwM2MClient).getPowerMode();
    verify(lwM2MClient).getState();
    verify(lwM2MModelConfigService).sendUpdates(isA(LwM2mClient.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#getLwM2mClients()}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getLwM2mClients()}
   */
  @Test
  @DisplayName("Test getLwM2mClients()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection LwM2mClientContextImpl.getLwM2mClients()"})
  void testGetLwM2mClients() {
    // Arrange, Act and Assert
    assertTrue(lwM2mClientContextImpl.getLwM2mClients().isEmpty());
  }

  /**
   * Test {@link LwM2mClientContextImpl#getProfile(UUID)} with {@code profileId}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getProfile(UUID)}
   */
  @Test
  @DisplayName("Test getProfile(UUID) with 'profileId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Lwm2mDeviceProfileTransportConfiguration LwM2mClientContextImpl.getProfile(UUID)"
  })
  void testGetProfileWithProfileId() {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.getProfile(UUID.randomUUID()));
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#getProfile(UUID)} with {@code profileId}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getProfile(UUID)}
   */
  @Test
  @DisplayName("Test getProfile(UUID) with 'profileId'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Lwm2mDeviceProfileTransportConfiguration LwM2mClientContextImpl.getProfile(UUID)"
  })
  void testGetProfileWithProfileId_thenCallsGetId() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.getProfile(UUID.randomUUID()));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#getProfile(UUID)} with {@code profileId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getProfile(UUID)}
   */
  @Test
  @DisplayName("Test getProfile(UUID) with 'profileId'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Lwm2mDeviceProfileTransportConfiguration LwM2mClientContextImpl.getProfile(UUID)"
  })
  void testGetProfileWithProfileId_thenReturnNull() {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(null);

    // Act
    Lwm2mDeviceProfileTransportConfiguration actualProfile =
        lwM2mClientContextImpl.getProfile(UUID.randomUUID());

    // Assert
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    assertNull(actualProfile);
  }

  /**
   * Test {@link LwM2mClientContextImpl#getProfile(Registration)} with {@code registration}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientStore} {@link TbLwM2MClientStore#get(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getProfile(Registration)}
   */
  @Test
  @DisplayName(
      "Test getProfile(Registration) with 'registration'; given TbLwM2MClientStore get(String) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Lwm2mDeviceProfileTransportConfiguration LwM2mClientContextImpl.getProfile(Registration)"
  })
  void testGetProfileWithRegistration_givenTbLwM2MClientStoreGetThrowRuntimeException() {
    // Arrange
    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenThrow(new RuntimeException());

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getProfile(registration));
    verify(registration).getEndpoint();
    verify(tbLwM2MClientStore).get("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link LwM2mClientContextImpl#getProfile(Registration)} with {@code registration}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mTransportContext#getNodeId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getProfile(Registration)}
   */
  @Test
  @DisplayName("Test getProfile(Registration) with 'registration'; then calls getNodeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Lwm2mDeviceProfileTransportConfiguration LwM2mClientContextImpl.getProfile(Registration)"
  })
  void testGetProfileWithRegistration_thenCallsGetNodeId() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");

    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getRegistration()).thenThrow(new RuntimeException());
    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getProfile(registration));
    verify(registration).getEndpoint();
    verify(lwM2mTransportContext).getNodeId();
    verify(lwM2mClient).getRegistration();
    verify(tbLwM2MClientStore).get("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link LwM2mClientContextImpl#profileUpdate(DeviceProfile)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#profileUpdate(DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test profileUpdate(DeviceProfile); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Lwm2mDeviceProfileTransportConfiguration LwM2mClientContextImpl.profileUpdate(DeviceProfile)"
  })
  void testProfileUpdate_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.profileUpdate(deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByDeviceId(UUID)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getClientByDeviceId(UUID)}
   */
  @Test
  @DisplayName("Test getClientByDeviceId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2mClient LwM2mClientContextImpl.getClientByDeviceId(UUID)"})
  void testGetClientByDeviceId() {
    // Arrange, Act and Assert
    assertNull(lwM2mClientContextImpl.getClientByDeviceId(UUID.randomUUID()));
  }

  /**
   * Test {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}
   */
  @Test
  @DisplayName("Test isDownlinkAllowed(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.isDownlinkAllowed(LwM2mClient)"})
  void testIsDownlinkAllowed() {
    // Arrange, Act and Assert
    assertTrue(
        lwM2mClientContextImpl.isDownlinkAllowed(
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Test {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code DRX}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPowerMode()} return {@code DRX}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test isDownlinkAllowed(LwM2mClient); given 'DRX'; when LwM2mClient getPowerMode() return 'DRX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.isDownlinkAllowed(LwM2mClient)"})
  void testIsDownlinkAllowed_givenDrx_whenLwM2mClientGetPowerModeReturnDrx() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPowerMode()).thenReturn(PowerMode.DRX);

    // Act
    boolean actualIsDownlinkAllowedResult = lwM2mClientContextImpl.isDownlinkAllowed(client);

    // Assert
    verify(client).getPowerMode();
    assertTrue(actualIsDownlinkAllowedResult);
  }

  /**
   * Test {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TransportDeviceProfileCache} {@link
   *       TransportDeviceProfileCache#get(DeviceProfileId)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test isDownlinkAllowed(LwM2mClient); given TransportDeviceProfileCache get(DeviceProfileId) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.isDownlinkAllowed(LwM2mClient)"})
  void testIsDownlinkAllowed_givenTransportDeviceProfileCacheGetThrowRuntimeException() {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any()))
        .thenThrow(new RuntimeException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.isDownlinkAllowed(client));
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}
   */
  @Test
  @DisplayName("Test isDownlinkAllowed(LwM2mClient); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.isDownlinkAllowed(LwM2mClient)"})
  void testIsDownlinkAllowed_thenCallsGetId() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.isDownlinkAllowed(client));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getProfileId()} return {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test isDownlinkAllowed(LwM2mClient); when LwM2mClient getProfileId() return 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.isDownlinkAllowed(LwM2mClient)"})
  void testIsDownlinkAllowed_whenLwM2mClientGetProfileIdReturnNull_thenReturnTrue() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);

    // Act
    boolean actualIsDownlinkAllowedResult = lwM2mClientContextImpl.isDownlinkAllowed(client);

    // Assert
    verify(client).getPowerMode();
    verify(client).getProfileId();
    assertTrue(actualIsDownlinkAllowedResult);
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link CompletableFuture#CompletableFuture()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName("Test onUplink(LwM2mClient); given CompletableFuture()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_givenCompletableFuture() {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    when(defaultSchedulerComponent.schedule(
            Mockito.<Callable<Object>>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    when(lwM2mTransportContext.getScheduler()).thenReturn(defaultSchedulerComponent);

    LwM2mClient client = mock(LwM2mClient.class);
    doNothing().when(client).setSleepTask(Mockito.<Future<Void>>any());
    when(client.getSleepTask()).thenReturn(new CompletableFuture<>());
    when(client.getPsmActivityTimer()).thenReturn(1L);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act
    lwM2mClientContextImpl.onUplink(client);

    // Assert
    verify(lwM2mTransportContext).getScheduler();
    verify(defaultSchedulerComponent)
        .schedule(isA(Callable.class), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSleepTask();
    verify(client).lock();
    verify(client).setSleepTask(isNull());
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code DRX}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPowerMode()} return {@code DRX}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test onUplink(LwM2mClient); given 'DRX'; when LwM2mClient getPowerMode() return 'DRX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_givenDrx_whenLwM2mClientGetPowerModeReturnDrx() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.DRX);

    // Act
    lwM2mClientContextImpl.onUplink(client);

    // Assert
    verify(client).getPowerMode();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code PSM}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPowerMode()} return {@code PSM}.
   *   <li>Then calls {@link LwM2mTransportContext#getScheduler()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test onUplink(LwM2mClient); given 'PSM'; when LwM2mClient getPowerMode() return 'PSM'; then calls getScheduler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_givenPsm_whenLwM2mClientGetPowerModeReturnPsm_thenCallsGetScheduler() {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    when(defaultSchedulerComponent.schedule(
            Mockito.<Callable<Object>>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    when(lwM2mTransportContext.getScheduler()).thenReturn(defaultSchedulerComponent);

    LwM2mClient client = mock(LwM2mClient.class);
    doNothing().when(client).setSleepTask(Mockito.<Future<Void>>any());
    when(client.getSleepTask()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act
    lwM2mClientContextImpl.onUplink(client);

    // Assert
    verify(lwM2mTransportContext).getScheduler();
    verify(defaultSchedulerComponent)
        .schedule(isA(Callable.class), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSleepTask();
    verify(client).lock();
    verify(client).setSleepTask(isNull());
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#lock()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test onUplink(LwM2mClient); given RuntimeException(); when LwM2mClient lock() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_givenRuntimeException_whenLwM2mClientLockThrowRuntimeException() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new RuntimeException()).when(client).lock();
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.onUplink(client));
    verify(client).getPowerMode();
    verify(client).lock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TransportDeviceProfileCache} {@link
   *       TransportDeviceProfileCache#get(DeviceProfileId)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test onUplink(LwM2mClient); given TransportDeviceProfileCache get(DeviceProfileId) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_givenTransportDeviceProfileCacheGetThrowRuntimeException() {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any()))
        .thenThrow(new RuntimeException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.onUplink(client));
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultChannelProgressivePromise#cancel(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName("Test onUplink(LwM2mClient); then calls cancel(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_thenCallsCancel() {
    // Arrange
    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise.cancel(anyBoolean())).thenThrow(new RuntimeException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getSleepTask()).thenReturn(defaultChannelProgressivePromise);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.onUplink(client));
    verify(defaultChannelProgressivePromise).cancel(false);
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getSleepTask();
    verify(client).lock();
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName("Test onUplink(LwM2mClient); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_thenCallsGetId() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.onUplink(client));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPagingTransmissionWindow()} return one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test onUplink(LwM2mClient); when LwM2mClient getPagingTransmissionWindow() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_whenLwM2mClientGetPagingTransmissionWindowReturnOne() {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    when(defaultSchedulerComponent.schedule(
            Mockito.<Callable<Object>>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    when(lwM2mTransportContext.getScheduler()).thenReturn(defaultSchedulerComponent);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    doNothing().when(client).setSleepTask(Mockito.<Future<Void>>any());
    when(client.getSleepTask()).thenReturn(null);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act
    lwM2mClientContextImpl.onUplink(client);

    // Assert
    verify(lwM2mTransportContext).getScheduler();
    verify(defaultSchedulerComponent)
        .schedule(isA(Callable.class), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getSleepTask();
    verify(client).lock();
    verify(client).setSleepTask(isNull());
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPagingTransmissionWindow()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test onUplink(LwM2mClient); when LwM2mClient getPagingTransmissionWindow() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_whenLwM2mClientGetPagingTransmissionWindowThrowRuntimeException() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPagingTransmissionWindow()).thenThrow(new RuntimeException());
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
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getProfileId()} return {@code null}.
   *   <li>Then calls {@link LwM2mClient#getProfileId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test onUplink(LwM2mClient); when LwM2mClient getProfileId() return 'null'; then calls getProfileId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_whenLwM2mClientGetProfileIdReturnNull_thenCallsGetProfileId() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.updateLastUplinkTime()).thenReturn(1L);

    // Act
    lwM2mClientContextImpl.onUplink(client);

    // Assert
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getSleepTask()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test onUplink(LwM2mClient); when LwM2mClient getSleepTask() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_whenLwM2mClientGetSleepTaskThrowRuntimeException() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSleepTask()).thenThrow(new RuntimeException());
    when(client.getPsmActivityTimer()).thenReturn(1L);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.onUplink(client));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSleepTask();
    verify(client).lock();
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#setSleepTask(Future)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test onUplink(LwM2mClient); when LwM2mClient setSleepTask(Future) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_whenLwM2mClientSetSleepTaskThrowRuntimeException() {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    when(defaultSchedulerComponent.schedule(
            Mockito.<Callable<Object>>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    when(lwM2mTransportContext.getScheduler()).thenReturn(defaultSchedulerComponent);

    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new RuntimeException()).when(client).setSleepTask(Mockito.<Future<Void>>any());
    when(client.getSleepTask()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.onUplink(client));
    verify(lwM2mTransportContext).getScheduler();
    verify(defaultSchedulerComponent)
        .schedule(isA(Callable.class), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSleepTask();
    verify(client).lock();
    verify(client).setSleepTask(isNull());
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getEdrxCycle()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test getRequestTimeout(LwM2mClient); given 'null'; when LwM2mClient getEdrxCycle() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long LwM2mClientContextImpl.getRequestTimeout(LwM2mClient)"})
  void testGetRequestTimeout_givenNull_whenLwM2mClientGetEdrxCycleReturnNull() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getRequestTimeout(client));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getEdrxCycle();
    verify(client).getPowerMode();
    verify(client).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  @DisplayName("Test getRequestTimeout(LwM2mClient); given one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long LwM2mClientContextImpl.getRequestTimeout(LwM2mClient)"})
  void testGetRequestTimeout_givenOne_thenReturnLongValueIsOne() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act
    Long actualRequestTimeout = lwM2mClientContextImpl.getRequestTimeout(client);

    // Assert
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getPowerMode();
    assertEquals(1L, actualRequestTimeout.longValue());
  }

  /**
   * Test {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  @DisplayName("Test getRequestTimeout(LwM2mClient); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long LwM2mClientContextImpl.getRequestTimeout(LwM2mClient)"})
  void testGetRequestTimeout_givenRuntimeException() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEdrxCycle()).thenThrow(new RuntimeException());
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getRequestTimeout(client));
    verify(client).getEdrxCycle();
    verify(client).getPowerMode();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TransportDeviceProfileCache} {@link
   *       TransportDeviceProfileCache#get(DeviceProfileId)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test getRequestTimeout(LwM2mClient); given TransportDeviceProfileCache get(DeviceProfileId) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long LwM2mClientContextImpl.getRequestTimeout(LwM2mClient)"})
  void testGetRequestTimeout_givenTransportDeviceProfileCacheGetThrowRuntimeException() {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any()))
        .thenThrow(new RuntimeException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getRequestTimeout(client));
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  @DisplayName("Test getRequestTimeout(LwM2mClient); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long LwM2mClientContextImpl.getRequestTimeout(LwM2mClient)"})
  void testGetRequestTimeout_thenCallsGetId() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException());
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getRequestTimeout(client));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client).getProfileId();
  }
}
