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
package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.cache.device.DeviceCacheKey;
import org.thingsboard.server.common.data.id.DeviceId;

class VersionedCacheKeyDiffblueTest {
  /**
   * Test {@link VersionedCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Given {@link DeviceCacheKey#DeviceCacheKey(DeviceId)} with deviceId is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedCacheKey#isVersioned()}
   */
  @Test
  @DisplayName(
      "Test isVersioned(); given DeviceCacheKey(DeviceId) with deviceId is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VersionedCacheKey.isVersioned()"})
  void testIsVersioned_givenDeviceCacheKeyWithDeviceIdIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new DeviceCacheKey(null).isVersioned());
  }

  /**
   * Test {@link VersionedCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Given {@link DeviceId#DeviceId(UUID)} with id is randomUUID.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedCacheKey#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); given DeviceId(UUID) with id is randomUUID; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VersionedCacheKey.isVersioned()"})
  void testIsVersioned_givenDeviceIdWithIdIsRandomUUID_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new DeviceCacheKey(new DeviceId(UUID.randomUUID())).isVersioned());
  }
}
