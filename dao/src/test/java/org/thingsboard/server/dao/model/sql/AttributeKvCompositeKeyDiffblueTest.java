package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.dao.model.ModelConstants;

class AttributeKvCompositeKeyDiffblueTest {
  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}, and {@link
   * AttributeKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#equals(Object)}
   *   <li>{@link AttributeKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
    assertEquals(attributeKvCompositeKey.hashCode(), attributeKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}, and {@link
   * AttributeKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#equals(Object)}
   *   <li>{@link AttributeKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(null);

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(null);

    // Act and Assert
    assertEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
    assertEquals(attributeKvCompositeKey.hashCode(), attributeKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}, and {@link
   * AttributeKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#equals(Object)}
   *   <li>{@link AttributeKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(attributeKvCompositeKey, attributeKvCompositeKey);
    int expectedHashCodeResult = attributeKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeKvCompositeKey.hashCode());
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(3);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(3);
    attributeKvCompositeKey.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(null);

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, null);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, "Different type to AttributeKvCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#AttributeKvCompositeKey()}
   *   <li>{@link AttributeKvCompositeKey#setAttributeKey(int)}
   *   <li>{@link AttributeKvCompositeKey#setAttributeType(int)}
   *   <li>{@link AttributeKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link AttributeKvCompositeKey#toString()}
   *   <li>{@link AttributeKvCompositeKey#getAttributeKey()}
   *   <li>{@link AttributeKvCompositeKey#getAttributeType()}
   *   <li>{@link AttributeKvCompositeKey#getEntityId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvCompositeKey.<init>()",
    "void AttributeKvCompositeKey.<init>(UUID, int, int)",
    "int AttributeKvCompositeKey.getAttributeKey()",
    "int AttributeKvCompositeKey.getAttributeType()",
    "UUID AttributeKvCompositeKey.getEntityId()",
    "void AttributeKvCompositeKey.setAttributeKey(int)",
    "void AttributeKvCompositeKey.setAttributeType(int)",
    "void AttributeKvCompositeKey.setEntityId(UUID)",
    "String AttributeKvCompositeKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AttributeKvCompositeKey actualAttributeKvCompositeKey = new AttributeKvCompositeKey();
    actualAttributeKvCompositeKey.setAttributeKey(1);
    actualAttributeKvCompositeKey.setAttributeType(1);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualAttributeKvCompositeKey.setEntityId(entityId);
    String actualToStringResult = actualAttributeKvCompositeKey.toString();
    int actualAttributeKey = actualAttributeKvCompositeKey.getAttributeKey();
    int actualAttributeType = actualAttributeKvCompositeKey.getAttributeType();
    UUID actualEntityId = actualAttributeKvCompositeKey.getEntityId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals(
        "AttributeKvCompositeKey(entityId=784f394c-42b6-435a-983c-b7beff2784f9, attributeType=1,"
            + " attributeKey=1)",
        actualToStringResult);
    assertEquals(1, actualAttributeKey);
    assertEquals(1, actualAttributeType);
    assertSame(entityId, actualEntityId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#AttributeKvCompositeKey(UUID, int, int)}
   *   <li>{@link AttributeKvCompositeKey#setAttributeKey(int)}
   *   <li>{@link AttributeKvCompositeKey#setAttributeType(int)}
   *   <li>{@link AttributeKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link AttributeKvCompositeKey#toString()}
   *   <li>{@link AttributeKvCompositeKey#getAttributeKey()}
   *   <li>{@link AttributeKvCompositeKey#getAttributeType()}
   *   <li>{@link AttributeKvCompositeKey#getEntityId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvCompositeKey.<init>()",
    "void AttributeKvCompositeKey.<init>(UUID, int, int)",
    "int AttributeKvCompositeKey.getAttributeKey()",
    "int AttributeKvCompositeKey.getAttributeType()",
    "UUID AttributeKvCompositeKey.getEntityId()",
    "void AttributeKvCompositeKey.setAttributeKey(int)",
    "void AttributeKvCompositeKey.setAttributeType(int)",
    "void AttributeKvCompositeKey.setEntityId(UUID)",
    "String AttributeKvCompositeKey.toString()"
  })
  void testGettersAndSetters_whenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange and Act
    AttributeKvCompositeKey actualAttributeKvCompositeKey =
        new AttributeKvCompositeKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1, 1);
    actualAttributeKvCompositeKey.setAttributeKey(1);
    actualAttributeKvCompositeKey.setAttributeType(1);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualAttributeKvCompositeKey.setEntityId(entityId);
    String actualToStringResult = actualAttributeKvCompositeKey.toString();
    int actualAttributeKey = actualAttributeKvCompositeKey.getAttributeKey();
    int actualAttributeType = actualAttributeKvCompositeKey.getAttributeType();
    UUID actualEntityId = actualAttributeKvCompositeKey.getEntityId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals(
        "AttributeKvCompositeKey(entityId=784f394c-42b6-435a-983c-b7beff2784f9, attributeType=1,"
            + " attributeKey=1)",
        actualToStringResult);
    assertEquals(1, actualAttributeKey);
    assertEquals(1, actualAttributeType);
    assertSame(entityId, actualEntityId);
  }
}
