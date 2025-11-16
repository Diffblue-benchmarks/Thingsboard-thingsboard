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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.EmptyNodeConfiguration;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.dao.entityview.EntityViewServiceImpl;

class TbCopyAttributesToEntityViewNodeDiffblueTest {
  /**
   * Test {@link TbCopyAttributesToEntityViewNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@link
   *       POJONode#POJONode(Object)} Data {@link POJONode}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyAttributesToEntityViewNode#init(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); then TbNodeConfiguration(JsonNode) with data is POJONode(Object) Data POJONode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenTbNodeConfigurationWithDataIsPOJONodeDataPOJONode() throws TbNodeException {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode =
        new TbCopyAttributesToEntityViewNode();
    TbContext ctx = mock(TbContext.class);
    EmptyNodeConfiguration emptyNodeConfiguration = new EmptyNodeConfiguration();
    TbNodeConfiguration configuration =
        new TbNodeConfiguration(new POJONode(emptyNodeConfiguration));

    // Act
    tbCopyAttributesToEntityViewNode.init(ctx, configuration);

    // Assert
    JsonNode data = configuration.getData();
    assertTrue(data instanceof POJONode);
    Object pojo = ((POJONode) data).getPojo();
    assertTrue(pojo instanceof EmptyNodeConfiguration);
    assertEquals(0, tbCopyAttributesToEntityViewNode.config.getVersion());
    assertSame(emptyNodeConfiguration, pojo);
  }

  /**
   * Test {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOneOf(TbMsgType[])} return {@code false}.
   *   <li>Then calls {@link TbMsg#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'false'; when TbMsg isTypeOneOf(TbMsgType[]) return 'false'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenFalse_whenTbMsgIsTypeOneOfReturnFalse_thenCallsGetType() {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode =
        new TbCopyAttributesToEntityViewNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(false);
    when(msg.getType()).thenReturn("Type");

    // Act
    tbCopyAttributesToEntityViewNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getType();
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
  }

  /**
   * Test {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()}.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgMetaData(); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgMetaData_thenCallsTellFailure() {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode =
        new TbCopyAttributesToEntityViewNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(true);

    // Act
    tbCopyAttributesToEntityViewNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getMetaData();
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
  }

  /**
   * Test {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsGetTenantId() {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode =
        new TbCopyAttributesToEntityViewNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.getEntityViewService()).thenReturn(new EntityViewServiceImpl());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Message metadata is empty", "42");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenThrow(new IllegalArgumentException());
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> tbCopyAttributesToEntityViewNode.onMsg(ctx, msg));
    verify(ctx).getEntityViewService();
    verify(ctx).getTenantId();
    verify(msg).getMetaData();
    verify(msg).getOriginator();
    verify(msg).isTypeOf(TbMsgType.POST_ATTRIBUTES_REQUEST);
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
  }

  /**
   * Test {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getEntityViewService()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext getEntityViewService() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextGetEntityViewServiceThrowIllegalArgumentException() {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode =
        new TbCopyAttributesToEntityViewNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getEntityViewService()).thenThrow(new IllegalArgumentException());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Message metadata is empty", "42");

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> tbCopyAttributesToEntityViewNode.onMsg(ctx, msg));
    verify(ctx).getEntityViewService();
    verify(msg).getMetaData();
    verify(msg).isTypeOf(TbMsgType.POST_ATTRIBUTES_REQUEST);
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
  }

  /**
   * Test {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getMetaData()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbMsg getMetaData() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsgGetMetaDataThrowIllegalArgumentException() {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode =
        new TbCopyAttributesToEntityViewNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenThrow(new IllegalArgumentException());
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> tbCopyAttributesToEntityViewNode.onMsg(ctx, msg));
    verify(msg).getMetaData();
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
  }

  /**
   * Test {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOf(TbMsgType)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link TbMsg#isTypeOf(TbMsgType)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbMsg isTypeOf(TbMsgType) throw IllegalArgumentException(); then calls isTypeOf(TbMsgType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsgIsTypeOfThrowIllegalArgumentException_thenCallsIsTypeOf() {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode =
        new TbCopyAttributesToEntityViewNode();
    TbContext ctx = mock(TbContext.class);

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Message metadata is empty", "42");

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenThrow(new IllegalArgumentException());
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> tbCopyAttributesToEntityViewNode.onMsg(ctx, msg));
    verify(msg).getMetaData();
    verify(msg).isTypeOf(TbMsgType.POST_ATTRIBUTES_REQUEST);
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
  }

  /**
   * Test {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOneOf(TbMsgType[])} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbMsg isTypeOneOf(TbMsgType[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsgIsTypeOneOfThrowIllegalArgumentException() {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode =
        new TbCopyAttributesToEntityViewNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> tbCopyAttributesToEntityViewNode.onMsg(ctx, msg));
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
  }

  /**
   * Test new {@link TbCopyAttributesToEntityViewNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * TbCopyAttributesToEntityViewNode}
   */
  @Test
  @DisplayName("Test new TbCopyAttributesToEntityViewNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.<init>()"})
  void testNewTbCopyAttributesToEntityViewNode() {
    // Arrange, Act and Assert
    assertNull(new TbCopyAttributesToEntityViewNode().config);
  }
}
