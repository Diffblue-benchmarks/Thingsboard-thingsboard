package org.thingsboard.server.queue.rabbitmq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbRabbitMqQueueArgumentsDiffblueTest {
  /**
   * Test {@link TbRabbitMqQueueArguments#getArgs(String)}.
   *
   * <ul>
   *   <li>When {@code :42}.
   *   <li>Then return empty string longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  @DisplayName("Test getArgs(String); when ':42'; then return empty string longValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbRabbitMqQueueArguments.getArgs(String)"})
  void testGetArgs_when42_thenReturnEmptyStringLongValueIsFortyTwo() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(":42");

    // Assert
    assertEquals(1, actualArgs.size());
    assertEquals(42L, ((Long) actualArgs.get("")).longValue());
  }

  /**
   * Test {@link TbRabbitMqQueueArguments#getArgs(String)}.
   *
   * <ul>
   *   <li>When {@code :}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  @DisplayName("Test getArgs(String); when ':'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbRabbitMqQueueArguments.getArgs(String)"})
  void testGetArgs_whenColon_thenReturnEmptyString() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(":");

    // Assert
    assertEquals(1, actualArgs.size());
    assertEquals("", actualArgs.get(""));
  }

  /**
   * Test {@link TbRabbitMqQueueArguments#getArgs(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  @DisplayName("Test getArgs(String); when empty string; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbRabbitMqQueueArguments.getArgs(String)"})
  void testGetArgs_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs("");

    // Assert
    assertTrue(actualArgs.isEmpty());
  }

  /**
   * Test {@link TbRabbitMqQueueArguments#getArgs(String)}.
   *
   * <ul>
   *   <li>When {@code :false}.
   *   <li>Then return not empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  @DisplayName("Test getArgs(String); when ':false'; then return not empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbRabbitMqQueueArguments.getArgs(String)"})
  void testGetArgs_whenFalse_thenReturnNotEmptyString() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(":false");

    // Assert
    assertEquals(1, actualArgs.size());
    assertFalse((Boolean) actualArgs.get(""));
  }

  /**
   * Test {@link TbRabbitMqQueueArguments#getArgs(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  @DisplayName("Test getArgs(String); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbRabbitMqQueueArguments.getArgs(String)"})
  void testGetArgs_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(null);

    // Assert
    assertTrue(actualArgs.isEmpty());
  }

  /**
   * Test {@link TbRabbitMqQueueArguments#getArgs(String)}.
   *
   * <ul>
   *   <li>When {@code ;}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  @DisplayName("Test getArgs(String); when ';'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbRabbitMqQueueArguments.getArgs(String)"})
  void testGetArgs_whenSemicolon_thenReturnEmpty() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(";");

    // Assert
    assertTrue(actualArgs.isEmpty());
  }

  /**
   * Test {@link TbRabbitMqQueueArguments#getArgs(String)}.
   *
   * <ul>
   *   <li>When {@code :true}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  @DisplayName("Test getArgs(String); when ':true'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbRabbitMqQueueArguments.getArgs(String)"})
  void testGetArgs_whenTrue_thenReturnEmptyString() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(":true");

    // Assert
    assertEquals(1, actualArgs.size());
    assertTrue((Boolean) actualArgs.get(""));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbRabbitMqQueueArguments#getCoreArgs()}
   *   <li>{@link TbRabbitMqQueueArguments#getEdgeArgs()}
   *   <li>{@link TbRabbitMqQueueArguments#getJsExecutorArgs()}
   *   <li>{@link TbRabbitMqQueueArguments#getNotificationsArgs()}
   *   <li>{@link TbRabbitMqQueueArguments#getRuleEngineArgs()}
   *   <li>{@link TbRabbitMqQueueArguments#getTransportApiArgs()}
   *   <li>{@link TbRabbitMqQueueArguments#getVcArgs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Map TbRabbitMqQueueArguments.getCoreArgs()",
    "Map TbRabbitMqQueueArguments.getEdgeArgs()",
    "Map TbRabbitMqQueueArguments.getJsExecutorArgs()",
    "Map TbRabbitMqQueueArguments.getNotificationsArgs()",
    "Map TbRabbitMqQueueArguments.getRuleEngineArgs()",
    "Map TbRabbitMqQueueArguments.getTransportApiArgs()",
    "Map TbRabbitMqQueueArguments.getVcArgs()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbRabbitMqQueueArguments tbRabbitMqQueueArguments = new TbRabbitMqQueueArguments();

    // Act
    Map<String, Object> actualCoreArgs = tbRabbitMqQueueArguments.getCoreArgs();
    Map<String, Object> actualEdgeArgs = tbRabbitMqQueueArguments.getEdgeArgs();
    Map<String, Object> actualJsExecutorArgs = tbRabbitMqQueueArguments.getJsExecutorArgs();
    Map<String, Object> actualNotificationsArgs = tbRabbitMqQueueArguments.getNotificationsArgs();
    Map<String, Object> actualRuleEngineArgs = tbRabbitMqQueueArguments.getRuleEngineArgs();
    Map<String, Object> actualTransportApiArgs = tbRabbitMqQueueArguments.getTransportApiArgs();

    // Assert
    assertNull(actualCoreArgs);
    assertNull(actualEdgeArgs);
    assertNull(actualJsExecutorArgs);
    assertNull(actualNotificationsArgs);
    assertNull(actualRuleEngineArgs);
    assertNull(actualTransportApiArgs);
    assertNull(tbRabbitMqQueueArguments.getVcArgs());
  }
}
