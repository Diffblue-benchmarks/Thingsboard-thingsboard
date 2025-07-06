package org.thingsboard.rule.engine.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMathArgumentDiffblueTest {
  /**
   * Test {@link TbMathArgument#equals(Object)}, and {@link TbMathArgument#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathArgument#equals(Object)}
   *   <li>{@link TbMathArgument#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    TbMathArgument tbMathArgument2 = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");

    // Act and Assert
    assertEquals(tbMathArgument, tbMathArgument2);
    int expectedHashCodeResult = tbMathArgument.hashCode();
    assertEquals(expectedHashCodeResult, tbMathArgument2.hashCode());
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}, and {@link TbMathArgument#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathArgument#equals(Object)}
   *   <li>{@link TbMathArgument#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(null, "Key");
    TbMathArgument tbMathArgument2 = new TbMathArgument(null, "Key");

    // Act and Assert
    assertEquals(tbMathArgument, tbMathArgument2);
    int expectedHashCodeResult = tbMathArgument.hashCode();
    assertEquals(expectedHashCodeResult, tbMathArgument2.hashCode());
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}, and {@link TbMathArgument#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathArgument#equals(Object)}
   *   <li>{@link TbMathArgument#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, null);
    TbMathArgument tbMathArgument2 = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, null);

    // Act and Assert
    assertEquals(tbMathArgument, tbMathArgument2);
    int expectedHashCodeResult = tbMathArgument.hashCode();
    assertEquals(expectedHashCodeResult, tbMathArgument2.hashCode());
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}, and {@link TbMathArgument#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathArgument#equals(Object)}
   *   <li>{@link TbMathArgument#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    tbMathArgument.setAttributeScope("Key");

    TbMathArgument tbMathArgument2 = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    tbMathArgument2.setAttributeScope("Key");

    // Act and Assert
    assertEquals(tbMathArgument, tbMathArgument2);
    int expectedHashCodeResult = tbMathArgument.hashCode();
    assertEquals(expectedHashCodeResult, tbMathArgument2.hashCode());
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}, and {@link TbMathArgument#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathArgument#equals(Object)}
   *   <li>{@link TbMathArgument#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    tbMathArgument.setDefaultValue(10.0d);

    TbMathArgument tbMathArgument2 = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    tbMathArgument2.setDefaultValue(10.0d);

    // Act and Assert
    assertEquals(tbMathArgument, tbMathArgument2);
    int expectedHashCodeResult = tbMathArgument.hashCode();
    assertEquals(expectedHashCodeResult, tbMathArgument2.hashCode());
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}, and {@link TbMathArgument#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathArgument#equals(Object)}
   *   <li>{@link TbMathArgument#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");

    // Act and Assert
    assertEquals(tbMathArgument, tbMathArgument);
    int expectedHashCodeResult = tbMathArgument.hashCode();
    assertEquals(expectedHashCodeResult, tbMathArgument.hashCode());
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(null, "Key");

    // Act and Assert
    assertNotEquals(tbMathArgument, new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.TIME_SERIES, "Key");

    // Act and Assert
    assertNotEquals(tbMathArgument, new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, null);

    // Act and Assert
    assertNotEquals(tbMathArgument, new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMathArgument tbMathArgument =
        new TbMathArgument(
            TbMathArgumentType.ATTRIBUTE, "org.thingsboard.rule.engine.math.TbMathArgument");

    // Act and Assert
    assertNotEquals(tbMathArgument, new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    tbMathArgument.setAttributeScope("Key");

    // Act and Assert
    assertNotEquals(tbMathArgument, new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    tbMathArgument.setDefaultValue(10.0d);

    // Act and Assert
    assertNotEquals(tbMathArgument, new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");

    TbMathArgument tbMathArgument2 = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    tbMathArgument2.setAttributeScope("Key");

    // Act and Assert
    assertNotEquals(tbMathArgument, tbMathArgument2);
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");

    TbMathArgument tbMathArgument2 = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    tbMathArgument2.setDefaultValue(10.0d);

    // Act and Assert
    assertNotEquals(tbMathArgument, tbMathArgument2);
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbMathArgument tbMathArgument =
        new TbMathArgument(
            TbMathArgumentType.ATTRIBUTE, "org.thingsboard.rule.engine.math.TbMathArgument");

    TbMathArgument tbMathArgument2 = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    tbMathArgument2.setName("org.thingsboard.rule.engine.math.TbMathArgument");

    // Act and Assert
    assertNotEquals(tbMathArgument, tbMathArgument2);
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, null);

    TbMathArgument tbMathArgument2 = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, null);
    tbMathArgument2.setKey("Key");

    // Act and Assert
    assertNotEquals(tbMathArgument, tbMathArgument2);
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key"), null);
  }

  /**
   * Test {@link TbMathArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMathArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMathArgument.equals(Object)", "int TbMathArgument.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key"),
        "Different type to TbMathArgument");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathArgument#TbMathArgument()}
   *   <li>{@link TbMathArgument#setAttributeScope(String)}
   *   <li>{@link TbMathArgument#setDefaultValue(Double)}
   *   <li>{@link TbMathArgument#setKey(String)}
   *   <li>{@link TbMathArgument#setName(String)}
   *   <li>{@link TbMathArgument#setType(TbMathArgumentType)}
   *   <li>{@link TbMathArgument#toString()}
   *   <li>{@link TbMathArgument#getAttributeScope()}
   *   <li>{@link TbMathArgument#getDefaultValue()}
   *   <li>{@link TbMathArgument#getKey()}
   *   <li>{@link TbMathArgument#getName()}
   *   <li>{@link TbMathArgument#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbMathArgument.<init>()",
    "void TbMathArgument.<init>(String, TbMathArgumentType, String)",
    "void TbMathArgument.<init>(String, TbMathArgumentType, String, String, Double)",
    "void TbMathArgument.<init>(TbMathArgumentType, String)",
    "String TbMathArgument.getAttributeScope()",
    "Double TbMathArgument.getDefaultValue()",
    "String TbMathArgument.getKey()",
    "String TbMathArgument.getName()",
    "TbMathArgumentType TbMathArgument.getType()",
    "void TbMathArgument.setAttributeScope(String)",
    "void TbMathArgument.setDefaultValue(Double)",
    "void TbMathArgument.setKey(String)",
    "void TbMathArgument.setName(String)",
    "void TbMathArgument.setType(TbMathArgumentType)",
    "String TbMathArgument.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbMathArgument actualTbMathArgument = new TbMathArgument();
    actualTbMathArgument.setAttributeScope("Attribute Scope");
    actualTbMathArgument.setDefaultValue(10.0d);
    actualTbMathArgument.setKey("Key");
    actualTbMathArgument.setName("Name");
    actualTbMathArgument.setType(TbMathArgumentType.ATTRIBUTE);
    String actualToStringResult = actualTbMathArgument.toString();
    String actualAttributeScope = actualTbMathArgument.getAttributeScope();
    Double actualDefaultValue = actualTbMathArgument.getDefaultValue();
    String actualKey = actualTbMathArgument.getKey();
    String actualName = actualTbMathArgument.getName();
    TbMathArgumentType actualType = actualTbMathArgument.getType();

    // Assert
    assertEquals("Attribute Scope", actualAttributeScope);
    assertEquals("Key", actualKey);
    assertEquals("Name", actualName);
    assertEquals(
        "TbMathArgument(name=Name, type=ATTRIBUTE, key=Key, attributeScope=Attribute Scope,"
            + " defaultValue=10.0)",
        actualToStringResult);
    assertEquals(10.0d, actualDefaultValue.doubleValue());
    assertEquals(TbMathArgumentType.ATTRIBUTE, actualType);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ATTRIBUTE}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathArgument#TbMathArgument(TbMathArgumentType, String)}
   *   <li>{@link TbMathArgument#setAttributeScope(String)}
   *   <li>{@link TbMathArgument#setDefaultValue(Double)}
   *   <li>{@link TbMathArgument#setKey(String)}
   *   <li>{@link TbMathArgument#setName(String)}
   *   <li>{@link TbMathArgument#setType(TbMathArgumentType)}
   *   <li>{@link TbMathArgument#toString()}
   *   <li>{@link TbMathArgument#getAttributeScope()}
   *   <li>{@link TbMathArgument#getDefaultValue()}
   *   <li>{@link TbMathArgument#getKey()}
   *   <li>{@link TbMathArgument#getName()}
   *   <li>{@link TbMathArgument#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'ATTRIBUTE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbMathArgument.<init>()",
    "void TbMathArgument.<init>(String, TbMathArgumentType, String)",
    "void TbMathArgument.<init>(String, TbMathArgumentType, String, String, Double)",
    "void TbMathArgument.<init>(TbMathArgumentType, String)",
    "String TbMathArgument.getAttributeScope()",
    "Double TbMathArgument.getDefaultValue()",
    "String TbMathArgument.getKey()",
    "String TbMathArgument.getName()",
    "TbMathArgumentType TbMathArgument.getType()",
    "void TbMathArgument.setAttributeScope(String)",
    "void TbMathArgument.setDefaultValue(Double)",
    "void TbMathArgument.setKey(String)",
    "void TbMathArgument.setName(String)",
    "void TbMathArgument.setType(TbMathArgumentType)",
    "String TbMathArgument.toString()"
  })
  void testGettersAndSetters_whenAttribute() {
    // Arrange and Act
    TbMathArgument actualTbMathArgument = new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key");
    actualTbMathArgument.setAttributeScope("Attribute Scope");
    actualTbMathArgument.setDefaultValue(10.0d);
    actualTbMathArgument.setKey("Key");
    actualTbMathArgument.setName("Name");
    actualTbMathArgument.setType(TbMathArgumentType.ATTRIBUTE);
    String actualToStringResult = actualTbMathArgument.toString();
    String actualAttributeScope = actualTbMathArgument.getAttributeScope();
    Double actualDefaultValue = actualTbMathArgument.getDefaultValue();
    String actualKey = actualTbMathArgument.getKey();
    String actualName = actualTbMathArgument.getName();
    TbMathArgumentType actualType = actualTbMathArgument.getType();

    // Assert
    assertEquals("Attribute Scope", actualAttributeScope);
    assertEquals("Key", actualKey);
    assertEquals("Name", actualName);
    assertEquals(
        "TbMathArgument(name=Name, type=ATTRIBUTE, key=Key, attributeScope=Attribute Scope,"
            + " defaultValue=10.0)",
        actualToStringResult);
    assertEquals(10.0d, actualDefaultValue.doubleValue());
    assertEquals(TbMathArgumentType.ATTRIBUTE, actualType);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Attribute Scope}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathArgument#TbMathArgument(String, TbMathArgumentType, String, String, Double)}
   *   <li>{@link TbMathArgument#setAttributeScope(String)}
   *   <li>{@link TbMathArgument#setDefaultValue(Double)}
   *   <li>{@link TbMathArgument#setKey(String)}
   *   <li>{@link TbMathArgument#setName(String)}
   *   <li>{@link TbMathArgument#setType(TbMathArgumentType)}
   *   <li>{@link TbMathArgument#toString()}
   *   <li>{@link TbMathArgument#getAttributeScope()}
   *   <li>{@link TbMathArgument#getDefaultValue()}
   *   <li>{@link TbMathArgument#getKey()}
   *   <li>{@link TbMathArgument#getName()}
   *   <li>{@link TbMathArgument#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Attribute Scope'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbMathArgument.<init>()",
    "void TbMathArgument.<init>(String, TbMathArgumentType, String)",
    "void TbMathArgument.<init>(String, TbMathArgumentType, String, String, Double)",
    "void TbMathArgument.<init>(TbMathArgumentType, String)",
    "String TbMathArgument.getAttributeScope()",
    "Double TbMathArgument.getDefaultValue()",
    "String TbMathArgument.getKey()",
    "String TbMathArgument.getName()",
    "TbMathArgumentType TbMathArgument.getType()",
    "void TbMathArgument.setAttributeScope(String)",
    "void TbMathArgument.setDefaultValue(Double)",
    "void TbMathArgument.setKey(String)",
    "void TbMathArgument.setName(String)",
    "void TbMathArgument.setType(TbMathArgumentType)",
    "String TbMathArgument.toString()"
  })
  void testGettersAndSetters_whenAttributeScope() {
    // Arrange and Act
    TbMathArgument actualTbMathArgument =
        new TbMathArgument("Name", TbMathArgumentType.ATTRIBUTE, "Key", "Attribute Scope", 10.0d);
    actualTbMathArgument.setAttributeScope("Attribute Scope");
    actualTbMathArgument.setDefaultValue(10.0d);
    actualTbMathArgument.setKey("Key");
    actualTbMathArgument.setName("Name");
    actualTbMathArgument.setType(TbMathArgumentType.ATTRIBUTE);
    String actualToStringResult = actualTbMathArgument.toString();
    String actualAttributeScope = actualTbMathArgument.getAttributeScope();
    Double actualDefaultValue = actualTbMathArgument.getDefaultValue();
    String actualKey = actualTbMathArgument.getKey();
    String actualName = actualTbMathArgument.getName();
    TbMathArgumentType actualType = actualTbMathArgument.getType();

    // Assert
    assertEquals("Attribute Scope", actualAttributeScope);
    assertEquals("Key", actualKey);
    assertEquals("Name", actualName);
    assertEquals(
        "TbMathArgument(name=Name, type=ATTRIBUTE, key=Key, attributeScope=Attribute Scope,"
            + " defaultValue=10.0)",
        actualToStringResult);
    assertEquals(10.0d, actualDefaultValue.doubleValue());
    assertEquals(TbMathArgumentType.ATTRIBUTE, actualType);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMathArgument#TbMathArgument(String, TbMathArgumentType, String)}
   *   <li>{@link TbMathArgument#setAttributeScope(String)}
   *   <li>{@link TbMathArgument#setDefaultValue(Double)}
   *   <li>{@link TbMathArgument#setKey(String)}
   *   <li>{@link TbMathArgument#setName(String)}
   *   <li>{@link TbMathArgument#setType(TbMathArgumentType)}
   *   <li>{@link TbMathArgument#toString()}
   *   <li>{@link TbMathArgument#getAttributeScope()}
   *   <li>{@link TbMathArgument#getDefaultValue()}
   *   <li>{@link TbMathArgument#getKey()}
   *   <li>{@link TbMathArgument#getName()}
   *   <li>{@link TbMathArgument#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbMathArgument.<init>()",
    "void TbMathArgument.<init>(String, TbMathArgumentType, String)",
    "void TbMathArgument.<init>(String, TbMathArgumentType, String, String, Double)",
    "void TbMathArgument.<init>(TbMathArgumentType, String)",
    "String TbMathArgument.getAttributeScope()",
    "Double TbMathArgument.getDefaultValue()",
    "String TbMathArgument.getKey()",
    "String TbMathArgument.getName()",
    "TbMathArgumentType TbMathArgument.getType()",
    "void TbMathArgument.setAttributeScope(String)",
    "void TbMathArgument.setDefaultValue(Double)",
    "void TbMathArgument.setKey(String)",
    "void TbMathArgument.setName(String)",
    "void TbMathArgument.setType(TbMathArgumentType)",
    "String TbMathArgument.toString()"
  })
  void testGettersAndSetters_whenName() {
    // Arrange and Act
    TbMathArgument actualTbMathArgument =
        new TbMathArgument("Name", TbMathArgumentType.ATTRIBUTE, "Key");
    actualTbMathArgument.setAttributeScope("Attribute Scope");
    actualTbMathArgument.setDefaultValue(10.0d);
    actualTbMathArgument.setKey("Key");
    actualTbMathArgument.setName("Name");
    actualTbMathArgument.setType(TbMathArgumentType.ATTRIBUTE);
    String actualToStringResult = actualTbMathArgument.toString();
    String actualAttributeScope = actualTbMathArgument.getAttributeScope();
    Double actualDefaultValue = actualTbMathArgument.getDefaultValue();
    String actualKey = actualTbMathArgument.getKey();
    String actualName = actualTbMathArgument.getName();
    TbMathArgumentType actualType = actualTbMathArgument.getType();

    // Assert
    assertEquals("Attribute Scope", actualAttributeScope);
    assertEquals("Key", actualKey);
    assertEquals("Name", actualName);
    assertEquals(
        "TbMathArgument(name=Name, type=ATTRIBUTE, key=Key, attributeScope=Attribute Scope,"
            + " defaultValue=10.0)",
        actualToStringResult);
    assertEquals(10.0d, actualDefaultValue.doubleValue());
    assertEquals(TbMathArgumentType.ATTRIBUTE, actualType);
  }
}
