package org.thingsboard.server.service.ws.notification.sub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.Notification;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.service.subscription.TbSubscription;
import org.thingsboard.server.service.subscription.TbSubscriptionType;
import org.thingsboard.server.service.ws.notification.cmd.UnreadNotificationsUpdate;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.CmdUpdateType;

class NotificationsSubscriptionDiffblueTest {
  /**
   * Test
   * {@link NotificationsSubscription#NotificationsSubscription(String, String, int, TenantId, EntityId, BiConsumer, int, Set)}.
   * <p>
   * Method under test:
   * {@link NotificationsSubscription#NotificationsSubscription(String, String, int, TenantId, EntityId, BiConsumer, int, Set)}
   */
  @Test
  @DisplayName("Test new NotificationsSubscription(String, String, int, TenantId, EntityId, BiConsumer, int, Set)")
  void testNewNotificationsSubscription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    BiConsumer<TbSubscription<NotificationsSubscriptionUpdate>, NotificationsSubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);

    // Act
    NotificationsSubscription actualNotificationsSubscription = new NotificationsSubscription("42", "42", 1, tenantId,
        null, updateProcessor, 1, new HashSet<>());

    // Assert
    assertEquals("42", actualNotificationsSubscription.getServiceId());
    assertEquals("42", actualNotificationsSubscription.getSessionId());
    assertNull(actualNotificationsSubscription.getEntityId());
    assertEquals(0, actualNotificationsSubscription.getSequence().get());
    assertEquals(1, actualNotificationsSubscription.getSubscriptionId());
    assertEquals(1, actualNotificationsSubscription.getLimit());
    assertEquals(TbSubscriptionType.NOTIFICATIONS, actualNotificationsSubscription.getType());
    assertTrue(actualNotificationsSubscription.getSortedNotifications().isEmpty());
    assertTrue(actualNotificationsSubscription.getLatestUnreadNotifications().isEmpty());
    assertTrue(actualNotificationsSubscription.getNotificationTypes().isEmpty());
    assertSame(tenantId, actualNotificationsSubscription.getTenantId());
    assertSame(updateProcessor, actualNotificationsSubscription.getUpdateProcessor());
  }

  /**
   * Test
   * {@link NotificationsSubscription#checkNotificationType(NotificationType)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ALARM}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationsSubscription#checkNotificationType(NotificationType)}
   */
  @Test
  @DisplayName("Test checkNotificationType(NotificationType); given HashSet() add 'ALARM'; then return 'false'")
  void testCheckNotificationType_givenHashSetAddAlarm_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashSet<NotificationType> notificationTypes = new HashSet<>();
    notificationTypes.add(NotificationType.ALARM);

    // Act and Assert
    assertFalse((new NotificationsSubscription("42", "42", 1, new TenantId(UUID.randomUUID()), null,
        mock(BiConsumer.class), 1, notificationTypes)).checkNotificationType(NotificationType.GENERAL));
  }

  /**
   * Test
   * {@link NotificationsSubscription#checkNotificationType(NotificationType)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code GENERAL}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationsSubscription#checkNotificationType(NotificationType)}
   */
  @Test
  @DisplayName("Test checkNotificationType(NotificationType); given HashSet() add 'GENERAL'; then return 'true'")
  void testCheckNotificationType_givenHashSetAddGeneral_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashSet<NotificationType> notificationTypes = new HashSet<>();
    notificationTypes.add(NotificationType.GENERAL);

    // Act and Assert
    assertTrue((new NotificationsSubscription("42", "42", 1, new TenantId(UUID.randomUUID()), null,
        mock(BiConsumer.class), 1, notificationTypes)).checkNotificationType(NotificationType.GENERAL));
  }

  /**
   * Test
   * {@link NotificationsSubscription#checkNotificationType(NotificationType)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationsSubscription#checkNotificationType(NotificationType)}
   */
  @Test
  @DisplayName("Test checkNotificationType(NotificationType); then return 'true'")
  void testCheckNotificationType_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    BiConsumer<TbSubscription<NotificationsSubscriptionUpdate>, NotificationsSubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);

    // Act and Assert
    assertTrue((new NotificationsSubscription("42", "42", 1, tenantId, null, updateProcessor, 1, new HashSet<>()))
        .checkNotificationType(NotificationType.GENERAL));
  }

  /**
   * Test {@link NotificationsSubscription#createFullUpdate()}.
   * <ul>
   *   <li>Then return ErrorMsg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubscription#createFullUpdate()}
   */
  @Test
  @DisplayName("Test createFullUpdate(); then return ErrorMsg is 'null'")
  void testCreateFullUpdate_thenReturnErrorMsgIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    BiConsumer<TbSubscription<NotificationsSubscriptionUpdate>, NotificationsSubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);
    NotificationsSubscription notificationsSubscription = new NotificationsSubscription("42", "42", 1, tenantId, null,
        updateProcessor, 1, new HashSet<>());

    // Act
    UnreadNotificationsUpdate actualCreateFullUpdateResult = notificationsSubscription.createFullUpdate();

    // Assert
    assertNull(actualCreateFullUpdateResult.getErrorMsg());
    assertNull(actualCreateFullUpdateResult.getUpdate());
    assertEquals(0, actualCreateFullUpdateResult.getTotalUnreadCount());
    assertEquals(0, actualCreateFullUpdateResult.getErrorCode());
    assertEquals(1, notificationsSubscription.getSequence().get());
    assertEquals(1, actualCreateFullUpdateResult.getSequenceNumber());
    assertEquals(1, actualCreateFullUpdateResult.getCmdId());
    assertEquals(CmdUpdateType.NOTIFICATIONS, actualCreateFullUpdateResult.getCmdUpdateType());
    assertTrue(actualCreateFullUpdateResult.getNotifications().isEmpty());
  }

  /**
   * Test {@link NotificationsSubscription#getSortedNotifications()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubscription#getSortedNotifications()}
   */
  @Test
  @DisplayName("Test getSortedNotifications(); then return Empty")
  void testGetSortedNotifications_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    BiConsumer<TbSubscription<NotificationsSubscriptionUpdate>, NotificationsSubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);

    // Act and Assert
    assertTrue((new NotificationsSubscription("42", "42", 1, tenantId, null, updateProcessor, 1, new HashSet<>()))
        .getSortedNotifications()
        .isEmpty());
  }

  /**
   * Test {@link NotificationsSubscription#createPartialUpdate(Notification)}.
   * <ul>
   *   <li>Then return ErrorMsg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationsSubscription#createPartialUpdate(Notification)}
   */
  @Test
  @DisplayName("Test createPartialUpdate(Notification); then return ErrorMsg is 'null'")
  void testCreatePartialUpdate_thenReturnErrorMsgIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    BiConsumer<TbSubscription<NotificationsSubscriptionUpdate>, NotificationsSubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);
    NotificationsSubscription notificationsSubscription = new NotificationsSubscription("42", "42", 1, tenantId, null,
        updateProcessor, 1, new HashSet<>());
    Notification notification = new Notification();

    // Act
    UnreadNotificationsUpdate actualCreatePartialUpdateResult = notificationsSubscription
        .createPartialUpdate(notification);

    // Assert
    assertNull(actualCreatePartialUpdateResult.getErrorMsg());
    assertNull(actualCreatePartialUpdateResult.getNotifications());
    assertEquals(0, actualCreatePartialUpdateResult.getTotalUnreadCount());
    assertEquals(0, actualCreatePartialUpdateResult.getErrorCode());
    assertEquals(1, notificationsSubscription.getSequence().get());
    assertEquals(1, actualCreatePartialUpdateResult.getSequenceNumber());
    assertEquals(1, actualCreatePartialUpdateResult.getCmdId());
    assertEquals(CmdUpdateType.NOTIFICATIONS, actualCreatePartialUpdateResult.getCmdUpdateType());
    assertSame(notification, actualCreatePartialUpdateResult.getUpdate());
  }

  /**
   * Test {@link NotificationsSubscription#createCountUpdate()}.
   * <ul>
   *   <li>Then return ErrorMsg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubscription#createCountUpdate()}
   */
  @Test
  @DisplayName("Test createCountUpdate(); then return ErrorMsg is 'null'")
  void testCreateCountUpdate_thenReturnErrorMsgIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    BiConsumer<TbSubscription<NotificationsSubscriptionUpdate>, NotificationsSubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);
    NotificationsSubscription notificationsSubscription = new NotificationsSubscription("42", "42", 1, tenantId, null,
        updateProcessor, 1, new HashSet<>());

    // Act
    UnreadNotificationsUpdate actualCreateCountUpdateResult = notificationsSubscription.createCountUpdate();

    // Assert
    assertNull(actualCreateCountUpdateResult.getErrorMsg());
    assertNull(actualCreateCountUpdateResult.getNotifications());
    assertNull(actualCreateCountUpdateResult.getUpdate());
    assertEquals(0, actualCreateCountUpdateResult.getTotalUnreadCount());
    assertEquals(0, actualCreateCountUpdateResult.getErrorCode());
    assertEquals(1, notificationsSubscription.getSequence().get());
    assertEquals(1, actualCreateCountUpdateResult.getSequenceNumber());
    assertEquals(1, actualCreateCountUpdateResult.getCmdId());
    assertEquals(CmdUpdateType.NOTIFICATIONS, actualCreateCountUpdateResult.getCmdUpdateType());
  }
}
