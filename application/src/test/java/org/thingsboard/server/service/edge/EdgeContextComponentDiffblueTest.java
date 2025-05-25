package org.thingsboard.server.service.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EdgeContextComponentDiffblueTest {
  /**
   * Test {@link EdgeContextComponent#equals(Object)}, and {@link EdgeContextComponent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeContextComponent#equals(Object)}
   *   <li>{@link EdgeContextComponent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeContextComponent.equals(Object)", "int EdgeContextComponent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();

    // Act and Assert
    assertEquals(edgeContextComponent, edgeContextComponent2);
    int expectedHashCodeResult = edgeContextComponent.hashCode();
    assertEquals(expectedHashCodeResult, edgeContextComponent2.hashCode());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}, and {@link EdgeContextComponent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeContextComponent#equals(Object)}
   *   <li>{@link EdgeContextComponent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeContextComponent.equals(Object)", "int EdgeContextComponent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    // Act and Assert
    assertEquals(edgeContextComponent, edgeContextComponent);
    int expectedHashCodeResult = edgeContextComponent.hashCode();
    assertEquals(expectedHashCodeResult, edgeContextComponent.hashCode());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeContextComponent.equals(Object)", "int EdgeContextComponent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeContextComponent(), 1);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeContextComponent.equals(Object)", "int EdgeContextComponent.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeContextComponent(), null);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeContextComponent.equals(Object)", "int EdgeContextComponent.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeContextComponent(), "Different type to EdgeContextComponent");
  }
}
