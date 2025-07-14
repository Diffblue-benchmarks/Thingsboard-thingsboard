package org.thingsboard.monitoring.notification;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.monitoring.data.notification.Notification;
import org.thingsboard.monitoring.notification.channels.NotificationChannel;

@ExtendWith(MockitoExtension.class)
class NotificationServiceDiffblueTest {
  @Mock private List<NotificationChannel> list;

  @InjectMocks private NotificationService notificationService;

  /**
   * Test {@link NotificationService#sendNotification(Notification)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NotificationChannel}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationService#sendNotification(Notification)}
   */
  @Test
  @DisplayName("Test sendNotification(Notification); given ArrayList() add NotificationChannel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationService.sendNotification(Notification)"})
  void testSendNotification_givenArrayListAddNotificationChannel() {
    // Arrange
    ArrayList<NotificationChannel> notificationChannels = new ArrayList<>();
    notificationChannels.add(mock(NotificationChannel.class));
    NotificationService notificationService = new NotificationService(notificationChannels);
    Notification notification = mock(Notification.class);
    when(notification.getText()).thenReturn("Text");

    // Act
    notificationService.sendNotification(notification);

    // Assert
    verify(notification).getText();
  }

  /**
   * Test {@link NotificationService#sendNotification(Notification)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#forEach(Consumer)} does nothing.
   *   <li>Then calls {@link List#forEach(Consumer)}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationService#sendNotification(Notification)}
   */
  @Test
  @DisplayName(
      "Test sendNotification(Notification); given List forEach(Consumer) does nothing; then calls forEach(Consumer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationService.sendNotification(Notification)"})
  void testSendNotification_givenListForEachDoesNothing_thenCallsForEach() {
    // Arrange
    doNothing().when(list).forEach(Mockito.<Consumer<NotificationChannel>>any());
    Notification notification = mock(Notification.class);
    when(notification.getText()).thenReturn("Text");

    // Act
    notificationService.sendNotification(notification);

    // Assert
    verify(list).forEach(isA(Consumer.class));
    verify(notification).getText();
  }
}
