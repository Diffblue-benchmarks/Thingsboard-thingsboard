/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.monitoring.notification;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.monitoring.data.notification.Notification;
import org.thingsboard.monitoring.notification.channels.NotificationChannel;

@ContextConfiguration(classes = {NotificationService.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class NotificationServiceDiffblueTest {
  @Autowired private List<NotificationChannel> list;

  @MockBean private NotificationChannel notificationChannel;

  @Autowired private NotificationService notificationService;

  /**
   * Test {@link NotificationService#sendNotification(Notification)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Notification} {@link Notification#getText()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationService#sendNotification(Notification)}
   */
  @Test
  @DisplayName(
      "Test sendNotification(Notification); given '42'; when Notification getText() return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationService.sendNotification(Notification)"})
  void testSendNotification_given42_whenNotificationGetTextReturn42() {
    // Arrange
    Notification notification = mock(Notification.class);
    when(notification.getText()).thenReturn("42");

    // Act
    notificationService.sendNotification(notification);

    // Assert
    verify(notification).getText();
  }

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationService.sendNotification(Notification)"})
  void testSendNotification_givenArrayListAddNotificationChannel() {
    // Arrange
    ArrayList<NotificationChannel> notificationChannels = new ArrayList<>();
    notificationChannels.add(mock(NotificationChannel.class));
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
   *   <li>Given {@code foo}.
   *   <li>When {@link Notification} {@link Notification#getText()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationService#sendNotification(Notification)}
   */
  @Test
  @DisplayName(
      "Test sendNotification(Notification); given 'foo'; when Notification getText() return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationService.sendNotification(Notification)"})
  void testSendNotification_givenFoo_whenNotificationGetTextReturnFoo() {
    // Arrange
    Notification notification = mock(Notification.class);
    when(notification.getText()).thenReturn("foo");

    // Act
    notificationService.sendNotification(notification);

    // Assert
    verify(notification).getText();
  }

  /**
   * Test {@link NotificationService#sendNotification(Notification)}.
   *
   * <ul>
   *   <li>Given {@link NotificationChannel}.
   *   <li>When {@link Notification} {@link Notification#getText()} return {@code Text}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationService#sendNotification(Notification)}
   */
  @Test
  @DisplayName(
      "Test sendNotification(Notification); given NotificationChannel; when Notification getText() return 'Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationService.sendNotification(Notification)"})
  void testSendNotification_givenNotificationChannel_whenNotificationGetTextReturnText() {
    // Arrange
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
   *   <li>Given {@link NotificationService#NotificationService(List)} with notificationChannels is
   *       {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationService#sendNotification(Notification)}
   */
  @Test
  @DisplayName(
      "Test sendNotification(Notification); given NotificationService(List) with notificationChannels is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationService.sendNotification(Notification)"})
  void testSendNotification_givenNotificationServiceWithNotificationChannelsIsArrayList() {
    // Arrange
    NotificationService notificationService = new NotificationService(new ArrayList<>());

    Notification notification = mock(Notification.class);
    when(notification.getText()).thenReturn("Text");

    // Act
    notificationService.sendNotification(notification);

    // Assert
    verify(notification).getText();
  }
}
