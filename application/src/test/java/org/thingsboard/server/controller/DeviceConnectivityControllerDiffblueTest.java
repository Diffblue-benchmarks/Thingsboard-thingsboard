package org.thingsboard.server.controller;

import static org.mockito.Mockito.when;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class DeviceConnectivityControllerDiffblueTest {
  @InjectMocks private DeviceConnectivityController deviceConnectivityController;

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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isNotFound());
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk());
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isNotFound());
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
