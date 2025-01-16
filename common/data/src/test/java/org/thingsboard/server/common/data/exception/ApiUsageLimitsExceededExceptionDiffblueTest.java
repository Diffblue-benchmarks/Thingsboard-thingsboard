package org.thingsboard.server.common.data.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApiUsageLimitsExceededExceptionDiffblueTest {
  /**
   * Test
   * {@link ApiUsageLimitsExceededException#ApiUsageLimitsExceededException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageLimitsExceededException#ApiUsageLimitsExceededException(String)}
   */
  @Test
  @DisplayName("Test new ApiUsageLimitsExceededException(String); then return Message is 'An error occurred'")
  void testNewApiUsageLimitsExceededException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    ApiUsageLimitsExceededException actualApiUsageLimitsExceededException = new ApiUsageLimitsExceededException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualApiUsageLimitsExceededException.getMessage());
    assertNull(actualApiUsageLimitsExceededException.getCause());
    assertEquals(0, actualApiUsageLimitsExceededException.getSuppressed().length);
  }

  /**
   * Test
   * {@link ApiUsageLimitsExceededException#ApiUsageLimitsExceededException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageLimitsExceededException#ApiUsageLimitsExceededException()}
   */
  @Test
  @DisplayName("Test new ApiUsageLimitsExceededException(); then return Message is 'null'")
  void testNewApiUsageLimitsExceededException_thenReturnMessageIsNull() {
    // Arrange and Act
    ApiUsageLimitsExceededException actualApiUsageLimitsExceededException = new ApiUsageLimitsExceededException();

    // Assert
    assertNull(actualApiUsageLimitsExceededException.getMessage());
    assertNull(actualApiUsageLimitsExceededException.getCause());
    assertEquals(0, actualApiUsageLimitsExceededException.getSuppressed().length);
  }
}
