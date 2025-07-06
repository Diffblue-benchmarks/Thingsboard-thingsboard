package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class EntityTypeFilterDiffblueTest {
  /**
   * Test {@link EntityTypeFilter#equals(Object)}, and {@link EntityTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTypeFilter#equals(Object)}
   *   <li>{@link EntityTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeFilter.equals(Object)", "int EntityTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(EntityType.TENANT);

    EntityTypeFilter entityTypeFilter2 = new EntityTypeFilter();
    entityTypeFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals(entityTypeFilter, entityTypeFilter2);
    int expectedHashCodeResult = entityTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeFilter2.hashCode());
  }

  /**
   * Test {@link EntityTypeFilter#equals(Object)}, and {@link EntityTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTypeFilter#equals(Object)}
   *   <li>{@link EntityTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeFilter.equals(Object)", "int EntityTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(null);

    EntityTypeFilter entityTypeFilter2 = new EntityTypeFilter();
    entityTypeFilter2.setEntityType(null);

    // Act and Assert
    assertEquals(entityTypeFilter, entityTypeFilter2);
    int expectedHashCodeResult = entityTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeFilter2.hashCode());
  }

  /**
   * Test {@link EntityTypeFilter#equals(Object)}, and {@link EntityTypeFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTypeFilter#equals(Object)}
   *   <li>{@link EntityTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeFilter.equals(Object)", "int EntityTypeFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals(entityTypeFilter, entityTypeFilter);
    int expectedHashCodeResult = entityTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeFilter.hashCode());
  }

  /**
   * Test {@link EntityTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeFilter.equals(Object)", "int EntityTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(null);

    EntityTypeFilter entityTypeFilter2 = new EntityTypeFilter();
    entityTypeFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityTypeFilter, entityTypeFilter2);
  }

  /**
   * Test {@link EntityTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeFilter.equals(Object)", "int EntityTypeFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(EntityType.CUSTOMER);

    EntityTypeFilter entityTypeFilter2 = new EntityTypeFilter();
    entityTypeFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityTypeFilter, entityTypeFilter2);
  }

  /**
   * Test {@link EntityTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeFilter.equals(Object)", "int EntityTypeFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityTypeFilter, null);
  }

  /**
   * Test {@link EntityTypeFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeFilter.equals(Object)", "int EntityTypeFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityTypeFilter, "Different type to EntityTypeFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityTypeFilter}
   *   <li>{@link EntityTypeFilter#setEntityType(EntityType)}
   *   <li>{@link EntityTypeFilter#toString()}
   *   <li>{@link EntityTypeFilter#getEntityType()}
   *   <li>{@link EntityTypeFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntityTypeFilter.<init>()",
    "EntityType EntityTypeFilter.getEntityType()",
    "EntityFilterType EntityTypeFilter.getType()",
    "void EntityTypeFilter.setEntityType(EntityType)",
    "String EntityTypeFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityTypeFilter actualEntityTypeFilter = new EntityTypeFilter();
    actualEntityTypeFilter.setEntityType(EntityType.TENANT);
    String actualToStringResult = actualEntityTypeFilter.toString();
    EntityType actualEntityType = actualEntityTypeFilter.getEntityType();

    // Assert
    assertEquals("EntityTypeFilter(entityType=TENANT)", actualToStringResult);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertEquals(EntityFilterType.ENTITY_TYPE, actualEntityTypeFilter.getType());
  }
}
