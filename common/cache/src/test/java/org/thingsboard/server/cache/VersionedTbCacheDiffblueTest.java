package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
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
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)} with {@code
   * DeviceCacheKey}, {@code Supplier}, {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()}.
   *   <li>Then return {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)}
   */
  @Test
  @DisplayName(
      "Test get(VersionedCacheKey, Supplier, boolean) with 'DeviceCacheKey', 'Supplier', 'boolean'; given Device(); then return Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serializable VersionedTbCache.get(VersionedCacheKey, Supplier, boolean)"})
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
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)} with {@code
   * DeviceCacheKey}, {@code Supplier}, {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link Device}.
   *   <li>When {@code false}.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)}
   */
  @Test
  @DisplayName(
      "Test get(VersionedCacheKey, Supplier, boolean) with 'DeviceCacheKey', 'Supplier', 'boolean'; given Device; when 'false'; then calls get()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serializable VersionedTbCache.get(VersionedCacheKey, Supplier, boolean)"})
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
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)} with {@code
   * DeviceCacheKey}, {@code Supplier}, {@code boolean}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)}
   */
  @Test
  @DisplayName(
      "Test get(VersionedCacheKey, Supplier, boolean) with 'DeviceCacheKey', 'Supplier', 'boolean'; given 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serializable VersionedTbCache.get(VersionedCacheKey, Supplier, boolean)"})
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
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)} with {@code
   * DeviceCacheKey}, {@code Supplier}, {@code boolean}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getVersion()}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier, boolean)}
   */
  @Test
  @DisplayName(
      "Test get(VersionedCacheKey, Supplier, boolean) with 'DeviceCacheKey', 'Supplier', 'boolean'; then calls getVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serializable VersionedTbCache.get(VersionedCacheKey, Supplier, boolean)"})
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
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier)} with {@code DeviceCacheKey},
   * {@code Supplier}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()}.
   *   <li>Then return {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier)}
   */
  @Test
  @DisplayName(
      "Test get(VersionedCacheKey, Supplier) with 'DeviceCacheKey', 'Supplier'; given Device(); then return Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serializable VersionedTbCache.get(VersionedCacheKey, Supplier)"})
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
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier)} with {@code DeviceCacheKey},
   * {@code Supplier}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier)}
   */
  @Test
  @DisplayName(
      "Test get(VersionedCacheKey, Supplier) with 'DeviceCacheKey', 'Supplier'; given 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serializable VersionedTbCache.get(VersionedCacheKey, Supplier)"})
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
   * Test {@link VersionedTbCache#get(VersionedCacheKey, Supplier)} with {@code DeviceCacheKey},
   * {@code Supplier}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getVersion()}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedTbCache#get(VersionedCacheKey, Supplier)}
   */
  @Test
  @DisplayName(
      "Test get(VersionedCacheKey, Supplier) with 'DeviceCacheKey', 'Supplier'; then calls getVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serializable VersionedTbCache.get(VersionedCacheKey, Supplier)"})
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

  /**
   * Test {@link VersionedTbCache#getVersion(Serializable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Device} {@link Device#getVersion()} return one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link VersionedTbCache#getVersion(Serializable)}
   */
  @Test
  @DisplayName(
      "Test getVersion(Serializable); given one; when Device getVersion() return one; then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long VersionedTbCache.getVersion(Serializable)"})
  void testGetVersion_givenOne_whenDeviceGetVersionReturnOne_thenReturnLongValueIsOne() {
    // Arrange
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(new CaffeineCacheManager());
    Device device = mock(Device.class);
    when(device.getVersion()).thenReturn(1L);

    // Act
    Long actualVersion = deviceCaffeineCache.getVersion(device);

    // Assert
    verify(device, atLeast(1)).getVersion();
    assertEquals(1L, actualVersion.longValue());
  }

  /**
   * Test {@link VersionedTbCache#getVersion(Serializable)}.
   *
   * <ul>
   *   <li>When {@link Device#Device()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedTbCache#getVersion(Serializable)}
   */
  @Test
  @DisplayName("Test getVersion(Serializable); when Device(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long VersionedTbCache.getVersion(Serializable)"})
  void testGetVersion_whenDevice_thenReturnNull() {
    // Arrange
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(new CaffeineCacheManager());

    // Act and Assert
    assertNull(deviceCaffeineCache.getVersion(new Device()));
  }

  /**
   * Test {@link VersionedTbCache#getVersion(Serializable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link VersionedTbCache#getVersion(Serializable)}
   */
  @Test
  @DisplayName("Test getVersion(Serializable); when 'null'; then return longValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long VersionedTbCache.getVersion(Serializable)"})
  void testGetVersion_whenNull_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(
        0L, new DeviceCaffeineCache(new CaffeineCacheManager()).getVersion(null).longValue());
  }
}
