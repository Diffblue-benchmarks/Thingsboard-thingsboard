package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.common.msg.TbMsg;

class TbAbstractAlarmNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#canEqual(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbAbstractAlarmNodeConfiguration.canEqual(Object)"})
  void testCanEqual_thenReturnFalse() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration =
        new TbClearAlarmNodeConfiguration();
    TbMsg telemetryMsgResult =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertFalse(tbClearAlarmNodeConfiguration.canEqual(telemetryMsgResult));
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link TbClearAlarmNodeConfiguration} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when TbClearAlarmNodeConfiguration (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbAbstractAlarmNodeConfiguration.canEqual(Object)"})
  void testCanEqual_whenTbClearAlarmNodeConfiguration_thenReturnTrue() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration =
        new TbClearAlarmNodeConfiguration();

    // Act and Assert
    assertTrue(tbClearAlarmNodeConfiguration.canEqual(new TbClearAlarmNodeConfiguration()));
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#equals(Object)}, and {@link
   * TbAbstractAlarmNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractAlarmNodeConfiguration.equals(Object)",
    "int TbAbstractAlarmNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration =
        new TbClearAlarmNodeConfiguration();
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration2 =
        new TbClearAlarmNodeConfiguration();

    // Act and Assert
    assertEquals(tbClearAlarmNodeConfiguration, tbClearAlarmNodeConfiguration2);
    assertEquals(
        tbClearAlarmNodeConfiguration.hashCode(), tbClearAlarmNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#equals(Object)}, and {@link
   * TbAbstractAlarmNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractAlarmNodeConfiguration.equals(Object)",
    "int TbAbstractAlarmNodeConfiguration.hashCode()"
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
   * Test {@link TbAbstractAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractAlarmNodeConfiguration.equals(Object)",
    "int TbAbstractAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbClearAlarmNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractAlarmNodeConfiguration.equals(Object)",
    "int TbAbstractAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbClearAlarmNodeConfiguration(), null);
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractAlarmNodeConfiguration.equals(Object)",
    "int TbAbstractAlarmNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbClearAlarmNodeConfiguration(), "Different type to TbAbstractAlarmNodeConfiguration");
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#getAlarmDetailsBuildJs()}.
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#getAlarmDetailsBuildJs()}
   */
  @Test
  @DisplayName("Test getAlarmDetailsBuildJs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAbstractAlarmNodeConfiguration.getAlarmDetailsBuildJs()"})
  void testGetAlarmDetailsBuildJs() {
    // Arrange, Act and Assert
    assertNull(new TbClearAlarmNodeConfiguration().getAlarmDetailsBuildJs());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#getAlarmDetailsBuildTbel()}.
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#getAlarmDetailsBuildTbel()}
   */
  @Test
  @DisplayName("Test getAlarmDetailsBuildTbel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAbstractAlarmNodeConfiguration.getAlarmDetailsBuildTbel()"})
  void testGetAlarmDetailsBuildTbel() {
    // Arrange, Act and Assert
    assertNull(new TbClearAlarmNodeConfiguration().getAlarmDetailsBuildTbel());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#getAlarmType()}.
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#getAlarmType()}
   */
  @Test
  @DisplayName("Test getAlarmType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAbstractAlarmNodeConfiguration.getAlarmType()"})
  void testGetAlarmType() {
    // Arrange, Act and Assert
    assertNull(new TbClearAlarmNodeConfiguration().getAlarmType());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#getScriptLang()}.
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#getScriptLang()}
   */
  @Test
  @DisplayName("Test getScriptLang()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ScriptLanguage TbAbstractAlarmNodeConfiguration.getScriptLang()"})
  void testGetScriptLang() {
    // Arrange, Act and Assert
    assertNull(new TbClearAlarmNodeConfiguration().getScriptLang());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#setAlarmDetailsBuildJs(String)}.
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#setAlarmDetailsBuildJs(String)}
   */
  @Test
  @DisplayName("Test setAlarmDetailsBuildJs(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractAlarmNodeConfiguration.setAlarmDetailsBuildJs(String)"})
  void testSetAlarmDetailsBuildJs() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration =
        new TbClearAlarmNodeConfiguration();

    // Act
    tbClearAlarmNodeConfiguration.setAlarmDetailsBuildJs("Alarm Details Build Js");

    // Assert
    assertEquals("Alarm Details Build Js", tbClearAlarmNodeConfiguration.getAlarmDetailsBuildJs());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#setAlarmDetailsBuildTbel(String)}.
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#setAlarmDetailsBuildTbel(String)}
   */
  @Test
  @DisplayName("Test setAlarmDetailsBuildTbel(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractAlarmNodeConfiguration.setAlarmDetailsBuildTbel(String)"})
  void testSetAlarmDetailsBuildTbel() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration =
        new TbClearAlarmNodeConfiguration();

    // Act
    tbClearAlarmNodeConfiguration.setAlarmDetailsBuildTbel("Alarm Details Build Tbel");

    // Assert
    assertEquals(
        "Alarm Details Build Tbel", tbClearAlarmNodeConfiguration.getAlarmDetailsBuildTbel());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#setAlarmType(String)}.
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#setAlarmType(String)}
   */
  @Test
  @DisplayName("Test setAlarmType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractAlarmNodeConfiguration.setAlarmType(String)"})
  void testSetAlarmType() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration =
        new TbClearAlarmNodeConfiguration();

    // Act
    tbClearAlarmNodeConfiguration.setAlarmType("Alarm Type");

    // Assert
    assertEquals("Alarm Type", tbClearAlarmNodeConfiguration.getAlarmType());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#setScriptLang(ScriptLanguage)}.
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#setScriptLang(ScriptLanguage)}
   */
  @Test
  @DisplayName("Test setScriptLang(ScriptLanguage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractAlarmNodeConfiguration.setScriptLang(ScriptLanguage)"})
  void testSetScriptLang() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration =
        new TbClearAlarmNodeConfiguration();

    // Act
    tbClearAlarmNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    // Assert
    assertEquals(ScriptLanguage.JS, tbClearAlarmNodeConfiguration.getScriptLang());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#toString()}.
   *
   * <p>Method under test: {@link TbAbstractAlarmNodeConfiguration#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAbstractAlarmNodeConfiguration.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("TbClearAlarmNodeConfiguration()", new TbClearAlarmNodeConfiguration().toString());
  }
}
