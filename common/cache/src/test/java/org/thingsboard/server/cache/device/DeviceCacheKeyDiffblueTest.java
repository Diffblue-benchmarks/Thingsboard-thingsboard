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
   *   <li>Given {@link DeviceId#DeviceId(UUID)} with id is randomUUID.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheKey#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); given DeviceId(UUID) with id is randomUUID; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceCacheKey.isVersioned()"})
  void testIsVersioned_givenDeviceIdWithIdIsRandomUUID_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new DeviceCacheKey(new DeviceId(UUID.randomUUID())).isVersioned());
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
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceCacheKey deviceCacheKey =
        DeviceCacheKey.builder().deviceId(null).deviceName(null).tenantId(null).build();
    DeviceCacheKey deviceCacheKey2 =
        DeviceCacheKey.builder().deviceId(null).deviceName(null).tenantId(null).build();

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
    DeviceCacheKeyBuilder deviceNameResult =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name");
    DeviceCacheKey deviceCacheKey = deviceNameResult.tenantId(new TenantId(null)).build();

    DeviceCacheKeyBuilder deviceNameResult2 =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name");
    DeviceCacheKey deviceCacheKey2 = deviceNameResult2.tenantId(new TenantId(null)).build();

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
        deviceCacheKey, deviceNameResult2.tenantId(new TenantId(UUID.randomUUID())).build());
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
        deviceCacheKey, deviceNameResult.tenantId(new TenantId(UUID.randomUUID())).build());
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
    DeviceCacheKey deviceCacheKey =
        builderResult
            .deviceId(new DeviceId(UUID.randomUUID()))
            .deviceName("Device Name")
            .tenantId(null)
            .build();

    // Act and Assert
    assertNotEquals(
        deviceCacheKey,
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name").tenantId(null).build());
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
    DeviceCacheKey deviceCacheKey =
        DeviceCacheKey.builder().deviceId(null).deviceName(null).tenantId(null).build();

    // Act and Assert
    assertNotEquals(
        deviceCacheKey,
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name").tenantId(null).build());
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
    DeviceCacheKey deviceCacheKey =
        DeviceCacheKey.builder().deviceId(null).deviceName("42").tenantId(null).build();

    // Act and Assert
    assertNotEquals(
        deviceCacheKey,
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name").tenantId(null).build());
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
    DeviceCacheKey deviceCacheKey =
        DeviceCacheKey.builder().deviceId(null).deviceName("Device Name").tenantId(null).build();

    DeviceCacheKeyBuilder builderResult = DeviceCacheKey.builder();

    // Act and Assert
    assertNotEquals(
        deviceCacheKey,
        builderResult
            .deviceId(new DeviceId(UUID.randomUUID()))
            .deviceName("Device Name")
            .tenantId(null)
            .build());
  }
}
