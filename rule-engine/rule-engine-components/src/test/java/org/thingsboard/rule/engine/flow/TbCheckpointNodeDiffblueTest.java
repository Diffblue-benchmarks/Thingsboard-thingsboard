package org.thingsboard.rule.engine.flow;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;

class TbCheckpointNodeDiffblueTest {
  /**
   * Test {@link TbCheckpointNode#init(TbContext, TbNodeConfiguration)}.
   * <p>
   * Method under test:
   * {@link TbCheckpointNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration)")
  void testInit() throws TbNodeException {
    // Arrange
    TbCheckpointNode tbCheckpointNode = new TbCheckpointNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenReturn("Queue Name");

    // Act
    tbCheckpointNode.init(ctx, new TbNodeConfiguration(MissingNode.getInstance()));

    // Assert
    verify(ctx).getQueueName();
  }

  /**
   * Test {@link TbCheckpointNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbCheckpointNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg() {
    // Arrange
    TbCheckpointNode tbCheckpointNode = new TbCheckpointNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx)
        .enqueueForTellNext(Mockito.<TbMsg>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Runnable>any(),
            Mockito.<Consumer<Throwable>>any());

    // Act
    tbCheckpointNode.onMsg(ctx, null);

    // Assert
    verify(ctx).enqueueForTellNext((TbMsg) isNull(), (String) isNull(), eq("Success"), isA(Runnable.class),
        isA(Consumer.class));
  }

  /**
   * Test {@link TbCheckpointNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Given {@link TbCheckpointNode} (default constructor).</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCheckpointNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given TbCheckpointNode (default constructor); when one")
  void testUpgrade_givenTbCheckpointNode_whenOne() throws TbNodeException {
    // Arrange
    TbCheckpointNode tbCheckpointNode = new TbCheckpointNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbCheckpointNode.upgrade(1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbCheckpointNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Given {@link TbCheckpointNode} (default constructor).</li>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCheckpointNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given TbCheckpointNode (default constructor); when zero")
  void testUpgrade_givenTbCheckpointNode_whenZero() throws TbNodeException {
    // Arrange
    TbCheckpointNode tbCheckpointNode = new TbCheckpointNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbCheckpointNode.upgrade(0, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbCheckpointNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Given {@link TbContext} {@link TbContext#getQueueName()} return
   * {@code Queue Name}.</li>
   *   <li>Then calls {@link TbContext#getQueueName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCheckpointNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given TbContext getQueueName() return 'Queue Name'; then calls getQueueName()")
  void testUpgrade_givenTbContextGetQueueNameReturnQueueName_thenCallsGetQueueName() throws TbNodeException {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenReturn("Queue Name");

    TbCheckpointNode tbCheckpointNode = new TbCheckpointNode();
    tbCheckpointNode.init(ctx, new TbNodeConfiguration(MissingNode.getInstance()));
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbCheckpointNode.upgrade(1, oldConfiguration);

    // Assert
    verify(ctx).getQueueName();
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }
}
