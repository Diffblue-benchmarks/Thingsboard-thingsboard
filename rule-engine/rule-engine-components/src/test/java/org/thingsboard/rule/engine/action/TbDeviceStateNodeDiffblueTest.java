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
package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.msg.TbMsg;

class TbDeviceStateNodeDiffblueTest {
  /**
   * Test {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given AlarmId(UUID) with id is randomUUID; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceStateNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenAlarmIdWithIdIsRandomUUID_thenCallsTellFailure() {
    // Arrange
    TbDeviceStateNode tbDeviceStateNode = new TbDeviceStateNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    tbDeviceStateNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext tellFailure(TbMsg, Throwable) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceStateNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextTellFailureThrowIllegalArgumentException() {
    // Arrange
    TbDeviceStateNode tbDeviceStateNode = new TbDeviceStateNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new IllegalArgumentException())
        .when(ctx)
        .tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceStateNode.onMsg(ctx, msg));
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getOriginator()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbMsg getOriginator() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceStateNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsgGetOriginatorThrowIllegalArgumentException() {
    // Arrange
    TbDeviceStateNode tbDeviceStateNode = new TbDeviceStateNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceStateNode.onMsg(ctx, msg));
    verify(msg).getOriginator();
  }
}
