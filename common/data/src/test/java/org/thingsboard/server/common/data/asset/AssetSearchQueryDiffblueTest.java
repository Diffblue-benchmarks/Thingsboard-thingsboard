package org.thingsboard.server.common.data.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationEntityTypeFilter;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;

class AssetSearchQueryDiffblueTest {
  /**
   * Test {@link AssetSearchQuery#toEntitySearchQuery()}.
   *
   * <ul>
   *   <li>Then return Filters first RelationType is {@code Contains}.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQuery#toEntitySearchQuery()}
   */
  @Test
  @DisplayName("Test toEntitySearchQuery(); then return Filters first RelationType is 'Contains'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityRelationsQuery AssetSearchQuery.toEntitySearchQuery()"})
  void testToEntitySearchQuery_thenReturnFiltersFirstRelationTypeIsContains() {
    // Arrange and Act
    EntityRelationsQuery actualToEntitySearchQueryResult =
        new AssetSearchQuery().toEntitySearchQuery();

    // Assert
    List<RelationEntityTypeFilter> filters = actualToEntitySearchQueryResult.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("Contains", getResult.getRelationType());
    assertNull(actualToEntitySearchQueryResult.getParameters());
    List<EntityType> entityTypes = getResult.getEntityTypes();
    assertEquals(1, entityTypes.size());
    assertEquals(EntityType.ASSET, entityTypes.get(0));
    assertFalse(getResult.isNegate());
  }

  /**
   * Test {@link AssetSearchQuery#toEntitySearchQuery()}.
   *
   * <ul>
   *   <li>Then return Filters first RelationType is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQuery#toEntitySearchQuery()}
   */
  @Test
  @DisplayName("Test toEntitySearchQuery(); then return Filters first RelationType is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityRelationsQuery AssetSearchQuery.toEntitySearchQuery()"})
  void testToEntitySearchQuery_thenReturnFiltersFirstRelationTypeIsFoo() {
    // Arrange
    AssetSearchQuery assetSearchQuery = new AssetSearchQuery();
    assetSearchQuery.setRelationType("foo");

    // Act
    EntityRelationsQuery actualToEntitySearchQueryResult = assetSearchQuery.toEntitySearchQuery();

    // Assert
    List<RelationEntityTypeFilter> filters = actualToEntitySearchQueryResult.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("foo", getResult.getRelationType());
    assertNull(actualToEntitySearchQueryResult.getParameters());
    List<EntityType> entityTypes = getResult.getEntityTypes();
    assertEquals(1, entityTypes.size());
    assertEquals(EntityType.ASSET, entityTypes.get(0));
    assertFalse(getResult.isNegate());
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}, and {@link AssetSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetSearchQuery#equals(Object)}
   *   <li>{@link AssetSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetSearchQuery assetSearchQuery = new AssetSearchQuery();
    AssetSearchQuery assetSearchQuery2 = new AssetSearchQuery();

    // Act and Assert
    assertEquals(assetSearchQuery, assetSearchQuery2);
    int expectedHashCodeResult = assetSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, assetSearchQuery2.hashCode());
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}, and {@link AssetSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetSearchQuery#equals(Object)}
   *   <li>{@link AssetSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetSearchQuery assetSearchQuery = new AssetSearchQuery();
    assetSearchQuery.setParameters(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    AssetSearchQuery assetSearchQuery2 = new AssetSearchQuery();
    assetSearchQuery2.setParameters(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertEquals(assetSearchQuery, assetSearchQuery2);
    int expectedHashCodeResult = assetSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, assetSearchQuery2.hashCode());
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}, and {@link AssetSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetSearchQuery#equals(Object)}
   *   <li>{@link AssetSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetSearchQuery assetSearchQuery = new AssetSearchQuery();
    assetSearchQuery.setRelationType("Relation Type");

    AssetSearchQuery assetSearchQuery2 = new AssetSearchQuery();
    assetSearchQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertEquals(assetSearchQuery, assetSearchQuery2);
    int expectedHashCodeResult = assetSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, assetSearchQuery2.hashCode());
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}, and {@link AssetSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetSearchQuery#equals(Object)}
   *   <li>{@link AssetSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AssetSearchQuery assetSearchQuery = new AssetSearchQuery();
    assetSearchQuery.setAssetTypes(new ArrayList<>());

    AssetSearchQuery assetSearchQuery2 = new AssetSearchQuery();
    assetSearchQuery2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(assetSearchQuery, assetSearchQuery2);
    int expectedHashCodeResult = assetSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, assetSearchQuery2.hashCode());
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}, and {@link AssetSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetSearchQuery#equals(Object)}
   *   <li>{@link AssetSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetSearchQuery assetSearchQuery = new AssetSearchQuery();

    // Act and Assert
    assertEquals(assetSearchQuery, assetSearchQuery);
    int expectedHashCodeResult = assetSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, assetSearchQuery.hashCode());
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetSearchQuery(), 1);
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetSearchQuery assetSearchQuery = new AssetSearchQuery();
    assetSearchQuery.setParameters(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(assetSearchQuery, new AssetSearchQuery());
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetSearchQuery assetSearchQuery = new AssetSearchQuery();
    assetSearchQuery.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(assetSearchQuery, new AssetSearchQuery());
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetSearchQuery assetSearchQuery = new AssetSearchQuery();
    assetSearchQuery.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(assetSearchQuery, new AssetSearchQuery());
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetSearchQuery assetSearchQuery = new AssetSearchQuery();

    AssetSearchQuery assetSearchQuery2 = new AssetSearchQuery();
    assetSearchQuery2.setParameters(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(assetSearchQuery, assetSearchQuery2);
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetSearchQuery assetSearchQuery = new AssetSearchQuery();

    AssetSearchQuery assetSearchQuery2 = new AssetSearchQuery();
    assetSearchQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(assetSearchQuery, assetSearchQuery2);
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetSearchQuery assetSearchQuery = new AssetSearchQuery();

    AssetSearchQuery assetSearchQuery2 = new AssetSearchQuery();
    assetSearchQuery2.setAssetTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(assetSearchQuery, assetSearchQuery2);
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetSearchQuery(), null);
  }

  /**
   * Test {@link AssetSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetSearchQuery.equals(Object)", "int AssetSearchQuery.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetSearchQuery(), "Different type to AssetSearchQuery");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AssetSearchQuery}
   *   <li>{@link AssetSearchQuery#setAssetTypes(List)}
   *   <li>{@link AssetSearchQuery#setParameters(RelationsSearchParameters)}
   *   <li>{@link AssetSearchQuery#setRelationType(String)}
   *   <li>{@link AssetSearchQuery#toString()}
   *   <li>{@link AssetSearchQuery#getAssetTypes()}
   *   <li>{@link AssetSearchQuery#getParameters()}
   *   <li>{@link AssetSearchQuery#getRelationType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AssetSearchQuery.<init>()",
    "List AssetSearchQuery.getAssetTypes()",
    "RelationsSearchParameters AssetSearchQuery.getParameters()",
    "String AssetSearchQuery.getRelationType()",
    "void AssetSearchQuery.setAssetTypes(List)",
    "void AssetSearchQuery.setParameters(RelationsSearchParameters)",
    "void AssetSearchQuery.setRelationType(String)",
    "String AssetSearchQuery.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AssetSearchQuery actualAssetSearchQuery = new AssetSearchQuery();
    ArrayList<String> assetTypes = new ArrayList<>();
    actualAssetSearchQuery.setAssetTypes(assetTypes);
    RelationsSearchParameters parameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);

    actualAssetSearchQuery.setParameters(parameters);
    actualAssetSearchQuery.setRelationType("Relation Type");
    String actualToStringResult = actualAssetSearchQuery.toString();
    List<String> actualAssetTypes = actualAssetSearchQuery.getAssetTypes();
    RelationsSearchParameters actualParameters = actualAssetSearchQuery.getParameters();

    // Assert
    assertEquals(
        "AssetSearchQuery(parameters=RelationsSearchParameters(rootId=13814000-1dd2-11b2-8080-808080808080,"
            + " rootType=TENANT, direction=FROM, relationTypeGroup=COMMON, maxLevel=3, fetchLastLevelOnly=true),"
            + " relationType=Relation Type, assetTypes=[])",
        actualToStringResult);
    assertEquals("Relation Type", actualAssetSearchQuery.getRelationType());
    assertTrue(actualAssetTypes.isEmpty());
    assertSame(assetTypes, actualAssetTypes);
    assertSame(parameters, actualParameters);
  }
}
