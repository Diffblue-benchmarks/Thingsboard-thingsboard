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
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceIdInfoDiffblueTest {
  /**
   * Test {@link DeviceIdInfo#DeviceIdInfo(UUID, UUID, UUID)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceIdInfo#DeviceIdInfo(UUID, UUID, UUID)}
   */
  @Test
  @DisplayName(
      "Test new DeviceIdInfo(UUID, UUID, UUID); when 'null'; then return CustomerId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceIdInfo.<init>(UUID, UUID, UUID)"})
  void testNewDeviceIdInfo_whenNull_thenReturnCustomerIdIsNull() {
    // Arrange
    UUID deviceId = EntityId.NULL_UUID;

    // Act
    DeviceIdInfo actualDeviceIdInfo = new DeviceIdInfo(EntityId.NULL_UUID, null, deviceId);

    // Assert
    assertNull(actualDeviceIdInfo.getCustomerId());
    DeviceId deviceId2 = actualDeviceIdInfo.getDeviceId();
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    TenantId tenantId = actualDeviceIdInfo.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(deviceId2.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(deviceId, deviceId2.getId());
    assertSame(deviceId, tenantId.getId());
  }

  /**
   * Test {@link DeviceIdInfo#DeviceIdInfo(UUID, UUID, UUID)}.
   *
   * <ul>
   *   <li>When {@link EntityId#NULL_UUID}.
   *   <li>Then return CustomerId EntityType is {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceIdInfo#DeviceIdInfo(UUID, UUID, UUID)}
   */
  @Test
  @DisplayName(
      "Test new DeviceIdInfo(UUID, UUID, UUID); when NULL_UUID; then return CustomerId EntityType is 'CUSTOMER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceIdInfo.<init>(UUID, UUID, UUID)"})
  void testNewDeviceIdInfo_whenNull_uuid_thenReturnCustomerIdEntityTypeIsCustomer() {
    // Arrange
    UUID deviceId = EntityId.NULL_UUID;

    // Act
    DeviceIdInfo actualDeviceIdInfo =
        new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, deviceId);

    // Assert
    CustomerId customerId = actualDeviceIdInfo.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
    UUID id = customerId.getId();
    assertSame(id, actualDeviceIdInfo.getDeviceId().getId());
    assertSame(id, actualDeviceIdInfo.getTenantId().getId());
    assertSame(deviceId, id);
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}, and {@link DeviceIdInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceIdInfo#equals(Object)}
   *   <li>{@link DeviceIdInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceIdInfo deviceIdInfo =
        new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID);
    DeviceIdInfo deviceIdInfo2 =
        new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID);

    // Act and Assert
    assertEquals(deviceIdInfo, deviceIdInfo2);
    assertEquals(deviceIdInfo.hashCode(), deviceIdInfo2.hashCode());
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}, and {@link DeviceIdInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceIdInfo#equals(Object)}
   *   <li>{@link DeviceIdInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(EntityId.NULL_UUID, null, EntityId.NULL_UUID);
    DeviceIdInfo deviceIdInfo2 = new DeviceIdInfo(EntityId.NULL_UUID, null, EntityId.NULL_UUID);

    // Act and Assert
    assertEquals(deviceIdInfo, deviceIdInfo2);
    assertEquals(deviceIdInfo.hashCode(), deviceIdInfo2.hashCode());
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}, and {@link DeviceIdInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceIdInfo#equals(Object)}
   *   <li>{@link DeviceIdInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceIdInfo deviceIdInfo =
        new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID);

    // Act and Assert
    assertEquals(deviceIdInfo, deviceIdInfo);
    int expectedHashCodeResult = deviceIdInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceIdInfo.hashCode());
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID), 1);
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceIdInfo deviceIdInfo =
        new DeviceIdInfo(UUID.randomUUID(), EntityId.NULL_UUID, EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(
        deviceIdInfo, new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID));
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceIdInfo deviceIdInfo =
        new DeviceIdInfo(EntityId.NULL_UUID, UUID.randomUUID(), EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(
        deviceIdInfo, new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID));
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(EntityId.NULL_UUID, null, EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(
        deviceIdInfo, new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID));
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceIdInfo deviceIdInfo =
        new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, UUID.randomUUID());

    // Act and Assert
    assertNotEquals(
        deviceIdInfo, new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID));
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID), null);
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID),
        "Different type to DeviceIdInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceIdInfo#toString()}
   *   <li>{@link DeviceIdInfo#getCustomerId()}
   *   <li>{@link DeviceIdInfo#getDeviceId()}
   *   <li>{@link DeviceIdInfo#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerId DeviceIdInfo.getCustomerId()",
    "DeviceId DeviceIdInfo.getDeviceId()",
    "TenantId DeviceIdInfo.getTenantId()",
    "String DeviceIdInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    DeviceIdInfo deviceIdInfo =
        new DeviceIdInfo(EntityId.NULL_UUID, EntityId.NULL_UUID, EntityId.NULL_UUID);

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
    assertEquals(TenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(id, actualDeviceId.getId());
  }
}
