package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityFieldsData entityFieldsData =
        new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
    EntityFieldsData entityFieldsData2 =
        new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertEquals(entityFieldsData, entityFieldsData2);
    int expectedHashCodeResult = entityFieldsData.hashCode();
    assertEquals(expectedHashCodeResult, entityFieldsData2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityFieldsData entityFieldsData =
        new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityFieldsData entityFieldsData = new EntityFieldsData((ObjectNode) null);

    // Act and Assert
    assertNotEquals(
        entityFieldsData,
        new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ObjectNode fieldsData = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    fieldsData.put("Property Name", DoubleNode.valueOf(10.0d));
    EntityFieldsData entityFieldsData = new EntityFieldsData(fieldsData);

    // Act and Assert
    assertNotEquals(
        entityFieldsData,
        new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))), null);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityFieldsData.equals(Object)", "int EntityFieldsData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))),
        "Different type to EntityFieldsData");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntityFieldsData.<init>(ObjectNode)",
    "ObjectNode EntityFieldsData.getFieldsData()",
    "void EntityFieldsData.setFieldsData(ObjectNode)",
    "String EntityFieldsData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityFieldsData actualEntityFieldsData =
        new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
    ObjectNode fieldsData = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    actualEntityFieldsData.setFieldsData(fieldsData);
    String actualToStringResult = actualEntityFieldsData.toString();

    // Assert
    assertEquals("EntityFieldsData(fieldsData={})", actualToStringResult);
    assertSame(fieldsData, actualEntityFieldsData.getFieldsData());
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData() {
    // Arrange
    Dashboard data = new Dashboard();

    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(
        new ShortCustomerInfo(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true));
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"title\" : null,\r\n"
            + "  \"image\" : null,\r\n"
            + "  \"assignedCustomers\" : [ {\r\n"
            + "    \"customerId\" : \"784f394c-42b6-435a-983c-b7beff2784f9\",\r\n"
            + "    \"title\" : \"Dr\",\r\n"
            + "    \"public\" : true\r\n"
            + "  } ],\r\n"
            + "  \"mobileHide\" : false,\r\n"
            + "  \"mobileOrder\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"configuration\" : null,\r\n"
            + "  \"entityAliasesConfig\" : [ ],\r\n"
            + "  \"widgetsConfig\" : [ ],\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData2() {
    // Arrange
    Device data = new Device(new Device());
    data.setDeviceDataBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
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
    assertTrue(actualHasNextResult);
    assertSame(nextResult, actualNextResult);
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"customerId\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"label\" : null,\r\n"
            + "  \"deviceProfileId\" : null,\r\n"
            + "  \"deviceDataBytes\" : \"Qf9BWEFYQVg=\",\r\n"
            + "  \"firmwareId\" : null,\r\n"
            + "  \"softwareId\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"deviceData\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"customerId\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"label\" : null,\r\n"
            + "  \"deviceProfileId\" : null,\r\n"
            + "  \"deviceDataBytes\" : \"f1hBWEFYQVg=\",\r\n"
            + "  \"firmwareId\" : null,\r\n"
            + "  \"softwareId\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"deviceData\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"customerId\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"label\" : null,\r\n"
            + "  \"deviceProfileId\" : null,\r\n"
            + "  \"deviceDataBytes\" : \"AABBWEFYQVg=\",\r\n"
            + "  \"firmwareId\" : null,\r\n"
            + "  \"softwareId\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"deviceData\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"customerId\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"label\" : null,\r\n"
            + "  \"deviceProfileId\" : null,\r\n"
            + "  \"deviceDataBytes\" : \"AABBAEFYQVg=\",\r\n"
            + "  \"firmwareId\" : null,\r\n"
            + "  \"softwareId\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"deviceData\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"customerId\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"label\" : null,\r\n"
            + "  \"deviceProfileId\" : null,\r\n"
            + "  \"deviceDataBytes\" : \"QVhBWEFYQVg=\",\r\n"
            + "  \"firmwareId\" : null,\r\n"
            + "  \"softwareId\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"deviceData\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenCustomerIdWithIdIsNull() {
    // Arrange
    Dashboard data = new Dashboard();

    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(new ShortCustomerInfo(new CustomerId(null), "Dr", true));
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"title\" : null,\r\n"
            + "  \"image\" : null,\r\n"
            + "  \"assignedCustomers\" : [ {\r\n"
            + "    \"customerId\" : null,\r\n"
            + "    \"title\" : \"Dr\",\r\n"
            + "    \"public\" : true\r\n"
            + "  } ],\r\n"
            + "  \"mobileHide\" : false,\r\n"
            + "  \"mobileOrder\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"configuration\" : null,\r\n"
            + "  \"entityAliasesConfig\" : [ ],\r\n"
            + "  \"widgetsConfig\" : [ ],\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
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
   *   <li>Given {@link DataConstants#DEFAULT_SECRET_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
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
    ObjectNode fieldsData = new EntityFieldsData(data).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"key\" : \"\",\r\n"
            + "  \"jsonValue\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenEmptyArrayOfByte() {
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"customerId\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"label\" : null,\r\n"
            + "  \"deviceProfileId\" : null,\r\n"
            + "  \"deviceDataBytes\" : \"\",\r\n"
            + "  \"firmwareId\" : null,\r\n"
            + "  \"softwareId\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"deviceData\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given {@code ENABLED}.
   *   <li>When {@link ApiUsageState#ApiUsageState()} JsExecState is {@code ENABLED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); given 'ENABLED'; when ApiUsageState() JsExecState is 'ENABLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenEnabled_whenApiUsageStateJsExecStateIsEnabled() {
    // Arrange
    ApiUsageState data = new ApiUsageState();
    data.setJsExecState(ApiUsageStateValue.ENABLED);

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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"entityId\" : null,\r\n"
            + "  \"transportState\" : null,\r\n"
            + "  \"dbStorageState\" : null,\r\n"
            + "  \"reExecState\" : null,\r\n"
            + "  \"jsExecState\" : \"ENABLED\",\r\n"
            + "  \"tbelExecState\" : null,\r\n"
            + "  \"emailExecState\" : null,\r\n"
            + "  \"smsExecState\" : null,\r\n"
            + "  \"alarmExecState\" : null,\r\n"
            + "  \"alarmCreationEnabled\" : true,\r\n"
            + "  \"dbStorageEnabled\" : true,\r\n"
            + "  \"emailSendEnabled\" : true,\r\n"
            + "  \"jsExecEnabled\" : true,\r\n"
            + "  \"reExecEnabled\" : true,\r\n"
            + "  \"smsSendEnabled\" : true,\r\n"
            + "  \"tbelExecEnabled\" : true,\r\n"
            + "  \"transportEnabled\" : true,\r\n"
            + "  \"uuidId\" : null\r\n"
            + "}",
        fieldsData.toPrettyString());
    assertEquals(21, fieldsData.size());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given {@code ENABLED}.
   *   <li>When {@link ApiUsageState#ApiUsageState()} TransportState is {@code ENABLED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); given 'ENABLED'; when ApiUsageState() TransportState is 'ENABLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenEnabled_whenApiUsageStateTransportStateIsEnabled() {
    // Arrange
    ApiUsageState data = new ApiUsageState();
    data.setTransportState(ApiUsageStateValue.ENABLED);

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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"entityId\" : null,\r\n"
            + "  \"transportState\" : \"ENABLED\",\r\n"
            + "  \"dbStorageState\" : null,\r\n"
            + "  \"reExecState\" : null,\r\n"
            + "  \"jsExecState\" : null,\r\n"
            + "  \"tbelExecState\" : null,\r\n"
            + "  \"emailExecState\" : null,\r\n"
            + "  \"smsExecState\" : null,\r\n"
            + "  \"alarmExecState\" : null,\r\n"
            + "  \"alarmCreationEnabled\" : true,\r\n"
            + "  \"dbStorageEnabled\" : true,\r\n"
            + "  \"emailSendEnabled\" : true,\r\n"
            + "  \"jsExecEnabled\" : true,\r\n"
            + "  \"reExecEnabled\" : true,\r\n"
            + "  \"smsSendEnabled\" : true,\r\n"
            + "  \"tbelExecEnabled\" : true,\r\n"
            + "  \"transportEnabled\" : true,\r\n"
            + "  \"uuidId\" : null\r\n"
            + "}",
        fieldsData.toPrettyString());
    assertEquals(21, fieldsData.size());
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"title\" : null,\r\n"
            + "  \"image\" : null,\r\n"
            + "  \"assignedCustomers\" : [ ],\r\n"
            + "  \"mobileHide\" : false,\r\n"
            + "  \"mobileOrder\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"configuration\" : null,\r\n"
            + "  \"entityAliasesConfig\" : [ ],\r\n"
            + "  \"widgetsConfig\" : [ ],\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"key\" : null,\r\n"
            + "  \"jsonValue\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link AdminSettings#AdminSettings()} Key is {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); given 'Key'; when AdminSettings() Key is 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenKey_whenAdminSettingsKeyIsKey() {
    // Arrange
    AdminSettings data = new AdminSettings();
    data.setKey("Key");

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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"key\" : \"Key\",\r\n"
            + "  \"jsonValue\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"title\" : null,\r\n"
            + "  \"image\" : null,\r\n"
            + "  \"assignedCustomers\" : null,\r\n"
            + "  \"mobileHide\" : false,\r\n"
            + "  \"mobileOrder\" : -2147483648,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"configuration\" : null,\r\n"
            + "  \"entityAliasesConfig\" : [ ],\r\n"
            + "  \"widgetsConfig\" : [ ],\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"title\" : null,\r\n"
            + "  \"image\" : null,\r\n"
            + "  \"assignedCustomers\" : null,\r\n"
            + "  \"mobileHide\" : false,\r\n"
            + "  \"mobileOrder\" : 3,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"configuration\" : null,\r\n"
            + "  \"entityAliasesConfig\" : [ ],\r\n"
            + "  \"widgetsConfig\" : [ ],\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"key\" : null,\r\n"
            + "  \"jsonValue\" : 10.0,\r\n"
            + "  \"uuidId\" : null\r\n"
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"key\" : null,\r\n"
            + "  \"jsonValue\" : 10.0,\r\n"
            + "  \"uuidId\" : null\r\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>Given wrap array of {@code byte} with {@code A} and two.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName("Test new EntityFieldsData(BaseData); given wrap array of byte with 'A' and two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_givenWrapArrayOfByteWithAAndTwo() {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    OtaPackage data2 = new OtaPackage();
    data2.setData(data);

    // Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(data2).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"deviceProfileId\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"title\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"tag\" : null,\r\n"
            + "  \"url\" : null,\r\n"
            + "  \"hasData\" : false,\r\n"
            + "  \"fileName\" : null,\r\n"
            + "  \"contentType\" : null,\r\n"
            + "  \"checksumAlgorithm\" : null,\r\n"
            + "  \"checksum\" : null,\r\n"
            + "  \"dataSize\" : null,\r\n"
            + "  \"data\" : \"QQJBAkECQQI=\",\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
            + "}",
        fieldsData.toPrettyString());
    assertEquals(19, fieldsData.size());
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"key\" : null,\r\n"
            + "  \"jsonValue\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>When {@link ApiUsageState#ApiUsageState()}.
   *   <li>Then return FieldsData size is twenty-one.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); when ApiUsageState(); then return FieldsData size is twenty-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_whenApiUsageState_thenReturnFieldsDataSizeIsTwentyOne() {
    // Arrange, Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(new ApiUsageState()).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"entityId\" : null,\r\n"
            + "  \"transportState\" : null,\r\n"
            + "  \"dbStorageState\" : null,\r\n"
            + "  \"reExecState\" : null,\r\n"
            + "  \"jsExecState\" : null,\r\n"
            + "  \"tbelExecState\" : null,\r\n"
            + "  \"emailExecState\" : null,\r\n"
            + "  \"smsExecState\" : null,\r\n"
            + "  \"alarmExecState\" : null,\r\n"
            + "  \"alarmCreationEnabled\" : true,\r\n"
            + "  \"dbStorageEnabled\" : true,\r\n"
            + "  \"emailSendEnabled\" : true,\r\n"
            + "  \"jsExecEnabled\" : true,\r\n"
            + "  \"reExecEnabled\" : true,\r\n"
            + "  \"smsSendEnabled\" : true,\r\n"
            + "  \"tbelExecEnabled\" : true,\r\n"
            + "  \"transportEnabled\" : true,\r\n"
            + "  \"uuidId\" : null\r\n"
            + "}",
        fieldsData.toPrettyString());
    assertEquals(21, fieldsData.size());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>When {@link Customer#Customer()}.
   *   <li>Then return FieldsData size is eighteen.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); when Customer(); then return FieldsData size is eighteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_whenCustomer_thenReturnFieldsDataSizeIsEighteen() {
    // Arrange, Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(new Customer()).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"country\" : null,\r\n"
            + "  \"state\" : null,\r\n"
            + "  \"city\" : null,\r\n"
            + "  \"address\" : null,\r\n"
            + "  \"address2\" : null,\r\n"
            + "  \"zip\" : null,\r\n"
            + "  \"phone\" : null,\r\n"
            + "  \"email\" : null,\r\n"
            + "  \"title\" : null,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"public\" : false,\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
            + "}",
        fieldsData.toPrettyString());
    assertEquals(18, fieldsData.size());
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"title\" : null,\r\n"
            + "  \"image\" : null,\r\n"
            + "  \"assignedCustomers\" : null,\r\n"
            + "  \"mobileHide\" : false,\r\n"
            + "  \"mobileOrder\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"configuration\" : null,\r\n"
            + "  \"entityAliasesConfig\" : [ ],\r\n"
            + "  \"widgetsConfig\" : [ ],\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"customerId\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"label\" : null,\r\n"
            + "  \"deviceProfileId\" : null,\r\n"
            + "  \"deviceDataBytes\" : \"AFhBWEFYQVg=\",\r\n"
            + "  \"firmwareId\" : null,\r\n"
            + "  \"softwareId\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"deviceData\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
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
  @Tag("MaintainedByDiffblue")
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
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"customerId\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"label\" : null,\r\n"
            + "  \"deviceProfileId\" : null,\r\n"
            + "  \"deviceDataBytes\" : null,\r\n"
            + "  \"firmwareId\" : null,\r\n"
            + "  \"softwareId\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"deviceData\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
            + "}",
        fieldsData.toPrettyString());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#EntityFieldsData(BaseData)}.
   *
   * <ul>
   *   <li>When {@link OtaPackage#OtaPackage()}.
   *   <li>Then return FieldsData size is nineteen.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#EntityFieldsData(BaseData)}
   */
  @Test
  @DisplayName(
      "Test new EntityFieldsData(BaseData); when OtaPackage(); then return FieldsData size is nineteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityFieldsData.<init>(BaseData)"})
  void testNewEntityFieldsData_whenOtaPackage_thenReturnFieldsDataSizeIsNineteen() {
    // Arrange, Act and Assert
    ObjectNode fieldsData = new EntityFieldsData(new OtaPackage()).getFieldsData();
    Iterator<JsonNode> iteratorResult = fieldsData.iterator();
    JsonNode expectedNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult instanceof LongNode);
    assertTrue(fieldsData.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"deviceProfileId\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"title\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"tag\" : null,\r\n"
            + "  \"url\" : null,\r\n"
            + "  \"hasData\" : false,\r\n"
            + "  \"fileName\" : null,\r\n"
            + "  \"contentType\" : null,\r\n"
            + "  \"checksumAlgorithm\" : null,\r\n"
            + "  \"checksum\" : null,\r\n"
            + "  \"dataSize\" : null,\r\n"
            + "  \"data\" : null,\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"uuidId\" : null\r\n"
            + "}",
        fieldsData.toPrettyString());
    assertEquals(19, fieldsData.size());
    assertTrue(actualHasNextResult);
    assertSame(expectedNextResult, actualNextResult);
  }

  /**
   * Test {@link EntityFieldsData#getFieldValue(String, boolean)} with {@code field}, {@code
   * ignoreNullStrings}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFieldsData#getFieldValue(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getFieldValue(String, boolean) with 'field', 'ignoreNullStrings'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String, boolean)"})
  void testGetFieldValueWithFieldIgnoreNullStrings_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)))
            .getFieldValue("Field", true));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityFieldsData.getFieldValue(String)"})
  void testGetFieldValueWithField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)))
            .getFieldValue("Field"));
  }
}
