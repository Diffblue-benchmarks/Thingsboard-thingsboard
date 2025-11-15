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
package org.thingsboard.server.transport.lwm2m.server.ota;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.node.codec.CodecException;
import org.eclipse.leshan.core.request.ExecuteRequest;
import org.eclipse.leshan.core.request.WriteRequest;
import org.eclipse.leshan.core.response.ExecuteResponse;
import org.eclipse.leshan.core.response.WriteResponse;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.cache.ota.CaffeineOtaPackageCache;
import org.thingsboard.server.cache.ota.OtaPackageDataCache;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.lwm2m.OtherConfiguration;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.ota.OtaPackageUpdateStatus;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
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
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.LwM2mVersionedModelProvider;
import org.thingsboard.server.transport.lwm2m.server.attributes.DefaultLwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContextImpl;
import org.thingsboard.server.transport.lwm2m.server.downlink.DefaultLwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.downlink.DownlinkRequestCallback;
import org.thingsboard.server.transport.lwm2m.server.downlink.LwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MExecuteRequest;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteReplaceRequest;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigServiceImpl;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.FirmwareUpdateResult;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.FirmwareUpdateState;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MClientFwOtaInfo;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MFirmwareUpdateStrategy;
import org.thingsboard.server.transport.lwm2m.server.ota.software.LwM2MClientSwOtaInfo;
import org.thingsboard.server.transport.lwm2m.server.ota.software.LwM2MSoftwareUpdateStrategy;
import org.thingsboard.server.transport.lwm2m.server.ota.software.SoftwareUpdateResult;
import org.thingsboard.server.transport.lwm2m.server.ota.software.SoftwareUpdateState;
import org.thingsboard.server.transport.lwm2m.server.rpc.DefaultLwM2MRpcRequestHandler;
import org.thingsboard.server.transport.lwm2m.server.session.DefaultLwM2MSessionManager;
import org.thingsboard.server.transport.lwm2m.server.store.TbDummyLwM2MClientOtaInfoStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbDummyLwM2MClientStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbInMemoryRegistrationStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbInMemorySecurityStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbL2M2MDtlsSessionInMemoryStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MClientOtaInfoStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2mSecurityStore;
import org.thingsboard.server.transport.lwm2m.server.uplink.DefaultLwM2mUplinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mUplinkMsgHandler;

class DefaultLwM2MOtaUpdateServiceDiffblueTest {
  /**
   * Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.init(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  void testInit2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    clientLwM2mSettings.setSwUpdateStrategy(1);
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService.init(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(clientContext).getProfile((UUID) isNull());
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  void testInit3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateResource()).thenThrow(new CodecException("An error occurred"));
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.init(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(clientLwM2mSettings).getFwUpdateResource();
    verify(clientLwM2mSettings).getFwUpdateStrategy();
    verify(clientLwM2mSettings).getSwUpdateResource();
    verify(clientLwM2mSettings).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(3));
    verify(clientContext).getProfile((UUID) isNull());
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  void testInit4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateResource()).thenThrow(new CodecException("An error occurred"));
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(null);
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.init(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(clientLwM2mSettings).getSwUpdateResource();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(3));
    verify(clientContext).getProfile((UUID) isNull());
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  void testInit5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateResource()).thenThrow(new CodecException("An error occurred"));
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.init(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(clientLwM2mSettings).getFwUpdateResource();
    verify(clientLwM2mSettings).getFwUpdateStrategy();
    verify(clientLwM2mSettings).getSwUpdateResource();
    verify(clientLwM2mSettings).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(3));
    verify(clientContext).getProfile((UUID) isNull());
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  void testInit6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateResource()).thenThrow(new CodecException("An error occurred"));
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(null);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.init(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(clientLwM2mSettings, atLeast(1)).getFwUpdateResource();
    verify(clientLwM2mSettings, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).getSwUpdateResource();
    verify(clientLwM2mSettings).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(3));
    verify(clientContext, atLeast(1)).getProfile((UUID) isNull());
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  void testInit7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(3);
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = mock(
        Lwm2mDeviceProfileTransportConfiguration.class);
    doNothing().when(lwm2mDeviceProfileTransportConfiguration)
        .setClientLwM2mSettings(Mockito.<OtherConfiguration>any());
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService.init(client));
    verify(lwm2mDeviceProfileTransportConfiguration).setClientLwM2mSettings(isA(OtherConfiguration.class));
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(3));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link DefaultLwM2MOtaUpdateService#getExecutorSize()}
   */
  @Test
  void testGetExecutorSize() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);

    // Act and Assert
    assertEquals(0,
        (new DefaultLwM2MOtaUpdateService(transportService, clientContext, new LwM2MTransportServerConfig(),
            mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class),
            mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
            mock(TbLwM2MClientOtaInfoStore.class))).getExecutorSize());
  }

  /**
   * Method under test: {@link DefaultLwM2MOtaUpdateService#getExecutorName()}
   */
  @Test
  void testGetExecutorName() {
    // Arrange
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
    DefaultTransportService transportService = new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider6, tenantRoutingInfoService3,
        applicationEventPublisher3, queueRoutingInfoService3, new TopicService());

    TbQueueTransportApiSettings transportApiSettings3 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings3 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider7 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings3 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage2 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider2 = new InMemoryTbTransportQueueFactory(transportApiSettings3,
        transportNotificationSettings3, serviceInfoProvider7, coreSettings3, storage2, new TopicService());

    TbCoreQueueProducerProvider producerProvider2 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService2 = new TbRuleEngineProducerService(null);
    TopicService topicService3 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory2 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache2 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService2 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache2 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor2 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService2 = new DefaultTransportService(partitionService2, queueProvider2,
        producerProvider2, ruleEngineProducerService2, topicService3, serviceInfoProvider8, statsFactory2,
        deviceProfileCache2, tenantProfileCache2, rateLimitService2, scheduler2, eventPublisher2,
        transportResourceCache2, notificationRuleProcessor2, new DefaultEntityLimitsCache(1, 3));

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TopicService topicService4 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory3 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache3 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache3 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService3 = new DefaultTransportService(null, null, null, null, topicService4,
        serviceInfoProvider9, statsFactory3, deviceProfileCache3, tenantProfileCache3, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context3 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config3 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler uplinkHandler = new DefaultLwM2mUplinkMsgHandler(null, context3, null, null, null,
        config3, logService, null, sessionStore, null, null, null, registrationStore, null,
        new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context4 = new LwM2mTransportContext();
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, transportService3,
        helper, null, config2, uplinkHandler,
        new DefaultLwM2mDownlinkMsgHandler(context4, new LwM2MTransportServerConfig(),
            mock(LwM2MTelemetryLogService.class), null, null),
        mock(LwM2MTelemetryLogService.class), null, mock(LwM2mModelProvider.class));

    TopicService topicService5 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory4 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache4 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache4 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService4 = new DefaultTransportService(null, null, null, null, topicService5,
        serviceInfoProvider10, statsFactory4, deviceProfileCache4, tenantProfileCache4, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportContext context5 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config4 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore2 = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore2 = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler uplinkHandler2 = new DefaultLwM2mUplinkMsgHandler(null, context5, null, null, null,
        config4, logService2, null, sessionStore2, null, null, null, registrationStore2, null,
        new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context6 = new LwM2mTransportContext();
    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(transportService4, null,
        uplinkHandler2,
        new DefaultLwM2mDownlinkMsgHandler(context6, new LwM2MTransportServerConfig(),
            mock(LwM2MTelemetryLogService.class), null, null),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    TopicService topicService6 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory5 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache5 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache5 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService5 = new DefaultTransportService(null, null, null, null, topicService6,
        serviceInfoProvider11, statsFactory5, deviceProfileCache5, tenantProfileCache5, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportContext context7 = new LwM2mTransportContext();
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures2 = new HashMap<>();
    DefaultLwM2MAttributesService attributesService2 = new DefaultLwM2MAttributesService(futures2, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    LwM2MTransportServerConfig config5 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService3 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportServerHelper helper2 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    TbL2M2MDtlsSessionInMemoryStore sessionStore3 = new TbL2M2MDtlsSessionInMemoryStore();
    LwM2mTransportContext context8 = new LwM2mTransportContext();
    DefaultLwM2mDownlinkMsgHandler defaultLwM2MDownlinkMsgHandler = new DefaultLwM2mDownlinkMsgHandler(context8,
        new LwM2MTransportServerConfig(), mock(LwM2MTelemetryLogService.class), null, null);

    LwM2mVersionedModelProvider modelProvider = new LwM2mVersionedModelProvider(null, null,
        new LwM2mTransportContext());

    TbInMemoryRegistrationStore registrationStore3 = new TbInMemoryRegistrationStore();
    TbLwM2mSecurityStore securityStore3 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService2, attributesService,
        rpcHandler,
        new DefaultLwM2mUplinkMsgHandler(transportService5, context7, attributesService2, null, null, config5,
            logService3, helper2, sessionStore3, null, defaultLwM2MDownlinkMsgHandler, modelProvider,
            registrationStore3, securityStore3, new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache6 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext = new LwM2mClientContextImpl(context, config, securityStore2, clientStore,
        sessionManager, deviceProfileCache6, new LwM2MModelConfigServiceImpl());

    LwM2MTransportServerConfig config6 = new LwM2MTransportServerConfig();
    DefaultTbServiceInfoProvider serviceInfoProvider12 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider12, tenantRoutingInfoService4,
        applicationEventPublisher4, queueRoutingInfoService4, new TopicService());

    TbQueueTransportApiSettings transportApiSettings4 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings4 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider13 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings4 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage3 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider3 = new InMemoryTbTransportQueueFactory(transportApiSettings4,
        transportNotificationSettings4, serviceInfoProvider13, coreSettings4, storage3, new TopicService());

    TopicService topicService7 = new TopicService();
    TbQueueCoreSettings coreSettings5 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings2 = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings2 = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider14 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings5 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings5 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings2 = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider3 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService7, coreSettings5, ruleEngineSettings2, vcSettings2, serviceInfoProvider14, transportApiSettings5,
        transportNotificationSettings5, edgeSettings2, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider15 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService3 = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider15, tenantRoutingInfoService5, applicationEventPublisher5,
            queueRoutingInfoService5, new TopicService()));
    TopicService topicService8 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider16 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory6 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache7 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache6 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService3 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler3 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache3 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor3 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService6 = new DefaultTransportService(partitionService3, queueProvider3,
        producerProvider3, ruleEngineProducerService3, topicService8, serviceInfoProvider16, statsFactory6,
        deviceProfileCache7, tenantProfileCache6, rateLimitService3, scheduler3, eventPublisher3,
        transportResourceCache3, notificationRuleProcessor3, new DefaultEntityLimitsCache(1, 3));

    LwM2mTransportContext context9 = new LwM2mTransportContext();
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures3 = new HashMap<>();
    DefaultTbServiceInfoProvider serviceInfoProvider17 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService6 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher6 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService6 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService4 = new HashPartitionService(serviceInfoProvider17, tenantRoutingInfoService6,
        applicationEventPublisher6, queueRoutingInfoService6, new TopicService());

    TbQueueTransportApiSettings transportApiSettings6 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings6 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider18 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings6 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage4 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider4 = new InMemoryTbTransportQueueFactory(transportApiSettings6,
        transportNotificationSettings6, serviceInfoProvider18, coreSettings6, storage4, new TopicService());

    TbCoreQueueProducerProvider producerProvider4 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService4 = new TbRuleEngineProducerService(null);
    TopicService topicService9 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider19 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory7 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache8 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache7 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService4 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler4 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher4 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache4 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor4 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService7 = new DefaultTransportService(partitionService4, queueProvider4,
        producerProvider4, ruleEngineProducerService4, topicService9, serviceInfoProvider19, statsFactory7,
        deviceProfileCache8, tenantProfileCache7, rateLimitService4, scheduler4, eventPublisher4,
        transportResourceCache4, notificationRuleProcessor4, new DefaultEntityLimitsCache(1, 3));

    LwM2mTransportServerHelper helper3 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    LwM2mTransportContext context10 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config7 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore4 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore2 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager2 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache9 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext2 = new LwM2mClientContextImpl(context10, config7, securityStore4, clientStore2,
        sessionManager2, deviceProfileCache9, new LwM2MModelConfigServiceImpl());

    LwM2MTransportServerConfig config8 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context11 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config9 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService4 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context12 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config10 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore3 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache10 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext3 = new LwM2mClientContextImpl(context12, config10, null, clientStore3, null,
        deviceProfileCache10, new LwM2MModelConfigServiceImpl());

    DefaultLwM2MAttributesService attributesService3 = new DefaultLwM2MAttributesService(futures3, transportService7,
        helper3, clientContext2, config8, null,
        new DefaultLwM2mDownlinkMsgHandler(context11, config9, logService4, clientContext3,
            new LwM2mVersionedModelProvider(null, null, new LwM2mTransportContext())),
        mock(LwM2MTelemetryLogService.class), null, mock(LwM2mModelProvider.class));

    DefaultTbServiceInfoProvider serviceInfoProvider20 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService7 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher7 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService7 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService5 = new HashPartitionService(serviceInfoProvider20, tenantRoutingInfoService7,
        applicationEventPublisher7, queueRoutingInfoService7, new TopicService());

    TbQueueTransportApiSettings transportApiSettings7 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings7 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider21 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings7 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage5 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider5 = new InMemoryTbTransportQueueFactory(transportApiSettings7,
        transportNotificationSettings7, serviceInfoProvider21, coreSettings7, storage5, new TopicService());

    TbCoreQueueProducerProvider producerProvider5 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService5 = new TbRuleEngineProducerService(null);
    TopicService topicService10 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider22 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory8 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache11 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache8 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService5 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler5 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher5 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache5 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor5 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService8 = new DefaultTransportService(partitionService5, queueProvider5,
        producerProvider5, ruleEngineProducerService5, topicService10, serviceInfoProvider22, statsFactory8,
        deviceProfileCache11, tenantProfileCache8, rateLimitService5, scheduler5, eventPublisher5,
        transportResourceCache5, notificationRuleProcessor5, new DefaultEntityLimitsCache(1, 3));

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures4 = new HashMap<>();
    TopicService topicService11 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider23 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory9 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache12 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache9 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService9 = new DefaultTransportService(null, null, null, null, topicService11,
        serviceInfoProvider23, statsFactory9, deviceProfileCache12, tenantProfileCache9, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportServerHelper helper4 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    LwM2mTransportContext context13 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config11 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore4 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache13 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext4 = new LwM2mClientContextImpl(context13, config11, null, clientStore4, null,
        deviceProfileCache13, new LwM2MModelConfigServiceImpl());

    LwM2MTransportServerConfig config12 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context14 = new LwM2mTransportContext();
    DefaultLwM2MAttributesService attributesService4 = new DefaultLwM2MAttributesService(futures4, transportService9,
        helper4, clientContext4, config12, null,
        new DefaultLwM2mDownlinkMsgHandler(context14, new LwM2MTransportServerConfig(),
            mock(LwM2MTelemetryLogService.class), null, null),
        mock(LwM2MTelemetryLogService.class), null, mock(LwM2mModelProvider.class));

    TopicService topicService12 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider24 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory10 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache14 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache10 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService10 = new DefaultTransportService(null, null, null, null, topicService12,
        serviceInfoProvider24, statsFactory10, deviceProfileCache14, tenantProfileCache10, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportContext context15 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config13 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore5 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache15 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext5 = new LwM2mClientContextImpl(context15, config13, null, clientStore5, null,
        deviceProfileCache15, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context16 = new LwM2mTransportContext();
    DefaultLwM2MSessionManager sessionManager3 = new DefaultLwM2MSessionManager(transportService8, attributesService4,
        new DefaultLwM2MRpcRequestHandler(transportService10, clientContext5, null,
            new DefaultLwM2mDownlinkMsgHandler(context16, new LwM2MTransportServerConfig(),
                mock(LwM2MTelemetryLogService.class), null, null),
            mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class)),
        null);

    LwM2MTransportServerConfig config14 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService5 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportServerHelper helper5 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    TbL2M2MDtlsSessionInMemoryStore sessionStore4 = new TbL2M2MDtlsSessionInMemoryStore();
    LwM2mTransportContext context17 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config15 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore5 = new TbInMemorySecurityStore();
    LwM2mTransportContext context18 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore6 = new TbLwM2mSecurityStore(securityStore5,
        new LwM2mCredentialsSecurityInfoValidator(context18, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore6 = new TbDummyLwM2MClientStore();
    TopicService topicService13 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider25 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory11 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache16 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache11 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService11 = new DefaultTransportService(null, null, null, null, topicService13,
        serviceInfoProvider25, statsFactory11, deviceProfileCache16, tenantProfileCache11, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures5 = new HashMap<>();
    DefaultLwM2MAttributesService attributesService5 = new DefaultLwM2MAttributesService(futures5, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MSessionManager sessionManager4 = new DefaultLwM2MSessionManager(transportService11, attributesService5,
        new DefaultLwM2MRpcRequestHandler(null, null, null, null, mock(LwM2MTelemetryLogService.class),
            mock(LwM2mModelProvider.class)),
        null);

    DefaultTransportDeviceProfileCache deviceProfileCache17 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext6 = new LwM2mClientContextImpl(context17, config15, securityStore6,
        clientStore6, sessionManager4, deviceProfileCache17, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context19 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config16 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService6 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context20 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config17 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore7 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore7 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager5 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache18 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext7 = new LwM2mClientContextImpl(context20, config17, securityStore7,
        clientStore7, sessionManager5, deviceProfileCache18, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context21 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config18 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore8 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache19 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context21, config18, null, clientStore8,
        null, deviceProfileCache19, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper6 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2mDownlinkMsgHandler defaultLwM2MDownlinkMsgHandler2 = new DefaultLwM2mDownlinkMsgHandler(context19,
        config16, logService6, clientContext7,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper6, new LwM2mTransportContext()));

    LwM2mTransportContext context22 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config19 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore8 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore9 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager6 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache20 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext2 = new LwM2mClientContextImpl(context22, config19, securityStore8,
        clientStore9, sessionManager6, deviceProfileCache20, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper7 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    LwM2mVersionedModelProvider modelProvider2 = new LwM2mVersionedModelProvider(lwM2mClientContext2, helper7,
        new LwM2mTransportContext());

    TbInMemoryRegistrationStore registrationStore4 = new TbInMemoryRegistrationStore();
    TbInMemorySecurityStore securityStore9 = new TbInMemorySecurityStore();
    LwM2mTransportContext context23 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore10 = new TbLwM2mSecurityStore(securityStore9,
        new LwM2mCredentialsSecurityInfoValidator(context23, new LwM2MTransportServerConfig()));

    DefaultLwM2mUplinkMsgHandler uplinkHandler3 = new DefaultLwM2mUplinkMsgHandler(transportService6, context9,
        attributesService3, sessionManager3, null, config14, logService5, helper5, sessionStore4, clientContext6,
        defaultLwM2MDownlinkMsgHandler2, modelProvider2, registrationStore4, securityStore10,
        new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context24 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config20 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService7 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context25 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config21 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore11 = new TbInMemorySecurityStore();
    LwM2mTransportContext context26 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore12 = new TbLwM2mSecurityStore(securityStore11,
        new LwM2mCredentialsSecurityInfoValidator(context26, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore10 = new TbDummyLwM2MClientStore();
    TopicService topicService14 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider26 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory12 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache21 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache12 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService12 = new DefaultTransportService(null, null, null, null, topicService14,
        serviceInfoProvider26, statsFactory12, deviceProfileCache21, tenantProfileCache12, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures6 = new HashMap<>();
    DefaultLwM2MAttributesService attributesService6 = new DefaultLwM2MAttributesService(futures6, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler2 = new DefaultLwM2MRpcRequestHandler(null, null, null, null,
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    LwM2mTransportContext context27 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config22 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService8 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore5 = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore5 = new TbInMemoryRegistrationStore();
    DefaultLwM2MSessionManager sessionManager7 = new DefaultLwM2MSessionManager(transportService12, attributesService6,
        rpcHandler2, new DefaultLwM2mUplinkMsgHandler(null, context27, null, null, null, config22, logService8, null,
            sessionStore5, null, null, null, registrationStore5, null, new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache22 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext8 = new LwM2mClientContextImpl(context25, config21, securityStore12,
        clientStore10, sessionManager7, deviceProfileCache22, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context28 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config23 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore13 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore11 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager8 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache23 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext3 = new LwM2mClientContextImpl(context28, config23, securityStore13,
        clientStore11, sessionManager8, deviceProfileCache23, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper8 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2mDownlinkMsgHandler downlinkHandler = new DefaultLwM2mDownlinkMsgHandler(context24, config20,
        logService7, clientContext8,
        new LwM2mVersionedModelProvider(lwM2mClientContext3, helper8, new LwM2mTransportContext()));

    CaffeineOtaPackageCache otaPackageDataCache = new CaffeineOtaPackageCache(new CaffeineCacheManager());
    LwM2MTelemetryLogService logService9 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportServerHelper helper9 = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    // Act and Assert
    assertEquals("LwM2M OTA",
        (new DefaultLwM2MOtaUpdateService(transportService, clientContext, config6, uplinkHandler3, downlinkHandler,
            otaPackageDataCache, logService9, helper9, new TbDummyLwM2MClientOtaInfoStore())).getExecutorName());
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .forceFirmwareUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doThrow(new CodecException("An error occurred")).when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), helper, otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doThrow(new CodecException("An error occurred")).when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doThrow(new CodecException("An error occurred")).when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), helper, otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .forceFirmwareUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(false);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientFwOtaInfo).isAssigned();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.getResult()).thenReturn(FirmwareUpdateResult.INITIAL);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doThrow(new CodecException("An error occurred")).when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(client);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doThrow(new CodecException("An error occurred")).when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenThrow(new CodecException("An error occurred"));
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService.forceFirmwareUpdate(client));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(client);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(false);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(client);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).isAssigned();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  void testForceFirmwareUpdate14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doThrow(new CodecException("An error occurred")).when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(client);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doThrow(new CodecException("An error occurred")).when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2",
        newFirmwareUrl, newFirmwareTag));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doThrow(new CodecException("An error occurred")).when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), helper, otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(false);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientFwOtaInfo).isAssigned();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.getResult()).thenReturn(FirmwareUpdateResult.INITIAL);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2",
        newFirmwareUrl, newFirmwareTag));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(false);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).isAssigned();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doThrow(new CodecException("An error occurred")).when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetFirmwareUpdate17() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isAssigned()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isAssigned();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentFirmwareNameUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareNameUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name");

    // Assert
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentFirmwareNameUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentFirmwareNameUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name"));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentFirmwareNameUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentName(Mockito.<String>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareNameUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name");

    // Assert
    verify(lwM2MClientFwOtaInfo).setCurrentName(eq("Name"));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentFirmwareNameUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentName(Mockito.<String>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(client, "Name");

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).setCurrentName(eq("Name"));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentSoftwareNameUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareNameUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name");

    // Assert
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentSoftwareNameUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentSoftwareNameUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentSoftwareNameUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentName(Mockito.<String>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareNameUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name");

    // Assert
    verify(lwM2MClientSwOtaInfo).setCurrentName(eq("Name"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentSoftwareNameUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentName(Mockito.<String>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(client, "Name");

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo).setCurrentName(eq("Name"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnFirmwareStrategyUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, new OtherConfiguration()));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnFirmwareStrategyUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(null);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client,
        new OtherConfiguration(1, 1, 1, PowerMode.PSM, 1L, 1L, 1L, "2020-03-01", "2020-03-01", "Default Object IDVer"));

    // Assert
    verify(clientLwM2mSettings).getFwUpdateResource();
    verify(clientLwM2mSettings).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(clientContext).getProfile(isA(UUID.class));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnFirmwareStrategyUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnFirmwareStrategyUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnFirmwareStrategyUpdate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration));
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnFirmwareStrategyUpdate6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnFirmwareStrategyUpdate7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnFirmwareStrategyUpdate8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(false);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).isAssigned();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnFirmwareStrategyUpdate9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.getResult()).thenReturn(FirmwareUpdateResult.INITIAL);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnFirmwareStrategyUpdate10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(null);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnFirmwareStrategyUpdate11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    TransportService transportService = mock(TransportService.class);
    doThrow(new CodecException("An error occurred")).when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnCurrentSoftwareStrategyUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, new OtherConfiguration()));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnCurrentSoftwareStrategyUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(null);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client,
        new OtherConfiguration(1, 1, 1, PowerMode.PSM, 1L, 1L, 1L, "2020-03-01", "2020-03-01", "Default Object IDVer"));

    // Assert
    verify(clientLwM2mSettings).getSwUpdateResource();
    verify(clientLwM2mSettings).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(clientContext).getProfile(isA(UUID.class));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnCurrentSoftwareStrategyUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnCurrentSoftwareStrategyUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnCurrentSoftwareStrategyUpdate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration));
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnCurrentSoftwareStrategyUpdate6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnCurrentSoftwareStrategyUpdate7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnCurrentSoftwareStrategyUpdate8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(false);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).isAssigned();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnCurrentSoftwareStrategyUpdate9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientSwOtaInfo.getResult()).thenReturn(SoftwareUpdateResult.INITIAL);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnCurrentSoftwareStrategyUpdate10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(null);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnCurrentSoftwareStrategyUpdate11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INSTALLED);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  void testOnCurrentSoftwareStrategyUpdate12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    (new Lwm2mDeviceProfileTransportConfiguration()).setClientLwM2mSettings(clientLwM2mSettings);
    TransportService transportService = mock(TransportService.class);
    doThrow(new CodecException("An error occurred")).when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentFirmwareVersion3Update() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareVersion3Update(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentFirmwareVersion3Update2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentFirmwareVersion3Update(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2"));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentFirmwareVersion3Update3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentVersion3(Mockito.<String>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareVersion3Update(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(lwM2MClientFwOtaInfo).setCurrentVersion3(eq("1.0.2"));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentFirmwareVersion3Update4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentVersion3(Mockito.<String>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(client, "1.0.2");

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).setCurrentVersion3(eq("1.0.2"));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentFirmwareVersionUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareVersionUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentFirmwareVersionUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentFirmwareVersionUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2"));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentFirmwareVersionUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentVersion(Mockito.<String>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareVersionUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(lwM2MClientFwOtaInfo).setCurrentVersion(eq("1.0.2"));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentFirmwareVersionUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentVersion(Mockito.<String>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(client, "1.0.2");

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).setCurrentVersion(eq("1.0.2"));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareStateUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareStateUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareStateUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doThrow(new CodecException("An error occurred")).when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentFirmwareStateUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareStateUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareStateUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.DOWNLOADING));
    verify(lwM2MClientFwOtaInfo).setUpdateState(eq(FirmwareUpdateState.DOWNLOADING));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareStateUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 1L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.DOWNLOADING));
    verify(lwM2MClientFwOtaInfo).setUpdateState(eq(FirmwareUpdateState.DOWNLOADING));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareStateUpdate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.DOWNLOADING));
    verify(lwM2MClientFwOtaInfo).setUpdateState(eq(FirmwareUpdateState.DOWNLOADING));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareStateUpdate6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendExecuteRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MExecuteRequest>any(),
            Mockito.<DownlinkRequestCallback<ExecuteRequest, ExecuteResponse>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 2L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendExecuteRequest(isA(LwM2mClient.class), isA(TbLwM2MExecuteRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.DOWNLOADED));
    verify(lwM2MClientFwOtaInfo).setUpdateState(eq(FirmwareUpdateState.DOWNLOADED));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareStateUpdate7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendExecuteRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MExecuteRequest>any(),
            Mockito.<DownlinkRequestCallback<ExecuteRequest, ExecuteResponse>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenThrow(new CodecException("An error occurred"));
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 2L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendExecuteRequest(isA(LwM2mClient.class), isA(TbLwM2MExecuteRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.DOWNLOADED));
    verify(lwM2MClientFwOtaInfo).setUpdateState(eq(FirmwareUpdateState.DOWNLOADED));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareStateUpdate8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 3L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.UPDATING));
    verify(lwM2MClientFwOtaInfo).setUpdateState(eq(FirmwareUpdateState.UPDATING));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareStateUpdate9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getStatus()).thenReturn(OtaPackageUpdateStatus.QUEUED);
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 0L);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).getStatus();
    verify(lwM2MClientFwOtaInfo).setUpdateState(eq(FirmwareUpdateState.IDLE));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareStateUpdate10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetPackageId()).thenReturn("42");
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    when(lwM2MClientFwOtaInfo.getStatus()).thenReturn(OtaPackageUpdateStatus.DOWNLOADING);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 0L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).getStatus();
    verify(lwM2MClientFwOtaInfo).getTargetPackageId();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(eq("42"));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.FAILED));
    verify(lwM2MClientFwOtaInfo).setUpdateState(eq(FirmwareUpdateState.IDLE));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareResultUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doThrow(new CodecException("An error occurred")).when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentFirmwareResultUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).update(Mockito.<FirmwareUpdateResult>any());
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareResultUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.UPDATED));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(lwM2MClientFwOtaInfo).update(eq(FirmwareUpdateResult.UPDATE_SUCCESSFULLY));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doThrow(new CodecException("An error occurred")).when(lwM2MClientFwOtaInfo)
        .update(Mockito.<FirmwareUpdateResult>any());
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentFirmwareResultUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.UPDATED));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(lwM2MClientFwOtaInfo).update(eq(FirmwareUpdateResult.UPDATE_SUCCESSFULLY));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).update(Mockito.<FirmwareUpdateResult>any());
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 1L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.UPDATED));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(lwM2MClientFwOtaInfo).update(eq(FirmwareUpdateResult.UPDATE_SUCCESSFULLY));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.UPDATED));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).update(Mockito.<FirmwareUpdateResult>any());
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 2L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.FAILED));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(lwM2MClientFwOtaInfo).update(eq(FirmwareUpdateResult.NOT_ENOUGH));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.getRetryAttempts()).thenReturn(1);
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 4L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getRetryAttempts();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(2));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.FAILED));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.getRetryAttempts()).thenReturn(1);
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenThrow(new CodecException("An error occurred"));
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 4L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getRetryAttempts();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(2));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.FAILED));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.getRetryAttempts()).thenReturn(1);
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 4L);

    // Assert
    verify(helper, atLeast(1)).sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
        isA(TransportProtos.SessionInfoProto.class), isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getRetryAttempts();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(2));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.FAILED));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.getRetryAttempts()).thenReturn(1);
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 4L);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getRetryAttempts();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(2));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.FAILED));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.getRetryAttempts()).thenReturn(1);
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 4L);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getRetryAttempts();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(2));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.FAILED));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.getRetryAttempts()).thenReturn(1);
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 4L);

    // Assert
    verify(helper, atLeast(1)).sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
        isA(TransportProtos.SessionInfoProto.class), isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getRetryAttempts();
    verify(lwM2MClientFwOtaInfo).isAssigned();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(2));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.FAILED));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.getRetryAttempts()).thenReturn(1);
    when(lwM2MClientFwOtaInfo.getResult()).thenReturn(FirmwareUpdateResult.INITIAL);
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 4L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getRetryAttempts();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(2));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.FAILED));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getRetryAttempts()).thenReturn(10);
    doNothing().when(lwM2MClientFwOtaInfo).update(Mockito.<FirmwareUpdateResult>any());
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 4L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).getRetryAttempts();
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.FAILED));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(lwM2MClientFwOtaInfo).update(eq(FirmwareUpdateResult.CONNECTION_LOST));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getStatus()).thenReturn(OtaPackageUpdateStatus.QUEUED);
    doNothing().when(lwM2MClientFwOtaInfo).update(Mockito.<FirmwareUpdateResult>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 0L);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).getStatus();
    verify(lwM2MClientFwOtaInfo).update(eq(FirmwareUpdateResult.INITIAL));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareResultUpdate17() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    when(lwM2MClientFwOtaInfo.getStatus()).thenReturn(OtaPackageUpdateStatus.UPDATING);
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    doNothing().when(lwM2MClientFwOtaInfo).update(Mockito.<FirmwareUpdateResult>any());
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 0L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).getStatus();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(lwM2MClientFwOtaInfo).setStatus(eq(OtaPackageUpdateStatus.UPDATED));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(lwM2MClientFwOtaInfo).update(eq(FirmwareUpdateResult.INITIAL));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareDeliveryMethodUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareDeliveryMethodUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 42L);

    // Assert
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareDeliveryMethodUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentFirmwareDeliveryMethodUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 42L));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareDeliveryMethodUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setDeliveryMethod(Mockito.<Integer>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareDeliveryMethodUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 42L);

    // Assert
    verify(lwM2MClientFwOtaInfo).setDeliveryMethod(eq(42));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentFirmwareDeliveryMethodUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setDeliveryMethod(Mockito.<Integer>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(client, 42L);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).setDeliveryMethod(eq(42));
    verify(otaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentSoftwareVersion3Update() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareVersion3Update(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentSoftwareVersion3Update2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentSoftwareVersion3Update(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentSoftwareVersion3Update3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentVersion3(Mockito.<String>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareVersion3Update(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(lwM2MClientSwOtaInfo).setCurrentVersion3(eq("1.0.2"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentSoftwareVersion3Update4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentVersion3(Mockito.<String>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(client, "1.0.2");

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo).setCurrentVersion3(eq("1.0.2"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentSoftwareVersionUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareVersionUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentSoftwareVersionUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentSoftwareVersionUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentSoftwareVersionUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentVersion(Mockito.<String>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareVersionUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(lwM2MClientSwOtaInfo).setCurrentVersion(eq("1.0.2"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  void testOnCurrentSoftwareVersionUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentVersion(Mockito.<String>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(client, "1.0.2");

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo).setCurrentVersion(eq("1.0.2"));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareStateUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doThrow(new CodecException("An error occurred")).when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentSoftwareStateUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareStateUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.DOWNLOAD_STARTED));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 1L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.DOWNLOAD_STARTED));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 2L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.DOWNLOADED));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendExecuteRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MExecuteRequest>any(),
            Mockito.<DownlinkRequestCallback<ExecuteRequest, ExecuteResponse>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 3L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendExecuteRequest(isA(LwM2mClient.class), isA(TbLwM2MExecuteRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.DELIVERED));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendExecuteRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MExecuteRequest>any(),
            Mockito.<DownlinkRequestCallback<ExecuteRequest, ExecuteResponse>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenThrow(new CodecException("An error occurred"));
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 3L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendExecuteRequest(isA(LwM2mClient.class), isA(TbLwM2MExecuteRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.DELIVERED));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 4L);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.INSTALLED));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.INITIAL));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doThrow(new CodecException("An error occurred")).when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.INITIAL));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.INITIAL));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.INITIAL));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.INITIAL));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(false);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).isAssigned();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.INITIAL));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientSwOtaInfo.getResult()).thenReturn(SoftwareUpdateResult.INITIAL);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.INITIAL));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendExecuteRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MExecuteRequest>any(),
            Mockito.<DownlinkRequestCallback<ExecuteRequest, ExecuteResponse>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INSTALLED);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendExecuteRequest(isA(LwM2mClient.class), isA(TbLwM2MExecuteRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.INITIAL));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareStateUpdate17() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(null);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setUpdateState(eq(SoftwareUpdateState.INITIAL));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareResultUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareResultUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareResultUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doThrow(new CodecException("An error occurred")).when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentSoftwareResultUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareResultUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).update(Mockito.<SoftwareUpdateResult>any());
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareResultUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(lwM2MClientSwOtaInfo).update(eq(SoftwareUpdateResult.DOWNLOADING));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareResultUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doThrow(new CodecException("An error occurred")).when(lwM2MClientSwOtaInfo)
        .update(Mockito.<SoftwareUpdateResult>any());
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentSoftwareResultUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(lwM2MClientSwOtaInfo).update(eq(SoftwareUpdateResult.DOWNLOADING));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareResultUpdate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).update(Mockito.<SoftwareUpdateResult>any());
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(client, 1L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(lwM2MClientSwOtaInfo).update(eq(SoftwareUpdateResult.DOWNLOADING));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareResultUpdate6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareResultUpdate7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).update(Mockito.<SoftwareUpdateResult>any());
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(client, 2L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(lwM2MClientSwOtaInfo).update(eq(SoftwareUpdateResult.SUCCESSFULLY_INSTALLED));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareResultUpdate8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).update(Mockito.<SoftwareUpdateResult>any());
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(client, 3L);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(lwM2MClientSwOtaInfo).update(eq(SoftwareUpdateResult.SUCCESSFULLY_DOWNLOADED_VERIFIED));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  void testOnCurrentSoftwareResultUpdate9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).update(Mockito.<SoftwareUpdateResult>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(client, 0L);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo).update(eq(SoftwareUpdateResult.INITIAL));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doThrow(new CodecException("An error occurred")).when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2",
        newSoftwareUrl, newSoftwareTag));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doThrow(new CodecException("An error occurred")).when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), helper, otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(false);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientSwOtaInfo).isAssigned();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientSwOtaInfo.getResult()).thenReturn(SoftwareUpdateResult.INITIAL);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    LwM2mDownlinkMsgHandler downlinkHandler = mock(LwM2mDownlinkMsgHandler.class);
    doNothing().when(downlinkHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class), downlinkHandler,
        mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(downlinkHandler).sendWriteReplaceRequest(isA(LwM2mClient.class), isA(TbLwM2MWriteReplaceRequest.class),
        isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2",
        newSoftwareUrl, newSoftwareTag));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(false);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).isAssigned();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INSTALLED);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    TransportService transportService = mock(TransportService.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(LwM2m.Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(clientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate17() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doThrow(new CodecException("An error occurred")).when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        helper, otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)}
   */
  @Test
  void testOnTargetSoftwareUpdate18() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isAssigned()).thenReturn(false);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(false);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo)
        .updateTarget(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    TbLwM2MClientOtaInfoStore otaInfoStore = mock(TbLwM2MClientOtaInfoStore.class);
    doNothing().when(otaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(otaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), otaInfoStore);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isAssigned();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(otaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(otaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#isOtaDownloading(LwM2mClient)}
   */
  @Test
  void testIsOtaDownloading() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), mock(TbLwM2MClientOtaInfoStore.class));

    // Act and Assert
    assertFalse(
        defaultLwM2MOtaUpdateService.isOtaDownloading(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#isOtaDownloading(LwM2mClient)}
   */
  @Test
  void testIsOtaDownloading2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), mock(TbLwM2MClientOtaInfoStore.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    boolean actualIsOtaDownloadingResult = defaultLwM2MOtaUpdateService.isOtaDownloading(client);

    // Assert
    verify(client).getEndpoint();
    assertFalse(actualIsOtaDownloadingResult);
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#startUpdateUsingBinary(LwM2mClient, LwM2MClientFwOtaInfo)}
   */
  @Test
  void testStartUpdateUsingBinary() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), mock(TbLwM2MClientOtaInfoStore.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());

    // Act
    defaultLwM2MOtaUpdateService.startUpdateUsingBinary(client,
        new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getSession();
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#startUpdateUsingBinary(LwM2mClient, LwM2MClientFwOtaInfo)}
   */
  @Test
  void testStartUpdateUsingBinary2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doThrow(new CodecException("An error occurred")).when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), mock(TbLwM2MClientOtaInfoStore.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.startUpdateUsingBinary(client,
            new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getSession();
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#startUpdateUsingBinary(LwM2mClient, LwM2MClientFwOtaInfo)}
   */
  @Test
  void testStartUpdateUsingBinary3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), mock(TbLwM2MClientOtaInfoStore.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MClientFwOtaInfo fwInfo = mock(LwM2MClientFwOtaInfo.class);
    when(fwInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);

    // Act
    defaultLwM2MOtaUpdateService.startUpdateUsingBinary(client, fwInfo);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getSession();
    verify(fwInfo).getType();
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#startUpdateUsingBinary(LwM2mClient, LwM2MClientSwOtaInfo)}
   */
  @Test
  void testStartUpdateUsingBinary4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), mock(TbLwM2MClientOtaInfoStore.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());

    // Act
    defaultLwM2MOtaUpdateService.startUpdateUsingBinary(client, new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getSession();
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#startUpdateUsingBinary(LwM2mClient, LwM2MClientSwOtaInfo)}
   */
  @Test
  void testStartUpdateUsingBinary5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doThrow(new CodecException("An error occurred")).when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), mock(TbLwM2MClientOtaInfoStore.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.startUpdateUsingBinary(client,
            new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY)));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getSession();
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#startUpdateUsingBinary(LwM2mClient, LwM2MClientSwOtaInfo)}
   */
  @Test
  void testStartUpdateUsingBinary6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.GetOtaPackageRequestMsg>any(),
            Mockito.<TransportServiceCallback<TransportProtos.GetOtaPackageResponseMsg>>any());
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService = new DefaultLwM2MOtaUpdateService(transportService,
        clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(OtaPackageDataCache.class), mock(LwM2MTelemetryLogService.class),
        mock(LwM2mTransportServerHelper.class), mock(TbLwM2MClientOtaInfoStore.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MClientSwOtaInfo swInfo = mock(LwM2MClientSwOtaInfo.class);
    when(swInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);

    // Act
    defaultLwM2MOtaUpdateService.startUpdateUsingBinary(client, swInfo);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.GetOtaPackageRequestMsg.class), isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getSession();
    verify(swInfo).getType();
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  void testToOtaPackageUpdateStatus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult = DefaultLwM2MOtaUpdateService
        .toOtaPackageUpdateStatus(SoftwareUpdateResult.INITIAL);

    // Assert
    assertFalse(actualToOtaPackageUpdateStatusResult.isPresent());
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  void testToOtaPackageUpdateStatus2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult = DefaultLwM2MOtaUpdateService
        .toOtaPackageUpdateStatus(SoftwareUpdateResult.DOWNLOADING);

    // Assert
    assertEquals(OtaPackageUpdateStatus.DOWNLOADING, actualToOtaPackageUpdateStatusResult.get());
    assertTrue(actualToOtaPackageUpdateStatusResult.isPresent());
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  void testToOtaPackageUpdateStatus3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult = DefaultLwM2MOtaUpdateService
        .toOtaPackageUpdateStatus(SoftwareUpdateResult.SUCCESSFULLY_INSTALLED);

    // Assert
    assertEquals(OtaPackageUpdateStatus.UPDATED, actualToOtaPackageUpdateStatusResult.get());
    assertTrue(actualToOtaPackageUpdateStatusResult.isPresent());
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  void testToOtaPackageUpdateStatus4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult = DefaultLwM2MOtaUpdateService
        .toOtaPackageUpdateStatus(SoftwareUpdateResult.SUCCESSFULLY_DOWNLOADED_VERIFIED);

    // Assert
    assertEquals(OtaPackageUpdateStatus.VERIFIED, actualToOtaPackageUpdateStatusResult.get());
    assertTrue(actualToOtaPackageUpdateStatusResult.isPresent());
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  void testToOtaPackageUpdateStatus5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult = DefaultLwM2MOtaUpdateService
        .toOtaPackageUpdateStatus(SoftwareUpdateResult.NOT_ENOUGH_STORAGE);

    // Assert
    assertEquals(OtaPackageUpdateStatus.FAILED, actualToOtaPackageUpdateStatusResult.get());
    assertTrue(actualToOtaPackageUpdateStatusResult.isPresent());
  }
}
