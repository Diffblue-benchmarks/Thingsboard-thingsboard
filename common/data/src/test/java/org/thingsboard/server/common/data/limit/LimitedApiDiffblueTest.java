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
package org.thingsboard.server.common.data.limit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;

class LimitedApiDiffblueTest {
  /**
   * Method under test:
   * {@link LimitedApi#getLimitConfig(DefaultTenantProfileConfiguration)}
   */
  @Test
  void testGetLimitConfig() {
    // Arrange, Act and Assert
    assertNull(LimitedApi.ENTITY_EXPORT.getLimitConfig(new DefaultTenantProfileConfiguration()));
    assertNull(LimitedApi.PASSWORD_RESET.getLimitConfig(new DefaultTenantProfileConfiguration()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LimitedApi#getLabel()}
   *   <li>{@link LimitedApi#isPerTenant()}
   *   <li>{@link LimitedApi#isRefillRateLimitIntervally()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    LimitedApi valueOfResult = LimitedApi.valueOf("ENTITY_EXPORT");

    // Act
    String actualLabel = valueOfResult.getLabel();
    boolean actualIsPerTenantResult = valueOfResult.isPerTenant();

    // Assert
    assertEquals("entity version creation", actualLabel);
    assertFalse(valueOfResult.isRefillRateLimitIntervally());
    assertTrue(actualIsPerTenantResult);
  }
}
