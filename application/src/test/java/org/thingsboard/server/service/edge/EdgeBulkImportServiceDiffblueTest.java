package org.thingsboard.server.service.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportColumnType;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.service.entitiy.edge.DefaultTbEdgeService;
import org.thingsboard.server.service.entitiy.edge.TbEdgeService;
import org.thingsboard.server.service.security.model.SecurityUser;

class EdgeBulkImportServiceDiffblueTest {
  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>Then calls {@link Edge#getAdditionalInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Edge, Map) with 'Edge', 'Map'; given Instance; then calls getAdditionalInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_givenInstance_thenCallsGetAdditionalInfo() {
    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());

    Edge entity = mock(Edge.class);
    when(entity.getAdditionalInfo()).thenReturn(NullNode.getInstance());
    doNothing().when(entity).setAdditionalInfo(Mockito.<JsonNode>any());

    // Act
    edgeBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    verify(entity, atLeast(1)).getAdditionalInfo();
    verify(entity).setAdditionalInfo(isA(JsonNode.class));
  }

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code LABEL}.
   *   <li>Then {@link Edge#Edge()} Label is empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Edge, Map) with 'Edge', 'Map'; given 'LABEL'; then Edge() Label is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_givenLabel_thenEdgeLabelIsEmptyString() {
    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    Edge entity = new Edge();

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.LABEL, "");
    fields.put(BulkImportColumnType.TYPE, "Value");
    fields.put(BulkImportColumnType.NAME, "42");

    // Act
    edgeBulkImportService.setEntityFields(entity, fields);

    // Assert
    assertTrue(entity.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("", entity.getLabel());
    assertEquals("42", entity.getName());
    assertEquals("Value", entity.getType());
  }

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code NAME}.
   *   <li>When {@link HashMap#HashMap()} {@code NAME} is {@code 42}.
   *   <li>Then {@link Edge#Edge()} Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Edge, Map) with 'Edge', 'Map'; given 'NAME'; when HashMap() 'NAME' is '42'; then Edge() Type is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_givenName_whenHashMapNameIs42_thenEdgeTypeIsNull() {
    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    Edge entity = new Edge();

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.NAME, "42");

    // Act
    edgeBulkImportService.setEntityFields(entity, fields);

    // Assert
    assertTrue(entity.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("42", entity.getName());
    assertNull(entity.getType());
  }

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code TYPE}.
   *   <li>Then {@link Edge#Edge()} Type is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Edge, Map) with 'Edge', 'Map'; given 'TYPE'; then Edge() Type is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_givenType_thenEdgeTypeIsValue() {
    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    Edge entity = new Edge();

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.TYPE, "Value");
    fields.put(BulkImportColumnType.NAME, "42");

    // Act
    edgeBulkImportService.setEntityFields(entity, fields);

    // Assert
    assertTrue(entity.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("42", entity.getName());
    assertEquals("Value", entity.getType());
  }

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   *
   * <ul>
   *   <li>Then {@link Edge#Edge(Edge)} with edge is {@link Edge#Edge()} AdditionalInfo {@link
   *       ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Edge, Map) with 'Edge', 'Map'; then Edge(Edge) with edge is Edge() AdditionalInfo ObjectNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_thenEdgeWithEdgeIsEdgeAdditionalInfoObjectNode() {
    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    Edge entity = new Edge(new Edge());

    // Act
    edgeBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    assertTrue(entity.getAdditionalInfo() instanceof ObjectNode);
  }

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge()}.
   *   <li>Then {@link Edge#Edge()} Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Edge, Map) with 'Edge', 'Map'; when Edge(); then Edge() Name is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_whenEdge_thenEdgeNameIsNull() {
    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());
    Edge entity = new Edge();

    // Act
    edgeBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    assertTrue(entity.getAdditionalInfo() instanceof ObjectNode);
    assertNull(entity.getName());
    assertNull(entity.getType());
  }

  /**
   * Test {@link EdgeBulkImportService#saveEntity(SecurityUser, Edge, Map)} with {@code
   * SecurityUser}, {@code Edge}, {@code Map}.
   *
   * <ul>
   *   <li>Then return {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeBulkImportService#saveEntity(SecurityUser, Edge, Map)}
   */
  @Test
  @DisplayName(
      "Test saveEntity(SecurityUser, Edge, Map) with 'SecurityUser', 'Edge', 'Map'; then return Edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeBulkImportService.saveEntity(SecurityUser, Edge, Map)"})
  void testSaveEntityWithSecurityUserEdgeMap_thenReturnEdge() throws Exception {
    // Arrange
    TbEdgeService tbEdgeService = mock(TbEdgeService.class);
    Edge edge = new Edge();
    when(tbEdgeService.save(Mockito.<Edge>any(), Mockito.<RuleChain>any(), Mockito.<User>any()))
        .thenReturn(edge);

    RuleChainService ruleChainService = mock(RuleChainService.class);
    when(ruleChainService.getEdgeTemplateRootRuleChain(Mockito.<TenantId>any()))
        .thenReturn(new RuleChain());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(new EdgeServiceImpl(), tbEdgeService, ruleChainService);
    SecurityUser user = new SecurityUser();
    Edge entity = new Edge();

    // Act
    Edge actualSaveEntityResult = edgeBulkImportService.saveEntity(user, entity, new HashMap<>());

    // Assert
    verify(ruleChainService).getEdgeTemplateRootRuleChain(isNull());
    verify(tbEdgeService).save(isA(Edge.class), isA(RuleChain.class), isA(User.class));
    assertSame(edge, actualSaveEntityResult);
  }

  /**
   * Test {@link EdgeBulkImportService#findOrCreateEntity(TenantId, String)}.
   *
   * <p>Method under test: {@link EdgeBulkImportService#findOrCreateEntity(TenantId, String)}
   */
  @Test
  @DisplayName("Test findOrCreateEntity(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeBulkImportService.findOrCreateEntity(TenantId, String)"})
  void testFindOrCreateEntity() {
    // Arrange
    EdgeServiceImpl edgeService = mock(EdgeServiceImpl.class);
    Edge edge = new Edge();
    when(edgeService.findEdgeByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(edge);
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());

    // Act
    Edge actualFindOrCreateEntityResult =
        edgeBulkImportService.findOrCreateEntity(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Name");

    // Assert
    verify(edgeService).findEdgeByTenantIdAndName(isA(TenantId.class), eq("Name"));
    assertSame(edge, actualFindOrCreateEntityResult);
  }

  /**
   * Test {@link EdgeBulkImportService#getEntityType()}.
   *
   * <p>Method under test: {@link EdgeBulkImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType EdgeBulkImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    EdgeBulkImportService edgeBulkImportService =
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService());

    // Act and Assert
    assertEquals(EntityType.EDGE, edgeBulkImportService.getEntityType());
  }
}
