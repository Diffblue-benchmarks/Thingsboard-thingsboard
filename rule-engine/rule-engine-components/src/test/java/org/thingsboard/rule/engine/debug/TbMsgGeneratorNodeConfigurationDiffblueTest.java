package org.thingsboard.rule.engine.debug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.script.ScriptLanguage;

class TbMsgGeneratorNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test:
   * {@link TbMsgGeneratorNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  void testDefaultConfiguration() {
    // Arrange and Act
    TbMsgGeneratorNodeConfiguration actualDefaultConfigurationResult = (new TbMsgGeneratorNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertNull(actualDefaultConfigurationResult.getOriginatorId());
    assertEquals(0, actualDefaultConfigurationResult.getMsgCount());
    assertEquals(1, actualDefaultConfigurationResult.getPeriodInSeconds());
    assertEquals(EntityType.RULE_NODE, actualDefaultConfigurationResult.getOriginatorType());
    assertEquals(ScriptLanguage.TBEL, actualDefaultConfigurationResult.getScriptLang());
    assertEquals(TbMsgGeneratorNodeConfiguration.DEFAULT_SCRIPT, actualDefaultConfigurationResult.getJsScript());
    assertEquals(TbMsgGeneratorNodeConfiguration.DEFAULT_SCRIPT, actualDefaultConfigurationResult.getTbelScript());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}, and
   * {@link TbMsgGeneratorNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration2 = new TbMsgGeneratorNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgGeneratorNodeConfiguration, tbMsgGeneratorNodeConfiguration2);
    int expectedHashCodeResult = tbMsgGeneratorNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgGeneratorNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}, and
   * {@link TbMsgGeneratorNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setOriginatorId("42");

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration2 = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration2.setOriginatorId("42");

    // Act and Assert
    assertEquals(tbMsgGeneratorNodeConfiguration, tbMsgGeneratorNodeConfiguration2);
    int expectedHashCodeResult = tbMsgGeneratorNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgGeneratorNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}, and
   * {@link TbMsgGeneratorNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setOriginatorType(EntityType.TENANT);

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration2 = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration2.setOriginatorType(EntityType.TENANT);

    // Act and Assert
    assertEquals(tbMsgGeneratorNodeConfiguration, tbMsgGeneratorNodeConfiguration2);
    int expectedHashCodeResult = tbMsgGeneratorNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgGeneratorNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}, and
   * {@link TbMsgGeneratorNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration2 = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration2.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertEquals(tbMsgGeneratorNodeConfiguration, tbMsgGeneratorNodeConfiguration2);
    int expectedHashCodeResult = tbMsgGeneratorNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgGeneratorNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}, and
   * {@link TbMsgGeneratorNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setJsScript("Js Script");

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration2 = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration2.setJsScript("Js Script");

    // Act and Assert
    assertEquals(tbMsgGeneratorNodeConfiguration, tbMsgGeneratorNodeConfiguration2);
    int expectedHashCodeResult = tbMsgGeneratorNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgGeneratorNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}, and
   * {@link TbMsgGeneratorNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setTbelScript("Tbel Script");

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration2 = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration2.setTbelScript("Tbel Script");

    // Act and Assert
    assertEquals(tbMsgGeneratorNodeConfiguration, tbMsgGeneratorNodeConfiguration2);
    int expectedHashCodeResult = tbMsgGeneratorNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgGeneratorNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}, and
   * {@link TbMsgGeneratorNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgGeneratorNodeConfiguration, tbMsgGeneratorNodeConfiguration);
    int expectedHashCodeResult = tbMsgGeneratorNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgGeneratorNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgGeneratorNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setMsgCount(3);

    // Act and Assert
    assertNotEquals(tbMsgGeneratorNodeConfiguration, new TbMsgGeneratorNodeConfiguration());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setPeriodInSeconds(1);

    // Act and Assert
    assertNotEquals(tbMsgGeneratorNodeConfiguration, new TbMsgGeneratorNodeConfiguration());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setOriginatorId("42");

    // Act and Assert
    assertNotEquals(tbMsgGeneratorNodeConfiguration, new TbMsgGeneratorNodeConfiguration());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setOriginatorType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(tbMsgGeneratorNodeConfiguration, new TbMsgGeneratorNodeConfiguration());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertNotEquals(tbMsgGeneratorNodeConfiguration, new TbMsgGeneratorNodeConfiguration());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setJsScript("Js Script");

    // Act and Assert
    assertNotEquals(tbMsgGeneratorNodeConfiguration, new TbMsgGeneratorNodeConfiguration());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setTbelScript("Tbel Script");

    // Act and Assert
    assertNotEquals(tbMsgGeneratorNodeConfiguration, new TbMsgGeneratorNodeConfiguration());
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration2 = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration2.setOriginatorId("42");

    // Act and Assert
    assertNotEquals(tbMsgGeneratorNodeConfiguration, tbMsgGeneratorNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration2 = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration2.setOriginatorType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(tbMsgGeneratorNodeConfiguration, tbMsgGeneratorNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration2 = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration2.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertNotEquals(tbMsgGeneratorNodeConfiguration, tbMsgGeneratorNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration2 = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration2.setJsScript("Js Script");

    // Act and Assert
    assertNotEquals(tbMsgGeneratorNodeConfiguration, tbMsgGeneratorNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration2 = new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration2.setTbelScript("Tbel Script");

    // Act and Assert
    assertNotEquals(tbMsgGeneratorNodeConfiguration, tbMsgGeneratorNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgGeneratorNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMsgGeneratorNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgGeneratorNodeConfiguration(), "Different type to TbMsgGeneratorNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbMsgGeneratorNodeConfiguration}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#setJsScript(String)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#setMsgCount(int)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#setOriginatorId(String)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#setOriginatorType(EntityType)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#setPeriodInSeconds(int)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#setScriptLang(ScriptLanguage)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#setTbelScript(String)}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#toString()}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#getJsScript()}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#getMsgCount()}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#getOriginatorId()}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#getOriginatorType()}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#getPeriodInSeconds()}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#getScriptLang()}
   *   <li>{@link TbMsgGeneratorNodeConfiguration#getTbelScript()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgGeneratorNodeConfiguration actualTbMsgGeneratorNodeConfiguration = new TbMsgGeneratorNodeConfiguration();
    actualTbMsgGeneratorNodeConfiguration.setJsScript("Js Script");
    actualTbMsgGeneratorNodeConfiguration.setMsgCount(3);
    actualTbMsgGeneratorNodeConfiguration.setOriginatorId("42");
    actualTbMsgGeneratorNodeConfiguration.setOriginatorType(EntityType.TENANT);
    actualTbMsgGeneratorNodeConfiguration.setPeriodInSeconds(1);
    actualTbMsgGeneratorNodeConfiguration.setScriptLang(ScriptLanguage.JS);
    actualTbMsgGeneratorNodeConfiguration.setTbelScript("Tbel Script");
    String actualToStringResult = actualTbMsgGeneratorNodeConfiguration.toString();
    String actualJsScript = actualTbMsgGeneratorNodeConfiguration.getJsScript();
    int actualMsgCount = actualTbMsgGeneratorNodeConfiguration.getMsgCount();
    String actualOriginatorId = actualTbMsgGeneratorNodeConfiguration.getOriginatorId();
    EntityType actualOriginatorType = actualTbMsgGeneratorNodeConfiguration.getOriginatorType();
    int actualPeriodInSeconds = actualTbMsgGeneratorNodeConfiguration.getPeriodInSeconds();
    ScriptLanguage actualScriptLang = actualTbMsgGeneratorNodeConfiguration.getScriptLang();

    // Assert that nothing has changed
    assertEquals("42", actualOriginatorId);
    assertEquals("Js Script", actualJsScript);
    assertEquals(
        "TbMsgGeneratorNodeConfiguration(msgCount=3, periodInSeconds=1, originatorId=42, originatorType=TENANT,"
            + " scriptLang=JS, jsScript=Js Script, tbelScript=Tbel Script)",
        actualToStringResult);
    assertEquals("Tbel Script", actualTbMsgGeneratorNodeConfiguration.getTbelScript());
    assertEquals(1, actualPeriodInSeconds);
    assertEquals(3, actualMsgCount);
    assertEquals(EntityType.TENANT, actualOriginatorType);
    assertEquals(ScriptLanguage.JS, actualScriptLang);
  }
}
