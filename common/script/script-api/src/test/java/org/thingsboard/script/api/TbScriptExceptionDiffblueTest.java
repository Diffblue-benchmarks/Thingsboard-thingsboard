package org.thingsboard.script.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbScriptExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbScriptException#TbScriptException(UUID, TbScriptException.ErrorCode, String, Exception)}
   *   <li>{@link TbScriptException#getBody()}
   *   <li>{@link TbScriptException#getErrorCode()}
   *   <li>{@link TbScriptException#getScriptId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UUID scriptId = UUID.randomUUID();
    Exception cause = new Exception("foo");

    // Act
    TbScriptException actualTbScriptException = new TbScriptException(scriptId, TbScriptException.ErrorCode.COMPILATION,
        "Not all who wander are lost", cause);
    String actualBody = actualTbScriptException.getBody();
    TbScriptException.ErrorCode actualErrorCode = actualTbScriptException.getErrorCode();
    UUID actualScriptId = actualTbScriptException.getScriptId();

    // Assert
    assertEquals("Not all who wander are lost", actualBody);
    assertEquals("java.lang.Exception: foo", actualTbScriptException.getMessage());
    assertEquals(0, actualTbScriptException.getSuppressed().length);
    assertEquals(TbScriptException.ErrorCode.COMPILATION, actualErrorCode);
    assertSame(cause, actualTbScriptException.getCause());
    assertSame(scriptId, actualScriptId);
  }
}
