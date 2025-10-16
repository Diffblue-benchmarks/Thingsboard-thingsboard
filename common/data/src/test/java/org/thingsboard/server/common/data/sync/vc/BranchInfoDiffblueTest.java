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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BranchInfoDiffblueTest {
  /**
   * Test {@link BranchInfo#equals(Object)}, and {@link BranchInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BranchInfo#equals(Object)}
   *   <li>{@link BranchInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BranchInfo.equals(Object)", "int BranchInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BranchInfo branchInfo = new BranchInfo("Name", true);
    BranchInfo branchInfo2 = new BranchInfo("Name", true);

    // Act and Assert
    assertEquals(branchInfo, branchInfo2);
    assertEquals(branchInfo.hashCode(), branchInfo2.hashCode());
  }

  /**
   * Test {@link BranchInfo#equals(Object)}, and {@link BranchInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BranchInfo#equals(Object)}
   *   <li>{@link BranchInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BranchInfo.equals(Object)", "int BranchInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BranchInfo branchInfo = new BranchInfo("Name", true);

    // Act and Assert
    assertEquals(branchInfo, branchInfo);
    int expectedHashCodeResult = branchInfo.hashCode();
    assertEquals(expectedHashCodeResult, branchInfo.hashCode());
  }

  /**
   * Test {@link BranchInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BranchInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BranchInfo.equals(Object)", "int BranchInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BranchInfo branchInfo = new BranchInfo(null, true);

    // Act and Assert
    assertNotEquals(branchInfo, new BranchInfo("Name", true));
  }

  /**
   * Test {@link BranchInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BranchInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BranchInfo.equals(Object)", "int BranchInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BranchInfo("Name", true), null);
  }

  /**
   * Test {@link BranchInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BranchInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BranchInfo.equals(Object)", "int BranchInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BranchInfo("Name", true), "Different type to BranchInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BranchInfo#BranchInfo(String, boolean)}
   *   <li>{@link BranchInfo#toString()}
   *   <li>{@link BranchInfo#getName()}
   *   <li>{@link BranchInfo#isDefault()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BranchInfo.<init>(String, boolean)",
    "String BranchInfo.getName()",
    "boolean BranchInfo.isDefault()",
    "String BranchInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BranchInfo actualBranchInfo = new BranchInfo("Name", true);
    String actualToStringResult = actualBranchInfo.toString();
    String actualName = actualBranchInfo.getName();

    // Assert
    assertEquals("BranchInfo(name=Name, isDefault=true)", actualToStringResult);
    assertEquals("Name", actualName);
    assertTrue(actualBranchInfo.isDefault());
  }
}
