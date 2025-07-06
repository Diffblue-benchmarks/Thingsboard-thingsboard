package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class AbstractDeviceEntityDiffblueTest {
  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    UUID deviceProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setDeviceProfileId(deviceProfileId);
    deviceEntity.setFirmwareId(null);
    deviceEntity.setSoftwareId(null);
    deviceEntity.setExternalId(null);
    deviceEntity.setDeviceData(null);

    // Act and Assert
    DeviceProfileId deviceProfileId2 = deviceEntity.toDevice().getDeviceProfileId();
    UUID id = deviceProfileId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId2.getEntityType());
    assertFalse(deviceProfileId2.isNullUid());
    assertSame(deviceProfileId, id);
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
  @Category(MaintainedByDiffblue.class)
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
    assertNull(actualToDeviceResult.getTenantId());
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
   *   <li>Given {@link DeviceEntity#DeviceEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    assertNull(actualToDeviceResult.getTenantId());
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
  @Category(MaintainedByDiffblue.class)
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
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
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
   *   <li>Then return CustomerId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(null);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setCustomerId(customerId);
    deviceEntity.setDeviceProfileId(null);
    deviceEntity.setFirmwareId(null);
    deviceEntity.setSoftwareId(null);
    deviceEntity.setExternalId(null);
    deviceEntity.setDeviceData(null);

    // Act and Assert
    CustomerId customerId2 = deviceEntity.toDevice().getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, id);
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    deviceEntity.setDeviceProfileId(null);
    deviceEntity.setFirmwareId(null);
    deviceEntity.setSoftwareId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setExternalId(externalId);
    deviceEntity.setDeviceData(null);

    // Act and Assert
    DeviceId externalId2 = deviceEntity.toDevice().getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DEVICE, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertSame(externalId, id);
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Then return FirmwareId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_thenReturnFirmwareIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    deviceEntity.setDeviceProfileId(null);
    UUID firmwareId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setFirmwareId(firmwareId);
    deviceEntity.setSoftwareId(null);
    deviceEntity.setExternalId(null);
    deviceEntity.setDeviceData(null);

    // Act and Assert
    OtaPackageId firmwareId2 = deviceEntity.toDevice().getFirmwareId();
    UUID id = firmwareId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.OTA_PACKAGE, firmwareId2.getEntityType());
    assertFalse(firmwareId2.isNullUid());
    assertSame(firmwareId, id);
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   *
   * <ul>
   *   <li>Then return SoftwareId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_thenReturnSoftwareIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(null);
    deviceEntity.setCustomerId(null);
    deviceEntity.setDeviceProfileId(null);
    deviceEntity.setFirmwareId(null);
    UUID softwareId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceEntity.setSoftwareId(softwareId);
    deviceEntity.setExternalId(null);
    deviceEntity.setDeviceData(null);

    // Act and Assert
    OtaPackageId softwareId2 = deviceEntity.toDevice().getSoftwareId();
    UUID id = softwareId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.OTA_PACKAGE, softwareId2.getEntityType());
    assertFalse(softwareId2.isNullUid());
    assertSame(softwareId, id);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_thenReturnTenantIdIdIsRandomUUID() {
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
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Device AbstractDeviceEntity.toDevice()"})
  public void testToDevice_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    TenantId tenantId = deviceEntity.toDevice().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
    int expectedHashCodeResult = deviceEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceEntity2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setType("Type");

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setName("Name");

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setLabel("Label");

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setType("Type");

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setName("Name");

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setLabel("Label");

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setDeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setFirmwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setSoftwareId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractDeviceEntity.equals(Object)",
    "int AbstractDeviceEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractDeviceEntity.setCustomerId(UUID)"})
  public void testSetCustomerId() {
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractDeviceEntity.setDeviceProfileId(UUID)"})
  public void testSetDeviceProfileId() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractDeviceEntity.setExternalId(UUID)"})
  public void testSetExternalId() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractDeviceEntity.setFirmwareId(UUID)"})
  public void testSetFirmwareId() {
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractDeviceEntity.setSoftwareId(UUID)"})
  public void testSetSoftwareId() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractDeviceEntity.setTenantId(UUID)"})
  public void testSetTenantId() {
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractDeviceEntity.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("DeviceEntity()", new DeviceEntity().toString());
  }
}
