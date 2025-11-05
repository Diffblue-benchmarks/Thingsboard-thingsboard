package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CacheSpecsDiffblueTest {
  /**
   * Test {@link CacheSpecs#equals(Object)}, and {@link CacheSpecs#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CacheSpecs#equals(Object)}
   *   <li>{@link CacheSpecs#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecs.equals(Object)", "int CacheSpecs.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(1);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(3);
    cacheSpecs2.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertEquals(cacheSpecs, cacheSpecs2);
    assertEquals(cacheSpecs.hashCode(), cacheSpecs2.hashCode());
  }

  /**
   * Test {@link CacheSpecs#equals(Object)}, and {@link CacheSpecs#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CacheSpecs#equals(Object)}
   *   <li>{@link CacheSpecs#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecs.equals(Object)", "int CacheSpecs.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(null);
    cacheSpecs.setTimeToLiveInMinutes(1);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(null);
    cacheSpecs2.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertEquals(cacheSpecs, cacheSpecs2);
    assertEquals(cacheSpecs.hashCode(), cacheSpecs2.hashCode());
  }

  /**
   * Test {@link CacheSpecs#equals(Object)}, and {@link CacheSpecs#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CacheSpecs#equals(Object)}
   *   <li>{@link CacheSpecs#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecs.equals(Object)", "int CacheSpecs.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(null);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(3);
    cacheSpecs2.setTimeToLiveInMinutes(null);

    // Act and Assert
    assertEquals(cacheSpecs, cacheSpecs2);
    assertEquals(cacheSpecs.hashCode(), cacheSpecs2.hashCode());
  }

  /**
   * Test {@link CacheSpecs#equals(Object)}, and {@link CacheSpecs#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CacheSpecs#equals(Object)}
   *   <li>{@link CacheSpecs#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecs.equals(Object)", "int CacheSpecs.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertEquals(cacheSpecs, cacheSpecs);
    int expectedHashCodeResult = cacheSpecs.hashCode();
    assertEquals(expectedHashCodeResult, cacheSpecs.hashCode());
  }

  /**
   * Test {@link CacheSpecs#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CacheSpecs#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecs.equals(Object)", "int CacheSpecs.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(1);
    cacheSpecs.setTimeToLiveInMinutes(1);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(3);
    cacheSpecs2.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertNotEquals(cacheSpecs, cacheSpecs2);
  }

  /**
   * Test {@link CacheSpecs#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CacheSpecs#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecs.equals(Object)", "int CacheSpecs.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(null);
    cacheSpecs.setTimeToLiveInMinutes(1);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(3);
    cacheSpecs2.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertNotEquals(cacheSpecs, cacheSpecs2);
  }

  /**
   * Test {@link CacheSpecs#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CacheSpecs#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecs.equals(Object)", "int CacheSpecs.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(3);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(3);
    cacheSpecs2.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertNotEquals(cacheSpecs, cacheSpecs2);
  }

  /**
   * Test {@link CacheSpecs#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CacheSpecs#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecs.equals(Object)", "int CacheSpecs.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(null);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(3);
    cacheSpecs2.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertNotEquals(cacheSpecs, cacheSpecs2);
  }

  /**
   * Test {@link CacheSpecs#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CacheSpecs#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecs.equals(Object)", "int CacheSpecs.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertNotEquals(cacheSpecs, null);
  }

  /**
   * Test {@link CacheSpecs#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CacheSpecs#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecs.equals(Object)", "int CacheSpecs.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertNotEquals(cacheSpecs, "Different type to CacheSpecs");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CacheSpecs}
   *   <li>{@link CacheSpecs#setMaxSize(Integer)}
   *   <li>{@link CacheSpecs#setTimeToLiveInMinutes(Integer)}
   *   <li>{@link CacheSpecs#toString()}
   *   <li>{@link CacheSpecs#getMaxSize()}
   *   <li>{@link CacheSpecs#getTimeToLiveInMinutes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CacheSpecs.<init>()",
    "Integer CacheSpecs.getMaxSize()",
    "Integer CacheSpecs.getTimeToLiveInMinutes()",
    "void CacheSpecs.setMaxSize(Integer)",
    "void CacheSpecs.setTimeToLiveInMinutes(Integer)",
    "String CacheSpecs.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    CacheSpecs actualCacheSpecs = new CacheSpecs();
    actualCacheSpecs.setMaxSize(3);
    actualCacheSpecs.setTimeToLiveInMinutes(1);
    String actualToStringResult = actualCacheSpecs.toString();
    Integer actualMaxSize = actualCacheSpecs.getMaxSize();

    // Assert
    assertEquals("CacheSpecs(timeToLiveInMinutes=1, maxSize=3)", actualToStringResult);
    assertEquals(1, actualCacheSpecs.getTimeToLiveInMinutes().intValue());
    assertEquals(3, actualMaxSize.intValue());
  }
}
