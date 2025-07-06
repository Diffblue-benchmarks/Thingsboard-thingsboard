package org.thingsboard.rule.engine.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.mqtt.MqttClientConfig;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.data.util.TbPair;

class TbMqttNodeDiffblueTest {
  /**
   * Test {@link TbMqttNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <p>Method under test: {@link TbMqttNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMqttNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration() throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException("netty-mqtt/"));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    JsonNode data = mock(JsonNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbMqttNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).fields();
    verify(ctx).getTenantId();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbMqttNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link JsonToken#VALUE_EMBEDDED_OBJECT}.
   *   <li>Then calls {@link JsonNode#isPojo()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given VALUE_EMBEDDED_OBJECT; then calls isPojo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMqttNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenValue_embedded_object_thenCallsIsPojo()
      throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    JsonNode data = mock(JsonNode.class);
    when(data.isPojo()).thenThrow(new RuntimeException("foo"));
    when(data.asToken()).thenReturn(JsonToken.VALUE_EMBEDDED_OBJECT);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMqttNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).isPojo();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbMqttNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getSelf()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then calls getSelf()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMqttNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenCallsGetSelf() throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenThrow(new RuntimeException("netty-mqtt/"));
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    JsonNode data = mock(JsonNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
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
   * Test {@link TbMqttNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link JsonNode} {@link JsonNode#fields()} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when JsonNode fields() throw RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMqttNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenJsonNodeFieldsThrowRuntimeExceptionWithFoo()
      throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    JsonNode data = mock(JsonNode.class);
    when(data.fields()).thenThrow(new RuntimeException("foo"));
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMqttNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).fields();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbMqttNode#getOwnerId(TbContext)}.
   *
   * <p>Method under test: {@link TbMqttNode#getOwnerId(TbContext)}
   */
  @Test
  @DisplayName("Test getOwnerId(TbContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbMqttNode.getOwnerId(TbContext)"})
  void testGetOwnerId() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();

    RuleNode ruleNode = new RuleNode();
    ruleNode.setId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenReturn(ruleNode);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    String actualOwnerId = tbMqttNode.getOwnerId(ctx);

    // Assert
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
    assertEquals(
        "Tenant[784f394c-42b6-435a-983c-b7beff2784f9]RuleNode[784f394c-42b6-435a-983c-b7beff2784f9]",
        actualOwnerId);
  }

  /**
   * Test {@link TbMqttNode#getOwnerId(TbContext)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getSelf()} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#getOwnerId(TbContext)}
   */
  @Test
  @DisplayName(
      "Test getOwnerId(TbContext); when TbContext getSelf() throw RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbMqttNode.getOwnerId(TbContext)"})
  void testGetOwnerId_whenTbContextGetSelfThrowRuntimeExceptionWithFoo() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenThrow(new RuntimeException("foo"));
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMqttNode.getOwnerId(ctx));
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbMqttNode#getOwnerId(TbContext)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getTenantId()} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#getOwnerId(TbContext)}
   */
  @Test
  @DisplayName(
      "Test getOwnerId(TbContext); when TbContext getTenantId() throw RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbMqttNode.getOwnerId(TbContext)"})
  void testGetOwnerId_whenTbContextGetTenantIdThrowRuntimeExceptionWithFoo() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMqttNode.getOwnerId(ctx));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}
   */
  @Test
  @DisplayName(
      "Test getMqttClient(TbContext, MqttClientConfig); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.mqtt.MqttClient TbMqttNode.getMqttClient(TbContext, MqttClientConfig)"
  })
  void testGetMqttClient_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getExternalCallExecutor()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbMqttNode.getMqttClient(ctx, new MqttClientConfig()));
    verify(ctx).getExternalCallExecutor();
  }

  /**
   * Test {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}.
   *
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}
   */
  @Test
  @DisplayName(
      "Test getMqttClient(TbContext, MqttClientConfig); given TestDbCallbackExecutor (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.mqtt.MqttClient TbMqttNode.getMqttClient(TbContext, MqttClientConfig)"
  })
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
   *
   * <ul>
   *   <li>Given {@link TbMqttNode} (default constructor).
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given TbMqttNode (default constructor); when one; then Second return DoubleNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbMqttNode.upgrade(int, JsonNode)"})
  void testUpgrade_givenTbMqttNode_whenOne_thenSecondReturnDoubleNode() throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbMqttNode.upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof DoubleNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbMqttNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbMqttNode}
   */
  @Test
  @DisplayName("Test new TbMqttNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMqttNode.<init>()"})
  void testNewTbMqttNode() {
    // Arrange and Act
    TbMqttNode actualTbMqttNode = new TbMqttNode();

    // Assert
    assertNull(actualTbMqttNode.mqttClient);
    assertNull(actualTbMqttNode.mqttNodeConfiguration);
  }
}
