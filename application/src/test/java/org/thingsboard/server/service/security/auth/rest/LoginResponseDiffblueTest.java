package org.thingsboard.server.service.security.auth.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LoginResponseDiffblueTest {
  /**
   * Test {@link LoginResponse#equals(Object)}, and {@link LoginResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LoginResponse#equals(Object)}
   *   <li>{@link LoginResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LoginResponse.equals(Object)", "int LoginResponse.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setRefreshToken("ABC123");
    loginResponse.setToken("ABC123");

    LoginResponse loginResponse2 = new LoginResponse();
    loginResponse2.setRefreshToken("ABC123");
    loginResponse2.setToken("ABC123");

    // Act and Assert
    assertEquals(loginResponse, loginResponse2);
    int expectedHashCodeResult = loginResponse.hashCode();
    assertEquals(expectedHashCodeResult, loginResponse2.hashCode());
  }

  /**
   * Test {@link LoginResponse#equals(Object)}, and {@link LoginResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LoginResponse#equals(Object)}
   *   <li>{@link LoginResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LoginResponse.equals(Object)", "int LoginResponse.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setRefreshToken(null);
    loginResponse.setToken("ABC123");

    LoginResponse loginResponse2 = new LoginResponse();
    loginResponse2.setRefreshToken(null);
    loginResponse2.setToken("ABC123");

    // Act and Assert
    assertEquals(loginResponse, loginResponse2);
    int expectedHashCodeResult = loginResponse.hashCode();
    assertEquals(expectedHashCodeResult, loginResponse2.hashCode());
  }

  /**
   * Test {@link LoginResponse#equals(Object)}, and {@link LoginResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LoginResponse#equals(Object)}
   *   <li>{@link LoginResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LoginResponse.equals(Object)", "int LoginResponse.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setRefreshToken("ABC123");
    loginResponse.setToken(null);

    LoginResponse loginResponse2 = new LoginResponse();
    loginResponse2.setRefreshToken("ABC123");
    loginResponse2.setToken(null);

    // Act and Assert
    assertEquals(loginResponse, loginResponse2);
    int expectedHashCodeResult = loginResponse.hashCode();
    assertEquals(expectedHashCodeResult, loginResponse2.hashCode());
  }

  /**
   * Test {@link LoginResponse#equals(Object)}, and {@link LoginResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LoginResponse#equals(Object)}
   *   <li>{@link LoginResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LoginResponse.equals(Object)", "int LoginResponse.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setRefreshToken("ABC123");
    loginResponse.setToken("ABC123");

    // Act and Assert
    assertEquals(loginResponse, loginResponse);
    int expectedHashCodeResult = loginResponse.hashCode();
    assertEquals(expectedHashCodeResult, loginResponse.hashCode());
  }

  /**
   * Test {@link LoginResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LoginResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LoginResponse.equals(Object)", "int LoginResponse.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setRefreshToken("Refresh Token");
    loginResponse.setToken("ABC123");

    LoginResponse loginResponse2 = new LoginResponse();
    loginResponse2.setRefreshToken("ABC123");
    loginResponse2.setToken("ABC123");

    // Act and Assert
    assertNotEquals(loginResponse, loginResponse2);
  }

  /**
   * Test {@link LoginResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LoginResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LoginResponse.equals(Object)", "int LoginResponse.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setRefreshToken(null);
    loginResponse.setToken("ABC123");

    LoginResponse loginResponse2 = new LoginResponse();
    loginResponse2.setRefreshToken("ABC123");
    loginResponse2.setToken("ABC123");

    // Act and Assert
    assertNotEquals(loginResponse, loginResponse2);
  }

  /**
   * Test {@link LoginResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LoginResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LoginResponse.equals(Object)", "int LoginResponse.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setRefreshToken("ABC123");
    loginResponse.setToken("Token");

    LoginResponse loginResponse2 = new LoginResponse();
    loginResponse2.setRefreshToken("ABC123");
    loginResponse2.setToken("ABC123");

    // Act and Assert
    assertNotEquals(loginResponse, loginResponse2);
  }

  /**
   * Test {@link LoginResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LoginResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LoginResponse.equals(Object)", "int LoginResponse.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setRefreshToken("ABC123");
    loginResponse.setToken(null);

    LoginResponse loginResponse2 = new LoginResponse();
    loginResponse2.setRefreshToken("ABC123");
    loginResponse2.setToken("ABC123");

    // Act and Assert
    assertNotEquals(loginResponse, loginResponse2);
  }

  /**
   * Test {@link LoginResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LoginResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LoginResponse.equals(Object)", "int LoginResponse.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setRefreshToken("ABC123");
    loginResponse.setToken("ABC123");

    // Act and Assert
    assertNotEquals(loginResponse, null);
  }

  /**
   * Test {@link LoginResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LoginResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LoginResponse.equals(Object)", "int LoginResponse.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setRefreshToken("ABC123");
    loginResponse.setToken("ABC123");

    // Act and Assert
    assertNotEquals(loginResponse, "Different type to LoginResponse");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LoginResponse}
   *   <li>{@link LoginResponse#setRefreshToken(String)}
   *   <li>{@link LoginResponse#setToken(String)}
   *   <li>{@link LoginResponse#toString()}
   *   <li>{@link LoginResponse#getRefreshToken()}
   *   <li>{@link LoginResponse#getToken()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LoginResponse.<init>()", "String LoginResponse.getRefreshToken()",
      "String LoginResponse.getToken()", "void LoginResponse.setRefreshToken(String)",
      "void LoginResponse.setToken(String)", "String LoginResponse.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    LoginResponse actualLoginResponse = new LoginResponse();
    actualLoginResponse.setRefreshToken("ABC123");
    actualLoginResponse.setToken("ABC123");
    String actualToStringResult = actualLoginResponse.toString();
    String actualRefreshToken = actualLoginResponse.getRefreshToken();

    // Assert
    assertEquals("ABC123", actualRefreshToken);
    assertEquals("ABC123", actualLoginResponse.getToken());
    assertEquals("LoginResponse(token=ABC123, refreshToken=ABC123)", actualToStringResult);
  }
}
