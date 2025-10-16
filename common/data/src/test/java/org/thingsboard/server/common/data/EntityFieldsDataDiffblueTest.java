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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;

class EntityFieldsDataDiffblueTest {
  /**
   * Test {@link EntityFieldsData#equals(Object)}, and {@link EntityFieldsData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityFieldsData#equals(Object)}
   *   <li>{@link EntityFieldsData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode fieldsData = new ObjectNode(nc);
    EntityFieldsData entityFieldsData = new EntityFieldsData(fieldsData);
    JsonNodeFactory nc2 = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode fieldsData2 = new ObjectNode(nc2);
    EntityFieldsData entityFieldsData2 = new EntityFieldsData(fieldsData2);

    // Act and Assert
    assertEquals(entityFieldsData, entityFieldsData2);
    assertEquals(entityFieldsData.hashCode(), entityFieldsData2.hashCode());
  }

  /**
   * Test {@link EntityFieldsData#equals(Object)}, and {@link EntityFieldsData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityFieldsData#equals(Object)}
   *   <li>{@link EntityFieldsData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityFieldsData entityFieldsData = new EntityFieldsData((ObjectNode) null);
    EntityFieldsData entityFieldsData2 = new EntityFieldsData((ObjectNode) null);

    // Act and Assert
    assertEquals(entityFieldsData, entityFieldsData2);
    assertEquals(entityFieldsData.hashCode(), entityFieldsData2.hashCode());
  }

  /**
   * Test {@link EntityFieldsData#equals(Object)}, and {@link EntityFieldsData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityFieldsData#equals(Object)}
   *   <li>{@link EntityFieldsData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode fieldsData = new ObjectNode(nc);
    EntityFieldsData entityFieldsData = new EntityFieldsData(fieldsData);

    // Act and Assert
    assertEquals(entityFieldsData, entityFieldsData);
    int expectedHashCodeResult = entityFieldsData.hashCode();
    assertEquals(expectedHashCodeResult, entityFieldsData.hashCode());
  }

  /**
   * Test {@link EntityFieldsData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityFieldsData entityFieldsData = new EntityFieldsData((ObjectNode) null);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode fieldsData = new ObjectNode(nc);

    // Act and Assert
    assertNotEquals(entityFieldsData, new EntityFieldsData(fieldsData));
  }

  /**
   * Test {@link EntityFieldsData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.put("Property Name", DoubleNode.valueOf(10.0d));
    EntityFieldsData entityFieldsData = new EntityFieldsData(fieldsData);
    JsonNodeFactory nc2 = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode fieldsData2 = new ObjectNode(nc2);

    // Act and Assert
    assertNotEquals(entityFieldsData, new EntityFieldsData(fieldsData2));
  }

  /**
   * Test {@link EntityFieldsData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode fieldsData = new ObjectNode(nc);

    // Act and Assert
    assertNotEquals(new EntityFieldsData(fieldsData), null);
  }

  /**
   * Test {@link EntityFieldsData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode fieldsData = new ObjectNode(nc);

    // Act and Assert
    assertNotEquals(new EntityFieldsData(fieldsData), "Different type to EntityFieldsData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityFieldsData#EntityFieldsData(ObjectNode)}
   *   <li>{@link EntityFieldsData#setFieldsData(ObjectNode)}
   *   <li>{@link EntityFieldsData#toString()}
   *   <li>{@link EntityFieldsData#getFieldsData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityFieldsData.<init>(ObjectNode)",
    "ObjectNode EntityFieldsData.getFieldsData()",
    "void EntityFieldsData.setFieldsData(ObjectNode)",
    "String EntityFieldsData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode fieldsData = new ObjectNode(nc);

    // Act
    EntityFieldsData actualEntityFieldsData = new EntityFieldsData(fieldsData);
    JsonNodeFactory nc2 = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode fieldsData2 = new ObjectNode(nc2);
    actualEntityFieldsData.setFieldsData(fieldsData2);
    String actualToStringResult = actualEntityFieldsData.toString();

    // Assert
    assertEquals("EntityFieldsData(fieldsData={})", actualToStringResult);
    assertSame(fieldsData2, actualEntityFieldsData.getFieldsData());
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData() {
    // Arrange
    Dashboard data = new Dashboard();

    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    ShortCustomerInfo shortCustomerInfo =
        new ShortCustomerInfo(
            new CustomerId(EntityId.NULL_UUID), DataConstants.DEFAULT_SECRET_KEY, true);
    assignedCustomers.add(shortCustomerInfo);
    data.setAssignedCustomers(assignedCustomers);

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"title\" : null,\n"
            + "  \"image\" : null,\n"
            + "  \"assignedCustomers\" : [ {\n"
            + "    \"customerId\" : \"13814000-1dd2-11b2-8080-808080808080\",\n"
            + "    \"title\" : \"\",\n"
            + "    \"public\" : true\n"
            + "  } ],\n"
            + "  \"mobileHide\" : false,\n"
            + "  \"mobileOrder\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"configuration\" : null,\n"
            + "  \"entityAliasesConfig\" : [ ],\n"
            + "  \"widgetsConfig\" : [ ],\n"
            + "  \"name\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertEquals(15, fieldsData.size());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData2() {
    // Arrange
    Device data = new Device(new Device());
    data.setDeviceDataBytes(new byte[] {});

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"customerId\" : null,\n"
            + "  \"name\" : null,\n"
            + "  \"type\" : null,\n"
            + "  \"label\" : null,\n"
            + "  \"deviceProfileId\" : null,\n"
            + "  \"deviceDataBytes\" : \"\",\n"
            + "  \"firmwareId\" : null,\n"
            + "  \"softwareId\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"additionalInfo\" : null,\n"
            + "  \"deviceData\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData3() {
    // Arrange
    Device data = new Device(new Device());
    data.setDeviceDataBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"customerId\" : null,\n"
            + "  \"name\" : null,\n"
            + "  \"type\" : null,\n"
            + "  \"label\" : null,\n"
            + "  \"deviceProfileId\" : null,\n"
            + "  \"deviceDataBytes\" : \"AFhBWEFYQVg=\",\n"
            + "  \"firmwareId\" : null,\n"
            + "  \"softwareId\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"additionalInfo\" : null,\n"
            + "  \"deviceData\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given array of byte with 'A' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenArrayOfByteWithAAndMinusOne() {
    // Arrange
    Device data = new Device();
    data.setDeviceDataBytes(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"customerId\" : null,\n"
            + "  \"name\" : null,\n"
            + "  \"type\" : null,\n"
            + "  \"label\" : null,\n"
            + "  \"deviceProfileId\" : null,\n"
            + "  \"deviceDataBytes\" : \"Qf9BWEFYQVg=\",\n"
            + "  \"firmwareId\" : null,\n"
            + "  \"softwareId\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"additionalInfo\" : null,\n"
            + "  \"deviceData\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given array of byte with MAX_VALUE and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenArrayOfByteWithMax_valueAndX() {
    // Arrange
    Device data = new Device();
    data.setDeviceDataBytes(new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"customerId\" : null,\n"
            + "  \"name\" : null,\n"
            + "  \"type\" : null,\n"
            + "  \"label\" : null,\n"
            + "  \"deviceProfileId\" : null,\n"
            + "  \"deviceDataBytes\" : \"f1hBWEFYQVg=\",\n"
            + "  \"firmwareId\" : null,\n"
            + "  \"softwareId\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"additionalInfo\" : null,\n"
            + "  \"deviceData\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given array of byte with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenArrayOfByteWithZeroAndZero() {
    // Arrange
    Device data = new Device();
    data.setDeviceDataBytes(new byte[] {0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"customerId\" : null,\n"
            + "  \"name\" : null,\n"
            + "  \"type\" : null,\n"
            + "  \"label\" : null,\n"
            + "  \"deviceProfileId\" : null,\n"
            + "  \"deviceDataBytes\" : \"AABBWEFYQVg=\",\n"
            + "  \"firmwareId\" : null,\n"
            + "  \"softwareId\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"additionalInfo\" : null,\n"
            + "  \"deviceData\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given array of byte with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenArrayOfByteWithZeroAndZero2() {
    // Arrange
    Device data = new Device();
    data.setDeviceDataBytes(new byte[] {0, 0, 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"customerId\" : null,\n"
            + "  \"name\" : null,\n"
            + "  \"type\" : null,\n"
            + "  \"label\" : null,\n"
            + "  \"deviceProfileId\" : null,\n"
            + "  \"deviceDataBytes\" : \"AABBAEFYQVg=\",\n"
            + "  \"firmwareId\" : null,\n"
            + "  \"softwareId\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"additionalInfo\" : null,\n"
            + "  \"deviceData\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] deviceDataBytes = "AXAXAXAX".getBytes("UTF-8");

    Device data = new Device();
    data.setDeviceDataBytes(deviceDataBytes);

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"customerId\" : null,\n"
            + "  \"name\" : null,\n"
            + "  \"type\" : null,\n"
            + "  \"label\" : null,\n"
            + "  \"deviceProfileId\" : null,\n"
            + "  \"deviceDataBytes\" : \"QVhBWEFYQVg=\",\n"
            + "  \"firmwareId\" : null,\n"
            + "  \"softwareId\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"additionalInfo\" : null,\n"
            + "  \"deviceData\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given {@link CustomerId#CustomerId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given CustomerId(UUID) with id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenCustomerIdWithIdIsNull() {
    // Arrange
    Dashboard data = new Dashboard();

    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(new CustomerId(null), "Dr", true);
    assignedCustomers.add(shortCustomerInfo);
    data.setAssignedCustomers(assignedCustomers);

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"title\" : null,\n"
            + "  \"image\" : null,\n"
            + "  \"assignedCustomers\" : [ {\n"
            + "    \"customerId\" : null,\n"
            + "    \"title\" : \"Dr\",\n"
            + "    \"public\" : true\n"
            + "  } ],\n"
            + "  \"mobileHide\" : false,\n"
            + "  \"mobileOrder\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"configuration\" : null,\n"
            + "  \"entityAliasesConfig\" : [ ],\n"
            + "  \"widgetsConfig\" : [ ],\n"
            + "  \"name\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertEquals(15, fieldsData.size());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given {@link CustomerId#CustomerId(UUID)} with id is {@link EntityId#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given CustomerId(UUID) with id is NULL_UUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenCustomerIdWithIdIsNull_uuid() {
    // Arrange
    Dashboard data = new Dashboard();

    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    ShortCustomerInfo shortCustomerInfo =
        new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true);
    assignedCustomers.add(shortCustomerInfo);
    data.setAssignedCustomers(assignedCustomers);

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"title\" : null,\n"
            + "  \"image\" : null,\n"
            + "  \"assignedCustomers\" : [ {\n"
            + "    \"customerId\" : \"13814000-1dd2-11b2-8080-808080808080\",\n"
            + "    \"title\" : \"Dr\",\n"
            + "    \"public\" : true\n"
            + "  } ],\n"
            + "  \"mobileHide\" : false,\n"
            + "  \"mobileOrder\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"configuration\" : null,\n"
            + "  \"entityAliasesConfig\" : [ ],\n"
            + "  \"widgetsConfig\" : [ ],\n"
            + "  \"name\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertEquals(15, fieldsData.size());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Dashboard#Dashboard()} AssignedCustomers is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); given HashSet(); when Dashboard() AssignedCustomers is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenHashSet_whenDashboardAssignedCustomersIsHashSet() {
    // Arrange
    Dashboard data = new Dashboard();
    data.setAssignedCustomers(new HashSet<>());

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"title\" : null,\n"
            + "  \"image\" : null,\n"
            + "  \"assignedCustomers\" : [ ],\n"
            + "  \"mobileHide\" : false,\n"
            + "  \"mobileOrder\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"configuration\" : null,\n"
            + "  \"entityAliasesConfig\" : [ ],\n"
            + "  \"widgetsConfig\" : [ ],\n"
            + "  \"name\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertEquals(15, fieldsData.size());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link AdminSettings#AdminSettings()} JsonValue is Instance.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); given Instance; when AdminSettings() JsonValue is Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenInstance_whenAdminSettingsJsonValueIsInstance() {
    // Arrange
    AdminSettings data = new AdminSettings();
    data.setJsonValue(MissingNode.getInstance());

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"key\" : null,\n"
            + "  \"jsonValue\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given {@link Integer#MIN_VALUE}.
   *   <li>When {@link Dashboard#Dashboard()} MobileOrder is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); given MIN_VALUE; when Dashboard() MobileOrder is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenMin_value_whenDashboardMobileOrderIsMin_value() {
    // Arrange
    Dashboard data = new Dashboard();
    data.setMobileOrder(Integer.MIN_VALUE);

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"title\" : null,\n"
            + "  \"image\" : null,\n"
            + "  \"assignedCustomers\" : null,\n"
            + "  \"mobileHide\" : false,\n"
            + "  \"mobileOrder\" : -2147483648,\n"
            + "  \"version\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"configuration\" : null,\n"
            + "  \"entityAliasesConfig\" : [ ],\n"
            + "  \"widgetsConfig\" : [ ],\n"
            + "  \"name\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertEquals(15, fieldsData.size());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link Dashboard#Dashboard()} MobileOrder is three.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); given three; when Dashboard() MobileOrder is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenThree_whenDashboardMobileOrderIsThree() {
    // Arrange
    Dashboard data = new Dashboard();
    data.setMobileOrder(3);

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"title\" : null,\n"
            + "  \"image\" : null,\n"
            + "  \"assignedCustomers\" : null,\n"
            + "  \"mobileHide\" : false,\n"
            + "  \"mobileOrder\" : 3,\n"
            + "  \"version\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"configuration\" : null,\n"
            + "  \"entityAliasesConfig\" : [ ],\n"
            + "  \"widgetsConfig\" : [ ],\n"
            + "  \"name\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertEquals(15, fieldsData.size());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   *   <li>When {@link AdminSettings#AdminSettings()} JsonValue is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); given valueOf ten; when AdminSettings() JsonValue is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenValueOfTen_whenAdminSettingsJsonValueIsValueOfTen() {
    // Arrange
    DoubleNode jsonValue = DoubleNode.valueOf(10.0d);

    AdminSettings data = new AdminSettings();
    data.setJsonValue(jsonValue);

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"key\" : null,\n"
            + "  \"jsonValue\" : 10.0,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   *   <li>When {@link AdminSettings#AdminSettings()} JsonValue is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); given valueOf ten; when AdminSettings() JsonValue is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenValueOfTen_whenAdminSettingsJsonValueIsValueOfTen2() {
    // Arrange
    FloatNode jsonValue = FloatNode.valueOf(10.0f);

    AdminSettings data = new AdminSettings();
    data.setJsonValue(jsonValue);

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"key\" : null,\n"
            + "  \"jsonValue\" : 10.0,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>When {@link AdminSettings#AdminSettings()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); when AdminSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_whenAdminSettings() {
    // Arrange, Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(new AdminSettings()).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"key\" : null,\n"
            + "  \"jsonValue\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.
   *   <li>Then return FieldsData size is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); when Dashboard(); then return FieldsData size is fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_whenDashboard_thenReturnFieldsDataSizeIsFifteen() {
    // Arrange, Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(new Dashboard()).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"title\" : null,\n"
            + "  \"image\" : null,\n"
            + "  \"assignedCustomers\" : null,\n"
            + "  \"mobileHide\" : false,\n"
            + "  \"mobileOrder\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"configuration\" : null,\n"
            + "  \"entityAliasesConfig\" : [ ],\n"
            + "  \"widgetsConfig\" : [ ],\n"
            + "  \"name\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertEquals(15, fieldsData.size());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>When {@link Device#Device()} DeviceDataBytes is array of {@code byte} with zero and
   *       {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); when Device() DeviceDataBytes is array of byte with zero and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_whenDeviceDeviceDataBytesIsArrayOfByteWithZeroAndX() {
    // Arrange
    Device data = new Device();
    data.setDeviceDataBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"customerId\" : null,\n"
            + "  \"name\" : null,\n"
            + "  \"type\" : null,\n"
            + "  \"label\" : null,\n"
            + "  \"deviceProfileId\" : null,\n"
            + "  \"deviceDataBytes\" : \"AFhBWEFYQVg=\",\n"
            + "  \"firmwareId\" : null,\n"
            + "  \"softwareId\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"additionalInfo\" : null,\n"
            + "  \"deviceData\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>When {@link Device#Device()} DeviceDataBytes is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); when Device() DeviceDataBytes is empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_whenDeviceDeviceDataBytesIsEmptyArrayOfByte() {
    // Arrange
    Device data = new Device();
    data.setDeviceDataBytes(new byte[] {});

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"customerId\" : null,\n"
            + "  \"name\" : null,\n"
            + "  \"type\" : null,\n"
            + "  \"label\" : null,\n"
            + "  \"deviceProfileId\" : null,\n"
            + "  \"deviceDataBytes\" : \"\",\n"
            + "  \"firmwareId\" : null,\n"
            + "  \"softwareId\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"additionalInfo\" : null,\n"
            + "  \"deviceData\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>When {@link Device#Device()}.
   *   <li>Then FieldsData iterator next return {@link LongNode}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); when Device(); then FieldsData iterator next return LongNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_whenDevice_thenFieldsDataIteratorNextReturnLongNode() {
    // Arrange, Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(new Device()).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n"
            + "  \"id\" : null,\n"
            + "  \"createdTime\" : 0,\n"
            + "  \"tenantId\" : null,\n"
            + "  \"customerId\" : null,\n"
            + "  \"name\" : null,\n"
            + "  \"type\" : null,\n"
            + "  \"label\" : null,\n"
            + "  \"deviceProfileId\" : null,\n"
            + "  \"deviceDataBytes\" : null,\n"
            + "  \"firmwareId\" : null,\n"
            + "  \"softwareId\" : null,\n"
            + "  \"externalId\" : null,\n"
            + "  \"version\" : null,\n"
            + "  \"additionalInfo\" : null,\n"
            + "  \"deviceData\" : null,\n"
            + "  \"uuidId\" : null\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName("Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode fieldsData = new ObjectNode(nc);

    // Act and Assert
    assertNull(
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName("Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings2() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.putArray(DataConstants.DEFAULT_SECRET_KEY);

    // Act and Assert
    assertEquals(
        "[]",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName("Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings3() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.putObject(DataConstants.DEFAULT_SECRET_KEY);

    // Act and Assert
    assertEquals(
        "{}",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName("Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings4() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.putRawValue(DataConstants.DEFAULT_SECRET_KEY, new RawValue("\\."));

    // Act and Assert
    assertEquals(
        "[RawValue of type `java.lang.String`]",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName("Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings5() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.putNull(DataConstants.DEFAULT_SECRET_KEY);

    // Act and Assert
    assertNull(
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName("Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings6() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    fieldsData.put(DataConstants.DEFAULT_SECRET_KEY, new ArrayNode(nf));

    // Act and Assert
    assertEquals(
        "[]",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName("Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings7() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.put(DataConstants.DEFAULT_SECRET_KEY, MissingNode.getInstance());

    // Act and Assert
    assertEquals(
        "null",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName("Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings8() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.put(DataConstants.DEFAULT_SECRET_KEY, new byte[] {});

    // Act and Assert
    assertNull(
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <ul>
   *   <li>Then return {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'; then return '10.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings_thenReturn100() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.put(DataConstants.DEFAULT_SECRET_KEY, DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertEquals(
        "10.0",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <ul>
   *   <li>Then return {@code ["Pojo"]}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'; then return '[\"Pojo\"]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings_thenReturnPojo() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode value = new ArrayNode(nf);
    value.addPOJO("Pojo");
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.put(DataConstants.DEFAULT_SECRET_KEY, value);

    // Act and Assert
    assertEquals(
        "[\"Pojo\"]",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <ul>
   *   <li>Then return {@code QQFBAUEBQQE=}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'; then return 'QQFBAUEBQQE='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings_thenReturnQqfbauebqqe() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.put(DataConstants.DEFAULT_SECRET_KEY, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals(
        "QQFBAUEBQQE=",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <ul>
   *   <li>Then return {@code ["QQFBAUEBQQE="]}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'; then return '[\"QQFBAUEBQQE=\"]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings_thenReturnQqfbauebqqe2() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode value = new ArrayNode(nf);
    value.add(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.put(DataConstants.DEFAULT_SECRET_KEY, value);

    // Act and Assert
    assertEquals(
        "[\"QQFBAUEBQQE=\"]",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <ul>
   *   <li>Then return {@code [{},"QQFBAUEBQQE="]}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'; then return '[{},\"QQFBAUEBQQE=\"]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings_thenReturnQqfbauebqqe3() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode value = new ArrayNode(nf);
    value.addObject();
    value.add(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.put(DataConstants.DEFAULT_SECRET_KEY, value);

    // Act and Assert
    assertEquals(
        "[{},\"QQFBAUEBQQE=\"]",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <ul>
   *   <li>Then return {@code ["\\.","QQFBAUEBQQE="]}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'; then return '[\"\\\\.\",\"QQFBAUEBQQE=\"]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings_thenReturnQqfbauebqqe4() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode value = new ArrayNode(nf);
    value.add("\\.");
    value.add(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.put(DataConstants.DEFAULT_SECRET_KEY, value);

    // Act and Assert
    assertEquals(
        "[\"\\\\.\",\"QQFBAUEBQQE=\"]",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <ul>
   *   <li>Then return {@code [{},{},"QQFBAUEBQQE="]}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'; then return '[{},{},\"QQFBAUEBQQE=\"]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings_thenReturnQqfbauebqqe5() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode value = new ArrayNode(nf);
    value.addObject();
    value.addObject();
    value.add(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.put(DataConstants.DEFAULT_SECRET_KEY, value);

    // Act and Assert
    assertEquals(
        "[{},{},\"QQFBAUEBQQE=\"]",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <ul>
   *   <li>Then return {@code [{},"\\.","QQFBAUEBQQE="]}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'; then return '[{},\"\\\\.\",\"QQFBAUEBQQE=\"]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings_thenReturnQqfbauebqqe6() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode value = new ArrayNode(nf);
    value.addObject();
    value.add("\\.");
    value.add(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.put(DataConstants.DEFAULT_SECRET_KEY, value);

    // Act and Assert
    assertEquals(
        "[{},\"\\\\.\",\"QQFBAUEBQQE=\"]",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <ul>
   *   <li>Then return {@code [RawValue of type [null]]}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'; then return '[RawValue of type [null]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings_thenReturnRawValueOfTypeNull() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode fieldsData = new ObjectNode(nc);
    fieldsData.putRawValue(DataConstants.DEFAULT_SECRET_KEY, new RawValue((String) null));

    // Act and Assert
    assertEquals(
        "[RawValue of type [null]]",
        new EntityFieldsData(fieldsData).getFieldValue(DataConstants.DEFAULT_SECRET_KEY, true));
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String)} with {@code field}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String)}
   */
  @Test
  @DisplayName("Test getFieldValue(String) with 'field'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String)"})
  void testGetFieldValueWithField_thenReturnNull() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode fieldsData = new ObjectNode(nc);

    // Act and Assert
    assertNull(new EntityFieldsData(fieldsData).getFieldValue("Field"));
  }
}
