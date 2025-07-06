package org.thingsboard.server.common.msg.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbRateLimitsDiffblueTest {
  /**
   * Test {@link TbRateLimits#TbRateLimits(String)}.
   *
   * <ul>
   *   <li>When {@code 42:42}.
   *   <li>Then return Configuration is {@code 42:42}.
   * </ul>
   *
   * <p>Method under test: {@link TbRateLimits#TbRateLimits(String)}
   */
  @Test
  @DisplayName("Test new TbRateLimits(String); when '42:42'; then return Configuration is '42:42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRateLimits.<init>(String)"})
  void testNewTbRateLimits_when4242_thenReturnConfigurationIs4242() {
    // Arrange, Act and Assert
    assertEquals("42:42", new TbRateLimits("42:42").getConfiguration());
  }

  /**
   * Test {@link TbRateLimits#TbRateLimits(String)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbRateLimits#TbRateLimits(String)}
   */
  @Test
  @DisplayName("Test new TbRateLimits(String); when ','; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRateLimits.<init>(String)"})
  void testNewTbRateLimits_whenComma_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new TbRateLimits(","));
  }

  /**
   * Test {@link TbRateLimits#TbRateLimits(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbRateLimits#TbRateLimits(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test new TbRateLimits(String, boolean); when ','; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRateLimits.<init>(String, boolean)"})
  void testNewTbRateLimits_whenComma_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new TbRateLimits(",", true));
  }

  /**
   * Test {@link TbRateLimits#tryConsume(long)} with {@code long}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbRateLimits#tryConsume(long)}
   */
  @Test
  @DisplayName("Test tryConsume(long) with 'long'; when MAX_VALUE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbRateLimits.tryConsume(long)"})
  void testTryConsumeWithLong_whenMax_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TbRateLimits("42:42").tryConsume(Long.MAX_VALUE));
  }

  /**
   * Test {@link TbRateLimits#tryConsume(long)} with {@code long}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbRateLimits#tryConsume(long)}
   */
  @Test
  @DisplayName("Test tryConsume(long) with 'long'; when one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbRateLimits.tryConsume(long)"})
  void testTryConsumeWithLong_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new TbRateLimits("42:42").tryConsume(1L));
  }

  /**
   * Test {@link TbRateLimits#tryConsume()}.
   *
   * <ul>
   *   <li>Given {@link TbRateLimits#TbRateLimits(String)} with limitsConfiguration is {@code
   *       42:42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbRateLimits#tryConsume()}
   */
  @Test
  @DisplayName(
      "Test tryConsume(); given TbRateLimits(String) with limitsConfiguration is '42:42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbRateLimits.tryConsume()"})
  void testTryConsume_givenTbRateLimitsWithLimitsConfigurationIs4242_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new TbRateLimits("42:42").tryConsume());
  }
}
