package org.thingsboard.rule.engine.flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbRuleChainInputNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbRuleChainInputNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbRuleChainInputNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbRuleChainInputNodeConfiguration TbRuleChainInputNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange
    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration =
        new TbRuleChainInputNodeConfiguration();

    // Act
    TbRuleChainInputNodeConfiguration actualDefaultConfigurationResult =
        tbRuleChainInputNodeConfiguration.defaultConfiguration();

    // Assert
    assertEquals(tbRuleChainInputNodeConfiguration, actualDefaultConfigurationResult);
  }

  /**
   * Test {@link TbRuleChainInputNodeConfiguration#equals(Object)}, and {@link
   * TbRuleChainInputNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbRuleChainInputNodeConfiguration#equals(Object)}
   *   <li>{@link TbRuleChainInputNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRuleChainInputNodeConfiguration.equals(Object)",
    "int TbRuleChainInputNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration =
        new TbRuleChainInputNodeConfiguration();
    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration2 =
        new TbRuleChainInputNodeConfiguration();

    // Act and Assert
    assertEquals(tbRuleChainInputNodeConfiguration, tbRuleChainInputNodeConfiguration2);
    assertEquals(
        tbRuleChainInputNodeConfiguration.hashCode(),
        tbRuleChainInputNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRuleChainInputNodeConfiguration#equals(Object)}, and {@link
   * TbRuleChainInputNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbRuleChainInputNodeConfiguration#equals(Object)}
   *   <li>{@link TbRuleChainInputNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRuleChainInputNodeConfiguration.equals(Object)",
    "int TbRuleChainInputNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration =
        new TbRuleChainInputNodeConfiguration();
    tbRuleChainInputNodeConfiguration.setRuleChainId("42");

    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration2 =
        new TbRuleChainInputNodeConfiguration();
    tbRuleChainInputNodeConfiguration2.setRuleChainId("42");

    // Act and Assert
    assertEquals(tbRuleChainInputNodeConfiguration, tbRuleChainInputNodeConfiguration2);
    assertEquals(
        tbRuleChainInputNodeConfiguration.hashCode(),
        tbRuleChainInputNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRuleChainInputNodeConfiguration#equals(Object)}, and {@link
   * TbRuleChainInputNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbRuleChainInputNodeConfiguration#equals(Object)}
   *   <li>{@link TbRuleChainInputNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRuleChainInputNodeConfiguration.equals(Object)",
    "int TbRuleChainInputNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration =
        new TbRuleChainInputNodeConfiguration();

    // Act and Assert
    assertEquals(tbRuleChainInputNodeConfiguration, tbRuleChainInputNodeConfiguration);
    int expectedHashCodeResult = tbRuleChainInputNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRuleChainInputNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbRuleChainInputNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainInputNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRuleChainInputNodeConfiguration.equals(Object)",
    "int TbRuleChainInputNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRuleChainInputNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbRuleChainInputNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainInputNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRuleChainInputNodeConfiguration.equals(Object)",
    "int TbRuleChainInputNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration =
        new TbRuleChainInputNodeConfiguration();
    tbRuleChainInputNodeConfiguration.setRuleChainId("42");

    // Act and Assert
    assertNotEquals(tbRuleChainInputNodeConfiguration, new TbRuleChainInputNodeConfiguration());
  }

  /**
   * Test {@link TbRuleChainInputNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainInputNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRuleChainInputNodeConfiguration.equals(Object)",
    "int TbRuleChainInputNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration =
        new TbRuleChainInputNodeConfiguration();
    tbRuleChainInputNodeConfiguration.setForwardMsgToDefaultRuleChain(true);

    // Act and Assert
    assertNotEquals(tbRuleChainInputNodeConfiguration, new TbRuleChainInputNodeConfiguration());
  }

  /**
   * Test {@link TbRuleChainInputNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainInputNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRuleChainInputNodeConfiguration.equals(Object)",
    "int TbRuleChainInputNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration =
        new TbRuleChainInputNodeConfiguration();

    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration2 =
        new TbRuleChainInputNodeConfiguration();
    tbRuleChainInputNodeConfiguration2.setRuleChainId("42");

    // Act and Assert
    assertNotEquals(tbRuleChainInputNodeConfiguration, tbRuleChainInputNodeConfiguration2);
  }

  /**
   * Test {@link TbRuleChainInputNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainInputNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRuleChainInputNodeConfiguration.equals(Object)",
    "int TbRuleChainInputNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRuleChainInputNodeConfiguration(), null);
  }

  /**
   * Test {@link TbRuleChainInputNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainInputNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRuleChainInputNodeConfiguration.equals(Object)",
    "int TbRuleChainInputNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbRuleChainInputNodeConfiguration(),
        "Different type to TbRuleChainInputNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbRuleChainInputNodeConfiguration}
   *   <li>{@link TbRuleChainInputNodeConfiguration#setForwardMsgToDefaultRuleChain(boolean)}
   *   <li>{@link TbRuleChainInputNodeConfiguration#setRuleChainId(String)}
   *   <li>{@link TbRuleChainInputNodeConfiguration#toString()}
   *   <li>{@link TbRuleChainInputNodeConfiguration#getRuleChainId()}
   *   <li>{@link TbRuleChainInputNodeConfiguration#isForwardMsgToDefaultRuleChain()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbRuleChainInputNodeConfiguration.<init>()",
    "String TbRuleChainInputNodeConfiguration.getRuleChainId()",
    "boolean TbRuleChainInputNodeConfiguration.isForwardMsgToDefaultRuleChain()",
    "void TbRuleChainInputNodeConfiguration.setForwardMsgToDefaultRuleChain(boolean)",
    "void TbRuleChainInputNodeConfiguration.setRuleChainId(String)",
    "String TbRuleChainInputNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbRuleChainInputNodeConfiguration actualTbRuleChainInputNodeConfiguration =
        new TbRuleChainInputNodeConfiguration();
    actualTbRuleChainInputNodeConfiguration.setForwardMsgToDefaultRuleChain(true);
    actualTbRuleChainInputNodeConfiguration.setRuleChainId("42");
    String actualToStringResult = actualTbRuleChainInputNodeConfiguration.toString();
    String actualRuleChainId = actualTbRuleChainInputNodeConfiguration.getRuleChainId();

    // Assert
    assertEquals("42", actualRuleChainId);
    assertEquals(
        "TbRuleChainInputNodeConfiguration(ruleChainId=42, forwardMsgToDefaultRuleChain=true)",
        actualToStringResult);
    assertTrue(actualTbRuleChainInputNodeConfiguration.isForwardMsgToDefaultRuleChain());
  }
}
