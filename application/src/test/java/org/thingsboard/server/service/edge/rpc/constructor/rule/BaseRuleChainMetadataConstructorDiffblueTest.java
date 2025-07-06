package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.rule.NodeConnectionInfo;
import org.thingsboard.server.common.data.rule.RuleChainConnectionInfo;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.gen.edge.v1.NodeConnectionInfoProto;
import org.thingsboard.server.gen.edge.v1.RuleChainConnectionInfoProto;
import org.thingsboard.server.gen.edge.v1.RuleNodeProto;

@ContextConfiguration(classes = {RuleChainMetadataConstructorV330.class})
@ExtendWith(SpringExtension.class)
class BaseRuleChainMetadataConstructorDiffblueTest {
  @Autowired private BaseRuleChainMetadataConstructor baseRuleChainMetadataConstructor;

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructConnections(List)}.
   *
   * <ul>
   *   <li>Given {@link NodeConnectionInfo} (default constructor) Type is {@code Type}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainMetadataConstructor#constructConnections(List)}
   */
  @Test
  @DisplayName(
      "Test constructConnections(List); given NodeConnectionInfo (default constructor) Type is 'Type'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseRuleChainMetadataConstructor.constructConnections(List)"})
  void testConstructConnections_givenNodeConnectionInfoTypeIsType_thenReturnSizeIsOne() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    connections.add(nodeConnectionInfo);

    // Act
    List<NodeConnectionInfoProto> actualConstructConnectionsResult =
        baseRuleChainMetadataConstructor.constructConnections(connections);

    // Assert
    assertEquals(1, actualConstructConnectionsResult.size());
    NodeConnectionInfoProto getResult = actualConstructConnectionsResult.get(0);
    ByteString typeBytes = getResult.getTypeBytes();
    assertEquals("Type", typeBytes.toStringUtf8());
    assertEquals("Type", getResult.getType());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(1, getResult.getToIndex());
    assertEquals(10, getResult.getSerializedSize());
    assertEquals(3, getResult.getDescriptorForType().getFields().size());
    assertEquals(3, getResult.getAllFields().size());
    assertFalse(typeBytes.isEmpty());
    assertTrue(typeBytes.iterator().hasNext());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructConnections(List)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainMetadataConstructor#constructConnections(List)}
   */
  @Test
  @DisplayName("Test constructConnections(List); then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseRuleChainMetadataConstructor.constructConnections(List)"})
  void testConstructConnections_thenReturnSizeIsTwo() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    NodeConnectionInfo nodeConnectionInfo2 = new NodeConnectionInfo();
    nodeConnectionInfo2.setFromIndex(-1);
    nodeConnectionInfo2.setToIndex(-1);
    nodeConnectionInfo2.setType("");

    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    connections.add(nodeConnectionInfo2);
    connections.add(nodeConnectionInfo);

    // Act
    List<NodeConnectionInfoProto> actualConstructConnectionsResult =
        baseRuleChainMetadataConstructor.constructConnections(connections);

    // Assert
    assertEquals(2, actualConstructConnectionsResult.size());
    NodeConnectionInfoProto getResult = actualConstructConnectionsResult.get(1);
    assertEquals("", getResult.getInitializationErrorString());
    NodeConnectionInfoProto getResult2 = actualConstructConnectionsResult.get(0);
    assertEquals("", getResult2.getType());
    assertEquals("Type", getResult.getType());
    assertEquals(-1, getResult2.getFromIndex());
    assertEquals(-1, getResult2.getToIndex());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(1, getResult.getToIndex());
    assertEquals(10, getResult.getSerializedSize());
    assertEquals(2, getResult2.getAllFields().size());
    assertEquals(22, getResult2.getSerializedSize());
    assertEquals(3, getResult.getAllFields().size());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructConnections(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainMetadataConstructor#constructConnections(List)}
   */
  @Test
  @DisplayName("Test constructConnections(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseRuleChainMetadataConstructor.constructConnections(List)"})
  void testConstructConnections_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(baseRuleChainMetadataConstructor.constructConnections(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructNodes(List)}.
   *
   * <p>Method under test: {@link BaseRuleChainMetadataConstructor#constructNodes(List)}
   */
  @Test
  @DisplayName("Test constructNodes(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseRuleChainMetadataConstructor.constructNodes(List)"})
  void testConstructNodes() {
    // Arrange
    ArrayList<RuleNode> nodes = new ArrayList<>();
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNode.isSingletonMode()).thenReturn(true);
    when(ruleNode.getAdditionalInfo())
        .thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(ruleNode.getConfiguration()).thenReturn(DoubleNode.valueOf(10.0d));
    when(ruleNode.getName()).thenReturn("Name");
    when(ruleNode.getType()).thenReturn("Type");
    when(ruleNode.getCreatedTime()).thenReturn(1L);
    when(ruleNode.getRuleChainId())
        .thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNode.getExternalId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNode.getId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleNode ruleNode2 = new RuleNode(ruleNode);
    ruleNode2.setName("");
    ruleNode2.setType("Type");
    ruleNode2.setId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    nodes.add(ruleNode2);

    // Act
    List<RuleNodeProto> actualConstructNodesResult =
        baseRuleChainMetadataConstructor.constructNodes(nodes);

    // Assert
    assertEquals(1, actualConstructNodesResult.size());
    RuleNodeProto getResult = actualConstructNodesResult.get(0);
    assertEquals("[]", getResult.getAdditionalInfo());
    ByteString additionalInfoBytes = getResult.getAdditionalInfoBytes();
    ByteIterator iteratorResult = additionalInfoBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('[', nextResult.byteValue());
    assertEquals(']', nextResult2.byteValue());
    assertEquals("[]", additionalInfoBytes.toStringUtf8());
    ByteString configurationBytes = getResult.getConfigurationBytes();
    assertFalse(configurationBytes.isEmpty());
    ByteIterator iteratorResult2 = configurationBytes.iterator();
    Byte nextResult3 = iteratorResult2.next();
    Byte nextResult4 = iteratorResult2.next();
    assertTrue(iteratorResult2.hasNext());
    assertEquals('1', nextResult3.byteValue());
    assertEquals('0', nextResult4.byteValue());
    assertEquals("10.0", configurationBytes.toStringUtf8());
    assertEquals(41, getResult.getSerializedSize());
    verify(ruleNode).isDebugMode();
    verify(ruleNode).isSingletonMode();
    verify(ruleNode).getAdditionalInfo();
    verify(ruleNode).getConfiguration();
    verify(ruleNode).getName();
    verify(ruleNode).getType();
    verify(ruleNode).getCreatedTime();
    verify(ruleNode).getRuleChainId();
    verify(ruleNode).getExternalId();
    verify(ruleNode).getId();
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructNodes(List)}.
   *
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode(RuleNode)} with ruleNode is {@link RuleNode#RuleNode()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainMetadataConstructor#constructNodes(List)}
   */
  @Test
  @DisplayName("Test constructNodes(List); given RuleNode(RuleNode) with ruleNode is RuleNode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseRuleChainMetadataConstructor.constructNodes(List)"})
  void testConstructNodes_givenRuleNodeWithRuleNodeIsRuleNode() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode(new RuleNode()));
    ruleNode.setName("");
    ruleNode.setType("Type");
    ruleNode.setId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(ruleNode);

    // Act
    List<RuleNodeProto> actualConstructNodesResult =
        baseRuleChainMetadataConstructor.constructNodes(nodes);

    // Assert
    assertEquals(1, actualConstructNodesResult.size());
    RuleNodeProto getResult = actualConstructNodesResult.get(0);
    ByteString additionalInfoBytes = getResult.getAdditionalInfoBytes();
    assertEquals("null", additionalInfoBytes.toStringUtf8());
    assertEquals("null", getResult.getAdditionalInfo());
    assertEquals("null", getResult.getConfiguration());
    assertEquals(39, getResult.getSerializedSize());
    assertEquals(5, getResult.getAllFields().size());
    assertFalse(getResult.getDebugMode());
    assertFalse(getResult.getSingletonMode());
    ByteIterator iteratorResult = additionalInfoBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructNodes(List)}.
   *
   * <ul>
   *   <li>Then return first AdditionalInfoBytes toStringUtf8 is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainMetadataConstructor#constructNodes(List)}
   */
  @Test
  @DisplayName(
      "Test constructNodes(List); then return first AdditionalInfoBytes toStringUtf8 is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseRuleChainMetadataConstructor.constructNodes(List)"})
  void testConstructNodes_thenReturnFirstAdditionalInfoBytesToStringUtf8IsNull() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode());
    ruleNode.setName("");
    ruleNode.setType("Type");
    ruleNode.setId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(ruleNode);

    // Act
    List<RuleNodeProto> actualConstructNodesResult =
        baseRuleChainMetadataConstructor.constructNodes(nodes);

    // Assert
    assertEquals(1, actualConstructNodesResult.size());
    RuleNodeProto getResult = actualConstructNodesResult.get(0);
    ByteString additionalInfoBytes = getResult.getAdditionalInfoBytes();
    assertEquals("null", additionalInfoBytes.toStringUtf8());
    assertEquals("null", getResult.getAdditionalInfo());
    assertEquals("null", getResult.getConfiguration());
    assertEquals(39, getResult.getSerializedSize());
    assertEquals(5, getResult.getAllFields().size());
    assertFalse(getResult.getDebugMode());
    assertFalse(getResult.getSingletonMode());
    ByteIterator iteratorResult = additionalInfoBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructNodes(List)}.
   *
   * <ul>
   *   <li>Then return first AdditionalInfo is {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainMetadataConstructor#constructNodes(List)}
   */
  @Test
  @DisplayName("Test constructNodes(List); then return first AdditionalInfo is '10.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseRuleChainMetadataConstructor.constructNodes(List)"})
  void testConstructNodes_thenReturnFirstAdditionalInfoIs100() {
    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNode.isSingletonMode()).thenReturn(true);
    when(ruleNode.getAdditionalInfo()).thenReturn(DoubleNode.valueOf(10.0d));
    when(ruleNode.getConfiguration()).thenReturn(DoubleNode.valueOf(10.0d));
    when(ruleNode.getName()).thenReturn("Name");
    when(ruleNode.getType()).thenReturn("Type");
    when(ruleNode.getCreatedTime()).thenReturn(1L);
    when(ruleNode.getRuleChainId())
        .thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNode.getExternalId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNode.getId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleNode ruleNode2 = new RuleNode(ruleNode);
    ruleNode2.setName("");
    ruleNode2.setType("Type");
    ruleNode2.setId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(ruleNode2);

    // Act
    List<RuleNodeProto> actualConstructNodesResult =
        baseRuleChainMetadataConstructor.constructNodes(nodes);

    // Assert
    assertEquals(1, actualConstructNodesResult.size());
    RuleNodeProto getResult = actualConstructNodesResult.get(0);
    assertEquals("10.0", getResult.getAdditionalInfo());
    ByteString additionalInfoBytes = getResult.getAdditionalInfoBytes();
    ByteIterator iteratorResult = additionalInfoBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('1', iteratorResult.next().byteValue());
    assertEquals('0', iteratorResult.next().byteValue());
    assertEquals("10.0", additionalInfoBytes.toStringUtf8());
    assertEquals(43, getResult.getSerializedSize());
    verify(ruleNode).isDebugMode();
    verify(ruleNode).isSingletonMode();
    verify(ruleNode).getAdditionalInfo();
    verify(ruleNode).getConfiguration();
    verify(ruleNode).getName();
    verify(ruleNode).getType();
    verify(ruleNode).getCreatedTime();
    verify(ruleNode).getRuleChainId();
    verify(ruleNode).getExternalId();
    verify(ruleNode).getId();
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructNodes(List)}.
   *
   * <ul>
   *   <li>Then return first InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainMetadataConstructor#constructNodes(List)}
   */
  @Test
  @DisplayName(
      "Test constructNodes(List); then return first InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseRuleChainMetadataConstructor.constructNodes(List)"})
  void testConstructNodes_thenReturnFirstInitializationErrorStringIsEmptyString() {
    // Arrange
    RuleChainMetadataConstructorV330 ruleChainMetadataConstructorV330 =
        new RuleChainMetadataConstructorV330();

    RuleNode ruleNode = new RuleNode(new RuleNode());
    ruleNode.setConfigurationBytes(new byte[] {});
    ruleNode.setName("");
    ruleNode.setType("Type");
    ruleNode.setId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(ruleNode);

    // Act
    List<RuleNodeProto> actualConstructNodesResult =
        ruleChainMetadataConstructorV330.constructNodes(nodes);

    // Assert
    assertEquals(1, actualConstructNodesResult.size());
    RuleNodeProto getResult = actualConstructNodesResult.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals("null", getResult.getAdditionalInfo());
    assertEquals("null", getResult.getConfiguration());
    assertEquals(-7476899250389416711L, getResult.getIdLSB());
    assertEquals(0, getResult.getConfigurationVersion());
    assertEquals(39, getResult.getSerializedSize());
    assertEquals(5, getResult.getAllFields().size());
    assertEquals(8669210807411032922L, getResult.getIdMSB());
    assertFalse(getResult.getDebugMode());
    assertFalse(getResult.getSingletonMode());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructNodes(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainMetadataConstructor#constructNodes(List)}
   */
  @Test
  @DisplayName("Test constructNodes(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseRuleChainMetadataConstructor.constructNodes(List)"})
  void testConstructNodes_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(baseRuleChainMetadataConstructor.constructNodes(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List,
   * NavigableSet)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName("Test constructRuleChainConnections(List, NavigableSet)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseRuleChainMetadataConstructor.constructRuleChainConnections(List, NavigableSet)"
  })
  void testConstructRuleChainConnections() {
    // Arrange
    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();
    RuleChainConnectionInfo ruleChainConnectionInfo = mock(RuleChainConnectionInfo.class);
    when(ruleChainConnectionInfo.getAdditionalInfo())
        .thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(ruleChainConnectionInfo.getType()).thenReturn("Type");
    when(ruleChainConnectionInfo.getFromIndex()).thenReturn(1);
    when(ruleChainConnectionInfo.getTargetRuleChainId())
        .thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(ruleChainConnectionInfo).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainConnectionInfo).setFromIndex(anyInt());
    doNothing().when(ruleChainConnectionInfo).setTargetRuleChainId(Mockito.<RuleChainId>any());
    doNothing().when(ruleChainConnectionInfo).setType(Mockito.<String>any());
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");
    ruleChainConnections.add(ruleChainConnectionInfo);

    // Act
    List<RuleChainConnectionInfoProto> actualConstructRuleChainConnectionsResult =
        baseRuleChainMetadataConstructor.constructRuleChainConnections(
            ruleChainConnections, new TreeSet<>());

    // Assert
    assertEquals(1, actualConstructRuleChainConnectionsResult.size());
    RuleChainConnectionInfoProto getResult = actualConstructRuleChainConnectionsResult.get(0);
    assertEquals("[]", getResult.getAdditionalInfo());
    ByteString additionalInfoBytes = getResult.getAdditionalInfoBytes();
    ByteIterator iteratorResult = additionalInfoBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('[', nextResult.byteValue());
    assertEquals(']', nextResult2.byteValue());
    assertEquals("[]", additionalInfoBytes.toStringUtf8());
    assertEquals(33, getResult.getSerializedSize());
    verify(ruleChainConnectionInfo).getAdditionalInfo();
    verify(ruleChainConnectionInfo).getFromIndex();
    verify(ruleChainConnectionInfo).getType();
    verify(ruleChainConnectionInfo, atLeast(1)).getTargetRuleChainId();
    verify(ruleChainConnectionInfo).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainConnectionInfo).setFromIndex(eq(1));
    verify(ruleChainConnectionInfo).setTargetRuleChainId(isA(RuleChainId.class));
    verify(ruleChainConnectionInfo).setType(eq("Type"));
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List,
   * NavigableSet)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName("Test constructRuleChainConnections(List, NavigableSet)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseRuleChainMetadataConstructor.constructRuleChainConnections(List, NavigableSet)"
  })
  void testConstructRuleChainConnections2() {
    // Arrange
    RuleChainMetadataConstructorV330 ruleChainMetadataConstructorV330 =
        new RuleChainMetadataConstructorV330();
    RuleChainConnectionInfo ruleChainConnectionInfo = mock(RuleChainConnectionInfo.class);
    when(ruleChainConnectionInfo.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(ruleChainConnectionInfo.getType()).thenReturn("Type");
    when(ruleChainConnectionInfo.getFromIndex()).thenReturn(1);
    when(ruleChainConnectionInfo.getTargetRuleChainId())
        .thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(ruleChainConnectionInfo).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainConnectionInfo).setFromIndex(anyInt());
    doNothing().when(ruleChainConnectionInfo).setTargetRuleChainId(Mockito.<RuleChainId>any());
    doNothing().when(ruleChainConnectionInfo).setType(Mockito.<String>any());
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();
    ruleChainConnections.add(ruleChainConnectionInfo);

    // Act
    List<RuleChainConnectionInfoProto> actualConstructRuleChainConnectionsResult =
        ruleChainMetadataConstructorV330.constructRuleChainConnections(
            ruleChainConnections, new TreeSet<>());

    // Assert
    verify(ruleChainConnectionInfo).getAdditionalInfo();
    verify(ruleChainConnectionInfo).getFromIndex();
    verify(ruleChainConnectionInfo, atLeast(1)).getTargetRuleChainId();
    verify(ruleChainConnectionInfo).getType();
    verify(ruleChainConnectionInfo).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainConnectionInfo).setFromIndex(eq(1));
    verify(ruleChainConnectionInfo).setTargetRuleChainId(isA(RuleChainId.class));
    verify(ruleChainConnectionInfo).setType(eq("Type"));
    assertEquals(1, actualConstructRuleChainConnectionsResult.size());
    RuleChainConnectionInfoProto getResult = actualConstructRuleChainConnectionsResult.get(0);
    ByteString additionalInfoBytes = getResult.getAdditionalInfoBytes();
    assertEquals("null", additionalInfoBytes.toStringUtf8());
    assertEquals("null", getResult.getAdditionalInfo());
    ByteIterator iteratorResult = additionalInfoBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List,
   * NavigableSet)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link TreeSet#TreeSet()} add one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainConnections(List, NavigableSet); given one; when TreeSet() add one; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseRuleChainMetadataConstructor.constructRuleChainConnections(List, NavigableSet)"
  })
  void testConstructRuleChainConnections_givenOne_whenTreeSetAddOne_thenReturnEmpty() {
    // Arrange
    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();

    TreeSet<Integer> removedNodeIndexes = new TreeSet<>();
    removedNodeIndexes.add(1);
    removedNodeIndexes.add(2);

    // Act and Assert
    assertTrue(
        baseRuleChainMetadataConstructor
            .constructRuleChainConnections(ruleChainConnections, removedNodeIndexes)
            .isEmpty());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List,
   * NavigableSet)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link TreeSet#TreeSet()} add two.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainConnections(List, NavigableSet); given two; when TreeSet() add two; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseRuleChainMetadataConstructor.constructRuleChainConnections(List, NavigableSet)"
  })
  void testConstructRuleChainConnections_givenTwo_whenTreeSetAddTwo_thenReturnEmpty() {
    // Arrange
    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();

    TreeSet<Integer> removedNodeIndexes = new TreeSet<>();
    removedNodeIndexes.add(2);

    // Act and Assert
    assertTrue(
        baseRuleChainMetadataConstructor
            .constructRuleChainConnections(ruleChainConnections, removedNodeIndexes)
            .isEmpty());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List,
   * NavigableSet)}.
   *
   * <ul>
   *   <li>Then return first AdditionalInfo is {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainConnections(List, NavigableSet); then return first AdditionalInfo is '2.3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseRuleChainMetadataConstructor.constructRuleChainConnections(List, NavigableSet)"
  })
  void testConstructRuleChainConnections_thenReturnFirstAdditionalInfoIs23() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = mock(RuleChainConnectionInfo.class);
    when(ruleChainConnectionInfo.getAdditionalInfo())
        .thenReturn(new DecimalNode(new BigDecimal("2.3")));
    when(ruleChainConnectionInfo.getType()).thenReturn("Type");
    when(ruleChainConnectionInfo.getFromIndex()).thenReturn(1);
    when(ruleChainConnectionInfo.getTargetRuleChainId())
        .thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(ruleChainConnectionInfo).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainConnectionInfo).setFromIndex(anyInt());
    doNothing().when(ruleChainConnectionInfo).setTargetRuleChainId(Mockito.<RuleChainId>any());
    doNothing().when(ruleChainConnectionInfo).setType(Mockito.<String>any());
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();
    ruleChainConnections.add(ruleChainConnectionInfo);

    // Act
    List<RuleChainConnectionInfoProto> actualConstructRuleChainConnectionsResult =
        baseRuleChainMetadataConstructor.constructRuleChainConnections(
            ruleChainConnections, new TreeSet<>());

    // Assert
    assertEquals(1, actualConstructRuleChainConnectionsResult.size());
    RuleChainConnectionInfoProto getResult = actualConstructRuleChainConnectionsResult.get(0);
    assertEquals("2.3", getResult.getAdditionalInfo());
    ByteString additionalInfoBytes = getResult.getAdditionalInfoBytes();
    ByteIterator iteratorResult = additionalInfoBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('2', iteratorResult.next().byteValue());
    assertEquals('.', iteratorResult.next().byteValue());
    assertEquals("2.3", additionalInfoBytes.toStringUtf8());
    assertEquals(34, getResult.getSerializedSize());
    verify(ruleChainConnectionInfo).getAdditionalInfo();
    verify(ruleChainConnectionInfo).getFromIndex();
    verify(ruleChainConnectionInfo).getType();
    verify(ruleChainConnectionInfo, atLeast(1)).getTargetRuleChainId();
    verify(ruleChainConnectionInfo).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainConnectionInfo).setFromIndex(eq(1));
    verify(ruleChainConnectionInfo).setTargetRuleChainId(isA(RuleChainId.class));
    verify(ruleChainConnectionInfo).setType(eq("Type"));
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List,
   * NavigableSet)}.
   *
   * <ul>
   *   <li>Then return first AdditionalInfo is {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainConnections(List, NavigableSet); then return first AdditionalInfo is '10.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseRuleChainMetadataConstructor.constructRuleChainConnections(List, NavigableSet)"
  })
  void testConstructRuleChainConnections_thenReturnFirstAdditionalInfoIs100() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();
    ruleChainConnections.add(ruleChainConnectionInfo);

    // Act
    List<RuleChainConnectionInfoProto> actualConstructRuleChainConnectionsResult =
        baseRuleChainMetadataConstructor.constructRuleChainConnections(
            ruleChainConnections, new TreeSet<>());

    // Assert
    assertEquals(1, actualConstructRuleChainConnectionsResult.size());
    RuleChainConnectionInfoProto getResult = actualConstructRuleChainConnectionsResult.get(0);
    assertEquals("10.0", getResult.getAdditionalInfo());
    ByteString additionalInfoBytes = getResult.getAdditionalInfoBytes();
    ByteIterator iteratorResult = additionalInfoBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('1', iteratorResult.next().byteValue());
    assertEquals('0', iteratorResult.next().byteValue());
    assertEquals("10.0", additionalInfoBytes.toStringUtf8());
    assertEquals(35, getResult.getSerializedSize());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List,
   * NavigableSet)}.
   *
   * <ul>
   *   <li>Then return first AdditionalInfo is {@code "QVhBWEFYQVg="}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainConnections(List, NavigableSet); then return first AdditionalInfo is '\"QVhBWEFYQVg=\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseRuleChainMetadataConstructor.constructRuleChainConnections(List, NavigableSet)"
  })
  void testConstructRuleChainConnections_thenReturnFirstAdditionalInfoIsQVhBWEFYQVg()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = mock(RuleChainConnectionInfo.class);
    when(ruleChainConnectionInfo.getAdditionalInfo())
        .thenReturn(new BinaryNode("AXAXAXAX".getBytes("UTF-8")));
    when(ruleChainConnectionInfo.getType()).thenReturn("Type");
    when(ruleChainConnectionInfo.getFromIndex()).thenReturn(1);
    when(ruleChainConnectionInfo.getTargetRuleChainId())
        .thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(ruleChainConnectionInfo).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainConnectionInfo).setFromIndex(anyInt());
    doNothing().when(ruleChainConnectionInfo).setTargetRuleChainId(Mockito.<RuleChainId>any());
    doNothing().when(ruleChainConnectionInfo).setType(Mockito.<String>any());
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();
    ruleChainConnections.add(ruleChainConnectionInfo);

    // Act
    List<RuleChainConnectionInfoProto> actualConstructRuleChainConnectionsResult =
        baseRuleChainMetadataConstructor.constructRuleChainConnections(
            ruleChainConnections, new TreeSet<>());

    // Assert
    assertEquals(1, actualConstructRuleChainConnectionsResult.size());
    RuleChainConnectionInfoProto getResult = actualConstructRuleChainConnectionsResult.get(0);
    assertEquals("\"QVhBWEFYQVg=\"", getResult.getAdditionalInfo());
    ByteString additionalInfoBytes = getResult.getAdditionalInfoBytes();
    ByteIterator iteratorResult = additionalInfoBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('"', iteratorResult.next().byteValue());
    assertEquals('Q', iteratorResult.next().byteValue());
    assertEquals("\"QVhBWEFYQVg=\"", additionalInfoBytes.toStringUtf8());
    assertEquals(45, getResult.getSerializedSize());
    verify(ruleChainConnectionInfo).getAdditionalInfo();
    verify(ruleChainConnectionInfo).getFromIndex();
    verify(ruleChainConnectionInfo).getType();
    verify(ruleChainConnectionInfo, atLeast(1)).getTargetRuleChainId();
    verify(ruleChainConnectionInfo).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainConnectionInfo).setFromIndex(eq(1));
    verify(ruleChainConnectionInfo).setTargetRuleChainId(isA(RuleChainId.class));
    verify(ruleChainConnectionInfo).setType(eq("Type"));
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List,
   * NavigableSet)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName("Test constructRuleChainConnections(List, NavigableSet); then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseRuleChainMetadataConstructor.constructRuleChainConnections(List, NavigableSet)"
  })
  void testConstructRuleChainConnections_thenReturnSizeIsTwo() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo2.setFromIndex(-1);
    ruleChainConnectionInfo2.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo2.setType("");

    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();
    ruleChainConnections.add(ruleChainConnectionInfo2);
    ruleChainConnections.add(ruleChainConnectionInfo);

    // Act
    List<RuleChainConnectionInfoProto> actualConstructRuleChainConnectionsResult =
        baseRuleChainMetadataConstructor.constructRuleChainConnections(
            ruleChainConnections, new TreeSet<>());

    // Assert
    assertEquals(2, actualConstructRuleChainConnectionsResult.size());
    RuleChainConnectionInfoProto getResult = actualConstructRuleChainConnectionsResult.get(1);
    assertEquals("", getResult.getInitializationErrorString());
    RuleChainConnectionInfoProto getResult2 = actualConstructRuleChainConnectionsResult.get(0);
    assertEquals("", getResult2.getType());
    assertEquals("10.0", getResult.getAdditionalInfo());
    assertEquals("Type", getResult.getType());
    assertEquals(-1, getResult2.getFromIndex());
    assertEquals(-7476899250389416711L, getResult.getTargetRuleChainIdLSB());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(35, getResult.getSerializedSize());
    assertEquals(38, getResult2.getSerializedSize());
    assertEquals(4, getResult2.getAllFields().size());
    assertEquals(5, getResult.getAllFields().size());
    assertEquals(8669210807411032922L, getResult.getTargetRuleChainIdMSB());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List,
   * NavigableSet)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainConnections(List, NavigableSet); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseRuleChainMetadataConstructor.constructRuleChainConnections(List, NavigableSet)"
  })
  void testConstructRuleChainConnections_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();

    // Act and Assert
    assertTrue(
        baseRuleChainMetadataConstructor
            .constructRuleChainConnections(ruleChainConnections, new TreeSet<>())
            .isEmpty());
  }
}
