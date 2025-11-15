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
package org.thingsboard.server.queue.sqs;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TbAwsSqsQueueAttributesDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsSqsQueueAttributes#getCoreAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getEdgeAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getJsExecutorAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getNotificationsAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getOtaAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getRuleEngineAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getTransportApiAttributes()}
   *   <li>{@link TbAwsSqsQueueAttributes#getVcAttributes()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbAwsSqsQueueAttributes tbAwsSqsQueueAttributes = new TbAwsSqsQueueAttributes();

    // Act
    Map<String, String> actualCoreAttributes = tbAwsSqsQueueAttributes.getCoreAttributes();
    Map<String, String> actualEdgeAttributes = tbAwsSqsQueueAttributes.getEdgeAttributes();
    Map<String, String> actualJsExecutorAttributes = tbAwsSqsQueueAttributes.getJsExecutorAttributes();
    Map<String, String> actualNotificationsAttributes = tbAwsSqsQueueAttributes.getNotificationsAttributes();
    Map<String, String> actualOtaAttributes = tbAwsSqsQueueAttributes.getOtaAttributes();
    Map<String, String> actualRuleEngineAttributes = tbAwsSqsQueueAttributes.getRuleEngineAttributes();
    Map<String, String> actualTransportApiAttributes = tbAwsSqsQueueAttributes.getTransportApiAttributes();

    // Assert
    assertNull(actualCoreAttributes);
    assertNull(actualEdgeAttributes);
    assertNull(actualJsExecutorAttributes);
    assertNull(actualNotificationsAttributes);
    assertNull(actualOtaAttributes);
    assertNull(actualRuleEngineAttributes);
    assertNull(actualTransportApiAttributes);
    assertNull(tbAwsSqsQueueAttributes.getVcAttributes());
  }

  /**
   * Method under test: {@link TbAwsSqsQueueAttributes#toConfigs(String)}
   */
  @Test
  void testToConfigs() {
    // Arrange and Act
    Map<String, String> actualToConfigsResult = TbAwsSqsQueueAttributes.toConfigs(";");

    // Assert
    assertTrue(actualToConfigsResult.isEmpty());
  }

  /**
   * Method under test: {@link TbAwsSqsQueueAttributes#toConfigs(String)}
   */
  @Test
  void testToConfigs2() {
    // Arrange and Act
    Map<String, String> actualToConfigsResult = TbAwsSqsQueueAttributes.toConfigs("");

    // Assert
    assertTrue(actualToConfigsResult.isEmpty());
  }
}
