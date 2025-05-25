package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * Test {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Errors Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}
   */
  @Test
  @DisplayName("Test new NotificationRequestStats(Map, Map, Integer, String); when 'null'; then return Errors Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRequestStats.<init>(Map, Map, Integer, String)"})
  void testNewNotificationRequestStats_whenNull_thenReturnErrorsEmpty() {
    // Arrange
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();

    // Act
    NotificationRequestStats actualNotificationRequestStats = new NotificationRequestStats(sent, new HashMap<>(), null,
        "An error occurred");

    // Assert
    assertTrue(actualNotificationRequestStats.getErrors().isEmpty());
    AtomicInteger totalErrors = actualNotificationRequestStats.getTotalErrors();
    assertEquals(0, totalErrors.getAndDecrement());
    assertEquals(-1, totalErrors.getAndIncrement());
  }

  /**
   * Test {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Errors is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#NotificationRequestStats(Map, Map, Integer, String)}
   */
  @Test
  @DisplayName("Test new NotificationRequestStats(Map, Map, Integer, String); when 'null'; then return Errors is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRequestStats.<init>(Map, Map, Integer, String)"})
  void testNewNotificationRequestStats_whenNull_thenReturnErrorsIsNull() {
    // Arrange and Act
    NotificationRequestStats actualNotificationRequestStats = new NotificationRequestStats(new HashMap<>(), null, null,
        "An error occurred");

    // Assert
    assertNull(actualNotificationRequestStats.getErrors());
    AtomicInteger totalErrors = actualNotificationRequestStats.getTotalErrors();
    assertEquals(0, totalErrors.getAndDecrement());
    assertEquals(-1, totalErrors.getAndIncrement());
  }

  /**
   * Test {@link NotificationRequestStats#reportSent(NotificationDeliveryMethod, NotificationRecipient)}.
   * <ul>
   *   <li>Then {@link NotificationRequestStats#NotificationRequestStats()} Sent size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#reportSent(NotificationDeliveryMethod, NotificationRecipient)}
   */
  @Test
  @DisplayName("Test reportSent(NotificationDeliveryMethod, NotificationRecipient); then NotificationRequestStats() Sent size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRequestStats.reportSent(NotificationDeliveryMethod, NotificationRecipient)"})
  void testReportSent_thenNotificationRequestStatsSentSizeIsOne() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();

    // Act
    notificationRequestStats.reportSent(NotificationDeliveryMethod.WEB, new User());

    // Assert
    Map<NotificationDeliveryMethod, AtomicInteger> sent = notificationRequestStats.getSent();
    assertEquals(1, sent.size());
    AtomicInteger getResult = sent.get(NotificationDeliveryMethod.WEB);
    assertEquals(1, getResult.getAndDecrement());
    assertEquals(0, getResult.getAndIncrement());
    assertEquals(1, notificationRequestStats.getTotalSent().get());
  }

  /**
   * Test {@link NotificationRequestStats#reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)}.
   * <p>
   * Method under test: {@link NotificationRequestStats#reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)}
   */
  @Test
  @DisplayName("Test reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationRequestStats.reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)"})
  void testReportError() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();
    Throwable error = new Throwable();

    User recipient = new User();
    recipient.setEmail("jane.doe@example.org");

    // Act
    notificationRequestStats.reportError(NotificationDeliveryMethod.WEB, error, recipient);

    // Assert
    Map<NotificationDeliveryMethod, Map<String, String>> errors = notificationRequestStats.getErrors();
    assertEquals(1, errors.size());
    Map<String, String> getResult = errors.get(NotificationDeliveryMethod.WEB);
    assertEquals(1, getResult.size());
    assertEquals("Throwable", getResult.get("jane.doe@example.org"));
    AtomicInteger totalErrors = notificationRequestStats.getTotalErrors();
    assertEquals(1, totalErrors.getAndDecrement());
    assertEquals(0, totalErrors.getAndIncrement());
  }

  /**
   * Test {@link NotificationRequestStats#reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)}.
   * <p>
   * Method under test: {@link NotificationRequestStats#reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)}
   */
  @Test
  @DisplayName("Test reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationRequestStats.reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)"})
  void testReportError2() {
    // Arrange
    HashMap<NotificationDeliveryMethod, Map<String, String>> errors = new HashMap<>();
    errors.put(NotificationDeliveryMethod.WEB, new HashMap<>());
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats(new HashMap<>(), errors, -1,
        "An error occurred");
    Throwable error = new Throwable();

    // Act
    notificationRequestStats.reportError(NotificationDeliveryMethod.WEB, error, new User());

    // Assert
    assertSame(errors, notificationRequestStats.getErrors());
    AtomicInteger totalErrors = notificationRequestStats.getTotalErrors();
    assertEquals(0, totalErrors.getAndDecrement());
    assertEquals(-1, totalErrors.getAndIncrement());
  }

  /**
   * Test {@link NotificationRequestStats#reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)}.
   * <ul>
   *   <li>Then {@link NotificationRequestStats#NotificationRequestStats()} Errors {@code WEB} {@code jane.doe@example.org} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestStats#reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)}
   */
  @Test
  @DisplayName("Test reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient); then NotificationRequestStats() Errors 'WEB' 'jane.doe@example.org' is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationRequestStats.reportError(NotificationDeliveryMethod, Throwable, NotificationRecipient)"})
  void testReportError_thenNotificationRequestStatsErrorsWebJaneDoeExampleOrgIsFoo() {
    // Arrange
    NotificationRequestStats notificationRequestStats = new NotificationRequestStats();
    Throwable error = new Throwable("foo");

    User recipient = new User();
    recipient.setEmail("jane.doe@example.org");

    // Act
    notificationRequestStats.reportError(NotificationDeliveryMethod.WEB, error, recipient);

    // Assert
    Map<NotificationDeliveryMethod, Map<String, String>> errors = notificationRequestStats.getErrors();
    assertEquals(1, errors.size());
    Map<String, String> getResult = errors.get(NotificationDeliveryMethod.WEB);
    assertEquals(1, getResult.size());
    assertEquals("foo", getResult.get("jane.doe@example.org"));
    AtomicInteger totalErrors = notificationRequestStats.getTotalErrors();
    assertEquals(1, totalErrors.getAndDecrement());
    assertEquals(0, totalErrors.getAndIncrement());
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
