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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.edge.Edge;

class BaseDataWithAdditionalInfoDiffblueTest {
  /**
   * Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new Edge()).getAdditionalInfo());
  }

  /**
   * Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Edge(new Edge())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo3() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Edge(new Edge(new Edge()))).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo() {
    // Arrange
    Customer customer = new Customer();
    MissingNode addInfo = MissingNode.getInstance();

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo2() {
    // Arrange
    Customer customer = new Customer(new Customer());
    MissingNode addInfo = MissingNode.getInstance();

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo3() {
    // Arrange
    Customer customer = new Customer();
    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo4() throws IOException {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setAdditionalInfo(null);

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
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
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo5() {
    // Arrange
    Customer customer = new Customer();
    BigIntegerNode addInfo = new BigIntegerNode(BigInteger.valueOf(1L));

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo6() throws UnsupportedEncodingException {
    // Arrange
    Customer customer = new Customer();
    BinaryNode addInfo = new BinaryNode("AXAXAXAX".getBytes("UTF-8"));

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo7() {
    // Arrange
    Customer customer = new Customer();
    NullNode addInfo = NullNode.getInstance();

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    NullNode expectedAdditionalInfo = addInfo.instance;
    assertSame(expectedAdditionalInfo, customer.getAdditionalInfo());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo8() {
    // Arrange
    Customer customer = new Customer();

    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    addInfo.add(MissingNode.getInstance());

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo9() {
    // Arrange
    Customer customer = new Customer();

    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    addInfo.addArray();
    addInfo.add(MissingNode.getInstance());

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo10() {
    // Arrange
    Customer customer = new Customer();

    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    addInfo.addObject();
    addInfo.add(MissingNode.getInstance());

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo11() {
    // Arrange
    Customer customer = new Customer();

    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    addInfo.addPOJO("Pojo");
    addInfo.add(MissingNode.getInstance());

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo12() {
    // Arrange
    Customer customer = new Customer();

    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    addInfo.addRawValue(new RawValue("foo"));
    addInfo.add(MissingNode.getInstance());

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo13() {
    // Arrange
    Customer customer = new Customer();

    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    addInfo.addNull();
    addInfo.add(MissingNode.getInstance());

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  void testSetAdditionalInfo14() throws UnsupportedEncodingException {
    // Arrange
    Customer customer = new Customer();

    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    addInfo.add("AXAXAXAX".getBytes("UTF-8"));
    addInfo.add(MissingNode.getInstance());

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}
   */
  @Test
  void testSetAdditionalInfoField() throws IOException {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setAdditionalInfoField("Field", null);

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", nextResult.toPrettyString());
    assertEquals("{\n  \"Field\" : null\n}", additionalInfo.toPrettyString());
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
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
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
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0.0d, traverseResult2.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
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
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isNull());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}
   */
  @Test
  void testGetAdditionalInfoField() {
    // Arrange, Act and Assert
    assertEquals("Default Value",
        (new Customer()).getAdditionalInfoField("Field", mock(Function.class), "Default Value"));
    assertEquals("Default Value",
        (new Customer(new Customer())).getAdditionalInfoField("Field", mock(Function.class), "Default Value"));
    assertEquals("Default Value", (new Customer(new Customer(new Customer()))).getAdditionalInfoField("Field",
        mock(Function.class), "Default Value"));
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  void testGetJson() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, new Device()::getDeviceDataBytes));
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  void testGetJson2() throws IOException {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer(new Customer())::getAdditionalInfo;

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, new Device()::getDeviceDataBytes);

    // Assert
    assertTrue(actualJson instanceof NullNode);
    JsonParser traverseResult = actualJson.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", actualJson.toPrettyString());
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
    assertEquals(0, actualJson.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, actualJson.getNodeType());
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
    assertFalse(actualJson.isArray());
    assertFalse(actualJson.isBigDecimal());
    assertFalse(actualJson.isBigInteger());
    assertFalse(actualJson.isBinary());
    assertFalse(actualJson.isBoolean());
    assertFalse(actualJson.isContainerNode());
    assertFalse(actualJson.isDouble());
    assertFalse(actualJson.isFloat());
    assertFalse(actualJson.isFloatingPointNumber());
    assertFalse(actualJson.isInt());
    assertFalse(actualJson.isIntegralNumber());
    assertFalse(actualJson.isLong());
    assertFalse(actualJson.isMissingNode());
    assertFalse(actualJson.isNumber());
    assertFalse(actualJson.isObject());
    assertFalse(actualJson.isPojo());
    assertFalse(actualJson.isShort());
    assertFalse(actualJson.isTextual());
    assertFalse(actualJson.iterator().hasNext());
    assertTrue(actualJson.isEmpty());
    assertTrue(actualJson.isNull());
    assertTrue(actualJson.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  void testGetJson3() throws UnsupportedEncodingException {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  void testGetJson4() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  void testGetJson5() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  void testGetJson6() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  void testGetJson7() throws IOException {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{});

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes);

    // Assert
    assertTrue(actualJson instanceof MissingNode);
    JsonParser traverseResult = actualJson.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
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
    assertEquals(0, actualJson.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.MISSING, actualJson.getNodeType());
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
    assertFalse(actualJson.isArray());
    assertFalse(actualJson.isBigDecimal());
    assertFalse(actualJson.isBigInteger());
    assertFalse(actualJson.isBinary());
    assertFalse(actualJson.isBoolean());
    assertFalse(actualJson.isContainerNode());
    assertFalse(actualJson.isDouble());
    assertFalse(actualJson.isFloat());
    assertFalse(actualJson.isFloatingPointNumber());
    assertFalse(actualJson.isInt());
    assertFalse(actualJson.isIntegralNumber());
    assertFalse(actualJson.isLong());
    assertFalse(actualJson.isNull());
    assertFalse(actualJson.isNumber());
    assertFalse(actualJson.isObject());
    assertFalse(actualJson.isPojo());
    assertFalse(actualJson.isShort());
    assertFalse(actualJson.isTextual());
    assertFalse(actualJson.isValueNode());
    assertFalse(actualJson.iterator().hasNext());
    assertTrue(actualJson.isEmpty());
    assertTrue(actualJson.isMissingNode());
    assertEquals(DataConstants.DEFAULT_SECRET_KEY, actualJson.toPrettyString());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  void testGetJson8() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  void testGetJson9() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 0, 0, 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  void testGetJson10() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  void testSetJson() throws IOException {
    // Arrange
    ArrayNode json = mock(ArrayNode.class);
    doNothing().when(json).serialize(Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    Consumer<JsonNode> jsonConsumer = new Customer()::setAdditionalInfo;

    // Act
    BaseDataWithAdditionalInfo.setJson(json, jsonConsumer, new Device()::setDeviceDataBytes);

    // Assert
    verify(json, atLeast(1)).serialize(Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
  }

  /**
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  void testSetJson2() throws IOException {
    // Arrange
    ArrayNode json = mock(ArrayNode.class);
    doNothing().when(json).serialize(Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    Customer customer = mock(Customer.class);
    doNothing().when(customer).setAdditionalInfo(Mockito.<JsonNode>any());
    Consumer<JsonNode> jsonConsumer = customer::setAdditionalInfo;

    // Act
    BaseDataWithAdditionalInfo.setJson(json, jsonConsumer, new Device()::setDeviceDataBytes);

    // Assert
    verify(json).serialize(isA(JsonGenerator.class), isA(SerializerProvider.class));
    verify(customer).setAdditionalInfo(isA(JsonNode.class));
  }
}
