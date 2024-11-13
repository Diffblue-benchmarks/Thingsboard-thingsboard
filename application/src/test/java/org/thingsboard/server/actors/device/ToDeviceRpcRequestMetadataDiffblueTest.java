package org.thingsboard.server.actors.device;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rpc.ToDeviceRpcRequestBody;
import org.thingsboard.server.common.msg.rpc.ToDeviceRpcRequest;
import org.thingsboard.server.common.msg.rpc.ToDeviceRpcRequestActorMsg;

class ToDeviceRpcRequestMetadataDiffblueTest {
  /**
   * Test {@link ToDeviceRpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDeviceRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);
    ToDeviceRpcRequestMetadata toDeviceRpcRequestMetadata = new ToDeviceRpcRequestMetadata(
        new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(id, tenantId, deviceId, true, 1L,
            new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info")),
        true);
    UUID id2 = UUID.randomUUID();
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(toDeviceRpcRequestMetadata,
        new ToDeviceRpcRequestMetadata(new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(id2, tenantId2, null,
            true, 1L, new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info")), true));
  }

  /**
   * Test {@link ToDeviceRpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDeviceRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);

    // Act and Assert
    assertNotEquals(
        new ToDeviceRpcRequestMetadata(new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(id, tenantId,
            deviceId, true, 1L, new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info")), true),
        "42");
  }
}
