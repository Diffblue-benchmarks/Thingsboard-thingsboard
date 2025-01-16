package org.thingsboard.server.service.ws.notification.cmd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.ws.WsCmdType;

class MarkNotificationsAsReadCmdDiffblueTest {
  /**
   * Test {@link MarkNotificationsAsReadCmd#equals(Object)}, and
   * {@link MarkNotificationsAsReadCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MarkNotificationsAsReadCmd#equals(Object)}
   *   <li>{@link MarkNotificationsAsReadCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MarkNotificationsAsReadCmd markNotificationsAsReadCmd = new MarkNotificationsAsReadCmd();
    MarkNotificationsAsReadCmd markNotificationsAsReadCmd2 = new MarkNotificationsAsReadCmd();

    // Act and Assert
    assertEquals(markNotificationsAsReadCmd, markNotificationsAsReadCmd2);
    int expectedHashCodeResult = markNotificationsAsReadCmd.hashCode();
    assertEquals(expectedHashCodeResult, markNotificationsAsReadCmd2.hashCode());
  }

  /**
   * Test {@link MarkNotificationsAsReadCmd#equals(Object)}, and
   * {@link MarkNotificationsAsReadCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MarkNotificationsAsReadCmd#equals(Object)}
   *   <li>{@link MarkNotificationsAsReadCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MarkNotificationsAsReadCmd markNotificationsAsReadCmd = new MarkNotificationsAsReadCmd(1, new ArrayList<>());
    MarkNotificationsAsReadCmd markNotificationsAsReadCmd2 = new MarkNotificationsAsReadCmd(1, new ArrayList<>());

    // Act and Assert
    assertEquals(markNotificationsAsReadCmd, markNotificationsAsReadCmd2);
    int expectedHashCodeResult = markNotificationsAsReadCmd.hashCode();
    assertEquals(expectedHashCodeResult, markNotificationsAsReadCmd2.hashCode());
  }

  /**
   * Test {@link MarkNotificationsAsReadCmd#equals(Object)}, and
   * {@link MarkNotificationsAsReadCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MarkNotificationsAsReadCmd#equals(Object)}
   *   <li>{@link MarkNotificationsAsReadCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MarkNotificationsAsReadCmd markNotificationsAsReadCmd = new MarkNotificationsAsReadCmd();

    // Act and Assert
    assertEquals(markNotificationsAsReadCmd, markNotificationsAsReadCmd);
    int expectedHashCodeResult = markNotificationsAsReadCmd.hashCode();
    assertEquals(expectedHashCodeResult, markNotificationsAsReadCmd.hashCode());
  }

  /**
   * Test {@link MarkNotificationsAsReadCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkNotificationsAsReadCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MarkNotificationsAsReadCmd markNotificationsAsReadCmd = new MarkNotificationsAsReadCmd(1, new ArrayList<>());

    // Act and Assert
    assertNotEquals(markNotificationsAsReadCmd, new MarkNotificationsAsReadCmd());
  }

  /**
   * Test {@link MarkNotificationsAsReadCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkNotificationsAsReadCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MarkNotificationsAsReadCmd markNotificationsAsReadCmd = new MarkNotificationsAsReadCmd();
    markNotificationsAsReadCmd.setNotifications(new ArrayList<>());

    // Act and Assert
    assertNotEquals(markNotificationsAsReadCmd, new MarkNotificationsAsReadCmd());
  }

  /**
   * Test {@link MarkNotificationsAsReadCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkNotificationsAsReadCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MarkNotificationsAsReadCmd markNotificationsAsReadCmd = new MarkNotificationsAsReadCmd();

    MarkNotificationsAsReadCmd markNotificationsAsReadCmd2 = new MarkNotificationsAsReadCmd();
    markNotificationsAsReadCmd2.setNotifications(new ArrayList<>());

    // Act and Assert
    assertNotEquals(markNotificationsAsReadCmd, markNotificationsAsReadCmd2);
  }

  /**
   * Test {@link MarkNotificationsAsReadCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkNotificationsAsReadCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MarkNotificationsAsReadCmd(), null);
  }

  /**
   * Test {@link MarkNotificationsAsReadCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkNotificationsAsReadCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MarkNotificationsAsReadCmd(), "Different type to MarkNotificationsAsReadCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MarkNotificationsAsReadCmd#MarkNotificationsAsReadCmd()}
   *   <li>{@link MarkNotificationsAsReadCmd#setCmdId(int)}
   *   <li>{@link MarkNotificationsAsReadCmd#setNotifications(List)}
   *   <li>{@link MarkNotificationsAsReadCmd#toString()}
   *   <li>{@link MarkNotificationsAsReadCmd#getCmdId()}
   *   <li>{@link MarkNotificationsAsReadCmd#getNotifications()}
   *   <li>{@link MarkNotificationsAsReadCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    MarkNotificationsAsReadCmd actualMarkNotificationsAsReadCmd = new MarkNotificationsAsReadCmd();
    actualMarkNotificationsAsReadCmd.setCmdId(1);
    ArrayList<UUID> notifications = new ArrayList<>();
    actualMarkNotificationsAsReadCmd.setNotifications(notifications);
    String actualToStringResult = actualMarkNotificationsAsReadCmd.toString();
    int actualCmdId = actualMarkNotificationsAsReadCmd.getCmdId();
    List<UUID> actualNotifications = actualMarkNotificationsAsReadCmd.getNotifications();

    // Assert that nothing has changed
    assertEquals("MarkNotificationsAsReadCmd(cmdId=1, notifications=[])", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.MARK_NOTIFICATIONS_AS_READ, actualMarkNotificationsAsReadCmd.getType());
    assertTrue(actualNotifications.isEmpty());
    assertSame(notifications, actualNotifications);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MarkNotificationsAsReadCmd#MarkNotificationsAsReadCmd(int, List)}
   *   <li>{@link MarkNotificationsAsReadCmd#setCmdId(int)}
   *   <li>{@link MarkNotificationsAsReadCmd#setNotifications(List)}
   *   <li>{@link MarkNotificationsAsReadCmd#toString()}
   *   <li>{@link MarkNotificationsAsReadCmd#getCmdId()}
   *   <li>{@link MarkNotificationsAsReadCmd#getNotifications()}
   *   <li>{@link MarkNotificationsAsReadCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    MarkNotificationsAsReadCmd actualMarkNotificationsAsReadCmd = new MarkNotificationsAsReadCmd(1, new ArrayList<>());
    actualMarkNotificationsAsReadCmd.setCmdId(1);
    ArrayList<UUID> notifications = new ArrayList<>();
    actualMarkNotificationsAsReadCmd.setNotifications(notifications);
    String actualToStringResult = actualMarkNotificationsAsReadCmd.toString();
    int actualCmdId = actualMarkNotificationsAsReadCmd.getCmdId();
    List<UUID> actualNotifications = actualMarkNotificationsAsReadCmd.getNotifications();

    // Assert that nothing has changed
    assertEquals("MarkNotificationsAsReadCmd(cmdId=1, notifications=[])", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.MARK_NOTIFICATIONS_AS_READ, actualMarkNotificationsAsReadCmd.getType());
    assertTrue(actualNotifications.isEmpty());
    assertSame(notifications, actualNotifications);
  }
}
