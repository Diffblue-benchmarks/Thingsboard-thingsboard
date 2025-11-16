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
package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class QuerySecurityContextDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return not IgnorePermissionCheck.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QuerySecurityContext#QuerySecurityContext(TenantId, CustomerId, EntityType)}
   *   <li>{@link QuerySecurityContext#getCustomerId()}
   *   <li>{@link QuerySecurityContext#getEntityType()}
   *   <li>{@link QuerySecurityContext#getTenantId()}
   *   <li>{@link QuerySecurityContext#isIgnorePermissionCheck()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QuerySecurityContext.<init>(TenantId, CustomerId, EntityType)",
    "void QuerySecurityContext.<init>(TenantId, CustomerId, EntityType, boolean)",
    "CustomerId QuerySecurityContext.getCustomerId()",
    "EntityType QuerySecurityContext.getEntityType()",
    "TenantId QuerySecurityContext.getTenantId()",
    "boolean QuerySecurityContext.isIgnorePermissionCheck()"
  })
  public void testGettersAndSetters_whenNull_customer_id_thenReturnNotIgnorePermissionCheck() {
    // Arrange
    CustomerId customerId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    QuerySecurityContext actualQuerySecurityContext =
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, customerId, EntityType.TENANT);
    CustomerId actualCustomerId = actualQuerySecurityContext.getCustomerId();
    EntityType actualEntityType = actualQuerySecurityContext.getEntityType();
    TenantId actualTenantId = actualQuerySecurityContext.getTenantId();

    // Assert
    assertEquals(EntityType.TENANT, actualEntityType);
    assertFalse(actualQuerySecurityContext.isIgnorePermissionCheck());
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(customerId, actualCustomerId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return IgnorePermissionCheck.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QuerySecurityContext#QuerySecurityContext(TenantId, CustomerId, EntityType,
   *       boolean)}
   *   <li>{@link QuerySecurityContext#getCustomerId()}
   *   <li>{@link QuerySecurityContext#getEntityType()}
   *   <li>{@link QuerySecurityContext#getTenantId()}
   *   <li>{@link QuerySecurityContext#isIgnorePermissionCheck()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QuerySecurityContext.<init>(TenantId, CustomerId, EntityType)",
    "void QuerySecurityContext.<init>(TenantId, CustomerId, EntityType, boolean)",
    "CustomerId QuerySecurityContext.getCustomerId()",
    "EntityType QuerySecurityContext.getEntityType()",
    "TenantId QuerySecurityContext.getTenantId()",
    "boolean QuerySecurityContext.isIgnorePermissionCheck()"
  })
  public void testGettersAndSetters_whenTrue_thenReturnIgnorePermissionCheck() {
    // Arrange
    CustomerId customerId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    QuerySecurityContext actualQuerySecurityContext =
        new QuerySecurityContext(ModelConstants.SYSTEM_TENANT, customerId, EntityType.TENANT, true);
    CustomerId actualCustomerId = actualQuerySecurityContext.getCustomerId();
    EntityType actualEntityType = actualQuerySecurityContext.getEntityType();
    TenantId actualTenantId = actualQuerySecurityContext.getTenantId();

    // Assert
    assertEquals(EntityType.TENANT, actualEntityType);
    assertTrue(actualQuerySecurityContext.isIgnorePermissionCheck());
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(customerId, actualCustomerId);
  }
}
