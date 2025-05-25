package org.thingsboard.server.common.data.relation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;

class EntityRelationsQueryDiffblueTest {
  /**
   * Test {@link EntityRelationsQuery#equals(Object)}, and {@link EntityRelationsQuery#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityRelationsQuery#equals(Object)}
   *   <li>{@link EntityRelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelationsQuery.equals(Object)", "int EntityRelationsQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    EntityRelationsQuery entityRelationsQuery2 = new EntityRelationsQuery();
    entityRelationsQuery2.setFilters(new ArrayList<>());
    entityRelationsQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertEquals(entityRelationsQuery, entityRelationsQuery2);
    int expectedHashCodeResult = entityRelationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityRelationsQuery2.hashCode());
  }

  /**
   * Test {@link EntityRelationsQuery#equals(Object)}, and {@link EntityRelationsQuery#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityRelationsQuery#equals(Object)}
   *   <li>{@link EntityRelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelationsQuery.equals(Object)", "int EntityRelationsQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery.setParameters(null);

    EntityRelationsQuery entityRelationsQuery2 = new EntityRelationsQuery();
    entityRelationsQuery2.setFilters(new ArrayList<>());
    entityRelationsQuery2.setParameters(null);

    // Act and Assert
    assertEquals(entityRelationsQuery, entityRelationsQuery2);
    int expectedHashCodeResult = entityRelationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityRelationsQuery2.hashCode());
  }

  /**
   * Test {@link EntityRelationsQuery#equals(Object)}, and {@link EntityRelationsQuery#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityRelationsQuery#equals(Object)}
   *   <li>{@link EntityRelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelationsQuery.equals(Object)", "int EntityRelationsQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertEquals(entityRelationsQuery, entityRelationsQuery);
    int expectedHashCodeResult = entityRelationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityRelationsQuery.hashCode());
  }

  /**
   * Test {@link EntityRelationsQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelationsQuery.equals(Object)", "int EntityRelationsQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<RelationEntityTypeFilter> filters = new ArrayList<>();
    filters.add(new RelationEntityTypeFilter());

    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(filters);
    entityRelationsQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    EntityRelationsQuery entityRelationsQuery2 = new EntityRelationsQuery();
    entityRelationsQuery2.setFilters(new ArrayList<>());
    entityRelationsQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(entityRelationsQuery, entityRelationsQuery2);
  }

  /**
   * Test {@link EntityRelationsQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelationsQuery.equals(Object)", "int EntityRelationsQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery.setParameters(new RelationsSearchParameters(
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), EntitySearchDirection.FROM, 3, true));

    EntityRelationsQuery entityRelationsQuery2 = new EntityRelationsQuery();
    entityRelationsQuery2.setFilters(new ArrayList<>());
    entityRelationsQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(entityRelationsQuery, entityRelationsQuery2);
  }

  /**
   * Test {@link EntityRelationsQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelationsQuery.equals(Object)", "int EntityRelationsQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery.setParameters(null);

    EntityRelationsQuery entityRelationsQuery2 = new EntityRelationsQuery();
    entityRelationsQuery2.setFilters(new ArrayList<>());
    entityRelationsQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(entityRelationsQuery, entityRelationsQuery2);
  }

  /**
   * Test {@link EntityRelationsQuery#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelationsQuery.equals(Object)", "int EntityRelationsQuery.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(entityRelationsQuery, null);
  }

  /**
   * Test {@link EntityRelationsQuery#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityRelationsQuery.equals(Object)", "int EntityRelationsQuery.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(entityRelationsQuery, "Different type to EntityRelationsQuery");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityRelationsQuery}
   *   <li>{@link EntityRelationsQuery#setFilters(List)}
   *   <li>{@link EntityRelationsQuery#setParameters(RelationsSearchParameters)}
   *   <li>{@link EntityRelationsQuery#toString()}
   *   <li>{@link EntityRelationsQuery#getFilters()}
   *   <li>{@link EntityRelationsQuery#getParameters()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityRelationsQuery.<init>()", "List EntityRelationsQuery.getFilters()",
      "RelationsSearchParameters EntityRelationsQuery.getParameters()", "void EntityRelationsQuery.setFilters(List)",
      "void EntityRelationsQuery.setParameters(RelationsSearchParameters)", "String EntityRelationsQuery.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntityRelationsQuery actualEntityRelationsQuery = new EntityRelationsQuery();
    ArrayList<RelationEntityTypeFilter> filters = new ArrayList<>();
    actualEntityRelationsQuery.setFilters(filters);
    RelationsSearchParameters parameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);

    actualEntityRelationsQuery.setParameters(parameters);
    String actualToStringResult = actualEntityRelationsQuery.toString();
    List<RelationEntityTypeFilter> actualFilters = actualEntityRelationsQuery.getFilters();
    RelationsSearchParameters actualParameters = actualEntityRelationsQuery.getParameters();

    // Assert
    assertEquals(
        "EntityRelationsQuery(parameters=RelationsSearchParameters(rootId=13814000-1dd2-11b2-8080-808080808080,"
            + " rootType=TENANT, direction=FROM, relationTypeGroup=COMMON, maxLevel=3, fetchLastLevelOnly=true),"
            + " filters=[])",
        actualToStringResult);
    assertTrue(actualFilters.isEmpty());
    assertSame(filters, actualFilters);
    assertSame(parameters, actualParameters);
  }
}
