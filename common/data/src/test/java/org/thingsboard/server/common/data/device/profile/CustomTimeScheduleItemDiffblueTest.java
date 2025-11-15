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
import org.junit.jupiter.api.Test;

class CustomTimeScheduleItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomTimeScheduleItem#equals(Object)}
   *   <li>{@link CustomTimeScheduleItem#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link CustomTimeScheduleItem#equals(Object)}
   *   <li>{@link CustomTimeScheduleItem#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link CustomTimeScheduleItem#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CustomTimeScheduleItem#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CustomTimeScheduleItem#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CustomTimeScheduleItem#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CustomTimeScheduleItem#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CustomTimeScheduleItem#equals(Object)}
   */
  @Test
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

    // Assert that nothing has changed
    assertEquals("CustomTimeScheduleItem(enabled=true, dayOfWeek=1, startsOn=1, endsOn=1)", actualToStringResult);
    assertEquals(1, actualDayOfWeek);
    assertEquals(1L, actualEndsOn);
    assertEquals(1L, actualStartsOn);
    assertTrue(actualCustomTimeScheduleItem.isEnabled());
  }
}
