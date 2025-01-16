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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.edge.Edge;

class BaseDataWithAdditionalInfoDiffblueTest {
  /**
   * Test {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Edge#Edge(Edge)} with edge is {@link Edge#Edge()}.</li>
   *   <li>Then return {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Edge(Edge) with edge is Edge(); then return instance")
  void testGetAdditionalInfo_givenEdgeWithEdgeIsEdge_thenReturnInstance() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Edge(new Edge())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Edge#Edge(Edge)} with edge is {@link Edge#Edge(Edge)}.</li>
   *   <li>Then return {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Edge(Edge) with edge is Edge(Edge); then return instance")
  void testGetAdditionalInfo_givenEdgeWithEdgeIsEdge_thenReturnInstance2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Edge(new Edge(new Edge()))).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Edge(); then return 'null'")
  void testGetAdditionalInfo_givenEdge_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Edge()).getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  void testSetAdditionalInfo() {
    // Arrange
    Customer customer = new Customer();
    BigIntegerNode addInfo = new BigIntegerNode(BigInteger.valueOf(1L));

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  void testSetAdditionalInfo2() throws UnsupportedEncodingException {
    // Arrange
    Customer customer = new Customer();
    BinaryNode addInfo = new BinaryNode("AXAXAXAX".getBytes("UTF-8"));

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); given 'AXAXAXAX' Bytes is 'UTF-8'")
  void testSetAdditionalInfo_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
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
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <ul>
   *   <li>Given {@link Customer#Customer()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Customer#Customer()} AdditionalInfo {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); given Customer(); when 'null'; then Customer() AdditionalInfo NullNode")
  void testSetAdditionalInfo_givenCustomer_whenNull_thenCustomerAdditionalInfoNullNode() throws IOException {
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
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <ul>
   *   <li>Given Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); given Instance")
  void testSetAdditionalInfo_givenInstance() {
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
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <ul>
   *   <li>Given {@code Pojo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); given 'Pojo'")
  void testSetAdditionalInfo_givenPojo() {
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
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <ul>
   *   <li>Given {@link RawValue#RawValue(String)} with v is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); given RawValue(String) with v is 'foo'")
  void testSetAdditionalInfo_givenRawValueWithVIsFoo() {
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
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <ul>
   *   <li>Then {@link Customer#Customer(Customer)} with customer is
   * {@link Customer#Customer()} AdditionalInfo is Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); then Customer(Customer) with customer is Customer() AdditionalInfo is Instance")
  void testSetAdditionalInfo_thenCustomerWithCustomerIsCustomerAdditionalInfoIsInstance() {
    // Arrange
    Customer customer = new Customer(new Customer());
    MissingNode addInfo = MissingNode.getInstance();

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  void testSetAdditionalInfo_whenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    Customer customer = new Customer();
    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true} addArray.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addArray")
  void testSetAdditionalInfo_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddArray() {
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
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true} addNull.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addNull")
  void testSetAdditionalInfo_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddNull() {
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
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true} addObject.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  void testSetAdditionalInfo_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddObject() {
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
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then {@link Customer#Customer()} AdditionalInfo is Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); when Instance; then Customer() AdditionalInfo is Instance")
  void testSetAdditionalInfo_whenInstance_thenCustomerAdditionalInfoIsInstance() {
    // Arrange
    Customer customer = new Customer();
    MissingNode addInfo = MissingNode.getInstance();

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then {@link Customer#Customer()} AdditionalInfo is Instance
   * {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); when Instance; then Customer() AdditionalInfo is Instance instance")
  void testSetAdditionalInfo_whenInstance_thenCustomerAdditionalInfoIsInstanceInstance() {
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
   * Test
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfoField(String, JsonNode)")
  void testSetAdditionalInfoField() throws IOException {
    // Arrange
    Customer customer = new Customer(new Customer());

    // Act
    customer.setAdditionalInfoField("Field", MissingNode.getInstance());

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
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
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
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
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
  }

  /**
   * Test
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfoField(String, JsonNode)")
  void testSetAdditionalInfoField2() throws IOException {
    // Arrange
    Customer customer = new Customer(new Customer(new Customer()));

    // Act
    customer.setAdditionalInfoField("Field", MissingNode.getInstance());

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
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
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
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
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
  }

  /**
   * Test
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   * <ul>
   *   <li>Then {@link Customer#Customer()} AdditionalInfo iterator next
   * {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfoField(String, JsonNode); then Customer() AdditionalInfo iterator next NullNode")
  void testSetAdditionalInfoField_thenCustomerAdditionalInfoIteratorNextNullNode() throws IOException {
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
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", nextResult.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
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
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
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
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isNull());
    assertTrue(nextResult.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
  }

  /**
   * Test
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then {@link Customer#Customer()} AdditionalInfo {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfoField(String, JsonNode); when Instance; then Customer() AdditionalInfo ObjectNode")
  void testSetAdditionalInfoField_whenInstance_thenCustomerAdditionalInfoObjectNode() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setAdditionalInfoField("Field", MissingNode.getInstance());

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Customer#Customer()} AdditionalInfo {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfoField(String, JsonNode); when 'null'; then Customer() AdditionalInfo ObjectNode")
  void testSetAdditionalInfoField_whenNull_thenCustomerAdditionalInfoObjectNode() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setAdditionalInfoField(null, MissingNode.getInstance());

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test
   * {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}.
   * <ul>
   *   <li>Given {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}
   */
  @Test
  @DisplayName("Test getAdditionalInfoField(String, Function, Object); given Customer()")
  void testGetAdditionalInfoField_givenCustomer() {
    // Arrange, Act and Assert
    assertEquals("Default Value",
        (new Customer()).getAdditionalInfoField("Field", mock(Function.class), "Default Value"));
  }

  /**
   * Test
   * {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}.
   * <ul>
   *   <li>Given {@link Customer#Customer(Customer)} with customer is
   * {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}
   */
  @Test
  @DisplayName("Test getAdditionalInfoField(String, Function, Object); given Customer(Customer) with customer is Customer()")
  void testGetAdditionalInfoField_givenCustomerWithCustomerIsCustomer() {
    // Arrange, Act and Assert
    assertEquals("Default Value",
        (new Customer(new Customer())).getAdditionalInfoField("Field", mock(Function.class), "Default Value"));
    assertEquals("Default Value", (new Customer(new Customer(new Customer()))).getAdditionalInfoField("Field",
        mock(Function.class), "Default Value"));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with 'A' and minus one")
  void testGetJson_givenArrayOfByteWithAAndMinusOne() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@link Byte#MAX_VALUE} and
   * {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with MAX_VALUE and 'X'")
  void testGetJson_givenArrayOfByteWithMax_valueAndX() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with zero and 'X'")
  void testGetJson_givenArrayOfByteWithZeroAndX() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with zero and zero")
  void testGetJson_givenArrayOfByteWithZeroAndZero() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with zero and zero")
  void testGetJson_givenArrayOfByteWithZeroAndZero2() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 0, 0, 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with zero and zero")
  void testGetJson_givenArrayOfByteWithZeroAndZero3() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given 'AXAXAXAX' Bytes is 'UTF-8'")
  void testGetJson_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   *   <li>Then return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given empty array of byte; then return MissingNode")
  void testGetJson_givenEmptyArrayOfByte_thenReturnMissingNode() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    Device device = new Device();
    device.setDeviceDataBytes(new byte[]{});

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes);

    // Assert
    assertTrue(actualJson instanceof MissingNode);
    assertEquals(JsonNodeType.MISSING, actualJson.getNodeType());
    assertFalse(actualJson.isNull());
    assertFalse(actualJson.isValueNode());
    assertTrue(actualJson.isMissingNode());
    assertEquals(DataConstants.DEFAULT_SECRET_KEY, actualJson.toPrettyString());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   * <ul>
   *   <li>When {@link Customer#Customer(Customer)} with customer is
   * {@link Customer#Customer()}.</li>
   *   <li>Then return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); when Customer(Customer) with customer is Customer(); then return NullNode")
  void testGetJson_whenCustomerWithCustomerIsCustomer_thenReturnNullNode() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer(new Customer())::getAdditionalInfo;

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, new Device()::getDeviceDataBytes);

    // Assert
    assertTrue(actualJson instanceof NullNode);
    assertEquals("null", actualJson.toPrettyString());
    assertEquals(JsonNodeType.NULL, actualJson.getNodeType());
    assertFalse(actualJson.isMissingNode());
    assertTrue(actualJson.isNull());
    assertTrue(actualJson.isValueNode());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   * <ul>
   *   <li>When {@link Device#Device()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); when Device(); then return 'null'")
  void testGetJson_whenDevice_thenReturnNull() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, new Device()::getDeviceDataBytes));
  }

  /**
   * Test
   * {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   * <ul>
   *   <li>When {@link ArrayNode}
   * {@link ArrayNode#serialize(JsonGenerator, SerializerProvider)} does
   * nothing.</li>
   *   <li>Then calls
   * {@link ArrayNode#serialize(JsonGenerator, SerializerProvider)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName("Test setJson(JsonNode, Consumer, Consumer); when ArrayNode serialize(JsonGenerator, SerializerProvider) does nothing; then calls serialize(JsonGenerator, SerializerProvider)")
  void testSetJson_whenArrayNodeSerializeDoesNothing_thenCallsSerialize() throws IOException {
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
   * Test
   * {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   * <ul>
   *   <li>When {@link Customer}
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)} does
   * nothing.</li>
   *   <li>Then calls
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName("Test setJson(JsonNode, Consumer, Consumer); when Customer setAdditionalInfo(JsonNode) does nothing; then calls setAdditionalInfo(JsonNode)")
  void testSetJson_whenCustomerSetAdditionalInfoDoesNothing_thenCallsSetAdditionalInfo() throws IOException {
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
