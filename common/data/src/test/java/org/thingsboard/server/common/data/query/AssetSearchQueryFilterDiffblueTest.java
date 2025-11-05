package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class AssetSearchQueryFilterDiffblueTest {
  /**
   * Test {@link AssetSearchQueryFilter#equals(Object)}, and {@link
   * AssetSearchQueryFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetSearchQueryFilter#equals(Object)}
   *   <li>{@link AssetSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetSearchQueryFilter.equals(Object)",
    "int AssetSearchQueryFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setAssetTypes(new ArrayList<>());
    assetSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    assetSearchQueryFilter.setFetchLastLevelOnly(true);
    assetSearchQueryFilter.setMaxLevel(3);
    assetSearchQueryFilter.setRelationType("Relation Type");
    assetSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    AssetSearchQueryFilter assetSearchQueryFilter2 = new AssetSearchQueryFilter();
    assetSearchQueryFilter2.setAssetTypes(new ArrayList<>());
    assetSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    assetSearchQueryFilter2.setFetchLastLevelOnly(true);
    assetSearchQueryFilter2.setMaxLevel(3);
    assetSearchQueryFilter2.setRelationType("Relation Type");
    assetSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
    assertEquals(assetSearchQueryFilter.hashCode(), assetSearchQueryFilter2.hashCode());
  }

  /**
   * Test {@link AssetSearchQueryFilter#equals(Object)}, and {@link
   * AssetSearchQueryFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetSearchQueryFilter#equals(Object)}
   *   <li>{@link AssetSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetSearchQueryFilter.equals(Object)",
    "int AssetSearchQueryFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setAssetTypes(new ArrayList<>());
    assetSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    assetSearchQueryFilter.setFetchLastLevelOnly(true);
    assetSearchQueryFilter.setMaxLevel(3);
    assetSearchQueryFilter.setRelationType("Relation Type");
    assetSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(assetSearchQueryFilter, assetSearchQueryFilter);
    int expectedHashCodeResult = assetSearchQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, assetSearchQueryFilter.hashCode());
  }

  /**
   * Test {@link AssetSearchQueryFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetSearchQueryFilter.equals(Object)",
    "int AssetSearchQueryFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Relation Type");

    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setAssetTypes(assetTypes);
    assetSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    assetSearchQueryFilter.setFetchLastLevelOnly(true);
    assetSearchQueryFilter.setMaxLevel(3);
    assetSearchQueryFilter.setRelationType("Relation Type");
    assetSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    AssetSearchQueryFilter assetSearchQueryFilter2 = new AssetSearchQueryFilter();
    assetSearchQueryFilter2.setAssetTypes(new ArrayList<>());
    assetSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    assetSearchQueryFilter2.setFetchLastLevelOnly(true);
    assetSearchQueryFilter2.setMaxLevel(3);
    assetSearchQueryFilter2.setRelationType("Relation Type");
    assetSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Test {@link AssetSearchQueryFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetSearchQueryFilter.equals(Object)",
    "int AssetSearchQueryFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setAssetTypes(new ArrayList<>());
    assetSearchQueryFilter.setDirection(null);
    assetSearchQueryFilter.setFetchLastLevelOnly(true);
    assetSearchQueryFilter.setMaxLevel(3);
    assetSearchQueryFilter.setRelationType("Relation Type");
    assetSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    AssetSearchQueryFilter assetSearchQueryFilter2 = new AssetSearchQueryFilter();
    assetSearchQueryFilter2.setAssetTypes(new ArrayList<>());
    assetSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    assetSearchQueryFilter2.setFetchLastLevelOnly(true);
    assetSearchQueryFilter2.setMaxLevel(3);
    assetSearchQueryFilter2.setRelationType("Relation Type");
    assetSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, assetSearchQueryFilter2);
  }

  /**
   * Test {@link AssetSearchQueryFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetSearchQueryFilter.equals(Object)",
    "int AssetSearchQueryFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setAssetTypes(new ArrayList<>());
    assetSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    assetSearchQueryFilter.setFetchLastLevelOnly(true);
    assetSearchQueryFilter.setMaxLevel(3);
    assetSearchQueryFilter.setRelationType("Relation Type");
    assetSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, null);
  }

  /**
   * Test {@link AssetSearchQueryFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetSearchQueryFilter.equals(Object)",
    "int AssetSearchQueryFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AssetSearchQueryFilter assetSearchQueryFilter = new AssetSearchQueryFilter();
    assetSearchQueryFilter.setAssetTypes(new ArrayList<>());
    assetSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    assetSearchQueryFilter.setFetchLastLevelOnly(true);
    assetSearchQueryFilter.setMaxLevel(3);
    assetSearchQueryFilter.setRelationType("Relation Type");
    assetSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(assetSearchQueryFilter, "Different type to AssetSearchQueryFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AssetSearchQueryFilter}
   *   <li>{@link AssetSearchQueryFilter#setAssetTypes(List)}
   *   <li>{@link AssetSearchQueryFilter#toString()}
   *   <li>{@link AssetSearchQueryFilter#getAssetTypes()}
   *   <li>{@link AssetSearchQueryFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssetSearchQueryFilter.<init>()",
    "List AssetSearchQueryFilter.getAssetTypes()",
    "EntityFilterType AssetSearchQueryFilter.getType()",
    "void AssetSearchQueryFilter.setAssetTypes(List)",
    "String AssetSearchQueryFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AssetSearchQueryFilter actualAssetSearchQueryFilter = new AssetSearchQueryFilter();
    ArrayList<String> assetTypes = new ArrayList<>();
    actualAssetSearchQueryFilter.setAssetTypes(assetTypes);
    String actualToStringResult = actualAssetSearchQueryFilter.toString();
    List<String> actualAssetTypes = actualAssetSearchQueryFilter.getAssetTypes();
    EntityFilterType actualType = actualAssetSearchQueryFilter.getType();

    // Assert
    assertEquals(
        "AssetSearchQueryFilter(super=EntitySearchQueryFilter(rootEntity=null, relationType=null, direction=null,"
            + " maxLevel=0, fetchLastLevelOnly=false), assetTypes=[])",
        actualToStringResult);
    assertNull(actualAssetSearchQueryFilter.getRelationType());
    assertNull(actualAssetSearchQueryFilter.getRootEntity());
    assertNull(actualAssetSearchQueryFilter.getDirection());
    assertEquals(0, actualAssetSearchQueryFilter.getMaxLevel());
    assertEquals(EntityFilterType.ASSET_SEARCH_QUERY, actualType);
    assertFalse(actualAssetSearchQueryFilter.isFetchLastLevelOnly());
    assertTrue(actualAssetTypes.isEmpty());
    assertSame(assetTypes, actualAssetTypes);
  }
}
