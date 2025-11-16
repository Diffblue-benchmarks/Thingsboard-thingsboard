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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.notification.targets.NotificationRecipient;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversation;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversationType;

class NotificationRequestStatsDiffblueTest {
  /**
   * Test {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return TotalErrors is minus one.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#NotificationRequestStats(Map, Map,
   * Integer, String)}
   */
  @Test
  @DisplayName(
      "Test new NotificationRequestStats(Map, Map, Integer, String); when minus one; then return TotalErrors is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestStats.<init>(Map, Map, Integer, String)"})
  void testNewNotificationRequestStats_whenMinusOne_thenReturnTotalErrorsIsMinusOne() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();

    // Act
    NotificationRequestStats actualNotificationRequestStats =
        new NotificationRequestStats(sent, new HashMap<>(), -1, "An error occurred");

    // Assert
    AtomicInteger totalErrors = actualNotificationRequestStats.getTotalErrors();
    assertEquals(-1, totalErrors.get());
    assertEquals(-1, totalErrors.getAcquire());
    assertEquals(-1, totalErrors.getOpaque());
    assertEquals(-1, totalErrors.getPlain());
  }

  /**
   * Test {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Errors Empty.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#NotificationRequestStats(Map, Map,
   * Integer, String)}
   */
  @Test
  @DisplayName(
      "Test new NotificationRequestStats(Map, Map, Integer, String); when 'null'; then return Errors Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestStats.<init>(Map, Map, Integer, String)"})
  void testNewNotificationRequestStats_whenNull_thenReturnErrorsEmpty() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();

    // Act
    NotificationRequestStats actualNotificationRequestStats =
        new NotificationRequestStats(sent, new HashMap<>(), null, "An error occurred");

    // Assert
    AtomicInteger totalErrors = actualNotificationRequestStats.getTotalErrors();
    assertEquals(0, totalErrors.get());
    assertEquals(0, totalErrors.getAcquire());
    assertEquals(0, totalErrors.getOpaque());
    assertEquals(0, totalErrors.getPlain());
    assertTrue(actualNotificationRequestStats.getErrors().isEmpty());
  }

  /**
   * Test {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Errors is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#NotificationRequestStats(Map, Map,
   * Integer, String)}
   */
  @Test
  @DisplayName(
      "Test new NotificationRequestStats(Map, Map, Integer, String); when 'null'; then return Errors is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestStats.<init>(Map, Map, Integer, String)"})
  void testNewNotificationRequestStats_whenNull_thenReturnErrorsIsNull() {
    // Arrange and Act
    NotificationRequestStats actualNotificationRequestStats =
        new NotificationRequestStats(new HashMap<>(), null, null, "An error occurred");

    // Assert
    assertNull(actualNotificationRequestStats.getErrors());
    AtomicInteger totalErrors = actualNotificationRequestStats.getTotalErrors();
    assertEquals(0, totalErrors.get());
    assertEquals(0, totalErrors.getAcquire());
    assertEquals(0, totalErrors.getOpaque());
    assertEquals(0, totalErrors.getPlain());
  }

  /**
   * Test {@link NotificationRequestStats#reportSent(NotificationDeliveryMethod,
   * NotificationRecipient)}.
   *
   * <ul>
   *   <li>Then {@link NotificationRequestStats#NotificationRequestStats()} Sent size is one.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#reportSent(NotificationDeliveryMethod,
   * NotificationRecipient)}
   */
  @Test
  @DisplayName(
      "Test reportSent(NotificationDeliveryMethod, NotificationRecipient); then NotificationRequestStats() Sent size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationRequestStats.reportSent(NotificationDeliveryMethod, NotificationRecipient)"
  })
  void testReportSent_thenNotificationRequestStatsSentSizeIsOne() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();

    // Act
    notificationRequestStats.reportSent(NotificationDeliveryMethod.WEB, new User());

    // Assert
    Map<NotificationDeliveryMethod, AtomicInteger> sent = notificationRequestStats.getSent();
    assertEquals(1, sent.size());
    AtomicInteger getResult = sent.get(NotificationDeliveryMethod.WEB);
    assertEquals(1, getResult.get());
    AtomicInteger totalSent = notificationRequestStats.getTotalSent();
    assertEquals(1, totalSent.get());
    assertEquals(1, getResult.getAcquire());
    assertEquals(1, totalSent.getAcquire());
    assertEquals(1, getResult.getOpaque());
    assertEquals(1, totalSent.getOpaque());
    assertEquals(1, getResult.getPlain());
    assertEquals(1, totalSent.getPlain());
  }

  /**
   * Test {@link NotificationRequestStats#reportError(NotificationDeliveryMethod, Throwable,
   * NotificationRecipient)}.
   *
   * <p>Method under test: {@link NotificationRequestStats#reportError(NotificationDeliveryMethod,
   * Throwable, NotificationRecipient)}
   */
  @Test
  @DisplayName("Test reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationRequestStats.reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)"
  })
  void testReportError() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();
    HashMap<NotificationDeliveryMethod, Map<String, String>> errors = new HashMap<>();

    NotificationRequestStats notificationRequestStats =
        new NotificationRequestStats(sent, errors, -1, "An error occurred");
    Error error = new Error("Not all who wander are lost");

    // Act
    notificationRequestStats.reportError(
        NotificationDeliveryMethod.WEB,
        error,
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build());

    // Assert
    Map<NotificationDeliveryMethod, Map<String, String>> errors2 =
        notificationRequestStats.getErrors();
    assertEquals(1, errors2.size());
    Map<String, String> getResult = errors2.get(NotificationDeliveryMethod.WEB);
    assertEquals(1, getResult.size());
    assertEquals("Not all who wander are lost", getResult.get("Whole Name"));
    AtomicInteger totalErrors = notificationRequestStats.getTotalErrors();
    assertEquals(0, totalErrors.get());
    assertEquals(0, totalErrors.getAcquire());
    assertEquals(0, totalErrors.getOpaque());
    assertEquals(0, totalErrors.getPlain());
    assertSame(errors, errors2);
  }

  /**
   * Test {@link NotificationRequestStats#reportError(NotificationDeliveryMethod, Throwable,
   * NotificationRecipient)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code WEB} is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#reportError(NotificationDeliveryMethod,
   * Throwable, NotificationRecipient)}
   */
  @Test
  @DisplayName(
      "Test reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient); given HashMap() 'WEB' is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationRequestStats.reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)"
  })
  void testReportError_givenHashMapWebIsHashMap() {
    // Arrange
    HashMap<NotificationDeliveryMethod, Map<String, String>> errors = new HashMap<>();
    errors.put(NotificationDeliveryMethod.WEB, new HashMap<>());
    NotificationRequestStats notificationRequestStats =
        new NotificationRequestStats(new HashMap<>(), errors, -1, "An error occurred");
    Error error = new Error("Not all who wander are lost");

    // Act
    notificationRequestStats.reportError(NotificationDeliveryMethod.WEB, error, new User());

    // Assert
    assertSame(errors, notificationRequestStats.getErrors());
  }

  /**
   * Test {@link NotificationRequestStats#reportError(NotificationDeliveryMethod, Throwable,
   * NotificationRecipient)}.
   *
   * <ul>
   *   <li>Then {@link NotificationRequestStats#NotificationRequestStats()} Errors size is one.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#reportError(NotificationDeliveryMethod,
   * Throwable, NotificationRecipient)}
   */
  @Test
  @DisplayName(
      "Test reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient); then NotificationRequestStats() Errors size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationRequestStats.reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)"
  })
  void testReportError_thenNotificationRequestStatsErrorsSizeIsOne() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();
    Throwable error = new Throwable();

    // Act
    notificationRequestStats.reportError(
        NotificationDeliveryMethod.WEB,
        error,
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build());

    // Assert
    Map<NotificationDeliveryMethod, Map<String, String>> errors =
        notificationRequestStats.getErrors();
    assertEquals(1, errors.size());
    Map<String, String> getResult = errors.get(NotificationDeliveryMethod.WEB);
    assertEquals(1, getResult.size());
    assertEquals("Throwable", getResult.get("Whole Name"));
    AtomicInteger totalErrors = notificationRequestStats.getTotalErrors();
    assertEquals(1, totalErrors.get());
    assertEquals(1, totalErrors.getAcquire());
    assertEquals(1, totalErrors.getOpaque());
    assertEquals(1, totalErrors.getPlain());
  }

  /**
   * Test {@link NotificationRequestStats#reportProcessed(NotificationDeliveryMethod, Object)}.
   *
   * <ul>
   *   <li>Then {@link NotificationRequestStats#NotificationRequestStats()} ProcessedRecipients size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationRequestStats#reportProcessed(NotificationDeliveryMethod, Object)}
   */
  @Test
  @DisplayName(
      "Test reportProcessed(NotificationDeliveryMethod, Object); then NotificationRequestStats() ProcessedRecipients size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationRequestStats.reportProcessed(NotificationDeliveryMethod, Object)"
  })
  void testReportProcessed_thenNotificationRequestStatsProcessedRecipientsSizeIsOne() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();

    // Act
    notificationRequestStats.reportProcessed(NotificationDeliveryMethod.WEB, "Recipient Id");

    // Assert
    Map<NotificationDeliveryMethod, Set<Object>> processedRecipients =
        notificationRequestStats.getProcessedRecipients();
    assertEquals(1, processedRecipients.size());
    assertEquals(1, processedRecipients.get(NotificationDeliveryMethod.WEB).size());
  }

  /**
   * Test {@link NotificationRequestStats#contains(NotificationDeliveryMethod, Object)}.
   *
   * <ul>
   *   <li>When {@code WEB}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#contains(NotificationDeliveryMethod,
   * Object)}
   */
  @Test
  @DisplayName("Test contains(NotificationDeliveryMethod, Object); when 'WEB'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestStats.contains(NotificationDeliveryMethod, Object)"
  })
  void testContains_whenWeb_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new NotificationRequestStats().contains(NotificationDeliveryMethod.WEB, "Recipient Id"));
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}, and {@link
   * NotificationRequestStats#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestStats#equals(Object)}
   *   <li>{@link NotificationRequestStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestStats.equals(Object)",
    "int NotificationRequestStats.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestStats.equals(Object)",
    "int NotificationRequestStats.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();

    // Act and Assert
    assertNotEquals(notificationRequestStats, new NotificationRequestStats());
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestStats.equals(Object)",
    "int NotificationRequestStats.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();
    NotificationRequestStats notificationRequestStats =
        new NotificationRequestStats(sent, new HashMap<>(), -1, "An error occurred");

    // Act and Assert
    assertNotEquals(notificationRequestStats, new NotificationRequestStats());
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestStats.equals(Object)",
    "int NotificationRequestStats.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();
    sent.put(NotificationDeliveryMethod.WEB, new AtomicInteger());
    NotificationRequestStats notificationRequestStats =
        new NotificationRequestStats(sent, new HashMap<>(), -1, "An error occurred");

    // Act and Assert
    assertNotEquals(notificationRequestStats, new NotificationRequestStats());
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestStats.equals(Object)",
    "int NotificationRequestStats.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();
    NotificationRequestStats notificationRequestStats =
        new NotificationRequestStats(sent, new HashMap<>(), -1, "An error occurred");
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent2 = new HashMap<>();

    // Act and Assert
    assertNotEquals(
        notificationRequestStats,
        new NotificationRequestStats(sent2, new HashMap<>(), -1, "An error occurred"));
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestStats.equals(Object)",
    "int NotificationRequestStats.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashMap<NotificationDeliveryMethod, Map<String, String>> errors = new HashMap<>();
    errors.put(NotificationDeliveryMethod.WEB, new HashMap<>());
    NotificationRequestStats notificationRequestStats =
        new NotificationRequestStats(new HashMap<>(), errors, -1, "An error occurred");
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();

    // Act and Assert
    assertNotEquals(
        notificationRequestStats,
        new NotificationRequestStats(sent, new HashMap<>(), -1, "An error occurred"));
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestStats.equals(Object)",
    "int NotificationRequestStats.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRequestStats(), null);
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestStats.equals(Object)",
    "int NotificationRequestStats.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRequestStats(), "Different type to NotificationRequestStats");
  }
}
