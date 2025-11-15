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
package org.thingsboard.server.common.data.tenant.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.queue.ProcessingStrategy;
import org.thingsboard.server.common.data.queue.ProcessingStrategyType;
import org.thingsboard.server.common.data.queue.SubmitStrategy;
import org.thingsboard.server.common.data.queue.SubmitStrategyType;

class TenantProfileQueueConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileQueueConfiguration#equals(Object)}
   *   <li>{@link TenantProfileQueueConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
    int expectedHashCodeResult = tenantProfileQueueConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileQueueConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileQueueConfiguration#equals(Object)}
   *   <li>{@link TenantProfileQueueConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    // Act and Assert
    assertEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration);
    int expectedHashCodeResult = tenantProfileQueueConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileQueueConfiguration.hashCode());
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
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

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(null);
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
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

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(NullNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(mock(JsonNode.class));
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(false);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Topic");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName(null);
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(3L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(3);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(1);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    SubmitStrategy submitStrategy = mock(SubmitStrategy.class);
    doNothing().when(submitStrategy).setBatchSize(anyInt());
    doNothing().when(submitStrategy).setType(Mockito.<SubmitStrategyType>any());
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    SubmitStrategy submitStrategy = mock(SubmitStrategy.class);
    doNothing().when(submitStrategy).setBatchSize(anyInt());
    doNothing().when(submitStrategy).setType(Mockito.<SubmitStrategyType>any());
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Name");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    SubmitStrategy submitStrategy = mock(SubmitStrategy.class);
    doNothing().when(submitStrategy).setBatchSize(anyInt());
    doNothing().when(submitStrategy).setType(Mockito.<SubmitStrategyType>any());
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic(null);

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration2.setName("Name");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(42);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, tenantProfileQueueConfiguration2);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, null);
  }

  /**
   * Method under test: {@link TenantProfileQueueConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tenantProfileQueueConfiguration, "Different type to TenantProfileQueueConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TenantProfileQueueConfiguration}
   *   <li>{@link TenantProfileQueueConfiguration#setAdditionalInfo(JsonNode)}
   *   <li>{@link TenantProfileQueueConfiguration#setConsumerPerPartition(boolean)}
   *   <li>{@link TenantProfileQueueConfiguration#setName(String)}
   *   <li>{@link TenantProfileQueueConfiguration#setPackProcessingTimeout(long)}
   *   <li>{@link TenantProfileQueueConfiguration#setPartitions(int)}
   *   <li>{@link TenantProfileQueueConfiguration#setPollInterval(int)}
   *   <li>
   * {@link TenantProfileQueueConfiguration#setProcessingStrategy(ProcessingStrategy)}
   *   <li>{@link TenantProfileQueueConfiguration#setSubmitStrategy(SubmitStrategy)}
   *   <li>{@link TenantProfileQueueConfiguration#setTopic(String)}
   *   <li>{@link TenantProfileQueueConfiguration#toString()}
   *   <li>{@link TenantProfileQueueConfiguration#getAdditionalInfo()}
   *   <li>{@link TenantProfileQueueConfiguration#getName()}
   *   <li>{@link TenantProfileQueueConfiguration#getPackProcessingTimeout()}
   *   <li>{@link TenantProfileQueueConfiguration#getPartitions()}
   *   <li>{@link TenantProfileQueueConfiguration#getPollInterval()}
   *   <li>{@link TenantProfileQueueConfiguration#getProcessingStrategy()}
   *   <li>{@link TenantProfileQueueConfiguration#getSubmitStrategy()}
   *   <li>{@link TenantProfileQueueConfiguration#getTopic()}
   *   <li>{@link TenantProfileQueueConfiguration#isConsumerPerPartition()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TenantProfileQueueConfiguration actualTenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    MissingNode additionalInfo = MissingNode.getInstance();
    actualTenantProfileQueueConfiguration.setAdditionalInfo(additionalInfo);
    actualTenantProfileQueueConfiguration.setConsumerPerPartition(true);
    actualTenantProfileQueueConfiguration.setName("Name");
    actualTenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    actualTenantProfileQueueConfiguration.setPartitions(1);
    actualTenantProfileQueueConfiguration.setPollInterval(42);
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    actualTenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);
    actualTenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    actualTenantProfileQueueConfiguration.setTopic("Topic");
    String actualToStringResult = actualTenantProfileQueueConfiguration.toString();
    JsonNode actualAdditionalInfo = actualTenantProfileQueueConfiguration.getAdditionalInfo();
    String actualName = actualTenantProfileQueueConfiguration.getName();
    long actualPackProcessingTimeout = actualTenantProfileQueueConfiguration.getPackProcessingTimeout();
    int actualPartitions = actualTenantProfileQueueConfiguration.getPartitions();
    int actualPollInterval = actualTenantProfileQueueConfiguration.getPollInterval();
    ProcessingStrategy actualProcessingStrategy = actualTenantProfileQueueConfiguration.getProcessingStrategy();
    SubmitStrategy actualSubmitStrategy = actualTenantProfileQueueConfiguration.getSubmitStrategy();
    String actualTopic = actualTenantProfileQueueConfiguration.getTopic();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(
        "TenantProfileQueueConfiguration(name=Name, topic=Topic, pollInterval=42, partitions=1, consumerPerPartition"
            + "=true, packProcessingTimeout=1, submitStrategy=SubmitStrategy(type=BURST, batchSize=3), processingStrategy"
            + "=ProcessingStrategy(type=SKIP_ALL_FAILURES, retries=1, failurePercentage=10.0, pauseBetweenRetries=1,"
            + " maxPauseBetweenRetries=1), additionalInfo=)",
        actualToStringResult);
    assertEquals("Topic", actualTopic);
    assertEquals(1, actualPartitions);
    assertEquals(1L, actualPackProcessingTimeout);
    assertEquals(42, actualPollInterval);
    assertTrue(actualTenantProfileQueueConfiguration.isConsumerPerPartition());
    assertSame(processingStrategy, actualProcessingStrategy);
    assertSame(submitStrategy, actualSubmitStrategy);
    assertSame(additionalInfo, actualAdditionalInfo);
  }
}
