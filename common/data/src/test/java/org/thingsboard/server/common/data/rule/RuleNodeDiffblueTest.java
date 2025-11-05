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
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;

class RuleNodeDiffblueTest {
  /**
   * Test {@link RuleNode#equals(Object)}, and {@link RuleNode#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNode#equals(Object)}
   *   <li>{@link RuleNode#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    RuleNode ruleNode2 = new RuleNode();

    // Act and Assert
    assertEquals(ruleNode, ruleNode2);
    assertEquals(ruleNode.hashCode(), ruleNode2.hashCode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}, and {@link RuleNode#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNode#equals(Object)}
   *   <li>{@link RuleNode#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    // Act and Assert
    assertEquals(ruleNode, ruleNode);
    int expectedHashCodeResult = ruleNode.hashCode();
    assertEquals(expectedHashCodeResult, ruleNode.hashCode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeId id = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNode ruleNode = new RuleNode(id);

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setType("Type");

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setName("Name");

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setSingletonMode(true);

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setQueueName("Queue Name");

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationVersion(1);

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setExternalId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setName("Name");

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setQueueName("Queue Name");

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setExternalId(
        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleNode(), null);
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNode.equals(Object)", "int RuleNode.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleNode(), "Different type to RuleNode");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNode#RuleNode(RuleNodeId)}
   *   <li>{@link RuleNode#setConfigurationBytes(byte[])}
   *   <li>{@link RuleNode#setConfigurationVersion(int)}
   *   <li>{@link RuleNode#setDebugMode(boolean)}
   *   <li>{@link RuleNode#setExternalId(RuleNodeId)}
   *   <li>{@link RuleNode#setName(String)}
   *   <li>{@link RuleNode#setQueueName(String)}
   *   <li>{@link RuleNode#setRuleChainId(RuleChainId)}
   *   <li>{@link RuleNode#setSingletonMode(boolean)}
   *   <li>{@link RuleNode#setType(String)}
   *   <li>{@link RuleNode#toString()}
   *   <li>{@link RuleNode#getConfigurationBytes()}
   *   <li>{@link RuleNode#getConfigurationVersion()}
   *   <li>{@link RuleNode#getExternalId()}
   *   <li>{@link RuleNode#getName()}
   *   <li>{@link RuleNode#getQueueName()}
   *   <li>{@link RuleNode#getRuleChainId()}
   *   <li>{@link RuleNode#getType()}
   *   <li>{@link RuleNode#isDebugMode()}
   *   <li>{@link RuleNode#isSingletonMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleNode.<init>()",
    "void RuleNode.<init>(RuleNodeId)",
    "byte[] RuleNode.getConfigurationBytes()",
    "int RuleNode.getConfigurationVersion()",
    "RuleNodeId RuleNode.getExternalId()",
    "String RuleNode.getName()",
    "String RuleNode.getQueueName()",
    "RuleChainId RuleNode.getRuleChainId()",
    "String RuleNode.getType()",
    "boolean RuleNode.isDebugMode()",
    "boolean RuleNode.isSingletonMode()",
    "void RuleNode.setConfigurationBytes(byte[])",
    "void RuleNode.setConfigurationVersion(int)",
    "void RuleNode.setDebugMode(boolean)",
    "void RuleNode.setExternalId(RuleNodeId)",
    "void RuleNode.setName(String)",
    "void RuleNode.setQueueName(String)",
    "void RuleNode.setRuleChainId(RuleChainId)",
    "void RuleNode.setSingletonMode(boolean)",
    "void RuleNode.setType(String)",
    "String RuleNode.toString()"
  })
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    RuleNodeId id = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    RuleNode actualRuleNode = new RuleNode(id);
    byte[] configurationBytes = "AXAXAXAX".getBytes("UTF-8");
    actualRuleNode.setConfigurationBytes(configurationBytes);
    actualRuleNode.setConfigurationVersion(1);
    actualRuleNode.setDebugMode(true);
    RuleNodeId externalId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleNode.setExternalId(externalId);
    actualRuleNode.setName("Name");
    actualRuleNode.setQueueName("Queue Name");
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleNode.setRuleChainId(ruleChainId);
    actualRuleNode.setSingletonMode(true);
    actualRuleNode.setType("Type");
    String actualToStringResult = actualRuleNode.toString();
    byte[] actualConfigurationBytes = actualRuleNode.getConfigurationBytes();
    int actualConfigurationVersion = actualRuleNode.getConfigurationVersion();
    RuleNodeId actualExternalId = actualRuleNode.getExternalId();
    String actualName = actualRuleNode.getName();
    String actualQueueName = actualRuleNode.getQueueName();
    RuleChainId actualRuleChainId = actualRuleNode.getRuleChainId();
    String actualType = actualRuleNode.getType();
    boolean actualIsDebugModeResult = actualRuleNode.isDebugMode();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Queue Name", actualQueueName);
    assertEquals(
        "RuleNode(ruleChainId=784f394c-42b6-435a-983c-b7beff2784f9, type=Type, name=Name, debugMode=true,"
            + " singletonMode=true, queueName=Queue Name, configurationVersion=1, configuration=null, configurationBytes"
            + "=[65, 88, 65, 88, 65, 88, 65, 88], externalId=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertEquals(1, actualConfigurationVersion);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualRuleNode.isSingletonMode());
    assertSame(ruleChainId, actualRuleChainId);
    assertSame(externalId, actualExternalId);
    assertSame(id, actualRuleNode.getId());
    assertSame(configurationBytes, actualConfigurationBytes);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualConfigurationBytes);
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
   *   <li>{@link RuleNode#RuleNode()}
   *   <li>{@link RuleNode#setConfigurationBytes(byte[])}
   *   <li>{@link RuleNode#setConfigurationVersion(int)}
   *   <li>{@link RuleNode#setDebugMode(boolean)}
   *   <li>{@link RuleNode#setExternalId(RuleNodeId)}
   *   <li>{@link RuleNode#setName(String)}
   *   <li>{@link RuleNode#setQueueName(String)}
   *   <li>{@link RuleNode#setRuleChainId(RuleChainId)}
   *   <li>{@link RuleNode#setSingletonMode(boolean)}
   *   <li>{@link RuleNode#setType(String)}
   *   <li>{@link RuleNode#toString()}
   *   <li>{@link RuleNode#getConfigurationBytes()}
   *   <li>{@link RuleNode#getConfigurationVersion()}
   *   <li>{@link RuleNode#getExternalId()}
   *   <li>{@link RuleNode#getName()}
   *   <li>{@link RuleNode#getQueueName()}
   *   <li>{@link RuleNode#getRuleChainId()}
   *   <li>{@link RuleNode#getType()}
   *   <li>{@link RuleNode#isDebugMode()}
   *   <li>{@link RuleNode#isSingletonMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleNode.<init>()",
    "void RuleNode.<init>(RuleNodeId)",
    "byte[] RuleNode.getConfigurationBytes()",
    "int RuleNode.getConfigurationVersion()",
    "RuleNodeId RuleNode.getExternalId()",
    "String RuleNode.getName()",
    "String RuleNode.getQueueName()",
    "RuleChainId RuleNode.getRuleChainId()",
    "String RuleNode.getType()",
    "boolean RuleNode.isDebugMode()",
    "boolean RuleNode.isSingletonMode()",
    "void RuleNode.setConfigurationBytes(byte[])",
    "void RuleNode.setConfigurationVersion(int)",
    "void RuleNode.setDebugMode(boolean)",
    "void RuleNode.setExternalId(RuleNodeId)",
    "void RuleNode.setName(String)",
    "void RuleNode.setQueueName(String)",
    "void RuleNode.setRuleChainId(RuleChainId)",
    "void RuleNode.setSingletonMode(boolean)",
    "void RuleNode.setType(String)",
    "String RuleNode.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsNull() throws UnsupportedEncodingException {
    // Arrange and Act
    RuleNode actualRuleNode = new RuleNode();
    byte[] configurationBytes = "AXAXAXAX".getBytes("UTF-8");
    actualRuleNode.setConfigurationBytes(configurationBytes);
    actualRuleNode.setConfigurationVersion(1);
    actualRuleNode.setDebugMode(true);
    RuleNodeId externalId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleNode.setExternalId(externalId);
    actualRuleNode.setName("Name");
    actualRuleNode.setQueueName("Queue Name");
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleNode.setRuleChainId(ruleChainId);
    actualRuleNode.setSingletonMode(true);
    actualRuleNode.setType("Type");
    String actualToStringResult = actualRuleNode.toString();
    byte[] actualConfigurationBytes = actualRuleNode.getConfigurationBytes();
    int actualConfigurationVersion = actualRuleNode.getConfigurationVersion();
    RuleNodeId actualExternalId = actualRuleNode.getExternalId();
    String actualName = actualRuleNode.getName();
    String actualQueueName = actualRuleNode.getQueueName();
    RuleChainId actualRuleChainId = actualRuleNode.getRuleChainId();
    String actualType = actualRuleNode.getType();
    boolean actualIsDebugModeResult = actualRuleNode.isDebugMode();
    boolean actualIsSingletonModeResult = actualRuleNode.isSingletonMode();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Queue Name", actualQueueName);
    assertEquals(
        "RuleNode(ruleChainId=784f394c-42b6-435a-983c-b7beff2784f9, type=Type, name=Name, debugMode=true,"
            + " singletonMode=true, queueName=Queue Name, configurationVersion=1, configuration=null, configurationBytes"
            + "=[65, 88, 65, 88, 65, 88, 65, 88], externalId=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertNull(actualRuleNode.getId());
    assertEquals(1, actualConfigurationVersion);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsSingletonModeResult);
    assertSame(ruleChainId, actualRuleChainId);
    assertSame(externalId, actualExternalId);
    assertSame(configurationBytes, actualConfigurationBytes);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualConfigurationBytes);
  }

  /**
   * Test {@link RuleNode#RuleNode(RuleNode)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link RuleNode#RuleNode()} ConfigurationBytes is array of {@code byte} with {@code
   *       A} and three.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  @DisplayName(
      "Test new RuleNode(RuleNode); given 'A'; when RuleNode() ConfigurationBytes is array of byte with 'A' and three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNode.<init>(RuleNode)"})
  void testNewRuleNode_givenA_whenRuleNodeConfigurationBytesIsArrayOfByteWithAAndThree()
      throws UnsupportedEncodingException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    RuleNode actualRuleNode = new RuleNode(ruleNode);

    // Assert
    JsonNode additionalInfo = actualRuleNode.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(actualRuleNode.isDebugMode());
    assertSame(additionalInfo, actualRuleNode.getConfiguration());
    assertArrayEquals("null".getBytes("UTF-8"), actualRuleNode.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNode#RuleNode(RuleNode)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   *   <li>Then Configuration return {@link MissingNode}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  @DisplayName(
      "Test new RuleNode(RuleNode); given empty array of byte; then Configuration return MissingNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNode.<init>(RuleNode)"})
  void testNewRuleNode_givenEmptyArrayOfByte_thenConfigurationReturnMissingNode()
      throws UnsupportedEncodingException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[] {});

    // Act
    RuleNode actualRuleNode = new RuleNode(ruleNode);

    // Assert
    assertTrue(actualRuleNode.getConfiguration() instanceof MissingNode);
    assertArrayEquals("null".getBytes("UTF-8"), actualRuleNode.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNode#RuleNode(RuleNode)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link RuleNode#RuleNode()} DebugMode is {@code true}.
   *   <li>Then return DebugMode.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  @DisplayName(
      "Test new RuleNode(RuleNode); given 'true'; when RuleNode() DebugMode is 'true'; then return DebugMode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNode.<init>(RuleNode)"})
  void testNewRuleNode_givenTrue_whenRuleNodeDebugModeIsTrue_thenReturnDebugMode()
      throws UnsupportedEncodingException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);

    // Act
    RuleNode actualRuleNode = new RuleNode(ruleNode);

    // Assert
    JsonNode additionalInfo = actualRuleNode.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertTrue(actualRuleNode.isDebugMode());
    assertSame(additionalInfo, actualRuleNode.getConfiguration());
    assertArrayEquals("null".getBytes("UTF-8"), actualRuleNode.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNode#RuleNode(RuleNode)}.
   *
   * <ul>
   *   <li>When {@link RuleNode#RuleNode(RuleNode)} with ruleNode is {@link RuleNode#RuleNode()}.
   *   <li>Then return not DebugMode.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  @DisplayName(
      "Test new RuleNode(RuleNode); when RuleNode(RuleNode) with ruleNode is RuleNode(); then return not DebugMode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNode.<init>(RuleNode)"})
  void testNewRuleNode_whenRuleNodeWithRuleNodeIsRuleNode_thenReturnNotDebugMode()
      throws UnsupportedEncodingException {
    // Arrange and Act
    RuleNode actualRuleNode = new RuleNode(new RuleNode(new RuleNode()));

    // Assert
    JsonNode additionalInfo = actualRuleNode.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(actualRuleNode.isDebugMode());
    assertSame(additionalInfo, actualRuleNode.getConfiguration());
    assertArrayEquals("null".getBytes("UTF-8"), actualRuleNode.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNode#RuleNode(RuleNode)}.
   *
   * <ul>
   *   <li>When {@link RuleNode#RuleNode(RuleNode)} with ruleNode is {@link
   *       RuleNode#RuleNode(RuleNode)}.
   *   <li>Then return not DebugMode.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  @DisplayName(
      "Test new RuleNode(RuleNode); when RuleNode(RuleNode) with ruleNode is RuleNode(RuleNode); then return not DebugMode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNode.<init>(RuleNode)"})
  void testNewRuleNode_whenRuleNodeWithRuleNodeIsRuleNode_thenReturnNotDebugMode2()
      throws UnsupportedEncodingException {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode(new RuleNode()));

    // Act
    RuleNode actualRuleNode = new RuleNode(ruleNode);

    // Assert
    JsonNode additionalInfo = actualRuleNode.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(actualRuleNode.isDebugMode());
    assertSame(additionalInfo, actualRuleNode.getConfiguration());
    assertArrayEquals("null".getBytes("UTF-8"), actualRuleNode.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNode#RuleNode(RuleNode)}.
   *
   * <ul>
   *   <li>When {@link RuleNode#RuleNode()}.
   *   <li>Then return not DebugMode.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  @DisplayName("Test new RuleNode(RuleNode); when RuleNode(); then return not DebugMode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNode.<init>(RuleNode)"})
  void testNewRuleNode_whenRuleNode_thenReturnNotDebugMode() throws UnsupportedEncodingException {
    // Arrange and Act
    RuleNode actualRuleNode = new RuleNode(new RuleNode());

    // Assert
    JsonNode additionalInfo = actualRuleNode.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(actualRuleNode.isDebugMode());
    assertSame(additionalInfo, actualRuleNode.getConfiguration());
    assertArrayEquals("null".getBytes("UTF-8"), actualRuleNode.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNode#getConfiguration()}.
   *
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()} ConfigurationBytes is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  @DisplayName(
      "Test getConfiguration(); given RuleNode() ConfigurationBytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode RuleNode.getConfiguration()"})
  void testGetConfiguration_givenRuleNodeConfigurationBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    JsonNode actualConfiguration = ruleNode.getConfiguration();

    // Assert
    assertNull(ruleNode.getAdditionalInfo());
    assertNull(actualConfiguration);
  }

  /**
   * Test {@link RuleNode#getConfiguration()}.
   *
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()}.
   *   <li>Then {@link RuleNode#RuleNode()} AdditionalInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  @DisplayName(
      "Test getConfiguration(); given RuleNode(); then RuleNode() AdditionalInfo is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode RuleNode.getConfiguration()"})
  void testGetConfiguration_givenRuleNode_thenRuleNodeAdditionalInfoIsNull() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    // Act
    JsonNode actualConfiguration = ruleNode.getConfiguration();

    // Assert
    assertNull(ruleNode.getAdditionalInfo());
    assertNull(actualConfiguration);
  }

  /**
   * Test {@link RuleNode#getConfiguration()}.
   *
   * <ul>
   *   <li>Then return {@link MissingNode}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration(); then return MissingNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode RuleNode.getConfiguration()"})
  void testGetConfiguration_thenReturnMissingNode() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[] {});

    // Act
    JsonNode actualConfiguration = ruleNode.getConfiguration();

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
   * Test {@link RuleNode#getConfiguration()}.
   *
   * <ul>
   *   <li>Then {@link RuleNode#RuleNode(RuleNode)} with ruleNode is {@link RuleNode#RuleNode()}
   *       AdditionalInfo is {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  @DisplayName(
      "Test getConfiguration(); then RuleNode(RuleNode) with ruleNode is RuleNode() AdditionalInfo is instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode RuleNode.getConfiguration()"})
  void testGetConfiguration_thenRuleNodeWithRuleNodeIsRuleNodeAdditionalInfoIsInstance() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode());

    // Act
    JsonNode actualConfiguration = ruleNode.getConfiguration();

    // Assert
    NullNode nullNode = ((NullNode) actualConfiguration).instance;
    assertSame(nullNode, ruleNode.getAdditionalInfo());
    assertSame(nullNode, actualConfiguration);
  }

  /**
   * Test {@link RuleNode#getConfiguration()}.
   *
   * <ul>
   *   <li>Then {@link RuleNode#RuleNode(RuleNode)} with ruleNode is {@link
   *       RuleNode#RuleNode(RuleNode)} AdditionalInfo is {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  @DisplayName(
      "Test getConfiguration(); then RuleNode(RuleNode) with ruleNode is RuleNode(RuleNode) AdditionalInfo is instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode RuleNode.getConfiguration()"})
  void testGetConfiguration_thenRuleNodeWithRuleNodeIsRuleNodeAdditionalInfoIsInstance2() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode(new RuleNode()));

    // Act
    JsonNode actualConfiguration = ruleNode.getConfiguration();

    // Assert
    NullNode nullNode = ((NullNode) actualConfiguration).instance;
    assertSame(nullNode, ruleNode.getAdditionalInfo());
    assertSame(nullNode, actualConfiguration);
  }

  /**
   * Test {@link RuleNode#setConfiguration(JsonNode)}.
   *
   * <p>Method under test: {@link RuleNode#setConfiguration(JsonNode)}
   */
  @Test
  @DisplayName("Test setConfiguration(JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNode.setConfiguration(JsonNode)"})
  void testSetConfiguration() throws UnsupportedEncodingException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode data = new ArrayNode(nf);
    data.addObject();

    // Act
    ruleNode.setConfiguration(data);

    // Assert
    assertSame(data, ruleNode.getConfiguration());
    assertArrayEquals("[{}]".getBytes("UTF-8"), ruleNode.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNode#setConfiguration(JsonNode)}.
   *
   * <p>Method under test: {@link RuleNode#setConfiguration(JsonNode)}
   */
  @Test
  @DisplayName("Test setConfiguration(JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNode.setConfiguration(JsonNode)"})
  void testSetConfiguration2() throws UnsupportedEncodingException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode data = new ArrayNode(nf);
    data.addObject();
    data.addObject();

    // Act
    ruleNode.setConfiguration(data);

    // Assert
    assertSame(data, ruleNode.getConfiguration());
    assertArrayEquals("[{},{}]".getBytes("UTF-8"), ruleNode.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNode#setConfiguration(JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then {@link RuleNode#RuleNode()} Configuration is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#setConfiguration(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test setConfiguration(JsonNode); when valueOf ten; then RuleNode() Configuration is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNode.setConfiguration(JsonNode)"})
  void testSetConfiguration_whenValueOfTen_thenRuleNodeConfigurationIsValueOfTen()
      throws UnsupportedEncodingException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act
    ruleNode.setConfiguration(data);

    // Assert
    assertSame(data, ruleNode.getConfiguration());
    assertArrayEquals("10.0".getBytes("UTF-8"), ruleNode.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNode#getId()}.
   *
   * <p>Method under test: {@link RuleNode#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeId RuleNode.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new RuleNode().getId());
  }

  /**
   * Test {@link RuleNode#getCreatedTime()}.
   *
   * <p>Method under test: {@link RuleNode#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RuleNode.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new RuleNode().getCreatedTime());
  }

  /**
   * Test {@link RuleNode#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given RuleNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode RuleNode.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenRuleNode_thenReturnNull() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    // Act and Assert
    assertNull(ruleNode.getAdditionalInfo());
    assertNull(ruleNode.getConfiguration());
  }

  /**
   * Test {@link RuleNode#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Then {@link RuleNode#RuleNode(RuleNode)} with ruleNode is {@link RuleNode#RuleNode()}
   *       Configuration is {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#getAdditionalInfo()}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfo(); then RuleNode(RuleNode) with ruleNode is RuleNode() Configuration is instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode RuleNode.getAdditionalInfo()"})
  void testGetAdditionalInfo_thenRuleNodeWithRuleNodeIsRuleNodeConfigurationIsInstance() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode());

    // Act
    JsonNode actualAdditionalInfo = ruleNode.getAdditionalInfo();

    // Assert
    NullNode nullNode = ((NullNode) actualAdditionalInfo).instance;
    assertSame(nullNode, actualAdditionalInfo);
    assertSame(nullNode, ruleNode.getConfiguration());
  }

  /**
   * Test {@link RuleNode#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Then {@link RuleNode#RuleNode(RuleNode)} with ruleNode is {@link
   *       RuleNode#RuleNode(RuleNode)} Configuration is {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNode#getAdditionalInfo()}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfo(); then RuleNode(RuleNode) with ruleNode is RuleNode(RuleNode) Configuration is instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode RuleNode.getAdditionalInfo()"})
  void testGetAdditionalInfo_thenRuleNodeWithRuleNodeIsRuleNodeConfigurationIsInstance2() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode(new RuleNode()));

    // Act
    JsonNode actualAdditionalInfo = ruleNode.getAdditionalInfo();

    // Assert
    NullNode nullNode = ((NullNode) actualAdditionalInfo).instance;
    assertSame(nullNode, actualAdditionalInfo);
    assertSame(nullNode, ruleNode.getConfiguration());
  }
}
