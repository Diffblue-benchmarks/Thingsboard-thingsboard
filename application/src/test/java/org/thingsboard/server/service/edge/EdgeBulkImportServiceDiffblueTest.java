package org.thingsboard.server.service.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
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
import org.thingsboard.server.common.data.BaseDataWithAdditionalInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.service.entitiy.edge.DefaultTbEdgeService;

@ExtendWith(MockitoExtension.class)
class EdgeBulkImportServiceDiffblueTest {
  @InjectMocks
  private EdgeBulkImportService edgeBulkImportService;

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then calls {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Edge, Map) with 'Edge', 'Map'; given Instance; then calls getAdditionalInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_givenInstance_thenCallsGetAdditionalInfo() {
    // Arrange
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
   * <ul>
   *   <li>Then {@link Edge#Edge(Edge)} with edge is {@link Edge#Edge()} AdditionalInfo {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Edge, Map) with 'Edge', 'Map'; then Edge(Edge) with edge is Edge() AdditionalInfo ObjectNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeBulkImportService.setEntityFields(Edge, Map)"})
  void testSetEntityFieldsWithEdgeMap_thenEdgeWithEdgeIsEdgeAdditionalInfoObjectNode() {
    // Arrange
    Edge entity = new Edge(new Edge());

    // Act
    edgeBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    assertTrue(entity.getAdditionalInfo() instanceof ObjectNode);
  }

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with {@code Edge}, {@code Map}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then {@link Edge#Edge()} AdditionalInfo {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Edge, Map) with 'Edge', 'Map'; when Edge(); then Edge() AdditionalInfo ObjectNode")
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
   * Test {@link EdgeBulkImportService#getEntityType()}.
   * <p>
   * Method under test: {@link EdgeBulkImportService#getEntityType()}
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
    assertEquals(EntityType.EDGE,
        (new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService())).getEntityType());
  }
}
