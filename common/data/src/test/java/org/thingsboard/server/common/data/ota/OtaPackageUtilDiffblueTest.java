package org.thingsboard.server.common.data.ota;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.HasOtaPackage;
import org.thingsboard.server.common.data.id.OtaPackageId;

class OtaPackageUtilDiffblueTest {
  /**
   * Test {@link OtaPackageUtil#getAttributeKeys(OtaPackageType)}.
   * <ul>
   *   <li>When {@code FIRMWARE}.</li>
   *   <li>Then return sixth is {@code fw_checksum}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageUtil#getAttributeKeys(OtaPackageType)}
   */
  @Test
  @DisplayName("Test getAttributeKeys(OtaPackageType); when 'FIRMWARE'; then return sixth is 'fw_checksum'")
  void testGetAttributeKeys_whenFirmware_thenReturnSixthIsFwChecksum() {
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
   * Test {@link OtaPackageUtil#getAttributeKeys(OtaPackageType)}.
   * <ul>
   *   <li>When {@code SOFTWARE}.</li>
   *   <li>Then return sixth is {@code sw_checksum}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageUtil#getAttributeKeys(OtaPackageType)}
   */
  @Test
  @DisplayName("Test getAttributeKeys(OtaPackageType); when 'SOFTWARE'; then return sixth is 'sw_checksum'")
  void testGetAttributeKeys_whenSoftware_thenReturnSixthIsSwChecksum() {
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
   * Test {@link OtaPackageUtil#getAttributeKey(OtaPackageType, OtaPackageKey)}.
   * <p>
   * Method under test:
   * {@link OtaPackageUtil#getAttributeKey(OtaPackageType, OtaPackageKey)}
   */
  @Test
  @DisplayName("Test getAttributeKey(OtaPackageType, OtaPackageKey)")
  void testGetAttributeKey() {
    // Arrange, Act and Assert
    assertEquals("fw_title", OtaPackageUtil.getAttributeKey(OtaPackageType.FIRMWARE, OtaPackageKey.TITLE));
  }

  /**
   * Test
   * {@link OtaPackageUtil#getTargetTelemetryKey(OtaPackageType, OtaPackageKey)}.
   * <p>
   * Method under test:
   * {@link OtaPackageUtil#getTargetTelemetryKey(OtaPackageType, OtaPackageKey)}
   */
  @Test
  @DisplayName("Test getTargetTelemetryKey(OtaPackageType, OtaPackageKey)")
  void testGetTargetTelemetryKey() {
    // Arrange, Act and Assert
    assertEquals("target_fw_title", OtaPackageUtil.getTargetTelemetryKey(OtaPackageType.FIRMWARE, OtaPackageKey.TITLE));
  }

  /**
   * Test
   * {@link OtaPackageUtil#getCurrentTelemetryKey(OtaPackageType, OtaPackageKey)}.
   * <p>
   * Method under test:
   * {@link OtaPackageUtil#getCurrentTelemetryKey(OtaPackageType, OtaPackageKey)}
   */
  @Test
  @DisplayName("Test getCurrentTelemetryKey(OtaPackageType, OtaPackageKey)")
  void testGetCurrentTelemetryKey() {
    // Arrange, Act and Assert
    assertEquals("current_fw_title",
        OtaPackageUtil.getCurrentTelemetryKey(OtaPackageType.FIRMWARE, OtaPackageKey.TITLE));
  }

  /**
   * Test {@link OtaPackageUtil#getTelemetryKey(OtaPackageType, OtaPackageKey)}
   * with {@code type}, {@code key}.
   * <p>
   * Method under test:
   * {@link OtaPackageUtil#getTelemetryKey(OtaPackageType, OtaPackageKey)}
   */
  @Test
  @DisplayName("Test getTelemetryKey(OtaPackageType, OtaPackageKey) with 'type', 'key'")
  void testGetTelemetryKeyWithTypeKey() {
    // Arrange, Act and Assert
    assertEquals("fw_title", OtaPackageUtil.getTelemetryKey(OtaPackageType.FIRMWARE, OtaPackageKey.TITLE));
  }

  /**
   * Test {@link OtaPackageUtil#getOtaPackageId(HasOtaPackage, OtaPackageType)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link HasOtaPackage#getFirmwareId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageUtil#getOtaPackageId(HasOtaPackage, OtaPackageType)}
   */
  @Test
  @DisplayName("Test getOtaPackageId(HasOtaPackage, OtaPackageType); given 'null'; then calls getFirmwareId()")
  void testGetOtaPackageId_givenNull_thenCallsGetFirmwareId() {
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
   * Test {@link OtaPackageUtil#getOtaPackageId(HasOtaPackage, OtaPackageType)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageUtil#getOtaPackageId(HasOtaPackage, OtaPackageType)}
   */
  @Test
  @DisplayName("Test getOtaPackageId(HasOtaPackage, OtaPackageType); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testGetOtaPackageId_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    HasOtaPackage entity = mock(HasOtaPackage.class);
    when(entity.getSoftwareId()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> OtaPackageUtil.getOtaPackageId(entity, OtaPackageType.SOFTWARE));
    verify(entity).getSoftwareId();
  }

  /**
   * Test {@link OtaPackageUtil#getOtaPackageId(HasOtaPackage, OtaPackageType)}.
   * <ul>
   *   <li>When {@link Device#Device()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageUtil#getOtaPackageId(HasOtaPackage, OtaPackageType)}
   */
  @Test
  @DisplayName("Test getOtaPackageId(HasOtaPackage, OtaPackageType); when Device(); then return 'null'")
  void testGetOtaPackageId_whenDevice_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(OtaPackageUtil.getOtaPackageId(new Device(), OtaPackageType.FIRMWARE));
    assertNull(OtaPackageUtil.getOtaPackageId(new Device(), OtaPackageType.SOFTWARE));
  }

  /**
   * Test
   * {@link OtaPackageUtil#getByOtaPackageType(Supplier, Supplier, OtaPackageType)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageUtil#getByOtaPackageType(Supplier, Supplier, OtaPackageType)}
   */
  @Test
  @DisplayName("Test getByOtaPackageType(Supplier, Supplier, OtaPackageType); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testGetByOtaPackageType_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
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

  /**
   * Test
   * {@link OtaPackageUtil#getByOtaPackageType(Supplier, Supplier, OtaPackageType)}.
   * <ul>
   *   <li>When {@code SOFTWARE}.</li>
   *   <li>Then return {@code Get}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageUtil#getByOtaPackageType(Supplier, Supplier, OtaPackageType)}
   */
  @Test
  @DisplayName("Test getByOtaPackageType(Supplier, Supplier, OtaPackageType); when 'SOFTWARE'; then return 'Get'")
  void testGetByOtaPackageType_whenSoftware_thenReturnGet() {
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
   * Test
   * {@link OtaPackageUtil#getByOtaPackageType(Supplier, Supplier, OtaPackageType)}.
   * <ul>
   *   <li>When {@link Supplier}.</li>
   *   <li>Then return {@code Get}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageUtil#getByOtaPackageType(Supplier, Supplier, OtaPackageType)}
   */
  @Test
  @DisplayName("Test getByOtaPackageType(Supplier, Supplier, OtaPackageType); when Supplier; then return 'Get'")
  void testGetByOtaPackageType_whenSupplier_thenReturnGet() {
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
}
