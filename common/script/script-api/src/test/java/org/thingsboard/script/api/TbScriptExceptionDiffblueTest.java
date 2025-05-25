package org.thingsboard.script.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.script.api.TbScriptException.ErrorCode;

class TbScriptExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbScriptException#TbScriptException(UUID, ErrorCode, String, Exception)}
   *   <li>{@link TbScriptException#getBody()}
   *   <li>{@link TbScriptException#getErrorCode()}
   *   <li>{@link TbScriptException#getScriptId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbScriptException.<init>(UUID, ErrorCode, String, Exception)",
      "String TbScriptException.getBody()", "ErrorCode TbScriptException.getErrorCode()",
      "UUID TbScriptException.getScriptId()"})
  void testGettersAndSetters() {
    // Arrange
    UUID scriptId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Exception cause = new Exception("foo");

    // Act
    TbScriptException actualTbScriptException = new TbScriptException(scriptId, ErrorCode.COMPILATION,
        "Not all who wander are lost", cause);
    String actualBody = actualTbScriptException.getBody();
    ErrorCode actualErrorCode = actualTbScriptException.getErrorCode();
    UUID actualScriptId = actualTbScriptException.getScriptId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualScriptId.toString());
    assertEquals("Not all who wander are lost", actualBody);
    assertEquals("java.lang.Exception: foo", actualTbScriptException.getMessage());
    assertEquals(0, actualTbScriptException.getSuppressed().length);
    assertEquals(ErrorCode.COMPILATION, actualErrorCode);
    assertSame(cause, actualTbScriptException.getCause());
    assertSame(scriptId, actualScriptId);
  }
}
