package org.thingsboard.server.service.ws.notification.cmd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.ws.WsCmdType;

class MarkAllNotificationsAsReadCmdDiffblueTest {
  /**
   * Test {@link MarkAllNotificationsAsReadCmd#equals(Object)}, and
   * {@link MarkAllNotificationsAsReadCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MarkAllNotificationsAsReadCmd#equals(Object)}
   *   <li>{@link MarkAllNotificationsAsReadCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MarkAllNotificationsAsReadCmd markAllNotificationsAsReadCmd = new MarkAllNotificationsAsReadCmd(1);
    MarkAllNotificationsAsReadCmd markAllNotificationsAsReadCmd2 = new MarkAllNotificationsAsReadCmd(1);

    // Act and Assert
    assertEquals(markAllNotificationsAsReadCmd, markAllNotificationsAsReadCmd2);
    int expectedHashCodeResult = markAllNotificationsAsReadCmd.hashCode();
    assertEquals(expectedHashCodeResult, markAllNotificationsAsReadCmd2.hashCode());
  }

  /**
   * Test {@link MarkAllNotificationsAsReadCmd#equals(Object)}, and
   * {@link MarkAllNotificationsAsReadCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MarkAllNotificationsAsReadCmd#equals(Object)}
   *   <li>{@link MarkAllNotificationsAsReadCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MarkAllNotificationsAsReadCmd markAllNotificationsAsReadCmd = new MarkAllNotificationsAsReadCmd(1);

    // Act and Assert
    assertEquals(markAllNotificationsAsReadCmd, markAllNotificationsAsReadCmd);
    int expectedHashCodeResult = markAllNotificationsAsReadCmd.hashCode();
    assertEquals(expectedHashCodeResult, markAllNotificationsAsReadCmd.hashCode());
  }

  /**
   * Test {@link MarkAllNotificationsAsReadCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkAllNotificationsAsReadCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MarkAllNotificationsAsReadCmd markAllNotificationsAsReadCmd = new MarkAllNotificationsAsReadCmd(2);

    // Act and Assert
    assertNotEquals(markAllNotificationsAsReadCmd, new MarkAllNotificationsAsReadCmd(1));
  }

  /**
   * Test {@link MarkAllNotificationsAsReadCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkAllNotificationsAsReadCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MarkAllNotificationsAsReadCmd(1), null);
  }

  /**
   * Test {@link MarkAllNotificationsAsReadCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkAllNotificationsAsReadCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MarkAllNotificationsAsReadCmd(1), "Different type to MarkAllNotificationsAsReadCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MarkAllNotificationsAsReadCmd#MarkAllNotificationsAsReadCmd()}
   *   <li>{@link MarkAllNotificationsAsReadCmd#setCmdId(int)}
   *   <li>{@link MarkAllNotificationsAsReadCmd#toString()}
   *   <li>{@link MarkAllNotificationsAsReadCmd#getCmdId()}
   *   <li>{@link MarkAllNotificationsAsReadCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    MarkAllNotificationsAsReadCmd actualMarkAllNotificationsAsReadCmd = new MarkAllNotificationsAsReadCmd();
    actualMarkAllNotificationsAsReadCmd.setCmdId(1);
    String actualToStringResult = actualMarkAllNotificationsAsReadCmd.toString();
    int actualCmdId = actualMarkAllNotificationsAsReadCmd.getCmdId();

    // Assert that nothing has changed
    assertEquals("MarkAllNotificationsAsReadCmd(cmdId=1)", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.MARK_ALL_NOTIFICATIONS_AS_READ, actualMarkAllNotificationsAsReadCmd.getType());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MarkAllNotificationsAsReadCmd#MarkAllNotificationsAsReadCmd(int)}
   *   <li>{@link MarkAllNotificationsAsReadCmd#setCmdId(int)}
   *   <li>{@link MarkAllNotificationsAsReadCmd#toString()}
   *   <li>{@link MarkAllNotificationsAsReadCmd#getCmdId()}
   *   <li>{@link MarkAllNotificationsAsReadCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    MarkAllNotificationsAsReadCmd actualMarkAllNotificationsAsReadCmd = new MarkAllNotificationsAsReadCmd(1);
    actualMarkAllNotificationsAsReadCmd.setCmdId(1);
    String actualToStringResult = actualMarkAllNotificationsAsReadCmd.toString();
    int actualCmdId = actualMarkAllNotificationsAsReadCmd.getCmdId();

    // Assert that nothing has changed
    assertEquals("MarkAllNotificationsAsReadCmd(cmdId=1)", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.MARK_ALL_NOTIFICATIONS_AS_READ, actualMarkAllNotificationsAsReadCmd.getType());
  }
}
