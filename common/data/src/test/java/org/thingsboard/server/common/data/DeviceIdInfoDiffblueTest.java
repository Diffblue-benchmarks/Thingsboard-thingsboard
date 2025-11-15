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
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceIdInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceIdInfo#equals(Object)}
   *   <li>{@link DeviceIdInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID);
    DeviceIdInfo deviceIdInfo2 = new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID);

    // Act and Assert
    assertEquals(deviceIdInfo, deviceIdInfo2);
    int expectedHashCodeResult = deviceIdInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceIdInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceIdInfo#equals(Object)}
   *   <li>{@link DeviceIdInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(EntityId.NULL_UUID, null, EntityId.NULL_UUID);
    DeviceIdInfo deviceIdInfo2 = new DeviceIdInfo(EntityId.NULL_UUID, null, EntityId.NULL_UUID);

    // Act and Assert
    assertEquals(deviceIdInfo, deviceIdInfo2);
    int expectedHashCodeResult = deviceIdInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceIdInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceIdInfo#equals(Object)}
   *   <li>{@link DeviceIdInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID);

    // Act and Assert
    assertEquals(deviceIdInfo, deviceIdInfo);
    int expectedHashCodeResult = deviceIdInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceIdInfo.hashCode());
  }

  /**
   * Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(UUID.randomUUID(), EntityId.NULL_UUID, EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceIdInfo, new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID));
  }

  /**
   * Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(EntityId.NULL_UUID, UUID.randomUUID(), EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceIdInfo, new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID));
  }

  /**
   * Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(EntityId.NULL_UUID, null, EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceIdInfo, new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID));
  }

  /**
   * Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, UUID.randomUUID());

    // Act and Assert
    assertNotEquals(deviceIdInfo, new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID));
  }

  /**
   * Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID),
        mock(AdminSettingsId.class));
  }

  /**
   * Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID), null);
  }

  /**
   * Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID),
        "Different type to DeviceIdInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceIdInfo#toString()}
   *   <li>{@link DeviceIdInfo#getCustomerId()}
   *   <li>{@link DeviceIdInfo#getDeviceId()}
   *   <li>{@link DeviceIdInfo#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID);

    // Act
    String actualToStringResult = deviceIdInfo.toString();
    CustomerId actualCustomerId = deviceIdInfo.getCustomerId();
    DeviceId actualDeviceId = deviceIdInfo.getDeviceId();
    TenantId actualTenantId = deviceIdInfo.getTenantId();

    // Assert
    UUID id = actualCustomerId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(
        "DeviceIdInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, customerId=13814000-1dd2-11b2-8080-808080808080,"
            + " deviceId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals(EntityType.CUSTOMER, actualCustomerId.getEntityType());
    assertEquals(EntityType.DEVICE, actualDeviceId.getEntityType());
    assertTrue(actualCustomerId.isNullUid());
    assertTrue(actualDeviceId.isNullUid());
    assertEquals(actualTenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(id, actualDeviceId.getId());
  }

  /**
   * Method under test: {@link DeviceIdInfo#DeviceIdInfo(UUID, UUID, UUID)}
   */
  @Test
  void testNewDeviceIdInfo() {
    // Arrange
    UUID deviceId = EntityId.NULL_UUID;

    // Act
    DeviceIdInfo actualDeviceIdInfo = new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, deviceId);

    // Assert
    CustomerId customerId = actualDeviceIdInfo.getCustomerId();
    UUID id = customerId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    DeviceId deviceId2 = actualDeviceIdInfo.getDeviceId();
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    TenantId tenantId = actualDeviceIdInfo.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(customerId.isNullUid());
    assertTrue(deviceId2.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(deviceId, id);
    assertSame(deviceId, deviceId2.getId());
    assertSame(deviceId, tenantId.getId());
  }

  /**
   * Method under test: {@link DeviceIdInfo#DeviceIdInfo(UUID, UUID, UUID)}
   */
  @Test
  void testNewDeviceIdInfo2() {
    // Arrange
    UUID deviceId = EntityId.NULL_UUID;

    // Act
    DeviceIdInfo actualDeviceIdInfo = new DeviceIdInfo(EntityId.NULL_UUID, null, deviceId);

    // Assert
    DeviceId deviceId2 = actualDeviceIdInfo.getDeviceId();
    UUID id = deviceId2.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertNull(actualDeviceIdInfo.getCustomerId());
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    TenantId tenantId = actualDeviceIdInfo.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(deviceId2.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(deviceId, id);
    assertSame(deviceId, tenantId.getId());
  }
}
