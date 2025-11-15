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

class EntityDataQueryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataQuery#EntityDataQuery()}
   *   <li>{@link EntityDataQuery#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityDataQuery actualEntityDataQuery = new EntityDataQuery();

    // Assert
    assertEquals("EntityDataQuery(super=AbstractDataQuery(super=EntityCountQuery(entityFilter=null, keyFilters=null),"
        + " pageLink=null, entityFields=null, latestValues=null))", actualEntityDataQuery.toString());
    assertNull(actualEntityDataQuery.getEntityFields());
    assertNull(actualEntityDataQuery.getLatestValues());
    assertNull(actualEntityDataQuery.getKeyFilters());
    assertNull(actualEntityDataQuery.getPageLink());
    assertNull(actualEntityDataQuery.getEntityFilter());
  }

  /**
   * Method under test: {@link EntityDataQuery#next()}
   */
  @Test
  void testNext() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();

    // Act
    EntityDataQuery actualNextResult = (new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues,
        keyFilters)).next();

    // Assert
    EntityDataPageLink pageLink2 = actualNextResult.getPageLink();
    assertNull(pageLink2.getTextSearch());
    assertNull(pageLink2.getSortOrder());
    assertEquals(0, pageLink2.getPageSize());
    assertEquals(1, pageLink2.getPage());
    assertFalse(pageLink2.isDynamic());
    List<EntityKey> entityFields2 = actualNextResult.getEntityFields();
    assertTrue(entityFields2.isEmpty());
    List<EntityKey> latestValues2 = actualNextResult.getLatestValues();
    assertTrue(latestValues2.isEmpty());
    List<KeyFilter> keyFilters2 = actualNextResult.getKeyFilters();
    assertTrue(keyFilters2.isEmpty());
    assertSame(entityFields, entityFields2);
    assertSame(latestValues, latestValues2);
    assertSame(keyFilters, keyFilters2);
  }

  /**
   * Method under test: {@link EntityDataQuery#next()}
   */
  @Test
  void testNext2() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    AlarmDataPageLink pageLink = new AlarmDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();

    // Act
    EntityDataQuery actualNextResult = (new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues,
        keyFilters)).next();

    // Assert
    EntityDataPageLink pageLink2 = actualNextResult.getPageLink();
    assertTrue(pageLink2 instanceof AlarmDataPageLink);
    assertNull(pageLink2.getTextSearch());
    assertNull(((AlarmDataPageLink) pageLink2).getTypeList());
    assertNull(((AlarmDataPageLink) pageLink2).getStatusList());
    assertNull(((AlarmDataPageLink) pageLink2).getSeverityList());
    assertNull(((AlarmDataPageLink) pageLink2).getAssigneeId());
    assertNull(pageLink2.getSortOrder());
    assertEquals(0, pageLink2.getPageSize());
    assertEquals(0L, ((AlarmDataPageLink) pageLink2).getEndTs());
    assertEquals(0L, ((AlarmDataPageLink) pageLink2).getStartTs());
    assertEquals(0L, ((AlarmDataPageLink) pageLink2).getTimeWindow());
    assertEquals(1, pageLink2.getPage());
    assertFalse(((AlarmDataPageLink) pageLink2).isSearchPropagatedAlarms());
    assertFalse(pageLink2.isDynamic());
    List<EntityKey> entityFields2 = actualNextResult.getEntityFields();
    assertTrue(entityFields2.isEmpty());
    List<EntityKey> latestValues2 = actualNextResult.getLatestValues();
    assertTrue(latestValues2.isEmpty());
    List<KeyFilter> keyFilters2 = actualNextResult.getKeyFilters();
    assertTrue(keyFilters2.isEmpty());
    assertSame(entityFields, entityFields2);
    assertSame(latestValues, latestValues2);
    assertSame(keyFilters, keyFilters2);
  }

  /**
   * Method under test: {@link EntityDataQuery#next()}
   */
  @Test
  void testNext3() {
    // Arrange
    AlarmDataPageLink pageLink = new AlarmDataPageLink();
    pageLink.setDynamic(true);
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();

    // Act
    EntityDataQuery actualNextResult = (new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues,
        keyFilters)).next();

    // Assert
    EntityDataPageLink pageLink2 = actualNextResult.getPageLink();
    assertTrue(pageLink2 instanceof AlarmDataPageLink);
    assertNull(pageLink2.getTextSearch());
    assertNull(((AlarmDataPageLink) pageLink2).getTypeList());
    assertNull(((AlarmDataPageLink) pageLink2).getStatusList());
    assertNull(((AlarmDataPageLink) pageLink2).getSeverityList());
    assertNull(((AlarmDataPageLink) pageLink2).getAssigneeId());
    assertNull(pageLink2.getSortOrder());
    assertEquals(0, pageLink2.getPageSize());
    assertEquals(0L, ((AlarmDataPageLink) pageLink2).getEndTs());
    assertEquals(0L, ((AlarmDataPageLink) pageLink2).getStartTs());
    assertEquals(0L, ((AlarmDataPageLink) pageLink2).getTimeWindow());
    assertEquals(1, pageLink2.getPage());
    assertFalse(((AlarmDataPageLink) pageLink2).isSearchPropagatedAlarms());
    List<EntityKey> entityFields2 = actualNextResult.getEntityFields();
    assertTrue(entityFields2.isEmpty());
    List<EntityKey> latestValues2 = actualNextResult.getLatestValues();
    assertTrue(latestValues2.isEmpty());
    List<KeyFilter> keyFilters2 = actualNextResult.getKeyFilters();
    assertTrue(keyFilters2.isEmpty());
    assertTrue(pageLink2.isDynamic());
    assertSame(entityFields, entityFields2);
    assertSame(latestValues, latestValues2);
    assertSame(keyFilters, keyFilters2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataQuery#EntityDataQuery(EntityFilter, List)}
   *   <li>{@link EntityDataQuery#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();

    // Act
    EntityDataQuery actualEntityDataQuery = new EntityDataQuery(entityFilter, keyFilters);
    actualEntityDataQuery.toString();

    // Assert
    assertNull(actualEntityDataQuery.getEntityFields());
    assertNull(actualEntityDataQuery.getLatestValues());
    assertNull(actualEntityDataQuery.getPageLink());
    List<KeyFilter> keyFilters2 = actualEntityDataQuery.getKeyFilters();
    assertTrue(keyFilters2.isEmpty());
    assertSame(keyFilters, keyFilters2);
    assertSame(entityFilter, actualEntityDataQuery.getEntityFilter());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityDataQuery#EntityDataQuery(EntityFilter, EntityDataPageLink, List, List, List)}
   *   <li>{@link EntityDataQuery#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();

    // Act
    EntityDataQuery actualEntityDataQuery = new EntityDataQuery(entityFilter, pageLink, entityFields, latestValues,
        keyFilters);
    actualEntityDataQuery.toString();

    // Assert
    List<EntityKey> entityFields2 = actualEntityDataQuery.getEntityFields();
    assertTrue(entityFields2.isEmpty());
    List<EntityKey> latestValues2 = actualEntityDataQuery.getLatestValues();
    assertTrue(latestValues2.isEmpty());
    List<KeyFilter> keyFilters2 = actualEntityDataQuery.getKeyFilters();
    assertTrue(keyFilters2.isEmpty());
    assertSame(entityFields, entityFields2);
    assertSame(latestValues, latestValues2);
    assertSame(keyFilters, keyFilters2);
    assertSame(pageLink, actualEntityDataQuery.getPageLink());
    assertSame(entityFilter, actualEntityDataQuery.getEntityFilter());
  }
}
