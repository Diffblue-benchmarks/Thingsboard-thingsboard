package org.thingsboard.server.common.msg.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rpc.ToDeviceRpcRequestBody;

class ToDeviceRpcRequestDiffblueTest {
  /**
   * Test {@link ToDeviceRpcRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDeviceRpcRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);
    ToDeviceRpcRequest toDeviceRpcRequest = new ToDeviceRpcRequest(id, tenantId, deviceId, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info");
    UUID id2 = UUID.randomUUID();
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(toDeviceRpcRequest, new ToDeviceRpcRequest(id2, tenantId2, null, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info"));
  }

  /**
   * Test {@link ToDeviceRpcRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDeviceRpcRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);

    // Act and Assert
    assertNotEquals(new ToDeviceRpcRequest(id, tenantId, deviceId, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info"), "42");
  }

  /**
   * Test {@link ToDeviceRpcRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDeviceRpcRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);
    ToDeviceRpcRequest toDeviceRpcRequest = new ToDeviceRpcRequest(null, tenantId, deviceId, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info");
    UUID id = UUID.randomUUID();
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(toDeviceRpcRequest, new ToDeviceRpcRequest(id, tenantId2, null, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info"));
  }

  /**
   * Test
   * {@link ToDeviceRpcRequest#ToDeviceRpcRequest(UUID, TenantId, DeviceId, boolean, long, ToDeviceRpcRequestBody, boolean, Integer, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Additional Info}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ToDeviceRpcRequest#ToDeviceRpcRequest(UUID, TenantId, DeviceId, boolean, long, ToDeviceRpcRequestBody, boolean, Integer, String)}
   */
  @Test
  @DisplayName("Test new ToDeviceRpcRequest(UUID, TenantId, DeviceId, boolean, long, ToDeviceRpcRequestBody, boolean, Integer, String); when 'null'; then return 'Additional Info'")
  void testNewToDeviceRpcRequest_whenNull_thenReturnAdditionalInfo() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ToDeviceRpcRequestBody body = new ToDeviceRpcRequestBody("Method", "Params");

    // Act
    ToDeviceRpcRequest actualToDeviceRpcRequest = new ToDeviceRpcRequest(id, tenantId, null, true, 1L, body, true, 1,
        "Additional Info");

    // Assert
    assertEquals("Additional Info", actualToDeviceRpcRequest.getAdditionalInfo());
    assertNull(actualToDeviceRpcRequest.getDeviceId());
    assertEquals(1, actualToDeviceRpcRequest.getRetries().intValue());
    assertEquals(1L, actualToDeviceRpcRequest.getExpirationTime());
    assertTrue(actualToDeviceRpcRequest.isOneway());
    assertTrue(actualToDeviceRpcRequest.isPersisted());
    assertSame(tenantId, actualToDeviceRpcRequest.getTenantId());
    assertSame(body, actualToDeviceRpcRequest.getBody());
    assertSame(id, actualToDeviceRpcRequest.getId());
  }
}
