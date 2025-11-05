package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;

class AttributeKvEntityDiffblueTest {
  /**
   * Test {@link AttributeKvEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) BooleanValue is {@code true}.
   *   <li>Then Kv return {@link BooleanDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AttributeKvEntity (default constructor) BooleanValue is 'true'; then Kv return BooleanDataEntry")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeKvEntry AttributeKvEntity.toData()"})
  void testToData_givenAttributeKvEntityBooleanValueIsTrue_thenKvReturnBooleanDataEntry() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setId(id);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setVersion(1L);
    attributeKvEntity.setStrValue(null);
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setLongValue(1L);
    attributeKvEntity.setJsonValue("foo");

    // Act
    AttributeKvEntry actualToDataResult = attributeKvEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) actualToDataResult).getKv() instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, actualToDataResult.getDataType());
    Optional<Double> doubleValue = actualToDataResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue((Boolean) actualToDataResult.getValue());
    assertEquals(Boolean.TRUE.toString(), actualToDataResult.getValueAsString());
    assertSame(doubleValue, actualToDataResult.getJsonValue());
    assertSame(doubleValue, actualToDataResult.getLongValue());
    assertSame(doubleValue, actualToDataResult.getStrValue());
  }

  /**
   * Test {@link AttributeKvEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) DoubleValue is {@code null}.
   *   <li>Then Kv return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AttributeKvEntity (default constructor) DoubleValue is 'null'; then Kv return LongDataEntry")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeKvEntry AttributeKvEntity.toData()"})
  void testToData_givenAttributeKvEntityDoubleValueIsNull_thenKvReturnLongDataEntry() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setId(id);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setVersion(1L);
    attributeKvEntity.setStrValue(null);
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setLongValue(1L);
    attributeKvEntity.setJsonValue("foo");

    // Act
    AttributeKvEntry actualToDataResult = attributeKvEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) actualToDataResult).getKv();
    assertTrue(kv instanceof LongDataEntry);
    assertEquals("1", kv.getValueAsString());
    assertEquals("1", actualToDataResult.getValueAsString());
    Optional<Long> longValue = actualToDataResult.getLongValue();
    assertEquals(1L, longValue.get().longValue());
    assertEquals(1L, ((Long) kv.getValue()).longValue());
    assertEquals(1L, ((Long) actualToDataResult.getValue()).longValue());
    assertEquals(DataType.LONG, kv.getDataType());
    assertEquals(DataType.LONG, actualToDataResult.getDataType());
    assertTrue(longValue.isPresent());
    assertEquals(longValue, kv.getLongValue());
  }

  /**
   * Test {@link AttributeKvEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) DoubleValue is ten.
   *   <li>Then Kv return {@link DoubleDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AttributeKvEntity (default constructor) DoubleValue is ten; then Kv return DoubleDataEntry")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeKvEntry AttributeKvEntity.toData()"})
  void testToData_givenAttributeKvEntityDoubleValueIsTen_thenKvReturnDoubleDataEntry() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setId(id);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setVersion(1L);
    attributeKvEntity.setStrValue(null);
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setLongValue(1L);
    attributeKvEntity.setJsonValue("foo");

    // Act
    AttributeKvEntry actualToDataResult = attributeKvEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) actualToDataResult).getKv();
    assertTrue(kv instanceof DoubleDataEntry);
    assertEquals("10.0", kv.getValueAsString());
    assertEquals("10.0", actualToDataResult.getValueAsString());
    Optional<Double> doubleValue = actualToDataResult.getDoubleValue();
    assertEquals(10.0d, doubleValue.get().doubleValue());
    assertEquals(10.0d, ((Double) kv.getValue()).doubleValue());
    assertEquals(10.0d, ((Double) actualToDataResult.getValue()).doubleValue());
    assertEquals(DataType.DOUBLE, kv.getDataType());
    assertEquals(DataType.DOUBLE, actualToDataResult.getDataType());
    assertTrue(doubleValue.isPresent());
    assertEquals(doubleValue, kv.getDoubleValue());
  }

  /**
   * Test {@link AttributeKvEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) JsonValue is {@code null}.
   *   <li>Then return Kv is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AttributeKvEntity (default constructor) JsonValue is 'null'; then return Kv is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeKvEntry AttributeKvEntity.toData()"})
  void testToData_givenAttributeKvEntityJsonValueIsNull_thenReturnKvIsNull() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setId(id);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setVersion(1L);
    attributeKvEntity.setStrValue(null);
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setJsonValue(null);

    // Act
    AttributeKvEntry actualToDataResult = attributeKvEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BaseAttributeKvEntry);
    assertNull(((BaseAttributeKvEntry) actualToDataResult).getKv());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getLastUpdateTs());
  }

  /**
   * Test {@link AttributeKvEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) LongValue is {@code null}.
   *   <li>Then Kv return {@link JsonDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AttributeKvEntity (default constructor) LongValue is 'null'; then Kv return JsonDataEntry")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeKvEntry AttributeKvEntity.toData()"})
  void testToData_givenAttributeKvEntityLongValueIsNull_thenKvReturnJsonDataEntry() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setId(id);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setVersion(1L);
    attributeKvEntity.setStrValue(null);
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setJsonValue("foo");

    // Act
    AttributeKvEntry actualToDataResult = attributeKvEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) actualToDataResult).getKv();
    assertTrue(kv instanceof JsonDataEntry);
    Optional<String> jsonValue = actualToDataResult.getJsonValue();
    assertEquals("foo", jsonValue.get());
    assertEquals("foo", kv.getValueAsString());
    assertEquals("foo", kv.getValue());
    assertEquals(DataType.JSON, kv.getDataType());
    assertEquals(DataType.JSON, actualToDataResult.getDataType());
    assertTrue(jsonValue.isPresent());
    assertEquals(jsonValue, kv.getJsonValue());
  }

  /**
   * Test {@link AttributeKvEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) StrValue is {@code foo}.
   *   <li>Then Kv return {@link StringDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AttributeKvEntity (default constructor) StrValue is 'foo'; then Kv return StringDataEntry")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeKvEntry AttributeKvEntity.toData()"})
  void testToData_givenAttributeKvEntityStrValueIsFoo_thenKvReturnStringDataEntry() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setId(id);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setVersion(1L);
    attributeKvEntity.setStrValue("foo");
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setLongValue(1L);
    attributeKvEntity.setJsonValue("foo");

    // Act
    AttributeKvEntry actualToDataResult = attributeKvEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) actualToDataResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    Optional<String> strValue = actualToDataResult.getStrValue();
    assertEquals("foo", strValue.get());
    assertEquals("foo", kv.getValueAsString());
    assertEquals("foo", kv.getValue());
    assertEquals(DataType.STRING, kv.getDataType());
    assertEquals(DataType.STRING, actualToDataResult.getDataType());
    assertTrue(strValue.isPresent());
    assertEquals(strValue, kv.getStrValue());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(null);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(null);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue(null);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue(null);
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(null);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(null);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(null);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey(null);
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey(null);
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity);
    int expectedHashCodeResult = attributeKvEntity.hashCode();
    assertEquals(expectedHashCodeResult, attributeKvEntity.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(false);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(0.5d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(3);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("Str Key");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue(null);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(3L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(null);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("42");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey(null);
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("Str Key");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue(null);
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(3L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(null);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, null);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, "Different type to AttributeKvEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AttributeKvEntity}
   *   <li>{@link AttributeKvEntity#setBooleanValue(Boolean)}
   *   <li>{@link AttributeKvEntity#setDoubleValue(Double)}
   *   <li>{@link AttributeKvEntity#setId(AttributeKvCompositeKey)}
   *   <li>{@link AttributeKvEntity#setJsonValue(String)}
   *   <li>{@link AttributeKvEntity#setLastUpdateTs(Long)}
   *   <li>{@link AttributeKvEntity#setLongValue(Long)}
   *   <li>{@link AttributeKvEntity#setStrKey(String)}
   *   <li>{@link AttributeKvEntity#setStrValue(String)}
   *   <li>{@link AttributeKvEntity#setVersion(Long)}
   *   <li>{@link AttributeKvEntity#toString()}
   *   <li>{@link AttributeKvEntity#getBooleanValue()}
   *   <li>{@link AttributeKvEntity#getDoubleValue()}
   *   <li>{@link AttributeKvEntity#getId()}
   *   <li>{@link AttributeKvEntity#getJsonValue()}
   *   <li>{@link AttributeKvEntity#getLastUpdateTs()}
   *   <li>{@link AttributeKvEntity#getLongValue()}
   *   <li>{@link AttributeKvEntity#getStrKey()}
   *   <li>{@link AttributeKvEntity#getStrValue()}
   *   <li>{@link AttributeKvEntity#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvEntity.<init>()",
    "Boolean AttributeKvEntity.getBooleanValue()",
    "Double AttributeKvEntity.getDoubleValue()",
    "AttributeKvCompositeKey AttributeKvEntity.getId()",
    "String AttributeKvEntity.getJsonValue()",
    "Long AttributeKvEntity.getLastUpdateTs()",
    "Long AttributeKvEntity.getLongValue()",
    "String AttributeKvEntity.getStrKey()",
    "String AttributeKvEntity.getStrValue()",
    "Long AttributeKvEntity.getVersion()",
    "void AttributeKvEntity.setBooleanValue(Boolean)",
    "void AttributeKvEntity.setDoubleValue(Double)",
    "void AttributeKvEntity.setId(AttributeKvCompositeKey)",
    "void AttributeKvEntity.setJsonValue(String)",
    "void AttributeKvEntity.setLastUpdateTs(Long)",
    "void AttributeKvEntity.setLongValue(Long)",
    "void AttributeKvEntity.setStrKey(String)",
    "void AttributeKvEntity.setStrValue(String)",
    "void AttributeKvEntity.setVersion(Long)",
    "String AttributeKvEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AttributeKvEntity actualAttributeKvEntity = new AttributeKvEntity();
    actualAttributeKvEntity.setBooleanValue(true);
    actualAttributeKvEntity.setDoubleValue(10.0d);
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualAttributeKvEntity.setId(id);
    actualAttributeKvEntity.setJsonValue("42");
    actualAttributeKvEntity.setLastUpdateTs(1L);
    actualAttributeKvEntity.setLongValue(42L);
    actualAttributeKvEntity.setStrKey("Str Key");
    actualAttributeKvEntity.setStrValue("42");
    actualAttributeKvEntity.setVersion(1L);
    String actualToStringResult = actualAttributeKvEntity.toString();
    Boolean actualBooleanValue = actualAttributeKvEntity.getBooleanValue();
    Double actualDoubleValue = actualAttributeKvEntity.getDoubleValue();
    AttributeKvCompositeKey actualId = actualAttributeKvEntity.getId();
    String actualJsonValue = actualAttributeKvEntity.getJsonValue();
    Long actualLastUpdateTs = actualAttributeKvEntity.getLastUpdateTs();
    Long actualLongValue = actualAttributeKvEntity.getLongValue();
    String actualStrKey = actualAttributeKvEntity.getStrKey();
    String actualStrValue = actualAttributeKvEntity.getStrValue();
    Long actualVersion = actualAttributeKvEntity.getVersion();

    // Assert
    assertEquals("42", actualJsonValue);
    assertEquals("42", actualStrValue);
    assertEquals(
        "AttributeKvEntity(id=AttributeKvCompositeKey(entityId=784f394c-42b6-435a-983c-b7beff2784f9, attributeType=1,"
            + " attributeKey=1), booleanValue=true, strValue=42, longValue=42, doubleValue=10.0, jsonValue=42,"
            + " lastUpdateTs=1, version=1, strKey=Str Key)",
        actualToStringResult);
    assertEquals("Str Key", actualStrKey);
    assertEquals(10.0d, actualDoubleValue.doubleValue());
    assertEquals(1L, actualLastUpdateTs.longValue());
    assertEquals(1L, actualVersion.longValue());
    assertEquals(42L, actualLongValue.longValue());
    assertTrue(actualBooleanValue);
    assertSame(id, actualId);
  }
}
