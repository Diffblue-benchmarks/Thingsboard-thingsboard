package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeException.<init>(String, String, RuleNode)"})
  void testNewRuleNodeException() {
    // Arrange and Act
    RuleNodeException actualRuleNodeException =
        new RuleNodeException(null, "Rule Chain Name", null);

    // Assert
    RuleChainId ruleChainId = actualRuleNodeException.getRuleChainId();
    UUID id = ruleChainId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    RuleNodeId ruleNodeId = actualRuleNodeException.getRuleNodeId();
    assertEquals(EntityType.RULE_NODE, ruleNodeId.getEntityType());
    assertTrue(ruleChainId.isNullUid());
    assertTrue(ruleNodeId.isNullUid());
    assertEquals(RuleNodeException.UNKNOWN, actualRuleNodeException.getLocalizedMessage());
    assertEquals(RuleNodeException.UNKNOWN, actualRuleNodeException.getMessage());
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
  @Tag("MaintainedByDiffblue")
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
   * Test {@link RuleNodeException#toJsonString(int)}.
   *
   * <p>Method under test: {@link RuleNodeException#toJsonString(int)}
   */
  @Test
  @DisplayName("Test toJsonString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleNodeException.toJsonString(int)"})
  void testToJsonString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080-808080808080"
            + "\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"Rule Chain Name\",\"message\":\"An ...[truncated 14"
            + " symbols]\"}",
        new RuleNodeException("An error occurred", "Rule Chain Name", null).toJsonString(3));
  }

  /**
   * Test {@link RuleNodeException#toJsonString(int)}.
   *
   * <p>Method under test: {@link RuleNodeException#toJsonString(int)}
   */
  @Test
  @DisplayName("Test toJsonString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleNodeException.toJsonString(int)"})
  void testToJsonString2() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080-808080808080"
            + "\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"Rule Chain Name\",\"message\":\"42\"}",
        new RuleNodeException("42", "Rule Chain Name", null).toJsonString(3));
  }

  /**
   * Test {@link RuleNodeException#toJsonString(int)}.
   *
   * <p>Method under test: {@link RuleNodeException#toJsonString(int)}
   */
  @Test
  @DisplayName("Test toJsonString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleNodeException.toJsonString(int)"})
  void testToJsonString3() {
    // Arrange
    RuleNode ruleNode =
        new RuleNode(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleNode.setRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(
        "{\"ruleNodeId\":\"784f394c-42b6-435a-983c-b7beff2784f9\",\"ruleChainId\":\"784f394c-42b6-435a-983c"
            + "-b7beff2784f9\",\"ruleNodeName\":null,\"ruleChainName\":\"Rule Chain Name\",\"message\":\"An ...[truncated"
            + " 14 symbols]\"}",
        new RuleNodeException("An error occurred", "Rule Chain Name", ruleNode).toJsonString(3));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleNodeException.toJsonString(int)"})
  void testToJsonString_whenZero() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080-808080808080"
            + "\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"Rule Chain Name\",\"message\":\"An error occurred\"}",
        new RuleNodeException("An error occurred", "Rule Chain Name", null).toJsonString(0));
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
  @Tag("MaintainedByDiffblue")
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
