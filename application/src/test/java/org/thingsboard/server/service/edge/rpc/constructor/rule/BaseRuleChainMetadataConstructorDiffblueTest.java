package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.rule.NodeConnectionInfo;
import org.thingsboard.server.gen.edge.v1.NodeConnectionInfoProto;

class BaseRuleChainMetadataConstructorDiffblueTest {
  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructConnections(List)}.
   *
   * <ul>
   *   <li>Given {@link NodeConnectionInfo} (default constructor) Type is {@code Type}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainMetadataConstructor#constructConnections(List)}
   */
  @Test
  @DisplayName(
      "Test constructConnections(List); given NodeConnectionInfo (default constructor) Type is 'Type'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainMetadataConstructor.constructConnections(List)"})
  void testConstructConnections_givenNodeConnectionInfoTypeIsType_thenReturnSizeIsTwo() {
    // Arrange
    RuleChainMetadataConstructorV330 ruleChainMetadataConstructorV330 =
        new RuleChainMetadataConstructorV330();

    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    NodeConnectionInfo nodeConnectionInfo2 = new NodeConnectionInfo();
    nodeConnectionInfo2.setFromIndex(-1);
    nodeConnectionInfo2.setToIndex(-1);
    nodeConnectionInfo2.setType("42");

    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    connections.add(nodeConnectionInfo2);
    connections.add(nodeConnectionInfo);

    // Act
    List<NodeConnectionInfoProto> actualConstructConnectionsResult =
        ruleChainMetadataConstructorV330.constructConnections(connections);

    // Assert
    assertEquals(2, actualConstructConnectionsResult.size());
    NodeConnectionInfoProto getResult = actualConstructConnectionsResult.get(1);
    assertEquals("", getResult.getInitializationErrorString());
    NodeConnectionInfoProto getResult2 = actualConstructConnectionsResult.get(0);
    assertEquals("42", getResult2.getType());
    assertEquals("Type", getResult.getType());
    assertEquals(-1, getResult2.getFromIndex());
    assertEquals(-1, getResult2.getToIndex());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(1, getResult.getToIndex());
    assertEquals(10, getResult.getSerializedSize());
    assertEquals(26, getResult2.getSerializedSize());
    assertEquals(3, getResult.getAllFields().size());
    assertTrue(getResult.findInitializationErrors().isEmpty());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructConnections(List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainMetadataConstructor#constructConnections(List)}
   */
  @Test
  @DisplayName("Test constructConnections(List); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainMetadataConstructor.constructConnections(List)"})
  void testConstructConnections_thenReturnSizeIsOne() {
    // Arrange
    RuleChainMetadataConstructorV330 ruleChainMetadataConstructorV330 =
        new RuleChainMetadataConstructorV330();

    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Connections");

    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    connections.add(nodeConnectionInfo);

    // Act
    List<NodeConnectionInfoProto> actualConstructConnectionsResult =
        ruleChainMetadataConstructorV330.constructConnections(connections);

    // Assert
    assertEquals(1, actualConstructConnectionsResult.size());
    NodeConnectionInfoProto getResult = actualConstructConnectionsResult.get(0);
    ByteString typeBytes = getResult.getTypeBytes();
    assertEquals("Connections", typeBytes.toStringUtf8());
    assertEquals("Connections", getResult.getType());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(1, getResult.getToIndex());
    assertEquals(17, getResult.getSerializedSize());
    ByteIterator iteratorResult = typeBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('C', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainMetadataConstructor.constructConnections(List)"})
  void testConstructConnections_whenArrayList_thenReturnEmpty() {
    // Arrange
    RuleChainMetadataConstructorV330 ruleChainMetadataConstructorV330 =
        new RuleChainMetadataConstructorV330();

    // Act and Assert
    assertTrue(ruleChainMetadataConstructorV330.constructConnections(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructConnections(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainMetadataConstructor#constructConnections(List)}
   */
  @Test
  @DisplayName("Test constructConnections(List); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainMetadataConstructor.constructConnections(List)"})
  void testConstructConnections_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new RuleChainMetadataConstructorV330().constructConnections(null).isEmpty());
  }
}
