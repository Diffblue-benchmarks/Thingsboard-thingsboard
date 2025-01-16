package org.thingsboard.server.common.data.relation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class RelationEntityTypeFilterDiffblueTest {
  /**
   * Test {@link RelationEntityTypeFilter#equals(Object)}, and
   * {@link RelationEntityTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationEntityTypeFilter#equals(Object)}
   *   <li>{@link RelationEntityTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter();
    RelationEntityTypeFilter relationEntityTypeFilter2 = new RelationEntityTypeFilter();

    // Act and Assert
    assertEquals(relationEntityTypeFilter, relationEntityTypeFilter2);
    int expectedHashCodeResult = relationEntityTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, relationEntityTypeFilter2.hashCode());
  }

  /**
   * Test {@link RelationEntityTypeFilter#equals(Object)}, and
   * {@link RelationEntityTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationEntityTypeFilter#equals(Object)}
   *   <li>{@link RelationEntityTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter("Relation Type",
        new ArrayList<>());
    RelationEntityTypeFilter relationEntityTypeFilter2 = new RelationEntityTypeFilter("Relation Type",
        new ArrayList<>());

    // Act and Assert
    assertEquals(relationEntityTypeFilter, relationEntityTypeFilter2);
    int expectedHashCodeResult = relationEntityTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, relationEntityTypeFilter2.hashCode());
  }

  /**
   * Test {@link RelationEntityTypeFilter#equals(Object)}, and
   * {@link RelationEntityTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationEntityTypeFilter#equals(Object)}
   *   <li>{@link RelationEntityTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter();

    // Act and Assert
    assertEquals(relationEntityTypeFilter, relationEntityTypeFilter);
    int expectedHashCodeResult = relationEntityTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, relationEntityTypeFilter.hashCode());
  }

  /**
   * Test {@link RelationEntityTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter("Relation Type",
        new ArrayList<>());

    // Act and Assert
    assertNotEquals(relationEntityTypeFilter, new RelationEntityTypeFilter());
  }

  /**
   * Test {@link RelationEntityTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter("Relation Type", new ArrayList<>(),
        true);

    // Act and Assert
    assertNotEquals(relationEntityTypeFilter, new RelationEntityTypeFilter());
  }

  /**
   * Test {@link RelationEntityTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter();

    // Act and Assert
    assertNotEquals(relationEntityTypeFilter, new RelationEntityTypeFilter("Relation Type", new ArrayList<>()));
  }

  /**
   * Test {@link RelationEntityTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter();
    relationEntityTypeFilter.setEntityTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(relationEntityTypeFilter, new RelationEntityTypeFilter());
  }

  /**
   * Test {@link RelationEntityTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter();

    RelationEntityTypeFilter relationEntityTypeFilter2 = new RelationEntityTypeFilter();
    relationEntityTypeFilter2.setEntityTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(relationEntityTypeFilter, relationEntityTypeFilter2);
  }

  /**
   * Test {@link RelationEntityTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationEntityTypeFilter(), null);
  }

  /**
   * Test {@link RelationEntityTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationEntityTypeFilter(), "Different type to RelationEntityTypeFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationEntityTypeFilter#RelationEntityTypeFilter()}
   *   <li>{@link RelationEntityTypeFilter#setEntityTypes(List)}
   *   <li>{@link RelationEntityTypeFilter#setNegate(boolean)}
   *   <li>{@link RelationEntityTypeFilter#setRelationType(String)}
   *   <li>{@link RelationEntityTypeFilter#toString()}
   *   <li>{@link RelationEntityTypeFilter#getEntityTypes()}
   *   <li>{@link RelationEntityTypeFilter#getRelationType()}
   *   <li>{@link RelationEntityTypeFilter#isNegate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    RelationEntityTypeFilter actualRelationEntityTypeFilter = new RelationEntityTypeFilter();
    ArrayList<EntityType> entityTypes = new ArrayList<>();
    actualRelationEntityTypeFilter.setEntityTypes(entityTypes);
    actualRelationEntityTypeFilter.setNegate(true);
    actualRelationEntityTypeFilter.setRelationType("Relation Type");
    String actualToStringResult = actualRelationEntityTypeFilter.toString();
    List<EntityType> actualEntityTypes = actualRelationEntityTypeFilter.getEntityTypes();
    String actualRelationType = actualRelationEntityTypeFilter.getRelationType();
    boolean actualIsNegateResult = actualRelationEntityTypeFilter.isNegate();

    // Assert that nothing has changed
    assertEquals("Relation Type", actualRelationType);
    assertEquals("RelationEntityTypeFilter(relationType=Relation Type, entityTypes=[], negate=true)",
        actualToStringResult);
    assertTrue(actualEntityTypes.isEmpty());
    assertTrue(actualIsNegateResult);
    assertSame(entityTypes, actualEntityTypes);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Relation Type}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationEntityTypeFilter#RelationEntityTypeFilter(String, List)}
   *   <li>{@link RelationEntityTypeFilter#setEntityTypes(List)}
   *   <li>{@link RelationEntityTypeFilter#setNegate(boolean)}
   *   <li>{@link RelationEntityTypeFilter#setRelationType(String)}
   *   <li>{@link RelationEntityTypeFilter#toString()}
   *   <li>{@link RelationEntityTypeFilter#getEntityTypes()}
   *   <li>{@link RelationEntityTypeFilter#getRelationType()}
   *   <li>{@link RelationEntityTypeFilter#isNegate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Relation Type'")
  void testGettersAndSetters_whenRelationType() {
    // Arrange and Act
    RelationEntityTypeFilter actualRelationEntityTypeFilter = new RelationEntityTypeFilter("Relation Type",
        new ArrayList<>());
    ArrayList<EntityType> entityTypes = new ArrayList<>();
    actualRelationEntityTypeFilter.setEntityTypes(entityTypes);
    actualRelationEntityTypeFilter.setNegate(true);
    actualRelationEntityTypeFilter.setRelationType("Relation Type");
    String actualToStringResult = actualRelationEntityTypeFilter.toString();
    List<EntityType> actualEntityTypes = actualRelationEntityTypeFilter.getEntityTypes();
    String actualRelationType = actualRelationEntityTypeFilter.getRelationType();
    boolean actualIsNegateResult = actualRelationEntityTypeFilter.isNegate();

    // Assert that nothing has changed
    assertEquals("Relation Type", actualRelationType);
    assertEquals("RelationEntityTypeFilter(relationType=Relation Type, entityTypes=[], negate=true)",
        actualToStringResult);
    assertTrue(actualEntityTypes.isEmpty());
    assertTrue(actualIsNegateResult);
    assertSame(entityTypes, actualEntityTypes);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RelationEntityTypeFilter#RelationEntityTypeFilter(String, List, boolean)}
   *   <li>{@link RelationEntityTypeFilter#setEntityTypes(List)}
   *   <li>{@link RelationEntityTypeFilter#setNegate(boolean)}
   *   <li>{@link RelationEntityTypeFilter#setRelationType(String)}
   *   <li>{@link RelationEntityTypeFilter#toString()}
   *   <li>{@link RelationEntityTypeFilter#getEntityTypes()}
   *   <li>{@link RelationEntityTypeFilter#getRelationType()}
   *   <li>{@link RelationEntityTypeFilter#isNegate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    RelationEntityTypeFilter actualRelationEntityTypeFilter = new RelationEntityTypeFilter("Relation Type",
        new ArrayList<>(), true);
    ArrayList<EntityType> entityTypes = new ArrayList<>();
    actualRelationEntityTypeFilter.setEntityTypes(entityTypes);
    actualRelationEntityTypeFilter.setNegate(true);
    actualRelationEntityTypeFilter.setRelationType("Relation Type");
    String actualToStringResult = actualRelationEntityTypeFilter.toString();
    List<EntityType> actualEntityTypes = actualRelationEntityTypeFilter.getEntityTypes();
    String actualRelationType = actualRelationEntityTypeFilter.getRelationType();
    boolean actualIsNegateResult = actualRelationEntityTypeFilter.isNegate();

    // Assert that nothing has changed
    assertEquals("Relation Type", actualRelationType);
    assertEquals("RelationEntityTypeFilter(relationType=Relation Type, entityTypes=[], negate=true)",
        actualToStringResult);
    assertTrue(actualEntityTypes.isEmpty());
    assertTrue(actualIsNegateResult);
    assertSame(entityTypes, actualEntityTypes);
  }
}
