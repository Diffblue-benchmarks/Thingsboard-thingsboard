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
package org.thingsboard.server.common.msg.timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.MsgType;

class DeviceActorServerSideRpcTimeoutMsgDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeviceActorServerSideRpcTimeoutMsg#DeviceActorServerSideRpcTimeoutMsg(Integer, long)}
   *   <li>{@link DeviceActorServerSideRpcTimeoutMsg#getMsgType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceActorServerSideRpcTimeoutMsg actualDeviceActorServerSideRpcTimeoutMsg = new DeviceActorServerSideRpcTimeoutMsg(
        1, 10L);
    MsgType actualMsgType = actualDeviceActorServerSideRpcTimeoutMsg.getMsgType();

    // Assert
    assertEquals(1, actualDeviceActorServerSideRpcTimeoutMsg.getId().intValue());
    assertEquals(10L, actualDeviceActorServerSideRpcTimeoutMsg.getTimeout());
    assertEquals(MsgType.DEVICE_ACTOR_SERVER_SIDE_RPC_TIMEOUT_MSG, actualMsgType);
  }
}
