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
package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SystemUtilDiffblueTest {
  /**
   * Test {@link SystemUtil#getDiscSpaceUsage()}.
   *
   * <p>Method under test: {@link SystemUtil#getDiscSpaceUsage()}
   */
  @Test
  @DisplayName("Test getDiscSpaceUsage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional SystemUtil.getDiscSpaceUsage()"})
  void testGetDiscSpaceUsage() {
    // Arrange and Act
    Optional<Integer> actualDiscSpaceUsage = SystemUtil.getDiscSpaceUsage();

    // Assert
    assertEquals(35, actualDiscSpaceUsage.get().intValue());
    assertTrue(actualDiscSpaceUsage.isPresent());
  }

  /**
   * Test {@link SystemUtil#getTotalDiscSpace()}.
   *
   * <p>Method under test: {@link SystemUtil#getTotalDiscSpace()}
   */
  @Test
  @DisplayName("Test getTotalDiscSpace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional SystemUtil.getTotalDiscSpace()"})
  void testGetTotalDiscSpace() {
    // Arrange and Act
    Optional<Long> actualTotalDiscSpace = SystemUtil.getTotalDiscSpace();

    // Assert
    assertEquals(85819633664L, actualTotalDiscSpace.get().longValue());
    assertTrue(actualTotalDiscSpace.isPresent());
  }
}
