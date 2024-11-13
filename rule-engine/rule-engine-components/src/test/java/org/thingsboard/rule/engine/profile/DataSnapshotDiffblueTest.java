package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.profile.AlarmConditionFilterKey;
import org.thingsboard.server.common.data.device.profile.AlarmConditionKeyType;
import org.thingsboard.server.common.data.query.EntityKey;
import org.thingsboard.server.common.data.query.EntityKeyType;

class DataSnapshotDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataSnapshot#DataSnapshot(Set)}
   *   <li>{@link DataSnapshot#setTs(long)}
   *   <li>{@link DataSnapshot#getTs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    DataSnapshot actualDataSnapshot = new DataSnapshot(new HashSet<>());
    actualDataSnapshot.setTs(1L);

    // Assert that nothing has changed
    assertEquals(1L, actualDataSnapshot.getTs());
  }

  /**
   * Test {@link DataSnapshot#toConditionKey(EntityKey)}.
   * <ul>
   *   <li>Then return Type is {@code ATTRIBUTE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSnapshot#toConditionKey(EntityKey)}
   */
  @Test
  @DisplayName("Test toConditionKey(EntityKey); then return Type is 'ATTRIBUTE'")
  void testToConditionKey_thenReturnTypeIsAttribute() {
    // Arrange and Act
    AlarmConditionFilterKey actualToConditionKeyResult = DataSnapshot
        .toConditionKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Assert
    assertEquals("Key", actualToConditionKeyResult.getKey());
    assertEquals(AlarmConditionKeyType.ATTRIBUTE, actualToConditionKeyResult.getType());
  }

  /**
   * Test {@link DataSnapshot#toConditionKey(EntityKey)}.
   * <ul>
   *   <li>Then return Type is {@code ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSnapshot#toConditionKey(EntityKey)}
   */
  @Test
  @DisplayName("Test toConditionKey(EntityKey); then return Type is 'ENTITY_FIELD'")
  void testToConditionKey_thenReturnTypeIsEntityField() {
    // Arrange and Act
    AlarmConditionFilterKey actualToConditionKeyResult = DataSnapshot
        .toConditionKey(new EntityKey(EntityKeyType.ENTITY_FIELD, "Key"));

    // Assert
    assertEquals("Key", actualToConditionKeyResult.getKey());
    assertEquals(AlarmConditionKeyType.ENTITY_FIELD, actualToConditionKeyResult.getType());
  }

  /**
   * Test {@link DataSnapshot#toConditionKey(EntityKey)}.
   * <ul>
   *   <li>Then return Type is {@code TIME_SERIES}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSnapshot#toConditionKey(EntityKey)}
   */
  @Test
  @DisplayName("Test toConditionKey(EntityKey); then return Type is 'TIME_SERIES'")
  void testToConditionKey_thenReturnTypeIsTimeSeries() {
    // Arrange and Act
    AlarmConditionFilterKey actualToConditionKeyResult = DataSnapshot
        .toConditionKey(new EntityKey(EntityKeyType.TIME_SERIES, "Key"));

    // Assert
    assertEquals("Key", actualToConditionKeyResult.getKey());
    assertEquals(AlarmConditionKeyType.TIME_SERIES, actualToConditionKeyResult.getType());
  }

  /**
   * Test {@link DataSnapshot#toConditionKey(EntityKey)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSnapshot#toConditionKey(EntityKey)}
   */
  @Test
  @DisplayName("Test toConditionKey(EntityKey); then throw RuntimeException")
  void testToConditionKey_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> DataSnapshot.toConditionKey(new EntityKey(EntityKeyType.ALARM_FIELD, "Key")));
  }

  /**
   * Test {@link DataSnapshot#toConditionKeyType(EntityKeyType)}.
   * <ul>
   *   <li>When {@code ALARM_FIELD}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSnapshot#toConditionKeyType(EntityKeyType)}
   */
  @Test
  @DisplayName("Test toConditionKeyType(EntityKeyType); when 'ALARM_FIELD'; then throw RuntimeException")
  void testToConditionKeyType_whenAlarmField_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> DataSnapshot.toConditionKeyType(EntityKeyType.ALARM_FIELD));
  }

  /**
   * Test {@link DataSnapshot#toConditionKeyType(EntityKeyType)}.
   * <ul>
   *   <li>When {@code ATTRIBUTE}.</li>
   *   <li>Then return {@code ATTRIBUTE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSnapshot#toConditionKeyType(EntityKeyType)}
   */
  @Test
  @DisplayName("Test toConditionKeyType(EntityKeyType); when 'ATTRIBUTE'; then return 'ATTRIBUTE'")
  void testToConditionKeyType_whenAttribute_thenReturnAttribute() {
    // Arrange, Act and Assert
    assertEquals(AlarmConditionKeyType.ATTRIBUTE, DataSnapshot.toConditionKeyType(EntityKeyType.ATTRIBUTE));
  }

  /**
   * Test {@link DataSnapshot#toConditionKeyType(EntityKeyType)}.
   * <ul>
   *   <li>When {@code ENTITY_FIELD}.</li>
   *   <li>Then return {@code ENTITY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSnapshot#toConditionKeyType(EntityKeyType)}
   */
  @Test
  @DisplayName("Test toConditionKeyType(EntityKeyType); when 'ENTITY_FIELD'; then return 'ENTITY_FIELD'")
  void testToConditionKeyType_whenEntityField_thenReturnEntityField() {
    // Arrange, Act and Assert
    assertEquals(AlarmConditionKeyType.ENTITY_FIELD, DataSnapshot.toConditionKeyType(EntityKeyType.ENTITY_FIELD));
  }

  /**
   * Test {@link DataSnapshot#toConditionKeyType(EntityKeyType)}.
   * <ul>
   *   <li>When {@code TIME_SERIES}.</li>
   *   <li>Then return {@code TIME_SERIES}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSnapshot#toConditionKeyType(EntityKeyType)}
   */
  @Test
  @DisplayName("Test toConditionKeyType(EntityKeyType); when 'TIME_SERIES'; then return 'TIME_SERIES'")
  void testToConditionKeyType_whenTimeSeries_thenReturnTimeSeries() {
    // Arrange, Act and Assert
    assertEquals(AlarmConditionKeyType.TIME_SERIES, DataSnapshot.toConditionKeyType(EntityKeyType.TIME_SERIES));
  }

  /**
   * Test {@link DataSnapshot#removeValue(EntityKey)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSnapshot#removeValue(EntityKey)}
   */
  @Test
  @DisplayName("Test removeValue(EntityKey); then throw RuntimeException")
  void testRemoveValue_thenThrowRuntimeException() {
    // Arrange
    DataSnapshot dataSnapshot = new DataSnapshot(new HashSet<>());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> dataSnapshot.removeValue(new EntityKey(EntityKeyType.ALARM_FIELD, "Key")));
  }

  /**
   * Test
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   * <p>
   * Method under test:
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  void testPutValue() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    dataSnapshot.putValue(key, 59L, EntityKeyValue.fromBool(true));
    AlarmConditionFilterKey key2 = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertFalse(dataSnapshot.putValue(key2, 0L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   * <p>
   * Method under test:
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  void testPutValue2() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    dataSnapshot.putValue(key, 59L, EntityKeyValue.fromBool(false));
    AlarmConditionFilterKey key2 = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key2, 0L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   * <p>
   * Method under test:
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  void testPutValue3() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    dataSnapshot.putValue(key, 59L, new EntityKeyValue());
    AlarmConditionFilterKey key2 = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key2, 0L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   * <p>
   * Method under test:
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  void testPutValue4() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    dataSnapshot.putValue(key, 59L, EntityKeyValue.fromDouble(10.0d));
    AlarmConditionFilterKey key2 = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key2, 0L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   * <p>
   * Method under test:
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  void testPutValue5() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    dataSnapshot.putValue(key, 59L, EntityKeyValue.fromBool(true));
    AlarmConditionFilterKey key2 = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key2, 0L, EntityKeyValue.fromDouble(10.0d)));
  }

  /**
   * Test
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   * <p>
   * Method under test:
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  void testPutValue6() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    dataSnapshot.putValue(key, 59L, EntityKeyValue.fromDouble(10.0d));
    AlarmConditionFilterKey key2 = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertFalse(dataSnapshot.putValue(key2, 0L, EntityKeyValue.fromDouble(10.0d)));
  }

  /**
   * Test
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   * <p>
   * Method under test:
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue)")
  void testPutValue7() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    dataSnapshot.putValue(key, 59L, EntityKeyValue.fromJson("foo"));
    AlarmConditionFilterKey key2 = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key2, 0L, new EntityKeyValue()));
  }

  /**
   * Test
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   * <ul>
   *   <li>When {@link EntityKeyValue} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue); when EntityKeyValue (default constructor)")
  void testPutValue_whenEntityKeyValue() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    dataSnapshot.putValue(key, 59L, new EntityKeyValue());
    AlarmConditionFilterKey key2 = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertFalse(dataSnapshot.putValue(key2, 0L, new EntityKeyValue()));
  }

  /**
   * Test
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   * <ul>
   *   <li>When fromBool {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue); when fromBool 'true'; then return 'false'")
  void testPutValue_whenFromBoolTrue_thenReturnFalse() {
    // Arrange
    DataSnapshot dataSnapshot = new DataSnapshot(new HashSet<>());
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertFalse(dataSnapshot.putValue(key, 0L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   * <ul>
   *   <li>When fromBool {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue); when fromBool 'true'; then return 'true'")
  void testPutValue_whenFromBoolTrue_thenReturnTrue() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key, 0L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   * <ul>
   *   <li>When fromJson {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue); when fromJson 'foo'")
  void testPutValue_whenFromJsonFoo() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    dataSnapshot.putValue(key, 59L, new EntityKeyValue());
    AlarmConditionFilterKey key2 = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key2, 0L, EntityKeyValue.fromJson("foo")));
  }

  /**
   * Test
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue); when one; then return 'false'")
  void testPutValue_whenOne_thenReturnFalse() {
    // Arrange
    DataSnapshot dataSnapshot = new DataSnapshot(new HashSet<>());
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertFalse(dataSnapshot.putValue(key, 1L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataSnapshot#putValue(AlarmConditionFilterKey, long, EntityKeyValue)}
   */
  @Test
  @DisplayName("Test putValue(AlarmConditionFilterKey, long, EntityKeyValue); when one; then return 'true'")
  void testPutValue_whenOne_thenReturnTrue() {
    // Arrange
    HashSet<AlarmConditionFilterKey> entityKeysToFetch = new HashSet<>();
    entityKeysToFetch.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    DataSnapshot dataSnapshot = new DataSnapshot(entityKeysToFetch);
    AlarmConditionFilterKey key = new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertTrue(dataSnapshot.putValue(key, 1L, EntityKeyValue.fromBool(true)));
  }

  /**
   * Test {@link DataSnapshot#getValue(AlarmConditionFilterKey)}.
   * <ul>
   *   <li>When
   * {@link AlarmConditionFilterKey#AlarmConditionFilterKey(AlarmConditionKeyType, String)}
   * with type is {@code ATTRIBUTE} and {@code Key}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSnapshot#getValue(AlarmConditionFilterKey)}
   */
  @Test
  @DisplayName("Test getValue(AlarmConditionFilterKey); when AlarmConditionFilterKey(AlarmConditionKeyType, String) with type is 'ATTRIBUTE' and 'Key'; then return 'null'")
  void testGetValue_whenAlarmConditionFilterKeyWithTypeIsAttributeAndKey_thenReturnNull() {
    // Arrange
    DataSnapshot dataSnapshot = new DataSnapshot(new HashSet<>());

    // Act and Assert
    assertNull(dataSnapshot.getValue(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key")));
  }
}
