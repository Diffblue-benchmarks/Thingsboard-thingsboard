package org.thingsboard.server.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.AndroidConfig;
import org.thingsboard.server.common.data.mobile.AndroidConfig.AndroidConfigBuilder;
import org.thingsboard.server.common.data.mobile.IosConfig;
import org.thingsboard.server.common.data.mobile.MobileAppSettings;
import org.thingsboard.server.dao.mobile.MobileAppSettingsService;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class MobileApplicationControllerDiffblueTest {
  @Mock private MobileAppSettingsService mobileAppSettingsService;

  @InjectMocks private MobileApplicationController mobileApplicationController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link MobileApplicationController#getAssetLinks()}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code
   *       /.well-known/assetlinks.json}.
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link MobileApplicationController#getAssetLinks()}
   */
  @Test
  @DisplayName(
      "Test getAssetLinks(); when get(String, Object[]) '/.well-known/assetlinks.json'; then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity MobileApplicationController.getAssetLinks()"
  })
  void testGetAssetLinks_whenGetWellKnownAssetlinksJson_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(mobileAppSettingsService.getMobileAppSettings(Mockito.<TenantId>any()))
        .thenReturn(new MobileAppSettings());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/.well-known/assetlinks.json");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link MobileApplicationController#getAppleAppSiteAssociation()}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code
   *       /.well-known/apple-app-site-association}.
   * </ul>
   *
   * <p>Method under test: {@link MobileApplicationController#getAppleAppSiteAssociation()}
   */
  @Test
  @DisplayName(
      "Test getAppleAppSiteAssociation(); when get(String, Object[]) '/.well-known/apple-app-site-association'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity MobileApplicationController.getAppleAppSiteAssociation()"
  })
  void testGetAppleAppSiteAssociation_whenGetWellKnownAppleAppSiteAssociation() throws Exception {
    // Arrange
    when(mobileAppSettingsService.getMobileAppSettings(Mockito.<TenantId>any()))
        .thenReturn(new MobileAppSettings());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/.well-known/apple-app-site-association");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link MobileApplicationController#getApplicationRedirect(String)}.
   *
   * <p>Method under test: {@link MobileApplicationController#getApplicationRedirect(String)}
   */
  @Test
  @DisplayName("Test getApplicationRedirect(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity MobileApplicationController.getApplicationRedirect(String)"
  })
  void testGetApplicationRedirect() throws Exception {
    // Arrange
    AndroidConfigBuilder builderResult = AndroidConfig.builder();
    builderResult.enabled(true);
    AndroidConfig androidConfig =
        builderResult
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setIosConfig(
        IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build());
    mobileAppSettings.setAndroidConfig(androidConfig);
    when(mobileAppSettingsService.getMobileAppSettings(Mockito.<TenantId>any()))
        .thenReturn(mobileAppSettings);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/noauth/qr")
            .header(
                "User-Agent",
                "Mozilla/5.0 (X11; Linux x86_64; rv:12.0) Gecko/20100101 Firefox/12.0");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link MobileApplicationController#getApplicationRedirect(String)}.
   *
   * <ul>
   *   <li>Given {@link MobileAppSettings#MobileAppSettings()} UseDefaultApp is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MobileApplicationController#getApplicationRedirect(String)}
   */
  @Test
  @DisplayName(
      "Test getApplicationRedirect(String); given MobileAppSettings() UseDefaultApp is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity MobileApplicationController.getApplicationRedirect(String)"
  })
  void testGetApplicationRedirect_givenMobileAppSettingsUseDefaultAppIsTrue() throws Exception {
    // Arrange
    AndroidConfigBuilder builderResult = AndroidConfig.builder();
    builderResult.enabled(true);
    AndroidConfig androidConfig =
        builderResult
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setUseDefaultApp(true);
    mobileAppSettings.setAndroidConfig(androidConfig);
    when(mobileAppSettingsService.getMobileAppSettings(Mockito.<TenantId>any()))
        .thenReturn(mobileAppSettings);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/noauth/qr")
            .header(
                "User-Agent",
                "Mozilla/5.0 (X11; Linux x86_64; rv:12.0) Gecko/20100101 Firefox/12.0");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileApplicationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }
}
