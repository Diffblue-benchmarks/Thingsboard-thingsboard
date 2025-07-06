package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.rule.RuleNode;

class RuleEngineExceptionDiffblueTest {
  /**
   * Test {@link RuleEngineException#RuleEngineException(String)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineException#RuleEngineException(String)}
   */
  @Test
  @DisplayName(
      "Test new RuleEngineException(String); then return LocalizedMessage is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleEngineException.<init>(String)"})
  void testNewRuleEngineException_thenReturnLocalizedMessageIsAnErrorOccurred() {
    // Arrange and Act
    RuleEngineException actualRuleEngineException = new RuleEngineException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualRuleEngineException.getLocalizedMessage());
    assertEquals("An error occurred", actualRuleEngineException.getMessage());
    assertNull(actualRuleEngineException.getCause());
    assertEquals(0, actualRuleEngineException.getSuppressed().length);
  }

  /**
   * Test {@link RuleEngineException#RuleEngineException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineException#RuleEngineException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new RuleEngineException(String, Throwable); then return LocalizedMessage is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleEngineException.<init>(String, Throwable)"})
  void testNewRuleEngineException_thenReturnLocalizedMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable t = new Throwable();

    // Act
    RuleEngineException actualRuleEngineException = new RuleEngineException("An error occurred", t);

    // Assert
    assertEquals("An error occurred", actualRuleEngineException.getLocalizedMessage());
    assertEquals("An error occurred", actualRuleEngineException.getMessage());
    assertEquals(0, actualRuleEngineException.getSuppressed().length);
    assertSame(t, actualRuleEngineException.getCause());
  }

  /**
   * Test {@link RuleEngineException#RuleEngineException(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return LocalizedMessage is {@link RuleNodeException#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineException#RuleEngineException(String)}
   */
  @Test
  @DisplayName(
      "Test new RuleEngineException(String); when 'null'; then return LocalizedMessage is UNKNOWN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleEngineException.<init>(String)"})
  void testNewRuleEngineException_whenNull_thenReturnLocalizedMessageIsUnknown() {
    // Arrange and Act
    RuleEngineException actualRuleEngineException = new RuleEngineException(null);

    // Assert
    assertNull(actualRuleEngineException.getCause());
    assertEquals(0, actualRuleEngineException.getSuppressed().length);
    assertEquals(RuleNodeException.UNKNOWN, actualRuleEngineException.getLocalizedMessage());
    assertEquals(RuleNodeException.UNKNOWN, actualRuleEngineException.getMessage());
  }

  /**
   * Test {@link RuleEngineException#RuleEngineException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return LocalizedMessage is {@link RuleNodeException#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineException#RuleEngineException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new RuleEngineException(String, Throwable); when 'null'; then return LocalizedMessage is UNKNOWN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleEngineException.<init>(String, Throwable)"})
  void testNewRuleEngineException_whenNull_thenReturnLocalizedMessageIsUnknown2() {
    // Arrange
    Throwable t = new Throwable();

    // Act
    RuleEngineException actualRuleEngineException = new RuleEngineException(null, t);

    // Assert
    assertEquals(0, actualRuleEngineException.getSuppressed().length);
    assertEquals(RuleNodeException.UNKNOWN, actualRuleEngineException.getLocalizedMessage());
    assertEquals(RuleNodeException.UNKNOWN, actualRuleEngineException.getMessage());
    assertSame(t, actualRuleEngineException.getCause());
  }

  /**
   * Test {@link RuleEngineException#toJsonString(int)}.
   *
   * <p>Method under test: {@link RuleEngineException#toJsonString(int)}
   */
  @Test
  @DisplayName("Test toJsonString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleEngineException.toJsonString(int)"})
  void testToJsonString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080-808080808080"
            + "\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"message\",\"message\":\"An ...[truncated 14 symbols]\"}",
        new RuleNodeException("An error occurred", "message", null).toJsonString(3));
  }

  /**
   * Test {@link RuleEngineException#toJsonString(int)}.
   *
   * <p>Method under test: {@link RuleEngineException#toJsonString(int)}
   */
  @Test
  @DisplayName("Test toJsonString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleEngineException.toJsonString(int)"})
  void testToJsonString2() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080"
            + "-808080808080\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"ruleNodeId\",\"message\":\"An ...[truncated"
            + " 14 symbols]\"}",
        new RuleNodeException("An error occurred", "ruleNodeId", null).toJsonString(3));
  }

  /**
   * Test {@link RuleEngineException#toJsonString(int)}.
   *
   * <p>Method under test: {@link RuleEngineException#toJsonString(int)}
   */
  @Test
  @DisplayName("Test toJsonString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleEngineException.toJsonString(int)"})
  void testToJsonString3() {
    // Arrange
    RuleNode ruleNode =
        new RuleNode(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleNode.setRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(
        "{\"ruleNodeId\":\"784f394c-42b6-435a-983c-b7beff2784f9\",\"ruleChainId\":\"784f394c-42b6-435a-983c-b7beff2784f9"
            + "\",\"ruleNodeName\":null,\"ruleChainName\":\"message\",\"message\":\"An ...[truncated 14 symbols]\"}",
        new RuleNodeException("An error occurred", "message", ruleNode).toJsonString(3));
  }

  /**
   * Test {@link RuleEngineException#toJsonString(int)}.
   *
   * <ul>
   *   <li>Given {@link RuleEngineException#RuleEngineException(String)} with message is {@code 42}.
   *   <li>Then return {@code {"message":"42"}}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineException#toJsonString(int)}
   */
  @Test
  @DisplayName(
      "Test toJsonString(int); given RuleEngineException(String) with message is '42'; then return '{\"message\":\"42\"}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleEngineException.toJsonString(int)"})
  void testToJsonString_givenRuleEngineExceptionWithMessageIs42_thenReturnMessage42() {
    // Arrange, Act and Assert
    assertEquals("{\"message\":\"42\"}", new RuleEngineException("42").toJsonString(3));
  }

  /**
   * Test {@link RuleEngineException#toJsonString(int)}.
   *
   * <ul>
   *   <li>Then return {@code {"message":"An ...[truncated 14 symbols]"}}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineException#toJsonString(int)}
   */
  @Test
  @DisplayName(
      "Test toJsonString(int); then return '{\"message\":\"An ...[truncated 14 symbols]\"}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleEngineException.toJsonString(int)"})
  void testToJsonString_thenReturnMessageAnTruncated14Symbols() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"message\":\"An ...[truncated 14 symbols]\"}",
        new RuleEngineException("An error occurred").toJsonString(3));
  }

  /**
   * Test {@link RuleEngineException#toJsonString(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code {"message":"An error occurred"}}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineException#toJsonString(int)}
   */
  @Test
  @DisplayName(
      "Test toJsonString(int); when zero; then return '{\"message\":\"An error occurred\"}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleEngineException.toJsonString(int)"})
  void testToJsonString_whenZero_thenReturnMessageAnErrorOccurred() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"message\":\"An error occurred\"}",
        new RuleEngineException("An error occurred").toJsonString(0));
  }

  /**
   * Test {@link RuleEngineException#truncateIfNecessary(String, int)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineException#truncateIfNecessary(String, int)}
   */
  @Test
  @DisplayName("Test truncateIfNecessary(String, int); when '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleEngineException.truncateIfNecessary(String, int)"})
  void testTruncateIfNecessary_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", new RuleEngineException("An error occurred").truncateIfNecessary("42", 3));
  }

  /**
   * Test {@link RuleEngineException#truncateIfNecessary(String, int)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineException#truncateIfNecessary(String, int)}
   */
  @Test
  @DisplayName(
      "Test truncateIfNecessary(String, int); when 'An error occurred'; then return 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleEngineException.truncateIfNecessary(String, int)"})
  void testTruncateIfNecessary_whenAnErrorOccurred_thenReturnAnErrorOccurred() {
    // Arrange, Act and Assert
    assertEquals(
        "An error occurred",
        new RuleEngineException("An error occurred").truncateIfNecessary("An error occurred", 0));
  }

  /**
   * Test {@link RuleEngineException#truncateIfNecessary(String, int)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return {@code An ...[truncated 14 symbols]}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineException#truncateIfNecessary(String, int)}
   */
  @Test
  @DisplayName(
      "Test truncateIfNecessary(String, int); when 'An error occurred'; then return 'An ...[truncated 14 symbols]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleEngineException.truncateIfNecessary(String, int)"})
  void testTruncateIfNecessary_whenAnErrorOccurred_thenReturnAnTruncated14Symbols() {
    // Arrange, Act and Assert
    assertEquals(
        "An ...[truncated 14 symbols]",
        new RuleEngineException("An error occurred").truncateIfNecessary("An error occurred", 3));
  }

  /**
   * Test {@link RuleEngineException#truncateIfNecessary(String, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineException#truncateIfNecessary(String, int)}
   */
  @Test
  @DisplayName("Test truncateIfNecessary(String, int); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleEngineException.truncateIfNecessary(String, int)"})
  void testTruncateIfNecessary_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new RuleEngineException("An error occurred").truncateIfNecessary(null, 0));
  }
}
