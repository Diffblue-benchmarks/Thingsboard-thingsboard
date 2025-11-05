package org.thingsboard.rule.engine.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;
import java.util.UUID;
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
import org.thingsboard.rule.engine.api.RuleEngineTelemetryService;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbMsgTimeseriesNodeDiffblueTest {
  @Mock private TbContext tbContext;

  @InjectMocks private TbMsgTimeseriesNode tbMsgTimeseriesNode;

  @Mock private TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration;

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs())
        .thenThrow(new IllegalArgumentException());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbMsgTimeseriesNode.onMsg(tbContext, msg));
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg2() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(1L);

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doThrow(new IllegalArgumentException())
        .when(ruleEngineTelemetryService)
        .saveWithoutLatestAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbMsgTimeseriesNode.onMsg(tbContext, msg));
    verify(ruleEngineTelemetryService)
        .saveWithoutLatestAndNotify(
            isA(TenantId.class),
            isNull(),
            isNull(),
            isA(List.class),
            eq(1L),
            isA(FutureCallback.class));
    verify(tbContext).getTelemetryService();
    verify(tbContext).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg3() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(false);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(1L);
    when(tbContext.getTelemetryService()).thenReturn(mock(RuleEngineTelemetryService.class));
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doThrow(new IllegalArgumentException())
        .when(ruleEngineTelemetryService)
        .saveAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbMsgTimeseriesNode.onMsg(tbContext, msg));
    verify(ruleEngineTelemetryService)
        .saveAndNotify(
            isA(TenantId.class),
            (CustomerId) isNull(),
            (EntityId) isNull(),
            isA(List.class),
            eq(1L),
            isA(FutureCallback.class));
    verify(tbContext, atLeast(1)).getTelemetryService();
    verify(tbContext, atLeast(1)).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg4() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(false);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(1L);
    when(tbContext.getTelemetryService()).thenReturn(mock(RuleEngineTelemetryService.class));
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doNothing()
        .when(ruleEngineTelemetryService)
        .saveAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "ts", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgTimeseriesNode.onMsg(tbContext, msg);

    // Assert
    verify(ruleEngineTelemetryService)
        .saveAndNotify(
            isA(TenantId.class),
            (CustomerId) isNull(),
            (EntityId) isNull(),
            isA(List.class),
            eq(1L),
            isA(FutureCallback.class));
    verify(tbContext, atLeast(1)).getTelemetryService();
    verify(tbContext, atLeast(1)).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgTimeseriesNodeConfiguration} {@link
   *       TbMsgTimeseriesNodeConfiguration#getDefaultTTL()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgTimeseriesNodeConfiguration getDefaultTTL() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgTimeseriesNodeConfigurationGetDefaultTTLReturnZero() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(false);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(0L);
    when(tbContext.getTelemetryService()).thenReturn(mock(RuleEngineTelemetryService.class));
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doNothing()
        .when(ruleEngineTelemetryService)
        .saveAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgTimeseriesNode.onMsg(tbContext, msg);

    // Assert
    verify(ruleEngineTelemetryService)
        .saveAndNotify(
            isA(TenantId.class),
            (CustomerId) isNull(),
            (EntityId) isNull(),
            isA(List.class),
            eq(0L),
            isA(FutureCallback.class));
    verify(tbContext, atLeast(1)).getTelemetryService();
    verify(tbContext, atLeast(1)).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgTimeseriesNodeConfiguration} {@link
   *       TbMsgTimeseriesNodeConfiguration#isUseServerTs()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgTimeseriesNodeConfiguration isUseServerTs() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgTimeseriesNodeConfigurationIsUseServerTsReturnFalse() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(false);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(false);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(1L);
    when(tbContext.getTelemetryService()).thenReturn(mock(RuleEngineTelemetryService.class));
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doNothing()
        .when(ruleEngineTelemetryService)
        .saveAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgTimeseriesNode.onMsg(tbContext, msg);

    // Assert
    verify(ruleEngineTelemetryService)
        .saveAndNotify(
            isA(TenantId.class),
            (CustomerId) isNull(),
            (EntityId) isNull(),
            isA(List.class),
            eq(1L),
            isA(FutureCallback.class));
    verify(tbContext, atLeast(1)).getTelemetryService();
    verify(tbContext, atLeast(1)).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleEngineTelemetryService#saveWithoutLatestAndNotify(TenantId,
   *       CustomerId, EntityId, List, long, FutureCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); then calls saveWithoutLatestAndNotify(TenantId, CustomerId, EntityId, List, long, FutureCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsSaveWithoutLatestAndNotify() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(1L);

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doNothing()
        .when(ruleEngineTelemetryService)
        .saveWithoutLatestAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgTimeseriesNode.onMsg(tbContext, msg);

    // Assert
    verify(ruleEngineTelemetryService)
        .saveWithoutLatestAndNotify(
            isA(TenantId.class),
            isNull(),
            isNull(),
            isA(List.class),
            eq(1L),
            isA(FutureCallback.class));
    verify(tbContext).getTelemetryService();
    verify(tbContext).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbTelemetryMsgFactory#telemetryMsg(EntityId, String, Object)} with originator
   *       is {@code null} and {@code Key} and value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when telemetryMsg(EntityId, String, Object) with originator is 'null' and 'Key' and value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTelemetryMsgWithOriginatorIsNullAndKeyAndValueIs42() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(false);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(1L);
    when(tbContext.getTelemetryService()).thenReturn(mock(RuleEngineTelemetryService.class));
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doNothing()
        .when(ruleEngineTelemetryService)
        .saveAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg = TbTelemetryMsgFactory.telemetryMsg(null, "Key", "42");

    // Act
    tbMsgTimeseriesNode.onMsg(tbContext, msg);

    // Assert
    verify(ruleEngineTelemetryService)
        .saveAndNotify(
            isA(TenantId.class),
            (CustomerId) isNull(),
            (EntityId) isNull(),
            isA(List.class),
            eq(1L),
            isA(FutureCallback.class));
    verify(tbContext, atLeast(1)).getTelemetryService();
    verify(tbContext, atLeast(1)).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbTelemetryMsgFactory#telemetryMsg(EntityId, String, Object)} with originator
   *       is {@code null} and {@code Key} and value is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when telemetryMsg(EntityId, String, Object) with originator is 'null' and 'Key' and value is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTelemetryMsgWithOriginatorIsNullAndKeyAndValueIsEmptyString() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(false);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(1L);
    when(tbContext.getTelemetryService()).thenReturn(mock(RuleEngineTelemetryService.class));
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doNothing()
        .when(ruleEngineTelemetryService)
        .saveAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg = TbTelemetryMsgFactory.telemetryMsg(null, "Key", "");

    // Act
    tbMsgTimeseriesNode.onMsg(tbContext, msg);

    // Assert
    verify(ruleEngineTelemetryService)
        .saveAndNotify(
            isA(TenantId.class),
            (CustomerId) isNull(),
            (EntityId) isNull(),
            isA(List.class),
            eq(1L),
            isA(FutureCallback.class));
    verify(tbContext, atLeast(1)).getTelemetryService();
    verify(tbContext, atLeast(1)).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbTelemetryMsgFactory#telemetryMsg(EntityId, String, Object)} with originator
   *       is {@code null} and {@code Key} and value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when telemetryMsg(EntityId, String, Object) with originator is 'null' and 'Key' and value is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTelemetryMsgWithOriginatorIsNullAndKeyAndValueIsFortyTwo() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(false);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(1L);
    when(tbContext.getTelemetryService()).thenReturn(mock(RuleEngineTelemetryService.class));
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doNothing()
        .when(ruleEngineTelemetryService)
        .saveAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg = TbTelemetryMsgFactory.telemetryMsg(null, "Key", 42L);

    // Act
    tbMsgTimeseriesNode.onMsg(tbContext, msg);

    // Assert
    verify(ruleEngineTelemetryService)
        .saveAndNotify(
            isA(TenantId.class),
            (CustomerId) isNull(),
            (EntityId) isNull(),
            isA(List.class),
            eq(1L),
            isA(FutureCallback.class));
    verify(tbContext, atLeast(1)).getTelemetryService();
    verify(tbContext, atLeast(1)).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbTelemetryMsgFactory#telemetryMsg(EntityId, String, Object)} with originator
   *       is {@code null} and {@code Key} and value is {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when telemetryMsg(EntityId, String, Object) with originator is 'null' and 'Key' and value is MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTelemetryMsgWithOriginatorIsNullAndKeyAndValueIsMax_value() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(false);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(1L);
    when(tbContext.getTelemetryService()).thenReturn(mock(RuleEngineTelemetryService.class));
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doNothing()
        .when(ruleEngineTelemetryService)
        .saveAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg = TbTelemetryMsgFactory.telemetryMsg(null, "Key", Long.MAX_VALUE);

    // Act
    tbMsgTimeseriesNode.onMsg(tbContext, msg);

    // Assert
    verify(ruleEngineTelemetryService)
        .saveAndNotify(
            isA(TenantId.class),
            (CustomerId) isNull(),
            (EntityId) isNull(),
            isA(List.class),
            eq(1L),
            isA(FutureCallback.class));
    verify(tbContext, atLeast(1)).getTelemetryService();
    verify(tbContext, atLeast(1)).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbTelemetryMsgFactory#telemetryMsg(EntityId, String, Object)} with originator
   *       is {@code null} and {@code Key} and value is {@link Long#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when telemetryMsg(EntityId, String, Object) with originator is 'null' and 'Key' and value is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTelemetryMsgWithOriginatorIsNullAndKeyAndValueIsMin_value() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(false);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(1L);
    when(tbContext.getTelemetryService()).thenReturn(mock(RuleEngineTelemetryService.class));
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doNothing()
        .when(ruleEngineTelemetryService)
        .saveAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg = TbTelemetryMsgFactory.telemetryMsg(null, "Key", Long.MIN_VALUE);

    // Act
    tbMsgTimeseriesNode.onMsg(tbContext, msg);

    // Assert
    verify(ruleEngineTelemetryService)
        .saveAndNotify(
            isA(TenantId.class),
            (CustomerId) isNull(),
            (EntityId) isNull(),
            isA(List.class),
            eq(1L),
            isA(FutureCallback.class));
    verify(tbContext, atLeast(1)).getTelemetryService();
    verify(tbContext, atLeast(1)).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbTelemetryMsgFactory#telemetryMsg(EntityId, String, Object)} with originator
   *       is {@code null} and {@code Key} and value is minimalForOnMsg.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when telemetryMsg(EntityId, String, Object) with originator is 'null' and 'Key' and value is minimalForOnMsg")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTelemetryMsgWithOriginatorIsNullAndKeyAndValueIsMinimalForOnMsg() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(false);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(1L);
    when(tbContext.getTelemetryService()).thenReturn(mock(RuleEngineTelemetryService.class));
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doNothing()
        .when(ruleEngineTelemetryService)
        .saveAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgTimeseriesNode.onMsg(tbContext, msg);

    // Assert
    verify(ruleEngineTelemetryService)
        .saveAndNotify(
            isA(TenantId.class),
            (CustomerId) isNull(),
            (EntityId) isNull(),
            isA(List.class),
            eq(1L),
            isA(FutureCallback.class));
    verify(tbContext, atLeast(1)).getTelemetryService();
    verify(tbContext, atLeast(1)).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbTelemetryMsgFactory#telemetryMsg(EntityId, String, Object)} with originator
   *       is {@code null} and {@code Key} and value is minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when telemetryMsg(EntityId, String, Object) with originator is 'null' and 'Key' and value is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTelemetryMsgWithOriginatorIsNullAndKeyAndValueIsMinusOne() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(false);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(1L);
    when(tbContext.getTelemetryService()).thenReturn(mock(RuleEngineTelemetryService.class));
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doNothing()
        .when(ruleEngineTelemetryService)
        .saveAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg = TbTelemetryMsgFactory.telemetryMsg(null, "Key", -1L);

    // Act
    tbMsgTimeseriesNode.onMsg(tbContext, msg);

    // Assert
    verify(ruleEngineTelemetryService)
        .saveAndNotify(
            isA(TenantId.class),
            (CustomerId) isNull(),
            (EntityId) isNull(),
            isA(List.class),
            eq(1L),
            isA(FutureCallback.class));
    verify(tbContext, atLeast(1)).getTelemetryService();
    verify(tbContext, atLeast(1)).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbTelemetryMsgFactory#telemetryMsg(EntityId, String, Object)} with originator
   *       is {@code null} and {@code Key} and value is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when telemetryMsg(EntityId, String, Object) with originator is 'null' and 'Key' and value is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTelemetryMsgWithOriginatorIsNullAndKeyAndValueIsZero() {
    // Arrange
    when(tbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()).thenReturn(false);
    when(tbMsgTimeseriesNodeConfiguration.isUseServerTs()).thenReturn(true);
    when(tbMsgTimeseriesNodeConfiguration.getDefaultTTL()).thenReturn(1L);
    when(tbContext.getTelemetryService()).thenReturn(mock(RuleEngineTelemetryService.class));
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineTelemetryService ruleEngineTelemetryService = mock(RuleEngineTelemetryService.class);
    doNothing()
        .when(ruleEngineTelemetryService)
        .saveAndNotify(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong(),
            Mockito.<FutureCallback<Void>>any());
    when(tbContext.getTelemetryService()).thenReturn(ruleEngineTelemetryService);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg = TbTelemetryMsgFactory.telemetryMsg(null, "Key", 0L);

    // Act
    tbMsgTimeseriesNode.onMsg(tbContext, msg);

    // Assert
    verify(ruleEngineTelemetryService)
        .saveAndNotify(
            isA(TenantId.class),
            (CustomerId) isNull(),
            (EntityId) isNull(),
            isA(List.class),
            eq(1L),
            isA(FutureCallback.class));
    verify(tbContext, atLeast(1)).getTelemetryService();
    verify(tbContext, atLeast(1)).getTenantId();
    verify(tbMsgTimeseriesNodeConfiguration).getDefaultTTL();
    verify(tbMsgTimeseriesNodeConfiguration).isSkipLatestPersistence();
    verify(tbMsgTimeseriesNodeConfiguration).isUseServerTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#computeTs(TbMsg, boolean)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link TbMsg} {@link TbMsg#getMetaDataTs()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#computeTs(TbMsg, boolean)}
   */
  @Test
  @DisplayName(
      "Test computeTs(TbMsg, boolean); given one; when TbMsg getMetaDataTs() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbMsgTimeseriesNode.computeTs(TbMsg, boolean)"})
  void testComputeTs_givenOne_whenTbMsgGetMetaDataTsReturnOne_thenReturnOne() {
    // Arrange
    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaDataTs()).thenReturn(1L);

    // Act
    long actualComputeTsResult = TbMsgTimeseriesNode.computeTs(msg, false);

    // Assert
    verify(msg).getMetaDataTs();
    assertEquals(1L, actualComputeTsResult);
  }

  /**
   * Test {@link TbMsgTimeseriesNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link TbContext} {@link TbContext#removeListeners()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given TbContext removeListeners() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.destroy()"})
  void testDestroy_givenTbContextRemoveListenersDoesNothing() {
    // Arrange
    doNothing().when(tbContext).removeListeners();

    // Act
    tbMsgTimeseriesNode.destroy();

    // Assert
    verify(tbContext).removeListeners();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#destroy()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.destroy()"})
  void testDestroy_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException()).when(tbContext).removeListeners();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbMsgTimeseriesNode.destroy());
    verify(tbContext).removeListeners();
  }
}
