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
package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.dao.cache.CacheExecutorService;

class TbAbstractGetEntityDataNodeDiffblueTest {
  /**
   * Test {@link TbAbstractGetEntityDataNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link CacheExecutorService} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractGetEntityDataNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given CacheExecutorService (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetEntityDataNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenCacheExecutorService() {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new CacheExecutorService());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    tbGetCustomerAttributeNode.onMsg(ctx, msg);

    // Assert
    verify(ctx, atLeast(1)).getDbCallbackExecutor();
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbAbstractGetEntityDataNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link CustomerId#CustomerId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractGetEntityDataNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given CustomerId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetEntityDataNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new CustomerId(UUID.randomUUID()));

    // Act
    tbGetCustomerAttributeNode.onMsg(ctx, msg);

    // Assert
    verify(ctx, atLeast(1)).getDbCallbackExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbAbstractGetEntityDataNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractGetEntityDataNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TestDbCallbackExecutor (default constructor); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetEntityDataNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTestDbCallbackExecutor_thenCallsTellFailure() {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    tbGetCustomerAttributeNode.onMsg(ctx, msg);

    // Assert
    verify(ctx, atLeast(1)).getDbCallbackExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}.
   *
   * <ul>
   *   <li>When {@code ATTRIBUTES}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}
   */
  @Test
  @DisplayName(
      "Test checkDataToFetchSupportedOrElseThrow(DataToFetch); when 'ATTRIBUTES'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractGetEntityDataNode.checkDataToFetchSupportedOrElseThrow(DataToFetch)"
  })
  void testCheckDataToFetchSupportedOrElseThrow_whenAttributes_thenDoesNotThrow()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new TbGetCustomerAttributeNode()
                .checkDataToFetchSupportedOrElseThrow(DataToFetch.ATTRIBUTES));
  }

  /**
   * Test {@link TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}.
   *
   * <ul>
   *   <li>When {@code FIELDS}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}
   */
  @Test
  @DisplayName(
      "Test checkDataToFetchSupportedOrElseThrow(DataToFetch); when 'FIELDS'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractGetEntityDataNode.checkDataToFetchSupportedOrElseThrow(DataToFetch)"
  })
  void testCheckDataToFetchSupportedOrElseThrow_whenFields_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            new TbGetCustomerAttributeNode()
                .checkDataToFetchSupportedOrElseThrow(DataToFetch.FIELDS));
  }

  /**
   * Test {@link TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}
   */
  @Test
  @DisplayName(
      "Test checkDataToFetchSupportedOrElseThrow(DataToFetch); when 'null'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractGetEntityDataNode.checkDataToFetchSupportedOrElseThrow(DataToFetch)"
  })
  void testCheckDataToFetchSupportedOrElseThrow_whenNull_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> new TbGetCustomerAttributeNode().checkDataToFetchSupportedOrElseThrow(null));
  }

  /**
   * Test {@link TbAbstractGetEntityDataNode#upgradeToUseFetchToAndDataToFetch(JsonNode)}.
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDataNode#upgradeToUseFetchToAndDataToFetch(JsonNode)}
   */
  @Test
  @DisplayName("Test upgradeToUseFetchToAndDataToFetch(JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractGetEntityDataNode.upgradeToUseFetchToAndDataToFetch(JsonNode)"
  })
  void testUpgradeToUseFetchToAndDataToFetch() throws TbNodeException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("attrMapping", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("dataMapping", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("telemetry", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("dataToFetch", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("fetchTo", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbGetCustomerAttributeNode.upgradeToUseFetchToAndDataToFetch(oldConfiguration));
  }

  /**
   * Test {@link TbAbstractGetEntityDataNode#upgradeToUseFetchToAndDataToFetch(JsonNode)}.
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDataNode#upgradeToUseFetchToAndDataToFetch(JsonNode)}
   */
  @Test
  @DisplayName("Test upgradeToUseFetchToAndDataToFetch(JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractGetEntityDataNode.upgradeToUseFetchToAndDataToFetch(JsonNode)"
  })
  void testUpgradeToUseFetchToAndDataToFetch2() throws TbNodeException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("telemetry", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("dataMapping", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("telemetry", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("dataToFetch", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("fetchTo", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbGetCustomerAttributeNode.upgradeToUseFetchToAndDataToFetch(oldConfiguration));
  }

  /**
   * Test {@link TbAbstractGetEntityDataNode#upgradeToUseFetchToAndDataToFetch(JsonNode)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDataNode#upgradeToUseFetchToAndDataToFetch(JsonNode)}
   */
  @Test
  @DisplayName("Test upgradeToUseFetchToAndDataToFetch(JsonNode); given Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractGetEntityDataNode.upgradeToUseFetchToAndDataToFetch(JsonNode)"
  })
  void testUpgradeToUseFetchToAndDataToFetch_givenInstance() throws TbNodeException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("attrMapping", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("dataMapping", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("telemetry", MissingNode.getInstance());
    oldConfiguration.put("dataToFetch", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("fetchTo", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbGetCustomerAttributeNode.upgradeToUseFetchToAndDataToFetch(oldConfiguration));
  }

  /**
   * Test {@link TbAbstractGetEntityDataNode#upgradeToUseFetchToAndDataToFetch(JsonNode)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDataNode#upgradeToUseFetchToAndDataToFetch(JsonNode)}
   */
  @Test
  @DisplayName("Test upgradeToUseFetchToAndDataToFetch(JsonNode); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractGetEntityDataNode.upgradeToUseFetchToAndDataToFetch(JsonNode)"
  })
  void testUpgradeToUseFetchToAndDataToFetch_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("attrMapping", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("dataMapping", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("attrMapping", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("dataToFetch", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("fetchTo", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbGetCustomerAttributeNode.upgradeToUseFetchToAndDataToFetch(oldConfiguration));
  }
}
