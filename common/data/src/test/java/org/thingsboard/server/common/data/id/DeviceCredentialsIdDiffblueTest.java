package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeviceCredentialsIdDiffblueTest {
  /**
   * Test {@link DeviceCredentialsId#DeviceCredentialsId(UUID)}.
   * <p>
   * Method under test: {@link DeviceCredentialsId#DeviceCredentialsId(UUID)}
   */
  @Test
  @DisplayName("Test new DeviceCredentialsId(UUID)")
  void testNewDeviceCredentialsId() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act and Assert
    UUID id2 = (new DeviceCredentialsId(id)).getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertSame(id, id2);
  }
}
