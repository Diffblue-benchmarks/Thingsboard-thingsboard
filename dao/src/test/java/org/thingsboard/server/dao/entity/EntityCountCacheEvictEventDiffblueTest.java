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

class EntityCountCacheEvictEventDiffblueTest {
  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}, and {@link
   * EntityCountCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#equals(Object)}
   *   <li>{@link EntityCountCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);
    EntityCountCacheEvictEvent entityCountCacheEvictEvent2 =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheEvictEvent, entityCountCacheEvictEvent2);
    assertEquals(entityCountCacheEvictEvent.hashCode(), entityCountCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}, and {@link
   * EntityCountCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#equals(Object)}
   *   <li>{@link EntityCountCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(null, EntityType.TENANT);
    EntityCountCacheEvictEvent entityCountCacheEvictEvent2 =
        new EntityCountCacheEvictEvent(null, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheEvictEvent, entityCountCacheEvictEvent2);
    assertEquals(entityCountCacheEvictEvent.hashCode(), entityCountCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}, and {@link
   * EntityCountCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#equals(Object)}
   *   <li>{@link EntityCountCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, null);
    EntityCountCacheEvictEvent entityCountCacheEvictEvent2 =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertEquals(entityCountCacheEvictEvent, entityCountCacheEvictEvent2);
    assertEquals(entityCountCacheEvictEvent.hashCode(), entityCountCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}, and {@link
   * EntityCountCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#equals(Object)}
   *   <li>{@link EntityCountCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheEvictEvent, entityCountCacheEvictEvent);
    int expectedHashCodeResult = entityCountCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, entityCountCacheEvictEvent.hashCode());
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(tenantId, EntityType.TENANT);

    // Act and Assert
    assertNotEquals(
        entityCountCacheEvictEvent,
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(null, EntityType.TENANT);

    // Act and Assert
    assertNotEquals(
        entityCountCacheEvictEvent,
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertNotEquals(
        entityCountCacheEvictEvent,
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.CUSTOMER);

    // Act and Assert
    assertNotEquals(
        entityCountCacheEvictEvent,
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT), null);
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT),
        "Different type to EntityCountCacheEvictEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#EntityCountCacheEvictEvent(TenantId, EntityType)}
   *   <li>{@link EntityCountCacheEvictEvent#toString()}
   *   <li>{@link EntityCountCacheEvictEvent#getEntityType()}
   *   <li>{@link EntityCountCacheEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityCountCacheEvictEvent.<init>(TenantId, EntityType)",
    "EntityType EntityCountCacheEvictEvent.getEntityType()",
    "TenantId EntityCountCacheEvictEvent.getTenantId()",
    "String EntityCountCacheEvictEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityCountCacheEvictEvent actualEntityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);
    String actualToStringResult = actualEntityCountCacheEvictEvent.toString();
    EntityType actualEntityType = actualEntityCountCacheEvictEvent.getEntityType();

    // Assert
    assertEquals(
        "EntityCountCacheEvictEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, entityType=TENANT)",
        actualToStringResult);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(TenantId.SYS_TENANT_ID, actualEntityCountCacheEvictEvent.getTenantId());
  }
}
