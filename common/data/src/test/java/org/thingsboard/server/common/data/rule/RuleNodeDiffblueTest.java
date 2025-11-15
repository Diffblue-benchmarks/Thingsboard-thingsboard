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
package org.thingsboard.server.common.data.rule;

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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;

class RuleNodeDiffblueTest {
  /**
   * Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  void testGetConfiguration() {
    // Arrange, Act and Assert
    assertNull((new RuleNode()).getConfiguration());
  }

  /**
   * Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  void testGetConfiguration2() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode());

    // Act
    JsonNode actualConfiguration = ruleNode.getConfiguration();

    // Assert
    NullNode nullNode = ((NullNode) actualConfiguration).instance;
    assertSame(nullNode, ruleNode.getAdditionalInfo());
    assertSame(nullNode, actualConfiguration);
  }

  /**
   * Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  void testGetConfiguration3() throws UnsupportedEncodingException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(ruleNode.getConfiguration());
  }

  /**
   * Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  void testGetConfiguration4() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode(new RuleNode()));

    // Act
    JsonNode actualConfiguration = ruleNode.getConfiguration();

    // Assert
    NullNode nullNode = ((NullNode) actualConfiguration).instance;
    assertSame(nullNode, ruleNode.getAdditionalInfo());
    assertSame(nullNode, actualConfiguration);
  }

  /**
   * Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  void testGetConfiguration5() throws IOException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[]{});

    // Act
    JsonNode actualConfiguration = ruleNode.getConfiguration();

    // Assert
    assertTrue(actualConfiguration instanceof MissingNode);
    JsonParser traverseResult = actualConfiguration.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", actualConfiguration.toPrettyString());
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
    assertEquals(0, actualConfiguration.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.MISSING, actualConfiguration.getNodeType());
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
    assertFalse(actualConfiguration.isArray());
    assertFalse(actualConfiguration.isBigDecimal());
    assertFalse(actualConfiguration.isBigInteger());
    assertFalse(actualConfiguration.isBinary());
    assertFalse(actualConfiguration.isBoolean());
    assertFalse(actualConfiguration.isContainerNode());
    assertFalse(actualConfiguration.isDouble());
    assertFalse(actualConfiguration.isFloat());
    assertFalse(actualConfiguration.isFloatingPointNumber());
    assertFalse(actualConfiguration.isInt());
    assertFalse(actualConfiguration.isIntegralNumber());
    assertFalse(actualConfiguration.isLong());
    assertFalse(actualConfiguration.isNull());
    assertFalse(actualConfiguration.isNumber());
    assertFalse(actualConfiguration.isObject());
    assertFalse(actualConfiguration.isPojo());
    assertFalse(actualConfiguration.isShort());
    assertFalse(actualConfiguration.isTextual());
    assertFalse(actualConfiguration.isValueNode());
    assertFalse(actualConfiguration.iterator().hasNext());
    assertTrue(actualConfiguration.isEmpty());
    assertTrue(actualConfiguration.isMissingNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link RuleNode#setConfiguration(JsonNode)}
   */
  @Test
  void testSetConfiguration() throws UnsupportedEncodingException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    MissingNode data = MissingNode.getInstance();

    // Act
    ruleNode.setConfiguration(data);

    // Assert
    assertSame(data, ruleNode.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, ruleNode.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleNode#setConfiguration(JsonNode)}
   */
  @Test
  void testSetConfiguration2() throws UnsupportedEncodingException {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addObject();

    // Act
    ruleNode.setConfiguration(data);

    // Assert
    assertSame(data, ruleNode.getConfiguration());
    byte[] expectedConfigurationBytes = "[{}]".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, ruleNode.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleNode#setConfiguration(JsonNode)}
   */
  @Test
  void testSetConfiguration3() throws UnsupportedEncodingException {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addObject();
    data.addObject();

    // Act
    ruleNode.setConfiguration(data);

    // Assert
    assertSame(data, ruleNode.getConfiguration());
    byte[] expectedConfigurationBytes = "[{},{}]".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, ruleNode.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleNode#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new RuleNode()).getId());
  }

  /**
   * Method under test: {@link RuleNode#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new RuleNode()).getCreatedTime());
  }

  /**
   * Method under test: {@link RuleNode#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new RuleNode()).getAdditionalInfo());
  }

  /**
   * Method under test: {@link RuleNode#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo2() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode());

    // Act
    JsonNode actualAdditionalInfo = ruleNode.getAdditionalInfo();

    // Assert
    NullNode nullNode = ((NullNode) actualAdditionalInfo).instance;
    assertSame(nullNode, actualAdditionalInfo);
    assertSame(nullNode, ruleNode.getConfiguration());
  }

  /**
   * Method under test: {@link RuleNode#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo3() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode(new RuleNode()));

    // Act
    JsonNode actualAdditionalInfo = ruleNode.getAdditionalInfo();

    // Assert
    NullNode nullNode = ((NullNode) actualAdditionalInfo).instance;
    assertSame(nullNode, actualAdditionalInfo);
    assertSame(nullNode, ruleNode.getConfiguration());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNode#equals(Object)}
   *   <li>{@link RuleNode#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    RuleNode ruleNode2 = new RuleNode();

    // Act and Assert
    assertEquals(ruleNode, ruleNode2);
    int expectedHashCodeResult = ruleNode.hashCode();
    assertEquals(expectedHashCodeResult, ruleNode2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNode#equals(Object)}
   *   <li>{@link RuleNode#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    // Act and Assert
    assertEquals(ruleNode, ruleNode);
    int expectedHashCodeResult = ruleNode.hashCode();
    assertEquals(expectedHashCodeResult, ruleNode.hashCode());
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNodeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleNode(), mock(RuleChain.class));
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setType("Type");

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setName("Name");

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setSingletonMode(true);

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setQueueName("Queue Name");

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationVersion(1);

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setExternalId(new RuleNodeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setName("Name");

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setQueueName("Queue Name");

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setExternalId(new RuleNodeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleNode(), null);
  }

  /**
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleNode(), "Different type to RuleNode");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNode#RuleNode()}
   *   <li>{@link RuleNode#setConfigurationBytes(byte[])}
   *   <li>{@link RuleNode#setConfigurationVersion(int)}
   *   <li>{@link RuleNode#setDebugMode(boolean)}
   *   <li>{@link RuleNode#setExternalId(RuleNodeId)}
   *   <li>{@link RuleNode#setName(String)}
   *   <li>{@link RuleNode#setQueueName(String)}
   *   <li>{@link RuleNode#setRuleChainId(RuleChainId)}
   *   <li>{@link RuleNode#setSingletonMode(boolean)}
   *   <li>{@link RuleNode#setType(String)}
   *   <li>{@link RuleNode#toString()}
   *   <li>{@link RuleNode#getConfigurationBytes()}
   *   <li>{@link RuleNode#getConfigurationVersion()}
   *   <li>{@link RuleNode#getExternalId()}
   *   <li>{@link RuleNode#getName()}
   *   <li>{@link RuleNode#getQueueName()}
   *   <li>{@link RuleNode#getRuleChainId()}
   *   <li>{@link RuleNode#getType()}
   *   <li>{@link RuleNode#isDebugMode()}
   *   <li>{@link RuleNode#isSingletonMode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    RuleNode actualRuleNode = new RuleNode();
    byte[] configurationBytes = "AXAXAXAX".getBytes("UTF-8");
    actualRuleNode.setConfigurationBytes(configurationBytes);
    actualRuleNode.setConfigurationVersion(1);
    actualRuleNode.setDebugMode(true);
    RuleNodeId externalId = new RuleNodeId(EntityId.NULL_UUID);
    actualRuleNode.setExternalId(externalId);
    actualRuleNode.setName("Name");
    actualRuleNode.setQueueName("Queue Name");
    RuleChainId ruleChainId = new RuleChainId(EntityId.NULL_UUID);
    actualRuleNode.setRuleChainId(ruleChainId);
    actualRuleNode.setSingletonMode(true);
    actualRuleNode.setType("Type");
    String actualToStringResult = actualRuleNode.toString();
    byte[] actualConfigurationBytes = actualRuleNode.getConfigurationBytes();
    int actualConfigurationVersion = actualRuleNode.getConfigurationVersion();
    RuleNodeId actualExternalId = actualRuleNode.getExternalId();
    String actualName = actualRuleNode.getName();
    String actualQueueName = actualRuleNode.getQueueName();
    RuleChainId actualRuleChainId = actualRuleNode.getRuleChainId();
    String actualType = actualRuleNode.getType();
    boolean actualIsDebugModeResult = actualRuleNode.isDebugMode();
    boolean actualIsSingletonModeResult = actualRuleNode.isSingletonMode();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Queue Name", actualQueueName);
    assertEquals("RuleNode(ruleChainId=13814000-1dd2-11b2-8080-808080808080, type=Type, name=Name, debugMode=true,"
        + " singletonMode=true, queueName=Queue Name, configurationVersion=1, configuration=null, configurationBytes"
        + "=[65, 88, 65, 88, 65, 88, 65, 88], externalId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals("Type", actualType);
    assertEquals(0L, actualRuleNode.getCreatedTime());
    assertEquals(1, actualConfigurationVersion);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsSingletonModeResult);
    assertSame(ruleChainId, actualRuleChainId);
    assertSame(externalId, actualExternalId);
    assertSame(configurationBytes, actualConfigurationBytes);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNode#RuleNode(RuleNodeId)}
   *   <li>{@link RuleNode#setConfigurationBytes(byte[])}
   *   <li>{@link RuleNode#setConfigurationVersion(int)}
   *   <li>{@link RuleNode#setDebugMode(boolean)}
   *   <li>{@link RuleNode#setExternalId(RuleNodeId)}
   *   <li>{@link RuleNode#setName(String)}
   *   <li>{@link RuleNode#setQueueName(String)}
   *   <li>{@link RuleNode#setRuleChainId(RuleChainId)}
   *   <li>{@link RuleNode#setSingletonMode(boolean)}
   *   <li>{@link RuleNode#setType(String)}
   *   <li>{@link RuleNode#toString()}
   *   <li>{@link RuleNode#getConfigurationBytes()}
   *   <li>{@link RuleNode#getConfigurationVersion()}
   *   <li>{@link RuleNode#getExternalId()}
   *   <li>{@link RuleNode#getName()}
   *   <li>{@link RuleNode#getQueueName()}
   *   <li>{@link RuleNode#getRuleChainId()}
   *   <li>{@link RuleNode#getType()}
   *   <li>{@link RuleNode#isDebugMode()}
   *   <li>{@link RuleNode#isSingletonMode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() throws UnsupportedEncodingException {
    // Arrange
    RuleNodeId id = new RuleNodeId(EntityId.NULL_UUID);

    // Act
    RuleNode actualRuleNode = new RuleNode(id);
    byte[] configurationBytes = "AXAXAXAX".getBytes("UTF-8");
    actualRuleNode.setConfigurationBytes(configurationBytes);
    actualRuleNode.setConfigurationVersion(1);
    actualRuleNode.setDebugMode(true);
    RuleNodeId externalId = new RuleNodeId(EntityId.NULL_UUID);
    actualRuleNode.setExternalId(externalId);
    actualRuleNode.setName("Name");
    actualRuleNode.setQueueName("Queue Name");
    RuleChainId ruleChainId = new RuleChainId(EntityId.NULL_UUID);
    actualRuleNode.setRuleChainId(ruleChainId);
    actualRuleNode.setSingletonMode(true);
    actualRuleNode.setType("Type");
    String actualToStringResult = actualRuleNode.toString();
    byte[] actualConfigurationBytes = actualRuleNode.getConfigurationBytes();
    int actualConfigurationVersion = actualRuleNode.getConfigurationVersion();
    RuleNodeId actualExternalId = actualRuleNode.getExternalId();
    String actualName = actualRuleNode.getName();
    String actualQueueName = actualRuleNode.getQueueName();
    RuleChainId actualRuleChainId = actualRuleNode.getRuleChainId();
    String actualType = actualRuleNode.getType();
    boolean actualIsDebugModeResult = actualRuleNode.isDebugMode();
    boolean actualIsSingletonModeResult = actualRuleNode.isSingletonMode();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Queue Name", actualQueueName);
    assertEquals("RuleNode(ruleChainId=13814000-1dd2-11b2-8080-808080808080, type=Type, name=Name, debugMode=true,"
        + " singletonMode=true, queueName=Queue Name, configurationVersion=1, configuration=null, configurationBytes"
        + "=[65, 88, 65, 88, 65, 88, 65, 88], externalId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals("Type", actualType);
    assertEquals(0L, actualRuleNode.getCreatedTime());
    assertEquals(1, actualConfigurationVersion);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsSingletonModeResult);
    assertSame(ruleChainId, actualRuleChainId);
    assertSame(externalId, actualExternalId);
    assertSame(id, actualRuleNode.getId());
    assertSame(configurationBytes, actualConfigurationBytes);
  }

  /**
   * Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  void testNewRuleNode() throws IOException {
    // Arrange and Act
    RuleNode actualRuleNode = new RuleNode(new RuleNode());

    // Assert
    JsonNode additionalInfo = actualRuleNode.getAdditionalInfo();
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
    assertNull(actualRuleNode.getName());
    assertNull(actualRuleNode.getQueueName());
    assertNull(actualRuleNode.getType());
    assertNull(actualRuleNode.getUuidId());
    assertNull(actualRuleNode.getRuleChainId());
    assertNull(actualRuleNode.getExternalId());
    assertNull(actualRuleNode.getId());
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
    assertEquals(0, actualRuleNode.getConfigurationVersion());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualRuleNode.getCreatedTime());
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
    assertFalse(actualRuleNode.isDebugMode());
    assertFalse(actualRuleNode.isSingletonMode());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleNode.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualRuleNode.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  void testNewRuleNode2() throws IOException {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode());

    // Act
    RuleNode actualRuleNode = new RuleNode(ruleNode);

    // Assert
    JsonNode additionalInfo = actualRuleNode.getAdditionalInfo();
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
    assertNull(ruleNode.getName());
    assertNull(actualRuleNode.getName());
    assertNull(ruleNode.getQueueName());
    assertNull(actualRuleNode.getQueueName());
    assertNull(ruleNode.getType());
    assertNull(actualRuleNode.getType());
    assertNull(ruleNode.getUuidId());
    assertNull(actualRuleNode.getUuidId());
    assertNull(ruleNode.getRuleChainId());
    assertNull(actualRuleNode.getRuleChainId());
    assertNull(ruleNode.getExternalId());
    assertNull(actualRuleNode.getExternalId());
    assertNull(ruleNode.getId());
    assertNull(actualRuleNode.getId());
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
    assertEquals(0, ruleNode.getConfigurationVersion());
    assertEquals(0, actualRuleNode.getConfigurationVersion());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, ruleNode.getCreatedTime());
    assertEquals(0L, actualRuleNode.getCreatedTime());
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
    assertFalse(ruleNode.isDebugMode());
    assertFalse(actualRuleNode.isDebugMode());
    assertFalse(ruleNode.isSingletonMode());
    assertFalse(actualRuleNode.isSingletonMode());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleNode.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, ruleNode.getConfigurationBytes());
    byte[] expectedConfigurationBytes2 = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes2, actualRuleNode.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  void testNewRuleNode3() throws IOException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);

    // Act
    RuleNode actualRuleNode = new RuleNode(ruleNode);

    // Assert
    JsonNode additionalInfo = actualRuleNode.getAdditionalInfo();
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
    assertNull(actualRuleNode.getName());
    assertNull(actualRuleNode.getQueueName());
    assertNull(actualRuleNode.getType());
    assertNull(actualRuleNode.getUuidId());
    assertNull(actualRuleNode.getRuleChainId());
    assertNull(actualRuleNode.getExternalId());
    assertNull(actualRuleNode.getId());
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
    assertEquals(0, actualRuleNode.getConfigurationVersion());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualRuleNode.getCreatedTime());
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
    assertFalse(actualRuleNode.isSingletonMode());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(actualRuleNode.isDebugMode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleNode.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualRuleNode.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  void testNewRuleNode4() throws IOException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    RuleNode actualRuleNode = new RuleNode(ruleNode);

    // Assert
    JsonNode additionalInfo = actualRuleNode.getAdditionalInfo();
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
    assertNull(actualRuleNode.getName());
    assertNull(actualRuleNode.getQueueName());
    assertNull(actualRuleNode.getType());
    assertNull(actualRuleNode.getUuidId());
    assertNull(actualRuleNode.getRuleChainId());
    assertNull(actualRuleNode.getExternalId());
    assertNull(actualRuleNode.getId());
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
    assertEquals(0, actualRuleNode.getConfigurationVersion());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualRuleNode.getCreatedTime());
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
    assertFalse(actualRuleNode.isDebugMode());
    assertFalse(actualRuleNode.isSingletonMode());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleNode.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualRuleNode.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  void testNewRuleNode5() throws IOException {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode(new RuleNode()));

    // Act
    RuleNode actualRuleNode = new RuleNode(ruleNode);

    // Assert
    JsonNode additionalInfo = actualRuleNode.getAdditionalInfo();
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
    assertNull(ruleNode.getName());
    assertNull(actualRuleNode.getName());
    assertNull(ruleNode.getQueueName());
    assertNull(actualRuleNode.getQueueName());
    assertNull(ruleNode.getType());
    assertNull(actualRuleNode.getType());
    assertNull(ruleNode.getUuidId());
    assertNull(actualRuleNode.getUuidId());
    assertNull(ruleNode.getRuleChainId());
    assertNull(actualRuleNode.getRuleChainId());
    assertNull(ruleNode.getExternalId());
    assertNull(actualRuleNode.getExternalId());
    assertNull(ruleNode.getId());
    assertNull(actualRuleNode.getId());
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
    assertEquals(0, ruleNode.getConfigurationVersion());
    assertEquals(0, actualRuleNode.getConfigurationVersion());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, ruleNode.getCreatedTime());
    assertEquals(0L, actualRuleNode.getCreatedTime());
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
    assertFalse(ruleNode.isDebugMode());
    assertFalse(actualRuleNode.isDebugMode());
    assertFalse(ruleNode.isSingletonMode());
    assertFalse(actualRuleNode.isSingletonMode());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleNode.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, ruleNode.getConfigurationBytes());
    byte[] expectedConfigurationBytes2 = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes2, actualRuleNode.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  void testNewRuleNode6() throws IOException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[]{});

    // Act
    RuleNode actualRuleNode = new RuleNode(ruleNode);

    // Assert
    JsonNode configuration = actualRuleNode.getConfiguration();
    assertTrue(configuration instanceof MissingNode);
    JsonNode additionalInfo = actualRuleNode.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = configuration.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    assertEquals("", configuration.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(actualRuleNode.getName());
    assertNull(actualRuleNode.getQueueName());
    assertNull(actualRuleNode.getType());
    assertNull(actualRuleNode.getUuidId());
    assertNull(actualRuleNode.getRuleChainId());
    assertNull(actualRuleNode.getExternalId());
    assertNull(actualRuleNode.getId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0, configuration.size());
    assertEquals(0, actualRuleNode.getConfigurationVersion());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0.0d, traverseResult2.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, actualRuleNode.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.MISSING, configuration.getNodeType());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(configuration.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(configuration.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(configuration.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(configuration.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(configuration.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(configuration.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(configuration.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(configuration.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(configuration.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(configuration.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(configuration.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(configuration.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(configuration.isNull());
    assertFalse(additionalInfo.isNumber());
    assertFalse(configuration.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(configuration.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(configuration.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(configuration.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(configuration.isTextual());
    assertFalse(configuration.isValueNode());
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualRuleNode.isDebugMode());
    assertFalse(actualRuleNode.isSingletonMode());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(configuration.isEmpty());
    assertTrue(configuration.isMissingNode());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult2.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult2.version());
    assertSame(iteratorResult, configuration.iterator());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualRuleNode.getConfigurationBytes());
  }
}
