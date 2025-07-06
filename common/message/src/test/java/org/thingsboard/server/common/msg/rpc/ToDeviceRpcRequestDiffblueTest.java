package org.thingsboard.server.common.msg.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rpc.ToDeviceRpcRequestBody;

class ToDeviceRpcRequestDiffblueTest {
  /**
   * Test {@link ToDeviceRpcRequest#ToDeviceRpcRequest(UUID, TenantId, DeviceId, boolean, long,
   * ToDeviceRpcRequestBody, boolean, Integer, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Additional Info}.
   * </ul>
   *
   * <p>Method under test: {@link ToDeviceRpcRequest#ToDeviceRpcRequest(UUID, TenantId, DeviceId,
   * boolean, long, ToDeviceRpcRequestBody, boolean, Integer, String)}
   */
  @Test
  @DisplayName(
      "Test new ToDeviceRpcRequest(UUID, TenantId, DeviceId, boolean, long, ToDeviceRpcRequestBody, boolean, Integer, String); when 'null'; then return 'Additional Info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ToDeviceRpcRequest.<init>(UUID, TenantId, DeviceId, boolean, long, ToDeviceRpcRequestBody, boolean, Integer, String)"
  })
  void testNewToDeviceRpcRequest_whenNull_thenReturnAdditionalInfo() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ToDeviceRpcRequestBody body = new ToDeviceRpcRequestBody("Method", "Params");

    // Act
    ToDeviceRpcRequest actualToDeviceRpcRequest =
        new ToDeviceRpcRequest(id, tenantId, null, true, 1L, body, true, 1, "Additional Info");

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
