package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.OtaPackageInfo;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class OtaPackageInfoEntityDiffblueTest {
  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}, and
   * {@link OtaPackageInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageInfoEntity#equals(Object)}
   *   <li>{@link OtaPackageInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
    int expectedHashCodeResult = otaPackageInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, otaPackageInfoEntity2.hashCode());
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}, and
   * {@link OtaPackageInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageInfoEntity#equals(Object)}
   *   <li>{@link OtaPackageInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    // Act and Assert
    assertEquals(otaPackageInfoEntity, otaPackageInfoEntity);
    int expectedHashCodeResult = otaPackageInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, otaPackageInfoEntity.hashCode());
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(MissingNode.getInstance());
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(null);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(mock(JsonNode.class));
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Dr");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum(null);
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(null);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.SHA256);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("Not all who wander are lost");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType(null);
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(3L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(1L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(null);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(UUID.randomUUID());
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(null);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("Dr");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName(null);
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(false);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Dr");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag(null);
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.randomUUID());
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(null);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Mr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle(null);
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(null);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.SOFTWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("Dr");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl(null);
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("Dr");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion(null);

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity2.setChecksum("Checksum");
    otaPackageInfoEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity2.setContentType("text/plain");
    otaPackageInfoEntity2.setCreatedTime(1L);
    otaPackageInfoEntity2.setDataSize(3L);
    otaPackageInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setFileName("foo.txt");
    otaPackageInfoEntity2.setHasData(true);
    otaPackageInfoEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTag("Tag");
    otaPackageInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setTitle("Dr");
    otaPackageInfoEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity2.setUrl("https://example.org/example");
    otaPackageInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, otaPackageInfoEntity2);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, null);
  }

  /**
   * Test {@link OtaPackageInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageInfoEntity, "Different type to OtaPackageInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity = new OtaPackageInfoEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualOtaPackageInfoEntity.setAdditionalInfo(additionalInfo);
    actualOtaPackageInfoEntity.setChecksum("Checksum");
    actualOtaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    actualOtaPackageInfoEntity.setContentType("text/plain");
    actualOtaPackageInfoEntity.setDataSize(3L);
    actualOtaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    actualOtaPackageInfoEntity.setFileName("foo.txt");
    actualOtaPackageInfoEntity.setHasData(true);
    actualOtaPackageInfoEntity.setTag("Tag");
    UUID tenantId = ModelConstants.NULL_UUID;
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

    // Assert that nothing has changed
    assertEquals("1.0.2", actualVersion);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDeviceProfileId.toString());
    assertEquals("Checksum", actualChecksum);
    assertEquals("Dr", actualTitle);
    assertEquals(
        "OtaPackageInfoEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, deviceProfileId=13814000-1dd2-11b2"
            + "-8080-808080808080, type=FIRMWARE, title=Dr, version=1.0.2, tag=Tag, url=https://example.org/example,"
            + " fileName=foo.txt, contentType=text/plain, checksumAlgorithm=MD5, checksum=Checksum, dataSize=3,"
            + " additionalInfo={\"isPublic\":true}, hasData=true)",
        actualToStringResult);
    assertEquals("Tag", actualTag);
    assertEquals("foo.txt", actualFileName);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals("text/plain", actualContentType);
    assertEquals(0L, actualOtaPackageInfoEntity.getCreatedTime());
    assertEquals(3L, actualDataSize.longValue());
    assertEquals(ChecksumAlgorithm.MD5, actualChecksumAlgorithm);
    assertEquals(OtaPackageType.FIRMWARE, actualType);
    assertTrue(actualIsHasDataResult);
    assertSame(additionalInfo, actualAdditionalInfo);
    assertSame(tenantId, actualDeviceProfileId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)}.
   * <p>
   * Method under test:
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)}
   */
  @Test
  public void testNewOtaPackageInfoEntity() {
    // Arrange, Act and Assert
    JsonNode additionalInfo = (new OtaPackageInfoEntity(ModelConstants.NULL_UUID, 1L, ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, OtaPackageType.FIRMWARE, "Dr", "1.0.2", "Tag", "https://example.org/example",
        "foo.txt", "text/plain", ChecksumAlgorithm.MD5, "Checksum", 3L,
        new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)), true)).getAdditionalInfo();
    assertTrue(additionalInfo instanceof ArrayNode);
    assertEquals("[ ]", additionalInfo.toPrettyString());
    assertEquals(0, additionalInfo.size());
    assertFalse(additionalInfo.elements().hasNext());
    assertTrue(additionalInfo.isEmpty());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}.
   * <p>
   * Method under test:
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}
   */
  @Test
  public void testNewOtaPackageInfoEntity2() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity = new OtaPackageInfoEntity(otaPackageInfo);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualOtaPackageInfoEntity.getTenantId().toString());
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
    assertNull(actualOtaPackageInfoEntity.getDeviceProfileId());
    assertNull(actualOtaPackageInfoEntity.getChecksumAlgorithm());
    assertNull(actualOtaPackageInfoEntity.getType());
    assertEquals(0L, actualOtaPackageInfoEntity.getCreatedTime());
    assertFalse(actualOtaPackageInfoEntity.isHasData());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}.
   * <p>
   * Method under test:
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}
   */
  @Test
  public void testNewOtaPackageInfoEntity3() throws IOException {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setDeviceProfileId(new DeviceProfileId(ModelConstants.NULL_UUID));

    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo(otaPackageInfo);
    otaPackageInfo2.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity = new OtaPackageInfoEntity(otaPackageInfo2);

    // Assert
    JsonNode additionalInfo = actualOtaPackageInfoEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualOtaPackageInfoEntity.getDeviceProfileId().toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)}.
   * <ul>
   *   <li>Then AdditionalInfo elements next return {@link ArrayNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)}
   */
  @Test
  public void testNewOtaPackageInfoEntity_thenAdditionalInfoElementsNextReturnArrayNode() {
    // Arrange
    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    arrayNode.addArray();
    arrayNode.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    JsonNode additionalInfo = (new OtaPackageInfoEntity(ModelConstants.NULL_UUID, 1L, ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, OtaPackageType.FIRMWARE, "Dr", "1.0.2", "Tag", "https://example.org/example",
        "foo.txt", "text/plain", ChecksumAlgorithm.MD5, "Checksum", 3L, arrayNode, true)).getAdditionalInfo();
    Iterator<JsonNode> elementsResult = additionalInfo.elements();
    JsonNode nextResult = elementsResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    assertTrue(additionalInfo instanceof ArrayNode);
    JsonNode nextResult2 = elementsResult.next();
    Iterator<JsonNode> iteratorResult = nextResult2.iterator();
    JsonNode nextResult3 = iteratorResult.next();
    assertTrue(nextResult3 instanceof BooleanNode);
    assertTrue(nextResult2 instanceof ObjectNode);
    assertEquals("[ [ ], {\r\n  \"isPublic\" : true\r\n} ]", additionalInfo.toPrettyString());
    assertEquals("[ ]", nextResult.toPrettyString());
    assertEquals(0, nextResult.size());
    assertEquals(JsonNodeType.ARRAY, nextResult.getNodeType());
    assertFalse(nextResult.elements().hasNext());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult3.iterator().hasNext());
    assertTrue(nextResult.isArray());
    assertTrue(nextResult.isEmpty());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}.
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}
   */
  @Test
  public void testNewOtaPackageInfoEntity_thenAdditionalInfoReturnNullNode() throws IOException {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo(new OtaPackageInfo());
    otaPackageInfo.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity = new OtaPackageInfoEntity(otaPackageInfo);

    // Assert
    JsonNode additionalInfo = actualOtaPackageInfoEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualOtaPackageInfoEntity.getDeviceProfileId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)}.
   * <ul>
   *   <li>When {@code Additional Info}.</li>
   *   <li>Then AdditionalInfo return {@link TextNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)}
   */
  @Test
  public void testNewOtaPackageInfoEntity_whenAdditionalInfo_thenAdditionalInfoReturnTextNode() {
    // Arrange, Act and Assert
    JsonNode additionalInfo = (new OtaPackageInfoEntity(ModelConstants.NULL_UUID, 1L, ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, OtaPackageType.FIRMWARE, "Dr", "1.0.2", "Tag", "https://example.org/example",
        "foo.txt", "text/plain", ChecksumAlgorithm.MD5, "Checksum", 3L, "Additional Info", true)).getAdditionalInfo();
    assertTrue(additionalInfo instanceof TextNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("\"Additional Info\"", additionalInfo.toPrettyString());
    assertEquals(JsonNodeType.STRING, additionalInfo.getNodeType());
    assertTrue(additionalInfo.isTextual());
  }

  /**
   * Test
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)}.
   * <ul>
   *   <li>When False.</li>
   *   <li>Then return AdditionalInfo is False {@link BooleanNode#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)}
   */
  @Test
  public void testNewOtaPackageInfoEntity_whenFalse_thenReturnAdditionalInfoIsFalseFalse() {
    // Arrange
    BooleanNode resultFalse = BooleanNode.getFalse();

    // Act and Assert
    BooleanNode expectedAdditionalInfo = resultFalse.FALSE;
    assertSame(expectedAdditionalInfo,
        (new OtaPackageInfoEntity(ModelConstants.NULL_UUID, 1L, ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            OtaPackageType.FIRMWARE, "Dr", "1.0.2", "Tag", "https://example.org/example", "foo.txt", "text/plain",
            ChecksumAlgorithm.MD5, "Checksum", 3L, resultFalse, true)).getAdditionalInfo());
  }

  /**
   * Test
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return AdditionalInfo is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)}
   */
  @Test
  public void testNewOtaPackageInfoEntity_whenNull_thenReturnAdditionalInfoIsNull() {
    // Arrange, Act and Assert
    assertNull((new OtaPackageInfoEntity(ModelConstants.NULL_UUID, 1L, ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, OtaPackageType.FIRMWARE, "Dr", "1.0.2", "Tag", "https://example.org/example",
        "foo.txt", "text/plain", ChecksumAlgorithm.MD5, "Checksum", 3L, null, true)).getAdditionalInfo());
  }

  /**
   * Test
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)}.
   * <ul>
   *   <li>When {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then AdditionalInfo return {@link IntNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)}
   */
  @Test
  public void testNewOtaPackageInfoEntity_whenNull_uuid_thenAdditionalInfoReturnIntNode() {
    // Arrange, Act and Assert
    JsonNode additionalInfo = (new OtaPackageInfoEntity(ModelConstants.NULL_UUID, 1L, ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, OtaPackageType.FIRMWARE, "Dr", "1.0.2", "Tag", "https://example.org/example",
        "foo.txt", "text/plain", ChecksumAlgorithm.MD5, "Checksum", 3L, 1, true)).getAdditionalInfo();
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
   * Test {@link OtaPackageInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link OtaPackageInfoEntity#OtaPackageInfoEntity()} DeviceProfileId
   * is {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  public void testToData_givenOtaPackageInfoEntityDeviceProfileIdIsNull_uuid() throws IOException {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);

    // Act and Assert
    JsonNode additionalInfo = otaPackageInfoEntity.toData().getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
  }

  /**
   * Test {@link OtaPackageInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link OtaPackageInfoEntity#OtaPackageInfoEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  public void testToData_givenOtaPackageInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    OtaPackageInfo actualToDataResult = (new OtaPackageInfoEntity()).toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
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
    OtaPackageId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getTenantId().getId());
    assertNull(actualToDataResult.getChecksumAlgorithm());
    assertNull(actualToDataResult.getType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(actualToDataResult.hasUrl());
    assertFalse(actualToDataResult.isHasData());
    assertFalse(id.isNullUid());
    assertTrue(additionalInfo.isNull());
  }

  /**
   * Test {@link OtaPackageInfoEntity#toData()}.
   * <ul>
   *   <li>Then return AdditionalInfo toPrettyString is
   * {@code "Additional Info"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnAdditionalInfoToPrettyStringIsAdditionalInfo() {
    // Arrange, Act and Assert
    JsonNode additionalInfo = (new OtaPackageInfoEntity(ModelConstants.NULL_UUID, 1L, ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, OtaPackageType.FIRMWARE, "Dr", "1.0.2", "Tag", "https://example.org/example",
        "foo.txt", "text/plain", ChecksumAlgorithm.MD5, "Checksum", 3L, "Additional Info", true)).toData()
        .getAdditionalInfo();
    assertTrue(additionalInfo instanceof TextNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("\"Additional Info\"", additionalInfo.toPrettyString());
    assertEquals(JsonNodeType.STRING, additionalInfo.getNodeType());
    assertTrue(additionalInfo.isTextual());
  }

  /**
   * Test {@link OtaPackageInfoEntity#toData()}.
   * <ul>
   *   <li>Then return DeviceProfileId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnDeviceProfileIdIsNull() throws IOException {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");
    otaPackageInfoEntity.setDeviceProfileId(null);

    // Act
    OtaPackageInfo actualToDataResult = otaPackageInfoEntity.toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualToDataResult.getDeviceProfileId());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
  }

  /**
   * Test {@link OtaPackageInfoEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    UUID tenantId = UUID.randomUUID();

    // Act
    OtaPackageInfo actualToDataResult = (new OtaPackageInfoEntity(ModelConstants.NULL_UUID, 1L, tenantId,
        ModelConstants.NULL_UUID, OtaPackageType.FIRMWARE, "Dr", "1.0.2", "Tag", "https://example.org/example",
        "foo.txt", "text/plain", ChecksumAlgorithm.MD5, "Checksum", 3L, "Additional Info", true)).toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof TextNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertSame(tenantId, actualToDataResult.getTenantId().getId());
  }
}
