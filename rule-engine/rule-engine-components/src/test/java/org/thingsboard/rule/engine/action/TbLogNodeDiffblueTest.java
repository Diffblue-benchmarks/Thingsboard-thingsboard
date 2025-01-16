package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.ScriptEngine;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbLogNodeDiffblueTest {
  /**
   * Test {@link TbLogNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code START_OBJECT}.</li>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLogNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; when ArrayNode asToken() return 'START_OBJECT'; then calls fields()")
  void testInit_givenStartObject_whenArrayNodeAsTokenReturnStartObject_thenCallsFields() throws TbNodeException {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbLogNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
  }

  /**
   * Test {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code TBEL}.</li>
   *   <li>When {@link TbLogNodeConfiguration} (default constructor) ScriptLang is
   * {@code TBEL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName("Test createScriptEngine(TbContext, TbLogNodeConfiguration); given 'TBEL'; when TbLogNodeConfiguration (default constructor) ScriptLang is 'TBEL'")
  void testCreateScriptEngine_givenTbel_whenTbLogNodeConfigurationScriptLangIsTbel() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    TbLogNodeConfiguration config = new TbLogNodeConfiguration();
    config.setScriptLang(ScriptLanguage.TBEL);

    // Act
    tbLogNode.createScriptEngine(ctx, config);

    // Assert
    verify(ctx).createScriptEngine(eq(ScriptLanguage.TBEL), isNull(), isA(String[].class));
  }

  /**
   * Test {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}.
   * <ul>
   *   <li>When {@link TbLogNodeConfiguration} (default constructor).</li>
   *   <li>Then calls
   * {@link TbContext#createScriptEngine(ScriptLanguage, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName("Test createScriptEngine(TbContext, TbLogNodeConfiguration); when TbLogNodeConfiguration (default constructor); then calls createScriptEngine(ScriptLanguage, String, String[])")
  void testCreateScriptEngine_whenTbLogNodeConfiguration_thenCallsCreateScriptEngine() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    // Act
    tbLogNode.createScriptEngine(ctx, new TbLogNodeConfiguration());

    // Assert
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
  }

  /**
   * Test {@link TbLogNode#isStandard(TbLogNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code JS}.</li>
   *   <li>When {@link TbLogNodeConfiguration} (default constructor) ScriptLang is
   * {@code JS}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLogNode#isStandard(TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName("Test isStandard(TbLogNodeConfiguration); given 'JS'; when TbLogNodeConfiguration (default constructor) ScriptLang is 'JS'; then return 'false'")
  void testIsStandard_givenJs_whenTbLogNodeConfigurationScriptLangIsJs_thenReturnFalse() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbLogNodeConfiguration conf = new TbLogNodeConfiguration();
    conf.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertFalse(tbLogNode.isStandard(conf));
  }

  /**
   * Test {@link TbLogNode#isStandard(TbLogNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code TBEL}.</li>
   *   <li>When {@link TbLogNodeConfiguration} (default constructor) ScriptLang is
   * {@code TBEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLogNode#isStandard(TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName("Test isStandard(TbLogNodeConfiguration); given 'TBEL'; when TbLogNodeConfiguration (default constructor) ScriptLang is 'TBEL'")
  void testIsStandard_givenTbel_whenTbLogNodeConfigurationScriptLangIsTbel() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbLogNodeConfiguration conf = new TbLogNodeConfiguration();
    conf.setScriptLang(ScriptLanguage.TBEL);

    // Act and Assert
    assertFalse(tbLogNode.isStandard(conf));
  }

  /**
   * Test {@link TbLogNode#isStandard(TbLogNodeConfiguration)}.
   * <ul>
   *   <li>When {@link TbLogNodeConfiguration} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLogNode#isStandard(TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName("Test isStandard(TbLogNodeConfiguration); when TbLogNodeConfiguration (default constructor); then return 'false'")
  void testIsStandard_whenTbLogNodeConfiguration_thenReturnFalse() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    // Act and Assert
    assertFalse(tbLogNode.isStandard(new TbLogNodeConfiguration()));
  }

  /**
   * Test {@link TbLogNode#logStandard(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link TbMsgMetaData#TbMsgMetaData()} Value {@code 42} is
   * {@code Value}.</li>
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLogNode#logStandard(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test logStandard(TbContext, TbMsg); given '42'; when TbMsgMetaData() Value '42' is 'Value'; then calls tellSuccess(TbMsg)")
  void testLogStandard_given42_whenTbMsgMetaDataValue42IsValue_thenCallsTellSuccess() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(metaData)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbLogNode.logStandard(ctx, msg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbLogNode#logStandard(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLogNode#logStandard(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test logStandard(TbContext, TbMsg); then calls tellSuccess(TbMsg)")
  void testLogStandard_thenCallsTellSuccess() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
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

    // Act
    tbLogNode.logStandard(ctx, msg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }
}
