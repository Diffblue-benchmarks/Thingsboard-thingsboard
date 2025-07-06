package org.thingsboard.server.queue.kafka;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbKafkaAdminDiffblueTest {
  /**
   * Test {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@link TbKafkaTopicConfigs#NUM_PARTITIONS_SETTING} is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  @DisplayName(
      "Test new TbKafkaAdmin(TbKafkaSettings, Map); given '42'; when HashMap() NUM_PARTITIONS_SETTING is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbKafkaAdmin.<init>(TbKafkaSettings, Map)"})
  void testNewTbKafkaAdmin_given42_whenHashMapNum_partitions_settingIs42() {
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
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbKafkaAdmin(TbKafkaSettings, Map); when HashMap(); then HashMap() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbKafkaAdmin.<init>(TbKafkaSettings, Map)"})
  void testNewTbKafkaAdmin_whenHashMap_thenHashMapEmpty() {
    // Arrange
    TbKafkaSettings settings = new TbKafkaSettings();
    HashMap<String, String> topicConfigs = new HashMap<>();

    // Act
    new TbKafkaAdmin(settings, topicConfigs);

    // Assert that nothing has changed
    assertTrue(topicConfigs.isEmpty());
  }
}
