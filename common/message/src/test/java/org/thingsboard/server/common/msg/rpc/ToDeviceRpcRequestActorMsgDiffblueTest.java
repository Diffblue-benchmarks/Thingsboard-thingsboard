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

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rpc.ToDeviceRpcRequestBody;

class ToDeviceRpcRequestActorMsgDiffblueTest {
  /**
   * Method under test: {@link ToDeviceRpcRequestActorMsg#equals(Object)}
   */
  @Test
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
   * Method under test: {@link ToDeviceRpcRequestActorMsg#getDeviceId()}
   */
  @Test
  void testGetDeviceId() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull((new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(id, tenantId, null, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info"))).getDeviceId());
  }

  /**
   * Method under test: {@link ToDeviceRpcRequestActorMsg#getTenantId()}
   */
  @Test
  void testGetTenantId() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertSame(tenantId, (new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(id, tenantId, null, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info"))).getTenantId());
  }

  /**
   * Method under test: {@link ToDeviceRpcRequestActorMsg#equals(Object)}
   */
  @Test
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
   * Method under test: {@link ToDeviceRpcRequestActorMsg#equals(Object)}
   */
  @Test
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
