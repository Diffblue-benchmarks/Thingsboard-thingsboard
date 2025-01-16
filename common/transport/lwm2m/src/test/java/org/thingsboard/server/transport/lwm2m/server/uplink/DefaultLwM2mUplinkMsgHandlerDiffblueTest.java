package org.thingsboard.server.transport.lwm2m.server.uplink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.eclipse.leshan.core.ResponseCode;
import org.eclipse.leshan.core.model.ObjectModel;
import org.eclipse.leshan.core.node.InvalidLwM2mPathException;
import org.eclipse.leshan.core.node.LwM2mNode;
import org.eclipse.leshan.core.node.LwM2mObjectInstance;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.node.TimestampedLwM2mNodes;
import org.eclipse.leshan.core.node.codec.LwM2mValueConverter;
import org.eclipse.leshan.core.request.CreateRequest;
import org.eclipse.leshan.core.response.AbstractLwM2mResponse;
import org.eclipse.leshan.core.response.CancelCompositeObservationResponse;
import org.eclipse.leshan.core.response.CancelObservationResponse;
import org.eclipse.leshan.core.response.ReadCompositeResponse;
import org.eclipse.leshan.core.response.ReadResponse;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.eclipse.leshan.server.registration.Registration;
import org.eclipse.leshan.server.registration.RegistrationStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.cache.ota.CaffeineOtaPackageCache;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.lwm2m.TelemetryMappingConfiguration;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
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
import org.thingsboard.server.transport.lwm2m.server.attributes.LwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContextImpl;
import org.thingsboard.server.transport.lwm2m.server.downlink.DefaultLwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.downlink.LwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigService;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigServiceImpl;
import org.thingsboard.server.transport.lwm2m.server.ota.DefaultLwM2MOtaUpdateService;
import org.thingsboard.server.transport.lwm2m.server.ota.LwM2MOtaUpdateService;
import org.thingsboard.server.transport.lwm2m.server.rpc.DefaultLwM2MRpcRequestHandler;
import org.thingsboard.server.transport.lwm2m.server.session.DefaultLwM2MSessionManager;
import org.thingsboard.server.transport.lwm2m.server.session.LwM2MSessionManager;
import org.thingsboard.server.transport.lwm2m.server.store.TbDummyLwM2MClientOtaInfoStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbDummyLwM2MClientStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbInMemoryRegistrationStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbInMemorySecurityStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbL2M2MDtlsSessionInMemoryStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MDtlsSessionStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2mSecurityStore;
import org.thingsboard.server.transport.lwm2m.utils.LwM2mValueConverterImpl;

class DefaultLwM2mUplinkMsgHandlerDiffblueTest {
  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#getExecutorSize()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#getExecutorSize()}
   */
  @Test
  @DisplayName("Test getExecutorSize(); then return zero")
  void testGetExecutorSize_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);

    // Act and Assert
    assertEquals(0,
        (new DefaultLwM2mUplinkMsgHandler(transportService, context, attributesService, sessionManager, otaService,
            new LwM2MTransportServerConfig(), mock(LwM2MTelemetryLogService.class),
            mock(LwM2mTransportServerHelper.class), mock(TbLwM2MDtlsSessionStore.class), mock(LwM2mClientContext.class),
            mock(LwM2mDownlinkMsgHandler.class), mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class),
            mock(TbLwM2mSecurityStore.class), mock(LwM2MModelConfigService.class))).getExecutorSize());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onSleepingDev(Registration)}.
   * <ul>
   *   <li>Given {@link LwM2mClientContext}
   * {@link LwM2mClientContext#asleep(LwM2mClient)} return {@code true}.</li>
   *   <li>Then calls {@link Registration#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onSleepingDev(Registration)}
   */
  @Test
  @DisplayName("Test onSleepingDev(Registration); given LwM2mClientContext asleep(LwM2mClient) return 'true'; then calls getEndpoint()")
  void testOnSleepingDev_givenLwM2mClientContextAsleepReturnTrue_thenCallsGetEndpoint() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.asleep(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(clientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(registration.getId()).thenReturn("42");

    // Act
    defaultLwM2mUplinkMsgHandler.onSleepingDev(registration);

    // Assert
    verify(registration, atLeast(1)).getEndpoint();
    verify(registration).getId();
    verify(clientContext).asleep(isA(LwM2mClient.class));
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadResponse(Registration, String, ReadResponse)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadResponse(Registration, String, ReadResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadResponse(Registration, String, ReadResponse)")
  void testOnUpdateValueAfterReadResponse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(clientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    CancelObservationResponse response = mock(CancelObservationResponse.class);
    when(response.getContent()).thenReturn(new LwM2mObjectInstance(new ArrayList<>()));

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadResponse(registration, "Path", response);

    // Assert
    verify(response).getContent();
    verify(registration).getEndpoint();
    verify(clientContext).awake(isA(LwM2mClient.class));
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadResponse(Registration, String, ReadResponse)}.
   * <ul>
   *   <li>Given fromCode one.</li>
   *   <li>Then calls {@link AbstractLwM2mResponse#getCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadResponse(Registration, String, ReadResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadResponse(Registration, String, ReadResponse); given fromCode one; then calls getCode()")
  void testOnUpdateValueAfterReadResponse_givenFromCodeOne_thenCallsGetCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(lwM2mClient.getObjectModel(Mockito.<String>any(), Mockito.<LwM2mModelProvider>any()))
        .thenReturn(new ObjectModel(1, "Name", "The characteristics of someone or something", "1.0.2", true, true,
            new ArrayList<>()));
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(clientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(lwM2mClient);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    CancelObservationResponse response = mock(CancelObservationResponse.class);
    when(response.getCode()).thenReturn(ResponseCode.fromCode(1));
    when(response.getContent()).thenReturn(new LwM2mObjectInstance(new ArrayList<>()));

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadResponse(registration, "Path", response);

    // Assert
    verify(response).getCode();
    verify(response).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClient).getEndpoint();
    verify(lwM2mClient).getObjectModel(eq("Path"), isA(LwM2mModelProvider.class));
    verify(clientContext).awake(isA(LwM2mClient.class));
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadResponse(Registration, String, ReadResponse)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClientContext#update(LwM2mClient)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadResponse(Registration, String, ReadResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadResponse(Registration, String, ReadResponse); then calls update(LwM2mClient)")
  void testOnUpdateValueAfterReadResponse_thenCallsUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(false);
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    when(clientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    CancelObservationResponse response = mock(CancelObservationResponse.class);
    when(response.getContent()).thenReturn(new LwM2mObjectInstance(new ArrayList<>()));

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadResponse(registration, "Path", response);

    // Assert
    verify(response).getContent();
    verify(registration).getEndpoint();
    verify(clientContext).awake(isA(LwM2mClient.class));
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(clientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)")
  void testOnUpdateValueAfterReadCompositeResponse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(clientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    CancelCompositeObservationResponse response = mock(CancelCompositeObservationResponse.class);
    when(response.getContent()).thenReturn(new HashMap<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(registration, response);

    // Assert
    verify(response, atLeast(1)).getContent();
    verify(registration).getEndpoint();
    verify(clientContext).awake(isA(LwM2mClient.class));
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(clientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)")
  void testOnUpdateValueAfterReadCompositeResponse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(false);
    when(clientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    CancelCompositeObservationResponse response = mock(CancelCompositeObservationResponse.class);
    when(response.getContent()).thenReturn(new HashMap<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(registration, response);

    // Assert
    verify(response, atLeast(1)).getContent();
    verify(registration).getEndpoint();
    verify(clientContext).awake(isA(LwM2mClient.class));
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(clientContext, atLeast(1)).update(isA(LwM2mClient.class));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}.
   * <ul>
   *   <li>Given fromCode one.</li>
   *   <li>Then calls {@link AbstractLwM2mResponse#getCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse); given fromCode one; then calls getCode()")
  void testOnUpdateValueAfterReadCompositeResponse_givenFromCodeOne_thenCallsGetCode()
      throws InvalidLwM2mPathException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(clientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(lwM2mClient);
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashMap<LwM2mPath, LwM2mNode> lwM2mPathLwM2mNodeMap = new HashMap<>();
    lwM2mPathLwM2mNodeMap.put(new LwM2mPath(1), mock(LwM2mNode.class));
    CancelCompositeObservationResponse response = mock(CancelCompositeObservationResponse.class);
    when(response.getCode()).thenReturn(ResponseCode.fromCode(1));
    when(response.getContent()).thenReturn(lwM2mPathLwM2mNodeMap);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(registration, response);

    // Assert
    verify(response).getCode();
    verify(response, atLeast(1)).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClient).getEndpoint();
    verify(clientContext).awake(isA(LwM2mClient.class));
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(clientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse); then calls getEndpoint()")
  void testOnUpdateValueAfterReadCompositeResponse_thenCallsGetEndpoint() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(clientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(lwM2mClient);
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    CancelCompositeObservationResponse response = mock(CancelCompositeObservationResponse.class);
    when(response.getContent()).thenReturn(new HashMap<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(registration, response);

    // Assert
    verify(response, atLeast(1)).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClient).getEndpoint();
    verify(clientContext).awake(isA(LwM2mClient.class));
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(clientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onErrorObservation(Registration, String)}.
   * <ul>
   *   <li>Then calls {@link Registration#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onErrorObservation(Registration, String)}
   */
  @Test
  @DisplayName("Test onErrorObservation(Registration, String); then calls getEndpoint()")
  void testOnErrorObservation_thenCallsGetEndpoint() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(), logService,
        mock(LwM2mTransportServerHelper.class), mock(TbLwM2MDtlsSessionStore.class), clientContext,
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class),
        mock(TbLwM2mSecurityStore.class), mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mUplinkMsgHandler.onErrorObservation(registration, "An error occurred");

    // Assert
    verify(registration).getEndpoint();
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(logService).log(isA(LwM2mClient.class), eq("error: An error occurred"));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link TimestampedLwM2mNodes#getNodesAt(Instant)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName("Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes); given HashMap(); then calls getNodesAt(Instant)")
  void testOnUpdateValueWithSendRequest_givenHashMap_thenCallsGetNodesAt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), mock(LwM2mClientContext.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    HashSet<Instant> instantSet = new HashSet<>();
    instantSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getNodesAt(Mockito.<Instant>any())).thenReturn(new HashMap<>());
    when(data.getTimestamps()).thenReturn(instantSet);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(null, data);

    // Assert that nothing has changed
    verify(data).getNodesAt(isA(Instant.class));
    verify(data).getTimestamps();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link TimestampedLwM2mNodes#getTimestamps()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName("Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes); given HashSet(); then calls getTimestamps()")
  void testOnUpdateValueWithSendRequest_givenHashSet_thenCallsGetTimestamps() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), mock(LwM2mClientContext.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getTimestamps()).thenReturn(new HashSet<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(null, data);

    // Assert that nothing has changed
    verify(data).getTimestamps();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto, DeviceProfile)}
   * with {@code sessionInfo}, {@code deviceProfile}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)}
   */
  @Test
  @DisplayName("Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'")
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert that nothing has changed
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto, DeviceProfile)}
   * with {@code sessionInfo}, {@code deviceProfile}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)}
   */
  @Test
  @DisplayName("Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'")
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert that nothing has changed
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto, DeviceProfile)}
   * with {@code sessionInfo}, {@code deviceProfile}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)}
   */
  @Test
  @DisplayName("Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'; given ArrayList() add 'null'")
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile_givenArrayListAddNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(null);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert that nothing has changed
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto, DeviceProfile)}
   * with {@code sessionInfo}, {@code deviceProfile}.
   * <ul>
   *   <li>Then calls {@link LwM2mClientContext#getLwM2mClients()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)}
   */
  @Test
  @DisplayName("Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'; then calls getLwM2mClients()")
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile_thenCallsGetLwM2mClients() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(new ArrayList<>());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert that nothing has changed
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto, DeviceProfile)}
   * with {@code sessionInfo}, {@code deviceProfile}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getProfileId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)}
   */
  @Test
  @DisplayName("Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'; then calls getProfileId()")
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile_thenCallsGetProfileId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getProfileId()).thenReturn(UUID.randomUUID());

    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(lwM2mClient);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert that nothing has changed
    verify(lwM2mClient, atLeast(1)).getProfileId();
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(SessionInfoProto, Device, Optional)}
   * with {@code sessionInfo}, {@code device}, {@code newDeviceProfileOpt}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)}
   */
  @Test
  @DisplayName("Test onDeviceUpdate(SessionInfoProto, Device, Optional) with 'sessionInfo', 'device', 'newDeviceProfileOpt'")
  void testOnDeviceUpdateWithSessionInfoDeviceNewDeviceProfileOpt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getClientByDeviceId(Mockito.<UUID>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();
    Device device = new Device();
    Optional<DeviceProfile> newDeviceProfileOpt = Optional.of(new DeviceProfile());

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceUpdate(sessionInfo, device, newDeviceProfileOpt);

    // Assert
    verify(clientContext).getClientByDeviceId(isNull());
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(SessionInfoProto, Device, Optional)}
   * with {@code sessionInfo}, {@code device}, {@code newDeviceProfileOpt}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)}
   */
  @Test
  @DisplayName("Test onDeviceUpdate(SessionInfoProto, Device, Optional) with 'sessionInfo', 'device', 'newDeviceProfileOpt'")
  void testOnDeviceUpdateWithSessionInfoDeviceNewDeviceProfileOpt2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getClientByDeviceId(Mockito.<UUID>any())).thenReturn(null);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();
    Device device = new Device();
    Optional<DeviceProfile> newDeviceProfileOpt = Optional.of(new DeviceProfile());

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceUpdate(sessionInfo, device, newDeviceProfileOpt);

    // Assert
    verify(clientContext).getClientByDeviceId(isNull());
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceUpdate(ResourceUpdateMsg)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceUpdate(TransportProtos.ResourceUpdateMsg)}
   */
  @Test
  @DisplayName("Test onResourceUpdate(ResourceUpdateMsg)")
  void testOnResourceUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    LwM2mVersionedModelProvider modelProvider = mock(LwM2mVersionedModelProvider.class);
    doNothing().when(modelProvider).evict(Mockito.<TenantId>any(), Mockito.<String>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class), modelProvider,
        mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class), mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceUpdate(TransportProtos.ResourceUpdateMsg.getDefaultInstance());

    // Assert
    verify(modelProvider).evict(isA(TenantId.class), eq(""));
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceUpdate(ResourceUpdateMsg)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceUpdate(TransportProtos.ResourceUpdateMsg)}
   */
  @Test
  @DisplayName("Test onResourceUpdate(ResourceUpdateMsg)")
  void testOnResourceUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    LwM2mVersionedModelProvider modelProvider = mock(LwM2mVersionedModelProvider.class);
    doNothing().when(modelProvider).evict(Mockito.<TenantId>any(), Mockito.<String>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class), modelProvider,
        mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class), mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceUpdate(TransportProtos.ResourceUpdateMsg.getDefaultInstance());

    // Assert
    verify(modelProvider).evict(isA(TenantId.class), eq(""));
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceUpdate(ResourceUpdateMsg)}.
   * <ul>
   *   <li>Then calls
   * {@link LwM2mClient#updateResourceModel(String, LwM2mModelProvider)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceUpdate(TransportProtos.ResourceUpdateMsg)}
   */
  @Test
  @DisplayName("Test onResourceUpdate(ResourceUpdateMsg); then calls updateResourceModel(String, LwM2mModelProvider)")
  void testOnResourceUpdate_thenCallsUpdateResourceModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doNothing().when(lwM2mClient).updateResourceModel(Mockito.<String>any(), Mockito.<LwM2mModelProvider>any());

    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(lwM2mClient);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    LwM2mVersionedModelProvider modelProvider = mock(LwM2mVersionedModelProvider.class);
    doNothing().when(modelProvider).evict(Mockito.<TenantId>any(), Mockito.<String>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class), modelProvider,
        mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class), mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceUpdate(TransportProtos.ResourceUpdateMsg.getDefaultInstance());

    // Assert
    verify(modelProvider).evict(isA(TenantId.class), eq(""));
    verify(lwM2mClient).updateResourceModel(eq(""), isA(LwM2mModelProvider.class));
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceUpdate(ResourceUpdateMsg)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls
   * {@link LwM2mVersionedModelProvider#evict(TenantId, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceUpdate(TransportProtos.ResourceUpdateMsg)}
   */
  @Test
  @DisplayName("Test onResourceUpdate(ResourceUpdateMsg); when DefaultInstance; then calls evict(TenantId, String)")
  void testOnResourceUpdate_whenDefaultInstance_thenCallsEvict() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(new ArrayList<>());
    LwM2mVersionedModelProvider modelProvider = mock(LwM2mVersionedModelProvider.class);
    doNothing().when(modelProvider).evict(Mockito.<TenantId>any(), Mockito.<String>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class), modelProvider,
        mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class), mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceUpdate(TransportProtos.ResourceUpdateMsg.getDefaultInstance());

    // Assert
    verify(modelProvider).evict(isA(TenantId.class), eq(""));
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceDelete(ResourceDeleteMsg)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceDelete(TransportProtos.ResourceDeleteMsg)}
   */
  @Test
  @DisplayName("Test onResourceDelete(ResourceDeleteMsg)")
  void testOnResourceDelete() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    LwM2mVersionedModelProvider modelProvider = mock(LwM2mVersionedModelProvider.class);
    doNothing().when(modelProvider).evict(Mockito.<TenantId>any(), Mockito.<String>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class), modelProvider,
        mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class), mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceDelete(TransportProtos.ResourceDeleteMsg.getDefaultInstance());

    // Assert
    verify(modelProvider).evict(isA(TenantId.class), eq(""));
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceDelete(ResourceDeleteMsg)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceDelete(TransportProtos.ResourceDeleteMsg)}
   */
  @Test
  @DisplayName("Test onResourceDelete(ResourceDeleteMsg)")
  void testOnResourceDelete2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    LwM2mVersionedModelProvider modelProvider = mock(LwM2mVersionedModelProvider.class);
    doNothing().when(modelProvider).evict(Mockito.<TenantId>any(), Mockito.<String>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class), modelProvider,
        mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class), mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceDelete(TransportProtos.ResourceDeleteMsg.getDefaultInstance());

    // Assert
    verify(modelProvider).evict(isA(TenantId.class), eq(""));
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceDelete(ResourceDeleteMsg)}.
   * <ul>
   *   <li>Then calls
   * {@link LwM2mClient#deleteResources(String, LwM2mModelProvider)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceDelete(TransportProtos.ResourceDeleteMsg)}
   */
  @Test
  @DisplayName("Test onResourceDelete(ResourceDeleteMsg); then calls deleteResources(String, LwM2mModelProvider)")
  void testOnResourceDelete_thenCallsDeleteResources() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doNothing().when(lwM2mClient).deleteResources(Mockito.<String>any(), Mockito.<LwM2mModelProvider>any());

    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(lwM2mClient);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    LwM2mVersionedModelProvider modelProvider = mock(LwM2mVersionedModelProvider.class);
    doNothing().when(modelProvider).evict(Mockito.<TenantId>any(), Mockito.<String>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class), modelProvider,
        mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class), mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceDelete(TransportProtos.ResourceDeleteMsg.getDefaultInstance());

    // Assert
    verify(modelProvider).evict(isA(TenantId.class), eq(""));
    verify(lwM2mClient).deleteResources(eq(""), isA(LwM2mModelProvider.class));
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceDelete(ResourceDeleteMsg)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls
   * {@link LwM2mVersionedModelProvider#evict(TenantId, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onResourceDelete(TransportProtos.ResourceDeleteMsg)}
   */
  @Test
  @DisplayName("Test onResourceDelete(ResourceDeleteMsg); when DefaultInstance; then calls evict(TenantId, String)")
  void testOnResourceDelete_whenDefaultInstance_thenCallsEvict() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(new ArrayList<>());
    LwM2mVersionedModelProvider modelProvider = mock(LwM2mVersionedModelProvider.class);
    doNothing().when(modelProvider).evict(Mockito.<TenantId>any(), Mockito.<String>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class), modelProvider,
        mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class), mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceDelete(TransportProtos.ResourceDeleteMsg.getDefaultInstance());

    // Assert
    verify(modelProvider).evict(isA(TenantId.class), eq(""));
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onAwakeDev(Registration)}.
   * <ul>
   *   <li>Given {@link LwM2mClientContext}
   * {@link LwM2mClientContext#awake(LwM2mClient)} return {@code true}.</li>
   *   <li>Then calls {@link Registration#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onAwakeDev(Registration)}
   */
  @Test
  @DisplayName("Test onAwakeDev(Registration); given LwM2mClientContext awake(LwM2mClient) return 'true'; then calls getEndpoint()")
  void testOnAwakeDev_givenLwM2mClientContextAwakeReturnTrue_thenCallsGetEndpoint() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(clientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(registration.getId()).thenReturn("42");

    // Act
    defaultLwM2mUplinkMsgHandler.onAwakeDev(registration);

    // Assert
    verify(registration, atLeast(1)).getEndpoint();
    verify(registration).getId();
    verify(clientContext).awake(isA(LwM2mClient.class));
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant)")
  void testUpdateAttrTelemetry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(new TelemetryMappingConfiguration());
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<Registration>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(clientContext).getProfile((Registration) isNull());
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant)")
  void testUpdateAttrTelemetry2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    lwm2mDeviceProfileTransportConfiguration
        .setObserveAttr(new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>()));
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<Registration>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(clientContext).getProfile((Registration) isNull());
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant)")
  void testUpdateAttrTelemetry3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(registration, "", null);

    // Assert
    verify(registration).getEndpoint();
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} addAll
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@code Path}.</li>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(Registration)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given HashSet() addAll ArrayList(); when 'Path'; then calls getProfile(Registration)")
  void testUpdateAttrTelemetry_givenHashSetAddAllArrayList_whenPath_thenCallsGetProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashSet<String> attribute = new HashSet<>();
    attribute.add("");
    attribute.addAll(new ArrayList<>());
    attribute.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<Registration>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(clientContext).getProfile((Registration) isNull());
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add empty string.</li>
   *   <li>When {@code Path}.</li>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(Registration)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given HashSet() add empty string; when 'Path'; then calls getProfile(Registration)")
  void testUpdateAttrTelemetry_givenHashSetAddEmptyString_whenPath_thenCallsGetProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashSet<String> attribute = new HashSet<>();
    attribute.add("UpdateAttrTelemetry paths [{}]");

    HashSet<String> telemetry = new HashSet<>();
    telemetry.add("");
    telemetry.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<Registration>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(clientContext).getProfile((Registration) isNull());
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code Path}.</li>
   *   <li>When {@code Path}.</li>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(Registration)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given HashSet() add 'Path'; when 'Path'; then calls getProfile(Registration)")
  void testUpdateAttrTelemetry_givenHashSetAddPath_whenPath_thenCallsGetProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashSet<String> attribute = new HashSet<>();
    attribute.add("Path");
    attribute.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<Registration>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(clientContext).getProfile((Registration) isNull());
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code UpdateAttrTelemetry paths
   * [{}]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given HashSet() add 'UpdateAttrTelemetry paths [{}]'")
  void testUpdateAttrTelemetry_givenHashSetAddUpdateAttrTelemetryPaths() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashSet<String> attribute = new HashSet<>();
    attribute.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<Registration>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(clientContext).getProfile((Registration) isNull());
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code UpdateAttrTelemetry paths
   * [{}]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given HashSet() add 'UpdateAttrTelemetry paths [{}]'")
  void testUpdateAttrTelemetry_givenHashSetAddUpdateAttrTelemetryPaths2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashSet<String> telemetry = new HashSet<>();
    telemetry.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<Registration>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(clientContext).getProfile((Registration) isNull());
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code UpdateAttrTelemetry}.</li>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(Registration)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given HashSet() add 'UpdateAttrTelemetry'; then calls getProfile(Registration)")
  void testUpdateAttrTelemetry_givenHashSetAddUpdateAttrTelemetry_thenCallsGetProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashSet<String> telemetry = new HashSet<>();
    telemetry.add("UpdateAttrTelemetry");
    telemetry.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<Registration>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(clientContext).getProfile((Registration) isNull());
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link LwM2mClientContext}
   * {@link LwM2mClientContext#getClientByEndpoint(String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given LwM2mClientContext getClientByEndpoint(String) return 'null'")
  void testUpdateAttrTelemetry_givenLwM2mClientContextGetClientByEndpointReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(null);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(registration, "", null);

    // Assert
    verify(registration).getEndpoint();
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given
   * {@link TelemetryMappingConfiguration#TelemetryMappingConfiguration()}
   * Attribute is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given TelemetryMappingConfiguration() Attribute is HashSet()")
  void testUpdateAttrTelemetry_givenTelemetryMappingConfigurationAttributeIsHashSet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration();
    observeAttr.setAttribute(new HashSet<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<Registration>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(clientContext).getProfile((Registration) isNull());
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(Registration)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); then calls getProfile(Registration)")
  void testUpdateAttrTelemetry_thenCallsGetProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(new Lwm2mDeviceProfileTransportConfiguration());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(clientContext).getProfile((Registration) isNull());
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String, CreateRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String, CreateRequest)}
   */
  @Test
  @DisplayName("Test onCreateResponseOk(LwM2mClient, String, CreateRequest)")
  void testOnCreateResponseOk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    LwM2mObjectInstance lwM2mObjectInstance = new LwM2mObjectInstance(new ArrayList<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onCreateResponseOk(client, "Path",
        new CreateRequest(1, lwM2mObjectInstance, new LwM2mObjectInstance(new ArrayList<>())));

    // Assert
    verify(clientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String, CreateRequest)}.
   * <ul>
   *   <li>When {@link LwM2mObjectInstance#LwM2mObjectInstance(Collection)} with
   * resources is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String, CreateRequest)}
   */
  @Test
  @DisplayName("Test onCreateResponseOk(LwM2mClient, String, CreateRequest); when LwM2mObjectInstance(Collection) with resources is ArrayList()")
  void testOnCreateResponseOk_whenLwM2mObjectInstanceWithResourcesIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    doNothing().when(clientContext).update(Mockito.<LwM2mClient>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mUplinkMsgHandler.onCreateResponseOk(client, "Path",
        new CreateRequest(1, new LwM2mObjectInstance(new ArrayList<>())));

    // Assert
    verify(clientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#getSessionInfoOrCloseSession(Registration)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#getSessionInfoOrCloseSession(Registration)}
   */
  @Test
  @DisplayName("Test getSessionInfoOrCloseSession(Registration)")
  void testGetSessionInfoOrCloseSession() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    TransportProtos.SessionInfoProto actualSessionInfoOrCloseSession = defaultLwM2mUplinkMsgHandler
        .getSessionInfoOrCloseSession(registration);

    // Assert
    verify(registration).getEndpoint();
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    assertNull(actualSessionInfoOrCloseSession);
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#getSessionInfoOrCloseSession(Registration)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#getSessionInfoOrCloseSession(Registration)}
   */
  @Test
  @DisplayName("Test getSessionInfoOrCloseSession(Registration)")
  void testGetSessionInfoOrCloseSession2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(null);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    TransportProtos.SessionInfoProto actualSessionInfoOrCloseSession = defaultLwM2mUplinkMsgHandler
        .getSessionInfoOrCloseSession(registration);

    // Assert
    verify(registration).getEndpoint();
    verify(clientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    assertNull(actualSessionInfoOrCloseSession);
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>Then calls {@link LwM2mClient#getProfileId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}
   */
  @Test
  @DisplayName("Test initAttributes(LwM2mClient, boolean); given randomUUID; then calls getProfileId()")
  void testInitAttributes_givenRandomUUID_thenCallsGetProfileId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    SettableFuture<List<TransportProtos.TsKvProto>> delegate = SettableFuture.create();
    when(attributesService.getSharedAttributes(Mockito.<LwM2mClient>any(), Mockito.<Collection<String>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));

    HashMap<String, String> keyName = new HashMap<>();
    keyName.put("foo", "foo");
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getProfileId()).thenReturn(UUID.randomUUID());

    // Act
    defaultLwM2mUplinkMsgHandler.initAttributes(lwM2MClient, true);

    // Assert
    verify(attributesService).getSharedAttributes(isA(LwM2mClient.class), isA(Collection.class));
    verify(lwM2MClient).getProfileId();
    verify(clientContext).getProfile(isA(UUID.class));
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}
   */
  @Test
  @DisplayName("Test initAttributes(LwM2mClient, boolean); then calls getProfile(UUID)")
  void testInitAttributes_thenCallsGetProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    lwm2mDeviceProfileTransportConfiguration
        .setObserveAttr(new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>()));
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.initAttributes(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), true);

    // Assert
    verify(clientContext).getProfile((UUID) isNull());
  }

  /**
   * Test
   * {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}.
   * <ul>
   *   <li>Then calls
   * {@link LwM2MAttributesService#getSharedAttributes(LwM2mClient, Collection)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}
   */
  @Test
  @DisplayName("Test initAttributes(LwM2mClient, boolean); then calls getSharedAttributes(LwM2mClient, Collection)")
  void testInitAttributes_thenCallsGetSharedAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    SettableFuture<List<TransportProtos.TsKvProto>> delegate = SettableFuture.create();
    when(attributesService.getSharedAttributes(Mockito.<LwM2mClient>any(), Mockito.<Collection<String>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));

    HashMap<String, String> keyName = new HashMap<>();
    keyName.put("foo", "foo");
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    // Act
    defaultLwM2mUplinkMsgHandler.initAttributes(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), true);

    // Assert
    verify(attributesService).getSharedAttributes(isA(LwM2mClient.class), isA(Collection.class));
    verify(clientContext).getProfile((UUID) isNull());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultLwM2mUplinkMsgHandler#getClientContext()}
   *   <li>{@link DefaultLwM2mUplinkMsgHandler#getConfig()}
   *   <li>{@link DefaultLwM2mUplinkMsgHandler#getConverter()}
   *   <li>{@link DefaultLwM2mUplinkMsgHandler#getExecutorName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
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
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
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

    TopicService topicService3 = new TopicService();
    TbQueueCoreSettings coreSettings4 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings2 = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings2 = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings4 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings4 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings2 = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider2 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService3, coreSettings4, ruleEngineSettings2, vcSettings2, serviceInfoProvider8, transportApiSettings4,
        transportNotificationSettings4, edgeSettings2, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService2 = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider9, tenantRoutingInfoService4, applicationEventPublisher4,
            queueRoutingInfoService4, new TopicService()));
    TopicService topicService4 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
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
        producerProvider2, ruleEngineProducerService2, topicService4, serviceInfoProvider10, statsFactory2,
        deviceProfileCache2, tenantProfileCache2, rateLimitService2, scheduler2, eventPublisher2,
        transportResourceCache2, notificationRuleProcessor2, new DefaultEntityLimitsCache(1, 3));

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context3 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context3, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    TopicService topicService5 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory3 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache3 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache3 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService3 = new DefaultTransportService(null, null, null, null, topicService5,
        serviceInfoProvider11, statsFactory3, deviceProfileCache3, tenantProfileCache3, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService3, null,
        new DefaultLwM2MRpcRequestHandler(null, null, null, null, mock(LwM2MTelemetryLogService.class),
            mock(LwM2mModelProvider.class)),
        null);

    DefaultTransportDeviceProfileCache deviceProfileCache4 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext = new LwM2mClientContextImpl(context2, config, securityStore2, clientStore,
        sessionManager, deviceProfileCache4, new LwM2MModelConfigServiceImpl());

    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context4 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config3 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context5 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config4 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore3 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore2 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager2 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache5 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext2 = new LwM2mClientContextImpl(context5, config4, securityStore3, clientStore2,
        sessionManager2, deviceProfileCache5, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context6 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config5 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore3 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache6 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context6, config5, null, clientStore3, null,
        deviceProfileCache6, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper2 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2mDownlinkMsgHandler downlinkHandler = new DefaultLwM2mDownlinkMsgHandler(context4, config3, logService,
        clientContext2, new LwM2mVersionedModelProvider(lwM2mClientContext, helper2, new LwM2mTransportContext()));

    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    DefaultTbServiceInfoProvider serviceInfoProvider12 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider12, tenantRoutingInfoService5,
        applicationEventPublisher5, queueRoutingInfoService5, new TopicService());

    TbQueueTransportApiSettings transportApiSettings5 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings5 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider13 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings5 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage3 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider3 = new InMemoryTbTransportQueueFactory(transportApiSettings5,
        transportNotificationSettings5, serviceInfoProvider13, coreSettings5, storage3, new TopicService());

    TbCoreQueueProducerProvider producerProvider3 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService3 = new TbRuleEngineProducerService(null);
    TopicService topicService6 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider14 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory4 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache7 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache4 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService3 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler3 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache3 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor3 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService4 = new DefaultTransportService(partitionService3, queueProvider3,
        producerProvider3, ruleEngineProducerService3, topicService6, serviceInfoProvider14, statsFactory4,
        deviceProfileCache7, tenantProfileCache4, rateLimitService3, scheduler3, eventPublisher3,
        transportResourceCache3, notificationRuleProcessor3, new DefaultEntityLimitsCache(1, 3));

    LwM2mTransportContext context7 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config6 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore4 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore4 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager3 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache8 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext3 = new LwM2mClientContextImpl(context7, config6, securityStore4, clientStore4,
        sessionManager3, deviceProfileCache8, new LwM2MModelConfigServiceImpl());

    LwM2MTransportServerConfig config7 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context8 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config8 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService3 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context9 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config9 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore5 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache9 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext4 = new LwM2mClientContextImpl(context9, config9, null, clientStore5, null,
        deviceProfileCache9, new LwM2MModelConfigServiceImpl());

    DefaultLwM2mDownlinkMsgHandler downlinkHandler2 = new DefaultLwM2mDownlinkMsgHandler(context8, config8, logService3,
        clientContext4, new LwM2mVersionedModelProvider(null, null, new LwM2mTransportContext()));

    CaffeineOtaPackageCache otaPackageDataCache = new CaffeineOtaPackageCache(new CaffeineCacheManager());
    LwM2MTelemetryLogService logService4 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportServerHelper helper3 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, transportService2,
        helper, clientContext, config2, null, downlinkHandler, logService2,
        new DefaultLwM2MOtaUpdateService(transportService4, clientContext3, config7, null, downlinkHandler2,
            otaPackageDataCache, logService4, helper3, new TbDummyLwM2MClientOtaInfoStore()),
        mock(LwM2mModelProvider.class));

    DefaultTbServiceInfoProvider serviceInfoProvider15 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService6 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher6 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService6 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService4 = new HashPartitionService(serviceInfoProvider15, tenantRoutingInfoService6,
        applicationEventPublisher6, queueRoutingInfoService6, new TopicService());

    TbQueueTransportApiSettings transportApiSettings6 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings6 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider16 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings6 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage4 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider4 = new InMemoryTbTransportQueueFactory(transportApiSettings6,
        transportNotificationSettings6, serviceInfoProvider16, coreSettings6, storage4, new TopicService());

    TopicService topicService7 = new TopicService();
    TbQueueCoreSettings coreSettings7 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings3 = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings3 = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider17 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings7 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings7 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings3 = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider4 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService7, coreSettings7, ruleEngineSettings3, vcSettings3, serviceInfoProvider17, transportApiSettings7,
        transportNotificationSettings7, edgeSettings3, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider18 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService7 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher7 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService7 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService4 = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider18, tenantRoutingInfoService7, applicationEventPublisher7,
            queueRoutingInfoService7, new TopicService()));
    TopicService topicService8 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider19 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory5 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache10 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache5 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService4 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler4 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher4 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache4 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor4 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService5 = new DefaultTransportService(partitionService4, queueProvider4,
        producerProvider4, ruleEngineProducerService4, topicService8, serviceInfoProvider19, statsFactory5,
        deviceProfileCache10, tenantProfileCache5, rateLimitService4, scheduler4, eventPublisher4,
        transportResourceCache4, notificationRuleProcessor4, new DefaultEntityLimitsCache(1, 3));

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures2 = new HashMap<>();
    DefaultTbServiceInfoProvider serviceInfoProvider20 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService8 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher8 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService8 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService5 = new HashPartitionService(serviceInfoProvider20, tenantRoutingInfoService8,
        applicationEventPublisher8, queueRoutingInfoService8, new TopicService());

    TbQueueTransportApiSettings transportApiSettings8 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings8 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider21 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings8 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage5 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider5 = new InMemoryTbTransportQueueFactory(transportApiSettings8,
        transportNotificationSettings8, serviceInfoProvider21, coreSettings8, storage5, new TopicService());

    TbCoreQueueProducerProvider producerProvider5 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService5 = new TbRuleEngineProducerService(null);
    TopicService topicService9 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider22 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory6 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache11 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache6 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService5 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler5 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher5 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache5 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor5 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService6 = new DefaultTransportService(partitionService5, queueProvider5,
        producerProvider5, ruleEngineProducerService5, topicService9, serviceInfoProvider22, statsFactory6,
        deviceProfileCache11, tenantProfileCache6, rateLimitService5, scheduler5, eventPublisher5,
        transportResourceCache5, notificationRuleProcessor5, new DefaultEntityLimitsCache(1, 3));

    LwM2mTransportServerHelper helper4 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    LwM2mTransportContext context10 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config10 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore5 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore6 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache12 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext5 = new LwM2mClientContextImpl(context10, config10, securityStore5,
        clientStore6, null, deviceProfileCache12, new LwM2MModelConfigServiceImpl());

    LwM2MTransportServerConfig config11 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context11 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config12 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService5 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context12 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config13 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore7 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache13 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext6 = new LwM2mClientContextImpl(context12, config13, null, clientStore7, null,
        deviceProfileCache13, new LwM2MModelConfigServiceImpl());

    DefaultLwM2mDownlinkMsgHandler downlinkHandler3 = new DefaultLwM2mDownlinkMsgHandler(context11, config12,
        logService5, clientContext6, new LwM2mVersionedModelProvider(null, null, new LwM2mTransportContext()));

    LwM2MTelemetryLogService logService6 = mock(LwM2MTelemetryLogService.class);
    TopicService topicService10 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider23 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory7 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache14 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache7 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService7 = new DefaultTransportService(null, null, null, null, topicService10,
        serviceInfoProvider23, statsFactory7, deviceProfileCache14, tenantProfileCache7, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportContext context13 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config14 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore8 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache15 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext7 = new LwM2mClientContextImpl(context13, config14, null, clientStore8, null,
        deviceProfileCache15, new LwM2MModelConfigServiceImpl());

    LwM2MTransportServerConfig config15 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context14 = new LwM2mTransportContext();
    DefaultLwM2mDownlinkMsgHandler downlinkHandler4 = new DefaultLwM2mDownlinkMsgHandler(context14,
        new LwM2MTransportServerConfig(), mock(LwM2MTelemetryLogService.class), null, null);

    CaffeineOtaPackageCache otaPackageDataCache2 = new CaffeineOtaPackageCache(new CaffeineCacheManager());
    LwM2MTelemetryLogService logService7 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportServerHelper helper5 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2MAttributesService attributesService2 = new DefaultLwM2MAttributesService(futures2, transportService6,
        helper4, clientContext5, config11, null, downlinkHandler3, logService6,
        new DefaultLwM2MOtaUpdateService(transportService7, clientContext7, config15, null, downlinkHandler4,
            otaPackageDataCache2, logService7, helper5, new TbDummyLwM2MClientOtaInfoStore()),
        mock(LwM2mModelProvider.class));

    DefaultTbServiceInfoProvider serviceInfoProvider24 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService9 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher9 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService9 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService6 = new HashPartitionService(serviceInfoProvider24, tenantRoutingInfoService9,
        applicationEventPublisher9, queueRoutingInfoService9, new TopicService());

    TbQueueTransportApiSettings transportApiSettings9 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings9 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider25 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings9 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage6 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider6 = new InMemoryTbTransportQueueFactory(transportApiSettings9,
        transportNotificationSettings9, serviceInfoProvider25, coreSettings9, storage6, new TopicService());

    TbCoreQueueProducerProvider producerProvider6 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService6 = new TbRuleEngineProducerService(null);
    TopicService topicService11 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider26 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory8 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache16 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache8 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService6 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler6 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher6 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache6 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor6 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService8 = new DefaultTransportService(partitionService6, queueProvider6,
        producerProvider6, ruleEngineProducerService6, topicService11, serviceInfoProvider26, statsFactory8,
        deviceProfileCache16, tenantProfileCache8, rateLimitService6, scheduler6, eventPublisher6,
        transportResourceCache6, notificationRuleProcessor6, new DefaultEntityLimitsCache(1, 3));

    LwM2mTransportContext context15 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config16 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore6 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore9 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache17 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext8 = new LwM2mClientContextImpl(context15, config16, securityStore6,
        clientStore9, null, deviceProfileCache17, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context16 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config17 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService8 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context17 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config18 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore10 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache18 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext9 = new LwM2mClientContextImpl(context17, config18, null, clientStore10, null,
        deviceProfileCache18, new LwM2MModelConfigServiceImpl());

    DefaultLwM2MSessionManager sessionManager4 = new DefaultLwM2MSessionManager(transportService5, attributesService2,
        new DefaultLwM2MRpcRequestHandler(transportService8, clientContext8, null,
            new DefaultLwM2mDownlinkMsgHandler(context16, config17, logService8, clientContext9,
                new LwM2mVersionedModelProvider(null, null, new LwM2mTransportContext())),
            mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class)),
        null);

    DefaultTbServiceInfoProvider serviceInfoProvider27 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService10 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher10 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService10 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService7 = new HashPartitionService(serviceInfoProvider27, tenantRoutingInfoService10,
        applicationEventPublisher10, queueRoutingInfoService10, new TopicService());

    TbQueueTransportApiSettings transportApiSettings10 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings10 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider28 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings10 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage7 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider7 = new InMemoryTbTransportQueueFactory(transportApiSettings10,
        transportNotificationSettings10, serviceInfoProvider28, coreSettings10, storage7, new TopicService());

    TopicService topicService12 = new TopicService();
    TbQueueCoreSettings coreSettings11 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings4 = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings4 = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider29 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings11 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings11 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings4 = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider7 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService12, coreSettings11, ruleEngineSettings4, vcSettings4, serviceInfoProvider29, transportApiSettings11,
        transportNotificationSettings11, edgeSettings4, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider30 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService11 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher11 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService11 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService7 = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider30, tenantRoutingInfoService11, applicationEventPublisher11,
            queueRoutingInfoService11, new TopicService()));
    TopicService topicService13 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider31 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory9 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache19 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache9 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService7 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler7 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher7 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache7 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor7 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService9 = new DefaultTransportService(partitionService7, queueProvider7,
        producerProvider7, ruleEngineProducerService7, topicService13, serviceInfoProvider31, statsFactory9,
        deviceProfileCache19, tenantProfileCache9, rateLimitService7, scheduler7, eventPublisher7,
        transportResourceCache7, notificationRuleProcessor7, new DefaultEntityLimitsCache(1, 3));

    LwM2mTransportContext context18 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config19 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore7 = new TbInMemorySecurityStore();
    LwM2mTransportContext context19 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore8 = new TbLwM2mSecurityStore(securityStore7,
        new LwM2mCredentialsSecurityInfoValidator(context19, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore11 = new TbDummyLwM2MClientStore();
    TopicService topicService14 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider32 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory10 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache20 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache10 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService10 = new DefaultTransportService(null, null, null, null, topicService14,
        serviceInfoProvider32, statsFactory10, deviceProfileCache20, tenantProfileCache10, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures3 = new HashMap<>();
    DefaultLwM2MAttributesService attributesService3 = new DefaultLwM2MAttributesService(futures3, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MSessionManager sessionManager5 = new DefaultLwM2MSessionManager(transportService10, attributesService3,
        new DefaultLwM2MRpcRequestHandler(null, null, null, null, mock(LwM2MTelemetryLogService.class),
            mock(LwM2mModelProvider.class)),
        null);

    DefaultTransportDeviceProfileCache deviceProfileCache21 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext10 = new LwM2mClientContextImpl(context18, config19, securityStore8,
        clientStore11, sessionManager5, deviceProfileCache21, new LwM2MModelConfigServiceImpl());

    LwM2MTransportServerConfig config20 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context20 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config21 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService9 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context21 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config22 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore9 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore12 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager6 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache22 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext11 = new LwM2mClientContextImpl(context21, config22, securityStore9,
        clientStore12, sessionManager6, deviceProfileCache22, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context22 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config23 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore13 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache23 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext2 = new LwM2mClientContextImpl(context22, config23, null, clientStore13,
        null, deviceProfileCache23, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper6 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2mDownlinkMsgHandler downlinkHandler5 = new DefaultLwM2mDownlinkMsgHandler(context20, config21,
        logService9, clientContext11,
        new LwM2mVersionedModelProvider(lwM2mClientContext2, helper6, new LwM2mTransportContext()));

    CaffeineOtaPackageCache otaPackageDataCache3 = new CaffeineOtaPackageCache(new CaffeineCacheManager());
    LwM2MTelemetryLogService logService10 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportServerHelper helper7 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2MOtaUpdateService otaService = new DefaultLwM2MOtaUpdateService(transportService9, clientContext10,
        config20, null, downlinkHandler5, otaPackageDataCache3, logService10, helper7,
        new TbDummyLwM2MClientOtaInfoStore());

    LwM2MTransportServerConfig config24 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService11 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportServerHelper helper8 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    LwM2mTransportContext context23 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config25 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore10 = new TbInMemorySecurityStore();
    LwM2mTransportContext context24 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore11 = new TbLwM2mSecurityStore(securityStore10,
        new LwM2mCredentialsSecurityInfoValidator(context24, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore14 = new TbDummyLwM2MClientStore();
    DefaultTbServiceInfoProvider serviceInfoProvider33 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService12 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher12 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService12 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService8 = new HashPartitionService(serviceInfoProvider33, tenantRoutingInfoService12,
        applicationEventPublisher12, queueRoutingInfoService12, new TopicService());

    TbQueueTransportApiSettings transportApiSettings12 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings12 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider34 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings12 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage8 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider8 = new InMemoryTbTransportQueueFactory(transportApiSettings12,
        transportNotificationSettings12, serviceInfoProvider34, coreSettings12, storage8, new TopicService());

    TbCoreQueueProducerProvider producerProvider8 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService8 = new TbRuleEngineProducerService(null);
    TopicService topicService15 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider35 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory11 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache24 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache11 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService8 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler8 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher8 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache8 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor8 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService11 = new DefaultTransportService(partitionService8, queueProvider8,
        producerProvider8, ruleEngineProducerService8, topicService15, serviceInfoProvider35, statsFactory11,
        deviceProfileCache24, tenantProfileCache11, rateLimitService8, scheduler8, eventPublisher8,
        transportResourceCache8, notificationRuleProcessor8, new DefaultEntityLimitsCache(1, 3));

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures4 = new HashMap<>();
    TopicService topicService16 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider36 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory12 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache25 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache12 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService12 = new DefaultTransportService(null, null, null, null, topicService16,
        serviceInfoProvider36, statsFactory12, deviceProfileCache25, tenantProfileCache12, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportServerHelper helper9 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    LwM2MTransportServerConfig config26 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context25 = new LwM2mTransportContext();
    DefaultLwM2mDownlinkMsgHandler downlinkHandler6 = new DefaultLwM2mDownlinkMsgHandler(context25,
        new LwM2MTransportServerConfig(), mock(LwM2MTelemetryLogService.class), null, null);

    LwM2MTelemetryLogService logService12 = mock(LwM2MTelemetryLogService.class);
    LwM2MTransportServerConfig config27 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService13 = mock(LwM2MTelemetryLogService.class);
    DefaultLwM2MAttributesService attributesService4 = new DefaultLwM2MAttributesService(futures4, transportService12,
        helper9, null, config26, null, downlinkHandler6, logService12, new DefaultLwM2MOtaUpdateService(null, null,
            config27, null, null, null, logService13, null, new TbDummyLwM2MClientOtaInfoStore()),
        mock(LwM2mModelProvider.class));

    TopicService topicService17 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider37 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory13 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache26 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache13 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService13 = new DefaultTransportService(null, null, null, null, topicService17,
        serviceInfoProvider37, statsFactory13, deviceProfileCache26, tenantProfileCache13, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportContext context26 = new LwM2mTransportContext();
    DefaultLwM2MSessionManager sessionManager7 = new DefaultLwM2MSessionManager(transportService11, attributesService4,
        new DefaultLwM2MRpcRequestHandler(transportService13, null, null,
            new DefaultLwM2mDownlinkMsgHandler(context26, new LwM2MTransportServerConfig(),
                mock(LwM2MTelemetryLogService.class), null, null),
            mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class)),
        null);

    DefaultTransportDeviceProfileCache deviceProfileCache27 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext12 = new LwM2mClientContextImpl(context23, config25, securityStore11,
        clientStore14, sessionManager7, deviceProfileCache27, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context27 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config28 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService14 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context28 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config29 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore12 = new TbInMemorySecurityStore();
    LwM2mTransportContext context29 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore13 = new TbLwM2mSecurityStore(securityStore12,
        new LwM2mCredentialsSecurityInfoValidator(context29, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore15 = new TbDummyLwM2MClientStore();
    TopicService topicService18 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider38 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory14 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache28 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache14 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService14 = new DefaultTransportService(null, null, null, null, topicService18,
        serviceInfoProvider38, statsFactory14, deviceProfileCache28, tenantProfileCache14, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures5 = new HashMap<>();
    DefaultLwM2MAttributesService attributesService5 = new DefaultLwM2MAttributesService(futures5, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MSessionManager sessionManager8 = new DefaultLwM2MSessionManager(transportService14, attributesService5,
        new DefaultLwM2MRpcRequestHandler(null, null, null, null, mock(LwM2MTelemetryLogService.class),
            mock(LwM2mModelProvider.class)),
        null);

    DefaultTransportDeviceProfileCache deviceProfileCache29 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext13 = new LwM2mClientContextImpl(context28, config29, securityStore13,
        clientStore15, sessionManager8, deviceProfileCache29, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context30 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config30 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore14 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore16 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager9 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache30 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext3 = new LwM2mClientContextImpl(context30, config30, securityStore14,
        clientStore16, sessionManager9, deviceProfileCache30, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper10 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2mDownlinkMsgHandler defaultLwM2MDownlinkMsgHandler = new DefaultLwM2mDownlinkMsgHandler(context27,
        config28, logService14, clientContext13,
        new LwM2mVersionedModelProvider(lwM2mClientContext3, helper10, new LwM2mTransportContext()));

    LwM2mTransportContext context31 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config31 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore15 = new TbInMemorySecurityStore();
    LwM2mTransportContext context32 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore16 = new TbLwM2mSecurityStore(securityStore15,
        new LwM2mCredentialsSecurityInfoValidator(context32, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore17 = new TbDummyLwM2MClientStore();
    TopicService topicService19 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider39 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory15 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache31 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache15 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService15 = new DefaultTransportService(null, null, null, null, topicService19,
        serviceInfoProvider39, statsFactory15, deviceProfileCache31, tenantProfileCache15, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures6 = new HashMap<>();
    DefaultLwM2MAttributesService attributesService6 = new DefaultLwM2MAttributesService(futures6, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MSessionManager sessionManager10 = new DefaultLwM2MSessionManager(transportService15, attributesService6,
        new DefaultLwM2MRpcRequestHandler(null, null, null, null, mock(LwM2MTelemetryLogService.class),
            mock(LwM2mModelProvider.class)),
        null);

    DefaultTransportDeviceProfileCache deviceProfileCache32 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext4 = new LwM2mClientContextImpl(context31, config31, securityStore16,
        clientStore17, sessionManager10, deviceProfileCache32, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper11 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    LwM2mVersionedModelProvider modelProvider = new LwM2mVersionedModelProvider(lwM2mClientContext4, helper11,
        new LwM2mTransportContext());

    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    TbInMemorySecurityStore securityStore17 = new TbInMemorySecurityStore();
    LwM2mTransportContext context33 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore18 = new TbLwM2mSecurityStore(securityStore17,
        new LwM2mCredentialsSecurityInfoValidator(context33, new LwM2MTransportServerConfig()));

    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler = new DefaultLwM2mUplinkMsgHandler(transportService,
        context, attributesService, sessionManager4, otaService, config24, logService11, helper8, sessionStore,
        clientContext12, defaultLwM2MDownlinkMsgHandler, modelProvider, registrationStore, securityStore18,
        new LwM2MModelConfigServiceImpl());

    // Act
    LwM2mClientContext actualClientContext = defaultLwM2mUplinkMsgHandler.getClientContext();
    LwM2MTransportServerConfig actualConfig = defaultLwM2mUplinkMsgHandler.getConfig();
    LwM2mValueConverter actualConverter = defaultLwM2mUplinkMsgHandler.getConverter();

    // Assert
    assertTrue(actualClientContext instanceof LwM2mClientContextImpl);
    assertTrue(actualConverter instanceof LwM2mValueConverterImpl);
    assertEquals("LwM2M uplink", defaultLwM2mUplinkMsgHandler.getExecutorName());
    assertSame(config24, actualConfig);
    assertSame(clientContext12, actualClientContext);
  }
}
