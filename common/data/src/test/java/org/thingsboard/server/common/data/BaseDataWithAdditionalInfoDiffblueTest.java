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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonGenerator;
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
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getAdditionalInfo()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getAdditionalInfo()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenEdge_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Edge()).getAdditionalInfo());
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
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
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
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
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
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
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); given Customer(); when 'null'; then Customer() AdditionalInfo NullNode")
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
   * <ul>
   *   <li>Given Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); given Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
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
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
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
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); given RawValue(String) with v is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
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
   *   <li>Then {@link Customer#Customer(Customer)} with customer is {@link Customer#Customer()} AdditionalInfo is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); then Customer(Customer) with customer is Customer() AdditionalInfo is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
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
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
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
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} addArray.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addArray")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
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
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} addNull.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addNull")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
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
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} addObject.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfo(JsonNode)"})
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
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); when Instance; then Customer() AdditionalInfo is Instance")
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
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then {@link Customer#Customer()} AdditionalInfo is Instance {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode); when Instance; then Customer() AdditionalInfo is Instance instance")
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
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfoField(String, JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfoField(String, JsonNode)"})
  void testSetAdditionalInfoField() {
    // Arrange
    Customer customer = new Customer(new Customer());

    // Act
    customer.setAdditionalInfoField("Field", MissingNode.getInstance());

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfoField(String, JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfoField(String, JsonNode)"})
  void testSetAdditionalInfoField2() {
    // Arrange
    Customer customer = new Customer(new Customer(new Customer()));

    // Act
    customer.setAdditionalInfoField("Field", MissingNode.getInstance());

    // Assert
    JsonNode additionalInfo = customer.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   * <ul>
   *   <li>Then {@link Customer#Customer()} AdditionalInfo iterator next {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfoField(String, JsonNode); then Customer() AdditionalInfo iterator next NullNode")
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
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then {@link Customer#Customer()} AdditionalInfo {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfoField(String, JsonNode); when Instance; then Customer() AdditionalInfo ObjectNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfoField(String, JsonNode)"})
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
   * Test {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Customer#Customer()} AdditionalInfo {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setAdditionalInfoField(String, JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfoField(String, JsonNode); when 'null'; then Customer() AdditionalInfo ObjectNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setAdditionalInfoField(String, JsonNode)"})
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
   * Test {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}.
   * <ul>
   *   <li>Given {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}
   */
  @Test
  @DisplayName("Test getAdditionalInfoField(String, Function, Object); given Customer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseDataWithAdditionalInfo.getAdditionalInfoField(String, Function, Object)"})
  void testGetAdditionalInfoField_givenCustomer() {
    // Arrange, Act and Assert
    assertEquals("Default Value",
        (new Customer()).getAdditionalInfoField("Field", mock(Function.class), "Default Value"));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}.
   * <ul>
   *   <li>Given {@link Customer#Customer(Customer)} with customer is {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}
   */
  @Test
  @DisplayName("Test getAdditionalInfoField(String, Function, Object); given Customer(Customer) with customer is Customer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseDataWithAdditionalInfo.getAdditionalInfoField(String, Function, Object)"})
  void testGetAdditionalInfoField_givenCustomerWithCustomerIsCustomer() {
    // Arrange, Act and Assert
    assertEquals("Default Value",
        (new Customer(new Customer())).getAdditionalInfoField("Field", mock(Function.class), "Default Value"));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}.
   * <ul>
   *   <li>Given {@link Customer#Customer(Customer)} with customer is {@link Customer#Customer(Customer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#getAdditionalInfoField(String, Function, Object)}
   */
  @Test
  @DisplayName("Test getAdditionalInfoField(String, Function, Object); given Customer(Customer) with customer is Customer(Customer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseDataWithAdditionalInfo.getAdditionalInfoField(String, Function, Object)"})
  void testGetAdditionalInfoField_givenCustomerWithCustomerIsCustomer2() {
    // Arrange, Act and Assert
    assertEquals("Default Value", (new Customer(new Customer(new Customer()))).getAdditionalInfoField("Field",
        mock(Function.class), "Default Value"));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
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
   *   <li>Given array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with MAX_VALUE and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
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
   * Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
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
   * Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
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
   * Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
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
   * Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
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
   * Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
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
   * Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); given empty array of byte; then return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
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
   *   <li>When {@link Customer#Customer(Customer)} with customer is {@link Customer#Customer()}.</li>
   *   <li>Then return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); when Customer(Customer) with customer is Customer(); then return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
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
   * Method under test: {@link BaseDataWithAdditionalInfo#getJson(Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getJson(Supplier, Supplier); when Device(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode BaseDataWithAdditionalInfo.getJson(Supplier, Supplier)"})
  void testGetJson_whenDevice_thenReturnNull() {
    // Arrange
    Supplier<JsonNode> jsonData = new Customer()::getAdditionalInfo;

    // Act and Assert
    assertNull(BaseDataWithAdditionalInfo.getJson(jsonData, new Device()::getDeviceDataBytes));
  }

  /**
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   * <ul>
   *   <li>When {@link ArrayNode} {@link ArrayNode#serialize(JsonGenerator, SerializerProvider)} does nothing.</li>
   *   <li>Then calls {@link ArrayNode#serialize(JsonGenerator, SerializerProvider)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName("Test setJson(JsonNode, Consumer, Consumer); when ArrayNode serialize(JsonGenerator, SerializerProvider) does nothing; then calls serialize(JsonGenerator, SerializerProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
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
   * Test {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}.
   * <ul>
   *   <li>When {@link Customer} {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)} does nothing.</li>
   *   <li>Then calls {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDataWithAdditionalInfo#setJson(JsonNode, Consumer, Consumer)}
   */
  @Test
  @DisplayName("Test setJson(JsonNode, Consumer, Consumer); when Customer setAdditionalInfo(JsonNode) does nothing; then calls setAdditionalInfo(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseDataWithAdditionalInfo.setJson(JsonNode, Consumer, Consumer)"})
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
