package org.thingsboard.server.service.edge.rpc.constructor.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.UnknownFieldSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.gen.edge.v1.DeviceCredentialsUpdateMsg;
import org.thingsboard.server.gen.edge.v1.DeviceUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

@ExtendWith(MockitoExtension.class)
class DeviceMsgConstructorV1DiffblueTest {
  @InjectMocks private DeviceMsgConstructorV1 deviceMsgConstructorV1;

  /**
   * Test {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType, Device)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType,
   * Device)}
   */
  @Test
  @DisplayName("Test constructDeviceUpdatedMsg(UpdateMsgType, Device); given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceUpdateMsg DeviceMsgConstructorV1.constructDeviceUpdatedMsg(UpdateMsgType, Device)"
  })
  void testConstructDeviceUpdatedMsg_givenA() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    device.setLabel("Label");
    device.setCustomerId(null);
    device.setType("Type");
    device.setName("");
    device.setId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceUpdateMsg actualConstructDeviceUpdatedMsgResult =
        deviceMsgConstructorV1.constructDeviceUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, device);

    // Assert
    assertEquals("", actualConstructDeviceUpdatedMsgResult.getAdditionalInfo());
    assertEquals("Label", actualConstructDeviceUpdatedMsgResult.getLabel());
    assertEquals(34, actualConstructDeviceUpdatedMsgResult.getSerializedSize());
    assertEquals(4, actualConstructDeviceUpdatedMsgResult.getAllFields().size());
    assertFalse(actualConstructDeviceUpdatedMsgResult.hasAdditionalInfo());
    assertTrue(actualConstructDeviceUpdatedMsgResult.hasLabel());
  }

  /**
   * Test {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType, Device)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType,
   * Device)}
   */
  @Test
  @DisplayName("Test constructDeviceUpdatedMsg(UpdateMsgType, Device); given empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceUpdateMsg DeviceMsgConstructorV1.constructDeviceUpdatedMsg(UpdateMsgType, Device)"
  })
  void testConstructDeviceUpdatedMsg_givenEmptyArrayOfByte() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {});
    device.setLabel("Label");
    device.setCustomerId(null);
    device.setType("Type");
    device.setName("");
    device.setId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceUpdateMsg actualConstructDeviceUpdatedMsgResult =
        deviceMsgConstructorV1.constructDeviceUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, device);

    // Assert
    assertEquals("", actualConstructDeviceUpdatedMsgResult.getAdditionalInfo());
    assertEquals("Label", actualConstructDeviceUpdatedMsgResult.getLabel());
    assertEquals(34, actualConstructDeviceUpdatedMsgResult.getSerializedSize());
    assertEquals(4, actualConstructDeviceUpdatedMsgResult.getAllFields().size());
    assertFalse(actualConstructDeviceUpdatedMsgResult.hasAdditionalInfo());
    assertTrue(actualConstructDeviceUpdatedMsgResult.hasLabel());
  }

  /**
   * Test {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType, Device)}.
   *
   * <ul>
   *   <li>Then return AdditionalInfo is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType,
   * Device)}
   */
  @Test
  @DisplayName(
      "Test constructDeviceUpdatedMsg(UpdateMsgType, Device); then return AdditionalInfo is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceUpdateMsg DeviceMsgConstructorV1.constructDeviceUpdatedMsg(UpdateMsgType, Device)"
  })
  void testConstructDeviceUpdatedMsg_thenReturnAdditionalInfoIsEmptyString() {
    // Arrange
    Device device = new Device();
    device.setLabel("Label");
    device.setCustomerId(null);
    device.setType("Type");
    device.setName("");
    device.setId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceUpdateMsg actualConstructDeviceUpdatedMsgResult =
        deviceMsgConstructorV1.constructDeviceUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, device);

    // Assert
    assertEquals("", actualConstructDeviceUpdatedMsgResult.getAdditionalInfo());
    assertEquals("Label", actualConstructDeviceUpdatedMsgResult.getLabel());
    assertEquals(34, actualConstructDeviceUpdatedMsgResult.getSerializedSize());
    assertEquals(4, actualConstructDeviceUpdatedMsgResult.getAllFields().size());
    assertFalse(actualConstructDeviceUpdatedMsgResult.hasAdditionalInfo());
    assertTrue(actualConstructDeviceUpdatedMsgResult.hasLabel());
  }

  /**
   * Test {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType, Device)}.
   *
   * <ul>
   *   <li>Then return CustomerIdLSB is {@code -7476899250389416711}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType,
   * Device)}
   */
  @Test
  @DisplayName(
      "Test constructDeviceUpdatedMsg(UpdateMsgType, Device); then return CustomerIdLSB is '-7476899250389416711'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceUpdateMsg DeviceMsgConstructorV1.constructDeviceUpdatedMsg(UpdateMsgType, Device)"
  })
  void testConstructDeviceUpdatedMsg_thenReturnCustomerIdLSBIs7476899250389416711() {
    // Arrange
    Device device = new Device();
    device.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    device.setType("Type");
    device.setName("");
    device.setId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceUpdateMsg actualConstructDeviceUpdatedMsgResult =
        deviceMsgConstructorV1.constructDeviceUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, device);

    // Assert
    assertEquals(-7476899250389416711L, actualConstructDeviceUpdatedMsgResult.getCustomerIdLSB());
    assertEquals(48, actualConstructDeviceUpdatedMsgResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualConstructDeviceUpdatedMsgResult.getCustomerIdMSB());
    assertTrue(actualConstructDeviceUpdatedMsgResult.hasCustomerIdLSB());
    assertTrue(actualConstructDeviceUpdatedMsgResult.hasCustomerIdMSB());
  }

  /**
   * Test {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType, Device)}.
   *
   * <ul>
   *   <li>When {@link Device#Device()} Type is {@code Type}.
   *   <li>Then return Label is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType,
   * Device)}
   */
  @Test
  @DisplayName(
      "Test constructDeviceUpdatedMsg(UpdateMsgType, Device); when Device() Type is 'Type'; then return Label is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceUpdateMsg DeviceMsgConstructorV1.constructDeviceUpdatedMsg(UpdateMsgType, Device)"
  })
  void testConstructDeviceUpdatedMsg_whenDeviceTypeIsType_thenReturnLabelIsEmptyString() {
    // Arrange
    Device device = new Device();
    device.setType("Type");
    device.setName("");
    device.setId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceUpdateMsg actualConstructDeviceUpdatedMsgResult =
        deviceMsgConstructorV1.constructDeviceUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, device);

    // Assert
    assertEquals("", actualConstructDeviceUpdatedMsgResult.getLabel());
    assertEquals(27, actualConstructDeviceUpdatedMsgResult.getSerializedSize());
    assertEquals(3, actualConstructDeviceUpdatedMsgResult.getAllFields().size());
    assertFalse(actualConstructDeviceUpdatedMsgResult.hasLabel());
  }

  /**
   * Test {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType, Device)}.
   *
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType,
   * Device)}
   */
  @Test
  @DisplayName(
      "Test constructDeviceUpdatedMsg(UpdateMsgType, Device); when Device(Device) with device is Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceUpdateMsg DeviceMsgConstructorV1.constructDeviceUpdatedMsg(UpdateMsgType, Device)"
  })
  void testConstructDeviceUpdatedMsg_whenDeviceWithDeviceIsDevice() {
    // Arrange
    Device device = new Device(new Device(new Device()));
    device.setLabel("Label");
    device.setCustomerId(null);
    device.setType("Type");
    device.setName("");
    device.setId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceUpdateMsg actualConstructDeviceUpdatedMsgResult =
        deviceMsgConstructorV1.constructDeviceUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, device);

    // Assert
    UnknownFieldSet unknownFields = actualConstructDeviceUpdatedMsgResult.getUnknownFields();
    DeviceUpdateMsg defaultInstanceForType =
        actualConstructDeviceUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    ByteString expectedDeviceDataBytes = actualConstructDeviceUpdatedMsgResult.getDeviceDataBytes();
    assertSame(expectedDeviceDataBytes, defaultInstanceForType.getDeviceDataBytes());
  }

  /**
   * Test {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType, Device)}.
   *
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is {@link Device#Device()} Label is {@code
   *       Label}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMsgConstructorV1#constructDeviceUpdatedMsg(UpdateMsgType,
   * Device)}
   */
  @Test
  @DisplayName(
      "Test constructDeviceUpdatedMsg(UpdateMsgType, Device); when Device(Device) with device is Device() Label is 'Label'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceUpdateMsg DeviceMsgConstructorV1.constructDeviceUpdatedMsg(UpdateMsgType, Device)"
  })
  void testConstructDeviceUpdatedMsg_whenDeviceWithDeviceIsDeviceLabelIsLabel() {
    // Arrange
    Device device = new Device(new Device());
    device.setLabel("Label");
    device.setCustomerId(null);
    device.setType("Type");
    device.setName("");
    device.setId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceUpdateMsg actualConstructDeviceUpdatedMsgResult =
        deviceMsgConstructorV1.constructDeviceUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, device);

    // Assert
    UnknownFieldSet unknownFields = actualConstructDeviceUpdatedMsgResult.getUnknownFields();
    DeviceUpdateMsg defaultInstanceForType =
        actualConstructDeviceUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    ByteString expectedDeviceDataBytes = actualConstructDeviceUpdatedMsgResult.getDeviceDataBytes();
    assertSame(expectedDeviceDataBytes, defaultInstanceForType.getDeviceDataBytes());
  }

  /**
   * Test {@link DeviceMsgConstructorV1#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}.
   *
   * <p>Method under test: {@link
   * DeviceMsgConstructorV1#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test constructDeviceCredentialsUpdatedMsg(DeviceCredentials)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceCredentialsUpdateMsg DeviceMsgConstructorV1.constructDeviceCredentialsUpdatedMsg(DeviceCredentials)"
  })
  void testConstructDeviceCredentialsUpdatedMsg() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceCredentialsUpdateMsg actualConstructDeviceCredentialsUpdatedMsgResult =
        deviceMsgConstructorV1.constructDeviceCredentialsUpdatedMsg(deviceCredentials);

    // Assert
    Descriptor descriptorForType =
        actualConstructDeviceCredentialsUpdatedMsgResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getOneofs().size());
    assertEquals(2, actualConstructDeviceCredentialsUpdatedMsgResult.getAllFields().size());
    assertEquals(21, actualConstructDeviceCredentialsUpdatedMsgResult.getSerializedSize());
    DeviceCredentialsUpdateMsg defaultInstanceForType =
        actualConstructDeviceCredentialsUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields =
        actualConstructDeviceCredentialsUpdatedMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link DeviceMsgConstructorV1#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}.
   *
   * <p>Method under test: {@link
   * DeviceMsgConstructorV1#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test constructDeviceCredentialsUpdatedMsg(DeviceCredentials)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceCredentialsUpdateMsg DeviceMsgConstructorV1.constructDeviceCredentialsUpdatedMsg(DeviceCredentials)"
  })
  void testConstructDeviceCredentialsUpdatedMsg2() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(
            new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceCredentials.setCredentialsType(null);
    deviceCredentials.setCredentialsValue("Device Credentials");
    deviceCredentials.setCredentialsId(null);
    deviceCredentials.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceCredentialsUpdateMsg actualConstructDeviceCredentialsUpdatedMsgResult =
        deviceMsgConstructorV1.constructDeviceCredentialsUpdatedMsg(deviceCredentials);

    // Assert
    ByteString credentialsValueBytes =
        actualConstructDeviceCredentialsUpdatedMsgResult.getCredentialsValueBytes();
    assertEquals("Device Credentials", credentialsValueBytes.toStringUtf8());
    assertEquals(
        "Device Credentials",
        actualConstructDeviceCredentialsUpdatedMsgResult.getCredentialsValue());
    assertEquals(3, actualConstructDeviceCredentialsUpdatedMsgResult.getAllFields().size());
    assertEquals(41, actualConstructDeviceCredentialsUpdatedMsgResult.getSerializedSize());
    assertFalse(credentialsValueBytes.isEmpty());
    assertTrue(credentialsValueBytes.iterator().hasNext());
    assertTrue(actualConstructDeviceCredentialsUpdatedMsgResult.hasCredentialsValue());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceCredentialsUpdateMsg DeviceMsgConstructorV1.constructDeviceCredentialsUpdatedMsg(DeviceCredentials)"
  })
  void testConstructDeviceCredentialsUpdatedMsg_thenReturnCredentialsTypeIsAccessToken() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(
            new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsValue(null);
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
    assertEquals(4, actualConstructDeviceCredentialsUpdatedMsgResult.getAllFields().size());
    assertEquals(55, actualConstructDeviceCredentialsUpdatedMsgResult.getSerializedSize());
  }
}
