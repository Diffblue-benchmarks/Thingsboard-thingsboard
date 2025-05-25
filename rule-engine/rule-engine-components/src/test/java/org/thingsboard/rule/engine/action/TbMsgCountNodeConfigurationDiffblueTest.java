package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMsgCountNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMsgCountNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test: {@link TbMsgCountNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgCountNodeConfiguration TbMsgCountNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration() {
    // Arrange and Act
    TbMsgCountNodeConfiguration actualDefaultConfigurationResult = (new TbMsgCountNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertEquals("messageCount", actualDefaultConfigurationResult.getTelemetryPrefix());
    assertEquals(1, actualDefaultConfigurationResult.getInterval());
  }

  /**
   * Test {@link TbMsgCountNodeConfiguration#equals(Object)}, and {@link TbMsgCountNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgCountNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgCountNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgCountNodeConfiguration.equals(Object)",
      "int TbMsgCountNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgCountNodeConfiguration tbMsgCountNodeConfiguration = new TbMsgCountNodeConfiguration();
    TbMsgCountNodeConfiguration tbMsgCountNodeConfiguration2 = new TbMsgCountNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgCountNodeConfiguration, tbMsgCountNodeConfiguration2);
    int expectedHashCodeResult = tbMsgCountNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgCountNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgCountNodeConfiguration#equals(Object)}, and {@link TbMsgCountNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgCountNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgCountNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgCountNodeConfiguration.equals(Object)",
      "int TbMsgCountNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMsgCountNodeConfiguration tbMsgCountNodeConfiguration = new TbMsgCountNodeConfiguration();
    tbMsgCountNodeConfiguration.setTelemetryPrefix("Telemetry Prefix");

    TbMsgCountNodeConfiguration tbMsgCountNodeConfiguration2 = new TbMsgCountNodeConfiguration();
    tbMsgCountNodeConfiguration2.setTelemetryPrefix("Telemetry Prefix");

    // Act and Assert
    assertEquals(tbMsgCountNodeConfiguration, tbMsgCountNodeConfiguration2);
    int expectedHashCodeResult = tbMsgCountNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgCountNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgCountNodeConfiguration#equals(Object)}, and {@link TbMsgCountNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgCountNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgCountNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgCountNodeConfiguration.equals(Object)",
      "int TbMsgCountNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgCountNodeConfiguration tbMsgCountNodeConfiguration = new TbMsgCountNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgCountNodeConfiguration, tbMsgCountNodeConfiguration);
    int expectedHashCodeResult = tbMsgCountNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgCountNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMsgCountNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgCountNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgCountNodeConfiguration.equals(Object)",
      "int TbMsgCountNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgCountNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbMsgCountNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgCountNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgCountNodeConfiguration.equals(Object)",
      "int TbMsgCountNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgCountNodeConfiguration tbMsgCountNodeConfiguration = new TbMsgCountNodeConfiguration();
    tbMsgCountNodeConfiguration.setTelemetryPrefix("Telemetry Prefix");

    // Act and Assert
    assertNotEquals(tbMsgCountNodeConfiguration, new TbMsgCountNodeConfiguration());
  }

  /**
   * Test {@link TbMsgCountNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgCountNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgCountNodeConfiguration.equals(Object)",
      "int TbMsgCountNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMsgCountNodeConfiguration tbMsgCountNodeConfiguration = new TbMsgCountNodeConfiguration();
    tbMsgCountNodeConfiguration.setInterval(42);

    // Act and Assert
    assertNotEquals(tbMsgCountNodeConfiguration, new TbMsgCountNodeConfiguration());
  }

  /**
   * Test {@link TbMsgCountNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgCountNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgCountNodeConfiguration.equals(Object)",
      "int TbMsgCountNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMsgCountNodeConfiguration tbMsgCountNodeConfiguration = new TbMsgCountNodeConfiguration();

    TbMsgCountNodeConfiguration tbMsgCountNodeConfiguration2 = new TbMsgCountNodeConfiguration();
    tbMsgCountNodeConfiguration2.setTelemetryPrefix("Telemetry Prefix");

    // Act and Assert
    assertNotEquals(tbMsgCountNodeConfiguration, tbMsgCountNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgCountNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgCountNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgCountNodeConfiguration.equals(Object)",
      "int TbMsgCountNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgCountNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMsgCountNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgCountNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgCountNodeConfiguration.equals(Object)",
      "int TbMsgCountNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgCountNodeConfiguration(), "Different type to TbMsgCountNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgCountNodeConfiguration}
   *   <li>{@link TbMsgCountNodeConfiguration#setInterval(int)}
   *   <li>{@link TbMsgCountNodeConfiguration#setTelemetryPrefix(String)}
   *   <li>{@link TbMsgCountNodeConfiguration#toString()}
   *   <li>{@link TbMsgCountNodeConfiguration#getInterval()}
   *   <li>{@link TbMsgCountNodeConfiguration#getTelemetryPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMsgCountNodeConfiguration.<init>()", "int TbMsgCountNodeConfiguration.getInterval()",
      "String TbMsgCountNodeConfiguration.getTelemetryPrefix()", "void TbMsgCountNodeConfiguration.setInterval(int)",
      "void TbMsgCountNodeConfiguration.setTelemetryPrefix(String)", "String TbMsgCountNodeConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgCountNodeConfiguration actualTbMsgCountNodeConfiguration = new TbMsgCountNodeConfiguration();
    actualTbMsgCountNodeConfiguration.setInterval(42);
    actualTbMsgCountNodeConfiguration.setTelemetryPrefix("Telemetry Prefix");
    String actualToStringResult = actualTbMsgCountNodeConfiguration.toString();
    int actualInterval = actualTbMsgCountNodeConfiguration.getInterval();

    // Assert
    assertEquals("TbMsgCountNodeConfiguration(telemetryPrefix=Telemetry Prefix, interval=42)", actualToStringResult);
    assertEquals("Telemetry Prefix", actualTbMsgCountNodeConfiguration.getTelemetryPrefix());
    assertEquals(42, actualInterval);
  }
}
