package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RegexUtilsDiffblueTest {
  /**
   * Test {@link RegexUtils#replace(String, String, Function)} with {@code input},
   * {@code pattern}, {@code replacer}.
   * <p>
   * Method under test: {@link RegexUtils#replace(String, String, Function)}
   */
  @Test
  @DisplayName("Test replace(String, String, Function) with 'input', 'pattern', 'replacer'")
  void testReplaceWithInputPatternReplacer() {
    // Arrange, Act and Assert
    assertEquals("Input", RegexUtils.replace("Input", "Pattern", mock(Function.class)));
  }

  /**
   * Test {@link RegexUtils#replace(String, Pattern, UnaryOperator)} with
   * {@code s}, {@code pattern}, {@code replacer}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@link RegexUtils#UUID_PATTERN}.</li>
   *   <li>Then return {@code Apply}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegexUtils#replace(String, Pattern, UnaryOperator)}
   */
  @Test
  @DisplayName("Test replace(String, Pattern, UnaryOperator) with 's', 'pattern', 'replacer'; given 'Apply'; when UUID_PATTERN; then return 'Apply'")
  void testReplaceWithSPatternReplacer_givenApply_whenUuid_pattern_thenReturnApply() {
    // Arrange
    UnaryOperator<String> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    String actualReplaceResult = RegexUtils.replace("99999999-9999-9999-9999-999999999999", RegexUtils.UUID_PATTERN,
        replacer);

    // Assert
    verify(replacer).apply(eq("99999999-9999-9999-9999-999999999999"));
    assertEquals("Apply", actualReplaceResult);
  }

  /**
   * Test {@link RegexUtils#replace(String, Pattern, UnaryOperator)} with
   * {@code s}, {@code pattern}, {@code replacer}.
   * <ul>
   *   <li>When compile empty string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegexUtils#replace(String, Pattern, UnaryOperator)}
   */
  @Test
  @DisplayName("Test replace(String, Pattern, UnaryOperator) with 's', 'pattern', 'replacer'; when compile empty string; then return a string")
  void testReplaceWithSPatternReplacer_whenCompileEmptyString_thenReturnAString() {
    // Arrange
    Pattern pattern = Pattern.compile("");
    UnaryOperator<String> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    String actualReplaceResult = RegexUtils.replace("99999999-9999-9999-9999-999999999999", pattern, replacer);

    // Assert
    verify(replacer, atLeast(1)).apply(eq(""));
    assertEquals("Apply9Apply9Apply9Apply9Apply9Apply9Apply9Apply9Apply-Apply9Apply9Apply9Apply9Apply-Apply9Apply9Appl"
        + "y9Apply9Apply-Apply9Apply9Apply9Apply9Apply-Apply9Apply9Apply9Apply9Apply9Apply9Apply9Apply9Apply9Ap"
        + "ply9Apply9Apply9Apply", actualReplaceResult);
  }

  /**
   * Test {@link RegexUtils#replace(String, Pattern, UnaryOperator)} with
   * {@code s}, {@code pattern}, {@code replacer}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegexUtils#replace(String, Pattern, UnaryOperator)}
   */
  @Test
  @DisplayName("Test replace(String, Pattern, UnaryOperator) with 's', 'pattern', 'replacer'; when 'foo'; then return 'foo'")
  void testReplaceWithSPatternReplacer_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", RegexUtils.replace("foo", RegexUtils.UUID_PATTERN, mock(UnaryOperator.class)));
  }

  /**
   * Test {@link RegexUtils#matches(String, Pattern)}.
   * <ul>
   *   <li>When {@code 99999999-9999-9999-9999-999999999999}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegexUtils#matches(String, Pattern)}
   */
  @Test
  @DisplayName("Test matches(String, Pattern); when '99999999-9999-9999-9999-999999999999'; then return 'true'")
  void testMatches_when99999999999999999999999999999999_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RegexUtils.matches("99999999-9999-9999-9999-999999999999", RegexUtils.UUID_PATTERN));
  }

  /**
   * Test {@link RegexUtils#matches(String, Pattern)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegexUtils#matches(String, Pattern)}
   */
  @Test
  @DisplayName("Test matches(String, Pattern); when 'Input'; then return 'false'")
  void testMatches_whenInput_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RegexUtils.matches("Input", RegexUtils.UUID_PATTERN));
  }

  /**
   * Test {@link RegexUtils#getMatch(String, Pattern, int)}.
   * <ul>
   *   <li>When {@code 99999999-9999-9999-9999-999999999999}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegexUtils#getMatch(String, Pattern, int)}
   */
  @Test
  @DisplayName("Test getMatch(String, Pattern, int); when '99999999-9999-9999-9999-999999999999'; then return 'null'")
  void testGetMatch_when99999999999999999999999999999999_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RegexUtils.getMatch("99999999-9999-9999-9999-999999999999", RegexUtils.UUID_PATTERN, 1));
  }

  /**
   * Test {@link RegexUtils#getMatch(String, Pattern, int)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegexUtils#getMatch(String, Pattern, int)}
   */
  @Test
  @DisplayName("Test getMatch(String, Pattern, int); when 'Input'; then return 'null'")
  void testGetMatch_whenInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RegexUtils.getMatch("Input", RegexUtils.UUID_PATTERN, 1));
  }

  /**
   * Test {@link RegexUtils#getMatch(String, Pattern, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code 99999999-9999-9999-9999-999999999999}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegexUtils#getMatch(String, Pattern, int)}
   */
  @Test
  @DisplayName("Test getMatch(String, Pattern, int); when zero; then return '99999999-9999-9999-9999-999999999999'")
  void testGetMatch_whenZero_thenReturn99999999999999999999999999999999() {
    // Arrange, Act and Assert
    assertEquals("99999999-9999-9999-9999-999999999999",
        RegexUtils.getMatch("99999999-9999-9999-9999-999999999999", RegexUtils.UUID_PATTERN, 0));
  }
}
