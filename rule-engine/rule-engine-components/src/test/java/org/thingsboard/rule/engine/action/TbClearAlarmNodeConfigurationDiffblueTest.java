package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbClearAlarmNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbClearAlarmNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbClearAlarmNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbClearAlarmNodeConfiguration TbClearAlarmNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration =
        new TbClearAlarmNodeConfiguration();

    // Act and Assert
    assertEquals(
        tbClearAlarmNodeConfiguration, tbClearAlarmNodeConfiguration.defaultConfiguration());
  }

  /**
   * Test {@link TbClearAlarmNodeConfiguration#equals(Object)}, and {@link
   * TbClearAlarmNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbClearAlarmNodeConfiguration#equals(Object)}
   *   <li>{@link TbClearAlarmNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbClearAlarmNodeConfiguration.equals(Object)",
    "int TbClearAlarmNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration =
        new TbClearAlarmNodeConfiguration();
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration2 =
        new TbClearAlarmNodeConfiguration();

    // Act and Assert
    assertEquals(tbClearAlarmNodeConfiguration, tbClearAlarmNodeConfiguration2);
    int expectedHashCodeResult = tbClearAlarmNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbClearAlarmNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbClearAlarmNodeConfiguration#equals(Object)}, and {@link
   * TbClearAlarmNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbClearAlarmNodeConfiguration#equals(Object)}
   *   <li>{@link TbClearAlarmNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbClearAlarmNodeConfiguration.equals(Object)",
    "int TbClearAlarmNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration =
        new TbClearAlarmNodeConfiguration();

    // Act and Assert
    assertEquals(tbClearAlarmNodeConfiguration, tbClearAlarmNodeConfiguration);
    int expectedHashCodeResult = tbClearAlarmNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbClearAlarmNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbClearAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbClearAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbClearAlarmNodeConfiguration.equals(Object)",
    "int TbClearAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbClearAlarmNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbClearAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbClearAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbClearAlarmNodeConfiguration.equals(Object)",
    "int TbClearAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbClearAlarmNodeConfiguration(), null);
  }

  /**
   * Test {@link TbClearAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbClearAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbClearAlarmNodeConfiguration.equals(Object)",
    "int TbClearAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbClearAlarmNodeConfiguration(), "Different type to TbClearAlarmNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbClearAlarmNodeConfiguration}
   *   <li>{@link TbClearAlarmNodeConfiguration#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbClearAlarmNodeConfiguration.<init>()",
    "java.lang.String TbClearAlarmNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbClearAlarmNodeConfiguration actualTbClearAlarmNodeConfiguration =
        new TbClearAlarmNodeConfiguration();

    // Assert
    assertEquals("TbClearAlarmNodeConfiguration()", actualTbClearAlarmNodeConfiguration.toString());
    assertNull(actualTbClearAlarmNodeConfiguration.getAlarmDetailsBuildJs());
    assertNull(actualTbClearAlarmNodeConfiguration.getAlarmDetailsBuildTbel());
    assertNull(actualTbClearAlarmNodeConfiguration.getAlarmType());
    assertNull(actualTbClearAlarmNodeConfiguration.getScriptLang());
  }
}
