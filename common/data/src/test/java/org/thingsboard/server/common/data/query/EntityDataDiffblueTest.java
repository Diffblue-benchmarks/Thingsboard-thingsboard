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
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EntityDataDiffblueTest {
  /**
   * Test {@link EntityData#equals(Object)}, and {@link EntityData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityData#equals(Object)}
   *   <li>{@link EntityData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(TenantId.SYS_TENANT_ID, latest, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();
    EntityData entityData2 = new EntityData(TenantId.SYS_TENANT_ID, latest2, new HashMap<>());

    // Act and Assert
    assertEquals(entityData, entityData2);
    assertEquals(entityData.hashCode(), entityData2.hashCode());
  }

  /**
   * Test {@link EntityData#equals(Object)}, and {@link EntityData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityData#equals(Object)}
   *   <li>{@link EntityData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(null, latest, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();
    EntityData entityData2 = new EntityData(null, latest2, new HashMap<>());

    // Act and Assert
    assertEquals(entityData, entityData2);
    assertEquals(entityData.hashCode(), entityData2.hashCode());
  }

  /**
   * Test {@link EntityData#equals(Object)}, and {@link EntityData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityData#equals(Object)}
   *   <li>{@link EntityData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    HashMap<String, TsValue[]> timeseries = new HashMap<>();

    EntityData entityData =
        new EntityData(TenantId.SYS_TENANT_ID, latest, timeseries, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();
    HashMap<String, TsValue[]> timeseries2 = new HashMap<>();

    EntityData entityData2 =
        new EntityData(TenantId.SYS_TENANT_ID, latest2, timeseries2, new HashMap<>());

    // Act and Assert
    assertEquals(entityData, entityData2);
    assertEquals(entityData.hashCode(), entityData2.hashCode());
  }

  /**
   * Test {@link EntityData#equals(Object)}, and {@link EntityData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityData#equals(Object)}
   *   <li>{@link EntityData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(TenantId.SYS_TENANT_ID, latest, new HashMap<>());

    // Act and Assert
    assertEquals(entityData, entityData);
    int expectedHashCodeResult = entityData.hashCode();
    assertEquals(expectedHashCodeResult, entityData.hashCode());
  }

  /**
   * Test {@link EntityData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(null, latest, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();

    // Act and Assert
    assertNotEquals(entityData, new EntityData(TenantId.SYS_TENANT_ID, latest2, new HashMap<>()));
  }

  /**
   * Test {@link EntityData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmId entityId = new AlarmId(EntityId.NULL_UUID);
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();

    EntityData entityData = new EntityData(entityId, latest, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();

    // Act and Assert
    assertNotEquals(entityData, new EntityData(TenantId.SYS_TENANT_ID, latest2, new HashMap<>()));
  }

  /**
   * Test {@link EntityData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    latest.put(EntityKeyType.ATTRIBUTE, new HashMap<>());
    EntityData entityData = new EntityData(TenantId.SYS_TENANT_ID, latest, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();

    // Act and Assert
    assertNotEquals(entityData, new EntityData(TenantId.SYS_TENANT_ID, latest2, new HashMap<>()));
  }

  /**
   * Test {@link EntityData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashMap<String, TsValue[]> timeseries = new HashMap<>();
    timeseries.put("foo", new TsValue[] {TsValue.EMPTY});
    EntityData entityData = new EntityData(TenantId.SYS_TENANT_ID, new HashMap<>(), timeseries);
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();

    // Act and Assert
    assertNotEquals(entityData, new EntityData(TenantId.SYS_TENANT_ID, latest, new HashMap<>()));
  }

  /**
   * Test {@link EntityData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    HashMap<String, TsValue[]> timeseries = new HashMap<>();

    EntityData entityData =
        new EntityData(TenantId.SYS_TENANT_ID, latest, timeseries, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();

    // Act and Assert
    assertNotEquals(entityData, new EntityData(TenantId.SYS_TENANT_ID, latest2, new HashMap<>()));
  }

  /**
   * Test {@link EntityData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(TenantId.SYS_TENANT_ID, latest, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();
    HashMap<String, TsValue[]> timeseries = new HashMap<>();

    // Act and Assert
    assertNotEquals(
        entityData, new EntityData(TenantId.SYS_TENANT_ID, latest2, timeseries, new HashMap<>()));
  }

  /**
   * Test {@link EntityData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();

    // Act and Assert
    assertNotEquals(new EntityData(TenantId.SYS_TENANT_ID, latest, new HashMap<>()), null);
  }

  /**
   * Test {@link EntityData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();

    // Act and Assert
    assertNotEquals(
        new EntityData(TenantId.SYS_TENANT_ID, latest, new HashMap<>()),
        "Different type to EntityData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityData#EntityData(EntityId, Map, Map)}
   *   <li>{@link EntityData#toString()}
   *   <li>{@link EntityData#getAggLatest()}
   *   <li>{@link EntityData#getEntityId()}
   *   <li>{@link EntityData#getLatest()}
   *   <li>{@link EntityData#getTimeseries()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityData.<init>(EntityId, Map, Map)",
    "void EntityData.<init>(EntityId, Map, Map, Map)",
    "Map EntityData.getAggLatest()",
    "EntityId EntityData.getEntityId()",
    "Map EntityData.getLatest()",
    "Map EntityData.getTimeseries()",
    "String EntityData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    HashMap<String, TsValue[]> timeseries = new HashMap<>();

    // Act
    EntityData actualEntityData = new EntityData(TenantId.SYS_TENANT_ID, latest, timeseries);
    String actualToStringResult = actualEntityData.toString();
    Map<Integer, ComparisonTsValue> actualAggLatest = actualEntityData.getAggLatest();
    EntityId actualEntityId = actualEntityData.getEntityId();
    Map<EntityKeyType, Map<String, TsValue>> actualLatest = actualEntityData.getLatest();
    Map<String, TsValue[]> actualTimeseries = actualEntityData.getTimeseries();

    // Assert
    assertEquals(
        "EntityData(entityId=13814000-1dd2-11b2-8080-808080808080, latest={}, timeseries={}, aggLatest=null)",
        actualToStringResult);
    assertNull(actualAggLatest);
    assertTrue(actualLatest.isEmpty());
    assertTrue(actualTimeseries.isEmpty());
    assertSame(latest, actualLatest);
    assertSame(timeseries, actualTimeseries);
    assertSame(((TenantId) actualEntityId).SYS_TENANT_ID, actualEntityId);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityData#EntityData(EntityId, Map, Map, Map)}
   *   <li>{@link EntityData#toString()}
   *   <li>{@link EntityData#getAggLatest()}
   *   <li>{@link EntityData#getEntityId()}
   *   <li>{@link EntityData#getLatest()}
   *   <li>{@link EntityData#getTimeseries()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityData.<init>(EntityId, Map, Map)",
    "void EntityData.<init>(EntityId, Map, Map, Map)",
    "Map EntityData.getAggLatest()",
    "EntityId EntityData.getEntityId()",
    "Map EntityData.getLatest()",
    "Map EntityData.getTimeseries()",
    "String EntityData.toString()"
  })
  void testGettersAndSetters2() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    HashMap<String, TsValue[]> timeseries = new HashMap<>();
    HashMap<Integer, ComparisonTsValue> aggLatest = new HashMap<>();

    // Act
    EntityData actualEntityData =
        new EntityData(TenantId.SYS_TENANT_ID, latest, timeseries, aggLatest);
    String actualToStringResult = actualEntityData.toString();
    Map<Integer, ComparisonTsValue> actualAggLatest = actualEntityData.getAggLatest();
    EntityId actualEntityId = actualEntityData.getEntityId();
    Map<EntityKeyType, Map<String, TsValue>> actualLatest = actualEntityData.getLatest();
    Map<String, TsValue[]> actualTimeseries = actualEntityData.getTimeseries();

    // Assert
    assertEquals(
        "EntityData(entityId=13814000-1dd2-11b2-8080-808080808080, latest={}, timeseries={}, aggLatest={})",
        actualToStringResult);
    assertTrue(actualAggLatest.isEmpty());
    assertTrue(actualLatest.isEmpty());
    assertTrue(actualTimeseries.isEmpty());
    assertSame(aggLatest, actualAggLatest);
    assertSame(latest, actualLatest);
    assertSame(timeseries, actualTimeseries);
    assertSame(((TenantId) actualEntityId).SYS_TENANT_ID, actualEntityId);
  }
}
