package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.script.ScriptLanguage;

class TbLogNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbLogNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbLogNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbLogNodeConfiguration TbLogNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration() {
    // Arrange and Act
    TbLogNodeConfiguration actualDefaultConfigurationResult =
        new TbLogNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals(
        "return '\\nIncoming message:\\n' + JSON.stringify(msg) + '\\nIncoming metadata:\\n' + JSON.stringify"
            + "(metadata);",
        actualDefaultConfigurationResult.getJsScript());
    assertEquals(
        "return '\\nIncoming message:\\n' + JSON.stringify(msg) + '\\nIncoming metadata:\\n' + JSON.stringify"
            + "(metadata);",
        actualDefaultConfigurationResult.getTbelScript());
    assertEquals(ScriptLanguage.TBEL, actualDefaultConfigurationResult.getScriptLang());
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}, and {@link
   * TbLogNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLogNodeConfiguration#equals(Object)}
   *   <li>{@link TbLogNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();
    TbLogNodeConfiguration tbLogNodeConfiguration2 = new TbLogNodeConfiguration();

    // Act and Assert
    assertEquals(tbLogNodeConfiguration, tbLogNodeConfiguration2);
    int expectedHashCodeResult = tbLogNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbLogNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}, and {@link
   * TbLogNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLogNodeConfiguration#equals(Object)}
   *   <li>{@link TbLogNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();
    tbLogNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    TbLogNodeConfiguration tbLogNodeConfiguration2 = new TbLogNodeConfiguration();
    tbLogNodeConfiguration2.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertEquals(tbLogNodeConfiguration, tbLogNodeConfiguration2);
    int expectedHashCodeResult = tbLogNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbLogNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}, and {@link
   * TbLogNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLogNodeConfiguration#equals(Object)}
   *   <li>{@link TbLogNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();
    tbLogNodeConfiguration.setJsScript("Js Script");

    TbLogNodeConfiguration tbLogNodeConfiguration2 = new TbLogNodeConfiguration();
    tbLogNodeConfiguration2.setJsScript("Js Script");

    // Act and Assert
    assertEquals(tbLogNodeConfiguration, tbLogNodeConfiguration2);
    int expectedHashCodeResult = tbLogNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbLogNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}, and {@link
   * TbLogNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLogNodeConfiguration#equals(Object)}
   *   <li>{@link TbLogNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();
    tbLogNodeConfiguration.setTbelScript("Tbel Script");

    TbLogNodeConfiguration tbLogNodeConfiguration2 = new TbLogNodeConfiguration();
    tbLogNodeConfiguration2.setTbelScript("Tbel Script");

    // Act and Assert
    assertEquals(tbLogNodeConfiguration, tbLogNodeConfiguration2);
    int expectedHashCodeResult = tbLogNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbLogNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}, and {@link
   * TbLogNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLogNodeConfiguration#equals(Object)}
   *   <li>{@link TbLogNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();

    // Act and Assert
    assertEquals(tbLogNodeConfiguration, tbLogNodeConfiguration);
    int expectedHashCodeResult = tbLogNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbLogNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbLogNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();
    tbLogNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertNotEquals(tbLogNodeConfiguration, new TbLogNodeConfiguration());
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();
    tbLogNodeConfiguration.setJsScript("Js Script");

    // Act and Assert
    assertNotEquals(tbLogNodeConfiguration, new TbLogNodeConfiguration());
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();
    tbLogNodeConfiguration.setTbelScript("Tbel Script");

    // Act and Assert
    assertNotEquals(tbLogNodeConfiguration, new TbLogNodeConfiguration());
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();

    TbLogNodeConfiguration tbLogNodeConfiguration2 = new TbLogNodeConfiguration();
    tbLogNodeConfiguration2.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertNotEquals(tbLogNodeConfiguration, tbLogNodeConfiguration2);
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();

    TbLogNodeConfiguration tbLogNodeConfiguration2 = new TbLogNodeConfiguration();
    tbLogNodeConfiguration2.setJsScript("Js Script");

    // Act and Assert
    assertNotEquals(tbLogNodeConfiguration, tbLogNodeConfiguration2);
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();

    TbLogNodeConfiguration tbLogNodeConfiguration2 = new TbLogNodeConfiguration();
    tbLogNodeConfiguration2.setTbelScript("Tbel Script");

    // Act and Assert
    assertNotEquals(tbLogNodeConfiguration, tbLogNodeConfiguration2);
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbLogNodeConfiguration(), null);
  }

  /**
   * Test {@link TbLogNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbLogNodeConfiguration.equals(Object)",
    "int TbLogNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbLogNodeConfiguration(), "Different type to TbLogNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbLogNodeConfiguration}
   *   <li>{@link TbLogNodeConfiguration#setJsScript(String)}
   *   <li>{@link TbLogNodeConfiguration#setScriptLang(ScriptLanguage)}
   *   <li>{@link TbLogNodeConfiguration#setTbelScript(String)}
   *   <li>{@link TbLogNodeConfiguration#toString()}
   *   <li>{@link TbLogNodeConfiguration#getJsScript()}
   *   <li>{@link TbLogNodeConfiguration#getScriptLang()}
   *   <li>{@link TbLogNodeConfiguration#getTbelScript()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbLogNodeConfiguration.<init>()",
    "String TbLogNodeConfiguration.getJsScript()",
    "ScriptLanguage TbLogNodeConfiguration.getScriptLang()",
    "String TbLogNodeConfiguration.getTbelScript()",
    "void TbLogNodeConfiguration.setJsScript(String)",
    "void TbLogNodeConfiguration.setScriptLang(ScriptLanguage)",
    "void TbLogNodeConfiguration.setTbelScript(String)",
    "String TbLogNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbLogNodeConfiguration actualTbLogNodeConfiguration = new TbLogNodeConfiguration();
    actualTbLogNodeConfiguration.setJsScript("Js Script");
    actualTbLogNodeConfiguration.setScriptLang(ScriptLanguage.JS);
    actualTbLogNodeConfiguration.setTbelScript("Tbel Script");
    String actualToStringResult = actualTbLogNodeConfiguration.toString();
    String actualJsScript = actualTbLogNodeConfiguration.getJsScript();
    ScriptLanguage actualScriptLang = actualTbLogNodeConfiguration.getScriptLang();

    // Assert
    assertEquals("Js Script", actualJsScript);
    assertEquals(
        "TbLogNodeConfiguration(scriptLang=JS, jsScript=Js Script, tbelScript=Tbel Script)",
        actualToStringResult);
    assertEquals("Tbel Script", actualTbLogNodeConfiguration.getTbelScript());
    assertEquals(ScriptLanguage.JS, actualScriptLang);
  }
}
