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
package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class TbStringActorIdDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbStringActorId#equals(Object)}
   *   <li>{@link TbStringActorId#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbStringActorId tbStringActorId = new TbStringActorId("42");
    TbStringActorId tbStringActorId2 = new TbStringActorId("42");

    // Act and Assert
    assertEquals(tbStringActorId, tbStringActorId2);
    int expectedHashCodeResult = tbStringActorId.hashCode();
    assertEquals(expectedHashCodeResult, tbStringActorId2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbStringActorId#equals(Object)}
   *   <li>{@link TbStringActorId#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbStringActorId tbStringActorId = new TbStringActorId("42");

    // Act and Assert
    assertEquals(tbStringActorId, tbStringActorId);
    int expectedHashCodeResult = tbStringActorId.hashCode();
    assertEquals(expectedHashCodeResult, tbStringActorId.hashCode());
  }

  /**
   * Method under test: {@link TbStringActorId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbStringActorId tbStringActorId = new TbStringActorId("Id");

    // Act and Assert
    assertNotEquals(tbStringActorId, new TbStringActorId("42"));
  }

  /**
   * Method under test: {@link TbStringActorId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbStringActorId("42"), null);
  }

  /**
   * Method under test: {@link TbStringActorId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbStringActorId("42"), "Different type to TbStringActorId");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbStringActorId#TbStringActorId(String)}
   *   <li>{@link TbStringActorId#getEntityType()}
   *   <li>{@link TbStringActorId#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TbStringActorId actualTbStringActorId = new TbStringActorId("42");
    EntityType actualEntityType = actualTbStringActorId.getEntityType();

    // Assert
    assertEquals("42", actualTbStringActorId.toString());
    assertNull(actualEntityType);
  }
}
