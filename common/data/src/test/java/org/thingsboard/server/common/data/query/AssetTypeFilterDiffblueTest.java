package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssetTypeFilterDiffblueTest {
  /**
   * Test {@link AssetTypeFilter#getAssetTypes()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return first is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AssetTypeFilter#getAssetTypes()}
   */
  @Test
  @DisplayName("Test getAssetTypes(); given ArrayList() add 'foo'; then return first is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssetTypeFilter.getAssetTypes()"})
  void testGetAssetTypes_givenArrayListAddFoo_thenReturnFirstIsFoo() {
    // Arrange
    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("foo");

    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetTypes(assetTypes);

    // Act
    List<String> actualAssetTypes = assetTypeFilter.getAssetTypes();

    // Assert
    assertEquals(1, actualAssetTypes.size());
    assertEquals("foo", actualAssetTypes.get(0));
    assertSame(assetTypes, actualAssetTypes);
  }

  /**
   * Test {@link AssetTypeFilter#getAssetTypes()}.
   *
   * <ul>
   *   <li>Given {@link AssetTypeFilter} (default constructor).
   *   <li>Then return first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetTypeFilter#getAssetTypes()}
   */
  @Test
  @DisplayName(
      "Test getAssetTypes(); given AssetTypeFilter (default constructor); then return first is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssetTypeFilter.getAssetTypes()"})
  void testGetAssetTypes_givenAssetTypeFilter_thenReturnFirstIsNull() {
    // Arrange and Act
    List<String> actualAssetTypes = new AssetTypeFilter().getAssetTypes();

    // Assert
    assertEquals(1, actualAssetTypes.size());
    assertNull(actualAssetTypes.get(0));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter2);
    assertEquals(assetTypeFilter.hashCode(), assetTypeFilter2.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Asset Type");

    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(assetTypes);

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter2);
    assertEquals(assetTypeFilter.hashCode(), assetTypeFilter2.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter(null);
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter(null);
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter2);
    assertEquals(assetTypeFilter.hashCode(), assetTypeFilter2.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType(null);
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType(null);
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(assetTypeFilter, assetTypeFilter2);
    assertEquals(assetTypeFilter.hashCode(), assetTypeFilter2.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Type");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter(null);
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Name Filter");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType(null);
    assetTypeFilter.setAssetTypes(new ArrayList<>());

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Asset Name Filter");
    assetTypes.add("Asset Type");

    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(assetTypes);

    AssetTypeFilter assetTypeFilter2 = new AssetTypeFilter();
    assetTypeFilter2.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter2.setAssetType("Asset Type");
    assetTypeFilter2.setAssetTypes(new ArrayList<>());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetTypeFilter.equals(Object)", "int AssetTypeFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AssetTypeFilter assetTypeFilter = new AssetTypeFilter();
    assetTypeFilter.setAssetNameFilter("Asset Name Filter");
    assetTypeFilter.setAssetType("Asset Type");
    assetTypeFilter.setAssetTypes(new ArrayList<>());

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
   *   <li>{@link AssetTypeFilter#setAssetNameFilter(String)}
   *   <li>{@link AssetTypeFilter#setAssetType(String)}
   *   <li>{@link AssetTypeFilter#setAssetTypes(List)}
   *   <li>{@link AssetTypeFilter#toString()}
   *   <li>{@link AssetTypeFilter#getAssetNameFilter()}
   *   <li>{@link AssetTypeFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssetTypeFilter.<init>()",
    "String AssetTypeFilter.getAssetNameFilter()",
    "EntityFilterType AssetTypeFilter.getType()",
    "void AssetTypeFilter.setAssetNameFilter(String)",
    "void AssetTypeFilter.setAssetType(String)",
    "void AssetTypeFilter.setAssetTypes(List)",
    "String AssetTypeFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AssetTypeFilter actualAssetTypeFilter = new AssetTypeFilter();
    actualAssetTypeFilter.setAssetNameFilter("Asset Name Filter");
    actualAssetTypeFilter.setAssetType("Asset Type");
    actualAssetTypeFilter.setAssetTypes(new ArrayList<>());
    String actualToStringResult = actualAssetTypeFilter.toString();
    String actualAssetNameFilter = actualAssetTypeFilter.getAssetNameFilter();

    // Assert
    assertEquals("Asset Name Filter", actualAssetNameFilter);
    assertEquals(
        "AssetTypeFilter(assetType=Asset Type, assetTypes=[Asset Type], assetNameFilter=Asset Name Filter)",
        actualToStringResult);
    assertEquals(EntityFilterType.ASSET_TYPE, actualAssetTypeFilter.getType());
  }
}
