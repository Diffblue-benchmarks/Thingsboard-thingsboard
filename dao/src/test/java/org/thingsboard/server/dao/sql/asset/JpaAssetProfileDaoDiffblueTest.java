package org.thingsboard.server.dao.sql.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
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
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.asset.AssetProfileInfo;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AssetProfileEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaAssetProfileDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaAssetProfileDaoDiffblueTest {
  @MockBean
  private AssetProfileRepository assetProfileRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaAssetProfileDao jpaAssetProfileDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaAssetProfileDao#getEntityClass()}
   *   <li>{@link JpaAssetProfileDao#getEntityType()}
   *   <li>{@link JpaAssetProfileDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaAssetProfileDao jpaAssetProfileDao = new JpaAssetProfileDao();

    // Act
    Class<AssetProfileEntity> actualEntityClass = jpaAssetProfileDao.getEntityClass();
    EntityType actualEntityType = jpaAssetProfileDao.getEntityType();

    // Assert
    assertNull(jpaAssetProfileDao.getRepository());
    assertEquals(EntityType.ASSET_PROFILE, actualEntityType);
    Class<AssetProfileEntity> expectedEntityClass = AssetProfileEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfileInfoById(TenantId, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findAssetProfileInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindAssetProfileInfoById() {
    // Arrange
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(new AssetProfile());
    when(assetProfileRepository.findAssetProfileInfoById(Mockito.<UUID>any())).thenReturn(assetProfileInfo);

    // Act
    AssetProfileInfo actualFindAssetProfileInfoByIdResult = jpaAssetProfileDao
        .findAssetProfileInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(assetProfileRepository).findAssetProfileInfoById(isA(UUID.class));
    assertSame(assetProfileInfo, actualFindAssetProfileInfoByIdResult);
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetProfiles_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAssetProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult = jpaAssetProfileDao
        .findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetProfileRepository).findAssetProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetProfilesResult.getTotalElements());
    assertEquals(1, actualFindAssetProfilesResult.getTotalPages());
    assertFalse(actualFindAssetProfilesResult.hasNext());
    assertTrue(actualFindAssetProfilesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data first DefaultQueueName is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetProfiles_thenReturnDataFirstDefaultQueueNameIs42() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(-1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("42");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("org.thingsboard.server.dao.model.sql.AssetProfileEntity");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("42");
    assetProfileEntity.setName("42");
    UUID tenantId = UUID.randomUUID();
    assetProfileEntity.setTenantId(tenantId);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(-1L);

    ArrayList<AssetProfileEntity> content = new ArrayList<>();
    content.add(assetProfileEntity);
    PageImpl<AssetProfileEntity> pageImpl = new PageImpl<>(content);
    when(assetProfileRepository.findAssetProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult = jpaAssetProfileDao
        .findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetProfileRepository).findAssetProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetProfile> data = actualFindAssetProfilesResult.getData();
    assertEquals(1, data.size());
    AssetProfile getResult = data.get(0);
    assertEquals("42", getResult.getDefaultQueueName());
    assertEquals("42", getResult.getImage());
    assertEquals("42", getResult.getName());
    assertEquals("org.thingsboard.server.dao.model.sql.AssetProfileEntity", getResult.getDescription());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    RuleChainId expectedDefaultRuleChainId = getResult.getDefaultEdgeRuleChainId();
    assertEquals(expectedDefaultRuleChainId, getResult.getDefaultRuleChainId());
    AssetProfileId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetProfiles_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAssetProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult = jpaAssetProfileDao
        .findAssetProfiles(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileRepository).findAssetProfiles(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetProfilesResult.getTotalElements());
    assertEquals(1, actualFindAssetProfilesResult.getTotalPages());
    assertFalse(actualFindAssetProfilesResult.hasNext());
    assertTrue(actualFindAssetProfilesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfileInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetProfileInfos_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(assetProfileRepository.findAssetProfileInfos(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetProfileInfo> actualFindAssetProfileInfosResult = jpaAssetProfileDao
        .findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetProfileRepository).findAssetProfileInfos(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetProfileInfosResult.getTotalElements());
    assertEquals(1, actualFindAssetProfileInfosResult.getTotalPages());
    assertFalse(actualFindAssetProfileInfosResult.hasNext());
    assertTrue(actualFindAssetProfileInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfileInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetProfileInfos_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAssetProfileInfos(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetProfileInfo> actualFindAssetProfileInfosResult = jpaAssetProfileDao
        .findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileRepository).findAssetProfileInfos(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetProfileInfosResult.getTotalElements());
    assertEquals(1, actualFindAssetProfileInfosResult.getTotalPages());
    assertFalse(actualFindAssetProfileInfosResult.hasNext());
    assertTrue(actualFindAssetProfileInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findDefaultAssetProfile(TenantId)}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findDefaultAssetProfile(TenantId)}
   */
  @Test
  public void testFindDefaultAssetProfile_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    assetProfileEntity.setTenantId(tenantId);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any())).thenReturn(assetProfileEntity);

    // Act
    AssetProfile actualFindDefaultAssetProfileResult = jpaAssetProfileDao
        .findDefaultAssetProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    TenantId tenantId2 = actualFindDefaultAssetProfileResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findDefaultAssetProfileInfo(TenantId)}.
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findDefaultAssetProfileInfo(TenantId)}
   */
  @Test
  public void testFindDefaultAssetProfileInfo() {
    // Arrange
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(new AssetProfile());
    when(assetProfileRepository.findDefaultAssetProfileInfo(Mockito.<UUID>any())).thenReturn(assetProfileInfo);

    // Act
    AssetProfileInfo actualFindDefaultAssetProfileInfoResult = jpaAssetProfileDao
        .findDefaultAssetProfileInfo(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetProfileRepository).findDefaultAssetProfileInfo(isA(UUID.class));
    assertSame(assetProfileInfo, actualFindDefaultAssetProfileInfoResult);
  }

  /**
   * Test {@link JpaAssetProfileDao#findByName(TenantId, String)}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetProfileDao#findByName(TenantId, String)}
   */
  @Test
  public void testFindByName_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    assetProfileEntity.setTenantId(tenantId);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(assetProfileEntity);

    // Act
    AssetProfile actualFindByNameResult = jpaAssetProfileDao.findByName(ModelConstants.SYSTEM_TENANT, "foo.txt");

    // Assert
    verify(assetProfileRepository).findByTenantIdAndName(isA(UUID.class), eq("foo.txt"));
    TenantId tenantId2 = actualFindByNameResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAllWithImages(PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  public void testFindAllWithImages_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetProfile> actualFindAllWithImagesResult = jpaAssetProfileDao.findAllWithImages(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    assertEquals(0L, actualFindAllWithImagesResult.getTotalElements());
    assertEquals(1, actualFindAllWithImagesResult.getTotalPages());
    assertFalse(actualFindAllWithImagesResult.hasNext());
    assertTrue(actualFindAllWithImagesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAllWithImages(PageLink)}.
   * <ul>
   *   <li>Then return Data first DefaultQueueName is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  public void testFindAllWithImages_thenReturnDataFirstDefaultQueueNameIs42() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(-1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("42");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("org.thingsboard.server.dao.model.sql.AssetProfileEntity");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("42");
    assetProfileEntity.setName("42");
    UUID tenantId = UUID.randomUUID();
    assetProfileEntity.setTenantId(tenantId);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(-1L);

    ArrayList<AssetProfileEntity> content = new ArrayList<>();
    content.add(assetProfileEntity);
    PageImpl<AssetProfileEntity> pageImpl = new PageImpl<>(content);
    when(assetProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetProfile> actualFindAllWithImagesResult = jpaAssetProfileDao.findAllWithImages(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    List<AssetProfile> data = actualFindAllWithImagesResult.getData();
    assertEquals(1, data.size());
    AssetProfile getResult = data.get(0);
    assertEquals("42", getResult.getDefaultQueueName());
    assertEquals("42", getResult.getImage());
    assertEquals("42", getResult.getName());
    assertEquals("org.thingsboard.server.dao.model.sql.AssetProfileEntity", getResult.getDescription());
    assertEquals(-1L, getResult.getVersion().longValue());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    RuleChainId expectedDefaultRuleChainId = getResult.getDefaultEdgeRuleChainId();
    assertEquals(expectedDefaultRuleChainId, getResult.getDefaultRuleChainId());
    AssetProfileId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAllWithImages(PageLink)}.
   * <ul>
   *   <li>Then return Data first DefaultQueueName is
   * {@code Default Queue Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  public void testFindAllWithImages_thenReturnDataFirstDefaultQueueNameIsDefaultQueueName() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    ArrayList<AssetProfileEntity> content = new ArrayList<>();
    content.add(assetProfileEntity);
    PageImpl<AssetProfileEntity> pageImpl = new PageImpl<>(content);
    when(assetProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<AssetProfile> actualFindAllWithImagesResult = jpaAssetProfileDao
        .findAllWithImages(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    List<AssetProfile> data = actualFindAllWithImagesResult.getData();
    assertEquals(1, data.size());
    AssetProfile getResult = data.get(0);
    assertEquals("Default Queue Name", getResult.getDefaultQueueName());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAllWithImages(PageLink)}.
   * <ul>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  public void testFindAllWithImages_thenReturnDataSizeIsTwo() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(0L);
    assetProfileEntity2.setDefault(false);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("org.thingsboard.server.dao.model.sql.AssetProfileEntity");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("Description");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("org.thingsboard.server.dao.model.sql.AssetProfileEntity");
    assetProfileEntity2.setName("org.thingsboard.server.dao.model.sql.AssetProfileEntity");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(0L);

    ArrayList<AssetProfileEntity> content = new ArrayList<>();
    content.add(assetProfileEntity2);
    content.add(assetProfileEntity);
    PageImpl<AssetProfileEntity> pageImpl = new PageImpl<>(content);
    when(assetProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<AssetProfile> actualFindAllWithImagesResult = jpaAssetProfileDao
        .findAllWithImages(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    List<AssetProfile> data = actualFindAllWithImagesResult.getData();
    assertEquals(2, data.size());
    AssetProfile getResult = data.get(1);
    assertEquals("Default Queue Name", getResult.getDefaultQueueName());
    AssetProfile getResult2 = data.get(0);
    assertEquals("Description", getResult2.getDescription());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals("org.thingsboard.server.dao.model.sql.AssetProfileEntity", getResult2.getDefaultQueueName());
    assertEquals("org.thingsboard.server.dao.model.sql.AssetProfileEntity", getResult2.getImage());
    assertEquals("org.thingsboard.server.dao.model.sql.AssetProfileEntity", getResult2.getName());
    assertEquals(0L, getResult2.getVersion().longValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2L, actualFindAllWithImagesResult.getTotalElements());
    assertFalse(getResult2.isDefault());
    assertTrue(getResult.isDefault());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAllWithImages(PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  public void testFindAllWithImages_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetProfile> actualFindAllWithImagesResult = jpaAssetProfileDao
        .findAllWithImages(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    assertEquals(0L, actualFindAllWithImagesResult.getTotalElements());
    assertEquals(1, actualFindAllWithImagesResult.getTotalPages());
    assertFalse(actualFindAllWithImagesResult.hasNext());
    assertTrue(actualFindAllWithImagesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findTenantAssetProfileNames(UUID, boolean)}.
   * <ul>
   *   <li>Then calls
   * {@link AssetProfileRepository#findActiveTenantAssetProfileNames(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findTenantAssetProfileNames(UUID, boolean)}
   */
  @Test
  public void testFindTenantAssetProfileNames_thenCallsFindActiveTenantAssetProfileNames() {
    // Arrange
    when(assetProfileRepository.findActiveTenantAssetProfileNames(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityInfo> actualFindTenantAssetProfileNamesResult = jpaAssetProfileDao
        .findTenantAssetProfileNames(ModelConstants.NULL_UUID, true);

    // Assert
    verify(assetProfileRepository).findActiveTenantAssetProfileNames(isA(UUID.class));
    assertTrue(actualFindTenantAssetProfileNamesResult.isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findTenantAssetProfileNames(UUID, boolean)}.
   * <ul>
   *   <li>Then calls
   * {@link AssetProfileRepository#findAllTenantAssetProfileNames(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findTenantAssetProfileNames(UUID, boolean)}
   */
  @Test
  public void testFindTenantAssetProfileNames_thenCallsFindAllTenantAssetProfileNames() {
    // Arrange
    when(assetProfileRepository.findAllTenantAssetProfileNames(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityInfo> actualFindTenantAssetProfileNamesResult = jpaAssetProfileDao
        .findTenantAssetProfileNames(ModelConstants.NULL_UUID, false);

    // Assert
    verify(assetProfileRepository).findAllTenantAssetProfileNames(isA(UUID.class));
    assertTrue(actualFindTenantAssetProfileNamesResult.isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfileEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    AssetProfile actualFindByTenantIdAndExternalIdResult = jpaAssetProfileDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(assetProfileRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Default Queue Name", actualFindByTenantIdAndExternalIdResult.getDefaultQueueName());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("The characteristics of someone or something",
        actualFindByTenantIdAndExternalIdResult.getDescription());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    AssetProfileId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.ASSET_PROFILE, externalId2.getEntityType());
    DashboardId defaultDashboardId = actualFindByTenantIdAndExternalIdResult.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId.getEntityType());
    RuleChainId defaultEdgeRuleChainId = actualFindByTenantIdAndExternalIdResult.getDefaultEdgeRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, defaultEdgeRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isDefault());
    assertTrue(defaultDashboardId.isNullUid());
    assertTrue(defaultEdgeRuleChainId.isNullUid());
    assertTrue(externalId2.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertEquals(defaultEdgeRuleChainId, actualFindByTenantIdAndExternalIdResult.getDefaultRuleChainId());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
    assertSame(externalId, defaultDashboardId.getId());
    assertSame(externalId, defaultEdgeRuleChainId.getId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    assetProfileEntity.setTenantId(tenantId);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfileEntity);

    // Act
    AssetProfile actualFindByTenantIdAndExternalIdResult = jpaAssetProfileDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(assetProfileRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId2 = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantIdAndName(UUID, String)}.
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndName() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(assetProfileEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    AssetProfile actualFindByTenantIdAndNameResult = jpaAssetProfileDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(assetProfileRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    TenantId tenantId2 = actualFindByTenantIdAndNameResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Default Queue Name", actualFindByTenantIdAndNameResult.getDefaultQueueName());
    assertEquals("Image", actualFindByTenantIdAndNameResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndNameResult.getName());
    assertEquals("The characteristics of someone or something", actualFindByTenantIdAndNameResult.getDescription());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    AssetProfileId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.ASSET_PROFILE, externalId.getEntityType());
    DashboardId defaultDashboardId = actualFindByTenantIdAndNameResult.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId.getEntityType());
    RuleChainId defaultEdgeRuleChainId = actualFindByTenantIdAndNameResult.getDefaultEdgeRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, defaultEdgeRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(actualFindByTenantIdAndNameResult.isDefault());
    assertTrue(defaultDashboardId.isNullUid());
    assertTrue(defaultEdgeRuleChainId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(defaultEdgeRuleChainId, actualFindByTenantIdAndNameResult.getDefaultRuleChainId());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
    assertSame(tenantId, defaultDashboardId.getId());
    assertSame(tenantId, defaultEdgeRuleChainId.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndName_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    assetProfileEntity.setTenantId(tenantId);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(assetProfileEntity);

    // Act
    AssetProfile actualFindByTenantIdAndNameResult = jpaAssetProfileDao.findByTenantIdAndName(ModelConstants.NULL_UUID,
        "Name");

    // Assert
    verify(assetProfileRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    TenantId tenantId2 = actualFindByTenantIdAndNameResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(assetProfileRepository.findAssetProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetProfile> actualFindByTenantIdResult = jpaAssetProfileDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetProfileRepository).findAssetProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.toString());
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then {@link ModelConstants#NULL_UUID} toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenNull_uuidToStringIs138140001dd211b28080808080808080() {
    // Arrange
    when(assetProfileRepository.findAssetProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<AssetProfile> actualFindByTenantIdResult = jpaAssetProfileDao.findByTenantId(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileRepository).findAssetProfiles(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.toString());
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    ArrayList<AssetProfileEntity> content = new ArrayList<>();
    content.add(assetProfileEntity);
    PageImpl<AssetProfileEntity> pageImpl = new PageImpl<>(content);
    when(assetProfileRepository.findAssetProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<AssetProfile> actualFindByTenantIdResult = jpaAssetProfileDao.findByTenantId(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileRepository).findAssetProfiles(isA(UUID.class), isNull(), isA(Pageable.class));
    List<AssetProfile> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    AssetProfile getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Default Queue Name", getResult.getDefaultQueueName());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    AssetProfileId externalId = getResult.getExternalId();
    assertEquals(EntityType.ASSET_PROFILE, externalId.getEntityType());
    DashboardId defaultDashboardId = getResult.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId.getEntityType());
    RuleChainId defaultEdgeRuleChainId = getResult.getDefaultEdgeRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, defaultEdgeRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(getResult.isDefault());
    assertTrue(defaultDashboardId.isNullUid());
    assertTrue(defaultEdgeRuleChainId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(defaultEdgeRuleChainId, getResult.getDefaultRuleChainId());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, defaultDashboardId.getId());
    assertSame(tenantId, defaultEdgeRuleChainId.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When randomUUID.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenRandomUUID_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAssetProfiles(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetProfile> actualFindByTenantIdResult = jpaAssetProfileDao.findByTenantId(UUID.randomUUID(),
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileRepository).findAssetProfiles(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#getExternalIdByInternal(AssetProfileId)} with
   * {@code AssetProfileId}.
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#getExternalIdByInternal(AssetProfileId)}
   */
  @Test
  public void testGetExternalIdByInternalWithAssetProfileId() {
    // Arrange
    when(assetProfileRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    AssetProfileId internalId = new AssetProfileId(ModelConstants.NULL_UUID);

    // Act
    AssetProfileId actualExternalIdByInternal = jpaAssetProfileDao.getExternalIdByInternal(internalId);

    // Assert
    verify(assetProfileRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaAssetProfileDao#getExternalIdByInternal(AssetProfileId)} with
   * {@code AssetProfileId}.
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#getExternalIdByInternal(AssetProfileId)}
   */
  @Test
  public void testGetExternalIdByInternalWithAssetProfileId2() {
    // Arrange
    when(assetProfileRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    AssetProfileId internalId = mock(AssetProfileId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    AssetProfileId actualExternalIdByInternal = jpaAssetProfileDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(assetProfileRepository).getExternalIdById(isA(UUID.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.ASSET_PROFILE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaAssetProfileDao#getExternalIdByInternal(AssetProfileId)} with
   * {@code AssetProfileId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#getExternalIdByInternal(AssetProfileId)}
   */
  @Test
  public void testGetExternalIdByInternalWithAssetProfileId_thenReturnNull() {
    // Arrange
    when(assetProfileRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    AssetProfileId actualExternalIdByInternal = jpaAssetProfileDao
        .getExternalIdByInternal(new AssetProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(assetProfileRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaAssetProfileDao#findDefaultEntityByTenantId(UUID)}.
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  public void testFindDefaultEntityByTenantId() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any())).thenReturn(assetProfileEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    AssetProfile actualFindDefaultEntityByTenantIdResult = jpaAssetProfileDao.findDefaultEntityByTenantId(tenantId);

    // Assert
    verify(assetProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    TenantId tenantId2 = actualFindDefaultEntityByTenantIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Default Queue Name", actualFindDefaultEntityByTenantIdResult.getDefaultQueueName());
    assertEquals("Image", actualFindDefaultEntityByTenantIdResult.getImage());
    assertEquals("Name", actualFindDefaultEntityByTenantIdResult.getName());
    assertEquals("The characteristics of someone or something",
        actualFindDefaultEntityByTenantIdResult.getDescription());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getVersion().longValue());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getCreatedTime());
    AssetProfileId externalId = actualFindDefaultEntityByTenantIdResult.getExternalId();
    assertEquals(EntityType.ASSET_PROFILE, externalId.getEntityType());
    DashboardId defaultDashboardId = actualFindDefaultEntityByTenantIdResult.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId.getEntityType());
    RuleChainId defaultEdgeRuleChainId = actualFindDefaultEntityByTenantIdResult.getDefaultEdgeRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, defaultEdgeRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(actualFindDefaultEntityByTenantIdResult.isDefault());
    assertTrue(defaultDashboardId.isNullUid());
    assertTrue(defaultEdgeRuleChainId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(defaultEdgeRuleChainId, actualFindDefaultEntityByTenantIdResult.getDefaultRuleChainId());
    assertEquals(externalId, actualFindDefaultEntityByTenantIdResult.getId());
    assertSame(tenantId, actualFindDefaultEntityByTenantIdResult.getUuidId());
    assertSame(tenantId, defaultDashboardId.getId());
    assertSame(tenantId, defaultEdgeRuleChainId.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findDefaultEntityByTenantId(UUID)}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  public void testFindDefaultEntityByTenantId_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    assetProfileEntity.setTenantId(tenantId);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any())).thenReturn(assetProfileEntity);

    // Act
    AssetProfile actualFindDefaultEntityByTenantIdResult = jpaAssetProfileDao
        .findDefaultEntityByTenantId(ModelConstants.NULL_UUID);

    // Assert
    verify(assetProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    TenantId tenantId2 = actualFindDefaultEntityByTenantIdResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaAssetProfileDao#findByTenantAndImageLink(TenantId, String, int)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetProfileDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  public void testFindByTenantAndImageLink_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(assetProfileRepository.findByTenantAndImageLink(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new ArrayList<>());

    // Act
    List<AssetProfileInfo> actualFindByTenantAndImageLinkResult = jpaAssetProfileDao
        .findByTenantAndImageLink(ModelConstants.SYSTEM_TENANT, "Image Link", 1);

    // Assert
    verify(assetProfileRepository).findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), isA(Pageable.class));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByImageLink(String, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetProfileDao#findByImageLink(String, int)}
   */
  @Test
  public void testFindByImageLink_whenOne_thenReturnEmpty() {
    // Arrange
    when(assetProfileRepository.findByImageLink(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<AssetProfileInfo> actualFindByImageLinkResult = jpaAssetProfileDao.findByImageLink("Image Link", 1);

    // Assert
    verify(assetProfileRepository).findByImageLink(eq("Image Link"), isA(Pageable.class));
    assertTrue(actualFindByImageLinkResult.isEmpty());
  }
}
