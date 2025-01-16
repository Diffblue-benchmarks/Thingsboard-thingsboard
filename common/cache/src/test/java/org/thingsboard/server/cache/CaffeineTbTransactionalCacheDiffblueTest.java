package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cache.customer.CustomerCacheKey;
import org.thingsboard.server.cache.customer.CustomerCaffeineCache;
import org.thingsboard.server.common.data.Customer;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class CaffeineTbTransactionalCacheDiffblueTest {
  @MockBean
  private CacheManager cacheManager;

  @Autowired
  private CaffeineTbTransactionalCache<CustomerCacheKey, Customer> caffeineTbTransactionalCache;

  @MockBean
  private CustomerCaffeineCache customerCaffeineCache;

  /**
   * Test {@link CaffeineTbTransactionalCache#commit(UUID, Map)}.
   * <ul>
   *   <li>Given {@link CustomerCaffeineCache}
   * {@link CaffeineTbTransactionalCache#commit(UUID, Map)} return
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CaffeineTbTransactionalCache#commit(UUID, Map)}
   */
  @Test
  @DisplayName("Test commit(UUID, Map); given CustomerCaffeineCache commit(UUID, Map) return 'true'; then return 'true'")
  void testCommit_givenCustomerCaffeineCacheCommitReturnTrue_thenReturnTrue() {
    // Arrange
    when(customerCaffeineCache.commit(Mockito.<UUID>any(), Mockito.<Map<CustomerCacheKey, Customer>>any()))
        .thenReturn(true);
    UUID trId = UUID.randomUUID();

    // Act
    boolean actualCommitResult = caffeineTbTransactionalCache.commit(trId, new HashMap<>());

    // Assert
    verify(customerCaffeineCache).commit(isA(UUID.class), isA(Map.class));
    assertTrue(actualCommitResult);
  }
}
