package org.thingsboard.server.service.edge.rpc.constructor.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.gen.edge.v1.DeviceCredentialsUpdateMsg;

class DeviceMsgConstructorV1DiffblueTest {
  /**
   * Test {@link DeviceMsgConstructorV1#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then return CredentialsId is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceMsgConstructorV1#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test constructDeviceCredentialsUpdatedMsg(DeviceCredentials); then return CredentialsId is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentialsUpdateMsg DeviceMsgConstructorV1.constructDeviceCredentialsUpdatedMsg(DeviceCredentials)"
  })
  void testConstructDeviceCredentialsUpdatedMsg_thenReturnCredentialsIdIsEmptyString() {
    // Arrange
    DeviceMsgConstructorV1 deviceMsgConstructorV1 = new DeviceMsgConstructorV1();

    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceCredentialsUpdateMsg actualConstructDeviceCredentialsUpdatedMsgResult =
        deviceMsgConstructorV1.constructDeviceCredentialsUpdatedMsg(deviceCredentials);

    // Assert
    assertEquals("", actualConstructDeviceCredentialsUpdatedMsgResult.getCredentialsId());
    assertEquals("", actualConstructDeviceCredentialsUpdatedMsgResult.getCredentialsType());
    assertEquals("", actualConstructDeviceCredentialsUpdatedMsgResult.getCredentialsValue());
    assertEquals(2, actualConstructDeviceCredentialsUpdatedMsgResult.getAllFields().size());
    assertEquals(21, actualConstructDeviceCredentialsUpdatedMsgResult.getSerializedSize());
    assertFalse(actualConstructDeviceCredentialsUpdatedMsgResult.hasCredentialsValue());
  }

  /**
   * Test {@link DeviceMsgConstructorV1#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then return CredentialsType is {@code ACCESS_TOKEN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceMsgConstructorV1#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test constructDeviceCredentialsUpdatedMsg(DeviceCredentials); then return CredentialsType is 'ACCESS_TOKEN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentialsUpdateMsg DeviceMsgConstructorV1.constructDeviceCredentialsUpdatedMsg(DeviceCredentials)"
  })
  void testConstructDeviceCredentialsUpdatedMsg_thenReturnCredentialsTypeIsAccessToken() {
    // Arrange
    DeviceMsgConstructorV1 deviceMsgConstructorV1 = new DeviceMsgConstructorV1();
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsValue("Device Credentials");
    deviceCredentials.setCredentialsId("Device Credentials");
    deviceCredentials.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceCredentialsUpdateMsg actualConstructDeviceCredentialsUpdatedMsgResult =
        deviceMsgConstructorV1.constructDeviceCredentialsUpdatedMsg(deviceCredentials);

    // Assert
    assertEquals(
        "ACCESS_TOKEN", actualConstructDeviceCredentialsUpdatedMsgResult.getCredentialsType());
    assertEquals(
        "Device Credentials", actualConstructDeviceCredentialsUpdatedMsgResult.getCredentialsId());
    assertEquals(
        "Device Credentials",
        actualConstructDeviceCredentialsUpdatedMsgResult.getCredentialsValue());
    assertEquals(5, actualConstructDeviceCredentialsUpdatedMsgResult.getAllFields().size());
    assertEquals(75, actualConstructDeviceCredentialsUpdatedMsgResult.getSerializedSize());
    assertTrue(actualConstructDeviceCredentialsUpdatedMsgResult.hasCredentialsValue());
  }
}
