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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.OtaPackageServiceTest;

public class OtaPackageEntityDiffblueTest {
  /**
   * Test {@link OtaPackageEntity#equals(Object)}, and {@link OtaPackageEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackageEntity#equals(Object)}
   *   <li>{@link OtaPackageEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertEquals(otaPackageEntity, otaPackageEntity2);
    assertEquals(otaPackageEntity.hashCode(), otaPackageEntity2.hashCode());
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}, and {@link OtaPackageEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackageEntity#equals(Object)}
   *   <li>{@link OtaPackageEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    // Act and Assert
    assertEquals(otaPackageEntity, otaPackageEntity);
    int expectedHashCodeResult = otaPackageEntity.hashCode();
    assertEquals(expectedHashCodeResult, otaPackageEntity.hashCode());
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(null);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Dr");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum(null);
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(null);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.SHA256);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("Not all who wander are lost");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType(null);
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(3L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData(null);
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(1L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(null);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(UUID.randomUUID());
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(null);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("Dr");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName(null);
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Dr");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag(null);
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(UUID.randomUUID());
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(null);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Mr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle(null);
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(null);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.SOFTWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("Dr");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl(null);
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("Dr");

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual28()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion(null);

    OtaPackageEntity otaPackageEntity2 = new OtaPackageEntity();
    otaPackageEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity2.setChecksum("Checksum");
    otaPackageEntity2.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity2.setContentType("text/plain");
    otaPackageEntity2.setCreatedTime(1L);
    otaPackageEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity2.setDataSize(3L);
    otaPackageEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setFileName("foo.txt");
    otaPackageEntity2.setId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTag("Tag");
    otaPackageEntity2.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity2.setTitle("Dr");
    otaPackageEntity2.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity2.setUrl("https://example.org/example");
    otaPackageEntity2.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity2.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, otaPackageEntity2);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, null);
  }

  /**
   * Test {@link OtaPackageEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackageEntity.equals(Object)", "int OtaPackageEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");

    // Act and Assert
    assertNotEquals(otaPackageEntity, "Different type to OtaPackageEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackageEntity#OtaPackageEntity()}
   *   <li>{@link OtaPackageEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link OtaPackageEntity#setChecksum(String)}
   *   <li>{@link OtaPackageEntity#setChecksumAlgorithm(ChecksumAlgorithm)}
   *   <li>{@link OtaPackageEntity#setContentType(String)}
   *   <li>{@link OtaPackageEntity#setData(byte[])}
   *   <li>{@link OtaPackageEntity#setDataSize(Long)}
   *   <li>{@link OtaPackageEntity#setDeviceProfileId(UUID)}
   *   <li>{@link OtaPackageEntity#setFileName(String)}
   *   <li>{@link OtaPackageEntity#setTag(String)}
   *   <li>{@link OtaPackageEntity#setTenantId(UUID)}
   *   <li>{@link OtaPackageEntity#setTitle(String)}
   *   <li>{@link OtaPackageEntity#setType(OtaPackageType)}
   *   <li>{@link OtaPackageEntity#setUrl(String)}
   *   <li>{@link OtaPackageEntity#setVersion(String)}
   *   <li>{@link OtaPackageEntity#toString()}
   *   <li>{@link OtaPackageEntity#getAdditionalInfo()}
   *   <li>{@link OtaPackageEntity#getChecksum()}
   *   <li>{@link OtaPackageEntity#getChecksumAlgorithm()}
   *   <li>{@link OtaPackageEntity#getContentType()}
   *   <li>{@link OtaPackageEntity#getData()}
   *   <li>{@link OtaPackageEntity#getDataSize()}
   *   <li>{@link OtaPackageEntity#getDeviceProfileId()}
   *   <li>{@link OtaPackageEntity#getFileName()}
   *   <li>{@link OtaPackageEntity#getTag()}
   *   <li>{@link OtaPackageEntity#getTenantId()}
   *   <li>{@link OtaPackageEntity#getTitle()}
   *   <li>{@link OtaPackageEntity#getType()}
   *   <li>{@link OtaPackageEntity#getUrl()}
   *   <li>{@link OtaPackageEntity#getVersion()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OtaPackageEntity.<init>()",
    "JsonNode OtaPackageEntity.getAdditionalInfo()",
    "String OtaPackageEntity.getChecksum()",
    "ChecksumAlgorithm OtaPackageEntity.getChecksumAlgorithm()",
    "String OtaPackageEntity.getContentType()",
    "byte[] OtaPackageEntity.getData()",
    "Long OtaPackageEntity.getDataSize()",
    "UUID OtaPackageEntity.getDeviceProfileId()",
    "String OtaPackageEntity.getFileName()",
    "String OtaPackageEntity.getTag()",
    "UUID OtaPackageEntity.getTenantId()",
    "String OtaPackageEntity.getTitle()",
    "OtaPackageType OtaPackageEntity.getType()",
    "String OtaPackageEntity.getUrl()",
    "String OtaPackageEntity.getVersion()",
    "void OtaPackageEntity.setAdditionalInfo(JsonNode)",
    "void OtaPackageEntity.setChecksum(String)",
    "void OtaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm)",
    "void OtaPackageEntity.setContentType(String)",
    "void OtaPackageEntity.setData(byte[])",
    "void OtaPackageEntity.setDataSize(Long)",
    "void OtaPackageEntity.setDeviceProfileId(UUID)",
    "void OtaPackageEntity.setFileName(String)",
    "void OtaPackageEntity.setTag(String)",
    "void OtaPackageEntity.setTenantId(UUID)",
    "void OtaPackageEntity.setTitle(String)",
    "void OtaPackageEntity.setType(OtaPackageType)",
    "void OtaPackageEntity.setUrl(String)",
    "void OtaPackageEntity.setVersion(String)",
    "String OtaPackageEntity.toString()"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    OtaPackageEntity actualOtaPackageEntity = new OtaPackageEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualOtaPackageEntity.setAdditionalInfo(additionalInfo);
    actualOtaPackageEntity.setChecksum("Checksum");
    actualOtaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    actualOtaPackageEntity.setContentType("text/plain");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualOtaPackageEntity.setData(data);
    actualOtaPackageEntity.setDataSize(3L);
    actualOtaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    actualOtaPackageEntity.setFileName("foo.txt");
    actualOtaPackageEntity.setTag("Tag");
    UUID tenantId = ModelConstants.NULL_UUID;
    actualOtaPackageEntity.setTenantId(tenantId);
    actualOtaPackageEntity.setTitle("Dr");
    actualOtaPackageEntity.setType(OtaPackageType.FIRMWARE);
    actualOtaPackageEntity.setUrl("https://example.org/example");
    actualOtaPackageEntity.setVersion("1.0.2");
    String actualToStringResult = actualOtaPackageEntity.toString();
    JsonNode actualAdditionalInfo = actualOtaPackageEntity.getAdditionalInfo();
    String actualChecksum = actualOtaPackageEntity.getChecksum();
    ChecksumAlgorithm actualChecksumAlgorithm = actualOtaPackageEntity.getChecksumAlgorithm();
    String actualContentType = actualOtaPackageEntity.getContentType();
    byte[] actualData = actualOtaPackageEntity.getData();
    Long actualDataSize = actualOtaPackageEntity.getDataSize();
    UUID actualDeviceProfileId = actualOtaPackageEntity.getDeviceProfileId();
    String actualFileName = actualOtaPackageEntity.getFileName();
    String actualTag = actualOtaPackageEntity.getTag();
    UUID actualTenantId = actualOtaPackageEntity.getTenantId();
    String actualTitle = actualOtaPackageEntity.getTitle();
    OtaPackageType actualType = actualOtaPackageEntity.getType();
    String actualUrl = actualOtaPackageEntity.getUrl();

    // Assert
    assertEquals("1.0.2", actualOtaPackageEntity.getVersion());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDeviceProfileId.toString());
    assertEquals("Checksum", actualChecksum);
    assertEquals("Dr", actualTitle);
    assertEquals(
        "OtaPackageEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, deviceProfileId=13814000-1dd2-11b2"
            + "-8080-808080808080, type=FIRMWARE, title=Dr, version=1.0.2, tag=Tag, url=https://example.org/example,"
            + " fileName=foo.txt, contentType=text/plain, checksumAlgorithm=MD5, checksum=Checksum, data=[65, 88, 65,"
            + " 88, 65, 88, 65, 88], dataSize=3, additionalInfo={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("Tag", actualTag);
    assertEquals("foo.txt", actualFileName);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals("text/plain", actualContentType);
    assertNull(actualOtaPackageEntity.getId());
    assertNull(actualOtaPackageEntity.getUuid());
    assertEquals(0L, actualOtaPackageEntity.getCreatedTime());
    assertEquals(3L, actualDataSize.longValue());
    assertEquals(ChecksumAlgorithm.MD5, actualChecksumAlgorithm);
    assertEquals(OtaPackageType.FIRMWARE, actualType);
    assertSame(data, actualData);
    assertSame(additionalInfo, actualAdditionalInfo);
    assertSame(tenantId, actualDeviceProfileId);
    assertSame(tenantId, actualTenantId);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Test {@link OtaPackageEntity#OtaPackageEntity(OtaPackage)}.
   *
   * <ul>
   *   <li>Then return DeviceProfileId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#OtaPackageEntity(OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageEntity.<init>(OtaPackage)"})
  public void testNewOtaPackageEntity_thenReturnDeviceProfileIdIsNull() {
    // Arrange
    OtaPackage otaPackage =
        OtaPackageServiceTest.createFirmware(ModelConstants.SYSTEM_TENANT, "1.0.2", null);

    // Act
    OtaPackageEntity actualOtaPackageEntity = new OtaPackageEntity(otaPackage);

    // Assert
    assertEquals("1.0.2", actualOtaPackageEntity.getVersion());
    assertEquals(
        "4bf5122f344554c53bde2ebb8cd2b7e3d1600ad631c385a5d7cce23c7785459a",
        actualOtaPackageEntity.getChecksum());
    assertEquals("My firmware", actualOtaPackageEntity.getTitle());
    assertEquals("filename.txt", actualOtaPackageEntity.getFileName());
    assertEquals("text/plain", actualOtaPackageEntity.getContentType());
    assertNull(actualOtaPackageEntity.getAdditionalInfo());
    assertNull(actualOtaPackageEntity.getTag());
    assertNull(actualOtaPackageEntity.getUrl());
    assertNull(actualOtaPackageEntity.getId());
    assertNull(actualOtaPackageEntity.getUuid());
    assertNull(actualOtaPackageEntity.getDeviceProfileId());
    assertEquals(0L, actualOtaPackageEntity.getCreatedTime());
    assertEquals(1L, actualOtaPackageEntity.getDataSize().longValue());
    assertEquals(ChecksumAlgorithm.SHA256, actualOtaPackageEntity.getChecksumAlgorithm());
    assertEquals(OtaPackageType.FIRMWARE, actualOtaPackageEntity.getType());
    assertArrayEquals(new byte[] {1}, actualOtaPackageEntity.getData());
  }

  /**
   * Test {@link OtaPackageEntity#OtaPackageEntity(OtaPackage)}.
   *
   * <ul>
   *   <li>When {@link DeviceProfileId#DeviceProfileId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#OtaPackageEntity(OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageEntity.<init>(OtaPackage)"})
  public void testNewOtaPackageEntity_whenDeviceProfileIdWithIdIsNull_uuid() {
    // Arrange
    OtaPackage otaPackage =
        OtaPackageServiceTest.createFirmware(
            ModelConstants.SYSTEM_TENANT, "1.0.2", new DeviceProfileId(ModelConstants.NULL_UUID));

    // Act
    OtaPackageEntity actualOtaPackageEntity = new OtaPackageEntity(otaPackage);

    // Assert
    assertEquals("1.0.2", actualOtaPackageEntity.getVersion());
    assertEquals(
        "4bf5122f344554c53bde2ebb8cd2b7e3d1600ad631c385a5d7cce23c7785459a",
        actualOtaPackageEntity.getChecksum());
    assertEquals("My firmware", actualOtaPackageEntity.getTitle());
    assertEquals("filename.txt", actualOtaPackageEntity.getFileName());
    assertEquals("text/plain", actualOtaPackageEntity.getContentType());
    assertNull(actualOtaPackageEntity.getAdditionalInfo());
    assertNull(actualOtaPackageEntity.getTag());
    assertNull(actualOtaPackageEntity.getUrl());
    assertNull(actualOtaPackageEntity.getId());
    assertNull(actualOtaPackageEntity.getUuid());
    assertEquals(0L, actualOtaPackageEntity.getCreatedTime());
    assertEquals(1L, actualOtaPackageEntity.getDataSize().longValue());
    assertEquals(ChecksumAlgorithm.SHA256, actualOtaPackageEntity.getChecksumAlgorithm());
    assertEquals(OtaPackageType.FIRMWARE, actualOtaPackageEntity.getType());
    assertArrayEquals(new byte[] {1}, actualOtaPackageEntity.getData());
  }

  /**
   * Test {@link OtaPackageEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link OtaPackageEntity#OtaPackageEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackage OtaPackageEntity.toData()"})
  public void testToData_givenOtaPackageEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    OtaPackage actualToDataResult = new OtaPackageEntity().toData();

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
    assertNull(actualToDataResult.getData());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getDeviceProfileId());
    assertNull(actualToDataResult.getChecksumAlgorithm());
    assertNull(actualToDataResult.getType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.hasUrl());
    assertFalse(actualToDataResult.isHasData());
  }

  /**
   * Test {@link OtaPackageEntity#toData()}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackage OtaPackageEntity.toData()"})
  public void testToData_thenAdditionalInfoReturnObjectNode() throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(UUID.randomUUID());
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));

    // Act
    OtaPackage actualToDataResult = otaPackageEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("1.0.2", actualToDataResult.getVersion());
    assertEquals("Checksum", actualToDataResult.getChecksum());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("Tag", actualToDataResult.getTag());
    assertEquals("foo.txt", actualToDataResult.getFileName());
    assertEquals("https://example.org/example", actualToDataResult.getUrl());
    assertEquals("text/plain", actualToDataResult.getContentType());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(3L, actualToDataResult.getDataSize().longValue());
    assertEquals(ChecksumAlgorithm.MD5, actualToDataResult.getChecksumAlgorithm());
    assertEquals(OtaPackageType.FIRMWARE, actualToDataResult.getType());
    assertTrue(actualToDataResult.hasUrl());
    assertTrue(actualToDataResult.isHasData());
  }

  /**
   * Test {@link OtaPackageEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackage OtaPackageEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackageEntity otaPackageEntity = new OtaPackageEntity();
    otaPackageEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageEntity.setChecksum("Checksum");
    otaPackageEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageEntity.setContentType("text/plain");
    otaPackageEntity.setCreatedTime(1L);
    otaPackageEntity.setDataSize(3L);
    otaPackageEntity.setFileName("foo.txt");
    otaPackageEntity.setId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTag("Tag");
    otaPackageEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageEntity.setTitle("Dr");
    otaPackageEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageEntity.setUrl("https://example.org/example");
    otaPackageEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageEntity.setVersion("1.0.2");
    otaPackageEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageEntity.setData("AXAXAXAX".getBytes("UTF-8"));

    // Act
    OtaPackage actualToDataResult = otaPackageEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    byte[] expectedArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedArrayResult, actualToDataResult.getData().array());
  }
}
