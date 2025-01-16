package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JsonDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsonDataEntry#JsonDataEntry(String, String)}
   *   <li>{@link JsonDataEntry#toString()}
   *   <li>{@link JsonDataEntry#getDataType()}
   *   <li>{@link JsonDataEntry#getValue()}
   *   <li>{@link JsonDataEntry#getValueAsString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    JsonDataEntry actualJsonDataEntry = new JsonDataEntry("Key", "42");
    String actualToStringResult = actualJsonDataEntry.toString();
    DataType actualDataType = actualJsonDataEntry.getDataType();
    Object actualValue = actualJsonDataEntry.getValue();

    // Assert
    assertEquals("42", actualJsonDataEntry.getValueAsString());
    assertEquals("42", actualValue);
    assertEquals("JsonDataEntry{value=42} BasicKvEntry{key='Key'}", actualToStringResult);
    assertEquals("Key", actualJsonDataEntry.getKey());
    assertEquals(DataType.JSON, actualDataType);
  }

  /**
   * Test {@link JsonDataEntry#getJsonValue()}.
   * <p>
   * Method under test: {@link JsonDataEntry#getJsonValue()}
   */
  @Test
  @DisplayName("Test getJsonValue()")
  void testGetJsonValue() {
    // Arrange and Act
    Optional<String> actualJsonValue = (new JsonDataEntry("Key", "42")).getJsonValue();

    // Assert
    assertEquals("42", actualJsonValue.get());
    assertTrue(actualJsonValue.isPresent());
  }

  /**
   * Test {@link JsonDataEntry#equals(Object)}, and
   * {@link JsonDataEntry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsonDataEntry#equals(Object)}
   *   <li>{@link JsonDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link JsonDataEntry#equals(Object)}, and
   * {@link JsonDataEntry#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsonDataEntry#equals(Object)}
   *   <li>{@link JsonDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonDataEntry jsonDataEntry = new JsonDataEntry("Key", "42");

    // Act and Assert
    assertEquals(jsonDataEntry, jsonDataEntry);
    int expectedHashCodeResult = jsonDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, jsonDataEntry.hashCode());
  }

  /**
   * Test {@link JsonDataEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsonDataEntry jsonDataEntry = new JsonDataEntry("org.thingsboard.server.common.data.kv.JsonDataEntry", "42");

    // Act and Assert
    assertNotEquals(jsonDataEntry, new JsonDataEntry("Key", "42"));
  }

  /**
   * Test {@link JsonDataEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonDataEntry("Key", "42"), mock(BooleanDataEntry.class));
  }

  /**
   * Test {@link JsonDataEntry#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonDataEntry("Key", "42"), null);
  }

  /**
   * Test {@link JsonDataEntry#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonDataEntry("Key", "42"), "Different type to JsonDataEntry");
  }
}
