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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbCheckMessageNodeDiffblueTest {
  @Mock private List<String> list;

  @InjectMocks private TbCheckMessageNode tbCheckMessageNode;

  @Mock private TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration;

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code 42}.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given '42'; when TbMsg getData() return '42'; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_given42_whenTbMsgGetDataReturn42_thenCallsGetData() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(true);
    when(list.isEmpty()).thenReturn(false);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");

    // Act
    tbCheckMessageNode.onMsg(ctx, msg);

    // Assert
    verify(list).isEmpty();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
    verify(msg).getData();
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given ArrayList() add '42'; then calls iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenArrayListAdd42_thenCallsIterator() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(true);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    Iterator<String> iteratorResult = stringList.iterator();
    when(list.isEmpty()).thenReturn(false);
    when(list.iterator()).thenReturn(iteratorResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("");

    // Act
    tbCheckMessageNode.onMsg(ctx, msg);

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
    verify(msg).getData();
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given ArrayList() add 'foo'; then calls iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenArrayListAddFoo_thenCallsIterator() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(false);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    Iterator<String> iteratorResult = stringList.iterator();
    when(list.isEmpty()).thenReturn(false);
    when(list.iterator()).thenReturn(iteratorResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("");

    // Act
    tbCheckMessageNode.onMsg(ctx, msg);

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
    verify(msg).getData();
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'Data'; when TbMsg getData() return 'Data'; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenData_whenTbMsgGetDataReturnData_thenCallsGetData() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(true);
    when(list.isEmpty()).thenReturn(false);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");

    // Act
    tbCheckMessageNode.onMsg(ctx, msg);

    // Assert
    verify(list).isEmpty();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
    verify(msg).getData();
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'Data'; when TbMsg getData() return 'Data'; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenData_whenTbMsgGetDataReturnData_thenCallsGetData2() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(false);
    when(list.isEmpty()).thenReturn(false);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");

    // Act
    tbCheckMessageNode.onMsg(ctx, msg);

    // Assert
    verify(list).isEmpty();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
    verify(msg).getData();
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code foo}.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'foo'; when TbMsg getData() return 'foo'; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenFoo_whenTbMsgGetDataReturnFoo_thenCallsGetData() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(true);
    when(list.isEmpty()).thenReturn(false);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("foo");

    // Act
    tbCheckMessageNode.onMsg(ctx, msg);

    // Assert
    verify(list).isEmpty();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
    verify(msg).getData();
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#isEmpty()} return {@code true}.
   *   <li>When {@link TbMsg}.
   *   <li>Then calls {@link List#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given List isEmpty() return 'true'; when TbMsg; then calls isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListIsEmptyReturnTrue_whenTbMsg_thenCallsIsEmpty() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(true);
    when(list.isEmpty()).thenReturn(true);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbCheckMessageNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(list).isEmpty();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#isEmpty()} return {@code true}.
   *   <li>When {@link TbMsg}.
   *   <li>Then calls {@link List#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given List isEmpty() return 'true'; when TbMsg; then calls isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListIsEmptyReturnTrue_whenTbMsg_thenCallsIsEmpty2() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(false);
    when(list.isEmpty()).thenReturn(true);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbCheckMessageNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(list).isEmpty();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#isEmpty()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>When {@link TbMsg}.
   *   <li>Then calls {@link List#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given List isEmpty() throw RuntimeException(); when TbMsg; then calls isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListIsEmptyThrowRuntimeException_whenTbMsg_thenCallsIsEmpty() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(true);
    when(list.isEmpty()).thenThrow(new RuntimeException());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbCheckMessageNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(list).isEmpty();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#isEmpty()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>When {@link TbMsg}.
   *   <li>Then calls {@link List#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given List isEmpty() throw RuntimeException(); when TbMsg; then calls isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListIsEmptyThrowRuntimeException_whenTbMsg_thenCallsIsEmpty2() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(false);
    when(list.isEmpty()).thenThrow(new RuntimeException());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbCheckMessageNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(list).isEmpty();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#iterator()} return {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given List iterator() return ArrayList() iterator; then calls iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListIteratorReturnArrayListIterator_thenCallsIterator() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(true);
    when(list.isEmpty()).thenReturn(false);

    ArrayList<String> stringList = new ArrayList<>();
    when(list.iterator()).thenReturn(stringList.iterator());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("");

    // Act
    tbCheckMessageNode.onMsg(ctx, msg);

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
    verify(msg).getData();
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#iterator()} return {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given List iterator() return ArrayList() iterator; then calls iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListIteratorReturnArrayListIterator_thenCallsIterator2() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(false);
    when(list.isEmpty()).thenReturn(false);

    ArrayList<String> stringList = new ArrayList<>();
    when(list.iterator()).thenReturn(stringList.iterator());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("");

    // Act
    tbCheckMessageNode.onMsg(ctx, msg);

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
    verify(msg).getData();
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TbCheckMessageNode tbCheckMessageNode = new TbCheckMessageNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new RuntimeException())
        .when(ctx)
        .tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbCheckMessageNode.onMsg(ctx, mock(TbMsg.class)));
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbCheckMessageNode} (default constructor).
   *   <li>When {@link TbMsg}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbCheckMessageNode (default constructor); when TbMsg")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbCheckMessageNode_whenTbMsg() {
    // Arrange
    TbCheckMessageNode tbCheckMessageNode = new TbCheckMessageNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbCheckMessageNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }
}
