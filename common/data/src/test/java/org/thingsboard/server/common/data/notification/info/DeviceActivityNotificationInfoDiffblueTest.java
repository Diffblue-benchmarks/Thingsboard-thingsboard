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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;

class DeviceActivityNotificationInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder#build()}
   *   <li>
   * {@link DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder#deviceCustomerId(CustomerId)}
   *   <li>
   * {@link DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder#deviceId(UUID)}
   *   <li>
   * {@link DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder#deviceLabel(String)}
   *   <li>
   * {@link DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder#deviceName(String)}
   *   <li>
   * {@link DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder#deviceType(String)}
   *   <li>
   * {@link DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder#eventType(String)}
   * </ul>
   */
  @Test
  void testDeviceActivityNotificationInfoBuilderBuild() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    CustomerId deviceCustomerId = new CustomerId(EntityId.NULL_UUID);

    // Act
    DeviceActivityNotificationInfo actualBuildResult = builderResult.deviceCustomerId(deviceCustomerId)
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Assert
    assertTrue(actualBuildResult.getStateEntityId() instanceof DeviceId);
    Map<String, String> templateData = actualBuildResult.getTemplateData();
    assertEquals(5, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("deviceId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualBuildResult.getDeviceId().toString());
    assertEquals("Device Label", templateData.get("deviceLabel"));
    assertEquals("Device Label", actualBuildResult.getDeviceLabel());
    assertEquals("Device Name", templateData.get("deviceName"));
    assertEquals("Device Name", actualBuildResult.getDeviceName());
    assertEquals("Device Type", templateData.get("deviceType"));
    assertEquals("Device Type", actualBuildResult.getDeviceType());
    assertEquals("Event Type", templateData.get("eventType"));
    assertEquals("Event Type", actualBuildResult.getEventType());
    assertNull(actualBuildResult.getDashboardId());
    assertNull(actualBuildResult.getAffectedTenantId());
    assertNull(actualBuildResult.getAffectedUserId());
    assertSame(deviceCustomerId, actualBuildResult.getAffectedCustomerId());
    assertSame(deviceCustomerId, actualBuildResult.getDeviceCustomerId());
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#getTemplateData()}
   */
  @Test
  void testGetTemplateData() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act
    Map<String, String> actualTemplateData = buildResult.getTemplateData();

    // Assert
    assertEquals(5, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("deviceId"));
    assertEquals("Device Label", actualTemplateData.get("deviceLabel"));
    assertEquals("Device Name", actualTemplateData.get("deviceName"));
    assertEquals("Device Type", actualTemplateData.get("deviceType"));
    assertEquals("Event Type", actualTemplateData.get("eventType"));
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#getStateEntityId()}
   */
  @Test
  void testGetStateEntityId() {
    // Arrange and Act
    EntityId actualStateEntityId = (new DeviceActivityNotificationInfo()).getStateEntityId();

    // Assert
    assertTrue(actualStateEntityId instanceof DeviceId);
    assertNull(actualStateEntityId.getId());
    assertEquals(EntityType.DEVICE, actualStateEntityId.getEntityType());
    assertFalse(actualStateEntityId.isNullUid());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#equals(Object)}
   *   <li>{@link DeviceActivityNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult2.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#equals(Object)}
   *   <li>{@link DeviceActivityNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceId(Mockito.<UUID>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder2
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceId(Mockito.<UUID>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder2
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType(null)
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceId(Mockito.<UUID>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder2
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("42")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceId(Mockito.<UUID>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder2
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(null)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceId(Mockito.<UUID>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder2
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType(null)
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceLabel(Mockito.<String>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder3
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(null)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceName(Mockito.<String>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder4
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(null)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceName(Mockito.<String>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder4
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(null)
        .deviceLabel("Device Label")
        .deviceName(null)
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    builderResult.deviceId(EntityId.NULL_UUID);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceName(Mockito.<String>any())).thenReturn(builderResult);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder4
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult2.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(null)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    builderResult.deviceName("Event Type");
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceName(Mockito.<String>any())).thenReturn(builderResult);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder4
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult2.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(null)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceName(Mockito.<String>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder4
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(null)
        .deviceLabel(null)
        .deviceName(null)
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    builderResult.deviceLabel("Event Type");
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceName(Mockito.<String>any())).thenReturn(builderResult);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder4
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult2.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(null)
        .deviceLabel("Device Label")
        .deviceName(null)
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceType(Mockito.<String>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceName(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder5 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder5.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder4);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder5
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(null)
        .deviceLabel(null)
        .deviceName(null)
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceType(Mockito.<String>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceName(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder5 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder5.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder4);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder5
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(null)
        .deviceLabel(null)
        .deviceName(null)
        .deviceType(null)
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    builderResult.deviceType("Event Type");
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceType(Mockito.<String>any())).thenReturn(builderResult);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceName(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder5 = mock(
        DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder5.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder4);
    DeviceActivityNotificationInfo buildResult = deviceActivityNotificationInfoBuilder5
        .deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult2 = builderResult2.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(null)
        .deviceLabel(null)
        .deviceName(null)
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo
        .builder();
    DeviceActivityNotificationInfo buildResult = builderResult.deviceCustomerId(new CustomerId(EntityId.NULL_UUID))
        .deviceId(EntityId.NULL_UUID)
        .deviceLabel("Device Label")
        .deviceName("Device Name")
        .deviceType("Device Type")
        .eventType("Event Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to DeviceActivityNotificationInfo");
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceActivityNotificationInfo actualDeviceActivityNotificationInfo = new DeviceActivityNotificationInfo();
    CustomerId deviceCustomerId = new CustomerId(EntityId.NULL_UUID);
    actualDeviceActivityNotificationInfo.setDeviceCustomerId(deviceCustomerId);
    UUID deviceId = EntityId.NULL_UUID;
    actualDeviceActivityNotificationInfo.setDeviceId(deviceId);
    actualDeviceActivityNotificationInfo.setDeviceLabel("Device Label");
    actualDeviceActivityNotificationInfo.setDeviceName("Device Name");
    actualDeviceActivityNotificationInfo.setDeviceType("Device Type");
    actualDeviceActivityNotificationInfo.setEventType("Event Type");
    String actualToStringResult = actualDeviceActivityNotificationInfo.toString();
    CustomerId actualAffectedCustomerId = actualDeviceActivityNotificationInfo.getAffectedCustomerId();
    CustomerId actualDeviceCustomerId = actualDeviceActivityNotificationInfo.getDeviceCustomerId();
    UUID actualDeviceId = actualDeviceActivityNotificationInfo.getDeviceId();
    String actualDeviceLabel = actualDeviceActivityNotificationInfo.getDeviceLabel();
    String actualDeviceName = actualDeviceActivityNotificationInfo.getDeviceName();
    String actualDeviceType = actualDeviceActivityNotificationInfo.getDeviceType();

    // Assert that nothing has changed
    assertEquals("Device Label", actualDeviceLabel);
    assertEquals("Device Name", actualDeviceName);
    assertEquals("Device Type", actualDeviceType);
    assertEquals("DeviceActivityNotificationInfo(eventType=Event Type, deviceId=13814000-1dd2-11b2-8080-808080808080,"
        + " deviceName=Device Name, deviceLabel=Device Label, deviceType=Device Type, deviceCustomerId=13814000"
        + "-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals("Event Type", actualDeviceActivityNotificationInfo.getEventType());
    assertSame(deviceCustomerId, actualAffectedCustomerId);
    assertSame(deviceCustomerId, actualDeviceCustomerId);
    assertSame(deviceId, actualDeviceId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeviceActivityNotificationInfo#DeviceActivityNotificationInfo(String, UUID, String, String, String, CustomerId)}
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
  void testGettersAndSetters2() {
    // Arrange and Act
    DeviceActivityNotificationInfo actualDeviceActivityNotificationInfo = new DeviceActivityNotificationInfo(
        "Event Type", EntityId.NULL_UUID, "Device Name", "Device Label", "Device Type",
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
    CustomerId actualAffectedCustomerId = actualDeviceActivityNotificationInfo.getAffectedCustomerId();
    CustomerId actualDeviceCustomerId = actualDeviceActivityNotificationInfo.getDeviceCustomerId();
    UUID actualDeviceId = actualDeviceActivityNotificationInfo.getDeviceId();
    String actualDeviceLabel = actualDeviceActivityNotificationInfo.getDeviceLabel();
    String actualDeviceName = actualDeviceActivityNotificationInfo.getDeviceName();
    String actualDeviceType = actualDeviceActivityNotificationInfo.getDeviceType();

    // Assert that nothing has changed
    assertEquals("Device Label", actualDeviceLabel);
    assertEquals("Device Name", actualDeviceName);
    assertEquals("Device Type", actualDeviceType);
    assertEquals("DeviceActivityNotificationInfo(eventType=Event Type, deviceId=13814000-1dd2-11b2-8080-808080808080,"
        + " deviceName=Device Name, deviceLabel=Device Label, deviceType=Device Type, deviceCustomerId=13814000"
        + "-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals("Event Type", actualDeviceActivityNotificationInfo.getEventType());
    assertSame(deviceCustomerId, actualAffectedCustomerId);
    assertSame(deviceCustomerId, actualDeviceCustomerId);
    assertSame(deviceId, actualDeviceId);
  }
}
