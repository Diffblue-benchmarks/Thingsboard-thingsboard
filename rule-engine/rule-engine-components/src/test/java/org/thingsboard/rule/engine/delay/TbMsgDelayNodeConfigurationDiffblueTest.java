package org.thingsboard.rule.engine.delay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMsgDelayNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMsgDelayNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbMsgDelayNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsgDelayNodeConfiguration TbMsgDelayNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbMsgDelayNodeConfiguration actualDefaultConfigurationResult =
        new TbMsgDelayNodeConfiguration().defaultConfiguration();

    // Assert
    assertNull(actualDefaultConfigurationResult.getPeriodInSecondsPattern());
    assertEquals(1000, actualDefaultConfigurationResult.getMaxPendingMsgs());
    assertEquals(60, actualDefaultConfigurationResult.getPeriodInSeconds());
    assertFalse(actualDefaultConfigurationResult.isUseMetadataPeriodInSecondsPatterns());
  }

  /**
   * Test {@link TbMsgDelayNodeConfiguration#equals(Object)}, and {@link
   * TbMsgDelayNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgDelayNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgDelayNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgDelayNodeConfiguration.equals(Object)",
    "int TbMsgDelayNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgDelayNodeConfiguration tbMsgDelayNodeConfiguration = new TbMsgDelayNodeConfiguration();
    TbMsgDelayNodeConfiguration tbMsgDelayNodeConfiguration2 = new TbMsgDelayNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgDelayNodeConfiguration, tbMsgDelayNodeConfiguration2);
    int expectedHashCodeResult = tbMsgDelayNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgDelayNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgDelayNodeConfiguration#equals(Object)}, and {@link
   * TbMsgDelayNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgDelayNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgDelayNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgDelayNodeConfiguration.equals(Object)",
    "int TbMsgDelayNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMsgDelayNodeConfiguration tbMsgDelayNodeConfiguration = new TbMsgDelayNodeConfiguration();
    tbMsgDelayNodeConfiguration.setPeriodInSecondsPattern("Period In Seconds Pattern");

    TbMsgDelayNodeConfiguration tbMsgDelayNodeConfiguration2 = new TbMsgDelayNodeConfiguration();
    tbMsgDelayNodeConfiguration2.setPeriodInSecondsPattern("Period In Seconds Pattern");

    // Act and Assert
    assertEquals(tbMsgDelayNodeConfiguration, tbMsgDelayNodeConfiguration2);
    int expectedHashCodeResult = tbMsgDelayNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgDelayNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgDelayNodeConfiguration#equals(Object)}, and {@link
   * TbMsgDelayNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgDelayNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgDelayNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgDelayNodeConfiguration.equals(Object)",
    "int TbMsgDelayNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgDelayNodeConfiguration tbMsgDelayNodeConfiguration = new TbMsgDelayNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgDelayNodeConfiguration, tbMsgDelayNodeConfiguration);
    int expectedHashCodeResult = tbMsgDelayNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgDelayNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMsgDelayNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgDelayNodeConfiguration.equals(Object)",
    "int TbMsgDelayNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgDelayNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbMsgDelayNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgDelayNodeConfiguration.equals(Object)",
    "int TbMsgDelayNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgDelayNodeConfiguration tbMsgDelayNodeConfiguration = new TbMsgDelayNodeConfiguration();
    tbMsgDelayNodeConfiguration.setPeriodInSeconds(1);

    // Act and Assert
    assertNotEquals(tbMsgDelayNodeConfiguration, new TbMsgDelayNodeConfiguration());
  }

  /**
   * Test {@link TbMsgDelayNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgDelayNodeConfiguration.equals(Object)",
    "int TbMsgDelayNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMsgDelayNodeConfiguration tbMsgDelayNodeConfiguration = new TbMsgDelayNodeConfiguration();
    tbMsgDelayNodeConfiguration.setMaxPendingMsgs(3);

    // Act and Assert
    assertNotEquals(tbMsgDelayNodeConfiguration, new TbMsgDelayNodeConfiguration());
  }

  /**
   * Test {@link TbMsgDelayNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgDelayNodeConfiguration.equals(Object)",
    "int TbMsgDelayNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMsgDelayNodeConfiguration tbMsgDelayNodeConfiguration = new TbMsgDelayNodeConfiguration();
    tbMsgDelayNodeConfiguration.setPeriodInSecondsPattern("Period In Seconds Pattern");

    // Act and Assert
    assertNotEquals(tbMsgDelayNodeConfiguration, new TbMsgDelayNodeConfiguration());
  }

  /**
   * Test {@link TbMsgDelayNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgDelayNodeConfiguration.equals(Object)",
    "int TbMsgDelayNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbMsgDelayNodeConfiguration tbMsgDelayNodeConfiguration = new TbMsgDelayNodeConfiguration();
    tbMsgDelayNodeConfiguration.setUseMetadataPeriodInSecondsPatterns(true);

    // Act and Assert
    assertNotEquals(tbMsgDelayNodeConfiguration, new TbMsgDelayNodeConfiguration());
  }

  /**
   * Test {@link TbMsgDelayNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgDelayNodeConfiguration.equals(Object)",
    "int TbMsgDelayNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbMsgDelayNodeConfiguration tbMsgDelayNodeConfiguration = new TbMsgDelayNodeConfiguration();

    TbMsgDelayNodeConfiguration tbMsgDelayNodeConfiguration2 = new TbMsgDelayNodeConfiguration();
    tbMsgDelayNodeConfiguration2.setPeriodInSecondsPattern("Period In Seconds Pattern");

    // Act and Assert
    assertNotEquals(tbMsgDelayNodeConfiguration, tbMsgDelayNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgDelayNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgDelayNodeConfiguration.equals(Object)",
    "int TbMsgDelayNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgDelayNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMsgDelayNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgDelayNodeConfiguration.equals(Object)",
    "int TbMsgDelayNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbMsgDelayNodeConfiguration(), "Different type to TbMsgDelayNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgDelayNodeConfiguration}
   *   <li>{@link TbMsgDelayNodeConfiguration#setMaxPendingMsgs(int)}
   *   <li>{@link TbMsgDelayNodeConfiguration#setPeriodInSeconds(int)}
   *   <li>{@link TbMsgDelayNodeConfiguration#setPeriodInSecondsPattern(String)}
   *   <li>{@link TbMsgDelayNodeConfiguration#setUseMetadataPeriodInSecondsPatterns(boolean)}
   *   <li>{@link TbMsgDelayNodeConfiguration#toString()}
   *   <li>{@link TbMsgDelayNodeConfiguration#getMaxPendingMsgs()}
   *   <li>{@link TbMsgDelayNodeConfiguration#getPeriodInSeconds()}
   *   <li>{@link TbMsgDelayNodeConfiguration#getPeriodInSecondsPattern()}
   *   <li>{@link TbMsgDelayNodeConfiguration#isUseMetadataPeriodInSecondsPatterns()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbMsgDelayNodeConfiguration.<init>()",
    "int TbMsgDelayNodeConfiguration.getMaxPendingMsgs()",
    "int TbMsgDelayNodeConfiguration.getPeriodInSeconds()",
    "String TbMsgDelayNodeConfiguration.getPeriodInSecondsPattern()",
    "boolean TbMsgDelayNodeConfiguration.isUseMetadataPeriodInSecondsPatterns()",
    "void TbMsgDelayNodeConfiguration.setMaxPendingMsgs(int)",
    "void TbMsgDelayNodeConfiguration.setPeriodInSeconds(int)",
    "void TbMsgDelayNodeConfiguration.setPeriodInSecondsPattern(String)",
    "void TbMsgDelayNodeConfiguration.setUseMetadataPeriodInSecondsPatterns(boolean)",
    "String TbMsgDelayNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgDelayNodeConfiguration actualTbMsgDelayNodeConfiguration =
        new TbMsgDelayNodeConfiguration();
    actualTbMsgDelayNodeConfiguration.setMaxPendingMsgs(3);
    actualTbMsgDelayNodeConfiguration.setPeriodInSeconds(1);
    actualTbMsgDelayNodeConfiguration.setPeriodInSecondsPattern("Period In Seconds Pattern");
    actualTbMsgDelayNodeConfiguration.setUseMetadataPeriodInSecondsPatterns(true);
    String actualToStringResult = actualTbMsgDelayNodeConfiguration.toString();
    int actualMaxPendingMsgs = actualTbMsgDelayNodeConfiguration.getMaxPendingMsgs();
    int actualPeriodInSeconds = actualTbMsgDelayNodeConfiguration.getPeriodInSeconds();
    String actualPeriodInSecondsPattern =
        actualTbMsgDelayNodeConfiguration.getPeriodInSecondsPattern();

    // Assert
    assertEquals("Period In Seconds Pattern", actualPeriodInSecondsPattern);
    assertEquals(
        "TbMsgDelayNodeConfiguration(periodInSeconds=1, maxPendingMsgs=3, periodInSecondsPattern=Period In"
            + " Seconds Pattern, useMetadataPeriodInSecondsPatterns=true)",
        actualToStringResult);
    assertEquals(1, actualPeriodInSeconds);
    assertEquals(3, actualMaxPendingMsgs);
    assertTrue(actualTbMsgDelayNodeConfiguration.isUseMetadataPeriodInSecondsPatterns());
  }
}
