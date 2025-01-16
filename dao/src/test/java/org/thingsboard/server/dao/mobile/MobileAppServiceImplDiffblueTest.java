package org.thingsboard.server.dao.mobile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.MobileApp;
import org.thingsboard.server.common.data.mobile.MobileAppInfo;
import org.thingsboard.server.common.data.mobile.MobileAppOauth2Client;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.oauth2.OAuth2ClientDao;
import org.thingsboard.server.dao.relation.RelationService;

@ContextConfiguration(classes = {MobileAppServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class MobileAppServiceImplDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private MobileAppDao mobileAppDao;

  @Autowired
  private MobileAppServiceImpl mobileAppServiceImpl;

  @MockBean
  private OAuth2ClientDao oAuth2ClientDao;

  @MockBean
  private RelationService relationService;

  /**
   * Test {@link MobileAppServiceImpl#saveMobileApp(TenantId, MobileApp)}.
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#saveMobileApp(TenantId, MobileApp)}
   */
  @Test
  public void testSaveMobileApp() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    when(mobileAppDao.save(Mockito.<TenantId>any(), Mockito.<MobileApp>any())).thenReturn(mobileApp);

    // Act
    MobileApp actualSaveMobileAppResult = mobileAppServiceImpl.saveMobileApp(ModelConstants.SYSTEM_TENANT,
        new MobileApp());

    // Assert
    verify(mobileAppDao).save(isA(TenantId.class), isA(MobileApp.class));
    assertSame(mobileApp, actualSaveMobileAppResult);
  }

  /**
   * Test {@link MobileAppServiceImpl#deleteMobileAppById(TenantId, MobileAppId)}.
   * <ul>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#deleteMobileAppById(TenantId, MobileAppId)}
   */
  @Test
  public void testDeleteMobileAppById_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(mobileAppDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    mobileAppServiceImpl.deleteMobileAppById(ModelConstants.SYSTEM_TENANT, new MobileAppId(ModelConstants.NULL_UUID));

    // Assert
    verify(mobileAppDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link MobileAppServiceImpl#findMobileAppById(TenantId, MobileAppId)}.
   * <ul>
   *   <li>Then return {@link MobileApp#MobileApp()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#findMobileAppById(TenantId, MobileAppId)}
   */
  @Test
  public void testFindMobileAppById_thenReturnMobileApp() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    when(mobileAppDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(mobileApp);

    // Act
    MobileApp actualFindMobileAppByIdResult = mobileAppServiceImpl.findMobileAppById(ModelConstants.SYSTEM_TENANT,
        new MobileAppId(ModelConstants.NULL_UUID));

    // Assert
    verify(mobileAppDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(mobileApp, actualFindMobileAppByIdResult);
  }

  /**
   * Test
   * {@link MobileAppServiceImpl#findMobileAppInfosByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#findMobileAppInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindMobileAppInfosByTenantId() {
    // Arrange
    PageData<MobileApp> emptyPageDataResult = PageData.emptyPageData();
    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<MobileAppInfo> actualFindMobileAppInfosByTenantIdResult = mobileAppServiceImpl
        .findMobileAppInfosByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertEquals(actualFindMobileAppInfosByTenantIdResult.EMPTY_PAGE_DATA, actualFindMobileAppInfosByTenantIdResult);
  }

  /**
   * Test
   * {@link MobileAppServiceImpl#findMobileAppInfosByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#findMobileAppInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindMobileAppInfosByTenantId2() {
    // Arrange
    PageData<MobileApp> pageData = new PageData<>(new ArrayList<>(), 3, 3L, true);

    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act
    PageData<MobileAppInfo> actualFindMobileAppInfosByTenantIdResult = mobileAppServiceImpl
        .findMobileAppInfosByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertEquals(pageData, actualFindMobileAppInfosByTenantIdResult);
  }

  /**
   * Test
   * {@link MobileAppServiceImpl#findMobileAppInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then calls {@link PageData#mapData(Function)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#findMobileAppInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindMobileAppInfosByTenantId_thenCallsMapData() {
    // Arrange
    PageData<MobileApp> pageData = mock(PageData.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(pageData.mapData(Mockito.<Function<MobileApp, Object>>any())).thenReturn(emptyPageDataResult);
    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act
    PageData<MobileAppInfo> actualFindMobileAppInfosByTenantIdResult = mobileAppServiceImpl
        .findMobileAppInfosByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(pageData).mapData(isA(Function.class));
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindMobileAppInfosByTenantIdResult.EMPTY_PAGE_DATA, actualFindMobileAppInfosByTenantIdResult);
  }

  /**
   * Test
   * {@link MobileAppServiceImpl#findMobileAppInfoById(TenantId, MobileAppId)}.
   * <ul>
   *   <li>Given {@link MobileAppDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#findMobileAppInfoById(TenantId, MobileAppId)}
   */
  @Test
  public void testFindMobileAppInfoById_givenMobileAppDaoFindByIdReturnNull_thenReturnNull() {
    // Arrange
    when(mobileAppDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    MobileAppInfo actualFindMobileAppInfoByIdResult = mobileAppServiceImpl
        .findMobileAppInfoById(ModelConstants.SYSTEM_TENANT, new MobileAppId(ModelConstants.NULL_UUID));

    // Assert
    verify(mobileAppDao).findById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualFindMobileAppInfoByIdResult);
  }

  /**
   * Test
   * {@link MobileAppServiceImpl#findMobileAppInfoById(TenantId, MobileAppId)}.
   * <ul>
   *   <li>Then return AppSecret is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#findMobileAppInfoById(TenantId, MobileAppId)}
   */
  @Test
  public void testFindMobileAppInfoById_thenReturnAppSecretIsNull() {
    // Arrange
    when(mobileAppDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new MobileApp());
    when(oAuth2ClientDao.findByMobileAppId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    MobileAppInfo actualFindMobileAppInfoByIdResult = mobileAppServiceImpl
        .findMobileAppInfoById(ModelConstants.SYSTEM_TENANT, new MobileAppId(ModelConstants.NULL_UUID));

    // Assert
    verify(mobileAppDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(oAuth2ClientDao).findByMobileAppId(isNull());
    assertNull(actualFindMobileAppInfoByIdResult.getAppSecret());
    assertNull(actualFindMobileAppInfoByIdResult.getName());
    assertNull(actualFindMobileAppInfoByIdResult.getPkgName());
    assertNull(actualFindMobileAppInfoByIdResult.getUuidId());
    assertNull(actualFindMobileAppInfoByIdResult.getId());
    assertNull(actualFindMobileAppInfoByIdResult.getTenantId());
    assertEquals(0L, actualFindMobileAppInfoByIdResult.getCreatedTime());
    assertFalse(actualFindMobileAppInfoByIdResult.isOauth2Enabled());
    assertTrue(actualFindMobileAppInfoByIdResult.getOauth2ClientInfos().isEmpty());
  }

  /**
   * Test
   * {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then calls
   * {@link MobileAppDao#addOauth2Client(MobileAppOauth2Client)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}
   */
  @Test
  public void testUpdateOauth2Clients_givenArrayListAddNull_thenCallsAddOauth2Client() {
    // Arrange
    ArrayList<MobileAppOauth2Client> mobileAppOauth2ClientList = new ArrayList<>();
    mobileAppOauth2ClientList.add(null);
    doNothing().when(mobileAppDao).addOauth2Client(Mockito.<MobileAppOauth2Client>any());
    doNothing().when(mobileAppDao).removeOauth2Client(Mockito.<MobileAppOauth2Client>any());
    when(mobileAppDao.findOauth2ClientsByMobileAppId(Mockito.<TenantId>any(), Mockito.<MobileAppId>any()))
        .thenReturn(mobileAppOauth2ClientList);

    ArrayList<OAuth2ClientId> oAuth2ClientIds = new ArrayList<>();
    oAuth2ClientIds.add(null);

    // Act
    mobileAppServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, oAuth2ClientIds);

    // Assert
    verify(mobileAppDao).addOauth2Client(isA(MobileAppOauth2Client.class));
    verify(mobileAppDao).findOauth2ClientsByMobileAppId(isA(TenantId.class), isNull());
    verify(mobileAppDao).removeOauth2Client(isNull());
  }

  /**
   * Test
   * {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}
   */
  @Test
  public void testUpdateOauth2Clients_givenNull_whenArrayListAddNull() {
    // Arrange
    ArrayList<MobileAppOauth2Client> mobileAppOauth2ClientList = new ArrayList<>();
    mobileAppOauth2ClientList.add(new MobileAppOauth2Client());
    when(mobileAppDao.findOauth2ClientsByMobileAppId(Mockito.<TenantId>any(), Mockito.<MobileAppId>any()))
        .thenReturn(mobileAppOauth2ClientList);

    ArrayList<OAuth2ClientId> oAuth2ClientIds = new ArrayList<>();
    oAuth2ClientIds.add(null);

    // Act
    mobileAppServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, oAuth2ClientIds);

    // Assert
    verify(mobileAppDao).findOauth2ClientsByMobileAppId(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}.
   * <ul>
   *   <li>Then calls
   * {@link MobileAppDao#removeOauth2Client(MobileAppOauth2Client)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}
   */
  @Test
  public void testUpdateOauth2Clients_thenCallsRemoveOauth2Client() {
    // Arrange
    ArrayList<MobileAppOauth2Client> mobileAppOauth2ClientList = new ArrayList<>();
    mobileAppOauth2ClientList.add(new MobileAppOauth2Client());
    doNothing().when(mobileAppDao).removeOauth2Client(Mockito.<MobileAppOauth2Client>any());
    when(mobileAppDao.findOauth2ClientsByMobileAppId(Mockito.<TenantId>any(), Mockito.<MobileAppId>any()))
        .thenReturn(mobileAppOauth2ClientList);

    // Act
    mobileAppServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, new ArrayList<>());

    // Assert
    verify(mobileAppDao).findOauth2ClientsByMobileAppId(isA(TenantId.class), isNull());
    verify(mobileAppDao).removeOauth2Client(isA(MobileAppOauth2Client.class));
  }

  /**
   * Test
   * {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}.
   * <ul>
   *   <li>Then calls
   * {@link MobileAppDao#removeOauth2Client(MobileAppOauth2Client)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}
   */
  @Test
  public void testUpdateOauth2Clients_thenCallsRemoveOauth2Client2() {
    // Arrange
    ArrayList<MobileAppOauth2Client> mobileAppOauth2ClientList = new ArrayList<>();
    mobileAppOauth2ClientList.add(new MobileAppOauth2Client());
    mobileAppOauth2ClientList.add(new MobileAppOauth2Client());
    doNothing().when(mobileAppDao).removeOauth2Client(Mockito.<MobileAppOauth2Client>any());
    when(mobileAppDao.findOauth2ClientsByMobileAppId(Mockito.<TenantId>any(), Mockito.<MobileAppId>any()))
        .thenReturn(mobileAppOauth2ClientList);

    // Act
    mobileAppServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, new ArrayList<>());

    // Assert
    verify(mobileAppDao).findOauth2ClientsByMobileAppId(isA(TenantId.class), isNull());
    verify(mobileAppDao, atLeast(1)).removeOauth2Client(isA(MobileAppOauth2Client.class));
  }

  /**
   * Test
   * {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}
   */
  @Test
  public void testUpdateOauth2Clients_whenArrayList() {
    // Arrange
    when(mobileAppDao.findOauth2ClientsByMobileAppId(Mockito.<TenantId>any(), Mockito.<MobileAppId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    mobileAppServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, new ArrayList<>());

    // Assert
    verify(mobileAppDao).findOauth2ClientsByMobileAppId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link MobileAppServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    when(mobileAppDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(mobileApp);

    // Act
    Optional<HasId<?>> actualFindEntityResult = mobileAppServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(mobileAppDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(mobileApp, actualFindEntityResult.get());
  }

  /**
   * Test {@link MobileAppServiceImpl#deleteMobileAppsByTenantId(TenantId)}.
   * <p>
   * Method under test:
   * {@link MobileAppServiceImpl#deleteMobileAppsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteMobileAppsByTenantId() {
    // Arrange
    doNothing().when(mobileAppDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    mobileAppServiceImpl.deleteMobileAppsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(mobileAppDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link MobileAppServiceImpl#deleteByTenantId(TenantId)}.
   * <p>
   * Method under test: {@link MobileAppServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId() {
    // Arrange
    doNothing().when(mobileAppDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    mobileAppServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(mobileAppDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link MobileAppServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link MobileAppServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.MOBILE_APP, (new MobileAppServiceImpl()).getEntityType());
  }
}
