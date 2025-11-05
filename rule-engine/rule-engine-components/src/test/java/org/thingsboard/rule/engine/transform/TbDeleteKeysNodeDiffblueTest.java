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
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbDeleteKeysNodeDiffblueTest {
  @Mock private List<Pattern> list;

  @InjectMocks private TbDeleteKeysNode tbDeleteKeysNode;

  @Mock private TbMsgSource tbMsgSource;

  /**
   * Test {@link TbDeleteKeysNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeleteKeysNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbDeleteKeysNode tbDeleteKeysNode = new TbDeleteKeysNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbDeleteKeysNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new TbDeleteKeysNodeConfiguration()))));
  }

  /**
   * Test {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeleteKeysNode.onMsg(TbContext, TbMsg)"})
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
    tbDeleteKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>Then calls {@link List#stream()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ArrayList() add compile '.*\\.txt'; then calls stream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeleteKeysNode.onMsg(TbContext, TbMsg)"})
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
    tbDeleteKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>Then calls {@link List#stream()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ArrayList() add compile '.*\\.txt'; then calls stream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeleteKeysNode.onMsg(TbContext, TbMsg)"})
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
    tbDeleteKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgSource} {@link TbMsgSource#ordinal()} return one.
   *   <li>Then calls {@link TbMsgSource#ordinal()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgSource ordinal() return one; then calls ordinal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeleteKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgSourceOrdinalReturnOne_thenCallsOrdinal()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(1);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbDeleteKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgSource} {@link TbMsgSource#ordinal()} return zero.
   *   <li>Then calls {@link List#stream()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgSource ordinal() return zero; then calls stream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeleteKeysNode.onMsg(TbContext, TbMsg)"})
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
    tbDeleteKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when AlarmId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeleteKeysNode.onMsg(TbContext, TbMsg)"})
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
    tbDeleteKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbDeleteKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#matches(String)}
   */
  @Test
  @DisplayName(
      "Test matches(String); given ArrayList() add compile '.*\\.txt'; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbDeleteKeysNode.matches(String)"})
  void testMatches_givenArrayListAddCompileTxt_whenKey_thenReturnFalse() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbDeleteKeysNode.matches("Key");

    // Assert
    verify(list).stream();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link TbDeleteKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#matches(String)}
   */
  @Test
  @DisplayName(
      "Test matches(String); given ArrayList() add compile '.*\\.txt'; when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbDeleteKeysNode.matches(String)"})
  void testMatches_givenArrayListAddCompileTxt_whenKey_thenReturnFalse2() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbDeleteKeysNode.matches("Key");

    // Assert
    verify(list).stream();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link TbDeleteKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add compile {@code .*\.txt}.
   *   <li>When {@code U.txt}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#matches(String)}
   */
  @Test
  @DisplayName(
      "Test matches(String); given ArrayList() add compile '.*\\.txt'; when 'U.txt'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbDeleteKeysNode.matches(String)"})
  void testMatches_givenArrayListAddCompileTxt_whenUTxt_thenReturnTrue() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    patternList.add(Pattern.compile(".*\\.txt"));
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbDeleteKeysNode.matches("U.txt");

    // Assert
    verify(list).stream();
    assertTrue(actualMatchesResult);
  }

  /**
   * Test {@link TbDeleteKeysNode#matches(String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNode#matches(String)}
   */
  @Test
  @DisplayName("Test matches(String); when 'Key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbDeleteKeysNode.matches(String)"})
  void testMatches_whenKey_thenReturnFalse() {
    // Arrange
    ArrayList<Pattern> patternList = new ArrayList<>();
    Stream<Pattern> streamResult = patternList.stream();
    when(list.stream()).thenReturn(streamResult);

    // Act
    boolean actualMatchesResult = tbDeleteKeysNode.matches("Key");

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
   *   <li>default or parameterless constructor of {@link TbDeleteKeysNode}
   *   <li>{@link TbDeleteKeysNode#getKeyToUpgradeFromVersionOne()}
   *   <li>{@link TbDeleteKeysNode#getNewKeyForUpgradeFromVersionZero()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbDeleteKeysNode.<init>()",
    "String TbDeleteKeysNode.getKeyToUpgradeFromVersionOne()",
    "String TbDeleteKeysNode.getNewKeyForUpgradeFromVersionZero()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbDeleteKeysNode actualTbDeleteKeysNode = new TbDeleteKeysNode();
    String actualKeyToUpgradeFromVersionOne =
        actualTbDeleteKeysNode.getKeyToUpgradeFromVersionOne();

    // Assert
    assertEquals("dataToFetch", actualKeyToUpgradeFromVersionOne);
    assertEquals("deleteFrom", actualTbDeleteKeysNode.getNewKeyForUpgradeFromVersionZero());
  }
}
