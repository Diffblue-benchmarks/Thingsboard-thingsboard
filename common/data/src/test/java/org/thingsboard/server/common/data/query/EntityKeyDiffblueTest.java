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
import org.junit.jupiter.api.Test;

class EntityKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKey#equals(Object)}
   *   <li>{@link EntityKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");
    EntityKey entityKey2 = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertEquals(entityKey, entityKey2);
    int expectedHashCodeResult = entityKey.hashCode();
    assertEquals(expectedHashCodeResult, entityKey2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKey#equals(Object)}
   *   <li>{@link EntityKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityKey entityKey = new EntityKey(null, "Key");
    EntityKey entityKey2 = new EntityKey(null, "Key");

    // Act and Assert
    assertEquals(entityKey, entityKey2);
    int expectedHashCodeResult = entityKey.hashCode();
    assertEquals(expectedHashCodeResult, entityKey2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKey#equals(Object)}
   *   <li>{@link EntityKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, null);
    EntityKey entityKey2 = new EntityKey(EntityKeyType.ATTRIBUTE, null);

    // Act and Assert
    assertEquals(entityKey, entityKey2);
    int expectedHashCodeResult = entityKey.hashCode();
    assertEquals(expectedHashCodeResult, entityKey2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKey#equals(Object)}
   *   <li>{@link EntityKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertEquals(entityKey, entityKey);
    int expectedHashCodeResult = entityKey.hashCode();
    assertEquals(expectedHashCodeResult, entityKey.hashCode());
  }

  /**
   * Method under test: {@link EntityKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityKey entityKey = new EntityKey(null, "Key");

    // Act and Assert
    assertNotEquals(entityKey, new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
  }

  /**
   * Method under test: {@link EntityKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityKey entityKey = new EntityKey(EntityKeyType.CLIENT_ATTRIBUTE, "Key");

    // Act and Assert
    assertNotEquals(entityKey, new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
  }

  /**
   * Method under test: {@link EntityKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, null);

    // Act and Assert
    assertNotEquals(entityKey, new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
  }

  /**
   * Method under test: {@link EntityKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "org.thingsboard.server.common.data.query.EntityKey");

    // Act and Assert
    assertNotEquals(entityKey, new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
  }

  /**
   * Method under test: {@link EntityKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"), null);
  }

  /**
   * Method under test: {@link EntityKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"), "Different type to EntityKey");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKey#EntityKey(EntityKeyType, String)}
   *   <li>{@link EntityKey#toString()}
   *   <li>{@link EntityKey#getKey()}
   *   <li>{@link EntityKey#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityKey actualEntityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");
    String actualToStringResult = actualEntityKey.toString();
    String actualKey = actualEntityKey.getKey();

    // Assert
    assertEquals("EntityKey(type=ATTRIBUTE, key=Key)", actualToStringResult);
    assertEquals("Key", actualKey);
    assertEquals(EntityKeyType.ATTRIBUTE, actualEntityKey.getType());
  }
}
