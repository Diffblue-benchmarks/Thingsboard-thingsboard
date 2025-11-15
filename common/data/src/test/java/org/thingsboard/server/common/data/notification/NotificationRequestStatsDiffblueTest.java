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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NotificationRequestStatsDiffblueTest {
  /**
   * Test {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}.
   * <ul>
   *   <li>Then return TotalErrors AndDecrement is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}
   */
  @Test
  @DisplayName("Test new NotificationRequestStats(Map, Map, Integer, String); then return TotalErrors AndDecrement is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRequestStats.<init>(Map, Map, Integer, String)"})
  void testNewNotificationRequestStats_thenReturnTotalErrorsAndDecrementIsMinusOne() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();

    // Act
    NotificationRequestStats actualNotificationRequestStats = new NotificationRequestStats(sent, new HashMap<>(), -1,
        "An error occurred");

    // Assert
    AtomicInteger totalErrors = actualNotificationRequestStats.getTotalErrors();
    assertEquals(-1, totalErrors.getAndDecrement());
    assertEquals(-2, totalErrors.getAndIncrement());
    assertTrue(actualNotificationRequestStats.getErrors().isEmpty());
  }

  /**
   * Test {@link NotificationRequestStats#reportProcessed(NotificationDeliveryMethod, Object)}.
   * <ul>
   *   <li>Then {@link NotificationRequestStats#NotificationRequestStats()} ProcessedRecipients size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#reportProcessed(NotificationDeliveryMethod, Object)}
   */
  @Test
  @DisplayName("Test reportProcessed(NotificationDeliveryMethod, Object); then NotificationRequestStats() ProcessedRecipients size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRequestStats.reportProcessed(NotificationDeliveryMethod, Object)"})
  void testReportProcessed_thenNotificationRequestStatsProcessedRecipientsSizeIsOne() {
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
   * Test {@link NotificationRequestStats#contains(NotificationDeliveryMethod, Object)}.
   * <ul>
   *   <li>When {@code WEB}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#contains(NotificationDeliveryMethod, Object)}
   */
  @Test
  @DisplayName("Test contains(NotificationDeliveryMethod, Object); when 'WEB'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestStats.contains(NotificationDeliveryMethod, Object)"})
  void testContains_whenWeb_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new NotificationRequestStats()).contains(NotificationDeliveryMethod.WEB, "Recipient Id"));
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}, and {@link NotificationRequestStats#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestStats#equals(Object)}
   *   <li>{@link NotificationRequestStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestStats.equals(Object)", "int NotificationRequestStats.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();

    // Act and Assert
    assertEquals(notificationRequestStats, notificationRequestStats);
    int expectedHashCodeResult = notificationRequestStats.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestStats.hashCode());
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestStats.equals(Object)", "int NotificationRequestStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();

    // Act and Assert
    assertNotEquals(notificationRequestStats, new NotificationRequestStats());
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestStats.equals(Object)", "int NotificationRequestStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats(sent, new HashMap<>(), -1,
        "An error occurred");

    // Act and Assert
    assertNotEquals(notificationRequestStats, new NotificationRequestStats());
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestStats.equals(Object)", "int NotificationRequestStats.hashCode()"})
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
   * Test {@link NotificationRequestStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestStats.equals(Object)", "int NotificationRequestStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   * Test {@link NotificationRequestStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestStats.equals(Object)", "int NotificationRequestStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashMap<NotificationDeliveryMethod, Map<String, String>> errors = new HashMap<>();
    errors.put(NotificationDeliveryMethod.SMS, new HashMap<>());
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats(new HashMap<>(), errors, -1,
        "An error occurred");
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();

    // Act and Assert
    assertNotEquals(notificationRequestStats,
        new NotificationRequestStats(sent, new HashMap<>(), -1, "An error occurred"));
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestStats.equals(Object)", "int NotificationRequestStats.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRequestStats(), null);
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestStats.equals(Object)", "int NotificationRequestStats.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRequestStats(), "Different type to NotificationRequestStats");
  }
}
