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
package org.thingsboard.server.common.data.sync.vc.request.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class EntityTypeVersionLoadRequestDiffblueTest {
  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}, and {@link
   * EntityTypeVersionLoadRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTypeVersionLoadRequest#equals(Object)}
   *   <li>{@link EntityTypeVersionLoadRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeVersionLoadRequest.equals(Object)",
    "int EntityTypeVersionLoadRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest.setRollbackOnError(true);
    entityTypeVersionLoadRequest.setVersionId("42");

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest2.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest2.setRollbackOnError(true);
    entityTypeVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
    assertEquals(entityTypeVersionLoadRequest.hashCode(), entityTypeVersionLoadRequest2.hashCode());
  }

  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}, and {@link
   * EntityTypeVersionLoadRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTypeVersionLoadRequest#equals(Object)}
   *   <li>{@link EntityTypeVersionLoadRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeVersionLoadRequest.equals(Object)",
    "int EntityTypeVersionLoadRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest.setRollbackOnError(true);
    entityTypeVersionLoadRequest.setVersionId("42");

    // Act and Assert
    assertEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest);
    int expectedHashCodeResult = entityTypeVersionLoadRequest.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeVersionLoadRequest.hashCode());
  }

  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeVersionLoadRequest.equals(Object)",
    "int EntityTypeVersionLoadRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    HashMap<EntityType, EntityTypeVersionLoadConfig> entityTypes = new HashMap<>();
    entityTypes.put(EntityType.TENANT, entityTypeVersionLoadConfig);

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(entityTypes);
    entityTypeVersionLoadRequest.setRollbackOnError(true);
    entityTypeVersionLoadRequest.setVersionId("42");

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest2.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest2.setRollbackOnError(true);
    entityTypeVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeVersionLoadRequest.equals(Object)",
    "int EntityTypeVersionLoadRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest.setRollbackOnError(false);
    entityTypeVersionLoadRequest.setVersionId("42");

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest2.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest2.setRollbackOnError(true);
    entityTypeVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeVersionLoadRequest.equals(Object)",
    "int EntityTypeVersionLoadRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest.setRollbackOnError(true);
    entityTypeVersionLoadRequest.setVersionId("1.0.2");

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest2.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest2.setRollbackOnError(true);
    entityTypeVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeVersionLoadRequest.equals(Object)",
    "int EntityTypeVersionLoadRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest.setRollbackOnError(true);
    entityTypeVersionLoadRequest.setVersionId("42");

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, null);
  }

  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityTypeVersionLoadRequest.equals(Object)",
    "int EntityTypeVersionLoadRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest.setRollbackOnError(true);
    entityTypeVersionLoadRequest.setVersionId("42");

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, "Different type to EntityTypeVersionLoadRequest");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityTypeVersionLoadRequest}
   *   <li>{@link EntityTypeVersionLoadRequest#setEntityTypes(Map)}
   *   <li>{@link EntityTypeVersionLoadRequest#setRollbackOnError(boolean)}
   *   <li>{@link EntityTypeVersionLoadRequest#toString()}
   *   <li>{@link EntityTypeVersionLoadRequest#getEntityTypes()}
   *   <li>{@link EntityTypeVersionLoadRequest#getType()}
   *   <li>{@link EntityTypeVersionLoadRequest#isRollbackOnError()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityTypeVersionLoadRequest.<init>()",
    "Map EntityTypeVersionLoadRequest.getEntityTypes()",
    "VersionLoadRequestType EntityTypeVersionLoadRequest.getType()",
    "boolean EntityTypeVersionLoadRequest.isRollbackOnError()",
    "void EntityTypeVersionLoadRequest.setEntityTypes(Map)",
    "void EntityTypeVersionLoadRequest.setRollbackOnError(boolean)",
    "String EntityTypeVersionLoadRequest.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityTypeVersionLoadRequest actualEntityTypeVersionLoadRequest =
        new EntityTypeVersionLoadRequest();
    HashMap<EntityType, EntityTypeVersionLoadConfig> entityTypes = new HashMap<>();
    actualEntityTypeVersionLoadRequest.setEntityTypes(entityTypes);
    actualEntityTypeVersionLoadRequest.setRollbackOnError(true);
    String actualToStringResult = actualEntityTypeVersionLoadRequest.toString();
    Map<EntityType, EntityTypeVersionLoadConfig> actualEntityTypes =
        actualEntityTypeVersionLoadRequest.getEntityTypes();
    VersionLoadRequestType actualType = actualEntityTypeVersionLoadRequest.getType();
    boolean actualIsRollbackOnErrorResult = actualEntityTypeVersionLoadRequest.isRollbackOnError();

    // Assert
    assertEquals(
        "EntityTypeVersionLoadRequest(entityTypes={}, rollbackOnError=true)", actualToStringResult);
    assertNull(actualEntityTypeVersionLoadRequest.getVersionId());
    assertEquals(VersionLoadRequestType.ENTITY_TYPE, actualType);
    assertTrue(actualEntityTypes.isEmpty());
    assertTrue(actualIsRollbackOnErrorResult);
    assertSame(entityTypes, actualEntityTypes);
  }
}
