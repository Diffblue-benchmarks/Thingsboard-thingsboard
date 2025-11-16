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
package org.thingsboard.rule.engine.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbRuleNodeMathFunctionTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbRuleNodeMathFunctionType#getMaxArgs()}
   *   <li>{@link TbRuleNodeMathFunctionType#getMinArgs()}
   *   <li>{@link TbRuleNodeMathFunctionType#isIntegerResult()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int TbRuleNodeMathFunctionType.getMaxArgs()",
    "int TbRuleNodeMathFunctionType.getMinArgs()",
    "boolean TbRuleNodeMathFunctionType.isIntegerResult()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbRuleNodeMathFunctionType valueOfResult = TbRuleNodeMathFunctionType.valueOf("ADD");

    // Act
    int actualMaxArgs = valueOfResult.getMaxArgs();
    int actualMinArgs = valueOfResult.getMinArgs();

    // Assert
    assertEquals(2, actualMaxArgs);
    assertEquals(2, actualMinArgs);
    assertFalse(valueOfResult.isIntegerResult());
  }
}
