package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.ScriptEngine;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.script.ScriptLanguage;

class TbTransformMsgNodeDiffblueTest {
  /**
   * Test {@link TbTransformMsgNode#loadNodeConfiguration(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code TBEL}.
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNode#loadNodeConfiguration(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbContext, TbNodeConfiguration); given 'TBEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbTransformMsgNodeConfiguration TbTransformMsgNode.loadNodeConfiguration(TbContext, TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_givenTbel() throws TbNodeException {
    // Arrange
    TbTransformMsgNode tbTransformMsgNode = new TbTransformMsgNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration.setScriptLang(ScriptLanguage.TBEL);

    // Act
    TbTransformMsgNodeConfiguration actualLoadNodeConfigurationResult =
        tbTransformMsgNode.loadNodeConfiguration(
            ctx, new TbNodeConfiguration(new POJONode(tbTransformMsgNodeConfiguration)));

    // Assert
    verify(ctx).createScriptEngine(eq(ScriptLanguage.TBEL), isNull(), isA(String[].class));
    assertSame(tbTransformMsgNodeConfiguration, actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbTransformMsgNode#loadNodeConfiguration(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbTransformMsgNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNode#loadNodeConfiguration(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbContext, TbNodeConfiguration); then return TbTransformMsgNodeConfiguration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbTransformMsgNodeConfiguration TbTransformMsgNode.loadNodeConfiguration(TbContext, TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenReturnTbTransformMsgNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbTransformMsgNode tbTransformMsgNode = new TbTransformMsgNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();

    // Act
    TbTransformMsgNodeConfiguration actualLoadNodeConfigurationResult =
        tbTransformMsgNode.loadNodeConfiguration(
            ctx, new TbNodeConfiguration(new POJONode(tbTransformMsgNodeConfiguration)));

    // Assert
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
    assertSame(tbTransformMsgNodeConfiguration, actualLoadNodeConfigurationResult);
  }

  /**
   * Test new {@link TbTransformMsgNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbTransformMsgNode}
   */
  @Test
  @DisplayName("Test new TbTransformMsgNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbTransformMsgNode.<init>()"})
  void testNewTbTransformMsgNode() {
    // Arrange, Act and Assert
    assertNull(new TbTransformMsgNode().config);
  }
}
