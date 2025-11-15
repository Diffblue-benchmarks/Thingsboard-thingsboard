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
package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class AffectedUserFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AffectedUserFilter#equals(Object)}
   *   <li>{@link AffectedUserFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AffectedUserFilter affectedUserFilter = new AffectedUserFilter();
    AffectedUserFilter affectedUserFilter2 = new AffectedUserFilter();

    // Act and Assert
    assertEquals(affectedUserFilter, affectedUserFilter2);
    int expectedHashCodeResult = affectedUserFilter.hashCode();
    assertEquals(expectedHashCodeResult, affectedUserFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AffectedUserFilter#equals(Object)}
   *   <li>{@link AffectedUserFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AffectedUserFilter affectedUserFilter = new AffectedUserFilter();

    // Act and Assert
    assertEquals(affectedUserFilter, affectedUserFilter);
    int expectedHashCodeResult = affectedUserFilter.hashCode();
    assertEquals(expectedHashCodeResult, affectedUserFilter.hashCode());
  }

  /**
   * Method under test: {@link AffectedUserFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AffectedUserFilter(), 1);
  }

  /**
   * Method under test: {@link AffectedUserFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AffectedUserFilter(), null);
  }

  /**
   * Method under test: {@link AffectedUserFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AffectedUserFilter(), "Different type to AffectedUserFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AffectedUserFilter}
   *   <li>{@link AffectedUserFilter#toString()}
   *   <li>{@link AffectedUserFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AffectedUserFilter actualAffectedUserFilter = new AffectedUserFilter();
    String actualToStringResult = actualAffectedUserFilter.toString();

    // Assert
    assertEquals("AffectedUserFilter()", actualToStringResult);
    assertEquals(UsersFilterType.AFFECTED_USER, actualAffectedUserFilter.getType());
  }
}
