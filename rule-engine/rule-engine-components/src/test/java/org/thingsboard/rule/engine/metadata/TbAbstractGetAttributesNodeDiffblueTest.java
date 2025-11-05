package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.dao.cache.CacheExecutorService;

class TbAbstractGetAttributesNodeDiffblueTest {
  /**
   * Test {@link TbAbstractGetAttributesNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractGetAttributesNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetAttributesNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        TbNodeException.class, () -> tbGetAttributesNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbAbstractGetAttributesNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractGetAttributesNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when ArrayNode asToken() throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetAttributesNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenArrayNodeAsTokenThrowRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbGetAttributesNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).asToken();
  }

  /**
   * Test {@link TbAbstractGetAttributesNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode} {@link ArrayNode#fields()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractGetAttributesNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when ArrayNode fields() throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetAttributesNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenArrayNodeFieldsThrowRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.fields()).thenThrow(new RuntimeException());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbGetAttributesNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbAbstractGetAttributesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link CacheExecutorService} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractGetAttributesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given CacheExecutorService (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetAttributesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenCacheExecutorService() throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new CacheExecutorService());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbGetAttributesNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
  }

  /**
   * Test {@link TbAbstractGetAttributesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbContext} {@link TbContext#getDbCallbackExecutor()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractGetAttributesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'null'; when TbContext getDbCallbackExecutor() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetAttributesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenNull_whenTbContextGetDbCallbackExecutorReturnNull() throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(null);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbGetAttributesNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractGetAttributesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractGetAttributesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given TestDbCallbackExecutor (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetAttributesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTestDbCallbackExecutor() throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbGetAttributesNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractGetAttributesNode#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode,
   * String, String, String)}.
   *
   * <p>Method under test: {@link
   * TbAbstractGetAttributesNode#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbPair TbAbstractGetAttributesNode.upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String)"
  })
  void testUpgradeRuleNodesWithOldPropertyToUseFetchTo() throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fetchTo", DoubleNode.valueOf(10.0d));

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeRuleNodesWithOldPropertyToUseFetchToResult =
        tbGetAttributesNode.upgradeRuleNodesWithOldPropertyToUseFetchTo(
            oldConfiguration, "Old Property", "If True", "If False");

    // Assert
    JsonNode second = actualUpgradeRuleNodesWithOldPropertyToUseFetchToResult.getSecond();
    assertTrue(second instanceof ObjectNode);
    assertTrue(actualUpgradeRuleNodesWithOldPropertyToUseFetchToResult.getFirst());
    assertSame(oldConfiguration, second);
  }
}
