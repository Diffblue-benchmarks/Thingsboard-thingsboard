package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.data.CoapDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.DefaultDeviceConfiguration;
import org.thingsboard.server.common.data.device.data.DefaultDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.DeviceConfiguration;
import org.thingsboard.server.common.data.device.data.DeviceData;
import org.thingsboard.server.common.data.device.data.DeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceDiffblueTest {
  /**
   * Test {@link Device#getExternalId()}.
   *
   * <p>Method under test: {@link Device#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.DeviceId Device.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new Device().getExternalId());
  }

  /**
   * Test {@link Device#Device(Device)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); given array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.<init>(Device)"})
  void testNewDevice_givenArrayOfByteWithAAndMinusOne() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualDevice = new Device(device);

    // Assert
    assertTrue(actualDevice.getAdditionalInfo() instanceof NullNode);
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(actualDevice.getVersion());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(0L, actualDevice.getCreatedTime());
  }

  /**
   * Test {@link Device#Device(Device)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); given array of byte with MAX_VALUE and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.<init>(Device)"})
  void testNewDevice_givenArrayOfByteWithMax_valueAndX() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualDevice = new Device(device);

    // Assert
    assertTrue(actualDevice.getAdditionalInfo() instanceof NullNode);
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(actualDevice.getVersion());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(0L, actualDevice.getCreatedTime());
  }

  /**
   * Test {@link Device#Device(Device)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); given array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.<init>(Device)"})
  void testNewDevice_givenArrayOfByteWithZeroAndX() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualDevice = new Device(device);

    // Assert
    assertTrue(actualDevice.getAdditionalInfo() instanceof NullNode);
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(actualDevice.getVersion());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(0L, actualDevice.getCreatedTime());
  }

  /**
   * Test {@link Device#Device(Device)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.<init>(Device)"})
  void testNewDevice_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Device actualDevice = new Device(device);

    // Assert
    assertTrue(actualDevice.getAdditionalInfo() instanceof NullNode);
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(actualDevice.getVersion());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(0L, actualDevice.getCreatedTime());
  }

  /**
   * Test {@link Device#Device(Device)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   *   <li>When {@link Device#Device()} DeviceDataBytes is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName(
      "Test new Device(Device); given empty array of byte; when Device() DeviceDataBytes is empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.<init>(Device)"})
  void testNewDevice_givenEmptyArrayOfByte_whenDeviceDeviceDataBytesIsEmptyArrayOfByte() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {});

    // Act
    Device actualDevice = new Device(device);

    // Assert
    assertTrue(actualDevice.getAdditionalInfo() instanceof NullNode);
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(actualDevice.getVersion());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(0L, actualDevice.getCreatedTime());
  }

  /**
   * Test {@link Device#Device(Device)}.
   *
   * <ul>
   *   <li>When {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); when Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.<init>(Device)"})
  void testNewDevice_whenDevice() {
    // Arrange and Act
    Device actualDevice = new Device(new Device());

    // Assert
    assertTrue(actualDevice.getAdditionalInfo() instanceof NullNode);
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(actualDevice.getVersion());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(0L, actualDevice.getCreatedTime());
  }

  /**
   * Test {@link Device#Device(Device)}.
   *
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); when Device(Device) with device is Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.<init>(Device)"})
  void testNewDevice_whenDeviceWithDeviceIsDevice() {
    // Arrange and Act
    Device actualDevice = new Device(new Device(new Device()));

    // Assert
    assertTrue(actualDevice.getAdditionalInfo() instanceof NullNode);
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(actualDevice.getVersion());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(0L, actualDevice.getCreatedTime());
  }

  /**
   * Test {@link Device#Device(Device)}.
   *
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is {@link Device#Device(Device)}.
   * </ul>
   *
   * <p>Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); when Device(Device) with device is Device(Device)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.<init>(Device)"})
  void testNewDevice_whenDeviceWithDeviceIsDevice2() {
    // Arrange and Act
    Device actualDevice = new Device(new Device(new Device(new Device())));

    // Assert
    assertTrue(actualDevice.getAdditionalInfo() instanceof NullNode);
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(actualDevice.getVersion());
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
    assertEquals(0L, actualDevice.getCreatedTime());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); given array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Device Device.updateDevice(Device)"})
  void testUpdateDevice_givenArrayOfByteWithAAndMinusOne() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualUpdateDeviceResult = device.updateDevice(device2);

    // Assert
    assertNull(actualUpdateDeviceResult.getDeviceDataBytes());
    assertNull(actualUpdateDeviceResult.getAdditionalInfo());
    assertNull(actualUpdateDeviceResult.getVersion());
    assertNull(actualUpdateDeviceResult.getLabel());
    assertNull(actualUpdateDeviceResult.getName());
    assertNull(actualUpdateDeviceResult.getType());
    assertNull(actualUpdateDeviceResult.getUuidId());
    assertNull(actualUpdateDeviceResult.getDeviceData());
    assertNull(actualUpdateDeviceResult.getCustomerId());
    assertNull(actualUpdateDeviceResult.getExternalId());
    assertNull(actualUpdateDeviceResult.getId());
    assertNull(actualUpdateDeviceResult.getDeviceProfileId());
    assertNull(actualUpdateDeviceResult.getFirmwareId());
    assertNull(actualUpdateDeviceResult.getSoftwareId());
    assertNull(actualUpdateDeviceResult.getTenantId());
    assertEquals(0L, actualUpdateDeviceResult.getCreatedTime());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); given array of byte with MAX_VALUE and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Device Device.updateDevice(Device)"})
  void testUpdateDevice_givenArrayOfByteWithMax_valueAndX() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes(new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualUpdateDeviceResult = device.updateDevice(device2);

    // Assert
    assertNull(actualUpdateDeviceResult.getDeviceDataBytes());
    assertNull(actualUpdateDeviceResult.getAdditionalInfo());
    assertNull(actualUpdateDeviceResult.getVersion());
    assertNull(actualUpdateDeviceResult.getLabel());
    assertNull(actualUpdateDeviceResult.getName());
    assertNull(actualUpdateDeviceResult.getType());
    assertNull(actualUpdateDeviceResult.getUuidId());
    assertNull(actualUpdateDeviceResult.getDeviceData());
    assertNull(actualUpdateDeviceResult.getCustomerId());
    assertNull(actualUpdateDeviceResult.getExternalId());
    assertNull(actualUpdateDeviceResult.getId());
    assertNull(actualUpdateDeviceResult.getDeviceProfileId());
    assertNull(actualUpdateDeviceResult.getFirmwareId());
    assertNull(actualUpdateDeviceResult.getSoftwareId());
    assertNull(actualUpdateDeviceResult.getTenantId());
    assertEquals(0L, actualUpdateDeviceResult.getCreatedTime());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); given array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Device Device.updateDevice(Device)"})
  void testUpdateDevice_givenArrayOfByteWithZeroAndX() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualUpdateDeviceResult = device.updateDevice(device2);

    // Assert
    assertNull(actualUpdateDeviceResult.getDeviceDataBytes());
    assertNull(actualUpdateDeviceResult.getAdditionalInfo());
    assertNull(actualUpdateDeviceResult.getVersion());
    assertNull(actualUpdateDeviceResult.getLabel());
    assertNull(actualUpdateDeviceResult.getName());
    assertNull(actualUpdateDeviceResult.getType());
    assertNull(actualUpdateDeviceResult.getUuidId());
    assertNull(actualUpdateDeviceResult.getDeviceData());
    assertNull(actualUpdateDeviceResult.getCustomerId());
    assertNull(actualUpdateDeviceResult.getExternalId());
    assertNull(actualUpdateDeviceResult.getId());
    assertNull(actualUpdateDeviceResult.getDeviceProfileId());
    assertNull(actualUpdateDeviceResult.getFirmwareId());
    assertNull(actualUpdateDeviceResult.getSoftwareId());
    assertNull(actualUpdateDeviceResult.getTenantId());
    assertEquals(0L, actualUpdateDeviceResult.getCreatedTime());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Device Device.updateDevice(Device)"})
  void testUpdateDevice_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Device actualUpdateDeviceResult = device.updateDevice(device2);

    // Assert
    assertNull(actualUpdateDeviceResult.getDeviceDataBytes());
    assertNull(actualUpdateDeviceResult.getAdditionalInfo());
    assertNull(actualUpdateDeviceResult.getVersion());
    assertNull(actualUpdateDeviceResult.getLabel());
    assertNull(actualUpdateDeviceResult.getName());
    assertNull(actualUpdateDeviceResult.getType());
    assertNull(actualUpdateDeviceResult.getUuidId());
    assertNull(actualUpdateDeviceResult.getDeviceData());
    assertNull(actualUpdateDeviceResult.getCustomerId());
    assertNull(actualUpdateDeviceResult.getExternalId());
    assertNull(actualUpdateDeviceResult.getId());
    assertNull(actualUpdateDeviceResult.getDeviceProfileId());
    assertNull(actualUpdateDeviceResult.getFirmwareId());
    assertNull(actualUpdateDeviceResult.getSoftwareId());
    assertNull(actualUpdateDeviceResult.getTenantId());
    assertEquals(0L, actualUpdateDeviceResult.getCreatedTime());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); given empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Device Device.updateDevice(Device)"})
  void testUpdateDevice_givenEmptyArrayOfByte() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes(new byte[] {});

    // Act
    Device actualUpdateDeviceResult = device.updateDevice(device2);

    // Assert
    assertNull(actualUpdateDeviceResult.getDeviceDataBytes());
    assertNull(actualUpdateDeviceResult.getAdditionalInfo());
    assertNull(actualUpdateDeviceResult.getVersion());
    assertNull(actualUpdateDeviceResult.getLabel());
    assertNull(actualUpdateDeviceResult.getName());
    assertNull(actualUpdateDeviceResult.getType());
    assertNull(actualUpdateDeviceResult.getUuidId());
    assertNull(actualUpdateDeviceResult.getDeviceData());
    assertNull(actualUpdateDeviceResult.getCustomerId());
    assertNull(actualUpdateDeviceResult.getExternalId());
    assertNull(actualUpdateDeviceResult.getId());
    assertNull(actualUpdateDeviceResult.getDeviceProfileId());
    assertNull(actualUpdateDeviceResult.getFirmwareId());
    assertNull(actualUpdateDeviceResult.getSoftwareId());
    assertNull(actualUpdateDeviceResult.getTenantId());
    assertEquals(0L, actualUpdateDeviceResult.getCreatedTime());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   *
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is {@link Device#Device()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName(
      "Test updateDevice(Device); when Device(Device) with device is Device(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Device Device.updateDevice(Device)"})
  void testUpdateDevice_whenDeviceWithDeviceIsDevice_thenAdditionalInfoReturnNullNode() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertTrue(
        device.updateDevice(new Device(new Device())).getAdditionalInfo() instanceof NullNode);
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   *
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is {@link Device#Device(Device)}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName(
      "Test updateDevice(Device); when Device(Device) with device is Device(Device); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Device Device.updateDevice(Device)"})
  void testUpdateDevice_whenDeviceWithDeviceIsDevice_thenAdditionalInfoReturnNullNode2() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertTrue(
        device.updateDevice(new Device(new Device(new Device()))).getAdditionalInfo()
            instanceof NullNode);
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   *
   * <ul>
   *   <li>When {@link Device#Device()}.
   *   <li>Then return {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); when Device(); then return Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Device Device.updateDevice(Device)"})
  void testUpdateDevice_whenDevice_thenReturnDevice() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertSame(device, device.updateDevice(new Device()));
  }

  /**
   * Test {@link Device#getId()}.
   *
   * <p>Method under test: {@link Device#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.DeviceId Device.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new Device().getId());
  }

  /**
   * Test {@link Device#getCreatedTime()}.
   *
   * <p>Method under test: {@link Device#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Device.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new Device().getCreatedTime());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   *
   * <p>Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceData Device.getDeviceData()"})
  void testGetDeviceData() {
    // Arrange
    Device device = new Device(new Device());
    device.setDeviceDataBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData(); given Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceData Device.getDeviceData()"})
  void testGetDeviceData_givenDevice() {
    // Arrange, Act and Assert
    assertNull(new Device().getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is array of {@code byte} with {@code A} and
   *       minus one.
   * </ul>
   *
   * <p>Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName(
      "Test getDeviceData(); given Device() DeviceDataBytes is array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceData Device.getDeviceData()"})
  void testGetDeviceData_givenDeviceDeviceDataBytesIsArrayOfByteWithAAndMinusOne() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is array of {@code byte} with {@link
   *       Byte#MAX_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName(
      "Test getDeviceData(); given Device() DeviceDataBytes is array of byte with MAX_VALUE and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceData Device.getDeviceData()"})
  void testGetDeviceData_givenDeviceDeviceDataBytesIsArrayOfByteWithMax_valueAndX() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is array of {@code byte} with zero and
   *       {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName(
      "Test getDeviceData(); given Device() DeviceDataBytes is array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceData Device.getDeviceData()"})
  void testGetDeviceData_givenDeviceDeviceDataBytesIsArrayOfByteWithZeroAndX() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is array of {@code byte} with zero and
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName(
      "Test getDeviceData(); given Device() DeviceDataBytes is array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceData Device.getDeviceData()"})
  void testGetDeviceData_givenDeviceDeviceDataBytesIsArrayOfByteWithZeroAndZero() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is array of {@code byte} with zero and
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName(
      "Test getDeviceData(); given Device() DeviceDataBytes is array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceData Device.getDeviceData()"})
  void testGetDeviceData_givenDeviceDeviceDataBytesIsArrayOfByteWithZeroAndZero2() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {0, 0, 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName(
      "Test getDeviceData(); given Device() DeviceDataBytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceData Device.getDeviceData()"})
  void testGetDeviceData_givenDeviceDeviceDataBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData(); given Device() DeviceDataBytes is empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceData Device.getDeviceData()"})
  void testGetDeviceData_givenDeviceDeviceDataBytesIsEmptyArrayOfByte() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   *
   * <ul>
   *   <li>Given {@link Device#Device(Device)} with device is {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData(); given Device(Device) with device is Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceData Device.getDeviceData()"})
  void testGetDeviceData_givenDeviceWithDeviceIsDevice() {
    // Arrange
    Device device = new Device(new Device(new Device()));
    device.setDeviceDataBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();
    DeviceData data = new DeviceData();

    // Act
    device.setDeviceData(data);

    // Assert
    assertSame(data, device.getDeviceData());
    byte[] expectedDeviceDataBytes =
        "{\"configuration\":null,\"transportConfiguration\":null}".getBytes("UTF-8");
    assertArrayEquals(expectedDeviceDataBytes, device.getDeviceDataBytes());
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   *
   * <ul>
   *   <li>Given {@link CoapDeviceTransportConfiguration} (default constructor) {@code null} is
   *       {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName(
      "Test setDeviceData(DeviceData); given CoapDeviceTransportConfiguration (default constructor) 'null' is 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData_givenCoapDeviceTransportConfigurationNullIsValue() {
    // Arrange
    Device device = new Device();

    CoapDeviceTransportConfiguration transportConfiguration =
        new CoapDeviceTransportConfiguration();
    transportConfiguration.put(null, "Value");

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(transportConfiguration);

    // Act
    device.setDeviceData(data);

    // Assert
    assertNull(device.getDeviceDataBytes());
    assertSame(data, device.getDeviceData());
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   *
   * <ul>
   *   <li>Given {@link DeviceConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); given DeviceConfiguration")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData_givenDeviceConfiguration() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(mock(DeviceConfiguration.class));
    data.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act
    device.setDeviceData(data);

    // Assert
    assertNull(device.getDeviceDataBytes());
    assertSame(data, device.getDeviceData());
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   *
   * <ul>
   *   <li>Given {@link DeviceInfo#DeviceInfo()}.
   *   <li>Then {@link DeviceInfo#DeviceInfo()} DeviceDataBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName(
      "Test setDeviceData(DeviceData); given DeviceInfo(); then DeviceInfo() DeviceDataBytes is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData_givenDeviceInfo_thenDeviceInfoDeviceDataBytesIsNull() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();

    DeviceData data = new DeviceData();
    data.setConfiguration(mock(DeviceConfiguration.class));
    data.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act
    deviceInfo.setDeviceData(data);

    // Assert
    assertNull(deviceInfo.getDeviceDataBytes());
    assertSame(data, deviceInfo.getDeviceData());
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()}.
   *   <li>When {@code null}.
   *   <li>Then {@link Device#Device()} DeviceData is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName(
      "Test setDeviceData(DeviceData); given Device(); when 'null'; then Device() DeviceData is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData_givenDevice_whenNull_thenDeviceDeviceDataIsNull() {
    // Arrange
    Device device = new Device();

    // Act
    device.setDeviceData(null);

    // Assert that nothing has changed
    assertNull(device.getDeviceDataBytes());
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   *
   * <ul>
   *   <li>Then array length is eighty.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); then array length is eighty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData_thenArrayLengthIsEighty() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(new DefaultDeviceTransportConfiguration());

    // Act
    device.setDeviceData(data);

    // Assert
    assertEquals(80, device.getDeviceDataBytes().length);
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   *
   * <ul>
   *   <li>Then array length is one hundred sixty-seven.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); then array length is one hundred sixty-seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData_thenArrayLengthIsOneHundredSixtySeven() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(new CoapDeviceTransportConfiguration());

    // Act
    device.setDeviceData(data);

    // Assert
    assertEquals(167, device.getDeviceDataBytes().length);
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   *
   * <ul>
   *   <li>Then array length is three hundred thirty-three.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); then array length is three hundred thirty-three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData_thenArrayLengthIsThreeHundredThirtyThree() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(new SnmpDeviceTransportConfiguration());

    // Act
    device.setDeviceData(data);

    // Assert
    assertEquals(333, device.getDeviceDataBytes().length);
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   *
   * <ul>
   *   <li>Then array length is two hundred fifty-seven.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); then array length is two hundred fifty-seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData_thenArrayLengthIsTwoHundredFiftySeven() {
    // Arrange
    Device device = new Device();

    CoapDeviceTransportConfiguration transportConfiguration =
        new CoapDeviceTransportConfiguration();
    transportConfiguration.put(
        "org.thingsboard.server.common.data.device.data.CoapDeviceTransportConfiguration", "Value");

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(transportConfiguration);

    // Act
    device.setDeviceData(data);

    // Assert
    assertEquals(257, device.getDeviceDataBytes().length);
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   *
   * <ul>
   *   <li>Then {@link Device#Device()} DeviceDataBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); then Device() DeviceDataBytes is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData_thenDeviceDeviceDataBytesIsNull() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act
    device.setDeviceData(data);

    // Assert
    assertNull(device.getDeviceDataBytes());
    assertSame(data, device.getDeviceData());
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   *
   * <ul>
   *   <li>Then {@link Device#Device(Device)} with device is {@link Device#Device()} DeviceDataBytes
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName(
      "Test setDeviceData(DeviceData); then Device(Device) with device is Device() DeviceDataBytes is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData_thenDeviceWithDeviceIsDeviceDeviceDataBytesIsNull() {
    // Arrange
    Device device = new Device(new Device());

    DeviceData data = new DeviceData();
    data.setConfiguration(mock(DeviceConfiguration.class));
    data.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act
    device.setDeviceData(data);

    // Assert
    assertNull(device.getDeviceDataBytes());
    assertSame(data, device.getDeviceData());
  }

  /**
   * Test {@link Device#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Device#getAdditionalInfo()}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfo(); given Device() DeviceDataBytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode Device.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenDeviceDeviceDataBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    JsonNode actualAdditionalInfo = new Device(device).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Device#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link Device#Device(Device)} with device is {@link Device#Device()}.
   *   <li>Then return {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link Device#getAdditionalInfo()}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfo(); given Device(Device) with device is Device(); then return instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode Device.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenDeviceWithDeviceIsDevice_thenReturnInstance() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = new Device(new Device()).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Device#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link Device#Device(Device)} with device is {@link Device#Device(Device)}.
   *   <li>Then return {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link Device#getAdditionalInfo()}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfo(); given Device(Device) with device is Device(Device); then return instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode Device.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenDeviceWithDeviceIsDevice_thenReturnInstance2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = new Device(new Device(new Device())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Device#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Device#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Device(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode Device.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenDevice_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Device().getAdditionalInfo());
  }

  /**
   * Test {@link Device#equals(Object)}, and {@link Device#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Device#equals(Object)}
   *   <li>{@link Device#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Device device = new Device();
    Device device2 = new Device();

    // Act and Assert
    assertEquals(device, device2);
    int expectedHashCodeResult = device.hashCode();
    assertEquals(expectedHashCodeResult, device2.hashCode());
  }

  /**
   * Test {@link Device#equals(Object)}, and {@link Device#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Device#equals(Object)}
   *   <li>{@link Device#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertEquals(device, device);
    int expectedHashCodeResult = device.hashCode();
    assertEquals(expectedHashCodeResult, device.hashCode());
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();

    // Act and Assert
    assertNotEquals(deviceInfo, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Device device = new Device(new Device());

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertNotEquals(device, new DeviceInfo());
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Device device = new Device();
    device.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Device device = new Device();
    device.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Device device = new Device();
    device.setName("Name");

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Device device = new Device();
    device.setType("Type");

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Device device = new Device();
    device.setLabel("Label");

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Device device = new Device();
    device.setVersion(1L);

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setName("Name");

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setType("Type");

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setLabel("Label");

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setVersion(1L);

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Device(), null);
  }

  /**
   * Test {@link Device#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Device(), "Different type to Device");
  }
}
