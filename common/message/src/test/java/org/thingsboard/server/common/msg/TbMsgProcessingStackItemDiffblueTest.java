/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.
   *   <li>Then return AllFields size is four.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgProcessingStackItem#toProto()}
   */
  @Test
  @DisplayName(
      "Test toProto(); given RuleChainId(UUID) with id is randomUUID; then return AllFields size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MsgProtos.TbMsgProcessingStackItemProto TbMsgProcessingStackItem.toProto()"})
  void testToProto_givenRuleChainIdWithIdIsRandomUUID_thenReturnAllFieldsSizeIsFour() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(ruleChainId, new RuleNodeId(UUID.randomUUID()));

    // Act
    TbMsgProcessingStackItemProto actualToProtoResult = tbMsgProcessingStackItem.toProto();

    // Assert
    assertEquals(4, actualToProtoResult.getAllFields().size());
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
    TbMsgProcessingStackItem tbMsgProcessingStackItem = new TbMsgProcessingStackItem(null, null);
    TbMsgProcessingStackItem tbMsgProcessingStackItem2 = new TbMsgProcessingStackItem(null, null);

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
    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(null, new RuleNodeId(null));
    TbMsgProcessingStackItem tbMsgProcessingStackItem2 =
        new TbMsgProcessingStackItem(null, new RuleNodeId(null));

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
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(ruleChainId, new RuleNodeId(UUID.randomUUID()));

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
    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    RuleChainId ruleChainId2 = new RuleChainId(UUID.randomUUID());
    TbMsgProcessingStackItem tbMsgProcessingStackItem2 =
        new TbMsgProcessingStackItem(ruleChainId2, new RuleNodeId(UUID.randomUUID()));

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
    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(null, new RuleNodeId(UUID.randomUUID()));
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    TbMsgProcessingStackItem tbMsgProcessingStackItem2 =
        new TbMsgProcessingStackItem(ruleChainId, new RuleNodeId(UUID.randomUUID()));

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
    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(null, new RuleNodeId(UUID.randomUUID()));
    TbMsgProcessingStackItem tbMsgProcessingStackItem2 =
        new TbMsgProcessingStackItem(null, new RuleNodeId(UUID.randomUUID()));

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
    TbMsgProcessingStackItem tbMsgProcessingStackItem = new TbMsgProcessingStackItem(null, null);
    TbMsgProcessingStackItem tbMsgProcessingStackItem2 =
        new TbMsgProcessingStackItem(null, new RuleNodeId(UUID.randomUUID()));

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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(null);
    TbMsgProcessingStackItem tbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    RuleChainId ruleChainId2 = new RuleChainId(null);
    TbMsgProcessingStackItem tbMsgProcessingStackItem2 =
        new TbMsgProcessingStackItem(ruleChainId2, new RuleNodeId(UUID.randomUUID()));

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
    "java.lang.String TbMsgProcessingStackItem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    TbMsgProcessingStackItem actualTbMsgProcessingStackItem =
        new TbMsgProcessingStackItem(ruleChainId, ruleNodeId);
    actualTbMsgProcessingStackItem.toString();
    RuleChainId actualRuleChainId = actualTbMsgProcessingStackItem.getRuleChainId();

    // Assert
    assertSame(ruleChainId, actualRuleChainId);
    assertSame(ruleNodeId, actualTbMsgProcessingStackItem.getRuleNodeId());
  }
}
