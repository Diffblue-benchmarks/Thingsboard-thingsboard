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
package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
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
import org.thingsboard.server.common.data.query.EntityDataPageLink;
import org.thingsboard.server.common.data.query.EntityDataQuery;
import org.thingsboard.server.common.data.query.EntityFilter;
import org.thingsboard.server.common.data.query.EntityFilterType;
import org.thingsboard.server.common.data.query.EntityKey;
import org.thingsboard.server.common.data.query.RelationsQueryFilter;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {DefaultEntityQueryRepository.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultEntityQueryRepositoryDiffblueTest {
  @Autowired private DefaultEntityQueryRepository defaultEntityQueryRepository;

  @MockBean private DefaultQueryLogComponent defaultQueryLogComponent;

  @MockBean private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link DefaultEntityQueryRepository#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}.
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#countEntitiesByQuery(TenantId,
   * CustomerId, EntityCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DefaultEntityQueryRepository.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  public void testCountEntitiesByQuery() throws SQLException, DataAccessException {
    // Arrange
    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    when(jdbcTemplate.queryForObject(
            Mockito.<String>any(), Mockito.<SqlParameterSource>any(), Mockito.<Class<Long>>any()))
        .thenReturn(1L);

    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    doNothing().when(connection).commit();

    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
    TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);

    DefaultEntityQueryRepository defaultEntityQueryRepository =
        new DefaultEntityQueryRepository(
            jdbcTemplate, transactionTemplate, new DefaultQueryLogComponent());

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.API_USAGE_STATE);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act
    long actualCountEntitiesByQueryResult =
        defaultEntityQueryRepository.countEntitiesByQuery(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(jdbcTemplate)
        .queryForObject(
            eq(
                "select count(e.id) from (select aus.id, aus.created_time, aus.tenant_id, aus.entity_id, coalesce((select title from tenant where id = aus.entity_id), (select title from customer where id = aus.entity_id)) as name from api_usage_state as aus) e where 1=1"),
            isA(SqlParameterSource.class),
            isA(Class.class));
    verify(entityFilter, atLeast(1)).getType();
    assertEquals(1L, actualCountEntitiesByQueryResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#countEntitiesByQuery(TenantId, CustomerId,
   * EntityCountQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link SecurityException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#countEntitiesByQuery(TenantId,
   * CustomerId, EntityCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DefaultEntityQueryRepository.countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)"
  })
  public void testCountEntitiesByQuery_thenThrowSecurityException() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenThrow(new SecurityException());

    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.API_USAGE_STATE);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();

    EntityDataQuery query =
        new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues, new ArrayList<>());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            defaultEntityQueryRepository.countEntitiesByQuery(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    verify(entityFilter, atLeast(1)).getType();
  }

  /**
   * Test {@link DefaultEntityQueryRepository#findEntityDataByQueryInternal(EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultEntityQueryRepository#findEntityDataByQueryInternal(EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultEntityQueryRepository.findEntityDataByQueryInternal(EntityDataQuery)"
  })
  public void testFindEntityDataByQueryInternal_thenReturnEmpty_page_data()
      throws TransactionException {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityData> actualFindEntityDataByQueryInternalResult =
        defaultEntityQueryRepository.findEntityDataByQueryInternal(new EntityDataQuery());

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityDataByQueryInternalResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#findEntityDataByQueryInternal(EntityDataQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link SecurityException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultEntityQueryRepository#findEntityDataByQueryInternal(EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultEntityQueryRepository.findEntityDataByQueryInternal(EntityDataQuery)"
  })
  public void testFindEntityDataByQueryInternal_thenThrowSecurityException()
      throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenThrow(new SecurityException());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () -> defaultEntityQueryRepository.findEntityDataByQueryInternal(new EntityDataQuery()));
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery, boolean)} with {@code tenantId}, {@code customerId}, {@code query}, {@code
   * ignorePermissionCheck}.
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId,
   * CustomerId, EntityDataQuery, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultEntityQueryRepository.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery, boolean)"
  })
  public void testFindEntityDataByQueryWithTenantIdCustomerIdQueryIgnorePermissionCheck()
      throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenThrow(new SecurityException());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            defaultEntityQueryRepository.findEntityDataByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new EntityDataQuery(),
                true));
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery, boolean)} with {@code tenantId}, {@code customerId}, {@code query}, {@code
   * ignorePermissionCheck}.
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId,
   * CustomerId, EntityDataQuery, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultEntityQueryRepository.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery, boolean)"
  })
  public void testFindEntityDataByQueryWithTenantIdCustomerIdQueryIgnorePermissionCheck2()
      throws TransactionException {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult =
        defaultEntityQueryRepository.findEntityDataByQuery(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new EntityDataQuery(),
            true);

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)} with {@code tenantId}, {@code customerId}, {@code query}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId,
   * CustomerId, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultEntityQueryRepository.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQueryWithTenantIdCustomerIdQuery_thenReturnEmpty_page_data()
      throws TransactionException {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult =
        defaultEntityQueryRepository.findEntityDataByQuery(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new EntityDataQuery());

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId, CustomerId,
   * EntityDataQuery)} with {@code tenantId}, {@code customerId}, {@code query}.
   *
   * <ul>
   *   <li>Then throw {@link SecurityException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#findEntityDataByQuery(TenantId,
   * CustomerId, EntityDataQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultEntityQueryRepository.findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)"
  })
  public void testFindEntityDataByQueryWithTenantIdCustomerIdQuery_thenThrowSecurityException()
      throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenThrow(new SecurityException());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            defaultEntityQueryRepository.findEntityDataByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new EntityDataQuery()));
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#getLvlFilter(int)}.
   *
   * <ul>
   *   <li>Given {@link NamedParameterJdbcTemplate}.
   *   <li>When three.
   *   <li>Then return {@code and re.lvl <= 2}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#getLvlFilter(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultEntityQueryRepository.getLvlFilter(int)"})
  public void testGetLvlFilter_givenNamedParameterJdbcTemplate_whenThree_thenReturnAndReLvl2() {
    // Arrange, Act and Assert
    assertEquals("and re.lvl <= 2", defaultEntityQueryRepository.getLvlFilter(3));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#getLvlFilter(int)}.
   *
   * <ul>
   *   <li>Given {@link NamedParameterJdbcTemplate}.
   *   <li>When zero.
   *   <li>Then return {@code and re.lvl <= 49}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#getLvlFilter(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultEntityQueryRepository.getLvlFilter(int)"})
  public void testGetLvlFilter_givenNamedParameterJdbcTemplate_whenZero_thenReturnAndReLvl49() {
    // Arrange, Act and Assert
    assertEquals("and re.lvl <= 49", defaultEntityQueryRepository.getLvlFilter(0));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#getLvlFilter(int)}.
   *
   * <ul>
   *   <li>Then return {@code and re.lvl <= -1}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#getLvlFilter(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultEntityQueryRepository.getLvlFilter(int)"})
  public void testGetLvlFilter_thenReturnAndReLvl1() {
    // Arrange
    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();

    DefaultEntityQueryRepository defaultEntityQueryRepository =
        new DefaultEntityQueryRepository(
            jdbcTemplate, transactionTemplate, new DefaultQueryLogComponent());

    // Act and Assert
    assertEquals("and re.lvl <= -1", defaultEntityQueryRepository.getLvlFilter(3));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#getMaxLevel(int)}.
   *
   * <ul>
   *   <li>Given {@link NamedParameterJdbcTemplate}.
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#getMaxLevel(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultEntityQueryRepository.getMaxLevel(int)"})
  public void testGetMaxLevel_givenNamedParameterJdbcTemplate_whenThree_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, defaultEntityQueryRepository.getMaxLevel(3));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#getMaxLevel(int)}.
   *
   * <ul>
   *   <li>Given {@link NamedParameterJdbcTemplate}.
   *   <li>When zero.
   *   <li>Then return fifty.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#getMaxLevel(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultEntityQueryRepository.getMaxLevel(int)"})
  public void testGetMaxLevel_givenNamedParameterJdbcTemplate_whenZero_thenReturnFifty() {
    // Arrange, Act and Assert
    assertEquals(50, defaultEntityQueryRepository.getMaxLevel(0));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#getMaxLevel(int)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#getMaxLevel(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultEntityQueryRepository.getMaxLevel(int)"})
  public void testGetMaxLevel_thenReturnZero() {
    // Arrange
    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();

    DefaultEntityQueryRepository defaultEntityQueryRepository =
        new DefaultEntityQueryRepository(
            jdbcTemplate, transactionTemplate, new DefaultQueryLogComponent());

    // Act and Assert
    assertEquals(0, defaultEntityQueryRepository.getMaxLevel(3));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   *
   * <ul>
   *   <li>Given {@code API_USAGE_STATE}.
   *   <li>Then return {@code API_USAGE_STATE}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DefaultEntityQueryRepository.resolveEntityType(EntityFilter)"})
  public void testResolveEntityType_givenApiUsageState_thenReturnApiUsageState() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.API_USAGE_STATE);

    // Act
    EntityType actualResolveEntityTypeResult =
        DefaultEntityQueryRepository.resolveEntityType(entityFilter);

    // Assert
    verify(entityFilter).getType();
    assertEquals(EntityType.API_USAGE_STATE, actualResolveEntityTypeResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   *
   * <ul>
   *   <li>Given {@code ASSET_SEARCH_QUERY}.
   *   <li>Then return {@code ASSET}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DefaultEntityQueryRepository.resolveEntityType(EntityFilter)"})
  public void testResolveEntityType_givenAssetSearchQuery_thenReturnAsset() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.ASSET_SEARCH_QUERY);

    // Act
    EntityType actualResolveEntityTypeResult =
        DefaultEntityQueryRepository.resolveEntityType(entityFilter);

    // Assert
    verify(entityFilter).getType();
    assertEquals(EntityType.ASSET, actualResolveEntityTypeResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   *
   * <ul>
   *   <li>Given {@code DEVICE_SEARCH_QUERY}.
   *   <li>Then return {@code DEVICE}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DefaultEntityQueryRepository.resolveEntityType(EntityFilter)"})
  public void testResolveEntityType_givenDeviceSearchQuery_thenReturnDevice() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.DEVICE_SEARCH_QUERY);

    // Act
    EntityType actualResolveEntityTypeResult =
        DefaultEntityQueryRepository.resolveEntityType(entityFilter);

    // Assert
    verify(entityFilter).getType();
    assertEquals(EntityType.DEVICE, actualResolveEntityTypeResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   *
   * <ul>
   *   <li>Given {@code EDGE_SEARCH_QUERY}.
   *   <li>Then return {@code EDGE}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DefaultEntityQueryRepository.resolveEntityType(EntityFilter)"})
  public void testResolveEntityType_givenEdgeSearchQuery_thenReturnEdge() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.EDGE_SEARCH_QUERY);

    // Act
    EntityType actualResolveEntityTypeResult =
        DefaultEntityQueryRepository.resolveEntityType(entityFilter);

    // Assert
    verify(entityFilter).getType();
    assertEquals(EntityType.EDGE, actualResolveEntityTypeResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   *
   * <ul>
   *   <li>Given {@code ENTITY_VIEW_SEARCH_QUERY}.
   *   <li>Then return {@code ENTITY_VIEW}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DefaultEntityQueryRepository.resolveEntityType(EntityFilter)"})
  public void testResolveEntityType_givenEntityViewSearchQuery_thenReturnEntityView() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenReturn(EntityFilterType.ENTITY_VIEW_SEARCH_QUERY);

    // Act
    EntityType actualResolveEntityTypeResult =
        DefaultEntityQueryRepository.resolveEntityType(entityFilter);

    // Assert
    verify(entityFilter).getType();
    assertEquals(EntityType.ENTITY_VIEW, actualResolveEntityTypeResult);
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DefaultEntityQueryRepository.resolveEntityType(EntityFilter)"})
  public void testResolveEntityType_givenNull_customer_id_thenReturnCustomer() {
    // Arrange
    RelationsQueryFilter entityFilter = new RelationsQueryFilter();
    entityFilter.setDirection(EntitySearchDirection.FROM);
    entityFilter.setFetchLastLevelOnly(true);
    entityFilter.setFilters(new ArrayList<>());
    entityFilter.setMaxLevel(3);
    entityFilter.setMultiRootEntitiesType(EntityType.TENANT);
    entityFilter.setMultiRootEntityIds(new HashSet<>());
    entityFilter.setNegate(true);
    entityFilter.setRootEntity(BaseEntityService.NULL_CUSTOMER_ID);
    entityFilter.setMultiRoot(false);

    // Act and Assert
    assertEquals(EntityType.CUSTOMER, DefaultEntityQueryRepository.resolveEntityType(entityFilter));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   *
   * <ul>
   *   <li>Given {@link SecurityException#SecurityException()}.
   *   <li>Then throw {@link SecurityException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DefaultEntityQueryRepository.resolveEntityType(EntityFilter)"})
  public void testResolveEntityType_givenSecurityException_thenThrowSecurityException() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    when(entityFilter.getType()).thenThrow(new SecurityException());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () -> DefaultEntityQueryRepository.resolveEntityType(entityFilter));
    verify(entityFilter).getType();
  }

  /**
   * Test {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}.
   *
   * <ul>
   *   <li>When {@link RelationsQueryFilter} (default constructor) MultiRoot is {@code true}.
   *   <li>Then return {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#resolveEntityType(EntityFilter)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DefaultEntityQueryRepository.resolveEntityType(EntityFilter)"})
  public void testResolveEntityType_whenRelationsQueryFilterMultiRootIsTrue_thenReturnTenant() {
    // Arrange
    RelationsQueryFilter entityFilter = new RelationsQueryFilter();
    entityFilter.setDirection(EntitySearchDirection.FROM);
    entityFilter.setFetchLastLevelOnly(true);
    entityFilter.setFilters(new ArrayList<>());
    entityFilter.setMaxLevel(3);
    entityFilter.setMultiRootEntitiesType(EntityType.TENANT);
    entityFilter.setMultiRootEntityIds(new HashSet<>());
    entityFilter.setNegate(true);
    entityFilter.setRootEntity(BaseEntityService.NULL_CUSTOMER_ID);
    entityFilter.setMultiRoot(true);

    // Act and Assert
    assertEquals(EntityType.TENANT, DefaultEntityQueryRepository.resolveEntityType(entityFilter));
  }

  /**
   * Test {@link DefaultEntityQueryRepository#getMaxLevelAllowed()}.
   *
   * <p>Method under test: {@link DefaultEntityQueryRepository#getMaxLevelAllowed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultEntityQueryRepository.getMaxLevelAllowed()"})
  public void testGetMaxLevelAllowed() {
    // Arrange
    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();

    DefaultEntityQueryRepository defaultEntityQueryRepository =
        new DefaultEntityQueryRepository(
            jdbcTemplate, transactionTemplate, new DefaultQueryLogComponent());

    // Act and Assert
    assertEquals(0, defaultEntityQueryRepository.getMaxLevelAllowed());
  }
}
