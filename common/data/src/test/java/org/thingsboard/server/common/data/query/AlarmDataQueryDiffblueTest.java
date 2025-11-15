/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AlarmDataQueryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataQuery#AlarmDataQuery()}
   *   <li>{@link AlarmDataQuery#toString()}
   *   <li>{@link AlarmDataQuery#getAlarmFields()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
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
   * Method under test: {@link AlarmDataQuery#next()}
   */
  @Test
  void testNext() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    AlarmDataPageLink pageLink = new AlarmDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    ArrayList<EntityKey> alarmFields = new ArrayList<>();

    // Act
    AlarmDataQuery actualNextResult = (new AlarmDataQuery(entityFilter, pageLink, entityFields, latestValues,
        keyFilters, alarmFields)).next();

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
    List<EntityKey> entityFields2 = actualNextResult.getEntityFields();
    assertTrue(entityFields2.isEmpty());
    List<EntityKey> latestValues2 = actualNextResult.getLatestValues();
    assertTrue(latestValues2.isEmpty());
    List<EntityKey> alarmFields2 = actualNextResult.getAlarmFields();
    assertTrue(alarmFields2.isEmpty());
    List<KeyFilter> keyFilters2 = actualNextResult.getKeyFilters();
    assertTrue(keyFilters2.isEmpty());
    assertSame(entityFields, entityFields2);
    assertSame(latestValues, latestValues2);
    assertSame(alarmFields, alarmFields2);
    assertSame(keyFilters, keyFilters2);
  }

  /**
   * Method under test: {@link AlarmDataQuery#next()}
   */
  @Test
  void testNext2() {
    // Arrange
    AlarmDataPageLink pageLink = new AlarmDataPageLink();
    pageLink.setDynamic(true);
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    ArrayList<EntityKey> alarmFields = new ArrayList<>();

    // Act
    AlarmDataQuery actualNextResult = (new AlarmDataQuery(entityFilter, pageLink, entityFields, latestValues,
        keyFilters, alarmFields)).next();

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
    List<EntityKey> entityFields2 = actualNextResult.getEntityFields();
    assertTrue(entityFields2.isEmpty());
    List<EntityKey> latestValues2 = actualNextResult.getLatestValues();
    assertTrue(latestValues2.isEmpty());
    List<EntityKey> alarmFields2 = actualNextResult.getAlarmFields();
    assertTrue(alarmFields2.isEmpty());
    List<KeyFilter> keyFilters2 = actualNextResult.getKeyFilters();
    assertTrue(keyFilters2.isEmpty());
    assertTrue(pageLink2.isDynamic());
    assertSame(entityFields, entityFields2);
    assertSame(latestValues, latestValues2);
    assertSame(alarmFields, alarmFields2);
    assertSame(keyFilters, keyFilters2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataQuery#AlarmDataQuery(EntityFilter, List)}
   *   <li>{@link AlarmDataQuery#toString()}
   *   <li>{@link AlarmDataQuery#getAlarmFields()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
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
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmDataQuery#AlarmDataQuery(EntityFilter, AlarmDataPageLink, List, List, List, List)}
   *   <li>{@link AlarmDataQuery#toString()}
   *   <li>{@link AlarmDataQuery#getAlarmFields()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
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
}
