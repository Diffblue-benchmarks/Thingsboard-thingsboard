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
package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.AlarmData;
import org.thingsboard.server.common.data.query.EntityDataPageLink;
import org.thingsboard.server.common.data.query.EntityDataSortOrder;
import org.thingsboard.server.dao.entity.BaseEntityService;

public class AlarmDataAdapterDiffblueTest {
  /**
   * Test {@link AlarmDataAdapter#createAlarmData(EntityDataPageLink, List, int, Collection)}.
   *
   * <p>Method under test: {@link AlarmDataAdapter#createAlarmData(EntityDataPageLink, List, int,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData AlarmDataAdapter.createAlarmData(EntityDataPageLink, List, int, Collection)"
  })
  public void testCreateAlarmData() {
    // Arrange
    EntityDataPageLink pageLink =
        new EntityDataPageLink(3, 1, "Text Search", new EntityDataSortOrder());
    ArrayList<Map<String, Object>> rows = new ArrayList<>();

    // Act
    PageData<AlarmData> actualCreateAlarmDataResult =
        AlarmDataAdapter.createAlarmData(pageLink, rows, 1, new ArrayList<>());

    // Assert
    assertEquals(1, actualCreateAlarmDataResult.getTotalPages());
    assertEquals(1L, actualCreateAlarmDataResult.getTotalElements());
    assertFalse(actualCreateAlarmDataResult.hasNext());
    assertTrue(actualCreateAlarmDataResult.getData().isEmpty());
  }

  /**
   * Test {@link AlarmDataAdapter#createAlarmData(EntityDataPageLink, List, int, Collection)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmDataAdapter#createAlarmData(EntityDataPageLink, List, int,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData AlarmDataAdapter.createAlarmData(EntityDataPageLink, List, int, Collection)"
  })
  public void testCreateAlarmData_givenNull_customer_id_whenArrayListAddNull_customer_id() {
    // Arrange
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<Map<String, Object>> rows = new ArrayList<>();

    ArrayList<EntityId> orderedEntityIds = new ArrayList<>();
    orderedEntityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    PageData<AlarmData> actualCreateAlarmDataResult =
        AlarmDataAdapter.createAlarmData(pageLink, rows, 1, orderedEntityIds);

    // Assert
    assertEquals(1, actualCreateAlarmDataResult.getTotalPages());
    assertEquals(1L, actualCreateAlarmDataResult.getTotalElements());
    assertFalse(actualCreateAlarmDataResult.hasNext());
    assertTrue(actualCreateAlarmDataResult.getData().isEmpty());
  }

  /**
   * Test {@link AlarmDataAdapter#createAlarmData(EntityDataPageLink, List, int, Collection)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return hasNext.
   * </ul>
   *
   * <p>Method under test: {@link AlarmDataAdapter#createAlarmData(EntityDataPageLink, List, int,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData AlarmDataAdapter.createAlarmData(EntityDataPageLink, List, int, Collection)"
  })
  public void testCreateAlarmData_givenThree_thenReturnHasNext() {
    // Arrange
    EntityDataPageLink pageLink = new EntityDataPageLink();
    pageLink.setPageSize(3);
    ArrayList<Map<String, Object>> rows = new ArrayList<>();

    // Act
    PageData<AlarmData> actualCreateAlarmDataResult =
        AlarmDataAdapter.createAlarmData(pageLink, rows, 1, new ArrayList<>());

    // Assert
    assertEquals(1, actualCreateAlarmDataResult.getTotalPages());
    assertEquals(1L, actualCreateAlarmDataResult.getTotalElements());
    assertTrue(actualCreateAlarmDataResult.getData().isEmpty());
    assertTrue(actualCreateAlarmDataResult.hasNext());
  }

  /**
   * Test {@link AlarmDataAdapter#createAlarmData(EntityDataPageLink, List, int, Collection)}.
   *
   * <ul>
   *   <li>When {@link EntityDataPageLink#EntityDataPageLink()}.
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link AlarmDataAdapter#createAlarmData(EntityDataPageLink, List, int,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData AlarmDataAdapter.createAlarmData(EntityDataPageLink, List, int, Collection)"
  })
  public void testCreateAlarmData_whenEntityDataPageLink_thenReturnNotHasNext() {
    // Arrange
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<Map<String, Object>> rows = new ArrayList<>();

    // Act
    PageData<AlarmData> actualCreateAlarmDataResult =
        AlarmDataAdapter.createAlarmData(pageLink, rows, 1, new ArrayList<>());

    // Assert
    assertEquals(1, actualCreateAlarmDataResult.getTotalPages());
    assertEquals(1L, actualCreateAlarmDataResult.getTotalElements());
    assertFalse(actualCreateAlarmDataResult.hasNext());
    assertTrue(actualCreateAlarmDataResult.getData().isEmpty());
  }
}
