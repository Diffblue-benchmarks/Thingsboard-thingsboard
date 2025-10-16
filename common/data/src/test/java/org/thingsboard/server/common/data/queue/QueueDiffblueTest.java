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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;

class QueueDiffblueTest {
  /**
   * Test {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}.
   *
   * <p>Method under test: {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}
   */
  @Test
  @DisplayName("Test new Queue(TenantId, TenantProfileQueueConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Queue.<init>(TenantId, TenantProfileQueueConfiguration)"})
  void testNewQueue() {
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
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    queueConfiguration.setAdditionalInfo(new ArrayNode(nf));
    queueConfiguration.setConsumerPerPartition(true);
    queueConfiguration.setName("Name");
    queueConfiguration.setPackProcessingTimeout(1L);
    queueConfiguration.setPartitions(1);
    queueConfiguration.setPollInterval(42);
    queueConfiguration.setProcessingStrategy(processingStrategy);
    queueConfiguration.setSubmitStrategy(submitStrategy);
    queueConfiguration.setTopic("Topic");

    // Act
    Queue actualQueue = new Queue(TenantId.SYS_TENANT_ID, queueConfiguration);

    // Assert
    JsonNode additionalInfo = actualQueue.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ArrayNode);
    assertEquals("[ ]", additionalInfo.toPrettyString());
    assertEquals(0, additionalInfo.size());
    assertFalse(additionalInfo.elements().hasNext());
    assertTrue(additionalInfo.isEmpty());
  }

  /**
   * Test {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return not ConsumerPerPartition.
   * </ul>
   *
   * <p>Method under test: {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}
   */
  @Test
  @DisplayName(
      "Test new Queue(TenantId, TenantProfileQueueConfiguration); given 'false'; then return not ConsumerPerPartition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Queue.<init>(TenantId, TenantProfileQueueConfiguration)"})
  void testNewQueue_givenFalse_thenReturnNotConsumerPerPartition() {
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
    MissingNode additionalInfo = MissingNode.getInstance();
    queueConfiguration.setAdditionalInfo(additionalInfo);
    queueConfiguration.setConsumerPerPartition(false);
    queueConfiguration.setName("Name");
    queueConfiguration.setPackProcessingTimeout(1L);
    queueConfiguration.setPartitions(1);
    queueConfiguration.setPollInterval(42);
    queueConfiguration.setProcessingStrategy(processingStrategy);
    queueConfiguration.setSubmitStrategy(submitStrategy);
    queueConfiguration.setTopic("Topic");

    // Act
    Queue actualQueue = new Queue(TenantId.SYS_TENANT_ID, queueConfiguration);

    // Assert
    assertFalse(actualQueue.isConsumerPerPartition());
    assertSame(additionalInfo, actualQueue.getAdditionalInfo());
  }

  /**
   * Test {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>Then return AdditionalInfo is Instance.
   * </ul>
   *
   * <p>Method under test: {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}
   */
  @Test
  @DisplayName(
      "Test new Queue(TenantId, TenantProfileQueueConfiguration); given Instance; then return AdditionalInfo is Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Queue.<init>(TenantId, TenantProfileQueueConfiguration)"})
  void testNewQueue_givenInstance_thenReturnAdditionalInfoIsInstance() {
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
    Queue actualQueue = new Queue(TenantId.SYS_TENANT_ID, queueConfiguration);

    // Assert
    assertSame(additionalInfo, actualQueue.getAdditionalInfo());
  }

  /**
   * Test {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   *   <li>Then return AdditionalInfo is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}
   */
  @Test
  @DisplayName(
      "Test new Queue(TenantId, TenantProfileQueueConfiguration); given valueOf ten; then return AdditionalInfo is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Queue.<init>(TenantId, TenantProfileQueueConfiguration)"})
  void testNewQueue_givenValueOfTen_thenReturnAdditionalInfoIsValueOfTen() {
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
    DoubleNode additionalInfo = DoubleNode.valueOf(10.0d);
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
    Queue actualQueue = new Queue(TenantId.SYS_TENANT_ID, queueConfiguration);

    // Assert
    assertSame(additionalInfo, actualQueue.getAdditionalInfo());
  }

  /**
   * Test {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo elements next return {@link POJONode}.
   * </ul>
   *
   * <p>Method under test: {@link Queue#Queue(TenantId, TenantProfileQueueConfiguration)}
   */
  @Test
  @DisplayName(
      "Test new Queue(TenantId, TenantProfileQueueConfiguration); then AdditionalInfo elements next return POJONode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Queue.<init>(TenantId, TenantProfileQueueConfiguration)"})
  void testNewQueue_thenAdditionalInfoElementsNextReturnPOJONode() {
    // Arrange
    TenantProfileQueueConfiguration queueConfiguration = new TenantProfileQueueConfiguration();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode additionalInfo = new ArrayNode(nf);
    additionalInfo.addPOJO("Pojo");
    queueConfiguration.setAdditionalInfo(additionalInfo);
    queueConfiguration.setConsumerPerPartition(true);
    queueConfiguration.setName("Name");
    queueConfiguration.setPackProcessingTimeout(1L);
    queueConfiguration.setPartitions(1);
    queueConfiguration.setPollInterval(42);

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    queueConfiguration.setProcessingStrategy(processingStrategy);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);
    queueConfiguration.setSubmitStrategy(submitStrategy);
    queueConfiguration.setTopic("Topic");

    // Act
    Queue actualQueue = new Queue(TenantId.SYS_TENANT_ID, queueConfiguration);

    // Assert
    JsonNode additionalInfo2 = actualQueue.getAdditionalInfo();
    assertTrue(additionalInfo2 instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = additionalInfo2.elements();
    JsonNode nextResult = elementsResult.next();
    assertFalse(elementsResult.hasNext());
    assertTrue(nextResult instanceof POJONode);
    assertFalse(additionalInfo2.isEmpty());
    Iterator<JsonNode> iteratorResult = additionalInfo2.iterator();
    JsonNode actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(nextResult, actualNextResult);
    assertEquals(1, additionalInfo2.size());
    assertEquals("[ \"Pojo\" ]", additionalInfo2.toPrettyString());
  }

  /**
   * Test {@link Queue#getCustomProperties()}.
   *
   * <ul>
   *   <li>Given {@link ProcessingStrategy} (default constructor) FailurePercentage is ten.
   * </ul>
   *
   * <p>Method under test: {@link Queue#getCustomProperties()}
   */
  @Test
  @DisplayName(
      "Test getCustomProperties(); given ProcessingStrategy (default constructor) FailurePercentage is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Queue.getCustomProperties()"})
  void testGetCustomProperties_givenProcessingStrategyFailurePercentageIsTen() {
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
    Queue queue = new Queue(TenantId.SYS_TENANT_ID, queueConfiguration);

    // Act and Assert
    assertNull(queue.getCustomProperties());
  }

  /**
   * Test {@link Queue#getCustomProperties()}.
   *
   * <ul>
   *   <li>Given {@link Queue#Queue()}.
   * </ul>
   *
   * <p>Method under test: {@link Queue#getCustomProperties()}
   */
  @Test
  @DisplayName("Test getCustomProperties(); given Queue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Queue.getCustomProperties()"})
  void testGetCustomProperties_givenQueue() {
    // Arrange, Act and Assert
    assertNull(new Queue().getCustomProperties());
  }

  /**
   * Test {@link Queue#isDuplicateMsgToAllPartitions()}.
   *
   * <ul>
   *   <li>Given {@link ProcessingStrategy} (default constructor) FailurePercentage is ten.
   * </ul>
   *
   * <p>Method under test: {@link Queue#isDuplicateMsgToAllPartitions()}
   */
  @Test
  @DisplayName(
      "Test isDuplicateMsgToAllPartitions(); given ProcessingStrategy (default constructor) FailurePercentage is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.isDuplicateMsgToAllPartitions()"})
  void testIsDuplicateMsgToAllPartitions_givenProcessingStrategyFailurePercentageIsTen() {
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
    Queue queue = new Queue(TenantId.SYS_TENANT_ID, queueConfiguration);

    // Act and Assert
    assertFalse(queue.isDuplicateMsgToAllPartitions());
  }

  /**
   * Test {@link Queue#isDuplicateMsgToAllPartitions()}.
   *
   * <ul>
   *   <li>Given {@link Queue#Queue()}.
   * </ul>
   *
   * <p>Method under test: {@link Queue#isDuplicateMsgToAllPartitions()}
   */
  @Test
  @DisplayName("Test isDuplicateMsgToAllPartitions(); given Queue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.isDuplicateMsgToAllPartitions()"})
  void testIsDuplicateMsgToAllPartitions_givenQueue() {
    // Arrange, Act and Assert
    assertFalse(new Queue().isDuplicateMsgToAllPartitions());
  }

  /**
   * Test {@link Queue#equals(Object)}, and {@link Queue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Queue#equals(Object)}
   *   <li>{@link Queue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Queue queue = new Queue();
    Queue queue2 = new Queue();

    // Act and Assert
    assertEquals(queue, queue2);
    assertEquals(queue.hashCode(), queue2.hashCode());
  }

  /**
   * Test {@link Queue#equals(Object)}, and {@link Queue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Queue#equals(Object)}
   *   <li>{@link Queue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
    Queue queue = new Queue(TenantId.SYS_TENANT_ID, queueConfiguration);

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration queueConfiguration2 = new TenantProfileQueueConfiguration();
    queueConfiguration2.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    queueConfiguration2.setConsumerPerPartition(true);
    queueConfiguration2.setName("Name");
    queueConfiguration2.setPackProcessingTimeout(1L);
    queueConfiguration2.setPartitions(1);
    queueConfiguration2.setPollInterval(42);
    queueConfiguration2.setProcessingStrategy(processingStrategy2);
    queueConfiguration2.setSubmitStrategy(submitStrategy2);
    queueConfiguration2.setTopic("Topic");
    Queue queue2 = new Queue(TenantId.SYS_TENANT_ID, queueConfiguration2);

    // Act and Assert
    assertEquals(queue, queue2);
    assertEquals(queue.hashCode(), queue2.hashCode());
  }

  /**
   * Test {@link Queue#equals(Object)}, and {@link Queue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Queue#equals(Object)}
   *   <li>{@link Queue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Queue queue = new Queue();

    // Act and Assert
    assertEquals(queue, queue);
    int expectedHashCodeResult = queue.hashCode();
    assertEquals(expectedHashCodeResult, queue.hashCode());
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
    Queue queue = new Queue(TenantId.SYS_TENANT_ID, queueConfiguration);

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Queue queue = new Queue();
    queue.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Queue queue = new Queue();
    queue.setName("Name");

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Queue queue = new Queue();
    queue.setTopic("Topic");

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Queue queue = new Queue();
    queue.setPartitions(1);

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Queue queue = new Queue();
    queue.setConsumerPerPartition(true);

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Queue queue = new Queue();
    queue.setPackProcessingTimeout(1L);

    // Act and Assert
    assertNotEquals(queue, new Queue());
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Queue queue = new Queue();

    Queue queue2 = new Queue();
    queue2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(queue, queue2);
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Queue queue = new Queue();

    Queue queue2 = new Queue();
    queue2.setName("Name");

    // Act and Assert
    assertNotEquals(queue, queue2);
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Queue queue = new Queue();

    Queue queue2 = new Queue();
    queue2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(queue, queue2);
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Queue queue = new Queue();

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    Queue queue2 = new Queue();
    queue2.setSubmitStrategy(submitStrategy);

    // Act and Assert
    assertNotEquals(queue, queue2);
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    Queue queue = new Queue();

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    Queue queue2 = new Queue();
    queue2.setProcessingStrategy(processingStrategy);

    // Act and Assert
    assertNotEquals(queue, queue2);
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Queue(), null);
  }

  /**
   * Test {@link Queue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Queue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Queue.equals(Object)", "int Queue.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Queue(), "Different type to Queue");
  }
}
