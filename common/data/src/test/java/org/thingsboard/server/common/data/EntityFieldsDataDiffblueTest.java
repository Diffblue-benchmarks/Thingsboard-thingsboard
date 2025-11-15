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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityFieldsDataDiffblueTest {
  /**
   * Test {@link EntityFieldsData#equals(Object)}, and {@link EntityFieldsData#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
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
   * Test {@link EntityFieldsData#equals(Object)}, and {@link EntityFieldsData#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(ObjectNode)", "ObjectNode EntityFieldsData.getFieldsData()",
      "void EntityFieldsData.setFieldsData(ObjectNode)", "String EntityFieldsData.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntityFieldsData actualEntityFieldsData = new EntityFieldsData(
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
    ObjectNode fieldsData = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    actualEntityFieldsData.setFieldsData(fieldsData);
    String actualToStringResult = actualEntityFieldsData.toString();

    // Assert
    assertEquals("EntityFieldsData(fieldsData={})", actualToStringResult);
    assertSame(fieldsData, actualEntityFieldsData.getFieldsData());
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenArrayOfByteWithAAndMinusOne() {
    // Arrange
    Device data = new Device();
    data.setDeviceDataBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(data)).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals("{\n" + "  \"id\" : null,\n" + "  \"createdTime\" : 0,\n" + "  \"tenantId\" : null,\n"
        + "  \"customerId\" : null,\n" + "  \"name\" : null,\n" + "  \"type\" : null,\n" + "  \"label\" : null,\n"
        + "  \"deviceProfileId\" : null,\n" + "  \"deviceDataBytes\" : \"Qf9BWEFYQVg=\",\n"
        + "  \"firmwareId\" : null,\n" + "  \"softwareId\" : null,\n" + "  \"externalId\" : null,\n"
        + "  \"version\" : null,\n" + "  \"additionalInfo\" : null,\n" + "  \"deviceData\" : null,\n"
        + "  \"uuidId\" : null\n" + "}", fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertEquals(Short.SIZE, fieldsData.size());
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given array of byte with MAX_VALUE and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenArrayOfByteWithMax_valueAndX() {
    // Arrange
    Device data = new Device();
    data.setDeviceDataBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(data)).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals("{\n" + "  \"id\" : null,\n" + "  \"createdTime\" : 0,\n" + "  \"tenantId\" : null,\n"
        + "  \"customerId\" : null,\n" + "  \"name\" : null,\n" + "  \"type\" : null,\n" + "  \"label\" : null,\n"
        + "  \"deviceProfileId\" : null,\n" + "  \"deviceDataBytes\" : \"f1hBWEFYQVg=\",\n"
        + "  \"firmwareId\" : null,\n" + "  \"softwareId\" : null,\n" + "  \"externalId\" : null,\n"
        + "  \"version\" : null,\n" + "  \"additionalInfo\" : null,\n" + "  \"deviceData\" : null,\n"
        + "  \"uuidId\" : null\n" + "}", fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertEquals(Short.SIZE, fieldsData.size());
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenArrayOfByteWithZeroAndX() {
    // Arrange
    Device data = new Device();
    data.setDeviceDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(data)).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals("{\n" + "  \"id\" : null,\n" + "  \"createdTime\" : 0,\n" + "  \"tenantId\" : null,\n"
        + "  \"customerId\" : null,\n" + "  \"name\" : null,\n" + "  \"type\" : null,\n" + "  \"label\" : null,\n"
        + "  \"deviceProfileId\" : null,\n" + "  \"deviceDataBytes\" : \"AFhBWEFYQVg=\",\n"
        + "  \"firmwareId\" : null,\n" + "  \"softwareId\" : null,\n" + "  \"externalId\" : null,\n"
        + "  \"version\" : null,\n" + "  \"additionalInfo\" : null,\n" + "  \"deviceData\" : null,\n"
        + "  \"uuidId\" : null\n" + "}", fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertEquals(Short.SIZE, fieldsData.size());
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenArrayOfByteWithZeroAndZero() {
    // Arrange
    Device data = new Device();
    data.setDeviceDataBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(data)).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals("{\n" + "  \"id\" : null,\n" + "  \"createdTime\" : 0,\n" + "  \"tenantId\" : null,\n"
        + "  \"customerId\" : null,\n" + "  \"name\" : null,\n" + "  \"type\" : null,\n" + "  \"label\" : null,\n"
        + "  \"deviceProfileId\" : null,\n" + "  \"deviceDataBytes\" : \"AABBWEFYQVg=\",\n"
        + "  \"firmwareId\" : null,\n" + "  \"softwareId\" : null,\n" + "  \"externalId\" : null,\n"
        + "  \"version\" : null,\n" + "  \"additionalInfo\" : null,\n" + "  \"deviceData\" : null,\n"
        + "  \"uuidId\" : null\n" + "}", fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertEquals(Short.SIZE, fieldsData.size());
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenArrayOfByteWithZeroAndZero2() {
    // Arrange
    Device data = new Device();
    data.setDeviceDataBytes(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(data)).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals("{\n" + "  \"id\" : null,\n" + "  \"createdTime\" : 0,\n" + "  \"tenantId\" : null,\n"
        + "  \"customerId\" : null,\n" + "  \"name\" : null,\n" + "  \"type\" : null,\n" + "  \"label\" : null,\n"
        + "  \"deviceProfileId\" : null,\n" + "  \"deviceDataBytes\" : \"AABBAEFYQVg=\",\n"
        + "  \"firmwareId\" : null,\n" + "  \"softwareId\" : null,\n" + "  \"externalId\" : null,\n"
        + "  \"version\" : null,\n" + "  \"additionalInfo\" : null,\n" + "  \"deviceData\" : null,\n"
        + "  \"uuidId\" : null\n" + "}", fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertEquals(Short.SIZE, fieldsData.size());
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] deviceDataBytes = "AXAXAXAX".getBytes("UTF-8");

    Device data = new Device();
    data.setDeviceDataBytes(deviceDataBytes);

    // Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(data)).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals("{\n" + "  \"id\" : null,\n" + "  \"createdTime\" : 0,\n" + "  \"tenantId\" : null,\n"
        + "  \"customerId\" : null,\n" + "  \"name\" : null,\n" + "  \"type\" : null,\n" + "  \"label\" : null,\n"
        + "  \"deviceProfileId\" : null,\n" + "  \"deviceDataBytes\" : \"QVhBWEFYQVg=\",\n"
        + "  \"firmwareId\" : null,\n" + "  \"softwareId\" : null,\n" + "  \"externalId\" : null,\n"
        + "  \"version\" : null,\n" + "  \"additionalInfo\" : null,\n" + "  \"deviceData\" : null,\n"
        + "  \"uuidId\" : null\n" + "}", fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertEquals(Short.SIZE, fieldsData.size());
    assertSame(expectedNextResult, actualNextResult);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenDefault_secret_key() {
    // Arrange
    AdminSettings data = new AdminSettings();
    data.setKey(DataConstants.DEFAULT_SECRET_KEY);

    // Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(data)).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals("{\n" + "  \"id\" : null,\n" + "  \"createdTime\" : 0,\n" + "  \"tenantId\" : null,\n"
        + "  \"key\" : \"\",\n" + "  \"jsonValue\" : null,\n" + "  \"uuidId\" : null\n" + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenEmptyArrayOfByte() {
    // Arrange
    Device data = new Device();
    data.setDeviceDataBytes(new byte[]{});

    // Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(data)).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n" + "  \"id\" : null,\n" + "  \"createdTime\" : 0,\n" + "  \"tenantId\" : null,\n"
            + "  \"customerId\" : null,\n" + "  \"name\" : null,\n" + "  \"type\" : null,\n" + "  \"label\" : null,\n"
            + "  \"deviceProfileId\" : null,\n" + "  \"deviceDataBytes\" : \"\",\n" + "  \"firmwareId\" : null,\n"
            + "  \"softwareId\" : null,\n" + "  \"externalId\" : null,\n" + "  \"version\" : null,\n"
            + "  \"additionalInfo\" : null,\n" + "  \"deviceData\" : null,\n" + "  \"uuidId\" : null\n" + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertEquals(Short.SIZE, fieldsData.size());
    assertSame(expectedNextResult, actualNextResult);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenInstance_whenAdminSettingsJsonValueIsInstance() {
    // Arrange
    AdminSettings data = new AdminSettings();
    data.setJsonValue(MissingNode.getInstance());

    // Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(data)).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals("{\n" + "  \"id\" : null,\n" + "  \"createdTime\" : 0,\n" + "  \"tenantId\" : null,\n"
        + "  \"key\" : null,\n" + "  \"jsonValue\" : null,\n" + "  \"uuidId\" : null\n" + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenKey_whenAdminSettingsKeyIsKey() {
    // Arrange
    AdminSettings data = new AdminSettings();
    data.setKey("Key");

    // Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(data)).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n" + "  \"id\" : null,\n" + "  \"createdTime\" : 0,\n" + "  \"tenantId\" : null,\n"
            + "  \"key\" : \"Key\",\n" + "  \"jsonValue\" : null,\n" + "  \"uuidId\" : null\n" + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>When {@link AdminSettings#AdminSettings()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); when AdminSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_whenAdminSettings() {
    // Arrange, Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(new AdminSettings())).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals("{\n" + "  \"id\" : null,\n" + "  \"createdTime\" : 0,\n" + "  \"tenantId\" : null,\n"
        + "  \"key\" : null,\n" + "  \"jsonValue\" : null,\n" + "  \"uuidId\" : null\n" + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   * <ul>
   *   <li>When {@link Device#Device()}.</li>
   *   <li>Then return FieldsData size is {@link Short#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); when Device(); then return FieldsData size is SIZE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_whenDevice_thenReturnFieldsDataSizeIsSize() {
    // Arrange, Act and Assert
    ObjectNode fieldsData = (new EntityFieldsData(new Device())).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n" + "  \"id\" : null,\n" + "  \"createdTime\" : 0,\n" + "  \"tenantId\" : null,\n"
            + "  \"customerId\" : null,\n" + "  \"name\" : null,\n" + "  \"type\" : null,\n" + "  \"label\" : null,\n"
            + "  \"deviceProfileId\" : null,\n" + "  \"deviceDataBytes\" : null,\n" + "  \"firmwareId\" : null,\n"
            + "  \"softwareId\" : null,\n" + "  \"externalId\" : null,\n" + "  \"version\" : null,\n"
            + "  \"additionalInfo\" : null,\n" + "  \"deviceData\" : null,\n" + "  \"uuidId\" : null\n" + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertEquals(Short.SIZE, fieldsData.size());
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code ignoreNullStrings}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName("Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String)"})
  void testGetFieldValueWithField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)))).getFieldValue("Field"));
  }
}
