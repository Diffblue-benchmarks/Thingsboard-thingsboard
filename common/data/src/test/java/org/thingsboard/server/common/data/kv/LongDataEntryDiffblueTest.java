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

class LongDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LongDataEntry#LongDataEntry(String, Long)}
   *   <li>{@link LongDataEntry#toString()}
   *   <li>{@link LongDataEntry#getDataType()}
   *   <li>{@link LongDataEntry#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LongDataEntry.<init>(String, Long)",
    "DataType LongDataEntry.getDataType()",
    "Object LongDataEntry.getValue()",
    "String LongDataEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LongDataEntry actualLongDataEntry = new LongDataEntry("Key", 42L);
    String actualToStringResult = actualLongDataEntry.toString();
    DataType actualDataType = actualLongDataEntry.getDataType();
    Object actualValue = actualLongDataEntry.getValue();

    // Assert
    assertEquals("Key", actualLongDataEntry.getKey());
    assertEquals("LongDataEntry{value=42} BasicKvEntry{key='Key'}", actualToStringResult);
    assertEquals(42L, ((Long) actualValue).longValue());
    assertEquals(DataType.LONG, actualDataType);
  }

  /**
   * Test {@link LongDataEntry#getLongValue()}.
   *
   * <p>Method under test: {@link LongDataEntry#getLongValue()}
   */
  @Test
  @DisplayName("Test getLongValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LongDataEntry.getLongValue()"})
  void testGetLongValue() {
    // Arrange and Act
    Optional<Long> actualLongValue = new LongDataEntry("Key", 42L).getLongValue();

    // Assert
    assertEquals(42L, actualLongValue.get().longValue());
    assertTrue(actualLongValue.isPresent());
  }

  /**
   * Test {@link LongDataEntry#equals(Object)}, and {@link LongDataEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LongDataEntry#equals(Object)}
   *   <li>{@link LongDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LongDataEntry.equals(Object)", "int LongDataEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LongDataEntry longDataEntry = new LongDataEntry("Key", 42L);
    LongDataEntry longDataEntry2 = new LongDataEntry("Key", 42L);

    // Act and Assert
    assertEquals(longDataEntry, longDataEntry2);
    assertEquals(longDataEntry.hashCode(), longDataEntry2.hashCode());
  }

  /**
   * Test {@link LongDataEntry#equals(Object)}, and {@link LongDataEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LongDataEntry#equals(Object)}
   *   <li>{@link LongDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LongDataEntry.equals(Object)", "int LongDataEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LongDataEntry longDataEntry = new LongDataEntry("Key", 42L);

    // Act and Assert
    assertEquals(longDataEntry, longDataEntry);
    int expectedHashCodeResult = longDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, longDataEntry.hashCode());
  }

  /**
   * Test {@link LongDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LongDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LongDataEntry.equals(Object)", "int LongDataEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LongDataEntry longDataEntry =
        new LongDataEntry("org.thingsboard.server.common.data.kv.LongDataEntry", 42L);

    // Act and Assert
    assertNotEquals(longDataEntry, new LongDataEntry("Key", 42L));
  }

  /**
   * Test {@link LongDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LongDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LongDataEntry.equals(Object)", "int LongDataEntry.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongDataEntry("Key", 42L), null);
  }

  /**
   * Test {@link LongDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LongDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LongDataEntry.equals(Object)", "int LongDataEntry.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongDataEntry("Key", 42L), "Different type to LongDataEntry");
  }

  /**
   * Test {@link LongDataEntry#getValueAsString()}.
   *
   * <p>Method under test: {@link LongDataEntry#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LongDataEntry.getValueAsString()"})
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("42", new LongDataEntry("Key", 42L).getValueAsString());
  }
}
