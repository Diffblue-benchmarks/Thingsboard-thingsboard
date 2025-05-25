package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.notification.rule.trigger.config.DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.DeviceActivityNotificationRuleTriggerConfig.DeviceEvent;

@ContextConfiguration(classes = {DeviceActivityNotificationRuleTriggerConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class DeviceActivityNotificationRuleTriggerConfigDiffblueTest {
  @Autowired
  private DeviceActivityNotificationRuleTriggerConfigBuilder deviceActivityNotificationRuleTriggerConfigBuilder;

  /**
   * Test DeviceActivityNotificationRuleTriggerConfigBuilder {@link DeviceActivityNotificationRuleTriggerConfigBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfigBuilder#build()}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfigBuilder#deviceProfiles(Set)}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfigBuilder#devices(Set)}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfigBuilder#notifyOn(Set)}
   * </ul>
   */
  @Test
  @DisplayName("Test DeviceActivityNotificationRuleTriggerConfigBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceActivityNotificationRuleTriggerConfigBuilder.<init>()",
      "DeviceActivityNotificationRuleTriggerConfig DeviceActivityNotificationRuleTriggerConfigBuilder.build()",
      "DeviceActivityNotificationRuleTriggerConfigBuilder DeviceActivityNotificationRuleTriggerConfigBuilder.deviceProfiles(Set)",
      "DeviceActivityNotificationRuleTriggerConfigBuilder DeviceActivityNotificationRuleTriggerConfigBuilder.devices(Set)",
      "DeviceActivityNotificationRuleTriggerConfigBuilder DeviceActivityNotificationRuleTriggerConfigBuilder.notifyOn(Set)",
      "String DeviceActivityNotificationRuleTriggerConfigBuilder.toString()"})
  void testDeviceActivityNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    HashSet<UUID> deviceProfiles = new HashSet<>();
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = builderResult
        .deviceProfiles(deviceProfiles);
    HashSet<UUID> devices = new HashSet<>();
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult.devices(devices);
    HashSet<DeviceEvent> notifyOn = new HashSet<>();

    // Act
    DeviceActivityNotificationRuleTriggerConfig actualBuildResult = devicesResult.notifyOn(notifyOn).build();

    // Assert
    assertEquals("#", actualBuildResult.getDeduplicationKey());
    assertEquals(NotificationRuleTriggerType.DEVICE_ACTIVITY, actualBuildResult.getTriggerType());
    Set<UUID> deviceProfiles2 = actualBuildResult.getDeviceProfiles();
    assertTrue(deviceProfiles2.isEmpty());
    Set<UUID> devices2 = actualBuildResult.getDevices();
    assertTrue(devices2.isEmpty());
    Set<DeviceEvent> notifyOn2 = actualBuildResult.getNotifyOn();
    assertTrue(notifyOn2.isEmpty());
    assertSame(deviceProfiles, deviceProfiles2);
    assertSame(devices, devices2);
    assertSame(notifyOn, notifyOn2);
  }

  /**
   * Test {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}, and {@link DeviceActivityNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceActivityNotificationRuleTriggerConfig.equals(Object)",
      "int DeviceActivityNotificationRuleTriggerConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult.devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();
    DeviceActivityNotificationRuleTriggerConfigBuilder builderResult2 = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult2 = builderResult2
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult2 = deviceProfilesResult2.devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult2 = devicesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}, and {@link DeviceActivityNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceActivityNotificationRuleTriggerConfig.equals(Object)",
      "int DeviceActivityNotificationRuleTriggerConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult.devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceActivityNotificationRuleTriggerConfig.equals(Object)",
      "int DeviceActivityNotificationRuleTriggerConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceActivityNotificationRuleTriggerConfigBuilder = mock(
        DeviceActivityNotificationRuleTriggerConfigBuilder.class);
    when(deviceActivityNotificationRuleTriggerConfigBuilder.deviceProfiles(Mockito.<Set<UUID>>any()))
        .thenReturn(DeviceActivityNotificationRuleTriggerConfig.builder());
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = deviceActivityNotificationRuleTriggerConfigBuilder
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult.devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();
    DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult2 = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult2 = deviceProfilesResult2.devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult2 = devicesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceActivityNotificationRuleTriggerConfig.equals(Object)",
      "int DeviceActivityNotificationRuleTriggerConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceActivityNotificationRuleTriggerConfigBuilder = mock(
        DeviceActivityNotificationRuleTriggerConfigBuilder.class);
    when(deviceActivityNotificationRuleTriggerConfigBuilder.devices(Mockito.<Set<UUID>>any()))
        .thenReturn(DeviceActivityNotificationRuleTriggerConfig.builder());
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceActivityNotificationRuleTriggerConfigBuilder2 = mock(
        DeviceActivityNotificationRuleTriggerConfigBuilder.class);
    when(deviceActivityNotificationRuleTriggerConfigBuilder2.deviceProfiles(Mockito.<Set<UUID>>any()))
        .thenReturn(deviceActivityNotificationRuleTriggerConfigBuilder);
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = deviceActivityNotificationRuleTriggerConfigBuilder2
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult.devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();
    DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult2 = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult2 = deviceProfilesResult2.devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult2 = devicesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceActivityNotificationRuleTriggerConfig.equals(Object)",
      "int DeviceActivityNotificationRuleTriggerConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<UUID> devices = new HashSet<>();
    devices.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    builderResult.devices(devices);
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceActivityNotificationRuleTriggerConfigBuilder = mock(
        DeviceActivityNotificationRuleTriggerConfigBuilder.class);
    when(deviceActivityNotificationRuleTriggerConfigBuilder.devices(Mockito.<Set<UUID>>any()))
        .thenReturn(builderResult);
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceActivityNotificationRuleTriggerConfigBuilder2 = mock(
        DeviceActivityNotificationRuleTriggerConfigBuilder.class);
    when(deviceActivityNotificationRuleTriggerConfigBuilder2.deviceProfiles(Mockito.<Set<UUID>>any()))
        .thenReturn(deviceActivityNotificationRuleTriggerConfigBuilder);
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = deviceActivityNotificationRuleTriggerConfigBuilder2
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult.devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();
    DeviceActivityNotificationRuleTriggerConfigBuilder builderResult2 = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult2 = builderResult2
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult2 = deviceProfilesResult2.devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult2 = devicesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceActivityNotificationRuleTriggerConfig.equals(Object)",
      "int DeviceActivityNotificationRuleTriggerConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult.devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceActivityNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceActivityNotificationRuleTriggerConfig.equals(Object)",
      "int DeviceActivityNotificationRuleTriggerConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult.devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig buildResult = devicesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to DeviceActivityNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#DeviceActivityNotificationRuleTriggerConfig()}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#setDeviceProfiles(Set)}
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceActivityNotificationRuleTriggerConfig.<init>()",
      "void DeviceActivityNotificationRuleTriggerConfig.<init>(Set, Set, Set)",
      "Set DeviceActivityNotificationRuleTriggerConfig.getDeviceProfiles()",
      "Set DeviceActivityNotificationRuleTriggerConfig.getDevices()",
      "Set DeviceActivityNotificationRuleTriggerConfig.getNotifyOn()",
      "NotificationRuleTriggerType DeviceActivityNotificationRuleTriggerConfig.getTriggerType()",
      "void DeviceActivityNotificationRuleTriggerConfig.setDeviceProfiles(Set)",
      "void DeviceActivityNotificationRuleTriggerConfig.setDevices(Set)",
      "void DeviceActivityNotificationRuleTriggerConfig.setNotifyOn(Set)",
      "String DeviceActivityNotificationRuleTriggerConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceActivityNotificationRuleTriggerConfig actualDeviceActivityNotificationRuleTriggerConfig = new DeviceActivityNotificationRuleTriggerConfig();
    HashSet<UUID> deviceProfiles = new HashSet<>();
    actualDeviceActivityNotificationRuleTriggerConfig.setDeviceProfiles(deviceProfiles);
    HashSet<UUID> devices = new HashSet<>();
    actualDeviceActivityNotificationRuleTriggerConfig.setDevices(devices);
    HashSet<DeviceEvent> notifyOn = new HashSet<>();
    actualDeviceActivityNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualDeviceActivityNotificationRuleTriggerConfig.toString();
    Set<UUID> actualDeviceProfiles = actualDeviceActivityNotificationRuleTriggerConfig.getDeviceProfiles();
    Set<UUID> actualDevices = actualDeviceActivityNotificationRuleTriggerConfig.getDevices();
    Set<DeviceEvent> actualNotifyOn = actualDeviceActivityNotificationRuleTriggerConfig.getNotifyOn();

    // Assert
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#DeviceActivityNotificationRuleTriggerConfig(Set, Set, Set)}
   *   <li>{@link DeviceActivityNotificationRuleTriggerConfig#setDeviceProfiles(Set)}
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
  @DisplayName("Test getters and setters; when HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceActivityNotificationRuleTriggerConfig.<init>()",
      "void DeviceActivityNotificationRuleTriggerConfig.<init>(Set, Set, Set)",
      "Set DeviceActivityNotificationRuleTriggerConfig.getDeviceProfiles()",
      "Set DeviceActivityNotificationRuleTriggerConfig.getDevices()",
      "Set DeviceActivityNotificationRuleTriggerConfig.getNotifyOn()",
      "NotificationRuleTriggerType DeviceActivityNotificationRuleTriggerConfig.getTriggerType()",
      "void DeviceActivityNotificationRuleTriggerConfig.setDeviceProfiles(Set)",
      "void DeviceActivityNotificationRuleTriggerConfig.setDevices(Set)",
      "void DeviceActivityNotificationRuleTriggerConfig.setNotifyOn(Set)",
      "String DeviceActivityNotificationRuleTriggerConfig.toString()"})
  void testGettersAndSetters_whenHashSet() {
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
    HashSet<DeviceEvent> notifyOn = new HashSet<>();
    actualDeviceActivityNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualDeviceActivityNotificationRuleTriggerConfig.toString();
    Set<UUID> actualDeviceProfiles = actualDeviceActivityNotificationRuleTriggerConfig.getDeviceProfiles();
    Set<UUID> actualDevices = actualDeviceActivityNotificationRuleTriggerConfig.getDevices();
    Set<DeviceEvent> actualNotifyOn = actualDeviceActivityNotificationRuleTriggerConfig.getNotifyOn();

    // Assert
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
