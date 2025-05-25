package org.thingsboard.server.service.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResetPasswordEmailRequestDiffblueTest {
  /**
   * Test {@link ResetPasswordEmailRequest#equals(Object)}, and {@link ResetPasswordEmailRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResetPasswordEmailRequest#equals(Object)}
   *   <li>{@link ResetPasswordEmailRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordEmailRequest.equals(Object)", "int ResetPasswordEmailRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResetPasswordEmailRequest resetPasswordEmailRequest = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest.setEmail("jane.doe@example.org");

    ResetPasswordEmailRequest resetPasswordEmailRequest2 = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest2.setEmail("jane.doe@example.org");

    // Act and Assert
    assertEquals(resetPasswordEmailRequest, resetPasswordEmailRequest2);
    int expectedHashCodeResult = resetPasswordEmailRequest.hashCode();
    assertEquals(expectedHashCodeResult, resetPasswordEmailRequest2.hashCode());
  }

  /**
   * Test {@link ResetPasswordEmailRequest#equals(Object)}, and {@link ResetPasswordEmailRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResetPasswordEmailRequest#equals(Object)}
   *   <li>{@link ResetPasswordEmailRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordEmailRequest.equals(Object)", "int ResetPasswordEmailRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ResetPasswordEmailRequest resetPasswordEmailRequest = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest.setEmail(null);

    ResetPasswordEmailRequest resetPasswordEmailRequest2 = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest2.setEmail(null);

    // Act and Assert
    assertEquals(resetPasswordEmailRequest, resetPasswordEmailRequest2);
    int expectedHashCodeResult = resetPasswordEmailRequest.hashCode();
    assertEquals(expectedHashCodeResult, resetPasswordEmailRequest2.hashCode());
  }

  /**
   * Test {@link ResetPasswordEmailRequest#equals(Object)}, and {@link ResetPasswordEmailRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResetPasswordEmailRequest#equals(Object)}
   *   <li>{@link ResetPasswordEmailRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordEmailRequest.equals(Object)", "int ResetPasswordEmailRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ResetPasswordEmailRequest resetPasswordEmailRequest = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest.setEmail("jane.doe@example.org");

    // Act and Assert
    assertEquals(resetPasswordEmailRequest, resetPasswordEmailRequest);
    int expectedHashCodeResult = resetPasswordEmailRequest.hashCode();
    assertEquals(expectedHashCodeResult, resetPasswordEmailRequest.hashCode());
  }

  /**
   * Test {@link ResetPasswordEmailRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResetPasswordEmailRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordEmailRequest.equals(Object)", "int ResetPasswordEmailRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ResetPasswordEmailRequest resetPasswordEmailRequest = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest.setEmail("john.smith@example.org");

    ResetPasswordEmailRequest resetPasswordEmailRequest2 = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest2.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(resetPasswordEmailRequest, resetPasswordEmailRequest2);
  }

  /**
   * Test {@link ResetPasswordEmailRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResetPasswordEmailRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordEmailRequest.equals(Object)", "int ResetPasswordEmailRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ResetPasswordEmailRequest resetPasswordEmailRequest = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest.setEmail(null);

    ResetPasswordEmailRequest resetPasswordEmailRequest2 = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest2.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(resetPasswordEmailRequest, resetPasswordEmailRequest2);
  }

  /**
   * Test {@link ResetPasswordEmailRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResetPasswordEmailRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordEmailRequest.equals(Object)", "int ResetPasswordEmailRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ResetPasswordEmailRequest resetPasswordEmailRequest = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(resetPasswordEmailRequest, null);
  }

  /**
   * Test {@link ResetPasswordEmailRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResetPasswordEmailRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResetPasswordEmailRequest.equals(Object)", "int ResetPasswordEmailRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ResetPasswordEmailRequest resetPasswordEmailRequest = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(resetPasswordEmailRequest, "Different type to ResetPasswordEmailRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ResetPasswordEmailRequest}
   *   <li>{@link ResetPasswordEmailRequest#setEmail(String)}
   *   <li>{@link ResetPasswordEmailRequest#toString()}
   *   <li>{@link ResetPasswordEmailRequest#getEmail()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResetPasswordEmailRequest.<init>()", "String ResetPasswordEmailRequest.getEmail()",
      "void ResetPasswordEmailRequest.setEmail(String)", "String ResetPasswordEmailRequest.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ResetPasswordEmailRequest actualResetPasswordEmailRequest = new ResetPasswordEmailRequest();
    actualResetPasswordEmailRequest.setEmail("jane.doe@example.org");
    String actualToStringResult = actualResetPasswordEmailRequest.toString();

    // Assert
    assertEquals("ResetPasswordEmailRequest(email=jane.doe@example.org)", actualToStringResult);
    assertEquals("jane.doe@example.org", actualResetPasswordEmailRequest.getEmail());
  }
}
