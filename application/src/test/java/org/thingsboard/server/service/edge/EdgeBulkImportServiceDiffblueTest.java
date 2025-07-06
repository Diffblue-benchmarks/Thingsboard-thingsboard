package org.thingsboard.server.service.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportColumnType;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.service.entitiy.edge.DefaultTbEdgeService;

@ExtendWith(MockitoExtension.class)
class EdgeBulkImportServiceDiffblueTest {
  @InjectMocks private EdgeBulkImportService edgeBulkImportService;

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code LABEL}.
   *   <li>Then calls {@link Edge#setLabel(String)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Edge, Map) with 'Edge', 'Map'; given 'LABEL'; then calls setLabel(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_givenLabel_thenCallsSetLabel() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Edge entity = mock(Edge.class);
    doNothing().when(entity).setLabel(Mockito.<String>any());
    doNothing().when(entity).setType(Mockito.<String>any());
    doNothing().when(entity).setName(Mockito.<String>any());
    when(entity.getAdditionalInfo()).thenReturn(jsonNode);
    doNothing().when(entity).setAdditionalInfo(Mockito.<JsonNode>any());

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.LABEL, "");
    fields.put(BulkImportColumnType.TYPE, "42");
    fields.put(BulkImportColumnType.NAME, "foo");

    // Act
    edgeBulkImportService.setEntityFields(entity, fields);

    // Assert
    verify(jsonNode).isNull();
    verify(entity, atLeast(1)).getAdditionalInfo();
    verify(entity).setAdditionalInfo(isA(JsonNode.class));
    verify(entity).setLabel(eq(""));
    verify(entity).setName(eq("foo"));
    verify(entity).setType(eq("42"));
  }

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code NAME}.
   *   <li>Then calls {@link Edge#setName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Edge, Map) with 'Edge', 'Map'; given 'NAME'; then calls setName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_givenName_thenCallsSetName() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Edge entity = mock(Edge.class);
    doNothing().when(entity).setName(Mockito.<String>any());
    when(entity.getAdditionalInfo()).thenReturn(jsonNode);
    doNothing().when(entity).setAdditionalInfo(Mockito.<JsonNode>any());

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.NAME, "foo");

    // Act
    edgeBulkImportService.setEntityFields(entity, fields);

    // Assert
    verify(jsonNode).isNull();
    verify(entity, atLeast(1)).getAdditionalInfo();
    verify(entity).setAdditionalInfo(isA(JsonNode.class));
    verify(entity).setName(eq("foo"));
  }

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code SHARED_ATTRIBUTE}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Edge, Map) with 'Edge', 'Map'; given 'SHARED_ATTRIBUTE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_givenSharedAttribute() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Edge entity = mock(Edge.class);
    doNothing().when(entity).setType(Mockito.<String>any());
    doNothing().when(entity).setName(Mockito.<String>any());
    when(entity.getAdditionalInfo()).thenReturn(jsonNode);
    doNothing().when(entity).setAdditionalInfo(Mockito.<JsonNode>any());

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.SHARED_ATTRIBUTE, "");
    fields.put(BulkImportColumnType.TYPE, "42");
    fields.put(BulkImportColumnType.NAME, "foo");

    // Act
    edgeBulkImportService.setEntityFields(entity, fields);

    // Assert
    verify(jsonNode).isNull();
    verify(entity, atLeast(1)).getAdditionalInfo();
    verify(entity).setAdditionalInfo(isA(JsonNode.class));
    verify(entity).setName(eq("foo"));
    verify(entity).setType(eq("42"));
  }

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code TYPE}.
   *   <li>Then calls {@link Edge#setType(String)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Edge, Map) with 'Edge', 'Map'; given 'TYPE'; then calls setType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_givenType_thenCallsSetType() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Edge entity = mock(Edge.class);
    doNothing().when(entity).setType(Mockito.<String>any());
    doNothing().when(entity).setName(Mockito.<String>any());
    when(entity.getAdditionalInfo()).thenReturn(jsonNode);
    doNothing().when(entity).setAdditionalInfo(Mockito.<JsonNode>any());

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.TYPE, "42");
    fields.put(BulkImportColumnType.NAME, "foo");

    // Act
    edgeBulkImportService.setEntityFields(entity, fields);

    // Assert
    verify(jsonNode).isNull();
    verify(entity, atLeast(1)).getAdditionalInfo();
    verify(entity).setAdditionalInfo(isA(JsonNode.class));
    verify(entity).setName(eq("foo"));
    verify(entity).setType(eq("42"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_thenEdgeWithEdgeIsEdgeAdditionalInfoObjectNode() {
    // Arrange
    Edge entity = new Edge(new Edge());

    // Act
    edgeBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    JsonNode additionalInfo = entity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals("{ }", additionalInfo.toPrettyString());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isNull());
    assertFalse(additionalInfo.isValueNode());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isObject());
  }

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge()}.
   *   <li>Then {@link Edge#Edge()} AdditionalInfo {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Edge, Map) with 'Edge', 'Map'; when Edge(); then Edge() AdditionalInfo ObjectNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_whenEdge_thenEdgeAdditionalInfoObjectNode() {
    // Arrange
    Edge entity = new Edge();

    // Act
    edgeBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    JsonNode additionalInfo = entity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
  }

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then calls {@link JsonNode#isNull()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Edge, Map) with 'Edge', 'Map'; when HashMap(); then calls isNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_whenHashMap_thenCallsIsNull() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Edge entity = mock(Edge.class);
    when(entity.getAdditionalInfo()).thenReturn(jsonNode);
    doNothing().when(entity).setAdditionalInfo(Mockito.<JsonNode>any());

    // Act
    edgeBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    verify(jsonNode).isNull();
    verify(entity, atLeast(1)).getAdditionalInfo();
    verify(entity).setAdditionalInfo(isA(JsonNode.class));
  }

  /**
   * Test {@link EdgeBulkImportService#getEntityType()}.
   *
   * <p>Method under test: {@link EdgeBulkImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType EdgeBulkImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    // Act and Assert
    assertEquals(
        EntityType.EDGE,
        new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService())
            .getEntityType());
  }
}
