package org.thingsboard.server.service.edge.rpc.constructor.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.gen.edge.v1.DeviceCredentialsUpdateMsg;

class DeviceMsgConstructorV2DiffblueTest {
  /**
   * Test {@link DeviceMsgConstructorV2#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}.
   *
   * <p>Method under test: {@link
   * DeviceMsgConstructorV2#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test constructDeviceCredentialsUpdatedMsg(DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentialsUpdateMsg DeviceMsgConstructorV2.constructDeviceCredentialsUpdatedMsg(DeviceCredentials)"
  })
  void testConstructDeviceCredentialsUpdatedMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DeviceMsgConstructorV2 deviceMsgConstructorV2 = new DeviceMsgConstructorV2();

    // Act
    DeviceCredentialsUpdateMsg actualConstructDeviceCredentialsUpdatedMsgResult =
        deviceMsgConstructorV2.constructDeviceCredentialsUpdatedMsg(new DeviceCredentials());

    // Assert
    assertEquals(
        "", actualConstructDeviceCredentialsUpdatedMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructDeviceCredentialsUpdatedMsgResult.getCredentialsId());
    assertEquals("", actualConstructDeviceCredentialsUpdatedMsgResult.getCredentialsType());
    assertEquals("", actualConstructDeviceCredentialsUpdatedMsgResult.getCredentialsValue());
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"deviceId\":null,\"credentialsType\":null,\"credentialsId\":null,\"credentialsValue"
            + "\":null,\"version\":null}",
        actualConstructDeviceCredentialsUpdatedMsgResult.getEntity());
    assertEquals(0L, actualConstructDeviceCredentialsUpdatedMsgResult.getDeviceIdLSB());
    assertEquals(0L, actualConstructDeviceCredentialsUpdatedMsgResult.getDeviceIdMSB());
    assertEquals(1, actualConstructDeviceCredentialsUpdatedMsgResult.getAllFields().size());
    assertEquals(128, actualConstructDeviceCredentialsUpdatedMsgResult.getSerializedSize());
    assertFalse(actualConstructDeviceCredentialsUpdatedMsgResult.hasCredentialsValue());
    assertTrue(
        actualConstructDeviceCredentialsUpdatedMsgResult.findInitializationErrors().isEmpty());
  }
}
