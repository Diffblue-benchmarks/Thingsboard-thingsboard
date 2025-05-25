package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.service.queue.DefaultTbEdgeConsumerService.EdgeQueueConfig;

@ExtendWith(MockitoExtension.class)
class DefaultTbEdgeConsumerServiceDiffblueTest {
  @InjectMocks
  private DefaultTbEdgeConsumerService defaultTbEdgeConsumerService;

  @Mock
  private StatsFactory statsFactory;

  /**
   * Test EdgeQueueConfig getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeQueueConfig#toString()}
   *   <li>{@link EdgeQueueConfig#getPollInterval()}
   *   <li>{@link EdgeQueueConfig#isConsumerPerPartition()}
   * </ul>
   */
  @Test
  @DisplayName("Test EdgeQueueConfig getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int EdgeQueueConfig.getPollInterval()", "boolean EdgeQueueConfig.isConsumerPerPartition()",
      "String EdgeQueueConfig.toString()"})
  void testEdgeQueueConfigGettersAndSetters() {
    // Arrange
    EdgeQueueConfig ofResult = EdgeQueueConfig.of(true, 42);

    // Act
    String actualToStringResult = ofResult.toString();
    int actualPollInterval = ofResult.getPollInterval();

    // Assert
    assertEquals("DefaultTbEdgeConsumerService.EdgeQueueConfig(consumerPerPartition=true, pollInterval=42)",
        actualToStringResult);
    assertEquals(42, actualPollInterval);
    assertTrue(ofResult.isConsumerPerPartition());
  }

  /**
   * Test {@link DefaultTbEdgeConsumerService#getNotificationPollDuration()}.
   * <p>
   * Method under test: {@link DefaultTbEdgeConsumerService#getNotificationPollDuration()}
   */
  @Test
  @DisplayName("Test getNotificationPollDuration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long DefaultTbEdgeConsumerService.getNotificationPollDuration()"})
  void testGetNotificationPollDuration() {
    // Arrange, Act and Assert
    assertEquals(0L, defaultTbEdgeConsumerService.getNotificationPollDuration());
  }

  /**
   * Test {@link DefaultTbEdgeConsumerService#getNotificationPackProcessingTimeout()}.
   * <p>
   * Method under test: {@link DefaultTbEdgeConsumerService#getNotificationPackProcessingTimeout()}
   */
  @Test
  @DisplayName("Test getNotificationPackProcessingTimeout()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long DefaultTbEdgeConsumerService.getNotificationPackProcessingTimeout()"})
  void testGetNotificationPackProcessingTimeout() {
    // Arrange, Act and Assert
    assertEquals(0L, defaultTbEdgeConsumerService.getNotificationPackProcessingTimeout());
  }

  /**
   * Test {@link DefaultTbEdgeConsumerService#getMgmtThreadPoolSize()}.
   * <p>
   * Method under test: {@link DefaultTbEdgeConsumerService#getMgmtThreadPoolSize()}
   */
  @Test
  @DisplayName("Test getMgmtThreadPoolSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DefaultTbEdgeConsumerService.getMgmtThreadPoolSize()"})
  void testGetMgmtThreadPoolSize() {
    // Arrange, Act and Assert
    assertEquals(20, defaultTbEdgeConsumerService.getMgmtThreadPoolSize());
  }
}
