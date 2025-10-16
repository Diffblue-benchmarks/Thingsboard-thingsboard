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
package org.thingsboard.server.common.data.rule;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;

class RuleChainDiffblueTest {
  /**
   * Test {@link RuleChain#equals(Object)}, and {@link RuleChain#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChain#equals(Object)}
   *   <li>{@link RuleChain#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    RuleChain ruleChain2 = new RuleChain();

    // Act and Assert
    assertEquals(ruleChain, ruleChain2);
    assertEquals(ruleChain.hashCode(), ruleChain2.hashCode());
  }

  /**
   * Test {@link RuleChain#equals(Object)}, and {@link RuleChain#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChain#equals(Object)}
   *   <li>{@link RuleChain#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    // Act and Assert
    assertEquals(ruleChain, ruleChain);
    int expectedHashCodeResult = ruleChain.hashCode();
    assertEquals(expectedHashCodeResult, ruleChain.hashCode());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setName("Name");

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setType(RuleChainType.CORE);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setFirstRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setRoot(true);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setDebugMode(true);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setExternalId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setName("Name");

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setType(RuleChainType.CORE);

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setFirstRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setExternalId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChain(), null);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.equals(Object)", "int RuleChain.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChain(), "Different type to RuleChain");
  }

  /**
   * Test {@link RuleChain#getExternalId()}.
   *
   * <p>Method under test: {@link RuleChain#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChainId RuleChain.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new RuleChain().getExternalId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChain#RuleChain()}
   *   <li>{@link RuleChain#setConfigurationBytes(byte[])}
   *   <li>{@link RuleChain#setDebugMode(boolean)}
   *   <li>{@link RuleChain#setExternalId(RuleChainId)}
   *   <li>{@link RuleChain#setFirstRuleNodeId(RuleNodeId)}
   *   <li>{@link RuleChain#setName(String)}
   *   <li>{@link RuleChain#setRoot(boolean)}
   *   <li>{@link RuleChain#setTenantId(TenantId)}
   *   <li>{@link RuleChain#setType(RuleChainType)}
   *   <li>{@link RuleChain#setVersion(Long)}
   *   <li>{@link RuleChain#toString()}
   *   <li>{@link RuleChain#getConfigurationBytes()}
   *   <li>{@link RuleChain#getFirstRuleNodeId()}
   *   <li>{@link RuleChain#getName()}
   *   <li>{@link RuleChain#getTenantId()}
   *   <li>{@link RuleChain#getType()}
   *   <li>{@link RuleChain#getVersion()}
   *   <li>{@link RuleChain#isDebugMode()}
   *   <li>{@link RuleChain#isRoot()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChain.<init>()",
    "void RuleChain.<init>(RuleChainId)",
    "byte[] RuleChain.getConfigurationBytes()",
    "RuleNodeId RuleChain.getFirstRuleNodeId()",
    "String RuleChain.getName()",
    "TenantId RuleChain.getTenantId()",
    "RuleChainType RuleChain.getType()",
    "Long RuleChain.getVersion()",
    "boolean RuleChain.isDebugMode()",
    "boolean RuleChain.isRoot()",
    "void RuleChain.setConfigurationBytes(byte[])",
    "void RuleChain.setDebugMode(boolean)",
    "void RuleChain.setExternalId(RuleChainId)",
    "void RuleChain.setFirstRuleNodeId(RuleNodeId)",
    "void RuleChain.setName(String)",
    "void RuleChain.setRoot(boolean)",
    "void RuleChain.setTenantId(TenantId)",
    "void RuleChain.setType(RuleChainType)",
    "void RuleChain.setVersion(Long)",
    "String RuleChain.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsNull() throws UnsupportedEncodingException {
    // Arrange and Act
    RuleChain actualRuleChain = new RuleChain();
    byte[] configurationBytes = "AXAXAXAX".getBytes("UTF-8");
    actualRuleChain.setConfigurationBytes(configurationBytes);
    actualRuleChain.setDebugMode(true);
    RuleChainId externalId = new RuleChainId(EntityId.NULL_UUID);
    actualRuleChain.setExternalId(externalId);
    RuleNodeId firstRuleNodeId = new RuleNodeId(EntityId.NULL_UUID);
    actualRuleChain.setFirstRuleNodeId(firstRuleNodeId);
    actualRuleChain.setName("Name");
    actualRuleChain.setRoot(true);
    actualRuleChain.setTenantId(TenantId.SYS_TENANT_ID);
    actualRuleChain.setType(RuleChainType.CORE);
    actualRuleChain.setVersion(1L);
    String actualToStringResult = actualRuleChain.toString();
    byte[] actualConfigurationBytes = actualRuleChain.getConfigurationBytes();
    RuleNodeId actualFirstRuleNodeId = actualRuleChain.getFirstRuleNodeId();
    String actualName = actualRuleChain.getName();
    TenantId actualTenantId = actualRuleChain.getTenantId();
    RuleChainType actualType = actualRuleChain.getType();
    Long actualVersion = actualRuleChain.getVersion();
    boolean actualIsDebugModeResult = actualRuleChain.isDebugMode();
    boolean actualIsRootResult = actualRuleChain.isRoot();

    // Assert
    assertEquals("Name", actualName);
    assertEquals(
        "RuleChain(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, type=CORE, firstRuleNodeId=13814000"
            + "-1dd2-11b2-8080-808080808080, root=true, debugMode=true, configuration=null, externalId=13814000-1dd2"
            + "-11b2-8080-808080808080, version=1, configurationBytes=[65, 88, 65, 88, 65, 88, 65, 88])",
        actualToStringResult);
    assertNull(actualRuleChain.getId());
    assertEquals(0L, actualRuleChain.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertEquals(RuleChainType.CORE, actualType);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsRootResult);
    assertSame(externalId, actualRuleChain.getExternalId());
    assertSame(firstRuleNodeId, actualFirstRuleNodeId);
    assertSame(configurationBytes, actualConfigurationBytes);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualConfigurationBytes);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@link RuleChainId#RuleChainId(UUID)} with id is {@link
   *       EntityId#NULL_UUID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChain#RuleChain(RuleChainId)}
   *   <li>{@link RuleChain#setConfigurationBytes(byte[])}
   *   <li>{@link RuleChain#setDebugMode(boolean)}
   *   <li>{@link RuleChain#setExternalId(RuleChainId)}
   *   <li>{@link RuleChain#setFirstRuleNodeId(RuleNodeId)}
   *   <li>{@link RuleChain#setName(String)}
   *   <li>{@link RuleChain#setRoot(boolean)}
   *   <li>{@link RuleChain#setTenantId(TenantId)}
   *   <li>{@link RuleChain#setType(RuleChainType)}
   *   <li>{@link RuleChain#setVersion(Long)}
   *   <li>{@link RuleChain#toString()}
   *   <li>{@link RuleChain#getConfigurationBytes()}
   *   <li>{@link RuleChain#getFirstRuleNodeId()}
   *   <li>{@link RuleChain#getName()}
   *   <li>{@link RuleChain#getTenantId()}
   *   <li>{@link RuleChain#getType()}
   *   <li>{@link RuleChain#getVersion()}
   *   <li>{@link RuleChain#isDebugMode()}
   *   <li>{@link RuleChain#isRoot()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is RuleChainId(UUID) with id is NULL_UUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChain.<init>()",
    "void RuleChain.<init>(RuleChainId)",
    "byte[] RuleChain.getConfigurationBytes()",
    "RuleNodeId RuleChain.getFirstRuleNodeId()",
    "String RuleChain.getName()",
    "TenantId RuleChain.getTenantId()",
    "RuleChainType RuleChain.getType()",
    "Long RuleChain.getVersion()",
    "boolean RuleChain.isDebugMode()",
    "boolean RuleChain.isRoot()",
    "void RuleChain.setConfigurationBytes(byte[])",
    "void RuleChain.setDebugMode(boolean)",
    "void RuleChain.setExternalId(RuleChainId)",
    "void RuleChain.setFirstRuleNodeId(RuleNodeId)",
    "void RuleChain.setName(String)",
    "void RuleChain.setRoot(boolean)",
    "void RuleChain.setTenantId(TenantId)",
    "void RuleChain.setType(RuleChainType)",
    "void RuleChain.setVersion(Long)",
    "String RuleChain.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsRuleChainIdWithIdIsNull_uuid()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainId id = new RuleChainId(EntityId.NULL_UUID);

    // Act
    RuleChain actualRuleChain = new RuleChain(id);
    byte[] configurationBytes = "AXAXAXAX".getBytes("UTF-8");
    actualRuleChain.setConfigurationBytes(configurationBytes);
    actualRuleChain.setDebugMode(true);
    RuleChainId externalId = new RuleChainId(EntityId.NULL_UUID);
    actualRuleChain.setExternalId(externalId);
    RuleNodeId firstRuleNodeId = new RuleNodeId(EntityId.NULL_UUID);
    actualRuleChain.setFirstRuleNodeId(firstRuleNodeId);
    actualRuleChain.setName("Name");
    actualRuleChain.setRoot(true);
    actualRuleChain.setTenantId(TenantId.SYS_TENANT_ID);
    actualRuleChain.setType(RuleChainType.CORE);
    actualRuleChain.setVersion(1L);
    String actualToStringResult = actualRuleChain.toString();
    byte[] actualConfigurationBytes = actualRuleChain.getConfigurationBytes();
    RuleNodeId actualFirstRuleNodeId = actualRuleChain.getFirstRuleNodeId();
    String actualName = actualRuleChain.getName();
    TenantId actualTenantId = actualRuleChain.getTenantId();
    RuleChainType actualType = actualRuleChain.getType();
    Long actualVersion = actualRuleChain.getVersion();
    boolean actualIsDebugModeResult = actualRuleChain.isDebugMode();
    boolean actualIsRootResult = actualRuleChain.isRoot();

    // Assert
    assertEquals("Name", actualName);
    assertEquals(
        "RuleChain(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, type=CORE, firstRuleNodeId=13814000"
            + "-1dd2-11b2-8080-808080808080, root=true, debugMode=true, configuration=null, externalId=13814000-1dd2"
            + "-11b2-8080-808080808080, version=1, configurationBytes=[65, 88, 65, 88, 65, 88, 65, 88])",
        actualToStringResult);
    assertEquals(0L, actualRuleChain.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertEquals(RuleChainType.CORE, actualType);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsRootResult);
    assertSame(externalId, actualRuleChain.getExternalId());
    assertSame(id, actualRuleChain.getId());
    assertSame(firstRuleNodeId, actualFirstRuleNodeId);
    assertSame(configurationBytes, actualConfigurationBytes);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualConfigurationBytes);
  }

  /**
   * Test {@link RuleChain#RuleChain(RuleChain)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  @DisplayName("Test new RuleChain(RuleChain); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChain.<init>(RuleChain)"})
  void testNewRuleChain_givenA() throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    RuleChain actualRuleChain = new RuleChain(ruleChain);

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(actualRuleChain.isRoot());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    assertArrayEquals("null".getBytes("UTF-8"), actualRuleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#RuleChain(RuleChain)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   *   <li>Then Configuration return {@link MissingNode}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  @DisplayName(
      "Test new RuleChain(RuleChain); given empty array of byte; then Configuration return MissingNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChain.<init>(RuleChain)"})
  void testNewRuleChain_givenEmptyArrayOfByte_thenConfigurationReturnMissingNode()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[] {});

    // Act
    RuleChain actualRuleChain = new RuleChain(ruleChain);

    // Assert
    assertTrue(actualRuleChain.getConfiguration() instanceof MissingNode);
    assertArrayEquals("null".getBytes("UTF-8"), actualRuleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#RuleChain(RuleChain)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link RuleChain#RuleChain()} Root is {@code true}.
   *   <li>Then return Root.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  @DisplayName(
      "Test new RuleChain(RuleChain); given 'true'; when RuleChain() Root is 'true'; then return Root")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChain.<init>(RuleChain)"})
  void testNewRuleChain_givenTrue_whenRuleChainRootIsTrue_thenReturnRoot()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setRoot(true);

    // Act
    RuleChain actualRuleChain = new RuleChain(ruleChain);

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertTrue(actualRuleChain.isRoot());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    assertArrayEquals("null".getBytes("UTF-8"), actualRuleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#RuleChain(RuleChain)}.
   *
   * <ul>
   *   <li>When {@link RuleChain#RuleChain(RuleChain)} with ruleChain is {@link
   *       RuleChain#RuleChain()}.
   *   <li>Then return not Root.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  @DisplayName(
      "Test new RuleChain(RuleChain); when RuleChain(RuleChain) with ruleChain is RuleChain(); then return not Root")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChain.<init>(RuleChain)"})
  void testNewRuleChain_whenRuleChainWithRuleChainIsRuleChain_thenReturnNotRoot()
      throws UnsupportedEncodingException {
    // Arrange and Act
    RuleChain actualRuleChain = new RuleChain(new RuleChain(new RuleChain()));

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(actualRuleChain.isRoot());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    assertArrayEquals("null".getBytes("UTF-8"), actualRuleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#RuleChain(RuleChain)}.
   *
   * <ul>
   *   <li>When {@link RuleChain#RuleChain(RuleChain)} with ruleChain is {@link
   *       RuleChain#RuleChain(RuleChain)}.
   *   <li>Then return not Root.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  @DisplayName(
      "Test new RuleChain(RuleChain); when RuleChain(RuleChain) with ruleChain is RuleChain(RuleChain); then return not Root")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChain.<init>(RuleChain)"})
  void testNewRuleChain_whenRuleChainWithRuleChainIsRuleChain_thenReturnNotRoot2()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChain(new RuleChain()));

    // Act
    RuleChain actualRuleChain = new RuleChain(ruleChain);

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(actualRuleChain.isRoot());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    assertArrayEquals("null".getBytes("UTF-8"), actualRuleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#RuleChain(RuleChain)}.
   *
   * <ul>
   *   <li>When {@link RuleChain#RuleChain()}.
   *   <li>Then return not Root.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  @DisplayName("Test new RuleChain(RuleChain); when RuleChain(); then return not Root")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChain.<init>(RuleChain)"})
  void testNewRuleChain_whenRuleChain_thenReturnNotRoot() throws UnsupportedEncodingException {
    // Arrange and Act
    RuleChain actualRuleChain = new RuleChain(new RuleChain());

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(actualRuleChain.isRoot());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    assertArrayEquals("null".getBytes("UTF-8"), actualRuleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#getId()}.
   *
   * <p>Method under test: {@link RuleChain#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChainId RuleChain.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new RuleChain().getId());
  }

  /**
   * Test {@link RuleChain#getCreatedTime()}.
   *
   * <p>Method under test: {@link RuleChain#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RuleChain.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new RuleChain().getCreatedTime());
  }

  /**
   * Test {@link RuleChain#getConfiguration()}.
   *
   * <p>Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode RuleChain.getConfiguration()"})
  void testGetConfiguration() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChain());

    // Act
    JsonNode actualConfiguration = ruleChain.getConfiguration();

    // Assert
    NullNode nullNode = ((NullNode) actualConfiguration).instance;
    assertSame(nullNode, ruleChain.getAdditionalInfo());
    assertSame(nullNode, actualConfiguration);
  }

  /**
   * Test {@link RuleChain#getConfiguration()}.
   *
   * <p>Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode RuleChain.getConfiguration()"})
  void testGetConfiguration2() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChain(new RuleChain()));

    // Act
    JsonNode actualConfiguration = ruleChain.getConfiguration();

    // Assert
    NullNode nullNode = ((NullNode) actualConfiguration).instance;
    assertSame(nullNode, ruleChain.getAdditionalInfo());
    assertSame(nullNode, actualConfiguration);
  }

  /**
   * Test {@link RuleChain#getConfiguration()}.
   *
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()} ConfigurationBytes is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  @DisplayName(
      "Test getConfiguration(); given RuleChain() ConfigurationBytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode RuleChain.getConfiguration()"})
  void testGetConfiguration_givenRuleChainConfigurationBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    JsonNode actualConfiguration = ruleChain.getConfiguration();

    // Assert
    assertNull(ruleChain.getAdditionalInfo());
    assertNull(actualConfiguration);
  }

  /**
   * Test {@link RuleChain#getConfiguration()}.
   *
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()}.
   *   <li>Then {@link RuleChain#RuleChain()} AdditionalInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  @DisplayName(
      "Test getConfiguration(); given RuleChain(); then RuleChain() AdditionalInfo is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode RuleChain.getConfiguration()"})
  void testGetConfiguration_givenRuleChain_thenRuleChainAdditionalInfoIsNull() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    // Act
    JsonNode actualConfiguration = ruleChain.getConfiguration();

    // Assert
    assertNull(ruleChain.getAdditionalInfo());
    assertNull(actualConfiguration);
  }

  /**
   * Test {@link RuleChain#getConfiguration()}.
   *
   * <ul>
   *   <li>Then return {@link MissingNode}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration(); then return MissingNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode RuleChain.getConfiguration()"})
  void testGetConfiguration_thenReturnMissingNode() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[] {});

    // Act
    JsonNode actualConfiguration = ruleChain.getConfiguration();

    // Assert
    assertTrue(actualConfiguration instanceof MissingNode);
    assertTrue(actualConfiguration.traverse() instanceof TreeTraversingParser);
    assertEquals("", actualConfiguration.toPrettyString());
    assertEquals(JsonNodeType.MISSING, actualConfiguration.getNodeType());
    assertFalse(actualConfiguration.isNull());
    assertFalse(actualConfiguration.isValueNode());
    assertTrue(actualConfiguration.isMissingNode());
  }

  /**
   * Test {@link RuleChain#setConfiguration(JsonNode)}.
   *
   * <p>Method under test: {@link RuleChain#setConfiguration(JsonNode)}
   */
  @Test
  @DisplayName("Test setConfiguration(JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChain.setConfiguration(JsonNode)"})
  void testSetConfiguration() throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode data = new ArrayNode(nf);
    data.addObject();

    // Act
    ruleChain.setConfiguration(data);

    // Assert
    assertSame(data, ruleChain.getConfiguration());
    assertArrayEquals("[{}]".getBytes("UTF-8"), ruleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#setConfiguration(JsonNode)}.
   *
   * <p>Method under test: {@link RuleChain#setConfiguration(JsonNode)}
   */
  @Test
  @DisplayName("Test setConfiguration(JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChain.setConfiguration(JsonNode)"})
  void testSetConfiguration2() throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode data = new ArrayNode(nf);
    data.addObject();
    data.addObject();

    // Act
    ruleChain.setConfiguration(data);

    // Assert
    assertSame(data, ruleChain.getConfiguration());
    assertArrayEquals("[{},{}]".getBytes("UTF-8"), ruleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#setConfiguration(JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then {@link RuleChain#RuleChain()} Configuration is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#setConfiguration(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test setConfiguration(JsonNode); when valueOf ten; then RuleChain() Configuration is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChain.setConfiguration(JsonNode)"})
  void testSetConfiguration_whenValueOfTen_thenRuleChainConfigurationIsValueOfTen()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act
    ruleChain.setConfiguration(data);

    // Assert
    assertSame(data, ruleChain.getConfiguration());
    assertArrayEquals("10.0".getBytes("UTF-8"), ruleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#isDefault()}.
   *
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()} Root is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#isDefault()}
   */
  @Test
  @DisplayName("Test isDefault(); given RuleChain() Root is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.isDefault()"})
  void testIsDefault_givenRuleChainRootIsTrue_thenReturnFalse() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setRoot(true);

    // Act and Assert
    assertFalse(ruleChain.isDefault());
  }

  /**
   * Test {@link RuleChain#isDefault()}.
   *
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()} Type is {@code CORE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#isDefault()}
   */
  @Test
  @DisplayName("Test isDefault(); given RuleChain() Type is 'CORE'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.isDefault()"})
  void testIsDefault_givenRuleChainTypeIsCore_thenReturnTrue() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setType(RuleChainType.CORE);
    ruleChain.setRoot(true);

    // Act and Assert
    assertTrue(ruleChain.isDefault());
  }

  /**
   * Test {@link RuleChain#isDefault()}.
   *
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChain#isDefault()}
   */
  @Test
  @DisplayName("Test isDefault(); given RuleChain(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChain.isDefault()"})
  void testIsDefault_givenRuleChain_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new RuleChain().isDefault());
  }
}
