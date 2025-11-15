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
package org.thingsboard.server.common.data.relation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class EntityRelationInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityRelationInfo#equals(Object)}
   *   <li>{@link EntityRelationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityRelationInfo entityRelationInfo = new EntityRelationInfo();
    EntityRelationInfo entityRelationInfo2 = new EntityRelationInfo();

    // Act and Assert
    assertEquals(entityRelationInfo, entityRelationInfo2);
    int expectedHashCodeResult = entityRelationInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityRelationInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityRelationInfo#equals(Object)}
   *   <li>{@link EntityRelationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityRelationInfo entityRelationInfo = new EntityRelationInfo();

    // Act and Assert
    assertEquals(entityRelationInfo, entityRelationInfo);
    int expectedHashCodeResult = entityRelationInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityRelationInfo.hashCode());
  }

  /**
   * Method under test: {@link EntityRelationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityRelationInfo(), 1);
    assertNotEquals(new EntityRelationInfo(), mock(EntityRelation.class));
  }

  /**
   * Method under test: {@link EntityRelationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityRelationInfo entityRelationInfo = new EntityRelationInfo();
    entityRelationInfo.setToName("To Name");

    // Act and Assert
    assertNotEquals(entityRelationInfo, new EntityRelationInfo());
  }

  /**
   * Method under test: {@link EntityRelationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityRelationInfo entityRelationInfo = new EntityRelationInfo();
    entityRelationInfo.setFrom(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityRelationInfo, new EntityRelationInfo());
  }

  /**
   * Method under test: {@link EntityRelationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityRelationInfo entityRelationInfo = new EntityRelationInfo();

    EntityRelationInfo entityRelationInfo2 = new EntityRelationInfo();
    entityRelationInfo2.setToName("To Name");

    // Act and Assert
    assertNotEquals(entityRelationInfo, entityRelationInfo2);
  }

  /**
   * Method under test: {@link EntityRelationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityRelationInfo(), null);
  }

  /**
   * Method under test: {@link EntityRelationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityRelationInfo(), "Different type to EntityRelationInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityRelationInfo#EntityRelationInfo()}
   *   <li>{@link EntityRelationInfo#setFromName(String)}
   *   <li>{@link EntityRelationInfo#setToName(String)}
   *   <li>{@link EntityRelationInfo#getFromName()}
   *   <li>{@link EntityRelationInfo#getToName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityRelationInfo actualEntityRelationInfo = new EntityRelationInfo();
    actualEntityRelationInfo.setFromName("jane.doe@example.org");
    actualEntityRelationInfo.setToName("To Name");
    String actualFromName = actualEntityRelationInfo.getFromName();

    // Assert that nothing has changed
    assertEquals("To Name", actualEntityRelationInfo.getToName());
    assertEquals("jane.doe@example.org", actualFromName);
  }

  /**
   * Method under test:
   * {@link EntityRelationInfo#EntityRelationInfo(EntityRelation)}
   */
  @Test
  void testNewEntityRelationInfo() {
    // Arrange and Act
    EntityRelationInfo actualEntityRelationInfo = new EntityRelationInfo(new EntityRelation());

    // Assert
    assertNull(actualEntityRelationInfo.getAdditionalInfo());
    assertNull(actualEntityRelationInfo.getVersion());
    assertNull(actualEntityRelationInfo.getType());
    assertNull(actualEntityRelationInfo.getFromName());
    assertNull(actualEntityRelationInfo.getToName());
    assertNull(actualEntityRelationInfo.getFrom());
    assertNull(actualEntityRelationInfo.getTo());
    assertNull(actualEntityRelationInfo.getTypeGroup());
  }
}
