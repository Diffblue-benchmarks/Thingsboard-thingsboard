package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.EmptyNodeConfiguration;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;

class TbMsgTypeSwitchNodeDiffblueTest {
  /**
   * Test {@link TbMsgTypeSwitchNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@link
   *       POJONode#POJONode(Object)} Data {@link POJONode}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTypeSwitchNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); then TbNodeConfiguration(JsonNode) with data is POJONode(Object) Data POJONode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTypeSwitchNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenTbNodeConfigurationWithDataIsPOJONodeDataPOJONode() throws TbNodeException {
    // Arrange
    TbMsgTypeSwitchNode tbMsgTypeSwitchNode = new TbMsgTypeSwitchNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    EmptyNodeConfiguration emptyNodeConfiguration = new EmptyNodeConfiguration();
    TbNodeConfiguration configuration =
        new TbNodeConfiguration(new POJONode(emptyNodeConfiguration));

    // Act
    tbMsgTypeSwitchNode.init(ctx, configuration);

    // Assert
    JsonNode data = configuration.getData();
    assertTrue(data instanceof POJONode);
    Object pojo = ((POJONode) data).getPojo();
    assertTrue(pojo instanceof EmptyNodeConfiguration);
    assertEquals(0, tbMsgTypeSwitchNode.config.getVersion());
    assertSame(emptyNodeConfiguration, pojo);
  }

  /**
   * Test {@link TbMsgTypeSwitchNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellNext(TbMsg, String)} does nothing.
   *   <li>Then calls {@link TbContext#tellNext(TbMsg, String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTypeSwitchNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext tellNext(TbMsg, String) does nothing; then calls tellNext(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTypeSwitchNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextTellNextDoesNothing_thenCallsTellNext() {
    // Arrange
    TbMsgTypeSwitchNode tbMsgTypeSwitchNode = new TbMsgTypeSwitchNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgTypeSwitchNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Post telemetry"));
  }

  /**
   * Test new {@link TbMsgTypeSwitchNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbMsgTypeSwitchNode}
   */
  @Test
  @DisplayName("Test new TbMsgTypeSwitchNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTypeSwitchNode.<init>()"})
  void testNewTbMsgTypeSwitchNode() {
    // Arrange, Act and Assert
    assertNull(new TbMsgTypeSwitchNode().config);
  }
}
