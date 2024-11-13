package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DummyTransportRateLimitDiffblueTest {
  /**
   * Test {@link DummyTransportRateLimit#tryConsume()}.
   * <p>
   * Method under test: {@link DummyTransportRateLimit#tryConsume()}
   */
  @Test
  @DisplayName("Test tryConsume()")
  void testTryConsume() {
    // Arrange, Act and Assert
    assertTrue((new DummyTransportRateLimit()).tryConsume());
  }

  /**
   * Test {@link DummyTransportRateLimit#tryConsume(long)} with {@code long}.
   * <p>
   * Method under test: {@link DummyTransportRateLimit#tryConsume(long)}
   */
  @Test
  @DisplayName("Test tryConsume(long) with 'long'")
  void testTryConsumeWithLong() {
    // Arrange, Act and Assert
    assertTrue((new DummyTransportRateLimit()).tryConsume(1L));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DummyTransportRateLimit}
   *   <li>{@link DummyTransportRateLimit#getConfiguration()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("", (new DummyTransportRateLimit()).getConfiguration());
  }
}
