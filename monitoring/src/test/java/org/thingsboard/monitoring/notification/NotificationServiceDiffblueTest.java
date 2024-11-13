package org.thingsboard.monitoring.notification;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.monitoring.data.notification.Notification;
import org.thingsboard.monitoring.notification.channels.NotificationChannel;

class NotificationServiceDiffblueTest {
  /**
   * Test {@link NotificationService#sendNotification(Notification)}.
   * <p>
   * Method under test: {@link NotificationService#sendNotification(Notification)}
   */
  @Test
  @DisplayName("Test sendNotification(Notification)")
  void testSendNotification() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationService notificationService = new NotificationService(new ArrayList<>());
    Notification notification = mock(Notification.class);
    when(notification.getText()).thenReturn("Text");

    // Act
    notificationService.sendNotification(notification);

    // Assert that nothing has changed
    verify(notification).getText();
  }

  /**
   * Test {@link NotificationService#sendNotification(Notification)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NotificationChannel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationService#sendNotification(Notification)}
   */
  @Test
  @DisplayName("Test sendNotification(Notification); given ArrayList() add NotificationChannel")
  void testSendNotification_givenArrayListAddNotificationChannel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<NotificationChannel> notificationChannels = new ArrayList<>();
    notificationChannels.add(mock(NotificationChannel.class));
    NotificationService notificationService = new NotificationService(notificationChannels);
    Notification notification = mock(Notification.class);
    when(notification.getText()).thenReturn("Text");

    // Act
    notificationService.sendNotification(notification);

    // Assert that nothing has changed
    verify(notification).getText();
  }

  /**
   * Test {@link NotificationService#sendNotification(Notification)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NotificationChannel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationService#sendNotification(Notification)}
   */
  @Test
  @DisplayName("Test sendNotification(Notification); given ArrayList() add NotificationChannel")
  void testSendNotification_givenArrayListAddNotificationChannel2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<NotificationChannel> notificationChannels = new ArrayList<>();
    notificationChannels.add(mock(NotificationChannel.class));
    notificationChannels.add(mock(NotificationChannel.class));
    NotificationService notificationService = new NotificationService(notificationChannels);
    Notification notification = mock(Notification.class);
    when(notification.getText()).thenReturn("Text");

    // Act
    notificationService.sendNotification(notification);

    // Assert that nothing has changed
    verify(notification).getText();
  }
}
