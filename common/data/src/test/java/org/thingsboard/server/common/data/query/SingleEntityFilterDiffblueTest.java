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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class SingleEntityFilterDiffblueTest {
  /**
   * Test {@link SingleEntityFilter#equals(Object)}, and {@link SingleEntityFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SingleEntityFilter#equals(Object)}
   *   <li>{@link SingleEntityFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleEntityFilter.equals(Object)",
    "int SingleEntityFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(TenantId.SYS_TENANT_ID);

    SingleEntityFilter singleEntityFilter2 = new SingleEntityFilter();
    singleEntityFilter2.setSingleEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(singleEntityFilter, singleEntityFilter2);
    assertEquals(singleEntityFilter.hashCode(), singleEntityFilter2.hashCode());
  }

  /**
   * Test {@link SingleEntityFilter#equals(Object)}, and {@link SingleEntityFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SingleEntityFilter#equals(Object)}
   *   <li>{@link SingleEntityFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleEntityFilter.equals(Object)",
    "int SingleEntityFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(null);

    SingleEntityFilter singleEntityFilter2 = new SingleEntityFilter();
    singleEntityFilter2.setSingleEntity(null);

    // Act and Assert
    assertEquals(singleEntityFilter, singleEntityFilter2);
    assertEquals(singleEntityFilter.hashCode(), singleEntityFilter2.hashCode());
  }

  /**
   * Test {@link SingleEntityFilter#equals(Object)}, and {@link SingleEntityFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SingleEntityFilter#equals(Object)}
   *   <li>{@link SingleEntityFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleEntityFilter.equals(Object)",
    "int SingleEntityFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(singleEntityFilter, singleEntityFilter);
    int expectedHashCodeResult = singleEntityFilter.hashCode();
    assertEquals(expectedHashCodeResult, singleEntityFilter.hashCode());
  }

  /**
   * Test {@link SingleEntityFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SingleEntityFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleEntityFilter.equals(Object)",
    "int SingleEntityFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(null);

    SingleEntityFilter singleEntityFilter2 = new SingleEntityFilter();
    singleEntityFilter2.setSingleEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(singleEntityFilter, singleEntityFilter2);
  }

  /**
   * Test {@link SingleEntityFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SingleEntityFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleEntityFilter.equals(Object)",
    "int SingleEntityFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(new AlarmId(EntityId.NULL_UUID));

    SingleEntityFilter singleEntityFilter2 = new SingleEntityFilter();
    singleEntityFilter2.setSingleEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(singleEntityFilter, singleEntityFilter2);
  }

  /**
   * Test {@link SingleEntityFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SingleEntityFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleEntityFilter.equals(Object)",
    "int SingleEntityFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(singleEntityFilter, null);
  }

  /**
   * Test {@link SingleEntityFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SingleEntityFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleEntityFilter.equals(Object)",
    "int SingleEntityFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SingleEntityFilter singleEntityFilter = new SingleEntityFilter();
    singleEntityFilter.setSingleEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(singleEntityFilter, "Different type to SingleEntityFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SingleEntityFilter}
   *   <li>{@link SingleEntityFilter#setSingleEntity(EntityId)}
   *   <li>{@link SingleEntityFilter#toString()}
   *   <li>{@link SingleEntityFilter#getSingleEntity()}
   *   <li>{@link SingleEntityFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SingleEntityFilter.<init>()",
    "EntityId SingleEntityFilter.getSingleEntity()",
    "EntityFilterType SingleEntityFilter.getType()",
    "void SingleEntityFilter.setSingleEntity(EntityId)",
    "String SingleEntityFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SingleEntityFilter actualSingleEntityFilter = new SingleEntityFilter();
    actualSingleEntityFilter.setSingleEntity(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualSingleEntityFilter.toString();
    EntityId actualSingleEntity = actualSingleEntityFilter.getSingleEntity();

    // Assert
    assertEquals(
        "SingleEntityFilter(singleEntity=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals(EntityFilterType.SINGLE_ENTITY, actualSingleEntityFilter.getType());
    assertSame(((TenantId) actualSingleEntity).SYS_TENANT_ID, actualSingleEntity);
  }
}
