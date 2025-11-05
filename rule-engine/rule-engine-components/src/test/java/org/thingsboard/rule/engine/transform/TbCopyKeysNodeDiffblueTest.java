package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.util.TbMsgSource;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

@ExtendWith(MockitoExtension.class)
class TbCopyKeysNodeDiffblueTest {
  @Mock private List<Pattern> list;

  @InjectMocks private TbCopyKeysNode tbCopyKeysNode;

  @Mock private TbMsgSource tbMsgSource;

  /**
   * Test {@link TbCopyKeysNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@link TbCopyKeysNodeConfiguration}
   *       (default constructor).
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when POJONode(Object) with v is TbCopyKeysNodeConfiguration (default constructor); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenPOJONodeWithVIsTbCopyKeysNodeConfiguration_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbCopyKeysNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new TbCopyKeysNodeConfiguration()))));
  }

  /**
   * Test {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);
    when(tbMsgSource.ordinal()).thenReturn(0);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            null, "U.txt", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbCopyKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>Then calls {@link List#stream()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ArrayList() add compile '.*\\.txt'; then calls stream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenArrayListAddCompileTxt_thenCallsStream()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);
    when(tbMsgSource.ordinal()).thenReturn(0);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbCopyKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>Then calls {@link List#stream()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ArrayList() add compile '.*\\.txt'; then calls stream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenArrayListAddCompileTxt_thenCallsStream2()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);
    when(tbMsgSource.ordinal()).thenReturn(0);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbCopyKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link TbMsgMetaData#TbMsgMetaData()} Value empty string is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given empty string; when TbMsgMetaData() Value empty string is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenEmptyString_whenTbMsgMetaDataValueEmptyStringIsEmptyString()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("", "");

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("42")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(metaData)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    tbCopyKeysNode.onMsg(
        ctx,
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build());

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link TbMsgMetaData#TbMsgMetaData()} Value {@code Key} is {@code 42}.
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'Key'; when TbMsgMetaData() Value 'Key' is '42'; then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenKey_whenTbMsgMetaDataValueKeyIs42_thenCallsTellSuccess()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");
    metaData.putValue("", "");

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("42")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(metaData)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    tbCopyKeysNode.onMsg(
        ctx,
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build());

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbCopyKeysNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given TbCopyKeysNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbCopyKeysNode()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("42")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    tbCopyKeysNode.onMsg(
        ctx,
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build());

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgSource} {@link TbMsgSource#ordinal()} return one.
   *   <li>Then calls {@link TbMsgSource#ordinal()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgSource ordinal() return one; then calls ordinal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgSourceOrdinalReturnOne_thenCallsOrdinal()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(1);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbCopyKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgSource} {@link TbMsgSource#ordinal()} return zero.
   *   <li>Then calls {@link List#stream()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgSource ordinal() return zero; then calls stream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgSourceOrdinalReturnZero_thenCallsStream()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);
    when(tbMsgSource.ordinal()).thenReturn(0);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbCopyKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when AlarmId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenAlarmIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);
    when(tbMsgSource.ordinal()).thenReturn(0);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "U.txt", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbCopyKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbTelemetryMsgFactory#telemetryMsg(EntityId, String, Object)} with originator
   *       is {@code null} and key is {@code U.txt} and value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when telemetryMsg(EntityId, String, Object) with originator is 'null' and key is 'U.txt' and value is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTelemetryMsgWithOriginatorIsNullAndKeyIsUTxtAndValueIsFortyTwo()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);
    when(tbMsgSource.ordinal()).thenReturn(0);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg = TbTelemetryMsgFactory.telemetryMsg(null, "U.txt", 42);

    // Act
    tbCopyKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbCopyKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#matches(String)}
   */
  @Test
  @DisplayName(
      "Test matches(String); given ArrayList() add compile '.*\\.txt'; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbCopyKeysNode.matches(String)"})
  void testMatches_givenArrayListAddCompileTxt_whenKey_thenReturnFalse() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbCopyKeysNode.matches("Key");

    // Assert
    verify(list).stream();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link TbCopyKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#matches(String)}
   */
  @Test
  @DisplayName(
      "Test matches(String); given ArrayList() add compile '.*\\.txt'; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbCopyKeysNode.matches(String)"})
  void testMatches_givenArrayListAddCompileTxt_whenKey_thenReturnFalse2() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbCopyKeysNode.matches("Key");

    // Assert
    verify(list).stream();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link TbCopyKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@code U.txt}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#matches(String)}
   */
  @Test
  @DisplayName(
      "Test matches(String); given ArrayList() add compile '.*\\.txt'; when 'U.txt'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbCopyKeysNode.matches(String)"})
  void testMatches_givenArrayListAddCompileTxt_whenUTxt_thenReturnTrue() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbCopyKeysNode.matches("U.txt");

    // Assert
    verify(list).stream();
    assertTrue(actualMatchesResult);
  }

  /**
   * Test {@link TbCopyKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNode#matches(String)}
   */
  @Test
  @DisplayName("Test matches(String); when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbCopyKeysNode.matches(String)"})
  void testMatches_whenKey_thenReturnFalse() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbCopyKeysNode.matches("Key");

    // Assert
    verify(list).stream();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbCopyKeysNode}
   *   <li>{@link TbCopyKeysNode#getKeyToUpgradeFromVersionOne()}
   *   <li>{@link TbCopyKeysNode#getNewKeyForUpgradeFromVersionZero()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbCopyKeysNode.<init>()",
    "String TbCopyKeysNode.getKeyToUpgradeFromVersionOne()",
    "String TbCopyKeysNode.getNewKeyForUpgradeFromVersionZero()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbCopyKeysNode actualTbCopyKeysNode = new TbCopyKeysNode();
    String actualKeyToUpgradeFromVersionOne = actualTbCopyKeysNode.getKeyToUpgradeFromVersionOne();

    // Assert
    assertEquals("copyFrom", actualTbCopyKeysNode.getNewKeyForUpgradeFromVersionZero());
    assertEquals("fromMetadata", actualKeyToUpgradeFromVersionOne);
  }
}
