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
package org.thingsboard.server.common.data.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class QueueStatsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QueueStats#equals(Object)}
   *   <li>{@link QueueStats#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    QueueStats queueStats2 = new QueueStats();

    // Act and Assert
    assertEquals(queueStats, queueStats2);
    int expectedHashCodeResult = queueStats.hashCode();
    assertEquals(expectedHashCodeResult, queueStats2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QueueStats#equals(Object)}
   *   <li>{@link QueueStats#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setTenantId(TenantId.SYS_TENANT_ID);

    QueueStats queueStats2 = new QueueStats();
    queueStats2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(queueStats, queueStats2);
    int expectedHashCodeResult = queueStats.hashCode();
    assertEquals(expectedHashCodeResult, queueStats2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QueueStats#equals(Object)}
   *   <li>{@link QueueStats#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setQueueName("Queue Name");

    QueueStats queueStats2 = new QueueStats();
    queueStats2.setQueueName("Queue Name");

    // Act and Assert
    assertEquals(queueStats, queueStats2);
    int expectedHashCodeResult = queueStats.hashCode();
    assertEquals(expectedHashCodeResult, queueStats2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QueueStats#equals(Object)}
   *   <li>{@link QueueStats#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setServiceId("42");

    QueueStats queueStats2 = new QueueStats();
    queueStats2.setServiceId("42");

    // Act and Assert
    assertEquals(queueStats, queueStats2);
    int expectedHashCodeResult = queueStats.hashCode();
    assertEquals(expectedHashCodeResult, queueStats2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QueueStats#equals(Object)}
   *   <li>{@link QueueStats#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueStats queueStats = new QueueStats();

    // Act and Assert
    assertEquals(queueStats, queueStats);
    int expectedHashCodeResult = queueStats.hashCode();
    assertEquals(expectedHashCodeResult, queueStats.hashCode());
  }

  /**
   * Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueStats(), 1);
    assertNotEquals(new QueueStats(), mock(Queue.class));
  }

  /**
   * Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(queueStats, new QueueStats());
  }

  /**
   * Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setQueueName("Queue Name");

    // Act and Assert
    assertNotEquals(queueStats, new QueueStats());
  }

  /**
   * Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setServiceId("42");

    // Act and Assert
    assertNotEquals(queueStats, new QueueStats());
  }

  /**
   * Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(queueStats, new QueueStats());
  }

  /**
   * Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    QueueStats queueStats = new QueueStats();

    QueueStats queueStats2 = new QueueStats();
    queueStats2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(queueStats, queueStats2);
  }

  /**
   * Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    QueueStats queueStats = new QueueStats();

    QueueStats queueStats2 = new QueueStats();
    queueStats2.setQueueName("Queue Name");

    // Act and Assert
    assertNotEquals(queueStats, queueStats2);
  }

  /**
   * Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    QueueStats queueStats = new QueueStats();

    QueueStats queueStats2 = new QueueStats();
    queueStats2.setServiceId("42");

    // Act and Assert
    assertNotEquals(queueStats, queueStats2);
  }

  /**
   * Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueStats(), null);
  }

  /**
   * Method under test: {@link QueueStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueStats(), "Different type to QueueStats");
  }
}
