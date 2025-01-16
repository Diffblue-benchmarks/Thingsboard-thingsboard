package org.thingsboard.server.service.ws.notification.cmd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.service.ws.WsCommandsWrapper;

@ContextConfiguration(classes = {NotificationCmdsWrapper.class})
@ExtendWith(SpringExtension.class)
class NotificationCmdsWrapperDiffblueTest {
  @Autowired
  private NotificationCmdsWrapper notificationCmdsWrapper;

  /**
   * Test {@link NotificationCmdsWrapper#toCommonCmdsWrapper()}.
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#toCommonCmdsWrapper()}
   */
  @Test
  @DisplayName("Test toCommonCmdsWrapper()")
  void testToCommonCmdsWrapper() {
    // Arrange and Act
    WsCommandsWrapper actualToCommonCmdsWrapperResult = notificationCmdsWrapper.toCommonCmdsWrapper();

    // Assert
    assertNull(actualToCommonCmdsWrapperResult.getAuthCmd());
    assertTrue(actualToCommonCmdsWrapperResult.getCmds().isEmpty());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}, and
   * {@link NotificationCmdsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationCmdsWrapper#equals(Object)}
   *   <li>{@link NotificationCmdsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();
    NotificationCmdsWrapper notificationCmdsWrapper2 = new NotificationCmdsWrapper();

    // Act and Assert
    assertEquals(notificationCmdsWrapper, notificationCmdsWrapper2);
    int expectedHashCodeResult = notificationCmdsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, notificationCmdsWrapper2.hashCode());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}, and
   * {@link NotificationCmdsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationCmdsWrapper#equals(Object)}
   *   <li>{@link NotificationCmdsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();
    notificationCmdsWrapper.setUnreadCountSubCmd(new NotificationsCountSubCmd(1));

    NotificationCmdsWrapper notificationCmdsWrapper2 = new NotificationCmdsWrapper();
    notificationCmdsWrapper2.setUnreadCountSubCmd(new NotificationsCountSubCmd(1));

    // Act and Assert
    assertEquals(notificationCmdsWrapper, notificationCmdsWrapper2);
    int expectedHashCodeResult = notificationCmdsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, notificationCmdsWrapper2.hashCode());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}, and
   * {@link NotificationCmdsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationCmdsWrapper#equals(Object)}
   *   <li>{@link NotificationCmdsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();
    notificationCmdsWrapper.setUnreadSubCmd(new NotificationsSubCmd());

    NotificationCmdsWrapper notificationCmdsWrapper2 = new NotificationCmdsWrapper();
    notificationCmdsWrapper2.setUnreadSubCmd(new NotificationsSubCmd());

    // Act and Assert
    assertEquals(notificationCmdsWrapper, notificationCmdsWrapper2);
    int expectedHashCodeResult = notificationCmdsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, notificationCmdsWrapper2.hashCode());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}, and
   * {@link NotificationCmdsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationCmdsWrapper#equals(Object)}
   *   <li>{@link NotificationCmdsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();
    notificationCmdsWrapper.setMarkAsReadCmd(new MarkNotificationsAsReadCmd());

    NotificationCmdsWrapper notificationCmdsWrapper2 = new NotificationCmdsWrapper();
    notificationCmdsWrapper2.setMarkAsReadCmd(new MarkNotificationsAsReadCmd());

    // Act and Assert
    assertEquals(notificationCmdsWrapper, notificationCmdsWrapper2);
    int expectedHashCodeResult = notificationCmdsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, notificationCmdsWrapper2.hashCode());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}, and
   * {@link NotificationCmdsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationCmdsWrapper#equals(Object)}
   *   <li>{@link NotificationCmdsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();
    notificationCmdsWrapper.setMarkAllAsReadCmd(new MarkAllNotificationsAsReadCmd(1));

    NotificationCmdsWrapper notificationCmdsWrapper2 = new NotificationCmdsWrapper();
    notificationCmdsWrapper2.setMarkAllAsReadCmd(new MarkAllNotificationsAsReadCmd(1));

    // Act and Assert
    assertEquals(notificationCmdsWrapper, notificationCmdsWrapper2);
    int expectedHashCodeResult = notificationCmdsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, notificationCmdsWrapper2.hashCode());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}, and
   * {@link NotificationCmdsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationCmdsWrapper#equals(Object)}
   *   <li>{@link NotificationCmdsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();
    notificationCmdsWrapper.setUnsubCmd(new NotificationsUnsubCmd(1));

    NotificationCmdsWrapper notificationCmdsWrapper2 = new NotificationCmdsWrapper();
    notificationCmdsWrapper2.setUnsubCmd(new NotificationsUnsubCmd(1));

    // Act and Assert
    assertEquals(notificationCmdsWrapper, notificationCmdsWrapper2);
    int expectedHashCodeResult = notificationCmdsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, notificationCmdsWrapper2.hashCode());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}, and
   * {@link NotificationCmdsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationCmdsWrapper#equals(Object)}
   *   <li>{@link NotificationCmdsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();

    // Act and Assert
    assertEquals(notificationCmdsWrapper, notificationCmdsWrapper);
    int expectedHashCodeResult = notificationCmdsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, notificationCmdsWrapper.hashCode());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationCmdsWrapper(), 1);
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();
    notificationCmdsWrapper.setUnreadCountSubCmd(new NotificationsCountSubCmd(1));

    // Act and Assert
    assertNotEquals(notificationCmdsWrapper, new NotificationCmdsWrapper());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();
    notificationCmdsWrapper.setUnreadSubCmd(new NotificationsSubCmd());

    // Act and Assert
    assertNotEquals(notificationCmdsWrapper, new NotificationCmdsWrapper());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();
    notificationCmdsWrapper.setMarkAsReadCmd(new MarkNotificationsAsReadCmd());

    // Act and Assert
    assertNotEquals(notificationCmdsWrapper, new NotificationCmdsWrapper());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();
    notificationCmdsWrapper.setMarkAllAsReadCmd(new MarkAllNotificationsAsReadCmd(1));

    // Act and Assert
    assertNotEquals(notificationCmdsWrapper, new NotificationCmdsWrapper());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();
    notificationCmdsWrapper.setUnsubCmd(new NotificationsUnsubCmd(1));

    // Act and Assert
    assertNotEquals(notificationCmdsWrapper, new NotificationCmdsWrapper());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();

    NotificationCmdsWrapper notificationCmdsWrapper2 = new NotificationCmdsWrapper();
    notificationCmdsWrapper2.setUnreadCountSubCmd(new NotificationsCountSubCmd(1));

    // Act and Assert
    assertNotEquals(notificationCmdsWrapper, notificationCmdsWrapper2);
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();

    NotificationCmdsWrapper notificationCmdsWrapper2 = new NotificationCmdsWrapper();
    notificationCmdsWrapper2.setUnreadSubCmd(new NotificationsSubCmd());

    // Act and Assert
    assertNotEquals(notificationCmdsWrapper, notificationCmdsWrapper2);
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();

    NotificationCmdsWrapper notificationCmdsWrapper2 = new NotificationCmdsWrapper();
    notificationCmdsWrapper2.setMarkAsReadCmd(new MarkNotificationsAsReadCmd());

    // Act and Assert
    assertNotEquals(notificationCmdsWrapper, notificationCmdsWrapper2);
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();

    NotificationCmdsWrapper notificationCmdsWrapper2 = new NotificationCmdsWrapper();
    notificationCmdsWrapper2.setMarkAllAsReadCmd(new MarkAllNotificationsAsReadCmd(1));

    // Act and Assert
    assertNotEquals(notificationCmdsWrapper, notificationCmdsWrapper2);
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();

    NotificationCmdsWrapper notificationCmdsWrapper2 = new NotificationCmdsWrapper();
    notificationCmdsWrapper2.setUnsubCmd(new NotificationsUnsubCmd(1));

    // Act and Assert
    assertNotEquals(notificationCmdsWrapper, notificationCmdsWrapper2);
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationCmdsWrapper notificationCmdsWrapper = new NotificationCmdsWrapper();
    notificationCmdsWrapper.setUnreadCountSubCmd(mock(NotificationsCountSubCmd.class));

    // Act and Assert
    assertNotEquals(notificationCmdsWrapper, new NotificationCmdsWrapper());
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationCmdsWrapper(), null);
  }

  /**
   * Test {@link NotificationCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationCmdsWrapper(), "Different type to NotificationCmdsWrapper");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NotificationCmdsWrapper}
   *   <li>
   * {@link NotificationCmdsWrapper#setMarkAllAsReadCmd(MarkAllNotificationsAsReadCmd)}
   *   <li>
   * {@link NotificationCmdsWrapper#setMarkAsReadCmd(MarkNotificationsAsReadCmd)}
   *   <li>
   * {@link NotificationCmdsWrapper#setUnreadCountSubCmd(NotificationsCountSubCmd)}
   *   <li>{@link NotificationCmdsWrapper#setUnreadSubCmd(NotificationsSubCmd)}
   *   <li>{@link NotificationCmdsWrapper#setUnsubCmd(NotificationsUnsubCmd)}
   *   <li>{@link NotificationCmdsWrapper#toString()}
   *   <li>{@link NotificationCmdsWrapper#getMarkAllAsReadCmd()}
   *   <li>{@link NotificationCmdsWrapper#getMarkAsReadCmd()}
   *   <li>{@link NotificationCmdsWrapper#getUnreadCountSubCmd()}
   *   <li>{@link NotificationCmdsWrapper#getUnreadSubCmd()}
   *   <li>{@link NotificationCmdsWrapper#getUnsubCmd()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationCmdsWrapper actualNotificationCmdsWrapper = new NotificationCmdsWrapper();
    MarkAllNotificationsAsReadCmd markAllAsReadCmd = new MarkAllNotificationsAsReadCmd(1);
    actualNotificationCmdsWrapper.setMarkAllAsReadCmd(markAllAsReadCmd);
    MarkNotificationsAsReadCmd markAsReadCmd = new MarkNotificationsAsReadCmd();
    actualNotificationCmdsWrapper.setMarkAsReadCmd(markAsReadCmd);
    NotificationsCountSubCmd unreadCountSubCmd = new NotificationsCountSubCmd(1);
    actualNotificationCmdsWrapper.setUnreadCountSubCmd(unreadCountSubCmd);
    NotificationsSubCmd unreadSubCmd = new NotificationsSubCmd();
    actualNotificationCmdsWrapper.setUnreadSubCmd(unreadSubCmd);
    NotificationsUnsubCmd unsubCmd = new NotificationsUnsubCmd(1);
    actualNotificationCmdsWrapper.setUnsubCmd(unsubCmd);
    String actualToStringResult = actualNotificationCmdsWrapper.toString();
    MarkAllNotificationsAsReadCmd actualMarkAllAsReadCmd = actualNotificationCmdsWrapper.getMarkAllAsReadCmd();
    MarkNotificationsAsReadCmd actualMarkAsReadCmd = actualNotificationCmdsWrapper.getMarkAsReadCmd();
    NotificationsCountSubCmd actualUnreadCountSubCmd = actualNotificationCmdsWrapper.getUnreadCountSubCmd();
    NotificationsSubCmd actualUnreadSubCmd = actualNotificationCmdsWrapper.getUnreadSubCmd();

    // Assert that nothing has changed
    assertEquals("NotificationCmdsWrapper(unreadCountSubCmd=NotificationsCountSubCmd(cmdId=1), unreadSubCmd=Notificat"
        + "ionsSubCmd(cmdId=0, limit=0, types=null), markAsReadCmd=MarkNotificationsAsReadCmd(cmdId=0,"
        + " notifications=null), markAllAsReadCmd=MarkAllNotificationsAsReadCmd(cmdId=1), unsubCmd=Notificatio"
        + "nsUnsubCmd(cmdId=1))", actualToStringResult);
    assertSame(markAllAsReadCmd, actualMarkAllAsReadCmd);
    assertSame(markAsReadCmd, actualMarkAsReadCmd);
    assertSame(unreadCountSubCmd, actualUnreadCountSubCmd);
    assertSame(unreadSubCmd, actualUnreadSubCmd);
    assertSame(unsubCmd, actualNotificationCmdsWrapper.getUnsubCmd());
  }
}
