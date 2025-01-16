package org.thingsboard.server.common.data.settings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;

class UserSettingsDiffblueTest {
  /**
   * Test {@link UserSettings#getSettings()}.
   * <ul>
   *   <li>Given {@link UserSettings} (default constructor) SettingsBytes is
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettings#getSettings()}
   */
  @Test
  @DisplayName("Test getSettings(); given UserSettings (default constructor) SettingsBytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  void testGetSettings_givenUserSettingsSettingsBytesIsAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(userSettings.getSettings());
  }

  /**
   * Test {@link UserSettings#getSettings()}.
   * <ul>
   *   <li>Given {@link UserSettings} (default constructor) Type is
   * {@code GENERAL}.</li>
   *   <li>Then return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettings#getSettings()}
   */
  @Test
  @DisplayName("Test getSettings(); given UserSettings (default constructor) Type is 'GENERAL'; then return MissingNode")
  void testGetSettings_givenUserSettingsTypeIsGeneral_thenReturnMissingNode() throws IOException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setSettingsBytes(new byte[]{});

    // Act
    JsonNode actualSettings = userSettings.getSettings();

    // Assert
    assertTrue(actualSettings instanceof MissingNode);
    JsonParser traverseResult = actualSettings.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", actualSettings.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertEquals(0, actualSettings.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.MISSING, actualSettings.getNodeType());
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
    assertFalse(actualSettings.isArray());
    assertFalse(actualSettings.isBigDecimal());
    assertFalse(actualSettings.isBigInteger());
    assertFalse(actualSettings.isBinary());
    assertFalse(actualSettings.isBoolean());
    assertFalse(actualSettings.isContainerNode());
    assertFalse(actualSettings.isDouble());
    assertFalse(actualSettings.isFloat());
    assertFalse(actualSettings.isFloatingPointNumber());
    assertFalse(actualSettings.isInt());
    assertFalse(actualSettings.isIntegralNumber());
    assertFalse(actualSettings.isLong());
    assertFalse(actualSettings.isNull());
    assertFalse(actualSettings.isNumber());
    assertFalse(actualSettings.isObject());
    assertFalse(actualSettings.isPojo());
    assertFalse(actualSettings.isShort());
    assertFalse(actualSettings.isTextual());
    assertFalse(actualSettings.isValueNode());
    assertFalse(actualSettings.iterator().hasNext());
    assertTrue(actualSettings.isEmpty());
    assertTrue(actualSettings.isMissingNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link UserSettings#getSettings()}.
   * <ul>
   *   <li>Given {@link UserSettings} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettings#getSettings()}
   */
  @Test
  @DisplayName("Test getSettings(); given UserSettings (default constructor); then return 'null'")
  void testGetSettings_givenUserSettings_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new UserSettings()).getSettings());
  }

  /**
   * Test {@link UserSettings#getSettings()}.
   * <ul>
   *   <li>Then return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettings#getSettings()}
   */
  @Test
  @DisplayName("Test getSettings(); then return MissingNode")
  void testGetSettings_thenReturnMissingNode() throws IOException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(new byte[]{});

    // Act
    JsonNode actualSettings = userSettings.getSettings();

    // Assert
    assertTrue(actualSettings instanceof MissingNode);
    JsonParser traverseResult = actualSettings.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", actualSettings.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertEquals(0, actualSettings.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.MISSING, actualSettings.getNodeType());
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
    assertFalse(actualSettings.isArray());
    assertFalse(actualSettings.isBigDecimal());
    assertFalse(actualSettings.isBigInteger());
    assertFalse(actualSettings.isBinary());
    assertFalse(actualSettings.isBoolean());
    assertFalse(actualSettings.isContainerNode());
    assertFalse(actualSettings.isDouble());
    assertFalse(actualSettings.isFloat());
    assertFalse(actualSettings.isFloatingPointNumber());
    assertFalse(actualSettings.isInt());
    assertFalse(actualSettings.isIntegralNumber());
    assertFalse(actualSettings.isLong());
    assertFalse(actualSettings.isNull());
    assertFalse(actualSettings.isNumber());
    assertFalse(actualSettings.isObject());
    assertFalse(actualSettings.isPojo());
    assertFalse(actualSettings.isShort());
    assertFalse(actualSettings.isTextual());
    assertFalse(actualSettings.isValueNode());
    assertFalse(actualSettings.iterator().hasNext());
    assertTrue(actualSettings.isEmpty());
    assertTrue(actualSettings.isMissingNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link UserSettings#setSettings(JsonNode)}.
   * <p>
   * Method under test: {@link UserSettings#setSettings(JsonNode)}
   */
  @Test
  @DisplayName("Test setSettings(JsonNode)")
  void testSetSettings() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();

    ArrayNode settings = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    settings.addObject();

    // Act
    userSettings.setSettings(settings);

    // Assert
    assertSame(settings, userSettings.getSettings());
    byte[] expectedSettingsBytes = "[{}]".getBytes("UTF-8");
    assertArrayEquals(expectedSettingsBytes, userSettings.getSettingsBytes());
  }

  /**
   * Test {@link UserSettings#setSettings(JsonNode)}.
   * <ul>
   *   <li>Then array length is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettings#setSettings(JsonNode)}
   */
  @Test
  @DisplayName("Test setSettings(JsonNode); then array length is seven")
  void testSetSettings_thenArrayLengthIsSeven() {
    // Arrange
    UserSettings userSettings = new UserSettings();

    ArrayNode settings = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    settings.addObject();
    settings.addObject();

    // Act
    userSettings.setSettings(settings);

    // Assert
    byte[] settingsBytes = userSettings.getSettingsBytes();
    assertEquals(7, settingsBytes.length);
    assertEquals(',', settingsBytes[3]);
    assertEquals(']', settingsBytes[6]);
    assertEquals('{', settingsBytes[4]);
    assertEquals('}', settingsBytes[5]);
  }

  /**
   * Test {@link UserSettings#setSettings(JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then {@link UserSettings} (default constructor) Settings is
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettings#setSettings(JsonNode)}
   */
  @Test
  @DisplayName("Test setSettings(JsonNode); when Instance; then UserSettings (default constructor) Settings is Instance")
  void testSetSettings_whenInstance_thenUserSettingsSettingsIsInstance() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    MissingNode settings = MissingNode.getInstance();

    // Act
    userSettings.setSettings(settings);

    // Assert
    assertSame(settings, userSettings.getSettings());
    byte[] expectedSettingsBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedSettingsBytes, userSettings.getSettingsBytes());
  }

  /**
   * Test {@link UserSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(mock(UserId.class));

    UserSettings userSettings2 = new UserSettings();
    userSettings2.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings2.setType(UserSettingsType.GENERAL);
    userSettings2.setUserId(null);

    // Act and Assert
    assertNotEquals(userSettings, userSettings2);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UserSettings}
   *   <li>{@link UserSettings#setSettingsBytes(byte[])}
   *   <li>{@link UserSettings#setType(UserSettingsType)}
   *   <li>{@link UserSettings#toString()}
   *   <li>{@link UserSettings#getSettingsBytes()}
   *   <li>{@link UserSettings#getType()}
   *   <li>{@link UserSettings#getUserId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    UserSettings actualUserSettings = new UserSettings();
    byte[] settingsBytes = "AXAXAXAX".getBytes("UTF-8");
    actualUserSettings.setSettingsBytes(settingsBytes);
    actualUserSettings.setType(UserSettingsType.GENERAL);
    String actualToStringResult = actualUserSettings.toString();
    byte[] actualSettingsBytes = actualUserSettings.getSettingsBytes();
    UserSettingsType actualType = actualUserSettings.getType();
    actualUserSettings.getUserId();

    // Assert that nothing has changed
    assertEquals("UserSettings(userId=null, type=GENERAL, settings=null)", actualToStringResult);
    assertEquals(UserSettingsType.GENERAL, actualType);
    assertSame(settingsBytes, actualSettingsBytes);
  }
}
