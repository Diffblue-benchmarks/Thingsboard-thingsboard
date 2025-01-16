package org.thingsboard.server.service.ws;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AuthCmdDiffblueTest {
  /**
   * Test {@link AuthCmd#equals(Object)}, and {@link AuthCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AuthCmd#equals(Object)}
   *   <li>{@link AuthCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AuthCmd authCmd = new AuthCmd(1, "ABC123");
    AuthCmd authCmd2 = new AuthCmd(1, "ABC123");

    // Act and Assert
    assertEquals(authCmd, authCmd2);
    int expectedHashCodeResult = authCmd.hashCode();
    assertEquals(expectedHashCodeResult, authCmd2.hashCode());
  }

  /**
   * Test {@link AuthCmd#equals(Object)}, and {@link AuthCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AuthCmd#equals(Object)}
   *   <li>{@link AuthCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AuthCmd authCmd = new AuthCmd(1, null);
    AuthCmd authCmd2 = new AuthCmd(1, null);

    // Act and Assert
    assertEquals(authCmd, authCmd2);
    int expectedHashCodeResult = authCmd.hashCode();
    assertEquals(expectedHashCodeResult, authCmd2.hashCode());
  }

  /**
   * Test {@link AuthCmd#equals(Object)}, and {@link AuthCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AuthCmd#equals(Object)}
   *   <li>{@link AuthCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AuthCmd authCmd = new AuthCmd(1, "ABC123");

    // Act and Assert
    assertEquals(authCmd, authCmd);
    int expectedHashCodeResult = authCmd.hashCode();
    assertEquals(expectedHashCodeResult, authCmd.hashCode());
  }

  /**
   * Test {@link AuthCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AuthCmd authCmd = new AuthCmd(2, "ABC123");

    // Act and Assert
    assertNotEquals(authCmd, new AuthCmd(1, "ABC123"));
  }

  /**
   * Test {@link AuthCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AuthCmd authCmd = new AuthCmd(1, "Token");

    // Act and Assert
    assertNotEquals(authCmd, new AuthCmd(1, "ABC123"));
  }

  /**
   * Test {@link AuthCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AuthCmd authCmd = new AuthCmd(1, null);

    // Act and Assert
    assertNotEquals(authCmd, new AuthCmd(1, "ABC123"));
  }

  /**
   * Test {@link AuthCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AuthCmd(1, "ABC123"), null);
  }

  /**
   * Test {@link AuthCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AuthCmd(1, "ABC123"), "Different type to AuthCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AuthCmd#AuthCmd()}
   *   <li>{@link AuthCmd#setCmdId(int)}
   *   <li>{@link AuthCmd#setToken(String)}
   *   <li>{@link AuthCmd#toString()}
   *   <li>{@link AuthCmd#getCmdId()}
   *   <li>{@link AuthCmd#getToken()}
   *   <li>{@link AuthCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AuthCmd actualAuthCmd = new AuthCmd();
    actualAuthCmd.setCmdId(1);
    actualAuthCmd.setToken("ABC123");
    String actualToStringResult = actualAuthCmd.toString();
    int actualCmdId = actualAuthCmd.getCmdId();
    String actualToken = actualAuthCmd.getToken();

    // Assert that nothing has changed
    assertEquals("ABC123", actualToken);
    assertEquals("AuthCmd(cmdId=1, token=ABC123)", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.AUTH, actualAuthCmd.getType());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AuthCmd#AuthCmd(int, String)}
   *   <li>{@link AuthCmd#setCmdId(int)}
   *   <li>{@link AuthCmd#setToken(String)}
   *   <li>{@link AuthCmd#toString()}
   *   <li>{@link AuthCmd#getCmdId()}
   *   <li>{@link AuthCmd#getToken()}
   *   <li>{@link AuthCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    AuthCmd actualAuthCmd = new AuthCmd(1, "ABC123");
    actualAuthCmd.setCmdId(1);
    actualAuthCmd.setToken("ABC123");
    String actualToStringResult = actualAuthCmd.toString();
    int actualCmdId = actualAuthCmd.getCmdId();
    String actualToken = actualAuthCmd.getToken();

    // Assert that nothing has changed
    assertEquals("ABC123", actualToken);
    assertEquals("AuthCmd(cmdId=1, token=ABC123)", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.AUTH, actualAuthCmd.getType());
  }
}
