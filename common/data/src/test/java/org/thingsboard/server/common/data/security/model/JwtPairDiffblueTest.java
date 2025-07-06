package org.thingsboard.server.common.data.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.Authority;

class JwtPairDiffblueTest {
  /**
   * Test {@link JwtPair#equals(Object)}, and {@link JwtPair#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtPair#equals(Object)}
   *   <li>{@link JwtPair#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtPair.equals(Object)", "int JwtPair.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", "ABC123");
    JwtPair jwtPair2 = new JwtPair("ABC123", "ABC123");

    // Act and Assert
    assertEquals(jwtPair, jwtPair2);
    int expectedHashCodeResult = jwtPair.hashCode();
    assertEquals(expectedHashCodeResult, jwtPair2.hashCode());
  }

  /**
   * Test {@link JwtPair#equals(Object)}, and {@link JwtPair#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtPair#equals(Object)}
   *   <li>{@link JwtPair#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtPair.equals(Object)", "int JwtPair.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    JwtPair jwtPair = new JwtPair(null, "ABC123");
    JwtPair jwtPair2 = new JwtPair(null, "ABC123");

    // Act and Assert
    assertEquals(jwtPair, jwtPair2);
    int expectedHashCodeResult = jwtPair.hashCode();
    assertEquals(expectedHashCodeResult, jwtPair2.hashCode());
  }

  /**
   * Test {@link JwtPair#equals(Object)}, and {@link JwtPair#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtPair#equals(Object)}
   *   <li>{@link JwtPair#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtPair.equals(Object)", "int JwtPair.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", null);
    JwtPair jwtPair2 = new JwtPair("ABC123", null);

    // Act and Assert
    assertEquals(jwtPair, jwtPair2);
    int expectedHashCodeResult = jwtPair.hashCode();
    assertEquals(expectedHashCodeResult, jwtPair2.hashCode());
  }

  /**
   * Test {@link JwtPair#equals(Object)}, and {@link JwtPair#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtPair#equals(Object)}
   *   <li>{@link JwtPair#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtPair.equals(Object)", "int JwtPair.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", "ABC123");
    jwtPair.setScope(Authority.SYS_ADMIN);

    JwtPair jwtPair2 = new JwtPair("ABC123", "ABC123");
    jwtPair2.setScope(Authority.SYS_ADMIN);

    // Act and Assert
    assertEquals(jwtPair, jwtPair2);
    int expectedHashCodeResult = jwtPair.hashCode();
    assertEquals(expectedHashCodeResult, jwtPair2.hashCode());
  }

  /**
   * Test {@link JwtPair#equals(Object)}, and {@link JwtPair#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtPair#equals(Object)}
   *   <li>{@link JwtPair#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtPair.equals(Object)", "int JwtPair.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", "ABC123");

    // Act and Assert
    assertEquals(jwtPair, jwtPair);
    int expectedHashCodeResult = jwtPair.hashCode();
    assertEquals(expectedHashCodeResult, jwtPair.hashCode());
  }

  /**
   * Test {@link JwtPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtPair.equals(Object)", "int JwtPair.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JwtPair jwtPair = new JwtPair("Token", "ABC123");

    // Act and Assert
    assertNotEquals(jwtPair, new JwtPair("ABC123", "ABC123"));
  }

  /**
   * Test {@link JwtPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtPair.equals(Object)", "int JwtPair.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JwtPair jwtPair = new JwtPair(null, "ABC123");

    // Act and Assert
    assertNotEquals(jwtPair, new JwtPair("ABC123", "ABC123"));
  }

  /**
   * Test {@link JwtPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtPair.equals(Object)", "int JwtPair.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", "Refresh Token");

    // Act and Assert
    assertNotEquals(jwtPair, new JwtPair("ABC123", "ABC123"));
  }

  /**
   * Test {@link JwtPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtPair.equals(Object)", "int JwtPair.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", null);

    // Act and Assert
    assertNotEquals(jwtPair, new JwtPair("ABC123", "ABC123"));
  }

  /**
   * Test {@link JwtPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtPair.equals(Object)", "int JwtPair.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", "ABC123");
    jwtPair.setScope(Authority.SYS_ADMIN);

    // Act and Assert
    assertNotEquals(jwtPair, new JwtPair("ABC123", "ABC123"));
  }

  /**
   * Test {@link JwtPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtPair.equals(Object)", "int JwtPair.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    JwtPair jwtPair = new JwtPair("ABC123", "ABC123");

    JwtPair jwtPair2 = new JwtPair("ABC123", "ABC123");
    jwtPair2.setScope(Authority.SYS_ADMIN);

    // Act and Assert
    assertNotEquals(jwtPair, jwtPair2);
  }

  /**
   * Test {@link JwtPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtPair.equals(Object)", "int JwtPair.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JwtPair("ABC123", "ABC123"), null);
  }

  /**
   * Test {@link JwtPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JwtPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtPair.equals(Object)", "int JwtPair.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JwtPair("ABC123", "ABC123"), "Different type to JwtPair");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtPair#JwtPair()}
   *   <li>{@link JwtPair#setRefreshToken(String)}
   *   <li>{@link JwtPair#setScope(Authority)}
   *   <li>{@link JwtPair#setToken(String)}
   *   <li>{@link JwtPair#toString()}
   *   <li>{@link JwtPair#getRefreshToken()}
   *   <li>{@link JwtPair#getScope()}
   *   <li>{@link JwtPair#getToken()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void JwtPair.<init>()",
    "void JwtPair.<init>(String, String)",
    "String JwtPair.getRefreshToken()",
    "Authority JwtPair.getScope()",
    "String JwtPair.getToken()",
    "void JwtPair.setRefreshToken(String)",
    "void JwtPair.setScope(Authority)",
    "void JwtPair.setToken(String)",
    "String JwtPair.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    JwtPair actualJwtPair = new JwtPair();
    actualJwtPair.setRefreshToken("ABC123");
    actualJwtPair.setScope(Authority.SYS_ADMIN);
    actualJwtPair.setToken("ABC123");
    String actualToStringResult = actualJwtPair.toString();
    String actualRefreshToken = actualJwtPair.getRefreshToken();
    Authority actualScope = actualJwtPair.getScope();

    // Assert
    assertEquals("ABC123", actualRefreshToken);
    assertEquals("ABC123", actualJwtPair.getToken());
    assertEquals(
        "JwtPair(token=ABC123, refreshToken=ABC123, scope=SYS_ADMIN)", actualToStringResult);
    assertEquals(Authority.SYS_ADMIN, actualScope);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ABC123}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JwtPair#JwtPair(String, String)}
   *   <li>{@link JwtPair#setRefreshToken(String)}
   *   <li>{@link JwtPair#setScope(Authority)}
   *   <li>{@link JwtPair#setToken(String)}
   *   <li>{@link JwtPair#toString()}
   *   <li>{@link JwtPair#getRefreshToken()}
   *   <li>{@link JwtPair#getScope()}
   *   <li>{@link JwtPair#getToken()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'ABC123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void JwtPair.<init>()",
    "void JwtPair.<init>(String, String)",
    "String JwtPair.getRefreshToken()",
    "Authority JwtPair.getScope()",
    "String JwtPair.getToken()",
    "void JwtPair.setRefreshToken(String)",
    "void JwtPair.setScope(Authority)",
    "void JwtPair.setToken(String)",
    "String JwtPair.toString()"
  })
  void testGettersAndSetters_whenAbc123() {
    // Arrange and Act
    JwtPair actualJwtPair = new JwtPair("ABC123", "ABC123");
    actualJwtPair.setRefreshToken("ABC123");
    actualJwtPair.setScope(Authority.SYS_ADMIN);
    actualJwtPair.setToken("ABC123");
    String actualToStringResult = actualJwtPair.toString();
    String actualRefreshToken = actualJwtPair.getRefreshToken();
    Authority actualScope = actualJwtPair.getScope();

    // Assert
    assertEquals("ABC123", actualRefreshToken);
    assertEquals("ABC123", actualJwtPair.getToken());
    assertEquals(
        "JwtPair(token=ABC123, refreshToken=ABC123, scope=SYS_ADMIN)", actualToStringResult);
    assertEquals(Authority.SYS_ADMIN, actualScope);
  }
}
