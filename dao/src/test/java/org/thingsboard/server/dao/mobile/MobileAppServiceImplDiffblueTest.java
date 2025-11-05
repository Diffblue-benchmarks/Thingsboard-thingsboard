package org.thingsboard.server.dao.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.oauth2.OAuth2ClientDao;

@ContextConfiguration(classes = {MobileAppServiceImpl.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class MobileAppServiceImplDiffblueTest {
  @MockBean private CleanUpService cleanUpService;

  @MockBean private MobileAppDao mobileAppDao;

  @Autowired private MobileAppServiceImpl mobileAppServiceImpl;

  @MockBean private OAuth2ClientDao oAuth2ClientDao;

  /**
   * Test {@link MobileAppServiceImpl#saveMobileApp(TenantId, MobileApp)}.
   *
   * <ul>
   *   <li>Given {@link MobileAppDao} {@link MobileAppDao#save(TenantId, Object)} return {@link
   *       MobileApp#MobileApp()}.
   *   <li>Then return {@link MobileApp#MobileApp()}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppServiceImpl#saveMobileApp(TenantId, MobileApp)}
   */
  @Test
  @DisplayName(
      "Test saveMobileApp(TenantId, MobileApp); given MobileAppDao save(TenantId, Object) return MobileApp(); then return MobileApp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileApp MobileAppServiceImpl.saveMobileApp(TenantId, MobileApp)"})
  void testSaveMobileApp_givenMobileAppDaoSaveReturnMobileApp_thenReturnMobileApp() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    when(mobileAppDao.save(Mockito.<TenantId>any(), Mockito.<MobileApp>any()))
        .thenReturn(mobileApp);

    // Act
    MobileApp actualSaveMobileAppResult =
        mobileAppServiceImpl.saveMobileApp(ModelConstants.SYSTEM_TENANT, new MobileApp());

    // Assert
    verify(mobileAppDao).save(isA(TenantId.class), isA(MobileApp.class));
    assertSame(mobileApp, actualSaveMobileAppResult);
  }

  /**
   * Test {@link MobileAppServiceImpl#saveMobileApp(TenantId, MobileApp)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppServiceImpl#saveMobileApp(TenantId, MobileApp)}
   */
  @Test
  @DisplayName("Test saveMobileApp(TenantId, MobileApp); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileApp MobileAppServiceImpl.saveMobileApp(TenantId, MobileApp)"})
  void testSaveMobileApp_thenThrowRuntimeException() {
    // Arrange
    when(mobileAppDao.save(Mockito.<TenantId>any(), Mockito.<MobileApp>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> mobileAppServiceImpl.saveMobileApp(ModelConstants.SYSTEM_TENANT, new MobileApp()));
    verify(mobileAppDao).save(isA(TenantId.class), isA(MobileApp.class));
  }

  /**
   * Test {@link MobileAppServiceImpl#deleteMobileAppById(TenantId, MobileAppId)}.
   *
   * <ul>
   *   <li>Then calls {@link MobileAppDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppServiceImpl#deleteMobileAppById(TenantId, MobileAppId)}
   */
  @Test
  @DisplayName(
      "Test deleteMobileAppById(TenantId, MobileAppId); then calls removeById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppServiceImpl.deleteMobileAppById(TenantId, MobileAppId)"})
  void testDeleteMobileAppById_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(mobileAppDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    mobileAppServiceImpl.deleteMobileAppById(
        ModelConstants.SYSTEM_TENANT,
        new MobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(mobileAppDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link MobileAppServiceImpl#findMobileAppById(TenantId, MobileAppId)}.
   *
   * <ul>
   *   <li>Then return {@link MobileApp#MobileApp()}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppServiceImpl#findMobileAppById(TenantId, MobileAppId)}
   */
  @Test
  @DisplayName("Test findMobileAppById(TenantId, MobileAppId); then return MobileApp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileApp MobileAppServiceImpl.findMobileAppById(TenantId, MobileAppId)"})
  void testFindMobileAppById_thenReturnMobileApp() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    when(mobileAppDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(mobileApp);

    // Act
    MobileApp actualFindMobileAppByIdResult =
        mobileAppServiceImpl.findMobileAppById(
            ModelConstants.SYSTEM_TENANT,
            new MobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(mobileAppDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(mobileApp, actualFindMobileAppByIdResult);
  }

  /**
   * Test {@link MobileAppServiceImpl#findMobileAppInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link MobileAppServiceImpl#findMobileAppInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findMobileAppInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData MobileAppServiceImpl.findMobileAppInfosByTenantId(TenantId, PageLink)"
  })
  void testFindMobileAppInfosByTenantId() {
    // Arrange
    PageData<MobileApp> emptyPageDataResult = PageData.emptyPageData();
    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<MobileAppInfo> actualFindMobileAppInfosByTenantIdResult =
        mobileAppServiceImpl.findMobileAppInfosByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertEquals(PageData.EMPTY_PAGE_DATA, actualFindMobileAppInfosByTenantIdResult);
  }

  /**
   * Test {@link MobileAppServiceImpl#findMobileAppInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link MobileAppServiceImpl#findMobileAppInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findMobileAppInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData MobileAppServiceImpl.findMobileAppInfosByTenantId(TenantId, PageLink)"
  })
  void testFindMobileAppInfosByTenantId2() {
    // Arrange
    PageData<MobileApp> pageData = new PageData<>(new ArrayList<>(), 3, 3L, true);
    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    PageData<MobileAppInfo> actualFindMobileAppInfosByTenantIdResult =
        mobileAppServiceImpl.findMobileAppInfosByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertEquals(pageData, actualFindMobileAppInfosByTenantIdResult);
  }

  /**
   * Test {@link MobileAppServiceImpl#findMobileAppInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageData#mapData(Function)}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppServiceImpl#findMobileAppInfosByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findMobileAppInfosByTenantId(TenantId, PageLink); then calls mapData(Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData MobileAppServiceImpl.findMobileAppInfosByTenantId(TenantId, PageLink)"
  })
  void testFindMobileAppInfosByTenantId_thenCallsMapData() {
    // Arrange
    PageData<MobileApp> pageData = mock(PageData.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(pageData.mapData(Mockito.<Function<MobileApp, Object>>any()))
        .thenReturn(emptyPageDataResult);
    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    PageData<MobileAppInfo> actualFindMobileAppInfosByTenantIdResult =
        mobileAppServiceImpl.findMobileAppInfosByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(pageData).mapData(isA(Function.class));
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindMobileAppInfosByTenantIdResult);
  }

  /**
   * Test {@link MobileAppServiceImpl#findMobileAppInfoById(TenantId, MobileAppId)}.
   *
   * <ul>
   *   <li>Given {@link MobileAppDao} {@link MobileAppDao#findById(TenantId, UUID)} return {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppServiceImpl#findMobileAppInfoById(TenantId, MobileAppId)}
   */
  @Test
  @DisplayName(
      "Test findMobileAppInfoById(TenantId, MobileAppId); given MobileAppDao findById(TenantId, UUID) return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppInfo MobileAppServiceImpl.findMobileAppInfoById(TenantId, MobileAppId)"
  })
  void testFindMobileAppInfoById_givenMobileAppDaoFindByIdReturnNull_thenReturnNull() {
    // Arrange
    when(mobileAppDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    MobileAppInfo actualFindMobileAppInfoByIdResult =
        mobileAppServiceImpl.findMobileAppInfoById(
            ModelConstants.SYSTEM_TENANT,
            new MobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(mobileAppDao).findById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualFindMobileAppInfoByIdResult);
  }

  /**
   * Test {@link MobileAppServiceImpl#findMobileAppInfoById(TenantId, MobileAppId)}.
   *
   * <ul>
   *   <li>Then return AppSecret is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppServiceImpl#findMobileAppInfoById(TenantId, MobileAppId)}
   */
  @Test
  @DisplayName("Test findMobileAppInfoById(TenantId, MobileAppId); then return AppSecret is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppInfo MobileAppServiceImpl.findMobileAppInfoById(TenantId, MobileAppId)"
  })
  void testFindMobileAppInfoById_thenReturnAppSecretIsNull() {
    // Arrange
    when(mobileAppDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new MobileApp());
    when(oAuth2ClientDao.findByMobileAppId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    MobileAppInfo actualFindMobileAppInfoByIdResult =
        mobileAppServiceImpl.findMobileAppInfoById(
            ModelConstants.SYSTEM_TENANT,
            new MobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
   * Test {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then calls {@link MobileAppDao#addOauth2Client(MobileAppOauth2Client)}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId,
   * List)}
   */
  @Test
  @DisplayName(
      "Test updateOauth2Clients(TenantId, MobileAppId, List); given ArrayList() add 'null'; then calls addOauth2Client(MobileAppOauth2Client)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppServiceImpl.updateOauth2Clients(TenantId, MobileAppId, List)"})
  void testUpdateOauth2Clients_givenArrayListAddNull_thenCallsAddOauth2Client() {
    // Arrange
    ArrayList<MobileAppOauth2Client> mobileAppOauth2ClientList = new ArrayList<>();
    mobileAppOauth2ClientList.add(null);
    doNothing().when(mobileAppDao).addOauth2Client(Mockito.<MobileAppOauth2Client>any());
    doNothing().when(mobileAppDao).removeOauth2Client(Mockito.<MobileAppOauth2Client>any());
    when(mobileAppDao.findOauth2ClientsByMobileAppId(
            Mockito.<TenantId>any(), Mockito.<MobileAppId>any()))
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
   * Test {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId,
   * List)}
   */
  @Test
  @DisplayName(
      "Test updateOauth2Clients(TenantId, MobileAppId, List); given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppServiceImpl.updateOauth2Clients(TenantId, MobileAppId, List)"})
  void testUpdateOauth2Clients_givenNull_whenArrayListAddNull() {
    // Arrange
    ArrayList<MobileAppOauth2Client> mobileAppOauth2ClientList = new ArrayList<>();
    mobileAppOauth2ClientList.add(new MobileAppOauth2Client());
    when(mobileAppDao.findOauth2ClientsByMobileAppId(
            Mockito.<TenantId>any(), Mockito.<MobileAppId>any()))
        .thenReturn(mobileAppOauth2ClientList);

    ArrayList<OAuth2ClientId> oAuth2ClientIds = new ArrayList<>();
    oAuth2ClientIds.add(null);

    // Act
    mobileAppServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, oAuth2ClientIds);

    // Assert
    verify(mobileAppDao).findOauth2ClientsByMobileAppId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}.
   *
   * <ul>
   *   <li>Then calls {@link MobileAppDao#removeOauth2Client(MobileAppOauth2Client)}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId,
   * List)}
   */
  @Test
  @DisplayName(
      "Test updateOauth2Clients(TenantId, MobileAppId, List); then calls removeOauth2Client(MobileAppOauth2Client)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppServiceImpl.updateOauth2Clients(TenantId, MobileAppId, List)"})
  void testUpdateOauth2Clients_thenCallsRemoveOauth2Client() {
    // Arrange
    ArrayList<MobileAppOauth2Client> mobileAppOauth2ClientList = new ArrayList<>();
    mobileAppOauth2ClientList.add(new MobileAppOauth2Client());
    doNothing().when(mobileAppDao).removeOauth2Client(Mockito.<MobileAppOauth2Client>any());
    when(mobileAppDao.findOauth2ClientsByMobileAppId(
            Mockito.<TenantId>any(), Mockito.<MobileAppId>any()))
        .thenReturn(mobileAppOauth2ClientList);

    // Act
    mobileAppServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, new ArrayList<>());

    // Assert
    verify(mobileAppDao).findOauth2ClientsByMobileAppId(isA(TenantId.class), isNull());
    verify(mobileAppDao).removeOauth2Client(isA(MobileAppOauth2Client.class));
  }

  /**
   * Test {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}.
   *
   * <ul>
   *   <li>Then calls {@link MobileAppDao#removeOauth2Client(MobileAppOauth2Client)}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId,
   * List)}
   */
  @Test
  @DisplayName(
      "Test updateOauth2Clients(TenantId, MobileAppId, List); then calls removeOauth2Client(MobileAppOauth2Client)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppServiceImpl.updateOauth2Clients(TenantId, MobileAppId, List)"})
  void testUpdateOauth2Clients_thenCallsRemoveOauth2Client2() {
    // Arrange
    ArrayList<MobileAppOauth2Client> mobileAppOauth2ClientList = new ArrayList<>();
    mobileAppOauth2ClientList.add(new MobileAppOauth2Client());
    mobileAppOauth2ClientList.add(new MobileAppOauth2Client());
    doNothing().when(mobileAppDao).removeOauth2Client(Mockito.<MobileAppOauth2Client>any());
    when(mobileAppDao.findOauth2ClientsByMobileAppId(
            Mockito.<TenantId>any(), Mockito.<MobileAppId>any()))
        .thenReturn(mobileAppOauth2ClientList);

    // Act
    mobileAppServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, new ArrayList<>());

    // Assert
    verify(mobileAppDao).findOauth2ClientsByMobileAppId(isA(TenantId.class), isNull());
    verify(mobileAppDao, atLeast(1)).removeOauth2Client(isA(MobileAppOauth2Client.class));
  }

  /**
   * Test {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppServiceImpl#updateOauth2Clients(TenantId, MobileAppId,
   * List)}
   */
  @Test
  @DisplayName("Test updateOauth2Clients(TenantId, MobileAppId, List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppServiceImpl.updateOauth2Clients(TenantId, MobileAppId, List)"})
  void testUpdateOauth2Clients_whenArrayList() {
    // Arrange
    when(mobileAppDao.findOauth2ClientsByMobileAppId(
            Mockito.<TenantId>any(), Mockito.<MobileAppId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    mobileAppServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, new ArrayList<>());

    // Assert
    verify(mobileAppDao).findOauth2ClientsByMobileAppId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link MobileAppServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test findEntity(TenantId, EntityId); when NULL_CUSTOMER_ID; then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MobileAppServiceImpl.findEntity(TenantId, EntityId)"})
  void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    when(mobileAppDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(mobileApp);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        mobileAppServiceImpl.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(mobileAppDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(mobileApp, actualFindEntityResult.get());
  }

  /**
   * Test {@link MobileAppServiceImpl#deleteMobileAppsByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link MobileAppServiceImpl#deleteMobileAppsByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteMobileAppsByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppServiceImpl.deleteMobileAppsByTenantId(TenantId)"})
  void testDeleteMobileAppsByTenantId() {
    // Arrange
    doNothing().when(mobileAppDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    mobileAppServiceImpl.deleteMobileAppsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(mobileAppDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link MobileAppServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link MobileAppServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId() {
    // Arrange
    doNothing().when(mobileAppDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    mobileAppServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(mobileAppDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link MobileAppServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link MobileAppServiceImpl#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType MobileAppServiceImpl.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.MOBILE_APP, new MobileAppServiceImpl().getEntityType());
  }
}
