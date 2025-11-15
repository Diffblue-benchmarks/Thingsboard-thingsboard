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
package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class EntityDataInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataInfo#equals(Object)}
   *   <li>{@link EntityDataInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(true, true, true);
    EntityDataInfo entityDataInfo2 = new EntityDataInfo(true, true, true);

    // Act and Assert
    assertEquals(entityDataInfo, entityDataInfo2);
    int expectedHashCodeResult = entityDataInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityDataInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataInfo#equals(Object)}
   *   <li>{@link EntityDataInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(true, true, true);

    // Act and Assert
    assertEquals(entityDataInfo, entityDataInfo);
    int expectedHashCodeResult = entityDataInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityDataInfo.hashCode());
  }

  /**
   * Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(false, true, true);

    // Act and Assert
    assertNotEquals(entityDataInfo, new EntityDataInfo(true, true, true));
  }

  /**
   * Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(true, false, true);

    // Act and Assert
    assertNotEquals(entityDataInfo, new EntityDataInfo(true, true, true));
  }

  /**
   * Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(true, true, false);

    // Act and Assert
    assertNotEquals(entityDataInfo, new EntityDataInfo(true, true, true));
  }

  /**
   * Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataInfo(true, true, true), null);
  }

  /**
   * Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataInfo(true, true, true), "Different type to EntityDataInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataInfo#EntityDataInfo()}
   *   <li>{@link EntityDataInfo#setHasAttributes(boolean)}
   *   <li>{@link EntityDataInfo#setHasCredentials(boolean)}
   *   <li>{@link EntityDataInfo#setHasRelations(boolean)}
   *   <li>{@link EntityDataInfo#toString()}
   *   <li>{@link EntityDataInfo#isHasAttributes()}
   *   <li>{@link EntityDataInfo#isHasCredentials()}
   *   <li>{@link EntityDataInfo#isHasRelations()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityDataInfo actualEntityDataInfo = new EntityDataInfo();
    actualEntityDataInfo.setHasAttributes(true);
    actualEntityDataInfo.setHasCredentials(true);
    actualEntityDataInfo.setHasRelations(true);
    String actualToStringResult = actualEntityDataInfo.toString();
    boolean actualIsHasAttributesResult = actualEntityDataInfo.isHasAttributes();
    boolean actualIsHasCredentialsResult = actualEntityDataInfo.isHasCredentials();

    // Assert that nothing has changed
    assertEquals("EntityDataInfo(hasRelations=true, hasAttributes=true, hasCredentials=true)", actualToStringResult);
    assertTrue(actualIsHasAttributesResult);
    assertTrue(actualIsHasCredentialsResult);
    assertTrue(actualEntityDataInfo.isHasRelations());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataInfo#EntityDataInfo(boolean, boolean, boolean)}
   *   <li>{@link EntityDataInfo#setHasAttributes(boolean)}
   *   <li>{@link EntityDataInfo#setHasCredentials(boolean)}
   *   <li>{@link EntityDataInfo#setHasRelations(boolean)}
   *   <li>{@link EntityDataInfo#toString()}
   *   <li>{@link EntityDataInfo#isHasAttributes()}
   *   <li>{@link EntityDataInfo#isHasCredentials()}
   *   <li>{@link EntityDataInfo#isHasRelations()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    EntityDataInfo actualEntityDataInfo = new EntityDataInfo(true, true, true);
    actualEntityDataInfo.setHasAttributes(true);
    actualEntityDataInfo.setHasCredentials(true);
    actualEntityDataInfo.setHasRelations(true);
    String actualToStringResult = actualEntityDataInfo.toString();
    boolean actualIsHasAttributesResult = actualEntityDataInfo.isHasAttributes();
    boolean actualIsHasCredentialsResult = actualEntityDataInfo.isHasCredentials();

    // Assert that nothing has changed
    assertEquals("EntityDataInfo(hasRelations=true, hasAttributes=true, hasCredentials=true)", actualToStringResult);
    assertTrue(actualIsHasAttributesResult);
    assertTrue(actualIsHasCredentialsResult);
    assertTrue(actualEntityDataInfo.isHasRelations());
  }
}
