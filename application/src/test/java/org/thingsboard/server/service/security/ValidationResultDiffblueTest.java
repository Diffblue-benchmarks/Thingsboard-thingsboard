package org.thingsboard.server.service.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidationResultDiffblueTest {
  /**
   * Test {@link ValidationResult#ok(Object)}.
   * <p>
   * Method under test: {@link ValidationResult#ok(Object)}
   */
  @Test
  @DisplayName("Test ok(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ValidationResult.ok(Object)"})
  void testOk() {
    // Arrange and Act
    ValidationResult<Object> actualOkResult = ValidationResult.ok("42");

    // Assert
    assertEquals("42", actualOkResult.getV());
    assertEquals("Ok", actualOkResult.getMessage());
    assertEquals(ValidationResultCode.OK, actualOkResult.getResultCode());
  }

  /**
   * Test {@link ValidationResult#accessDenied(String)}.
   * <p>
   * Method under test: {@link ValidationResult#accessDenied(String)}
   */
  @Test
  @DisplayName("Test accessDenied(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ValidationResult.accessDenied(String)"})
  void testAccessDenied() {
    // Arrange and Act
    ValidationResult<Object> actualAccessDeniedResult = ValidationResult.accessDenied("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualAccessDeniedResult.getMessage());
    assertNull(actualAccessDeniedResult.getV());
    assertEquals(ValidationResultCode.ACCESS_DENIED, actualAccessDeniedResult.getResultCode());
  }

  /**
   * Test {@link ValidationResult#entityNotFound(String)}.
   * <p>
   * Method under test: {@link ValidationResult#entityNotFound(String)}
   */
  @Test
  @DisplayName("Test entityNotFound(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ValidationResult.entityNotFound(String)"})
  void testEntityNotFound() {
    // Arrange and Act
    ValidationResult<Object> actualEntityNotFoundResult = ValidationResult
        .entityNotFound("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualEntityNotFoundResult.getMessage());
    assertNull(actualEntityNotFoundResult.getV());
    assertEquals(ValidationResultCode.ENTITY_NOT_FOUND, actualEntityNotFoundResult.getResultCode());
  }

  /**
   * Test {@link ValidationResult#unauthorized(String)}.
   * <p>
   * Method under test: {@link ValidationResult#unauthorized(String)}
   */
  @Test
  @DisplayName("Test unauthorized(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ValidationResult.unauthorized(String)"})
  void testUnauthorized() {
    // Arrange and Act
    ValidationResult<Object> actualUnauthorizedResult = ValidationResult.unauthorized("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualUnauthorizedResult.getMessage());
    assertNull(actualUnauthorizedResult.getV());
    assertEquals(ValidationResultCode.UNAUTHORIZED, actualUnauthorizedResult.getResultCode());
  }

  /**
   * Test {@link ValidationResult#internalError(String)}.
   * <p>
   * Method under test: {@link ValidationResult#internalError(String)}
   */
  @Test
  @DisplayName("Test internalError(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ValidationResult.internalError(String)"})
  void testInternalError() {
    // Arrange and Act
    ValidationResult<Object> actualInternalErrorResult = ValidationResult.internalError("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualInternalErrorResult.getMessage());
    assertNull(actualInternalErrorResult.getV());
    assertEquals(ValidationResultCode.INTERNAL_ERROR, actualInternalErrorResult.getResultCode());
  }

  /**
   * Test {@link ValidationResult#equals(Object)}, and {@link ValidationResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationResult#equals(Object)}
   *   <li>{@link ValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationResult.equals(Object)", "int ValidationResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ValidationResult<Object> accessDeniedResult = ValidationResult.accessDenied("Not all who wander are lost");
    ValidationResult<Object> accessDeniedResult2 = ValidationResult.accessDenied("Not all who wander are lost");

    // Act and Assert
    assertEquals(accessDeniedResult, accessDeniedResult2);
    int expectedHashCodeResult = accessDeniedResult.hashCode();
    assertEquals(expectedHashCodeResult, accessDeniedResult2.hashCode());
  }

  /**
   * Test {@link ValidationResult#equals(Object)}, and {@link ValidationResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationResult#equals(Object)}
   *   <li>{@link ValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationResult.equals(Object)", "int ValidationResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ValidationResult<Object> accessDeniedResult = ValidationResult.accessDenied(null);
    ValidationResult<Object> accessDeniedResult2 = ValidationResult.accessDenied(null);

    // Act and Assert
    assertEquals(accessDeniedResult, accessDeniedResult2);
    int expectedHashCodeResult = accessDeniedResult.hashCode();
    assertEquals(expectedHashCodeResult, accessDeniedResult2.hashCode());
  }

  /**
   * Test {@link ValidationResult#equals(Object)}, and {@link ValidationResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationResult#equals(Object)}
   *   <li>{@link ValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationResult.equals(Object)", "int ValidationResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ValidationResult<Object> accessDeniedResult = ValidationResult.accessDenied("Not all who wander are lost");

    // Act and Assert
    assertEquals(accessDeniedResult, accessDeniedResult);
    int expectedHashCodeResult = accessDeniedResult.hashCode();
    assertEquals(expectedHashCodeResult, accessDeniedResult.hashCode());
  }

  /**
   * Test {@link ValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationResult.equals(Object)", "int ValidationResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ValidationResult<Object> accessDeniedResult = ValidationResult.accessDenied("Message");
    ValidationResult<Object> accessDeniedResult2 = ValidationResult.accessDenied("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(accessDeniedResult, accessDeniedResult2);
  }

  /**
   * Test {@link ValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationResult.equals(Object)", "int ValidationResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ValidationResult<Object> accessDeniedResult = ValidationResult.accessDenied(null);
    ValidationResult<Object> accessDeniedResult2 = ValidationResult.accessDenied("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(accessDeniedResult, accessDeniedResult2);
  }

  /**
   * Test {@link ValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationResult.equals(Object)", "int ValidationResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ValidationResult<Object> entityNotFoundResult = ValidationResult.entityNotFound("Not all who wander are lost");
    ValidationResult<Object> accessDeniedResult = ValidationResult.accessDenied("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(entityNotFoundResult, accessDeniedResult);
  }

  /**
   * Test {@link ValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationResult.equals(Object)", "int ValidationResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ValidationResult<Object> accessDeniedResult = ValidationResult.accessDenied("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(accessDeniedResult, null);
  }

  /**
   * Test {@link ValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationResult.equals(Object)", "int ValidationResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ValidationResult<Object> accessDeniedResult = ValidationResult.accessDenied("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(accessDeniedResult, "Different type to ValidationResult");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationResult#ValidationResult(ValidationResultCode, String, Object)}
   *   <li>{@link ValidationResult#toString()}
   *   <li>{@link ValidationResult#getMessage()}
   *   <li>{@link ValidationResult#getResultCode()}
   *   <li>{@link ValidationResult#getV()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationResult.<init>(ValidationResultCode, String, Object)",
      "String ValidationResult.getMessage()", "ValidationResultCode ValidationResult.getResultCode()",
      "Object ValidationResult.getV()", "String ValidationResult.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ValidationResult<Object> actualValidationResult = new ValidationResult<>(ValidationResultCode.OK,
        "Not all who wander are lost", "42");
    String actualToStringResult = actualValidationResult.toString();
    String actualMessage = actualValidationResult.getMessage();
    ValidationResultCode actualResultCode = actualValidationResult.getResultCode();

    // Assert
    assertEquals("42", actualValidationResult.getV());
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("ValidationResult(resultCode=OK, message=Not all who wander are lost, v=42)", actualToStringResult);
    assertEquals(ValidationResultCode.OK, actualResultCode);
  }
}
