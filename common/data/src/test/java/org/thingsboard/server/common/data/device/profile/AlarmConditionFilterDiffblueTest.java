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
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.EntityKeyValueType;
import org.thingsboard.server.common.data.query.KeyFilterPredicate;

class AlarmConditionFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmConditionFilter#equals(Object)}
   *   <li>{@link AlarmConditionFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(null);
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(null);
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertEquals(alarmConditionFilter, alarmConditionFilter2);
    int expectedHashCodeResult = alarmConditionFilter.hashCode();
    assertEquals(expectedHashCodeResult, alarmConditionFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmConditionFilter#equals(Object)}
   *   <li>{@link AlarmConditionFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertEquals(alarmConditionFilter, alarmConditionFilter);
    int expectedHashCodeResult = alarmConditionFilter.hashCode();
    assertEquals(expectedHashCodeResult, alarmConditionFilter.hashCode());
  }

  /**
   * Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(null, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(null);
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(null);
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue(alarmConditionFilter);
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter3 = new AlarmConditionFilter();
    alarmConditionFilter3.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter3.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter3.setValue("Value");
    alarmConditionFilter3.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter2, alarmConditionFilter3);
  }

  /**
   * Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue(null);
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(null);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.NUMERIC);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(null);
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(null);
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue(null);
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue(null);
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(null);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(null);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, null);
  }

  /**
   * Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, "Different type to AlarmConditionFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AlarmConditionFilter}
   *   <li>{@link AlarmConditionFilter#setKey(AlarmConditionFilterKey)}
   *   <li>{@link AlarmConditionFilter#setPredicate(KeyFilterPredicate)}
   *   <li>{@link AlarmConditionFilter#setValue(Object)}
   *   <li>{@link AlarmConditionFilter#setValueType(EntityKeyValueType)}
   *   <li>{@link AlarmConditionFilter#toString()}
   *   <li>{@link AlarmConditionFilter#getKey()}
   *   <li>{@link AlarmConditionFilter#getPredicate()}
   *   <li>{@link AlarmConditionFilter#getValue()}
   *   <li>{@link AlarmConditionFilter#getValueType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmConditionFilter actualAlarmConditionFilter = new AlarmConditionFilter();
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    actualAlarmConditionFilter.setKey(key);
    KeyFilterPredicate predicate = mock(KeyFilterPredicate.class);
    actualAlarmConditionFilter.setPredicate(predicate);
    actualAlarmConditionFilter.setValue("Value");
    actualAlarmConditionFilter.setValueType(EntityKeyValueType.STRING);
    actualAlarmConditionFilter.toString();
    AlarmConditionFilterKey actualKey = actualAlarmConditionFilter.getKey();
    KeyFilterPredicate actualPredicate = actualAlarmConditionFilter.getPredicate();
    Object actualValue = actualAlarmConditionFilter.getValue();

    // Assert that nothing has changed
    assertEquals("Value", actualValue);
    assertEquals(EntityKeyValueType.STRING, actualAlarmConditionFilter.getValueType());
    assertSame(key, actualKey);
    assertSame(predicate, actualPredicate);
  }
}
