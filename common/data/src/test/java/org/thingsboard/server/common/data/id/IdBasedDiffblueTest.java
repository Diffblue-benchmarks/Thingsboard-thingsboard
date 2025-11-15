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
package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.ApiUsageState;

class IdBasedDiffblueTest {
  /**
   * Method under test: {@link IdBased#setId(UUIDBased)}
   */
  @Test
  void testSetId() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    AdminSettingsId adminSettingsId = new AdminSettingsId(EntityId.NULL_UUID);

    // Act
    adminSettings.setId(adminSettingsId);

    // Assert
    assertSame(adminSettingsId, adminSettings.getId());
  }

  /**
   * Method under test: {@link IdBased#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new ApiUsageState()).getId());
  }

  /**
   * Method under test: {@link IdBased#getUuidId()}
   */
  @Test
  void testGetUuidId() {
    // Arrange, Act and Assert
    assertNull((new AdminSettings()).getUuidId());
  }

  /**
   * Method under test: {@link IdBased#getUuidId()}
   */
  @Test
  void testGetUuidId2() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setId(new AdminSettingsId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", adminSettings.getUuidId().toString());
  }
}
