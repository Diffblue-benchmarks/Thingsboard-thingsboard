package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.discovery.QueueRoutingInfo;

class TransportQueueRoutingInfoServiceDiffblueTest {
  /**
   * Test {@link TransportQueueRoutingInfoService#getAllQueuesRoutingInfo()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportQueueRoutingInfoService#getAllQueuesRoutingInfo()}
   */
  @Test
  @DisplayName("Test getAllQueuesRoutingInfo(); then return Empty")
  void testGetAllQueuesRoutingInfo_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    when(transportService.getQueueRoutingInfo(Mockito.<TransportProtos.GetAllQueueRoutingInfoRequestMsg>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<QueueRoutingInfo> actualAllQueuesRoutingInfo = (new TransportQueueRoutingInfoService(transportService))
        .getAllQueuesRoutingInfo();

    // Assert
    verify(transportService).getQueueRoutingInfo(isA(TransportProtos.GetAllQueueRoutingInfoRequestMsg.class));
    assertTrue(actualAllQueuesRoutingInfo.isEmpty());
  }
}
