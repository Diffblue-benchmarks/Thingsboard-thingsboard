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
package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {BaseEntityCountService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseEntityCountServiceDiffblueTest {
  @Autowired private BaseEntityCountService baseEntityCountService;

  @MockBean private TbTransactionalCache<EntityCountCacheKey, Long> tbTransactionalCache;

  /**
   * Test {@link BaseEntityCountService#countByTenantIdAndEntityType(TenantId, EntityType)}.
   *
   * <p>Method under test: {@link BaseEntityCountService#countByTenantIdAndEntityType(TenantId,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long BaseEntityCountService.countByTenantIdAndEntityType(TenantId, EntityType)"
  })
  public void testCountByTenantIdAndEntityType() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<EntityCountCacheKey>any(), Mockito.<Supplier<Long>>any(), anyBoolean()))
        .thenReturn(1L);

    // Act
    long actualCountByTenantIdAndEntityTypeResult =
        baseEntityCountService.countByTenantIdAndEntityType(
            ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(EntityCountCacheKey.class), isA(Supplier.class), eq(false));
    assertEquals(1L, actualCountByTenantIdAndEntityTypeResult);
  }

  /**
   * Test {@link BaseEntityCountService#publishCountEntityEvictEvent(TenantId, EntityType)}.
   *
   * <p>Method under test: {@link BaseEntityCountService#publishCountEntityEvictEvent(TenantId,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseEntityCountService.publishCountEntityEvictEvent(TenantId, EntityType)"
  })
  public void testPublishCountEntityEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<EntityCountCacheKey>any());

    // Act
    baseEntityCountService.publishCountEntityEvictEvent(
        ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(EntityCountCacheKey.class));
  }

  /**
   * Test {@link BaseEntityCountService#handleEvictEvent(EntityCountCacheEvictEvent)} with {@code
   * EntityCountCacheEvictEvent}.
   *
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseEntityCountService#handleEvictEvent(EntityCountCacheEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEntityCountService.handleEvictEvent(EntityCountCacheEvictEvent)"})
  public void testHandleEvictEventWithEntityCountCacheEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<EntityCountCacheKey>any());

    // Act
    baseEntityCountService.handleEvictEvent(
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));

    // Assert
    verify(tbTransactionalCache).evict(isA(EntityCountCacheKey.class));
  }
}
