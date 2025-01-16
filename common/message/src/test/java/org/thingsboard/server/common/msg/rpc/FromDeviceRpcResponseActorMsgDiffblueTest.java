package org.thingsboard.server.common.msg.rpc;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rpc.RpcError;

class FromDeviceRpcResponseActorMsgDiffblueTest {
  /**
   * Test {@link FromDeviceRpcResponseActorMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FromDeviceRpcResponseActorMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);
    FromDeviceRpcResponseActorMsg fromDeviceRpcResponseActorMsg = new FromDeviceRpcResponseActorMsg(1, tenantId,
        deviceId, new FromDeviceRpcResponse(UUID.randomUUID(), "Response", RpcError.NOT_FOUND));
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(fromDeviceRpcResponseActorMsg, new FromDeviceRpcResponseActorMsg(1, tenantId2, null,
        new FromDeviceRpcResponse(UUID.randomUUID(), "Response", RpcError.NOT_FOUND)));
  }

  /**
   * Test {@link FromDeviceRpcResponseActorMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FromDeviceRpcResponseActorMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);

    // Act and Assert
    assertNotEquals(new FromDeviceRpcResponseActorMsg(1, tenantId, deviceId,
        new FromDeviceRpcResponse(UUID.randomUUID(), "Response", RpcError.NOT_FOUND)), "42");
  }

  /**
   * Test {@link FromDeviceRpcResponseActorMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FromDeviceRpcResponseActorMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);
    FromDeviceRpcResponseActorMsg fromDeviceRpcResponseActorMsg = new FromDeviceRpcResponseActorMsg(2, tenantId,
        deviceId, new FromDeviceRpcResponse(UUID.randomUUID(), "Response", RpcError.NOT_FOUND));
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(fromDeviceRpcResponseActorMsg, new FromDeviceRpcResponseActorMsg(1, tenantId2, null,
        new FromDeviceRpcResponse(UUID.randomUUID(), "Response", RpcError.NOT_FOUND)));
  }
}
