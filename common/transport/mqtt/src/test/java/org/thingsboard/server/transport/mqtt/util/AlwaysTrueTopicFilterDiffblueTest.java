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
package org.thingsboard.server.transport.mqtt.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlwaysTrueTopicFilterDiffblueTest {
  /**
   * Test {@link AlwaysTrueTopicFilter#filter(String)}.
   *
   * <p>Method under test: {@link AlwaysTrueTopicFilter#filter(String)}
   */
  @Test
  @DisplayName("Test filter(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlwaysTrueTopicFilter.filter(String)"})
  void testFilter() {
    // Arrange, Act and Assert
    assertTrue(new AlwaysTrueTopicFilter().filter("Topic"));
  }

  /**
   * Test {@link AlwaysTrueTopicFilter#equals(Object)}, and {@link
   * AlwaysTrueTopicFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlwaysTrueTopicFilter#equals(Object)}
   *   <li>{@link AlwaysTrueTopicFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlwaysTrueTopicFilter.equals(Object)",
    "int AlwaysTrueTopicFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlwaysTrueTopicFilter alwaysTrueTopicFilter = new AlwaysTrueTopicFilter();
    AlwaysTrueTopicFilter alwaysTrueTopicFilter2 = new AlwaysTrueTopicFilter();

    // Act and Assert
    assertEquals(alwaysTrueTopicFilter, alwaysTrueTopicFilter2);
    assertEquals(alwaysTrueTopicFilter.hashCode(), alwaysTrueTopicFilter2.hashCode());
  }

  /**
   * Test {@link AlwaysTrueTopicFilter#equals(Object)}, and {@link
   * AlwaysTrueTopicFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlwaysTrueTopicFilter#equals(Object)}
   *   <li>{@link AlwaysTrueTopicFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlwaysTrueTopicFilter.equals(Object)",
    "int AlwaysTrueTopicFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlwaysTrueTopicFilter alwaysTrueTopicFilter = new AlwaysTrueTopicFilter();

    // Act and Assert
    assertEquals(alwaysTrueTopicFilter, alwaysTrueTopicFilter);
    int expectedHashCodeResult = alwaysTrueTopicFilter.hashCode();
    assertEquals(expectedHashCodeResult, alwaysTrueTopicFilter.hashCode());
  }

  /**
   * Test {@link AlwaysTrueTopicFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlwaysTrueTopicFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlwaysTrueTopicFilter.equals(Object)",
    "int AlwaysTrueTopicFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlwaysTrueTopicFilter(), 1);
  }

  /**
   * Test {@link AlwaysTrueTopicFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlwaysTrueTopicFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlwaysTrueTopicFilter.equals(Object)",
    "int AlwaysTrueTopicFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlwaysTrueTopicFilter(), null);
  }

  /**
   * Test {@link AlwaysTrueTopicFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlwaysTrueTopicFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlwaysTrueTopicFilter.equals(Object)",
    "int AlwaysTrueTopicFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlwaysTrueTopicFilter(), "Different type to AlwaysTrueTopicFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AlwaysTrueTopicFilter}
   *   <li>{@link AlwaysTrueTopicFilter#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlwaysTrueTopicFilter.<init>()",
    "String AlwaysTrueTopicFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("AlwaysTrueTopicFilter()", new AlwaysTrueTopicFilter().toString());
  }
}
