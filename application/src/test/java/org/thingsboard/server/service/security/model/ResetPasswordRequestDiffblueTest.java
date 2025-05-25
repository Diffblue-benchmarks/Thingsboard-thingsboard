package org.thingsboard.server.service.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResetPasswordRequestDiffblueTest {
  /**
   * Test {@link ResetPasswordRequest#equals(Object)}, and {@link ResetPasswordRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResetPasswordRequest#equals(Object)}
   *   <li>{@link ResetPasswordRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordRequest.equals(Object)", "int ResetPasswordRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
    resetPasswordRequest.setPassword("iloveyou");
    resetPasswordRequest.setResetToken("ABC123");

    ResetPasswordRequest resetPasswordRequest2 = new ResetPasswordRequest();
    resetPasswordRequest2.setPassword("iloveyou");
    resetPasswordRequest2.setResetToken("ABC123");

    // Act and Assert
    assertEquals(resetPasswordRequest, resetPasswordRequest2);
    int expectedHashCodeResult = resetPasswordRequest.hashCode();
    assertEquals(expectedHashCodeResult, resetPasswordRequest2.hashCode());
  }

  /**
   * Test {@link ResetPasswordRequest#equals(Object)}, and {@link ResetPasswordRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResetPasswordRequest#equals(Object)}
   *   <li>{@link ResetPasswordRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordRequest.equals(Object)", "int ResetPasswordRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
    resetPasswordRequest.setPassword(null);
    resetPasswordRequest.setResetToken("ABC123");

    ResetPasswordRequest resetPasswordRequest2 = new ResetPasswordRequest();
    resetPasswordRequest2.setPassword(null);
    resetPasswordRequest2.setResetToken("ABC123");

    // Act and Assert
    assertEquals(resetPasswordRequest, resetPasswordRequest2);
    int expectedHashCodeResult = resetPasswordRequest.hashCode();
    assertEquals(expectedHashCodeResult, resetPasswordRequest2.hashCode());
  }

  /**
   * Test {@link ResetPasswordRequest#equals(Object)}, and {@link ResetPasswordRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResetPasswordRequest#equals(Object)}
   *   <li>{@link ResetPasswordRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordRequest.equals(Object)", "int ResetPasswordRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
    resetPasswordRequest.setPassword("iloveyou");
    resetPasswordRequest.setResetToken(null);

    ResetPasswordRequest resetPasswordRequest2 = new ResetPasswordRequest();
    resetPasswordRequest2.setPassword("iloveyou");
    resetPasswordRequest2.setResetToken(null);

    // Act and Assert
    assertEquals(resetPasswordRequest, resetPasswordRequest2);
    int expectedHashCodeResult = resetPasswordRequest.hashCode();
    assertEquals(expectedHashCodeResult, resetPasswordRequest2.hashCode());
  }

  /**
   * Test {@link ResetPasswordRequest#equals(Object)}, and {@link ResetPasswordRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResetPasswordRequest#equals(Object)}
   *   <li>{@link ResetPasswordRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordRequest.equals(Object)", "int ResetPasswordRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
    resetPasswordRequest.setPassword("iloveyou");
    resetPasswordRequest.setResetToken("ABC123");

    // Act and Assert
    assertEquals(resetPasswordRequest, resetPasswordRequest);
    int expectedHashCodeResult = resetPasswordRequest.hashCode();
    assertEquals(expectedHashCodeResult, resetPasswordRequest.hashCode());
  }

  /**
   * Test {@link ResetPasswordRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResetPasswordRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordRequest.equals(Object)", "int ResetPasswordRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
    resetPasswordRequest.setPassword("ABC123");
    resetPasswordRequest.setResetToken("ABC123");

    ResetPasswordRequest resetPasswordRequest2 = new ResetPasswordRequest();
    resetPasswordRequest2.setPassword("iloveyou");
    resetPasswordRequest2.setResetToken("ABC123");

    // Act and Assert
    assertNotEquals(resetPasswordRequest, resetPasswordRequest2);
  }

  /**
   * Test {@link ResetPasswordRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResetPasswordRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordRequest.equals(Object)", "int ResetPasswordRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
    resetPasswordRequest.setPassword(null);
    resetPasswordRequest.setResetToken("ABC123");

    ResetPasswordRequest resetPasswordRequest2 = new ResetPasswordRequest();
    resetPasswordRequest2.setPassword("iloveyou");
    resetPasswordRequest2.setResetToken("ABC123");

    // Act and Assert
    assertNotEquals(resetPasswordRequest, resetPasswordRequest2);
  }

  /**
   * Test {@link ResetPasswordRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResetPasswordRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordRequest.equals(Object)", "int ResetPasswordRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
    resetPasswordRequest.setPassword("iloveyou");
    resetPasswordRequest.setResetToken("iloveyou");

    ResetPasswordRequest resetPasswordRequest2 = new ResetPasswordRequest();
    resetPasswordRequest2.setPassword("iloveyou");
    resetPasswordRequest2.setResetToken("ABC123");

    // Act and Assert
    assertNotEquals(resetPasswordRequest, resetPasswordRequest2);
  }

  /**
   * Test {@link ResetPasswordRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResetPasswordRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordRequest.equals(Object)", "int ResetPasswordRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
    resetPasswordRequest.setPassword("iloveyou");
    resetPasswordRequest.setResetToken(null);

    ResetPasswordRequest resetPasswordRequest2 = new ResetPasswordRequest();
    resetPasswordRequest2.setPassword("iloveyou");
    resetPasswordRequest2.setResetToken("ABC123");

    // Act and Assert
    assertNotEquals(resetPasswordRequest, resetPasswordRequest2);
  }

  /**
   * Test {@link ResetPasswordRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResetPasswordRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordRequest.equals(Object)", "int ResetPasswordRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
    resetPasswordRequest.setPassword("iloveyou");
    resetPasswordRequest.setResetToken("ABC123");

    // Act and Assert
    assertNotEquals(resetPasswordRequest, null);
  }

  /**
   * Test {@link ResetPasswordRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResetPasswordRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordRequest.equals(Object)", "int ResetPasswordRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
    resetPasswordRequest.setPassword("iloveyou");
    resetPasswordRequest.setResetToken("ABC123");

    // Act and Assert
    assertNotEquals(resetPasswordRequest, "Different type to ResetPasswordRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ResetPasswordRequest}
   *   <li>{@link ResetPasswordRequest#setPassword(String)}
   *   <li>{@link ResetPasswordRequest#setResetToken(String)}
   *   <li>{@link ResetPasswordRequest#toString()}
   *   <li>{@link ResetPasswordRequest#getPassword()}
   *   <li>{@link ResetPasswordRequest#getResetToken()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResetPasswordRequest.<init>()", "String ResetPasswordRequest.getPassword()",
      "String ResetPasswordRequest.getResetToken()", "void ResetPasswordRequest.setPassword(String)",
      "void ResetPasswordRequest.setResetToken(String)", "String ResetPasswordRequest.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ResetPasswordRequest actualResetPasswordRequest = new ResetPasswordRequest();
    actualResetPasswordRequest.setPassword("iloveyou");
    actualResetPasswordRequest.setResetToken("ABC123");
    String actualToStringResult = actualResetPasswordRequest.toString();
    String actualPassword = actualResetPasswordRequest.getPassword();

    // Assert
    assertEquals("ABC123", actualResetPasswordRequest.getResetToken());
    assertEquals("ResetPasswordRequest(resetToken=ABC123, password=iloveyou)", actualToStringResult);
    assertEquals("iloveyou", actualPassword);
  }
}
