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
package org.thingsboard.rule.engine.delay;

import static org.junit.jupiter.api.Assertions.assertThrows;
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

class TbMsgDelayNodeDiffblueTest {
  /**
   * Test {@link TbMsgDelayNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbMsg getData() throw RuntimeException(); then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDelayNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsgGetDataThrowRuntimeException_thenCallsGetData() {
    // Arrange
    TbMsgDelayNode tbMsgDelayNode = new TbMsgDelayNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new RuntimeException());
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgDelayNode.onMsg(ctx, msg));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.DELAY_TIMEOUT_SELF_MSG);
  }

  /**
   * Test {@link TbMsgDelayNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOf(TbMsgType)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbMsg isTypeOf(TbMsgType) throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDelayNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsgIsTypeOfThrowRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TbMsgDelayNode tbMsgDelayNode = new TbMsgDelayNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgDelayNode.onMsg(ctx, msg));
    verify(msg).isTypeOf(TbMsgType.DELAY_TIMEOUT_SELF_MSG);
  }
}
