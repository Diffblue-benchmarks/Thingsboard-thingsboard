package org.thingsboard.server.controller;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class OtaPackageControllerDiffblueTest {
  @InjectMocks private OtaPackageController otaPackageController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link OtaPackageController#getOtaPackages(int, int, String, String, String)} with {@code
   * pageSize}, {@code page}, {@code textSearch}, {@code sortProperty}, {@code sortOrder}.
   *
   * <p>Method under test: {@link OtaPackageController#getOtaPackages(int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getOtaPackages(int, int, String, String, String) with 'pageSize', 'page', 'textSearch', 'sortProperty', 'sortOrder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData OtaPackageController.getOtaPackages(int, int, String, String, String)"
  })
  void testGetOtaPackagesWithPageSizePageTextSearchSortPropertySortOrder() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/otaPackages").param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(otaPackageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link OtaPackageController#getOtaPackages(String, String, int, int, String, String,
   * String)} with {@code strDeviceProfileId}, {@code strType}, {@code pageSize}, {@code page},
   * {@code textSearch}, {@code sortProperty}, {@code sortOrder}.
   *
   * <p>Method under test: {@link OtaPackageController#getOtaPackages(String, String, int, int,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getOtaPackages(String, String, int, int, String, String, String) with 'strDeviceProfileId', 'strType', 'pageSize', 'page', 'textSearch', 'sortProperty', 'sortOrder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData OtaPackageController.getOtaPackages(String, String, int, int, String, String, String)"
  })
  void testGetOtaPackagesWithStrDeviceProfileIdStrTypePageSizePageTextSearchSortPropertySortOrder()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/otaPackages/{deviceProfileId}/{type}", "42", "Type")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(otaPackageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
