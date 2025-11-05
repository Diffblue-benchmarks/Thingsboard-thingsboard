package org.thingsboard.server.common.data.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.limit.LimitedApi;

class RateLimitExceededExceptionDiffblueTest {
  /**
   * Test {@link RateLimitExceededException#RateLimitExceededException(String)}.
   *
   * <p>Method under test: {@link RateLimitExceededException#RateLimitExceededException(String)}
   */
  @Test
  @DisplayName("Test new RateLimitExceededException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RateLimitExceededException.<init>(String)"})
  void testNewRateLimitExceededException() {
    // Arrange and Act
    RateLimitExceededException actualRateLimitExceededException =
        new RateLimitExceededException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualRateLimitExceededException.getMessage());
    assertNull(actualRateLimitExceededException.getCause());
    assertEquals(0, actualRateLimitExceededException.getSuppressed().length);
  }

  /**
   * Test {@link RateLimitExceededException#RateLimitExceededException(LimitedApi)}.
   *
   * <p>Method under test: {@link RateLimitExceededException#RateLimitExceededException(LimitedApi)}
   */
  @Test
  @DisplayName("Test new RateLimitExceededException(LimitedApi)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RateLimitExceededException.<init>(LimitedApi)"})
  void testNewRateLimitExceededException2() {
    // Arrange and Act
    RateLimitExceededException actualRateLimitExceededException =
        new RateLimitExceededException(LimitedApi.ENTITY_EXPORT);

    // Assert
    assertEquals(
        "Rate limit for entity version creation is exceeded",
        actualRateLimitExceededException.getLocalizedMessage());
    assertEquals(
        "Rate limit for entity version creation is exceeded",
        actualRateLimitExceededException.getMessage());
    assertNull(actualRateLimitExceededException.getCause());
    assertEquals(0, actualRateLimitExceededException.getSuppressed().length);
  }
}
