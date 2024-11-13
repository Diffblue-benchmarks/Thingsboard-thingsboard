package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.thingsboard.server.common.data.edge.EdgeSearchQuery;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.service.edge.EdgeBulkImportService;
import org.thingsboard.server.service.edge.instructions.DefaultEdgeInstallInstructionsService;
import org.thingsboard.server.service.edge.instructions.DefaultEdgeUpgradeInstructionsService;
import org.thingsboard.server.service.edge.instructions.EdgeInstallInstructionsService;
import org.thingsboard.server.service.edge.instructions.EdgeUpgradeInstructionsService;
import org.thingsboard.server.service.edge.rpc.EdgeGrpcService;
import org.thingsboard.server.service.edge.rpc.EdgeRpcService;
import org.thingsboard.server.service.entitiy.edge.DefaultTbEdgeService;
import org.thingsboard.server.service.install.InstallScripts;

class EdgeControllerDiffblueTest {
  /**
   * Test {@link EdgeController#isEdgesSupportEnabled()}.
   * <p>
   * Method under test: {@link EdgeController#isEdgesSupportEnabled()}
   */
  @Test
  @DisplayName("Test isEdgesSupportEnabled()")
  void testIsEdgesSupportEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertFalse((new EdgeController(edgeBulkImportService, tbEdgeService2, edgeRpcServiceOpt, edgeInstallServiceOpt,
        edgeUpgradeServiceOpt)).isEdgesSupportEnabled());
  }

  /**
   * Test {@link EdgeController#isEdgesSupportEnabled()}.
   * <p>
   * Method under test: {@link EdgeController#isEdgesSupportEnabled()}
   */
  @Test
  @DisplayName("Test isEdgesSupportEnabled()")
  void testIsEdgesSupportEnabled2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeService = mock(EdgeServiceImpl.class);
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
    assertFalse((new EdgeController(edgeBulkImportService, tbEdgeService2, edgeRpcServiceOpt, edgeInstallServiceOpt,
        edgeUpgradeServiceOpt)).isEdgesSupportEnabled());
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
  void testFindByQuery_thenThrowDataValidationException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeController#syncEdge(String)}
   */
  @Test
  @DisplayName("Test syncEdge(String); then throw ThingsboardException")
  void testSyncEdge_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link EdgeController#getEdgeInstallInstructions(String, String, HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link EdgeController#getEdgeInstallInstructions(String, String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getEdgeInstallInstructions(String, String, HttpServletRequest)")
  void testGetEdgeInstallInstructions() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link EdgeController#getEdgeUpgradeInstructions(String, String)}
   */
  @Test
  @DisplayName("Test getEdgeUpgradeInstructions(String, String)")
  void testGetEdgeUpgradeInstructions() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  void testIsEdgeUpgradeAvailable() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
