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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceProfileInfoDiffblueTest {
  /**
   * Test {@link DeviceProfileInfo#DeviceProfileInfo(DeviceProfile)}.
   *
   * <p>Method under test: {@link DeviceProfileInfo#DeviceProfileInfo(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfileInfo(DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileInfo.<init>(DeviceProfile)"})
  void testNewDeviceProfileInfo() {
    // Arrange and Act
    DeviceProfileInfo actualDeviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());

    // Assert
    assertNull(actualDeviceProfileInfo.getImage());
    assertNull(actualDeviceProfileInfo.getName());
    assertNull(actualDeviceProfileInfo.getType());
    assertNull(actualDeviceProfileInfo.getTransportType());
    assertNull(actualDeviceProfileInfo.getDefaultDashboardId());
    assertNull(actualDeviceProfileInfo.getId());
    assertNull(actualDeviceProfileInfo.getTenantId());
  }

  /**
   * Test {@link DeviceProfileInfo#DeviceProfileInfo(UUID, UUID, String, String, UUID,
   * DeviceProfileType, DeviceTransportType)}.
   *
   * <ul>
   *   <li>Then return DefaultDashboardId EntityType is {@code DASHBOARD}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#DeviceProfileInfo(UUID, UUID, String, String,
   * UUID, DeviceProfileType, DeviceTransportType)}
   */
  @Test
  @DisplayName(
      "Test new DeviceProfileInfo(UUID, UUID, String, String, UUID, DeviceProfileType, DeviceTransportType); then return DefaultDashboardId EntityType is 'DASHBOARD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProfileInfo.<init>(UUID, UUID, String, String, UUID, DeviceProfileType, DeviceTransportType)"
  })
  void testNewDeviceProfileInfo_thenReturnDefaultDashboardIdEntityTypeIsDashboard() {
    // Arrange
    UUID defaultDashboardId = EntityId.NULL_UUID;

    // Act
    DeviceProfileInfo actualDeviceProfileInfo =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            defaultDashboardId,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Assert
    EntityId id = actualDeviceProfileInfo.getId();
    assertTrue(id instanceof DeviceProfileId);
    DashboardId defaultDashboardId2 = actualDeviceProfileInfo.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId2.getEntityType());
    assertTrue(defaultDashboardId2.isNullUid());
    UUID id2 = defaultDashboardId2.getId();
    assertSame(id2, id.getId());
    assertSame(id2, actualDeviceProfileInfo.getTenantId().getId());
    assertSame(defaultDashboardId, id2);
  }

  /**
   * Test {@link DeviceProfileInfo#DeviceProfileInfo(UUID, UUID, String, String, UUID,
   * DeviceProfileType, DeviceTransportType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Image}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#DeviceProfileInfo(UUID, UUID, String, String,
   * UUID, DeviceProfileType, DeviceTransportType)}
   */
  @Test
  @DisplayName(
      "Test new DeviceProfileInfo(UUID, UUID, String, String, UUID, DeviceProfileType, DeviceTransportType); when 'null'; then return 'Image'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProfileInfo.<init>(UUID, UUID, String, String, UUID, DeviceProfileType, DeviceTransportType)"
  })
  void testNewDeviceProfileInfo_whenNull_thenReturnImage() {
    // Arrange
    UUID tenantId = EntityId.NULL_UUID;

    // Act
    DeviceProfileInfo actualDeviceProfileInfo =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            tenantId,
            "Name",
            "Image",
            null,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Assert
    EntityId id = actualDeviceProfileInfo.getId();
    assertTrue(id instanceof DeviceProfileId);
    assertEquals("Image", actualDeviceProfileInfo.getImage());
    assertEquals("Name", actualDeviceProfileInfo.getName());
    assertNull(actualDeviceProfileInfo.getDefaultDashboardId());
    assertEquals(DeviceProfileType.DEFAULT, actualDeviceProfileInfo.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualDeviceProfileInfo.getTransportType());
    assertEquals(EntityType.DEVICE_PROFILE, id.getEntityType());
    TenantId tenantId2 = actualDeviceProfileInfo.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(id.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, id.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}, and {@link DeviceProfileInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileInfo#equals(Object)}
   *   <li>{@link DeviceProfileInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());
    DeviceProfileInfo deviceProfileInfo2 = new DeviceProfileInfo(new DeviceProfile());

    // Act and Assert
    assertEquals(deviceProfileInfo, deviceProfileInfo2);
    assertEquals(deviceProfileInfo.hashCode(), deviceProfileInfo2.hashCode());
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}, and {@link DeviceProfileInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileInfo#equals(Object)}
   *   <li>{@link DeviceProfileInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);
    DeviceProfileInfo deviceProfileInfo2 =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Act and Assert
    assertEquals(deviceProfileInfo, deviceProfileInfo2);
    assertEquals(deviceProfileInfo.hashCode(), deviceProfileInfo2.hashCode());
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}, and {@link DeviceProfileInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileInfo#equals(Object)}
   *   <li>{@link DeviceProfileInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());

    // Act and Assert
    assertEquals(deviceProfileInfo, deviceProfileInfo);
    int expectedHashCodeResult = deviceProfileInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceProfileInfo.hashCode());
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(deviceProfileInfo, new DeviceProfileInfo(new DeviceProfile()));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Name",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(
        deviceProfileInfo,
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            null,
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(
        deviceProfileInfo,
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            null,
            DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(
        deviceProfileInfo,
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            null);

    // Act and Assert
    assertNotEquals(
        deviceProfileInfo,
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.MQTT);

    // Act and Assert
    assertNotEquals(
        deviceProfileInfo,
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(
        deviceProfileInfo,
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            null,
            DeviceTransportType.DEFAULT));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            UUID.randomUUID(),
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(
        deviceProfileInfo,
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            UUID.randomUUID(),
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(
        deviceProfileInfo,
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            null,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(
        deviceProfileInfo,
        new DeviceProfileInfo(
            EntityId.NULL_UUID,
            EntityId.NULL_UUID,
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());

    DeviceProfile profile = new DeviceProfile();
    profile.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceProfileInfo, new DeviceProfileInfo(profile));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceProfileInfo(new DeviceProfile()), null);
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DeviceProfileInfo(new DeviceProfile()), "Different type to DeviceProfileInfo");
  }
}
