package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DoubleDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DoubleDataEntry#DoubleDataEntry(String, Double)}
   *   <li>{@link DoubleDataEntry#toString()}
   *   <li>{@link DoubleDataEntry#getDataType()}
   *   <li>{@link DoubleDataEntry#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    DoubleDataEntry actualDoubleDataEntry = new DoubleDataEntry("Key", 10.0d);
    String actualToStringResult = actualDoubleDataEntry.toString();
    DataType actualDataType = actualDoubleDataEntry.getDataType();
    Object actualValue = actualDoubleDataEntry.getValue();

    // Assert
    assertEquals("DoubleDataEntry{value=10.0} BasicKvEntry{key='Key'}", actualToStringResult);
    assertEquals("Key", actualDoubleDataEntry.getKey());
    assertEquals(10.0d, ((Double) actualValue).doubleValue());
    assertEquals(DataType.DOUBLE, actualDataType);
  }

  /**
   * Test {@link DoubleDataEntry#getDoubleValue()}.
   * <p>
   * Method under test: {@link DoubleDataEntry#getDoubleValue()}
   */
  @Test
  @DisplayName("Test getDoubleValue()")
  void testGetDoubleValue() {
    // Arrange and Act
    Optional<Double> actualDoubleValue = (new DoubleDataEntry("Key", 10.0d)).getDoubleValue();

    // Assert
    assertEquals(10.0d, actualDoubleValue.get().doubleValue());
    assertTrue(actualDoubleValue.isPresent());
  }

  /**
   * Test {@link DoubleDataEntry#equals(Object)}, and
   * {@link DoubleDataEntry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DoubleDataEntry#equals(Object)}
   *   <li>{@link DoubleDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DoubleDataEntry doubleDataEntry = new DoubleDataEntry("Key", 10.0d);
    DoubleDataEntry doubleDataEntry2 = new DoubleDataEntry("Key", 10.0d);

    // Act and Assert
    assertEquals(doubleDataEntry, doubleDataEntry2);
    int expectedHashCodeResult = doubleDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, doubleDataEntry2.hashCode());
  }

  /**
   * Test {@link DoubleDataEntry#equals(Object)}, and
   * {@link DoubleDataEntry#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DoubleDataEntry#equals(Object)}
   *   <li>{@link DoubleDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DoubleDataEntry doubleDataEntry = new DoubleDataEntry("Key", 10.0d);

    // Act and Assert
    assertEquals(doubleDataEntry, doubleDataEntry);
    int expectedHashCodeResult = doubleDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, doubleDataEntry.hashCode());
  }

  /**
   * Test {@link DoubleDataEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DoubleDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DoubleDataEntry doubleDataEntry = new DoubleDataEntry("org.thingsboard.server.common.data.kv.DoubleDataEntry",
        10.0d);

    // Act and Assert
    assertNotEquals(doubleDataEntry, new DoubleDataEntry("Key", 10.0d));
  }

  /**
   * Test {@link DoubleDataEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DoubleDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleDataEntry("Key", 10.0d), mock(BooleanDataEntry.class));
  }

  /**
   * Test {@link DoubleDataEntry#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DoubleDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleDataEntry("Key", 10.0d), null);
  }

  /**
   * Test {@link DoubleDataEntry#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DoubleDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleDataEntry("Key", 10.0d), "Different type to DoubleDataEntry");
  }

  /**
   * Test {@link DoubleDataEntry#getValueAsString()}.
   * <p>
   * Method under test: {@link DoubleDataEntry#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString()")
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("10.0", (new DoubleDataEntry("Key", 10.0d)).getValueAsString());
  }
}
