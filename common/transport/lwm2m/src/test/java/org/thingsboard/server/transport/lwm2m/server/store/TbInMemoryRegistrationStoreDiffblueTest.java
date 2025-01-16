package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.link.Link;
import org.eclipse.leshan.core.node.InvalidLwM2mPathException;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.observation.Observation;
import org.eclipse.leshan.core.observation.ObservationIdentifier;
import org.eclipse.leshan.core.observation.SingleObservation;
import org.eclipse.leshan.core.peer.LwM2mIdentity;
import org.eclipse.leshan.core.peer.LwM2mPeer;
import org.eclipse.leshan.core.request.ContentFormat;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.eclipse.leshan.server.registration.RegistrationUpdate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.LwM2mVersionedModelProvider;
import org.thingsboard.server.transport.lwm2m.server.attributes.DefaultLwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.attributes.LwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContextImpl;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigServiceImpl;
import org.thingsboard.server.transport.lwm2m.server.rpc.DefaultLwM2MRpcRequestHandler;
import org.thingsboard.server.transport.lwm2m.server.rpc.LwM2MRpcRequestHandler;
import org.thingsboard.server.transport.lwm2m.server.session.DefaultLwM2MSessionManager;
import org.thingsboard.server.transport.lwm2m.server.uplink.DefaultLwM2mUplinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mUplinkMsgHandler;

class TbInMemoryRegistrationStoreDiffblueTest {
  /**
   * Test {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}
   */
  @Test
  @DisplayName("Test new TbInMemoryRegistrationStore()")
  void testNewTbInMemoryRegistrationStore() {
    // Arrange, Act and Assert
    assertFalse((new TbInMemoryRegistrationStore()).getAllRegistrations().hasNext());
  }

  /**
   * Test
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore(LwM2MTransportServerConfig, long, LwM2mVersionedModelProvider)}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore(LwM2MTransportServerConfig, long, LwM2mVersionedModelProvider)}
   */
  @Test
  @DisplayName("Test new TbInMemoryRegistrationStore(LwM2MTransportServerConfig, long, LwM2mVersionedModelProvider)")
  void testNewTbInMemoryRegistrationStore2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService = new DefaultTransportService(null, null, null, null, topicService,
        serviceInfoProvider, statsFactory, deviceProfileCache, tenantProfileCache, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(null, null, null, null,
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    LwM2mTransportContext context3 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config3 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService, attributesService,
        rpcHandler, new DefaultLwM2mUplinkMsgHandler(null, context3, null, null, null, config3, logService, null,
            sessionStore, null, null, null, registrationStore, null, new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context, config2, securityStore2,
        clientStore, sessionManager, deviceProfileCache2, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    // Act and Assert
    assertFalse((new TbInMemoryRegistrationStore(config, 1L,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext()))).getAllRegistrations()
        .hasNext());
  }

  /**
   * Test
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore(LwM2MTransportServerConfig, ScheduledExecutorService, long, LwM2mVersionedModelProvider)}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore(LwM2MTransportServerConfig, ScheduledExecutorService, long, LwM2mVersionedModelProvider)}
   */
  @Test
  @DisplayName("Test new TbInMemoryRegistrationStore(LwM2MTransportServerConfig, ScheduledExecutorService, long, LwM2mVersionedModelProvider)")
  void testNewTbInMemoryRegistrationStore3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    DefaultEventLoop schedExecutor = new DefaultEventLoop();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService = new DefaultTransportService(null, null, null, null, topicService,
        serviceInfoProvider, statsFactory, deviceProfileCache, tenantProfileCache, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(null, null, null, null,
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    LwM2mTransportContext context3 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config3 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService, attributesService,
        rpcHandler, new DefaultLwM2mUplinkMsgHandler(null, context3, null, null, null, config3, logService, null,
            sessionStore, null, null, null, registrationStore, null, new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context, config2, securityStore2,
        clientStore, sessionManager, deviceProfileCache2, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    // Act and Assert
    assertFalse((new TbInMemoryRegistrationStore(config, schedExecutor, 1L,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext()))).getAllRegistrations()
        .hasNext());
  }

  /**
   * Test
   * {@link TbInMemoryRegistrationStore#updateRegistration(RegistrationUpdate)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#updateRegistration(RegistrationUpdate)}
   */
  @Test
  @DisplayName("Test updateRegistration(RegistrationUpdate); then return 'null'")
  void testUpdateRegistration_thenReturnNull() {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    LwM2mPeer clientTransportData = mock(LwM2mPeer.class);
    HashSet<ContentFormat> supportedContentFormats = new HashSet<>();
    HashMap<Integer, LwM2m.Version> supportedObjects = new HashMap<>();
    HashSet<LwM2mPath> availableInstances = new HashSet<>();
    HashMap<String, String> additionalAttributes = new HashMap<>();

    // Act and Assert
    assertNull(tbInMemoryRegistrationStore.updateRegistration(new RegistrationUpdate("42", clientTransportData, 1L,
        "42", null, new Link[]{new Link("Uri Reference", new ArrayList<>())}, "Alternate Path", supportedContentFormats,
        supportedObjects, availableInstances, additionalAttributes, new HashMap<>())));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getRegistration(String)}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#getRegistration(String)}
   */
  @Test
  @DisplayName("Test getRegistration(String)")
  void testGetRegistration() {
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(),
        mock(LwM2mCredentialsSecurityInfoValidator.class));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context, config2, securityStore, clientStore,
        sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    // Act and Assert
    assertNull((new TbInMemoryRegistrationStore(config, 1L,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext())))
        .getRegistration("42"));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getRegistration(String)}.
   * <ul>
   *   <li>Given
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#getRegistration(String)}
   */
  @Test
  @DisplayName("Test getRegistration(String); given TbInMemoryRegistrationStore()")
  void testGetRegistration_givenTbInMemoryRegistrationStore() {
    // Arrange, Act and Assert
    assertNull((new TbInMemoryRegistrationStore()).getRegistration("42"));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getRegistrationByEndpoint(String)}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#getRegistrationByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getRegistrationByEndpoint(String)")
  void testGetRegistrationByEndpoint() {
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(),
        mock(LwM2mCredentialsSecurityInfoValidator.class));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context, config2, securityStore, clientStore,
        sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    // Act and Assert
    assertNull((new TbInMemoryRegistrationStore(config, 1L,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext())))
        .getRegistrationByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getRegistrationByEndpoint(String)}.
   * <ul>
   *   <li>Given
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#getRegistrationByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getRegistrationByEndpoint(String); given TbInMemoryRegistrationStore()")
  void testGetRegistrationByEndpoint_givenTbInMemoryRegistrationStore() {
    // Arrange, Act and Assert
    assertNull((new TbInMemoryRegistrationStore()).getRegistrationByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test
   * {@link TbInMemoryRegistrationStore#getRegistrationByAdress(InetSocketAddress)}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#getRegistrationByAdress(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test getRegistrationByAdress(InetSocketAddress)")
  void testGetRegistrationByAdress() {
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(),
        mock(LwM2mCredentialsSecurityInfoValidator.class));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context, config2, securityStore, clientStore,
        sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore(config, 1L,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext()));

    // Act and Assert
    assertNull(tbInMemoryRegistrationStore.getRegistrationByAdress(InetSocketAddress.createUnresolved("foo", 1)));
  }

  /**
   * Test
   * {@link TbInMemoryRegistrationStore#getRegistrationByAdress(InetSocketAddress)}.
   * <ul>
   *   <li>Given
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#getRegistrationByAdress(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test getRegistrationByAdress(InetSocketAddress); given TbInMemoryRegistrationStore()")
  void testGetRegistrationByAdress_givenTbInMemoryRegistrationStore() {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();

    // Act and Assert
    assertNull(tbInMemoryRegistrationStore.getRegistrationByAdress(InetSocketAddress.createUnresolved("foo", 1)));
  }

  /**
   * Test
   * {@link TbInMemoryRegistrationStore#getRegistrationByIdentity(LwM2mIdentity)}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#getRegistrationByIdentity(LwM2mIdentity)}
   */
  @Test
  @DisplayName("Test getRegistrationByIdentity(LwM2mIdentity)")
  void testGetRegistrationByIdentity() {
    // Arrange, Act and Assert
    assertNull((new TbInMemoryRegistrationStore()).getRegistrationByIdentity(mock(LwM2mIdentity.class)));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getAllRegistrations()}.
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#getAllRegistrations()}
   */
  @Test
  @DisplayName("Test getAllRegistrations()")
  void testGetAllRegistrations() {
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(),
        mock(LwM2mCredentialsSecurityInfoValidator.class));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context, config2, securityStore, clientStore,
        sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    // Act and Assert
    assertFalse((new TbInMemoryRegistrationStore(config, 1L,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext()))).getAllRegistrations()
        .hasNext());
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getAllRegistrations()}.
   * <ul>
   *   <li>Given
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbInMemoryRegistrationStore#getAllRegistrations()}
   */
  @Test
  @DisplayName("Test getAllRegistrations(); given TbInMemoryRegistrationStore()")
  void testGetAllRegistrations_givenTbInMemoryRegistrationStore() {
    // Arrange, Act and Assert
    assertFalse((new TbInMemoryRegistrationStore()).getAllRegistrations().hasNext());
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#removeRegistration(String)}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#removeRegistration(String)}
   */
  @Test
  @DisplayName("Test removeRegistration(String)")
  void testRemoveRegistration() {
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(),
        mock(LwM2mCredentialsSecurityInfoValidator.class));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context, config2, securityStore, clientStore,
        sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    // Act and Assert
    assertNull((new TbInMemoryRegistrationStore(config, 1L,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext())))
        .removeRegistration("42"));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#removeRegistration(String)}.
   * <ul>
   *   <li>Given
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#removeRegistration(String)}
   */
  @Test
  @DisplayName("Test removeRegistration(String); given TbInMemoryRegistrationStore()")
  void testRemoveRegistration_givenTbInMemoryRegistrationStore() {
    // Arrange, Act and Assert
    assertNull((new TbInMemoryRegistrationStore()).removeRegistration("42"));
  }

  /**
   * Test
   * {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#addObservation(String, Observation, boolean)}
   */
  @Test
  @DisplayName("Test addObservation(String, Observation, boolean)")
  void testAddObservation() throws UnsupportedEncodingException, InvalidLwM2mPathException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();
    ObservationIdentifier id = new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"));
    LwM2mPath path = new LwM2mPath(1);
    ContentFormat contentFormat = ContentFormat.fromCode(1);
    HashMap<String, String> context = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbInMemoryRegistrationStore.addObservation("42",
        new SingleObservation(id, "42", path, contentFormat, context, new HashMap<>()), true));
  }

  /**
   * Test
   * {@link TbInMemoryRegistrationStore#getObservation(ObservationIdentifier)}
   * with {@code observationId}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#getObservation(ObservationIdentifier)}
   */
  @Test
  @DisplayName("Test getObservation(ObservationIdentifier) with 'observationId'")
  void testGetObservationWithObservationId() throws UnsupportedEncodingException {
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(),
        mock(LwM2mCredentialsSecurityInfoValidator.class));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context, config2, securityStore, clientStore,
        sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore(config, 1L,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext()));

    // Act and Assert
    assertNull(tbInMemoryRegistrationStore.getObservation(new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test
   * {@link TbInMemoryRegistrationStore#getObservation(ObservationIdentifier)}
   * with {@code observationId}.
   * <ul>
   *   <li>Given
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#getObservation(ObservationIdentifier)}
   */
  @Test
  @DisplayName("Test getObservation(ObservationIdentifier) with 'observationId'; given TbInMemoryRegistrationStore()")
  void testGetObservationWithObservationId_givenTbInMemoryRegistrationStore() throws UnsupportedEncodingException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();

    // Act and Assert
    assertNull(tbInMemoryRegistrationStore.getObservation(new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test
   * {@link TbInMemoryRegistrationStore#getObservation(String, ObservationIdentifier)}
   * with {@code registrationId}, {@code observationId}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#getObservation(String, ObservationIdentifier)}
   */
  @Test
  @DisplayName("Test getObservation(String, ObservationIdentifier) with 'registrationId', 'observationId'")
  void testGetObservationWithRegistrationIdObservationId() throws UnsupportedEncodingException {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();

    // Act and Assert
    assertNull(
        tbInMemoryRegistrationStore.getObservation("42", new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test
   * {@link TbInMemoryRegistrationStore#getObservation(String, ObservationIdentifier)}
   * with {@code registrationId}, {@code observationId}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#getObservation(String, ObservationIdentifier)}
   */
  @Test
  @DisplayName("Test getObservation(String, ObservationIdentifier) with 'registrationId', 'observationId'")
  void testGetObservationWithRegistrationIdObservationId2() throws UnsupportedEncodingException {
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(),
        mock(LwM2mCredentialsSecurityInfoValidator.class));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context, config2, securityStore, clientStore,
        sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore(config, 1L,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext()));

    // Act and Assert
    assertNull(
        tbInMemoryRegistrationStore.getObservation("42", new ObservationIdentifier("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getObservations(String)}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#getObservations(String)}
   */
  @Test
  @DisplayName("Test getObservations(String)")
  void testGetObservations() {
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(),
        mock(LwM2mCredentialsSecurityInfoValidator.class));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context, config2, securityStore, clientStore,
        sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    // Act
    Collection<Observation> actualObservations = (new TbInMemoryRegistrationStore(config, 1L,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext())))
        .getObservations("42");

    // Assert
    assertTrue(actualObservations instanceof List);
    assertTrue(actualObservations.isEmpty());
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#getObservations(String)}.
   * <ul>
   *   <li>Given
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#getObservations(String)}
   */
  @Test
  @DisplayName("Test getObservations(String); given TbInMemoryRegistrationStore()")
  void testGetObservations_givenTbInMemoryRegistrationStore() {
    // Arrange and Act
    Collection<Observation> actualObservations = (new TbInMemoryRegistrationStore()).getObservations("42");

    // Assert
    assertTrue(actualObservations instanceof List);
    assertTrue(actualObservations.isEmpty());
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#removeObservations(String)}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#removeObservations(String)}
   */
  @Test
  @DisplayName("Test removeObservations(String)")
  void testRemoveObservations() {
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(),
        mock(LwM2mCredentialsSecurityInfoValidator.class));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context, config2, securityStore, clientStore,
        sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    // Act
    Collection<Observation> actualRemoveObservationsResult = (new TbInMemoryRegistrationStore(config, 1L,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext())))
        .removeObservations("42");

    // Assert
    assertTrue(actualRemoveObservationsResult instanceof List);
    assertTrue(actualRemoveObservationsResult.isEmpty());
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#removeObservations(String)}.
   * <ul>
   *   <li>Given
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#removeObservations(String)}
   */
  @Test
  @DisplayName("Test removeObservations(String); given TbInMemoryRegistrationStore()")
  void testRemoveObservations_givenTbInMemoryRegistrationStore() {
    // Arrange and Act
    Collection<Observation> actualRemoveObservationsResult = (new TbInMemoryRegistrationStore())
        .removeObservations("42");

    // Assert
    assertTrue(actualRemoveObservationsResult instanceof List);
    assertTrue(actualRemoveObservationsResult.isEmpty());
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#removeFromMap(Map, Object, Object)}.
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#removeFromMap(Map, Object, Object)}
   */
  @Test
  @DisplayName("Test removeFromMap(Map, Object, Object)")
  void testRemoveFromMap() {
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(),
        mock(LwM2mCredentialsSecurityInfoValidator.class));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context, config2, securityStore, clientStore,
        sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore(config, 1L,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext()));

    // Act and Assert
    assertFalse(tbInMemoryRegistrationStore.removeFromMap(new HashMap<>(), "Key", "Value"));
  }

  /**
   * Test {@link TbInMemoryRegistrationStore#removeFromMap(Map, Object, Object)}.
   * <ul>
   *   <li>Given
   * {@link TbInMemoryRegistrationStore#TbInMemoryRegistrationStore()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbInMemoryRegistrationStore#removeFromMap(Map, Object, Object)}
   */
  @Test
  @DisplayName("Test removeFromMap(Map, Object, Object); given TbInMemoryRegistrationStore()")
  void testRemoveFromMap_givenTbInMemoryRegistrationStore() {
    // Arrange
    TbInMemoryRegistrationStore tbInMemoryRegistrationStore = new TbInMemoryRegistrationStore();

    // Act and Assert
    assertFalse(tbInMemoryRegistrationStore.removeFromMap(new HashMap<>(), "Key", "Value"));
  }
}
