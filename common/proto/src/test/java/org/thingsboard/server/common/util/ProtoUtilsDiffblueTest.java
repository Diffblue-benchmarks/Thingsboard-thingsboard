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
package org.thingsboard.server.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.UnknownFieldSet;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceProfileProvisionType;
import org.thingsboard.server.common.data.DeviceProfileType;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.TenantInfo;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.data.rpc.ToDeviceRpcRequestBody;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.common.data.sync.vc.RepositoryAuthMethod;
import org.thingsboard.server.common.data.sync.vc.RepositorySettings;
import org.thingsboard.server.common.msg.MsgType;
import org.thingsboard.server.common.msg.ToDeviceActorNotificationMsg;
import org.thingsboard.server.common.msg.edge.EdgeEventUpdateMsg;
import org.thingsboard.server.common.msg.edge.EdgeHighPriorityMsg;
import org.thingsboard.server.common.msg.edge.FromEdgeSyncResponse;
import org.thingsboard.server.common.msg.edge.ToEdgeSyncRequest;
import org.thingsboard.server.common.msg.plugin.ComponentLifecycleMsg;
import org.thingsboard.server.common.msg.rpc.ToDeviceRpcRequest;
import org.thingsboard.server.common.msg.rpc.ToDeviceRpcRequestActorMsg;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.AttributeValueProto;
import org.thingsboard.server.gen.transport.TransportProtos.ComponentLifecycleMsgProto;
import org.thingsboard.server.gen.transport.TransportProtos.DeviceCredentialsProto;
import org.thingsboard.server.gen.transport.TransportProtos.DeviceProfileProto;
import org.thingsboard.server.gen.transport.TransportProtos.DeviceProto;
import org.thingsboard.server.gen.transport.TransportProtos.EdgeEventUpdateMsgProto;
import org.thingsboard.server.gen.transport.TransportProtos.EdgeHighPriorityMsgProto;
import org.thingsboard.server.gen.transport.TransportProtos.EntityTypeProto;
import org.thingsboard.server.gen.transport.TransportProtos.EntityUpdateMsg;
import org.thingsboard.server.gen.transport.TransportProtos.FromEdgeSyncResponseMsgProto;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueType;
import org.thingsboard.server.gen.transport.TransportProtos.RepositorySettingsProto;
import org.thingsboard.server.gen.transport.TransportProtos.TenantProfileProto;
import org.thingsboard.server.gen.transport.TransportProtos.TenantProto;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceActorNotificationMsgProto;
import org.thingsboard.server.gen.transport.TransportProtos.ToEdgeSyncRequestMsgProto;

class ProtoUtilsDiffblueTest {
  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry() {
    // Arrange and Act
    AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"))));

    // Assert
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    AttributeValueProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <ul>
   *   <li>Given {@code BOOLEAN}.</li>
   *   <li>Then return SerializedSize is thirteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; given 'BOOLEAN'; then return SerializedSize is thirteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_givenBoolean_thenReturnSerializedSizeIsThirteen() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    Optional<Boolean> ofResult = Optional.of(true);
    when(attributeKvEntry.getBooleanValue()).thenReturn(ofResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.BOOLEAN);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry, atLeast(1)).getBooleanValue();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    assertEquals(0, actualToProtoResult.getTypeValue());
    assertEquals(13, actualToProtoResult.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, actualToProtoResult.getType());
    assertTrue(actualToProtoResult.getBoolV());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <ul>
   *   <li>Given {@code LONG}.</li>
   *   <li>Then return SerializedSize is fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; given 'LONG'; then return SerializedSize is fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_givenLong_thenReturnSerializedSizeIsFifteen() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(attributeKvEntry.getLongValue()).thenReturn(ofResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.LONG);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry, atLeast(1)).getLongValue();
    assertEquals(1, actualToProtoResult.getTypeValue());
    assertEquals(15, actualToProtoResult.getSerializedSize());
    assertEquals(1L, actualToProtoResult.getLongV());
    assertEquals(KeyValueType.LONG_V, actualToProtoResult.getType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <ul>
   *   <li>Given {@link Optional} with ten.</li>
   *   <li>Then return DoubleV is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; given Optional with ten; then return DoubleV is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_givenOptionalWithTen_thenReturnDoubleVIsTen() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Double> ofResult = Optional.<Double>of(10.0d);
    when(attributeKvEntry.getDoubleValue()).thenReturn(ofResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.DOUBLE);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry, atLeast(1)).getDoubleValue();
    verify(attributeKvEntry).getKey();
    assertEquals(10.0d, actualToProtoResult.getDoubleV());
    assertEquals(2, actualToProtoResult.getTypeValue());
    assertEquals(22, actualToProtoResult.getSerializedSize());
    assertEquals(KeyValueType.DOUBLE_V, actualToProtoResult.getType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <ul>
   *   <li>Then return AllFields size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; then return AllFields size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_thenReturnAllFieldsSizeIsThree() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    Optional<Boolean> emptyResult = Optional.empty();
    when(attributeKvEntry.getBooleanValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.BOOLEAN);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry, atLeast(1)).getBooleanValue();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    assertEquals(0, actualToProtoResult.getTypeValue());
    assertEquals(3, actualToProtoResult.getAllFields().size());
    assertEquals(9, actualToProtoResult.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, actualToProtoResult.getType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <ul>
   *   <li>Then return LongV is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; then return LongV is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_thenReturnLongVIsFortyTwo() {
    // Arrange and Act
    AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(1L, new LongDataEntry("Key", 42L)));

    // Assert
    assertEquals(42L, actualToProtoResult.getLongV());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    AttributeValueProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <ul>
   *   <li>Then return SerializedSize is seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; then return SerializedSize is seventeen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_thenReturnSerializedSizeIsSeventeen() {
    // Arrange and Act
    AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(new JsonDataEntry("Key", "42"), 1L, 1L));

    // Assert
    assertEquals(17, actualToProtoResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    AttributeValueProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <ul>
   *   <li>Then return SerializedSize is twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; then return SerializedSize is twenty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_thenReturnSerializedSizeIsTwenty() {
    // Arrange and Act
    AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(1L, new DoubleDataEntry("Key", 10.0d)));

    // Assert
    assertEquals(20, actualToProtoResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    AttributeValueProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <ul>
   *   <li>Then return TypeValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; then return TypeValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_thenReturnTypeValueIsThree() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<String> emptyResult = Optional.empty();
    when(attributeKvEntry.getStrValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.STRING);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry, atLeast(1)).getStrValue();
    assertEquals(11, actualToProtoResult.getSerializedSize());
    assertEquals(3, actualToProtoResult.getTypeValue());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertEquals(KeyValueType.STRING_V, actualToProtoResult.getType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <ul>
   *   <li>When {@link AttributeKvEntry} {@link KvEntry#getDoubleValue()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; when AttributeKvEntry getDoubleValue() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_whenAttributeKvEntryGetDoubleValueReturnEmpty() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Double> emptyResult = Optional.empty();
    when(attributeKvEntry.getDoubleValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.DOUBLE);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry, atLeast(1)).getDoubleValue();
    verify(attributeKvEntry).getKey();
    assertEquals(11, actualToProtoResult.getSerializedSize());
    assertEquals(2, actualToProtoResult.getTypeValue());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertEquals(KeyValueType.DOUBLE_V, actualToProtoResult.getType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <ul>
   *   <li>When {@link AttributeKvEntry} {@link KvEntry#getLongValue()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; when AttributeKvEntry getLongValue() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_whenAttributeKvEntryGetLongValueReturnEmpty() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Long> emptyResult = Optional.empty();
    when(attributeKvEntry.getLongValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.LONG);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry, atLeast(1)).getLongValue();
    assertEquals(1, actualToProtoResult.getTypeValue());
    assertEquals(11, actualToProtoResult.getSerializedSize());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertEquals(KeyValueType.LONG_V, actualToProtoResult.getType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <ul>
   *   <li>When {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and value is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; when BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_whenBooleanDataEntryWithKeyAndValueIsTrue() {
    // Arrange and Act
    AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(1L, new BooleanDataEntry("Key", true)));

    // Assert
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    AttributeValueProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; when JsonDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_whenJsonDataEntryWithKeyAndValueIs42() {
    // Arrange and Act
    AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Assert
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    AttributeValueProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with {@code AttributeKvEntry}.
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; when JsonDataEntry(String, String) with 'Key' and value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_whenJsonDataEntryWithKeyAndValueIsNull() {
    // Arrange and Act
    AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", null)));

    // Assert
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    AttributeValueProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg2() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsFive() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AssetId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    assertEquals(5, actualToProtoResult.getEntityTypeValue());
    assertEquals(EntityTypeProto.ASSET, actualToProtoResult.getEntityType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsFour() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new DashboardId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    assertEquals(4, actualToProtoResult.getEntityTypeValue());
    assertEquals(EntityTypeProto.DASHBOARD, actualToProtoResult.getEntityType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsSix() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new DeviceId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    assertEquals(6, actualToProtoResult.getEntityTypeValue());
    assertEquals(EntityTypeProto.DEVICE, actualToProtoResult.getEntityType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is thirty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is thirty-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsThirtySix() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new DomainId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    assertEquals(36, actualToProtoResult.getEntityTypeValue());
    assertEquals(EntityTypeProto.DOMAIN, actualToProtoResult.getEntityType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is twenty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is twenty-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsTwentyOne() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new DeviceProfileId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    assertEquals(21, actualToProtoResult.getEntityTypeValue());
    assertEquals(EntityTypeProto.DEVICE_PROFILE, actualToProtoResult.getEntityType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is twenty-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is twenty-three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsTwentyThree() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new ApiUsageStateId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    assertEquals(23, actualToProtoResult.getEntityTypeValue());
    assertEquals(EntityTypeProto.API_USAGE_STATE, actualToProtoResult.getEntityType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is twenty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is twenty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsTwentyTwo() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new AssetProfileId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    assertEquals(22, actualToProtoResult.getEntityTypeValue());
    assertEquals(EntityTypeProto.ASSET_PROFILE, actualToProtoResult.getEntityType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsTwo() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new CustomerId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    assertEquals(2, actualToProtoResult.getEntityTypeValue());
    assertEquals(EntityTypeProto.CUSTOMER, actualToProtoResult.getEntityType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsFive() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.STOPPED));

    // Assert
    assertEquals(5, actualToProtoResult.getEventValue());
    assertEquals(TransportProtos.ComponentLifecycleEvent.STOPPED, actualToProtoResult.getEvent());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsFour() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.UPDATED));

    // Assert
    assertEquals(4, actualToProtoResult.getEventValue());
    assertEquals(TransportProtos.ComponentLifecycleEvent.UPDATED, actualToProtoResult.getEvent());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsOne() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.STARTED));

    // Assert
    assertEquals(1, actualToProtoResult.getEventValue());
    assertEquals(TransportProtos.ComponentLifecycleEvent.STARTED, actualToProtoResult.getEvent());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsSeven() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.FAILED));

    // Assert
    assertEquals(7, actualToProtoResult.getEventValue());
    assertEquals(TransportProtos.ComponentLifecycleEvent.FAILED, actualToProtoResult.getEvent());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsSix() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.DELETED));

    // Assert
    assertEquals(6, actualToProtoResult.getEventValue());
    assertEquals(TransportProtos.ComponentLifecycleEvent.DELETED, actualToProtoResult.getEvent());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsThree() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.SUSPENDED));

    // Assert
    assertEquals(3, actualToProtoResult.getEventValue());
    assertEquals(TransportProtos.ComponentLifecycleEvent.SUSPENDED, actualToProtoResult.getEvent());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsTwo() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.ACTIVATED));

    // Assert
    assertEquals(2, actualToProtoResult.getEventValue());
    assertEquals(TransportProtos.ComponentLifecycleEvent.ACTIVATED, actualToProtoResult.getEvent());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    ComponentLifecycleMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceCredentials)} with {@code DeviceCredentials}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test toProto(DeviceCredentials) with 'DeviceCredentials'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.DeviceCredentialsProto ProtoUtils.toProto(DeviceCredentials)"})
  void testToProtoWithDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsValue("42");
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsId("42");
    deviceCredentials.setId(new DeviceCredentialsId(UUID.randomUUID()));

    // Act
    DeviceCredentialsProto actualToProtoResult = ProtoUtils.toProto(deviceCredentials);

    // Assert
    DeviceCredentialsProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    ByteString credentialsIdBytes = defaultInstanceForType.getCredentialsIdBytes();
    assertEquals("", credentialsIdBytes.toStringUtf8());
    assertEquals("42", actualToProtoResult.getCredentialsValue());
    assertFalse(credentialsIdBytes.iterator().hasNext());
    assertTrue(credentialsIdBytes.isEmpty());
    assertTrue(actualToProtoResult.hasCredentialsValue());
    assertEquals(credentialsIdBytes, defaultInstanceForType.getCredentialsValueBytes());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceCredentials)} with {@code DeviceCredentials}.
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.</li>
   *   <li>Then return Version is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test toProto(DeviceCredentials) with 'DeviceCredentials'; given 'ACCESS_TOKEN'; then return Version is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.DeviceCredentialsProto ProtoUtils.toProto(DeviceCredentials)"})
  void testToProtoWithDeviceCredentials_givenAccessToken_thenReturnVersionIsZero() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsId("42");
    deviceCredentials.setId(new DeviceCredentialsId(UUID.randomUUID()));

    // Act
    DeviceCredentialsProto actualToProtoResult = ProtoUtils.toProto(deviceCredentials);

    // Assert
    ByteString credentialsValueBytes = actualToProtoResult.getCredentialsValueBytes();
    assertEquals("", credentialsValueBytes.toStringUtf8());
    assertEquals("", actualToProtoResult.getCredentialsValue());
    assertEquals(0L, actualToProtoResult.getVersion());
    assertEquals(3, actualToProtoResult.getAllFields().size());
    assertFalse(credentialsValueBytes.iterator().hasNext());
    assertFalse(actualToProtoResult.hasCredentialsValue());
    assertFalse(actualToProtoResult.hasVersion());
    assertTrue(credentialsValueBytes.isEmpty());
    DeviceCredentialsProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertEquals(credentialsValueBytes, defaultInstanceForType.getCredentialsIdBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType.getCredentialsValueBytes());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceCredentials)} with {@code DeviceCredentials}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Version is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test toProto(DeviceCredentials) with 'DeviceCredentials'; given one; then return Version is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.DeviceCredentialsProto ProtoUtils.toProto(DeviceCredentials)"})
  void testToProtoWithDeviceCredentials_givenOne_thenReturnVersionIsOne() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setVersion(1L);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsId("42");
    deviceCredentials.setId(new DeviceCredentialsId(UUID.randomUUID()));

    // Act
    DeviceCredentialsProto actualToProtoResult = ProtoUtils.toProto(deviceCredentials);

    // Assert
    ByteString credentialsValueBytes = actualToProtoResult.getCredentialsValueBytes();
    assertEquals("", credentialsValueBytes.toStringUtf8());
    assertEquals("", actualToProtoResult.getCredentialsValue());
    assertEquals(1L, actualToProtoResult.getVersion());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertFalse(credentialsValueBytes.iterator().hasNext());
    assertFalse(actualToProtoResult.hasCredentialsValue());
    assertTrue(credentialsValueBytes.isEmpty());
    assertTrue(actualToProtoResult.hasVersion());
    DeviceCredentialsProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertEquals(credentialsValueBytes, defaultInstanceForType.getCredentialsIdBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType.getCredentialsValueBytes());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Given {@code Default Queue Name}.</li>
   *   <li>Then return {@code Default Queue Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; given 'Default Queue Name'; then return 'Default Queue Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.DeviceProfileProto ProtoUtils.toProto(DeviceProfile)"})
  void testToProtoWithDeviceProfile_givenDefaultQueueName_thenReturnDefaultQueueName() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultQueueName("Default Queue Name");
    deviceProfile.setProfileDataBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    deviceProfile.setDefaultRuleChainId(null);
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.randomUUID()));
    deviceProfile.setName("");

    // Act
    DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    assertEquals("Default Queue Name", actualToProtoResult.getDefaultQueueName());
    assertTrue(actualToProtoResult.hasDefaultQueueName());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Given {@code DISABLED}.</li>
   *   <li>Then return AllFields size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; given 'DISABLED'; then return AllFields size is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.DeviceProfileProto ProtoUtils.toProto(DeviceProfile)"})
  void testToProtoWithDeviceProfile_givenDisabled_thenReturnAllFieldsSizeIsFive() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.randomUUID()));
    deviceProfile.setName("");

    // Act
    DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    assertEquals(5, actualToProtoResult.getAllFields().size());
    FileOptions defaultInstanceForType = actualToProtoResult.getDescriptorForType()
        .getFile()
        .getOptions()
        .getDefaultInstanceForType();
    assertFalse(defaultInstanceForType.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType.hasOptimizeFor());
    assertFalse(defaultInstanceForType.hasPhpClassPrefix());
    assertFalse(actualToProtoResult.hasDeviceProfileData());
    ByteString expectedDeviceProfileData = actualToProtoResult.getDeviceProfileData();
    assertSame(expectedDeviceProfileData, actualToProtoResult.getDefaultInstanceForType().getDeviceProfileData());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Version is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; given one; then return Version is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.DeviceProfileProto ProtoUtils.toProto(DeviceProfile)"})
  void testToProtoWithDeviceProfile_givenOne_thenReturnVersionIsOne() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setVersion(1L);
    deviceProfile.setProfileDataBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    deviceProfile.setDefaultRuleChainId(null);
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.randomUUID()));
    deviceProfile.setName("");

    // Act
    DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    assertEquals(1L, actualToProtoResult.getVersion());
    assertEquals(7, actualToProtoResult.getAllFields().size());
    assertTrue(actualToProtoResult.hasVersion());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Then return AllFields size is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; then return AllFields size is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.DeviceProfileProto ProtoUtils.toProto(DeviceProfile)"})
  void testToProtoWithDeviceProfile_thenReturnAllFieldsSizeIsEight() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultEdgeRuleChainId(new RuleChainId(UUID.randomUUID()));
    deviceProfile.setProfileDataBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    deviceProfile.setDefaultRuleChainId(null);
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.randomUUID()));
    deviceProfile.setName("");

    // Act
    DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    assertEquals(8, actualToProtoResult.getAllFields().size());
    assertTrue(actualToProtoResult.hasDefaultEdgeRuleChainIdLSB());
    assertTrue(actualToProtoResult.hasDefaultEdgeRuleChainIdMSB());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Then return hasDefaultRuleChainIdLSB.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; then return hasDefaultRuleChainIdLSB")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.DeviceProfileProto ProtoUtils.toProto(DeviceProfile)"})
  void testToProtoWithDeviceProfile_thenReturnHasDefaultRuleChainIdLSB() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultRuleChainId(new RuleChainId(UUID.randomUUID()));
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.randomUUID()));
    deviceProfile.setName("");

    // Act
    DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    assertEquals(7, actualToProtoResult.getAllFields().size());
    FileOptions defaultInstanceForType = actualToProtoResult.getDescriptorForType()
        .getFile()
        .getOptions()
        .getDefaultInstanceForType();
    assertFalse(defaultInstanceForType.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType.hasOptimizeFor());
    assertFalse(defaultInstanceForType.hasPhpClassPrefix());
    assertFalse(actualToProtoResult.hasDeviceProfileData());
    assertTrue(actualToProtoResult.hasDefaultRuleChainIdLSB());
    assertTrue(actualToProtoResult.hasDefaultRuleChainIdMSB());
    ByteString expectedDeviceProfileData = actualToProtoResult.getDeviceProfileData();
    assertSame(expectedDeviceProfileData, actualToProtoResult.getDefaultInstanceForType().getDeviceProfileData());
  }

  /**
   * Test {@link ProtoUtils#toProto(EdgeEventUpdateMsg)} with {@code EdgeEventUpdateMsg}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EdgeEventUpdateMsg)}
   */
  @Test
  @DisplayName("Test toProto(EdgeEventUpdateMsg) with 'EdgeEventUpdateMsg'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.EdgeEventUpdateMsgProto ProtoUtils.toProto(EdgeEventUpdateMsg)"})
  void testToProtoWithEdgeEventUpdateMsg() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    EdgeEventUpdateMsgProto actualToProtoResult = ProtoUtils
        .toProto(new EdgeEventUpdateMsg(tenantId, new EdgeId(UUID.randomUUID())));

    // Assert
    assertEquals("", actualToProtoResult.getInitializationErrorString());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertTrue(actualToProtoResult.findInitializationErrors().isEmpty());
    assertTrue(actualToProtoResult.isInitialized());
  }

  /**
   * Test {@link ProtoUtils#toProto(EdgeHighPriorityMsg)} with {@code EdgeHighPriorityMsg}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>Then return AllFields size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EdgeHighPriorityMsg)}
   */
  @Test
  @DisplayName("Test toProto(EdgeHighPriorityMsg) with 'EdgeHighPriorityMsg'; given 'ADDED'; then return AllFields size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.EdgeHighPriorityMsgProto ProtoUtils.toProto(EdgeHighPriorityMsg)"})
  void testToProtoWithEdgeHighPriorityMsg_givenAdded_thenReturnAllFieldsSizeIsFour() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);
    edgeEvent.setType(EdgeEventType.ASSET);

    // Act
    EdgeHighPriorityMsgProto actualToProtoResult = ProtoUtils
        .toProto(new EdgeHighPriorityMsg(new TenantId(UUID.randomUUID()), edgeEvent));

    // Assert
    ByteString bodyBytes = actualToProtoResult.getBodyBytes();
    assertEquals("", bodyBytes.toStringUtf8());
    assertEquals("", actualToProtoResult.getBody());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertEquals(9, actualToProtoResult.getDescriptorForType().getFields().size());
    assertFalse(bodyBytes.iterator().hasNext());
    assertFalse(actualToProtoResult.hasBody());
    assertTrue(bodyBytes.isEmpty());
    EdgeHighPriorityMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertEquals(bodyBytes, defaultInstanceForType.getActionBytes());
    assertEquals(bodyBytes, defaultInstanceForType.getBodyBytes());
    assertEquals(bodyBytes, defaultInstanceForType.getTypeBytes());
  }

  /**
   * Test {@link ProtoUtils#toProto(EdgeHighPriorityMsg)} with {@code EdgeHighPriorityMsg}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>Then return AllFields size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EdgeHighPriorityMsg)}
   */
  @Test
  @DisplayName("Test toProto(EdgeHighPriorityMsg) with 'EdgeHighPriorityMsg'; given randomUUID; then return AllFields size is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.EdgeHighPriorityMsgProto ProtoUtils.toProto(EdgeHighPriorityMsg)"})
  void testToProtoWithEdgeHighPriorityMsg_givenRandomUUID_thenReturnAllFieldsSizeIsSix() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setEntityId(UUID.randomUUID());
    edgeEvent.setAction(EdgeEventActionType.ADDED);
    edgeEvent.setType(EdgeEventType.ASSET);

    // Act
    EdgeHighPriorityMsgProto actualToProtoResult = ProtoUtils
        .toProto(new EdgeHighPriorityMsg(new TenantId(UUID.randomUUID()), edgeEvent));

    // Assert
    ByteString bodyBytes = actualToProtoResult.getBodyBytes();
    assertEquals("", bodyBytes.toStringUtf8());
    assertEquals("", actualToProtoResult.getBody());
    assertEquals(6, actualToProtoResult.getAllFields().size());
    assertEquals(9, actualToProtoResult.getDescriptorForType().getFields().size());
    assertFalse(bodyBytes.iterator().hasNext());
    assertFalse(actualToProtoResult.hasBody());
    assertTrue(bodyBytes.isEmpty());
    assertTrue(actualToProtoResult.hasEntityIdLSB());
    assertTrue(actualToProtoResult.hasEntityIdMSB());
    EdgeHighPriorityMsgProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertEquals(bodyBytes, defaultInstanceForType.getActionBytes());
    assertEquals(bodyBytes, defaultInstanceForType.getBodyBytes());
    assertEquals(bodyBytes, defaultInstanceForType.getTypeBytes());
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code ALARM}.</li>
   *   <li>Then return {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'ALARM'; then return 'ALARM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenAlarm_thenReturnAlarm() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.ALARM, ProtoUtils.toProto(EntityType.ALARM));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code API_USAGE_STATE}.</li>
   *   <li>Then return {@code API_USAGE_STATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'API_USAGE_STATE'; then return 'API_USAGE_STATE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenApiUsageState_thenReturnApiUsageState() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.API_USAGE_STATE, ProtoUtils.toProto(EntityType.API_USAGE_STATE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code ASSET_PROFILE}.</li>
   *   <li>Then return {@code ASSET_PROFILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'ASSET_PROFILE'; then return 'ASSET_PROFILE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenAssetProfile_thenReturnAssetProfile() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.ASSET_PROFILE, ProtoUtils.toProto(EntityType.ASSET_PROFILE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code ASSET}.</li>
   *   <li>Then return {@code ASSET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'ASSET'; then return 'ASSET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenAsset_thenReturnAsset() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.ASSET, ProtoUtils.toProto(EntityType.ASSET));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code CUSTOMER}.</li>
   *   <li>Then return {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'CUSTOMER'; then return 'CUSTOMER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenCustomer_thenReturnCustomer() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.CUSTOMER, ProtoUtils.toProto(EntityType.CUSTOMER));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code DASHBOARD}.</li>
   *   <li>Then return {@code DASHBOARD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'DASHBOARD'; then return 'DASHBOARD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenDashboard_thenReturnDashboard() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.DASHBOARD, ProtoUtils.toProto(EntityType.DASHBOARD));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code DEVICE_PROFILE}.</li>
   *   <li>Then return {@code DEVICE_PROFILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'DEVICE_PROFILE'; then return 'DEVICE_PROFILE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenDeviceProfile_thenReturnDeviceProfile() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.DEVICE_PROFILE, ProtoUtils.toProto(EntityType.DEVICE_PROFILE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code DEVICE}.</li>
   *   <li>Then return {@code DEVICE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'DEVICE'; then return 'DEVICE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenDevice_thenReturnDevice() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.DEVICE, ProtoUtils.toProto(EntityType.DEVICE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code EDGE}.</li>
   *   <li>Then return {@code EDGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'EDGE'; then return 'EDGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenEdge_thenReturnEdge() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.EDGE, ProtoUtils.toProto(EntityType.EDGE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.</li>
   *   <li>Then return {@code ENTITY_VIEW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'ENTITY_VIEW'; then return 'ENTITY_VIEW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenEntityView_thenReturnEntityView() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.ENTITY_VIEW, ProtoUtils.toProto(EntityType.ENTITY_VIEW));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code OTA_PACKAGE}.</li>
   *   <li>Then return {@code OTA_PACKAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'OTA_PACKAGE'; then return 'OTA_PACKAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenOtaPackage_thenReturnOtaPackage() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.OTA_PACKAGE, ProtoUtils.toProto(EntityType.OTA_PACKAGE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code RPC}.</li>
   *   <li>Then return {@code RPC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'RPC'; then return 'RPC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenRpc_thenReturnRpc() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.RPC, ProtoUtils.toProto(EntityType.RPC));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code RULE_CHAIN}.</li>
   *   <li>Then return {@code RULE_CHAIN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'RULE_CHAIN'; then return 'RULE_CHAIN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenRuleChain_thenReturnRuleChain() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.RULE_CHAIN, ProtoUtils.toProto(EntityType.RULE_CHAIN));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code RULE_NODE}.</li>
   *   <li>Then return {@code RULE_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'RULE_NODE'; then return 'RULE_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenRuleNode_thenReturnRuleNode() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.RULE_NODE, ProtoUtils.toProto(EntityType.RULE_NODE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code TB_RESOURCE}.</li>
   *   <li>Then return {@code TB_RESOURCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'TB_RESOURCE'; then return 'TB_RESOURCE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenTbResource_thenReturnTbResource() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.TB_RESOURCE, ProtoUtils.toProto(EntityType.TB_RESOURCE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code TENANT_PROFILE}.</li>
   *   <li>Then return {@code TENANT_PROFILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'TENANT_PROFILE'; then return 'TENANT_PROFILE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenTenantProfile_thenReturnTenantProfile() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.TENANT_PROFILE, ProtoUtils.toProto(EntityType.TENANT_PROFILE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code TENANT}.</li>
   *   <li>Then return {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'TENANT'; then return 'TENANT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenTenant_thenReturnTenant() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.TENANT, ProtoUtils.toProto(EntityType.TENANT));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code USER}.</li>
   *   <li>Then return {@code USER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'USER'; then return 'USER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenUser_thenReturnUser() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.USER, ProtoUtils.toProto(EntityType.USER));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code WIDGET_TYPE}.</li>
   *   <li>Then return {@code WIDGET_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'WIDGET_TYPE'; then return 'WIDGET_TYPE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenWidgetType_thenReturnWidgetType() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.WIDGET_TYPE, ProtoUtils.toProto(EntityType.WIDGET_TYPE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code WIDGETS_BUNDLE}.</li>
   *   <li>Then return {@code WIDGETS_BUNDLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'WIDGETS_BUNDLE'; then return 'WIDGETS_BUNDLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityTypeProto ProtoUtils.toProto(EntityType)"})
  void testToProtoWithEntityType_whenWidgetsBundle_thenReturnWidgetsBundle() {
    // Arrange, Act and Assert
    assertEquals(EntityTypeProto.WIDGETS_BUNDLE, ProtoUtils.toProto(EntityType.WIDGETS_BUNDLE));
  }

  /**
   * Test {@link ProtoUtils#toProto(FromEdgeSyncResponse)} with {@code FromEdgeSyncResponse}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(FromEdgeSyncResponse)}
   */
  @Test
  @DisplayName("Test toProto(FromEdgeSyncResponse) with 'FromEdgeSyncResponse'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FromEdgeSyncResponseMsgProto ProtoUtils.toProto(FromEdgeSyncResponse)"})
  void testToProtoWithFromEdgeSyncResponse() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    FromEdgeSyncResponseMsgProto actualToProtoResult = ProtoUtils
        .toProto(new FromEdgeSyncResponse(id, tenantId, new EdgeId(UUID.randomUUID()), true, "An error occurred"));

    // Assert
    assertEquals("", actualToProtoResult.getInitializationErrorString());
    assertEquals("An error occurred", actualToProtoResult.getError());
    assertEquals(8, actualToProtoResult.getAllFields().size());
    assertTrue(actualToProtoResult.findInitializationErrors().isEmpty());
    assertTrue(actualToProtoResult.getSuccess());
    assertTrue(actualToProtoResult.isInitialized());
  }

  /**
   * Test {@link ProtoUtils#toProto(RepositorySettings)} with {@code RepositorySettings}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(RepositorySettings)}
   */
  @Test
  @DisplayName("Test toProto(RepositorySettings) with 'RepositorySettings'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettingsProto ProtoUtils.toProto(RepositorySettings)"})
  void testToProtoWithRepositorySettings() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKeyFileName("foo.txt");
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    repositorySettings.setRepositoryUri("");

    // Act
    RepositorySettingsProto actualToProtoResult = ProtoUtils.toProto(repositorySettings);

    // Assert
    ByteString privateKeyFileNameBytes = actualToProtoResult.getPrivateKeyFileNameBytes();
    assertEquals("foo.txt", privateKeyFileNameBytes.toStringUtf8());
    assertEquals("foo.txt", actualToProtoResult.getPrivateKeyFileName());
    assertFalse(privateKeyFileNameBytes.isEmpty());
    ByteIterator iteratorResult = privateKeyFileNameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(actualToProtoResult.hasPrivateKeyFileName());
    assertEquals('f', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link ProtoUtils#toProto(RepositorySettings)} with {@code RepositorySettings}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(RepositorySettings)}
   */
  @Test
  @DisplayName("Test toProto(RepositorySettings) with 'RepositorySettings'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettingsProto ProtoUtils.toProto(RepositorySettings)"})
  void testToProtoWithRepositorySettings2() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKeyPassword("iloveyou");
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    repositorySettings.setRepositoryUri("");

    // Act
    RepositorySettingsProto actualToProtoResult = ProtoUtils.toProto(repositorySettings);

    // Assert
    ByteString privateKeyPasswordBytes = actualToProtoResult.getPrivateKeyPasswordBytes();
    assertEquals("iloveyou", privateKeyPasswordBytes.toStringUtf8());
    assertEquals("iloveyou", actualToProtoResult.getPrivateKeyPassword());
    assertFalse(privateKeyPasswordBytes.isEmpty());
    ByteIterator iteratorResult = privateKeyPasswordBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(actualToProtoResult.hasPrivateKeyPassword());
    assertEquals('i', iteratorResult.next().byteValue());
    assertEquals('l', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link ProtoUtils#toProto(RepositorySettings)} with {@code RepositorySettings}.
   * <ul>
   *   <li>Then return AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(RepositorySettings)}
   */
  @Test
  @DisplayName("Test toProto(RepositorySettings) with 'RepositorySettings'; then return AllFields size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettingsProto ProtoUtils.toProto(RepositorySettings)"})
  void testToProtoWithRepositorySettings_thenReturnAllFieldsSizeIsOne() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    repositorySettings.setRepositoryUri("");

    // Act
    RepositorySettingsProto actualToProtoResult = ProtoUtils.toProto(repositorySettings);

    // Assert
    assertEquals(1, actualToProtoResult.getAllFields().size());
    assertEquals(19, actualToProtoResult.getSerializedSize());
  }

  /**
   * Test {@link ProtoUtils#toProto(RepositorySettings)} with {@code RepositorySettings}.
   * <ul>
   *   <li>Then return DefaultBranch is {@code janedoe/featurebranch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(RepositorySettings)}
   */
  @Test
  @DisplayName("Test toProto(RepositorySettings) with 'RepositorySettings'; then return DefaultBranch is 'janedoe/featurebranch'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettingsProto ProtoUtils.toProto(RepositorySettings)"})
  void testToProtoWithRepositorySettings_thenReturnDefaultBranchIsJanedoeFeaturebranch() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setDefaultBranch("janedoe/featurebranch");
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    repositorySettings.setRepositoryUri("");

    // Act
    RepositorySettingsProto actualToProtoResult = ProtoUtils.toProto(repositorySettings);

    // Assert
    assertEquals("janedoe/featurebranch", actualToProtoResult.getDefaultBranch());
    assertEquals(42, actualToProtoResult.getSerializedSize());
    assertTrue(actualToProtoResult.hasDefaultBranch());
  }

  /**
   * Test {@link ProtoUtils#toProto(RepositorySettings)} with {@code RepositorySettings}.
   * <ul>
   *   <li>Then return PasswordBytes toStringUtf8 is {@code iloveyou}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(RepositorySettings)}
   */
  @Test
  @DisplayName("Test toProto(RepositorySettings) with 'RepositorySettings'; then return PasswordBytes toStringUtf8 is 'iloveyou'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettingsProto ProtoUtils.toProto(RepositorySettings)"})
  void testToProtoWithRepositorySettings_thenReturnPasswordBytesToStringUtf8IsIloveyou() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPassword("iloveyou");
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    repositorySettings.setRepositoryUri("");

    // Act
    RepositorySettingsProto actualToProtoResult = ProtoUtils.toProto(repositorySettings);

    // Assert
    ByteString passwordBytes = actualToProtoResult.getPasswordBytes();
    assertEquals("iloveyou", passwordBytes.toStringUtf8());
    assertEquals("iloveyou", actualToProtoResult.getPassword());
    assertFalse(passwordBytes.isEmpty());
    ByteIterator iteratorResult = passwordBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(actualToProtoResult.hasPassword());
    assertEquals('i', iteratorResult.next().byteValue());
    assertEquals('l', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link ProtoUtils#toProto(TenantProfile)} with {@code TenantProfile}.
   * <ul>
   *   <li>Then return DescriptionBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(TenantProfile)}
   */
  @Test
  @DisplayName("Test toProto(TenantProfile) with 'TenantProfile'; then return DescriptionBytes toStringUtf8 is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TenantProfileProto ProtoUtils.toProto(TenantProfile)"})
  void testToProtoWithTenantProfile_thenReturnDescriptionBytesToStringUtf8IsEmptyString() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDescription(null);
    tenantProfile.setName("Tenant Profile");
    tenantProfile.setProfileDataBytes(null);

    // Act
    TenantProfileProto actualToProtoResult = ProtoUtils.toProto(tenantProfile);

    // Assert
    ByteString descriptionBytes = actualToProtoResult.getDescriptionBytes();
    assertEquals("", descriptionBytes.toStringUtf8());
    assertEquals("", actualToProtoResult.getDescription());
    ByteString nameBytes = actualToProtoResult.getNameBytes();
    assertEquals("Tenant Profile", nameBytes.toStringUtf8());
    assertEquals(1, actualToProtoResult.getAllFields().size());
    assertEquals(2, actualToProtoResult.getDescriptorForType().getOneofs().size());
    assertFalse(nameBytes.isEmpty());
    assertFalse(descriptionBytes.iterator().hasNext());
    assertFalse(actualToProtoResult.hasDescription());
    assertFalse(actualToProtoResult.hasProfileData());
    assertTrue(descriptionBytes.isEmpty());
    assertTrue(nameBytes.iterator().hasNext());
    TenantProfileProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertEquals(descriptionBytes, defaultInstanceForType.getDescriptionBytes());
    assertEquals(descriptionBytes, defaultInstanceForType.getNameBytes());
    ByteString profileData = actualToProtoResult.getProfileData();
    assertEquals(descriptionBytes, profileData);
    assertEquals(Short.SIZE, actualToProtoResult.getSerializedSize());
    assertSame(profileData, defaultInstanceForType.getProfileData());
  }

  /**
   * Test {@link ProtoUtils#toProto(TenantProfile)} with {@code TenantProfile}.
   * <ul>
   *   <li>Then return ProfileData toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(TenantProfile)}
   */
  @Test
  @DisplayName("Test toProto(TenantProfile) with 'TenantProfile'; then return ProfileData toStringUtf8 is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TenantProfileProto ProtoUtils.toProto(TenantProfile)"})
  void testToProtoWithTenantProfile_thenReturnProfileDataToStringUtf8IsEmptyString() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDescription("Tenant Profile");
    tenantProfile.setName("Tenant Profile");
    tenantProfile.setProfileDataBytes(null);

    // Act
    TenantProfileProto actualToProtoResult = ProtoUtils.toProto(tenantProfile);

    // Assert
    ByteString profileData = actualToProtoResult.getProfileData();
    assertEquals("", profileData.toStringUtf8());
    ByteString descriptionBytes = actualToProtoResult.getDescriptionBytes();
    assertEquals("Tenant Profile", descriptionBytes.toStringUtf8());
    assertEquals("Tenant Profile", actualToProtoResult.getDescription());
    assertFalse(descriptionBytes.isEmpty());
    assertFalse(profileData.iterator().hasNext());
    assertTrue(profileData.isEmpty());
    assertTrue(descriptionBytes.iterator().hasNext());
    assertTrue(actualToProtoResult.hasDescription());
    assertEquals(descriptionBytes, actualToProtoResult.getNameBytes());
    TenantProfileProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    assertEquals(profileData, defaultInstanceForType.getDescriptionBytes());
    assertEquals(profileData, defaultInstanceForType.getNameBytes());
    assertEquals(Integer.SIZE, actualToProtoResult.getSerializedSize());
  }

  /**
   * Test {@link ProtoUtils#toProto(Tenant)} with {@code Tenant}.
   * <ul>
   *   <li>Given {@code Dr}.</li>
   *   <li>When {@link Tenant#Tenant()} Title is {@code Dr}.</li>
   *   <li>Then return AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; given 'Dr'; when Tenant() Title is 'Dr'; then return AllFields size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProto ProtoUtils.toProto(Tenant)"})
  void testToProtoWithTenant_givenDr_whenTenantTitleIsDr_thenReturnAllFieldsSizeIsOne() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setTitle("Dr");

    // Act
    TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals(1, actualToProtoResult.getAllFields().size());
    assertEquals(4, actualToProtoResult.getSerializedSize());
  }

  /**
   * Test {@link ProtoUtils#toProto(Tenant)} with {@code Tenant}.
   * <ul>
   *   <li>Given {@code Mr}.</li>
   *   <li>Then return Title is {@code Mr}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; given 'Mr'; then return Title is 'Mr'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProto ProtoUtils.toProto(Tenant)"})
  void testToProtoWithTenant_givenMr_thenReturnTitleIsMr() {
    // Arrange
    TenantInfo tenant = new TenantInfo(new Tenant(), "foo.txt");
    tenant.setTitle("Mr");

    // Act
    TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals("Mr", actualToProtoResult.getTitle());
    assertEquals("null", actualToProtoResult.getAdditionalInfo());
    assertTrue(actualToProtoResult.hasAdditionalInfo());
  }

  /**
   * Test {@link ProtoUtils#toProto(Tenant)} with {@code Tenant}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link Tenant#Tenant()} Version is one.</li>
   *   <li>Then return Version is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; given one; when Tenant() Version is one; then return Version is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProto ProtoUtils.toProto(Tenant)"})
  void testToProtoWithTenant_givenOne_whenTenantVersionIsOne_thenReturnVersionIsOne() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setVersion(1L);
    tenant.setTitle("Dr");

    // Act
    TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals(1L, actualToProtoResult.getVersion());
    assertEquals(7, actualToProtoResult.getSerializedSize());
    assertTrue(actualToProtoResult.hasVersion());
  }

  /**
   * Test {@link ProtoUtils#toProto(ToDeviceActorNotificationMsg)} with {@code ToDeviceActorNotificationMsg}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ToDeviceActorNotificationMsg)}
   */
  @Test
  @DisplayName("Test toProto(ToDeviceActorNotificationMsg) with 'ToDeviceActorNotificationMsg'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TransportProtos.ToDeviceActorNotificationMsgProto ProtoUtils.toProto(ToDeviceActorNotificationMsg)"})
  void testToProtoWithToDeviceActorNotificationMsg() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = new DeviceId(UUID.randomUUID());

    // Act
    ToDeviceActorNotificationMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(id, tenantId, deviceId, true, 1L,
            new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info")));

    // Assert
    assertEquals("", actualToProtoResult.getInitializationErrorString());
    assertEquals(1, actualToProtoResult.getAllFields().size());
    assertFalse(actualToProtoResult.hasDeviceAttributesEventMsg());
    assertFalse(actualToProtoResult.hasDeviceCredentialsUpdateMsg());
    assertFalse(actualToProtoResult.hasDeviceDeleteMsg());
    assertFalse(actualToProtoResult.hasDeviceEdgeUpdateMsg());
    assertFalse(actualToProtoResult.hasDeviceNameOrTypeMsg());
    assertFalse(actualToProtoResult.hasFromDeviceRpcResponseMsg());
    assertFalse(actualToProtoResult.hasRemoveRpcActorMsg());
    assertTrue(actualToProtoResult.findInitializationErrors().isEmpty());
    assertTrue(actualToProtoResult.hasToDeviceRpcRequestMsg());
    assertTrue(actualToProtoResult.isInitialized());
  }

  /**
   * Test {@link ProtoUtils#toProto(ToDeviceActorNotificationMsg)} with {@code ToDeviceActorNotificationMsg}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ToDeviceActorNotificationMsg)}
   */
  @Test
  @DisplayName("Test toProto(ToDeviceActorNotificationMsg) with 'ToDeviceActorNotificationMsg'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TransportProtos.ToDeviceActorNotificationMsgProto ProtoUtils.toProto(ToDeviceActorNotificationMsg)"})
  void testToProtoWithToDeviceActorNotificationMsg_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ProtoUtils.toProto((ToDeviceActorNotificationMsg) null));
  }

  /**
   * Test {@link ProtoUtils#toProto(ToEdgeSyncRequest)} with {@code ToEdgeSyncRequest}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ToEdgeSyncRequest)}
   */
  @Test
  @DisplayName("Test toProto(ToEdgeSyncRequest) with 'ToEdgeSyncRequest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ToEdgeSyncRequestMsgProto ProtoUtils.toProto(ToEdgeSyncRequest)"})
  void testToProtoWithToEdgeSyncRequest() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ToEdgeSyncRequestMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ToEdgeSyncRequest(id, tenantId, new EdgeId(UUID.randomUUID()), "42"));

    // Assert
    assertEquals("", actualToProtoResult.getInitializationErrorString());
    assertEquals("42", actualToProtoResult.getServiceId());
    assertEquals(7, actualToProtoResult.getAllFields().size());
    assertTrue(actualToProtoResult.findInitializationErrors().isEmpty());
    assertTrue(actualToProtoResult.isInitialized());
  }

  /**
   * Test {@link ProtoUtils#fromProto(AttributeValueProto)} with {@code AttributeValueProto}.
   * <ul>
   *   <li>Then return {@link BaseAttributeKvEntry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#fromProto(AttributeValueProto)}
   */
  @Test
  @DisplayName("Test fromProto(AttributeValueProto) with 'AttributeValueProto'; then return BaseAttributeKvEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeKvEntry ProtoUtils.fromProto(AttributeValueProto)"})
  void testFromProtoWithAttributeValueProto_thenReturnBaseAttributeKvEntry() {
    // Arrange and Act
    AttributeKvEntry actualFromProtoResult = ProtoUtils.fromProto(AttributeValueProto.getDefaultInstance());

    // Assert
    assertTrue(actualFromProtoResult instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) actualFromProtoResult).getKv() instanceof BooleanDataEntry);
    assertEquals("", actualFromProtoResult.getKey());
    assertNull(actualFromProtoResult.getVersion());
    assertNull(actualFromProtoResult.getValue());
    assertEquals(0L, actualFromProtoResult.getLastUpdateTs());
    assertEquals(DataType.BOOLEAN, actualFromProtoResult.getDataType());
    Optional<Boolean> booleanValue = actualFromProtoResult.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertSame(booleanValue, actualFromProtoResult.getDoubleValue());
    assertSame(booleanValue, actualFromProtoResult.getJsonValue());
    assertSame(booleanValue, actualFromProtoResult.getLongValue());
    assertSame(booleanValue, actualFromProtoResult.getStrValue());
  }

  /**
   * Test {@link ProtoUtils#fromProto(DeviceCredentialsProto)} with {@code DeviceCredentialsProto}.
   * <ul>
   *   <li>Then return CredentialsId is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#fromProto(TransportProtos.DeviceCredentialsProto)}
   */
  @Test
  @DisplayName("Test fromProto(DeviceCredentialsProto) with 'DeviceCredentialsProto'; then return CredentialsId is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceCredentials ProtoUtils.fromProto(TransportProtos.DeviceCredentialsProto)"})
  void testFromProtoWithDeviceCredentialsProto_thenReturnCredentialsIdIsEmptyString() {
    // Arrange and Act
    DeviceCredentials actualFromProtoResult = ProtoUtils.fromProto(DeviceCredentialsProto.getDefaultInstance());

    // Assert
    assertEquals("", actualFromProtoResult.getCredentialsId());
    UUID uuidId = actualFromProtoResult.getUuidId();
    assertEquals("00000000-0000-0000-0000-000000000000", uuidId.toString());
    DeviceId deviceId = actualFromProtoResult.getDeviceId();
    assertEquals("00000000-0000-0000-0000-000000000000", deviceId.getId().toString());
    assertNull(actualFromProtoResult.getVersion());
    assertNull(actualFromProtoResult.getCredentialsValue());
    assertEquals(0L, actualFromProtoResult.getCreatedTime());
    assertEquals(EntityType.DEVICE, deviceId.getEntityType());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualFromProtoResult.getCredentialsType());
    assertFalse(deviceId.isNullUid());
    assertSame(uuidId, actualFromProtoResult.getId().getId());
  }

  /**
   * Test {@link ProtoUtils#fromProto(DeviceProto)} with {@code DeviceProto}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#fromProto(DeviceProto)}
   */
  @Test
  @DisplayName("Test fromProto(DeviceProto) with 'DeviceProto'; when DefaultInstance; then return Name is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Device ProtoUtils.fromProto(DeviceProto)"})
  void testFromProtoWithDeviceProto_whenDefaultInstance_thenReturnNameIsEmptyString() {
    // Arrange and Act
    Device actualFromProtoResult = ProtoUtils.fromProto(DeviceProto.getDefaultInstance());

    // Assert
    assertEquals("", actualFromProtoResult.getName());
    assertEquals("", actualFromProtoResult.getType());
    assertNull(actualFromProtoResult.getDeviceDataBytes());
    assertNull(actualFromProtoResult.getAdditionalInfo());
    assertNull(actualFromProtoResult.getVersion());
    assertNull(actualFromProtoResult.getLabel());
    assertNull(actualFromProtoResult.getDeviceData());
    assertNull(actualFromProtoResult.getCustomerId());
    assertNull(actualFromProtoResult.getExternalId());
    assertNull(actualFromProtoResult.getFirmwareId());
    assertNull(actualFromProtoResult.getSoftwareId());
    assertEquals(0L, actualFromProtoResult.getCreatedTime());
  }

  /**
   * Test {@link ProtoUtils#fromProto(EdgeEventUpdateMsgProto)} with {@code EdgeEventUpdateMsgProto}.
   * <p>
   * Method under test: {@link ProtoUtils#fromProto(TransportProtos.EdgeEventUpdateMsgProto)}
   */
  @Test
  @DisplayName("Test fromProto(EdgeEventUpdateMsgProto) with 'EdgeEventUpdateMsgProto'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeEventUpdateMsg ProtoUtils.fromProto(TransportProtos.EdgeEventUpdateMsgProto)"})
  void testFromProtoWithEdgeEventUpdateMsgProto() {
    // Arrange and Act
    EdgeEventUpdateMsg actualFromProtoResult = ProtoUtils.fromProto(EdgeEventUpdateMsgProto.getDefaultInstance());

    // Assert
    EdgeId edgeId = actualFromProtoResult.getEdgeId();
    assertEquals("00000000-0000-0000-0000-000000000000", edgeId.getId().toString());
    TenantId tenantId = actualFromProtoResult.getTenantId();
    assertEquals("00000000-0000-0000-0000-000000000000", tenantId.getId().toString());
    assertEquals(EntityType.EDGE, edgeId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(MsgType.EDGE_EVENT_UPDATE_TO_EDGE_SESSION_MSG, actualFromProtoResult.getMsgType());
    assertFalse(edgeId.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link ProtoUtils#fromProto(EntityTypeProto)} with {@code EntityTypeProto}.
   * <ul>
   *   <li>When {@code UNSPECIFIED}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#fromProto(EntityTypeProto)}
   */
  @Test
  @DisplayName("Test fromProto(EntityTypeProto) with 'EntityTypeProto'; when 'UNSPECIFIED'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType ProtoUtils.fromProto(EntityTypeProto)"})
  void testFromProtoWithEntityTypeProto_whenUnspecified_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ProtoUtils.fromProto(EntityTypeProto.UNSPECIFIED));
  }

  /**
   * Test {@link ProtoUtils#fromProto(FromEdgeSyncResponseMsgProto)} with {@code FromEdgeSyncResponseMsgProto}.
   * <ul>
   *   <li>Then return Error is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#fromProto(FromEdgeSyncResponseMsgProto)}
   */
  @Test
  @DisplayName("Test fromProto(FromEdgeSyncResponseMsgProto) with 'FromEdgeSyncResponseMsgProto'; then return Error is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FromEdgeSyncResponse ProtoUtils.fromProto(FromEdgeSyncResponseMsgProto)"})
  void testFromProtoWithFromEdgeSyncResponseMsgProto_thenReturnErrorIsEmptyString() {
    // Arrange and Act
    FromEdgeSyncResponse actualFromProtoResult = ProtoUtils
        .fromProto(FromEdgeSyncResponseMsgProto.getDefaultInstance());

    // Assert
    assertEquals("", actualFromProtoResult.getError());
    EdgeId edgeId = actualFromProtoResult.getEdgeId();
    assertEquals("00000000-0000-0000-0000-000000000000", edgeId.getId().toString());
    TenantId tenantId = actualFromProtoResult.getTenantId();
    assertEquals("00000000-0000-0000-0000-000000000000", tenantId.getId().toString());
    assertEquals("00000000-0000-0000-0000-000000000000", actualFromProtoResult.getId().toString());
    assertEquals(EntityType.EDGE, edgeId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(MsgType.EDGE_SYNC_RESPONSE_FROM_EDGE_SESSION_MSG, actualFromProtoResult.getMsgType());
    assertFalse(edgeId.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertFalse(actualFromProtoResult.isSuccess());
  }

  /**
   * Test {@link ProtoUtils#fromProto(TenantProfileProto)} with {@code TenantProfileProto}.
   * <ul>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#fromProto(TransportProtos.TenantProfileProto)}
   */
  @Test
  @DisplayName("Test fromProto(TenantProfileProto) with 'TenantProfileProto'; then return Name is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProfile ProtoUtils.fromProto(TransportProtos.TenantProfileProto)"})
  void testFromProtoWithTenantProfileProto_thenReturnNameIsEmptyString() {
    // Arrange and Act
    TenantProfile actualFromProtoResult = ProtoUtils.fromProto(TenantProfileProto.getDefaultInstance());

    // Assert
    assertEquals("", actualFromProtoResult.getName());
    assertNull(actualFromProtoResult.getProfileDataBytes());
    assertNull(actualFromProtoResult.getDescription());
    assertEquals(0L, actualFromProtoResult.getCreatedTime());
    assertFalse(actualFromProtoResult.isDefault());
    assertFalse(actualFromProtoResult.isIsolatedTbRuleEngine());
  }

  /**
   * Test {@link ProtoUtils#fromProto(TenantProto)} with {@code TenantProto}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#fromProto(TenantProto)}
   */
  @Test
  @DisplayName("Test fromProto(TenantProto) with 'TenantProto'; when DefaultInstance; then return Name is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tenant ProtoUtils.fromProto(TenantProto)"})
  void testFromProtoWithTenantProto_whenDefaultInstance_thenReturnNameIsEmptyString() {
    // Arrange and Act
    Tenant actualFromProtoResult = ProtoUtils.fromProto(TenantProto.getDefaultInstance());

    // Assert
    assertEquals("", actualFromProtoResult.getName());
    assertEquals("", actualFromProtoResult.getTitle());
    assertNull(actualFromProtoResult.getAdditionalInfo());
    assertNull(actualFromProtoResult.getVersion());
    assertNull(actualFromProtoResult.getAddress());
    assertNull(actualFromProtoResult.getAddress2());
    assertNull(actualFromProtoResult.getCity());
    assertNull(actualFromProtoResult.getCountry());
    assertNull(actualFromProtoResult.getEmail());
    assertNull(actualFromProtoResult.getPhone());
    assertNull(actualFromProtoResult.getRegion());
    assertNull(actualFromProtoResult.getState());
    assertNull(actualFromProtoResult.getZip());
    assertEquals(0L, actualFromProtoResult.getCreatedTime());
  }

  /**
   * Test {@link ProtoUtils#fromProto(ToDeviceActorNotificationMsgProto)} with {@code ToDeviceActorNotificationMsgProto}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#fromProto(TransportProtos.ToDeviceActorNotificationMsgProto)}
   */
  @Test
  @DisplayName("Test fromProto(ToDeviceActorNotificationMsgProto) with 'ToDeviceActorNotificationMsgProto'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ToDeviceActorNotificationMsg ProtoUtils.fromProto(TransportProtos.ToDeviceActorNotificationMsgProto)"})
  void testFromProtoWithToDeviceActorNotificationMsgProto_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ProtoUtils.fromProto(ToDeviceActorNotificationMsgProto.getDefaultInstance()));
  }

  /**
   * Test {@link ProtoUtils#fromProto(ToEdgeSyncRequestMsgProto)} with {@code ToEdgeSyncRequestMsgProto}.
   * <ul>
   *   <li>Then return ServiceId is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#fromProto(TransportProtos.ToEdgeSyncRequestMsgProto)}
   */
  @Test
  @DisplayName("Test fromProto(ToEdgeSyncRequestMsgProto) with 'ToEdgeSyncRequestMsgProto'; then return ServiceId is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToEdgeSyncRequest ProtoUtils.fromProto(TransportProtos.ToEdgeSyncRequestMsgProto)"})
  void testFromProtoWithToEdgeSyncRequestMsgProto_thenReturnServiceIdIsEmptyString() {
    // Arrange and Act
    ToEdgeSyncRequest actualFromProtoResult = ProtoUtils.fromProto(ToEdgeSyncRequestMsgProto.getDefaultInstance());

    // Assert
    assertEquals("", actualFromProtoResult.getServiceId());
    EdgeId edgeId = actualFromProtoResult.getEdgeId();
    assertEquals("00000000-0000-0000-0000-000000000000", edgeId.getId().toString());
    TenantId tenantId = actualFromProtoResult.getTenantId();
    assertEquals("00000000-0000-0000-0000-000000000000", tenantId.getId().toString());
    assertEquals("00000000-0000-0000-0000-000000000000", actualFromProtoResult.getId().toString());
    assertEquals(EntityType.EDGE, edgeId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(MsgType.EDGE_SYNC_REQUEST_TO_EDGE_SESSION_MSG, actualFromProtoResult.getMsgType());
    assertFalse(edgeId.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link ProtoUtils#toEntityUpdateProto(Object)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link OAuth2Client#OAuth2Client()} AdditionalInfo is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toEntityUpdateProto(Object)}
   */
  @Test
  @DisplayName("Test toEntityUpdateProto(Object); given 'null'; when OAuth2Client() AdditionalInfo is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.EntityUpdateMsg ProtoUtils.toEntityUpdateProto(Object)"})
  void testToEntityUpdateProto_givenNull_whenOAuth2ClientAdditionalInfoIsNull() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setAdditionalInfo(null);

    // Act
    EntityUpdateMsg actualToEntityUpdateProtoResult = ProtoUtils.toEntityUpdateProto(oAuth2Client);

    // Assert
    assertEquals(actualToEntityUpdateProtoResult, actualToEntityUpdateProtoResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toEntityUpdateProto(Object)}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toEntityUpdateProto(Object)}
   */
  @Test
  @DisplayName("Test toEntityUpdateProto(Object); when 'Entity'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.EntityUpdateMsg ProtoUtils.toEntityUpdateProto(Object)"})
  void testToEntityUpdateProto_whenEntity() {
    // Arrange and Act
    EntityUpdateMsg actualToEntityUpdateProtoResult = ProtoUtils.toEntityUpdateProto("Entity");

    // Assert
    assertEquals(actualToEntityUpdateProtoResult, actualToEntityUpdateProtoResult.getDefaultInstanceForType());
  }
}
