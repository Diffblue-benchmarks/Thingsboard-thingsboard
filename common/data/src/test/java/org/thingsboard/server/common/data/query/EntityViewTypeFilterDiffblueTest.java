package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EntityViewTypeFilterDiffblueTest {
  /**
   * Test {@link EntityViewTypeFilter#getEntityViewTypes()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return first is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewTypeFilter#getEntityViewTypes()}
   */
  @Test
  @DisplayName("Test getEntityViewTypes(); given ArrayList() add 'foo'; then return first is 'foo'")
  void testGetEntityViewTypes_givenArrayListAddFoo_thenReturnFirstIsFoo() {
    // Arrange
    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("foo");

    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewTypes(entityViewTypes);

    // Act
    List<String> actualEntityViewTypes = entityViewTypeFilter.getEntityViewTypes();

    // Assert
    assertEquals(1, actualEntityViewTypes.size());
    assertEquals("foo", actualEntityViewTypes.get(0));
    assertSame(entityViewTypes, actualEntityViewTypes);
  }

  /**
   * Test {@link EntityViewTypeFilter#getEntityViewTypes()}.
   * <ul>
   *   <li>Given {@link EntityViewTypeFilter} (default constructor).</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewTypeFilter#getEntityViewTypes()}
   */
  @Test
  @DisplayName("Test getEntityViewTypes(); given EntityViewTypeFilter (default constructor); then return first is 'null'")
  void testGetEntityViewTypes_givenEntityViewTypeFilter_thenReturnFirstIsNull() {
    // Arrange and Act
    List<String> actualEntityViewTypes = (new EntityViewTypeFilter()).getEntityViewTypes();

    // Assert
    assertEquals(1, actualEntityViewTypes.size());
    assertNull(actualEntityViewTypes.get(0));
  }

  /**
   * Test {@link EntityViewTypeFilter#equals(Object)}, and
   * {@link EntityViewTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewTypeFilter#equals(Object)}
   *   <li>{@link EntityViewTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(entityViewTypeFilter, entityViewTypeFilter2);
    int expectedHashCodeResult = entityViewTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityViewTypeFilter2.hashCode());
  }

  /**
   * Test {@link EntityViewTypeFilter#equals(Object)}, and
   * {@link EntityViewTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewTypeFilter#equals(Object)}
   *   <li>{@link EntityViewTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Entity View Type");

    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(entityViewTypes);

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(entityViewTypeFilter, entityViewTypeFilter2);
    int expectedHashCodeResult = entityViewTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityViewTypeFilter2.hashCode());
  }

  /**
   * Test {@link EntityViewTypeFilter#equals(Object)}, and
   * {@link EntityViewTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewTypeFilter#equals(Object)}
   *   <li>{@link EntityViewTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter(null);
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter(null);
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(entityViewTypeFilter, entityViewTypeFilter2);
    int expectedHashCodeResult = entityViewTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityViewTypeFilter2.hashCode());
  }

  /**
   * Test {@link EntityViewTypeFilter#equals(Object)}, and
   * {@link EntityViewTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewTypeFilter#equals(Object)}
   *   <li>{@link EntityViewTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType(null);
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType(null);
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(entityViewTypeFilter, entityViewTypeFilter2);
    int expectedHashCodeResult = entityViewTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityViewTypeFilter2.hashCode());
  }

  /**
   * Test {@link EntityViewTypeFilter#equals(Object)}, and
   * {@link EntityViewTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewTypeFilter#equals(Object)}
   *   <li>{@link EntityViewTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(entityViewTypeFilter, entityViewTypeFilter);
    int expectedHashCodeResult = entityViewTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityViewTypeFilter.hashCode());
  }

  /**
   * Test {@link EntityViewTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Type");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, entityViewTypeFilter2);
  }

  /**
   * Test {@link EntityViewTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter(null);
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, entityViewTypeFilter2);
  }

  /**
   * Test {@link EntityViewTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, entityViewTypeFilter2);
  }

  /**
   * Test {@link EntityViewTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType(null);
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, entityViewTypeFilter2);
  }

  /**
   * Test {@link EntityViewTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Entity View Name Filter");
    entityViewTypes.add("Entity View Type");

    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(entityViewTypes);

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, entityViewTypeFilter2);
  }

  /**
   * Test {@link EntityViewTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, null);
  }

  /**
   * Test {@link EntityViewTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, "Different type to EntityViewTypeFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityViewTypeFilter}
   *   <li>{@link EntityViewTypeFilter#setEntityViewNameFilter(String)}
   *   <li>{@link EntityViewTypeFilter#setEntityViewType(String)}
   *   <li>{@link EntityViewTypeFilter#setEntityViewTypes(List)}
   *   <li>{@link EntityViewTypeFilter#toString()}
   *   <li>{@link EntityViewTypeFilter#getEntityViewNameFilter()}
   *   <li>{@link EntityViewTypeFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    EntityViewTypeFilter actualEntityViewTypeFilter = new EntityViewTypeFilter();
    actualEntityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    actualEntityViewTypeFilter.setEntityViewType("Entity View Type");
    actualEntityViewTypeFilter.setEntityViewTypes(new ArrayList<>());
    String actualToStringResult = actualEntityViewTypeFilter.toString();
    String actualEntityViewNameFilter = actualEntityViewTypeFilter.getEntityViewNameFilter();

    // Assert that nothing has changed
    assertEquals("Entity View Name Filter", actualEntityViewNameFilter);
    assertEquals("EntityViewTypeFilter(entityViewType=Entity View Type, entityViewTypes=[Entity View Type], entityView"
        + "NameFilter=Entity View Name Filter)", actualToStringResult);
    assertEquals(EntityFilterType.ENTITY_VIEW_TYPE, actualEntityViewTypeFilter.getType());
  }
}
