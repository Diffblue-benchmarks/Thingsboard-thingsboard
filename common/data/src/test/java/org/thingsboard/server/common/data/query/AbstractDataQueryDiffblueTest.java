package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractDataQueryDiffblueTest {
  /**
   * Test {@link AbstractDataQuery#getEntityFields()}.
   * <ul>
   *   <li>Given {@link AlarmDataQuery#AlarmDataQuery()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDataQuery#getEntityFields()}
   */
  @Test
  @DisplayName("Test getEntityFields(); given AlarmDataQuery()")
  void testGetEntityFields_givenAlarmDataQuery() {
    // Arrange, Act and Assert
    assertNull((new AlarmDataQuery()).getEntityFields());
  }

  /**
   * Test {@link AbstractDataQuery#getEntityFields()}.
   * <ul>
   *   <li>Given {@link AlarmDataQuery#AlarmDataQuery(EntityFilter, List)} with
   * {@link EntityFilter} and keyFilters is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDataQuery#getEntityFields()}
   */
  @Test
  @DisplayName("Test getEntityFields(); given AlarmDataQuery(EntityFilter, List) with EntityFilter and keyFilters is ArrayList()")
  void testGetEntityFields_givenAlarmDataQueryWithEntityFilterAndKeyFiltersIsArrayList() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);

    // Act and Assert
    assertNull((new AlarmDataQuery(entityFilter, new ArrayList<>())).getEntityFields());
  }

  /**
   * Test {@link AbstractDataQuery#getLatestValues()}.
   * <ul>
   *   <li>Given {@link AlarmDataQuery#AlarmDataQuery()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDataQuery#getLatestValues()}
   */
  @Test
  @DisplayName("Test getLatestValues(); given AlarmDataQuery()")
  void testGetLatestValues_givenAlarmDataQuery() {
    // Arrange, Act and Assert
    assertNull((new AlarmDataQuery()).getLatestValues());
  }

  /**
   * Test {@link AbstractDataQuery#getLatestValues()}.
   * <ul>
   *   <li>Given {@link AlarmDataQuery#AlarmDataQuery(EntityFilter, List)} with
   * {@link EntityFilter} and keyFilters is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDataQuery#getLatestValues()}
   */
  @Test
  @DisplayName("Test getLatestValues(); given AlarmDataQuery(EntityFilter, List) with EntityFilter and keyFilters is ArrayList()")
  void testGetLatestValues_givenAlarmDataQueryWithEntityFilterAndKeyFiltersIsArrayList() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);

    // Act and Assert
    assertNull((new AlarmDataQuery(entityFilter, new ArrayList<>())).getLatestValues());
  }

  /**
   * Test {@link AbstractDataQuery#getPageLink()}.
   * <ul>
   *   <li>Given {@link AlarmDataQuery#AlarmDataQuery()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDataQuery#getPageLink()}
   */
  @Test
  @DisplayName("Test getPageLink(); given AlarmDataQuery()")
  void testGetPageLink_givenAlarmDataQuery() {
    // Arrange, Act and Assert
    assertNull((new AlarmDataQuery()).getPageLink());
  }

  /**
   * Test {@link AbstractDataQuery#getPageLink()}.
   * <ul>
   *   <li>Given {@link AlarmDataQuery#AlarmDataQuery(EntityFilter, List)} with
   * {@link EntityFilter} and keyFilters is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDataQuery#getPageLink()}
   */
  @Test
  @DisplayName("Test getPageLink(); given AlarmDataQuery(EntityFilter, List) with EntityFilter and keyFilters is ArrayList()")
  void testGetPageLink_givenAlarmDataQueryWithEntityFilterAndKeyFiltersIsArrayList() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);

    // Act and Assert
    assertNull((new AlarmDataQuery(entityFilter, new ArrayList<>())).getPageLink());
  }

  /**
   * Test {@link AbstractDataQuery#toString()}.
   * <ul>
   *   <li>Given {@link EntityDataQuery#EntityDataQuery()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDataQuery#toString()}
   */
  @Test
  @DisplayName("Test toString(); given EntityDataQuery(); then return a string")
  void testToString_givenEntityDataQuery_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals("EntityDataQuery(super=AbstractDataQuery(super=EntityCountQuery(entityFilter=null, keyFilters=null),"
        + " pageLink=null, entityFields=null, latestValues=null))", (new EntityDataQuery()).toString());
  }
}
