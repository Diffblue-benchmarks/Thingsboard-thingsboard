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
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DashboardInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDashboardInfoDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaDashboardInfoDaoDiffblueTest {
  @MockBean
  private DashboardInfoRepository dashboardInfoRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaDashboardInfoDao jpaDashboardInfoDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaDashboardInfoDao#getEntityClass()}
   *   <li>{@link JpaDashboardInfoDao#getRepository()}
   * </ul>
   */
  @Test
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
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantId() {
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
    PageImpl<DashboardInfoEntity> pageImpl = new PageImpl<>(content);
    when(dashboardInfoRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult = jpaDashboardInfoDao
        .findDashboardsByTenantId(tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<DashboardInfo> data = actualFindDashboardsByTenantIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    DashboardId id = getResult.getId();
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(getResult.isMobileHide());
    assertTrue(id.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, id.getId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult = jpaDashboardInfoDao
        .findDashboardsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDashboardsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindDashboardsByTenantIdResult.getTotalPages());
    assertFalse(actualFindDashboardsByTenantIdResult.hasNext());
    assertTrue(actualFindDashboardsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link DashboardInfo#DashboardInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantId_thenReturnDataFirstIsDashboardInfo() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = mock(DashboardInfoEntity.class);
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoEntity.toData()).thenReturn(dashboardInfo);
    doNothing().when(dashboardInfoEntity).setCreatedTime(anyLong());
    doNothing().when(dashboardInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(dashboardInfoEntity).setAssignedCustomers(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setMobileHide(anyBoolean());
    doNothing().when(dashboardInfoEntity).setMobileOrder(Mockito.<Integer>any());
    doNothing().when(dashboardInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setTitle(Mockito.<String>any());
    dashboardInfoEntity.setAssignedCustomers("42");
    dashboardInfoEntity.setCreatedTime(-1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("42");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(-1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Prof");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(-1L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    PageImpl<DashboardInfoEntity> pageImpl = new PageImpl<>(content);
    when(dashboardInfoRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult = jpaDashboardInfoDao
        .findDashboardsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoEntity).setCreatedTime(eq(-1L));
    verify(dashboardInfoEntity).setId(isA(UUID.class));
    verify(dashboardInfoEntity).setUuid(isA(UUID.class));
    verify(dashboardInfoEntity).setVersion(eq(-1L));
    verify(dashboardInfoEntity).setAssignedCustomers(eq("42"));
    verify(dashboardInfoEntity).setImage(eq("42"));
    verify(dashboardInfoEntity).setMobileHide(eq(true));
    verify(dashboardInfoEntity).setMobileOrder(eq(-1));
    verify(dashboardInfoEntity).setTenantId(isA(UUID.class));
    verify(dashboardInfoEntity).setTitle(eq("Prof"));
    verify(dashboardInfoEntity).toData();
    verify(dashboardInfoRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DashboardInfo> data = actualFindDashboardsByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(dashboardInfo, data.get(0));
  }

  /**
   * Test {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findDashboardsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult = jpaDashboardInfoDao
        .findDashboardsByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDashboardsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindDashboardsByTenantIdResult.getTotalPages());
    assertFalse(actualFindDashboardsByTenantIdResult.hasNext());
    assertTrue(actualFindDashboardsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantId() {
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
    PageImpl<DashboardInfoEntity> pageImpl = new PageImpl<>(content);
    when(dashboardInfoRepository.findMobileByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult = jpaDashboardInfoDao
        .findMobileDashboardsByTenantId(tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository).findMobileByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<DashboardInfo> data = actualFindMobileDashboardsByTenantIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("mobileOrder", getResult.getImage());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    DashboardId id = getResult.getId();
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(getResult.isMobileHide());
    assertTrue(id.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, id.getId());
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findMobileByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult = jpaDashboardInfoDao
        .findMobileDashboardsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository).findMobileByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindMobileDashboardsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindMobileDashboardsByTenantIdResult.getTotalPages());
    assertFalse(actualFindMobileDashboardsByTenantIdResult.hasNext());
    assertTrue(actualFindMobileDashboardsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link DashboardInfo#DashboardInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantId_thenReturnDataFirstIsDashboardInfo() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = mock(DashboardInfoEntity.class);
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoEntity.toData()).thenReturn(dashboardInfo);
    doNothing().when(dashboardInfoEntity).setCreatedTime(anyLong());
    doNothing().when(dashboardInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(dashboardInfoEntity).setAssignedCustomers(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setMobileHide(anyBoolean());
    doNothing().when(dashboardInfoEntity).setMobileOrder(Mockito.<Integer>any());
    doNothing().when(dashboardInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setTitle(Mockito.<String>any());
    dashboardInfoEntity.setAssignedCustomers("java.util.HashSet");
    dashboardInfoEntity.setCreatedTime(-1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("java.util.HashSet");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(-1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Prof");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(-1L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    PageImpl<DashboardInfoEntity> pageImpl = new PageImpl<>(content);
    when(dashboardInfoRepository.findMobileByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult = jpaDashboardInfoDao
        .findMobileDashboardsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(dashboardInfoEntity).setCreatedTime(eq(-1L));
    verify(dashboardInfoEntity).setId(isA(UUID.class));
    verify(dashboardInfoEntity).setUuid(isA(UUID.class));
    verify(dashboardInfoEntity).setVersion(eq(-1L));
    verify(dashboardInfoEntity).setAssignedCustomers(eq("java.util.HashSet"));
    verify(dashboardInfoEntity).setImage(eq("java.util.HashSet"));
    verify(dashboardInfoEntity).setMobileHide(eq(true));
    verify(dashboardInfoEntity).setMobileOrder(eq(-1));
    verify(dashboardInfoEntity).setTenantId(isA(UUID.class));
    verify(dashboardInfoEntity).setTitle(eq("Prof"));
    verify(dashboardInfoEntity).toData();
    verify(dashboardInfoRepository).findMobileByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<DashboardInfo> data = actualFindMobileDashboardsByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(dashboardInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findMobileByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult = jpaDashboardInfoDao
        .findMobileDashboardsByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository).findMobileByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindMobileDashboardsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindMobileDashboardsByTenantIdResult.getTotalPages());
    assertFalse(actualFindMobileDashboardsByTenantIdResult.hasNext());
    assertTrue(actualFindMobileDashboardsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
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
    PageImpl<DashboardInfoEntity> pageImpl = new PageImpl<>(content);
    when(dashboardInfoRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID customerId = ModelConstants.NULL_UUID;

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult = jpaDashboardInfoDao
        .findDashboardsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, customerId,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    List<DashboardInfo> data = actualFindDashboardsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    DashboardId id = getResult.getId();
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(getResult.isMobileHide());
    assertTrue(id.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(customerId, getResult.getUuidId());
    assertSame(customerId, id.getId());
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndCustomerId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult = jpaDashboardInfoDao
        .findDashboardsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindDashboardsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindDashboardsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindDashboardsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindDashboardsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link DashboardInfo#DashboardInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndCustomerId_thenReturnDataFirstIsDashboardInfo() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = mock(DashboardInfoEntity.class);
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoEntity.toData()).thenReturn(dashboardInfo);
    doNothing().when(dashboardInfoEntity).setCreatedTime(anyLong());
    doNothing().when(dashboardInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(dashboardInfoEntity).setAssignedCustomers(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setMobileHide(anyBoolean());
    doNothing().when(dashboardInfoEntity).setMobileOrder(Mockito.<Integer>any());
    doNothing().when(dashboardInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setTitle(Mockito.<String>any());
    dashboardInfoEntity.setAssignedCustomers("42");
    dashboardInfoEntity.setCreatedTime(-1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("42");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(-1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Prof");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(-1L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    PageImpl<DashboardInfoEntity> pageImpl = new PageImpl<>(content);
    when(dashboardInfoRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult = jpaDashboardInfoDao
        .findDashboardsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoEntity).setCreatedTime(eq(-1L));
    verify(dashboardInfoEntity).setId(isA(UUID.class));
    verify(dashboardInfoEntity).setUuid(isA(UUID.class));
    verify(dashboardInfoEntity).setVersion(eq(-1L));
    verify(dashboardInfoEntity).setAssignedCustomers(eq("42"));
    verify(dashboardInfoEntity).setImage(eq("42"));
    verify(dashboardInfoEntity).setMobileHide(eq(true));
    verify(dashboardInfoEntity).setMobileOrder(eq(-1));
    verify(dashboardInfoEntity).setTenantId(isA(UUID.class));
    verify(dashboardInfoEntity).setTitle(eq("Prof"));
    verify(dashboardInfoEntity).toData();
    verify(dashboardInfoRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<DashboardInfo> data = actualFindDashboardsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    assertSame(dashboardInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult = jpaDashboardInfoDao
        .findDashboardsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindDashboardsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindDashboardsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindDashboardsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindDashboardsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
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
    PageImpl<DashboardInfoEntity> pageImpl = new PageImpl<>(content);
    when(dashboardInfoRepository.findMobileByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID customerId = ModelConstants.NULL_UUID;

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult = jpaDashboardInfoDao
        .findMobileDashboardsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, customerId,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository).findMobileByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    List<DashboardInfo> data = actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("mobileOrder", getResult.getImage());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    DashboardId id = getResult.getId();
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(getResult.isMobileHide());
    assertTrue(id.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(customerId, getResult.getUuidId());
    assertSame(customerId, id.getId());
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantIdAndCustomerId2() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = mock(DashboardInfoEntity.class);
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoEntity.toData()).thenReturn(dashboardInfo);
    doNothing().when(dashboardInfoEntity).setCreatedTime(anyLong());
    doNothing().when(dashboardInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(dashboardInfoEntity).setAssignedCustomers(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setMobileHide(anyBoolean());
    doNothing().when(dashboardInfoEntity).setMobileOrder(Mockito.<Integer>any());
    doNothing().when(dashboardInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setTitle(Mockito.<String>any());
    dashboardInfoEntity.setAssignedCustomers("java.util.HashSet");
    dashboardInfoEntity.setCreatedTime(-1L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("java.util.HashSet");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(-1);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Prof");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(-1L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    PageImpl<DashboardInfoEntity> pageImpl = new PageImpl<>(content);
    when(dashboardInfoRepository.findMobileByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult = jpaDashboardInfoDao
        .findMobileDashboardsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(dashboardInfoEntity).setCreatedTime(eq(-1L));
    verify(dashboardInfoEntity).setId(isA(UUID.class));
    verify(dashboardInfoEntity).setUuid(isA(UUID.class));
    verify(dashboardInfoEntity).setVersion(eq(-1L));
    verify(dashboardInfoEntity).setAssignedCustomers(eq("java.util.HashSet"));
    verify(dashboardInfoEntity).setImage(eq("java.util.HashSet"));
    verify(dashboardInfoEntity).setMobileHide(eq(true));
    verify(dashboardInfoEntity).setMobileOrder(eq(-1));
    verify(dashboardInfoEntity).setTenantId(isA(UUID.class));
    verify(dashboardInfoEntity).setTitle(eq("Prof"));
    verify(dashboardInfoEntity).toData();
    verify(dashboardInfoRepository).findMobileByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class),
        eq("Text Search"), isA(Pageable.class));
    List<DashboardInfo> data = actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    assertSame(dashboardInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findMobileByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult = jpaDashboardInfoDao
        .findMobileDashboardsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository).findMobileByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindMobileDashboardsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findMobileDashboardsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantIdAndCustomerId_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(dashboardInfoRepository.findMobileByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult = jpaDashboardInfoDao
        .findMobileDashboardsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository).findMobileByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindMobileDashboardsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindMobileDashboardsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndEdgeId() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Try to find dashboards by tenantId [{}], edgeId [{}] and pageLink [{}]");
    dashboardInfoEntity.setCreatedTime(3L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("Try to find dashboards by tenantId [{}], edgeId [{}] and pageLink [{}]");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(3);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(3L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    PageImpl<DashboardInfoEntity> pageImpl = new PageImpl<>(content);
    when(dashboardInfoRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID edgeId = ModelConstants.NULL_UUID;

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult = jpaDashboardInfoDao
        .findDashboardsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, edgeId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    List<DashboardInfo> data = actualFindDashboardsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    DashboardInfo getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Try to find dashboards by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getImage());
    assertEquals(3, getResult.getMobileOrder().intValue());
    assertEquals(3L, getResult.getVersion().longValue());
    assertEquals(3L, getResult.getCreatedTime());
    DashboardId id = getResult.getId();
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(getResult.isMobileHide());
    assertTrue(id.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(edgeId, getResult.getUuidId());
    assertSame(edgeId, id.getId());
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndEdgeId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult = jpaDashboardInfoDao
        .findDashboardsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindDashboardsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindDashboardsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindDashboardsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindDashboardsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link DashboardInfo#DashboardInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndEdgeId_thenReturnDataFirstIsDashboardInfo() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = mock(DashboardInfoEntity.class);
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoEntity.toData()).thenReturn(dashboardInfo);
    doNothing().when(dashboardInfoEntity).setCreatedTime(anyLong());
    doNothing().when(dashboardInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(dashboardInfoEntity).setAssignedCustomers(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setMobileHide(anyBoolean());
    doNothing().when(dashboardInfoEntity).setMobileOrder(Mockito.<Integer>any());
    doNothing().when(dashboardInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setTitle(Mockito.<String>any());
    dashboardInfoEntity.setAssignedCustomers("java.util.HashSet");
    dashboardInfoEntity.setCreatedTime(2L);
    dashboardInfoEntity.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setImage("java.util.HashSet");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(2);
    dashboardInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setTitle("Prof");
    dashboardInfoEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity.setVersion(2L);

    ArrayList<DashboardInfoEntity> content = new ArrayList<>();
    content.add(dashboardInfoEntity);
    PageImpl<DashboardInfoEntity> pageImpl = new PageImpl<>(content);
    when(dashboardInfoRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult = jpaDashboardInfoDao
        .findDashboardsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardInfoEntity).setCreatedTime(eq(2L));
    verify(dashboardInfoEntity).setId(isA(UUID.class));
    verify(dashboardInfoEntity).setUuid(isA(UUID.class));
    verify(dashboardInfoEntity).setVersion(eq(2L));
    verify(dashboardInfoEntity).setAssignedCustomers(eq("java.util.HashSet"));
    verify(dashboardInfoEntity).setImage(eq("java.util.HashSet"));
    verify(dashboardInfoEntity).setMobileHide(eq(true));
    verify(dashboardInfoEntity).setMobileOrder(eq(2));
    verify(dashboardInfoEntity).setTenantId(isA(UUID.class));
    verify(dashboardInfoEntity).setTitle(eq("Prof"));
    verify(dashboardInfoEntity).toData();
    verify(dashboardInfoRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<DashboardInfo> data = actualFindDashboardsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    assertSame(dashboardInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findDashboardsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndEdgeId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardInfoRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult = jpaDashboardInfoDao
        .findDashboardsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindDashboardsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindDashboardsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindDashboardsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindDashboardsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findFirstByTenantIdAndName(UUID, String)}.
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findFirstByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindFirstByTenantIdAndName() {
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
    when(dashboardInfoRepository.findFirstByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(dashboardInfoEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    DashboardInfo actualFindFirstByTenantIdAndNameResult = jpaDashboardInfoDao.findFirstByTenantIdAndName(tenantId,
        "Name");

    // Assert
    verify(dashboardInfoRepository).findFirstByTenantIdAndTitle(isA(UUID.class), eq("Name"));
    TenantId tenantId2 = actualFindFirstByTenantIdAndNameResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Dr", actualFindFirstByTenantIdAndNameResult.getName());
    assertEquals("Dr", actualFindFirstByTenantIdAndNameResult.getTitle());
    assertEquals("Image", actualFindFirstByTenantIdAndNameResult.getImage());
    assertEquals(1, actualFindFirstByTenantIdAndNameResult.getMobileOrder().intValue());
    assertEquals(1L, actualFindFirstByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindFirstByTenantIdAndNameResult.getCreatedTime());
    DashboardId id = actualFindFirstByTenantIdAndNameResult.getId();
    assertEquals(EntityType.DASHBOARD, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(actualFindFirstByTenantIdAndNameResult.isMobileHide());
    assertTrue(id.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, actualFindFirstByTenantIdAndNameResult.getUuidId());
    assertSame(tenantId, id.getId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findFirstByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then return {@link DashboardInfo#DashboardInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findFirstByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindFirstByTenantIdAndName_thenReturnDashboardInfo() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = mock(DashboardInfoEntity.class);
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoEntity.toData()).thenReturn(dashboardInfo);
    doNothing().when(dashboardInfoEntity).setCreatedTime(anyLong());
    doNothing().when(dashboardInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(dashboardInfoEntity).setAssignedCustomers(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setMobileHide(anyBoolean());
    doNothing().when(dashboardInfoEntity).setMobileOrder(Mockito.<Integer>any());
    doNothing().when(dashboardInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setTitle(Mockito.<String>any());
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
    when(dashboardInfoRepository.findFirstByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(dashboardInfoEntity);

    // Act
    DashboardInfo actualFindFirstByTenantIdAndNameResult = jpaDashboardInfoDao
        .findFirstByTenantIdAndName(ModelConstants.NULL_UUID, "Name");

    // Assert
    verify(dashboardInfoEntity).setCreatedTime(eq(1L));
    verify(dashboardInfoEntity).setId(isA(UUID.class));
    verify(dashboardInfoEntity).setUuid(isA(UUID.class));
    verify(dashboardInfoEntity).setVersion(eq(1L));
    verify(dashboardInfoEntity).setAssignedCustomers(eq("Assigned Customers"));
    verify(dashboardInfoEntity).setImage(eq("Image"));
    verify(dashboardInfoEntity).setMobileHide(eq(true));
    verify(dashboardInfoEntity).setMobileOrder(eq(1));
    verify(dashboardInfoEntity).setTenantId(isA(UUID.class));
    verify(dashboardInfoEntity).setTitle(eq("Dr"));
    verify(dashboardInfoEntity).toData();
    verify(dashboardInfoRepository).findFirstByTenantIdAndTitle(isA(UUID.class), eq("Name"));
    assertSame(dashboardInfo, actualFindFirstByTenantIdAndNameResult);
  }

  /**
   * Test {@link JpaDashboardInfoDao#findTitleById(UUID, UUID)}.
   * <p>
   * Method under test: {@link JpaDashboardInfoDao#findTitleById(UUID, UUID)}
   */
  @Test
  public void testFindTitleById() {
    // Arrange
    when(dashboardInfoRepository.findTitleByTenantIdAndId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn("Dr");

    // Act
    String actualFindTitleByIdResult = jpaDashboardInfoDao.findTitleById(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID);

    // Assert
    verify(dashboardInfoRepository).findTitleByTenantIdAndId(isA(UUID.class), isA(UUID.class));
    assertEquals("Dr", actualFindTitleByIdResult);
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}.
   * <ul>
   *   <li>Then return first is {@link DashboardInfo#DashboardInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  public void testFindByTenantAndImageLink_thenReturnFirstIsDashboardInfo() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = mock(DashboardInfoEntity.class);
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoEntity.toData()).thenReturn(dashboardInfo);
    doNothing().when(dashboardInfoEntity).setCreatedTime(anyLong());
    doNothing().when(dashboardInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(dashboardInfoEntity).setAssignedCustomers(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setMobileHide(anyBoolean());
    doNothing().when(dashboardInfoEntity).setMobileOrder(Mockito.<Integer>any());
    doNothing().when(dashboardInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setTitle(Mockito.<String>any());
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
    when(dashboardInfoRepository.findByTenantAndImageLink(Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(dashboardInfoEntityList);

    // Act
    List<DashboardInfo> actualFindByTenantAndImageLinkResult = jpaDashboardInfoDao
        .findByTenantAndImageLink(ModelConstants.SYSTEM_TENANT, "Image Link", 1);

    // Assert
    verify(dashboardInfoEntity).setCreatedTime(eq(1L));
    verify(dashboardInfoEntity).setId(isA(UUID.class));
    verify(dashboardInfoEntity).setUuid(isA(UUID.class));
    verify(dashboardInfoEntity).setVersion(eq(1L));
    verify(dashboardInfoEntity).setAssignedCustomers(eq("Assigned Customers"));
    verify(dashboardInfoEntity).setImage(eq("Image"));
    verify(dashboardInfoEntity).setMobileHide(eq(true));
    verify(dashboardInfoEntity).setMobileOrder(eq(1));
    verify(dashboardInfoEntity).setTenantId(isA(UUID.class));
    verify(dashboardInfoEntity).setTitle(eq("Dr"));
    verify(dashboardInfoEntity).toData();
    verify(dashboardInfoRepository).findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), eq(1));
    assertEquals(1, actualFindByTenantAndImageLinkResult.size());
    assertSame(dashboardInfo, actualFindByTenantAndImageLinkResult.get(0));
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  public void testFindByTenantAndImageLink_thenReturnSizeIsTwo() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = mock(DashboardInfoEntity.class);
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoEntity.toData()).thenReturn(dashboardInfo);
    doNothing().when(dashboardInfoEntity).setCreatedTime(anyLong());
    doNothing().when(dashboardInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(dashboardInfoEntity).setAssignedCustomers(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setMobileHide(anyBoolean());
    doNothing().when(dashboardInfoEntity).setMobileOrder(Mockito.<Integer>any());
    doNothing().when(dashboardInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setTitle(Mockito.<String>any());
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

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("42");
    dashboardInfoEntity2.setCreatedTime(-1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("42");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(-1);
    UUID tenantId = UUID.randomUUID();
    dashboardInfoEntity2.setTenantId(tenantId);
    dashboardInfoEntity2.setTitle("Prof");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(-1L);

    ArrayList<DashboardInfoEntity> dashboardInfoEntityList = new ArrayList<>();
    dashboardInfoEntityList.add(dashboardInfoEntity2);
    dashboardInfoEntityList.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findByTenantAndImageLink(Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(dashboardInfoEntityList);

    // Act
    List<DashboardInfo> actualFindByTenantAndImageLinkResult = jpaDashboardInfoDao
        .findByTenantAndImageLink(ModelConstants.SYSTEM_TENANT, "Image Link", 1);

    // Assert
    verify(dashboardInfoEntity).setCreatedTime(eq(1L));
    verify(dashboardInfoEntity).setId(isA(UUID.class));
    verify(dashboardInfoEntity).setUuid(isA(UUID.class));
    verify(dashboardInfoEntity).setVersion(eq(1L));
    verify(dashboardInfoEntity).setAssignedCustomers(eq("Assigned Customers"));
    verify(dashboardInfoEntity).setImage(eq("Image"));
    verify(dashboardInfoEntity).setMobileHide(eq(true));
    verify(dashboardInfoEntity).setMobileOrder(eq(1));
    verify(dashboardInfoEntity).setTenantId(isA(UUID.class));
    verify(dashboardInfoEntity).setTitle(eq("Dr"));
    verify(dashboardInfoEntity).toData();
    verify(dashboardInfoRepository).findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), eq(1));
    assertEquals(2, actualFindByTenantAndImageLinkResult.size());
    DashboardInfo getResult = actualFindByTenantAndImageLinkResult.get(0);
    assertEquals("42", getResult.getImage());
    assertEquals("Prof", getResult.getName());
    assertEquals("Prof", getResult.getTitle());
    assertEquals(-1, getResult.getMobileOrder().intValue());
    assertEquals(-1L, getResult.getVersion().longValue());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(dashboardInfo, actualFindByTenantAndImageLinkResult.get(1));
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  public void testFindByTenantAndImageLink_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(dashboardInfoRepository.findByTenantAndImageLink(Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<DashboardInfo> actualFindByTenantAndImageLinkResult = jpaDashboardInfoDao
        .findByTenantAndImageLink(ModelConstants.SYSTEM_TENANT, "Image Link", 1);

    // Assert
    verify(dashboardInfoRepository).findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), eq(1));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findByImageLink(String, int)}.
   * <p>
   * Method under test: {@link JpaDashboardInfoDao#findByImageLink(String, int)}
   */
  @Test
  public void testFindByImageLink() {
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
    when(dashboardInfoRepository.findByImageLink(Mockito.<String>any(), anyInt())).thenReturn(dashboardInfoEntityList);

    // Act
    List<DashboardInfo> actualFindByImageLinkResult = jpaDashboardInfoDao.findByImageLink("Image Link", 1);

    // Assert
    verify(dashboardInfoRepository).findByImageLink(eq("Image Link"), eq(1));
    assertEquals(1, actualFindByImageLinkResult.size());
    DashboardInfo getResult = actualFindByImageLinkResult.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findByImageLink(String, int)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardInfoDao#findByImageLink(String, int)}
   */
  @Test
  public void testFindByImageLink_thenReturnEmpty() {
    // Arrange
    when(dashboardInfoRepository.findByImageLink(Mockito.<String>any(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<DashboardInfo> actualFindByImageLinkResult = jpaDashboardInfoDao.findByImageLink("Image Link", 1);

    // Assert
    verify(dashboardInfoRepository).findByImageLink(eq("Image Link"), eq(1));
    assertTrue(actualFindByImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findByImageLink(String, int)}.
   * <ul>
   *   <li>Then return first is {@link DashboardInfo#DashboardInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardInfoDao#findByImageLink(String, int)}
   */
  @Test
  public void testFindByImageLink_thenReturnFirstIsDashboardInfo() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = mock(DashboardInfoEntity.class);
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoEntity.toData()).thenReturn(dashboardInfo);
    doNothing().when(dashboardInfoEntity).setCreatedTime(anyLong());
    doNothing().when(dashboardInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(dashboardInfoEntity).setAssignedCustomers(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setMobileHide(anyBoolean());
    doNothing().when(dashboardInfoEntity).setMobileOrder(Mockito.<Integer>any());
    doNothing().when(dashboardInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setTitle(Mockito.<String>any());
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
    when(dashboardInfoRepository.findByImageLink(Mockito.<String>any(), anyInt())).thenReturn(dashboardInfoEntityList);

    // Act
    List<DashboardInfo> actualFindByImageLinkResult = jpaDashboardInfoDao.findByImageLink("Image Link", 1);

    // Assert
    verify(dashboardInfoEntity).setCreatedTime(eq(1L));
    verify(dashboardInfoEntity).setId(isA(UUID.class));
    verify(dashboardInfoEntity).setUuid(isA(UUID.class));
    verify(dashboardInfoEntity).setVersion(eq(1L));
    verify(dashboardInfoEntity).setAssignedCustomers(eq("Assigned Customers"));
    verify(dashboardInfoEntity).setImage(eq("Image"));
    verify(dashboardInfoEntity).setMobileHide(eq(true));
    verify(dashboardInfoEntity).setMobileOrder(eq(1));
    verify(dashboardInfoEntity).setTenantId(isA(UUID.class));
    verify(dashboardInfoEntity).setTitle(eq("Dr"));
    verify(dashboardInfoEntity).toData();
    verify(dashboardInfoRepository).findByImageLink(eq("Image Link"), eq(1));
    assertEquals(1, actualFindByImageLinkResult.size());
    assertSame(dashboardInfo, actualFindByImageLinkResult.get(0));
  }

  /**
   * Test {@link JpaDashboardInfoDao#findByImageLink(String, int)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardInfoDao#findByImageLink(String, int)}
   */
  @Test
  public void testFindByImageLink_thenReturnSizeIsTwo() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = mock(DashboardInfoEntity.class);
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoEntity.toData()).thenReturn(dashboardInfo);
    doNothing().when(dashboardInfoEntity).setCreatedTime(anyLong());
    doNothing().when(dashboardInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(dashboardInfoEntity).setAssignedCustomers(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(dashboardInfoEntity).setMobileHide(anyBoolean());
    doNothing().when(dashboardInfoEntity).setMobileOrder(Mockito.<Integer>any());
    doNothing().when(dashboardInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(dashboardInfoEntity).setTitle(Mockito.<String>any());
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

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("42");
    dashboardInfoEntity2.setCreatedTime(-1L);
    dashboardInfoEntity2.setId(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setImage("42");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(-1);
    UUID tenantId = UUID.randomUUID();
    dashboardInfoEntity2.setTenantId(tenantId);
    dashboardInfoEntity2.setTitle("Prof");
    dashboardInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    dashboardInfoEntity2.setVersion(-1L);

    ArrayList<DashboardInfoEntity> dashboardInfoEntityList = new ArrayList<>();
    dashboardInfoEntityList.add(dashboardInfoEntity2);
    dashboardInfoEntityList.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findByImageLink(Mockito.<String>any(), anyInt())).thenReturn(dashboardInfoEntityList);

    // Act
    List<DashboardInfo> actualFindByImageLinkResult = jpaDashboardInfoDao.findByImageLink("Image Link", 1);

    // Assert
    verify(dashboardInfoEntity).setCreatedTime(eq(1L));
    verify(dashboardInfoEntity).setId(isA(UUID.class));
    verify(dashboardInfoEntity).setUuid(isA(UUID.class));
    verify(dashboardInfoEntity).setVersion(eq(1L));
    verify(dashboardInfoEntity).setAssignedCustomers(eq("Assigned Customers"));
    verify(dashboardInfoEntity).setImage(eq("Image"));
    verify(dashboardInfoEntity).setMobileHide(eq(true));
    verify(dashboardInfoEntity).setMobileOrder(eq(1));
    verify(dashboardInfoEntity).setTenantId(isA(UUID.class));
    verify(dashboardInfoEntity).setTitle(eq("Dr"));
    verify(dashboardInfoEntity).toData();
    verify(dashboardInfoRepository).findByImageLink(eq("Image Link"), eq(1));
    assertEquals(2, actualFindByImageLinkResult.size());
    DashboardInfo getResult = actualFindByImageLinkResult.get(0);
    assertEquals("42", getResult.getImage());
    assertEquals("Prof", getResult.getName());
    assertEquals("Prof", getResult.getTitle());
    assertEquals(-1, getResult.getMobileOrder().intValue());
    assertEquals(-1L, getResult.getVersion().longValue());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(dashboardInfo, actualFindByImageLinkResult.get(1));
    assertSame(tenantId, tenantId2.getId());
  }
}
