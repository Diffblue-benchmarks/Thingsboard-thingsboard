package org.thingsboard.rule.engine.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.mqtt.MqttClientConfig;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleNode;

class TbMqttNodeDiffblueTest {
  /**
   * Test {@link TbMqttNode#getOwnerId(TbContext)}.
   * <p>
   * Method under test: {@link TbMqttNode#getOwnerId(TbContext)}
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
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    String actualOwnerId = tbMqttNode.getOwnerId(ctx);

    // Assert
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
    assertEquals("Tenant[784f394c-42b6-435a-983c-b7beff2784f9]RuleNode[784f394c-42b6-435a-983c-b7beff2784f9]",
        actualOwnerId);
  }

  /**
   * Test {@link TbMqttNode#getOwnerId(TbContext)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMqttNode#getOwnerId(TbContext)}
   */
  @Test
  @DisplayName("Test getOwnerId(TbContext); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbMqttNode.getOwnerId(TbContext)"})
  void testGetOwnerId_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenThrow(new RuntimeException("foo"));
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMqttNode.getOwnerId(ctx));
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}
   */
  @Test
  @DisplayName("Test getMqttClient(TbContext, MqttClientConfig); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.mqtt.MqttClient TbMqttNode.getMqttClient(TbContext, MqttClientConfig)"})
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
   * Method under test: {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}
   */
  @Test
  @DisplayName("Test getMqttClient(TbContext, MqttClientConfig); given TestDbCallbackExecutor (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.mqtt.MqttClient TbMqttNode.getMqttClient(TbContext, MqttClientConfig)"})
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
   * Test new {@link TbMqttNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbMqttNode}
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
