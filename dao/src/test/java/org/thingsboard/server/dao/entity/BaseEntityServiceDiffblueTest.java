package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.HasUUID;
import org.thingsboard.server.common.data.id.NameLabelAndCustomerDetails;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationRequest;
import org.thingsboard.server.common.data.notification.NotificationRequestStats;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.AlarmDataQuery;
import org.thingsboard.server.common.data.query.EntityCountQuery;
import org.thingsboard.server.common.data.query.EntityData;
import org.thingsboard.server.common.data.query.EntityDataPageLink;
import org.thingsboard.server.common.data.query.EntityDataQuery;
import org.thingsboard.server.common.data.query.EntityDataSortOrder;
import org.thingsboard.server.common.data.query.EntityFilter;
import org.thingsboard.server.common.data.query.EntityFilterType;
import org.thingsboard.server.common.data.query.EntityKey;
import org.thingsboard.server.common.data.query.EntityKeyType;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationRequestEntity;
import org.thingsboard.server.dao.notification.DefaultNotificationRequestService;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.NotificationRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {BaseEntityService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class BaseEntityServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private BaseEntityService baseEntityService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityQueryDao entityQueryDao;

  @MockBean
  private EntityServiceRegistry entityServiceRegistry;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private RelationService relationService;

  /**
   * Test
   * {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   * <p>
   * Method under test:
   * {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}
   */
  @Test
  public void testCountEntitiesByQuery() {
    // Arrange
    when(entityQueryDao.countEntitiesByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<EntityCountQuery>any())).thenThrow(new IncorrectParameterException("An error occurred"));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseEntityService.countEntitiesByQuery(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            new AlarmDataQuery(entityFilter, new ArrayList<>())));
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao).countEntitiesByQuery(isA(TenantId.class), isA(CustomerId.class),
        isA(EntityCountQuery.class));
  }

  /**
   * Test
   * {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   * <p>
   * Method under test:
   * {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}
   */
  @Test
  public void testCountEntitiesByQuery2() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseEntityService.countEntitiesByQuery(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            new EntityCountQuery(entityFilter)));
    verify(entityFilter).getType();
  }

  /**
   * Test
   * {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   * <ul>
   *   <li>Given {@link EntityQueryDao}.</li>
   *   <li>When {@link EntityCountQuery#EntityCountQuery()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}
   */
  @Test
  public void testCountEntitiesByQuery_givenEntityQueryDao_whenEntityCountQuery() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseEntityService.countEntitiesByQuery(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            new EntityCountQuery()));
  }

  /**
   * Test
   * {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   * <ul>
   *   <li>Given {@link EntityQueryDao}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}
   */
  @Test
  public void testCountEntitiesByQuery_givenEntityQueryDao_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> baseEntityService
        .countEntitiesByQuery(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test
   * {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EntityFilter} {@link EntityFilter#getType()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}
   */
  @Test
  public void testCountEntitiesByQuery_givenNull_whenEntityFilterGetTypeReturnNull() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(null);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseEntityService.countEntitiesByQuery(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            new AlarmDataQuery(entityFilter, new ArrayList<>())));
    verify(entityFilter).getType();
  }

  /**
   * Test
   * {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   * <ul>
   *   <li>Given {@code SINGLE_ENTITY}.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}
   */
  @Test
  public void testCountEntitiesByQuery_givenSingleEntity_thenReturnThree() {
    // Arrange
    when(entityQueryDao.countEntitiesByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<EntityCountQuery>any())).thenReturn(3L);
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    long actualCountEntitiesByQueryResult = baseEntityService.countEntitiesByQuery(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, new AlarmDataQuery(entityFilter, new ArrayList<>()));

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao).countEntitiesByQuery(isA(TenantId.class), isA(CustomerId.class),
        isA(EntityCountQuery.class));
    assertEquals(3L, actualCountEntitiesByQueryResult);
  }

  /**
   * Test
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   * <p>
   * Method under test:
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQuery() {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityQueryDao.findEntityDataByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<EntityDataQuery>any())).thenReturn(emptyPageDataResult);
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 3,
        "Executing findEntityDataByQuery, tenantId [{}], customerId [{}], query [{}]", new EntityDataSortOrder());

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult = baseEntityService.findEntityDataByQuery(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao).findEntityDataByQuery(isA(TenantId.class), isA(CustomerId.class),
        isA(EntityDataQuery.class));
    assertSame(actualFindEntityDataByQueryResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   * <p>
   * Method under test:
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQuery2() {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityQueryDao.findEntityDataByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<EntityDataQuery>any())).thenReturn(emptyPageDataResult);
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 3, null, new EntityDataSortOrder());

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult = baseEntityService.findEntityDataByQuery(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao).findEntityDataByQuery(isA(TenantId.class), isA(CustomerId.class),
        isA(EntityDataQuery.class));
    assertSame(actualFindEntityDataByQueryResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   * <p>
   * Method under test:
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQuery3() {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityQueryDao.findEntityDataByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<EntityDataQuery>any())).thenReturn(emptyPageDataResult);
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 3, "", new EntityDataSortOrder());

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult = baseEntityService.findEntityDataByQuery(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao).findEntityDataByQuery(isA(TenantId.class), isA(CustomerId.class),
        isA(EntityDataQuery.class));
    assertSame(actualFindEntityDataByQueryResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   * <p>
   * Method under test:
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQuery4() {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityQueryDao.findEntityDataByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<EntityDataQuery>any())).thenReturn(emptyPageDataResult);
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 3,
        "Executing findEntityDataByQuery, tenantId [{}], customerId [{}], query [{}]", null);

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult = baseEntityService.findEntityDataByQuery(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao).findEntityDataByQuery(isA(TenantId.class), isA(CustomerId.class),
        isA(EntityDataQuery.class));
    assertSame(actualFindEntityDataByQueryResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   * <p>
   * Method under test:
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQuery5() {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityQueryDao.findEntityDataByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<EntityDataQuery>any())).thenReturn(emptyPageDataResult);
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 3,
        "Executing findEntityDataByQuery, tenantId [{}], customerId [{}], query [{}]",
        new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE,
            "Executing findEntityDataByQuery, tenantId [{}], customerId [{}], query [{}]")));

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult = baseEntityService.findEntityDataByQuery(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao).findEntityDataByQuery(isA(TenantId.class), isA(CustomerId.class),
        isA(EntityDataQuery.class));
    assertSame(actualFindEntityDataByQueryResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EntityFilter} {@link EntityFilter#getType()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQuery_givenNull_whenEntityFilterGetTypeReturnNull() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(null);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseEntityService.findEntityDataByQuery(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            new EntityDataQuery(entityFilter, new ArrayList<>())));
    verify(entityFilter).getType();
  }

  /**
   * Test
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   * <ul>
   *   <li>Then calls {@link EntityDataSortOrder#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQuery_thenCallsGetKey() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataSortOrder sortOrder = mock(EntityDataSortOrder.class);
    when(sortOrder.getKey()).thenThrow(new IncorrectParameterException("An error occurred"));
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 3,
        "Executing findEntityDataByQuery, tenantId [{}], customerId [{}], query [{}]", sortOrder);

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseEntityService.findEntityDataByQuery(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>())));
    verify(sortOrder).getKey();
    verify(entityFilter, atLeast(1)).getType();
  }

  /**
   * Test
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   * <ul>
   *   <li>Then calls {@link EntityDataPageLink#getPageSize()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQuery_thenCallsGetPageSize() {
    // Arrange
    new IncorrectParameterException("An error occurred");
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink = mock(EntityDataPageLink.class);
    when(pageLink.getPageSize()).thenThrow(new IncorrectParameterException("An error occurred"));
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseEntityService.findEntityDataByQuery(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>())));
    verify(pageLink).getPageSize();
    verify(entityFilter, atLeast(1)).getType();
  }

  /**
   * Test
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   * <ul>
   *   <li>When {@link EntityDataQuery#EntityDataQuery()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQuery_whenEntityDataQuery() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseEntityService.findEntityDataByQuery(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            new EntityDataQuery()));
  }

  /**
   * Test
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQuery_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> baseEntityService
        .findEntityDataByQuery(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test {@link BaseEntityService#fetchEntityName(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link NotificationRequestRepository}
   * {@link CrudRepository#findById(Object)} return empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#fetchEntityName(TenantId, EntityId)}
   */
  @Test
  public void testFetchEntityName_givenNotificationRequestRepositoryFindByIdReturnEmpty() {
    // Arrange
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    Optional<NotificationRequestEntity> emptyResult = Optional.empty();
    when(notificationRequestRepository.findById(Mockito.<UUID>any())).thenReturn(emptyResult);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    DefaultNotificationRequestService defaultNotificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(defaultNotificationRequestService);

    // Act
    Optional<String> actualFetchEntityNameResult = baseEntityService.fetchEntityName(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationRequestRepository).findById(isA(UUID.class));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.CUSTOMER));
    assertFalse(actualFetchEntityNameResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityName(TenantId, EntityId)}.
   * <ul>
   *   <li>Then calls {@link EntityDaoService#findEntity(TenantId, EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#fetchEntityName(TenantId, EntityId)}
   */
  @Test
  public void testFetchEntityName_thenCallsFindEntity() {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    Optional<HasId<?>> ofResult = Optional.<HasId<?>>of(mock(HasId.class));
    Mockito.<Optional<HasId<?>>>when(entityDaoService.findEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(ofResult);
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    // Act
    Optional<String> actualFetchEntityNameResult = baseEntityService.fetchEntityName(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityDaoService).findEntity(isA(TenantId.class), isA(EntityId.class));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.CUSTOMER));
    assertFalse(actualFetchEntityNameResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityName(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code To targets []}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#fetchEntityName(TenantId, EntityId)}
   */
  @Test
  public void testFetchEntityName_thenReturnGetIsToTargets() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = mock(NotificationRequestEntity.class);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult.templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    when(notificationRequestEntity.toData()).thenReturn(buildResult);
    doNothing().when(notificationRequestEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRequestEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setInfo(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityType(Mockito.<EntityType>any());
    doNothing().when(notificationRequestEntity).setRuleId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setStats(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setStatus(Mockito.<NotificationRequestStatus>any());
    doNothing().when(notificationRequestEntity).setTargets(Mockito.<String>any());
    doNothing().when(notificationRequestEntity).setTemplate(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setTenantId(Mockito.<UUID>any());
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<NotificationRequestEntity> ofResult = Optional.of(notificationRequestEntity);
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    when(notificationRequestRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    DefaultNotificationRequestService defaultNotificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(defaultNotificationRequestService);

    // Act
    Optional<String> actualFetchEntityNameResult = baseEntityService.fetchEntityName(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationRequestRepository).findById(isA(UUID.class));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.CUSTOMER));
    verify(notificationRequestEntity).setCreatedTime(eq(1L));
    verify(notificationRequestEntity).setId(isA(UUID.class));
    verify(notificationRequestEntity).setUuid(isA(UUID.class));
    verify(notificationRequestEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRequestEntity).setInfo(isA(JsonNode.class));
    verify(notificationRequestEntity).setOriginatorEntityId(isA(UUID.class));
    verify(notificationRequestEntity).setOriginatorEntityType(eq(EntityType.TENANT));
    verify(notificationRequestEntity).setRuleId(isA(UUID.class));
    verify(notificationRequestEntity).setStats(isA(JsonNode.class));
    verify(notificationRequestEntity).setStatus(eq(NotificationRequestStatus.PROCESSING));
    verify(notificationRequestEntity).setTargets(eq("Targets"));
    verify(notificationRequestEntity).setTemplate(isA(JsonNode.class));
    verify(notificationRequestEntity).setTemplateId(isA(UUID.class));
    verify(notificationRequestEntity).setTenantId(isA(UUID.class));
    verify(notificationRequestEntity).toData();
    assertEquals("To targets []", actualFetchEntityNameResult.get());
    assertTrue(actualFetchEntityNameResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link NotificationRequestRepository}
   * {@link CrudRepository#findById(Object)} return empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}
   */
  @Test
  public void testFetchEntityLabel_givenNotificationRequestRepositoryFindByIdReturnEmpty() {
    // Arrange
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    Optional<NotificationRequestEntity> emptyResult = Optional.empty();
    when(notificationRequestRepository.findById(Mockito.<UUID>any())).thenReturn(emptyResult);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    DefaultNotificationRequestService defaultNotificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(defaultNotificationRequestService);

    // Act
    Optional<String> actualFetchEntityLabelResult = baseEntityService.fetchEntityLabel(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationRequestRepository).findById(isA(UUID.class));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.CUSTOMER));
    assertFalse(actualFetchEntityLabelResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}.
   * <ul>
   *   <li>Then calls {@link EntityDaoService#findEntity(TenantId, EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}
   */
  @Test
  public void testFetchEntityLabel_thenCallsFindEntity() {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    Optional<HasId<?>> ofResult = Optional.<HasId<?>>of(mock(HasId.class));
    Mockito.<Optional<HasId<?>>>when(entityDaoService.findEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(ofResult);
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    // Act
    Optional<String> actualFetchEntityLabelResult = baseEntityService.fetchEntityLabel(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityDaoService).findEntity(isA(TenantId.class), isA(EntityId.class));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.CUSTOMER));
    assertFalse(actualFetchEntityLabelResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code To targets []}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}
   */
  @Test
  public void testFetchEntityLabel_thenReturnGetIsToTargets() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = mock(NotificationRequestEntity.class);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult.templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    when(notificationRequestEntity.toData()).thenReturn(buildResult);
    doNothing().when(notificationRequestEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRequestEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setInfo(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityType(Mockito.<EntityType>any());
    doNothing().when(notificationRequestEntity).setRuleId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setStats(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setStatus(Mockito.<NotificationRequestStatus>any());
    doNothing().when(notificationRequestEntity).setTargets(Mockito.<String>any());
    doNothing().when(notificationRequestEntity).setTemplate(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setTenantId(Mockito.<UUID>any());
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<NotificationRequestEntity> ofResult = Optional.of(notificationRequestEntity);
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    when(notificationRequestRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    DefaultNotificationRequestService defaultNotificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(defaultNotificationRequestService);

    // Act
    Optional<String> actualFetchEntityLabelResult = baseEntityService.fetchEntityLabel(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationRequestRepository).findById(isA(UUID.class));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.CUSTOMER));
    verify(notificationRequestEntity).setCreatedTime(eq(1L));
    verify(notificationRequestEntity).setId(isA(UUID.class));
    verify(notificationRequestEntity).setUuid(isA(UUID.class));
    verify(notificationRequestEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRequestEntity).setInfo(isA(JsonNode.class));
    verify(notificationRequestEntity).setOriginatorEntityId(isA(UUID.class));
    verify(notificationRequestEntity).setOriginatorEntityType(eq(EntityType.TENANT));
    verify(notificationRequestEntity).setRuleId(isA(UUID.class));
    verify(notificationRequestEntity).setStats(isA(JsonNode.class));
    verify(notificationRequestEntity).setStatus(eq(NotificationRequestStatus.PROCESSING));
    verify(notificationRequestEntity).setTargets(eq("Targets"));
    verify(notificationRequestEntity).setTemplate(isA(JsonNode.class));
    verify(notificationRequestEntity).setTemplateId(isA(UUID.class));
    verify(notificationRequestEntity).setTenantId(isA(UUID.class));
    verify(notificationRequestEntity).toData();
    assertEquals("To targets []", actualFetchEntityLabelResult.get());
    assertTrue(actualFetchEntityLabelResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityCustomerId(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#fetchEntityCustomerId(TenantId, EntityId)}
   */
  @Test
  public void testFetchEntityCustomerId_thenReturnNotPresent() {
    // Arrange
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    Optional<NotificationRequestEntity> emptyResult = Optional.empty();
    when(notificationRequestRepository.findById(Mockito.<UUID>any())).thenReturn(emptyResult);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    DefaultNotificationRequestService defaultNotificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(defaultNotificationRequestService);

    // Act
    Optional<CustomerId> actualFetchEntityCustomerIdResult = baseEntityService
        .fetchEntityCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationRequestRepository).findById(isA(UUID.class));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.CUSTOMER));
    assertFalse(actualFetchEntityCustomerIdResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityCustomerId(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#fetchEntityCustomerId(TenantId, EntityId)}
   */
  @Test
  public void testFetchEntityCustomerId_thenReturnPresent() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = mock(NotificationRequestEntity.class);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult.templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    when(notificationRequestEntity.toData()).thenReturn(buildResult);
    doNothing().when(notificationRequestEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRequestEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setInfo(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityType(Mockito.<EntityType>any());
    doNothing().when(notificationRequestEntity).setRuleId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setStats(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setStatus(Mockito.<NotificationRequestStatus>any());
    doNothing().when(notificationRequestEntity).setTargets(Mockito.<String>any());
    doNothing().when(notificationRequestEntity).setTemplate(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setTenantId(Mockito.<UUID>any());
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<NotificationRequestEntity> ofResult = Optional.of(notificationRequestEntity);
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    when(notificationRequestRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    DefaultNotificationRequestService defaultNotificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(defaultNotificationRequestService);
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Optional<CustomerId> actualFetchEntityCustomerIdResult = baseEntityService
        .fetchEntityCustomerId(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(notificationRequestRepository).findById(isA(UUID.class));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.CUSTOMER));
    verify(notificationRequestEntity).setCreatedTime(eq(1L));
    verify(notificationRequestEntity).setId(isA(UUID.class));
    verify(notificationRequestEntity).setUuid(isA(UUID.class));
    verify(notificationRequestEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRequestEntity).setInfo(isA(JsonNode.class));
    verify(notificationRequestEntity).setOriginatorEntityId(isA(UUID.class));
    verify(notificationRequestEntity).setOriginatorEntityType(eq(EntityType.TENANT));
    verify(notificationRequestEntity).setRuleId(isA(UUID.class));
    verify(notificationRequestEntity).setStats(isA(JsonNode.class));
    verify(notificationRequestEntity).setStatus(eq(NotificationRequestStatus.PROCESSING));
    verify(notificationRequestEntity).setTargets(eq("Targets"));
    verify(notificationRequestEntity).setTemplate(isA(JsonNode.class));
    verify(notificationRequestEntity).setTemplateId(isA(UUID.class));
    verify(notificationRequestEntity).setTenantId(isA(UUID.class));
    verify(notificationRequestEntity).toData();
    assertTrue(actualFetchEntityCustomerIdResult.isPresent());
    assertSame(entityId, actualFetchEntityCustomerIdResult.get());
  }

  /**
   * Test
   * {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} Label is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId, EntityId)}
   */
  @Test
  public void testFetchNameLabelAndCustomerDetails_thenReturnGetLabelIsNull() {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    Optional<HasId<?>> ofResult = Optional.<HasId<?>>of(mock(HasId.class));
    Mockito.<Optional<HasId<?>>>when(entityDaoService.findEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(ofResult);
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Optional<NameLabelAndCustomerDetails> actualFetchNameLabelAndCustomerDetailsResult = baseEntityService
        .fetchNameLabelAndCustomerDetails(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityDaoService).findEntity(isA(TenantId.class), isA(EntityId.class));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.CUSTOMER));
    NameLabelAndCustomerDetails getResult = actualFetchNameLabelAndCustomerDetailsResult.get();
    assertNull(getResult.getLabel());
    assertNull(getResult.getName());
    assertTrue(actualFetchNameLabelAndCustomerDetailsResult.isPresent());
    assertSame(entityId, getResult.getCustomerId());
  }

  /**
   * Test
   * {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} Label is {@code To targets []}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId, EntityId)}
   */
  @Test
  public void testFetchNameLabelAndCustomerDetails_thenReturnGetLabelIsToTargets() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = mock(NotificationRequestEntity.class);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult.templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    when(notificationRequestEntity.toData()).thenReturn(buildResult);
    doNothing().when(notificationRequestEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRequestEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setInfo(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityType(Mockito.<EntityType>any());
    doNothing().when(notificationRequestEntity).setRuleId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setStats(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setStatus(Mockito.<NotificationRequestStatus>any());
    doNothing().when(notificationRequestEntity).setTargets(Mockito.<String>any());
    doNothing().when(notificationRequestEntity).setTemplate(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setTenantId(Mockito.<UUID>any());
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<NotificationRequestEntity> ofResult = Optional.of(notificationRequestEntity);
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    when(notificationRequestRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    DefaultNotificationRequestService defaultNotificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(defaultNotificationRequestService);
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Optional<NameLabelAndCustomerDetails> actualFetchNameLabelAndCustomerDetailsResult = baseEntityService
        .fetchNameLabelAndCustomerDetails(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(notificationRequestRepository).findById(isA(UUID.class));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.CUSTOMER));
    verify(notificationRequestEntity).setCreatedTime(eq(1L));
    verify(notificationRequestEntity).setId(isA(UUID.class));
    verify(notificationRequestEntity).setUuid(isA(UUID.class));
    verify(notificationRequestEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRequestEntity).setInfo(isA(JsonNode.class));
    verify(notificationRequestEntity).setOriginatorEntityId(isA(UUID.class));
    verify(notificationRequestEntity).setOriginatorEntityType(eq(EntityType.TENANT));
    verify(notificationRequestEntity).setRuleId(isA(UUID.class));
    verify(notificationRequestEntity).setStats(isA(JsonNode.class));
    verify(notificationRequestEntity).setStatus(eq(NotificationRequestStatus.PROCESSING));
    verify(notificationRequestEntity).setTargets(eq("Targets"));
    verify(notificationRequestEntity).setTemplate(isA(JsonNode.class));
    verify(notificationRequestEntity).setTemplateId(isA(UUID.class));
    verify(notificationRequestEntity).setTenantId(isA(UUID.class));
    verify(notificationRequestEntity).toData();
    NameLabelAndCustomerDetails getResult = actualFetchNameLabelAndCustomerDetailsResult.get();
    assertEquals("To targets []", getResult.getLabel());
    assertEquals("To targets []", getResult.getName());
    assertTrue(actualFetchNameLabelAndCustomerDetailsResult.isPresent());
    assertSame(entityId, getResult.getCustomerId());
  }

  /**
   * Test
   * {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId, EntityId)}
   */
  @Test
  public void testFetchNameLabelAndCustomerDetails_thenReturnNotPresent() {
    // Arrange
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    Optional<NotificationRequestEntity> emptyResult = Optional.empty();
    when(notificationRequestRepository.findById(Mockito.<UUID>any())).thenReturn(emptyResult);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    DefaultNotificationRequestService defaultNotificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(defaultNotificationRequestService);

    // Act
    Optional<NameLabelAndCustomerDetails> actualFetchNameLabelAndCustomerDetailsResult = baseEntityService
        .fetchNameLabelAndCustomerDetails(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationRequestRepository).findById(isA(UUID.class));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.CUSTOMER));
    assertFalse(actualFetchNameLabelAndCustomerDetailsResult.isPresent());
  }
}
