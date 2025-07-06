package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.ApiUsageState;

class IdBasedDiffblueTest {
  /**
   * Test {@link IdBased#setId(UUIDBased)}.
   *
   * <p>Method under test: {@link IdBased#setId(UUIDBased)}
   */
  @Test
  @DisplayName("Test setId(UUIDBased)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IdBased.setId(UUIDBased)"})
  void testSetId() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AdminSettingsId adminSettingsId = new AdminSettingsId(id);

    // Act
    adminSettings.setId(adminSettingsId);

    // Assert
    assertSame(adminSettingsId, adminSettings.getId());
    assertSame(id, adminSettings.getUuidId());
  }

  /**
   * Test {@link IdBased#getId()}.
   *
   * <p>Method under test: {@link IdBased#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUIDBased IdBased.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new ApiUsageState().getId());
  }

  /**
   * Test {@link IdBased#getUuidId()}.
   *
   * <ul>
   *   <li>Given {@link AdminSettings#AdminSettings()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IdBased#getUuidId()}
   */
  @Test
  @DisplayName("Test getUuidId(); given AdminSettings(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID IdBased.getUuidId()"})
  void testGetUuidId_givenAdminSettings_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AdminSettings().getUuidId());
  }

  /**
   * Test {@link IdBased#getUuidId()}.
   *
   * <ul>
   *   <li>Then return toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link IdBased#getUuidId()}
   */
  @Test
  @DisplayName("Test getUuidId(); then return toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID IdBased.getUuidId()"})
  void testGetUuidId_thenReturnToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    adminSettings.setId(new AdminSettingsId(id));

    // Act
    UUID actualUuidId = adminSettings.getUuidId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualUuidId.toString());
    assertSame(id, actualUuidId);
  }
}
