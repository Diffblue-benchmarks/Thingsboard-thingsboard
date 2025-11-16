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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * <ul>
   *   <li>Given {@link TbMsgProcessingCtx#TbMsgProcessingCtx()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgProcessingCtx#pop()}
   */
  @Test
  @DisplayName("Test pop(); given TbMsgProcessingCtx(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsgProcessingStackItem TbMsgProcessingCtx.pop()"})
  void testPop_givenTbMsgProcessingCtx_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TbMsgProcessingCtx().pop());
  }

  /**
   * Test {@link TbMsgProcessingCtx#pop()}.
   *
   * <ul>
   *   <li>Then return RuleChainId is {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgProcessingCtx#pop()}
   */
  @Test
  @DisplayName("Test pop(); then return RuleChainId is RuleChainId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsgProcessingStackItem TbMsgProcessingCtx.pop()"})
  void testPop_thenReturnRuleChainIdIsRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx tbMsgProcessingCtx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    tbMsgProcessingCtx.push(ruleChainId, ruleNodeId);

    // Act
    TbMsgProcessingStackItem actualPopResult = tbMsgProcessingCtx.pop();

    // Assert
    assertSame(ruleChainId, actualPopResult.getRuleChainId());
    assertSame(ruleNodeId, actualPopResult.getRuleNodeId());
  }

  /**
   * Test {@link TbMsgProcessingCtx#toProto()}.
   *
   * <p>Method under test: {@link TbMsgProcessingCtx#toProto()}
   */
  @Test
  @DisplayName("Test toProto()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtx.toProto()"})
  void testToProto() {
    // Arrange
    TbMsgProcessingCtx tbMsgProcessingCtx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    tbMsgProcessingCtx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));

    // Act
    TbMsgProcessingCtxProto actualToProtoResult = tbMsgProcessingCtx.toProto();

    // Assert
    assertEquals(1, actualToProtoResult.getStackList().size());
    assertEquals(1, actualToProtoResult.getAllFields().size());
    assertEquals(1, actualToProtoResult.getStackCount());
    TbMsgProcessingCtxProto defaultInstanceForType =
        actualToProtoResult.getDefaultInstanceForType();
    List<TbMsgProcessingStackItemProto> stackList = defaultInstanceForType.getStackList();
    assertTrue(stackList.isEmpty());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(stackList, defaultInstanceForType.getStackOrBuilderList());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtx.toProto()"})
  void testToProto_givenTbMsgProcessingCtx_thenReturnSerializedSizeIsZero() {
    // Arrange and Act
    TbMsgProcessingCtxProto actualToProtoResult = new TbMsgProcessingCtx().toProto();

    // Assert
    assertEquals(0, actualToProtoResult.getSerializedSize());
    assertEquals(0, actualToProtoResult.getStackCount());
    assertTrue(actualToProtoResult.getStackList().isEmpty());
    assertTrue(actualToProtoResult.getAllFields().isEmpty());
    TbMsgProcessingCtxProto actualDefaultInstanceForType =
        actualToProtoResult.getDefaultInstanceForType();
    assertEquals(actualToProtoResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link TbMsgProcessingCtx#toProto()}.
   *
   * <ul>
   *   <li>Given {@link UUID#UUID(long, long)} with one and one.
   *   <li>Then return StackList size is one.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgProcessingCtx#toProto()}
   */
  @Test
  @DisplayName(
      "Test toProto(); given UUID(long, long) with one and one; then return StackList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtx.toProto()"})
  void testToProto_givenUuidWithOneAndOne_thenReturnStackListSizeIsOne() {
    // Arrange
    TbMsgProcessingCtx tbMsgProcessingCtx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(new UUID(1L, 1L));
    tbMsgProcessingCtx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));

    // Act
    TbMsgProcessingCtxProto actualToProtoResult = tbMsgProcessingCtx.toProto();

    // Assert
    assertEquals(1, actualToProtoResult.getStackList().size());
    assertEquals(1, actualToProtoResult.getAllFields().size());
    assertEquals(1, actualToProtoResult.getStackCount());
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
