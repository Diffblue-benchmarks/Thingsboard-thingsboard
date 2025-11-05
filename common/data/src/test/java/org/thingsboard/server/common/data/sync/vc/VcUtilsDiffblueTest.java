package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VcUtilsDiffblueTest {
  /**
   * Test {@link VcUtils#checkBranchName(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link VcUtils#checkBranchName(String)}
   */
  @Test
  @DisplayName("Test checkBranchName(String); when '42'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VcUtils.checkBranchName(String)"})
  void testCheckBranchName_when42_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> VcUtils.checkBranchName("42"));
  }

  /**
   * Test {@link VcUtils#checkBranchName(String)}.
   *
   * <ul>
   *   <li>When {@code contains whitespace}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link VcUtils#checkBranchName(String)}
   */
  @Test
  @DisplayName(
      "Test checkBranchName(String); when 'contains whitespace'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VcUtils.checkBranchName(String)"})
  void testCheckBranchName_whenContainsWhitespace_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> VcUtils.checkBranchName("contains whitespace"));
  }

  /**
   * Test {@link VcUtils#checkBranchName(String)}.
   *
   * <ul>
   *   <li>When {@code ..}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link VcUtils#checkBranchName(String)}
   */
  @Test
  @DisplayName("Test checkBranchName(String); when '..'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VcUtils.checkBranchName(String)"})
  void testCheckBranchName_whenDotDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> VcUtils.checkBranchName(".."));
  }

  /**
   * Test {@link VcUtils#checkBranchName(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link VcUtils#checkBranchName(String)}
   */
  @Test
  @DisplayName("Test checkBranchName(String); when empty string; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VcUtils.checkBranchName(String)"})
  void testCheckBranchName_whenEmptyString_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> VcUtils.checkBranchName(""));
  }

  /**
   * Test {@link VcUtils#checkBranchName(String)}.
   *
   * <ul>
   *   <li>When {@code janedoe/featurebranch}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link VcUtils#checkBranchName(String)}
   */
  @Test
  @DisplayName("Test checkBranchName(String); when 'janedoe/featurebranch'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VcUtils.checkBranchName(String)"})
  void testCheckBranchName_whenJanedoeFeaturebranch_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> VcUtils.checkBranchName("janedoe/featurebranch"));
  }

  /**
   * Test {@link VcUtils#checkBranchName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link VcUtils#checkBranchName(String)}
   */
  @Test
  @DisplayName("Test checkBranchName(String); when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VcUtils.checkBranchName(String)"})
  void testCheckBranchName_whenNull_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> VcUtils.checkBranchName(null));
  }

  /**
   * Test {@link VcUtils#checkBranchName(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link VcUtils#checkBranchName(String)}
   */
  @Test
  @DisplayName("Test checkBranchName(String); when '/'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VcUtils.checkBranchName(String)"})
  void testCheckBranchName_whenSlash_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> VcUtils.checkBranchName("/"));
  }
}
