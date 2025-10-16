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

class BaseDataDiffblueTest {
  /**
   * Test {@link BaseData#getCreatedTime()}.
   *
   * <p>Method under test: {@link BaseData#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseData.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new ApiUsageState().getCreatedTime());
  }

  /**
   * Test {@link BaseData#setCreatedTime(long)}.
   *
   * <p>Method under test: {@link BaseData#setCreatedTime(long)}
   */
  @Test
  @DisplayName("Test setCreatedTime(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseData.setCreatedTime(long)"})
  void testSetCreatedTime() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();

    // Act
    adminSettings.setCreatedTime(1L);

    // Assert
    assertEquals(1L, adminSettings.getCreatedTime());
  }
}
