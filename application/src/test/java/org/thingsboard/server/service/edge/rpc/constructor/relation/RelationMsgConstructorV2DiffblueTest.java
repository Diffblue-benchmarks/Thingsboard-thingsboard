package org.thingsboard.server.service.edge.rpc.constructor.relation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.gen.edge.v1.RelationUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class RelationMsgConstructorV2DiffblueTest {
  /**
   * Test {@link RelationMsgConstructorV2#constructRelationUpdatedMsg(UpdateMsgType,
   * EntityRelation)}.
   *
   * <ul>
   *   <li>Then return MsgTypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RelationMsgConstructorV2#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}
   */
  @Test
  @DisplayName(
      "Test constructRelationUpdatedMsg(UpdateMsgType, EntityRelation); then return MsgTypeValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RelationUpdateMsg RelationMsgConstructorV2.constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)"
  })
  void testConstructRelationUpdatedMsg_thenReturnMsgTypeValueIsOne() {
    // Arrange
    RelationMsgConstructorV2 relationMsgConstructorV2 = new RelationMsgConstructorV2();

    // Act
    RelationUpdateMsg actualConstructRelationUpdatedMsgResult =
        relationMsgConstructorV2.constructRelationUpdatedMsg(
            UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, new EntityRelation());

    // Assert
    assertEquals(1, actualConstructRelationUpdatedMsgResult.getMsgTypeValue());
    assertEquals(2, actualConstructRelationUpdatedMsgResult.getAllFields().size());
    assertEquals(93, actualConstructRelationUpdatedMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE,
        actualConstructRelationUpdatedMsgResult.getMsgType());
  }

  /**
   * Test {@link RelationMsgConstructorV2#constructRelationUpdatedMsg(UpdateMsgType,
   * EntityRelation)}.
   *
   * <ul>
   *   <li>Then return MsgTypeValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * RelationMsgConstructorV2#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}
   */
  @Test
  @DisplayName(
      "Test constructRelationUpdatedMsg(UpdateMsgType, EntityRelation); then return MsgTypeValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RelationUpdateMsg RelationMsgConstructorV2.constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)"
  })
  void testConstructRelationUpdatedMsg_thenReturnMsgTypeValueIsZero() {
    // Arrange
    RelationMsgConstructorV2 relationMsgConstructorV2 = new RelationMsgConstructorV2();

    // Act
    RelationUpdateMsg actualConstructRelationUpdatedMsgResult =
        relationMsgConstructorV2.constructRelationUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, new EntityRelation());

    // Assert
    assertEquals(0, actualConstructRelationUpdatedMsgResult.getMsgTypeValue());
    assertEquals(1, actualConstructRelationUpdatedMsgResult.getAllFields().size());
    assertEquals(91, actualConstructRelationUpdatedMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructRelationUpdatedMsgResult.getMsgType());
  }
}
