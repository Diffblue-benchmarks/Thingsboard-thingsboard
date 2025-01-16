package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import io.netty.channel.group.DefaultChannelGroup;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.notification.targets.NotificationRecipient;

class NotificationRequestStatsDiffblueTest {
  /**
   * Test
   * {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}.
   * <ul>
   *   <li>Given {@code WEB}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}
   */
  @Test
  @DisplayName("Test new NotificationRequestStats(Map, Map, Integer, String); given 'WEB'")
  void testNewNotificationRequestStats_givenWeb() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();
    sent.computeIfPresent(NotificationDeliveryMethod.WEB, mock(BiFunction.class));

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
   * Test
   * {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}.
   * <ul>
   *   <li>Then return TotalErrors AndDecrement is minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}
   */
  @Test
  @DisplayName("Test new NotificationRequestStats(Map, Map, Integer, String); then return TotalErrors AndDecrement is minus one")
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
   * Test
   * {@link NotificationRequestStats#reportSent(NotificationDeliveryMethod, NotificationRecipient)}.
   * <ul>
   *   <li>Then {@link NotificationRequestStats#NotificationRequestStats()} Sent
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequestStats#reportSent(NotificationDeliveryMethod, NotificationRecipient)}
   */
  @Test
  @DisplayName("Test reportSent(NotificationDeliveryMethod, NotificationRecipient); then NotificationRequestStats() Sent size is one")
  void testReportSent_thenNotificationRequestStatsSentSizeIsOne() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();

    // Act
    notificationRequestStats.reportSent(NotificationDeliveryMethod.WEB, new User());

    // Assert
    Map<NotificationDeliveryMethod, AtomicInteger> sent = notificationRequestStats.getSent();
    assertEquals(1, sent.size());
    assertEquals(1, notificationRequestStats.getTotalSent().get());
    assertTrue(sent.containsKey(NotificationDeliveryMethod.WEB));
  }

  /**
   * Test
   * {@link NotificationRequestStats#reportProcessed(NotificationDeliveryMethod, Object)}.
   * <ul>
   *   <li>Then {@link NotificationRequestStats#NotificationRequestStats()}
   * ProcessedRecipients size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequestStats#reportProcessed(NotificationDeliveryMethod, Object)}
   */
  @Test
  @DisplayName("Test reportProcessed(NotificationDeliveryMethod, Object); then NotificationRequestStats() ProcessedRecipients size is one")
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
   * Test
   * {@link NotificationRequestStats#reportProcessed(NotificationDeliveryMethod, Object)}.
   * <ul>
   *   <li>When {@link DefaultChannelGroup}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequestStats#reportProcessed(NotificationDeliveryMethod, Object)}
   */
  @Test
  @DisplayName("Test reportProcessed(NotificationDeliveryMethod, Object); when DefaultChannelGroup")
  void testReportProcessed_whenDefaultChannelGroup() {
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
   * Test
   * {@link NotificationRequestStats#contains(NotificationDeliveryMethod, Object)}.
   * <ul>
   *   <li>When {@link DefaultChannelGroup}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequestStats#contains(NotificationDeliveryMethod, Object)}
   */
  @Test
  @DisplayName("Test contains(NotificationDeliveryMethod, Object); when DefaultChannelGroup; then return 'false'")
  void testContains_whenDefaultChannelGroup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new NotificationRequestStats()).contains(NotificationDeliveryMethod.WEB, mock(DefaultChannelGroup.class)));
  }

  /**
   * Test
   * {@link NotificationRequestStats#contains(NotificationDeliveryMethod, Object)}.
   * <ul>
   *   <li>When {@code WEB}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequestStats#contains(NotificationDeliveryMethod, Object)}
   */
  @Test
  @DisplayName("Test contains(NotificationDeliveryMethod, Object); when 'WEB'; then return 'false'")
  void testContains_whenWeb_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new NotificationRequestStats()).contains(NotificationDeliveryMethod.WEB, "Recipient Id"));
  }

  /**
   * Test {@link NotificationRequestStats#equals(Object)}, and
   * {@link NotificationRequestStats#hashCode()}.
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
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRequestStats(), "Different type to NotificationRequestStats");
  }
}
