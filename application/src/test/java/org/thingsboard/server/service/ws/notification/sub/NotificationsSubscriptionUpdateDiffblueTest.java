package org.thingsboard.server.service.ws.notification.sub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.NotificationRequestId;

class NotificationsSubscriptionUpdateDiffblueTest {
  /**
   * Test {@link NotificationsSubscriptionUpdate#equals(Object)}, and
   * {@link NotificationsSubscriptionUpdate#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsSubscriptionUpdate#equals(Object)}
   *   <li>{@link NotificationsSubscriptionUpdate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestUpdate notificationRequestUpdate = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();
    NotificationsSubscriptionUpdate notificationsSubscriptionUpdate = new NotificationsSubscriptionUpdate(
        notificationRequestUpdate);

    // Act and Assert
    assertEquals(notificationsSubscriptionUpdate, notificationsSubscriptionUpdate);
    int expectedHashCodeResult = notificationsSubscriptionUpdate.hashCode();
    assertEquals(expectedHashCodeResult, notificationsSubscriptionUpdate.hashCode());
  }

  /**
   * Test {@link NotificationsSubscriptionUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubscriptionUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestUpdate notificationRequestUpdate = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();
    NotificationsSubscriptionUpdate notificationsSubscriptionUpdate = new NotificationsSubscriptionUpdate(
        notificationRequestUpdate);
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult2 = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestUpdate notificationRequestUpdate2 = deletedResult2
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();

    // Act and Assert
    assertNotEquals(notificationsSubscriptionUpdate, new NotificationsSubscriptionUpdate(notificationRequestUpdate2));
  }

  /**
   * Test {@link NotificationsSubscriptionUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubscriptionUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRequestUpdate.NotificationRequestUpdateBuilder notificationRequestUpdateBuilder = mock(
        NotificationRequestUpdate.NotificationRequestUpdateBuilder.class);
    when(notificationRequestUpdateBuilder.deleted(anyBoolean())).thenReturn(NotificationRequestUpdate.builder());
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult = notificationRequestUpdateBuilder
        .deleted(true);
    NotificationRequestUpdate notificationRequestUpdate = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();
    NotificationsSubscriptionUpdate notificationsSubscriptionUpdate = new NotificationsSubscriptionUpdate(
        notificationRequestUpdate);
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult2 = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestUpdate notificationRequestUpdate2 = deletedResult2
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();

    // Act and Assert
    assertNotEquals(notificationsSubscriptionUpdate, new NotificationsSubscriptionUpdate(notificationRequestUpdate2));
  }

  /**
   * Test {@link NotificationsSubscriptionUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubscriptionUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestUpdate notificationRequestUpdate = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();

    // Act and Assert
    assertNotEquals(new NotificationsSubscriptionUpdate(notificationRequestUpdate), null);
  }

  /**
   * Test {@link NotificationsSubscriptionUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubscriptionUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestUpdate notificationRequestUpdate = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();

    // Act and Assert
    assertNotEquals(new NotificationsSubscriptionUpdate(notificationRequestUpdate),
        "Different type to NotificationsSubscriptionUpdate");
  }
}
