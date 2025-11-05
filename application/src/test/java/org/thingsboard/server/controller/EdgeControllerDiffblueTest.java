package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeSearchQuery;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportRequest;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportRequest.Mapping;
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
  @InjectMocks private EdgeController edgeController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link EdgeController#isEdgesSupportEnabled()}.
   *
   * <ul>
   *   <li>Then status four hundred six.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#isEdgesSupportEnabled()}
   */
  @Test
  @DisplayName("Test isEdgesSupportEnabled(); then status four hundred six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeController.isEdgesSupportEnabled()"})
  void testIsEdgesSupportEnabled_thenStatusFourHundredSix() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/edges/enabled");
    requestBuilder.accept("Media Types");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(edgeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(406));
  }

  /**
   * Test {@link EdgeController#isEdgesSupportEnabled()}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code /api/edges/enabled}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#isEdgesSupportEnabled()}
   */
  @Test
  @DisplayName(
      "Test isEdgesSupportEnabled(); when get(String, Object[]) '/api/edges/enabled'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeController.isEdgesSupportEnabled()"})
  void testIsEdgesSupportEnabled_whenGetApiEdgesEnabled_thenStatusIsOk() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/edges/enabled");

    // Act and Assert
    ResultMatcher stringResult = content().string(Boolean.FALSE.toString());
    MockMvcBuilders.standaloneSetup(edgeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(stringResult);
  }

  /**
   * Test {@link EdgeController#getEdgeById(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getEdgeById(String)}
   */
  @Test
  @DisplayName("Test getEdgeById(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.getEdgeById(String)"})
  void testGetEdgeById_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.getEdgeById("42"));
  }

  /**
   * Test {@link EdgeController#getEdgeById(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getEdgeById(String)}
   */
  @Test
  @DisplayName("Test getEdgeById(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.getEdgeById(String)"})
  void testGetEdgeById_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.getEdgeById(""));
  }

  /**
   * Test {@link EdgeController#getEdgeInfoById(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getEdgeInfoById(String)}
   */
  @Test
  @DisplayName("Test getEdgeInfoById(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeController.getEdgeInfoById(String)"})
  void testGetEdgeInfoById_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.getEdgeInfoById("42"));
  }

  /**
   * Test {@link EdgeController#getEdgeInfoById(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getEdgeInfoById(String)}
   */
  @Test
  @DisplayName("Test getEdgeInfoById(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeController.getEdgeInfoById(String)"})
  void testGetEdgeInfoById_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.getEdgeInfoById(""));
  }

  /**
   * Test {@link EdgeController#saveEdge(Edge)}.
   *
   * <p>Method under test: {@link EdgeController#saveEdge(Edge)}
   */
  @Test
  @DisplayName("Test saveEdge(Edge)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.saveEdge(Edge)"})
  void testSaveEdge() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.saveEdge(new Edge()));
  }

  /**
   * Test {@link EdgeController#deleteEdge(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#deleteEdge(String)}
   */
  @Test
  @DisplayName("Test deleteEdge(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeController.deleteEdge(String)"})
  void testDeleteEdge_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.deleteEdge("42"));
  }

  /**
   * Test {@link EdgeController#deleteEdge(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#deleteEdge(String)}
   */
  @Test
  @DisplayName("Test deleteEdge(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeController.deleteEdge(String)"})
  void testDeleteEdge_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.deleteEdge(""));
  }

  /**
   * Test {@link EdgeController#getEdges(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getEdges(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getEdges(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EdgeController.getEdges(int, int, String, String, String)"
  })
  void testGetEdges_whenEmptyString_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> edgeController.getEdges(3, 1, "Text Search", "", "asc"));
  }

  /**
   * Test {@link EdgeController#getEdges(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getEdges(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getEdges(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EdgeController.getEdges(int, int, String, String, String)"
  })
  void testGetEdges_whenEmptyString_thenThrowThingsboardException2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> edgeController.getEdges(3, 1, "Text Search", "U", ""));
  }

  /**
   * Test {@link EdgeController#getEdges(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Sort Property}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getEdges(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getEdges(int, int, String, String, String); when 'Sort Property'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EdgeController.getEdges(int, int, String, String, String)"
  })
  void testGetEdges_whenSortProperty_thenThrowIllegalArgumentException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> edgeController.getEdges(3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link EdgeController#getEdges(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getEdges(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getEdges(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EdgeController.getEdges(int, int, String, String, String)"
  })
  void testGetEdges_whenU_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> edgeController.getEdges(3, 1, "Text Search", "U", "asc"));
  }

  /**
   * Test {@link EdgeController#getEdges(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getEdges(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getEdges(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EdgeController.getEdges(int, int, String, String, String)"
  })
  void testGetEdges_whenU_thenThrowThingsboardException2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> edgeController.getEdges(3, 1, "Text Search", "U", "U"));
  }

  /**
   * Test {@link EdgeController#assignEdgeToCustomer(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#assignEdgeToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignEdgeToCustomer(String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.assignEdgeToCustomer(String, String)"})
  void testAssignEdgeToCustomer_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.assignEdgeToCustomer("42", "42"));
  }

  /**
   * Test {@link EdgeController#assignEdgeToCustomer(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#assignEdgeToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignEdgeToCustomer(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.assignEdgeToCustomer(String, String)"})
  void testAssignEdgeToCustomer_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.assignEdgeToCustomer("", "42"));
  }

  /**
   * Test {@link EdgeController#assignEdgeToCustomer(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#assignEdgeToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignEdgeToCustomer(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.assignEdgeToCustomer(String, String)"})
  void testAssignEdgeToCustomer_whenEmptyString2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.assignEdgeToCustomer("42", ""));
  }

  /**
   * Test {@link EdgeController#unassignEdgeFromCustomer(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#unassignEdgeFromCustomer(String)}
   */
  @Test
  @DisplayName("Test unassignEdgeFromCustomer(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.unassignEdgeFromCustomer(String)"})
  void testUnassignEdgeFromCustomer_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.unassignEdgeFromCustomer("42"));
  }

  /**
   * Test {@link EdgeController#unassignEdgeFromCustomer(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#unassignEdgeFromCustomer(String)}
   */
  @Test
  @DisplayName("Test unassignEdgeFromCustomer(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.unassignEdgeFromCustomer(String)"})
  void testUnassignEdgeFromCustomer_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.unassignEdgeFromCustomer(""));
  }

  /**
   * Test {@link EdgeController#assignEdgeToPublicCustomer(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#assignEdgeToPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test assignEdgeToPublicCustomer(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.assignEdgeToPublicCustomer(String)"})
  void testAssignEdgeToPublicCustomer_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.assignEdgeToPublicCustomer("42"));
  }

  /**
   * Test {@link EdgeController#assignEdgeToPublicCustomer(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#assignEdgeToPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test assignEdgeToPublicCustomer(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.assignEdgeToPublicCustomer(String)"})
  void testAssignEdgeToPublicCustomer_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.assignEdgeToPublicCustomer(""));
  }

  /**
   * Test {@link EdgeController#getTenantEdges(int, int, String, String, String, String)}.
   *
   * <p>Method under test: {@link EdgeController#getTenantEdges(int, int, String, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test getTenantEdges(int, int, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EdgeController.getTenantEdges(int, int, String, String, String, String)"
  })
  void testGetTenantEdges() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> edgeController.getTenantEdges(3, 1, "Type", "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link EdgeController#getTenantEdgeInfos(int, int, String, String, String, String)}.
   *
   * <p>Method under test: {@link EdgeController#getTenantEdgeInfos(int, int, String, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getTenantEdgeInfos(int, int, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EdgeController.getTenantEdgeInfos(int, int, String, String, String, String)"
  })
  void testGetTenantEdgeInfos() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            edgeController.getTenantEdgeInfos(3, 1, "Type", "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link EdgeController#getTenantEdge(String)}.
   *
   * <p>Method under test: {@link EdgeController#getTenantEdge(String)}
   */
  @Test
  @DisplayName("Test getTenantEdge(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.getTenantEdge(String)"})
  void testGetTenantEdge() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.getTenantEdge("Edge Name"));
  }

  /**
   * Test {@link EdgeController#setEdgeRootRuleChain(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#setEdgeRootRuleChain(String, String)}
   */
  @Test
  @DisplayName("Test setEdgeRootRuleChain(String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.setEdgeRootRuleChain(String, String)"})
  void testSetEdgeRootRuleChain_when42() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.setEdgeRootRuleChain("42", "42"));
  }

  /**
   * Test {@link EdgeController#setEdgeRootRuleChain(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#setEdgeRootRuleChain(String, String)}
   */
  @Test
  @DisplayName("Test setEdgeRootRuleChain(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.setEdgeRootRuleChain(String, String)"})
  void testSetEdgeRootRuleChain_whenEmptyString() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.setEdgeRootRuleChain("", "42"));
  }

  /**
   * Test {@link EdgeController#setEdgeRootRuleChain(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#setEdgeRootRuleChain(String, String)}
   */
  @Test
  @DisplayName("Test setEdgeRootRuleChain(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.setEdgeRootRuleChain(String, String)"})
  void testSetEdgeRootRuleChain_whenEmptyString2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.setEdgeRootRuleChain("42", ""));
  }

  /**
   * Test {@link EdgeController#setEdgeRootRuleChain(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#setEdgeRootRuleChain(String, String)}
   */
  @Test
  @DisplayName("Test setEdgeRootRuleChain(String, String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeController.setEdgeRootRuleChain(String, String)"})
  void testSetEdgeRootRuleChain_whenNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.setEdgeRootRuleChain(null, "42"));
  }

  /**
   * Test {@link EdgeController#getCustomerEdges(String, int, int, String, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getCustomerEdges(String, int, int, String, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getCustomerEdges(String, int, int, String, String, String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EdgeController.getCustomerEdges(String, int, int, String, String, String, String)"
  })
  void testGetCustomerEdges_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            edgeController.getCustomerEdges(
                "42", 3, 1, "Type", "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link EdgeController#getCustomerEdges(String, int, int, String, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getCustomerEdges(String, int, int, String, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getCustomerEdges(String, int, int, String, String, String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EdgeController.getCustomerEdges(String, int, int, String, String, String, String)"
  })
  void testGetCustomerEdges_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            edgeController.getCustomerEdges(
                "", 3, 1, "Type", "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link EdgeController#getCustomerEdgeInfos(String, int, int, String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getCustomerEdgeInfos(String, int, int, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getCustomerEdgeInfos(String, int, int, String, String, String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EdgeController.getCustomerEdgeInfos(String, int, int, String, String, String, String)"
  })
  void testGetCustomerEdgeInfos_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            edgeController.getCustomerEdgeInfos(
                "42", 3, 1, "Type", "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link EdgeController#getCustomerEdgeInfos(String, int, int, String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getCustomerEdgeInfos(String, int, int, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getCustomerEdgeInfos(String, int, int, String, String, String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EdgeController.getCustomerEdgeInfos(String, int, int, String, String, String, String)"
  })
  void testGetCustomerEdgeInfos_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            edgeController.getCustomerEdgeInfos(
                "", 3, 1, "Type", "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link EdgeController#getEdgesByIds(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getEdgesByIds(String[])}
   */
  @Test
  @DisplayName("Test getEdgesByIds(String[]); when array of String with empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.getEdgesByIds(String[])"})
  void testGetEdgesByIds_whenArrayOfStringWithEmptyString()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.getEdgesByIds(new String[] {""}));
  }

  /**
   * Test {@link EdgeController#getEdgesByIds(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Str Edge Ids}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getEdgesByIds(String[])}
   */
  @Test
  @DisplayName("Test getEdgesByIds(String[]); when array of String with 'Str Edge Ids'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.getEdgesByIds(String[])"})
  void testGetEdgesByIds_whenArrayOfStringWithStrEdgeIds()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> edgeController.getEdgesByIds(new String[] {"Str Edge Ids"}));
  }

  /**
   * Test {@link EdgeController#getEdgesByIds(String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#getEdgesByIds(String[])}
   */
  @Test
  @DisplayName("Test getEdgesByIds(String[]); when empty array of String")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.getEdgesByIds(String[])"})
  void testGetEdgesByIds_whenEmptyArrayOfString()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.getEdgesByIds(new String[] {}));
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   *
   * <p>Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EdgeSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<String> edgeTypes = new ArrayList<>();
    edgeTypes.add("Requested item wasn't found!");

    EdgeSearchQuery query = new EdgeSearchQuery();
    query.setEdgeTypes(edgeTypes);
    query.setParameters(
        new RelationsSearchParameters(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            EntityType.TENANT,
            EntitySearchDirection.FROM,
            RelationTypeGroup.COMMON,
            3,
            true));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.findByQuery(query));
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   *
   * <p>Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EdgeSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery2() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<String> edgeTypes = new ArrayList<>();
    edgeTypes.add("Requested item wasn't found!");

    EdgeSearchQuery query = new EdgeSearchQuery();
    query.setEdgeTypes(edgeTypes);
    query.setParameters(
        new RelationsSearchParameters(
            UUID.randomUUID(),
            EntityType.TENANT,
            EntitySearchDirection.FROM,
            RelationTypeGroup.COMMON,
            3,
            true));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.findByQuery(query));
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   *
   * <p>Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EdgeSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery3() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<String> edgeTypes = new ArrayList<>();
    edgeTypes.add("Requested item wasn't found!");

    EdgeSearchQuery query = new EdgeSearchQuery();
    query.setEdgeTypes(edgeTypes);
    query.setParameters(
        new RelationsSearchParameters(
            null,
            EntityType.TENANT,
            EntitySearchDirection.FROM,
            RelationTypeGroup.COMMON,
            3,
            true));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.findByQuery(query));
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   *
   * <p>Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EdgeSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery4() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenThrow(new DataValidationException("An error occurred"));

    ArrayList<String> edgeTypes = new ArrayList<>();
    edgeTypes.add("Requested item wasn't found!");

    EdgeSearchQuery query = new EdgeSearchQuery();
    query.setEdgeTypes(edgeTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> edgeController.findByQuery(query));
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   *
   * <p>Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EdgeSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery5() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new DataValidationException("An error occurred"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    ArrayList<String> edgeTypes = new ArrayList<>();
    edgeTypes.add("Requested item wasn't found!");

    EdgeSearchQuery query = new EdgeSearchQuery();
    query.setEdgeTypes(edgeTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.findByQuery(query));
    verify(alarmId).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   *
   * <p>Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EdgeSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery6() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new DataValidationException("An error occurred"));
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    ArrayList<String> edgeTypes = new ArrayList<>();
    edgeTypes.add("Requested item wasn't found!");

    EdgeSearchQuery query = new EdgeSearchQuery();
    query.setEdgeTypes(edgeTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.findByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getEntityType()} return {@code RULE_NODE}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EdgeSearchQuery); given AlarmId getEntityType() return 'RULE_NODE'; then calls getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery_givenAlarmIdGetEntityTypeReturnRuleNode_thenCallsGetEntityType()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    ArrayList<String> edgeTypes = new ArrayList<>();
    edgeTypes.add("Requested item wasn't found!");

    EdgeSearchQuery query = new EdgeSearchQuery();
    query.setEdgeTypes(edgeTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.findByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getEntityType()} return {@code TENANT_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EdgeSearchQuery); given AlarmId getEntityType() return 'TENANT_PROFILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery_givenAlarmIdGetEntityTypeReturnTenantProfile()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT_PROFILE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    ArrayList<String> edgeTypes = new ArrayList<>();
    edgeTypes.add("Requested item wasn't found!");

    EdgeSearchQuery query = new EdgeSearchQuery();
    query.setEdgeTypes(edgeTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.findByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EdgeSearchQuery); given AlarmId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery_givenAlarmIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeSearchQuery query = new EdgeSearchQuery();
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    query.setParameters(
        new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.findByQuery(query));
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link RelationsSearchParameters} {@link RelationsSearchParameters#getEntityId()}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EdgeSearchQuery); given RelationsSearchParameters getEntityId() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery_givenRelationsSearchParametersGetEntityIdReturnNull()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(null);

    ArrayList<String> edgeTypes = new ArrayList<>();
    edgeTypes.add("Requested item wasn't found!");

    EdgeSearchQuery query = new EdgeSearchQuery();
    query.setEdgeTypes(edgeTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.findByQuery(query));
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeSearchQuery#getParameters()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EdgeSearchQuery); then calls getParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery_thenCallsGetParameters()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    EdgeSearchQuery query = mock(EdgeSearchQuery.class);
    when(query.getParameters()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> edgeController.findByQuery(query));
    verify(query).getParameters();
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   *
   * <ul>
   *   <li>When {@link EdgeSearchQuery} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EdgeSearchQuery); when EdgeSearchQuery (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery_whenEdgeSearchQuery()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> edgeController.findByQuery(new EdgeSearchQuery()));
  }

  /**
   * Test {@link EdgeController#findByQuery(EdgeSearchQuery)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#findByQuery(EdgeSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EdgeSearchQuery); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.findByQuery(EdgeSearchQuery)"})
  void testFindByQuery_whenNull()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.findByQuery(null));
  }

  /**
   * Test {@link EdgeController#getEdgeTypes()}.
   *
   * <p>Method under test: {@link EdgeController#getEdgeTypes()}
   */
  @Test
  @DisplayName("Test getEdgeTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EdgeController.getEdgeTypes()"})
  void testGetEdgeTypes() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.getEdgeTypes());
  }

  /**
   * Test {@link EdgeController#syncEdge(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#syncEdge(String)}
   */
  @Test
  @DisplayName("Test syncEdge(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult EdgeController.syncEdge(String)"
  })
  void testSyncEdge_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.syncEdge("42"));
  }

  /**
   * Test {@link EdgeController#syncEdge(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeController#syncEdge(String)}
   */
  @Test
  @DisplayName("Test syncEdge(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult EdgeController.syncEdge(String)"
  })
  void testSyncEdge_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.syncEdge(""));
  }

  /**
   * Test {@link EdgeController#findMissingToRelatedRuleChains(String)}.
   *
   * <p>Method under test: {@link EdgeController#findMissingToRelatedRuleChains(String)}
   */
  @Test
  @DisplayName("Test findMissingToRelatedRuleChains(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EdgeController.findMissingToRelatedRuleChains(String)"})
  void testFindMissingToRelatedRuleChains() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> edgeController.findMissingToRelatedRuleChains("42"));
  }

  /**
   * Test {@link EdgeController#processEdgesBulkImport(BulkImportRequest)}.
   *
   * <p>Method under test: {@link EdgeController#processEdgesBulkImport(BulkImportRequest)}
   */
  @Test
  @DisplayName("Test processEdgesBulkImport(BulkImportRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportResult EdgeController.processEdgesBulkImport(BulkImportRequest)"
  })
  void testProcessEdgesBulkImport() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    Mapping mapping = new Mapping();
    mapping.setColumns(new ArrayList<>());
    mapping.setDelimiter('A');
    mapping.setHeader(true);
    mapping.setUpdate(true);

    BulkImportRequest request = new BulkImportRequest();
    request.setFile("File");
    request.setMapping(mapping);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.processEdgesBulkImport(request));
  }

  /**
   * Test {@link EdgeController#getEdgeInstallInstructions(String, String, HttpServletRequest)}.
   *
   * <p>Method under test: {@link EdgeController#getEdgeInstallInstructions(String, String,
   * HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getEdgeInstallInstructions(String, String, HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeInstructions EdgeController.getEdgeInstallInstructions(String, String, HttpServletRequest)"
  })
  void testGetEdgeInstallInstructions() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            edgeController.getEdgeInstallInstructions(
                "42", "Installation Method", new MockHttpServletRequest()));
  }

  /**
   * Test {@link EdgeController#getEdgeUpgradeInstructions(String, String)}.
   *
   * <p>Method under test: {@link EdgeController#getEdgeUpgradeInstructions(String, String)}
   */
  @Test
  @DisplayName("Test getEdgeUpgradeInstructions(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInstructions EdgeController.getEdgeUpgradeInstructions(String, String)"})
  void testGetEdgeUpgradeInstructions() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> edgeController.getEdgeUpgradeInstructions("1.0.2", "Method"));
  }

  /**
   * Test {@link EdgeController#isEdgeUpgradeAvailable(String)}.
   *
   * <p>Method under test: {@link EdgeController#isEdgeUpgradeAvailable(String)}
   */
  @Test
  @DisplayName("Test isEdgeUpgradeAvailable(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeController.isEdgeUpgradeAvailable(String)"})
  void testIsEdgeUpgradeAvailable() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    DefaultTbEdgeService tbEdgeService2 = new DefaultTbEdgeService(new BaseRuleChainService());
    Optional<EdgeRpcService> edgeRpcServiceOpt = Optional.of(new EdgeGrpcService());
    Optional<EdgeInstallInstructionsService> edgeInstallServiceOpt =
        Optional.of(new DefaultEdgeInstallInstructionsService(new InstallScripts()));
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    Optional<EdgeUpgradeInstructionsService> edgeUpgradeServiceOpt =
        Optional.of(defaultEdgeUpgradeInstructionsService);

    EdgeController edgeController =
        new EdgeController(
            edgeBulkImportService,
            tbEdgeService2,
            edgeRpcServiceOpt,
            edgeInstallServiceOpt,
            edgeUpgradeServiceOpt);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> edgeController.isEdgeUpgradeAvailable("42"));
  }
}
