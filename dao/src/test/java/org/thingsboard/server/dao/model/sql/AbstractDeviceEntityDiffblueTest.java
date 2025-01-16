package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
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
import org.thingsboard.server.dao.model.ModelConstants;

public class AbstractDeviceEntityDiffblueTest {
  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   * <p>
   * Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} DeviceData is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} TenantId is randomUUID.</li>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  public void testToDevice_givenDeviceEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    UUID tenantId = UUID.randomUUID();
    deviceEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = deviceEntity.toDevice().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AbstractDeviceEntity#toDevice()}.
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  public void testToDevice_givenDeviceEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Device actualToDeviceResult = (new DeviceEntity()).toDevice();

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
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
  public void testToDevice_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    JsonNode additionalInfo = deviceEntity.toDevice().getAdditionalInfo();
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
    assertFalse(additionalInfo.isNull());
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
   * Test {@link AbstractDeviceEntity#toDevice()}.
   * <ul>
   *   <li>Then return CustomerId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
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
   * <ul>
   *   <li>Then return ExternalId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
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
   * <ul>
   *   <li>Then return FirmwareId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
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
   * <ul>
   *   <li>Then return SoftwareId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
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
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#toDevice()}
   */
  @Test
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
   * <ul>
   *   <li>When {@link DeviceEntity#DeviceEntity()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenDeviceEntity_thenReturnTrue() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    // Act and Assert
    assertTrue(deviceEntity.canEqual(new DeviceEntity()));
  }

  /**
   * Test {@link AbstractDeviceEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DeviceEntity()).canEqual("Other"));
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}, and
   * {@link AbstractDeviceEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
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
   * Test {@link AbstractDeviceEntity#equals(Object)}, and
   * {@link AbstractDeviceEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceEntity(), mock(DeviceInfoEntity.class));
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setType("Type");

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setName("Name");

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setLabel("Label");

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceEntity, new DeviceEntity());
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setCustomerId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setType("Type");

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setName("Name");

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setLabel("Label");

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setDeviceProfileId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setFirmwareId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setSoftwareId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();

    DeviceEntity deviceEntity2 = new DeviceEntity();
    deviceEntity2.setExternalId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(deviceEntity, deviceEntity2);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceEntity(), null);
  }

  /**
   * Test {@link AbstractDeviceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractDeviceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceEntity(), "Different type to AbstractDeviceEntity");
  }

  /**
   * Test {@link AbstractDeviceEntity#getAdditionalInfo()}.
   * <p>
   * Method under test: {@link AbstractDeviceEntity#getAdditionalInfo()}
   */
  @Test
  public void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new DeviceEntity()).getAdditionalInfo());
  }

  /**
   * Test {@link AbstractDeviceEntity#getCustomerId()}.
   * <p>
   * Method under test: {@link AbstractDeviceEntity#getCustomerId()}
   */
  @Test
  public void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull((new DeviceEntity()).getCustomerId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getDeviceData()}.
   * <p>
   * Method under test: {@link AbstractDeviceEntity#getDeviceData()}
   */
  @Test
  public void testGetDeviceData() {
    // Arrange, Act and Assert
    assertNull((new DeviceEntity()).getDeviceData());
  }

  /**
   * Test {@link AbstractDeviceEntity#getDeviceProfileId()}.
   * <p>
   * Method under test: {@link AbstractDeviceEntity#getDeviceProfileId()}
   */
  @Test
  public void testGetDeviceProfileId() {
    // Arrange, Act and Assert
    assertNull((new DeviceEntity()).getDeviceProfileId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getExternalId()}.
   * <p>
   * Method under test: {@link AbstractDeviceEntity#getExternalId()}
   */
  @Test
  public void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new DeviceEntity()).getExternalId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getFirmwareId()}.
   * <p>
   * Method under test: {@link AbstractDeviceEntity#getFirmwareId()}
   */
  @Test
  public void testGetFirmwareId() {
    // Arrange, Act and Assert
    assertNull((new DeviceEntity()).getFirmwareId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getLabel()}.
   * <p>
   * Method under test: {@link AbstractDeviceEntity#getLabel()}
   */
  @Test
  public void testGetLabel() {
    // Arrange, Act and Assert
    assertNull((new DeviceEntity()).getLabel());
  }

  /**
   * Test {@link AbstractDeviceEntity#getName()}.
   * <p>
   * Method under test: {@link AbstractDeviceEntity#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull((new DeviceEntity()).getName());
  }

  /**
   * Test {@link AbstractDeviceEntity#getSoftwareId()}.
   * <p>
   * Method under test: {@link AbstractDeviceEntity#getSoftwareId()}
   */
  @Test
  public void testGetSoftwareId() {
    // Arrange, Act and Assert
    assertNull((new DeviceEntity()).getSoftwareId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getTenantId()}.
   * <p>
   * Method under test: {@link AbstractDeviceEntity#getTenantId()}
   */
  @Test
  public void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull((new DeviceEntity()).getTenantId());
  }

  /**
   * Test {@link AbstractDeviceEntity#getType()}.
   * <p>
   * Method under test: {@link AbstractDeviceEntity#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull((new DeviceEntity()).getType());
  }

  /**
   * Test {@link AbstractDeviceEntity#setAdditionalInfo(JsonNode)}.
   * <p>
   * Method under test: {@link AbstractDeviceEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractDeviceEntity#setCustomerId(UUID)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractDeviceEntity#setDeviceData(JsonNode)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractDeviceEntity#setDeviceProfileId(UUID)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractDeviceEntity#setExternalId(UUID)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractDeviceEntity#setFirmwareId(UUID)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractDeviceEntity#setLabel(String)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractDeviceEntity#setName(String)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractDeviceEntity#setSoftwareId(UUID)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractDeviceEntity#setTenantId(UUID)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractDeviceEntity#setType(String)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractDeviceEntity#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("DeviceEntity()", (new DeviceEntity()).toString());
  }
}
