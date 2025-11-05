package org.thingsboard.server.dao.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

class EntityCountCacheKeyDiffblueTest {
  /**
   * Test {@link EntityCountCacheKey#equals(Object)}, and {@link EntityCountCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheKey#equals(Object)}
   *   <li>{@link EntityCountCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);
    EntityCountCacheKey entityCountCacheKey2 =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheKey, entityCountCacheKey2);
    assertEquals(entityCountCacheKey.hashCode(), entityCountCacheKey2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}, and {@link EntityCountCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheKey#equals(Object)}
   *   <li>{@link EntityCountCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey = new EntityCountCacheKey(null, EntityType.TENANT);
    EntityCountCacheKey entityCountCacheKey2 = new EntityCountCacheKey(null, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheKey, entityCountCacheKey2);
    assertEquals(entityCountCacheKey.hashCode(), entityCountCacheKey2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}, and {@link EntityCountCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheKey#equals(Object)}
   *   <li>{@link EntityCountCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, null);
    EntityCountCacheKey entityCountCacheKey2 =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertEquals(entityCountCacheKey, entityCountCacheKey2);
    assertEquals(entityCountCacheKey.hashCode(), entityCountCacheKey2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}, and {@link EntityCountCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheKey#equals(Object)}
   *   <li>{@link EntityCountCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheKey, entityCountCacheKey);
    int expectedHashCodeResult = entityCountCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, entityCountCacheKey.hashCode());
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityCountCacheKey entityCountCacheKey = new EntityCountCacheKey(tenantId, EntityType.TENANT);

    // Act and Assert
    assertNotEquals(
        entityCountCacheKey,
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey = new EntityCountCacheKey(null, EntityType.TENANT);

    // Act and Assert
    assertNotEquals(
        entityCountCacheKey,
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertNotEquals(
        entityCountCacheKey,
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.CUSTOMER);

    // Act and Assert
    assertNotEquals(
        entityCountCacheKey,
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT), null);
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT),
        "Different type to EntityCountCacheKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheKey#EntityCountCacheKey(TenantId, EntityType)}
   *   <li>{@link EntityCountCacheKey#toString()}
   *   <li>{@link EntityCountCacheKey#getEntityType()}
   *   <li>{@link EntityCountCacheKey#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityCountCacheKey.<init>(TenantId, EntityType)",
    "EntityType EntityCountCacheKey.getEntityType()",
    "TenantId EntityCountCacheKey.getTenantId()",
    "String EntityCountCacheKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityCountCacheKey actualEntityCountCacheKey =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);
    String actualToStringResult = actualEntityCountCacheKey.toString();
    EntityType actualEntityType = actualEntityCountCacheKey.getEntityType();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080_TENANT", actualToStringResult);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(TenantId.SYS_TENANT_ID, actualEntityCountCacheKey.getTenantId());
  }
}
