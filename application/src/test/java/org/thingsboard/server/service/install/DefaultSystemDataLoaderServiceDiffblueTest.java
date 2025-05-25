package org.thingsboard.server.service.install;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.MobileApp;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.security.model.JwtSettings;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.mobile.MobileAppDao;
import org.thingsboard.server.service.security.auth.jwt.settings.JwtSettingsService;

@ExtendWith(MockitoExtension.class)
class DefaultSystemDataLoaderServiceDiffblueTest {
  @InjectMocks
  private DefaultSystemDataLoaderService defaultSystemDataLoaderService;

  @Mock
  private InstallScripts installScripts;

  @Mock
  private JwtSettingsService jwtSettingsService;

  @Mock
  private MobileAppDao mobileAppDao;

  /**
   * Test {@link DefaultSystemDataLoaderService#createRandomJwtSettings()}.
   * <ul>
   *   <li>Then calls {@link JwtSettingsService#getJwtSettings()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#createRandomJwtSettings()}
   */
  @Test
  @DisplayName("Test createRandomJwtSettings(); then calls getJwtSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultSystemDataLoaderService.createRandomJwtSettings()"})
  void testCreateRandomJwtSettings_thenCallsGetJwtSettings() throws Exception {
    // Arrange
    when(jwtSettingsService.getJwtSettings()).thenReturn(new JwtSettings());

    // Act
    defaultSystemDataLoaderService.createRandomJwtSettings();

    // Assert
    verify(jwtSettingsService).getJwtSettings();
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#updateSecuritySettings()}.
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#updateSecuritySettings()}
   */
  @Test
  @DisplayName("Test updateSecuritySettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultSystemDataLoaderService.updateSecuritySettings()"})
  void testUpdateSecuritySettings() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenSigningKey("ABC123");
    when(jwtSettingsService.saveJwtSettings(Mockito.<JwtSettings>any())).thenReturn(new JwtSettings());
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);
    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultSystemDataLoaderService.updateSecuritySettings());
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(jwtSettingsService).getJwtSettings();
    verify(jwtSettingsService).saveJwtSettings(isA(JwtSettings.class));
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#updateSecuritySettings()}.
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#updateSecuritySettings()}
   */
  @Test
  @DisplayName("Test updateSecuritySettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultSystemDataLoaderService.updateSecuritySettings()"})
  void testUpdateSecuritySettings2() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenSigningKey("thingsboardDefaultSigningKey");
    when(jwtSettingsService.saveJwtSettings(Mockito.<JwtSettings>any())).thenReturn(new JwtSettings());
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);
    PageData<MobileApp> emptyPageDataResult = PageData.emptyPageData();
    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    defaultSystemDataLoaderService.updateSecuritySettings();

    // Assert
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(jwtSettingsService).getJwtSettings();
    verify(jwtSettingsService).saveJwtSettings(isA(JwtSettings.class));
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#updateSecuritySettings()}.
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#updateSecuritySettings()}
   */
  @Test
  @DisplayName("Test updateSecuritySettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultSystemDataLoaderService.updateSecuritySettings()"})
  void testUpdateSecuritySettings3() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenSigningKey("ABC123");
    when(jwtSettingsService.saveJwtSettings(Mockito.<JwtSettings>any())).thenReturn(new JwtSettings());
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);

    MobileApp mobileApp = new MobileApp();
    mobileApp.setAppSecret("thingsboardDefaultSigningKey");

    ArrayList<MobileApp> data = new ArrayList<>();
    data.add(mobileApp);
    PageData<MobileApp> pageData = new PageData<>(data, 5, 5L, true);

    when(mobileAppDao.save(Mockito.<TenantId>any(), Mockito.<MobileApp>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultSystemDataLoaderService.updateSecuritySettings());
    verify(mobileAppDao).save(isA(TenantId.class), isA(MobileApp.class));
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(jwtSettingsService).getJwtSettings();
    verify(jwtSettingsService).saveJwtSettings(isA(JwtSettings.class));
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#updateSecuritySettings()}.
   * <ul>
   *   <li>Given {@link MobileAppDao} {@link MobileAppDao#findByTenantId(TenantId, PageLink)} return emptyPageData.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#updateSecuritySettings()}
   */
  @Test
  @DisplayName("Test updateSecuritySettings(); given MobileAppDao findByTenantId(TenantId, PageLink) return emptyPageData")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultSystemDataLoaderService.updateSecuritySettings()"})
  void testUpdateSecuritySettings_givenMobileAppDaoFindByTenantIdReturnEmptyPageData() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenSigningKey("ABC123");
    when(jwtSettingsService.saveJwtSettings(Mockito.<JwtSettings>any())).thenReturn(new JwtSettings());
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);
    PageData<MobileApp> emptyPageDataResult = PageData.emptyPageData();
    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    defaultSystemDataLoaderService.updateSecuritySettings();

    // Assert
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(jwtSettingsService).getJwtSettings();
    verify(jwtSettingsService).saveJwtSettings(isA(JwtSettings.class));
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#updateSecuritySettings()}.
   * <ul>
   *   <li>Given {@link MobileAppDao} {@link Dao#save(TenantId, Object)} return {@link MobileApp#MobileApp()}.</li>
   *   <li>Then calls {@link Dao#save(TenantId, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#updateSecuritySettings()}
   */
  @Test
  @DisplayName("Test updateSecuritySettings(); given MobileAppDao save(TenantId, Object) return MobileApp(); then calls save(TenantId, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultSystemDataLoaderService.updateSecuritySettings()"})
  void testUpdateSecuritySettings_givenMobileAppDaoSaveReturnMobileApp_thenCallsSave() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenSigningKey("ABC123");
    when(jwtSettingsService.saveJwtSettings(Mockito.<JwtSettings>any())).thenReturn(new JwtSettings());
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);

    MobileApp mobileApp = new MobileApp();
    mobileApp.setAppSecret("thingsboardDefaultSigningKey");

    ArrayList<MobileApp> data = new ArrayList<>();
    data.add(mobileApp);
    PageData<MobileApp> pageData = new PageData<>(data, 5, 5L, true);

    when(mobileAppDao.save(Mockito.<TenantId>any(), Mockito.<MobileApp>any())).thenReturn(new MobileApp());
    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act
    defaultSystemDataLoaderService.updateSecuritySettings();

    // Assert
    verify(mobileAppDao).save(isA(TenantId.class), isA(MobileApp.class));
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(jwtSettingsService).getJwtSettings();
    verify(jwtSettingsService).saveJwtSettings(isA(JwtSettings.class));
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#createOAuth2Templates()}.
   * <ul>
   *   <li>Given {@link InstallScripts} {@link InstallScripts#createOAuth2Templates()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#createOAuth2Templates()}
   */
  @Test
  @DisplayName("Test createOAuth2Templates(); given InstallScripts createOAuth2Templates() does nothing")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultSystemDataLoaderService.createOAuth2Templates()"})
  void testCreateOAuth2Templates_givenInstallScriptsCreateOAuth2TemplatesDoesNothing() throws Exception {
    // Arrange
    doNothing().when(installScripts).createOAuth2Templates();

    // Act
    defaultSystemDataLoaderService.createOAuth2Templates();

    // Assert
    verify(installScripts).createOAuth2Templates();
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#createOAuth2Templates()}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#createOAuth2Templates()}
   */
  @Test
  @DisplayName("Test createOAuth2Templates(); then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultSystemDataLoaderService.createOAuth2Templates()"})
  void testCreateOAuth2Templates_thenThrowDataValidationException() throws Exception {
    // Arrange
    doThrow(new DataValidationException("An error occurred")).when(installScripts).createOAuth2Templates();

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultSystemDataLoaderService.createOAuth2Templates());
    verify(installScripts).createOAuth2Templates();
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#loadSystemWidgets()}.
   * <ul>
   *   <li>Given {@link InstallScripts} {@link InstallScripts#loadSystemWidgets()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#loadSystemWidgets()}
   */
  @Test
  @DisplayName("Test loadSystemWidgets(); given InstallScripts loadSystemWidgets() does nothing")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultSystemDataLoaderService.loadSystemWidgets()"})
  void testLoadSystemWidgets_givenInstallScriptsLoadSystemWidgetsDoesNothing() throws Exception {
    // Arrange
    doNothing().when(installScripts).loadSystemWidgets();

    // Act
    defaultSystemDataLoaderService.loadSystemWidgets();

    // Assert
    verify(installScripts).loadSystemWidgets();
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#loadSystemWidgets()}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#loadSystemWidgets()}
   */
  @Test
  @DisplayName("Test loadSystemWidgets(); then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultSystemDataLoaderService.loadSystemWidgets()"})
  void testLoadSystemWidgets_thenThrowDataValidationException() throws Exception {
    // Arrange
    doThrow(new DataValidationException("An error occurred")).when(installScripts).loadSystemWidgets();

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultSystemDataLoaderService.loadSystemWidgets());
    verify(installScripts).loadSystemWidgets();
  }
}
