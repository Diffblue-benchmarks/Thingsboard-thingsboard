package org.thingsboard.server.service.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChangePasswordRequestDiffblueTest {
  /**
   * Test {@link ChangePasswordRequest#equals(Object)}, and
   * {@link ChangePasswordRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ChangePasswordRequest#equals(Object)}
   *   <li>{@link ChangePasswordRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
    changePasswordRequest.setCurrentPassword("iloveyou");
    changePasswordRequest.setNewPassword("iloveyou");

    ChangePasswordRequest changePasswordRequest2 = new ChangePasswordRequest();
    changePasswordRequest2.setCurrentPassword("iloveyou");
    changePasswordRequest2.setNewPassword("iloveyou");

    // Act and Assert
    assertEquals(changePasswordRequest, changePasswordRequest2);
    int expectedHashCodeResult = changePasswordRequest.hashCode();
    assertEquals(expectedHashCodeResult, changePasswordRequest2.hashCode());
  }

  /**
   * Test {@link ChangePasswordRequest#equals(Object)}, and
   * {@link ChangePasswordRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ChangePasswordRequest#equals(Object)}
   *   <li>{@link ChangePasswordRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
    changePasswordRequest.setCurrentPassword(null);
    changePasswordRequest.setNewPassword("iloveyou");

    ChangePasswordRequest changePasswordRequest2 = new ChangePasswordRequest();
    changePasswordRequest2.setCurrentPassword(null);
    changePasswordRequest2.setNewPassword("iloveyou");

    // Act and Assert
    assertEquals(changePasswordRequest, changePasswordRequest2);
    int expectedHashCodeResult = changePasswordRequest.hashCode();
    assertEquals(expectedHashCodeResult, changePasswordRequest2.hashCode());
  }

  /**
   * Test {@link ChangePasswordRequest#equals(Object)}, and
   * {@link ChangePasswordRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ChangePasswordRequest#equals(Object)}
   *   <li>{@link ChangePasswordRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
    changePasswordRequest.setCurrentPassword("iloveyou");
    changePasswordRequest.setNewPassword(null);

    ChangePasswordRequest changePasswordRequest2 = new ChangePasswordRequest();
    changePasswordRequest2.setCurrentPassword("iloveyou");
    changePasswordRequest2.setNewPassword(null);

    // Act and Assert
    assertEquals(changePasswordRequest, changePasswordRequest2);
    int expectedHashCodeResult = changePasswordRequest.hashCode();
    assertEquals(expectedHashCodeResult, changePasswordRequest2.hashCode());
  }

  /**
   * Test {@link ChangePasswordRequest#equals(Object)}, and
   * {@link ChangePasswordRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ChangePasswordRequest#equals(Object)}
   *   <li>{@link ChangePasswordRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
    changePasswordRequest.setCurrentPassword("iloveyou");
    changePasswordRequest.setNewPassword("iloveyou");

    // Act and Assert
    assertEquals(changePasswordRequest, changePasswordRequest);
    int expectedHashCodeResult = changePasswordRequest.hashCode();
    assertEquals(expectedHashCodeResult, changePasswordRequest.hashCode());
  }

  /**
   * Test {@link ChangePasswordRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangePasswordRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
    changePasswordRequest.setCurrentPassword("Current Password");
    changePasswordRequest.setNewPassword("iloveyou");

    ChangePasswordRequest changePasswordRequest2 = new ChangePasswordRequest();
    changePasswordRequest2.setCurrentPassword("iloveyou");
    changePasswordRequest2.setNewPassword("iloveyou");

    // Act and Assert
    assertNotEquals(changePasswordRequest, changePasswordRequest2);
  }

  /**
   * Test {@link ChangePasswordRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangePasswordRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
    changePasswordRequest.setCurrentPassword(null);
    changePasswordRequest.setNewPassword("iloveyou");

    ChangePasswordRequest changePasswordRequest2 = new ChangePasswordRequest();
    changePasswordRequest2.setCurrentPassword("iloveyou");
    changePasswordRequest2.setNewPassword("iloveyou");

    // Act and Assert
    assertNotEquals(changePasswordRequest, changePasswordRequest2);
  }

  /**
   * Test {@link ChangePasswordRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangePasswordRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
    changePasswordRequest.setCurrentPassword("iloveyou");
    changePasswordRequest.setNewPassword("New Password");

    ChangePasswordRequest changePasswordRequest2 = new ChangePasswordRequest();
    changePasswordRequest2.setCurrentPassword("iloveyou");
    changePasswordRequest2.setNewPassword("iloveyou");

    // Act and Assert
    assertNotEquals(changePasswordRequest, changePasswordRequest2);
  }

  /**
   * Test {@link ChangePasswordRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangePasswordRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
    changePasswordRequest.setCurrentPassword("iloveyou");
    changePasswordRequest.setNewPassword(null);

    ChangePasswordRequest changePasswordRequest2 = new ChangePasswordRequest();
    changePasswordRequest2.setCurrentPassword("iloveyou");
    changePasswordRequest2.setNewPassword("iloveyou");

    // Act and Assert
    assertNotEquals(changePasswordRequest, changePasswordRequest2);
  }

  /**
   * Test {@link ChangePasswordRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangePasswordRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
    changePasswordRequest.setCurrentPassword("iloveyou");
    changePasswordRequest.setNewPassword("iloveyou");

    // Act and Assert
    assertNotEquals(changePasswordRequest, null);
  }

  /**
   * Test {@link ChangePasswordRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangePasswordRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
    changePasswordRequest.setCurrentPassword("iloveyou");
    changePasswordRequest.setNewPassword("iloveyou");

    // Act and Assert
    assertNotEquals(changePasswordRequest, "Different type to ChangePasswordRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ChangePasswordRequest}
   *   <li>{@link ChangePasswordRequest#setCurrentPassword(String)}
   *   <li>{@link ChangePasswordRequest#setNewPassword(String)}
   *   <li>{@link ChangePasswordRequest#toString()}
   *   <li>{@link ChangePasswordRequest#getCurrentPassword()}
   *   <li>{@link ChangePasswordRequest#getNewPassword()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    ChangePasswordRequest actualChangePasswordRequest = new ChangePasswordRequest();
    actualChangePasswordRequest.setCurrentPassword("iloveyou");
    actualChangePasswordRequest.setNewPassword("iloveyou");
    String actualToStringResult = actualChangePasswordRequest.toString();
    String actualCurrentPassword = actualChangePasswordRequest.getCurrentPassword();

    // Assert that nothing has changed
    assertEquals("ChangePasswordRequest(currentPassword=iloveyou, newPassword=iloveyou)", actualToStringResult);
    assertEquals("iloveyou", actualCurrentPassword);
    assertEquals("iloveyou", actualChangePasswordRequest.getNewPassword());
  }
}
