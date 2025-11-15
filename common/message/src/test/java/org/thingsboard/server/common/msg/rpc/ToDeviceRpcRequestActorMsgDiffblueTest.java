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
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDeviceRpcRequestActorMsg#getDeviceId()}
   */
  @Test
  @DisplayName("Test getDeviceId(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.DeviceId ToDeviceRpcRequestActorMsg.getDeviceId()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId ToDeviceRpcRequestActorMsg.getTenantId()"})
  void testGetTenantId_thenReturnTenantIdWithIdIsRandomUUID() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertSame(tenantId, (new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(id, tenantId, null, true, 1L,
        new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info"))).getTenantId());
  }
}
