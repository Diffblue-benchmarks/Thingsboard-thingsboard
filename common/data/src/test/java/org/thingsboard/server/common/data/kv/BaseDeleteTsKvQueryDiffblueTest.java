package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BaseDeleteTsKvQueryDiffblueTest {
  /**
   * Test {@link BaseDeleteTsKvQuery#BaseDeleteTsKvQuery(String, long, long)}.
   *
   * <p>Method under test: {@link BaseDeleteTsKvQuery#BaseDeleteTsKvQuery(String, long, long)}
   */
  @Test
  @DisplayName("Test new BaseDeleteTsKvQuery(String, long, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDeleteTsKvQuery.<init>(String, long, long)"})
  void testNewBaseDeleteTsKvQuery() {
    // Arrange and Act
    BaseDeleteTsKvQuery actualBaseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Assert
    assertEquals("Key", actualBaseDeleteTsKvQuery.getKey());
    assertEquals(0, actualBaseDeleteTsKvQuery.getId());
    assertEquals(1L, actualBaseDeleteTsKvQuery.getEndTs());
    assertEquals(1L, actualBaseDeleteTsKvQuery.getStartTs());
    assertFalse(actualBaseDeleteTsKvQuery.getRewriteLatestIfDeleted());
    assertTrue(actualBaseDeleteTsKvQuery.getDeleteLatest());
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#BaseDeleteTsKvQuery(String, long, long, boolean)}.
   *
   * <p>Method under test: {@link BaseDeleteTsKvQuery#BaseDeleteTsKvQuery(String, long, long,
   * boolean)}
   */
  @Test
  @DisplayName("Test new BaseDeleteTsKvQuery(String, long, long, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDeleteTsKvQuery.<init>(String, long, long, boolean)"})
  void testNewBaseDeleteTsKvQuery2() {
    // Arrange and Act
    BaseDeleteTsKvQuery actualBaseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L, true);

    // Assert
    assertEquals("Key", actualBaseDeleteTsKvQuery.getKey());
    assertEquals(0, actualBaseDeleteTsKvQuery.getId());
    assertEquals(1L, actualBaseDeleteTsKvQuery.getEndTs());
    assertEquals(1L, actualBaseDeleteTsKvQuery.getStartTs());
    assertTrue(actualBaseDeleteTsKvQuery.getDeleteLatest());
    assertTrue(actualBaseDeleteTsKvQuery.getRewriteLatestIfDeleted());
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#BaseDeleteTsKvQuery(String, long, long, boolean, boolean)}.
   *
   * <p>Method under test: {@link BaseDeleteTsKvQuery#BaseDeleteTsKvQuery(String, long, long,
   * boolean, boolean)}
   */
  @Test
  @DisplayName("Test new BaseDeleteTsKvQuery(String, long, long, boolean, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDeleteTsKvQuery.<init>(String, long, long, boolean, boolean)"})
  void testNewBaseDeleteTsKvQuery3() {
    // Arrange and Act
    BaseDeleteTsKvQuery actualBaseDeleteTsKvQuery =
        new BaseDeleteTsKvQuery("Key", 1L, 1L, true, true);

    // Assert
    assertEquals("Key", actualBaseDeleteTsKvQuery.getKey());
    assertEquals(0, actualBaseDeleteTsKvQuery.getId());
    assertEquals(1L, actualBaseDeleteTsKvQuery.getEndTs());
    assertEquals(1L, actualBaseDeleteTsKvQuery.getStartTs());
    assertTrue(actualBaseDeleteTsKvQuery.getDeleteLatest());
    assertTrue(actualBaseDeleteTsKvQuery.getRewriteLatestIfDeleted());
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}, and {@link BaseDeleteTsKvQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseDeleteTsKvQuery#equals(Object)}
   *   <li>{@link BaseDeleteTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseDeleteTsKvQuery.equals(Object)",
    "int BaseDeleteTsKvQuery.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);
    BaseDeleteTsKvQuery baseDeleteTsKvQuery2 = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(baseDeleteTsKvQuery, baseDeleteTsKvQuery2);
    int expectedHashCodeResult = baseDeleteTsKvQuery.hashCode();
    assertEquals(expectedHashCodeResult, baseDeleteTsKvQuery2.hashCode());
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}, and {@link BaseDeleteTsKvQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseDeleteTsKvQuery#equals(Object)}
   *   <li>{@link BaseDeleteTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseDeleteTsKvQuery.equals(Object)",
    "int BaseDeleteTsKvQuery.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(baseDeleteTsKvQuery, baseDeleteTsKvQuery);
    int expectedHashCodeResult = baseDeleteTsKvQuery.hashCode();
    assertEquals(expectedHashCodeResult, baseDeleteTsKvQuery.hashCode());
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseDeleteTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseDeleteTsKvQuery.equals(Object)",
    "int BaseDeleteTsKvQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L, true);

    // Act and Assert
    assertNotEquals(baseDeleteTsKvQuery, new BaseDeleteTsKvQuery("Key", 1L, 1L));
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseDeleteTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseDeleteTsKvQuery.equals(Object)",
    "int BaseDeleteTsKvQuery.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseDeleteTsKvQuery("Key", 1L, 1L), null);
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseDeleteTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BaseDeleteTsKvQuery.equals(Object)",
    "int BaseDeleteTsKvQuery.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new BaseDeleteTsKvQuery("Key", 1L, 1L), "Different type to BaseDeleteTsKvQuery");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseDeleteTsKvQuery#toString()}
   *   <li>{@link BaseDeleteTsKvQuery#getDeleteLatest()}
   *   <li>{@link BaseDeleteTsKvQuery#getRewriteLatestIfDeleted()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Boolean BaseDeleteTsKvQuery.getDeleteLatest()",
    "Boolean BaseDeleteTsKvQuery.getRewriteLatestIfDeleted()",
    "String BaseDeleteTsKvQuery.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Act
    String actualToStringResult = baseDeleteTsKvQuery.toString();
    Boolean actualDeleteLatest = baseDeleteTsKvQuery.getDeleteLatest();

    // Assert
    assertEquals(
        "BaseDeleteTsKvQuery(rewriteLatestIfDeleted=false, deleteLatest=true)",
        actualToStringResult);
    assertFalse(baseDeleteTsKvQuery.getRewriteLatestIfDeleted());
    assertTrue(actualDeleteLatest);
  }
}
