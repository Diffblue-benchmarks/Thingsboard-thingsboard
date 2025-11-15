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
import org.junit.jupiter.api.Test;

class NodeConnectionInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeConnectionInfo#equals(Object)}
   *   <li>{@link NodeConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    NodeConnectionInfo nodeConnectionInfo2 = new NodeConnectionInfo();
    nodeConnectionInfo2.setFromIndex(1);
    nodeConnectionInfo2.setToIndex(1);
    nodeConnectionInfo2.setType("Type");

    // Act and Assert
    assertEquals(nodeConnectionInfo, nodeConnectionInfo2);
    int expectedHashCodeResult = nodeConnectionInfo.hashCode();
    assertEquals(expectedHashCodeResult, nodeConnectionInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeConnectionInfo#equals(Object)}
   *   <li>{@link NodeConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType(null);

    NodeConnectionInfo nodeConnectionInfo2 = new NodeConnectionInfo();
    nodeConnectionInfo2.setFromIndex(1);
    nodeConnectionInfo2.setToIndex(1);
    nodeConnectionInfo2.setType(null);

    // Act and Assert
    assertEquals(nodeConnectionInfo, nodeConnectionInfo2);
    int expectedHashCodeResult = nodeConnectionInfo.hashCode();
    assertEquals(expectedHashCodeResult, nodeConnectionInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeConnectionInfo#equals(Object)}
   *   <li>{@link NodeConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    // Act and Assert
    assertEquals(nodeConnectionInfo, nodeConnectionInfo);
    int expectedHashCodeResult = nodeConnectionInfo.hashCode();
    assertEquals(expectedHashCodeResult, nodeConnectionInfo.hashCode());
  }

  /**
   * Method under test: {@link NodeConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(3);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    NodeConnectionInfo nodeConnectionInfo2 = new NodeConnectionInfo();
    nodeConnectionInfo2.setFromIndex(1);
    nodeConnectionInfo2.setToIndex(1);
    nodeConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(nodeConnectionInfo, nodeConnectionInfo2);
  }

  /**
   * Method under test: {@link NodeConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(3);
    nodeConnectionInfo.setType("Type");

    NodeConnectionInfo nodeConnectionInfo2 = new NodeConnectionInfo();
    nodeConnectionInfo2.setFromIndex(1);
    nodeConnectionInfo2.setToIndex(1);
    nodeConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(nodeConnectionInfo, nodeConnectionInfo2);
  }

  /**
   * Method under test: {@link NodeConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType(null);

    NodeConnectionInfo nodeConnectionInfo2 = new NodeConnectionInfo();
    nodeConnectionInfo2.setFromIndex(1);
    nodeConnectionInfo2.setToIndex(1);
    nodeConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(nodeConnectionInfo, nodeConnectionInfo2);
  }

  /**
   * Method under test: {@link NodeConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("org.thingsboard.server.common.data.rule.NodeConnectionInfo");

    NodeConnectionInfo nodeConnectionInfo2 = new NodeConnectionInfo();
    nodeConnectionInfo2.setFromIndex(1);
    nodeConnectionInfo2.setToIndex(1);
    nodeConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(nodeConnectionInfo, nodeConnectionInfo2);
  }

  /**
   * Method under test: {@link NodeConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    // Act and Assert
    assertNotEquals(nodeConnectionInfo, null);
  }

  /**
   * Method under test: {@link NodeConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    // Act and Assert
    assertNotEquals(nodeConnectionInfo, "Different type to NodeConnectionInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NodeConnectionInfo}
   *   <li>{@link NodeConnectionInfo#setFromIndex(int)}
   *   <li>{@link NodeConnectionInfo#setToIndex(int)}
   *   <li>{@link NodeConnectionInfo#setType(String)}
   *   <li>{@link NodeConnectionInfo#toString()}
   *   <li>{@link NodeConnectionInfo#getFromIndex()}
   *   <li>{@link NodeConnectionInfo#getToIndex()}
   *   <li>{@link NodeConnectionInfo#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NodeConnectionInfo actualNodeConnectionInfo = new NodeConnectionInfo();
    actualNodeConnectionInfo.setFromIndex(1);
    actualNodeConnectionInfo.setToIndex(1);
    actualNodeConnectionInfo.setType("Type");
    String actualToStringResult = actualNodeConnectionInfo.toString();
    int actualFromIndex = actualNodeConnectionInfo.getFromIndex();
    int actualToIndex = actualNodeConnectionInfo.getToIndex();

    // Assert that nothing has changed
    assertEquals("NodeConnectionInfo(fromIndex=1, toIndex=1, type=Type)", actualToStringResult);
    assertEquals("Type", actualNodeConnectionInfo.getType());
    assertEquals(1, actualFromIndex);
    assertEquals(1, actualToIndex);
  }
}
