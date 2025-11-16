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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApiUsageStateValueDiffblueTest {
  /**
   * Test {@link ApiUsageStateValue#toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue)}.
   *
   * <ul>
   *   <li>When {@code ENABLED}.
   *   <li>Then return {@code ENABLED}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateValue#toMoreRestricted(ApiUsageStateValue,
   * ApiUsageStateValue)}
   */
  @Test
  @DisplayName(
      "Test toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue); when 'ENABLED'; then return 'ENABLED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageStateValue ApiUsageStateValue.toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue)"
  })
  void testToMoreRestricted_whenEnabled_thenReturnEnabled() {
    // Arrange, Act and Assert
    assertEquals(
        ApiUsageStateValue.ENABLED,
        ApiUsageStateValue.toMoreRestricted(
            ApiUsageStateValue.ENABLED, ApiUsageStateValue.ENABLED));
  }

  /**
   * Test {@link ApiUsageStateValue#toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue)}.
   *
   * <ul>
   *   <li>When {@code WARNING}.
   *   <li>Then return {@code WARNING}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateValue#toMoreRestricted(ApiUsageStateValue,
   * ApiUsageStateValue)}
   */
  @Test
  @DisplayName(
      "Test toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue); when 'WARNING'; then return 'WARNING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageStateValue ApiUsageStateValue.toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue)"
  })
  void testToMoreRestricted_whenWarning_thenReturnWarning() {
    // Arrange, Act and Assert
    assertEquals(
        ApiUsageStateValue.WARNING,
        ApiUsageStateValue.toMoreRestricted(
            ApiUsageStateValue.WARNING, ApiUsageStateValue.ENABLED));
  }
}
