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

class BooleanDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BooleanDataEntry#BooleanDataEntry(String, Boolean)}
   *   <li>{@link BooleanDataEntry#toString()}
   *   <li>{@link BooleanDataEntry#getDataType()}
   *   <li>{@link BooleanDataEntry#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BooleanDataEntry.<init>(String, Boolean)",
    "DataType BooleanDataEntry.getDataType()",
    "Object BooleanDataEntry.getValue()",
    "String BooleanDataEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BooleanDataEntry actualBooleanDataEntry = new BooleanDataEntry("Key", true);
    String actualToStringResult = actualBooleanDataEntry.toString();
    DataType actualDataType = actualBooleanDataEntry.getDataType();
    Object actualValue = actualBooleanDataEntry.getValue();

    // Assert
    assertEquals("BooleanDataEntry{value=true} BasicKvEntry{key='Key'}", actualToStringResult);
    assertEquals("Key", actualBooleanDataEntry.getKey());
    assertEquals(DataType.BOOLEAN, actualDataType);
    assertTrue((Boolean) actualValue);
  }

  /**
   * Test {@link BooleanDataEntry#getBooleanValue()}.
   *
   * <p>Method under test: {@link BooleanDataEntry#getBooleanValue()}
   */
  @Test
  @DisplayName("Test getBooleanValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BooleanDataEntry.getBooleanValue()"})
  void testGetBooleanValue() {
    // Arrange and Act
    Optional<Boolean> actualBooleanValue = new BooleanDataEntry("Key", true).getBooleanValue();

    // Assert
    assertTrue(actualBooleanValue.get());
    assertTrue(actualBooleanValue.isPresent());
  }

  /**
   * Test {@link BooleanDataEntry#equals(Object)}, and {@link BooleanDataEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BooleanDataEntry#equals(Object)}
   *   <li>{@link BooleanDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BooleanDataEntry.equals(Object)", "int BooleanDataEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BooleanDataEntry booleanDataEntry = new BooleanDataEntry("Key", true);
    BooleanDataEntry booleanDataEntry2 = new BooleanDataEntry("Key", true);

    // Act and Assert
    assertEquals(booleanDataEntry, booleanDataEntry2);
    assertEquals(booleanDataEntry.hashCode(), booleanDataEntry2.hashCode());
  }

  /**
   * Test {@link BooleanDataEntry#equals(Object)}, and {@link BooleanDataEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BooleanDataEntry#equals(Object)}
   *   <li>{@link BooleanDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BooleanDataEntry.equals(Object)", "int BooleanDataEntry.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BooleanDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BooleanDataEntry.equals(Object)", "int BooleanDataEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BooleanDataEntry booleanDataEntry =
        new BooleanDataEntry("org.thingsboard.server.common.data.kv.BooleanDataEntry", true);

    // Act and Assert
    assertNotEquals(booleanDataEntry, new BooleanDataEntry("Key", true));
  }

  /**
   * Test {@link BooleanDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BooleanDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BooleanDataEntry.equals(Object)", "int BooleanDataEntry.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanDataEntry("Key", true), null);
  }

  /**
   * Test {@link BooleanDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BooleanDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BooleanDataEntry.equals(Object)", "int BooleanDataEntry.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanDataEntry("Key", true), "Different type to BooleanDataEntry");
  }

  /**
   * Test {@link BooleanDataEntry#getValueAsString()}.
   *
   * <p>Method under test: {@link BooleanDataEntry#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BooleanDataEntry.getValueAsString()"})
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals(Boolean.TRUE.toString(), new BooleanDataEntry("Key", true).getValueAsString());
  }
}
