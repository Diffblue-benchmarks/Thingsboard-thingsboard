package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EdgeUpgradeMessageDiffblueTest {
  /**
   * Test {@link EdgeUpgradeMessage#equals(Object)}, and
   * {@link EdgeUpgradeMessage#hashCode()}.
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
   * Test {@link EdgeUpgradeMessage#equals(Object)}, and
   * {@link EdgeUpgradeMessage#hashCode()}.
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
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpgradeMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
