package org.thingsboard.server.service.ws.notification.cmd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.ws.WsCmdType;

class NotificationsCountSubCmdDiffblueTest {
  /**
   * Test {@link NotificationsCountSubCmd#equals(Object)}, and
   * {@link NotificationsCountSubCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsCountSubCmd#equals(Object)}
   *   <li>{@link NotificationsCountSubCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationsCountSubCmd notificationsCountSubCmd = new NotificationsCountSubCmd(1);
    NotificationsCountSubCmd notificationsCountSubCmd2 = new NotificationsCountSubCmd(1);

    // Act and Assert
    assertEquals(notificationsCountSubCmd, notificationsCountSubCmd2);
    int expectedHashCodeResult = notificationsCountSubCmd.hashCode();
    assertEquals(expectedHashCodeResult, notificationsCountSubCmd2.hashCode());
  }

  /**
   * Test {@link NotificationsCountSubCmd#equals(Object)}, and
   * {@link NotificationsCountSubCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsCountSubCmd#equals(Object)}
   *   <li>{@link NotificationsCountSubCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationsCountSubCmd notificationsCountSubCmd = new NotificationsCountSubCmd(1);

    // Act and Assert
    assertEquals(notificationsCountSubCmd, notificationsCountSubCmd);
    int expectedHashCodeResult = notificationsCountSubCmd.hashCode();
    assertEquals(expectedHashCodeResult, notificationsCountSubCmd.hashCode());
  }

  /**
   * Test {@link NotificationsCountSubCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsCountSubCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationsCountSubCmd notificationsCountSubCmd = new NotificationsCountSubCmd(2);

    // Act and Assert
    assertNotEquals(notificationsCountSubCmd, new NotificationsCountSubCmd(1));
  }

  /**
   * Test {@link NotificationsCountSubCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsCountSubCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationsCountSubCmd(1), null);
  }

  /**
   * Test {@link NotificationsCountSubCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsCountSubCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationsCountSubCmd(1), "Different type to NotificationsCountSubCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsCountSubCmd#NotificationsCountSubCmd()}
   *   <li>{@link NotificationsCountSubCmd#setCmdId(int)}
   *   <li>{@link NotificationsCountSubCmd#toString()}
   *   <li>{@link NotificationsCountSubCmd#getCmdId()}
   *   <li>{@link NotificationsCountSubCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationsCountSubCmd actualNotificationsCountSubCmd = new NotificationsCountSubCmd();
    actualNotificationsCountSubCmd.setCmdId(1);
    String actualToStringResult = actualNotificationsCountSubCmd.toString();
    int actualCmdId = actualNotificationsCountSubCmd.getCmdId();

    // Assert that nothing has changed
    assertEquals("NotificationsCountSubCmd(cmdId=1)", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.NOTIFICATIONS_COUNT, actualNotificationsCountSubCmd.getType());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsCountSubCmd#NotificationsCountSubCmd(int)}
   *   <li>{@link NotificationsCountSubCmd#setCmdId(int)}
   *   <li>{@link NotificationsCountSubCmd#toString()}
   *   <li>{@link NotificationsCountSubCmd#getCmdId()}
   *   <li>{@link NotificationsCountSubCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    NotificationsCountSubCmd actualNotificationsCountSubCmd = new NotificationsCountSubCmd(1);
    actualNotificationsCountSubCmd.setCmdId(1);
    String actualToStringResult = actualNotificationsCountSubCmd.toString();
    int actualCmdId = actualNotificationsCountSubCmd.getCmdId();

    // Assert that nothing has changed
    assertEquals("NotificationsCountSubCmd(cmdId=1)", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.NOTIFICATIONS_COUNT, actualNotificationsCountSubCmd.getType());
  }
}
