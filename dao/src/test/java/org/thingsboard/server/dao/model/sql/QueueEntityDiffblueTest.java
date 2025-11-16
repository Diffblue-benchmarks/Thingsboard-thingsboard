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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.queue.ProcessingStrategy;
import org.thingsboard.server.common.data.queue.ProcessingStrategyType;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.queue.SubmitStrategy;
import org.thingsboard.server.common.data.queue.SubmitStrategyType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class QueueEntityDiffblueTest {
  /**
   * Test {@link QueueEntity#equals(Object)}, and {@link QueueEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueEntity#equals(Object)}
   *   <li>{@link QueueEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(queueEntity, queueEntity2);
    assertEquals(queueEntity.hashCode(), queueEntity2.hashCode());
  }

  /**
   * Test {@link QueueEntity#equals(Object)}, and {@link QueueEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueEntity#equals(Object)}
   *   <li>{@link QueueEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(null);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(null);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(queueEntity, queueEntity2);
    assertEquals(queueEntity.hashCode(), queueEntity2.hashCode());
  }

  /**
   * Test {@link QueueEntity#equals(Object)}, and {@link QueueEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueEntity#equals(Object)}
   *   <li>{@link QueueEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName(null);
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName(null);
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(queueEntity, queueEntity2);
    assertEquals(queueEntity.hashCode(), queueEntity2.hashCode());
  }

  /**
   * Test {@link QueueEntity#equals(Object)}, and {@link QueueEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueEntity#equals(Object)}
   *   <li>{@link QueueEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(queueEntity, queueEntity);
    int expectedHashCodeResult = queueEntity.hashCode();
    assertEquals(expectedHashCodeResult, queueEntity.hashCode());
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(null);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(false);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(3L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Topic");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName(null);
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(3L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(3);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(1);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(DoubleNode.valueOf(10.0d));
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(null);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(DoubleNode.valueOf(10.0d));
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(null);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.randomUUID());
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(null);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Name");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic(null);
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(ModelConstants.NULL_UUID);
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, queueEntity2);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, null);
  }

  /**
   * Test {@link QueueEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueEntity, "Different type to QueueEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueEntity#QueueEntity()}
   *   <li>{@link QueueEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link QueueEntity#setConsumerPerPartition(boolean)}
   *   <li>{@link QueueEntity#setName(String)}
   *   <li>{@link QueueEntity#setPackProcessingTimeout(long)}
   *   <li>{@link QueueEntity#setPartitions(int)}
   *   <li>{@link QueueEntity#setPollInterval(int)}
   *   <li>{@link QueueEntity#setProcessingStrategy(JsonNode)}
   *   <li>{@link QueueEntity#setSubmitStrategy(JsonNode)}
   *   <li>{@link QueueEntity#setTenantId(UUID)}
   *   <li>{@link QueueEntity#setTopic(String)}
   *   <li>{@link QueueEntity#toString()}
   *   <li>{@link QueueEntity#getAdditionalInfo()}
   *   <li>{@link QueueEntity#getName()}
   *   <li>{@link QueueEntity#getPackProcessingTimeout()}
   *   <li>{@link QueueEntity#getPartitions()}
   *   <li>{@link QueueEntity#getPollInterval()}
   *   <li>{@link QueueEntity#getProcessingStrategy()}
   *   <li>{@link QueueEntity#getSubmitStrategy()}
   *   <li>{@link QueueEntity#getTenantId()}
   *   <li>{@link QueueEntity#getTopic()}
   *   <li>{@link QueueEntity#isConsumerPerPartition()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QueueEntity.<init>()",
    "JsonNode QueueEntity.getAdditionalInfo()",
    "String QueueEntity.getName()",
    "long QueueEntity.getPackProcessingTimeout()",
    "int QueueEntity.getPartitions()",
    "int QueueEntity.getPollInterval()",
    "JsonNode QueueEntity.getProcessingStrategy()",
    "JsonNode QueueEntity.getSubmitStrategy()",
    "UUID QueueEntity.getTenantId()",
    "String QueueEntity.getTopic()",
    "boolean QueueEntity.isConsumerPerPartition()",
    "void QueueEntity.setAdditionalInfo(JsonNode)",
    "void QueueEntity.setConsumerPerPartition(boolean)",
    "void QueueEntity.setName(String)",
    "void QueueEntity.setPackProcessingTimeout(long)",
    "void QueueEntity.setPartitions(int)",
    "void QueueEntity.setPollInterval(int)",
    "void QueueEntity.setProcessingStrategy(JsonNode)",
    "void QueueEntity.setSubmitStrategy(JsonNode)",
    "void QueueEntity.setTenantId(UUID)",
    "void QueueEntity.setTopic(String)",
    "String QueueEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    QueueEntity actualQueueEntity = new QueueEntity();
    actualQueueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualQueueEntity.setConsumerPerPartition(true);
    actualQueueEntity.setName("Name");
    actualQueueEntity.setPackProcessingTimeout(1L);
    actualQueueEntity.setPartitions(1);
    actualQueueEntity.setPollInterval(42);
    actualQueueEntity.setProcessingStrategy(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNode submitStrategy = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualQueueEntity.setSubmitStrategy(submitStrategy);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualQueueEntity.setTenantId(tenantId);
    actualQueueEntity.setTopic("Topic");
    String actualToStringResult = actualQueueEntity.toString();
    JsonNode actualAdditionalInfo = actualQueueEntity.getAdditionalInfo();
    String actualName = actualQueueEntity.getName();
    long actualPackProcessingTimeout = actualQueueEntity.getPackProcessingTimeout();
    int actualPartitions = actualQueueEntity.getPartitions();
    int actualPollInterval = actualQueueEntity.getPollInterval();
    JsonNode actualProcessingStrategy = actualQueueEntity.getProcessingStrategy();
    JsonNode actualSubmitStrategy = actualQueueEntity.getSubmitStrategy();
    UUID actualTenantId = actualQueueEntity.getTenantId();
    String actualTopic = actualQueueEntity.getTopic();
    boolean actualIsConsumerPerPartitionResult = actualQueueEntity.isConsumerPerPartition();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.toString());
    assertEquals("Name", actualName);
    assertEquals(
        "QueueEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, topic=Topic, pollInterval=42,"
            + " partitions=1, consumerPerPartition=true, packProcessingTimeout=1, submitStrategy={\"isPublic\":true},"
            + " processingStrategy={\"isPublic\":true}, additionalInfo={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("Topic", actualTopic);
    assertNull(actualQueueEntity.getId());
    assertNull(actualQueueEntity.getUuid());
    assertEquals(0L, actualQueueEntity.getCreatedTime());
    assertEquals(1, actualPartitions);
    assertEquals(1L, actualPackProcessingTimeout);
    assertEquals(42, actualPollInterval);
    assertTrue(actualIsConsumerPerPartitionResult);
    assertSame(submitStrategy, actualAdditionalInfo);
    assertSame(submitStrategy, actualProcessingStrategy);
    assertSame(submitStrategy, actualSubmitStrategy);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link QueueEntity#QueueEntity(Queue)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Queue#Queue(QueueId)} with id is {@code null} ProcessingStrategy is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#QueueEntity(Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueEntity.<init>(Queue)"})
  public void testNewQueueEntity_givenNull_whenQueueWithIdIsNullProcessingStrategyIsNull() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    Queue queue = new Queue(null);
    queue.setTenantId(ModelConstants.SYSTEM_TENANT);
    queue.setSubmitStrategy(submitStrategy);
    queue.setProcessingStrategy(null);

    // Act
    QueueEntity actualQueueEntity = new QueueEntity(queue);

    // Assert
    JsonNode processingStrategy = actualQueueEntity.getProcessingStrategy();
    assertTrue(processingStrategy instanceof NullNode);
    JsonNode submitStrategy2 = actualQueueEntity.getSubmitStrategy();
    assertTrue(submitStrategy2 instanceof ObjectNode);
    assertTrue(submitStrategy2.traverse() instanceof TreeTraversingParser);
    assertEquals(0, processingStrategy.size());
    assertEquals(JsonNodeType.NULL, processingStrategy.getNodeType());
    assertFalse(processingStrategy.isContainerNode());
    assertFalse(processingStrategy.isObject());
    assertFalse(processingStrategy.iterator().hasNext());
    assertTrue(processingStrategy.isEmpty());
    assertTrue(processingStrategy.isNull());
    assertTrue(processingStrategy.isValueNode());
  }

  /**
   * Test {@link QueueEntity#QueueEntity(Queue)}.
   *
   * <ul>
   *   <li>Then ProcessingStrategy iterator next return {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#QueueEntity(Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueEntity.<init>(Queue)"})
  public void testNewQueueEntity_thenProcessingStrategyIteratorNextReturnTextNode() {
    // Arrange
    Queue queue = new Queue(null);
    queue.setTenantId(ModelConstants.SYSTEM_TENANT);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);
    queue.setSubmitStrategy(submitStrategy);

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    queue.setProcessingStrategy(processingStrategy);

    // Act
    QueueEntity actualQueueEntity = new QueueEntity(queue);

    // Assert
    JsonNode processingStrategy2 = actualQueueEntity.getProcessingStrategy();
    assertTrue(processingStrategy2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = processingStrategy2.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    JsonNode nextResult3 = iteratorResult.next();
    assertTrue(iteratorResult.hasNext());
    assertTrue(nextResult instanceof TextNode);
    assertTrue(nextResult2 instanceof IntNode);
    assertTrue(nextResult3 instanceof DoubleNode);
    JsonNode submitStrategy2 = actualQueueEntity.getSubmitStrategy();
    assertTrue(submitStrategy2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = submitStrategy2.iterator();
    JsonNode nextResult4 = iteratorResult2.next();
    JsonNode nextResult5 = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertTrue(nextResult4 instanceof TextNode);
    assertTrue(nextResult5 instanceof IntNode);
  }

  /**
   * Test {@link QueueEntity#QueueEntity(Queue)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#QueueEntity(Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueEntity.<init>(Queue)"})
  public void testNewQueueEntity_thenReturnIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    Queue queue = new Queue(new QueueId(ModelConstants.NULL_UUID));
    queue.setTenantId(ModelConstants.SYSTEM_TENANT);
    queue.setSubmitStrategy(submitStrategy);
    queue.setProcessingStrategy(processingStrategy);

    // Act
    QueueEntity actualQueueEntity = new QueueEntity(queue);

    // Assert
    JsonNode processingStrategy2 = actualQueueEntity.getProcessingStrategy();
    assertTrue(processingStrategy2 instanceof ObjectNode);
    JsonNode submitStrategy2 = actualQueueEntity.getSubmitStrategy();
    assertTrue(submitStrategy2 instanceof ObjectNode);
    assertTrue(submitStrategy2.traverse() instanceof TreeTraversingParser);
    UUID id = actualQueueEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertTrue(processingStrategy2.iterator().hasNext());
    assertSame(id, actualQueueEntity.getUuid());
  }

  /**
   * Test {@link QueueEntity#QueueEntity(Queue)}.
   *
   * <ul>
   *   <li>When {@link Queue#Queue()}.
   *   <li>Then return TenantId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#QueueEntity(Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueEntity.<init>(Queue)"})
  public void testNewQueueEntity_whenQueue_thenReturnTenantIdIsNull() {
    // Arrange and Act
    QueueEntity actualQueueEntity = new QueueEntity(new Queue());

    // Assert
    JsonNode processingStrategy = actualQueueEntity.getProcessingStrategy();
    assertTrue(processingStrategy instanceof NullNode);
    assertNull(actualQueueEntity.getTenantId());
    assertEquals(0, processingStrategy.size());
    assertEquals(JsonNodeType.NULL, processingStrategy.getNodeType());
    assertFalse(processingStrategy.isContainerNode());
    assertFalse(processingStrategy.isObject());
    assertFalse(processingStrategy.iterator().hasNext());
    assertTrue(processingStrategy.isEmpty());
    assertTrue(processingStrategy.isNull());
    assertTrue(processingStrategy.isValueNode());
    assertSame(processingStrategy, actualQueueEntity.getSubmitStrategy());
  }

  /**
   * Test {@link QueueEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link QueueEntity#QueueEntity()} ProcessingStrategy is Instance.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueEntity.toData()"})
  public void testToData_givenQueueEntityProcessingStrategyIsInstance() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);
    queueEntity.setSubmitStrategy(MissingNode.getInstance());
    queueEntity.setProcessingStrategy(MissingNode.getInstance());

    // Act
    Queue actualToDataResult = queueEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("Topic", actualToDataResult.getTopic());
    assertEquals(1, actualToDataResult.getPartitions());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(1L, actualToDataResult.getPackProcessingTimeout());
    assertEquals(42, actualToDataResult.getPollInterval());
    assertTrue(actualToDataResult.isConsumerPerPartition());
  }

  /**
   * Test {@link QueueEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link QueueEntity#QueueEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueEntity.toData()"})
  public void testToData_givenQueueEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange, Act and Assert
    JsonNode additionalInfo = new QueueEntity().toData().getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link QueueEntity#toData()}.
   *
   * <ul>
   *   <li>Then AdditionalInfo elements next return {@link ArrayNode}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueEntity.toData()"})
  public void testToData_thenAdditionalInfoElementsNextReturnArrayNode() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode additionalInfo = new ArrayNode(nf);
    additionalInfo.addArray();
    additionalInfo.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(additionalInfo);

    // Act and Assert
    JsonNode additionalInfo2 = queueEntity.toData().getAdditionalInfo();
    Iterator<JsonNode> elementsResult = additionalInfo2.elements();
    JsonNode nextResult = elementsResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    assertTrue(additionalInfo2 instanceof ArrayNode);
    JsonNode nextResult2 = elementsResult.next();
    Iterator<JsonNode> iteratorResult = nextResult2.iterator();
    JsonNode nextResult3 = iteratorResult.next();
    assertTrue(nextResult3 instanceof BooleanNode);
    assertTrue(nextResult2 instanceof ObjectNode);
    assertEquals(0, nextResult.size());
    assertEquals(JsonNodeType.ARRAY, nextResult.getNodeType());
    assertFalse(nextResult.elements().hasNext());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult3.iterator().hasNext());
    assertTrue(nextResult.isArray());
    assertTrue(nextResult.isEmpty());
  }

  /**
   * Test {@link QueueEntity#toData()}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueEntity.toData()"})
  public void testToData_thenAdditionalInfoReturnObjectNode() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);
    queueEntity.setSubmitStrategy(null);
    queueEntity.setProcessingStrategy(null);

    // Act
    Queue actualToDataResult = queueEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("Topic", actualToDataResult.getTopic());
    assertEquals(1, actualToDataResult.getPartitions());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(1L, actualToDataResult.getPackProcessingTimeout());
    assertEquals(42, actualToDataResult.getPollInterval());
    assertTrue(actualToDataResult.isConsumerPerPartition());
  }

  /**
   * Test {@link QueueEntity#toData()}.
   *
   * <ul>
   *   <li>Then return AdditionalInfo elements next size is one.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueEntity.toData()"})
  public void testToData_thenReturnAdditionalInfoElementsNextSizeIsOne() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode additionalInfo = new ArrayNode(nf);
    additionalInfo.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(additionalInfo);

    // Act and Assert
    JsonNode additionalInfo2 = queueEntity.toData().getAdditionalInfo();
    assertTrue(additionalInfo2 instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = additionalInfo2.elements();
    JsonNode nextResult = elementsResult.next();
    Iterator<JsonNode> iteratorResult = nextResult.iterator();
    assertTrue(iteratorResult.next() instanceof BooleanNode);
    assertTrue(nextResult instanceof ObjectNode);
    assertEquals(1, nextResult.size());
    assertEquals(1, additionalInfo2.size());
    assertEquals(JsonNodeType.OBJECT, nextResult.getNodeType());
    assertFalse(nextResult.isEmpty());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isObject());
  }

  /**
   * Test {@link QueueEntity#toData()}.
   *
   * <ul>
   *   <li>Then return not AdditionalInfo iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueEntity.toData()"})
  public void testToData_thenReturnNotAdditionalInfoIteratorHasNext() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    queueEntity.setAdditionalInfo(new ArrayNode(nf));

    // Act and Assert
    JsonNode additionalInfo = queueEntity.toData().getAdditionalInfo();
    assertTrue(additionalInfo instanceof ArrayNode);
    assertEquals(0, additionalInfo.size());
    assertFalse(additionalInfo.elements().hasNext());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
  }
}
