package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
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
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(queueEntity, queueEntity2);
    int expectedHashCodeResult = queueEntity.hashCode();
    assertEquals(expectedHashCodeResult, queueEntity2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(null);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(false);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(3L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Topic");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName(null);
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(3L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(3);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(1);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(DoubleNode.valueOf(10.0d));
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(null);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(DoubleNode.valueOf(10.0d));
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(null);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(null);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Name");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic(null);
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueEntity queueEntity2 = new QueueEntity();
    queueEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setConsumerPerPartition(true);
    queueEntity2.setCreatedTime(1L);
    queueEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setName("Name");
    queueEntity2.setPackProcessingTimeout(1L);
    queueEntity2.setPartitions(1);
    queueEntity2.setPollInterval(42);
    queueEntity2.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity2.setTopic("Topic");
    queueEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueueEntity.equals(Object)", "int QueueEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
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
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Name", actualName);
    assertEquals(
        "QueueEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, name=Name, topic=Topic, pollInterval=42,"
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
    assertSame(tenantId, actualTenantId);
    assertSame(submitStrategy, actualAdditionalInfo);
    assertSame(submitStrategy, actualProcessingStrategy);
    assertSame(submitStrategy, actualSubmitStrategy);
  }

  /**
   * Test {@link QueueEntity#QueueEntity(Queue)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#QueueEntity(Queue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueueEntity.<init>(Queue)"})
  public void testNewQueueEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(3L);
    processingStrategy.setPauseBetweenRetries(3L);
    processingStrategy.setRetries(3);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration queueConfiguration = new TenantProfileQueueConfiguration();
    queueConfiguration.setAdditionalInfo(null);
    queueConfiguration.setConsumerPerPartition(true);
    queueConfiguration.setName("Name");
    queueConfiguration.setPackProcessingTimeout(3L);
    queueConfiguration.setPartitions(3);
    queueConfiguration.setPollInterval(42);
    queueConfiguration.setProcessingStrategy(processingStrategy);
    queueConfiguration.setSubmitStrategy(submitStrategy);
    queueConfiguration.setTopic("Topic");

    // Act
    QueueEntity actualQueueEntity =
        new QueueEntity(new Queue(ModelConstants.SYSTEM_TENANT, queueConfiguration));

    // Assert
    assertTrue(actualQueueEntity.getAdditionalInfo() instanceof NullNode);
    assertEquals("Name", actualQueueEntity.getName());
    assertEquals("Topic", actualQueueEntity.getTopic());
    assertEquals(3, actualQueueEntity.getPartitions());
    assertEquals(3L, actualQueueEntity.getPackProcessingTimeout());
    assertEquals(42, actualQueueEntity.getPollInterval());
    assertTrue(actualQueueEntity.isConsumerPerPartition());
  }

  /**
   * Test {@link QueueEntity#QueueEntity(Queue)}.
   *
   * <ul>
   *   <li>Then ProcessingStrategy return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#QueueEntity(Queue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueueEntity.<init>(Queue)"})
  public void testNewQueueEntity_thenProcessingStrategyReturnObjectNode() {
    // Arrange
    Queue queue = new Queue(null);
    queue.setTenantId(null);

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
   *   <li>Then ProcessingStrategy traverse return {@link TreeTraversingParser}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#QueueEntity(Queue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueueEntity.<init>(Queue)"})
  public void testNewQueueEntity_thenProcessingStrategyTraverseReturnTreeTraversingParser() {
    // Arrange and Act
    QueueEntity actualQueueEntity = new QueueEntity(new Queue());

    // Assert
    JsonNode processingStrategy = actualQueueEntity.getProcessingStrategy();
    assertTrue(processingStrategy instanceof NullNode);
    assertTrue(processingStrategy.traverse() instanceof TreeTraversingParser);
    assertEquals("null", processingStrategy.toPrettyString());
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
   * Test {@link QueueEntity#QueueEntity(Queue)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#QueueEntity(Queue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueueEntity.<init>(Queue)"})
  public void testNewQueueEntity_thenReturnIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Queue queue = new Queue(new QueueId(id));
    queue.setTenantId(null);
    queue.setSubmitStrategy(null);
    queue.setProcessingStrategy(processingStrategy);

    // Act
    QueueEntity actualQueueEntity = new QueueEntity(queue);

    // Assert
    UUID id2 = actualQueueEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
    assertSame(id, actualQueueEntity.getUuid());
  }

  /**
   * Test {@link QueueEntity#QueueEntity(Queue)}.
   *
   * <ul>
   *   <li>Then return TenantId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#QueueEntity(Queue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueueEntity.<init>(Queue)"})
  public void testNewQueueEntity_thenReturnTenantIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Queue queue = new Queue(null);
    queue.setTenantId(ModelConstants.SYSTEM_TENANT);
    queue.setSubmitStrategy(null);
    queue.setProcessingStrategy(null);

    // Act
    QueueEntity actualQueueEntity = new QueueEntity(queue);

    // Assert
    JsonNode processingStrategy = actualQueueEntity.getProcessingStrategy();
    assertTrue(processingStrategy instanceof NullNode);
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualQueueEntity.getTenantId().toString());
    assertEquals("null", processingStrategy.toPrettyString());
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
   * Test {@link QueueEntity#QueueEntity(Queue)}.
   *
   * <ul>
   *   <li>Then SubmitStrategy return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#QueueEntity(Queue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueueEntity.<init>(Queue)"})
  public void testNewQueueEntity_thenSubmitStrategyReturnNullNode() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    Queue queue = new Queue(null);
    queue.setTenantId(null);
    queue.setSubmitStrategy(null);
    queue.setProcessingStrategy(processingStrategy);

    // Act and Assert
    JsonNode submitStrategy = new QueueEntity(queue).getSubmitStrategy();
    assertTrue(submitStrategy instanceof NullNode);
    assertEquals("null", submitStrategy.toPrettyString());
    assertEquals(0, submitStrategy.size());
    assertEquals(JsonNodeType.NULL, submitStrategy.getNodeType());
    assertFalse(submitStrategy.isContainerNode());
    assertFalse(submitStrategy.isObject());
    assertFalse(submitStrategy.iterator().hasNext());
    assertTrue(submitStrategy.isEmpty());
    assertTrue(submitStrategy.isNull());
    assertTrue(submitStrategy.isValueNode());
  }

  /**
   * Test {@link QueueEntity#toData()}.
   *
   * <p>Method under test: {@link QueueEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Queue QueueEntity.toData()"})
  public void testToData() {
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
    queueConfiguration.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueConfiguration.setConsumerPerPartition(true);
    queueConfiguration.setName("Name");
    queueConfiguration.setPackProcessingTimeout(1L);
    queueConfiguration.setPartitions(1);
    queueConfiguration.setPollInterval(42);
    queueConfiguration.setProcessingStrategy(processingStrategy);
    queueConfiguration.setSubmitStrategy(submitStrategy);
    queueConfiguration.setTopic("Topic");
    Queue queue = new Queue(ModelConstants.SYSTEM_TENANT, queueConfiguration);

    // Act and Assert
    assertEquals(queue, new QueueEntity(queue).toData());
  }

  /**
   * Test {@link QueueEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link QueueEntity#QueueEntity(Queue)} with queue is {@link Queue#Queue()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Queue QueueEntity.toData()"})
  public void testToData_givenQueueEntityWithQueueIsQueue_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Queue actualToDataResult = new QueueEntity(new Queue()).toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTopic());
    assertEquals(0, actualToDataResult.getPartitions());
    assertEquals(0, actualToDataResult.getPollInterval());
    assertEquals(0L, actualToDataResult.getPackProcessingTimeout());
    assertFalse(actualToDataResult.isConsumerPerPartition());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Queue QueueEntity.toData()"})
  public void testToData_givenQueueEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Queue actualToDataResult = new QueueEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTopic());
    assertEquals(0, actualToDataResult.getPartitions());
    assertEquals(0, actualToDataResult.getPollInterval());
    assertEquals(0L, actualToDataResult.getPackProcessingTimeout());
    assertFalse(actualToDataResult.isConsumerPerPartition());
  }

  /**
   * Test {@link QueueEntity#toData()}.
   *
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.
   * </ul>
   *
   * <p>Method under test: {@link QueueEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Queue QueueEntity.toData()"})
  public void testToData_thenAdditionalInfoIteratorNextReturnBooleanNode() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    queueEntity.setTenantId(tenantId);
    queueEntity.setTopic("Topic");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    queueEntity.setUuid(id);
    queueEntity.setSubmitStrategy(null);
    queueEntity.setProcessingStrategy(null);

    // Act
    Queue actualToDataResult = queueEntity.toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    UUID id2 = actualToDataResult.getTenantId().getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
    assertSame(tenantId, id2);
  }
}
