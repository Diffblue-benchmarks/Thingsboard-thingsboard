package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BasicKvEntryDiffblueTest {
  /**
   * Test {@link BasicKvEntry#getKey()}.
   *
   * <p>Method under test: {@link BasicKvEntry#getKey()}
   */
  @Test
  @DisplayName("Test getKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String BasicKvEntry.getKey()"})
  void testGetKey() {
    // Arrange, Act and Assert
    assertEquals("Key", new JsonDataEntry("Key", "42").getKey());
  }

  /**
   * Test {@link BasicKvEntry#getStrValue()}.
   *
   * <p>Method under test: {@link BasicKvEntry#getStrValue()}
   */
  @Test
  @DisplayName("Test getStrValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Optional BasicKvEntry.getStrValue()"})
  void testGetStrValue() {
    // Arrange, Act and Assert
    assertFalse(new JsonDataEntry("Key", "42").getStrValue().isPresent());
  }

  /**
   * Test {@link BasicKvEntry#getLongValue()}.
   *
   * <p>Method under test: {@link BasicKvEntry#getLongValue()}
   */
  @Test
  @DisplayName("Test getLongValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Optional BasicKvEntry.getLongValue()"})
  void testGetLongValue() {
    // Arrange, Act and Assert
    assertFalse(new JsonDataEntry("Key", "42").getLongValue().isPresent());
  }

  /**
   * Test {@link BasicKvEntry#getBooleanValue()}.
   *
   * <p>Method under test: {@link BasicKvEntry#getBooleanValue()}
   */
  @Test
  @DisplayName("Test getBooleanValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Optional BasicKvEntry.getBooleanValue()"})
  void testGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(new JsonDataEntry("Key", "42").getBooleanValue().isPresent());
  }

  /**
   * Test {@link BasicKvEntry#getDoubleValue()}.
   *
   * <p>Method under test: {@link BasicKvEntry#getDoubleValue()}
   */
  @Test
  @DisplayName("Test getDoubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Optional BasicKvEntry.getDoubleValue()"})
  void testGetDoubleValue() {
    // Arrange, Act and Assert
    assertFalse(new JsonDataEntry("Key", "42").getDoubleValue().isPresent());
  }

  /**
   * Test {@link BasicKvEntry#getJsonValue()}.
   *
   * <p>Method under test: {@link BasicKvEntry#getJsonValue()}
   */
  @Test
  @DisplayName("Test getJsonValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Optional BasicKvEntry.getJsonValue()"})
  void testGetJsonValue() {
    // Arrange, Act and Assert
    assertFalse(new StringDataEntry("Key", "42").getJsonValue().isPresent());
  }

  /**
   * Test {@link BasicKvEntry#equals(Object)}, and {@link BasicKvEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicKvEntry.equals(Object)", "int BasicKvEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsonDataEntry jsonDataEntry = new JsonDataEntry("Key", "42");
    JsonDataEntry jsonDataEntry2 = new JsonDataEntry("Key", "42");

    // Act and Assert
    assertEquals(jsonDataEntry, jsonDataEntry2);
    int expectedHashCodeResult = jsonDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, jsonDataEntry2.hashCode());
  }

  /**
   * Test {@link BasicKvEntry#equals(Object)}, and {@link BasicKvEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicKvEntry.equals(Object)", "int BasicKvEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonDataEntry jsonDataEntry = new JsonDataEntry("Key", "42");

    // Act and Assert
    assertEquals(jsonDataEntry, jsonDataEntry);
    int expectedHashCodeResult = jsonDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, jsonDataEntry.hashCode());
  }

  /**
   * Test {@link BasicKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicKvEntry.equals(Object)", "int BasicKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsonDataEntry jsonDataEntry =
        new JsonDataEntry("org.thingsboard.server.common.data.kv.JsonDataEntry", "42");

    // Act and Assert
    assertNotEquals(jsonDataEntry, new JsonDataEntry("Key", "42"));
  }

  /**
   * Test {@link BasicKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicKvEntry.equals(Object)", "int BasicKvEntry.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonDataEntry("Key", "42"), null);
  }

  /**
   * Test {@link BasicKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicKvEntry.equals(Object)", "int BasicKvEntry.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonDataEntry("Key", "42"), "Different type to BasicKvEntry");
  }

  /**
   * Test {@link BasicKvEntry#toString()}.
   *
   * <p>Method under test: {@link BasicKvEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String BasicKvEntry.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "JsonDataEntry{value=42} BasicKvEntry{key='Key'}",
        new JsonDataEntry("Key", "42").toString());
  }
}
