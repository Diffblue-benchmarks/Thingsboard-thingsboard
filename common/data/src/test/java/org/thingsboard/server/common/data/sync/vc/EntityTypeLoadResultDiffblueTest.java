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
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class EntityTypeLoadResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeLoadResult.EntityTypeLoadResultBuilder#build()}
   *   <li>{@link EntityTypeLoadResult.EntityTypeLoadResultBuilder#created(int)}
   *   <li>{@link EntityTypeLoadResult.EntityTypeLoadResultBuilder#deleted(int)}
   *   <li>
   * {@link EntityTypeLoadResult.EntityTypeLoadResultBuilder#entityType(EntityType)}
   *   <li>{@link EntityTypeLoadResult.EntityTypeLoadResultBuilder#updated(int)}
   * </ul>
   */
  @Test
  void testEntityTypeLoadResultBuilderBuild() {
    // Arrange and Act
    EntityTypeLoadResult actualBuildResult = EntityTypeLoadResult.builder()
        .created(1)
        .deleted(1)
        .entityType(EntityType.TENANT)
        .updated(1)
        .build();

    // Assert
    assertEquals(1, actualBuildResult.getCreated());
    assertEquals(1, actualBuildResult.getDeleted());
    assertEquals(1, actualBuildResult.getUpdated());
    assertEquals(EntityType.TENANT, actualBuildResult.getEntityType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeLoadResult#equals(Object)}
   *   <li>{@link EntityTypeLoadResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityTypeLoadResult buildResult = EntityTypeLoadResult.builder()
        .created(1)
        .deleted(1)
        .entityType(EntityType.TENANT)
        .updated(1)
        .build();
    EntityTypeLoadResult buildResult2 = EntityTypeLoadResult.builder()
        .created(1)
        .deleted(1)
        .entityType(EntityType.TENANT)
        .updated(1)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeLoadResult#equals(Object)}
   *   <li>{@link EntityTypeLoadResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityTypeLoadResult buildResult = EntityTypeLoadResult.builder()
        .created(1)
        .deleted(1)
        .entityType(EntityType.TENANT)
        .updated(1)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link EntityTypeLoadResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeLoadResult.EntityTypeLoadResultBuilder entityTypeLoadResultBuilder = mock(
        EntityTypeLoadResult.EntityTypeLoadResultBuilder.class);
    when(entityTypeLoadResultBuilder.created(anyInt())).thenReturn(EntityTypeLoadResult.builder());
    EntityTypeLoadResult buildResult = entityTypeLoadResultBuilder.created(1)
        .deleted(1)
        .entityType(EntityType.TENANT)
        .updated(1)
        .build();
    EntityTypeLoadResult buildResult2 = EntityTypeLoadResult.builder()
        .created(1)
        .deleted(1)
        .entityType(EntityType.TENANT)
        .updated(1)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EntityTypeLoadResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityTypeLoadResult buildResult = EntityTypeLoadResult.builder()
        .created(1)
        .deleted(1)
        .entityType(EntityType.TENANT)
        .updated(1)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link EntityTypeLoadResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityTypeLoadResult buildResult = EntityTypeLoadResult.builder()
        .created(1)
        .deleted(1)
        .entityType(EntityType.TENANT)
        .updated(1)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntityTypeLoadResult");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeLoadResult#EntityTypeLoadResult()}
   *   <li>{@link EntityTypeLoadResult#setCreated(int)}
   *   <li>{@link EntityTypeLoadResult#setDeleted(int)}
   *   <li>{@link EntityTypeLoadResult#setEntityType(EntityType)}
   *   <li>{@link EntityTypeLoadResult#setUpdated(int)}
   *   <li>{@link EntityTypeLoadResult#toString()}
   *   <li>{@link EntityTypeLoadResult#getCreated()}
   *   <li>{@link EntityTypeLoadResult#getDeleted()}
   *   <li>{@link EntityTypeLoadResult#getEntityType()}
   *   <li>{@link EntityTypeLoadResult#getUpdated()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityTypeLoadResult actualEntityTypeLoadResult = new EntityTypeLoadResult();
    actualEntityTypeLoadResult.setCreated(1);
    actualEntityTypeLoadResult.setDeleted(1);
    actualEntityTypeLoadResult.setEntityType(EntityType.TENANT);
    actualEntityTypeLoadResult.setUpdated(1);
    String actualToStringResult = actualEntityTypeLoadResult.toString();
    int actualCreated = actualEntityTypeLoadResult.getCreated();
    int actualDeleted = actualEntityTypeLoadResult.getDeleted();
    EntityType actualEntityType = actualEntityTypeLoadResult.getEntityType();

    // Assert that nothing has changed
    assertEquals("EntityTypeLoadResult(entityType=TENANT, created=1, updated=1, deleted=1)", actualToStringResult);
    assertEquals(1, actualCreated);
    assertEquals(1, actualDeleted);
    assertEquals(1, actualEntityTypeLoadResult.getUpdated());
    assertEquals(EntityType.TENANT, actualEntityType);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeLoadResult#EntityTypeLoadResult(EntityType)}
   *   <li>{@link EntityTypeLoadResult#setCreated(int)}
   *   <li>{@link EntityTypeLoadResult#setDeleted(int)}
   *   <li>{@link EntityTypeLoadResult#setEntityType(EntityType)}
   *   <li>{@link EntityTypeLoadResult#setUpdated(int)}
   *   <li>{@link EntityTypeLoadResult#toString()}
   *   <li>{@link EntityTypeLoadResult#getCreated()}
   *   <li>{@link EntityTypeLoadResult#getDeleted()}
   *   <li>{@link EntityTypeLoadResult#getEntityType()}
   *   <li>{@link EntityTypeLoadResult#getUpdated()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    EntityTypeLoadResult actualEntityTypeLoadResult = new EntityTypeLoadResult(EntityType.TENANT);
    actualEntityTypeLoadResult.setCreated(1);
    actualEntityTypeLoadResult.setDeleted(1);
    actualEntityTypeLoadResult.setEntityType(EntityType.TENANT);
    actualEntityTypeLoadResult.setUpdated(1);
    String actualToStringResult = actualEntityTypeLoadResult.toString();
    int actualCreated = actualEntityTypeLoadResult.getCreated();
    int actualDeleted = actualEntityTypeLoadResult.getDeleted();
    EntityType actualEntityType = actualEntityTypeLoadResult.getEntityType();

    // Assert that nothing has changed
    assertEquals("EntityTypeLoadResult(entityType=TENANT, created=1, updated=1, deleted=1)", actualToStringResult);
    assertEquals(1, actualCreated);
    assertEquals(1, actualDeleted);
    assertEquals(1, actualEntityTypeLoadResult.getUpdated());
    assertEquals(EntityType.TENANT, actualEntityType);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityTypeLoadResult#EntityTypeLoadResult(EntityType, int, int, int)}
   *   <li>{@link EntityTypeLoadResult#setCreated(int)}
   *   <li>{@link EntityTypeLoadResult#setDeleted(int)}
   *   <li>{@link EntityTypeLoadResult#setEntityType(EntityType)}
   *   <li>{@link EntityTypeLoadResult#setUpdated(int)}
   *   <li>{@link EntityTypeLoadResult#toString()}
   *   <li>{@link EntityTypeLoadResult#getCreated()}
   *   <li>{@link EntityTypeLoadResult#getDeleted()}
   *   <li>{@link EntityTypeLoadResult#getEntityType()}
   *   <li>{@link EntityTypeLoadResult#getUpdated()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange and Act
    EntityTypeLoadResult actualEntityTypeLoadResult = new EntityTypeLoadResult(EntityType.TENANT, 1, 1, 1);
    actualEntityTypeLoadResult.setCreated(1);
    actualEntityTypeLoadResult.setDeleted(1);
    actualEntityTypeLoadResult.setEntityType(EntityType.TENANT);
    actualEntityTypeLoadResult.setUpdated(1);
    String actualToStringResult = actualEntityTypeLoadResult.toString();
    int actualCreated = actualEntityTypeLoadResult.getCreated();
    int actualDeleted = actualEntityTypeLoadResult.getDeleted();
    EntityType actualEntityType = actualEntityTypeLoadResult.getEntityType();

    // Assert that nothing has changed
    assertEquals("EntityTypeLoadResult(entityType=TENANT, created=1, updated=1, deleted=1)", actualToStringResult);
    assertEquals(1, actualCreated);
    assertEquals(1, actualDeleted);
    assertEquals(1, actualEntityTypeLoadResult.getUpdated());
    assertEquals(EntityType.TENANT, actualEntityType);
  }
}
