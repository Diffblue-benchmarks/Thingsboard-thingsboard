package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class QuerySecurityContextDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return not IgnorePermissionCheck.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link QuerySecurityContext#QuerySecurityContext(TenantId, CustomerId, EntityType)}
   *   <li>{@link QuerySecurityContext#getCustomerId()}
   *   <li>{@link QuerySecurityContext#getEntityType()}
   *   <li>{@link QuerySecurityContext#getTenantId()}
   *   <li>{@link QuerySecurityContext#isIgnorePermissionCheck()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenNull_customer_id_thenReturnNotIgnorePermissionCheck() {
    // Arrange
    CustomerId customerId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    QuerySecurityContext actualQuerySecurityContext = new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, customerId,
        EntityType.TENANT);
    CustomerId actualCustomerId = actualQuerySecurityContext.getCustomerId();
    EntityType actualEntityType = actualQuerySecurityContext.getEntityType();
    TenantId actualTenantId = actualQuerySecurityContext.getTenantId();

    // Assert
    assertEquals(EntityType.TENANT, actualEntityType);
    assertFalse(actualQuerySecurityContext.isIgnorePermissionCheck());
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(customerId, actualCustomerId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return IgnorePermissionCheck.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link QuerySecurityContext#QuerySecurityContext(TenantId, CustomerId, EntityType, boolean)}
   *   <li>{@link QuerySecurityContext#getCustomerId()}
   *   <li>{@link QuerySecurityContext#getEntityType()}
   *   <li>{@link QuerySecurityContext#getTenantId()}
   *   <li>{@link QuerySecurityContext#isIgnorePermissionCheck()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenTrue_thenReturnIgnorePermissionCheck() {
    // Arrange
    CustomerId customerId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    QuerySecurityContext actualQuerySecurityContext = new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, customerId,
        EntityType.TENANT, true);
    CustomerId actualCustomerId = actualQuerySecurityContext.getCustomerId();
    EntityType actualEntityType = actualQuerySecurityContext.getEntityType();
    TenantId actualTenantId = actualQuerySecurityContext.getTenantId();

    // Assert
    assertEquals(EntityType.TENANT, actualEntityType);
    assertTrue(actualQuerySecurityContext.isIgnorePermissionCheck());
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(customerId, actualCustomerId);
  }
}
