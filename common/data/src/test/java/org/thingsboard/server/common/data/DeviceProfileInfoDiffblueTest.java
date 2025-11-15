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
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceProfileInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileInfo#equals(Object)}
   *   <li>{@link DeviceProfileInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());
    DeviceProfileInfo deviceProfileInfo2 = new DeviceProfileInfo(new DeviceProfile());

    // Act and Assert
    assertEquals(deviceProfileInfo, deviceProfileInfo2);
    int expectedHashCodeResult = deviceProfileInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceProfileInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileInfo#equals(Object)}
   *   <li>{@link DeviceProfileInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());

    // Act and Assert
    assertEquals(deviceProfileInfo, deviceProfileInfo);
    int expectedHashCodeResult = deviceProfileInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceProfileInfo.hashCode());
  }

  /**
   * Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, "Name", "Image",
        EntityId.NULL_UUID, DeviceProfileType.DEFAULT, DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(deviceProfileInfo, new DeviceProfileInfo(new DeviceProfile()));
  }

  /**
   * Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceProfileInfo(new DeviceProfile()), null);
  }

  /**
   * Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceProfileInfo(new DeviceProfile()), "Different type to DeviceProfileInfo");
  }

  /**
   * Method under test:
   * {@link DeviceProfileInfo#DeviceProfileInfo(UUID, UUID, String, String, UUID, DeviceProfileType, DeviceTransportType)}
   */
  @Test
  void testNewDeviceProfileInfo() {
    // Arrange
    UUID defaultDashboardId = EntityId.NULL_UUID;

    // Act
    DeviceProfileInfo actualDeviceProfileInfo = new DeviceProfileInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, "Name",
        "Image", defaultDashboardId, DeviceProfileType.DEFAULT, DeviceTransportType.DEFAULT);

    // Assert
    EntityId id = actualDeviceProfileInfo.getId();
    assertTrue(id instanceof DeviceProfileId);
    DashboardId defaultDashboardId2 = actualDeviceProfileInfo.getDefaultDashboardId();
    UUID id2 = defaultDashboardId2.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertEquals("Image", actualDeviceProfileInfo.getImage());
    assertEquals("Name", actualDeviceProfileInfo.getName());
    assertEquals(DeviceProfileType.DEFAULT, actualDeviceProfileInfo.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualDeviceProfileInfo.getTransportType());
    assertEquals(EntityType.DASHBOARD, defaultDashboardId2.getEntityType());
    assertEquals(EntityType.DEVICE_PROFILE, id.getEntityType());
    TenantId tenantId = actualDeviceProfileInfo.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(defaultDashboardId2.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(id.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(defaultDashboardId, id.getId());
    assertSame(defaultDashboardId, id2);
    assertSame(defaultDashboardId, tenantId.getId());
  }

  /**
   * Method under test:
   * {@link DeviceProfileInfo#DeviceProfileInfo(UUID, UUID, String, String, UUID, DeviceProfileType, DeviceTransportType)}
   */
  @Test
  void testNewDeviceProfileInfo2() {
    // Arrange
    UUID tenantId = EntityId.NULL_UUID;

    // Act
    DeviceProfileInfo actualDeviceProfileInfo = new DeviceProfileInfo(EntityId.NULL_UUID, tenantId, "Name", "Image",
        null, DeviceProfileType.DEFAULT, DeviceTransportType.DEFAULT);

    // Assert
    EntityId id = actualDeviceProfileInfo.getId();
    assertTrue(id instanceof DeviceProfileId);
    TenantId tenantId2 = actualDeviceProfileInfo.getTenantId();
    UUID id2 = tenantId2.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertEquals("Image", actualDeviceProfileInfo.getImage());
    assertEquals("Name", actualDeviceProfileInfo.getName());
    assertNull(actualDeviceProfileInfo.getDefaultDashboardId());
    assertEquals(DeviceProfileType.DEFAULT, actualDeviceProfileInfo.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualDeviceProfileInfo.getTransportType());
    assertEquals(EntityType.DEVICE_PROFILE, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(id.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, id.getId());
    assertSame(tenantId, id2);
  }

  /**
   * Method under test: {@link DeviceProfileInfo#DeviceProfileInfo(DeviceProfile)}
   */
  @Test
  void testNewDeviceProfileInfo3() {
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
}
