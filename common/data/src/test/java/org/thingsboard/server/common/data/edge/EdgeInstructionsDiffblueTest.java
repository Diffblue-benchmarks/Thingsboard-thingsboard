package org.thingsboard.server.common.data.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EdgeInstructionsDiffblueTest {
  /**
   * Test {@link EdgeInstructions#equals(Object)}, and
   * {@link EdgeInstructions#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInstructions#equals(Object)}
   *   <li>{@link EdgeInstructions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link EdgeInstructions#equals(Object)}, and
   * {@link EdgeInstructions#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInstructions#equals(Object)}
   *   <li>{@link EdgeInstructions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link EdgeInstructions#equals(Object)}, and
   * {@link EdgeInstructions#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInstructions#equals(Object)}
   *   <li>{@link EdgeInstructions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeInstructions edgeInstructions = new EdgeInstructions("Instructions");

    // Act and Assert
    assertEquals(edgeInstructions, edgeInstructions);
    int expectedHashCodeResult = edgeInstructions.hashCode();
    assertEquals(expectedHashCodeResult, edgeInstructions.hashCode());
  }

  /**
   * Test {@link EdgeInstructions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInstructions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeInstructions edgeInstructions = new EdgeInstructions(null);

    // Act and Assert
    assertNotEquals(edgeInstructions, new EdgeInstructions("Instructions"));
  }

  /**
   * Test {@link EdgeInstructions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInstructions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeInstructions edgeInstructions = new EdgeInstructions(
        "org.thingsboard.server.common.data.edge.EdgeInstructions");

    // Act and Assert
    assertNotEquals(edgeInstructions, new EdgeInstructions("Instructions"));
  }

  /**
   * Test {@link EdgeInstructions#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInstructions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeInstructions("Instructions"), null);
  }

  /**
   * Test {@link EdgeInstructions#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInstructions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeInstructions("Instructions"), "Different type to EdgeInstructions");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInstructions#EdgeInstructions()}
   *   <li>{@link EdgeInstructions#setInstructions(String)}
   *   <li>{@link EdgeInstructions#toString()}
   *   <li>{@link EdgeInstructions#getInstructions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Instructions}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInstructions#EdgeInstructions(String)}
   *   <li>{@link EdgeInstructions#setInstructions(String)}
   *   <li>{@link EdgeInstructions#toString()}
   *   <li>{@link EdgeInstructions#getInstructions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Instructions'")
  void testGettersAndSetters_whenInstructions() {
    // Arrange and Act
    EdgeInstructions actualEdgeInstructions = new EdgeInstructions("Instructions");
    actualEdgeInstructions.setInstructions("Instructions");
    String actualToStringResult = actualEdgeInstructions.toString();

    // Assert that nothing has changed
    assertEquals("EdgeInstructions(instructions=Instructions)", actualToStringResult);
    assertEquals("Instructions", actualEdgeInstructions.getInstructions());
  }
}
