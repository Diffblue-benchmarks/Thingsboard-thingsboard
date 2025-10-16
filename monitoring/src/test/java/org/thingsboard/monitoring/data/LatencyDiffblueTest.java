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
package org.thingsboard.monitoring.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LatencyDiffblueTest {
  /**
   * Test {@link Latency#getFormattedValue()}.
   *
   * <p>Method under test: {@link Latency#getFormattedValue()}
   */
  @Test
  @DisplayName("Test getFormattedValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Latency.getFormattedValue()"})
  void testGetFormattedValue() {
    // Arrange, Act and Assert
    assertEquals("10.00 ms", Latency.of("Key", 10.0d).getFormattedValue());
  }

  /**
   * Test {@link Latency#equals(Object)}, and {@link Latency#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Latency#equals(Object)}
   *   <li>{@link Latency#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Latency.equals(Object)", "int Latency.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Latency ofResult = Latency.of("Key", 10.0d);
    Latency ofResult2 = Latency.of("Key", 10.0d);

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link Latency#equals(Object)}, and {@link Latency#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Latency#equals(Object)}
   *   <li>{@link Latency#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Latency.equals(Object)", "int Latency.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Latency ofResult = Latency.of(null, 10.0d);
    Latency ofResult2 = Latency.of(null, 10.0d);

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link Latency#equals(Object)}, and {@link Latency#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Latency#equals(Object)}
   *   <li>{@link Latency#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Latency.equals(Object)", "int Latency.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Latency ofResult = Latency.of("Key", 10.0d);

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link Latency#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Latency#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Latency.equals(Object)", "int Latency.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Latency.of("Key", 10.0d), 1);
  }

  /**
   * Test {@link Latency#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Latency#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Latency.equals(Object)", "int Latency.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Latency ofResult = Latency.of(null, 10.0d);

    // Act and Assert
    assertNotEquals(ofResult, Latency.of("Key", 10.0d));
  }

  /**
   * Test {@link Latency#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Latency#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Latency.equals(Object)", "int Latency.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Latency ofResult = Latency.of("org.thingsboard.monitoring.data.Latency", 10.0d);

    // Act and Assert
    assertNotEquals(ofResult, Latency.of("Key", 10.0d));
  }

  /**
   * Test {@link Latency#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Latency#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Latency.equals(Object)", "int Latency.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Latency ofResult = Latency.of("Key", 0.5d);

    // Act and Assert
    assertNotEquals(ofResult, Latency.of("Key", 10.0d));
  }

  /**
   * Test {@link Latency#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Latency#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Latency.equals(Object)", "int Latency.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Latency.of("Key", 10.0d), null);
  }

  /**
   * Test {@link Latency#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Latency#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Latency.equals(Object)", "int Latency.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Latency.of("Key", 10.0d), "Different type to Latency");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Latency#toString()}
   *   <li>{@link Latency#getKey()}
   *   <li>{@link Latency#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String Latency.getKey()",
    "double Latency.getValue()",
    "String Latency.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Latency ofResult = Latency.of("Key", 10.0d);

    // Act
    String actualToStringResult = ofResult.toString();
    String actualKey = ofResult.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("Latency(key=Key, value=10.0)", actualToStringResult);
    assertEquals(10.0d, ofResult.getValue());
  }

  /**
   * Test {@link Latency#of(String, double)}.
   *
   * <p>Method under test: {@link Latency#of(String, double)}
   */
  @Test
  @DisplayName("Test of(String, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Latency Latency.of(String, double)"})
  void testOf() {
    // Arrange and Act
    Latency actualOfResult = Latency.of("Key", 10.0d);

    // Assert
    assertEquals("10.00 ms", actualOfResult.getFormattedValue());
    assertEquals("Key", actualOfResult.getKey());
    assertEquals(10.0d, actualOfResult.getValue());
  }
}
