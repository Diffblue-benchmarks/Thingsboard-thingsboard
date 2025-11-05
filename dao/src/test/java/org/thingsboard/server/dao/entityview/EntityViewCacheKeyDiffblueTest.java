package org.thingsboard.server.dao.entityview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

class EntityViewCacheKeyDiffblueTest {
  /**
   * Test {@link EntityViewCacheKey#byName(TenantId, String)}.
   *
   * <p>Method under test: {@link EntityViewCacheKey#byName(TenantId, String)}
   */
  @Test
  @DisplayName("Test byName(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewCacheKey EntityViewCacheKey.byName(TenantId, String)"})
  void testByName() {
    // Arrange and Act
    EntityViewCacheKey actualByNameResult =
        EntityViewCacheKey.byName(ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    assertEquals("Name", actualByNameResult.getName());
    assertNull(actualByNameResult.getEntityId());
    assertNull(actualByNameResult.getEntityViewId());
    assertFalse(actualByNameResult.isVersioned());
    assertSame(TenantId.SYS_TENANT_ID, actualByNameResult.getTenantId());
  }

  /**
   * Test {@link EntityViewCacheKey#byEntityId(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link EntityViewCacheKey#byEntityId(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test byEntityId(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewCacheKey EntityViewCacheKey.byEntityId(TenantId, EntityId)"})
  void testByEntityId() {
    // Arrange
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    EntityViewCacheKey actualByEntityIdResult =
        EntityViewCacheKey.byEntityId(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    assertNull(actualByEntityIdResult.getName());
    assertNull(actualByEntityIdResult.getEntityViewId());
    assertFalse(actualByEntityIdResult.isVersioned());
    assertSame(TenantId.SYS_TENANT_ID, actualByEntityIdResult.getTenantId());
    assertSame(entityId, actualByEntityIdResult.getEntityId());
  }

  /**
   * Test {@link EntityViewCacheKey#byId(EntityViewId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheKey#byId(EntityViewId)}
   */
  @Test
  @DisplayName("Test byId(EntityViewId); when 'null'; then return Name is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewCacheKey EntityViewCacheKey.byId(EntityViewId)"})
  void testById_whenNull_thenReturnNameIsNull() {
    // Arrange and Act
    EntityViewCacheKey actualByIdResult = EntityViewCacheKey.byId(null);

    // Assert
    assertNull(actualByIdResult.getName());
    assertNull(actualByIdResult.getEntityId());
    assertNull(actualByIdResult.getEntityViewId());
    assertNull(actualByIdResult.getTenantId());
    assertFalse(actualByIdResult.isVersioned());
  }

  /**
   * Test {@link EntityViewCacheKey#toString()}.
   *
   * <p>Method under test: {@link EntityViewCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityViewCacheKey.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080_13814000-1dd2-11b2-8080-808080808080",
        EntityViewCacheKey.byEntityId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID)
            .toString());
  }

  /**
   * Test {@link EntityViewCacheKey#toString()}.
   *
   * <ul>
   *   <li>Given byId {@code null}.
   *   <li>Then return {@code null_n_null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString(); given byId 'null'; then return 'null_n_null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityViewCacheKey.toString()"})
  void testToString_givenByIdNull_thenReturnNullNNull() {
    // Arrange
    EntityViewCacheKey byIdResult = EntityViewCacheKey.byId(null);

    // Act and Assert
    assertEquals("null_n_null", byIdResult.toString());
  }

  /**
   * Test {@link EntityViewCacheKey#toString()}.
   *
   * <ul>
   *   <li>Then return {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityViewCacheKey.toString()"})
  void testToString_thenReturn784f394c42b6435a983cB7beff2784f9() {
    // Arrange, Act and Assert
    assertEquals(
        "784f394c-42b6-435a-983c-b7beff2784f9",
        EntityViewCacheKey.byId(
                new EntityViewId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .toString());
  }

  /**
   * Test {@link EntityViewCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Given byId {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheKey#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); given byId 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewCacheKey.isVersioned()"})
  void testIsVersioned_givenByIdNull_thenReturnFalse() {
    // Arrange
    EntityViewCacheKey byIdResult = EntityViewCacheKey.byId(null);

    // Act and Assert
    assertFalse(byIdResult.isVersioned());
  }

  /**
   * Test {@link EntityViewCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheKey#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewCacheKey.isVersioned()"})
  void testIsVersioned_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        EntityViewCacheKey.byId(
                new EntityViewId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .isVersioned());
  }
}
