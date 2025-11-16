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
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;

@ExtendWith(MockitoExtension.class)
class TbCopyKeysNodeDiffblueTest {
  @Mock private List<Pattern> list;

  @InjectMocks private TbCopyKeysNode tbCopyKeysNode;

  /**
   * Test {@link TbCopyKeysNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@link TbCopyKeysNodeConfiguration}
   *       (default constructor).
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when POJONode(Object) with v is TbCopyKeysNodeConfiguration (default constructor); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenPOJONodeWithVIsTbCopyKeysNodeConfiguration_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    TbContext ctx = mock(TbContext.class);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbCopyKeysNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new TbCopyKeysNodeConfiguration()))));
  }

  /**
   * Test {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbCopyKeysNode} (default constructor).
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code 42}.
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbCopyKeysNode (default constructor); when TbMsg getData() return '42'; then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbCopyKeysNode_whenTbMsgGetDataReturn42_thenCallsTellSuccess()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbCopyKeysNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value empty string is empty string.
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgMetaData() Value empty string is empty string; then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgMetaDataValueEmptyStringIsEmptyString_thenCallsTellSuccess()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("", "");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act
    tbCopyKeysNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value {@code Key} is {@code 42}.
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgMetaData() Value 'Key' is '42'; then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgMetaDataValueKeyIs42_thenCallsTellSuccess()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Key", "42");
    tbMsgMetaData.putValue("", "");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act
    tbCopyKeysNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbCopyKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#matches(String)}
   */
  @Test
  @DisplayName(
      "Test matches(String); given ArrayList() add compile '.*\\.txt'; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbCopyKeysNode.matches(String)"})
  void testMatches_givenArrayListAddCompileTxt_whenKey_thenReturnFalse() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbCopyKeysNode.matches("Key");

    // Assert
    verify(list).stream();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link TbCopyKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#matches(String)}
   */
  @Test
  @DisplayName(
      "Test matches(String); given ArrayList() add compile '.*\\.txt'; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbCopyKeysNode.matches(String)"})
  void testMatches_givenArrayListAddCompileTxt_whenKey_thenReturnFalse2() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbCopyKeysNode.matches("Key");

    // Assert
    verify(list).stream();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link TbCopyKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@code U.txt}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#matches(String)}
   */
  @Test
  @DisplayName(
      "Test matches(String); given ArrayList() add compile '.*\\.txt'; when 'U.txt'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbCopyKeysNode.matches(String)"})
  void testMatches_givenArrayListAddCompileTxt_whenUTxt_thenReturnTrue() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbCopyKeysNode.matches("U.txt");

    // Assert
    verify(list).stream();
    assertTrue(actualMatchesResult);
  }

  /**
   * Test {@link TbCopyKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#matches(String)}
   */
  @Test
  @DisplayName("Test matches(String); when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbCopyKeysNode.matches(String)"})
  void testMatches_whenKey_thenReturnFalse() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbCopyKeysNode.matches("Key");

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
   *   <li>default or parameterless constructor of {@link TbCopyKeysNode}
   *   <li>{@link TbCopyKeysNode#getKeyToUpgradeFromVersionOne()}
   *   <li>{@link TbCopyKeysNode#getNewKeyForUpgradeFromVersionZero()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbCopyKeysNode.<init>()",
    "String TbCopyKeysNode.getKeyToUpgradeFromVersionOne()",
    "String TbCopyKeysNode.getNewKeyForUpgradeFromVersionZero()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbCopyKeysNode actualTbCopyKeysNode = new TbCopyKeysNode();
    String actualKeyToUpgradeFromVersionOne = actualTbCopyKeysNode.getKeyToUpgradeFromVersionOne();

    // Assert
    assertEquals("copyFrom", actualTbCopyKeysNode.getNewKeyForUpgradeFromVersionZero());
    assertEquals("fromMetadata", actualKeyToUpgradeFromVersionOne);
  }
}
