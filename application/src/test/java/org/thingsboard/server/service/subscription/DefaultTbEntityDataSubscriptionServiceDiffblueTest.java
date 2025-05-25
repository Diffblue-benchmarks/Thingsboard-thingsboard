package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.web.socket.CloseStatus;
import org.thingsboard.server.common.data.kv.AggregationParams;
import org.thingsboard.server.common.data.query.AlarmCountQuery;
import org.thingsboard.server.common.data.query.AlarmCountQuery.AlarmCountQueryBuilder;
import org.thingsboard.server.common.data.query.EntityCountQuery;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.ws.WebSocketService;
import org.thingsboard.server.service.ws.WebSocketSessionRef;
import org.thingsboard.server.service.ws.WebSocketSessionRef.WebSocketSessionRefBuilder;
import org.thingsboard.server.service.ws.WebSocketSessionType;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.AggHistoryCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.AlarmCountCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.EntityCountCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.EntityDataCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.EntityHistoryCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.LatestValueCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.TimeSeriesCmd;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultTbEntityDataSubscriptionServiceDiffblueTest {
  @InjectMocks
  private DefaultTbEntityDataSubscriptionService defaultTbEntityDataSubscriptionService;

  @Mock
  private WebSocketService webSocketService;

  /**
   * Test {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, AlarmCountCmd)} with {@code WebSocketSessionRef}, {@code AlarmCountCmd}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, AlarmCountCmd)}
   */
  @Test
  @DisplayName("Test handleCmd(WebSocketSessionRef, AlarmCountCmd) with 'WebSocketSessionRef', 'AlarmCountCmd'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbEntityDataSubscriptionService.handleCmd(WebSocketSessionRef, AlarmCountCmd)"})
  void testHandleCmdWithWebSocketSessionRefAlarmCountCmd_thenThrowRuntimeException() {
    // Arrange
    DefaultTbEntityDataSubscriptionService defaultTbEntityDataSubscriptionService = new DefaultTbEntityDataSubscriptionService();
    WebSocketSessionRef session = mock(WebSocketSessionRef.class);
    when(session.getSecurityCtx()).thenThrow(new RuntimeException("foo"));
    when(session.getSessionId()).thenReturn("42");
    AlarmCountQueryBuilder endTsResult = AlarmCountQuery.builder().assigneeId(null).endTs(1L);
    AlarmCountQueryBuilder startTsResult = endTsResult.severityList(new ArrayList<>()).startTs(1L);
    AlarmCountQueryBuilder timeWindowResult = startTsResult.statusList(new ArrayList<>()).timeWindow(10L);
    AlarmCountQuery query = timeWindowResult.typeList(new ArrayList<>()).build();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbEntityDataSubscriptionService.handleCmd(session, new AlarmCountCmd(1, query)));
    verify(session).getSecurityCtx();
    verify(session, atLeast(1)).getSessionId();
  }

  /**
   * Test {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityCountCmd)} with {@code WebSocketSessionRef}, {@code EntityCountCmd}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityCountCmd)}
   */
  @Test
  @DisplayName("Test handleCmd(WebSocketSessionRef, EntityCountCmd) with 'WebSocketSessionRef', 'EntityCountCmd'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbEntityDataSubscriptionService.handleCmd(WebSocketSessionRef, EntityCountCmd)"})
  void testHandleCmdWithWebSocketSessionRefEntityCountCmd_thenThrowRuntimeException() {
    // Arrange
    WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef session = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    EntityCountQuery query = mock(EntityCountQuery.class);
    when(query.getKeyFilters()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbEntityDataSubscriptionService.handleCmd(session, new EntityCountCmd(1, query)));
    verify(query).getKeyFilters();
  }

  /**
   * Test {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityDataCmd)} with {@code WebSocketSessionRef}, {@code EntityDataCmd}.
   * <p>
   * Method under test: {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityDataCmd)}
   */
  @Test
  @DisplayName("Test handleCmd(WebSocketSessionRef, EntityDataCmd) with 'WebSocketSessionRef', 'EntityDataCmd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbEntityDataSubscriptionService.handleCmd(WebSocketSessionRef, EntityDataCmd)"})
  void testHandleCmdWithWebSocketSessionRefEntityDataCmd() {
    // Arrange
    doNothing().when(webSocketService).close(Mockito.<String>any(), Mockito.<CloseStatus>any());
    WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef session = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());
    EntityHistoryCmd historyCmd = new EntityHistoryCmd();

    // Act
    defaultTbEntityDataSubscriptionService.handleCmd(session,
        new EntityDataCmd(1, null, historyCmd, latestCmd, new TimeSeriesCmd()));

    // Assert
    verify(webSocketService).close(eq("42"), isA(CloseStatus.class));
  }

  /**
   * Test {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityDataCmd)} with {@code WebSocketSessionRef}, {@code EntityDataCmd}.
   * <p>
   * Method under test: {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityDataCmd)}
   */
  @Test
  @DisplayName("Test handleCmd(WebSocketSessionRef, EntityDataCmd) with 'WebSocketSessionRef', 'EntityDataCmd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbEntityDataSubscriptionService.handleCmd(WebSocketSessionRef, EntityDataCmd)"})
  void testHandleCmdWithWebSocketSessionRefEntityDataCmd2() {
    // Arrange
    doNothing().when(webSocketService).close(Mockito.<String>any(), Mockito.<CloseStatus>any());
    WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef session = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());

    // Act
    defaultTbEntityDataSubscriptionService.handleCmd(session,
        new EntityDataCmd(1, null, null, latestCmd, new TimeSeriesCmd()));

    // Assert
    verify(webSocketService).close(eq("42"), isA(CloseStatus.class));
  }

  /**
   * Test {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityDataCmd)} with {@code WebSocketSessionRef}, {@code EntityDataCmd}.
   * <p>
   * Method under test: {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityDataCmd)}
   */
  @Test
  @DisplayName("Test handleCmd(WebSocketSessionRef, EntityDataCmd) with 'WebSocketSessionRef', 'EntityDataCmd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbEntityDataSubscriptionService.handleCmd(WebSocketSessionRef, EntityDataCmd)"})
  void testHandleCmdWithWebSocketSessionRefEntityDataCmd3() {
    // Arrange
    doNothing().when(webSocketService).close(Mockito.<String>any(), Mockito.<CloseStatus>any());
    WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef session = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("[{}][{}] Fetching history data for start {} and end {} ms for keys: ({})");
    stringList.add("[{}][{}] Creating new subscription using: {}");
    EntityHistoryCmd historyCmd = mock(EntityHistoryCmd.class);
    when(historyCmd.toAggregationParams()).thenReturn(AggregationParams.none());
    when(historyCmd.getLimit()).thenReturn(1);
    when(historyCmd.isFetchLatestPreviousPoint()).thenReturn(true);
    when(historyCmd.getKeys()).thenReturn(stringList);
    when(historyCmd.getEndTs()).thenReturn(1L);
    when(historyCmd.getStartTs()).thenReturn(1L);

    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());

    // Act
    defaultTbEntityDataSubscriptionService.handleCmd(session,
        new EntityDataCmd(1, null, historyCmd, latestCmd, new TimeSeriesCmd()));

    // Assert
    verify(webSocketService).close(eq("42"), isA(CloseStatus.class));
    verify(historyCmd, atLeast(1)).getEndTs();
    verify(historyCmd, atLeast(1)).getKeys();
    verify(historyCmd, atLeast(1)).getLimit();
    verify(historyCmd, atLeast(1)).getStartTs();
    verify(historyCmd).isFetchLatestPreviousPoint();
    verify(historyCmd, atLeast(1)).toAggregationParams();
  }

  /**
   * Test {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityDataCmd)} with {@code WebSocketSessionRef}, {@code EntityDataCmd}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityDataCmd)}
   */
  @Test
  @DisplayName("Test handleCmd(WebSocketSessionRef, EntityDataCmd) with 'WebSocketSessionRef', 'EntityDataCmd'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbEntityDataSubscriptionService.handleCmd(WebSocketSessionRef, EntityDataCmd)"})
  void testHandleCmdWithWebSocketSessionRefEntityDataCmd_givenNull() {
    // Arrange
    doNothing().when(webSocketService).close(Mockito.<String>any(), Mockito.<CloseStatus>any());
    WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef session = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    AggHistoryCmd aggHistoryCmd = new AggHistoryCmd();
    aggHistoryCmd.setEndTs(1L);
    aggHistoryCmd.setKeys(new ArrayList<>());
    aggHistoryCmd.setStartTs(1L);

    LatestValueCmd latestValueCmd = new LatestValueCmd();
    latestValueCmd.setKeys(new ArrayList<>());
    EntityDataCmd cmd = mock(EntityDataCmd.class);
    when(cmd.getCmdId()).thenReturn(1);
    when(cmd.getQuery()).thenReturn(null);
    when(cmd.getAggHistoryCmd()).thenReturn(aggHistoryCmd);
    when(cmd.getLatestCmd()).thenReturn(latestValueCmd);
    when(cmd.getTsCmd()).thenReturn(new TimeSeriesCmd());

    // Act
    defaultTbEntityDataSubscriptionService.handleCmd(session, cmd);

    // Assert
    verify(webSocketService).close(eq("42"), isA(CloseStatus.class));
    verify(cmd, atLeast(1)).getCmdId();
    verify(cmd, atLeast(1)).getAggHistoryCmd();
    verify(cmd).getLatestCmd();
    verify(cmd, atLeast(1)).getQuery();
    verify(cmd).getTsCmd();
  }

  /**
   * Test {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityDataCmd)} with {@code WebSocketSessionRef}, {@code EntityDataCmd}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link EntityHistoryCmd#getEndTs()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityDataCmd)}
   */
  @Test
  @DisplayName("Test handleCmd(WebSocketSessionRef, EntityDataCmd) with 'WebSocketSessionRef', 'EntityDataCmd'; given 'true'; then calls getEndTs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbEntityDataSubscriptionService.handleCmd(WebSocketSessionRef, EntityDataCmd)"})
  void testHandleCmdWithWebSocketSessionRefEntityDataCmd_givenTrue_thenCallsGetEndTs() {
    // Arrange
    doNothing().when(webSocketService).close(Mockito.<String>any(), Mockito.<CloseStatus>any());
    WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef session = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    EntityHistoryCmd historyCmd = mock(EntityHistoryCmd.class);
    when(historyCmd.isFetchLatestPreviousPoint()).thenReturn(true);
    when(historyCmd.getKeys()).thenReturn(new ArrayList<>());
    when(historyCmd.getEndTs()).thenReturn(1L);
    when(historyCmd.getStartTs()).thenReturn(1L);

    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());

    // Act
    defaultTbEntityDataSubscriptionService.handleCmd(session,
        new EntityDataCmd(1, null, historyCmd, latestCmd, new TimeSeriesCmd()));

    // Assert
    verify(webSocketService).close(eq("42"), isA(CloseStatus.class));
    verify(historyCmd).getEndTs();
    verify(historyCmd, atLeast(1)).getKeys();
    verify(historyCmd).getStartTs();
    verify(historyCmd).isFetchLatestPreviousPoint();
  }

  /**
   * Test {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityDataCmd)} with {@code WebSocketSessionRef}, {@code EntityDataCmd}.
   * <ul>
   *   <li>Then calls {@link EntityHistoryCmd#getLimit()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, EntityDataCmd)}
   */
  @Test
  @DisplayName("Test handleCmd(WebSocketSessionRef, EntityDataCmd) with 'WebSocketSessionRef', 'EntityDataCmd'; then calls getLimit()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbEntityDataSubscriptionService.handleCmd(WebSocketSessionRef, EntityDataCmd)"})
  void testHandleCmdWithWebSocketSessionRefEntityDataCmd_thenCallsGetLimit() {
    // Arrange
    doNothing().when(webSocketService).close(Mockito.<String>any(), Mockito.<CloseStatus>any());
    WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef session = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("[{}][{}] Creating new subscription using: {}");
    EntityHistoryCmd historyCmd = mock(EntityHistoryCmd.class);
    when(historyCmd.toAggregationParams()).thenReturn(AggregationParams.none());
    when(historyCmd.getLimit()).thenReturn(1);
    when(historyCmd.isFetchLatestPreviousPoint()).thenReturn(true);
    when(historyCmd.getKeys()).thenReturn(stringList);
    when(historyCmd.getEndTs()).thenReturn(1L);
    when(historyCmd.getStartTs()).thenReturn(1L);

    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());

    // Act
    defaultTbEntityDataSubscriptionService.handleCmd(session,
        new EntityDataCmd(1, null, historyCmd, latestCmd, new TimeSeriesCmd()));

    // Assert
    verify(webSocketService).close(eq("42"), isA(CloseStatus.class));
    verify(historyCmd, atLeast(1)).getEndTs();
    verify(historyCmd, atLeast(1)).getKeys();
    verify(historyCmd).getLimit();
    verify(historyCmd, atLeast(1)).getStartTs();
    verify(historyCmd).isFetchLatestPreviousPoint();
    verify(historyCmd, atLeast(1)).toAggregationParams();
  }

  /**
   * Test {@link DefaultTbEntityDataSubscriptionService#getDbCallbackExecutor()}.
   * <p>
   * Method under test: {@link DefaultTbEntityDataSubscriptionService#getDbCallbackExecutor()}
   */
  @Test
  @DisplayName("Test getDbCallbackExecutor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.service.executors.DbCallbackExecutorService DefaultTbEntityDataSubscriptionService.getDbCallbackExecutor()"})
  void testGetDbCallbackExecutor() {
    // Arrange, Act and Assert
    assertNull((new DefaultTbEntityDataSubscriptionService()).getDbCallbackExecutor());
  }
}
