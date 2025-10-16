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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.sync.vc.EntityTypeLoadResult.EntityTypeLoadResultBuilder;

@ContextConfiguration(classes = {EntityTypeLoadResultBuilder.class})
@ExtendWith(SpringExtension.class)
class EntityTypeLoadResultDiffblueTest {
  @Autowired private EntityTypeLoadResultBuilder entityTypeLoadResultBuilder;

  /**
   * Test EntityTypeLoadResultBuilder {@link EntityTypeLoadResultBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTypeLoadResultBuilder#build()}
   *   <li>{@link EntityTypeLoadResultBuilder#created(int)}
   *   <li>{@link EntityTypeLoadResultBuilder#deleted(int)}
   *   <li>{@link EntityTypeLoadResultBuilder#entityType(EntityType)}
   *   <li>{@link EntityTypeLoadResultBuilder#updated(int)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityTypeLoadResultBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityTypeLoadResultBuilder.<init>()",
    "EntityTypeLoadResult EntityTypeLoadResultBuilder.build()",
    "EntityTypeLoadResultBuilder EntityTypeLoadResultBuilder.created(int)",
    "EntityTypeLoadResultBuilder EntityTypeLoadResultBuilder.deleted(int)",
    "EntityTypeLoadResultBuilder EntityTypeLoadResultBuilder.entityType(EntityType)",
    "String EntityTypeLoadResultBuilder.toString()",
    "EntityTypeLoadResultBuilder EntityTypeLoadResultBuilder.updated(int)"
  })
  void testEntityTypeLoadResultBuilderBuild() {
    // Arrange and Act
    EntityTypeLoadResult actualEntityTypeLoadResult =
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(1)
            .entityType(EntityType.TENANT)
            .updated(1)
            .build();

    // Assert
    assertEquals(1, actualEntityTypeLoadResult.getCreated());
    assertEquals(1, actualEntityTypeLoadResult.getDeleted());
    assertEquals(1, actualEntityTypeLoadResult.getUpdated());
    assertEquals(EntityType.TENANT, actualEntityTypeLoadResult.getEntityType());
  }

  /**
   * Test {@link EntityTypeLoadResult#equals(Object)}, and {@link EntityTypeLoadResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTypeLoadResult#equals(Object)}
   *   <li>{@link EntityTypeLoadResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeLoadResult.equals(Object)",
    "int EntityTypeLoadResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityTypeLoadResult entityTypeLoadResult =
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(1)
            .entityType(EntityType.TENANT)
            .updated(1)
            .build();
    EntityTypeLoadResult entityTypeLoadResult2 =
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(1)
            .entityType(EntityType.TENANT)
            .updated(1)
            .build();

    // Act and Assert
    assertEquals(entityTypeLoadResult, entityTypeLoadResult2);
    assertEquals(entityTypeLoadResult.hashCode(), entityTypeLoadResult2.hashCode());
  }

  /**
   * Test {@link EntityTypeLoadResult#equals(Object)}, and {@link EntityTypeLoadResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTypeLoadResult#equals(Object)}
   *   <li>{@link EntityTypeLoadResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeLoadResult.equals(Object)",
    "int EntityTypeLoadResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityTypeLoadResult entityTypeLoadResult =
        EntityTypeLoadResult.builder().created(1).deleted(1).entityType(null).updated(1).build();
    EntityTypeLoadResult entityTypeLoadResult2 =
        EntityTypeLoadResult.builder().created(1).deleted(1).entityType(null).updated(1).build();

    // Act and Assert
    assertEquals(entityTypeLoadResult, entityTypeLoadResult2);
    assertEquals(entityTypeLoadResult.hashCode(), entityTypeLoadResult2.hashCode());
  }

  /**
   * Test {@link EntityTypeLoadResult#equals(Object)}, and {@link EntityTypeLoadResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTypeLoadResult#equals(Object)}
   *   <li>{@link EntityTypeLoadResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeLoadResult.equals(Object)",
    "int EntityTypeLoadResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityTypeLoadResult entityTypeLoadResult =
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(1)
            .entityType(EntityType.TENANT)
            .updated(1)
            .build();

    // Act and Assert
    assertEquals(entityTypeLoadResult, entityTypeLoadResult);
    int expectedHashCodeResult = entityTypeLoadResult.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeLoadResult.hashCode());
  }

  /**
   * Test {@link EntityTypeLoadResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeLoadResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeLoadResult.equals(Object)",
    "int EntityTypeLoadResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeLoadResult entityTypeLoadResult =
        EntityTypeLoadResult.builder()
            .created(3)
            .deleted(1)
            .entityType(EntityType.TENANT)
            .updated(1)
            .build();

    // Act and Assert
    assertNotEquals(
        entityTypeLoadResult,
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(1)
            .entityType(EntityType.TENANT)
            .updated(1)
            .build());
  }

  /**
   * Test {@link EntityTypeLoadResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeLoadResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeLoadResult.equals(Object)",
    "int EntityTypeLoadResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityTypeLoadResult entityTypeLoadResult =
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(3)
            .entityType(EntityType.TENANT)
            .updated(1)
            .build();

    // Act and Assert
    assertNotEquals(
        entityTypeLoadResult,
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(1)
            .entityType(EntityType.TENANT)
            .updated(1)
            .build());
  }

  /**
   * Test {@link EntityTypeLoadResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeLoadResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeLoadResult.equals(Object)",
    "int EntityTypeLoadResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityTypeLoadResult entityTypeLoadResult =
        EntityTypeLoadResult.builder().created(1).deleted(1).entityType(null).updated(1).build();

    // Act and Assert
    assertNotEquals(
        entityTypeLoadResult,
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(1)
            .entityType(EntityType.TENANT)
            .updated(1)
            .build());
  }

  /**
   * Test {@link EntityTypeLoadResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeLoadResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeLoadResult.equals(Object)",
    "int EntityTypeLoadResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityTypeLoadResult entityTypeLoadResult =
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(1)
            .entityType(EntityType.CUSTOMER)
            .updated(1)
            .build();

    // Act and Assert
    assertNotEquals(
        entityTypeLoadResult,
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(1)
            .entityType(EntityType.TENANT)
            .updated(1)
            .build());
  }

  /**
   * Test {@link EntityTypeLoadResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeLoadResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeLoadResult.equals(Object)",
    "int EntityTypeLoadResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityTypeLoadResult entityTypeLoadResult =
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(1)
            .entityType(EntityType.TENANT)
            .updated(3)
            .build();

    // Act and Assert
    assertNotEquals(
        entityTypeLoadResult,
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(1)
            .entityType(EntityType.TENANT)
            .updated(1)
            .build());
  }

  /**
   * Test {@link EntityTypeLoadResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeLoadResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeLoadResult.equals(Object)",
    "int EntityTypeLoadResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(1)
            .entityType(EntityType.TENANT)
            .updated(1)
            .build(),
        null);
  }

  /**
   * Test {@link EntityTypeLoadResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeLoadResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeLoadResult.equals(Object)",
    "int EntityTypeLoadResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        EntityTypeLoadResult.builder()
            .created(1)
            .deleted(1)
            .entityType(EntityType.TENANT)
            .updated(1)
            .build(),
        "Different type to EntityTypeLoadResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityTypeLoadResult.<init>()",
    "void EntityTypeLoadResult.<init>(EntityType)",
    "void EntityTypeLoadResult.<init>(EntityType, int, int, int)",
    "int EntityTypeLoadResult.getCreated()",
    "int EntityTypeLoadResult.getDeleted()",
    "EntityType EntityTypeLoadResult.getEntityType()",
    "int EntityTypeLoadResult.getUpdated()",
    "void EntityTypeLoadResult.setCreated(int)",
    "void EntityTypeLoadResult.setDeleted(int)",
    "void EntityTypeLoadResult.setEntityType(EntityType)",
    "void EntityTypeLoadResult.setUpdated(int)",
    "String EntityTypeLoadResult.toString()"
  })
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

    // Assert
    assertEquals(
        "EntityTypeLoadResult(entityType=TENANT, created=1, updated=1, deleted=1)",
        actualToStringResult);
    assertEquals(1, actualCreated);
    assertEquals(1, actualDeleted);
    assertEquals(1, actualEntityTypeLoadResult.getUpdated());
    assertEquals(EntityType.TENANT, actualEntityType);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTypeLoadResult#EntityTypeLoadResult(EntityType, int, int, int)}
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
  @DisplayName("Test getters and setters; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityTypeLoadResult.<init>()",
    "void EntityTypeLoadResult.<init>(EntityType)",
    "void EntityTypeLoadResult.<init>(EntityType, int, int, int)",
    "int EntityTypeLoadResult.getCreated()",
    "int EntityTypeLoadResult.getDeleted()",
    "EntityType EntityTypeLoadResult.getEntityType()",
    "int EntityTypeLoadResult.getUpdated()",
    "void EntityTypeLoadResult.setCreated(int)",
    "void EntityTypeLoadResult.setDeleted(int)",
    "void EntityTypeLoadResult.setEntityType(EntityType)",
    "void EntityTypeLoadResult.setUpdated(int)",
    "String EntityTypeLoadResult.toString()"
  })
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    EntityTypeLoadResult actualEntityTypeLoadResult =
        new EntityTypeLoadResult(EntityType.TENANT, 1, 1, 1);
    actualEntityTypeLoadResult.setCreated(1);
    actualEntityTypeLoadResult.setDeleted(1);
    actualEntityTypeLoadResult.setEntityType(EntityType.TENANT);
    actualEntityTypeLoadResult.setUpdated(1);
    String actualToStringResult = actualEntityTypeLoadResult.toString();
    int actualCreated = actualEntityTypeLoadResult.getCreated();
    int actualDeleted = actualEntityTypeLoadResult.getDeleted();
    EntityType actualEntityType = actualEntityTypeLoadResult.getEntityType();

    // Assert
    assertEquals(
        "EntityTypeLoadResult(entityType=TENANT, created=1, updated=1, deleted=1)",
        actualToStringResult);
    assertEquals(1, actualCreated);
    assertEquals(1, actualDeleted);
    assertEquals(1, actualEntityTypeLoadResult.getUpdated());
    assertEquals(EntityType.TENANT, actualEntityType);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code TENANT}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters; when 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityTypeLoadResult.<init>()",
    "void EntityTypeLoadResult.<init>(EntityType)",
    "void EntityTypeLoadResult.<init>(EntityType, int, int, int)",
    "int EntityTypeLoadResult.getCreated()",
    "int EntityTypeLoadResult.getDeleted()",
    "EntityType EntityTypeLoadResult.getEntityType()",
    "int EntityTypeLoadResult.getUpdated()",
    "void EntityTypeLoadResult.setCreated(int)",
    "void EntityTypeLoadResult.setDeleted(int)",
    "void EntityTypeLoadResult.setEntityType(EntityType)",
    "void EntityTypeLoadResult.setUpdated(int)",
    "String EntityTypeLoadResult.toString()"
  })
  void testGettersAndSetters_whenTenant() {
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

    // Assert
    assertEquals(
        "EntityTypeLoadResult(entityType=TENANT, created=1, updated=1, deleted=1)",
        actualToStringResult);
    assertEquals(1, actualCreated);
    assertEquals(1, actualDeleted);
    assertEquals(1, actualEntityTypeLoadResult.getUpdated());
    assertEquals(EntityType.TENANT, actualEntityType);
  }
}
