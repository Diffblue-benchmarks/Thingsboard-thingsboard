package org.thingsboard.server.dao.sql.dashboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.DashboardInfo;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DashboardInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDashboardInfoDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaDashboardInfoDao.getEntityClass()",
      "org.springframework.data.jpa.repository.JpaRepository JpaDashboardInfoDao.getRepository()"})
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
   * Test {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}.
   * <p>
   * Method under test: {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    ArrayList<DashboardInfoEntity> dashboardInfoEntityList = new ArrayList<>();
    dashboardInfoEntityList.add(dashboardInfoEntity);
    when(dashboardInfoRepository.findByTenantAndImageLink(Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(dashboardInfoEntityList);

    // Act
    List<DashboardInfo> actualFindByTenantAndImageLinkResult = jpaDashboardInfoDao
        .findByTenantAndImageLink(ModelConstants.SYSTEM_TENANT, "Image Link", 1);

    // Assert
    verify(dashboardInfoRepository).findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), eq(1));
    assertEquals(1, actualFindByTenantAndImageLinkResult.size());
    DashboardInfo getResult = actualFindByTenantAndImageLinkResult.get(0);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", getResult.getTenantId().getId().toString());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
  }

  /**
   * Test {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}.
   * <ul>
   *   <li>Then return first is {@link DashboardInfo#DashboardInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByTenantAndImageLink(TenantId, String, int)"})
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
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   * Test {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByTenantAndImageLink(TenantId, String, int)"})
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
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("42");
    dashboardInfoEntity2.setCreatedTime(-1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("42");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(-1);
    dashboardInfoEntity2.setTenantId(UUID.randomUUID());
    dashboardInfoEntity2.setTitle("Prof");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    assertSame(dashboardInfo, actualFindByTenantAndImageLinkResult.get(1));
  }

  /**
   * Test {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardInfoDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByTenantAndImageLink(TenantId, String, int)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByImageLink(String, int)"})
  public void testFindByImageLink() {
    // Arrange
    DashboardInfoEntity dashboardInfoEntity = new DashboardInfoEntity();
    dashboardInfoEntity.setAssignedCustomers("Assigned Customers");
    dashboardInfoEntity.setCreatedTime(1L);
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", getResult.getTenantId().getId().toString());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByImageLink(String, int)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByImageLink(String, int)"})
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
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaDashboardInfoDao.findByImageLink(String, int)"})
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
    dashboardInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setImage("Image");
    dashboardInfoEntity.setMobileHide(true);
    dashboardInfoEntity.setMobileOrder(1);
    dashboardInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setTitle("Dr");
    dashboardInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity.setVersion(1L);

    DashboardInfoEntity dashboardInfoEntity2 = new DashboardInfoEntity();
    dashboardInfoEntity2.setAssignedCustomers("42");
    dashboardInfoEntity2.setCreatedTime(-1L);
    dashboardInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    dashboardInfoEntity2.setImage("42");
    dashboardInfoEntity2.setMobileHide(true);
    dashboardInfoEntity2.setMobileOrder(-1);
    dashboardInfoEntity2.setTenantId(UUID.randomUUID());
    dashboardInfoEntity2.setTitle("Prof");
    dashboardInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    assertSame(dashboardInfo, actualFindByImageLinkResult.get(1));
  }
}
