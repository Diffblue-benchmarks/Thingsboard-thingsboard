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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.common.data.DashboardInfo;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DashboardInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDashboardInfoDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaDashboardInfoDaoDiffblueTest {
  @MockBean private DashboardInfoRepository dashboardInfoRepository;

  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaDashboardInfoDao jpaDashboardInfoDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaDashboardInfoDao#getEntityClass()}
   *   <li>{@link JpaDashboardInfoDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaDashboardInfoDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaDashboardInfoDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaDashboardInfoDao jpaDashboardInfoDao = new JpaDashboardInfoDao();

    // Act
    Class<DashboardInfoEntity> actualEntityClass = jpaDashboardInfoDao.getEntityClass();

    // Assert
    assertNull(jpaDashboardInfoDao.getRepository());
    Class<DashboardInfoEntity> expectedEntityClass = DashboardInfoEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardInfoDao.findDashboardsByTenantId(UUID, PageLink)"})
  public void testFindDashboardsByTenantId_givenDashboardInfoEntityTenantIdIsNull_uuid() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult =
        jpaDashboardInfoDao.findDashboardsByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DashboardInfo> data = actualFindDashboardsByTenantIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDashboardsByTenantIdResult.getTotalElements());
    assertTrue(getResult.isMobileHide());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardInfoDao.findDashboardsByTenantId(UUID, PageLink)"})
  public void testFindDashboardsByTenantId_givenDashboardInfoEntityTenantIdIsRandomUUID() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.randomUUID());
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult =
        jpaDashboardInfoDao.findDashboardsByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DashboardInfo> data = actualFindDashboardsByTenantIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDashboardsByTenantIdResult.getTotalElements());
    assertTrue(getResult.isMobileHide());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardInfoDao.findDashboardsByTenantId(UUID, PageLink)"})
  public void testFindDashboardsByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult =
        jpaDashboardInfoDao.findDashboardsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDashboardsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindDashboardsByTenantIdResult.getTotalPages());
    assertFalse(actualFindDashboardsByTenantIdResult.hasNext());
    assertTrue(actualFindDashboardsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardInfoDao.findDashboardsByTenantId(UUID, PageLink)"})
  public void testFindDashboardsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult =
        jpaDashboardInfoDao.findDashboardsByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDashboardsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindDashboardsByTenantIdResult.getTotalPages());
    assertFalse(actualFindDashboardsByTenantIdResult.hasNext());
    assertTrue(actualFindDashboardsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardInfoDao.findMobileDashboardsByTenantId(UUID, PageLink)"})
  public void testFindMobileDashboardsByTenantId_givenDashboardInfoEntityTenantIdIsNull_uuid() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("mobileOrder");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("mobileOrder");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findMobileByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult =
        jpaDashboardInfoDao.findMobileDashboardsByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findMobileByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DashboardInfo> data = actualFindMobileDashboardsByTenantIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("mobileOrder", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindMobileDashboardsByTenantIdResult.getTotalElements());
    assertTrue(getResult.isMobileHide());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardInfoDao.findMobileDashboardsByTenantId(UUID, PageLink)"})
  public void testFindMobileDashboardsByTenantId_givenDashboardInfoEntityTenantIdIsRandomUUID() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("mobileOrder");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("mobileOrder");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.randomUUID());
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findMobileByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult =
        jpaDashboardInfoDao.findMobileDashboardsByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findMobileByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DashboardInfo> data = actualFindMobileDashboardsByTenantIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("mobileOrder", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindMobileDashboardsByTenantIdResult.getTotalElements());
    assertTrue(getResult.isMobileHide());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardInfoDao.findMobileDashboardsByTenantId(UUID, PageLink)"})
  public void testFindMobileDashboardsByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findMobileByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult =
        jpaDashboardInfoDao.findMobileDashboardsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findMobileByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindMobileDashboardsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindMobileDashboardsByTenantIdResult.getTotalPages());
    assertFalse(actualFindMobileDashboardsByTenantIdResult.hasNext());
    assertTrue(actualFindMobileDashboardsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDashboardInfoDao.findMobileDashboardsByTenantId(UUID, PageLink)"})
  public void testFindMobileDashboardsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findMobileByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult =
        jpaDashboardInfoDao.findMobileDashboardsByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository)
        .findMobileByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindMobileDashboardsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindMobileDashboardsByTenantIdResult.getTotalPages());
    assertFalse(actualFindMobileDashboardsByTenantIdResult.hasNext());
    assertTrue(actualFindMobileDashboardsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDashboardInfoDao.findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndCustomerId() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult =
        jpaDashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DashboardInfo> data = actualFindDashboardsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDashboardsByTenantIdAndCustomerIdResult.getTotalElements());
    assertTrue(getResult.isMobileHide());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDashboardInfoDao.findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndCustomerId2() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.randomUUID());
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult =
        jpaDashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DashboardInfo> data = actualFindDashboardsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindDashboardsByTenantIdAndCustomerIdResult.getTotalElements());
    assertTrue(getResult.isMobileHide());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDashboardInfoDao.findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndCustomerId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult =
        jpaDashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDashboardsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindDashboardsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindDashboardsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindDashboardsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDashboardInfoDao.findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult =
        jpaDashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDashboardsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindDashboardsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindDashboardsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindDashboardsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindMobileDashboardsByTenantIdAndCustomerId() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("mobileOrder");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("mobileOrder");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findMobileByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult =
        jpaDashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findMobileByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DashboardInfo> data = actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("mobileOrder", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getTotalElements());
    assertTrue(getResult.isMobileHide());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindMobileDashboardsByTenantIdAndCustomerId2() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("mobileOrder");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("mobileOrder");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.randomUUID());
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findMobileByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult =
        jpaDashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findMobileByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DashboardInfo> data = actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("mobileOrder", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getTotalElements());
    assertTrue(getResult.isMobileHide());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindMobileDashboardsByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findMobileByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult =
        jpaDashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository)
        .findMobileByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindMobileDashboardsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindMobileDashboardsByTenantIdAndCustomerId_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(dashboardInfoRepository.findMobileByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult =
        jpaDashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findMobileByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindMobileDashboardsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDashboardInfoDao.findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndEdgeId() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers(
        "Try to find dashboards by tenantId [{}], edgeId [{}] and pageLink [{}]");
    dashboardInfoEntity.setCreatedTime(3L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage(
        "Try to find dashboards by tenantId [{}], edgeId [{}] and pageLink [{}]");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(3);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(3L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID edgeId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult =
        jpaDashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, edgeId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DashboardInfo> data = actualFindDashboardsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals(
        "Try to find dashboards by tenantId [{}], edgeId [{}] and pageLink [{}]",
        getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1L, actualFindDashboardsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(3, getResult.getMobileOrder().intValue());
    assertEquals(3L, getResult.getVersion().longValue());
    assertEquals(3L, getResult.getCreatedTime());
    assertTrue(getResult.isMobileHide());
    assertSame(edgeId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDashboardInfoDao.findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndEdgeId2() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers(
        "Try to find dashboards by tenantId [{}], edgeId [{}] and pageLink [{}]");
    dashboardInfoEntity.setCreatedTime(3L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage(
        "Try to find dashboards by tenantId [{}], edgeId [{}] and pageLink [{}]");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(3);
    dashboardInfoEntity.setTenantId(UUID.randomUUID());
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(3L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID edgeId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult =
        jpaDashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, edgeId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DashboardInfo> data = actualFindDashboardsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals(
        "Try to find dashboards by tenantId [{}], edgeId [{}] and pageLink [{}]",
        getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1L, actualFindDashboardsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(3, getResult.getMobileOrder().intValue());
    assertEquals(3L, getResult.getVersion().longValue());
    assertEquals(3L, getResult.getCreatedTime());
    assertTrue(getResult.isMobileHide());
    assertSame(edgeId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDashboardInfoDao.findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndEdgeId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult =
        jpaDashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDashboardsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindDashboardsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindDashboardsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindDashboardsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaDashboardInfoDao.findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndEdgeId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult =
        jpaDashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository)
        .findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDashboardsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindDashboardsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindDashboardsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindDashboardsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findFirstByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findFirstByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DashboardInfo JpaDashboardInfoDao.findFirstByTenantIdAndName(UUID, String)"})
  public void testFindFirstByTenantIdAndName_givenDashboardInfoEntityTenantIdIsNull_uuid() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);
    when(dashboardInfoRepository.findFirstByTenantIdAndTitle(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(dashboardInfoEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    DashboardInfo actualFindFirstByTenantIdAndNameResult =
        jpaDashboardInfoDao.findFirstByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(dashboardInfoRepository).findFirstByTenantIdAndTitle(isA(UUID.class), eq("Name"));
    assertEquals("Dr", actualFindFirstByTenantIdAndNameResult.getName());
    assertEquals("Dr", actualFindFirstByTenantIdAndNameResult.getTitle());
    assertEquals("Image", actualFindFirstByTenantIdAndNameResult.getImage());
    assertNull(actualFindFirstByTenantIdAndNameResult.getAssignedCustomers());
    assertEquals(1, actualFindFirstByTenantIdAndNameResult.getMobileOrder().intValue());
    assertEquals(1L, actualFindFirstByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindFirstByTenantIdAndNameResult.getCreatedTime());
    assertTrue(actualFindFirstByTenantIdAndNameResult.isMobileHide());
    assertSame(tenantId, actualFindFirstByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findFirstByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findFirstByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DashboardInfo JpaDashboardInfoDao.findFirstByTenantIdAndName(UUID, String)"})
  public void testFindFirstByTenantIdAndName_givenDashboardInfoEntityTenantIdIsRandomUUID() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.randomUUID());
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);
    when(dashboardInfoRepository.findFirstByTenantIdAndTitle(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(dashboardInfoEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    DashboardInfo actualFindFirstByTenantIdAndNameResult =
        jpaDashboardInfoDao.findFirstByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(dashboardInfoRepository).findFirstByTenantIdAndTitle(isA(UUID.class), eq("Name"));
    assertEquals("Dr", actualFindFirstByTenantIdAndNameResult.getName());
    assertEquals("Dr", actualFindFirstByTenantIdAndNameResult.getTitle());
    assertEquals("Image", actualFindFirstByTenantIdAndNameResult.getImage());
    assertNull(actualFindFirstByTenantIdAndNameResult.getAssignedCustomers());
    assertEquals(1, actualFindFirstByTenantIdAndNameResult.getMobileOrder().intValue());
    assertEquals(1L, actualFindFirstByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindFirstByTenantIdAndNameResult.getCreatedTime());
    assertTrue(actualFindFirstByTenantIdAndNameResult.isMobileHide());
    assertSame(tenantId, actualFindFirstByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findTitleById(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findTitleById(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JpaDashboardInfoDao.findTitleById(UUID, UUID)"})
  public void testFindTitleById() {
    // Arrange
    when(dashboardInfoRepository.findTitleByTenantIdAndId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn("Dr");

    // Act
    String actualFindTitleByIdResult =
        jpaDashboardInfoDao.findTitleById(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(dashboardInfoRepository).findTitleByTenantIdAndId(isA(UUID.class), isA(UUID.class));
    assertEquals("Dr", actualFindTitleByIdResult);
  }

  /**
   * Test {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(dashboardInfoRepository.findByTenantAndImageLink(
            Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<DashboardInfo> actualFindByTenantAndImageLinkResult =
        jpaDashboardInfoDao.findByTenantAndImageLink(tenantId, "Image Link", 1);

    // Assert
    verify(tenantId).getId();
    verify(dashboardInfoRepository)
        .findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), eq(1));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>Then return first Image is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_thenReturnFirstImageIs42() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("42");
    dashboardInfoEntity.setCreatedTime(-1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("42");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(-1);
    UUID tenantId = UUID.randomUUID();
    dashboardInfoEntity.setTenantId(tenantId);
    dashboardInfoEntity.setTitle("Prof");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(-1L);

    ArrayList<DashboardInfoEntity> dashboardInfoEntityList = new ArrayList<>();
    dashboardInfoEntityList.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findByTenantAndImageLink(
            Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(dashboardInfoEntityList);

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<DashboardInfo> actualFindByTenantAndImageLinkResult =
        jpaDashboardInfoDao.findByTenantAndImageLink(tenantId2, "Image Link", 1);

    // Assert
    verify(tenantId2).getId();
    verify(dashboardInfoRepository)
        .findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), eq(1));
    assertEquals(1, actualFindByTenantAndImageLinkResult.size());
    DashboardInfo getResult = actualFindByTenantAndImageLinkResult.get(0);
    assertEquals("42", getResult.getImage());
    assertEquals("Prof", getResult.getName());
    assertEquals("Prof", getResult.getTitle());
    assertEquals(-1, getResult.getMobileOrder().intValue());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    TenantId tenantId3 = getResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertSame(tenantId, tenantId3.getId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>Then return first Name is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_thenReturnFirstNameIsDr() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    ArrayList<DashboardInfoEntity> dashboardInfoEntityList = new ArrayList<>();
    dashboardInfoEntityList.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findByTenantAndImageLink(
            Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(dashboardInfoEntityList);

    // Act
    List<DashboardInfo> actualFindByTenantAndImageLinkResult =
        jpaDashboardInfoDao.findByTenantAndImageLink(ModelConstants.SYSTEM_TENANT, "Image Link", 1);

    // Assert
    verify(dashboardInfoRepository)
        .findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), eq(1));
    assertEquals(1, actualFindByTenantAndImageLinkResult.size());
    DashboardInfo getResult = actualFindByTenantAndImageLinkResult.get(0);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertSame(TenantId.SYS_TENANT_ID, getResult.getTenantId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(dashboardInfoRepository.findByTenantAndImageLink(
            Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<DashboardInfo> actualFindByTenantAndImageLinkResult =
        jpaDashboardInfoDao.findByTenantAndImageLink(ModelConstants.SYSTEM_TENANT, "Image Link", 1);

    // Assert
    verify(dashboardInfoRepository)
        .findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), eq(1));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findByImageLink(String, int)}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findByImageLink(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByImageLink(String, int)"})
  public void testFindByImageLink_givenDashboardInfoEntityTenantIdIsNull_uuid() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    ArrayList<DashboardInfoEntity> dashboardInfoEntityList = new ArrayList<>();
    dashboardInfoEntityList.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findByImageLink(Mockito.<String>any(), anyInt()))
        .thenReturn(dashboardInfoEntityList);

    // Act
    List<DashboardInfo> actualFindByImageLinkResult =
        jpaDashboardInfoDao.findByImageLink("Image Link", 1);

    // Assert
    verify(dashboardInfoRepository).findByImageLink("Image Link", 1);
    assertEquals(1, actualFindByImageLinkResult.size());
    DashboardInfo getResult = actualFindByImageLinkResult.get(0);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isMobileHide());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findByImageLink(String, int)}.
   *
   * <ul>
   *   <li>Given {@link DashboardInfoEntity#DashboardInfoEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findByImageLink(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByImageLink(String, int)"})
  public void testFindByImageLink_givenDashboardInfoEntityTenantIdIsRandomUUID() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.randomUUID());
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(1L);

    ArrayList<DashboardInfoEntity> dashboardInfoEntityList = new ArrayList<>();
    dashboardInfoEntityList.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findByImageLink(Mockito.<String>any(), anyInt()))
        .thenReturn(dashboardInfoEntityList);

    // Act
    List<DashboardInfo> actualFindByImageLinkResult =
        jpaDashboardInfoDao.findByImageLink("Image Link", 1);

    // Assert
    verify(dashboardInfoRepository).findByImageLink("Image Link", 1);
    assertEquals(1, actualFindByImageLinkResult.size());
    DashboardInfo getResult = actualFindByImageLinkResult.get(0);
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertNull(getResult.getAssignedCustomers());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isMobileHide());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findByImageLink(String, int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaDashboardInfoDao#findByImageLink(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByImageLink(String, int)"})
  public void testFindByImageLink_thenReturnEmpty() {
    // Arrange
    when(dashboardInfoRepository.findByImageLink(Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<DashboardInfo> actualFindByImageLinkResult =
        jpaDashboardInfoDao.findByImageLink("Image Link", 1);

    // Assert
    verify(dashboardInfoRepository).findByImageLink("Image Link", 1);
    assertTrue(actualFindByImageLinkResult.isEmpty());
  }
}
