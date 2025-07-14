package org.thingsboard.server.dao.model.sqlts.latest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TsKvLatestEntityDiffblueTest {
  /**
   * Test {@link TsKvLatestEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()} BooleanValue is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given TsKvLatestEntity() BooleanValue is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTsKvLatestEntityBooleanValueIsTrue_thenReturnTrue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);
    tsKvLatestEntity.setStrValue(null);
    tsKvLatestEntity.setLongValue(null);
    tsKvLatestEntity.setDoubleValue(null);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setJsonValue(null);

    // Act and Assert
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvLatestEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()} DoubleValue is ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given TsKvLatestEntity() DoubleValue is ten; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTsKvLatestEntityDoubleValueIsTen_thenReturnTrue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);
    tsKvLatestEntity.setStrValue(null);
    tsKvLatestEntity.setLongValue(null);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setBooleanValue(null);
    tsKvLatestEntity.setJsonValue(null);

    // Act and Assert
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvLatestEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()} JsonValue is {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given TsKvLatestEntity() JsonValue is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTsKvLatestEntityJsonValueIsFoo_thenReturnTrue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);
    tsKvLatestEntity.setStrValue(null);
    tsKvLatestEntity.setLongValue(null);
    tsKvLatestEntity.setDoubleValue(null);
    tsKvLatestEntity.setBooleanValue(null);
    tsKvLatestEntity.setJsonValue("foo");

    // Act and Assert
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvLatestEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()} LongValue is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given TsKvLatestEntity() LongValue is one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTsKvLatestEntityLongValueIsOne_thenReturnTrue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);
    tsKvLatestEntity.setStrValue(null);
    tsKvLatestEntity.setLongValue(1L);
    tsKvLatestEntity.setDoubleValue(null);
    tsKvLatestEntity.setBooleanValue(null);
    tsKvLatestEntity.setJsonValue(null);

    // Act and Assert
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvLatestEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()} StrValue is {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given TsKvLatestEntity() StrValue is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTsKvLatestEntityStrValueIsFoo_thenReturnTrue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);
    tsKvLatestEntity.setStrValue("foo");
    tsKvLatestEntity.setLongValue(null);
    tsKvLatestEntity.setDoubleValue(null);
    tsKvLatestEntity.setBooleanValue(null);
    tsKvLatestEntity.setJsonValue(null);

    // Act and Assert
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvLatestEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given TsKvLatestEntity(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTsKvLatestEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TsKvLatestEntity().isNotEmpty());
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}, and {@link TsKvLatestEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestEntity#equals(Object)}
   *   <li>{@link TsKvLatestEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);

    TsKvLatestEntity tsKvLatestEntity2 = new TsKvLatestEntity();
    tsKvLatestEntity2.setAggValuesCount(3L);
    tsKvLatestEntity2.setAggValuesLastTs(42L);
    tsKvLatestEntity2.setBooleanValue(true);
    tsKvLatestEntity2.setDoubleValue(10.0d);
    tsKvLatestEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity2.setJsonValue("42");
    tsKvLatestEntity2.setKey(1);
    tsKvLatestEntity2.setLongValue(42L);
    tsKvLatestEntity2.setStrKey("Str Key");
    tsKvLatestEntity2.setStrValue("42");
    tsKvLatestEntity2.setTs(1L);
    tsKvLatestEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(tsKvLatestEntity, tsKvLatestEntity2);
    int expectedHashCodeResult = tsKvLatestEntity.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestEntity2.hashCode());
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}, and {@link TsKvLatestEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestEntity#equals(Object)}
   *   <li>{@link TsKvLatestEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(null);

    TsKvLatestEntity tsKvLatestEntity2 = new TsKvLatestEntity();
    tsKvLatestEntity2.setAggValuesCount(3L);
    tsKvLatestEntity2.setAggValuesLastTs(42L);
    tsKvLatestEntity2.setBooleanValue(true);
    tsKvLatestEntity2.setDoubleValue(10.0d);
    tsKvLatestEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity2.setJsonValue("42");
    tsKvLatestEntity2.setKey(1);
    tsKvLatestEntity2.setLongValue(42L);
    tsKvLatestEntity2.setStrKey("Str Key");
    tsKvLatestEntity2.setStrValue("42");
    tsKvLatestEntity2.setTs(1L);
    tsKvLatestEntity2.setVersion(null);

    // Act and Assert
    assertEquals(tsKvLatestEntity, tsKvLatestEntity2);
    int expectedHashCodeResult = tsKvLatestEntity.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestEntity2.hashCode());
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}, and {@link TsKvLatestEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestEntity#equals(Object)}
   *   <li>{@link TsKvLatestEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);

    // Act and Assert
    assertEquals(tsKvLatestEntity, tsKvLatestEntity);
    int expectedHashCodeResult = tsKvLatestEntity.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestEntity.hashCode());
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(3L);

    TsKvLatestEntity tsKvLatestEntity2 = new TsKvLatestEntity();
    tsKvLatestEntity2.setAggValuesCount(3L);
    tsKvLatestEntity2.setAggValuesLastTs(42L);
    tsKvLatestEntity2.setBooleanValue(true);
    tsKvLatestEntity2.setDoubleValue(10.0d);
    tsKvLatestEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity2.setJsonValue("42");
    tsKvLatestEntity2.setKey(1);
    tsKvLatestEntity2.setLongValue(42L);
    tsKvLatestEntity2.setStrKey("Str Key");
    tsKvLatestEntity2.setStrValue("42");
    tsKvLatestEntity2.setTs(1L);
    tsKvLatestEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(tsKvLatestEntity, tsKvLatestEntity2);
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(null);

    TsKvLatestEntity tsKvLatestEntity2 = new TsKvLatestEntity();
    tsKvLatestEntity2.setAggValuesCount(3L);
    tsKvLatestEntity2.setAggValuesLastTs(42L);
    tsKvLatestEntity2.setBooleanValue(true);
    tsKvLatestEntity2.setDoubleValue(10.0d);
    tsKvLatestEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity2.setJsonValue("42");
    tsKvLatestEntity2.setKey(1);
    tsKvLatestEntity2.setLongValue(42L);
    tsKvLatestEntity2.setStrKey("Str Key");
    tsKvLatestEntity2.setStrValue("42");
    tsKvLatestEntity2.setTs(1L);
    tsKvLatestEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(tsKvLatestEntity, tsKvLatestEntity2);
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(tsKvLatestEntity, null);
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(tsKvLatestEntity, "Different type to TsKvLatestEntity");
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return BooleanValue is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestEntity#TsKvLatestEntity()}
   *   <li>{@link TsKvLatestEntity#setVersion(Long)}
   *   <li>{@link TsKvLatestEntity#toString()}
   *   <li>{@link TsKvLatestEntity#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return BooleanValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TsKvLatestEntity.<init>()",
    "void TsKvLatestEntity.<init>(UUID, Integer, String, String, Boolean, Long, Double, String, Long, Long)",
    "Long TsKvLatestEntity.getVersion()",
    "void TsKvLatestEntity.setVersion(Long)",
    "String TsKvLatestEntity.toString()"
  })
  void testGettersAndSetters_thenReturnBooleanValueIsNull() {
    // Arrange and Act
    TsKvLatestEntity actualTsKvLatestEntity = new TsKvLatestEntity();
    actualTsKvLatestEntity.setVersion(1L);
    String actualToStringResult = actualTsKvLatestEntity.toString();
    Long actualVersion = actualTsKvLatestEntity.getVersion();

    // Assert
    assertEquals("TsKvLatestEntity(version=1)", actualToStringResult);
    assertNull(actualTsKvLatestEntity.getBooleanValue());
    assertNull(actualTsKvLatestEntity.getDoubleValue());
    assertNull(actualTsKvLatestEntity.getAggValuesCount());
    assertNull(actualTsKvLatestEntity.getAggValuesLastTs());
    assertNull(actualTsKvLatestEntity.getLongValue());
    assertNull(actualTsKvLatestEntity.getTs());
    assertNull(actualTsKvLatestEntity.getJsonValue());
    assertNull(actualTsKvLatestEntity.getStrKey());
    assertNull(actualTsKvLatestEntity.getStrValue());
    assertNull(actualTsKvLatestEntity.getEntityId());
    assertEquals(0, actualTsKvLatestEntity.getKey());
    assertEquals(1L, actualVersion.longValue());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return JsonValue is {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestEntity#TsKvLatestEntity(UUID, Integer, String, String, Boolean, Long,
   *       Double, String, Long, Long)}
   *   <li>{@link TsKvLatestEntity#setVersion(Long)}
   *   <li>{@link TsKvLatestEntity#toString()}
   *   <li>{@link TsKvLatestEntity#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return JsonValue is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TsKvLatestEntity.<init>()",
    "void TsKvLatestEntity.<init>(UUID, Integer, String, String, Boolean, Long, Double, String, Long, Long)",
    "Long TsKvLatestEntity.getVersion()",
    "void TsKvLatestEntity.setVersion(Long)",
    "String TsKvLatestEntity.toString()"
  })
  void testGettersAndSetters_thenReturnJsonValueIs42() {
    // Arrange
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    TsKvLatestEntity actualTsKvLatestEntity =
        new TsKvLatestEntity(entityId, 1, "Str Key", "42", true, 42L, 10.0d, "42", 1L, 1L);
    actualTsKvLatestEntity.setVersion(1L);
    String actualToStringResult = actualTsKvLatestEntity.toString();
    Long actualVersion = actualTsKvLatestEntity.getVersion();

    // Assert
    assertEquals("42", actualTsKvLatestEntity.getJsonValue());
    assertEquals("42", actualTsKvLatestEntity.getStrValue());
    UUID entityId2 = actualTsKvLatestEntity.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    assertEquals("Str Key", actualTsKvLatestEntity.getStrKey());
    assertEquals("TsKvLatestEntity(version=1)", actualToStringResult);
    assertNull(actualTsKvLatestEntity.getAggValuesCount());
    assertNull(actualTsKvLatestEntity.getAggValuesLastTs());
    assertEquals(1, actualTsKvLatestEntity.getKey());
    assertEquals(10.0d, actualTsKvLatestEntity.getDoubleValue().doubleValue());
    assertEquals(1L, actualTsKvLatestEntity.getTs().longValue());
    assertEquals(1L, actualVersion.longValue());
    assertEquals(42L, actualTsKvLatestEntity.getLongValue().longValue());
    assertTrue(actualTsKvLatestEntity.getBooleanValue());
    assertSame(entityId, entityId2);
  }
}
