package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.Iterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.OtaPackageInfo;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

class OtaPackageInfoEntityDiffblueTest {
  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}, and {@link OtaPackageInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackageInfoEntity#equals(Object)}
   *   <li>{@link OtaPackageInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
    int expectedHashCodeResult = otaPackageInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, otaPackageInfoEntity2.hashCode());
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}, and {@link OtaPackageInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackageInfoEntity#equals(Object)}
   *   <li>{@link OtaPackageInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    // Act and Assert
    assertEquals(otaPackageInfoEntity, otaPackageInfoEntity);
    int expectedHashCodeResult = otaPackageInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, otaPackageInfoEntity.hashCode());
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(null);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Dr");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum(null);
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(null);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.SHA256);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("Not all who wander are lost");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType(null);
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(3L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(1L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(null);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(null);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("Dr");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName(null);
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(false);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Dr");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag(null);
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(null);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Mr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle(null);
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(null);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.SOFTWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("Dr");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl(null);
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("Dr");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion(null);

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, null);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, "Different type to OtaPackageInfoEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackageInfoEntity#OtaPackageInfoEntity()}
   *   <li>{@link OtaPackageInfoEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link OtaPackageInfoEntity#setChecksum(String)}
   *   <li>{@link OtaPackageInfoEntity#setChecksumAlgorithm(ChecksumAlgorithm)}
   *   <li>{@link OtaPackageInfoEntity#setContentType(String)}
   *   <li>{@link OtaPackageInfoEntity#setDataSize(Long)}
   *   <li>{@link OtaPackageInfoEntity#setDeviceProfileId(UUID)}
   *   <li>{@link OtaPackageInfoEntity#setFileName(String)}
   *   <li>{@link OtaPackageInfoEntity#setHasData(boolean)}
   *   <li>{@link OtaPackageInfoEntity#setTag(String)}
   *   <li>{@link OtaPackageInfoEntity#setTenantId(UUID)}
   *   <li>{@link OtaPackageInfoEntity#setTitle(String)}
   *   <li>{@link OtaPackageInfoEntity#setType(OtaPackageType)}
   *   <li>{@link OtaPackageInfoEntity#setUrl(String)}
   *   <li>{@link OtaPackageInfoEntity#setVersion(String)}
   *   <li>{@link OtaPackageInfoEntity#toString()}
   *   <li>{@link OtaPackageInfoEntity#getAdditionalInfo()}
   *   <li>{@link OtaPackageInfoEntity#getChecksum()}
   *   <li>{@link OtaPackageInfoEntity#getChecksumAlgorithm()}
   *   <li>{@link OtaPackageInfoEntity#getContentType()}
   *   <li>{@link OtaPackageInfoEntity#getDataSize()}
   *   <li>{@link OtaPackageInfoEntity#getDeviceProfileId()}
   *   <li>{@link OtaPackageInfoEntity#getFileName()}
   *   <li>{@link OtaPackageInfoEntity#getTag()}
   *   <li>{@link OtaPackageInfoEntity#getTenantId()}
   *   <li>{@link OtaPackageInfoEntity#getTitle()}
   *   <li>{@link OtaPackageInfoEntity#getType()}
   *   <li>{@link OtaPackageInfoEntity#getUrl()}
   *   <li>{@link OtaPackageInfoEntity#getVersion()}
   *   <li>{@link OtaPackageInfoEntity#isHasData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void OtaPackageInfoEntity.<init>()",
    "JsonNode OtaPackageInfoEntity.getAdditionalInfo()",
    "String OtaPackageInfoEntity.getChecksum()",
    "ChecksumAlgorithm OtaPackageInfoEntity.getChecksumAlgorithm()",
    "String OtaPackageInfoEntity.getContentType()",
    "Long OtaPackageInfoEntity.getDataSize()",
    "UUID OtaPackageInfoEntity.getDeviceProfileId()",
    "String OtaPackageInfoEntity.getFileName()",
    "String OtaPackageInfoEntity.getTag()",
    "UUID OtaPackageInfoEntity.getTenantId()",
    "String OtaPackageInfoEntity.getTitle()",
    "OtaPackageType OtaPackageInfoEntity.getType()",
    "String OtaPackageInfoEntity.getUrl()",
    "String OtaPackageInfoEntity.getVersion()",
    "boolean OtaPackageInfoEntity.isHasData()",
    "void OtaPackageInfoEntity.setAdditionalInfo(JsonNode)",
    "void OtaPackageInfoEntity.setChecksum(String)",
    "void OtaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm)",
    "void OtaPackageInfoEntity.setContentType(String)",
    "void OtaPackageInfoEntity.setDataSize(Long)",
    "void OtaPackageInfoEntity.setDeviceProfileId(UUID)",
    "void OtaPackageInfoEntity.setFileName(String)",
    "void OtaPackageInfoEntity.setHasData(boolean)",
    "void OtaPackageInfoEntity.setTag(String)",
    "void OtaPackageInfoEntity.setTenantId(UUID)",
    "void OtaPackageInfoEntity.setTitle(String)",
    "void OtaPackageInfoEntity.setType(OtaPackageType)",
    "void OtaPackageInfoEntity.setUrl(String)",
    "void OtaPackageInfoEntity.setVersion(String)",
    "String OtaPackageInfoEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity = new OtaPackageInfoEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualOtaPackageInfoEntity.setAdditionalInfo(additionalInfo);
    actualOtaPackageInfoEntity.setChecksum("Checksum");
    actualOtaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    actualOtaPackageInfoEntity.setContentType("text/plain");
    actualOtaPackageInfoEntity.setDataSize(3L);
    UUID deviceProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualOtaPackageInfoEntity.setDeviceProfileId(deviceProfileId);
    actualOtaPackageInfoEntity.setFileName("foo.txt");
    actualOtaPackageInfoEntity.setHasData(true);
    actualOtaPackageInfoEntity.setTag("Tag");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualOtaPackageInfoEntity.setTenantId(tenantId);
    actualOtaPackageInfoEntity.setTitle("Dr");
    actualOtaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    actualOtaPackageInfoEntity.setUrl("https://example.org/example");
    actualOtaPackageInfoEntity.setVersion("1.0.2");
    String actualToStringResult = actualOtaPackageInfoEntity.toString();
    JsonNode actualAdditionalInfo = actualOtaPackageInfoEntity.getAdditionalInfo();
    String actualChecksum = actualOtaPackageInfoEntity.getChecksum();
    ChecksumAlgorithm actualChecksumAlgorithm = actualOtaPackageInfoEntity.getChecksumAlgorithm();
    String actualContentType = actualOtaPackageInfoEntity.getContentType();
    Long actualDataSize = actualOtaPackageInfoEntity.getDataSize();
    UUID actualDeviceProfileId = actualOtaPackageInfoEntity.getDeviceProfileId();
    String actualFileName = actualOtaPackageInfoEntity.getFileName();
    String actualTag = actualOtaPackageInfoEntity.getTag();
    UUID actualTenantId = actualOtaPackageInfoEntity.getTenantId();
    String actualTitle = actualOtaPackageInfoEntity.getTitle();
    OtaPackageType actualType = actualOtaPackageInfoEntity.getType();
    String actualUrl = actualOtaPackageInfoEntity.getUrl();
    String actualVersion = actualOtaPackageInfoEntity.getVersion();
    boolean actualIsHasDataResult = actualOtaPackageInfoEntity.isHasData();

    // Assert
    assertEquals("1.0.2", actualVersion);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDeviceProfileId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Checksum", actualChecksum);
    assertEquals("Dr", actualTitle);
    assertEquals(
        "OtaPackageInfoEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, deviceProfileId=784f394c-42b6-435a"
            + "-983c-b7beff2784f9, type=FIRMWARE, title=Dr, version=1.0.2, tag=Tag, url=https://example.org/example,"
            + " fileName=foo.txt, contentType=text/plain, checksumAlgorithm=MD5, checksum=Checksum, dataSize=3,"
            + " additionalInfo={\"isPublic\":true}, hasData=true)",
        actualToStringResult);
    assertEquals("Tag", actualTag);
    assertEquals("foo.txt", actualFileName);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals("text/plain", actualContentType);
    assertNull(actualOtaPackageInfoEntity.getId());
    assertNull(actualOtaPackageInfoEntity.getUuid());
    assertEquals(0L, actualOtaPackageInfoEntity.getCreatedTime());
    assertEquals(3L, actualDataSize.longValue());
    assertEquals(ChecksumAlgorithm.MD5, actualChecksumAlgorithm);
    assertEquals(OtaPackageType.FIRMWARE, actualType);
    assertTrue(actualIsHasDataResult);
    assertSame(deviceProfileId, actualDeviceProfileId);
    assertSame(tenantId, actualTenantId);
    assertSame(additionalInfo, actualAdditionalInfo);
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType,
   * String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object,
   * boolean)}.
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID,
   * OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String,
   * Long, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test new OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void OtaPackageInfoEntity.<init>(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)"
  })
  void testNewOtaPackageInfoEntity() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID deviceProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    JsonNode additionalInfo =
        new OtaPackageInfoEntity(
                id,
                1L,
                tenantId,
                deviceProfileId,
                OtaPackageType.FIRMWARE,
                "Dr",
                "1.0.2",
                "Tag",
                "https://example.org/example",
                "foo.txt",
                "text/plain",
                ChecksumAlgorithm.MD5,
                "Checksum",
                3L,
                new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)),
                true)
            .getAdditionalInfo();
    assertTrue(additionalInfo instanceof ArrayNode);
    assertEquals("[ ]", additionalInfo.toPrettyString());
    assertEquals(0, additionalInfo.size());
    assertFalse(additionalInfo.elements().hasNext());
    assertTrue(additionalInfo.isEmpty());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}.
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}
   */
  @Test
  @DisplayName("Test new OtaPackageInfoEntity(OtaPackageInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageInfoEntity.<init>(OtaPackageInfo)"})
  void testNewOtaPackageInfoEntity2() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo(new OtaPackageInfo());
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    otaPackageInfo.setDeviceProfileId(new DeviceProfileId(id));
    otaPackageInfo.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity = new OtaPackageInfoEntity(otaPackageInfo);

    // Assert
    assertTrue(actualOtaPackageInfoEntity.getAdditionalInfo() instanceof NullNode);
    assertSame(id, actualOtaPackageInfoEntity.getDeviceProfileId());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType,
   * String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object,
   * boolean)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link IntNode}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID,
   * OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String,
   * Long, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test new OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean); then AdditionalInfo return IntNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void OtaPackageInfoEntity.<init>(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)"
  })
  void testNewOtaPackageInfoEntity_thenAdditionalInfoReturnIntNode() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    JsonNode additionalInfo =
        new OtaPackageInfoEntity(
                id,
                1L,
                tenantId,
                UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                OtaPackageType.FIRMWARE,
                "Dr",
                "1.0.2",
                "Tag",
                "https://example.org/example",
                "foo.txt",
                "text/plain",
                ChecksumAlgorithm.MD5,
                "Checksum",
                3L,
                1,
                true)
            .getAdditionalInfo();
    assertTrue(additionalInfo instanceof IntNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("1", additionalInfo.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, additionalInfo.getNodeType());
    assertFalse(((IntNode) additionalInfo).isNaN());
    assertTrue(additionalInfo.isInt());
    assertTrue(additionalInfo.isIntegralNumber());
    assertTrue(additionalInfo.isNumber());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}.
   *
   * <ul>
   *   <li>Then return AdditionalInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}
   */
  @Test
  @DisplayName(
      "Test new OtaPackageInfoEntity(OtaPackageInfo); then return AdditionalInfo is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageInfoEntity.<init>(OtaPackageInfo)"})
  void testNewOtaPackageInfoEntity_thenReturnAdditionalInfoIsNull() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity = new OtaPackageInfoEntity(otaPackageInfo);

    // Assert
    assertNull(actualOtaPackageInfoEntity.getAdditionalInfo());
    assertNull(actualOtaPackageInfoEntity.getDataSize());
    assertNull(actualOtaPackageInfoEntity.getChecksum());
    assertNull(actualOtaPackageInfoEntity.getContentType());
    assertNull(actualOtaPackageInfoEntity.getFileName());
    assertNull(actualOtaPackageInfoEntity.getTag());
    assertNull(actualOtaPackageInfoEntity.getTitle());
    assertNull(actualOtaPackageInfoEntity.getUrl());
    assertNull(actualOtaPackageInfoEntity.getVersion());
    assertNull(actualOtaPackageInfoEntity.getId());
    assertNull(actualOtaPackageInfoEntity.getUuid());
    assertNull(actualOtaPackageInfoEntity.getChecksumAlgorithm());
    assertNull(actualOtaPackageInfoEntity.getType());
    assertEquals(0L, actualOtaPackageInfoEntity.getCreatedTime());
    assertFalse(actualOtaPackageInfoEntity.isHasData());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}.
   *
   * <ul>
   *   <li>Then return DeviceProfileId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}
   */
  @Test
  @DisplayName(
      "Test new OtaPackageInfoEntity(OtaPackageInfo); then return DeviceProfileId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageInfoEntity.<init>(OtaPackageInfo)"})
  void testNewOtaPackageInfoEntity_thenReturnDeviceProfileIdIsNull() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo(new OtaPackageInfo());
    otaPackageInfo.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity = new OtaPackageInfoEntity(otaPackageInfo);

    // Assert
    assertTrue(actualOtaPackageInfoEntity.getAdditionalInfo() instanceof NullNode);
    assertNull(actualOtaPackageInfoEntity.getDeviceProfileId());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType,
   * String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code Additional Info}.
   *   <li>Then AdditionalInfo return {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID,
   * OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String,
   * Long, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test new OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean); when 'Additional Info'; then AdditionalInfo return TextNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void OtaPackageInfoEntity.<init>(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)"
  })
  void testNewOtaPackageInfoEntity_whenAdditionalInfo_thenAdditionalInfoReturnTextNode() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    JsonNode additionalInfo =
        new OtaPackageInfoEntity(
                id,
                1L,
                tenantId,
                UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                OtaPackageType.FIRMWARE,
                "Dr",
                "1.0.2",
                "Tag",
                "https://example.org/example",
                "foo.txt",
                "text/plain",
                ChecksumAlgorithm.MD5,
                "Checksum",
                3L,
                "Additional Info",
                true)
            .getAdditionalInfo();
    assertTrue(additionalInfo instanceof TextNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("\"Additional Info\"", additionalInfo.toPrettyString());
    assertEquals(JsonNodeType.STRING, additionalInfo.getNodeType());
    assertTrue(additionalInfo.isTextual());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType,
   * String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object,
   * boolean)}.
   *
   * <ul>
   *   <li>When False.
   *   <li>Then return AdditionalInfo is False {@link BooleanNode#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID,
   * OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String,
   * Long, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test new OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean); when False; then return AdditionalInfo is False FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void OtaPackageInfoEntity.<init>(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)"
  })
  void testNewOtaPackageInfoEntity_whenFalse_thenReturnAdditionalInfoIsFalseFalse() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID deviceProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    BooleanNode resultFalse = BooleanNode.getFalse();

    // Act and Assert
    BooleanNode expectedAdditionalInfo = resultFalse.FALSE;
    assertSame(
        expectedAdditionalInfo,
        new OtaPackageInfoEntity(
                id,
                1L,
                tenantId,
                deviceProfileId,
                OtaPackageType.FIRMWARE,
                "Dr",
                "1.0.2",
                "Tag",
                "https://example.org/example",
                "foo.txt",
                "text/plain",
                ChecksumAlgorithm.MD5,
                "Checksum",
                3L,
                resultFalse,
                true)
            .getAdditionalInfo());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType,
   * String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID,
   * OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String,
   * Long, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test new OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean); when 'null'; then return Version is '1.0.2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void OtaPackageInfoEntity.<init>(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)"
  })
  void testNewOtaPackageInfoEntity_whenNull_thenReturnVersionIs102() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID deviceProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity =
        new OtaPackageInfoEntity(
            id,
            1L,
            tenantId,
            deviceProfileId,
            OtaPackageType.FIRMWARE,
            "Dr",
            "1.0.2",
            "Tag",
            "https://example.org/example",
            "foo.txt",
            "text/plain",
            ChecksumAlgorithm.MD5,
            "Checksum",
            3L,
            null,
            true);

    // Assert
    assertEquals("1.0.2", actualOtaPackageInfoEntity.getVersion());
    assertEquals("Checksum", actualOtaPackageInfoEntity.getChecksum());
    assertEquals("Dr", actualOtaPackageInfoEntity.getTitle());
    assertEquals("Tag", actualOtaPackageInfoEntity.getTag());
    assertEquals("foo.txt", actualOtaPackageInfoEntity.getFileName());
    assertEquals("https://example.org/example", actualOtaPackageInfoEntity.getUrl());
    assertEquals("text/plain", actualOtaPackageInfoEntity.getContentType());
    assertNull(actualOtaPackageInfoEntity.getAdditionalInfo());
    assertEquals(1L, actualOtaPackageInfoEntity.getCreatedTime());
    assertEquals(3L, actualOtaPackageInfoEntity.getDataSize().longValue());
    assertEquals(ChecksumAlgorithm.MD5, actualOtaPackageInfoEntity.getChecksumAlgorithm());
    assertEquals(OtaPackageType.FIRMWARE, actualOtaPackageInfoEntity.getType());
    assertTrue(actualOtaPackageInfoEntity.isHasData());
    assertSame(id, actualOtaPackageInfoEntity.getId());
    assertSame(id, actualOtaPackageInfoEntity.getUuid());
    assertSame(deviceProfileId, actualOtaPackageInfoEntity.getDeviceProfileId());
    assertSame(tenantId, actualOtaPackageInfoEntity.getTenantId());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType,
   * String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object,
   * boolean)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return AdditionalInfo is valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID,
   * OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String,
   * Long, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test new OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean); when valueOf one; then return AdditionalInfo is valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void OtaPackageInfoEntity.<init>(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)"
  })
  void testNewOtaPackageInfoEntity_whenValueOfOne_thenReturnAdditionalInfoIsValueOfOne() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID deviceProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    IntNode valueOfResult = IntNode.valueOf(1);

    // Act and Assert
    assertSame(
        valueOfResult,
        new OtaPackageInfoEntity(
                id,
                1L,
                tenantId,
                deviceProfileId,
                OtaPackageType.FIRMWARE,
                "Dr",
                "1.0.2",
                "Tag",
                "https://example.org/example",
                "foo.txt",
                "text/plain",
                ChecksumAlgorithm.MD5,
                "Checksum",
                3L,
                valueOfResult,
                true)
            .getAdditionalInfo());
  }

  /**
   * Test {@link OtaPackageInfoEntity#toData()}.
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OtaPackageInfo OtaPackageInfoEntity.toData()"})
  void testToData() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");
    otaPackageInfoEntity.setDeviceProfileId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    JsonNode additionalInfo = otaPackageInfoEntity.toData().getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    assertTrue(iteratorResult.next() instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertEquals(1, additionalInfo.size());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(iteratorResult.hasNext());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(additionalInfo.isObject());
  }

  /**
   * Test {@link OtaPackageInfoEntity#toData()}.
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OtaPackageInfo OtaPackageInfoEntity.toData()"})
  void testToData2() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    JsonNode additionalInfo =
        new OtaPackageInfoEntity(
                id,
                1L,
                tenantId,
                UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                OtaPackageType.FIRMWARE,
                "Dr",
                "1.0.2",
                "Tag",
                "https://example.org/example",
                "foo.txt",
                "text/plain",
                ChecksumAlgorithm.MD5,
                "Checksum",
                3L,
                "Additional Info",
                true)
            .toData()
            .getAdditionalInfo();
    assertTrue(additionalInfo instanceof TextNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("\"Additional Info\"", additionalInfo.toPrettyString());
    assertEquals(JsonNodeType.STRING, additionalInfo.getNodeType());
    assertTrue(additionalInfo.isTextual());
  }

  /**
   * Test {@link OtaPackageInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link OtaPackageInfoEntity#OtaPackageInfoEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given OtaPackageInfoEntity(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OtaPackageInfo OtaPackageInfoEntity.toData()"})
  void testToData_givenOtaPackageInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    OtaPackageInfo actualToDataResult = new OtaPackageInfoEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getDataSize());
    assertNull(actualToDataResult.getChecksum());
    assertNull(actualToDataResult.getContentType());
    assertNull(actualToDataResult.getFileName());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTag());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getUrl());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getChecksumAlgorithm());
    assertNull(actualToDataResult.getType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.hasUrl());
    assertFalse(actualToDataResult.isHasData());
  }

  /**
   * Test {@link OtaPackageInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return DeviceProfileId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return DeviceProfileId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OtaPackageInfo OtaPackageInfoEntity.toData()"})
  void testToData_thenReturnDeviceProfileIdIsNull() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    otaPackageInfoEntity.setVersion("1.0.2");
    otaPackageInfoEntity.setDeviceProfileId(null);

    // Act
    OtaPackageInfo actualToDataResult = otaPackageInfoEntity.toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    assertTrue(iteratorResult.next() instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(actualToDataResult.getDeviceProfileId());
    assertEquals(1, additionalInfo.size());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(iteratorResult.hasNext());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(additionalInfo.isObject());
  }

  /**
   * Test {@link OtaPackageInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OtaPackageInfo OtaPackageInfoEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.randomUUID();

    // Act
    OtaPackageInfo actualToDataResult =
        new OtaPackageInfoEntity(
                id,
                1L,
                tenantId,
                UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                OtaPackageType.FIRMWARE,
                "Dr",
                "1.0.2",
                "Tag",
                "https://example.org/example",
                "foo.txt",
                "text/plain",
                ChecksumAlgorithm.MD5,
                "Checksum",
                3L,
                "Additional Info",
                true)
            .toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof TextNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("\"Additional Info\"", additionalInfo.toPrettyString());
    assertEquals(JsonNodeType.STRING, additionalInfo.getNodeType());
    assertTrue(additionalInfo.isTextual());
    assertSame(tenantId, actualToDataResult.getTenantId().getId());
  }
}
