package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.DoubleNode;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.DefaultRuleChainCreateRequest;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainConnectionInfo;
import org.thingsboard.server.common.data.rule.RuleChainData;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.data.script.ScriptLanguage;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainController.getRuleChainById(String)"})
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
        .andExpect(MockMvcResultMatchers.status().isOk());
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#getRuleChainOutputLabelsUsage(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#getRuleChainOutputLabelsUsage(String)}
   */
  @Test
  @DisplayName("Test getRuleChainOutputLabelsUsage(String); when '42'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List RuleChainController.getRuleChainOutputLabelsUsage(String)"})
  void testGetRuleChainOutputLabelsUsage_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/ruleChain/{ruleChainId}/output/labels/usage", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChainMetaData RuleChainController.getRuleChainMetaData(String)"})
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
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#saveRuleChain(DefaultRuleChainCreateRequest)} with {@code
   * request}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#saveRuleChain(DefaultRuleChainCreateRequest)}
   */
  @Test
  @DisplayName(
      "Test saveRuleChain(DefaultRuleChainCreateRequest) with 'request'; then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainController.saveRuleChain(DefaultRuleChainCreateRequest)"})
  void testSaveRuleChainWithRequest_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("Requested item wasn't found!"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/ruleChain/device/default");
    postResult.characterEncoding("https://example.org/example");

    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest =
        new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName("Name");
    String content = new ObjectMapper().writeValueAsString(defaultRuleChainCreateRequest);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link RuleChainController#saveRuleChain(DefaultRuleChainCreateRequest)} with {@code
   * request}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#saveRuleChain(DefaultRuleChainCreateRequest)}
   */
  @Test
  @DisplayName(
      "Test saveRuleChain(DefaultRuleChainCreateRequest) with 'request'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainController.saveRuleChain(DefaultRuleChainCreateRequest)"})
  void testSaveRuleChainWithRequest_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest =
        new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName("Name");
    String content = new ObjectMapper().writeValueAsString(defaultRuleChainCreateRequest);
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/ruleChain/device/default")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#saveRuleChain(DefaultRuleChainCreateRequest)} with {@code
   * request}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#saveRuleChain(DefaultRuleChainCreateRequest)}
   */
  @Test
  @DisplayName(
      "Test saveRuleChain(DefaultRuleChainCreateRequest) with 'request'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainController.saveRuleChain(DefaultRuleChainCreateRequest)"})
  void testSaveRuleChainWithRequest_thenStatusIsOk2() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/ruleChain/device/default");
    postResult.characterEncoding("https://example.org/example");

    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest =
        new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName("Name");
    String content = new ObjectMapper().writeValueAsString(defaultRuleChainCreateRequest);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#saveRuleChain(RuleChain)} with {@code ruleChain}.
   *
   * <p>Method under test: {@link RuleChainController#saveRuleChain(RuleChain)}
   */
  @Test
  @DisplayName("Test saveRuleChain(RuleChain) with 'ruleChain'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainController.saveRuleChain(RuleChain)"})
  void testSaveRuleChainWithRuleChain() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes("AXAXAXAX".getBytes("UTF-8"));
    ruleChain.setCreatedTime(1L);
    ruleChain.setDebugMode(true);
    ruleChain.setExternalId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChain.setFirstRuleNodeId(
        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChain.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChain.setName("Name");
    ruleChain.setRoot(true);
    ruleChain.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChain.setType(RuleChainType.CORE);
    ruleChain.setVersion(1L);
    String content = new ObjectMapper().writeValueAsString(ruleChain);
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/ruleChain")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#saveRuleChain(RuleChain)} with {@code ruleChain}.
   *
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#saveRuleChain(RuleChain)}
   */
  @Test
  @DisplayName(
      "Test saveRuleChain(RuleChain) with 'ruleChain'; given TenantId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainController.saveRuleChain(RuleChain)"})
  void testSaveRuleChainWithRuleChain_givenTenantIdWithIdIsRandomUUID() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes("AXAXAXAX".getBytes("UTF-8"));
    ruleChain.setCreatedTime(1L);
    ruleChain.setDebugMode(true);
    ruleChain.setExternalId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChain.setFirstRuleNodeId(
        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChain.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChain.setName("Name");
    ruleChain.setRoot(true);
    ruleChain.setTenantId(new TenantId(UUID.randomUUID()));
    ruleChain.setType(RuleChainType.CORE);
    ruleChain.setVersion(1L);
    String content = new ObjectMapper().writeValueAsString(ruleChain);
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/ruleChain")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#setRootRuleChain(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#setRootRuleChain(String)}
   */
  @Test
  @DisplayName("Test setRootRuleChain(String); when '42'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainController.setRootRuleChain(String)"})
  void testSetRootRuleChain_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/ruleChain/{ruleChainId}/root", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#saveRuleChainMetaData(RuleChainMetaData, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RuleNode#RuleNode()}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#saveRuleChainMetaData(RuleChainMetaData,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveRuleChainMetaData(RuleChainMetaData, boolean); given ArrayList() add RuleNode(); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RuleChainMetaData RuleChainController.saveRuleChainMetaData(RuleChainMetaData, boolean)"
  })
  void testSaveRuleChainMetaData_givenArrayListAddRuleNode_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(new RuleNode());

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setConnections(new ArrayList<>());
    ruleChainMetaData.setFirstNodeIndex(1);
    ruleChainMetaData.setNodes(nodes);
    ruleChainMetaData.setRuleChainConnections(new ArrayList<>());
    ruleChainMetaData.setRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainMetaData.setVersion(1L);
    String content = new ObjectMapper().writeValueAsString(ruleChainMetaData);
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/ruleChain/metadata")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#saveRuleChainMetaData(RuleChainMetaData, boolean)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#saveRuleChainMetaData(RuleChainMetaData,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveRuleChainMetaData(RuleChainMetaData, boolean); given 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RuleChainMetaData RuleChainController.saveRuleChainMetaData(RuleChainMetaData, boolean)"
  })
  void testSaveRuleChainMetaData_givenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/ruleChain/metadata");
    postResult.characterEncoding("https://example.org/example");

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setConnections(new ArrayList<>());
    ruleChainMetaData.setFirstNodeIndex(1);
    ruleChainMetaData.setNodes(new ArrayList<>());
    ruleChainMetaData.setRuleChainConnections(new ArrayList<>());
    ruleChainMetaData.setRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainMetaData.setVersion(1L);
    String content = new ObjectMapper().writeValueAsString(ruleChainMetaData);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#saveRuleChainMetaData(RuleChainMetaData, boolean)}.
   *
   * <ul>
   *   <li>Given {@link RuleChainConnectionInfo} (default constructor) AdditionalInfo is valueOf
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#saveRuleChainMetaData(RuleChainMetaData,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveRuleChainMetaData(RuleChainMetaData, boolean); given RuleChainConnectionInfo (default constructor) AdditionalInfo is valueOf ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RuleChainMetaData RuleChainController.saveRuleChainMetaData(RuleChainMetaData, boolean)"
  })
  void testSaveRuleChainMetaData_givenRuleChainConnectionInfoAdditionalInfoIsValueOfTen()
      throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("entityType");

    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();
    ruleChainConnections.add(ruleChainConnectionInfo);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setConnections(new ArrayList<>());
    ruleChainMetaData.setFirstNodeIndex(1);
    ruleChainMetaData.setNodes(new ArrayList<>());
    ruleChainMetaData.setRuleChainConnections(ruleChainConnections);
    ruleChainMetaData.setRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainMetaData.setVersion(1L);
    String content = new ObjectMapper().writeValueAsString(ruleChainMetaData);
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/ruleChain/metadata")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#saveRuleChainMetaData(RuleChainMetaData, boolean)}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#saveRuleChainMetaData(RuleChainMetaData,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveRuleChainMetaData(RuleChainMetaData, boolean); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RuleChainMetaData RuleChainController.saveRuleChainMetaData(RuleChainMetaData, boolean)"
  })
  void testSaveRuleChainMetaData_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("entityType"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/ruleChain/metadata");
    postResult.characterEncoding("https://example.org/example");

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setConnections(new ArrayList<>());
    ruleChainMetaData.setFirstNodeIndex(1);
    ruleChainMetaData.setNodes(new ArrayList<>());
    ruleChainMetaData.setRuleChainConnections(new ArrayList<>());
    ruleChainMetaData.setRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainMetaData.setVersion(1L);
    String content = new ObjectMapper().writeValueAsString(ruleChainMetaData);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link RuleChainController#saveRuleChainMetaData(RuleChainMetaData, boolean)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#saveRuleChainMetaData(RuleChainMetaData,
   * boolean)}
   */
  @Test
  @DisplayName("Test saveRuleChainMetaData(RuleChainMetaData, boolean); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RuleChainMetaData RuleChainController.saveRuleChainMetaData(RuleChainMetaData, boolean)"
  })
  void testSaveRuleChainMetaData_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setConnections(new ArrayList<>());
    ruleChainMetaData.setFirstNodeIndex(1);
    ruleChainMetaData.setNodes(new ArrayList<>());
    ruleChainMetaData.setRuleChainConnections(new ArrayList<>());
    ruleChainMetaData.setRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainMetaData.setVersion(1L);
    String content = new ObjectMapper().writeValueAsString(ruleChainMetaData);
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/ruleChain/metadata")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#getRuleChains(int, int, String, String, String, String)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#getRuleChains(int, int, String, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getRuleChains(int, int, String, String, String, String); then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData RuleChainController.getRuleChains(int, int, String, String, String, String)"
  })
  void testGetRuleChains_thenStatusFourHundred() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("You aren't authorized to perform this operation!"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/ruleChains").param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link RuleChainController#getRuleChains(int, int, String, String, String, String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#getRuleChains(int, int, String, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getRuleChains(int, int, String, String, String, String); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData RuleChainController.getRuleChains(int, int, String, String, String, String)"
  })
  void testGetRuleChains_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/ruleChains").param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#getRuleChains(int, int, String, String, String, String)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequestBuilder#param(String, String[])} {@code page} is
   *       valueOf one.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#getRuleChains(int, int, String, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getRuleChains(int, int, String, String, String, String); when param(String, String[]) 'page' is valueOf one; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData RuleChainController.getRuleChains(int, int, String, String, String, String)"
  })
  void testGetRuleChains_whenParamPageIsValueOfOne_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/ruleChains");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode RuleChainController.getLatestRuleNodeDebugInput(String)"})
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
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#isTbelEnabled()}.
   *
   * <p>Method under test: {@link RuleChainController#isTbelEnabled()}
   */
  @Test
  @DisplayName("Test isTbelEnabled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean RuleChainController.isTbelEnabled()"})
  void testIsTbelEnabled() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#isTbelEnabled()}.
   *
   * <p>Method under test: {@link RuleChainController#isTbelEnabled()}
   */
  @Test
  @DisplayName("Test isTbelEnabled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean RuleChainController.isTbelEnabled()"})
  void testIsTbelEnabled2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link RuleChainController#isTbelEnabled()}.
   *
   * <ul>
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#isTbelEnabled()}
   */
  @Test
  @DisplayName("Test isTbelEnabled(); then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean RuleChainController.isTbelEnabled()"})
  void testIsTbelEnabled_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/ruleChain/tbelEnabled");

    // Act and Assert
    ResultActions resultActions =
        MockMvcBuilders.standaloneSetup(ruleChainController)
            .setControllerAdvice(thingsboardErrorResponseHandler)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    ContentResultMatchers contentResult = MockMvcResultMatchers.content();
    resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
  }

  /**
   * Test {@link RuleChainController#testScript(ScriptLanguage, JsonNode)}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#testScript(ScriptLanguage, JsonNode)}
   */
  @Test
  @DisplayName("Test testScript(ScriptLanguage, JsonNode); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode RuleChainController.testScript(ScriptLanguage, JsonNode)"})
  void testTestScript_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("script"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/ruleChain/testScript");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(DoubleNode.valueOf(10.0d)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link RuleChainController#testScript(ScriptLanguage, JsonNode)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#testScript(ScriptLanguage, JsonNode)}
   */
  @Test
  @DisplayName("Test testScript(ScriptLanguage, JsonNode); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode RuleChainController.testScript(ScriptLanguage, JsonNode)"})
  void testTestScript_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/ruleChain/testScript")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(DoubleNode.valueOf(10.0d)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#testScript(ScriptLanguage, JsonNode)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#testScript(ScriptLanguage, JsonNode)}
   */
  @Test
  @DisplayName("Test testScript(ScriptLanguage, JsonNode); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode RuleChainController.testScript(ScriptLanguage, JsonNode)"})
  void testTestScript_thenStatusIsOk2() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/ruleChain/testScript");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(DoubleNode.valueOf(10.0d)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChainData RuleChainController.exportRuleChains(int)"})
  void testExportRuleChains_thenStatusFourHundred() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("You aren't authorized to perform this operation!"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/ruleChains/export")
            .param("limit", "https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChainData RuleChainController.exportRuleChains(int)"})
  void testExportRuleChains_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/ruleChains/export")
            .param("limit", "https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChainData RuleChainController.exportRuleChains(int)"})
  void testExportRuleChains_whenValueOfOne_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/ruleChains/export");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("limit", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#importRuleChains(RuleChainData, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RuleChain#RuleChain()}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#importRuleChains(RuleChainData, boolean)}
   */
  @Test
  @DisplayName(
      "Test importRuleChains(RuleChainData, boolean); given ArrayList() add RuleChain(); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List RuleChainController.importRuleChains(RuleChainData, boolean)"})
  void testImportRuleChains_givenArrayListAddRuleChain_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    ArrayList<RuleChain> ruleChains = new ArrayList<>();
    ruleChains.add(new RuleChain());

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(ruleChains);
    String content = new ObjectMapper().writeValueAsString(ruleChainData);
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/ruleChains/import")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#importRuleChains(RuleChainData, boolean)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#importRuleChains(RuleChainData, boolean)}
   */
  @Test
  @DisplayName("Test importRuleChains(RuleChainData, boolean); given 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List RuleChainController.importRuleChains(RuleChainData, boolean)"})
  void testImportRuleChains_givenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/ruleChains/import");
    postResult.characterEncoding("https://example.org/example");

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(new ArrayList<>());
    String content = new ObjectMapper().writeValueAsString(ruleChainData);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#importRuleChains(RuleChainData, boolean)}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#importRuleChains(RuleChainData, boolean)}
   */
  @Test
  @DisplayName("Test importRuleChains(RuleChainData, boolean); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List RuleChainController.importRuleChains(RuleChainData, boolean)"})
  void testImportRuleChains_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException("You aren't authorized to perform this operation!"))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/ruleChains/import");
    postResult.characterEncoding("https://example.org/example");

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(new ArrayList<>());
    String content = new ObjectMapper().writeValueAsString(ruleChainData);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link RuleChainController#importRuleChains(RuleChainData, boolean)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#importRuleChains(RuleChainData, boolean)}
   */
  @Test
  @DisplayName("Test importRuleChains(RuleChainData, boolean); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List RuleChainController.importRuleChains(RuleChainData, boolean)"})
  void testImportRuleChains_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(new ArrayList<>());
    String content = new ObjectMapper().writeValueAsString(ruleChainData);
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/ruleChains/import")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainController.assignRuleChainToEdge(String, String)"})
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
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#unassignRuleChainFromEdge(String, String)}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#delete(String, Object[])} {@code
   *       /api/edge/{edgeId}/ruleChain/{ruleChainId}} {@code 42} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#unassignRuleChainFromEdge(String, String)}
   */
  @Test
  @DisplayName(
      "Test unassignRuleChainFromEdge(String, String); when delete(String, Object[]) '/api/edge/{edgeId}/ruleChain/{ruleChainId}' '42' and '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainController.unassignRuleChainFromEdge(String, String)"})
  void testUnassignRuleChainFromEdge_whenDeleteApiEdgeEdgeIdRuleChainRuleChainId42And42()
      throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/edge/{edgeId}/ruleChain/{ruleChainId}", "42", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#getEdgeRuleChains(String, int, int, String, String, String)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#getEdgeRuleChains(String, int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getEdgeRuleChains(String, int, int, String, String, String); then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData RuleChainController.getEdgeRuleChains(String, int, int, String, String, String)"
  })
  void testGetEdgeRuleChains_thenStatusFourHundred() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException(EdgeController.EDGE_ID))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/ruleChains", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link RuleChainController#getEdgeRuleChains(String, int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#getEdgeRuleChains(String, int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getEdgeRuleChains(String, int, int, String, String, String); when '42'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData RuleChainController.getEdgeRuleChains(String, int, int, String, String, String)"
  })
  void testGetEdgeRuleChains_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/ruleChains", "42");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#getEdgeRuleChains(String, int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#getEdgeRuleChains(String, int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getEdgeRuleChains(String, int, int, String, String, String); when 'https://example.org/example'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData RuleChainController.getEdgeRuleChains(String, int, int, String, String, String)"
  })
  void testGetEdgeRuleChains_whenHttpsExampleOrgExample_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/ruleChains", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#setEdgeTemplateRootRuleChain(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#setEdgeTemplateRootRuleChain(String)}
   */
  @Test
  @DisplayName("Test setEdgeTemplateRootRuleChain(String); when '42'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainController.setEdgeTemplateRootRuleChain(String)"})
  void testSetEdgeTemplateRootRuleChain_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/ruleChain/{ruleChainId}/edgeTemplateRoot", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#setAutoAssignToEdgeRuleChain(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#setAutoAssignToEdgeRuleChain(String)}
   */
  @Test
  @DisplayName("Test setAutoAssignToEdgeRuleChain(String); when '42'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainController.setAutoAssignToEdgeRuleChain(String)"})
  void testSetAutoAssignToEdgeRuleChain_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/ruleChain/{ruleChainId}/autoAssignToEdge", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RuleChainController#unsetAutoAssignToEdgeRuleChain(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainController#unsetAutoAssignToEdgeRuleChain(String)}
   */
  @Test
  @DisplayName("Test unsetAutoAssignToEdgeRuleChain(String); when '42'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainController.unsetAutoAssignToEdgeRuleChain(String)"})
  void testUnsetAutoAssignToEdgeRuleChain_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/ruleChain/{ruleChainId}/autoAssignToEdge", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ruleChainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
