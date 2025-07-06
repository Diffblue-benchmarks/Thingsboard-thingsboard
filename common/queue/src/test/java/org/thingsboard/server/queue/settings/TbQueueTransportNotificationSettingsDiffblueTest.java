package org.thingsboard.server.queue.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbQueueTransportNotificationSettingsDiffblueTest {
  /**
   * Test {@link TbQueueTransportNotificationSettings#equals(Object)}, and {@link
   * TbQueueTransportNotificationSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueTransportNotificationSettings#equals(Object)}
   *   <li>{@link TbQueueTransportNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueTransportNotificationSettings.equals(Object)",
    "int TbQueueTransportNotificationSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();

    // Act and Assert
    assertEquals(tbQueueTransportNotificationSettings, tbQueueTransportNotificationSettings2);
    int expectedHashCodeResult = tbQueueTransportNotificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueTransportNotificationSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueTransportNotificationSettings#equals(Object)}, and {@link
   * TbQueueTransportNotificationSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueTransportNotificationSettings#equals(Object)}
   *   <li>{@link TbQueueTransportNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueTransportNotificationSettings.equals(Object)",
    "int TbQueueTransportNotificationSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    tbQueueTransportNotificationSettings.setNotificationsTopic("Notifications Topic");

    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    tbQueueTransportNotificationSettings2.setNotificationsTopic("Notifications Topic");

    // Act and Assert
    assertEquals(tbQueueTransportNotificationSettings, tbQueueTransportNotificationSettings2);
    int expectedHashCodeResult = tbQueueTransportNotificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueTransportNotificationSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueTransportNotificationSettings#equals(Object)}, and {@link
   * TbQueueTransportNotificationSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueTransportNotificationSettings#equals(Object)}
   *   <li>{@link TbQueueTransportNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueTransportNotificationSettings.equals(Object)",
    "int TbQueueTransportNotificationSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings =
        new TbQueueTransportNotificationSettings();

    // Act and Assert
    assertEquals(tbQueueTransportNotificationSettings, tbQueueTransportNotificationSettings);
    int expectedHashCodeResult = tbQueueTransportNotificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueTransportNotificationSettings.hashCode());
  }

  /**
   * Test {@link TbQueueTransportNotificationSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueTransportNotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueTransportNotificationSettings.equals(Object)",
    "int TbQueueTransportNotificationSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueTransportNotificationSettings(), 1);
  }

  /**
   * Test {@link TbQueueTransportNotificationSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueTransportNotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueTransportNotificationSettings.equals(Object)",
    "int TbQueueTransportNotificationSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    tbQueueTransportNotificationSettings.setNotificationsTopic("Notifications Topic");

    // Act and Assert
    assertNotEquals(
        tbQueueTransportNotificationSettings, new TbQueueTransportNotificationSettings());
  }

  /**
   * Test {@link TbQueueTransportNotificationSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueTransportNotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueTransportNotificationSettings.equals(Object)",
    "int TbQueueTransportNotificationSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    tbQueueTransportNotificationSettings.setTransportPollInterval(42L);

    // Act and Assert
    assertNotEquals(
        tbQueueTransportNotificationSettings, new TbQueueTransportNotificationSettings());
  }

  /**
   * Test {@link TbQueueTransportNotificationSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueTransportNotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueTransportNotificationSettings.equals(Object)",
    "int TbQueueTransportNotificationSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings =
        new TbQueueTransportNotificationSettings();

    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    tbQueueTransportNotificationSettings2.setNotificationsTopic("Notifications Topic");

    // Act and Assert
    assertNotEquals(tbQueueTransportNotificationSettings, tbQueueTransportNotificationSettings2);
  }

  /**
   * Test {@link TbQueueTransportNotificationSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueTransportNotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueTransportNotificationSettings.equals(Object)",
    "int TbQueueTransportNotificationSettings.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueTransportNotificationSettings(), null);
  }

  /**
   * Test {@link TbQueueTransportNotificationSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueTransportNotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueTransportNotificationSettings.equals(Object)",
    "int TbQueueTransportNotificationSettings.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbQueueTransportNotificationSettings(),
        "Different type to TbQueueTransportNotificationSettings");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueTransportNotificationSettings#setNotificationsTopic(String)}
   *   <li>{@link TbQueueTransportNotificationSettings#setTransportPollInterval(long)}
   *   <li>{@link TbQueueTransportNotificationSettings#toString()}
   *   <li>{@link TbQueueTransportNotificationSettings#getNotificationsTopic()}
   *   <li>{@link TbQueueTransportNotificationSettings#getTransportPollInterval()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String TbQueueTransportNotificationSettings.getNotificationsTopic()",
    "long TbQueueTransportNotificationSettings.getTransportPollInterval()",
    "void TbQueueTransportNotificationSettings.setNotificationsTopic(String)",
    "void TbQueueTransportNotificationSettings.setTransportPollInterval(long)",
    "String TbQueueTransportNotificationSettings.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings =
        new TbQueueTransportNotificationSettings();

    // Act
    tbQueueTransportNotificationSettings.setNotificationsTopic("Notifications Topic");
    tbQueueTransportNotificationSettings.setTransportPollInterval(42L);
    String actualToStringResult = tbQueueTransportNotificationSettings.toString();
    String actualNotificationsTopic = tbQueueTransportNotificationSettings.getNotificationsTopic();

    // Assert
    assertEquals("Notifications Topic", actualNotificationsTopic);
    assertEquals(
        "TbQueueTransportNotificationSettings(notificationsTopic=Notifications Topic, transportPollInterval"
            + "=42)",
        actualToStringResult);
    assertEquals(42L, tbQueueTransportNotificationSettings.getTransportPollInterval());
  }
}
