package org.thingsboard.server.service.edge.rpc.processor.notification;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.gen.edge.v1.DownlinkMsg;

class NotificationEdgeProcessorDiffblueTest {
  /**
   * Test
   * {@link NotificationEdgeProcessor#convertNotificationRuleToDownlink(EdgeEvent)}.
   * <ul>
   *   <li>Given {@code POST_ATTRIBUTES}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationEdgeProcessor#convertNotificationRuleToDownlink(EdgeEvent)}
   */
  @Test
  @DisplayName("Test convertNotificationRuleToDownlink(EdgeEvent); given 'POST_ATTRIBUTES'; then return 'null'")
  void testConvertNotificationRuleToDownlink_givenPostAttributes_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationEdgeProcessor notificationEdgeProcessor = new NotificationEdgeProcessor();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.POST_ATTRIBUTES);

    // Act
    DownlinkMsg actualConvertNotificationRuleToDownlinkResult = notificationEdgeProcessor
        .convertNotificationRuleToDownlink(edgeEvent);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    assertNull(actualConvertNotificationRuleToDownlinkResult);
  }

  /**
   * Test
   * {@link NotificationEdgeProcessor#convertNotificationTargetToDownlink(EdgeEvent)}.
   * <ul>
   *   <li>Given {@code POST_ATTRIBUTES}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationEdgeProcessor#convertNotificationTargetToDownlink(EdgeEvent)}
   */
  @Test
  @DisplayName("Test convertNotificationTargetToDownlink(EdgeEvent); given 'POST_ATTRIBUTES'; then return 'null'")
  void testConvertNotificationTargetToDownlink_givenPostAttributes_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationEdgeProcessor notificationEdgeProcessor = new NotificationEdgeProcessor();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.POST_ATTRIBUTES);

    // Act
    DownlinkMsg actualConvertNotificationTargetToDownlinkResult = notificationEdgeProcessor
        .convertNotificationTargetToDownlink(edgeEvent);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    assertNull(actualConvertNotificationTargetToDownlinkResult);
  }

  /**
   * Test
   * {@link NotificationEdgeProcessor#convertNotificationTemplateToDownlink(EdgeEvent)}.
   * <ul>
   *   <li>Given {@code POST_ATTRIBUTES}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationEdgeProcessor#convertNotificationTemplateToDownlink(EdgeEvent)}
   */
  @Test
  @DisplayName("Test convertNotificationTemplateToDownlink(EdgeEvent); given 'POST_ATTRIBUTES'; then return 'null'")
  void testConvertNotificationTemplateToDownlink_givenPostAttributes_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationEdgeProcessor notificationEdgeProcessor = new NotificationEdgeProcessor();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.POST_ATTRIBUTES);

    // Act
    DownlinkMsg actualConvertNotificationTemplateToDownlinkResult = notificationEdgeProcessor
        .convertNotificationTemplateToDownlink(edgeEvent);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    assertNull(actualConvertNotificationTemplateToDownlinkResult);
  }
}
