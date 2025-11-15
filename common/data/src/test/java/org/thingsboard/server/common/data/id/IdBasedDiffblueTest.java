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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.ApiUsageState;

class IdBasedDiffblueTest {
  /**
   * Test {@link IdBased#setId(UUIDBased)}.
   * <p>
   * Method under test: {@link IdBased#setId(UUIDBased)}
   */
  @Test
  @DisplayName("Test setId(UUIDBased)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IdBased.setId(UUIDBased)"})
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
   * Test {@link IdBased#getId()}.
   * <p>
   * Method under test: {@link IdBased#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUIDBased IdBased.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new ApiUsageState()).getId());
  }

  /**
   * Test {@link IdBased#getUuidId()}.
   * <ul>
   *   <li>Given {@link AdminSettings#AdminSettings()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdBased#getUuidId()}
   */
  @Test
  @DisplayName("Test getUuidId(); given AdminSettings(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.UUID IdBased.getUuidId()"})
  void testGetUuidId_givenAdminSettings_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminSettings()).getUuidId());
  }

  /**
   * Test {@link IdBased#getUuidId()}.
   * <ul>
   *   <li>Then return toString is {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdBased#getUuidId()}
   */
  @Test
  @DisplayName("Test getUuidId(); then return toString is '13814000-1dd2-11b2-8080-808080808080'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.UUID IdBased.getUuidId()"})
  void testGetUuidId_thenReturnToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setId(new AdminSettingsId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", adminSettings.getUuidId().toString());
  }
}
