package org.thingsboard.server.dao.sql.mobile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.mobile.MobileApp;
import org.thingsboard.server.common.data.mobile.MobileAppOauth2Client;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.MobileAppEntity;
import org.thingsboard.server.dao.model.sql.MobileAppOauth2ClientCompositeKey;
import org.thingsboard.server.dao.model.sql.MobileAppOauth2ClientEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaMobileAppDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaMobileAppDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaMobileAppDao jpaMobileAppDao;

  @MockBean
  private MobileAppOauth2ClientRepository mobileAppOauth2ClientRepository;

  @MockBean
  private MobileAppRepository mobileAppRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaMobileAppDao#getEntityClass()}
   *   <li>{@link JpaMobileAppDao#getEntityType()}
   *   <li>{@link JpaMobileAppDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaMobileAppDao jpaMobileAppDao = new JpaMobileAppDao(mock(MobileAppRepository.class),
        mock(MobileAppOauth2ClientRepository.class));

    // Act
    Class<MobileAppEntity> actualEntityClass = jpaMobileAppDao.getEntityClass();
    EntityType actualEntityType = jpaMobileAppDao.getEntityType();
    jpaMobileAppDao.getRepository();

    // Assert
    assertEquals(EntityType.MOBILE_APP, actualEntityType);
    Class<MobileAppEntity> expectedEntityClass = MobileAppEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(mobileAppRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<MobileApp> actualFindByTenantIdResult = jpaMobileAppDao.findByTenantId(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(mobileAppRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link MobileApp#MobileApp()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataFirstIsMobileApp() {
    // Arrange
    MobileAppEntity mobileAppEntity = mock(MobileAppEntity.class);
    MobileApp mobileApp = new MobileApp();
    when(mobileAppEntity.toData()).thenReturn(mobileApp);
    doNothing().when(mobileAppEntity).setCreatedTime(anyLong());
    doNothing().when(mobileAppEntity).setId(Mockito.<UUID>any());
    doNothing().when(mobileAppEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(mobileAppEntity).setAppSecret(Mockito.<String>any());
    doNothing().when(mobileAppEntity).setOauth2Enabled(Mockito.<Boolean>any());
    doNothing().when(mobileAppEntity).setPkgName(Mockito.<String>any());
    doNothing().when(mobileAppEntity).setTenantId(Mockito.<UUID>any());
    mobileAppEntity.setAppSecret("42");
    mobileAppEntity.setCreatedTime(-1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("42");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<MobileAppEntity> content = new ArrayList<>();
    content.add(mobileAppEntity);
    PageImpl<MobileAppEntity> pageImpl = new PageImpl<>(content);
    when(mobileAppRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<MobileApp> actualFindByTenantIdResult = jpaMobileAppDao.findByTenantId(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(mobileAppEntity).setCreatedTime(eq(-1L));
    verify(mobileAppEntity).setId(isA(UUID.class));
    verify(mobileAppEntity).setUuid(isA(UUID.class));
    verify(mobileAppEntity).setAppSecret(eq("42"));
    verify(mobileAppEntity).setOauth2Enabled(eq(true));
    verify(mobileAppEntity).setPkgName(eq("42"));
    verify(mobileAppEntity).setTenantId(isA(UUID.class));
    verify(mobileAppEntity).toData();
    verify(mobileAppRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<MobileApp> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(mobileApp, data.get(0));
  }

  /**
   * Test {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataSizeIsTwo() {
    // Arrange
    MobileAppEntity mobileAppEntity = mock(MobileAppEntity.class);
    MobileApp mobileApp = new MobileApp();
    when(mobileAppEntity.toData()).thenReturn(mobileApp);
    doNothing().when(mobileAppEntity).setCreatedTime(anyLong());
    doNothing().when(mobileAppEntity).setId(Mockito.<UUID>any());
    doNothing().when(mobileAppEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(mobileAppEntity).setAppSecret(Mockito.<String>any());
    doNothing().when(mobileAppEntity).setOauth2Enabled(Mockito.<Boolean>any());
    doNothing().when(mobileAppEntity).setPkgName(Mockito.<String>any());
    doNothing().when(mobileAppEntity).setTenantId(Mockito.<UUID>any());
    mobileAppEntity.setAppSecret("42");
    mobileAppEntity.setCreatedTime(-1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("42");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("org.thingsboard.server.dao.model.sql.MobileAppEntity");
    mobileAppEntity2.setCreatedTime(0L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("org.thingsboard.server.dao.model.sql.MobileAppEntity");
    UUID tenantId = UUID.randomUUID();
    mobileAppEntity2.setTenantId(tenantId);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<MobileAppEntity> content = new ArrayList<>();
    content.add(mobileAppEntity2);
    content.add(mobileAppEntity);
    PageImpl<MobileAppEntity> pageImpl = new PageImpl<>(content);
    when(mobileAppRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<MobileApp> actualFindByTenantIdResult = jpaMobileAppDao.findByTenantId(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(mobileAppEntity).setCreatedTime(eq(-1L));
    verify(mobileAppEntity).setId(isA(UUID.class));
    verify(mobileAppEntity).setUuid(isA(UUID.class));
    verify(mobileAppEntity).setAppSecret(eq("42"));
    verify(mobileAppEntity).setOauth2Enabled(eq(true));
    verify(mobileAppEntity).setPkgName(eq("42"));
    verify(mobileAppEntity).setTenantId(isA(UUID.class));
    verify(mobileAppEntity).toData();
    verify(mobileAppRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<MobileApp> data = actualFindByTenantIdResult.getData();
    assertEquals(2, data.size());
    MobileApp getResult = data.get(0);
    assertEquals("org.thingsboard.server.dao.model.sql.MobileAppEntity", getResult.getAppSecret());
    assertEquals("org.thingsboard.server.dao.model.sql.MobileAppEntity", getResult.getName());
    assertEquals("org.thingsboard.server.dao.model.sql.MobileAppEntity", getResult.getPkgName());
    assertEquals(2L, actualFindByTenantIdResult.getTotalElements());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(mobileApp, data.get(1));
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaMobileAppDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(mobileAppRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<MobileApp> actualFindByTenantIdResult = jpaMobileAppDao.findByTenantId(ModelConstants.SYSTEM_TENANT,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(mobileAppRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaMobileAppDao#findOauth2ClientsByMobileAppId(TenantId, MobileAppId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaMobileAppDao#findOauth2ClientsByMobileAppId(TenantId, MobileAppId)}
   */
  @Test
  public void testFindOauth2ClientsByMobileAppId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(mobileAppOauth2ClientRepository.findAllByMobileAppId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());
    MobileAppId mobileAppId = mock(MobileAppId.class);
    when(mobileAppId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<MobileAppOauth2Client> actualFindOauth2ClientsByMobileAppIdResult = jpaMobileAppDao
        .findOauth2ClientsByMobileAppId(ModelConstants.SYSTEM_TENANT, mobileAppId);

    // Assert
    verify(mobileAppId).getId();
    verify(mobileAppOauth2ClientRepository).findAllByMobileAppId(isA(UUID.class));
    assertTrue(actualFindOauth2ClientsByMobileAppIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaMobileAppDao#findOauth2ClientsByMobileAppId(TenantId, MobileAppId)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaMobileAppDao#findOauth2ClientsByMobileAppId(TenantId, MobileAppId)}
   */
  @Test
  public void testFindOauth2ClientsByMobileAppId_thenReturnEmpty() {
    // Arrange
    when(mobileAppOauth2ClientRepository.findAllByMobileAppId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<MobileAppOauth2Client> actualFindOauth2ClientsByMobileAppIdResult = jpaMobileAppDao
        .findOauth2ClientsByMobileAppId(ModelConstants.SYSTEM_TENANT, new MobileAppId(ModelConstants.NULL_UUID));

    // Assert
    verify(mobileAppOauth2ClientRepository).findAllByMobileAppId(isA(UUID.class));
    assertTrue(actualFindOauth2ClientsByMobileAppIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaMobileAppDao#findOauth2ClientsByMobileAppId(TenantId, MobileAppId)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaMobileAppDao#findOauth2ClientsByMobileAppId(TenantId, MobileAppId)}
   */
  @Test
  public void testFindOauth2ClientsByMobileAppId_thenReturnSizeIsOne() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    ArrayList<MobileAppOauth2ClientEntity> mobileAppOauth2ClientEntityList = new ArrayList<>();
    mobileAppOauth2ClientEntityList.add(mobileAppOauth2ClientEntity);
    when(mobileAppOauth2ClientRepository.findAllByMobileAppId(Mockito.<UUID>any()))
        .thenReturn(mobileAppOauth2ClientEntityList);
    MobileAppId mobileAppId = new MobileAppId(ModelConstants.NULL_UUID);

    // Act
    List<MobileAppOauth2Client> actualFindOauth2ClientsByMobileAppIdResult = jpaMobileAppDao
        .findOauth2ClientsByMobileAppId(ModelConstants.SYSTEM_TENANT, mobileAppId);

    // Assert
    verify(mobileAppOauth2ClientRepository).findAllByMobileAppId(isA(UUID.class));
    assertEquals(1, actualFindOauth2ClientsByMobileAppIdResult.size());
    MobileAppOauth2Client getResult = actualFindOauth2ClientsByMobileAppIdResult.get(0);
    OAuth2ClientId oAuth2ClientId = getResult.getOAuth2ClientId();
    assertEquals(EntityType.OAUTH2_CLIENT, oAuth2ClientId.getEntityType());
    assertTrue(oAuth2ClientId.isNullUid());
    assertEquals(mobileAppId, getResult.getMobileAppId());
  }

  /**
   * Test {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}.
   * <ul>
   *   <li>Given {@link MobileAppId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}
   */
  @Test
  public void testAddOauth2Client_givenMobileAppIdGetIdReturnNull_uuid() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);
    when(mobileAppOauth2ClientRepository.save(Mockito.<MobileAppOauth2ClientEntity>any()))
        .thenReturn(mobileAppOauth2ClientEntity);
    MobileAppId mobileAppId = mock(MobileAppId.class);
    when(mobileAppId.getId()).thenReturn(ModelConstants.NULL_UUID);
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    MobileAppOauth2Client mobileAppOauth2Client = mock(MobileAppOauth2Client.class);
    when(mobileAppOauth2Client.getOAuth2ClientId()).thenReturn(oAuth2ClientId);
    when(mobileAppOauth2Client.getMobileAppId()).thenReturn(mobileAppId);

    // Act
    jpaMobileAppDao.addOauth2Client(mobileAppOauth2Client);

    // Assert
    verify(mobileAppOauth2ClientRepository).save(isA(MobileAppOauth2ClientEntity.class));
    verify(mobileAppId).getId();
    verify(oAuth2ClientId).getId();
    verify(mobileAppOauth2Client).getMobileAppId();
    verify(mobileAppOauth2Client).getOAuth2ClientId();
  }

  /**
   * Test {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}.
   * <ul>
   *   <li>Given {@link OAuth2ClientId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}
   */
  @Test
  public void testAddOauth2Client_givenOAuth2ClientIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);
    when(mobileAppOauth2ClientRepository.save(Mockito.<MobileAppOauth2ClientEntity>any()))
        .thenReturn(mobileAppOauth2ClientEntity);
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    MobileAppOauth2Client mobileAppOauth2Client = mock(MobileAppOauth2Client.class);
    when(mobileAppOauth2Client.getOAuth2ClientId()).thenReturn(oAuth2ClientId);
    when(mobileAppOauth2Client.getMobileAppId()).thenReturn(new MobileAppId(ModelConstants.NULL_UUID));

    // Act
    jpaMobileAppDao.addOauth2Client(mobileAppOauth2Client);

    // Assert
    verify(mobileAppOauth2ClientRepository).save(isA(MobileAppOauth2ClientEntity.class));
    verify(oAuth2ClientId).getId();
    verify(mobileAppOauth2Client).getMobileAppId();
    verify(mobileAppOauth2Client).getOAuth2ClientId();
  }

  /**
   * Test {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}.
   * <ul>
   *   <li>Given {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}
   */
  @Test
  public void testAddOauth2Client_givenOAuth2ClientIdWithIdIsNull_uuid() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);
    when(mobileAppOauth2ClientRepository.save(Mockito.<MobileAppOauth2ClientEntity>any()))
        .thenReturn(mobileAppOauth2ClientEntity);
    MobileAppOauth2Client mobileAppOauth2Client = mock(MobileAppOauth2Client.class);
    when(mobileAppOauth2Client.getOAuth2ClientId()).thenReturn(new OAuth2ClientId(ModelConstants.NULL_UUID));
    when(mobileAppOauth2Client.getMobileAppId()).thenReturn(new MobileAppId(ModelConstants.NULL_UUID));

    // Act
    jpaMobileAppDao.addOauth2Client(mobileAppOauth2Client);

    // Assert
    verify(mobileAppOauth2ClientRepository).save(isA(MobileAppOauth2ClientEntity.class));
    verify(mobileAppOauth2Client).getMobileAppId();
    verify(mobileAppOauth2Client).getOAuth2ClientId();
  }

  /**
   * Test {@link JpaMobileAppDao#removeOauth2Client(MobileAppOauth2Client)}.
   * <ul>
   *   <li>Given {@link MobileAppId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaMobileAppDao#removeOauth2Client(MobileAppOauth2Client)}
   */
  @Test
  public void testRemoveOauth2Client_givenMobileAppIdGetIdReturnNull_uuid() {
    // Arrange
    doNothing().when(mobileAppOauth2ClientRepository).deleteById(Mockito.<MobileAppOauth2ClientCompositeKey>any());
    MobileAppId mobileAppId = mock(MobileAppId.class);
    when(mobileAppId.getId()).thenReturn(ModelConstants.NULL_UUID);
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    MobileAppOauth2Client mobileAppOauth2Client = mock(MobileAppOauth2Client.class);
    when(mobileAppOauth2Client.getOAuth2ClientId()).thenReturn(oAuth2ClientId);
    when(mobileAppOauth2Client.getMobileAppId()).thenReturn(mobileAppId);

    // Act
    jpaMobileAppDao.removeOauth2Client(mobileAppOauth2Client);

    // Assert
    verify(mobileAppOauth2ClientRepository).deleteById(isA(MobileAppOauth2ClientCompositeKey.class));
    verify(mobileAppId).getId();
    verify(oAuth2ClientId).getId();
    verify(mobileAppOauth2Client).getMobileAppId();
    verify(mobileAppOauth2Client).getOAuth2ClientId();
  }

  /**
   * Test {@link JpaMobileAppDao#removeOauth2Client(MobileAppOauth2Client)}.
   * <ul>
   *   <li>Given {@link OAuth2ClientId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaMobileAppDao#removeOauth2Client(MobileAppOauth2Client)}
   */
  @Test
  public void testRemoveOauth2Client_givenOAuth2ClientIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(mobileAppOauth2ClientRepository).deleteById(Mockito.<MobileAppOauth2ClientCompositeKey>any());
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    MobileAppOauth2Client mobileAppOauth2Client = mock(MobileAppOauth2Client.class);
    when(mobileAppOauth2Client.getOAuth2ClientId()).thenReturn(oAuth2ClientId);
    when(mobileAppOauth2Client.getMobileAppId()).thenReturn(new MobileAppId(ModelConstants.NULL_UUID));

    // Act
    jpaMobileAppDao.removeOauth2Client(mobileAppOauth2Client);

    // Assert
    verify(mobileAppOauth2ClientRepository).deleteById(isA(MobileAppOauth2ClientCompositeKey.class));
    verify(oAuth2ClientId).getId();
    verify(mobileAppOauth2Client).getMobileAppId();
    verify(mobileAppOauth2Client).getOAuth2ClientId();
  }

  /**
   * Test {@link JpaMobileAppDao#removeOauth2Client(MobileAppOauth2Client)}.
   * <ul>
   *   <li>Given {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaMobileAppDao#removeOauth2Client(MobileAppOauth2Client)}
   */
  @Test
  public void testRemoveOauth2Client_givenOAuth2ClientIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(mobileAppOauth2ClientRepository).deleteById(Mockito.<MobileAppOauth2ClientCompositeKey>any());
    MobileAppOauth2Client mobileAppOauth2Client = mock(MobileAppOauth2Client.class);
    when(mobileAppOauth2Client.getOAuth2ClientId()).thenReturn(new OAuth2ClientId(ModelConstants.NULL_UUID));
    when(mobileAppOauth2Client.getMobileAppId()).thenReturn(new MobileAppId(ModelConstants.NULL_UUID));

    // Act
    jpaMobileAppDao.removeOauth2Client(mobileAppOauth2Client);

    // Assert
    verify(mobileAppOauth2ClientRepository).deleteById(isA(MobileAppOauth2ClientCompositeKey.class));
    verify(mobileAppOauth2Client).getMobileAppId();
    verify(mobileAppOauth2Client).getOAuth2ClientId();
  }

  /**
   * Test {@link JpaMobileAppDao#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link MobileAppRepository#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaMobileAppDao#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(mobileAppRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaMobileAppDao.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(mobileAppRepository).deleteByTenantId(isA(UUID.class));
  }
}
