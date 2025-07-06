package org.thingsboard.server.common.msg.rpc;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rpc.ToDeviceRpcRequestBody;

class ToDeviceRpcRequestActorMsgDiffblueTest {
  /**
   * Test {@link ToDeviceRpcRequestActorMsg#getDeviceId()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToDeviceRpcRequestActorMsg#getDeviceId()}
   */
  @Test
  @DisplayName("Test getDeviceId(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.DeviceId ToDeviceRpcRequestActorMsg.getDeviceId()"
  })
  void testGetDeviceId_thenReturnNull() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNull(
        new ToDeviceRpcRequestActorMsg(
                "42",
                new ToDeviceRpcRequest(
                    id,
                    tenantId,
                    null,
                    true,
                    1L,
                    new ToDeviceRpcRequestBody("Method", "Params"),
                    true,
                    1,
                    "Additional Info"))
            .getDeviceId());
  }

  /**
   * Test {@link ToDeviceRpcRequestActorMsg#getTenantId()}.
   *
   * <p>Method under test: {@link ToDeviceRpcRequestActorMsg#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId ToDeviceRpcRequestActorMsg.getTenantId()"})
  void testGetTenantId() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        tenantId,
        new ToDeviceRpcRequestActorMsg(
                "42",
                new ToDeviceRpcRequest(
                    id,
                    tenantId,
                    null,
                    true,
                    1L,
                    new ToDeviceRpcRequestBody("Method", "Params"),
                    true,
                    1,
                    "Additional Info"))
            .getTenantId());
  }
}
