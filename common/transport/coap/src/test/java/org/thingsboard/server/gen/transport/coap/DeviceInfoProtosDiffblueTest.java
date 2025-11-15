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
package org.thingsboard.server.gen.transport.coap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.coap.ConfigProtos.ProtoConfig;
import org.thingsboard.server.gen.transport.coap.DeviceInfoProtos.ModemType;
import org.thingsboard.server.gen.transport.coap.DeviceInfoProtos.ProtoDeviceInfo;
import org.thingsboard.server.gen.transport.coap.DeviceInfoProtos.ProtoModem;
import org.thingsboard.server.gen.transport.coap.DeviceInfoProtos.ProtoRuntime;
import org.thingsboard.server.gen.transport.coap.DeviceInfoProtos.ProtoUpdateInfo;

class DeviceInfoProtosDiffblueTest {
  /**
   * Test ModemType {@link ModemType#forNumber(int)}.
   * <ul>
   *   <li>When {@link ProtoConfig#DNS_SERVER_IP_FIELD_NUMBER}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#forNumber(int)}
   */
  @Test
  @DisplayName("Test ModemType forNumber(int); when DNS_SERVER_IP_FIELD_NUMBER; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModemType ModemType.forNumber(int)"})
  void testModemTypeForNumber_whenDns_server_ip_field_number_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ModemType.forNumber(ProtoConfig.DNS_SERVER_IP_FIELD_NUMBER));
  }

  /**
   * Test ModemType {@link ModemType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code MODEM_TYPE_BC66}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#forNumber(int)}
   */
  @Test
  @DisplayName("Test ModemType forNumber(int); when one; then return 'MODEM_TYPE_BC66'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModemType ModemType.forNumber(int)"})
  void testModemTypeForNumber_whenOne_thenReturnModemTypeBc66() {
    // Arrange, Act and Assert
    assertEquals(ModemType.MODEM_TYPE_BC66, ModemType.forNumber(1));
  }

  /**
   * Test ModemType {@link ModemType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code MODEM_TYPE_BC66NA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#forNumber(int)}
   */
  @Test
  @DisplayName("Test ModemType forNumber(int); when two; then return 'MODEM_TYPE_BC66NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModemType ModemType.forNumber(int)"})
  void testModemTypeForNumber_whenTwo_thenReturnModemTypeBc66na() {
    // Arrange, Act and Assert
    assertEquals(ModemType.MODEM_TYPE_BC66NA, ModemType.forNumber(2));
  }

  /**
   * Test ModemType {@link ModemType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code MODEM_TYPE_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#forNumber(int)}
   */
  @Test
  @DisplayName("Test ModemType forNumber(int); when zero; then return 'MODEM_TYPE_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModemType ModemType.forNumber(int)"})
  void testModemTypeForNumber_whenZero_thenReturnModemTypeUnspecified() {
    // Arrange, Act and Assert
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, ModemType.forNumber(0));
  }

  /**
   * Test ModemType {@link ModemType#getDescriptor()}.
   * <p>
   * Method under test: {@link ModemType#getDescriptor()}
   */
  @Test
  @DisplayName("Test ModemType getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor ModemType.getDescriptor()"})
  void testModemTypeGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = ModemType.getDescriptor();

    // Assert
    assertEquals("ModemType", actualDescriptor.getFullName());
    assertEquals("ModemType", actualDescriptor.getName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }

  /**
   * Test ModemType {@link ModemType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link ModemType#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test ModemType getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor ModemType.getDescriptorForType()"})
  void testModemTypeGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = ModemType.MODEM_TYPE_UNSPECIFIED.getDescriptorForType();

    // Assert
    assertEquals("ModemType", actualDescriptorForType.getFullName());
    assertEquals("ModemType", actualDescriptorForType.getName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(3, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test ModemType {@link ModemType#getNumber()}.
   * <ul>
   *   <li>Given {@code MODEM_TYPE_UNSPECIFIED}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#getNumber()}
   */
  @Test
  @DisplayName("Test ModemType getNumber(); given 'MODEM_TYPE_UNSPECIFIED'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModemType.getNumber()"})
  void testModemTypeGetNumber_givenModemTypeUnspecified_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ModemType.MODEM_TYPE_UNSPECIFIED.getNumber());
  }

  /**
   * Test ModemType {@link ModemType#getNumber()}.
   * <ul>
   *   <li>Given {@link ModemType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#getNumber()}
   */
  @Test
  @DisplayName("Test ModemType getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModemType.getNumber()"})
  void testModemTypeGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ModemType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test ModemType {@link ModemType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link ModemType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test ModemType getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ModemType.getValueDescriptor()"})
  void testModemTypeGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ModemType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test ModemType {@link ModemType#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code MODEM_TYPE_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test ModemType getValueDescriptor(); then return Name is 'MODEM_TYPE_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ModemType.getValueDescriptor()"})
  void testModemTypeGetValueDescriptor_thenReturnNameIsModemTypeUnspecified() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = ModemType.MODEM_TYPE_UNSPECIFIED.getValueDescriptor();

    // Assert
    assertEquals("MODEM_TYPE_UNSPECIFIED", actualValueDescriptor.getName());
    assertEquals("ModemType.MODEM_TYPE_UNSPECIFIED", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test ModemType {@link ModemType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ModemType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test ModemType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ModemType.internalGetValueMap()"})
  void testModemTypeInternalGetValueMap() {
    // Arrange and Act
    EnumLiteMap<ModemType> actualInternalGetValueMapResult = ModemType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER));
  }

  /**
   * Test ModemType {@link ModemType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ModemType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test ModemType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ModemType.internalGetValueMap()"})
  void testModemTypeInternalGetValueMap2() {
    // Arrange and Act
    EnumLiteMap<ModemType> actualInternalGetValueMapResult = ModemType.internalGetValueMap();

    // Assert
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test ModemType {@link ModemType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code MODEM_TYPE_BC66}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test ModemType internalGetValueMap(); then return findValueByNumber one is 'MODEM_TYPE_BC66'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ModemType.internalGetValueMap()"})
  void testModemTypeInternalGetValueMap_thenReturnFindValueByNumberOneIsModemTypeBc66() {
    // Arrange and Act
    EnumLiteMap<ModemType> actualInternalGetValueMapResult = ModemType.internalGetValueMap();

    // Assert
    assertEquals(ModemType.MODEM_TYPE_BC66, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test ModemType {@link ModemType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code MODEM_TYPE_BC66NA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test ModemType internalGetValueMap(); then return findValueByNumber two is 'MODEM_TYPE_BC66NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ModemType.internalGetValueMap()"})
  void testModemTypeInternalGetValueMap_thenReturnFindValueByNumberTwoIsModemTypeBc66na() {
    // Arrange and Act
    EnumLiteMap<ModemType> actualInternalGetValueMapResult = ModemType.internalGetValueMap();

    // Assert
    assertEquals(ModemType.MODEM_TYPE_BC66NA, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test ModemType {@link ModemType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When {@link ProtoConfig#DNS_SERVER_IP_FIELD_NUMBER}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#valueOf(int)}
   */
  @Test
  @DisplayName("Test ModemType valueOf(int) with 'value'; when DNS_SERVER_IP_FIELD_NUMBER; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModemType ModemType.valueOf(int)"})
  void testModemTypeValueOfWithValue_whenDns_server_ip_field_number_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ModemType.valueOf(ProtoConfig.DNS_SERVER_IP_FIELD_NUMBER));
  }

  /**
   * Test ModemType {@link ModemType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code MODEM_TYPE_BC66}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#valueOf(int)}
   */
  @Test
  @DisplayName("Test ModemType valueOf(int) with 'value'; when one; then return 'MODEM_TYPE_BC66'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModemType ModemType.valueOf(int)"})
  void testModemTypeValueOfWithValue_whenOne_thenReturnModemTypeBc66() {
    // Arrange, Act and Assert
    assertEquals(ModemType.MODEM_TYPE_BC66, ModemType.valueOf(1));
  }

  /**
   * Test ModemType {@link ModemType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code MODEM_TYPE_BC66NA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#valueOf(int)}
   */
  @Test
  @DisplayName("Test ModemType valueOf(int) with 'value'; when two; then return 'MODEM_TYPE_BC66NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModemType ModemType.valueOf(int)"})
  void testModemTypeValueOfWithValue_whenTwo_thenReturnModemTypeBc66na() {
    // Arrange, Act and Assert
    assertEquals(ModemType.MODEM_TYPE_BC66NA, ModemType.valueOf(2));
  }

  /**
   * Test ModemType {@link ModemType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code MODEM_TYPE_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModemType#valueOf(int)}
   */
  @Test
  @DisplayName("Test ModemType valueOf(int) with 'value'; when zero; then return 'MODEM_TYPE_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModemType ModemType.valueOf(int)"})
  void testModemTypeValueOfWithValue_whenZero_thenReturnModemTypeUnspecified() {
    // Arrange, Act and Assert
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, ModemType.valueOf(0));
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#equals(Object)}, and {@link ProtoDeviceInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoDeviceInfo#equals(Object)}
   *   <li>{@link ProtoDeviceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoDeviceInfo.equals(Object)", "int ProtoDeviceInfo.hashCode()"})
  void testProtoDeviceInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoDeviceInfo defaultInstance = ProtoDeviceInfo.getDefaultInstance();
    ProtoDeviceInfo defaultInstance2 = ProtoDeviceInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#equals(Object)}, and {@link ProtoDeviceInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoDeviceInfo#equals(Object)}
   *   <li>{@link ProtoDeviceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoDeviceInfo.equals(Object)", "int ProtoDeviceInfo.hashCode()"})
  void testProtoDeviceInfoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProtoDeviceInfo defaultInstance = ProtoDeviceInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoDeviceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoDeviceInfo.equals(Object)", "int ProtoDeviceInfo.hashCode()"})
  void testProtoDeviceInfoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoDeviceInfo.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoDeviceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoDeviceInfo.equals(Object)", "int ProtoDeviceInfo.hashCode()"})
  void testProtoDeviceInfoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoDeviceInfo.getDefaultInstance(), null);
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoDeviceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoDeviceInfo.equals(Object)", "int ProtoDeviceInfo.hashCode()"})
  void testProtoDeviceInfoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoDeviceInfo.getDefaultInstance(), "Different type to ProtoDeviceInfo");
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#getCloudToken()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#getCloudToken()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo getCloudToken()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoDeviceInfo.getCloudToken()"})
  void testProtoDeviceInfoGetCloudToken() {
    // Arrange, Act and Assert
    assertEquals("", ProtoDeviceInfo.getDefaultInstance().getCloudToken());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#getCloudTokenBytes()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#getCloudTokenBytes()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo getCloudTokenBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoDeviceInfo.getCloudTokenBytes()"})
  void testProtoDeviceInfoGetCloudTokenBytes() {
    // Arrange
    ProtoDeviceInfo defaultInstance = ProtoDeviceInfo.getDefaultInstance();

    // Act
    ByteString actualCloudTokenBytes = defaultInstance.getCloudTokenBytes();

    // Assert
    ByteString byteString = actualCloudTokenBytes.EMPTY;
    assertEquals(byteString, actualCloudTokenBytes);
    assertEquals(byteString, defaultInstance.getCommitIdBytes());
    assertSame(byteString, defaultInstance.getSerialNum());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#getCommitId()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#getCommitId()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo getCommitId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoDeviceInfo.getCommitId()"})
  void testProtoDeviceInfoGetCommitId() {
    // Arrange, Act and Assert
    assertEquals("", ProtoDeviceInfo.getDefaultInstance().getCommitId());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#getCommitIdBytes()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#getCommitIdBytes()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo getCommitIdBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoDeviceInfo.getCommitIdBytes()"})
  void testProtoDeviceInfoGetCommitIdBytes() {
    // Arrange
    ProtoDeviceInfo defaultInstance = ProtoDeviceInfo.getDefaultInstance();

    // Act
    ByteString actualCommitIdBytes = defaultInstance.getCommitIdBytes();

    // Assert
    ByteString byteString = actualCommitIdBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getCloudTokenBytes());
    assertEquals(byteString, actualCommitIdBytes);
    assertSame(byteString, defaultInstance.getSerialNum());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.getDefaultInstanceForType()"})
  void testProtoDeviceInfoGetDefaultInstanceForType() {
    // Arrange
    ProtoDeviceInfo defaultInstance = ProtoDeviceInfo.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#getLastUpdateInfo()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#getLastUpdateInfo()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo getLastUpdateInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoDeviceInfo.getLastUpdateInfo()"})
  void testProtoDeviceInfoGetLastUpdateInfo() {
    // Arrange and Act
    ProtoUpdateInfo actualLastUpdateInfo = ProtoDeviceInfo.getDefaultInstance().getLastUpdateInfo();

    // Assert
    assertEquals("", actualLastUpdateInfo.getInitializationErrorString());
    assertEquals(0, actualLastUpdateInfo.getSerializedSize());
    assertEquals(0, actualLastUpdateInfo.getStatus());
    assertEquals(0, actualLastUpdateInfo.getTimestamp());
    assertTrue(actualLastUpdateInfo.findInitializationErrors().isEmpty());
    assertTrue(actualLastUpdateInfo.getAllFields().isEmpty());
    assertTrue(actualLastUpdateInfo.isInitialized());
    assertSame(actualLastUpdateInfo, actualLastUpdateInfo.getDefaultInstanceForType());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#getMemoryStatisticsCount()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#getMemoryStatisticsCount()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo getMemoryStatisticsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoDeviceInfo.getMemoryStatisticsCount()"})
  void testProtoDeviceInfoGetMemoryStatisticsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoDeviceInfo.getDefaultInstance().getMemoryStatisticsCount());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#getModem()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#getModem()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo getModem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoDeviceInfo.getModem()"})
  void testProtoDeviceInfoGetModem() {
    // Arrange and Act
    ProtoModem actualModem = ProtoDeviceInfo.getDefaultInstance().getModem();

    // Assert
    assertEquals("", actualModem.getInitializationErrorString());
    assertEquals("", actualModem.getSimCardIdentification());
    assertEquals(0, actualModem.getParametersCount());
    assertEquals(0, actualModem.getSerializedSize());
    assertEquals(0, actualModem.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualModem.getType());
    assertTrue(actualModem.findInitializationErrors().isEmpty());
    assertTrue(actualModem.getParametersList().isEmpty());
    assertTrue(actualModem.getAllFields().isEmpty());
    assertTrue(actualModem.isInitialized());
    assertSame(actualModem, actualModem.getDefaultInstanceForType());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#getRuntimeInfo()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#getRuntimeInfo()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo getRuntimeInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoDeviceInfo.getRuntimeInfo()"})
  void testProtoDeviceInfoGetRuntimeInfo() {
    // Arrange and Act
    ProtoRuntime actualRuntimeInfo = ProtoDeviceInfo.getDefaultInstance().getRuntimeInfo();

    // Assert
    assertEquals("", actualRuntimeInfo.getInitializationErrorString());
    assertEquals(0, actualRuntimeInfo.getBatteryResetTimestamp());
    assertEquals(0, actualRuntimeInfo.getMaxMcuTemperature());
    assertEquals(0, actualRuntimeInfo.getMcuTemperature());
    assertEquals(0, actualRuntimeInfo.getMessageCountersCount());
    assertEquals(0, actualRuntimeInfo.getMinBatteryMcuTemperature());
    assertEquals(0, actualRuntimeInfo.getMinBatteryVoltage());
    assertEquals(0, actualRuntimeInfo.getMinMcuTemperature());
    assertEquals(0, actualRuntimeInfo.getRuntimeErrorsCount());
    assertEquals(0, actualRuntimeInfo.getSerializedSize());
    assertEquals(0, actualRuntimeInfo.getUpTime());
    assertTrue(actualRuntimeInfo.findInitializationErrors().isEmpty());
    List<Integer> messageCountersList = actualRuntimeInfo.getMessageCountersList();
    assertTrue(messageCountersList.isEmpty());
    assertTrue(actualRuntimeInfo.getAllFields().isEmpty());
    assertTrue(actualRuntimeInfo.isInitialized());
    assertSame(actualRuntimeInfo, actualRuntimeInfo.getDefaultInstanceForType());
    assertSame(messageCountersList, actualRuntimeInfo.getRuntimeErrorsList());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#getSerializedSize()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoDeviceInfo.getSerializedSize()"})
  void testProtoDeviceInfoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoDeviceInfo.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#hasLastUpdateInfo()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#hasLastUpdateInfo()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo hasLastUpdateInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoDeviceInfo.hasLastUpdateInfo()"})
  void testProtoDeviceInfoHasLastUpdateInfo() {
    // Arrange, Act and Assert
    assertFalse(ProtoDeviceInfo.getDefaultInstance().hasLastUpdateInfo());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#hasModem()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#hasModem()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo hasModem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoDeviceInfo.hasModem()"})
  void testProtoDeviceInfoHasModem() {
    // Arrange, Act and Assert
    assertFalse(ProtoDeviceInfo.getDefaultInstance().hasModem());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#hasRuntimeInfo()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#hasRuntimeInfo()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo hasRuntimeInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoDeviceInfo.hasRuntimeInfo()"})
  void testProtoDeviceInfoHasRuntimeInfo() {
    // Arrange, Act and Assert
    assertFalse(ProtoDeviceInfo.getDefaultInstance().hasRuntimeInfo());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#isInitialized()}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoDeviceInfo.isInitialized()"})
  void testProtoDeviceInfoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProtoDeviceInfo.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseDelimitedFrom(InputStream)"})
  void testProtoDeviceInfoParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoDeviceInfo.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoDeviceInfoParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        ProtoDeviceInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoDeviceInfoParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoDeviceInfo actualParseDelimitedFromResult = ProtoDeviceInfo.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoDeviceInfoParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoDeviceInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoDeviceInfoParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoDeviceInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoDeviceInfoParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ProtoDeviceInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoDeviceInfoParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoDeviceInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseDelimitedFrom(InputStream)"})
  void testProtoDeviceInfoParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoDeviceInfo.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseDelimitedFrom(InputStream)"})
  void testProtoDeviceInfoParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, ProtoDeviceInfo.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseDelimitedFrom(InputStream)"})
  void testProtoDeviceInfoParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoDeviceInfo actualParseDelimitedFromResult = ProtoDeviceInfo.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseDelimitedFrom(InputStream)"})
  void testProtoDeviceInfoParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoDeviceInfo.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseDelimitedFrom(InputStream)"})
  void testProtoDeviceInfoParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ProtoDeviceInfo.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(byte[])"})
  void testProtoDeviceInfoParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoDeviceInfo actualParseFromResult = ProtoDeviceInfo.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getCommitId());
    assertEquals(0, actualParseFromResult.getMemoryStatisticsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSwVersion());
    assertFalse(actualParseFromResult.hasLastUpdateInfo());
    assertFalse(actualParseFromResult.hasModem());
    assertFalse(actualParseFromResult.hasRuntimeInfo());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getMemoryStatisticsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(ByteBuffer)"})
  void testProtoDeviceInfoParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoDeviceInfo actualParseFromResult = ProtoDeviceInfo.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getCommitId());
    assertEquals(0, actualParseFromResult.getMemoryStatisticsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSwVersion());
    assertFalse(actualParseFromResult.hasLastUpdateInfo());
    assertFalse(actualParseFromResult.hasModem());
    assertFalse(actualParseFromResult.hasRuntimeInfo());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getMemoryStatisticsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testProtoDeviceInfoParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ProtoDeviceInfo actualParseFromResult = ProtoDeviceInfo.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getCommitId());
    assertEquals(0, actualParseFromResult.getMemoryStatisticsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSwVersion());
    assertFalse(actualParseFromResult.hasLastUpdateInfo());
    assertFalse(actualParseFromResult.hasModem());
    assertFalse(actualParseFromResult.hasRuntimeInfo());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getMemoryStatisticsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoDeviceInfoParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoDeviceInfo actualParseFromResult = ProtoDeviceInfo.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getCommitId());
    assertEquals(0, actualParseFromResult.getMemoryStatisticsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSwVersion());
    assertFalse(actualParseFromResult.hasLastUpdateInfo());
    assertFalse(actualParseFromResult.hasModem());
    assertFalse(actualParseFromResult.hasRuntimeInfo());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getMemoryStatisticsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(ByteString)"})
  void testProtoDeviceInfoParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoDeviceInfo actualParseFromResult = ProtoDeviceInfo.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getCommitId());
    assertEquals(0, actualParseFromResult.getMemoryStatisticsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSwVersion());
    assertFalse(actualParseFromResult.hasLastUpdateInfo());
    assertFalse(actualParseFromResult.hasModem());
    assertFalse(actualParseFromResult.hasRuntimeInfo());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getMemoryStatisticsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getCloudTokenBytes());
    assertEquals(byteString, actualParseFromResult.getCommitIdBytes());
    assertSame(byteString, actualParseFromResult.getSerialNum());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoDeviceInfoParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoDeviceInfo actualParseFromResult = ProtoDeviceInfo.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getCommitId());
    assertEquals(0, actualParseFromResult.getMemoryStatisticsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSwVersion());
    assertFalse(actualParseFromResult.hasLastUpdateInfo());
    assertFalse(actualParseFromResult.hasModem());
    assertFalse(actualParseFromResult.hasRuntimeInfo());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getMemoryStatisticsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getCloudTokenBytes());
    assertEquals(byteString, actualParseFromResult.getCommitIdBytes());
    assertSame(byteString, actualParseFromResult.getSerialNum());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(CodedInputStream)"})
  void testProtoDeviceInfoParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoDeviceInfo actualParseFromResult = ProtoDeviceInfo.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getCommitId());
    assertEquals(0, actualParseFromResult.getMemoryStatisticsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSwVersion());
    assertFalse(actualParseFromResult.hasLastUpdateInfo());
    assertFalse(actualParseFromResult.hasModem());
    assertFalse(actualParseFromResult.hasRuntimeInfo());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getMemoryStatisticsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoDeviceInfoParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoDeviceInfo actualParseFromResult = ProtoDeviceInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getCommitId());
    assertEquals(0, actualParseFromResult.getMemoryStatisticsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSwVersion());
    assertFalse(actualParseFromResult.hasLastUpdateInfo());
    assertFalse(actualParseFromResult.hasModem());
    assertFalse(actualParseFromResult.hasRuntimeInfo());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getMemoryStatisticsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(InputStream)"})
  void testProtoDeviceInfoParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ProtoDeviceInfo actualParseFromResult = ProtoDeviceInfo.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(InputStream)"})
  void testProtoDeviceInfoParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoDeviceInfo.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoDeviceInfoParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ProtoDeviceInfo actualParseFromResult = ProtoDeviceInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getCommitId());
    assertEquals(0, actualParseFromResult.getMemoryStatisticsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSwVersion());
    assertFalse(actualParseFromResult.hasLastUpdateInfo());
    assertFalse(actualParseFromResult.hasModem());
    assertFalse(actualParseFromResult.hasRuntimeInfo());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getMemoryStatisticsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoDeviceInfoParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoDeviceInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoDeviceInfoParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoDeviceInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(InputStream)"})
  void testProtoDeviceInfoParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoDeviceInfo.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoDeviceInfo {@link ProtoDeviceInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoDeviceInfo#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoDeviceInfo parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoDeviceInfo ProtoDeviceInfo.parseFrom(InputStream)"})
  void testProtoDeviceInfoParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ProtoDeviceInfo actualParseFromResult = ProtoDeviceInfo.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoModem {@link ProtoModem#equals(Object)}, and {@link ProtoModem#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoModem#equals(Object)}
   *   <li>{@link ProtoModem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoModem equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoModem.equals(Object)", "int ProtoModem.hashCode()"})
  void testProtoModemEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoModem defaultInstance = ProtoModem.getDefaultInstance();
    ProtoModem defaultInstance2 = ProtoModem.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoModem {@link ProtoModem#equals(Object)}, and {@link ProtoModem#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoModem#equals(Object)}
   *   <li>{@link ProtoModem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoModem equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoModem.equals(Object)", "int ProtoModem.hashCode()"})
  void testProtoModemEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProtoModem defaultInstance = ProtoModem.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoModem {@link ProtoModem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoModem equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoModem.equals(Object)", "int ProtoModem.hashCode()"})
  void testProtoModemEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoModem.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoModem {@link ProtoModem#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoModem equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoModem.equals(Object)", "int ProtoModem.hashCode()"})
  void testProtoModemEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoModem.getDefaultInstance(), null);
  }

  /**
   * Test ProtoModem {@link ProtoModem#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoModem equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoModem.equals(Object)", "int ProtoModem.hashCode()"})
  void testProtoModemEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoModem.getDefaultInstance(), "Different type to ProtoModem");
  }

  /**
   * Test ProtoModem {@link ProtoModem#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ProtoModem#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoModem getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.getDefaultInstanceForType()"})
  void testProtoModemGetDefaultInstanceForType() {
    // Arrange
    ProtoModem defaultInstance = ProtoModem.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoModem {@link ProtoModem#getParametersCount()}.
   * <p>
   * Method under test: {@link ProtoModem#getParametersCount()}
   */
  @Test
  @DisplayName("Test ProtoModem getParametersCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoModem.getParametersCount()"})
  void testProtoModemGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoModem.getDefaultInstance().getParametersCount());
  }

  /**
   * Test ProtoModem {@link ProtoModem#getSerializedSize()}.
   * <p>
   * Method under test: {@link ProtoModem#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoModem getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoModem.getSerializedSize()"})
  void testProtoModemGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoModem.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoModem {@link ProtoModem#getSimCardIdentification()}.
   * <p>
   * Method under test: {@link ProtoModem#getSimCardIdentification()}
   */
  @Test
  @DisplayName("Test ProtoModem getSimCardIdentification()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoModem.getSimCardIdentification()"})
  void testProtoModemGetSimCardIdentification() {
    // Arrange, Act and Assert
    assertEquals("", ProtoModem.getDefaultInstance().getSimCardIdentification());
  }

  /**
   * Test ProtoModem {@link ProtoModem#getSimCardIdentificationBytes()}.
   * <p>
   * Method under test: {@link ProtoModem#getSimCardIdentificationBytes()}
   */
  @Test
  @DisplayName("Test ProtoModem getSimCardIdentificationBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoModem.getSimCardIdentificationBytes()"})
  void testProtoModemGetSimCardIdentificationBytes() {
    // Arrange
    ProtoModem defaultInstance = ProtoModem.getDefaultInstance();

    // Act
    ByteString actualSimCardIdentificationBytes = defaultInstance.getSimCardIdentificationBytes();

    // Assert
    ByteString byteString = actualSimCardIdentificationBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileDescriptor file = descriptorForType.getFile();
    assertEquals(byteString, file.toProto().getPackageBytes());
    FileOptions options = file.getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualSimCardIdentificationBytes);
  }

  /**
   * Test ProtoModem {@link ProtoModem#getType()}.
   * <p>
   * Method under test: {@link ProtoModem#getType()}
   */
  @Test
  @DisplayName("Test ProtoModem getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModemType ProtoModem.getType()"})
  void testProtoModemGetType() {
    // Arrange, Act and Assert
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, ProtoModem.getDefaultInstance().getType());
  }

  /**
   * Test ProtoModem {@link ProtoModem#isInitialized()}.
   * <p>
   * Method under test: {@link ProtoModem#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoModem isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoModem.isInitialized()"})
  void testProtoModemIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProtoModem.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoModem#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoModem parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseDelimitedFrom(InputStream)"})
  void testProtoModemParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoModem actualParseDelimitedFromResult = ProtoModem.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getSimCardIdentification());
    assertEquals(0, actualParseDelimitedFromResult.getParametersCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getTypeValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseDelimitedFromResult.getType());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getParametersList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoModem#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoModem parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseDelimitedFrom(InputStream)"})
  void testProtoModemParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoModem.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoModem#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoModemParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoModem actualParseDelimitedFromResult = ProtoModem.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getSimCardIdentification());
    assertEquals(0, actualParseDelimitedFromResult.getParametersCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getTypeValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseDelimitedFromResult.getType());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getParametersList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoModem#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoModemParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoModem.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoModem#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoModemParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ProtoModem.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoModemParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoModem.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoModemParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoModem.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoModem parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseDelimitedFrom(InputStream)"})
  void testProtoModemParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoModem.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoModem parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseDelimitedFrom(InputStream)"})
  void testProtoModemParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoModem.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoModem parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseDelimitedFrom(InputStream)"})
  void testProtoModemParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ProtoModem.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(ByteBuffer)"})
  void testProtoModemParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSimCardIdentification());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testProtoModemParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSimCardIdentification());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoModemParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSimCardIdentification());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoModemParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSimCardIdentification());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedSimCardIdentificationBytes = data.EMPTY;
    assertEquals(expectedSimCardIdentificationBytes, actualParseFromResult.getSimCardIdentificationBytes());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoModemParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSimCardIdentification());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedSimCardIdentificationBytes = data.EMPTY;
    assertEquals(expectedSimCardIdentificationBytes, actualParseFromResult.getSimCardIdentificationBytes());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(ByteString)"})
  void testProtoModemParseFromWithByteString_givenCodedInputStreamReadTagReturnFour() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSimCardIdentification());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedSimCardIdentificationBytes = data.EMPTY;
    assertEquals(expectedSimCardIdentificationBytes, actualParseFromResult.getSimCardIdentificationBytes());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(ByteString)"})
  void testProtoModemParseFromWithByteString_givenCodedInputStreamReadTagReturnZero() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSimCardIdentification());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedSimCardIdentificationBytes = data.EMPTY;
    assertEquals(expectedSimCardIdentificationBytes, actualParseFromResult.getSimCardIdentificationBytes());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(byte[])"})
  void testProtoModemParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSimCardIdentification());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(CodedInputStream)"})
  void testProtoModemParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSimCardIdentification());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoModemParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSimCardIdentification());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoModemParseFromWithCodedInputStreamExtensionRegistryLite_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSimCardIdentification());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(CodedInputStream)"})
  void testProtoModemParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSimCardIdentification());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(InputStream)"})
  void testProtoModemParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoModemParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSimCardIdentification());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(ModemType.MODEM_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoModemParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoModem.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoModemParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoModem.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(InputStream)"})
  void testProtoModemParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoModem.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(InputStream)"})
  void testProtoModemParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoModem.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoModem {@link ProtoModem#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoModem#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoModem parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoModem ProtoModem.parseFrom(InputStream)"})
  void testProtoModemParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ProtoModem actualParseFromResult = ProtoModem.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#equals(Object)}, and {@link ProtoRuntime#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoRuntime#equals(Object)}
   *   <li>{@link ProtoRuntime#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoRuntime equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoRuntime.equals(Object)", "int ProtoRuntime.hashCode()"})
  void testProtoRuntimeEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoRuntime defaultInstance = ProtoRuntime.getDefaultInstance();
    ProtoRuntime defaultInstance2 = ProtoRuntime.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#equals(Object)}, and {@link ProtoRuntime#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoRuntime#equals(Object)}
   *   <li>{@link ProtoRuntime#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoRuntime equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoRuntime.equals(Object)", "int ProtoRuntime.hashCode()"})
  void testProtoRuntimeEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProtoRuntime defaultInstance = ProtoRuntime.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRuntime#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoRuntime equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoRuntime.equals(Object)", "int ProtoRuntime.hashCode()"})
  void testProtoRuntimeEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoRuntime.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRuntime#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoRuntime equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoRuntime.equals(Object)", "int ProtoRuntime.hashCode()"})
  void testProtoRuntimeEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoRuntime.getDefaultInstance(), null);
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRuntime#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoRuntime equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoRuntime.equals(Object)", "int ProtoRuntime.hashCode()"})
  void testProtoRuntimeEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoRuntime.getDefaultInstance(), "Different type to ProtoRuntime");
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ProtoRuntime#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoRuntime getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.getDefaultInstanceForType()"})
  void testProtoRuntimeGetDefaultInstanceForType() {
    // Arrange
    ProtoRuntime defaultInstance = ProtoRuntime.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#getMessageCountersCount()}.
   * <p>
   * Method under test: {@link ProtoRuntime#getMessageCountersCount()}
   */
  @Test
  @DisplayName("Test ProtoRuntime getMessageCountersCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoRuntime.getMessageCountersCount()"})
  void testProtoRuntimeGetMessageCountersCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoRuntime.getDefaultInstance().getMessageCountersCount());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#getRuntimeErrorsCount()}.
   * <p>
   * Method under test: {@link ProtoRuntime#getRuntimeErrorsCount()}
   */
  @Test
  @DisplayName("Test ProtoRuntime getRuntimeErrorsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoRuntime.getRuntimeErrorsCount()"})
  void testProtoRuntimeGetRuntimeErrorsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoRuntime.getDefaultInstance().getRuntimeErrorsCount());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#getSerializedSize()}.
   * <p>
   * Method under test: {@link ProtoRuntime#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoRuntime getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoRuntime.getSerializedSize()"})
  void testProtoRuntimeGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoRuntime.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#isInitialized()}.
   * <p>
   * Method under test: {@link ProtoRuntime#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoRuntime isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoRuntime.isInitialized()"})
  void testProtoRuntimeIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProtoRuntime.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseDelimitedFrom(InputStream)"})
  void testProtoRuntimeParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoRuntime actualParseDelimitedFromResult = ProtoRuntime.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getBatteryResetTimestamp());
    assertEquals(0, actualParseDelimitedFromResult.getMaxMcuTemperature());
    assertEquals(0, actualParseDelimitedFromResult.getMcuTemperature());
    assertEquals(0, actualParseDelimitedFromResult.getMessageCountersCount());
    assertEquals(0, actualParseDelimitedFromResult.getMinBatteryMcuTemperature());
    assertEquals(0, actualParseDelimitedFromResult.getMinBatteryVoltage());
    assertEquals(0, actualParseDelimitedFromResult.getMinMcuTemperature());
    assertEquals(0, actualParseDelimitedFromResult.getRuntimeErrorsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getUpTime());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<Integer> messageCountersList = actualParseDelimitedFromResult.getMessageCountersList();
    assertTrue(messageCountersList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(messageCountersList, actualParseDelimitedFromResult.getRuntimeErrorsList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseDelimitedFrom(InputStream)"})
  void testProtoRuntimeParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoRuntime.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuntimeParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoRuntime actualParseDelimitedFromResult = ProtoRuntime.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getBatteryResetTimestamp());
    assertEquals(0, actualParseDelimitedFromResult.getMaxMcuTemperature());
    assertEquals(0, actualParseDelimitedFromResult.getMcuTemperature());
    assertEquals(0, actualParseDelimitedFromResult.getMessageCountersCount());
    assertEquals(0, actualParseDelimitedFromResult.getMinBatteryMcuTemperature());
    assertEquals(0, actualParseDelimitedFromResult.getMinBatteryVoltage());
    assertEquals(0, actualParseDelimitedFromResult.getMinMcuTemperature());
    assertEquals(0, actualParseDelimitedFromResult.getRuntimeErrorsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getUpTime());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<Integer> messageCountersList = actualParseDelimitedFromResult.getMessageCountersList();
    assertTrue(messageCountersList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(messageCountersList, actualParseDelimitedFromResult.getRuntimeErrorsList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuntimeParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoRuntime.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuntimeParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoRuntime.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRuntime#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuntimeParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoRuntime.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRuntime#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseDelimitedFrom(InputStream)"})
  void testProtoRuntimeParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoRuntime.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRuntime#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseDelimitedFrom(InputStream)"})
  void testProtoRuntimeParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoRuntime.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(ByteBuffer)"})
  void testProtoRuntimeParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoRuntime actualParseFromResult = ProtoRuntime.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBatteryResetTimestamp());
    assertEquals(0, actualParseFromResult.getMaxMcuTemperature());
    assertEquals(0, actualParseFromResult.getMcuTemperature());
    assertEquals(0, actualParseFromResult.getMessageCountersCount());
    assertEquals(0, actualParseFromResult.getMinBatteryMcuTemperature());
    assertEquals(0, actualParseFromResult.getMinBatteryVoltage());
    assertEquals(0, actualParseFromResult.getMinMcuTemperature());
    assertEquals(0, actualParseFromResult.getRuntimeErrorsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getUpTime());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Integer> messageCountersList = actualParseFromResult.getMessageCountersList();
    assertTrue(messageCountersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(messageCountersList, actualParseFromResult.getRuntimeErrorsList());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testProtoRuntimeParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ProtoRuntime actualParseFromResult = ProtoRuntime.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBatteryResetTimestamp());
    assertEquals(0, actualParseFromResult.getMaxMcuTemperature());
    assertEquals(0, actualParseFromResult.getMcuTemperature());
    assertEquals(0, actualParseFromResult.getMessageCountersCount());
    assertEquals(0, actualParseFromResult.getMinBatteryMcuTemperature());
    assertEquals(0, actualParseFromResult.getMinBatteryVoltage());
    assertEquals(0, actualParseFromResult.getMinMcuTemperature());
    assertEquals(0, actualParseFromResult.getRuntimeErrorsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getUpTime());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Integer> messageCountersList = actualParseFromResult.getMessageCountersList();
    assertTrue(messageCountersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(messageCountersList, actualParseFromResult.getRuntimeErrorsList());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoRuntimeParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoRuntime actualParseFromResult = ProtoRuntime.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseFromResult.getMessageCountersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    List<Integer> messageCountersList = actualParseFromResult.getMessageCountersList();
    assertTrue(messageCountersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    FileDescriptorProto toProtoResult = actualParseFromResult.getDescriptorForType().getFile().toProto();
    assertSame(messageCountersList, toProtoResult.getPublicDependencyList());
    assertSame(messageCountersList, toProtoResult.getWeakDependencyList());
    assertSame(messageCountersList, actualParseFromResult.getRuntimeErrorsList());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoRuntimeParseFromWithByteExtensionRegistryLite2() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoRuntime actualParseFromResult = ProtoRuntime.parseFrom(new byte[]{18, 6, 'A', 'X', 'A', 'X', 'A', 'X'},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(1, actualParseFromResult.getAllFields().size());
    List<Integer> messageCountersList = actualParseFromResult.getMessageCountersList();
    assertEquals(6, messageCountersList.size());
    assertEquals(6, actualParseFromResult.getMessageCountersCount());
    assertEquals(65, messageCountersList.get(0).intValue());
    assertEquals(65, messageCountersList.get(2).intValue());
    assertEquals(65, messageCountersList.get(4).intValue());
    assertEquals(8, actualParseFromResult.getSerializedSize());
    assertEquals(88, messageCountersList.get(1).intValue());
    assertEquals(88, messageCountersList.get(3).intValue());
    assertEquals(88, messageCountersList.get(5).intValue());
    List<Integer> runtimeErrorsList = actualParseFromResult.getRuntimeErrorsList();
    assertTrue(runtimeErrorsList.isEmpty());
    ProtoRuntime defaultInstanceForType = actualParseFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(runtimeErrorsList, defaultInstanceForType.getMessageCountersList());
    assertSame(runtimeErrorsList, defaultInstanceForType.getRuntimeErrorsList());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(ByteString)"})
  void testProtoRuntimeParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoRuntime actualParseFromResult = ProtoRuntime.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBatteryResetTimestamp());
    assertEquals(0, actualParseFromResult.getMaxMcuTemperature());
    assertEquals(0, actualParseFromResult.getMcuTemperature());
    assertEquals(0, actualParseFromResult.getMessageCountersCount());
    assertEquals(0, actualParseFromResult.getMinBatteryMcuTemperature());
    assertEquals(0, actualParseFromResult.getMinBatteryVoltage());
    assertEquals(0, actualParseFromResult.getMinMcuTemperature());
    assertEquals(0, actualParseFromResult.getRuntimeErrorsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getUpTime());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Integer> messageCountersList = actualParseFromResult.getMessageCountersList();
    assertTrue(messageCountersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(messageCountersList, actualParseFromResult.getRuntimeErrorsList());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoRuntimeParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoRuntime actualParseFromResult = ProtoRuntime.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBatteryResetTimestamp());
    assertEquals(0, actualParseFromResult.getMaxMcuTemperature());
    assertEquals(0, actualParseFromResult.getMcuTemperature());
    assertEquals(0, actualParseFromResult.getMessageCountersCount());
    assertEquals(0, actualParseFromResult.getMinBatteryMcuTemperature());
    assertEquals(0, actualParseFromResult.getMinBatteryVoltage());
    assertEquals(0, actualParseFromResult.getMinMcuTemperature());
    assertEquals(0, actualParseFromResult.getRuntimeErrorsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getUpTime());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Integer> messageCountersList = actualParseFromResult.getMessageCountersList();
    assertTrue(messageCountersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(messageCountersList, actualParseFromResult.getRuntimeErrorsList());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(byte[]) with 'byte[]'; then return AllFields size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(byte[])"})
  void testProtoRuntimeParseFromWithByte_thenReturnAllFieldsSizeIsOne() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoRuntime actualParseFromResult = ProtoRuntime.parseFrom(new byte[]{18, 6, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(1, actualParseFromResult.getAllFields().size());
    List<Integer> messageCountersList = actualParseFromResult.getMessageCountersList();
    assertEquals(6, messageCountersList.size());
    assertEquals(6, actualParseFromResult.getMessageCountersCount());
    assertEquals(65, messageCountersList.get(0).intValue());
    assertEquals(65, messageCountersList.get(2).intValue());
    assertEquals(65, messageCountersList.get(4).intValue());
    assertEquals(8, actualParseFromResult.getSerializedSize());
    assertEquals(88, messageCountersList.get(1).intValue());
    assertEquals(88, messageCountersList.get(3).intValue());
    assertEquals(88, messageCountersList.get(5).intValue());
    List<Integer> runtimeErrorsList = actualParseFromResult.getRuntimeErrorsList();
    assertTrue(runtimeErrorsList.isEmpty());
    ProtoRuntime defaultInstanceForType = actualParseFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(runtimeErrorsList, defaultInstanceForType.getMessageCountersList());
    assertSame(runtimeErrorsList, defaultInstanceForType.getRuntimeErrorsList());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return MessageCountersCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(byte[]) with 'byte[]'; then return MessageCountersCount is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(byte[])"})
  void testProtoRuntimeParseFromWithByte_thenReturnMessageCountersCountIsZero() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoRuntime actualParseFromResult = ProtoRuntime.parseFrom(new byte[]{});

    // Assert
    assertEquals(0, actualParseFromResult.getMessageCountersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    List<Integer> messageCountersList = actualParseFromResult.getMessageCountersList();
    assertTrue(messageCountersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    FileDescriptorProto toProtoResult = actualParseFromResult.getDescriptorForType().getFile().toProto();
    assertSame(messageCountersList, toProtoResult.getPublicDependencyList());
    assertSame(messageCountersList, toProtoResult.getWeakDependencyList());
    assertSame(messageCountersList, actualParseFromResult.getRuntimeErrorsList());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(CodedInputStream)"})
  void testProtoRuntimeParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoRuntime actualParseFromResult = ProtoRuntime.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBatteryResetTimestamp());
    assertEquals(0, actualParseFromResult.getMaxMcuTemperature());
    assertEquals(0, actualParseFromResult.getMcuTemperature());
    assertEquals(0, actualParseFromResult.getMessageCountersCount());
    assertEquals(0, actualParseFromResult.getMinBatteryMcuTemperature());
    assertEquals(0, actualParseFromResult.getMinBatteryVoltage());
    assertEquals(0, actualParseFromResult.getMinMcuTemperature());
    assertEquals(0, actualParseFromResult.getRuntimeErrorsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getUpTime());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Integer> messageCountersList = actualParseFromResult.getMessageCountersList();
    assertTrue(messageCountersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(messageCountersList, actualParseFromResult.getRuntimeErrorsList());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoRuntimeParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoRuntime actualParseFromResult = ProtoRuntime.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBatteryResetTimestamp());
    assertEquals(0, actualParseFromResult.getMaxMcuTemperature());
    assertEquals(0, actualParseFromResult.getMcuTemperature());
    assertEquals(0, actualParseFromResult.getMessageCountersCount());
    assertEquals(0, actualParseFromResult.getMinBatteryMcuTemperature());
    assertEquals(0, actualParseFromResult.getMinBatteryVoltage());
    assertEquals(0, actualParseFromResult.getMinMcuTemperature());
    assertEquals(0, actualParseFromResult.getRuntimeErrorsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getUpTime());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Integer> messageCountersList = actualParseFromResult.getMessageCountersList();
    assertTrue(messageCountersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(messageCountersList, actualParseFromResult.getRuntimeErrorsList());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(InputStream)"})
  void testProtoRuntimeParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ProtoRuntime actualParseFromResult = ProtoRuntime.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(ProtoRuntime.RUNTIME_ERRORS_FIELD_NUMBER,
        actualParseFromResult.getDescriptorForType().getFields().size());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuntimeParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ProtoRuntime actualParseFromResult = ProtoRuntime.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBatteryResetTimestamp());
    assertEquals(0, actualParseFromResult.getMaxMcuTemperature());
    assertEquals(0, actualParseFromResult.getMcuTemperature());
    assertEquals(0, actualParseFromResult.getMessageCountersCount());
    assertEquals(0, actualParseFromResult.getMinBatteryMcuTemperature());
    assertEquals(0, actualParseFromResult.getMinBatteryVoltage());
    assertEquals(0, actualParseFromResult.getMinMcuTemperature());
    assertEquals(0, actualParseFromResult.getRuntimeErrorsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getUpTime());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Integer> messageCountersList = actualParseFromResult.getMessageCountersList();
    assertTrue(messageCountersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(messageCountersList, actualParseFromResult.getRuntimeErrorsList());
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuntimeParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoRuntime.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuntimeParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoRuntime.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(InputStream)"})
  void testProtoRuntimeParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoRuntime.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(InputStream)"})
  void testProtoRuntimeParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoRuntime.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoRuntime {@link ProtoRuntime#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRuntime#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRuntime parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRuntime ProtoRuntime.parseFrom(InputStream)"})
  void testProtoRuntimeParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ProtoRuntime actualParseFromResult = ProtoRuntime.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(ProtoRuntime.RUNTIME_ERRORS_FIELD_NUMBER,
        actualParseFromResult.getDescriptorForType().getFields().size());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#equals(Object)}, and {@link ProtoUpdateInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoUpdateInfo#equals(Object)}
   *   <li>{@link ProtoUpdateInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoUpdateInfo.equals(Object)", "int ProtoUpdateInfo.hashCode()"})
  void testProtoUpdateInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoUpdateInfo defaultInstance = ProtoUpdateInfo.getDefaultInstance();
    ProtoUpdateInfo defaultInstance2 = ProtoUpdateInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#equals(Object)}, and {@link ProtoUpdateInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoUpdateInfo#equals(Object)}
   *   <li>{@link ProtoUpdateInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoUpdateInfo.equals(Object)", "int ProtoUpdateInfo.hashCode()"})
  void testProtoUpdateInfoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProtoUpdateInfo defaultInstance = ProtoUpdateInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUpdateInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoUpdateInfo.equals(Object)", "int ProtoUpdateInfo.hashCode()"})
  void testProtoUpdateInfoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoUpdateInfo.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUpdateInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoUpdateInfo.equals(Object)", "int ProtoUpdateInfo.hashCode()"})
  void testProtoUpdateInfoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoUpdateInfo.getDefaultInstance(), null);
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUpdateInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoUpdateInfo.equals(Object)", "int ProtoUpdateInfo.hashCode()"})
  void testProtoUpdateInfoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoUpdateInfo.getDefaultInstance(), "Different type to ProtoUpdateInfo");
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.getDefaultInstanceForType()"})
  void testProtoUpdateInfoGetDefaultInstanceForType() {
    // Arrange
    ProtoUpdateInfo defaultInstance = ProtoUpdateInfo.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#getSerializedSize()}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoUpdateInfo.getSerializedSize()"})
  void testProtoUpdateInfoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoUpdateInfo.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#isInitialized()}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoUpdateInfo.isInitialized()"})
  void testProtoUpdateInfoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProtoUpdateInfo.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseDelimitedFrom(InputStream)"})
  void testProtoUpdateInfoParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoUpdateInfo actualParseDelimitedFromResult = ProtoUpdateInfo.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getStatus());
    assertEquals(0, actualParseDelimitedFromResult.getTimestamp());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseDelimitedFrom(InputStream)"})
  void testProtoUpdateInfoParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoUpdateInfo.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoUpdateInfoParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoUpdateInfo actualParseDelimitedFromResult = ProtoUpdateInfo.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getStatus());
    assertEquals(0, actualParseDelimitedFromResult.getTimestamp());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoUpdateInfoParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoUpdateInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoUpdateInfoParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoUpdateInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoUpdateInfoParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoUpdateInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseDelimitedFrom(InputStream)"})
  void testProtoUpdateInfoParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoUpdateInfo.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseDelimitedFrom(InputStream)"})
  void testProtoUpdateInfoParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoUpdateInfo.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(byte[])"})
  void testProtoUpdateInfoParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoUpdateInfo actualParseFromResult = ProtoUpdateInfo.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatus());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(ByteBuffer)"})
  void testProtoUpdateInfoParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoUpdateInfo actualParseFromResult = ProtoUpdateInfo.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatus());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testProtoUpdateInfoParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ProtoUpdateInfo actualParseFromResult = ProtoUpdateInfo.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatus());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoUpdateInfoParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoUpdateInfo actualParseFromResult = ProtoUpdateInfo.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatus());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(ByteString)"})
  void testProtoUpdateInfoParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoUpdateInfo actualParseFromResult = ProtoUpdateInfo.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatus());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoUpdateInfoParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoUpdateInfo actualParseFromResult = ProtoUpdateInfo.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatus());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(CodedInputStream)"})
  void testProtoUpdateInfoParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoUpdateInfo actualParseFromResult = ProtoUpdateInfo.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatus());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoUpdateInfoParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoUpdateInfo actualParseFromResult = ProtoUpdateInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatus());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(InputStream)"})
  void testProtoUpdateInfoParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ProtoUpdateInfo actualParseFromResult = ProtoUpdateInfo.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(InputStream)"})
  void testProtoUpdateInfoParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoUpdateInfo.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoUpdateInfoParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ProtoUpdateInfo actualParseFromResult = ProtoUpdateInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatus());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoUpdateInfoParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoUpdateInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoUpdateInfoParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoUpdateInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(InputStream)"})
  void testProtoUpdateInfoParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoUpdateInfo.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoUpdateInfo {@link ProtoUpdateInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUpdateInfo#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoUpdateInfo parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoUpdateInfo ProtoUpdateInfo.parseFrom(InputStream)"})
  void testProtoUpdateInfoParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ProtoUpdateInfo actualParseFromResult = ProtoUpdateInfo.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }
}
