package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.google.api.Advice;
import com.google.api.BackendRule;
import com.google.protobuf.ByteString;
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

class ToTransportMsgResponseDecoderDiffblueTest {
  /**
   * Test {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}.
   * <p>
   * Method under test: {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg)")
  void testDecode() throws IOException {
    // Arrange
    ToTransportMsgResponseDecoder toTransportMsgResponseDecoder = new ToTransportMsgResponseDecoder();

    // Act
    TransportProtos.ToTransportMsg actualDecodeResult = toTransportMsgResponseDecoder.decode(new DefaultTbQueueMsg(
        new TbProtoQueueMsg<>(UUID.randomUUID(), DefaultTransportService.SESSION_EVENT_MSG_OPEN)));

    // Assert
    Descriptors.Descriptor descriptorForType = actualDecodeResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(Short.SIZE, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.AttributeUpdateNotificationMsg attributeUpdateNotification = actualDecodeResult
        .getAttributeUpdateNotification();
    Descriptors.Descriptor descriptorForType2 = attributeUpdateNotification.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.EntityDeleteMsg entityDeleteMsg = actualDecodeResult.getEntityDeleteMsg();
    Descriptors.Descriptor descriptorForType3 = entityDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EntityUpdateMsg entityUpdateMsg = actualDecodeResult.getEntityUpdateMsg();
    Descriptors.Descriptor descriptorForType4 = entityUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.GetAttributeResponseMsg getAttributesResponse = actualDecodeResult.getGetAttributesResponse();
    Descriptors.Descriptor descriptorForType5 = getAttributesResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionResponse = actualDecodeResult.getProvisionResponse();
    Descriptors.Descriptor descriptorForType6 = provisionResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.ResourceDeleteMsg resourceDeleteMsg = actualDecodeResult.getResourceDeleteMsg();
    Descriptors.Descriptor descriptorForType7 = resourceDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceUpdateMsg resourceUpdateMsg = actualDecodeResult.getResourceUpdateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.SessionCloseNotificationProto sessionCloseNotification = actualDecodeResult
        .getSessionCloseNotification();
    Descriptors.Descriptor descriptorForType9 = sessionCloseNotification.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToDeviceRpcRequestMsg toDeviceRequest = actualDecodeResult.getToDeviceRequest();
    Descriptors.Descriptor descriptorForType10 = toDeviceRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.ToServerRpcResponseMsg toServerResponse = actualDecodeResult.getToServerResponse();
    Descriptors.Descriptor descriptorForType11 = toServerResponse.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    TransportProtos.ToTransportUpdateCredentialsProto toTransportUpdateCredentialsNotification = actualDecodeResult
        .getToTransportUpdateCredentialsNotification();
    Descriptors.Descriptor descriptorForType12 = toTransportUpdateCredentialsNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = actualDecodeResult.getUplinkNotificationMsg();
    Descriptors.Descriptor descriptorForType13 = uplinkNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType13.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(14);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(15);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertSame(options, toProtoResult.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    assertSame(options, descriptorForType12.getOptions());
    assertSame(options, descriptorForType13.getOptions());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    TransportProtos.ToTransportMsg defaultInstanceForType = actualDecodeResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualDecodeResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiUsageState = entityUpdateMsg.getApiUsageState();
    assertSame(unknownFields, apiUsageState.getUnknownFields());
    TransportProtos.DeviceProto device = entityUpdateMsg.getDevice();
    assertSame(unknownFields, device.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityUpdateMsg.getDeviceProfile();
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    TransportProtos.TenantProto tenant = entityUpdateMsg.getTenant();
    assertSame(unknownFields, tenant.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityUpdateMsg.getTenantProfile();
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    assertSame(unknownFields, attributeUpdateNotification.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, entityDeleteMsg.getUnknownFields());
    assertSame(unknownFields, entityUpdateMsg.getUnknownFields());
    assertSame(unknownFields, getAttributesResponse.getUnknownFields());
    assertSame(unknownFields, provisionResponse.getUnknownFields());
    assertSame(unknownFields, resourceDeleteMsg.getUnknownFields());
    assertSame(unknownFields, resourceUpdateMsg.getUnknownFields());
    assertSame(unknownFields, sessionCloseNotification.getUnknownFields());
    assertSame(unknownFields, toDeviceRequest.getUnknownFields());
    assertSame(unknownFields, toServerResponse.getUnknownFields());
    assertSame(unknownFields, toTransportUpdateCredentialsNotification.getUnknownFields());
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList sharedDeletedList = attributeUpdateNotification.getSharedDeletedList();
    assertSame(sharedDeletedList, toProtoResult.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult2.getReservedNameList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsIdList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsValueList());
    ByteString deviceData = device.getDeviceData();
    assertSame(deviceData, deviceProfile.getDeviceProfileData());
    assertSame(deviceData, tenantProfile.getProfileData());
    assertSame(apiUsageState, apiUsageState.getDefaultInstanceForType());
    assertSame(apiUsageState, entityUpdateMsg.getApiUsageStateOrBuilder());
    assertSame(device, device.getDefaultInstanceForType());
    assertSame(device, entityUpdateMsg.getDeviceOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityUpdateMsg.getDeviceProfileOrBuilder());
    assertSame(tenant, entityUpdateMsg.getTenantOrBuilder());
    assertSame(tenant, tenant.getDefaultInstanceForType());
    assertSame(tenantProfile, entityUpdateMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, attributeUpdateNotification.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, defaultInstanceForType.getAttributeUpdateNotification());
    assertSame(attributeUpdateNotification, actualDecodeResult.getAttributeUpdateNotificationOrBuilder());
    assertSame(attributeUpdateNotification, defaultInstanceForType.getAttributeUpdateNotificationOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(entityDeleteMsg, entityDeleteMsg.getDefaultInstanceForType());
    assertSame(entityDeleteMsg, defaultInstanceForType.getEntityDeleteMsg());
    assertSame(entityDeleteMsg, actualDecodeResult.getEntityDeleteMsgOrBuilder());
    assertSame(entityDeleteMsg, defaultInstanceForType.getEntityDeleteMsgOrBuilder());
    assertSame(entityUpdateMsg, entityUpdateMsg.getDefaultInstanceForType());
    assertSame(entityUpdateMsg, defaultInstanceForType.getEntityUpdateMsg());
    assertSame(entityUpdateMsg, actualDecodeResult.getEntityUpdateMsgOrBuilder());
    assertSame(entityUpdateMsg, defaultInstanceForType.getEntityUpdateMsgOrBuilder());
    assertSame(getAttributesResponse, getAttributesResponse.getDefaultInstanceForType());
    assertSame(getAttributesResponse, defaultInstanceForType.getGetAttributesResponse());
    assertSame(getAttributesResponse, actualDecodeResult.getGetAttributesResponseOrBuilder());
    assertSame(getAttributesResponse, defaultInstanceForType.getGetAttributesResponseOrBuilder());
    assertSame(provisionResponse, provisionResponse.getDefaultInstanceForType());
    assertSame(provisionResponse, defaultInstanceForType.getProvisionResponse());
    assertSame(provisionResponse, actualDecodeResult.getProvisionResponseOrBuilder());
    assertSame(provisionResponse, defaultInstanceForType.getProvisionResponseOrBuilder());
    assertSame(resourceDeleteMsg, resourceDeleteMsg.getDefaultInstanceForType());
    assertSame(resourceDeleteMsg, defaultInstanceForType.getResourceDeleteMsg());
    assertSame(resourceDeleteMsg, actualDecodeResult.getResourceDeleteMsgOrBuilder());
    assertSame(resourceDeleteMsg, defaultInstanceForType.getResourceDeleteMsgOrBuilder());
    assertSame(resourceUpdateMsg, resourceUpdateMsg.getDefaultInstanceForType());
    assertSame(resourceUpdateMsg, defaultInstanceForType.getResourceUpdateMsg());
    assertSame(resourceUpdateMsg, actualDecodeResult.getResourceUpdateMsgOrBuilder());
    assertSame(resourceUpdateMsg, defaultInstanceForType.getResourceUpdateMsgOrBuilder());
    assertSame(sessionCloseNotification, sessionCloseNotification.getDefaultInstanceForType());
    assertSame(sessionCloseNotification, defaultInstanceForType.getSessionCloseNotification());
    assertSame(sessionCloseNotification, actualDecodeResult.getSessionCloseNotificationOrBuilder());
    assertSame(sessionCloseNotification, defaultInstanceForType.getSessionCloseNotificationOrBuilder());
    assertSame(toDeviceRequest, toDeviceRequest.getDefaultInstanceForType());
    assertSame(toDeviceRequest, defaultInstanceForType.getToDeviceRequest());
    assertSame(toDeviceRequest, actualDecodeResult.getToDeviceRequestOrBuilder());
    assertSame(toDeviceRequest, defaultInstanceForType.getToDeviceRequestOrBuilder());
    assertSame(toServerResponse, toServerResponse.getDefaultInstanceForType());
    assertSame(toServerResponse, defaultInstanceForType.getToServerResponse());
    assertSame(toServerResponse, actualDecodeResult.getToServerResponseOrBuilder());
    assertSame(toServerResponse, defaultInstanceForType.getToServerResponseOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        defaultInstanceForType.getToTransportUpdateCredentialsNotification());
    assertSame(toTransportUpdateCredentialsNotification,
        actualDecodeResult.getToTransportUpdateCredentialsNotificationOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        defaultInstanceForType.getToTransportUpdateCredentialsNotificationOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        toTransportUpdateCredentialsNotification.getDefaultInstanceForType());
    assertSame(uplinkNotificationMsg, defaultInstanceForType.getUplinkNotificationMsg());
    assertSame(uplinkNotificationMsg, actualDecodeResult.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, defaultInstanceForType.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}.
   * <p>
   * Method under test: {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg)")
  void testDecode2() throws IOException {
    // Arrange
    ToTransportMsgResponseDecoder toTransportMsgResponseDecoder = new ToTransportMsgResponseDecoder();

    // Act
    TransportProtos.ToTransportMsg actualDecodeResult = toTransportMsgResponseDecoder
        .decode(new TbProtoQueueMsg<>(UUID.randomUUID(), DefaultTransportService.SESSION_EVENT_MSG_OPEN));

    // Assert
    Descriptors.Descriptor descriptorForType = actualDecodeResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(Short.SIZE, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.AttributeUpdateNotificationMsg attributeUpdateNotification = actualDecodeResult
        .getAttributeUpdateNotification();
    Descriptors.Descriptor descriptorForType2 = attributeUpdateNotification.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.EntityDeleteMsg entityDeleteMsg = actualDecodeResult.getEntityDeleteMsg();
    Descriptors.Descriptor descriptorForType3 = entityDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EntityUpdateMsg entityUpdateMsg = actualDecodeResult.getEntityUpdateMsg();
    Descriptors.Descriptor descriptorForType4 = entityUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.GetAttributeResponseMsg getAttributesResponse = actualDecodeResult.getGetAttributesResponse();
    Descriptors.Descriptor descriptorForType5 = getAttributesResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionResponse = actualDecodeResult.getProvisionResponse();
    Descriptors.Descriptor descriptorForType6 = provisionResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.ResourceDeleteMsg resourceDeleteMsg = actualDecodeResult.getResourceDeleteMsg();
    Descriptors.Descriptor descriptorForType7 = resourceDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceUpdateMsg resourceUpdateMsg = actualDecodeResult.getResourceUpdateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.SessionCloseNotificationProto sessionCloseNotification = actualDecodeResult
        .getSessionCloseNotification();
    Descriptors.Descriptor descriptorForType9 = sessionCloseNotification.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToDeviceRpcRequestMsg toDeviceRequest = actualDecodeResult.getToDeviceRequest();
    Descriptors.Descriptor descriptorForType10 = toDeviceRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.ToServerRpcResponseMsg toServerResponse = actualDecodeResult.getToServerResponse();
    Descriptors.Descriptor descriptorForType11 = toServerResponse.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    TransportProtos.ToTransportUpdateCredentialsProto toTransportUpdateCredentialsNotification = actualDecodeResult
        .getToTransportUpdateCredentialsNotification();
    Descriptors.Descriptor descriptorForType12 = toTransportUpdateCredentialsNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = actualDecodeResult.getUplinkNotificationMsg();
    Descriptors.Descriptor descriptorForType13 = uplinkNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType13.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(14);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(15);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertSame(options, toProtoResult.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    assertSame(options, descriptorForType12.getOptions());
    assertSame(options, descriptorForType13.getOptions());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    TransportProtos.ToTransportMsg defaultInstanceForType = actualDecodeResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualDecodeResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiUsageState = entityUpdateMsg.getApiUsageState();
    assertSame(unknownFields, apiUsageState.getUnknownFields());
    TransportProtos.DeviceProto device = entityUpdateMsg.getDevice();
    assertSame(unknownFields, device.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityUpdateMsg.getDeviceProfile();
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    TransportProtos.TenantProto tenant = entityUpdateMsg.getTenant();
    assertSame(unknownFields, tenant.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityUpdateMsg.getTenantProfile();
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    assertSame(unknownFields, attributeUpdateNotification.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, entityDeleteMsg.getUnknownFields());
    assertSame(unknownFields, entityUpdateMsg.getUnknownFields());
    assertSame(unknownFields, getAttributesResponse.getUnknownFields());
    assertSame(unknownFields, provisionResponse.getUnknownFields());
    assertSame(unknownFields, resourceDeleteMsg.getUnknownFields());
    assertSame(unknownFields, resourceUpdateMsg.getUnknownFields());
    assertSame(unknownFields, sessionCloseNotification.getUnknownFields());
    assertSame(unknownFields, toDeviceRequest.getUnknownFields());
    assertSame(unknownFields, toServerResponse.getUnknownFields());
    assertSame(unknownFields, toTransportUpdateCredentialsNotification.getUnknownFields());
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList sharedDeletedList = attributeUpdateNotification.getSharedDeletedList();
    assertSame(sharedDeletedList, toProtoResult.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult2.getReservedNameList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsIdList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsValueList());
    ByteString deviceData = device.getDeviceData();
    assertSame(deviceData, deviceProfile.getDeviceProfileData());
    assertSame(deviceData, tenantProfile.getProfileData());
    assertSame(apiUsageState, apiUsageState.getDefaultInstanceForType());
    assertSame(apiUsageState, entityUpdateMsg.getApiUsageStateOrBuilder());
    assertSame(device, device.getDefaultInstanceForType());
    assertSame(device, entityUpdateMsg.getDeviceOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityUpdateMsg.getDeviceProfileOrBuilder());
    assertSame(tenant, entityUpdateMsg.getTenantOrBuilder());
    assertSame(tenant, tenant.getDefaultInstanceForType());
    assertSame(tenantProfile, entityUpdateMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, attributeUpdateNotification.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, defaultInstanceForType.getAttributeUpdateNotification());
    assertSame(attributeUpdateNotification, actualDecodeResult.getAttributeUpdateNotificationOrBuilder());
    assertSame(attributeUpdateNotification, defaultInstanceForType.getAttributeUpdateNotificationOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(entityDeleteMsg, entityDeleteMsg.getDefaultInstanceForType());
    assertSame(entityDeleteMsg, defaultInstanceForType.getEntityDeleteMsg());
    assertSame(entityDeleteMsg, actualDecodeResult.getEntityDeleteMsgOrBuilder());
    assertSame(entityDeleteMsg, defaultInstanceForType.getEntityDeleteMsgOrBuilder());
    assertSame(entityUpdateMsg, entityUpdateMsg.getDefaultInstanceForType());
    assertSame(entityUpdateMsg, defaultInstanceForType.getEntityUpdateMsg());
    assertSame(entityUpdateMsg, actualDecodeResult.getEntityUpdateMsgOrBuilder());
    assertSame(entityUpdateMsg, defaultInstanceForType.getEntityUpdateMsgOrBuilder());
    assertSame(getAttributesResponse, getAttributesResponse.getDefaultInstanceForType());
    assertSame(getAttributesResponse, defaultInstanceForType.getGetAttributesResponse());
    assertSame(getAttributesResponse, actualDecodeResult.getGetAttributesResponseOrBuilder());
    assertSame(getAttributesResponse, defaultInstanceForType.getGetAttributesResponseOrBuilder());
    assertSame(provisionResponse, provisionResponse.getDefaultInstanceForType());
    assertSame(provisionResponse, defaultInstanceForType.getProvisionResponse());
    assertSame(provisionResponse, actualDecodeResult.getProvisionResponseOrBuilder());
    assertSame(provisionResponse, defaultInstanceForType.getProvisionResponseOrBuilder());
    assertSame(resourceDeleteMsg, resourceDeleteMsg.getDefaultInstanceForType());
    assertSame(resourceDeleteMsg, defaultInstanceForType.getResourceDeleteMsg());
    assertSame(resourceDeleteMsg, actualDecodeResult.getResourceDeleteMsgOrBuilder());
    assertSame(resourceDeleteMsg, defaultInstanceForType.getResourceDeleteMsgOrBuilder());
    assertSame(resourceUpdateMsg, resourceUpdateMsg.getDefaultInstanceForType());
    assertSame(resourceUpdateMsg, defaultInstanceForType.getResourceUpdateMsg());
    assertSame(resourceUpdateMsg, actualDecodeResult.getResourceUpdateMsgOrBuilder());
    assertSame(resourceUpdateMsg, defaultInstanceForType.getResourceUpdateMsgOrBuilder());
    assertSame(sessionCloseNotification, sessionCloseNotification.getDefaultInstanceForType());
    assertSame(sessionCloseNotification, defaultInstanceForType.getSessionCloseNotification());
    assertSame(sessionCloseNotification, actualDecodeResult.getSessionCloseNotificationOrBuilder());
    assertSame(sessionCloseNotification, defaultInstanceForType.getSessionCloseNotificationOrBuilder());
    assertSame(toDeviceRequest, toDeviceRequest.getDefaultInstanceForType());
    assertSame(toDeviceRequest, defaultInstanceForType.getToDeviceRequest());
    assertSame(toDeviceRequest, actualDecodeResult.getToDeviceRequestOrBuilder());
    assertSame(toDeviceRequest, defaultInstanceForType.getToDeviceRequestOrBuilder());
    assertSame(toServerResponse, toServerResponse.getDefaultInstanceForType());
    assertSame(toServerResponse, defaultInstanceForType.getToServerResponse());
    assertSame(toServerResponse, actualDecodeResult.getToServerResponseOrBuilder());
    assertSame(toServerResponse, defaultInstanceForType.getToServerResponseOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        defaultInstanceForType.getToTransportUpdateCredentialsNotification());
    assertSame(toTransportUpdateCredentialsNotification,
        actualDecodeResult.getToTransportUpdateCredentialsNotificationOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        defaultInstanceForType.getToTransportUpdateCredentialsNotificationOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        toTransportUpdateCredentialsNotification.getDefaultInstanceForType());
    assertSame(uplinkNotificationMsg, defaultInstanceForType.getUplinkNotificationMsg());
    assertSame(uplinkNotificationMsg, actualDecodeResult.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, defaultInstanceForType.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}.
   * <p>
   * Method under test: {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg)")
  void testDecode3() throws IOException {
    // Arrange
    ToTransportMsgResponseDecoder toTransportMsgResponseDecoder = new ToTransportMsgResponseDecoder();

    // Act
    TransportProtos.ToTransportMsg actualDecodeResult = toTransportMsgResponseDecoder.decode(new DefaultTbQueueMsg(
        new TbProtoQueueMsg<>(UUID.randomUUID(), TransportActivityManager.SESSION_EXPIRED_NOTIFICATION_PROTO)));

    // Assert
    Descriptors.Descriptor descriptorForType = actualDecodeResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(Short.SIZE, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.AttributeUpdateNotificationMsg attributeUpdateNotification = actualDecodeResult
        .getAttributeUpdateNotification();
    Descriptors.Descriptor descriptorForType2 = attributeUpdateNotification.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.EntityDeleteMsg entityDeleteMsg = actualDecodeResult.getEntityDeleteMsg();
    Descriptors.Descriptor descriptorForType3 = entityDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EntityUpdateMsg entityUpdateMsg = actualDecodeResult.getEntityUpdateMsg();
    Descriptors.Descriptor descriptorForType4 = entityUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.GetAttributeResponseMsg getAttributesResponse = actualDecodeResult.getGetAttributesResponse();
    Descriptors.Descriptor descriptorForType5 = getAttributesResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionResponse = actualDecodeResult.getProvisionResponse();
    Descriptors.Descriptor descriptorForType6 = provisionResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.ResourceDeleteMsg resourceDeleteMsg = actualDecodeResult.getResourceDeleteMsg();
    Descriptors.Descriptor descriptorForType7 = resourceDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceUpdateMsg resourceUpdateMsg = actualDecodeResult.getResourceUpdateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.SessionCloseNotificationProto sessionCloseNotification = actualDecodeResult
        .getSessionCloseNotification();
    Descriptors.Descriptor descriptorForType9 = sessionCloseNotification.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToDeviceRpcRequestMsg toDeviceRequest = actualDecodeResult.getToDeviceRequest();
    Descriptors.Descriptor descriptorForType10 = toDeviceRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.ToServerRpcResponseMsg toServerResponse = actualDecodeResult.getToServerResponse();
    Descriptors.Descriptor descriptorForType11 = toServerResponse.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    TransportProtos.ToTransportUpdateCredentialsProto toTransportUpdateCredentialsNotification = actualDecodeResult
        .getToTransportUpdateCredentialsNotification();
    Descriptors.Descriptor descriptorForType12 = toTransportUpdateCredentialsNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = actualDecodeResult.getUplinkNotificationMsg();
    Descriptors.Descriptor descriptorForType13 = uplinkNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType13.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(14);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(15);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertSame(options, toProtoResult.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    assertSame(options, descriptorForType12.getOptions());
    assertSame(options, descriptorForType13.getOptions());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    TransportProtos.ToTransportMsg defaultInstanceForType = actualDecodeResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = attributeUpdateNotification.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiUsageState = entityUpdateMsg.getApiUsageState();
    assertSame(unknownFields, apiUsageState.getUnknownFields());
    TransportProtos.DeviceProto device = entityUpdateMsg.getDevice();
    assertSame(unknownFields, device.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityUpdateMsg.getDeviceProfile();
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    TransportProtos.TenantProto tenant = entityUpdateMsg.getTenant();
    assertSame(unknownFields, tenant.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityUpdateMsg.getTenantProfile();
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, entityDeleteMsg.getUnknownFields());
    assertSame(unknownFields, entityUpdateMsg.getUnknownFields());
    assertSame(unknownFields, getAttributesResponse.getUnknownFields());
    assertSame(unknownFields, provisionResponse.getUnknownFields());
    assertSame(unknownFields, resourceDeleteMsg.getUnknownFields());
    assertSame(unknownFields, resourceUpdateMsg.getUnknownFields());
    assertSame(unknownFields, sessionCloseNotification.getUnknownFields());
    assertSame(unknownFields, toDeviceRequest.getUnknownFields());
    assertSame(unknownFields, toServerResponse.getUnknownFields());
    assertSame(unknownFields, toTransportUpdateCredentialsNotification.getUnknownFields());
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, actualDecodeResult.getUnknownFields().getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList sharedDeletedList = attributeUpdateNotification.getSharedDeletedList();
    assertSame(sharedDeletedList, toProtoResult.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult2.getReservedNameList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsIdList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsValueList());
    ByteString deviceData = device.getDeviceData();
    assertSame(deviceData, deviceProfile.getDeviceProfileData());
    assertSame(deviceData, tenantProfile.getProfileData());
    assertSame(apiUsageState, apiUsageState.getDefaultInstanceForType());
    assertSame(apiUsageState, entityUpdateMsg.getApiUsageStateOrBuilder());
    assertSame(device, device.getDefaultInstanceForType());
    assertSame(device, entityUpdateMsg.getDeviceOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityUpdateMsg.getDeviceProfileOrBuilder());
    assertSame(tenant, entityUpdateMsg.getTenantOrBuilder());
    assertSame(tenant, tenant.getDefaultInstanceForType());
    assertSame(tenantProfile, entityUpdateMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, attributeUpdateNotification.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, defaultInstanceForType.getAttributeUpdateNotification());
    assertSame(attributeUpdateNotification, actualDecodeResult.getAttributeUpdateNotificationOrBuilder());
    assertSame(attributeUpdateNotification, defaultInstanceForType.getAttributeUpdateNotificationOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(entityDeleteMsg, entityDeleteMsg.getDefaultInstanceForType());
    assertSame(entityDeleteMsg, defaultInstanceForType.getEntityDeleteMsg());
    assertSame(entityDeleteMsg, actualDecodeResult.getEntityDeleteMsgOrBuilder());
    assertSame(entityDeleteMsg, defaultInstanceForType.getEntityDeleteMsgOrBuilder());
    assertSame(entityUpdateMsg, entityUpdateMsg.getDefaultInstanceForType());
    assertSame(entityUpdateMsg, defaultInstanceForType.getEntityUpdateMsg());
    assertSame(entityUpdateMsg, actualDecodeResult.getEntityUpdateMsgOrBuilder());
    assertSame(entityUpdateMsg, defaultInstanceForType.getEntityUpdateMsgOrBuilder());
    assertSame(getAttributesResponse, getAttributesResponse.getDefaultInstanceForType());
    assertSame(getAttributesResponse, defaultInstanceForType.getGetAttributesResponse());
    assertSame(getAttributesResponse, actualDecodeResult.getGetAttributesResponseOrBuilder());
    assertSame(getAttributesResponse, defaultInstanceForType.getGetAttributesResponseOrBuilder());
    assertSame(provisionResponse, provisionResponse.getDefaultInstanceForType());
    assertSame(provisionResponse, defaultInstanceForType.getProvisionResponse());
    assertSame(provisionResponse, actualDecodeResult.getProvisionResponseOrBuilder());
    assertSame(provisionResponse, defaultInstanceForType.getProvisionResponseOrBuilder());
    assertSame(resourceDeleteMsg, resourceDeleteMsg.getDefaultInstanceForType());
    assertSame(resourceDeleteMsg, defaultInstanceForType.getResourceDeleteMsg());
    assertSame(resourceDeleteMsg, actualDecodeResult.getResourceDeleteMsgOrBuilder());
    assertSame(resourceDeleteMsg, defaultInstanceForType.getResourceDeleteMsgOrBuilder());
    assertSame(resourceUpdateMsg, resourceUpdateMsg.getDefaultInstanceForType());
    assertSame(resourceUpdateMsg, defaultInstanceForType.getResourceUpdateMsg());
    assertSame(resourceUpdateMsg, actualDecodeResult.getResourceUpdateMsgOrBuilder());
    assertSame(resourceUpdateMsg, defaultInstanceForType.getResourceUpdateMsgOrBuilder());
    assertSame(sessionCloseNotification, sessionCloseNotification.getDefaultInstanceForType());
    assertSame(sessionCloseNotification, defaultInstanceForType.getSessionCloseNotification());
    assertSame(sessionCloseNotification, actualDecodeResult.getSessionCloseNotificationOrBuilder());
    assertSame(sessionCloseNotification, defaultInstanceForType.getSessionCloseNotificationOrBuilder());
    assertSame(toDeviceRequest, toDeviceRequest.getDefaultInstanceForType());
    assertSame(toDeviceRequest, defaultInstanceForType.getToDeviceRequest());
    assertSame(toDeviceRequest, actualDecodeResult.getToDeviceRequestOrBuilder());
    assertSame(toDeviceRequest, defaultInstanceForType.getToDeviceRequestOrBuilder());
    assertSame(toServerResponse, toServerResponse.getDefaultInstanceForType());
    assertSame(toServerResponse, defaultInstanceForType.getToServerResponse());
    assertSame(toServerResponse, actualDecodeResult.getToServerResponseOrBuilder());
    assertSame(toServerResponse, defaultInstanceForType.getToServerResponseOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        defaultInstanceForType.getToTransportUpdateCredentialsNotification());
    assertSame(toTransportUpdateCredentialsNotification,
        actualDecodeResult.getToTransportUpdateCredentialsNotificationOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        defaultInstanceForType.getToTransportUpdateCredentialsNotificationOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        toTransportUpdateCredentialsNotification.getDefaultInstanceForType());
    assertSame(uplinkNotificationMsg, defaultInstanceForType.getUplinkNotificationMsg());
    assertSame(uplinkNotificationMsg, actualDecodeResult.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, defaultInstanceForType.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}.
   * <p>
   * Method under test: {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg)")
  void testDecode4() throws IOException {
    // Arrange
    ToTransportMsgResponseDecoder toTransportMsgResponseDecoder = new ToTransportMsgResponseDecoder();

    // Act
    TransportProtos.ToTransportMsg actualDecodeResult = toTransportMsgResponseDecoder
        .decode(new TbProtoQueueMsg<>(UUID.randomUUID(), TransportActivityManager.SESSION_EXPIRED_NOTIFICATION_PROTO));

    // Assert
    Descriptors.Descriptor descriptorForType = actualDecodeResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(Short.SIZE, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.AttributeUpdateNotificationMsg attributeUpdateNotification = actualDecodeResult
        .getAttributeUpdateNotification();
    Descriptors.Descriptor descriptorForType2 = attributeUpdateNotification.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.EntityDeleteMsg entityDeleteMsg = actualDecodeResult.getEntityDeleteMsg();
    Descriptors.Descriptor descriptorForType3 = entityDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EntityUpdateMsg entityUpdateMsg = actualDecodeResult.getEntityUpdateMsg();
    Descriptors.Descriptor descriptorForType4 = entityUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.GetAttributeResponseMsg getAttributesResponse = actualDecodeResult.getGetAttributesResponse();
    Descriptors.Descriptor descriptorForType5 = getAttributesResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionResponse = actualDecodeResult.getProvisionResponse();
    Descriptors.Descriptor descriptorForType6 = provisionResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.ResourceDeleteMsg resourceDeleteMsg = actualDecodeResult.getResourceDeleteMsg();
    Descriptors.Descriptor descriptorForType7 = resourceDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceUpdateMsg resourceUpdateMsg = actualDecodeResult.getResourceUpdateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.SessionCloseNotificationProto sessionCloseNotification = actualDecodeResult
        .getSessionCloseNotification();
    Descriptors.Descriptor descriptorForType9 = sessionCloseNotification.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToDeviceRpcRequestMsg toDeviceRequest = actualDecodeResult.getToDeviceRequest();
    Descriptors.Descriptor descriptorForType10 = toDeviceRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.ToServerRpcResponseMsg toServerResponse = actualDecodeResult.getToServerResponse();
    Descriptors.Descriptor descriptorForType11 = toServerResponse.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    TransportProtos.ToTransportUpdateCredentialsProto toTransportUpdateCredentialsNotification = actualDecodeResult
        .getToTransportUpdateCredentialsNotification();
    Descriptors.Descriptor descriptorForType12 = toTransportUpdateCredentialsNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = actualDecodeResult.getUplinkNotificationMsg();
    Descriptors.Descriptor descriptorForType13 = uplinkNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType13.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(14);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(15);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertSame(options, toProtoResult.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    assertSame(options, descriptorForType12.getOptions());
    assertSame(options, descriptorForType13.getOptions());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    TransportProtos.ToTransportMsg defaultInstanceForType = actualDecodeResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = attributeUpdateNotification.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiUsageState = entityUpdateMsg.getApiUsageState();
    assertSame(unknownFields, apiUsageState.getUnknownFields());
    TransportProtos.DeviceProto device = entityUpdateMsg.getDevice();
    assertSame(unknownFields, device.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityUpdateMsg.getDeviceProfile();
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    TransportProtos.TenantProto tenant = entityUpdateMsg.getTenant();
    assertSame(unknownFields, tenant.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityUpdateMsg.getTenantProfile();
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, entityDeleteMsg.getUnknownFields());
    assertSame(unknownFields, entityUpdateMsg.getUnknownFields());
    assertSame(unknownFields, getAttributesResponse.getUnknownFields());
    assertSame(unknownFields, provisionResponse.getUnknownFields());
    assertSame(unknownFields, resourceDeleteMsg.getUnknownFields());
    assertSame(unknownFields, resourceUpdateMsg.getUnknownFields());
    assertSame(unknownFields, sessionCloseNotification.getUnknownFields());
    assertSame(unknownFields, toDeviceRequest.getUnknownFields());
    assertSame(unknownFields, toServerResponse.getUnknownFields());
    assertSame(unknownFields, toTransportUpdateCredentialsNotification.getUnknownFields());
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, actualDecodeResult.getUnknownFields().getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList sharedDeletedList = attributeUpdateNotification.getSharedDeletedList();
    assertSame(sharedDeletedList, toProtoResult.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult2.getReservedNameList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsIdList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsValueList());
    ByteString deviceData = device.getDeviceData();
    assertSame(deviceData, deviceProfile.getDeviceProfileData());
    assertSame(deviceData, tenantProfile.getProfileData());
    assertSame(apiUsageState, apiUsageState.getDefaultInstanceForType());
    assertSame(apiUsageState, entityUpdateMsg.getApiUsageStateOrBuilder());
    assertSame(device, device.getDefaultInstanceForType());
    assertSame(device, entityUpdateMsg.getDeviceOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityUpdateMsg.getDeviceProfileOrBuilder());
    assertSame(tenant, entityUpdateMsg.getTenantOrBuilder());
    assertSame(tenant, tenant.getDefaultInstanceForType());
    assertSame(tenantProfile, entityUpdateMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, attributeUpdateNotification.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, defaultInstanceForType.getAttributeUpdateNotification());
    assertSame(attributeUpdateNotification, actualDecodeResult.getAttributeUpdateNotificationOrBuilder());
    assertSame(attributeUpdateNotification, defaultInstanceForType.getAttributeUpdateNotificationOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(entityDeleteMsg, entityDeleteMsg.getDefaultInstanceForType());
    assertSame(entityDeleteMsg, defaultInstanceForType.getEntityDeleteMsg());
    assertSame(entityDeleteMsg, actualDecodeResult.getEntityDeleteMsgOrBuilder());
    assertSame(entityDeleteMsg, defaultInstanceForType.getEntityDeleteMsgOrBuilder());
    assertSame(entityUpdateMsg, entityUpdateMsg.getDefaultInstanceForType());
    assertSame(entityUpdateMsg, defaultInstanceForType.getEntityUpdateMsg());
    assertSame(entityUpdateMsg, actualDecodeResult.getEntityUpdateMsgOrBuilder());
    assertSame(entityUpdateMsg, defaultInstanceForType.getEntityUpdateMsgOrBuilder());
    assertSame(getAttributesResponse, getAttributesResponse.getDefaultInstanceForType());
    assertSame(getAttributesResponse, defaultInstanceForType.getGetAttributesResponse());
    assertSame(getAttributesResponse, actualDecodeResult.getGetAttributesResponseOrBuilder());
    assertSame(getAttributesResponse, defaultInstanceForType.getGetAttributesResponseOrBuilder());
    assertSame(provisionResponse, provisionResponse.getDefaultInstanceForType());
    assertSame(provisionResponse, defaultInstanceForType.getProvisionResponse());
    assertSame(provisionResponse, actualDecodeResult.getProvisionResponseOrBuilder());
    assertSame(provisionResponse, defaultInstanceForType.getProvisionResponseOrBuilder());
    assertSame(resourceDeleteMsg, resourceDeleteMsg.getDefaultInstanceForType());
    assertSame(resourceDeleteMsg, defaultInstanceForType.getResourceDeleteMsg());
    assertSame(resourceDeleteMsg, actualDecodeResult.getResourceDeleteMsgOrBuilder());
    assertSame(resourceDeleteMsg, defaultInstanceForType.getResourceDeleteMsgOrBuilder());
    assertSame(resourceUpdateMsg, resourceUpdateMsg.getDefaultInstanceForType());
    assertSame(resourceUpdateMsg, defaultInstanceForType.getResourceUpdateMsg());
    assertSame(resourceUpdateMsg, actualDecodeResult.getResourceUpdateMsgOrBuilder());
    assertSame(resourceUpdateMsg, defaultInstanceForType.getResourceUpdateMsgOrBuilder());
    assertSame(sessionCloseNotification, sessionCloseNotification.getDefaultInstanceForType());
    assertSame(sessionCloseNotification, defaultInstanceForType.getSessionCloseNotification());
    assertSame(sessionCloseNotification, actualDecodeResult.getSessionCloseNotificationOrBuilder());
    assertSame(sessionCloseNotification, defaultInstanceForType.getSessionCloseNotificationOrBuilder());
    assertSame(toDeviceRequest, toDeviceRequest.getDefaultInstanceForType());
    assertSame(toDeviceRequest, defaultInstanceForType.getToDeviceRequest());
    assertSame(toDeviceRequest, actualDecodeResult.getToDeviceRequestOrBuilder());
    assertSame(toDeviceRequest, defaultInstanceForType.getToDeviceRequestOrBuilder());
    assertSame(toServerResponse, toServerResponse.getDefaultInstanceForType());
    assertSame(toServerResponse, defaultInstanceForType.getToServerResponse());
    assertSame(toServerResponse, actualDecodeResult.getToServerResponseOrBuilder());
    assertSame(toServerResponse, defaultInstanceForType.getToServerResponseOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        defaultInstanceForType.getToTransportUpdateCredentialsNotification());
    assertSame(toTransportUpdateCredentialsNotification,
        actualDecodeResult.getToTransportUpdateCredentialsNotificationOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        defaultInstanceForType.getToTransportUpdateCredentialsNotificationOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        toTransportUpdateCredentialsNotification.getDefaultInstanceForType());
    assertSame(uplinkNotificationMsg, defaultInstanceForType.getUplinkNotificationMsg());
    assertSame(uplinkNotificationMsg, actualDecodeResult.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, defaultInstanceForType.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}.
   * <ul>
   *   <li>Then return SessionIdLSB is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg); then return SessionIdLSB is one")
  void testDecode_thenReturnSessionIdLSBIsOne() throws IOException {
    // Arrange
    ToTransportMsgResponseDecoder toTransportMsgResponseDecoder = new ToTransportMsgResponseDecoder();

    // Act
    TransportProtos.ToTransportMsg actualDecodeResult = toTransportMsgResponseDecoder.decode(new DefaultTbQueueMsg(
        new TbProtoQueueMsg<>(UUID.randomUUID(), DefaultTransportService.SUBSCRIBE_TO_ATTRIBUTE_UPDATES_ASYNC_MSG)));

    // Assert
    assertEquals(1L, actualDecodeResult.getSessionIdLSB());
    Descriptors.Descriptor descriptorForType = actualDecodeResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(Short.SIZE, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.AttributeUpdateNotificationMsg attributeUpdateNotification = actualDecodeResult
        .getAttributeUpdateNotification();
    Descriptors.Descriptor descriptorForType2 = attributeUpdateNotification.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.EntityDeleteMsg entityDeleteMsg = actualDecodeResult.getEntityDeleteMsg();
    Descriptors.Descriptor descriptorForType3 = entityDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EntityUpdateMsg entityUpdateMsg = actualDecodeResult.getEntityUpdateMsg();
    Descriptors.Descriptor descriptorForType4 = entityUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.GetAttributeResponseMsg getAttributesResponse = actualDecodeResult.getGetAttributesResponse();
    Descriptors.Descriptor descriptorForType5 = getAttributesResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionResponse = actualDecodeResult.getProvisionResponse();
    Descriptors.Descriptor descriptorForType6 = provisionResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.ResourceDeleteMsg resourceDeleteMsg = actualDecodeResult.getResourceDeleteMsg();
    Descriptors.Descriptor descriptorForType7 = resourceDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceUpdateMsg resourceUpdateMsg = actualDecodeResult.getResourceUpdateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.SessionCloseNotificationProto sessionCloseNotification = actualDecodeResult
        .getSessionCloseNotification();
    Descriptors.Descriptor descriptorForType9 = sessionCloseNotification.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToDeviceRpcRequestMsg toDeviceRequest = actualDecodeResult.getToDeviceRequest();
    Descriptors.Descriptor descriptorForType10 = toDeviceRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.ToServerRpcResponseMsg toServerResponse = actualDecodeResult.getToServerResponse();
    Descriptors.Descriptor descriptorForType11 = toServerResponse.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    TransportProtos.ToTransportUpdateCredentialsProto toTransportUpdateCredentialsNotification = actualDecodeResult
        .getToTransportUpdateCredentialsNotification();
    Descriptors.Descriptor descriptorForType12 = toTransportUpdateCredentialsNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = actualDecodeResult.getUplinkNotificationMsg();
    Descriptors.Descriptor descriptorForType13 = uplinkNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType13.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(14);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(15);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertSame(options, toProtoResult.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    assertSame(options, descriptorForType12.getOptions());
    assertSame(options, descriptorForType13.getOptions());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    TransportProtos.ToTransportMsg defaultInstanceForType = actualDecodeResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualDecodeResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiUsageState = entityUpdateMsg.getApiUsageState();
    assertSame(unknownFields, apiUsageState.getUnknownFields());
    TransportProtos.DeviceProto device = entityUpdateMsg.getDevice();
    assertSame(unknownFields, device.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityUpdateMsg.getDeviceProfile();
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    TransportProtos.TenantProto tenant = entityUpdateMsg.getTenant();
    assertSame(unknownFields, tenant.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityUpdateMsg.getTenantProfile();
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    assertSame(unknownFields, attributeUpdateNotification.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, entityDeleteMsg.getUnknownFields());
    assertSame(unknownFields, entityUpdateMsg.getUnknownFields());
    assertSame(unknownFields, getAttributesResponse.getUnknownFields());
    assertSame(unknownFields, provisionResponse.getUnknownFields());
    assertSame(unknownFields, resourceDeleteMsg.getUnknownFields());
    assertSame(unknownFields, resourceUpdateMsg.getUnknownFields());
    assertSame(unknownFields, sessionCloseNotification.getUnknownFields());
    assertSame(unknownFields, toDeviceRequest.getUnknownFields());
    assertSame(unknownFields, toServerResponse.getUnknownFields());
    assertSame(unknownFields, toTransportUpdateCredentialsNotification.getUnknownFields());
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList sharedDeletedList = attributeUpdateNotification.getSharedDeletedList();
    assertSame(sharedDeletedList, toProtoResult.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult2.getReservedNameList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsIdList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsValueList());
    ByteString deviceData = device.getDeviceData();
    assertSame(deviceData, deviceProfile.getDeviceProfileData());
    assertSame(deviceData, tenantProfile.getProfileData());
    assertSame(apiUsageState, apiUsageState.getDefaultInstanceForType());
    assertSame(apiUsageState, entityUpdateMsg.getApiUsageStateOrBuilder());
    assertSame(device, device.getDefaultInstanceForType());
    assertSame(device, entityUpdateMsg.getDeviceOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityUpdateMsg.getDeviceProfileOrBuilder());
    assertSame(tenant, entityUpdateMsg.getTenantOrBuilder());
    assertSame(tenant, tenant.getDefaultInstanceForType());
    assertSame(tenantProfile, entityUpdateMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, attributeUpdateNotification.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, defaultInstanceForType.getAttributeUpdateNotification());
    assertSame(attributeUpdateNotification, actualDecodeResult.getAttributeUpdateNotificationOrBuilder());
    assertSame(attributeUpdateNotification, defaultInstanceForType.getAttributeUpdateNotificationOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(entityDeleteMsg, entityDeleteMsg.getDefaultInstanceForType());
    assertSame(entityDeleteMsg, defaultInstanceForType.getEntityDeleteMsg());
    assertSame(entityDeleteMsg, actualDecodeResult.getEntityDeleteMsgOrBuilder());
    assertSame(entityDeleteMsg, defaultInstanceForType.getEntityDeleteMsgOrBuilder());
    assertSame(entityUpdateMsg, entityUpdateMsg.getDefaultInstanceForType());
    assertSame(entityUpdateMsg, defaultInstanceForType.getEntityUpdateMsg());
    assertSame(entityUpdateMsg, actualDecodeResult.getEntityUpdateMsgOrBuilder());
    assertSame(entityUpdateMsg, defaultInstanceForType.getEntityUpdateMsgOrBuilder());
    assertSame(getAttributesResponse, getAttributesResponse.getDefaultInstanceForType());
    assertSame(getAttributesResponse, defaultInstanceForType.getGetAttributesResponse());
    assertSame(getAttributesResponse, actualDecodeResult.getGetAttributesResponseOrBuilder());
    assertSame(getAttributesResponse, defaultInstanceForType.getGetAttributesResponseOrBuilder());
    assertSame(provisionResponse, provisionResponse.getDefaultInstanceForType());
    assertSame(provisionResponse, defaultInstanceForType.getProvisionResponse());
    assertSame(provisionResponse, actualDecodeResult.getProvisionResponseOrBuilder());
    assertSame(provisionResponse, defaultInstanceForType.getProvisionResponseOrBuilder());
    assertSame(resourceDeleteMsg, resourceDeleteMsg.getDefaultInstanceForType());
    assertSame(resourceDeleteMsg, defaultInstanceForType.getResourceDeleteMsg());
    assertSame(resourceDeleteMsg, actualDecodeResult.getResourceDeleteMsgOrBuilder());
    assertSame(resourceDeleteMsg, defaultInstanceForType.getResourceDeleteMsgOrBuilder());
    assertSame(resourceUpdateMsg, resourceUpdateMsg.getDefaultInstanceForType());
    assertSame(resourceUpdateMsg, defaultInstanceForType.getResourceUpdateMsg());
    assertSame(resourceUpdateMsg, actualDecodeResult.getResourceUpdateMsgOrBuilder());
    assertSame(resourceUpdateMsg, defaultInstanceForType.getResourceUpdateMsgOrBuilder());
    assertSame(sessionCloseNotification, sessionCloseNotification.getDefaultInstanceForType());
    assertSame(sessionCloseNotification, defaultInstanceForType.getSessionCloseNotification());
    assertSame(sessionCloseNotification, actualDecodeResult.getSessionCloseNotificationOrBuilder());
    assertSame(sessionCloseNotification, defaultInstanceForType.getSessionCloseNotificationOrBuilder());
    assertSame(toDeviceRequest, toDeviceRequest.getDefaultInstanceForType());
    assertSame(toDeviceRequest, defaultInstanceForType.getToDeviceRequest());
    assertSame(toDeviceRequest, actualDecodeResult.getToDeviceRequestOrBuilder());
    assertSame(toDeviceRequest, defaultInstanceForType.getToDeviceRequestOrBuilder());
    assertSame(toServerResponse, toServerResponse.getDefaultInstanceForType());
    assertSame(toServerResponse, defaultInstanceForType.getToServerResponse());
    assertSame(toServerResponse, actualDecodeResult.getToServerResponseOrBuilder());
    assertSame(toServerResponse, defaultInstanceForType.getToServerResponseOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        defaultInstanceForType.getToTransportUpdateCredentialsNotification());
    assertSame(toTransportUpdateCredentialsNotification,
        actualDecodeResult.getToTransportUpdateCredentialsNotificationOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        defaultInstanceForType.getToTransportUpdateCredentialsNotificationOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        toTransportUpdateCredentialsNotification.getDefaultInstanceForType());
    assertSame(uplinkNotificationMsg, defaultInstanceForType.getUplinkNotificationMsg());
    assertSame(uplinkNotificationMsg, actualDecodeResult.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, defaultInstanceForType.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}.
   * <ul>
   *   <li>When {@link TbProtoQueueMsg#TbProtoQueueMsg(UUID, GeneratedMessageV3)}
   * with key is randomUUID and value is DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg); when TbProtoQueueMsg(UUID, GeneratedMessageV3) with key is randomUUID and value is DefaultInstance")
  void testDecode_whenTbProtoQueueMsgWithKeyIsRandomUUIDAndValueIsDefaultInstance() throws IOException {
    // Arrange
    ToTransportMsgResponseDecoder toTransportMsgResponseDecoder = new ToTransportMsgResponseDecoder();
    UUID key = UUID.randomUUID();

    // Act
    TransportProtos.ToTransportMsg actualDecodeResult = toTransportMsgResponseDecoder
        .decode(new TbProtoQueueMsg<>(key, Advice.getDefaultInstance()));

    // Assert
    assertEquals(actualDecodeResult, actualDecodeResult.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType = actualDecodeResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(Short.SIZE, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.AttributeUpdateNotificationMsg attributeUpdateNotification = actualDecodeResult
        .getAttributeUpdateNotification();
    Descriptors.Descriptor descriptorForType2 = attributeUpdateNotification.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.EntityDeleteMsg entityDeleteMsg = actualDecodeResult.getEntityDeleteMsg();
    Descriptors.Descriptor descriptorForType3 = entityDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EntityUpdateMsg entityUpdateMsg = actualDecodeResult.getEntityUpdateMsg();
    Descriptors.Descriptor descriptorForType4 = entityUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.GetAttributeResponseMsg getAttributesResponse = actualDecodeResult.getGetAttributesResponse();
    Descriptors.Descriptor descriptorForType5 = getAttributesResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionResponse = actualDecodeResult.getProvisionResponse();
    Descriptors.Descriptor descriptorForType6 = provisionResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.ResourceDeleteMsg resourceDeleteMsg = actualDecodeResult.getResourceDeleteMsg();
    Descriptors.Descriptor descriptorForType7 = resourceDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceUpdateMsg resourceUpdateMsg = actualDecodeResult.getResourceUpdateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.SessionCloseNotificationProto sessionCloseNotification = actualDecodeResult
        .getSessionCloseNotification();
    Descriptors.Descriptor descriptorForType9 = sessionCloseNotification.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToDeviceRpcRequestMsg toDeviceRequest = actualDecodeResult.getToDeviceRequest();
    Descriptors.Descriptor descriptorForType10 = toDeviceRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.ToServerRpcResponseMsg toServerResponse = actualDecodeResult.getToServerResponse();
    Descriptors.Descriptor descriptorForType11 = toServerResponse.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    TransportProtos.ToTransportUpdateCredentialsProto toTransportUpdateCredentialsNotification = actualDecodeResult
        .getToTransportUpdateCredentialsNotification();
    Descriptors.Descriptor descriptorForType12 = toTransportUpdateCredentialsNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = actualDecodeResult.getUplinkNotificationMsg();
    Descriptors.Descriptor descriptorForType13 = uplinkNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType13.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(14);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(15);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertSame(options, toProtoResult.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    assertSame(options, descriptorForType12.getOptions());
    assertSame(options, descriptorForType13.getOptions());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    UnknownFieldSet unknownFields = actualDecodeResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiUsageState = entityUpdateMsg.getApiUsageState();
    assertSame(unknownFields, apiUsageState.getUnknownFields());
    TransportProtos.DeviceProto device = entityUpdateMsg.getDevice();
    assertSame(unknownFields, device.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityUpdateMsg.getDeviceProfile();
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    TransportProtos.TenantProto tenant = entityUpdateMsg.getTenant();
    assertSame(unknownFields, tenant.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityUpdateMsg.getTenantProfile();
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    assertSame(unknownFields, attributeUpdateNotification.getUnknownFields());
    assertSame(unknownFields, entityDeleteMsg.getUnknownFields());
    assertSame(unknownFields, entityUpdateMsg.getUnknownFields());
    assertSame(unknownFields, getAttributesResponse.getUnknownFields());
    assertSame(unknownFields, provisionResponse.getUnknownFields());
    assertSame(unknownFields, resourceDeleteMsg.getUnknownFields());
    assertSame(unknownFields, resourceUpdateMsg.getUnknownFields());
    assertSame(unknownFields, sessionCloseNotification.getUnknownFields());
    assertSame(unknownFields, toDeviceRequest.getUnknownFields());
    assertSame(unknownFields, toServerResponse.getUnknownFields());
    assertSame(unknownFields, toTransportUpdateCredentialsNotification.getUnknownFields());
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList sharedDeletedList = attributeUpdateNotification.getSharedDeletedList();
    assertSame(sharedDeletedList, toProtoResult.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult2.getReservedNameList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsIdList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsValueList());
    ByteString deviceData = device.getDeviceData();
    assertSame(deviceData, deviceProfile.getDeviceProfileData());
    assertSame(deviceData, tenantProfile.getProfileData());
    assertSame(apiUsageState, apiUsageState.getDefaultInstanceForType());
    assertSame(apiUsageState, entityUpdateMsg.getApiUsageStateOrBuilder());
    assertSame(device, device.getDefaultInstanceForType());
    assertSame(device, entityUpdateMsg.getDeviceOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityUpdateMsg.getDeviceProfileOrBuilder());
    assertSame(tenant, entityUpdateMsg.getTenantOrBuilder());
    assertSame(tenant, tenant.getDefaultInstanceForType());
    assertSame(tenantProfile, entityUpdateMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, attributeUpdateNotification.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, actualDecodeResult.getAttributeUpdateNotificationOrBuilder());
    assertSame(entityDeleteMsg, entityDeleteMsg.getDefaultInstanceForType());
    assertSame(entityDeleteMsg, actualDecodeResult.getEntityDeleteMsgOrBuilder());
    assertSame(entityUpdateMsg, entityUpdateMsg.getDefaultInstanceForType());
    assertSame(entityUpdateMsg, actualDecodeResult.getEntityUpdateMsgOrBuilder());
    assertSame(getAttributesResponse, getAttributesResponse.getDefaultInstanceForType());
    assertSame(getAttributesResponse, actualDecodeResult.getGetAttributesResponseOrBuilder());
    assertSame(provisionResponse, provisionResponse.getDefaultInstanceForType());
    assertSame(provisionResponse, actualDecodeResult.getProvisionResponseOrBuilder());
    assertSame(resourceDeleteMsg, resourceDeleteMsg.getDefaultInstanceForType());
    assertSame(resourceDeleteMsg, actualDecodeResult.getResourceDeleteMsgOrBuilder());
    assertSame(resourceUpdateMsg, resourceUpdateMsg.getDefaultInstanceForType());
    assertSame(resourceUpdateMsg, actualDecodeResult.getResourceUpdateMsgOrBuilder());
    assertSame(sessionCloseNotification, sessionCloseNotification.getDefaultInstanceForType());
    assertSame(sessionCloseNotification, actualDecodeResult.getSessionCloseNotificationOrBuilder());
    assertSame(toDeviceRequest, toDeviceRequest.getDefaultInstanceForType());
    assertSame(toDeviceRequest, actualDecodeResult.getToDeviceRequestOrBuilder());
    assertSame(toServerResponse, toServerResponse.getDefaultInstanceForType());
    assertSame(toServerResponse, actualDecodeResult.getToServerResponseOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        actualDecodeResult.getToTransportUpdateCredentialsNotificationOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        toTransportUpdateCredentialsNotification.getDefaultInstanceForType());
    assertSame(uplinkNotificationMsg, actualDecodeResult.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}.
   * <ul>
   *   <li>When {@link TbProtoQueueMsg#TbProtoQueueMsg(UUID, GeneratedMessageV3)}
   * with key is randomUUID and value is DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg); when TbProtoQueueMsg(UUID, GeneratedMessageV3) with key is randomUUID and value is DefaultInstance")
  void testDecode_whenTbProtoQueueMsgWithKeyIsRandomUUIDAndValueIsDefaultInstance2() throws IOException {
    // Arrange
    ToTransportMsgResponseDecoder toTransportMsgResponseDecoder = new ToTransportMsgResponseDecoder();
    UUID key = UUID.randomUUID();

    // Act
    TransportProtos.ToTransportMsg actualDecodeResult = toTransportMsgResponseDecoder
        .decode(new TbProtoQueueMsg<>(key, BackendRule.getDefaultInstance()));

    // Assert
    assertEquals(actualDecodeResult, actualDecodeResult.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType = actualDecodeResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(Short.SIZE, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.AttributeUpdateNotificationMsg attributeUpdateNotification = actualDecodeResult
        .getAttributeUpdateNotification();
    Descriptors.Descriptor descriptorForType2 = attributeUpdateNotification.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.EntityDeleteMsg entityDeleteMsg = actualDecodeResult.getEntityDeleteMsg();
    Descriptors.Descriptor descriptorForType3 = entityDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EntityUpdateMsg entityUpdateMsg = actualDecodeResult.getEntityUpdateMsg();
    Descriptors.Descriptor descriptorForType4 = entityUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.GetAttributeResponseMsg getAttributesResponse = actualDecodeResult.getGetAttributesResponse();
    Descriptors.Descriptor descriptorForType5 = getAttributesResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionResponse = actualDecodeResult.getProvisionResponse();
    Descriptors.Descriptor descriptorForType6 = provisionResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.ResourceDeleteMsg resourceDeleteMsg = actualDecodeResult.getResourceDeleteMsg();
    Descriptors.Descriptor descriptorForType7 = resourceDeleteMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceUpdateMsg resourceUpdateMsg = actualDecodeResult.getResourceUpdateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceUpdateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.SessionCloseNotificationProto sessionCloseNotification = actualDecodeResult
        .getSessionCloseNotification();
    Descriptors.Descriptor descriptorForType9 = sessionCloseNotification.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToDeviceRpcRequestMsg toDeviceRequest = actualDecodeResult.getToDeviceRequest();
    Descriptors.Descriptor descriptorForType10 = toDeviceRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.ToServerRpcResponseMsg toServerResponse = actualDecodeResult.getToServerResponse();
    Descriptors.Descriptor descriptorForType11 = toServerResponse.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    TransportProtos.ToTransportUpdateCredentialsProto toTransportUpdateCredentialsNotification = actualDecodeResult
        .getToTransportUpdateCredentialsNotification();
    Descriptors.Descriptor descriptorForType12 = toTransportUpdateCredentialsNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = actualDecodeResult.getUplinkNotificationMsg();
    Descriptors.Descriptor descriptorForType13 = uplinkNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType13.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(14);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(15);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertSame(options, toProtoResult.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    assertSame(options, descriptorForType12.getOptions());
    assertSame(options, descriptorForType13.getOptions());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    UnknownFieldSet unknownFields = actualDecodeResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiUsageState = entityUpdateMsg.getApiUsageState();
    assertSame(unknownFields, apiUsageState.getUnknownFields());
    TransportProtos.DeviceProto device = entityUpdateMsg.getDevice();
    assertSame(unknownFields, device.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityUpdateMsg.getDeviceProfile();
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    TransportProtos.TenantProto tenant = entityUpdateMsg.getTenant();
    assertSame(unknownFields, tenant.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityUpdateMsg.getTenantProfile();
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    assertSame(unknownFields, attributeUpdateNotification.getUnknownFields());
    assertSame(unknownFields, entityDeleteMsg.getUnknownFields());
    assertSame(unknownFields, entityUpdateMsg.getUnknownFields());
    assertSame(unknownFields, getAttributesResponse.getUnknownFields());
    assertSame(unknownFields, provisionResponse.getUnknownFields());
    assertSame(unknownFields, resourceDeleteMsg.getUnknownFields());
    assertSame(unknownFields, resourceUpdateMsg.getUnknownFields());
    assertSame(unknownFields, sessionCloseNotification.getUnknownFields());
    assertSame(unknownFields, toDeviceRequest.getUnknownFields());
    assertSame(unknownFields, toServerResponse.getUnknownFields());
    assertSame(unknownFields, toTransportUpdateCredentialsNotification.getUnknownFields());
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList sharedDeletedList = attributeUpdateNotification.getSharedDeletedList();
    assertSame(sharedDeletedList, toProtoResult.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult2.getReservedNameList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsIdList());
    assertSame(sharedDeletedList, toTransportUpdateCredentialsNotification.getCredentialsValueList());
    ByteString deviceData = device.getDeviceData();
    assertSame(deviceData, deviceProfile.getDeviceProfileData());
    assertSame(deviceData, tenantProfile.getProfileData());
    assertSame(apiUsageState, apiUsageState.getDefaultInstanceForType());
    assertSame(apiUsageState, entityUpdateMsg.getApiUsageStateOrBuilder());
    assertSame(device, device.getDefaultInstanceForType());
    assertSame(device, entityUpdateMsg.getDeviceOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityUpdateMsg.getDeviceProfileOrBuilder());
    assertSame(tenant, entityUpdateMsg.getTenantOrBuilder());
    assertSame(tenant, tenant.getDefaultInstanceForType());
    assertSame(tenantProfile, entityUpdateMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, attributeUpdateNotification.getDefaultInstanceForType());
    assertSame(attributeUpdateNotification, actualDecodeResult.getAttributeUpdateNotificationOrBuilder());
    assertSame(entityDeleteMsg, entityDeleteMsg.getDefaultInstanceForType());
    assertSame(entityDeleteMsg, actualDecodeResult.getEntityDeleteMsgOrBuilder());
    assertSame(entityUpdateMsg, entityUpdateMsg.getDefaultInstanceForType());
    assertSame(entityUpdateMsg, actualDecodeResult.getEntityUpdateMsgOrBuilder());
    assertSame(getAttributesResponse, getAttributesResponse.getDefaultInstanceForType());
    assertSame(getAttributesResponse, actualDecodeResult.getGetAttributesResponseOrBuilder());
    assertSame(provisionResponse, provisionResponse.getDefaultInstanceForType());
    assertSame(provisionResponse, actualDecodeResult.getProvisionResponseOrBuilder());
    assertSame(resourceDeleteMsg, resourceDeleteMsg.getDefaultInstanceForType());
    assertSame(resourceDeleteMsg, actualDecodeResult.getResourceDeleteMsgOrBuilder());
    assertSame(resourceUpdateMsg, resourceUpdateMsg.getDefaultInstanceForType());
    assertSame(resourceUpdateMsg, actualDecodeResult.getResourceUpdateMsgOrBuilder());
    assertSame(sessionCloseNotification, sessionCloseNotification.getDefaultInstanceForType());
    assertSame(sessionCloseNotification, actualDecodeResult.getSessionCloseNotificationOrBuilder());
    assertSame(toDeviceRequest, toDeviceRequest.getDefaultInstanceForType());
    assertSame(toDeviceRequest, actualDecodeResult.getToDeviceRequestOrBuilder());
    assertSame(toServerResponse, toServerResponse.getDefaultInstanceForType());
    assertSame(toServerResponse, actualDecodeResult.getToServerResponseOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        actualDecodeResult.getToTransportUpdateCredentialsNotificationOrBuilder());
    assertSame(toTransportUpdateCredentialsNotification,
        toTransportUpdateCredentialsNotification.getDefaultInstanceForType());
    assertSame(uplinkNotificationMsg, actualDecodeResult.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }
}
