package org.thingsboard.server.service.edge.rpc.processor.alarm;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.gen.edge.v1.DownlinkMsg;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

@ExtendWith(MockitoExtension.class)
class AlarmEdgeProcessorDiffblueTest {
  @InjectMocks private AlarmEdgeProcessorV1 alarmEdgeProcessorV1;

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent,
   * EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmEventToDownlink(EdgeEvent, EdgeVersion); given ArrayNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AlarmEdgeProcessor.convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)"
  })
  void testConvertAlarmEventToDownlink_givenArrayNode() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setBody(mock(ArrayNode.class));
    edgeEvent.setAction(EdgeEventActionType.CREDENTIALS_UPDATED);

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}.
   *
   * <ul>
   *   <li>Given {@code DELETED}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent,
   * EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test convertAlarmEventToDownlink(EdgeEvent, EdgeVersion); given 'DELETED'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AlarmEdgeProcessor.convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)"
  })
  void testConvertAlarmEventToDownlink_givenDeleted_thenReturnNull() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.DELETED);

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   *
   * <ul>
   *   <li>Given {@code ADDED}.
   *   <li>When {@link EdgeEvent#EdgeEvent()} Action is {@code ADDED}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent,
   * EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); given 'ADDED'; when EdgeEvent() Action is 'ADDED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AlarmEdgeProcessor.convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)"
  })
  void testConvertAlarmCommentEventToDownlink_givenAdded_whenEdgeEventActionIsAdded() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertNull(
        alarmEdgeProcessorV1.convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent,
   * EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); given Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AlarmEdgeProcessor.convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)"
  })
  void testConvertAlarmCommentEventToDownlink_givenInstance() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getBody()).thenReturn(MissingNode.getInstance());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED_COMMENT);

    // Act
    DownlinkMsg actualConvertAlarmCommentEventToDownlinkResult =
        alarmEdgeProcessorV1.convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent, atLeast(1)).getAction();
    verify(edgeEvent).getBody();
    assertNull(actualConvertAlarmCommentEventToDownlinkResult);
  }

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent,
   * EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); given Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AlarmEdgeProcessor.convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)"
  })
  void testConvertAlarmCommentEventToDownlink_givenInstance2() {
    // Arrange
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getBody()).thenReturn(MissingNode.getInstance());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED_COMMENT);

    // Act
    DownlinkMsg actualConvertAlarmCommentEventToDownlinkResult =
        alarmEdgeProcessorV1.convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent, atLeast(1)).getAction();
    verify(edgeEvent).getBody();
    assertNull(actualConvertAlarmCommentEventToDownlinkResult);
  }

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link EdgeEvent} {@link EdgeEvent#getBody()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent,
   * EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); given 'null'; when EdgeEvent getBody() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AlarmEdgeProcessor.convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)"
  })
  void testConvertAlarmCommentEventToDownlink_givenNull_whenEdgeEventGetBodyReturnNull() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getBody()).thenReturn(null);
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED_COMMENT);

    // Act
    DownlinkMsg actualConvertAlarmCommentEventToDownlinkResult =
        alarmEdgeProcessorV1.convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent, atLeast(1)).getAction();
    verify(edgeEvent).getBody();
    assertNull(actualConvertAlarmCommentEventToDownlinkResult);
  }

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   *
   * <ul>
   *   <li>When {@link EdgeEvent} {@link EdgeEvent#getAction()} return {@code ADDED}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent,
   * EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); when EdgeEvent getAction() return 'ADDED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AlarmEdgeProcessor.convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)"
  })
  void testConvertAlarmCommentEventToDownlink_whenEdgeEventGetActionReturnAdded() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED);

    // Act
    DownlinkMsg actualConvertAlarmCommentEventToDownlinkResult =
        alarmEdgeProcessorV1.convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent, atLeast(1)).getAction();
    assertNull(actualConvertAlarmCommentEventToDownlinkResult);
  }
}
