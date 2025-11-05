package org.thingsboard.server.common.data.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NodeConnectionInfoDiffblueTest {
  /**
   * Test {@link NodeConnectionInfo#equals(Object)}, and {@link NodeConnectionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeConnectionInfo#equals(Object)}
   *   <li>{@link NodeConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NodeConnectionInfo.equals(Object)",
    "int NodeConnectionInfo.hashCode()"
  })
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
    assertEquals(nodeConnectionInfo.hashCode(), nodeConnectionInfo2.hashCode());
  }

  /**
   * Test {@link NodeConnectionInfo#equals(Object)}, and {@link NodeConnectionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeConnectionInfo#equals(Object)}
   *   <li>{@link NodeConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NodeConnectionInfo.equals(Object)",
    "int NodeConnectionInfo.hashCode()"
  })
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
    assertEquals(nodeConnectionInfo.hashCode(), nodeConnectionInfo2.hashCode());
  }

  /**
   * Test {@link NodeConnectionInfo#equals(Object)}, and {@link NodeConnectionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeConnectionInfo#equals(Object)}
   *   <li>{@link NodeConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NodeConnectionInfo.equals(Object)",
    "int NodeConnectionInfo.hashCode()"
  })
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
   * Test {@link NodeConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NodeConnectionInfo.equals(Object)",
    "int NodeConnectionInfo.hashCode()"
  })
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
   * Test {@link NodeConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NodeConnectionInfo.equals(Object)",
    "int NodeConnectionInfo.hashCode()"
  })
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
   * Test {@link NodeConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NodeConnectionInfo.equals(Object)",
    "int NodeConnectionInfo.hashCode()"
  })
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
   * Test {@link NodeConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NodeConnectionInfo.equals(Object)",
    "int NodeConnectionInfo.hashCode()"
  })
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
   * Test {@link NodeConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NodeConnectionInfo.equals(Object)",
    "int NodeConnectionInfo.hashCode()"
  })
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
   * Test {@link NodeConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NodeConnectionInfo.equals(Object)",
    "int NodeConnectionInfo.hashCode()"
  })
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NodeConnectionInfo.<init>()",
    "int NodeConnectionInfo.getFromIndex()",
    "int NodeConnectionInfo.getToIndex()",
    "String NodeConnectionInfo.getType()",
    "void NodeConnectionInfo.setFromIndex(int)",
    "void NodeConnectionInfo.setToIndex(int)",
    "void NodeConnectionInfo.setType(String)",
    "String NodeConnectionInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NodeConnectionInfo actualNodeConnectionInfo = new NodeConnectionInfo();
    actualNodeConnectionInfo.setFromIndex(1);
    actualNodeConnectionInfo.setToIndex(1);
    actualNodeConnectionInfo.setType("Type");
    String actualToStringResult = actualNodeConnectionInfo.toString();
    int actualFromIndex = actualNodeConnectionInfo.getFromIndex();
    int actualToIndex = actualNodeConnectionInfo.getToIndex();

    // Assert
    assertEquals("NodeConnectionInfo(fromIndex=1, toIndex=1, type=Type)", actualToStringResult);
    assertEquals("Type", actualNodeConnectionInfo.getType());
    assertEquals(1, actualFromIndex);
    assertEquals(1, actualToIndex);
  }
}
