package org.thingsboard.server.dao.util.mapping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class JsonConverterDiffblueTest {
  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with
   * {@code JsonNode}.
   * <p>
   * Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  public void testConvertToDatabaseColumnWithJsonNode() {
    // Arrange
    JsonConverter jsonConverter = new JsonConverter();

    // Act and Assert
    assertEquals("[]",
        jsonConverter.convertToDatabaseColumn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with
   * {@code JsonNode}.
   * <p>
   * Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  public void testConvertToDatabaseColumnWithJsonNode2() {
    // Arrange
    JsonConverter jsonConverter = new JsonConverter();

    // Act and Assert
    assertEquals("[]",
        jsonConverter.convertToDatabaseColumn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true), 3)));
  }

  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with
   * {@code JsonNode}.
   * <ul>
   *   <li>Given {@code Pojo}.</li>
   *   <li>Then return {@code ["Pojo",{"isPublic":true}]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  public void testConvertToDatabaseColumnWithJsonNode_givenPojo_thenReturnPojoIsPublicTrue() {
    // Arrange
    JsonConverter jsonConverter = new JsonConverter();

    ArrayNode jsonNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    jsonNode.addPOJO("Pojo");
    jsonNode.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals("[\"Pojo\",{\"isPublic\":true}]", jsonConverter.convertToDatabaseColumn(jsonNode));
  }

  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with
   * {@code JsonNode}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>Then return {@code [2,{"isPublic":true}]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  public void testConvertToDatabaseColumnWithJsonNode_givenTwo_thenReturn2IsPublicTrue() {
    // Arrange
    JsonConverter jsonConverter = new JsonConverter();

    ArrayNode jsonNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    jsonNode.addPOJO(2);
    jsonNode.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals("[2,{\"isPublic\":true}]", jsonConverter.convertToDatabaseColumn(jsonNode));
  }

  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with
   * {@code JsonNode}.
   * <ul>
   *   <li>Then return {@code [foo,{"isPublic":true}]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  public void testConvertToDatabaseColumnWithJsonNode_thenReturnFooIsPublicTrue() {
    // Arrange
    JsonConverter jsonConverter = new JsonConverter();

    ArrayNode jsonNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    jsonNode.addRawValue(new RawValue("foo"));
    jsonNode.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals("[foo,{\"isPublic\":true}]", jsonConverter.convertToDatabaseColumn(jsonNode));
  }

  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with
   * {@code JsonNode}.
   * <ul>
   *   <li>Then return {@code {"isPublic":true}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  public void testConvertToDatabaseColumnWithJsonNode_thenReturnIsPublicTrue() {
    // Arrange, Act and Assert
    assertEquals("{\"isPublic\":true}",
        (new JsonConverter()).convertToDatabaseColumn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with
   * {@code JsonNode}.
   * <ul>
   *   <li>Then return {@code [{"isPublic":true}]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  public void testConvertToDatabaseColumnWithJsonNode_thenReturnIsPublicTrue2() {
    // Arrange
    JsonConverter jsonConverter = new JsonConverter();

    ArrayNode jsonNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    jsonNode.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals("[{\"isPublic\":true}]", jsonConverter.convertToDatabaseColumn(jsonNode));
  }

  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with
   * {@code JsonNode}.
   * <ul>
   *   <li>Then return {@code [[],{"isPublic":true}]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  public void testConvertToDatabaseColumnWithJsonNode_thenReturnIsPublicTrue3() {
    // Arrange
    JsonConverter jsonConverter = new JsonConverter();

    ArrayNode jsonNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    jsonNode.addArray();
    jsonNode.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals("[[],{\"isPublic\":true}]", jsonConverter.convertToDatabaseColumn(jsonNode));
  }

  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with
   * {@code JsonNode}.
   * <ul>
   *   <li>Then return {@code "QVhB"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  public void testConvertToDatabaseColumnWithJsonNode_thenReturnQVhB() throws UnsupportedEncodingException {
    // Arrange
    JsonConverter jsonConverter = new JsonConverter();

    // Act and Assert
    assertEquals("\"QVhB\"", jsonConverter.convertToDatabaseColumn(new BinaryNode("AXAXAXAX".getBytes("UTF-8"), 2, 3)));
  }

  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with
   * {@code JsonNode}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  public void testConvertToDatabaseColumnWithJsonNode_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new JsonConverter()).convertToDatabaseColumn(null));
  }

  /**
   * Test {@link JsonConverter#convertToEntityAttribute(String)} with
   * {@code String}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@link IntNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToEntityAttribute(String)}
   */
  @Test
  public void testConvertToEntityAttributeWithString_when42_thenReturnIntNode() throws IOException {
    // Arrange and Act
    JsonNode actualConvertToEntityAttributeResult = (new JsonConverter()).convertToEntityAttribute("42");

    // Assert
    assertTrue(actualConvertToEntityAttributeResult instanceof IntNode);
    JsonParser traverseResult = actualConvertToEntityAttributeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", actualConvertToEntityAttributeResult.toPrettyString());
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
    assertEquals(0, actualConvertToEntityAttributeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualConvertToEntityAttributeResult.getNodeType());
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
    assertFalse(actualConvertToEntityAttributeResult.isArray());
    assertFalse(actualConvertToEntityAttributeResult.isBigDecimal());
    assertFalse(actualConvertToEntityAttributeResult.isBigInteger());
    assertFalse(actualConvertToEntityAttributeResult.isBinary());
    assertFalse(actualConvertToEntityAttributeResult.isBoolean());
    assertFalse(actualConvertToEntityAttributeResult.isContainerNode());
    assertFalse(actualConvertToEntityAttributeResult.isDouble());
    assertFalse(actualConvertToEntityAttributeResult.isFloat());
    assertFalse(actualConvertToEntityAttributeResult.isFloatingPointNumber());
    assertFalse(actualConvertToEntityAttributeResult.isLong());
    assertFalse(actualConvertToEntityAttributeResult.isMissingNode());
    assertFalse(actualConvertToEntityAttributeResult.isNull());
    assertFalse(actualConvertToEntityAttributeResult.isObject());
    assertFalse(actualConvertToEntityAttributeResult.isPojo());
    assertFalse(actualConvertToEntityAttributeResult.isShort());
    assertFalse(actualConvertToEntityAttributeResult.isTextual());
    assertFalse(((IntNode) actualConvertToEntityAttributeResult).isNaN());
    assertFalse(actualConvertToEntityAttributeResult.iterator().hasNext());
    assertTrue(actualConvertToEntityAttributeResult.isEmpty());
    assertTrue(actualConvertToEntityAttributeResult.isInt());
    assertTrue(actualConvertToEntityAttributeResult.isIntegralNumber());
    assertTrue(actualConvertToEntityAttributeResult.isNumber());
    assertTrue(actualConvertToEntityAttributeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link JsonConverter#convertToEntityAttribute(String)} with
   * {@code String}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToEntityAttribute(String)}
   */
  @Test
  public void testConvertToEntityAttributeWithString_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new JsonConverter()).convertToEntityAttribute(""));
  }

  /**
   * Test {@link JsonConverter#convertToEntityAttribute(String)} with
   * {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToEntityAttribute(String)}
   */
  @Test
  public void testConvertToEntityAttributeWithString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new JsonConverter()).convertToEntityAttribute(null));
  }
}
