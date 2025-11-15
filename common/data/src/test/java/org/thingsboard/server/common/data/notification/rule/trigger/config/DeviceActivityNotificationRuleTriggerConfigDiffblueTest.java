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
package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;

class DeviceActivityNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder#build()}
   *   <li>
   * {@link DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder#deviceProfiles(Set)}
   *   <li>
   * {@link DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder#devices(Set)}
   *   <li>
   * {@link DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder#notifyOn(Set)}
   * </ul>
   */
  @Test
  void testDeviceActivityNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    HashSet<UUID> deviceProfiles = new HashSet<>();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = builderResult
        .deviceProfiles(deviceProfiles);
    HashSet<UUID> devices = new HashSet<>();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult
        .devices(devices);
    HashSet<DeviceActivityNotificationRuleTriggerConfig.DeviceEvent> notifyOn = new HashSet<>();

    // Act
    DeviceActivityNotificationRuleTriggerConfig actualBuildResult = devicesResult.notifyOn(notifyOn).build();

    // Assert
    assertEquals("#", actualBuildResult.getDeduplicationKey());
    assertEquals(NotificationRuleTriggerType.DEVICE_ACTIVITY, actualBuildResult.getTriggerType());
    Set<UUID> deviceProfiles2 = actualBuildResult.getDeviceProfiles();
    assertTrue(deviceProfiles2.isEmpty());
    Set<UUID> devices2 = actualBuildResult.getDevices();
    assertTrue(devices2.isEmpty());
    Set<DeviceActivityNotificationRuleTriggerConfig.DeviceEvent> notifyOn2 = actualBuildResult.getNotifyOn();
    assertTrue(notifyOn2.isEmpty());
    assertSame(deviceProfiles, deviceProfiles2);
    assertSame(devices, devices2);
    assertSame(notifyOn, notifyOn2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult
        .devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder builderResult2 = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult2 = builderResult2
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult2 = deviceProfilesResult2
        .devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult2 = devicesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult
        .devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test:
   * {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceActivityNotificationRuleTriggerConfigBuilder = mock(
        DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder.class);
    when(deviceActivityNotificationRuleTriggerConfigBuilder.deviceProfiles(Mockito.<Set<UUID>>any()))
        .thenReturn(DeviceActivityNotificationRuleTriggerConfig.builder());
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = deviceActivityNotificationRuleTriggerConfigBuilder
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult
        .devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult2 = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult2 = deviceProfilesResult2
        .devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult2 = devicesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceActivityNotificationRuleTriggerConfigBuilder = mock(
        DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder.class);
    when(deviceActivityNotificationRuleTriggerConfigBuilder.devices(Mockito.<Set<UUID>>any()))
        .thenReturn(DeviceActivityNotificationRuleTriggerConfig.builder());
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceActivityNotificationRuleTriggerConfigBuilder2 = mock(
        DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder.class);
    when(deviceActivityNotificationRuleTriggerConfigBuilder2.deviceProfiles(Mockito.<Set<UUID>>any()))
        .thenReturn(deviceActivityNotificationRuleTriggerConfigBuilder);
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = deviceActivityNotificationRuleTriggerConfigBuilder2
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult
        .devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult2 = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult2 = deviceProfilesResult2
        .devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult2 = devicesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<UUID> devices = new HashSet<>();
    devices.add(EntityId.NULL_UUID);
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    builderResult.devices(devices);
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceActivityNotificationRuleTriggerConfigBuilder = mock(
        DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder.class);
    when(deviceActivityNotificationRuleTriggerConfigBuilder.devices(Mockito.<Set<UUID>>any()))
        .thenReturn(builderResult);
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceActivityNotificationRuleTriggerConfigBuilder2 = mock(
        DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder.class);
    when(deviceActivityNotificationRuleTriggerConfigBuilder2.deviceProfiles(Mockito.<Set<UUID>>any()))
        .thenReturn(deviceActivityNotificationRuleTriggerConfigBuilder);
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = deviceActivityNotificationRuleTriggerConfigBuilder2
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult
        .devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder builderResult2 = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult2 = builderResult2
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult2 = deviceProfilesResult2
        .devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult2 = devicesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult
        .devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test:
   * {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult
        .devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to DeviceActivityNotificationRuleTriggerConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeviceActivityNotificationRuleTriggerConfig#DeviceActivityNotificationRuleTriggerConfig()}
   *   <li>
   * {@link DeviceActivityNotificationRuleTriggerConfig#setDeviceProfiles(Set)}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#setDevices(Set)}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#toString()}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#getDeviceProfiles()}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#getDevices()}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceActivityNotificationRuleTriggerConfig actualDeviceActivityNotificationRuleTriggerConfig = new DeviceActivityNotificationRuleTriggerConfig();
    HashSet<UUID> deviceProfiles = new HashSet<>();
    actualDeviceActivityNotificationRuleTriggerConfig.setDeviceProfiles(deviceProfiles);
    HashSet<UUID> devices = new HashSet<>();
    actualDeviceActivityNotificationRuleTriggerConfig.setDevices(devices);
    HashSet<DeviceActivityNotificationRuleTriggerConfig.DeviceEvent> notifyOn = new HashSet<>();
    actualDeviceActivityNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualDeviceActivityNotificationRuleTriggerConfig.toString();
    Set<UUID> actualDeviceProfiles = actualDeviceActivityNotificationRuleTriggerConfig.getDeviceProfiles();
    Set<UUID> actualDevices = actualDeviceActivityNotificationRuleTriggerConfig.getDevices();
    Set<DeviceActivityNotificationRuleTriggerConfig.DeviceEvent> actualNotifyOn = actualDeviceActivityNotificationRuleTriggerConfig
        .getNotifyOn();

    // Assert that nothing has changed
    assertEquals("DeviceActivityNotificationRuleTriggerConfig(devices=[], deviceProfiles=[], notifyOn=[])",
        actualToStringResult);
    assertEquals(NotificationRuleTriggerType.DEVICE_ACTIVITY,
        actualDeviceActivityNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualDeviceProfiles.isEmpty());
    assertTrue(actualDevices.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(deviceProfiles, actualDeviceProfiles);
    assertSame(devices, actualDevices);
    assertSame(notifyOn, actualNotifyOn);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeviceActivityNotificationRuleTriggerConfig#DeviceActivityNotificationRuleTriggerConfig(Set, Set, Set)}
   *   <li>
   * {@link DeviceActivityNotificationRuleTriggerConfig#setDeviceProfiles(Set)}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#setDevices(Set)}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#toString()}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#getDeviceProfiles()}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#getDevices()}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    HashSet<UUID> devices = new HashSet<>();
    HashSet<UUID> deviceProfiles = new HashSet<>();

    // Act
    DeviceActivityNotificationRuleTriggerConfig actualDeviceActivityNotificationRuleTriggerConfig = new DeviceActivityNotificationRuleTriggerConfig(
        devices, deviceProfiles, new HashSet<>());
    HashSet<UUID> deviceProfiles2 = new HashSet<>();
    actualDeviceActivityNotificationRuleTriggerConfig.setDeviceProfiles(deviceProfiles2);
    HashSet<UUID> devices2 = new HashSet<>();
    actualDeviceActivityNotificationRuleTriggerConfig.setDevices(devices2);
    HashSet<DeviceActivityNotificationRuleTriggerConfig.DeviceEvent> notifyOn = new HashSet<>();
    actualDeviceActivityNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualDeviceActivityNotificationRuleTriggerConfig.toString();
    Set<UUID> actualDeviceProfiles = actualDeviceActivityNotificationRuleTriggerConfig.getDeviceProfiles();
    Set<UUID> actualDevices = actualDeviceActivityNotificationRuleTriggerConfig.getDevices();
    Set<DeviceActivityNotificationRuleTriggerConfig.DeviceEvent> actualNotifyOn = actualDeviceActivityNotificationRuleTriggerConfig
        .getNotifyOn();

    // Assert that nothing has changed
    assertEquals("DeviceActivityNotificationRuleTriggerConfig(devices=[], deviceProfiles=[], notifyOn=[])",
        actualToStringResult);
    assertEquals(NotificationRuleTriggerType.DEVICE_ACTIVITY,
        actualDeviceActivityNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualDeviceProfiles.isEmpty());
    assertTrue(actualDevices.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(deviceProfiles2, actualDeviceProfiles);
    assertSame(devices2, actualDevices);
    assertSame(notifyOn, actualNotifyOn);
  }
}
