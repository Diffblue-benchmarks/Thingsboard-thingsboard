package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.google.api.BackendRule;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.common.DefaultTbQueueMsg;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;

class TransportApiResponseDecoderDiffblueTest {
  /**
   * Test {@link TransportApiResponseDecoder#decode(TbQueueMsg)}.
   * <p>
   * Method under test: {@link TransportApiResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg)")
  void testDecode() throws IOException {
    // Arrange
    TransportApiResponseDecoder transportApiResponseDecoder = new TransportApiResponseDecoder();

    // Act
    TransportProtos.TransportApiResponseMsg actualDecodeResult = transportApiResponseDecoder
        .decode(new DefaultTbQueueMsg(
            new TbProtoQueueMsg<>(UUID.randomUUID(), DefaultTransportService.SESSION_EVENT_MSG_OPEN)));

    // Assert
    Descriptors.Descriptor descriptorForType = actualDecodeResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(11, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult.getWeakDependencyList());
    TransportProtos.GetDeviceCredentialsResponseMsg deviceCredentialsResponseMsg = actualDecodeResult
        .getDeviceCredentialsResponseMsg();
    Descriptors.Descriptor descriptorForType2 = deviceCredentialsResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.GetDeviceResponseMsg deviceResponseMsg = actualDecodeResult.getDeviceResponseMsg();
    Descriptors.Descriptor descriptorForType3 = deviceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.GetEntityProfileResponseMsg entityProfileResponseMsg = actualDecodeResult
        .getEntityProfileResponseMsg();
    Descriptors.Descriptor descriptorForType4 = entityProfileResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.GetOrCreateDeviceFromGatewayResponseMsg getOrCreateDeviceResponseMsg = actualDecodeResult
        .getGetOrCreateDeviceResponseMsg();
    Descriptors.Descriptor descriptorForType5 = getOrCreateDeviceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.LwM2MResponseMsg lwM2MResponseMsg = actualDecodeResult.getLwM2MResponseMsg();
    Descriptors.Descriptor descriptorForType6 = lwM2MResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.GetOtaPackageResponseMsg otaPackageResponseMsg = actualDecodeResult.getOtaPackageResponseMsg();
    Descriptors.Descriptor descriptorForType7 = otaPackageResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionDeviceResponseMsg = actualDecodeResult
        .getProvisionDeviceResponseMsg();
    Descriptors.Descriptor descriptorForType8 = provisionDeviceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.GetResourceResponseMsg resourceResponseMsg = actualDecodeResult.getResourceResponseMsg();
    Descriptors.Descriptor descriptorForType9 = resourceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.GetSnmpDevicesResponseMsg snmpDevicesResponseMsg = actualDecodeResult.getSnmpDevicesResponseMsg();
    Descriptors.Descriptor descriptorForType10 = snmpDevicesResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.ValidateDeviceCredentialsResponseMsg validateCredResponseMsg = actualDecodeResult
        .getValidateCredResponseMsg();
    Descriptors.Descriptor descriptorForType11 = validateCredResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(10);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(9);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult2.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options, descriptorForType2.getOptions());
    assertSame(options, descriptorForType3.getOptions());
    assertSame(options, descriptorForType4.getOptions());
    assertSame(options, descriptorForType5.getOptions());
    assertSame(options, descriptorForType6.getOptions());
    assertSame(options, descriptorForType7.getOptions());
    assertSame(options, descriptorForType8.getOptions());
    assertSame(options, descriptorForType9.getOptions());
    assertSame(options, descriptorForType10.getOptions());
    assertSame(options, descriptorForType11.getOptions());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(options2, toProtoResult.getOptions());
    assertSame(options2, toProtoResult.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    TransportProtos.TransportApiResponseMsg defaultInstanceForType = actualDecodeResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType2, getResult4.getMessageType());
    assertSame(descriptorForType5, getResult2.getMessageType());
    assertSame(descriptorForType11, getResult.getMessageType());
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.DeviceCredentialsProto deviceCredentialsData = deviceCredentialsResponseMsg
        .getDeviceCredentialsData();
    assertSame(unknownFields, deviceCredentialsData.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiState = entityProfileResponseMsg.getApiState();
    assertSame(unknownFields, apiState.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityProfileResponseMsg.getDeviceProfile();
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityProfileResponseMsg.getTenantProfile();
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    TransportProtos.DeviceInfoProto deviceInfo = getOrCreateDeviceResponseMsg.getDeviceInfo();
    assertSame(unknownFields, deviceInfo.getUnknownFields());
    TransportProtos.TbResourceProto resource = resourceResponseMsg.getResource();
    assertSame(unknownFields, resource.getUnknownFields());
    TransportProtos.LwM2MRegistrationResponseMsg registrationMsg = lwM2MResponseMsg.getRegistrationMsg();
    assertSame(unknownFields, registrationMsg.getUnknownFields());
    assertSame(unknownFields, deviceCredentialsResponseMsg.getUnknownFields());
    assertSame(unknownFields, deviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, entityProfileResponseMsg.getUnknownFields());
    assertSame(unknownFields, getOrCreateDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, lwM2MResponseMsg.getUnknownFields());
    assertSame(unknownFields, otaPackageResponseMsg.getUnknownFields());
    assertSame(unknownFields, provisionDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, resourceResponseMsg.getUnknownFields());
    assertSame(unknownFields, snmpDevicesResponseMsg.getUnknownFields());
    assertSame(unknownFields, validateCredResponseMsg.getUnknownFields());
    assertSame(unknownFields, actualDecodeResult.getUnknownFields().getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsData.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsResponseMsg.getDeviceCredentialsDataOrBuilder());
    assertSame(apiState, apiState.getDefaultInstanceForType());
    assertSame(apiState, entityProfileResponseMsg.getApiStateOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityProfileResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfileOrBuilder());
    assertSame(tenantProfile, entityProfileResponseMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(deviceInfo, deviceInfo.getDefaultInstanceForType());
    assertSame(deviceInfo, getOrCreateDeviceResponseMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, registrationMsg.getDeviceInfo());
    assertSame(deviceInfo, registrationMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfo());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfoOrBuilder());
    assertSame(resource, resourceResponseMsg.getResourceOrBuilder());
    assertSame(resource, resource.getDefaultInstanceForType());
    ProtocolStringList idsList = snmpDevicesResponseMsg.getIdsList();
    assertSame(idsList, toProtoResult2.getReservedNameList());
    assertSame(idsList, toProtoResult.getDependencyList());
    assertSame(registrationMsg, registrationMsg.getDefaultInstanceForType());
    assertSame(registrationMsg, lwM2MResponseMsg.getRegistrationMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceCredentialsResponseMsg, deviceCredentialsResponseMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsResponseMsg, defaultInstanceForType.getDeviceCredentialsResponseMsg());
    assertSame(deviceCredentialsResponseMsg, actualDecodeResult.getDeviceCredentialsResponseMsgOrBuilder());
    assertSame(deviceCredentialsResponseMsg, defaultInstanceForType.getDeviceCredentialsResponseMsgOrBuilder());
    assertSame(deviceResponseMsg, deviceResponseMsg.getDefaultInstanceForType());
    assertSame(deviceResponseMsg, defaultInstanceForType.getDeviceResponseMsg());
    assertSame(deviceResponseMsg, actualDecodeResult.getDeviceResponseMsgOrBuilder());
    assertSame(deviceResponseMsg, defaultInstanceForType.getDeviceResponseMsgOrBuilder());
    assertSame(entityProfileResponseMsg, entityProfileResponseMsg.getDefaultInstanceForType());
    assertSame(entityProfileResponseMsg, defaultInstanceForType.getEntityProfileResponseMsg());
    assertSame(entityProfileResponseMsg, actualDecodeResult.getEntityProfileResponseMsgOrBuilder());
    assertSame(entityProfileResponseMsg, defaultInstanceForType.getEntityProfileResponseMsgOrBuilder());
    assertSame(getOrCreateDeviceResponseMsg, getOrCreateDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(getOrCreateDeviceResponseMsg, defaultInstanceForType.getGetOrCreateDeviceResponseMsg());
    assertSame(getOrCreateDeviceResponseMsg, actualDecodeResult.getGetOrCreateDeviceResponseMsgOrBuilder());
    assertSame(getOrCreateDeviceResponseMsg, defaultInstanceForType.getGetOrCreateDeviceResponseMsgOrBuilder());
    assertSame(lwM2MResponseMsg, lwM2MResponseMsg.getDefaultInstanceForType());
    assertSame(lwM2MResponseMsg, defaultInstanceForType.getLwM2MResponseMsg());
    assertSame(lwM2MResponseMsg, actualDecodeResult.getLwM2MResponseMsgOrBuilder());
    assertSame(lwM2MResponseMsg, defaultInstanceForType.getLwM2MResponseMsgOrBuilder());
    assertSame(otaPackageResponseMsg, otaPackageResponseMsg.getDefaultInstanceForType());
    assertSame(otaPackageResponseMsg, defaultInstanceForType.getOtaPackageResponseMsg());
    assertSame(otaPackageResponseMsg, actualDecodeResult.getOtaPackageResponseMsgOrBuilder());
    assertSame(otaPackageResponseMsg, defaultInstanceForType.getOtaPackageResponseMsgOrBuilder());
    assertSame(provisionDeviceResponseMsg, provisionDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(provisionDeviceResponseMsg, defaultInstanceForType.getProvisionDeviceResponseMsg());
    assertSame(provisionDeviceResponseMsg, actualDecodeResult.getProvisionDeviceResponseMsgOrBuilder());
    assertSame(provisionDeviceResponseMsg, defaultInstanceForType.getProvisionDeviceResponseMsgOrBuilder());
    assertSame(resourceResponseMsg, resourceResponseMsg.getDefaultInstanceForType());
    assertSame(resourceResponseMsg, defaultInstanceForType.getResourceResponseMsg());
    assertSame(resourceResponseMsg, actualDecodeResult.getResourceResponseMsgOrBuilder());
    assertSame(resourceResponseMsg, defaultInstanceForType.getResourceResponseMsgOrBuilder());
    assertSame(snmpDevicesResponseMsg, snmpDevicesResponseMsg.getDefaultInstanceForType());
    assertSame(snmpDevicesResponseMsg, defaultInstanceForType.getSnmpDevicesResponseMsg());
    assertSame(snmpDevicesResponseMsg, actualDecodeResult.getSnmpDevicesResponseMsgOrBuilder());
    assertSame(snmpDevicesResponseMsg, defaultInstanceForType.getSnmpDevicesResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, defaultInstanceForType.getValidateCredResponseMsg());
    assertSame(validateCredResponseMsg, actualDecodeResult.getValidateCredResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, defaultInstanceForType.getValidateCredResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, validateCredResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link TransportApiResponseDecoder#decode(TbQueueMsg)}.
   * <p>
   * Method under test: {@link TransportApiResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg)")
  void testDecode2() throws IOException {
    // Arrange
    TransportApiResponseDecoder transportApiResponseDecoder = new TransportApiResponseDecoder();

    // Act
    TransportProtos.TransportApiResponseMsg actualDecodeResult = transportApiResponseDecoder
        .decode(new TbProtoQueueMsg<>(UUID.randomUUID(), DefaultTransportService.SESSION_EVENT_MSG_OPEN));

    // Assert
    Descriptors.Descriptor descriptorForType = actualDecodeResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(11, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult.getWeakDependencyList());
    TransportProtos.GetDeviceCredentialsResponseMsg deviceCredentialsResponseMsg = actualDecodeResult
        .getDeviceCredentialsResponseMsg();
    Descriptors.Descriptor descriptorForType2 = deviceCredentialsResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.GetDeviceResponseMsg deviceResponseMsg = actualDecodeResult.getDeviceResponseMsg();
    Descriptors.Descriptor descriptorForType3 = deviceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.GetEntityProfileResponseMsg entityProfileResponseMsg = actualDecodeResult
        .getEntityProfileResponseMsg();
    Descriptors.Descriptor descriptorForType4 = entityProfileResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.GetOrCreateDeviceFromGatewayResponseMsg getOrCreateDeviceResponseMsg = actualDecodeResult
        .getGetOrCreateDeviceResponseMsg();
    Descriptors.Descriptor descriptorForType5 = getOrCreateDeviceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.LwM2MResponseMsg lwM2MResponseMsg = actualDecodeResult.getLwM2MResponseMsg();
    Descriptors.Descriptor descriptorForType6 = lwM2MResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.GetOtaPackageResponseMsg otaPackageResponseMsg = actualDecodeResult.getOtaPackageResponseMsg();
    Descriptors.Descriptor descriptorForType7 = otaPackageResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionDeviceResponseMsg = actualDecodeResult
        .getProvisionDeviceResponseMsg();
    Descriptors.Descriptor descriptorForType8 = provisionDeviceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.GetResourceResponseMsg resourceResponseMsg = actualDecodeResult.getResourceResponseMsg();
    Descriptors.Descriptor descriptorForType9 = resourceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.GetSnmpDevicesResponseMsg snmpDevicesResponseMsg = actualDecodeResult.getSnmpDevicesResponseMsg();
    Descriptors.Descriptor descriptorForType10 = snmpDevicesResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.ValidateDeviceCredentialsResponseMsg validateCredResponseMsg = actualDecodeResult
        .getValidateCredResponseMsg();
    Descriptors.Descriptor descriptorForType11 = validateCredResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(10);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(9);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult2.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options, descriptorForType2.getOptions());
    assertSame(options, descriptorForType3.getOptions());
    assertSame(options, descriptorForType4.getOptions());
    assertSame(options, descriptorForType5.getOptions());
    assertSame(options, descriptorForType6.getOptions());
    assertSame(options, descriptorForType7.getOptions());
    assertSame(options, descriptorForType8.getOptions());
    assertSame(options, descriptorForType9.getOptions());
    assertSame(options, descriptorForType10.getOptions());
    assertSame(options, descriptorForType11.getOptions());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(options2, toProtoResult.getOptions());
    assertSame(options2, toProtoResult.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    TransportProtos.TransportApiResponseMsg defaultInstanceForType = actualDecodeResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType2, getResult4.getMessageType());
    assertSame(descriptorForType5, getResult2.getMessageType());
    assertSame(descriptorForType11, getResult.getMessageType());
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.DeviceCredentialsProto deviceCredentialsData = deviceCredentialsResponseMsg
        .getDeviceCredentialsData();
    assertSame(unknownFields, deviceCredentialsData.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiState = entityProfileResponseMsg.getApiState();
    assertSame(unknownFields, apiState.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityProfileResponseMsg.getDeviceProfile();
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityProfileResponseMsg.getTenantProfile();
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    TransportProtos.DeviceInfoProto deviceInfo = getOrCreateDeviceResponseMsg.getDeviceInfo();
    assertSame(unknownFields, deviceInfo.getUnknownFields());
    TransportProtos.TbResourceProto resource = resourceResponseMsg.getResource();
    assertSame(unknownFields, resource.getUnknownFields());
    TransportProtos.LwM2MRegistrationResponseMsg registrationMsg = lwM2MResponseMsg.getRegistrationMsg();
    assertSame(unknownFields, registrationMsg.getUnknownFields());
    assertSame(unknownFields, deviceCredentialsResponseMsg.getUnknownFields());
    assertSame(unknownFields, deviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, entityProfileResponseMsg.getUnknownFields());
    assertSame(unknownFields, getOrCreateDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, lwM2MResponseMsg.getUnknownFields());
    assertSame(unknownFields, otaPackageResponseMsg.getUnknownFields());
    assertSame(unknownFields, provisionDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, resourceResponseMsg.getUnknownFields());
    assertSame(unknownFields, snmpDevicesResponseMsg.getUnknownFields());
    assertSame(unknownFields, validateCredResponseMsg.getUnknownFields());
    assertSame(unknownFields, actualDecodeResult.getUnknownFields().getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsData.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsResponseMsg.getDeviceCredentialsDataOrBuilder());
    assertSame(apiState, apiState.getDefaultInstanceForType());
    assertSame(apiState, entityProfileResponseMsg.getApiStateOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityProfileResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfileOrBuilder());
    assertSame(tenantProfile, entityProfileResponseMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(deviceInfo, deviceInfo.getDefaultInstanceForType());
    assertSame(deviceInfo, getOrCreateDeviceResponseMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, registrationMsg.getDeviceInfo());
    assertSame(deviceInfo, registrationMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfo());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfoOrBuilder());
    assertSame(resource, resourceResponseMsg.getResourceOrBuilder());
    assertSame(resource, resource.getDefaultInstanceForType());
    ProtocolStringList idsList = snmpDevicesResponseMsg.getIdsList();
    assertSame(idsList, toProtoResult2.getReservedNameList());
    assertSame(idsList, toProtoResult.getDependencyList());
    assertSame(registrationMsg, registrationMsg.getDefaultInstanceForType());
    assertSame(registrationMsg, lwM2MResponseMsg.getRegistrationMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceCredentialsResponseMsg, deviceCredentialsResponseMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsResponseMsg, defaultInstanceForType.getDeviceCredentialsResponseMsg());
    assertSame(deviceCredentialsResponseMsg, actualDecodeResult.getDeviceCredentialsResponseMsgOrBuilder());
    assertSame(deviceCredentialsResponseMsg, defaultInstanceForType.getDeviceCredentialsResponseMsgOrBuilder());
    assertSame(deviceResponseMsg, deviceResponseMsg.getDefaultInstanceForType());
    assertSame(deviceResponseMsg, defaultInstanceForType.getDeviceResponseMsg());
    assertSame(deviceResponseMsg, actualDecodeResult.getDeviceResponseMsgOrBuilder());
    assertSame(deviceResponseMsg, defaultInstanceForType.getDeviceResponseMsgOrBuilder());
    assertSame(entityProfileResponseMsg, entityProfileResponseMsg.getDefaultInstanceForType());
    assertSame(entityProfileResponseMsg, defaultInstanceForType.getEntityProfileResponseMsg());
    assertSame(entityProfileResponseMsg, actualDecodeResult.getEntityProfileResponseMsgOrBuilder());
    assertSame(entityProfileResponseMsg, defaultInstanceForType.getEntityProfileResponseMsgOrBuilder());
    assertSame(getOrCreateDeviceResponseMsg, getOrCreateDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(getOrCreateDeviceResponseMsg, defaultInstanceForType.getGetOrCreateDeviceResponseMsg());
    assertSame(getOrCreateDeviceResponseMsg, actualDecodeResult.getGetOrCreateDeviceResponseMsgOrBuilder());
    assertSame(getOrCreateDeviceResponseMsg, defaultInstanceForType.getGetOrCreateDeviceResponseMsgOrBuilder());
    assertSame(lwM2MResponseMsg, lwM2MResponseMsg.getDefaultInstanceForType());
    assertSame(lwM2MResponseMsg, defaultInstanceForType.getLwM2MResponseMsg());
    assertSame(lwM2MResponseMsg, actualDecodeResult.getLwM2MResponseMsgOrBuilder());
    assertSame(lwM2MResponseMsg, defaultInstanceForType.getLwM2MResponseMsgOrBuilder());
    assertSame(otaPackageResponseMsg, otaPackageResponseMsg.getDefaultInstanceForType());
    assertSame(otaPackageResponseMsg, defaultInstanceForType.getOtaPackageResponseMsg());
    assertSame(otaPackageResponseMsg, actualDecodeResult.getOtaPackageResponseMsgOrBuilder());
    assertSame(otaPackageResponseMsg, defaultInstanceForType.getOtaPackageResponseMsgOrBuilder());
    assertSame(provisionDeviceResponseMsg, provisionDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(provisionDeviceResponseMsg, defaultInstanceForType.getProvisionDeviceResponseMsg());
    assertSame(provisionDeviceResponseMsg, actualDecodeResult.getProvisionDeviceResponseMsgOrBuilder());
    assertSame(provisionDeviceResponseMsg, defaultInstanceForType.getProvisionDeviceResponseMsgOrBuilder());
    assertSame(resourceResponseMsg, resourceResponseMsg.getDefaultInstanceForType());
    assertSame(resourceResponseMsg, defaultInstanceForType.getResourceResponseMsg());
    assertSame(resourceResponseMsg, actualDecodeResult.getResourceResponseMsgOrBuilder());
    assertSame(resourceResponseMsg, defaultInstanceForType.getResourceResponseMsgOrBuilder());
    assertSame(snmpDevicesResponseMsg, snmpDevicesResponseMsg.getDefaultInstanceForType());
    assertSame(snmpDevicesResponseMsg, defaultInstanceForType.getSnmpDevicesResponseMsg());
    assertSame(snmpDevicesResponseMsg, actualDecodeResult.getSnmpDevicesResponseMsgOrBuilder());
    assertSame(snmpDevicesResponseMsg, defaultInstanceForType.getSnmpDevicesResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, defaultInstanceForType.getValidateCredResponseMsg());
    assertSame(validateCredResponseMsg, actualDecodeResult.getValidateCredResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, defaultInstanceForType.getValidateCredResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, validateCredResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link TransportApiResponseDecoder#decode(TbQueueMsg)}.
   * <p>
   * Method under test: {@link TransportApiResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg)")
  void testDecode3() throws IOException {
    // Arrange
    TransportApiResponseDecoder transportApiResponseDecoder = new TransportApiResponseDecoder();
    UUID key = UUID.randomUUID();

    // Act
    TransportProtos.TransportApiResponseMsg actualDecodeResult = transportApiResponseDecoder
        .decode(new TbProtoQueueMsg<>(key, BackendRule.getDefaultInstance()));

    // Assert
    Descriptors.Descriptor descriptorForType = actualDecodeResult.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertNull(options.getDescriptorForType().getContainingType());
    UnknownFieldSet unknownFields = actualDecodeResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualDecodeResult.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(11, fields.size());
    assertEquals(actualDecodeResult, actualDecodeResult.getDefaultInstanceForType());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult.getWeakDependencyList());
    TransportProtos.GetDeviceCredentialsResponseMsg deviceCredentialsResponseMsg = actualDecodeResult
        .getDeviceCredentialsResponseMsg();
    Descriptors.Descriptor descriptorForType2 = deviceCredentialsResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.GetDeviceResponseMsg deviceResponseMsg = actualDecodeResult.getDeviceResponseMsg();
    assertSame(file, deviceResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetEntityProfileResponseMsg entityProfileResponseMsg = actualDecodeResult
        .getEntityProfileResponseMsg();
    assertSame(file, entityProfileResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetOrCreateDeviceFromGatewayResponseMsg getOrCreateDeviceResponseMsg = actualDecodeResult
        .getGetOrCreateDeviceResponseMsg();
    Descriptors.Descriptor descriptorForType3 = getOrCreateDeviceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.LwM2MResponseMsg lwM2MResponseMsg = actualDecodeResult.getLwM2MResponseMsg();
    assertSame(file, lwM2MResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetOtaPackageResponseMsg otaPackageResponseMsg = actualDecodeResult.getOtaPackageResponseMsg();
    assertSame(file, otaPackageResponseMsg.getDescriptorForType().getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionDeviceResponseMsg = actualDecodeResult
        .getProvisionDeviceResponseMsg();
    assertSame(file, provisionDeviceResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetResourceResponseMsg resourceResponseMsg = actualDecodeResult.getResourceResponseMsg();
    assertSame(file, resourceResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetSnmpDevicesResponseMsg snmpDevicesResponseMsg = actualDecodeResult.getSnmpDevicesResponseMsg();
    assertSame(file, snmpDevicesResponseMsg.getDescriptorForType().getFile());
    TransportProtos.ValidateDeviceCredentialsResponseMsg validateCredResponseMsg = actualDecodeResult
        .getValidateCredResponseMsg();
    Descriptors.Descriptor descriptorForType4 = validateCredResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(10);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(9);
    assertSame(file, getResult4.getFile());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(options2, toProtoResult.getOptions());
    assertSame(options2, toProtoResult.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult4.getMessageType());
    assertSame(descriptorForType3, getResult2.getMessageType());
    assertSame(descriptorForType4, getResult.getMessageType());
    assertSame(unknownFields, options.getUnknownFields());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.DeviceCredentialsProto deviceCredentialsData = deviceCredentialsResponseMsg
        .getDeviceCredentialsData();
    assertSame(unknownFields, deviceCredentialsData.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiState = entityProfileResponseMsg.getApiState();
    assertSame(unknownFields, apiState.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityProfileResponseMsg.getDeviceProfile();
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityProfileResponseMsg.getTenantProfile();
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    TransportProtos.DeviceInfoProto deviceInfo = getOrCreateDeviceResponseMsg.getDeviceInfo();
    assertSame(unknownFields, deviceInfo.getUnknownFields());
    TransportProtos.TbResourceProto resource = resourceResponseMsg.getResource();
    assertSame(unknownFields, resource.getUnknownFields());
    TransportProtos.LwM2MRegistrationResponseMsg registrationMsg = lwM2MResponseMsg.getRegistrationMsg();
    assertSame(unknownFields, registrationMsg.getUnknownFields());
    assertSame(unknownFields, deviceCredentialsResponseMsg.getUnknownFields());
    assertSame(unknownFields, deviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, entityProfileResponseMsg.getUnknownFields());
    assertSame(unknownFields, getOrCreateDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, lwM2MResponseMsg.getUnknownFields());
    assertSame(unknownFields, otaPackageResponseMsg.getUnknownFields());
    assertSame(unknownFields, provisionDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, resourceResponseMsg.getUnknownFields());
    assertSame(unknownFields, snmpDevicesResponseMsg.getUnknownFields());
    assertSame(unknownFields, validateCredResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsData.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsResponseMsg.getDeviceCredentialsDataOrBuilder());
    assertSame(apiState, apiState.getDefaultInstanceForType());
    assertSame(apiState, entityProfileResponseMsg.getApiStateOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityProfileResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfileOrBuilder());
    assertSame(tenantProfile, entityProfileResponseMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(deviceInfo, deviceInfo.getDefaultInstanceForType());
    assertSame(deviceInfo, getOrCreateDeviceResponseMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, registrationMsg.getDeviceInfo());
    assertSame(deviceInfo, registrationMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfo());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfoOrBuilder());
    assertSame(resource, resourceResponseMsg.getResourceOrBuilder());
    assertSame(resource, resource.getDefaultInstanceForType());
    ProtocolStringList idsList = snmpDevicesResponseMsg.getIdsList();
    assertSame(idsList, toProtoResult2.getReservedNameList());
    assertSame(idsList, toProtoResult.getDependencyList());
    assertSame(registrationMsg, registrationMsg.getDefaultInstanceForType());
    assertSame(registrationMsg, lwM2MResponseMsg.getRegistrationMsgOrBuilder());
    assertSame(deviceCredentialsResponseMsg, deviceCredentialsResponseMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsResponseMsg, actualDecodeResult.getDeviceCredentialsResponseMsgOrBuilder());
    assertSame(deviceResponseMsg, deviceResponseMsg.getDefaultInstanceForType());
    assertSame(deviceResponseMsg, actualDecodeResult.getDeviceResponseMsgOrBuilder());
    assertSame(entityProfileResponseMsg, entityProfileResponseMsg.getDefaultInstanceForType());
    assertSame(entityProfileResponseMsg, actualDecodeResult.getEntityProfileResponseMsgOrBuilder());
    assertSame(getOrCreateDeviceResponseMsg, getOrCreateDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(getOrCreateDeviceResponseMsg, actualDecodeResult.getGetOrCreateDeviceResponseMsgOrBuilder());
    assertSame(lwM2MResponseMsg, lwM2MResponseMsg.getDefaultInstanceForType());
    assertSame(lwM2MResponseMsg, actualDecodeResult.getLwM2MResponseMsgOrBuilder());
    assertSame(otaPackageResponseMsg, otaPackageResponseMsg.getDefaultInstanceForType());
    assertSame(otaPackageResponseMsg, actualDecodeResult.getOtaPackageResponseMsgOrBuilder());
    assertSame(provisionDeviceResponseMsg, provisionDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(provisionDeviceResponseMsg, actualDecodeResult.getProvisionDeviceResponseMsgOrBuilder());
    assertSame(resourceResponseMsg, resourceResponseMsg.getDefaultInstanceForType());
    assertSame(resourceResponseMsg, actualDecodeResult.getResourceResponseMsgOrBuilder());
    assertSame(snmpDevicesResponseMsg, snmpDevicesResponseMsg.getDefaultInstanceForType());
    assertSame(snmpDevicesResponseMsg, actualDecodeResult.getSnmpDevicesResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, actualDecodeResult.getValidateCredResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, validateCredResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link TransportApiResponseDecoder#decode(TbQueueMsg)}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg); then return UnknownFields SerializedSize is four")
  void testDecode_thenReturnUnknownFieldsSerializedSizeIsFour() throws IOException {
    // Arrange
    TransportApiResponseDecoder transportApiResponseDecoder = new TransportApiResponseDecoder();

    // Act
    TransportProtos.TransportApiResponseMsg actualDecodeResult = transportApiResponseDecoder
        .decode(new DefaultTbQueueMsg(
            new TbProtoQueueMsg<>(UUID.randomUUID(), TransportActivityManager.SESSION_EVENT_MSG_CLOSED)));

    // Assert
    Descriptors.Descriptor descriptorForType = actualDecodeResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(11, fields.size());
    UnknownFieldSet unknownFields = actualDecodeResult.getUnknownFields();
    assertEquals(4, unknownFields.getSerializedSize());
    assertEquals(4, actualDecodeResult.getSerializedSize());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult.getWeakDependencyList());
    TransportProtos.GetDeviceCredentialsResponseMsg deviceCredentialsResponseMsg = actualDecodeResult
        .getDeviceCredentialsResponseMsg();
    Descriptors.Descriptor descriptorForType2 = deviceCredentialsResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.GetDeviceResponseMsg deviceResponseMsg = actualDecodeResult.getDeviceResponseMsg();
    Descriptors.Descriptor descriptorForType3 = deviceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.GetEntityProfileResponseMsg entityProfileResponseMsg = actualDecodeResult
        .getEntityProfileResponseMsg();
    Descriptors.Descriptor descriptorForType4 = entityProfileResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.GetOrCreateDeviceFromGatewayResponseMsg getOrCreateDeviceResponseMsg = actualDecodeResult
        .getGetOrCreateDeviceResponseMsg();
    Descriptors.Descriptor descriptorForType5 = getOrCreateDeviceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.LwM2MResponseMsg lwM2MResponseMsg = actualDecodeResult.getLwM2MResponseMsg();
    Descriptors.Descriptor descriptorForType6 = lwM2MResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.GetOtaPackageResponseMsg otaPackageResponseMsg = actualDecodeResult.getOtaPackageResponseMsg();
    Descriptors.Descriptor descriptorForType7 = otaPackageResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionDeviceResponseMsg = actualDecodeResult
        .getProvisionDeviceResponseMsg();
    Descriptors.Descriptor descriptorForType8 = provisionDeviceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.GetResourceResponseMsg resourceResponseMsg = actualDecodeResult.getResourceResponseMsg();
    Descriptors.Descriptor descriptorForType9 = resourceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.GetSnmpDevicesResponseMsg snmpDevicesResponseMsg = actualDecodeResult.getSnmpDevicesResponseMsg();
    Descriptors.Descriptor descriptorForType10 = snmpDevicesResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.ValidateDeviceCredentialsResponseMsg validateCredResponseMsg = actualDecodeResult
        .getValidateCredResponseMsg();
    Descriptors.Descriptor descriptorForType11 = validateCredResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(10);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(9);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult2.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options, descriptorForType2.getOptions());
    assertSame(options, descriptorForType3.getOptions());
    assertSame(options, descriptorForType4.getOptions());
    assertSame(options, descriptorForType5.getOptions());
    assertSame(options, descriptorForType6.getOptions());
    assertSame(options, descriptorForType7.getOptions());
    assertSame(options, descriptorForType8.getOptions());
    assertSame(options, descriptorForType9.getOptions());
    assertSame(options, descriptorForType10.getOptions());
    assertSame(options, descriptorForType11.getOptions());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(options2, toProtoResult.getOptions());
    assertSame(options2, toProtoResult.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    TransportProtos.TransportApiResponseMsg defaultInstanceForType = actualDecodeResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType2, getResult4.getMessageType());
    assertSame(descriptorForType5, getResult2.getMessageType());
    assertSame(descriptorForType11, getResult.getMessageType());
    UnknownFieldSet unknownFields2 = defaultInstanceForType.getUnknownFields();
    assertSame(unknownFields2, options.getUnknownFields());
    assertSame(unknownFields2, toProtoResult2.getUnknownFields());
    assertSame(unknownFields2, options2.getUnknownFields());
    assertSame(unknownFields2, toProtoResult.getUnknownFields());
    TransportProtos.DeviceCredentialsProto deviceCredentialsData = deviceCredentialsResponseMsg
        .getDeviceCredentialsData();
    assertSame(unknownFields2, deviceCredentialsData.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiState = entityProfileResponseMsg.getApiState();
    assertSame(unknownFields2, apiState.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityProfileResponseMsg.getDeviceProfile();
    assertSame(unknownFields2, deviceProfile.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityProfileResponseMsg.getTenantProfile();
    assertSame(unknownFields2, tenantProfile.getUnknownFields());
    TransportProtos.DeviceInfoProto deviceInfo = getOrCreateDeviceResponseMsg.getDeviceInfo();
    assertSame(unknownFields2, deviceInfo.getUnknownFields());
    TransportProtos.TbResourceProto resource = resourceResponseMsg.getResource();
    assertSame(unknownFields2, resource.getUnknownFields());
    TransportProtos.LwM2MRegistrationResponseMsg registrationMsg = lwM2MResponseMsg.getRegistrationMsg();
    assertSame(unknownFields2, registrationMsg.getUnknownFields());
    assertSame(unknownFields2, deviceCredentialsResponseMsg.getUnknownFields());
    assertSame(unknownFields2, deviceResponseMsg.getUnknownFields());
    assertSame(unknownFields2, entityProfileResponseMsg.getUnknownFields());
    assertSame(unknownFields2, getOrCreateDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields2, lwM2MResponseMsg.getUnknownFields());
    assertSame(unknownFields2, otaPackageResponseMsg.getUnknownFields());
    assertSame(unknownFields2, provisionDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields2, resourceResponseMsg.getUnknownFields());
    assertSame(unknownFields2, snmpDevicesResponseMsg.getUnknownFields());
    assertSame(unknownFields2, validateCredResponseMsg.getUnknownFields());
    assertSame(unknownFields2, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields2, unknownFields2.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsData.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsResponseMsg.getDeviceCredentialsDataOrBuilder());
    assertSame(apiState, apiState.getDefaultInstanceForType());
    assertSame(apiState, entityProfileResponseMsg.getApiStateOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityProfileResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfileOrBuilder());
    assertSame(tenantProfile, entityProfileResponseMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(deviceInfo, deviceInfo.getDefaultInstanceForType());
    assertSame(deviceInfo, getOrCreateDeviceResponseMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, registrationMsg.getDeviceInfo());
    assertSame(deviceInfo, registrationMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfo());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfoOrBuilder());
    assertSame(resource, resourceResponseMsg.getResourceOrBuilder());
    assertSame(resource, resource.getDefaultInstanceForType());
    ProtocolStringList idsList = snmpDevicesResponseMsg.getIdsList();
    assertSame(idsList, toProtoResult2.getReservedNameList());
    assertSame(idsList, toProtoResult.getDependencyList());
    assertSame(registrationMsg, registrationMsg.getDefaultInstanceForType());
    assertSame(registrationMsg, lwM2MResponseMsg.getRegistrationMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceCredentialsResponseMsg, deviceCredentialsResponseMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsResponseMsg, defaultInstanceForType.getDeviceCredentialsResponseMsg());
    assertSame(deviceCredentialsResponseMsg, actualDecodeResult.getDeviceCredentialsResponseMsgOrBuilder());
    assertSame(deviceCredentialsResponseMsg, defaultInstanceForType.getDeviceCredentialsResponseMsgOrBuilder());
    assertSame(deviceResponseMsg, deviceResponseMsg.getDefaultInstanceForType());
    assertSame(deviceResponseMsg, defaultInstanceForType.getDeviceResponseMsg());
    assertSame(deviceResponseMsg, actualDecodeResult.getDeviceResponseMsgOrBuilder());
    assertSame(deviceResponseMsg, defaultInstanceForType.getDeviceResponseMsgOrBuilder());
    assertSame(entityProfileResponseMsg, entityProfileResponseMsg.getDefaultInstanceForType());
    assertSame(entityProfileResponseMsg, defaultInstanceForType.getEntityProfileResponseMsg());
    assertSame(entityProfileResponseMsg, actualDecodeResult.getEntityProfileResponseMsgOrBuilder());
    assertSame(entityProfileResponseMsg, defaultInstanceForType.getEntityProfileResponseMsgOrBuilder());
    assertSame(getOrCreateDeviceResponseMsg, getOrCreateDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(getOrCreateDeviceResponseMsg, defaultInstanceForType.getGetOrCreateDeviceResponseMsg());
    assertSame(getOrCreateDeviceResponseMsg, actualDecodeResult.getGetOrCreateDeviceResponseMsgOrBuilder());
    assertSame(getOrCreateDeviceResponseMsg, defaultInstanceForType.getGetOrCreateDeviceResponseMsgOrBuilder());
    assertSame(lwM2MResponseMsg, lwM2MResponseMsg.getDefaultInstanceForType());
    assertSame(lwM2MResponseMsg, defaultInstanceForType.getLwM2MResponseMsg());
    assertSame(lwM2MResponseMsg, actualDecodeResult.getLwM2MResponseMsgOrBuilder());
    assertSame(lwM2MResponseMsg, defaultInstanceForType.getLwM2MResponseMsgOrBuilder());
    assertSame(otaPackageResponseMsg, otaPackageResponseMsg.getDefaultInstanceForType());
    assertSame(otaPackageResponseMsg, defaultInstanceForType.getOtaPackageResponseMsg());
    assertSame(otaPackageResponseMsg, actualDecodeResult.getOtaPackageResponseMsgOrBuilder());
    assertSame(otaPackageResponseMsg, defaultInstanceForType.getOtaPackageResponseMsgOrBuilder());
    assertSame(provisionDeviceResponseMsg, provisionDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(provisionDeviceResponseMsg, defaultInstanceForType.getProvisionDeviceResponseMsg());
    assertSame(provisionDeviceResponseMsg, actualDecodeResult.getProvisionDeviceResponseMsgOrBuilder());
    assertSame(provisionDeviceResponseMsg, defaultInstanceForType.getProvisionDeviceResponseMsgOrBuilder());
    assertSame(resourceResponseMsg, resourceResponseMsg.getDefaultInstanceForType());
    assertSame(resourceResponseMsg, defaultInstanceForType.getResourceResponseMsg());
    assertSame(resourceResponseMsg, actualDecodeResult.getResourceResponseMsgOrBuilder());
    assertSame(resourceResponseMsg, defaultInstanceForType.getResourceResponseMsgOrBuilder());
    assertSame(snmpDevicesResponseMsg, snmpDevicesResponseMsg.getDefaultInstanceForType());
    assertSame(snmpDevicesResponseMsg, defaultInstanceForType.getSnmpDevicesResponseMsg());
    assertSame(snmpDevicesResponseMsg, actualDecodeResult.getSnmpDevicesResponseMsgOrBuilder());
    assertSame(snmpDevicesResponseMsg, defaultInstanceForType.getSnmpDevicesResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, defaultInstanceForType.getValidateCredResponseMsg());
    assertSame(validateCredResponseMsg, actualDecodeResult.getValidateCredResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, defaultInstanceForType.getValidateCredResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, validateCredResponseMsg.getDefaultInstanceForType());
  }
}
