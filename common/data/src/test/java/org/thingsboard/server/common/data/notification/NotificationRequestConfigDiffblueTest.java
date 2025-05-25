package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NotificationRequestConfigDiffblueTest {
  /**
   * Test {@link NotificationRequestConfig#equals(Object)}, and {@link NotificationRequestConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestConfig#equals(Object)}
   *   <li>{@link NotificationRequestConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestConfig.equals(Object)", "int NotificationRequestConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRequestConfig notificationRequestConfig = new NotificationRequestConfig();
    notificationRequestConfig.setSendingDelayInSec(3);

    NotificationRequestConfig notificationRequestConfig2 = new NotificationRequestConfig();
    notificationRequestConfig2.setSendingDelayInSec(3);

    // Act and Assert
    assertEquals(notificationRequestConfig, notificationRequestConfig2);
    int expectedHashCodeResult = notificationRequestConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestConfig2.hashCode());
  }

  /**
   * Test {@link NotificationRequestConfig#equals(Object)}, and {@link NotificationRequestConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestConfig#equals(Object)}
   *   <li>{@link NotificationRequestConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestConfig.equals(Object)", "int NotificationRequestConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestConfig notificationRequestConfig = new NotificationRequestConfig();
    notificationRequestConfig.setSendingDelayInSec(3);

    // Act and Assert
    assertEquals(notificationRequestConfig, notificationRequestConfig);
    int expectedHashCodeResult = notificationRequestConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestConfig.hashCode());
  }

  /**
   * Test {@link NotificationRequestConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestConfig.equals(Object)", "int NotificationRequestConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequestConfig notificationRequestConfig = new NotificationRequestConfig();
    notificationRequestConfig.setSendingDelayInSec(1);

    NotificationRequestConfig notificationRequestConfig2 = new NotificationRequestConfig();
    notificationRequestConfig2.setSendingDelayInSec(3);

    // Act and Assert
    assertNotEquals(notificationRequestConfig, notificationRequestConfig2);
  }

  /**
   * Test {@link NotificationRequestConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestConfig.equals(Object)", "int NotificationRequestConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRequestConfig notificationRequestConfig = new NotificationRequestConfig();
    notificationRequestConfig.setSendingDelayInSec(3);

    // Act and Assert
    assertNotEquals(notificationRequestConfig, null);
  }

  /**
   * Test {@link NotificationRequestConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestConfig.equals(Object)", "int NotificationRequestConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRequestConfig notificationRequestConfig = new NotificationRequestConfig();
    notificationRequestConfig.setSendingDelayInSec(3);

    // Act and Assert
    assertNotEquals(notificationRequestConfig, "Different type to NotificationRequestConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NotificationRequestConfig}
   *   <li>{@link NotificationRequestConfig#setSendingDelayInSec(int)}
   *   <li>{@link NotificationRequestConfig#toString()}
   *   <li>{@link NotificationRequestConfig#getSendingDelayInSec()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRequestConfig.<init>()", "int NotificationRequestConfig.getSendingDelayInSec()",
      "void NotificationRequestConfig.setSendingDelayInSec(int)", "String NotificationRequestConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRequestConfig actualNotificationRequestConfig = new NotificationRequestConfig();
    actualNotificationRequestConfig.setSendingDelayInSec(3);
    String actualToStringResult = actualNotificationRequestConfig.toString();

    // Assert
    assertEquals("NotificationRequestConfig(sendingDelayInSec=3)", actualToStringResult);
    assertEquals(3, actualNotificationRequestConfig.getSendingDelayInSec());
  }
}
