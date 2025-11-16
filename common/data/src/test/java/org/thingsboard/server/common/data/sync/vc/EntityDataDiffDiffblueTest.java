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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;

class EntityDataDiffDiffblueTest {
  /**
   * Test {@link EntityDataDiff#equals(Object)}, and {@link EntityDataDiff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataDiff#equals(Object)}
   *   <li>{@link EntityDataDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityDataDiff.equals(Object)", "int EntityDataDiff.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityDataDiff entityDataDiff = new EntityDataDiff(null, new EntityExportData<>());
    EntityDataDiff entityDataDiff2 = new EntityDataDiff(null, new EntityExportData<>());

    // Act and Assert
    assertEquals(entityDataDiff, entityDataDiff2);
    assertEquals(entityDataDiff.hashCode(), entityDataDiff2.hashCode());
  }

  /**
   * Test {@link EntityDataDiff#equals(Object)}, and {@link EntityDataDiff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataDiff#equals(Object)}
   *   <li>{@link EntityDataDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityDataDiff.equals(Object)", "int EntityDataDiff.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityDataDiff entityDataDiff = new EntityDataDiff(new EntityExportData<>(), null);
    EntityDataDiff entityDataDiff2 = new EntityDataDiff(new EntityExportData<>(), null);

    // Act and Assert
    assertEquals(entityDataDiff, entityDataDiff2);
    assertEquals(entityDataDiff.hashCode(), entityDataDiff2.hashCode());
  }
}
