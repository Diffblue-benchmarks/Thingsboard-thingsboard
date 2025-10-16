/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.sync.vc;

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
