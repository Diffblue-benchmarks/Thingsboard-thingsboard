package org.thingsboard.server.service.edge.rpc.processor.alarm;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

class AlarmEdgeProcessorDiffblueTest {
  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code DELETED}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmEventToDownlink(EdgeEvent, EdgeVersion); given 'DELETED'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg AlarmEdgeProcessor.convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertAlarmEventToDownlink_givenDeleted_thenReturnNull() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.DELETED);

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link EdgeEvent#EdgeEvent()} Body is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmEventToDownlink(EdgeEvent, EdgeVersion); given Instance; when EdgeEvent() Body is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg AlarmEdgeProcessor.convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertAlarmEventToDownlink_givenInstance_whenEdgeEventBodyIsInstance() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setBody(MissingNode.getInstance());
    edgeEvent.setAction(EdgeEventActionType.DELETED);

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link EdgeEvent#EdgeEvent()} Body is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmEventToDownlink(EdgeEvent, EdgeVersion); given Instance; when EdgeEvent() Body is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg AlarmEdgeProcessor.convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertAlarmEventToDownlink_givenInstance_whenEdgeEventBodyIsInstance2() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setBody(NullNode.getInstance());
    edgeEvent.setAction(EdgeEventActionType.DELETED);

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@link JsonNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEdgeProcessor#convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmEventToDownlink(EdgeEvent, EdgeVersion); given JsonNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg AlarmEdgeProcessor.convertAlarmEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertAlarmEventToDownlink_givenJsonNode() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setBody(mock(JsonNode.class));
    edgeEvent.setAction(EdgeEventActionType.CREDENTIALS_UPDATED);

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>When {@link EdgeEvent#EdgeEvent()} Action is {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); given 'ADDED'; when EdgeEvent() Action is 'ADDED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg AlarmEdgeProcessor.convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertAlarmCommentEventToDownlink_givenAdded_whenEdgeEventActionIsAdded() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link EdgeEvent#EdgeEvent()} Body is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); given Instance; when EdgeEvent() Body is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg AlarmEdgeProcessor.convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertAlarmCommentEventToDownlink_givenInstance_whenEdgeEventBodyIsInstance() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED_COMMENT);
    edgeEvent.setBody(MissingNode.getInstance());

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EdgeEvent#EdgeEvent()} Body is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); given 'null'; when EdgeEvent() Body is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg AlarmEdgeProcessor.convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertAlarmCommentEventToDownlink_givenNull_whenEdgeEventBodyIsNull() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED_COMMENT);
    edgeEvent.setBody(null);

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code UPDATED_COMMENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEdgeProcessor#convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion); given 'UPDATED_COMMENT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg AlarmEdgeProcessor.convertAlarmCommentEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertAlarmCommentEventToDownlink_givenUpdatedComment() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.UPDATED_COMMENT);
    edgeEvent.setBody(MissingNode.getInstance());

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmCommentEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }
}
