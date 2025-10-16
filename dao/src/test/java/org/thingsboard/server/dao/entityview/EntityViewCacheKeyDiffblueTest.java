/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.entityview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityViewCacheKeyDiffblueTest {
  /**
   * Test {@link EntityViewCacheKey#byName(TenantId, String)}.
   *
   * <p>Method under test: {@link EntityViewCacheKey#byName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewCacheKey EntityViewCacheKey.byName(TenantId, String)"})
  public void testByName() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewCacheKey EntityViewCacheKey.byEntityId(TenantId, EntityId)"})
  public void testByEntityId() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewCacheKey EntityViewCacheKey.byId(EntityViewId)"})
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
   *
   * <p>Method under test: {@link EntityViewCacheKey#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityViewCacheKey.toString()"})
  public void testToString() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityViewCacheKey.toString()"})
  public void testToString_givenByIdNull_thenReturnNullNNull() {
    // Arrange
    EntityViewCacheKey byIdResult = EntityViewCacheKey.byId(null);

    // Act and Assert
    assertEquals("null_n_null", byIdResult.toString());
  }

  /**
   * Test {@link EntityViewCacheKey#toString()}.
   *
   * <ul>
   *   <li>Then return {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheKey#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityViewCacheKey.toString()"})
  public void testToString_thenReturn138140001dd211b28080808080808080() {
    // Arrange, Act and Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        EntityViewCacheKey.byId(new EntityViewId(ModelConstants.NULL_UUID)).toString());
  }

  /**
   * Test {@link EntityViewCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Given byId {@link EntityViewId#EntityViewId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheKey#isVersioned()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewCacheKey.isVersioned()"})
  public void testIsVersioned_givenByIdEntityViewIdWithIdIsNull_uuid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EntityViewCacheKey.byId(new EntityViewId(ModelConstants.NULL_UUID)).isVersioned());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewCacheKey.isVersioned()"})
  public void testIsVersioned_givenByIdNull_thenReturnFalse() {
    // Arrange
    EntityViewCacheKey byIdResult = EntityViewCacheKey.byId(null);

    // Act and Assert
    assertFalse(byIdResult.isVersioned());
  }
}
