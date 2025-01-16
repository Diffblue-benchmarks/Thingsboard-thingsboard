package org.thingsboard.server.queue.housekeeper;

import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTask;
import org.thingsboard.server.queue.provider.TbQueueProducerProvider;

@DisabledInAotMode
class DefaultHousekeeperClientDiffblueTest {
  @MockBean
  private DefaultHousekeeperClient defaultHousekeeperClient;

  @MockBean
  private HousekeeperConfig housekeeperConfig;

  @MockBean
  private TbQueueProducerProvider tbQueueProducerProvider;

  /**
   * Test {@link DefaultHousekeeperClient#submitTask(HousekeeperTask)}.
   * <p>
   * Method under test:
   * {@link DefaultHousekeeperClient#submitTask(HousekeeperTask)}
   */
  @Test
  @DisplayName("Test submitTask(HousekeeperTask)")
  void testSubmitTask() {
    // Arrange
    doNothing().when(defaultHousekeeperClient).submitTask(Mockito.<HousekeeperTask>any());

    // Act
    defaultHousekeeperClient.submitTask(null);

    // Assert that nothing has changed
    verify(defaultHousekeeperClient).submitTask(isNull());
  }
}
