package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

class RuleNodeEntityDiffblueTest {
  /**
   * Test {@link RuleNodeEntity#equals(Object)}, and {@link RuleNodeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeEntity#equals(Object)}
   *   <li>{@link RuleNodeEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(ruleNodeEntity, ruleNodeEntity2);
    int expectedHashCodeResult = ruleNodeEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}, and {@link RuleNodeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeEntity#equals(Object)}
   *   <li>{@link RuleNodeEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(null);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(null);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(ruleNodeEntity, ruleNodeEntity2);
    int expectedHashCodeResult = ruleNodeEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}, and {@link RuleNodeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeEntity#equals(Object)}
   *   <li>{@link RuleNodeEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(ruleNodeEntity, ruleNodeEntity);
    int expectedHashCodeResult = ruleNodeEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeEntity.hashCode());
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(null);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(DoubleNode.valueOf(10.0d));
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(null);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(3);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(3L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(false);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(null);
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Type");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName(null);
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Type");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName(null);
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(null);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(false);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Name");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType(null);
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, null);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeEntity, "Different type to RuleNodeEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RuleNodeEntity.<init>()",
    "JsonNode RuleNodeEntity.getAdditionalInfo()",
    "JsonNode RuleNodeEntity.getConfiguration()",
    "int RuleNodeEntity.getConfigurationVersion()",
    "UUID RuleNodeEntity.getExternalId()",
    "String RuleNodeEntity.getName()",
    "String RuleNodeEntity.getQueueName()",
    "UUID RuleNodeEntity.getRuleChainId()",
    "String RuleNodeEntity.getType()",
    "boolean RuleNodeEntity.isDebugMode()",
    "boolean RuleNodeEntity.isSingletonMode()",
    "void RuleNodeEntity.setAdditionalInfo(JsonNode)",
    "void RuleNodeEntity.setConfiguration(JsonNode)",
    "void RuleNodeEntity.setConfigurationVersion(int)",
    "void RuleNodeEntity.setDebugMode(boolean)",
    "void RuleNodeEntity.setExternalId(UUID)",
    "void RuleNodeEntity.setName(String)",
    "void RuleNodeEntity.setQueueName(String)",
    "void RuleNodeEntity.setRuleChainId(UUID)",
    "void RuleNodeEntity.setSingletonMode(boolean)",
    "void RuleNodeEntity.setType(String)",
    "String RuleNodeEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity();
    actualRuleNodeEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualRuleNodeEntity.setConfiguration(configuration);
    actualRuleNodeEntity.setConfigurationVersion(1);
    actualRuleNodeEntity.setDebugMode(true);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRuleNodeEntity.setExternalId(externalId);
    actualRuleNodeEntity.setName("Name");
    actualRuleNodeEntity.setQueueName("Queue Name");
    UUID ruleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualRuleChainId.toString());
    assertEquals("Name", actualName);
    assertEquals("Queue Name", actualQueueName);
    assertEquals(
        "RuleNodeEntity(ruleChainId=784f394c-42b6-435a-983c-b7beff2784f9, type=Type, name=Name, configurationVersion"
            + "=1, configuration={\"isPublic\":true}, additionalInfo={\"isPublic\":true}, debugMode=true, singletonMode=true,"
            + " queueName=Queue Name, externalId=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertNull(actualRuleNodeEntity.getId());
    assertNull(actualRuleNodeEntity.getUuid());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertEquals(1, actualConfigurationVersion);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsSingletonModeResult);
    assertSame(externalId, actualExternalId);
    assertSame(ruleChainId, actualRuleChainId);
    assertSame(configuration, actualAdditionalInfo);
    assertSame(configuration, actualConfiguration);
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @DisplayName("Test new RuleNodeEntity(RuleNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  void testNewRuleNodeEntity() {
    // Arrange
    RuleNode ruleNode = new RuleNode((RuleNodeId) null);
    ruleNode.setRuleChainId(null);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleNode.setExternalId(new RuleNodeId(id));

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    UUID externalId = actualRuleNodeEntity.getExternalId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", externalId.toString());
    assertNull(actualRuleNodeEntity.getAdditionalInfo());
    assertNull(actualRuleNodeEntity.getConfiguration());
    assertSame(id, externalId);
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @DisplayName("Test new RuleNodeEntity(RuleNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  void testNewRuleNodeEntity2() {
    // Arrange
    RuleNode ruleNode = new RuleNode((RuleNodeId) null);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleNode.setRuleChainId(new RuleChainId(id));
    ruleNode.setExternalId(null);

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    UUID ruleChainId = actualRuleNodeEntity.getRuleChainId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", ruleChainId.toString());
    assertNull(actualRuleNodeEntity.getAdditionalInfo());
    assertNull(actualRuleNodeEntity.getConfiguration());
    assertSame(id, ruleChainId);
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @DisplayName("Test new RuleNodeEntity(RuleNode); given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  void testNewRuleNodeEntity_givenA() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    assertNull(actualRuleNodeEntity.getId());
    assertNull(actualRuleNodeEntity.getUuid());
    assertNull(actualRuleNodeEntity.getExternalId());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertFalse(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return CreatedTime is three.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @DisplayName("Test new RuleNodeEntity(RuleNode); given three; then return CreatedTime is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  void testNewRuleNodeEntity_givenThree_thenReturnCreatedTimeIsThree() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setCreatedTime(3L);

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    assertNull(actualRuleNodeEntity.getId());
    assertNull(actualRuleNodeEntity.getUuid());
    assertNull(actualRuleNodeEntity.getExternalId());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(3L, actualRuleNodeEntity.getCreatedTime());
    assertFalse(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link RuleNode#RuleNode()} DebugMode is {@code true}.
   *   <li>Then return DebugMode.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @DisplayName(
      "Test new RuleNodeEntity(RuleNode); given 'true'; when RuleNode() DebugMode is 'true'; then return DebugMode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  void testNewRuleNodeEntity_givenTrue_whenRuleNodeDebugModeIsTrue_thenReturnDebugMode() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    assertNull(actualRuleNodeEntity.getId());
    assertNull(actualRuleNodeEntity.getUuid());
    assertNull(actualRuleNodeEntity.getExternalId());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertTrue(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @DisplayName("Test new RuleNodeEntity(RuleNode); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  void testNewRuleNodeEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(new RuleNode(new RuleNode()));

    // Assert
    JsonNode additionalInfo = actualRuleNodeEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertSame(additionalInfo, actualRuleNodeEntity.getConfiguration());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @DisplayName(
      "Test new RuleNodeEntity(RuleNode); then return Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  void testNewRuleNodeEntity_thenReturnIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    RuleNode ruleNode = new RuleNode(new RuleNodeId(id));
    ruleNode.setRuleChainId(null);
    ruleNode.setExternalId(null);

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    UUID id2 = actualRuleNodeEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
    assertSame(id, actualRuleNodeEntity.getUuid());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>When {@link RuleNode#RuleNode(RuleNode)} with ruleNode is {@link
   *       RuleNode#RuleNode(RuleNode)}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @DisplayName(
      "Test new RuleNodeEntity(RuleNode); when RuleNode(RuleNode) with ruleNode is RuleNode(RuleNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  void testNewRuleNodeEntity_whenRuleNodeWithRuleNodeIsRuleNode() {
    // Arrange and Act
    RuleNodeEntity actualRuleNodeEntity =
        new RuleNodeEntity(new RuleNode(new RuleNode(new RuleNode())));

    // Assert
    JsonNode additionalInfo = actualRuleNodeEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertSame(additionalInfo, actualRuleNodeEntity.getConfiguration());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>When {@link RuleNode#RuleNode()}.
   *   <li>Then return CreatedTime is zero.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @DisplayName(
      "Test new RuleNodeEntity(RuleNode); when RuleNode(); then return CreatedTime is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  void testNewRuleNodeEntity_whenRuleNode_thenReturnCreatedTimeIsZero() {
    // Arrange and Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(new RuleNode());

    // Assert
    assertNull(actualRuleNodeEntity.getId());
    assertNull(actualRuleNodeEntity.getUuid());
    assertNull(actualRuleNodeEntity.getExternalId());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertFalse(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeEntity#RuleNodeEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given RuleNodeEntity(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNode RuleNodeEntity.toData()"})
  void testToData_givenRuleNodeEntity_thenAdditionalInfoReturnNullNode()
      throws UnsupportedEncodingException {
    // Arrange and Act
    RuleNode actualToDataResult = new RuleNodeEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getQueueName());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUuidId());
    assertEquals(0, actualToDataResult.getConfigurationVersion());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isDebugMode());
    assertFalse(actualToDataResult.isSingletonMode());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualToDataResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNodeEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return ExternalId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNode RuleNodeEntity.toData()"})
  void testToData_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9()
      throws UnsupportedEncodingException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setRuleChainId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleNodeEntity.setExternalId(externalId);

    // Act
    RuleNode actualToDataResult = ruleNodeEntity.toData();

    // Assert
    RuleNodeId externalId2 = actualToDataResult.getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_NODE, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertEquals(externalId2, actualToDataResult.getId());
    assertSame(externalId, id);
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualToDataResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNodeEntity#toData()}.
   *
   * <ul>
   *   <li>Then return RuleChainId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return RuleChainId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNode RuleNodeEntity.toData()"})
  void testToData_thenReturnRuleChainIdIdToStringIs784f394c42b6435a983cB7beff2784f9()
      throws UnsupportedEncodingException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID ruleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleNodeEntity.setRuleChainId(ruleChainId);
    ruleNodeEntity.setExternalId(null);

    // Act
    RuleNode actualToDataResult = ruleNodeEntity.toData();

    // Assert
    RuleChainId ruleChainId2 = actualToDataResult.getRuleChainId();
    UUID id = ruleChainId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_CHAIN, ruleChainId2.getEntityType());
    assertFalse(ruleChainId2.isNullUid());
    assertSame(ruleChainId, id);
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualToDataResult.getConfigurationBytes());
  }
}
