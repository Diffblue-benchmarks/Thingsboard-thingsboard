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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.OtaPackageInfo;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class OtaPackageInfoEntityDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    assertEquals(otaPackageInfoEntity.hashCode(), otaPackageInfoEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
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
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Dr");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag(null);
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.randomUUID());
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(null);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Mr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle(null);
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(null);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.SOFTWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("Dr");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl(null);
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("Dr");

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion(null);

    OtaPackageInfoEntity otaPackageInfoEntity2 = new OtaPackageInfoEntity();
    otaPackageInfoEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageInfoEntity.equals(Object)",
    "int OtaPackageInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

    // Assert
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
    assertNull(actualOtaPackageInfoEntity.getId());
    assertNull(actualOtaPackageInfoEntity.getUuid());
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
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType,
   * String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object,
   * boolean)}.
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID,
   * OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String,
   * Long, Object, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OtaPackageInfoEntity.<init>(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)"
  })
  public void testNewOtaPackageInfoEntity() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode arrayNode = new ArrayNode(nf);

    // Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity =
        new OtaPackageInfoEntity(
            ModelConstants.NULL_UUID,
            1L,
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
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
            arrayNode,
            true);

    // Assert
    JsonNode additionalInfo = actualOtaPackageInfoEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ArrayNode);
    assertEquals("[ ]", additionalInfo.toPrettyString());
    assertEquals(0, additionalInfo.size());
    assertFalse(additionalInfo.elements().hasNext());
    assertTrue(additionalInfo.isEmpty());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileId#DeviceProfileId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(OtaPackageInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageInfoEntity.<init>(OtaPackageInfo)"})
  public void testNewOtaPackageInfoEntity_givenDeviceProfileIdWithIdIsNull_uuid() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo(new OtaPackageInfo());
    otaPackageInfo.setDeviceProfileId(new DeviceProfileId(ModelConstants.NULL_UUID));
    otaPackageInfo.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertTrue(new OtaPackageInfoEntity(otaPackageInfo).getAdditionalInfo() instanceof NullNode);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageInfoEntity.<init>(OtaPackageInfo)"})
  public void testNewOtaPackageInfoEntity_thenReturnAdditionalInfoIsNull() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageInfoEntity.<init>(OtaPackageInfo)"})
  public void testNewOtaPackageInfoEntity_thenReturnDeviceProfileIdIsNull() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OtaPackageInfoEntity.<init>(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)"
  })
  public void testNewOtaPackageInfoEntity_whenAdditionalInfo_thenAdditionalInfoReturnTextNode() {
    // Arrange and Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity =
        new OtaPackageInfoEntity(
            ModelConstants.NULL_UUID,
            1L,
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
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
            true);

    // Assert
    JsonNode additionalInfo = actualOtaPackageInfoEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof TextNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType,
   * String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object,
   * boolean)}.
   *
   * <ul>
   *   <li>When False.
   *   <li>Then return AdditionalInfo is {@link BooleanNode#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID,
   * OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String,
   * Long, Object, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OtaPackageInfoEntity.<init>(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)"
  })
  public void testNewOtaPackageInfoEntity_whenFalse_thenReturnAdditionalInfoIsFalse() {
    // Arrange and Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity =
        new OtaPackageInfoEntity(
            ModelConstants.NULL_UUID,
            1L,
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
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
            BooleanNode.getFalse(),
            true);

    // Assert
    assertSame(BooleanNode.FALSE, actualOtaPackageInfoEntity.getAdditionalInfo());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType,
   * String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return AdditionalInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID,
   * OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String,
   * Long, Object, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OtaPackageInfoEntity.<init>(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)"
  })
  public void testNewOtaPackageInfoEntity_whenNull_thenReturnAdditionalInfoIsNull() {
    // Arrange and Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity =
        new OtaPackageInfoEntity(
            ModelConstants.NULL_UUID,
            1L,
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
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
    assertNull(actualOtaPackageInfoEntity.getAdditionalInfo());
  }

  /**
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType,
   * String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#NULL_UUID}.
   *   <li>Then AdditionalInfo return {@link IntNode}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID,
   * OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String,
   * Long, Object, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OtaPackageInfoEntity.<init>(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)"
  })
  public void testNewOtaPackageInfoEntity_whenNull_uuid_thenAdditionalInfoReturnIntNode() {
    // Arrange and Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity =
        new OtaPackageInfoEntity(
            ModelConstants.NULL_UUID,
            1L,
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
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
            true);

    // Assert
    JsonNode additionalInfo = actualOtaPackageInfoEntity.getAdditionalInfo();
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
   * Test {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID, OtaPackageType,
   * String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object,
   * boolean)}.
   *
   * <ul>
   *   <li>When randomUUID.
   *   <li>Then return Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#OtaPackageInfoEntity(UUID, long, UUID, UUID,
   * OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String,
   * Long, Object, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OtaPackageInfoEntity.<init>(UUID, long, UUID, UUID, OtaPackageType, String, String, String, String, String, String, ChecksumAlgorithm, String, Long, Object, boolean)"
  })
  public void testNewOtaPackageInfoEntity_whenRandomUUID_thenReturnIdIsRandomUUID() {
    // Arrange
    UUID id = UUID.randomUUID();

    // Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity =
        new OtaPackageInfoEntity(
            id,
            1L,
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
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
            true);

    // Assert
    JsonNode additionalInfo = actualOtaPackageInfoEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof TextNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertSame(id, actualOtaPackageInfoEntity.getId());
    assertSame(id, actualOtaPackageInfoEntity.getUuid());
  }

  /**
   * Test {@link OtaPackageInfoEntity#toData()}.
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackageInfo OtaPackageInfoEntity.toData()"})
  public void testToData() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    otaPackageInfoEntity.setAdditionalInfo(new ArrayNode(nf));

    // Act and Assert
    JsonNode additionalInfo = otaPackageInfoEntity.toData().getAdditionalInfo();
    assertTrue(additionalInfo instanceof ArrayNode);
    assertEquals("[ ]", additionalInfo.toPrettyString());
    assertEquals(0, additionalInfo.size());
    assertFalse(additionalInfo.elements().hasNext());
    assertTrue(additionalInfo.isEmpty());
  }

  /**
   * Test {@link OtaPackageInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link OtaPackageInfoEntity#OtaPackageInfoEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackageInfo OtaPackageInfoEntity.toData()"})
  public void testToData_givenOtaPackageInfoEntityTenantIdIsRandomUUID() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(UUID.randomUUID());
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");
    otaPackageInfoEntity.setDeviceProfileId(null);

    // Act
    OtaPackageInfo actualToDataResult = otaPackageInfoEntity.toData();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackageInfo OtaPackageInfoEntity.toData()"})
  public void testToData_givenOtaPackageInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange, Act and Assert
    JsonNode additionalInfo = new OtaPackageInfoEntity().toData().getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link OtaPackageInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then AdditionalInfo elements next iterator next return {@link BooleanNode}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackageInfo OtaPackageInfoEntity.toData()"})
  public void testToData_thenAdditionalInfoElementsNextIteratorNextReturnBooleanNode() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode additionalInfo = new ArrayNode(nf);
    additionalInfo.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    OtaPackageInfoEntity otaPackageInfoEntity = new OtaPackageInfoEntity();
    otaPackageInfoEntity.setAdditionalInfo(additionalInfo);

    // Act and Assert
    JsonNode additionalInfo2 = otaPackageInfoEntity.toData().getAdditionalInfo();
    assertTrue(additionalInfo2 instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = additionalInfo2.elements();
    JsonNode nextResult = elementsResult.next();
    Iterator<JsonNode> iteratorResult = nextResult.iterator();
    assertTrue(iteratorResult.next() instanceof BooleanNode);
    assertTrue(nextResult instanceof ObjectNode);
    assertEquals("[ {\n  \"isPublic\" : true\n} ]", additionalInfo2.toPrettyString());
    assertEquals("{\n  \"isPublic\" : true\n}", nextResult.toPrettyString());
    assertEquals(1, nextResult.size());
    assertEquals(1, additionalInfo2.size());
    assertEquals(JsonNodeType.OBJECT, nextResult.getNodeType());
    assertFalse(nextResult.isEmpty());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isObject());
  }

  /**
   * Test {@link OtaPackageInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackageInfo OtaPackageInfoEntity.toData()"})
  public void testToData_thenAdditionalInfoReturnObjectNode() {
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
   * Test {@link OtaPackageInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackageInfo OtaPackageInfoEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
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
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);

    // Act
    OtaPackageInfo actualToDataResult = otaPackageInfoEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    DeviceProfileId deviceProfileId = actualToDataResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
