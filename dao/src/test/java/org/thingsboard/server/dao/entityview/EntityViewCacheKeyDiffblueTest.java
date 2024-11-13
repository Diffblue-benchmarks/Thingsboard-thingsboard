package org.thingsboard.server.dao.entityview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityViewCacheKeyDiffblueTest {
  /**
   * Test {@link EntityViewCacheKey#byName(TenantId, String)}.
   * <p>
   * Method under test: {@link EntityViewCacheKey#byName(TenantId, String)}
   */
  @Test
  public void testByName() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    EntityViewCacheKey actualByNameResult = EntityViewCacheKey.byName(tenantId, "Name");

    // Assert
    assertEquals("Name", actualByNameResult.getName());
    assertNull(actualByNameResult.getEntityId());
    assertNull(actualByNameResult.getEntityViewId());
    assertFalse(actualByNameResult.isVersioned());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualByNameResult.getTenantId());
  }

  /**
   * Test {@link EntityViewCacheKey#byEntityId(TenantId, EntityId)}.
   * <p>
   * Method under test: {@link EntityViewCacheKey#byEntityId(TenantId, EntityId)}
   */
  @Test
  public void testByEntityId() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    EntityViewCacheKey actualByEntityIdResult = EntityViewCacheKey.byEntityId(tenantId, entityId);

    // Assert
    assertNull(actualByEntityIdResult.getName());
    assertNull(actualByEntityIdResult.getEntityViewId());
    assertFalse(actualByEntityIdResult.isVersioned());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualByEntityIdResult.getTenantId());
    assertSame(entityId, actualByEntityIdResult.getEntityId());
  }

  /**
   * Test {@link EntityViewCacheKey#byId(EntityViewId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewCacheKey#byId(EntityViewId)}
   */
  @Test
  public void testById_whenNull_thenReturnNameIsNull() {
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
   * <p>
   * Method under test: {@link EntityViewCacheKey#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080_13814000-1dd2-11b2-8080-808080808080",
        EntityViewCacheKey.byEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID).toString());
  }

  /**
   * Test {@link EntityViewCacheKey#toString()}.
   * <ul>
   *   <li>Given byId {@code null}.</li>
   *   <li>Then return {@code null_n_null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewCacheKey#toString()}
   */
  @Test
  public void testToString_givenByIdNull_thenReturnNullNNull() {
    // Arrange, Act and Assert
    assertEquals("null_n_null", EntityViewCacheKey.byId(null).toString());
  }

  /**
   * Test {@link EntityViewCacheKey#toString()}.
   * <ul>
   *   <li>Then return {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewCacheKey#toString()}
   */
  @Test
  public void testToString_thenReturn138140001dd211b28080808080808080() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080",
        EntityViewCacheKey.byId(new EntityViewId(ModelConstants.NULL_UUID)).toString());
  }

  /**
   * Test {@link EntityViewCacheKey#isVersioned()}.
   * <ul>
   *   <li>Given byId {@link EntityViewId#EntityViewId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewCacheKey#isVersioned()}
   */
  @Test
  public void testIsVersioned_givenByIdEntityViewIdWithIdIsNull_uuid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EntityViewCacheKey.byId(new EntityViewId(ModelConstants.NULL_UUID)).isVersioned());
  }

  /**
   * Test {@link EntityViewCacheKey#isVersioned()}.
   * <ul>
   *   <li>Given byId {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewCacheKey#isVersioned()}
   */
  @Test
  public void testIsVersioned_givenByIdNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EntityViewCacheKey.byId(null).isVersioned());
  }
}
