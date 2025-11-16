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
package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.msg.TbMsg;

class TbAbstractTransformNodeDiffblueTest {
  /**
   * Test {@link TbAbstractTransformNode#transformFailure(TbContext, TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNode#transformFailure(TbContext, TbMsg,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test transformFailure(TbContext, TbMsg, Throwable); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractTransformNode.transformFailure(TbContext, TbMsg, Throwable)"})
  void testTransformFailure_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new RuntimeException())
        .when(ctx)
        .tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg = mock(TbMsg.class);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbChangeOriginatorNode.transformFailure(ctx, msg, new Throwable()));
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractTransformNode#transformFailure(TbContext, TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNode#transformFailure(TbContext, TbMsg,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test transformFailure(TbContext, TbMsg, Throwable); when TbContext tellFailure(TbMsg, Throwable) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractTransformNode.transformFailure(TbContext, TbMsg, Throwable)"})
  void testTransformFailure_whenTbContextTellFailureDoesNothing() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg = mock(TbMsg.class);

    // Act
    tbChangeOriginatorNode.transformFailure(ctx, msg, new Throwable());

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}
   */
  @Test
  @DisplayName(
      "Test transformSuccess(TbContext, TbMsg, List); when 'null'; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractTransformNode.transformSuccess(TbContext, TbMsg, List)"})
  void testTransformSuccess_whenNull_thenCallsTellFailure() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbChangeOriginatorNode.transformSuccess(ctx, mock(TbMsg.class), null);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} does nothing.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}
   */
  @Test
  @DisplayName(
      "Test transformSuccess(TbContext, TbMsg, List); when TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractTransformNode.transformSuccess(TbContext, TbMsg, List)"})
  void testTransformSuccess_whenTbContextTellFailureDoesNothing_thenCallsTellFailure() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg = mock(TbMsg.class);

    // Act
    tbChangeOriginatorNode.transformSuccess(ctx, msg, new ArrayList<>());

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}
   */
  @Test
  @DisplayName(
      "Test transformSuccess(TbContext, TbMsg, List); when TbContext tellFailure(TbMsg, Throwable) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractTransformNode.transformSuccess(TbContext, TbMsg, List)"})
  void testTransformSuccess_whenTbContextTellFailureThrowRuntimeException() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new RuntimeException())
        .when(ctx)
        .tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg = mock(TbMsg.class);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbChangeOriginatorNode.transformSuccess(ctx, msg, new ArrayList<>()));
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellSuccess(TbMsg)} does nothing.
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}
   */
  @Test
  @DisplayName(
      "Test transformSuccess(TbContext, TbMsg, List); when TbContext tellSuccess(TbMsg) does nothing; then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractTransformNode.transformSuccess(TbContext, TbMsg, List)"})
  void testTransformSuccess_whenTbContextTellSuccessDoesNothing_thenCallsTellSuccess() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg = mock(TbMsg.class);

    ArrayList<TbMsg> msgs = new ArrayList<>();
    msgs.add(mock(TbMsg.class));

    // Act
    tbChangeOriginatorNode.transformSuccess(ctx, msg, msgs);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellSuccess(TbMsg)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}
   */
  @Test
  @DisplayName(
      "Test transformSuccess(TbContext, TbMsg, List); when TbContext tellSuccess(TbMsg) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractTransformNode.transformSuccess(TbContext, TbMsg, List)"})
  void testTransformSuccess_whenTbContextTellSuccessThrowRuntimeException() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new RuntimeException()).when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg = mock(TbMsg.class);

    ArrayList<TbMsg> msgs = new ArrayList<>();
    msgs.add(mock(TbMsg.class));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbChangeOriginatorNode.transformSuccess(ctx, msg, msgs));
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }
}
