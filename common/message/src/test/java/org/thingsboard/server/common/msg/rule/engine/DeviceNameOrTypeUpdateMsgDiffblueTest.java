package org.thingsboard.server.common.msg.rule.engine;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceNameOrTypeUpdateMsgDiffblueTest {
  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg = new DeviceNameOrTypeUpdateMsg(new TenantId(UUID.randomUUID()),
        mock(DeviceId.class), "Device Name", "Device Type");

    // Act and Assert
    assertNotEquals(deviceNameOrTypeUpdateMsg,
        new DeviceNameOrTypeUpdateMsg(new TenantId(UUID.randomUUID()), null, "Device Name", "Device Type"));
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceNameOrTypeUpdateMsg(new TenantId(UUID.randomUUID()), mock(DeviceId.class), "Device Name",
        "Device Type"), "42");
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg = new DeviceNameOrTypeUpdateMsg(null, mock(DeviceId.class),
        "Device Name", "Device Type");

    // Act and Assert
    assertNotEquals(deviceNameOrTypeUpdateMsg,
        new DeviceNameOrTypeUpdateMsg(new TenantId(UUID.randomUUID()), null, "Device Name", "Device Type"));
  }
}
