package org.thingsboard.server.service.edge.rpc.constructor.entityview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.EntityViewInfo;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.gen.edge.v1.EntityViewUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class EntityViewMsgConstructorV2DiffblueTest {
  /**
   * Test {@link EntityViewMsgConstructorV2#constructEntityViewUpdatedMsg(UpdateMsgType,
   * EntityView)}.
   *
   * <ul>
   *   <li>Then return MsgTypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewMsgConstructorV2#constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)}
   */
  @Test
  @DisplayName(
      "Test constructEntityViewUpdatedMsg(UpdateMsgType, EntityView); then return MsgTypeValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityViewUpdateMsg EntityViewMsgConstructorV2.constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)"
  })
  void testConstructEntityViewUpdatedMsg_thenReturnMsgTypeValueIsOne() {
    // Arrange
    EntityViewMsgConstructorV2 entityViewMsgConstructorV2 = new EntityViewMsgConstructorV2();

    // Act
    EntityViewUpdateMsg actualConstructEntityViewUpdatedMsgResult =
        entityViewMsgConstructorV2.constructEntityViewUpdatedMsg(
            UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE,
            new EntityViewInfo(
                new EntityViewId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Assert
    assertEquals(1, actualConstructEntityViewUpdatedMsgResult.getMsgTypeValue());
    assertEquals(338, actualConstructEntityViewUpdatedMsgResult.getSerializedSize());
    assertEquals(4, actualConstructEntityViewUpdatedMsgResult.getAllFields().size());
    assertEquals(
        UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE,
        actualConstructEntityViewUpdatedMsgResult.getMsgType());
    UnknownFieldSet unknownFields = actualConstructEntityViewUpdatedMsgResult.getUnknownFields();
    EntityViewUpdateMsg defaultInstanceForType =
        actualConstructEntityViewUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link EntityViewMsgConstructorV2#constructEntityViewUpdatedMsg(UpdateMsgType,
   * EntityView)}.
   *
   * <ul>
   *   <li>Then return MsgTypeValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityViewMsgConstructorV2#constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)}
   */
  @Test
  @DisplayName(
      "Test constructEntityViewUpdatedMsg(UpdateMsgType, EntityView); then return MsgTypeValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityViewUpdateMsg EntityViewMsgConstructorV2.constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)"
  })
  void testConstructEntityViewUpdatedMsg_thenReturnMsgTypeValueIsZero() {
    // Arrange
    EntityViewMsgConstructorV2 entityViewMsgConstructorV2 = new EntityViewMsgConstructorV2();

    // Act
    EntityViewUpdateMsg actualConstructEntityViewUpdatedMsgResult =
        entityViewMsgConstructorV2.constructEntityViewUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
            new EntityViewInfo(
                new EntityViewId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Assert
    assertEquals(0, actualConstructEntityViewUpdatedMsgResult.getMsgTypeValue());
    assertEquals(3, actualConstructEntityViewUpdatedMsgResult.getAllFields().size());
    assertEquals(336, actualConstructEntityViewUpdatedMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructEntityViewUpdatedMsgResult.getMsgType());
    UnknownFieldSet unknownFields = actualConstructEntityViewUpdatedMsgResult.getUnknownFields();
    EntityViewUpdateMsg defaultInstanceForType =
        actualConstructEntityViewUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }
}
