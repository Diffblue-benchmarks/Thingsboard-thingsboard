package org.thingsboard.server.service.edge.rpc.constructor.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.gen.edge.v1.DeviceProfileUpdateMsg;
import org.thingsboard.server.gen.edge.v1.DeviceUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class BaseDeviceMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseDeviceMsgConstructor#constructDeviceDeleteMsg(DeviceId)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDeviceMsgConstructor#constructDeviceDeleteMsg(DeviceId)}
   */
  @Test
  @DisplayName("Test constructDeviceDeleteMsg(DeviceId); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceUpdateMsg BaseDeviceMsgConstructor.constructDeviceDeleteMsg(DeviceId)"})
  void testConstructDeviceDeleteMsg_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    DeviceMsgConstructorV1 deviceMsgConstructorV1 = new DeviceMsgConstructorV1();

    // Act
    DeviceUpdateMsg actualConstructDeviceDeleteMsgResult = deviceMsgConstructorV1
        .constructDeviceDeleteMsg(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructDeviceDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructDeviceDeleteMsgResult.getAdditionalInfo());
    assertEquals("", actualConstructDeviceDeleteMsgResult.getConflictName());
    assertEquals("", actualConstructDeviceDeleteMsgResult.getEntity());
    assertEquals("", actualConstructDeviceDeleteMsgResult.getLabel());
    assertEquals("", actualConstructDeviceDeleteMsgResult.getName());
    assertEquals("", actualConstructDeviceDeleteMsgResult.getType());
    assertEquals(-7476899250389416711L, actualConstructDeviceDeleteMsgResult.getIdLSB());
    assertEquals(0L, actualConstructDeviceDeleteMsgResult.getCustomerIdLSB());
    assertEquals(0L, actualConstructDeviceDeleteMsgResult.getCustomerIdMSB());
    assertEquals(0L, actualConstructDeviceDeleteMsgResult.getDeviceProfileIdLSB());
    assertEquals(0L, actualConstructDeviceDeleteMsgResult.getDeviceProfileIdMSB());
    assertEquals(0L, actualConstructDeviceDeleteMsgResult.getFirmwareIdLSB());
    assertEquals(0L, actualConstructDeviceDeleteMsgResult.getFirmwareIdMSB());
    assertEquals(0L, actualConstructDeviceDeleteMsgResult.getSoftwareIdLSB());
    assertEquals(0L, actualConstructDeviceDeleteMsgResult.getSoftwareIdMSB());
    assertEquals(2, actualConstructDeviceDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructDeviceDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructDeviceDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructDeviceDeleteMsgResult.getIdMSB());
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, actualConstructDeviceDeleteMsgResult.getMsgType());
    assertFalse(actualConstructDeviceDeleteMsgResult.hasAdditionalInfo());
    assertFalse(actualConstructDeviceDeleteMsgResult.hasConflictName());
    assertFalse(actualConstructDeviceDeleteMsgResult.hasCustomerIdLSB());
    assertFalse(actualConstructDeviceDeleteMsgResult.hasCustomerIdMSB());
    assertFalse(actualConstructDeviceDeleteMsgResult.hasDeviceDataBytes());
    assertFalse(actualConstructDeviceDeleteMsgResult.hasDeviceProfileIdLSB());
    assertFalse(actualConstructDeviceDeleteMsgResult.hasDeviceProfileIdMSB());
    assertFalse(actualConstructDeviceDeleteMsgResult.hasFirmwareIdLSB());
    assertFalse(actualConstructDeviceDeleteMsgResult.hasFirmwareIdMSB());
    assertFalse(actualConstructDeviceDeleteMsgResult.hasLabel());
    assertFalse(actualConstructDeviceDeleteMsgResult.hasSoftwareIdLSB());
    assertFalse(actualConstructDeviceDeleteMsgResult.hasSoftwareIdMSB());
    assertTrue(actualConstructDeviceDeleteMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructDeviceDeleteMsgResult.isInitialized());
  }

  /**
   * Test {@link BaseDeviceMsgConstructor#constructDeviceProfileDeleteMsg(DeviceProfileId)}.
   * <p>
   * Method under test: {@link BaseDeviceMsgConstructor#constructDeviceProfileDeleteMsg(DeviceProfileId)}
   */
  @Test
  @DisplayName("Test constructDeviceProfileDeleteMsg(DeviceProfileId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DeviceProfileUpdateMsg BaseDeviceMsgConstructor.constructDeviceProfileDeleteMsg(DeviceProfileId)"})
  void testConstructDeviceProfileDeleteMsg() {
    // Arrange
    DeviceMsgConstructorV1 deviceMsgConstructorV1 = new DeviceMsgConstructorV1();

    // Act
    DeviceProfileUpdateMsg actualConstructDeviceProfileDeleteMsgResult = deviceMsgConstructorV1
        .constructDeviceProfileDeleteMsg(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructDeviceProfileDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructDeviceProfileDeleteMsgResult.getDefaultQueueName());
    assertEquals("", actualConstructDeviceProfileDeleteMsgResult.getDescription());
    assertEquals("", actualConstructDeviceProfileDeleteMsgResult.getEntity());
    assertEquals("", actualConstructDeviceProfileDeleteMsgResult.getName());
    assertEquals("", actualConstructDeviceProfileDeleteMsgResult.getProvisionDeviceKey());
    assertEquals("", actualConstructDeviceProfileDeleteMsgResult.getProvisionType());
    assertEquals("", actualConstructDeviceProfileDeleteMsgResult.getTransportType());
    assertEquals("", actualConstructDeviceProfileDeleteMsgResult.getType());
    assertEquals(-7476899250389416711L, actualConstructDeviceProfileDeleteMsgResult.getIdLSB());
    assertEquals(0L, actualConstructDeviceProfileDeleteMsgResult.getDefaultDashboardIdLSB());
    assertEquals(0L, actualConstructDeviceProfileDeleteMsgResult.getDefaultDashboardIdMSB());
    assertEquals(0L, actualConstructDeviceProfileDeleteMsgResult.getDefaultRuleChainIdLSB());
    assertEquals(0L, actualConstructDeviceProfileDeleteMsgResult.getDefaultRuleChainIdMSB());
    assertEquals(0L, actualConstructDeviceProfileDeleteMsgResult.getFirmwareIdLSB());
    assertEquals(0L, actualConstructDeviceProfileDeleteMsgResult.getFirmwareIdMSB());
    assertEquals(0L, actualConstructDeviceProfileDeleteMsgResult.getSoftwareIdLSB());
    assertEquals(0L, actualConstructDeviceProfileDeleteMsgResult.getSoftwareIdMSB());
    assertEquals(2, actualConstructDeviceProfileDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructDeviceProfileDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructDeviceProfileDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructDeviceProfileDeleteMsgResult.getIdMSB());
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, actualConstructDeviceProfileDeleteMsgResult.getMsgType());
    assertFalse(actualConstructDeviceProfileDeleteMsgResult.getDefault());
    assertFalse(actualConstructDeviceProfileDeleteMsgResult.hasDefaultDashboardIdLSB());
    assertFalse(actualConstructDeviceProfileDeleteMsgResult.hasDefaultDashboardIdMSB());
    assertFalse(actualConstructDeviceProfileDeleteMsgResult.hasDescription());
    assertFalse(actualConstructDeviceProfileDeleteMsgResult.hasFirmwareIdLSB());
    assertFalse(actualConstructDeviceProfileDeleteMsgResult.hasFirmwareIdMSB());
    assertFalse(actualConstructDeviceProfileDeleteMsgResult.hasImage());
    assertFalse(actualConstructDeviceProfileDeleteMsgResult.hasProvisionDeviceKey());
    assertFalse(actualConstructDeviceProfileDeleteMsgResult.hasProvisionType());
    assertFalse(actualConstructDeviceProfileDeleteMsgResult.hasSoftwareIdLSB());
    assertFalse(actualConstructDeviceProfileDeleteMsgResult.hasSoftwareIdMSB());
    assertFalse(actualConstructDeviceProfileDeleteMsgResult.hasTransportType());
    assertTrue(actualConstructDeviceProfileDeleteMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructDeviceProfileDeleteMsgResult.isInitialized());
    ByteString expectedProfileDataBytes = actualConstructDeviceProfileDeleteMsgResult.getImage();
    assertSame(expectedProfileDataBytes, actualConstructDeviceProfileDeleteMsgResult.getProfileDataBytes());
  }
}
