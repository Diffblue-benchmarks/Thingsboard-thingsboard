package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AdminSettingsIdDiffblueTest {
  /**
   * Test {@link AdminSettingsId#AdminSettingsId(UUID)}.
   * <p>
   * Method under test: {@link AdminSettingsId#AdminSettingsId(UUID)}
   */
  @Test
  @DisplayName("Test new AdminSettingsId(UUID)")
  void testNewAdminSettingsId() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act and Assert
    UUID id2 = (new AdminSettingsId(id)).getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertSame(id, id2);
  }
}
