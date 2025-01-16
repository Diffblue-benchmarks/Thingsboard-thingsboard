package org.thingsboard.server.service.edge.rpc.constructor.tenant;

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
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.gen.edge.v1.TenantUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class TenantMsgConstructorV1DiffblueTest {
  /**
   * Test
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   * <p>
   * Method under test:
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}
   */
  @Test
  @DisplayName("Test constructTenantUpdateMsg(UpdateMsgType, Tenant)")
  void testConstructTenantUpdateMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();
    Tenant tenant = mock(Tenant.class);
    when(tenant.getAdditionalInfo()).thenReturn(null);
    when(tenant.getAddress()).thenReturn("42 Main St");
    when(tenant.getAddress2()).thenReturn("42 Main St");
    when(tenant.getCity()).thenReturn("Oxford");
    when(tenant.getCountry()).thenReturn("GB");
    when(tenant.getEmail()).thenReturn("jane.doe@example.org");
    when(tenant.getPhone()).thenReturn("6625550144");
    when(tenant.getState()).thenReturn("MD");
    when(tenant.getZip()).thenReturn("21654");
    when(tenant.getRegion()).thenReturn("us-east-2");
    when(tenant.getTenantProfileId()).thenReturn(new TenantProfileId(UUID.randomUUID()));
    when(tenant.getTitle()).thenReturn("Dr");
    when(tenant.getId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(tenant).setId(Mockito.<TenantId>any());
    tenant.setId(new TenantId(null));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult = tenantMsgConstructorV1
        .constructTenantUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant);

    // Assert
    verify(tenant).getAdditionalInfo();
    verify(tenant, atLeast(1)).getAddress();
    verify(tenant, atLeast(1)).getAddress2();
    verify(tenant, atLeast(1)).getCity();
    verify(tenant, atLeast(1)).getCountry();
    verify(tenant, atLeast(1)).getEmail();
    verify(tenant, atLeast(1)).getId();
    verify(tenant, atLeast(1)).getPhone();
    verify(tenant).getRegion();
    verify(tenant, atLeast(1)).getState();
    verify(tenant, atLeast(1)).getTenantProfileId();
    verify(tenant).getTitle();
    verify(tenant, atLeast(1)).getZip();
    verify(tenant).setId(isA(TenantId.class));
    ByteString additionalInfoBytes = actualConstructTenantUpdateMsgResult.getAdditionalInfoBytes();
    assertEquals("", additionalInfoBytes.toStringUtf8());
    assertEquals("", actualConstructTenantUpdateMsgResult.getAdditionalInfo());
    Descriptors.Descriptor descriptorForType = actualConstructTenantUpdateMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(17, fields.size());
    assertFalse(additionalInfoBytes.iterator().hasNext());
    assertFalse(actualConstructTenantUpdateMsgResult.hasAdditionalInfo());
    assertTrue(additionalInfoBytes.isEmpty());
    assertEquals(additionalInfoBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(additionalInfoBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(additionalInfoBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(15).toProto();
    assertEquals(additionalInfoBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(Short.SIZE).toProto();
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
    assertEquals(additionalInfoBytes, options.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getGoPackageBytes());
    assertEquals(additionalInfoBytes, options.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, options.getSwiftPrefixBytes());
    TenantUpdateMsg defaultInstanceForType = actualConstructTenantUpdateMsgResult.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType.getAdditionalInfoBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getAddress2Bytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getAddressBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getCityBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getCountryBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getEmailBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getEntityBytes());
    assertEquals(additionalInfoBytes, actualConstructTenantUpdateMsgResult.getEntityBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getPhoneBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getRegionBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getStateBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getTitleBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getZipBytes());
  }

  /**
   * Test
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   * <ul>
   *   <li>Given Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}
   */
  @Test
  @DisplayName("Test constructTenantUpdateMsg(UpdateMsgType, Tenant); given Instance")
  void testConstructTenantUpdateMsg_givenInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();
    Tenant tenant = mock(Tenant.class);
    when(tenant.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(tenant.getAddress()).thenReturn("42 Main St");
    when(tenant.getAddress2()).thenReturn("42 Main St");
    when(tenant.getCity()).thenReturn("Oxford");
    when(tenant.getCountry()).thenReturn("GB");
    when(tenant.getEmail()).thenReturn("jane.doe@example.org");
    when(tenant.getPhone()).thenReturn("6625550144");
    when(tenant.getState()).thenReturn("MD");
    when(tenant.getZip()).thenReturn("21654");
    when(tenant.getRegion()).thenReturn("us-east-2");
    when(tenant.getTenantProfileId()).thenReturn(new TenantProfileId(UUID.randomUUID()));
    when(tenant.getTitle()).thenReturn("Dr");
    when(tenant.getId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(tenant).setId(Mockito.<TenantId>any());
    tenant.setId(new TenantId(null));

    // Act
    tenantMsgConstructorV1.constructTenantUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant);

    // Assert
    verify(tenant, atLeast(1)).getAdditionalInfo();
    verify(tenant, atLeast(1)).getAddress();
    verify(tenant, atLeast(1)).getAddress2();
    verify(tenant, atLeast(1)).getCity();
    verify(tenant, atLeast(1)).getCountry();
    verify(tenant, atLeast(1)).getEmail();
    verify(tenant, atLeast(1)).getId();
    verify(tenant, atLeast(1)).getPhone();
    verify(tenant).getRegion();
    verify(tenant, atLeast(1)).getState();
    verify(tenant, atLeast(1)).getTenantProfileId();
    verify(tenant).getTitle();
    verify(tenant, atLeast(1)).getZip();
    verify(tenant).setId(isA(TenantId.class));
  }

  /**
   * Test
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   * <ul>
   *   <li>Then return AddressBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}
   */
  @Test
  @DisplayName("Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return AddressBytes toStringUtf8 is empty string")
  void testConstructTenantUpdateMsg_thenReturnAddressBytesToStringUtf8IsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();
    Tenant tenant = mock(Tenant.class);
    when(tenant.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(tenant.getAddress()).thenReturn(null);
    when(tenant.getAddress2()).thenReturn("42 Main St");
    when(tenant.getCity()).thenReturn("Oxford");
    when(tenant.getCountry()).thenReturn("GB");
    when(tenant.getEmail()).thenReturn("jane.doe@example.org");
    when(tenant.getPhone()).thenReturn("6625550144");
    when(tenant.getState()).thenReturn("MD");
    when(tenant.getZip()).thenReturn("21654");
    when(tenant.getRegion()).thenReturn("us-east-2");
    when(tenant.getTenantProfileId()).thenReturn(new TenantProfileId(UUID.randomUUID()));
    when(tenant.getTitle()).thenReturn("Dr");
    when(tenant.getId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(tenant).setId(Mockito.<TenantId>any());
    tenant.setId(new TenantId(null));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult = tenantMsgConstructorV1
        .constructTenantUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant);

    // Assert
    verify(tenant, atLeast(1)).getAdditionalInfo();
    verify(tenant).getAddress();
    verify(tenant, atLeast(1)).getAddress2();
    verify(tenant, atLeast(1)).getCity();
    verify(tenant, atLeast(1)).getCountry();
    verify(tenant, atLeast(1)).getEmail();
    verify(tenant, atLeast(1)).getId();
    verify(tenant, atLeast(1)).getPhone();
    verify(tenant).getRegion();
    verify(tenant, atLeast(1)).getState();
    verify(tenant, atLeast(1)).getTenantProfileId();
    verify(tenant).getTitle();
    verify(tenant, atLeast(1)).getZip();
    verify(tenant).setId(isA(TenantId.class));
    ByteString addressBytes = actualConstructTenantUpdateMsgResult.getAddressBytes();
    assertEquals("", addressBytes.toStringUtf8());
    assertEquals("", actualConstructTenantUpdateMsgResult.getAddress());
    Descriptors.Descriptor descriptorForType = actualConstructTenantUpdateMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(17, fields.size());
    assertFalse(addressBytes.iterator().hasNext());
    assertFalse(actualConstructTenantUpdateMsgResult.hasAddress());
    assertTrue(addressBytes.isEmpty());
    assertEquals(addressBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(addressBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(addressBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(15).toProto();
    assertEquals(addressBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(Short.SIZE).toProto();
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
    assertEquals(addressBytes, options.getCsharpNamespaceBytes());
    assertEquals(addressBytes, options.getGoPackageBytes());
    assertEquals(addressBytes, options.getObjcClassPrefixBytes());
    assertEquals(addressBytes, options.getPhpClassPrefixBytes());
    assertEquals(addressBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(addressBytes, options.getPhpNamespaceBytes());
    assertEquals(addressBytes, options.getRubyPackageBytes());
    assertEquals(addressBytes, options.getSwiftPrefixBytes());
    TenantUpdateMsg defaultInstanceForType = actualConstructTenantUpdateMsgResult.getDefaultInstanceForType();
    assertEquals(addressBytes, defaultInstanceForType.getAdditionalInfoBytes());
    assertEquals(addressBytes, defaultInstanceForType.getAddress2Bytes());
    assertEquals(addressBytes, defaultInstanceForType.getAddressBytes());
    assertEquals(addressBytes, defaultInstanceForType.getCityBytes());
    assertEquals(addressBytes, defaultInstanceForType.getCountryBytes());
    assertEquals(addressBytes, defaultInstanceForType.getEmailBytes());
    assertEquals(addressBytes, defaultInstanceForType.getEntityBytes());
    assertEquals(addressBytes, actualConstructTenantUpdateMsgResult.getEntityBytes());
    assertEquals(addressBytes, defaultInstanceForType.getPhoneBytes());
    assertEquals(addressBytes, defaultInstanceForType.getRegionBytes());
    assertEquals(addressBytes, defaultInstanceForType.getStateBytes());
    assertEquals(addressBytes, defaultInstanceForType.getTitleBytes());
    assertEquals(addressBytes, defaultInstanceForType.getZipBytes());
  }

  /**
   * Test
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   * <ul>
   *   <li>Then return CityBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}
   */
  @Test
  @DisplayName("Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return CityBytes toStringUtf8 is empty string")
  void testConstructTenantUpdateMsg_thenReturnCityBytesToStringUtf8IsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();
    Tenant tenant = mock(Tenant.class);
    when(tenant.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(tenant.getAddress()).thenReturn("42 Main St");
    when(tenant.getAddress2()).thenReturn("42 Main St");
    when(tenant.getCity()).thenReturn(null);
    when(tenant.getCountry()).thenReturn("GB");
    when(tenant.getEmail()).thenReturn("jane.doe@example.org");
    when(tenant.getPhone()).thenReturn("6625550144");
    when(tenant.getState()).thenReturn("MD");
    when(tenant.getZip()).thenReturn("21654");
    when(tenant.getRegion()).thenReturn("us-east-2");
    when(tenant.getTenantProfileId()).thenReturn(new TenantProfileId(UUID.randomUUID()));
    when(tenant.getTitle()).thenReturn("Dr");
    when(tenant.getId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(tenant).setId(Mockito.<TenantId>any());
    tenant.setId(new TenantId(null));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult = tenantMsgConstructorV1
        .constructTenantUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant);

    // Assert
    verify(tenant, atLeast(1)).getAdditionalInfo();
    verify(tenant, atLeast(1)).getAddress();
    verify(tenant, atLeast(1)).getAddress2();
    verify(tenant).getCity();
    verify(tenant, atLeast(1)).getCountry();
    verify(tenant, atLeast(1)).getEmail();
    verify(tenant, atLeast(1)).getId();
    verify(tenant, atLeast(1)).getPhone();
    verify(tenant).getRegion();
    verify(tenant, atLeast(1)).getState();
    verify(tenant, atLeast(1)).getTenantProfileId();
    verify(tenant).getTitle();
    verify(tenant, atLeast(1)).getZip();
    verify(tenant).setId(isA(TenantId.class));
    ByteString cityBytes = actualConstructTenantUpdateMsgResult.getCityBytes();
    assertEquals("", cityBytes.toStringUtf8());
    assertEquals("", actualConstructTenantUpdateMsgResult.getCity());
    Descriptors.Descriptor descriptorForType = actualConstructTenantUpdateMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(17, fields.size());
    assertFalse(cityBytes.iterator().hasNext());
    assertFalse(actualConstructTenantUpdateMsgResult.hasCity());
    assertTrue(cityBytes.isEmpty());
    assertEquals(cityBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(cityBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(cityBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(15).toProto();
    assertEquals(cityBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(Short.SIZE).toProto();
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
    assertEquals(cityBytes, options.getCsharpNamespaceBytes());
    assertEquals(cityBytes, options.getGoPackageBytes());
    assertEquals(cityBytes, options.getObjcClassPrefixBytes());
    assertEquals(cityBytes, options.getPhpClassPrefixBytes());
    assertEquals(cityBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(cityBytes, options.getPhpNamespaceBytes());
    assertEquals(cityBytes, options.getRubyPackageBytes());
    assertEquals(cityBytes, options.getSwiftPrefixBytes());
    TenantUpdateMsg defaultInstanceForType = actualConstructTenantUpdateMsgResult.getDefaultInstanceForType();
    assertEquals(cityBytes, defaultInstanceForType.getAdditionalInfoBytes());
    assertEquals(cityBytes, defaultInstanceForType.getAddress2Bytes());
    assertEquals(cityBytes, defaultInstanceForType.getAddressBytes());
    assertEquals(cityBytes, defaultInstanceForType.getCityBytes());
    assertEquals(cityBytes, defaultInstanceForType.getCountryBytes());
    assertEquals(cityBytes, defaultInstanceForType.getEmailBytes());
    assertEquals(cityBytes, defaultInstanceForType.getEntityBytes());
    assertEquals(cityBytes, actualConstructTenantUpdateMsgResult.getEntityBytes());
    assertEquals(cityBytes, defaultInstanceForType.getPhoneBytes());
    assertEquals(cityBytes, defaultInstanceForType.getRegionBytes());
    assertEquals(cityBytes, defaultInstanceForType.getStateBytes());
    assertEquals(cityBytes, defaultInstanceForType.getTitleBytes());
    assertEquals(cityBytes, defaultInstanceForType.getZipBytes());
  }

  /**
   * Test
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   * <ul>
   *   <li>Then return CountryBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}
   */
  @Test
  @DisplayName("Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return CountryBytes toStringUtf8 is empty string")
  void testConstructTenantUpdateMsg_thenReturnCountryBytesToStringUtf8IsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();
    Tenant tenant = mock(Tenant.class);
    when(tenant.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(tenant.getAddress()).thenReturn("42 Main St");
    when(tenant.getAddress2()).thenReturn("42 Main St");
    when(tenant.getCity()).thenReturn("Oxford");
    when(tenant.getCountry()).thenReturn(null);
    when(tenant.getEmail()).thenReturn("jane.doe@example.org");
    when(tenant.getPhone()).thenReturn("6625550144");
    when(tenant.getState()).thenReturn("MD");
    when(tenant.getZip()).thenReturn("21654");
    when(tenant.getRegion()).thenReturn("us-east-2");
    when(tenant.getTenantProfileId()).thenReturn(new TenantProfileId(UUID.randomUUID()));
    when(tenant.getTitle()).thenReturn("Dr");
    when(tenant.getId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(tenant).setId(Mockito.<TenantId>any());
    tenant.setId(new TenantId(null));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult = tenantMsgConstructorV1
        .constructTenantUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant);

    // Assert
    verify(tenant, atLeast(1)).getAdditionalInfo();
    verify(tenant, atLeast(1)).getAddress();
    verify(tenant, atLeast(1)).getAddress2();
    verify(tenant, atLeast(1)).getCity();
    verify(tenant).getCountry();
    verify(tenant, atLeast(1)).getEmail();
    verify(tenant, atLeast(1)).getId();
    verify(tenant, atLeast(1)).getPhone();
    verify(tenant).getRegion();
    verify(tenant, atLeast(1)).getState();
    verify(tenant, atLeast(1)).getTenantProfileId();
    verify(tenant).getTitle();
    verify(tenant, atLeast(1)).getZip();
    verify(tenant).setId(isA(TenantId.class));
    ByteString countryBytes = actualConstructTenantUpdateMsgResult.getCountryBytes();
    assertEquals("", countryBytes.toStringUtf8());
    assertEquals("", actualConstructTenantUpdateMsgResult.getCountry());
    Descriptors.Descriptor descriptorForType = actualConstructTenantUpdateMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(17, fields.size());
    assertFalse(countryBytes.iterator().hasNext());
    assertFalse(actualConstructTenantUpdateMsgResult.hasCountry());
    assertTrue(countryBytes.isEmpty());
    assertEquals(countryBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(countryBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(countryBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(15).toProto();
    assertEquals(countryBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(Short.SIZE).toProto();
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
    assertEquals(countryBytes, options.getCsharpNamespaceBytes());
    assertEquals(countryBytes, options.getGoPackageBytes());
    assertEquals(countryBytes, options.getObjcClassPrefixBytes());
    assertEquals(countryBytes, options.getPhpClassPrefixBytes());
    assertEquals(countryBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(countryBytes, options.getPhpNamespaceBytes());
    assertEquals(countryBytes, options.getRubyPackageBytes());
    assertEquals(countryBytes, options.getSwiftPrefixBytes());
    TenantUpdateMsg defaultInstanceForType = actualConstructTenantUpdateMsgResult.getDefaultInstanceForType();
    assertEquals(countryBytes, defaultInstanceForType.getAdditionalInfoBytes());
    assertEquals(countryBytes, defaultInstanceForType.getAddress2Bytes());
    assertEquals(countryBytes, defaultInstanceForType.getAddressBytes());
    assertEquals(countryBytes, defaultInstanceForType.getCityBytes());
    assertEquals(countryBytes, defaultInstanceForType.getCountryBytes());
    assertEquals(countryBytes, defaultInstanceForType.getEmailBytes());
    assertEquals(countryBytes, defaultInstanceForType.getEntityBytes());
    assertEquals(countryBytes, actualConstructTenantUpdateMsgResult.getEntityBytes());
    assertEquals(countryBytes, defaultInstanceForType.getPhoneBytes());
    assertEquals(countryBytes, defaultInstanceForType.getRegionBytes());
    assertEquals(countryBytes, defaultInstanceForType.getStateBytes());
    assertEquals(countryBytes, defaultInstanceForType.getTitleBytes());
    assertEquals(countryBytes, defaultInstanceForType.getZipBytes());
  }

  /**
   * Test
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   * <ul>
   *   <li>Then return EmailBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}
   */
  @Test
  @DisplayName("Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return EmailBytes toStringUtf8 is empty string")
  void testConstructTenantUpdateMsg_thenReturnEmailBytesToStringUtf8IsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();
    Tenant tenant = mock(Tenant.class);
    when(tenant.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(tenant.getAddress()).thenReturn("42 Main St");
    when(tenant.getAddress2()).thenReturn("42 Main St");
    when(tenant.getCity()).thenReturn("Oxford");
    when(tenant.getCountry()).thenReturn("GB");
    when(tenant.getEmail()).thenReturn(null);
    when(tenant.getPhone()).thenReturn("6625550144");
    when(tenant.getState()).thenReturn("MD");
    when(tenant.getZip()).thenReturn("21654");
    when(tenant.getRegion()).thenReturn("us-east-2");
    when(tenant.getTenantProfileId()).thenReturn(new TenantProfileId(UUID.randomUUID()));
    when(tenant.getTitle()).thenReturn("Dr");
    when(tenant.getId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(tenant).setId(Mockito.<TenantId>any());
    tenant.setId(new TenantId(null));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult = tenantMsgConstructorV1
        .constructTenantUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant);

    // Assert
    verify(tenant, atLeast(1)).getAdditionalInfo();
    verify(tenant, atLeast(1)).getAddress();
    verify(tenant, atLeast(1)).getAddress2();
    verify(tenant, atLeast(1)).getCity();
    verify(tenant, atLeast(1)).getCountry();
    verify(tenant).getEmail();
    verify(tenant, atLeast(1)).getId();
    verify(tenant, atLeast(1)).getPhone();
    verify(tenant).getRegion();
    verify(tenant, atLeast(1)).getState();
    verify(tenant, atLeast(1)).getTenantProfileId();
    verify(tenant).getTitle();
    verify(tenant, atLeast(1)).getZip();
    verify(tenant).setId(isA(TenantId.class));
    ByteString emailBytes = actualConstructTenantUpdateMsgResult.getEmailBytes();
    assertEquals("", emailBytes.toStringUtf8());
    assertEquals("", actualConstructTenantUpdateMsgResult.getEmail());
    Descriptors.Descriptor descriptorForType = actualConstructTenantUpdateMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(17, fields.size());
    assertFalse(emailBytes.iterator().hasNext());
    assertFalse(actualConstructTenantUpdateMsgResult.hasEmail());
    assertTrue(emailBytes.isEmpty());
    assertEquals(emailBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(emailBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(emailBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(15).toProto();
    assertEquals(emailBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(Short.SIZE).toProto();
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
    assertEquals(emailBytes, options.getCsharpNamespaceBytes());
    assertEquals(emailBytes, options.getGoPackageBytes());
    assertEquals(emailBytes, options.getObjcClassPrefixBytes());
    assertEquals(emailBytes, options.getPhpClassPrefixBytes());
    assertEquals(emailBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(emailBytes, options.getPhpNamespaceBytes());
    assertEquals(emailBytes, options.getRubyPackageBytes());
    assertEquals(emailBytes, options.getSwiftPrefixBytes());
    TenantUpdateMsg defaultInstanceForType = actualConstructTenantUpdateMsgResult.getDefaultInstanceForType();
    assertEquals(emailBytes, defaultInstanceForType.getAdditionalInfoBytes());
    assertEquals(emailBytes, defaultInstanceForType.getAddress2Bytes());
    assertEquals(emailBytes, defaultInstanceForType.getAddressBytes());
    assertEquals(emailBytes, defaultInstanceForType.getCityBytes());
    assertEquals(emailBytes, defaultInstanceForType.getCountryBytes());
    assertEquals(emailBytes, defaultInstanceForType.getEmailBytes());
    assertEquals(emailBytes, defaultInstanceForType.getEntityBytes());
    assertEquals(emailBytes, actualConstructTenantUpdateMsgResult.getEntityBytes());
    assertEquals(emailBytes, defaultInstanceForType.getPhoneBytes());
    assertEquals(emailBytes, defaultInstanceForType.getRegionBytes());
    assertEquals(emailBytes, defaultInstanceForType.getStateBytes());
    assertEquals(emailBytes, defaultInstanceForType.getTitleBytes());
    assertEquals(emailBytes, defaultInstanceForType.getZipBytes());
  }

  /**
   * Test
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   * <ul>
   *   <li>Then return Phone is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}
   */
  @Test
  @DisplayName("Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return Phone is empty string")
  void testConstructTenantUpdateMsg_thenReturnPhoneIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();
    Tenant tenant = mock(Tenant.class);
    when(tenant.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(tenant.getAddress()).thenReturn("42 Main St");
    when(tenant.getAddress2()).thenReturn("42 Main St");
    when(tenant.getCity()).thenReturn("Oxford");
    when(tenant.getCountry()).thenReturn("GB");
    when(tenant.getEmail()).thenReturn("jane.doe@example.org");
    when(tenant.getPhone()).thenReturn(null);
    when(tenant.getState()).thenReturn("MD");
    when(tenant.getZip()).thenReturn("21654");
    when(tenant.getRegion()).thenReturn("us-east-2");
    when(tenant.getTenantProfileId()).thenReturn(new TenantProfileId(UUID.randomUUID()));
    when(tenant.getTitle()).thenReturn("Dr");
    when(tenant.getId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(tenant).setId(Mockito.<TenantId>any());
    tenant.setId(new TenantId(null));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult = tenantMsgConstructorV1
        .constructTenantUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant);

    // Assert
    verify(tenant, atLeast(1)).getAdditionalInfo();
    verify(tenant, atLeast(1)).getAddress();
    verify(tenant, atLeast(1)).getAddress2();
    verify(tenant, atLeast(1)).getCity();
    verify(tenant, atLeast(1)).getCountry();
    verify(tenant, atLeast(1)).getEmail();
    verify(tenant, atLeast(1)).getId();
    verify(tenant).getPhone();
    verify(tenant).getRegion();
    verify(tenant, atLeast(1)).getState();
    verify(tenant, atLeast(1)).getTenantProfileId();
    verify(tenant).getTitle();
    verify(tenant, atLeast(1)).getZip();
    verify(tenant).setId(isA(TenantId.class));
    assertEquals("", actualConstructTenantUpdateMsgResult.getPhone());
    assertFalse(actualConstructTenantUpdateMsgResult.hasPhone());
  }

  /**
   * Test
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   * <ul>
   *   <li>Then return State is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}
   */
  @Test
  @DisplayName("Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return State is empty string")
  void testConstructTenantUpdateMsg_thenReturnStateIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();
    Tenant tenant = mock(Tenant.class);
    when(tenant.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(tenant.getAddress()).thenReturn("42 Main St");
    when(tenant.getAddress2()).thenReturn("42 Main St");
    when(tenant.getCity()).thenReturn("Oxford");
    when(tenant.getCountry()).thenReturn("GB");
    when(tenant.getEmail()).thenReturn("jane.doe@example.org");
    when(tenant.getPhone()).thenReturn("6625550144");
    when(tenant.getState()).thenReturn(null);
    when(tenant.getZip()).thenReturn("21654");
    when(tenant.getRegion()).thenReturn("us-east-2");
    when(tenant.getTenantProfileId()).thenReturn(new TenantProfileId(UUID.randomUUID()));
    when(tenant.getTitle()).thenReturn("Dr");
    when(tenant.getId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(tenant).setId(Mockito.<TenantId>any());
    tenant.setId(new TenantId(null));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult = tenantMsgConstructorV1
        .constructTenantUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant);

    // Assert
    verify(tenant, atLeast(1)).getAdditionalInfo();
    verify(tenant, atLeast(1)).getAddress();
    verify(tenant, atLeast(1)).getAddress2();
    verify(tenant, atLeast(1)).getCity();
    verify(tenant, atLeast(1)).getCountry();
    verify(tenant, atLeast(1)).getEmail();
    verify(tenant, atLeast(1)).getId();
    verify(tenant, atLeast(1)).getPhone();
    verify(tenant).getRegion();
    verify(tenant).getState();
    verify(tenant, atLeast(1)).getTenantProfileId();
    verify(tenant).getTitle();
    verify(tenant, atLeast(1)).getZip();
    verify(tenant).setId(isA(TenantId.class));
    assertEquals("", actualConstructTenantUpdateMsgResult.getState());
    assertFalse(actualConstructTenantUpdateMsgResult.hasState());
  }

  /**
   * Test
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   * <ul>
   *   <li>Then return Zip is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantMsgConstructorV1#constructTenantUpdateMsg(UpdateMsgType, Tenant)}
   */
  @Test
  @DisplayName("Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return Zip is empty string")
  void testConstructTenantUpdateMsg_thenReturnZipIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();
    Tenant tenant = mock(Tenant.class);
    when(tenant.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(tenant.getAddress()).thenReturn("42 Main St");
    when(tenant.getAddress2()).thenReturn("42 Main St");
    when(tenant.getCity()).thenReturn("Oxford");
    when(tenant.getCountry()).thenReturn("GB");
    when(tenant.getEmail()).thenReturn("jane.doe@example.org");
    when(tenant.getPhone()).thenReturn("6625550144");
    when(tenant.getState()).thenReturn("MD");
    when(tenant.getZip()).thenReturn(null);
    when(tenant.getRegion()).thenReturn("us-east-2");
    when(tenant.getTenantProfileId()).thenReturn(new TenantProfileId(UUID.randomUUID()));
    when(tenant.getTitle()).thenReturn("Dr");
    when(tenant.getId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(tenant).setId(Mockito.<TenantId>any());
    tenant.setId(new TenantId(null));

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult = tenantMsgConstructorV1
        .constructTenantUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenant);

    // Assert
    verify(tenant, atLeast(1)).getAdditionalInfo();
    verify(tenant, atLeast(1)).getAddress();
    verify(tenant, atLeast(1)).getAddress2();
    verify(tenant, atLeast(1)).getCity();
    verify(tenant, atLeast(1)).getCountry();
    verify(tenant, atLeast(1)).getEmail();
    verify(tenant, atLeast(1)).getId();
    verify(tenant, atLeast(1)).getPhone();
    verify(tenant).getRegion();
    verify(tenant, atLeast(1)).getState();
    verify(tenant, atLeast(1)).getTenantProfileId();
    verify(tenant).getTitle();
    verify(tenant).getZip();
    verify(tenant).setId(isA(TenantId.class));
    assertEquals("", actualConstructTenantUpdateMsgResult.getZip());
    assertFalse(actualConstructTenantUpdateMsgResult.hasZip());
  }
}
