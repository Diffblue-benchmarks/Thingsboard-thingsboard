package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.msg.TbMsg;

class TbAbstractTransformNodeDiffblueTest {
  /**
   * Test
   * {@link TbAbstractTransformNode#transformFailure(TbContext, TbMsg, Throwable)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractTransformNode#transformFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test transformFailure(TbContext, TbMsg, Throwable); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testTransformFailure_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = mock(TbContext.class);
    doThrow(new RuntimeException("foo")).when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbChangeOriginatorNode.transformFailure(ctx, null, new Throwable()));
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }

  /**
   * Test
   * {@link TbAbstractTransformNode#transformFailure(TbContext, TbMsg, Throwable)}.
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)}
   * does nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractTransformNode#transformFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test transformFailure(TbContext, TbMsg, Throwable); when TbContext tellFailure(TbMsg, Throwable) does nothing")
  void testTransformFailure_whenTbContextTellFailureDoesNothing() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbChangeOriginatorNode.transformFailure(ctx, null, new Throwable());

    // Assert
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }

  /**
   * Test
   * {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}
   */
  @Test
  @DisplayName("Test transformSuccess(TbContext, TbMsg, List); given RuntimeException(String) with 'foo'")
  void testTransformSuccess_givenRuntimeExceptionWithFoo() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = mock(TbContext.class);
    doThrow(new RuntimeException("foo")).when(ctx).tellSuccess(Mockito.<TbMsg>any());

    ArrayList<TbMsg> msgs = new ArrayList<>();
    msgs.add(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbChangeOriginatorNode.transformSuccess(ctx, null, msgs));
    verify(ctx).tellSuccess(isNull());
  }

  /**
   * Test
   * {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code Message or messages list are empty!}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}
   */
  @Test
  @DisplayName("Test transformSuccess(TbContext, TbMsg, List); given RuntimeException(String) with 'Message or messages list are empty!'")
  void testTransformSuccess_givenRuntimeExceptionWithMessageOrMessagesListAreEmpty() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = mock(TbContext.class);
    doThrow(new RuntimeException("Message or messages list are empty!")).when(ctx)
        .tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbChangeOriginatorNode.transformSuccess(ctx, null, new ArrayList<>()));
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }

  /**
   * Test
   * {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}.
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)}
   * does nothing.</li>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}
   */
  @Test
  @DisplayName("Test transformSuccess(TbContext, TbMsg, List); when TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  void testTransformSuccess_whenTbContextTellFailureDoesNothing_thenCallsTellFailure() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbChangeOriginatorNode.transformSuccess(ctx, null, new ArrayList<>());

    // Assert
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }

  /**
   * Test
   * {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}.
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)}
   * does nothing.</li>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}
   */
  @Test
  @DisplayName("Test transformSuccess(TbContext, TbMsg, List); when TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  void testTransformSuccess_whenTbContextTellFailureDoesNothing_thenCallsTellFailure2() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbChangeOriginatorNode.transformSuccess(ctx, null, null);

    // Assert
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }

  /**
   * Test
   * {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}.
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellSuccess(TbMsg)} does
   * nothing.</li>
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}
   */
  @Test
  @DisplayName("Test transformSuccess(TbContext, TbMsg, List); when TbContext tellSuccess(TbMsg) does nothing; then calls tellSuccess(TbMsg)")
  void testTransformSuccess_whenTbContextTellSuccessDoesNothing_thenCallsTellSuccess() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    ArrayList<TbMsg> msgs = new ArrayList<>();
    msgs.add(null);

    // Act
    tbChangeOriginatorNode.transformSuccess(ctx, null, msgs);

    // Assert
    verify(ctx).tellSuccess(isNull());
  }
}
