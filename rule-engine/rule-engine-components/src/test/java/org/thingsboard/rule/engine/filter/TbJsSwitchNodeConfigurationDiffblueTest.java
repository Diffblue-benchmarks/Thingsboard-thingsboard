package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.script.ScriptLanguage;

class TbJsSwitchNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbJsSwitchNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test: {@link TbJsSwitchNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  void testDefaultConfiguration() {
    // Arrange and Act
    TbJsSwitchNodeConfiguration actualDefaultConfigurationResult = (new TbJsSwitchNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertEquals("function nextRelation(metadata, msg) {\n" + "    return ['one','nine'];\n" + "}\n"
        + "if(msgType == 'POST_TELEMETRY_REQUEST') {\n" + "    return ['two'];\n" + "}\n"
        + "return nextRelation(metadata, msg);", actualDefaultConfigurationResult.getTbelScript());
    assertEquals("function nextRelation(metadata, msg) {\n" + "    return ['one','nine'];\n" + "}\n"
        + "if(msgType === 'POST_TELEMETRY_REQUEST') {\n" + "    return ['two'];\n" + "}\n"
        + "return nextRelation(metadata, msg);", actualDefaultConfigurationResult.getJsScript());
    assertEquals(ScriptLanguage.TBEL, actualDefaultConfigurationResult.getScriptLang());
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}, and
   * {@link TbJsSwitchNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbJsSwitchNodeConfiguration#equals(Object)}
   *   <li>{@link TbJsSwitchNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration = new TbJsSwitchNodeConfiguration();
    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration2 = new TbJsSwitchNodeConfiguration();

    // Act and Assert
    assertEquals(tbJsSwitchNodeConfiguration, tbJsSwitchNodeConfiguration2);
    int expectedHashCodeResult = tbJsSwitchNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbJsSwitchNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}, and
   * {@link TbJsSwitchNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbJsSwitchNodeConfiguration#equals(Object)}
   *   <li>{@link TbJsSwitchNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration = new TbJsSwitchNodeConfiguration();
    tbJsSwitchNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration2 = new TbJsSwitchNodeConfiguration();
    tbJsSwitchNodeConfiguration2.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertEquals(tbJsSwitchNodeConfiguration, tbJsSwitchNodeConfiguration2);
    int expectedHashCodeResult = tbJsSwitchNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbJsSwitchNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}, and
   * {@link TbJsSwitchNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbJsSwitchNodeConfiguration#equals(Object)}
   *   <li>{@link TbJsSwitchNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration = new TbJsSwitchNodeConfiguration();
    tbJsSwitchNodeConfiguration.setJsScript("Js Script");

    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration2 = new TbJsSwitchNodeConfiguration();
    tbJsSwitchNodeConfiguration2.setJsScript("Js Script");

    // Act and Assert
    assertEquals(tbJsSwitchNodeConfiguration, tbJsSwitchNodeConfiguration2);
    int expectedHashCodeResult = tbJsSwitchNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbJsSwitchNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}, and
   * {@link TbJsSwitchNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbJsSwitchNodeConfiguration#equals(Object)}
   *   <li>{@link TbJsSwitchNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration = new TbJsSwitchNodeConfiguration();
    tbJsSwitchNodeConfiguration.setTbelScript("Tbel Script");

    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration2 = new TbJsSwitchNodeConfiguration();
    tbJsSwitchNodeConfiguration2.setTbelScript("Tbel Script");

    // Act and Assert
    assertEquals(tbJsSwitchNodeConfiguration, tbJsSwitchNodeConfiguration2);
    int expectedHashCodeResult = tbJsSwitchNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbJsSwitchNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}, and
   * {@link TbJsSwitchNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbJsSwitchNodeConfiguration#equals(Object)}
   *   <li>{@link TbJsSwitchNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration = new TbJsSwitchNodeConfiguration();

    // Act and Assert
    assertEquals(tbJsSwitchNodeConfiguration, tbJsSwitchNodeConfiguration);
    int expectedHashCodeResult = tbJsSwitchNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbJsSwitchNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJsSwitchNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbJsSwitchNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJsSwitchNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration = new TbJsSwitchNodeConfiguration();
    tbJsSwitchNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertNotEquals(tbJsSwitchNodeConfiguration, new TbJsSwitchNodeConfiguration());
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJsSwitchNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration = new TbJsSwitchNodeConfiguration();
    tbJsSwitchNodeConfiguration.setJsScript("Js Script");

    // Act and Assert
    assertNotEquals(tbJsSwitchNodeConfiguration, new TbJsSwitchNodeConfiguration());
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJsSwitchNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration = new TbJsSwitchNodeConfiguration();
    tbJsSwitchNodeConfiguration.setTbelScript("Tbel Script");

    // Act and Assert
    assertNotEquals(tbJsSwitchNodeConfiguration, new TbJsSwitchNodeConfiguration());
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJsSwitchNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration = new TbJsSwitchNodeConfiguration();

    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration2 = new TbJsSwitchNodeConfiguration();
    tbJsSwitchNodeConfiguration2.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertNotEquals(tbJsSwitchNodeConfiguration, tbJsSwitchNodeConfiguration2);
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJsSwitchNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration = new TbJsSwitchNodeConfiguration();

    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration2 = new TbJsSwitchNodeConfiguration();
    tbJsSwitchNodeConfiguration2.setJsScript("Js Script");

    // Act and Assert
    assertNotEquals(tbJsSwitchNodeConfiguration, tbJsSwitchNodeConfiguration2);
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJsSwitchNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration = new TbJsSwitchNodeConfiguration();

    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration2 = new TbJsSwitchNodeConfiguration();
    tbJsSwitchNodeConfiguration2.setTbelScript("Tbel Script");

    // Act and Assert
    assertNotEquals(tbJsSwitchNodeConfiguration, tbJsSwitchNodeConfiguration2);
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJsSwitchNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbJsSwitchNodeConfiguration(), null);
  }

  /**
   * Test {@link TbJsSwitchNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJsSwitchNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbJsSwitchNodeConfiguration(), "Different type to TbJsSwitchNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbJsSwitchNodeConfiguration}
   *   <li>{@link TbJsSwitchNodeConfiguration#setJsScript(String)}
   *   <li>{@link TbJsSwitchNodeConfiguration#setScriptLang(ScriptLanguage)}
   *   <li>{@link TbJsSwitchNodeConfiguration#setTbelScript(String)}
   *   <li>{@link TbJsSwitchNodeConfiguration#toString()}
   *   <li>{@link TbJsSwitchNodeConfiguration#getJsScript()}
   *   <li>{@link TbJsSwitchNodeConfiguration#getScriptLang()}
   *   <li>{@link TbJsSwitchNodeConfiguration#getTbelScript()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbJsSwitchNodeConfiguration actualTbJsSwitchNodeConfiguration = new TbJsSwitchNodeConfiguration();
    actualTbJsSwitchNodeConfiguration.setJsScript("Js Script");
    actualTbJsSwitchNodeConfiguration.setScriptLang(ScriptLanguage.JS);
    actualTbJsSwitchNodeConfiguration.setTbelScript("Tbel Script");
    String actualToStringResult = actualTbJsSwitchNodeConfiguration.toString();
    String actualJsScript = actualTbJsSwitchNodeConfiguration.getJsScript();
    ScriptLanguage actualScriptLang = actualTbJsSwitchNodeConfiguration.getScriptLang();

    // Assert that nothing has changed
    assertEquals("Js Script", actualJsScript);
    assertEquals("TbJsSwitchNodeConfiguration(scriptLang=JS, jsScript=Js Script, tbelScript=Tbel Script)",
        actualToStringResult);
    assertEquals("Tbel Script", actualTbJsSwitchNodeConfiguration.getTbelScript());
    assertEquals(ScriptLanguage.JS, actualScriptLang);
  }
}
