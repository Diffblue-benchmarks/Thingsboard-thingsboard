package org.thingsboard.server.service.ws.notification.cmd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.ws.WsCmdType;

class NotificationsUnsubCmdDiffblueTest {
  /**
   * Test {@link NotificationsUnsubCmd#equals(Object)}, and
   * {@link NotificationsUnsubCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsUnsubCmd#equals(Object)}
   *   <li>{@link NotificationsUnsubCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationsUnsubCmd notificationsUnsubCmd = new NotificationsUnsubCmd(1);
    NotificationsUnsubCmd notificationsUnsubCmd2 = new NotificationsUnsubCmd(1);

    // Act and Assert
    assertEquals(notificationsUnsubCmd, notificationsUnsubCmd2);
    int expectedHashCodeResult = notificationsUnsubCmd.hashCode();
    assertEquals(expectedHashCodeResult, notificationsUnsubCmd2.hashCode());
  }

  /**
   * Test {@link NotificationsUnsubCmd#equals(Object)}, and
   * {@link NotificationsUnsubCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsUnsubCmd#equals(Object)}
   *   <li>{@link NotificationsUnsubCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationsUnsubCmd notificationsUnsubCmd = new NotificationsUnsubCmd(1);

    // Act and Assert
    assertEquals(notificationsUnsubCmd, notificationsUnsubCmd);
    int expectedHashCodeResult = notificationsUnsubCmd.hashCode();
    assertEquals(expectedHashCodeResult, notificationsUnsubCmd.hashCode());
  }

  /**
   * Test {@link NotificationsUnsubCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsUnsubCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationsUnsubCmd notificationsUnsubCmd = new NotificationsUnsubCmd(2);

    // Act and Assert
    assertNotEquals(notificationsUnsubCmd, new NotificationsUnsubCmd(1));
  }

  /**
   * Test {@link NotificationsUnsubCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsUnsubCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationsUnsubCmd(1), null);
  }

  /**
   * Test {@link NotificationsUnsubCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsUnsubCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationsUnsubCmd(1), "Different type to NotificationsUnsubCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsUnsubCmd#NotificationsUnsubCmd()}
   *   <li>{@link NotificationsUnsubCmd#setCmdId(int)}
   *   <li>{@link NotificationsUnsubCmd#toString()}
   *   <li>{@link NotificationsUnsubCmd#getCmdId()}
   *   <li>{@link NotificationsUnsubCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationsUnsubCmd actualNotificationsUnsubCmd = new NotificationsUnsubCmd();
    actualNotificationsUnsubCmd.setCmdId(1);
    String actualToStringResult = actualNotificationsUnsubCmd.toString();
    int actualCmdId = actualNotificationsUnsubCmd.getCmdId();

    // Assert that nothing has changed
    assertEquals("NotificationsUnsubCmd(cmdId=1)", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.NOTIFICATIONS_UNSUBSCRIBE, actualNotificationsUnsubCmd.getType());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsUnsubCmd#NotificationsUnsubCmd(int)}
   *   <li>{@link NotificationsUnsubCmd#setCmdId(int)}
   *   <li>{@link NotificationsUnsubCmd#toString()}
   *   <li>{@link NotificationsUnsubCmd#getCmdId()}
   *   <li>{@link NotificationsUnsubCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    NotificationsUnsubCmd actualNotificationsUnsubCmd = new NotificationsUnsubCmd(1);
    actualNotificationsUnsubCmd.setCmdId(1);
    String actualToStringResult = actualNotificationsUnsubCmd.toString();
    int actualCmdId = actualNotificationsUnsubCmd.getCmdId();

    // Assert that nothing has changed
    assertEquals("NotificationsUnsubCmd(cmdId=1)", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.NOTIFICATIONS_UNSUBSCRIBE, actualNotificationsUnsubCmd.getType());
  }
}
