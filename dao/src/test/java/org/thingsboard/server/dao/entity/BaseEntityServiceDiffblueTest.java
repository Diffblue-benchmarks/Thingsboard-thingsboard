package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
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

@ContextConfiguration(classes = {BaseEntityService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseEntityServiceDiffblueTest {
  @Autowired private BaseEntityService baseEntityService;

  @MockBean private EntityQueryDao entityQueryDao;

  /**
   * Test {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  public void testCountEntitiesByQuery() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.countEntitiesByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new AlarmDataQuery(entityFilter, new ArrayList<>())));
    verify(entityFilter).getType();
  }

  /**
   * Test {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  public void testCountEntitiesByQuery2() {
    // Arrange
    when(entityQueryDao.countEntitiesByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityCountQuery>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.countEntitiesByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new AlarmDataQuery(entityFilter, new ArrayList<>())));
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .countEntitiesByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityCountQuery.class));
  }

  /**
   * Test {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   *
   * <ul>
   *   <li>Given {@code FROM}.
   *   <li>When {@link RelationsQueryFilter} (default constructor) RootEntity is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  public void testCountEntitiesByQuery_givenFrom_whenRelationsQueryFilterRootEntityIsNull() {
    // Arrange
    RelationsQueryFilter entityFilter = new RelationsQueryFilter();
    entityFilter.setDirection(EntitySearchDirection.FROM);
    entityFilter.setFetchLastLevelOnly(true);
    entityFilter.setFilters(new ArrayList<>());
    entityFilter.setMaxLevel(3);
    entityFilter.setNegate(true);
    entityFilter.setMultiRoot(false);
    entityFilter.setMultiRootEntitiesType(null);
    entityFilter.setRootEntity(null);
    entityFilter.setMultiRootEntityIds(null);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.countEntitiesByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new EntityCountQuery(entityFilter)));
  }

  /**
   * Test {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  public void testCountEntitiesByQuery_givenNull_customer_id() {
    // Arrange
    when(entityQueryDao.countEntitiesByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityCountQuery>any()))
        .thenReturn(3L);

    RelationsQueryFilter entityFilter = new RelationsQueryFilter();
    entityFilter.setDirection(EntitySearchDirection.FROM);
    entityFilter.setFetchLastLevelOnly(true);
    entityFilter.setFilters(new ArrayList<>());
    entityFilter.setMaxLevel(3);
    entityFilter.setNegate(true);
    entityFilter.setMultiRoot(false);
    entityFilter.setMultiRootEntitiesType(null);
    entityFilter.setRootEntity(BaseEntityService.NULL_CUSTOMER_ID);
    entityFilter.setMultiRootEntityIds(null);

    // Act
    long actualCountEntitiesByQueryResult =
        baseEntityService.countEntitiesByQuery(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new EntityCountQuery(entityFilter));

    // Assert
    verify(entityQueryDao)
        .countEntitiesByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityCountQuery.class));
    assertEquals(3L, actualCountEntitiesByQueryResult);
  }

  /**
   * Test {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link EntityFilter} {@link EntityFilter#getType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  public void testCountEntitiesByQuery_givenNull_whenEntityFilterGetTypeReturnNull() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.countEntitiesByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new AlarmDataQuery(entityFilter, new ArrayList<>())));
    verify(entityFilter).getType();
  }

  /**
   * Test {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   *
   * <ul>
   *   <li>Given {@code SINGLE_ENTITY}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  public void testCountEntitiesByQuery_givenSingleEntity_thenReturnThree() {
    // Arrange
    when(entityQueryDao.countEntitiesByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityCountQuery>any()))
        .thenReturn(3L);
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);

    // Act
    long actualCountEntitiesByQueryResult =
        baseEntityService.countEntitiesByQuery(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new AlarmDataQuery(entityFilter, new ArrayList<>()));

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
   *   <li>Then calls {@link EntityCountQuery#getEntityFilter()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  public void testCountEntitiesByQuery_thenCallsGetEntityFilter() {
    // Arrange
    EntityCountQuery query = mock(EntityCountQuery.class);
    when(query.getEntityFilter()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.countEntitiesByQuery(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(query).getEntityFilter();
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  public void testCountEntitiesByQuery_whenEntityCountQuery() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "long BaseEntityService.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  public void testCountEntitiesByQuery_whenNull_thenThrowIncorrectParameterException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQuery() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.findEntityDataByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new EntityDataQuery(entityFilter, new ArrayList<>())));
    verify(entityFilter).getType();
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQuery2() {
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

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult =
        baseEntityService.findEntityDataByQuery(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new EntityDataQuery(
                entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .findEntityDataByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityDataQuery.class));
    assertSame(
        actualFindEntityDataByQueryResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQuery3() {
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

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.findEntityDataByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new EntityDataQuery(
                    entityFilter, pageLink, entityFields, latestValues, new ArrayList<>())));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQuery4() {
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

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult =
        baseEntityService.findEntityDataByQuery(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new EntityDataQuery(
                entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .findEntityDataByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityDataQuery.class));
    assertSame(
        actualFindEntityDataByQueryResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQuery5() {
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

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult =
        baseEntityService.findEntityDataByQuery(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new EntityDataQuery(
                entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .findEntityDataByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityDataQuery.class));
    assertSame(
        actualFindEntityDataByQueryResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQuery6() {
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

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult =
        baseEntityService.findEntityDataByQuery(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new EntityDataQuery(
                entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .findEntityDataByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityDataQuery.class));
    assertSame(
        actualFindEntityDataByQueryResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQuery7() {
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

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult =
        baseEntityService.findEntityDataByQuery(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new EntityDataQuery(
                entityFilter, pageLink, entityFields, latestValues, new ArrayList<>()));

    // Assert
    verify(entityFilter, atLeast(1)).getType();
    verify(entityQueryDao)
        .findEntityDataByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityDataQuery.class));
    assertSame(
        actualFindEntityDataByQueryResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link EntityFilter} {@link EntityFilter#getType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQuery_givenNull_whenEntityFilterGetTypeReturnNull() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.findEntityDataByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new EntityDataQuery(entityFilter, new ArrayList<>())));
    verify(entityFilter).getType();
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityDataSortOrder#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQuery_thenCallsGetKey() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataSortOrder sortOrder = mock(EntityDataSortOrder.class);
    when(sortOrder.getKey()).thenThrow(new IncorrectParameterException("An error occurred"));
    EntityDataPageLink pageLink =
        new EntityDataPageLink(
            3,
            3,
            "Executing findEntityDataByQuery, tenantId [{}], customerId [{}], query [{}]",
            sortOrder);

    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.findEntityDataByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new EntityDataQuery(
                    entityFilter, pageLink, entityFields, latestValues, new ArrayList<>())));
    verify(sortOrder).getKey();
    verify(entityFilter, atLeast(1)).getType();
  }

  /**
   * Test {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityDataPageLink#getPageSize()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEntityService#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQuery_thenCallsGetPageSize() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.SINGLE_ENTITY);
    EntityDataPageLink pageLink = mock(EntityDataPageLink.class);
    when(pageLink.getPageSize()).thenThrow(new IncorrectParameterException("An error occurred"));
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.findEntityDataByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new EntityDataQuery(
                    entityFilter, pageLink, entityFields, latestValues, new ArrayList<>())));
    verify(pageLink).getPageSize();
    verify(entityFilter, atLeast(1)).getType();
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQuery_whenEntityDataQuery() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseEntityService.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQuery_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseEntityService.findEntityDataByQuery(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }
}
