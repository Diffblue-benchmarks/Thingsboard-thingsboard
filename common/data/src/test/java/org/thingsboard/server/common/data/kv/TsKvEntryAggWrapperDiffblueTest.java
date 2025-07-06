package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TsKvEntryAggWrapperDiffblueTest {
  /**
   * Test {@link TsKvEntryAggWrapper#equals(Object)}, and {@link TsKvEntryAggWrapper#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvEntryAggWrapper#equals(Object)}
   *   <li>{@link TsKvEntryAggWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TsKvEntryAggWrapper.equals(Object)",
    "int TsKvEntryAggWrapper.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKvEntryAggWrapper tsKvEntryAggWrapper =
        new TsKvEntryAggWrapper(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L);
    TsKvEntryAggWrapper tsKvEntryAggWrapper2 =
        new TsKvEntryAggWrapper(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L);

    // Act and Assert
    assertEquals(tsKvEntryAggWrapper, tsKvEntryAggWrapper2);
    int expectedHashCodeResult = tsKvEntryAggWrapper.hashCode();
    assertEquals(expectedHashCodeResult, tsKvEntryAggWrapper2.hashCode());
  }

  /**
   * Test {@link TsKvEntryAggWrapper#equals(Object)}, and {@link TsKvEntryAggWrapper#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvEntryAggWrapper#equals(Object)}
   *   <li>{@link TsKvEntryAggWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TsKvEntryAggWrapper.equals(Object)",
    "int TsKvEntryAggWrapper.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsKvEntryAggWrapper tsKvEntryAggWrapper = new TsKvEntryAggWrapper(null, 1L);
    TsKvEntryAggWrapper tsKvEntryAggWrapper2 = new TsKvEntryAggWrapper(null, 1L);

    // Act and Assert
    assertEquals(tsKvEntryAggWrapper, tsKvEntryAggWrapper2);
    int expectedHashCodeResult = tsKvEntryAggWrapper.hashCode();
    assertEquals(expectedHashCodeResult, tsKvEntryAggWrapper2.hashCode());
  }

  /**
   * Test {@link TsKvEntryAggWrapper#equals(Object)}, and {@link TsKvEntryAggWrapper#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvEntryAggWrapper#equals(Object)}
   *   <li>{@link TsKvEntryAggWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TsKvEntryAggWrapper.equals(Object)",
    "int TsKvEntryAggWrapper.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKvEntryAggWrapper tsKvEntryAggWrapper =
        new TsKvEntryAggWrapper(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L);

    // Act and Assert
    assertEquals(tsKvEntryAggWrapper, tsKvEntryAggWrapper);
    int expectedHashCodeResult = tsKvEntryAggWrapper.hashCode();
    assertEquals(expectedHashCodeResult, tsKvEntryAggWrapper.hashCode());
  }

  /**
   * Test {@link TsKvEntryAggWrapper#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntryAggWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TsKvEntryAggWrapper.equals(Object)",
    "int TsKvEntryAggWrapper.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvEntryAggWrapper tsKvEntryAggWrapper =
        new TsKvEntryAggWrapper(new BasicTsKvEntry(3L, new JsonDataEntry("Key", "42")), 1L);

    // Act and Assert
    assertNotEquals(
        tsKvEntryAggWrapper,
        new TsKvEntryAggWrapper(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L));
  }

  /**
   * Test {@link TsKvEntryAggWrapper#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntryAggWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TsKvEntryAggWrapper.equals(Object)",
    "int TsKvEntryAggWrapper.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsKvEntryAggWrapper tsKvEntryAggWrapper = new TsKvEntryAggWrapper(null, 1L);

    // Act and Assert
    assertNotEquals(
        tsKvEntryAggWrapper,
        new TsKvEntryAggWrapper(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L));
  }

  /**
   * Test {@link TsKvEntryAggWrapper#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntryAggWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TsKvEntryAggWrapper.equals(Object)",
    "int TsKvEntryAggWrapper.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsKvEntryAggWrapper tsKvEntryAggWrapper =
        new TsKvEntryAggWrapper(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 3L);

    // Act and Assert
    assertNotEquals(
        tsKvEntryAggWrapper,
        new TsKvEntryAggWrapper(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L));
  }

  /**
   * Test {@link TsKvEntryAggWrapper#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntryAggWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TsKvEntryAggWrapper.equals(Object)",
    "int TsKvEntryAggWrapper.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TsKvEntryAggWrapper(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L), null);
  }

  /**
   * Test {@link TsKvEntryAggWrapper#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntryAggWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TsKvEntryAggWrapper.equals(Object)",
    "int TsKvEntryAggWrapper.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TsKvEntryAggWrapper(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L),
        "Different type to TsKvEntryAggWrapper");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvEntryAggWrapper#TsKvEntryAggWrapper(TsKvEntry, long)}
   *   <li>{@link TsKvEntryAggWrapper#toString()}
   *   <li>{@link TsKvEntryAggWrapper#getEntry()}
   *   <li>{@link TsKvEntryAggWrapper#getLastEntryTs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TsKvEntryAggWrapper.<init>(TsKvEntry, long)",
    "TsKvEntry TsKvEntryAggWrapper.getEntry()",
    "long TsKvEntryAggWrapper.getLastEntryTs()",
    "String TsKvEntryAggWrapper.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    BasicTsKvEntry entry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act
    TsKvEntryAggWrapper actualTsKvEntryAggWrapper = new TsKvEntryAggWrapper(entry, 1L);
    String actualToStringResult = actualTsKvEntryAggWrapper.toString();
    TsKvEntry actualEntry = actualTsKvEntryAggWrapper.getEntry();

    // Assert
    assertEquals(
        "TsKvEntryAggWrapper(entry=BasicTsKvEntry(ts=1, kv=JsonDataEntry{value=42} BasicKvEntry{key='Key'},"
            + " version=null), lastEntryTs=1)",
        actualToStringResult);
    assertEquals(1L, actualTsKvEntryAggWrapper.getLastEntryTs());
    assertSame(entry, actualEntry);
  }
}
