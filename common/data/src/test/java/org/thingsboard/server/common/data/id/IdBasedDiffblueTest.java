package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
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
  void testGetUuidId_givenAdminSettings_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminSettings()).getUuidId());
  }

  /**
   * Test {@link IdBased#getUuidId()}.
   * <ul>
   *   <li>Then return toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdBased#getUuidId()}
   */
  @Test
  @DisplayName("Test getUuidId(); then return toString is '13814000-1dd2-11b2-8080-808080808080'")
  void testGetUuidId_thenReturnToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setId(new AdminSettingsId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", adminSettings.getUuidId().toString());
  }
}
