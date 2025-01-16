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
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;

class RuleNodeDiffblueTest {
  /**
   * Test {@link RuleNode#equals(Object)}, and {@link RuleNode#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNode#equals(Object)}
   *   <li>{@link RuleNode#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link RuleNode#equals(Object)}, and {@link RuleNode#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNode#equals(Object)}
   *   <li>{@link RuleNode#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    // Act and Assert
    assertEquals(ruleNode, ruleNode);
    int expectedHashCodeResult = ruleNode.hashCode();
    assertEquals(expectedHashCodeResult, ruleNode.hashCode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleNode(), mock(RuleChain.class));
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setType("Type");

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setName("Name");

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setSingletonMode(true);

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setQueueName("Queue Name");

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationVersion(1);

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setExternalId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleNode, new RuleNode());
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setName("Name");

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setQueueName("Queue Name");

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    RuleNode ruleNode2 = new RuleNode();
    ruleNode2.setExternalId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleNode, ruleNode2);
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleNode(), null);
  }

  /**
   * Test {@link RuleNode#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleNode(), "Different type to RuleNode");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    RuleNode actualRuleNode = new RuleNode();
    byte[] configurationBytes = "AXAXAXAX".getBytes("UTF-8");
    actualRuleNode.setConfigurationBytes(configurationBytes);
    actualRuleNode.setConfigurationVersion(1);
    actualRuleNode.setDebugMode(true);
    RuleNodeId externalId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleNode.setExternalId(externalId);
    actualRuleNode.setName("Name");
    actualRuleNode.setQueueName("Queue Name");
    RuleChainId ruleChainId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    assertEquals("RuleNode(ruleChainId=784f394c-42b6-435a-983c-b7beff2784f9, type=Type, name=Name, debugMode=true,"
        + " singletonMode=true, queueName=Queue Name, configurationVersion=1, configuration=null, configurationBytes"
        + "=[65, 88, 65, 88, 65, 88, 65, 88], externalId=784f394c-42b6-435a-983c-b7beff2784f9)", actualToStringResult);
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  void testGettersAndSetters2() throws UnsupportedEncodingException {
    // Arrange
    RuleNodeId id = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    RuleNode actualRuleNode = new RuleNode(id);
    byte[] configurationBytes = "AXAXAXAX".getBytes("UTF-8");
    actualRuleNode.setConfigurationBytes(configurationBytes);
    actualRuleNode.setConfigurationVersion(1);
    actualRuleNode.setDebugMode(true);
    RuleNodeId externalId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleNode.setExternalId(externalId);
    actualRuleNode.setName("Name");
    actualRuleNode.setQueueName("Queue Name");
    RuleChainId ruleChainId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    assertEquals("RuleNode(ruleChainId=784f394c-42b6-435a-983c-b7beff2784f9, type=Type, name=Name, debugMode=true,"
        + " singletonMode=true, queueName=Queue Name, configurationVersion=1, configuration=null, configurationBytes"
        + "=[65, 88, 65, 88, 65, 88, 65, 88], externalId=784f394c-42b6-435a-983c-b7beff2784f9)", actualToStringResult);
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
   * Test {@link RuleNode#RuleNode(RuleNode)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link RuleNode#RuleNode()} ConfigurationBytes is array of
   * {@code byte} with {@code A} and three.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  @DisplayName("Test new RuleNode(RuleNode); given 'A'; when RuleNode() ConfigurationBytes is array of byte with 'A' and three")
  void testNewRuleNode_givenA_whenRuleNodeConfigurationBytesIsArrayOfByteWithAAndThree() throws IOException {
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
   * Test {@link RuleNode#RuleNode(RuleNode)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   *   <li>Then Configuration return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  @DisplayName("Test new RuleNode(RuleNode); given empty array of byte; then Configuration return MissingNode")
  void testNewRuleNode_givenEmptyArrayOfByte_thenConfigurationReturnMissingNode() throws IOException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[]{});

    // Act and Assert
    JsonNode configuration = (new RuleNode(ruleNode)).getConfiguration();
    assertTrue(configuration instanceof MissingNode);
    JsonParser traverseResult = configuration.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", configuration.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
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
    assertEquals(0, configuration.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(JsonNodeType.MISSING, configuration.getNodeType());
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
    assertFalse(configuration.isArray());
    assertFalse(configuration.isBigDecimal());
    assertFalse(configuration.isBigInteger());
    assertFalse(configuration.isBinary());
    assertFalse(configuration.isBoolean());
    assertFalse(configuration.isContainerNode());
    assertFalse(configuration.isDouble());
    assertFalse(configuration.isFloat());
    assertFalse(configuration.isFloatingPointNumber());
    assertFalse(configuration.isInt());
    assertFalse(configuration.isIntegralNumber());
    assertFalse(configuration.isLong());
    assertFalse(configuration.isNull());
    assertFalse(configuration.isNumber());
    assertFalse(configuration.isObject());
    assertFalse(configuration.isPojo());
    assertFalse(configuration.isShort());
    assertFalse(configuration.isTextual());
    assertFalse(configuration.isValueNode());
    assertTrue(configuration.isEmpty());
    assertTrue(configuration.isMissingNode());
  }

  /**
   * Test {@link RuleNode#RuleNode(RuleNode)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link RuleNode#RuleNode()} DebugMode is {@code true}.</li>
   *   <li>Then return DebugMode.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  @DisplayName("Test new RuleNode(RuleNode); given 'true'; when RuleNode() DebugMode is 'true'; then return DebugMode")
  void testNewRuleNode_givenTrue_whenRuleNodeDebugModeIsTrue_thenReturnDebugMode() throws IOException {
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
   * Test {@link RuleNode#RuleNode(RuleNode)}.
   * <ul>
   *   <li>When {@link RuleNode#RuleNode(RuleNode)} with ruleNode is
   * {@link RuleNode#RuleNode()}.</li>
   *   <li>Then return not DebugMode.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  @DisplayName("Test new RuleNode(RuleNode); when RuleNode(RuleNode) with ruleNode is RuleNode(); then return not DebugMode")
  void testNewRuleNode_whenRuleNodeWithRuleNodeIsRuleNode_thenReturnNotDebugMode() throws IOException {
    // Arrange and Act
    RuleNode actualRuleNode = new RuleNode(new RuleNode(new RuleNode()));

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
   * Test {@link RuleNode#RuleNode(RuleNode)}.
   * <ul>
   *   <li>When {@link RuleNode#RuleNode(RuleNode)} with ruleNode is
   * {@link RuleNode#RuleNode(RuleNode)}.</li>
   *   <li>Then return not DebugMode.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  @DisplayName("Test new RuleNode(RuleNode); when RuleNode(RuleNode) with ruleNode is RuleNode(RuleNode); then return not DebugMode")
  void testNewRuleNode_whenRuleNodeWithRuleNodeIsRuleNode_thenReturnNotDebugMode2() throws IOException {
    // Arrange and Act
    RuleNode actualRuleNode = new RuleNode(new RuleNode(new RuleNode(new RuleNode())));

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
   * Test {@link RuleNode#RuleNode(RuleNode)}.
   * <ul>
   *   <li>When {@link RuleNode#RuleNode()}.</li>
   *   <li>Then return not DebugMode.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#RuleNode(RuleNode)}
   */
  @Test
  @DisplayName("Test new RuleNode(RuleNode); when RuleNode(); then return not DebugMode")
  void testNewRuleNode_whenRuleNode_thenReturnNotDebugMode() throws IOException {
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
   * Test {@link RuleNode#getConfiguration()}.
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()} ConfigurationBytes is {@code AXAXAXAX}
   * Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration(); given RuleNode() ConfigurationBytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  void testGetConfiguration_givenRuleNodeConfigurationBytesIsAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    JsonNode actualConfiguration = ruleNode.getConfiguration();

    // Assert
    assertNull(ruleNode.getAdditionalInfo());
    assertNull(actualConfiguration);
  }

  /**
   * Test {@link RuleNode#getConfiguration()}.
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()}.</li>
   *   <li>Then {@link RuleNode#RuleNode()} AdditionalInfo is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration(); given RuleNode(); then RuleNode() AdditionalInfo is 'null'")
  void testGetConfiguration_givenRuleNode_thenRuleNodeAdditionalInfoIsNull() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    // Act
    JsonNode actualConfiguration = ruleNode.getConfiguration();

    // Assert
    assertNull(ruleNode.getAdditionalInfo());
    assertNull(actualConfiguration);
  }

  /**
   * Test {@link RuleNode#getConfiguration()}.
   * <ul>
   *   <li>Then return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration(); then return MissingNode")
  void testGetConfiguration_thenReturnMissingNode() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[]{});

    // Act
    JsonNode actualConfiguration = ruleNode.getConfiguration();

    // Assert
    assertTrue(actualConfiguration instanceof MissingNode);
    assertTrue(actualConfiguration.traverse() instanceof TreeTraversingParser);
    assertEquals("", actualConfiguration.toPrettyString());
    assertEquals(JsonNodeType.MISSING, actualConfiguration.getNodeType());
    assertFalse(actualConfiguration.isNull());
    assertFalse(actualConfiguration.isValueNode());
    assertTrue(actualConfiguration.isMissingNode());
  }

  /**
   * Test {@link RuleNode#getConfiguration()}.
   * <ul>
   *   <li>Then {@link RuleNode#RuleNode(RuleNode)} with ruleNode is
   * {@link RuleNode#RuleNode()} AdditionalInfo is {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration(); then RuleNode(RuleNode) with ruleNode is RuleNode() AdditionalInfo is instance")
  void testGetConfiguration_thenRuleNodeWithRuleNodeIsRuleNodeAdditionalInfoIsInstance() {
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
   * Test {@link RuleNode#getConfiguration()}.
   * <ul>
   *   <li>Then {@link RuleNode#RuleNode(RuleNode)} with ruleNode is
   * {@link RuleNode#RuleNode(RuleNode)} AdditionalInfo is
   * {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration(); then RuleNode(RuleNode) with ruleNode is RuleNode(RuleNode) AdditionalInfo is instance")
  void testGetConfiguration_thenRuleNodeWithRuleNodeIsRuleNodeAdditionalInfoIsInstance2() {
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
   * Test {@link RuleNode#setConfiguration(JsonNode)}.
   * <p>
   * Method under test: {@link RuleNode#setConfiguration(JsonNode)}
   */
  @Test
  @DisplayName("Test setConfiguration(JsonNode)")
  void testSetConfiguration() throws UnsupportedEncodingException {
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
   * Test {@link RuleNode#setConfiguration(JsonNode)}.
   * <ul>
   *   <li>Then array length is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#setConfiguration(JsonNode)}
   */
  @Test
  @DisplayName("Test setConfiguration(JsonNode); then array length is seven")
  void testSetConfiguration_thenArrayLengthIsSeven() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addObject();
    data.addObject();

    // Act
    ruleNode.setConfiguration(data);

    // Assert
    byte[] configurationBytes = ruleNode.getConfigurationBytes();
    assertEquals(7, configurationBytes.length);
    assertEquals(',', configurationBytes[3]);
    assertEquals(']', configurationBytes[6]);
    assertEquals('{', configurationBytes[4]);
    assertEquals('}', configurationBytes[5]);
  }

  /**
   * Test {@link RuleNode#setConfiguration(JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then {@link RuleNode#RuleNode()} Configuration is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#setConfiguration(JsonNode)}
   */
  @Test
  @DisplayName("Test setConfiguration(JsonNode); when Instance; then RuleNode() Configuration is Instance")
  void testSetConfiguration_whenInstance_thenRuleNodeConfigurationIsInstance() throws UnsupportedEncodingException {
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
   * Test {@link RuleNode#getId()}.
   * <p>
   * Method under test: {@link RuleNode#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new RuleNode()).getId());
  }

  /**
   * Test {@link RuleNode#getCreatedTime()}.
   * <p>
   * Method under test: {@link RuleNode#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new RuleNode()).getCreatedTime());
  }

  /**
   * Test {@link RuleNode#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given RuleNode(); then return 'null'")
  void testGetAdditionalInfo_givenRuleNode_thenReturnNull() {
    // Arrange
    RuleNode ruleNode = new RuleNode();

    // Act and Assert
    assertNull(ruleNode.getAdditionalInfo());
    assertNull(ruleNode.getConfiguration());
  }

  /**
   * Test {@link RuleNode#getAdditionalInfo()}.
   * <ul>
   *   <li>Then {@link RuleNode#RuleNode(RuleNode)} with ruleNode is
   * {@link RuleNode#RuleNode()} Configuration is {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); then RuleNode(RuleNode) with ruleNode is RuleNode() Configuration is instance")
  void testGetAdditionalInfo_thenRuleNodeWithRuleNodeIsRuleNodeConfigurationIsInstance() {
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
   * Test {@link RuleNode#getAdditionalInfo()}.
   * <ul>
   *   <li>Then {@link RuleNode#RuleNode(RuleNode)} with ruleNode is
   * {@link RuleNode#RuleNode(RuleNode)} Configuration is
   * {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNode#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); then RuleNode(RuleNode) with ruleNode is RuleNode(RuleNode) Configuration is instance")
  void testGetAdditionalInfo_thenRuleNodeWithRuleNodeIsRuleNodeConfigurationIsInstance2() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode(new RuleNode()));

    // Act
    JsonNode actualAdditionalInfo = ruleNode.getAdditionalInfo();

    // Assert
    NullNode nullNode = ((NullNode) actualAdditionalInfo).instance;
    assertSame(nullNode, actualAdditionalInfo);
    assertSame(nullNode, ruleNode.getConfiguration());
  }
}
