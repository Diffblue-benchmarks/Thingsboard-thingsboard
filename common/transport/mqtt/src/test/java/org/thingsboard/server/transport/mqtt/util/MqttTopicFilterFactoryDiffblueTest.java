package org.thingsboard.server.transport.mqtt.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MqttTopicFilterFactoryDiffblueTest {
  /**
   * Test {@link MqttTopicFilterFactory#toFilter(String)}.
   * <ul>
   *   <li>When {@code +}.</li>
   *   <li>Then return not filter empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  @DisplayName("Test toFilter(String); when '+'; then return not filter empty string")
  void testToFilter_whenPlusSign_thenReturnNotFilterEmptyString() {
    // Arrange and Act
    MqttTopicFilter actualToFilterResult = MqttTopicFilterFactory.toFilter("+");
    boolean actualFilterResult = actualToFilterResult.filter("");

    // Assert
    assertTrue(actualToFilterResult instanceof RegexTopicFilter);
    assertEquals("[^/]+", ((RegexTopicFilter) actualToFilterResult).getRegex().pattern());
    assertFalse(actualFilterResult);
  }

  /**
   * Test {@link MqttTopicFilterFactory#toFilter(String)}.
   * <ul>
   *   <li>When {@code +}.</li>
   *   <li>Then return {@link RegexTopicFilter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  @DisplayName("Test toFilter(String); when '+'; then return RegexTopicFilter")
  void testToFilter_whenPlusSign_thenReturnRegexTopicFilter() {
    // Arrange and Act
    MqttTopicFilter actualToFilterResult = MqttTopicFilterFactory.toFilter("+");
    boolean actualFilterResult = actualToFilterResult.filter("Topic");

    // Assert
    assertTrue(actualToFilterResult instanceof RegexTopicFilter);
    assertEquals("[^/]+", ((RegexTopicFilter) actualToFilterResult).getRegex().pattern());
    assertTrue(actualFilterResult);
  }

  /**
   * Test {@link MqttTopicFilterFactory#toFilter(String)}.
   * <ul>
   *   <li>When {@code Topic Filter}.</li>
   *   <li>Then return Filter is {@code Topic Filter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  @DisplayName("Test toFilter(String); when 'Topic Filter'; then return Filter is 'Topic Filter'")
  void testToFilter_whenTopicFilter_thenReturnFilterIsTopicFilter() {
    // Arrange and Act
    MqttTopicFilter actualToFilterResult = MqttTopicFilterFactory.toFilter("Topic Filter");
    boolean actualFilterResult = actualToFilterResult.filter("Topic");

    // Assert
    assertTrue(actualToFilterResult instanceof EqualsTopicFilter);
    assertEquals("Topic Filter", ((EqualsTopicFilter) actualToFilterResult).getFilter());
    assertFalse(actualFilterResult);
  }

  /**
   * Test {@link MqttTopicFilterFactory#toFilter(String)}.
   * <ul>
   *   <li>When {@code Topic}.</li>
   *   <li>Then return Filter is {@code Topic}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  @DisplayName("Test toFilter(String); when 'Topic'; then return Filter is 'Topic'")
  void testToFilter_whenTopic_thenReturnFilterIsTopic() {
    // Arrange and Act
    MqttTopicFilter actualToFilterResult = MqttTopicFilterFactory.toFilter("Topic");
    boolean actualFilterResult = actualToFilterResult.filter("Topic");

    // Assert
    assertTrue(actualToFilterResult instanceof EqualsTopicFilter);
    assertEquals("Topic", ((EqualsTopicFilter) actualToFilterResult).getFilter());
    assertTrue(actualFilterResult);
  }
}
