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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.dao.cassandra.CassandraCluster;

class TbSaveToCustomCassandraTableNodeDiffblueTest {
  /**
   * Test {@link TbSaveToCustomCassandraTableNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNode#init(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given HashMap(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSaveToCustomCassandraTableNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenHashMap_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbSaveToCustomCassandraTableNode tbSaveToCustomCassandraTableNode =
        new TbSaveToCustomCassandraTableNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getCassandraCluster()).thenReturn(new CassandraCluster());

    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration =
        new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration.setFieldsMapping(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            tbSaveToCustomCassandraTableNode.init(
                ctx,
                new TbNodeConfiguration(
                    new POJONode(tbSaveToCustomCassandraTableNodeConfiguration))));
    verify(ctx).getCassandraCluster();
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbContext} {@link TbContext#getCassandraCluster()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNode#init(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'null'; when TbContext getCassandraCluster() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSaveToCustomCassandraTableNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenNull_whenTbContextGetCassandraClusterReturnNull() throws TbNodeException {
    // Arrange
    TbSaveToCustomCassandraTableNode tbSaveToCustomCassandraTableNode =
        new TbSaveToCustomCassandraTableNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getCassandraCluster()).thenReturn(null);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            tbSaveToCustomCassandraTableNode.init(
                ctx,
                new TbNodeConfiguration(
                    new POJONode(new TbSaveToCustomCassandraTableNodeConfiguration()))));
    verify(ctx).getCassandraCluster();
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNode#init(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSaveToCustomCassandraTableNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenRuntimeException() throws TbNodeException {
    // Arrange
    TbSaveToCustomCassandraTableNode tbSaveToCustomCassandraTableNode =
        new TbSaveToCustomCassandraTableNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getCassandraCluster()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            tbSaveToCustomCassandraTableNode.init(
                ctx,
                new TbNodeConfiguration(
                    new POJONode(new TbSaveToCustomCassandraTableNodeConfiguration()))));
    verify(ctx).getCassandraCluster();
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code 42}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given '42'; when TbMsg getData() return '42'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSaveToCustomCassandraTableNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_given42_whenTbMsgGetDataReturn42_thenThrowIllegalStateException() {
    // Arrange
    TbSaveToCustomCassandraTableNode tbSaveToCustomCassandraTableNode =
        new TbSaveToCustomCassandraTableNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> tbSaveToCustomCassandraTableNode.onMsg(ctx, msg));
    verify(msg).getData();
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'Data'; when TbMsg getData() return 'Data'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSaveToCustomCassandraTableNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenData_whenTbMsgGetDataReturnData_thenThrowIllegalStateException() {
    // Arrange
    TbSaveToCustomCassandraTableNode tbSaveToCustomCassandraTableNode =
        new TbSaveToCustomCassandraTableNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> tbSaveToCustomCassandraTableNode.onMsg(ctx, msg));
    verify(msg).getData();
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given empty string; when TbMsg getData() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSaveToCustomCassandraTableNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenEmptyString_whenTbMsgGetDataReturnEmptyString() {
    // Arrange
    TbSaveToCustomCassandraTableNode tbSaveToCustomCassandraTableNode =
        new TbSaveToCustomCassandraTableNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("");

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> tbSaveToCustomCassandraTableNode.onMsg(ctx, msg));
    verify(msg).getData();
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code foo}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'foo'; when TbMsg getData() return 'foo'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSaveToCustomCassandraTableNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenFoo_whenTbMsgGetDataReturnFoo_thenThrowIllegalStateException() {
    // Arrange
    TbSaveToCustomCassandraTableNode tbSaveToCustomCassandraTableNode =
        new TbSaveToCustomCassandraTableNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("foo");

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> tbSaveToCustomCassandraTableNode.onMsg(ctx, msg));
    verify(msg).getData();
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSaveToCustomCassandraTableNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TbSaveToCustomCassandraTableNode tbSaveToCustomCassandraTableNode =
        new TbSaveToCustomCassandraTableNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbSaveToCustomCassandraTableNode.onMsg(ctx, msg));
    verify(msg).getData();
  }
}
