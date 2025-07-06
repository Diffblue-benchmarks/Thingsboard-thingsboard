package org.thingsboard.server.common.msg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.msg.gen.MsgProtos;
import org.thingsboard.server.common.msg.gen.MsgProtos.TbMsgProcessingCtxProto;
import org.thingsboard.server.common.msg.gen.MsgProtos.TbMsgProcessingStackItemProto;

class TbMsgProcessingCtxDiffblueTest {
  /**
   * Test {@link TbMsgProcessingCtx#pop()}.
   *
   * <p>Method under test: {@link TbMsgProcessingCtx#pop()}
   */
  @Test
  @DisplayName("Test pop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItem TbMsgProcessingCtx.pop()"})
  void testPop() {
    // Arrange
    TbMsgProcessingCtx tbMsgProcessingCtx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbMsgProcessingCtx.push(ruleChainId, ruleNodeId);

    // Act
    TbMsgProcessingStackItem actualPopResult = tbMsgProcessingCtx.pop();

    // Assert
    assertSame(ruleChainId, actualPopResult.getRuleChainId());
    assertSame(ruleNodeId, actualPopResult.getRuleNodeId());
  }

  /**
   * Test {@link TbMsgProcessingCtx#pop()}.
   *
   * <ul>
   *   <li>Given {@link TbMsgProcessingCtx#TbMsgProcessingCtx()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgProcessingCtx#pop()}
   */
  @Test
  @DisplayName("Test pop(); given TbMsgProcessingCtx(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItem TbMsgProcessingCtx.pop()"})
  void testPop_givenTbMsgProcessingCtx_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TbMsgProcessingCtx().pop());
  }

  /**
   * Test {@link TbMsgProcessingCtx#toProto()}.
   *
   * <ul>
   *   <li>Given {@link TbMsgProcessingCtx#TbMsgProcessingCtx()}.
   *   <li>Then return SerializedSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgProcessingCtx#toProto()}
   */
  @Test
  @DisplayName("Test toProto(); given TbMsgProcessingCtx(); then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtx.toProto()"})
  void testToProto_givenTbMsgProcessingCtx_thenReturnSerializedSizeIsZero() {
    // Arrange and Act
    TbMsgProcessingCtxProto actualToProtoResult = new TbMsgProcessingCtx().toProto();

    // Assert
    assertEquals(0, actualToProtoResult.getSerializedSize());
    assertEquals(0, actualToProtoResult.getStackCount());
    assertTrue(actualToProtoResult.getStackList().isEmpty());
    assertTrue(actualToProtoResult.getAllFields().isEmpty());
    assertEquals(actualToProtoResult, actualToProtoResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link TbMsgProcessingCtx#toProto()}.
   *
   * <ul>
   *   <li>Then return StackList size is one.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgProcessingCtx#toProto()}
   */
  @Test
  @DisplayName("Test toProto(); then return StackList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtx.toProto()"})
  void testToProto_thenReturnStackListSizeIsOne() {
    // Arrange
    TbMsgProcessingCtx tbMsgProcessingCtx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbMsgProcessingCtx.push(
        ruleChainId, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TbMsgProcessingCtxProto actualToProtoResult = tbMsgProcessingCtx.toProto();

    // Assert
    assertEquals(1, actualToProtoResult.getStackList().size());
    assertEquals(1, actualToProtoResult.getAllFields().size());
    assertEquals(1, actualToProtoResult.getStackCount());
    assertEquals(44, actualToProtoResult.getSerializedSize());
    TbMsgProcessingCtxProto defaultInstanceForType =
        actualToProtoResult.getDefaultInstanceForType();
    List<TbMsgProcessingStackItemProto> stackList = defaultInstanceForType.getStackList();
    assertTrue(stackList.isEmpty());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(stackList, defaultInstanceForType.getStackOrBuilderList());
  }
}
