package org.thingsboard.server.common.data.device;

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

class DeviceSearchQueryDiffblueTest {
  /**
   * Test {@link DeviceSearchQuery#toEntitySearchQuery()}.
   * <ul>
   *   <li>Then return Filters first RelationType is {@code Contains}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSearchQuery#toEntitySearchQuery()}
   */
  @Test
  @DisplayName("Test toEntitySearchQuery(); then return Filters first RelationType is 'Contains'")
  void testToEntitySearchQuery_thenReturnFiltersFirstRelationTypeIsContains() {
    // Arrange and Act
    EntityRelationsQuery actualToEntitySearchQueryResult = (new DeviceSearchQuery()).toEntitySearchQuery();

    // Assert
    List<RelationEntityTypeFilter> filters = actualToEntitySearchQueryResult.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("Contains", getResult.getRelationType());
    assertNull(actualToEntitySearchQueryResult.getParameters());
    List<EntityType> entityTypes = getResult.getEntityTypes();
    assertEquals(1, entityTypes.size());
    assertEquals(EntityType.DEVICE, entityTypes.get(0));
    assertFalse(getResult.isNegate());
  }

  /**
   * Test {@link DeviceSearchQuery#toEntitySearchQuery()}.
   * <ul>
   *   <li>Then return Filters first RelationType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSearchQuery#toEntitySearchQuery()}
   */
  @Test
  @DisplayName("Test toEntitySearchQuery(); then return Filters first RelationType is 'foo'")
  void testToEntitySearchQuery_thenReturnFiltersFirstRelationTypeIsFoo() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    deviceSearchQuery.setRelationType("foo");

    // Act
    EntityRelationsQuery actualToEntitySearchQueryResult = deviceSearchQuery.toEntitySearchQuery();

    // Assert
    List<RelationEntityTypeFilter> filters = actualToEntitySearchQueryResult.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("foo", getResult.getRelationType());
    assertNull(actualToEntitySearchQueryResult.getParameters());
    List<EntityType> entityTypes = getResult.getEntityTypes();
    assertEquals(1, entityTypes.size());
    assertEquals(EntityType.DEVICE, entityTypes.get(0));
    assertFalse(getResult.isNegate());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}, and
   * {@link DeviceSearchQuery#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceSearchQuery#equals(Object)}
   *   <li>{@link DeviceSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    DeviceSearchQuery deviceSearchQuery2 = new DeviceSearchQuery();

    // Act and Assert
    assertEquals(deviceSearchQuery, deviceSearchQuery2);
    int expectedHashCodeResult = deviceSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, deviceSearchQuery2.hashCode());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}, and
   * {@link DeviceSearchQuery#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceSearchQuery#equals(Object)}
   *   <li>{@link DeviceSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();

    // Act and Assert
    assertEquals(deviceSearchQuery, deviceSearchQuery);
    int expectedHashCodeResult = deviceSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, deviceSearchQuery.hashCode());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceSearchQuery(), 1);
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    deviceSearchQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(deviceSearchQuery, new DeviceSearchQuery());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    deviceSearchQuery.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(deviceSearchQuery, new DeviceSearchQuery());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    deviceSearchQuery.setDeviceTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(deviceSearchQuery, new DeviceSearchQuery());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();

    DeviceSearchQuery deviceSearchQuery2 = new DeviceSearchQuery();
    deviceSearchQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(deviceSearchQuery, deviceSearchQuery2);
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();

    DeviceSearchQuery deviceSearchQuery2 = new DeviceSearchQuery();
    deviceSearchQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(deviceSearchQuery, deviceSearchQuery2);
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();

    DeviceSearchQuery deviceSearchQuery2 = new DeviceSearchQuery();
    deviceSearchQuery2.setDeviceTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(deviceSearchQuery, deviceSearchQuery2);
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters parameters = new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true);

    DeviceSearchQuery deviceSearchQuery = new DeviceSearchQuery();
    deviceSearchQuery.setParameters(parameters);

    // Act and Assert
    assertNotEquals(deviceSearchQuery, new DeviceSearchQuery());
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceSearchQuery(), null);
  }

  /**
   * Test {@link DeviceSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceSearchQuery(), "Different type to DeviceSearchQuery");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceSearchQuery}
   *   <li>{@link DeviceSearchQuery#setDeviceTypes(List)}
   *   <li>{@link DeviceSearchQuery#setParameters(RelationsSearchParameters)}
   *   <li>{@link DeviceSearchQuery#setRelationType(String)}
   *   <li>{@link DeviceSearchQuery#toString()}
   *   <li>{@link DeviceSearchQuery#getDeviceTypes()}
   *   <li>{@link DeviceSearchQuery#getParameters()}
   *   <li>{@link DeviceSearchQuery#getRelationType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceSearchQuery actualDeviceSearchQuery = new DeviceSearchQuery();
    ArrayList<String> deviceTypes = new ArrayList<>();
    actualDeviceSearchQuery.setDeviceTypes(deviceTypes);
    RelationsSearchParameters parameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);

    actualDeviceSearchQuery.setParameters(parameters);
    actualDeviceSearchQuery.setRelationType("Relation Type");
    String actualToStringResult = actualDeviceSearchQuery.toString();
    List<String> actualDeviceTypes = actualDeviceSearchQuery.getDeviceTypes();
    RelationsSearchParameters actualParameters = actualDeviceSearchQuery.getParameters();

    // Assert that nothing has changed
    assertEquals("DeviceSearchQuery(parameters=RelationsSearchParameters(rootId=13814000-1dd2-11b2-8080-808080808080,"
        + " rootType=TENANT, direction=FROM, relationTypeGroup=COMMON, maxLevel=3, fetchLastLevelOnly=true),"
        + " relationType=Relation Type, deviceTypes=[])", actualToStringResult);
    assertEquals("Relation Type", actualDeviceSearchQuery.getRelationType());
    assertTrue(actualDeviceTypes.isEmpty());
    assertSame(deviceTypes, actualDeviceTypes);
    assertSame(parameters, actualParameters);
  }
}
