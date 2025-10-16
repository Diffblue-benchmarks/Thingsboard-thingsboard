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
package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.notification.info.DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder;

@ContextConfiguration(classes = {DeviceActivityNotificationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class DeviceActivityNotificationInfoDiffblueTest {
  @Autowired private DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder;

  /**
   * Test DeviceActivityNotificationInfoBuilder {@link
   * DeviceActivityNotificationInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfoBuilder#build()}
   *   <li>{@link DeviceActivityNotificationInfoBuilder#deviceCustomerId(CustomerId)}
   *   <li>{@link DeviceActivityNotificationInfoBuilder#deviceId(UUID)}
   *   <li>{@link DeviceActivityNotificationInfoBuilder#deviceLabel(String)}
   *   <li>{@link DeviceActivityNotificationInfoBuilder#deviceName(String)}
   *   <li>{@link DeviceActivityNotificationInfoBuilder#deviceType(String)}
   *   <li>{@link DeviceActivityNotificationInfoBuilder#eventType(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test DeviceActivityNotificationInfoBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceActivityNotificationInfoBuilder.<init>()",
    "DeviceActivityNotificationInfo DeviceActivityNotificationInfoBuilder.build()",
    "DeviceActivityNotificationInfoBuilder DeviceActivityNotificationInfoBuilder.deviceCustomerId(CustomerId)",
    "DeviceActivityNotificationInfoBuilder DeviceActivityNotificationInfoBuilder.deviceId(UUID)",
    "DeviceActivityNotificationInfoBuilder DeviceActivityNotificationInfoBuilder.deviceLabel(String)",
    "DeviceActivityNotificationInfoBuilder DeviceActivityNotificationInfoBuilder.deviceName(String)",
    "DeviceActivityNotificationInfoBuilder DeviceActivityNotificationInfoBuilder.deviceType(String)",
    "DeviceActivityNotificationInfoBuilder DeviceActivityNotificationInfoBuilder.eventType(String)",
    "String DeviceActivityNotificationInfoBuilder.toString()"
  })
  void testDeviceActivityNotificationInfoBuilderBuild() {
    // Arrange and Act
    DeviceActivityNotificationInfoBuilder actualBuilderResult =
        DeviceActivityNotificationInfo.builder();
    CustomerId deviceCustomerId = new CustomerId(EntityId.NULL_UUID);
    UUID deviceId = EntityId.NULL_UUID;
    DeviceActivityNotificationInfo actualDeviceActivityNotificationInfo =
        actualBuilderResult
            .deviceCustomerId(deviceCustomerId)
            .deviceId(deviceId)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Assert
    assertTrue(actualDeviceActivityNotificationInfo.getStateEntityId() instanceof DeviceId);
    Map<String, String> templateData = actualDeviceActivityNotificationInfo.getTemplateData();
    assertEquals(5, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("deviceId"));
    UUID deviceId2 = actualDeviceActivityNotificationInfo.getDeviceId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", deviceId2.toString());
    assertEquals("Device Label", templateData.get("deviceLabel"));
    assertEquals("Device Label", actualDeviceActivityNotificationInfo.getDeviceLabel());
    assertEquals("Device Name", templateData.get("deviceName"));
    assertEquals("Device Name", actualDeviceActivityNotificationInfo.getDeviceName());
    assertEquals("Device Type", templateData.get("deviceType"));
    assertEquals("Device Type", actualDeviceActivityNotificationInfo.getDeviceType());
    assertEquals("Event Type", templateData.get("eventType"));
    assertEquals("Event Type", actualDeviceActivityNotificationInfo.getEventType());
    assertNull(actualDeviceActivityNotificationInfo.getDashboardId());
    assertNull(actualDeviceActivityNotificationInfo.getAffectedTenantId());
    assertNull(actualDeviceActivityNotificationInfo.getAffectedUserId());
    assertSame(deviceCustomerId, actualDeviceActivityNotificationInfo.getAffectedCustomerId());
    assertSame(deviceCustomerId, actualDeviceActivityNotificationInfo.getDeviceCustomerId());
    assertSame(deviceId, deviceId2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return size is five.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DeviceActivityNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnSizeIsFive() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();

    // Act
    Map<String, String> actualTemplateData =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build()
            .getTemplateData();

    // Assert
    assertEquals(5, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("deviceId"));
    assertEquals("Device Label", actualTemplateData.get("deviceLabel"));
    assertEquals("Device Name", actualTemplateData.get("deviceName"));
    assertEquals("Device Type", actualTemplateData.get("deviceType"));
    assertEquals("Event Type", actualTemplateData.get("eventType"));
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#getStateEntityId()}.
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#getStateEntityId()}
   */
  @Test
  @DisplayName("Test getStateEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId DeviceActivityNotificationInfo.getStateEntityId()"})
  void testGetStateEntityId() {
    // Arrange and Act
    EntityId actualStateEntityId = new DeviceActivityNotificationInfo().getStateEntityId();

    // Assert
    assertTrue(actualStateEntityId instanceof DeviceId);
    assertNull(actualStateEntityId.getId());
    assertEquals(EntityType.DEVICE, actualStateEntityId.getEntityType());
    assertFalse(actualStateEntityId.isNullUid());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}, and {@link
   * DeviceActivityNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#equals(Object)}
   *   <li>{@link DeviceActivityNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo2 =
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertEquals(deviceActivityNotificationInfo, deviceActivityNotificationInfo2);
    assertEquals(
        deviceActivityNotificationInfo.hashCode(), deviceActivityNotificationInfo2.hashCode());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}, and {@link
   * DeviceActivityNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#equals(Object)}
   *   <li>{@link DeviceActivityNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        DeviceActivityNotificationInfo.builder()
            .deviceCustomerId(null)
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo2 =
        DeviceActivityNotificationInfo.builder()
            .deviceCustomerId(null)
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertEquals(deviceActivityNotificationInfo, deviceActivityNotificationInfo2);
    assertEquals(
        deviceActivityNotificationInfo.hashCode(), deviceActivityNotificationInfo2.hashCode());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}, and {@link
   * DeviceActivityNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#equals(Object)}
   *   <li>{@link DeviceActivityNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(null)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo2 =
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(null)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertEquals(deviceActivityNotificationInfo, deviceActivityNotificationInfo2);
    assertEquals(
        deviceActivityNotificationInfo.hashCode(), deviceActivityNotificationInfo2.hashCode());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}, and {@link
   * DeviceActivityNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#equals(Object)}
   *   <li>{@link DeviceActivityNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel(null)
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo2 =
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel(null)
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertEquals(deviceActivityNotificationInfo, deviceActivityNotificationInfo2);
    assertEquals(
        deviceActivityNotificationInfo.hashCode(), deviceActivityNotificationInfo2.hashCode());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}, and {@link
   * DeviceActivityNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#equals(Object)}
   *   <li>{@link DeviceActivityNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName(null)
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo2 =
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName(null)
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertEquals(deviceActivityNotificationInfo, deviceActivityNotificationInfo2);
    assertEquals(
        deviceActivityNotificationInfo.hashCode(), deviceActivityNotificationInfo2.hashCode());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}, and {@link
   * DeviceActivityNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#equals(Object)}
   *   <li>{@link DeviceActivityNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType(null)
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo2 =
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType(null)
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertEquals(deviceActivityNotificationInfo, deviceActivityNotificationInfo2);
    assertEquals(
        deviceActivityNotificationInfo.hashCode(), deviceActivityNotificationInfo2.hashCode());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}, and {@link
   * DeviceActivityNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#equals(Object)}
   *   <li>{@link DeviceActivityNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertEquals(deviceActivityNotificationInfo, deviceActivityNotificationInfo);
    int expectedHashCodeResult = deviceActivityNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceActivityNotificationInfo.hashCode());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(UUID.randomUUID()))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        deviceActivityNotificationInfo,
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        DeviceActivityNotificationInfo.builder()
            .deviceCustomerId(null)
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        deviceActivityNotificationInfo,
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();

    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID));
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        deviceCustomerIdResult
            .deviceId(UUID.randomUUID())
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        deviceActivityNotificationInfo,
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(null)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        deviceActivityNotificationInfo,
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Event Type")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        deviceActivityNotificationInfo,
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel(null)
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        deviceActivityNotificationInfo,
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Event Type")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        deviceActivityNotificationInfo,
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName(null)
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        deviceActivityNotificationInfo,
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Event Type")
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        deviceActivityNotificationInfo,
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType(null)
            .eventType("Event Type")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        deviceActivityNotificationInfo,
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Device Name")
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        deviceActivityNotificationInfo,
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo deviceActivityNotificationInfo =
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType(null)
            .build();

    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        deviceActivityNotificationInfo,
        builderResult2
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build(),
        null);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
            .deviceId(EntityId.NULL_UUID)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build(),
        "Different type to DeviceActivityNotificationInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#DeviceActivityNotificationInfo()}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceCustomerId(CustomerId)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceId(UUID)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceLabel(String)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceName(String)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceType(String)}
   *   <li>{@link DeviceActivityNotificationInfo#setEventType(String)}
   *   <li>{@link DeviceActivityNotificationInfo#toString()}
   *   <li>{@link DeviceActivityNotificationInfo#getAffectedCustomerId()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceCustomerId()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceId()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceLabel()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceName()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceType()}
   *   <li>{@link DeviceActivityNotificationInfo#getEventType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceActivityNotificationInfo.<init>()",
    "void DeviceActivityNotificationInfo.<init>(String, UUID, String, String, String, CustomerId)",
    "CustomerId DeviceActivityNotificationInfo.getAffectedCustomerId()",
    "CustomerId DeviceActivityNotificationInfo.getDeviceCustomerId()",
    "UUID DeviceActivityNotificationInfo.getDeviceId()",
    "String DeviceActivityNotificationInfo.getDeviceLabel()",
    "String DeviceActivityNotificationInfo.getDeviceName()",
    "String DeviceActivityNotificationInfo.getDeviceType()",
    "String DeviceActivityNotificationInfo.getEventType()",
    "void DeviceActivityNotificationInfo.setDeviceCustomerId(CustomerId)",
    "void DeviceActivityNotificationInfo.setDeviceId(UUID)",
    "void DeviceActivityNotificationInfo.setDeviceLabel(String)",
    "void DeviceActivityNotificationInfo.setDeviceName(String)",
    "void DeviceActivityNotificationInfo.setDeviceType(String)",
    "void DeviceActivityNotificationInfo.setEventType(String)",
    "String DeviceActivityNotificationInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceActivityNotificationInfo actualDeviceActivityNotificationInfo =
        new DeviceActivityNotificationInfo();
    CustomerId deviceCustomerId = new CustomerId(EntityId.NULL_UUID);
    actualDeviceActivityNotificationInfo.setDeviceCustomerId(deviceCustomerId);
    UUID deviceId = EntityId.NULL_UUID;
    actualDeviceActivityNotificationInfo.setDeviceId(deviceId);
    actualDeviceActivityNotificationInfo.setDeviceLabel("Device Label");
    actualDeviceActivityNotificationInfo.setDeviceName("Device Name");
    actualDeviceActivityNotificationInfo.setDeviceType("Device Type");
    actualDeviceActivityNotificationInfo.setEventType("Event Type");
    String actualToStringResult = actualDeviceActivityNotificationInfo.toString();
    CustomerId actualAffectedCustomerId =
        actualDeviceActivityNotificationInfo.getAffectedCustomerId();
    CustomerId actualDeviceCustomerId = actualDeviceActivityNotificationInfo.getDeviceCustomerId();
    UUID actualDeviceId = actualDeviceActivityNotificationInfo.getDeviceId();
    String actualDeviceLabel = actualDeviceActivityNotificationInfo.getDeviceLabel();
    String actualDeviceName = actualDeviceActivityNotificationInfo.getDeviceName();
    String actualDeviceType = actualDeviceActivityNotificationInfo.getDeviceType();

    // Assert
    assertEquals("Device Label", actualDeviceLabel);
    assertEquals("Device Name", actualDeviceName);
    assertEquals("Device Type", actualDeviceType);
    assertEquals(
        "DeviceActivityNotificationInfo(eventType=Event Type, deviceId=13814000-1dd2-11b2-8080-808080808080,"
            + " deviceName=Device Name, deviceLabel=Device Label, deviceType=Device Type, deviceCustomerId=13814000"
            + "-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals("Event Type", actualDeviceActivityNotificationInfo.getEventType());
    assertSame(deviceCustomerId, actualAffectedCustomerId);
    assertSame(deviceCustomerId, actualDeviceCustomerId);
    assertSame(deviceId, actualDeviceId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Event Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#DeviceActivityNotificationInfo(String, UUID,
   *       String, String, String, CustomerId)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceCustomerId(CustomerId)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceId(UUID)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceLabel(String)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceName(String)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceType(String)}
   *   <li>{@link DeviceActivityNotificationInfo#setEventType(String)}
   *   <li>{@link DeviceActivityNotificationInfo#toString()}
   *   <li>{@link DeviceActivityNotificationInfo#getAffectedCustomerId()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceCustomerId()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceId()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceLabel()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceName()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceType()}
   *   <li>{@link DeviceActivityNotificationInfo#getEventType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Event Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceActivityNotificationInfo.<init>()",
    "void DeviceActivityNotificationInfo.<init>(String, UUID, String, String, String, CustomerId)",
    "CustomerId DeviceActivityNotificationInfo.getAffectedCustomerId()",
    "CustomerId DeviceActivityNotificationInfo.getDeviceCustomerId()",
    "UUID DeviceActivityNotificationInfo.getDeviceId()",
    "String DeviceActivityNotificationInfo.getDeviceLabel()",
    "String DeviceActivityNotificationInfo.getDeviceName()",
    "String DeviceActivityNotificationInfo.getDeviceType()",
    "String DeviceActivityNotificationInfo.getEventType()",
    "void DeviceActivityNotificationInfo.setDeviceCustomerId(CustomerId)",
    "void DeviceActivityNotificationInfo.setDeviceId(UUID)",
    "void DeviceActivityNotificationInfo.setDeviceLabel(String)",
    "void DeviceActivityNotificationInfo.setDeviceName(String)",
    "void DeviceActivityNotificationInfo.setDeviceType(String)",
    "void DeviceActivityNotificationInfo.setEventType(String)",
    "String DeviceActivityNotificationInfo.toString()"
  })
  void testGettersAndSetters_whenEventType() {
    // Arrange and Act
    DeviceActivityNotificationInfo actualDeviceActivityNotificationInfo =
        new DeviceActivityNotificationInfo(
            "Event Type",
            EntityId.NULL_UUID,
            "Device Name",
            "Device Label",
            "Device Type",
            new CustomerId(EntityId.NULL_UUID));
    CustomerId deviceCustomerId = new CustomerId(EntityId.NULL_UUID);
    actualDeviceActivityNotificationInfo.setDeviceCustomerId(deviceCustomerId);
    UUID deviceId = EntityId.NULL_UUID;
    actualDeviceActivityNotificationInfo.setDeviceId(deviceId);
    actualDeviceActivityNotificationInfo.setDeviceLabel("Device Label");
    actualDeviceActivityNotificationInfo.setDeviceName("Device Name");
    actualDeviceActivityNotificationInfo.setDeviceType("Device Type");
    actualDeviceActivityNotificationInfo.setEventType("Event Type");
    String actualToStringResult = actualDeviceActivityNotificationInfo.toString();
    CustomerId actualAffectedCustomerId =
        actualDeviceActivityNotificationInfo.getAffectedCustomerId();
    CustomerId actualDeviceCustomerId = actualDeviceActivityNotificationInfo.getDeviceCustomerId();
    UUID actualDeviceId = actualDeviceActivityNotificationInfo.getDeviceId();
    String actualDeviceLabel = actualDeviceActivityNotificationInfo.getDeviceLabel();
    String actualDeviceName = actualDeviceActivityNotificationInfo.getDeviceName();
    String actualDeviceType = actualDeviceActivityNotificationInfo.getDeviceType();

    // Assert
    assertEquals("Device Label", actualDeviceLabel);
    assertEquals("Device Name", actualDeviceName);
    assertEquals("Device Type", actualDeviceType);
    assertEquals(
        "DeviceActivityNotificationInfo(eventType=Event Type, deviceId=13814000-1dd2-11b2-8080-808080808080,"
            + " deviceName=Device Name, deviceLabel=Device Label, deviceType=Device Type, deviceCustomerId=13814000"
            + "-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals("Event Type", actualDeviceActivityNotificationInfo.getEventType());
    assertSame(deviceCustomerId, actualAffectedCustomerId);
    assertSame(deviceCustomerId, actualDeviceCustomerId);
    assertSame(deviceId, actualDeviceId);
  }
}
