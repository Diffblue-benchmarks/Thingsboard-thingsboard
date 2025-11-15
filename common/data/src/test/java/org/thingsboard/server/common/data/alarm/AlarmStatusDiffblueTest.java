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
package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AlarmStatusDiffblueTest {
  /**
   * Method under test: {@link AlarmStatus#getAckSearchStatus()}
   */
  @Test
  void testGetAckSearchStatus() {
    // Arrange, Act and Assert
    assertEquals(AlarmSearchStatus.UNACK, AlarmStatus.ACTIVE_UNACK.getAckSearchStatus());
    assertEquals(AlarmSearchStatus.ACK, AlarmStatus.ACTIVE_ACK.getAckSearchStatus());
    assertEquals(AlarmSearchStatus.ACK, AlarmStatus.CLEARED_ACK.getAckSearchStatus());
  }

  /**
   * Method under test: {@link AlarmStatus#getClearSearchStatus()}
   */
  @Test
  void testGetClearSearchStatus() {
    // Arrange, Act and Assert
    assertEquals(AlarmSearchStatus.ACTIVE, AlarmStatus.ACTIVE_UNACK.getClearSearchStatus());
    assertEquals(AlarmSearchStatus.CLEARED, AlarmStatus.CLEARED_ACK.getClearSearchStatus());
    assertEquals(AlarmSearchStatus.CLEARED, AlarmStatus.CLEARED_UNACK.getClearSearchStatus());
  }

  /**
   * Method under test: {@link AlarmStatus#isAck()}
   */
  @Test
  void testIsAck() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatus.ACTIVE_UNACK.isAck());
    assertTrue(AlarmStatus.ACTIVE_ACK.isAck());
    assertTrue(AlarmStatus.CLEARED_ACK.isAck());
  }

  /**
   * Method under test: {@link AlarmStatus#isCleared()}
   */
  @Test
  void testIsCleared() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatus.ACTIVE_UNACK.isCleared());
    assertTrue(AlarmStatus.CLEARED_ACK.isCleared());
    assertTrue(AlarmStatus.CLEARED_UNACK.isCleared());
  }
}
