package org.thingsboard.server.service.edge.rpc.constructor.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.gen.edge.v1.CustomerUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class CustomerMsgConstructorV1DiffblueTest {
  /**
   * Test
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   * <p>
   * Method under test:
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName("Test constructCustomerUpdatedMsg(UpdateMsgType, Customer)")
  void testConstructCustomerUpdatedMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();
    Customer customer = mock(Customer.class);
    when(customer.getAdditionalInfo()).thenReturn(null);
    when(customer.getAddress()).thenReturn("42 Main St");
    when(customer.getAddress2()).thenReturn("42 Main St");
    when(customer.getCity()).thenReturn("Oxford");
    when(customer.getCountry()).thenReturn("GB");
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getPhone()).thenReturn("6625550144");
    when(customer.getState()).thenReturn("MD");
    when(customer.getZip()).thenReturn("21654");
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(customer).setId(Mockito.<CustomerId>any());
    customer.setId(new CustomerId(null));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult = customerMsgConstructorV1
        .constructCustomerUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    verify(customer).getAdditionalInfo();
    verify(customer, atLeast(1)).getAddress();
    verify(customer, atLeast(1)).getAddress2();
    verify(customer, atLeast(1)).getCity();
    verify(customer, atLeast(1)).getCountry();
    verify(customer, atLeast(1)).getEmail();
    verify(customer, atLeast(1)).getId();
    verify(customer, atLeast(1)).getPhone();
    verify(customer, atLeast(1)).getState();
    verify(customer).getTitle();
    verify(customer, atLeast(1)).getZip();
    verify(customer).setId(isA(CustomerId.class));
    ByteString additionalInfoBytes = actualConstructCustomerUpdatedMsgResult.getAdditionalInfoBytes();
    assertEquals("", additionalInfoBytes.toStringUtf8());
    assertEquals("", actualConstructCustomerUpdatedMsgResult.getAdditionalInfo());
    Descriptors.Descriptor descriptorForType = actualConstructCustomerUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(14, fields.size());
    assertFalse(additionalInfoBytes.iterator().hasNext());
    assertFalse(actualConstructCustomerUpdatedMsgResult.hasAdditionalInfo());
    assertTrue(additionalInfoBytes.isEmpty());
    assertEquals(additionalInfoBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(additionalInfoBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(additionalInfoBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(12).toProto();
    assertEquals(additionalInfoBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(13).toProto();
    assertEquals(additionalInfoBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(additionalInfoBytes, toProtoResult.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(additionalInfoBytes, options.getGoPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, options.getSwiftPrefixBytes());
    CustomerUpdateMsg defaultInstanceForType2 = actualConstructCustomerUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getAdditionalInfoBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getAddress2Bytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getAddressBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getCityBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getCountryBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getEmailBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getEntityBytes());
    assertEquals(additionalInfoBytes, actualConstructCustomerUpdatedMsgResult.getEntityBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getPhoneBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getStateBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getTitleBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getZipBytes());
  }

  /**
   * Test
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then return AllFields size is twelve.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName("Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); given Instance; then return AllFields size is twelve")
  void testConstructCustomerUpdatedMsg_givenInstance_thenReturnAllFieldsSizeIsTwelve() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();
    Customer customer = mock(Customer.class);
    when(customer.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(customer.getAddress()).thenReturn("42 Main St");
    when(customer.getAddress2()).thenReturn("42 Main St");
    when(customer.getCity()).thenReturn("Oxford");
    when(customer.getCountry()).thenReturn("GB");
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getPhone()).thenReturn("6625550144");
    when(customer.getState()).thenReturn("MD");
    when(customer.getZip()).thenReturn("21654");
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(customer).setId(Mockito.<CustomerId>any());
    customer.setId(new CustomerId(null));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult = customerMsgConstructorV1
        .constructCustomerUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    verify(customer, atLeast(1)).getAdditionalInfo();
    verify(customer, atLeast(1)).getAddress();
    verify(customer, atLeast(1)).getAddress2();
    verify(customer, atLeast(1)).getCity();
    verify(customer, atLeast(1)).getCountry();
    verify(customer, atLeast(1)).getEmail();
    verify(customer, atLeast(1)).getId();
    verify(customer, atLeast(1)).getPhone();
    verify(customer, atLeast(1)).getState();
    verify(customer).getTitle();
    verify(customer, atLeast(1)).getZip();
    verify(customer).setId(isA(CustomerId.class));
    assertEquals(12, actualConstructCustomerUpdatedMsgResult.getAllFields().size());
  }

  /**
   * Test
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   * <ul>
   *   <li>Then return AddressBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName("Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); then return AddressBytes toStringUtf8 is empty string")
  void testConstructCustomerUpdatedMsg_thenReturnAddressBytesToStringUtf8IsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();
    Customer customer = mock(Customer.class);
    when(customer.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(customer.getAddress()).thenReturn(null);
    when(customer.getAddress2()).thenReturn("42 Main St");
    when(customer.getCity()).thenReturn("Oxford");
    when(customer.getCountry()).thenReturn("GB");
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getPhone()).thenReturn("6625550144");
    when(customer.getState()).thenReturn("MD");
    when(customer.getZip()).thenReturn("21654");
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(customer).setId(Mockito.<CustomerId>any());
    customer.setId(new CustomerId(null));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult = customerMsgConstructorV1
        .constructCustomerUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    verify(customer, atLeast(1)).getAdditionalInfo();
    verify(customer).getAddress();
    verify(customer, atLeast(1)).getAddress2();
    verify(customer, atLeast(1)).getCity();
    verify(customer, atLeast(1)).getCountry();
    verify(customer, atLeast(1)).getEmail();
    verify(customer, atLeast(1)).getId();
    verify(customer, atLeast(1)).getPhone();
    verify(customer, atLeast(1)).getState();
    verify(customer).getTitle();
    verify(customer, atLeast(1)).getZip();
    verify(customer).setId(isA(CustomerId.class));
    ByteString addressBytes = actualConstructCustomerUpdatedMsgResult.getAddressBytes();
    assertEquals("", addressBytes.toStringUtf8());
    assertEquals("", actualConstructCustomerUpdatedMsgResult.getAddress());
    Descriptors.Descriptor descriptorForType = actualConstructCustomerUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(14, fields.size());
    assertFalse(addressBytes.iterator().hasNext());
    assertFalse(actualConstructCustomerUpdatedMsgResult.hasAddress());
    assertTrue(addressBytes.isEmpty());
    assertEquals(addressBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(addressBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(addressBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(12).toProto();
    assertEquals(addressBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(13).toProto();
    assertEquals(addressBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(addressBytes, toProtoResult.getExtendeeBytes());
    assertEquals(addressBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(addressBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(addressBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(addressBytes, toProtoResult.getJsonNameBytes());
    assertEquals(addressBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(addressBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(addressBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(addressBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(addressBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(addressBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(addressBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(addressBytes, options.getCsharpNamespaceBytes());
    assertEquals(addressBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(addressBytes, options.getGoPackageBytes());
    assertEquals(addressBytes, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(addressBytes, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(addressBytes, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(addressBytes, options.getObjcClassPrefixBytes());
    assertEquals(addressBytes, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(addressBytes, options.getPhpClassPrefixBytes());
    assertEquals(addressBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(addressBytes, options.getPhpNamespaceBytes());
    assertEquals(addressBytes, options.getRubyPackageBytes());
    assertEquals(addressBytes, options.getSwiftPrefixBytes());
    CustomerUpdateMsg defaultInstanceForType2 = actualConstructCustomerUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(addressBytes, defaultInstanceForType2.getAdditionalInfoBytes());
    assertEquals(addressBytes, defaultInstanceForType2.getAddress2Bytes());
    assertEquals(addressBytes, defaultInstanceForType2.getAddressBytes());
    assertEquals(addressBytes, defaultInstanceForType2.getCityBytes());
    assertEquals(addressBytes, defaultInstanceForType2.getCountryBytes());
    assertEquals(addressBytes, defaultInstanceForType2.getEmailBytes());
    assertEquals(addressBytes, defaultInstanceForType2.getEntityBytes());
    assertEquals(addressBytes, actualConstructCustomerUpdatedMsgResult.getEntityBytes());
    assertEquals(addressBytes, defaultInstanceForType2.getPhoneBytes());
    assertEquals(addressBytes, defaultInstanceForType2.getStateBytes());
    assertEquals(addressBytes, defaultInstanceForType2.getTitleBytes());
    assertEquals(addressBytes, defaultInstanceForType2.getZipBytes());
  }

  /**
   * Test
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   * <ul>
   *   <li>Then return CityBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName("Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); then return CityBytes toStringUtf8 is empty string")
  void testConstructCustomerUpdatedMsg_thenReturnCityBytesToStringUtf8IsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();
    Customer customer = mock(Customer.class);
    when(customer.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(customer.getAddress()).thenReturn("42 Main St");
    when(customer.getAddress2()).thenReturn("42 Main St");
    when(customer.getCity()).thenReturn(null);
    when(customer.getCountry()).thenReturn("GB");
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getPhone()).thenReturn("6625550144");
    when(customer.getState()).thenReturn("MD");
    when(customer.getZip()).thenReturn("21654");
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(customer).setId(Mockito.<CustomerId>any());
    customer.setId(new CustomerId(null));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult = customerMsgConstructorV1
        .constructCustomerUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    verify(customer, atLeast(1)).getAdditionalInfo();
    verify(customer, atLeast(1)).getAddress();
    verify(customer, atLeast(1)).getAddress2();
    verify(customer).getCity();
    verify(customer, atLeast(1)).getCountry();
    verify(customer, atLeast(1)).getEmail();
    verify(customer, atLeast(1)).getId();
    verify(customer, atLeast(1)).getPhone();
    verify(customer, atLeast(1)).getState();
    verify(customer).getTitle();
    verify(customer, atLeast(1)).getZip();
    verify(customer).setId(isA(CustomerId.class));
    ByteString cityBytes = actualConstructCustomerUpdatedMsgResult.getCityBytes();
    assertEquals("", cityBytes.toStringUtf8());
    assertEquals("", actualConstructCustomerUpdatedMsgResult.getCity());
    Descriptors.Descriptor descriptorForType = actualConstructCustomerUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(14, fields.size());
    assertFalse(cityBytes.iterator().hasNext());
    assertFalse(actualConstructCustomerUpdatedMsgResult.hasCity());
    assertTrue(cityBytes.isEmpty());
    assertEquals(cityBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(cityBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(cityBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(12).toProto();
    assertEquals(cityBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(13).toProto();
    assertEquals(cityBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(cityBytes, toProtoResult.getExtendeeBytes());
    assertEquals(cityBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(cityBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(cityBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(cityBytes, toProtoResult.getJsonNameBytes());
    assertEquals(cityBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(cityBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(cityBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(cityBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(cityBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(cityBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(cityBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(cityBytes, options.getCsharpNamespaceBytes());
    assertEquals(cityBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(cityBytes, options.getGoPackageBytes());
    assertEquals(cityBytes, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(cityBytes, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(cityBytes, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(cityBytes, options.getObjcClassPrefixBytes());
    assertEquals(cityBytes, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(cityBytes, options.getPhpClassPrefixBytes());
    assertEquals(cityBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(cityBytes, options.getPhpNamespaceBytes());
    assertEquals(cityBytes, options.getRubyPackageBytes());
    assertEquals(cityBytes, options.getSwiftPrefixBytes());
    CustomerUpdateMsg defaultInstanceForType2 = actualConstructCustomerUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(cityBytes, defaultInstanceForType2.getAdditionalInfoBytes());
    assertEquals(cityBytes, defaultInstanceForType2.getAddress2Bytes());
    assertEquals(cityBytes, defaultInstanceForType2.getAddressBytes());
    assertEquals(cityBytes, defaultInstanceForType2.getCityBytes());
    assertEquals(cityBytes, defaultInstanceForType2.getCountryBytes());
    assertEquals(cityBytes, defaultInstanceForType2.getEmailBytes());
    assertEquals(cityBytes, defaultInstanceForType2.getEntityBytes());
    assertEquals(cityBytes, actualConstructCustomerUpdatedMsgResult.getEntityBytes());
    assertEquals(cityBytes, defaultInstanceForType2.getPhoneBytes());
    assertEquals(cityBytes, defaultInstanceForType2.getStateBytes());
    assertEquals(cityBytes, defaultInstanceForType2.getTitleBytes());
    assertEquals(cityBytes, defaultInstanceForType2.getZipBytes());
  }

  /**
   * Test
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   * <ul>
   *   <li>Then return CountryBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName("Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); then return CountryBytes toStringUtf8 is empty string")
  void testConstructCustomerUpdatedMsg_thenReturnCountryBytesToStringUtf8IsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();
    Customer customer = mock(Customer.class);
    when(customer.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(customer.getAddress()).thenReturn("42 Main St");
    when(customer.getAddress2()).thenReturn("42 Main St");
    when(customer.getCity()).thenReturn("Oxford");
    when(customer.getCountry()).thenReturn(null);
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getPhone()).thenReturn("6625550144");
    when(customer.getState()).thenReturn("MD");
    when(customer.getZip()).thenReturn("21654");
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(customer).setId(Mockito.<CustomerId>any());
    customer.setId(new CustomerId(null));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult = customerMsgConstructorV1
        .constructCustomerUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    verify(customer, atLeast(1)).getAdditionalInfo();
    verify(customer, atLeast(1)).getAddress();
    verify(customer, atLeast(1)).getAddress2();
    verify(customer, atLeast(1)).getCity();
    verify(customer).getCountry();
    verify(customer, atLeast(1)).getEmail();
    verify(customer, atLeast(1)).getId();
    verify(customer, atLeast(1)).getPhone();
    verify(customer, atLeast(1)).getState();
    verify(customer).getTitle();
    verify(customer, atLeast(1)).getZip();
    verify(customer).setId(isA(CustomerId.class));
    ByteString countryBytes = actualConstructCustomerUpdatedMsgResult.getCountryBytes();
    assertEquals("", countryBytes.toStringUtf8());
    assertEquals("", actualConstructCustomerUpdatedMsgResult.getCountry());
    Descriptors.Descriptor descriptorForType = actualConstructCustomerUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(14, fields.size());
    assertFalse(countryBytes.iterator().hasNext());
    assertFalse(actualConstructCustomerUpdatedMsgResult.hasCountry());
    assertTrue(countryBytes.isEmpty());
    assertEquals(countryBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(countryBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(countryBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(12).toProto();
    assertEquals(countryBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(13).toProto();
    assertEquals(countryBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(countryBytes, toProtoResult.getExtendeeBytes());
    assertEquals(countryBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(countryBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(countryBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(countryBytes, toProtoResult.getJsonNameBytes());
    assertEquals(countryBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(countryBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(countryBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(countryBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(countryBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(countryBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(countryBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(countryBytes, options.getCsharpNamespaceBytes());
    assertEquals(countryBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(countryBytes, options.getGoPackageBytes());
    assertEquals(countryBytes, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(countryBytes, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(countryBytes, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(countryBytes, options.getObjcClassPrefixBytes());
    assertEquals(countryBytes, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(countryBytes, options.getPhpClassPrefixBytes());
    assertEquals(countryBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(countryBytes, options.getPhpNamespaceBytes());
    assertEquals(countryBytes, options.getRubyPackageBytes());
    assertEquals(countryBytes, options.getSwiftPrefixBytes());
    CustomerUpdateMsg defaultInstanceForType2 = actualConstructCustomerUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(countryBytes, defaultInstanceForType2.getAdditionalInfoBytes());
    assertEquals(countryBytes, defaultInstanceForType2.getAddress2Bytes());
    assertEquals(countryBytes, defaultInstanceForType2.getAddressBytes());
    assertEquals(countryBytes, defaultInstanceForType2.getCityBytes());
    assertEquals(countryBytes, defaultInstanceForType2.getCountryBytes());
    assertEquals(countryBytes, defaultInstanceForType2.getEmailBytes());
    assertEquals(countryBytes, defaultInstanceForType2.getEntityBytes());
    assertEquals(countryBytes, actualConstructCustomerUpdatedMsgResult.getEntityBytes());
    assertEquals(countryBytes, defaultInstanceForType2.getPhoneBytes());
    assertEquals(countryBytes, defaultInstanceForType2.getStateBytes());
    assertEquals(countryBytes, defaultInstanceForType2.getTitleBytes());
    assertEquals(countryBytes, defaultInstanceForType2.getZipBytes());
  }

  /**
   * Test
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   * <ul>
   *   <li>Then return EmailBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName("Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); then return EmailBytes toStringUtf8 is empty string")
  void testConstructCustomerUpdatedMsg_thenReturnEmailBytesToStringUtf8IsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();
    Customer customer = mock(Customer.class);
    when(customer.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(customer.getAddress()).thenReturn("42 Main St");
    when(customer.getAddress2()).thenReturn("42 Main St");
    when(customer.getCity()).thenReturn("Oxford");
    when(customer.getCountry()).thenReturn("GB");
    when(customer.getEmail()).thenReturn(null);
    when(customer.getPhone()).thenReturn("6625550144");
    when(customer.getState()).thenReturn("MD");
    when(customer.getZip()).thenReturn("21654");
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(customer).setId(Mockito.<CustomerId>any());
    customer.setId(new CustomerId(null));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult = customerMsgConstructorV1
        .constructCustomerUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    verify(customer, atLeast(1)).getAdditionalInfo();
    verify(customer, atLeast(1)).getAddress();
    verify(customer, atLeast(1)).getAddress2();
    verify(customer, atLeast(1)).getCity();
    verify(customer, atLeast(1)).getCountry();
    verify(customer).getEmail();
    verify(customer, atLeast(1)).getId();
    verify(customer, atLeast(1)).getPhone();
    verify(customer, atLeast(1)).getState();
    verify(customer).getTitle();
    verify(customer, atLeast(1)).getZip();
    verify(customer).setId(isA(CustomerId.class));
    ByteString emailBytes = actualConstructCustomerUpdatedMsgResult.getEmailBytes();
    assertEquals("", emailBytes.toStringUtf8());
    assertEquals("", actualConstructCustomerUpdatedMsgResult.getEmail());
    Descriptors.Descriptor descriptorForType = actualConstructCustomerUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(14, fields.size());
    assertFalse(emailBytes.iterator().hasNext());
    assertFalse(actualConstructCustomerUpdatedMsgResult.hasEmail());
    assertTrue(emailBytes.isEmpty());
    assertEquals(emailBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(emailBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(emailBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(12).toProto();
    assertEquals(emailBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(13).toProto();
    assertEquals(emailBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(emailBytes, toProtoResult.getExtendeeBytes());
    assertEquals(emailBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(emailBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(emailBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(emailBytes, toProtoResult.getJsonNameBytes());
    assertEquals(emailBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(emailBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(emailBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(emailBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(emailBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(emailBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(emailBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(emailBytes, options.getCsharpNamespaceBytes());
    assertEquals(emailBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(emailBytes, options.getGoPackageBytes());
    assertEquals(emailBytes, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(emailBytes, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(emailBytes, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(emailBytes, options.getObjcClassPrefixBytes());
    assertEquals(emailBytes, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(emailBytes, options.getPhpClassPrefixBytes());
    assertEquals(emailBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(emailBytes, options.getPhpNamespaceBytes());
    assertEquals(emailBytes, options.getRubyPackageBytes());
    assertEquals(emailBytes, options.getSwiftPrefixBytes());
    CustomerUpdateMsg defaultInstanceForType2 = actualConstructCustomerUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(emailBytes, defaultInstanceForType2.getAdditionalInfoBytes());
    assertEquals(emailBytes, defaultInstanceForType2.getAddress2Bytes());
    assertEquals(emailBytes, defaultInstanceForType2.getAddressBytes());
    assertEquals(emailBytes, defaultInstanceForType2.getCityBytes());
    assertEquals(emailBytes, defaultInstanceForType2.getCountryBytes());
    assertEquals(emailBytes, defaultInstanceForType2.getEmailBytes());
    assertEquals(emailBytes, defaultInstanceForType2.getEntityBytes());
    assertEquals(emailBytes, actualConstructCustomerUpdatedMsgResult.getEntityBytes());
    assertEquals(emailBytes, defaultInstanceForType2.getPhoneBytes());
    assertEquals(emailBytes, defaultInstanceForType2.getStateBytes());
    assertEquals(emailBytes, defaultInstanceForType2.getTitleBytes());
    assertEquals(emailBytes, defaultInstanceForType2.getZipBytes());
  }

  /**
   * Test
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   * <ul>
   *   <li>Then return Phone is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName("Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); then return Phone is empty string")
  void testConstructCustomerUpdatedMsg_thenReturnPhoneIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();
    Customer customer = mock(Customer.class);
    when(customer.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(customer.getAddress()).thenReturn("42 Main St");
    when(customer.getAddress2()).thenReturn("42 Main St");
    when(customer.getCity()).thenReturn("Oxford");
    when(customer.getCountry()).thenReturn("GB");
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getPhone()).thenReturn(null);
    when(customer.getState()).thenReturn("MD");
    when(customer.getZip()).thenReturn("21654");
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(customer).setId(Mockito.<CustomerId>any());
    customer.setId(new CustomerId(null));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult = customerMsgConstructorV1
        .constructCustomerUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    verify(customer, atLeast(1)).getAdditionalInfo();
    verify(customer, atLeast(1)).getAddress();
    verify(customer, atLeast(1)).getAddress2();
    verify(customer, atLeast(1)).getCity();
    verify(customer, atLeast(1)).getCountry();
    verify(customer, atLeast(1)).getEmail();
    verify(customer, atLeast(1)).getId();
    verify(customer).getPhone();
    verify(customer, atLeast(1)).getState();
    verify(customer).getTitle();
    verify(customer, atLeast(1)).getZip();
    verify(customer).setId(isA(CustomerId.class));
    assertEquals("", actualConstructCustomerUpdatedMsgResult.getPhone());
    assertFalse(actualConstructCustomerUpdatedMsgResult.hasPhone());
  }

  /**
   * Test
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   * <ul>
   *   <li>Then return State is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName("Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); then return State is empty string")
  void testConstructCustomerUpdatedMsg_thenReturnStateIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();
    Customer customer = mock(Customer.class);
    when(customer.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(customer.getAddress()).thenReturn("42 Main St");
    when(customer.getAddress2()).thenReturn("42 Main St");
    when(customer.getCity()).thenReturn("Oxford");
    when(customer.getCountry()).thenReturn("GB");
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getPhone()).thenReturn("6625550144");
    when(customer.getState()).thenReturn(null);
    when(customer.getZip()).thenReturn("21654");
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(customer).setId(Mockito.<CustomerId>any());
    customer.setId(new CustomerId(null));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult = customerMsgConstructorV1
        .constructCustomerUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    verify(customer, atLeast(1)).getAdditionalInfo();
    verify(customer, atLeast(1)).getAddress();
    verify(customer, atLeast(1)).getAddress2();
    verify(customer, atLeast(1)).getCity();
    verify(customer, atLeast(1)).getCountry();
    verify(customer, atLeast(1)).getEmail();
    verify(customer, atLeast(1)).getId();
    verify(customer, atLeast(1)).getPhone();
    verify(customer).getState();
    verify(customer).getTitle();
    verify(customer, atLeast(1)).getZip();
    verify(customer).setId(isA(CustomerId.class));
    assertEquals("", actualConstructCustomerUpdatedMsgResult.getState());
    assertFalse(actualConstructCustomerUpdatedMsgResult.hasState());
  }

  /**
   * Test
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}.
   * <ul>
   *   <li>Then return Zip is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerMsgConstructorV1#constructCustomerUpdatedMsg(UpdateMsgType, Customer)}
   */
  @Test
  @DisplayName("Test constructCustomerUpdatedMsg(UpdateMsgType, Customer); then return Zip is empty string")
  void testConstructCustomerUpdatedMsg_thenReturnZipIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerMsgConstructorV1 customerMsgConstructorV1 = new CustomerMsgConstructorV1();
    Customer customer = mock(Customer.class);
    when(customer.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(customer.getAddress()).thenReturn("42 Main St");
    when(customer.getAddress2()).thenReturn("42 Main St");
    when(customer.getCity()).thenReturn("Oxford");
    when(customer.getCountry()).thenReturn("GB");
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getPhone()).thenReturn("6625550144");
    when(customer.getState()).thenReturn("MD");
    when(customer.getZip()).thenReturn(null);
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(customer).setId(Mockito.<CustomerId>any());
    customer.setId(new CustomerId(null));

    // Act
    CustomerUpdateMsg actualConstructCustomerUpdatedMsgResult = customerMsgConstructorV1
        .constructCustomerUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, customer);

    // Assert
    verify(customer, atLeast(1)).getAdditionalInfo();
    verify(customer, atLeast(1)).getAddress();
    verify(customer, atLeast(1)).getAddress2();
    verify(customer, atLeast(1)).getCity();
    verify(customer, atLeast(1)).getCountry();
    verify(customer, atLeast(1)).getEmail();
    verify(customer, atLeast(1)).getId();
    verify(customer, atLeast(1)).getPhone();
    verify(customer, atLeast(1)).getState();
    verify(customer).getTitle();
    verify(customer).getZip();
    verify(customer).setId(isA(CustomerId.class));
    assertEquals("", actualConstructCustomerUpdatedMsgResult.getZip());
    assertFalse(actualConstructCustomerUpdatedMsgResult.hasZip());
  }
}
