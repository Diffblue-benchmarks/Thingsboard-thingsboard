package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbRuleNodeUpdateExceptionDiffblueTest {
  /**
   * Test {@link TbRuleNodeUpdateException#TbRuleNodeUpdateException(String, Throwable)}.
   *
   * <p>Method under test: {@link TbRuleNodeUpdateException#TbRuleNodeUpdateException(String,
   * Throwable)}
   */
  @Test
  @DisplayName("Test new TbRuleNodeUpdateException(String, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRuleNodeUpdateException.<init>(String, Throwable)"})
  void testNewTbRuleNodeUpdateException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TbRuleNodeUpdateException actualTbRuleNodeUpdateException =
        new TbRuleNodeUpdateException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTbRuleNodeUpdateException.getMessage());
    assertEquals(0, actualTbRuleNodeUpdateException.getSuppressed().length);
    assertSame(cause, actualTbRuleNodeUpdateException.getCause());
  }
}
