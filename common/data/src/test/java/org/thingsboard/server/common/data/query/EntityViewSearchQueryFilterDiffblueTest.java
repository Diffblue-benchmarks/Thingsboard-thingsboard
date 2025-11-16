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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class EntityViewSearchQueryFilterDiffblueTest {
  /**
   * Test {@link EntityViewSearchQueryFilter#equals(Object)}, and {@link
   * EntityViewSearchQueryFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewSearchQueryFilter#equals(Object)}
   *   <li>{@link EntityViewSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewSearchQueryFilter.equals(Object)",
    "int EntityViewSearchQueryFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewSearchQueryFilter entityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter.setMaxLevel(3);
    entityViewSearchQueryFilter.setRelationType("Relation Type");
    entityViewSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    EntityViewSearchQueryFilter entityViewSearchQueryFilter2 = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter2.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter2.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter2.setMaxLevel(3);
    entityViewSearchQueryFilter2.setRelationType("Relation Type");
    entityViewSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(entityViewSearchQueryFilter, entityViewSearchQueryFilter2);
    assertEquals(entityViewSearchQueryFilter.hashCode(), entityViewSearchQueryFilter2.hashCode());
  }

  /**
   * Test {@link EntityViewSearchQueryFilter#equals(Object)}, and {@link
   * EntityViewSearchQueryFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewSearchQueryFilter#equals(Object)}
   *   <li>{@link EntityViewSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewSearchQueryFilter.equals(Object)",
    "int EntityViewSearchQueryFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewSearchQueryFilter entityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter.setMaxLevel(3);
    entityViewSearchQueryFilter.setRelationType("Relation Type");
    entityViewSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(entityViewSearchQueryFilter, entityViewSearchQueryFilter);
    int expectedHashCodeResult = entityViewSearchQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityViewSearchQueryFilter.hashCode());
  }

  /**
   * Test {@link EntityViewSearchQueryFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewSearchQueryFilter.equals(Object)",
    "int EntityViewSearchQueryFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewSearchQueryFilter entityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter.setDirection(null);
    entityViewSearchQueryFilter.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter.setMaxLevel(3);
    entityViewSearchQueryFilter.setRelationType("Relation Type");
    entityViewSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    EntityViewSearchQueryFilter entityViewSearchQueryFilter2 = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter2.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter2.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter2.setMaxLevel(3);
    entityViewSearchQueryFilter2.setRelationType("Relation Type");
    entityViewSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityViewSearchQueryFilter, entityViewSearchQueryFilter2);
  }

  /**
   * Test {@link EntityViewSearchQueryFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewSearchQueryFilter.equals(Object)",
    "int EntityViewSearchQueryFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Relation Type");

    EntityViewSearchQueryFilter entityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter.setEntityViewTypes(entityViewTypes);
    entityViewSearchQueryFilter.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter.setMaxLevel(3);
    entityViewSearchQueryFilter.setRelationType("Relation Type");
    entityViewSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    EntityViewSearchQueryFilter entityViewSearchQueryFilter2 = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter2.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter2.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter2.setMaxLevel(3);
    entityViewSearchQueryFilter2.setRelationType("Relation Type");
    entityViewSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityViewSearchQueryFilter, entityViewSearchQueryFilter2);
  }

  /**
   * Test {@link EntityViewSearchQueryFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewSearchQueryFilter.equals(Object)",
    "int EntityViewSearchQueryFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityViewSearchQueryFilter entityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter.setMaxLevel(3);
    entityViewSearchQueryFilter.setRelationType("Relation Type");
    entityViewSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityViewSearchQueryFilter, null);
  }

  /**
   * Test {@link EntityViewSearchQueryFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewSearchQueryFilter.equals(Object)",
    "int EntityViewSearchQueryFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityViewSearchQueryFilter entityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter.setMaxLevel(3);
    entityViewSearchQueryFilter.setRelationType("Relation Type");
    entityViewSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityViewSearchQueryFilter, "Different type to EntityViewSearchQueryFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityViewSearchQueryFilter}
   *   <li>{@link EntityViewSearchQueryFilter#setEntityViewTypes(List)}
   *   <li>{@link EntityViewSearchQueryFilter#toString()}
   *   <li>{@link EntityViewSearchQueryFilter#getEntityViewTypes()}
   *   <li>{@link EntityViewSearchQueryFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityViewSearchQueryFilter.<init>()",
    "List EntityViewSearchQueryFilter.getEntityViewTypes()",
    "EntityFilterType EntityViewSearchQueryFilter.getType()",
    "void EntityViewSearchQueryFilter.setEntityViewTypes(List)",
    "String EntityViewSearchQueryFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityViewSearchQueryFilter actualEntityViewSearchQueryFilter =
        new EntityViewSearchQueryFilter();
    ArrayList<String> entityViewTypes = new ArrayList<>();
    actualEntityViewSearchQueryFilter.setEntityViewTypes(entityViewTypes);
    String actualToStringResult = actualEntityViewSearchQueryFilter.toString();
    List<String> actualEntityViewTypes = actualEntityViewSearchQueryFilter.getEntityViewTypes();
    EntityFilterType actualType = actualEntityViewSearchQueryFilter.getType();

    // Assert
    assertEquals(
        "EntityViewSearchQueryFilter(super=EntitySearchQueryFilter(rootEntity=null, relationType=null,"
            + " direction=null, maxLevel=0, fetchLastLevelOnly=false), entityViewTypes=[])",
        actualToStringResult);
    assertNull(actualEntityViewSearchQueryFilter.getRelationType());
    assertNull(actualEntityViewSearchQueryFilter.getRootEntity());
    assertNull(actualEntityViewSearchQueryFilter.getDirection());
    assertEquals(0, actualEntityViewSearchQueryFilter.getMaxLevel());
    assertEquals(EntityFilterType.ENTITY_VIEW_SEARCH_QUERY, actualType);
    assertFalse(actualEntityViewSearchQueryFilter.isFetchLastLevelOnly());
    assertTrue(actualEntityViewTypes.isEmpty());
    assertSame(entityViewTypes, actualEntityViewTypes);
  }
}
