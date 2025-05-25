package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TsKvLatestRemovingResultDiffblueTest {
  /**
   * Test {@link TsKvLatestRemovingResult#equals(Object)}, and {@link TsKvLatestRemovingResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvLatestRemovingResult#equals(Object)}
   *   <li>{@link TsKvLatestRemovingResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestRemovingResult.equals(Object)", "int TsKvLatestRemovingResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKvLatestRemovingResult tsKvLatestRemovingResult = new TsKvLatestRemovingResult("Key", true);
    TsKvLatestRemovingResult tsKvLatestRemovingResult2 = new TsKvLatestRemovingResult("Key", true);

    // Act and Assert
    assertEquals(tsKvLatestRemovingResult, tsKvLatestRemovingResult2);
    int expectedHashCodeResult = tsKvLatestRemovingResult.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestRemovingResult2.hashCode());
  }

  /**
   * Test {@link TsKvLatestRemovingResult#equals(Object)}, and {@link TsKvLatestRemovingResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvLatestRemovingResult#equals(Object)}
   *   <li>{@link TsKvLatestRemovingResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestRemovingResult.equals(Object)", "int TsKvLatestRemovingResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsKvLatestRemovingResult tsKvLatestRemovingResult = new TsKvLatestRemovingResult(null, true);
    TsKvLatestRemovingResult tsKvLatestRemovingResult2 = new TsKvLatestRemovingResult(null, true);

    // Act and Assert
    assertEquals(tsKvLatestRemovingResult, tsKvLatestRemovingResult2);
    int expectedHashCodeResult = tsKvLatestRemovingResult.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestRemovingResult2.hashCode());
  }

  /**
   * Test {@link TsKvLatestRemovingResult#equals(Object)}, and {@link TsKvLatestRemovingResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvLatestRemovingResult#equals(Object)}
   *   <li>{@link TsKvLatestRemovingResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestRemovingResult.equals(Object)", "int TsKvLatestRemovingResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TsKvLatestRemovingResult tsKvLatestRemovingResult = new TsKvLatestRemovingResult(
        new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L);
    TsKvLatestRemovingResult tsKvLatestRemovingResult2 = new TsKvLatestRemovingResult(
        new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L);

    // Act and Assert
    assertEquals(tsKvLatestRemovingResult, tsKvLatestRemovingResult2);
    int expectedHashCodeResult = tsKvLatestRemovingResult.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestRemovingResult2.hashCode());
  }

  /**
   * Test {@link TsKvLatestRemovingResult#equals(Object)}, and {@link TsKvLatestRemovingResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvLatestRemovingResult#equals(Object)}
   *   <li>{@link TsKvLatestRemovingResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestRemovingResult.equals(Object)", "int TsKvLatestRemovingResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKvLatestRemovingResult tsKvLatestRemovingResult = new TsKvLatestRemovingResult("Key", true);

    // Act and Assert
    assertEquals(tsKvLatestRemovingResult, tsKvLatestRemovingResult);
    int expectedHashCodeResult = tsKvLatestRemovingResult.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestRemovingResult.hashCode());
  }

  /**
   * Test {@link TsKvLatestRemovingResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestRemovingResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestRemovingResult.equals(Object)", "int TsKvLatestRemovingResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvLatestRemovingResult tsKvLatestRemovingResult = new TsKvLatestRemovingResult(null, true);

    // Act and Assert
    assertNotEquals(tsKvLatestRemovingResult, new TsKvLatestRemovingResult("Key", true));
  }

  /**
   * Test {@link TsKvLatestRemovingResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestRemovingResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestRemovingResult.equals(Object)", "int TsKvLatestRemovingResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsKvLatestRemovingResult tsKvLatestRemovingResult = new TsKvLatestRemovingResult(
        "org.thingsboard.server.common.data.kv.TsKvLatestRemovingResult", true);

    // Act and Assert
    assertNotEquals(tsKvLatestRemovingResult, new TsKvLatestRemovingResult("Key", true));
  }

  /**
   * Test {@link TsKvLatestRemovingResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestRemovingResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestRemovingResult.equals(Object)", "int TsKvLatestRemovingResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsKvLatestRemovingResult tsKvLatestRemovingResult = new TsKvLatestRemovingResult("Key", false);

    // Act and Assert
    assertNotEquals(tsKvLatestRemovingResult, new TsKvLatestRemovingResult("Key", true));
  }

  /**
   * Test {@link TsKvLatestRemovingResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestRemovingResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestRemovingResult.equals(Object)", "int TsKvLatestRemovingResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TsKvLatestRemovingResult tsKvLatestRemovingResult = new TsKvLatestRemovingResult(
        new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L);

    // Act and Assert
    assertNotEquals(tsKvLatestRemovingResult, new TsKvLatestRemovingResult("Key", true));
  }

  /**
   * Test {@link TsKvLatestRemovingResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestRemovingResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestRemovingResult.equals(Object)", "int TsKvLatestRemovingResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TsKvLatestRemovingResult tsKvLatestRemovingResult = new TsKvLatestRemovingResult("Key", true);

    // Act and Assert
    assertNotEquals(tsKvLatestRemovingResult,
        new TsKvLatestRemovingResult(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L));
  }

  /**
   * Test {@link TsKvLatestRemovingResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestRemovingResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestRemovingResult.equals(Object)", "int TsKvLatestRemovingResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TsKvLatestRemovingResult tsKvLatestRemovingResult = new TsKvLatestRemovingResult("Key", true);
    tsKvLatestRemovingResult.setData(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertNotEquals(tsKvLatestRemovingResult, new TsKvLatestRemovingResult("Key", true));
  }

  /**
   * Test {@link TsKvLatestRemovingResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestRemovingResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestRemovingResult.equals(Object)", "int TsKvLatestRemovingResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TsKvLatestRemovingResult tsKvLatestRemovingResult = new TsKvLatestRemovingResult("Key", true);

    TsKvLatestRemovingResult tsKvLatestRemovingResult2 = new TsKvLatestRemovingResult("Key", true);
    tsKvLatestRemovingResult2.setData(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertNotEquals(tsKvLatestRemovingResult, tsKvLatestRemovingResult2);
  }

  /**
   * Test {@link TsKvLatestRemovingResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestRemovingResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestRemovingResult.equals(Object)", "int TsKvLatestRemovingResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvLatestRemovingResult("Key", true), null);
  }

  /**
   * Test {@link TsKvLatestRemovingResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestRemovingResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvLatestRemovingResult.equals(Object)", "int TsKvLatestRemovingResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvLatestRemovingResult("Key", true), "Different type to TsKvLatestRemovingResult");
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvLatestRemovingResult#TsKvLatestRemovingResult(String, boolean, Long)}
   *   <li>{@link TsKvLatestRemovingResult#setData(TsKvEntry)}
   *   <li>{@link TsKvLatestRemovingResult#setKey(String)}
   *   <li>{@link TsKvLatestRemovingResult#setRemoved(boolean)}
   *   <li>{@link TsKvLatestRemovingResult#setVersion(Long)}
   *   <li>{@link TsKvLatestRemovingResult#toString()}
   *   <li>{@link TsKvLatestRemovingResult#getData()}
   *   <li>{@link TsKvLatestRemovingResult#getKey()}
   *   <li>{@link TsKvLatestRemovingResult#getVersion()}
   *   <li>{@link TsKvLatestRemovingResult#isRemoved()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvLatestRemovingResult.<init>(String, boolean)",
      "void TsKvLatestRemovingResult.<init>(String, boolean, Long)", "TsKvEntry TsKvLatestRemovingResult.getData()",
      "String TsKvLatestRemovingResult.getKey()", "Long TsKvLatestRemovingResult.getVersion()",
      "boolean TsKvLatestRemovingResult.isRemoved()", "void TsKvLatestRemovingResult.setData(TsKvEntry)",
      "void TsKvLatestRemovingResult.setKey(String)", "void TsKvLatestRemovingResult.setRemoved(boolean)",
      "void TsKvLatestRemovingResult.setVersion(Long)", "String TsKvLatestRemovingResult.toString()"})
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    TsKvLatestRemovingResult actualTsKvLatestRemovingResult = new TsKvLatestRemovingResult("Key", true, 1L);
    BasicTsKvEntry data = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    actualTsKvLatestRemovingResult.setData(data);
    actualTsKvLatestRemovingResult.setKey("Key");
    actualTsKvLatestRemovingResult.setRemoved(true);
    actualTsKvLatestRemovingResult.setVersion(1L);
    String actualToStringResult = actualTsKvLatestRemovingResult.toString();
    TsKvEntry actualData = actualTsKvLatestRemovingResult.getData();
    String actualKey = actualTsKvLatestRemovingResult.getKey();
    Long actualVersion = actualTsKvLatestRemovingResult.getVersion();
    boolean actualIsRemovedResult = actualTsKvLatestRemovingResult.isRemoved();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("TsKvLatestRemovingResult(key=Key, data=BasicTsKvEntry(ts=1, kv=JsonDataEntry{value=42} BasicKvEntry"
        + "{key='Key'}, version=null), removed=true, version=1)", actualToStringResult);
    assertEquals(1L, actualVersion.longValue());
    assertTrue(actualIsRemovedResult);
    assertSame(data, actualData);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvLatestRemovingResult#TsKvLatestRemovingResult(String, boolean)}
   *   <li>{@link TsKvLatestRemovingResult#setData(TsKvEntry)}
   *   <li>{@link TsKvLatestRemovingResult#setKey(String)}
   *   <li>{@link TsKvLatestRemovingResult#setRemoved(boolean)}
   *   <li>{@link TsKvLatestRemovingResult#setVersion(Long)}
   *   <li>{@link TsKvLatestRemovingResult#toString()}
   *   <li>{@link TsKvLatestRemovingResult#getData()}
   *   <li>{@link TsKvLatestRemovingResult#getKey()}
   *   <li>{@link TsKvLatestRemovingResult#getVersion()}
   *   <li>{@link TsKvLatestRemovingResult#isRemoved()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvLatestRemovingResult.<init>(String, boolean)",
      "void TsKvLatestRemovingResult.<init>(String, boolean, Long)", "TsKvEntry TsKvLatestRemovingResult.getData()",
      "String TsKvLatestRemovingResult.getKey()", "Long TsKvLatestRemovingResult.getVersion()",
      "boolean TsKvLatestRemovingResult.isRemoved()", "void TsKvLatestRemovingResult.setData(TsKvEntry)",
      "void TsKvLatestRemovingResult.setKey(String)", "void TsKvLatestRemovingResult.setRemoved(boolean)",
      "void TsKvLatestRemovingResult.setVersion(Long)", "String TsKvLatestRemovingResult.toString()"})
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    TsKvLatestRemovingResult actualTsKvLatestRemovingResult = new TsKvLatestRemovingResult("Key", true);
    BasicTsKvEntry data = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    actualTsKvLatestRemovingResult.setData(data);
    actualTsKvLatestRemovingResult.setKey("Key");
    actualTsKvLatestRemovingResult.setRemoved(true);
    actualTsKvLatestRemovingResult.setVersion(1L);
    String actualToStringResult = actualTsKvLatestRemovingResult.toString();
    TsKvEntry actualData = actualTsKvLatestRemovingResult.getData();
    String actualKey = actualTsKvLatestRemovingResult.getKey();
    Long actualVersion = actualTsKvLatestRemovingResult.getVersion();
    boolean actualIsRemovedResult = actualTsKvLatestRemovingResult.isRemoved();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("TsKvLatestRemovingResult(key=Key, data=BasicTsKvEntry(ts=1, kv=JsonDataEntry{value=42} BasicKvEntry"
        + "{key='Key'}, version=null), removed=true, version=1)", actualToStringResult);
    assertEquals(1L, actualVersion.longValue());
    assertTrue(actualIsRemovedResult);
    assertSame(data, actualData);
  }

  /**
   * Test {@link TsKvLatestRemovingResult#TsKvLatestRemovingResult(TsKvEntry, Long)}.
   * <ul>
   *   <li>Then return {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestRemovingResult#TsKvLatestRemovingResult(TsKvEntry, Long)}
   */
  @Test
  @DisplayName("Test new TsKvLatestRemovingResult(TsKvEntry, Long); then return 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvLatestRemovingResult.<init>(TsKvEntry, Long)"})
  void testNewTsKvLatestRemovingResult_thenReturnKey() {
    // Arrange
    BasicTsKvEntry data = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act
    TsKvLatestRemovingResult actualTsKvLatestRemovingResult = new TsKvLatestRemovingResult(data, 1L);

    // Assert
    assertEquals("Key", actualTsKvLatestRemovingResult.getKey());
    assertEquals(1L, actualTsKvLatestRemovingResult.getVersion().longValue());
    assertTrue(actualTsKvLatestRemovingResult.isRemoved());
    assertSame(data, actualTsKvLatestRemovingResult.getData());
  }
}
