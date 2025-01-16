package org.thingsboard.server.service.ws.notification;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.NotificationCenter;
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.dao.notification.NotificationService;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.subscription.TbLocalSubscriptionService;
import org.thingsboard.server.service.ws.WebSocketSessionRef;
import org.thingsboard.server.service.ws.WebSocketSessionType;
import org.thingsboard.server.service.ws.notification.cmd.MarkAllNotificationsAsReadCmd;
import org.thingsboard.server.service.ws.notification.cmd.MarkNotificationsAsReadCmd;
import org.thingsboard.server.service.ws.notification.cmd.NotificationsUnsubCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.UnsubscribeCmd;

class DefaultNotificationCommandsHandlerDiffblueTest {
  /**
   * Test
   * {@link DefaultNotificationCommandsHandler#handleMarkAsReadCmd(WebSocketSessionRef, MarkNotificationsAsReadCmd)}.
   * <ul>
   *   <li>Then calls
   * {@link NotificationCenter#markNotificationAsRead(TenantId, UserId, NotificationId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationCommandsHandler#handleMarkAsReadCmd(WebSocketSessionRef, MarkNotificationsAsReadCmd)}
   */
  @Test
  @DisplayName("Test handleMarkAsReadCmd(WebSocketSessionRef, MarkNotificationsAsReadCmd); then calls markNotificationAsRead(TenantId, UserId, NotificationId)")
  void testHandleMarkAsReadCmd_thenCallsMarkNotificationAsRead() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationCenter notificationCenter = mock(NotificationCenter.class);
    doNothing().when(notificationCenter)
        .markNotificationAsRead(Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<NotificationId>any());
    DefaultNotificationCommandsHandler defaultNotificationCommandsHandler = new DefaultNotificationCommandsHandler(
        mock(NotificationService.class), mock(TbLocalSubscriptionService.class), notificationCenter,
        mock(TbServiceInfoProvider.class));
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    ArrayList<UUID> notifications = new ArrayList<>();
    notifications.add(UUID.randomUUID());

    MarkNotificationsAsReadCmd cmd = new MarkNotificationsAsReadCmd();
    cmd.setNotifications(notifications);

    // Act
    defaultNotificationCommandsHandler.handleMarkAsReadCmd(sessionRef, cmd);

    // Assert
    verify(notificationCenter).markNotificationAsRead(isNull(), isNull(), isA(NotificationId.class));
  }

  /**
   * Test
   * {@link DefaultNotificationCommandsHandler#handleMarkAsReadCmd(WebSocketSessionRef, MarkNotificationsAsReadCmd)}.
   * <ul>
   *   <li>Then calls
   * {@link NotificationCenter#markNotificationAsRead(TenantId, UserId, NotificationId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationCommandsHandler#handleMarkAsReadCmd(WebSocketSessionRef, MarkNotificationsAsReadCmd)}
   */
  @Test
  @DisplayName("Test handleMarkAsReadCmd(WebSocketSessionRef, MarkNotificationsAsReadCmd); then calls markNotificationAsRead(TenantId, UserId, NotificationId)")
  void testHandleMarkAsReadCmd_thenCallsMarkNotificationAsRead2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationCenter notificationCenter = mock(NotificationCenter.class);
    doNothing().when(notificationCenter)
        .markNotificationAsRead(Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<NotificationId>any());
    DefaultNotificationCommandsHandler defaultNotificationCommandsHandler = new DefaultNotificationCommandsHandler(
        mock(NotificationService.class), mock(TbLocalSubscriptionService.class), notificationCenter,
        mock(TbServiceInfoProvider.class));
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    ArrayList<UUID> notifications = new ArrayList<>();
    notifications.add(UUID.randomUUID());
    notifications.add(UUID.randomUUID());

    MarkNotificationsAsReadCmd cmd = new MarkNotificationsAsReadCmd();
    cmd.setNotifications(notifications);

    // Act
    defaultNotificationCommandsHandler.handleMarkAsReadCmd(sessionRef, cmd);

    // Assert
    verify(notificationCenter, atLeast(1)).markNotificationAsRead(isNull(), isNull(), Mockito.<NotificationId>any());
  }

  /**
   * Test
   * {@link DefaultNotificationCommandsHandler#handleMarkAllAsReadCmd(WebSocketSessionRef, MarkAllNotificationsAsReadCmd)}.
   * <ul>
   *   <li>Then calls
   * {@link NotificationCenter#markAllNotificationsAsRead(TenantId, NotificationDeliveryMethod, UserId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationCommandsHandler#handleMarkAllAsReadCmd(WebSocketSessionRef, MarkAllNotificationsAsReadCmd)}
   */
  @Test
  @DisplayName("Test handleMarkAllAsReadCmd(WebSocketSessionRef, MarkAllNotificationsAsReadCmd); then calls markAllNotificationsAsRead(TenantId, NotificationDeliveryMethod, UserId)")
  void testHandleMarkAllAsReadCmd_thenCallsMarkAllNotificationsAsRead() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationCenter notificationCenter = mock(NotificationCenter.class);
    doNothing().when(notificationCenter)
        .markAllNotificationsAsRead(Mockito.<TenantId>any(), Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UserId>any());
    DefaultNotificationCommandsHandler defaultNotificationCommandsHandler = new DefaultNotificationCommandsHandler(
        mock(NotificationService.class), mock(TbLocalSubscriptionService.class), notificationCenter,
        mock(TbServiceInfoProvider.class));
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act
    defaultNotificationCommandsHandler.handleMarkAllAsReadCmd(sessionRef, new MarkAllNotificationsAsReadCmd(1));

    // Assert
    verify(notificationCenter).markAllNotificationsAsRead(isNull(), eq(NotificationDeliveryMethod.WEB), isNull());
  }

  /**
   * Test
   * {@link DefaultNotificationCommandsHandler#handleUnsubCmd(WebSocketSessionRef, UnsubscribeCmd)}.
   * <ul>
   *   <li>Then calls
   * {@link TbLocalSubscriptionService#cancelSubscription(TenantId, String, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationCommandsHandler#handleUnsubCmd(WebSocketSessionRef, UnsubscribeCmd)}
   */
  @Test
  @DisplayName("Test handleUnsubCmd(WebSocketSessionRef, UnsubscribeCmd); then calls cancelSubscription(TenantId, String, int)")
  void testHandleUnsubCmd_thenCallsCancelSubscription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLocalSubscriptionService localSubscriptionService = mock(TbLocalSubscriptionService.class);
    doNothing().when(localSubscriptionService)
        .cancelSubscription(Mockito.<TenantId>any(), Mockito.<String>any(), anyInt());
    DefaultNotificationCommandsHandler defaultNotificationCommandsHandler = new DefaultNotificationCommandsHandler(
        mock(NotificationService.class), localSubscriptionService, mock(NotificationCenter.class),
        mock(TbServiceInfoProvider.class));
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act
    defaultNotificationCommandsHandler.handleUnsubCmd(sessionRef, new NotificationsUnsubCmd(1));

    // Assert
    verify(localSubscriptionService).cancelSubscription(isNull(), eq("42"), eq(1));
  }
}
