package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeSearchQuery;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.edge.EdgeBulkImportService;
import org.thingsboard.server.service.edge.instructions.DefaultEdgeInstallInstructionsService;
import org.thingsboard.server.service.edge.instructions.DefaultEdgeUpgradeInstructionsService;
import org.thingsboard.server.service.edge.instructions.EdgeInstallInstructionsService;
import org.thingsboard.server.service.edge.instructions.EdgeUpgradeInstructionsService;
import org.thingsboard.server.service.edge.rpc.EdgeGrpcService;
import org.thingsboard.server.service.edge.rpc.EdgeRpcService;
import org.thingsboard.server.service.entitiy.edge.DefaultTbEdgeService;
import org.thingsboard.server.service.install.InstallScripts;

@ExtendWith(MockitoExtension.class)
class EdgeControllerDiffblueTest {
  @InjectMocks
  private EdgeController edgeController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link EdgeController#isEdgesSupportEnabled()}.
   * <ul>
   *   <li>Then status four hundred six.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeController#isEdgesSupportEnabled()}
   */
  @Test
  @DisplayName("Test isEdgesSupportEnabled(); then status four hundred six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeController.isEdgesSupportEnabled()"})
  void testIsEdgesSupportEnabled_thenStatusFourHundredSix() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/edges/enabled", "Uri Variables");
    requestBuilder.accept("https://example.org/example");
    requestBuilder.characterEncoding("https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(edgeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(406));
  }

  /**
   * Test {@link EdgeController#isEdgesSupportEnabled()}.
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code /api/edges/enabled}.</li>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeController#isEdgesSupportEnabled()}
   */
  @Test
  @DisplayName("Test isEdgesSupportEnabled(); when get(String, Object[]) '/api/edges/enabled'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeController.isEdgesSupportEnabled()"})
  void testIsEdgesSupportEnabled_whenGetApiEdgesEnabled_thenStatusIsOk() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/edges/enabled");

    // Act and Assert
    ResultActions resultActions = MockMvcBuilders.standaloneSetup(edgeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    ContentResultMatchers contentResult = MockMvcResultMatchers.content();
    resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
  }

  /**
   * Test {@link EdgeController#saveEdge(Edge)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then status four hundred fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeController#saveEdge(Edge)}
   */
  @Test
  @DisplayName("Test saveEdge(Edge); given 'https://example.org/example'; then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge EdgeController.saveEdge(Edge)"})
  void testSaveEdge_givenHttpsExampleOrgExample_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/edge");
    postResult.characterEncoding("https://example.org/example");

    Edge edge = new Edge();
    edge.setCreatedTime(1L);
    edge.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    edge.setId(null);
    edge.setLabel("Label");
    edge.setName("Name");
    edge.setRootRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    edge.setRoutingKey("Routing Key");
    edge.setSecret("Secret");
    edge.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    edge.setType("Type");
    edge.setVersion(1L);
    String content = (new ObjectMapper()).writeValueAsString(edge);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(edgeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link EdgeController#getEdges(int, int, String, String, String)}.
   * <p>
   * Method under test: {@link EdgeController#getEdges(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getEdges(int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData EdgeController.getEdges(int, int, String, String, String)"})
  void testGetEdges() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/edges")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(edgeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link EdgeController#getTenantEdges(int, int, String, String, String, String)}.
   * <p>
   * Method under test: {@link EdgeController#getTenantEdges(int, int, String, String, String, String)}
   */
  @Test
  @DisplayName("Test getTenantEdges(int, int, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData EdgeController.getTenantEdges(int, int, String, String, String, String)"})
  void testGetTenantEdges() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/tenant/edges")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(edgeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link EdgeController#getTenantEdgeInfos(int, int, String, String, String, String)}.
   * <p>
   * Method under test: {@link EdgeController#getTenantEdgeInfos(int, int, String, String, String, String)}
   */
  @Test
  @DisplayName("Test getTenantEdgeInfos(int, int, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData EdgeController.getTenantEdgeInfos(int, int, String, String, String, String)"})
  void testGetTenantEdgeInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/tenant/edgeInfos")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(edgeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EdgeSearchQuery); then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery_thenThrowDataValidationException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());
    EdgeBulkImportService edgeBulkImportService = new EdgeBulkImportService(edgeService, tbEdgeService,
        new BaseRuleChainService());

    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt = Optional
        .of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt = Optional
        .of(new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts()));
    EdgeController edgeController = new EdgeController(edgeBulkImportService, tbEdgeService2, edgeRpcServiceOpt,
        edgeInstallServiceOpt, edgeUpgradeServiceOpt);
    EdgeSearchQuery query = mock(EdgeSearchQuery.class);
    when(query.getParameters()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> edgeController.findByQuery(query));
    verify(query).getParameters();
  }

  /**
   * Test {@link EdgeController#syncEdge(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeController#syncEdge(String)}
   */
  @Test
  @DisplayName("Test syncEdge(String); when '42'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.springframework.web.context.request.async.DeferredResult EdgeController.syncEdge(String)"})
  void testSyncEdge_when42_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());
    EdgeBulkImportService edgeBulkImportService = new EdgeBulkImportService(edgeService, tbEdgeService,
        new BaseRuleChainService());

    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt = Optional
        .of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt = Optional
        .of(new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts()));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> (new EdgeController(edgeBulkImportService, tbEdgeService2,
        edgeRpcServiceOpt, edgeInstallServiceOpt, edgeUpgradeServiceOpt)).syncEdge("42"));
  }

  /**
   * Test {@link EdgeController#getEdgeInstallInstructions(String, String, HttpServletRequest)}.
   * <p>
   * Method under test: {@link EdgeController#getEdgeInstallInstructions(String, String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getEdgeInstallInstructions(String, String, HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeInstructions EdgeController.getEdgeInstallInstructions(String, String, HttpServletRequest)"})
  void testGetEdgeInstallInstructions() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());
    EdgeBulkImportService edgeBulkImportService = new EdgeBulkImportService(edgeService, tbEdgeService,
        new BaseRuleChainService());

    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt = Optional
        .of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt = Optional
        .of(new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts()));
    EdgeController edgeController = new EdgeController(edgeBulkImportService, tbEdgeService2, edgeRpcServiceOpt,
        edgeInstallServiceOpt, edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> edgeController.getEdgeInstallInstructions("42", "Installation Method", new MockHttpServletRequest()));
  }

  /**
   * Test {@link EdgeController#getEdgeUpgradeInstructions(String, String)}.
   * <p>
   * Method under test: {@link EdgeController#getEdgeUpgradeInstructions(String, String)}
   */
  @Test
  @DisplayName("Test getEdgeUpgradeInstructions(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeInstructions EdgeController.getEdgeUpgradeInstructions(String, String)"})
  void testGetEdgeUpgradeInstructions() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());
    EdgeBulkImportService edgeBulkImportService = new EdgeBulkImportService(edgeService, tbEdgeService,
        new BaseRuleChainService());

    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt = Optional
        .of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt = Optional
        .of(new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts()));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new EdgeController(edgeBulkImportService, tbEdgeService2, edgeRpcServiceOpt, edgeInstallServiceOpt,
            edgeUpgradeServiceOpt)).getEdgeUpgradeInstructions("1.0.2", "Method"));
  }

  /**
   * Test {@link EdgeController#isEdgeUpgradeAvailable(String)}.
   * <p>
   * Method under test: {@link EdgeController#isEdgeUpgradeAvailable(String)}
   */
  @Test
  @DisplayName("Test isEdgeUpgradeAvailable(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeController.isEdgeUpgradeAvailable(String)"})
  void testIsEdgeUpgradeAvailable() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());
    EdgeBulkImportService edgeBulkImportService = new EdgeBulkImportService(edgeService, tbEdgeService,
        new BaseRuleChainService());

    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt = Optional
        .of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt = Optional
        .of(new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts()));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> (new EdgeController(edgeBulkImportService, tbEdgeService2,
        edgeRpcServiceOpt, edgeInstallServiceOpt, edgeUpgradeServiceOpt)).isEdgeUpgradeAvailable("42"));
  }
}
