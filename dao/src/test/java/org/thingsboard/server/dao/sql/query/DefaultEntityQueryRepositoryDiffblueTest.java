package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.EntityCountQuery;
import org.thingsboard.server.common.data.query.EntityData;
import org.thingsboard.server.common.data.query.EntityDataQuery;
import org.thingsboard.server.common.data.query.EntityFilter;
import org.thingsboard.server.common.data.query.EntityFilterType;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {DefaultEntityQueryRepository.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class DefaultEntityQueryRepositoryDiffblueTest {
  @Autowired
  private DefaultEntityQueryRepository defaultEntityQueryRepository;

  @MockBean
  private DefaultQueryLogComponent defaultQueryLogComponent;

  @MockBean
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test
   * {@link DefaultEntityQueryRepository#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   * <ul>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryRepository#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}
   */
  @Test
  public void testCountEntitiesByQuery_thenThrowSecurityException() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.ASSET_TYPE);
    EntityCountQuery query = mock(EntityCountQuery.class);
    when(query.getKeyFilters()).thenThrow(new SecurityException("select count(e.id) from "));
    when(query.getEntityFilter()).thenReturn(entityFilter);

    // Act and Assert
    assertThrows(SecurityException.class, () -> defaultEntityQueryRepository
        .countEntitiesByQuery(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(query).getEntityFilter();
    verify(query).getKeyFilters();
    verify(entityFilter).getType();
  }

  /**
   * Test
   * {@link DefaultEntityQueryRepository#findEntityDataByQueryInternal(EntityDataQuery)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryRepository#findEntityDataByQueryInternal(EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQueryInternal_thenReturnEmpty_page_data() throws TransactionException {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityData> actualFindEntityDataByQueryInternalResult = defaultEntityQueryRepository
        .findEntityDataByQueryInternal(new EntityDataQuery());

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertSame(actualFindEntityDataByQueryInternalResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryInternalResult);
  }

  /**
   * Test
   * {@link DefaultEntityQueryRepository#findEntityDataByQueryInternal(EntityDataQuery)}.
   * <ul>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryRepository#findEntityDataByQueryInternal(EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQueryInternal_thenThrowSecurityException() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenThrow(new SecurityException("foo"));

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> defaultEntityQueryRepository.findEntityDataByQueryInternal(new EntityDataQuery()));
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test
   * {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery, boolean)}
   * with {@code tenantId}, {@code customerId}, {@code query},
   * {@code ignorePermissionCheck}.
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery, boolean)}
   */
  @Test
  public void testFindEntityDataByQueryWithTenantIdCustomerIdQueryIgnorePermissionCheck() throws TransactionException {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult = defaultEntityQueryRepository.findEntityDataByQuery(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new EntityDataQuery(), true);

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertSame(actualFindEntityDataByQueryResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test
   * {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery, boolean)}
   * with {@code tenantId}, {@code customerId}, {@code query},
   * {@code ignorePermissionCheck}.
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery, boolean)}
   */
  @Test
  public void testFindEntityDataByQueryWithTenantIdCustomerIdQueryIgnorePermissionCheck2() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenThrow(new SecurityException("foo"));

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> defaultEntityQueryRepository.findEntityDataByQuery(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, new EntityDataQuery(), true));
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test
   * {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   * with {@code tenantId}, {@code customerId}, {@code query}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQueryWithTenantIdCustomerIdQuery_thenReturnEmpty_page_data()
      throws TransactionException {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult = defaultEntityQueryRepository
        .findEntityDataByQuery(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new EntityDataQuery());

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertSame(actualFindEntityDataByQueryResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test
   * {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   * with {@code tenantId}, {@code customerId}, {@code query}.
   * <ul>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQueryWithTenantIdCustomerIdQuery_thenThrowSecurityException()
      throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenThrow(new SecurityException("foo"));

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> defaultEntityQueryRepository.findEntityDataByQuery(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, new EntityDataQuery()));
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#getLvlFilter(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code and re.lvl <= 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityQueryRepository#getLvlFilter(int)}
   */
  @Test
  public void testGetLvlFilter_whenThree_thenReturnAndReLvl2() {
    // Arrange, Act and Assert
    assertEquals("and re.lvl <= 2", defaultEntityQueryRepository.getLvlFilter(3));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#getLvlFilter(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code and re.lvl <= 49}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityQueryRepository#getLvlFilter(int)}
   */
  @Test
  public void testGetLvlFilter_whenZero_thenReturnAndReLvl49() {
    // Arrange, Act and Assert
    assertEquals("and re.lvl <= 49", defaultEntityQueryRepository.getLvlFilter(0));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#getMaxLevel(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityQueryRepository#getMaxLevel(int)}
   */
  @Test
  public void testGetMaxLevel_whenThree_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, defaultEntityQueryRepository.getMaxLevel(3));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#getMaxLevel(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityQueryRepository#getMaxLevel(int)}
   */
  @Test
  public void testGetMaxLevel_whenZero_thenReturnFifty() {
    // Arrange, Act and Assert
    assertEquals(50, defaultEntityQueryRepository.getMaxLevel(0));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   * <ul>
   *   <li>Given {@code API_USAGE_STATE}.</li>
   *   <li>Then return {@code API_USAGE_STATE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  public void testResolveEntityType_givenApiUsageState_thenReturnApiUsageState() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.API_USAGE_STATE);

    // Act
    EntityType actualResolveEntityTypeResult = DefaultEntityQueryRepository.resolveEntityType(entityFilter);

    // Assert
    verify(entityFilter).getType();
    assertEquals(EntityType.API_USAGE_STATE, actualResolveEntityTypeResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   * <ul>
   *   <li>Given {@code ASSET_TYPE}.</li>
   *   <li>Then return {@code ASSET}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  public void testResolveEntityType_givenAssetType_thenReturnAsset() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.ASSET_TYPE);

    // Act
    EntityType actualResolveEntityTypeResult = DefaultEntityQueryRepository.resolveEntityType(entityFilter);

    // Assert
    verify(entityFilter).getType();
    assertEquals(EntityType.ASSET, actualResolveEntityTypeResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   * <ul>
   *   <li>Given {@code DEVICE_TYPE}.</li>
   *   <li>Then return {@code DEVICE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  public void testResolveEntityType_givenDeviceType_thenReturnDevice() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.DEVICE_TYPE);

    // Act
    EntityType actualResolveEntityTypeResult = DefaultEntityQueryRepository.resolveEntityType(entityFilter);

    // Assert
    verify(entityFilter).getType();
    assertEquals(EntityType.DEVICE, actualResolveEntityTypeResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   * <ul>
   *   <li>Given {@code EDGE_TYPE}.</li>
   *   <li>Then return {@code EDGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  public void testResolveEntityType_givenEdgeType_thenReturnEdge() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.EDGE_TYPE);

    // Act
    EntityType actualResolveEntityTypeResult = DefaultEntityQueryRepository.resolveEntityType(entityFilter);

    // Assert
    verify(entityFilter).getType();
    assertEquals(EntityType.EDGE, actualResolveEntityTypeResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   * <ul>
   *   <li>Given {@code ENTITY_VIEW_TYPE}.</li>
   *   <li>Then return {@code ENTITY_VIEW}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  public void testResolveEntityType_givenEntityViewType_thenReturnEntityView() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.ENTITY_VIEW_TYPE);

    // Act
    EntityType actualResolveEntityTypeResult = DefaultEntityQueryRepository.resolveEntityType(entityFilter);

    // Assert
    verify(entityFilter).getType();
    assertEquals(EntityType.ENTITY_VIEW, actualResolveEntityTypeResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   * <ul>
   *   <li>Given {@link SecurityException#SecurityException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  public void testResolveEntityType_givenSecurityExceptionWithFoo_thenThrowSecurityException() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenThrow(new SecurityException("foo"));

    // Act and Assert
    assertThrows(SecurityException.class, () -> DefaultEntityQueryRepository.resolveEntityType(entityFilter));
    verify(entityFilter).getType();
  }

  /**
   * Test {@link DefaultEntityQueryRepository#getMaxLevelAllowed()}.
   * <p>
   * Method under test: {@link DefaultEntityQueryRepository#getMaxLevelAllowed()}
   */
  @Test
  public void testGetMaxLevelAllowed() {
    // Arrange
    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();

    // Act and Assert
    assertEquals(0,
        (new DefaultEntityQueryRepository(jdbcTemplate, transactionTemplate, new DefaultQueryLogComponent()))
            .getMaxLevelAllowed());
  }
}
