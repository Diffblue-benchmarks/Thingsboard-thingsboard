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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceCacheEvictEventDiffblueTest {
  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}, and {@link
   * DeviceCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCacheEvictEvent#equals(Object)}
   *   <li>{@link DeviceCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(null, null, "New Name", "Old Name");
    DeviceCacheEvictEvent deviceCacheEvictEvent2 =
        new DeviceCacheEvictEvent(null, null, "New Name", "Old Name");

    // Act and Assert
    assertEquals(deviceCacheEvictEvent, deviceCacheEvictEvent2);
    assertEquals(deviceCacheEvictEvent.hashCode(), deviceCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}, and {@link
   * DeviceCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCacheEvictEvent#equals(Object)}
   *   <li>{@link DeviceCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(null, null, null, "Old Name");
    DeviceCacheEvictEvent deviceCacheEvictEvent2 =
        new DeviceCacheEvictEvent(null, null, null, "Old Name");

    // Act and Assert
    assertEquals(deviceCacheEvictEvent, deviceCacheEvictEvent2);
    assertEquals(deviceCacheEvictEvent.hashCode(), deviceCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}, and {@link
   * DeviceCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCacheEvictEvent#equals(Object)}
   *   <li>{@link DeviceCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(null, null, "New Name", null);
    DeviceCacheEvictEvent deviceCacheEvictEvent2 =
        new DeviceCacheEvictEvent(null, null, "New Name", null);

    // Act and Assert
    assertEquals(deviceCacheEvictEvent, deviceCacheEvictEvent2);
    assertEquals(deviceCacheEvictEvent.hashCode(), deviceCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}, and {@link
   * DeviceCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCacheEvictEvent#equals(Object)}
   *   <li>{@link DeviceCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(null, null, "New Name", "Old Name");
    deviceCacheEvictEvent.setSavedDevice(new Device());

    DeviceCacheEvictEvent deviceCacheEvictEvent2 =
        new DeviceCacheEvictEvent(null, null, "New Name", "Old Name");
    deviceCacheEvictEvent2.setSavedDevice(new Device());

    // Act and Assert
    assertEquals(deviceCacheEvictEvent, deviceCacheEvictEvent2);
    assertEquals(deviceCacheEvictEvent.hashCode(), deviceCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(new TenantId(UUID.randomUUID()), null, "New Name", "Old Name");

    // Act and Assert
    assertNotEquals(
        deviceCacheEvictEvent,
        new DeviceCacheEvictEvent(new TenantId(UUID.randomUUID()), null, "New Name", "Old Name"));
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(null, null, "New Name", "Old Name");

    // Act and Assert
    assertNotEquals(
        deviceCacheEvictEvent,
        new DeviceCacheEvictEvent(new TenantId(UUID.randomUUID()), null, "New Name", "Old Name"));
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DeviceCacheEvictEvent(new TenantId(UUID.randomUUID()), null, "New Name", "Old Name"),
        1);
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(null, new DeviceId(UUID.randomUUID()), "New Name", "Old Name");

    // Act and Assert
    assertNotEquals(
        deviceCacheEvictEvent, new DeviceCacheEvictEvent(null, null, "New Name", "Old Name"));
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(null, null, "Old Name", "Old Name");

    // Act and Assert
    assertNotEquals(
        deviceCacheEvictEvent, new DeviceCacheEvictEvent(null, null, "New Name", "Old Name"));
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(null, null, null, "Old Name");

    // Act and Assert
    assertNotEquals(
        deviceCacheEvictEvent, new DeviceCacheEvictEvent(null, null, "New Name", "Old Name"));
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(null, null, "New Name", "New Name");

    // Act and Assert
    assertNotEquals(
        deviceCacheEvictEvent, new DeviceCacheEvictEvent(null, null, "New Name", "Old Name"));
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(null, null, "New Name", null);

    // Act and Assert
    assertNotEquals(
        deviceCacheEvictEvent, new DeviceCacheEvictEvent(null, null, "New Name", "Old Name"));
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(null, null, "New Name", "Old Name");

    // Act and Assert
    assertNotEquals(
        deviceCacheEvictEvent,
        new DeviceCacheEvictEvent(null, new DeviceId(UUID.randomUUID()), "New Name", "Old Name"));
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(null, null, "New Name", "Old Name");
    deviceCacheEvictEvent.setSavedDevice(new Device());

    // Act and Assert
    assertNotEquals(
        deviceCacheEvictEvent, new DeviceCacheEvictEvent(null, null, "New Name", "Old Name"));
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCacheEvictEvent.equals(Object)",
    "int DeviceCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent =
        new DeviceCacheEvictEvent(null, null, "New Name", "Old Name");

    DeviceCacheEvictEvent deviceCacheEvictEvent2 =
        new DeviceCacheEvictEvent(null, null, "New Name", "Old Name");
    deviceCacheEvictEvent2.setSavedDevice(new Device());

    // Act and Assert
    assertNotEquals(deviceCacheEvictEvent, deviceCacheEvictEvent2);
  }
}
