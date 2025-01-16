package org.thingsboard.server.common.data;

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
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AdminSettingsId;

class EntityFieldsDataDiffblueTest {
  /**
   * Test {@link EntityFieldsData#equals(Object)}, and
   * {@link EntityFieldsData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFieldsData#equals(Object)}
   *   <li>{@link EntityFieldsData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityFieldsData entityFieldsData = new EntityFieldsData(
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
    EntityFieldsData entityFieldsData2 = new EntityFieldsData(
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertEquals(entityFieldsData, entityFieldsData2);
    int expectedHashCodeResult = entityFieldsData.hashCode();
    assertEquals(expectedHashCodeResult, entityFieldsData2.hashCode());
  }

  /**
   * Test {@link EntityFieldsData#equals(Object)}, and
   * {@link EntityFieldsData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFieldsData#equals(Object)}
   *   <li>{@link EntityFieldsData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityFieldsData entityFieldsData = new EntityFieldsData(new ObjectNode(mock(JsonNodeFactory.class)));
    EntityFieldsData entityFieldsData2 = new EntityFieldsData(
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertEquals(entityFieldsData, entityFieldsData2);
    int expectedHashCodeResult = entityFieldsData.hashCode();
    assertEquals(expectedHashCodeResult, entityFieldsData2.hashCode());
  }

  /**
   * Test {@link EntityFieldsData#equals(Object)}, and
   * {@link EntityFieldsData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFieldsData#equals(Object)}
   *   <li>{@link EntityFieldsData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityFieldsData entityFieldsData = new EntityFieldsData(
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertEquals(entityFieldsData, entityFieldsData);
    int expectedHashCodeResult = entityFieldsData.hashCode();
    assertEquals(expectedHashCodeResult, entityFieldsData.hashCode());
  }

  /**
   * Test {@link EntityFieldsData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityFieldsData entityFieldsData = new EntityFieldsData((ObjectNode) null);

    // Act and Assert
    assertNotEquals(entityFieldsData, new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Test {@link EntityFieldsData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ObjectNode fieldsData = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    fieldsData.put("Property Name", MissingNode.getInstance());
    EntityFieldsData entityFieldsData = new EntityFieldsData(fieldsData);

    // Act and Assert
    assertNotEquals(entityFieldsData, new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Test {@link EntityFieldsData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))), null);
  }

  /**
   * Test {@link EntityFieldsData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))),
        "Different type to EntityFieldsData");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFieldsData#EntityFieldsData(ObjectNode)}
   *   <li>{@link EntityFieldsData#setFieldsData(ObjectNode)}
   *   <li>{@link EntityFieldsData#toString()}
   *   <li>{@link EntityFieldsData#getFieldsData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    EntityFieldsData actualEntityFieldsData = new EntityFieldsData(
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
    ObjectNode fieldsData = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    actualEntityFieldsData.setFieldsData(fieldsData);
    String actualToStringResult = actualEntityFieldsData.toString();

    // Assert that nothing has changed
    assertEquals("EntityFieldsData(fieldsData={})", actualToStringResult);
    assertSame(fieldsData, actualEntityFieldsData.getFieldsData());
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>Given {@link DataConstants#DEFAULT_SECRET_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given DEFAULT_SECRET_KEY")
  void testNewEntityFieldsData_givenDefault_secret_key() {
    // Arrange
    AdminSettings data = new AdminSettings();
    data.setKey(DataConstants.DEFAULT_SECRET_KEY);

    // Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(data)).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult2 instanceof LongNode);
    assertTrue(nextResult instanceof NullNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\r\n" + "  \"id\" : null,\r\n" + "  \"createdTime\" : 0,\r\n" + "  \"tenantId\" : null,\r\n"
            + "  \"key\" : \"\",\r\n" + "  \"jsonValue\" : null,\r\n" + "  \"uuidId\" : null\r\n" + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(nextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link AdminSettings#AdminSettings()} JsonValue is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given Instance; when AdminSettings() JsonValue is Instance")
  void testNewEntityFieldsData_givenInstance_whenAdminSettingsJsonValueIsInstance() {
    // Arrange
    AdminSettings data = new AdminSettings();
    data.setJsonValue(MissingNode.getInstance());

    // Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(data)).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult2 instanceof LongNode);
    assertTrue(nextResult instanceof NullNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\r\n" + "  \"id\" : null,\r\n" + "  \"createdTime\" : 0,\r\n" + "  \"tenantId\" : null,\r\n"
            + "  \"key\" : null,\r\n" + "  \"jsonValue\" : null,\r\n" + "  \"uuidId\" : null\r\n" + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(nextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>Given {@code Key}.</li>
   *   <li>When {@link AdminSettings#AdminSettings()} Key is {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given 'Key'; when AdminSettings() Key is 'Key'")
  void testNewEntityFieldsData_givenKey_whenAdminSettingsKeyIsKey() {
    // Arrange
    AdminSettings data = new AdminSettings();
    data.setKey("Key");

    // Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(data)).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult2 instanceof LongNode);
    assertTrue(nextResult instanceof NullNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\r\n" + "  \"id\" : null,\r\n" + "  \"createdTime\" : 0,\r\n" + "  \"tenantId\" : null,\r\n"
            + "  \"key\" : \"Key\",\r\n" + "  \"jsonValue\" : null,\r\n" + "  \"uuidId\" : null\r\n" + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(nextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>Then FieldsData iterator next return {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); then FieldsData iterator next return ObjectNode")
  void testNewEntityFieldsData_thenFieldsDataIteratorNextReturnObjectNode() throws IOException {
    // Arrange, Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(
        new AdminSettings(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))))
        .getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    JsonNode nextResult3 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult2 instanceof LongNode);
    assertTrue(nextResult3 instanceof NullNode);
    assertTrue(nextResult instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = nextResult.iterator();
    JsonNode nextResult4 = iteratorResult2.next();
    assertTrue(nextResult4 instanceof TextNode);
    JsonParser traverseResult = nextResult4.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult3.traverse() instanceof TreeTraversingParser);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"784f394c-42b6-435a-983c-b7beff2784f9\"", nextResult4.toPrettyString());
    assertEquals("null", nextResult3.toPrettyString());
    assertEquals("{\r\n  \"id\" : \"784f394c-42b6-435a-983c-b7beff2784f9\"\r\n}", nextResult.toPrettyString());
    assertEquals(
        "{\r\n" + "  \"id\" : {\r\n" + "    \"id\" : \"784f394c-42b6-435a-983c-b7beff2784f9\"\r\n" + "  },\r\n"
            + "  \"createdTime\" : 0,\r\n" + "  \"tenantId\" : null,\r\n" + "  \"key\" : null,\r\n"
            + "  \"jsonValue\" : null,\r\n" + "  \"uuidId\" : \"784f394c-42b6-435a-983c-b7beff2784f9\"\r\n" + "}",
        fieldsData.toPrettyString());
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
    assertEquals(0, nextResult4.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, nextResult.size());
    assertEquals(JsonNodeType.NULL, nextResult3.getNodeType());
    assertEquals(JsonNodeType.OBJECT, nextResult.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult4.getNodeType());
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
    assertFalse(nextResult4.isArray());
    assertFalse(nextResult4.isBigDecimal());
    assertFalse(nextResult4.isBigInteger());
    assertFalse(nextResult4.isBinary());
    assertFalse(nextResult4.isBoolean());
    assertFalse(nextResult4.isContainerNode());
    assertFalse(nextResult4.isDouble());
    assertFalse(nextResult.isEmpty());
    assertFalse(nextResult4.isFloat());
    assertFalse(nextResult4.isFloatingPointNumber());
    assertFalse(nextResult4.isInt());
    assertFalse(nextResult4.isIntegralNumber());
    assertFalse(nextResult4.isLong());
    assertFalse(nextResult4.isMissingNode());
    assertFalse(nextResult4.isNull());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult4.isNumber());
    assertFalse(nextResult4.isObject());
    assertFalse(nextResult4.isPojo());
    assertFalse(nextResult4.isShort());
    assertFalse(nextResult3.isTextual());
    assertFalse(nextResult.isValueNode());
    assertFalse(iteratorResult2.hasNext());
    assertFalse(nextResult2.iterator().hasNext());
    assertTrue(nextResult.isContainerNode());
    assertTrue(nextResult4.isEmpty());
    assertTrue(nextResult3.isNull());
    assertTrue(nextResult.isObject());
    assertTrue(nextResult4.isTextual());
    assertTrue(nextResult4.isValueNode());
    assertTrue(actualHasNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>When {@link AdminSettings#AdminSettings()}.</li>
   *   <li>Then return FieldsData iterator next.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); when AdminSettings(); then return FieldsData iterator next")
  void testNewEntityFieldsData_whenAdminSettings_thenReturnFieldsDataIteratorNext() {
    // Arrange, Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(new AdminSettings())).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult2 instanceof LongNode);
    assertTrue(nextResult instanceof NullNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\r\n" + "  \"id\" : null,\r\n" + "  \"createdTime\" : 0,\r\n" + "  \"tenantId\" : null,\r\n"
            + "  \"key\" : null,\r\n" + "  \"jsonValue\" : null,\r\n" + "  \"uuidId\" : null\r\n" + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(nextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>When {@link Customer#Customer()}.</li>
   *   <li>Then return FieldsData size is eighteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); when Customer(); then return FieldsData size is eighteen")
  void testNewEntityFieldsData_whenCustomer_thenReturnFieldsDataSizeIsEighteen() {
    // Arrange, Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(new Customer())).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult2 instanceof LongNode);
    assertTrue(nextResult instanceof NullNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\r\n" + "  \"id\" : null,\r\n" + "  \"createdTime\" : 0,\r\n" + "  \"country\" : null,\r\n"
            + "  \"state\" : null,\r\n" + "  \"city\" : null,\r\n" + "  \"address\" : null,\r\n"
            + "  \"address2\" : null,\r\n" + "  \"zip\" : null,\r\n" + "  \"phone\" : null,\r\n"
            + "  \"email\" : null,\r\n" + "  \"title\" : null,\r\n" + "  \"tenantId\" : null,\r\n"
            + "  \"externalId\" : null,\r\n" + "  \"version\" : null,\r\n" + "  \"name\" : null,\r\n"
            + "  \"public\" : false,\r\n" + "  \"additionalInfo\" : null,\r\n" + "  \"uuidId\" : null\r\n" + "}",
        fieldsData.toPrettyString());
    assertEquals(18, fieldsData.size());
    assertTrue(actualHasNextResult);
    assertSame(nextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with
   * {@code field}, {@code ignoreNullStrings}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName("Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'; then return 'null'")
  void testGetFieldValueWithFieldIgnoreNullStrings_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)))).getFieldValue("Field",
        true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String)} with {@code field}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#getFieldValue(String)}
   */
  @Test
  @DisplayName("Test getFieldValue(String) with 'field'; then return 'null'")
  void testGetFieldValueWithField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)))).getFieldValue("Field"));
  }
}
