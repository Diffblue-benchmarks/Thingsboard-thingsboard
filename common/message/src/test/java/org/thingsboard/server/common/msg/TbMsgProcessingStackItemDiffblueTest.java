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
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.msg.gen.MsgProtos;

class TbMsgProcessingStackItemDiffblueTest {
  /**
   * Method under test: {@link TbMsgProcessingStackItem#toProto()}
   */
  @Test
  void testToProto() {
    // Arrange
    MsgProtos.TbMsgProcessingStackItemProto item = MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance();

    // Act and Assert
    assertEquals(item, TbMsgProcessingStackItem.fromProto(item).toProto());
  }

  /**
   * Method under test:
   * {@link TbMsgProcessingStackItem#fromProto(MsgProtos.TbMsgProcessingStackItemProto)}
   */
  @Test
  void testFromProto() {
    // Arrange and Act
    TbMsgProcessingStackItem actualFromProtoResult = TbMsgProcessingStackItem
        .fromProto(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance());

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
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgProcessingStackItem#equals(Object)}
   *   <li>{@link TbMsgProcessingStackItem#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgProcessingStackItem fromProtoResult = TbMsgProcessingStackItem
        .fromProto(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance());
    TbMsgProcessingStackItem fromProtoResult2 = TbMsgProcessingStackItem
        .fromProto(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance());

    // Act and Assert
    assertEquals(fromProtoResult, fromProtoResult2);
    int expectedHashCodeResult = fromProtoResult.hashCode();
    assertEquals(expectedHashCodeResult, fromProtoResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgProcessingStackItem#equals(Object)}
   *   <li>{@link TbMsgProcessingStackItem#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgProcessingStackItem fromProtoResult = TbMsgProcessingStackItem
        .fromProto(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance());

    // Act and Assert
    assertEquals(fromProtoResult, fromProtoResult);
    int expectedHashCodeResult = fromProtoResult.hashCode();
    assertEquals(expectedHashCodeResult, fromProtoResult.hashCode());
  }

  /**
   * Method under test: {@link TbMsgProcessingStackItem#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    TbMsgProcessingStackItem tbMsgProcessingStackItem = new TbMsgProcessingStackItem(ruleChainId,
        new RuleNodeId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(tbMsgProcessingStackItem,
        TbMsgProcessingStackItem.fromProto(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance()));
  }

  /**
   * Method under test: {@link TbMsgProcessingStackItem#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgProcessingStackItem.fromProto(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance()),
        mock(AdminSettingsId.class));
  }

  /**
   * Method under test: {@link TbMsgProcessingStackItem#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMsgProcessingStackItem tbMsgProcessingStackItem = new TbMsgProcessingStackItem(null,
        new RuleNodeId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(tbMsgProcessingStackItem,
        TbMsgProcessingStackItem.fromProto(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance()));
  }

  /**
   * Method under test: {@link TbMsgProcessingStackItem#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgProcessingStackItem.fromProto(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance()),
        null);
  }

  /**
   * Method under test: {@link TbMsgProcessingStackItem#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgProcessingStackItem.fromProto(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance()),
        "Different type to TbMsgProcessingStackItem");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbMsgProcessingStackItem#TbMsgProcessingStackItem(RuleChainId, RuleNodeId)}
   *   <li>{@link TbMsgProcessingStackItem#toString()}
   *   <li>{@link TbMsgProcessingStackItem#getRuleChainId()}
   *   <li>{@link TbMsgProcessingStackItem#getRuleNodeId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    TbMsgProcessingStackItem actualTbMsgProcessingStackItem = new TbMsgProcessingStackItem(ruleChainId, ruleNodeId);
    actualTbMsgProcessingStackItem.toString();
    RuleChainId actualRuleChainId = actualTbMsgProcessingStackItem.getRuleChainId();

    // Assert
    assertSame(ruleChainId, actualRuleChainId);
    assertSame(ruleNodeId, actualTbMsgProcessingStackItem.getRuleNodeId());
  }
}
