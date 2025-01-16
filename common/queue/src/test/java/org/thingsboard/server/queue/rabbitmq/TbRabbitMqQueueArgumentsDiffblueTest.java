package org.thingsboard.server.queue.rabbitmq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbRabbitMqQueueArgumentsDiffblueTest {
  /**
   * Test {@link TbRabbitMqQueueArguments#getArgs(String)}.
   * <ul>
   *   <li>When {@code :42}.</li>
   *   <li>Then return containsKey empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  @DisplayName("Test getArgs(String); when ':42'; then return containsKey empty string")
  void testGetArgs_when42_thenReturnContainsKeyEmptyString() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(":42");

    // Assert
    assertEquals(1, actualArgs.size());
    assertTrue(actualArgs.containsKey(""));
  }

  /**
   * Test {@link TbRabbitMqQueueArguments#getArgs(String)}.
   * <ul>
   *   <li>When {@code :}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  @DisplayName("Test getArgs(String); when ':'; then return empty string")
  void testGetArgs_whenColon_thenReturnEmptyString() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(":");

    // Assert
    assertEquals(1, actualArgs.size());
    assertEquals("", actualArgs.get(""));
  }

  /**
   * Test {@link TbRabbitMqQueueArguments#getArgs(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  @DisplayName("Test getArgs(String); when empty string; then return Empty")
  void testGetArgs_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs("");

    // Assert
    assertTrue(actualArgs.isEmpty());
  }

  /**
   * Test {@link TbRabbitMqQueueArguments#getArgs(String)}.
   * <ul>
   *   <li>When {@code :false}.</li>
   *   <li>Then return containsKey empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  @DisplayName("Test getArgs(String); when ':false'; then return containsKey empty string")
  void testGetArgs_whenFalse_thenReturnContainsKeyEmptyString() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(":false");

    // Assert
    assertEquals(1, actualArgs.size());
    assertTrue(actualArgs.containsKey(""));
  }

  /**
   * Test {@link TbRabbitMqQueueArguments#getArgs(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  @DisplayName("Test getArgs(String); when ';'; then return Empty")
  void testGetArgs_whenSemicolon_thenReturnEmpty() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(";");

    // Assert
    assertTrue(actualArgs.isEmpty());
  }

  /**
   * Test {@link TbRabbitMqQueueArguments#getArgs(String)}.
   * <ul>
   *   <li>When {@code :true}.</li>
   *   <li>Then return containsKey empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  @DisplayName("Test getArgs(String); when ':true'; then return containsKey empty string")
  void testGetArgs_whenTrue_thenReturnContainsKeyEmptyString() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(":true");

    // Assert
    assertEquals(1, actualArgs.size());
    assertTrue(actualArgs.containsKey(""));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
