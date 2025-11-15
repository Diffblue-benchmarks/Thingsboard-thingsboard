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
package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import io.netty.channel.group.DefaultChannelGroup;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class NotificationRequestStatsDiffblueTest {
  /**
   * Method under test:
   * {@link NotificationRequestStats#reportProcessed(NotificationDeliveryMethod, Object)}
   */
  @Test
  void testReportProcessed() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();

    // Act
    notificationRequestStats.reportProcessed(NotificationDeliveryMethod.WEB, "Recipient Id");

    // Assert
    Map<NotificationDeliveryMethod, Set<Object>> processedRecipients = notificationRequestStats
        .getProcessedRecipients();
    assertEquals(1, processedRecipients.size());
    assertEquals(1, processedRecipients.get(NotificationDeliveryMethod.WEB).size());
  }

  /**
   * Method under test:
   * {@link NotificationRequestStats#reportProcessed(NotificationDeliveryMethod, Object)}
   */
  @Test
  void testReportProcessed2() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();

    // Act
    notificationRequestStats.reportProcessed(NotificationDeliveryMethod.WEB, mock(DefaultChannelGroup.class));

    // Assert
    Map<NotificationDeliveryMethod, Set<Object>> processedRecipients = notificationRequestStats
        .getProcessedRecipients();
    assertEquals(1, processedRecipients.size());
    assertEquals(1, processedRecipients.get(NotificationDeliveryMethod.WEB).size());
  }

  /**
   * Method under test:
   * {@link NotificationRequestStats#contains(NotificationDeliveryMethod, Object)}
   */
  @Test
  void testContains() {
    // Arrange, Act and Assert
    assertFalse((new NotificationRequestStats()).contains(NotificationDeliveryMethod.WEB, "Recipient Id"));
    assertFalse(
        (new NotificationRequestStats()).contains(NotificationDeliveryMethod.WEB, mock(DefaultChannelGroup.class)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestStats#equals(Object)}
   *   <li>{@link NotificationRequestStats#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();

    // Act and Assert
    assertEquals(notificationRequestStats, notificationRequestStats);
    int expectedHashCodeResult = notificationRequestStats.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestStats.hashCode());
  }

  /**
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();

    // Act and Assert
    assertNotEquals(notificationRequestStats, new NotificationRequestStats());
  }

  /**
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats(sent, new HashMap<>(), -1,
        "An error occurred");

    // Act and Assert
    assertNotEquals(notificationRequestStats, new NotificationRequestStats());
  }

  /**
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();
    sent.put(NotificationDeliveryMethod.WEB, new AtomicInteger(1));
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats(sent, new HashMap<>(), -1,
        "An error occurred");

    // Act and Assert
    assertNotEquals(notificationRequestStats, new NotificationRequestStats());
  }

  /**
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();
    sent.computeIfPresent(NotificationDeliveryMethod.WEB, mock(BiFunction.class));
    sent.put(NotificationDeliveryMethod.WEB, new AtomicInteger(1));
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats(sent, new HashMap<>(), -1,
        "An error occurred");

    // Act and Assert
    assertNotEquals(notificationRequestStats, new NotificationRequestStats());
  }

  /**
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats(sent, new HashMap<>(), -1,
        "An error occurred");
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent2 = new HashMap<>();

    // Act and Assert
    assertNotEquals(notificationRequestStats,
        new NotificationRequestStats(sent2, new HashMap<>(), -1, "An error occurred"));
  }

  /**
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    HashMap<NotificationDeliveryMethod, Map<String, String>> errors = new HashMap<>();
    errors.put(NotificationDeliveryMethod.WEB, new HashMap<>());
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats(new HashMap<>(), errors, -1,
        "An error occurred");
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();

    // Act and Assert
    assertNotEquals(notificationRequestStats,
        new NotificationRequestStats(sent, new HashMap<>(), -1, "An error occurred"));
  }

  /**
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRequestStats(), null);
  }

  /**
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRequestStats(), "Different type to NotificationRequestStats");
  }

  /**
   * Method under test:
   * {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}
   */
  @Test
  void testNewNotificationRequestStats() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();
    HashMap<NotificationDeliveryMethod, Map<String, String>> errors = new HashMap<>();

    // Act
    NotificationRequestStats actualNotificationRequestStats = new NotificationRequestStats(sent, errors, -1,
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualNotificationRequestStats.getError());
    assertNull(actualNotificationRequestStats.getTotalSent());
    AtomicInteger totalErrors = actualNotificationRequestStats.getTotalErrors();
    assertEquals(-1, totalErrors.getAndDecrement());
    assertEquals(-2, totalErrors.getAndIncrement());
    Map<NotificationDeliveryMethod, Map<String, String>> errors2 = actualNotificationRequestStats.getErrors();
    assertTrue(errors2.isEmpty());
    assertTrue(actualNotificationRequestStats.getProcessedRecipients().isEmpty());
    Map<NotificationDeliveryMethod, AtomicInteger> sent2 = actualNotificationRequestStats.getSent();
    assertTrue(sent2.isEmpty());
    assertSame(errors, errors2);
    assertSame(sent, sent2);
  }

  /**
   * Method under test:
   * {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}
   */
  @Test
  void testNewNotificationRequestStats2() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();
    sent.computeIfPresent(NotificationDeliveryMethod.WEB, mock(BiFunction.class));
    HashMap<NotificationDeliveryMethod, Map<String, String>> errors = new HashMap<>();

    // Act
    NotificationRequestStats actualNotificationRequestStats = new NotificationRequestStats(sent, errors, -1,
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualNotificationRequestStats.getError());
    assertNull(actualNotificationRequestStats.getTotalSent());
    AtomicInteger totalErrors = actualNotificationRequestStats.getTotalErrors();
    assertEquals(-1, totalErrors.getAndDecrement());
    assertEquals(-2, totalErrors.getAndIncrement());
    Map<NotificationDeliveryMethod, Map<String, String>> errors2 = actualNotificationRequestStats.getErrors();
    assertTrue(errors2.isEmpty());
    assertTrue(actualNotificationRequestStats.getProcessedRecipients().isEmpty());
    Map<NotificationDeliveryMethod, AtomicInteger> sent2 = actualNotificationRequestStats.getSent();
    assertTrue(sent2.isEmpty());
    assertSame(errors, errors2);
    assertSame(sent, sent2);
  }
}
