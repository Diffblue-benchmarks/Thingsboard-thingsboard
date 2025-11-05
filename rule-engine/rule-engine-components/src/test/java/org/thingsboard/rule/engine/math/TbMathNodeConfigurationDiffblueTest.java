package org.thingsboard.rule.engine.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMathNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMathNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbMathNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMathNodeConfiguration TbMathNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration() {
    // Arrange and Act
    TbMathNodeConfiguration actualDefaultConfigurationResult =
        new TbMathNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals("(x - 32) / 1.8", actualDefaultConfigurationResult.getCustomFunction());
    List<TbMathArgument> arguments = actualDefaultConfigurationResult.getArguments();
    assertEquals(1, arguments.size());
    TbMathArgument getResult = arguments.get(0);
    assertEquals("temperature", getResult.getKey());
    TbMathResult result = actualDefaultConfigurationResult.getResult();
    assertEquals("temperatureCelsius", result.getKey());
    assertEquals("x", getResult.getName());
    assertNull(getResult.getDefaultValue());
    assertNull(getResult.getAttributeScope());
    assertNull(result.getAttributeScope());
    assertEquals(2, result.getResultValuePrecision());
    assertEquals(TbMathArgumentType.MESSAGE_BODY, getResult.getType());
    assertEquals(TbMathArgumentType.MESSAGE_BODY, result.getType());
    assertEquals(
        TbRuleNodeMathFunctionType.CUSTOM, actualDefaultConfigurationResult.getOperation());
    assertFalse(result.isAddToBody());
    assertFalse(result.isAddToMetadata());
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}, and {@link
   * TbMathNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathNodeConfiguration#equals(Object)}
   *   <li>{@link TbMathNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();
    TbMathNodeConfiguration tbMathNodeConfiguration2 = new TbMathNodeConfiguration();

    // Act and Assert
    assertEquals(tbMathNodeConfiguration, tbMathNodeConfiguration2);
    assertEquals(tbMathNodeConfiguration.hashCode(), tbMathNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}, and {@link
   * TbMathNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathNodeConfiguration#equals(Object)}
   *   <li>{@link TbMathNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();
    tbMathNodeConfiguration.setOperation(TbRuleNodeMathFunctionType.ADD);

    TbMathNodeConfiguration tbMathNodeConfiguration2 = new TbMathNodeConfiguration();
    tbMathNodeConfiguration2.setOperation(TbRuleNodeMathFunctionType.ADD);

    // Act and Assert
    assertEquals(tbMathNodeConfiguration, tbMathNodeConfiguration2);
    assertEquals(tbMathNodeConfiguration.hashCode(), tbMathNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}, and {@link
   * TbMathNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathNodeConfiguration#equals(Object)}
   *   <li>{@link TbMathNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();
    tbMathNodeConfiguration.setArguments(new ArrayList<>());

    TbMathNodeConfiguration tbMathNodeConfiguration2 = new TbMathNodeConfiguration();
    tbMathNodeConfiguration2.setArguments(new ArrayList<>());

    // Act and Assert
    assertEquals(tbMathNodeConfiguration, tbMathNodeConfiguration2);
    assertEquals(tbMathNodeConfiguration.hashCode(), tbMathNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}, and {@link
   * TbMathNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathNodeConfiguration#equals(Object)}
   *   <li>{@link TbMathNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();
    tbMathNodeConfiguration.setCustomFunction("Custom Function");

    TbMathNodeConfiguration tbMathNodeConfiguration2 = new TbMathNodeConfiguration();
    tbMathNodeConfiguration2.setCustomFunction("Custom Function");

    // Act and Assert
    assertEquals(tbMathNodeConfiguration, tbMathNodeConfiguration2);
    assertEquals(tbMathNodeConfiguration.hashCode(), tbMathNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}, and {@link
   * TbMathNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathNodeConfiguration#equals(Object)}
   *   <li>{@link TbMathNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();
    TbMathResult result =
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope");
    tbMathNodeConfiguration.setResult(result);

    TbMathNodeConfiguration tbMathNodeConfiguration2 = new TbMathNodeConfiguration();
    TbMathResult result2 =
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope");
    tbMathNodeConfiguration2.setResult(result2);

    // Act and Assert
    assertEquals(tbMathNodeConfiguration, tbMathNodeConfiguration2);
    assertEquals(tbMathNodeConfiguration.hashCode(), tbMathNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}, and {@link
   * TbMathNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathNodeConfiguration#equals(Object)}
   *   <li>{@link TbMathNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();

    // Act and Assert
    assertEquals(tbMathNodeConfiguration, tbMathNodeConfiguration);
    int expectedHashCodeResult = tbMathNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMathNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMathNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();
    tbMathNodeConfiguration.setOperation(TbRuleNodeMathFunctionType.ADD);

    // Act and Assert
    assertNotEquals(tbMathNodeConfiguration, new TbMathNodeConfiguration());
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();
    tbMathNodeConfiguration.setArguments(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbMathNodeConfiguration, new TbMathNodeConfiguration());
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();
    tbMathNodeConfiguration.setCustomFunction("Custom Function");

    // Act and Assert
    assertNotEquals(tbMathNodeConfiguration, new TbMathNodeConfiguration());
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();
    TbMathResult result =
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope");
    tbMathNodeConfiguration.setResult(result);

    // Act and Assert
    assertNotEquals(tbMathNodeConfiguration, new TbMathNodeConfiguration());
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();

    TbMathNodeConfiguration tbMathNodeConfiguration2 = new TbMathNodeConfiguration();
    tbMathNodeConfiguration2.setOperation(TbRuleNodeMathFunctionType.ADD);

    // Act and Assert
    assertNotEquals(tbMathNodeConfiguration, tbMathNodeConfiguration2);
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();

    TbMathNodeConfiguration tbMathNodeConfiguration2 = new TbMathNodeConfiguration();
    tbMathNodeConfiguration2.setArguments(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbMathNodeConfiguration, tbMathNodeConfiguration2);
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();

    TbMathNodeConfiguration tbMathNodeConfiguration2 = new TbMathNodeConfiguration();
    tbMathNodeConfiguration2.setCustomFunction("Custom Function");

    // Act and Assert
    assertNotEquals(tbMathNodeConfiguration, tbMathNodeConfiguration2);
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();

    TbMathNodeConfiguration tbMathNodeConfiguration2 = new TbMathNodeConfiguration();
    TbMathResult result =
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope");
    tbMathNodeConfiguration2.setResult(result);

    // Act and Assert
    assertNotEquals(tbMathNodeConfiguration, tbMathNodeConfiguration2);
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMathNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMathNodeConfiguration.equals(Object)",
    "int TbMathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMathNodeConfiguration(), "Different type to TbMathNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMathNodeConfiguration}
   *   <li>{@link TbMathNodeConfiguration#setArguments(List)}
   *   <li>{@link TbMathNodeConfiguration#setCustomFunction(String)}
   *   <li>{@link TbMathNodeConfiguration#setOperation(TbRuleNodeMathFunctionType)}
   *   <li>{@link TbMathNodeConfiguration#setResult(TbMathResult)}
   *   <li>{@link TbMathNodeConfiguration#toString()}
   *   <li>{@link TbMathNodeConfiguration#getArguments()}
   *   <li>{@link TbMathNodeConfiguration#getCustomFunction()}
   *   <li>{@link TbMathNodeConfiguration#getOperation()}
   *   <li>{@link TbMathNodeConfiguration#getResult()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbMathNodeConfiguration.<init>()",
    "List TbMathNodeConfiguration.getArguments()",
    "String TbMathNodeConfiguration.getCustomFunction()",
    "TbRuleNodeMathFunctionType TbMathNodeConfiguration.getOperation()",
    "TbMathResult TbMathNodeConfiguration.getResult()",
    "void TbMathNodeConfiguration.setArguments(List)",
    "void TbMathNodeConfiguration.setCustomFunction(String)",
    "void TbMathNodeConfiguration.setOperation(TbRuleNodeMathFunctionType)",
    "void TbMathNodeConfiguration.setResult(TbMathResult)",
    "String TbMathNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbMathNodeConfiguration actualTbMathNodeConfiguration = new TbMathNodeConfiguration();
    ArrayList<TbMathArgument> arguments = new ArrayList<>();
    actualTbMathNodeConfiguration.setArguments(arguments);
    actualTbMathNodeConfiguration.setCustomFunction("Custom Function");
    actualTbMathNodeConfiguration.setOperation(TbRuleNodeMathFunctionType.ADD);
    TbMathResult result =
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope");
    actualTbMathNodeConfiguration.setResult(result);
    String actualToStringResult = actualTbMathNodeConfiguration.toString();
    List<TbMathArgument> actualArguments = actualTbMathNodeConfiguration.getArguments();
    String actualCustomFunction = actualTbMathNodeConfiguration.getCustomFunction();
    TbRuleNodeMathFunctionType actualOperation = actualTbMathNodeConfiguration.getOperation();
    TbMathResult actualResult = actualTbMathNodeConfiguration.getResult();

    // Assert
    assertEquals("Custom Function", actualCustomFunction);
    assertEquals(
        "TbMathNodeConfiguration(operation=ADD, arguments=[], customFunction=Custom Function, result=TbMathResult"
            + "(type=ATTRIBUTE, key=Key, resultValuePrecision=42, addToBody=true, addToMetadata=true, attributeScope"
            + "=Attribute Scope))",
        actualToStringResult);
    assertEquals(TbRuleNodeMathFunctionType.ADD, actualOperation);
    assertTrue(actualArguments.isEmpty());
    assertSame(arguments, actualArguments);
    assertSame(result, actualResult);
  }
}
