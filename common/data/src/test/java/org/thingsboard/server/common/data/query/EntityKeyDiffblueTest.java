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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityKeyDiffblueTest {
  /**
   * Test {@link EntityKey#equals(Object)}, and {@link EntityKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKey#equals(Object)}
   *   <li>{@link EntityKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityKey.equals(Object)", "int EntityKey.hashCode()"})
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
   * Test {@link EntityKey#equals(Object)}, and {@link EntityKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKey#equals(Object)}
   *   <li>{@link EntityKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityKey.equals(Object)", "int EntityKey.hashCode()"})
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
   * Test {@link EntityKey#equals(Object)}, and {@link EntityKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKey#equals(Object)}
   *   <li>{@link EntityKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityKey.equals(Object)", "int EntityKey.hashCode()"})
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
   * Test {@link EntityKey#equals(Object)}, and {@link EntityKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKey#equals(Object)}
   *   <li>{@link EntityKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityKey.equals(Object)", "int EntityKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertEquals(entityKey, entityKey);
    int expectedHashCodeResult = entityKey.hashCode();
    assertEquals(expectedHashCodeResult, entityKey.hashCode());
  }

  /**
   * Test {@link EntityKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityKey.equals(Object)", "int EntityKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityKey entityKey = new EntityKey(null, "Key");

    // Act and Assert
    assertNotEquals(entityKey, new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link EntityKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityKey.equals(Object)", "int EntityKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityKey entityKey = new EntityKey(EntityKeyType.CLIENT_ATTRIBUTE, "Key");

    // Act and Assert
    assertNotEquals(entityKey, new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link EntityKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityKey.equals(Object)", "int EntityKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, null);

    // Act and Assert
    assertNotEquals(entityKey, new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link EntityKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityKey.equals(Object)", "int EntityKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityKey entityKey = new EntityKey(EntityKeyType.ATTRIBUTE, "org.thingsboard.server.common.data.query.EntityKey");

    // Act and Assert
    assertNotEquals(entityKey, new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link EntityKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityKey.equals(Object)", "int EntityKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"), null);
  }

  /**
   * Test {@link EntityKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityKey.equals(Object)", "int EntityKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"), "Different type to EntityKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityKey#EntityKey(EntityKeyType, String)}
   *   <li>{@link EntityKey#toString()}
   *   <li>{@link EntityKey#getKey()}
   *   <li>{@link EntityKey#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityKey.<init>(EntityKeyType, String)", "String EntityKey.getKey()",
      "EntityKeyType EntityKey.getType()", "String EntityKey.toString()"})
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
