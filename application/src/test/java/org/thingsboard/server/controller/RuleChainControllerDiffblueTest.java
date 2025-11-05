package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class RuleChainControllerDiffblueTest {
  @InjectMocks private RuleChainController ruleChainController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link RuleChainController#getRuleChainById(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#getRuleChainById(String)}
   */
  @Test
  @DisplayName("Test getRuleChainById(String); when '42'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.rule.RuleChain RuleChainController.getRuleChainById(String)"
  })
  void testGetRuleChainById_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/ruleChain/{ruleChainId}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RuleChainController#getRuleChainOutputLabels(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#getRuleChainOutputLabels(String)}
   */
  @Test
  @DisplayName("Test getRuleChainOutputLabels(String); when '42'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set RuleChainController.getRuleChainOutputLabels(String)"})
  void testGetRuleChainOutputLabels_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/ruleChain/{ruleChainId}/output/labels", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RuleChainController#getRuleChainMetaData(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#getRuleChainMetaData(String)}
   */
  @Test
  @DisplayName("Test getRuleChainMetaData(String); when '42'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.rule.RuleChainMetaData RuleChainController.getRuleChainMetaData(String)"
  })
  void testGetRuleChainMetaData_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/ruleChain/{ruleChainId}/metadata", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RuleChainController#deleteRuleChain(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#deleteRuleChain(String)}
   */
  @Test
  @DisplayName("Test deleteRuleChain(String); when '42'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainController.deleteRuleChain(String)"})
  void testDeleteRuleChain_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/ruleChain/{ruleChainId}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RuleChainController#getLatestRuleNodeDebugInput(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#getLatestRuleNodeDebugInput(String)}
   */
  @Test
  @DisplayName("Test getLatestRuleNodeDebugInput(String); when '42'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.databind.JsonNode RuleChainController.getLatestRuleNodeDebugInput(String)"
  })
  void testGetLatestRuleNodeDebugInput_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/ruleNode/{ruleNodeId}/debugIn", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RuleChainController#exportRuleChains(int)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#exportRuleChains(int)}
   */
  @Test
  @DisplayName("Test exportRuleChains(int); then status four hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.rule.RuleChainData RuleChainController.exportRuleChains(int)"
  })
  void testExportRuleChains_thenStatusFourHundred() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/ruleChains/export")
            .param("limit", "You aren't authorized to perform this operation!");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link RuleChainController#exportRuleChains(int)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#exportRuleChains(int)}
   */
  @Test
  @DisplayName("Test exportRuleChains(int); then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.rule.RuleChainData RuleChainController.exportRuleChains(int)"
  })
  void testExportRuleChains_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/ruleChains/export")
            .param("limit", "You aren't authorized to perform this operation!");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RuleChainController#exportRuleChains(int)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#exportRuleChains(int)}
   */
  @Test
  @DisplayName("Test exportRuleChains(int); when valueOf one; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.rule.RuleChainData RuleChainController.exportRuleChains(int)"
  })
  void testExportRuleChains_whenValueOfOne_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/ruleChains/export").param("limit", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RuleChainController#assignRuleChainToEdge(String, String)}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#post(String, Object[])} {@code
   *       /api/edge/{edgeId}/ruleChain/{ruleChainId}} {@code 42} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#assignRuleChainToEdge(String, String)}
   */
  @Test
  @DisplayName(
      "Test assignRuleChainToEdge(String, String); when post(String, Object[]) '/api/edge/{edgeId}/ruleChain/{ruleChainId}' '42' and '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.rule.RuleChain RuleChainController.assignRuleChainToEdge(String, String)"
  })
  void testAssignRuleChainToEdge_whenPostApiEdgeEdgeIdRuleChainRuleChainId42And42()
      throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/edge/{edgeId}/ruleChain/{ruleChainId}", "42", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RuleChainController#getEdgeRuleChains(String, int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#getEdgeRuleChains(String, int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getEdgeRuleChains(String, int, int, String, String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData RuleChainController.getEdgeRuleChains(String, int, int, String, String, String)"
  })
  void testGetEdgeRuleChains_when42() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/ruleChains", "42")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RuleChainController#getAutoAssignToEdgeRuleChains()}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code
   *       /api/ruleChain/autoAssignToEdgeRuleChains}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#getAutoAssignToEdgeRuleChains()}
   */
  @Test
  @DisplayName(
      "Test getAutoAssignToEdgeRuleChains(); when get(String, Object[]) '/api/ruleChain/autoAssignToEdgeRuleChains'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List RuleChainController.getAutoAssignToEdgeRuleChains()"})
  void testGetAutoAssignToEdgeRuleChains_whenGetApiRuleChainAutoAssignToEdgeRuleChains()
      throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/ruleChain/autoAssignToEdgeRuleChains");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }
}
