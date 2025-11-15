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
package org.thingsboard.server.transport.mqtt.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class MqttTopicFilterFactoryDiffblueTest {
  /**
   * Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  void testToFilter() {
    // Arrange and Act
    MqttTopicFilter actualToFilterResult = MqttTopicFilterFactory.toFilter("Topic Filter");
    boolean actualFilterResult = actualToFilterResult.filter("Topic");

    // Assert
    assertTrue(actualToFilterResult instanceof EqualsTopicFilter);
    assertEquals("Topic Filter", ((EqualsTopicFilter) actualToFilterResult).getFilter());
    assertFalse(actualFilterResult);
  }

  /**
   * Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  void testToFilter2() {
    // Arrange and Act
    MqttTopicFilter actualToFilterResult = MqttTopicFilterFactory.toFilter("Topic");
    boolean actualFilterResult = actualToFilterResult.filter("Topic");

    // Assert
    assertTrue(actualToFilterResult instanceof EqualsTopicFilter);
    assertEquals("Topic", ((EqualsTopicFilter) actualToFilterResult).getFilter());
    assertTrue(actualFilterResult);
  }

  /**
   * Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  void testToFilter3() {
    // Arrange and Act
    MqttTopicFilter actualToFilterResult = MqttTopicFilterFactory.toFilter("+");
    boolean actualFilterResult = actualToFilterResult.filter("Topic");

    // Assert
    assertTrue(actualToFilterResult instanceof RegexTopicFilter);
    assertEquals("[^/]+", ((RegexTopicFilter) actualToFilterResult).getRegex().pattern());
    assertTrue(actualFilterResult);
  }

  /**
   * Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  void testToFilter4() {
    // Arrange and Act
    MqttTopicFilter actualToFilterResult = MqttTopicFilterFactory.toFilter("+");
    boolean actualFilterResult = actualToFilterResult.filter("");

    // Assert
    assertTrue(actualToFilterResult instanceof RegexTopicFilter);
    assertEquals("[^/]+", ((RegexTopicFilter) actualToFilterResult).getRegex().pattern());
    assertFalse(actualFilterResult);
  }
}
