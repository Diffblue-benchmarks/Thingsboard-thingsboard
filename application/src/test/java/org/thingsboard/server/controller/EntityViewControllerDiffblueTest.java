package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.entityview.EntityViewSearchQuery;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.entityview.EntityViewServiceImpl;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;
import org.thingsboard.server.service.apiusage.DefaultTbApiUsageStateService;
import org.thingsboard.server.service.entitiy.entityview.DefaultTbEntityViewService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.mail.MailExecutorService;
import org.thingsboard.server.service.telemetry.DefaultTelemetrySubscriptionService;

@ExtendWith(MockitoExtension.class)
class EntityViewControllerDiffblueTest {
  @InjectMocks private EntityViewController entityViewController;

  /**
   * Test {@link EntityViewController#deleteEntityView(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#deleteEntityView(String)}
   */
  @Test
  @DisplayName("Test deleteEntityView(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewController.deleteEntityView(String)"})
  void testDeleteEntityView_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider, new DefaultSchedulerComponent(), null);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService =
        new DefaultTbApiUsageStateService(
            null,
            tenantService,
            tsService2,
            null,
            null,
            null,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService tsSubService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, null, apiUsageClient, apiUsageStateService);

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, tsSubService, new BaseTimeseriesService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new EntityViewController(tbEntityViewService).deleteEntityView("42"));
  }

  /**
   * Test {@link EntityViewController#deleteEntityView(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#deleteEntityView(String)}
   */
  @Test
  @DisplayName("Test deleteEntityView(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewController.deleteEntityView(String)"})
  void testDeleteEntityView_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider, new DefaultSchedulerComponent(), null);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService =
        new DefaultTbApiUsageStateService(
            null,
            tenantService,
            tsService2,
            null,
            null,
            null,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService tsSubService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, null, apiUsageClient, apiUsageStateService);

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, tsSubService, new BaseTimeseriesService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new EntityViewController(tbEntityViewService).deleteEntityView(""));
  }

  /**
   * Test {@link EntityViewController#assignEntityViewToCustomer(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#assignEntityViewToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignEntityViewToCustomer(String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.EntityView EntityViewController.assignEntityViewToCustomer(String, String)"
  })
  void testAssignEntityViewToCustomer_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider, new DefaultSchedulerComponent(), null);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService =
        new DefaultTbApiUsageStateService(
            null,
            tenantService,
            tsService2,
            null,
            null,
            null,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService tsSubService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, null, apiUsageClient, apiUsageStateService);

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, tsSubService, new BaseTimeseriesService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new EntityViewController(tbEntityViewService).assignEntityViewToCustomer("42", "42"));
  }

  /**
   * Test {@link EntityViewController#assignEntityViewToCustomer(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#assignEntityViewToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignEntityViewToCustomer(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.EntityView EntityViewController.assignEntityViewToCustomer(String, String)"
  })
  void testAssignEntityViewToCustomer_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider, new DefaultSchedulerComponent(), null);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService =
        new DefaultTbApiUsageStateService(
            null,
            tenantService,
            tsService2,
            null,
            null,
            null,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService tsSubService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, null, apiUsageClient, apiUsageStateService);

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, tsSubService, new BaseTimeseriesService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new EntityViewController(tbEntityViewService).assignEntityViewToCustomer("", "42"));
  }

  /**
   * Test {@link EntityViewController#assignEntityViewToCustomer(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#assignEntityViewToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignEntityViewToCustomer(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.EntityView EntityViewController.assignEntityViewToCustomer(String, String)"
  })
  void testAssignEntityViewToCustomer_whenEmptyString2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider, new DefaultSchedulerComponent(), null);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService =
        new DefaultTbApiUsageStateService(
            null,
            tenantService,
            tsService2,
            null,
            null,
            null,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService tsSubService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, null, apiUsageClient, apiUsageStateService);

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, tsSubService, new BaseTimeseriesService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new EntityViewController(tbEntityViewService).assignEntityViewToCustomer("42", ""));
  }

  /**
   * Test {@link EntityViewController#findByQuery(EntityViewSearchQuery)}.
   *
   * <p>Method under test: {@link EntityViewController#findByQuery(EntityViewSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EntityViewSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityViewController.findByQuery(EntityViewSearchQuery)"})
  void testFindByQuery() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Requested item wasn't found!");

    EntityViewSearchQuery query = new EntityViewSearchQuery();
    query.setEntityViewTypes(entityViewTypes);
    query.setParameters(
        new RelationsSearchParameters(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            EntityType.TENANT,
            EntitySearchDirection.FROM,
            RelationTypeGroup.COMMON,
            3,
            true));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityViewController.findByQuery(query));
  }

  /**
   * Test {@link EntityViewController#findByQuery(EntityViewSearchQuery)}.
   *
   * <p>Method under test: {@link EntityViewController#findByQuery(EntityViewSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EntityViewSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityViewController.findByQuery(EntityViewSearchQuery)"})
  void testFindByQuery2() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Requested item wasn't found!");

    EntityViewSearchQuery query = new EntityViewSearchQuery();
    query.setEntityViewTypes(entityViewTypes);
    query.setParameters(
        new RelationsSearchParameters(
            UUID.randomUUID(),
            EntityType.TENANT,
            EntitySearchDirection.FROM,
            RelationTypeGroup.COMMON,
            3,
            true));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityViewController.findByQuery(query));
  }

  /**
   * Test {@link EntityViewController#findByQuery(EntityViewSearchQuery)}.
   *
   * <p>Method under test: {@link EntityViewController#findByQuery(EntityViewSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EntityViewSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityViewController.findByQuery(EntityViewSearchQuery)"})
  void testFindByQuery3() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Requested item wasn't found!");

    EntityViewSearchQuery query = new EntityViewSearchQuery();
    query.setEntityViewTypes(entityViewTypes);
    query.setParameters(
        new RelationsSearchParameters(
            null,
            EntityType.TENANT,
            EntitySearchDirection.FROM,
            RelationTypeGroup.COMMON,
            3,
            true));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityViewController.findByQuery(query));
  }

  /**
   * Test {@link EntityViewController#findByQuery(EntityViewSearchQuery)}.
   *
   * <p>Method under test: {@link EntityViewController#findByQuery(EntityViewSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EntityViewSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityViewController.findByQuery(EntityViewSearchQuery)"})
  void testFindByQuery4() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Requested item wasn't found!");

    EntityViewSearchQuery query = new EntityViewSearchQuery();
    query.setEntityViewTypes(entityViewTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> entityViewController.findByQuery(query));
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityViewController#findByQuery(EntityViewSearchQuery)}.
   *
   * <p>Method under test: {@link EntityViewController#findByQuery(EntityViewSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EntityViewSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityViewController.findByQuery(EntityViewSearchQuery)"})
  void testFindByQuery5() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Requested item wasn't found!");

    EntityViewSearchQuery query = new EntityViewSearchQuery();
    query.setEntityViewTypes(entityViewTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityViewController.findByQuery(query));
    verify(alarmId).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityViewController#findByQuery(EntityViewSearchQuery)}.
   *
   * <p>Method under test: {@link EntityViewController#findByQuery(EntityViewSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EntityViewSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityViewController.findByQuery(EntityViewSearchQuery)"})
  void testFindByQuery6() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Requested item wasn't found!");

    EntityViewSearchQuery query = new EntityViewSearchQuery();
    query.setEntityViewTypes(entityViewTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityViewController.findByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityViewController#findByQuery(EntityViewSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getEntityType()} return {@code RULE_NODE}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#findByQuery(EntityViewSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EntityViewSearchQuery); given AlarmId getEntityType() return 'RULE_NODE'; then calls getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityViewController.findByQuery(EntityViewSearchQuery)"})
  void testFindByQuery_givenAlarmIdGetEntityTypeReturnRuleNode_thenCallsGetEntityType()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Requested item wasn't found!");

    EntityViewSearchQuery query = new EntityViewSearchQuery();
    query.setEntityViewTypes(entityViewTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityViewController.findByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityViewController#findByQuery(EntityViewSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getEntityType()} return {@code TENANT_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#findByQuery(EntityViewSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EntityViewSearchQuery); given AlarmId getEntityType() return 'TENANT_PROFILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityViewController.findByQuery(EntityViewSearchQuery)"})
  void testFindByQuery_givenAlarmIdGetEntityTypeReturnTenantProfile()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT_PROFILE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Requested item wasn't found!");

    EntityViewSearchQuery query = new EntityViewSearchQuery();
    query.setEntityViewTypes(entityViewTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityViewController.findByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityViewController#findByQuery(EntityViewSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#findByQuery(EntityViewSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EntityViewSearchQuery); given AlarmId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityViewController.findByQuery(EntityViewSearchQuery)"})
  void testFindByQuery_givenAlarmIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewSearchQuery query = new EntityViewSearchQuery();
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    query.setParameters(
        new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityViewController.findByQuery(query));
  }

  /**
   * Test {@link EntityViewController#findByQuery(EntityViewSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link RelationsSearchParameters} {@link RelationsSearchParameters#getEntityId()}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#findByQuery(EntityViewSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EntityViewSearchQuery); given RelationsSearchParameters getEntityId() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityViewController.findByQuery(EntityViewSearchQuery)"})
  void testFindByQuery_givenRelationsSearchParametersGetEntityIdReturnNull()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(null);

    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Requested item wasn't found!");

    EntityViewSearchQuery query = new EntityViewSearchQuery();
    query.setEntityViewTypes(entityViewTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityViewController.findByQuery(query));
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityViewController#findByQuery(EntityViewSearchQuery)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityViewSearchQuery#getParameters()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#findByQuery(EntityViewSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EntityViewSearchQuery); then calls getParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityViewController.findByQuery(EntityViewSearchQuery)"})
  void testFindByQuery_thenCallsGetParameters()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider, new DefaultSchedulerComponent(), null);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService =
        new DefaultTbApiUsageStateService(
            null,
            tenantService,
            tsService2,
            null,
            null,
            null,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService tsSubService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, null, apiUsageClient, apiUsageStateService);

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, tsSubService, new BaseTimeseriesService());
    EntityViewController entityViewController = new EntityViewController(tbEntityViewService);

    EntityViewSearchQuery query = mock(EntityViewSearchQuery.class);
    when(query.getParameters()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> entityViewController.findByQuery(query));
    verify(query).getParameters();
  }

  /**
   * Test {@link EntityViewController#findByQuery(EntityViewSearchQuery)}.
   *
   * <ul>
   *   <li>When {@link EntityViewSearchQuery} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#findByQuery(EntityViewSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EntityViewSearchQuery); when EntityViewSearchQuery (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityViewController.findByQuery(EntityViewSearchQuery)"})
  void testFindByQuery_whenEntityViewSearchQuery()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider, new DefaultSchedulerComponent(), null);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService =
        new DefaultTbApiUsageStateService(
            null,
            tenantService,
            tsService2,
            null,
            null,
            null,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService tsSubService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, null, apiUsageClient, apiUsageStateService);

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, tsSubService, new BaseTimeseriesService());
    EntityViewController entityViewController = new EntityViewController(tbEntityViewService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> entityViewController.findByQuery(new EntityViewSearchQuery()));
  }

  /**
   * Test {@link EntityViewController#findByQuery(EntityViewSearchQuery)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#findByQuery(EntityViewSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EntityViewSearchQuery); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityViewController.findByQuery(EntityViewSearchQuery)"})
  void testFindByQuery_whenNull()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider, new DefaultSchedulerComponent(), null);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService =
        new DefaultTbApiUsageStateService(
            null,
            tenantService,
            tsService2,
            null,
            null,
            null,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService tsSubService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, null, apiUsageClient, apiUsageStateService);

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, tsSubService, new BaseTimeseriesService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new EntityViewController(tbEntityViewService).findByQuery(null));
  }

  /**
   * Test {@link EntityViewController#assignEntityViewToPublicCustomer(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#assignEntityViewToPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test assignEntityViewToPublicCustomer(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.EntityView EntityViewController.assignEntityViewToPublicCustomer(String)"
  })
  void testAssignEntityViewToPublicCustomer_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider, new DefaultSchedulerComponent(), null);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService =
        new DefaultTbApiUsageStateService(
            null,
            tenantService,
            tsService2,
            null,
            null,
            null,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService tsSubService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, null, apiUsageClient, apiUsageStateService);

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, tsSubService, new BaseTimeseriesService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new EntityViewController(tbEntityViewService).assignEntityViewToPublicCustomer("42"));
  }

  /**
   * Test {@link EntityViewController#assignEntityViewToPublicCustomer(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#assignEntityViewToPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test assignEntityViewToPublicCustomer(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.EntityView EntityViewController.assignEntityViewToPublicCustomer(String)"
  })
  void testAssignEntityViewToPublicCustomer_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider, new DefaultSchedulerComponent(), null);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService =
        new DefaultTbApiUsageStateService(
            null,
            tenantService,
            tsService2,
            null,
            null,
            null,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService tsSubService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, null, apiUsageClient, apiUsageStateService);

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, tsSubService, new BaseTimeseriesService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new EntityViewController(tbEntityViewService).assignEntityViewToPublicCustomer(""));
  }

  /**
   * Test {@link EntityViewController#assignEntityViewToEdge(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#assignEntityViewToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignEntityViewToEdge(String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.EntityView EntityViewController.assignEntityViewToEdge(String, String)"
  })
  void testAssignEntityViewToEdge_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider, new DefaultSchedulerComponent(), null);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService =
        new DefaultTbApiUsageStateService(
            null,
            tenantService,
            tsService2,
            null,
            null,
            null,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService tsSubService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, null, apiUsageClient, apiUsageStateService);

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, tsSubService, new BaseTimeseriesService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new EntityViewController(tbEntityViewService).assignEntityViewToEdge("42", "42"));
  }

  /**
   * Test {@link EntityViewController#assignEntityViewToEdge(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#assignEntityViewToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignEntityViewToEdge(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.EntityView EntityViewController.assignEntityViewToEdge(String, String)"
  })
  void testAssignEntityViewToEdge_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider, new DefaultSchedulerComponent(), null);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService =
        new DefaultTbApiUsageStateService(
            null,
            tenantService,
            tsService2,
            null,
            null,
            null,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService tsSubService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, null, apiUsageClient, apiUsageStateService);

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, tsSubService, new BaseTimeseriesService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new EntityViewController(tbEntityViewService).assignEntityViewToEdge("", "42"));
  }

  /**
   * Test {@link EntityViewController#assignEntityViewToEdge(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewController#assignEntityViewToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignEntityViewToEdge(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.EntityView EntityViewController.assignEntityViewToEdge(String, String)"
  })
  void testAssignEntityViewToEdge_whenEmptyString2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider, new DefaultSchedulerComponent(), null);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService =
        new DefaultTbApiUsageStateService(
            null,
            tenantService,
            tsService2,
            null,
            null,
            null,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService tsSubService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, null, apiUsageClient, apiUsageStateService);

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, tsSubService, new BaseTimeseriesService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new EntityViewController(tbEntityViewService).assignEntityViewToEdge("42", ""));
  }
}
