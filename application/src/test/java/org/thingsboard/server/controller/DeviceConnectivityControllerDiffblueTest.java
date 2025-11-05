package org.thingsboard.server.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.dao.device.DeviceConnectivityService;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class DeviceConnectivityControllerDiffblueTest {
  @InjectMocks private DeviceConnectivityController deviceConnectivityController;

  @Mock private DeviceConnectivityService deviceConnectivityService;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link DeviceConnectivityController#getDevicePublishTelemetryCommands(String,
   * HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceConnectivityController#getDevicePublishTelemetryCommands(String, HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test getDevicePublishTelemetryCommands(String, HttpServletRequest); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.databind.JsonNode DeviceConnectivityController.getDevicePublishTelemetryCommands(String, HttpServletRequest)"
  })
  void testGetDevicePublishTelemetryCommands_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceConnectivityController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link DeviceConnectivityController#getDevicePublishTelemetryCommands(String,
   * HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceConnectivityController#getDevicePublishTelemetryCommands(String, HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test getDevicePublishTelemetryCommands(String, HttpServletRequest); then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.databind.JsonNode DeviceConnectivityController.getDevicePublishTelemetryCommands(String, HttpServletRequest)"
  })
  void testGetDevicePublishTelemetryCommands_thenStatusIsOk() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceConnectivityController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DeviceConnectivityController#downloadServerCertificate(String)}.
   *
   * <ul>
   *   <li>Then content contentType {@code application/octet-stream}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityController#downloadServerCertificate(String)}
   */
  @Test
  @DisplayName(
      "Test downloadServerCertificate(String); then content contentType 'application/octet-stream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResponseEntity DeviceConnectivityController.downloadServerCertificate(String)"
  })
  void testDownloadServerCertificate_thenContentContentTypeApplicationOctetStream()
      throws Exception {
    // Arrange
    when(deviceConnectivityService.getPemCertFile(Mockito.<String>any()))
        .thenReturn(new ByteArrayResource("AXAXAXAX".getBytes("UTF-8")));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/device-connectivity/{protocol}/certificate/download", "Protocol");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceConnectivityController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/octet-stream"))
        .andExpect(content().string("AXAXAXAX"));
  }

  /**
   * Test {@link DeviceConnectivityController#downloadGatewayDockerCompose(String,
   * HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityController#downloadGatewayDockerCompose(String,
   * HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test downloadGatewayDockerCompose(String, HttpServletRequest); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResponseEntity DeviceConnectivityController.downloadGatewayDockerCompose(String, HttpServletRequest)"
  })
  void testDownloadGatewayDockerCompose_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceConnectivityController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link DeviceConnectivityController#downloadGatewayDockerCompose(String,
   * HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityController#downloadGatewayDockerCompose(String,
   * HttpServletRequest)}
   */
  @Test
  @DisplayName("Test downloadGatewayDockerCompose(String, HttpServletRequest); then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResponseEntity DeviceConnectivityController.downloadGatewayDockerCompose(String, HttpServletRequest)"
  })
  void testDownloadGatewayDockerCompose_thenStatusIsOk() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(deviceConnectivityController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }
}
