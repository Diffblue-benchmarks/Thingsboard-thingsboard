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
package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class DefaultEntityLimitsCacheDiffblueTest {
  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey); when TenantId(UUID) with id is randomUUID; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultEntityLimitsCache.get(EntityLimitKey)"})
  void testGet_whenTenantIdWithIdIsRandomUUID_thenReturnFalse() {
    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);

    // Act and Assert
    assertFalse(defaultEntityLimitsCache.get(new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name")));
  }
}
