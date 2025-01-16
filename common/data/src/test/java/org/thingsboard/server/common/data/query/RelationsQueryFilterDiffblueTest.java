package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationEntityTypeFilter;

class RelationsQueryFilterDiffblueTest {
  /**
   * Test {@link RelationsQueryFilter#equals(Object)}, and
   * {@link RelationsQueryFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationsQueryFilter#equals(Object)}
   *   <li>{@link RelationsQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(relationsQueryFilter, relationsQueryFilter2);
    int expectedHashCodeResult = relationsQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, relationsQueryFilter2.hashCode());
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}, and
   * {@link RelationsQueryFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationsQueryFilter#equals(Object)}
   *   <li>{@link RelationsQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(null);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(null);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(relationsQueryFilter, relationsQueryFilter2);
    int expectedHashCodeResult = relationsQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, relationsQueryFilter2.hashCode());
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}, and
   * {@link RelationsQueryFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationsQueryFilter#equals(Object)}
   *   <li>{@link RelationsQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(relationsQueryFilter, relationsQueryFilter);
    int expectedHashCodeResult = relationsQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, relationsQueryFilter.hashCode());
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(null);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, relationsQueryFilter2);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.TO);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, relationsQueryFilter2);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(false);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, relationsQueryFilter2);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<RelationEntityTypeFilter> filters = new ArrayList<>();
    filters.add(new RelationEntityTypeFilter());

    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(filters);
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, relationsQueryFilter2);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(1);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, relationsQueryFilter2);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(false);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, relationsQueryFilter2);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(null);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, relationsQueryFilter2);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.CUSTOMER);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, relationsQueryFilter2);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    HashSet<String> multiRootEntityIds = new HashSet<>();
    multiRootEntityIds.add("foo");

    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(multiRootEntityIds);
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, relationsQueryFilter2);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(false);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, relationsQueryFilter2);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(null);

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, relationsQueryFilter2);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, relationsQueryFilter2);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(mock(EntityId.class));

    RelationsQueryFilter relationsQueryFilter2 = new RelationsQueryFilter();
    relationsQueryFilter2.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter2.setFetchLastLevelOnly(true);
    relationsQueryFilter2.setFilters(new ArrayList<>());
    relationsQueryFilter2.setMaxLevel(3);
    relationsQueryFilter2.setMultiRoot(true);
    relationsQueryFilter2.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter2.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter2.setNegate(true);
    relationsQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, relationsQueryFilter2);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, null);
  }

  /**
   * Test {@link RelationsQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RelationsQueryFilter relationsQueryFilter = new RelationsQueryFilter();
    relationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    relationsQueryFilter.setFetchLastLevelOnly(true);
    relationsQueryFilter.setFilters(new ArrayList<>());
    relationsQueryFilter.setMaxLevel(3);
    relationsQueryFilter.setMultiRoot(true);
    relationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    relationsQueryFilter.setMultiRootEntityIds(new HashSet<>());
    relationsQueryFilter.setNegate(true);
    relationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(relationsQueryFilter, "Different type to RelationsQueryFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RelationsQueryFilter}
   *   <li>{@link RelationsQueryFilter#setDirection(EntitySearchDirection)}
   *   <li>{@link RelationsQueryFilter#setFetchLastLevelOnly(boolean)}
   *   <li>{@link RelationsQueryFilter#setFilters(List)}
   *   <li>{@link RelationsQueryFilter#setMaxLevel(int)}
   *   <li>{@link RelationsQueryFilter#setMultiRoot(boolean)}
   *   <li>{@link RelationsQueryFilter#setMultiRootEntitiesType(EntityType)}
   *   <li>{@link RelationsQueryFilter#setMultiRootEntityIds(Set)}
   *   <li>{@link RelationsQueryFilter#setNegate(boolean)}
   *   <li>{@link RelationsQueryFilter#setRootEntity(EntityId)}
   *   <li>{@link RelationsQueryFilter#toString()}
   *   <li>{@link RelationsQueryFilter#getDirection()}
   *   <li>{@link RelationsQueryFilter#getFilters()}
   *   <li>{@link RelationsQueryFilter#getMaxLevel()}
   *   <li>{@link RelationsQueryFilter#getMultiRootEntitiesType()}
   *   <li>{@link RelationsQueryFilter#getMultiRootEntityIds()}
   *   <li>{@link RelationsQueryFilter#getRootEntity()}
   *   <li>{@link RelationsQueryFilter#getType()}
   *   <li>{@link RelationsQueryFilter#isFetchLastLevelOnly()}
   *   <li>{@link RelationsQueryFilter#isMultiRoot()}
   *   <li>{@link RelationsQueryFilter#isNegate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    RelationsQueryFilter actualRelationsQueryFilter = new RelationsQueryFilter();
    actualRelationsQueryFilter.setDirection(EntitySearchDirection.FROM);
    actualRelationsQueryFilter.setFetchLastLevelOnly(true);
    ArrayList<RelationEntityTypeFilter> filters = new ArrayList<>();
    actualRelationsQueryFilter.setFilters(filters);
    actualRelationsQueryFilter.setMaxLevel(3);
    actualRelationsQueryFilter.setMultiRoot(true);
    actualRelationsQueryFilter.setMultiRootEntitiesType(EntityType.TENANT);
    HashSet<String> multiRootEntityIds = new HashSet<>();
    actualRelationsQueryFilter.setMultiRootEntityIds(multiRootEntityIds);
    actualRelationsQueryFilter.setNegate(true);
    actualRelationsQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualRelationsQueryFilter.toString();
    EntitySearchDirection actualDirection = actualRelationsQueryFilter.getDirection();
    List<RelationEntityTypeFilter> actualFilters = actualRelationsQueryFilter.getFilters();
    int actualMaxLevel = actualRelationsQueryFilter.getMaxLevel();
    EntityType actualMultiRootEntitiesType = actualRelationsQueryFilter.getMultiRootEntitiesType();
    Set<String> actualMultiRootEntityIds = actualRelationsQueryFilter.getMultiRootEntityIds();
    EntityId actualRootEntity = actualRelationsQueryFilter.getRootEntity();
    EntityFilterType actualType = actualRelationsQueryFilter.getType();
    boolean actualIsFetchLastLevelOnlyResult = actualRelationsQueryFilter.isFetchLastLevelOnly();
    boolean actualIsMultiRootResult = actualRelationsQueryFilter.isMultiRoot();
    boolean actualIsNegateResult = actualRelationsQueryFilter.isNegate();

    // Assert that nothing has changed
    assertEquals(
        "RelationsQueryFilter(rootEntity=13814000-1dd2-11b2-8080-808080808080, isMultiRoot=true, multiRootEntitiesType"
            + "=TENANT, multiRootEntityIds=[], direction=FROM, filters=[], maxLevel=3, fetchLastLevelOnly=true,"
            + " negate=true)",
        actualToStringResult);
    assertEquals(3, actualMaxLevel);
    assertEquals(EntityType.TENANT, actualMultiRootEntitiesType);
    assertEquals(EntityFilterType.RELATIONS_QUERY, actualType);
    assertEquals(EntitySearchDirection.FROM, actualDirection);
    assertTrue(actualFilters.isEmpty());
    assertTrue(actualMultiRootEntityIds.isEmpty());
    assertTrue(actualIsFetchLastLevelOnlyResult);
    assertTrue(actualIsMultiRootResult);
    assertTrue(actualIsNegateResult);
    assertSame(filters, actualFilters);
    assertSame(multiRootEntityIds, actualMultiRootEntityIds);
    assertSame(((TenantId) actualRootEntity).SYS_TENANT_ID, actualRootEntity);
  }
}
