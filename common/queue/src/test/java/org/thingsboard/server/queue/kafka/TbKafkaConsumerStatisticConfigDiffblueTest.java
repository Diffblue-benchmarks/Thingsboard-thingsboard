package org.thingsboard.server.queue.kafka;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbKafkaConsumerStatisticConfigDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbKafkaConsumerStatisticConfig#getEnabled()}
   *   <li>{@link TbKafkaConsumerStatisticConfig#getKafkaResponseTimeoutMs()}
   *   <li>{@link TbKafkaConsumerStatisticConfig#getPrintIntervalMs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbKafkaConsumerStatisticConfig tbKafkaConsumerStatisticConfig = new TbKafkaConsumerStatisticConfig();

    // Act
    Boolean actualEnabled = tbKafkaConsumerStatisticConfig.getEnabled();
    Long actualKafkaResponseTimeoutMs = tbKafkaConsumerStatisticConfig.getKafkaResponseTimeoutMs();

    // Assert
    assertNull(actualEnabled);
    assertNull(actualKafkaResponseTimeoutMs);
    assertNull(tbKafkaConsumerStatisticConfig.getPrintIntervalMs());
  }
}
