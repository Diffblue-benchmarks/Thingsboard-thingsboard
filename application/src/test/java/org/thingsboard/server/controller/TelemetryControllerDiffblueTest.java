package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletResponse;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class TelemetryControllerDiffblueTest {
  @InjectMocks private TelemetryController telemetryController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link TelemetryController#deleteDeviceAttributes(String, AttributeScope, String)}.
   *
   * <p>Method under test: {@link TelemetryController#deleteDeviceAttributes(String, AttributeScope,
   * String)}
   */
  @Test
  @DisplayName("Test deleteDeviceAttributes(String, AttributeScope, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.deleteDeviceAttributes(String, AttributeScope, String)"
  })
  void testDeleteDeviceAttributes() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete(
                "/api/plugins/telemetry/{deviceId}/{scope}", "42", AttributeScope.CLIENT_SCOPE)
            .param("keys", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link TelemetryController#deleteEntityAttributes(String, String, AttributeScope,
   * String)}.
   *
   * <p>Method under test: {@link TelemetryController#deleteEntityAttributes(String, String,
   * AttributeScope, String)}
   */
  @Test
  @DisplayName("Test deleteEntityAttributes(String, String, AttributeScope, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.deleteEntityAttributes(String, String, AttributeScope, String)"
  })
  void testDeleteEntityAttributes() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder deleteResult =
        MockMvcRequestBuilders.delete(
            "/api/plugins/telemetry/{entityType}/{entityId}/{scope}",
            "Entity Type",
            "42",
            AttributeScope.CLIENT_SCOPE);

    MockHttpServletRequestBuilder requestBuilder = deleteResult.param("keys", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }
}
