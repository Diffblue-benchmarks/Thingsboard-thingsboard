package org.thingsboard.server.service.edge.rpc.constructor.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.gen.edge.v1.AlarmCommentUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class BaseAlarmMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseAlarmMsgConstructor#constructAlarmCommentUpdatedMsg(UpdateMsgType,
   * AlarmComment)}.
   *
   * <p>Method under test: {@link
   * BaseAlarmMsgConstructor#constructAlarmCommentUpdatedMsg(UpdateMsgType, AlarmComment)}
   */
  @Test
  @DisplayName("Test constructAlarmCommentUpdatedMsg(UpdateMsgType, AlarmComment)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AlarmCommentUpdateMsg BaseAlarmMsgConstructor.constructAlarmCommentUpdatedMsg(UpdateMsgType, AlarmComment)"
  })
  void testConstructAlarmCommentUpdatedMsg() {
    // Arrange
    AlarmMsgConstructorV1 alarmMsgConstructorV1 = new AlarmMsgConstructorV1();

    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(DoubleNode.valueOf(10.0d));

    // Act
    AlarmCommentUpdateMsg actualConstructAlarmCommentUpdatedMsgResult =
        alarmMsgConstructorV1.constructAlarmCommentUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, alarmComment);

    // Assert
    assertEquals("", actualConstructAlarmCommentUpdatedMsgResult.getInitializationErrorString());
    assertEquals(
        "{\"alarmId\":null,\"userId\":null,\"type\":null,\"comment\":10.0,\"id\":null,\"createdTime\":0,\"name\":\"10.0\"}",
        actualConstructAlarmCommentUpdatedMsgResult.getEntity());
    assertEquals(0, actualConstructAlarmCommentUpdatedMsgResult.getMsgTypeValue());
    assertEquals(1, actualConstructAlarmCommentUpdatedMsgResult.getAllFields().size());
    assertEquals(99, actualConstructAlarmCommentUpdatedMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructAlarmCommentUpdatedMsgResult.getMsgType());
    assertTrue(actualConstructAlarmCommentUpdatedMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructAlarmCommentUpdatedMsgResult.isInitialized());
  }
}
