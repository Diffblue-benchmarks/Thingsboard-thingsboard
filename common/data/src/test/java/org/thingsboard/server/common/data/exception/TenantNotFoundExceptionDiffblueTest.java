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
package org.thingsboard.server.common.data.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class TenantNotFoundExceptionDiffblueTest {
  /**
   * Method under test: {@link TenantNotFoundException#getTenantId()}
   */
  @Test
  void testGetTenantId() {
    // Arrange and Act
    TenantId actualTenantId = (new TenantNotFoundException(TenantId.SYS_TENANT_ID)).getTenantId();

    // Assert
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Method under test:
   * {@link TenantNotFoundException#TenantNotFoundException(TenantId)}
   */
  @Test
  void testNewTenantNotFoundException() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    TenantNotFoundException actualTenantNotFoundException = new TenantNotFoundException(tenantId);

    // Assert
    assertEquals("Tenant with id 13814000-1dd2-11b2-8080-808080808080 not found",
        actualTenantNotFoundException.getLocalizedMessage());
    assertEquals("Tenant with id 13814000-1dd2-11b2-8080-808080808080 not found",
        actualTenantNotFoundException.getMessage());
    assertNull(actualTenantNotFoundException.getCause());
    assertEquals(0, actualTenantNotFoundException.getSuppressed().length);
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualTenantNotFoundException.getTenantId());
  }
}
