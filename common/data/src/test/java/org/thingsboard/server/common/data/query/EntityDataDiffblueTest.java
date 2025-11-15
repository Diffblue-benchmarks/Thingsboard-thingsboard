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
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EntityDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityData#equals(Object)}
   *   <li>{@link EntityData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(TenantId.SYS_TENANT_ID, latest, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();
    EntityData entityData2 = new EntityData(TenantId.SYS_TENANT_ID, latest2, new HashMap<>());

    // Act and Assert
    assertEquals(entityData, entityData2);
    int expectedHashCodeResult = entityData.hashCode();
    assertEquals(expectedHashCodeResult, entityData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityData#equals(Object)}
   *   <li>{@link EntityData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(null, latest, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();
    EntityData entityData2 = new EntityData(null, latest2, new HashMap<>());

    // Act and Assert
    assertEquals(entityData, entityData2);
    int expectedHashCodeResult = entityData.hashCode();
    assertEquals(expectedHashCodeResult, entityData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityData#equals(Object)}
   *   <li>{@link EntityData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    HashMap<String, TsValue[]> timeseries = new HashMap<>();
    EntityData entityData = new EntityData(TenantId.SYS_TENANT_ID, latest, timeseries, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();
    HashMap<String, TsValue[]> timeseries2 = new HashMap<>();
    EntityData entityData2 = new EntityData(TenantId.SYS_TENANT_ID, latest2, timeseries2, new HashMap<>());

    // Act and Assert
    assertEquals(entityData, entityData2);
    int expectedHashCodeResult = entityData.hashCode();
    assertEquals(expectedHashCodeResult, entityData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityData#equals(Object)}
   *   <li>{@link EntityData#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(null, latest, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();

    // Act and Assert
    assertNotEquals(entityData, new EntityData(TenantId.SYS_TENANT_ID, latest2, new HashMap<>()));
  }

  /**
   * Method under test: {@link EntityData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(entityId, latest, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();

    // Act and Assert
    assertNotEquals(entityData, new EntityData(TenantId.SYS_TENANT_ID, latest2, new HashMap<>()));
  }

  /**
   * Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    latest.put(EntityKeyType.ATTRIBUTE, new HashMap<>());
    EntityData entityData = new EntityData(TenantId.SYS_TENANT_ID, latest, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();

    // Act and Assert
    assertNotEquals(entityData, new EntityData(TenantId.SYS_TENANT_ID, latest2, new HashMap<>()));
  }

  /**
   * Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashMap<String, TsValue[]> timeseries = new HashMap<>();
    timeseries.put("foo", new TsValue[]{TsValue.EMPTY});
    EntityData entityData = new EntityData(TenantId.SYS_TENANT_ID, new HashMap<>(), timeseries);
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();

    // Act and Assert
    assertNotEquals(entityData, new EntityData(TenantId.SYS_TENANT_ID, latest, new HashMap<>()));
  }

  /**
   * Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    HashMap<String, TsValue[]> timeseries = new HashMap<>();
    EntityData entityData = new EntityData(TenantId.SYS_TENANT_ID, latest, timeseries, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();

    // Act and Assert
    assertNotEquals(entityData, new EntityData(TenantId.SYS_TENANT_ID, latest2, new HashMap<>()));
  }

  /**
   * Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData entityData = new EntityData(TenantId.SYS_TENANT_ID, latest, new HashMap<>());
    HashMap<EntityKeyType, Map<String, TsValue>> latest2 = new HashMap<>();
    HashMap<String, TsValue[]> timeseries = new HashMap<>();

    // Act and Assert
    assertNotEquals(entityData, new EntityData(TenantId.SYS_TENANT_ID, latest2, timeseries, new HashMap<>()));
  }

  /**
   * Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();

    // Act and Assert
    assertNotEquals(new EntityData(TenantId.SYS_TENANT_ID, latest, new HashMap<>()), null);
  }

  /**
   * Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();

    // Act and Assert
    assertNotEquals(new EntityData(TenantId.SYS_TENANT_ID, latest, new HashMap<>()), "Different type to EntityData");
  }

  /**
   * Methods under test:
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
    assertEquals("EntityData(entityId=13814000-1dd2-11b2-8080-808080808080, latest={}, timeseries={}, aggLatest=null)",
        actualToStringResult);
    assertNull(actualAggLatest);
    assertTrue(actualLatest.isEmpty());
    assertTrue(actualTimeseries.isEmpty());
    assertSame(latest, actualLatest);
    assertSame(timeseries, actualTimeseries);
    assertSame(((TenantId) actualEntityId).SYS_TENANT_ID, actualEntityId);
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters2() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    HashMap<String, TsValue[]> timeseries = new HashMap<>();
    HashMap<Integer, ComparisonTsValue> aggLatest = new HashMap<>();

    // Act
    EntityData actualEntityData = new EntityData(TenantId.SYS_TENANT_ID, latest, timeseries, aggLatest);
    String actualToStringResult = actualEntityData.toString();
    Map<Integer, ComparisonTsValue> actualAggLatest = actualEntityData.getAggLatest();
    EntityId actualEntityId = actualEntityData.getEntityId();
    Map<EntityKeyType, Map<String, TsValue>> actualLatest = actualEntityData.getLatest();
    Map<String, TsValue[]> actualTimeseries = actualEntityData.getTimeseries();

    // Assert
    assertEquals("EntityData(entityId=13814000-1dd2-11b2-8080-808080808080, latest={}, timeseries={}, aggLatest={})",
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
