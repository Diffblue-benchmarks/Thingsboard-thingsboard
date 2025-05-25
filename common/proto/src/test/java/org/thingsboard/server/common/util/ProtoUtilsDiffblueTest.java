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
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.UnknownFieldSet;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
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
import org.thingsboard.server.common.msg.rule.engine.DeviceAttributesEventNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.AttributeValueProto;
import org.thingsboard.server.gen.transport.TransportProtos.ComponentLifecycleMsgProto;
import org.thingsboard.server.gen.transport.TransportProtos.DeviceAttributesEventMsgProto;
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
   *   <li>Given of ten.</li>
   *   <li>Then return DoubleV is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; given of ten; then return DoubleV is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_givenOfTen_thenReturnDoubleVIsTen() {
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
   *   <li>Then return JsonV is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; then return JsonV is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_thenReturnJsonVIsFoo() {
    // Arrange
    Optional<String> ofResult = Optional.of("foo");
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getJsonValue()).thenReturn(ofResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.JSON);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    assertEquals("foo", actualToProtoResult.getJsonV());
    ByteString jsonVBytes = actualToProtoResult.getJsonVBytes();
    ByteIterator iteratorResult = jsonVBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('f', nextResult.byteValue());
    assertEquals('o', nextResult2.byteValue());
    assertEquals('o', nextResult3.byteValue());
    assertEquals("foo", jsonVBytes.toStringUtf8());
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry, atLeast(1)).getJsonValue();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
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
   *   <li>Then return StringV is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; then return StringV is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeValueProto ProtoUtils.toProto(AttributeKvEntry)"})
  void testToProtoWithAttributeKvEntry_thenReturnStringVIsFoo() {
    // Arrange
    Optional<String> ofResult = Optional.of("foo");
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getStrValue()).thenReturn(ofResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.STRING);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    assertEquals("foo", actualToProtoResult.getStringV());
    ByteString stringVBytes = actualToProtoResult.getStringVBytes();
    ByteIterator iteratorResult = stringVBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('f', nextResult.byteValue());
    assertEquals('o', nextResult2.byteValue());
    assertEquals('o', nextResult3.byteValue());
    assertEquals("foo", stringVBytes.toStringUtf8());
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry, atLeast(1)).getStrValue();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
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
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.CREATED));

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
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.CREATED));

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
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.CREATED));

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
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.CREATED));

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
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.CREATED));

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
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new DomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.CREATED));

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
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.CREATED));

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
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.CREATED));

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
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.CREATED));

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
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.CREATED));

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
   *   <li>Then return EventValue is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.ComponentLifecycleMsgProto ProtoUtils.toProto(ComponentLifecycleMsg)"})
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsEight() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.DEACTIVATED));

    // Assert
    assertEquals(8, actualToProtoResult.getEventValue());
    assertEquals(TransportProtos.ComponentLifecycleEvent.DEACTIVATED, actualToProtoResult.getEvent());
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
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.STOPPED));

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
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.UPDATED));

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
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.STARTED));

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
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.FAILED));

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
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.DELETED));

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
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.SUSPENDED));

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
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(new ComponentLifecycleMsg(tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ComponentLifecycleEvent.ACTIVATED));

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
    deviceCredentials.setId(new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceCredentialsProto actualToProtoResult = ProtoUtils.toProto(deviceCredentials);

    // Assert
    DeviceCredentialsProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    ByteString credentialsIdBytes = defaultInstanceForType.getCredentialsIdBytes();
    assertEquals("", credentialsIdBytes.toStringUtf8());
    assertEquals("42", actualToProtoResult.getCredentialsValue());
    assertEquals(29, actualToProtoResult.getSerializedSize());
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
    deviceCredentials.setId(new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceCredentialsProto actualToProtoResult = ProtoUtils.toProto(deviceCredentials);

    // Assert
    assertEquals(0L, actualToProtoResult.getVersion());
    assertEquals(25, actualToProtoResult.getSerializedSize());
    assertEquals(3, actualToProtoResult.getAllFields().size());
    assertFalse(actualToProtoResult.hasVersion());
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
    deviceCredentials.setId(new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    DeviceCredentialsProto actualToProtoResult = ProtoUtils.toProto(deviceCredentials);

    // Assert
    assertEquals(1L, actualToProtoResult.getVersion());
    assertEquals(27, actualToProtoResult.getSerializedSize());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertTrue(actualToProtoResult.hasVersion());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.DeviceProfileProto ProtoUtils.toProto(DeviceProfile)"})
  void testToProtoWithDeviceProfile() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDescription("The characteristics of someone or something");
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceProfile.setName("");

    // Act
    DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    assertEquals("The characteristics of someone or something", actualToProtoResult.getDescription());
    ByteString descriptionBytes = actualToProtoResult.getDescriptionBytes();
    assertFalse(descriptionBytes.isEmpty());
    ByteIterator iteratorResult = descriptionBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals("The characteristics of someone or something", descriptionBytes.toStringUtf8());
    assertEquals(91, actualToProtoResult.getSerializedSize());
    assertTrue(actualToProtoResult.hasDescription());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.DeviceProfileProto ProtoUtils.toProto(DeviceProfile)"})
  void testToProtoWithDeviceProfile2() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceProfile.setName("");

    // Act
    DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    assertEquals(-7476899250389416711L, actualToProtoResult.getDefaultRuleChainIdLSB());
    assertEquals(67, actualToProtoResult.getSerializedSize());
    assertEquals(7, actualToProtoResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualToProtoResult.getDefaultRuleChainIdMSB());
    assertTrue(actualToProtoResult.hasDefaultRuleChainIdLSB());
    assertTrue(actualToProtoResult.hasDefaultRuleChainIdMSB());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Given {@code DISABLED}.</li>
   *   <li>Then return Description is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; given 'DISABLED'; then return Description is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.DeviceProfileProto ProtoUtils.toProto(DeviceProfile)"})
  void testToProtoWithDeviceProfile_givenDisabled_thenReturnDescriptionIsEmptyString() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceProfile.setName("");

    // Act
    DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    assertEquals("", actualToProtoResult.getDescription());
    assertEquals("", actualToProtoResult.getImage());
    assertEquals(0L, actualToProtoResult.getDefaultRuleChainIdLSB());
    assertEquals(0L, actualToProtoResult.getDefaultRuleChainIdMSB());
    assertEquals(46, actualToProtoResult.getSerializedSize());
    assertEquals(5, actualToProtoResult.getAllFields().size());
    assertFalse(actualToProtoResult.hasDefaultRuleChainIdLSB());
    assertFalse(actualToProtoResult.hasDefaultRuleChainIdMSB());
    assertFalse(actualToProtoResult.hasDescription());
    assertFalse(actualToProtoResult.hasDeviceProfileData());
    assertFalse(actualToProtoResult.hasImage());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Given {@code Image}.</li>
   *   <li>Then return {@code Image}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; given 'Image'; then return 'Image'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.DeviceProfileProto ProtoUtils.toProto(DeviceProfile)"})
  void testToProtoWithDeviceProfile_givenImage_thenReturnImage() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setImage("Image");
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceProfile.setName("");

    // Act
    DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    assertEquals("Image", actualToProtoResult.getImage());
    ByteString imageBytes = actualToProtoResult.getImageBytes();
    assertFalse(imageBytes.isEmpty());
    ByteIterator iteratorResult = imageBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('I', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals("Image", imageBytes.toStringUtf8());
    assertEquals(53, actualToProtoResult.getSerializedSize());
    assertTrue(actualToProtoResult.hasImage());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return not DeviceProfileData Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; given 'null'; then return not DeviceProfileData Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.DeviceProfileProto ProtoUtils.toProto(DeviceProfile)"})
  void testToProtoWithDeviceProfile_givenNull_thenReturnNotDeviceProfileDataEmpty() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    deviceProfile.setDefaultRuleChainId(null);
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceProfile.setName("");

    // Act
    DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    ByteString deviceProfileData = actualToProtoResult.getDeviceProfileData();
    assertFalse(deviceProfileData.isEmpty());
    ByteIterator iteratorResult = deviceProfileData.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals((byte) 1, iteratorResult.next().byteValue());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals("A\u0001A\u0001A\u0001A\u0001", deviceProfileData.toStringUtf8());
    assertEquals(57, actualToProtoResult.getSerializedSize());
    assertTrue(actualToProtoResult.hasDeviceProfileData());
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
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    EdgeEventUpdateMsgProto actualToProtoResult = ProtoUtils
        .toProto(new EdgeEventUpdateMsg(tenantId, new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Assert
    assertEquals("", actualToProtoResult.getInitializationErrorString());
    assertEquals(-7476899250389416711L, actualToProtoResult.getEdgeIdLSB());
    assertEquals(-7476899250389416711L, actualToProtoResult.getTenantIdLSB());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertEquals(42, actualToProtoResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualToProtoResult.getEdgeIdMSB());
    assertEquals(8669210807411032922L, actualToProtoResult.getTenantIdMSB());
    assertTrue(actualToProtoResult.findInitializationErrors().isEmpty());
    assertTrue(actualToProtoResult.isInitialized());
  }

  /**
   * Test {@link ProtoUtils#toProto(EdgeHighPriorityMsg)} with {@code EdgeHighPriorityMsg}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return Body is {@code "QQFB"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EdgeHighPriorityMsg)}
   */
  @Test
  @DisplayName("Test toProto(EdgeHighPriorityMsg) with 'EdgeHighPriorityMsg'; given 'A'; then return Body is '\"QQFB\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.EdgeHighPriorityMsgProto ProtoUtils.toProto(EdgeHighPriorityMsg)"})
  void testToProtoWithEdgeHighPriorityMsg_givenA_thenReturnBodyIsQqfb() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setBody(new BinaryNode(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 2, 3));
    edgeEvent.setAction(EdgeEventActionType.ADDED);
    edgeEvent.setType(EdgeEventType.ASSET);

    // Act
    EdgeHighPriorityMsgProto actualToProtoResult = ProtoUtils.toProto(
        new EdgeHighPriorityMsg(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), edgeEvent));

    // Assert
    assertEquals("\"QQFB\"", actualToProtoResult.getBody());
    ByteString bodyBytes = actualToProtoResult.getBodyBytes();
    ByteIterator iteratorResult = bodyBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('"', iteratorResult.next().byteValue());
    assertEquals('Q', iteratorResult.next().byteValue());
    assertEquals('Q', iteratorResult.next().byteValue());
    assertEquals("\"QQFB\"", bodyBytes.toStringUtf8());
  }

  /**
   * Test {@link ProtoUtils#toProto(EdgeHighPriorityMsg)} with {@code EdgeHighPriorityMsg}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then return Body is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EdgeHighPriorityMsg)}
   */
  @Test
  @DisplayName("Test toProto(EdgeHighPriorityMsg) with 'EdgeHighPriorityMsg'; given Instance; then return Body is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.EdgeHighPriorityMsgProto ProtoUtils.toProto(EdgeHighPriorityMsg)"})
  void testToProtoWithEdgeHighPriorityMsg_givenInstance_thenReturnBodyIsNull() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setBody(MissingNode.getInstance());
    edgeEvent.setAction(EdgeEventActionType.ADDED);
    edgeEvent.setType(EdgeEventType.ASSET);

    // Act
    EdgeHighPriorityMsgProto actualToProtoResult = ProtoUtils.toProto(
        new EdgeHighPriorityMsg(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), edgeEvent));

    // Assert
    assertEquals("null", actualToProtoResult.getBody());
    ByteString bodyBytes = actualToProtoResult.getBodyBytes();
    ByteIterator iteratorResult = bodyBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('l', iteratorResult.next().byteValue());
    assertEquals("null", bodyBytes.toStringUtf8());
    assertEquals(41, actualToProtoResult.getSerializedSize());
  }

  /**
   * Test {@link ProtoUtils#toProto(EdgeHighPriorityMsg)} with {@code EdgeHighPriorityMsg}.
   * <ul>
   *   <li>Then return BodyBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EdgeHighPriorityMsg)}
   */
  @Test
  @DisplayName("Test toProto(EdgeHighPriorityMsg) with 'EdgeHighPriorityMsg'; then return BodyBytes toStringUtf8 is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.EdgeHighPriorityMsgProto ProtoUtils.toProto(EdgeHighPriorityMsg)"})
  void testToProtoWithEdgeHighPriorityMsg_thenReturnBodyBytesToStringUtf8IsEmptyString() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);
    edgeEvent.setType(EdgeEventType.ASSET);

    // Act
    EdgeHighPriorityMsgProto actualToProtoResult = ProtoUtils.toProto(
        new EdgeHighPriorityMsg(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), edgeEvent));

    // Assert
    ByteString bodyBytes = actualToProtoResult.getBodyBytes();
    assertEquals("", bodyBytes.toStringUtf8());
    assertEquals("", actualToProtoResult.getBody());
    assertEquals(35, actualToProtoResult.getSerializedSize());
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
   *   <li>Then return Body is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EdgeHighPriorityMsg)}
   */
  @Test
  @DisplayName("Test toProto(EdgeHighPriorityMsg) with 'EdgeHighPriorityMsg'; then return Body is '1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.EdgeHighPriorityMsgProto ProtoUtils.toProto(EdgeHighPriorityMsg)"})
  void testToProtoWithEdgeHighPriorityMsg_thenReturnBodyIs1() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setBody(new BigIntegerNode(BigInteger.valueOf(1L)));
    edgeEvent.setAction(EdgeEventActionType.ADDED);
    edgeEvent.setType(EdgeEventType.ASSET);

    // Act
    EdgeHighPriorityMsgProto actualToProtoResult = ProtoUtils.toProto(new EdgeHighPriorityMsg(tenantId, edgeEvent));

    // Assert
    assertEquals("1", actualToProtoResult.getBody());
    ByteString bodyBytes = actualToProtoResult.getBodyBytes();
    ByteIterator iteratorResult = bodyBytes.iterator();
    Byte nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('1', nextResult.byteValue());
    assertEquals("1", bodyBytes.toStringUtf8());
    assertEquals(38, actualToProtoResult.getSerializedSize());
  }

  /**
   * Test {@link ProtoUtils#toProto(EdgeHighPriorityMsg)} with {@code EdgeHighPriorityMsg}.
   * <ul>
   *   <li>Then return EntityIdLSB is {@code -7476899250389416711}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EdgeHighPriorityMsg)}
   */
  @Test
  @DisplayName("Test toProto(EdgeHighPriorityMsg) with 'EdgeHighPriorityMsg'; then return EntityIdLSB is '-7476899250389416711'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.EdgeHighPriorityMsgProto ProtoUtils.toProto(EdgeHighPriorityMsg)"})
  void testToProtoWithEdgeHighPriorityMsg_thenReturnEntityIdLSBIs7476899250389416711() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEvent.setAction(EdgeEventActionType.ADDED);
    edgeEvent.setType(EdgeEventType.ASSET);

    // Act
    EdgeHighPriorityMsgProto actualToProtoResult = ProtoUtils.toProto(
        new EdgeHighPriorityMsg(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), edgeEvent));

    // Assert
    assertEquals(-7476899250389416711L, actualToProtoResult.getEntityIdLSB());
    assertEquals(56, actualToProtoResult.getSerializedSize());
    assertEquals(6, actualToProtoResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualToProtoResult.getEntityIdMSB());
    assertTrue(actualToProtoResult.hasEntityIdLSB());
    assertTrue(actualToProtoResult.hasEntityIdMSB());
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
  @MethodsUnderTest({"TransportProtos.EntityTypeProto ProtoUtils.toProto(EntityType)"})
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
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    FromEdgeSyncResponseMsgProto actualToProtoResult = ProtoUtils.toProto(new FromEdgeSyncResponse(id, tenantId,
        new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), true, "An error occurred"));

    // Assert
    assertEquals("", actualToProtoResult.getInitializationErrorString());
    assertEquals("An error occurred", actualToProtoResult.getError());
    assertEquals(-7476899250389416711L, actualToProtoResult.getEdgeIdLSB());
    assertEquals(-7476899250389416711L, actualToProtoResult.getResponseIdLSB());
    assertEquals(-7476899250389416711L, actualToProtoResult.getTenantIdLSB());
    assertEquals(8, actualToProtoResult.getAllFields().size());
    assertEquals(84, actualToProtoResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualToProtoResult.getEdgeIdMSB());
    assertEquals(8669210807411032922L, actualToProtoResult.getResponseIdMSB());
    assertEquals(8669210807411032922L, actualToProtoResult.getTenantIdMSB());
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
  @MethodsUnderTest({"TransportProtos.RepositorySettingsProto ProtoUtils.toProto(RepositorySettings)"})
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
  @MethodsUnderTest({"TransportProtos.RepositorySettingsProto ProtoUtils.toProto(RepositorySettings)"})
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
   *   <li>Given {@code janedoe}.</li>
   *   <li>Then return Username is {@code janedoe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(RepositorySettings)}
   */
  @Test
  @DisplayName("Test toProto(RepositorySettings) with 'RepositorySettings'; given 'janedoe'; then return Username is 'janedoe'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.RepositorySettingsProto ProtoUtils.toProto(RepositorySettings)"})
  void testToProtoWithRepositorySettings_givenJanedoe_thenReturnUsernameIsJanedoe() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setUsername("janedoe");
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    repositorySettings.setRepositoryUri("");

    // Act
    RepositorySettingsProto actualToProtoResult = ProtoUtils.toProto(repositorySettings);

    // Assert
    assertEquals("janedoe", actualToProtoResult.getUsername());
    ByteString usernameBytes = actualToProtoResult.getUsernameBytes();
    assertFalse(usernameBytes.isEmpty());
    ByteIterator iteratorResult = usernameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('j', iteratorResult.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals("janedoe", usernameBytes.toStringUtf8());
    assertTrue(actualToProtoResult.hasUsername());
  }

  /**
   * Test {@link ProtoUtils#toProto(RepositorySettings)} with {@code RepositorySettings}.
   * <ul>
   *   <li>Given {@code Private Key}.</li>
   *   <li>Then return {@code Private Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(RepositorySettings)}
   */
  @Test
  @DisplayName("Test toProto(RepositorySettings) with 'RepositorySettings'; given 'Private Key'; then return 'Private Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.RepositorySettingsProto ProtoUtils.toProto(RepositorySettings)"})
  void testToProtoWithRepositorySettings_givenPrivateKey_thenReturnPrivateKey() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKey("Private Key");
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    repositorySettings.setRepositoryUri("");

    // Act
    RepositorySettingsProto actualToProtoResult = ProtoUtils.toProto(repositorySettings);

    // Assert
    assertEquals("Private Key", actualToProtoResult.getPrivateKey());
    ByteString privateKeyBytes = actualToProtoResult.getPrivateKeyBytes();
    assertFalse(privateKeyBytes.isEmpty());
    ByteIterator iteratorResult = privateKeyBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('P', iteratorResult.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertEquals('i', iteratorResult.next().byteValue());
    assertEquals("Private Key", privateKeyBytes.toStringUtf8());
    assertEquals(Integer.SIZE, actualToProtoResult.getSerializedSize());
    assertTrue(actualToProtoResult.hasPrivateKey());
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
  @MethodsUnderTest({"TransportProtos.RepositorySettingsProto ProtoUtils.toProto(RepositorySettings)"})
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
  @MethodsUnderTest({"TransportProtos.RepositorySettingsProto ProtoUtils.toProto(RepositorySettings)"})
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
  @MethodsUnderTest({"TransportProtos.RepositorySettingsProto ProtoUtils.toProto(RepositorySettings)"})
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
   *   <li>Given {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(TenantProfile)}
   */
  @Test
  @DisplayName("Test toProto(TenantProfile) with 'TenantProfile'; given 'Name'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TenantProfileProto ProtoUtils.toProto(TenantProfile)"})
  void testToProtoWithTenantProfile_givenName_thenReturnName() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenantProfile.setName("Name");

    // Act
    TenantProfileProto actualToProtoResult = ProtoUtils.toProto(tenantProfile);

    // Assert
    assertEquals("Name", actualToProtoResult.getName());
    assertEquals(-7476899250389416711L, actualToProtoResult.getTenantProfileIdLSB());
    assertEquals(27, actualToProtoResult.getSerializedSize());
    assertEquals(3, actualToProtoResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualToProtoResult.getTenantProfileIdMSB());
  }

  /**
   * Test {@link ProtoUtils#toProto(TenantProfile)} with {@code TenantProfile}.
   * <ul>
   *   <li>Then return DescriptorForType Fields size is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(TenantProfile)}
   */
  @Test
  @DisplayName("Test toProto(TenantProfile) with 'TenantProfile'; then return DescriptorForType Fields size is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TenantProfileProto ProtoUtils.toProto(TenantProfile)"})
  void testToProtoWithTenantProfile_thenReturnDescriptorForTypeFieldsSizeIsEight() throws UnsupportedEncodingException {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDescription(null);
    tenantProfile.setName("Tenant Profile");
    tenantProfile.setProfileDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    TenantProfileProto actualToProtoResult = ProtoUtils.toProto(tenantProfile);

    // Assert
    List<FieldDescriptor> fields = actualToProtoResult.getDescriptorForType().getFields();
    assertEquals(8, fields.size());
    ByteString expectedDefaultValue = actualToProtoResult.getDefaultInstanceForType().getProfileData();
    assertSame(expectedDefaultValue, fields.get(7).getDefaultValue());
    ByteString profileData = actualToProtoResult.getProfileData();
    assertFalse(profileData.isEmpty());
    ByteIterator iteratorResult = profileData.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals("AXAXAXAX", profileData.toStringUtf8());
    assertEquals(26, actualToProtoResult.getSerializedSize());
    assertTrue(actualToProtoResult.hasProfileData());
  }

  /**
   * Test {@link ProtoUtils#toProto(TenantProfile)} with {@code TenantProfile}.
   * <ul>
   *   <li>Then return NameBytes toStringUtf8 is {@code Tenant Profile}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(TenantProfile)}
   */
  @Test
  @DisplayName("Test toProto(TenantProfile) with 'TenantProfile'; then return NameBytes toStringUtf8 is 'Tenant Profile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TenantProfileProto ProtoUtils.toProto(TenantProfile)"})
  void testToProtoWithTenantProfile_thenReturnNameBytesToStringUtf8IsTenantProfile() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDescription(null);
    tenantProfile.setName("Tenant Profile");
    tenantProfile.setProfileDataBytes(null);

    // Act
    TenantProfileProto actualToProtoResult = ProtoUtils.toProto(tenantProfile);

    // Assert
    ByteString nameBytes = actualToProtoResult.getNameBytes();
    assertEquals("Tenant Profile", nameBytes.toStringUtf8());
    assertEquals(1, actualToProtoResult.getAllFields().size());
    assertEquals(2, actualToProtoResult.getDescriptorForType().getOneofs().size());
    ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals(Short.SIZE, actualToProtoResult.getSerializedSize());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals('n', iteratorResult.next().byteValue());
    ByteString expectedProfileData = actualToProtoResult.getProfileData();
    assertSame(expectedProfileData, actualToProtoResult.getDefaultInstanceForType().getProfileData());
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
   *   <li>Given {@code 21654}.</li>
   *   <li>When {@link Tenant#Tenant()} Zip is {@code 21654}.</li>
   *   <li>Then return Zip is {@code 21654}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; given '21654'; when Tenant() Zip is '21654'; then return Zip is '21654'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProto ProtoUtils.toProto(Tenant)"})
  void testToProtoWithTenant_given21654_whenTenantZipIs21654_thenReturnZipIs21654() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setZip("21654");
    tenant.setTitle("Dr");

    // Act
    TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals("21654", actualToProtoResult.getZip());
    ByteString zipBytes = actualToProtoResult.getZipBytes();
    assertFalse(zipBytes.isEmpty());
    ByteIterator iteratorResult = zipBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('2', iteratorResult.next().byteValue());
    assertEquals('1', iteratorResult.next().byteValue());
    assertEquals('6', iteratorResult.next().byteValue());
    assertEquals("21654", zipBytes.toStringUtf8());
    assertTrue(actualToProtoResult.hasZip());
  }

  /**
   * Test {@link ProtoUtils#toProto(Tenant)} with {@code Tenant}.
   * <ul>
   *   <li>Given {@code 6625550144}.</li>
   *   <li>Then return Phone is {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; given '6625550144'; then return Phone is '6625550144'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProto ProtoUtils.toProto(Tenant)"})
  void testToProtoWithTenant_given6625550144_thenReturnPhoneIs6625550144() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setPhone("6625550144");
    tenant.setTitle("Dr");

    // Act
    TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals("6625550144", actualToProtoResult.getPhone());
    ByteString phoneBytes = actualToProtoResult.getPhoneBytes();
    assertFalse(phoneBytes.isEmpty());
    ByteIterator iteratorResult = phoneBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('6', iteratorResult.next().byteValue());
    assertEquals('6', iteratorResult.next().byteValue());
    assertEquals('2', iteratorResult.next().byteValue());
    assertEquals("6625550144", phoneBytes.toStringUtf8());
    assertTrue(actualToProtoResult.hasPhone());
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
   *   <li>Given {@code GB}.</li>
   *   <li>When {@link Tenant#Tenant()} Country is {@code GB}.</li>
   *   <li>Then return Country is {@code GB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; given 'GB'; when Tenant() Country is 'GB'; then return Country is 'GB'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProto ProtoUtils.toProto(Tenant)"})
  void testToProtoWithTenant_givenGb_whenTenantCountryIsGb_thenReturnCountryIsGb() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setCountry("GB");
    tenant.setTitle("Dr");

    // Act
    TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals("GB", actualToProtoResult.getCountry());
    ByteString countryBytes = actualToProtoResult.getCountryBytes();
    assertFalse(countryBytes.isEmpty());
    ByteIterator iteratorResult = countryBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('G', nextResult.byteValue());
    assertEquals('B', nextResult2.byteValue());
    assertEquals("GB", countryBytes.toStringUtf8());
    assertTrue(actualToProtoResult.hasCountry());
  }

  /**
   * Test {@link ProtoUtils#toProto(Tenant)} with {@code Tenant}.
   * <ul>
   *   <li>Given {@code jane.doe@example.org}.</li>
   *   <li>Then return Email is {@code jane.doe@example.org}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; given 'jane.doe@example.org'; then return Email is 'jane.doe@example.org'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProto ProtoUtils.toProto(Tenant)"})
  void testToProtoWithTenant_givenJaneDoeExampleOrg_thenReturnEmailIsJaneDoeExampleOrg() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setEmail("jane.doe@example.org");
    tenant.setTitle("Dr");

    // Act
    TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals("jane.doe@example.org", actualToProtoResult.getEmail());
    ByteString emailBytes = actualToProtoResult.getEmailBytes();
    assertFalse(emailBytes.isEmpty());
    ByteIterator iteratorResult = emailBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('j', iteratorResult.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals("jane.doe@example.org", emailBytes.toStringUtf8());
    assertEquals(26, actualToProtoResult.getSerializedSize());
    assertTrue(actualToProtoResult.hasEmail());
  }

  /**
   * Test {@link ProtoUtils#toProto(Tenant)} with {@code Tenant}.
   * <ul>
   *   <li>Given {@code MD}.</li>
   *   <li>When {@link Tenant#Tenant()} State is {@code MD}.</li>
   *   <li>Then return State is {@code MD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; given 'MD'; when Tenant() State is 'MD'; then return State is 'MD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProto ProtoUtils.toProto(Tenant)"})
  void testToProtoWithTenant_givenMd_whenTenantStateIsMd_thenReturnStateIsMd() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setState("MD");
    tenant.setTitle("Dr");

    // Act
    TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals("MD", actualToProtoResult.getState());
    ByteString stateBytes = actualToProtoResult.getStateBytes();
    assertFalse(stateBytes.isEmpty());
    ByteIterator iteratorResult = stateBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('M', nextResult.byteValue());
    assertEquals('D', nextResult2.byteValue());
    assertEquals("MD", stateBytes.toStringUtf8());
    assertTrue(actualToProtoResult.hasState());
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
   * Test {@link ProtoUtils#toProto(Tenant)} with {@code Tenant}.
   * <ul>
   *   <li>Given {@code Oxford}.</li>
   *   <li>When {@link Tenant#Tenant()} City is {@code Oxford}.</li>
   *   <li>Then return City is {@code Oxford}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; given 'Oxford'; when Tenant() City is 'Oxford'; then return City is 'Oxford'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProto ProtoUtils.toProto(Tenant)"})
  void testToProtoWithTenant_givenOxford_whenTenantCityIsOxford_thenReturnCityIsOxford() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setCity("Oxford");
    tenant.setTitle("Dr");

    // Act
    TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals("Oxford", actualToProtoResult.getCity());
    ByteString cityBytes = actualToProtoResult.getCityBytes();
    assertFalse(cityBytes.isEmpty());
    ByteIterator iteratorResult = cityBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('O', iteratorResult.next().byteValue());
    assertEquals('x', iteratorResult.next().byteValue());
    assertEquals('f', iteratorResult.next().byteValue());
    assertEquals("Oxford", cityBytes.toStringUtf8());
    assertEquals(12, actualToProtoResult.getSerializedSize());
    assertTrue(actualToProtoResult.hasCity());
  }

  /**
   * Test {@link ProtoUtils#toProto(Tenant)} with {@code Tenant}.
   * <ul>
   *   <li>Given {@code us-east-2}.</li>
   *   <li>Then return Region is {@code us-east-2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; given 'us-east-2'; then return Region is 'us-east-2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProto ProtoUtils.toProto(Tenant)"})
  void testToProtoWithTenant_givenUsEast2_thenReturnRegionIsUsEast2() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setRegion("us-east-2");
    tenant.setTitle("Dr");

    // Act
    TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals("us-east-2", actualToProtoResult.getRegion());
    ByteString regionBytes = actualToProtoResult.getRegionBytes();
    assertFalse(regionBytes.isEmpty());
    ByteIterator iteratorResult = regionBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('s', iteratorResult.next().byteValue());
    assertEquals('-', iteratorResult.next().byteValue());
    assertEquals("us-east-2", regionBytes.toStringUtf8());
    assertEquals(15, actualToProtoResult.getSerializedSize());
    assertTrue(actualToProtoResult.hasRegion());
  }

  /**
   * Test {@link ProtoUtils#toProto(Tenant)} with {@code Tenant}.
   * <ul>
   *   <li>Then return TenantIdLSB is {@code -7476899250389416711}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; then return TenantIdLSB is '-7476899250389416711'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProto ProtoUtils.toProto(Tenant)"})
  void testToProtoWithTenant_thenReturnTenantIdLSBIs7476899250389416711() {
    // Arrange
    Tenant tenant = new Tenant(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenant.setTitle("Dr");

    // Act
    TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals(-7476899250389416711L, actualToProtoResult.getTenantIdLSB());
    assertEquals(25, actualToProtoResult.getSerializedSize());
    assertEquals(3, actualToProtoResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualToProtoResult.getTenantIdMSB());
  }

  /**
   * Test {@link ProtoUtils#toProto(Tenant)} with {@code Tenant}.
   * <ul>
   *   <li>When {@link Tenant#Tenant()} Address2 is {@code 42 Main St}.</li>
   *   <li>Then return Address2 is {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; when Tenant() Address2 is '42 Main St'; then return Address2 is '42 Main St'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProto ProtoUtils.toProto(Tenant)"})
  void testToProtoWithTenant_whenTenantAddress2Is42MainSt_thenReturnAddress2Is42MainSt() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setAddress2("42 Main St");
    tenant.setTitle("Dr");

    // Act
    TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals("42 Main St", actualToProtoResult.getAddress2());
    ByteString address2Bytes = actualToProtoResult.getAddress2Bytes();
    assertFalse(address2Bytes.isEmpty());
    ByteIterator iteratorResult = address2Bytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('4', iteratorResult.next().byteValue());
    assertEquals('2', iteratorResult.next().byteValue());
    assertEquals(' ', iteratorResult.next().byteValue());
    assertEquals("42 Main St", address2Bytes.toStringUtf8());
    assertTrue(actualToProtoResult.hasAddress2());
  }

  /**
   * Test {@link ProtoUtils#toProto(Tenant)} with {@code Tenant}.
   * <ul>
   *   <li>When {@link Tenant#Tenant()} Address is {@code 42 Main St}.</li>
   *   <li>Then return Address is {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; when Tenant() Address is '42 Main St'; then return Address is '42 Main St'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProto ProtoUtils.toProto(Tenant)"})
  void testToProtoWithTenant_whenTenantAddressIs42MainSt_thenReturnAddressIs42MainSt() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setAddress("42 Main St");
    tenant.setTitle("Dr");

    // Act
    TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals("42 Main St", actualToProtoResult.getAddress());
    ByteString addressBytes = actualToProtoResult.getAddressBytes();
    assertFalse(addressBytes.isEmpty());
    ByteIterator iteratorResult = addressBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('4', iteratorResult.next().byteValue());
    assertEquals('2', iteratorResult.next().byteValue());
    assertEquals(' ', iteratorResult.next().byteValue());
    assertEquals("42 Main St", addressBytes.toStringUtf8());
    assertTrue(actualToProtoResult.hasAddress());
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
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ToDeviceActorNotificationMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ToDeviceRpcRequestActorMsg("42", new ToDeviceRpcRequest(id, tenantId, deviceId, true, 1L,
            new ToDeviceRpcRequestBody("Method", "Params"), true, 1, "Additional Info")));

    // Assert
    assertEquals(93, actualToProtoResult.getSerializedSize());
    assertFalse(actualToProtoResult.hasDeviceAttributesEventMsg());
    assertTrue(actualToProtoResult.hasToDeviceRpcRequestMsg());
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
  void testToProtoWithToDeviceActorNotificationMsg2() {
    // Arrange
    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    List<AttributeValueProto> valuesList = ProtoUtils
        .toProto(new DeviceAttributesEventNotificationMsg(tenantId,
            new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, null, values, true))
        .getDeviceAttributesEventMsg()
        .getValuesList();
    assertEquals(1, valuesList.size());
    AttributeValueProto getResult = valuesList.get(0);
    assertEquals(0L, getResult.getVersion());
    assertEquals(15, getResult.getSerializedSize());
    assertEquals(4, getResult.getTypeValue());
    assertEquals(KeyValueType.JSON_V, getResult.getType());
    assertFalse(getResult.hasVersion());
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
  void testToProtoWithToDeviceActorNotificationMsg3() {
    // Arrange
    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    values.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ToDeviceActorNotificationMsgProto actualToProtoResult = ProtoUtils.toProto(new DeviceAttributesEventNotificationMsg(
        tenantId, new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, null, values, true));

    // Assert
    DeviceAttributesEventMsgProto deviceAttributesEventMsg = actualToProtoResult.getDeviceAttributesEventMsg();
    List<AttributeValueProto> valuesList = deviceAttributesEventMsg.getValuesList();
    assertEquals(2, valuesList.size());
    assertEquals(2, deviceAttributesEventMsg.getValuesCount());
    assertEquals(78, deviceAttributesEventMsg.getSerializedSize());
    assertEquals(80, actualToProtoResult.getSerializedSize());
    assertEquals(valuesList.get(0), valuesList.get(1));
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
  void testToProtoWithToDeviceActorNotificationMsg4() {
    // Arrange
    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", null)));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ToDeviceActorNotificationMsgProto actualToProtoResult = ProtoUtils.toProto(new DeviceAttributesEventNotificationMsg(
        tenantId, new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, null, values, true));

    // Assert
    DeviceAttributesEventMsgProto deviceAttributesEventMsg = actualToProtoResult.getDeviceAttributesEventMsg();
    List<AttributeValueProto> valuesList = deviceAttributesEventMsg.getValuesList();
    assertEquals(1, valuesList.size());
    assertEquals(55, deviceAttributesEventMsg.getSerializedSize());
    assertEquals(57, actualToProtoResult.getSerializedSize());
    AttributeValueProto getResult = valuesList.get(0);
    assertEquals(9, getResult.getSerializedSize());
    assertFalse(getResult.getHasV());
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
  void testToProtoWithToDeviceActorNotificationMsg5() {
    // Arrange
    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"))));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    List<AttributeValueProto> valuesList = ProtoUtils
        .toProto(new DeviceAttributesEventNotificationMsg(tenantId,
            new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, null, values, true))
        .getDeviceAttributesEventMsg()
        .getValuesList();
    assertEquals(1, valuesList.size());
    AttributeValueProto getResult = valuesList.get(0);
    assertEquals(0L, getResult.getVersion());
    assertEquals(15, getResult.getSerializedSize());
    assertEquals(4, getResult.getTypeValue());
    assertEquals(KeyValueType.JSON_V, getResult.getType());
    assertFalse(getResult.hasVersion());
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
  void testToProtoWithToDeviceActorNotificationMsg6() {
    // Arrange
    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(new BaseAttributeKvEntry(1L, new StringDataEntry("Key", "42")));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ToDeviceActorNotificationMsgProto actualToProtoResult = ProtoUtils.toProto(new DeviceAttributesEventNotificationMsg(
        tenantId, new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, null, values, true));

    // Assert
    DeviceAttributesEventMsgProto deviceAttributesEventMsg = actualToProtoResult.getDeviceAttributesEventMsg();
    List<AttributeValueProto> valuesList = deviceAttributesEventMsg.getValuesList();
    assertEquals(1, valuesList.size());
    AttributeValueProto getResult = valuesList.get(0);
    assertEquals("42", getResult.getStringV());
    assertEquals(3, getResult.getTypeValue());
    assertEquals(61, deviceAttributesEventMsg.getSerializedSize());
    assertEquals(63, actualToProtoResult.getSerializedSize());
    assertEquals(KeyValueType.STRING_V, getResult.getType());
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
  void testToProtoWithToDeviceActorNotificationMsg7() {
    // Arrange
    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(new BaseAttributeKvEntry(new JsonDataEntry("Key", "42"), 1L, 1L));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ToDeviceActorNotificationMsgProto actualToProtoResult = ProtoUtils.toProto(new DeviceAttributesEventNotificationMsg(
        tenantId, new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, null, values, true));

    // Assert
    DeviceAttributesEventMsgProto deviceAttributesEventMsg = actualToProtoResult.getDeviceAttributesEventMsg();
    List<AttributeValueProto> valuesList = deviceAttributesEventMsg.getValuesList();
    assertEquals(1, valuesList.size());
    AttributeValueProto getResult = valuesList.get(0);
    assertEquals("42", getResult.getJsonV());
    assertEquals(17, getResult.getSerializedSize());
    assertEquals(63, deviceAttributesEventMsg.getSerializedSize());
    assertEquals(65, actualToProtoResult.getSerializedSize());
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
  void testToProtoWithToDeviceActorNotificationMsg8() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    Optional<Boolean> ofResult = Optional.of(true);
    when(attributeKvEntry.getBooleanValue()).thenReturn(ofResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.BOOLEAN);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(attributeKvEntry);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ToDeviceActorNotificationMsgProto actualToProtoResult = ProtoUtils.toProto(new DeviceAttributesEventNotificationMsg(
        tenantId, new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, null, values, true));

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry, atLeast(1)).getBooleanValue();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    DeviceAttributesEventMsgProto deviceAttributesEventMsg = actualToProtoResult.getDeviceAttributesEventMsg();
    List<AttributeValueProto> valuesList = deviceAttributesEventMsg.getValuesList();
    assertEquals(1, valuesList.size());
    AttributeValueProto getResult = valuesList.get(0);
    assertEquals(13, getResult.getSerializedSize());
    assertEquals(59, deviceAttributesEventMsg.getSerializedSize());
    assertEquals(61, actualToProtoResult.getSerializedSize());
    assertTrue(getResult.getBoolV());
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
  void testToProtoWithToDeviceActorNotificationMsg9() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    Optional<Boolean> emptyResult = Optional.empty();
    when(attributeKvEntry.getBooleanValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.BOOLEAN);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(attributeKvEntry);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ToDeviceActorNotificationMsgProto actualToProtoResult = ProtoUtils.toProto(new DeviceAttributesEventNotificationMsg(
        tenantId, new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, null, values, true));

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry, atLeast(1)).getBooleanValue();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    DeviceAttributesEventMsgProto deviceAttributesEventMsg = actualToProtoResult.getDeviceAttributesEventMsg();
    List<AttributeValueProto> valuesList = deviceAttributesEventMsg.getValuesList();
    assertEquals(1, valuesList.size());
    AttributeValueProto getResult = valuesList.get(0);
    assertEquals(0, getResult.getTypeValue());
    assertEquals(55, deviceAttributesEventMsg.getSerializedSize());
    assertEquals(57, actualToProtoResult.getSerializedSize());
    assertEquals(9, getResult.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, getResult.getType());
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
  void testToProtoWithToDeviceActorNotificationMsg10() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(attributeKvEntry.getLongValue()).thenReturn(ofResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.LONG);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(attributeKvEntry);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ToDeviceActorNotificationMsgProto actualToProtoResult = ProtoUtils.toProto(new DeviceAttributesEventNotificationMsg(
        tenantId, new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, null, values, true));

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry, atLeast(1)).getLongValue();
    DeviceAttributesEventMsgProto deviceAttributesEventMsg = actualToProtoResult.getDeviceAttributesEventMsg();
    List<AttributeValueProto> valuesList = deviceAttributesEventMsg.getValuesList();
    assertEquals(1, valuesList.size());
    AttributeValueProto getResult = valuesList.get(0);
    assertEquals(1, getResult.getTypeValue());
    assertEquals(1L, getResult.getLongV());
    assertEquals(61, deviceAttributesEventMsg.getSerializedSize());
    assertEquals(63, actualToProtoResult.getSerializedSize());
    assertEquals(KeyValueType.LONG_V, getResult.getType());
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
  void testToProtoWithToDeviceActorNotificationMsg11() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Long> emptyResult = Optional.empty();
    when(attributeKvEntry.getLongValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.LONG);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(attributeKvEntry);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ToDeviceActorNotificationMsgProto actualToProtoResult = ProtoUtils.toProto(new DeviceAttributesEventNotificationMsg(
        tenantId, new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, null, values, true));

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry, atLeast(1)).getLongValue();
    DeviceAttributesEventMsgProto deviceAttributesEventMsg = actualToProtoResult.getDeviceAttributesEventMsg();
    List<AttributeValueProto> valuesList = deviceAttributesEventMsg.getValuesList();
    assertEquals(1, valuesList.size());
    AttributeValueProto getResult = valuesList.get(0);
    assertEquals(1, getResult.getTypeValue());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(57, deviceAttributesEventMsg.getSerializedSize());
    assertEquals(59, actualToProtoResult.getSerializedSize());
    assertEquals(KeyValueType.LONG_V, getResult.getType());
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
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ToEdgeSyncRequestMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ToEdgeSyncRequest(id, tenantId, new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "42"));

    // Assert
    assertEquals("", actualToProtoResult.getInitializationErrorString());
    assertEquals("42", actualToProtoResult.getServiceId());
    assertEquals(-7476899250389416711L, actualToProtoResult.getEdgeIdLSB());
    assertEquals(-7476899250389416711L, actualToProtoResult.getRequestIdLSB());
    assertEquals(-7476899250389416711L, actualToProtoResult.getTenantIdLSB());
    assertEquals(67, actualToProtoResult.getSerializedSize());
    assertEquals(7, actualToProtoResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualToProtoResult.getEdgeIdMSB());
    assertEquals(8669210807411032922L, actualToProtoResult.getRequestIdMSB());
    assertEquals(8669210807411032922L, actualToProtoResult.getTenantIdMSB());
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
   * Method under test: {@link ProtoUtils#fromProto(TransportProtos.DeviceProto)}
   */
  @Test
  @DisplayName("Test fromProto(DeviceProto) with 'DeviceProto'; when DefaultInstance; then return Name is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Device ProtoUtils.fromProto(TransportProtos.DeviceProto)"})
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
   * Method under test: {@link ProtoUtils#fromProto(TransportProtos.EntityTypeProto)}
   */
  @Test
  @DisplayName("Test fromProto(EntityTypeProto) with 'EntityTypeProto'; when 'UNSPECIFIED'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType ProtoUtils.fromProto(TransportProtos.EntityTypeProto)"})
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
