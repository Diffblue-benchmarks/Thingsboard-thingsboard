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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class KeyFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KeyFilter#equals(Object)}
   *   <li>{@link KeyFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(null);
    keyFilter.setValueType(EntityKeyValueType.STRING);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(null);
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertEquals(keyFilter, keyFilter2);
    int expectedHashCodeResult = keyFilter.hashCode();
    assertEquals(expectedHashCodeResult, keyFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KeyFilter#equals(Object)}
   *   <li>{@link KeyFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertEquals(keyFilter, keyFilter);
    int expectedHashCodeResult = keyFilter.hashCode();
    assertEquals(expectedHashCodeResult, keyFilter.hashCode());
  }

  /**
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(null, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(null);
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(null);
    keyFilter.setValueType(EntityKeyValueType.STRING);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(null);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.NUMERIC);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(null);
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(null);
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(null);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(null);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, null);
  }

  /**
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, "Different type to KeyFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link KeyFilter}
   *   <li>{@link KeyFilter#setKey(EntityKey)}
   *   <li>{@link KeyFilter#setPredicate(KeyFilterPredicate)}
   *   <li>{@link KeyFilter#setValueType(EntityKeyValueType)}
   *   <li>{@link KeyFilter#toString()}
   *   <li>{@link KeyFilter#getKey()}
   *   <li>{@link KeyFilter#getPredicate()}
   *   <li>{@link KeyFilter#getValueType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    KeyFilter actualKeyFilter = new KeyFilter();
    EntityKey key = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    actualKeyFilter.setKey(key);
    KeyFilterPredicate predicate = mock(KeyFilterPredicate.class);
    actualKeyFilter.setPredicate(predicate);
    actualKeyFilter.setValueType(EntityKeyValueType.STRING);
    actualKeyFilter.toString();
    EntityKey actualKey = actualKeyFilter.getKey();
    KeyFilterPredicate actualPredicate = actualKeyFilter.getPredicate();

    // Assert that nothing has changed
    assertEquals(EntityKeyValueType.STRING, actualKeyFilter.getValueType());
    assertSame(key, actualKey);
    assertSame(predicate, actualPredicate);
  }
}
