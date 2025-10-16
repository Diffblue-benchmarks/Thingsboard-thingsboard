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
package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TsValueDiffblueTest {
  /**
   * Test {@link TsValue#TsValue(long, String)}.
   *
   * <p>Method under test: {@link TsValue#TsValue(long, String)}
   */
  @Test
  @DisplayName("Test new TsValue(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsValue.<init>(long, String)"})
  void testNewTsValue() {
    // Arrange and Act
    TsValue actualTsValue = new TsValue(1L, "42");

    // Assert
    assertEquals("42", actualTsValue.getValue());
    assertNull(actualTsValue.getCount());
    assertEquals(1L, actualTsValue.getTs());
  }

  /**
   * Test {@link TsValue#TsValue(long, String, Long)}.
   *
   * <p>Method under test: {@link TsValue#TsValue(long, String, Long)}
   */
  @Test
  @DisplayName("Test new TsValue(long, String, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsValue.<init>(long, String, Long)"})
  void testNewTsValue2() {
    // Arrange and Act
    TsValue actualTsValue = new TsValue(1L, "42", 3L);

    // Assert
    assertEquals("42", actualTsValue.getValue());
    assertEquals(1L, actualTsValue.getTs());
    assertEquals(3L, actualTsValue.getCount().longValue());
  }

  /**
   * Test {@link TsValue#equals(Object)}, and {@link TsValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsValue#equals(Object)}
   *   <li>{@link TsValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsValue.equals(Object)", "int TsValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsValue tsValue = TsValue.EMPTY;
    TsValue tsValue2 = TsValue.EMPTY;

    // Act and Assert
    assertEquals(tsValue, tsValue2);
    assertEquals(tsValue.hashCode(), tsValue2.hashCode());
  }

  /**
   * Test {@link TsValue#equals(Object)}, and {@link TsValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsValue#equals(Object)}
   *   <li>{@link TsValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsValue.equals(Object)", "int TsValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42");
    TsValue tsValue2 = new TsValue(1L, "42");

    // Act and Assert
    assertEquals(tsValue, tsValue2);
    assertEquals(tsValue.hashCode(), tsValue2.hashCode());
  }

  /**
   * Test {@link TsValue#equals(Object)}, and {@link TsValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsValue#equals(Object)}
   *   <li>{@link TsValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsValue.equals(Object)", "int TsValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42", 3L);
    TsValue tsValue2 = new TsValue(1L, "42", 3L);

    // Act and Assert
    assertEquals(tsValue, tsValue2);
    assertEquals(tsValue.hashCode(), tsValue2.hashCode());
  }

  /**
   * Test {@link TsValue#equals(Object)}, and {@link TsValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsValue#equals(Object)}
   *   <li>{@link TsValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsValue.equals(Object)", "int TsValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsValue tsValue = TsValue.EMPTY;

    // Act and Assert
    assertEquals(tsValue, tsValue);
    int expectedHashCodeResult = tsValue.hashCode();
    assertEquals(expectedHashCodeResult, tsValue.hashCode());
  }

  /**
   * Test {@link TsValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsValue.equals(Object)", "int TsValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsValue(1L, "42"), TsValue.EMPTY);
  }

  /**
   * Test {@link TsValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsValue.equals(Object)", "int TsValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TsValue(0L, "42"), TsValue.EMPTY);
  }

  /**
   * Test {@link TsValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsValue.equals(Object)", "int TsValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42");

    // Act and Assert
    assertNotEquals(tsValue, new TsValue(1L, "42", 3L));
  }

  /**
   * Test {@link TsValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsValue.equals(Object)", "int TsValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TsValue tsValue = new TsValue(0L, null);

    // Act and Assert
    assertNotEquals(tsValue, TsValue.EMPTY);
  }

  /**
   * Test {@link TsValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsValue.equals(Object)", "int TsValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42", 3L);

    // Act and Assert
    assertNotEquals(tsValue, new TsValue(1L, "42"));
  }

  /**
   * Test {@link TsValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsValue.equals(Object)", "int TsValue.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TsValue.EMPTY, null);
  }

  /**
   * Test {@link TsValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsValue.equals(Object)", "int TsValue.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TsValue.EMPTY, "Different type to TsValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsValue#toString()}
   *   <li>{@link TsValue#getCount()}
   *   <li>{@link TsValue#getTs()}
   *   <li>{@link TsValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long TsValue.getCount()",
    "long TsValue.getTs()",
    "String TsValue.getValue()",
    "String TsValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42");

    // Act
    String actualToStringResult = tsValue.toString();
    Long actualCount = tsValue.getCount();
    long actualTs = tsValue.getTs();

    // Assert
    assertEquals("42", tsValue.getValue());
    assertEquals("TsValue(ts=1, value=42, count=null)", actualToStringResult);
    assertNull(actualCount);
    assertEquals(1L, actualTs);
  }
}
