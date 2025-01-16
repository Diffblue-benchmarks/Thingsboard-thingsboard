package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.data.CoapDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.DefaultDeviceConfiguration;
import org.thingsboard.server.common.data.device.data.DefaultDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.DeviceConfiguration;
import org.thingsboard.server.common.data.device.data.DeviceData;
import org.thingsboard.server.common.data.device.data.DeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceDiffblueTest {
  /**
   * Test {@link Device#getExternalId()}.
   * <p>
   * Method under test: {@link Device#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new Device()).getExternalId());
  }

  /**
   * Test {@link Device#Device(Device)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); given array of byte with 'A' and minus one")
  void testNewDevice_givenArrayOfByteWithAAndMinusOne() throws IOException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualDevice = new Device(device);

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
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
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
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
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
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
    assertEquals(0L, actualDevice.getCreatedTime());
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
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link Device#Device(Device)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@link Byte#MAX_VALUE} and
   * {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); given array of byte with MAX_VALUE and 'X'")
  void testNewDevice_givenArrayOfByteWithMax_valueAndX() throws IOException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualDevice = new Device(device);

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
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
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
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
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
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
    assertEquals(0L, actualDevice.getCreatedTime());
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
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link Device#Device(Device)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); given array of byte with zero and 'X'")
  void testNewDevice_givenArrayOfByteWithZeroAndX() throws IOException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualDevice = new Device(device);

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
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
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
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
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
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
    assertEquals(0L, actualDevice.getCreatedTime());
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
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link Device#Device(Device)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); given 'AXAXAXAX' Bytes is 'UTF-8'")
  void testNewDevice_givenAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Device actualDevice = new Device(device);

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
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
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
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
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
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
    assertEquals(0L, actualDevice.getCreatedTime());
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
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link Device#Device(Device)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   *   <li>When {@link Device#Device()} DeviceDataBytes is empty array of
   * {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); given empty array of byte; when Device() DeviceDataBytes is empty array of byte")
  void testNewDevice_givenEmptyArrayOfByte_whenDeviceDeviceDataBytesIsEmptyArrayOfByte() throws IOException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{});

    // Act
    Device actualDevice = new Device(device);

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
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
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
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
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
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
    assertEquals(0L, actualDevice.getCreatedTime());
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
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link Device#Device(Device)}.
   * <ul>
   *   <li>When {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); when Device()")
  void testNewDevice_whenDevice() throws IOException {
    // Arrange and Act
    Device actualDevice = new Device(new Device());

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
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
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
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
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
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
    assertEquals(0L, actualDevice.getCreatedTime());
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
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link Device#Device(Device)}.
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is
   * {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); when Device(Device) with device is Device()")
  void testNewDevice_whenDeviceWithDeviceIsDevice() throws IOException {
    // Arrange and Act
    Device actualDevice = new Device(new Device(new Device()));

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
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
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
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
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
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
    assertEquals(0L, actualDevice.getCreatedTime());
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
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link Device#Device(Device)}.
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is
   * {@link Device#Device(Device)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#Device(Device)}
   */
  @Test
  @DisplayName("Test new Device(Device); when Device(Device) with device is Device(Device)")
  void testNewDevice_whenDeviceWithDeviceIsDevice2() throws IOException {
    // Arrange and Act
    Device actualDevice = new Device(new Device(new Device(new Device())));

    // Assert
    JsonNode additionalInfo = actualDevice.getAdditionalInfo();
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
    assertNull(actualDevice.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDevice.getVersion());
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
    assertNull(actualDevice.getLabel());
    assertNull(actualDevice.getName());
    assertNull(actualDevice.getType());
    assertNull(actualDevice.getUuidId());
    assertNull(actualDevice.getDeviceData());
    assertNull(actualDevice.getCustomerId());
    assertNull(actualDevice.getExternalId());
    assertNull(actualDevice.getId());
    assertNull(actualDevice.getDeviceProfileId());
    assertNull(actualDevice.getFirmwareId());
    assertNull(actualDevice.getSoftwareId());
    assertNull(actualDevice.getTenantId());
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
    assertEquals(0L, actualDevice.getCreatedTime());
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
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); given array of byte with 'A' and minus one")
  void testUpdateDevice_givenArrayOfByteWithAAndMinusOne() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualUpdateDeviceResult = device.updateDevice(device2);

    // Assert
    assertNull(actualUpdateDeviceResult.getDeviceDataBytes());
    assertNull(actualUpdateDeviceResult.getAdditionalInfo());
    assertNull(actualUpdateDeviceResult.getVersion());
    assertNull(actualUpdateDeviceResult.getLabel());
    assertNull(actualUpdateDeviceResult.getName());
    assertNull(actualUpdateDeviceResult.getType());
    assertNull(actualUpdateDeviceResult.getUuidId());
    assertNull(actualUpdateDeviceResult.getDeviceData());
    assertNull(actualUpdateDeviceResult.getCustomerId());
    assertNull(actualUpdateDeviceResult.getExternalId());
    assertNull(actualUpdateDeviceResult.getId());
    assertNull(actualUpdateDeviceResult.getDeviceProfileId());
    assertNull(actualUpdateDeviceResult.getFirmwareId());
    assertNull(actualUpdateDeviceResult.getSoftwareId());
    assertNull(actualUpdateDeviceResult.getTenantId());
    assertEquals(0L, actualUpdateDeviceResult.getCreatedTime());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@link Byte#MAX_VALUE} and
   * {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); given array of byte with MAX_VALUE and 'X'")
  void testUpdateDevice_givenArrayOfByteWithMax_valueAndX() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualUpdateDeviceResult = device.updateDevice(device2);

    // Assert
    assertNull(actualUpdateDeviceResult.getDeviceDataBytes());
    assertNull(actualUpdateDeviceResult.getAdditionalInfo());
    assertNull(actualUpdateDeviceResult.getVersion());
    assertNull(actualUpdateDeviceResult.getLabel());
    assertNull(actualUpdateDeviceResult.getName());
    assertNull(actualUpdateDeviceResult.getType());
    assertNull(actualUpdateDeviceResult.getUuidId());
    assertNull(actualUpdateDeviceResult.getDeviceData());
    assertNull(actualUpdateDeviceResult.getCustomerId());
    assertNull(actualUpdateDeviceResult.getExternalId());
    assertNull(actualUpdateDeviceResult.getId());
    assertNull(actualUpdateDeviceResult.getDeviceProfileId());
    assertNull(actualUpdateDeviceResult.getFirmwareId());
    assertNull(actualUpdateDeviceResult.getSoftwareId());
    assertNull(actualUpdateDeviceResult.getTenantId());
    assertEquals(0L, actualUpdateDeviceResult.getCreatedTime());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); given array of byte with zero and 'X'")
  void testUpdateDevice_givenArrayOfByteWithZeroAndX() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Device actualUpdateDeviceResult = device.updateDevice(device2);

    // Assert
    assertNull(actualUpdateDeviceResult.getDeviceDataBytes());
    assertNull(actualUpdateDeviceResult.getAdditionalInfo());
    assertNull(actualUpdateDeviceResult.getVersion());
    assertNull(actualUpdateDeviceResult.getLabel());
    assertNull(actualUpdateDeviceResult.getName());
    assertNull(actualUpdateDeviceResult.getType());
    assertNull(actualUpdateDeviceResult.getUuidId());
    assertNull(actualUpdateDeviceResult.getDeviceData());
    assertNull(actualUpdateDeviceResult.getCustomerId());
    assertNull(actualUpdateDeviceResult.getExternalId());
    assertNull(actualUpdateDeviceResult.getId());
    assertNull(actualUpdateDeviceResult.getDeviceProfileId());
    assertNull(actualUpdateDeviceResult.getFirmwareId());
    assertNull(actualUpdateDeviceResult.getSoftwareId());
    assertNull(actualUpdateDeviceResult.getTenantId());
    assertEquals(0L, actualUpdateDeviceResult.getCreatedTime());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); given 'AXAXAXAX' Bytes is 'UTF-8'")
  void testUpdateDevice_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Device actualUpdateDeviceResult = device.updateDevice(device2);

    // Assert
    assertNull(actualUpdateDeviceResult.getDeviceDataBytes());
    assertNull(actualUpdateDeviceResult.getAdditionalInfo());
    assertNull(actualUpdateDeviceResult.getVersion());
    assertNull(actualUpdateDeviceResult.getLabel());
    assertNull(actualUpdateDeviceResult.getName());
    assertNull(actualUpdateDeviceResult.getType());
    assertNull(actualUpdateDeviceResult.getUuidId());
    assertNull(actualUpdateDeviceResult.getDeviceData());
    assertNull(actualUpdateDeviceResult.getCustomerId());
    assertNull(actualUpdateDeviceResult.getExternalId());
    assertNull(actualUpdateDeviceResult.getId());
    assertNull(actualUpdateDeviceResult.getDeviceProfileId());
    assertNull(actualUpdateDeviceResult.getFirmwareId());
    assertNull(actualUpdateDeviceResult.getSoftwareId());
    assertNull(actualUpdateDeviceResult.getTenantId());
    assertEquals(0L, actualUpdateDeviceResult.getCreatedTime());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); given empty array of byte")
  void testUpdateDevice_givenEmptyArrayOfByte() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setDeviceDataBytes(new byte[]{});

    // Act
    Device actualUpdateDeviceResult = device.updateDevice(device2);

    // Assert
    assertNull(actualUpdateDeviceResult.getDeviceDataBytes());
    assertNull(actualUpdateDeviceResult.getAdditionalInfo());
    assertNull(actualUpdateDeviceResult.getVersion());
    assertNull(actualUpdateDeviceResult.getLabel());
    assertNull(actualUpdateDeviceResult.getName());
    assertNull(actualUpdateDeviceResult.getType());
    assertNull(actualUpdateDeviceResult.getUuidId());
    assertNull(actualUpdateDeviceResult.getDeviceData());
    assertNull(actualUpdateDeviceResult.getCustomerId());
    assertNull(actualUpdateDeviceResult.getExternalId());
    assertNull(actualUpdateDeviceResult.getId());
    assertNull(actualUpdateDeviceResult.getDeviceProfileId());
    assertNull(actualUpdateDeviceResult.getFirmwareId());
    assertNull(actualUpdateDeviceResult.getSoftwareId());
    assertNull(actualUpdateDeviceResult.getTenantId());
    assertEquals(0L, actualUpdateDeviceResult.getCreatedTime());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is
   * {@link Device#Device()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); when Device(Device) with device is Device(); then AdditionalInfo return NullNode")
  void testUpdateDevice_whenDeviceWithDeviceIsDevice_thenAdditionalInfoReturnNullNode() throws IOException {
    // Arrange
    Device device = new Device();

    // Act and Assert
    JsonNode additionalInfo = device.updateDevice(new Device(new Device())).getAdditionalInfo();
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
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
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
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is
   * {@link Device#Device(Device)}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); when Device(Device) with device is Device(Device); then AdditionalInfo return NullNode")
  void testUpdateDevice_whenDeviceWithDeviceIsDevice_thenAdditionalInfoReturnNullNode2() throws IOException {
    // Arrange
    Device device = new Device();

    // Act and Assert
    JsonNode additionalInfo = device.updateDevice(new Device(new Device(new Device()))).getAdditionalInfo();
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
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
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
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link Device#updateDevice(Device)}.
   * <ul>
   *   <li>When {@link Device#Device()}.</li>
   *   <li>Then return {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#updateDevice(Device)}
   */
  @Test
  @DisplayName("Test updateDevice(Device); when Device(); then return Device()")
  void testUpdateDevice_whenDevice_thenReturnDevice() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertSame(device, device.updateDevice(new Device()));
  }

  /**
   * Test {@link Device#getId()}.
   * <p>
   * Method under test: {@link Device#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new Device()).getId());
  }

  /**
   * Test {@link Device#getCreatedTime()}.
   * <p>
   * Method under test: {@link Device#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Device()).getCreatedTime());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   * <p>
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData()")
  void testGetDeviceData() {
    // Arrange
    Device device = new Device(new Device());
    device.setDeviceDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   * <ul>
   *   <li>Given {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData(); given Device()")
  void testGetDeviceData_givenDevice() {
    // Arrange, Act and Assert
    assertNull((new Device()).getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is array of {@code byte}
   * with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData(); given Device() DeviceDataBytes is array of byte with 'A' and minus one")
  void testGetDeviceData_givenDeviceDeviceDataBytesIsArrayOfByteWithAAndMinusOne() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is array of {@code byte}
   * with {@link Byte#MAX_VALUE} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData(); given Device() DeviceDataBytes is array of byte with MAX_VALUE and 'X'")
  void testGetDeviceData_givenDeviceDeviceDataBytesIsArrayOfByteWithMax_valueAndX() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is array of {@code byte}
   * with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData(); given Device() DeviceDataBytes is array of byte with zero and 'X'")
  void testGetDeviceData_givenDeviceDeviceDataBytesIsArrayOfByteWithZeroAndX() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is array of {@code byte}
   * with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData(); given Device() DeviceDataBytes is array of byte with zero and zero")
  void testGetDeviceData_givenDeviceDeviceDataBytesIsArrayOfByteWithZeroAndZero() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is array of {@code byte}
   * with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData(); given Device() DeviceDataBytes is array of byte with zero and zero")
  void testGetDeviceData_givenDeviceDeviceDataBytesIsArrayOfByteWithZeroAndZero2() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is {@code AXAXAXAX} Bytes
   * is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData(); given Device() DeviceDataBytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  void testGetDeviceData_givenDeviceDeviceDataBytesIsAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is empty array of
   * {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData(); given Device() DeviceDataBytes is empty array of byte")
  void testGetDeviceData_givenDeviceDeviceDataBytesIsEmptyArrayOfByte() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#getDeviceData()}.
   * <ul>
   *   <li>Given {@link Device#Device(Device)} with device is
   * {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#getDeviceData()}
   */
  @Test
  @DisplayName("Test getDeviceData(); given Device(Device) with device is Device()")
  void testGetDeviceData_givenDeviceWithDeviceIsDevice() {
    // Arrange
    Device device = new Device(new Device(new Device()));
    device.setDeviceDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   * <ul>
   *   <li>Given {@link CoapDeviceTransportConfiguration} (default constructor)
   * {@code null} is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); given CoapDeviceTransportConfiguration (default constructor) 'null' is 'Value'")
  void testSetDeviceData_givenCoapDeviceTransportConfigurationNullIsValue() {
    // Arrange
    Device device = new Device();

    CoapDeviceTransportConfiguration transportConfiguration = new CoapDeviceTransportConfiguration();
    transportConfiguration.put(null, "Value");

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(transportConfiguration);

    // Act
    device.setDeviceData(data);

    // Assert
    assertNull(device.getDeviceDataBytes());
    assertSame(data, device.getDeviceData());
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   * <ul>
   *   <li>Given {@link DeviceConfiguration}.</li>
   *   <li>Then {@link Device#Device()} DeviceData is {@link DeviceData} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); given DeviceConfiguration; then Device() DeviceData is DeviceData (default constructor)")
  void testSetDeviceData_givenDeviceConfiguration_thenDeviceDeviceDataIsDeviceData() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(mock(DeviceConfiguration.class));
    data.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act
    device.setDeviceData(data);

    // Assert
    assertNull(device.getDeviceDataBytes());
    assertSame(data, device.getDeviceData());
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   * <ul>
   *   <li>Given {@link DeviceInfo#DeviceInfo()}.</li>
   *   <li>Then {@link DeviceInfo#DeviceInfo()} DeviceDataBytes is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); given DeviceInfo(); then DeviceInfo() DeviceDataBytes is 'null'")
  void testSetDeviceData_givenDeviceInfo_thenDeviceInfoDeviceDataBytesIsNull() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();

    DeviceData data = new DeviceData();
    data.setConfiguration(mock(DeviceConfiguration.class));
    data.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act
    deviceInfo.setDeviceData(data);

    // Assert
    assertNull(deviceInfo.getDeviceDataBytes());
    assertSame(data, deviceInfo.getDeviceData());
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   * <ul>
   *   <li>Given {@link Device#Device()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Device#Device()} DeviceData is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); given Device(); when 'null'; then Device() DeviceData is 'null'")
  void testSetDeviceData_givenDevice_whenNull_thenDeviceDeviceDataIsNull() {
    // Arrange
    Device device = new Device();

    // Act
    device.setDeviceData(null);

    // Assert
    assertNull(device.getDeviceDataBytes());
    assertNull(device.getDeviceData());
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then array length is fifty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); given 'null'; then array length is fifty-two")
  void testSetDeviceData_givenNull_thenArrayLengthIsFiftyTwo() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(null);
    data.setTransportConfiguration(null);

    // Act
    device.setDeviceData(data);

    // Assert
    byte[] deviceDataBytes = device.getDeviceDataBytes();
    assertEquals(52, deviceDataBytes.length);
    assertEquals(',', deviceDataBytes[21]);
    assertEquals(':', deviceDataBytes[46]);
    assertEquals('C', deviceDataBytes[Integer.SIZE]);
    assertEquals('"', deviceDataBytes[22]);
    assertEquals('"', deviceDataBytes[45]);
    assertEquals('a', deviceDataBytes[40]);
    assertEquals('f', deviceDataBytes[35]);
    assertEquals('g', deviceDataBytes[37]);
    assertEquals('i', deviceDataBytes[36]);
    assertEquals('i', deviceDataBytes[42]);
    assertEquals('l', deviceDataBytes[19]);
    assertEquals('l', deviceDataBytes[20]);
    assertEquals('l', deviceDataBytes[49]);
    assertEquals('l', deviceDataBytes[50]);
    assertEquals('n', deviceDataBytes[17]);
    assertEquals('n', deviceDataBytes[34]);
    assertEquals('n', deviceDataBytes[44]);
    assertEquals('n', deviceDataBytes[47]);
    assertEquals('o', deviceDataBytes[29]);
    assertEquals('o', deviceDataBytes[33]);
    assertEquals('o', deviceDataBytes[43]);
    assertEquals('p', deviceDataBytes[28]);
    assertEquals('r', deviceDataBytes[24]);
    assertEquals('r', deviceDataBytes[30]);
    assertEquals('r', deviceDataBytes[39]);
    assertEquals('s', deviceDataBytes[27]);
    assertEquals('t', deviceDataBytes[23]);
    assertEquals('t', deviceDataBytes[31]);
    assertEquals('t', deviceDataBytes[41]);
    assertEquals('u', deviceDataBytes[18]);
    assertEquals('u', deviceDataBytes[38]);
    assertEquals('u', deviceDataBytes[48]);
    assertEquals('}', deviceDataBytes[51]);
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   * <ul>
   *   <li>Then array length is eighty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); then array length is eighty")
  void testSetDeviceData_thenArrayLengthIsEighty() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(new DefaultDeviceTransportConfiguration());

    // Act
    device.setDeviceData(data);

    // Assert
    byte[] deviceDataBytes = device.getDeviceDataBytes();
    assertEquals(80, deviceDataBytes.length);
    assertEquals(':', deviceDataBytes[60]);
    assertEquals(':', deviceDataBytes[68]);
    assertEquals('A', deviceDataBytes[73]);
    assertEquals('D', deviceDataBytes[70]);
    assertEquals('E', deviceDataBytes[71]);
    assertEquals('F', deviceDataBytes[72]);
    assertEquals('L', deviceDataBytes[75]);
    assertEquals('T', deviceDataBytes[76]);
    assertEquals('U', deviceDataBytes[74]);
    assertEquals('"', deviceDataBytes[59]);
    assertEquals('"', deviceDataBytes[62]);
    assertEquals('"', deviceDataBytes[67]);
    assertEquals('"', deviceDataBytes[69]);
    assertEquals('"', deviceDataBytes[77]);
    assertEquals('e', deviceDataBytes[66]);
    assertEquals('i', deviceDataBytes[56]);
    assertEquals('n', deviceDataBytes[58]);
    assertEquals('o', deviceDataBytes[57]);
    assertEquals('p', deviceDataBytes[65]);
    assertEquals('t', deviceDataBytes[55]);
    assertEquals('t', deviceDataBytes[63]);
    assertEquals('y', deviceDataBytes[Double.SIZE]);
    assertEquals('{', deviceDataBytes[61]);
    assertEquals('}', deviceDataBytes[78]);
    assertEquals('}', deviceDataBytes[79]);
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   * <ul>
   *   <li>Then array length is one hundred sixty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); then array length is one hundred sixty-seven")
  void testSetDeviceData_thenArrayLengthIsOneHundredSixtySeven() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(new CoapDeviceTransportConfiguration());

    // Act
    device.setDeviceData(data);

    // Assert
    byte[] deviceDataBytes = device.getDeviceDataBytes();
    assertEquals(167, deviceDataBytes.length);
    assertEquals(':', deviceDataBytes[160]);
    assertEquals('W', deviceDataBytes[153]);
    assertEquals('"', deviceDataBytes[159]);
    assertEquals('a', deviceDataBytes[143]);
    assertEquals('d', deviceDataBytes[156]);
    assertEquals('i', deviceDataBytes[147]);
    assertEquals('i', deviceDataBytes[150]);
    assertEquals('i', deviceDataBytes[154]);
    assertEquals('l', deviceDataBytes[163]);
    assertEquals('l', deviceDataBytes[164]);
    assertEquals('m', deviceDataBytes[146]);
    assertEquals('n', deviceDataBytes[144]);
    assertEquals('n', deviceDataBytes[152]);
    assertEquals('n', deviceDataBytes[155]);
    assertEquals('n', deviceDataBytes[161]);
    assertEquals('o', deviceDataBytes[151]);
    assertEquals('o', deviceDataBytes[157]);
    assertEquals('r', deviceDataBytes[142]);
    assertEquals('s', deviceDataBytes[145]);
    assertEquals('s', deviceDataBytes[148]);
    assertEquals('s', deviceDataBytes[149]);
    assertEquals('u', deviceDataBytes[162]);
    assertEquals('w', deviceDataBytes[158]);
    assertEquals('}', deviceDataBytes[165]);
    assertEquals('}', deviceDataBytes[166]);
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   * <ul>
   *   <li>Then array length is three hundred thirty-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); then array length is three hundred thirty-three")
  void testSetDeviceData_thenArrayLengthIsThreeHundredThirtyThree() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(new SnmpDeviceTransportConfiguration());

    // Act
    device.setDeviceData(data);

    // Assert
    byte[] deviceDataBytes = device.getDeviceDataBytes();
    assertEquals(333, deviceDataBytes.length);
    assertEquals(',', deviceDataBytes[315]);
    assertEquals(':', deviceDataBytes[310]);
    assertEquals(':', deviceDataBytes[326]);
    assertEquals('I', deviceDataBytes[323]);
    assertEquals('"', deviceDataBytes[309]);
    assertEquals('"', deviceDataBytes[316]);
    assertEquals('"', deviceDataBytes[325]);
    assertEquals('d', deviceDataBytes[324]);
    assertEquals('e', deviceDataBytes[308]);
    assertEquals('e', deviceDataBytes[317]);
    assertEquals('e', deviceDataBytes[322]);
    assertEquals('g', deviceDataBytes[319]);
    assertEquals('i', deviceDataBytes[320]);
    assertEquals('l', deviceDataBytes[313]);
    assertEquals('l', deviceDataBytes[314]);
    assertEquals('l', deviceDataBytes[329]);
    assertEquals('l', deviceDataBytes[330]);
    assertEquals('n', deviceDataBytes[311]);
    assertEquals('n', deviceDataBytes[318]);
    assertEquals('n', deviceDataBytes[321]);
    assertEquals('n', deviceDataBytes[327]);
    assertEquals('u', deviceDataBytes[312]);
    assertEquals('u', deviceDataBytes[328]);
    assertEquals('}', deviceDataBytes[331]);
    assertEquals('}', deviceDataBytes[332]);
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   * <ul>
   *   <li>Then array length is two hundred fifty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); then array length is two hundred fifty-seven")
  void testSetDeviceData_thenArrayLengthIsTwoHundredFiftySeven() {
    // Arrange
    Device device = new Device();

    CoapDeviceTransportConfiguration transportConfiguration = new CoapDeviceTransportConfiguration();
    transportConfiguration.put("org.thingsboard.server.common.data.device.data.CoapDeviceTransportConfiguration",
        "Value");

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(transportConfiguration);

    // Act
    device.setDeviceData(data);

    // Assert
    byte[] deviceDataBytes = device.getDeviceDataBytes();
    assertEquals(257, deviceDataBytes.length);
    assertEquals(':', deviceDataBytes[247]);
    assertEquals('C', deviceDataBytes[233]);
    assertEquals('V', deviceDataBytes[249]);
    assertEquals('"', deviceDataBytes[246]);
    assertEquals('"', deviceDataBytes[248]);
    assertEquals('"', deviceDataBytes[254]);
    assertEquals('a', deviceDataBytes[241]);
    assertEquals('a', deviceDataBytes[250]);
    assertEquals('e', deviceDataBytes[253]);
    assertEquals('f', deviceDataBytes[236]);
    assertEquals('g', deviceDataBytes[238]);
    assertEquals('i', deviceDataBytes[237]);
    assertEquals('i', deviceDataBytes[243]);
    assertEquals('l', deviceDataBytes[251]);
    assertEquals('n', deviceDataBytes[235]);
    assertEquals('n', deviceDataBytes[245]);
    assertEquals('o', deviceDataBytes[234]);
    assertEquals('o', deviceDataBytes[244]);
    assertEquals('r', deviceDataBytes[240]);
    assertEquals('t', deviceDataBytes[232]);
    assertEquals('t', deviceDataBytes[242]);
    assertEquals('u', deviceDataBytes[239]);
    assertEquals('u', deviceDataBytes[252]);
    assertEquals('}', deviceDataBytes[255]);
    assertEquals('}', deviceDataBytes[256]);
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   * <ul>
   *   <li>Then {@link Device#Device()} DeviceData is {@link DeviceData} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); then Device() DeviceData is DeviceData (default constructor)")
  void testSetDeviceData_thenDeviceDeviceDataIsDeviceData() {
    // Arrange
    Device device = new Device();

    DeviceData data = new DeviceData();
    data.setConfiguration(new DefaultDeviceConfiguration());
    data.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act
    device.setDeviceData(data);

    // Assert
    assertNull(device.getDeviceDataBytes());
    assertSame(data, device.getDeviceData());
  }

  /**
   * Test {@link Device#setDeviceData(DeviceData)}.
   * <ul>
   *   <li>Then {@link Device#Device(Device)} with device is {@link Device#Device()}
   * DeviceDataBytes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#setDeviceData(DeviceData)}
   */
  @Test
  @DisplayName("Test setDeviceData(DeviceData); then Device(Device) with device is Device() DeviceDataBytes is 'null'")
  void testSetDeviceData_thenDeviceWithDeviceIsDeviceDeviceDataBytesIsNull() {
    // Arrange
    Device device = new Device(new Device());

    DeviceData data = new DeviceData();
    data.setConfiguration(mock(DeviceConfiguration.class));
    data.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act
    device.setDeviceData(data);

    // Assert
    assertNull(device.getDeviceDataBytes());
    assertSame(data, device.getDeviceData());
  }

  /**
   * Test {@link Device#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Device#Device()} DeviceDataBytes is {@code AXAXAXAX} Bytes
   * is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Device() DeviceDataBytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  void testGetAdditionalInfo_givenDeviceDeviceDataBytesIsAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    JsonNode actualAdditionalInfo = (new Device(device)).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Device#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Device#Device(Device)} with device is
   * {@link Device#Device()}.</li>
   *   <li>Then return {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Device(Device) with device is Device(); then return instance")
  void testGetAdditionalInfo_givenDeviceWithDeviceIsDevice_thenReturnInstance() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Device(new Device())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Device#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Device#Device(Device)} with device is
   * {@link Device#Device(Device)}.</li>
   *   <li>Then return {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Device(Device) with device is Device(Device); then return instance")
  void testGetAdditionalInfo_givenDeviceWithDeviceIsDevice_thenReturnInstance2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Device(new Device(new Device()))).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Device#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Device#Device()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Device(); then return 'null'")
  void testGetAdditionalInfo_givenDevice_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Device()).getAdditionalInfo());
  }

  /**
   * Test {@link Device#equals(Object)}, and {@link Device#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Device#equals(Object)}
   *   <li>{@link Device#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Device device = new Device();
    Device device2 = new Device();

    // Act and Assert
    assertEquals(device, device2);
    int expectedHashCodeResult = device.hashCode();
    assertEquals(expectedHashCodeResult, device2.hashCode());
  }

  /**
   * Test {@link Device#equals(Object)}, and {@link Device#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Device#equals(Object)}
   *   <li>{@link Device#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertEquals(device, device);
    int expectedHashCodeResult = device.hashCode();
    assertEquals(expectedHashCodeResult, device.hashCode());
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();

    // Act and Assert
    assertNotEquals(deviceInfo, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Device device = new Device(new Device());

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertNotEquals(device, new DeviceInfo());
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange, Act and Assert
    assertNotEquals(new Device(), mock(AdminSettings.class));
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Device device = new Device();
    device.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Device device = new Device();
    device.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Device device = new Device();
    device.setName("Name");

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Device device = new Device();
    device.setType("Type");

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Device device = new Device();
    device.setLabel("Label");

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Device device = new Device();
    device.setVersion(1L);

    // Act and Assert
    assertNotEquals(device, new Device());
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setName("Name");

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setType("Type");

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setLabel("Label");

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    Device device = new Device();

    Device device2 = new Device();
    device2.setVersion(1L);

    // Act and Assert
    assertNotEquals(device, device2);
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Device(), null);
  }

  /**
   * Test {@link Device#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Device#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Device(), "Different type to Device");
  }
}
