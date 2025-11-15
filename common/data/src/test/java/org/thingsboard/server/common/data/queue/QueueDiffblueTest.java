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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;

class QueueDiffblueTest {
  /**
   * Method under test: {@link Queue#getCustomProperties()}
   */
  @Test
  void testGetCustomProperties() {
    // Arrange, Act and Assert
    assertNull((new Queue()).getCustomProperties());
    assertNull((new Queue(TenantId.SYS_TENANT_ID, new TenantProfileQueueConfiguration())).getCustomProperties());
  }

  /**
   * Method under test: {@link Queue#isDuplicateMsgToAllPartitions()}
   */
  @Test
  void testIsDuplicateMsgToAllPartitions() {
    // Arrange, Act and Assert
    assertFalse((new Queue()).isDuplicateMsgToAllPartitions());
    assertFalse(
        (new Queue(TenantId.SYS_TENANT_ID, new TenantProfileQueueConfiguration())).isDuplicateMsgToAllPartitions());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Queue#equals(Object)}
   *   <li>{@link Queue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Queue queue = new Queue();
    Queue queue2 = new Queue();

    // Act and Assert
    assertEquals(queue, queue2);
    int expectedHashCodeResult = queue.hashCode();
    assertEquals(expectedHashCodeResult, queue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Queue#equals(Object)}
   *   <li>{@link Queue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Queue queue = new Queue();

    // Act and Assert
    assertEquals(queue, queue);
    int expectedHashCodeResult = queue.hashCode();
    assertEquals(expectedHashCodeResult, queue.hashCode());
  }

  /**
   * Method under test: {@link Queue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Queue queue = new Queue(TenantId.SYS_TENANT_ID, new TenantProfileQueueConfiguration());

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Method under test: {@link Queue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Queue queue = new Queue();

    // Act and Assert
    assertNotEquals(queue, new Queue(TenantId.SYS_TENANT_ID, new TenantProfileQueueConfiguration()));
  }

  /**
   * Method under test: {@link Queue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Queue queue = new Queue();
    queue.setName("Name");

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Method under test: {@link Queue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Queue queue = new Queue();
    queue.setTopic("Topic");

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Method under test: {@link Queue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Queue queue = new Queue();
    queue.setPollInterval(42);

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Method under test: {@link Queue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Queue queue = new Queue();
    queue.setPartitions(1);

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Method under test: {@link Queue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Queue queue = new Queue();
    queue.setConsumerPerPartition(true);

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Method under test: {@link Queue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Queue queue = new Queue();
    queue.setPackProcessingTimeout(1L);

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Method under test: {@link Queue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    Queue queue = new Queue();
    queue.setSubmitStrategy(submitStrategy);

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Method under test: {@link Queue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    Queue queue = new Queue();
    queue.setProcessingStrategy(processingStrategy);

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Method under test: {@link Queue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
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
    TenantProfileQueueConfiguration queueConfiguration = mock(TenantProfileQueueConfiguration.class);
    when(queueConfiguration.isConsumerPerPartition()).thenReturn(true);
    when(queueConfiguration.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(queueConfiguration.getPartitions()).thenReturn(1);
    when(queueConfiguration.getPollInterval()).thenReturn(42);
    when(queueConfiguration.getName()).thenReturn("Name");
    when(queueConfiguration.getTopic()).thenReturn("Topic");
    when(queueConfiguration.getPackProcessingTimeout()).thenReturn(1L);
    when(queueConfiguration.getProcessingStrategy()).thenReturn(processingStrategy);
    when(queueConfiguration.getSubmitStrategy()).thenReturn(submitStrategy);
    Queue queue = new Queue(TenantId.SYS_TENANT_ID, queueConfiguration);

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Method under test: {@link Queue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Queue(), null);
  }

  /**
   * Method under test: {@link Queue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Queue(), "Different type to Queue");
  }

  /**
   * Method under test:
   * {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}
   */
  @Test
  void testNewQueue() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

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
    MissingNode additionalInfo = MissingNode.getInstance();
    queueConfiguration.setAdditionalInfo(additionalInfo);
    queueConfiguration.setConsumerPerPartition(true);
    queueConfiguration.setName("Name");
    queueConfiguration.setPackProcessingTimeout(1L);
    queueConfiguration.setPartitions(1);
    queueConfiguration.setPollInterval(42);
    queueConfiguration.setProcessingStrategy(processingStrategy);
    queueConfiguration.setSubmitStrategy(submitStrategy);
    queueConfiguration.setTopic("Topic");

    // Act
    Queue actualQueue = new Queue(tenantId, queueConfiguration);

    // Assert
    assertEquals("Name", actualQueue.getName());
    assertEquals("Topic", actualQueue.getTopic());
    assertNull(actualQueue.getCustomProperties());
    assertNull(actualQueue.getUuidId());
    assertNull(actualQueue.getId());
    assertEquals(0L, actualQueue.getCreatedTime());
    assertEquals(1, actualQueue.getPartitions());
    assertEquals(1L, actualQueue.getPackProcessingTimeout());
    assertEquals(42, actualQueue.getPollInterval());
    assertTrue(actualQueue.isConsumerPerPartition());
    assertSame(processingStrategy, actualQueue.getProcessingStrategy());
    assertSame(submitStrategy, actualQueue.getSubmitStrategy());
    assertSame(additionalInfo, actualQueue.getAdditionalInfo());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualQueue.getTenantId());
  }

  /**
   * Method under test:
   * {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}
   */
  @Test
  void testNewQueue2() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

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
    ArrayNode additionalInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    queueConfiguration.setAdditionalInfo(additionalInfo);
    queueConfiguration.setConsumerPerPartition(true);
    queueConfiguration.setName("Name");
    queueConfiguration.setPackProcessingTimeout(1L);
    queueConfiguration.setPartitions(1);
    queueConfiguration.setPollInterval(42);
    queueConfiguration.setProcessingStrategy(processingStrategy);
    queueConfiguration.setSubmitStrategy(submitStrategy);
    queueConfiguration.setTopic("Topic");

    // Act
    Queue actualQueue = new Queue(tenantId, queueConfiguration);

    // Assert
    assertEquals("Name", actualQueue.getName());
    assertEquals("Topic", actualQueue.getTopic());
    assertNull(actualQueue.getCustomProperties());
    assertNull(actualQueue.getUuidId());
    assertNull(actualQueue.getId());
    assertEquals(0L, actualQueue.getCreatedTime());
    assertEquals(1, actualQueue.getPartitions());
    assertEquals(1L, actualQueue.getPackProcessingTimeout());
    assertEquals(42, actualQueue.getPollInterval());
    assertTrue(actualQueue.isConsumerPerPartition());
    assertSame(additionalInfo, actualQueue.getAdditionalInfo());
    assertSame(processingStrategy, actualQueue.getProcessingStrategy());
    assertSame(submitStrategy, actualQueue.getSubmitStrategy());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualQueue.getTenantId());
  }

  /**
   * Method under test:
   * {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}
   */
  @Test
  void testNewQueue3() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

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
    IntNode additionalInfo = IntNode.valueOf(3);
    queueConfiguration.setAdditionalInfo(additionalInfo);
    queueConfiguration.setConsumerPerPartition(true);
    queueConfiguration.setName("Name");
    queueConfiguration.setPackProcessingTimeout(1L);
    queueConfiguration.setPartitions(1);
    queueConfiguration.setPollInterval(42);
    queueConfiguration.setProcessingStrategy(processingStrategy);
    queueConfiguration.setSubmitStrategy(submitStrategy);
    queueConfiguration.setTopic("Topic");

    // Act
    Queue actualQueue = new Queue(tenantId, queueConfiguration);

    // Assert
    assertEquals("Name", actualQueue.getName());
    assertEquals("Topic", actualQueue.getTopic());
    assertNull(actualQueue.getCustomProperties());
    assertNull(actualQueue.getUuidId());
    assertNull(actualQueue.getId());
    assertEquals(0L, actualQueue.getCreatedTime());
    assertEquals(1, actualQueue.getPartitions());
    assertEquals(1L, actualQueue.getPackProcessingTimeout());
    assertEquals(42, actualQueue.getPollInterval());
    assertTrue(actualQueue.isConsumerPerPartition());
    assertSame(processingStrategy, actualQueue.getProcessingStrategy());
    assertSame(submitStrategy, actualQueue.getSubmitStrategy());
    assertSame(additionalInfo, actualQueue.getAdditionalInfo());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualQueue.getTenantId());
  }

  /**
   * Method under test:
   * {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}
   */
  @Test
  void testNewQueue4() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    ArrayNode additionalInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalInfo.addPOJO("Pojo");

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
    queueConfiguration.setAdditionalInfo(additionalInfo);
    queueConfiguration.setConsumerPerPartition(true);
    queueConfiguration.setName("Name");
    queueConfiguration.setPackProcessingTimeout(1L);
    queueConfiguration.setPartitions(1);
    queueConfiguration.setPollInterval(42);
    queueConfiguration.setProcessingStrategy(processingStrategy);
    queueConfiguration.setSubmitStrategy(submitStrategy);
    queueConfiguration.setTopic("Topic");

    // Act
    Queue actualQueue = new Queue(tenantId, queueConfiguration);

    // Assert
    assertEquals("Name", actualQueue.getName());
    assertEquals("Topic", actualQueue.getTopic());
    assertNull(actualQueue.getCustomProperties());
    assertNull(actualQueue.getUuidId());
    assertNull(actualQueue.getId());
    assertEquals(0L, actualQueue.getCreatedTime());
    assertEquals(1, actualQueue.getPartitions());
    assertEquals(1L, actualQueue.getPackProcessingTimeout());
    assertEquals(42, actualQueue.getPollInterval());
    assertTrue(actualQueue.isConsumerPerPartition());
    assertSame(additionalInfo, actualQueue.getAdditionalInfo());
    assertSame(processingStrategy, actualQueue.getProcessingStrategy());
    assertSame(submitStrategy, actualQueue.getSubmitStrategy());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualQueue.getTenantId());
  }

  /**
   * Method under test:
   * {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}
   */
  @Test
  void testNewQueue5() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    ArrayNode additionalInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalInfo.addPOJO(2);

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
    queueConfiguration.setAdditionalInfo(additionalInfo);
    queueConfiguration.setConsumerPerPartition(true);
    queueConfiguration.setName("Name");
    queueConfiguration.setPackProcessingTimeout(1L);
    queueConfiguration.setPartitions(1);
    queueConfiguration.setPollInterval(42);
    queueConfiguration.setProcessingStrategy(processingStrategy);
    queueConfiguration.setSubmitStrategy(submitStrategy);
    queueConfiguration.setTopic("Topic");

    // Act
    Queue actualQueue = new Queue(tenantId, queueConfiguration);

    // Assert
    assertEquals("Name", actualQueue.getName());
    assertEquals("Topic", actualQueue.getTopic());
    assertNull(actualQueue.getCustomProperties());
    assertNull(actualQueue.getUuidId());
    assertNull(actualQueue.getId());
    assertEquals(0L, actualQueue.getCreatedTime());
    assertEquals(1, actualQueue.getPartitions());
    assertEquals(1L, actualQueue.getPackProcessingTimeout());
    assertEquals(42, actualQueue.getPollInterval());
    assertTrue(actualQueue.isConsumerPerPartition());
    assertSame(additionalInfo, actualQueue.getAdditionalInfo());
    assertSame(processingStrategy, actualQueue.getProcessingStrategy());
    assertSame(submitStrategy, actualQueue.getSubmitStrategy());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualQueue.getTenantId());
  }
}
