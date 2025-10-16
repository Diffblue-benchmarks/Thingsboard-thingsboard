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
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class DeviceEntityDiffblueTest {
  /**
   * Test {@link DeviceEntity#equals(Object)}, and {@link DeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceEntity#equals(Object)}
   *   <li>{@link DeviceEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceEntity.equals(Object)", "int DeviceEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity2.setCreatedTime(1L);
    deviceEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity2.setId(ModelConstants.NULL_UUID);
    deviceEntity2.setLabel("Label");
    deviceEntity2.setName("Name");
    deviceEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity2.setType("Type");
    deviceEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity2);
    assertEquals(deviceEntity.hashCode(), deviceEntity2.hashCode());
  }

  /**
   * Test {@link DeviceEntity#equals(Object)}, and {@link DeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceEntity#equals(Object)}
   *   <li>{@link DeviceEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceEntity.equals(Object)", "int DeviceEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity);
    int expectedHashCodeResult = deviceEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceEntity.hashCode());
  }

  /**
   * Test {@link DeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceEntity.equals(Object)", "int DeviceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity2.setCreatedTime(1L);
    deviceEntity2.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity2.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity2.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity2.setId(ModelConstants.NULL_UUID);
    deviceEntity2.setLabel("Label");
    deviceEntity2.setName("Name");
    deviceEntity2.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity2.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity2.setType("Type");
    deviceEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link DeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceEntity.equals(Object)", "int DeviceEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceEntity, null);
  }

  /**
   * Test {@link DeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceEntity.equals(Object)", "int DeviceEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceEntity, "Different type to DeviceEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceEntity#DeviceEntity()}
   *   <li>{@link DeviceEntity#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceEntity.<init>()", "java.lang.String DeviceEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    DeviceEntity actualDeviceEntity = new DeviceEntity();

    // Assert
    assertEquals("DeviceEntity()", actualDeviceEntity.toString());
    assertNull(actualDeviceEntity.getAdditionalInfo());
    assertNull(actualDeviceEntity.getDeviceData());
    assertNull(actualDeviceEntity.getVersion());
    assertNull(actualDeviceEntity.getLabel());
    assertNull(actualDeviceEntity.getName());
    assertNull(actualDeviceEntity.getType());
    assertNull(actualDeviceEntity.getId());
    assertNull(actualDeviceEntity.getUuid());
    assertNull(actualDeviceEntity.getCustomerId());
    assertNull(actualDeviceEntity.getDeviceProfileId());
    assertNull(actualDeviceEntity.getExternalId());
    assertNull(actualDeviceEntity.getFirmwareId());
    assertNull(actualDeviceEntity.getSoftwareId());
    assertNull(actualDeviceEntity.getTenantId());
    assertEquals(0L, actualDeviceEntity.getCreatedTime());
  }

  /**
   * Test {@link DeviceEntity#DeviceEntity(Device)}.
   *
   * <p>Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceEntity.<init>(Device)"})
  public void testNewDeviceEntity() {
    // Arrange
    Device device = new Device();
    device.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(device);

    // Assert
    UUID customerId = actualDeviceEntity.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.toString());
    CustomerId customerId2 = actualDeviceEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
  }

  /**
   * Test {@link DeviceEntity#DeviceEntity(Device)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceEntity.<init>(Device)"})
  public void testNewDeviceEntity_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(device);

    // Assert
    assertNull(actualDeviceEntity.getCustomerId());
    assertNull(actualDeviceEntity.getTenantId());
    Device toDataResult = actualDeviceEntity.toData();
    assertNull(toDataResult.getCustomerId());
    assertNull(toDataResult.getTenantId());
  }

  /**
   * Test {@link DeviceEntity#DeviceEntity(Device)}.
   *
   * <ul>
   *   <li>Then return TenantId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceEntity.<init>(Device)"})
  public void testNewDeviceEntity_thenReturnTenantIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Device device = new Device();
    device.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(device);

    // Assert
    UUID tenantId = actualDeviceEntity.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.toString());
    TenantId tenantId2 = actualDeviceEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DeviceEntity#DeviceEntity(Device)}.
   *
   * <ul>
   *   <li>When {@link Device#Device()}.
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceEntity.<init>(Device)"})
  public void testNewDeviceEntity_whenDevice_thenReturnCustomerIdIsNull() {
    // Arrange and Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(new Device());

    // Assert
    assertNull(actualDeviceEntity.getCustomerId());
    assertNull(actualDeviceEntity.getTenantId());
    Device toDataResult = actualDeviceEntity.toData();
    assertNull(toDataResult.getCustomerId());
    assertNull(toDataResult.getTenantId());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} DeviceData is Instance.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceEntity.toData()"})
  public void testToData_givenDeviceEntityDeviceDataIsInstance() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    deviceEntity.setDeviceProfileId(null);
    deviceEntity.setFirmwareId(null);
    deviceEntity.setSoftwareId(null);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());

    // Act
    Device actualToDataResult = deviceEntity.toData();

    // Assert
    DeviceId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} TenantId is randomUUID.
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceEntity.toData()"})
  public void testToData_givenDeviceEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID tenantId = UUID.randomUUID();
    deviceEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = deviceEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceEntity.toData()"})
  public void testToData_givenDeviceEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Device actualToDataResult = new DeviceEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getLabel());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUuidId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   *
   * <ul>
   *   <li>Then return CustomerId EntityType is {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceEntity.toData()"})
  public void testToData_thenReturnCustomerIdEntityTypeIsCustomer() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceProfileId(null);
    deviceEntity.setFirmwareId(null);
    deviceEntity.setSoftwareId(null);
    deviceEntity.setExternalId(null);
    deviceEntity.setDeviceData(null);

    // Act
    Device actualToDataResult = deviceEntity.toData();

    // Assert
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   *
   * <ul>
   *   <li>Then return DeviceProfileId EntityType is {@code DEVICE_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceEntity.toData()"})
  public void testToData_thenReturnDeviceProfileIdEntityTypeIsDeviceProfile() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(null);
    deviceEntity.setSoftwareId(null);
    deviceEntity.setExternalId(null);
    deviceEntity.setDeviceData(null);

    // Act
    Device actualToDataResult = deviceEntity.toData();

    // Assert
    DeviceProfileId deviceProfileId = actualToDataResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId EntityType is {@code DEVICE}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceEntity.toData()"})
  public void testToData_thenReturnExternalIdEntityTypeIsDevice() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    deviceEntity.setDeviceProfileId(null);
    deviceEntity.setFirmwareId(null);
    deviceEntity.setSoftwareId(null);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);

    // Act
    Device actualToDataResult = deviceEntity.toData();

    // Assert
    DeviceId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   *
   * <ul>
   *   <li>Then return FirmwareId EntityType is {@code OTA_PACKAGE}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceEntity.toData()"})
  public void testToData_thenReturnFirmwareIdEntityTypeIsOtaPackage() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    deviceEntity.setDeviceProfileId(null);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setSoftwareId(null);
    deviceEntity.setExternalId(null);
    deviceEntity.setDeviceData(null);

    // Act
    Device actualToDataResult = deviceEntity.toData();

    // Assert
    OtaPackageId firmwareId = actualToDataResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertTrue(firmwareId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   *
   * <ul>
   *   <li>Then return SoftwareId EntityType is {@code OTA_PACKAGE}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceEntity.toData()"})
  public void testToData_thenReturnSoftwareIdEntityTypeIsOtaPackage() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    deviceEntity.setDeviceProfileId(null);
    deviceEntity.setFirmwareId(null);
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(null);
    deviceEntity.setDeviceData(null);

    // Act
    Device actualToDataResult = deviceEntity.toData();

    // Assert
    OtaPackageId softwareId = actualToDataResult.getSoftwareId();
    assertEquals(EntityType.OTA_PACKAGE, softwareId.getEntityType());
    assertTrue(actualToDataResult.getId().isNullUid());
    assertTrue(softwareId.isNullUid());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId = deviceEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
