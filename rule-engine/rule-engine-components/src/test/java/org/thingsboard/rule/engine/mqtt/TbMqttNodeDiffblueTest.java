package org.thingsboard.rule.engine.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

class TbMqttNodeDiffblueTest {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMqttNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenCallsGetSelf() throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenThrow(new RuntimeException());
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
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMqttNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    JsonNode data = mock(JsonNode.class);
    when(data.fields()).thenThrow(new RuntimeException());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMqttNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).fields();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbMqttNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getTenantId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when TbContext getTenantId() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMqttNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenTbContextGetTenantIdThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException());
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
   * Test {@link TbMqttNode#getOwnerId(TbContext)}.
   *
   * <p>Method under test: {@link TbMqttNode#getOwnerId(TbContext)}
   */
  @Test
  @DisplayName("Test getOwnerId(TbContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#getOwnerId(TbContext)}
   */
  @Test
  @DisplayName("Test getOwnerId(TbContext); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbMqttNode.getOwnerId(TbContext)"})
  void testGetOwnerId_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenThrow(new RuntimeException());
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMqttNode.getOwnerId(ctx));
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}.
   *
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).
   *   <li>Then calls {@link TbContext#getExternalCallExecutor()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}
   */
  @Test
  @DisplayName(
      "Test getMqttClient(TbContext, MqttClientConfig); given TestDbCallbackExecutor (default constructor); then calls getExternalCallExecutor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.mqtt.MqttClient TbMqttNode.getMqttClient(TbContext, MqttClientConfig)"
  })
  void testGetMqttClient_givenTestDbCallbackExecutor_thenCallsGetExternalCallExecutor() {
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
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given TbMqttNode (default constructor); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMqttNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_givenTbMqttNode_whenOne_thenReturnSecondIsValueOfTen() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(oldConfiguration, new TbMqttNode().upgrade(1, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbMqttNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Second is {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is
   *       withExactBigDecimals {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then return Second is ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMqttNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_thenReturnSecondIsObjectNodeWithNcIsWithExactBigDecimalsTrue()
      throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("parseToPlainText", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertSame(oldConfiguration, tbMqttNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test new {@link TbMqttNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbMqttNode}
   */
  @Test
  @DisplayName("Test new TbMqttNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMqttNode.<init>()"})
  void testNewTbMqttNode() {
    // Arrange and Act
    TbMqttNode actualTbMqttNode = new TbMqttNode();

    // Assert
    assertNull(actualTbMqttNode.mqttClient);
    assertNull(actualTbMqttNode.mqttNodeConfiguration);
  }
}
