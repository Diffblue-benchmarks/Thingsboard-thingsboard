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
package org.thingsboard.server.common.data.device;

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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationEntityTypeFilter;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;

class DeviceSearchQueryDiffblueTest {
  /**
   * Test {@link DeviceSearchQuery#toEntitySearchQuery()}.
   *
   * <ul>
   *   <li>Then return Filters first RelationType is {@code Contains}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQuery#toEntitySearchQuery()}
   */
  @Test
  @DisplayName("Test toEntitySearchQuery(); then return Filters first RelationType is 'Contains'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelationsQuery DeviceSearchQuery.toEntitySearchQuery()"})
  void testToEntitySearchQuery_thenReturnFiltersFirstRelationTypeIsContains() {
    // Arrange and Act
    EntityRelationsQuery actualToEntitySearchQueryResult =
        new DeviceSearchQuery().toEntitySearchQuery();

    // Assert
    List<RelationEntityTypeFilter> filters = actualToEntitySearchQueryResult.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("Contains", getResult.getRelationType());
    assertNull(actualToEntitySearchQueryResult.getParameters());
    List<EntityType> entityTypes = getResult.getEntityTypes();
    assertEquals(1, entityTypes.size());
    assertEquals(EntityType.DEVICE, entityTypes.get(0));
    assertFalse(getResult.isNegate());
  }

  /**
   * Test {@link DeviceSearchQuery#toEntitySearchQuery()}.
   *
   * <ul>
   *   <li>Then return Filters first RelationType is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQuery#toEntitySearchQuery()}
   */
  @Test
  @DisplayName("Test toEntitySearchQuery(); then return Filters first RelationType is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelationsQuery DeviceSearchQuery.toEntitySearchQuery()"})
  void testToEntitySearchQuery_thenReturnFiltersFirstRelationTypeIsFoo() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    deviceSearchQuery.setRelationType("foo");

    // Act
    EntityRelationsQuery actualToEntitySearchQueryResult = deviceSearchQuery.toEntitySearchQuery();

    // Assert
    List<RelationEntityTypeFilter> filters = actualToEntitySearchQueryResult.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("foo", getResult.getRelationType());
    assertNull(actualToEntitySearchQueryResult.getParameters());
    List<EntityType> entityTypes = getResult.getEntityTypes();
    assertEquals(1, entityTypes.size());
    assertEquals(EntityType.DEVICE, entityTypes.get(0));
    assertFalse(getResult.isNegate());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}, and {@link DeviceSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceSearchQuery#equals(Object)}
   *   <li>{@link DeviceSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    DeviceSearchQuery deviceSearchQuery2 = new DeviceSearchQuery();

    // Act and Assert
    assertEquals(deviceSearchQuery, deviceSearchQuery2);
    assertEquals(deviceSearchQuery.hashCode(), deviceSearchQuery2.hashCode());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}, and {@link DeviceSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceSearchQuery#equals(Object)}
   *   <li>{@link DeviceSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    deviceSearchQuery.setParameters(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    DeviceSearchQuery deviceSearchQuery2 = new DeviceSearchQuery();
    deviceSearchQuery2.setParameters(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertEquals(deviceSearchQuery, deviceSearchQuery2);
    assertEquals(deviceSearchQuery.hashCode(), deviceSearchQuery2.hashCode());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}, and {@link DeviceSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceSearchQuery#equals(Object)}
   *   <li>{@link DeviceSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    deviceSearchQuery.setRelationType("Relation Type");

    DeviceSearchQuery deviceSearchQuery2 = new DeviceSearchQuery();
    deviceSearchQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertEquals(deviceSearchQuery, deviceSearchQuery2);
    assertEquals(deviceSearchQuery.hashCode(), deviceSearchQuery2.hashCode());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}, and {@link DeviceSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceSearchQuery#equals(Object)}
   *   <li>{@link DeviceSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    deviceSearchQuery.setDeviceTypes(new ArrayList<>());

    DeviceSearchQuery deviceSearchQuery2 = new DeviceSearchQuery();
    deviceSearchQuery2.setDeviceTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(deviceSearchQuery, deviceSearchQuery2);
    assertEquals(deviceSearchQuery.hashCode(), deviceSearchQuery2.hashCode());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}, and {@link DeviceSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceSearchQuery#equals(Object)}
   *   <li>{@link DeviceSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();

    // Act and Assert
    assertEquals(deviceSearchQuery, deviceSearchQuery);
    int expectedHashCodeResult = deviceSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, deviceSearchQuery.hashCode());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceSearchQuery(), 1);
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    deviceSearchQuery.setParameters(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(deviceSearchQuery, new DeviceSearchQuery());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    deviceSearchQuery.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(deviceSearchQuery, new DeviceSearchQuery());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    deviceSearchQuery.setDeviceTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(deviceSearchQuery, new DeviceSearchQuery());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();

    DeviceSearchQuery deviceSearchQuery2 = new DeviceSearchQuery();
    deviceSearchQuery2.setParameters(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(deviceSearchQuery, deviceSearchQuery2);
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();

    DeviceSearchQuery deviceSearchQuery2 = new DeviceSearchQuery();
    deviceSearchQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(deviceSearchQuery, deviceSearchQuery2);
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();

    DeviceSearchQuery deviceSearchQuery2 = new DeviceSearchQuery();
    deviceSearchQuery2.setDeviceTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(deviceSearchQuery, deviceSearchQuery2);
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceSearchQuery(), null);
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceSearchQuery.equals(Object)",
    "int DeviceSearchQuery.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceSearchQuery(), "Different type to DeviceSearchQuery");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceSearchQuery}
   *   <li>{@link DeviceSearchQuery#setDeviceTypes(List)}
   *   <li>{@link DeviceSearchQuery#setParameters(RelationsSearchParameters)}
   *   <li>{@link DeviceSearchQuery#setRelationType(String)}
   *   <li>{@link DeviceSearchQuery#toString()}
   *   <li>{@link DeviceSearchQuery#getDeviceTypes()}
   *   <li>{@link DeviceSearchQuery#getParameters()}
   *   <li>{@link DeviceSearchQuery#getRelationType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceSearchQuery.<init>()",
    "List DeviceSearchQuery.getDeviceTypes()",
    "RelationsSearchParameters DeviceSearchQuery.getParameters()",
    "String DeviceSearchQuery.getRelationType()",
    "void DeviceSearchQuery.setDeviceTypes(List)",
    "void DeviceSearchQuery.setParameters(RelationsSearchParameters)",
    "void DeviceSearchQuery.setRelationType(String)",
    "String DeviceSearchQuery.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceSearchQuery actualDeviceSearchQuery = new DeviceSearchQuery();
    ArrayList<String> deviceTypes = new ArrayList<>();
    actualDeviceSearchQuery.setDeviceTypes(deviceTypes);
    RelationsSearchParameters parameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    actualDeviceSearchQuery.setParameters(parameters);
    actualDeviceSearchQuery.setRelationType("Relation Type");
    String actualToStringResult = actualDeviceSearchQuery.toString();
    List<String> actualDeviceTypes = actualDeviceSearchQuery.getDeviceTypes();
    RelationsSearchParameters actualParameters = actualDeviceSearchQuery.getParameters();

    // Assert
    assertEquals(
        "DeviceSearchQuery(parameters=RelationsSearchParameters(rootId=13814000-1dd2-11b2-8080-808080808080,"
            + " rootType=TENANT, direction=FROM, relationTypeGroup=COMMON, maxLevel=3, fetchLastLevelOnly=true),"
            + " relationType=Relation Type, deviceTypes=[])",
        actualToStringResult);
    assertEquals("Relation Type", actualDeviceSearchQuery.getRelationType());
    assertTrue(actualDeviceTypes.isEmpty());
    assertSame(deviceTypes, actualDeviceTypes);
    assertSame(parameters, actualParameters);
  }
}
