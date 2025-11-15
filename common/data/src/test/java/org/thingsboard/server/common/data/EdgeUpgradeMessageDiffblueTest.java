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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EdgeUpgradeMessageDiffblueTest {
  /**
   * Test {@link EdgeUpgradeMessage#equals(Object)}, and {@link EdgeUpgradeMessage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeUpgradeMessage#equals(Object)}
   *   <li>{@link EdgeUpgradeMessage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeUpgradeMessage.equals(Object)", "int EdgeUpgradeMessage.hashCode()"})
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
   * Test {@link EdgeUpgradeMessage#equals(Object)}, and {@link EdgeUpgradeMessage#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeUpgradeMessage#equals(Object)}
   *   <li>{@link EdgeUpgradeMessage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeUpgradeMessage.equals(Object)", "int EdgeUpgradeMessage.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeUpgradeMessage edgeUpgradeMessage = new EdgeUpgradeMessage(new HashMap<>());

    // Act and Assert
    assertEquals(edgeUpgradeMessage, edgeUpgradeMessage);
    int expectedHashCodeResult = edgeUpgradeMessage.hashCode();
    assertEquals(expectedHashCodeResult, edgeUpgradeMessage.hashCode());
  }

  /**
   * Test {@link EdgeUpgradeMessage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpgradeMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeUpgradeMessage.equals(Object)", "int EdgeUpgradeMessage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<String, EdgeUpgradeInfo> edgeVersions = new HashMap<>();
    edgeVersions.put("foo", new EdgeUpgradeInfo(true, "1.0.2"));
    EdgeUpgradeMessage edgeUpgradeMessage = new EdgeUpgradeMessage(edgeVersions);

    // Act and Assert
    assertNotEquals(edgeUpgradeMessage, new EdgeUpgradeMessage(new HashMap<>()));
  }

  /**
   * Test {@link EdgeUpgradeMessage#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpgradeMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeUpgradeMessage.equals(Object)", "int EdgeUpgradeMessage.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeUpgradeMessage(new HashMap<>()), null);
  }

  /**
   * Test {@link EdgeUpgradeMessage#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpgradeMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeUpgradeMessage.equals(Object)", "int EdgeUpgradeMessage.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeUpgradeMessage(new HashMap<>()), "Different type to EdgeUpgradeMessage");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeUpgradeMessage#EdgeUpgradeMessage(Map)}
   *   <li>{@link EdgeUpgradeMessage#toString()}
   *   <li>{@link EdgeUpgradeMessage#getEdgeVersions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeUpgradeMessage.<init>(Map)", "Map EdgeUpgradeMessage.getEdgeVersions()",
      "String EdgeUpgradeMessage.toString()"})
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
