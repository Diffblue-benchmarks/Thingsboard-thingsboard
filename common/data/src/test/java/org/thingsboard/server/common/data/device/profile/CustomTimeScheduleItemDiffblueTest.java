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
package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CustomTimeScheduleItemDiffblueTest {
  /**
   * Test {@link CustomTimeScheduleItem#equals(Object)}, and {@link CustomTimeScheduleItem#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomTimeScheduleItem#equals(Object)}
   *   <li>{@link CustomTimeScheduleItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeScheduleItem.equals(Object)", "int CustomTimeScheduleItem.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomTimeScheduleItem customTimeScheduleItem = new CustomTimeScheduleItem();
    customTimeScheduleItem.setDayOfWeek(1);
    customTimeScheduleItem.setEnabled(true);
    customTimeScheduleItem.setEndsOn(1L);
    customTimeScheduleItem.setStartsOn(1L);

    CustomTimeScheduleItem customTimeScheduleItem2 = new CustomTimeScheduleItem();
    customTimeScheduleItem2.setDayOfWeek(1);
    customTimeScheduleItem2.setEnabled(true);
    customTimeScheduleItem2.setEndsOn(1L);
    customTimeScheduleItem2.setStartsOn(1L);

    // Act and Assert
    assertEquals(customTimeScheduleItem, customTimeScheduleItem2);
    int expectedHashCodeResult = customTimeScheduleItem.hashCode();
    assertEquals(expectedHashCodeResult, customTimeScheduleItem2.hashCode());
  }

  /**
   * Test {@link CustomTimeScheduleItem#equals(Object)}, and {@link CustomTimeScheduleItem#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomTimeScheduleItem#equals(Object)}
   *   <li>{@link CustomTimeScheduleItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeScheduleItem.equals(Object)", "int CustomTimeScheduleItem.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomTimeScheduleItem customTimeScheduleItem = new CustomTimeScheduleItem();
    customTimeScheduleItem.setDayOfWeek(1);
    customTimeScheduleItem.setEnabled(true);
    customTimeScheduleItem.setEndsOn(1L);
    customTimeScheduleItem.setStartsOn(1L);

    // Act and Assert
    assertEquals(customTimeScheduleItem, customTimeScheduleItem);
    int expectedHashCodeResult = customTimeScheduleItem.hashCode();
    assertEquals(expectedHashCodeResult, customTimeScheduleItem.hashCode());
  }

  /**
   * Test {@link CustomTimeScheduleItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomTimeScheduleItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeScheduleItem.equals(Object)", "int CustomTimeScheduleItem.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomTimeScheduleItem customTimeScheduleItem = new CustomTimeScheduleItem();
    customTimeScheduleItem.setDayOfWeek(3);
    customTimeScheduleItem.setEnabled(true);
    customTimeScheduleItem.setEndsOn(1L);
    customTimeScheduleItem.setStartsOn(1L);

    CustomTimeScheduleItem customTimeScheduleItem2 = new CustomTimeScheduleItem();
    customTimeScheduleItem2.setDayOfWeek(1);
    customTimeScheduleItem2.setEnabled(true);
    customTimeScheduleItem2.setEndsOn(1L);
    customTimeScheduleItem2.setStartsOn(1L);

    // Act and Assert
    assertNotEquals(customTimeScheduleItem, customTimeScheduleItem2);
  }

  /**
   * Test {@link CustomTimeScheduleItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomTimeScheduleItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeScheduleItem.equals(Object)", "int CustomTimeScheduleItem.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomTimeScheduleItem customTimeScheduleItem = new CustomTimeScheduleItem();
    customTimeScheduleItem.setDayOfWeek(1);
    customTimeScheduleItem.setEnabled(false);
    customTimeScheduleItem.setEndsOn(1L);
    customTimeScheduleItem.setStartsOn(1L);

    CustomTimeScheduleItem customTimeScheduleItem2 = new CustomTimeScheduleItem();
    customTimeScheduleItem2.setDayOfWeek(1);
    customTimeScheduleItem2.setEnabled(true);
    customTimeScheduleItem2.setEndsOn(1L);
    customTimeScheduleItem2.setStartsOn(1L);

    // Act and Assert
    assertNotEquals(customTimeScheduleItem, customTimeScheduleItem2);
  }

  /**
   * Test {@link CustomTimeScheduleItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomTimeScheduleItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeScheduleItem.equals(Object)", "int CustomTimeScheduleItem.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CustomTimeScheduleItem customTimeScheduleItem = new CustomTimeScheduleItem();
    customTimeScheduleItem.setDayOfWeek(1);
    customTimeScheduleItem.setEnabled(true);
    customTimeScheduleItem.setEndsOn(3L);
    customTimeScheduleItem.setStartsOn(1L);

    CustomTimeScheduleItem customTimeScheduleItem2 = new CustomTimeScheduleItem();
    customTimeScheduleItem2.setDayOfWeek(1);
    customTimeScheduleItem2.setEnabled(true);
    customTimeScheduleItem2.setEndsOn(1L);
    customTimeScheduleItem2.setStartsOn(1L);

    // Act and Assert
    assertNotEquals(customTimeScheduleItem, customTimeScheduleItem2);
  }

  /**
   * Test {@link CustomTimeScheduleItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomTimeScheduleItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeScheduleItem.equals(Object)", "int CustomTimeScheduleItem.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CustomTimeScheduleItem customTimeScheduleItem = new CustomTimeScheduleItem();
    customTimeScheduleItem.setDayOfWeek(1);
    customTimeScheduleItem.setEnabled(true);
    customTimeScheduleItem.setEndsOn(1L);
    customTimeScheduleItem.setStartsOn(3L);

    CustomTimeScheduleItem customTimeScheduleItem2 = new CustomTimeScheduleItem();
    customTimeScheduleItem2.setDayOfWeek(1);
    customTimeScheduleItem2.setEnabled(true);
    customTimeScheduleItem2.setEndsOn(1L);
    customTimeScheduleItem2.setStartsOn(1L);

    // Act and Assert
    assertNotEquals(customTimeScheduleItem, customTimeScheduleItem2);
  }

  /**
   * Test {@link CustomTimeScheduleItem#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomTimeScheduleItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeScheduleItem.equals(Object)", "int CustomTimeScheduleItem.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomTimeScheduleItem customTimeScheduleItem = new CustomTimeScheduleItem();
    customTimeScheduleItem.setDayOfWeek(1);
    customTimeScheduleItem.setEnabled(true);
    customTimeScheduleItem.setEndsOn(1L);
    customTimeScheduleItem.setStartsOn(1L);

    // Act and Assert
    assertNotEquals(customTimeScheduleItem, null);
  }

  /**
   * Test {@link CustomTimeScheduleItem#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomTimeScheduleItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeScheduleItem.equals(Object)", "int CustomTimeScheduleItem.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomTimeScheduleItem customTimeScheduleItem = new CustomTimeScheduleItem();
    customTimeScheduleItem.setDayOfWeek(1);
    customTimeScheduleItem.setEnabled(true);
    customTimeScheduleItem.setEndsOn(1L);
    customTimeScheduleItem.setStartsOn(1L);

    // Act and Assert
    assertNotEquals(customTimeScheduleItem, "Different type to CustomTimeScheduleItem");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomTimeScheduleItem}
   *   <li>{@link CustomTimeScheduleItem#setDayOfWeek(int)}
   *   <li>{@link CustomTimeScheduleItem#setEnabled(boolean)}
   *   <li>{@link CustomTimeScheduleItem#setEndsOn(long)}
   *   <li>{@link CustomTimeScheduleItem#setStartsOn(long)}
   *   <li>{@link CustomTimeScheduleItem#toString()}
   *   <li>{@link CustomTimeScheduleItem#getDayOfWeek()}
   *   <li>{@link CustomTimeScheduleItem#getEndsOn()}
   *   <li>{@link CustomTimeScheduleItem#getStartsOn()}
   *   <li>{@link CustomTimeScheduleItem#isEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomTimeScheduleItem.<init>()", "int CustomTimeScheduleItem.getDayOfWeek()",
      "long CustomTimeScheduleItem.getEndsOn()", "long CustomTimeScheduleItem.getStartsOn()",
      "boolean CustomTimeScheduleItem.isEnabled()", "void CustomTimeScheduleItem.setDayOfWeek(int)",
      "void CustomTimeScheduleItem.setEnabled(boolean)", "void CustomTimeScheduleItem.setEndsOn(long)",
      "void CustomTimeScheduleItem.setStartsOn(long)", "String CustomTimeScheduleItem.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    CustomTimeScheduleItem actualCustomTimeScheduleItem = new CustomTimeScheduleItem();
    actualCustomTimeScheduleItem.setDayOfWeek(1);
    actualCustomTimeScheduleItem.setEnabled(true);
    actualCustomTimeScheduleItem.setEndsOn(1L);
    actualCustomTimeScheduleItem.setStartsOn(1L);
    String actualToStringResult = actualCustomTimeScheduleItem.toString();
    int actualDayOfWeek = actualCustomTimeScheduleItem.getDayOfWeek();
    long actualEndsOn = actualCustomTimeScheduleItem.getEndsOn();
    long actualStartsOn = actualCustomTimeScheduleItem.getStartsOn();

    // Assert
    assertEquals("CustomTimeScheduleItem(enabled=true, dayOfWeek=1, startsOn=1, endsOn=1)", actualToStringResult);
    assertEquals(1, actualDayOfWeek);
    assertEquals(1L, actualEndsOn);
    assertEquals(1L, actualStartsOn);
    assertTrue(actualCustomTimeScheduleItem.isEnabled());
  }
}
