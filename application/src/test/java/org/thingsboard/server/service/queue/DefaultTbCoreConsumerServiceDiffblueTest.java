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
import org.thingsboard.server.service.queue.DefaultTbCoreConsumerService.CoreQueueConfig;

@ExtendWith(MockitoExtension.class)
class DefaultTbCoreConsumerServiceDiffblueTest {
  @InjectMocks
  private DefaultTbCoreConsumerService defaultTbCoreConsumerService;

  @Mock
  private StatsFactory statsFactory;

  /**
   * Test CoreQueueConfig getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CoreQueueConfig#toString()}
   *   <li>{@link CoreQueueConfig#getPollInterval()}
   *   <li>{@link CoreQueueConfig#isConsumerPerPartition()}
   * </ul>
   */
  @Test
  @DisplayName("Test CoreQueueConfig getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CoreQueueConfig.getPollInterval()", "boolean CoreQueueConfig.isConsumerPerPartition()",
      "String CoreQueueConfig.toString()"})
  void testCoreQueueConfigGettersAndSetters() {
    // Arrange
    CoreQueueConfig ofResult = CoreQueueConfig.of(true, 42);

    // Act
    String actualToStringResult = ofResult.toString();
    int actualPollInterval = ofResult.getPollInterval();

    // Assert
    assertEquals("DefaultTbCoreConsumerService.CoreQueueConfig(consumerPerPartition=true, pollInterval=42)",
        actualToStringResult);
    assertEquals(42, actualPollInterval);
    assertTrue(ofResult.isConsumerPerPartition());
  }

  /**
   * Test {@link DefaultTbCoreConsumerService#getMgmtThreadPoolSize()}.
   * <p>
   * Method under test: {@link DefaultTbCoreConsumerService#getMgmtThreadPoolSize()}
   */
  @Test
  @DisplayName("Test getMgmtThreadPoolSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DefaultTbCoreConsumerService.getMgmtThreadPoolSize()"})
  void testGetMgmtThreadPoolSize() {
    // Arrange, Act and Assert
    assertEquals(20, defaultTbCoreConsumerService.getMgmtThreadPoolSize());
  }
}
