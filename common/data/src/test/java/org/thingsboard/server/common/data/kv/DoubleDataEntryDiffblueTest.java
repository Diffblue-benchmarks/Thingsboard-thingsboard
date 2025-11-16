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
package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DoubleDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoubleDataEntry#DoubleDataEntry(String, Double)}
   *   <li>{@link DoubleDataEntry#toString()}
   *   <li>{@link DoubleDataEntry#getDataType()}
   *   <li>{@link DoubleDataEntry#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DoubleDataEntry.<init>(String, Double)",
    "DataType DoubleDataEntry.getDataType()",
    "Object DoubleDataEntry.getValue()",
    "String DoubleDataEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DoubleDataEntry actualDoubleDataEntry = new DoubleDataEntry("Key", 10.0d);
    String actualToStringResult = actualDoubleDataEntry.toString();
    DataType actualDataType = actualDoubleDataEntry.getDataType();
    Object actualValue = actualDoubleDataEntry.getValue();

    // Assert
    assertEquals("DoubleDataEntry{value=10.0} BasicKvEntry{key='Key'}", actualToStringResult);
    assertEquals("Key", actualDoubleDataEntry.getKey());
    assertEquals(10.0d, ((Double) actualValue).doubleValue());
    assertEquals(DataType.DOUBLE, actualDataType);
  }

  /**
   * Test {@link DoubleDataEntry#getDoubleValue()}.
   *
   * <p>Method under test: {@link DoubleDataEntry#getDoubleValue()}
   */
  @Test
  @DisplayName("Test getDoubleValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DoubleDataEntry.getDoubleValue()"})
  void testGetDoubleValue() {
    // Arrange and Act
    Optional<Double> actualDoubleValue = new DoubleDataEntry("Key", 10.0d).getDoubleValue();

    // Assert
    assertEquals(10.0d, actualDoubleValue.get().doubleValue());
    assertTrue(actualDoubleValue.isPresent());
  }

  /**
   * Test {@link DoubleDataEntry#equals(Object)}, and {@link DoubleDataEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoubleDataEntry#equals(Object)}
   *   <li>{@link DoubleDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DoubleDataEntry.equals(Object)", "int DoubleDataEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DoubleDataEntry doubleDataEntry = new DoubleDataEntry("Key", 10.0d);
    DoubleDataEntry doubleDataEntry2 = new DoubleDataEntry("Key", 10.0d);

    // Act and Assert
    assertEquals(doubleDataEntry, doubleDataEntry2);
    assertEquals(doubleDataEntry.hashCode(), doubleDataEntry2.hashCode());
  }

  /**
   * Test {@link DoubleDataEntry#equals(Object)}, and {@link DoubleDataEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoubleDataEntry#equals(Object)}
   *   <li>{@link DoubleDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DoubleDataEntry.equals(Object)", "int DoubleDataEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DoubleDataEntry doubleDataEntry = new DoubleDataEntry("Key", 10.0d);

    // Act and Assert
    assertEquals(doubleDataEntry, doubleDataEntry);
    int expectedHashCodeResult = doubleDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, doubleDataEntry.hashCode());
  }

  /**
   * Test {@link DoubleDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoubleDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DoubleDataEntry.equals(Object)", "int DoubleDataEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DoubleDataEntry doubleDataEntry =
        new DoubleDataEntry("org.thingsboard.server.common.data.kv.DoubleDataEntry", 10.0d);

    // Act and Assert
    assertNotEquals(doubleDataEntry, new DoubleDataEntry("Key", 10.0d));
  }

  /**
   * Test {@link DoubleDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoubleDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DoubleDataEntry.equals(Object)", "int DoubleDataEntry.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleDataEntry("Key", 10.0d), null);
  }

  /**
   * Test {@link DoubleDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoubleDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DoubleDataEntry.equals(Object)", "int DoubleDataEntry.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleDataEntry("Key", 10.0d), "Different type to DoubleDataEntry");
  }

  /**
   * Test {@link DoubleDataEntry#getValueAsString()}.
   *
   * <p>Method under test: {@link DoubleDataEntry#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DoubleDataEntry.getValueAsString()"})
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("10.0", new DoubleDataEntry("Key", 10.0d).getValueAsString());
  }
}
