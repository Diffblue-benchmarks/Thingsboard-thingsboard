/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.msg.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rpc.ToDeviceRpcRequestBody;

class ToDeviceRpcRequestDiffblueTest {
  /**
   * Method under test: {@link ToDeviceRpcRequest#equals(Object)}
   */
  @Test
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
   * Method under test: {@link ToDeviceRpcRequest#equals(Object)}
   */
  @Test
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
   * Method under test: {@link ToDeviceRpcRequest#equals(Object)}
   */
  @Test
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
   * Method under test:
   * {@link ToDeviceRpcRequest#ToDeviceRpcRequest(UUID, TenantId, DeviceId, boolean, long, ToDeviceRpcRequestBody, boolean, Integer, String)}
   */
  @Test
  void testNewToDeviceRpcRequest() {
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
