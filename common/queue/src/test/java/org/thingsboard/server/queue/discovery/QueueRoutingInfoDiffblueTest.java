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
package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
import org.thingsboard.server.gen.transport.TransportProtos;

class QueueRoutingInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QueueRoutingInfo#equals(Object)}
   *   <li>{@link QueueRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());
    QueueRoutingInfo queueRoutingInfo2 = new QueueRoutingInfo(new Queue());

    // Act and Assert
    assertEquals(queueRoutingInfo, queueRoutingInfo2);
    int expectedHashCodeResult = queueRoutingInfo.hashCode();
    assertEquals(expectedHashCodeResult, queueRoutingInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QueueRoutingInfo#equals(Object)}
   *   <li>{@link QueueRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());

    // Act and Assert
    assertEquals(queueRoutingInfo, queueRoutingInfo);
    int expectedHashCodeResult = queueRoutingInfo.hashCode();
    assertEquals(expectedHashCodeResult, queueRoutingInfo.hashCode());
  }

  /**
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(
        new Queue(tenantId, new TenantProfileQueueConfiguration()));

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.isDuplicateMsgToAllPartitions()).thenReturn(true);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getName()).thenReturn("Name");
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(queue.getId()).thenReturn(null);
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(queue);

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.isDuplicateMsgToAllPartitions()).thenReturn(true);
    when(queue.getPartitions()).thenReturn(0);
    when(queue.getName()).thenReturn("Name");
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(queue.getId()).thenReturn(null);
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(queue);

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueRoutingInfo(new Queue()), null);
  }

  /**
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueRoutingInfo(new Queue()), "Different type to QueueRoutingInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QueueRoutingInfo#toString()}
   *   <li>{@link QueueRoutingInfo#getPartitions()}
   *   <li>{@link QueueRoutingInfo#getQueueId()}
   *   <li>{@link QueueRoutingInfo#getQueueName()}
   *   <li>{@link QueueRoutingInfo#getQueueTopic()}
   *   <li>{@link QueueRoutingInfo#getTenantId()}
   *   <li>{@link QueueRoutingInfo#isDuplicateMsgToAllPartitions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());

    // Act
    String actualToStringResult = queueRoutingInfo.toString();
    int actualPartitions = queueRoutingInfo.getPartitions();
    QueueId actualQueueId = queueRoutingInfo.getQueueId();
    String actualQueueName = queueRoutingInfo.getQueueName();
    String actualQueueTopic = queueRoutingInfo.getQueueTopic();
    TenantId actualTenantId = queueRoutingInfo.getTenantId();

    // Assert
    assertEquals("QueueRoutingInfo(tenantId=null, queueId=null, queueName=null, queueTopic=null, partitions=0,"
        + " duplicateMsgToAllPartitions=false)", actualToStringResult);
    assertNull(actualQueueName);
    assertNull(actualQueueTopic);
    assertNull(actualQueueId);
    assertNull(actualTenantId);
    assertEquals(0, actualPartitions);
    assertFalse(queueRoutingInfo.isDuplicateMsgToAllPartitions());
  }

  /**
   * Method under test: {@link QueueRoutingInfo#QueueRoutingInfo(Queue)}
   */
  @Test
  void testNewQueueRoutingInfo() {
    // Arrange and Act
    QueueRoutingInfo actualQueueRoutingInfo = new QueueRoutingInfo(new Queue());

    // Assert
    assertNull(actualQueueRoutingInfo.getQueueName());
    assertNull(actualQueueRoutingInfo.getQueueTopic());
    assertNull(actualQueueRoutingInfo.getQueueId());
    assertNull(actualQueueRoutingInfo.getTenantId());
    assertEquals(0, actualQueueRoutingInfo.getPartitions());
    assertFalse(actualQueueRoutingInfo.isDuplicateMsgToAllPartitions());
  }

  /**
   * Method under test: {@link QueueRoutingInfo#QueueRoutingInfo(Queue)}
   */
  @Test
  void testNewQueueRoutingInfo2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    QueueRoutingInfo actualQueueRoutingInfo = new QueueRoutingInfo(
        new Queue(tenantId, new TenantProfileQueueConfiguration()));

    // Assert
    assertNull(actualQueueRoutingInfo.getQueueName());
    assertNull(actualQueueRoutingInfo.getQueueTopic());
    assertNull(actualQueueRoutingInfo.getQueueId());
    assertEquals(0, actualQueueRoutingInfo.getPartitions());
    assertFalse(actualQueueRoutingInfo.isDuplicateMsgToAllPartitions());
    assertSame(tenantId, actualQueueRoutingInfo.getTenantId());
  }

  /**
   * Method under test:
   * {@link QueueRoutingInfo#QueueRoutingInfo(TransportProtos.GetQueueRoutingInfoResponseMsg)}
   */
  @Test
  void testNewQueueRoutingInfo3() {
    // Arrange and Act
    QueueRoutingInfo actualQueueRoutingInfo = new QueueRoutingInfo(
        TransportProtos.GetQueueRoutingInfoResponseMsg.getDefaultInstance());

    // Assert
    assertEquals("", actualQueueRoutingInfo.getQueueName());
    assertEquals("", actualQueueRoutingInfo.getQueueTopic());
    QueueId queueId = actualQueueRoutingInfo.getQueueId();
    assertEquals("00000000-0000-0000-0000-000000000000", queueId.getId().toString());
    TenantId tenantId = actualQueueRoutingInfo.getTenantId();
    assertEquals("00000000-0000-0000-0000-000000000000", tenantId.getId().toString());
    assertEquals(0, actualQueueRoutingInfo.getPartitions());
    assertEquals(EntityType.QUEUE, queueId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(queueId.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertFalse(actualQueueRoutingInfo.isDuplicateMsgToAllPartitions());
  }

  /**
   * Method under test:
   * {@link QueueRoutingInfo#QueueRoutingInfo(TransportProtos.QueueUpdateMsg)}
   */
  @Test
  void testNewQueueRoutingInfo4() {
    // Arrange and Act
    QueueRoutingInfo actualQueueRoutingInfo = new QueueRoutingInfo(TransportProtos.QueueUpdateMsg.getDefaultInstance());

    // Assert
    assertEquals("", actualQueueRoutingInfo.getQueueName());
    assertEquals("", actualQueueRoutingInfo.getQueueTopic());
    QueueId queueId = actualQueueRoutingInfo.getQueueId();
    assertEquals("00000000-0000-0000-0000-000000000000", queueId.getId().toString());
    TenantId tenantId = actualQueueRoutingInfo.getTenantId();
    assertEquals("00000000-0000-0000-0000-000000000000", tenantId.getId().toString());
    assertEquals(0, actualQueueRoutingInfo.getPartitions());
    assertEquals(EntityType.QUEUE, queueId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(queueId.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertFalse(actualQueueRoutingInfo.isDuplicateMsgToAllPartitions());
  }
}
