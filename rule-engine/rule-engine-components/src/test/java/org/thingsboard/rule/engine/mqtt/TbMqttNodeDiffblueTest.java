package org.thingsboard.rule.engine.mqtt;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.mqtt.MqttClientConfig;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleNode;

class TbMqttNodeDiffblueTest {
  /**
   * Test {@link TbMqttNode#init(TbContext, TbNodeConfiguration)} with
   * {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMqttNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw TbNodeException")
  void testInitWithCtxConfiguration_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenThrow(new RuntimeException("netty-mqtt/"));
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    JsonNode data = mock(JsonNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbMqttNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).fields();
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbMqttNode#destroy()}.
   * <ul>
   *   <li>Then calls {@link TbContext#isExternalNodeForceAck()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMqttNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); then calls isExternalNodeForceAck()")
  void testDestroy_thenCallsIsExternalNodeForceAck() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbMqttNode tbMqttNode = new TbMqttNode();
    tbMqttNode.init(ctx);

    // Act
    tbMqttNode.destroy();

    // Assert that nothing has changed
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbMqttNode#getOwnerId(TbContext)}.
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()} Id is
   * {@link RuleNodeId#RuleNodeId(UUID)} with id is randomUUID.</li>
   *   <li>Then calls {@link TbContext#getSelf()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMqttNode#getOwnerId(TbContext)}
   */
  @Test
  @DisplayName("Test getOwnerId(TbContext); given RuleNode() Id is RuleNodeId(UUID) with id is randomUUID; then calls getSelf()")
  void testGetOwnerId_givenRuleNodeIdIsRuleNodeIdWithIdIsRandomUUID_thenCallsGetSelf() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();

    RuleNode ruleNode = new RuleNode();
    ruleNode.setId(new RuleNodeId(UUID.randomUUID()));
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenReturn(ruleNode);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    tbMqttNode.getOwnerId(ctx);

    // Assert
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbMqttNode#getOwnerId(TbContext)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMqttNode#getOwnerId(TbContext)}
   */
  @Test
  @DisplayName("Test getOwnerId(TbContext); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testGetOwnerId_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenThrow(new RuntimeException("foo"));
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMqttNode.getOwnerId(ctx));
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}
   */
  @Test
  @DisplayName("Test getMqttClient(TbContext, MqttClientConfig); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testGetMqttClient_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getExternalCallExecutor()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMqttNode.getMqttClient(ctx, new MqttClientConfig()));
    verify(ctx).getExternalCallExecutor();
  }

  /**
   * Test {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}.
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}
   */
  @Test
  @DisplayName("Test getMqttClient(TbContext, MqttClientConfig); given TestDbCallbackExecutor (default constructor)")
  void testGetMqttClient_givenTestDbCallbackExecutor() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());

    // Act
    tbMqttNode.getMqttClient(ctx, new MqttClientConfig());

    // Assert
    verify(ctx).getExternalCallExecutor();
  }

  /**
   * Test {@link TbMqttNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Given {@link TbMqttNode} (default constructor).</li>
   *   <li>When one.</li>
   *   <li>Then return Second is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMqttNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given TbMqttNode (default constructor); when one; then return Second is Instance")
  void testUpgrade_givenTbMqttNode_whenOne_thenReturnSecondIsInstance() throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act and Assert
    assertSame(oldConfiguration, tbMqttNode.upgrade(1, oldConfiguration).getSecond());
  }

  /**
   * Test new {@link TbMqttNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbMqttNode}
   */
  @Test
  @DisplayName("Test new TbMqttNode (default constructor)")
  void testNewTbMqttNode() {
    // Arrange and Act
    TbMqttNode actualTbMqttNode = new TbMqttNode();

    // Assert
    assertNull(actualTbMqttNode.mqttClient);
    assertNull(actualTbMqttNode.mqttNodeConfiguration);
  }
}
