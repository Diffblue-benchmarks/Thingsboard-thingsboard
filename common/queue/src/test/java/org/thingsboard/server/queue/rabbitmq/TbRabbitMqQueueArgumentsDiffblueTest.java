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
package org.thingsboard.server.queue.rabbitmq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TbRabbitMqQueueArgumentsDiffblueTest {
  /**
   * Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  void testGetArgs() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(";");

    // Assert
    assertTrue(actualArgs.isEmpty());
  }

  /**
   * Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  void testGetArgs2() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(":");

    // Assert
    assertEquals(1, actualArgs.size());
    assertEquals("", actualArgs.get(""));
  }

  /**
   * Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  void testGetArgs3() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs("");

    // Assert
    assertTrue(actualArgs.isEmpty());
  }

  /**
   * Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  void testGetArgs4() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(":42");

    // Assert
    assertEquals(1, actualArgs.size());
    assertTrue(actualArgs.containsKey(""));
  }

  /**
   * Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  void testGetArgs5() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(":false");

    // Assert
    assertEquals(1, actualArgs.size());
    assertTrue(actualArgs.containsKey(""));
  }

  /**
   * Method under test: {@link TbRabbitMqQueueArguments#getArgs(String)}
   */
  @Test
  void testGetArgs6() {
    // Arrange and Act
    Map<String, Object> actualArgs = TbRabbitMqQueueArguments.getArgs(":true");

    // Assert
    assertEquals(1, actualArgs.size());
    assertTrue(actualArgs.containsKey(""));
  }

  /**
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
