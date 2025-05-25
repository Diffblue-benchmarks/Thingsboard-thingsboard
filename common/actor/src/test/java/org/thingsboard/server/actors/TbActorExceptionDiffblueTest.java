package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbActorExceptionDiffblueTest {
  /**
   * Test {@link TbActorException#TbActorException(String, Throwable)}.
   * <p>
   * Method under test: {@link TbActorException#TbActorException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new TbActorException(String, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbActorException.<init>(String, Throwable)"})
  void testNewTbActorException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TbActorException actualTbActorException = new TbActorException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTbActorException.getMessage());
    assertEquals(0, actualTbActorException.getSuppressed().length);
    assertSame(cause, actualTbActorException.getCause());
  }
}
