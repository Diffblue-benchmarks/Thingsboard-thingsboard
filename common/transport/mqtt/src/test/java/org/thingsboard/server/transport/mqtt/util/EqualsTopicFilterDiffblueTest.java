package org.thingsboard.server.transport.mqtt.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EqualsTopicFilterDiffblueTest {
  /**
   * Test {@link EqualsTopicFilter#filter(String)}.
   *
   * <ul>
   *   <li>Given {@link EqualsTopicFilter#EqualsTopicFilter(String)} with filter is {@code Topic}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EqualsTopicFilter#filter(String)}
   */
  @Test
  @DisplayName(
      "Test filter(String); given EqualsTopicFilter(String) with filter is 'Topic'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EqualsTopicFilter.filter(String)"})
  void testFilter_givenEqualsTopicFilterWithFilterIsTopic_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new EqualsTopicFilter("Topic").filter("Topic"));
  }

  /**
   * Test {@link EqualsTopicFilter#filter(String)}.
   *
   * <ul>
   *   <li>Given {@link EqualsTopicFilter#EqualsTopicFilter(String)} with {@code Filter}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EqualsTopicFilter#filter(String)}
   */
  @Test
  @DisplayName(
      "Test filter(String); given EqualsTopicFilter(String) with 'Filter'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EqualsTopicFilter.filter(String)"})
  void testFilter_givenEqualsTopicFilterWithFilter_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EqualsTopicFilter("Filter").filter("Topic"));
  }

  /**
   * Test {@link EqualsTopicFilter#equals(Object)}, and {@link EqualsTopicFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EqualsTopicFilter#equals(Object)}
   *   <li>{@link EqualsTopicFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EqualsTopicFilter.equals(Object)",
    "int EqualsTopicFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EqualsTopicFilter equalsTopicFilter = new EqualsTopicFilter("Filter");
    EqualsTopicFilter equalsTopicFilter2 = new EqualsTopicFilter("Filter");

    // Act and Assert
    assertEquals(equalsTopicFilter, equalsTopicFilter2);
    int expectedHashCodeResult = equalsTopicFilter.hashCode();
    assertEquals(expectedHashCodeResult, equalsTopicFilter2.hashCode());
  }

  /**
   * Test {@link EqualsTopicFilter#equals(Object)}, and {@link EqualsTopicFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EqualsTopicFilter#equals(Object)}
   *   <li>{@link EqualsTopicFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EqualsTopicFilter.equals(Object)",
    "int EqualsTopicFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EqualsTopicFilter equalsTopicFilter = new EqualsTopicFilter(null);
    EqualsTopicFilter equalsTopicFilter2 = new EqualsTopicFilter(null);

    // Act and Assert
    assertEquals(equalsTopicFilter, equalsTopicFilter2);
    int expectedHashCodeResult = equalsTopicFilter.hashCode();
    assertEquals(expectedHashCodeResult, equalsTopicFilter2.hashCode());
  }

  /**
   * Test {@link EqualsTopicFilter#equals(Object)}, and {@link EqualsTopicFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EqualsTopicFilter#equals(Object)}
   *   <li>{@link EqualsTopicFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EqualsTopicFilter.equals(Object)",
    "int EqualsTopicFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EqualsTopicFilter equalsTopicFilter = new EqualsTopicFilter("Filter");

    // Act and Assert
    assertEquals(equalsTopicFilter, equalsTopicFilter);
    int expectedHashCodeResult = equalsTopicFilter.hashCode();
    assertEquals(expectedHashCodeResult, equalsTopicFilter.hashCode());
  }

  /**
   * Test {@link EqualsTopicFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EqualsTopicFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EqualsTopicFilter.equals(Object)",
    "int EqualsTopicFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EqualsTopicFilter equalsTopicFilter = new EqualsTopicFilter(null);

    // Act and Assert
    assertNotEquals(equalsTopicFilter, new EqualsTopicFilter("Filter"));
  }

  /**
   * Test {@link EqualsTopicFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EqualsTopicFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EqualsTopicFilter.equals(Object)",
    "int EqualsTopicFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EqualsTopicFilter equalsTopicFilter =
        new EqualsTopicFilter("org.thingsboard.server.transport.mqtt.util.EqualsTopicFilter");

    // Act and Assert
    assertNotEquals(equalsTopicFilter, new EqualsTopicFilter("Filter"));
  }

  /**
   * Test {@link EqualsTopicFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EqualsTopicFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EqualsTopicFilter.equals(Object)",
    "int EqualsTopicFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EqualsTopicFilter("Filter"), null);
  }

  /**
   * Test {@link EqualsTopicFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EqualsTopicFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EqualsTopicFilter.equals(Object)",
    "int EqualsTopicFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EqualsTopicFilter("Filter"), "Different type to EqualsTopicFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EqualsTopicFilter#EqualsTopicFilter(String)}
   *   <li>{@link EqualsTopicFilter#toString()}
   *   <li>{@link EqualsTopicFilter#getFilter()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EqualsTopicFilter.<init>(String)",
    "String EqualsTopicFilter.getFilter()",
    "String EqualsTopicFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EqualsTopicFilter actualEqualsTopicFilter = new EqualsTopicFilter("Filter");
    String actualToStringResult = actualEqualsTopicFilter.toString();

    // Assert
    assertEquals("EqualsTopicFilter(filter=Filter)", actualToStringResult);
    assertEquals("Filter", actualEqualsTopicFilter.getFilter());
  }
}
