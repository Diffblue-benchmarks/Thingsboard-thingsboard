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
package org.thingsboard.server.dao.sql.dashboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DashboardEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDashboardDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaDashboardDaoDiffblueTest {
  @MockBean private DashboardRepository dashboardRepository;

  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaDashboardDao jpaDashboardDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaDashboardDao#getEntityClass()}
   *   <li>{@link JpaDashboardDao#getEntityType()}
   *   <li>{@link JpaDashboardDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaDashboardDao.getEntityClass()",
    "EntityType JpaDashboardDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaDashboardDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaDashboardDao jpaDashboardDao = new JpaDashboardDao();

    // Act
    Class<DashboardEntity> actualEntityClass = jpaDashboardDao.getEntityClass();
    EntityType actualEntityType = jpaDashboardDao.getEntityType();

    // Assert
    assertNull(jpaDashboardDao.getRepository());
    assertEquals(EntityType.DASHBOARD, actualEntityType);
    Class<DashboardEntity> expectedEntityClass = DashboardEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaDashboardDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaDashboardDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(dashboardRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Long actualCountByTenantIdResult = jpaDashboardDao.countByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(dashboardRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaDashboardDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaDashboardDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(dashboardRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult =
        jpaDashboardDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(dashboardRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard JpaDashboardDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_givenDashboardEntityTenantIdIsNull_uuid() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);
    when(dashboardRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(dashboardEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    Dashboard actualFindByTenantIdAndExternalIdResult =
        jpaDashboardDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(dashboardRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindByTenantIdAndExternalIdResult.getConfiguration() instanceof ObjectNode);
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getTitle());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    assertNull(actualFindByTenantIdAndExternalIdResult.getAssignedCustomers());
    assertEquals(1, actualFindByTenantIdAndExternalIdResult.getMobileOrder().intValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    List<ObjectNode> entityAliasesConfig =
        actualFindByTenantIdAndExternalIdResult.getEntityAliasesConfig();
    assertTrue(entityAliasesConfig.isEmpty());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isMobileHide());
    assertSame(entityAliasesConfig, actualFindByTenantIdAndExternalIdResult.getWidgetsConfig());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard JpaDashboardDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_givenDashboardEntityTenantIdIsRandomUUID() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(UUID.randomUUID());
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);
    when(dashboardRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(dashboardEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    Dashboard actualFindByTenantIdAndExternalIdResult =
        jpaDashboardDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(dashboardRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindByTenantIdAndExternalIdResult.getConfiguration() instanceof ObjectNode);
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getTitle());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    assertNull(actualFindByTenantIdAndExternalIdResult.getAssignedCustomers());
    assertEquals(1, actualFindByTenantIdAndExternalIdResult.getMobileOrder().intValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    List<ObjectNode> entityAliasesConfig =
        actualFindByTenantIdAndExternalIdResult.getEntityAliasesConfig();
    assertTrue(entityAliasesConfig.isEmpty());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isMobileHide());
    assertSame(entityAliasesConfig, actualFindByTenantIdAndExternalIdResult.getWidgetsConfig());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenDashboardEntityTenantIdIsNull_uuid() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    ArrayList<DashboardEntity> content = new ArrayList<>();
    content.add(dashboardEntity);
    when(dashboardRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Dashboard> actualFindByTenantIdResult =
        jpaDashboardDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<Dashboard> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Dashboard getResult = data.get(0);
    assertTrue(getResult.getConfiguration() instanceof ObjectNode);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    List<ObjectNode> entityAliasesConfig = getResult.getEntityAliasesConfig();
    assertTrue(entityAliasesConfig.isEmpty());
    assertTrue(getResult.isMobileHide());
    assertSame(entityAliasesConfig, getResult.getWidgetsConfig());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenDashboardEntityTenantIdIsRandomUUID() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(UUID.randomUUID());
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    ArrayList<DashboardEntity> content = new ArrayList<>();
    content.add(dashboardEntity);
    when(dashboardRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Dashboard> actualFindByTenantIdResult =
        jpaDashboardDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<Dashboard> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Dashboard getResult = data.get(0);
    assertTrue(getResult.getConfiguration() instanceof ObjectNode);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    List<ObjectNode> entityAliasesConfig = getResult.getEntityAliasesConfig();
    assertTrue(entityAliasesConfig.isEmpty());
    assertTrue(getResult.isMobileHide());
    assertSame(entityAliasesConfig, getResult.getWidgetsConfig());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Dashboard> actualFindByTenantIdResult =
        jpaDashboardDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Dashboard> actualFindByTenantIdResult =
        jpaDashboardDao.findByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardDao#getExternalIdByInternal(DashboardId)} with {@code DashboardId}.
   *
   * <p>Method under test: {@link JpaDashboardDao#getExternalIdByInternal(DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DashboardId JpaDashboardDao.getExternalIdByInternal(DashboardId)"})
  public void testGetExternalIdByInternalWithDashboardId() {
    // Arrange
    when(dashboardRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    DashboardId internalId = new DashboardId(ModelConstants.NULL_UUID);

    // Act
    DashboardId actualExternalIdByInternal = jpaDashboardDao.getExternalIdByInternal(internalId);

    // Assert
    verify(dashboardRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaDashboardDao#getExternalIdByInternal(DashboardId)} with {@code DashboardId}.
   *
   * <p>Method under test: {@link JpaDashboardDao#getExternalIdByInternal(DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DashboardId JpaDashboardDao.getExternalIdByInternal(DashboardId)"})
  public void testGetExternalIdByInternalWithDashboardId2() {
    // Arrange
    when(dashboardRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);

    DashboardId internalId = mock(DashboardId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DashboardId actualExternalIdByInternal = jpaDashboardDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(dashboardRepository).getExternalIdById(isA(UUID.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.DASHBOARD, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaDashboardDao#getExternalIdByInternal(DashboardId)} with {@code DashboardId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#getExternalIdByInternal(DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DashboardId JpaDashboardDao.getExternalIdByInternal(DashboardId)"})
  public void testGetExternalIdByInternalWithDashboardId_thenReturnNull() {
    // Arrange
    when(dashboardRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    DashboardId actualExternalIdByInternal =
        jpaDashboardDao.getExternalIdByInternal(new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantIdAndTitle(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findByTenantIdAndTitle(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDashboardDao.findByTenantIdAndTitle(UUID, String)"})
  public void testFindByTenantIdAndTitle_givenDashboardEntityTenantIdIsNull_uuid() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    ArrayList<DashboardEntity> dashboardEntityList = new ArrayList<>();
    dashboardEntityList.add(dashboardEntity);
    when(dashboardRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(dashboardEntityList);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    List<Dashboard> actualFindByTenantIdAndTitleResult =
        jpaDashboardDao.findByTenantIdAndTitle(tenantId, "Dr");

    // Assert
    verify(dashboardRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
    assertEquals(1, actualFindByTenantIdAndTitleResult.size());
    Dashboard getResult = actualFindByTenantIdAndTitleResult.get(0);
    assertTrue(getResult.getConfiguration() instanceof ObjectNode);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    List<ObjectNode> entityAliasesConfig = getResult.getEntityAliasesConfig();
    assertTrue(entityAliasesConfig.isEmpty());
    assertTrue(getResult.isMobileHide());
    assertSame(entityAliasesConfig, getResult.getWidgetsConfig());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantIdAndTitle(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link DashboardEntity#DashboardEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findByTenantIdAndTitle(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDashboardDao.findByTenantIdAndTitle(UUID, String)"})
  public void testFindByTenantIdAndTitle_givenDashboardEntityTenantIdIsRandomUUID() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(UUID.randomUUID());
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    ArrayList<DashboardEntity> dashboardEntityList = new ArrayList<>();
    dashboardEntityList.add(dashboardEntity);
    when(dashboardRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(dashboardEntityList);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    List<Dashboard> actualFindByTenantIdAndTitleResult =
        jpaDashboardDao.findByTenantIdAndTitle(tenantId, "Dr");

    // Assert
    verify(dashboardRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
    assertEquals(1, actualFindByTenantIdAndTitleResult.size());
    Dashboard getResult = actualFindByTenantIdAndTitleResult.get(0);
    assertTrue(getResult.getConfiguration() instanceof ObjectNode);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    List<ObjectNode> entityAliasesConfig = getResult.getEntityAliasesConfig();
    assertTrue(entityAliasesConfig.isEmpty());
    assertTrue(getResult.isMobileHide());
    assertSame(entityAliasesConfig, getResult.getWidgetsConfig());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantIdAndTitle(UUID, String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findByTenantIdAndTitle(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDashboardDao.findByTenantIdAndTitle(UUID, String)"})
  public void testFindByTenantIdAndTitle_thenReturnEmpty() {
    // Arrange
    when(dashboardRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Dashboard> actualFindByTenantIdAndTitleResult =
        jpaDashboardDao.findByTenantIdAndTitle(ModelConstants.NULL_UUID, "Dr");

    // Assert
    verify(dashboardRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
    assertTrue(actualFindByTenantIdAndTitleResult.isEmpty());
  }

  /**
   * Test {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)} with {@code TenantId},
   * {@code PageLink}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardDao.findIdsByTenantId(TenantId, PageLink)"})
  public void testFindIdsByTenantIdWithTenantIdPageLink_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardId> actualFindIdsByTenantIdResult =
        jpaDashboardDao.findIdsByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)} with {@code TenantId},
   * {@code PageLink}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardDao.findIdsByTenantId(TenantId, PageLink)"})
  public void testFindIdsByTenantIdWithTenantIdPageLink_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    when(dashboardRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardId> actualFindIdsByTenantIdResult =
        jpaDashboardDao.findIdsByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    List<DashboardId> data = actualFindIdsByTenantIdResult.getData();
    assertEquals(1, data.size());
    DashboardId getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(1L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(EntityType.DASHBOARD, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
  }

  /**
   * Test {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)} with {@code TenantId},
   * {@code PageLink}.
   *
   * <ul>
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardDao.findIdsByTenantId(TenantId, PageLink)"})
  public void testFindIdsByTenantIdWithTenantIdPageLink_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    when(dashboardRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardId> actualFindIdsByTenantIdResult =
        jpaDashboardDao.findIdsByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    List<DashboardId> data = actualFindIdsByTenantIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindIdsByTenantIdResult.getTotalElements());
    DashboardId expectedGetResult = data.get(0);
    assertEquals(expectedGetResult, data.get(1));
  }

  /**
   * Test {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)} with {@code TenantId},
   * {@code PageLink}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardDao.findIdsByTenantId(TenantId, PageLink)"})
  public void testFindIdsByTenantIdWithTenantIdPageLink_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardId> actualFindIdsByTenantIdResult =
        jpaDashboardDao.findIdsByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)} with {@code TenantId},
   * {@code PageLink}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardDao.findIdsByTenantId(TenantId, PageLink)"})
  public void testFindIdsByTenantIdWithTenantIdPageLink_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(dashboardRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<DashboardId> actualFindIdsByTenantIdResult =
        jpaDashboardDao.findIdsByTenantId(tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(dashboardRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardDao#findAllIds(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findAllIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardDao.findAllIds(PageLink)"})
  public void testFindAllIds_givenArrayListAddNull_uuid_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    when(dashboardRepository.findAllIds(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardId> actualFindAllIdsResult = jpaDashboardDao.findAllIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardRepository).findAllIds(isA(Pageable.class));
    List<DashboardId> data = actualFindAllIdsResult.getData();
    assertEquals(1, data.size());
    DashboardId getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(1L, actualFindAllIdsResult.getTotalElements());
    assertEquals(EntityType.DASHBOARD, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
  }

  /**
   * Test {@link JpaDashboardDao#findAllIds(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findAllIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardDao.findAllIds(PageLink)"})
  public void testFindAllIds_givenArrayListAddNull_uuid_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    when(dashboardRepository.findAllIds(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardId> actualFindAllIdsResult = jpaDashboardDao.findAllIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardRepository).findAllIds(isA(Pageable.class));
    List<DashboardId> data = actualFindAllIdsResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAllIdsResult.getTotalElements());
    DashboardId expectedGetResult = data.get(0);
    assertEquals(expectedGetResult, data.get(1));
  }

  /**
   * Test {@link JpaDashboardDao#findAllIds(PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findAllIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardDao.findAllIds(PageLink)"})
  public void testFindAllIds_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardRepository.findAllIds(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardId> actualFindAllIdsResult = jpaDashboardDao.findAllIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardRepository).findAllIds(isA(Pageable.class));
    assertEquals(0L, actualFindAllIdsResult.getTotalElements());
    assertEquals(1, actualFindAllIdsResult.getTotalPages());
    assertFalse(actualFindAllIdsResult.hasNext());
    assertTrue(actualFindAllIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardDao#findAllIds(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardDao#findAllIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardDao.findAllIds(PageLink)"})
  public void testFindAllIds_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardRepository.findAllIds(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardId> actualFindAllIdsResult =
        jpaDashboardDao.findAllIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardRepository).findAllIds(isA(Pageable.class));
    assertEquals(0L, actualFindAllIdsResult.getTotalElements());
    assertEquals(1, actualFindAllIdsResult.getTotalPages());
    assertFalse(actualFindAllIdsResult.hasNext());
    assertTrue(actualFindAllIdsResult.getData().isEmpty());
  }
}
