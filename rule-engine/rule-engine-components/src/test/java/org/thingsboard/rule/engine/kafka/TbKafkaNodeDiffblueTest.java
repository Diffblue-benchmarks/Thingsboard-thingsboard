package org.thingsboard.rule.engine.kafka;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.RuleNodeId;

class TbKafkaNodeDiffblueTest {
  /**
   * Test {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>Then calls {@link TbContext#getServiceId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then calls getServiceId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbKafkaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenCallsGetServiceId() throws TbNodeException {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getServiceId()).thenThrow(new RuntimeException("client.id"));
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbKafkaNode.init(ctx, new TbNodeConfiguration(NullNode.getInstance())));
    verify(ctx).getSelfId();
    verify(ctx).getServiceId();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when TbNodeConfiguration(JsonNode) with data is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbKafkaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenTbNodeConfigurationWithDataIsNull() throws TbNodeException {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId()).thenThrow(new RuntimeException("client.id"));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbKafkaNode.init(ctx, new TbNodeConfiguration(null)));
    verify(ctx).getSelfId();
    verify(ctx).isExternalNodeForceAck();
  }
}
