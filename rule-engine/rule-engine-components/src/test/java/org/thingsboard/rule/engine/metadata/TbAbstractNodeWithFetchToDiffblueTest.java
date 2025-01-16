package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.util.concurrent.AsyncFunction;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbAbstractNodeWithFetchToDiffblueTest {
  /**
   * Test {@link TbAbstractNodeWithFetchTo#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link SimpleEntry#SimpleEntry(Object, Object)} with {@code foo} and
   * Instance.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractNodeWithFetchTo#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given ArrayList() add SimpleEntry(Object, Object) with 'foo' and Instance; then throw TbNodeException")
  void testInit_givenArrayListAddSimpleEntryWithFooAndInstance_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    TbContext ctx = mock(TbContext.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    entryList.add(new AbstractMap.SimpleEntry<>("foo", MissingNode.getInstance()));
    ArrayNode data = mock(ArrayNode.class);
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbFetchDeviceCredentialsNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link SimpleEntry#SimpleEntry(Object, Object)} with {@code foo} and
   * Instance.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractNodeWithFetchTo#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given ArrayList() add SimpleEntry(Object, Object) with 'foo' and Instance; then throw TbNodeException")
  void testInit_givenArrayListAddSimpleEntryWithFooAndInstance_thenThrowTbNodeException2() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    TbContext ctx = mock(TbContext.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    entryList.add(new AbstractMap.SimpleEntry<>("foo", MissingNode.getInstance()));
    entryList.add(new AbstractMap.SimpleEntry<>("foo", MissingNode.getInstance()));
    ArrayNode data = mock(ArrayNode.class);
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbFetchDeviceCredentialsNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractNodeWithFetchTo#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then throw TbNodeException")
  void testInit_givenStartObject_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbFetchDeviceCredentialsNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}.
   * <p>
   * Method under test:
   * {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}
   */
  @Test
  @DisplayName("Test checkIfEntityIsPresentOrThrow(String)")
  void testCheckIfEntityIsPresentOrThrow() throws Exception {
    // Arrange and Act
    AsyncFunction<EntityId, EntityId> actualCheckIfEntityIsPresentOrThrowResult = (new TbFetchDeviceCredentialsNode())
        .checkIfEntityIsPresentOrThrow("Not all who wander are lost");
    AlarmId alarmId = new AlarmId(UUID.randomUUID());

    // Assert
    assertSame(alarmId, actualCheckIfEntityIsPresentOrThrowResult.apply(alarmId).get());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}.
   * <ul>
   *   <li>Then return apply {@code null} Done.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}
   */
  @Test
  @DisplayName("Test checkIfEntityIsPresentOrThrow(String); then return apply 'null' Done")
  void testCheckIfEntityIsPresentOrThrow_thenReturnApplyNullDone() throws Exception {
    // Arrange, Act and Assert
    assertTrue((new TbFetchDeviceCredentialsNode()).checkIfEntityIsPresentOrThrow("Not all who wander are lost")
        .apply(null)
        .isDone());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}
   */
  @Test
  @DisplayName("Test getMsgDataAsObjectNode(TbMsg); then throw IllegalArgumentException")
  void testGetMsgDataAsObjectNode_thenThrowIllegalArgumentException() {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    TbMsg.TbMsgBuilder tbMsgBuilder = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder.metaData(Mockito.<TbMsgMetaData>any())).thenReturn(TbMsg.builder());
    TbMsg.TbMsgBuilder tbMsgBuilder2 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder2.internalType(Mockito.<TbMsgType>any())).thenReturn(tbMsgBuilder);
    TbMsg.TbMsgBuilder tbMsgBuilder3 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder3.id(Mockito.<UUID>any())).thenReturn(tbMsgBuilder2);
    TbMsg.TbMsgBuilder tbMsgBuilder4 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder4.dataType(Mockito.<TbMsgDataType>any())).thenReturn(tbMsgBuilder3);
    TbMsg.TbMsgBuilder tbMsgBuilder5 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder5.data(Mockito.<String>any())).thenReturn(tbMsgBuilder4);
    TbMsg.TbMsgBuilder tbMsgBuilder6 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder6.customerId(Mockito.<CustomerId>any())).thenReturn(tbMsgBuilder5);
    TbMsg.TbMsgBuilder tbMsgBuilder7 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder7.ctx(Mockito.<TbMsgProcessingCtx>any())).thenReturn(tbMsgBuilder6);
    TbMsg.TbMsgBuilder tbMsgBuilder8 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder8.correlationId(Mockito.<UUID>any())).thenReturn(tbMsgBuilder7);
    TbMsg.TbMsgBuilder tbMsgBuilder9 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder9.callback(Mockito.<TbMsgCallback>any())).thenReturn(tbMsgBuilder8);
    TbMsg.TbMsgBuilder callbackResult = tbMsgBuilder9.callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbFetchDeviceCredentialsNode.getMsgDataAsObjectNode(msg));
    verify(tbMsgBuilder9).callback(isA(TbMsgCallback.class));
    verify(tbMsgBuilder8).correlationId(isA(UUID.class));
    verify(tbMsgBuilder7).ctx(isA(TbMsgProcessingCtx.class));
    verify(tbMsgBuilder6).customerId(isA(CustomerId.class));
    verify(tbMsgBuilder5).data(eq("Data"));
    verify(tbMsgBuilder4).dataType(eq(TbMsgDataType.JSON));
    verify(tbMsgBuilder3).id(isA(UUID.class));
    verify(tbMsgBuilder2).internalType(eq(TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(tbMsgBuilder).metaData(isA(TbMsgMetaData.class));
  }

  /**
   * Test
   * {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)}.
   * <p>
   * Method under test:
   * {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)}
   */
  @Test
  @DisplayName("Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)")
  void testUpgradeConfigurationToUseFetchTo() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    ObjectNode newConfig = mock(ObjectNode.class);
    when(newConfig.get(Mockito.<String>any())).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbFetchDeviceCredentialsNode
        .upgradeConfigurationToUseFetchTo("Old Property", "If True", "If False", newConfig));
    verify(newConfig).get(eq("Old Property"));
  }

  /**
   * Test
   * {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)}.
   * <ul>
   *   <li>Then return First.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)}
   */
  @Test
  @DisplayName("Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); then return First")
  void testUpgradeConfigurationToUseFetchTo_thenReturnFirst() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    ObjectNode newConfig = mock(ObjectNode.class);
    when(newConfig.remove(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    when(newConfig.put(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(newConfig.get(Mockito.<String>any())).thenReturn(BooleanNode.getFalse());

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeConfigurationToUseFetchToResult = tbFetchDeviceCredentialsNode
        .upgradeConfigurationToUseFetchTo("Old Property", "If True", "If False", newConfig);

    // Assert
    verify(newConfig).get(eq("Old Property"));
    verify(newConfig).put(eq("fetchTo"), eq("If False"));
    verify(newConfig).remove(eq("Old Property"));
    assertTrue(actualUpgradeConfigurationToUseFetchToResult.getFirst());
    assertSame(newConfig, actualUpgradeConfigurationToUseFetchToResult.getSecond());
  }

  /**
   * Test
   * {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)}.
   * <ul>
   *   <li>Then return First.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)}
   */
  @Test
  @DisplayName("Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); then return First")
  void testUpgradeConfigurationToUseFetchTo_thenReturnFirst2() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    ObjectNode newConfig = mock(ObjectNode.class);
    when(newConfig.remove(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    when(newConfig.put(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(newConfig.get(Mockito.<String>any())).thenReturn(BooleanNode.getTrue());

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeConfigurationToUseFetchToResult = tbFetchDeviceCredentialsNode
        .upgradeConfigurationToUseFetchTo("Old Property", "If True", "If False", newConfig);

    // Assert
    verify(newConfig).get(eq("Old Property"));
    verify(newConfig).put(eq("fetchTo"), eq("If True"));
    verify(newConfig).remove(eq("Old Property"));
    assertTrue(actualUpgradeConfigurationToUseFetchToResult.getFirst());
    assertSame(newConfig, actualUpgradeConfigurationToUseFetchToResult.getSecond());
  }

  /**
   * Test
   * {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)}
   */
  @Test
  @DisplayName("Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); then throw NoSuchElementException")
  void testUpgradeConfigurationToUseFetchTo_thenThrowNoSuchElementException() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    ObjectNode newConfig = mock(ObjectNode.class);
    when(newConfig.remove(Mockito.<String>any())).thenThrow(new NoSuchElementException(Boolean.TRUE.toString()));
    when(newConfig.get(Mockito.<String>any())).thenReturn(BooleanNode.getFalse());

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> tbFetchDeviceCredentialsNode
        .upgradeConfigurationToUseFetchTo("Old Property", "If True", "If False", newConfig));
    verify(newConfig).get(eq("Old Property"));
    verify(newConfig).remove(eq("Old Property"));
  }

  /**
   * Test
   * {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)}
   */
  @Test
  @DisplayName("Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); then throw NoSuchElementException")
  void testUpgradeConfigurationToUseFetchTo_thenThrowNoSuchElementException2() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    ObjectNode newConfig = mock(ObjectNode.class);
    when(newConfig.remove(Mockito.<String>any())).thenThrow(new NoSuchElementException(Boolean.TRUE.toString()));
    when(newConfig.get(Mockito.<String>any())).thenReturn(BooleanNode.getTrue());

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> tbFetchDeviceCredentialsNode
        .upgradeConfigurationToUseFetchTo("Old Property", "If True", "If False", newConfig));
    verify(newConfig).get(eq("Old Property"));
    verify(newConfig).remove(eq("Old Property"));
  }

  /**
   * Test
   * {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)}.
   * <ul>
   *   <li>When {@link ObjectNode} {@link ObjectNode#get(String)} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)}
   */
  @Test
  @DisplayName("Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); when ObjectNode get(String) return Instance")
  void testUpgradeConfigurationToUseFetchTo_whenObjectNodeGetReturnInstance() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    ObjectNode newConfig = mock(ObjectNode.class);
    when(newConfig.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbFetchDeviceCredentialsNode
        .upgradeConfigurationToUseFetchTo("Old Property", "If True", "If False", newConfig));
    verify(newConfig).get(eq("Old Property"));
  }
}
