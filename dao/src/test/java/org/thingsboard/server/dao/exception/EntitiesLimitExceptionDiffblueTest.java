package org.thingsboard.server.dao.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntitiesLimitExceptionDiffblueTest {
  /**
   * Test {@link EntitiesLimitException#EntitiesLimitException(TenantId, EntityType)}.
   * <p>
   * Method under test: {@link EntitiesLimitException#EntitiesLimitException(TenantId, EntityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EntitiesLimitException.<init>(TenantId, EntityType)"})
  public void testNewEntitiesLimitException() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    EntitiesLimitException actualEntitiesLimitException = new EntitiesLimitException(tenantId, EntityType.TENANT);

    // Assert
    assertEquals("Tenants limit reached", actualEntitiesLimitException.getLocalizedMessage());
    assertEquals("Tenants limit reached", actualEntitiesLimitException.getMessage());
    assertNull(actualEntitiesLimitException.getCause());
    assertEquals(0, actualEntitiesLimitException.getSuppressed().length);
    assertEquals(EntityType.TENANT, actualEntitiesLimitException.getEntityType());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualEntitiesLimitException.getTenantId());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesLimitException#getEntityType()}
   *   <li>{@link EntitiesLimitException#getTenantId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType EntitiesLimitException.getEntityType()",
      "TenantId EntitiesLimitException.getTenantId()"})
  public void testGettersAndSetters() {
    // Arrange
    EntitiesLimitException entitiesLimitException = new EntitiesLimitException(ModelConstants.SYSTEM_TENANT,
        EntityType.TENANT);

    // Act
    EntityType actualEntityType = entitiesLimitException.getEntityType();
    TenantId actualTenantId = entitiesLimitException.getTenantId();

    // Assert
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
