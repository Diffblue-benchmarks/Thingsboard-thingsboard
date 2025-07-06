package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMsgPushToEdgeNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMsgPushToEdgeNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsgPushToEdgeNodeConfiguration TbMsgPushToEdgeNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange, Act and Assert
    assertEquals(
        "SERVER_SCOPE", new TbMsgPushToEdgeNodeConfiguration().defaultConfiguration().getScope());
  }

  /**
   * Test {@link TbMsgPushToEdgeNodeConfiguration#equals(Object)}, and {@link
   * TbMsgPushToEdgeNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgPushToEdgeNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgPushToEdgeNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgPushToEdgeNodeConfiguration.equals(Object)",
    "int TbMsgPushToEdgeNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgPushToEdgeNodeConfiguration tbMsgPushToEdgeNodeConfiguration =
        new TbMsgPushToEdgeNodeConfiguration();
    TbMsgPushToEdgeNodeConfiguration tbMsgPushToEdgeNodeConfiguration2 =
        new TbMsgPushToEdgeNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgPushToEdgeNodeConfiguration, tbMsgPushToEdgeNodeConfiguration2);
    int expectedHashCodeResult = tbMsgPushToEdgeNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgPushToEdgeNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgPushToEdgeNodeConfiguration#equals(Object)}, and {@link
   * TbMsgPushToEdgeNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgPushToEdgeNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgPushToEdgeNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgPushToEdgeNodeConfiguration.equals(Object)",
    "int TbMsgPushToEdgeNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgPushToEdgeNodeConfiguration tbMsgPushToEdgeNodeConfiguration =
        new TbMsgPushToEdgeNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgPushToEdgeNodeConfiguration, tbMsgPushToEdgeNodeConfiguration);
    int expectedHashCodeResult = tbMsgPushToEdgeNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgPushToEdgeNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMsgPushToEdgeNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgPushToEdgeNodeConfiguration.equals(Object)",
    "int TbMsgPushToEdgeNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgPushToEdgeNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbMsgPushToEdgeNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgPushToEdgeNodeConfiguration.equals(Object)",
    "int TbMsgPushToEdgeNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgPushToEdgeNodeConfiguration tbMsgPushToEdgeNodeConfiguration =
        new TbMsgPushToEdgeNodeConfiguration();
    tbMsgPushToEdgeNodeConfiguration.setScope("Scope");

    // Act and Assert
    assertNotEquals(tbMsgPushToEdgeNodeConfiguration, new TbMsgPushToEdgeNodeConfiguration());
  }

  /**
   * Test {@link TbMsgPushToEdgeNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgPushToEdgeNodeConfiguration.equals(Object)",
    "int TbMsgPushToEdgeNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgPushToEdgeNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMsgPushToEdgeNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgPushToEdgeNodeConfiguration.equals(Object)",
    "int TbMsgPushToEdgeNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbMsgPushToEdgeNodeConfiguration(),
        "Different type to TbMsgPushToEdgeNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgPushToEdgeNodeConfiguration}
   *   <li>{@link TbMsgPushToEdgeNodeConfiguration#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbMsgPushToEdgeNodeConfiguration.<init>()",
    "java.lang.String TbMsgPushToEdgeNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgPushToEdgeNodeConfiguration actualTbMsgPushToEdgeNodeConfiguration =
        new TbMsgPushToEdgeNodeConfiguration();

    // Assert
    assertEquals(
        "TbMsgPushToEdgeNodeConfiguration()", actualTbMsgPushToEdgeNodeConfiguration.toString());
    assertNull(actualTbMsgPushToEdgeNodeConfiguration.getScope());
  }
}
