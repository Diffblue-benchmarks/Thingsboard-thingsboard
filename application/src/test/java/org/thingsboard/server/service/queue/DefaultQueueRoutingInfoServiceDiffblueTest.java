package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.dao.queue.BaseQueueService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfo;

class DefaultQueueRoutingInfoServiceDiffblueTest {
  /**
   * Test {@link DefaultQueueRoutingInfoService#getAllQueuesRoutingInfo()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultQueueRoutingInfoService#getAllQueuesRoutingInfo()}
   */
  @Test
  @DisplayName("Test getAllQueuesRoutingInfo(); then return Empty")
  void testGetAllQueuesRoutingInfo_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseQueueService queueService = mock(BaseQueueService.class);
    when(queueService.findAllQueues()).thenReturn(new ArrayList<>());

    // Act
    List<QueueRoutingInfo> actualAllQueuesRoutingInfo = (new DefaultQueueRoutingInfoService(queueService))
        .getAllQueuesRoutingInfo();

    // Assert
    verify(queueService).findAllQueues();
    assertTrue(actualAllQueuesRoutingInfo.isEmpty());
  }
}
