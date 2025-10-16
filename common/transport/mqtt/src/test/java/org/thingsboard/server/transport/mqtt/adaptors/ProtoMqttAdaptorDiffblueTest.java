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
package org.thingsboard.server.transport.mqtt.adaptors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Any;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.UnknownFieldSet;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.AttributeUpdateNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.CredentialsDataProto;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.PostAttributeMsg;
import org.thingsboard.server.gen.transport.TransportProtos.PostTelemetryMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ProvisionDeviceCredentialsMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ProvisionDeviceRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ProvisionDeviceResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToServerRpcResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvListProto;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.session.DeviceSessionCtx;
import org.thingsboard.server.transport.mqtt.session.MqttDeviceAwareSessionContext;
import org.thingsboard.server.transport.mqtt.session.MqttTopicMatcher;

@ContextConfiguration(classes = {ProtoMqttAdaptor.class})
@ExtendWith(SpringExtension.class)
class ProtoMqttAdaptorDiffblueTest {
  @Autowired private ProtoMqttAdaptor protoMqttAdaptor;

  /**
   * Test {@link ProtoMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Then calls {@link MqttPublishMessage#payload()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage); then calls payload()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg ProtoMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry_thenCallsPayload() throws AdaptorException {
    // Arrange
    Descriptor descriptor = mock(Descriptor.class);
    when(descriptor.toProto()).thenThrow(new RuntimeException());

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getTelemetryDynamicMsgDescriptor()).thenReturn(descriptor);

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload())
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> protoMqttAdaptor.convertToPostTelemetry(ctx, inbound));
    verify(descriptor).toProto();
    verify(inbound).payload();
    verify(ctx).getTelemetryDynamicMsgDescriptor();
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Then return DescriptorForType Fields size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage); then return DescriptorForType Fields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg ProtoMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry_thenReturnDescriptorForTypeFieldsSizeIsOne()
      throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    Descriptor descriptor = PostTelemetryMsg.getDescriptor();
    when(ctx.getTelemetryDynamicMsgDescriptor()).thenReturn(descriptor);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        protoMqttAdaptor.convertToPostTelemetry(ctx, inbound);

    // Assert
    verify(ctx).getTelemetryDynamicMsgDescriptor();
    Descriptor descriptorForType = actualConvertToPostTelemetryResult.getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(1, getResult.getKvList().size());
    assertEquals(1, getResult.getKvCount());
    assertSame(descriptor, fields.get(0).getContainingType());
    assertSame(
        descriptor,
        actualConvertToPostTelemetryResult.getDefaultInstanceForType().getDescriptorForType());
    assertSame(descriptor, descriptorForType);
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Then return TsKvListList first KvCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage); then return TsKvListList first KvCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg ProtoMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstKvCountIsZero()
      throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getTelemetryDynamicMsgDescriptor()).thenReturn(Any.getDescriptor());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        protoMqttAdaptor.convertToPostTelemetry(ctx, inbound);

    // Assert
    verify(ctx).getTelemetryDynamicMsgDescriptor();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Then return TsKvListList first KvList size is {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage); then return TsKvListList first KvList size is SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg ProtoMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstKvListSizeIsSize()
      throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getTelemetryDynamicMsgDescriptor()).thenReturn(SessionInfoProto.getDescriptor());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        protoMqttAdaptor.convertToPostTelemetry(ctx, inbound);

    // Assert
    verify(ctx).getTelemetryDynamicMsgDescriptor();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(Short.SIZE, getResult.getKvList().size());
    assertEquals(Short.SIZE, getResult.getKvCount());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage); then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg ProtoMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    Descriptor descriptor = mock(Descriptor.class);
    when(descriptor.toProto()).thenThrow(new RuntimeException());

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getTelemetryDynamicMsgDescriptor()).thenReturn(descriptor);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> protoMqttAdaptor.convertToPostTelemetry(ctx, inbound));
    verify(descriptor).toProto();
    verify(ctx).getTelemetryDynamicMsgDescriptor();
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg ProtoMqttAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getAttributesDynamicMessageDescriptor()).thenReturn(PostTelemetryMsg.getDescriptor());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage inbound =
        new MqttPublishMessage(
            mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        protoMqttAdaptor.convertToPostAttributes(ctx, inbound);

    // Assert
    verify(ctx).getAttributesDynamicMessageDescriptor();
    UnknownFieldSet unknownFields = actualConvertToPostAttributesResult.getUnknownFields();
    PostAttributeMsg defaultInstanceForType =
        actualConvertToPostAttributesResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given Descriptor.
   *   <li>Then return KvCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage); given Descriptor; then return KvCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg ProtoMqttAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes_givenDescriptor_thenReturnKvCountIsZero()
      throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getAttributesDynamicMessageDescriptor()).thenReturn(Any.getDescriptor());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        protoMqttAdaptor.convertToPostAttributes(ctx, inbound);

    // Assert
    verify(ctx).getAttributesDynamicMessageDescriptor();
    assertEquals(0, actualConvertToPostAttributesResult.getKvCount());
    assertEquals(0, actualConvertToPostAttributesResult.getSerializedSize());
    assertTrue(actualConvertToPostAttributesResult.getKvList().isEmpty());
    assertTrue(actualConvertToPostAttributesResult.getAllFields().isEmpty());
    PostAttributeMsg actualDefaultInstanceForType =
        actualConvertToPostAttributesResult.getDefaultInstanceForType();
    assertEquals(actualConvertToPostAttributesResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given Descriptor.
   *   <li>Then return KvList size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage); given Descriptor; then return KvList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg ProtoMqttAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes_givenDescriptor_thenReturnKvListSizeIsOne()
      throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getAttributesDynamicMessageDescriptor()).thenReturn(PostTelemetryMsg.getDescriptor());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        protoMqttAdaptor.convertToPostAttributes(ctx, inbound);

    // Assert
    verify(ctx).getAttributesDynamicMessageDescriptor();
    assertEquals(1, actualConvertToPostAttributesResult.getKvList().size());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Then return DescriptorForType Fields size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage); then return DescriptorForType Fields size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg ProtoMqttAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes_thenReturnDescriptorForTypeFieldsSizeIsTwo()
      throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getAttributesDynamicMessageDescriptor()).thenReturn(SessionInfoProto.getDescriptor());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        protoMqttAdaptor.convertToPostAttributes(ctx, inbound);

    // Assert
    verify(ctx).getAttributesDynamicMessageDescriptor();
    assertEquals(2, actualConvertToPostAttributesResult.getDescriptorForType().getFields().size());
    assertEquals(287, actualConvertToPostAttributesResult.getSerializedSize());
    assertEquals(Short.SIZE, actualConvertToPostAttributesResult.getKvList().size());
    assertEquals(Short.SIZE, actualConvertToPostAttributesResult.getKvCount());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <ul>
   *   <li>Then calls {@link MqttPublishMessage#payload()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage,
   * String)}
   */
  @Test
  @DisplayName(
      "Test convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String); then calls payload()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg ProtoMqttAdaptor.convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToDeviceRpcResponse_thenCallsPayload() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getRpcResponseDynamicMessageDescriptor()).thenReturn(PostTelemetryMsg.getDescriptor());

    MqttPublishMessage mqttMsg = mock(MqttPublishMessage.class);
    when(mqttMsg.payload())
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));
    when(mqttMsg.variableHeader()).thenReturn(new MqttPublishVariableHeader("Topic Name", 1));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoMqttAdaptor.convertToDeviceRpcResponse(ctx, mqttMsg, "Topic Base"));
    verify(mqttMsg).payload();
    verify(mqttMsg).variableHeader();
    verify(ctx).getRpcResponseDynamicMessageDescriptor();
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <ul>
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage,
   * String)}
   */
  @Test
  @DisplayName(
      "Test convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String); then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg ProtoMqttAdaptor.convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToDeviceRpcResponse_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getRpcResponseDynamicMessageDescriptor()).thenReturn(PostTelemetryMsg.getDescriptor());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage mqttMsg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoMqttAdaptor.convertToDeviceRpcResponse(ctx, mqttMsg, "Topic Base"));
    verify(ctx).getRpcResponseDynamicMessageDescriptor();
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoMqttAdaptor.convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToProvisionRequestMsg() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage mqttMsg =
        new MqttPublishMessage(
            mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    // Act
    ProvisionDeviceRequestMsg actualConvertToProvisionRequestMsgResult =
        protoMqttAdaptor.convertToProvisionRequestMsg(ctx, mqttMsg);

    // Assert
    ProvisionDeviceRequestMsg actualDefaultInstanceForType =
        actualConvertToProvisionRequestMsgResult.getDefaultInstanceForType();
    assertEquals(actualConvertToProvisionRequestMsgResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToProvisionRequestMsgResult.getUnknownFields();
    CredentialsDataProto credentialsDataProto =
        actualConvertToProvisionRequestMsgResult.getCredentialsDataProto();
    assertSame(unknownFields, credentialsDataProto.getUnknownFields());
    ProvisionDeviceCredentialsMsg provisionDeviceCredentialsMsg =
        actualConvertToProvisionRequestMsgResult.getProvisionDeviceCredentialsMsg();
    assertSame(unknownFields, provisionDeviceCredentialsMsg.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
    CredentialsDataProto actualDefaultInstanceForType3 =
        credentialsDataProto.getDefaultInstanceForType();
    assertSame(credentialsDataProto, actualDefaultInstanceForType3);
    assertSame(
        credentialsDataProto,
        actualConvertToProvisionRequestMsgResult.getCredentialsDataProtoOrBuilder());
    ProvisionDeviceCredentialsMsg actualDefaultInstanceForType4 =
        provisionDeviceCredentialsMsg.getDefaultInstanceForType();
    assertSame(provisionDeviceCredentialsMsg, actualDefaultInstanceForType4);
    assertSame(
        provisionDeviceCredentialsMsg,
        actualConvertToProvisionRequestMsgResult.getProvisionDeviceCredentialsMsgOrBuilder());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is {@link
   *       EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage); given DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoMqttAdaptor.convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToProvisionRequestMsg_givenDuplicatedByteBufWithBufferIsEmptyByteBuf()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttPublishMessage mqttMsg = mock(MqttPublishMessage.class);
    when(mqttMsg.payload())
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Act
    ProvisionDeviceRequestMsg actualConvertToProvisionRequestMsgResult =
        protoMqttAdaptor.convertToProvisionRequestMsg(ctx, mqttMsg);

    // Assert
    verify(mqttMsg).payload();
    ProvisionDeviceRequestMsg actualDefaultInstanceForType =
        actualConvertToProvisionRequestMsgResult.getDefaultInstanceForType();
    assertEquals(actualConvertToProvisionRequestMsgResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToProvisionRequestMsgResult.getUnknownFields();
    CredentialsDataProto credentialsDataProto =
        actualConvertToProvisionRequestMsgResult.getCredentialsDataProto();
    assertSame(unknownFields, credentialsDataProto.getUnknownFields());
    ProvisionDeviceCredentialsMsg provisionDeviceCredentialsMsg =
        actualConvertToProvisionRequestMsgResult.getProvisionDeviceCredentialsMsg();
    assertSame(unknownFields, provisionDeviceCredentialsMsg.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
    CredentialsDataProto actualDefaultInstanceForType3 =
        credentialsDataProto.getDefaultInstanceForType();
    assertSame(credentialsDataProto, actualDefaultInstanceForType3);
    assertSame(
        credentialsDataProto,
        actualConvertToProvisionRequestMsgResult.getCredentialsDataProtoOrBuilder());
    ProvisionDeviceCredentialsMsg actualDefaultInstanceForType4 =
        provisionDeviceCredentialsMsg.getDefaultInstanceForType();
    assertSame(provisionDeviceCredentialsMsg, actualDefaultInstanceForType4);
    assertSame(
        provisionDeviceCredentialsMsg,
        actualConvertToProvisionRequestMsgResult.getProvisionDeviceCredentialsMsgOrBuilder());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage); then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoMqttAdaptor.convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToProvisionRequestMsg_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    ByteBuf byteBuf = mock(ByteBuf.class);
    when(byteBuf.readableBytes()).thenReturn(1);
    when(byteBuf.readerIndex()).thenReturn(1);
    when(byteBuf.getBytes(anyInt(), Mockito.<byte[]>any()))
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    MqttPublishMessage mqttMsg = mock(MqttPublishMessage.class);
    when(mqttMsg.payload()).thenReturn(byteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> protoMqttAdaptor.convertToProvisionRequestMsg(ctx, mqttMsg));
    verify(byteBuf).getBytes(eq(1), isA(byte[].class));
    verify(byteBuf).readableBytes();
    verify(byteBuf).readerIndex();
    verify(mqttMsg).payload();
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is {@link
   *       EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage); when DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoMqttAdaptor.convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToProvisionRequestMsg_whenDuplicatedByteBufWithBufferIsEmptyByteBuf()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage mqttMsg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    ProvisionDeviceRequestMsg actualConvertToProvisionRequestMsgResult =
        protoMqttAdaptor.convertToProvisionRequestMsg(ctx, mqttMsg);

    // Assert
    ProvisionDeviceRequestMsg actualDefaultInstanceForType =
        actualConvertToProvisionRequestMsgResult.getDefaultInstanceForType();
    assertEquals(actualConvertToProvisionRequestMsgResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToProvisionRequestMsgResult.getUnknownFields();
    CredentialsDataProto credentialsDataProto =
        actualConvertToProvisionRequestMsgResult.getCredentialsDataProto();
    assertSame(unknownFields, credentialsDataProto.getUnknownFields());
    ProvisionDeviceCredentialsMsg provisionDeviceCredentialsMsg =
        actualConvertToProvisionRequestMsgResult.getProvisionDeviceCredentialsMsg();
    assertSame(unknownFields, provisionDeviceCredentialsMsg.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
    CredentialsDataProto actualDefaultInstanceForType3 =
        credentialsDataProto.getDefaultInstanceForType();
    assertSame(credentialsDataProto, actualDefaultInstanceForType3);
    assertSame(
        credentialsDataProto,
        actualConvertToProvisionRequestMsgResult.getCredentialsDataProtoOrBuilder());
    ProvisionDeviceCredentialsMsg actualDefaultInstanceForType4 =
        provisionDeviceCredentialsMsg.getDefaultInstanceForType();
    assertSame(provisionDeviceCredentialsMsg, actualDefaultInstanceForType4);
    assertSame(
        provisionDeviceCredentialsMsg,
        actualConvertToProvisionRequestMsgResult.getProvisionDeviceCredentialsMsgOrBuilder());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String,
   * int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code requestId}, {@code
   * chunk}, {@code firmwareType}.
   *
   * <p>Method under test: {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * byte[], String, int, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"
  })
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        protoMqttAdaptor.convertToPublish(
            ctx, "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v2/fw/response/42/chunk/1",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeUpdateNotificationMsg#toByteArray()}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'; then calls toByteArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic_thenCallsToByteArray()
      throws UnsupportedEncodingException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        protoMqttAdaptor.convertToPublish(ctx, notificationMsg, "Topic");

    // Assert
    verify(notificationMsg).toByteArray();
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <ul>
   *   <li>Then {@link Optional#get()} return {@link MqttPublishMessage}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'; then get() return MqttPublishMessage")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic_thenGetReturnMqttPublishMessage() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        protoMqttAdaptor.convertToPublish(
            ctx, AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic");

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <ul>
   *   <li>Then calls {@link ProvisionDeviceResponseMsg#toByteArray()}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'; then calls toByteArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse_thenCallsToByteArray()
      throws UnsupportedEncodingException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    ProvisionDeviceResponseMsg provisionResponse = mock(ProvisionDeviceResponseMsg.class);
    when(provisionResponse.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        protoMqttAdaptor.convertToPublish(ctx, provisionResponse);

    // Assert
    verify(provisionResponse).toByteArray();
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <ul>
   *   <li>Then {@link Optional#get()} return {@link MqttPublishMessage}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'; then get() return MqttPublishMessage")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse_thenGetReturnMqttPublishMessage() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        protoMqttAdaptor.convertToPublish(ctx, ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then calls {@link GetAttributeResponseMsg#toByteArray()}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'; given zero; then calls toByteArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase_givenZero_thenCallsToByteArray()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getRequestId()).thenReturn(0);
    when(responseMsg.getError()).thenReturn("");
    when(responseMsg.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        protoMqttAdaptor.convertToPublish(ctx, responseMsg, "Topic Base");

    // Assert
    verify(responseMsg).toByteArray();
    verify(responseMsg).getError();
    verify(responseMsg).getRequestId();
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <ul>
   *   <li>Then {@link Optional#get()} return {@link MqttPublishMessage}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'; then get() return MqttPublishMessage")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase_thenGetReturnMqttPublishMessage()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        protoMqttAdaptor.convertToPublish(
            ctx, GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase_thenReturnNotPresent()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getRequestId()).thenReturn(-1);
    when(responseMsg.getError()).thenReturn(null);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        protoMqttAdaptor.convertToPublish(ctx, responseMsg, "Topic Base");

    // Assert
    verify(responseMsg).getError();
    verify(responseMsg).getRequestId();
    assertFalse(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <ul>
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase_thenThrowAdaptorException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getError()).thenReturn("An error occurred");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoMqttAdaptor.convertToPublish(ctx, responseMsg, "Topic Base"));
    verify(responseMsg, atLeast(1)).getError();
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToDeviceRpcRequestMsg, String)} with {@code ctx}, {@code rpcRequest}, {@code topicBase}.
   *
   * <ul>
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToDeviceRpcRequestMsg, String) with 'ctx', 'rpcRequest', 'topicBase'; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)"
  })
  void testConvertToPublishWithCtxRpcRequestTopicBase_thenThrowAdaptorException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            protoMqttAdaptor.convertToPublish(
                ctx, ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base"));
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <p>Method under test: {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        protoMqttAdaptor.convertToPublish(
            ctx, ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <p>Method under test: {@link ProtoMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase2() throws UnsupportedEncodingException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    ToServerRpcResponseMsg rpcResponse = mock(ToServerRpcResponseMsg.class);
    when(rpcResponse.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(rpcResponse.getRequestId()).thenReturn(1);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        protoMqttAdaptor.convertToPublish(ctx, rpcResponse, "Topic Base");

    // Assert
    verify(rpcResponse).toByteArray();
    verify(rpcResponse).getRequestId();
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link
   * ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult =
        protoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(
            ctx, "org.thingsboard.server.transport.mqtt.adaptors.ProtoMqttAdaptor", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link
   * ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); given HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish_givenHashMap() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.putAll(new HashMap<>());
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult =
        protoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link
   * ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <ul>
   *   <li>Given {@link ProtoMqttAdaptor} (default constructor).
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); given ProtoMqttAdaptor (default constructor); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish_givenProtoMqttAdaptor_whenZero() {
    // Arrange
    ProtoMqttAdaptor protoMqttAdaptor = new ProtoMqttAdaptor();
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult =
        protoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 0);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link
   * ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <ul>
   *   <li>When {@code Device Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); when 'Device Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish_whenDeviceName() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult =
        protoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link
   * ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish_whenEmptyString() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult =
        protoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link
   * ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); when minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish_whenMinusOne() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult =
        protoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", -1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg() throws IOException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSerializedSize()).thenReturn(0);
    doNothing().when(notificationMsg).writeTo(Mockito.<CodedOutputStream>any());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        protoMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", notificationMsg);

    // Assert
    verify(notificationMsg, atLeast(1)).getSerializedSize();
    verify(notificationMsg).writeTo(isA(CodedOutputStream.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg2() throws IOException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSerializedSize()).thenReturn(0);
    doNothing().when(notificationMsg).writeTo(Mockito.<CodedOutputStream>any());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        protoMqttAdaptor.convertToGatewayPublish(
            ctx,
            "org.thingsboard.server.transport.mqtt.adaptors.ProtoMqttAdaptor",
            notificationMsg);

    // Assert
    verify(notificationMsg, atLeast(1)).getSerializedSize();
    verify(notificationMsg).writeTo(isA(CodedOutputStream.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'; when DefaultInstance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg_whenDefaultInstance() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        protoMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg_whenEmptyString()
      throws IOException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSerializedSize()).thenReturn(0);
    doNothing().when(notificationMsg).writeTo(Mockito.<CodedOutputStream>any());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        protoMqttAdaptor.convertToGatewayPublish(ctx, "", notificationMsg);

    // Assert
    verify(notificationMsg, atLeast(1)).getSerializedSize();
    verify(notificationMsg).writeTo(isA(CodedOutputStream.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getError()).thenReturn("An error occurred");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoMqttAdaptor.convertToGatewayPublish(ctx, null, responseMsg));
    verify(responseMsg, atLeast(1)).getError();
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg2()
      throws IOException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getError()).thenReturn("");
    when(responseMsg.getSerializedSize()).thenReturn(0);
    doNothing().when(responseMsg).writeTo(Mockito.<CodedOutputStream>any());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        protoMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", responseMsg);

    // Assert
    verify(responseMsg).getError();
    verify(responseMsg, atLeast(1)).getSerializedSize();
    verify(responseMsg).writeTo(isA(CodedOutputStream.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg3()
      throws IOException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getError()).thenReturn("");
    when(responseMsg.getSerializedSize()).thenReturn(0);
    doNothing().when(responseMsg).writeTo(Mockito.<CodedOutputStream>any());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        protoMqttAdaptor.convertToGatewayPublish(
            ctx, "org.thingsboard.server.transport.mqtt.adaptors.ProtoMqttAdaptor", responseMsg);

    // Assert
    verify(responseMsg).getError();
    verify(responseMsg, atLeast(1)).getSerializedSize();
    verify(responseMsg).writeTo(isA(CodedOutputStream.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg_givenNull()
      throws IOException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getError()).thenReturn(null);
    when(responseMsg.getSerializedSize()).thenReturn(0);
    doNothing().when(responseMsg).writeTo(Mockito.<CodedOutputStream>any());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        protoMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", responseMsg);

    // Assert
    verify(responseMsg).getError();
    verify(responseMsg, atLeast(1)).getSerializedSize();
    verify(responseMsg).writeTo(isA(CodedOutputStream.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'; when DefaultInstance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg_whenDefaultInstance()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        protoMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg_whenEmptyString()
      throws IOException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getError()).thenReturn("");
    when(responseMsg.getSerializedSize()).thenReturn(0);
    doNothing().when(responseMsg).writeTo(Mockito.<CodedOutputStream>any());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        protoMqttAdaptor.convertToGatewayPublish(ctx, "", responseMsg);

    // Assert
    verify(responseMsg).getError();
    verify(responseMsg, atLeast(1)).getSerializedSize();
    verify(responseMsg).writeTo(isA(CodedOutputStream.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest() throws IOException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    ToDeviceRpcRequestMsg rpcRequest = mock(ToDeviceRpcRequestMsg.class);
    when(rpcRequest.getSerializedSize()).thenReturn(0);
    doNothing().when(rpcRequest).writeTo(Mockito.<CodedOutputStream>any());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        protoMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", rpcRequest);

    // Assert
    verify(rpcRequest, atLeast(1)).getSerializedSize();
    verify(rpcRequest).writeTo(isA(CodedOutputStream.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest2() throws IOException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    ToDeviceRpcRequestMsg rpcRequest = mock(ToDeviceRpcRequestMsg.class);
    when(rpcRequest.getSerializedSize()).thenReturn(0);
    doNothing().when(rpcRequest).writeTo(Mockito.<CodedOutputStream>any());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        protoMqttAdaptor.convertToGatewayPublish(
            ctx, "org.thingsboard.server.transport.mqtt.adaptors.ProtoMqttAdaptor", rpcRequest);

    // Assert
    verify(rpcRequest, atLeast(1)).getSerializedSize();
    verify(rpcRequest).writeTo(isA(CodedOutputStream.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'; when DefaultInstance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest_whenDefaultInstance() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        protoMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ProtoMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest_whenEmptyString() throws IOException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    ToDeviceRpcRequestMsg rpcRequest = mock(ToDeviceRpcRequestMsg.class);
    when(rpcRequest.getSerializedSize()).thenReturn(0);
    doNothing().when(rpcRequest).writeTo(Mockito.<CodedOutputStream>any());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        protoMqttAdaptor.convertToGatewayPublish(ctx, "", rpcRequest);

    // Assert
    verify(rpcRequest, atLeast(1)).getSerializedSize();
    verify(rpcRequest).writeTo(isA(CodedOutputStream.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#toBytes(ByteBuf)}.
   *
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       MqttTransportAdaptor#ALLOCATOR}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoMqttAdaptor#toBytes(ByteBuf)}
   */
  @Test
  @DisplayName(
      "Test toBytes(ByteBuf); when EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ProtoMqttAdaptor.toBytes(ByteBuf)"})
  void testToBytes_whenEmptyByteBufWithAllocIsAllocator_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {},
        ProtoMqttAdaptor.toBytes(
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));
  }
}
