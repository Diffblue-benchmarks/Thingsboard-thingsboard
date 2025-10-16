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
package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

@RunWith(MockitoJUnitRunner.class)
public class CassandraBaseTimeseriesLatestDaoDiffblueTest {
  @InjectMocks private CassandraBaseTimeseriesLatestDao cassandraBaseTimeseriesLatestDao;

  /**
   * Test {@link CassandraBaseTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * CassandraBaseTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CassandraBaseTimeseriesLatestDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        cassandraBaseTimeseriesLatestDao
            .findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null)
            .isEmpty());
  }

  /**
   * Test {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CassandraBaseTimeseriesLatestDao.findAllKeysByEntityIds(TenantId, List)"
  })
  public void testFindAllKeysByEntityIds_givenNull_customer_id() {
    // Arrange
    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertTrue(
        cassandraBaseTimeseriesLatestDao
            .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds)
            .isEmpty());
  }

  /**
   * Test {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CassandraBaseTimeseriesLatestDao.findAllKeysByEntityIds(TenantId, List)"
  })
  public void testFindAllKeysByEntityIds_givenNull_customer_id2() {
    // Arrange
    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertTrue(
        cassandraBaseTimeseriesLatestDao
            .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds)
            .isEmpty());
  }

  /**
   * Test {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesLatestDao#findAllKeysByEntityIds(TenantId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CassandraBaseTimeseriesLatestDao.findAllKeysByEntityIds(TenantId, List)"
  })
  public void testFindAllKeysByEntityIds_whenArrayList() {
    // Arrange, Act and Assert
    assertTrue(
        cassandraBaseTimeseriesLatestDao
            .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>())
            .isEmpty());
  }
}
