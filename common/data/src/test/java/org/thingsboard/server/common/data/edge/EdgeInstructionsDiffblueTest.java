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
package org.thingsboard.server.common.data.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class EdgeInstructionsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInstructions#equals(Object)}
   *   <li>{@link EdgeInstructions#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeInstructions edgeInstructions = new EdgeInstructions("Instructions");
    EdgeInstructions edgeInstructions2 = new EdgeInstructions("Instructions");

    // Act and Assert
    assertEquals(edgeInstructions, edgeInstructions2);
    int expectedHashCodeResult = edgeInstructions.hashCode();
    assertEquals(expectedHashCodeResult, edgeInstructions2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInstructions#equals(Object)}
   *   <li>{@link EdgeInstructions#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeInstructions edgeInstructions = new EdgeInstructions(null);
    EdgeInstructions edgeInstructions2 = new EdgeInstructions(null);

    // Act and Assert
    assertEquals(edgeInstructions, edgeInstructions2);
    int expectedHashCodeResult = edgeInstructions.hashCode();
    assertEquals(expectedHashCodeResult, edgeInstructions2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInstructions#equals(Object)}
   *   <li>{@link EdgeInstructions#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeInstructions edgeInstructions = new EdgeInstructions("Instructions");

    // Act and Assert
    assertEquals(edgeInstructions, edgeInstructions);
    int expectedHashCodeResult = edgeInstructions.hashCode();
    assertEquals(expectedHashCodeResult, edgeInstructions.hashCode());
  }

  /**
   * Method under test: {@link EdgeInstructions#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeInstructions edgeInstructions = new EdgeInstructions(null);

    // Act and Assert
    assertNotEquals(edgeInstructions, new EdgeInstructions("Instructions"));
  }

  /**
   * Method under test: {@link EdgeInstructions#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeInstructions edgeInstructions = new EdgeInstructions(
        "org.thingsboard.server.common.data.edge.EdgeInstructions");

    // Act and Assert
    assertNotEquals(edgeInstructions, new EdgeInstructions("Instructions"));
  }

  /**
   * Method under test: {@link EdgeInstructions#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeInstructions("Instructions"), null);
  }

  /**
   * Method under test: {@link EdgeInstructions#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeInstructions("Instructions"), "Different type to EdgeInstructions");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInstructions#EdgeInstructions()}
   *   <li>{@link EdgeInstructions#setInstructions(String)}
   *   <li>{@link EdgeInstructions#toString()}
   *   <li>{@link EdgeInstructions#getInstructions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeInstructions actualEdgeInstructions = new EdgeInstructions();
    actualEdgeInstructions.setInstructions("Instructions");
    String actualToStringResult = actualEdgeInstructions.toString();

    // Assert that nothing has changed
    assertEquals("EdgeInstructions(instructions=Instructions)", actualToStringResult);
    assertEquals("Instructions", actualEdgeInstructions.getInstructions());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInstructions#EdgeInstructions(String)}
   *   <li>{@link EdgeInstructions#setInstructions(String)}
   *   <li>{@link EdgeInstructions#toString()}
   *   <li>{@link EdgeInstructions#getInstructions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    EdgeInstructions actualEdgeInstructions = new EdgeInstructions("Instructions");
    actualEdgeInstructions.setInstructions("Instructions");
    String actualToStringResult = actualEdgeInstructions.toString();

    // Assert that nothing has changed
    assertEquals("EdgeInstructions(instructions=Instructions)", actualToStringResult);
    assertEquals("Instructions", actualEdgeInstructions.getInstructions());
  }
}
