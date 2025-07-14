package org.thingsboard.server.dao.attributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

class AttributeCacheKeyDiffblueTest {
  /**
   * Test {@link AttributeCacheKey#equals(Object)}, and {@link AttributeCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeCacheKey#equals(Object)}
   *   <li>{@link AttributeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AttributeCacheKey.equals(Object)",
    "int AttributeCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributeCacheKey attributeCacheKey =
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, "Key");
    AttributeCacheKey attributeCacheKey2 =
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Act and Assert
    assertEquals(attributeCacheKey, attributeCacheKey2);
    int expectedHashCodeResult = attributeCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeCacheKey2.hashCode());
  }

  /**
   * Test {@link AttributeCacheKey#equals(Object)}, and {@link AttributeCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeCacheKey#equals(Object)}
   *   <li>{@link AttributeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AttributeCacheKey.equals(Object)",
    "int AttributeCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AttributeCacheKey attributeCacheKey =
        new AttributeCacheKey(null, BaseEntityService.NULL_CUSTOMER_ID, "Key");
    AttributeCacheKey attributeCacheKey2 =
        new AttributeCacheKey(null, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Act and Assert
    assertEquals(attributeCacheKey, attributeCacheKey2);
    int expectedHashCodeResult = attributeCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeCacheKey2.hashCode());
  }

  /**
   * Test {@link AttributeCacheKey#equals(Object)}, and {@link AttributeCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeCacheKey#equals(Object)}
   *   <li>{@link AttributeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AttributeCacheKey.equals(Object)",
    "int AttributeCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AttributeCacheKey attributeCacheKey =
        new AttributeCacheKey(AttributeScope.CLIENT_SCOPE, null, "Key");
    AttributeCacheKey attributeCacheKey2 =
        new AttributeCacheKey(AttributeScope.CLIENT_SCOPE, null, "Key");

    // Act and Assert
    assertEquals(attributeCacheKey, attributeCacheKey2);
    int expectedHashCodeResult = attributeCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeCacheKey2.hashCode());
  }

  /**
   * Test {@link AttributeCacheKey#equals(Object)}, and {@link AttributeCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeCacheKey#equals(Object)}
   *   <li>{@link AttributeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AttributeCacheKey.equals(Object)",
    "int AttributeCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AttributeCacheKey attributeCacheKey =
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, null);
    AttributeCacheKey attributeCacheKey2 =
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, null);

    // Act and Assert
    assertEquals(attributeCacheKey, attributeCacheKey2);
    int expectedHashCodeResult = attributeCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeCacheKey2.hashCode());
  }

  /**
   * Test {@link AttributeCacheKey#equals(Object)}, and {@link AttributeCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeCacheKey#equals(Object)}
   *   <li>{@link AttributeCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AttributeCacheKey.equals(Object)",
    "int AttributeCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributeCacheKey attributeCacheKey =
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Act and Assert
    assertEquals(attributeCacheKey, attributeCacheKey);
    int expectedHashCodeResult = attributeCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeCacheKey.hashCode());
  }

  /**
   * Test {@link AttributeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AttributeCacheKey.equals(Object)",
    "int AttributeCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AttributeCacheKey attributeCacheKey =
        new AttributeCacheKey(null, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Act and Assert
    assertNotEquals(
        attributeCacheKey,
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, "Key"));
  }

  /**
   * Test {@link AttributeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AttributeCacheKey.equals(Object)",
    "int AttributeCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AttributeCacheKey attributeCacheKey =
        new AttributeCacheKey(
            AttributeScope.SERVER_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Act and Assert
    assertNotEquals(
        attributeCacheKey,
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, "Key"));
  }

  /**
   * Test {@link AttributeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AttributeCacheKey.equals(Object)",
    "int AttributeCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AttributeCacheKey attributeCacheKey =
        new AttributeCacheKey(AttributeScope.CLIENT_SCOPE, ModelConstants.SYSTEM_TENANT, "Key");

    // Act and Assert
    assertNotEquals(
        attributeCacheKey,
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, "Key"));
  }

  /**
   * Test {@link AttributeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AttributeCacheKey.equals(Object)",
    "int AttributeCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AttributeCacheKey attributeCacheKey =
        new AttributeCacheKey(AttributeScope.CLIENT_SCOPE, null, "Key");

    // Act and Assert
    assertNotEquals(
        attributeCacheKey,
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, "Key"));
  }

  /**
   * Test {@link AttributeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AttributeCacheKey.equals(Object)",
    "int AttributeCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AttributeCacheKey attributeCacheKey =
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, null);

    // Act and Assert
    assertNotEquals(
        attributeCacheKey,
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, "Key"));
  }

  /**
   * Test {@link AttributeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AttributeCacheKey.equals(Object)",
    "int AttributeCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AttributeCacheKey attributeCacheKey =
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE,
            BaseEntityService.NULL_CUSTOMER_ID,
            "org.thingsboard.server.dao.attributes.AttributeCacheKey");

    // Act and Assert
    assertNotEquals(
        attributeCacheKey,
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, "Key"));
  }

  /**
   * Test {@link AttributeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AttributeCacheKey.equals(Object)",
    "int AttributeCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, "Key"),
        null);
  }

  /**
   * Test {@link AttributeCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AttributeCacheKey.equals(Object)",
    "int AttributeCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AttributeCacheKey(
            AttributeScope.CLIENT_SCOPE, BaseEntityService.NULL_CUSTOMER_ID, "Key"),
        "Different type to AttributeCacheKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeCacheKey#AttributeCacheKey(AttributeScope, EntityId, String)}
   *   <li>{@link AttributeCacheKey#toString()}
   *   <li>{@link AttributeCacheKey#getEntityId()}
   *   <li>{@link AttributeCacheKey#getKey()}
   *   <li>{@link AttributeCacheKey#getScope()}
   *   <li>{@link AttributeCacheKey#isVersioned()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AttributeCacheKey.<init>(AttributeScope, EntityId, String)",
    "EntityId AttributeCacheKey.getEntityId()",
    "String AttributeCacheKey.getKey()",
    "AttributeScope AttributeCacheKey.getScope()",
    "boolean AttributeCacheKey.isVersioned()",
    "String AttributeCacheKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    AttributeCacheKey actualAttributeCacheKey =
        new AttributeCacheKey(AttributeScope.CLIENT_SCOPE, entityId, "Key");
    String actualToStringResult = actualAttributeCacheKey.toString();
    EntityId actualEntityId = actualAttributeCacheKey.getEntityId();
    String actualKey = actualAttributeCacheKey.getKey();
    AttributeScope actualScope = actualAttributeCacheKey.getScope();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("{13814000-1dd2-11b2-8080-808080808080}CLIENT_SCOPE_Key", actualToStringResult);
    assertEquals(AttributeScope.CLIENT_SCOPE, actualScope);
    assertTrue(actualAttributeCacheKey.isVersioned());
    assertSame(entityId, actualEntityId);
  }
}
