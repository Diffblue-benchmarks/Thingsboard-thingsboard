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
package org.thingsboard.server.dao.usage;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.EntityCountService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.TenantProfileServiceTest;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.timeseries.TimeseriesService;
import org.thingsboard.server.dao.usagerecord.ApiUsageStateService;

@ContextConfiguration(classes = {BasicUsageInfoService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BasicUsageInfoServiceDiffblueTest {
  @MockBean private ApiUsageStateService apiUsageStateService;

  @Autowired private BasicUsageInfoService basicUsageInfoService;

  @MockBean private EntityCountService entityCountService;

  @MockBean private TbTenantProfileCache tbTenantProfileCache;

  @MockBean private TimeseriesService timeseriesService;

  /**
   * Test {@link BasicUsageInfoService#getUsageInfo(TenantId)}.
   *
   * <p>Method under test: {@link BasicUsageInfoService#getUsageInfo(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.UsageInfo BasicUsageInfoService.getUsageInfo(TenantId)"
  })
  public void testGetUsageInfo() {
    // Arrange
    when(entityCountService.countByTenantIdAndEntityType(
            Mockito.<TenantId>any(), Mockito.<EntityType>any()))
        .thenThrow(new RuntimeException());
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> basicUsageInfoService.getUsageInfo(ModelConstants.SYSTEM_TENANT));
    verify(entityCountService)
        .countByTenantIdAndEntityType(isA(TenantId.class), eq(EntityType.DEVICE));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link BasicUsageInfoService#getUsageInfo(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageStateService#findTenantApiUsageState(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicUsageInfoService#getUsageInfo(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.UsageInfo BasicUsageInfoService.getUsageInfo(TenantId)"
  })
  public void testGetUsageInfo_thenCallsFindTenantApiUsageState() {
    // Arrange
    when(entityCountService.countByTenantIdAndEntityType(
            Mockito.<TenantId>any(), Mockito.<EntityType>any()))
        .thenReturn(1L);
    when(apiUsageStateService.findTenantApiUsageState(Mockito.<TenantId>any()))
        .thenThrow(new RuntimeException());
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> basicUsageInfoService.getUsageInfo(ModelConstants.SYSTEM_TENANT));
    verify(entityCountService, atLeast(1))
        .countByTenantIdAndEntityType(isA(TenantId.class), Mockito.<EntityType>any());
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    verify(apiUsageStateService).findTenantApiUsageState(isA(TenantId.class));
  }
}
