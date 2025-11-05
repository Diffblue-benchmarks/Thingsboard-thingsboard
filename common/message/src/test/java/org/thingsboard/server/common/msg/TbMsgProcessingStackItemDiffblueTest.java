package org.thingsboard.server.common.msg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MsgProtos.TbMsgProcessingStackItemProto TbMsgProcessingStackItem.toProto()"})
  void testToProto_thenReturnRuleChainIdLSBIs7476899250389416711() {
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(ruleChainId, ruleNodeId);

    // Act
    TbMsgProcessingStackItemProto actualToProtoResult = tbMsgProcessingStackItem.toProto();

    // Assert
    assertEquals(-7476899250389416711L, actualToProtoResult.getRuleChainIdLSB());
    assertEquals(-7476899250389416711L, actualToProtoResult.getRuleNodeIdLSB());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertEquals(42, actualToProtoResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualToProtoResult.getRuleChainIdMSB());
    assertEquals(8669210807411032922L, actualToProtoResult.getRuleNodeIdMSB());
    assertTrue(actualToProtoResult.findInitializationErrors().isEmpty());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link TbMsgProcessingStackItem#equals(Object)}, and {@link
   * TbMsgProcessingStackItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgProcessingStackItem#equals(Object)}
   *   <li>{@link TbMsgProcessingStackItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgProcessingStackItem.equals(Object)",
    "int TbMsgProcessingStackItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(ruleChainId, ruleNodeId);
    RuleChainId ruleChainId2 =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId2 =
        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgProcessingStackItem tbMsgProcessingStackItem2 =
        new TbMsgProcessingStackItem(ruleChainId2, ruleNodeId2);

    // Act and Assert
    assertEquals(tbMsgProcessingStackItem, tbMsgProcessingStackItem2);
    assertEquals(tbMsgProcessingStackItem.hashCode(), tbMsgProcessingStackItem2.hashCode());
  }

  /**
   * Test {@link TbMsgProcessingStackItem#equals(Object)}, and {@link
   * TbMsgProcessingStackItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgProcessingStackItem#equals(Object)}
   *   <li>{@link TbMsgProcessingStackItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgProcessingStackItem.equals(Object)",
    "int TbMsgProcessingStackItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(null, ruleNodeId);
    RuleNodeId ruleNodeId2 =
        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgProcessingStackItem tbMsgProcessingStackItem2 =
        new TbMsgProcessingStackItem(null, ruleNodeId2);

    // Act and Assert
    assertEquals(tbMsgProcessingStackItem, tbMsgProcessingStackItem2);
    assertEquals(tbMsgProcessingStackItem.hashCode(), tbMsgProcessingStackItem2.hashCode());
  }

  /**
   * Test {@link TbMsgProcessingStackItem#equals(Object)}, and {@link
   * TbMsgProcessingStackItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgProcessingStackItem#equals(Object)}
   *   <li>{@link TbMsgProcessingStackItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgProcessingStackItem.equals(Object)",
    "int TbMsgProcessingStackItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(ruleChainId, null);
    RuleChainId ruleChainId2 =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgProcessingStackItem tbMsgProcessingStackItem2 =
        new TbMsgProcessingStackItem(ruleChainId2, null);

    // Act and Assert
    assertEquals(tbMsgProcessingStackItem, tbMsgProcessingStackItem2);
    assertEquals(tbMsgProcessingStackItem.hashCode(), tbMsgProcessingStackItem2.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgProcessingStackItem.equals(Object)",
    "int TbMsgProcessingStackItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(ruleChainId, ruleNodeId);

    // Act and Assert
    assertNotEquals(tbMsgProcessingStackItem, "42");
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgProcessingStackItem.equals(Object)",
    "int TbMsgProcessingStackItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(ruleChainId, ruleNodeId);
    RuleChainId ruleChainId2 =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId2 =
        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgProcessingStackItem tbMsgProcessingStackItem2 =
        new TbMsgProcessingStackItem(ruleChainId2, ruleNodeId2);

    // Act and Assert
    assertNotEquals(tbMsgProcessingStackItem, tbMsgProcessingStackItem2);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgProcessingStackItem.equals(Object)",
    "int TbMsgProcessingStackItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(null, ruleNodeId);
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId2 =
        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgProcessingStackItem tbMsgProcessingStackItem2 =
        new TbMsgProcessingStackItem(ruleChainId, ruleNodeId2);

    // Act and Assert
    assertNotEquals(tbMsgProcessingStackItem, tbMsgProcessingStackItem2);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgProcessingStackItem.equals(Object)",
    "int TbMsgProcessingStackItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    RuleChainId ruleChainId2 =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgProcessingStackItem tbMsgProcessingStackItem2 =
        new TbMsgProcessingStackItem(ruleChainId2, ruleNodeId);

    // Act and Assert
    assertNotEquals(tbMsgProcessingStackItem, tbMsgProcessingStackItem2);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgProcessingStackItem.equals(Object)",
    "int TbMsgProcessingStackItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(ruleChainId, null);
    RuleChainId ruleChainId2 =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgProcessingStackItem tbMsgProcessingStackItem2 =
        new TbMsgProcessingStackItem(ruleChainId2, ruleNodeId);

    // Act and Assert
    assertNotEquals(tbMsgProcessingStackItem, tbMsgProcessingStackItem2);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
