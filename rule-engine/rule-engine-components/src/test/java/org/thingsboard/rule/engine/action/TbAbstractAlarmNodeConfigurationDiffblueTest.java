package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.script.ScriptLanguage;

class TbAbstractAlarmNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbAbstractAlarmNodeConfiguration.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TbClearAlarmNodeConfiguration()).canEqual("Other"));
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#canEqual(Object)}.
   * <ul>
   *   <li>When {@link TbClearAlarmNodeConfiguration} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when TbClearAlarmNodeConfiguration (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbAbstractAlarmNodeConfiguration.canEqual(Object)"})
  void testCanEqual_whenTbClearAlarmNodeConfiguration_thenReturnTrue() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration = new TbClearAlarmNodeConfiguration();

    // Act and Assert
    assertTrue(tbClearAlarmNodeConfiguration.canEqual(new TbClearAlarmNodeConfiguration()));
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#equals(Object)}, and {@link TbAbstractAlarmNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbAbstractAlarmNodeConfiguration.equals(Object)",
      "int TbAbstractAlarmNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration = new TbClearAlarmNodeConfiguration();
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration2 = new TbClearAlarmNodeConfiguration();

    // Act and Assert
    assertEquals(tbClearAlarmNodeConfiguration, tbClearAlarmNodeConfiguration2);
    int expectedHashCodeResult = tbClearAlarmNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbClearAlarmNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#equals(Object)}, and {@link TbAbstractAlarmNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbAbstractAlarmNodeConfiguration.equals(Object)",
      "int TbAbstractAlarmNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration = new TbClearAlarmNodeConfiguration();

    // Act and Assert
    assertEquals(tbClearAlarmNodeConfiguration, tbClearAlarmNodeConfiguration);
    int expectedHashCodeResult = tbClearAlarmNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbClearAlarmNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbAbstractAlarmNodeConfiguration.equals(Object)",
      "int TbAbstractAlarmNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbClearAlarmNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbAbstractAlarmNodeConfiguration.equals(Object)",
      "int TbAbstractAlarmNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbClearAlarmNodeConfiguration(), null);
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbAbstractAlarmNodeConfiguration.equals(Object)",
      "int TbAbstractAlarmNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbClearAlarmNodeConfiguration(), "Different type to TbAbstractAlarmNodeConfiguration");
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#getAlarmDetailsBuildJs()}.
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#getAlarmDetailsBuildJs()}
   */
  @Test
  @DisplayName("Test getAlarmDetailsBuildJs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbAbstractAlarmNodeConfiguration.getAlarmDetailsBuildJs()"})
  void testGetAlarmDetailsBuildJs() {
    // Arrange, Act and Assert
    assertNull((new TbClearAlarmNodeConfiguration()).getAlarmDetailsBuildJs());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#getAlarmDetailsBuildTbel()}.
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#getAlarmDetailsBuildTbel()}
   */
  @Test
  @DisplayName("Test getAlarmDetailsBuildTbel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbAbstractAlarmNodeConfiguration.getAlarmDetailsBuildTbel()"})
  void testGetAlarmDetailsBuildTbel() {
    // Arrange, Act and Assert
    assertNull((new TbClearAlarmNodeConfiguration()).getAlarmDetailsBuildTbel());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#getAlarmType()}.
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#getAlarmType()}
   */
  @Test
  @DisplayName("Test getAlarmType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbAbstractAlarmNodeConfiguration.getAlarmType()"})
  void testGetAlarmType() {
    // Arrange, Act and Assert
    assertNull((new TbClearAlarmNodeConfiguration()).getAlarmType());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#getScriptLang()}.
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#getScriptLang()}
   */
  @Test
  @DisplayName("Test getScriptLang()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ScriptLanguage TbAbstractAlarmNodeConfiguration.getScriptLang()"})
  void testGetScriptLang() {
    // Arrange, Act and Assert
    assertNull((new TbClearAlarmNodeConfiguration()).getScriptLang());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#setAlarmDetailsBuildJs(String)}.
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#setAlarmDetailsBuildJs(String)}
   */
  @Test
  @DisplayName("Test setAlarmDetailsBuildJs(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAbstractAlarmNodeConfiguration.setAlarmDetailsBuildJs(String)"})
  void testSetAlarmDetailsBuildJs() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration = new TbClearAlarmNodeConfiguration();

    // Act
    tbClearAlarmNodeConfiguration.setAlarmDetailsBuildJs("Alarm Details Build Js");

    // Assert
    assertEquals("Alarm Details Build Js", tbClearAlarmNodeConfiguration.getAlarmDetailsBuildJs());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#setAlarmDetailsBuildTbel(String)}.
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#setAlarmDetailsBuildTbel(String)}
   */
  @Test
  @DisplayName("Test setAlarmDetailsBuildTbel(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAbstractAlarmNodeConfiguration.setAlarmDetailsBuildTbel(String)"})
  void testSetAlarmDetailsBuildTbel() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration = new TbClearAlarmNodeConfiguration();

    // Act
    tbClearAlarmNodeConfiguration.setAlarmDetailsBuildTbel("Alarm Details Build Tbel");

    // Assert
    assertEquals("Alarm Details Build Tbel", tbClearAlarmNodeConfiguration.getAlarmDetailsBuildTbel());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#setAlarmType(String)}.
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#setAlarmType(String)}
   */
  @Test
  @DisplayName("Test setAlarmType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAbstractAlarmNodeConfiguration.setAlarmType(String)"})
  void testSetAlarmType() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration = new TbClearAlarmNodeConfiguration();

    // Act
    tbClearAlarmNodeConfiguration.setAlarmType("Alarm Type");

    // Assert
    assertEquals("Alarm Type", tbClearAlarmNodeConfiguration.getAlarmType());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#setScriptLang(ScriptLanguage)}.
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#setScriptLang(ScriptLanguage)}
   */
  @Test
  @DisplayName("Test setScriptLang(ScriptLanguage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAbstractAlarmNodeConfiguration.setScriptLang(ScriptLanguage)"})
  void testSetScriptLang() {
    // Arrange
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration = new TbClearAlarmNodeConfiguration();

    // Act
    tbClearAlarmNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    // Assert
    assertEquals(ScriptLanguage.JS, tbClearAlarmNodeConfiguration.getScriptLang());
  }

  /**
   * Test {@link TbAbstractAlarmNodeConfiguration#toString()}.
   * <p>
   * Method under test: {@link TbAbstractAlarmNodeConfiguration#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbAbstractAlarmNodeConfiguration.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("TbClearAlarmNodeConfiguration()", (new TbClearAlarmNodeConfiguration()).toString());
  }
}
