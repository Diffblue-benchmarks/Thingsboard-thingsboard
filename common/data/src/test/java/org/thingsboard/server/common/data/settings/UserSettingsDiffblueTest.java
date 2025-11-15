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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserSettingsDiffblueTest {
  /**
   * Test {@link UserSettings#getSettings()}.
   * <ul>
   *   <li>Given {@link UserSettings} (default constructor) SettingsBytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettings#getSettings()}
   */
  @Test
  @DisplayName("Test getSettings(); given UserSettings (default constructor) SettingsBytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode UserSettings.getSettings()"})
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
   *   <li>Given {@link UserSettings} (default constructor) Type is {@code GENERAL}.</li>
   *   <li>Then return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettings#getSettings()}
   */
  @Test
  @DisplayName("Test getSettings(); given UserSettings (default constructor) Type is 'GENERAL'; then return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode UserSettings.getSettings()"})
  void testGetSettings_givenUserSettingsTypeIsGeneral_thenReturnMissingNode() {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setSettingsBytes(new byte[]{});

    // Act
    JsonNode actualSettings = userSettings.getSettings();

    // Assert
    assertTrue(actualSettings instanceof MissingNode);
    assertTrue(actualSettings.traverse() instanceof TreeTraversingParser);
    assertEquals("", actualSettings.toPrettyString());
    assertEquals(0, actualSettings.size());
    assertEquals(JsonNodeType.MISSING, actualSettings.getNodeType());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode UserSettings.getSettings()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode UserSettings.getSettings()"})
  void testGetSettings_thenReturnMissingNode() {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(new byte[]{});

    // Act
    JsonNode actualSettings = userSettings.getSettings();

    // Assert
    assertTrue(actualSettings instanceof MissingNode);
    assertTrue(actualSettings.traverse() instanceof TreeTraversingParser);
    assertEquals("", actualSettings.toPrettyString());
    assertEquals(0, actualSettings.size());
    assertEquals(JsonNodeType.MISSING, actualSettings.getNodeType());
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
  }

  /**
   * Test {@link UserSettings#setSettings(JsonNode)}.
   * <p>
   * Method under test: {@link UserSettings#setSettings(JsonNode)}
   */
  @Test
  @DisplayName("Test setSettings(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserSettings.setSettings(JsonNode)"})
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
   * <p>
   * Method under test: {@link UserSettings#setSettings(JsonNode)}
   */
  @Test
  @DisplayName("Test setSettings(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserSettings.setSettings(JsonNode)"})
  void testSetSettings2() throws UnsupportedEncodingException {
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
   * Test {@link UserSettings#setSettings(JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then {@link UserSettings} (default constructor) Settings is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettings#setSettings(JsonNode)}
   */
  @Test
  @DisplayName("Test setSettings(JsonNode); when Instance; then UserSettings (default constructor) Settings is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserSettings.setSettings(JsonNode)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserSettings.<init>()", "byte[] UserSettings.getSettingsBytes()",
      "UserSettingsType UserSettings.getType()",
      "org.thingsboard.server.common.data.id.UserId UserSettings.getUserId()",
      "void UserSettings.setSettingsBytes(byte[])", "void UserSettings.setType(UserSettingsType)",
      "void UserSettings.setUserId(org.thingsboard.server.common.data.id.UserId)", "String UserSettings.toString()"})
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    UserSettings actualUserSettings = new UserSettings();
    byte[] settingsBytes = "AXAXAXAX".getBytes("UTF-8");
    actualUserSettings.setSettingsBytes(settingsBytes);
    actualUserSettings.setType(UserSettingsType.GENERAL);
    String actualToStringResult = actualUserSettings.toString();
    byte[] actualSettingsBytes = actualUserSettings.getSettingsBytes();
    UserSettingsType actualType = actualUserSettings.getType();

    // Assert
    assertEquals("UserSettings(userId=null, type=GENERAL, settings=null)", actualToStringResult);
    assertNull(actualUserSettings.getUserId());
    assertEquals(UserSettingsType.GENERAL, actualType);
    assertSame(settingsBytes, actualSettingsBytes);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSettingsBytes);
  }
}
