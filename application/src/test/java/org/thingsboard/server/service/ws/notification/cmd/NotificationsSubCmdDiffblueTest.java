package org.thingsboard.server.service.ws.notification.cmd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.service.ws.WsCmdType;

class NotificationsSubCmdDiffblueTest {
  /**
   * Test {@link NotificationsSubCmd#equals(Object)}, and
   * {@link NotificationsSubCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsSubCmd#equals(Object)}
   *   <li>{@link NotificationsSubCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationsSubCmd notificationsSubCmd = new NotificationsSubCmd();
    NotificationsSubCmd notificationsSubCmd2 = new NotificationsSubCmd();

    // Act and Assert
    assertEquals(notificationsSubCmd, notificationsSubCmd2);
    int expectedHashCodeResult = notificationsSubCmd.hashCode();
    assertEquals(expectedHashCodeResult, notificationsSubCmd2.hashCode());
  }

  /**
   * Test {@link NotificationsSubCmd#equals(Object)}, and
   * {@link NotificationsSubCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsSubCmd#equals(Object)}
   *   <li>{@link NotificationsSubCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationsSubCmd notificationsSubCmd = new NotificationsSubCmd(1, 1, new HashSet<>());
    NotificationsSubCmd notificationsSubCmd2 = new NotificationsSubCmd(1, 1, new HashSet<>());

    // Act and Assert
    assertEquals(notificationsSubCmd, notificationsSubCmd2);
    int expectedHashCodeResult = notificationsSubCmd.hashCode();
    assertEquals(expectedHashCodeResult, notificationsSubCmd2.hashCode());
  }

  /**
   * Test {@link NotificationsSubCmd#equals(Object)}, and
   * {@link NotificationsSubCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsSubCmd#equals(Object)}
   *   <li>{@link NotificationsSubCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationsSubCmd notificationsSubCmd = new NotificationsSubCmd();

    // Act and Assert
    assertEquals(notificationsSubCmd, notificationsSubCmd);
    int expectedHashCodeResult = notificationsSubCmd.hashCode();
    assertEquals(expectedHashCodeResult, notificationsSubCmd.hashCode());
  }

  /**
   * Test {@link NotificationsSubCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationsSubCmd notificationsSubCmd = new NotificationsSubCmd(1, 1, new HashSet<>());

    // Act and Assert
    assertNotEquals(notificationsSubCmd, new NotificationsSubCmd());
  }

  /**
   * Test {@link NotificationsSubCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationsSubCmd notificationsSubCmd = new NotificationsSubCmd();
    notificationsSubCmd.setLimit(1);

    // Act and Assert
    assertNotEquals(notificationsSubCmd, new NotificationsSubCmd());
  }

  /**
   * Test {@link NotificationsSubCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationsSubCmd notificationsSubCmd = new NotificationsSubCmd();
    notificationsSubCmd.setTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(notificationsSubCmd, new NotificationsSubCmd());
  }

  /**
   * Test {@link NotificationsSubCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationsSubCmd notificationsSubCmd = new NotificationsSubCmd();

    NotificationsSubCmd notificationsSubCmd2 = new NotificationsSubCmd();
    notificationsSubCmd2.setTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(notificationsSubCmd, notificationsSubCmd2);
  }

  /**
   * Test {@link NotificationsSubCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationsSubCmd(), null);
  }

  /**
   * Test {@link NotificationsSubCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsSubCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationsSubCmd(), "Different type to NotificationsSubCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsSubCmd#NotificationsSubCmd()}
   *   <li>{@link NotificationsSubCmd#setCmdId(int)}
   *   <li>{@link NotificationsSubCmd#setLimit(int)}
   *   <li>{@link NotificationsSubCmd#setTypes(Set)}
   *   <li>{@link NotificationsSubCmd#toString()}
   *   <li>{@link NotificationsSubCmd#getCmdId()}
   *   <li>{@link NotificationsSubCmd#getLimit()}
   *   <li>{@link NotificationsSubCmd#getType()}
   *   <li>{@link NotificationsSubCmd#getTypes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationsSubCmd actualNotificationsSubCmd = new NotificationsSubCmd();
    actualNotificationsSubCmd.setCmdId(1);
    actualNotificationsSubCmd.setLimit(1);
    HashSet<NotificationType> types = new HashSet<>();
    actualNotificationsSubCmd.setTypes(types);
    String actualToStringResult = actualNotificationsSubCmd.toString();
    int actualCmdId = actualNotificationsSubCmd.getCmdId();
    int actualLimit = actualNotificationsSubCmd.getLimit();
    WsCmdType actualType = actualNotificationsSubCmd.getType();
    Set<NotificationType> actualTypes = actualNotificationsSubCmd.getTypes();

    // Assert that nothing has changed
    assertEquals("NotificationsSubCmd(cmdId=1, limit=1, types=[])", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(1, actualLimit);
    assertEquals(WsCmdType.NOTIFICATIONS, actualType);
    assertTrue(actualTypes.isEmpty());
    assertSame(types, actualTypes);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationsSubCmd#NotificationsSubCmd(int, int, Set)}
   *   <li>{@link NotificationsSubCmd#setCmdId(int)}
   *   <li>{@link NotificationsSubCmd#setLimit(int)}
   *   <li>{@link NotificationsSubCmd#setTypes(Set)}
   *   <li>{@link NotificationsSubCmd#toString()}
   *   <li>{@link NotificationsSubCmd#getCmdId()}
   *   <li>{@link NotificationsSubCmd#getLimit()}
   *   <li>{@link NotificationsSubCmd#getType()}
   *   <li>{@link NotificationsSubCmd#getTypes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    NotificationsSubCmd actualNotificationsSubCmd = new NotificationsSubCmd(1, 1, new HashSet<>());
    actualNotificationsSubCmd.setCmdId(1);
    actualNotificationsSubCmd.setLimit(1);
    HashSet<NotificationType> types = new HashSet<>();
    actualNotificationsSubCmd.setTypes(types);
    String actualToStringResult = actualNotificationsSubCmd.toString();
    int actualCmdId = actualNotificationsSubCmd.getCmdId();
    int actualLimit = actualNotificationsSubCmd.getLimit();
    WsCmdType actualType = actualNotificationsSubCmd.getType();
    Set<NotificationType> actualTypes = actualNotificationsSubCmd.getTypes();

    // Assert that nothing has changed
    assertEquals("NotificationsSubCmd(cmdId=1, limit=1, types=[])", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(1, actualLimit);
    assertEquals(WsCmdType.NOTIFICATIONS, actualType);
    assertTrue(actualTypes.isEmpty());
    assertSame(types, actualTypes);
  }
}
