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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.GetQueueRoutingInfoResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.QueueUpdateMsg;

class QueueRoutingInfoDiffblueTest {
  /**
   * Test {@link QueueRoutingInfo#QueueRoutingInfo(Queue)}.
   * <ul>
   *   <li>Then return TenantId is {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#QueueRoutingInfo(Queue)}
   */
  @Test
  @DisplayName("Test new QueueRoutingInfo(Queue); then return TenantId is TenantId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueRoutingInfo.<init>(Queue)"})
  void testNewQueueRoutingInfo_thenReturnTenantIdIsTenantIdWithIdIsRandomUUID() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertSame(tenantId,
        (new QueueRoutingInfo(new Queue(tenantId, new TenantProfileQueueConfiguration()))).getTenantId());
  }

  /**
   * Test {@link QueueRoutingInfo#QueueRoutingInfo(GetQueueRoutingInfoResponseMsg)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return QueueName is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#QueueRoutingInfo(TransportProtos.GetQueueRoutingInfoResponseMsg)}
   */
  @Test
  @DisplayName("Test new QueueRoutingInfo(GetQueueRoutingInfoResponseMsg); when DefaultInstance; then return QueueName is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueRoutingInfo.<init>(TransportProtos.GetQueueRoutingInfoResponseMsg)"})
  void testNewQueueRoutingInfo_whenDefaultInstance_thenReturnQueueNameIsEmptyString() {
    // Arrange and Act
    QueueRoutingInfo actualQueueRoutingInfo = new QueueRoutingInfo(GetQueueRoutingInfoResponseMsg.getDefaultInstance());

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
   * Test {@link QueueRoutingInfo#QueueRoutingInfo(QueueUpdateMsg)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return QueueName is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#QueueRoutingInfo(QueueUpdateMsg)}
   */
  @Test
  @DisplayName("Test new QueueRoutingInfo(QueueUpdateMsg); when DefaultInstance; then return QueueName is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueRoutingInfo.<init>(QueueUpdateMsg)"})
  void testNewQueueRoutingInfo_whenDefaultInstance_thenReturnQueueNameIsEmptyString2() {
    // Arrange and Act
    QueueRoutingInfo actualQueueRoutingInfo = new QueueRoutingInfo(QueueUpdateMsg.getDefaultInstance());

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
   * Test {@link QueueRoutingInfo#QueueRoutingInfo(Queue)}.
   * <ul>
   *   <li>When {@link Queue#Queue()}.</li>
   *   <li>Then return QueueName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#QueueRoutingInfo(Queue)}
   */
  @Test
  @DisplayName("Test new QueueRoutingInfo(Queue); when Queue(); then return QueueName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueRoutingInfo.<init>(Queue)"})
  void testNewQueueRoutingInfo_whenQueue_thenReturnQueueNameIsNull() {
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
   * Test {@link QueueRoutingInfo#equals(Object)}, and {@link QueueRoutingInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueRoutingInfo#equals(Object)}
   *   <li>{@link QueueRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
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
   * Test {@link QueueRoutingInfo#equals(Object)}, and {@link QueueRoutingInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueRoutingInfo#equals(Object)}
   *   <li>{@link QueueRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Queue queue = new Queue();
    queue.setName("Name");
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(queue);

    Queue queue2 = new Queue();
    queue2.setName("Name");
    QueueRoutingInfo queueRoutingInfo2 = new QueueRoutingInfo(queue2);

    // Act and Assert
    assertEquals(queueRoutingInfo, queueRoutingInfo2);
    int expectedHashCodeResult = queueRoutingInfo.hashCode();
    assertEquals(expectedHashCodeResult, queueRoutingInfo2.hashCode());
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}, and {@link QueueRoutingInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueRoutingInfo#equals(Object)}
   *   <li>{@link QueueRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Queue queue = new Queue();
    queue.setTopic("Topic");
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(queue);

    Queue queue2 = new Queue();
    queue2.setTopic("Topic");
    QueueRoutingInfo queueRoutingInfo2 = new QueueRoutingInfo(queue2);

    // Act and Assert
    assertEquals(queueRoutingInfo, queueRoutingInfo2);
    int expectedHashCodeResult = queueRoutingInfo.hashCode();
    assertEquals(expectedHashCodeResult, queueRoutingInfo2.hashCode());
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}, and {@link QueueRoutingInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueRoutingInfo#equals(Object)}
   *   <li>{@link QueueRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());

    // Act and Assert
    assertEquals(queueRoutingInfo, queueRoutingInfo);
    int expectedHashCodeResult = queueRoutingInfo.hashCode();
    assertEquals(expectedHashCodeResult, queueRoutingInfo.hashCode());
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(
        new Queue(tenantId, new TenantProfileQueueConfiguration()));

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue(tenantId, new TenantProfileQueueConfiguration())));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Queue queue = new Queue();
    queue.setName("Name");
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(queue);

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Queue queue = new Queue();
    queue.setTopic("Topic");
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(queue);

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Queue queue = new Queue();
    queue.setPartitions(1);
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(queue);

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());

    Queue queue = new Queue();
    queue.setName("Name");

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(queue));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());

    Queue queue = new Queue();
    queue.setTopic("Topic");

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(queue));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue(new QueueId(UUID.randomUUID())));

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue(new QueueId(UUID.randomUUID()))));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueRoutingInfo(new Queue()), null);
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueRoutingInfo(new Queue()), "Different type to QueueRoutingInfo");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int QueueRoutingInfo.getPartitions()", "QueueId QueueRoutingInfo.getQueueId()",
      "String QueueRoutingInfo.getQueueName()", "String QueueRoutingInfo.getQueueTopic()",
      "TenantId QueueRoutingInfo.getTenantId()", "boolean QueueRoutingInfo.isDuplicateMsgToAllPartitions()",
      "String QueueRoutingInfo.toString()"})
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
}
