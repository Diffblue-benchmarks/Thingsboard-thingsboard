package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.AlarmCountQuery;
import org.thingsboard.server.service.ws.WebSocketSessionRef;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.AlarmCountCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.UnsubscribeCmd;

class DefaultTbEntityDataSubscriptionServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, AlarmCountCmd)}
   * with {@code WebSocketSessionRef}, {@code AlarmCountCmd}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbEntityDataSubscriptionService#handleCmd(WebSocketSessionRef, AlarmCountCmd)}
   */
  @Test
  @DisplayName("Test handleCmd(WebSocketSessionRef, AlarmCountCmd) with 'WebSocketSessionRef', 'AlarmCountCmd'; then throw RuntimeException")
  void testHandleCmdWithWebSocketSessionRefAlarmCountCmd_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbEntityDataSubscriptionService defaultTbEntityDataSubscriptionService = new DefaultTbEntityDataSubscriptionService();
    WebSocketSessionRef session = mock(WebSocketSessionRef.class);
    when(session.getSecurityCtx()).thenThrow(new RuntimeException("foo"));
    when(session.getSessionId()).thenReturn("42");
    AlarmCountQuery.AlarmCountQueryBuilder endTsResult = AlarmCountQuery.builder().assigneeId(null).endTs(1L);
    AlarmCountQuery.AlarmCountQueryBuilder startTsResult = endTsResult.severityList(new ArrayList<>()).startTs(1L);
    AlarmCountQuery.AlarmCountQueryBuilder timeWindowResult = startTsResult.statusList(new ArrayList<>())
        .timeWindow(10L);
    AlarmCountQuery query = timeWindowResult.typeList(new ArrayList<>()).build();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbEntityDataSubscriptionService.handleCmd(session, new AlarmCountCmd(1, query)));
    verify(session).getSecurityCtx();
    verify(session, atLeast(1)).getSessionId();
  }

  /**
   * Test
   * {@link DefaultTbEntityDataSubscriptionService#cancelSubscription(String, UnsubscribeCmd)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link UnsubscribeCmd#getCmdId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbEntityDataSubscriptionService#cancelSubscription(String, UnsubscribeCmd)}
   */
  @Test
  @DisplayName("Test cancelSubscription(String, UnsubscribeCmd); given one; then calls getCmdId()")
  void testCancelSubscription_givenOne_thenCallsGetCmdId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbEntityDataSubscriptionService defaultTbEntityDataSubscriptionService = new DefaultTbEntityDataSubscriptionService();
    UnsubscribeCmd cmd = mock(UnsubscribeCmd.class);
    when(cmd.getCmdId()).thenReturn(1);

    // Act
    defaultTbEntityDataSubscriptionService.cancelSubscription("42", cmd);

    // Assert that nothing has changed
    verify(cmd).getCmdId();
  }

  /**
   * Test {@link DefaultTbEntityDataSubscriptionService#getDbCallbackExecutor()}.
   * <p>
   * Method under test:
   * {@link DefaultTbEntityDataSubscriptionService#getDbCallbackExecutor()}
   */
  @Test
  @DisplayName("Test getDbCallbackExecutor()")
  void testGetDbCallbackExecutor() {
    // Arrange, Act and Assert
    assertNull((new DefaultTbEntityDataSubscriptionService()).getDbCallbackExecutor());
  }
}
