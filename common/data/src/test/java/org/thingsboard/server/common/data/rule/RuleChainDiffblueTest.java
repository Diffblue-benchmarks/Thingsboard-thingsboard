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
import org.thingsboard.server.common.data.id.TenantId;

class RuleChainDiffblueTest {
  /**
   * Method under test: {@link RuleChain#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new RuleChain()).getId());
  }

  /**
   * Method under test: {@link RuleChain#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new RuleChain()).getCreatedTime());
  }

  /**
   * Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  void testGetConfiguration() {
    // Arrange, Act and Assert
    assertNull((new RuleChain()).getConfiguration());
  }

  /**
   * Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  void testGetConfiguration2() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChain());

    // Act
    JsonNode actualConfiguration = ruleChain.getConfiguration();

    // Assert
    NullNode nullNode = ((NullNode) actualConfiguration).instance;
    assertSame(nullNode, ruleChain.getAdditionalInfo());
    assertSame(nullNode, actualConfiguration);
  }

  /**
   * Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  void testGetConfiguration3() throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(ruleChain.getConfiguration());
  }

  /**
   * Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  void testGetConfiguration4() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChain(new RuleChain()));

    // Act
    JsonNode actualConfiguration = ruleChain.getConfiguration();

    // Assert
    NullNode nullNode = ((NullNode) actualConfiguration).instance;
    assertSame(nullNode, ruleChain.getAdditionalInfo());
    assertSame(nullNode, actualConfiguration);
  }

  /**
   * Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  void testGetConfiguration5() throws IOException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[]{});

    // Act
    JsonNode actualConfiguration = ruleChain.getConfiguration();

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
   * Method under test: {@link RuleChain#setConfiguration(JsonNode)}
   */
  @Test
  void testSetConfiguration() throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    MissingNode data = MissingNode.getInstance();

    // Act
    ruleChain.setConfiguration(data);

    // Assert
    assertSame(data, ruleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, ruleChain.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleChain#setConfiguration(JsonNode)}
   */
  @Test
  void testSetConfiguration2() throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addObject();

    // Act
    ruleChain.setConfiguration(data);

    // Assert
    assertSame(data, ruleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "[{}]".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, ruleChain.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleChain#setConfiguration(JsonNode)}
   */
  @Test
  void testSetConfiguration3() throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addObject();
    data.addObject();

    // Act
    ruleChain.setConfiguration(data);

    // Assert
    assertSame(data, ruleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "[{},{}]".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, ruleChain.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleChain#isDefault()}
   */
  @Test
  void testIsDefault() {
    // Arrange, Act and Assert
    assertFalse((new RuleChain()).isDefault());
  }

  /**
   * Method under test: {@link RuleChain#isDefault()}
   */
  @Test
  void testIsDefault2() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setRoot(true);

    // Act and Assert
    assertFalse(ruleChain.isDefault());
  }

  /**
   * Method under test: {@link RuleChain#isDefault()}
   */
  @Test
  void testIsDefault3() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setType(RuleChainType.CORE);
    ruleChain.setRoot(true);

    // Act and Assert
    assertTrue(ruleChain.isDefault());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChain#equals(Object)}
   *   <li>{@link RuleChain#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    RuleChain ruleChain2 = new RuleChain();

    // Act and Assert
    assertEquals(ruleChain, ruleChain2);
    int expectedHashCodeResult = ruleChain.hashCode();
    assertEquals(expectedHashCodeResult, ruleChain2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChain#equals(Object)}
   *   <li>{@link RuleChain#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    // Act and Assert
    assertEquals(ruleChain, ruleChain);
    int expectedHashCodeResult = ruleChain.hashCode();
    assertEquals(expectedHashCodeResult, ruleChain.hashCode());
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChain(), mock(RuleNode.class));
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setName("Name");

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setType(RuleChainType.CORE);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setFirstRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setRoot(true);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setDebugMode(true);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setExternalId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setName("Name");

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setType(RuleChainType.CORE);

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setFirstRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setExternalId(new RuleChainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChain(), null);
  }

  /**
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChain(), "Different type to RuleChain");
  }

  /**
   * Method under test: {@link RuleChain#getExternalId()}
   */
  @Test
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new RuleChain()).getExternalId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChain#RuleChain()}
   *   <li>{@link RuleChain#setConfigurationBytes(byte[])}
   *   <li>{@link RuleChain#setDebugMode(boolean)}
   *   <li>{@link RuleChain#setExternalId(RuleChainId)}
   *   <li>{@link RuleChain#setFirstRuleNodeId(RuleNodeId)}
   *   <li>{@link RuleChain#setName(String)}
   *   <li>{@link RuleChain#setRoot(boolean)}
   *   <li>{@link RuleChain#setTenantId(TenantId)}
   *   <li>{@link RuleChain#setType(RuleChainType)}
   *   <li>{@link RuleChain#setVersion(Long)}
   *   <li>{@link RuleChain#toString()}
   *   <li>{@link RuleChain#getConfigurationBytes()}
   *   <li>{@link RuleChain#getFirstRuleNodeId()}
   *   <li>{@link RuleChain#getName()}
   *   <li>{@link RuleChain#getTenantId()}
   *   <li>{@link RuleChain#getType()}
   *   <li>{@link RuleChain#getVersion()}
   *   <li>{@link RuleChain#isDebugMode()}
   *   <li>{@link RuleChain#isRoot()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    RuleChain actualRuleChain = new RuleChain();
    byte[] configurationBytes = "AXAXAXAX".getBytes("UTF-8");
    actualRuleChain.setConfigurationBytes(configurationBytes);
    actualRuleChain.setDebugMode(true);
    RuleChainId externalId = new RuleChainId(EntityId.NULL_UUID);
    actualRuleChain.setExternalId(externalId);
    RuleNodeId firstRuleNodeId = new RuleNodeId(EntityId.NULL_UUID);
    actualRuleChain.setFirstRuleNodeId(firstRuleNodeId);
    actualRuleChain.setName("Name");
    actualRuleChain.setRoot(true);
    actualRuleChain.setTenantId(TenantId.SYS_TENANT_ID);
    actualRuleChain.setType(RuleChainType.CORE);
    actualRuleChain.setVersion(1L);
    String actualToStringResult = actualRuleChain.toString();
    byte[] actualConfigurationBytes = actualRuleChain.getConfigurationBytes();
    RuleNodeId actualFirstRuleNodeId = actualRuleChain.getFirstRuleNodeId();
    String actualName = actualRuleChain.getName();
    TenantId actualTenantId = actualRuleChain.getTenantId();
    RuleChainType actualType = actualRuleChain.getType();
    Long actualVersion = actualRuleChain.getVersion();
    boolean actualIsDebugModeResult = actualRuleChain.isDebugMode();
    boolean actualIsRootResult = actualRuleChain.isRoot();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(
        "RuleChain(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, type=CORE, firstRuleNodeId=13814000"
            + "-1dd2-11b2-8080-808080808080, root=true, debugMode=true, configuration=null, externalId=13814000-1dd2"
            + "-11b2-8080-808080808080, version=1, configurationBytes=[65, 88, 65, 88, 65, 88, 65, 88])",
        actualToStringResult);
    assertEquals(0L, actualRuleChain.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertEquals(RuleChainType.CORE, actualType);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsRootResult);
    assertSame(externalId, actualRuleChain.getExternalId());
    assertSame(firstRuleNodeId, actualFirstRuleNodeId);
    assertSame(configurationBytes, actualConfigurationBytes);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChain#RuleChain(RuleChainId)}
   *   <li>{@link RuleChain#setConfigurationBytes(byte[])}
   *   <li>{@link RuleChain#setDebugMode(boolean)}
   *   <li>{@link RuleChain#setExternalId(RuleChainId)}
   *   <li>{@link RuleChain#setFirstRuleNodeId(RuleNodeId)}
   *   <li>{@link RuleChain#setName(String)}
   *   <li>{@link RuleChain#setRoot(boolean)}
   *   <li>{@link RuleChain#setTenantId(TenantId)}
   *   <li>{@link RuleChain#setType(RuleChainType)}
   *   <li>{@link RuleChain#setVersion(Long)}
   *   <li>{@link RuleChain#toString()}
   *   <li>{@link RuleChain#getConfigurationBytes()}
   *   <li>{@link RuleChain#getFirstRuleNodeId()}
   *   <li>{@link RuleChain#getName()}
   *   <li>{@link RuleChain#getTenantId()}
   *   <li>{@link RuleChain#getType()}
   *   <li>{@link RuleChain#getVersion()}
   *   <li>{@link RuleChain#isDebugMode()}
   *   <li>{@link RuleChain#isRoot()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() throws UnsupportedEncodingException {
    // Arrange
    RuleChainId id = new RuleChainId(EntityId.NULL_UUID);

    // Act
    RuleChain actualRuleChain = new RuleChain(id);
    byte[] configurationBytes = "AXAXAXAX".getBytes("UTF-8");
    actualRuleChain.setConfigurationBytes(configurationBytes);
    actualRuleChain.setDebugMode(true);
    RuleChainId externalId = new RuleChainId(EntityId.NULL_UUID);
    actualRuleChain.setExternalId(externalId);
    RuleNodeId firstRuleNodeId = new RuleNodeId(EntityId.NULL_UUID);
    actualRuleChain.setFirstRuleNodeId(firstRuleNodeId);
    actualRuleChain.setName("Name");
    actualRuleChain.setRoot(true);
    actualRuleChain.setTenantId(TenantId.SYS_TENANT_ID);
    actualRuleChain.setType(RuleChainType.CORE);
    actualRuleChain.setVersion(1L);
    String actualToStringResult = actualRuleChain.toString();
    byte[] actualConfigurationBytes = actualRuleChain.getConfigurationBytes();
    RuleNodeId actualFirstRuleNodeId = actualRuleChain.getFirstRuleNodeId();
    String actualName = actualRuleChain.getName();
    TenantId actualTenantId = actualRuleChain.getTenantId();
    RuleChainType actualType = actualRuleChain.getType();
    Long actualVersion = actualRuleChain.getVersion();
    boolean actualIsDebugModeResult = actualRuleChain.isDebugMode();
    boolean actualIsRootResult = actualRuleChain.isRoot();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(
        "RuleChain(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, type=CORE, firstRuleNodeId=13814000"
            + "-1dd2-11b2-8080-808080808080, root=true, debugMode=true, configuration=null, externalId=13814000-1dd2"
            + "-11b2-8080-808080808080, version=1, configurationBytes=[65, 88, 65, 88, 65, 88, 65, 88])",
        actualToStringResult);
    assertEquals(0L, actualRuleChain.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertEquals(RuleChainType.CORE, actualType);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsRootResult);
    assertSame(externalId, actualRuleChain.getExternalId());
    assertSame(id, actualRuleChain.getId());
    assertSame(firstRuleNodeId, actualFirstRuleNodeId);
    assertSame(configurationBytes, actualConfigurationBytes);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  void testNewRuleChain() throws IOException {
    // Arrange and Act
    RuleChain actualRuleChain = new RuleChain(new RuleChain());

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
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
    assertNull(actualRuleChain.getVersion());
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
    assertNull(actualRuleChain.getName());
    assertNull(actualRuleChain.getUuidId());
    assertNull(actualRuleChain.getExternalId());
    assertNull(actualRuleChain.getId());
    assertNull(actualRuleChain.getFirstRuleNodeId());
    assertNull(actualRuleChain.getTenantId());
    assertNull(actualRuleChain.getType());
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
    assertEquals(0L, actualRuleChain.getCreatedTime());
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
    assertFalse(actualRuleChain.isDebugMode());
    assertFalse(actualRuleChain.isDefault());
    assertFalse(actualRuleChain.isRoot());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualRuleChain.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  void testNewRuleChain2() throws IOException {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChain());

    // Act
    RuleChain actualRuleChain = new RuleChain(ruleChain);

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
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
    assertNull(ruleChain.getVersion());
    assertNull(actualRuleChain.getVersion());
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
    assertNull(ruleChain.getName());
    assertNull(actualRuleChain.getName());
    assertNull(ruleChain.getUuidId());
    assertNull(actualRuleChain.getUuidId());
    assertNull(ruleChain.getExternalId());
    assertNull(actualRuleChain.getExternalId());
    assertNull(ruleChain.getId());
    assertNull(actualRuleChain.getId());
    assertNull(ruleChain.getFirstRuleNodeId());
    assertNull(actualRuleChain.getFirstRuleNodeId());
    assertNull(ruleChain.getTenantId());
    assertNull(actualRuleChain.getTenantId());
    assertNull(ruleChain.getType());
    assertNull(actualRuleChain.getType());
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
    assertEquals(0L, ruleChain.getCreatedTime());
    assertEquals(0L, actualRuleChain.getCreatedTime());
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
    assertFalse(ruleChain.isDebugMode());
    assertFalse(actualRuleChain.isDebugMode());
    assertFalse(ruleChain.isDefault());
    assertFalse(actualRuleChain.isDefault());
    assertFalse(ruleChain.isRoot());
    assertFalse(actualRuleChain.isRoot());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, ruleChain.getConfigurationBytes());
    byte[] expectedConfigurationBytes2 = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes2, actualRuleChain.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  void testNewRuleChain3() throws IOException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setRoot(true);

    // Act
    RuleChain actualRuleChain = new RuleChain(ruleChain);

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
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
    assertNull(actualRuleChain.getVersion());
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
    assertNull(actualRuleChain.getName());
    assertNull(actualRuleChain.getUuidId());
    assertNull(actualRuleChain.getExternalId());
    assertNull(actualRuleChain.getId());
    assertNull(actualRuleChain.getFirstRuleNodeId());
    assertNull(actualRuleChain.getTenantId());
    assertNull(actualRuleChain.getType());
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
    assertEquals(0L, actualRuleChain.getCreatedTime());
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
    assertFalse(actualRuleChain.isDebugMode());
    assertFalse(actualRuleChain.isDefault());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(actualRuleChain.isRoot());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualRuleChain.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  void testNewRuleChain4() throws IOException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    RuleChain actualRuleChain = new RuleChain(ruleChain);

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
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
    assertNull(actualRuleChain.getVersion());
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
    assertNull(actualRuleChain.getName());
    assertNull(actualRuleChain.getUuidId());
    assertNull(actualRuleChain.getExternalId());
    assertNull(actualRuleChain.getId());
    assertNull(actualRuleChain.getFirstRuleNodeId());
    assertNull(actualRuleChain.getTenantId());
    assertNull(actualRuleChain.getType());
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
    assertEquals(0L, actualRuleChain.getCreatedTime());
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
    assertFalse(actualRuleChain.isDebugMode());
    assertFalse(actualRuleChain.isDefault());
    assertFalse(actualRuleChain.isRoot());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualRuleChain.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  void testNewRuleChain5() throws IOException {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChain(new RuleChain()));

    // Act
    RuleChain actualRuleChain = new RuleChain(ruleChain);

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
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
    assertNull(ruleChain.getVersion());
    assertNull(actualRuleChain.getVersion());
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
    assertNull(ruleChain.getName());
    assertNull(actualRuleChain.getName());
    assertNull(ruleChain.getUuidId());
    assertNull(actualRuleChain.getUuidId());
    assertNull(ruleChain.getExternalId());
    assertNull(actualRuleChain.getExternalId());
    assertNull(ruleChain.getId());
    assertNull(actualRuleChain.getId());
    assertNull(ruleChain.getFirstRuleNodeId());
    assertNull(actualRuleChain.getFirstRuleNodeId());
    assertNull(ruleChain.getTenantId());
    assertNull(actualRuleChain.getTenantId());
    assertNull(ruleChain.getType());
    assertNull(actualRuleChain.getType());
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
    assertEquals(0L, ruleChain.getCreatedTime());
    assertEquals(0L, actualRuleChain.getCreatedTime());
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
    assertFalse(ruleChain.isDebugMode());
    assertFalse(actualRuleChain.isDebugMode());
    assertFalse(ruleChain.isDefault());
    assertFalse(actualRuleChain.isDefault());
    assertFalse(ruleChain.isRoot());
    assertFalse(actualRuleChain.isRoot());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, ruleChain.getConfigurationBytes());
    byte[] expectedConfigurationBytes2 = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes2, actualRuleChain.getConfigurationBytes());
  }

  /**
   * Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  void testNewRuleChain6() throws IOException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[]{});

    // Act
    RuleChain actualRuleChain = new RuleChain(ruleChain);

    // Assert
    JsonNode configuration = actualRuleChain.getConfiguration();
    assertTrue(configuration instanceof MissingNode);
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
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
    assertNull(actualRuleChain.getVersion());
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
    assertNull(actualRuleChain.getName());
    assertNull(actualRuleChain.getUuidId());
    assertNull(actualRuleChain.getExternalId());
    assertNull(actualRuleChain.getId());
    assertNull(actualRuleChain.getFirstRuleNodeId());
    assertNull(actualRuleChain.getTenantId());
    assertNull(actualRuleChain.getType());
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
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0.0d, traverseResult2.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, actualRuleChain.getCreatedTime());
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
    assertFalse(actualRuleChain.isDebugMode());
    assertFalse(actualRuleChain.isDefault());
    assertFalse(actualRuleChain.isRoot());
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
    assertArrayEquals(expectedConfigurationBytes, actualRuleChain.getConfigurationBytes());
  }
}
