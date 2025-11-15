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
package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.MsgType;

class PartitionChangeMsgDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PartitionChangeMsg#equals(Object)}
   *   <li>{@link PartitionChangeMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PartitionChangeMsg partitionChangeMsg = new PartitionChangeMsg(ServiceType.TB_CORE);
    PartitionChangeMsg partitionChangeMsg2 = new PartitionChangeMsg(ServiceType.TB_CORE);

    // Act and Assert
    assertEquals(partitionChangeMsg, partitionChangeMsg2);
    int expectedHashCodeResult = partitionChangeMsg.hashCode();
    assertEquals(expectedHashCodeResult, partitionChangeMsg2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PartitionChangeMsg#equals(Object)}
   *   <li>{@link PartitionChangeMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PartitionChangeMsg partitionChangeMsg = new PartitionChangeMsg(null);
    PartitionChangeMsg partitionChangeMsg2 = new PartitionChangeMsg(null);

    // Act and Assert
    assertEquals(partitionChangeMsg, partitionChangeMsg2);
    int expectedHashCodeResult = partitionChangeMsg.hashCode();
    assertEquals(expectedHashCodeResult, partitionChangeMsg2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PartitionChangeMsg#equals(Object)}
   *   <li>{@link PartitionChangeMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PartitionChangeMsg partitionChangeMsg = new PartitionChangeMsg(ServiceType.TB_CORE);

    // Act and Assert
    assertEquals(partitionChangeMsg, partitionChangeMsg);
    int expectedHashCodeResult = partitionChangeMsg.hashCode();
    assertEquals(expectedHashCodeResult, partitionChangeMsg.hashCode());
  }

  /**
   * Method under test: {@link PartitionChangeMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PartitionChangeMsg partitionChangeMsg = new PartitionChangeMsg(null);

    // Act and Assert
    assertNotEquals(partitionChangeMsg, new PartitionChangeMsg(ServiceType.TB_CORE));
  }

  /**
   * Method under test: {@link PartitionChangeMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PartitionChangeMsg partitionChangeMsg = new PartitionChangeMsg(ServiceType.TB_RULE_ENGINE);

    // Act and Assert
    assertNotEquals(partitionChangeMsg, new PartitionChangeMsg(ServiceType.TB_CORE));
  }

  /**
   * Method under test: {@link PartitionChangeMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PartitionChangeMsg(ServiceType.TB_CORE), null);
  }

  /**
   * Method under test: {@link PartitionChangeMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PartitionChangeMsg(ServiceType.TB_CORE), "Different type to PartitionChangeMsg");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PartitionChangeMsg#PartitionChangeMsg(ServiceType)}
   *   <li>{@link PartitionChangeMsg#toString()}
   *   <li>{@link PartitionChangeMsg#getMsgType()}
   *   <li>{@link PartitionChangeMsg#getServiceType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PartitionChangeMsg actualPartitionChangeMsg = new PartitionChangeMsg(ServiceType.TB_CORE);
    String actualToStringResult = actualPartitionChangeMsg.toString();
    MsgType actualMsgType = actualPartitionChangeMsg.getMsgType();

    // Assert
    assertEquals("PartitionChangeMsg(serviceType=TB_CORE)", actualToStringResult);
    assertEquals(MsgType.PARTITION_CHANGE_MSG, actualMsgType);
    assertEquals(ServiceType.TB_CORE, actualPartitionChangeMsg.getServiceType());
  }
}
