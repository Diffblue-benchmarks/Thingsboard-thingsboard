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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class TbKafkaAdminDiffblueTest {
  /**
   * Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  void testNewTbKafkaAdmin() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaSettings settings = new TbKafkaSettings();
    HashMap<String, String> topicConfigs = new HashMap<>();

    // Act
    new TbKafkaAdmin(settings, topicConfigs);

    // Assert
    assertTrue(topicConfigs.isEmpty());
  }

  /**
   * Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  void testNewTbKafkaAdmin2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaSettings settings = new TbKafkaSettings();

    HashMap<String, String> topicConfigs = new HashMap<>();
    topicConfigs.put(TbKafkaTopicConfigs.NUM_PARTITIONS_SETTING, "42");

    // Act
    new TbKafkaAdmin(settings, topicConfigs);

    // Assert
    assertTrue(topicConfigs.isEmpty());
  }

  /**
   * Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  void testNewTbKafkaAdmin3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaSettings settings = new TbKafkaSettings();

    HashMap<String, String> topicConfigs = new HashMap<>();
    topicConfigs.computeIfPresent(TbKafkaTopicConfigs.NUM_PARTITIONS_SETTING, mock(BiFunction.class));

    // Act
    new TbKafkaAdmin(settings, topicConfigs);

    // Assert
    assertTrue(topicConfigs.isEmpty());
  }
}
