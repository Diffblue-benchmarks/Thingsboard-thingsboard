package org.thingsboard.server.controller;

import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.ClaimRequest;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.SaveDeviceWithCredentialsRequest;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class DeviceControllerDiffblueTest {
  @InjectMocks private DeviceController deviceController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link DeviceController#saveDeviceWithCredentials(SaveDeviceWithCredentialsRequest)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceController#saveDeviceWithCredentials(SaveDeviceWithCredentialsRequest)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceWithCredentials(SaveDeviceWithCredentialsRequest); then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Device DeviceController.saveDeviceWithCredentials(SaveDeviceWithCredentialsRequest)"
  })
  void testSaveDeviceWithCredentials_thenStatusFourHundred() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/device-with-credentials")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            objectMapper.writeValueAsString(
                new SaveDeviceWithCredentialsRequest(null, new DeviceCredentials())));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link DeviceController#saveDeviceWithCredentials(SaveDeviceWithCredentialsRequest)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceController#saveDeviceWithCredentials(SaveDeviceWithCredentialsRequest)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceWithCredentials(SaveDeviceWithCredentialsRequest); then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Device DeviceController.saveDeviceWithCredentials(SaveDeviceWithCredentialsRequest)"
  })
  void testSaveDeviceWithCredentials_thenStatusFourHundred2() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/device-with-credentials")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            objectMapper.writeValueAsString(
                new SaveDeviceWithCredentialsRequest(null, new DeviceCredentials())));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link DeviceController#saveDeviceWithCredentials(SaveDeviceWithCredentialsRequest)}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceController#saveDeviceWithCredentials(SaveDeviceWithCredentialsRequest)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceWithCredentials(SaveDeviceWithCredentialsRequest); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Device DeviceController.saveDeviceWithCredentials(SaveDeviceWithCredentialsRequest)"
  })
  void testSaveDeviceWithCredentials_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/device-with-credentials");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    Device device = new Device();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            objectMapper.writeValueAsString(
                new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials())));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link DeviceController#updateDeviceCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link DeviceController#updateDeviceCredentials(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test updateDeviceCredentials(DeviceCredentials); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceCredentials DeviceController.updateDeviceCredentials(DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/device/credentials");
    postResult.characterEncoding("https://example.org/example");

    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCreatedTime(1L);
    deviceCredentials.setCredentialsId("42");
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsValue("42");
    deviceCredentials.setDeviceId(null);
    deviceCredentials.setId(
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceCredentials.setVersion(1L);
    String content = new ObjectMapper().writeValueAsString(deviceCredentials);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link DeviceController#getTenantDevices(int, int, String, String, String, String)}.
   *
   * <p>Method under test: {@link DeviceController#getTenantDevices(int, int, String, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getTenantDevices(int, int, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceController.getTenantDevices(int, int, String, String, String, String)"
  })
  void testGetTenantDevices() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/tenant/devices")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link DeviceController#getTenantDeviceInfos(int, int, String, String, Boolean, String,
   * String, String)}.
   *
   * <p>Method under test: {@link DeviceController#getTenantDeviceInfos(int, int, String, String,
   * Boolean, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantDeviceInfos(int, int, String, String, Boolean, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceController.getTenantDeviceInfos(int, int, String, String, Boolean, String, String, String)"
  })
  void testGetTenantDeviceInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/tenant/deviceInfos")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link DeviceController#getCustomerDevices(String, int, int, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link DeviceController#getCustomerDevices(String, int, int, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test getCustomerDevices(String, int, int, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceController.getCustomerDevices(String, int, int, String, String, String, String)"
  })
  void testGetCustomerDevices() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/customer/{customerId}/devices", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link DeviceController#getCustomerDeviceInfos(String, int, int, String, String, Boolean,
   * String, String, String)}.
   *
   * <p>Method under test: {@link DeviceController#getCustomerDeviceInfos(String, int, int, String,
   * String, Boolean, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getCustomerDeviceInfos(String, int, int, String, String, Boolean, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceController.getCustomerDeviceInfos(String, int, int, String, String, Boolean, String, String, String)"
  })
  void testGetCustomerDeviceInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/customer/{customerId}/deviceInfos", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link DeviceController#claimDevice(String, ClaimRequest)}.
   *
   * <p>Method under test: {@link DeviceController#claimDevice(String, ClaimRequest)}
   */
  @Test
  @DisplayName("Test claimDevice(String, ClaimRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult DeviceController.claimDevice(String, ClaimRequest)"
  })
  void testClaimDevice() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/customer/device/{deviceName}/claim", "Device Name");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new ClaimRequest(null)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link DeviceController#getEdgeDevices(String, int, int, String, String, Boolean, String,
   * String, String, Long, Long)}.
   *
   * <p>Method under test: {@link DeviceController#getEdgeDevices(String, int, int, String, String,
   * Boolean, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getEdgeDevices(String, int, int, String, String, Boolean, String, String, String, Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceController.getEdgeDevices(String, int, int, String, String, Boolean, String, String, String, Long, Long)"
  })
  void testGetEdgeDevices() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/devices", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
