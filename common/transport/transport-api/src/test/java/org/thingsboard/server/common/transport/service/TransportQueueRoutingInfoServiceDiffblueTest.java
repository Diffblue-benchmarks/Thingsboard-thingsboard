package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.GetAllQueueRoutingInfoRequestMsg;
import org.thingsboard.server.queue.discovery.QueueRoutingInfo;

class TransportQueueRoutingInfoServiceDiffblueTest {
  /**
   * Test {@link TransportQueueRoutingInfoService#getAllQueuesRoutingInfo()}.
   *
   * <p>Method under test: {@link TransportQueueRoutingInfoService#getAllQueuesRoutingInfo()}
   */
  @Test
  @DisplayName("Test getAllQueuesRoutingInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TransportQueueRoutingInfoService.getAllQueuesRoutingInfo()"})
  void testGetAllQueuesRoutingInfo() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    when(transportService.getQueueRoutingInfo(Mockito.<GetAllQueueRoutingInfoRequestMsg>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<QueueRoutingInfo> actualAllQueuesRoutingInfo =
        new TransportQueueRoutingInfoService(transportService).getAllQueuesRoutingInfo();

    // Assert
    verify(transportService).getQueueRoutingInfo(isA(GetAllQueueRoutingInfoRequestMsg.class));
    assertTrue(actualAllQueuesRoutingInfo.isEmpty());
  }
}
