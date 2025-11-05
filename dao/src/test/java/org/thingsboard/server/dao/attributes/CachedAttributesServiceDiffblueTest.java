package org.thingsboard.server.dao.attributes;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ExtendWith(MockitoExtension.class)
class CachedAttributesServiceDiffblueTest {
  @InjectMocks private CachedAttributesService cachedAttributesService;

  @Mock private JpaExecutorService jpaExecutorService;

  @Mock private StatsFactory statsFactory;

  /**
   * Test {@link CachedAttributesService#findAll(TenantId, EntityId, AttributeScope)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#findAll(TenantId, EntityId,
   * AttributeScope)}
   */
  @Test
  @DisplayName(
      "Test findAll(TenantId, EntityId, AttributeScope); when NULL_CUSTOMER_ID; then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CachedAttributesService.findAll(TenantId, EntityId, AttributeScope)"
  })
  void testFindAll_whenNull_customer_id_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<AttributeKvEntry>> actualFindAllResult =
        cachedAttributesService.findAll(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAllResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllResult);
  }
}
