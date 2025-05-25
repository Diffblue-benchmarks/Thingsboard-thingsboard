package org.thingsboard.server.service.security.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserPasswordNotValidExceptionDiffblueTest {
  /**
   * Test {@link UserPasswordNotValidException#UserPasswordNotValidException(String)}.
   * <p>
   * Method under test: {@link UserPasswordNotValidException#UserPasswordNotValidException(String)}
   */
  @Test
  @DisplayName("Test new UserPasswordNotValidException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserPasswordNotValidException.<init>(String)"})
  void testNewUserPasswordNotValidException() {
    // Arrange and Act
    UserPasswordNotValidException actualUserPasswordNotValidException = new UserPasswordNotValidException("Msg");

    // Assert
    assertEquals("Msg", actualUserPasswordNotValidException.getMessage());
    assertNull(actualUserPasswordNotValidException.getCause());
    assertEquals(0, actualUserPasswordNotValidException.getSuppressed().length);
  }
}
