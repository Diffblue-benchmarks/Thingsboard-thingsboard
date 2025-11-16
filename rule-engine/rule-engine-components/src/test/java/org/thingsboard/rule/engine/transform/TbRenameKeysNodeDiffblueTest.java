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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
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
class TbRenameKeysNodeDiffblueTest {
  @Mock private Map<String, String> map;

  @Mock private TbMsgSource tbMsgSource;

  @InjectMocks private TbRenameKeysNode tbRenameKeysNode;

  /**
   * Test {@link TbRenameKeysNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code DATA}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'DATA'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenData_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbRenameKeysNode tbRenameKeysNode = new TbRenameKeysNode();
    TbContext ctx = mock(TbContext.class);

    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration =
        new TbRenameKeysNodeConfiguration();
    tbRenameKeysNodeConfiguration.setRenameIn(TbMsgSource.DATA);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbRenameKeysNode.init(
                ctx, new TbNodeConfiguration(new POJONode(tbRenameKeysNodeConfiguration))));
  }

  /**
   * Test {@link TbRenameKeysNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenHashMap() throws TbNodeException {
    // Arrange
    TbRenameKeysNode tbRenameKeysNode = new TbRenameKeysNode();
    TbContext ctx = mock(TbContext.class);

    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration =
        new TbRenameKeysNodeConfiguration();
    tbRenameKeysNodeConfiguration.setRenameKeysMapping(new HashMap<>());
    tbRenameKeysNodeConfiguration.setRenameIn(TbMsgSource.DATA);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbRenameKeysNode.init(
                ctx, new TbNodeConfiguration(new POJONode(tbRenameKeysNodeConfiguration))));
  }

  /**
   * Test {@link TbRenameKeysNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenDoesNotThrow() throws TbNodeException {
    // Arrange
    TbRenameKeysNode tbRenameKeysNode = new TbRenameKeysNode();
    TbContext ctx = mock(TbContext.class);

    HashMap<String, String> renameKeysMapping = new HashMap<>();
    renameKeysMapping.put("At least one mapping entry should be specified!", "42");

    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration =
        new TbRenameKeysNodeConfiguration();
    tbRenameKeysNodeConfiguration.setRenameKeysMapping(renameKeysMapping);
    tbRenameKeysNodeConfiguration.setRenameIn(TbMsgSource.DATA);

    // Act and Assert
    assertDoesNotThrow(
        () ->
            tbRenameKeysNode.init(
                ctx, new TbNodeConfiguration(new POJONode(tbRenameKeysNodeConfiguration))));
  }

  /**
   * Test {@link TbRenameKeysNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbRenameKeysNode tbRenameKeysNode = new TbRenameKeysNode();
    TbContext ctx = mock(TbContext.class);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbRenameKeysNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new TbRenameKeysNodeConfiguration()))));
  }

  /**
   * Test {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code 42}.
   *   <li>Then calls {@link TbMsgSource#ordinal()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given '42'; when TbMsg getData() return '42'; then calls ordinal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_given42_whenTbMsgGetDataReturn42_thenCallsOrdinal()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(0);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbRenameKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link AbstractMap.SimpleEntry#SimpleEntry(Object,
   *       Object)} with {@code Key} and {@code 42}.
   *   <li>Then calls {@link Map#entrySet()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given HashSet() add SimpleEntry(Object, Object) with 'Key' and '42'; then calls entrySet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenHashSetAddSimpleEntryWithKeyAnd42_thenCallsEntrySet()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(1);

    HashSet<Entry<String, String>> entrySet = new HashSet<>();
    entrySet.add(new SimpleEntry<>("Key", "42"));
    when(map.entrySet()).thenReturn(entrySet);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbRenameKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(map).entrySet();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value {@code 42} is {@code Value}.
   *   <li>Then calls {@link Map#entrySet()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgMetaData() Value '42' is 'Value'; then calls entrySet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgMetaDataValue42IsValue_thenCallsEntrySet()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(1);
    when(map.entrySet()).thenReturn(new HashSet<>());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("42", "Value");
    tbMsgMetaData.putValue("Key", "42");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act
    tbRenameKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(map).entrySet();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value {@code Key} is {@code 42}.
   *   <li>Then calls {@link Map#entrySet()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgMetaData() Value 'Key' is '42'; then calls entrySet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgMetaDataValueKeyIs42_thenCallsEntrySet()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(1);
    when(map.entrySet()).thenReturn(new HashSet<>());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Key", "42");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act
    tbRenameKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(map).entrySet();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData(Map)} with data is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given TbMsgMetaData(Map) with data is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgMetaDataWithDataIsHashMap()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(0);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData(new HashMap<>()));

    // Act
    tbRenameKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgSource} {@link TbMsgSource#ordinal()} return one.
   *   <li>Then calls {@link Map#entrySet()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgSource ordinal() return one; then calls entrySet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgSourceOrdinalReturnOne_thenCallsEntrySet()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(1);
    when(map.entrySet()).thenReturn(new HashSet<>());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbRenameKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(map).entrySet();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbRenameKeysNode}
   *   <li>{@link TbRenameKeysNode#getKeyToUpgradeFromVersionOne()}
   *   <li>{@link TbRenameKeysNode#getNewKeyForUpgradeFromVersionZero()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbRenameKeysNode.<init>()",
    "String TbRenameKeysNode.getKeyToUpgradeFromVersionOne()",
    "String TbRenameKeysNode.getNewKeyForUpgradeFromVersionZero()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbRenameKeysNode actualTbRenameKeysNode = new TbRenameKeysNode();
    String actualKeyToUpgradeFromVersionOne =
        actualTbRenameKeysNode.getKeyToUpgradeFromVersionOne();

    // Assert
    assertEquals("fromMetadata", actualKeyToUpgradeFromVersionOne);
    assertEquals("renameIn", actualTbRenameKeysNode.getNewKeyForUpgradeFromVersionZero());
  }
}
