package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AlarmDataQueryDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return KeyFilters is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataQuery#AlarmDataQuery()}
   *   <li>{@link AlarmDataQuery#toString()}
   *   <li>{@link AlarmDataQuery#getAlarmFields()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return KeyFilters is 'null'")
  void testGettersAndSetters_thenReturnKeyFiltersIsNull() {
    // Arrange and Act
    AlarmDataQuery actualAlarmDataQuery = new AlarmDataQuery();
    String actualToStringResult = actualAlarmDataQuery.toString();
    List<EntityKey> actualAlarmFields = actualAlarmDataQuery.getAlarmFields();

    // Assert
    assertEquals("AlarmDataQuery(alarmFields=null)", actualToStringResult);
    assertNull(actualAlarmDataQuery.getEntityFields());
    assertNull(actualAlarmDataQuery.getLatestValues());
    assertNull(actualAlarmFields);
    assertNull(actualAlarmDataQuery.getKeyFilters());
    assertNull(actualAlarmDataQuery.getPageLink());
    assertNull(actualAlarmDataQuery.getEntityFilter());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return toString is {@code AlarmDataQuery(alarmFields=[])}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmDataQuery#AlarmDataQuery(EntityFilter, AlarmDataPageLink, List, List, List, List)}
   *   <li>{@link AlarmDataQuery#toString()}
   *   <li>{@link AlarmDataQuery#getAlarmFields()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'AlarmDataQuery(alarmFields=[])'")
  void testGettersAndSetters_thenReturnToStringIsAlarmDataQueryAlarmFields() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    AlarmDataPageLink pageLink = new AlarmDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    ArrayList<EntityKey> alarmFields = new ArrayList<>();

    // Act
    AlarmDataQuery actualAlarmDataQuery = new AlarmDataQuery(entityFilter, pageLink, entityFields, latestValues,
        keyFilters, alarmFields);
    String actualToStringResult = actualAlarmDataQuery.toString();
    List<EntityKey> actualAlarmFields = actualAlarmDataQuery.getAlarmFields();

    // Assert
    assertEquals("AlarmDataQuery(alarmFields=[])", actualToStringResult);
    List<EntityKey> entityFields2 = actualAlarmDataQuery.getEntityFields();
    assertTrue(entityFields2.isEmpty());
    List<EntityKey> latestValues2 = actualAlarmDataQuery.getLatestValues();
    assertTrue(latestValues2.isEmpty());
    assertTrue(actualAlarmFields.isEmpty());
    List<KeyFilter> keyFilters2 = actualAlarmDataQuery.getKeyFilters();
    assertTrue(keyFilters2.isEmpty());
    assertSame(entityFields, entityFields2);
    assertSame(latestValues, latestValues2);
    assertSame(alarmFields, actualAlarmFields);
    assertSame(keyFilters, keyFilters2);
    assertSame(pageLink, actualAlarmDataQuery.getPageLink());
    assertSame(entityFilter, actualAlarmDataQuery.getEntityFilter());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return toString is {@code AlarmDataQuery(alarmFields=null)}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataQuery#AlarmDataQuery(EntityFilter, List)}
   *   <li>{@link AlarmDataQuery#toString()}
   *   <li>{@link AlarmDataQuery#getAlarmFields()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'AlarmDataQuery(alarmFields=null)'")
  void testGettersAndSetters_thenReturnToStringIsAlarmDataQueryAlarmFieldsNull() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();

    // Act
    AlarmDataQuery actualAlarmDataQuery = new AlarmDataQuery(entityFilter, keyFilters);
    String actualToStringResult = actualAlarmDataQuery.toString();
    List<EntityKey> actualAlarmFields = actualAlarmDataQuery.getAlarmFields();

    // Assert
    assertEquals("AlarmDataQuery(alarmFields=null)", actualToStringResult);
    assertNull(actualAlarmDataQuery.getEntityFields());
    assertNull(actualAlarmDataQuery.getLatestValues());
    assertNull(actualAlarmFields);
    assertNull(actualAlarmDataQuery.getPageLink());
    List<KeyFilter> keyFilters2 = actualAlarmDataQuery.getKeyFilters();
    assertTrue(keyFilters2.isEmpty());
    assertSame(keyFilters, keyFilters2);
    assertSame(entityFilter, actualAlarmDataQuery.getEntityFilter());
  }

  /**
   * Test {@link AlarmDataQuery#next()}.
   * <ul>
   *   <li>Given {@link AlarmDataPageLink#AlarmDataPageLink()} Dynamic is
   * {@code true}.</li>
   *   <li>Then return PageLink Dynamic.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataQuery#next()}
   */
  @Test
  @DisplayName("Test next(); given AlarmDataPageLink() Dynamic is 'true'; then return PageLink Dynamic")
  void testNext_givenAlarmDataPageLinkDynamicIsTrue_thenReturnPageLinkDynamic() {
    // Arrange
    AlarmDataPageLink pageLink = new AlarmDataPageLink();
    pageLink.setDynamic(true);
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();

    // Act
    AlarmDataQuery actualNextResult = (new AlarmDataQuery(entityFilter, pageLink, entityFields, latestValues,
        keyFilters, new ArrayList<>())).next();

    // Assert
    AlarmDataPageLink pageLink2 = actualNextResult.getPageLink();
    assertNull(pageLink2.getTextSearch());
    assertNull(pageLink2.getTypeList());
    assertNull(pageLink2.getStatusList());
    assertNull(pageLink2.getSeverityList());
    assertNull(pageLink2.getAssigneeId());
    assertNull(pageLink2.getSortOrder());
    assertEquals(0, pageLink2.getPageSize());
    assertEquals(0L, pageLink2.getEndTs());
    assertEquals(0L, pageLink2.getStartTs());
    assertEquals(0L, pageLink2.getTimeWindow());
    assertEquals(1, pageLink2.getPage());
    assertFalse(pageLink2.isSearchPropagatedAlarms());
    assertTrue(actualNextResult.getEntityFields().isEmpty());
    assertTrue(actualNextResult.getLatestValues().isEmpty());
    assertTrue(actualNextResult.getAlarmFields().isEmpty());
    assertTrue(actualNextResult.getKeyFilters().isEmpty());
    assertTrue(pageLink2.isDynamic());
  }

  /**
   * Test {@link AlarmDataQuery#next()}.
   * <ul>
   *   <li>Then return not PageLink Dynamic.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataQuery#next()}
   */
  @Test
  @DisplayName("Test next(); then return not PageLink Dynamic")
  void testNext_thenReturnNotPageLinkDynamic() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    AlarmDataPageLink pageLink = new AlarmDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();

    // Act
    AlarmDataQuery actualNextResult = (new AlarmDataQuery(entityFilter, pageLink, entityFields, latestValues,
        keyFilters, new ArrayList<>())).next();

    // Assert
    AlarmDataPageLink pageLink2 = actualNextResult.getPageLink();
    assertNull(pageLink2.getTextSearch());
    assertNull(pageLink2.getTypeList());
    assertNull(pageLink2.getStatusList());
    assertNull(pageLink2.getSeverityList());
    assertNull(pageLink2.getAssigneeId());
    assertNull(pageLink2.getSortOrder());
    assertEquals(0, pageLink2.getPageSize());
    assertEquals(0L, pageLink2.getEndTs());
    assertEquals(0L, pageLink2.getStartTs());
    assertEquals(0L, pageLink2.getTimeWindow());
    assertEquals(1, pageLink2.getPage());
    assertFalse(pageLink2.isSearchPropagatedAlarms());
    assertFalse(pageLink2.isDynamic());
    assertTrue(actualNextResult.getEntityFields().isEmpty());
    assertTrue(actualNextResult.getLatestValues().isEmpty());
    assertTrue(actualNextResult.getAlarmFields().isEmpty());
    assertTrue(actualNextResult.getKeyFilters().isEmpty());
  }
}
