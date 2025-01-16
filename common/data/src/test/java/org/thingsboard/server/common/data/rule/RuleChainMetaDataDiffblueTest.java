package org.thingsboard.server.common.data.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;

class RuleChainMetaDataDiffblueTest {
  /**
   * Test {@link RuleChainMetaData#addConnectionInfo(int, int, String)}.
   * <ul>
   *   <li>Then {@link RuleChainMetaData} (default constructor) Connections is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainMetaData#addConnectionInfo(int, int, String)}
   */
  @Test
  @DisplayName("Test addConnectionInfo(int, int, String); then RuleChainMetaData (default constructor) Connections is ArrayList()")
  void testAddConnectionInfo_thenRuleChainMetaDataConnectionsIsArrayList() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    ruleChainMetaData.setConnections(connections);

    // Act
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Assert
    assertSame(connections, ruleChainMetaData.getConnections());
  }

  /**
   * Test {@link RuleChainMetaData#addConnectionInfo(int, int, String)}.
   * <ul>
   *   <li>Then {@link RuleChainMetaData} (default constructor) Connections size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainMetaData#addConnectionInfo(int, int, String)}
   */
  @Test
  @DisplayName("Test addConnectionInfo(int, int, String); then RuleChainMetaData (default constructor) Connections size is one")
  void testAddConnectionInfo_thenRuleChainMetaDataConnectionsSizeIsOne() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();

    // Act
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Assert
    List<NodeConnectionInfo> connections = ruleChainMetaData.getConnections();
    assertEquals(1, connections.size());
    NodeConnectionInfo getResult = connections.get(0);
    assertEquals("Type", getResult.getType());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(1, getResult.getToIndex());
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}, and
   * {@link RuleChainMetaData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainMetaData#equals(Object)}
   *   <li>{@link RuleChainMetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();

    // Act and Assert
    assertEquals(ruleChainMetaData, ruleChainMetaData2);
    int expectedHashCodeResult = ruleChainMetaData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainMetaData2.hashCode());
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}, and
   * {@link RuleChainMetaData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainMetaData#equals(Object)}
   *   <li>{@link RuleChainMetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertEquals(ruleChainMetaData, ruleChainMetaData2);
    int expectedHashCodeResult = ruleChainMetaData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainMetaData2.hashCode());
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}, and
   * {@link RuleChainMetaData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainMetaData#equals(Object)}
   *   <li>{@link RuleChainMetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setRuleChainConnections(new ArrayList<>());

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.setRuleChainConnections(new ArrayList<>());

    // Act and Assert
    assertEquals(ruleChainMetaData, ruleChainMetaData2);
    int expectedHashCodeResult = ruleChainMetaData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainMetaData2.hashCode());
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}, and
   * {@link RuleChainMetaData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainMetaData#equals(Object)}
   *   <li>{@link RuleChainMetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();

    // Act and Assert
    assertEquals(ruleChainMetaData, ruleChainMetaData);
    int expectedHashCodeResult = ruleChainMetaData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainMetaData.hashCode());
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(1L);
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setFirstNodeIndex(1);
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(new ArrayList<>());
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.setRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainMetaData2.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.setVersion(1L);
    ruleChainMetaData2.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.setFirstNodeIndex(1);
    ruleChainMetaData2.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.setNodes(new ArrayList<>());
    ruleChainMetaData2.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setRuleChainConnections(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setRuleChainId(mock(RuleChainId.class));
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.setRuleChainConnections(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.setRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(1L);
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setFirstNodeIndex(1);
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.setFirstNodeIndex(1);

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(new ArrayList<>());
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.setNodes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainMetaData(), null);
  }

  /**
   * Test {@link RuleChainMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainMetaData(), "Different type to RuleChainMetaData");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RuleChainMetaData}
   *   <li>{@link RuleChainMetaData#setConnections(List)}
   *   <li>{@link RuleChainMetaData#setFirstNodeIndex(Integer)}
   *   <li>{@link RuleChainMetaData#setNodes(List)}
   *   <li>{@link RuleChainMetaData#setRuleChainConnections(List)}
   *   <li>{@link RuleChainMetaData#setRuleChainId(RuleChainId)}
   *   <li>{@link RuleChainMetaData#setVersion(Long)}
   *   <li>{@link RuleChainMetaData#toString()}
   *   <li>{@link RuleChainMetaData#getConnections()}
   *   <li>{@link RuleChainMetaData#getFirstNodeIndex()}
   *   <li>{@link RuleChainMetaData#getNodes()}
   *   <li>{@link RuleChainMetaData#getRuleChainConnections()}
   *   <li>{@link RuleChainMetaData#getRuleChainId()}
   *   <li>{@link RuleChainMetaData#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    RuleChainMetaData actualRuleChainMetaData = new RuleChainMetaData();
    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    actualRuleChainMetaData.setConnections(connections);
    actualRuleChainMetaData.setFirstNodeIndex(1);
    ArrayList<RuleNode> nodes = new ArrayList<>();
    actualRuleChainMetaData.setNodes(nodes);
    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();
    actualRuleChainMetaData.setRuleChainConnections(ruleChainConnections);
    RuleChainId ruleChainId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleChainMetaData.setRuleChainId(ruleChainId);
    actualRuleChainMetaData.setVersion(1L);
    String actualToStringResult = actualRuleChainMetaData.toString();
    List<NodeConnectionInfo> actualConnections = actualRuleChainMetaData.getConnections();
    Integer actualFirstNodeIndex = actualRuleChainMetaData.getFirstNodeIndex();
    List<RuleNode> actualNodes = actualRuleChainMetaData.getNodes();
    List<RuleChainConnectionInfo> actualRuleChainConnections = actualRuleChainMetaData.getRuleChainConnections();
    RuleChainId actualRuleChainId = actualRuleChainMetaData.getRuleChainId();
    Long actualVersion = actualRuleChainMetaData.getVersion();

    // Assert that nothing has changed
    assertEquals("RuleChainMetaData(ruleChainId=784f394c-42b6-435a-983c-b7beff2784f9, version=1, firstNodeIndex=1,"
        + " nodes=[], connections=[], ruleChainConnections=[])", actualToStringResult);
    assertEquals(1, actualFirstNodeIndex.intValue());
    assertEquals(1L, actualVersion.longValue());
    assertTrue(actualConnections.isEmpty());
    assertTrue(actualNodes.isEmpty());
    assertTrue(actualRuleChainConnections.isEmpty());
    assertSame(connections, actualConnections);
    assertSame(nodes, actualNodes);
    assertSame(ruleChainConnections, actualRuleChainConnections);
    assertSame(ruleChainId, actualRuleChainId);
  }
}
