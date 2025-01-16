package org.thingsboard.server.service.edge.rpc.processor.edge;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.DownlinkMsg;
import org.thingsboard.server.gen.transport.TransportProtos;

class EdgeProcessorDiffblueTest {
  /**
   * Test {@link EdgeProcessor#convertEdgeEventToDownlink(EdgeEvent)}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>Then calls {@link EdgeEvent#getAction()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeProcessor#convertEdgeEventToDownlink(EdgeEvent)}
   */
  @Test
  @DisplayName("Test convertEdgeEventToDownlink(EdgeEvent); given randomUUID; then calls getAction()")
  void testConvertEdgeEventToDownlink_givenRandomUUID_thenCallsGetAction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeProcessor edgeProcessor = new EdgeProcessor();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED);

    // Act
    DownlinkMsg actualConvertEdgeEventToDownlinkResult = edgeProcessor.convertEdgeEventToDownlink(edgeEvent);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    assertNull(actualConvertEdgeEventToDownlinkResult);
  }

  /**
   * Test {@link EdgeProcessor#convertEdgeEventToDownlink(EdgeEvent)}.
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()} Action is {@code ADDED}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeProcessor#convertEdgeEventToDownlink(EdgeEvent)}
   */
  @Test
  @DisplayName("Test convertEdgeEventToDownlink(EdgeEvent); when EdgeEvent() Action is 'ADDED'; then return 'null'")
  void testConvertEdgeEventToDownlink_whenEdgeEventActionIsAdded_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeProcessor edgeProcessor = new EdgeProcessor();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertNull(edgeProcessor.convertEdgeEventToDownlink(edgeEvent));
  }

  /**
   * Test
   * {@link EdgeProcessor#processEdgeNotification(TenantId, EdgeNotificationMsgProto)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeProcessor#processEdgeNotification(TenantId, TransportProtos.EdgeNotificationMsgProto)}
   */
  @Test
  @DisplayName("Test processEdgeNotification(TenantId, EdgeNotificationMsgProto); when DefaultInstance")
  void testProcessEdgeNotification_whenDefaultInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeProcessor edgeProcessor = new EdgeProcessor();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertTrue(
        edgeProcessor.processEdgeNotification(tenantId, TransportProtos.EdgeNotificationMsgProto.getDefaultInstance())
            .isDone());
  }

  /**
   * Test
   * {@link EdgeProcessor#processEdgeNotification(TenantId, EdgeNotificationMsgProto)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeProcessor#processEdgeNotification(TenantId, TransportProtos.EdgeNotificationMsgProto)}
   */
  @Test
  @DisplayName("Test processEdgeNotification(TenantId, EdgeNotificationMsgProto); when 'null'")
  void testProcessEdgeNotification_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeProcessor edgeProcessor = new EdgeProcessor();

    // Act and Assert
    assertTrue(edgeProcessor.processEdgeNotification(new TenantId(UUID.randomUUID()), null).isDone());
  }
}
