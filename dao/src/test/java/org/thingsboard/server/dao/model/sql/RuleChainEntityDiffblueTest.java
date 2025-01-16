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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class RuleChainEntityDiffblueTest {
  /**
   * Test {@link RuleChainEntity#equals(Object)}, and
   * {@link RuleChainEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainEntity#equals(Object)}
   *   <li>{@link RuleChainEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(ruleChainEntity, ruleChainEntity2);
    int expectedHashCodeResult = ruleChainEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainEntity2.hashCode());
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}, and
   * {@link RuleChainEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainEntity#equals(Object)}
   *   <li>{@link RuleChainEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    // Act and Assert
    assertEquals(ruleChainEntity, ruleChainEntity);
    int expectedHashCodeResult = ruleChainEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainEntity.hashCode());
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(MissingNode.getInstance());
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(null);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(mock(JsonNode.class));
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(MissingNode.getInstance());
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(null);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(3L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(false);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.randomUUID());
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(null);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(UUID.randomUUID());
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(null);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName(null);
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("org.thingsboard.server.dao.model.sql.RuleChainEntity");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(false);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.randomUUID());
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(null);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(null);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.EDGE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, null);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, "Different type to RuleChainEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainEntity#RuleChainEntity()}
   *   <li>{@link RuleChainEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link RuleChainEntity#setConfiguration(JsonNode)}
   *   <li>{@link RuleChainEntity#setDebugMode(boolean)}
   *   <li>{@link RuleChainEntity#setExternalId(UUID)}
   *   <li>{@link RuleChainEntity#setFirstRuleNodeId(UUID)}
   *   <li>{@link RuleChainEntity#setName(String)}
   *   <li>{@link RuleChainEntity#setRoot(boolean)}
   *   <li>{@link RuleChainEntity#setTenantId(UUID)}
   *   <li>{@link RuleChainEntity#setType(RuleChainType)}
   *   <li>{@link RuleChainEntity#toString()}
   *   <li>{@link RuleChainEntity#getAdditionalInfo()}
   *   <li>{@link RuleChainEntity#getConfiguration()}
   *   <li>{@link RuleChainEntity#getExternalId()}
   *   <li>{@link RuleChainEntity#getFirstRuleNodeId()}
   *   <li>{@link RuleChainEntity#getName()}
   *   <li>{@link RuleChainEntity#getTenantId()}
   *   <li>{@link RuleChainEntity#getType()}
   *   <li>{@link RuleChainEntity#isDebugMode()}
   *   <li>{@link RuleChainEntity#isRoot()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity();
    actualRuleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualRuleChainEntity.setConfiguration(configuration);
    actualRuleChainEntity.setDebugMode(true);
    actualRuleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    actualRuleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    actualRuleChainEntity.setName("Name");
    actualRuleChainEntity.setRoot(true);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualRuleChainEntity.setTenantId(tenantId);
    actualRuleChainEntity.setType(RuleChainType.CORE);
    String actualToStringResult = actualRuleChainEntity.toString();
    JsonNode actualAdditionalInfo = actualRuleChainEntity.getAdditionalInfo();
    JsonNode actualConfiguration = actualRuleChainEntity.getConfiguration();
    UUID actualExternalId = actualRuleChainEntity.getExternalId();
    UUID actualFirstRuleNodeId = actualRuleChainEntity.getFirstRuleNodeId();
    String actualName = actualRuleChainEntity.getName();
    UUID actualTenantId = actualRuleChainEntity.getTenantId();
    RuleChainType actualType = actualRuleChainEntity.getType();
    boolean actualIsDebugModeResult = actualRuleChainEntity.isDebugMode();
    boolean actualIsRootResult = actualRuleChainEntity.isRoot();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Name", actualName);
    assertEquals(
        "RuleChainEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, type=CORE, firstRuleNodeId"
            + "=13814000-1dd2-11b2-8080-808080808080, root=true, debugMode=true, configuration={\"isPublic\":true},"
            + " additionalInfo={\"isPublic\":true}, externalId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals(0L, actualRuleChainEntity.getCreatedTime());
    assertEquals(RuleChainType.CORE, actualType);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsRootResult);
    assertSame(configuration, actualAdditionalInfo);
    assertSame(configuration, actualConfiguration);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualFirstRuleNodeId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   * <p>
   * Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  public void testNewRuleChainEntity() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setFirstRuleNodeId(null);
    ruleChain.setExternalId(null);
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRuleChainEntity.getTenantId().toString());
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertNull(actualRuleChainEntity.getId());
    assertNull(actualRuleChainEntity.getUuid());
    assertNull(actualRuleChainEntity.getExternalId());
    assertNull(actualRuleChainEntity.getFirstRuleNodeId());
    assertFalse(actualRuleChainEntity.isRoot());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   * <p>
   * Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  public void testNewRuleChainEntity2() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setFirstRuleNodeId(null);
    ruleChain.setExternalId(new RuleChainId(ModelConstants.NULL_UUID));
    ruleChain.setTenantId(null);

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRuleChainEntity.getExternalId().toString());
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertNull(actualRuleChainEntity.getId());
    assertNull(actualRuleChainEntity.getUuid());
    assertNull(actualRuleChainEntity.getFirstRuleNodeId());
    assertNull(actualRuleChainEntity.getTenantId());
    assertFalse(actualRuleChainEntity.isRoot());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   * <p>
   * Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  public void testNewRuleChainEntity3() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setFirstRuleNodeId(new RuleNodeId(ModelConstants.NULL_UUID));
    ruleChain.setExternalId(null);
    ruleChain.setTenantId(null);

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRuleChainEntity.getFirstRuleNodeId().toString());
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertNull(actualRuleChainEntity.getId());
    assertNull(actualRuleChainEntity.getUuid());
    assertNull(actualRuleChainEntity.getExternalId());
    assertNull(actualRuleChainEntity.getTenantId());
    assertFalse(actualRuleChainEntity.isRoot());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  public void testNewRuleChainEntity_givenA() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertNull(actualRuleChainEntity.getId());
    assertNull(actualRuleChainEntity.getUuid());
    assertNull(actualRuleChainEntity.getExternalId());
    assertNull(actualRuleChainEntity.getFirstRuleNodeId());
    assertNull(actualRuleChainEntity.getTenantId());
    assertFalse(actualRuleChainEntity.isRoot());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link RuleChain#RuleChain()} Root is {@code true}.</li>
   *   <li>Then return Root.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  public void testNewRuleChainEntity_givenTrue_whenRuleChainRootIsTrue_thenReturnRoot() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setRoot(true);

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertNull(actualRuleChainEntity.getId());
    assertNull(actualRuleChainEntity.getUuid());
    assertNull(actualRuleChainEntity.getExternalId());
    assertNull(actualRuleChainEntity.getFirstRuleNodeId());
    assertNull(actualRuleChainEntity.getTenantId());
    assertTrue(actualRuleChainEntity.isRoot());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  public void testNewRuleChainEntity_thenAdditionalInfoReturnNullNode() throws IOException {
    // Arrange and Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(new RuleChain(new RuleChain()));

    // Assert
    JsonNode additionalInfo = actualRuleChainEntity.getAdditionalInfo();
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
    assertSame(additionalInfo, actualRuleChainEntity.getConfiguration());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   * <ul>
   *   <li>Then return Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  public void testNewRuleChainEntity_thenReturnIdToStringIs138140001dd211b28080808080808080() {
    // Arrange and Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(
        new RuleChain(new RuleChainId(ModelConstants.NULL_UUID)));

    // Assert
    UUID id = actualRuleChainEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertSame(id, actualRuleChainEntity.getUuid());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   * <ul>
   *   <li>When {@link RuleChain#RuleChain(RuleChain)} with ruleChain is
   * {@link RuleChain#RuleChain(RuleChain)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  public void testNewRuleChainEntity_whenRuleChainWithRuleChainIsRuleChain() throws IOException {
    // Arrange and Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(new RuleChain(new RuleChain(new RuleChain())));

    // Assert
    JsonNode additionalInfo = actualRuleChainEntity.getAdditionalInfo();
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
    assertSame(additionalInfo, actualRuleChainEntity.getConfiguration());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   * <ul>
   *   <li>When {@link RuleChain#RuleChain()}.</li>
   *   <li>Then return ExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  public void testNewRuleChainEntity_whenRuleChain_thenReturnExternalIdIsNull() {
    // Arrange and Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(new RuleChain());

    // Assert
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertNull(actualRuleChainEntity.getId());
    assertNull(actualRuleChainEntity.getUuid());
    assertNull(actualRuleChainEntity.getExternalId());
    assertNull(actualRuleChainEntity.getFirstRuleNodeId());
    assertNull(actualRuleChainEntity.getTenantId());
    assertFalse(actualRuleChainEntity.isRoot());
  }

  /**
   * Test {@link RuleChainEntity#toData()}.
   * <ul>
   *   <li>Given {@link RuleChainEntity#RuleChainEntity()} TenantId is
   * randomUUID.</li>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#toData()}
   */
  @Test
  public void testToData_givenRuleChainEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    UUID tenantId = UUID.randomUUID();
    ruleChainEntity.setTenantId(tenantId);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    ruleChainEntity.setFirstRuleNodeId(null);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    RuleChain actualToDataResult = ruleChainEntity.toData();

    // Assert
    RuleChainId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.RULE_CHAIN, externalId.getEntityType());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link RuleChainEntity#toData()}.
   * <ul>
   *   <li>Given {@link RuleChainEntity#RuleChainEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#toData()}
   */
  @Test
  public void testToData_givenRuleChainEntity_thenAdditionalInfoReturnNullNode() throws UnsupportedEncodingException {
    // Arrange and Act
    RuleChain actualToDataResult = (new RuleChainEntity()).toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    RuleChainId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getTenantId().getId());
    assertNull(actualToDataResult.getType());
    assertEquals(0, additionalInfo.size());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(id.isNullUid());
    assertFalse(actualToDataResult.isDebugMode());
    assertFalse(actualToDataResult.isDefault());
    assertFalse(actualToDataResult.isRoot());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualToDataResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChainEntity#toData()}.
   * <ul>
   *   <li>Then return FirstRuleNodeId EntityType is {@code RULE_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#toData()}
   */
  @Test
  public void testToData_thenReturnFirstRuleNodeIdEntityTypeIsRuleNode() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setExternalId(null);

    // Act
    RuleChain actualToDataResult = ruleChainEntity.toData();

    // Assert
    RuleNodeId firstRuleNodeId = actualToDataResult.getFirstRuleNodeId();
    assertEquals(EntityType.RULE_NODE, firstRuleNodeId.getEntityType());
    assertTrue(firstRuleNodeId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link RuleChainEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    ruleChainEntity.setFirstRuleNodeId(null);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    RuleChain actualToDataResult = ruleChainEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    RuleChainId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.RULE_CHAIN, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertEquals(externalId, actualToDataResult.getId());
  }
}
