package org.thingsboard.server.service.rpc;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rpc.ToDeviceRpcRequestBody;
import org.thingsboard.server.common.msg.rpc.ToDeviceRpcRequest;
import org.thingsboard.server.service.security.model.SecurityUser;

class LocalRequestMetaDataDiffblueTest {
  /**
   * Test {@link LocalRequestMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalRequestMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);
    ToDeviceRpcRequest request = new ToDeviceRpcRequest(id, tenantId, deviceId, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info");

    SecurityUser user = new SecurityUser();
    LocalRequestMetaData localRequestMetaData = new LocalRequestMetaData(request, user, new DeferredResult<>());
    UUID id2 = UUID.randomUUID();
    TenantId tenantId2 = new TenantId(UUID.randomUUID());
    ToDeviceRpcRequest request2 = new ToDeviceRpcRequest(id2, tenantId2, null, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info");

    SecurityUser user2 = new SecurityUser();

    // Act and Assert
    assertNotEquals(localRequestMetaData, new LocalRequestMetaData(request2, user2, new DeferredResult<>()));
  }

  /**
   * Test {@link LocalRequestMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocalRequestMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);
    ToDeviceRpcRequest request = new ToDeviceRpcRequest(id, tenantId, deviceId, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info");

    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertNotEquals(new LocalRequestMetaData(request, user, new DeferredResult<>()), "42");
  }
}
