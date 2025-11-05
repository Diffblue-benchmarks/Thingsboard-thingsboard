package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CacheSpecsMapDiffblueTest {
  /**
   * Test {@link CacheSpecsMap#equals(Object)}, and {@link CacheSpecsMap#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CacheSpecsMap#equals(Object)}
   *   <li>{@link CacheSpecsMap#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecsMap.equals(Object)", "int CacheSpecsMap.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CacheSpecsMap cacheSpecsMap2 = new CacheSpecsMap();

    // Act and Assert
    assertEquals(cacheSpecsMap, cacheSpecsMap2);
    assertEquals(cacheSpecsMap.hashCode(), cacheSpecsMap2.hashCode());
  }

  /**
   * Test {@link CacheSpecsMap#equals(Object)}, and {@link CacheSpecsMap#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CacheSpecsMap#equals(Object)}
   *   <li>{@link CacheSpecsMap#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecsMap.equals(Object)", "int CacheSpecsMap.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    cacheSpecsMap.setSpecs(new HashMap<>());

    CacheSpecsMap cacheSpecsMap2 = new CacheSpecsMap();
    cacheSpecsMap2.setSpecs(new HashMap<>());

    // Act and Assert
    assertEquals(cacheSpecsMap, cacheSpecsMap2);
    assertEquals(cacheSpecsMap.hashCode(), cacheSpecsMap2.hashCode());
  }

  /**
   * Test {@link CacheSpecsMap#equals(Object)}, and {@link CacheSpecsMap#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CacheSpecsMap#equals(Object)}
   *   <li>{@link CacheSpecsMap#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecsMap.equals(Object)", "int CacheSpecsMap.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    // Act and Assert
    assertEquals(cacheSpecsMap, cacheSpecsMap);
    int expectedHashCodeResult = cacheSpecsMap.hashCode();
    assertEquals(expectedHashCodeResult, cacheSpecsMap.hashCode());
  }

  /**
   * Test {@link CacheSpecsMap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CacheSpecsMap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecsMap.equals(Object)", "int CacheSpecsMap.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CacheSpecsMap(), 1);
  }

  /**
   * Test {@link CacheSpecsMap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CacheSpecsMap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecsMap.equals(Object)", "int CacheSpecsMap.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    cacheSpecsMap.setRefreshTokenExpTime(1);

    // Act and Assert
    assertNotEquals(cacheSpecsMap, new CacheSpecsMap());
  }

  /**
   * Test {@link CacheSpecsMap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CacheSpecsMap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecsMap.equals(Object)", "int CacheSpecsMap.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    cacheSpecsMap.setSpecs(new HashMap<>());

    // Act and Assert
    assertNotEquals(cacheSpecsMap, new CacheSpecsMap());
  }

  /**
   * Test {@link CacheSpecsMap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CacheSpecsMap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecsMap.equals(Object)", "int CacheSpecsMap.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    CacheSpecsMap cacheSpecsMap2 = new CacheSpecsMap();
    cacheSpecsMap2.setSpecs(new HashMap<>());

    // Act and Assert
    assertNotEquals(cacheSpecsMap, cacheSpecsMap2);
  }

  /**
   * Test {@link CacheSpecsMap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CacheSpecsMap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecsMap.equals(Object)", "int CacheSpecsMap.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CacheSpecsMap(), null);
  }

  /**
   * Test {@link CacheSpecsMap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CacheSpecsMap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CacheSpecsMap.equals(Object)", "int CacheSpecsMap.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CacheSpecsMap(), "Different type to CacheSpecsMap");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CacheSpecsMap#setRefreshTokenExpTime(int)}
   *   <li>{@link CacheSpecsMap#setSpecs(Map)}
   *   <li>{@link CacheSpecsMap#toString()}
   *   <li>{@link CacheSpecsMap#getRefreshTokenExpTime()}
   *   <li>{@link CacheSpecsMap#getSpecs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int CacheSpecsMap.getRefreshTokenExpTime()",
    "Map CacheSpecsMap.getSpecs()",
    "void CacheSpecsMap.setRefreshTokenExpTime(int)",
    "void CacheSpecsMap.setSpecs(Map)",
    "String CacheSpecsMap.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    // Act
    cacheSpecsMap.setRefreshTokenExpTime(1);
    HashMap<String, CacheSpecs> specs = new HashMap<>();
    cacheSpecsMap.setSpecs(specs);
    String actualToStringResult = cacheSpecsMap.toString();
    int actualRefreshTokenExpTime = cacheSpecsMap.getRefreshTokenExpTime();
    Map<String, CacheSpecs> actualSpecs = cacheSpecsMap.getSpecs();

    // Assert
    assertEquals("CacheSpecsMap(refreshTokenExpTime=1, specs={})", actualToStringResult);
    assertEquals(1, actualRefreshTokenExpTime);
    assertTrue(actualSpecs.isEmpty());
    assertSame(specs, actualSpecs);
  }
}
