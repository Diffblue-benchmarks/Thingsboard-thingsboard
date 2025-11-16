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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class TenantProfileNotFoundExceptionDiffblueTest {
  /**
   * Test {@link TenantProfileNotFoundException#TenantProfileNotFoundException(TenantId)}.
   *
   * <p>Method under test: {@link
   * TenantProfileNotFoundException#TenantProfileNotFoundException(TenantId)}
   */
  @Test
  @DisplayName("Test new TenantProfileNotFoundException(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileNotFoundException.<init>(TenantId)"})
  void testNewTenantProfileNotFoundException() {
    // Arrange and Act
    TenantProfileNotFoundException actualTenantProfileNotFoundException =
        new TenantProfileNotFoundException(TenantId.SYS_TENANT_ID);

    // Assert
    assertEquals(
        "Profile for tenant with id 13814000-1dd2-11b2-8080-808080808080 not found",
        actualTenantProfileNotFoundException.getLocalizedMessage());
    assertEquals(
        "Profile for tenant with id 13814000-1dd2-11b2-8080-808080808080 not found",
        actualTenantProfileNotFoundException.getMessage());
    assertNull(actualTenantProfileNotFoundException.getCause());
    assertEquals(0, actualTenantProfileNotFoundException.getSuppressed().length);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantProfileNotFoundException.getTenantId());
  }

  /**
   * Test {@link TenantProfileNotFoundException#getTenantId()}.
   *
   * <p>Method under test: {@link TenantProfileNotFoundException#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantProfileNotFoundException.getTenantId()"})
  void testGetTenantId() {
    // Arrange, Act and Assert
    assertSame(
        TenantId.SYS_TENANT_ID,
        new TenantProfileNotFoundException(TenantId.SYS_TENANT_ID).getTenantId());
  }
}
