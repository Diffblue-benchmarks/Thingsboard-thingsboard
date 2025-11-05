package org.thingsboard.server.cache.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.cache.device.DeviceCacheKey.DeviceCacheKeyBuilder;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceCacheKeyDiffblueTest {
  /**
   * Test {@link DeviceCacheKey#toString()}.
   *
   * <p>Method under test: {@link DeviceCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DeviceCacheKey.toString()"})
  void testToString() {
    // Arrange
    DeviceCacheKeyBuilder builderResult = DeviceCacheKey.builder();

    DeviceCacheKeyBuilder deviceNameResult =
        builderResult
            .deviceId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceName("Device Name");

    // Act and Assert
    assertEquals(
        "784f394c-42b6-435a-983c-b7beff2784f9_784f394c-42b6-435a-983c-b7beff2784f9",
        deviceNameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build()
            .toString());
  }

  /**
   * Test {@link DeviceCacheKey#toString()}.
   *
   * <ul>
   *   <li>Given {@link DeviceCacheKey#DeviceCacheKey(DeviceId)} with deviceId is {@code null}.
   *   <li>Then return {@code null_n_null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheKey#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given DeviceCacheKey(DeviceId) with deviceId is 'null'; then return 'null_n_null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DeviceCacheKey.toString()"})
  void testToString_givenDeviceCacheKeyWithDeviceIdIsNull_thenReturnNullNNull() {
    // Arrange, Act and Assert
    assertEquals("null_n_null", new DeviceCacheKey(null).toString());
  }

  /**
   * Test {@link DeviceCacheKey#toString()}.
   *
   * <ul>
   *   <li>Then return {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DeviceCacheKey.toString()"})
  void testToString_thenReturn784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", new DeviceCacheKey(deviceId).toString());
  }

  /**
   * Test {@link DeviceCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Given {@link DeviceCacheKey#DeviceCacheKey(DeviceId)} with deviceId is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheKey#isVersioned()}
   */
  @Test
  @DisplayName(
      "Test isVersioned(); given DeviceCacheKey(DeviceId) with deviceId is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceCacheKey.isVersioned()"})
  void testIsVersioned_givenDeviceCacheKeyWithDeviceIdIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new DeviceCacheKey(null).isVersioned());
  }

  /**
   * Test {@link DeviceCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheKey#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceCacheKey.isVersioned()"})
  void testIsVersioned_thenReturnTrue() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertTrue(new DeviceCacheKey(deviceId).isVersioned());
  }

  /**
   * Test {@link DeviceCacheKey#equals(Object)}, and {@link DeviceCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCacheKey#equals(Object)}
   *   <li>{@link DeviceCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceCacheKey.equals(Object)", "int DeviceCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceCacheKeyBuilder deviceNameResult =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name");
    DeviceCacheKey deviceCacheKey =
        deviceNameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    DeviceCacheKeyBuilder deviceNameResult2 =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name");
    DeviceCacheKey deviceCacheKey2 =
        deviceNameResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    // Act and Assert
    assertEquals(deviceCacheKey, deviceCacheKey2);
    assertEquals(deviceCacheKey.hashCode(), deviceCacheKey2.hashCode());
  }

  /**
   * Test {@link DeviceCacheKey#equals(Object)}, and {@link DeviceCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCacheKey#equals(Object)}
   *   <li>{@link DeviceCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceCacheKey.equals(Object)", "int DeviceCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceCacheKey deviceCacheKey =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name").tenantId(null).build();
    DeviceCacheKey deviceCacheKey2 =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name").tenantId(null).build();

    // Act and Assert
    assertEquals(deviceCacheKey, deviceCacheKey2);
    assertEquals(deviceCacheKey.hashCode(), deviceCacheKey2.hashCode());
  }

  /**
   * Test {@link DeviceCacheKey#equals(Object)}, and {@link DeviceCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCacheKey#equals(Object)}
   *   <li>{@link DeviceCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceCacheKey.equals(Object)", "int DeviceCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceCacheKeyBuilder builderResult = DeviceCacheKey.builder();

    DeviceCacheKeyBuilder deviceNameResult =
        builderResult
            .deviceId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceName("Device Name");
    DeviceCacheKey deviceCacheKey =
        deviceNameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    DeviceCacheKeyBuilder builderResult2 = DeviceCacheKey.builder();

    DeviceCacheKeyBuilder deviceNameResult2 =
        builderResult2
            .deviceId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceName("Device Name");
    DeviceCacheKey deviceCacheKey2 =
        deviceNameResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    // Act and Assert
    assertEquals(deviceCacheKey, deviceCacheKey2);
    assertEquals(deviceCacheKey.hashCode(), deviceCacheKey2.hashCode());
  }

  /**
   * Test {@link DeviceCacheKey#equals(Object)}, and {@link DeviceCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCacheKey#equals(Object)}
   *   <li>{@link DeviceCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceCacheKey.equals(Object)", "int DeviceCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DeviceCacheKeyBuilder deviceNameResult =
        DeviceCacheKey.builder().deviceId(null).deviceName(null);
    DeviceCacheKey deviceCacheKey =
        deviceNameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    DeviceCacheKeyBuilder deviceNameResult2 =
        DeviceCacheKey.builder().deviceId(null).deviceName(null);
    DeviceCacheKey deviceCacheKey2 =
        deviceNameResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    // Act and Assert
    assertEquals(deviceCacheKey, deviceCacheKey2);
    assertEquals(deviceCacheKey.hashCode(), deviceCacheKey2.hashCode());
  }

  /**
   * Test {@link DeviceCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceCacheKey.equals(Object)", "int DeviceCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceCacheKeyBuilder deviceNameResult =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name");
    DeviceCacheKey deviceCacheKey =
        deviceNameResult.tenantId(new TenantId(UUID.randomUUID())).build();

    DeviceCacheKeyBuilder deviceNameResult2 =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name");

    // Act and Assert
    assertNotEquals(
        deviceCacheKey,
        deviceNameResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }

  /**
   * Test {@link DeviceCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceCacheKey.equals(Object)", "int DeviceCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceCacheKey deviceCacheKey =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name").tenantId(null).build();

    DeviceCacheKeyBuilder deviceNameResult =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name");

    // Act and Assert
    assertNotEquals(
        deviceCacheKey,
        deviceNameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }

  /**
   * Test {@link DeviceCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceCacheKey.equals(Object)", "int DeviceCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceCacheKeyBuilder builderResult = DeviceCacheKey.builder();

    DeviceCacheKeyBuilder deviceNameResult =
        builderResult
            .deviceId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceName("Device Name");
    DeviceCacheKey deviceCacheKey =
        deviceNameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    DeviceCacheKeyBuilder deviceNameResult2 =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name");

    // Act and Assert
    assertNotEquals(
        deviceCacheKey,
        deviceNameResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }

  /**
   * Test {@link DeviceCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceCacheKey.equals(Object)", "int DeviceCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceCacheKeyBuilder deviceNameResult =
        DeviceCacheKey.builder().deviceId(null).deviceName(null);
    DeviceCacheKey deviceCacheKey =
        deviceNameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    DeviceCacheKeyBuilder deviceNameResult2 =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name");

    // Act and Assert
    assertNotEquals(
        deviceCacheKey,
        deviceNameResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }

  /**
   * Test {@link DeviceCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceCacheKey.equals(Object)", "int DeviceCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceCacheKeyBuilder deviceNameResult =
        DeviceCacheKey.builder().deviceId(null).deviceName("42");
    DeviceCacheKey deviceCacheKey =
        deviceNameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    DeviceCacheKeyBuilder deviceNameResult2 =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name");

    // Act and Assert
    assertNotEquals(
        deviceCacheKey,
        deviceNameResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }

  /**
   * Test {@link DeviceCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceCacheKey.equals(Object)", "int DeviceCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceCacheKeyBuilder deviceNameResult =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name");
    DeviceCacheKey deviceCacheKey =
        deviceNameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    DeviceCacheKeyBuilder builderResult = DeviceCacheKey.builder();

    DeviceCacheKeyBuilder deviceNameResult2 =
        builderResult
            .deviceId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceName("Device Name");

    // Act and Assert
    assertNotEquals(
        deviceCacheKey,
        deviceNameResult2
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());
  }
}
