package org.thingsboard.server.controller;

import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.LogoutRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.AndroidConfig;
import org.thingsboard.server.common.data.mobile.AndroidConfig.AndroidConfigBuilder;
import org.thingsboard.server.common.data.mobile.BadgePosition;
import org.thingsboard.server.common.data.mobile.IosConfig;
import org.thingsboard.server.common.data.mobile.MobileAppSettings;
import org.thingsboard.server.common.data.mobile.QRCodeConfig;
import org.thingsboard.server.common.data.security.model.JwtPair;
import org.thingsboard.server.dao.mobile.MobileAppSettingsService;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.mobile.secret.MobileAppSecretService;

@ExtendWith(MockitoExtension.class)
class MobileApplicationControllerDiffblueTest {
  @Mock
  private MobileAppSecretService mobileAppSecretService;

  @Mock
  private MobileAppSettingsService mobileAppSettingsService;

  @InjectMocks
  private MobileApplicationController mobileApplicationController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link MobileApplicationController#getAssetLinks()}.
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code /.well-known/assetlinks.json}.</li>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApplicationController#getAssetLinks()}
   */
  @Test
  @DisplayName("Test getAssetLinks(); when get(String, Object[]) '/.well-known/assetlinks.json'; then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity MobileApplicationController.getAssetLinks()"})
  void testGetAssetLinks_whenGetWellKnownAssetlinksJson_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(mobileAppSettingsService.getMobileAppSettings(Mockito.<TenantId>any())).thenReturn(new MobileAppSettings());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/.well-known/assetlinks.json");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link MobileApplicationController#getAppleAppSiteAssociation()}.
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code /.well-known/apple-app-site-association}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApplicationController#getAppleAppSiteAssociation()}
   */
  @Test
  @DisplayName("Test getAppleAppSiteAssociation(); when get(String, Object[]) '/.well-known/apple-app-site-association'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity MobileApplicationController.getAppleAppSiteAssociation()"})
  void testGetAppleAppSiteAssociation_whenGetWellKnownAppleAppSiteAssociation() throws Exception {
    // Arrange
    when(mobileAppSettingsService.getMobileAppSettings(Mockito.<TenantId>any())).thenReturn(new MobileAppSettings());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/.well-known/apple-app-site-association");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link MobileApplicationController#saveMobileAppSettings(MobileAppSettings)}.
   * <ul>
   *   <li>Then status four hundred fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApplicationController#saveMobileAppSettings(MobileAppSettings)}
   */
  @Test
  @DisplayName("Test saveMobileAppSettings(MobileAppSettings); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MobileAppSettings MobileApplicationController.saveMobileAppSettings(MobileAppSettings)"})
  void testSaveMobileAppSettings_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/mobile/app/settings");
    postResult.characterEncoding("https://example.org/example");

    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    AndroidConfig androidConfig = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();
    mobileAppSettings.setAndroidConfig(androidConfig);
    mobileAppSettings.setCreatedTime(1L);
    mobileAppSettings.setDefaultAppStoreLink("Default App Store Link");
    mobileAppSettings.setDefaultGooglePlayLink("Default Google Play Link");
    mobileAppSettings.setId(null);
    IosConfig iosConfig = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();
    mobileAppSettings.setIosConfig(iosConfig);
    QRCodeConfig qrCodeConfig = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    mobileAppSettings.setQrCodeConfig(qrCodeConfig);
    mobileAppSettings.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    mobileAppSettings.setUseDefaultApp(true);
    String content = (new ObjectMapper()).writeValueAsString(mobileAppSettings);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link MobileApplicationController#getMobileAppSettings()}.
   * <p>
   * Method under test: {@link MobileApplicationController#getMobileAppSettings()}
   */
  @Test
  @DisplayName("Test getMobileAppSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MobileAppSettings MobileApplicationController.getMobileAppSettings()"})
  void testGetMobileAppSettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link MobileApplicationController#getMobileAppSettings()}.
   * <p>
   * Method under test: {@link MobileApplicationController#getMobileAppSettings()}
   */
  @Test
  @DisplayName("Test getMobileAppSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MobileAppSettings MobileApplicationController.getMobileAppSettings()"})
  void testGetMobileAppSettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link MobileApplicationController#getMobileAppSettings()}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApplicationController#getMobileAppSettings()}
   */
  @Test
  @DisplayName("Test getMobileAppSettings(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MobileAppSettings MobileApplicationController.getMobileAppSettings()"})
  void testGetMobileAppSettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link MobileApplicationController#getMobileAppSettings()}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApplicationController#getMobileAppSettings()}
   */
  @Test
  @DisplayName("Test getMobileAppSettings(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MobileAppSettings MobileApplicationController.getMobileAppSettings()"})
  void testGetMobileAppSettings_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link MobileApplicationController#getMobileAppDeepLink(HttpServletRequest)}.
   * <p>
   * Method under test: {@link MobileApplicationController#getMobileAppDeepLink(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getMobileAppDeepLink(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MobileApplicationController.getMobileAppDeepLink(HttpServletRequest)"})
  void testGetMobileAppDeepLink() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link MobileApplicationController#getMobileAppDeepLink(HttpServletRequest)}.
   * <p>
   * Method under test: {@link MobileApplicationController#getMobileAppDeepLink(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getMobileAppDeepLink(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MobileApplicationController.getMobileAppDeepLink(HttpServletRequest)"})
  void testGetMobileAppDeepLink2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link MobileApplicationController#getMobileAppDeepLink(HttpServletRequest)}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApplicationController#getMobileAppDeepLink(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getMobileAppDeepLink(HttpServletRequest); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MobileApplicationController.getMobileAppDeepLink(HttpServletRequest)"})
  void testGetMobileAppDeepLink_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link MobileApplicationController#getMobileAppDeepLink(HttpServletRequest)}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApplicationController#getMobileAppDeepLink(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getMobileAppDeepLink(HttpServletRequest); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MobileApplicationController.getMobileAppDeepLink(HttpServletRequest)"})
  void testGetMobileAppDeepLink_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link MobileApplicationController#getUserTokenByMobileSecret(String)}.
   * <ul>
   *   <li>When {@code Secret}.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApplicationController#getUserTokenByMobileSecret(String)}
   */
  @Test
  @DisplayName("Test getUserTokenByMobileSecret(String); when 'Secret'; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JwtPair MobileApplicationController.getUserTokenByMobileSecret(String)"})
  void testGetUserTokenByMobileSecret_whenSecret_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(mobileAppSecretService.getJwtPair(Mockito.<String>any())).thenReturn(new JwtPair("ABC123", "ABC123"));
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/noauth/qr/{secret}", "Secret");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("{\"token\":\"ABC123\",\"refreshToken\":\"ABC123\"}"));
  }

  /**
   * Test {@link MobileApplicationController#getApplicationRedirect(String)}.
   * <p>
   * Method under test: {@link MobileApplicationController#getApplicationRedirect(String)}
   */
  @Test
  @DisplayName("Test getApplicationRedirect(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity MobileApplicationController.getApplicationRedirect(String)"})
  void testGetApplicationRedirect() throws Exception {
    // Arrange
    AndroidConfigBuilder builderResult = AndroidConfig.builder();
    builderResult.enabled(true);
    AndroidConfig androidConfig = builderResult.appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();

    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    IosConfig iosConfig = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();
    mobileAppSettings.setIosConfig(iosConfig);
    mobileAppSettings.setAndroidConfig(androidConfig);
    when(mobileAppSettingsService.getMobileAppSettings(Mockito.<TenantId>any())).thenReturn(mobileAppSettings);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/noauth/qr")
        .header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:12.0) Gecko/20100101 Firefox/12.0");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }
}
