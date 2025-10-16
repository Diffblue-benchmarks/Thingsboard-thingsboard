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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegexTopicFilterDiffblueTest {
  /**
   * Test {@link RegexTopicFilter#RegexTopicFilter(String)}.
   *
   * <p>Method under test: {@link RegexTopicFilter#RegexTopicFilter(String)}
   */
  @Test
  @DisplayName("Test new RegexTopicFilter(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegexTopicFilter.<init>(String)"})
  void testNewRegexTopicFilter() {
    // Arrange, Act and Assert
    assertEquals(".*", new RegexTopicFilter(".*").getRegex().pattern());
  }

  /**
   * Test {@link RegexTopicFilter#filter(String)}.
   *
   * <ul>
   *   <li>Given {@link RegexTopicFilter#RegexTopicFilter(String)} with regex is {@code .*}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RegexTopicFilter#filter(String)}
   */
  @Test
  @DisplayName(
      "Test filter(String); given RegexTopicFilter(String) with regex is '.*'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegexTopicFilter.filter(String)"})
  void testFilter_givenRegexTopicFilterWithRegexIsDotAsterisk_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new RegexTopicFilter(".*").filter("Topic"));
  }

  /**
   * Test {@link RegexTopicFilter#filter(String)}.
   *
   * <ul>
   *   <li>Given {@link RegexTopicFilter#RegexTopicFilter(String)} with regex is {@code U}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RegexTopicFilter#filter(String)}
   */
  @Test
  @DisplayName(
      "Test filter(String); given RegexTopicFilter(String) with regex is 'U'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegexTopicFilter.filter(String)"})
  void testFilter_givenRegexTopicFilterWithRegexIsU_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new RegexTopicFilter("U").filter("Topic"));
  }

  /**
   * Test {@link RegexTopicFilter#equals(Object)}, and {@link RegexTopicFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RegexTopicFilter#equals(Object)}
   *   <li>{@link RegexTopicFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegexTopicFilter.equals(Object)", "int RegexTopicFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RegexTopicFilter regexTopicFilter = new RegexTopicFilter(".*");

    // Act and Assert
    assertEquals(regexTopicFilter, regexTopicFilter);
    int expectedHashCodeResult = regexTopicFilter.hashCode();
    assertEquals(expectedHashCodeResult, regexTopicFilter.hashCode());
  }

  /**
   * Test {@link RegexTopicFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RegexTopicFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegexTopicFilter.equals(Object)", "int RegexTopicFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RegexTopicFilter regexTopicFilter = new RegexTopicFilter(".*");

    // Act and Assert
    assertNotEquals(regexTopicFilter, new RegexTopicFilter(".*"));
  }

  /**
   * Test {@link RegexTopicFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RegexTopicFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegexTopicFilter.equals(Object)", "int RegexTopicFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RegexTopicFilter(".*"), null);
  }

  /**
   * Test {@link RegexTopicFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RegexTopicFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegexTopicFilter.equals(Object)", "int RegexTopicFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RegexTopicFilter(".*"), "Different type to RegexTopicFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RegexTopicFilter#toString()}
   *   <li>{@link RegexTopicFilter#getRegex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.regex.Pattern RegexTopicFilter.getRegex()",
    "String RegexTopicFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    RegexTopicFilter regexTopicFilter = new RegexTopicFilter(".*");

    // Act
    String actualToStringResult = regexTopicFilter.toString();

    // Assert
    assertEquals(".*", regexTopicFilter.getRegex().pattern());
    assertEquals("RegexTopicFilter(regex=.*)", actualToStringResult);
  }
}
