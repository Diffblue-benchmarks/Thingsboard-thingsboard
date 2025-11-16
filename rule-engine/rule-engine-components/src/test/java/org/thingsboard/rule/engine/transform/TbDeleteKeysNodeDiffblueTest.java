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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
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
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.util.TbMsgSource;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;

@ExtendWith(MockitoExtension.class)
class TbDeleteKeysNodeDiffblueTest {
  @Mock private List<Pattern> list;

  @InjectMocks private TbDeleteKeysNode tbDeleteKeysNode;

  @Mock private TbMsgSource tbMsgSource;

  /**
   * Test {@link TbDeleteKeysNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeleteKeysNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbDeleteKeysNode tbDeleteKeysNode = new TbDeleteKeysNode();
    TbContext ctx = mock(TbContext.class);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbDeleteKeysNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new TbDeleteKeysNodeConfiguration()))));
  }

  /**
   * Test {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   *   <li>Then calls {@link List#stream()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ArrayList() add compile '.*\\.txt'; when TbMsg getData() return 'Data'; then calls stream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeleteKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenArrayListAddCompileTxt_whenTbMsgGetDataReturnData_thenCallsStream()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);
    when(tbMsgSource.ordinal()).thenReturn(1);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Key", "42");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act
    tbDeleteKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   *   <li>Then calls {@link List#stream()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ArrayList() add compile '.*\\.txt'; when TbMsg getData() return 'Data'; then calls stream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeleteKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenArrayListAddCompileTxt_whenTbMsgGetDataReturnData_thenCallsStream2()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);
    when(tbMsgSource.ordinal()).thenReturn(1);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Key", "42");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act
    tbDeleteKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   *   <li>Then calls {@link TbMsgSource#ordinal()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgMetaData(); when TbMsg getData() return 'Data'; then calls ordinal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeleteKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgMetaData_whenTbMsgGetDataReturnData_thenCallsOrdinal()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(1);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbDeleteKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgSource} {@link TbMsgSource#ordinal()} return one.
   *   <li>Then calls {@link List#stream()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgSource ordinal() return one; then calls stream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeleteKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgSourceOrdinalReturnOne_thenCallsStream()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);
    when(tbMsgSource.ordinal()).thenReturn(1);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Key", "42");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act
    tbDeleteKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbDeleteKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#matches(String)}
   */
  @Test
  @DisplayName(
      "Test matches(String); given ArrayList() add compile '.*\\.txt'; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbDeleteKeysNode.matches(String)"})
  void testMatches_givenArrayListAddCompileTxt_whenKey_thenReturnFalse() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbDeleteKeysNode.matches("Key");

    // Assert
    verify(list).stream();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link TbDeleteKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#matches(String)}
   */
  @Test
  @DisplayName(
      "Test matches(String); given ArrayList() add compile '.*\\.txt'; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbDeleteKeysNode.matches(String)"})
  void testMatches_givenArrayListAddCompileTxt_whenKey_thenReturnFalse2() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbDeleteKeysNode.matches("Key");

    // Assert
    verify(list).stream();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link TbDeleteKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@code U.txt}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#matches(String)}
   */
  @Test
  @DisplayName(
      "Test matches(String); given ArrayList() add compile '.*\\.txt'; when 'U.txt'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbDeleteKeysNode.matches(String)"})
  void testMatches_givenArrayListAddCompileTxt_whenUTxt_thenReturnTrue() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbDeleteKeysNode.matches("U.txt");

    // Assert
    verify(list).stream();
    assertTrue(actualMatchesResult);
  }

  /**
   * Test {@link TbDeleteKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#matches(String)}
   */
  @Test
  @DisplayName("Test matches(String); when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbDeleteKeysNode.matches(String)"})
  void testMatches_whenKey_thenReturnFalse() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbDeleteKeysNode.matches("Key");

    // Assert
    verify(list).stream();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbDeleteKeysNode}
   *   <li>{@link TbDeleteKeysNode#getKeyToUpgradeFromVersionOne()}
   *   <li>{@link TbDeleteKeysNode#getNewKeyForUpgradeFromVersionZero()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbDeleteKeysNode.<init>()",
    "String TbDeleteKeysNode.getKeyToUpgradeFromVersionOne()",
    "String TbDeleteKeysNode.getNewKeyForUpgradeFromVersionZero()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbDeleteKeysNode actualTbDeleteKeysNode = new TbDeleteKeysNode();
    String actualKeyToUpgradeFromVersionOne =
        actualTbDeleteKeysNode.getKeyToUpgradeFromVersionOne();

    // Assert
    assertEquals("dataToFetch", actualKeyToUpgradeFromVersionOne);
    assertEquals("deleteFrom", actualTbDeleteKeysNode.getNewKeyForUpgradeFromVersionZero());
  }
}
