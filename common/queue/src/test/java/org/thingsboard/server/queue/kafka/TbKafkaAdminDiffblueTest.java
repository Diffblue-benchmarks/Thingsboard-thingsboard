package org.thingsboard.server.queue.kafka;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbKafkaAdminDiffblueTest {
  /**
   * Test {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()}
   * {@link TbKafkaTopicConfigs#NUM_PARTITIONS_SETTING} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbKafkaAdmin(TbKafkaSettings, Map); given '42'; when HashMap() NUM_PARTITIONS_SETTING is '42'")
  void testNewTbKafkaAdmin_given42_whenHashMapNum_partitions_settingIs42() {
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
   * Test {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbKafkaAdmin(TbKafkaSettings, Map); given BiFunction")
  void testNewTbKafkaAdmin_givenBiFunction() {
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

  /**
   * Test {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link HashMap#HashMap()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbKafkaAdmin(TbKafkaSettings, Map); when HashMap(); then HashMap() Empty")
  void testNewTbKafkaAdmin_whenHashMap_thenHashMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaSettings settings = new TbKafkaSettings();
    HashMap<String, String> topicConfigs = new HashMap<>();

    // Act
    new TbKafkaAdmin(settings, topicConfigs);

    // Assert
    assertTrue(topicConfigs.isEmpty());
  }
}
