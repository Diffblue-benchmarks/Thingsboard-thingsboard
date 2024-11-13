package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertArrayEquals;
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
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class RuleNodeEntityDiffblueTest {
  /**
   * Test {@link RuleNodeEntity#equals(Object)}, and
   * {@link RuleNodeEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeEntity#equals(Object)}
   *   <li>{@link RuleNodeEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeEntity, ruleNodeEntity2);
    int expectedHashCodeResult = ruleNodeEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}, and
   * {@link RuleNodeEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeEntity#equals(Object)}
   *   <li>{@link RuleNodeEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeEntity, ruleNodeEntity);
    int expectedHashCodeResult = ruleNodeEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeEntity.hashCode());
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(MissingNode.getInstance());
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(null);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(mock(JsonNode.class));
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(MissingNode.getInstance());
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(null);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(3);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(3L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(false);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.randomUUID());
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(null);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Type");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName(null);
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Type");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName(null);
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.randomUUID());
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(null);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(false);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Name");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType(null);
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, null);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, "Different type to RuleNodeEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeEntity#RuleNodeEntity()}
   *   <li>{@link RuleNodeEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link RuleNodeEntity#setConfiguration(JsonNode)}
   *   <li>{@link RuleNodeEntity#setConfigurationVersion(int)}
   *   <li>{@link RuleNodeEntity#setDebugMode(boolean)}
   *   <li>{@link RuleNodeEntity#setExternalId(UUID)}
   *   <li>{@link RuleNodeEntity#setName(String)}
   *   <li>{@link RuleNodeEntity#setQueueName(String)}
   *   <li>{@link RuleNodeEntity#setRuleChainId(UUID)}
   *   <li>{@link RuleNodeEntity#setSingletonMode(boolean)}
   *   <li>{@link RuleNodeEntity#setType(String)}
   *   <li>{@link RuleNodeEntity#toString()}
   *   <li>{@link RuleNodeEntity#getAdditionalInfo()}
   *   <li>{@link RuleNodeEntity#getConfiguration()}
   *   <li>{@link RuleNodeEntity#getConfigurationVersion()}
   *   <li>{@link RuleNodeEntity#getExternalId()}
   *   <li>{@link RuleNodeEntity#getName()}
   *   <li>{@link RuleNodeEntity#getQueueName()}
   *   <li>{@link RuleNodeEntity#getRuleChainId()}
   *   <li>{@link RuleNodeEntity#getType()}
   *   <li>{@link RuleNodeEntity#isDebugMode()}
   *   <li>{@link RuleNodeEntity#isSingletonMode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity();
    actualRuleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualRuleNodeEntity.setConfiguration(configuration);
    actualRuleNodeEntity.setConfigurationVersion(1);
    actualRuleNodeEntity.setDebugMode(true);
    actualRuleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    actualRuleNodeEntity.setName("Name");
    actualRuleNodeEntity.setQueueName("Queue Name");
    UUID ruleChainId = ModelConstants.NULL_UUID;
    actualRuleNodeEntity.setRuleChainId(ruleChainId);
    actualRuleNodeEntity.setSingletonMode(true);
    actualRuleNodeEntity.setType("Type");
    String actualToStringResult = actualRuleNodeEntity.toString();
    JsonNode actualAdditionalInfo = actualRuleNodeEntity.getAdditionalInfo();
    JsonNode actualConfiguration = actualRuleNodeEntity.getConfiguration();
    int actualConfigurationVersion = actualRuleNodeEntity.getConfigurationVersion();
    UUID actualExternalId = actualRuleNodeEntity.getExternalId();
    String actualName = actualRuleNodeEntity.getName();
    String actualQueueName = actualRuleNodeEntity.getQueueName();
    UUID actualRuleChainId = actualRuleNodeEntity.getRuleChainId();
    String actualType = actualRuleNodeEntity.getType();
    boolean actualIsDebugModeResult = actualRuleNodeEntity.isDebugMode();
    boolean actualIsSingletonModeResult = actualRuleNodeEntity.isSingletonMode();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Name", actualName);
    assertEquals("Queue Name", actualQueueName);
    assertEquals(
        "RuleNodeEntity(ruleChainId=13814000-1dd2-11b2-8080-808080808080, type=Type, name=Name, configurationVersion"
            + "=1, configuration={\"isPublic\":true}, additionalInfo={\"isPublic\":true}, debugMode=true, singletonMode=true,"
            + " queueName=Queue Name, externalId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertEquals(1, actualConfigurationVersion);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsSingletonModeResult);
    assertSame(configuration, actualAdditionalInfo);
    assertSame(configuration, actualConfiguration);
    assertSame(ruleChainId, actualExternalId);
    assertSame(ruleChainId, actualRuleChainId);
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   * <p>
   * Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  public void testNewRuleNodeEntity() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setRuleChainId(null);
    ruleNode.setExternalId(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRuleNodeEntity.getExternalId().toString());
    assertNull(actualRuleNodeEntity.getAdditionalInfo());
    assertNull(actualRuleNodeEntity.getConfiguration());
    assertNull(actualRuleNodeEntity.getId());
    assertNull(actualRuleNodeEntity.getUuid());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertFalse(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   * <p>
   * Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  public void testNewRuleNodeEntity2() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));
    ruleNode.setExternalId(null);

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRuleNodeEntity.getRuleChainId().toString());
    assertNull(actualRuleNodeEntity.getAdditionalInfo());
    assertNull(actualRuleNodeEntity.getConfiguration());
    assertNull(actualRuleNodeEntity.getId());
    assertNull(actualRuleNodeEntity.getUuid());
    assertNull(actualRuleNodeEntity.getExternalId());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertFalse(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  public void testNewRuleNodeEntity_givenA() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    assertNull(actualRuleNodeEntity.getAdditionalInfo());
    assertNull(actualRuleNodeEntity.getConfiguration());
    assertNull(actualRuleNodeEntity.getId());
    assertNull(actualRuleNodeEntity.getUuid());
    assertNull(actualRuleNodeEntity.getExternalId());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertFalse(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then return CreatedTime is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  public void testNewRuleNodeEntity_givenThree_thenReturnCreatedTimeIsThree() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setCreatedTime(3L);

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    assertNull(actualRuleNodeEntity.getAdditionalInfo());
    assertNull(actualRuleNodeEntity.getConfiguration());
    assertNull(actualRuleNodeEntity.getId());
    assertNull(actualRuleNodeEntity.getUuid());
    assertNull(actualRuleNodeEntity.getExternalId());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(3L, actualRuleNodeEntity.getCreatedTime());
    assertFalse(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link RuleNode#RuleNode()} DebugMode is {@code true}.</li>
   *   <li>Then return DebugMode.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  public void testNewRuleNodeEntity_givenTrue_whenRuleNodeDebugModeIsTrue_thenReturnDebugMode() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    assertNull(actualRuleNodeEntity.getAdditionalInfo());
    assertNull(actualRuleNodeEntity.getConfiguration());
    assertNull(actualRuleNodeEntity.getId());
    assertNull(actualRuleNodeEntity.getUuid());
    assertNull(actualRuleNodeEntity.getExternalId());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertTrue(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  public void testNewRuleNodeEntity_thenAdditionalInfoReturnNullNode() throws IOException {
    // Arrange and Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(new RuleNode(new RuleNode()));

    // Assert
    JsonNode additionalInfo = actualRuleNodeEntity.getAdditionalInfo();
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
    assertSame(additionalInfo, actualRuleNodeEntity.getConfiguration());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   * <ul>
   *   <li>Then return Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  public void testNewRuleNodeEntity_thenReturnIdToStringIs138140001dd211b28080808080808080() {
    // Arrange and Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(new RuleNode(new RuleNodeId(ModelConstants.NULL_UUID)));

    // Assert
    UUID id = actualRuleNodeEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertNull(actualRuleNodeEntity.getAdditionalInfo());
    assertNull(actualRuleNodeEntity.getConfiguration());
    assertSame(id, actualRuleNodeEntity.getUuid());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   * <ul>
   *   <li>When {@link RuleNode#RuleNode(RuleNode)} with ruleNode is
   * {@link RuleNode#RuleNode(RuleNode)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  public void testNewRuleNodeEntity_whenRuleNodeWithRuleNodeIsRuleNode() throws IOException {
    // Arrange and Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(new RuleNode(new RuleNode(new RuleNode())));

    // Assert
    JsonNode additionalInfo = actualRuleNodeEntity.getAdditionalInfo();
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
    assertSame(additionalInfo, actualRuleNodeEntity.getConfiguration());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   * <ul>
   *   <li>When {@link RuleNode#RuleNode()}.</li>
   *   <li>Then return ExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  public void testNewRuleNodeEntity_whenRuleNode_thenReturnExternalIdIsNull() {
    // Arrange and Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(new RuleNode());

    // Assert
    assertNull(actualRuleNodeEntity.getAdditionalInfo());
    assertNull(actualRuleNodeEntity.getConfiguration());
    assertNull(actualRuleNodeEntity.getId());
    assertNull(actualRuleNodeEntity.getUuid());
    assertNull(actualRuleNodeEntity.getExternalId());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertFalse(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#toData()}.
   * <ul>
   *   <li>Given {@link RuleNodeEntity#RuleNodeEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#toData()}
   */
  @Test
  public void testToData_givenRuleNodeEntity_thenAdditionalInfoReturnNullNode() throws UnsupportedEncodingException {
    // Arrange and Act
    RuleNode actualToDataResult = (new RuleNodeEntity()).toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getQueueName());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUuidId());
    RuleNodeId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertEquals(0, additionalInfo.size());
    assertEquals(0, actualToDataResult.getConfigurationVersion());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(id.isNullUid());
    assertFalse(actualToDataResult.isDebugMode());
    assertFalse(actualToDataResult.isSingletonMode());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualToDataResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNodeEntity#toData()}.
   * <ul>
   *   <li>Then return ExternalId EntityType is {@code RULE_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#toData()}
   */
  @Test
  public void testToData_thenReturnExternalIdEntityTypeIsRuleNode() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);
    ruleNodeEntity.setRuleChainId(null);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    RuleNode actualToDataResult = ruleNodeEntity.toData();

    // Assert
    RuleNodeId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.RULE_NODE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
  }

  /**
   * Test {@link RuleNodeEntity#toData()}.
   * <ul>
   *   <li>Then return RuleChainId EntityType is {@code RULE_CHAIN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeEntity#toData()}
   */
  @Test
  public void testToData_thenReturnRuleChainIdEntityTypeIsRuleChain() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setExternalId(null);

    // Act
    RuleNode actualToDataResult = ruleNodeEntity.toData();

    // Assert
    RuleChainId ruleChainId = actualToDataResult.getRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    assertTrue(actualToDataResult.getId().isNullUid());
    assertTrue(ruleChainId.isNullUid());
  }
}
