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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;

class UserSettingsDiffblueTest {
  /**
   * Method under test: {@link UserSettings#getSettings()}
   */
  @Test
  void testGetSettings() {
    // Arrange, Act and Assert
    assertNull((new UserSettings()).getSettings());
  }

  /**
   * Method under test: {@link UserSettings#getSettings()}
   */
  @Test
  void testGetSettings2() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(userSettings.getSettings());
  }

  /**
   * Method under test: {@link UserSettings#getSettings()}
   */
  @Test
  void testGetSettings3() throws IOException {
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
   * Method under test: {@link UserSettings#getSettings()}
   */
  @Test
  void testGetSettings4() throws IOException {
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
   * Method under test: {@link UserSettings#setSettings(JsonNode)}
   */
  @Test
  void testSetSettings() throws UnsupportedEncodingException {
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
   * Method under test: {@link UserSettings#setSettings(JsonNode)}
   */
  @Test
  void testSetSettings2() throws UnsupportedEncodingException {
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
   * Method under test: {@link UserSettings#setSettings(JsonNode)}
   */
  @Test
  void testSetSettings3() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();

    ArrayNode settings = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    settings.addObject();
    settings.addObject();

    // Act
    userSettings.setSettings(settings);

    // Assert
    assertSame(settings, userSettings.getSettings());
    byte[] expectedSettingsBytes = "[{},{}]".getBytes("UTF-8");
    assertArrayEquals(expectedSettingsBytes, userSettings.getSettingsBytes());
  }

  /**
   * Method under test: {@link UserSettings#equals(Object)}
   */
  @Test
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
