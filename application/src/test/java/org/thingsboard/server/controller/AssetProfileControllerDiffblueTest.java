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
class AssetProfileControllerDiffblueTest {
  @InjectMocks
  private AssetProfileController assetProfileController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link AssetProfileController#getAssetProfiles(int, int, String, String, String)}.
   * <p>
   * Method under test: {@link AssetProfileController#getAssetProfiles(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getAssetProfiles(int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData AssetProfileController.getAssetProfiles(int, int, String, String, String)"})
  void testGetAssetProfiles() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/assetProfiles")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(assetProfileController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfileInfos(int, int, String, String, String)}.
   * <p>
   * Method under test: {@link AssetProfileController#getAssetProfileInfos(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getAssetProfileInfos(int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData AssetProfileController.getAssetProfileInfos(int, int, String, String, String)"})
  void testGetAssetProfileInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/assetProfileInfos")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(assetProfileController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfileNames(boolean)}.
   * <p>
   * Method under test: {@link AssetProfileController#getAssetProfileNames(boolean)}
   */
  @Test
  @DisplayName("Test getAssetProfileNames(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List AssetProfileController.getAssetProfileNames(boolean)"})
  void testGetAssetProfileNames() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/assetProfile/names")
        .param("activeOnly", "https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(assetProfileController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
