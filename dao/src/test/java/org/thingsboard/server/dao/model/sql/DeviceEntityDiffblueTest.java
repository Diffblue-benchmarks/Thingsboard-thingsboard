package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.Test;
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
   * Test {@link DeviceEntity#equals(Object)}, and
   * {@link DeviceEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceEntity#equals(Object)}
   *   <li>{@link DeviceEntity#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = deviceEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceEntity2.hashCode());
  }

  /**
   * Test {@link DeviceEntity#equals(Object)}, and
   * {@link DeviceEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceEntity#equals(Object)}
   *   <li>{@link DeviceEntity#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(MissingNode.getInstance());
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(mock(JsonNode.class));
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#equals(Object)}
   */
  @Test
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceEntity#DeviceEntity()}
   *   <li>{@link DeviceEntity#toString()}
   * </ul>
   */
  @Test
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
   * <p>
   * Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
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
   * <p>
   * Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  public void testNewDeviceEntity2() {
    // Arrange
    Device device = new Device();
    DeviceProfileId deviceProfileId = new DeviceProfileId(ModelConstants.NULL_UUID);
    device.setDeviceProfileId(deviceProfileId);

    // Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(device);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDeviceEntity.getDeviceProfileId().toString());
    assertEquals(deviceProfileId, actualDeviceEntity.toData().getDeviceProfileId());
  }

  /**
   * Test {@link DeviceEntity#DeviceEntity(Device)}.
   * <p>
   * Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  public void testNewDeviceEntity3() {
    // Arrange
    Device device = new Device();
    OtaPackageId firmwareId = new OtaPackageId(ModelConstants.NULL_UUID);
    device.setFirmwareId(firmwareId);

    // Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(device);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDeviceEntity.getFirmwareId().toString());
    assertEquals(firmwareId, actualDeviceEntity.toData().getFirmwareId());
  }

  /**
   * Test {@link DeviceEntity#DeviceEntity(Device)}.
   * <p>
   * Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  public void testNewDeviceEntity4() {
    // Arrange
    Device device = new Device();
    OtaPackageId softwareId = new OtaPackageId(ModelConstants.NULL_UUID);
    device.setSoftwareId(softwareId);

    // Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(device);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDeviceEntity.getSoftwareId().toString());
    assertEquals(softwareId, actualDeviceEntity.toData().getSoftwareId());
  }

  /**
   * Test {@link DeviceEntity#DeviceEntity(Device)}.
   * <p>
   * Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  public void testNewDeviceEntity5() {
    // Arrange
    Device device = new Device();
    DeviceId externalId = new DeviceId(ModelConstants.NULL_UUID);
    device.setExternalId(externalId);

    // Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(device);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDeviceEntity.getExternalId().toString());
    assertEquals(externalId, actualDeviceEntity.toData().getExternalId());
  }

  /**
   * Test {@link DeviceEntity#DeviceEntity(Device)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  public void testNewDeviceEntity_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(device);

    // Assert
    assertNull(actualDeviceEntity.getCustomerId());
    assertNull(actualDeviceEntity.getDeviceProfileId());
    assertNull(actualDeviceEntity.getExternalId());
    assertNull(actualDeviceEntity.getFirmwareId());
    assertNull(actualDeviceEntity.getSoftwareId());
    assertNull(actualDeviceEntity.getTenantId());
    Device toDataResult = actualDeviceEntity.toData();
    assertNull(toDataResult.getCustomerId());
    assertNull(toDataResult.getExternalId());
    assertNull(toDataResult.getDeviceProfileId());
    assertNull(toDataResult.getFirmwareId());
    assertNull(toDataResult.getSoftwareId());
    assertNull(toDataResult.getTenantId());
  }

  /**
   * Test {@link DeviceEntity#DeviceEntity(Device)}.
   * <ul>
   *   <li>When {@link Device#Device()}.</li>
   *   <li>Then return CustomerId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#DeviceEntity(Device)}
   */
  @Test
  public void testNewDeviceEntity_whenDevice_thenReturnCustomerIdIsNull() {
    // Arrange and Act
    DeviceEntity actualDeviceEntity = new DeviceEntity(new Device());

    // Assert
    assertNull(actualDeviceEntity.getCustomerId());
    assertNull(actualDeviceEntity.getDeviceProfileId());
    assertNull(actualDeviceEntity.getExternalId());
    assertNull(actualDeviceEntity.getFirmwareId());
    assertNull(actualDeviceEntity.getSoftwareId());
    assertNull(actualDeviceEntity.getTenantId());
    Device toDataResult = actualDeviceEntity.toData();
    assertNull(toDataResult.getCustomerId());
    assertNull(toDataResult.getExternalId());
    assertNull(toDataResult.getDeviceProfileId());
    assertNull(toDataResult.getFirmwareId());
    assertNull(toDataResult.getSoftwareId());
    assertNull(toDataResult.getTenantId());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} TenantId is randomUUID.</li>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  public void testToData_givenDeviceEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID tenantId = UUID.randomUUID();
    deviceEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = deviceEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#toData()}
   */
  @Test
  public void testToData_givenDeviceEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Device actualToDataResult = (new DeviceEntity()).toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getLabel());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUuidId());
    DeviceId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertEquals(0, additionalInfo.size());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(id.isNullUid());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link DeviceEntity#toData()}.
   * <ul>
   *   <li>Then return CustomerId EntityType is {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#toData()}
   */
  @Test
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
   * <ul>
   *   <li>Then return DeviceProfileId EntityType is {@code DEVICE_PROFILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#toData()}
   */
  @Test
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
   * <ul>
   *   <li>Then return ExternalId EntityType is {@code DEVICE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#toData()}
   */
  @Test
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
   * <ul>
   *   <li>Then return FirmwareId EntityType is {@code OTA_PACKAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#toData()}
   */
  @Test
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
   * <ul>
   *   <li>Then return SoftwareId EntityType is {@code OTA_PACKAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#toData()}
   */
  @Test
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
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEntity#toData()}
   */
  @Test
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
