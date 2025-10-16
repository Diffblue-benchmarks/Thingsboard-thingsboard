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
package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;

class TbMsgTypeSwitchNodeDiffblueTest {
  /**
   * Test {@link TbMsgTypeSwitchNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMsgTypeSwitchNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTypeSwitchNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() {
    // Arrange
    TbMsgTypeSwitchNode tbMsgTypeSwitchNode = new TbMsgTypeSwitchNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getInternalType()).thenReturn(TbMsgType.POST_ATTRIBUTES_REQUEST);

    // Act
    tbMsgTypeSwitchNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Post attributes"));
    verify(msg).getInternalType();
  }

  /**
   * Test new {@link TbMsgTypeSwitchNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbMsgTypeSwitchNode}
   */
  @Test
  @DisplayName("Test new TbMsgTypeSwitchNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTypeSwitchNode.<init>()"})
  void testNewTbMsgTypeSwitchNode() {
    // Arrange, Act and Assert
    assertNull(new TbMsgTypeSwitchNode().config);
  }
}
