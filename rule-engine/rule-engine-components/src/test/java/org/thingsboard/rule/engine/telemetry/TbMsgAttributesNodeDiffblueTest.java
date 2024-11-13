package org.thingsboard.rule.engine.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbMsgAttributesNodeDiffblueTest {
  /**
   * Test {@link TbMsgAttributesNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given IllegalArgumentException(String) with 'foo'; then throw IllegalArgumentException")
  void testOnMsg_givenIllegalArgumentExceptionWithFoo_thenThrowIllegalArgumentException() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    TbContext ctx = mock(TbContext.class);
    doThrow(new IllegalArgumentException("foo")).when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_TELEMETRY_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbMsgAttributesNode.onMsg(ctx, msg));
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgAttributesNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)}
   * does nothing.</li>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); when TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  void testOnMsg_whenTbContextTellFailureDoesNothing_thenCallsTellFailure() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_TELEMETRY_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbMsgAttributesNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test
   * {@link TbMsgAttributesNode#saveAttr(List, TbContext, TbMsg, AttributeScope, boolean)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgAttributesNode#saveAttr(List, TbContext, TbMsg, AttributeScope, boolean)}
   */
  @Test
  @DisplayName("Test saveAttr(List, TbContext, TbMsg, AttributeScope, boolean); then throw IllegalArgumentException")
  void testSaveAttr_thenThrowIllegalArgumentException() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTelemetryService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> tbMsgAttributesNode.saveAttr(attributes, ctx, null, AttributeScope.CLIENT_SCOPE, true));
    verify(ctx).getTelemetryService();
  }

  /**
   * Test
   * {@link TbMsgAttributesNode#saveAttr(List, TbContext, TbMsg, AttributeScope, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgAttributesNode#saveAttr(List, TbContext, TbMsg, AttributeScope, boolean)}
   */
  @Test
  @DisplayName("Test saveAttr(List, TbContext, TbMsg, AttributeScope, boolean); when ArrayList(); then calls tellSuccess(TbMsg)")
  void testSaveAttr_whenArrayList_thenCallsTellSuccess() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    // Act
    tbMsgAttributesNode.saveAttr(attributes, ctx, null, AttributeScope.CLIENT_SCOPE, true);

    // Assert
    verify(ctx).tellSuccess(isNull());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List)")
  void testFilterChangedAttr() throws TbNodeException {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    TbContext ctx = mock(TbContext.class);
    tbMsgAttributesNode.init(ctx, new TbNodeConfiguration(null));
    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(currentAttributes, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); given JsonDataEntry(String, String) with 'Key' and value is '42'")
  void testFilterChangedAttr_givenJsonDataEntryWithKeyAndValueIs42() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(currentAttributes, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return ArrayList()")
  void testFilterChangedAttr_givenJsonDataEntryWithKeyAndValueIs42_thenReturnArrayList() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    newAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertSame(newAttributes, tbMsgAttributesNode.filterChangedAttr(currentAttributes, newAttributes));
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return size is two")
  void testFilterChangedAttr_givenJsonDataEntryWithKeyAndValueIs42_thenReturnSizeIsTwo() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();

    ArrayList<AttributeKvEntry> newAttributes = new ArrayList<>();
    newAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));

    newAttributes.add(baseAttributeKvEntry);

    // Act
    List<AttributeKvEntry> actualFilterChangedAttrResult = tbMsgAttributesNode.filterChangedAttr(currentAttributes,
        newAttributes);

    // Assert
    assertEquals(2, actualFilterChangedAttrResult.size());
    assertSame(baseAttributeKvEntry, actualFilterChangedAttrResult.get(1));
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); given JsonDataEntry(String, String) with 'Key' and value is '42'")
  void testFilterChangedAttr_givenJsonDataEntryWithKeyAndValueIs422() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(currentAttributes, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); given JsonDataEntry(String, String) with 'Key' and value is '42'")
  void testFilterChangedAttr_givenJsonDataEntryWithKeyAndValueIs423() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    currentAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(currentAttributes, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>Given {@link TbMsgAttributesNode} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); given TbMsgAttributesNode (default constructor); when ArrayList(); then return Empty")
  void testFilterChangedAttr_givenTbMsgAttributesNode_whenArrayList_thenReturnEmpty() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    ArrayList<AttributeKvEntry> currentAttributes = new ArrayList<>();

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(currentAttributes, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#filterChangedAttr(List, List)}.
   * <ul>
   *   <li>Given {@link TbMsgAttributesNode} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgAttributesNode#filterChangedAttr(List, List)}
   */
  @Test
  @DisplayName("Test filterChangedAttr(List, List); given TbMsgAttributesNode (default constructor); when 'null'; then return Empty")
  void testFilterChangedAttr_givenTbMsgAttributesNode_whenNull_thenReturnEmpty() {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();

    // Act and Assert
    assertTrue(tbMsgAttributesNode.filterChangedAttr(null, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link TbMsgAttributesNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test: {@link TbMsgAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbMsgAttributesNode tbMsgAttributesNode = new TbMsgAttributesNode();
    ObjectNode oldConfiguration = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbMsgAttributesNode.upgrade(-1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof ObjectNode);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertEquals("{ }", second.toPrettyString());
    assertEquals("{ }", oldConfiguration.toPrettyString());
    assertEquals(0, second.size());
    assertEquals(0, oldConfiguration.size());
    assertFalse(oldConfiguration.iterator().hasNext());
    assertFalse(second.iterator().hasNext());
    assertFalse(actualUpgradeResult.getFirst());
    assertTrue(second.isEmpty());
    assertTrue(oldConfiguration.isEmpty());
  }
}
