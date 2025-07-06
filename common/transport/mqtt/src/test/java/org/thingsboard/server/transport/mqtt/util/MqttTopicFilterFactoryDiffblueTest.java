package org.thingsboard.server.transport.mqtt.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MqttTopicFilterFactoryDiffblueTest {
  /**
   * Test {@link MqttTopicFilterFactory#toFilter(String)}.
   *
   * <p>Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  @DisplayName("Test toFilter(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttTopicFilter MqttTopicFilterFactory.toFilter(String)"})
  void testToFilter() {
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
   *
   * <ul>
   *   <li>When {@code #}.
   *   <li>Then return {@link AlwaysTrueTopicFilter}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  @DisplayName("Test toFilter(String); when '#'; then return AlwaysTrueTopicFilter")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttTopicFilter MqttTopicFilterFactory.toFilter(String)"})
  void testToFilter_whenNumberSign_thenReturnAlwaysTrueTopicFilter() {
    // Arrange and Act
    MqttTopicFilter actualToFilterResult = MqttTopicFilterFactory.toFilter("#");
    boolean actualFilterResult = actualToFilterResult.filter("Topic");

    // Assert
    assertTrue(actualToFilterResult instanceof AlwaysTrueTopicFilter);
    assertFalse(((AlwaysTrueTopicFilter) actualToFilterResult).canEqual("Other"));
    assertTrue(actualToFilterResult.filter("Topic"));
    assertTrue(actualFilterResult);
  }

  /**
   * Test {@link MqttTopicFilterFactory#toFilter(String)}.
   *
   * <ul>
   *   <li>When {@code +}.
   *   <li>Then return not filter empty string.
   * </ul>
   *
   * <p>Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  @DisplayName("Test toFilter(String); when '+'; then return not filter empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttTopicFilter MqttTopicFilterFactory.toFilter(String)"})
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
   *
   * <ul>
   *   <li>When {@code Topic Filter}.
   *   <li>Then return Filter is {@code Topic Filter}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  @DisplayName("Test toFilter(String); when 'Topic Filter'; then return Filter is 'Topic Filter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttTopicFilter MqttTopicFilterFactory.toFilter(String)"})
  void testToFilter_whenTopicFilter_thenReturnFilterIsTopicFilter() {
    // Arrange and Act
    MqttTopicFilter actualToFilterResult = MqttTopicFilterFactory.toFilter("Topic Filter");

    // Assert
    assertTrue(actualToFilterResult instanceof EqualsTopicFilter);
    assertEquals("Topic Filter", ((EqualsTopicFilter) actualToFilterResult).getFilter());
  }

  /**
   * Test {@link MqttTopicFilterFactory#toFilter(String)}.
   *
   * <ul>
   *   <li>When {@code Topic Filter}.
   *   <li>Then return not filter {@code Topic}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  @DisplayName("Test toFilter(String); when 'Topic Filter'; then return not filter 'Topic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttTopicFilter MqttTopicFilterFactory.toFilter(String)"})
  void testToFilter_whenTopicFilter_thenReturnNotFilterTopic() {
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
   *
   * <ul>
   *   <li>When {@code Topic Filter#}.
   *   <li>Then return Regex pattern is {@code Topic Filter#}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  @DisplayName(
      "Test toFilter(String); when 'Topic Filter#'; then return Regex pattern is 'Topic Filter#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttTopicFilter MqttTopicFilterFactory.toFilter(String)"})
  void testToFilter_whenTopicFilter_thenReturnRegexPatternIsTopicFilter() {
    // Arrange and Act
    MqttTopicFilter actualToFilterResult = MqttTopicFilterFactory.toFilter("Topic Filter#");

    // Assert
    assertTrue(actualToFilterResult instanceof RegexTopicFilter);
    assertEquals("Topic Filter#", ((RegexTopicFilter) actualToFilterResult).getRegex().pattern());
  }

  /**
   * Test {@link MqttTopicFilterFactory#toFilter(String)}.
   *
   * <ul>
   *   <li>When {@code Topic}.
   *   <li>Then return Filter is {@code Topic}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTopicFilterFactory#toFilter(String)}
   */
  @Test
  @DisplayName("Test toFilter(String); when 'Topic'; then return Filter is 'Topic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttTopicFilter MqttTopicFilterFactory.toFilter(String)"})
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
