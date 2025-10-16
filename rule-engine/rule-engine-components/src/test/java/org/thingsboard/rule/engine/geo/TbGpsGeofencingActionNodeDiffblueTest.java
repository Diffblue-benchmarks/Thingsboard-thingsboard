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
package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;

class TbGpsGeofencingActionNodeDiffblueTest {
  /**
   * Test {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code 42}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given '42'; when TbMsg getData() return '42'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGpsGeofencingActionNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_given42_whenTbMsgGetDataReturn42_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbGpsGeofencingActionNode.onMsg(ctx, msg));
    verify(msg).getData();
  }

  /**
   * Test {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'Data'; when TbMsg getData() return 'Data'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGpsGeofencingActionNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenData_whenTbMsgGetDataReturnData_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbGpsGeofencingActionNode.onMsg(ctx, msg));
    verify(msg).getData();
  }

  /**
   * Test {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given empty string; when TbMsg getData() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGpsGeofencingActionNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenEmptyString_whenTbMsgGetDataReturnEmptyString() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("");

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbGpsGeofencingActionNode.onMsg(ctx, msg));
    verify(msg).getData();
  }

  /**
   * Test {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code foo}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'foo'; when TbMsg getData() return 'foo'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGpsGeofencingActionNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenFoo_whenTbMsgGetDataReturnFoo_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("foo");

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbGpsGeofencingActionNode.onMsg(ctx, msg));
    verify(msg).getData();
  }

  /**
   * Test {@link TbGpsGeofencingActionNode#getConfigClazz()}.
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNode#getConfigClazz()}
   */
  @Test
  @DisplayName("Test getConfigClazz()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class TbGpsGeofencingActionNode.getConfigClazz()"})
  void testGetConfigClazz() {
    // Arrange and Act
    Class<TbGpsGeofencingActionNodeConfiguration> actualConfigClazz =
        new TbGpsGeofencingActionNode().getConfigClazz();

    // Assert
    Class<TbGpsGeofencingActionNodeConfiguration> expectedConfigClazz =
        TbGpsGeofencingActionNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualConfigClazz);
  }

  /**
   * Test {@link TbGpsGeofencingActionNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbGpsGeofencingActionNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenOne_thenReturnSecondIsValueOfTen() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(
        oldConfiguration, new TbGpsGeofencingActionNode().upgrade(1, oldConfiguration).getSecond());
  }

  /**
   * Test new {@link TbGpsGeofencingActionNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbGpsGeofencingActionNode}
   */
  @Test
  @DisplayName("Test new TbGpsGeofencingActionNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGpsGeofencingActionNode.<init>()"})
  void testNewTbGpsGeofencingActionNode() {
    // Arrange and Act
    TbGpsGeofencingActionNode actualTbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    // Assert
    assertNull(actualTbGpsGeofencingActionNode.jtsCtx);
    assertNull(actualTbGpsGeofencingActionNode.config);
    Class<TbGpsGeofencingActionNodeConfiguration> expectedConfigClazz =
        TbGpsGeofencingActionNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualTbGpsGeofencingActionNode.getConfigClazz());
  }
}
