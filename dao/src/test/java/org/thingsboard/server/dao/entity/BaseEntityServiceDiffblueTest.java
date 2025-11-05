package org.thingsboard.server.dao.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.NameLabelAndCustomerDetails;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationRequest;
import org.thingsboard.server.common.data.notification.NotificationRequest.NotificationRequestBuilder;
import org.thingsboard.server.common.data.notification.NotificationRequestStats;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
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
import org.thingsboard.server.common.data.query.RelationsQueryFilter;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.notification.DefaultNotificationRequestService;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.NotificationRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {BaseEntityService.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class BaseEntityServiceDiffblueTest {
  @Autowired private BaseEntityService baseEntityService;

  @MockBean private EntityQueryDao entityQueryDao;

  @MockBean private EntityServiceRegistry entityServiceRegistry;

  /**
   * Test {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}
   */
  @Test
  @DisplayName("Test countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  void testCountEntitiesByQuery() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenThrow(new IncorrectParameterException("An error occurred"));
    AlarmDataQuery query = new AlarmDataQuery(entityFilter, new ArrayList<>());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.countEntitiesByQuery(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(entityFilter).getType();
  }

  /**
   * Test {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}
   */
  @Test
  @DisplayName("Test countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  void testCountEntitiesByQuery2() {
    // Arrange
    when(entityQueryDao.countEntitiesByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityCountQuery>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    AlarmDataQuery query = new AlarmDataQuery(entityFilter, new ArrayList<>());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.countEntitiesByQuery(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .countEntitiesByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityCountQuery.class));
  }

  /**
   * Test {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}
   */
  @Test
  @DisplayName(
      "Test countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  void testCountEntitiesByQuery_thenCallsGetId() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));
    EntityFilter entityFilter = mock(EntityFilter.class);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.countEntitiesByQuery(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}
   */
  @Test
  @DisplayName(
      "Test countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  void testCountEntitiesByQuery_thenReturnThree() {
    // Arrange
    when(entityQueryDao.countEntitiesByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityCountQuery>any()))
        .thenReturn(3L);

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    AlarmDataQuery query = new AlarmDataQuery(entityFilter, new ArrayList<>());

    // Act
    long actualCountEntitiesByQueryResult =
        baseEntityService.countEntitiesByQuery(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .countEntitiesByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityCountQuery.class));
    assertEquals(3L, actualCountEntitiesByQueryResult);
  }

  /**
   * Test {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   *
   * <ul>
   *   <li>When {@link EntityCountQuery#EntityCountQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}
   */
  @Test
  @DisplayName(
      "Test countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery); when EntityCountQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  void testCountEntitiesByQuery_whenEntityCountQuery() {
    // Arrange, Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.countEntitiesByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new EntityCountQuery()));
  }

  /**
   * Test {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}
   */
  @Test
  @DisplayName(
      "Test countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery); when 'null'; then throw IncorrectParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  void testCountEntitiesByQuery_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.countEntitiesByQuery(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @DisplayName("Test findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  void testFindEntityDataByQuery() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenThrow(new IncorrectParameterException("An error occurred"));
    EntityDataQuery query = new EntityDataQuery(entityFilter, new ArrayList<>());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.findEntityDataByQuery(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(entityFilter).getType();
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @DisplayName("Test findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  void testFindEntityDataByQuery2() {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityQueryDao.findEntityDataByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityDataQuery>any()))
        .thenReturn(emptyPageDataResult);

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink =
        new EntityDataPageLink(
            3,
            3,
            "Executing findEntityDataByQuery, tenantId [{}], customerId [{}], query [{}]",
            new EntityDataSortOrder());
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult =
        baseEntityService.findEntityDataByQuery(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .findEntityDataByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityDataQuery.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @DisplayName("Test findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  void testFindEntityDataByQuery3() {
    // Arrange
    when(entityQueryDao.findEntityDataByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityDataQuery>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink =
        new EntityDataPageLink(
            3,
            3,
            "Executing findEntityDataByQuery, tenantId [{}], customerId [{}], query [{}]",
            new EntityDataSortOrder());
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.findEntityDataByQuery(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .findEntityDataByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityDataQuery.class));
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @DisplayName("Test findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  void testFindEntityDataByQuery4() {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityQueryDao.findEntityDataByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityDataQuery>any()))
        .thenReturn(emptyPageDataResult);

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 3, null, new EntityDataSortOrder());
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult =
        baseEntityService.findEntityDataByQuery(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .findEntityDataByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityDataQuery.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @DisplayName("Test findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  void testFindEntityDataByQuery5() {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityQueryDao.findEntityDataByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityDataQuery>any()))
        .thenReturn(emptyPageDataResult);

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink = new EntityDataPageLink(3, 3, "", new EntityDataSortOrder());
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult =
        baseEntityService.findEntityDataByQuery(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .findEntityDataByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityDataQuery.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @DisplayName("Test findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  void testFindEntityDataByQuery6() {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityQueryDao.findEntityDataByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityDataQuery>any()))
        .thenReturn(emptyPageDataResult);

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink =
        new EntityDataPageLink(
            3,
            3,
            "Executing findEntityDataByQuery, tenantId [{}], customerId [{}], query [{}]",
            null);
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult =
        baseEntityService.findEntityDataByQuery(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .findEntityDataByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityDataQuery.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @DisplayName("Test findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  void testFindEntityDataByQuery7() {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityQueryDao.findEntityDataByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityDataQuery>any()))
        .thenReturn(emptyPageDataResult);

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink =
        new EntityDataPageLink(
            3,
            3,
            "Executing findEntityDataByQuery, tenantId [{}], customerId [{}], query [{}]",
            new EntityDataSortOrder(
                new EntityKey(
                    EntityKeyType.ATTRIBUTE,
                    "Executing findEntityDataByQuery, tenantId [{}], customerId [{}], query [{}]")));
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult =
        baseEntityService.findEntityDataByQuery(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .findEntityDataByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityDataQuery.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @DisplayName("Test findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  void testFindEntityDataByQuery8() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));
    EntityFilter entityFilter = mock(EntityFilter.class);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.findEntityDataByQuery(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @DisplayName("Test findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  void testFindEntityDataByQuery9() {
    // Arrange
    BaseEntityService baseEntityService = new BaseEntityService();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityDataQuery query = mock(EntityDataQuery.class);
    when(query.getEntityFilter()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseEntityService.findEntityDataByQuery(tenantId, customerId, query));
    verify(customerId).getId();
    verify(tenantId).getId();
    verify(query).getEntityFilter();
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Given {@link EntityFilter} {@link EntityFilter#getType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @DisplayName(
      "Test findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery); given EntityFilter getType() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  void testFindEntityDataByQuery_givenEntityFilterGetTypeReturnNull() {
    // Arrange
    BaseEntityService baseEntityService = new BaseEntityService();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(null);

    EntityDataQuery query = mock(EntityDataQuery.class);
    when(query.getEntityFilter()).thenReturn(entityFilter);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseEntityService.findEntityDataByQuery(tenantId, customerId, query));
    verify(customerId).getId();
    verify(tenantId).getId();
    verify(query, atLeast(1)).getEntityFilter();
    verify(entityFilter).getType();
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Given {@link RelationsQueryFilter} (default constructor) Direction is {@code FROM}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @DisplayName(
      "Test findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery); given RelationsQueryFilter (default constructor) Direction is 'FROM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  void testFindEntityDataByQuery_givenRelationsQueryFilterDirectionIsFrom() {
    // Arrange
    BaseEntityService baseEntityService = new BaseEntityService();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(BaseEntityService.NULL_CUSTOMER_ID);

    EntityDataQuery query = mock(EntityDataQuery.class);
    when(query.getEntityFilter()).thenReturn(relationsQueryFilter);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseEntityService.findEntityDataByQuery(tenantId, customerId, query));
    verify(customerId).getId();
    verify(tenantId).getId();
    verify(query, atLeast(1)).getEntityFilter();
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <ul>
   *   <li>When {@link EntityDataQuery#EntityDataQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @DisplayName(
      "Test findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery); when EntityDataQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  void testFindEntityDataByQuery_whenEntityDataQuery() {
    // Arrange, Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.findEntityDataByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new EntityDataQuery()));
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @DisplayName(
      "Test findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery); when 'null'; then throw IncorrectParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  void testFindEntityDataByQuery_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.findEntityDataByQuery(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test {@link BaseEntityService#fetchEntityName(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code To targets []}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#fetchEntityName(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test fetchEntityName(TenantId, EntityId); then return get() is 'To targets []'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseEntityService.fetchEntityName(TenantId, EntityId)"})
  void testFetchEntityName_thenReturnGetIsToTargets() {
    // Arrange
    JpaNotificationRequestDao notificationRequestDao = mock(JpaNotificationRequestDao.class);

    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);

    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());

    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    when(notificationRequestDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(
            templateResult
                .templateId(
                    new NotificationTemplateId(
                        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build());
    JpaNotificationDao notificationDao =
        new JpaNotificationDao(
            mock(NotificationRepository.class), mock(SqlPartitioningRepository.class));

    DefaultNotificationRequestService defaultNotificationRequestService =
        new DefaultNotificationRequestService(
            notificationRequestDao, notificationDao, mock(ApplicationEventPublisher.class));
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(defaultNotificationRequestService);

    // Act
    Optional<String> actualFetchEntityNameResult =
        baseEntityService.fetchEntityName(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    verify(notificationRequestDao).findById(isA(TenantId.class), isA(UUID.class));
    assertEquals("To targets []", actualFetchEntityNameResult.get());
    assertTrue(actualFetchEntityNameResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityName(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#fetchEntityName(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test fetchEntityName(TenantId, EntityId); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseEntityService.fetchEntityName(TenantId, EntityId)"})
  void testFetchEntityName_thenReturnNotPresent() {
    // Arrange
    JpaNotificationRuleDao notificationRuleDao = mock(JpaNotificationRuleDao.class);
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(null);
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(new DefaultNotificationRuleService(notificationRuleDao));

    // Act
    Optional<String> actualFetchEntityNameResult =
        baseEntityService.fetchEntityName(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualFetchEntityNameResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link JpaNotificationRuleDao} {@link JpaNotificationRuleDao#findById(TenantId,
   *       UUID)} return {@link NotificationRule#NotificationRule()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test fetchEntityLabel(TenantId, EntityId); given JpaNotificationRuleDao findById(TenantId, UUID) return NotificationRule()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseEntityService.fetchEntityLabel(TenantId, EntityId)"})
  void testFetchEntityLabel_givenJpaNotificationRuleDaoFindByIdReturnNotificationRule() {
    // Arrange
    JpaNotificationRuleDao notificationRuleDao = mock(JpaNotificationRuleDao.class);
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new NotificationRule());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(new DefaultNotificationRuleService(notificationRuleDao));

    // Act
    Optional<String> actualFetchEntityLabelResult =
        baseEntityService.fetchEntityLabel(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualFetchEntityLabelResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link JpaNotificationRuleDao} {@link JpaNotificationRuleDao#findById(TenantId,
   *       UUID)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test fetchEntityLabel(TenantId, EntityId); given JpaNotificationRuleDao findById(TenantId, UUID) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseEntityService.fetchEntityLabel(TenantId, EntityId)"})
  void testFetchEntityLabel_givenJpaNotificationRuleDaoFindByIdReturnNull() {
    // Arrange
    JpaNotificationRuleDao notificationRuleDao = mock(JpaNotificationRuleDao.class);
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(null);
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(new DefaultNotificationRuleService(notificationRuleDao));

    // Act
    Optional<String> actualFetchEntityLabelResult =
        baseEntityService.fetchEntityLabel(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualFetchEntityLabelResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityDaoService#findEntity(TenantId, EntityId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test fetchEntityLabel(TenantId, EntityId); then calls findEntity(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseEntityService.fetchEntityLabel(TenantId, EntityId)"})
  void testFetchEntityLabel_thenCallsFindEntity() {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    Optional<HasId<?>> ofResult = Optional.of(mock(HasId.class));
    Mockito.<Optional<HasId<?>>>when(
            entityDaoService.findEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(ofResult);
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(entityDaoService);

    // Act
    Optional<String> actualFetchEntityLabelResult =
        baseEntityService.fetchEntityLabel(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityDaoService).findEntity(isA(TenantId.class), isA(EntityId.class));
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    assertFalse(actualFetchEntityLabelResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code To targets []}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test fetchEntityLabel(TenantId, EntityId); then return get() is 'To targets []'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseEntityService.fetchEntityLabel(TenantId, EntityId)"})
  void testFetchEntityLabel_thenReturnGetIsToTargets() {
    // Arrange
    JpaNotificationRequestDao notificationRequestDao = mock(JpaNotificationRequestDao.class);

    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);

    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());

    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    when(notificationRequestDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(
            templateResult
                .templateId(
                    new NotificationTemplateId(
                        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build());
    JpaNotificationDao notificationDao =
        new JpaNotificationDao(
            mock(NotificationRepository.class), mock(SqlPartitioningRepository.class));

    DefaultNotificationRequestService defaultNotificationRequestService =
        new DefaultNotificationRequestService(
            notificationRequestDao, notificationDao, mock(ApplicationEventPublisher.class));
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(defaultNotificationRequestService);

    // Act
    Optional<String> actualFetchEntityLabelResult =
        baseEntityService.fetchEntityLabel(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    verify(notificationRequestDao).findById(isA(TenantId.class), isA(UUID.class));
    assertEquals("To targets []", actualFetchEntityLabelResult.get());
    assertTrue(actualFetchEntityLabelResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#fetchEntityLabel(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test fetchEntityLabel(TenantId, EntityId); then throw IncorrectParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseEntityService.fetchEntityLabel(TenantId, EntityId)"})
  void testFetchEntityLabel_thenThrowIncorrectParameterException() {
    // Arrange
    NotificationRule notificationRule = mock(NotificationRule.class);
    when(notificationRule.getName())
        .thenThrow(new IncorrectParameterException("An error occurred"));

    JpaNotificationRuleDao notificationRuleDao = mock(JpaNotificationRuleDao.class);
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationRule);
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(new DefaultNotificationRuleService(notificationRuleDao));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.fetchEntityLabel(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(notificationRule).getName();
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseEntityService#fetchEntityCustomerId(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#fetchEntityCustomerId(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test fetchEntityCustomerId(TenantId, EntityId); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseEntityService.fetchEntityCustomerId(TenantId, EntityId)"})
  void testFetchEntityCustomerId_thenReturnNotPresent() {
    // Arrange
    JpaNotificationRuleDao notificationRuleDao = mock(JpaNotificationRuleDao.class);
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(null);
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(new DefaultNotificationRuleService(notificationRuleDao));

    // Act
    Optional<CustomerId> actualFetchEntityCustomerIdResult =
        baseEntityService.fetchEntityCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualFetchEntityCustomerIdResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchEntityCustomerId(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#fetchEntityCustomerId(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test fetchEntityCustomerId(TenantId, EntityId); then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseEntityService.fetchEntityCustomerId(TenantId, EntityId)"})
  void testFetchEntityCustomerId_thenReturnPresent() {
    // Arrange
    JpaNotificationRequestDao notificationRequestDao = mock(JpaNotificationRequestDao.class);

    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);

    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());

    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    when(notificationRequestDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(
            templateResult
                .templateId(
                    new NotificationTemplateId(
                        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build());
    JpaNotificationDao notificationDao =
        new JpaNotificationDao(
            mock(NotificationRepository.class), mock(SqlPartitioningRepository.class));

    DefaultNotificationRequestService defaultNotificationRequestService =
        new DefaultNotificationRequestService(
            notificationRequestDao, notificationDao, mock(ApplicationEventPublisher.class));
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(defaultNotificationRequestService);
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Optional<CustomerId> actualFetchEntityCustomerIdResult =
        baseEntityService.fetchEntityCustomerId(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    verify(notificationRequestDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFetchEntityCustomerIdResult.isPresent());
    assertSame(entityId, actualFetchEntityCustomerIdResult.get());
  }

  /**
   * Test {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName("Test fetchNameLabelAndCustomerDetails(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BaseEntityService.fetchNameLabelAndCustomerDetails(TenantId, EntityId)"
  })
  void testFetchNameLabelAndCustomerDetails() {
    // Arrange
    JpaNotificationRuleDao notificationRuleDao = mock(JpaNotificationRuleDao.class);
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new NotificationRule());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(new DefaultNotificationRuleService(notificationRuleDao));
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Optional<NameLabelAndCustomerDetails> actualFetchNameLabelAndCustomerDetailsResult =
        baseEntityService.fetchNameLabelAndCustomerDetails(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
    NameLabelAndCustomerDetails getResult = actualFetchNameLabelAndCustomerDetailsResult.get();
    assertNull(getResult.getLabel());
    assertNull(getResult.getName());
    assertTrue(actualFetchNameLabelAndCustomerDetailsResult.isPresent());
    assertSame(entityId, getResult.getCustomerId());
  }

  /**
   * Test {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityDaoService#findEntity(TenantId, EntityId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test fetchNameLabelAndCustomerDetails(TenantId, EntityId); then calls findEntity(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BaseEntityService.fetchNameLabelAndCustomerDetails(TenantId, EntityId)"
  })
  void testFetchNameLabelAndCustomerDetails_thenCallsFindEntity() {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    Optional<HasId<?>> ofResult = Optional.of(mock(HasId.class));
    Mockito.<Optional<HasId<?>>>when(
            entityDaoService.findEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(ofResult);
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(entityDaoService);
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Optional<NameLabelAndCustomerDetails> actualFetchNameLabelAndCustomerDetailsResult =
        baseEntityService.fetchNameLabelAndCustomerDetails(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityDaoService).findEntity(isA(TenantId.class), isA(EntityId.class));
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    NameLabelAndCustomerDetails getResult = actualFetchNameLabelAndCustomerDetailsResult.get();
    assertNull(getResult.getLabel());
    assertNull(getResult.getName());
    assertTrue(actualFetchNameLabelAndCustomerDetailsResult.isPresent());
    assertSame(entityId, getResult.getCustomerId());
  }

  /**
   * Test {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} Label is {@code To targets []}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test fetchNameLabelAndCustomerDetails(TenantId, EntityId); then return get() Label is 'To targets []'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BaseEntityService.fetchNameLabelAndCustomerDetails(TenantId, EntityId)"
  })
  void testFetchNameLabelAndCustomerDetails_thenReturnGetLabelIsToTargets() {
    // Arrange
    JpaNotificationRequestDao notificationRequestDao = mock(JpaNotificationRequestDao.class);

    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);

    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());

    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    when(notificationRequestDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(
            templateResult
                .templateId(
                    new NotificationTemplateId(
                        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build());
    JpaNotificationDao notificationDao =
        new JpaNotificationDao(
            mock(NotificationRepository.class), mock(SqlPartitioningRepository.class));

    DefaultNotificationRequestService defaultNotificationRequestService =
        new DefaultNotificationRequestService(
            notificationRequestDao, notificationDao, mock(ApplicationEventPublisher.class));
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(defaultNotificationRequestService);
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Optional<NameLabelAndCustomerDetails> actualFetchNameLabelAndCustomerDetailsResult =
        baseEntityService.fetchNameLabelAndCustomerDetails(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    verify(notificationRequestDao).findById(isA(TenantId.class), isA(UUID.class));
    NameLabelAndCustomerDetails getResult = actualFetchNameLabelAndCustomerDetailsResult.get();
    assertEquals("To targets []", getResult.getLabel());
    assertEquals("To targets []", getResult.getName());
    assertTrue(actualFetchNameLabelAndCustomerDetailsResult.isPresent());
    assertSame(entityId, getResult.getCustomerId());
  }

  /**
   * Test {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName("Test fetchNameLabelAndCustomerDetails(TenantId, EntityId); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BaseEntityService.fetchNameLabelAndCustomerDetails(TenantId, EntityId)"
  })
  void testFetchNameLabelAndCustomerDetails_thenReturnNotPresent() {
    // Arrange
    JpaNotificationRuleDao notificationRuleDao = mock(JpaNotificationRuleDao.class);
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(null);
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(new DefaultNotificationRuleService(notificationRuleDao));

    // Act
    Optional<NameLabelAndCustomerDetails> actualFetchNameLabelAndCustomerDetailsResult =
        baseEntityService.fetchNameLabelAndCustomerDetails(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualFetchNameLabelAndCustomerDetailsResult.isPresent());
  }

  /**
   * Test {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#fetchNameLabelAndCustomerDetails(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test fetchNameLabelAndCustomerDetails(TenantId, EntityId); then throw IncorrectParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BaseEntityService.fetchNameLabelAndCustomerDetails(TenantId, EntityId)"
  })
  void testFetchNameLabelAndCustomerDetails_thenThrowIncorrectParameterException() {
    // Arrange
    NotificationRule notificationRule = mock(NotificationRule.class);
    when(notificationRule.getName())
        .thenThrow(new IncorrectParameterException("An error occurred"));

    JpaNotificationRuleDao notificationRuleDao = mock(JpaNotificationRuleDao.class);
    when(notificationRuleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationRule);
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(new DefaultNotificationRuleService(notificationRuleDao));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.fetchNameLabelAndCustomerDetails(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(notificationRule).getName();
    verify(entityServiceRegistry).getServiceByEntityType(EntityType.CUSTOMER);
    verify(notificationRuleDao).findById(isA(TenantId.class), isA(UUID.class));
  }
}
