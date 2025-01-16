package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.queue.SubmitStrategy;
import org.thingsboard.server.common.data.queue.SubmitStrategyType;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class QueueEntityDiffblueTest {
  /**
   * Test {@link QueueEntity#equals(Object)}, and {@link QueueEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueEntity#equals(Object)}
   *   <li>{@link QueueEntity#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = queueEntity.hashCode();
    assertEquals(expectedHashCodeResult, queueEntity2.hashCode());
  }

  /**
   * Test {@link QueueEntity#equals(Object)}, and {@link QueueEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueEntity#equals(Object)}
   *   <li>{@link QueueEntity#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(MissingNode.getInstance());
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    queueEntity.setAdditionalInfo(mock(JsonNode.class));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
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
    queueEntity.setProcessingStrategy(MissingNode.getInstance());
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
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
    queueEntity.setSubmitStrategy(MissingNode.getInstance());
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#equals(Object)}
   */
  @Test
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
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    QueueEntity actualQueueEntity = new QueueEntity();
    actualQueueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualQueueEntity.setConsumerPerPartition(true);
    actualQueueEntity.setName("Name");
    actualQueueEntity.setPackProcessingTimeout(1L);
    actualQueueEntity.setPartitions(1);
    actualQueueEntity.setPollInterval(42);
    actualQueueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.toString());
    assertEquals("Name", actualName);
    assertEquals("QueueEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, topic=Topic, pollInterval=42,"
        + " partitions=1, consumerPerPartition=true, packProcessingTimeout=1, submitStrategy={\"isPublic\":true},"
        + " processingStrategy={\"isPublic\":true}, additionalInfo={\"isPublic\":true})", actualToStringResult);
    assertEquals("Topic", actualTopic);
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
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#QueueEntity(Queue)}
   */
  @Test
  public void testNewQueueEntity_thenAdditionalInfoReturnNullNode() throws IOException {
    // Arrange and Act
    QueueEntity actualQueueEntity = new QueueEntity(
        new Queue(ModelConstants.SYSTEM_TENANT, new TenantProfileQueueConfiguration()));

    // Assert
    JsonNode additionalInfo = actualQueueEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualQueueEntity.getProcessingStrategy());
    assertSame(additionalInfo, actualQueueEntity.getSubmitStrategy());
  }

  /**
   * Test {@link QueueEntity#QueueEntity(Queue)}.
   * <ul>
   *   <li>When {@link Queue#Queue()} ProcessingStrategy is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#QueueEntity(Queue)}
   */
  @Test
  public void testNewQueueEntity_whenQueueProcessingStrategyIsNull() {
    // Arrange
    Queue queue = new Queue();
    queue.setId(null);
    queue.setSubmitStrategy(null);
    queue.setTenantId(ModelConstants.SYSTEM_TENANT);
    queue.setProcessingStrategy(null);

    // Act
    QueueEntity actualQueueEntity = new QueueEntity(queue);

    // Assert
    JsonNode processingStrategy = actualQueueEntity.getProcessingStrategy();
    assertTrue(processingStrategy instanceof NullNode);
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
   * <ul>
   *   <li>When {@link Queue#Queue()}.</li>
   *   <li>Then ProcessingStrategy return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#QueueEntity(Queue)}
   */
  @Test
  public void testNewQueueEntity_whenQueue_thenProcessingStrategyReturnNullNode() {
    // Arrange and Act
    QueueEntity actualQueueEntity = new QueueEntity(new Queue());

    // Assert
    JsonNode processingStrategy = actualQueueEntity.getProcessingStrategy();
    assertTrue(processingStrategy instanceof NullNode);
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
   * Test {@link QueueEntity#toData()}.
   * <ul>
   *   <li>Given {@link QueueEntity#QueueEntity()}.</li>
   *   <li>Then return AdditionalInfo toPrettyString is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#toData()}
   */
  @Test
  public void testToData_givenQueueEntity_thenReturnAdditionalInfoToPrettyStringIsNull() {
    // Arrange, Act and Assert
    JsonNode additionalInfo = (new QueueEntity()).toData().getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("null", additionalInfo.toPrettyString());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link QueueEntity#toData()}.
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#toData()}
   */
  @Test
  public void testToData_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
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
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Name", actualToDataResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("Topic", actualToDataResult.getTopic());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(1, actualToDataResult.getPartitions());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(1L, actualToDataResult.getPackProcessingTimeout());
    assertEquals(42, actualToDataResult.getPollInterval());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    QueueId id = actualToDataResult.getId();
    assertTrue(id.isNullUid());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertTrue(actualToDataResult.isConsumerPerPartition());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(uuidId, id.getId());
    assertSame(uuidId, tenantId.getId());
  }

  /**
   * Test {@link QueueEntity#toData()}.
   * <ul>
   *   <li>Then return AdditionalInfo is
   * {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#toData()}
   */
  @Test
  public void testToData_thenReturnAdditionalInfoIsArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    QueueEntity queueEntity = new QueueEntity();
    ArrayNode additionalInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    queueEntity.setAdditionalInfo(additionalInfo);

    // Act and Assert
    assertSame(additionalInfo, queueEntity.toData().getAdditionalInfo());
  }

  /**
   * Test {@link QueueEntity#toData()}.
   * <ul>
   *   <li>Then return AdditionalInfo toPrettyString is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#toData()}
   */
  @Test
  public void testToData_thenReturnAdditionalInfoToPrettyStringIsNull() {
    // Arrange, Act and Assert
    JsonNode additionalInfo = (new QueueEntity(new Queue())).toData().getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("null", additionalInfo.toPrettyString());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link QueueEntity#toData()}.
   * <ul>
   *   <li>Then return SubmitStrategy is {@link SubmitStrategy} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueEntity#toData()}
   */
  @Test
  public void testToData_thenReturnSubmitStrategyIsSubmitStrategy() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    Queue queue = new Queue();
    queue.setSubmitStrategy(submitStrategy);

    // Act
    Queue actualToDataResult = (new QueueEntity(queue)).toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals(submitStrategy, actualToDataResult.getSubmitStrategy());
  }
}
