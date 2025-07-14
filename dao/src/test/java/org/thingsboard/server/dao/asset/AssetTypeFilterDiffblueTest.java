package org.thingsboard.server.dao.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssetTypeFilterDiffblueTest {
  /**
   * Test {@link AssetTypeFilter#equals(Object)}, and {@link AssetTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetTypeFilter#equals(Object)}
   *   <li>{@link AssetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType("Relation Type");

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetTypes(new ArrayList<>());
    assetTypeFilter2.setRelationType("Relation Type");

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter2);
    int expectedHashCodeResult = assetTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, assetTypeFilter2.hashCode());
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}, and {@link AssetTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetTypeFilter#equals(Object)}
   *   <li>{@link AssetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType(null);

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetTypes(new ArrayList<>());
    assetTypeFilter2.setRelationType(null);

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter2);
    int expectedHashCodeResult = assetTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, assetTypeFilter2.hashCode());
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}, and {@link AssetTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetTypeFilter#equals(Object)}
   *   <li>{@link AssetTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType("Relation Type");

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter);
    int expectedHashCodeResult = assetTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, assetTypeFilter.hashCode());
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Relation Type");

    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(assetTypes);
    assetTypeFilter.setRelationType("Relation Type");

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetTypes(new ArrayList<>());
    assetTypeFilter2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(assetTypeFilter, assetTypeFilter2);
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType(null);

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetTypes(new ArrayList<>());
    assetTypeFilter2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(assetTypeFilter, assetTypeFilter2);
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType("org.thingsboard.server.dao.asset.AssetTypeFilter");

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetTypes(new ArrayList<>());
    assetTypeFilter2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(assetTypeFilter, assetTypeFilter2);
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(assetTypeFilter, null);
  }

  /**
   * Test {@link AssetTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(new ArrayList<>());
    assetTypeFilter.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(assetTypeFilter, "Different type to AssetTypeFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AssetTypeFilter}
   *   <li>{@link AssetTypeFilter#setAssetTypes(List)}
   *   <li>{@link AssetTypeFilter#setRelationType(String)}
   *   <li>{@link AssetTypeFilter#toString()}
   *   <li>{@link AssetTypeFilter#getAssetTypes()}
   *   <li>{@link AssetTypeFilter#getRelationType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AssetTypeFilter.<init>()",
    "List AssetTypeFilter.getAssetTypes()",
    "String AssetTypeFilter.getRelationType()",
    "void AssetTypeFilter.setAssetTypes(List)",
    "void AssetTypeFilter.setRelationType(String)",
    "String AssetTypeFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AssetTypeFilter actualAssetTypeFilter = new AssetTypeFilter();
    ArrayList<String> assetTypes = new ArrayList<>();
    actualAssetTypeFilter.setAssetTypes(assetTypes);
    actualAssetTypeFilter.setRelationType("Relation Type");
    String actualToStringResult = actualAssetTypeFilter.toString();
    List<String> actualAssetTypes = actualAssetTypeFilter.getAssetTypes();

    // Assert
    assertEquals(
        "AssetTypeFilter(relationType=Relation Type, assetTypes=[])", actualToStringResult);
    assertEquals("Relation Type", actualAssetTypeFilter.getRelationType());
    assertTrue(actualAssetTypes.isEmpty());
    assertSame(assetTypes, actualAssetTypes);
  }
}
