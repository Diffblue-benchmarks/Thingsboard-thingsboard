package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Collection;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TbCaffeineCacheConfiguration.class, CacheSpecsMap.class})
@ExtendWith(SpringExtension.class)
class TbCaffeineCacheConfigurationDiffblueTest {
  @Autowired
  private CacheSpecsMap cacheSpecsMap;

  @Autowired
  private TbCaffeineCacheConfiguration tbCaffeineCacheConfiguration;

  /**
   * Test {@link TbCaffeineCacheConfiguration#cacheManager()}.
   * <p>
   * Method under test: {@link TbCaffeineCacheConfiguration#cacheManager()}
   */
  @Test
  @DisplayName("Test cacheManager()")
  void testCacheManager() {
    // Arrange and Act
    CacheManager actualCacheManagerResult = tbCaffeineCacheConfiguration.cacheManager();

    // Assert
    Collection<String> cacheNames = actualCacheManagerResult.getCacheNames();
    assertTrue(cacheNames instanceof Set);
    assertTrue(actualCacheManagerResult instanceof SimpleCacheManager);
    assertTrue(cacheNames.isEmpty());
  }
}
