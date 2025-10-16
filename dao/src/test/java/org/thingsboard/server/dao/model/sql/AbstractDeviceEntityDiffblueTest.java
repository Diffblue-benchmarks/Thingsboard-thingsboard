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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AbstractDeviceEntityDiffblueTest {
  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(null);
    deviceEntity.setSoftwareId(null);
    deviceEntity.setExternalId(null);
    deviceEntity.setDeviceData(null);

    // Act
    Device actualToDeviceResult = deviceEntity.toDevice();

    // Assert
    DeviceProfileId deviceProfileId = actualToDeviceResult.getDeviceProfileId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", deviceProfileId.getId().toString());
    assertNull(actualToDeviceResult.getTenantId());
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    assertTrue(deviceProfileId.isNullUid());
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} DeviceData is Instance.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_givenDeviceEntityDeviceDataIsInstance() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    deviceEntity.setDeviceProfileId(null);
    deviceEntity.setFirmwareId(null);
    deviceEntity.setSoftwareId(null);
    deviceEntity.setExternalId(null);
    deviceEntity.setDeviceData(MissingNode.getInstance());

    // Act
    Device actualToDeviceResult = deviceEntity.toDevice();

    // Assert
    JsonNode additionalInfo = actualToDeviceResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToDeviceResult.getCustomerId());
    assertNull(actualToDeviceResult.getExternalId());
    assertNull(actualToDeviceResult.getDeviceProfileId());
    assertNull(actualToDeviceResult.getFirmwareId());
    assertNull(actualToDeviceResult.getSoftwareId());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} TenantId is randomUUID.
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_givenDeviceEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID tenantId = UUID.randomUUID();
    deviceEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = deviceEntity.toDevice().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_givenDeviceEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Device actualToDeviceResult = new DeviceEntity().toDevice();

    // Assert
    JsonNode additionalInfo = actualToDeviceResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToDeviceResult.getCustomerId());
    assertNull(actualToDeviceResult.getExternalId());
    assertNull(actualToDeviceResult.getDeviceProfileId());
    assertNull(actualToDeviceResult.getFirmwareId());
    assertNull(actualToDeviceResult.getSoftwareId());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_thenAdditionalInfoIteratorNextReturnBooleanNode() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    JsonNode additionalInfo = deviceEntity.toDevice().getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    assertTrue(iteratorResult.next() instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals("{\n  \"isPublic\" : true\n}", additionalInfo.toPrettyString());
    assertEquals(1, additionalInfo.size());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(additionalInfo.isNull());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(iteratorResult.hasNext());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(additionalInfo.isObject());
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Then return CustomerId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_thenReturnCustomerIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceProfileId(null);
    deviceEntity.setFirmwareId(null);
    deviceEntity.setSoftwareId(null);
    deviceEntity.setExternalId(null);
    deviceEntity.setDeviceData(null);

    // Act
    Device actualToDeviceResult = deviceEntity.toDevice();

    // Assert
    CustomerId customerId = actualToDeviceResult.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.getId().toString());
    assertNull(actualToDeviceResult.getTenantId());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_thenReturnExternalIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    deviceEntity.setDeviceProfileId(null);
    deviceEntity.setFirmwareId(null);
    deviceEntity.setSoftwareId(null);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);

    // Act
    Device actualToDeviceResult = deviceEntity.toDevice();

    // Assert
    DeviceId externalId = actualToDeviceResult.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.getId().toString());
    assertNull(actualToDeviceResult.getTenantId());
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Then return FirmwareId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_thenReturnFirmwareIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    deviceEntity.setDeviceProfileId(null);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setSoftwareId(null);
    deviceEntity.setExternalId(null);
    deviceEntity.setDeviceData(null);

    // Act
    Device actualToDeviceResult = deviceEntity.toDevice();

    // Assert
    OtaPackageId firmwareId = actualToDeviceResult.getFirmwareId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", firmwareId.getId().toString());
    assertNull(actualToDeviceResult.getTenantId());
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertTrue(firmwareId.isNullUid());
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Then return SoftwareId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_thenReturnSoftwareIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    deviceEntity.setDeviceProfileId(null);
    deviceEntity.setFirmwareId(null);
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(null);
    deviceEntity.setDeviceData(null);

    // Act
    Device actualToDeviceResult = deviceEntity.toDevice();

    // Assert
    OtaPackageId softwareId = actualToDeviceResult.getSoftwareId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", softwareId.getId().toString());
    assertNull(actualToDeviceResult.getTenantId());
    assertEquals(EntityType.OTA_PACKAGE, softwareId.getEntityType());
    assertTrue(softwareId.isNullUid());
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId = deviceEntity.toDevice().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AbstractDeviceEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link DeviceEntity#DeviceEntity()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#canEqual(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractDeviceEntity.canEqual(Object)"})
  public void testCanEqual_whenDeviceEntity_thenReturnTrue() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    // Act and Assert
    assertTrue(deviceEntity.canEqual(new DeviceEntity()));
  }

  /**
   * Test {@link AbstractDeviceEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#canEqual(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractDeviceEntity.canEqual(Object)"})
  public void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new DeviceEntity().canEqual("Other"));
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}, and {@link AbstractDeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    DeviceEntity deviceEntity2 = new DeviceEntity();

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity2);
    assertEquals(deviceEntity.hashCode(), deviceEntity2.hashCode());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}, and {@link AbstractDeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity2);
    assertNotEquals(deviceEntity.hashCode(), deviceEntity2.hashCode());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}, and {@link AbstractDeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity2);
    assertNotEquals(deviceEntity.hashCode(), deviceEntity2.hashCode());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}, and {@link AbstractDeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity2);
    assertNotEquals(deviceEntity.hashCode(), deviceEntity2.hashCode());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}, and {@link AbstractDeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity2);
    assertNotEquals(deviceEntity.hashCode(), deviceEntity2.hashCode());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}, and {@link AbstractDeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity2);
    assertNotEquals(deviceEntity.hashCode(), deviceEntity2.hashCode());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}, and {@link AbstractDeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity2);
    assertNotEquals(deviceEntity.hashCode(), deviceEntity2.hashCode());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}, and {@link AbstractDeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity2);
    assertNotEquals(deviceEntity.hashCode(), deviceEntity2.hashCode());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}, and {@link AbstractDeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual9() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity2);
    assertNotEquals(deviceEntity.hashCode(), deviceEntity2.hashCode());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}, and {@link AbstractDeviceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    // Act and Assert
    assertEquals(deviceEntity, deviceEntity);
    int expectedHashCodeResult = deviceEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceEntity.hashCode());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceEntity, assetEntity);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(deviceEntity2.getDeviceData())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(deviceEntity2.getLabel()).thenReturn("Label");
    when(deviceEntity2.getName()).thenReturn("Name");
    when(deviceEntity2.getType()).thenReturn("Type");
    when(deviceEntity2.getCustomerId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getExternalId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getFirmwareId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getSoftwareId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getTenantId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setType("Type");
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setName("Name");
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setLabel("Label");
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(deviceEntity2.getDeviceData())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(deviceEntity2.getLabel()).thenReturn("Label");
    when(deviceEntity2.getName()).thenReturn("Name");
    when(deviceEntity2.getType()).thenReturn("Type");
    when(deviceEntity2.getCustomerId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getExternalId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getFirmwareId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getSoftwareId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getTenantId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn("foo");
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn("foo");
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn("foo");
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getSoftwareId()).thenReturn(null);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCreatedTime(1L);

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getAdditionalInfo()).thenReturn(null);
    when(deviceEntity2.getDeviceData()).thenReturn(null);
    when(deviceEntity2.getLabel()).thenReturn(null);
    when(deviceEntity2.getName()).thenReturn(null);
    when(deviceEntity2.getType()).thenReturn(null);
    when(deviceEntity2.getCustomerId()).thenReturn(null);
    when(deviceEntity2.getDeviceProfileId()).thenReturn(null);
    when(deviceEntity2.getExternalId()).thenReturn(null);
    when(deviceEntity2.getFirmwareId()).thenReturn(null);
    when(deviceEntity2.getSoftwareId()).thenReturn(ModelConstants.NULL_UUID);
    when(deviceEntity2.getTenantId()).thenReturn(null);
    when(deviceEntity2.getVersion()).thenReturn(null);
    when(deviceEntity2.getId()).thenReturn(null);
    when(deviceEntity2.getCreatedTime()).thenReturn(1L);
    when(deviceEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceEntity(), null);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceEntity(), "Different type to AbstractDeviceEntity");
  }

  /**
   * Test {@link AbstractDeviceEntity#getAdditionalInfo()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getAdditionalInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AbstractDeviceEntity.getAdditionalInfo()"})
  public void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getAdditionalInfo());
  }

  /**
   * Test {@link AbstractDeviceEntity#getCustomerId()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getCustomerId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractDeviceEntity.getCustomerId()"})
  public void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getCustomerId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getDeviceData()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getDeviceData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AbstractDeviceEntity.getDeviceData()"})
  public void testGetDeviceData() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getDeviceData());
  }

  /**
   * Test {@link AbstractDeviceEntity#getDeviceProfileId()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getDeviceProfileId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractDeviceEntity.getDeviceProfileId()"})
  public void testGetDeviceProfileId() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getDeviceProfileId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getExternalId()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getExternalId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractDeviceEntity.getExternalId()"})
  public void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getExternalId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getFirmwareId()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getFirmwareId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractDeviceEntity.getFirmwareId()"})
  public void testGetFirmwareId() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getFirmwareId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getLabel()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getLabel()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractDeviceEntity.getLabel()"})
  public void testGetLabel() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getLabel());
  }

  /**
   * Test {@link AbstractDeviceEntity#getName()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractDeviceEntity.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getName());
  }

  /**
   * Test {@link AbstractDeviceEntity#getSoftwareId()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getSoftwareId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractDeviceEntity.getSoftwareId()"})
  public void testGetSoftwareId() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getSoftwareId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getTenantId()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getTenantId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractDeviceEntity.getTenantId()"})
  public void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getTenantId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getType()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractDeviceEntity.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getType());
  }

  /**
   * Test {@link AbstractDeviceEntity#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setAdditionalInfo(JsonNode)"})
  public void testSetAdditionalInfo() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    deviceEntity.setAdditionalInfo(additionalInfo);

    // Assert
    assertSame(additionalInfo, deviceEntity.toData().getAdditionalInfo());
    assertSame(additionalInfo, deviceEntity.getAdditionalInfo());
  }

  /**
   * Test {@link AbstractDeviceEntity#setCustomerId(UUID)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setCustomerId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setCustomerId(UUID)"})
  public void testSetCustomerId() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID customerId = ModelConstants.NULL_UUID;

    // Act
    deviceEntity.setCustomerId(customerId);

    // Assert
    CustomerId customerId2 = deviceEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, deviceEntity.getCustomerId());
  }

  /**
   * Test {@link AbstractDeviceEntity#setDeviceData(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setDeviceData(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setDeviceData(JsonNode)"})
  public void testSetDeviceData() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    JsonNode deviceData = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    deviceEntity.setDeviceData(deviceData);

    // Assert
    assertSame(deviceData, deviceEntity.getDeviceData());
  }

  /**
   * Test {@link AbstractDeviceEntity#setDeviceProfileId(UUID)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setDeviceProfileId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setDeviceProfileId(UUID)"})
  public void testSetDeviceProfileId() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID deviceProfileId = ModelConstants.NULL_UUID;

    // Act
    deviceEntity.setDeviceProfileId(deviceProfileId);

    // Assert
    DeviceProfileId deviceProfileId2 = deviceEntity.toData().getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId2.getEntityType());
    assertTrue(deviceProfileId2.isNullUid());
    assertSame(deviceProfileId, deviceProfileId2.getId());
    assertSame(deviceProfileId, deviceEntity.getDeviceProfileId());
  }

  /**
   * Test {@link AbstractDeviceEntity#setExternalId(UUID)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setExternalId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setExternalId(UUID)"})
  public void testSetExternalId() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    deviceEntity.setExternalId(externalId);

    // Assert
    DeviceId externalId2 = deviceEntity.toData().getExternalId();
    assertEquals(EntityType.DEVICE, externalId2.getEntityType());
    assertTrue(externalId2.isNullUid());
    assertSame(externalId, externalId2.getId());
    assertSame(externalId, deviceEntity.getExternalId());
  }

  /**
   * Test {@link AbstractDeviceEntity#setFirmwareId(UUID)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setFirmwareId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setFirmwareId(UUID)"})
  public void testSetFirmwareId() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID firmwareId = ModelConstants.NULL_UUID;

    // Act
    deviceEntity.setFirmwareId(firmwareId);

    // Assert
    OtaPackageId firmwareId2 = deviceEntity.toData().getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId2.getEntityType());
    assertTrue(firmwareId2.isNullUid());
    assertSame(firmwareId, firmwareId2.getId());
    assertSame(firmwareId, deviceEntity.getFirmwareId());
  }

  /**
   * Test {@link AbstractDeviceEntity#setLabel(String)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setLabel(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setLabel(String)"})
  public void testSetLabel() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    // Act
    deviceEntity.setLabel("Label");

    // Assert
    assertEquals("Label", deviceEntity.toData().getLabel());
    assertEquals("Label", deviceEntity.getLabel());
  }

  /**
   * Test {@link AbstractDeviceEntity#setName(String)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setName(String)"})
  public void testSetName() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    // Act
    deviceEntity.setName("Name");

    // Assert
    assertEquals("Name", deviceEntity.toData().getName());
    assertEquals("Name", deviceEntity.getName());
  }

  /**
   * Test {@link AbstractDeviceEntity#setSoftwareId(UUID)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setSoftwareId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setSoftwareId(UUID)"})
  public void testSetSoftwareId() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID softwareId = ModelConstants.NULL_UUID;

    // Act
    deviceEntity.setSoftwareId(softwareId);

    // Assert
    OtaPackageId softwareId2 = deviceEntity.toData().getSoftwareId();
    assertEquals(EntityType.OTA_PACKAGE, softwareId2.getEntityType());
    assertTrue(softwareId2.isNullUid());
    assertSame(softwareId, softwareId2.getId());
    assertSame(softwareId, deviceEntity.getSoftwareId());
  }

  /**
   * Test {@link AbstractDeviceEntity#setTenantId(UUID)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setTenantId(UUID)"})
  public void testSetTenantId() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    deviceEntity.setTenantId(tenantId);

    // Assert
    TenantId tenantId2 = deviceEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, deviceEntity.getTenantId());
  }

  /**
   * Test {@link AbstractDeviceEntity#setType(String)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setType(String)"})
  public void testSetType() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    // Act
    deviceEntity.setType("Type");

    // Assert
    assertEquals("Type", deviceEntity.toData().getType());
    assertEquals("Type", deviceEntity.getType());
  }

  /**
   * Test {@link AbstractDeviceEntity#toString()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractDeviceEntity.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("DeviceEntity()", new DeviceEntity().toString());
  }
}
