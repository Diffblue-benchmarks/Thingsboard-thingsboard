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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class EdgeUpgradeMessageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeUpgradeMessage#equals(Object)}
   *   <li>{@link EdgeUpgradeMessage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeUpgradeMessage edgeUpgradeMessage = new EdgeUpgradeMessage(new HashMap<>());
    EdgeUpgradeMessage edgeUpgradeMessage2 = new EdgeUpgradeMessage(new HashMap<>());

    // Act and Assert
    assertEquals(edgeUpgradeMessage, edgeUpgradeMessage2);
    int expectedHashCodeResult = edgeUpgradeMessage.hashCode();
    assertEquals(expectedHashCodeResult, edgeUpgradeMessage2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeUpgradeMessage#equals(Object)}
   *   <li>{@link EdgeUpgradeMessage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeUpgradeMessage edgeUpgradeMessage = new EdgeUpgradeMessage(new HashMap<>());

    // Act and Assert
    assertEquals(edgeUpgradeMessage, edgeUpgradeMessage);
    int expectedHashCodeResult = edgeUpgradeMessage.hashCode();
    assertEquals(expectedHashCodeResult, edgeUpgradeMessage.hashCode());
  }

  /**
   * Method under test: {@link EdgeUpgradeMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<String, EdgeUpgradeInfo> edgeVersions = new HashMap<>();
    edgeVersions.put("foo", new EdgeUpgradeInfo(true, "1.0.2"));
    EdgeUpgradeMessage edgeUpgradeMessage = new EdgeUpgradeMessage(edgeVersions);

    // Act and Assert
    assertNotEquals(edgeUpgradeMessage, new EdgeUpgradeMessage(new HashMap<>()));
  }

  /**
   * Method under test: {@link EdgeUpgradeMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<String, EdgeUpgradeInfo> edgeVersions = new HashMap<>();
    edgeVersions.computeIfPresent("foo", mock(BiFunction.class));
    edgeVersions.put("foo", new EdgeUpgradeInfo(true, "1.0.2"));
    EdgeUpgradeMessage edgeUpgradeMessage = new EdgeUpgradeMessage(edgeVersions);

    // Act and Assert
    assertNotEquals(edgeUpgradeMessage, new EdgeUpgradeMessage(new HashMap<>()));
  }

  /**
   * Method under test: {@link EdgeUpgradeMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeUpgradeMessage(new HashMap<>()), null);
  }

  /**
   * Method under test: {@link EdgeUpgradeMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeUpgradeMessage(new HashMap<>()), "Different type to EdgeUpgradeMessage");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeUpgradeMessage#EdgeUpgradeMessage(Map)}
   *   <li>{@link EdgeUpgradeMessage#toString()}
   *   <li>{@link EdgeUpgradeMessage#getEdgeVersions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    HashMap<String, EdgeUpgradeInfo> edgeVersions = new HashMap<>();

    // Act
    EdgeUpgradeMessage actualEdgeUpgradeMessage = new EdgeUpgradeMessage(edgeVersions);
    String actualToStringResult = actualEdgeUpgradeMessage.toString();
    Map<String, EdgeUpgradeInfo> actualEdgeVersions = actualEdgeUpgradeMessage.getEdgeVersions();

    // Assert
    assertEquals("EdgeUpgradeMessage(edgeVersions={})", actualToStringResult);
    assertTrue(actualEdgeVersions.isEmpty());
    assertSame(edgeVersions, actualEdgeVersions);
  }
}
