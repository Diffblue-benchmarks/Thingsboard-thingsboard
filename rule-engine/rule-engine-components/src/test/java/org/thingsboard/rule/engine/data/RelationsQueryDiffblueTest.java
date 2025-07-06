package org.thingsboard.rule.engine.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationEntityTypeFilter;

class RelationsQueryDiffblueTest {
  /**
   * Test {@link RelationsQuery#equals(Object)}, and {@link RelationsQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationsQuery#equals(Object)}
   *   <li>{@link RelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RelationsQuery.equals(Object)", "int RelationsQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    RelationsQuery relationsQuery2 = new RelationsQuery();
    relationsQuery2.setDirection(EntitySearchDirection.FROM);
    relationsQuery2.setFetchLastLevelOnly(true);
    relationsQuery2.setFilters(new ArrayList<>());
    relationsQuery2.setMaxLevel(3);

    // Act and Assert
    assertEquals(relationsQuery, relationsQuery2);
    int expectedHashCodeResult = relationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, relationsQuery2.hashCode());
  }

  /**
   * Test {@link RelationsQuery#equals(Object)}, and {@link RelationsQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationsQuery#equals(Object)}
   *   <li>{@link RelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RelationsQuery.equals(Object)", "int RelationsQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(null);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    RelationsQuery relationsQuery2 = new RelationsQuery();
    relationsQuery2.setDirection(null);
    relationsQuery2.setFetchLastLevelOnly(true);
    relationsQuery2.setFilters(new ArrayList<>());
    relationsQuery2.setMaxLevel(3);

    // Act and Assert
    assertEquals(relationsQuery, relationsQuery2);
    int expectedHashCodeResult = relationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, relationsQuery2.hashCode());
  }

  /**
   * Test {@link RelationsQuery#equals(Object)}, and {@link RelationsQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationsQuery#equals(Object)}
   *   <li>{@link RelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RelationsQuery.equals(Object)", "int RelationsQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    // Act and Assert
    assertEquals(relationsQuery, relationsQuery);
    int expectedHashCodeResult = relationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, relationsQuery.hashCode());
  }

  /**
   * Test {@link RelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RelationsQuery.equals(Object)", "int RelationsQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(null);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    RelationsQuery relationsQuery2 = new RelationsQuery();
    relationsQuery2.setDirection(EntitySearchDirection.FROM);
    relationsQuery2.setFetchLastLevelOnly(true);
    relationsQuery2.setFilters(new ArrayList<>());
    relationsQuery2.setMaxLevel(3);

    // Act and Assert
    assertNotEquals(relationsQuery, relationsQuery2);
  }

  /**
   * Test {@link RelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RelationsQuery.equals(Object)", "int RelationsQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.TO);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    RelationsQuery relationsQuery2 = new RelationsQuery();
    relationsQuery2.setDirection(EntitySearchDirection.FROM);
    relationsQuery2.setFetchLastLevelOnly(true);
    relationsQuery2.setFilters(new ArrayList<>());
    relationsQuery2.setMaxLevel(3);

    // Act and Assert
    assertNotEquals(relationsQuery, relationsQuery2);
  }

  /**
   * Test {@link RelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RelationsQuery.equals(Object)", "int RelationsQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(false);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    RelationsQuery relationsQuery2 = new RelationsQuery();
    relationsQuery2.setDirection(EntitySearchDirection.FROM);
    relationsQuery2.setFetchLastLevelOnly(true);
    relationsQuery2.setFilters(new ArrayList<>());
    relationsQuery2.setMaxLevel(3);

    // Act and Assert
    assertNotEquals(relationsQuery, relationsQuery2);
  }

  /**
   * Test {@link RelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RelationsQuery.equals(Object)", "int RelationsQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<RelationEntityTypeFilter> filters = new ArrayList<>();
    filters.add(new RelationEntityTypeFilter());

    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(filters);
    relationsQuery.setMaxLevel(3);

    RelationsQuery relationsQuery2 = new RelationsQuery();
    relationsQuery2.setDirection(EntitySearchDirection.FROM);
    relationsQuery2.setFetchLastLevelOnly(true);
    relationsQuery2.setFilters(new ArrayList<>());
    relationsQuery2.setMaxLevel(3);

    // Act and Assert
    assertNotEquals(relationsQuery, relationsQuery2);
  }

  /**
   * Test {@link RelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RelationsQuery.equals(Object)", "int RelationsQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(1);

    RelationsQuery relationsQuery2 = new RelationsQuery();
    relationsQuery2.setDirection(EntitySearchDirection.FROM);
    relationsQuery2.setFetchLastLevelOnly(true);
    relationsQuery2.setFilters(new ArrayList<>());
    relationsQuery2.setMaxLevel(3);

    // Act and Assert
    assertNotEquals(relationsQuery, relationsQuery2);
  }

  /**
   * Test {@link RelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RelationsQuery.equals(Object)", "int RelationsQuery.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    // Act and Assert
    assertNotEquals(relationsQuery, null);
  }

  /**
   * Test {@link RelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RelationsQuery.equals(Object)", "int RelationsQuery.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    // Act and Assert
    assertNotEquals(relationsQuery, "Different type to RelationsQuery");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RelationsQuery}
   *   <li>{@link RelationsQuery#setDirection(EntitySearchDirection)}
   *   <li>{@link RelationsQuery#setFetchLastLevelOnly(boolean)}
   *   <li>{@link RelationsQuery#setFilters(List)}
   *   <li>{@link RelationsQuery#setMaxLevel(int)}
   *   <li>{@link RelationsQuery#toString()}
   *   <li>{@link RelationsQuery#getDirection()}
   *   <li>{@link RelationsQuery#getFilters()}
   *   <li>{@link RelationsQuery#getMaxLevel()}
   *   <li>{@link RelationsQuery#isFetchLastLevelOnly()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RelationsQuery.<init>()",
    "EntitySearchDirection RelationsQuery.getDirection()",
    "List RelationsQuery.getFilters()",
    "int RelationsQuery.getMaxLevel()",
    "boolean RelationsQuery.isFetchLastLevelOnly()",
    "void RelationsQuery.setDirection(EntitySearchDirection)",
    "void RelationsQuery.setFetchLastLevelOnly(boolean)",
    "void RelationsQuery.setFilters(List)",
    "void RelationsQuery.setMaxLevel(int)",
    "String RelationsQuery.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RelationsQuery actualRelationsQuery = new RelationsQuery();
    actualRelationsQuery.setDirection(EntitySearchDirection.FROM);
    actualRelationsQuery.setFetchLastLevelOnly(true);
    ArrayList<RelationEntityTypeFilter> filters = new ArrayList<>();
    actualRelationsQuery.setFilters(filters);
    actualRelationsQuery.setMaxLevel(3);
    String actualToStringResult = actualRelationsQuery.toString();
    EntitySearchDirection actualDirection = actualRelationsQuery.getDirection();
    List<RelationEntityTypeFilter> actualFilters = actualRelationsQuery.getFilters();
    int actualMaxLevel = actualRelationsQuery.getMaxLevel();
    boolean actualIsFetchLastLevelOnlyResult = actualRelationsQuery.isFetchLastLevelOnly();

    // Assert
    assertEquals(
        "RelationsQuery(direction=FROM, maxLevel=3, filters=[], fetchLastLevelOnly=true)",
        actualToStringResult);
    assertEquals(3, actualMaxLevel);
    assertEquals(EntitySearchDirection.FROM, actualDirection);
    assertTrue(actualFilters.isEmpty());
    assertTrue(actualIsFetchLastLevelOnlyResult);
    assertSame(filters, actualFilters);
  }
}
