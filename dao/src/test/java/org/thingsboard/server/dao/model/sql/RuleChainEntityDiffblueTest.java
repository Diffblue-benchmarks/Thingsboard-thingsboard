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
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

class RuleChainEntityDiffblueTest {
  /**
   * Test {@link RuleChainEntity#equals(Object)}, and {@link RuleChainEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainEntity#equals(Object)}
   *   <li>{@link RuleChainEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(ruleChainEntity, ruleChainEntity2);
    int expectedHashCodeResult = ruleChainEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainEntity2.hashCode());
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}, and {@link RuleChainEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainEntity#equals(Object)}
   *   <li>{@link RuleChainEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(null);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(null);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(ruleChainEntity, ruleChainEntity2);
    int expectedHashCodeResult = ruleChainEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainEntity2.hashCode());
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}, and {@link RuleChainEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainEntity#equals(Object)}
   *   <li>{@link RuleChainEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    // Act and Assert
    assertEquals(ruleChainEntity, ruleChainEntity);
    int expectedHashCodeResult = ruleChainEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainEntity.hashCode());
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(null);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(DoubleNode.valueOf(10.0d));
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(null);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(3L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(false);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(null);
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(null);
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName(null);
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("org.thingsboard.server.dao.model.sql.RuleChainEntity");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(false);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(null);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(null);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.EDGE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, null);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setFirstRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, "Different type to RuleChainEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RuleChainEntity.<init>()",
    "JsonNode RuleChainEntity.getAdditionalInfo()",
    "JsonNode RuleChainEntity.getConfiguration()",
    "UUID RuleChainEntity.getExternalId()",
    "UUID RuleChainEntity.getFirstRuleNodeId()",
    "String RuleChainEntity.getName()",
    "UUID RuleChainEntity.getTenantId()",
    "RuleChainType RuleChainEntity.getType()",
    "boolean RuleChainEntity.isDebugMode()",
    "boolean RuleChainEntity.isRoot()",
    "void RuleChainEntity.setAdditionalInfo(JsonNode)",
    "void RuleChainEntity.setConfiguration(JsonNode)",
    "void RuleChainEntity.setDebugMode(boolean)",
    "void RuleChainEntity.setExternalId(UUID)",
    "void RuleChainEntity.setFirstRuleNodeId(UUID)",
    "void RuleChainEntity.setName(String)",
    "void RuleChainEntity.setRoot(boolean)",
    "void RuleChainEntity.setTenantId(UUID)",
    "void RuleChainEntity.setType(RuleChainType)",
    "String RuleChainEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity();
    actualRuleChainEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualRuleChainEntity.setConfiguration(configuration);
    actualRuleChainEntity.setDebugMode(true);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRuleChainEntity.setExternalId(externalId);
    UUID firstRuleNodeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRuleChainEntity.setFirstRuleNodeId(firstRuleNodeId);
    actualRuleChainEntity.setName("Name");
    actualRuleChainEntity.setRoot(true);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualFirstRuleNodeId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Name", actualName);
    assertEquals(
        "RuleChainEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, name=Name, type=CORE, firstRuleNodeId"
            + "=784f394c-42b6-435a-983c-b7beff2784f9, root=true, debugMode=true, configuration={\"isPublic\":true},"
            + " additionalInfo={\"isPublic\":true}, externalId=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertNull(actualRuleChainEntity.getVersion());
    assertNull(actualRuleChainEntity.getId());
    assertNull(actualRuleChainEntity.getUuid());
    assertEquals(0L, actualRuleChainEntity.getCreatedTime());
    assertEquals(RuleChainType.CORE, actualType);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsRootResult);
    assertSame(externalId, actualExternalId);
    assertSame(firstRuleNodeId, actualFirstRuleNodeId);
    assertSame(tenantId, actualTenantId);
    assertSame(configuration, actualAdditionalInfo);
    assertSame(configuration, actualConfiguration);
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @DisplayName("Test new RuleChainEntity(RuleChain)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  void testNewRuleChainEntity() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    RuleChain ruleChain = new RuleChain(new RuleChainId(id));
    ruleChain.setFirstRuleNodeId(null);
    ruleChain.setExternalId(null);
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualRuleChainEntity.getTenantId().toString());
    UUID id2 = actualRuleChainEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
    assertSame(id, actualRuleChainEntity.getUuid());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @DisplayName("Test new RuleChainEntity(RuleChain)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  void testNewRuleChainEntity2() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    RuleChain ruleChain = new RuleChain(new RuleChainId(id));
    ruleChain.setFirstRuleNodeId(null);
    UUID id2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleChain.setExternalId(new RuleChainId(id2));
    ruleChain.setTenantId(null);

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    UUID id3 = actualRuleChainEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id3.toString());
    UUID externalId = actualRuleChainEntity.getExternalId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", externalId.toString());
    assertSame(id, id3);
    assertSame(id, actualRuleChainEntity.getUuid());
    assertSame(id2, externalId);
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @DisplayName("Test new RuleChainEntity(RuleChain)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  void testNewRuleChainEntity3() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    RuleChain ruleChain = new RuleChain(new RuleChainId(id));
    UUID id2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleChain.setFirstRuleNodeId(new RuleNodeId(id2));
    ruleChain.setExternalId(null);
    ruleChain.setTenantId(null);

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    UUID id3 = actualRuleChainEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id3.toString());
    UUID firstRuleNodeId = actualRuleChainEntity.getFirstRuleNodeId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", firstRuleNodeId.toString());
    assertSame(id, id3);
    assertSame(id, actualRuleChainEntity.getUuid());
    assertSame(id2, firstRuleNodeId);
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @DisplayName("Test new RuleChainEntity(RuleChain); given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  void testNewRuleChainEntity_givenA() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertNull(actualRuleChainEntity.getId());
    assertNull(actualRuleChainEntity.getUuid());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link RuleChain#RuleChain()} Root is {@code true}.
   *   <li>Then return Root.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @DisplayName(
      "Test new RuleChainEntity(RuleChain); given 'true'; when RuleChain() Root is 'true'; then return Root")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  void testNewRuleChainEntity_givenTrue_whenRuleChainRootIsTrue_thenReturnRoot() {
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
    assertTrue(actualRuleChainEntity.isRoot());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @DisplayName("Test new RuleChainEntity(RuleChain); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  void testNewRuleChainEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(new RuleChain(new RuleChain()));

    // Assert
    JsonNode additionalInfo = actualRuleChainEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertSame(additionalInfo, actualRuleChainEntity.getConfiguration());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <ul>
   *   <li>When {@link RuleChain#RuleChain(RuleChainId)} with id is {@link
   *       RuleChainId#RuleChainId(UUID)} FirstRuleNodeId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @DisplayName(
      "Test new RuleChainEntity(RuleChain); when RuleChain(RuleChainId) with id is RuleChainId(UUID) FirstRuleNodeId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  void testNewRuleChainEntity_whenRuleChainWithIdIsRuleChainIdFirstRuleNodeIdIsNull() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    RuleChain ruleChain = new RuleChain(new RuleChainId(id));
    ruleChain.setFirstRuleNodeId(null);
    ruleChain.setExternalId(null);
    ruleChain.setTenantId(null);

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    UUID id2 = actualRuleChainEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
    assertSame(id, actualRuleChainEntity.getUuid());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <ul>
   *   <li>When {@link RuleChain#RuleChain(RuleChain)} with ruleChain is {@link
   *       RuleChain#RuleChain(RuleChain)}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @DisplayName(
      "Test new RuleChainEntity(RuleChain); when RuleChain(RuleChain) with ruleChain is RuleChain(RuleChain)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  void testNewRuleChainEntity_whenRuleChainWithRuleChainIsRuleChain() {
    // Arrange and Act
    RuleChainEntity actualRuleChainEntity =
        new RuleChainEntity(new RuleChain(new RuleChain(new RuleChain())));

    // Assert
    JsonNode additionalInfo = actualRuleChainEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertSame(additionalInfo, actualRuleChainEntity.getConfiguration());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <ul>
   *   <li>When {@link RuleChain#RuleChain()}.
   *   <li>Then return AdditionalInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @DisplayName(
      "Test new RuleChainEntity(RuleChain); when RuleChain(); then return AdditionalInfo is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  void testNewRuleChainEntity_whenRuleChain_thenReturnAdditionalInfoIsNull() {
    // Arrange and Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(new RuleChain());

    // Assert
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertNull(actualRuleChainEntity.getId());
    assertNull(actualRuleChainEntity.getUuid());
  }

  /**
   * Test {@link RuleChainEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link RuleChainEntity#RuleChainEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given RuleChainEntity(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainEntity.toData()"})
  void testToData_givenRuleChainEntity_thenAdditionalInfoReturnNullNode()
      throws UnsupportedEncodingException {
    // Arrange and Act
    RuleChain actualToDataResult = new RuleChainEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isDebugMode());
    assertFalse(actualToDataResult.isDefault());
    assertFalse(actualToDataResult.isRoot());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualToDataResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChainEntity#toData()}.
   *
   * <ul>
   *   <li>Then return FirstRuleNodeId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return FirstRuleNodeId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainEntity.toData()"})
  void testToData_thenReturnFirstRuleNodeIdIdToStringIs784f394c42b6435a983cB7beff2784f9()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);
    UUID firstRuleNodeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleChainEntity.setFirstRuleNodeId(firstRuleNodeId);
    ruleChainEntity.setExternalId(null);

    // Act
    RuleChain actualToDataResult = ruleChainEntity.toData();

    // Assert
    RuleNodeId firstRuleNodeId2 = actualToDataResult.getFirstRuleNodeId();
    UUID id = firstRuleNodeId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_NODE, firstRuleNodeId2.getEntityType());
    assertFalse(firstRuleNodeId2.isNullUid());
    assertSame(firstRuleNodeId, id);
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualToDataResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChainEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    UUID tenantId = UUID.randomUUID();
    ruleChainEntity.setTenantId(tenantId);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);
    ruleChainEntity.setFirstRuleNodeId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleChainEntity.setExternalId(externalId);

    // Act
    RuleChain actualToDataResult = ruleChainEntity.toData();

    // Assert
    RuleChainId externalId2 = actualToDataResult.getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_CHAIN, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertEquals(externalId2, actualToDataResult.getId());
    assertSame(externalId, id);
    assertSame(tenantId, actualToDataResult.getTenantId().getId());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualToDataResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChainEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainEntity.setVersion(1L);
    ruleChainEntity.setFirstRuleNodeId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleChainEntity.setExternalId(externalId);

    // Act
    RuleChain actualToDataResult = ruleChainEntity.toData();

    // Assert
    RuleChainId externalId2 = actualToDataResult.getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(
        "784f394c-42b6-435a-983c-b7beff2784f9",
        actualToDataResult.getTenantId().getId().toString());
    assertEquals(EntityType.RULE_CHAIN, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertEquals(externalId2, actualToDataResult.getId());
    assertSame(externalId, id);
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualToDataResult.getConfigurationBytes());
  }
}
