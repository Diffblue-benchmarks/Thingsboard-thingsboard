package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.DoubleNode;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.kv.IntervalType;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class TelemetryControllerDiffblueTest {
  @InjectMocks private TelemetryController telemetryController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link TelemetryController#getAttributeKeys(String, String)}.
   *
   * <p>Method under test: {@link TelemetryController#getAttributeKeys(String, String)}
   */
  @Test
  @DisplayName("Test getAttributeKeys(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.getAttributeKeys(String, String)"
  })
  void testGetAttributeKeys() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/plugins/telemetry/{entityType}/{entityId}/keys/attributes", "Entity Type", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#getAttributeKeysByScope(String, String, AttributeScope)}.
   *
   * <p>Method under test: {@link TelemetryController#getAttributeKeysByScope(String, String,
   * AttributeScope)}
   */
  @Test
  @DisplayName("Test getAttributeKeysByScope(String, String, AttributeScope)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.getAttributeKeysByScope(String, String, AttributeScope)"
  })
  void testGetAttributeKeysByScope() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/plugins/telemetry/{entityType}/{entityId}/keys/attributes/{scope}",
            "Entity Type",
            "42",
            AttributeScope.CLIENT_SCOPE);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#getAttributes(String, String, String)}.
   *
   * <p>Method under test: {@link TelemetryController#getAttributes(String, String, String)}
   */
  @Test
  @DisplayName("Test getAttributes(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.getAttributes(String, String, String)"
  })
  void testGetAttributes() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/plugins/telemetry/{entityType}/{entityId}/values/attributes",
            "Entity Type",
            "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#getAttributesByScope(String, String, AttributeScope, String)}.
   *
   * <p>Method under test: {@link TelemetryController#getAttributesByScope(String, String,
   * AttributeScope, String)}
   */
  @Test
  @DisplayName("Test getAttributesByScope(String, String, AttributeScope, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.getAttributesByScope(String, String, AttributeScope, String)"
  })
  void testGetAttributesByScope() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/plugins/telemetry/{entityType}/{entityId}/values/attributes/{scope}",
            "Entity Type",
            "42",
            AttributeScope.CLIENT_SCOPE);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#getTimeseriesKeys(String, String)}.
   *
   * <p>Method under test: {@link TelemetryController#getTimeseriesKeys(String, String)}
   */
  @Test
  @DisplayName("Test getTimeseriesKeys(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.getTimeseriesKeys(String, String)"
  })
  void testGetTimeseriesKeys() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/plugins/telemetry/{entityType}/{entityId}/keys/timeseries", "Entity Type", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#getLatestTimeseries(String, String, String, Boolean)}.
   *
   * <p>Method under test: {@link TelemetryController#getLatestTimeseries(String, String, String,
   * Boolean)}
   */
  @Test
  @DisplayName("Test getLatestTimeseries(String, String, String, Boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.getLatestTimeseries(String, String, String, Boolean)"
  })
  void testGetLatestTimeseries() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/plugins/telemetry/{entityType}/{entityId}/values/timeseries",
            "Entity Type",
            "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#getTimeseries(String, String, String, Long, Long, IntervalType,
   * Long, String, Integer, String, String, Boolean)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#getTimeseries(String, String, String, Long,
   * Long, IntervalType, Long, String, Integer, String, String, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getTimeseries(String, String, String, Long, Long, IntervalType, Long, String, Integer, String, String, Boolean); then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.getTimeseries(String, String, String, Long, Long, IntervalType, Long, String, Integer, String, String, Boolean)"
  })
  void testGetTimeseries_thenStatusFourHundred() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("You aren't authorized to perform this operation!"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get(
                "/api/plugins/telemetry/{entityType}/{entityId}/values/timeseries",
                "Entity Type",
                "42")
            .param("agg", "foo")
            .param("endTs", "https://example.org/example");
    MockHttpServletRequestBuilder paramResult2 =
        paramResult.param("interval", String.valueOf(1L)).param("keys", "foo");
    MockHttpServletRequestBuilder paramResult3 =
        paramResult2.param("limit", String.valueOf(1)).param("orderBy", "foo");
    MockHttpServletRequestBuilder requestBuilder =
        paramResult3.param("startTs", String.valueOf(1L));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TelemetryController#getTimeseries(String, String, String, Long, Long, IntervalType,
   * Long, String, Integer, String, String, Boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#getTimeseries(String, String, String, Long,
   * Long, IntervalType, Long, String, Integer, String, String, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getTimeseries(String, String, String, Long, Long, IntervalType, Long, String, Integer, String, String, Boolean); when empty string; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.getTimeseries(String, String, String, Long, Long, IntervalType, Long, String, Integer, String, String, Boolean)"
  })
  void testGetTimeseries_whenEmptyString_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get(
                "/api/plugins/telemetry/{entityType}/{entityId}/values/timeseries",
                "Entity Type",
                "42")
            .param("agg", "foo")
            .param("endTs", "");
    MockHttpServletRequestBuilder paramResult2 =
        paramResult.param("interval", String.valueOf(1L)).param("keys", "foo");
    MockHttpServletRequestBuilder paramResult3 =
        paramResult2.param("limit", String.valueOf(1)).param("orderBy", "foo");
    MockHttpServletRequestBuilder requestBuilder =
        paramResult3.param("startTs", String.valueOf(1L));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#getTimeseries(String, String, String, Long, Long, IntervalType,
   * Long, String, Integer, String, String, Boolean)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#getTimeseries(String, String, String, Long,
   * Long, IntervalType, Long, String, Integer, String, String, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getTimeseries(String, String, String, Long, Long, IntervalType, Long, String, Integer, String, String, Boolean); when 'https://example.org/example'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.getTimeseries(String, String, String, Long, Long, IntervalType, Long, String, Integer, String, String, Boolean)"
  })
  void testGetTimeseries_whenHttpsExampleOrgExample_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get(
                "/api/plugins/telemetry/{entityType}/{entityId}/values/timeseries",
                "Entity Type",
                "42")
            .param("agg", "foo")
            .param("endTs", "https://example.org/example");
    MockHttpServletRequestBuilder paramResult2 =
        paramResult.param("interval", String.valueOf(1L)).param("keys", "foo");
    MockHttpServletRequestBuilder paramResult3 =
        paramResult2.param("limit", String.valueOf(1)).param("orderBy", "foo");
    MockHttpServletRequestBuilder requestBuilder =
        paramResult3.param("startTs", String.valueOf(1L));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#getTimeseries(String, String, String, Long, Long, IntervalType,
   * Long, String, Integer, String, String, Boolean)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequestBuilder#param(String, String[])} {@code endTs} is
   *       valueOf one.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#getTimeseries(String, String, String, Long,
   * Long, IntervalType, Long, String, Integer, String, String, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getTimeseries(String, String, String, Long, Long, IntervalType, Long, String, Integer, String, String, Boolean); when param(String, String[]) 'endTs' is valueOf one; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.getTimeseries(String, String, String, Long, Long, IntervalType, Long, String, Integer, String, String, Boolean)"
  })
  void testGetTimeseries_whenParamEndTsIsValueOfOne_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get(
                "/api/plugins/telemetry/{entityType}/{entityId}/values/timeseries",
                "Entity Type",
                "42")
            .param("agg", "foo");
    MockHttpServletRequestBuilder paramResult2 = paramResult.param("endTs", String.valueOf(1L));
    MockHttpServletRequestBuilder paramResult3 =
        paramResult2.param("interval", String.valueOf(1L)).param("keys", "foo");
    MockHttpServletRequestBuilder paramResult4 =
        paramResult3.param("limit", String.valueOf(1)).param("orderBy", "foo");
    MockHttpServletRequestBuilder requestBuilder =
        paramResult4.param("startTs", String.valueOf(1L));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#saveDeviceAttributes(String, AttributeScope, JsonNode)}.
   *
   * <p>Method under test: {@link TelemetryController#saveDeviceAttributes(String, AttributeScope,
   * JsonNode)}
   */
  @Test
  @DisplayName("Test saveDeviceAttributes(String, AttributeScope, JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveDeviceAttributes(String, AttributeScope, JsonNode)"
  })
  void testSaveDeviceAttributes() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post(
                "/api/plugins/telemetry/{deviceId}/{scope}", "42", AttributeScope.CLIENT_SCOPE)
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(DoubleNode.valueOf(10.0d)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#saveDeviceAttributes(String, AttributeScope, JsonNode)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveDeviceAttributes(String, AttributeScope,
   * JsonNode)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceAttributes(String, AttributeScope, JsonNode); then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveDeviceAttributes(String, AttributeScope, JsonNode)"
  })
  void testSaveDeviceAttributes_thenStatusFourHundred() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("foo"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post(
                "/api/plugins/telemetry/{deviceId}/{scope}",
                "Uri Variables",
                "Uri Variables",
                "Uri Variables")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(DoubleNode.valueOf(10.0d)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TelemetryController#saveDeviceAttributes(String, AttributeScope, JsonNode)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveDeviceAttributes(String, AttributeScope,
   * JsonNode)}
   */
  @Test
  @DisplayName("Test saveDeviceAttributes(String, AttributeScope, JsonNode); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveDeviceAttributes(String, AttributeScope, JsonNode)"
  })
  void testSaveDeviceAttributes_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post(
                "/api/plugins/telemetry/{deviceId}/{scope}",
                "Uri Variables",
                "Uri Variables",
                "Uri Variables")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(DoubleNode.valueOf(10.0d)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#saveEntityAttributesV1(String, String, AttributeScope,
   * JsonNode)}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveEntityAttributesV1(String, String,
   * AttributeScope, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test saveEntityAttributesV1(String, String, AttributeScope, JsonNode); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveEntityAttributesV1(String, String, AttributeScope, JsonNode)"
  })
  void testSaveEntityAttributesV1_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("foo"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/plugins/telemetry/{entityType}/{entityId}/{scope}",
            "Entity Type",
            "42",
            AttributeScope.CLIENT_SCOPE);
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(DoubleNode.valueOf(10.0d)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link TelemetryController#saveEntityAttributesV1(String, String, AttributeScope,
   * JsonNode)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveEntityAttributesV1(String, String,
   * AttributeScope, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test saveEntityAttributesV1(String, String, AttributeScope, JsonNode); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveEntityAttributesV1(String, String, AttributeScope, JsonNode)"
  })
  void testSaveEntityAttributesV1_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post(
                "/api/plugins/telemetry/{entityType}/{entityId}/{scope}",
                "Entity Type",
                "42",
                AttributeScope.CLIENT_SCOPE)
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(DoubleNode.valueOf(10.0d)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#saveEntityAttributesV1(String, String, AttributeScope,
   * JsonNode)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveEntityAttributesV1(String, String,
   * AttributeScope, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test saveEntityAttributesV1(String, String, AttributeScope, JsonNode); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveEntityAttributesV1(String, String, AttributeScope, JsonNode)"
  })
  void testSaveEntityAttributesV1_thenStatusIsOk2() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/plugins/telemetry/{entityType}/{entityId}/{scope}",
            "Entity Type",
            "42",
            AttributeScope.CLIENT_SCOPE);
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(DoubleNode.valueOf(10.0d)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#saveEntityAttributesV2(String, String, AttributeScope,
   * JsonNode)}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveEntityAttributesV2(String, String,
   * AttributeScope, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test saveEntityAttributesV2(String, String, AttributeScope, JsonNode); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveEntityAttributesV2(String, String, AttributeScope, JsonNode)"
  })
  void testSaveEntityAttributesV2_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("foo"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/plugins/telemetry/{entityType}/{entityId}/attributes/{scope}",
            "Entity Type",
            "42",
            AttributeScope.CLIENT_SCOPE);
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(DoubleNode.valueOf(10.0d)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link TelemetryController#saveEntityAttributesV2(String, String, AttributeScope,
   * JsonNode)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveEntityAttributesV2(String, String,
   * AttributeScope, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test saveEntityAttributesV2(String, String, AttributeScope, JsonNode); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveEntityAttributesV2(String, String, AttributeScope, JsonNode)"
  })
  void testSaveEntityAttributesV2_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post(
                "/api/plugins/telemetry/{entityType}/{entityId}/attributes/{scope}",
                "Entity Type",
                "42",
                AttributeScope.CLIENT_SCOPE)
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(DoubleNode.valueOf(10.0d)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#saveEntityAttributesV2(String, String, AttributeScope,
   * JsonNode)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveEntityAttributesV2(String, String,
   * AttributeScope, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test saveEntityAttributesV2(String, String, AttributeScope, JsonNode); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveEntityAttributesV2(String, String, AttributeScope, JsonNode)"
  })
  void testSaveEntityAttributesV2_thenStatusIsOk2() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/plugins/telemetry/{entityType}/{entityId}/attributes/{scope}",
            "Entity Type",
            "42",
            AttributeScope.CLIENT_SCOPE);
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(DoubleNode.valueOf(10.0d)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#saveEntityTelemetry(String, String, String, String)}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveEntityTelemetry(String, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test saveEntityTelemetry(String, String, String, String); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveEntityTelemetry(String, String, String, String)"
  })
  void testSaveEntityTelemetry_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("foo"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/plugins/telemetry/{entityType}/{entityId}/timeseries/{scope}",
            "Entity Type",
            "42",
            "Scope");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link TelemetryController#saveEntityTelemetry(String, String, String, String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveEntityTelemetry(String, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test saveEntityTelemetry(String, String, String, String); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveEntityTelemetry(String, String, String, String)"
  })
  void testSaveEntityTelemetry_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post(
                "/api/plugins/telemetry/{entityType}/{entityId}/timeseries/{scope}",
                "Entity Type",
                "42",
                "Scope")
            .contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#saveEntityTelemetry(String, String, String, String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveEntityTelemetry(String, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test saveEntityTelemetry(String, String, String, String); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveEntityTelemetry(String, String, String, String)"
  })
  void testSaveEntityTelemetry_thenStatusIsOk2() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/plugins/telemetry/{entityType}/{entityId}/timeseries/{scope}",
            "Entity Type",
            "42",
            "Scope");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#saveEntityTelemetryWithTTL(String, String, String, Long,
   * String)}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveEntityTelemetryWithTTL(String, String,
   * String, Long, String)}
   */
  @Test
  @DisplayName(
      "Test saveEntityTelemetryWithTTL(String, String, String, Long, String); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveEntityTelemetryWithTTL(String, String, String, Long, String)"
  })
  void testSaveEntityTelemetryWithTTL_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("foo"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/plugins/telemetry/{entityType}/{entityId}/timeseries/{scope}/{ttl}",
            "Entity Type",
            "42",
            "Scope",
            1L);
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link TelemetryController#saveEntityTelemetryWithTTL(String, String, String, Long,
   * String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveEntityTelemetryWithTTL(String, String,
   * String, Long, String)}
   */
  @Test
  @DisplayName(
      "Test saveEntityTelemetryWithTTL(String, String, String, Long, String); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveEntityTelemetryWithTTL(String, String, String, Long, String)"
  })
  void testSaveEntityTelemetryWithTTL_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post(
                "/api/plugins/telemetry/{entityType}/{entityId}/timeseries/{scope}/{ttl}",
                "Entity Type",
                "42",
                "Scope",
                1L)
            .contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#saveEntityTelemetryWithTTL(String, String, String, Long,
   * String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#saveEntityTelemetryWithTTL(String, String,
   * String, Long, String)}
   */
  @Test
  @DisplayName(
      "Test saveEntityTelemetryWithTTL(String, String, String, Long, String); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.saveEntityTelemetryWithTTL(String, String, String, Long, String)"
  })
  void testSaveEntityTelemetryWithTTL_thenStatusIsOk2() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/plugins/telemetry/{entityType}/{entityId}/timeseries/{scope}/{ttl}",
            "Entity Type",
            "42",
            "Scope",
            1L);
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#deleteEntityTimeseries(String, String, String, boolean, Long,
   * Long, boolean, boolean)}.
   *
   * <p>Method under test: {@link TelemetryController#deleteEntityTimeseries(String, String, String,
   * boolean, Long, Long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntityTimeseries(String, String, String, boolean, Long, Long, boolean, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.deleteEntityTimeseries(String, String, String, boolean, Long, Long, boolean, boolean)"
  })
  void testDeleteEntityTimeseries() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder deleteResult =
        MockMvcRequestBuilders.delete(
            "/api/plugins/telemetry/{entityType}/{entityId}/timeseries/delete",
            "Entity Type",
            "42");
    MockHttpServletRequestBuilder paramResult =
        deleteResult.param("deleteAllDataForKeys", String.valueOf(true)).param("keys", "foo");
    MockHttpServletRequestBuilder requestBuilder =
        paramResult.param("rewriteLatestIfDeleted", String.valueOf(true));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#deleteEntityTimeseries(String, String, String, boolean, Long,
   * Long, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#deleteEntityTimeseries(String, String, String,
   * boolean, Long, Long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntityTimeseries(String, String, String, boolean, Long, Long, boolean, boolean); then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.deleteEntityTimeseries(String, String, String, boolean, Long, Long, boolean, boolean)"
  })
  void testDeleteEntityTimeseries_thenStatusFourHundred() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("foo"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.delete(
                "/api/plugins/telemetry/{entityType}/{entityId}/timeseries/delete",
                "Entity Type",
                "42")
            .param("deleteAllDataForKeys", "https://example.org/example")
            .param("keys", "foo");
    MockHttpServletRequestBuilder requestBuilder =
        paramResult.param("rewriteLatestIfDeleted", String.valueOf(true));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TelemetryController#deleteEntityTimeseries(String, String, String, boolean, Long,
   * Long, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#deleteEntityTimeseries(String, String, String,
   * boolean, Long, Long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntityTimeseries(String, String, String, boolean, Long, Long, boolean, boolean); when 'https://example.org/example'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.deleteEntityTimeseries(String, String, String, boolean, Long, Long, boolean, boolean)"
  })
  void testDeleteEntityTimeseries_whenHttpsExampleOrgExample_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.delete(
                "/api/plugins/telemetry/{entityType}/{entityId}/timeseries/delete",
                "Entity Type",
                "42")
            .param("deleteAllDataForKeys", "https://example.org/example")
            .param("keys", "foo");
    MockHttpServletRequestBuilder requestBuilder =
        paramResult.param("rewriteLatestIfDeleted", String.valueOf(true));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#deleteDeviceAttributes(String, AttributeScope, String)}.
   *
   * <p>Method under test: {@link TelemetryController#deleteDeviceAttributes(String, AttributeScope,
   * String)}
   */
  @Test
  @DisplayName("Test deleteDeviceAttributes(String, AttributeScope, String)")
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#deleteDeviceAttributes(String, AttributeScope, String)}.
   *
   * <ul>
   *   <li>Given {@code CLIENT_SCOPE}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#deleteDeviceAttributes(String, AttributeScope,
   * String)}
   */
  @Test
  @DisplayName("Test deleteDeviceAttributes(String, AttributeScope, String); given 'CLIENT_SCOPE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.deleteDeviceAttributes(String, AttributeScope, String)"
  })
  void testDeleteDeviceAttributes_givenClientScope() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete(
                "/api/plugins/telemetry/{deviceId}/{scope}",
                "Uri Variables",
                "Uri Variables",
                "Uri Variables")
            .param("keys", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TelemetryController#deleteDeviceAttributes(String, AttributeScope, String)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryController#deleteDeviceAttributes(String, AttributeScope,
   * String)}
   */
  @Test
  @DisplayName(
      "Test deleteDeviceAttributes(String, AttributeScope, String); then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.deleteDeviceAttributes(String, AttributeScope, String)"
  })
  void testDeleteDeviceAttributes_thenStatusFourHundred() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("foo"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete(
                "/api/plugins/telemetry/{deviceId}/{scope}",
                "Uri Variables",
                "Uri Variables",
                "Uri Variables")
            .param("keys", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult TelemetryController.deleteEntityAttributes(String, String, AttributeScope, String)"
  })
  void testDeleteEntityAttributes() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete(
                "/api/plugins/telemetry/{entityType}/{entityId}/{scope}",
                "Entity Type",
                "42",
                AttributeScope.CLIENT_SCOPE)
            .param("keys", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(telemetryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
