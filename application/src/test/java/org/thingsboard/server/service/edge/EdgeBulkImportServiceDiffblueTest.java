package org.thingsboard.server.service.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.BaseDataWithAdditionalInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.service.entitiy.edge.DefaultTbEdgeService;
import org.thingsboard.server.service.entitiy.edge.TbEdgeService;
import org.thingsboard.server.service.security.model.SecurityUser;

class EdgeBulkImportServiceDiffblueTest {
  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with
   * {@code Edge}, {@code Map}.
   * <p>
   * Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Edge, Map) with 'Edge', 'Map'")
  void testSetEntityFieldsWithEdgeMap() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeService edgeService = mock(EdgeService.class);
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());
    EdgeBulkImportService edgeBulkImportService = new EdgeBulkImportService(edgeService, tbEdgeService,
        new BaseRuleChainService());
    Edge entity = new Edge();

    // Act
    edgeBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    JsonNode additionalInfo = entity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
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
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with
   * {@code Edge}, {@code Map}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then calls {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Edge, Map) with 'Edge', 'Map'; given Instance; then calls getAdditionalInfo()")
  void testSetEntityFieldsWithEdgeMap_givenInstance_thenCallsGetAdditionalInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());
    EdgeBulkImportService edgeBulkImportService = new EdgeBulkImportService(edgeService, tbEdgeService,
        new BaseRuleChainService());
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
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with
   * {@code Edge}, {@code Map}.
   * <ul>
   *   <li>Then {@link Edge#Edge(Edge)} with edge is {@link Edge#Edge()}
   * AdditionalInfo {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Edge, Map) with 'Edge', 'Map'; then Edge(Edge) with edge is Edge() AdditionalInfo ObjectNode")
  void testSetEntityFieldsWithEdgeMap_thenEdgeWithEdgeIsEdgeAdditionalInfoObjectNode() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());
    EdgeBulkImportService edgeBulkImportService = new EdgeBulkImportService(edgeService, tbEdgeService,
        new BaseRuleChainService());
    Edge entity = new Edge(new Edge());

    // Act
    edgeBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    JsonNode additionalInfo = entity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
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
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link EdgeBulkImportService#setEntityFields(Edge, Map)} with
   * {@code Edge}, {@code Map}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then {@link Edge#Edge()} AdditionalInfo {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeBulkImportService#setEntityFields(Edge, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Edge, Map) with 'Edge', 'Map'; when Edge(); then Edge() AdditionalInfo ObjectNode")
  void testSetEntityFieldsWithEdgeMap_whenEdge_thenEdgeAdditionalInfoObjectNode() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());
    EdgeBulkImportService edgeBulkImportService = new EdgeBulkImportService(edgeService, tbEdgeService,
        new BaseRuleChainService());
    Edge entity = new Edge();

    // Act
    edgeBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    JsonNode additionalInfo = entity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
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
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link EdgeBulkImportService#saveEntity(SecurityUser, Edge, Map)} with
   * {@code SecurityUser}, {@code Edge}, {@code Map}.
   * <ul>
   *   <li>Then return {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeBulkImportService#saveEntity(SecurityUser, Edge, Map)}
   */
  @Test
  @DisplayName("Test saveEntity(SecurityUser, Edge, Map) with 'SecurityUser', 'Edge', 'Map'; then return Edge()")
  void testSaveEntityWithSecurityUserEdgeMap_thenReturnEdge() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEdgeService tbEdgeService = mock(TbEdgeService.class);
    Edge edge = new Edge();
    when(tbEdgeService.save(Mockito.<Edge>any(), Mockito.<RuleChain>any(), Mockito.<User>any())).thenReturn(edge);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    when(ruleChainService.getEdgeTemplateRootRuleChain(Mockito.<TenantId>any())).thenReturn(new RuleChain());
    EdgeBulkImportService edgeBulkImportService = new EdgeBulkImportService(new EdgeServiceImpl(), tbEdgeService,
        ruleChainService);
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
   * <ul>
   *   <li>Then return {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeBulkImportService#findOrCreateEntity(TenantId, String)}
   */
  @Test
  @DisplayName("Test findOrCreateEntity(TenantId, String); then return Edge()")
  void testFindOrCreateEntity_thenReturnEdge() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeServiceImpl edgeService = mock(EdgeServiceImpl.class);
    Edge edge = new Edge();
    when(edgeService.findEdgeByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(edge);
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());
    EdgeBulkImportService edgeBulkImportService = new EdgeBulkImportService(edgeService, tbEdgeService,
        new BaseRuleChainService());

    // Act
    Edge actualFindOrCreateEntityResult = edgeBulkImportService.findOrCreateEntity(new TenantId(UUID.randomUUID()),
        "Name");

    // Assert
    verify(edgeService).findEdgeByTenantIdAndName(isA(TenantId.class), eq("Name"));
    assertSame(edge, actualFindOrCreateEntityResult);
  }

  /**
   * Test {@link EdgeBulkImportService#getEntityType()}.
   * <p>
   * Method under test: {@link EdgeBulkImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
    // Arrange
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbEdgeService tbEdgeService = new DefaultTbEdgeService(new BaseRuleChainService());

    // Act and Assert
    assertEquals(EntityType.EDGE,
        (new EdgeBulkImportService(edgeService, tbEdgeService, new BaseRuleChainService())).getEntityType());
  }
}
