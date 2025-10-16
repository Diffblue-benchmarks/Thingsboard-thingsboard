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
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.DeviceInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class DeviceInfoEntityDiffblueTest {
  /**
   * Test {@link DeviceInfoEntity#equals(Object)}, and {@link DeviceInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceInfoEntity#equals(Object)}
   *   <li>{@link DeviceInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceInfoEntity, deviceInfoEntity2);
    assertEquals(deviceInfoEntity.hashCode(), deviceInfoEntity2.hashCode());
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}, and {@link DeviceInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceInfoEntity#equals(Object)}
   *   <li>{@link DeviceInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    // Act and Assert
    assertEquals(deviceInfoEntity, deviceInfoEntity);
    int expectedHashCodeResult = deviceInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceInfoEntity.hashCode());
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(false);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(false);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Mr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle(null);
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("Type");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName(null);
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    DeviceInfoEntity deviceInfoEntity2 = new DeviceInfoEntity();
    deviceInfoEntity2.setActive(true);
    deviceInfoEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setCreatedTime(1L);
    deviceInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setCustomerIsPublic(true);
    deviceInfoEntity2.setCustomerTitle("Dr");
    deviceInfoEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setDeviceProfileName("foo.txt");
    deviceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setLabel("Label");
    deviceInfoEntity2.setName("Name");
    deviceInfoEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setType("Type");
    deviceInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, deviceInfoEntity2);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, null);
  }

  /**
   * Test {@link DeviceInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceInfoEntity.equals(Object)", "int DeviceInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceInfoEntity, "Different type to DeviceInfoEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceInfoEntity}
   *   <li>{@link DeviceInfoEntity#setActive(boolean)}
   *   <li>{@link DeviceInfoEntity#setCustomerIsPublic(boolean)}
   *   <li>{@link DeviceInfoEntity#setCustomerTitle(String)}
   *   <li>{@link DeviceInfoEntity#setDeviceProfileName(String)}
   *   <li>{@link DeviceInfoEntity#toString()}
   *   <li>{@link DeviceInfoEntity#getCustomerTitle()}
   *   <li>{@link DeviceInfoEntity#getDeviceProfileName()}
   *   <li>{@link DeviceInfoEntity#isActive()}
   *   <li>{@link DeviceInfoEntity#isCustomerIsPublic()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceInfoEntity.<init>()",
    "String DeviceInfoEntity.getCustomerTitle()",
    "String DeviceInfoEntity.getDeviceProfileName()",
    "boolean DeviceInfoEntity.isActive()",
    "boolean DeviceInfoEntity.isCustomerIsPublic()",
    "void DeviceInfoEntity.setActive(boolean)",
    "void DeviceInfoEntity.setCustomerIsPublic(boolean)",
    "void DeviceInfoEntity.setCustomerTitle(String)",
    "void DeviceInfoEntity.setDeviceProfileName(String)",
    "String DeviceInfoEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DeviceInfoEntity actualDeviceInfoEntity = new DeviceInfoEntity();
    actualDeviceInfoEntity.setActive(true);
    actualDeviceInfoEntity.setCustomerIsPublic(true);
    actualDeviceInfoEntity.setCustomerTitle("Dr");
    actualDeviceInfoEntity.setDeviceProfileName("foo.txt");
    String actualToStringResult = actualDeviceInfoEntity.toString();
    String actualCustomerTitle = actualDeviceInfoEntity.getCustomerTitle();
    String actualDeviceProfileName = actualDeviceInfoEntity.getDeviceProfileName();
    boolean actualIsActiveResult = actualDeviceInfoEntity.isActive();
    boolean actualIsCustomerIsPublicResult = actualDeviceInfoEntity.isCustomerIsPublic();

    // Assert
    assertEquals(
        "DeviceInfoEntity(customerTitle=Dr, customerIsPublic=true, deviceProfileName=foo.txt, active=true)",
        actualToStringResult);
    assertEquals("Dr", actualCustomerTitle);
    assertEquals("foo.txt", actualDeviceProfileName);
    assertNull(actualDeviceInfoEntity.getAdditionalInfo());
    assertNull(actualDeviceInfoEntity.getDeviceData());
    assertNull(actualDeviceInfoEntity.getVersion());
    assertNull(actualDeviceInfoEntity.getLabel());
    assertNull(actualDeviceInfoEntity.getName());
    assertNull(actualDeviceInfoEntity.getType());
    assertNull(actualDeviceInfoEntity.getId());
    assertNull(actualDeviceInfoEntity.getUuid());
    assertNull(actualDeviceInfoEntity.getCustomerId());
    assertNull(actualDeviceInfoEntity.getDeviceProfileId());
    assertNull(actualDeviceInfoEntity.getExternalId());
    assertNull(actualDeviceInfoEntity.getFirmwareId());
    assertNull(actualDeviceInfoEntity.getSoftwareId());
    assertNull(actualDeviceInfoEntity.getTenantId());
    assertEquals(0L, actualDeviceInfoEntity.getCreatedTime());
    assertTrue(actualIsActiveResult);
    assertTrue(actualIsCustomerIsPublicResult);
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceInfoEntity} (default constructor).
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_givenDeviceInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    DeviceInfo actualToDataResult = new DeviceInfoEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getLabel());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getCustomerTitle());
    assertNull(actualToDataResult.getDeviceProfileName());
    assertNull(actualToDataResult.getUuidId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isActive());
    assertFalse(actualToDataResult.isCustomerIsPublic());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return CustomerId EntityType is {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnCustomerIdEntityTypeIsCustomer() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileId(null);
    deviceInfoEntity.setFirmwareId(null);
    deviceInfoEntity.setSoftwareId(null);
    deviceInfoEntity.setExternalId(null);
    deviceInfoEntity.setDeviceData(null);

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return DeviceProfileId EntityType is {@code DEVICE_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnDeviceProfileIdEntityTypeIsDeviceProfile() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(null);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(null);
    deviceInfoEntity.setSoftwareId(null);
    deviceInfoEntity.setExternalId(null);
    deviceInfoEntity.setDeviceData(null);

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    DeviceProfileId deviceProfileId = actualToDataResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId EntityType is {@code DEVICE}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnExternalIdEntityTypeIsDevice() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(null);
    deviceInfoEntity.setDeviceProfileId(null);
    deviceInfoEntity.setFirmwareId(null);
    deviceInfoEntity.setSoftwareId(null);
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceData(null);

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    DeviceId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return FirmwareId EntityType is {@code OTA_PACKAGE}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnFirmwareIdEntityTypeIsOtaPackage() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(null);
    deviceInfoEntity.setDeviceProfileId(null);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setSoftwareId(null);
    deviceInfoEntity.setExternalId(null);
    deviceInfoEntity.setDeviceData(null);

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    OtaPackageId firmwareId = actualToDataResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertTrue(firmwareId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnNotTenantIdNullUid() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    UUID tenantId = UUID.randomUUID();
    deviceInfoEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = deviceInfoEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return SoftwareId EntityType is {@code OTA_PACKAGE}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnSoftwareIdEntityTypeIsOtaPackage() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);
    deviceInfoEntity.setTenantId(null);
    deviceInfoEntity.setCustomerId(null);
    deviceInfoEntity.setDeviceProfileId(null);
    deviceInfoEntity.setFirmwareId(null);
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setExternalId(null);
    deviceInfoEntity.setDeviceData(null);

    // Act
    DeviceInfo actualToDataResult = deviceInfoEntity.toData();

    // Assert
    OtaPackageId softwareId = actualToDataResult.getSoftwareId();
    assertEquals(EntityType.OTA_PACKAGE, softwareId.getEntityType());
    assertTrue(actualToDataResult.getId().isNullUid());
    assertTrue(softwareId.isNullUid());
  }

  /**
   * Test {@link DeviceInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceInfoEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId = deviceInfoEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
