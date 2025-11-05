package org.thingsboard.server.dao.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {BaseEntityCountService.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class BaseEntityCountServiceDiffblueTest {
  @Autowired private BaseEntityCountService baseEntityCountService;

  @MockBean private TbTransactionalCache<EntityCountCacheKey, Long> tbTransactionalCache;

  /**
   * Test {@link BaseEntityCountService#countByTenantIdAndEntityType(TenantId, EntityType)}.
   *
   * <p>Method under test: {@link BaseEntityCountService#countByTenantIdAndEntityType(TenantId,
   * EntityType)}
   */
  @Test
  @DisplayName("Test countByTenantIdAndEntityType(TenantId, EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long BaseEntityCountService.countByTenantIdAndEntityType(TenantId, EntityType)"
  })
  void testCountByTenantIdAndEntityType() {
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
  @DisplayName("Test publishCountEntityEvictEvent(TenantId, EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseEntityCountService.publishCountEntityEvictEvent(TenantId, EntityType)"
  })
  void testPublishCountEntityEvictEvent() {
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
  @DisplayName(
      "Test handleEvictEvent(EntityCountCacheEvictEvent) with 'EntityCountCacheEvictEvent'; then calls evict(Serializable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEntityCountService.handleEvictEvent(EntityCountCacheEvictEvent)"})
  void testHandleEvictEventWithEntityCountCacheEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<EntityCountCacheKey>any());

    // Act
    baseEntityCountService.handleEvictEvent(
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));

    // Assert
    verify(tbTransactionalCache).evict(isA(EntityCountCacheKey.class));
  }
}
