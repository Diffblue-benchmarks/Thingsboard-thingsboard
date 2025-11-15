/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;

class RuleChainMetaDataDiffblueTest {
  /**
   * Method under test:
   * {@link RuleChainMetaData#addConnectionInfo(int, int, String)}
   */
  @Test
  void testAddConnectionInfo() {
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
   * Method under test:
   * {@link RuleChainMetaData#addConnectionInfo(int, int, String)}
   */
  @Test
  void testAddConnectionInfo2() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainMetaData#equals(Object)}
   *   <li>{@link RuleChainMetaData#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainMetaData#equals(Object)}
   *   <li>{@link RuleChainMetaData#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainMetaData#equals(Object)}
   *   <li>{@link RuleChainMetaData#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainMetaData#equals(Object)}
   *   <li>{@link RuleChainMetaData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();

    // Act and Assert
    assertEquals(ruleChainMetaData, ruleChainMetaData);
    int expectedHashCodeResult = ruleChainMetaData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainMetaData.hashCode());
  }

  /**
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(1L);
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setFirstNodeIndex(1);
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(new ArrayList<>());
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainMetaData2.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setRuleChainConnections(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setRuleChainId(mock(RuleChainId.class));
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act and Assert
    assertNotEquals(ruleChainMetaData, new RuleChainMetaData());
  }

  /**
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.setRuleChainConnections(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    RuleChainMetaData ruleChainMetaData2 = new RuleChainMetaData();
    ruleChainMetaData2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleChainMetaData, ruleChainMetaData2);
  }

  /**
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainMetaData(), null);
  }

  /**
   * Method under test: {@link RuleChainMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainMetaData(), "Different type to RuleChainMetaData");
  }

  /**
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
    RuleChainId ruleChainId = new RuleChainId(EntityId.NULL_UUID);
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
    assertEquals("RuleChainMetaData(ruleChainId=13814000-1dd2-11b2-8080-808080808080, version=1, firstNodeIndex=1,"
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
