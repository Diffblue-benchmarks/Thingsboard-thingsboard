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
class DeviceProfileControllerDiffblueTest {
  @InjectMocks private DeviceProfileController deviceProfileController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link DeviceProfileController#getDeviceProfileById(String, boolean)}.
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfileById(String, boolean)}
   */
  @Test
  @DisplayName("Test getDeviceProfileById(String, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.DeviceProfile DeviceProfileController.getDeviceProfileById(String, boolean)"
  })
  void testGetDeviceProfileById() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/deviceProfile/{deviceProfileId}", "42")
            .param("inlineImages", "https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceProfileController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfiles(int, int, String, String, String)}.
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfiles(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getDeviceProfiles(int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileController.getDeviceProfiles(int, int, String, String, String)"
  })
  void testGetDeviceProfiles() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/deviceProfiles")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceProfileController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfileInfos(int, int, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfileInfos(int, int, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test getDeviceProfileInfos(int, int, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileController.getDeviceProfileInfos(int, int, String, String, String, String)"
  })
  void testGetDeviceProfileInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/deviceProfileInfos")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceProfileController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfileNames(boolean)}.
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfileNames(boolean)}
   */
  @Test
  @DisplayName("Test getDeviceProfileNames(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List DeviceProfileController.getDeviceProfileNames(boolean)"})
  void testGetDeviceProfileNames() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/deviceProfile/names")
            .param("activeOnly", "https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceProfileController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
