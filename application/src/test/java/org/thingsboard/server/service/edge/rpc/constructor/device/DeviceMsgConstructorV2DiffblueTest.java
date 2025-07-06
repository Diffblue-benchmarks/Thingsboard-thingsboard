package org.thingsboard.server.service.edge.rpc.constructor.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceCredentialsUpdateMsg DeviceMsgConstructorV2.constructDeviceCredentialsUpdatedMsg(DeviceCredentials)"
  })
  void testConstructDeviceCredentialsUpdatedMsg() {
    // Arrange
    DeviceMsgConstructorV2 deviceMsgConstructorV2 = new DeviceMsgConstructorV2();

    // Act
    DeviceCredentialsUpdateMsg actualConstructDeviceCredentialsUpdatedMsgResult =
        deviceMsgConstructorV2.constructDeviceCredentialsUpdatedMsg(
            new DeviceCredentials(
                new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Assert
    assertEquals(
        "{\"id\":{\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"deviceId\":null,\"credentialsType"
            + "\":null,\"credentialsId\":null,\"credentialsValue\":null,\"version\":null}",
        actualConstructDeviceCredentialsUpdatedMsgResult.getEntityBytes().toStringUtf8());
    assertEquals(
        "{\"id\":{\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"deviceId\":null,\"credentialsType"
            + "\":null,\"credentialsId\":null,\"credentialsValue\":null,\"version\":null}",
        actualConstructDeviceCredentialsUpdatedMsgResult.getEntity());
    assertEquals(170, actualConstructDeviceCredentialsUpdatedMsgResult.getSerializedSize());
    UnknownFieldSet unknownFields =
        actualConstructDeviceCredentialsUpdatedMsgResult.getUnknownFields();
    DeviceCredentialsUpdateMsg defaultInstanceForType =
        actualConstructDeviceCredentialsUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link DeviceMsgConstructorV2#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}.
   *
   * <p>Method under test: {@link
   * DeviceMsgConstructorV2#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test constructDeviceCredentialsUpdatedMsg(DeviceCredentials)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceCredentialsUpdateMsg DeviceMsgConstructorV2.constructDeviceCredentialsUpdatedMsg(DeviceCredentials)"
  })
  void testConstructDeviceCredentialsUpdatedMsg2() {
    // Arrange
    DeviceMsgConstructorV2 deviceMsgConstructorV2 = new DeviceMsgConstructorV2();

    // Act
    DeviceCredentialsUpdateMsg actualConstructDeviceCredentialsUpdatedMsgResult =
        deviceMsgConstructorV2.constructDeviceCredentialsUpdatedMsg(
            new DeviceCredentials(new DeviceCredentials()));

    // Assert
    UnknownFieldSet unknownFields =
        actualConstructDeviceCredentialsUpdatedMsgResult.getUnknownFields();
    DeviceCredentialsUpdateMsg defaultInstanceForType =
        actualConstructDeviceCredentialsUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link DeviceMsgConstructorV2#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}.
   *
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceMsgConstructorV2#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test constructDeviceCredentialsUpdatedMsg(DeviceCredentials); when DeviceCredentials()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceCredentialsUpdateMsg DeviceMsgConstructorV2.constructDeviceCredentialsUpdatedMsg(DeviceCredentials)"
  })
  void testConstructDeviceCredentialsUpdatedMsg_whenDeviceCredentials() {
    // Arrange
    DeviceMsgConstructorV2 deviceMsgConstructorV2 = new DeviceMsgConstructorV2();

    // Act
    DeviceCredentialsUpdateMsg actualConstructDeviceCredentialsUpdatedMsgResult =
        deviceMsgConstructorV2.constructDeviceCredentialsUpdatedMsg(new DeviceCredentials());

    // Assert
    UnknownFieldSet unknownFields =
        actualConstructDeviceCredentialsUpdatedMsgResult.getUnknownFields();
    DeviceCredentialsUpdateMsg defaultInstanceForType =
        actualConstructDeviceCredentialsUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }
}
