package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.edge.Edge;

class BaseDataWithAdditionalInfoDiffblueTest {
  /**
   * Test {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge(Edge)} with edge is {@link Edge#Edge()}.
   *   <li>Then return {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfo(); given Edge(Edge) with edge is Edge(); then return instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenEdgeWithEdgeIsEdge_thenReturnInstance() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = new Edge(new Edge()).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge(Edge)} with edge is {@link Edge#Edge(Edge)}.
   *   <li>Then return {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfo(); given Edge(Edge) with edge is Edge(Edge); then return instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenEdgeWithEdgeIsEdge_thenReturnInstance2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = new Edge(new Edge(new Edge())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Edge(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenEdge_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Edge().getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo() {
    // Arrange
    Customer customer = new Customer(new Customer());
    DoubleNode addInfo = DoubleNode.valueOf(10.0d);

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
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
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo3() {
    // Arrange
    Customer customer = new Customer();

    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    addInfo.addObject();

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo4() {
    // Arrange
    Customer customer = new Customer();

    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    addInfo.addObject();
    addInfo.addObject();

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer()}.
   *   <li>When {@code null}.
   *   <li>Then {@link Customer#Customer()} AdditionalInfo {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test setAdditionalInfo(JsonNode); given Customer(); when 'null'; then Customer() AdditionalInfo NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo_givenCustomer_whenNull_thenCustomerAdditionalInfoNullNode() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setAdditionalInfo(null);

    // Assert
    assertTrue(customer.getAdditionalInfo() instanceof NullNode);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   *
   * <ul>
   *   <li>Given {@code Pojo}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); given 'Pojo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo_givenPojo() {
    // Arrange
    Customer customer = new Customer();

    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    addInfo.addPOJO("Pojo");
    addInfo.addObject();

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   *
   * <ul>
   *   <li>Given {@code Pojo}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); given 'Pojo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo_givenPojo2() {
    // Arrange
    Customer customer = new Customer();

    ArrayNode addInfo = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    addInfo.addObject();
    addInfo.addPOJO("Pojo");
    addInfo.addObject();

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   *
   * <ul>
   *   <li>When Instance.
   *   <li>Then {@link Customer#Customer()} AdditionalInfo is Instance.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test setAdditionalInfo(JsonNode); when Instance; then Customer() AdditionalInfo is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
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
   *
   * <ul>
   *   <li>When Instance.
   *   <li>Then {@link Customer#Customer()} AdditionalInfo is Instance {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test setAdditionalInfo(JsonNode); when Instance; then Customer() AdditionalInfo is Instance instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
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
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then {@link Customer#Customer()} AdditionalInfo is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test setAdditionalInfo(JsonNode); when valueOf ten; then Customer() AdditionalInfo is valueOf ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo_whenValueOfTen_thenCustomerAdditionalInfoIsValueOfTen() {
    // Arrange
    Customer customer = new Customer();
    DoubleNode addInfo = DoubleNode.valueOf(10.0d);

    // Act
    customer.setAdditionalInfo(addInfo);

    // Assert
    assertSame(addInfo, customer.getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String,
   * JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfoField(String, JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfoField(String, JsonNode)"})
  void testSetAdditionalInfoField() {
    // Arrange
    Customer customer = new Customer(new Customer());

    // Act
    customer.setAdditionalInfoField("Field", DoubleNode.valueOf(10.0d));

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String,
   * JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfoField(String, JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfoField(String, JsonNode)"})
  void testSetAdditionalInfoField2() throws UnsupportedEncodingException {
    // Arrange
    Customer customer = new Customer();
    BinaryNode value = new BinaryNode("AXAXAXAX".getBytes("UTF-8"));

    // Act
    customer.setAdditionalInfoField("Field", value);

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(value, actualNextResult);
    assertEquals("{\r\n  \"Field\" : \"QVhBWEFYQVg=\"\r\n}", additionalInfo.toPrettyString());
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String,
   * JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfoField(String, JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfoField(String, JsonNode)"})
  void testSetAdditionalInfoField3() {
    // Arrange
    Customer customer = new Customer(new Customer(new Customer()));

    // Act
    customer.setAdditionalInfoField("Field", DoubleNode.valueOf(10.0d));

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   *
   * <ul>
   *   <li>Then {@link Customer#Customer()} AdditionalInfo iterator next is Instance.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String,
   * JsonNode)}
   */
  @Test
  @DisplayName(
      "Test setAdditionalInfoField(String, JsonNode); then Customer() AdditionalInfo iterator next is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfoField(String, JsonNode)"})
  void testSetAdditionalInfoField_thenCustomerAdditionalInfoIteratorNextIsInstance() {
    // Arrange
    Customer customer = new Customer();
    MissingNode value = MissingNode.getInstance();

    // Act
    customer.setAdditionalInfoField("Field", value);

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(value, actualNextResult);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   *
   * <ul>
   *   <li>Then {@link Customer#Customer()} AdditionalInfo iterator next {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String,
   * JsonNode)}
   */
  @Test
  @DisplayName(
      "Test setAdditionalInfoField(String, JsonNode); then Customer() AdditionalInfo iterator next NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfoField(String, JsonNode)"})
  void testSetAdditionalInfoField_thenCustomerAdditionalInfoIteratorNextNullNode() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setAdditionalInfoField("Field", null);

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    assertTrue(iteratorResult.next() instanceof NullNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link Customer#Customer()} AdditionalInfo {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String,
   * JsonNode)}
   */
  @Test
  @DisplayName(
      "Test setAdditionalInfoField(String, JsonNode); when 'null'; then Customer() AdditionalInfo ObjectNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfoField(String, JsonNode)"})
  void testSetAdditionalInfoField_whenNull_thenCustomerAdditionalInfoObjectNode() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setAdditionalInfoField(null, DoubleNode.valueOf(10.0d));

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then {@link Customer#Customer()} AdditionalInfo {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String,
   * JsonNode)}
   */
  @Test
  @DisplayName(
      "Test setAdditionalInfoField(String, JsonNode); when valueOf ten; then Customer() AdditionalInfo ObjectNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfoField(String, JsonNode)"})
  void testSetAdditionalInfoField_whenValueOfTen_thenCustomerAdditionalInfoObjectNode() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setAdditionalInfoField("Field", DoubleNode.valueOf(10.0d));

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String,
   * Function, Object)}
   */
  @Test
  @DisplayName("Test getAdditionalInfoField(String, Function, Object); given Customer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object BaseDataWithAdditionalInfo.getAdditionalInfoField(String, Function, Object)"
  })
  void testGetAdditionalInfoField_givenCustomer() {
    // Arrange, Act and Assert
    assertEquals(
        "Default Value",
        new Customer().getAdditionalInfoField("Field", mock(Function.class), "Default Value"));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer(Customer)} with customer is {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String,
   * Function, Object)}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfoField(String, Function, Object); given Customer(Customer) with customer is Customer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object BaseDataWithAdditionalInfo.getAdditionalInfoField(String, Function, Object)"
  })
  void testGetAdditionalInfoField_givenCustomerWithCustomerIsCustomer() {
    // Arrange, Act and Assert
    assertEquals(
        "Default Value",
        new Customer(new Customer())
            .getAdditionalInfoField("Field", mock(Function.class), "Default Value"));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer(Customer)} with customer is {@link
   *       Customer#Customer(Customer)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String,
   * Function, Object)}
   */
  @Test
  @DisplayName(
      "Test getAdditionalInfoField(String, Function, Object); given Customer(Customer) with customer is Customer(Customer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object BaseDataWithAdditionalInfo.getAdditionalInfoField(String, Function, Object)"
  })
  void testGetAdditionalInfoField_givenCustomerWithCustomerIsCustomer2() {
    // Arrange, Act and Assert
    assertEquals(
        "Default Value",
        new Customer(new Customer(new Customer()))
            .getAdditionalInfoField("Field", mock(Function.class), "Default Value"));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
  void testGetJson_givenArrayOfByteWithAAndMinusOne() {
    // Arrange
    Supplier<JsonNode> jsonData = mock(Supplier.class);
    when(jsonData.get()).thenReturn(null);

    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes);

    // Assert
    verify(jsonData).get();
    assertNull(actualJson);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with MAX_VALUE and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
  void testGetJson_givenArrayOfByteWithMax_valueAndX() {
    // Arrange
    Supplier<JsonNode> jsonData = mock(Supplier.class);
    when(jsonData.get()).thenReturn(null);

    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes);

    // Assert
    verify(jsonData).get();
    assertNull(actualJson);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.
   *   <li>When {@link Device#Device(Device)} with device is {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName(
      "Test getJson(Supplier, Supplier); given array of byte with zero and 'X'; when Device(Device) with device is Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
  void testGetJson_givenArrayOfByteWithZeroAndX_whenDeviceWithDeviceIsDevice() {
    // Arrange
    Supplier<JsonNode> jsonData = mock(Supplier.class);
    when(jsonData.get()).thenReturn(null);

    Device device = new Device(new Device(new Device()));
    device.setDeviceDataBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes);

    // Assert
    verify(jsonData).get();
    assertNull(actualJson);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
  void testGetJson_givenArrayOfByteWithZeroAndZero() {
    // Arrange
    Supplier<JsonNode> jsonData = mock(Supplier.class);
    when(jsonData.get()).thenReturn(null);

    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes);

    // Assert
    verify(jsonData).get();
    assertNull(actualJson);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
  void testGetJson_givenArrayOfByteWithZeroAndZero2() {
    // Arrange
    Supplier<JsonNode> jsonData = mock(Supplier.class);
    when(jsonData.get()).thenReturn(null);

    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {0, 0, 0, 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes);

    // Assert
    verify(jsonData).get();
    assertNull(actualJson);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
  void testGetJson_givenArrayOfByteWithZeroAndZero3() {
    // Arrange
    Supplier<JsonNode> jsonData = mock(Supplier.class);
    when(jsonData.get()).thenReturn(null);

    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {0, 0, 'A', 0, 'A', 'X', 'A', 'X'});

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes);

    // Assert
    verify(jsonData).get();
    assertNull(actualJson);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
  void testGetJson_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Supplier<JsonNode> jsonData = mock(Supplier.class);
    when(jsonData.get()).thenReturn(null);

    Device device = new Device();
    device.setDeviceDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes);

    // Assert
    verify(jsonData).get();
    assertNull(actualJson);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   *   <li>Then return {@link MissingNode}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName(
      "Test getJson(Supplier, Supplier); given empty array of byte; then return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
  void testGetJson_givenEmptyArrayOfByte_thenReturnMissingNode() {
    // Arrange
    Supplier<JsonNode> jsonData = mock(Supplier.class);
    when(jsonData.get()).thenReturn(null);

    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {});

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes);

    // Assert
    verify(jsonData).get();
    assertTrue(actualJson instanceof MissingNode);
    assertEquals(JsonNodeType.MISSING, actualJson.getNodeType());
    assertFalse(actualJson.isDouble());
    assertFalse(actualJson.isFloatingPointNumber());
    assertFalse(actualJson.isNumber());
    assertFalse(actualJson.isValueNode());
    assertTrue(actualJson.isMissingNode());
    assertEquals(DataConstants.DEFAULT_SECRET_KEY, actualJson.toPrettyString());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Device#Device()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given 'null'; when Device(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
  void testGetJson_givenNull_whenDevice_thenReturnNull() {
    // Arrange
    Supplier<JsonNode> jsonData = mock(Supplier.class);
    when(jsonData.get()).thenReturn(null);

    // Act
    JsonNode actualJson =
        BaseDataWithAdditionalInfo.getJson(jsonData, new Device()::getDeviceDataBytes);

    // Assert
    verify(jsonData).get();
    assertNull(actualJson);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   *   <li>When {@link Supplier} {@link Supplier#get()} return valueOf ten.
   *   <li>Then return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName(
      "Test getJson(Supplier, Supplier); given valueOf ten; when Supplier get() return valueOf ten; then return DoubleNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
  void testGetJson_givenValueOfTen_whenSupplierGetReturnValueOfTen_thenReturnDoubleNode() {
    // Arrange
    Supplier<JsonNode> jsonData = mock(Supplier.class);
    when(jsonData.get()).thenReturn(DoubleNode.valueOf(10.0d));

    // Act
    JsonNode actualJson =
        BaseDataWithAdditionalInfo.getJson(jsonData, new Device()::getDeviceDataBytes);

    // Assert
    verify(jsonData).get();
    assertTrue(actualJson instanceof DoubleNode);
    assertEquals("10.0", actualJson.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, actualJson.getNodeType());
    assertFalse(actualJson.isMissingNode());
    assertFalse(((DoubleNode) actualJson).isNaN());
    assertTrue(actualJson.isDouble());
    assertTrue(actualJson.isFloatingPointNumber());
    assertTrue(actualJson.isNumber());
    assertTrue(actualJson.isValueNode());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   *
   * <ul>
   *   <li>When {@link Device#Device()} DeviceDataBytes is array of {@code byte} with zero and
   *       {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName(
      "Test getJson(Supplier, Supplier); when Device() DeviceDataBytes is array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
  void testGetJson_whenDeviceDeviceDataBytesIsArrayOfByteWithZeroAndX() {
    // Arrange
    Supplier<JsonNode> jsonData = mock(Supplier.class);
    when(jsonData.get()).thenReturn(null);

    Device device = new Device();
    device.setDeviceDataBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes);

    // Assert
    verify(jsonData).get();
    assertNull(actualJson);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   *
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is {@link Device#Device()} DeviceDataBytes
   *       is array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName(
      "Test getJson(Supplier, Supplier); when Device(Device) with device is Device() DeviceDataBytes is array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
  void testGetJson_whenDeviceWithDeviceIsDeviceDeviceDataBytesIsArrayOfByteWithZeroAndX() {
    // Arrange
    Supplier<JsonNode> jsonData = mock(Supplier.class);
    when(jsonData.get()).thenReturn(null);

    Device device = new Device(new Device());
    device.setDeviceDataBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsonNode actualJson = BaseDataWithAdditionalInfo.getJson(jsonData, device::getDeviceDataBytes);

    // Assert
    verify(jsonData).get();
    assertNull(actualJson);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   *
   * <ul>
   *   <li>Given {@code Pojo}.
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addPOJO {@code Pojo}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName(
      "Test setJson(JsonNode, Consumer, Consumer); given 'Pojo'; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addPOJO 'Pojo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
  void testSetJson_givenPojo_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddPOJOPojo() {
    // Arrange
    ArrayNode json = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    json.addPOJO("Pojo");
    Consumer<JsonNode> jsonConsumer = mock(Consumer.class);
    doNothing().when(jsonConsumer).accept(Mockito.<JsonNode>any());

    // Act
    BaseDataWithAdditionalInfo.setJson(json, jsonConsumer, new Device()::setDeviceDataBytes);

    // Assert
    verify(jsonConsumer).accept(isA(JsonNode.class));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   *
   * <ul>
   *   <li>Given {@code Pojo}.
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addPOJO {@code Pojo}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName(
      "Test setJson(JsonNode, Consumer, Consumer); given 'Pojo'; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addPOJO 'Pojo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
  void testSetJson_givenPojo_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddPOJOPojo2() {
    // Arrange
    ArrayNode json = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    json.addObject();
    json.addPOJO("Pojo");
    Consumer<JsonNode> jsonConsumer = mock(Consumer.class);
    doNothing().when(jsonConsumer).accept(Mockito.<JsonNode>any());

    // Act
    BaseDataWithAdditionalInfo.setJson(json, jsonConsumer, new Device()::setDeviceDataBytes);

    // Assert
    verify(jsonConsumer).accept(isA(JsonNode.class));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addPOJO two.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName(
      "Test setJson(JsonNode, Consumer, Consumer); given two; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addPOJO two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
  void testSetJson_givenTwo_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddPOJOTwo() {
    // Arrange
    ArrayNode json = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    json.addObject();
    json.addPOJO(2);
    Consumer<JsonNode> jsonConsumer = mock(Consumer.class);
    doNothing().when(jsonConsumer).accept(Mockito.<JsonNode>any());

    // Act
    BaseDataWithAdditionalInfo.setJson(json, jsonConsumer, new Device()::setDeviceDataBytes);

    // Assert
    verify(jsonConsumer).accept(isA(JsonNode.class));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addObject.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName(
      "Test setJson(JsonNode, Consumer, Consumer); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
  void testSetJson_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddObject() {
    // Arrange
    ArrayNode json = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    json.addObject();
    Consumer<JsonNode> jsonConsumer = mock(Consumer.class);
    doNothing().when(jsonConsumer).accept(Mockito.<JsonNode>any());

    // Act
    BaseDataWithAdditionalInfo.setJson(json, jsonConsumer, new Device()::setDeviceDataBytes);

    // Assert
    verify(jsonConsumer).accept(isA(JsonNode.class));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addObject.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName(
      "Test setJson(JsonNode, Consumer, Consumer); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
  void testSetJson_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddObject2() {
    // Arrange
    ArrayNode json = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    json.addObject();
    json.addObject();
    Consumer<JsonNode> jsonConsumer = mock(Consumer.class);
    doNothing().when(jsonConsumer).accept(Mockito.<JsonNode>any());

    // Act
    BaseDataWithAdditionalInfo.setJson(json, jsonConsumer, new Device()::setDeviceDataBytes);

    // Assert
    verify(jsonConsumer).accept(isA(JsonNode.class));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName(
      "Test setJson(JsonNode, Consumer, Consumer); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
  void testSetJson_whenArrayNodeWithNfIsWithExactBigDecimalsTrue_thenCallsAccept() {
    // Arrange
    ArrayNode json = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    Consumer<JsonNode> jsonConsumer = mock(Consumer.class);
    doNothing().when(jsonConsumer).accept(Mockito.<JsonNode>any());

    // Act
    BaseDataWithAdditionalInfo.setJson(json, jsonConsumer, new Device()::setDeviceDataBytes);

    // Assert
    verify(jsonConsumer).accept(isA(JsonNode.class));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   *
   * <ul>
   *   <li>When {@link BinaryNode#BinaryNode(byte[])} with data is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName(
      "Test setJson(JsonNode, Consumer, Consumer); when BinaryNode(byte[]) with data is 'AXAXAXAX' Bytes is 'UTF-8'; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
  void testSetJson_whenBinaryNodeWithDataIsAxaxaxaxBytesIsUtf8_thenCallsAccept()
      throws UnsupportedEncodingException {
    // Arrange
    BinaryNode json = new BinaryNode("AXAXAXAX".getBytes("UTF-8"));
    Consumer<JsonNode> jsonConsumer = mock(Consumer.class);
    doNothing().when(jsonConsumer).accept(Mockito.<JsonNode>any());

    // Act
    BaseDataWithAdditionalInfo.setJson(json, jsonConsumer, new Device()::setDeviceDataBytes);

    // Assert
    verify(jsonConsumer).accept(isA(JsonNode.class));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   *
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is {@link Device#Device()}.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName(
      "Test setJson(JsonNode, Consumer, Consumer); when Device(Device) with device is Device(); then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
  void testSetJson_whenDeviceWithDeviceIsDevice_thenCallsAccept() {
    // Arrange
    DoubleNode json = DoubleNode.valueOf(10.0d);
    Consumer<JsonNode> jsonConsumer = mock(Consumer.class);
    doNothing().when(jsonConsumer).accept(Mockito.<JsonNode>any());

    // Act
    BaseDataWithAdditionalInfo.setJson(
        json, jsonConsumer, new Device(new Device())::setDeviceDataBytes);

    // Assert
    verify(jsonConsumer).accept(isA(JsonNode.class));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   *
   * <ul>
   *   <li>When Instance.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName(
      "Test setJson(JsonNode, Consumer, Consumer); when Instance; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
  void testSetJson_whenInstance_thenCallsAccept() {
    // Arrange
    MissingNode json = MissingNode.getInstance();
    Consumer<JsonNode> jsonConsumer = mock(Consumer.class);
    doNothing().when(jsonConsumer).accept(Mockito.<JsonNode>any());

    // Act
    BaseDataWithAdditionalInfo.setJson(json, jsonConsumer, new Device()::setDeviceDataBytes);

    // Assert
    verify(jsonConsumer).accept(isA(JsonNode.class));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   *
   * <ul>
   *   <li>When Instance.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName(
      "Test setJson(JsonNode, Consumer, Consumer); when Instance; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
  void testSetJson_whenInstance_thenCallsAccept2() {
    // Arrange
    NullNode json = NullNode.getInstance();
    Consumer<JsonNode> jsonConsumer = mock(Consumer.class);
    doNothing().when(jsonConsumer).accept(Mockito.<JsonNode>any());

    // Act
    BaseDataWithAdditionalInfo.setJson(json, jsonConsumer, new Device()::setDeviceDataBytes);

    // Assert
    verify(jsonConsumer).accept(isA(JsonNode.class));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName("Test setJson(JsonNode, Consumer, Consumer); when 'null'; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
  void testSetJson_whenNull_thenCallsAccept() {
    // Arrange
    Consumer<JsonNode> jsonConsumer = mock(Consumer.class);
    doNothing().when(jsonConsumer).accept(Mockito.<JsonNode>any());

    // Act
    BaseDataWithAdditionalInfo.setJson(null, jsonConsumer, new Device()::setDeviceDataBytes);

    // Assert
    verify(jsonConsumer).accept(isNull());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName(
      "Test setJson(JsonNode, Consumer, Consumer); when valueOf ten; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
  void testSetJson_whenValueOfTen_thenCallsAccept() {
    // Arrange
    DoubleNode json = DoubleNode.valueOf(10.0d);
    Consumer<JsonNode> jsonConsumer = mock(Consumer.class);
    doNothing().when(jsonConsumer).accept(Mockito.<JsonNode>any());

    // Act
    BaseDataWithAdditionalInfo.setJson(json, jsonConsumer, new Device()::setDeviceDataBytes);

    // Assert
    verify(jsonConsumer).accept(isA(JsonNode.class));
  }
}
