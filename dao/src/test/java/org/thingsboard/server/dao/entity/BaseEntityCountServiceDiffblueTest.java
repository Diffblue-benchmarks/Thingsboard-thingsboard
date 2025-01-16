package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;

@ContextConfiguration(classes = {BaseEntityCountService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class BaseEntityCountServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private BaseEntityCountService baseEntityCountService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityServiceRegistry entityServiceRegistry;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private TbTransactionalCache<EntityCountCacheKey, Long> tbTransactionalCache;

  /**
   * Test
   * {@link BaseEntityCountService#countByTenantIdAndEntityType(TenantId, EntityType)}.
   * <p>
   * Method under test:
   * {@link BaseEntityCountService#countByTenantIdAndEntityType(TenantId, EntityType)}
   */
  @Test
  public void testCountByTenantIdAndEntityType() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<EntityCountCacheKey>any(), Mockito.<Supplier<Long>>any(),
        anyBoolean())).thenReturn(1L);

    // Act
    long actualCountByTenantIdAndEntityTypeResult = baseEntityCountService
        .countByTenantIdAndEntityType(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(EntityCountCacheKey.class), isA(Supplier.class), eq(false));
    assertEquals(1L, actualCountByTenantIdAndEntityTypeResult);
  }

  /**
   * Test
   * {@link BaseEntityCountService#publishCountEntityEvictEvent(TenantId, EntityType)}.
   * <p>
   * Method under test:
   * {@link BaseEntityCountService#publishCountEntityEvictEvent(TenantId, EntityType)}
   */
  @Test
  public void testPublishCountEntityEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<EntityCountCacheKey>any());

    // Act
    baseEntityCountService.publishCountEntityEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(EntityCountCacheKey.class));
  }

  /**
   * Test
   * {@link BaseEntityCountService#handleEvictEvent(EntityCountCacheEvictEvent)}
   * with {@code EntityCountCacheEvictEvent}.
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityCountService#handleEvictEvent(EntityCountCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithEntityCountCacheEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<EntityCountCacheKey>any());

    // Act
    baseEntityCountService
        .handleEvictEvent(new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));

    // Assert
    verify(tbTransactionalCache).evict(isA(EntityCountCacheKey.class));
  }
}
