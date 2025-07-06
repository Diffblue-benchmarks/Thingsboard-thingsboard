package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.script.ScriptLanguage;

class TbTransformMsgNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbTransformMsgNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbTransformMsgNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbTransformMsgNodeConfiguration TbTransformMsgNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbTransformMsgNodeConfiguration actualDefaultConfigurationResult =
        new TbTransformMsgNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals(
        "return {msg: msg, metadata: metadata, msgType: msgType};",
        actualDefaultConfigurationResult.getJsScript());
    assertEquals(
        "return {msg: msg, metadata: metadata, msgType: msgType};",
        actualDefaultConfigurationResult.getTbelScript());
    assertEquals(ScriptLanguage.TBEL, actualDefaultConfigurationResult.getScriptLang());
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}, and {@link
   * TbTransformMsgNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbTransformMsgNodeConfiguration#equals(Object)}
   *   <li>{@link TbTransformMsgNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration2 =
        new TbTransformMsgNodeConfiguration();

    // Act and Assert
    assertEquals(tbTransformMsgNodeConfiguration, tbTransformMsgNodeConfiguration2);
    int expectedHashCodeResult = tbTransformMsgNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbTransformMsgNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}, and {@link
   * TbTransformMsgNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbTransformMsgNodeConfiguration#equals(Object)}
   *   <li>{@link TbTransformMsgNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration2 =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration2.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertEquals(tbTransformMsgNodeConfiguration, tbTransformMsgNodeConfiguration2);
    int expectedHashCodeResult = tbTransformMsgNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbTransformMsgNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}, and {@link
   * TbTransformMsgNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbTransformMsgNodeConfiguration#equals(Object)}
   *   <li>{@link TbTransformMsgNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration.setJsScript("Js Script");

    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration2 =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration2.setJsScript("Js Script");

    // Act and Assert
    assertEquals(tbTransformMsgNodeConfiguration, tbTransformMsgNodeConfiguration2);
    int expectedHashCodeResult = tbTransformMsgNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbTransformMsgNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}, and {@link
   * TbTransformMsgNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbTransformMsgNodeConfiguration#equals(Object)}
   *   <li>{@link TbTransformMsgNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration.setTbelScript("Tbel Script");

    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration2 =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration2.setTbelScript("Tbel Script");

    // Act and Assert
    assertEquals(tbTransformMsgNodeConfiguration, tbTransformMsgNodeConfiguration2);
    int expectedHashCodeResult = tbTransformMsgNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbTransformMsgNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}, and {@link
   * TbTransformMsgNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbTransformMsgNodeConfiguration#equals(Object)}
   *   <li>{@link TbTransformMsgNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();

    // Act and Assert
    assertEquals(tbTransformMsgNodeConfiguration, tbTransformMsgNodeConfiguration);
    int expectedHashCodeResult = tbTransformMsgNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbTransformMsgNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbTransformMsgNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertNotEquals(tbTransformMsgNodeConfiguration, new TbTransformMsgNodeConfiguration());
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration.setJsScript("Js Script");

    // Act and Assert
    assertNotEquals(tbTransformMsgNodeConfiguration, new TbTransformMsgNodeConfiguration());
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration.setTbelScript("Tbel Script");

    // Act and Assert
    assertNotEquals(tbTransformMsgNodeConfiguration, new TbTransformMsgNodeConfiguration());
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();

    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration2 =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration2.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertNotEquals(tbTransformMsgNodeConfiguration, tbTransformMsgNodeConfiguration2);
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();

    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration2 =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration2.setJsScript("Js Script");

    // Act and Assert
    assertNotEquals(tbTransformMsgNodeConfiguration, tbTransformMsgNodeConfiguration2);
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();

    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration2 =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration2.setTbelScript("Tbel Script");

    // Act and Assert
    assertNotEquals(tbTransformMsgNodeConfiguration, tbTransformMsgNodeConfiguration2);
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbTransformMsgNodeConfiguration(), null);
  }

  /**
   * Test {@link TbTransformMsgNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbTransformMsgNodeConfiguration.equals(Object)",
    "int TbTransformMsgNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbTransformMsgNodeConfiguration(), "Different type to TbTransformMsgNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbTransformMsgNodeConfiguration}
   *   <li>{@link TbTransformMsgNodeConfiguration#setJsScript(String)}
   *   <li>{@link TbTransformMsgNodeConfiguration#setScriptLang(ScriptLanguage)}
   *   <li>{@link TbTransformMsgNodeConfiguration#setTbelScript(String)}
   *   <li>{@link TbTransformMsgNodeConfiguration#toString()}
   *   <li>{@link TbTransformMsgNodeConfiguration#getJsScript()}
   *   <li>{@link TbTransformMsgNodeConfiguration#getScriptLang()}
   *   <li>{@link TbTransformMsgNodeConfiguration#getTbelScript()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbTransformMsgNodeConfiguration.<init>()",
    "String TbTransformMsgNodeConfiguration.getJsScript()",
    "ScriptLanguage TbTransformMsgNodeConfiguration.getScriptLang()",
    "String TbTransformMsgNodeConfiguration.getTbelScript()",
    "void TbTransformMsgNodeConfiguration.setJsScript(String)",
    "void TbTransformMsgNodeConfiguration.setScriptLang(ScriptLanguage)",
    "void TbTransformMsgNodeConfiguration.setTbelScript(String)",
    "String TbTransformMsgNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbTransformMsgNodeConfiguration actualTbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();
    actualTbTransformMsgNodeConfiguration.setJsScript("Js Script");
    actualTbTransformMsgNodeConfiguration.setScriptLang(ScriptLanguage.JS);
    actualTbTransformMsgNodeConfiguration.setTbelScript("Tbel Script");
    String actualToStringResult = actualTbTransformMsgNodeConfiguration.toString();
    String actualJsScript = actualTbTransformMsgNodeConfiguration.getJsScript();
    ScriptLanguage actualScriptLang = actualTbTransformMsgNodeConfiguration.getScriptLang();

    // Assert
    assertEquals("Js Script", actualJsScript);
    assertEquals(
        "TbTransformMsgNodeConfiguration(scriptLang=JS, jsScript=Js Script, tbelScript=Tbel Script)",
        actualToStringResult);
    assertEquals("Tbel Script", actualTbTransformMsgNodeConfiguration.getTbelScript());
    assertEquals(ScriptLanguage.JS, actualScriptLang);
  }
}
