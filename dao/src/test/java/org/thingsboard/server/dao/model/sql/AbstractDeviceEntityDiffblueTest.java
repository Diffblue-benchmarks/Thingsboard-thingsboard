package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class AbstractDeviceEntityDiffblueTest {
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
  @DisplayName("Test toDevice(); given DeviceEntity() DeviceData is Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  void testToDevice_givenDeviceEntityDeviceDataIsInstance() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setCustomerId(customerId);
    UUID deviceProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setDeviceProfileId(deviceProfileId);
    UUID firmwareId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setFirmwareId(firmwareId);
    deviceEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setExternalId(externalId);
    deviceEntity.setDeviceData(MissingNode.getInstance());

    // Act
    Device actualToDeviceResult = deviceEntity.toDevice();

    // Assert
    CustomerId customerId2 = actualToDeviceResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    DeviceId externalId2 = actualToDeviceResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId2.getEntityType());
    DeviceProfileId deviceProfileId2 = actualToDeviceResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId2.getEntityType());
    OtaPackageId firmwareId2 = actualToDeviceResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId2.getEntityType());
    TenantId tenantId = actualToDeviceResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertFalse(deviceProfileId2.isNullUid());
    assertFalse(externalId2.isNullUid());
    assertFalse(firmwareId2.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertEquals(firmwareId2, actualToDeviceResult.getSoftwareId());
    assertSame(customerId, customerId2.getId());
    assertSame(deviceProfileId, deviceProfileId2.getId());
    assertSame(externalId, externalId2.getId());
    assertSame(firmwareId, firmwareId2.getId());
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} DeviceData is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @DisplayName("Test toDevice(); given DeviceEntity() DeviceData is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  void testToDevice_givenDeviceEntityDeviceDataIsNull() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setCustomerId(customerId);
    UUID deviceProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setDeviceProfileId(deviceProfileId);
    UUID firmwareId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setFirmwareId(firmwareId);
    deviceEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setExternalId(externalId);
    deviceEntity.setDeviceData(null);

    // Act
    Device actualToDeviceResult = deviceEntity.toDevice();

    // Assert
    CustomerId customerId2 = actualToDeviceResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    DeviceId externalId2 = actualToDeviceResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId2.getEntityType());
    DeviceProfileId deviceProfileId2 = actualToDeviceResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId2.getEntityType());
    OtaPackageId firmwareId2 = actualToDeviceResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId2.getEntityType());
    TenantId tenantId = actualToDeviceResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertFalse(deviceProfileId2.isNullUid());
    assertFalse(externalId2.isNullUid());
    assertFalse(firmwareId2.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertEquals(firmwareId2, actualToDeviceResult.getSoftwareId());
    assertSame(customerId, customerId2.getId());
    assertSame(deviceProfileId, deviceProfileId2.getId());
    assertSame(externalId, externalId2.getId());
    assertSame(firmwareId, firmwareId2.getId());
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()}.
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @DisplayName("Test toDevice(); given DeviceEntity(); then return CustomerId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  void testToDevice_givenDeviceEntity_thenReturnCustomerIdIsNull() {
    // Arrange and Act
    Device actualToDeviceResult = new DeviceEntity().toDevice();

    // Assert
    assertNull(actualToDeviceResult.getCustomerId());
    assertNull(actualToDeviceResult.getExternalId());
    assertNull(actualToDeviceResult.getDeviceProfileId());
    assertNull(actualToDeviceResult.getFirmwareId());
    assertNull(actualToDeviceResult.getSoftwareId());
    assertNull(actualToDeviceResult.getTenantId());
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
  @DisplayName("Test toDevice(); then AdditionalInfo iterator next return BooleanNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  void testToDevice_thenAdditionalInfoIteratorNextReturnBooleanNode() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    JsonNode additionalInfo = deviceEntity.toDevice().getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    assertTrue(iteratorResult.next() instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
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
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @DisplayName("Test toDevice(); then return TenantId Id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  void testToDevice_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID tenantId = UUID.randomUUID();
    deviceEntity.setTenantId(tenantId);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setCustomerId(customerId);
    UUID deviceProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setDeviceProfileId(deviceProfileId);
    UUID firmwareId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setFirmwareId(firmwareId);
    deviceEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setExternalId(externalId);
    deviceEntity.setDeviceData(null);

    // Act
    Device actualToDeviceResult = deviceEntity.toDevice();

    // Assert
    CustomerId customerId2 = actualToDeviceResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    DeviceId externalId2 = actualToDeviceResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId2.getEntityType());
    DeviceProfileId deviceProfileId2 = actualToDeviceResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId2.getEntityType());
    OtaPackageId firmwareId2 = actualToDeviceResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId2.getEntityType());
    TenantId tenantId2 = actualToDeviceResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertFalse(deviceProfileId2.isNullUid());
    assertFalse(externalId2.isNullUid());
    assertFalse(firmwareId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertEquals(firmwareId2, actualToDeviceResult.getSoftwareId());
    assertSame(customerId, customerId2.getId());
    assertSame(deviceProfileId, deviceProfileId2.getId());
    assertSame(externalId, externalId2.getId());
    assertSame(firmwareId, firmwareId2.getId());
    assertSame(tenantId, tenantId2.getId());
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
  @DisplayName("Test canEqual(Object); when DeviceEntity(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractDeviceEntity.canEqual(Object)"})
  void testCanEqual_whenDeviceEntity_thenReturnTrue() {
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
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractDeviceEntity.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = mock(DeviceEntity.class);
    when(deviceEntity2.getVersion()).thenReturn(1L);
    when(deviceEntity2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceEntity(), "Different type to AbstractDeviceEntity");
  }

  /**
   * Test {@link AbstractDeviceEntity#getAdditionalInfo()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AbstractDeviceEntity.getAdditionalInfo()"})
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getAdditionalInfo());
  }

  /**
   * Test {@link AbstractDeviceEntity#getCustomerId()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getCustomerId()}
   */
  @Test
  @DisplayName("Test getCustomerId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractDeviceEntity.getCustomerId()"})
  void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getCustomerId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getDeviceData()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AbstractDeviceEntity.getDeviceData()"})
  void testGetDeviceData() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getDeviceData());
  }

  /**
   * Test {@link AbstractDeviceEntity#getDeviceProfileId()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getDeviceProfileId()}
   */
  @Test
  @DisplayName("Test getDeviceProfileId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractDeviceEntity.getDeviceProfileId()"})
  void testGetDeviceProfileId() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getDeviceProfileId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getExternalId()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractDeviceEntity.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getExternalId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getFirmwareId()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getFirmwareId()}
   */
  @Test
  @DisplayName("Test getFirmwareId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractDeviceEntity.getFirmwareId()"})
  void testGetFirmwareId() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getFirmwareId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getLabel()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractDeviceEntity.getLabel()"})
  void testGetLabel() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getLabel());
  }

  /**
   * Test {@link AbstractDeviceEntity#getName()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractDeviceEntity.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getName());
  }

  /**
   * Test {@link AbstractDeviceEntity#getSoftwareId()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getSoftwareId()}
   */
  @Test
  @DisplayName("Test getSoftwareId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractDeviceEntity.getSoftwareId()"})
  void testGetSoftwareId() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getSoftwareId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getTenantId()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractDeviceEntity.getTenantId()"})
  void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getTenantId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getType()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractDeviceEntity.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertNull(new DeviceEntity().getType());
  }

  /**
   * Test {@link AbstractDeviceEntity#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo() {
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
  @DisplayName("Test setCustomerId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setCustomerId(UUID)"})
  void testSetCustomerId() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    deviceEntity.setCustomerId(customerId);

    // Assert
    CustomerId customerId2 = deviceEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, deviceEntity.getCustomerId());
  }

  /**
   * Test {@link AbstractDeviceEntity#setDeviceData(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setDeviceData(JsonNode)}
   */
  @Test
  @DisplayName("Test setDeviceData(JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setDeviceData(JsonNode)"})
  void testSetDeviceData() {
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
  @DisplayName("Test setDeviceProfileId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setDeviceProfileId(UUID)"})
  void testSetDeviceProfileId() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID deviceProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    deviceEntity.setDeviceProfileId(deviceProfileId);

    // Assert
    DeviceProfileId deviceProfileId2 = deviceEntity.toData().getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId2.getEntityType());
    assertFalse(deviceProfileId2.isNullUid());
    assertSame(deviceProfileId, deviceProfileId2.getId());
    assertSame(deviceProfileId, deviceEntity.getDeviceProfileId());
  }

  /**
   * Test {@link AbstractDeviceEntity#setExternalId(UUID)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setExternalId(UUID)}
   */
  @Test
  @DisplayName("Test setExternalId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setExternalId(UUID)"})
  void testSetExternalId() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    deviceEntity.setExternalId(externalId);

    // Assert
    DeviceId externalId2 = deviceEntity.toData().getExternalId();
    assertEquals(EntityType.DEVICE, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertSame(externalId, externalId2.getId());
    assertSame(externalId, deviceEntity.getExternalId());
  }

  /**
   * Test {@link AbstractDeviceEntity#setFirmwareId(UUID)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setFirmwareId(UUID)}
   */
  @Test
  @DisplayName("Test setFirmwareId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setFirmwareId(UUID)"})
  void testSetFirmwareId() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID firmwareId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    deviceEntity.setFirmwareId(firmwareId);

    // Assert
    OtaPackageId firmwareId2 = deviceEntity.toData().getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId2.getEntityType());
    assertFalse(firmwareId2.isNullUid());
    assertSame(firmwareId, firmwareId2.getId());
    assertSame(firmwareId, deviceEntity.getFirmwareId());
  }

  /**
   * Test {@link AbstractDeviceEntity#setLabel(String)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setLabel(String)}
   */
  @Test
  @DisplayName("Test setLabel(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setLabel(String)"})
  void testSetLabel() {
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
  @DisplayName("Test setName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setName(String)"})
  void testSetName() {
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
  @DisplayName("Test setSoftwareId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setSoftwareId(UUID)"})
  void testSetSoftwareId() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID softwareId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    deviceEntity.setSoftwareId(softwareId);

    // Assert
    OtaPackageId softwareId2 = deviceEntity.toData().getSoftwareId();
    assertEquals(EntityType.OTA_PACKAGE, softwareId2.getEntityType());
    assertFalse(softwareId2.isNullUid());
    assertSame(softwareId, softwareId2.getId());
    assertSame(softwareId, deviceEntity.getSoftwareId());
  }

  /**
   * Test {@link AbstractDeviceEntity#setTenantId(UUID)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setTenantId(UUID)}
   */
  @Test
  @DisplayName("Test setTenantId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setTenantId(UUID)"})
  void testSetTenantId() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    deviceEntity.setTenantId(tenantId);

    // Assert
    TenantId tenantId2 = deviceEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId2.getId().toString());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, deviceEntity.getTenantId());
  }

  /**
   * Test {@link AbstractDeviceEntity#setType(String)}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#setType(String)}
   */
  @Test
  @DisplayName("Test setType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractDeviceEntity.setType(String)"})
  void testSetType() {
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
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractDeviceEntity.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("DeviceEntity()", new DeviceEntity().toString());
  }
}
