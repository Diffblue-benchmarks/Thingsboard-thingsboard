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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.EntityKeyValueType;
import org.thingsboard.server.common.data.query.KeyFilterPredicate;

class AlarmConditionFilterDiffblueTest {
  /**
   * Test {@link AlarmConditionFilter#equals(Object)}, and {@link AlarmConditionFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmConditionFilter#equals(Object)}
   *   <li>{@link AlarmConditionFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(null);
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(null);
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertEquals(alarmConditionFilter, alarmConditionFilter2);
    assertEquals(alarmConditionFilter.hashCode(), alarmConditionFilter2.hashCode());
  }

  /**
   * Test {@link AlarmConditionFilter#equals(Object)}, and {@link AlarmConditionFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmConditionFilter#equals(Object)}
   *   <li>{@link AlarmConditionFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertEquals(alarmConditionFilter, alarmConditionFilter);
    int expectedHashCodeResult = alarmConditionFilter.hashCode();
    assertEquals(expectedHashCodeResult, alarmConditionFilter.hashCode());
  }

  /**
   * Test {@link AlarmConditionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Test {@link AlarmConditionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(null, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Test {@link AlarmConditionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(null);
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Test {@link AlarmConditionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(null);
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Test {@link AlarmConditionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue(alarmConditionFilter);
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter3 = new AlarmConditionFilter();
    alarmConditionFilter3.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter3.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter3.setValue("Value");
    alarmConditionFilter3.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter2, alarmConditionFilter3);
  }

  /**
   * Test {@link AlarmConditionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue(null);
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Test {@link AlarmConditionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(null);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Test {@link AlarmConditionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.NUMERIC);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Test {@link AlarmConditionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
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
   * Test {@link AlarmConditionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue(null);
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue(null);
    alarmConditionFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Test {@link AlarmConditionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(null);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(null);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, alarmConditionFilter2);
  }

  /**
   * Test {@link AlarmConditionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, null);
  }

  /**
   * Test {@link AlarmConditionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilter.equals(Object)",
    "int AlarmConditionFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(alarmConditionFilter, "Different type to AlarmConditionFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmConditionFilter.<init>()",
    "AlarmConditionFilterKey AlarmConditionFilter.getKey()",
    "KeyFilterPredicate AlarmConditionFilter.getPredicate()",
    "Object AlarmConditionFilter.getValue()",
    "EntityKeyValueType AlarmConditionFilter.getValueType()",
    "void AlarmConditionFilter.setKey(AlarmConditionFilterKey)",
    "void AlarmConditionFilter.setPredicate(KeyFilterPredicate)",
    "void AlarmConditionFilter.setValue(Object)",
    "void AlarmConditionFilter.setValueType(EntityKeyValueType)",
    "java.lang.String AlarmConditionFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmConditionFilter actualAlarmConditionFilter = new AlarmConditionFilter();
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");
    actualAlarmConditionFilter.setKey(key);
    KeyFilterPredicate predicate = mock(KeyFilterPredicate.class);
    actualAlarmConditionFilter.setPredicate(predicate);
    actualAlarmConditionFilter.setValue("Value");
    actualAlarmConditionFilter.setValueType(EntityKeyValueType.STRING);
    actualAlarmConditionFilter.toString();
    AlarmConditionFilterKey actualKey = actualAlarmConditionFilter.getKey();
    KeyFilterPredicate actualPredicate = actualAlarmConditionFilter.getPredicate();
    Object actualValue = actualAlarmConditionFilter.getValue();

    // Assert
    assertEquals("Value", actualValue);
    assertEquals(EntityKeyValueType.STRING, actualAlarmConditionFilter.getValueType());
    assertSame(key, actualKey);
    assertSame(predicate, actualPredicate);
  }
}
