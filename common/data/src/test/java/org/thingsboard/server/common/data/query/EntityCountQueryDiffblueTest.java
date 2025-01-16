package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EntityCountQueryDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountQuery#EntityCountQuery()}
   *   <li>{@link EntityCountQuery#toString()}
   *   <li>{@link EntityCountQuery#getEntityFilter()}
   *   <li>{@link EntityCountQuery#getKeyFilters()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    EntityCountQuery actualEntityCountQuery = new EntityCountQuery();
    String actualToStringResult = actualEntityCountQuery.toString();
    EntityFilter actualEntityFilter = actualEntityCountQuery.getEntityFilter();

    // Assert
    assertEquals("EntityCountQuery(entityFilter=null, keyFilters=null)", actualToStringResult);
    assertNull(actualEntityCountQuery.getKeyFilters());
    assertNull(actualEntityFilter);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link EntityFilter}.</li>
   *   <li>Then return KeyFilters Empty.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountQuery#EntityCountQuery(EntityFilter, List)}
   *   <li>{@link EntityCountQuery#toString()}
   *   <li>{@link EntityCountQuery#getEntityFilter()}
   *   <li>{@link EntityCountQuery#getKeyFilters()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when EntityFilter; then return KeyFilters Empty")
  void testGettersAndSetters_whenEntityFilter_thenReturnKeyFiltersEmpty() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();

    // Act
    EntityCountQuery actualEntityCountQuery = new EntityCountQuery(entityFilter, keyFilters);
    actualEntityCountQuery.toString();
    EntityFilter actualEntityFilter = actualEntityCountQuery.getEntityFilter();
    List<KeyFilter> actualKeyFilters = actualEntityCountQuery.getKeyFilters();

    // Assert
    assertTrue(actualKeyFilters.isEmpty());
    assertSame(keyFilters, actualKeyFilters);
    assertSame(entityFilter, actualEntityFilter);
  }

  /**
   * Test {@link EntityCountQuery#EntityCountQuery(EntityFilter)}.
   * <p>
   * Method under test: {@link EntityCountQuery#EntityCountQuery(EntityFilter)}
   */
  @Test
  @DisplayName("Test new EntityCountQuery(EntityFilter)")
  void testNewEntityCountQuery() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);

    // Act
    EntityCountQuery actualEntityCountQuery = new EntityCountQuery(entityFilter);

    // Assert
    assertTrue(actualEntityCountQuery.getKeyFilters().isEmpty());
    assertSame(entityFilter, actualEntityCountQuery.getEntityFilter());
  }
}
