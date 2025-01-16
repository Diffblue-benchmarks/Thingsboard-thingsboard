package org.thingsboard.server.service.edge.rpc.processor.alarm;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.DownlinkMsg;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

class AlarmEdgeProcessorDiffblueTest {
  /**
   * Test
   * {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link EdgeEvent} {@link EdgeEvent#getBody()} return Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmEventToDownlink(EdgeEvent, EdgeVersion); given Instance; when EdgeEvent getBody() return Instance")
  void testConvertAlarmEventToDownlink_givenInstance_whenEdgeEventGetBodyReturnInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getBody()).thenReturn(MissingNode.getInstance());
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.DELETED);
    when(edgeEvent.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    DownlinkMsg actualConvertAlarmEventToDownlinkResult = alarmEdgeProcessorV1.convertAlarmEventToDownlink(edgeEvent,
        EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getBody();
    verify(edgeEvent).getEntityId();
    verify(edgeEvent).getTenantId();
    assertNull(actualConvertAlarmEventToDownlinkResult);
  }

  /**
   * Test
   * {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link EdgeEvent} {@link EdgeEvent#getBody()} return Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmEventToDownlink(EdgeEvent, EdgeVersion); given Instance; when EdgeEvent getBody() return Instance")
  void testConvertAlarmEventToDownlink_givenInstance_whenEdgeEventGetBodyReturnInstance2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getBody()).thenReturn(NullNode.getInstance());
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.DELETED);
    when(edgeEvent.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    DownlinkMsg actualConvertAlarmEventToDownlinkResult = alarmEdgeProcessorV1.convertAlarmEventToDownlink(edgeEvent,
        EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getBody();
    verify(edgeEvent).getEntityId();
    verify(edgeEvent).getTenantId();
    assertNull(actualConvertAlarmEventToDownlinkResult);
  }

  /**
   * Test
   * {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@link JsonNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmEventToDownlink(EdgeEvent, EdgeVersion); given JsonNode")
  void testConvertAlarmEventToDownlink_givenJsonNode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getBody()).thenReturn(mock(JsonNode.class));
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.CREDENTIALS_UPDATED);
    when(edgeEvent.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    DownlinkMsg actualConvertAlarmEventToDownlinkResult = alarmEdgeProcessorV1.convertAlarmEventToDownlink(edgeEvent,
        EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getBody();
    verify(edgeEvent).getEntityId();
    verify(edgeEvent).getTenantId();
    assertNull(actualConvertAlarmEventToDownlinkResult);
  }

  /**
   * Test
   * {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EdgeEvent} {@link EdgeEvent#getBody()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmEventToDownlink(EdgeEvent, EdgeVersion); given 'null'; when EdgeEvent getBody() return 'null'")
  void testConvertAlarmEventToDownlink_givenNull_whenEdgeEventGetBodyReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getBody()).thenReturn(null);
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.DELETED);
    when(edgeEvent.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    DownlinkMsg actualConvertAlarmEventToDownlinkResult = alarmEdgeProcessorV1.convertAlarmEventToDownlink(edgeEvent,
        EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getBody();
    verify(edgeEvent).getEntityId();
    verify(edgeEvent).getTenantId();
    assertNull(actualConvertAlarmEventToDownlinkResult);
  }

  /**
   * Test
   * {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>When {@link EdgeEvent#EdgeEvent()} Action is {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); given 'ADDED'; when EdgeEvent() Action is 'ADDED'")
  void testConvertAlarmCommentEventToDownlink_givenAdded_whenEdgeEventActionIsAdded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link EdgeEvent#EdgeEvent()} Body is Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); given Instance; when EdgeEvent() Body is Instance")
  void testConvertAlarmCommentEventToDownlink_givenInstance_whenEdgeEventBodyIsInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED_COMMENT);
    edgeEvent.setBody(MissingNode.getInstance());

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EdgeEvent#EdgeEvent()} Body is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); given 'null'; when EdgeEvent() Body is 'null'")
  void testConvertAlarmCommentEventToDownlink_givenNull_whenEdgeEventBodyIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED_COMMENT);
    edgeEvent.setBody(null);

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code UPDATED_COMMENT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); given 'UPDATED_COMMENT'")
  void testConvertAlarmCommentEventToDownlink_givenUpdatedComment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.UPDATED_COMMENT);
    edgeEvent.setBody(MissingNode.getInstance());

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Then calls {@link EdgeEvent#getAction()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); then calls getAction()")
  void testConvertAlarmCommentEventToDownlink_thenCallsGetAction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED);

    // Act
    DownlinkMsg actualConvertAlarmCommentEventToDownlinkResult = alarmEdgeProcessorV1
        .convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent, atLeast(1)).getAction();
    assertNull(actualConvertAlarmCommentEventToDownlinkResult);
  }
}
