package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BooleanDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BooleanDataEntry#BooleanDataEntry(String, Boolean)}
   *   <li>{@link BooleanDataEntry#toString()}
   *   <li>{@link BooleanDataEntry#getDataType()}
   *   <li>{@link BooleanDataEntry#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BooleanDataEntry actualBooleanDataEntry = new BooleanDataEntry("Key", true);
    String actualToStringResult = actualBooleanDataEntry.toString();
    DataType actualDataType = actualBooleanDataEntry.getDataType();
    actualBooleanDataEntry.getValue();

    // Assert
    assertEquals("BooleanDataEntry{value=true} BasicKvEntry{key='Key'}", actualToStringResult);
    assertEquals("Key", actualBooleanDataEntry.getKey());
    assertEquals(DataType.BOOLEAN, actualDataType);
  }

  /**
   * Test {@link BooleanDataEntry#getBooleanValue()}.
   * <p>
   * Method under test: {@link BooleanDataEntry#getBooleanValue()}
   */
  @Test
  @DisplayName("Test getBooleanValue()")
  void testGetBooleanValue() {
    // Arrange and Act
    Optional<Boolean> actualBooleanValue = (new BooleanDataEntry("Key", true)).getBooleanValue();

    // Assert
    assertTrue(actualBooleanValue.get());
    assertTrue(actualBooleanValue.isPresent());
  }

  /**
   * Test {@link BooleanDataEntry#equals(Object)}, and
   * {@link BooleanDataEntry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BooleanDataEntry#equals(Object)}
   *   <li>{@link BooleanDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BooleanDataEntry booleanDataEntry = new BooleanDataEntry("Key", true);
    BooleanDataEntry booleanDataEntry2 = new BooleanDataEntry("Key", true);

    // Act and Assert
    assertEquals(booleanDataEntry, booleanDataEntry2);
    int expectedHashCodeResult = booleanDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, booleanDataEntry2.hashCode());
  }

  /**
   * Test {@link BooleanDataEntry#equals(Object)}, and
   * {@link BooleanDataEntry#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BooleanDataEntry#equals(Object)}
   *   <li>{@link BooleanDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BooleanDataEntry booleanDataEntry = new BooleanDataEntry("Key", true);

    // Act and Assert
    assertEquals(booleanDataEntry, booleanDataEntry);
    int expectedHashCodeResult = booleanDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, booleanDataEntry.hashCode());
  }

  /**
   * Test {@link BooleanDataEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BooleanDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BooleanDataEntry booleanDataEntry = new BooleanDataEntry("org.thingsboard.server.common.data.kv.BooleanDataEntry",
        true);

    // Act and Assert
    assertNotEquals(booleanDataEntry, new BooleanDataEntry("Key", true));
  }

  /**
   * Test {@link BooleanDataEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BooleanDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanDataEntry("Key", true), mock(DoubleDataEntry.class));
  }

  /**
   * Test {@link BooleanDataEntry#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BooleanDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanDataEntry("Key", true), null);
  }

  /**
   * Test {@link BooleanDataEntry#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BooleanDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanDataEntry("Key", true), "Different type to BooleanDataEntry");
  }

  /**
   * Test {@link BooleanDataEntry#getValueAsString()}.
   * <p>
   * Method under test: {@link BooleanDataEntry#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString()")
  void testGetValueAsString() {
    // Arrange and Act
    String actualValueAsString = (new BooleanDataEntry("Key", true)).getValueAsString();

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualValueAsString);
  }
}
