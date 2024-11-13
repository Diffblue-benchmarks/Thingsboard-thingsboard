package org.thingsboard.server.common.msg.rpc;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

class RemoveRpcActorMsgDiffblueTest {
  /**
   * Test {@link RemoveRpcActorMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveRpcActorMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);
    RemoveRpcActorMsg removeRpcActorMsg = new RemoveRpcActorMsg(tenantId, deviceId, UUID.randomUUID());
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(removeRpcActorMsg, new RemoveRpcActorMsg(tenantId2, null, UUID.randomUUID()));
  }

  /**
   * Test {@link RemoveRpcActorMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveRpcActorMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);

    // Act and Assert
    assertNotEquals(new RemoveRpcActorMsg(tenantId, deviceId, UUID.randomUUID()), "42");
  }

  /**
   * Test {@link RemoveRpcActorMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveRpcActorMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceId deviceId = mock(DeviceId.class);
    RemoveRpcActorMsg removeRpcActorMsg = new RemoveRpcActorMsg(null, deviceId, UUID.randomUUID());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(removeRpcActorMsg, new RemoveRpcActorMsg(tenantId, null, UUID.randomUUID()));
  }
}
