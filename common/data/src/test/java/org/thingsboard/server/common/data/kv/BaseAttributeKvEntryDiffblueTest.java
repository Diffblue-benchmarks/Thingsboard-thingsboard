package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BaseAttributeKvEntryDiffblueTest {
  /**
   * Test {@link BaseAttributeKvEntry#equals(Object)}, and {@link BaseAttributeKvEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseAttributeKvEntry#equals(Object)}
   *   <li>{@link BaseAttributeKvEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseAttributeKvEntry.equals(Object)",
    "int BaseAttributeKvEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals(baseAttributeKvEntry, baseAttributeKvEntry2);
    int expectedHashCodeResult = baseAttributeKvEntry.hashCode();
    assertEquals(expectedHashCodeResult, baseAttributeKvEntry2.hashCode());
  }

  /**
   * Test {@link BaseAttributeKvEntry#equals(Object)}, and {@link BaseAttributeKvEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseAttributeKvEntry#equals(Object)}
   *   <li>{@link BaseAttributeKvEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseAttributeKvEntry.equals(Object)",
    "int BaseAttributeKvEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, null);
    BaseAttributeKvEntry baseAttributeKvEntry2 = new BaseAttributeKvEntry(1L, null);

    // Act and Assert
    assertEquals(baseAttributeKvEntry, baseAttributeKvEntry2);
    int expectedHashCodeResult = baseAttributeKvEntry.hashCode();
    assertEquals(expectedHashCodeResult, baseAttributeKvEntry2.hashCode());
  }

  /**
   * Test {@link BaseAttributeKvEntry#equals(Object)}, and {@link BaseAttributeKvEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseAttributeKvEntry#equals(Object)}
   *   <li>{@link BaseAttributeKvEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseAttributeKvEntry.equals(Object)",
    "int BaseAttributeKvEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(new JsonDataEntry("Key", "42"), 1L, 1L);
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(new JsonDataEntry("Key", "42"), 1L, 1L);

    // Act and Assert
    assertEquals(baseAttributeKvEntry, baseAttributeKvEntry2);
    int expectedHashCodeResult = baseAttributeKvEntry.hashCode();
    assertEquals(expectedHashCodeResult, baseAttributeKvEntry2.hashCode());
  }

  /**
   * Test {@link BaseAttributeKvEntry#equals(Object)}, and {@link BaseAttributeKvEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseAttributeKvEntry#equals(Object)}
   *   <li>{@link BaseAttributeKvEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseAttributeKvEntry.equals(Object)",
    "int BaseAttributeKvEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals(baseAttributeKvEntry, baseAttributeKvEntry);
    int expectedHashCodeResult = baseAttributeKvEntry.hashCode();
    assertEquals(expectedHashCodeResult, baseAttributeKvEntry.hashCode());
  }

  /**
   * Test {@link BaseAttributeKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseAttributeKvEntry.equals(Object)",
    "int BaseAttributeKvEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(3L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(
        baseAttributeKvEntry, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Test {@link BaseAttributeKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseAttributeKvEntry.equals(Object)",
    "int BaseAttributeKvEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry(null, "42"));

    // Act and Assert
    assertNotEquals(
        baseAttributeKvEntry, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Test {@link BaseAttributeKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseAttributeKvEntry.equals(Object)",
    "int BaseAttributeKvEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertNotEquals(
        baseAttributeKvEntry, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Test {@link BaseAttributeKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseAttributeKvEntry.equals(Object)",
    "int BaseAttributeKvEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, null);

    // Act and Assert
    assertNotEquals(
        baseAttributeKvEntry, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Test {@link BaseAttributeKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseAttributeKvEntry.equals(Object)",
    "int BaseAttributeKvEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(new JsonDataEntry("Key", "42"), 1L, 1L);

    // Act and Assert
    assertNotEquals(
        baseAttributeKvEntry, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Test {@link BaseAttributeKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseAttributeKvEntry.equals(Object)",
    "int BaseAttributeKvEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(
        baseAttributeKvEntry, new BaseAttributeKvEntry(new JsonDataEntry("Key", "42"), 1L, 1L));
  }

  /**
   * Test {@link BaseAttributeKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseAttributeKvEntry.equals(Object)",
    "int BaseAttributeKvEntry.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")), null);
  }

  /**
   * Test {@link BaseAttributeKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseAttributeKvEntry.equals(Object)",
    "int BaseAttributeKvEntry.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")),
        "Different type to BaseAttributeKvEntry");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseAttributeKvEntry#BaseAttributeKvEntry(long, KvEntry)}
   *   <li>{@link BaseAttributeKvEntry#toString()}
   *   <li>{@link BaseAttributeKvEntry#getKv()}
   *   <li>{@link BaseAttributeKvEntry#getLastUpdateTs()}
   *   <li>{@link BaseAttributeKvEntry#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void BaseAttributeKvEntry.<init>(long, KvEntry)",
    "void BaseAttributeKvEntry.<init>(KvEntry, long)",
    "KvEntry BaseAttributeKvEntry.getKv()",
    "long BaseAttributeKvEntry.getLastUpdateTs()",
    "Long BaseAttributeKvEntry.getVersion()",
    "String BaseAttributeKvEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");

    // Act
    BaseAttributeKvEntry actualBaseAttributeKvEntry = new BaseAttributeKvEntry(1L, kv);
    String actualToStringResult = actualBaseAttributeKvEntry.toString();
    KvEntry actualKv = actualBaseAttributeKvEntry.getKv();
    long actualLastUpdateTs = actualBaseAttributeKvEntry.getLastUpdateTs();

    // Assert
    assertEquals(
        "BaseAttributeKvEntry(lastUpdateTs=1, kv=JsonDataEntry{value=42} BasicKvEntry{key='Key'},"
            + " version=null)",
        actualToStringResult);
    assertNull(actualBaseAttributeKvEntry.getVersion());
    assertEquals(1L, actualLastUpdateTs);
    assertSame(kv, actualKv);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseAttributeKvEntry#BaseAttributeKvEntry(KvEntry, long)}
   *   <li>{@link BaseAttributeKvEntry#toString()}
   *   <li>{@link BaseAttributeKvEntry#getKv()}
   *   <li>{@link BaseAttributeKvEntry#getLastUpdateTs()}
   *   <li>{@link BaseAttributeKvEntry#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void BaseAttributeKvEntry.<init>(long, KvEntry)",
    "void BaseAttributeKvEntry.<init>(KvEntry, long)",
    "KvEntry BaseAttributeKvEntry.getKv()",
    "long BaseAttributeKvEntry.getLastUpdateTs()",
    "Long BaseAttributeKvEntry.getVersion()",
    "String BaseAttributeKvEntry.toString()"
  })
  void testGettersAndSetters2() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");

    // Act
    BaseAttributeKvEntry actualBaseAttributeKvEntry = new BaseAttributeKvEntry(kv, 1L);
    String actualToStringResult = actualBaseAttributeKvEntry.toString();
    KvEntry actualKv = actualBaseAttributeKvEntry.getKv();
    long actualLastUpdateTs = actualBaseAttributeKvEntry.getLastUpdateTs();

    // Assert
    assertEquals(
        "BaseAttributeKvEntry(lastUpdateTs=1, kv=JsonDataEntry{value=42} BasicKvEntry{key='Key'},"
            + " version=null)",
        actualToStringResult);
    assertNull(actualBaseAttributeKvEntry.getVersion());
    assertEquals(1L, actualLastUpdateTs);
    assertSame(kv, actualKv);
  }

  /**
   * Test {@link BaseAttributeKvEntry#BaseAttributeKvEntry(KvEntry, long, Long)}.
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#BaseAttributeKvEntry(KvEntry, long, Long)}
   */
  @Test
  @DisplayName("Test new BaseAttributeKvEntry(KvEntry, long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseAttributeKvEntry.<init>(KvEntry, long, Long)"})
  void testNewBaseAttributeKvEntry() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");

    // Act
    BaseAttributeKvEntry actualBaseAttributeKvEntry = new BaseAttributeKvEntry(kv, 1L, 1L);

    // Assert
    KvEntry kv2 = actualBaseAttributeKvEntry.getKv();
    assertTrue(kv2 instanceof JsonDataEntry);
    assertEquals("42", actualBaseAttributeKvEntry.getValueAsString());
    assertEquals("42", actualBaseAttributeKvEntry.getValue());
    assertEquals("Key", actualBaseAttributeKvEntry.getKey());
    assertEquals(1L, actualBaseAttributeKvEntry.getVersion().longValue());
    assertEquals(1L, actualBaseAttributeKvEntry.getLastUpdateTs());
    assertEquals(DataType.JSON, actualBaseAttributeKvEntry.getDataType());
    Optional<Boolean> booleanValue = actualBaseAttributeKvEntry.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertSame(kv, kv2);
    assertSame(booleanValue, actualBaseAttributeKvEntry.getDoubleValue());
    assertSame(booleanValue, actualBaseAttributeKvEntry.getLongValue());
    assertSame(booleanValue, actualBaseAttributeKvEntry.getStrValue());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getKey()}.
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getKey()}
   */
  @Test
  @DisplayName("Test getKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BaseAttributeKvEntry.getKey()"})
  void testGetKey() {
    // Arrange, Act and Assert
    assertEquals(
        "Key",
        new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))
            .getKey());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getKey()}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getKey()}
   */
  @Test
  @DisplayName(
      "Test getKey(); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BaseAttributeKvEntry.getKey()"})
  void testGetKey_givenJsonDataEntryWithKeyAndValueIs42_thenReturnKey() {
    // Arrange, Act and Assert
    assertEquals("Key", new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")).getKey());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getDataType()}.
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getDataType()}
   */
  @Test
  @DisplayName("Test getDataType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataType BaseAttributeKvEntry.getDataType()"})
  void testGetDataType() {
    // Arrange, Act and Assert
    assertEquals(
        DataType.JSON,
        new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))
            .getDataType());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getDataType()}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return {@code JSON}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getDataType()}
   */
  @Test
  @DisplayName(
      "Test getDataType(); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return 'JSON'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataType BaseAttributeKvEntry.getDataType()"})
  void testGetDataType_givenJsonDataEntryWithKeyAndValueIs42_thenReturnJson() {
    // Arrange, Act and Assert
    assertEquals(
        DataType.JSON, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")).getDataType());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getStrValue()}.
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getStrValue()}
   */
  @Test
  @DisplayName("Test getStrValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BaseAttributeKvEntry.getStrValue()"})
  void testGetStrValue() {
    // Arrange, Act and Assert
    assertFalse(
        new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))
            .getStrValue()
            .isPresent());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getStrValue()}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getStrValue()}
   */
  @Test
  @DisplayName(
      "Test getStrValue(); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BaseAttributeKvEntry.getStrValue()"})
  void testGetStrValue_givenJsonDataEntryWithKeyAndValueIs42_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")).getStrValue().isPresent());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getLongValue()}.
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getLongValue()}
   */
  @Test
  @DisplayName("Test getLongValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BaseAttributeKvEntry.getLongValue()"})
  void testGetLongValue() {
    // Arrange, Act and Assert
    assertFalse(
        new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))
            .getLongValue()
            .isPresent());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getLongValue()}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getLongValue()}
   */
  @Test
  @DisplayName(
      "Test getLongValue(); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BaseAttributeKvEntry.getLongValue()"})
  void testGetLongValue_givenJsonDataEntryWithKeyAndValueIs42_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")).getLongValue().isPresent());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getBooleanValue()}.
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getBooleanValue()}
   */
  @Test
  @DisplayName("Test getBooleanValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BaseAttributeKvEntry.getBooleanValue()"})
  void testGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(
        new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))
            .getBooleanValue()
            .isPresent());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getBooleanValue()}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getBooleanValue()}
   */
  @Test
  @DisplayName(
      "Test getBooleanValue(); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BaseAttributeKvEntry.getBooleanValue()"})
  void testGetBooleanValue_givenJsonDataEntryWithKeyAndValueIs42_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")).getBooleanValue().isPresent());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getDoubleValue()}.
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getDoubleValue()}
   */
  @Test
  @DisplayName("Test getDoubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BaseAttributeKvEntry.getDoubleValue()"})
  void testGetDoubleValue() {
    // Arrange, Act and Assert
    assertFalse(
        new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))
            .getDoubleValue()
            .isPresent());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getDoubleValue()}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getDoubleValue()}
   */
  @Test
  @DisplayName(
      "Test getDoubleValue(); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BaseAttributeKvEntry.getDoubleValue()"})
  void testGetDoubleValue_givenJsonDataEntryWithKeyAndValueIs42_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")).getDoubleValue().isPresent());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getJsonValue()}.
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getJsonValue()}
   */
  @Test
  @DisplayName("Test getJsonValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BaseAttributeKvEntry.getJsonValue()"})
  void testGetJsonValue() {
    // Arrange and Act
    Optional<String> actualJsonValue =
        new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))
            .getJsonValue();

    // Assert
    assertEquals("42", actualJsonValue.get());
    assertTrue(actualJsonValue.isPresent());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getJsonValue()}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return {@link Optional#get()} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getJsonValue()}
   */
  @Test
  @DisplayName(
      "Test getJsonValue(); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BaseAttributeKvEntry.getJsonValue()"})
  void testGetJsonValue_givenJsonDataEntryWithKeyAndValueIs42_thenReturnGetIs42() {
    // Arrange and Act
    Optional<String> actualJsonValue =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")).getJsonValue();

    // Assert
    assertEquals("42", actualJsonValue.get());
    assertTrue(actualJsonValue.isPresent());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getValueAsString()}.
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BaseAttributeKvEntry.getValueAsString()"})
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))
            .getValueAsString());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getValueAsString()}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getValueAsString()}
   */
  @Test
  @DisplayName(
      "Test getValueAsString(); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BaseAttributeKvEntry.getValueAsString()"})
  void testGetValueAsString_givenJsonDataEntryWithKeyAndValueIs42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals(
        "42", new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")).getValueAsString());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getValue()}.
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getValue()}
   */
  @Test
  @DisplayName("Test getValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseAttributeKvEntry.getValue()"})
  void testGetValue() {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))
            .getValue());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getValue()}.
   *
   * <ul>
   *   <li>Given {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and
   *       value is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given BooleanDataEntry(String, Boolean) with 'Key' and value is 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseAttributeKvEntry.getValue()"})
  void testGetValue_givenBooleanDataEntryWithKeyAndValueIsFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (Boolean) new BaseAttributeKvEntry(1L, new BooleanDataEntry("Key", false)).getValue());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getValue()}.
   *
   * <ul>
   *   <li>Given {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and
   *       value is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseAttributeKvEntry.getValue()"})
  void testGetValue_givenBooleanDataEntryWithKeyAndValueIsTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (Boolean) new BaseAttributeKvEntry(1L, new BooleanDataEntry("Key", true)).getValue());
  }

  /**
   * Test {@link BaseAttributeKvEntry#getValue()}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAttributeKvEntry#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseAttributeKvEntry.getValue()"})
  void testGetValue_givenJsonDataEntryWithKeyAndValueIs42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")).getValue());
  }
}
