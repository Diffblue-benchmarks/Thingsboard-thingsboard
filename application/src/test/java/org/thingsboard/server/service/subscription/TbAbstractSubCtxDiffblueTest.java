package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.DynamicValueSourceType;
import org.thingsboard.server.common.data.query.FilterPredicateType;
import org.thingsboard.server.service.subscription.TbAbstractSubCtx.DynamicValueKey;

class TbAbstractSubCtxDiffblueTest {
  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}, and {@link DynamicValueKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValueKey#equals(Object)}
   *   <li>{@link DynamicValueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DynamicValueKey.equals(Object)", "int DynamicValueKey.hashCode()"})
  void testDynamicValueKeyEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DynamicValueKey dynamicValueKey = new DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    DynamicValueKey dynamicValueKey2 = new DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertEquals(dynamicValueKey, dynamicValueKey2);
    int expectedHashCodeResult = dynamicValueKey.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValueKey2.hashCode());
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}, and {@link DynamicValueKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValueKey#equals(Object)}
   *   <li>{@link DynamicValueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DynamicValueKey.equals(Object)", "int DynamicValueKey.hashCode()"})
  void testDynamicValueKeyEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DynamicValueKey dynamicValueKey = new DynamicValueKey(null, DynamicValueSourceType.CURRENT_TENANT,
        "Source Attribute");
    DynamicValueKey dynamicValueKey2 = new DynamicValueKey(null, DynamicValueSourceType.CURRENT_TENANT,
        "Source Attribute");

    // Act and Assert
    assertEquals(dynamicValueKey, dynamicValueKey2);
    int expectedHashCodeResult = dynamicValueKey.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValueKey2.hashCode());
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}, and {@link DynamicValueKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValueKey#equals(Object)}
   *   <li>{@link DynamicValueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DynamicValueKey.equals(Object)", "int DynamicValueKey.hashCode()"})
  void testDynamicValueKeyEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DynamicValueKey dynamicValueKey = new DynamicValueKey(FilterPredicateType.STRING, null, "Source Attribute");
    DynamicValueKey dynamicValueKey2 = new DynamicValueKey(FilterPredicateType.STRING, null, "Source Attribute");

    // Act and Assert
    assertEquals(dynamicValueKey, dynamicValueKey2);
    int expectedHashCodeResult = dynamicValueKey.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValueKey2.hashCode());
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}, and {@link DynamicValueKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValueKey#equals(Object)}
   *   <li>{@link DynamicValueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DynamicValueKey.equals(Object)", "int DynamicValueKey.hashCode()"})
  void testDynamicValueKeyEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DynamicValueKey dynamicValueKey = new DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, null);
    DynamicValueKey dynamicValueKey2 = new DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, null);

    // Act and Assert
    assertEquals(dynamicValueKey, dynamicValueKey2);
    int expectedHashCodeResult = dynamicValueKey.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValueKey2.hashCode());
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}, and {@link DynamicValueKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValueKey#equals(Object)}
   *   <li>{@link DynamicValueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DynamicValueKey.equals(Object)", "int DynamicValueKey.hashCode()"})
  void testDynamicValueKeyEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DynamicValueKey dynamicValueKey = new DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertEquals(dynamicValueKey, dynamicValueKey);
    int expectedHashCodeResult = dynamicValueKey.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValueKey.hashCode());
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DynamicValueKey.equals(Object)", "int DynamicValueKey.hashCode()"})
  void testDynamicValueKeyEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DynamicValueKey dynamicValueKey = new DynamicValueKey(null, DynamicValueSourceType.CURRENT_TENANT,
        "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValueKey,
        new DynamicValueKey(FilterPredicateType.STRING, DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DynamicValueKey.equals(Object)", "int DynamicValueKey.hashCode()"})
  void testDynamicValueKeyEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DynamicValueKey dynamicValueKey = new DynamicValueKey(FilterPredicateType.NUMERIC,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValueKey,
        new DynamicValueKey(FilterPredicateType.STRING, DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DynamicValueKey.equals(Object)", "int DynamicValueKey.hashCode()"})
  void testDynamicValueKeyEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DynamicValueKey dynamicValueKey = new DynamicValueKey(FilterPredicateType.STRING, null, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValueKey,
        new DynamicValueKey(FilterPredicateType.STRING, DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DynamicValueKey.equals(Object)", "int DynamicValueKey.hashCode()"})
  void testDynamicValueKeyEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DynamicValueKey dynamicValueKey = new DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_CUSTOMER, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValueKey,
        new DynamicValueKey(FilterPredicateType.STRING, DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DynamicValueKey.equals(Object)", "int DynamicValueKey.hashCode()"})
  void testDynamicValueKeyEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DynamicValueKey dynamicValueKey = new DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, null);

    // Act and Assert
    assertNotEquals(dynamicValueKey,
        new DynamicValueKey(FilterPredicateType.STRING, DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DynamicValueKey.equals(Object)", "int DynamicValueKey.hashCode()"})
  void testDynamicValueKeyEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DynamicValueKey dynamicValueKey = new DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT,
        "org.thingsboard.server.service.subscription.TbAbstractSubCtx$DynamicValueKey");

    // Act and Assert
    assertNotEquals(dynamicValueKey,
        new DynamicValueKey(FilterPredicateType.STRING, DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DynamicValueKey.equals(Object)", "int DynamicValueKey.hashCode()"})
  void testDynamicValueKeyEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DynamicValueKey(FilterPredicateType.STRING, DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"),
        null);
  }

  /**
   * Test DynamicValueKey {@link DynamicValueKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test DynamicValueKey equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DynamicValueKey.equals(Object)", "int DynamicValueKey.hashCode()"})
  void testDynamicValueKeyEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DynamicValueKey(FilterPredicateType.STRING, DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"),
        "Different type to DynamicValueKey");
  }

  /**
   * Test DynamicValueKey getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValueKey#DynamicValueKey(FilterPredicateType, DynamicValueSourceType, String)}
   *   <li>{@link DynamicValueKey#toString()}
   *   <li>{@link DynamicValueKey#getPredicateType()}
   *   <li>{@link DynamicValueKey#getSourceAttribute()}
   *   <li>{@link DynamicValueKey#getSourceType()}
   * </ul>
   */
  @Test
  @DisplayName("Test DynamicValueKey getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DynamicValueKey.<init>(FilterPredicateType, DynamicValueSourceType, String)",
      "FilterPredicateType DynamicValueKey.getPredicateType()", "String DynamicValueKey.getSourceAttribute()",
      "DynamicValueSourceType DynamicValueKey.getSourceType()", "String DynamicValueKey.toString()"})
  void testDynamicValueKeyGettersAndSetters() {
    // Arrange and Act
    DynamicValueKey actualDynamicValueKey = new DynamicValueKey(FilterPredicateType.STRING,
        DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    String actualToStringResult = actualDynamicValueKey.toString();
    FilterPredicateType actualPredicateType = actualDynamicValueKey.getPredicateType();
    String actualSourceAttribute = actualDynamicValueKey.getSourceAttribute();

    // Assert
    assertEquals("Source Attribute", actualSourceAttribute);
    assertEquals(
        "TbAbstractSubCtx.DynamicValueKey(predicateType=STRING, sourceType=CURRENT_TENANT, sourceAttribute=Source"
            + " Attribute)",
        actualToStringResult);
    assertEquals(DynamicValueSourceType.CURRENT_TENANT, actualDynamicValueKey.getSourceType());
    assertEquals(FilterPredicateType.STRING, actualPredicateType);
  }
}
