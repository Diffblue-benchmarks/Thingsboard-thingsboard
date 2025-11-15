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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeviceInfoDiffblueTest {
  /**
   * Test {@link DeviceInfo#DeviceInfo(Device, String, boolean, String, boolean)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#DeviceInfo(Device, String, boolean, String, boolean)}
   */
  @Test
  @DisplayName("Test new DeviceInfo(Device, String, boolean, String, boolean); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceInfo.<init>(Device, String, boolean, String, boolean)"})
  void testNewDeviceInfo_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    DeviceInfo actualDeviceInfo = new DeviceInfo(device, "Dr", true, "foo.txt", true);

    // Assert
    assertTrue(actualDeviceInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("Dr", actualDeviceInfo.getCustomerTitle());
    assertEquals("foo.txt", actualDeviceInfo.getDeviceProfileName());
    assertNull(actualDeviceInfo.getDeviceDataBytes());
    assertNull(actualDeviceInfo.getVersion());
    assertNull(actualDeviceInfo.getLabel());
    assertNull(actualDeviceInfo.getName());
    assertNull(actualDeviceInfo.getType());
    assertNull(actualDeviceInfo.getUuidId());
    assertNull(actualDeviceInfo.getDeviceData());
    assertNull(actualDeviceInfo.getCustomerId());
    assertNull(actualDeviceInfo.getExternalId());
    assertNull(actualDeviceInfo.getId());
    assertNull(actualDeviceInfo.getDeviceProfileId());
    assertNull(actualDeviceInfo.getFirmwareId());
    assertNull(actualDeviceInfo.getSoftwareId());
    assertNull(actualDeviceInfo.getTenantId());
    assertEquals(0L, actualDeviceInfo.getCreatedTime());
    assertTrue(actualDeviceInfo.isActive());
    assertTrue(actualDeviceInfo.isCustomerIsPublic());
  }

  /**
   * Test {@link DeviceInfo#DeviceInfo(Device, String, boolean, String, boolean)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#DeviceInfo(Device, String, boolean, String, boolean)}
   */
  @Test
  @DisplayName("Test new DeviceInfo(Device, String, boolean, String, boolean); given empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceInfo.<init>(Device, String, boolean, String, boolean)"})
  void testNewDeviceInfo_givenEmptyArrayOfByte() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{});

    // Act
    DeviceInfo actualDeviceInfo = new DeviceInfo(device, "Dr", true, "foo.txt", true);

    // Assert
    assertTrue(actualDeviceInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("Dr", actualDeviceInfo.getCustomerTitle());
    assertEquals("foo.txt", actualDeviceInfo.getDeviceProfileName());
    assertNull(actualDeviceInfo.getDeviceDataBytes());
    assertNull(actualDeviceInfo.getVersion());
    assertNull(actualDeviceInfo.getLabel());
    assertNull(actualDeviceInfo.getName());
    assertNull(actualDeviceInfo.getType());
    assertNull(actualDeviceInfo.getUuidId());
    assertNull(actualDeviceInfo.getDeviceData());
    assertNull(actualDeviceInfo.getCustomerId());
    assertNull(actualDeviceInfo.getExternalId());
    assertNull(actualDeviceInfo.getId());
    assertNull(actualDeviceInfo.getDeviceProfileId());
    assertNull(actualDeviceInfo.getFirmwareId());
    assertNull(actualDeviceInfo.getSoftwareId());
    assertNull(actualDeviceInfo.getTenantId());
    assertEquals(0L, actualDeviceInfo.getCreatedTime());
    assertTrue(actualDeviceInfo.isActive());
    assertTrue(actualDeviceInfo.isCustomerIsPublic());
  }

  /**
   * Test {@link DeviceInfo#DeviceInfo(Device, String, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#DeviceInfo(Device, String, boolean, String, boolean)}
   */
  @Test
  @DisplayName("Test new DeviceInfo(Device, String, boolean, String, boolean); when Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceInfo.<init>(Device, String, boolean, String, boolean)"})
  void testNewDeviceInfo_whenDevice() {
    // Arrange and Act
    DeviceInfo actualDeviceInfo = new DeviceInfo(new Device(), "Dr", true, "foo.txt", true);

    // Assert
    assertTrue(actualDeviceInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("Dr", actualDeviceInfo.getCustomerTitle());
    assertEquals("foo.txt", actualDeviceInfo.getDeviceProfileName());
    assertNull(actualDeviceInfo.getDeviceDataBytes());
    assertNull(actualDeviceInfo.getVersion());
    assertNull(actualDeviceInfo.getLabel());
    assertNull(actualDeviceInfo.getName());
    assertNull(actualDeviceInfo.getType());
    assertNull(actualDeviceInfo.getUuidId());
    assertNull(actualDeviceInfo.getDeviceData());
    assertNull(actualDeviceInfo.getCustomerId());
    assertNull(actualDeviceInfo.getExternalId());
    assertNull(actualDeviceInfo.getId());
    assertNull(actualDeviceInfo.getDeviceProfileId());
    assertNull(actualDeviceInfo.getFirmwareId());
    assertNull(actualDeviceInfo.getSoftwareId());
    assertNull(actualDeviceInfo.getTenantId());
    assertEquals(0L, actualDeviceInfo.getCreatedTime());
    assertTrue(actualDeviceInfo.isActive());
    assertTrue(actualDeviceInfo.isCustomerIsPublic());
  }

  /**
   * Test {@link DeviceInfo#DeviceInfo(Device, String, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#DeviceInfo(Device, String, boolean, String, boolean)}
   */
  @Test
  @DisplayName("Test new DeviceInfo(Device, String, boolean, String, boolean); when Device(Device) with device is Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceInfo.<init>(Device, String, boolean, String, boolean)"})
  void testNewDeviceInfo_whenDeviceWithDeviceIsDevice() {
    // Arrange and Act
    DeviceInfo actualDeviceInfo = new DeviceInfo(new Device(new Device()), "Dr", true, "foo.txt", true);

    // Assert
    assertTrue(actualDeviceInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("Dr", actualDeviceInfo.getCustomerTitle());
    assertEquals("foo.txt", actualDeviceInfo.getDeviceProfileName());
    assertNull(actualDeviceInfo.getDeviceDataBytes());
    assertNull(actualDeviceInfo.getVersion());
    assertNull(actualDeviceInfo.getLabel());
    assertNull(actualDeviceInfo.getName());
    assertNull(actualDeviceInfo.getType());
    assertNull(actualDeviceInfo.getUuidId());
    assertNull(actualDeviceInfo.getDeviceData());
    assertNull(actualDeviceInfo.getCustomerId());
    assertNull(actualDeviceInfo.getExternalId());
    assertNull(actualDeviceInfo.getId());
    assertNull(actualDeviceInfo.getDeviceProfileId());
    assertNull(actualDeviceInfo.getFirmwareId());
    assertNull(actualDeviceInfo.getSoftwareId());
    assertNull(actualDeviceInfo.getTenantId());
    assertEquals(0L, actualDeviceInfo.getCreatedTime());
    assertTrue(actualDeviceInfo.isActive());
    assertTrue(actualDeviceInfo.isCustomerIsPublic());
  }

  /**
   * Test {@link DeviceInfo#DeviceInfo(Device, String, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is {@link Device#Device(Device)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#DeviceInfo(Device, String, boolean, String, boolean)}
   */
  @Test
  @DisplayName("Test new DeviceInfo(Device, String, boolean, String, boolean); when Device(Device) with device is Device(Device)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceInfo.<init>(Device, String, boolean, String, boolean)"})
  void testNewDeviceInfo_whenDeviceWithDeviceIsDevice2() {
    // Arrange and Act
    DeviceInfo actualDeviceInfo = new DeviceInfo(new Device(new Device(new Device())), "Dr", true, "foo.txt", true);

    // Assert
    assertTrue(actualDeviceInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("Dr", actualDeviceInfo.getCustomerTitle());
    assertEquals("foo.txt", actualDeviceInfo.getDeviceProfileName());
    assertNull(actualDeviceInfo.getDeviceDataBytes());
    assertNull(actualDeviceInfo.getVersion());
    assertNull(actualDeviceInfo.getLabel());
    assertNull(actualDeviceInfo.getName());
    assertNull(actualDeviceInfo.getType());
    assertNull(actualDeviceInfo.getUuidId());
    assertNull(actualDeviceInfo.getDeviceData());
    assertNull(actualDeviceInfo.getCustomerId());
    assertNull(actualDeviceInfo.getExternalId());
    assertNull(actualDeviceInfo.getId());
    assertNull(actualDeviceInfo.getDeviceProfileId());
    assertNull(actualDeviceInfo.getFirmwareId());
    assertNull(actualDeviceInfo.getSoftwareId());
    assertNull(actualDeviceInfo.getTenantId());
    assertEquals(0L, actualDeviceInfo.getCreatedTime());
    assertTrue(actualDeviceInfo.isActive());
    assertTrue(actualDeviceInfo.isCustomerIsPublic());
  }

  /**
   * Test {@link DeviceInfo#equals(Object)}, and {@link DeviceInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceInfo#equals(Object)}
   *   <li>{@link DeviceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceInfo.equals(Object)", "int DeviceInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();
    DeviceInfo deviceInfo2 = new DeviceInfo();

    // Act and Assert
    assertEquals(deviceInfo, deviceInfo2);
    int expectedHashCodeResult = deviceInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceInfo2.hashCode());
  }

  /**
   * Test {@link DeviceInfo#equals(Object)}, and {@link DeviceInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceInfo#equals(Object)}
   *   <li>{@link DeviceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceInfo.equals(Object)", "int DeviceInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo(new Device(), "Dr", true, "foo.txt", true);
    DeviceInfo deviceInfo2 = new DeviceInfo(new Device(), "Dr", true, "foo.txt", true);

    // Act and Assert
    assertEquals(deviceInfo, deviceInfo2);
    int notExpectedHashCodeResult = deviceInfo.hashCode();
    assertNotEquals(notExpectedHashCodeResult, deviceInfo2.hashCode());
  }

  /**
   * Test {@link DeviceInfo#equals(Object)}, and {@link DeviceInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceInfo#equals(Object)}
   *   <li>{@link DeviceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceInfo.equals(Object)", "int DeviceInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();

    // Act and Assert
    assertEquals(deviceInfo, deviceInfo);
    int expectedHashCodeResult = deviceInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceInfo.hashCode());
  }

  /**
   * Test {@link DeviceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceInfo.equals(Object)", "int DeviceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo(new Device(), "Dr", true, "foo.txt", true);

    // Act and Assert
    assertNotEquals(deviceInfo, new DeviceInfo());
  }

  /**
   * Test {@link DeviceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceInfo.equals(Object)", "int DeviceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();
    deviceInfo.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(deviceInfo, new DeviceInfo());
  }

  /**
   * Test {@link DeviceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceInfo.equals(Object)", "int DeviceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();
    deviceInfo.setCustomerIsPublic(true);

    // Act and Assert
    assertNotEquals(deviceInfo, new DeviceInfo());
  }

  /**
   * Test {@link DeviceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceInfo.equals(Object)", "int DeviceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();
    deviceInfo.setDeviceProfileName("foo.txt");

    // Act and Assert
    assertNotEquals(deviceInfo, new DeviceInfo());
  }

  /**
   * Test {@link DeviceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceInfo.equals(Object)", "int DeviceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();
    deviceInfo.setActive(true);

    // Act and Assert
    assertNotEquals(deviceInfo, new DeviceInfo());
  }

  /**
   * Test {@link DeviceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceInfo.equals(Object)", "int DeviceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();

    DeviceInfo deviceInfo2 = new DeviceInfo();
    deviceInfo2.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(deviceInfo, deviceInfo2);
  }

  /**
   * Test {@link DeviceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceInfo.equals(Object)", "int DeviceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();

    DeviceInfo deviceInfo2 = new DeviceInfo();
    deviceInfo2.setDeviceProfileName("foo.txt");

    // Act and Assert
    assertNotEquals(deviceInfo, deviceInfo2);
  }

  /**
   * Test {@link DeviceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceInfo.equals(Object)", "int DeviceInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceInfo(), null);
  }

  /**
   * Test {@link DeviceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceInfo.equals(Object)", "int DeviceInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceInfo(), "Different type to DeviceInfo");
  }
}
