package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.script.ScriptLanguage;

class TbJsFilterNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbJsFilterNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbJsFilterNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbJsFilterNodeConfiguration TbJsFilterNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbJsFilterNodeConfiguration actualDefaultConfigurationResult =
        new TbJsFilterNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals("return msg.temperature > 20;", actualDefaultConfigurationResult.getJsScript());
    assertEquals("return msg.temperature > 20;", actualDefaultConfigurationResult.getTbelScript());
    assertEquals(ScriptLanguage.TBEL, actualDefaultConfigurationResult.getScriptLang());
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}, and {@link
   * TbJsFilterNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbJsFilterNodeConfiguration#equals(Object)}
   *   <li>{@link TbJsFilterNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration = new TbJsFilterNodeConfiguration();
    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration2 = new TbJsFilterNodeConfiguration();

    // Act and Assert
    assertEquals(tbJsFilterNodeConfiguration, tbJsFilterNodeConfiguration2);
    assertEquals(tbJsFilterNodeConfiguration.hashCode(), tbJsFilterNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}, and {@link
   * TbJsFilterNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbJsFilterNodeConfiguration#equals(Object)}
   *   <li>{@link TbJsFilterNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration = new TbJsFilterNodeConfiguration();
    tbJsFilterNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration2 = new TbJsFilterNodeConfiguration();
    tbJsFilterNodeConfiguration2.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertEquals(tbJsFilterNodeConfiguration, tbJsFilterNodeConfiguration2);
    assertEquals(tbJsFilterNodeConfiguration.hashCode(), tbJsFilterNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}, and {@link
   * TbJsFilterNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbJsFilterNodeConfiguration#equals(Object)}
   *   <li>{@link TbJsFilterNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration = new TbJsFilterNodeConfiguration();
    tbJsFilterNodeConfiguration.setJsScript("Js Script");

    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration2 = new TbJsFilterNodeConfiguration();
    tbJsFilterNodeConfiguration2.setJsScript("Js Script");

    // Act and Assert
    assertEquals(tbJsFilterNodeConfiguration, tbJsFilterNodeConfiguration2);
    assertEquals(tbJsFilterNodeConfiguration.hashCode(), tbJsFilterNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}, and {@link
   * TbJsFilterNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbJsFilterNodeConfiguration#equals(Object)}
   *   <li>{@link TbJsFilterNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration = new TbJsFilterNodeConfiguration();
    tbJsFilterNodeConfiguration.setTbelScript("Tbel Script");

    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration2 = new TbJsFilterNodeConfiguration();
    tbJsFilterNodeConfiguration2.setTbelScript("Tbel Script");

    // Act and Assert
    assertEquals(tbJsFilterNodeConfiguration, tbJsFilterNodeConfiguration2);
    assertEquals(tbJsFilterNodeConfiguration.hashCode(), tbJsFilterNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}, and {@link
   * TbJsFilterNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbJsFilterNodeConfiguration#equals(Object)}
   *   <li>{@link TbJsFilterNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration = new TbJsFilterNodeConfiguration();

    // Act and Assert
    assertEquals(tbJsFilterNodeConfiguration, tbJsFilterNodeConfiguration);
    int expectedHashCodeResult = tbJsFilterNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbJsFilterNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbJsFilterNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration = new TbJsFilterNodeConfiguration();
    tbJsFilterNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertNotEquals(tbJsFilterNodeConfiguration, new TbJsFilterNodeConfiguration());
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration = new TbJsFilterNodeConfiguration();
    tbJsFilterNodeConfiguration.setJsScript("Js Script");

    // Act and Assert
    assertNotEquals(tbJsFilterNodeConfiguration, new TbJsFilterNodeConfiguration());
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration = new TbJsFilterNodeConfiguration();
    tbJsFilterNodeConfiguration.setTbelScript("Tbel Script");

    // Act and Assert
    assertNotEquals(tbJsFilterNodeConfiguration, new TbJsFilterNodeConfiguration());
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration = new TbJsFilterNodeConfiguration();

    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration2 = new TbJsFilterNodeConfiguration();
    tbJsFilterNodeConfiguration2.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertNotEquals(tbJsFilterNodeConfiguration, tbJsFilterNodeConfiguration2);
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration = new TbJsFilterNodeConfiguration();

    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration2 = new TbJsFilterNodeConfiguration();
    tbJsFilterNodeConfiguration2.setJsScript("Js Script");

    // Act and Assert
    assertNotEquals(tbJsFilterNodeConfiguration, tbJsFilterNodeConfiguration2);
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration = new TbJsFilterNodeConfiguration();

    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration2 = new TbJsFilterNodeConfiguration();
    tbJsFilterNodeConfiguration2.setTbelScript("Tbel Script");

    // Act and Assert
    assertNotEquals(tbJsFilterNodeConfiguration, tbJsFilterNodeConfiguration2);
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbJsFilterNodeConfiguration(), null);
  }

  /**
   * Test {@link TbJsFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsFilterNodeConfiguration.equals(Object)",
    "int TbJsFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbJsFilterNodeConfiguration(), "Different type to TbJsFilterNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbJsFilterNodeConfiguration}
   *   <li>{@link TbJsFilterNodeConfiguration#setJsScript(String)}
   *   <li>{@link TbJsFilterNodeConfiguration#setScriptLang(ScriptLanguage)}
   *   <li>{@link TbJsFilterNodeConfiguration#setTbelScript(String)}
   *   <li>{@link TbJsFilterNodeConfiguration#toString()}
   *   <li>{@link TbJsFilterNodeConfiguration#getJsScript()}
   *   <li>{@link TbJsFilterNodeConfiguration#getScriptLang()}
   *   <li>{@link TbJsFilterNodeConfiguration#getTbelScript()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbJsFilterNodeConfiguration.<init>()",
    "String TbJsFilterNodeConfiguration.getJsScript()",
    "ScriptLanguage TbJsFilterNodeConfiguration.getScriptLang()",
    "String TbJsFilterNodeConfiguration.getTbelScript()",
    "void TbJsFilterNodeConfiguration.setJsScript(String)",
    "void TbJsFilterNodeConfiguration.setScriptLang(ScriptLanguage)",
    "void TbJsFilterNodeConfiguration.setTbelScript(String)",
    "String TbJsFilterNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbJsFilterNodeConfiguration actualTbJsFilterNodeConfiguration =
        new TbJsFilterNodeConfiguration();
    actualTbJsFilterNodeConfiguration.setJsScript("Js Script");
    actualTbJsFilterNodeConfiguration.setScriptLang(ScriptLanguage.JS);
    actualTbJsFilterNodeConfiguration.setTbelScript("Tbel Script");
    String actualToStringResult = actualTbJsFilterNodeConfiguration.toString();
    String actualJsScript = actualTbJsFilterNodeConfiguration.getJsScript();
    ScriptLanguage actualScriptLang = actualTbJsFilterNodeConfiguration.getScriptLang();

    // Assert
    assertEquals("Js Script", actualJsScript);
    assertEquals(
        "TbJsFilterNodeConfiguration(scriptLang=JS, jsScript=Js Script, tbelScript=Tbel Script)",
        actualToStringResult);
    assertEquals("Tbel Script", actualTbJsFilterNodeConfiguration.getTbelScript());
    assertEquals(ScriptLanguage.JS, actualScriptLang);
  }
}
