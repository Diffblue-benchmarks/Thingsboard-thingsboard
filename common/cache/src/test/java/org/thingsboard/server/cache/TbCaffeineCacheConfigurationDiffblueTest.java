package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Autowired private CacheSpecsMap cacheSpecsMap;

  @Autowired private TbCaffeineCacheConfiguration tbCaffeineCacheConfiguration;

  /**
   * Test {@link TbCaffeineCacheConfiguration#cacheManager()}.
   *
   * <ul>
   *   <li>Given {@link CacheSpecsMap} (default constructor) Specs is {@link HashMap#HashMap()}.
   *   <li>Then return CacheNames Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbCaffeineCacheConfiguration#cacheManager()}
   */
  @Test
  @DisplayName(
      "Test cacheManager(); given CacheSpecsMap (default constructor) Specs is HashMap(); then return CacheNames Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheManager TbCaffeineCacheConfiguration.cacheManager()"})
  void testCacheManager_givenCacheSpecsMapSpecsIsHashMap_thenReturnCacheNamesEmpty() {
    // Arrange
    CacheSpecsMap configuration = new CacheSpecsMap();
    configuration.setSpecs(new HashMap<>());

    // Act
    CacheManager actualCacheManagerResult =
        new TbCaffeineCacheConfiguration(configuration).cacheManager();

    // Assert
    Collection<String> cacheNames = actualCacheManagerResult.getCacheNames();
    assertTrue(cacheNames instanceof Set);
    assertTrue(actualCacheManagerResult instanceof SimpleCacheManager);
    assertTrue(cacheNames.isEmpty());
  }

  /**
   * Test {@link TbCaffeineCacheConfiguration#cacheManager()}.
   *
   * <ul>
   *   <li>Given {@link CacheSpecs} (default constructor) MaxSize is one.
   *   <li>Then return CacheNames size is two.
   * </ul>
   *
   * <p>Method under test: {@link TbCaffeineCacheConfiguration#cacheManager()}
   */
  @Test
  @DisplayName(
      "Test cacheManager(); given CacheSpecs (default constructor) MaxSize is one; then return CacheNames size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheManager TbCaffeineCacheConfiguration.cacheManager()"})
  void testCacheManager_givenCacheSpecsMaxSizeIsOne_thenReturnCacheNamesSizeIsTwo() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(1);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(1);
    cacheSpecs2.setTimeToLiveInMinutes(0);

    HashMap<String, CacheSpecs> specs = new HashMap<>();
    specs.put("Key", cacheSpecs2);
    specs.put("Initializing cache: {} specs {}", cacheSpecs);

    CacheSpecsMap configuration = new CacheSpecsMap();
    configuration.setSpecs(specs);

    // Act
    CacheManager actualCacheManagerResult =
        new TbCaffeineCacheConfiguration(configuration).cacheManager();

    // Assert
    Collection<String> cacheNames = actualCacheManagerResult.getCacheNames();
    assertEquals(2, cacheNames.size());
    assertTrue(cacheNames instanceof Set);
    assertTrue(actualCacheManagerResult instanceof SimpleCacheManager);
    assertTrue(cacheNames.contains("Initializing cache: {} specs {}"));
    assertTrue(cacheNames.contains("Key"));
  }

  /**
   * Test {@link TbCaffeineCacheConfiguration#cacheManager()}.
   *
   * <ul>
   *   <li>Given {@link CacheSpecs} (default constructor) MaxSize is three.
   *   <li>Then return CacheNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link TbCaffeineCacheConfiguration#cacheManager()}
   */
  @Test
  @DisplayName(
      "Test cacheManager(); given CacheSpecs (default constructor) MaxSize is three; then return CacheNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheManager TbCaffeineCacheConfiguration.cacheManager()"})
  void testCacheManager_givenCacheSpecsMaxSizeIsThree_thenReturnCacheNamesSizeIsOne() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(1);

    HashMap<String, CacheSpecs> specs = new HashMap<>();
    specs.put("Initializing cache: {} specs {}", cacheSpecs);

    CacheSpecsMap configuration = new CacheSpecsMap();
    configuration.setSpecs(specs);

    // Act
    CacheManager actualCacheManagerResult =
        new TbCaffeineCacheConfiguration(configuration).cacheManager();

    // Assert
    Collection<String> cacheNames = actualCacheManagerResult.getCacheNames();
    assertEquals(1, cacheNames.size());
    assertTrue(cacheNames instanceof Set);
    assertTrue(actualCacheManagerResult instanceof SimpleCacheManager);
    assertTrue(cacheNames.contains("Initializing cache: {} specs {}"));
  }

  /**
   * Test {@link TbCaffeineCacheConfiguration#cacheManager()}.
   *
   * <ul>
   *   <li>Given {@link TbCaffeineCacheConfiguration}.
   *   <li>Then return CacheNames Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbCaffeineCacheConfiguration#cacheManager()}
   */
  @Test
  @DisplayName(
      "Test cacheManager(); given TbCaffeineCacheConfiguration; then return CacheNames Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheManager TbCaffeineCacheConfiguration.cacheManager()"})
  void testCacheManager_givenTbCaffeineCacheConfiguration_thenReturnCacheNamesEmpty() {
    // Arrange and Act
    CacheManager actualCacheManagerResult = tbCaffeineCacheConfiguration.cacheManager();

    // Assert
    Collection<String> cacheNames = actualCacheManagerResult.getCacheNames();
    assertTrue(cacheNames instanceof Set);
    assertTrue(actualCacheManagerResult instanceof SimpleCacheManager);
    assertTrue(cacheNames.isEmpty());
  }

  /**
   * Test {@link TbCaffeineCacheConfiguration#cacheManager()}.
   *
   * <ul>
   *   <li>Then return CacheNames Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbCaffeineCacheConfiguration#cacheManager()}
   */
  @Test
  @DisplayName("Test cacheManager(); then return CacheNames Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheManager TbCaffeineCacheConfiguration.cacheManager()"})
  void testCacheManager_thenReturnCacheNamesEmpty() {
    // Arrange and Act
    CacheManager actualCacheManagerResult =
        new TbCaffeineCacheConfiguration(new CacheSpecsMap()).cacheManager();

    // Assert
    Collection<String> cacheNames = actualCacheManagerResult.getCacheNames();
    assertTrue(cacheNames instanceof Set);
    assertTrue(actualCacheManagerResult instanceof SimpleCacheManager);
    assertTrue(cacheNames.isEmpty());
  }

  /**
   * Test {@link TbCaffeineCacheConfiguration#ticker()}.
   *
   * <p>Method under test: {@link TbCaffeineCacheConfiguration#ticker()}
   */
  @Test
  @DisplayName("Test ticker()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.github.benmanes.caffeine.cache.Ticker TbCaffeineCacheConfiguration.ticker()"
  })
  void testTicker() {
    // Arrange and Act
    tbCaffeineCacheConfiguration.ticker().read();

    // Assert that nothing has changed
    assertTrue(tbCaffeineCacheConfiguration instanceof TbCaffeineCacheConfiguration);
  }

  /**
   * Test {@link TbCaffeineCacheConfiguration#ticker()}.
   *
   * <p>Method under test: {@link TbCaffeineCacheConfiguration#ticker()}
   */
  @Test
  @DisplayName("Test ticker()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.github.benmanes.caffeine.cache.Ticker TbCaffeineCacheConfiguration.ticker()"
  })
  void testTicker2() {
    // Arrange and Act
    tbCaffeineCacheConfiguration.ticker();

    // Assert that nothing has changed
    assertTrue(tbCaffeineCacheConfiguration instanceof TbCaffeineCacheConfiguration);
  }
}
