package org.thingsboard.server.actors.tenant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import freemarker.template.Configuration;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.DefaultTbActorSystem;
import org.thingsboard.server.actors.TbActor;
import org.thingsboard.server.actors.TbActorCtx;
import org.thingsboard.server.actors.TbActorException;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorNotRegisteredException;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.TbEntityActorId;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.actors.tenant.TenantActor.ActorCreator;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.MsgType;
import org.thingsboard.server.common.msg.TbActorMsg;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.msg.queue.QueueToRuleEngineMsg;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.dao.service.validator.ApiUsageDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.sql.tenant.JpaTenantProfileDao;
import org.thingsboard.server.dao.sql.usagerecord.ApiUsageStateRepository;
import org.thingsboard.server.dao.sql.usagerecord.JpaApiUsageStateDao;
import org.thingsboard.server.dao.tenant.DefaultTbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;
import org.thingsboard.server.dao.usagerecord.ApiUsageStateServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;
import org.thingsboard.server.service.apiusage.DefaultTbApiUsageStateService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.mail.MailExecutorService;

@ContextConfiguration(classes = {ActorCreator.class, TenantActor.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class TenantActorDiffblueTest {
  @Autowired private ActorCreator actorCreator;

  @MockBean private ActorSystemContext actorSystemContext;

  @Autowired private TenantActor tenantActor;

  @MockBean private TenantId tenantId;

  /**
   * Test ActorCreator {@link ActorCreator#createActor()}.
   *
   * <p>Method under test: {@link ActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test ActorCreator createActor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActor ActorCreator.createActor()"})
  void testActorCreatorCreateActor() {
    // Arrange
    ActorSystemContext context = new ActorSystemContext();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ActorCreator actorCreator = new ActorCreator(context, tenantId);

    // Act
    TbActor actualCreateActorResult = actorCreator.createActor();

    // Assert
    assertTrue(actualCreateActorResult instanceof TenantActor);
    assertNull(((TenantActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
    assertNull(((TenantActor) actualCreateActorResult).getRootChainActor());
    assertNull(((TenantActor) actualCreateActorResult).getRootChain());
    assertFalse(((TenantActor) actualCreateActorResult).cantFindTenant);
  }

  /**
   * Test ActorCreator {@link ActorCreator#createActor()}.
   *
   * <p>Method under test: {@link ActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test ActorCreator createActor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActor ActorCreator.createActor()"})
  void testActorCreatorCreateActor2() {
    // Arrange
    ActorCreator actorCreator = new ActorCreator(new ActorSystemContext(), null);

    // Act
    TbActor actualCreateActorResult = actorCreator.createActor();

    // Assert
    assertTrue(actualCreateActorResult instanceof TenantActor);
    assertNull(((TenantActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
    assertNull(((TenantActor) actualCreateActorResult).getRootChainActor());
    assertNull(((TenantActor) actualCreateActorResult).getRootChain());
    assertFalse(((TenantActor) actualCreateActorResult).cantFindTenant);
  }

  /**
   * Test ActorCreator {@link ActorCreator#createActorId()}.
   *
   * <p>Method under test: {@link ActorCreator#createActorId()}
   */
  @Test
  @DisplayName("Test ActorCreator createActorId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActorId ActorCreator.createActorId()"})
  void testActorCreatorCreateActorId() {
    // Arrange and Act
    TbActorId actualCreateActorIdResult = actorCreator.createActorId();

    // Assert
    assertTrue(actualCreateActorIdResult instanceof TbEntityActorId);
    assertNull(actualCreateActorIdResult.getEntityType());
  }

  /**
   * Test {@link TenantActor#init(TbActorCtx)}.
   *
   * <p>Method under test: {@link TenantActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName("Test init(TbActorCtx)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantActor.init(TbActorCtx)"})
  void testInit() throws TbActorException {
    // Arrange
    when(actorSystemContext.getTenantService())
        .thenThrow(new TbActorNotRegisteredException(mock(TbActorId.class), "An error occurred"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    tenantActor.init(ctx);

    // Assert
    verify(actorSystemContext).getTenantService();
    assertFalse(tenantActor.cantFindTenant);
    assertSame(ctx, tenantActor.getActorRef());
    assertSame(ctx, tenantActor.getCtx());
  }

  /**
   * Test {@link TenantActor#init(TbActorCtx)}.
   *
   * <p>Method under test: {@link TenantActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName("Test init(TbActorCtx)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantActor.init(TbActorCtx)"})
  void testInit2() throws TbActorException {
    // Arrange
    TenantServiceImpl tenantServiceImpl = mock(TenantServiceImpl.class);
    when(tenantServiceImpl.findTenantById(Mockito.<TenantId>any())).thenReturn(new Tenant());
    when(actorSystemContext.getServiceInfoProvider())
        .thenReturn(new DefaultTbServiceInfoProvider());
    when(actorSystemContext.getTenantService()).thenReturn(tenantServiceImpl);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    tenantActor.init(ctx);

    // Assert
    verify(actorSystemContext).getServiceInfoProvider();
    verify(actorSystemContext).getTenantService();
    verify(tenantServiceImpl).findTenantById(isA(TenantId.class));
    assertFalse(tenantActor.cantFindTenant);
    assertSame(ctx, tenantActor.getActorRef());
    assertSame(ctx, tenantActor.getCtx());
  }

  /**
   * Test {@link TenantActor#init(TbActorCtx)}.
   *
   * <p>Method under test: {@link TenantActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName("Test init(TbActorCtx)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantActor.init(TbActorCtx)"})
  void testInit3() throws TbActorException {
    // Arrange
    TenantServiceImpl tenantServiceImpl = mock(TenantServiceImpl.class);
    when(tenantServiceImpl.findTenantById(Mockito.<TenantId>any())).thenReturn(new Tenant());
    when(actorSystemContext.getServiceInfoProvider())
        .thenThrow(new TbActorNotRegisteredException(mock(TbActorId.class), "An error occurred"));
    when(actorSystemContext.getTenantService()).thenReturn(tenantServiceImpl);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    tenantActor.init(ctx);

    // Assert
    verify(actorSystemContext).getServiceInfoProvider();
    verify(actorSystemContext).getTenantService();
    verify(tenantServiceImpl).findTenantById(isA(TenantId.class));
    assertFalse(tenantActor.cantFindTenant);
    assertSame(ctx, tenantActor.getActorRef());
    assertSame(ctx, tenantActor.getCtx());
  }

  /**
   * Test {@link TenantActor#init(TbActorCtx)}.
   *
   * <p>Method under test: {@link TenantActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName("Test init(TbActorCtx)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantActor.init(TbActorCtx)"})
  void testInit4() throws TbActorException {
    // Arrange
    TenantServiceImpl tenantServiceImpl = mock(TenantServiceImpl.class);
    when(tenantServiceImpl.findTenantById(Mockito.<TenantId>any())).thenReturn(new Tenant());

    DefaultTbServiceInfoProvider defaultTbServiceInfoProvider =
        mock(DefaultTbServiceInfoProvider.class);
    when(defaultTbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService hashPartitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    when(actorSystemContext.getPartitionService()).thenReturn(hashPartitionService);
    when(actorSystemContext.getServiceInfoProvider()).thenReturn(defaultTbServiceInfoProvider);
    when(actorSystemContext.getTenantService()).thenReturn(tenantServiceImpl);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    tenantActor.init(ctx);

    // Assert
    verify(actorSystemContext).getPartitionService();
    verify(actorSystemContext, atLeast(1)).getServiceInfoProvider();
    verify(actorSystemContext).getTenantService();
    verify(tenantServiceImpl).findTenantById(isA(TenantId.class));
    verify(defaultTbServiceInfoProvider, atLeast(1)).isService(Mockito.<ServiceType>any());
    assertFalse(tenantActor.cantFindTenant);
    assertSame(ctx, tenantActor.getActorRef());
    assertSame(ctx, tenantActor.getCtx());
  }

  /**
   * Test {@link TenantActor#init(TbActorCtx)}.
   *
   * <p>Method under test: {@link TenantActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName("Test init(TbActorCtx)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantActor.init(TbActorCtx)"})
  void testInit5() throws TbActorException {
    // Arrange
    TenantServiceImpl tenantServiceImpl = mock(TenantServiceImpl.class);
    when(tenantServiceImpl.findTenantById(Mockito.<TenantId>any())).thenReturn(new Tenant());

    DefaultTbServiceInfoProvider defaultTbServiceInfoProvider =
        mock(DefaultTbServiceInfoProvider.class);
    when(defaultTbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);
    when(actorSystemContext.getPartitionService())
        .thenThrow(new TbActorNotRegisteredException(mock(TbActorId.class), "An error occurred"));
    when(actorSystemContext.getServiceInfoProvider()).thenReturn(defaultTbServiceInfoProvider);
    when(actorSystemContext.getTenantService()).thenReturn(tenantServiceImpl);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    tenantActor.init(ctx);

    // Assert
    verify(actorSystemContext).getPartitionService();
    verify(actorSystemContext, atLeast(1)).getServiceInfoProvider();
    verify(actorSystemContext).getTenantService();
    verify(tenantServiceImpl).findTenantById(isA(TenantId.class));
    verify(defaultTbServiceInfoProvider, atLeast(1)).isService(Mockito.<ServiceType>any());
    assertFalse(tenantActor.cantFindTenant);
    assertSame(ctx, tenantActor.getActorRef());
    assertSame(ctx, tenantActor.getCtx());
  }

  /**
   * Test {@link TenantActor#init(TbActorCtx)}.
   *
   * <p>Method under test: {@link TenantActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName("Test init(TbActorCtx)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantActor.init(TbActorCtx)"})
  void testInit6() throws TbActorException {
    // Arrange
    TenantServiceImpl tenantServiceImpl = mock(TenantServiceImpl.class);
    when(tenantServiceImpl.findTenantById(Mockito.<TenantId>any())).thenReturn(new Tenant());

    DefaultTbServiceInfoProvider defaultTbServiceInfoProvider =
        mock(DefaultTbServiceInfoProvider.class);
    when(defaultTbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);

    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService hashPartitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    when(actorSystemContext.getApiUsageStateService())
        .thenThrow(new TbActorNotRegisteredException(mock(TbActorId.class), "An error occurred"));
    when(actorSystemContext.getPartitionService()).thenReturn(hashPartitionService);
    when(actorSystemContext.getServiceInfoProvider()).thenReturn(defaultTbServiceInfoProvider);
    when(actorSystemContext.getTenantService()).thenReturn(tenantServiceImpl);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    tenantActor.init(ctx);

    // Assert
    verify(actorSystemContext).getApiUsageStateService();
    verify(actorSystemContext).getPartitionService();
    verify(actorSystemContext, atLeast(1)).getServiceInfoProvider();
    verify(actorSystemContext).getTenantService();
    verify(tenantServiceImpl).findTenantById(isA(TenantId.class));
    verify(defaultTbServiceInfoProvider, atLeast(1)).isService(Mockito.<ServiceType>any());
    verify(serviceInfoProvider).isService(ServiceType.TB_CORE);
    assertTrue(tenantActor.cantFindTenant);
    assertSame(ctx, tenantActor.getActorRef());
    assertSame(ctx, tenantActor.getCtx());
  }

  /**
   * Test {@link TenantActor#init(TbActorCtx)}.
   *
   * <ul>
   *   <li>Given {@link DefaultTbApiUsageStateService} {@link
   *       DefaultTbApiUsageStateService#getApiUsageState(TenantId)} return {@link
   *       ApiUsageState#ApiUsageState()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName(
      "Test init(TbActorCtx); given DefaultTbApiUsageStateService getApiUsageState(TenantId) return ApiUsageState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantActor.init(TbActorCtx)"})
  void testInit_givenDefaultTbApiUsageStateServiceGetApiUsageStateReturnApiUsageState()
      throws TbActorException {
    // Arrange
    TenantServiceImpl tenantServiceImpl = mock(TenantServiceImpl.class);
    when(tenantServiceImpl.findTenantById(Mockito.<TenantId>any())).thenReturn(new Tenant());

    DefaultTbServiceInfoProvider defaultTbServiceInfoProvider =
        mock(DefaultTbServiceInfoProvider.class);
    when(defaultTbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);

    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService hashPartitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    DefaultTbApiUsageStateService defaultTbApiUsageStateService =
        mock(DefaultTbApiUsageStateService.class);
    when(defaultTbApiUsageStateService.getApiUsageState(Mockito.<TenantId>any()))
        .thenReturn(new ApiUsageState());
    when(actorSystemContext.getApiUsageStateService()).thenReturn(defaultTbApiUsageStateService);
    when(actorSystemContext.getPartitionService()).thenReturn(hashPartitionService);
    when(actorSystemContext.getServiceInfoProvider()).thenReturn(defaultTbServiceInfoProvider);
    when(actorSystemContext.getTenantService()).thenReturn(tenantServiceImpl);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    tenantActor.init(ctx);

    // Assert
    verify(actorSystemContext).getApiUsageStateService();
    verify(actorSystemContext).getPartitionService();
    verify(actorSystemContext, atLeast(1)).getServiceInfoProvider();
    verify(actorSystemContext).getTenantService();
    verify(tenantServiceImpl).findTenantById(isA(TenantId.class));
    verify(defaultTbServiceInfoProvider, atLeast(1)).isService(Mockito.<ServiceType>any());
    verify(serviceInfoProvider).isService(ServiceType.TB_CORE);
    verify(defaultTbApiUsageStateService).getApiUsageState(isA(TenantId.class));
    assertTrue(tenantActor.cantFindTenant);
    assertSame(ctx, tenantActor.getActorRef());
    assertSame(ctx, tenantActor.getCtx());
  }

  /**
   * Test {@link TenantActor#init(TbActorCtx)}.
   *
   * <ul>
   *   <li>Given {@link DefaultTbApiUsageStateService} {@link
   *       DefaultTbApiUsageStateService#getApiUsageState(TenantId)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName(
      "Test init(TbActorCtx); given DefaultTbApiUsageStateService getApiUsageState(TenantId) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantActor.init(TbActorCtx)"})
  void testInit_givenDefaultTbApiUsageStateServiceGetApiUsageStateReturnNull()
      throws TbActorException {
    // Arrange
    TenantServiceImpl tenantServiceImpl = mock(TenantServiceImpl.class);
    when(tenantServiceImpl.findTenantById(Mockito.<TenantId>any())).thenReturn(new Tenant());

    DefaultTbServiceInfoProvider defaultTbServiceInfoProvider =
        mock(DefaultTbServiceInfoProvider.class);
    when(defaultTbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);

    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService hashPartitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    DefaultTbApiUsageStateService defaultTbApiUsageStateService =
        mock(DefaultTbApiUsageStateService.class);
    when(defaultTbApiUsageStateService.getApiUsageState(Mockito.<TenantId>any())).thenReturn(null);
    when(actorSystemContext.getApiUsageStateService()).thenReturn(defaultTbApiUsageStateService);
    when(actorSystemContext.getPartitionService()).thenReturn(hashPartitionService);
    when(actorSystemContext.getServiceInfoProvider()).thenReturn(defaultTbServiceInfoProvider);
    when(actorSystemContext.getTenantService()).thenReturn(tenantServiceImpl);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    tenantActor.init(ctx);

    // Assert
    verify(actorSystemContext).getApiUsageStateService();
    verify(actorSystemContext).getPartitionService();
    verify(actorSystemContext, atLeast(1)).getServiceInfoProvider();
    verify(actorSystemContext).getTenantService();
    verify(tenantServiceImpl).findTenantById(isA(TenantId.class));
    verify(defaultTbServiceInfoProvider, atLeast(1)).isService(Mockito.<ServiceType>any());
    verify(serviceInfoProvider).isService(ServiceType.TB_CORE);
    verify(defaultTbApiUsageStateService).getApiUsageState(isA(TenantId.class));
    assertTrue(tenantActor.cantFindTenant);
    assertSame(ctx, tenantActor.getActorRef());
    assertSame(ctx, tenantActor.getCtx());
  }

  /**
   * Test {@link TenantActor#init(TbActorCtx)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName("Test init(TbActorCtx); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantActor.init(TbActorCtx)"})
  void testInit_thenCallsGetId() throws TbActorException {
    // Arrange
    when(actorSystemContext.getTenantService()).thenReturn(new TenantServiceImpl());
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    tenantActor.init(ctx);

    // Assert
    verify(actorSystemContext).getTenantService();
    verify(tenantId).getId();
    assertFalse(tenantActor.cantFindTenant);
    assertSame(ctx, tenantActor.getActorRef());
    assertSame(ctx, tenantActor.getCtx());
  }

  /**
   * Test {@link TenantActor#init(TbActorCtx)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantRoutingInfoService#getRoutingInfo(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link TenantActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName("Test init(TbActorCtx); then calls getRoutingInfo(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantActor.init(TbActorCtx)"})
  void testInit_thenCallsGetRoutingInfo() throws TbActorException {
    // Arrange
    TenantServiceImpl tenantServiceImpl = mock(TenantServiceImpl.class);
    when(tenantServiceImpl.findTenantById(Mockito.<TenantId>any())).thenReturn(new Tenant());

    DefaultTbServiceInfoProvider defaultTbServiceInfoProvider =
        mock(DefaultTbServiceInfoProvider.class);
    when(defaultTbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);

    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService hashPartitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    when(tenantRoutingInfoService2.getRoutingInfo(Mockito.<TenantId>any()))
        .thenThrow(new TbActorNotRegisteredException(mock(TbActorId.class), "An error occurred"));
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao =
        new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateService =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService2,
            tsService2,
            new ApiUsageDataValidator());
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider3,
            tenantRoutingInfoService3,
            applicationEventPublisher3,
            queueRoutingInfoService3,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider5,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService2,
            serviceInfoProvider4,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService defaultTbApiUsageStateService =
        new DefaultTbApiUsageStateService(
            partitionService,
            tenantService,
            tsService,
            apiUsageStateService,
            tenantProfileCache,
            mailService,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());
    when(actorSystemContext.getApiUsageStateService()).thenReturn(defaultTbApiUsageStateService);
    when(actorSystemContext.getPartitionService()).thenReturn(hashPartitionService);
    when(actorSystemContext.getServiceInfoProvider()).thenReturn(defaultTbServiceInfoProvider);
    when(actorSystemContext.getTenantService()).thenReturn(tenantServiceImpl);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    tenantActor.init(ctx);

    // Assert
    verify(actorSystemContext).getApiUsageStateService();
    verify(actorSystemContext).getPartitionService();
    verify(actorSystemContext, atLeast(1)).getServiceInfoProvider();
    verify(actorSystemContext).getTenantService();
    verify(tenantServiceImpl).findTenantById(isA(TenantId.class));
    verify(defaultTbServiceInfoProvider, atLeast(1)).isService(Mockito.<ServiceType>any());
    verify(serviceInfoProvider).isService(ServiceType.TB_CORE);
    verify(tenantRoutingInfoService2).getRoutingInfo(isA(TenantId.class));
    assertTrue(tenantActor.cantFindTenant);
    assertSame(ctx, tenantActor.getActorRef());
    assertSame(ctx, tenantActor.getCtx());
  }

  /**
   * Test {@link TenantActor#doProcess(TbActorMsg)}.
   *
   * <ul>
   *   <li>Given {@code APP_INIT_MSG}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TenantActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg); given 'APP_INIT_MSG'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantActor.doProcess(TbActorMsg)"})
  void testDoProcess_givenAppInitMsg_thenReturnFalse() {
    // Arrange
    TbActorMsg msg = mock(TbActorMsg.class);
    when(msg.getMsgType()).thenReturn(MsgType.APP_INIT_MSG);

    // Act
    boolean actualDoProcessResult = tenantActor.doProcess(msg);

    // Assert
    verify(msg).getMsgType();
    assertFalse(actualDoProcessResult);
  }

  /**
   * Test {@link TenantActor#doProcess(TbActorMsg)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TenantActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantActor.doProcess(TbActorMsg)"})
  void testDoProcess_thenReturnTrue() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    QueueToRuleEngineMsg msg =
        new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message");

    // Act and Assert
    assertTrue(tenantActor.doProcess(msg));
  }

  /**
   * Test {@link TenantActor#doProcess(TbActorMsg)}.
   *
   * <ul>
   *   <li>Then throw {@link TbActorNotRegisteredException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg); then throw TbActorNotRegisteredException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantActor.doProcess(TbActorMsg)"})
  void testDoProcess_thenThrowTbActorNotRegisteredException() {
    // Arrange
    TbActorMsg msg = mock(TbActorMsg.class);
    when(msg.getMsgType())
        .thenThrow(new TbActorNotRegisteredException(mock(TbActorId.class), "An error occurred"));

    // Act and Assert
    assertThrows(TbActorNotRegisteredException.class, () -> tenantActor.doProcess(msg));
    verify(msg).getMsgType();
  }

  /**
   * Test {@link TenantActor#onProcessFailure(TbActorMsg, Throwable)}.
   *
   * <p>Method under test: {@link TenantActor#onProcessFailure(TbActorMsg, Throwable)}
   */
  @Test
  @DisplayName("Test onProcessFailure(TbActorMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.actors.ProcessFailureStrategy TenantActor.onProcessFailure(TbActorMsg, Throwable)"
  })
  void testOnProcessFailure() {
    // Arrange
    TbActorMsg msg = mock(TbActorMsg.class);

    // Act and Assert
    assertFalse(tenantActor.onProcessFailure(msg, new Throwable()).isStop());
  }
}
