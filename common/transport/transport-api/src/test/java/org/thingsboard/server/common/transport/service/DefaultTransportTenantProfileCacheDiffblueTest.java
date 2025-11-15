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
package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;

@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class DefaultTransportTenantProfileCacheDiffblueTest {
  @InjectMocks
  private DefaultTransportTenantProfileCache defaultTransportTenantProfileCache;

  /**
   * Test {@link DefaultTransportTenantProfileCache#put(TenantId, TenantProfileId)} with {@code tenantId}, {@code profileId}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTransportTenantProfileCache#put(TenantId, TenantProfileId)}
   */
  @Test
  @DisplayName("Test put(TenantId, TenantProfileId) with 'tenantId', 'profileId'; when TenantId(UUID) with id is randomUUID; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultTransportTenantProfileCache.put(TenantId, TenantProfileId)"})
  void testPutWithTenantIdProfileId_whenTenantIdWithIdIsRandomUUID_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(defaultTransportTenantProfileCache.put(new TenantId(UUID.randomUUID()), null));
  }

  /**
   * Test {@link DefaultTransportTenantProfileCache#remove(TenantProfileId)}.
   * <ul>
   *   <li>When {@link TenantProfileId#TenantProfileId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTransportTenantProfileCache#remove(TenantProfileId)}
   */
  @Test
  @DisplayName("Test remove(TenantProfileId); when TenantProfileId(UUID) with id is randomUUID; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set DefaultTransportTenantProfileCache.remove(TenantProfileId)"})
  void testRemove_whenTenantProfileIdWithIdIsRandomUUID_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(defaultTransportTenantProfileCache.remove(new TenantProfileId(UUID.randomUUID())));
  }
}
