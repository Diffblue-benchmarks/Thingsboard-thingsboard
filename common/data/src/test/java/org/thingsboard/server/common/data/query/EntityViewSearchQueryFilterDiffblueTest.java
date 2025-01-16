package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class EntityViewSearchQueryFilterDiffblueTest {
  /**
   * Test {@link EntityViewSearchQueryFilter#equals(Object)}, and
   * {@link EntityViewSearchQueryFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewSearchQueryFilter#equals(Object)}
   *   <li>{@link EntityViewSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewSearchQueryFilter entityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter.setMaxLevel(3);
    entityViewSearchQueryFilter.setRelationType("Relation Type");
    entityViewSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    EntityViewSearchQueryFilter entityViewSearchQueryFilter2 = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter2.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter2.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter2.setMaxLevel(3);
    entityViewSearchQueryFilter2.setRelationType("Relation Type");
    entityViewSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(entityViewSearchQueryFilter, entityViewSearchQueryFilter2);
    int expectedHashCodeResult = entityViewSearchQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityViewSearchQueryFilter2.hashCode());
  }

  /**
   * Test {@link EntityViewSearchQueryFilter#equals(Object)}, and
   * {@link EntityViewSearchQueryFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewSearchQueryFilter#equals(Object)}
   *   <li>{@link EntityViewSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewSearchQueryFilter entityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter.setMaxLevel(3);
    entityViewSearchQueryFilter.setRelationType("Relation Type");
    entityViewSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(entityViewSearchQueryFilter, entityViewSearchQueryFilter);
    int expectedHashCodeResult = entityViewSearchQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityViewSearchQueryFilter.hashCode());
  }

  /**
   * Test {@link EntityViewSearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewSearchQueryFilter entityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter.setDirection(null);
    entityViewSearchQueryFilter.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter.setMaxLevel(3);
    entityViewSearchQueryFilter.setRelationType("Relation Type");
    entityViewSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    EntityViewSearchQueryFilter entityViewSearchQueryFilter2 = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter2.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter2.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter2.setMaxLevel(3);
    entityViewSearchQueryFilter2.setRelationType("Relation Type");
    entityViewSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityViewSearchQueryFilter, entityViewSearchQueryFilter2);
  }

  /**
   * Test {@link EntityViewSearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Relation Type");

    EntityViewSearchQueryFilter entityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter.setEntityViewTypes(entityViewTypes);
    entityViewSearchQueryFilter.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter.setMaxLevel(3);
    entityViewSearchQueryFilter.setRelationType("Relation Type");
    entityViewSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    EntityViewSearchQueryFilter entityViewSearchQueryFilter2 = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter2.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter2.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter2.setMaxLevel(3);
    entityViewSearchQueryFilter2.setRelationType("Relation Type");
    entityViewSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityViewSearchQueryFilter, entityViewSearchQueryFilter2);
  }

  /**
   * Test {@link EntityViewSearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityViewSearchQueryFilter entityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter.setMaxLevel(3);
    entityViewSearchQueryFilter.setRelationType("Relation Type");
    entityViewSearchQueryFilter.setRootEntity(mock(EntityId.class));

    EntityViewSearchQueryFilter entityViewSearchQueryFilter2 = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter2.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter2.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter2.setMaxLevel(3);
    entityViewSearchQueryFilter2.setRelationType("Relation Type");
    entityViewSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityViewSearchQueryFilter, entityViewSearchQueryFilter2);
  }

  /**
   * Test {@link EntityViewSearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityViewSearchQueryFilter entityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter.setMaxLevel(3);
    entityViewSearchQueryFilter.setRelationType("Relation Type");
    entityViewSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityViewSearchQueryFilter, null);
  }

  /**
   * Test {@link EntityViewSearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityViewSearchQueryFilter entityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    entityViewSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    entityViewSearchQueryFilter.setEntityViewTypes(new ArrayList<>());
    entityViewSearchQueryFilter.setFetchLastLevelOnly(true);
    entityViewSearchQueryFilter.setMaxLevel(3);
    entityViewSearchQueryFilter.setRelationType("Relation Type");
    entityViewSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityViewSearchQueryFilter, "Different type to EntityViewSearchQueryFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link EntityViewSearchQueryFilter}
   *   <li>{@link EntityViewSearchQueryFilter#setEntityViewTypes(List)}
   *   <li>{@link EntityViewSearchQueryFilter#toString()}
   *   <li>{@link EntityViewSearchQueryFilter#getEntityViewTypes()}
   *   <li>{@link EntityViewSearchQueryFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    EntityViewSearchQueryFilter actualEntityViewSearchQueryFilter = new EntityViewSearchQueryFilter();
    ArrayList<String> entityViewTypes = new ArrayList<>();
    actualEntityViewSearchQueryFilter.setEntityViewTypes(entityViewTypes);
    String actualToStringResult = actualEntityViewSearchQueryFilter.toString();
    List<String> actualEntityViewTypes = actualEntityViewSearchQueryFilter.getEntityViewTypes();
    EntityFilterType actualType = actualEntityViewSearchQueryFilter.getType();

    // Assert that nothing has changed
    assertEquals("EntityViewSearchQueryFilter(super=EntitySearchQueryFilter(rootEntity=null, relationType=null,"
        + " direction=null, maxLevel=0, fetchLastLevelOnly=false), entityViewTypes=[])", actualToStringResult);
    assertEquals(0, actualEntityViewSearchQueryFilter.getMaxLevel());
    assertEquals(EntityFilterType.ENTITY_VIEW_SEARCH_QUERY, actualType);
    assertFalse(actualEntityViewSearchQueryFilter.isFetchLastLevelOnly());
    assertTrue(actualEntityViewTypes.isEmpty());
    assertSame(entityViewTypes, actualEntityViewTypes);
  }
}
