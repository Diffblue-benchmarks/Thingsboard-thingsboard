package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
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
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class RuleEngineControllerDiffblueTest {
  @InjectMocks private RuleEngineController ruleEngineController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link RuleEngineController#handleRuleEngineRequest(String, String, String, int, String)}
   * with {@code entityType}, {@code entityIdStr}, {@code queueName}, {@code timeout}, {@code
   * requestBody}.
   *
   * <p>Method under test: {@link RuleEngineController#handleRuleEngineRequest(String, String,
   * String, int, String)}
   */
  @Test
  @DisplayName(
      "Test handleRuleEngineRequest(String, String, String, int, String) with 'entityType', 'entityIdStr', 'queueName', 'timeout', 'requestBody'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RuleEngineController.handleRuleEngineRequest(String, String, String, int, String)"
  })
  void testHandleRuleEngineRequestWithEntityTypeEntityIdStrQueueNameTimeoutRequestBody()
      throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/rule-engine/{entityType}/{entityId}/{queueName}/{timeout}",
            "Entity Type",
            "42",
            "Queue Name",
            10);

    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString(""));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleEngineController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RuleEngineController#handleRuleEngineRequest(String, String, String, int, String)}
   * with {@code entityType}, {@code entityIdStr}, {@code queueName}, {@code timeout}, {@code
   * requestBody}.
   *
   * <p>Method under test: {@link RuleEngineController#handleRuleEngineRequest(String, String,
   * String, int, String)}
   */
  @Test
  @DisplayName(
      "Test handleRuleEngineRequest(String, String, String, int, String) with 'entityType', 'entityIdStr', 'queueName', 'timeout', 'requestBody'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RuleEngineController.handleRuleEngineRequest(String, String, String, int, String)"
  })
  void testHandleRuleEngineRequestWithEntityTypeEntityIdStrQueueNameTimeoutRequestBody2()
      throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/rule-engine/{entityType}/{entityId}/{queueName}/{timeout}",
            "Entity Type",
            "42",
            "Queue Name",
            10);
    postResult.characterEncoding("You aren't authorized to perform this operation!");

    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString(""));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleEngineController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }

  /**
   * Test {@link RuleEngineController#handleRuleEngineRequest(String, String, String)} with {@code
   * entityType}, {@code entityIdStr}, {@code requestBody}.
   *
   * <p>Method under test: {@link RuleEngineController#handleRuleEngineRequest(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test handleRuleEngineRequest(String, String, String) with 'entityType', 'entityIdStr', 'requestBody'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RuleEngineController.handleRuleEngineRequest(String, String, String)"
  })
  void testHandleRuleEngineRequestWithEntityTypeEntityIdStrRequestBody() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/rule-engine/{entityType}/{entityId}", "Entity Type", "42");
    postResult.characterEncoding("You aren't authorized to perform this operation!");

    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString(""));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleEngineController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }

  /**
   * Test {@link RuleEngineController#handleRuleEngineRequest(String, String, String)} with {@code
   * entityType}, {@code entityIdStr}, {@code requestBody}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineController#handleRuleEngineRequest(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test handleRuleEngineRequest(String, String, String) with 'entityType', 'entityIdStr', 'requestBody'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RuleEngineController.handleRuleEngineRequest(String, String, String)"
  })
  void testHandleRuleEngineRequestWithEntityTypeEntityIdStrRequestBody_thenStatusIsOk()
      throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/rule-engine/{entityType}/{entityId}", "Entity Type", "42");

    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString(""));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleEngineController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RuleEngineController#handleRuleEngineRequest(String, String, int, String)} with
   * {@code entityType}, {@code entityIdStr}, {@code timeout}, {@code requestBody}.
   *
   * <p>Method under test: {@link RuleEngineController#handleRuleEngineRequest(String, String, int,
   * String)}
   */
  @Test
  @DisplayName(
      "Test handleRuleEngineRequest(String, String, int, String) with 'entityType', 'entityIdStr', 'timeout', 'requestBody'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RuleEngineController.handleRuleEngineRequest(String, String, int, String)"
  })
  void testHandleRuleEngineRequestWithEntityTypeEntityIdStrTimeoutRequestBody() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/rule-engine/{entityType}/{entityId}/{timeout}", "Entity Type", "42", 10);

    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString(""));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleEngineController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RuleEngineController#handleRuleEngineRequest(String, String, int, String)} with
   * {@code entityType}, {@code entityIdStr}, {@code timeout}, {@code requestBody}.
   *
   * <p>Method under test: {@link RuleEngineController#handleRuleEngineRequest(String, String, int,
   * String)}
   */
  @Test
  @DisplayName(
      "Test handleRuleEngineRequest(String, String, int, String) with 'entityType', 'entityIdStr', 'timeout', 'requestBody'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RuleEngineController.handleRuleEngineRequest(String, String, int, String)"
  })
  void testHandleRuleEngineRequestWithEntityTypeEntityIdStrTimeoutRequestBody2() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/rule-engine/{entityType}/{entityId}/{timeout}", "Entity Type", "42", 10);
    postResult.characterEncoding("You aren't authorized to perform this operation!");

    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString(""));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleEngineController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }

  /**
   * Test {@link RuleEngineController#handleRuleEngineRequest(String)} with {@code requestBody}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineController#handleRuleEngineRequest(String)}
   */
  @Test
  @DisplayName(
      "Test handleRuleEngineRequest(String) with 'requestBody'; then status four hundred fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RuleEngineController.handleRuleEngineRequest(String)"
  })
  void testHandleRuleEngineRequestWithRequestBody_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/rule-engine/");
    postResult.characterEncoding("You aren't authorized to perform this operation!");

    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString(""));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleEngineController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }

  /**
   * Test {@link RuleEngineController#handleRuleEngineRequest(String)} with {@code requestBody}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineController#handleRuleEngineRequest(String)}
   */
  @Test
  @DisplayName("Test handleRuleEngineRequest(String) with 'requestBody'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RuleEngineController.handleRuleEngineRequest(String)"
  })
  void testHandleRuleEngineRequestWithRequestBody_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/rule-engine/").contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString(""));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleEngineController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }
}
