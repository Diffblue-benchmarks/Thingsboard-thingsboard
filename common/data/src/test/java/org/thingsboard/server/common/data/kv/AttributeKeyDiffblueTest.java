package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AttributeKeyDiffblueTest {
  /**
   * Test {@link AttributeKey#equals(Object)}, and {@link AttributeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKey#equals(Object)}
   *   <li>{@link AttributeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttributeKey.equals(Object)", "int AttributeKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey("Scope", "Attribute Key");
    AttributeKey attributeKey2 = new AttributeKey("Scope", "Attribute Key");

    // Act and Assert
    assertEquals(attributeKey, attributeKey2);
    assertEquals(attributeKey.hashCode(), attributeKey2.hashCode());
  }

  /**
   * Test {@link AttributeKey#equals(Object)}, and {@link AttributeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKey#equals(Object)}
   *   <li>{@link AttributeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttributeKey.equals(Object)", "int AttributeKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey(null, "Attribute Key");
    AttributeKey attributeKey2 = new AttributeKey(null, "Attribute Key");

    // Act and Assert
    assertEquals(attributeKey, attributeKey2);
    assertEquals(attributeKey.hashCode(), attributeKey2.hashCode());
  }

  /**
   * Test {@link AttributeKey#equals(Object)}, and {@link AttributeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKey#equals(Object)}
   *   <li>{@link AttributeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttributeKey.equals(Object)", "int AttributeKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey("Scope", null);
    AttributeKey attributeKey2 = new AttributeKey("Scope", null);

    // Act and Assert
    assertEquals(attributeKey, attributeKey2);
    assertEquals(attributeKey.hashCode(), attributeKey2.hashCode());
  }

  /**
   * Test {@link AttributeKey#equals(Object)}, and {@link AttributeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKey#equals(Object)}
   *   <li>{@link AttributeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttributeKey.equals(Object)", "int AttributeKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey("Scope", "Attribute Key");

    // Act and Assert
    assertEquals(attributeKey, attributeKey);
    int expectedHashCodeResult = attributeKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeKey.hashCode());
  }

  /**
   * Test {@link AttributeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttributeKey.equals(Object)", "int AttributeKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey("Attribute Key", "Attribute Key");

    // Act and Assert
    assertNotEquals(attributeKey, new AttributeKey("Scope", "Attribute Key"));
  }

  /**
   * Test {@link AttributeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttributeKey.equals(Object)", "int AttributeKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey(null, "Attribute Key");

    // Act and Assert
    assertNotEquals(attributeKey, new AttributeKey("Scope", "Attribute Key"));
  }

  /**
   * Test {@link AttributeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttributeKey.equals(Object)", "int AttributeKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey("Scope", "Scope");

    // Act and Assert
    assertNotEquals(attributeKey, new AttributeKey("Scope", "Attribute Key"));
  }

  /**
   * Test {@link AttributeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttributeKey.equals(Object)", "int AttributeKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey("Scope", null);

    // Act and Assert
    assertNotEquals(attributeKey, new AttributeKey("Scope", "Attribute Key"));
  }

  /**
   * Test {@link AttributeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttributeKey.equals(Object)", "int AttributeKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributeKey("Scope", "Attribute Key"), null);
  }

  /**
   * Test {@link AttributeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttributeKey.equals(Object)", "int AttributeKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributeKey("Scope", "Attribute Key"), "Different type to AttributeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKey#AttributeKey(String, String)}
   *   <li>{@link AttributeKey#toString()}
   *   <li>{@link AttributeKey#getAttributeKey()}
   *   <li>{@link AttributeKey#getScope()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKey.<init>(String, String)",
    "String AttributeKey.getAttributeKey()",
    "String AttributeKey.getScope()",
    "String AttributeKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AttributeKey actualAttributeKey = new AttributeKey("Scope", "Attribute Key");
    String actualToStringResult = actualAttributeKey.toString();
    String actualAttributeKey2 = actualAttributeKey.getAttributeKey();

    // Assert
    assertEquals("Attribute Key", actualAttributeKey2);
    assertEquals("AttributeKey(scope=Scope, attributeKey=Attribute Key)", actualToStringResult);
    assertEquals("Scope", actualAttributeKey.getScope());
  }
}
