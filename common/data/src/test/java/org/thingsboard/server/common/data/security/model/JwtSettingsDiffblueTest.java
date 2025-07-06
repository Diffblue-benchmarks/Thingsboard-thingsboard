package org.thingsboard.server.common.data.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JwtSettingsDiffblueTest {
  /**
   * Test {@link JwtSettings#equals(Object)}, and {@link JwtSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtSettings#equals(Object)}
   *   <li>{@link JwtSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtSettings.equals(Object)", "int JwtSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    JwtSettings jwtSettings2 = new JwtSettings();

    // Act and Assert
    assertEquals(jwtSettings, jwtSettings2);
    int expectedHashCodeResult = jwtSettings.hashCode();
    assertEquals(expectedHashCodeResult, jwtSettings2.hashCode());
  }

  /**
   * Test {@link JwtSettings#equals(Object)}, and {@link JwtSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtSettings#equals(Object)}
   *   <li>{@link JwtSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtSettings.equals(Object)", "int JwtSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings(1, 1, "ABC123", "ABC123");
    JwtSettings jwtSettings2 = new JwtSettings(1, 1, "ABC123", "ABC123");

    // Act and Assert
    assertEquals(jwtSettings, jwtSettings2);
    int expectedHashCodeResult = jwtSettings.hashCode();
    assertEquals(expectedHashCodeResult, jwtSettings2.hashCode());
  }

  /**
   * Test {@link JwtSettings#equals(Object)}, and {@link JwtSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtSettings#equals(Object)}
   *   <li>{@link JwtSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtSettings.equals(Object)", "int JwtSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();

    // Act and Assert
    assertEquals(jwtSettings, jwtSettings);
    int expectedHashCodeResult = jwtSettings.hashCode();
    assertEquals(expectedHashCodeResult, jwtSettings.hashCode());
  }

  /**
   * Test {@link JwtSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtSettings.equals(Object)", "int JwtSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings(1, 1, "ABC123", "ABC123");

    // Act and Assert
    assertNotEquals(jwtSettings, new JwtSettings());
  }

  /**
   * Test {@link JwtSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtSettings.equals(Object)", "int JwtSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();

    // Act and Assert
    assertNotEquals(jwtSettings, new JwtSettings(1, 1, "ABC123", "ABC123"));
  }

  /**
   * Test {@link JwtSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtSettings.equals(Object)", "int JwtSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setRefreshTokenExpTime(1);

    // Act and Assert
    assertNotEquals(jwtSettings, new JwtSettings());
  }

  /**
   * Test {@link JwtSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtSettings.equals(Object)", "int JwtSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenIssuer("ABC123");

    // Act and Assert
    assertNotEquals(jwtSettings, new JwtSettings());
  }

  /**
   * Test {@link JwtSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtSettings.equals(Object)", "int JwtSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenSigningKey("ABC123");

    // Act and Assert
    assertNotEquals(jwtSettings, new JwtSettings());
  }

  /**
   * Test {@link JwtSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtSettings.equals(Object)", "int JwtSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();

    JwtSettings jwtSettings2 = new JwtSettings();
    jwtSettings2.setRefreshTokenExpTime(1);

    // Act and Assert
    assertNotEquals(jwtSettings, jwtSettings2);
  }

  /**
   * Test {@link JwtSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtSettings.equals(Object)", "int JwtSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();

    JwtSettings jwtSettings2 = new JwtSettings();
    jwtSettings2.setTokenIssuer("ABC123");

    // Act and Assert
    assertNotEquals(jwtSettings, jwtSettings2);
  }

  /**
   * Test {@link JwtSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtSettings.equals(Object)", "int JwtSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();

    JwtSettings jwtSettings2 = new JwtSettings();
    jwtSettings2.setTokenSigningKey("ABC123");

    // Act and Assert
    assertNotEquals(jwtSettings, jwtSettings2);
  }

  /**
   * Test {@link JwtSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtSettings.equals(Object)", "int JwtSettings.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JwtSettings(), null);
  }

  /**
   * Test {@link JwtSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtSettings.equals(Object)", "int JwtSettings.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JwtSettings(), "Different type to JwtSettings");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtSettings#JwtSettings()}
   *   <li>{@link JwtSettings#setRefreshTokenExpTime(Integer)}
   *   <li>{@link JwtSettings#setTokenExpirationTime(Integer)}
   *   <li>{@link JwtSettings#setTokenIssuer(String)}
   *   <li>{@link JwtSettings#setTokenSigningKey(String)}
   *   <li>{@link JwtSettings#toString()}
   *   <li>{@link JwtSettings#getRefreshTokenExpTime()}
   *   <li>{@link JwtSettings#getTokenExpirationTime()}
   *   <li>{@link JwtSettings#getTokenIssuer()}
   *   <li>{@link JwtSettings#getTokenSigningKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void JwtSettings.<init>()",
    "void JwtSettings.<init>(Integer, Integer, String, String)",
    "Integer JwtSettings.getRefreshTokenExpTime()",
    "Integer JwtSettings.getTokenExpirationTime()",
    "String JwtSettings.getTokenIssuer()",
    "String JwtSettings.getTokenSigningKey()",
    "void JwtSettings.setRefreshTokenExpTime(Integer)",
    "void JwtSettings.setTokenExpirationTime(Integer)",
    "void JwtSettings.setTokenIssuer(String)",
    "void JwtSettings.setTokenSigningKey(String)",
    "String JwtSettings.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    JwtSettings actualJwtSettings = new JwtSettings();
    actualJwtSettings.setRefreshTokenExpTime(1);
    actualJwtSettings.setTokenExpirationTime(1);
    actualJwtSettings.setTokenIssuer("ABC123");
    actualJwtSettings.setTokenSigningKey("ABC123");
    String actualToStringResult = actualJwtSettings.toString();
    Integer actualRefreshTokenExpTime = actualJwtSettings.getRefreshTokenExpTime();
    Integer actualTokenExpirationTime = actualJwtSettings.getTokenExpirationTime();
    String actualTokenIssuer = actualJwtSettings.getTokenIssuer();

    // Assert
    assertEquals("ABC123", actualTokenIssuer);
    assertEquals("ABC123", actualJwtSettings.getTokenSigningKey());
    assertEquals(
        "JwtSettings(tokenExpirationTime=1, refreshTokenExpTime=1, tokenIssuer=ABC123, tokenSigningKey"
            + "=ABC123)",
        actualToStringResult);
    assertEquals(1, actualRefreshTokenExpTime.intValue());
    assertEquals(1, actualTokenExpirationTime.intValue());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtSettings#JwtSettings(Integer, Integer, String, String)}
   *   <li>{@link JwtSettings#setRefreshTokenExpTime(Integer)}
   *   <li>{@link JwtSettings#setTokenExpirationTime(Integer)}
   *   <li>{@link JwtSettings#setTokenIssuer(String)}
   *   <li>{@link JwtSettings#setTokenSigningKey(String)}
   *   <li>{@link JwtSettings#toString()}
   *   <li>{@link JwtSettings#getRefreshTokenExpTime()}
   *   <li>{@link JwtSettings#getTokenExpirationTime()}
   *   <li>{@link JwtSettings#getTokenIssuer()}
   *   <li>{@link JwtSettings#getTokenSigningKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void JwtSettings.<init>()",
    "void JwtSettings.<init>(Integer, Integer, String, String)",
    "Integer JwtSettings.getRefreshTokenExpTime()",
    "Integer JwtSettings.getTokenExpirationTime()",
    "String JwtSettings.getTokenIssuer()",
    "String JwtSettings.getTokenSigningKey()",
    "void JwtSettings.setRefreshTokenExpTime(Integer)",
    "void JwtSettings.setTokenExpirationTime(Integer)",
    "void JwtSettings.setTokenIssuer(String)",
    "void JwtSettings.setTokenSigningKey(String)",
    "String JwtSettings.toString()"
  })
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    JwtSettings actualJwtSettings = new JwtSettings(1, 1, "ABC123", "ABC123");
    actualJwtSettings.setRefreshTokenExpTime(1);
    actualJwtSettings.setTokenExpirationTime(1);
    actualJwtSettings.setTokenIssuer("ABC123");
    actualJwtSettings.setTokenSigningKey("ABC123");
    String actualToStringResult = actualJwtSettings.toString();
    Integer actualRefreshTokenExpTime = actualJwtSettings.getRefreshTokenExpTime();
    Integer actualTokenExpirationTime = actualJwtSettings.getTokenExpirationTime();
    String actualTokenIssuer = actualJwtSettings.getTokenIssuer();

    // Assert
    assertEquals("ABC123", actualTokenIssuer);
    assertEquals("ABC123", actualJwtSettings.getTokenSigningKey());
    assertEquals(
        "JwtSettings(tokenExpirationTime=1, refreshTokenExpTime=1, tokenIssuer=ABC123, tokenSigningKey"
            + "=ABC123)",
        actualToStringResult);
    assertEquals(1, actualRefreshTokenExpTime.intValue());
    assertEquals(1, actualTokenExpirationTime.intValue());
  }
}
