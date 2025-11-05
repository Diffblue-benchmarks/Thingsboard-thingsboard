package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.device.data.CoapDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.DefaultDeviceConfiguration;
import org.thingsboard.server.common.data.device.data.DefaultDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.DeviceConfiguration;
import org.thingsboard.server.common.data.device.data.DeviceData;
import org.thingsboard.server.common.data.device.data.DeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;

class DeviceDiffblueTest {
  /**
   * Test {@link Device#getExternalId()}.
   *
   * <p>Method under test: {@link Device#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(0L, actualDevice.createdTime);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(0L, actualDevice.createdTime);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(0L, actualDevice.createdTime);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(0L, actualDevice.createdTime);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(0L, actualDevice.createdTime);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(0L, actualDevice.createdTime);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(0L, actualDevice.createdTime);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Device.<init>(Device)"})
  void testNewDevice_whenDeviceWithDeviceIsDevice2() {
    // Arrange
    Device device = new Device(new Device(new Device()));

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
    assertEquals(0L, actualDevice.createdTime);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(0L, actualUpdateDeviceResult.createdTime);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(0L, actualUpdateDeviceResult.createdTime);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(0L, actualUpdateDeviceResult.createdTime);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(0L, actualUpdateDeviceResult.createdTime);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(0L, actualUpdateDeviceResult.createdTime);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device Device.updateDevice(Device)"})
  void testUpdateDevice_whenDevice_thenReturnDevice() {
    // Arrange
    Device device = new Device();

    // Act
    Device actualUpdateDeviceResult = device.updateDevice(new Device());

    // Assert
    assertSame(device, actualUpdateDeviceResult);
  }

  /**
   * Test {@link Device#getId()}.
   *
   * <p>Method under test: {@link Device#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Device.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new Device().getCreatedTime());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>Given {@link Device#Device()} DeviceDataBytes is array of {@code byte} with zero and
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName(
      "Test getDeviceData(); given Device() DeviceDataBytes is array of byte with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceData Device.getDeviceData()"})
  void testGetDeviceData_givenDeviceDeviceDataBytesIsArrayOfByteWithZeroAndZero3() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {0, 0, 'A', -1, 'A', 'X', 'A', 'X'});

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceData Device.getDeviceData()"})
  void testGetDeviceData_givenDeviceDeviceDataBytesIsEmptyArrayOfByte() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {});

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(null);
    data.setTransportConfiguration(null);

    // Act
    device.setDeviceData(data);

    // Assert
    assertSame(data, device.getDeviceData());
    assertArrayEquals(
        "{\"configuration\":null,\"transportConfiguration\":null}".getBytes("UTF-8"),
        device.getDeviceDataBytes());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>Given {@link DeviceTransportConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); given DeviceTransportConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData_givenDeviceTransportConfiguration() {
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
   *   <li>Given {@code null}.
   *   <li>When {@link DeviceData} (default constructor) Configuration is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName(
      "Test setDeviceData(DeviceData); given 'null'; when DeviceData (default constructor) Configuration is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData_givenNull_whenDeviceDataConfigurationIsNull() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(null);
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
   *   <li>Then array length is eighty.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); then array length is eighty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>When {@code null}.
   *   <li>Then {@link Device#Device()} DeviceData is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); when 'null'; then Device() DeviceData is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Device.setDeviceData(DeviceData)"})
  void testSetDeviceData_whenNull_thenDeviceDeviceDataIsNull() {
    // Arrange
    Device device = new Device();

    // Act
    device.setDeviceData(null);

    // Assert that nothing has changed
    assertNull(device.getDeviceDataBytes());
    assertNull(device.getDeviceData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Device device = new Device();
    Device device2 = new Device();

    // Act and Assert
    assertEquals(device, device2);
    assertEquals(device.hashCode(), device2.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();

    DeviceInfo deviceInfo2 = mock(DeviceInfo.class);
    when(deviceInfo2.getVersion()).thenReturn(1L);
    when(deviceInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceInfo, deviceInfo2);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Device.equals(Object)", "int Device.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Device(), "Different type to Device");
  }
}
