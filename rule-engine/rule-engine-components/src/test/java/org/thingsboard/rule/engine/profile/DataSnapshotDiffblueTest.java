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
package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.profile.AlarmConditionFilterKey;
import org.thingsboard.server.common.data.device.profile.AlarmConditionKeyType;
import org.thingsboard.server.common.data.query.EntityKey;
import org.thingsboard.server.common.data.query.EntityKeyType;

class DataSnapshotDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DataSnapshot#DataSnapshot(Set)}
   *   <li>{@link DataSnapshot#setTs(long)}
   *   <li>{@link DataSnapshot#getTs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataSnapshot.<init>(Set)",
    "long DataSnapshot.getTs()",
    "void DataSnapshot.setTs(long)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DataSnapshot actualDataSnapshot = new DataSnapshot(new HashSet<>());
    actualDataSnapshot.setTs(1L);

    // Assert
    assertEquals(1L, actualDataSnapshot.getTs());
  }

  /**
   * Test {@link DataSnapshot#toConditionKey(EntityKey)}.
   *
   * <ul>
   *   <li>Then return Type is {@code ATTRIBUTE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#toConditionKey(EntityKey)}
   */
  @Test
  @DisplayName("Test toConditionKey(EntityKey); then return Type is 'ATTRIBUTE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmConditionFilterKey DataSnapshot.toConditionKey(EntityKey)"})
  void testToConditionKey_thenReturnTypeIsAttribute() {
    // Arrange and Act
    AlarmConditionFilterKey actualToConditionKeyResult =
        DataSnapshot.toConditionKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Assert
    assertEquals("Key", actualToConditionKeyResult.getKey());
    assertEquals(AlarmConditionKeyType.ATTRIBUTE, actualToConditionKeyResult.getType());
  }

  /**
   * Test {@link DataSnapshot#toConditionKey(EntityKey)}.
   *
   * <ul>
   *   <li>Then return Type is {@code ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#toConditionKey(EntityKey)}
   */
  @Test
  @DisplayName("Test toConditionKey(EntityKey); then return Type is 'ENTITY_FIELD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmConditionFilterKey DataSnapshot.toConditionKey(EntityKey)"})
  void testToConditionKey_thenReturnTypeIsEntityField() {
    // Arrange and Act
    AlarmConditionFilterKey actualToConditionKeyResult =
        DataSnapshot.toConditionKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "Key"));

    // Assert
    assertEquals("Key", actualToConditionKeyResult.getKey());
    assertEquals(AlarmConditionKeyType.ENTITY_FIELD, actualToConditionKeyResult.getType());
  }

  /**
   * Test {@link DataSnapshot#toConditionKey(EntityKey)}.
   *
   * <ul>
   *   <li>Then return Type is {@code TIME_SERIES}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#toConditionKey(EntityKey)}
   */
  @Test
  @DisplayName("Test toConditionKey(EntityKey); then return Type is 'TIME_SERIES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmConditionFilterKey DataSnapshot.toConditionKey(EntityKey)"})
  void testToConditionKey_thenReturnTypeIsTimeSeries() {
    // Arrange and Act
    AlarmConditionFilterKey actualToConditionKeyResult =
        DataSnapshot.toConditionKey(new EntityKey(EntityKeyType.TIME_SERIES, "Key"));

    // Assert
    assertEquals("Key", actualToConditionKeyResult.getKey());
    assertEquals(AlarmConditionKeyType.TIME_SERIES, actualToConditionKeyResult.getType());
  }

  /**
   * Test {@link DataSnapshot#toConditionKey(EntityKey)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#toConditionKey(EntityKey)}
   */
  @Test
  @DisplayName("Test toConditionKey(EntityKey); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmConditionFilterKey DataSnapshot.toConditionKey(EntityKey)"})
  void testToConditionKey_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> DataSnapshot.toConditionKey(new EntityKey(EntityKeyType.ALARM_FIELD, "Key")));
  }

  /**
   * Test {@link DataSnapshot#toConditionKeyType(EntityKeyType)}.
   *
   * <ul>
   *   <li>When {@code ALARM_FIELD}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#toConditionKeyType(EntityKeyType)}
   */
  @Test
  @DisplayName(
      "Test toConditionKeyType(EntityKeyType); when 'ALARM_FIELD'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmConditionKeyType DataSnapshot.toConditionKeyType(EntityKeyType)"})
  void testToConditionKeyType_whenAlarmField_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> DataSnapshot.toConditionKeyType(EntityKeyType.ALARM_FIELD));
  }

  /**
   * Test {@link DataSnapshot#toConditionKeyType(EntityKeyType)}.
   *
   * <ul>
   *   <li>When {@code ATTRIBUTE}.
   *   <li>Then return {@code ATTRIBUTE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#toConditionKeyType(EntityKeyType)}
   */
  @Test
  @DisplayName("Test toConditionKeyType(EntityKeyType); when 'ATTRIBUTE'; then return 'ATTRIBUTE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmConditionKeyType DataSnapshot.toConditionKeyType(EntityKeyType)"})
  void testToConditionKeyType_whenAttribute_thenReturnAttribute() {
    // Arrange, Act and Assert
    assertEquals(
        AlarmConditionKeyType.ATTRIBUTE, DataSnapshot.toConditionKeyType(EntityKeyType.ATTRIBUTE));
  }

  /**
   * Test {@link DataSnapshot#toConditionKeyType(EntityKeyType)}.
   *
   * <ul>
   *   <li>When {@code ENTITY_FIELD}.
   *   <li>Then return {@code ENTITY_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#toConditionKeyType(EntityKeyType)}
   */
  @Test
  @DisplayName(
      "Test toConditionKeyType(EntityKeyType); when 'ENTITY_FIELD'; then return 'ENTITY_FIELD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmConditionKeyType DataSnapshot.toConditionKeyType(EntityKeyType)"})
  void testToConditionKeyType_whenEntityField_thenReturnEntityField() {
    // Arrange, Act and Assert
    assertEquals(
        AlarmConditionKeyType.ENTITY_FIELD,
        DataSnapshot.toConditionKeyType(EntityKeyType.ENTITY_FIELD));
  }

  /**
   * Test {@link DataSnapshot#toConditionKeyType(EntityKeyType)}.
   *
   * <ul>
   *   <li>When {@code TIME_SERIES}.
   *   <li>Then return {@code TIME_SERIES}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#toConditionKeyType(EntityKeyType)}
   */
  @Test
  @DisplayName(
      "Test toConditionKeyType(EntityKeyType); when 'TIME_SERIES'; then return 'TIME_SERIES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmConditionKeyType DataSnapshot.toConditionKeyType(EntityKeyType)"})
  void testToConditionKeyType_whenTimeSeries_thenReturnTimeSeries() {
    // Arrange, Act and Assert
    assertEquals(
        AlarmConditionKeyType.TIME_SERIES,
        DataSnapshot.toConditionKeyType(EntityKeyType.TIME_SERIES));
  }

  /**
   * Test {@link DataSnapshot#removeValue(EntityKey)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#removeValue(EntityKey)}
   */
  @Test
  @DisplayName("Test removeValue(EntityKey); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataSnapshot.removeValue(EntityKey)"})
  void testRemoveValue_thenThrowRuntimeException() {
    // Arrange
    DataSnapshot dataSnapshot = new DataSnapshot(new HashSet<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> dataSnapshot.removeValue(new EntityKey(EntityKeyType.ALARM_FIELD, "Key")));
  }

  /**
   * Test {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   *
   * <p>Method under test: {@link DataSnapshot#putValue(AlarmConditionFilterKey, long,
   * EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataSnapshot.putValue(AlarmConditionFilterKey, long, EntityKeyValue)"
  })
  void testPutValue() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");
    dataSnapshot.putValue(key, 59L, EntityKeyValue.fromBool(true));
    dataSnapshot.setTs(1L);
    AlarmConditionFilterKey key2 =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertFalse(dataSnapshot.putValue(key2, 1L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   *
   * <p>Method under test: {@link DataSnapshot#putValue(AlarmConditionFilterKey, long,
   * EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataSnapshot.putValue(AlarmConditionFilterKey, long, EntityKeyValue)"
  })
  void testPutValue2() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");
    dataSnapshot.putValue(key, 59L, EntityKeyValue.fromBool(false));
    dataSnapshot.setTs(1L);
    AlarmConditionFilterKey key2 =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key2, 1L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   *
   * <p>Method under test: {@link DataSnapshot#putValue(AlarmConditionFilterKey, long,
   * EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataSnapshot.putValue(AlarmConditionFilterKey, long, EntityKeyValue)"
  })
  void testPutValue3() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");
    dataSnapshot.putValue(key, 59L, new EntityKeyValue());
    dataSnapshot.setTs(1L);
    AlarmConditionFilterKey key2 =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key2, 1L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   *
   * <p>Method under test: {@link DataSnapshot#putValue(AlarmConditionFilterKey, long,
   * EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataSnapshot.putValue(AlarmConditionFilterKey, long, EntityKeyValue)"
  })
  void testPutValue4() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");
    dataSnapshot.putValue(key, 59L, EntityKeyValue.fromDouble(10.0d));
    dataSnapshot.setTs(1L);
    AlarmConditionFilterKey key2 =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key2, 1L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   *
   * <p>Method under test: {@link DataSnapshot#putValue(AlarmConditionFilterKey, long,
   * EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataSnapshot.putValue(AlarmConditionFilterKey, long, EntityKeyValue)"
  })
  void testPutValue5() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");
    dataSnapshot.putValue(key, 59L, EntityKeyValue.fromBool(true));
    dataSnapshot.setTs(1L);
    AlarmConditionFilterKey key2 =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key2, 1L, EntityKeyValue.fromDouble(10.0d)));
  }

  /**
   * Test {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   *
   * <p>Method under test: {@link DataSnapshot#putValue(AlarmConditionFilterKey, long,
   * EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataSnapshot.putValue(AlarmConditionFilterKey, long, EntityKeyValue)"
  })
  void testPutValue6() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");
    dataSnapshot.putValue(key, 59L, EntityKeyValue.fromDouble(10.0d));
    dataSnapshot.setTs(1L);
    AlarmConditionFilterKey key2 =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertFalse(dataSnapshot.putValue(key2, 1L, EntityKeyValue.fromDouble(10.0d)));
  }

  /**
   * Test {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   *
   * <p>Method under test: {@link DataSnapshot#putValue(AlarmConditionFilterKey, long,
   * EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataSnapshot.putValue(AlarmConditionFilterKey, long, EntityKeyValue)"
  })
  void testPutValue7() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");
    dataSnapshot.putValue(key, 59L, EntityKeyValue.fromJson("foo"));
    dataSnapshot.setTs(1L);
    AlarmConditionFilterKey key2 =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key2, 1L, new EntityKeyValue()));
  }

  /**
   * Test {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   *
   * <ul>
   *   <li>Given {@link DataSnapshot#DataSnapshot(Set)} with entityKeysToFetch is {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#putValue(AlarmConditionFilterKey, long,
   * EntityKeyValue)}
   */
  @Test
  @DisplayName(
      "Test putValue(AlarmConditionFilterKey, long, EntityKeyValue); given DataSnapshot(Set) with entityKeysToFetch is HashSet(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataSnapshot.putValue(AlarmConditionFilterKey, long, EntityKeyValue)"
  })
  void testPutValue_givenDataSnapshotWithEntityKeysToFetchIsHashSet_thenReturnFalse() {
    // Arrange
    DataSnapshot dataSnapshot = new DataSnapshot(new HashSet<>());
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertFalse(dataSnapshot.putValue(key, 1L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   *
   * <ul>
   *   <li>Given {@link DataSnapshot#DataSnapshot(Set)} with entityKeysToFetch is {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#putValue(AlarmConditionFilterKey, long,
   * EntityKeyValue)}
   */
  @Test
  @DisplayName(
      "Test putValue(AlarmConditionFilterKey, long, EntityKeyValue); given DataSnapshot(Set) with entityKeysToFetch is HashSet(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataSnapshot.putValue(AlarmConditionFilterKey, long, EntityKeyValue)"
  })
  void testPutValue_givenDataSnapshotWithEntityKeysToFetchIsHashSet_thenReturnTrue() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key, 1L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   *
   * <ul>
   *   <li>When {@link EntityKeyValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#putValue(AlarmConditionFilterKey, long,
   * EntityKeyValue)}
   */
  @Test
  @DisplayName(
      "Test putValue(AlarmConditionFilterKey, long, EntityKeyValue); when EntityKeyValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataSnapshot.putValue(AlarmConditionFilterKey, long, EntityKeyValue)"
  })
  void testPutValue_whenEntityKeyValue() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");
    dataSnapshot.putValue(key, 59L, new EntityKeyValue());
    dataSnapshot.setTs(1L);
    AlarmConditionFilterKey key2 =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertFalse(dataSnapshot.putValue(key2, 1L, new EntityKeyValue()));
  }

  /**
   * Test {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   *
   * <ul>
   *   <li>When fromBool {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#putValue(AlarmConditionFilterKey, long,
   * EntityKeyValue)}
   */
  @Test
  @DisplayName(
      "Test putValue(AlarmConditionFilterKey, long, EntityKeyValue); when fromBool 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataSnapshot.putValue(AlarmConditionFilterKey, long, EntityKeyValue)"
  })
  void testPutValue_whenFromBoolTrue_thenReturnFalse() {
    // Arrange
    DataSnapshot dataSnapshot = new DataSnapshot(new HashSet<>());
    dataSnapshot.setTs(1L);
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertFalse(dataSnapshot.putValue(key, 1L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   *
   * <ul>
   *   <li>When fromBool {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#putValue(AlarmConditionFilterKey, long,
   * EntityKeyValue)}
   */
  @Test
  @DisplayName(
      "Test putValue(AlarmConditionFilterKey, long, EntityKeyValue); when fromBool 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataSnapshot.putValue(AlarmConditionFilterKey, long, EntityKeyValue)"
  })
  void testPutValue_whenFromBoolTrue_thenReturnTrue() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    dataSnapshot.setTs(1L);
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key, 1L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   *
   * <ul>
   *   <li>When fromJson {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#putValue(AlarmConditionFilterKey, long,
   * EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue); when fromJson 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataSnapshot.putValue(AlarmConditionFilterKey, long, EntityKeyValue)"
  })
  void testPutValue_whenFromJsonFoo() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");
    dataSnapshot.putValue(key, 59L, new EntityKeyValue());
    dataSnapshot.setTs(1L);
    AlarmConditionFilterKey key2 =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key2, 1L, EntityKeyValue.fromJson("foo")));
  }

  /**
   * Test {@link DataSnapshot#getValue(AlarmConditionFilterKey)}.
   *
   * <ul>
   *   <li>When {@link AlarmConditionFilterKey#AlarmConditionFilterKey(AlarmConditionKeyType,
   *       String)} with type is {@code ATTRIBUTE} and {@code Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataSnapshot#getValue(AlarmConditionFilterKey)}
   */
  @Test
  @DisplayName(
      "Test getValue(AlarmConditionFilterKey); when AlarmConditionFilterKey(AlarmConditionKeyType, String) with type is 'ATTRIBUTE' and 'Key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKeyValue DataSnapshot.getValue(AlarmConditionFilterKey)"})
  void testGetValue_whenAlarmConditionFilterKeyWithTypeIsAttributeAndKey_thenReturnNull() {
    // Arrange
    DataSnapshot dataSnapshot = new DataSnapshot(new HashSet<>());

    // Act
    EntityKeyValue actualValue =
        dataSnapshot.getValue(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    // Assert
    assertNull(actualValue);
  }
}
