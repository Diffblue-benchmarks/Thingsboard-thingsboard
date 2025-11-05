package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.api.ScriptEngine;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbAbstractAlarmNodeDiffblueTest {
  @Mock private ScriptEngine scriptEngine;

  @InjectMocks private TbClearAlarmNode tbClearAlarmNode;

  /**
   * Test {@link TbAbstractAlarmNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>Then {@link TbClearAlarmNode} (default constructor) {@link TbAbstractAlarmNode#config}
   *       AlarmDetailsBuildJs is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then TbClearAlarmNode (default constructor) config AlarmDetailsBuildJs is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractAlarmNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_thenTbClearAlarmNodeConfigAlarmDetailsBuildJsIsNull()
      throws TbNodeException {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbClearAlarmNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration = tbClearAlarmNode.config;
    assertNull(tbClearAlarmNodeConfiguration.getAlarmDetailsBuildJs());
    assertNull(tbClearAlarmNodeConfiguration.getAlarmDetailsBuildTbel());
    assertNull(tbClearAlarmNodeConfiguration.getAlarmType());
    assertNull(tbClearAlarmNodeConfiguration.getScriptLang());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName("Test buildAlarmDetails(TbMsg, JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertTrue(tbClearAlarmNode.buildAlarmDetails(msg, DoubleNode.valueOf(10.0d)).isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName("Test buildAlarmDetails(TbMsg, JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails2() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertTrue(tbClearAlarmNode.buildAlarmDetails(msg, DoubleNode.valueOf(10.0d)).isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName("Test buildAlarmDetails(TbMsg, JsonNode); given Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenInstance() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode previousDetails = new ArrayNode(nf);
    previousDetails.add(MissingNode.getInstance());

    // Act and Assert
    assertTrue(tbClearAlarmNode.buildAlarmDetails(msg, previousDetails).isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link TbClearAlarmNode} (default constructor).
   *   <li>When Instance.
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); given TbClearAlarmNode (default constructor); when Instance; then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenTbClearAlarmNode_whenInstance_thenReturnDone() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertTrue(tbClearAlarmNode.buildAlarmDetails(msg, MissingNode.getInstance()).isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link TbClearAlarmNode} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); given TbClearAlarmNode (default constructor); when 'null'; then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenTbClearAlarmNode_whenNull_thenReturnDone() {
    // Arrange, Act and Assert
    assertTrue(new TbClearAlarmNode().buildAlarmDetails(null, DoubleNode.valueOf(10.0d)).isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link TbClearAlarmNode} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); given TbClearAlarmNode (default constructor); when 'null'; then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenTbClearAlarmNode_whenNull_thenReturnDone2() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertTrue(tbClearAlarmNode.buildAlarmDetails(msg, null).isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link TbClearAlarmNode} (default constructor).
   *   <li>When valueOf ten.
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); given TbClearAlarmNode (default constructor); when valueOf ten; then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenTbClearAlarmNode_whenValueOfTen_thenReturnDone() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertTrue(tbClearAlarmNode.buildAlarmDetails(msg, DoubleNode.valueOf(10.0d)).isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName("Test buildAlarmDetails(TbMsg, JsonNode); given valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenValueOfTen() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode previousDetails = new ArrayNode(nf);
    previousDetails.add(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertTrue(tbClearAlarmNode.buildAlarmDetails(msg, previousDetails).isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName("Test buildAlarmDetails(TbMsg, JsonNode); then return ApiFutureToListenableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_thenReturnApiFutureToListenableFuture() {
    // Arrange
    ListenableFutureToApiFuture<JsonNode> delegate =
        new ListenableFutureToApiFuture<>(mock(ListenableFutureTask.class));
    ForwardingApiFuture<JsonNode> apiFuture = new ForwardingApiFuture<>(delegate);
    ApiFutureToListenableFuture<JsonNode> apiFutureToListenableFuture =
        new ApiFutureToListenableFuture<>(apiFuture);
    when(scriptEngine.executeJsonAsync(Mockito.<TbMsg>any()))
        .thenReturn(apiFutureToListenableFuture);
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    ListenableFuture<JsonNode> actualBuildAlarmDetailsResult =
        tbClearAlarmNode.buildAlarmDetails(msg, DoubleNode.valueOf(10.0d));

    // Assert
    verify(scriptEngine).executeJsonAsync(isA(TbMsg.class));
    assertTrue(actualBuildAlarmDetailsResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualBuildAlarmDetailsResult);
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_whenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    // Act and Assert
    assertTrue(tbClearAlarmNode.buildAlarmDetails(msg, new ArrayNode(nf)).isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addArray.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddArray() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode previousDetails = new ArrayNode(nf);
    previousDetails.addArray();
    previousDetails.add(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertTrue(tbClearAlarmNode.buildAlarmDetails(msg, previousDetails).isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addObject.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddObject() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode previousDetails = new ArrayNode(nf);
    previousDetails.addObject();
    previousDetails.add(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertTrue(tbClearAlarmNode.buildAlarmDetails(msg, previousDetails).isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link ScriptEngine} {@link ScriptEngine#destroy()} does nothing.
   *   <li>Then calls {@link ScriptEngine#destroy()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given ScriptEngine destroy() does nothing; then calls destroy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractAlarmNode.destroy()"})
  void testDestroy_givenScriptEngineDestroyDoesNothing_thenCallsDestroy() {
    // Arrange
    doNothing().when(scriptEngine).destroy();

    // Act
    tbClearAlarmNode.destroy();

    // Assert
    verify(scriptEngine).destroy();
  }
}
