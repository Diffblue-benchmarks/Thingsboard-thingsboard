package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VcUtilsDiffblueTest {
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VcUtils.checkBranchName(String)"})
  void testCheckBranchName_whenDotDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> VcUtils.checkBranchName(".."));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VcUtils.checkBranchName(String)"})
  void testCheckBranchName_whenSlash_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> VcUtils.checkBranchName("/"));
  }
}
