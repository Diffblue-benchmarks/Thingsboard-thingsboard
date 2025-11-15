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
package org.thingsboard.server.queue.kafka;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbKafkaTopicConfigsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbKafkaTopicConfigs#getCoreConfigs()}
   *   <li>{@link TbKafkaTopicConfigs#getEdgeConfigs()}
   *   <li>{@link TbKafkaTopicConfigs#getFwUpdatesConfigs()}
   *   <li>{@link TbKafkaTopicConfigs#getHousekeeperConfigs()}
   *   <li>{@link TbKafkaTopicConfigs#getHousekeeperReprocessingConfigs()}
   *   <li>{@link TbKafkaTopicConfigs#getJsExecutorRequestConfigs()}
   *   <li>{@link TbKafkaTopicConfigs#getJsExecutorResponseConfigs()}
   *   <li>{@link TbKafkaTopicConfigs#getNotificationsConfigs()}
   *   <li>{@link TbKafkaTopicConfigs#getRuleEngineConfigs()}
   *   <li>{@link TbKafkaTopicConfigs#getTransportApiRequestConfigs()}
   *   <li>{@link TbKafkaTopicConfigs#getTransportApiResponseConfigs()}
   *   <li>{@link TbKafkaTopicConfigs#getVcConfigs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbKafkaTopicConfigs.getCoreConfigs()", "Map TbKafkaTopicConfigs.getEdgeConfigs()",
      "Map TbKafkaTopicConfigs.getFwUpdatesConfigs()", "Map TbKafkaTopicConfigs.getHousekeeperConfigs()",
      "Map TbKafkaTopicConfigs.getHousekeeperReprocessingConfigs()",
      "Map TbKafkaTopicConfigs.getJsExecutorRequestConfigs()", "Map TbKafkaTopicConfigs.getJsExecutorResponseConfigs()",
      "Map TbKafkaTopicConfigs.getNotificationsConfigs()", "Map TbKafkaTopicConfigs.getRuleEngineConfigs()",
      "Map TbKafkaTopicConfigs.getTransportApiRequestConfigs()",
      "Map TbKafkaTopicConfigs.getTransportApiResponseConfigs()", "Map TbKafkaTopicConfigs.getVcConfigs()"})
  void testGettersAndSetters() {
    // Arrange
    TbKafkaTopicConfigs tbKafkaTopicConfigs = new TbKafkaTopicConfigs();

    // Act
    Map<String, String> actualCoreConfigs = tbKafkaTopicConfigs.getCoreConfigs();
    Map<String, String> actualEdgeConfigs = tbKafkaTopicConfigs.getEdgeConfigs();
    Map<String, String> actualFwUpdatesConfigs = tbKafkaTopicConfigs.getFwUpdatesConfigs();
    Map<String, String> actualHousekeeperConfigs = tbKafkaTopicConfigs.getHousekeeperConfigs();
    Map<String, String> actualHousekeeperReprocessingConfigs = tbKafkaTopicConfigs.getHousekeeperReprocessingConfigs();
    Map<String, String> actualJsExecutorRequestConfigs = tbKafkaTopicConfigs.getJsExecutorRequestConfigs();
    Map<String, String> actualJsExecutorResponseConfigs = tbKafkaTopicConfigs.getJsExecutorResponseConfigs();
    Map<String, String> actualNotificationsConfigs = tbKafkaTopicConfigs.getNotificationsConfigs();
    Map<String, String> actualRuleEngineConfigs = tbKafkaTopicConfigs.getRuleEngineConfigs();
    Map<String, String> actualTransportApiRequestConfigs = tbKafkaTopicConfigs.getTransportApiRequestConfigs();
    Map<String, String> actualTransportApiResponseConfigs = tbKafkaTopicConfigs.getTransportApiResponseConfigs();

    // Assert
    assertNull(actualCoreConfigs);
    assertNull(actualEdgeConfigs);
    assertNull(actualFwUpdatesConfigs);
    assertNull(actualHousekeeperConfigs);
    assertNull(actualHousekeeperReprocessingConfigs);
    assertNull(actualJsExecutorRequestConfigs);
    assertNull(actualJsExecutorResponseConfigs);
    assertNull(actualNotificationsConfigs);
    assertNull(actualRuleEngineConfigs);
    assertNull(actualTransportApiRequestConfigs);
    assertNull(actualTransportApiResponseConfigs);
    assertNull(tbKafkaTopicConfigs.getVcConfigs());
  }
}
