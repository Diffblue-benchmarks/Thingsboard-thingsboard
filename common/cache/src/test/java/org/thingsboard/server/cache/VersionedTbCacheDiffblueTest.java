package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.server.cache.device.DeviceCacheKey;
import org.thingsboard.server.cache.device.DeviceCaffeineCache;
import org.thingsboard.server.common.data.Device;

class VersionedTbCacheDiffblueTest {
  /**
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)} with {@code DeviceCacheKey}, {@code Supplier}, {@code boolean}.
   * <ul>
   *   <li>Given {@link Device#Device()}.</li>
   *   <li>Then return {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)}
   */
  @Test
  @DisplayName("Test get(VersionedCacheKey, Supplier, boolean) with 'DeviceCacheKey', 'Supplier', 'boolean'; given Device(); then return Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.Serializable VersionedTbCache.get(VersionedCacheKey, Supplier, boolean)"})
  void testGetWithDeviceCacheKeySupplierBoolean_givenDevice_thenReturnDevice() {
    // Arrange
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(new CaffeineCacheManager());
    DeviceCacheKey deviceCacheKey = new DeviceCacheKey(null);
    Supplier<Device> supplier = mock(Supplier.class);
    Device device = new Device();
    when(supplier.get()).thenReturn(device);

    // Act
    Device actualGetResult = deviceCaffeineCache.get(deviceCacheKey, supplier, true);

    // Assert
    verify(supplier).get();
    assertSame(device, actualGetResult);
  }

  /**
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)} with {@code DeviceCacheKey}, {@code Supplier}, {@code boolean}.
   * <ul>
   *   <li>Given {@link Device}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link Supplier#get()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)}
   */
  @Test
  @DisplayName("Test get(VersionedCacheKey, Supplier, boolean) with 'DeviceCacheKey', 'Supplier', 'boolean'; given Device; when 'false'; then calls get()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.Serializable VersionedTbCache.get(VersionedCacheKey, Supplier, boolean)"})
  void testGetWithDeviceCacheKeySupplierBoolean_givenDevice_whenFalse_thenCallsGet() {
    // Arrange
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(new CaffeineCacheManager());
    DeviceCacheKey deviceCacheKey = new DeviceCacheKey(null);
    Supplier<Device> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn(mock(Device.class));

    // Act
    deviceCaffeineCache.get(deviceCacheKey, supplier, false);

    // Assert
    verify(supplier).get();
  }

  /**
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)} with {@code DeviceCacheKey}, {@code Supplier}, {@code boolean}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)}
   */
  @Test
  @DisplayName("Test get(VersionedCacheKey, Supplier, boolean) with 'DeviceCacheKey', 'Supplier', 'boolean'; given 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.Serializable VersionedTbCache.get(VersionedCacheKey, Supplier, boolean)"})
  void testGetWithDeviceCacheKeySupplierBoolean_givenNull_thenReturnNull() {
    // Arrange
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(new CaffeineCacheManager());
    DeviceCacheKey deviceCacheKey = new DeviceCacheKey(null);
    Supplier<Device> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn(null);

    // Act
    Device actualGetResult = deviceCaffeineCache.get(deviceCacheKey, supplier, true);

    // Assert
    verify(supplier).get();
    assertNull(actualGetResult);
  }

  /**
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)} with {@code DeviceCacheKey}, {@code Supplier}, {@code boolean}.
   * <ul>
   *   <li>Then calls {@link Device#getVersion()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)}
   */
  @Test
  @DisplayName("Test get(VersionedCacheKey, Supplier, boolean) with 'DeviceCacheKey', 'Supplier', 'boolean'; then calls getVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.Serializable VersionedTbCache.get(VersionedCacheKey, Supplier, boolean)"})
  void testGetWithDeviceCacheKeySupplierBoolean_thenCallsGetVersion() {
    // Arrange
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(new CaffeineCacheManager());
    DeviceCacheKey deviceCacheKey = new DeviceCacheKey(null);
    Device device = mock(Device.class);
    when(device.getVersion()).thenReturn(1L);
    Supplier<Device> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn(device);

    // Act
    deviceCaffeineCache.get(deviceCacheKey, supplier, true);

    // Assert
    verify(supplier).get();
    verify(device, atLeast(1)).getVersion();
  }

  /**
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier)} with {@code DeviceCacheKey}, {@code Supplier}.
   * <ul>
   *   <li>Given {@link Device#Device()}.</li>
   *   <li>Then return {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier)}
   */
  @Test
  @DisplayName("Test get(VersionedCacheKey, Supplier) with 'DeviceCacheKey', 'Supplier'; given Device(); then return Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.Serializable VersionedTbCache.get(VersionedCacheKey, Supplier)"})
  void testGetWithDeviceCacheKeySupplier_givenDevice_thenReturnDevice() {
    // Arrange
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(new CaffeineCacheManager());
    DeviceCacheKey deviceCacheKey = new DeviceCacheKey(null);
    Supplier<Device> supplier = mock(Supplier.class);
    Device device = new Device();
    when(supplier.get()).thenReturn(device);

    // Act
    Device actualGetResult = deviceCaffeineCache.get(deviceCacheKey, supplier);

    // Assert
    verify(supplier).get();
    assertSame(device, actualGetResult);
  }

  /**
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier)} with {@code DeviceCacheKey}, {@code Supplier}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier)}
   */
  @Test
  @DisplayName("Test get(VersionedCacheKey, Supplier) with 'DeviceCacheKey', 'Supplier'; given 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.Serializable VersionedTbCache.get(VersionedCacheKey, Supplier)"})
  void testGetWithDeviceCacheKeySupplier_givenNull_thenReturnNull() {
    // Arrange
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(new CaffeineCacheManager());
    DeviceCacheKey deviceCacheKey = new DeviceCacheKey(null);
    Supplier<Device> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn(null);

    // Act
    Device actualGetResult = deviceCaffeineCache.get(deviceCacheKey, supplier);

    // Assert
    verify(supplier).get();
    assertNull(actualGetResult);
  }

  /**
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier)} with {@code DeviceCacheKey}, {@code Supplier}.
   * <ul>
   *   <li>Then calls {@link Device#getVersion()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier)}
   */
  @Test
  @DisplayName("Test get(VersionedCacheKey, Supplier) with 'DeviceCacheKey', 'Supplier'; then calls getVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.Serializable VersionedTbCache.get(VersionedCacheKey, Supplier)"})
  void testGetWithDeviceCacheKeySupplier_thenCallsGetVersion() {
    // Arrange
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(new CaffeineCacheManager());
    DeviceCacheKey deviceCacheKey = new DeviceCacheKey(null);
    Device device = mock(Device.class);
    when(device.getVersion()).thenReturn(1L);
    Supplier<Device> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn(device);

    // Act
    deviceCaffeineCache.get(deviceCacheKey, supplier);

    // Assert
    verify(supplier).get();
    verify(device, atLeast(1)).getVersion();
  }
}
