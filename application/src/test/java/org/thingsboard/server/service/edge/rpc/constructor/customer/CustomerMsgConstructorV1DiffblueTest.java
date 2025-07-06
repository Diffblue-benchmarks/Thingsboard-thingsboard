package org.thingsboard.server.service.edge.rpc.constructor.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.gen.edge.v1.CustomerUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class CustomerMsgConstructorV1DiffblueTest {
  /**
   * Test {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   *
   * <ul>
   *   <li>Given {@code 21654}.
   *   <li>Then return SerializedSize is {@link Integer#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName(
      "Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); given '21654'; then return SerializedSize is SIZE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "CustomerUpdateMsg CustomerMsgConstructorV1.constructCustomerUpdatedMsg(UpdateMsgType, Customer)"
  })
  void testConstructCustomerUpdatedMsg_given21654_thenReturnSerializedSizeIsSize() {
    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();

    Customer customer = new Customer();
    customer.setZip("21654");
    customer.setTitle("Dr");
    customer.setId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult =
        customerMsgConstructorV1.constructCustomerUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    assertEquals(Integer.SIZE, actualConstructCustomerUpdatedMsgResult.getSerializedSize());
    assertEquals("21654", actualConstructCustomerUpdatedMsgResult.getZip());
    ByteString zipBytes = actualConstructCustomerUpdatedMsgResult.getZipBytes();
    assertFalse(zipBytes.isEmpty());
    ByteIterator iteratorResult = zipBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('2', iteratorResult.next().byteValue());
    assertEquals('1', iteratorResult.next().byteValue());
    assertEquals('6', iteratorResult.next().byteValue());
    assertEquals("21654", zipBytes.toStringUtf8());
    assertTrue(actualConstructCustomerUpdatedMsgResult.hasZip());
  }

  /**
   * Test {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   *
   * <ul>
   *   <li>Given {@code 6625550144}.
   *   <li>Then return Phone is {@code 6625550144}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName(
      "Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); given '6625550144'; then return Phone is '6625550144'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "CustomerUpdateMsg CustomerMsgConstructorV1.constructCustomerUpdatedMsg(UpdateMsgType, Customer)"
  })
  void testConstructCustomerUpdatedMsg_given6625550144_thenReturnPhoneIs6625550144() {
    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();

    Customer customer = new Customer();
    customer.setPhone("6625550144");
    customer.setTitle("Dr");
    customer.setId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult =
        customerMsgConstructorV1.constructCustomerUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    assertEquals("6625550144", actualConstructCustomerUpdatedMsgResult.getPhone());
    ByteString phoneBytes = actualConstructCustomerUpdatedMsgResult.getPhoneBytes();
    assertFalse(phoneBytes.isEmpty());
    ByteIterator iteratorResult = phoneBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('6', iteratorResult.next().byteValue());
    assertEquals('6', iteratorResult.next().byteValue());
    assertEquals('2', iteratorResult.next().byteValue());
    assertEquals("6625550144", phoneBytes.toStringUtf8());
    assertTrue(actualConstructCustomerUpdatedMsgResult.hasPhone());
  }

  /**
   * Test {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   *
   * <ul>
   *   <li>Given {@code GB}.
   *   <li>Then return Country is {@code GB}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName(
      "Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); given 'GB'; then return Country is 'GB'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "CustomerUpdateMsg CustomerMsgConstructorV1.constructCustomerUpdatedMsg(UpdateMsgType, Customer)"
  })
  void testConstructCustomerUpdatedMsg_givenGb_thenReturnCountryIsGb() {
    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();

    Customer customer = new Customer();
    customer.setCountry("GB");
    customer.setTitle("Dr");
    customer.setId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult =
        customerMsgConstructorV1.constructCustomerUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    assertEquals("GB", actualConstructCustomerUpdatedMsgResult.getCountry());
    ByteString countryBytes = actualConstructCustomerUpdatedMsgResult.getCountryBytes();
    assertFalse(countryBytes.isEmpty());
    ByteIterator iteratorResult = countryBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('G', nextResult.byteValue());
    assertEquals('B', nextResult2.byteValue());
    assertEquals("GB", countryBytes.toStringUtf8());
    assertTrue(actualConstructCustomerUpdatedMsgResult.hasCountry());
  }

  /**
   * Test {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   *
   * <ul>
   *   <li>Given {@code MD}.
   *   <li>Then return State is {@code MD}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName(
      "Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); given 'MD'; then return State is 'MD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "CustomerUpdateMsg CustomerMsgConstructorV1.constructCustomerUpdatedMsg(UpdateMsgType, Customer)"
  })
  void testConstructCustomerUpdatedMsg_givenMd_thenReturnStateIsMd() {
    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();

    Customer customer = new Customer();
    customer.setState("MD");
    customer.setTitle("Dr");
    customer.setId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult =
        customerMsgConstructorV1.constructCustomerUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    assertEquals("MD", actualConstructCustomerUpdatedMsgResult.getState());
    ByteString stateBytes = actualConstructCustomerUpdatedMsgResult.getStateBytes();
    assertFalse(stateBytes.isEmpty());
    ByteIterator iteratorResult = stateBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('M', nextResult.byteValue());
    assertEquals('D', nextResult2.byteValue());
    assertEquals("MD", stateBytes.toStringUtf8());
    assertTrue(actualConstructCustomerUpdatedMsgResult.hasState());
  }

  /**
   * Test {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   *
   * <ul>
   *   <li>Given {@code Oxford}.
   *   <li>Then return City is {@code Oxford}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName(
      "Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); given 'Oxford'; then return City is 'Oxford'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "CustomerUpdateMsg CustomerMsgConstructorV1.constructCustomerUpdatedMsg(UpdateMsgType, Customer)"
  })
  void testConstructCustomerUpdatedMsg_givenOxford_thenReturnCityIsOxford() {
    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();

    Customer customer = new Customer();
    customer.setCity("Oxford");
    customer.setTitle("Dr");
    customer.setId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult =
        customerMsgConstructorV1.constructCustomerUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    assertEquals("Oxford", actualConstructCustomerUpdatedMsgResult.getCity());
    ByteString cityBytes = actualConstructCustomerUpdatedMsgResult.getCityBytes();
    assertFalse(cityBytes.isEmpty());
    ByteIterator iteratorResult = cityBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('O', iteratorResult.next().byteValue());
    assertEquals('x', iteratorResult.next().byteValue());
    assertEquals('f', iteratorResult.next().byteValue());
    assertEquals("Oxford", cityBytes.toStringUtf8());
    assertEquals(33, actualConstructCustomerUpdatedMsgResult.getSerializedSize());
    assertTrue(actualConstructCustomerUpdatedMsgResult.hasCity());
  }

  /**
   * Test {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   *
   * <ul>
   *   <li>Then return Address2 is {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName(
      "Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); then return Address2 is '42 Main St'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "CustomerUpdateMsg CustomerMsgConstructorV1.constructCustomerUpdatedMsg(UpdateMsgType, Customer)"
  })
  void testConstructCustomerUpdatedMsg_thenReturnAddress2Is42MainSt() {
    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();

    Customer customer = new Customer();
    customer.setAddress2("42 Main St");
    customer.setTitle("Dr");
    customer.setId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult =
        customerMsgConstructorV1.constructCustomerUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    assertEquals("42 Main St", actualConstructCustomerUpdatedMsgResult.getAddress2());
    ByteString address2Bytes = actualConstructCustomerUpdatedMsgResult.getAddress2Bytes();
    assertFalse(address2Bytes.isEmpty());
    ByteIterator iteratorResult = address2Bytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('4', iteratorResult.next().byteValue());
    assertEquals('2', iteratorResult.next().byteValue());
    assertEquals(' ', iteratorResult.next().byteValue());
    assertEquals("42 Main St", address2Bytes.toStringUtf8());
    assertTrue(actualConstructCustomerUpdatedMsgResult.hasAddress2());
  }

  /**
   * Test {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   *
   * <ul>
   *   <li>Then return Address is {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName(
      "Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); then return Address is '42 Main St'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "CustomerUpdateMsg CustomerMsgConstructorV1.constructCustomerUpdatedMsg(UpdateMsgType, Customer)"
  })
  void testConstructCustomerUpdatedMsg_thenReturnAddressIs42MainSt() {
    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();

    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setTitle("Dr");
    customer.setId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult =
        customerMsgConstructorV1.constructCustomerUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    assertEquals("42 Main St", actualConstructCustomerUpdatedMsgResult.getAddress());
    ByteString addressBytes = actualConstructCustomerUpdatedMsgResult.getAddressBytes();
    assertFalse(addressBytes.isEmpty());
    ByteIterator iteratorResult = addressBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('4', iteratorResult.next().byteValue());
    assertEquals('2', iteratorResult.next().byteValue());
    assertEquals(' ', iteratorResult.next().byteValue());
    assertEquals("42 Main St", addressBytes.toStringUtf8());
    assertTrue(actualConstructCustomerUpdatedMsgResult.hasAddress());
  }

  /**
   * Test {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   *
   * <ul>
   *   <li>Then return Email is {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName(
      "Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); then return Email is 'jane.doe@example.org'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "CustomerUpdateMsg CustomerMsgConstructorV1.constructCustomerUpdatedMsg(UpdateMsgType, Customer)"
  })
  void testConstructCustomerUpdatedMsg_thenReturnEmailIsJaneDoeExampleOrg() {
    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();

    Customer customer = new Customer();
    customer.setEmail("jane.doe@example.org");
    customer.setTitle("Dr");
    customer.setId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult =
        customerMsgConstructorV1.constructCustomerUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    assertEquals("jane.doe@example.org", actualConstructCustomerUpdatedMsgResult.getEmail());
    ByteString emailBytes = actualConstructCustomerUpdatedMsgResult.getEmailBytes();
    assertFalse(emailBytes.isEmpty());
    ByteIterator iteratorResult = emailBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('j', iteratorResult.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals("jane.doe@example.org", emailBytes.toStringUtf8());
    assertEquals(47, actualConstructCustomerUpdatedMsgResult.getSerializedSize());
    assertTrue(actualConstructCustomerUpdatedMsgResult.hasEmail());
  }

  /**
   * Test {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName(
      "Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); then return SerializedSize is twenty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "CustomerUpdateMsg CustomerMsgConstructorV1.constructCustomerUpdatedMsg(UpdateMsgType, Customer)"
  })
  void testConstructCustomerUpdatedMsg_thenReturnSerializedSizeIsTwentyFive() {
    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();

    Customer customer = new Customer();
    customer.setTitle("Dr");
    customer.setId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult =
        customerMsgConstructorV1.constructCustomerUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    assertEquals(25, actualConstructCustomerUpdatedMsgResult.getSerializedSize());
    assertEquals(3, actualConstructCustomerUpdatedMsgResult.getAllFields().size());
  }
}
