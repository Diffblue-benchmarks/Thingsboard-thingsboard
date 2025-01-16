package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TbResourceId;

class TbResourceDiffblueTest {
  /**
   * Test {@link TbResource#equals(Object)}, and {@link TbResource#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResource#equals(Object)}
   *   <li>{@link TbResource#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbResource tbResource = new TbResource();
    TbResource tbResource2 = new TbResource();

    // Act and Assert
    assertEquals(tbResource, tbResource2);
    int expectedHashCodeResult = tbResource.hashCode();
    assertEquals(expectedHashCodeResult, tbResource2.hashCode());
  }

  /**
   * Test {@link TbResource#equals(Object)}, and {@link TbResource#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResource#equals(Object)}
   *   <li>{@link TbResource#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbResource tbResource = new TbResource();

    // Act and Assert
    assertEquals(tbResource, tbResource);
    int expectedHashCodeResult = tbResource.hashCode();
    assertEquals(expectedHashCodeResult, tbResource.hashCode());
  }

  /**
   * Test {@link TbResource#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbResource tbResource = new TbResource(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(tbResource, new TbResource());
  }

  /**
   * Test {@link TbResource#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResource(), mock(AdminSettings.class));
  }

  /**
   * Test {@link TbResource#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setEncodedData("Data");

    // Act and Assert
    assertNotEquals(tbResource, new TbResource());
  }

  /**
   * Test {@link TbResource#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setEncodedPreview("Preview");

    // Act and Assert
    assertNotEquals(tbResource, new TbResource());
  }

  /**
   * Test {@link TbResource#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResource(), null);
  }

  /**
   * Test {@link TbResource#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResource(), "Different type to TbResource");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResource#TbResource()}
   *   <li>{@link TbResource#setData(byte[])}
   *   <li>{@link TbResource#setPreview(byte[])}
   *   <li>{@link TbResource#toString()}
   *   <li>{@link TbResource#getData()}
   *   <li>{@link TbResource#getPreview()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    TbResource actualTbResource = new TbResource();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualTbResource.setData(data);
    byte[] preview = "AXAXAXAX".getBytes("UTF-8");
    actualTbResource.setPreview(preview);
    String actualToStringResult = actualTbResource.toString();
    byte[] actualData = actualTbResource.getData();
    byte[] actualPreview = actualTbResource.getPreview();

    // Assert that nothing has changed
    assertEquals("TbResourceInfo(tenantId=null, title=null, resourceType=null, resourceSubType=null, resourceKey=null,"
        + " isPublic=false, publicResourceKey=null, searchText=null, etag=null, fileName=null, descriptor=null,"
        + " externalId=null)", actualToStringResult);
    assertEquals(0L, actualTbResource.getCreatedTime());
    assertFalse(actualTbResource.isPublic());
    assertSame(data, actualData);
    assertSame(preview, actualPreview);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResource#TbResource(TbResourceId)}
   *   <li>{@link TbResource#setData(byte[])}
   *   <li>{@link TbResource#setPreview(byte[])}
   *   <li>{@link TbResource#toString()}
   *   <li>{@link TbResource#getData()}
   *   <li>{@link TbResource#getPreview()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters2() throws UnsupportedEncodingException {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbResource actualTbResource = new TbResource(id);
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualTbResource.setData(data);
    byte[] preview = "AXAXAXAX".getBytes("UTF-8");
    actualTbResource.setPreview(preview);
    String actualToStringResult = actualTbResource.toString();
    byte[] actualData = actualTbResource.getData();
    byte[] actualPreview = actualTbResource.getPreview();

    // Assert that nothing has changed
    assertEquals("TbResourceInfo(tenantId=null, title=null, resourceType=null, resourceSubType=null, resourceKey=null,"
        + " isPublic=false, publicResourceKey=null, searchText=null, etag=null, fileName=null, descriptor=null,"
        + " externalId=null)", actualToStringResult);
    assertEquals(0L, actualTbResource.getCreatedTime());
    assertFalse(actualTbResource.isPublic());
    assertSame(id, actualTbResource.getId());
    assertSame(data, actualData);
    assertSame(preview, actualPreview);
  }

  /**
   * Test {@link TbResource#TbResource(TbResourceInfo)}.
   * <ul>
   *   <li>Given {@code Resource Info}.</li>
   *   <li>Then Descriptor return {@link TextNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#TbResource(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResource(TbResourceInfo); given 'Resource Info'; then Descriptor return TextNode")
  void testNewTbResource_givenResourceInfo_thenDescriptorReturnTextNode() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    resourceInfo.setDescriptorValue("Resource Info");

    // Act and Assert
    JsonNode descriptor = (new TbResource(resourceInfo)).getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals("\"Resource Info\"", descriptor.toPrettyString());
    assertEquals(0, descriptor.size());
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.iterator().hasNext());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResource#TbResource(TbResource)}.
   * <ul>
   *   <li>Given {@code Resource}.</li>
   *   <li>Then Descriptor return {@link TextNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#TbResource(TbResource)}
   */
  @Test
  @DisplayName("Test new TbResource(TbResource); given 'Resource'; then Descriptor return TextNode")
  void testNewTbResource_givenResource_thenDescriptorReturnTextNode() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setDescriptorValue("Resource");

    // Act and Assert
    JsonNode descriptor = (new TbResource(resource)).getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals("\"Resource\"", descriptor.toPrettyString());
    assertEquals(0, descriptor.size());
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.iterator().hasNext());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResource#TbResource(TbResource)}.
   * <ul>
   *   <li>Then Descriptor return {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#TbResource(TbResource)}
   */
  @Test
  @DisplayName("Test new TbResource(TbResource); then Descriptor return ObjectNode")
  void testNewTbResource_thenDescriptorReturnObjectNode() throws IOException {
    // Arrange
    TbResource resource = new TbResource();
    resource.setDescriptorValue(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    JsonNode descriptor = (new TbResource(resource)).getDescriptor();
    assertTrue(descriptor instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = nextResult2.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("\"784f394c-42b6-435a-983c-b7beff2784f9\"", nextResult2.toPrettyString());
    assertEquals("\"TB_RESOURCE\"", nextResult.toPrettyString());
    assertEquals("{\r\n  \"entityType\" : \"TB_RESOURCE\",\r\n  \"id\" : \"784f394c-42b6-435a-983c-b7beff2784f9\"\r\n}",
        descriptor.toPrettyString());
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
    assertEquals(0, nextResult.size());
    assertEquals(0, nextResult2.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0.0d, traverseResult2.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(2, descriptor.size());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
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
    assertFalse(nextResult.isArray());
    assertFalse(nextResult2.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult2.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult2.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult2.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult2.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult2.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult2.isDouble());
    assertFalse(descriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult2.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult2.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult2.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult2.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult2.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult2.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult2.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult2.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult2.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult2.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult2.isShort());
    assertFalse(descriptor.isTextual());
    assertFalse(descriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(descriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult2.isEmpty());
    assertTrue(descriptor.isObject());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult.isValueNode());
    assertTrue(nextResult2.isValueNode());
  }

  /**
   * Test {@link TbResource#TbResource(TbResourceInfo)}.
   * <ul>
   *   <li>Then Descriptor return {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#TbResource(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResource(TbResourceInfo); then Descriptor return ObjectNode")
  void testNewTbResource_thenDescriptorReturnObjectNode2() throws IOException {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    resourceInfo.setDescriptorValue(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    JsonNode descriptor = (new TbResource(resourceInfo)).getDescriptor();
    assertTrue(descriptor instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = nextResult2.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("\"784f394c-42b6-435a-983c-b7beff2784f9\"", nextResult2.toPrettyString());
    assertEquals("\"TB_RESOURCE\"", nextResult.toPrettyString());
    assertEquals("{\r\n  \"entityType\" : \"TB_RESOURCE\",\r\n  \"id\" : \"784f394c-42b6-435a-983c-b7beff2784f9\"\r\n}",
        descriptor.toPrettyString());
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
    assertEquals(0, nextResult.size());
    assertEquals(0, nextResult2.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0.0d, traverseResult2.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(2, descriptor.size());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
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
    assertFalse(nextResult.isArray());
    assertFalse(nextResult2.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult2.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult2.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult2.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult2.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult2.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult2.isDouble());
    assertFalse(descriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult2.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult2.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult2.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult2.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult2.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult2.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult2.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult2.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult2.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult2.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult2.isShort());
    assertFalse(descriptor.isTextual());
    assertFalse(descriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(descriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult2.isEmpty());
    assertTrue(descriptor.isObject());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult.isValueNode());
    assertTrue(nextResult2.isValueNode());
  }

  /**
   * Test {@link TbResource#TbResource(TbResourceInfo)}.
   * <ul>
   *   <li>When {@link TbResourceInfo#TbResourceInfo()}.</li>
   *   <li>Then return Data is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#TbResource(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResource(TbResourceInfo); when TbResourceInfo(); then return Data is 'null'")
  void testNewTbResource_whenTbResourceInfo_thenReturnDataIsNull() {
    // Arrange and Act
    TbResource actualTbResource = new TbResource(new TbResourceInfo());

    // Assert
    assertNull(actualTbResource.getData());
    assertNull(actualTbResource.getPreview());
    assertNull(actualTbResource.getDescriptor());
    assertNull(actualTbResource.getEncodedData());
    assertNull(actualTbResource.getEncodedPreview());
    assertNull(actualTbResource.getEtag());
    assertNull(actualTbResource.getFileName());
    assertNull(actualTbResource.getLink());
    assertNull(actualTbResource.getName());
    assertNull(actualTbResource.getPublicLink());
    assertNull(actualTbResource.getPublicResourceKey());
    assertNull(actualTbResource.getResourceKey());
    assertNull(actualTbResource.getSearchText());
    assertNull(actualTbResource.getTitle());
    assertNull(actualTbResource.getUuidId());
    assertNull(actualTbResource.getResourceSubType());
    assertNull(actualTbResource.getResourceType());
    assertNull(actualTbResource.getExternalId());
    assertNull(actualTbResource.getId());
    assertNull(actualTbResource.getTenantId());
    assertEquals(0L, actualTbResource.getCreatedTime());
    assertFalse(actualTbResource.isPublic());
  }

  /**
   * Test {@link TbResource#TbResource(TbResource)}.
   * <ul>
   *   <li>When {@link TbResource#TbResource()}.</li>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#TbResource(TbResource)}
   */
  @Test
  @DisplayName("Test new TbResource(TbResource); when TbResource(); then return TbResource()")
  void testNewTbResource_whenTbResource_thenReturnTbResource() {
    // Arrange
    TbResource resource = new TbResource();

    // Act and Assert
    assertEquals(resource, new TbResource(resource));
  }

  /**
   * Test {@link TbResource#getEncodedData()}.
   * <p>
   * Method under test: {@link TbResource#getEncodedData()}
   */
  @Test
  @DisplayName("Test getEncodedData()")
  void testGetEncodedData() {
    // Arrange, Act and Assert
    assertNull((new TbResource()).getEncodedData());
  }

  /**
   * Test {@link TbResource#setEncodedData(String)}.
   * <ul>
   *   <li>When {@code Data}.</li>
   *   <li>Then {@link TbResource#TbResource()} EncodedData is {@code Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#setEncodedData(String)}
   */
  @Test
  @DisplayName("Test setEncodedData(String); when 'Data'; then TbResource() EncodedData is 'Data'")
  void testSetEncodedData_whenData_thenTbResourceEncodedDataIsData() {
    // Arrange
    TbResource tbResource = new TbResource();

    // Act
    tbResource.setEncodedData("Data");

    // Assert
    assertEquals("Data", tbResource.getEncodedData());
    assertArrayEquals(new byte[]{'\r', -85, 'Z'}, tbResource.getData());
  }

  /**
   * Test {@link TbResource#getEncodedPreview()}.
   * <p>
   * Method under test: {@link TbResource#getEncodedPreview()}
   */
  @Test
  @DisplayName("Test getEncodedPreview()")
  void testGetEncodedPreview() {
    // Arrange, Act and Assert
    assertNull((new TbResource()).getEncodedPreview());
  }

  /**
   * Test {@link TbResource#setEncodedPreview(String)}.
   * <ul>
   *   <li>When {@code Preview}.</li>
   *   <li>Then {@link TbResource#TbResource()} EncodedPreview is
   * {@code Preview=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#setEncodedPreview(String)}
   */
  @Test
  @DisplayName("Test setEncodedPreview(String); when 'Preview'; then TbResource() EncodedPreview is 'Preview='")
  void testSetEncodedPreview_whenPreview_thenTbResourceEncodedPreviewIsPreview() {
    // Arrange
    TbResource tbResource = new TbResource();

    // Act
    tbResource.setEncodedPreview("Preview");

    // Assert
    assertEquals("Preview=", tbResource.getEncodedPreview());
    assertArrayEquals(new byte[]{'>', -73, -81, -119, -20}, tbResource.getPreview());
  }
}
