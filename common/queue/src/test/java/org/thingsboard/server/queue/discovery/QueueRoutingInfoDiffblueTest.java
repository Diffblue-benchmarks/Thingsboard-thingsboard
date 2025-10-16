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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.ProcessingStrategy;
import org.thingsboard.server.common.data.queue.ProcessingStrategyType;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.queue.SubmitStrategy;
import org.thingsboard.server.common.data.queue.SubmitStrategyType;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.GetQueueRoutingInfoResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.QueueUpdateMsg;

class QueueRoutingInfoDiffblueTest {
  /**
   * Test {@link QueueRoutingInfo#QueueRoutingInfo(Queue)}.
   *
   * <ul>
   *   <li>Then return QueueName is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link QueueRoutingInfo#QueueRoutingInfo(Queue)}
   */
  @Test
  @DisplayName("Test new QueueRoutingInfo(Queue); then return QueueName is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueRoutingInfo.<init>(Queue)"})
  void testNewQueueRoutingInfo_thenReturnQueueNameIsName() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(15L);
    processingStrategy.setPauseBetweenRetries(15L);
    processingStrategy.setRetries(15);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration queueConfiguration = new TenantProfileQueueConfiguration();
    queueConfiguration.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    queueConfiguration.setConsumerPerPartition(true);
    queueConfiguration.setName("Name");
    queueConfiguration.setPackProcessingTimeout(15L);
    queueConfiguration.setPartitions(15);
    queueConfiguration.setPollInterval(42);
    queueConfiguration.setProcessingStrategy(processingStrategy);
    queueConfiguration.setSubmitStrategy(submitStrategy);
    queueConfiguration.setTopic("Topic");
    TenantId tenantId = new TenantId(UUID.randomUUID());

    Queue queue = new Queue(tenantId, queueConfiguration);

    // Act
    QueueRoutingInfo actualQueueRoutingInfo = new QueueRoutingInfo(queue);

    // Assert
    assertEquals("Name", actualQueueRoutingInfo.getQueueName());
    assertEquals("Topic", actualQueueRoutingInfo.getQueueTopic());
    assertEquals(15, actualQueueRoutingInfo.getPartitions());
    assertSame(tenantId, actualQueueRoutingInfo.getTenantId());
  }

  /**
   * Test {@link QueueRoutingInfo#QueueRoutingInfo(GetQueueRoutingInfoResponseMsg)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return QueueName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * QueueRoutingInfo#QueueRoutingInfo(TransportProtos.GetQueueRoutingInfoResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test new QueueRoutingInfo(GetQueueRoutingInfoResponseMsg); when DefaultInstance; then return QueueName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QueueRoutingInfo.<init>(TransportProtos.GetQueueRoutingInfoResponseMsg)"
  })
  void testNewQueueRoutingInfo_whenDefaultInstance_thenReturnQueueNameIsEmptyString() {
    // Arrange and Act
    QueueRoutingInfo actualQueueRoutingInfo =
        new QueueRoutingInfo(GetQueueRoutingInfoResponseMsg.getDefaultInstance());

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
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return QueueName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link QueueRoutingInfo#QueueRoutingInfo(QueueUpdateMsg)}
   */
  @Test
  @DisplayName(
      "Test new QueueRoutingInfo(QueueUpdateMsg); when DefaultInstance; then return QueueName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueRoutingInfo.<init>(QueueUpdateMsg)"})
  void testNewQueueRoutingInfo_whenDefaultInstance_thenReturnQueueNameIsEmptyString2() {
    // Arrange and Act
    QueueRoutingInfo actualQueueRoutingInfo =
        new QueueRoutingInfo(QueueUpdateMsg.getDefaultInstance());

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
   *
   * <ul>
   *   <li>When {@link Queue#Queue()}.
   *   <li>Then return QueueName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link QueueRoutingInfo#QueueRoutingInfo(Queue)}
   */
  @Test
  @DisplayName("Test new QueueRoutingInfo(Queue); when Queue(); then return QueueName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueRoutingInfo.<init>(Queue)"})
  void testNewQueueRoutingInfo_whenQueue_thenReturnQueueNameIsNull() {
    // Arrange and Act
    QueueRoutingInfo actualQueueRoutingInfo = new QueueRoutingInfo(new Queue());

    // Assert
    assertNull(actualQueueRoutingInfo.getQueueName());
    assertNull(actualQueueRoutingInfo.getQueueTopic());
    assertNull(actualQueueRoutingInfo.getTenantId());
    assertEquals(0, actualQueueRoutingInfo.getPartitions());
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}, and {@link QueueRoutingInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueRoutingInfo#equals(Object)}
   *   <li>{@link QueueRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());
    QueueRoutingInfo queueRoutingInfo2 = new QueueRoutingInfo(new Queue());

    // Act and Assert
    assertEquals(queueRoutingInfo, queueRoutingInfo2);
    assertEquals(queueRoutingInfo.hashCode(), queueRoutingInfo2.hashCode());
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}, and {@link QueueRoutingInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueRoutingInfo#equals(Object)}
   *   <li>{@link QueueRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(queueRoutingInfo.hashCode(), queueRoutingInfo2.hashCode());
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}, and {@link QueueRoutingInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueRoutingInfo#equals(Object)}
   *   <li>{@link QueueRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(queueRoutingInfo.hashCode(), queueRoutingInfo2.hashCode());
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}, and {@link QueueRoutingInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueRoutingInfo#equals(Object)}
   *   <li>{@link QueueRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueRoutingInfo(new Queue()), 1);
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration queueConfiguration = new TenantProfileQueueConfiguration();
    queueConfiguration.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    queueConfiguration.setConsumerPerPartition(true);
    queueConfiguration.setName("Name");
    queueConfiguration.setPackProcessingTimeout(1L);
    queueConfiguration.setPartitions(1);
    queueConfiguration.setPollInterval(42);
    queueConfiguration.setProcessingStrategy(processingStrategy);
    queueConfiguration.setSubmitStrategy(submitStrategy);
    queueConfiguration.setTopic("Topic");
    Queue queue = new Queue(new TenantId(UUID.randomUUID()), queueConfiguration);
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(queue);

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Queue queue = new Queue();
    queue.setTenantId(new TenantId(UUID.randomUUID()));
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(queue);

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Queue queue = new Queue();
    queue.setName("Name");
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(queue);

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Queue queue = new Queue();
    queue.setTopic("Topic");
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(queue);

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());

    Queue queue = new Queue();
    queue.setTenantId(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(queue));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());

    Queue queue = new Queue();
    queue.setName("Name");

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(queue));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());

    Queue queue = new Queue();
    queue.setTopic("Topic");

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(queue));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueRoutingInfo(new Queue()), null);
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueRoutingInfo.equals(Object)", "int QueueRoutingInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueRoutingInfo(new Queue()), "Different type to QueueRoutingInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int QueueRoutingInfo.getPartitions()",
    "QueueId QueueRoutingInfo.getQueueId()",
    "String QueueRoutingInfo.getQueueName()",
    "String QueueRoutingInfo.getQueueTopic()",
    "TenantId QueueRoutingInfo.getTenantId()",
    "boolean QueueRoutingInfo.isDuplicateMsgToAllPartitions()",
    "String QueueRoutingInfo.toString()"
  })
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
    assertEquals(
        "QueueRoutingInfo(tenantId=null, queueId=null, queueName=null, queueTopic=null, partitions=0,"
            + " duplicateMsgToAllPartitions=false)",
        actualToStringResult);
    assertNull(actualQueueName);
    assertNull(actualQueueTopic);
    assertNull(actualQueueId);
    assertNull(actualTenantId);
    assertEquals(0, actualPartitions);
    assertFalse(queueRoutingInfo.isDuplicateMsgToAllPartitions());
  }
}
