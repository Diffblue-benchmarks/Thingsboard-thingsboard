package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class EntityNameFilterDiffblueTest {
  /**
   * Test {@link EntityNameFilter#equals(Object)}, and {@link EntityNameFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityNameFilter#equals(Object)}
   *   <li>{@link EntityNameFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityNameFilter.equals(Object)", "int EntityNameFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(EntityType.TENANT);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter("Entity Name Filter");
    entityNameFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals(entityNameFilter, entityNameFilter2);
    int expectedHashCodeResult = entityNameFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityNameFilter2.hashCode());
  }

  /**
   * Test {@link EntityNameFilter#equals(Object)}, and {@link EntityNameFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityNameFilter#equals(Object)}
   *   <li>{@link EntityNameFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityNameFilter.equals(Object)", "int EntityNameFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter(null);
    entityNameFilter.setEntityType(EntityType.TENANT);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter(null);
    entityNameFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals(entityNameFilter, entityNameFilter2);
    int expectedHashCodeResult = entityNameFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityNameFilter2.hashCode());
  }

  /**
   * Test {@link EntityNameFilter#equals(Object)}, and {@link EntityNameFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityNameFilter#equals(Object)}
   *   <li>{@link EntityNameFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityNameFilter.equals(Object)", "int EntityNameFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(null);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter("Entity Name Filter");
    entityNameFilter2.setEntityType(null);

    // Act and Assert
    assertEquals(entityNameFilter, entityNameFilter2);
    int expectedHashCodeResult = entityNameFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityNameFilter2.hashCode());
  }

  /**
   * Test {@link EntityNameFilter#equals(Object)}, and {@link EntityNameFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityNameFilter#equals(Object)}
   *   <li>{@link EntityNameFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityNameFilter.equals(Object)", "int EntityNameFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals(entityNameFilter, entityNameFilter);
    int expectedHashCodeResult = entityNameFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityNameFilter.hashCode());
  }

  /**
   * Test {@link EntityNameFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityNameFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityNameFilter.equals(Object)", "int EntityNameFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter(null);
    entityNameFilter.setEntityType(EntityType.TENANT);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter("Entity Name Filter");
    entityNameFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityNameFilter, entityNameFilter2);
  }

  /**
   * Test {@link EntityNameFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityNameFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityNameFilter.equals(Object)", "int EntityNameFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("org.thingsboard.server.common.data.query.EntityNameFilter");
    entityNameFilter.setEntityType(EntityType.TENANT);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter("Entity Name Filter");
    entityNameFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityNameFilter, entityNameFilter2);
  }

  /**
   * Test {@link EntityNameFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityNameFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityNameFilter.equals(Object)", "int EntityNameFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(null);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter("Entity Name Filter");
    entityNameFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityNameFilter, entityNameFilter2);
  }

  /**
   * Test {@link EntityNameFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityNameFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityNameFilter.equals(Object)", "int EntityNameFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(EntityType.CUSTOMER);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter("Entity Name Filter");
    entityNameFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityNameFilter, entityNameFilter2);
  }

  /**
   * Test {@link EntityNameFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityNameFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityNameFilter.equals(Object)", "int EntityNameFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityNameFilter, null);
  }

  /**
   * Test {@link EntityNameFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityNameFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityNameFilter.equals(Object)", "int EntityNameFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityNameFilter, "Different type to EntityNameFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityNameFilter}
   *   <li>{@link EntityNameFilter#setEntityNameFilter(String)}
   *   <li>{@link EntityNameFilter#setEntityType(EntityType)}
   *   <li>{@link EntityNameFilter#toString()}
   *   <li>{@link EntityNameFilter#getEntityNameFilter()}
   *   <li>{@link EntityNameFilter#getEntityType()}
   *   <li>{@link EntityNameFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityNameFilter.<init>()", "String EntityNameFilter.getEntityNameFilter()",
      "EntityType EntityNameFilter.getEntityType()", "EntityFilterType EntityNameFilter.getType()",
      "void EntityNameFilter.setEntityNameFilter(String)", "void EntityNameFilter.setEntityType(EntityType)",
      "String EntityNameFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntityNameFilter actualEntityNameFilter = new EntityNameFilter();
    actualEntityNameFilter.setEntityNameFilter("Entity Name Filter");
    actualEntityNameFilter.setEntityType(EntityType.TENANT);
    String actualToStringResult = actualEntityNameFilter.toString();
    String actualEntityNameFilter2 = actualEntityNameFilter.getEntityNameFilter();
    EntityType actualEntityType = actualEntityNameFilter.getEntityType();

    // Assert
    assertEquals("Entity Name Filter", actualEntityNameFilter2);
    assertEquals("EntityNameFilter(entityType=TENANT, entityNameFilter=Entity Name Filter)", actualToStringResult);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertEquals(EntityFilterType.ENTITY_NAME, actualEntityNameFilter.getType());
  }
}
