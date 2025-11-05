package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RegexUtilsDiffblueTest {
  /**
   * Test {@link RegexUtils#replace(String, String, Function)} with {@code input}, {@code pattern},
   * {@code replacer}.
   *
   * <p>Method under test: {@link RegexUtils#replace(String, String, Function)}
   */
  @Test
  @DisplayName("Test replace(String, String, Function) with 'input', 'pattern', 'replacer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RegexUtils.replace(String, String, Function)"})
  void testReplaceWithInputPatternReplacer() {
    // Arrange and Act
    String actualReplaceResult = RegexUtils.replace("Input", "Pattern", mock(Function.class));

    // Assert
    assertEquals("Input", actualReplaceResult);
  }

  /**
   * Test {@link RegexUtils#replace(String, Pattern, UnaryOperator)} with {@code s}, {@code
   * pattern}, {@code replacer}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>When {@link RegexUtils#UUID_PATTERN}.
   *   <li>Then return {@code Apply}.
   * </ul>
   *
   * <p>Method under test: {@link RegexUtils#replace(String, Pattern, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test replace(String, Pattern, UnaryOperator) with 's', 'pattern', 'replacer'; given 'Apply'; when UUID_PATTERN; then return 'Apply'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RegexUtils.replace(String, Pattern, UnaryOperator)"})
  void testReplaceWithSPatternReplacer_givenApply_whenUuid_pattern_thenReturnApply() {
    // Arrange
    UnaryOperator<String> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    String actualReplaceResult =
        RegexUtils.replace(
            "99999999-9999-9999-9999-999999999999", RegexUtils.UUID_PATTERN, replacer);

    // Assert
    verify(replacer).apply("99999999-9999-9999-9999-999999999999");
    assertEquals("Apply", actualReplaceResult);
  }

  /**
   * Test {@link RegexUtils#replace(String, Pattern, UnaryOperator)} with {@code s}, {@code
   * pattern}, {@code replacer}.
   *
   * <ul>
   *   <li>When compile empty string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link RegexUtils#replace(String, Pattern, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test replace(String, Pattern, UnaryOperator) with 's', 'pattern', 'replacer'; when compile empty string; then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RegexUtils.replace(String, Pattern, UnaryOperator)"})
  void testReplaceWithSPatternReplacer_whenCompileEmptyString_thenReturnAString() {
    // Arrange
    Pattern pattern = Pattern.compile("");

    UnaryOperator<String> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    String actualReplaceResult =
        RegexUtils.replace("99999999-9999-9999-9999-999999999999", pattern, replacer);

    // Assert
    verify(replacer, atLeast(1)).apply("");
    assertEquals(
        "Apply9Apply9Apply9Apply9Apply9Apply9Apply9Apply9Apply-Apply9Apply9Apply9Apply9Apply-Apply9Apply9Appl"
            + "y9Apply9Apply-Apply9Apply9Apply9Apply9Apply-Apply9Apply9Apply9Apply9Apply9Apply9Apply9Apply9Apply9Ap"
            + "ply9Apply9Apply9Apply",
        actualReplaceResult);
  }

  /**
   * Test {@link RegexUtils#replace(String, Pattern, UnaryOperator)} with {@code s}, {@code
   * pattern}, {@code replacer}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link RegexUtils#replace(String, Pattern, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test replace(String, Pattern, UnaryOperator) with 's', 'pattern', 'replacer'; when 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RegexUtils.replace(String, Pattern, UnaryOperator)"})
  void testReplaceWithSPatternReplacer_whenFoo_thenReturnFoo() {
    // Arrange and Act
    String actualReplaceResult =
        RegexUtils.replace("foo", RegexUtils.UUID_PATTERN, mock(UnaryOperator.class));

    // Assert
    assertEquals("foo", actualReplaceResult);
  }

  /**
   * Test {@link RegexUtils#matches(String, Pattern)}.
   *
   * <ul>
   *   <li>When {@code 99999999-9999-9999-9999-999999999999}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RegexUtils#matches(String, Pattern)}
   */
  @Test
  @DisplayName(
      "Test matches(String, Pattern); when '99999999-9999-9999-9999-999999999999'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegexUtils.matches(String, Pattern)"})
  void testMatches_when99999999999999999999999999999999_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RegexUtils.matches("99999999-9999-9999-9999-999999999999", RegexUtils.UUID_PATTERN));
  }

  /**
   * Test {@link RegexUtils#matches(String, Pattern)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RegexUtils#matches(String, Pattern)}
   */
  @Test
  @DisplayName("Test matches(String, Pattern); when 'Input'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegexUtils.matches(String, Pattern)"})
  void testMatches_whenInput_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RegexUtils.matches("Input", RegexUtils.UUID_PATTERN));
  }

  /**
   * Test {@link RegexUtils#getMatch(String, Pattern, int)}.
   *
   * <ul>
   *   <li>When {@code 99999999-9999-9999-9999-999999999999}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RegexUtils#getMatch(String, Pattern, int)}
   */
  @Test
  @DisplayName(
      "Test getMatch(String, Pattern, int); when '99999999-9999-9999-9999-999999999999'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RegexUtils.getMatch(String, Pattern, int)"})
  void testGetMatch_when99999999999999999999999999999999_thenReturnNull() {
    // Arrange and Act
    String actualMatch =
        RegexUtils.getMatch("99999999-9999-9999-9999-999999999999", RegexUtils.UUID_PATTERN, 1);

    // Assert
    assertNull(actualMatch);
  }

  /**
   * Test {@link RegexUtils#getMatch(String, Pattern, int)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RegexUtils#getMatch(String, Pattern, int)}
   */
  @Test
  @DisplayName("Test getMatch(String, Pattern, int); when 'Input'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RegexUtils.getMatch(String, Pattern, int)"})
  void testGetMatch_whenInput_thenReturnNull() {
    // Arrange and Act
    String actualMatch = RegexUtils.getMatch("Input", RegexUtils.UUID_PATTERN, 1);

    // Assert
    assertNull(actualMatch);
  }

  /**
   * Test {@link RegexUtils#getMatch(String, Pattern, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code 99999999-9999-9999-9999-999999999999}.
   * </ul>
   *
   * <p>Method under test: {@link RegexUtils#getMatch(String, Pattern, int)}
   */
  @Test
  @DisplayName(
      "Test getMatch(String, Pattern, int); when zero; then return '99999999-9999-9999-9999-999999999999'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RegexUtils.getMatch(String, Pattern, int)"})
  void testGetMatch_whenZero_thenReturn99999999999999999999999999999999() {
    // Arrange and Act
    String actualMatch =
        RegexUtils.getMatch("99999999-9999-9999-9999-999999999999", RegexUtils.UUID_PATTERN, 0);

    // Assert
    assertEquals("99999999-9999-9999-9999-999999999999", actualMatch);
  }
}
