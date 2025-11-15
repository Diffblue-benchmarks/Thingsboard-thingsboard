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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.DynamicValue;
import org.thingsboard.server.common.data.query.DynamicValueSourceType;

class CustomTimeScheduleDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomTimeSchedule#equals(Object)}
   *   <li>{@link CustomTimeSchedule#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertEquals(customTimeSchedule, customTimeSchedule2);
    int expectedHashCodeResult = customTimeSchedule.hashCode();
    assertEquals(expectedHashCodeResult, customTimeSchedule2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomTimeSchedule#equals(Object)}
   *   <li>{@link CustomTimeSchedule#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(null);
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(null);
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertEquals(customTimeSchedule, customTimeSchedule2);
    int expectedHashCodeResult = customTimeSchedule.hashCode();
    assertEquals(expectedHashCodeResult, customTimeSchedule2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomTimeSchedule#equals(Object)}
   *   <li>{@link CustomTimeSchedule#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone(null);

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone(null);

    // Act and Assert
    assertEquals(customTimeSchedule, customTimeSchedule2);
    int expectedHashCodeResult = customTimeSchedule.hashCode();
    assertEquals(expectedHashCodeResult, customTimeSchedule2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomTimeSchedule#equals(Object)}
   *   <li>{@link CustomTimeSchedule#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    // Act and Assert
    assertEquals(customTimeSchedule, customTimeSchedule);
    int expectedHashCodeResult = customTimeSchedule.hashCode();
    assertEquals(expectedHashCodeResult, customTimeSchedule.hashCode());
  }

  /**
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(null, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, customTimeSchedule2);
  }

  /**
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(null);
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, customTimeSchedule2);
  }

  /**
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(mock(DynamicValue.class));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, customTimeSchedule2);
  }

  /**
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CustomTimeScheduleItem customTimeScheduleItem = new CustomTimeScheduleItem();
    customTimeScheduleItem.setDayOfWeek(1);
    customTimeScheduleItem.setEnabled(true);
    customTimeScheduleItem.setEndsOn(1L);
    customTimeScheduleItem.setStartsOn(1L);

    ArrayList<CustomTimeScheduleItem> items = new ArrayList<>();
    items.add(customTimeScheduleItem);

    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(items);
    customTimeSchedule.setTimezone("UTC");

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, customTimeSchedule2);
  }

  /**
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("Europe/London");

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, customTimeSchedule2);
  }

  /**
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone(null);

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, customTimeSchedule2);
  }

  /**
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, null);
  }

  /**
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, "Different type to CustomTimeSchedule");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomTimeSchedule}
   *   <li>{@link CustomTimeSchedule#setDynamicValue(DynamicValue)}
   *   <li>{@link CustomTimeSchedule#setItems(List)}
   *   <li>{@link CustomTimeSchedule#setTimezone(String)}
   *   <li>{@link CustomTimeSchedule#toString()}
   *   <li>{@link CustomTimeSchedule#getDynamicValue()}
   *   <li>{@link CustomTimeSchedule#getItems()}
   *   <li>{@link CustomTimeSchedule#getTimezone()}
   *   <li>{@link CustomTimeSchedule#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CustomTimeSchedule actualCustomTimeSchedule = new CustomTimeSchedule();
    DynamicValue<String> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    actualCustomTimeSchedule.setDynamicValue(dynamicValue);
    ArrayList<CustomTimeScheduleItem> items = new ArrayList<>();
    actualCustomTimeSchedule.setItems(items);
    actualCustomTimeSchedule.setTimezone("UTC");
    String actualToStringResult = actualCustomTimeSchedule.toString();
    DynamicValue<String> actualDynamicValue = actualCustomTimeSchedule.getDynamicValue();
    List<CustomTimeScheduleItem> actualItems = actualCustomTimeSchedule.getItems();
    String actualTimezone = actualCustomTimeSchedule.getTimezone();

    // Assert that nothing has changed
    assertEquals("CustomTimeSchedule(timezone=UTC, items=[], dynamicValue=DynamicValue(resolvedValue=null, sourceType"
        + "=CURRENT_TENANT, sourceAttribute=Source Attribute, inherit=false))", actualToStringResult);
    assertEquals("UTC", actualTimezone);
    assertEquals(AlarmScheduleType.CUSTOM, actualCustomTimeSchedule.getType());
    assertTrue(actualItems.isEmpty());
    assertSame(items, actualItems);
    assertSame(dynamicValue, actualDynamicValue);
  }
}
