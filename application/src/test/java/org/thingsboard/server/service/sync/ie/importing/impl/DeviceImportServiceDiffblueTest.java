package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceDao;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

class DeviceImportServiceDiffblueTest {
  /**
   * Test {@link DeviceImportService#deepCopy(Device)} with {@code Device}.
   * <p>
   * Method under test: {@link DeviceImportService#deepCopy(Device)}
   */
  @Test
  @DisplayName("Test deepCopy(Device) with 'Device'")
  void testDeepCopyWithDevice() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceImportService deviceImportService = new DeviceImportService(deviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()));

    // Act
    Device actualDeepCopyResult = deviceImportService.deepCopy(new Device());

    // Assert
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
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
    assertNull(actualDeepCopyResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDeepCopyResult.getVersion());
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
    assertNull(actualDeepCopyResult.getLabel());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getType());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getDeviceData());
    assertNull(actualDeepCopyResult.getCustomerId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getDeviceProfileId());
    assertNull(actualDeepCopyResult.getFirmwareId());
    assertNull(actualDeepCopyResult.getSoftwareId());
    assertNull(actualDeepCopyResult.getTenantId());
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
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
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
   * Test {@link DeviceImportService#deepCopy(Device)} with {@code Device}.
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is
   * {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#deepCopy(Device)}
   */
  @Test
  @DisplayName("Test deepCopy(Device) with 'Device'; when Device(Device) with device is Device()")
  void testDeepCopyWithDevice_whenDeviceWithDeviceIsDevice() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceImportService deviceImportService = new DeviceImportService(deviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()));

    // Act
    Device actualDeepCopyResult = deviceImportService.deepCopy(new Device(new Device()));

    // Assert
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
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
    assertNull(actualDeepCopyResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDeepCopyResult.getVersion());
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
    assertNull(actualDeepCopyResult.getLabel());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getType());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getDeviceData());
    assertNull(actualDeepCopyResult.getCustomerId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getDeviceProfileId());
    assertNull(actualDeepCopyResult.getFirmwareId());
    assertNull(actualDeepCopyResult.getSoftwareId());
    assertNull(actualDeepCopyResult.getTenantId());
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
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
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
   * Test {@link DeviceImportService#deepCopy(Device)} with {@code Device}.
   * <ul>
   *   <li>When {@link Device#Device()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#deepCopy(Device)}
   */
  @Test
  @DisplayName("Test deepCopy(Device) with 'Device'; when Device(); then AdditionalInfo return NullNode")
  void testDeepCopyWithDevice_whenDevice_thenAdditionalInfoReturnNullNode() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceImportService deviceImportService = new DeviceImportService(deviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()));

    // Act
    Device actualDeepCopyResult = deviceImportService.deepCopy(new Device());

    // Assert
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
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
    assertNull(actualDeepCopyResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDeepCopyResult.getVersion());
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
    assertNull(actualDeepCopyResult.getLabel());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getType());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getDeviceData());
    assertNull(actualDeepCopyResult.getCustomerId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getDeviceProfileId());
    assertNull(actualDeepCopyResult.getFirmwareId());
    assertNull(actualDeepCopyResult.getSoftwareId());
    assertNull(actualDeepCopyResult.getTenantId());
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
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
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
   * Test {@link DeviceImportService#cleanupForComparison(Device)} with
   * {@code Device}.
   * <ul>
   *   <li>Then calls {@link BaseData#setCreatedTime(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#cleanupForComparison(Device)}
   */
  @Test
  @DisplayName("Test cleanupForComparison(Device) with 'Device'; then calls setCreatedTime(long)")
  void testCleanupForComparisonWithDevice_thenCallsSetCreatedTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceImportService deviceImportService = new DeviceImportService(deviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()));
    Device e = mock(Device.class);
    when(e.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(e).setCreatedTime(anyLong());
    doNothing().when(e).setTenantId(Mockito.<TenantId>any());
    doNothing().when(e).setVersion(Mockito.<Long>any());

    // Act
    deviceImportService.cleanupForComparison(e);

    // Assert that nothing has changed
    verify(e).setCreatedTime(eq(0L));
    verify(e, atLeast(1)).getCustomerId();
    verify(e).setTenantId(isNull());
    verify(e).setVersion(isNull());
  }

  /**
   * Test {@link DeviceImportService#getEntityType()}.
   * <p>
   * Method under test: {@link DeviceImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();

    // Act and Assert
    assertEquals(EntityType.DEVICE,
        (new DeviceImportService(deviceService,
            new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator())))
            .getEntityType());
  }
}
