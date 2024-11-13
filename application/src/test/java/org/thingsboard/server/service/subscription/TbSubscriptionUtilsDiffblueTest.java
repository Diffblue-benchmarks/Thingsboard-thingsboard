package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.kv.AggTsKvEntry;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.service.ws.notification.sub.NotificationRequestUpdate;
import org.thingsboard.server.service.ws.notification.sub.NotificationUpdate;
import org.thingsboard.server.service.ws.notification.sub.NotificationsSubscriptionUpdate;

class TbSubscriptionUtilsDiffblueTest {
  /**
   * Test {@link TbSubscriptionUtils#toSubEventProto(String, TbEntitySubEvent)}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toSubEventProto(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test toSubEventProto(String, TbEntitySubEvent)")
  void testToSubEventProto() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    TransportProtos.ToCoreMsg actualToSubEventProtoResult = TbSubscriptionUtils.toSubEventProto("42",
        new TbEntitySubEvent(new TenantId(UUID.randomUUID()), entityId, ComponentLifecycleEvent.CREATED, null, 10));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualToSubEventProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualToSubEventProtoResult.getToDeviceActorMsg();
    TransportProtos.GetAttributeRequestMsg getAttributes = toDeviceActorMsg.getGetAttributes();
    assertSame(reservedNameList, getAttributes.getClientAttributeNamesList());
    assertSame(reservedNameList, getAttributes.getSharedAttributeNamesList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options.getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualToSubEventProtoResult
        .getToDeviceActorNotification();
    TransportProtos.DeviceAttributesEventMsgProto deviceAttributesEventMsg = toDeviceActorNotification
        .getDeviceAttributesEventMsg();
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysOrBuilderList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesOrBuilderList());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualToSubEventProtoResult.getEdgeNotificationMsg();
    TransportProtos.PostAttributeMsg postAttributesMsg = edgeNotificationMsg.getPostAttributesMsg();
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvList());
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvOrBuilderList());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = edgeNotificationMsg.getPostTelemetryMsg();
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListList());
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.DeviceActivityProto deviceActivityMsg = actualToSubEventProtoResult.getDeviceActivityMsg();
    Descriptors.Descriptor descriptorForType2 = deviceActivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.DeviceConnectProto deviceConnectMsg = actualToSubEventProtoResult.getDeviceConnectMsg();
    Descriptors.Descriptor descriptorForType3 = deviceConnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.DeviceDisconnectProto deviceDisconnectMsg = actualToSubEventProtoResult.getDeviceDisconnectMsg();
    Descriptors.Descriptor descriptorForType4 = deviceDisconnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.DeviceInactivityProto deviceInactivityMsg = actualToSubEventProtoResult.getDeviceInactivityMsg();
    Descriptors.Descriptor descriptorForType5 = deviceInactivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.DeviceStateServiceMsgProto deviceStateServiceMsg = actualToSubEventProtoResult
        .getDeviceStateServiceMsg();
    Descriptors.Descriptor descriptorForType6 = deviceStateServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ErrorEventProto errorEventMsg = actualToSubEventProtoResult.getErrorEventMsg();
    Descriptors.Descriptor descriptorForType8 = errorEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.LifecycleEventProto lifecycleEventMsg = actualToSubEventProtoResult.getLifecycleEventMsg();
    Descriptors.Descriptor descriptorForType9 = lifecycleEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.NotificationSchedulerServiceMsg notificationSchedulerServiceMsg = actualToSubEventProtoResult
        .getNotificationSchedulerServiceMsg();
    Descriptors.Descriptor descriptorForType10 = notificationSchedulerServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreMsg defaultInstanceForType = actualToSubEventProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToSubEventProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, postAttributesMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceActivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceConnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceDisconnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceInactivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceStateServiceMsg.getUnknownFields());
    assertSame(unknownFields, edgeNotificationMsg.getUnknownFields());
    assertSame(unknownFields, errorEventMsg.getUnknownFields());
    assertSame(unknownFields, lifecycleEventMsg.getUnknownFields());
    assertSame(unknownFields, notificationSchedulerServiceMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorNotification.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = actualToSubEventProtoResult
        .getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, deviceAttributesEventMsg.getUnknownFields());
    TransportProtos.DeviceCredentialsUpdateMsgProto deviceCredentialsUpdateMsg = toDeviceActorNotification
        .getDeviceCredentialsUpdateMsg();
    assertSame(unknownFields, deviceCredentialsUpdateMsg.getUnknownFields());
    TransportProtos.ClaimDeviceMsg claimDevice = toDeviceActorMsg.getClaimDevice();
    assertSame(unknownFields, claimDevice.getUnknownFields());
    assertSame(unknownFields, getAttributes.getUnknownFields());
    TransportProtos.ProvisionDeviceRequestMsg provisionDevice = toDeviceActorMsg.getProvisionDevice();
    assertSame(unknownFields, provisionDevice.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseStatusMsg rpcResponseStatusMsg = toDeviceActorMsg.getRpcResponseStatusMsg();
    assertSame(unknownFields, rpcResponseStatusMsg.getUnknownFields());
    TransportProtos.SendPendingRPCMsg sendPendingRPC = toDeviceActorMsg.getSendPendingRPC();
    assertSame(unknownFields, sendPendingRPC.getUnknownFields());
    TransportProtos.SessionEventMsg sessionEvent = toDeviceActorMsg.getSessionEvent();
    assertSame(unknownFields, sessionEvent.getUnknownFields());
    TransportProtos.SessionInfoProto sessionInfo = toDeviceActorMsg.getSessionInfo();
    assertSame(unknownFields, sessionInfo.getUnknownFields());
    TransportProtos.SubscribeToAttributeUpdatesMsg subscribeToAttributes = toDeviceActorMsg.getSubscribeToAttributes();
    assertSame(unknownFields, subscribeToAttributes.getUnknownFields());
    TransportProtos.SubscribeToRPCMsg subscribeToRPC = toDeviceActorMsg.getSubscribeToRPC();
    assertSame(unknownFields, subscribeToRPC.getUnknownFields());
    TransportProtos.SubscriptionInfoProto subscriptionInfo = toDeviceActorMsg.getSubscriptionInfo();
    assertSame(unknownFields, subscriptionInfo.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseMsg toDeviceRPCCallResponse = toDeviceActorMsg.getToDeviceRPCCallResponse();
    assertSame(unknownFields, toDeviceRPCCallResponse.getUnknownFields());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = toDeviceActorMsg.getUplinkNotificationMsg();
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(postAttributesMsg, edgeNotificationMsg.getPostAttributesMsgOrBuilder());
    assertSame(postAttributesMsg, postAttributesMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, edgeNotificationMsg.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, deviceActivityMsg.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsg());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsgOrBuilder());
    assertSame(deviceActivityMsg, actualToSubEventProtoResult.getDeviceActivityMsgOrBuilder());
    assertSame(deviceConnectMsg, deviceConnectMsg.getDefaultInstanceForType());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsg());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsgOrBuilder());
    assertSame(deviceConnectMsg, actualToSubEventProtoResult.getDeviceConnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, deviceDisconnectMsg.getDefaultInstanceForType());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsg());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, actualToSubEventProtoResult.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceInactivityMsg, deviceInactivityMsg.getDefaultInstanceForType());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsg());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceInactivityMsg, actualToSubEventProtoResult.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceStateServiceMsg, deviceStateServiceMsg.getDefaultInstanceForType());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsg());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsgOrBuilder());
    assertSame(deviceStateServiceMsg, actualToSubEventProtoResult.getDeviceStateServiceMsgOrBuilder());
    assertSame(edgeNotificationMsg, edgeNotificationMsg.getDefaultInstanceForType());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsg());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsgOrBuilder());
    assertSame(edgeNotificationMsg, actualToSubEventProtoResult.getEdgeNotificationMsgOrBuilder());
    assertSame(errorEventMsg, errorEventMsg.getDefaultInstanceForType());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsg());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsgOrBuilder());
    assertSame(errorEventMsg, actualToSubEventProtoResult.getErrorEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, lifecycleEventMsg.getDefaultInstanceForType());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsg());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, actualToSubEventProtoResult.getLifecycleEventMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg, notificationSchedulerServiceMsg.getDefaultInstanceForType());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsg());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg,
        actualToSubEventProtoResult.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsg());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, actualToSubEventProtoResult.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, toDeviceActorMsg.getDefaultInstanceForType());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotification());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, actualToSubEventProtoResult.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, toDeviceActorNotification.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, actualToSubEventProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(deviceAttributesEventMsg, deviceAttributesEventMsg.getDefaultInstanceForType());
    assertSame(deviceAttributesEventMsg, toDeviceActorNotification.getDeviceAttributesEventMsgOrBuilder());
    assertSame(deviceCredentialsUpdateMsg, deviceCredentialsUpdateMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsUpdateMsg, toDeviceActorNotification.getDeviceCredentialsUpdateMsgOrBuilder());
    TransportProtos.DeviceDeleteMsgProto deviceDeleteMsg = toDeviceActorNotification.getDeviceDeleteMsg();
    assertSame(deviceDeleteMsg, deviceDeleteMsg.getDefaultInstanceForType());
    assertSame(deviceDeleteMsg, toDeviceActorNotification.getDeviceDeleteMsgOrBuilder());
    assertSame(claimDevice, claimDevice.getDefaultInstanceForType());
    assertSame(claimDevice, toDeviceActorMsg.getClaimDeviceOrBuilder());
    assertSame(getAttributes, getAttributes.getDefaultInstanceForType());
    assertSame(getAttributes, toDeviceActorMsg.getGetAttributesOrBuilder());
    assertSame(provisionDevice, provisionDevice.getDefaultInstanceForType());
    assertSame(provisionDevice, toDeviceActorMsg.getProvisionDeviceOrBuilder());
    assertSame(rpcResponseStatusMsg, rpcResponseStatusMsg.getDefaultInstanceForType());
    assertSame(rpcResponseStatusMsg, toDeviceActorMsg.getRpcResponseStatusMsgOrBuilder());
    assertSame(sendPendingRPC, sendPendingRPC.getDefaultInstanceForType());
    assertSame(sendPendingRPC, toDeviceActorMsg.getSendPendingRPCOrBuilder());
    assertSame(sessionEvent, sessionEvent.getDefaultInstanceForType());
    assertSame(sessionEvent, toDeviceActorMsg.getSessionEventOrBuilder());
    assertSame(sessionInfo, sessionInfo.getDefaultInstanceForType());
    assertSame(sessionInfo, toDeviceActorMsg.getSessionInfoOrBuilder());
    assertSame(subscribeToAttributes, subscribeToAttributes.getDefaultInstanceForType());
    assertSame(subscribeToAttributes, toDeviceActorMsg.getSubscribeToAttributesOrBuilder());
    assertSame(subscribeToRPC, subscribeToRPC.getDefaultInstanceForType());
    assertSame(subscribeToRPC, toDeviceActorMsg.getSubscribeToRPCOrBuilder());
    assertSame(subscriptionInfo, subscriptionInfo.getDefaultInstanceForType());
    assertSame(subscriptionInfo, toDeviceActorMsg.getSubscriptionInfoOrBuilder());
    assertSame(toDeviceRPCCallResponse, toDeviceRPCCallResponse.getDefaultInstanceForType());
    assertSame(toDeviceRPCCallResponse, toDeviceActorMsg.getToDeviceRPCCallResponseOrBuilder());
    assertSame(uplinkNotificationMsg, toDeviceActorMsg.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link TbSubscriptionUtils#toSubEventProto(String, TbEntitySubEvent)}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toSubEventProto(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test toSubEventProto(String, TbEntitySubEvent)")
  void testToSubEventProto2() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    HashSet<String> tsKeys = new HashSet<>();

    // Act
    TransportProtos.ToCoreMsg actualToSubEventProtoResult = TbSubscriptionUtils.toSubEventProto("42",
        new TbEntitySubEvent(tenantId, entityId, ComponentLifecycleEvent.CREATED,
            new TbSubscriptionsInfo(true, true, true, tsKeys, true, new HashSet<>(), 10), 10));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualToSubEventProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualToSubEventProtoResult.getToDeviceActorMsg();
    TransportProtos.GetAttributeRequestMsg getAttributes = toDeviceActorMsg.getGetAttributes();
    assertSame(reservedNameList, getAttributes.getClientAttributeNamesList());
    assertSame(reservedNameList, getAttributes.getSharedAttributeNamesList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options.getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualToSubEventProtoResult
        .getToDeviceActorNotification();
    TransportProtos.DeviceAttributesEventMsgProto deviceAttributesEventMsg = toDeviceActorNotification
        .getDeviceAttributesEventMsg();
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysOrBuilderList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesOrBuilderList());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualToSubEventProtoResult.getEdgeNotificationMsg();
    TransportProtos.PostAttributeMsg postAttributesMsg = edgeNotificationMsg.getPostAttributesMsg();
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvList());
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvOrBuilderList());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = edgeNotificationMsg.getPostTelemetryMsg();
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListList());
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.DeviceActivityProto deviceActivityMsg = actualToSubEventProtoResult.getDeviceActivityMsg();
    Descriptors.Descriptor descriptorForType2 = deviceActivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.DeviceConnectProto deviceConnectMsg = actualToSubEventProtoResult.getDeviceConnectMsg();
    Descriptors.Descriptor descriptorForType3 = deviceConnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.DeviceDisconnectProto deviceDisconnectMsg = actualToSubEventProtoResult.getDeviceDisconnectMsg();
    Descriptors.Descriptor descriptorForType4 = deviceDisconnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.DeviceInactivityProto deviceInactivityMsg = actualToSubEventProtoResult.getDeviceInactivityMsg();
    Descriptors.Descriptor descriptorForType5 = deviceInactivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.DeviceStateServiceMsgProto deviceStateServiceMsg = actualToSubEventProtoResult
        .getDeviceStateServiceMsg();
    Descriptors.Descriptor descriptorForType6 = deviceStateServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ErrorEventProto errorEventMsg = actualToSubEventProtoResult.getErrorEventMsg();
    Descriptors.Descriptor descriptorForType8 = errorEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.LifecycleEventProto lifecycleEventMsg = actualToSubEventProtoResult.getLifecycleEventMsg();
    Descriptors.Descriptor descriptorForType9 = lifecycleEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.NotificationSchedulerServiceMsg notificationSchedulerServiceMsg = actualToSubEventProtoResult
        .getNotificationSchedulerServiceMsg();
    Descriptors.Descriptor descriptorForType10 = notificationSchedulerServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreMsg defaultInstanceForType = actualToSubEventProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToSubEventProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, postAttributesMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceActivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceConnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceDisconnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceInactivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceStateServiceMsg.getUnknownFields());
    assertSame(unknownFields, edgeNotificationMsg.getUnknownFields());
    assertSame(unknownFields, errorEventMsg.getUnknownFields());
    assertSame(unknownFields, lifecycleEventMsg.getUnknownFields());
    assertSame(unknownFields, notificationSchedulerServiceMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorNotification.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = actualToSubEventProtoResult
        .getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, deviceAttributesEventMsg.getUnknownFields());
    TransportProtos.DeviceCredentialsUpdateMsgProto deviceCredentialsUpdateMsg = toDeviceActorNotification
        .getDeviceCredentialsUpdateMsg();
    assertSame(unknownFields, deviceCredentialsUpdateMsg.getUnknownFields());
    TransportProtos.ClaimDeviceMsg claimDevice = toDeviceActorMsg.getClaimDevice();
    assertSame(unknownFields, claimDevice.getUnknownFields());
    assertSame(unknownFields, getAttributes.getUnknownFields());
    TransportProtos.ProvisionDeviceRequestMsg provisionDevice = toDeviceActorMsg.getProvisionDevice();
    assertSame(unknownFields, provisionDevice.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseStatusMsg rpcResponseStatusMsg = toDeviceActorMsg.getRpcResponseStatusMsg();
    assertSame(unknownFields, rpcResponseStatusMsg.getUnknownFields());
    TransportProtos.SendPendingRPCMsg sendPendingRPC = toDeviceActorMsg.getSendPendingRPC();
    assertSame(unknownFields, sendPendingRPC.getUnknownFields());
    TransportProtos.SessionEventMsg sessionEvent = toDeviceActorMsg.getSessionEvent();
    assertSame(unknownFields, sessionEvent.getUnknownFields());
    TransportProtos.SessionInfoProto sessionInfo = toDeviceActorMsg.getSessionInfo();
    assertSame(unknownFields, sessionInfo.getUnknownFields());
    TransportProtos.SubscribeToAttributeUpdatesMsg subscribeToAttributes = toDeviceActorMsg.getSubscribeToAttributes();
    assertSame(unknownFields, subscribeToAttributes.getUnknownFields());
    TransportProtos.SubscribeToRPCMsg subscribeToRPC = toDeviceActorMsg.getSubscribeToRPC();
    assertSame(unknownFields, subscribeToRPC.getUnknownFields());
    TransportProtos.SubscriptionInfoProto subscriptionInfo = toDeviceActorMsg.getSubscriptionInfo();
    assertSame(unknownFields, subscriptionInfo.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseMsg toDeviceRPCCallResponse = toDeviceActorMsg.getToDeviceRPCCallResponse();
    assertSame(unknownFields, toDeviceRPCCallResponse.getUnknownFields());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = toDeviceActorMsg.getUplinkNotificationMsg();
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(postAttributesMsg, edgeNotificationMsg.getPostAttributesMsgOrBuilder());
    assertSame(postAttributesMsg, postAttributesMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, edgeNotificationMsg.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, deviceActivityMsg.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsg());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsgOrBuilder());
    assertSame(deviceActivityMsg, actualToSubEventProtoResult.getDeviceActivityMsgOrBuilder());
    assertSame(deviceConnectMsg, deviceConnectMsg.getDefaultInstanceForType());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsg());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsgOrBuilder());
    assertSame(deviceConnectMsg, actualToSubEventProtoResult.getDeviceConnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, deviceDisconnectMsg.getDefaultInstanceForType());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsg());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, actualToSubEventProtoResult.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceInactivityMsg, deviceInactivityMsg.getDefaultInstanceForType());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsg());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceInactivityMsg, actualToSubEventProtoResult.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceStateServiceMsg, deviceStateServiceMsg.getDefaultInstanceForType());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsg());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsgOrBuilder());
    assertSame(deviceStateServiceMsg, actualToSubEventProtoResult.getDeviceStateServiceMsgOrBuilder());
    assertSame(edgeNotificationMsg, edgeNotificationMsg.getDefaultInstanceForType());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsg());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsgOrBuilder());
    assertSame(edgeNotificationMsg, actualToSubEventProtoResult.getEdgeNotificationMsgOrBuilder());
    assertSame(errorEventMsg, errorEventMsg.getDefaultInstanceForType());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsg());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsgOrBuilder());
    assertSame(errorEventMsg, actualToSubEventProtoResult.getErrorEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, lifecycleEventMsg.getDefaultInstanceForType());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsg());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, actualToSubEventProtoResult.getLifecycleEventMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg, notificationSchedulerServiceMsg.getDefaultInstanceForType());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsg());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg,
        actualToSubEventProtoResult.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsg());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, actualToSubEventProtoResult.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, toDeviceActorMsg.getDefaultInstanceForType());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotification());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, actualToSubEventProtoResult.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, toDeviceActorNotification.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, actualToSubEventProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(deviceAttributesEventMsg, deviceAttributesEventMsg.getDefaultInstanceForType());
    assertSame(deviceAttributesEventMsg, toDeviceActorNotification.getDeviceAttributesEventMsgOrBuilder());
    assertSame(deviceCredentialsUpdateMsg, deviceCredentialsUpdateMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsUpdateMsg, toDeviceActorNotification.getDeviceCredentialsUpdateMsgOrBuilder());
    TransportProtos.DeviceDeleteMsgProto deviceDeleteMsg = toDeviceActorNotification.getDeviceDeleteMsg();
    assertSame(deviceDeleteMsg, deviceDeleteMsg.getDefaultInstanceForType());
    assertSame(deviceDeleteMsg, toDeviceActorNotification.getDeviceDeleteMsgOrBuilder());
    assertSame(claimDevice, claimDevice.getDefaultInstanceForType());
    assertSame(claimDevice, toDeviceActorMsg.getClaimDeviceOrBuilder());
    assertSame(getAttributes, getAttributes.getDefaultInstanceForType());
    assertSame(getAttributes, toDeviceActorMsg.getGetAttributesOrBuilder());
    assertSame(provisionDevice, provisionDevice.getDefaultInstanceForType());
    assertSame(provisionDevice, toDeviceActorMsg.getProvisionDeviceOrBuilder());
    assertSame(rpcResponseStatusMsg, rpcResponseStatusMsg.getDefaultInstanceForType());
    assertSame(rpcResponseStatusMsg, toDeviceActorMsg.getRpcResponseStatusMsgOrBuilder());
    assertSame(sendPendingRPC, sendPendingRPC.getDefaultInstanceForType());
    assertSame(sendPendingRPC, toDeviceActorMsg.getSendPendingRPCOrBuilder());
    assertSame(sessionEvent, sessionEvent.getDefaultInstanceForType());
    assertSame(sessionEvent, toDeviceActorMsg.getSessionEventOrBuilder());
    assertSame(sessionInfo, sessionInfo.getDefaultInstanceForType());
    assertSame(sessionInfo, toDeviceActorMsg.getSessionInfoOrBuilder());
    assertSame(subscribeToAttributes, subscribeToAttributes.getDefaultInstanceForType());
    assertSame(subscribeToAttributes, toDeviceActorMsg.getSubscribeToAttributesOrBuilder());
    assertSame(subscribeToRPC, subscribeToRPC.getDefaultInstanceForType());
    assertSame(subscribeToRPC, toDeviceActorMsg.getSubscribeToRPCOrBuilder());
    assertSame(subscriptionInfo, subscriptionInfo.getDefaultInstanceForType());
    assertSame(subscriptionInfo, toDeviceActorMsg.getSubscriptionInfoOrBuilder());
    assertSame(toDeviceRPCCallResponse, toDeviceRPCCallResponse.getDefaultInstanceForType());
    assertSame(toDeviceRPCCallResponse, toDeviceActorMsg.getToDeviceRPCCallResponseOrBuilder());
    assertSame(uplinkNotificationMsg, toDeviceActorMsg.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link TbSubscriptionUtils#toSubEventProto(String, TbEntitySubEvent)}.
   * <ul>
   *   <li>Given {@link TbSubscriptionsInfo#TbSubscriptionsInfo()}.</li>
   *   <li>Then calls {@link TbEntitySubEvent#getEntityId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toSubEventProto(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test toSubEventProto(String, TbEntitySubEvent); given TbSubscriptionsInfo(); then calls getEntityId()")
  void testToSubEventProto_givenTbSubscriptionsInfo_thenCallsGetEntityId() {
    // Arrange
    TbEntitySubEvent event = mock(TbEntitySubEvent.class);
    when(event.getInfo()).thenReturn(new TbSubscriptionsInfo());
    when(event.getType()).thenReturn(ComponentLifecycleEvent.CREATED);
    when(event.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(event.getSeqNumber()).thenReturn(10);
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    TransportProtos.ToCoreMsg actualToSubEventProtoResult = TbSubscriptionUtils.toSubEventProto("42", event);

    // Assert
    verify(event, atLeast(1)).getEntityId();
    verify(event).getInfo();
    verify(event).getSeqNumber();
    verify(event, atLeast(1)).getTenantId();
    verify(event).getType();
    Descriptors.Descriptor descriptorForType = actualToSubEventProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualToSubEventProtoResult.getToDeviceActorMsg();
    TransportProtos.GetAttributeRequestMsg getAttributes = toDeviceActorMsg.getGetAttributes();
    assertSame(reservedNameList, getAttributes.getClientAttributeNamesList());
    assertSame(reservedNameList, getAttributes.getSharedAttributeNamesList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options.getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualToSubEventProtoResult
        .getToDeviceActorNotification();
    TransportProtos.DeviceAttributesEventMsgProto deviceAttributesEventMsg = toDeviceActorNotification
        .getDeviceAttributesEventMsg();
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysOrBuilderList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesOrBuilderList());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualToSubEventProtoResult.getEdgeNotificationMsg();
    TransportProtos.PostAttributeMsg postAttributesMsg = edgeNotificationMsg.getPostAttributesMsg();
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvList());
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvOrBuilderList());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = edgeNotificationMsg.getPostTelemetryMsg();
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListList());
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.DeviceActivityProto deviceActivityMsg = actualToSubEventProtoResult.getDeviceActivityMsg();
    Descriptors.Descriptor descriptorForType2 = deviceActivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.DeviceConnectProto deviceConnectMsg = actualToSubEventProtoResult.getDeviceConnectMsg();
    Descriptors.Descriptor descriptorForType3 = deviceConnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.DeviceDisconnectProto deviceDisconnectMsg = actualToSubEventProtoResult.getDeviceDisconnectMsg();
    Descriptors.Descriptor descriptorForType4 = deviceDisconnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.DeviceInactivityProto deviceInactivityMsg = actualToSubEventProtoResult.getDeviceInactivityMsg();
    Descriptors.Descriptor descriptorForType5 = deviceInactivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.DeviceStateServiceMsgProto deviceStateServiceMsg = actualToSubEventProtoResult
        .getDeviceStateServiceMsg();
    Descriptors.Descriptor descriptorForType6 = deviceStateServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ErrorEventProto errorEventMsg = actualToSubEventProtoResult.getErrorEventMsg();
    Descriptors.Descriptor descriptorForType8 = errorEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.LifecycleEventProto lifecycleEventMsg = actualToSubEventProtoResult.getLifecycleEventMsg();
    Descriptors.Descriptor descriptorForType9 = lifecycleEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.NotificationSchedulerServiceMsg notificationSchedulerServiceMsg = actualToSubEventProtoResult
        .getNotificationSchedulerServiceMsg();
    Descriptors.Descriptor descriptorForType10 = notificationSchedulerServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreMsg defaultInstanceForType = actualToSubEventProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToSubEventProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, postAttributesMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceActivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceConnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceDisconnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceInactivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceStateServiceMsg.getUnknownFields());
    assertSame(unknownFields, edgeNotificationMsg.getUnknownFields());
    assertSame(unknownFields, errorEventMsg.getUnknownFields());
    assertSame(unknownFields, lifecycleEventMsg.getUnknownFields());
    assertSame(unknownFields, notificationSchedulerServiceMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorNotification.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = actualToSubEventProtoResult
        .getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, deviceAttributesEventMsg.getUnknownFields());
    TransportProtos.DeviceCredentialsUpdateMsgProto deviceCredentialsUpdateMsg = toDeviceActorNotification
        .getDeviceCredentialsUpdateMsg();
    assertSame(unknownFields, deviceCredentialsUpdateMsg.getUnknownFields());
    TransportProtos.ClaimDeviceMsg claimDevice = toDeviceActorMsg.getClaimDevice();
    assertSame(unknownFields, claimDevice.getUnknownFields());
    assertSame(unknownFields, getAttributes.getUnknownFields());
    TransportProtos.ProvisionDeviceRequestMsg provisionDevice = toDeviceActorMsg.getProvisionDevice();
    assertSame(unknownFields, provisionDevice.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseStatusMsg rpcResponseStatusMsg = toDeviceActorMsg.getRpcResponseStatusMsg();
    assertSame(unknownFields, rpcResponseStatusMsg.getUnknownFields());
    TransportProtos.SendPendingRPCMsg sendPendingRPC = toDeviceActorMsg.getSendPendingRPC();
    assertSame(unknownFields, sendPendingRPC.getUnknownFields());
    TransportProtos.SessionEventMsg sessionEvent = toDeviceActorMsg.getSessionEvent();
    assertSame(unknownFields, sessionEvent.getUnknownFields());
    TransportProtos.SessionInfoProto sessionInfo = toDeviceActorMsg.getSessionInfo();
    assertSame(unknownFields, sessionInfo.getUnknownFields());
    TransportProtos.SubscribeToAttributeUpdatesMsg subscribeToAttributes = toDeviceActorMsg.getSubscribeToAttributes();
    assertSame(unknownFields, subscribeToAttributes.getUnknownFields());
    TransportProtos.SubscribeToRPCMsg subscribeToRPC = toDeviceActorMsg.getSubscribeToRPC();
    assertSame(unknownFields, subscribeToRPC.getUnknownFields());
    TransportProtos.SubscriptionInfoProto subscriptionInfo = toDeviceActorMsg.getSubscriptionInfo();
    assertSame(unknownFields, subscriptionInfo.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseMsg toDeviceRPCCallResponse = toDeviceActorMsg.getToDeviceRPCCallResponse();
    assertSame(unknownFields, toDeviceRPCCallResponse.getUnknownFields());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = toDeviceActorMsg.getUplinkNotificationMsg();
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(postAttributesMsg, edgeNotificationMsg.getPostAttributesMsgOrBuilder());
    assertSame(postAttributesMsg, postAttributesMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, edgeNotificationMsg.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, deviceActivityMsg.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsg());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsgOrBuilder());
    assertSame(deviceActivityMsg, actualToSubEventProtoResult.getDeviceActivityMsgOrBuilder());
    assertSame(deviceConnectMsg, deviceConnectMsg.getDefaultInstanceForType());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsg());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsgOrBuilder());
    assertSame(deviceConnectMsg, actualToSubEventProtoResult.getDeviceConnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, deviceDisconnectMsg.getDefaultInstanceForType());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsg());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, actualToSubEventProtoResult.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceInactivityMsg, deviceInactivityMsg.getDefaultInstanceForType());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsg());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceInactivityMsg, actualToSubEventProtoResult.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceStateServiceMsg, deviceStateServiceMsg.getDefaultInstanceForType());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsg());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsgOrBuilder());
    assertSame(deviceStateServiceMsg, actualToSubEventProtoResult.getDeviceStateServiceMsgOrBuilder());
    assertSame(edgeNotificationMsg, edgeNotificationMsg.getDefaultInstanceForType());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsg());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsgOrBuilder());
    assertSame(edgeNotificationMsg, actualToSubEventProtoResult.getEdgeNotificationMsgOrBuilder());
    assertSame(errorEventMsg, errorEventMsg.getDefaultInstanceForType());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsg());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsgOrBuilder());
    assertSame(errorEventMsg, actualToSubEventProtoResult.getErrorEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, lifecycleEventMsg.getDefaultInstanceForType());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsg());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, actualToSubEventProtoResult.getLifecycleEventMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg, notificationSchedulerServiceMsg.getDefaultInstanceForType());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsg());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg,
        actualToSubEventProtoResult.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsg());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, actualToSubEventProtoResult.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, toDeviceActorMsg.getDefaultInstanceForType());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotification());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, actualToSubEventProtoResult.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, toDeviceActorNotification.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, actualToSubEventProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(deviceAttributesEventMsg, deviceAttributesEventMsg.getDefaultInstanceForType());
    assertSame(deviceAttributesEventMsg, toDeviceActorNotification.getDeviceAttributesEventMsgOrBuilder());
    assertSame(deviceCredentialsUpdateMsg, deviceCredentialsUpdateMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsUpdateMsg, toDeviceActorNotification.getDeviceCredentialsUpdateMsgOrBuilder());
    TransportProtos.DeviceDeleteMsgProto deviceDeleteMsg = toDeviceActorNotification.getDeviceDeleteMsg();
    assertSame(deviceDeleteMsg, deviceDeleteMsg.getDefaultInstanceForType());
    assertSame(deviceDeleteMsg, toDeviceActorNotification.getDeviceDeleteMsgOrBuilder());
    assertSame(claimDevice, claimDevice.getDefaultInstanceForType());
    assertSame(claimDevice, toDeviceActorMsg.getClaimDeviceOrBuilder());
    assertSame(getAttributes, getAttributes.getDefaultInstanceForType());
    assertSame(getAttributes, toDeviceActorMsg.getGetAttributesOrBuilder());
    assertSame(provisionDevice, provisionDevice.getDefaultInstanceForType());
    assertSame(provisionDevice, toDeviceActorMsg.getProvisionDeviceOrBuilder());
    assertSame(rpcResponseStatusMsg, rpcResponseStatusMsg.getDefaultInstanceForType());
    assertSame(rpcResponseStatusMsg, toDeviceActorMsg.getRpcResponseStatusMsgOrBuilder());
    assertSame(sendPendingRPC, sendPendingRPC.getDefaultInstanceForType());
    assertSame(sendPendingRPC, toDeviceActorMsg.getSendPendingRPCOrBuilder());
    assertSame(sessionEvent, sessionEvent.getDefaultInstanceForType());
    assertSame(sessionEvent, toDeviceActorMsg.getSessionEventOrBuilder());
    assertSame(sessionInfo, sessionInfo.getDefaultInstanceForType());
    assertSame(sessionInfo, toDeviceActorMsg.getSessionInfoOrBuilder());
    assertSame(subscribeToAttributes, subscribeToAttributes.getDefaultInstanceForType());
    assertSame(subscribeToAttributes, toDeviceActorMsg.getSubscribeToAttributesOrBuilder());
    assertSame(subscribeToRPC, subscribeToRPC.getDefaultInstanceForType());
    assertSame(subscribeToRPC, toDeviceActorMsg.getSubscribeToRPCOrBuilder());
    assertSame(subscriptionInfo, subscriptionInfo.getDefaultInstanceForType());
    assertSame(subscriptionInfo, toDeviceActorMsg.getSubscriptionInfoOrBuilder());
    assertSame(toDeviceRPCCallResponse, toDeviceRPCCallResponse.getDefaultInstanceForType());
    assertSame(toDeviceRPCCallResponse, toDeviceActorMsg.getToDeviceRPCCallResponseOrBuilder());
    assertSame(uplinkNotificationMsg, toDeviceActorMsg.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link TbSubscriptionUtils#toSubEventProto(String, TbEntitySubEvent)}.
   * <ul>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toSubEventProto(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test toSubEventProto(String, TbEntitySubEvent); then calls getEntityType()")
  void testToSubEventProto_thenCallsGetEntityType() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TransportProtos.ToCoreMsg actualToSubEventProtoResult = TbSubscriptionUtils.toSubEventProto("42",
        new TbEntitySubEvent(tenantId, entityId, ComponentLifecycleEvent.CREATED, new TbSubscriptionsInfo(), 10));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualToSubEventProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualToSubEventProtoResult.getToDeviceActorMsg();
    TransportProtos.GetAttributeRequestMsg getAttributes = toDeviceActorMsg.getGetAttributes();
    assertSame(reservedNameList, getAttributes.getClientAttributeNamesList());
    assertSame(reservedNameList, getAttributes.getSharedAttributeNamesList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options.getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualToSubEventProtoResult
        .getToDeviceActorNotification();
    TransportProtos.DeviceAttributesEventMsgProto deviceAttributesEventMsg = toDeviceActorNotification
        .getDeviceAttributesEventMsg();
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysOrBuilderList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesOrBuilderList());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualToSubEventProtoResult.getEdgeNotificationMsg();
    TransportProtos.PostAttributeMsg postAttributesMsg = edgeNotificationMsg.getPostAttributesMsg();
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvList());
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvOrBuilderList());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = edgeNotificationMsg.getPostTelemetryMsg();
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListList());
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.DeviceActivityProto deviceActivityMsg = actualToSubEventProtoResult.getDeviceActivityMsg();
    Descriptors.Descriptor descriptorForType2 = deviceActivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.DeviceConnectProto deviceConnectMsg = actualToSubEventProtoResult.getDeviceConnectMsg();
    Descriptors.Descriptor descriptorForType3 = deviceConnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.DeviceDisconnectProto deviceDisconnectMsg = actualToSubEventProtoResult.getDeviceDisconnectMsg();
    Descriptors.Descriptor descriptorForType4 = deviceDisconnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.DeviceInactivityProto deviceInactivityMsg = actualToSubEventProtoResult.getDeviceInactivityMsg();
    Descriptors.Descriptor descriptorForType5 = deviceInactivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.DeviceStateServiceMsgProto deviceStateServiceMsg = actualToSubEventProtoResult
        .getDeviceStateServiceMsg();
    Descriptors.Descriptor descriptorForType6 = deviceStateServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ErrorEventProto errorEventMsg = actualToSubEventProtoResult.getErrorEventMsg();
    Descriptors.Descriptor descriptorForType8 = errorEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.LifecycleEventProto lifecycleEventMsg = actualToSubEventProtoResult.getLifecycleEventMsg();
    Descriptors.Descriptor descriptorForType9 = lifecycleEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.NotificationSchedulerServiceMsg notificationSchedulerServiceMsg = actualToSubEventProtoResult
        .getNotificationSchedulerServiceMsg();
    Descriptors.Descriptor descriptorForType10 = notificationSchedulerServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreMsg defaultInstanceForType = actualToSubEventProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToSubEventProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, postAttributesMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceActivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceConnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceDisconnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceInactivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceStateServiceMsg.getUnknownFields());
    assertSame(unknownFields, edgeNotificationMsg.getUnknownFields());
    assertSame(unknownFields, errorEventMsg.getUnknownFields());
    assertSame(unknownFields, lifecycleEventMsg.getUnknownFields());
    assertSame(unknownFields, notificationSchedulerServiceMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorNotification.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = actualToSubEventProtoResult
        .getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, deviceAttributesEventMsg.getUnknownFields());
    TransportProtos.DeviceCredentialsUpdateMsgProto deviceCredentialsUpdateMsg = toDeviceActorNotification
        .getDeviceCredentialsUpdateMsg();
    assertSame(unknownFields, deviceCredentialsUpdateMsg.getUnknownFields());
    TransportProtos.ClaimDeviceMsg claimDevice = toDeviceActorMsg.getClaimDevice();
    assertSame(unknownFields, claimDevice.getUnknownFields());
    assertSame(unknownFields, getAttributes.getUnknownFields());
    TransportProtos.ProvisionDeviceRequestMsg provisionDevice = toDeviceActorMsg.getProvisionDevice();
    assertSame(unknownFields, provisionDevice.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseStatusMsg rpcResponseStatusMsg = toDeviceActorMsg.getRpcResponseStatusMsg();
    assertSame(unknownFields, rpcResponseStatusMsg.getUnknownFields());
    TransportProtos.SendPendingRPCMsg sendPendingRPC = toDeviceActorMsg.getSendPendingRPC();
    assertSame(unknownFields, sendPendingRPC.getUnknownFields());
    TransportProtos.SessionEventMsg sessionEvent = toDeviceActorMsg.getSessionEvent();
    assertSame(unknownFields, sessionEvent.getUnknownFields());
    TransportProtos.SessionInfoProto sessionInfo = toDeviceActorMsg.getSessionInfo();
    assertSame(unknownFields, sessionInfo.getUnknownFields());
    TransportProtos.SubscribeToAttributeUpdatesMsg subscribeToAttributes = toDeviceActorMsg.getSubscribeToAttributes();
    assertSame(unknownFields, subscribeToAttributes.getUnknownFields());
    TransportProtos.SubscribeToRPCMsg subscribeToRPC = toDeviceActorMsg.getSubscribeToRPC();
    assertSame(unknownFields, subscribeToRPC.getUnknownFields());
    TransportProtos.SubscriptionInfoProto subscriptionInfo = toDeviceActorMsg.getSubscriptionInfo();
    assertSame(unknownFields, subscriptionInfo.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseMsg toDeviceRPCCallResponse = toDeviceActorMsg.getToDeviceRPCCallResponse();
    assertSame(unknownFields, toDeviceRPCCallResponse.getUnknownFields());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = toDeviceActorMsg.getUplinkNotificationMsg();
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(postAttributesMsg, edgeNotificationMsg.getPostAttributesMsgOrBuilder());
    assertSame(postAttributesMsg, postAttributesMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, edgeNotificationMsg.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, deviceActivityMsg.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsg());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsgOrBuilder());
    assertSame(deviceActivityMsg, actualToSubEventProtoResult.getDeviceActivityMsgOrBuilder());
    assertSame(deviceConnectMsg, deviceConnectMsg.getDefaultInstanceForType());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsg());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsgOrBuilder());
    assertSame(deviceConnectMsg, actualToSubEventProtoResult.getDeviceConnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, deviceDisconnectMsg.getDefaultInstanceForType());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsg());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, actualToSubEventProtoResult.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceInactivityMsg, deviceInactivityMsg.getDefaultInstanceForType());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsg());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceInactivityMsg, actualToSubEventProtoResult.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceStateServiceMsg, deviceStateServiceMsg.getDefaultInstanceForType());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsg());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsgOrBuilder());
    assertSame(deviceStateServiceMsg, actualToSubEventProtoResult.getDeviceStateServiceMsgOrBuilder());
    assertSame(edgeNotificationMsg, edgeNotificationMsg.getDefaultInstanceForType());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsg());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsgOrBuilder());
    assertSame(edgeNotificationMsg, actualToSubEventProtoResult.getEdgeNotificationMsgOrBuilder());
    assertSame(errorEventMsg, errorEventMsg.getDefaultInstanceForType());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsg());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsgOrBuilder());
    assertSame(errorEventMsg, actualToSubEventProtoResult.getErrorEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, lifecycleEventMsg.getDefaultInstanceForType());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsg());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, actualToSubEventProtoResult.getLifecycleEventMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg, notificationSchedulerServiceMsg.getDefaultInstanceForType());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsg());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg,
        actualToSubEventProtoResult.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsg());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, actualToSubEventProtoResult.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, toDeviceActorMsg.getDefaultInstanceForType());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotification());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, actualToSubEventProtoResult.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, toDeviceActorNotification.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, actualToSubEventProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(deviceAttributesEventMsg, deviceAttributesEventMsg.getDefaultInstanceForType());
    assertSame(deviceAttributesEventMsg, toDeviceActorNotification.getDeviceAttributesEventMsgOrBuilder());
    assertSame(deviceCredentialsUpdateMsg, deviceCredentialsUpdateMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsUpdateMsg, toDeviceActorNotification.getDeviceCredentialsUpdateMsgOrBuilder());
    TransportProtos.DeviceDeleteMsgProto deviceDeleteMsg = toDeviceActorNotification.getDeviceDeleteMsg();
    assertSame(deviceDeleteMsg, deviceDeleteMsg.getDefaultInstanceForType());
    assertSame(deviceDeleteMsg, toDeviceActorNotification.getDeviceDeleteMsgOrBuilder());
    assertSame(claimDevice, claimDevice.getDefaultInstanceForType());
    assertSame(claimDevice, toDeviceActorMsg.getClaimDeviceOrBuilder());
    assertSame(getAttributes, getAttributes.getDefaultInstanceForType());
    assertSame(getAttributes, toDeviceActorMsg.getGetAttributesOrBuilder());
    assertSame(provisionDevice, provisionDevice.getDefaultInstanceForType());
    assertSame(provisionDevice, toDeviceActorMsg.getProvisionDeviceOrBuilder());
    assertSame(rpcResponseStatusMsg, rpcResponseStatusMsg.getDefaultInstanceForType());
    assertSame(rpcResponseStatusMsg, toDeviceActorMsg.getRpcResponseStatusMsgOrBuilder());
    assertSame(sendPendingRPC, sendPendingRPC.getDefaultInstanceForType());
    assertSame(sendPendingRPC, toDeviceActorMsg.getSendPendingRPCOrBuilder());
    assertSame(sessionEvent, sessionEvent.getDefaultInstanceForType());
    assertSame(sessionEvent, toDeviceActorMsg.getSessionEventOrBuilder());
    assertSame(sessionInfo, sessionInfo.getDefaultInstanceForType());
    assertSame(sessionInfo, toDeviceActorMsg.getSessionInfoOrBuilder());
    assertSame(subscribeToAttributes, subscribeToAttributes.getDefaultInstanceForType());
    assertSame(subscribeToAttributes, toDeviceActorMsg.getSubscribeToAttributesOrBuilder());
    assertSame(subscribeToRPC, subscribeToRPC.getDefaultInstanceForType());
    assertSame(subscribeToRPC, toDeviceActorMsg.getSubscribeToRPCOrBuilder());
    assertSame(subscriptionInfo, subscriptionInfo.getDefaultInstanceForType());
    assertSame(subscriptionInfo, toDeviceActorMsg.getSubscriptionInfoOrBuilder());
    assertSame(toDeviceRPCCallResponse, toDeviceRPCCallResponse.getDefaultInstanceForType());
    assertSame(toDeviceRPCCallResponse, toDeviceActorMsg.getToDeviceRPCCallResponseOrBuilder());
    assertSame(uplinkNotificationMsg, toDeviceActorMsg.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link TbSubscriptionUtils#toSubEventProto(String, TbEntitySubEvent)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toSubEventProto(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test toSubEventProto(String, TbEntitySubEvent); when AlarmId(UUID) with id is randomUUID")
  void testToSubEventProto_whenAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = new AlarmId(UUID.randomUUID());

    // Act
    TransportProtos.ToCoreMsg actualToSubEventProtoResult = TbSubscriptionUtils.toSubEventProto("42",
        new TbEntitySubEvent(tenantId, entityId, ComponentLifecycleEvent.CREATED, new TbSubscriptionsInfo(), 10));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToSubEventProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualToSubEventProtoResult.getToDeviceActorMsg();
    TransportProtos.GetAttributeRequestMsg getAttributes = toDeviceActorMsg.getGetAttributes();
    assertSame(reservedNameList, getAttributes.getClientAttributeNamesList());
    assertSame(reservedNameList, getAttributes.getSharedAttributeNamesList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options.getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualToSubEventProtoResult
        .getToDeviceActorNotification();
    TransportProtos.DeviceAttributesEventMsgProto deviceAttributesEventMsg = toDeviceActorNotification
        .getDeviceAttributesEventMsg();
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysOrBuilderList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesOrBuilderList());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualToSubEventProtoResult.getEdgeNotificationMsg();
    TransportProtos.PostAttributeMsg postAttributesMsg = edgeNotificationMsg.getPostAttributesMsg();
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvList());
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvOrBuilderList());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = edgeNotificationMsg.getPostTelemetryMsg();
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListList());
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.DeviceActivityProto deviceActivityMsg = actualToSubEventProtoResult.getDeviceActivityMsg();
    Descriptors.Descriptor descriptorForType2 = deviceActivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.DeviceConnectProto deviceConnectMsg = actualToSubEventProtoResult.getDeviceConnectMsg();
    Descriptors.Descriptor descriptorForType3 = deviceConnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.DeviceDisconnectProto deviceDisconnectMsg = actualToSubEventProtoResult.getDeviceDisconnectMsg();
    Descriptors.Descriptor descriptorForType4 = deviceDisconnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.DeviceInactivityProto deviceInactivityMsg = actualToSubEventProtoResult.getDeviceInactivityMsg();
    Descriptors.Descriptor descriptorForType5 = deviceInactivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.DeviceStateServiceMsgProto deviceStateServiceMsg = actualToSubEventProtoResult
        .getDeviceStateServiceMsg();
    Descriptors.Descriptor descriptorForType6 = deviceStateServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ErrorEventProto errorEventMsg = actualToSubEventProtoResult.getErrorEventMsg();
    Descriptors.Descriptor descriptorForType8 = errorEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.LifecycleEventProto lifecycleEventMsg = actualToSubEventProtoResult.getLifecycleEventMsg();
    Descriptors.Descriptor descriptorForType9 = lifecycleEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.NotificationSchedulerServiceMsg notificationSchedulerServiceMsg = actualToSubEventProtoResult
        .getNotificationSchedulerServiceMsg();
    Descriptors.Descriptor descriptorForType10 = notificationSchedulerServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreMsg defaultInstanceForType = actualToSubEventProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToSubEventProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, postAttributesMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceActivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceConnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceDisconnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceInactivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceStateServiceMsg.getUnknownFields());
    assertSame(unknownFields, edgeNotificationMsg.getUnknownFields());
    assertSame(unknownFields, errorEventMsg.getUnknownFields());
    assertSame(unknownFields, lifecycleEventMsg.getUnknownFields());
    assertSame(unknownFields, notificationSchedulerServiceMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorNotification.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = actualToSubEventProtoResult
        .getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, deviceAttributesEventMsg.getUnknownFields());
    TransportProtos.DeviceCredentialsUpdateMsgProto deviceCredentialsUpdateMsg = toDeviceActorNotification
        .getDeviceCredentialsUpdateMsg();
    assertSame(unknownFields, deviceCredentialsUpdateMsg.getUnknownFields());
    TransportProtos.ClaimDeviceMsg claimDevice = toDeviceActorMsg.getClaimDevice();
    assertSame(unknownFields, claimDevice.getUnknownFields());
    assertSame(unknownFields, getAttributes.getUnknownFields());
    TransportProtos.ProvisionDeviceRequestMsg provisionDevice = toDeviceActorMsg.getProvisionDevice();
    assertSame(unknownFields, provisionDevice.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseStatusMsg rpcResponseStatusMsg = toDeviceActorMsg.getRpcResponseStatusMsg();
    assertSame(unknownFields, rpcResponseStatusMsg.getUnknownFields());
    TransportProtos.SendPendingRPCMsg sendPendingRPC = toDeviceActorMsg.getSendPendingRPC();
    assertSame(unknownFields, sendPendingRPC.getUnknownFields());
    TransportProtos.SessionEventMsg sessionEvent = toDeviceActorMsg.getSessionEvent();
    assertSame(unknownFields, sessionEvent.getUnknownFields());
    TransportProtos.SessionInfoProto sessionInfo = toDeviceActorMsg.getSessionInfo();
    assertSame(unknownFields, sessionInfo.getUnknownFields());
    TransportProtos.SubscribeToAttributeUpdatesMsg subscribeToAttributes = toDeviceActorMsg.getSubscribeToAttributes();
    assertSame(unknownFields, subscribeToAttributes.getUnknownFields());
    TransportProtos.SubscribeToRPCMsg subscribeToRPC = toDeviceActorMsg.getSubscribeToRPC();
    assertSame(unknownFields, subscribeToRPC.getUnknownFields());
    TransportProtos.SubscriptionInfoProto subscriptionInfo = toDeviceActorMsg.getSubscriptionInfo();
    assertSame(unknownFields, subscriptionInfo.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseMsg toDeviceRPCCallResponse = toDeviceActorMsg.getToDeviceRPCCallResponse();
    assertSame(unknownFields, toDeviceRPCCallResponse.getUnknownFields());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = toDeviceActorMsg.getUplinkNotificationMsg();
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(postAttributesMsg, edgeNotificationMsg.getPostAttributesMsgOrBuilder());
    assertSame(postAttributesMsg, postAttributesMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, edgeNotificationMsg.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, deviceActivityMsg.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsg());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsgOrBuilder());
    assertSame(deviceActivityMsg, actualToSubEventProtoResult.getDeviceActivityMsgOrBuilder());
    assertSame(deviceConnectMsg, deviceConnectMsg.getDefaultInstanceForType());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsg());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsgOrBuilder());
    assertSame(deviceConnectMsg, actualToSubEventProtoResult.getDeviceConnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, deviceDisconnectMsg.getDefaultInstanceForType());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsg());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, actualToSubEventProtoResult.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceInactivityMsg, deviceInactivityMsg.getDefaultInstanceForType());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsg());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceInactivityMsg, actualToSubEventProtoResult.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceStateServiceMsg, deviceStateServiceMsg.getDefaultInstanceForType());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsg());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsgOrBuilder());
    assertSame(deviceStateServiceMsg, actualToSubEventProtoResult.getDeviceStateServiceMsgOrBuilder());
    assertSame(edgeNotificationMsg, edgeNotificationMsg.getDefaultInstanceForType());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsg());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsgOrBuilder());
    assertSame(edgeNotificationMsg, actualToSubEventProtoResult.getEdgeNotificationMsgOrBuilder());
    assertSame(errorEventMsg, errorEventMsg.getDefaultInstanceForType());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsg());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsgOrBuilder());
    assertSame(errorEventMsg, actualToSubEventProtoResult.getErrorEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, lifecycleEventMsg.getDefaultInstanceForType());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsg());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, actualToSubEventProtoResult.getLifecycleEventMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg, notificationSchedulerServiceMsg.getDefaultInstanceForType());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsg());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg,
        actualToSubEventProtoResult.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsg());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, actualToSubEventProtoResult.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, toDeviceActorMsg.getDefaultInstanceForType());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotification());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, actualToSubEventProtoResult.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, toDeviceActorNotification.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, actualToSubEventProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(deviceAttributesEventMsg, deviceAttributesEventMsg.getDefaultInstanceForType());
    assertSame(deviceAttributesEventMsg, toDeviceActorNotification.getDeviceAttributesEventMsgOrBuilder());
    assertSame(deviceCredentialsUpdateMsg, deviceCredentialsUpdateMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsUpdateMsg, toDeviceActorNotification.getDeviceCredentialsUpdateMsgOrBuilder());
    TransportProtos.DeviceDeleteMsgProto deviceDeleteMsg = toDeviceActorNotification.getDeviceDeleteMsg();
    assertSame(deviceDeleteMsg, deviceDeleteMsg.getDefaultInstanceForType());
    assertSame(deviceDeleteMsg, toDeviceActorNotification.getDeviceDeleteMsgOrBuilder());
    assertSame(claimDevice, claimDevice.getDefaultInstanceForType());
    assertSame(claimDevice, toDeviceActorMsg.getClaimDeviceOrBuilder());
    assertSame(getAttributes, getAttributes.getDefaultInstanceForType());
    assertSame(getAttributes, toDeviceActorMsg.getGetAttributesOrBuilder());
    assertSame(provisionDevice, provisionDevice.getDefaultInstanceForType());
    assertSame(provisionDevice, toDeviceActorMsg.getProvisionDeviceOrBuilder());
    assertSame(rpcResponseStatusMsg, rpcResponseStatusMsg.getDefaultInstanceForType());
    assertSame(rpcResponseStatusMsg, toDeviceActorMsg.getRpcResponseStatusMsgOrBuilder());
    assertSame(sendPendingRPC, sendPendingRPC.getDefaultInstanceForType());
    assertSame(sendPendingRPC, toDeviceActorMsg.getSendPendingRPCOrBuilder());
    assertSame(sessionEvent, sessionEvent.getDefaultInstanceForType());
    assertSame(sessionEvent, toDeviceActorMsg.getSessionEventOrBuilder());
    assertSame(sessionInfo, sessionInfo.getDefaultInstanceForType());
    assertSame(sessionInfo, toDeviceActorMsg.getSessionInfoOrBuilder());
    assertSame(subscribeToAttributes, subscribeToAttributes.getDefaultInstanceForType());
    assertSame(subscribeToAttributes, toDeviceActorMsg.getSubscribeToAttributesOrBuilder());
    assertSame(subscribeToRPC, subscribeToRPC.getDefaultInstanceForType());
    assertSame(subscribeToRPC, toDeviceActorMsg.getSubscribeToRPCOrBuilder());
    assertSame(subscriptionInfo, subscriptionInfo.getDefaultInstanceForType());
    assertSame(subscriptionInfo, toDeviceActorMsg.getSubscriptionInfoOrBuilder());
    assertSame(toDeviceRPCCallResponse, toDeviceRPCCallResponse.getDefaultInstanceForType());
    assertSame(toDeviceRPCCallResponse, toDeviceActorMsg.getToDeviceRPCCallResponseOrBuilder());
    assertSame(uplinkNotificationMsg, toDeviceActorMsg.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link TbSubscriptionUtils#toProto(EntityId, List)} with
   * {@code entityId}, {@code updates}.
   * <p>
   * Method under test: {@link TbSubscriptionUtils#toProto(EntityId, List)}
   */
  @Test
  @DisplayName("Test toProto(EntityId, List) with 'entityId', 'updates'")
  void testToProtoWithEntityIdUpdates() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    ArrayList<TsKvEntry> updates = new ArrayList<>();

    // Act
    TransportProtos.ToCoreNotificationMsg actualToProtoResult = TbSubscriptionUtils.toProto(entityId, updates);

    // Assert
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg = actualToProtoResult
        .getToLocalSubscriptionServiceMsg();
    TransportProtos.TbSubUpdateProto tsUpdate = toLocalSubscriptionServiceMsg.getTsUpdate();
    assertEquals(0, tsUpdate.getDataCount());
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    assertEquals(updates, descriptorForType.getOptions().findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals(updates, toProtoResult.findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getAlarmSubUpdate().findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getAlarmUpdate().findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getAttrUpdate().findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getNotificationsSubUpdate().findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getNotificationsUpdate().findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getSubEventCallback().findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getSubUpdate().findInitializationErrors());
    assertEquals(updates, tsUpdate.findInitializationErrors());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = actualToProtoResult.getToSubscriptionMgrMsg();
    assertEquals(updates, toSubscriptionMgrMsg.getAlarmDelete().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getAlarmSub().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getAlarmUpdate().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getAttrDelete().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getAttrUpdate().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getAttributeSub().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getNotificationRequestUpdate().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getNotificationUpdate().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getNotificationsCountSub().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getNotificationsSub().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getSubClose().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getSubEvent().findInitializationErrors());
    assertEquals(updates,
        actualToProtoResult.getDefaultInstanceForType().getToLocalSubscriptionServiceMsg().findInitializationErrors());
    assertEquals(updates, actualToProtoResult.getVcResponseMsg().findInitializationErrors());
    assertEquals(updates, toProtoResult.getReservedNameList());
    Descriptors.Descriptor descriptorForType2 = actualToProtoResult.getComponentLifecycle().getDescriptorForType();
    assertEquals(updates, descriptorForType2.getEnumTypes());
    Descriptors.Descriptor descriptorForType3 = actualToProtoResult.getCoreStartupMsg().getDescriptorForType();
    assertEquals(updates, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = actualToProtoResult.getEdgeEventUpdate().getDescriptorForType();
    assertEquals(updates, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = actualToProtoResult.getFromDeviceRpcResponse().getDescriptorForType();
    assertEquals(updates, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor descriptorForType6 = actualToProtoResult.getFromEdgeSyncResponse().getDescriptorForType();
    assertEquals(updates, descriptorForType6.getEnumTypes());
    Descriptors.Descriptor descriptorForType7 = actualToProtoResult.getNotificationRuleProcessorMsg()
        .getDescriptorForType();
    assertEquals(updates, descriptorForType7.getEnumTypes());
    Descriptors.Descriptor descriptorForType8 = actualToProtoResult.getResourceCacheInvalidateMsg()
        .getDescriptorForType();
    assertEquals(updates, descriptorForType8.getEnumTypes());
    Descriptors.Descriptor descriptorForType9 = actualToProtoResult.getRestApiCallResponseMsg().getDescriptorForType();
    assertEquals(updates, descriptorForType9.getEnumTypes());
    Descriptors.Descriptor descriptorForType10 = actualToProtoResult.getToEdgeSyncRequest().getDescriptorForType();
    assertEquals(updates, descriptorForType10.getEnumTypes());
    Descriptors.Descriptor descriptorForType11 = toLocalSubscriptionServiceMsg.getDescriptorForType();
    assertEquals(updates, descriptorForType11.getEnumTypes());
    Descriptors.Descriptor descriptorForType12 = toSubscriptionMgrMsg.getDescriptorForType();
    assertEquals(updates, descriptorForType12.getEnumTypes());
    assertEquals(updates, descriptorForType2.getExtensions());
    assertEquals(updates, descriptorForType3.getExtensions());
    assertEquals(updates, descriptorForType4.getExtensions());
    assertEquals(updates, descriptorForType5.getExtensions());
    assertEquals(updates, descriptorForType6.getExtensions());
    assertEquals(updates, descriptorForType7.getExtensions());
    assertEquals(updates, descriptorForType8.getExtensions());
    assertEquals(updates, descriptorForType9.getExtensions());
    assertEquals(updates, descriptorForType10.getExtensions());
    assertEquals(updates, descriptorForType11.getExtensions());
    assertEquals(updates, descriptorForType12.getExtensions());
    assertEquals(updates, descriptorForType2.getNestedTypes());
    assertEquals(updates, descriptorForType3.getNestedTypes());
    assertEquals(updates, descriptorForType4.getNestedTypes());
    assertEquals(updates, descriptorForType5.getNestedTypes());
    assertEquals(updates, descriptorForType6.getNestedTypes());
    assertEquals(updates, descriptorForType7.getNestedTypes());
    assertEquals(updates, descriptorForType8.getNestedTypes());
    assertEquals(updates, descriptorForType9.getNestedTypes());
    assertEquals(updates, descriptorForType10.getNestedTypes());
    assertEquals(updates, descriptorForType11.getNestedTypes());
    assertEquals(updates, descriptorForType12.getNestedTypes());
    assertEquals(updates, descriptorForType2.getOneofs());
    assertEquals(updates, descriptorForType3.getOneofs());
    assertEquals(updates, descriptorForType4.getOneofs());
    assertEquals(updates, descriptorForType5.getOneofs());
    assertEquals(updates, descriptorForType6.getOneofs());
    assertEquals(updates, descriptorForType7.getOneofs());
    assertEquals(updates, descriptorForType8.getOneofs());
    assertEquals(updates, descriptorForType9.getOneofs());
    assertEquals(updates, descriptorForType10.getOneofs());
    assertEquals(updates, descriptorForType11.getOneofs());
    assertEquals(updates, descriptorForType12.getOneofs());
    assertEquals(updates, descriptorForType2.getRealOneofs());
    assertEquals(updates, descriptorForType3.getRealOneofs());
    assertEquals(updates, descriptorForType4.getRealOneofs());
    assertEquals(updates, descriptorForType5.getRealOneofs());
    assertEquals(updates, descriptorForType6.getRealOneofs());
    assertEquals(updates, descriptorForType7.getRealOneofs());
    assertEquals(updates, descriptorForType8.getRealOneofs());
    assertEquals(updates, descriptorForType9.getRealOneofs());
    assertEquals(updates, descriptorForType10.getRealOneofs());
    assertEquals(updates, descriptorForType11.getRealOneofs());
    assertEquals(updates, descriptorForType12.getRealOneofs());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(updates, file.getDependencies());
    assertEquals(updates, file.getExtensions());
    assertEquals(updates, file.getPublicDependencies());
    assertEquals(updates, file.getServices());
  }

  /**
   * Test {@link TbSubscriptionUtils#toProto(EntityId, List)} with
   * {@code entityId}, {@code updates}.
   * <p>
   * Method under test: {@link TbSubscriptionUtils#toProto(EntityId, List)}
   */
  @Test
  @DisplayName("Test toProto(EntityId, List) with 'entityId', 'updates'")
  void testToProtoWithEntityIdUpdates2() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.randomUUID());

    ArrayList<TsKvEntry> updates = new ArrayList<>();
    updates.add(new BasicTsKvEntry(1L, new JsonDataEntry("", "42")));
    updates.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertEquals(2,
        TbSubscriptionUtils.toProto(entityId, updates).getToLocalSubscriptionServiceMsg().getTsUpdate().getDataCount());
  }

  /**
   * Test {@link TbSubscriptionUtils#toProto(EntityId, List)} with
   * {@code entityId}, {@code updates}.
   * <p>
   * Method under test: {@link TbSubscriptionUtils#toProto(EntityId, List)}
   */
  @Test
  @DisplayName("Test toProto(EntityId, List) with 'entityId', 'updates'")
  void testToProtoWithEntityIdUpdates3() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    AggTsKvEntry kv = mock(AggTsKvEntry.class);
    Optional<Boolean> ofResult = Optional.of(true);
    when(kv.getBooleanValue()).thenReturn(ofResult);
    when(kv.getDataType()).thenReturn(DataType.BOOLEAN);
    when(kv.getKey()).thenReturn("Key");
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    ArrayList<TsKvEntry> updates = new ArrayList<>();
    updates.add(basicTsKvEntry);

    // Act
    TbSubscriptionUtils.toProto(entityId, updates);

    // Assert
    verify(kv).getBooleanValue();
    verify(kv, atLeast(1)).getDataType();
    verify(kv).getKey();
  }

  /**
   * Test {@link TbSubscriptionUtils#toProto(EntityId, List)} with
   * {@code entityId}, {@code updates}.
   * <ul>
   *   <li>Given {@link AggTsKvEntry} {@link BasicTsKvEntry#getBooleanValue()}
   * return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscriptionUtils#toProto(EntityId, List)}
   */
  @Test
  @DisplayName("Test toProto(EntityId, List) with 'entityId', 'updates'; given AggTsKvEntry getBooleanValue() return empty")
  void testToProtoWithEntityIdUpdates_givenAggTsKvEntryGetBooleanValueReturnEmpty() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    AggTsKvEntry kv = mock(AggTsKvEntry.class);
    Optional<Boolean> emptyResult = Optional.empty();
    when(kv.getBooleanValue()).thenReturn(emptyResult);
    when(kv.getDataType()).thenReturn(DataType.BOOLEAN);
    when(kv.getKey()).thenReturn("Key");
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    ArrayList<TsKvEntry> updates = new ArrayList<>();
    updates.add(basicTsKvEntry);

    // Act
    TbSubscriptionUtils.toProto(entityId, updates);

    // Assert
    verify(kv).getBooleanValue();
    verify(kv, atLeast(1)).getDataType();
    verify(kv).getKey();
  }

  /**
   * Test {@link TbSubscriptionUtils#toProto(EntityId, List)} with
   * {@code entityId}, {@code updates}.
   * <ul>
   *   <li>Then calls {@link BasicTsKvEntry#getLongValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscriptionUtils#toProto(EntityId, List)}
   */
  @Test
  @DisplayName("Test toProto(EntityId, List) with 'entityId', 'updates'; then calls getLongValue()")
  void testToProtoWithEntityIdUpdates_thenCallsGetLongValue() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    AggTsKvEntry kv = mock(AggTsKvEntry.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(kv.getLongValue()).thenReturn(ofResult);
    when(kv.getDataType()).thenReturn(DataType.LONG);
    when(kv.getKey()).thenReturn("Key");
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    ArrayList<TsKvEntry> updates = new ArrayList<>();
    updates.add(basicTsKvEntry);

    // Act
    TbSubscriptionUtils.toProto(entityId, updates);

    // Assert
    verify(kv, atLeast(1)).getDataType();
    verify(kv).getKey();
    verify(kv).getLongValue();
  }

  /**
   * Test {@link TbSubscriptionUtils#toProto(String, EntityId, List)} with
   * {@code scope}, {@code entityId}, {@code updates}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toProto(String, EntityId, List)}
   */
  @Test
  @DisplayName("Test toProto(String, EntityId, List) with 'scope', 'entityId', 'updates'")
  void testToProtoWithScopeEntityIdUpdates() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    ArrayList<TsKvEntry> updates = new ArrayList<>();

    // Act
    TransportProtos.ToCoreNotificationMsg actualToProtoResult = TbSubscriptionUtils.toProto("Scope", entityId, updates);

    // Assert
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg = actualToProtoResult
        .getToLocalSubscriptionServiceMsg();
    TransportProtos.TbSubUpdateProto attrUpdate = toLocalSubscriptionServiceMsg.getAttrUpdate();
    assertEquals(0, attrUpdate.getDataCount());
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    assertEquals(updates, descriptorForType.getOptions().findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals(updates, toProtoResult.findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getAlarmSubUpdate().findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getAlarmUpdate().findInitializationErrors());
    assertEquals(updates, attrUpdate.findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getNotificationsSubUpdate().findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getNotificationsUpdate().findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getSubEventCallback().findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getSubUpdate().findInitializationErrors());
    assertEquals(updates, toLocalSubscriptionServiceMsg.getTsUpdate().findInitializationErrors());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = actualToProtoResult.getToSubscriptionMgrMsg();
    assertEquals(updates, toSubscriptionMgrMsg.getAlarmDelete().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getAlarmSub().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getAlarmUpdate().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getAttrDelete().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getAttrUpdate().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getAttributeSub().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getNotificationRequestUpdate().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getNotificationUpdate().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getNotificationsCountSub().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getNotificationsSub().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getSubClose().findInitializationErrors());
    assertEquals(updates, toSubscriptionMgrMsg.getSubEvent().findInitializationErrors());
    assertEquals(updates,
        actualToProtoResult.getDefaultInstanceForType().getToLocalSubscriptionServiceMsg().findInitializationErrors());
    assertEquals(updates, actualToProtoResult.getVcResponseMsg().findInitializationErrors());
    assertEquals(updates, toProtoResult.getReservedNameList());
    Descriptors.Descriptor descriptorForType2 = actualToProtoResult.getComponentLifecycle().getDescriptorForType();
    assertEquals(updates, descriptorForType2.getEnumTypes());
    Descriptors.Descriptor descriptorForType3 = actualToProtoResult.getCoreStartupMsg().getDescriptorForType();
    assertEquals(updates, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = actualToProtoResult.getEdgeEventUpdate().getDescriptorForType();
    assertEquals(updates, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = actualToProtoResult.getFromDeviceRpcResponse().getDescriptorForType();
    assertEquals(updates, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor descriptorForType6 = actualToProtoResult.getFromEdgeSyncResponse().getDescriptorForType();
    assertEquals(updates, descriptorForType6.getEnumTypes());
    Descriptors.Descriptor descriptorForType7 = actualToProtoResult.getNotificationRuleProcessorMsg()
        .getDescriptorForType();
    assertEquals(updates, descriptorForType7.getEnumTypes());
    Descriptors.Descriptor descriptorForType8 = actualToProtoResult.getResourceCacheInvalidateMsg()
        .getDescriptorForType();
    assertEquals(updates, descriptorForType8.getEnumTypes());
    Descriptors.Descriptor descriptorForType9 = actualToProtoResult.getRestApiCallResponseMsg().getDescriptorForType();
    assertEquals(updates, descriptorForType9.getEnumTypes());
    Descriptors.Descriptor descriptorForType10 = actualToProtoResult.getToEdgeSyncRequest().getDescriptorForType();
    assertEquals(updates, descriptorForType10.getEnumTypes());
    Descriptors.Descriptor descriptorForType11 = toLocalSubscriptionServiceMsg.getDescriptorForType();
    assertEquals(updates, descriptorForType11.getEnumTypes());
    Descriptors.Descriptor descriptorForType12 = toSubscriptionMgrMsg.getDescriptorForType();
    assertEquals(updates, descriptorForType12.getEnumTypes());
    assertEquals(updates, descriptorForType2.getExtensions());
    assertEquals(updates, descriptorForType3.getExtensions());
    assertEquals(updates, descriptorForType4.getExtensions());
    assertEquals(updates, descriptorForType5.getExtensions());
    assertEquals(updates, descriptorForType6.getExtensions());
    assertEquals(updates, descriptorForType7.getExtensions());
    assertEquals(updates, descriptorForType8.getExtensions());
    assertEquals(updates, descriptorForType9.getExtensions());
    assertEquals(updates, descriptorForType10.getExtensions());
    assertEquals(updates, descriptorForType11.getExtensions());
    assertEquals(updates, descriptorForType12.getExtensions());
    assertEquals(updates, descriptorForType2.getNestedTypes());
    assertEquals(updates, descriptorForType3.getNestedTypes());
    assertEquals(updates, descriptorForType4.getNestedTypes());
    assertEquals(updates, descriptorForType5.getNestedTypes());
    assertEquals(updates, descriptorForType6.getNestedTypes());
    assertEquals(updates, descriptorForType7.getNestedTypes());
    assertEquals(updates, descriptorForType8.getNestedTypes());
    assertEquals(updates, descriptorForType9.getNestedTypes());
    assertEquals(updates, descriptorForType10.getNestedTypes());
    assertEquals(updates, descriptorForType11.getNestedTypes());
    assertEquals(updates, descriptorForType12.getNestedTypes());
    assertEquals(updates, descriptorForType2.getOneofs());
    assertEquals(updates, descriptorForType3.getOneofs());
    assertEquals(updates, descriptorForType4.getOneofs());
    assertEquals(updates, descriptorForType5.getOneofs());
    assertEquals(updates, descriptorForType6.getOneofs());
    assertEquals(updates, descriptorForType7.getOneofs());
    assertEquals(updates, descriptorForType8.getOneofs());
    assertEquals(updates, descriptorForType9.getOneofs());
    assertEquals(updates, descriptorForType10.getOneofs());
    assertEquals(updates, descriptorForType11.getOneofs());
    assertEquals(updates, descriptorForType12.getOneofs());
    assertEquals(updates, descriptorForType2.getRealOneofs());
    assertEquals(updates, descriptorForType3.getRealOneofs());
    assertEquals(updates, descriptorForType4.getRealOneofs());
    assertEquals(updates, descriptorForType5.getRealOneofs());
    assertEquals(updates, descriptorForType6.getRealOneofs());
    assertEquals(updates, descriptorForType7.getRealOneofs());
    assertEquals(updates, descriptorForType8.getRealOneofs());
    assertEquals(updates, descriptorForType9.getRealOneofs());
    assertEquals(updates, descriptorForType10.getRealOneofs());
    assertEquals(updates, descriptorForType11.getRealOneofs());
    assertEquals(updates, descriptorForType12.getRealOneofs());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(updates, file.getDependencies());
    assertEquals(updates, file.getExtensions());
    assertEquals(updates, file.getPublicDependencies());
    assertEquals(updates, file.getServices());
  }

  /**
   * Test {@link TbSubscriptionUtils#toProto(String, EntityId, List)} with
   * {@code scope}, {@code entityId}, {@code updates}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toProto(String, EntityId, List)}
   */
  @Test
  @DisplayName("Test toProto(String, EntityId, List) with 'scope', 'entityId', 'updates'")
  void testToProtoWithScopeEntityIdUpdates2() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.randomUUID());

    ArrayList<TsKvEntry> updates = new ArrayList<>();
    updates.add(new BasicTsKvEntry(1L, new JsonDataEntry("", "42")));
    updates.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertEquals(2,
        TbSubscriptionUtils.toProto("Scope", entityId, updates)
            .getToLocalSubscriptionServiceMsg()
            .getAttrUpdate()
            .getDataCount());
  }

  /**
   * Test {@link TbSubscriptionUtils#toProto(String, EntityId, List)} with
   * {@code scope}, {@code entityId}, {@code updates}.
   * <ul>
   *   <li>Then calls {@link BasicTsKvEntry#getBooleanValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toProto(String, EntityId, List)}
   */
  @Test
  @DisplayName("Test toProto(String, EntityId, List) with 'scope', 'entityId', 'updates'; then calls getBooleanValue()")
  void testToProtoWithScopeEntityIdUpdates_thenCallsGetBooleanValue() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    AggTsKvEntry kv = mock(AggTsKvEntry.class);
    Optional<Boolean> ofResult = Optional.of(true);
    when(kv.getBooleanValue()).thenReturn(ofResult);
    when(kv.getDataType()).thenReturn(DataType.BOOLEAN);
    when(kv.getKey()).thenReturn("Key");
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    ArrayList<TsKvEntry> updates = new ArrayList<>();
    updates.add(basicTsKvEntry);

    // Act
    TbSubscriptionUtils.toProto("Scope", entityId, updates);

    // Assert
    verify(kv).getBooleanValue();
    verify(kv, atLeast(1)).getDataType();
    verify(kv).getKey();
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#toProto(TenantId, UUID, int, TbEntityUpdatesInfo)}
   * with {@code tenantId}, {@code id}, {@code seqNumber}, {@code update}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toProto(TenantId, UUID, int, TbEntityUpdatesInfo)}
   */
  @Test
  @DisplayName("Test toProto(TenantId, UUID, int, TbEntityUpdatesInfo) with 'tenantId', 'id', 'seqNumber', 'update'")
  void testToProtoWithTenantIdIdSeqNumberUpdate() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UUID id = UUID.randomUUID();

    // Act
    TransportProtos.ToCoreNotificationMsg actualToProtoResult = TbSubscriptionUtils.toProto(tenantId, id, 10,
        new TbEntityUpdatesInfo(1L));

    // Assert
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg = actualToProtoResult
        .getToLocalSubscriptionServiceMsg();
    TransportProtos.TbEntitySubEventCallbackProto subEventCallback = toLocalSubscriptionServiceMsg
        .getSubEventCallback();
    assertEquals(1L, subEventCallback.getAttributesUpdateTs());
    assertEquals(1L, subEventCallback.getTimeSeriesUpdateTs());
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = actualToProtoResult.getToSubscriptionMgrMsg();
    TransportProtos.TbAttributeDeleteProto attrDelete = toSubscriptionMgrMsg.getAttrDelete();
    assertSame(reservedNameList, attrDelete.getKeysList());
    TransportProtos.TbEntitySubEventProto subEvent = toSubscriptionMgrMsg.getSubEvent();
    assertSame(reservedNameList, subEvent.getAttrKeysList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.ComponentLifecycleMsgProto componentLifecycle = actualToProtoResult.getComponentLifecycle();
    Descriptors.Descriptor descriptorForType2 = componentLifecycle.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.CoreStartupMsg coreStartupMsg = actualToProtoResult.getCoreStartupMsg();
    Descriptors.Descriptor descriptorForType3 = coreStartupMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EdgeEventUpdateMsgProto edgeEventUpdate = actualToProtoResult.getEdgeEventUpdate();
    Descriptors.Descriptor descriptorForType4 = edgeEventUpdate.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.FromDeviceRPCResponseProto fromDeviceRpcResponse = actualToProtoResult.getFromDeviceRpcResponse();
    Descriptors.Descriptor descriptorForType5 = fromDeviceRpcResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.FromEdgeSyncResponseMsgProto fromEdgeSyncResponse = actualToProtoResult.getFromEdgeSyncResponse();
    Descriptors.Descriptor descriptorForType6 = fromEdgeSyncResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.NotificationRuleProcessorMsg notificationRuleProcessorMsg = actualToProtoResult
        .getNotificationRuleProcessorMsg();
    Descriptors.Descriptor descriptorForType7 = notificationRuleProcessorMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceCacheInvalidateMsg resourceCacheInvalidateMsg = actualToProtoResult
        .getResourceCacheInvalidateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceCacheInvalidateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.RestApiCallResponseMsgProto restApiCallResponseMsg = actualToProtoResult
        .getRestApiCallResponseMsg();
    Descriptors.Descriptor descriptorForType9 = restApiCallResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToEdgeSyncRequestMsgProto toEdgeSyncRequest = actualToProtoResult.getToEdgeSyncRequest();
    Descriptors.Descriptor descriptorForType10 = toEdgeSyncRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    Descriptors.Descriptor descriptorForType11 = toLocalSubscriptionServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toSubscriptionMgrMsg.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreNotificationMsg defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg2 = defaultInstanceForType
        .getToLocalSubscriptionServiceMsg();
    assertSame(descriptorForType11, toLocalSubscriptionServiceMsg2.getDescriptorForType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionUpdateProto alarmSubUpdate = toLocalSubscriptionServiceMsg.getAlarmSubUpdate();
    assertSame(unknownFields, alarmSubUpdate.getUnknownFields());
    TransportProtos.TbAlarmSubUpdateProto alarmUpdate = toLocalSubscriptionServiceMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate.getUnknownFields());
    TransportProtos.TbSubUpdateProto attrUpdate = toLocalSubscriptionServiceMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate.getUnknownFields());
    TransportProtos.NotificationsSubscriptionUpdateProto notificationsSubUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsSubUpdate();
    assertSame(unknownFields, notificationsSubUpdate.getUnknownFields());
    TransportProtos.NotificationsSubUpdateProto notificationsUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsUpdate();
    assertSame(unknownFields, notificationsUpdate.getUnknownFields());
    assertSame(unknownFields, subEventCallback.getUnknownFields());
    TransportProtos.TbSubscriptionUpdateProto subUpdate = toLocalSubscriptionServiceMsg.getSubUpdate();
    assertSame(unknownFields, subUpdate.getUnknownFields());
    TransportProtos.TbAlarmDeleteProto alarmDelete = toSubscriptionMgrMsg.getAlarmDelete();
    assertSame(unknownFields, alarmDelete.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionProto alarmSub = toSubscriptionMgrMsg.getAlarmSub();
    assertSame(unknownFields, alarmSub.getUnknownFields());
    TransportProtos.TbAlarmUpdateProto alarmUpdate2 = toSubscriptionMgrMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate2.getUnknownFields());
    assertSame(unknownFields, attrDelete.getUnknownFields());
    TransportProtos.TbAttributeUpdateProto attrUpdate2 = toSubscriptionMgrMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate2.getUnknownFields());
    TransportProtos.TbAttributeSubscriptionProto attributeSub = toSubscriptionMgrMsg.getAttributeSub();
    assertSame(unknownFields, attributeSub.getUnknownFields());
    TransportProtos.NotificationRequestUpdateProto notificationRequestUpdate = toSubscriptionMgrMsg
        .getNotificationRequestUpdate();
    assertSame(unknownFields, notificationRequestUpdate.getUnknownFields());
    TransportProtos.NotificationUpdateProto notificationUpdate = toSubscriptionMgrMsg.getNotificationUpdate();
    assertSame(unknownFields, notificationUpdate.getUnknownFields());
    TransportProtos.NotificationsCountSubscriptionProto notificationsCountSub = toSubscriptionMgrMsg
        .getNotificationsCountSub();
    assertSame(unknownFields, notificationsCountSub.getUnknownFields());
    TransportProtos.NotificationsSubscriptionProto notificationsSub = toSubscriptionMgrMsg.getNotificationsSub();
    assertSame(unknownFields, notificationsSub.getUnknownFields());
    TransportProtos.TbSubscriptionCloseProto subClose = toSubscriptionMgrMsg.getSubClose();
    assertSame(unknownFields, subClose.getUnknownFields());
    assertSame(unknownFields, componentLifecycle.getUnknownFields());
    assertSame(unknownFields, coreStartupMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, edgeEventUpdate.getUnknownFields());
    assertSame(unknownFields, fromDeviceRpcResponse.getUnknownFields());
    assertSame(unknownFields, fromEdgeSyncResponse.getUnknownFields());
    assertSame(unknownFields, notificationRuleProcessorMsg.getUnknownFields());
    assertSame(unknownFields, resourceCacheInvalidateMsg.getUnknownFields());
    assertSame(unknownFields, restApiCallResponseMsg.getUnknownFields());
    assertSame(unknownFields, toEdgeSyncRequest.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg2.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg.getUnknownFields());
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.VersionControlResponseMsg vcResponseMsg = actualToProtoResult.getVcResponseMsg();
    assertSame(unknownFields, vcResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg2.getAlarmSubUpdate());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg2.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, alarmSubUpdate.getDefaultInstanceForType());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg2.getAlarmUpdate());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg2.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate, alarmUpdate.getDefaultInstanceForType());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getAttrUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getAttrUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getTsUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getTsUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdateOrBuilder());
    assertSame(attrUpdate, attrUpdate.getDefaultInstanceForType());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg2.getNotificationsSubUpdate());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg2.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, notificationsSubUpdate.getDefaultInstanceForType());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg2.getNotificationsUpdate());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg2.getNotificationsUpdateOrBuilder());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg.getNotificationsUpdateOrBuilder());
    assertSame(notificationsUpdate, notificationsUpdate.getDefaultInstanceForType());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg.getSubEventCallbackOrBuilder());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg2.getSubUpdate());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg2.getSubUpdateOrBuilder());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg.getSubUpdateOrBuilder());
    assertSame(subUpdate, subUpdate.getDefaultInstanceForType());
    ByteString expectedResponse = notificationRuleProcessorMsg.getTrigger();
    assertSame(expectedResponse, restApiCallResponseMsg.getResponse());
    assertSame(alarmDelete, toSubscriptionMgrMsg.getAlarmDeleteOrBuilder());
    assertSame(alarmDelete, alarmDelete.getDefaultInstanceForType());
    assertSame(alarmSub, toSubscriptionMgrMsg.getAlarmSubOrBuilder());
    assertSame(alarmSub, alarmSub.getDefaultInstanceForType());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate2, alarmUpdate2.getDefaultInstanceForType());
    assertSame(attrDelete, toSubscriptionMgrMsg.getAttrDeleteOrBuilder());
    assertSame(attrDelete, attrDelete.getDefaultInstanceForType());
    assertSame(attrUpdate2, toSubscriptionMgrMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate2, attrUpdate2.getDefaultInstanceForType());
    assertSame(attributeSub, toSubscriptionMgrMsg.getAttributeSubOrBuilder());
    assertSame(attributeSub, attributeSub.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate, notificationRequestUpdate.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate, toSubscriptionMgrMsg.getNotificationRequestUpdateOrBuilder());
    assertSame(notificationUpdate, notificationUpdate.getDefaultInstanceForType());
    assertSame(notificationUpdate, toSubscriptionMgrMsg.getNotificationUpdateOrBuilder());
    assertSame(notificationsCountSub, notificationsCountSub.getDefaultInstanceForType());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg.getNotificationsCountSubOrBuilder());
    assertSame(notificationsSub, notificationsSub.getDefaultInstanceForType());
    assertSame(notificationsSub, toSubscriptionMgrMsg.getNotificationsSubOrBuilder());
    assertSame(subClose, toSubscriptionMgrMsg.getSubCloseOrBuilder());
    assertSame(subClose, subClose.getDefaultInstanceForType());
    assertSame(subEvent, toSubscriptionMgrMsg.getSubEventOrBuilder());
    assertSame(subEvent, subEvent.getDefaultInstanceForType());
    assertSame(componentLifecycle, componentLifecycle.getDefaultInstanceForType());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycle());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycleOrBuilder());
    assertSame(componentLifecycle, actualToProtoResult.getComponentLifecycleOrBuilder());
    assertSame(coreStartupMsg, coreStartupMsg.getDefaultInstanceForType());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsg());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsgOrBuilder());
    assertSame(coreStartupMsg, actualToProtoResult.getCoreStartupMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, edgeEventUpdate.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdate());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdateOrBuilder());
    assertSame(edgeEventUpdate, actualToProtoResult.getEdgeEventUpdateOrBuilder());
    assertSame(fromDeviceRpcResponse, fromDeviceRpcResponse.getDefaultInstanceForType());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponse());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromDeviceRpcResponse, actualToProtoResult.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, fromEdgeSyncResponse.getDefaultInstanceForType());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponse());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, actualToProtoResult.getFromEdgeSyncResponseOrBuilder());
    assertSame(notificationRuleProcessorMsg, notificationRuleProcessorMsg.getDefaultInstanceForType());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsg());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(notificationRuleProcessorMsg, actualToProtoResult.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg, resourceCacheInvalidateMsg.getDefaultInstanceForType());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsg());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg, actualToProtoResult.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(restApiCallResponseMsg, restApiCallResponseMsg.getDefaultInstanceForType());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsg());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsgOrBuilder());
    assertSame(restApiCallResponseMsg, actualToProtoResult.getRestApiCallResponseMsgOrBuilder());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequest());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, actualToProtoResult.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, toEdgeSyncRequest.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, toLocalSubscriptionServiceMsg2.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, toLocalSubscriptionServiceMsg.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, defaultInstanceForType.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toLocalSubscriptionServiceMsg, actualToProtoResult.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsg());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, actualToProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsg());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, actualToProtoResult.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, vcResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#toProto(TenantId, UUID, int, TbEntityUpdatesInfo)}
   * with {@code tenantId}, {@code id}, {@code seqNumber}, {@code update}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toProto(TenantId, UUID, int, TbEntityUpdatesInfo)}
   */
  @Test
  @DisplayName("Test toProto(TenantId, UUID, int, TbEntityUpdatesInfo) with 'tenantId', 'id', 'seqNumber', 'update'")
  void testToProtoWithTenantIdIdSeqNumberUpdate2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TransportProtos.ToCoreNotificationMsg actualToProtoResult = TbSubscriptionUtils.toProto(tenantId, UUID.randomUUID(),
        10, mock(TbEntityUpdatesInfo.class));

    // Assert
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg = actualToProtoResult
        .getToLocalSubscriptionServiceMsg();
    TransportProtos.TbEntitySubEventCallbackProto subEventCallback = toLocalSubscriptionServiceMsg
        .getSubEventCallback();
    assertEquals(0L, subEventCallback.getAttributesUpdateTs());
    assertEquals(0L, subEventCallback.getTimeSeriesUpdateTs());
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = actualToProtoResult.getToSubscriptionMgrMsg();
    TransportProtos.TbAttributeDeleteProto attrDelete = toSubscriptionMgrMsg.getAttrDelete();
    assertSame(reservedNameList, attrDelete.getKeysList());
    TransportProtos.TbEntitySubEventProto subEvent = toSubscriptionMgrMsg.getSubEvent();
    assertSame(reservedNameList, subEvent.getAttrKeysList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.ComponentLifecycleMsgProto componentLifecycle = actualToProtoResult.getComponentLifecycle();
    Descriptors.Descriptor descriptorForType2 = componentLifecycle.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.CoreStartupMsg coreStartupMsg = actualToProtoResult.getCoreStartupMsg();
    Descriptors.Descriptor descriptorForType3 = coreStartupMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EdgeEventUpdateMsgProto edgeEventUpdate = actualToProtoResult.getEdgeEventUpdate();
    Descriptors.Descriptor descriptorForType4 = edgeEventUpdate.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.FromDeviceRPCResponseProto fromDeviceRpcResponse = actualToProtoResult.getFromDeviceRpcResponse();
    Descriptors.Descriptor descriptorForType5 = fromDeviceRpcResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.FromEdgeSyncResponseMsgProto fromEdgeSyncResponse = actualToProtoResult.getFromEdgeSyncResponse();
    Descriptors.Descriptor descriptorForType6 = fromEdgeSyncResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.NotificationRuleProcessorMsg notificationRuleProcessorMsg = actualToProtoResult
        .getNotificationRuleProcessorMsg();
    Descriptors.Descriptor descriptorForType7 = notificationRuleProcessorMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceCacheInvalidateMsg resourceCacheInvalidateMsg = actualToProtoResult
        .getResourceCacheInvalidateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceCacheInvalidateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.RestApiCallResponseMsgProto restApiCallResponseMsg = actualToProtoResult
        .getRestApiCallResponseMsg();
    Descriptors.Descriptor descriptorForType9 = restApiCallResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToEdgeSyncRequestMsgProto toEdgeSyncRequest = actualToProtoResult.getToEdgeSyncRequest();
    Descriptors.Descriptor descriptorForType10 = toEdgeSyncRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    Descriptors.Descriptor descriptorForType11 = toLocalSubscriptionServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toSubscriptionMgrMsg.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreNotificationMsg defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg2 = defaultInstanceForType
        .getToLocalSubscriptionServiceMsg();
    assertSame(descriptorForType11, toLocalSubscriptionServiceMsg2.getDescriptorForType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionUpdateProto alarmSubUpdate = toLocalSubscriptionServiceMsg.getAlarmSubUpdate();
    assertSame(unknownFields, alarmSubUpdate.getUnknownFields());
    TransportProtos.TbAlarmSubUpdateProto alarmUpdate = toLocalSubscriptionServiceMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate.getUnknownFields());
    TransportProtos.TbSubUpdateProto attrUpdate = toLocalSubscriptionServiceMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate.getUnknownFields());
    TransportProtos.NotificationsSubscriptionUpdateProto notificationsSubUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsSubUpdate();
    assertSame(unknownFields, notificationsSubUpdate.getUnknownFields());
    TransportProtos.NotificationsSubUpdateProto notificationsUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsUpdate();
    assertSame(unknownFields, notificationsUpdate.getUnknownFields());
    assertSame(unknownFields, subEventCallback.getUnknownFields());
    TransportProtos.TbSubscriptionUpdateProto subUpdate = toLocalSubscriptionServiceMsg.getSubUpdate();
    assertSame(unknownFields, subUpdate.getUnknownFields());
    TransportProtos.TbAlarmDeleteProto alarmDelete = toSubscriptionMgrMsg.getAlarmDelete();
    assertSame(unknownFields, alarmDelete.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionProto alarmSub = toSubscriptionMgrMsg.getAlarmSub();
    assertSame(unknownFields, alarmSub.getUnknownFields());
    TransportProtos.TbAlarmUpdateProto alarmUpdate2 = toSubscriptionMgrMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate2.getUnknownFields());
    assertSame(unknownFields, attrDelete.getUnknownFields());
    TransportProtos.TbAttributeUpdateProto attrUpdate2 = toSubscriptionMgrMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate2.getUnknownFields());
    TransportProtos.TbAttributeSubscriptionProto attributeSub = toSubscriptionMgrMsg.getAttributeSub();
    assertSame(unknownFields, attributeSub.getUnknownFields());
    TransportProtos.NotificationRequestUpdateProto notificationRequestUpdate = toSubscriptionMgrMsg
        .getNotificationRequestUpdate();
    assertSame(unknownFields, notificationRequestUpdate.getUnknownFields());
    TransportProtos.NotificationUpdateProto notificationUpdate = toSubscriptionMgrMsg.getNotificationUpdate();
    assertSame(unknownFields, notificationUpdate.getUnknownFields());
    TransportProtos.NotificationsCountSubscriptionProto notificationsCountSub = toSubscriptionMgrMsg
        .getNotificationsCountSub();
    assertSame(unknownFields, notificationsCountSub.getUnknownFields());
    TransportProtos.NotificationsSubscriptionProto notificationsSub = toSubscriptionMgrMsg.getNotificationsSub();
    assertSame(unknownFields, notificationsSub.getUnknownFields());
    TransportProtos.TbSubscriptionCloseProto subClose = toSubscriptionMgrMsg.getSubClose();
    assertSame(unknownFields, subClose.getUnknownFields());
    assertSame(unknownFields, componentLifecycle.getUnknownFields());
    assertSame(unknownFields, coreStartupMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, edgeEventUpdate.getUnknownFields());
    assertSame(unknownFields, fromDeviceRpcResponse.getUnknownFields());
    assertSame(unknownFields, fromEdgeSyncResponse.getUnknownFields());
    assertSame(unknownFields, notificationRuleProcessorMsg.getUnknownFields());
    assertSame(unknownFields, resourceCacheInvalidateMsg.getUnknownFields());
    assertSame(unknownFields, restApiCallResponseMsg.getUnknownFields());
    assertSame(unknownFields, toEdgeSyncRequest.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg2.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg.getUnknownFields());
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.VersionControlResponseMsg vcResponseMsg = actualToProtoResult.getVcResponseMsg();
    assertSame(unknownFields, vcResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg2.getAlarmSubUpdate());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg2.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, alarmSubUpdate.getDefaultInstanceForType());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg2.getAlarmUpdate());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg2.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate, alarmUpdate.getDefaultInstanceForType());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getAttrUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getAttrUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getTsUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getTsUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdateOrBuilder());
    assertSame(attrUpdate, attrUpdate.getDefaultInstanceForType());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg2.getNotificationsSubUpdate());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg2.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, notificationsSubUpdate.getDefaultInstanceForType());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg2.getNotificationsUpdate());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg2.getNotificationsUpdateOrBuilder());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg.getNotificationsUpdateOrBuilder());
    assertSame(notificationsUpdate, notificationsUpdate.getDefaultInstanceForType());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg.getSubEventCallbackOrBuilder());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg2.getSubUpdate());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg2.getSubUpdateOrBuilder());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg.getSubUpdateOrBuilder());
    assertSame(subUpdate, subUpdate.getDefaultInstanceForType());
    ByteString expectedResponse = notificationRuleProcessorMsg.getTrigger();
    assertSame(expectedResponse, restApiCallResponseMsg.getResponse());
    assertSame(alarmDelete, toSubscriptionMgrMsg.getAlarmDeleteOrBuilder());
    assertSame(alarmDelete, alarmDelete.getDefaultInstanceForType());
    assertSame(alarmSub, toSubscriptionMgrMsg.getAlarmSubOrBuilder());
    assertSame(alarmSub, alarmSub.getDefaultInstanceForType());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate2, alarmUpdate2.getDefaultInstanceForType());
    assertSame(attrDelete, toSubscriptionMgrMsg.getAttrDeleteOrBuilder());
    assertSame(attrDelete, attrDelete.getDefaultInstanceForType());
    assertSame(attrUpdate2, toSubscriptionMgrMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate2, attrUpdate2.getDefaultInstanceForType());
    assertSame(attributeSub, toSubscriptionMgrMsg.getAttributeSubOrBuilder());
    assertSame(attributeSub, attributeSub.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate, notificationRequestUpdate.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate, toSubscriptionMgrMsg.getNotificationRequestUpdateOrBuilder());
    assertSame(notificationUpdate, notificationUpdate.getDefaultInstanceForType());
    assertSame(notificationUpdate, toSubscriptionMgrMsg.getNotificationUpdateOrBuilder());
    assertSame(notificationsCountSub, notificationsCountSub.getDefaultInstanceForType());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg.getNotificationsCountSubOrBuilder());
    assertSame(notificationsSub, notificationsSub.getDefaultInstanceForType());
    assertSame(notificationsSub, toSubscriptionMgrMsg.getNotificationsSubOrBuilder());
    assertSame(subClose, toSubscriptionMgrMsg.getSubCloseOrBuilder());
    assertSame(subClose, subClose.getDefaultInstanceForType());
    assertSame(subEvent, toSubscriptionMgrMsg.getSubEventOrBuilder());
    assertSame(subEvent, subEvent.getDefaultInstanceForType());
    assertSame(componentLifecycle, componentLifecycle.getDefaultInstanceForType());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycle());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycleOrBuilder());
    assertSame(componentLifecycle, actualToProtoResult.getComponentLifecycleOrBuilder());
    assertSame(coreStartupMsg, coreStartupMsg.getDefaultInstanceForType());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsg());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsgOrBuilder());
    assertSame(coreStartupMsg, actualToProtoResult.getCoreStartupMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, edgeEventUpdate.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdate());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdateOrBuilder());
    assertSame(edgeEventUpdate, actualToProtoResult.getEdgeEventUpdateOrBuilder());
    assertSame(fromDeviceRpcResponse, fromDeviceRpcResponse.getDefaultInstanceForType());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponse());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromDeviceRpcResponse, actualToProtoResult.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, fromEdgeSyncResponse.getDefaultInstanceForType());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponse());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, actualToProtoResult.getFromEdgeSyncResponseOrBuilder());
    assertSame(notificationRuleProcessorMsg, notificationRuleProcessorMsg.getDefaultInstanceForType());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsg());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(notificationRuleProcessorMsg, actualToProtoResult.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg, resourceCacheInvalidateMsg.getDefaultInstanceForType());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsg());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg, actualToProtoResult.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(restApiCallResponseMsg, restApiCallResponseMsg.getDefaultInstanceForType());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsg());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsgOrBuilder());
    assertSame(restApiCallResponseMsg, actualToProtoResult.getRestApiCallResponseMsgOrBuilder());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequest());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, actualToProtoResult.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, toEdgeSyncRequest.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, toLocalSubscriptionServiceMsg2.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, toLocalSubscriptionServiceMsg.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, defaultInstanceForType.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toLocalSubscriptionServiceMsg, actualToProtoResult.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsg());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, actualToProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsg());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, actualToProtoResult.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, vcResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link TbSubscriptionUtils#toProto(boolean, String, EntityId, List)}
   * with {@code timeSeries}, {@code scope}, {@code entityId}, {@code updates}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toProto(boolean, String, EntityId, List)}
   */
  @Test
  @DisplayName("Test toProto(boolean, String, EntityId, List) with 'timeSeries', 'scope', 'entityId', 'updates'")
  void testToProtoWithTimeSeriesScopeEntityIdUpdates() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.randomUUID());

    // Act
    TransportProtos.ToCoreNotificationMsg actualToProtoResult = TbSubscriptionUtils.toProto(false, "Scope", entityId,
        new ArrayList<>());

    // Assert
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg = actualToProtoResult
        .getToLocalSubscriptionServiceMsg();
    TransportProtos.TbSubUpdateProto attrUpdate = toLocalSubscriptionServiceMsg.getAttrUpdate();
    assertEquals("Scope", attrUpdate.getScope());
    TransportProtos.TbSubUpdateProto tsUpdate = toLocalSubscriptionServiceMsg.getTsUpdate();
    assertEquals(0, tsUpdate.getSerializedSize());
    assertEquals(0L, tsUpdate.getEntityIdLSB());
    assertEquals(0L, tsUpdate.getEntityIdMSB());
    assertFalse(toLocalSubscriptionServiceMsg.hasTsUpdate());
    assertTrue(toLocalSubscriptionServiceMsg.hasAttrUpdate());
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    TransportProtos.ComponentLifecycleMsgProto componentLifecycle = actualToProtoResult.getComponentLifecycle();
    assertSame(options, componentLifecycle.getDescriptorForType().getOptions());
    TransportProtos.CoreStartupMsg coreStartupMsg = actualToProtoResult.getCoreStartupMsg();
    assertSame(options, coreStartupMsg.getDescriptorForType().getOptions());
    TransportProtos.EdgeEventUpdateMsgProto edgeEventUpdate = actualToProtoResult.getEdgeEventUpdate();
    assertSame(options, edgeEventUpdate.getDescriptorForType().getOptions());
    TransportProtos.FromDeviceRPCResponseProto fromDeviceRpcResponse = actualToProtoResult.getFromDeviceRpcResponse();
    assertSame(options, fromDeviceRpcResponse.getDescriptorForType().getOptions());
    TransportProtos.FromEdgeSyncResponseMsgProto fromEdgeSyncResponse = actualToProtoResult.getFromEdgeSyncResponse();
    assertSame(options, fromEdgeSyncResponse.getDescriptorForType().getOptions());
    TransportProtos.NotificationRuleProcessorMsg notificationRuleProcessorMsg = actualToProtoResult
        .getNotificationRuleProcessorMsg();
    assertSame(options, notificationRuleProcessorMsg.getDescriptorForType().getOptions());
    TransportProtos.ResourceCacheInvalidateMsg resourceCacheInvalidateMsg = actualToProtoResult
        .getResourceCacheInvalidateMsg();
    assertSame(options, resourceCacheInvalidateMsg.getDescriptorForType().getOptions());
    TransportProtos.RestApiCallResponseMsgProto restApiCallResponseMsg = actualToProtoResult
        .getRestApiCallResponseMsg();
    assertSame(options, restApiCallResponseMsg.getDescriptorForType().getOptions());
    TransportProtos.ToEdgeSyncRequestMsgProto toEdgeSyncRequest = actualToProtoResult.getToEdgeSyncRequest();
    assertSame(options, toEdgeSyncRequest.getDescriptorForType().getOptions());
    Descriptors.Descriptor descriptorForType2 = toLocalSubscriptionServiceMsg.getDescriptorForType();
    assertSame(options, descriptorForType2.getOptions());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = actualToProtoResult.getToSubscriptionMgrMsg();
    assertSame(options, toSubscriptionMgrMsg.getDescriptorForType().getOptions());
    TransportProtos.ToCoreNotificationMsg defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg2 = defaultInstanceForType
        .getToLocalSubscriptionServiceMsg();
    assertSame(descriptorForType2, toLocalSubscriptionServiceMsg2.getDescriptorForType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionUpdateProto alarmSubUpdate = toLocalSubscriptionServiceMsg.getAlarmSubUpdate();
    assertSame(unknownFields, alarmSubUpdate.getUnknownFields());
    TransportProtos.TbAlarmSubUpdateProto alarmUpdate = toLocalSubscriptionServiceMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate.getUnknownFields());
    assertSame(unknownFields, attrUpdate.getUnknownFields());
    TransportProtos.NotificationsSubscriptionUpdateProto notificationsSubUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsSubUpdate();
    assertSame(unknownFields, notificationsSubUpdate.getUnknownFields());
    TransportProtos.NotificationsSubUpdateProto notificationsUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsUpdate();
    assertSame(unknownFields, notificationsUpdate.getUnknownFields());
    TransportProtos.TbEntitySubEventCallbackProto subEventCallback = toLocalSubscriptionServiceMsg
        .getSubEventCallback();
    assertSame(unknownFields, subEventCallback.getUnknownFields());
    TransportProtos.TbSubscriptionUpdateProto subUpdate = toLocalSubscriptionServiceMsg.getSubUpdate();
    assertSame(unknownFields, subUpdate.getUnknownFields());
    assertSame(unknownFields, tsUpdate.getUnknownFields());
    TransportProtos.TbAlarmDeleteProto alarmDelete = toSubscriptionMgrMsg.getAlarmDelete();
    assertSame(unknownFields, alarmDelete.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionProto alarmSub = toSubscriptionMgrMsg.getAlarmSub();
    assertSame(unknownFields, alarmSub.getUnknownFields());
    TransportProtos.TbAlarmUpdateProto alarmUpdate2 = toSubscriptionMgrMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate2.getUnknownFields());
    TransportProtos.TbAttributeDeleteProto attrDelete = toSubscriptionMgrMsg.getAttrDelete();
    assertSame(unknownFields, attrDelete.getUnknownFields());
    TransportProtos.TbAttributeUpdateProto attrUpdate2 = toSubscriptionMgrMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate2.getUnknownFields());
    TransportProtos.TbAttributeSubscriptionProto attributeSub = toSubscriptionMgrMsg.getAttributeSub();
    assertSame(unknownFields, attributeSub.getUnknownFields());
    TransportProtos.NotificationRequestUpdateProto notificationRequestUpdate = toSubscriptionMgrMsg
        .getNotificationRequestUpdate();
    assertSame(unknownFields, notificationRequestUpdate.getUnknownFields());
    TransportProtos.NotificationUpdateProto notificationUpdate = toSubscriptionMgrMsg.getNotificationUpdate();
    assertSame(unknownFields, notificationUpdate.getUnknownFields());
    TransportProtos.NotificationsCountSubscriptionProto notificationsCountSub = toSubscriptionMgrMsg
        .getNotificationsCountSub();
    assertSame(unknownFields, notificationsCountSub.getUnknownFields());
    TransportProtos.NotificationsSubscriptionProto notificationsSub = toSubscriptionMgrMsg.getNotificationsSub();
    assertSame(unknownFields, notificationsSub.getUnknownFields());
    TransportProtos.TbSubscriptionCloseProto subClose = toSubscriptionMgrMsg.getSubClose();
    assertSame(unknownFields, subClose.getUnknownFields());
    assertSame(unknownFields, componentLifecycle.getUnknownFields());
    assertSame(unknownFields, coreStartupMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, edgeEventUpdate.getUnknownFields());
    assertSame(unknownFields, fromDeviceRpcResponse.getUnknownFields());
    assertSame(unknownFields, fromEdgeSyncResponse.getUnknownFields());
    assertSame(unknownFields, notificationRuleProcessorMsg.getUnknownFields());
    assertSame(unknownFields, resourceCacheInvalidateMsg.getUnknownFields());
    assertSame(unknownFields, restApiCallResponseMsg.getUnknownFields());
    assertSame(unknownFields, toEdgeSyncRequest.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg2.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg.getUnknownFields());
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.VersionControlResponseMsg vcResponseMsg = actualToProtoResult.getVcResponseMsg();
    assertSame(unknownFields, vcResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg2.getAlarmSubUpdate());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg2.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, alarmSubUpdate.getDefaultInstanceForType());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg2.getAlarmUpdate());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg2.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate, alarmUpdate.getDefaultInstanceForType());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getAttrUpdateOrBuilder());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg2.getNotificationsSubUpdate());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg2.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, notificationsSubUpdate.getDefaultInstanceForType());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg2.getNotificationsUpdate());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg2.getNotificationsUpdateOrBuilder());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg.getNotificationsUpdateOrBuilder());
    assertSame(notificationsUpdate, notificationsUpdate.getDefaultInstanceForType());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg2.getSubEventCallback());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg2.getSubEventCallbackOrBuilder());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg.getSubEventCallbackOrBuilder());
    assertSame(subEventCallback, subEventCallback.getDefaultInstanceForType());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg2.getSubUpdate());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg2.getSubUpdateOrBuilder());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg.getSubUpdateOrBuilder());
    assertSame(subUpdate, subUpdate.getDefaultInstanceForType());
    assertSame(tsUpdate, toLocalSubscriptionServiceMsg2.getAttrUpdate());
    assertSame(tsUpdate, toLocalSubscriptionServiceMsg2.getAttrUpdateOrBuilder());
    assertSame(tsUpdate, toLocalSubscriptionServiceMsg2.getTsUpdate());
    assertSame(tsUpdate, toLocalSubscriptionServiceMsg2.getTsUpdateOrBuilder());
    assertSame(tsUpdate, toLocalSubscriptionServiceMsg.getTsUpdateOrBuilder());
    assertSame(tsUpdate, attrUpdate.getDefaultInstanceForType());
    assertSame(tsUpdate, tsUpdate.getDefaultInstanceForType());
    ByteString expectedResponse = notificationRuleProcessorMsg.getTrigger();
    assertSame(expectedResponse, restApiCallResponseMsg.getResponse());
    assertSame(alarmDelete, toSubscriptionMgrMsg.getAlarmDeleteOrBuilder());
    assertSame(alarmDelete, alarmDelete.getDefaultInstanceForType());
    assertSame(alarmSub, toSubscriptionMgrMsg.getAlarmSubOrBuilder());
    assertSame(alarmSub, alarmSub.getDefaultInstanceForType());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate2, alarmUpdate2.getDefaultInstanceForType());
    assertSame(attrDelete, toSubscriptionMgrMsg.getAttrDeleteOrBuilder());
    assertSame(attrDelete, attrDelete.getDefaultInstanceForType());
    assertSame(attrUpdate2, toSubscriptionMgrMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate2, attrUpdate2.getDefaultInstanceForType());
    assertSame(attributeSub, toSubscriptionMgrMsg.getAttributeSubOrBuilder());
    assertSame(attributeSub, attributeSub.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate, notificationRequestUpdate.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate, toSubscriptionMgrMsg.getNotificationRequestUpdateOrBuilder());
    assertSame(notificationUpdate, notificationUpdate.getDefaultInstanceForType());
    assertSame(notificationUpdate, toSubscriptionMgrMsg.getNotificationUpdateOrBuilder());
    assertSame(notificationsCountSub, notificationsCountSub.getDefaultInstanceForType());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg.getNotificationsCountSubOrBuilder());
    assertSame(notificationsSub, notificationsSub.getDefaultInstanceForType());
    assertSame(notificationsSub, toSubscriptionMgrMsg.getNotificationsSubOrBuilder());
    assertSame(subClose, toSubscriptionMgrMsg.getSubCloseOrBuilder());
    assertSame(subClose, subClose.getDefaultInstanceForType());
    TransportProtos.TbEntitySubEventProto expectedSubEventOrBuilder = toSubscriptionMgrMsg.getSubEvent();
    assertSame(expectedSubEventOrBuilder, toSubscriptionMgrMsg.getSubEventOrBuilder());
    assertSame(componentLifecycle, componentLifecycle.getDefaultInstanceForType());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycle());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycleOrBuilder());
    assertSame(componentLifecycle, actualToProtoResult.getComponentLifecycleOrBuilder());
    assertSame(coreStartupMsg, coreStartupMsg.getDefaultInstanceForType());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsg());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsgOrBuilder());
    assertSame(coreStartupMsg, actualToProtoResult.getCoreStartupMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, edgeEventUpdate.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdate());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdateOrBuilder());
    assertSame(edgeEventUpdate, actualToProtoResult.getEdgeEventUpdateOrBuilder());
    assertSame(fromDeviceRpcResponse, fromDeviceRpcResponse.getDefaultInstanceForType());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponse());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromDeviceRpcResponse, actualToProtoResult.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, fromEdgeSyncResponse.getDefaultInstanceForType());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponse());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, actualToProtoResult.getFromEdgeSyncResponseOrBuilder());
    assertSame(notificationRuleProcessorMsg, notificationRuleProcessorMsg.getDefaultInstanceForType());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsg());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(notificationRuleProcessorMsg, actualToProtoResult.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg, resourceCacheInvalidateMsg.getDefaultInstanceForType());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsg());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg, actualToProtoResult.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(restApiCallResponseMsg, restApiCallResponseMsg.getDefaultInstanceForType());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsg());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsgOrBuilder());
    assertSame(restApiCallResponseMsg, actualToProtoResult.getRestApiCallResponseMsgOrBuilder());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequest());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, actualToProtoResult.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, toEdgeSyncRequest.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, toLocalSubscriptionServiceMsg2.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, toLocalSubscriptionServiceMsg.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, defaultInstanceForType.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toLocalSubscriptionServiceMsg, actualToProtoResult.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsg());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, actualToProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsg());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, actualToProtoResult.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, vcResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link TbSubscriptionUtils#toProto(boolean, String, EntityId, List)}
   * with {@code timeSeries}, {@code scope}, {@code entityId}, {@code updates}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toProto(boolean, String, EntityId, List)}
   */
  @Test
  @DisplayName("Test toProto(boolean, String, EntityId, List) with 'timeSeries', 'scope', 'entityId', 'updates'")
  void testToProtoWithTimeSeriesScopeEntityIdUpdates2() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.randomUUID());

    ArrayList<TsKvEntry> updates = new ArrayList<>();
    updates.add(new BasicTsKvEntry(1L, new JsonDataEntry("", "42")));
    updates.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertEquals(2,
        TbSubscriptionUtils.toProto(true, "Scope", entityId, updates)
            .getToLocalSubscriptionServiceMsg()
            .getTsUpdate()
            .getDataCount());
  }

  /**
   * Test {@link TbSubscriptionUtils#fromProto(TbSubUpdateProto)} with
   * {@code TbSubUpdateProto}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#fromProto(TransportProtos.TbSubUpdateProto)}
   */
  @Test
  @DisplayName("Test fromProto(TbSubUpdateProto) with 'TbSubUpdateProto'; when DefaultInstance; then return Empty")
  void testFromProtoWithTbSubUpdateProto_whenDefaultInstance_thenReturnEmpty() {
    // Arrange and Act
    List<TsKvEntry> actualFromProtoResult = TbSubscriptionUtils
        .fromProto(TransportProtos.TbSubUpdateProto.getDefaultInstance());

    // Assert
    assertTrue(actualFromProtoResult.isEmpty());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#toAlarmSubUpdateToProto(EntityId, AlarmInfo, boolean)}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toAlarmSubUpdateToProto(EntityId, AlarmInfo, boolean)}
   */
  @Test
  @DisplayName("Test toAlarmSubUpdateToProto(EntityId, AlarmInfo, boolean); given randomUUID; then calls getId()")
  void testToAlarmSubUpdateToProto_givenRandomUUID_thenCallsGetId() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act
    TransportProtos.ToCoreNotificationMsg actualToAlarmSubUpdateToProtoResult = TbSubscriptionUtils
        .toAlarmSubUpdateToProto(entityId, new AlarmInfo(), true);

    // Assert
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualToAlarmSubUpdateToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = actualToAlarmSubUpdateToProtoResult
        .getToSubscriptionMgrMsg();
    TransportProtos.TbAttributeDeleteProto attrDelete = toSubscriptionMgrMsg.getAttrDelete();
    assertSame(reservedNameList, attrDelete.getKeysList());
    TransportProtos.TbEntitySubEventProto subEvent = toSubscriptionMgrMsg.getSubEvent();
    assertSame(reservedNameList, subEvent.getAttrKeysList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.ComponentLifecycleMsgProto componentLifecycle = actualToAlarmSubUpdateToProtoResult
        .getComponentLifecycle();
    Descriptors.Descriptor descriptorForType2 = componentLifecycle.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.CoreStartupMsg coreStartupMsg = actualToAlarmSubUpdateToProtoResult.getCoreStartupMsg();
    Descriptors.Descriptor descriptorForType3 = coreStartupMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EdgeEventUpdateMsgProto edgeEventUpdate = actualToAlarmSubUpdateToProtoResult.getEdgeEventUpdate();
    Descriptors.Descriptor descriptorForType4 = edgeEventUpdate.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.FromDeviceRPCResponseProto fromDeviceRpcResponse = actualToAlarmSubUpdateToProtoResult
        .getFromDeviceRpcResponse();
    Descriptors.Descriptor descriptorForType5 = fromDeviceRpcResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.FromEdgeSyncResponseMsgProto fromEdgeSyncResponse = actualToAlarmSubUpdateToProtoResult
        .getFromEdgeSyncResponse();
    Descriptors.Descriptor descriptorForType6 = fromEdgeSyncResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.NotificationRuleProcessorMsg notificationRuleProcessorMsg = actualToAlarmSubUpdateToProtoResult
        .getNotificationRuleProcessorMsg();
    Descriptors.Descriptor descriptorForType7 = notificationRuleProcessorMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceCacheInvalidateMsg resourceCacheInvalidateMsg = actualToAlarmSubUpdateToProtoResult
        .getResourceCacheInvalidateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceCacheInvalidateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.RestApiCallResponseMsgProto restApiCallResponseMsg = actualToAlarmSubUpdateToProtoResult
        .getRestApiCallResponseMsg();
    Descriptors.Descriptor descriptorForType9 = restApiCallResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToEdgeSyncRequestMsgProto toEdgeSyncRequest = actualToAlarmSubUpdateToProtoResult
        .getToEdgeSyncRequest();
    Descriptors.Descriptor descriptorForType10 = toEdgeSyncRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg = actualToAlarmSubUpdateToProtoResult
        .getToLocalSubscriptionServiceMsg();
    Descriptors.Descriptor descriptorForType11 = toLocalSubscriptionServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toSubscriptionMgrMsg.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreNotificationMsg defaultInstanceForType = actualToAlarmSubUpdateToProtoResult
        .getDefaultInstanceForType();
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg2 = defaultInstanceForType
        .getToLocalSubscriptionServiceMsg();
    assertSame(descriptorForType11, toLocalSubscriptionServiceMsg2.getDescriptorForType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToAlarmSubUpdateToProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionUpdateProto alarmSubUpdate = toLocalSubscriptionServiceMsg.getAlarmSubUpdate();
    assertSame(unknownFields, alarmSubUpdate.getUnknownFields());
    TransportProtos.TbAlarmSubUpdateProto alarmUpdate = toLocalSubscriptionServiceMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate.getUnknownFields());
    TransportProtos.TbSubUpdateProto attrUpdate = toLocalSubscriptionServiceMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate.getUnknownFields());
    TransportProtos.NotificationsSubscriptionUpdateProto notificationsSubUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsSubUpdate();
    assertSame(unknownFields, notificationsSubUpdate.getUnknownFields());
    TransportProtos.NotificationsSubUpdateProto notificationsUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsUpdate();
    assertSame(unknownFields, notificationsUpdate.getUnknownFields());
    TransportProtos.TbEntitySubEventCallbackProto subEventCallback = toLocalSubscriptionServiceMsg
        .getSubEventCallback();
    assertSame(unknownFields, subEventCallback.getUnknownFields());
    TransportProtos.TbSubscriptionUpdateProto subUpdate = toLocalSubscriptionServiceMsg.getSubUpdate();
    assertSame(unknownFields, subUpdate.getUnknownFields());
    TransportProtos.TbAlarmDeleteProto alarmDelete = toSubscriptionMgrMsg.getAlarmDelete();
    assertSame(unknownFields, alarmDelete.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionProto alarmSub = toSubscriptionMgrMsg.getAlarmSub();
    assertSame(unknownFields, alarmSub.getUnknownFields());
    TransportProtos.TbAlarmUpdateProto alarmUpdate2 = toSubscriptionMgrMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate2.getUnknownFields());
    assertSame(unknownFields, attrDelete.getUnknownFields());
    TransportProtos.TbAttributeUpdateProto attrUpdate2 = toSubscriptionMgrMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate2.getUnknownFields());
    TransportProtos.TbAttributeSubscriptionProto attributeSub = toSubscriptionMgrMsg.getAttributeSub();
    assertSame(unknownFields, attributeSub.getUnknownFields());
    TransportProtos.NotificationRequestUpdateProto notificationRequestUpdate = toSubscriptionMgrMsg
        .getNotificationRequestUpdate();
    assertSame(unknownFields, notificationRequestUpdate.getUnknownFields());
    TransportProtos.NotificationUpdateProto notificationUpdate = toSubscriptionMgrMsg.getNotificationUpdate();
    assertSame(unknownFields, notificationUpdate.getUnknownFields());
    TransportProtos.NotificationsCountSubscriptionProto notificationsCountSub = toSubscriptionMgrMsg
        .getNotificationsCountSub();
    assertSame(unknownFields, notificationsCountSub.getUnknownFields());
    TransportProtos.NotificationsSubscriptionProto notificationsSub = toSubscriptionMgrMsg.getNotificationsSub();
    assertSame(unknownFields, notificationsSub.getUnknownFields());
    TransportProtos.TbSubscriptionCloseProto subClose = toSubscriptionMgrMsg.getSubClose();
    assertSame(unknownFields, subClose.getUnknownFields());
    assertSame(unknownFields, componentLifecycle.getUnknownFields());
    assertSame(unknownFields, coreStartupMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, edgeEventUpdate.getUnknownFields());
    assertSame(unknownFields, fromDeviceRpcResponse.getUnknownFields());
    assertSame(unknownFields, fromEdgeSyncResponse.getUnknownFields());
    assertSame(unknownFields, notificationRuleProcessorMsg.getUnknownFields());
    assertSame(unknownFields, resourceCacheInvalidateMsg.getUnknownFields());
    assertSame(unknownFields, restApiCallResponseMsg.getUnknownFields());
    assertSame(unknownFields, toEdgeSyncRequest.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg2.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg.getUnknownFields());
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.VersionControlResponseMsg vcResponseMsg = actualToAlarmSubUpdateToProtoResult.getVcResponseMsg();
    assertSame(unknownFields, vcResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg2.getAlarmSubUpdate());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg2.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, alarmSubUpdate.getDefaultInstanceForType());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg.getAlarmUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getAttrUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getAttrUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getTsUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getTsUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdateOrBuilder());
    assertSame(attrUpdate, attrUpdate.getDefaultInstanceForType());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg2.getNotificationsSubUpdate());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg2.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, notificationsSubUpdate.getDefaultInstanceForType());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg2.getNotificationsUpdate());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg2.getNotificationsUpdateOrBuilder());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg.getNotificationsUpdateOrBuilder());
    assertSame(notificationsUpdate, notificationsUpdate.getDefaultInstanceForType());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg2.getSubEventCallback());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg2.getSubEventCallbackOrBuilder());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg.getSubEventCallbackOrBuilder());
    assertSame(subEventCallback, subEventCallback.getDefaultInstanceForType());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg2.getSubUpdate());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg2.getSubUpdateOrBuilder());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg.getSubUpdateOrBuilder());
    assertSame(subUpdate, subUpdate.getDefaultInstanceForType());
    ByteString expectedResponse = notificationRuleProcessorMsg.getTrigger();
    assertSame(expectedResponse, restApiCallResponseMsg.getResponse());
    assertSame(alarmDelete, toSubscriptionMgrMsg.getAlarmDeleteOrBuilder());
    assertSame(alarmDelete, alarmDelete.getDefaultInstanceForType());
    assertSame(alarmSub, toSubscriptionMgrMsg.getAlarmSubOrBuilder());
    assertSame(alarmSub, alarmSub.getDefaultInstanceForType());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate2, alarmUpdate2.getDefaultInstanceForType());
    assertSame(attrDelete, toSubscriptionMgrMsg.getAttrDeleteOrBuilder());
    assertSame(attrDelete, attrDelete.getDefaultInstanceForType());
    assertSame(attrUpdate2, toSubscriptionMgrMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate2, attrUpdate2.getDefaultInstanceForType());
    assertSame(attributeSub, toSubscriptionMgrMsg.getAttributeSubOrBuilder());
    assertSame(attributeSub, attributeSub.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate, notificationRequestUpdate.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate, toSubscriptionMgrMsg.getNotificationRequestUpdateOrBuilder());
    assertSame(notificationUpdate, notificationUpdate.getDefaultInstanceForType());
    assertSame(notificationUpdate, toSubscriptionMgrMsg.getNotificationUpdateOrBuilder());
    assertSame(notificationsCountSub, notificationsCountSub.getDefaultInstanceForType());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg.getNotificationsCountSubOrBuilder());
    assertSame(notificationsSub, notificationsSub.getDefaultInstanceForType());
    assertSame(notificationsSub, toSubscriptionMgrMsg.getNotificationsSubOrBuilder());
    assertSame(subClose, toSubscriptionMgrMsg.getSubCloseOrBuilder());
    assertSame(subClose, subClose.getDefaultInstanceForType());
    assertSame(subEvent, toSubscriptionMgrMsg.getSubEventOrBuilder());
    assertSame(subEvent, subEvent.getDefaultInstanceForType());
    assertSame(componentLifecycle, componentLifecycle.getDefaultInstanceForType());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycle());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycleOrBuilder());
    assertSame(componentLifecycle, actualToAlarmSubUpdateToProtoResult.getComponentLifecycleOrBuilder());
    assertSame(coreStartupMsg, coreStartupMsg.getDefaultInstanceForType());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsg());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsgOrBuilder());
    assertSame(coreStartupMsg, actualToAlarmSubUpdateToProtoResult.getCoreStartupMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, edgeEventUpdate.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdate());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdateOrBuilder());
    assertSame(edgeEventUpdate, actualToAlarmSubUpdateToProtoResult.getEdgeEventUpdateOrBuilder());
    assertSame(fromDeviceRpcResponse, fromDeviceRpcResponse.getDefaultInstanceForType());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponse());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromDeviceRpcResponse, actualToAlarmSubUpdateToProtoResult.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, fromEdgeSyncResponse.getDefaultInstanceForType());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponse());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, actualToAlarmSubUpdateToProtoResult.getFromEdgeSyncResponseOrBuilder());
    assertSame(notificationRuleProcessorMsg, notificationRuleProcessorMsg.getDefaultInstanceForType());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsg());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(notificationRuleProcessorMsg,
        actualToAlarmSubUpdateToProtoResult.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg, resourceCacheInvalidateMsg.getDefaultInstanceForType());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsg());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg,
        actualToAlarmSubUpdateToProtoResult.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(restApiCallResponseMsg, restApiCallResponseMsg.getDefaultInstanceForType());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsg());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsgOrBuilder());
    assertSame(restApiCallResponseMsg, actualToAlarmSubUpdateToProtoResult.getRestApiCallResponseMsgOrBuilder());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequest());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, actualToAlarmSubUpdateToProtoResult.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, toEdgeSyncRequest.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, toLocalSubscriptionServiceMsg2.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, toLocalSubscriptionServiceMsg.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, defaultInstanceForType.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toLocalSubscriptionServiceMsg,
        actualToAlarmSubUpdateToProtoResult.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsg());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, actualToAlarmSubUpdateToProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsg());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, actualToAlarmSubUpdateToProtoResult.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, vcResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#toAlarmSubUpdateToProto(EntityId, AlarmInfo, boolean)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toAlarmSubUpdateToProto(EntityId, AlarmInfo, boolean)}
   */
  @Test
  @DisplayName("Test toAlarmSubUpdateToProto(EntityId, AlarmInfo, boolean); when AlarmId(UUID) with id is randomUUID")
  void testToAlarmSubUpdateToProto_whenAlarmIdWithIdIsRandomUUID() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.randomUUID());

    // Act
    TransportProtos.ToCoreNotificationMsg actualToAlarmSubUpdateToProtoResult = TbSubscriptionUtils
        .toAlarmSubUpdateToProto(entityId, new AlarmInfo(), true);

    // Assert
    Descriptors.Descriptor descriptorForType = actualToAlarmSubUpdateToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = actualToAlarmSubUpdateToProtoResult
        .getToSubscriptionMgrMsg();
    TransportProtos.TbAttributeDeleteProto attrDelete = toSubscriptionMgrMsg.getAttrDelete();
    assertSame(reservedNameList, attrDelete.getKeysList());
    TransportProtos.TbEntitySubEventProto subEvent = toSubscriptionMgrMsg.getSubEvent();
    assertSame(reservedNameList, subEvent.getAttrKeysList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.ComponentLifecycleMsgProto componentLifecycle = actualToAlarmSubUpdateToProtoResult
        .getComponentLifecycle();
    Descriptors.Descriptor descriptorForType2 = componentLifecycle.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.CoreStartupMsg coreStartupMsg = actualToAlarmSubUpdateToProtoResult.getCoreStartupMsg();
    Descriptors.Descriptor descriptorForType3 = coreStartupMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EdgeEventUpdateMsgProto edgeEventUpdate = actualToAlarmSubUpdateToProtoResult.getEdgeEventUpdate();
    Descriptors.Descriptor descriptorForType4 = edgeEventUpdate.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.FromDeviceRPCResponseProto fromDeviceRpcResponse = actualToAlarmSubUpdateToProtoResult
        .getFromDeviceRpcResponse();
    Descriptors.Descriptor descriptorForType5 = fromDeviceRpcResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.FromEdgeSyncResponseMsgProto fromEdgeSyncResponse = actualToAlarmSubUpdateToProtoResult
        .getFromEdgeSyncResponse();
    Descriptors.Descriptor descriptorForType6 = fromEdgeSyncResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.NotificationRuleProcessorMsg notificationRuleProcessorMsg = actualToAlarmSubUpdateToProtoResult
        .getNotificationRuleProcessorMsg();
    Descriptors.Descriptor descriptorForType7 = notificationRuleProcessorMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceCacheInvalidateMsg resourceCacheInvalidateMsg = actualToAlarmSubUpdateToProtoResult
        .getResourceCacheInvalidateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceCacheInvalidateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.RestApiCallResponseMsgProto restApiCallResponseMsg = actualToAlarmSubUpdateToProtoResult
        .getRestApiCallResponseMsg();
    Descriptors.Descriptor descriptorForType9 = restApiCallResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToEdgeSyncRequestMsgProto toEdgeSyncRequest = actualToAlarmSubUpdateToProtoResult
        .getToEdgeSyncRequest();
    Descriptors.Descriptor descriptorForType10 = toEdgeSyncRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg = actualToAlarmSubUpdateToProtoResult
        .getToLocalSubscriptionServiceMsg();
    Descriptors.Descriptor descriptorForType11 = toLocalSubscriptionServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toSubscriptionMgrMsg.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreNotificationMsg defaultInstanceForType = actualToAlarmSubUpdateToProtoResult
        .getDefaultInstanceForType();
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg2 = defaultInstanceForType
        .getToLocalSubscriptionServiceMsg();
    assertSame(descriptorForType11, toLocalSubscriptionServiceMsg2.getDescriptorForType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToAlarmSubUpdateToProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionUpdateProto alarmSubUpdate = toLocalSubscriptionServiceMsg.getAlarmSubUpdate();
    assertSame(unknownFields, alarmSubUpdate.getUnknownFields());
    TransportProtos.TbAlarmSubUpdateProto alarmUpdate = toLocalSubscriptionServiceMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate.getUnknownFields());
    TransportProtos.TbSubUpdateProto attrUpdate = toLocalSubscriptionServiceMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate.getUnknownFields());
    TransportProtos.NotificationsSubscriptionUpdateProto notificationsSubUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsSubUpdate();
    assertSame(unknownFields, notificationsSubUpdate.getUnknownFields());
    TransportProtos.NotificationsSubUpdateProto notificationsUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsUpdate();
    assertSame(unknownFields, notificationsUpdate.getUnknownFields());
    TransportProtos.TbEntitySubEventCallbackProto subEventCallback = toLocalSubscriptionServiceMsg
        .getSubEventCallback();
    assertSame(unknownFields, subEventCallback.getUnknownFields());
    TransportProtos.TbSubscriptionUpdateProto subUpdate = toLocalSubscriptionServiceMsg.getSubUpdate();
    assertSame(unknownFields, subUpdate.getUnknownFields());
    TransportProtos.TbAlarmDeleteProto alarmDelete = toSubscriptionMgrMsg.getAlarmDelete();
    assertSame(unknownFields, alarmDelete.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionProto alarmSub = toSubscriptionMgrMsg.getAlarmSub();
    assertSame(unknownFields, alarmSub.getUnknownFields());
    TransportProtos.TbAlarmUpdateProto alarmUpdate2 = toSubscriptionMgrMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate2.getUnknownFields());
    assertSame(unknownFields, attrDelete.getUnknownFields());
    TransportProtos.TbAttributeUpdateProto attrUpdate2 = toSubscriptionMgrMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate2.getUnknownFields());
    TransportProtos.TbAttributeSubscriptionProto attributeSub = toSubscriptionMgrMsg.getAttributeSub();
    assertSame(unknownFields, attributeSub.getUnknownFields());
    TransportProtos.NotificationRequestUpdateProto notificationRequestUpdate = toSubscriptionMgrMsg
        .getNotificationRequestUpdate();
    assertSame(unknownFields, notificationRequestUpdate.getUnknownFields());
    TransportProtos.NotificationUpdateProto notificationUpdate = toSubscriptionMgrMsg.getNotificationUpdate();
    assertSame(unknownFields, notificationUpdate.getUnknownFields());
    TransportProtos.NotificationsCountSubscriptionProto notificationsCountSub = toSubscriptionMgrMsg
        .getNotificationsCountSub();
    assertSame(unknownFields, notificationsCountSub.getUnknownFields());
    TransportProtos.NotificationsSubscriptionProto notificationsSub = toSubscriptionMgrMsg.getNotificationsSub();
    assertSame(unknownFields, notificationsSub.getUnknownFields());
    TransportProtos.TbSubscriptionCloseProto subClose = toSubscriptionMgrMsg.getSubClose();
    assertSame(unknownFields, subClose.getUnknownFields());
    assertSame(unknownFields, componentLifecycle.getUnknownFields());
    assertSame(unknownFields, coreStartupMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, edgeEventUpdate.getUnknownFields());
    assertSame(unknownFields, fromDeviceRpcResponse.getUnknownFields());
    assertSame(unknownFields, fromEdgeSyncResponse.getUnknownFields());
    assertSame(unknownFields, notificationRuleProcessorMsg.getUnknownFields());
    assertSame(unknownFields, resourceCacheInvalidateMsg.getUnknownFields());
    assertSame(unknownFields, restApiCallResponseMsg.getUnknownFields());
    assertSame(unknownFields, toEdgeSyncRequest.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg2.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg.getUnknownFields());
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.VersionControlResponseMsg vcResponseMsg = actualToAlarmSubUpdateToProtoResult.getVcResponseMsg();
    assertSame(unknownFields, vcResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg2.getAlarmSubUpdate());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg2.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, alarmSubUpdate.getDefaultInstanceForType());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg.getAlarmUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getAttrUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getAttrUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getTsUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getTsUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdateOrBuilder());
    assertSame(attrUpdate, attrUpdate.getDefaultInstanceForType());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg2.getNotificationsSubUpdate());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg2.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, notificationsSubUpdate.getDefaultInstanceForType());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg2.getNotificationsUpdate());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg2.getNotificationsUpdateOrBuilder());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg.getNotificationsUpdateOrBuilder());
    assertSame(notificationsUpdate, notificationsUpdate.getDefaultInstanceForType());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg2.getSubEventCallback());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg2.getSubEventCallbackOrBuilder());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg.getSubEventCallbackOrBuilder());
    assertSame(subEventCallback, subEventCallback.getDefaultInstanceForType());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg2.getSubUpdate());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg2.getSubUpdateOrBuilder());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg.getSubUpdateOrBuilder());
    assertSame(subUpdate, subUpdate.getDefaultInstanceForType());
    ByteString expectedResponse = notificationRuleProcessorMsg.getTrigger();
    assertSame(expectedResponse, restApiCallResponseMsg.getResponse());
    assertSame(alarmDelete, toSubscriptionMgrMsg.getAlarmDeleteOrBuilder());
    assertSame(alarmDelete, alarmDelete.getDefaultInstanceForType());
    assertSame(alarmSub, toSubscriptionMgrMsg.getAlarmSubOrBuilder());
    assertSame(alarmSub, alarmSub.getDefaultInstanceForType());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate2, alarmUpdate2.getDefaultInstanceForType());
    assertSame(attrDelete, toSubscriptionMgrMsg.getAttrDeleteOrBuilder());
    assertSame(attrDelete, attrDelete.getDefaultInstanceForType());
    assertSame(attrUpdate2, toSubscriptionMgrMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate2, attrUpdate2.getDefaultInstanceForType());
    assertSame(attributeSub, toSubscriptionMgrMsg.getAttributeSubOrBuilder());
    assertSame(attributeSub, attributeSub.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate, notificationRequestUpdate.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate, toSubscriptionMgrMsg.getNotificationRequestUpdateOrBuilder());
    assertSame(notificationUpdate, notificationUpdate.getDefaultInstanceForType());
    assertSame(notificationUpdate, toSubscriptionMgrMsg.getNotificationUpdateOrBuilder());
    assertSame(notificationsCountSub, notificationsCountSub.getDefaultInstanceForType());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg.getNotificationsCountSubOrBuilder());
    assertSame(notificationsSub, notificationsSub.getDefaultInstanceForType());
    assertSame(notificationsSub, toSubscriptionMgrMsg.getNotificationsSubOrBuilder());
    assertSame(subClose, toSubscriptionMgrMsg.getSubCloseOrBuilder());
    assertSame(subClose, subClose.getDefaultInstanceForType());
    assertSame(subEvent, toSubscriptionMgrMsg.getSubEventOrBuilder());
    assertSame(subEvent, subEvent.getDefaultInstanceForType());
    assertSame(componentLifecycle, componentLifecycle.getDefaultInstanceForType());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycle());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycleOrBuilder());
    assertSame(componentLifecycle, actualToAlarmSubUpdateToProtoResult.getComponentLifecycleOrBuilder());
    assertSame(coreStartupMsg, coreStartupMsg.getDefaultInstanceForType());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsg());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsgOrBuilder());
    assertSame(coreStartupMsg, actualToAlarmSubUpdateToProtoResult.getCoreStartupMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, edgeEventUpdate.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdate());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdateOrBuilder());
    assertSame(edgeEventUpdate, actualToAlarmSubUpdateToProtoResult.getEdgeEventUpdateOrBuilder());
    assertSame(fromDeviceRpcResponse, fromDeviceRpcResponse.getDefaultInstanceForType());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponse());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromDeviceRpcResponse, actualToAlarmSubUpdateToProtoResult.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, fromEdgeSyncResponse.getDefaultInstanceForType());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponse());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, actualToAlarmSubUpdateToProtoResult.getFromEdgeSyncResponseOrBuilder());
    assertSame(notificationRuleProcessorMsg, notificationRuleProcessorMsg.getDefaultInstanceForType());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsg());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(notificationRuleProcessorMsg,
        actualToAlarmSubUpdateToProtoResult.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg, resourceCacheInvalidateMsg.getDefaultInstanceForType());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsg());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg,
        actualToAlarmSubUpdateToProtoResult.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(restApiCallResponseMsg, restApiCallResponseMsg.getDefaultInstanceForType());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsg());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsgOrBuilder());
    assertSame(restApiCallResponseMsg, actualToAlarmSubUpdateToProtoResult.getRestApiCallResponseMsgOrBuilder());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequest());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, actualToAlarmSubUpdateToProtoResult.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, toEdgeSyncRequest.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, toLocalSubscriptionServiceMsg2.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, toLocalSubscriptionServiceMsg.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, defaultInstanceForType.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toLocalSubscriptionServiceMsg,
        actualToAlarmSubUpdateToProtoResult.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsg());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, actualToAlarmSubUpdateToProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsg());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, actualToAlarmSubUpdateToProtoResult.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, vcResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#notificationsSubUpdateToProto(EntityId, NotificationsSubscriptionUpdate)}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#notificationsSubUpdateToProto(EntityId, NotificationsSubscriptionUpdate)}
   */
  @Test
  @DisplayName("Test notificationsSubUpdateToProto(EntityId, NotificationsSubscriptionUpdate)")
  void testNotificationsSubUpdateToProto() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestUpdate notificationRequestUpdate = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();

    // Act
    TransportProtos.ToCoreNotificationMsg actualNotificationsSubUpdateToProtoResult = TbSubscriptionUtils
        .notificationsSubUpdateToProto(entityId, new NotificationsSubscriptionUpdate(notificationRequestUpdate));

    // Assert
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualNotificationsSubUpdateToProtoResult.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertEquals("", options.getInitializationErrorString());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg = actualNotificationsSubUpdateToProtoResult
        .getToLocalSubscriptionServiceMsg();
    TransportProtos.TbAlarmSubscriptionUpdateProto alarmSubUpdate = toLocalSubscriptionServiceMsg.getAlarmSubUpdate();
    assertEquals("", alarmSubUpdate.getInitializationErrorString());
    TransportProtos.TbAlarmSubUpdateProto alarmUpdate = toLocalSubscriptionServiceMsg.getAlarmUpdate();
    assertEquals("", alarmUpdate.getInitializationErrorString());
    TransportProtos.TbSubUpdateProto attrUpdate = toLocalSubscriptionServiceMsg.getAttrUpdate();
    assertEquals("", attrUpdate.getInitializationErrorString());
    TransportProtos.NotificationsSubscriptionUpdateProto notificationsSubUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsSubUpdate();
    assertEquals("", notificationsSubUpdate.getInitializationErrorString());
    TransportProtos.NotificationsSubUpdateProto notificationsUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsUpdate();
    assertEquals("", notificationsUpdate.getInitializationErrorString());
    TransportProtos.TbEntitySubEventCallbackProto subEventCallback = toLocalSubscriptionServiceMsg
        .getSubEventCallback();
    assertEquals("", subEventCallback.getInitializationErrorString());
    TransportProtos.TbSubscriptionUpdateProto subUpdate = toLocalSubscriptionServiceMsg.getSubUpdate();
    assertEquals("", subUpdate.getInitializationErrorString());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = actualNotificationsSubUpdateToProtoResult
        .getToSubscriptionMgrMsg();
    TransportProtos.TbAlarmDeleteProto alarmDelete = toSubscriptionMgrMsg.getAlarmDelete();
    assertEquals("", alarmDelete.getInitializationErrorString());
    TransportProtos.TbAlarmSubscriptionProto alarmSub = toSubscriptionMgrMsg.getAlarmSub();
    assertEquals("", alarmSub.getInitializationErrorString());
    TransportProtos.TbAlarmUpdateProto alarmUpdate2 = toSubscriptionMgrMsg.getAlarmUpdate();
    assertEquals("", alarmUpdate2.getInitializationErrorString());
    TransportProtos.TbAttributeDeleteProto attrDelete = toSubscriptionMgrMsg.getAttrDelete();
    assertEquals("", attrDelete.getInitializationErrorString());
    TransportProtos.TbAttributeUpdateProto attrUpdate2 = toSubscriptionMgrMsg.getAttrUpdate();
    assertEquals("", attrUpdate2.getInitializationErrorString());
    TransportProtos.TbAttributeSubscriptionProto attributeSub = toSubscriptionMgrMsg.getAttributeSub();
    assertEquals("", attributeSub.getInitializationErrorString());
    TransportProtos.NotificationRequestUpdateProto notificationRequestUpdate2 = toSubscriptionMgrMsg
        .getNotificationRequestUpdate();
    assertEquals("", notificationRequestUpdate2.getInitializationErrorString());
    TransportProtos.NotificationUpdateProto notificationUpdate = toSubscriptionMgrMsg.getNotificationUpdate();
    assertEquals("", notificationUpdate.getInitializationErrorString());
    TransportProtos.NotificationsCountSubscriptionProto notificationsCountSub = toSubscriptionMgrMsg
        .getNotificationsCountSub();
    assertEquals("", notificationsCountSub.getInitializationErrorString());
    TransportProtos.NotificationsSubscriptionProto notificationsSub = toSubscriptionMgrMsg.getNotificationsSub();
    assertEquals("", notificationsSub.getInitializationErrorString());
    TransportProtos.TbSubscriptionCloseProto subClose = toSubscriptionMgrMsg.getSubClose();
    assertEquals("", subClose.getInitializationErrorString());
    TransportProtos.TbEntitySubEventProto subEvent = toSubscriptionMgrMsg.getSubEvent();
    assertEquals("", subEvent.getInitializationErrorString());
    TransportProtos.ComponentLifecycleMsgProto componentLifecycle = actualNotificationsSubUpdateToProtoResult
        .getComponentLifecycle();
    assertEquals("", componentLifecycle.getInitializationErrorString());
    TransportProtos.CoreStartupMsg coreStartupMsg = actualNotificationsSubUpdateToProtoResult.getCoreStartupMsg();
    assertEquals("", coreStartupMsg.getInitializationErrorString());
    TransportProtos.ToCoreNotificationMsg defaultInstanceForType = actualNotificationsSubUpdateToProtoResult
        .getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    TransportProtos.EdgeEventUpdateMsgProto edgeEventUpdate = actualNotificationsSubUpdateToProtoResult
        .getEdgeEventUpdate();
    assertEquals("", edgeEventUpdate.getInitializationErrorString());
    TransportProtos.FromDeviceRPCResponseProto fromDeviceRpcResponse = actualNotificationsSubUpdateToProtoResult
        .getFromDeviceRpcResponse();
    assertEquals("", fromDeviceRpcResponse.getInitializationErrorString());
    TransportProtos.FromEdgeSyncResponseMsgProto fromEdgeSyncResponse = actualNotificationsSubUpdateToProtoResult
        .getFromEdgeSyncResponse();
    assertEquals("", fromEdgeSyncResponse.getInitializationErrorString());
    TransportProtos.NotificationRuleProcessorMsg notificationRuleProcessorMsg = actualNotificationsSubUpdateToProtoResult
        .getNotificationRuleProcessorMsg();
    assertEquals("", notificationRuleProcessorMsg.getInitializationErrorString());
    TransportProtos.ResourceCacheInvalidateMsg resourceCacheInvalidateMsg = actualNotificationsSubUpdateToProtoResult
        .getResourceCacheInvalidateMsg();
    assertEquals("", resourceCacheInvalidateMsg.getInitializationErrorString());
    TransportProtos.RestApiCallResponseMsgProto restApiCallResponseMsg = actualNotificationsSubUpdateToProtoResult
        .getRestApiCallResponseMsg();
    assertEquals("", restApiCallResponseMsg.getInitializationErrorString());
    TransportProtos.ToEdgeSyncRequestMsgProto toEdgeSyncRequest = actualNotificationsSubUpdateToProtoResult
        .getToEdgeSyncRequest();
    assertEquals("", toEdgeSyncRequest.getInitializationErrorString());
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg2 = defaultInstanceForType
        .getToLocalSubscriptionServiceMsg();
    assertEquals("", toLocalSubscriptionServiceMsg2.getInitializationErrorString());
    assertEquals("", toLocalSubscriptionServiceMsg.getInitializationErrorString());
    assertEquals("", toSubscriptionMgrMsg.getInitializationErrorString());
    TransportProtos.VersionControlResponseMsg vcResponseMsg = actualNotificationsSubUpdateToProtoResult
        .getVcResponseMsg();
    assertEquals("", vcResponseMsg.getInitializationErrorString());
    assertEquals("", actualNotificationsSubUpdateToProtoResult.getInitializationErrorString());
    ByteString serviceIdBytes = coreStartupMsg.getServiceIdBytes();
    assertEquals("", serviceIdBytes.toStringUtf8());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals("", file.getEditionName());
    assertEquals("", coreStartupMsg.getServiceId());
    assertEquals("", fromDeviceRpcResponse.getResponse());
    assertEquals("", fromEdgeSyncResponse.getError());
    assertEquals("", notificationRequestUpdate2.getUpdate());
    assertEquals("", notificationUpdate.getUpdate());
    assertEquals("", notificationsUpdate.getNotificationUpdate());
    assertEquals("", notificationsSubUpdate.getNotificationRequestUpdate());
    assertEquals("", notificationsSubUpdate.getNotificationUpdate());
    assertEquals("", notificationsSubUpdate.getSessionId());
    assertEquals("", alarmDelete.getAlarm());
    assertEquals("", alarmDelete.getEntityType());
    assertEquals("", alarmUpdate.getAlarm());
    assertEquals("", alarmUpdate.getErrorMsg());
    assertEquals("", alarmSubUpdate.getAlarm());
    assertEquals("", alarmSubUpdate.getErrorMsg());
    assertEquals("", alarmSubUpdate.getSessionId());
    assertEquals("", alarmUpdate2.getAlarm());
    assertEquals("", alarmUpdate2.getEntityType());
    assertEquals("", attrDelete.getEntityType());
    assertEquals("", attrDelete.getScope());
    assertEquals("", attributeSub.getScope());
    assertEquals("", attrUpdate2.getEntityType());
    assertEquals("", attrUpdate2.getScope());
    assertEquals("", subEvent.getEntityType());
    assertEquals("", subEvent.getServiceId());
    assertEquals("", attrUpdate.getErrorMsg());
    assertEquals("", attrUpdate.getScope());
    assertEquals("", subClose.getSessionId());
    assertEquals("", subUpdate.getErrorMsg());
    assertEquals("", subUpdate.getSessionId());
    assertEquals("", toEdgeSyncRequest.getServiceId());
    assertEquals("", vcResponseMsg.getError());
    Descriptors.Descriptor descriptorForType2 = componentLifecycle.getDescriptorForType();
    assertEquals("ComponentLifecycleMsgProto", descriptorForType2.getName());
    Descriptors.Descriptor descriptorForType3 = coreStartupMsg.getDescriptorForType();
    assertEquals("CoreStartupMsg", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = edgeEventUpdate.getDescriptorForType();
    assertEquals("EdgeEventUpdateMsgProto", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = fromDeviceRpcResponse.getDescriptorForType();
    assertEquals("FromDeviceRPCResponseProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = fromEdgeSyncResponse.getDescriptorForType();
    assertEquals("FromEdgeSyncResponseMsgProto", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toLocalSubscriptionServiceMsg.getDescriptorForType();
    assertEquals("LocalSubscriptionServiceMsgProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = notificationRuleProcessorMsg.getDescriptorForType();
    assertEquals("NotificationRuleProcessorMsg", descriptorForType8.getName());
    Descriptors.Descriptor descriptorForType9 = resourceCacheInvalidateMsg.getDescriptorForType();
    assertEquals("ResourceCacheInvalidateMsg", descriptorForType9.getName());
    Descriptors.Descriptor descriptorForType10 = restApiCallResponseMsg.getDescriptorForType();
    assertEquals("RestApiCallResponseMsgProto", descriptorForType10.getName());
    Descriptors.Descriptor descriptorForType11 = toSubscriptionMgrMsg.getDescriptorForType();
    assertEquals("SubscriptionMgrMsgProto", descriptorForType11.getName());
    assertEquals("ToCoreNotificationMsg", toProtoResult.getName());
    assertEquals("ToCoreNotificationMsg", descriptorForType.getName());
    Descriptors.Descriptor descriptorForType12 = toEdgeSyncRequest.getDescriptorForType();
    assertEquals("ToEdgeSyncRequestMsgProto", descriptorForType12.getName());
    assertEquals("queue.proto", file.getFullName());
    assertEquals("queue.proto", file.getName());
    assertEquals("transport", file.getPackage());
    assertEquals("transport.ComponentLifecycleMsgProto", descriptorForType2.getFullName());
    assertEquals("transport.CoreStartupMsg", descriptorForType3.getFullName());
    assertEquals("transport.EdgeEventUpdateMsgProto", descriptorForType4.getFullName());
    assertEquals("transport.FromDeviceRPCResponseProto", descriptorForType5.getFullName());
    assertEquals("transport.FromEdgeSyncResponseMsgProto", descriptorForType6.getFullName());
    assertEquals("transport.LocalSubscriptionServiceMsgProto", descriptorForType7.getFullName());
    assertEquals("transport.NotificationRuleProcessorMsg", descriptorForType8.getFullName());
    assertEquals("transport.ResourceCacheInvalidateMsg", descriptorForType9.getFullName());
    assertEquals("transport.RestApiCallResponseMsgProto", descriptorForType10.getFullName());
    assertEquals("transport.SubscriptionMgrMsgProto", descriptorForType11.getFullName());
    assertEquals("transport.ToCoreNotificationMsg", descriptorForType.getFullName());
    assertEquals("transport.ToEdgeSyncRequestMsgProto", descriptorForType12.getFullName());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType9.getContainingType());
    assertNull(descriptorForType10.getContainingType());
    assertNull(descriptorForType12.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType11.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, options.getSerializedSize());
    assertEquals(0, options.getUninterpretedOptionCount());
    UnknownFieldSet unknownFields = actualNotificationsSubUpdateToProtoResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, componentLifecycle.getEntityTypeValue());
    assertEquals(0, componentLifecycle.getEventValue());
    assertEquals(0, componentLifecycle.getSerializedSize());
    assertEquals(0, coreStartupMsg.getPartitionsCount());
    assertEquals(0, coreStartupMsg.getSerializedSize());
    assertEquals(0, edgeEventUpdate.getSerializedSize());
    assertEquals(0, fromDeviceRpcResponse.getError());
    assertEquals(0, fromDeviceRpcResponse.getSerializedSize());
    assertEquals(0, fromEdgeSyncResponse.getSerializedSize());
    assertEquals(0, toLocalSubscriptionServiceMsg2.getSerializedSize());
    assertEquals(0, notificationRequestUpdate2.getSerializedSize());
    assertEquals(0, notificationRuleProcessorMsg.getSerializedSize());
    assertEquals(0, notificationUpdate.getSerializedSize());
    assertEquals(0, notificationsCountSub.getSerializedSize());
    assertEquals(0, notificationsSub.getLimit());
    assertEquals(0, notificationsSub.getSerializedSize());
    assertEquals(0, notificationsSubUpdate.getSerializedSize());
    assertEquals(0, notificationsSubUpdate.getSubscriptionId());
    assertEquals(0, resourceCacheInvalidateMsg.getKeysCount());
    assertEquals(0, resourceCacheInvalidateMsg.getSerializedSize());
    assertEquals(0, restApiCallResponseMsg.getSerializedSize());
    assertEquals(0, toSubscriptionMgrMsg.getSerializedSize());
    assertEquals(0, alarmDelete.getSerializedSize());
    assertEquals(0, alarmUpdate.getErrorCode());
    assertEquals(0, alarmUpdate.getSerializedSize());
    assertEquals(0, alarmSub.getSerializedSize());
    assertEquals(0, alarmSubUpdate.getErrorCode());
    assertEquals(0, alarmSubUpdate.getSerializedSize());
    assertEquals(0, alarmSubUpdate.getSubscriptionId());
    assertEquals(0, alarmUpdate2.getSerializedSize());
    assertEquals(0, attrDelete.getKeysCount());
    assertEquals(0, attrDelete.getSerializedSize());
    assertEquals(0, attributeSub.getKeyStatesCount());
    assertEquals(0, attributeSub.getSerializedSize());
    assertEquals(0, attrUpdate2.getDataCount());
    assertEquals(0, attrUpdate2.getSerializedSize());
    assertEquals(0, subEventCallback.getSeqNumber());
    assertEquals(0, subEventCallback.getSerializedSize());
    assertEquals(0, subEvent.getAttrKeysCount());
    assertEquals(0, subEvent.getSeqNumber());
    assertEquals(0, subEvent.getSerializedSize());
    assertEquals(0, subEvent.getTsKeysCount());
    assertEquals(0, attrUpdate.getDataCount());
    assertEquals(0, attrUpdate.getErrorCode());
    assertEquals(0, attrUpdate.getSerializedSize());
    assertEquals(0, subClose.getSerializedSize());
    assertEquals(0, subClose.getSubscriptionId());
    assertEquals(0, subUpdate.getDataCount());
    assertEquals(0, subUpdate.getErrorCode());
    assertEquals(0, subUpdate.getSerializedSize());
    assertEquals(0, subUpdate.getSubscriptionId());
    assertEquals(0, defaultInstanceForType.getQueueDeleteMsgsCount());
    assertEquals(0, actualNotificationsSubUpdateToProtoResult.getQueueDeleteMsgsCount());
    assertEquals(0, defaultInstanceForType.getQueueUpdateMsgsCount());
    assertEquals(0, actualNotificationsSubUpdateToProtoResult.getQueueUpdateMsgsCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, toEdgeSyncRequest.getSerializedSize());
    assertEquals(0, vcResponseMsg.getSerializedSize());
    assertEquals(0L, componentLifecycle.getEntityIdLSB());
    assertEquals(0L, componentLifecycle.getEntityIdMSB());
    assertEquals(0L, componentLifecycle.getTenantIdLSB());
    assertEquals(0L, componentLifecycle.getTenantIdMSB());
    assertEquals(0L, coreStartupMsg.getTs());
    assertEquals(0L, edgeEventUpdate.getEdgeIdLSB());
    assertEquals(0L, edgeEventUpdate.getEdgeIdMSB());
    assertEquals(0L, edgeEventUpdate.getTenantIdLSB());
    assertEquals(0L, edgeEventUpdate.getTenantIdMSB());
    assertEquals(0L, fromDeviceRpcResponse.getRequestIdLSB());
    assertEquals(0L, fromDeviceRpcResponse.getRequestIdMSB());
    assertEquals(0L, fromEdgeSyncResponse.getEdgeIdLSB());
    assertEquals(0L, fromEdgeSyncResponse.getEdgeIdMSB());
    assertEquals(0L, fromEdgeSyncResponse.getResponseIdLSB());
    assertEquals(0L, fromEdgeSyncResponse.getResponseIdMSB());
    assertEquals(0L, fromEdgeSyncResponse.getTenantIdLSB());
    assertEquals(0L, fromEdgeSyncResponse.getTenantIdMSB());
    assertEquals(0L, notificationRequestUpdate2.getTenantIdLSB());
    assertEquals(0L, notificationRequestUpdate2.getTenantIdMSB());
    assertEquals(0L, notificationUpdate.getRecipientIdLSB());
    assertEquals(0L, notificationUpdate.getRecipientIdMSB());
    assertEquals(0L, notificationUpdate.getTenantIdLSB());
    assertEquals(0L, notificationUpdate.getTenantIdMSB());
    assertEquals(0L, resourceCacheInvalidateMsg.getTenantIdLSB());
    assertEquals(0L, resourceCacheInvalidateMsg.getTenantIdMSB());
    assertEquals(0L, restApiCallResponseMsg.getRequestIdLSB());
    assertEquals(0L, restApiCallResponseMsg.getRequestIdMSB());
    assertEquals(0L, alarmDelete.getEntityIdLSB());
    assertEquals(0L, alarmDelete.getEntityIdMSB());
    assertEquals(0L, alarmDelete.getTenantIdLSB());
    assertEquals(0L, alarmDelete.getTenantIdMSB());
    assertEquals(0L, alarmUpdate.getEntityIdLSB());
    assertEquals(0L, alarmUpdate.getEntityIdMSB());
    assertEquals(0L, alarmSub.getTs());
    assertEquals(0L, alarmUpdate2.getEntityIdLSB());
    assertEquals(0L, alarmUpdate2.getEntityIdMSB());
    assertEquals(0L, alarmUpdate2.getTenantIdLSB());
    assertEquals(0L, alarmUpdate2.getTenantIdMSB());
    assertEquals(0L, attrDelete.getEntityIdLSB());
    assertEquals(0L, attrDelete.getEntityIdMSB());
    assertEquals(0L, attrDelete.getTenantIdLSB());
    assertEquals(0L, attrDelete.getTenantIdMSB());
    assertEquals(0L, attrUpdate2.getEntityIdLSB());
    assertEquals(0L, attrUpdate2.getEntityIdMSB());
    assertEquals(0L, attrUpdate2.getTenantIdLSB());
    assertEquals(0L, attrUpdate2.getTenantIdMSB());
    assertEquals(0L, subEventCallback.getAttributesUpdateTs());
    assertEquals(0L, subEventCallback.getEntityIdLSB());
    assertEquals(0L, subEventCallback.getEntityIdMSB());
    assertEquals(0L, subEventCallback.getTenantIdLSB());
    assertEquals(0L, subEventCallback.getTenantIdMSB());
    assertEquals(0L, subEventCallback.getTimeSeriesUpdateTs());
    assertEquals(0L, subEvent.getEntityIdLSB());
    assertEquals(0L, subEvent.getEntityIdMSB());
    assertEquals(0L, subEvent.getTenantIdLSB());
    assertEquals(0L, subEvent.getTenantIdMSB());
    assertEquals(0L, attrUpdate.getEntityIdLSB());
    assertEquals(0L, attrUpdate.getEntityIdMSB());
    assertEquals(0L, toEdgeSyncRequest.getEdgeIdLSB());
    assertEquals(0L, toEdgeSyncRequest.getEdgeIdMSB());
    assertEquals(0L, toEdgeSyncRequest.getRequestIdLSB());
    assertEquals(0L, toEdgeSyncRequest.getRequestIdMSB());
    assertEquals(0L, toEdgeSyncRequest.getTenantIdLSB());
    assertEquals(0L, toEdgeSyncRequest.getTenantIdMSB());
    assertEquals(0L, vcResponseMsg.getRequestIdLSB());
    assertEquals(0L, vcResponseMsg.getRequestIdMSB());
    assertEquals(1, toLocalSubscriptionServiceMsg.getAllFields().size());
    assertEquals(1, actualNotificationsSubUpdateToProtoResult.getAllFields().size());
    assertEquals(117, descriptorForType11.getIndex());
    assertEquals(118, descriptorForType7.getIndex());
    assertEquals(119, descriptorForType5.getIndex());
    assertEquals(120, descriptorForType2.getIndex());
    assertEquals(123, descriptorForType4.getIndex());
    assertEquals(124, descriptorForType12.getIndex());
    assertEquals(125, descriptorForType6.getIndex());
    assertEquals(14, toProtoResult.getFieldCount());
    assertEquals(14, descriptorForType.getFields().size());
    assertEquals(165, descriptorForType.getIndex());
    assertEquals(175, descriptorForType8.getIndex());
    assertEquals(3, descriptorForType10.getIndex());
    assertEquals(36, descriptorForType3.getIndex());
    assertEquals(37, descriptorForType9.getIndex());
    assertEquals(961, toProtoResult.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(TransportProtos.ComponentLifecycleEvent.CREATED, componentLifecycle.getEvent());
    assertEquals(TransportProtos.EntityTypeProto.UNSPECIFIED, componentLifecycle.getEntityType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(options.getDeprecated());
    assertFalse(options.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.getMapEntry());
    assertFalse(options.getMessageSetWireFormat());
    assertFalse(options.getNoStandardDescriptorAccessor());
    assertFalse(options.hasDeprecated());
    assertFalse(options.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.hasFeatures());
    assertFalse(options.hasMapEntry());
    assertFalse(options.hasMessageSetWireFormat());
    assertFalse(options.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType4.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType6.isExtendable());
    assertFalse(descriptorForType8.isExtendable());
    assertFalse(descriptorForType9.isExtendable());
    assertFalse(descriptorForType10.isExtendable());
    assertFalse(descriptorForType12.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType11.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(serviceIdBytes.iterator().hasNext());
    assertFalse(fromEdgeSyncResponse.getSuccess());
    assertFalse(toLocalSubscriptionServiceMsg2.hasAlarmSubUpdate());
    assertFalse(toLocalSubscriptionServiceMsg.hasAlarmSubUpdate());
    assertFalse(toLocalSubscriptionServiceMsg2.hasAlarmUpdate());
    assertFalse(toLocalSubscriptionServiceMsg.hasAlarmUpdate());
    assertFalse(toLocalSubscriptionServiceMsg2.hasAttrUpdate());
    assertFalse(toLocalSubscriptionServiceMsg.hasAttrUpdate());
    assertFalse(toLocalSubscriptionServiceMsg2.hasNotificationsSubUpdate());
    assertFalse(toLocalSubscriptionServiceMsg.hasNotificationsSubUpdate());
    assertFalse(toLocalSubscriptionServiceMsg2.hasNotificationsUpdate());
    assertFalse(toLocalSubscriptionServiceMsg2.hasSubEventCallback());
    assertFalse(toLocalSubscriptionServiceMsg.hasSubEventCallback());
    assertFalse(toLocalSubscriptionServiceMsg2.hasSubUpdate());
    assertFalse(toLocalSubscriptionServiceMsg.hasSubUpdate());
    assertFalse(toLocalSubscriptionServiceMsg2.hasTsUpdate());
    assertFalse(toLocalSubscriptionServiceMsg.hasTsUpdate());
    assertFalse(notificationsCountSub.hasSub());
    assertFalse(notificationsSub.hasSub());
    assertFalse(toSubscriptionMgrMsg.hasAlarmDelete());
    assertFalse(toSubscriptionMgrMsg.hasAlarmSub());
    assertFalse(toSubscriptionMgrMsg.hasAlarmUpdate());
    assertFalse(toSubscriptionMgrMsg.hasAttrDelete());
    assertFalse(toSubscriptionMgrMsg.hasAttrUpdate());
    assertFalse(toSubscriptionMgrMsg.hasAttributeSub());
    assertFalse(toSubscriptionMgrMsg.hasNotificationRequestUpdate());
    assertFalse(toSubscriptionMgrMsg.hasNotificationUpdate());
    assertFalse(toSubscriptionMgrMsg.hasNotificationsCountSub());
    assertFalse(toSubscriptionMgrMsg.hasNotificationsSub());
    assertFalse(toSubscriptionMgrMsg.hasSubClose());
    assertFalse(toSubscriptionMgrMsg.hasSubEvent());
    assertFalse(toSubscriptionMgrMsg.hasTelemetrySub());
    assertFalse(toSubscriptionMgrMsg.hasTsDelete());
    assertFalse(toSubscriptionMgrMsg.hasTsUpdate());
    assertFalse(alarmUpdate.getDeleted());
    assertFalse(alarmSub.hasSub());
    assertFalse(alarmSubUpdate.getDeleted());
    assertFalse(attrDelete.getNotifyDevice());
    assertFalse(attributeSub.getAllKeys());
    assertFalse(attributeSub.hasSub());
    assertFalse(subEvent.getAlarms());
    assertFalse(subEvent.getAttrAllKeys());
    assertFalse(subEvent.getNotifications());
    assertFalse(subEvent.getTsAllKeys());
    assertFalse(defaultInstanceForType.hasComponentLifecycle());
    assertFalse(actualNotificationsSubUpdateToProtoResult.hasComponentLifecycle());
    assertFalse(defaultInstanceForType.hasCoreStartupMsg());
    assertFalse(actualNotificationsSubUpdateToProtoResult.hasCoreStartupMsg());
    assertFalse(defaultInstanceForType.hasEdgeEventUpdate());
    assertFalse(actualNotificationsSubUpdateToProtoResult.hasEdgeEventUpdate());
    assertFalse(defaultInstanceForType.hasFromDeviceRpcResponse());
    assertFalse(actualNotificationsSubUpdateToProtoResult.hasFromDeviceRpcResponse());
    assertFalse(defaultInstanceForType.hasFromEdgeSyncResponse());
    assertFalse(actualNotificationsSubUpdateToProtoResult.hasFromEdgeSyncResponse());
    assertFalse(defaultInstanceForType.hasNotificationRuleProcessorMsg());
    assertFalse(actualNotificationsSubUpdateToProtoResult.hasNotificationRuleProcessorMsg());
    assertFalse(defaultInstanceForType.hasResourceCacheInvalidateMsg());
    assertFalse(actualNotificationsSubUpdateToProtoResult.hasResourceCacheInvalidateMsg());
    assertFalse(defaultInstanceForType.hasRestApiCallResponseMsg());
    assertFalse(actualNotificationsSubUpdateToProtoResult.hasRestApiCallResponseMsg());
    assertFalse(defaultInstanceForType.hasToEdgeSyncRequest());
    assertFalse(actualNotificationsSubUpdateToProtoResult.hasToEdgeSyncRequest());
    assertFalse(defaultInstanceForType.hasToLocalSubscriptionServiceMsg());
    assertFalse(defaultInstanceForType.hasToSubscriptionMgrMsg());
    assertFalse(actualNotificationsSubUpdateToProtoResult.hasToSubscriptionMgrMsg());
    assertFalse(defaultInstanceForType.hasVcResponseMsg());
    assertFalse(actualNotificationsSubUpdateToProtoResult.hasVcResponseMsg());
    assertFalse(vcResponseMsg.hasCommitResponse());
    assertFalse(vcResponseMsg.hasEntitiesContentResponse());
    assertFalse(vcResponseMsg.hasEntityContentResponse());
    assertFalse(vcResponseMsg.hasGenericResponse());
    assertFalse(vcResponseMsg.hasListBranchesResponse());
    assertFalse(vcResponseMsg.hasListEntitiesResponse());
    assertFalse(vcResponseMsg.hasListVersionsResponse());
    assertFalse(vcResponseMsg.hasVersionsDiffResponse());
    assertTrue(serviceIdBytes.isEmpty());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(unknownFields.isInitialized());
    assertTrue(componentLifecycle.findInitializationErrors().isEmpty());
    assertTrue(coreStartupMsg.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(edgeEventUpdate.findInitializationErrors().isEmpty());
    assertTrue(fromDeviceRpcResponse.findInitializationErrors().isEmpty());
    assertTrue(fromEdgeSyncResponse.findInitializationErrors().isEmpty());
    assertTrue(notificationRuleProcessorMsg.findInitializationErrors().isEmpty());
    assertTrue(resourceCacheInvalidateMsg.findInitializationErrors().isEmpty());
    assertTrue(restApiCallResponseMsg.findInitializationErrors().isEmpty());
    assertTrue(toEdgeSyncRequest.findInitializationErrors().isEmpty());
    assertTrue(toLocalSubscriptionServiceMsg.findInitializationErrors().isEmpty());
    assertTrue(toSubscriptionMgrMsg.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualNotificationsSubUpdateToProtoResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(coreStartupMsg.getPartitionsList().isEmpty());
    List<TransportProtos.QueueDeleteMsg> queueDeleteMsgsList = actualNotificationsSubUpdateToProtoResult
        .getQueueDeleteMsgsList();
    assertTrue(queueDeleteMsgsList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = componentLifecycle.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(coreStartupMsg.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(edgeEventUpdate.getAllFields().isEmpty());
    assertTrue(fromDeviceRpcResponse.getAllFields().isEmpty());
    assertTrue(fromEdgeSyncResponse.getAllFields().isEmpty());
    assertTrue(notificationRuleProcessorMsg.getAllFields().isEmpty());
    assertTrue(resourceCacheInvalidateMsg.getAllFields().isEmpty());
    assertTrue(restApiCallResponseMsg.getAllFields().isEmpty());
    assertTrue(toEdgeSyncRequest.getAllFields().isEmpty());
    assertTrue(toSubscriptionMgrMsg.getAllFields().isEmpty());
    assertTrue(componentLifecycle.isInitialized());
    assertTrue(coreStartupMsg.isInitialized());
    assertTrue(edgeEventUpdate.isInitialized());
    assertTrue(fromDeviceRpcResponse.isInitialized());
    assertTrue(fromEdgeSyncResponse.isInitialized());
    assertTrue(toLocalSubscriptionServiceMsg.hasNotificationsUpdate());
    assertTrue(toLocalSubscriptionServiceMsg2.isInitialized());
    assertTrue(toLocalSubscriptionServiceMsg.isInitialized());
    assertTrue(notificationRequestUpdate2.isInitialized());
    assertTrue(notificationRuleProcessorMsg.isInitialized());
    assertTrue(notificationUpdate.isInitialized());
    assertTrue(notificationsCountSub.isInitialized());
    assertTrue(notificationsUpdate.isInitialized());
    assertTrue(notificationsSub.isInitialized());
    assertTrue(notificationsSubUpdate.isInitialized());
    assertTrue(resourceCacheInvalidateMsg.isInitialized());
    assertTrue(restApiCallResponseMsg.isInitialized());
    assertTrue(toSubscriptionMgrMsg.isInitialized());
    assertTrue(alarmDelete.isInitialized());
    assertTrue(alarmUpdate.isInitialized());
    assertTrue(alarmSub.isInitialized());
    assertTrue(alarmSubUpdate.isInitialized());
    assertTrue(alarmUpdate2.isInitialized());
    assertTrue(attrDelete.isInitialized());
    assertTrue(attributeSub.isInitialized());
    assertTrue(attrUpdate2.isInitialized());
    assertTrue(subEventCallback.isInitialized());
    assertTrue(attrUpdate.isInitialized());
    assertTrue(subClose.isInitialized());
    assertTrue(subUpdate.isInitialized());
    assertTrue(actualNotificationsSubUpdateToProtoResult.hasToLocalSubscriptionServiceMsg());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(actualNotificationsSubUpdateToProtoResult.isInitialized());
    assertTrue(toEdgeSyncRequest.isInitialized());
    assertTrue(vcResponseMsg.isInitialized());
    assertEquals(findInitializationErrorsResult, options.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, alarmSubUpdate.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, alarmUpdate.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, attrUpdate.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, notificationsSubUpdate.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, notificationsUpdate.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, subEventCallback.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, subUpdate.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, alarmDelete.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, alarmSub.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, alarmUpdate2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, attrDelete.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, attrUpdate2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, attributeSub.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, notificationRequestUpdate2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, notificationUpdate.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, notificationsCountSub.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, notificationsSub.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, subClose.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, subEvent.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toLocalSubscriptionServiceMsg2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, vcResponseMsg.findInitializationErrors());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertEquals(findInitializationErrorsResult, reservedNameList);
    assertEquals(findInitializationErrorsResult, descriptorForType2.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType12.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType11.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType12.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType11.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType12.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType11.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType12.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType11.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType12.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType11.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file.getDependencies());
    assertEquals(findInitializationErrorsResult, file.getExtensions());
    assertEquals(findInitializationErrorsResult, file.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file.getServices());
    assertEquals(allFields, alarmSubUpdate.getAllFields());
    assertEquals(allFields, alarmUpdate.getAllFields());
    assertEquals(allFields, attrUpdate.getAllFields());
    assertEquals(allFields, notificationsSubUpdate.getAllFields());
    assertEquals(allFields, subEventCallback.getAllFields());
    assertEquals(allFields, subUpdate.getAllFields());
    assertEquals(allFields, alarmDelete.getAllFields());
    assertEquals(allFields, alarmSub.getAllFields());
    assertEquals(allFields, alarmUpdate2.getAllFields());
    assertEquals(allFields, attrDelete.getAllFields());
    assertEquals(allFields, attrUpdate2.getAllFields());
    assertEquals(allFields, attributeSub.getAllFields());
    assertEquals(allFields, notificationRequestUpdate2.getAllFields());
    assertEquals(allFields, notificationUpdate.getAllFields());
    assertEquals(allFields, notificationsCountSub.getAllFields());
    assertEquals(allFields, notificationsSub.getAllFields());
    assertEquals(allFields, subClose.getAllFields());
    assertEquals(allFields, subEvent.getAllFields());
    assertEquals(allFields, toLocalSubscriptionServiceMsg2.getAllFields());
    assertEquals(allFields, vcResponseMsg.getAllFields());
    assertEquals(allFields, options.getAllFields());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(serviceIdBytes, fromDeviceRpcResponse.getResponseBytes());
    assertEquals(serviceIdBytes, fromEdgeSyncResponse.getErrorBytes());
    assertEquals(serviceIdBytes, notificationRequestUpdate2.getUpdateBytes());
    ByteString trigger = notificationRuleProcessorMsg.getTrigger();
    assertEquals(serviceIdBytes, trigger);
    assertEquals(serviceIdBytes, notificationUpdate.getUpdateBytes());
    assertEquals(serviceIdBytes, notificationsUpdate.getNotificationUpdateBytes());
    assertEquals(serviceIdBytes, notificationsSubUpdate.getNotificationRequestUpdateBytes());
    assertEquals(serviceIdBytes, notificationsSubUpdate.getNotificationUpdateBytes());
    assertEquals(serviceIdBytes, notificationsSubUpdate.getSessionIdBytes());
    assertEquals(serviceIdBytes, alarmDelete.getAlarmBytes());
    assertEquals(serviceIdBytes, alarmDelete.getEntityTypeBytes());
    assertEquals(serviceIdBytes, alarmUpdate.getAlarmBytes());
    assertEquals(serviceIdBytes, alarmUpdate.getErrorMsgBytes());
    assertEquals(serviceIdBytes, alarmSubUpdate.getAlarmBytes());
    assertEquals(serviceIdBytes, alarmSubUpdate.getErrorMsgBytes());
    assertEquals(serviceIdBytes, alarmSubUpdate.getSessionIdBytes());
    assertEquals(serviceIdBytes, alarmUpdate2.getAlarmBytes());
    assertEquals(serviceIdBytes, alarmUpdate2.getEntityTypeBytes());
    assertEquals(serviceIdBytes, attrDelete.getEntityTypeBytes());
    assertEquals(serviceIdBytes, attrDelete.getScopeBytes());
    assertEquals(serviceIdBytes, attributeSub.getScopeBytes());
    assertEquals(serviceIdBytes, attrUpdate2.getEntityTypeBytes());
    assertEquals(serviceIdBytes, attrUpdate2.getScopeBytes());
    assertEquals(serviceIdBytes, subEvent.getEntityTypeBytes());
    assertEquals(serviceIdBytes, subEvent.getServiceIdBytes());
    assertEquals(serviceIdBytes, attrUpdate.getErrorMsgBytes());
    assertEquals(serviceIdBytes, attrUpdate.getScopeBytes());
    assertEquals(serviceIdBytes, subClose.getSessionIdBytes());
    assertEquals(serviceIdBytes, subUpdate.getErrorMsgBytes());
    assertEquals(serviceIdBytes, subUpdate.getSessionIdBytes());
    assertEquals(serviceIdBytes, toEdgeSyncRequest.getServiceIdBytes());
    assertEquals(serviceIdBytes, vcResponseMsg.getErrorBytes());
    assertSame(reservedNameList, attrDelete.getKeysList());
    assertSame(reservedNameList, subEvent.getAttrKeysList());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    assertSame(file, descriptorForType6.getFile());
    assertSame(file, descriptorForType8.getFile());
    assertSame(file, descriptorForType9.getFile());
    assertSame(file, descriptorForType10.getFile());
    assertSame(file, descriptorForType12.getFile());
    assertSame(file, descriptorForType7.getFile());
    assertSame(file, descriptorForType11.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options, descriptorForType2.getOptions());
    assertSame(options, descriptorForType3.getOptions());
    assertSame(options, descriptorForType4.getOptions());
    assertSame(options, descriptorForType5.getOptions());
    assertSame(options, descriptorForType6.getOptions());
    assertSame(options, descriptorForType8.getOptions());
    assertSame(options, descriptorForType9.getOptions());
    assertSame(options, descriptorForType10.getOptions());
    assertSame(options, descriptorForType12.getOptions());
    assertSame(options, descriptorForType7.getOptions());
    assertSame(options, descriptorForType11.getOptions());
    assertSame(descriptorForType7, toLocalSubscriptionServiceMsg2.getDescriptorForType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, alarmSubUpdate.getUnknownFields());
    assertSame(unknownFields, alarmUpdate.getUnknownFields());
    assertSame(unknownFields, attrUpdate.getUnknownFields());
    assertSame(unknownFields, notificationsSubUpdate.getUnknownFields());
    assertSame(unknownFields, notificationsUpdate.getUnknownFields());
    assertSame(unknownFields, subEventCallback.getUnknownFields());
    assertSame(unknownFields, subUpdate.getUnknownFields());
    assertSame(unknownFields, alarmDelete.getUnknownFields());
    assertSame(unknownFields, alarmSub.getUnknownFields());
    assertSame(unknownFields, alarmUpdate2.getUnknownFields());
    assertSame(unknownFields, attrDelete.getUnknownFields());
    assertSame(unknownFields, attrUpdate2.getUnknownFields());
    assertSame(unknownFields, attributeSub.getUnknownFields());
    assertSame(unknownFields, notificationRequestUpdate2.getUnknownFields());
    assertSame(unknownFields, notificationUpdate.getUnknownFields());
    assertSame(unknownFields, notificationsCountSub.getUnknownFields());
    assertSame(unknownFields, notificationsSub.getUnknownFields());
    assertSame(unknownFields, subClose.getUnknownFields());
    assertSame(unknownFields, componentLifecycle.getUnknownFields());
    assertSame(unknownFields, coreStartupMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, edgeEventUpdate.getUnknownFields());
    assertSame(unknownFields, fromDeviceRpcResponse.getUnknownFields());
    assertSame(unknownFields, fromEdgeSyncResponse.getUnknownFields());
    assertSame(unknownFields, notificationRuleProcessorMsg.getUnknownFields());
    assertSame(unknownFields, resourceCacheInvalidateMsg.getUnknownFields());
    assertSame(unknownFields, restApiCallResponseMsg.getUnknownFields());
    assertSame(unknownFields, toEdgeSyncRequest.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg2.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg.getUnknownFields());
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    assertSame(unknownFields, vcResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg2.getAlarmSubUpdate());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg2.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, alarmSubUpdate.getDefaultInstanceForType());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg2.getAlarmUpdate());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg2.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate, alarmUpdate.getDefaultInstanceForType());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getAttrUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getAttrUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getTsUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg2.getTsUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdateOrBuilder());
    assertSame(attrUpdate, attrUpdate.getDefaultInstanceForType());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg2.getNotificationsSubUpdate());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg2.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, notificationsSubUpdate.getDefaultInstanceForType());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg.getNotificationsUpdateOrBuilder());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg2.getSubEventCallback());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg2.getSubEventCallbackOrBuilder());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg.getSubEventCallbackOrBuilder());
    assertSame(subEventCallback, subEventCallback.getDefaultInstanceForType());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg2.getSubUpdate());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg2.getSubUpdateOrBuilder());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg.getSubUpdateOrBuilder());
    assertSame(subUpdate, subUpdate.getDefaultInstanceForType());
    assertSame(trigger, restApiCallResponseMsg.getResponse());
    assertSame(alarmDelete, toSubscriptionMgrMsg.getAlarmDeleteOrBuilder());
    assertSame(alarmDelete, alarmDelete.getDefaultInstanceForType());
    assertSame(alarmSub, toSubscriptionMgrMsg.getAlarmSubOrBuilder());
    assertSame(alarmSub, alarmSub.getDefaultInstanceForType());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate2, alarmUpdate2.getDefaultInstanceForType());
    assertSame(attrDelete, toSubscriptionMgrMsg.getAttrDeleteOrBuilder());
    assertSame(attrDelete, attrDelete.getDefaultInstanceForType());
    assertSame(attrUpdate2, toSubscriptionMgrMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate2, attrUpdate2.getDefaultInstanceForType());
    assertSame(attributeSub, toSubscriptionMgrMsg.getAttributeSubOrBuilder());
    assertSame(attributeSub, attributeSub.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate2, notificationRequestUpdate2.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate2, toSubscriptionMgrMsg.getNotificationRequestUpdateOrBuilder());
    assertSame(notificationUpdate, notificationUpdate.getDefaultInstanceForType());
    assertSame(notificationUpdate, toSubscriptionMgrMsg.getNotificationUpdateOrBuilder());
    assertSame(notificationsCountSub, notificationsCountSub.getDefaultInstanceForType());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg.getNotificationsCountSubOrBuilder());
    assertSame(notificationsSub, notificationsSub.getDefaultInstanceForType());
    assertSame(notificationsSub, toSubscriptionMgrMsg.getNotificationsSubOrBuilder());
    assertSame(subClose, toSubscriptionMgrMsg.getSubCloseOrBuilder());
    assertSame(subClose, subClose.getDefaultInstanceForType());
    assertSame(subEvent, toSubscriptionMgrMsg.getSubEventOrBuilder());
    assertSame(subEvent, subEvent.getDefaultInstanceForType());
    assertSame(componentLifecycle, componentLifecycle.getDefaultInstanceForType());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycle());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycleOrBuilder());
    assertSame(componentLifecycle, actualNotificationsSubUpdateToProtoResult.getComponentLifecycleOrBuilder());
    assertSame(coreStartupMsg, coreStartupMsg.getDefaultInstanceForType());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsg());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsgOrBuilder());
    assertSame(coreStartupMsg, actualNotificationsSubUpdateToProtoResult.getCoreStartupMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, edgeEventUpdate.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdate());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdateOrBuilder());
    assertSame(edgeEventUpdate, actualNotificationsSubUpdateToProtoResult.getEdgeEventUpdateOrBuilder());
    assertSame(fromDeviceRpcResponse, fromDeviceRpcResponse.getDefaultInstanceForType());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponse());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromDeviceRpcResponse, actualNotificationsSubUpdateToProtoResult.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, fromEdgeSyncResponse.getDefaultInstanceForType());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponse());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, actualNotificationsSubUpdateToProtoResult.getFromEdgeSyncResponseOrBuilder());
    assertSame(notificationRuleProcessorMsg, notificationRuleProcessorMsg.getDefaultInstanceForType());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsg());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(notificationRuleProcessorMsg,
        actualNotificationsSubUpdateToProtoResult.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(queueDeleteMsgsList, toProtoResult.getEnumTypeList());
    assertSame(queueDeleteMsgsList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(queueDeleteMsgsList, toProtoResult.getExtensionList());
    assertSame(queueDeleteMsgsList, toProtoResult.getExtensionOrBuilderList());
    assertSame(queueDeleteMsgsList, toProtoResult.getExtensionRangeList());
    assertSame(queueDeleteMsgsList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(queueDeleteMsgsList, toProtoResult.getNestedTypeList());
    assertSame(queueDeleteMsgsList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(queueDeleteMsgsList, toProtoResult.getOneofDeclList());
    assertSame(queueDeleteMsgsList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(queueDeleteMsgsList, toProtoResult.getReservedRangeList());
    assertSame(queueDeleteMsgsList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(queueDeleteMsgsList, options.getUninterpretedOptionList());
    assertSame(queueDeleteMsgsList, options.getUninterpretedOptionOrBuilderList());
    assertSame(queueDeleteMsgsList, resourceCacheInvalidateMsg.getKeysList());
    assertSame(queueDeleteMsgsList, resourceCacheInvalidateMsg.getKeysOrBuilderList());
    assertSame(queueDeleteMsgsList, attributeSub.getKeyStatesList());
    assertSame(queueDeleteMsgsList, attributeSub.getKeyStatesOrBuilderList());
    assertSame(queueDeleteMsgsList, attrUpdate2.getDataList());
    assertSame(queueDeleteMsgsList, attrUpdate2.getDataOrBuilderList());
    assertSame(queueDeleteMsgsList, attrUpdate.getDataList());
    assertSame(queueDeleteMsgsList, attrUpdate.getDataOrBuilderList());
    assertSame(queueDeleteMsgsList, subUpdate.getDataList());
    assertSame(queueDeleteMsgsList, subUpdate.getDataOrBuilderList());
    assertSame(queueDeleteMsgsList, defaultInstanceForType.getQueueDeleteMsgsList());
    assertSame(queueDeleteMsgsList, defaultInstanceForType.getQueueDeleteMsgsOrBuilderList());
    assertSame(queueDeleteMsgsList, actualNotificationsSubUpdateToProtoResult.getQueueDeleteMsgsOrBuilderList());
    assertSame(queueDeleteMsgsList, defaultInstanceForType.getQueueUpdateMsgsList());
    assertSame(queueDeleteMsgsList, actualNotificationsSubUpdateToProtoResult.getQueueUpdateMsgsList());
    assertSame(queueDeleteMsgsList, defaultInstanceForType.getQueueUpdateMsgsOrBuilderList());
    assertSame(queueDeleteMsgsList, actualNotificationsSubUpdateToProtoResult.getQueueUpdateMsgsOrBuilderList());
    assertSame(resourceCacheInvalidateMsg, resourceCacheInvalidateMsg.getDefaultInstanceForType());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsg());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg,
        actualNotificationsSubUpdateToProtoResult.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(restApiCallResponseMsg, restApiCallResponseMsg.getDefaultInstanceForType());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsg());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsgOrBuilder());
    assertSame(restApiCallResponseMsg, actualNotificationsSubUpdateToProtoResult.getRestApiCallResponseMsgOrBuilder());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequest());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, actualNotificationsSubUpdateToProtoResult.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, toEdgeSyncRequest.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, toLocalSubscriptionServiceMsg2.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, toLocalSubscriptionServiceMsg.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg2, defaultInstanceForType.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toLocalSubscriptionServiceMsg,
        actualNotificationsSubUpdateToProtoResult.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsg());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, actualNotificationsSubUpdateToProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsg());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, actualNotificationsSubUpdateToProtoResult.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, vcResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#toTimeseriesUpdateProto(TenantId, EntityId, List)}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toTimeseriesUpdateProto(TenantId, EntityId, List)}
   */
  @Test
  @DisplayName("Test toTimeseriesUpdateProto(TenantId, EntityId, List)")
  void testToTimeseriesUpdateProto() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    ArrayList<TsKvEntry> ts = new ArrayList<>();

    // Act
    TransportProtos.ToCoreMsg actualToTimeseriesUpdateProtoResult = TbSubscriptionUtils
        .toTimeseriesUpdateProto(tenantId, entityId, ts);

    // Assert
    Descriptors.Descriptor descriptorForType = actualToTimeseriesUpdateProtoResult.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertEquals(ts, options.findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals(ts, toProtoResult.findInitializationErrors());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualToTimeseriesUpdateProtoResult
        .getEdgeNotificationMsg();
    assertEquals(ts, edgeNotificationMsg.getPostAttributesMsg().findInitializationErrors());
    assertEquals(ts, edgeNotificationMsg.getPostTelemetryMsg().findInitializationErrors());
    assertEquals(ts,
        actualToTimeseriesUpdateProtoResult.getDefaultInstanceForType()
            .getToSubscriptionMgrMsg()
            .findInitializationErrors());
    assertEquals(ts, actualToTimeseriesUpdateProtoResult.getToSubscriptionMgrMsg().findInitializationErrors());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualToTimeseriesUpdateProtoResult
        .getToDeviceActorNotification();
    assertEquals(ts, toDeviceActorNotification.getDeviceAttributesEventMsg().findInitializationErrors());
    assertEquals(ts, toDeviceActorNotification.getDeviceCredentialsUpdateMsg().findInitializationErrors());
    assertEquals(ts, toDeviceActorNotification.getDeviceDeleteMsg().findInitializationErrors());
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualToTimeseriesUpdateProtoResult
        .getToDeviceActorMsg();
    assertEquals(ts, toDeviceActorMsg.getClaimDevice().findInitializationErrors());
    assertEquals(ts, toDeviceActorMsg.getGetAttributes().findInitializationErrors());
    assertEquals(ts, toDeviceActorMsg.getProvisionDevice().findInitializationErrors());
    assertEquals(ts, toDeviceActorMsg.getRpcResponseStatusMsg().findInitializationErrors());
    assertEquals(ts, toDeviceActorMsg.getSendPendingRPC().findInitializationErrors());
    assertEquals(ts, toDeviceActorMsg.getSessionEvent().findInitializationErrors());
    assertEquals(ts, toDeviceActorMsg.getSessionInfo().findInitializationErrors());
    assertEquals(ts, toDeviceActorMsg.getSubscribeToAttributes().findInitializationErrors());
    assertEquals(ts, toDeviceActorMsg.getSubscribeToRPC().findInitializationErrors());
    assertEquals(ts, toDeviceActorMsg.getSubscriptionInfo().findInitializationErrors());
    assertEquals(ts, toDeviceActorMsg.getToDeviceRPCCallResponse().findInitializationErrors());
    assertEquals(ts, toDeviceActorMsg.getUplinkNotificationMsg().findInitializationErrors());
    assertEquals(ts, toProtoResult.getReservedNameList());
    assertEquals(ts, options.getUninterpretedOptionList());
    Descriptors.Descriptor descriptorForType2 = actualToTimeseriesUpdateProtoResult.getDeviceActivityMsg()
        .getDescriptorForType();
    assertEquals(ts, descriptorForType2.getEnumTypes());
    Descriptors.Descriptor descriptorForType3 = actualToTimeseriesUpdateProtoResult.getDeviceConnectMsg()
        .getDescriptorForType();
    assertEquals(ts, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = actualToTimeseriesUpdateProtoResult.getDeviceDisconnectMsg()
        .getDescriptorForType();
    assertEquals(ts, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = actualToTimeseriesUpdateProtoResult.getDeviceInactivityMsg()
        .getDescriptorForType();
    assertEquals(ts, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor descriptorForType6 = actualToTimeseriesUpdateProtoResult.getDeviceStateServiceMsg()
        .getDescriptorForType();
    assertEquals(ts, descriptorForType6.getEnumTypes());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertEquals(ts, descriptorForType7.getEnumTypes());
    Descriptors.Descriptor descriptorForType8 = actualToTimeseriesUpdateProtoResult.getErrorEventMsg()
        .getDescriptorForType();
    assertEquals(ts, descriptorForType8.getEnumTypes());
    Descriptors.Descriptor descriptorForType9 = actualToTimeseriesUpdateProtoResult.getLifecycleEventMsg()
        .getDescriptorForType();
    assertEquals(ts, descriptorForType9.getEnumTypes());
    Descriptors.Descriptor descriptorForType10 = actualToTimeseriesUpdateProtoResult
        .getNotificationSchedulerServiceMsg()
        .getDescriptorForType();
    assertEquals(ts, descriptorForType10.getEnumTypes());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertEquals(ts, descriptorForType11.getEnumTypes());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertEquals(ts, descriptorForType12.getEnumTypes());
    assertEquals(ts, descriptorForType2.getExtensions());
    assertEquals(ts, descriptorForType3.getExtensions());
    assertEquals(ts, descriptorForType4.getExtensions());
    assertEquals(ts, descriptorForType5.getExtensions());
    assertEquals(ts, descriptorForType6.getExtensions());
    assertEquals(ts, descriptorForType7.getExtensions());
    assertEquals(ts, descriptorForType8.getExtensions());
    assertEquals(ts, descriptorForType9.getExtensions());
    assertEquals(ts, descriptorForType10.getExtensions());
    assertEquals(ts, descriptorForType11.getExtensions());
    assertEquals(ts, descriptorForType12.getExtensions());
    assertEquals(ts, descriptorForType2.getNestedTypes());
    assertEquals(ts, descriptorForType3.getNestedTypes());
    assertEquals(ts, descriptorForType4.getNestedTypes());
    assertEquals(ts, descriptorForType5.getNestedTypes());
    assertEquals(ts, descriptorForType6.getNestedTypes());
    assertEquals(ts, descriptorForType7.getNestedTypes());
    assertEquals(ts, descriptorForType8.getNestedTypes());
    assertEquals(ts, descriptorForType9.getNestedTypes());
    assertEquals(ts, descriptorForType10.getNestedTypes());
    assertEquals(ts, descriptorForType11.getNestedTypes());
    assertEquals(ts, descriptorForType12.getNestedTypes());
    assertEquals(ts, descriptorForType2.getOneofs());
    assertEquals(ts, descriptorForType3.getOneofs());
    assertEquals(ts, descriptorForType4.getOneofs());
    assertEquals(ts, descriptorForType5.getOneofs());
    assertEquals(ts, descriptorForType6.getOneofs());
    assertEquals(ts, descriptorForType7.getOneofs());
    assertEquals(ts, descriptorForType8.getOneofs());
    assertEquals(ts, descriptorForType9.getOneofs());
    assertEquals(ts, descriptorForType10.getOneofs());
    assertEquals(ts, descriptorForType11.getOneofs());
    assertEquals(ts, descriptorForType12.getOneofs());
    assertEquals(ts, descriptorForType2.getRealOneofs());
    assertEquals(ts, descriptorForType3.getRealOneofs());
    assertEquals(ts, descriptorForType4.getRealOneofs());
    assertEquals(ts, descriptorForType5.getRealOneofs());
    assertEquals(ts, descriptorForType6.getRealOneofs());
    assertEquals(ts, descriptorForType7.getRealOneofs());
    assertEquals(ts, descriptorForType8.getRealOneofs());
    assertEquals(ts, descriptorForType9.getRealOneofs());
    assertEquals(ts, descriptorForType10.getRealOneofs());
    assertEquals(ts, descriptorForType11.getRealOneofs());
    assertEquals(ts, descriptorForType12.getRealOneofs());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(ts, file.getDependencies());
    assertEquals(ts, file.getExtensions());
    assertEquals(ts, file.getPublicDependencies());
    assertEquals(ts, file.getServices());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#toTimeseriesDeleteProto(TenantId, EntityId, List)}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toTimeseriesDeleteProto(TenantId, EntityId, List)}
   */
  @Test
  @DisplayName("Test toTimeseriesDeleteProto(TenantId, EntityId, List)")
  void testToTimeseriesDeleteProto() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    ArrayList<String> keys = new ArrayList<>();

    // Act
    TransportProtos.ToCoreMsg actualToTimeseriesDeleteProtoResult = TbSubscriptionUtils
        .toTimeseriesDeleteProto(tenantId, entityId, keys);

    // Assert
    Descriptors.Descriptor descriptorForType = actualToTimeseriesDeleteProtoResult.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertEquals(keys, options.findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals(keys, toProtoResult.findInitializationErrors());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualToTimeseriesDeleteProtoResult
        .getEdgeNotificationMsg();
    assertEquals(keys, edgeNotificationMsg.getPostAttributesMsg().findInitializationErrors());
    assertEquals(keys, edgeNotificationMsg.getPostTelemetryMsg().findInitializationErrors());
    assertEquals(keys,
        actualToTimeseriesDeleteProtoResult.getDefaultInstanceForType()
            .getToSubscriptionMgrMsg()
            .findInitializationErrors());
    assertEquals(keys, actualToTimeseriesDeleteProtoResult.getToSubscriptionMgrMsg().findInitializationErrors());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualToTimeseriesDeleteProtoResult
        .getToDeviceActorNotification();
    assertEquals(keys, toDeviceActorNotification.getDeviceAttributesEventMsg().findInitializationErrors());
    assertEquals(keys, toDeviceActorNotification.getDeviceCredentialsUpdateMsg().findInitializationErrors());
    assertEquals(keys, toDeviceActorNotification.getDeviceDeleteMsg().findInitializationErrors());
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualToTimeseriesDeleteProtoResult
        .getToDeviceActorMsg();
    assertEquals(keys, toDeviceActorMsg.getClaimDevice().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getGetAttributes().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getProvisionDevice().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getRpcResponseStatusMsg().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getSendPendingRPC().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getSessionEvent().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getSessionInfo().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getSubscribeToAttributes().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getSubscribeToRPC().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getSubscriptionInfo().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getToDeviceRPCCallResponse().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getUplinkNotificationMsg().findInitializationErrors());
    assertEquals(keys, toProtoResult.getReservedNameList());
    assertEquals(keys, options.getUninterpretedOptionList());
    Descriptors.Descriptor descriptorForType2 = actualToTimeseriesDeleteProtoResult.getDeviceActivityMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType2.getEnumTypes());
    Descriptors.Descriptor descriptorForType3 = actualToTimeseriesDeleteProtoResult.getDeviceConnectMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = actualToTimeseriesDeleteProtoResult.getDeviceDisconnectMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = actualToTimeseriesDeleteProtoResult.getDeviceInactivityMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor descriptorForType6 = actualToTimeseriesDeleteProtoResult.getDeviceStateServiceMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType6.getEnumTypes());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertEquals(keys, descriptorForType7.getEnumTypes());
    Descriptors.Descriptor descriptorForType8 = actualToTimeseriesDeleteProtoResult.getErrorEventMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType8.getEnumTypes());
    Descriptors.Descriptor descriptorForType9 = actualToTimeseriesDeleteProtoResult.getLifecycleEventMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType9.getEnumTypes());
    Descriptors.Descriptor descriptorForType10 = actualToTimeseriesDeleteProtoResult
        .getNotificationSchedulerServiceMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType10.getEnumTypes());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertEquals(keys, descriptorForType11.getEnumTypes());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertEquals(keys, descriptorForType12.getEnumTypes());
    assertEquals(keys, descriptorForType2.getExtensions());
    assertEquals(keys, descriptorForType3.getExtensions());
    assertEquals(keys, descriptorForType4.getExtensions());
    assertEquals(keys, descriptorForType5.getExtensions());
    assertEquals(keys, descriptorForType6.getExtensions());
    assertEquals(keys, descriptorForType7.getExtensions());
    assertEquals(keys, descriptorForType8.getExtensions());
    assertEquals(keys, descriptorForType9.getExtensions());
    assertEquals(keys, descriptorForType10.getExtensions());
    assertEquals(keys, descriptorForType11.getExtensions());
    assertEquals(keys, descriptorForType12.getExtensions());
    assertEquals(keys, descriptorForType2.getNestedTypes());
    assertEquals(keys, descriptorForType3.getNestedTypes());
    assertEquals(keys, descriptorForType4.getNestedTypes());
    assertEquals(keys, descriptorForType5.getNestedTypes());
    assertEquals(keys, descriptorForType6.getNestedTypes());
    assertEquals(keys, descriptorForType7.getNestedTypes());
    assertEquals(keys, descriptorForType8.getNestedTypes());
    assertEquals(keys, descriptorForType9.getNestedTypes());
    assertEquals(keys, descriptorForType10.getNestedTypes());
    assertEquals(keys, descriptorForType11.getNestedTypes());
    assertEquals(keys, descriptorForType12.getNestedTypes());
    assertEquals(keys, descriptorForType2.getOneofs());
    assertEquals(keys, descriptorForType3.getOneofs());
    assertEquals(keys, descriptorForType4.getOneofs());
    assertEquals(keys, descriptorForType5.getOneofs());
    assertEquals(keys, descriptorForType6.getOneofs());
    assertEquals(keys, descriptorForType7.getOneofs());
    assertEquals(keys, descriptorForType8.getOneofs());
    assertEquals(keys, descriptorForType9.getOneofs());
    assertEquals(keys, descriptorForType10.getOneofs());
    assertEquals(keys, descriptorForType11.getOneofs());
    assertEquals(keys, descriptorForType12.getOneofs());
    assertEquals(keys, descriptorForType2.getRealOneofs());
    assertEquals(keys, descriptorForType3.getRealOneofs());
    assertEquals(keys, descriptorForType4.getRealOneofs());
    assertEquals(keys, descriptorForType5.getRealOneofs());
    assertEquals(keys, descriptorForType6.getRealOneofs());
    assertEquals(keys, descriptorForType7.getRealOneofs());
    assertEquals(keys, descriptorForType8.getRealOneofs());
    assertEquals(keys, descriptorForType9.getRealOneofs());
    assertEquals(keys, descriptorForType10.getRealOneofs());
    assertEquals(keys, descriptorForType11.getRealOneofs());
    assertEquals(keys, descriptorForType12.getRealOneofs());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(keys, file.getDependencies());
    assertEquals(keys, file.getExtensions());
    assertEquals(keys, file.getPublicDependencies());
    assertEquals(keys, file.getServices());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#toAttributesUpdateProto(TenantId, EntityId, String, List)}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toAttributesUpdateProto(TenantId, EntityId, String, List)}
   */
  @Test
  @DisplayName("Test toAttributesUpdateProto(TenantId, EntityId, String, List)")
  void testToAttributesUpdateProto() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();

    // Act
    TransportProtos.ToCoreMsg actualToAttributesUpdateProtoResult = TbSubscriptionUtils
        .toAttributesUpdateProto(tenantId, entityId, "Scope", attributes);

    // Assert
    Descriptors.Descriptor descriptorForType = actualToAttributesUpdateProtoResult.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertEquals(attributes, options.findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals(attributes, toProtoResult.findInitializationErrors());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualToAttributesUpdateProtoResult
        .getEdgeNotificationMsg();
    assertEquals(attributes, edgeNotificationMsg.getPostAttributesMsg().findInitializationErrors());
    assertEquals(attributes, edgeNotificationMsg.getPostTelemetryMsg().findInitializationErrors());
    assertEquals(attributes,
        actualToAttributesUpdateProtoResult.getDefaultInstanceForType()
            .getToSubscriptionMgrMsg()
            .findInitializationErrors());
    assertEquals(attributes, actualToAttributesUpdateProtoResult.getToSubscriptionMgrMsg().findInitializationErrors());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualToAttributesUpdateProtoResult
        .getToDeviceActorNotification();
    assertEquals(attributes, toDeviceActorNotification.getDeviceAttributesEventMsg().findInitializationErrors());
    assertEquals(attributes, toDeviceActorNotification.getDeviceCredentialsUpdateMsg().findInitializationErrors());
    assertEquals(attributes, toDeviceActorNotification.getDeviceDeleteMsg().findInitializationErrors());
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualToAttributesUpdateProtoResult
        .getToDeviceActorMsg();
    assertEquals(attributes, toDeviceActorMsg.getClaimDevice().findInitializationErrors());
    assertEquals(attributes, toDeviceActorMsg.getGetAttributes().findInitializationErrors());
    assertEquals(attributes, toDeviceActorMsg.getProvisionDevice().findInitializationErrors());
    assertEquals(attributes, toDeviceActorMsg.getRpcResponseStatusMsg().findInitializationErrors());
    assertEquals(attributes, toDeviceActorMsg.getSendPendingRPC().findInitializationErrors());
    assertEquals(attributes, toDeviceActorMsg.getSessionEvent().findInitializationErrors());
    assertEquals(attributes, toDeviceActorMsg.getSessionInfo().findInitializationErrors());
    assertEquals(attributes, toDeviceActorMsg.getSubscribeToAttributes().findInitializationErrors());
    assertEquals(attributes, toDeviceActorMsg.getSubscribeToRPC().findInitializationErrors());
    assertEquals(attributes, toDeviceActorMsg.getSubscriptionInfo().findInitializationErrors());
    assertEquals(attributes, toDeviceActorMsg.getToDeviceRPCCallResponse().findInitializationErrors());
    assertEquals(attributes, toDeviceActorMsg.getUplinkNotificationMsg().findInitializationErrors());
    assertEquals(attributes, toProtoResult.getReservedNameList());
    assertEquals(attributes, options.getUninterpretedOptionList());
    Descriptors.Descriptor descriptorForType2 = actualToAttributesUpdateProtoResult.getDeviceActivityMsg()
        .getDescriptorForType();
    assertEquals(attributes, descriptorForType2.getEnumTypes());
    Descriptors.Descriptor descriptorForType3 = actualToAttributesUpdateProtoResult.getDeviceConnectMsg()
        .getDescriptorForType();
    assertEquals(attributes, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = actualToAttributesUpdateProtoResult.getDeviceDisconnectMsg()
        .getDescriptorForType();
    assertEquals(attributes, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = actualToAttributesUpdateProtoResult.getDeviceInactivityMsg()
        .getDescriptorForType();
    assertEquals(attributes, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor descriptorForType6 = actualToAttributesUpdateProtoResult.getDeviceStateServiceMsg()
        .getDescriptorForType();
    assertEquals(attributes, descriptorForType6.getEnumTypes());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertEquals(attributes, descriptorForType7.getEnumTypes());
    Descriptors.Descriptor descriptorForType8 = actualToAttributesUpdateProtoResult.getErrorEventMsg()
        .getDescriptorForType();
    assertEquals(attributes, descriptorForType8.getEnumTypes());
    Descriptors.Descriptor descriptorForType9 = actualToAttributesUpdateProtoResult.getLifecycleEventMsg()
        .getDescriptorForType();
    assertEquals(attributes, descriptorForType9.getEnumTypes());
    Descriptors.Descriptor descriptorForType10 = actualToAttributesUpdateProtoResult
        .getNotificationSchedulerServiceMsg()
        .getDescriptorForType();
    assertEquals(attributes, descriptorForType10.getEnumTypes());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertEquals(attributes, descriptorForType11.getEnumTypes());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertEquals(attributes, descriptorForType12.getEnumTypes());
    assertEquals(attributes, descriptorForType2.getExtensions());
    assertEquals(attributes, descriptorForType3.getExtensions());
    assertEquals(attributes, descriptorForType4.getExtensions());
    assertEquals(attributes, descriptorForType5.getExtensions());
    assertEquals(attributes, descriptorForType6.getExtensions());
    assertEquals(attributes, descriptorForType7.getExtensions());
    assertEquals(attributes, descriptorForType8.getExtensions());
    assertEquals(attributes, descriptorForType9.getExtensions());
    assertEquals(attributes, descriptorForType10.getExtensions());
    assertEquals(attributes, descriptorForType11.getExtensions());
    assertEquals(attributes, descriptorForType12.getExtensions());
    assertEquals(attributes, descriptorForType2.getNestedTypes());
    assertEquals(attributes, descriptorForType3.getNestedTypes());
    assertEquals(attributes, descriptorForType4.getNestedTypes());
    assertEquals(attributes, descriptorForType5.getNestedTypes());
    assertEquals(attributes, descriptorForType6.getNestedTypes());
    assertEquals(attributes, descriptorForType7.getNestedTypes());
    assertEquals(attributes, descriptorForType8.getNestedTypes());
    assertEquals(attributes, descriptorForType9.getNestedTypes());
    assertEquals(attributes, descriptorForType10.getNestedTypes());
    assertEquals(attributes, descriptorForType11.getNestedTypes());
    assertEquals(attributes, descriptorForType12.getNestedTypes());
    assertEquals(attributes, descriptorForType2.getOneofs());
    assertEquals(attributes, descriptorForType3.getOneofs());
    assertEquals(attributes, descriptorForType4.getOneofs());
    assertEquals(attributes, descriptorForType5.getOneofs());
    assertEquals(attributes, descriptorForType6.getOneofs());
    assertEquals(attributes, descriptorForType7.getOneofs());
    assertEquals(attributes, descriptorForType8.getOneofs());
    assertEquals(attributes, descriptorForType9.getOneofs());
    assertEquals(attributes, descriptorForType10.getOneofs());
    assertEquals(attributes, descriptorForType11.getOneofs());
    assertEquals(attributes, descriptorForType12.getOneofs());
    assertEquals(attributes, descriptorForType2.getRealOneofs());
    assertEquals(attributes, descriptorForType3.getRealOneofs());
    assertEquals(attributes, descriptorForType4.getRealOneofs());
    assertEquals(attributes, descriptorForType5.getRealOneofs());
    assertEquals(attributes, descriptorForType6.getRealOneofs());
    assertEquals(attributes, descriptorForType7.getRealOneofs());
    assertEquals(attributes, descriptorForType8.getRealOneofs());
    assertEquals(attributes, descriptorForType9.getRealOneofs());
    assertEquals(attributes, descriptorForType10.getRealOneofs());
    assertEquals(attributes, descriptorForType11.getRealOneofs());
    assertEquals(attributes, descriptorForType12.getRealOneofs());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(attributes, file.getDependencies());
    assertEquals(attributes, file.getExtensions());
    assertEquals(attributes, file.getPublicDependencies());
    assertEquals(attributes, file.getServices());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#toAttributesDeleteProto(TenantId, EntityId, String, List, boolean)}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toAttributesDeleteProto(TenantId, EntityId, String, List, boolean)}
   */
  @Test
  @DisplayName("Test toAttributesDeleteProto(TenantId, EntityId, String, List, boolean)")
  void testToAttributesDeleteProto() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    ArrayList<String> keys = new ArrayList<>();

    // Act
    TransportProtos.ToCoreMsg actualToAttributesDeleteProtoResult = TbSubscriptionUtils
        .toAttributesDeleteProto(tenantId, entityId, "Scope", keys, true);

    // Assert
    Descriptors.Descriptor descriptorForType = actualToAttributesDeleteProtoResult.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertEquals(keys, options.findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals(keys, toProtoResult.findInitializationErrors());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualToAttributesDeleteProtoResult
        .getEdgeNotificationMsg();
    assertEquals(keys, edgeNotificationMsg.getPostAttributesMsg().findInitializationErrors());
    assertEquals(keys, edgeNotificationMsg.getPostTelemetryMsg().findInitializationErrors());
    assertEquals(keys,
        actualToAttributesDeleteProtoResult.getDefaultInstanceForType()
            .getToSubscriptionMgrMsg()
            .findInitializationErrors());
    assertEquals(keys, actualToAttributesDeleteProtoResult.getToSubscriptionMgrMsg().findInitializationErrors());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualToAttributesDeleteProtoResult
        .getToDeviceActorNotification();
    assertEquals(keys, toDeviceActorNotification.getDeviceAttributesEventMsg().findInitializationErrors());
    assertEquals(keys, toDeviceActorNotification.getDeviceCredentialsUpdateMsg().findInitializationErrors());
    assertEquals(keys, toDeviceActorNotification.getDeviceDeleteMsg().findInitializationErrors());
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualToAttributesDeleteProtoResult
        .getToDeviceActorMsg();
    assertEquals(keys, toDeviceActorMsg.getClaimDevice().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getGetAttributes().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getProvisionDevice().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getRpcResponseStatusMsg().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getSendPendingRPC().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getSessionEvent().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getSessionInfo().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getSubscribeToAttributes().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getSubscribeToRPC().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getSubscriptionInfo().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getToDeviceRPCCallResponse().findInitializationErrors());
    assertEquals(keys, toDeviceActorMsg.getUplinkNotificationMsg().findInitializationErrors());
    assertEquals(keys, toProtoResult.getReservedNameList());
    assertEquals(keys, options.getUninterpretedOptionList());
    Descriptors.Descriptor descriptorForType2 = actualToAttributesDeleteProtoResult.getDeviceActivityMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType2.getEnumTypes());
    Descriptors.Descriptor descriptorForType3 = actualToAttributesDeleteProtoResult.getDeviceConnectMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = actualToAttributesDeleteProtoResult.getDeviceDisconnectMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = actualToAttributesDeleteProtoResult.getDeviceInactivityMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor descriptorForType6 = actualToAttributesDeleteProtoResult.getDeviceStateServiceMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType6.getEnumTypes());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertEquals(keys, descriptorForType7.getEnumTypes());
    Descriptors.Descriptor descriptorForType8 = actualToAttributesDeleteProtoResult.getErrorEventMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType8.getEnumTypes());
    Descriptors.Descriptor descriptorForType9 = actualToAttributesDeleteProtoResult.getLifecycleEventMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType9.getEnumTypes());
    Descriptors.Descriptor descriptorForType10 = actualToAttributesDeleteProtoResult
        .getNotificationSchedulerServiceMsg()
        .getDescriptorForType();
    assertEquals(keys, descriptorForType10.getEnumTypes());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertEquals(keys, descriptorForType11.getEnumTypes());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertEquals(keys, descriptorForType12.getEnumTypes());
    assertEquals(keys, descriptorForType2.getExtensions());
    assertEquals(keys, descriptorForType3.getExtensions());
    assertEquals(keys, descriptorForType4.getExtensions());
    assertEquals(keys, descriptorForType5.getExtensions());
    assertEquals(keys, descriptorForType6.getExtensions());
    assertEquals(keys, descriptorForType7.getExtensions());
    assertEquals(keys, descriptorForType8.getExtensions());
    assertEquals(keys, descriptorForType9.getExtensions());
    assertEquals(keys, descriptorForType10.getExtensions());
    assertEquals(keys, descriptorForType11.getExtensions());
    assertEquals(keys, descriptorForType12.getExtensions());
    assertEquals(keys, descriptorForType2.getNestedTypes());
    assertEquals(keys, descriptorForType3.getNestedTypes());
    assertEquals(keys, descriptorForType4.getNestedTypes());
    assertEquals(keys, descriptorForType5.getNestedTypes());
    assertEquals(keys, descriptorForType6.getNestedTypes());
    assertEquals(keys, descriptorForType7.getNestedTypes());
    assertEquals(keys, descriptorForType8.getNestedTypes());
    assertEquals(keys, descriptorForType9.getNestedTypes());
    assertEquals(keys, descriptorForType10.getNestedTypes());
    assertEquals(keys, descriptorForType11.getNestedTypes());
    assertEquals(keys, descriptorForType12.getNestedTypes());
    assertEquals(keys, descriptorForType2.getOneofs());
    assertEquals(keys, descriptorForType3.getOneofs());
    assertEquals(keys, descriptorForType4.getOneofs());
    assertEquals(keys, descriptorForType5.getOneofs());
    assertEquals(keys, descriptorForType6.getOneofs());
    assertEquals(keys, descriptorForType7.getOneofs());
    assertEquals(keys, descriptorForType8.getOneofs());
    assertEquals(keys, descriptorForType9.getOneofs());
    assertEquals(keys, descriptorForType10.getOneofs());
    assertEquals(keys, descriptorForType11.getOneofs());
    assertEquals(keys, descriptorForType12.getOneofs());
    assertEquals(keys, descriptorForType2.getRealOneofs());
    assertEquals(keys, descriptorForType3.getRealOneofs());
    assertEquals(keys, descriptorForType4.getRealOneofs());
    assertEquals(keys, descriptorForType5.getRealOneofs());
    assertEquals(keys, descriptorForType6.getRealOneofs());
    assertEquals(keys, descriptorForType7.getRealOneofs());
    assertEquals(keys, descriptorForType8.getRealOneofs());
    assertEquals(keys, descriptorForType9.getRealOneofs());
    assertEquals(keys, descriptorForType10.getRealOneofs());
    assertEquals(keys, descriptorForType11.getRealOneofs());
    assertEquals(keys, descriptorForType12.getRealOneofs());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(keys, file.getDependencies());
    assertEquals(keys, file.getExtensions());
    assertEquals(keys, file.getPublicDependencies());
    assertEquals(keys, file.getServices());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#toAlarmUpdateProto(TenantId, EntityId, AlarmInfo)}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toAlarmUpdateProto(TenantId, EntityId, AlarmInfo)}
   */
  @Test
  @DisplayName("Test toAlarmUpdateProto(TenantId, EntityId, AlarmInfo); given randomUUID; then calls getEntityType()")
  void testToAlarmUpdateProto_givenRandomUUID_thenCallsGetEntityType() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    TransportProtos.ToCoreMsg actualToAlarmUpdateProtoResult = TbSubscriptionUtils.toAlarmUpdateProto(tenantId,
        entityId, new AlarmInfo());

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualToAlarmUpdateProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualToAlarmUpdateProtoResult.getToDeviceActorMsg();
    TransportProtos.GetAttributeRequestMsg getAttributes = toDeviceActorMsg.getGetAttributes();
    assertSame(reservedNameList, getAttributes.getClientAttributeNamesList());
    assertSame(reservedNameList, getAttributes.getSharedAttributeNamesList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options.getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualToAlarmUpdateProtoResult
        .getToDeviceActorNotification();
    TransportProtos.DeviceAttributesEventMsgProto deviceAttributesEventMsg = toDeviceActorNotification
        .getDeviceAttributesEventMsg();
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysOrBuilderList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesOrBuilderList());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualToAlarmUpdateProtoResult
        .getEdgeNotificationMsg();
    TransportProtos.PostAttributeMsg postAttributesMsg = edgeNotificationMsg.getPostAttributesMsg();
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvList());
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvOrBuilderList());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = edgeNotificationMsg.getPostTelemetryMsg();
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListList());
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.DeviceActivityProto deviceActivityMsg = actualToAlarmUpdateProtoResult.getDeviceActivityMsg();
    Descriptors.Descriptor descriptorForType2 = deviceActivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.DeviceConnectProto deviceConnectMsg = actualToAlarmUpdateProtoResult.getDeviceConnectMsg();
    Descriptors.Descriptor descriptorForType3 = deviceConnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.DeviceDisconnectProto deviceDisconnectMsg = actualToAlarmUpdateProtoResult.getDeviceDisconnectMsg();
    Descriptors.Descriptor descriptorForType4 = deviceDisconnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.DeviceInactivityProto deviceInactivityMsg = actualToAlarmUpdateProtoResult.getDeviceInactivityMsg();
    Descriptors.Descriptor descriptorForType5 = deviceInactivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.DeviceStateServiceMsgProto deviceStateServiceMsg = actualToAlarmUpdateProtoResult
        .getDeviceStateServiceMsg();
    Descriptors.Descriptor descriptorForType6 = deviceStateServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ErrorEventProto errorEventMsg = actualToAlarmUpdateProtoResult.getErrorEventMsg();
    Descriptors.Descriptor descriptorForType8 = errorEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.LifecycleEventProto lifecycleEventMsg = actualToAlarmUpdateProtoResult.getLifecycleEventMsg();
    Descriptors.Descriptor descriptorForType9 = lifecycleEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.NotificationSchedulerServiceMsg notificationSchedulerServiceMsg = actualToAlarmUpdateProtoResult
        .getNotificationSchedulerServiceMsg();
    Descriptors.Descriptor descriptorForType10 = notificationSchedulerServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreMsg defaultInstanceForType = actualToAlarmUpdateProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToAlarmUpdateProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, postAttributesMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceActivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceConnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceDisconnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceInactivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceStateServiceMsg.getUnknownFields());
    assertSame(unknownFields, edgeNotificationMsg.getUnknownFields());
    assertSame(unknownFields, errorEventMsg.getUnknownFields());
    assertSame(unknownFields, lifecycleEventMsg.getUnknownFields());
    assertSame(unknownFields, notificationSchedulerServiceMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorNotification.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = actualToAlarmUpdateProtoResult
        .getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, deviceAttributesEventMsg.getUnknownFields());
    TransportProtos.DeviceCredentialsUpdateMsgProto deviceCredentialsUpdateMsg = toDeviceActorNotification
        .getDeviceCredentialsUpdateMsg();
    assertSame(unknownFields, deviceCredentialsUpdateMsg.getUnknownFields());
    TransportProtos.ClaimDeviceMsg claimDevice = toDeviceActorMsg.getClaimDevice();
    assertSame(unknownFields, claimDevice.getUnknownFields());
    assertSame(unknownFields, getAttributes.getUnknownFields());
    TransportProtos.ProvisionDeviceRequestMsg provisionDevice = toDeviceActorMsg.getProvisionDevice();
    assertSame(unknownFields, provisionDevice.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseStatusMsg rpcResponseStatusMsg = toDeviceActorMsg.getRpcResponseStatusMsg();
    assertSame(unknownFields, rpcResponseStatusMsg.getUnknownFields());
    TransportProtos.SendPendingRPCMsg sendPendingRPC = toDeviceActorMsg.getSendPendingRPC();
    assertSame(unknownFields, sendPendingRPC.getUnknownFields());
    TransportProtos.SessionEventMsg sessionEvent = toDeviceActorMsg.getSessionEvent();
    assertSame(unknownFields, sessionEvent.getUnknownFields());
    TransportProtos.SessionInfoProto sessionInfo = toDeviceActorMsg.getSessionInfo();
    assertSame(unknownFields, sessionInfo.getUnknownFields());
    TransportProtos.SubscribeToAttributeUpdatesMsg subscribeToAttributes = toDeviceActorMsg.getSubscribeToAttributes();
    assertSame(unknownFields, subscribeToAttributes.getUnknownFields());
    TransportProtos.SubscribeToRPCMsg subscribeToRPC = toDeviceActorMsg.getSubscribeToRPC();
    assertSame(unknownFields, subscribeToRPC.getUnknownFields());
    TransportProtos.SubscriptionInfoProto subscriptionInfo = toDeviceActorMsg.getSubscriptionInfo();
    assertSame(unknownFields, subscriptionInfo.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseMsg toDeviceRPCCallResponse = toDeviceActorMsg.getToDeviceRPCCallResponse();
    assertSame(unknownFields, toDeviceRPCCallResponse.getUnknownFields());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = toDeviceActorMsg.getUplinkNotificationMsg();
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(postAttributesMsg, edgeNotificationMsg.getPostAttributesMsgOrBuilder());
    assertSame(postAttributesMsg, postAttributesMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, edgeNotificationMsg.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, deviceActivityMsg.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsg());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsgOrBuilder());
    assertSame(deviceActivityMsg, actualToAlarmUpdateProtoResult.getDeviceActivityMsgOrBuilder());
    assertSame(deviceConnectMsg, deviceConnectMsg.getDefaultInstanceForType());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsg());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsgOrBuilder());
    assertSame(deviceConnectMsg, actualToAlarmUpdateProtoResult.getDeviceConnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, deviceDisconnectMsg.getDefaultInstanceForType());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsg());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, actualToAlarmUpdateProtoResult.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceInactivityMsg, deviceInactivityMsg.getDefaultInstanceForType());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsg());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceInactivityMsg, actualToAlarmUpdateProtoResult.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceStateServiceMsg, deviceStateServiceMsg.getDefaultInstanceForType());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsg());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsgOrBuilder());
    assertSame(deviceStateServiceMsg, actualToAlarmUpdateProtoResult.getDeviceStateServiceMsgOrBuilder());
    assertSame(edgeNotificationMsg, edgeNotificationMsg.getDefaultInstanceForType());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsg());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsgOrBuilder());
    assertSame(edgeNotificationMsg, actualToAlarmUpdateProtoResult.getEdgeNotificationMsgOrBuilder());
    assertSame(errorEventMsg, errorEventMsg.getDefaultInstanceForType());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsg());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsgOrBuilder());
    assertSame(errorEventMsg, actualToAlarmUpdateProtoResult.getErrorEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, lifecycleEventMsg.getDefaultInstanceForType());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsg());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, actualToAlarmUpdateProtoResult.getLifecycleEventMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg, notificationSchedulerServiceMsg.getDefaultInstanceForType());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsg());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg,
        actualToAlarmUpdateProtoResult.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsg());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, actualToAlarmUpdateProtoResult.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, toDeviceActorMsg.getDefaultInstanceForType());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotification());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, actualToAlarmUpdateProtoResult.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, toDeviceActorNotification.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, actualToAlarmUpdateProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(deviceAttributesEventMsg, deviceAttributesEventMsg.getDefaultInstanceForType());
    assertSame(deviceAttributesEventMsg, toDeviceActorNotification.getDeviceAttributesEventMsgOrBuilder());
    assertSame(deviceCredentialsUpdateMsg, deviceCredentialsUpdateMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsUpdateMsg, toDeviceActorNotification.getDeviceCredentialsUpdateMsgOrBuilder());
    TransportProtos.DeviceDeleteMsgProto deviceDeleteMsg = toDeviceActorNotification.getDeviceDeleteMsg();
    assertSame(deviceDeleteMsg, deviceDeleteMsg.getDefaultInstanceForType());
    assertSame(deviceDeleteMsg, toDeviceActorNotification.getDeviceDeleteMsgOrBuilder());
    assertSame(claimDevice, claimDevice.getDefaultInstanceForType());
    assertSame(claimDevice, toDeviceActorMsg.getClaimDeviceOrBuilder());
    assertSame(getAttributes, getAttributes.getDefaultInstanceForType());
    assertSame(getAttributes, toDeviceActorMsg.getGetAttributesOrBuilder());
    assertSame(provisionDevice, provisionDevice.getDefaultInstanceForType());
    assertSame(provisionDevice, toDeviceActorMsg.getProvisionDeviceOrBuilder());
    assertSame(rpcResponseStatusMsg, rpcResponseStatusMsg.getDefaultInstanceForType());
    assertSame(rpcResponseStatusMsg, toDeviceActorMsg.getRpcResponseStatusMsgOrBuilder());
    assertSame(sendPendingRPC, sendPendingRPC.getDefaultInstanceForType());
    assertSame(sendPendingRPC, toDeviceActorMsg.getSendPendingRPCOrBuilder());
    assertSame(sessionEvent, sessionEvent.getDefaultInstanceForType());
    assertSame(sessionEvent, toDeviceActorMsg.getSessionEventOrBuilder());
    assertSame(sessionInfo, sessionInfo.getDefaultInstanceForType());
    assertSame(sessionInfo, toDeviceActorMsg.getSessionInfoOrBuilder());
    assertSame(subscribeToAttributes, subscribeToAttributes.getDefaultInstanceForType());
    assertSame(subscribeToAttributes, toDeviceActorMsg.getSubscribeToAttributesOrBuilder());
    assertSame(subscribeToRPC, subscribeToRPC.getDefaultInstanceForType());
    assertSame(subscribeToRPC, toDeviceActorMsg.getSubscribeToRPCOrBuilder());
    assertSame(subscriptionInfo, subscriptionInfo.getDefaultInstanceForType());
    assertSame(subscriptionInfo, toDeviceActorMsg.getSubscriptionInfoOrBuilder());
    assertSame(toDeviceRPCCallResponse, toDeviceRPCCallResponse.getDefaultInstanceForType());
    assertSame(toDeviceRPCCallResponse, toDeviceActorMsg.getToDeviceRPCCallResponseOrBuilder());
    assertSame(uplinkNotificationMsg, toDeviceActorMsg.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#toAlarmDeletedProto(TenantId, EntityId, AlarmInfo)}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toAlarmDeletedProto(TenantId, EntityId, AlarmInfo)}
   */
  @Test
  @DisplayName("Test toAlarmDeletedProto(TenantId, EntityId, AlarmInfo); given randomUUID; then calls getEntityType()")
  void testToAlarmDeletedProto_givenRandomUUID_thenCallsGetEntityType() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    TransportProtos.ToCoreMsg actualToAlarmDeletedProtoResult = TbSubscriptionUtils.toAlarmDeletedProto(tenantId,
        entityId, new AlarmInfo());

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualToAlarmDeletedProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualToAlarmDeletedProtoResult.getToDeviceActorMsg();
    TransportProtos.GetAttributeRequestMsg getAttributes = toDeviceActorMsg.getGetAttributes();
    assertSame(reservedNameList, getAttributes.getClientAttributeNamesList());
    assertSame(reservedNameList, getAttributes.getSharedAttributeNamesList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options.getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualToAlarmDeletedProtoResult
        .getToDeviceActorNotification();
    TransportProtos.DeviceAttributesEventMsgProto deviceAttributesEventMsg = toDeviceActorNotification
        .getDeviceAttributesEventMsg();
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysOrBuilderList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesOrBuilderList());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualToAlarmDeletedProtoResult
        .getEdgeNotificationMsg();
    TransportProtos.PostAttributeMsg postAttributesMsg = edgeNotificationMsg.getPostAttributesMsg();
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvList());
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvOrBuilderList());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = edgeNotificationMsg.getPostTelemetryMsg();
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListList());
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.DeviceActivityProto deviceActivityMsg = actualToAlarmDeletedProtoResult.getDeviceActivityMsg();
    Descriptors.Descriptor descriptorForType2 = deviceActivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.DeviceConnectProto deviceConnectMsg = actualToAlarmDeletedProtoResult.getDeviceConnectMsg();
    Descriptors.Descriptor descriptorForType3 = deviceConnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.DeviceDisconnectProto deviceDisconnectMsg = actualToAlarmDeletedProtoResult
        .getDeviceDisconnectMsg();
    Descriptors.Descriptor descriptorForType4 = deviceDisconnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.DeviceInactivityProto deviceInactivityMsg = actualToAlarmDeletedProtoResult
        .getDeviceInactivityMsg();
    Descriptors.Descriptor descriptorForType5 = deviceInactivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.DeviceStateServiceMsgProto deviceStateServiceMsg = actualToAlarmDeletedProtoResult
        .getDeviceStateServiceMsg();
    Descriptors.Descriptor descriptorForType6 = deviceStateServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ErrorEventProto errorEventMsg = actualToAlarmDeletedProtoResult.getErrorEventMsg();
    Descriptors.Descriptor descriptorForType8 = errorEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.LifecycleEventProto lifecycleEventMsg = actualToAlarmDeletedProtoResult.getLifecycleEventMsg();
    Descriptors.Descriptor descriptorForType9 = lifecycleEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.NotificationSchedulerServiceMsg notificationSchedulerServiceMsg = actualToAlarmDeletedProtoResult
        .getNotificationSchedulerServiceMsg();
    Descriptors.Descriptor descriptorForType10 = notificationSchedulerServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreMsg defaultInstanceForType = actualToAlarmDeletedProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToAlarmDeletedProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, postAttributesMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceActivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceConnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceDisconnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceInactivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceStateServiceMsg.getUnknownFields());
    assertSame(unknownFields, edgeNotificationMsg.getUnknownFields());
    assertSame(unknownFields, errorEventMsg.getUnknownFields());
    assertSame(unknownFields, lifecycleEventMsg.getUnknownFields());
    assertSame(unknownFields, notificationSchedulerServiceMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorNotification.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = actualToAlarmDeletedProtoResult
        .getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, deviceAttributesEventMsg.getUnknownFields());
    TransportProtos.DeviceCredentialsUpdateMsgProto deviceCredentialsUpdateMsg = toDeviceActorNotification
        .getDeviceCredentialsUpdateMsg();
    assertSame(unknownFields, deviceCredentialsUpdateMsg.getUnknownFields());
    TransportProtos.ClaimDeviceMsg claimDevice = toDeviceActorMsg.getClaimDevice();
    assertSame(unknownFields, claimDevice.getUnknownFields());
    assertSame(unknownFields, getAttributes.getUnknownFields());
    TransportProtos.ProvisionDeviceRequestMsg provisionDevice = toDeviceActorMsg.getProvisionDevice();
    assertSame(unknownFields, provisionDevice.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseStatusMsg rpcResponseStatusMsg = toDeviceActorMsg.getRpcResponseStatusMsg();
    assertSame(unknownFields, rpcResponseStatusMsg.getUnknownFields());
    TransportProtos.SendPendingRPCMsg sendPendingRPC = toDeviceActorMsg.getSendPendingRPC();
    assertSame(unknownFields, sendPendingRPC.getUnknownFields());
    TransportProtos.SessionEventMsg sessionEvent = toDeviceActorMsg.getSessionEvent();
    assertSame(unknownFields, sessionEvent.getUnknownFields());
    TransportProtos.SessionInfoProto sessionInfo = toDeviceActorMsg.getSessionInfo();
    assertSame(unknownFields, sessionInfo.getUnknownFields());
    TransportProtos.SubscribeToAttributeUpdatesMsg subscribeToAttributes = toDeviceActorMsg.getSubscribeToAttributes();
    assertSame(unknownFields, subscribeToAttributes.getUnknownFields());
    TransportProtos.SubscribeToRPCMsg subscribeToRPC = toDeviceActorMsg.getSubscribeToRPC();
    assertSame(unknownFields, subscribeToRPC.getUnknownFields());
    TransportProtos.SubscriptionInfoProto subscriptionInfo = toDeviceActorMsg.getSubscriptionInfo();
    assertSame(unknownFields, subscriptionInfo.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseMsg toDeviceRPCCallResponse = toDeviceActorMsg.getToDeviceRPCCallResponse();
    assertSame(unknownFields, toDeviceRPCCallResponse.getUnknownFields());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = toDeviceActorMsg.getUplinkNotificationMsg();
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(postAttributesMsg, edgeNotificationMsg.getPostAttributesMsgOrBuilder());
    assertSame(postAttributesMsg, postAttributesMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, edgeNotificationMsg.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, deviceActivityMsg.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsg());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsgOrBuilder());
    assertSame(deviceActivityMsg, actualToAlarmDeletedProtoResult.getDeviceActivityMsgOrBuilder());
    assertSame(deviceConnectMsg, deviceConnectMsg.getDefaultInstanceForType());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsg());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsgOrBuilder());
    assertSame(deviceConnectMsg, actualToAlarmDeletedProtoResult.getDeviceConnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, deviceDisconnectMsg.getDefaultInstanceForType());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsg());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, actualToAlarmDeletedProtoResult.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceInactivityMsg, deviceInactivityMsg.getDefaultInstanceForType());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsg());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceInactivityMsg, actualToAlarmDeletedProtoResult.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceStateServiceMsg, deviceStateServiceMsg.getDefaultInstanceForType());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsg());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsgOrBuilder());
    assertSame(deviceStateServiceMsg, actualToAlarmDeletedProtoResult.getDeviceStateServiceMsgOrBuilder());
    assertSame(edgeNotificationMsg, edgeNotificationMsg.getDefaultInstanceForType());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsg());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsgOrBuilder());
    assertSame(edgeNotificationMsg, actualToAlarmDeletedProtoResult.getEdgeNotificationMsgOrBuilder());
    assertSame(errorEventMsg, errorEventMsg.getDefaultInstanceForType());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsg());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsgOrBuilder());
    assertSame(errorEventMsg, actualToAlarmDeletedProtoResult.getErrorEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, lifecycleEventMsg.getDefaultInstanceForType());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsg());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, actualToAlarmDeletedProtoResult.getLifecycleEventMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg, notificationSchedulerServiceMsg.getDefaultInstanceForType());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsg());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg,
        actualToAlarmDeletedProtoResult.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsg());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, actualToAlarmDeletedProtoResult.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, toDeviceActorMsg.getDefaultInstanceForType());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotification());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, actualToAlarmDeletedProtoResult.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, toDeviceActorNotification.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, actualToAlarmDeletedProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(deviceAttributesEventMsg, deviceAttributesEventMsg.getDefaultInstanceForType());
    assertSame(deviceAttributesEventMsg, toDeviceActorNotification.getDeviceAttributesEventMsgOrBuilder());
    assertSame(deviceCredentialsUpdateMsg, deviceCredentialsUpdateMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsUpdateMsg, toDeviceActorNotification.getDeviceCredentialsUpdateMsgOrBuilder());
    TransportProtos.DeviceDeleteMsgProto deviceDeleteMsg = toDeviceActorNotification.getDeviceDeleteMsg();
    assertSame(deviceDeleteMsg, deviceDeleteMsg.getDefaultInstanceForType());
    assertSame(deviceDeleteMsg, toDeviceActorNotification.getDeviceDeleteMsgOrBuilder());
    assertSame(claimDevice, claimDevice.getDefaultInstanceForType());
    assertSame(claimDevice, toDeviceActorMsg.getClaimDeviceOrBuilder());
    assertSame(getAttributes, getAttributes.getDefaultInstanceForType());
    assertSame(getAttributes, toDeviceActorMsg.getGetAttributesOrBuilder());
    assertSame(provisionDevice, provisionDevice.getDefaultInstanceForType());
    assertSame(provisionDevice, toDeviceActorMsg.getProvisionDeviceOrBuilder());
    assertSame(rpcResponseStatusMsg, rpcResponseStatusMsg.getDefaultInstanceForType());
    assertSame(rpcResponseStatusMsg, toDeviceActorMsg.getRpcResponseStatusMsgOrBuilder());
    assertSame(sendPendingRPC, sendPendingRPC.getDefaultInstanceForType());
    assertSame(sendPendingRPC, toDeviceActorMsg.getSendPendingRPCOrBuilder());
    assertSame(sessionEvent, sessionEvent.getDefaultInstanceForType());
    assertSame(sessionEvent, toDeviceActorMsg.getSessionEventOrBuilder());
    assertSame(sessionInfo, sessionInfo.getDefaultInstanceForType());
    assertSame(sessionInfo, toDeviceActorMsg.getSessionInfoOrBuilder());
    assertSame(subscribeToAttributes, subscribeToAttributes.getDefaultInstanceForType());
    assertSame(subscribeToAttributes, toDeviceActorMsg.getSubscribeToAttributesOrBuilder());
    assertSame(subscribeToRPC, subscribeToRPC.getDefaultInstanceForType());
    assertSame(subscribeToRPC, toDeviceActorMsg.getSubscribeToRPCOrBuilder());
    assertSame(subscriptionInfo, subscriptionInfo.getDefaultInstanceForType());
    assertSame(subscriptionInfo, toDeviceActorMsg.getSubscriptionInfoOrBuilder());
    assertSame(toDeviceRPCCallResponse, toDeviceRPCCallResponse.getDefaultInstanceForType());
    assertSame(toDeviceRPCCallResponse, toDeviceActorMsg.getToDeviceRPCCallResponseOrBuilder());
    assertSame(uplinkNotificationMsg, toDeviceActorMsg.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#toAlarmDeletedProto(TenantId, EntityId, AlarmInfo)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toAlarmDeletedProto(TenantId, EntityId, AlarmInfo)}
   */
  @Test
  @DisplayName("Test toAlarmDeletedProto(TenantId, EntityId, AlarmInfo); when AlarmId(UUID) with id is randomUUID")
  void testToAlarmDeletedProto_whenAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = new AlarmId(UUID.randomUUID());

    // Act
    TransportProtos.ToCoreMsg actualToAlarmDeletedProtoResult = TbSubscriptionUtils.toAlarmDeletedProto(tenantId,
        entityId, new AlarmInfo());

    // Assert
    Descriptors.Descriptor descriptorForType = actualToAlarmDeletedProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualToAlarmDeletedProtoResult.getToDeviceActorMsg();
    TransportProtos.GetAttributeRequestMsg getAttributes = toDeviceActorMsg.getGetAttributes();
    assertSame(reservedNameList, getAttributes.getClientAttributeNamesList());
    assertSame(reservedNameList, getAttributes.getSharedAttributeNamesList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options.getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualToAlarmDeletedProtoResult
        .getToDeviceActorNotification();
    TransportProtos.DeviceAttributesEventMsgProto deviceAttributesEventMsg = toDeviceActorNotification
        .getDeviceAttributesEventMsg();
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysOrBuilderList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesOrBuilderList());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualToAlarmDeletedProtoResult
        .getEdgeNotificationMsg();
    TransportProtos.PostAttributeMsg postAttributesMsg = edgeNotificationMsg.getPostAttributesMsg();
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvList());
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvOrBuilderList());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = edgeNotificationMsg.getPostTelemetryMsg();
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListList());
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.DeviceActivityProto deviceActivityMsg = actualToAlarmDeletedProtoResult.getDeviceActivityMsg();
    Descriptors.Descriptor descriptorForType2 = deviceActivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.DeviceConnectProto deviceConnectMsg = actualToAlarmDeletedProtoResult.getDeviceConnectMsg();
    Descriptors.Descriptor descriptorForType3 = deviceConnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.DeviceDisconnectProto deviceDisconnectMsg = actualToAlarmDeletedProtoResult
        .getDeviceDisconnectMsg();
    Descriptors.Descriptor descriptorForType4 = deviceDisconnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.DeviceInactivityProto deviceInactivityMsg = actualToAlarmDeletedProtoResult
        .getDeviceInactivityMsg();
    Descriptors.Descriptor descriptorForType5 = deviceInactivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.DeviceStateServiceMsgProto deviceStateServiceMsg = actualToAlarmDeletedProtoResult
        .getDeviceStateServiceMsg();
    Descriptors.Descriptor descriptorForType6 = deviceStateServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ErrorEventProto errorEventMsg = actualToAlarmDeletedProtoResult.getErrorEventMsg();
    Descriptors.Descriptor descriptorForType8 = errorEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.LifecycleEventProto lifecycleEventMsg = actualToAlarmDeletedProtoResult.getLifecycleEventMsg();
    Descriptors.Descriptor descriptorForType9 = lifecycleEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.NotificationSchedulerServiceMsg notificationSchedulerServiceMsg = actualToAlarmDeletedProtoResult
        .getNotificationSchedulerServiceMsg();
    Descriptors.Descriptor descriptorForType10 = notificationSchedulerServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreMsg defaultInstanceForType = actualToAlarmDeletedProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToAlarmDeletedProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, postAttributesMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceActivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceConnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceDisconnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceInactivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceStateServiceMsg.getUnknownFields());
    assertSame(unknownFields, edgeNotificationMsg.getUnknownFields());
    assertSame(unknownFields, errorEventMsg.getUnknownFields());
    assertSame(unknownFields, lifecycleEventMsg.getUnknownFields());
    assertSame(unknownFields, notificationSchedulerServiceMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorNotification.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = actualToAlarmDeletedProtoResult
        .getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, deviceAttributesEventMsg.getUnknownFields());
    TransportProtos.DeviceCredentialsUpdateMsgProto deviceCredentialsUpdateMsg = toDeviceActorNotification
        .getDeviceCredentialsUpdateMsg();
    assertSame(unknownFields, deviceCredentialsUpdateMsg.getUnknownFields());
    TransportProtos.ClaimDeviceMsg claimDevice = toDeviceActorMsg.getClaimDevice();
    assertSame(unknownFields, claimDevice.getUnknownFields());
    assertSame(unknownFields, getAttributes.getUnknownFields());
    TransportProtos.ProvisionDeviceRequestMsg provisionDevice = toDeviceActorMsg.getProvisionDevice();
    assertSame(unknownFields, provisionDevice.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseStatusMsg rpcResponseStatusMsg = toDeviceActorMsg.getRpcResponseStatusMsg();
    assertSame(unknownFields, rpcResponseStatusMsg.getUnknownFields());
    TransportProtos.SendPendingRPCMsg sendPendingRPC = toDeviceActorMsg.getSendPendingRPC();
    assertSame(unknownFields, sendPendingRPC.getUnknownFields());
    TransportProtos.SessionEventMsg sessionEvent = toDeviceActorMsg.getSessionEvent();
    assertSame(unknownFields, sessionEvent.getUnknownFields());
    TransportProtos.SessionInfoProto sessionInfo = toDeviceActorMsg.getSessionInfo();
    assertSame(unknownFields, sessionInfo.getUnknownFields());
    TransportProtos.SubscribeToAttributeUpdatesMsg subscribeToAttributes = toDeviceActorMsg.getSubscribeToAttributes();
    assertSame(unknownFields, subscribeToAttributes.getUnknownFields());
    TransportProtos.SubscribeToRPCMsg subscribeToRPC = toDeviceActorMsg.getSubscribeToRPC();
    assertSame(unknownFields, subscribeToRPC.getUnknownFields());
    TransportProtos.SubscriptionInfoProto subscriptionInfo = toDeviceActorMsg.getSubscriptionInfo();
    assertSame(unknownFields, subscriptionInfo.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseMsg toDeviceRPCCallResponse = toDeviceActorMsg.getToDeviceRPCCallResponse();
    assertSame(unknownFields, toDeviceRPCCallResponse.getUnknownFields());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = toDeviceActorMsg.getUplinkNotificationMsg();
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(postAttributesMsg, edgeNotificationMsg.getPostAttributesMsgOrBuilder());
    assertSame(postAttributesMsg, postAttributesMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, edgeNotificationMsg.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, deviceActivityMsg.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsg());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsgOrBuilder());
    assertSame(deviceActivityMsg, actualToAlarmDeletedProtoResult.getDeviceActivityMsgOrBuilder());
    assertSame(deviceConnectMsg, deviceConnectMsg.getDefaultInstanceForType());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsg());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsgOrBuilder());
    assertSame(deviceConnectMsg, actualToAlarmDeletedProtoResult.getDeviceConnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, deviceDisconnectMsg.getDefaultInstanceForType());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsg());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, actualToAlarmDeletedProtoResult.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceInactivityMsg, deviceInactivityMsg.getDefaultInstanceForType());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsg());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceInactivityMsg, actualToAlarmDeletedProtoResult.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceStateServiceMsg, deviceStateServiceMsg.getDefaultInstanceForType());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsg());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsgOrBuilder());
    assertSame(deviceStateServiceMsg, actualToAlarmDeletedProtoResult.getDeviceStateServiceMsgOrBuilder());
    assertSame(edgeNotificationMsg, edgeNotificationMsg.getDefaultInstanceForType());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsg());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsgOrBuilder());
    assertSame(edgeNotificationMsg, actualToAlarmDeletedProtoResult.getEdgeNotificationMsgOrBuilder());
    assertSame(errorEventMsg, errorEventMsg.getDefaultInstanceForType());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsg());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsgOrBuilder());
    assertSame(errorEventMsg, actualToAlarmDeletedProtoResult.getErrorEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, lifecycleEventMsg.getDefaultInstanceForType());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsg());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, actualToAlarmDeletedProtoResult.getLifecycleEventMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg, notificationSchedulerServiceMsg.getDefaultInstanceForType());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsg());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg,
        actualToAlarmDeletedProtoResult.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsg());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, actualToAlarmDeletedProtoResult.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, toDeviceActorMsg.getDefaultInstanceForType());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotification());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, actualToAlarmDeletedProtoResult.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, toDeviceActorNotification.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, actualToAlarmDeletedProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(deviceAttributesEventMsg, deviceAttributesEventMsg.getDefaultInstanceForType());
    assertSame(deviceAttributesEventMsg, toDeviceActorNotification.getDeviceAttributesEventMsgOrBuilder());
    assertSame(deviceCredentialsUpdateMsg, deviceCredentialsUpdateMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsUpdateMsg, toDeviceActorNotification.getDeviceCredentialsUpdateMsgOrBuilder());
    TransportProtos.DeviceDeleteMsgProto deviceDeleteMsg = toDeviceActorNotification.getDeviceDeleteMsg();
    assertSame(deviceDeleteMsg, deviceDeleteMsg.getDefaultInstanceForType());
    assertSame(deviceDeleteMsg, toDeviceActorNotification.getDeviceDeleteMsgOrBuilder());
    assertSame(claimDevice, claimDevice.getDefaultInstanceForType());
    assertSame(claimDevice, toDeviceActorMsg.getClaimDeviceOrBuilder());
    assertSame(getAttributes, getAttributes.getDefaultInstanceForType());
    assertSame(getAttributes, toDeviceActorMsg.getGetAttributesOrBuilder());
    assertSame(provisionDevice, provisionDevice.getDefaultInstanceForType());
    assertSame(provisionDevice, toDeviceActorMsg.getProvisionDeviceOrBuilder());
    assertSame(rpcResponseStatusMsg, rpcResponseStatusMsg.getDefaultInstanceForType());
    assertSame(rpcResponseStatusMsg, toDeviceActorMsg.getRpcResponseStatusMsgOrBuilder());
    assertSame(sendPendingRPC, sendPendingRPC.getDefaultInstanceForType());
    assertSame(sendPendingRPC, toDeviceActorMsg.getSendPendingRPCOrBuilder());
    assertSame(sessionEvent, sessionEvent.getDefaultInstanceForType());
    assertSame(sessionEvent, toDeviceActorMsg.getSessionEventOrBuilder());
    assertSame(sessionInfo, sessionInfo.getDefaultInstanceForType());
    assertSame(sessionInfo, toDeviceActorMsg.getSessionInfoOrBuilder());
    assertSame(subscribeToAttributes, subscribeToAttributes.getDefaultInstanceForType());
    assertSame(subscribeToAttributes, toDeviceActorMsg.getSubscribeToAttributesOrBuilder());
    assertSame(subscribeToRPC, subscribeToRPC.getDefaultInstanceForType());
    assertSame(subscribeToRPC, toDeviceActorMsg.getSubscribeToRPCOrBuilder());
    assertSame(subscriptionInfo, subscriptionInfo.getDefaultInstanceForType());
    assertSame(subscriptionInfo, toDeviceActorMsg.getSubscriptionInfoOrBuilder());
    assertSame(toDeviceRPCCallResponse, toDeviceRPCCallResponse.getDefaultInstanceForType());
    assertSame(toDeviceRPCCallResponse, toDeviceActorMsg.getToDeviceRPCCallResponseOrBuilder());
    assertSame(uplinkNotificationMsg, toDeviceActorMsg.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#toAlarmDeletedProto(TenantId, EntityId, AlarmInfo)}.
   * <ul>
   *   <li>When {@link ApiUsageStateId#ApiUsageStateId(UUID)} with id is
   * randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#toAlarmDeletedProto(TenantId, EntityId, AlarmInfo)}
   */
  @Test
  @DisplayName("Test toAlarmDeletedProto(TenantId, EntityId, AlarmInfo); when ApiUsageStateId(UUID) with id is randomUUID")
  void testToAlarmDeletedProto_whenApiUsageStateIdWithIdIsRandomUUID() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ApiUsageStateId entityId = new ApiUsageStateId(UUID.randomUUID());

    // Act
    TransportProtos.ToCoreMsg actualToAlarmDeletedProtoResult = TbSubscriptionUtils.toAlarmDeletedProto(tenantId,
        entityId, new AlarmInfo());

    // Assert
    Descriptors.Descriptor descriptorForType = actualToAlarmDeletedProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualToAlarmDeletedProtoResult.getToDeviceActorMsg();
    TransportProtos.GetAttributeRequestMsg getAttributes = toDeviceActorMsg.getGetAttributes();
    assertSame(reservedNameList, getAttributes.getClientAttributeNamesList());
    assertSame(reservedNameList, getAttributes.getSharedAttributeNamesList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options.getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualToAlarmDeletedProtoResult
        .getToDeviceActorNotification();
    TransportProtos.DeviceAttributesEventMsgProto deviceAttributesEventMsg = toDeviceActorNotification
        .getDeviceAttributesEventMsg();
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysOrBuilderList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesOrBuilderList());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualToAlarmDeletedProtoResult
        .getEdgeNotificationMsg();
    TransportProtos.PostAttributeMsg postAttributesMsg = edgeNotificationMsg.getPostAttributesMsg();
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvList());
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvOrBuilderList());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = edgeNotificationMsg.getPostTelemetryMsg();
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListList());
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.DeviceActivityProto deviceActivityMsg = actualToAlarmDeletedProtoResult.getDeviceActivityMsg();
    Descriptors.Descriptor descriptorForType2 = deviceActivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.DeviceConnectProto deviceConnectMsg = actualToAlarmDeletedProtoResult.getDeviceConnectMsg();
    Descriptors.Descriptor descriptorForType3 = deviceConnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.DeviceDisconnectProto deviceDisconnectMsg = actualToAlarmDeletedProtoResult
        .getDeviceDisconnectMsg();
    Descriptors.Descriptor descriptorForType4 = deviceDisconnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.DeviceInactivityProto deviceInactivityMsg = actualToAlarmDeletedProtoResult
        .getDeviceInactivityMsg();
    Descriptors.Descriptor descriptorForType5 = deviceInactivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.DeviceStateServiceMsgProto deviceStateServiceMsg = actualToAlarmDeletedProtoResult
        .getDeviceStateServiceMsg();
    Descriptors.Descriptor descriptorForType6 = deviceStateServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ErrorEventProto errorEventMsg = actualToAlarmDeletedProtoResult.getErrorEventMsg();
    Descriptors.Descriptor descriptorForType8 = errorEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.LifecycleEventProto lifecycleEventMsg = actualToAlarmDeletedProtoResult.getLifecycleEventMsg();
    Descriptors.Descriptor descriptorForType9 = lifecycleEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.NotificationSchedulerServiceMsg notificationSchedulerServiceMsg = actualToAlarmDeletedProtoResult
        .getNotificationSchedulerServiceMsg();
    Descriptors.Descriptor descriptorForType10 = notificationSchedulerServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreMsg defaultInstanceForType = actualToAlarmDeletedProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToAlarmDeletedProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, postAttributesMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceActivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceConnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceDisconnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceInactivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceStateServiceMsg.getUnknownFields());
    assertSame(unknownFields, edgeNotificationMsg.getUnknownFields());
    assertSame(unknownFields, errorEventMsg.getUnknownFields());
    assertSame(unknownFields, lifecycleEventMsg.getUnknownFields());
    assertSame(unknownFields, notificationSchedulerServiceMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorNotification.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = actualToAlarmDeletedProtoResult
        .getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, deviceAttributesEventMsg.getUnknownFields());
    TransportProtos.DeviceCredentialsUpdateMsgProto deviceCredentialsUpdateMsg = toDeviceActorNotification
        .getDeviceCredentialsUpdateMsg();
    assertSame(unknownFields, deviceCredentialsUpdateMsg.getUnknownFields());
    TransportProtos.ClaimDeviceMsg claimDevice = toDeviceActorMsg.getClaimDevice();
    assertSame(unknownFields, claimDevice.getUnknownFields());
    assertSame(unknownFields, getAttributes.getUnknownFields());
    TransportProtos.ProvisionDeviceRequestMsg provisionDevice = toDeviceActorMsg.getProvisionDevice();
    assertSame(unknownFields, provisionDevice.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseStatusMsg rpcResponseStatusMsg = toDeviceActorMsg.getRpcResponseStatusMsg();
    assertSame(unknownFields, rpcResponseStatusMsg.getUnknownFields());
    TransportProtos.SendPendingRPCMsg sendPendingRPC = toDeviceActorMsg.getSendPendingRPC();
    assertSame(unknownFields, sendPendingRPC.getUnknownFields());
    TransportProtos.SessionEventMsg sessionEvent = toDeviceActorMsg.getSessionEvent();
    assertSame(unknownFields, sessionEvent.getUnknownFields());
    TransportProtos.SessionInfoProto sessionInfo = toDeviceActorMsg.getSessionInfo();
    assertSame(unknownFields, sessionInfo.getUnknownFields());
    TransportProtos.SubscribeToAttributeUpdatesMsg subscribeToAttributes = toDeviceActorMsg.getSubscribeToAttributes();
    assertSame(unknownFields, subscribeToAttributes.getUnknownFields());
    TransportProtos.SubscribeToRPCMsg subscribeToRPC = toDeviceActorMsg.getSubscribeToRPC();
    assertSame(unknownFields, subscribeToRPC.getUnknownFields());
    TransportProtos.SubscriptionInfoProto subscriptionInfo = toDeviceActorMsg.getSubscriptionInfo();
    assertSame(unknownFields, subscriptionInfo.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseMsg toDeviceRPCCallResponse = toDeviceActorMsg.getToDeviceRPCCallResponse();
    assertSame(unknownFields, toDeviceRPCCallResponse.getUnknownFields());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = toDeviceActorMsg.getUplinkNotificationMsg();
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(postAttributesMsg, edgeNotificationMsg.getPostAttributesMsgOrBuilder());
    assertSame(postAttributesMsg, postAttributesMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, edgeNotificationMsg.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, deviceActivityMsg.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsg());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsgOrBuilder());
    assertSame(deviceActivityMsg, actualToAlarmDeletedProtoResult.getDeviceActivityMsgOrBuilder());
    assertSame(deviceConnectMsg, deviceConnectMsg.getDefaultInstanceForType());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsg());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsgOrBuilder());
    assertSame(deviceConnectMsg, actualToAlarmDeletedProtoResult.getDeviceConnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, deviceDisconnectMsg.getDefaultInstanceForType());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsg());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, actualToAlarmDeletedProtoResult.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceInactivityMsg, deviceInactivityMsg.getDefaultInstanceForType());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsg());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceInactivityMsg, actualToAlarmDeletedProtoResult.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceStateServiceMsg, deviceStateServiceMsg.getDefaultInstanceForType());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsg());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsgOrBuilder());
    assertSame(deviceStateServiceMsg, actualToAlarmDeletedProtoResult.getDeviceStateServiceMsgOrBuilder());
    assertSame(edgeNotificationMsg, edgeNotificationMsg.getDefaultInstanceForType());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsg());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsgOrBuilder());
    assertSame(edgeNotificationMsg, actualToAlarmDeletedProtoResult.getEdgeNotificationMsgOrBuilder());
    assertSame(errorEventMsg, errorEventMsg.getDefaultInstanceForType());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsg());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsgOrBuilder());
    assertSame(errorEventMsg, actualToAlarmDeletedProtoResult.getErrorEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, lifecycleEventMsg.getDefaultInstanceForType());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsg());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, actualToAlarmDeletedProtoResult.getLifecycleEventMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg, notificationSchedulerServiceMsg.getDefaultInstanceForType());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsg());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg,
        actualToAlarmDeletedProtoResult.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsg());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, actualToAlarmDeletedProtoResult.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, toDeviceActorMsg.getDefaultInstanceForType());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotification());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, actualToAlarmDeletedProtoResult.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, toDeviceActorNotification.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, actualToAlarmDeletedProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(deviceAttributesEventMsg, deviceAttributesEventMsg.getDefaultInstanceForType());
    assertSame(deviceAttributesEventMsg, toDeviceActorNotification.getDeviceAttributesEventMsgOrBuilder());
    assertSame(deviceCredentialsUpdateMsg, deviceCredentialsUpdateMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsUpdateMsg, toDeviceActorNotification.getDeviceCredentialsUpdateMsgOrBuilder());
    TransportProtos.DeviceDeleteMsgProto deviceDeleteMsg = toDeviceActorNotification.getDeviceDeleteMsg();
    assertSame(deviceDeleteMsg, deviceDeleteMsg.getDefaultInstanceForType());
    assertSame(deviceDeleteMsg, toDeviceActorNotification.getDeviceDeleteMsgOrBuilder());
    assertSame(claimDevice, claimDevice.getDefaultInstanceForType());
    assertSame(claimDevice, toDeviceActorMsg.getClaimDeviceOrBuilder());
    assertSame(getAttributes, getAttributes.getDefaultInstanceForType());
    assertSame(getAttributes, toDeviceActorMsg.getGetAttributesOrBuilder());
    assertSame(provisionDevice, provisionDevice.getDefaultInstanceForType());
    assertSame(provisionDevice, toDeviceActorMsg.getProvisionDeviceOrBuilder());
    assertSame(rpcResponseStatusMsg, rpcResponseStatusMsg.getDefaultInstanceForType());
    assertSame(rpcResponseStatusMsg, toDeviceActorMsg.getRpcResponseStatusMsgOrBuilder());
    assertSame(sendPendingRPC, sendPendingRPC.getDefaultInstanceForType());
    assertSame(sendPendingRPC, toDeviceActorMsg.getSendPendingRPCOrBuilder());
    assertSame(sessionEvent, sessionEvent.getDefaultInstanceForType());
    assertSame(sessionEvent, toDeviceActorMsg.getSessionEventOrBuilder());
    assertSame(sessionInfo, sessionInfo.getDefaultInstanceForType());
    assertSame(sessionInfo, toDeviceActorMsg.getSessionInfoOrBuilder());
    assertSame(subscribeToAttributes, subscribeToAttributes.getDefaultInstanceForType());
    assertSame(subscribeToAttributes, toDeviceActorMsg.getSubscribeToAttributesOrBuilder());
    assertSame(subscribeToRPC, subscribeToRPC.getDefaultInstanceForType());
    assertSame(subscribeToRPC, toDeviceActorMsg.getSubscribeToRPCOrBuilder());
    assertSame(subscriptionInfo, subscriptionInfo.getDefaultInstanceForType());
    assertSame(subscriptionInfo, toDeviceActorMsg.getSubscriptionInfoOrBuilder());
    assertSame(toDeviceRPCCallResponse, toDeviceRPCCallResponse.getDefaultInstanceForType());
    assertSame(toDeviceRPCCallResponse, toDeviceActorMsg.getToDeviceRPCCallResponseOrBuilder());
    assertSame(uplinkNotificationMsg, toDeviceActorMsg.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#notificationUpdateToProto(TenantId, UserId, NotificationUpdate)}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#notificationUpdateToProto(TenantId, UserId, NotificationUpdate)}
   */
  @Test
  @DisplayName("Test notificationUpdateToProto(TenantId, UserId, NotificationUpdate); given randomUUID; then calls getId()")
  void testNotificationUpdateToProto_givenRandomUUID_thenCallsGetId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(UUID.randomUUID());

    // Act
    TransportProtos.ToCoreMsg actualNotificationUpdateToProtoResult = TbSubscriptionUtils
        .notificationUpdateToProto(tenantId, recipientId, new NotificationUpdate());

    // Assert
    verify(recipientId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualNotificationUpdateToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualNotificationUpdateToProtoResult
        .getToDeviceActorMsg();
    TransportProtos.GetAttributeRequestMsg getAttributes = toDeviceActorMsg.getGetAttributes();
    assertSame(reservedNameList, getAttributes.getClientAttributeNamesList());
    assertSame(reservedNameList, getAttributes.getSharedAttributeNamesList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options.getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualNotificationUpdateToProtoResult
        .getToDeviceActorNotification();
    TransportProtos.DeviceAttributesEventMsgProto deviceAttributesEventMsg = toDeviceActorNotification
        .getDeviceAttributesEventMsg();
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysOrBuilderList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesOrBuilderList());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualNotificationUpdateToProtoResult
        .getEdgeNotificationMsg();
    TransportProtos.PostAttributeMsg postAttributesMsg = edgeNotificationMsg.getPostAttributesMsg();
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvList());
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvOrBuilderList());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = edgeNotificationMsg.getPostTelemetryMsg();
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListList());
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.DeviceActivityProto deviceActivityMsg = actualNotificationUpdateToProtoResult
        .getDeviceActivityMsg();
    Descriptors.Descriptor descriptorForType2 = deviceActivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.DeviceConnectProto deviceConnectMsg = actualNotificationUpdateToProtoResult.getDeviceConnectMsg();
    Descriptors.Descriptor descriptorForType3 = deviceConnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.DeviceDisconnectProto deviceDisconnectMsg = actualNotificationUpdateToProtoResult
        .getDeviceDisconnectMsg();
    Descriptors.Descriptor descriptorForType4 = deviceDisconnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.DeviceInactivityProto deviceInactivityMsg = actualNotificationUpdateToProtoResult
        .getDeviceInactivityMsg();
    Descriptors.Descriptor descriptorForType5 = deviceInactivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.DeviceStateServiceMsgProto deviceStateServiceMsg = actualNotificationUpdateToProtoResult
        .getDeviceStateServiceMsg();
    Descriptors.Descriptor descriptorForType6 = deviceStateServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ErrorEventProto errorEventMsg = actualNotificationUpdateToProtoResult.getErrorEventMsg();
    Descriptors.Descriptor descriptorForType8 = errorEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.LifecycleEventProto lifecycleEventMsg = actualNotificationUpdateToProtoResult
        .getLifecycleEventMsg();
    Descriptors.Descriptor descriptorForType9 = lifecycleEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.NotificationSchedulerServiceMsg notificationSchedulerServiceMsg = actualNotificationUpdateToProtoResult
        .getNotificationSchedulerServiceMsg();
    Descriptors.Descriptor descriptorForType10 = notificationSchedulerServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreMsg defaultInstanceForType = actualNotificationUpdateToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualNotificationUpdateToProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, postAttributesMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceActivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceConnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceDisconnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceInactivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceStateServiceMsg.getUnknownFields());
    assertSame(unknownFields, edgeNotificationMsg.getUnknownFields());
    assertSame(unknownFields, errorEventMsg.getUnknownFields());
    assertSame(unknownFields, lifecycleEventMsg.getUnknownFields());
    assertSame(unknownFields, notificationSchedulerServiceMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorNotification.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = actualNotificationUpdateToProtoResult
        .getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, deviceAttributesEventMsg.getUnknownFields());
    TransportProtos.DeviceCredentialsUpdateMsgProto deviceCredentialsUpdateMsg = toDeviceActorNotification
        .getDeviceCredentialsUpdateMsg();
    assertSame(unknownFields, deviceCredentialsUpdateMsg.getUnknownFields());
    TransportProtos.ClaimDeviceMsg claimDevice = toDeviceActorMsg.getClaimDevice();
    assertSame(unknownFields, claimDevice.getUnknownFields());
    assertSame(unknownFields, getAttributes.getUnknownFields());
    TransportProtos.ProvisionDeviceRequestMsg provisionDevice = toDeviceActorMsg.getProvisionDevice();
    assertSame(unknownFields, provisionDevice.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseStatusMsg rpcResponseStatusMsg = toDeviceActorMsg.getRpcResponseStatusMsg();
    assertSame(unknownFields, rpcResponseStatusMsg.getUnknownFields());
    TransportProtos.SendPendingRPCMsg sendPendingRPC = toDeviceActorMsg.getSendPendingRPC();
    assertSame(unknownFields, sendPendingRPC.getUnknownFields());
    TransportProtos.SessionEventMsg sessionEvent = toDeviceActorMsg.getSessionEvent();
    assertSame(unknownFields, sessionEvent.getUnknownFields());
    TransportProtos.SessionInfoProto sessionInfo = toDeviceActorMsg.getSessionInfo();
    assertSame(unknownFields, sessionInfo.getUnknownFields());
    TransportProtos.SubscribeToAttributeUpdatesMsg subscribeToAttributes = toDeviceActorMsg.getSubscribeToAttributes();
    assertSame(unknownFields, subscribeToAttributes.getUnknownFields());
    TransportProtos.SubscribeToRPCMsg subscribeToRPC = toDeviceActorMsg.getSubscribeToRPC();
    assertSame(unknownFields, subscribeToRPC.getUnknownFields());
    TransportProtos.SubscriptionInfoProto subscriptionInfo = toDeviceActorMsg.getSubscriptionInfo();
    assertSame(unknownFields, subscriptionInfo.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseMsg toDeviceRPCCallResponse = toDeviceActorMsg.getToDeviceRPCCallResponse();
    assertSame(unknownFields, toDeviceRPCCallResponse.getUnknownFields());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = toDeviceActorMsg.getUplinkNotificationMsg();
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(postAttributesMsg, edgeNotificationMsg.getPostAttributesMsgOrBuilder());
    assertSame(postAttributesMsg, postAttributesMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, edgeNotificationMsg.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, deviceActivityMsg.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsg());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsgOrBuilder());
    assertSame(deviceActivityMsg, actualNotificationUpdateToProtoResult.getDeviceActivityMsgOrBuilder());
    assertSame(deviceConnectMsg, deviceConnectMsg.getDefaultInstanceForType());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsg());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsgOrBuilder());
    assertSame(deviceConnectMsg, actualNotificationUpdateToProtoResult.getDeviceConnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, deviceDisconnectMsg.getDefaultInstanceForType());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsg());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, actualNotificationUpdateToProtoResult.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceInactivityMsg, deviceInactivityMsg.getDefaultInstanceForType());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsg());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceInactivityMsg, actualNotificationUpdateToProtoResult.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceStateServiceMsg, deviceStateServiceMsg.getDefaultInstanceForType());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsg());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsgOrBuilder());
    assertSame(deviceStateServiceMsg, actualNotificationUpdateToProtoResult.getDeviceStateServiceMsgOrBuilder());
    assertSame(edgeNotificationMsg, edgeNotificationMsg.getDefaultInstanceForType());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsg());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsgOrBuilder());
    assertSame(edgeNotificationMsg, actualNotificationUpdateToProtoResult.getEdgeNotificationMsgOrBuilder());
    assertSame(errorEventMsg, errorEventMsg.getDefaultInstanceForType());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsg());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsgOrBuilder());
    assertSame(errorEventMsg, actualNotificationUpdateToProtoResult.getErrorEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, lifecycleEventMsg.getDefaultInstanceForType());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsg());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, actualNotificationUpdateToProtoResult.getLifecycleEventMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg, notificationSchedulerServiceMsg.getDefaultInstanceForType());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsg());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg,
        actualNotificationUpdateToProtoResult.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsg());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, actualNotificationUpdateToProtoResult.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, toDeviceActorMsg.getDefaultInstanceForType());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotification());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification,
        actualNotificationUpdateToProtoResult.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, toDeviceActorNotification.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, actualNotificationUpdateToProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(deviceAttributesEventMsg, deviceAttributesEventMsg.getDefaultInstanceForType());
    assertSame(deviceAttributesEventMsg, toDeviceActorNotification.getDeviceAttributesEventMsgOrBuilder());
    assertSame(deviceCredentialsUpdateMsg, deviceCredentialsUpdateMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsUpdateMsg, toDeviceActorNotification.getDeviceCredentialsUpdateMsgOrBuilder());
    TransportProtos.DeviceDeleteMsgProto deviceDeleteMsg = toDeviceActorNotification.getDeviceDeleteMsg();
    assertSame(deviceDeleteMsg, deviceDeleteMsg.getDefaultInstanceForType());
    assertSame(deviceDeleteMsg, toDeviceActorNotification.getDeviceDeleteMsgOrBuilder());
    assertSame(claimDevice, claimDevice.getDefaultInstanceForType());
    assertSame(claimDevice, toDeviceActorMsg.getClaimDeviceOrBuilder());
    assertSame(getAttributes, getAttributes.getDefaultInstanceForType());
    assertSame(getAttributes, toDeviceActorMsg.getGetAttributesOrBuilder());
    assertSame(provisionDevice, provisionDevice.getDefaultInstanceForType());
    assertSame(provisionDevice, toDeviceActorMsg.getProvisionDeviceOrBuilder());
    assertSame(rpcResponseStatusMsg, rpcResponseStatusMsg.getDefaultInstanceForType());
    assertSame(rpcResponseStatusMsg, toDeviceActorMsg.getRpcResponseStatusMsgOrBuilder());
    assertSame(sendPendingRPC, sendPendingRPC.getDefaultInstanceForType());
    assertSame(sendPendingRPC, toDeviceActorMsg.getSendPendingRPCOrBuilder());
    assertSame(sessionEvent, sessionEvent.getDefaultInstanceForType());
    assertSame(sessionEvent, toDeviceActorMsg.getSessionEventOrBuilder());
    assertSame(sessionInfo, sessionInfo.getDefaultInstanceForType());
    assertSame(sessionInfo, toDeviceActorMsg.getSessionInfoOrBuilder());
    assertSame(subscribeToAttributes, subscribeToAttributes.getDefaultInstanceForType());
    assertSame(subscribeToAttributes, toDeviceActorMsg.getSubscribeToAttributesOrBuilder());
    assertSame(subscribeToRPC, subscribeToRPC.getDefaultInstanceForType());
    assertSame(subscribeToRPC, toDeviceActorMsg.getSubscribeToRPCOrBuilder());
    assertSame(subscriptionInfo, subscriptionInfo.getDefaultInstanceForType());
    assertSame(subscriptionInfo, toDeviceActorMsg.getSubscriptionInfoOrBuilder());
    assertSame(toDeviceRPCCallResponse, toDeviceRPCCallResponse.getDefaultInstanceForType());
    assertSame(toDeviceRPCCallResponse, toDeviceActorMsg.getToDeviceRPCCallResponseOrBuilder());
    assertSame(uplinkNotificationMsg, toDeviceActorMsg.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#notificationUpdateToProto(TenantId, UserId, NotificationUpdate)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#notificationUpdateToProto(TenantId, UserId, NotificationUpdate)}
   */
  @Test
  @DisplayName("Test notificationUpdateToProto(TenantId, UserId, NotificationUpdate); when UserId(UUID) with id is randomUUID")
  void testNotificationUpdateToProto_whenUserIdWithIdIsRandomUUID() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UserId recipientId = new UserId(UUID.randomUUID());

    // Act
    TransportProtos.ToCoreMsg actualNotificationUpdateToProtoResult = TbSubscriptionUtils
        .notificationUpdateToProto(tenantId, recipientId, new NotificationUpdate());

    // Assert
    Descriptors.Descriptor descriptorForType = actualNotificationUpdateToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    TransportProtos.TransportToDeviceActorMsg toDeviceActorMsg = actualNotificationUpdateToProtoResult
        .getToDeviceActorMsg();
    TransportProtos.GetAttributeRequestMsg getAttributes = toDeviceActorMsg.getGetAttributes();
    assertSame(reservedNameList, getAttributes.getClientAttributeNamesList());
    assertSame(reservedNameList, getAttributes.getSharedAttributeNamesList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options.getUninterpretedOptionList();
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    TransportProtos.ToDeviceActorNotificationMsgProto toDeviceActorNotification = actualNotificationUpdateToProtoResult
        .getToDeviceActorNotification();
    TransportProtos.DeviceAttributesEventMsgProto deviceAttributesEventMsg = toDeviceActorNotification
        .getDeviceAttributesEventMsg();
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getDeletedKeysOrBuilderList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesList());
    assertSame(uninterpretedOptionList, deviceAttributesEventMsg.getValuesOrBuilderList());
    TransportProtos.EdgeNotificationMsgProto edgeNotificationMsg = actualNotificationUpdateToProtoResult
        .getEdgeNotificationMsg();
    TransportProtos.PostAttributeMsg postAttributesMsg = edgeNotificationMsg.getPostAttributesMsg();
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvList());
    assertSame(uninterpretedOptionList, postAttributesMsg.getKvOrBuilderList());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = edgeNotificationMsg.getPostTelemetryMsg();
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListList());
    assertSame(uninterpretedOptionList, postTelemetryMsg.getTsKvListOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.DeviceActivityProto deviceActivityMsg = actualNotificationUpdateToProtoResult
        .getDeviceActivityMsg();
    Descriptors.Descriptor descriptorForType2 = deviceActivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.DeviceConnectProto deviceConnectMsg = actualNotificationUpdateToProtoResult.getDeviceConnectMsg();
    Descriptors.Descriptor descriptorForType3 = deviceConnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.DeviceDisconnectProto deviceDisconnectMsg = actualNotificationUpdateToProtoResult
        .getDeviceDisconnectMsg();
    Descriptors.Descriptor descriptorForType4 = deviceDisconnectMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.DeviceInactivityProto deviceInactivityMsg = actualNotificationUpdateToProtoResult
        .getDeviceInactivityMsg();
    Descriptors.Descriptor descriptorForType5 = deviceInactivityMsg.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.DeviceStateServiceMsgProto deviceStateServiceMsg = actualNotificationUpdateToProtoResult
        .getDeviceStateServiceMsg();
    Descriptors.Descriptor descriptorForType6 = deviceStateServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    Descriptors.Descriptor descriptorForType7 = edgeNotificationMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ErrorEventProto errorEventMsg = actualNotificationUpdateToProtoResult.getErrorEventMsg();
    Descriptors.Descriptor descriptorForType8 = errorEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.LifecycleEventProto lifecycleEventMsg = actualNotificationUpdateToProtoResult
        .getLifecycleEventMsg();
    Descriptors.Descriptor descriptorForType9 = lifecycleEventMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.NotificationSchedulerServiceMsg notificationSchedulerServiceMsg = actualNotificationUpdateToProtoResult
        .getNotificationSchedulerServiceMsg();
    Descriptors.Descriptor descriptorForType10 = notificationSchedulerServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    Descriptors.Descriptor descriptorForType11 = toDeviceActorMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toDeviceActorNotification.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreMsg defaultInstanceForType = actualNotificationUpdateToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualNotificationUpdateToProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, postAttributesMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceActivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceConnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceDisconnectMsg.getUnknownFields());
    assertSame(unknownFields, deviceInactivityMsg.getUnknownFields());
    assertSame(unknownFields, deviceStateServiceMsg.getUnknownFields());
    assertSame(unknownFields, edgeNotificationMsg.getUnknownFields());
    assertSame(unknownFields, errorEventMsg.getUnknownFields());
    assertSame(unknownFields, lifecycleEventMsg.getUnknownFields());
    assertSame(unknownFields, notificationSchedulerServiceMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorMsg.getUnknownFields());
    assertSame(unknownFields, toDeviceActorNotification.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = actualNotificationUpdateToProtoResult
        .getToSubscriptionMgrMsg();
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, deviceAttributesEventMsg.getUnknownFields());
    TransportProtos.DeviceCredentialsUpdateMsgProto deviceCredentialsUpdateMsg = toDeviceActorNotification
        .getDeviceCredentialsUpdateMsg();
    assertSame(unknownFields, deviceCredentialsUpdateMsg.getUnknownFields());
    TransportProtos.ClaimDeviceMsg claimDevice = toDeviceActorMsg.getClaimDevice();
    assertSame(unknownFields, claimDevice.getUnknownFields());
    assertSame(unknownFields, getAttributes.getUnknownFields());
    TransportProtos.ProvisionDeviceRequestMsg provisionDevice = toDeviceActorMsg.getProvisionDevice();
    assertSame(unknownFields, provisionDevice.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseStatusMsg rpcResponseStatusMsg = toDeviceActorMsg.getRpcResponseStatusMsg();
    assertSame(unknownFields, rpcResponseStatusMsg.getUnknownFields());
    TransportProtos.SendPendingRPCMsg sendPendingRPC = toDeviceActorMsg.getSendPendingRPC();
    assertSame(unknownFields, sendPendingRPC.getUnknownFields());
    TransportProtos.SessionEventMsg sessionEvent = toDeviceActorMsg.getSessionEvent();
    assertSame(unknownFields, sessionEvent.getUnknownFields());
    TransportProtos.SessionInfoProto sessionInfo = toDeviceActorMsg.getSessionInfo();
    assertSame(unknownFields, sessionInfo.getUnknownFields());
    TransportProtos.SubscribeToAttributeUpdatesMsg subscribeToAttributes = toDeviceActorMsg.getSubscribeToAttributes();
    assertSame(unknownFields, subscribeToAttributes.getUnknownFields());
    TransportProtos.SubscribeToRPCMsg subscribeToRPC = toDeviceActorMsg.getSubscribeToRPC();
    assertSame(unknownFields, subscribeToRPC.getUnknownFields());
    TransportProtos.SubscriptionInfoProto subscriptionInfo = toDeviceActorMsg.getSubscriptionInfo();
    assertSame(unknownFields, subscriptionInfo.getUnknownFields());
    TransportProtos.ToDeviceRpcResponseMsg toDeviceRPCCallResponse = toDeviceActorMsg.getToDeviceRPCCallResponse();
    assertSame(unknownFields, toDeviceRPCCallResponse.getUnknownFields());
    TransportProtos.UplinkNotificationMsg uplinkNotificationMsg = toDeviceActorMsg.getUplinkNotificationMsg();
    assertSame(unknownFields, uplinkNotificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(postAttributesMsg, edgeNotificationMsg.getPostAttributesMsgOrBuilder());
    assertSame(postAttributesMsg, postAttributesMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, edgeNotificationMsg.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, deviceActivityMsg.getDefaultInstanceForType());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsg());
    assertSame(deviceActivityMsg, defaultInstanceForType.getDeviceActivityMsgOrBuilder());
    assertSame(deviceActivityMsg, actualNotificationUpdateToProtoResult.getDeviceActivityMsgOrBuilder());
    assertSame(deviceConnectMsg, deviceConnectMsg.getDefaultInstanceForType());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsg());
    assertSame(deviceConnectMsg, defaultInstanceForType.getDeviceConnectMsgOrBuilder());
    assertSame(deviceConnectMsg, actualNotificationUpdateToProtoResult.getDeviceConnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, deviceDisconnectMsg.getDefaultInstanceForType());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsg());
    assertSame(deviceDisconnectMsg, defaultInstanceForType.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceDisconnectMsg, actualNotificationUpdateToProtoResult.getDeviceDisconnectMsgOrBuilder());
    assertSame(deviceInactivityMsg, deviceInactivityMsg.getDefaultInstanceForType());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsg());
    assertSame(deviceInactivityMsg, defaultInstanceForType.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceInactivityMsg, actualNotificationUpdateToProtoResult.getDeviceInactivityMsgOrBuilder());
    assertSame(deviceStateServiceMsg, deviceStateServiceMsg.getDefaultInstanceForType());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsg());
    assertSame(deviceStateServiceMsg, defaultInstanceForType.getDeviceStateServiceMsgOrBuilder());
    assertSame(deviceStateServiceMsg, actualNotificationUpdateToProtoResult.getDeviceStateServiceMsgOrBuilder());
    assertSame(edgeNotificationMsg, edgeNotificationMsg.getDefaultInstanceForType());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsg());
    assertSame(edgeNotificationMsg, defaultInstanceForType.getEdgeNotificationMsgOrBuilder());
    assertSame(edgeNotificationMsg, actualNotificationUpdateToProtoResult.getEdgeNotificationMsgOrBuilder());
    assertSame(errorEventMsg, errorEventMsg.getDefaultInstanceForType());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsg());
    assertSame(errorEventMsg, defaultInstanceForType.getErrorEventMsgOrBuilder());
    assertSame(errorEventMsg, actualNotificationUpdateToProtoResult.getErrorEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, lifecycleEventMsg.getDefaultInstanceForType());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsg());
    assertSame(lifecycleEventMsg, defaultInstanceForType.getLifecycleEventMsgOrBuilder());
    assertSame(lifecycleEventMsg, actualNotificationUpdateToProtoResult.getLifecycleEventMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg, notificationSchedulerServiceMsg.getDefaultInstanceForType());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsg());
    assertSame(notificationSchedulerServiceMsg, defaultInstanceForType.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(notificationSchedulerServiceMsg,
        actualNotificationUpdateToProtoResult.getNotificationSchedulerServiceMsgOrBuilder());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsg());
    assertSame(toDeviceActorMsg, defaultInstanceForType.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, actualNotificationUpdateToProtoResult.getToDeviceActorMsgOrBuilder());
    assertSame(toDeviceActorMsg, toDeviceActorMsg.getDefaultInstanceForType());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotification());
    assertSame(toDeviceActorNotification, defaultInstanceForType.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification,
        actualNotificationUpdateToProtoResult.getToDeviceActorNotificationOrBuilder());
    assertSame(toDeviceActorNotification, toDeviceActorNotification.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, actualNotificationUpdateToProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(deviceAttributesEventMsg, deviceAttributesEventMsg.getDefaultInstanceForType());
    assertSame(deviceAttributesEventMsg, toDeviceActorNotification.getDeviceAttributesEventMsgOrBuilder());
    assertSame(deviceCredentialsUpdateMsg, deviceCredentialsUpdateMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsUpdateMsg, toDeviceActorNotification.getDeviceCredentialsUpdateMsgOrBuilder());
    TransportProtos.DeviceDeleteMsgProto deviceDeleteMsg = toDeviceActorNotification.getDeviceDeleteMsg();
    assertSame(deviceDeleteMsg, deviceDeleteMsg.getDefaultInstanceForType());
    assertSame(deviceDeleteMsg, toDeviceActorNotification.getDeviceDeleteMsgOrBuilder());
    assertSame(claimDevice, claimDevice.getDefaultInstanceForType());
    assertSame(claimDevice, toDeviceActorMsg.getClaimDeviceOrBuilder());
    assertSame(getAttributes, getAttributes.getDefaultInstanceForType());
    assertSame(getAttributes, toDeviceActorMsg.getGetAttributesOrBuilder());
    assertSame(provisionDevice, provisionDevice.getDefaultInstanceForType());
    assertSame(provisionDevice, toDeviceActorMsg.getProvisionDeviceOrBuilder());
    assertSame(rpcResponseStatusMsg, rpcResponseStatusMsg.getDefaultInstanceForType());
    assertSame(rpcResponseStatusMsg, toDeviceActorMsg.getRpcResponseStatusMsgOrBuilder());
    assertSame(sendPendingRPC, sendPendingRPC.getDefaultInstanceForType());
    assertSame(sendPendingRPC, toDeviceActorMsg.getSendPendingRPCOrBuilder());
    assertSame(sessionEvent, sessionEvent.getDefaultInstanceForType());
    assertSame(sessionEvent, toDeviceActorMsg.getSessionEventOrBuilder());
    assertSame(sessionInfo, sessionInfo.getDefaultInstanceForType());
    assertSame(sessionInfo, toDeviceActorMsg.getSessionInfoOrBuilder());
    assertSame(subscribeToAttributes, subscribeToAttributes.getDefaultInstanceForType());
    assertSame(subscribeToAttributes, toDeviceActorMsg.getSubscribeToAttributesOrBuilder());
    assertSame(subscribeToRPC, subscribeToRPC.getDefaultInstanceForType());
    assertSame(subscribeToRPC, toDeviceActorMsg.getSubscribeToRPCOrBuilder());
    assertSame(subscriptionInfo, subscriptionInfo.getDefaultInstanceForType());
    assertSame(subscriptionInfo, toDeviceActorMsg.getSubscriptionInfoOrBuilder());
    assertSame(toDeviceRPCCallResponse, toDeviceRPCCallResponse.getDefaultInstanceForType());
    assertSame(toDeviceRPCCallResponse, toDeviceActorMsg.getToDeviceRPCCallResponseOrBuilder());
    assertSame(uplinkNotificationMsg, toDeviceActorMsg.getUplinkNotificationMsgOrBuilder());
    assertSame(uplinkNotificationMsg, uplinkNotificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#notificationRequestUpdateToProto(TenantId, NotificationRequestUpdate)}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#notificationRequestUpdateToProto(TenantId, NotificationRequestUpdate)}
   */
  @Test
  @DisplayName("Test notificationRequestUpdateToProto(TenantId, NotificationRequestUpdate)")
  void testNotificationRequestUpdateToProto() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TransportProtos.ToCoreNotificationMsg actualNotificationRequestUpdateToProtoResult = TbSubscriptionUtils
        .notificationRequestUpdateToProto(tenantId, new NotificationRequestUpdate());

    // Assert
    Descriptors.Descriptor descriptorForType = actualNotificationRequestUpdateToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList expectedKeysList = toProtoResult.getReservedNameList();
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = actualNotificationRequestUpdateToProtoResult
        .getToSubscriptionMgrMsg();
    TransportProtos.TbAttributeDeleteProto attrDelete = toSubscriptionMgrMsg.getAttrDelete();
    assertSame(expectedKeysList, attrDelete.getKeysList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.ComponentLifecycleMsgProto componentLifecycle = actualNotificationRequestUpdateToProtoResult
        .getComponentLifecycle();
    Descriptors.Descriptor descriptorForType2 = componentLifecycle.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.CoreStartupMsg coreStartupMsg = actualNotificationRequestUpdateToProtoResult.getCoreStartupMsg();
    Descriptors.Descriptor descriptorForType3 = coreStartupMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EdgeEventUpdateMsgProto edgeEventUpdate = actualNotificationRequestUpdateToProtoResult
        .getEdgeEventUpdate();
    Descriptors.Descriptor descriptorForType4 = edgeEventUpdate.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.FromDeviceRPCResponseProto fromDeviceRpcResponse = actualNotificationRequestUpdateToProtoResult
        .getFromDeviceRpcResponse();
    Descriptors.Descriptor descriptorForType5 = fromDeviceRpcResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.FromEdgeSyncResponseMsgProto fromEdgeSyncResponse = actualNotificationRequestUpdateToProtoResult
        .getFromEdgeSyncResponse();
    Descriptors.Descriptor descriptorForType6 = fromEdgeSyncResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.NotificationRuleProcessorMsg notificationRuleProcessorMsg = actualNotificationRequestUpdateToProtoResult
        .getNotificationRuleProcessorMsg();
    Descriptors.Descriptor descriptorForType7 = notificationRuleProcessorMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceCacheInvalidateMsg resourceCacheInvalidateMsg = actualNotificationRequestUpdateToProtoResult
        .getResourceCacheInvalidateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceCacheInvalidateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.RestApiCallResponseMsgProto restApiCallResponseMsg = actualNotificationRequestUpdateToProtoResult
        .getRestApiCallResponseMsg();
    Descriptors.Descriptor descriptorForType9 = restApiCallResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToEdgeSyncRequestMsgProto toEdgeSyncRequest = actualNotificationRequestUpdateToProtoResult
        .getToEdgeSyncRequest();
    Descriptors.Descriptor descriptorForType10 = toEdgeSyncRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg = actualNotificationRequestUpdateToProtoResult
        .getToLocalSubscriptionServiceMsg();
    Descriptors.Descriptor descriptorForType11 = toLocalSubscriptionServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toSubscriptionMgrMsg.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreNotificationMsg defaultInstanceForType = actualNotificationRequestUpdateToProtoResult
        .getDefaultInstanceForType();
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(descriptorForType12, toSubscriptionMgrMsg2.getDescriptorForType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualNotificationRequestUpdateToProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionUpdateProto alarmSubUpdate = toLocalSubscriptionServiceMsg.getAlarmSubUpdate();
    assertSame(unknownFields, alarmSubUpdate.getUnknownFields());
    TransportProtos.TbAlarmSubUpdateProto alarmUpdate = toLocalSubscriptionServiceMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate.getUnknownFields());
    TransportProtos.TbSubUpdateProto attrUpdate = toLocalSubscriptionServiceMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate.getUnknownFields());
    TransportProtos.NotificationsSubscriptionUpdateProto notificationsSubUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsSubUpdate();
    assertSame(unknownFields, notificationsSubUpdate.getUnknownFields());
    TransportProtos.NotificationsSubUpdateProto notificationsUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsUpdate();
    assertSame(unknownFields, notificationsUpdate.getUnknownFields());
    TransportProtos.TbEntitySubEventCallbackProto subEventCallback = toLocalSubscriptionServiceMsg
        .getSubEventCallback();
    assertSame(unknownFields, subEventCallback.getUnknownFields());
    TransportProtos.TbSubscriptionUpdateProto subUpdate = toLocalSubscriptionServiceMsg.getSubUpdate();
    assertSame(unknownFields, subUpdate.getUnknownFields());
    TransportProtos.TbAlarmDeleteProto alarmDelete = toSubscriptionMgrMsg.getAlarmDelete();
    assertSame(unknownFields, alarmDelete.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionProto alarmSub = toSubscriptionMgrMsg.getAlarmSub();
    assertSame(unknownFields, alarmSub.getUnknownFields());
    TransportProtos.TbAlarmUpdateProto alarmUpdate2 = toSubscriptionMgrMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate2.getUnknownFields());
    assertSame(unknownFields, attrDelete.getUnknownFields());
    TransportProtos.TbAttributeUpdateProto attrUpdate2 = toSubscriptionMgrMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate2.getUnknownFields());
    TransportProtos.TbAttributeSubscriptionProto attributeSub = toSubscriptionMgrMsg.getAttributeSub();
    assertSame(unknownFields, attributeSub.getUnknownFields());
    TransportProtos.NotificationRequestUpdateProto notificationRequestUpdate = toSubscriptionMgrMsg
        .getNotificationRequestUpdate();
    assertSame(unknownFields, notificationRequestUpdate.getUnknownFields());
    TransportProtos.NotificationUpdateProto notificationUpdate = toSubscriptionMgrMsg.getNotificationUpdate();
    assertSame(unknownFields, notificationUpdate.getUnknownFields());
    TransportProtos.NotificationsCountSubscriptionProto notificationsCountSub = toSubscriptionMgrMsg
        .getNotificationsCountSub();
    assertSame(unknownFields, notificationsCountSub.getUnknownFields());
    TransportProtos.NotificationsSubscriptionProto notificationsSub = toSubscriptionMgrMsg.getNotificationsSub();
    assertSame(unknownFields, notificationsSub.getUnknownFields());
    TransportProtos.TbSubscriptionCloseProto subClose = toSubscriptionMgrMsg.getSubClose();
    assertSame(unknownFields, subClose.getUnknownFields());
    assertSame(unknownFields, componentLifecycle.getUnknownFields());
    assertSame(unknownFields, coreStartupMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, edgeEventUpdate.getUnknownFields());
    assertSame(unknownFields, fromDeviceRpcResponse.getUnknownFields());
    assertSame(unknownFields, fromEdgeSyncResponse.getUnknownFields());
    assertSame(unknownFields, notificationRuleProcessorMsg.getUnknownFields());
    assertSame(unknownFields, resourceCacheInvalidateMsg.getUnknownFields());
    assertSame(unknownFields, restApiCallResponseMsg.getUnknownFields());
    assertSame(unknownFields, toEdgeSyncRequest.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg.getUnknownFields());
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.VersionControlResponseMsg vcResponseMsg = actualNotificationRequestUpdateToProtoResult
        .getVcResponseMsg();
    assertSame(unknownFields, vcResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, alarmSubUpdate.getDefaultInstanceForType());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate, alarmUpdate.getDefaultInstanceForType());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdateOrBuilder());
    assertSame(attrUpdate, attrUpdate.getDefaultInstanceForType());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, notificationsSubUpdate.getDefaultInstanceForType());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg.getNotificationsUpdateOrBuilder());
    assertSame(notificationsUpdate, notificationsUpdate.getDefaultInstanceForType());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg.getSubEventCallbackOrBuilder());
    assertSame(subEventCallback, subEventCallback.getDefaultInstanceForType());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg.getSubUpdateOrBuilder());
    assertSame(subUpdate, subUpdate.getDefaultInstanceForType());
    ByteString expectedResponse = notificationRuleProcessorMsg.getTrigger();
    assertSame(expectedResponse, restApiCallResponseMsg.getResponse());
    assertSame(alarmDelete, toSubscriptionMgrMsg2.getAlarmDelete());
    assertSame(alarmDelete, toSubscriptionMgrMsg2.getAlarmDeleteOrBuilder());
    assertSame(alarmDelete, toSubscriptionMgrMsg.getAlarmDeleteOrBuilder());
    assertSame(alarmDelete, alarmDelete.getDefaultInstanceForType());
    assertSame(alarmSub, toSubscriptionMgrMsg2.getAlarmSub());
    assertSame(alarmSub, toSubscriptionMgrMsg2.getAlarmSubOrBuilder());
    assertSame(alarmSub, toSubscriptionMgrMsg.getAlarmSubOrBuilder());
    assertSame(alarmSub, alarmSub.getDefaultInstanceForType());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg2.getAlarmUpdate());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg2.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate2, alarmUpdate2.getDefaultInstanceForType());
    assertSame(attrDelete, toSubscriptionMgrMsg2.getAttrDelete());
    assertSame(attrDelete, toSubscriptionMgrMsg2.getAttrDeleteOrBuilder());
    assertSame(attrDelete, toSubscriptionMgrMsg.getAttrDeleteOrBuilder());
    assertSame(attrDelete, attrDelete.getDefaultInstanceForType());
    assertSame(attrUpdate2, toSubscriptionMgrMsg2.getAttrUpdate());
    assertSame(attrUpdate2, toSubscriptionMgrMsg2.getAttrUpdateOrBuilder());
    assertSame(attrUpdate2, toSubscriptionMgrMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate2, attrUpdate2.getDefaultInstanceForType());
    assertSame(attributeSub, toSubscriptionMgrMsg2.getAttributeSub());
    assertSame(attributeSub, toSubscriptionMgrMsg2.getAttributeSubOrBuilder());
    assertSame(attributeSub, toSubscriptionMgrMsg.getAttributeSubOrBuilder());
    assertSame(attributeSub, attributeSub.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate, toSubscriptionMgrMsg.getNotificationRequestUpdateOrBuilder());
    assertSame(notificationUpdate, notificationUpdate.getDefaultInstanceForType());
    assertSame(notificationUpdate, toSubscriptionMgrMsg2.getNotificationUpdate());
    assertSame(notificationUpdate, toSubscriptionMgrMsg2.getNotificationUpdateOrBuilder());
    assertSame(notificationUpdate, toSubscriptionMgrMsg.getNotificationUpdateOrBuilder());
    assertSame(notificationsCountSub, notificationsCountSub.getDefaultInstanceForType());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg2.getNotificationsCountSub());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg2.getNotificationsCountSubOrBuilder());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg.getNotificationsCountSubOrBuilder());
    assertSame(notificationsSub, notificationsSub.getDefaultInstanceForType());
    assertSame(notificationsSub, toSubscriptionMgrMsg2.getNotificationsSub());
    assertSame(notificationsSub, toSubscriptionMgrMsg2.getNotificationsSubOrBuilder());
    assertSame(notificationsSub, toSubscriptionMgrMsg.getNotificationsSubOrBuilder());
    assertSame(subClose, toSubscriptionMgrMsg2.getSubClose());
    assertSame(subClose, toSubscriptionMgrMsg2.getSubCloseOrBuilder());
    assertSame(subClose, toSubscriptionMgrMsg.getSubCloseOrBuilder());
    assertSame(subClose, subClose.getDefaultInstanceForType());
    TransportProtos.TbEntitySubEventProto subEvent = toSubscriptionMgrMsg.getSubEvent();
    assertSame(subEvent, toSubscriptionMgrMsg2.getSubEvent());
    assertSame(subEvent, toSubscriptionMgrMsg2.getSubEventOrBuilder());
    assertSame(subEvent, toSubscriptionMgrMsg.getSubEventOrBuilder());
    assertSame(componentLifecycle, componentLifecycle.getDefaultInstanceForType());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycle());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycleOrBuilder());
    assertSame(componentLifecycle, actualNotificationRequestUpdateToProtoResult.getComponentLifecycleOrBuilder());
    assertSame(coreStartupMsg, coreStartupMsg.getDefaultInstanceForType());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsg());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsgOrBuilder());
    assertSame(coreStartupMsg, actualNotificationRequestUpdateToProtoResult.getCoreStartupMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, edgeEventUpdate.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdate());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdateOrBuilder());
    assertSame(edgeEventUpdate, actualNotificationRequestUpdateToProtoResult.getEdgeEventUpdateOrBuilder());
    assertSame(fromDeviceRpcResponse, fromDeviceRpcResponse.getDefaultInstanceForType());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponse());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromDeviceRpcResponse, actualNotificationRequestUpdateToProtoResult.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, fromEdgeSyncResponse.getDefaultInstanceForType());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponse());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, actualNotificationRequestUpdateToProtoResult.getFromEdgeSyncResponseOrBuilder());
    assertSame(notificationRuleProcessorMsg, notificationRuleProcessorMsg.getDefaultInstanceForType());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsg());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(notificationRuleProcessorMsg,
        actualNotificationRequestUpdateToProtoResult.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg, resourceCacheInvalidateMsg.getDefaultInstanceForType());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsg());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg,
        actualNotificationRequestUpdateToProtoResult.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(restApiCallResponseMsg, restApiCallResponseMsg.getDefaultInstanceForType());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsg());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsgOrBuilder());
    assertSame(restApiCallResponseMsg,
        actualNotificationRequestUpdateToProtoResult.getRestApiCallResponseMsgOrBuilder());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequest());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, actualNotificationRequestUpdateToProtoResult.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, toEdgeSyncRequest.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg, toLocalSubscriptionServiceMsg.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg, defaultInstanceForType.getToLocalSubscriptionServiceMsg());
    assertSame(toLocalSubscriptionServiceMsg, defaultInstanceForType.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toLocalSubscriptionServiceMsg,
        actualNotificationRequestUpdateToProtoResult.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg2, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg2, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, actualNotificationRequestUpdateToProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsg());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, actualNotificationRequestUpdateToProtoResult.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, vcResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#notificationRequestUpdateToProto(TenantId, NotificationRequestUpdate)}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#notificationRequestUpdateToProto(TenantId, NotificationRequestUpdate)}
   */
  @Test
  @DisplayName("Test notificationRequestUpdateToProto(TenantId, NotificationRequestUpdate)")
  void testNotificationRequestUpdateToProto2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestUpdate notificationRequestUpdate = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();

    // Act
    TransportProtos.ToCoreNotificationMsg actualNotificationRequestUpdateToProtoResult = TbSubscriptionUtils
        .notificationRequestUpdateToProto(tenantId, notificationRequestUpdate);

    // Assert
    Descriptors.Descriptor descriptorForType = actualNotificationRequestUpdateToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList expectedKeysList = toProtoResult.getReservedNameList();
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = actualNotificationRequestUpdateToProtoResult
        .getToSubscriptionMgrMsg();
    TransportProtos.TbAttributeDeleteProto attrDelete = toSubscriptionMgrMsg.getAttrDelete();
    assertSame(expectedKeysList, attrDelete.getKeysList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.ComponentLifecycleMsgProto componentLifecycle = actualNotificationRequestUpdateToProtoResult
        .getComponentLifecycle();
    Descriptors.Descriptor descriptorForType2 = componentLifecycle.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.CoreStartupMsg coreStartupMsg = actualNotificationRequestUpdateToProtoResult.getCoreStartupMsg();
    Descriptors.Descriptor descriptorForType3 = coreStartupMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EdgeEventUpdateMsgProto edgeEventUpdate = actualNotificationRequestUpdateToProtoResult
        .getEdgeEventUpdate();
    Descriptors.Descriptor descriptorForType4 = edgeEventUpdate.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.FromDeviceRPCResponseProto fromDeviceRpcResponse = actualNotificationRequestUpdateToProtoResult
        .getFromDeviceRpcResponse();
    Descriptors.Descriptor descriptorForType5 = fromDeviceRpcResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.FromEdgeSyncResponseMsgProto fromEdgeSyncResponse = actualNotificationRequestUpdateToProtoResult
        .getFromEdgeSyncResponse();
    Descriptors.Descriptor descriptorForType6 = fromEdgeSyncResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.NotificationRuleProcessorMsg notificationRuleProcessorMsg = actualNotificationRequestUpdateToProtoResult
        .getNotificationRuleProcessorMsg();
    Descriptors.Descriptor descriptorForType7 = notificationRuleProcessorMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceCacheInvalidateMsg resourceCacheInvalidateMsg = actualNotificationRequestUpdateToProtoResult
        .getResourceCacheInvalidateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceCacheInvalidateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.RestApiCallResponseMsgProto restApiCallResponseMsg = actualNotificationRequestUpdateToProtoResult
        .getRestApiCallResponseMsg();
    Descriptors.Descriptor descriptorForType9 = restApiCallResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToEdgeSyncRequestMsgProto toEdgeSyncRequest = actualNotificationRequestUpdateToProtoResult
        .getToEdgeSyncRequest();
    Descriptors.Descriptor descriptorForType10 = toEdgeSyncRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg = actualNotificationRequestUpdateToProtoResult
        .getToLocalSubscriptionServiceMsg();
    Descriptors.Descriptor descriptorForType11 = toLocalSubscriptionServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toSubscriptionMgrMsg.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreNotificationMsg defaultInstanceForType = actualNotificationRequestUpdateToProtoResult
        .getDefaultInstanceForType();
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(descriptorForType12, toSubscriptionMgrMsg2.getDescriptorForType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualNotificationRequestUpdateToProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionUpdateProto alarmSubUpdate = toLocalSubscriptionServiceMsg.getAlarmSubUpdate();
    assertSame(unknownFields, alarmSubUpdate.getUnknownFields());
    TransportProtos.TbAlarmSubUpdateProto alarmUpdate = toLocalSubscriptionServiceMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate.getUnknownFields());
    TransportProtos.TbSubUpdateProto attrUpdate = toLocalSubscriptionServiceMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate.getUnknownFields());
    TransportProtos.NotificationsSubscriptionUpdateProto notificationsSubUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsSubUpdate();
    assertSame(unknownFields, notificationsSubUpdate.getUnknownFields());
    TransportProtos.NotificationsSubUpdateProto notificationsUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsUpdate();
    assertSame(unknownFields, notificationsUpdate.getUnknownFields());
    TransportProtos.TbEntitySubEventCallbackProto subEventCallback = toLocalSubscriptionServiceMsg
        .getSubEventCallback();
    assertSame(unknownFields, subEventCallback.getUnknownFields());
    TransportProtos.TbSubscriptionUpdateProto subUpdate = toLocalSubscriptionServiceMsg.getSubUpdate();
    assertSame(unknownFields, subUpdate.getUnknownFields());
    TransportProtos.TbAlarmDeleteProto alarmDelete = toSubscriptionMgrMsg.getAlarmDelete();
    assertSame(unknownFields, alarmDelete.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionProto alarmSub = toSubscriptionMgrMsg.getAlarmSub();
    assertSame(unknownFields, alarmSub.getUnknownFields());
    TransportProtos.TbAlarmUpdateProto alarmUpdate2 = toSubscriptionMgrMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate2.getUnknownFields());
    assertSame(unknownFields, attrDelete.getUnknownFields());
    TransportProtos.TbAttributeUpdateProto attrUpdate2 = toSubscriptionMgrMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate2.getUnknownFields());
    TransportProtos.TbAttributeSubscriptionProto attributeSub = toSubscriptionMgrMsg.getAttributeSub();
    assertSame(unknownFields, attributeSub.getUnknownFields());
    TransportProtos.NotificationRequestUpdateProto notificationRequestUpdate2 = toSubscriptionMgrMsg
        .getNotificationRequestUpdate();
    assertSame(unknownFields, notificationRequestUpdate2.getUnknownFields());
    TransportProtos.NotificationUpdateProto notificationUpdate = toSubscriptionMgrMsg.getNotificationUpdate();
    assertSame(unknownFields, notificationUpdate.getUnknownFields());
    TransportProtos.NotificationsCountSubscriptionProto notificationsCountSub = toSubscriptionMgrMsg
        .getNotificationsCountSub();
    assertSame(unknownFields, notificationsCountSub.getUnknownFields());
    TransportProtos.NotificationsSubscriptionProto notificationsSub = toSubscriptionMgrMsg.getNotificationsSub();
    assertSame(unknownFields, notificationsSub.getUnknownFields());
    TransportProtos.TbSubscriptionCloseProto subClose = toSubscriptionMgrMsg.getSubClose();
    assertSame(unknownFields, subClose.getUnknownFields());
    assertSame(unknownFields, componentLifecycle.getUnknownFields());
    assertSame(unknownFields, coreStartupMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, edgeEventUpdate.getUnknownFields());
    assertSame(unknownFields, fromDeviceRpcResponse.getUnknownFields());
    assertSame(unknownFields, fromEdgeSyncResponse.getUnknownFields());
    assertSame(unknownFields, notificationRuleProcessorMsg.getUnknownFields());
    assertSame(unknownFields, resourceCacheInvalidateMsg.getUnknownFields());
    assertSame(unknownFields, restApiCallResponseMsg.getUnknownFields());
    assertSame(unknownFields, toEdgeSyncRequest.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg.getUnknownFields());
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.VersionControlResponseMsg vcResponseMsg = actualNotificationRequestUpdateToProtoResult
        .getVcResponseMsg();
    assertSame(unknownFields, vcResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, alarmSubUpdate.getDefaultInstanceForType());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate, alarmUpdate.getDefaultInstanceForType());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdateOrBuilder());
    assertSame(attrUpdate, attrUpdate.getDefaultInstanceForType());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, notificationsSubUpdate.getDefaultInstanceForType());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg.getNotificationsUpdateOrBuilder());
    assertSame(notificationsUpdate, notificationsUpdate.getDefaultInstanceForType());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg.getSubEventCallbackOrBuilder());
    assertSame(subEventCallback, subEventCallback.getDefaultInstanceForType());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg.getSubUpdateOrBuilder());
    assertSame(subUpdate, subUpdate.getDefaultInstanceForType());
    ByteString expectedResponse = notificationRuleProcessorMsg.getTrigger();
    assertSame(expectedResponse, restApiCallResponseMsg.getResponse());
    assertSame(alarmDelete, toSubscriptionMgrMsg2.getAlarmDelete());
    assertSame(alarmDelete, toSubscriptionMgrMsg2.getAlarmDeleteOrBuilder());
    assertSame(alarmDelete, toSubscriptionMgrMsg.getAlarmDeleteOrBuilder());
    assertSame(alarmDelete, alarmDelete.getDefaultInstanceForType());
    assertSame(alarmSub, toSubscriptionMgrMsg2.getAlarmSub());
    assertSame(alarmSub, toSubscriptionMgrMsg2.getAlarmSubOrBuilder());
    assertSame(alarmSub, toSubscriptionMgrMsg.getAlarmSubOrBuilder());
    assertSame(alarmSub, alarmSub.getDefaultInstanceForType());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg2.getAlarmUpdate());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg2.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate2, alarmUpdate2.getDefaultInstanceForType());
    assertSame(attrDelete, toSubscriptionMgrMsg2.getAttrDelete());
    assertSame(attrDelete, toSubscriptionMgrMsg2.getAttrDeleteOrBuilder());
    assertSame(attrDelete, toSubscriptionMgrMsg.getAttrDeleteOrBuilder());
    assertSame(attrDelete, attrDelete.getDefaultInstanceForType());
    assertSame(attrUpdate2, toSubscriptionMgrMsg2.getAttrUpdate());
    assertSame(attrUpdate2, toSubscriptionMgrMsg2.getAttrUpdateOrBuilder());
    assertSame(attrUpdate2, toSubscriptionMgrMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate2, attrUpdate2.getDefaultInstanceForType());
    assertSame(attributeSub, toSubscriptionMgrMsg2.getAttributeSub());
    assertSame(attributeSub, toSubscriptionMgrMsg2.getAttributeSubOrBuilder());
    assertSame(attributeSub, toSubscriptionMgrMsg.getAttributeSubOrBuilder());
    assertSame(attributeSub, attributeSub.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate2, toSubscriptionMgrMsg.getNotificationRequestUpdateOrBuilder());
    assertSame(notificationUpdate, notificationUpdate.getDefaultInstanceForType());
    assertSame(notificationUpdate, toSubscriptionMgrMsg2.getNotificationUpdate());
    assertSame(notificationUpdate, toSubscriptionMgrMsg2.getNotificationUpdateOrBuilder());
    assertSame(notificationUpdate, toSubscriptionMgrMsg.getNotificationUpdateOrBuilder());
    assertSame(notificationsCountSub, notificationsCountSub.getDefaultInstanceForType());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg2.getNotificationsCountSub());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg2.getNotificationsCountSubOrBuilder());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg.getNotificationsCountSubOrBuilder());
    assertSame(notificationsSub, notificationsSub.getDefaultInstanceForType());
    assertSame(notificationsSub, toSubscriptionMgrMsg2.getNotificationsSub());
    assertSame(notificationsSub, toSubscriptionMgrMsg2.getNotificationsSubOrBuilder());
    assertSame(notificationsSub, toSubscriptionMgrMsg.getNotificationsSubOrBuilder());
    assertSame(subClose, toSubscriptionMgrMsg2.getSubClose());
    assertSame(subClose, toSubscriptionMgrMsg2.getSubCloseOrBuilder());
    assertSame(subClose, toSubscriptionMgrMsg.getSubCloseOrBuilder());
    assertSame(subClose, subClose.getDefaultInstanceForType());
    TransportProtos.TbEntitySubEventProto subEvent = toSubscriptionMgrMsg.getSubEvent();
    assertSame(subEvent, toSubscriptionMgrMsg2.getSubEvent());
    assertSame(subEvent, toSubscriptionMgrMsg2.getSubEventOrBuilder());
    assertSame(subEvent, toSubscriptionMgrMsg.getSubEventOrBuilder());
    assertSame(componentLifecycle, componentLifecycle.getDefaultInstanceForType());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycle());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycleOrBuilder());
    assertSame(componentLifecycle, actualNotificationRequestUpdateToProtoResult.getComponentLifecycleOrBuilder());
    assertSame(coreStartupMsg, coreStartupMsg.getDefaultInstanceForType());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsg());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsgOrBuilder());
    assertSame(coreStartupMsg, actualNotificationRequestUpdateToProtoResult.getCoreStartupMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, edgeEventUpdate.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdate());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdateOrBuilder());
    assertSame(edgeEventUpdate, actualNotificationRequestUpdateToProtoResult.getEdgeEventUpdateOrBuilder());
    assertSame(fromDeviceRpcResponse, fromDeviceRpcResponse.getDefaultInstanceForType());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponse());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromDeviceRpcResponse, actualNotificationRequestUpdateToProtoResult.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, fromEdgeSyncResponse.getDefaultInstanceForType());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponse());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, actualNotificationRequestUpdateToProtoResult.getFromEdgeSyncResponseOrBuilder());
    assertSame(notificationRuleProcessorMsg, notificationRuleProcessorMsg.getDefaultInstanceForType());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsg());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(notificationRuleProcessorMsg,
        actualNotificationRequestUpdateToProtoResult.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg, resourceCacheInvalidateMsg.getDefaultInstanceForType());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsg());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg,
        actualNotificationRequestUpdateToProtoResult.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(restApiCallResponseMsg, restApiCallResponseMsg.getDefaultInstanceForType());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsg());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsgOrBuilder());
    assertSame(restApiCallResponseMsg,
        actualNotificationRequestUpdateToProtoResult.getRestApiCallResponseMsgOrBuilder());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequest());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, actualNotificationRequestUpdateToProtoResult.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, toEdgeSyncRequest.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg, toLocalSubscriptionServiceMsg.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg, defaultInstanceForType.getToLocalSubscriptionServiceMsg());
    assertSame(toLocalSubscriptionServiceMsg, defaultInstanceForType.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toLocalSubscriptionServiceMsg,
        actualNotificationRequestUpdateToProtoResult.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg2, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg2, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, actualNotificationRequestUpdateToProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsg());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, actualNotificationRequestUpdateToProtoResult.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, vcResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TbSubscriptionUtils#notificationRequestUpdateToProto(TenantId, NotificationRequestUpdate)}.
   * <p>
   * Method under test:
   * {@link TbSubscriptionUtils#notificationRequestUpdateToProto(TenantId, NotificationRequestUpdate)}
   */
  @Test
  @DisplayName("Test notificationRequestUpdateToProto(TenantId, NotificationRequestUpdate)")
  void testNotificationRequestUpdateToProto3() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(-1L, -1L));

    // Act
    TransportProtos.ToCoreNotificationMsg actualNotificationRequestUpdateToProtoResult = TbSubscriptionUtils
        .notificationRequestUpdateToProto(tenantId, new NotificationRequestUpdate());

    // Assert
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg = actualNotificationRequestUpdateToProtoResult
        .getToSubscriptionMgrMsg();
    TransportProtos.NotificationRequestUpdateProto notificationRequestUpdate = toSubscriptionMgrMsg
        .getNotificationRequestUpdate();
    assertEquals(-1L, notificationRequestUpdate.getTenantIdLSB());
    assertEquals(-1L, notificationRequestUpdate.getTenantIdMSB());
    Descriptors.Descriptor descriptorForType = actualNotificationRequestUpdateToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    ProtocolStringList expectedKeysList = toProtoResult.getReservedNameList();
    TransportProtos.TbAttributeDeleteProto attrDelete = toSubscriptionMgrMsg.getAttrDelete();
    assertSame(expectedKeysList, attrDelete.getKeysList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    TransportProtos.ComponentLifecycleMsgProto componentLifecycle = actualNotificationRequestUpdateToProtoResult
        .getComponentLifecycle();
    Descriptors.Descriptor descriptorForType2 = componentLifecycle.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.CoreStartupMsg coreStartupMsg = actualNotificationRequestUpdateToProtoResult.getCoreStartupMsg();
    Descriptors.Descriptor descriptorForType3 = coreStartupMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.EdgeEventUpdateMsgProto edgeEventUpdate = actualNotificationRequestUpdateToProtoResult
        .getEdgeEventUpdate();
    Descriptors.Descriptor descriptorForType4 = edgeEventUpdate.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.FromDeviceRPCResponseProto fromDeviceRpcResponse = actualNotificationRequestUpdateToProtoResult
        .getFromDeviceRpcResponse();
    Descriptors.Descriptor descriptorForType5 = fromDeviceRpcResponse.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.FromEdgeSyncResponseMsgProto fromEdgeSyncResponse = actualNotificationRequestUpdateToProtoResult
        .getFromEdgeSyncResponse();
    Descriptors.Descriptor descriptorForType6 = fromEdgeSyncResponse.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    TransportProtos.NotificationRuleProcessorMsg notificationRuleProcessorMsg = actualNotificationRequestUpdateToProtoResult
        .getNotificationRuleProcessorMsg();
    Descriptors.Descriptor descriptorForType7 = notificationRuleProcessorMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    TransportProtos.ResourceCacheInvalidateMsg resourceCacheInvalidateMsg = actualNotificationRequestUpdateToProtoResult
        .getResourceCacheInvalidateMsg();
    Descriptors.Descriptor descriptorForType8 = resourceCacheInvalidateMsg.getDescriptorForType();
    assertSame(file, descriptorForType8.getFile());
    TransportProtos.RestApiCallResponseMsgProto restApiCallResponseMsg = actualNotificationRequestUpdateToProtoResult
        .getRestApiCallResponseMsg();
    Descriptors.Descriptor descriptorForType9 = restApiCallResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType9.getFile());
    TransportProtos.ToEdgeSyncRequestMsgProto toEdgeSyncRequest = actualNotificationRequestUpdateToProtoResult
        .getToEdgeSyncRequest();
    Descriptors.Descriptor descriptorForType10 = toEdgeSyncRequest.getDescriptorForType();
    assertSame(file, descriptorForType10.getFile());
    TransportProtos.LocalSubscriptionServiceMsgProto toLocalSubscriptionServiceMsg = actualNotificationRequestUpdateToProtoResult
        .getToLocalSubscriptionServiceMsg();
    Descriptors.Descriptor descriptorForType11 = toLocalSubscriptionServiceMsg.getDescriptorForType();
    assertSame(file, descriptorForType11.getFile());
    Descriptors.Descriptor descriptorForType12 = toSubscriptionMgrMsg.getDescriptorForType();
    assertSame(file, descriptorForType12.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
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
    TransportProtos.ToCoreNotificationMsg defaultInstanceForType = actualNotificationRequestUpdateToProtoResult
        .getDefaultInstanceForType();
    TransportProtos.SubscriptionMgrMsgProto toSubscriptionMgrMsg2 = defaultInstanceForType.getToSubscriptionMgrMsg();
    assertSame(descriptorForType12, toSubscriptionMgrMsg2.getDescriptorForType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualNotificationRequestUpdateToProtoResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionUpdateProto alarmSubUpdate = toLocalSubscriptionServiceMsg.getAlarmSubUpdate();
    assertSame(unknownFields, alarmSubUpdate.getUnknownFields());
    TransportProtos.TbAlarmSubUpdateProto alarmUpdate = toLocalSubscriptionServiceMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate.getUnknownFields());
    TransportProtos.TbSubUpdateProto attrUpdate = toLocalSubscriptionServiceMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate.getUnknownFields());
    TransportProtos.NotificationsSubscriptionUpdateProto notificationsSubUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsSubUpdate();
    assertSame(unknownFields, notificationsSubUpdate.getUnknownFields());
    TransportProtos.NotificationsSubUpdateProto notificationsUpdate = toLocalSubscriptionServiceMsg
        .getNotificationsUpdate();
    assertSame(unknownFields, notificationsUpdate.getUnknownFields());
    TransportProtos.TbEntitySubEventCallbackProto subEventCallback = toLocalSubscriptionServiceMsg
        .getSubEventCallback();
    assertSame(unknownFields, subEventCallback.getUnknownFields());
    TransportProtos.TbSubscriptionUpdateProto subUpdate = toLocalSubscriptionServiceMsg.getSubUpdate();
    assertSame(unknownFields, subUpdate.getUnknownFields());
    TransportProtos.TbAlarmDeleteProto alarmDelete = toSubscriptionMgrMsg.getAlarmDelete();
    assertSame(unknownFields, alarmDelete.getUnknownFields());
    TransportProtos.TbAlarmSubscriptionProto alarmSub = toSubscriptionMgrMsg.getAlarmSub();
    assertSame(unknownFields, alarmSub.getUnknownFields());
    TransportProtos.TbAlarmUpdateProto alarmUpdate2 = toSubscriptionMgrMsg.getAlarmUpdate();
    assertSame(unknownFields, alarmUpdate2.getUnknownFields());
    assertSame(unknownFields, attrDelete.getUnknownFields());
    TransportProtos.TbAttributeUpdateProto attrUpdate2 = toSubscriptionMgrMsg.getAttrUpdate();
    assertSame(unknownFields, attrUpdate2.getUnknownFields());
    TransportProtos.TbAttributeSubscriptionProto attributeSub = toSubscriptionMgrMsg.getAttributeSub();
    assertSame(unknownFields, attributeSub.getUnknownFields());
    assertSame(unknownFields, notificationRequestUpdate.getUnknownFields());
    TransportProtos.NotificationUpdateProto notificationUpdate = toSubscriptionMgrMsg.getNotificationUpdate();
    assertSame(unknownFields, notificationUpdate.getUnknownFields());
    TransportProtos.NotificationsCountSubscriptionProto notificationsCountSub = toSubscriptionMgrMsg
        .getNotificationsCountSub();
    assertSame(unknownFields, notificationsCountSub.getUnknownFields());
    TransportProtos.NotificationsSubscriptionProto notificationsSub = toSubscriptionMgrMsg.getNotificationsSub();
    assertSame(unknownFields, notificationsSub.getUnknownFields());
    TransportProtos.TbSubscriptionCloseProto subClose = toSubscriptionMgrMsg.getSubClose();
    assertSame(unknownFields, subClose.getUnknownFields());
    assertSame(unknownFields, componentLifecycle.getUnknownFields());
    assertSame(unknownFields, coreStartupMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, edgeEventUpdate.getUnknownFields());
    assertSame(unknownFields, fromDeviceRpcResponse.getUnknownFields());
    assertSame(unknownFields, fromEdgeSyncResponse.getUnknownFields());
    assertSame(unknownFields, notificationRuleProcessorMsg.getUnknownFields());
    assertSame(unknownFields, resourceCacheInvalidateMsg.getUnknownFields());
    assertSame(unknownFields, restApiCallResponseMsg.getUnknownFields());
    assertSame(unknownFields, toEdgeSyncRequest.getUnknownFields());
    assertSame(unknownFields, toLocalSubscriptionServiceMsg.getUnknownFields());
    assertSame(unknownFields, toSubscriptionMgrMsg2.getUnknownFields());
    assertSame(unknownFields, toSubscriptionMgrMsg.getUnknownFields());
    TransportProtos.VersionControlResponseMsg vcResponseMsg = actualNotificationRequestUpdateToProtoResult
        .getVcResponseMsg();
    assertSame(unknownFields, vcResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(alarmSubUpdate, toLocalSubscriptionServiceMsg.getAlarmSubUpdateOrBuilder());
    assertSame(alarmSubUpdate, alarmSubUpdate.getDefaultInstanceForType());
    assertSame(alarmUpdate, toLocalSubscriptionServiceMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate, alarmUpdate.getDefaultInstanceForType());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdate());
    assertSame(attrUpdate, toLocalSubscriptionServiceMsg.getTsUpdateOrBuilder());
    assertSame(attrUpdate, attrUpdate.getDefaultInstanceForType());
    assertSame(notificationsSubUpdate, toLocalSubscriptionServiceMsg.getNotificationsSubUpdateOrBuilder());
    assertSame(notificationsSubUpdate, notificationsSubUpdate.getDefaultInstanceForType());
    assertSame(notificationsUpdate, toLocalSubscriptionServiceMsg.getNotificationsUpdateOrBuilder());
    assertSame(notificationsUpdate, notificationsUpdate.getDefaultInstanceForType());
    assertSame(subEventCallback, toLocalSubscriptionServiceMsg.getSubEventCallbackOrBuilder());
    assertSame(subEventCallback, subEventCallback.getDefaultInstanceForType());
    assertSame(subUpdate, toLocalSubscriptionServiceMsg.getSubUpdateOrBuilder());
    assertSame(subUpdate, subUpdate.getDefaultInstanceForType());
    ByteString expectedResponse = notificationRuleProcessorMsg.getTrigger();
    assertSame(expectedResponse, restApiCallResponseMsg.getResponse());
    assertSame(alarmDelete, toSubscriptionMgrMsg2.getAlarmDelete());
    assertSame(alarmDelete, toSubscriptionMgrMsg2.getAlarmDeleteOrBuilder());
    assertSame(alarmDelete, toSubscriptionMgrMsg.getAlarmDeleteOrBuilder());
    assertSame(alarmDelete, alarmDelete.getDefaultInstanceForType());
    assertSame(alarmSub, toSubscriptionMgrMsg2.getAlarmSub());
    assertSame(alarmSub, toSubscriptionMgrMsg2.getAlarmSubOrBuilder());
    assertSame(alarmSub, toSubscriptionMgrMsg.getAlarmSubOrBuilder());
    assertSame(alarmSub, alarmSub.getDefaultInstanceForType());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg2.getAlarmUpdate());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg2.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate2, toSubscriptionMgrMsg.getAlarmUpdateOrBuilder());
    assertSame(alarmUpdate2, alarmUpdate2.getDefaultInstanceForType());
    assertSame(attrDelete, toSubscriptionMgrMsg2.getAttrDelete());
    assertSame(attrDelete, toSubscriptionMgrMsg2.getAttrDeleteOrBuilder());
    assertSame(attrDelete, toSubscriptionMgrMsg.getAttrDeleteOrBuilder());
    assertSame(attrDelete, attrDelete.getDefaultInstanceForType());
    assertSame(attrUpdate2, toSubscriptionMgrMsg2.getAttrUpdate());
    assertSame(attrUpdate2, toSubscriptionMgrMsg2.getAttrUpdateOrBuilder());
    assertSame(attrUpdate2, toSubscriptionMgrMsg.getAttrUpdateOrBuilder());
    assertSame(attrUpdate2, attrUpdate2.getDefaultInstanceForType());
    assertSame(attributeSub, toSubscriptionMgrMsg2.getAttributeSub());
    assertSame(attributeSub, toSubscriptionMgrMsg2.getAttributeSubOrBuilder());
    assertSame(attributeSub, toSubscriptionMgrMsg.getAttributeSubOrBuilder());
    assertSame(attributeSub, attributeSub.getDefaultInstanceForType());
    assertSame(notificationRequestUpdate, toSubscriptionMgrMsg.getNotificationRequestUpdateOrBuilder());
    assertSame(notificationUpdate, notificationUpdate.getDefaultInstanceForType());
    assertSame(notificationUpdate, toSubscriptionMgrMsg2.getNotificationUpdate());
    assertSame(notificationUpdate, toSubscriptionMgrMsg2.getNotificationUpdateOrBuilder());
    assertSame(notificationUpdate, toSubscriptionMgrMsg.getNotificationUpdateOrBuilder());
    assertSame(notificationsCountSub, notificationsCountSub.getDefaultInstanceForType());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg2.getNotificationsCountSub());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg2.getNotificationsCountSubOrBuilder());
    assertSame(notificationsCountSub, toSubscriptionMgrMsg.getNotificationsCountSubOrBuilder());
    assertSame(notificationsSub, notificationsSub.getDefaultInstanceForType());
    assertSame(notificationsSub, toSubscriptionMgrMsg2.getNotificationsSub());
    assertSame(notificationsSub, toSubscriptionMgrMsg2.getNotificationsSubOrBuilder());
    assertSame(notificationsSub, toSubscriptionMgrMsg.getNotificationsSubOrBuilder());
    assertSame(subClose, toSubscriptionMgrMsg2.getSubClose());
    assertSame(subClose, toSubscriptionMgrMsg2.getSubCloseOrBuilder());
    assertSame(subClose, toSubscriptionMgrMsg.getSubCloseOrBuilder());
    assertSame(subClose, subClose.getDefaultInstanceForType());
    TransportProtos.TbEntitySubEventProto subEvent = toSubscriptionMgrMsg.getSubEvent();
    assertSame(subEvent, toSubscriptionMgrMsg2.getSubEvent());
    assertSame(subEvent, toSubscriptionMgrMsg2.getSubEventOrBuilder());
    assertSame(subEvent, toSubscriptionMgrMsg.getSubEventOrBuilder());
    assertSame(componentLifecycle, componentLifecycle.getDefaultInstanceForType());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycle());
    assertSame(componentLifecycle, defaultInstanceForType.getComponentLifecycleOrBuilder());
    assertSame(componentLifecycle, actualNotificationRequestUpdateToProtoResult.getComponentLifecycleOrBuilder());
    assertSame(coreStartupMsg, coreStartupMsg.getDefaultInstanceForType());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsg());
    assertSame(coreStartupMsg, defaultInstanceForType.getCoreStartupMsgOrBuilder());
    assertSame(coreStartupMsg, actualNotificationRequestUpdateToProtoResult.getCoreStartupMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, edgeEventUpdate.getDefaultInstanceForType());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdate());
    assertSame(edgeEventUpdate, defaultInstanceForType.getEdgeEventUpdateOrBuilder());
    assertSame(edgeEventUpdate, actualNotificationRequestUpdateToProtoResult.getEdgeEventUpdateOrBuilder());
    assertSame(fromDeviceRpcResponse, fromDeviceRpcResponse.getDefaultInstanceForType());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponse());
    assertSame(fromDeviceRpcResponse, defaultInstanceForType.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromDeviceRpcResponse, actualNotificationRequestUpdateToProtoResult.getFromDeviceRpcResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, fromEdgeSyncResponse.getDefaultInstanceForType());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponse());
    assertSame(fromEdgeSyncResponse, defaultInstanceForType.getFromEdgeSyncResponseOrBuilder());
    assertSame(fromEdgeSyncResponse, actualNotificationRequestUpdateToProtoResult.getFromEdgeSyncResponseOrBuilder());
    assertSame(notificationRuleProcessorMsg, notificationRuleProcessorMsg.getDefaultInstanceForType());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsg());
    assertSame(notificationRuleProcessorMsg, defaultInstanceForType.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(notificationRuleProcessorMsg,
        actualNotificationRequestUpdateToProtoResult.getNotificationRuleProcessorMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg, resourceCacheInvalidateMsg.getDefaultInstanceForType());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsg());
    assertSame(resourceCacheInvalidateMsg, defaultInstanceForType.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(resourceCacheInvalidateMsg,
        actualNotificationRequestUpdateToProtoResult.getResourceCacheInvalidateMsgOrBuilder());
    assertSame(restApiCallResponseMsg, restApiCallResponseMsg.getDefaultInstanceForType());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsg());
    assertSame(restApiCallResponseMsg, defaultInstanceForType.getRestApiCallResponseMsgOrBuilder());
    assertSame(restApiCallResponseMsg,
        actualNotificationRequestUpdateToProtoResult.getRestApiCallResponseMsgOrBuilder());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequest());
    assertSame(toEdgeSyncRequest, defaultInstanceForType.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, actualNotificationRequestUpdateToProtoResult.getToEdgeSyncRequestOrBuilder());
    assertSame(toEdgeSyncRequest, toEdgeSyncRequest.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg, toLocalSubscriptionServiceMsg.getDefaultInstanceForType());
    assertSame(toLocalSubscriptionServiceMsg, defaultInstanceForType.getToLocalSubscriptionServiceMsg());
    assertSame(toLocalSubscriptionServiceMsg, defaultInstanceForType.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toLocalSubscriptionServiceMsg,
        actualNotificationRequestUpdateToProtoResult.getToLocalSubscriptionServiceMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg2, toSubscriptionMgrMsg2.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg2, toSubscriptionMgrMsg.getDefaultInstanceForType());
    assertSame(toSubscriptionMgrMsg2, defaultInstanceForType.getToSubscriptionMgrMsgOrBuilder());
    assertSame(toSubscriptionMgrMsg, actualNotificationRequestUpdateToProtoResult.getToSubscriptionMgrMsgOrBuilder());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsg());
    assertSame(vcResponseMsg, defaultInstanceForType.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, actualNotificationRequestUpdateToProtoResult.getVcResponseMsgOrBuilder());
    assertSame(vcResponseMsg, vcResponseMsg.getDefaultInstanceForType());
  }
}
