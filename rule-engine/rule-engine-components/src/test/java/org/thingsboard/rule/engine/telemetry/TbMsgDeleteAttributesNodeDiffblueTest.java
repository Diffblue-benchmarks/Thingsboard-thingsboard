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
package org.thingsboard.rule.engine.telemetry;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;

@ExtendWith(MockitoExtension.class)
class TbMsgDeleteAttributesNodeDiffblueTest {
  @Mock private List<String> list;

  @InjectMocks private TbMsgDeleteAttributesNode tbMsgDeleteAttributesNode;

  /**
   * Test {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code 42}.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ArrayList() add empty string; when TbMsg getData() return '42'; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeleteAttributesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenArrayListAddEmptyString_whenTbMsgGetDataReturn42_thenCallsGetData()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");
    Stream<String> streamResult = stringList.stream();
    when(list.stream()).thenReturn(streamResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbMsgDeleteAttributesNode.onMsg(ctx, msg);

    // Assert
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value empty string is empty string.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgMetaData() Value empty string is empty string; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeleteAttributesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgMetaDataValueEmptyStringIsEmptyString_thenCallsGetData()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");
    Stream<String> streamResult = stringList.stream();
    when(list.stream()).thenReturn(streamResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("", "");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act
    tbMsgDeleteAttributesNode.onMsg(ctx, msg);

    // Assert
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg}.
   *   <li>Then calls {@link List#stream()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); when TbMsg; then calls stream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeleteAttributesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsg_thenCallsStream()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    Stream<String> streamResult = stringList.stream();
    when(list.stream()).thenReturn(streamResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    // Act
    tbMsgDeleteAttributesNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }
}
