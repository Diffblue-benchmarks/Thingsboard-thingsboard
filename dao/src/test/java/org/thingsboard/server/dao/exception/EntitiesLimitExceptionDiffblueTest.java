package org.thingsboard.server.dao.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

class EntitiesLimitExceptionDiffblueTest {
  /**
   * Test {@link EntitiesLimitException#EntitiesLimitException(TenantId, EntityType)}.
   *
   * <p>Method under test: {@link EntitiesLimitException#EntitiesLimitException(TenantId,
   * EntityType)}
   */
  @Test
  @DisplayName("Test new EntitiesLimitException(TenantId, EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitiesLimitException.<init>(TenantId, EntityType)"})
  void testNewEntitiesLimitException() {
    // Arrange and Act
    EntitiesLimitException actualEntitiesLimitException =
        new EntitiesLimitException(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Assert
    assertEquals("Tenants limit reached", actualEntitiesLimitException.getLocalizedMessage());
    assertEquals("Tenants limit reached", actualEntitiesLimitException.getMessage());
    assertNull(actualEntitiesLimitException.getCause());
    assertEquals(0, actualEntitiesLimitException.getSuppressed().length);
    assertEquals(EntityType.TENANT, actualEntitiesLimitException.getEntityType());
    assertSame(TenantId.SYS_TENANT_ID, actualEntitiesLimitException.getTenantId());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitException#getEntityType()}
   *   <li>{@link EntitiesLimitException#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityType EntitiesLimitException.getEntityType()",
    "TenantId EntitiesLimitException.getTenantId()"
  })
  void testGettersAndSetters() {
    // Arrange
    EntitiesLimitException entitiesLimitException =
        new EntitiesLimitException(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act
    EntityType actualEntityType = entitiesLimitException.getEntityType();

    // Assert
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(TenantId.SYS_TENANT_ID, entitiesLimitException.getTenantId());
  }
}
