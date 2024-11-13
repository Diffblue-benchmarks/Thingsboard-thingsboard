package org.thingsboard.server.common.msg.rpc;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rpc.ToDeviceRpcRequestBody;

class ToDeviceRpcRequestActorMsgDiffblueTest {
  /**
   * Test {@link ToDeviceRpcRequestActorMsg#getDeviceId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDeviceRpcRequestActorMsg#getDeviceId()}
   */
  @Test
  @DisplayName("Test getDeviceId(); then return 'null'")
  void testGetDeviceId_thenReturnNull() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull((new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(id, tenantId, null, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info"))).getDeviceId());
  }

  /**
   * Test {@link ToDeviceRpcRequestActorMsg#getTenantId()}.
   * <ul>
   *   <li>Then return {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDeviceRpcRequestActorMsg#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId(); then return TenantId(UUID) with id is randomUUID")
  void testGetTenantId_thenReturnTenantIdWithIdIsRandomUUID() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertSame(tenantId, (new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(id, tenantId, null, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info"))).getTenantId());
  }

  /**
   * Test {@link ToDeviceRpcRequestActorMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDeviceRpcRequestActorMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);
    ToDeviceRpcRequestActorMsg toDeviceRpcRequestActorMsg = new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(
        id, tenantId, deviceId, true, 1L, new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info"));
    UUID id2 = UUID.randomUUID();
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(toDeviceRpcRequestActorMsg, new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(id2,
        tenantId2, null, true, 1L, new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info")));
  }

  /**
   * Test {@link ToDeviceRpcRequestActorMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDeviceRpcRequestActorMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);

    // Act and Assert
    assertNotEquals(new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(id, tenantId, deviceId, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info")), "42");
  }

  /**
   * Test {@link ToDeviceRpcRequestActorMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDeviceRpcRequestActorMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);
    ToDeviceRpcRequestActorMsg toDeviceRpcRequestActorMsg = new ToDeviceRpcRequestActorMsg("Service Id",
        new ToDeviceRpcRequest(id, tenantId, deviceId, true, 1L, new ToDeviceRpcRequestBody("Method", "Params"), true,
            1, "Additional Info"));
    UUID id2 = UUID.randomUUID();
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(toDeviceRpcRequestActorMsg, new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(id2,
        tenantId2, null, true, 1L, new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info")));
  }
}
