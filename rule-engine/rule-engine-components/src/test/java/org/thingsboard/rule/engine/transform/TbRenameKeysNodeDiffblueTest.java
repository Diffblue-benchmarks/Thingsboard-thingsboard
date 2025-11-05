package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.transform.MapEntry;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
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
class TbRenameKeysNodeDiffblueTest {
  @Mock private Map<String, String> map;

  @Mock private TbMsgSource tbMsgSource;

  @InjectMocks private TbRenameKeysNode tbRenameKeysNode;

  /**
   * Test {@link TbRenameKeysNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbRenameKeysNode tbRenameKeysNode = new TbRenameKeysNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbRenameKeysNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new TbRenameKeysNodeConfiguration()))));
  }

  /**
   * Test {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link MapEntry} (default constructor).
   *   <li>Then calls {@link TbMsgSource#ordinal()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given HashSet() add MapEntry (default constructor); then calls ordinal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenHashSetAddMapEntry_thenCallsOrdinal()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(0);

    HashSet<Entry<String, String>> entrySet = new HashSet<>();
    entrySet.add(new MapEntry<>());
    when(map.entrySet()).thenReturn(entrySet);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbRenameKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(map).entrySet();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link AbstractMap.SimpleEntry#SimpleEntry(Object,
   *       Object)} with {@code Key} and {@code 42}.
   *   <li>Then calls {@link TbMsgSource#ordinal()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given HashSet() add SimpleEntry(Object, Object) with 'Key' and '42'; then calls ordinal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenHashSetAddSimpleEntryWithKeyAnd42_thenCallsOrdinal()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(1);

    HashSet<Entry<String, String>> entrySet = new HashSet<>();
    entrySet.add(new SimpleEntry<>("Key", "42"));
    when(map.entrySet()).thenReturn(entrySet);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbRenameKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(map).entrySet();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link AbstractMap.SimpleEntry#SimpleEntry(Object,
   *       Object)} with {@code Key} and {@code 42}.
   *   <li>Then calls {@link TbMsgSource#ordinal()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given HashSet() add SimpleEntry(Object, Object) with 'Key' and '42'; then calls ordinal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenHashSetAddSimpleEntryWithKeyAnd42_thenCallsOrdinal2()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(0);

    HashSet<Entry<String, String>> entrySet = new HashSet<>();
    entrySet.add(new SimpleEntry<>("Key", "42"));
    when(map.entrySet()).thenReturn(entrySet);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbRenameKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(map).entrySet();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgSource} {@link TbMsgSource#ordinal()} return one.
   *   <li>Then calls {@link TbMsgSource#ordinal()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgSource ordinal() return one; then calls ordinal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgSourceOrdinalReturnOne_thenCallsOrdinal()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(1);
    when(map.entrySet()).thenReturn(new HashSet<>());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbRenameKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(map).entrySet();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgSource} {@link TbMsgSource#ordinal()} return zero.
   *   <li>Then calls {@link TbMsgSource#ordinal()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgSource ordinal() return zero; then calls ordinal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgSourceOrdinalReturnZero_thenCallsOrdinal()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(0);
    when(map.entrySet()).thenReturn(new HashSet<>());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbRenameKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(map).entrySet();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when AlarmId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRenameKeysNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenAlarmIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    when(tbMsgSource.ordinal()).thenReturn(0);

    HashSet<Entry<String, String>> entrySet = new HashSet<>();
    entrySet.add(new SimpleEntry<>("Key", "42"));
    when(map.entrySet()).thenReturn(entrySet);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbRenameKeysNode.onMsg(ctx, msg);

    // Assert
    verify(tbMsgSource).ordinal();
    verify(map).entrySet();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbRenameKeysNode}
   *   <li>{@link TbRenameKeysNode#getKeyToUpgradeFromVersionOne()}
   *   <li>{@link TbRenameKeysNode#getNewKeyForUpgradeFromVersionZero()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbRenameKeysNode.<init>()",
    "String TbRenameKeysNode.getKeyToUpgradeFromVersionOne()",
    "String TbRenameKeysNode.getNewKeyForUpgradeFromVersionZero()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbRenameKeysNode actualTbRenameKeysNode = new TbRenameKeysNode();
    String actualKeyToUpgradeFromVersionOne =
        actualTbRenameKeysNode.getKeyToUpgradeFromVersionOne();

    // Assert
    assertEquals("fromMetadata", actualKeyToUpgradeFromVersionOne);
    assertEquals("renameIn", actualTbRenameKeysNode.getNewKeyForUpgradeFromVersionZero());
  }
}
