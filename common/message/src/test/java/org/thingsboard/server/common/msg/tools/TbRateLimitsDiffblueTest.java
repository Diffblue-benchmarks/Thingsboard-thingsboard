package org.thingsboard.server.common.msg.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbRateLimitsDiffblueTest {
  /**
   * Test {@link TbRateLimits#TbRateLimits(String)}.
   * <ul>
   *   <li>When {@code 42:42}.</li>
   *   <li>Then return Configuration is {@code 42:42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRateLimits#TbRateLimits(String)}
   */
  @Test
  @DisplayName("Test new TbRateLimits(String); when '42:42'; then return Configuration is '42:42'")
  void testNewTbRateLimits_when4242_thenReturnConfigurationIs4242() {
    // Arrange, Act and Assert
    assertEquals("42:42", (new TbRateLimits("42:42")).getConfiguration());
  }

  /**
   * Test {@link TbRateLimits#TbRateLimits(String)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRateLimits#TbRateLimits(String)}
   */
  @Test
  @DisplayName("Test new TbRateLimits(String); when ','; then throw IllegalArgumentException")
  void testNewTbRateLimits_whenComma_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new TbRateLimits(","));
    assertThrows(IllegalArgumentException.class, () -> new TbRateLimits(",", true));
  }

  /**
   * Test {@link TbRateLimits#tryConsume(long)} with {@code long}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRateLimits#tryConsume(long)}
   */
  @Test
  @DisplayName("Test tryConsume(long) with 'long'; when MAX_VALUE; then return 'false'")
  void testTryConsumeWithLong_whenMax_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TbRateLimits("42:42")).tryConsume(Long.MAX_VALUE));
  }

  /**
   * Test {@link TbRateLimits#tryConsume(long)} with {@code long}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRateLimits#tryConsume(long)}
   */
  @Test
  @DisplayName("Test tryConsume(long) with 'long'; when one; then return 'true'")
  void testTryConsumeWithLong_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new TbRateLimits("42:42")).tryConsume(1L));
  }

  /**
   * Test {@link TbRateLimits#tryConsume()}.
   * <ul>
   *   <li>Given {@link TbRateLimits#TbRateLimits(String)} with limitsConfiguration
   * is {@code 42:42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRateLimits#tryConsume()}
   */
  @Test
  @DisplayName("Test tryConsume(); given TbRateLimits(String) with limitsConfiguration is '42:42'; then return 'true'")
  void testTryConsume_givenTbRateLimitsWithLimitsConfigurationIs4242_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new TbRateLimits("42:42")).tryConsume());
  }
}
