package org.thingsboard.server.common.msg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.msg.gen.MsgProtos;
import org.thingsboard.server.common.msg.gen.MsgProtos.TbMsgProcessingStackItemProto;

class TbMsgProcessingStackItemDiffblueTest {
  /**
   * Test {@link TbMsgProcessingStackItem#toProto()}.
   *
   * <ul>
   *   <li>Then return RuleChainIdLSB is {@code -7476899250389416711}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgProcessingStackItem#toProto()}
   */
  @Test
  @DisplayName("Test toProto(); then return RuleChainIdLSB is '-7476899250389416711'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MsgProtos.TbMsgProcessingStackItemProto TbMsgProcessingStackItem.toProto()"})
  void testToProto_thenReturnRuleChainIdLSBIs7476899250389416711() {
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsgProcessingStackItemProto actualToProtoResult =
        new TbMsgProcessingStackItem(
                ruleChainId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .toProto();

    // Assert
    assertEquals(-7476899250389416711L, actualToProtoResult.getRuleChainIdLSB());
    assertEquals(-7476899250389416711L, actualToProtoResult.getRuleNodeIdLSB());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertEquals(42, actualToProtoResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualToProtoResult.getRuleChainIdMSB());
    assertEquals(8669210807411032922L, actualToProtoResult.getRuleNodeIdMSB());
    assertTrue(actualToProtoResult.findInitializationErrors().isEmpty());
    assertTrue(actualToProtoResult.isInitialized());
    assertEquals(TbMsg.EMPTY_STRING, actualToProtoResult.getInitializationErrorString());
  }

  /**
   * Test {@link TbMsgProcessingStackItem#fromProto(TbMsgProcessingStackItemProto)}.
   *
   * <ul>
   *   <li>Then return RuleChainId Id toString is {@code 00000000-0000-0000-0000-000000000000}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbMsgProcessingStackItem#fromProto(MsgProtos.TbMsgProcessingStackItemProto)}
   */
  @Test
  @DisplayName(
      "Test fromProto(TbMsgProcessingStackItemProto); then return RuleChainId Id toString is '00000000-0000-0000-0000-000000000000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsgProcessingStackItem TbMsgProcessingStackItem.fromProto(MsgProtos.TbMsgProcessingStackItemProto)"
  })
  void testFromProto_thenReturnRuleChainIdIdToStringIs00000000000000000000000000000000() {
    // Arrange and Act
    TbMsgProcessingStackItem actualFromProtoResult =
        TbMsgProcessingStackItem.fromProto(TbMsgProcessingStackItemProto.getDefaultInstance());

    // Assert
    RuleChainId ruleChainId = actualFromProtoResult.getRuleChainId();
    assertEquals("00000000-0000-0000-0000-000000000000", ruleChainId.getId().toString());
    RuleNodeId ruleNodeId = actualFromProtoResult.getRuleNodeId();
    assertEquals("00000000-0000-0000-0000-000000000000", ruleNodeId.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    assertEquals(EntityType.RULE_NODE, ruleNodeId.getEntityType());
    assertFalse(ruleChainId.isNullUid());
    assertFalse(ruleNodeId.isNullUid());
  }

  /**
   * Test {@link TbMsgProcessingStackItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgProcessingStackItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMsgProcessingStackItem.equals(Object)",
    "int TbMsgProcessingStackItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        new TbMsgProcessingStackItem(
            ruleChainId, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))),
        "42");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgProcessingStackItem#TbMsgProcessingStackItem(RuleChainId, RuleNodeId)}
   *   <li>{@link TbMsgProcessingStackItem#toString()}
   *   <li>{@link TbMsgProcessingStackItem#getRuleChainId()}
   *   <li>{@link TbMsgProcessingStackItem#getRuleNodeId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbMsgProcessingStackItem.<init>(RuleChainId, RuleNodeId)",
    "RuleChainId TbMsgProcessingStackItem.getRuleChainId()",
    "RuleNodeId TbMsgProcessingStackItem.getRuleNodeId()",
    "String TbMsgProcessingStackItem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsgProcessingStackItem actualTbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(ruleChainId, ruleNodeId);
    String actualToStringResult = actualTbMsgProcessingStackItem.toString();
    RuleChainId actualRuleChainId = actualTbMsgProcessingStackItem.getRuleChainId();

    // Assert
    assertEquals(
        "TbMsgProcessingStackItem(ruleChainId=784f394c-42b6-435a-983c-b7beff2784f9, ruleNodeId=784f394c-42b6"
            + "-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertSame(ruleChainId, actualRuleChainId);
    assertSame(ruleNodeId, actualTbMsgProcessingStackItem.getRuleNodeId());
  }
}
