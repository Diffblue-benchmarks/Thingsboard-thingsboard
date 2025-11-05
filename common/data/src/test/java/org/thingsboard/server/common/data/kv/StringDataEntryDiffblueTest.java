package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringDataEntry#StringDataEntry(String, String)}
   *   <li>{@link StringDataEntry#toString()}
   *   <li>{@link StringDataEntry#getDataType()}
   *   <li>{@link StringDataEntry#getValue()}
   *   <li>{@link StringDataEntry#getValueAsString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StringDataEntry.<init>(String, String)",
    "DataType StringDataEntry.getDataType()",
    "Object StringDataEntry.getValue()",
    "String StringDataEntry.getValueAsString()",
    "String StringDataEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    StringDataEntry actualStringDataEntry = new StringDataEntry("Key", "42");
    String actualToStringResult = actualStringDataEntry.toString();
    DataType actualDataType = actualStringDataEntry.getDataType();
    Object actualValue = actualStringDataEntry.getValue();

    // Assert
    assertEquals("42", actualStringDataEntry.getValueAsString());
    assertEquals("42", actualValue);
    assertEquals("Key", actualStringDataEntry.getKey());
    assertEquals("StringDataEntry{value='42'} BasicKvEntry{key='Key'}", actualToStringResult);
    assertEquals(DataType.STRING, actualDataType);
  }

  /**
   * Test {@link StringDataEntry#getStrValue()}.
   *
   * <p>Method under test: {@link StringDataEntry#getStrValue()}
   */
  @Test
  @DisplayName("Test getStrValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional StringDataEntry.getStrValue()"})
  void testGetStrValue() {
    // Arrange and Act
    Optional<String> actualStrValue = new StringDataEntry("Key", "42").getStrValue();

    // Assert
    assertEquals("42", actualStrValue.get());
    assertTrue(actualStrValue.isPresent());
  }

  /**
   * Test {@link StringDataEntry#equals(Object)}, and {@link StringDataEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringDataEntry#equals(Object)}
   *   <li>{@link StringDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringDataEntry.equals(Object)", "int StringDataEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StringDataEntry stringDataEntry = new StringDataEntry("Key", "42");
    StringDataEntry stringDataEntry2 = new StringDataEntry("Key", "42");

    // Act and Assert
    assertEquals(stringDataEntry, stringDataEntry2);
    assertEquals(stringDataEntry.hashCode(), stringDataEntry2.hashCode());
  }

  /**
   * Test {@link StringDataEntry#equals(Object)}, and {@link StringDataEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringDataEntry#equals(Object)}
   *   <li>{@link StringDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringDataEntry.equals(Object)", "int StringDataEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StringDataEntry stringDataEntry = new StringDataEntry("Key", "42");

    // Act and Assert
    assertEquals(stringDataEntry, stringDataEntry);
    int expectedHashCodeResult = stringDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, stringDataEntry.hashCode());
  }

  /**
   * Test {@link StringDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringDataEntry.equals(Object)", "int StringDataEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StringDataEntry stringDataEntry =
        new StringDataEntry("org.thingsboard.server.common.data.kv.StringDataEntry", "42");

    // Act and Assert
    assertNotEquals(stringDataEntry, new StringDataEntry("Key", "42"));
  }

  /**
   * Test {@link StringDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringDataEntry.equals(Object)", "int StringDataEntry.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringDataEntry("Key", "42"), null);
  }

  /**
   * Test {@link StringDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringDataEntry.equals(Object)", "int StringDataEntry.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringDataEntry("Key", "42"), "Different type to StringDataEntry");
  }
}
