package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.tools.TbRateLimits;

class SimpleTransportRateLimitDiffblueTest {
  /**
   * Test {@link SimpleTransportRateLimit#SimpleTransportRateLimit(String)}.
   *
   * <ul>
   *   <li>When {@code 42:42}.
   *   <li>Then return Configuration is {@code 42:42}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTransportRateLimit#SimpleTransportRateLimit(String)}
   */
  @Test
  @DisplayName(
      "Test new SimpleTransportRateLimit(String); when '42:42'; then return Configuration is '42:42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTransportRateLimit.<init>(String)"})
  void testNewSimpleTransportRateLimit_when4242_thenReturnConfigurationIs4242() {
    // Arrange, Act and Assert
    assertEquals("42:42", new SimpleTransportRateLimit("42:42").getConfiguration());
  }

  /**
   * Test {@link SimpleTransportRateLimit#tryConsume(long)} with {@code long}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTransportRateLimit#tryConsume(long)}
   */
  @Test
  @DisplayName("Test tryConsume(long) with 'long'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleTransportRateLimit.tryConsume(long)"})
  void testTryConsumeWithLong_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new SimpleTransportRateLimit(null, "Configuration").tryConsume(0L));
  }

  /**
   * Test {@link SimpleTransportRateLimit#tryConsume()}.
   *
   * <ul>
   *   <li>Given {@link TbRateLimits} {@link TbRateLimits#tryConsume()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTransportRateLimit#tryConsume()}
   */
  @Test
  @DisplayName(
      "Test tryConsume(); given TbRateLimits tryConsume() return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleTransportRateLimit.tryConsume()"})
  void testTryConsume_givenTbRateLimitsTryConsumeReturnFalse_thenReturnFalse() {
    // Arrange
    TbRateLimits rateLimit = mock(TbRateLimits.class);
    when(rateLimit.tryConsume()).thenReturn(false);

    // Act
    boolean actualTryConsumeResult =
        new SimpleTransportRateLimit(rateLimit, "Configuration").tryConsume();

    // Assert
    verify(rateLimit).tryConsume();
    assertFalse(actualTryConsumeResult);
  }

  /**
   * Test {@link SimpleTransportRateLimit#tryConsume()}.
   *
   * <ul>
   *   <li>Given {@link TbRateLimits} {@link TbRateLimits#tryConsume()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTransportRateLimit#tryConsume()}
   */
  @Test
  @DisplayName(
      "Test tryConsume(); given TbRateLimits tryConsume() return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleTransportRateLimit.tryConsume()"})
  void testTryConsume_givenTbRateLimitsTryConsumeReturnTrue_thenReturnTrue() {
    // Arrange
    TbRateLimits rateLimit = mock(TbRateLimits.class);
    when(rateLimit.tryConsume()).thenReturn(true);

    // Act
    boolean actualTryConsumeResult =
        new SimpleTransportRateLimit(rateLimit, "Configuration").tryConsume();

    // Assert
    verify(rateLimit).tryConsume();
    assertTrue(actualTryConsumeResult);
  }
}
