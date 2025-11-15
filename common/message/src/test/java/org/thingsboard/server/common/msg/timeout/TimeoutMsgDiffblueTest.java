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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class TimeoutMsgDiffblueTest {
  /**
   * Method under test: {@link TimeoutMsg#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new DeviceActorServerSideRpcTimeoutMsg(1, 10L)).canEqual("Other"));
    assertTrue((new DeviceActorServerSideRpcTimeoutMsg(1, 10L)).canEqual(mock(TimeoutMsg.class)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TimeoutMsg#equals(Object)}
   *   <li>{@link TimeoutMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg = new DeviceActorServerSideRpcTimeoutMsg(1,
        10L);
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg2 = new DeviceActorServerSideRpcTimeoutMsg(1,
        10L);

    // Act and Assert
    assertEquals(deviceActorServerSideRpcTimeoutMsg, deviceActorServerSideRpcTimeoutMsg2);
    int expectedHashCodeResult = deviceActorServerSideRpcTimeoutMsg.hashCode();
    assertEquals(expectedHashCodeResult, deviceActorServerSideRpcTimeoutMsg2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TimeoutMsg#equals(Object)}
   *   <li>{@link TimeoutMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg = new DeviceActorServerSideRpcTimeoutMsg(null,
        10L);
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg2 = new DeviceActorServerSideRpcTimeoutMsg(
        null, 10L);

    // Act and Assert
    assertEquals(deviceActorServerSideRpcTimeoutMsg, deviceActorServerSideRpcTimeoutMsg2);
    int expectedHashCodeResult = deviceActorServerSideRpcTimeoutMsg.hashCode();
    assertEquals(expectedHashCodeResult, deviceActorServerSideRpcTimeoutMsg2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TimeoutMsg#equals(Object)}
   *   <li>{@link TimeoutMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg = new DeviceActorServerSideRpcTimeoutMsg(1,
        10L);

    // Act and Assert
    assertEquals(deviceActorServerSideRpcTimeoutMsg, deviceActorServerSideRpcTimeoutMsg);
    int expectedHashCodeResult = deviceActorServerSideRpcTimeoutMsg.hashCode();
    assertEquals(expectedHashCodeResult, deviceActorServerSideRpcTimeoutMsg.hashCode());
  }

  /**
   * Method under test: {@link TimeoutMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg = new DeviceActorServerSideRpcTimeoutMsg(2,
        10L);

    // Act and Assert
    assertNotEquals(deviceActorServerSideRpcTimeoutMsg, new DeviceActorServerSideRpcTimeoutMsg(1, 10L));
  }

  /**
   * Method under test: {@link TimeoutMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg = new DeviceActorServerSideRpcTimeoutMsg(null,
        10L);

    // Act and Assert
    assertNotEquals(deviceActorServerSideRpcTimeoutMsg, new DeviceActorServerSideRpcTimeoutMsg(1, 10L));
  }

  /**
   * Method under test: {@link TimeoutMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg = new DeviceActorServerSideRpcTimeoutMsg(1,
        1L);

    // Act and Assert
    assertNotEquals(deviceActorServerSideRpcTimeoutMsg, new DeviceActorServerSideRpcTimeoutMsg(1, 10L));
  }

  /**
   * Method under test: {@link TimeoutMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceActorServerSideRpcTimeoutMsg(1, 10L), null);
  }

  /**
   * Method under test: {@link TimeoutMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceActorServerSideRpcTimeoutMsg(1, 10L), "Different type to TimeoutMsg");
  }

  /**
   * Method under test: {@link TimeoutMsg#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertEquals(1, (new DeviceActorServerSideRpcTimeoutMsg(1, 10L)).getId().intValue());
  }

  /**
   * Method under test: {@link TimeoutMsg#getTimeout()}
   */
  @Test
  void testGetTimeout() {
    // Arrange, Act and Assert
    assertEquals(10L, (new DeviceActorServerSideRpcTimeoutMsg(1, 10L)).getTimeout());
  }

  /**
   * Method under test: {@link TimeoutMsg#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("TimeoutMsg(id=1, timeout=10)", (new DeviceActorServerSideRpcTimeoutMsg(1, 10L)).toString());
  }
}
