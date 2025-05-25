package org.thingsboard.server.service.ws.notification.sub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
   * Test {@link NotificationsSubscription#NotificationsSubscription(String, String, int, TenantId, EntityId, BiConsumer, int, Set)}.
   * <ul>
   *   <li>Given {@code ALARM}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubscription#NotificationsSubscription(String, String, int, TenantId, EntityId, BiConsumer, int, Set)}
   */
  @Test
  @DisplayName("Test new NotificationsSubscription(String, String, int, TenantId, EntityId, BiConsumer, int, Set); given 'ALARM'; when HashSet() add 'ALARM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationsSubscription.<init>(String, String, int, TenantId, EntityId, BiConsumer, int, Set)"})
  void testNewNotificationsSubscription_givenAlarm_whenHashSetAddAlarm() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    BiConsumer<TbSubscription<NotificationsSubscriptionUpdate>, NotificationsSubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);

    HashSet<NotificationType> notificationTypes = new HashSet<>();
    notificationTypes.add(NotificationType.ALARM);
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    NotificationsSubscription actualNotificationsSubscription = new NotificationsSubscription("42", "42", 1, tenantId,
        null, updateProcessor, 1, notificationTypes);

    // Assert
    assertEquals("42", actualNotificationsSubscription.getServiceId());
    assertEquals("42", actualNotificationsSubscription.getSessionId());
    assertNull(actualNotificationsSubscription.getEntityId());
    assertEquals(1, actualNotificationsSubscription.getSubscriptionId());
    assertEquals(1, actualNotificationsSubscription.getLimit());
    assertEquals(TbSubscriptionType.NOTIFICATIONS, actualNotificationsSubscription.getType());
    assertTrue(actualNotificationsSubscription.getSortedNotifications().isEmpty());
    assertTrue(actualNotificationsSubscription.getLatestUnreadNotifications().isEmpty());
    assertSame(notificationTypes, actualNotificationsSubscription.getNotificationTypes());
    assertSame(tenantId, actualNotificationsSubscription.getTenantId());
    assertSame(updateProcessor, actualNotificationsSubscription.getUpdateProcessor());
  }

  /**
   * Test {@link NotificationsSubscription#NotificationsSubscription(String, String, int, TenantId, EntityId, BiConsumer, int, Set)}.
   * <ul>
   *   <li>Then return NotificationTypes is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubscription#NotificationsSubscription(String, String, int, TenantId, EntityId, BiConsumer, int, Set)}
   */
  @Test
  @DisplayName("Test new NotificationsSubscription(String, String, int, TenantId, EntityId, BiConsumer, int, Set); then return NotificationTypes is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationsSubscription.<init>(String, String, int, TenantId, EntityId, BiConsumer, int, Set)"})
  void testNewNotificationsSubscription_thenReturnNotificationTypesIsHashSet() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    BiConsumer<TbSubscription<NotificationsSubscriptionUpdate>, NotificationsSubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);

    HashSet<NotificationType> notificationTypes = new HashSet<>();
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    NotificationsSubscription actualNotificationsSubscription = new NotificationsSubscription("42", "42", 1, tenantId,
        null, updateProcessor, 1, notificationTypes);

    // Assert
    assertEquals("42", actualNotificationsSubscription.getServiceId());
    assertEquals("42", actualNotificationsSubscription.getSessionId());
    assertNull(actualNotificationsSubscription.getEntityId());
    assertEquals(1, actualNotificationsSubscription.getSubscriptionId());
    assertEquals(1, actualNotificationsSubscription.getLimit());
    assertEquals(TbSubscriptionType.NOTIFICATIONS, actualNotificationsSubscription.getType());
    assertTrue(actualNotificationsSubscription.getSortedNotifications().isEmpty());
    assertTrue(actualNotificationsSubscription.getLatestUnreadNotifications().isEmpty());
    assertSame(notificationTypes, actualNotificationsSubscription.getNotificationTypes());
    assertSame(tenantId, actualNotificationsSubscription.getTenantId());
    assertSame(updateProcessor, actualNotificationsSubscription.getUpdateProcessor());
  }

  /**
   * Test {@link NotificationsSubscription#NotificationsSubscription(String, String, int, TenantId, EntityId, BiConsumer, int, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return NotificationTypes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubscription#NotificationsSubscription(String, String, int, TenantId, EntityId, BiConsumer, int, Set)}
   */
  @Test
  @DisplayName("Test new NotificationsSubscription(String, String, int, TenantId, EntityId, BiConsumer, int, Set); when HashSet(); then return NotificationTypes Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationsSubscription.<init>(String, String, int, TenantId, EntityId, BiConsumer, int, Set)"})
  void testNewNotificationsSubscription_whenHashSet_thenReturnNotificationTypesEmpty() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    BiConsumer<TbSubscription<NotificationsSubscriptionUpdate>, NotificationsSubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);

    // Act
    NotificationsSubscription actualNotificationsSubscription = new NotificationsSubscription("42", "42", 1, tenantId,
        null, updateProcessor, 1, new HashSet<>());

    // Assert
    assertEquals("42", actualNotificationsSubscription.getServiceId());
    assertEquals("42", actualNotificationsSubscription.getSessionId());
    assertNull(actualNotificationsSubscription.getEntityId());
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
   * Test {@link NotificationsSubscription#checkNotificationType(NotificationType)}.
   * <p>
   * Method under test: {@link NotificationsSubscription#checkNotificationType(NotificationType)}
   */
  @Test
  @DisplayName("Test checkNotificationType(NotificationType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationsSubscription.checkNotificationType(NotificationType)"})
  void testCheckNotificationType() {
    // Arrange, Act and Assert
    assertTrue((new NotificationsSubscription("42", "42", 1,
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, mock(BiConsumer.class), 1, null))
        .checkNotificationType(NotificationType.GENERAL));
  }

  /**
   * Test {@link NotificationsSubscription#checkNotificationType(NotificationType)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ALARM}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubscription#checkNotificationType(NotificationType)}
   */
  @Test
  @DisplayName("Test checkNotificationType(NotificationType); given HashSet() add 'ALARM'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationsSubscription.checkNotificationType(NotificationType)"})
  void testCheckNotificationType_givenHashSetAddAlarm_thenReturnFalse() {
    // Arrange
    HashSet<NotificationType> notificationTypes = new HashSet<>();
    notificationTypes.add(NotificationType.ALARM);

    // Act and Assert
    assertFalse((new NotificationsSubscription("42", "42", 1,
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, mock(BiConsumer.class), 1,
        notificationTypes)).checkNotificationType(NotificationType.GENERAL));
  }

  /**
   * Test {@link NotificationsSubscription#checkNotificationType(NotificationType)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code GENERAL}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubscription#checkNotificationType(NotificationType)}
   */
  @Test
  @DisplayName("Test checkNotificationType(NotificationType); given HashSet() add 'GENERAL'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationsSubscription.checkNotificationType(NotificationType)"})
  void testCheckNotificationType_givenHashSetAddGeneral_thenReturnTrue() {
    // Arrange
    HashSet<NotificationType> notificationTypes = new HashSet<>();
    notificationTypes.add(NotificationType.GENERAL);

    // Act and Assert
    assertTrue((new NotificationsSubscription("42", "42", 1,
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, mock(BiConsumer.class), 1,
        notificationTypes)).checkNotificationType(NotificationType.GENERAL));
  }

  /**
   * Test {@link NotificationsSubscription#checkNotificationType(NotificationType)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubscription#checkNotificationType(NotificationType)}
   */
  @Test
  @DisplayName("Test checkNotificationType(NotificationType); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationsSubscription.checkNotificationType(NotificationType)"})
  void testCheckNotificationType_thenReturnTrue() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UnreadNotificationsUpdate NotificationsSubscription.createFullUpdate()"})
  void testCreateFullUpdate_thenReturnErrorMsgIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List NotificationsSubscription.getSortedNotifications()"})
  void testGetSortedNotifications_thenReturnEmpty() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   * Method under test: {@link NotificationsSubscription#createPartialUpdate(Notification)}
   */
  @Test
  @DisplayName("Test createPartialUpdate(Notification); then return ErrorMsg is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UnreadNotificationsUpdate NotificationsSubscription.createPartialUpdate(Notification)"})
  void testCreatePartialUpdate_thenReturnErrorMsgIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UnreadNotificationsUpdate NotificationsSubscription.createCountUpdate()"})
  void testCreateCountUpdate_thenReturnErrorMsgIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
