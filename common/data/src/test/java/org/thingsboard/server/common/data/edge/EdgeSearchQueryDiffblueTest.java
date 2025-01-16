package org.thingsboard.server.common.data.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationEntityTypeFilter;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;

class EdgeSearchQueryDiffblueTest {
  /**
   * Test {@link EdgeSearchQuery#toEntitySearchQuery()}.
   * <ul>
   *   <li>Then return Filters first RelationType is {@code Contains}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQuery#toEntitySearchQuery()}
   */
  @Test
  @DisplayName("Test toEntitySearchQuery(); then return Filters first RelationType is 'Contains'")
  void testToEntitySearchQuery_thenReturnFiltersFirstRelationTypeIsContains() {
    // Arrange and Act
    EntityRelationsQuery actualToEntitySearchQueryResult = (new EdgeSearchQuery()).toEntitySearchQuery();

    // Assert
    List<RelationEntityTypeFilter> filters = actualToEntitySearchQueryResult.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("Contains", getResult.getRelationType());
    assertNull(actualToEntitySearchQueryResult.getParameters());
    List<EntityType> entityTypes = getResult.getEntityTypes();
    assertEquals(1, entityTypes.size());
    assertEquals(EntityType.EDGE, entityTypes.get(0));
    assertFalse(getResult.isNegate());
  }

  /**
   * Test {@link EdgeSearchQuery#toEntitySearchQuery()}.
   * <ul>
   *   <li>Then return Filters first RelationType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQuery#toEntitySearchQuery()}
   */
  @Test
  @DisplayName("Test toEntitySearchQuery(); then return Filters first RelationType is 'foo'")
  void testToEntitySearchQuery_thenReturnFiltersFirstRelationTypeIsFoo() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setRelationType("foo");

    // Act
    EntityRelationsQuery actualToEntitySearchQueryResult = edgeSearchQuery.toEntitySearchQuery();

    // Assert
    List<RelationEntityTypeFilter> filters = actualToEntitySearchQueryResult.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("foo", getResult.getRelationType());
    assertNull(actualToEntitySearchQueryResult.getParameters());
    List<EntityType> entityTypes = getResult.getEntityTypes();
    assertEquals(1, entityTypes.size());
    assertEquals(EntityType.EDGE, entityTypes.get(0));
    assertFalse(getResult.isNegate());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}, and
   * {@link EdgeSearchQuery#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeSearchQuery#equals(Object)}
   *   <li>{@link EdgeSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();

    // Act and Assert
    assertEquals(edgeSearchQuery, edgeSearchQuery2);
    int expectedHashCodeResult = edgeSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, edgeSearchQuery2.hashCode());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}, and
   * {@link EdgeSearchQuery#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeSearchQuery#equals(Object)}
   *   <li>{@link EdgeSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();

    // Act and Assert
    assertEquals(edgeSearchQuery, edgeSearchQuery);
    int expectedHashCodeResult = edgeSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, edgeSearchQuery.hashCode());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSearchQuery(), 1);
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(edgeSearchQuery, new EdgeSearchQuery());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(edgeSearchQuery, new EdgeSearchQuery());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(edgeSearchQuery, new EdgeSearchQuery());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();

    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();
    edgeSearchQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(edgeSearchQuery, edgeSearchQuery2);
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();

    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();
    edgeSearchQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(edgeSearchQuery, edgeSearchQuery2);
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();

    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();
    edgeSearchQuery2.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(edgeSearchQuery, edgeSearchQuery2);
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters parameters = new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true);

    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setParameters(parameters);

    // Act and Assert
    assertNotEquals(edgeSearchQuery, new EdgeSearchQuery());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSearchQuery(), null);
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSearchQuery(), "Different type to EdgeSearchQuery");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EdgeSearchQuery}
   *   <li>{@link EdgeSearchQuery#setEdgeTypes(List)}
   *   <li>{@link EdgeSearchQuery#setParameters(RelationsSearchParameters)}
   *   <li>{@link EdgeSearchQuery#setRelationType(String)}
   *   <li>{@link EdgeSearchQuery#toString()}
   *   <li>{@link EdgeSearchQuery#getEdgeTypes()}
   *   <li>{@link EdgeSearchQuery#getParameters()}
   *   <li>{@link EdgeSearchQuery#getRelationType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeSearchQuery actualEdgeSearchQuery = new EdgeSearchQuery();
    ArrayList<String> edgeTypes = new ArrayList<>();
    actualEdgeSearchQuery.setEdgeTypes(edgeTypes);
    RelationsSearchParameters parameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);

    actualEdgeSearchQuery.setParameters(parameters);
    actualEdgeSearchQuery.setRelationType("Relation Type");
    String actualToStringResult = actualEdgeSearchQuery.toString();
    List<String> actualEdgeTypes = actualEdgeSearchQuery.getEdgeTypes();
    RelationsSearchParameters actualParameters = actualEdgeSearchQuery.getParameters();

    // Assert that nothing has changed
    assertEquals("EdgeSearchQuery(parameters=RelationsSearchParameters(rootId=13814000-1dd2-11b2-8080-808080808080,"
        + " rootType=TENANT, direction=FROM, relationTypeGroup=COMMON, maxLevel=3, fetchLastLevelOnly=true),"
        + " relationType=Relation Type, edgeTypes=[])", actualToStringResult);
    assertEquals("Relation Type", actualEdgeSearchQuery.getRelationType());
    assertTrue(actualEdgeTypes.isEmpty());
    assertSame(edgeTypes, actualEdgeTypes);
    assertSame(parameters, actualParameters);
  }
}
