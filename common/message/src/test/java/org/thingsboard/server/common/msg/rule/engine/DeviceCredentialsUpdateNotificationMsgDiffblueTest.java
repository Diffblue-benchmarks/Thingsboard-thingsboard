package org.thingsboard.server.common.msg.rule.engine;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class DeviceCredentialsUpdateNotificationMsgDiffblueTest {
  /**
   * Test {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);
    DeviceCredentialsUpdateNotificationMsg deviceCredentialsUpdateNotificationMsg = new DeviceCredentialsUpdateNotificationMsg(
        tenantId, deviceId, new DeviceCredentials());
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(deviceCredentialsUpdateNotificationMsg,
        new DeviceCredentialsUpdateNotificationMsg(tenantId2, null, new DeviceCredentials()));
  }

  /**
   * Test {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);

    // Act and Assert
    assertNotEquals(new DeviceCredentialsUpdateNotificationMsg(tenantId, deviceId, new DeviceCredentials()), "42");
  }

  /**
   * Test {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceId deviceId = mock(DeviceId.class);
    DeviceCredentialsUpdateNotificationMsg deviceCredentialsUpdateNotificationMsg = new DeviceCredentialsUpdateNotificationMsg(
        null, deviceId, new DeviceCredentials());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(deviceCredentialsUpdateNotificationMsg,
        new DeviceCredentialsUpdateNotificationMsg(tenantId, null, new DeviceCredentials()));
  }
}
