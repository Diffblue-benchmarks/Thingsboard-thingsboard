package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.rule.RuleNode;

class RuleNodeExceptionDiffblueTest {
  /**
   * Test {@link RuleNodeException#RuleNodeException(String, String, RuleNode)}.
   *
   * <p>Method under test: {@link RuleNodeException#RuleNodeException(String, String, RuleNode)}
   */
  @Test
  @DisplayName("Test new RuleNodeException(String, String, RuleNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeException.<init>(String, String, RuleNode)"})
  void testNewRuleNodeException() {
    // Arrange and Act
    RuleNodeException actualRuleNodeException =
        new RuleNodeException("An error occurred", "Rule Chain Name", null);

    // Assert
    RuleChainId ruleChainId = actualRuleNodeException.getRuleChainId();
    UUID id = ruleChainId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    RuleNodeId ruleNodeId = actualRuleNodeException.getRuleNodeId();
    assertEquals(EntityType.RULE_NODE, ruleNodeId.getEntityType());
    assertTrue(ruleChainId.isNullUid());
    assertTrue(ruleNodeId.isNullUid());
    assertEquals(RuleNodeException.UNKNOWN, actualRuleNodeException.getRuleNodeName());
    assertSame(id, ruleNodeId.getId());
  }

  /**
   * Test {@link RuleNodeException#RuleNodeException(String, String, RuleNode)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeException#RuleNodeException(String, String, RuleNode)}
   */
  @Test
  @DisplayName(
      "Test new RuleNodeException(String, String, RuleNode); then return LocalizedMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeException.<init>(String, String, RuleNode)"})
  void testNewRuleNodeException_thenReturnLocalizedMessageIsAnErrorOccurred() {
    // Arrange and Act
    RuleNodeException actualRuleNodeException =
        new RuleNodeException("An error occurred", "Rule Chain Name", new RuleNode());

    // Assert
    assertEquals("An error occurred", actualRuleNodeException.getLocalizedMessage());
    assertEquals("An error occurred", actualRuleNodeException.getMessage());
    assertNull(actualRuleNodeException.getRuleNodeName());
    assertNull(actualRuleNodeException.getRuleChainId());
    assertNull(actualRuleNodeException.getRuleNodeId());
  }

  /**
   * Test {@link RuleNodeException#RuleNodeException(String, String, RuleNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return LocalizedMessage is {@link RuleNodeException#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeException#RuleNodeException(String, String, RuleNode)}
   */
  @Test
  @DisplayName(
      "Test new RuleNodeException(String, String, RuleNode); when 'null'; then return LocalizedMessage is UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeException.<init>(String, String, RuleNode)"})
  void testNewRuleNodeException_whenNull_thenReturnLocalizedMessageIsUnknown() {
    // Arrange and Act
    RuleNodeException actualRuleNodeException =
        new RuleNodeException(null, "Rule Chain Name", new RuleNode());

    // Assert
    assertNull(actualRuleNodeException.getRuleNodeName());
    assertNull(actualRuleNodeException.getRuleChainId());
    assertNull(actualRuleNodeException.getRuleNodeId());
    assertEquals(RuleNodeException.UNKNOWN, actualRuleNodeException.getLocalizedMessage());
    assertEquals(RuleNodeException.UNKNOWN, actualRuleNodeException.getMessage());
  }

  /**
   * Test {@link RuleNodeException#toJsonString(int)}.
   *
   * <p>Method under test: {@link RuleNodeException#toJsonString(int)}
   */
  @Test
  @DisplayName("Test toJsonString(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleNodeException.toJsonString(int)"})
  void testToJsonString() {
    // Arrange
    RuleNodeException ruleNodeException =
        new RuleNodeException("An error occurred", "Rule Chain Name", null);

    // Act and Assert
    assertEquals(
        "{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080-808080808080"
            + "\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"Rule Chain Name\",\"message\":\"An ...[truncated 14"
            + " symbols]\"}",
        ruleNodeException.toJsonString(3));
  }

  /**
   * Test {@link RuleNodeException#toJsonString(int)}.
   *
   * <p>Method under test: {@link RuleNodeException#toJsonString(int)}
   */
  @Test
  @DisplayName("Test toJsonString(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleNodeException.toJsonString(int)"})
  void testToJsonString2() {
    // Arrange
    RuleNodeException ruleNodeException =
        new RuleNodeException(
            "An error occurred", "org.thingsboard.server.common.msg.queue.RuleNodeException", null);

    // Act and Assert
    assertEquals(
        "{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080-808080808080"
            + "\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"org.thingsboard.server.common.msg.queue.RuleNodeException"
            + "\",\"message\":\"An ...[truncated 14 symbols]\"}",
        ruleNodeException.toJsonString(3));
  }

  /**
   * Test {@link RuleNodeException#toJsonString(int)}.
   *
   * <p>Method under test: {@link RuleNodeException#toJsonString(int)}
   */
  @Test
  @DisplayName("Test toJsonString(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleNodeException.toJsonString(int)"})
  void testToJsonString3() {
    // Arrange
    RuleNodeException ruleNodeException = new RuleNodeException("42", "Rule Chain Name", null);

    // Act and Assert
    assertEquals(
        "{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080-808080808080"
            + "\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"Rule Chain Name\",\"message\":\"42\"}",
        ruleNodeException.toJsonString(3));
  }

  /**
   * Test {@link RuleNodeException#toJsonString(int)}.
   *
   * <p>Method under test: {@link RuleNodeException#toJsonString(int)}
   */
  @Test
  @DisplayName("Test toJsonString(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleNodeException.toJsonString(int)"})
  void testToJsonString4() {
    // Arrange
    RuleNodeId id = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNode ruleNode = new RuleNode(id);
    ruleNode.setRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleNodeException ruleNodeException =
        new RuleNodeException("An error occurred", "Rule Chain Name", ruleNode);

    // Act and Assert
    assertEquals(
        "{\"ruleNodeId\":\"784f394c-42b6-435a-983c-b7beff2784f9\",\"ruleChainId\":\"784f394c-42b6-435a-983c"
            + "-b7beff2784f9\",\"ruleNodeName\":null,\"ruleChainName\":\"Rule Chain Name\",\"message\":\"An ...[truncated"
            + " 14 symbols]\"}",
        ruleNodeException.toJsonString(3));
  }

  /**
   * Test {@link RuleNodeException#toJsonString(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeException#toJsonString(int)}
   */
  @Test
  @DisplayName("Test toJsonString(int); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleNodeException.toJsonString(int)"})
  void testToJsonString_whenZero() {
    // Arrange
    RuleNodeException ruleNodeException =
        new RuleNodeException("An error occurred", "Rule Chain Name", null);

    // Act and Assert
    assertEquals(
        "{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080-808080808080"
            + "\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"Rule Chain Name\",\"message\":\"An error occurred\"}",
        ruleNodeException.toJsonString(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeException#getRuleChainId()}
   *   <li>{@link RuleNodeException#getRuleChainName()}
   *   <li>{@link RuleNodeException#getRuleNodeId()}
   *   <li>{@link RuleNodeException#getRuleNodeName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainId RuleNodeException.getRuleChainId()",
    "String RuleNodeException.getRuleChainName()",
    "RuleNodeId RuleNodeException.getRuleNodeId()",
    "String RuleNodeException.getRuleNodeName()"
  })
  void testGettersAndSetters() {
    // Arrange
    RuleNodeException ruleNodeException =
        new RuleNodeException("An error occurred", "Rule Chain Name", new RuleNode());

    // Act
    RuleChainId actualRuleChainId = ruleNodeException.getRuleChainId();
    String actualRuleChainName = ruleNodeException.getRuleChainName();
    RuleNodeId actualRuleNodeId = ruleNodeException.getRuleNodeId();

    // Assert
    assertEquals("Rule Chain Name", actualRuleChainName);
    assertNull(ruleNodeException.getRuleNodeName());
    assertNull(actualRuleChainId);
    assertNull(actualRuleNodeId);
  }
}
