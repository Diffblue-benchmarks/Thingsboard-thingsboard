package org.thingsboard.server.service.security.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JwtExpiredTokenExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code ABC123}.</li>
   *   <li>Then return token is {@code ABC123}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JwtExpiredTokenException#JwtExpiredTokenException(String, String, Throwable)}
   *   <li>{@link JwtExpiredTokenException#token()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'ABC123'; then return token is 'ABC123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JwtExpiredTokenException.<init>(String)",
      "void JwtExpiredTokenException.<init>(String, String, Throwable)", "String JwtExpiredTokenException.token()"})
  void testGettersAndSetters_whenAbc123_thenReturnTokenIsAbc123() {
    // Arrange
    Throwable t = new Throwable();

    // Act
    JwtExpiredTokenException actualJwtExpiredTokenException = new JwtExpiredTokenException("ABC123", "Msg", t);

    // Assert
    assertEquals("ABC123", actualJwtExpiredTokenException.token());
    assertEquals("Msg", actualJwtExpiredTokenException.getMessage());
    assertEquals(0, actualJwtExpiredTokenException.getSuppressed().length);
    assertSame(t, actualJwtExpiredTokenException.getCause());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Msg}.</li>
   *   <li>Then return token is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JwtExpiredTokenException#JwtExpiredTokenException(String)}
   *   <li>{@link JwtExpiredTokenException#token()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Msg'; then return token is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JwtExpiredTokenException.<init>(String)",
      "void JwtExpiredTokenException.<init>(String, String, Throwable)", "String JwtExpiredTokenException.token()"})
  void testGettersAndSetters_whenMsg_thenReturnTokenIsNull() {
    // Arrange and Act
    JwtExpiredTokenException actualJwtExpiredTokenException = new JwtExpiredTokenException("Msg");

    // Assert
    assertEquals("Msg", actualJwtExpiredTokenException.getMessage());
    assertNull(actualJwtExpiredTokenException.token());
    assertNull(actualJwtExpiredTokenException.getCause());
    assertEquals(0, actualJwtExpiredTokenException.getSuppressed().length);
  }
}
