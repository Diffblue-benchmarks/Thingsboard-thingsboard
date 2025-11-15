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
package org.thingsboard.server.common.data.ota;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.HasOtaPackage;
import org.thingsboard.server.common.data.id.OtaPackageId;

class OtaPackageUtilDiffblueTest {
  /**
   * Method under test: {@link OtaPackageUtil#getAttributeKeys(OtaPackageType)}
   */
  @Test
  void testGetAttributeKeys() {
    // Arrange and Act
    List<String> actualAttributeKeys = OtaPackageUtil.getAttributeKeys(OtaPackageType.FIRMWARE);

    // Assert
    assertEquals(9, actualAttributeKeys.size());
    assertEquals("fw_checksum", actualAttributeKeys.get(5));
    assertEquals("fw_checksum_algorithm", actualAttributeKeys.get(6));
    assertEquals("fw_size", actualAttributeKeys.get(4));
    assertEquals("fw_state", actualAttributeKeys.get(3));
    assertEquals("fw_tag", actualAttributeKeys.get(8));
    assertEquals("fw_title", actualAttributeKeys.get(0));
    assertEquals("fw_ts", actualAttributeKeys.get(2));
    assertEquals("fw_url", actualAttributeKeys.get(7));
    assertEquals("fw_version", actualAttributeKeys.get(1));
  }

  /**
   * Method under test: {@link OtaPackageUtil#getAttributeKeys(OtaPackageType)}
   */
  @Test
  void testGetAttributeKeys2() {
    // Arrange and Act
    List<String> actualAttributeKeys = OtaPackageUtil.getAttributeKeys(OtaPackageType.SOFTWARE);

    // Assert
    assertEquals(9, actualAttributeKeys.size());
    assertEquals("sw_checksum", actualAttributeKeys.get(5));
    assertEquals("sw_checksum_algorithm", actualAttributeKeys.get(6));
    assertEquals("sw_size", actualAttributeKeys.get(4));
    assertEquals("sw_state", actualAttributeKeys.get(3));
    assertEquals("sw_tag", actualAttributeKeys.get(8));
    assertEquals("sw_title", actualAttributeKeys.get(0));
    assertEquals("sw_ts", actualAttributeKeys.get(2));
    assertEquals("sw_url", actualAttributeKeys.get(7));
    assertEquals("sw_version", actualAttributeKeys.get(1));
  }

  /**
   * Method under test:
   * {@link OtaPackageUtil#getAttributeKey(OtaPackageType, OtaPackageKey)}
   */
  @Test
  void testGetAttributeKey() {
    // Arrange, Act and Assert
    assertEquals("fw_title", OtaPackageUtil.getAttributeKey(OtaPackageType.FIRMWARE, OtaPackageKey.TITLE));
  }

  /**
   * Method under test:
   * {@link OtaPackageUtil#getTargetTelemetryKey(OtaPackageType, OtaPackageKey)}
   */
  @Test
  void testGetTargetTelemetryKey() {
    // Arrange, Act and Assert
    assertEquals("target_fw_title", OtaPackageUtil.getTargetTelemetryKey(OtaPackageType.FIRMWARE, OtaPackageKey.TITLE));
  }

  /**
   * Method under test:
   * {@link OtaPackageUtil#getCurrentTelemetryKey(OtaPackageType, OtaPackageKey)}
   */
  @Test
  void testGetCurrentTelemetryKey() {
    // Arrange, Act and Assert
    assertEquals("current_fw_title",
        OtaPackageUtil.getCurrentTelemetryKey(OtaPackageType.FIRMWARE, OtaPackageKey.TITLE));
  }

  /**
   * Method under test:
   * {@link OtaPackageUtil#getTelemetryKey(OtaPackageType, OtaPackageKey)}
   */
  @Test
  void testGetTelemetryKey() {
    // Arrange, Act and Assert
    assertEquals("fw_title", OtaPackageUtil.getTelemetryKey(OtaPackageType.FIRMWARE, OtaPackageKey.TITLE));
  }

  /**
   * Method under test:
   * {@link OtaPackageUtil#getOtaPackageId(HasOtaPackage, OtaPackageType)}
   */
  @Test
  void testGetOtaPackageId() {
    // Arrange, Act and Assert
    assertNull(OtaPackageUtil.getOtaPackageId(new Device(), OtaPackageType.FIRMWARE));
    assertNull(OtaPackageUtil.getOtaPackageId(new Device(), OtaPackageType.SOFTWARE));
  }

  /**
   * Method under test:
   * {@link OtaPackageUtil#getOtaPackageId(HasOtaPackage, OtaPackageType)}
   */
  @Test
  void testGetOtaPackageId2() {
    // Arrange
    HasOtaPackage entity = mock(HasOtaPackage.class);
    when(entity.getFirmwareId()).thenReturn(null);

    // Act
    OtaPackageId actualOtaPackageId = OtaPackageUtil.getOtaPackageId(entity, OtaPackageType.FIRMWARE);

    // Assert
    verify(entity).getFirmwareId();
    assertNull(actualOtaPackageId);
  }

  /**
   * Method under test:
   * {@link OtaPackageUtil#getOtaPackageId(HasOtaPackage, OtaPackageType)}
   */
  @Test
  void testGetOtaPackageId3() {
    // Arrange
    HasOtaPackage entity = mock(HasOtaPackage.class);
    when(entity.getSoftwareId()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> OtaPackageUtil.getOtaPackageId(entity, OtaPackageType.SOFTWARE));
    verify(entity).getSoftwareId();
  }

  /**
   * Method under test:
   * {@link OtaPackageUtil#getByOtaPackageType(Supplier, Supplier, OtaPackageType)}
   */
  @Test
  void testGetByOtaPackageType() {
    // Arrange
    Supplier<Object> firmwareSupplier = mock(Supplier.class);
    when(firmwareSupplier.get()).thenReturn("Get");

    // Act
    Object actualByOtaPackageType = OtaPackageUtil.getByOtaPackageType(firmwareSupplier, mock(Supplier.class),
        OtaPackageType.FIRMWARE);

    // Assert
    verify(firmwareSupplier).get();
    assertEquals("Get", actualByOtaPackageType);
  }

  /**
   * Method under test:
   * {@link OtaPackageUtil#getByOtaPackageType(Supplier, Supplier, OtaPackageType)}
   */
  @Test
  void testGetByOtaPackageType2() {
    // Arrange
    Supplier<Object> firmwareSupplier = mock(Supplier.class);
    when(firmwareSupplier.get()).thenReturn("Get");
    Supplier<Object> softwareSupplier = mock(Supplier.class);
    when(softwareSupplier.get()).thenReturn("Get");

    // Act
    Object actualByOtaPackageType = OtaPackageUtil.getByOtaPackageType(firmwareSupplier, softwareSupplier,
        OtaPackageType.SOFTWARE);

    // Assert
    verify(softwareSupplier).get();
    assertEquals("Get", actualByOtaPackageType);
  }

  /**
   * Method under test:
   * {@link OtaPackageUtil#getByOtaPackageType(Supplier, Supplier, OtaPackageType)}
   */
  @Test
  void testGetByOtaPackageType3() {
    // Arrange
    Supplier<Object> firmwareSupplier = mock(Supplier.class);
    when(firmwareSupplier.get()).thenReturn("Get");
    Supplier<Object> softwareSupplier = mock(Supplier.class);
    when(softwareSupplier.get()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> OtaPackageUtil.getByOtaPackageType(firmwareSupplier, softwareSupplier, OtaPackageType.SOFTWARE));
    verify(softwareSupplier).get();
  }
}
