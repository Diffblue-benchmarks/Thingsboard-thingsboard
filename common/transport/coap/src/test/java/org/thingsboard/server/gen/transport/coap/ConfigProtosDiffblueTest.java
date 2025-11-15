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
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
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
import org.thingsboard.server.gen.transport.coap.ConfigProtos.BleAdvertisingPeriodMode;
import org.thingsboard.server.gen.transport.coap.ConfigProtos.ProtoBleAdvertisingPeriod;
import org.thingsboard.server.gen.transport.coap.ConfigProtos.ProtoCalibrationParameters;
import org.thingsboard.server.gen.transport.coap.ConfigProtos.ProtoConfig;
import org.thingsboard.server.gen.transport.coap.ConfigProtos.ProtoOutputControlState;
import org.thingsboard.server.gen.transport.coap.ProtoRuleProtos.ProtoCalendar;

class ConfigProtosDiffblueTest {
  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#forNumber(int)}.
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#forNumber(int)}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode forNumber(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BleAdvertisingPeriodMode BleAdvertisingPeriodMode.forNumber(int)"})
  void testBleAdvertisingPeriodModeForNumber() {
    // Arrange, Act and Assert
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED,
        BleAdvertisingPeriodMode.forNumber(0));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code BLE_ADVERTISING_PERIOD_MODE_DEFAULT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#forNumber(int)}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode forNumber(int); then return 'BLE_ADVERTISING_PERIOD_MODE_DEFAULT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BleAdvertisingPeriodMode BleAdvertisingPeriodMode.forNumber(int)"})
  void testBleAdvertisingPeriodModeForNumber_thenReturnBleAdvertisingPeriodModeDefault() {
    // Arrange, Act and Assert
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_DEFAULT, BleAdvertisingPeriodMode.forNumber(1));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code BLE_ADVERTISING_PERIOD_MODE_FAST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#forNumber(int)}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode forNumber(int); then return 'BLE_ADVERTISING_PERIOD_MODE_FAST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BleAdvertisingPeriodMode BleAdvertisingPeriodMode.forNumber(int)"})
  void testBleAdvertisingPeriodModeForNumber_thenReturnBleAdvertisingPeriodModeFast() {
    // Arrange, Act and Assert
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_FAST, BleAdvertisingPeriodMode.forNumber(3));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code BLE_ADVERTISING_PERIOD_MODE_NORMAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#forNumber(int)}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode forNumber(int); then return 'BLE_ADVERTISING_PERIOD_MODE_NORMAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BleAdvertisingPeriodMode BleAdvertisingPeriodMode.forNumber(int)"})
  void testBleAdvertisingPeriodModeForNumber_thenReturnBleAdvertisingPeriodModeNormal() {
    // Arrange, Act and Assert
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_NORMAL, BleAdvertisingPeriodMode.forNumber(2));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#forNumber(int)}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode forNumber(int); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BleAdvertisingPeriodMode BleAdvertisingPeriodMode.forNumber(int)"})
  void testBleAdvertisingPeriodModeForNumber_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BleAdvertisingPeriodMode.forNumber(ProtoConfig.DNS_SERVER_IP_FIELD_NUMBER));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#getDescriptor()}.
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#getDescriptor()}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor BleAdvertisingPeriodMode.getDescriptor()"})
  void testBleAdvertisingPeriodModeGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = BleAdvertisingPeriodMode.getDescriptor();

    // Assert
    assertEquals("BleAdvertisingPeriodMode", actualDescriptor.getFullName());
    assertEquals("BleAdvertisingPeriodMode", actualDescriptor.getName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#getDescriptorForType()}.
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor BleAdvertisingPeriodMode.getDescriptorForType()"})
  void testBleAdvertisingPeriodModeGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED
        .getDescriptorForType();

    // Assert
    assertEquals("BleAdvertisingPeriodMode", actualDescriptorForType.getFullName());
    assertEquals("BleAdvertisingPeriodMode", actualDescriptorForType.getName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(4, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#getNumber()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#getNumber()}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode getNumber(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BleAdvertisingPeriodMode.getNumber()"})
  void testBleAdvertisingPeriodModeGetNumber_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED.getNumber());
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#getNumber()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#getNumber()}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode getNumber(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BleAdvertisingPeriodMode.getNumber()"})
  void testBleAdvertisingPeriodModeGetNumber_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> BleAdvertisingPeriodMode.UNRECOGNIZED.getNumber());
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#getValueDescriptor()}.
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode getValueDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor BleAdvertisingPeriodMode.getValueDescriptor()"})
  void testBleAdvertisingPeriodModeGetValueDescriptor() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED
        .getValueDescriptor();

    // Assert
    assertEquals("BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED", actualValueDescriptor.getName());
    assertEquals("BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED",
        actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#getValueDescriptor()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode getValueDescriptor(); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor BleAdvertisingPeriodMode.getValueDescriptor()"})
  void testBleAdvertisingPeriodModeGetValueDescriptor_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> BleAdvertisingPeriodMode.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#internalGetValueMap()}.
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BleAdvertisingPeriodMode.internalGetValueMap()"})
  void testBleAdvertisingPeriodModeInternalGetValueMap() {
    // Arrange and Act
    EnumLiteMap<BleAdvertisingPeriodMode> actualInternalGetValueMapResult = BleAdvertisingPeriodMode
        .internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#internalGetValueMap()}.
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BleAdvertisingPeriodMode.internalGetValueMap()"})
  void testBleAdvertisingPeriodModeInternalGetValueMap2() {
    // Arrange and Act
    EnumLiteMap<BleAdvertisingPeriodMode> actualInternalGetValueMapResult = BleAdvertisingPeriodMode
        .internalGetValueMap();

    // Assert
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_DEFAULT,
        actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#internalGetValueMap()}.
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BleAdvertisingPeriodMode.internalGetValueMap()"})
  void testBleAdvertisingPeriodModeInternalGetValueMap3() {
    // Arrange and Act
    EnumLiteMap<BleAdvertisingPeriodMode> actualInternalGetValueMapResult = BleAdvertisingPeriodMode
        .internalGetValueMap();

    // Assert
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_NORMAL,
        actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#internalGetValueMap()}.
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BleAdvertisingPeriodMode.internalGetValueMap()"})
  void testBleAdvertisingPeriodModeInternalGetValueMap4() {
    // Arrange and Act
    EnumLiteMap<BleAdvertisingPeriodMode> actualInternalGetValueMapResult = BleAdvertisingPeriodMode
        .internalGetValueMap();

    // Assert
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_FAST,
        actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#internalGetValueMap()}.
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap BleAdvertisingPeriodMode.internalGetValueMap()"})
  void testBleAdvertisingPeriodModeInternalGetValueMap5() {
    // Arrange and Act
    EnumLiteMap<BleAdvertisingPeriodMode> actualInternalGetValueMapResult = BleAdvertisingPeriodMode
        .internalGetValueMap();

    // Assert
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED,
        actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#valueOf(int)}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode valueOf(int) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BleAdvertisingPeriodMode BleAdvertisingPeriodMode.valueOf(int)"})
  void testBleAdvertisingPeriodModeValueOfWithValue() {
    // Arrange, Act and Assert
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED, BleAdvertisingPeriodMode.valueOf(0));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#valueOf(int)}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode valueOf(int) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BleAdvertisingPeriodMode BleAdvertisingPeriodMode.valueOf(int)"})
  void testBleAdvertisingPeriodModeValueOfWithValue2() {
    // Arrange, Act and Assert
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_DEFAULT, BleAdvertisingPeriodMode.valueOf(1));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#valueOf(int)}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode valueOf(int) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BleAdvertisingPeriodMode BleAdvertisingPeriodMode.valueOf(int)"})
  void testBleAdvertisingPeriodModeValueOfWithValue3() {
    // Arrange, Act and Assert
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_NORMAL, BleAdvertisingPeriodMode.valueOf(2));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#valueOf(int)}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode valueOf(int) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BleAdvertisingPeriodMode BleAdvertisingPeriodMode.valueOf(int)"})
  void testBleAdvertisingPeriodModeValueOfWithValue4() {
    // Arrange, Act and Assert
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_FAST, BleAdvertisingPeriodMode.valueOf(3));
  }

  /**
   * Test BleAdvertisingPeriodMode {@link BleAdvertisingPeriodMode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BleAdvertisingPeriodMode#valueOf(int)}
   */
  @Test
  @DisplayName("Test BleAdvertisingPeriodMode valueOf(int) with 'value'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BleAdvertisingPeriodMode BleAdvertisingPeriodMode.valueOf(int)"})
  void testBleAdvertisingPeriodModeValueOfWithValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BleAdvertisingPeriodMode.valueOf(ProtoConfig.DNS_SERVER_IP_FIELD_NUMBER));
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#equals(Object)}, and {@link ProtoBleAdvertisingPeriod#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoBleAdvertisingPeriod#equals(Object)}
   *   <li>{@link ProtoBleAdvertisingPeriod#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoBleAdvertisingPeriod.equals(Object)", "int ProtoBleAdvertisingPeriod.hashCode()"})
  void testProtoBleAdvertisingPeriodEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoBleAdvertisingPeriod defaultInstance = ProtoBleAdvertisingPeriod.getDefaultInstance();
    ProtoBleAdvertisingPeriod defaultInstance2 = ProtoBleAdvertisingPeriod.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#equals(Object)}, and {@link ProtoBleAdvertisingPeriod#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoBleAdvertisingPeriod#equals(Object)}
   *   <li>{@link ProtoBleAdvertisingPeriod#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoBleAdvertisingPeriod.equals(Object)", "int ProtoBleAdvertisingPeriod.hashCode()"})
  void testProtoBleAdvertisingPeriodEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProtoBleAdvertisingPeriod defaultInstance = ProtoBleAdvertisingPeriod.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoBleAdvertisingPeriod.equals(Object)", "int ProtoBleAdvertisingPeriod.hashCode()"})
  void testProtoBleAdvertisingPeriodEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoBleAdvertisingPeriod.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoBleAdvertisingPeriod.equals(Object)", "int ProtoBleAdvertisingPeriod.hashCode()"})
  void testProtoBleAdvertisingPeriodEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoBleAdvertisingPeriod.getDefaultInstance(), null);
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoBleAdvertisingPeriod.equals(Object)", "int ProtoBleAdvertisingPeriod.hashCode()"})
  void testProtoBleAdvertisingPeriodEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoBleAdvertisingPeriod.getDefaultInstance(), "Different type to ProtoBleAdvertisingPeriod");
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.getDefaultInstanceForType()"})
  void testProtoBleAdvertisingPeriodGetDefaultInstanceForType() {
    // Arrange
    ProtoBleAdvertisingPeriod defaultInstance = ProtoBleAdvertisingPeriod.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#getMode()}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#getMode()}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod getMode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BleAdvertisingPeriodMode ProtoBleAdvertisingPeriod.getMode()"})
  void testProtoBleAdvertisingPeriodGetMode() {
    // Arrange, Act and Assert
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED,
        ProtoBleAdvertisingPeriod.getDefaultInstance().getMode());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#getSerializedSize()}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoBleAdvertisingPeriod.getSerializedSize()"})
  void testProtoBleAdvertisingPeriodGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoBleAdvertisingPeriod.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#isInitialized()}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoBleAdvertisingPeriod.isInitialized()"})
  void testProtoBleAdvertisingPeriodIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProtoBleAdvertisingPeriod.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseDelimitedFrom(InputStream)"})
  void testProtoBleAdvertisingPeriodParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoBleAdvertisingPeriod actualParseDelimitedFromResult = ProtoBleAdvertisingPeriod.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getFast());
    assertEquals(0, actualParseDelimitedFromResult.getModeValue());
    assertEquals(0, actualParseDelimitedFromResult.getNormal());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED,
        actualParseDelimitedFromResult.getMode());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseDelimitedFrom(InputStream)"})
  void testProtoBleAdvertisingPeriodParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoBleAdvertisingPeriod.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoBleAdvertisingPeriodParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoBleAdvertisingPeriod actualParseDelimitedFromResult = ProtoBleAdvertisingPeriod.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getFast());
    assertEquals(0, actualParseDelimitedFromResult.getModeValue());
    assertEquals(0, actualParseDelimitedFromResult.getNormal());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED,
        actualParseDelimitedFromResult.getMode());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoBleAdvertisingPeriodParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoBleAdvertisingPeriod.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoBleAdvertisingPeriodParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoBleAdvertisingPeriod.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoBleAdvertisingPeriodParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoBleAdvertisingPeriod.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseDelimitedFrom(InputStream)"})
  void testProtoBleAdvertisingPeriodParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoBleAdvertisingPeriod.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseDelimitedFrom(InputStream)"})
  void testProtoBleAdvertisingPeriodParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoBleAdvertisingPeriod.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(byte[])"})
  void testProtoBleAdvertisingPeriodParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoBleAdvertisingPeriod actualParseFromResult = ProtoBleAdvertisingPeriod.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFast());
    assertEquals(0, actualParseFromResult.getModeValue());
    assertEquals(0, actualParseFromResult.getNormal());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED, actualParseFromResult.getMode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(ByteBuffer)"})
  void testProtoBleAdvertisingPeriodParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoBleAdvertisingPeriod actualParseFromResult = ProtoBleAdvertisingPeriod
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFast());
    assertEquals(0, actualParseFromResult.getModeValue());
    assertEquals(0, actualParseFromResult.getNormal());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED, actualParseFromResult.getMode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testProtoBleAdvertisingPeriodParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ProtoBleAdvertisingPeriod actualParseFromResult = ProtoBleAdvertisingPeriod.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFast());
    assertEquals(0, actualParseFromResult.getModeValue());
    assertEquals(0, actualParseFromResult.getNormal());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED, actualParseFromResult.getMode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoBleAdvertisingPeriodParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoBleAdvertisingPeriod actualParseFromResult = ProtoBleAdvertisingPeriod.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFast());
    assertEquals(0, actualParseFromResult.getModeValue());
    assertEquals(0, actualParseFromResult.getNormal());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED, actualParseFromResult.getMode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(ByteString)"})
  void testProtoBleAdvertisingPeriodParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoBleAdvertisingPeriod actualParseFromResult = ProtoBleAdvertisingPeriod.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFast());
    assertEquals(0, actualParseFromResult.getModeValue());
    assertEquals(0, actualParseFromResult.getNormal());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED, actualParseFromResult.getMode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoBleAdvertisingPeriodParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoBleAdvertisingPeriod actualParseFromResult = ProtoBleAdvertisingPeriod.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFast());
    assertEquals(0, actualParseFromResult.getModeValue());
    assertEquals(0, actualParseFromResult.getNormal());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED, actualParseFromResult.getMode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(CodedInputStream)"})
  void testProtoBleAdvertisingPeriodParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoBleAdvertisingPeriod actualParseFromResult = ProtoBleAdvertisingPeriod.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFast());
    assertEquals(0, actualParseFromResult.getModeValue());
    assertEquals(0, actualParseFromResult.getNormal());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED, actualParseFromResult.getMode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoBleAdvertisingPeriodParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoBleAdvertisingPeriod actualParseFromResult = ProtoBleAdvertisingPeriod.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFast());
    assertEquals(0, actualParseFromResult.getModeValue());
    assertEquals(0, actualParseFromResult.getNormal());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED, actualParseFromResult.getMode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(InputStream)"})
  void testProtoBleAdvertisingPeriodParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ProtoBleAdvertisingPeriod actualParseFromResult = ProtoBleAdvertisingPeriod
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(InputStream)"})
  void testProtoBleAdvertisingPeriodParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoBleAdvertisingPeriod.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoBleAdvertisingPeriodParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ProtoBleAdvertisingPeriod actualParseFromResult = ProtoBleAdvertisingPeriod.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFast());
    assertEquals(0, actualParseFromResult.getModeValue());
    assertEquals(0, actualParseFromResult.getNormal());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED, actualParseFromResult.getMode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoBleAdvertisingPeriodParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoBleAdvertisingPeriod.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoBleAdvertisingPeriodParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoBleAdvertisingPeriod.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(InputStream)"})
  void testProtoBleAdvertisingPeriodParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoBleAdvertisingPeriod.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoBleAdvertisingPeriod {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoBleAdvertisingPeriod#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoBleAdvertisingPeriod parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoBleAdvertisingPeriod.parseFrom(InputStream)"})
  void testProtoBleAdvertisingPeriodParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ProtoBleAdvertisingPeriod actualParseFromResult = ProtoBleAdvertisingPeriod.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#equals(Object)}, and {@link ProtoCalibrationParameters#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoCalibrationParameters#equals(Object)}
   *   <li>{@link ProtoCalibrationParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoCalibrationParameters.equals(Object)", "int ProtoCalibrationParameters.hashCode()"})
  void testProtoCalibrationParametersEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoCalibrationParameters defaultInstance = ProtoCalibrationParameters.getDefaultInstance();
    ProtoCalibrationParameters defaultInstance2 = ProtoCalibrationParameters.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#equals(Object)}, and {@link ProtoCalibrationParameters#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoCalibrationParameters#equals(Object)}
   *   <li>{@link ProtoCalibrationParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoCalibrationParameters.equals(Object)", "int ProtoCalibrationParameters.hashCode()"})
  void testProtoCalibrationParametersEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProtoCalibrationParameters defaultInstance = ProtoCalibrationParameters.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoCalibrationParameters.equals(Object)", "int ProtoCalibrationParameters.hashCode()"})
  void testProtoCalibrationParametersEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoCalibrationParameters.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoCalibrationParameters.equals(Object)", "int ProtoCalibrationParameters.hashCode()"})
  void testProtoCalibrationParametersEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoCalibrationParameters.getDefaultInstance(), null);
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoCalibrationParameters.equals(Object)", "int ProtoCalibrationParameters.hashCode()"})
  void testProtoCalibrationParametersEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoCalibrationParameters.getDefaultInstance(), "Different type to ProtoCalibrationParameters");
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.getDefaultInstanceForType()"})
  void testProtoCalibrationParametersGetDefaultInstanceForType() {
    // Arrange
    ProtoCalibrationParameters defaultInstance = ProtoCalibrationParameters.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#getParametersCount()}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#getParametersCount()}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters getParametersCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoCalibrationParameters.getParametersCount()"})
  void testProtoCalibrationParametersGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoCalibrationParameters.getDefaultInstance().getParametersCount());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#getSerializedSize()}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoCalibrationParameters.getSerializedSize()"})
  void testProtoCalibrationParametersGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoCalibrationParameters.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#isInitialized()}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoCalibrationParameters.isInitialized()"})
  void testProtoCalibrationParametersIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProtoCalibrationParameters.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseDelimitedFrom(InputStream)"})
  void testProtoCalibrationParametersParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoCalibrationParameters actualParseDelimitedFromResult = ProtoCalibrationParameters.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getCalibrationRequest());
    assertEquals(0, actualParseDelimitedFromResult.getChannelAssignment());
    assertEquals(0, actualParseDelimitedFromResult.getParametersCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getParametersList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseDelimitedFrom(InputStream)"})
  void testProtoCalibrationParametersParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoCalibrationParameters.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoCalibrationParameters ProtoCalibrationParameters.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalibrationParametersParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoCalibrationParameters actualParseDelimitedFromResult = ProtoCalibrationParameters.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getCalibrationRequest());
    assertEquals(0, actualParseDelimitedFromResult.getChannelAssignment());
    assertEquals(0, actualParseDelimitedFromResult.getParametersCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getParametersList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoCalibrationParameters ProtoCalibrationParameters.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalibrationParametersParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoCalibrationParameters.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoCalibrationParameters ProtoCalibrationParameters.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalibrationParametersParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoCalibrationParameters.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoCalibrationParameters ProtoCalibrationParameters.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalibrationParametersParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoCalibrationParameters.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseDelimitedFrom(InputStream)"})
  void testProtoCalibrationParametersParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoCalibrationParameters.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseDelimitedFrom(InputStream)"})
  void testProtoCalibrationParametersParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoCalibrationParameters.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(byte[])"})
  void testProtoCalibrationParametersParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCalibrationRequest());
    assertEquals(0, actualParseFromResult.getChannelAssignment());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(ByteBuffer)"})
  void testProtoCalibrationParametersParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCalibrationRequest());
    assertEquals(0, actualParseFromResult.getChannelAssignment());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testProtoCalibrationParametersParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCalibrationRequest());
    assertEquals(0, actualParseFromResult.getChannelAssignment());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoCalibrationParametersParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCalibrationRequest());
    assertEquals(0, actualParseFromResult.getChannelAssignment());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(ByteString)"})
  void testProtoCalibrationParametersParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCalibrationRequest());
    assertEquals(0, actualParseFromResult.getChannelAssignment());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(ByteString)"})
  void testProtoCalibrationParametersParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCalibrationRequest());
    assertEquals(0, actualParseFromResult.getChannelAssignment());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoCalibrationParametersParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCalibrationRequest());
    assertEquals(0, actualParseFromResult.getChannelAssignment());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoCalibrationParametersParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCalibrationRequest());
    assertEquals(0, actualParseFromResult.getChannelAssignment());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(CodedInputStream)"})
  void testProtoCalibrationParametersParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCalibrationRequest());
    assertEquals(0, actualParseFromResult.getChannelAssignment());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoCalibrationParametersParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCalibrationRequest());
    assertEquals(0, actualParseFromResult.getChannelAssignment());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoCalibrationParametersParseFromWithCodedInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCalibrationRequest());
    assertEquals(0, actualParseFromResult.getChannelAssignment());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(CodedInputStream)"})
  void testProtoCalibrationParametersParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCalibrationRequest());
    assertEquals(0, actualParseFromResult.getChannelAssignment());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(InputStream)"})
  void testProtoCalibrationParametersParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(InputStream)"})
  void testProtoCalibrationParametersParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoCalibrationParameters.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalibrationParametersParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCalibrationRequest());
    assertEquals(0, actualParseFromResult.getChannelAssignment());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalibrationParametersParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoCalibrationParameters.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalibrationParametersParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoCalibrationParameters.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(InputStream)"})
  void testProtoCalibrationParametersParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoCalibrationParameters.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoCalibrationParameters {@link ProtoCalibrationParameters#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalibrationParameters#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalibrationParameters parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoCalibrationParameters.parseFrom(InputStream)"})
  void testProtoCalibrationParametersParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ProtoCalibrationParameters actualParseFromResult = ProtoCalibrationParameters.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#equals(Object)}, and {@link ProtoConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoConfig#equals(Object)}
   *   <li>{@link ProtoConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoConfig equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoConfig.equals(Object)", "int ProtoConfig.hashCode()"})
  void testProtoConfigEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();
    ProtoConfig defaultInstance2 = ProtoConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#equals(Object)}, and {@link ProtoConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoConfig#equals(Object)}
   *   <li>{@link ProtoConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoConfig equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoConfig.equals(Object)", "int ProtoConfig.hashCode()"})
  void testProtoConfigEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoConfig equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoConfig.equals(Object)", "int ProtoConfig.hashCode()"})
  void testProtoConfigEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoConfig.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoConfig equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoConfig.equals(Object)", "int ProtoConfig.hashCode()"})
  void testProtoConfigEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoConfig.getDefaultInstance(), null);
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoConfig equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoConfig.equals(Object)", "int ProtoConfig.hashCode()"})
  void testProtoConfigEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoConfig.getDefaultInstance(), "Different type to ProtoConfig");
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getApn()}.
   * <p>
   * Method under test: {@link ProtoConfig#getApn()}
   */
  @Test
  @DisplayName("Test ProtoConfig getApn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConfig.getApn()"})
  void testProtoConfigGetApn() {
    // Arrange, Act and Assert
    assertEquals("", ProtoConfig.getDefaultInstance().getApn());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getApnBytes()}.
   * <p>
   * Method under test: {@link ProtoConfig#getApnBytes()}
   */
  @Test
  @DisplayName("Test ProtoConfig getApnBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoConfig.getApnBytes()"})
  void testProtoConfigGetApnBytes() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();

    // Act
    ByteString actualApnBytes = defaultInstance.getApnBytes();

    // Assert
    ByteString byteString = actualApnBytes.EMPTY;
    assertEquals(byteString, actualApnBytes);
    assertEquals(byteString, defaultInstance.getApnPasswordBytes());
    assertEquals(byteString, defaultInstance.getApnUserNameBytes());
    assertEquals(byteString, defaultInstance.getCloudTokenBytes());
    assertEquals(byteString, defaultInstance.getConfigurationEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataServerIpBytes());
    assertEquals(byteString, defaultInstance.getDeviceInfoEndpointBytes());
    assertSame(byteString, defaultInstance.getEncryptionKey());
    assertSame(byteString, defaultInstance.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getApnPassword()}.
   * <p>
   * Method under test: {@link ProtoConfig#getApnPassword()}
   */
  @Test
  @DisplayName("Test ProtoConfig getApnPassword()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConfig.getApnPassword()"})
  void testProtoConfigGetApnPassword() {
    // Arrange, Act and Assert
    assertEquals("", ProtoConfig.getDefaultInstance().getApnPassword());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getApnPasswordBytes()}.
   * <p>
   * Method under test: {@link ProtoConfig#getApnPasswordBytes()}
   */
  @Test
  @DisplayName("Test ProtoConfig getApnPasswordBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoConfig.getApnPasswordBytes()"})
  void testProtoConfigGetApnPasswordBytes() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();

    // Act
    ByteString actualApnPasswordBytes = defaultInstance.getApnPasswordBytes();

    // Assert
    ByteString byteString = actualApnPasswordBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getApnBytes());
    assertEquals(byteString, actualApnPasswordBytes);
    assertEquals(byteString, defaultInstance.getApnUserNameBytes());
    assertEquals(byteString, defaultInstance.getCloudTokenBytes());
    assertEquals(byteString, defaultInstance.getConfigurationEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataServerIpBytes());
    assertEquals(byteString, defaultInstance.getDeviceInfoEndpointBytes());
    assertSame(byteString, defaultInstance.getEncryptionKey());
    assertSame(byteString, defaultInstance.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getApnUserName()}.
   * <p>
   * Method under test: {@link ProtoConfig#getApnUserName()}
   */
  @Test
  @DisplayName("Test ProtoConfig getApnUserName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConfig.getApnUserName()"})
  void testProtoConfigGetApnUserName() {
    // Arrange, Act and Assert
    assertEquals("", ProtoConfig.getDefaultInstance().getApnUserName());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getApnUserNameBytes()}.
   * <p>
   * Method under test: {@link ProtoConfig#getApnUserNameBytes()}
   */
  @Test
  @DisplayName("Test ProtoConfig getApnUserNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoConfig.getApnUserNameBytes()"})
  void testProtoConfigGetApnUserNameBytes() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();

    // Act
    ByteString actualApnUserNameBytes = defaultInstance.getApnUserNameBytes();

    // Assert
    ByteString byteString = actualApnUserNameBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getApnBytes());
    assertEquals(byteString, defaultInstance.getApnPasswordBytes());
    assertEquals(byteString, actualApnUserNameBytes);
    assertEquals(byteString, defaultInstance.getCloudTokenBytes());
    assertEquals(byteString, defaultInstance.getConfigurationEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataServerIpBytes());
    assertEquals(byteString, defaultInstance.getDeviceInfoEndpointBytes());
    assertSame(byteString, defaultInstance.getEncryptionKey());
    assertSame(byteString, defaultInstance.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getBleAdvertisingPeriod()}.
   * <p>
   * Method under test: {@link ProtoConfig#getBleAdvertisingPeriod()}
   */
  @Test
  @DisplayName("Test ProtoConfig getBleAdvertisingPeriod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoBleAdvertisingPeriod ProtoConfig.getBleAdvertisingPeriod()"})
  void testProtoConfigGetBleAdvertisingPeriod() {
    // Arrange and Act
    ProtoBleAdvertisingPeriod actualBleAdvertisingPeriod = ProtoConfig.getDefaultInstance().getBleAdvertisingPeriod();

    // Assert
    assertEquals("", actualBleAdvertisingPeriod.getInitializationErrorString());
    assertEquals(0, actualBleAdvertisingPeriod.getFast());
    assertEquals(0, actualBleAdvertisingPeriod.getModeValue());
    assertEquals(0, actualBleAdvertisingPeriod.getNormal());
    assertEquals(0, actualBleAdvertisingPeriod.getSerializedSize());
    assertEquals(BleAdvertisingPeriodMode.BLE_ADVERTISING_PERIOD_MODE_UNSPECIFIED,
        actualBleAdvertisingPeriod.getMode());
    assertTrue(actualBleAdvertisingPeriod.findInitializationErrors().isEmpty());
    assertTrue(actualBleAdvertisingPeriod.getAllFields().isEmpty());
    assertTrue(actualBleAdvertisingPeriod.isInitialized());
    assertSame(actualBleAdvertisingPeriod, actualBleAdvertisingPeriod.getDefaultInstanceForType());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getCalendarsCount()}.
   * <p>
   * Method under test: {@link ProtoConfig#getCalendarsCount()}
   */
  @Test
  @DisplayName("Test ProtoConfig getCalendarsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoConfig.getCalendarsCount()"})
  void testProtoConfigGetCalendarsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoConfig.getDefaultInstance().getCalendarsCount());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getCalibrationParametersRequest()}.
   * <p>
   * Method under test: {@link ProtoConfig#getCalibrationParametersRequest()}
   */
  @Test
  @DisplayName("Test ProtoConfig getCalibrationParametersRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalibrationParameters ProtoConfig.getCalibrationParametersRequest()"})
  void testProtoConfigGetCalibrationParametersRequest() {
    // Arrange and Act
    ProtoCalibrationParameters actualCalibrationParametersRequest = ProtoConfig.getDefaultInstance()
        .getCalibrationParametersRequest();

    // Assert
    assertEquals("", actualCalibrationParametersRequest.getInitializationErrorString());
    assertEquals(0, actualCalibrationParametersRequest.getCalibrationRequest());
    assertEquals(0, actualCalibrationParametersRequest.getChannelAssignment());
    assertEquals(0, actualCalibrationParametersRequest.getParametersCount());
    assertEquals(0, actualCalibrationParametersRequest.getSerializedSize());
    assertTrue(actualCalibrationParametersRequest.findInitializationErrors().isEmpty());
    assertTrue(actualCalibrationParametersRequest.getParametersList().isEmpty());
    assertTrue(actualCalibrationParametersRequest.getAllFields().isEmpty());
    assertTrue(actualCalibrationParametersRequest.isInitialized());
    assertSame(actualCalibrationParametersRequest, actualCalibrationParametersRequest.getDefaultInstanceForType());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getCellularConfigParamsCount()}.
   * <p>
   * Method under test: {@link ProtoConfig#getCellularConfigParamsCount()}
   */
  @Test
  @DisplayName("Test ProtoConfig getCellularConfigParamsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoConfig.getCellularConfigParamsCount()"})
  void testProtoConfigGetCellularConfigParamsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoConfig.getDefaultInstance().getCellularConfigParamsCount());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getChannelTypesCount()}.
   * <p>
   * Method under test: {@link ProtoConfig#getChannelTypesCount()}
   */
  @Test
  @DisplayName("Test ProtoConfig getChannelTypesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoConfig.getChannelTypesCount()"})
  void testProtoConfigGetChannelTypesCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoConfig.getDefaultInstance().getChannelTypesCount());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getChannelTypesList()}.
   * <p>
   * Method under test: {@link ProtoConfig#getChannelTypesList()}
   */
  @Test
  @DisplayName("Test ProtoConfig getChannelTypesList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ProtoConfig.getChannelTypesList()"})
  void testProtoConfigGetChannelTypesList() {
    // Arrange, Act and Assert
    assertTrue(ProtoConfig.getDefaultInstance().getChannelTypesList().isEmpty());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getCloudToken()}.
   * <p>
   * Method under test: {@link ProtoConfig#getCloudToken()}
   */
  @Test
  @DisplayName("Test ProtoConfig getCloudToken()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConfig.getCloudToken()"})
  void testProtoConfigGetCloudToken() {
    // Arrange, Act and Assert
    assertEquals("", ProtoConfig.getDefaultInstance().getCloudToken());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getCloudTokenBytes()}.
   * <p>
   * Method under test: {@link ProtoConfig#getCloudTokenBytes()}
   */
  @Test
  @DisplayName("Test ProtoConfig getCloudTokenBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoConfig.getCloudTokenBytes()"})
  void testProtoConfigGetCloudTokenBytes() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();

    // Act
    ByteString actualCloudTokenBytes = defaultInstance.getCloudTokenBytes();

    // Assert
    ByteString byteString = actualCloudTokenBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getApnBytes());
    assertEquals(byteString, defaultInstance.getApnPasswordBytes());
    assertEquals(byteString, defaultInstance.getApnUserNameBytes());
    assertEquals(byteString, actualCloudTokenBytes);
    assertEquals(byteString, defaultInstance.getConfigurationEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataServerIpBytes());
    assertEquals(byteString, defaultInstance.getDeviceInfoEndpointBytes());
    assertSame(byteString, defaultInstance.getEncryptionKey());
    assertSame(byteString, defaultInstance.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getConfigurationEndpoint()}.
   * <p>
   * Method under test: {@link ProtoConfig#getConfigurationEndpoint()}
   */
  @Test
  @DisplayName("Test ProtoConfig getConfigurationEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConfig.getConfigurationEndpoint()"})
  void testProtoConfigGetConfigurationEndpoint() {
    // Arrange, Act and Assert
    assertEquals("", ProtoConfig.getDefaultInstance().getConfigurationEndpoint());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getConfigurationEndpointBytes()}.
   * <p>
   * Method under test: {@link ProtoConfig#getConfigurationEndpointBytes()}
   */
  @Test
  @DisplayName("Test ProtoConfig getConfigurationEndpointBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoConfig.getConfigurationEndpointBytes()"})
  void testProtoConfigGetConfigurationEndpointBytes() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();

    // Act
    ByteString actualConfigurationEndpointBytes = defaultInstance.getConfigurationEndpointBytes();

    // Assert
    ByteString byteString = actualConfigurationEndpointBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getApnBytes());
    assertEquals(byteString, defaultInstance.getApnPasswordBytes());
    assertEquals(byteString, defaultInstance.getApnUserNameBytes());
    assertEquals(byteString, defaultInstance.getCloudTokenBytes());
    assertEquals(byteString, actualConfigurationEndpointBytes);
    assertEquals(byteString, defaultInstance.getDataEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataServerIpBytes());
    assertEquals(byteString, defaultInstance.getDeviceInfoEndpointBytes());
    assertSame(byteString, defaultInstance.getEncryptionKey());
    assertSame(byteString, defaultInstance.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getDataEndpoint()}.
   * <p>
   * Method under test: {@link ProtoConfig#getDataEndpoint()}
   */
  @Test
  @DisplayName("Test ProtoConfig getDataEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConfig.getDataEndpoint()"})
  void testProtoConfigGetDataEndpoint() {
    // Arrange, Act and Assert
    assertEquals("", ProtoConfig.getDefaultInstance().getDataEndpoint());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getDataEndpointBytes()}.
   * <p>
   * Method under test: {@link ProtoConfig#getDataEndpointBytes()}
   */
  @Test
  @DisplayName("Test ProtoConfig getDataEndpointBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoConfig.getDataEndpointBytes()"})
  void testProtoConfigGetDataEndpointBytes() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();

    // Act
    ByteString actualDataEndpointBytes = defaultInstance.getDataEndpointBytes();

    // Assert
    ByteString byteString = actualDataEndpointBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getApnBytes());
    assertEquals(byteString, defaultInstance.getApnPasswordBytes());
    assertEquals(byteString, defaultInstance.getApnUserNameBytes());
    assertEquals(byteString, defaultInstance.getCloudTokenBytes());
    assertEquals(byteString, defaultInstance.getConfigurationEndpointBytes());
    assertEquals(byteString, actualDataEndpointBytes);
    assertEquals(byteString, defaultInstance.getDataServerIpBytes());
    assertEquals(byteString, defaultInstance.getDeviceInfoEndpointBytes());
    assertSame(byteString, defaultInstance.getEncryptionKey());
    assertSame(byteString, defaultInstance.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getDataServerIp()}.
   * <p>
   * Method under test: {@link ProtoConfig#getDataServerIp()}
   */
  @Test
  @DisplayName("Test ProtoConfig getDataServerIp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConfig.getDataServerIp()"})
  void testProtoConfigGetDataServerIp() {
    // Arrange, Act and Assert
    assertEquals("", ProtoConfig.getDefaultInstance().getDataServerIp());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getDataServerIpBytes()}.
   * <p>
   * Method under test: {@link ProtoConfig#getDataServerIpBytes()}
   */
  @Test
  @DisplayName("Test ProtoConfig getDataServerIpBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoConfig.getDataServerIpBytes()"})
  void testProtoConfigGetDataServerIpBytes() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();

    // Act
    ByteString actualDataServerIpBytes = defaultInstance.getDataServerIpBytes();

    // Assert
    ByteString byteString = actualDataServerIpBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getApnBytes());
    assertEquals(byteString, defaultInstance.getApnPasswordBytes());
    assertEquals(byteString, defaultInstance.getApnUserNameBytes());
    assertEquals(byteString, defaultInstance.getCloudTokenBytes());
    assertEquals(byteString, defaultInstance.getConfigurationEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataEndpointBytes());
    assertEquals(byteString, actualDataServerIpBytes);
    assertEquals(byteString, defaultInstance.getDeviceInfoEndpointBytes());
    assertSame(byteString, defaultInstance.getEncryptionKey());
    assertSame(byteString, defaultInstance.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ProtoConfig#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoConfig getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.getDefaultInstanceForType()"})
  void testProtoConfigGetDefaultInstanceForType() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getDeviceInfoEndpoint()}.
   * <p>
   * Method under test: {@link ProtoConfig#getDeviceInfoEndpoint()}
   */
  @Test
  @DisplayName("Test ProtoConfig getDeviceInfoEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConfig.getDeviceInfoEndpoint()"})
  void testProtoConfigGetDeviceInfoEndpoint() {
    // Arrange, Act and Assert
    assertEquals("", ProtoConfig.getDefaultInstance().getDeviceInfoEndpoint());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getDeviceInfoEndpointBytes()}.
   * <p>
   * Method under test: {@link ProtoConfig#getDeviceInfoEndpointBytes()}
   */
  @Test
  @DisplayName("Test ProtoConfig getDeviceInfoEndpointBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoConfig.getDeviceInfoEndpointBytes()"})
  void testProtoConfigGetDeviceInfoEndpointBytes() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();

    // Act
    ByteString actualDeviceInfoEndpointBytes = defaultInstance.getDeviceInfoEndpointBytes();

    // Assert
    ByteString byteString = actualDeviceInfoEndpointBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getApnBytes());
    assertEquals(byteString, defaultInstance.getApnPasswordBytes());
    assertEquals(byteString, defaultInstance.getApnUserNameBytes());
    assertEquals(byteString, defaultInstance.getCloudTokenBytes());
    assertEquals(byteString, defaultInstance.getConfigurationEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataServerIpBytes());
    assertEquals(byteString, actualDeviceInfoEndpointBytes);
    assertSame(byteString, defaultInstance.getEncryptionKey());
    assertSame(byteString, defaultInstance.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getDnsServerIpCount()}.
   * <p>
   * Method under test: {@link ProtoConfig#getDnsServerIpCount()}
   */
  @Test
  @DisplayName("Test ProtoConfig getDnsServerIpCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoConfig.getDnsServerIpCount()"})
  void testProtoConfigGetDnsServerIpCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoConfig.getDefaultInstance().getDnsServerIpCount());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getErrorsCount()}.
   * <p>
   * Method under test: {@link ProtoConfig#getErrorsCount()}
   */
  @Test
  @DisplayName("Test ProtoConfig getErrorsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoConfig.getErrorsCount()"})
  void testProtoConfigGetErrorsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoConfig.getDefaultInstance().getErrorsCount());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getLedConfigCount()}.
   * <p>
   * Method under test: {@link ProtoConfig#getLedConfigCount()}
   */
  @Test
  @DisplayName("Test ProtoConfig getLedConfigCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoConfig.getLedConfigCount()"})
  void testProtoConfigGetLedConfigCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoConfig.getDefaultInstance().getLedConfigCount());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getModemUpdateRequest()}.
   * <p>
   * Method under test: {@link ProtoConfig#getModemUpdateRequest()}
   */
  @Test
  @DisplayName("Test ProtoConfig getModemUpdateRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConfig.getModemUpdateRequest()"})
  void testProtoConfigGetModemUpdateRequest() {
    // Arrange, Act and Assert
    assertEquals("", ProtoConfig.getDefaultInstance().getModemUpdateRequest());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getModemUpdateRequestBytes()}.
   * <p>
   * Method under test: {@link ProtoConfig#getModemUpdateRequestBytes()}
   */
  @Test
  @DisplayName("Test ProtoConfig getModemUpdateRequestBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoConfig.getModemUpdateRequestBytes()"})
  void testProtoConfigGetModemUpdateRequestBytes() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();

    // Act
    ByteString actualModemUpdateRequestBytes = defaultInstance.getModemUpdateRequestBytes();

    // Assert
    ByteString byteString = actualModemUpdateRequestBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getApnBytes());
    assertEquals(byteString, defaultInstance.getApnPasswordBytes());
    assertEquals(byteString, defaultInstance.getApnUserNameBytes());
    assertEquals(byteString, defaultInstance.getCloudTokenBytes());
    assertEquals(byteString, defaultInstance.getConfigurationEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataServerIpBytes());
    assertEquals(byteString, defaultInstance.getDeviceInfoEndpointBytes());
    assertEquals(byteString, actualModemUpdateRequestBytes);
    assertSame(byteString, defaultInstance.getEncryptionKey());
    assertSame(byteString, defaultInstance.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getOutputControlStateRequestCount()}.
   * <p>
   * Method under test: {@link ProtoConfig#getOutputControlStateRequestCount()}
   */
  @Test
  @DisplayName("Test ProtoConfig getOutputControlStateRequestCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoConfig.getOutputControlStateRequestCount()"})
  void testProtoConfigGetOutputControlStateRequestCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoConfig.getDefaultInstance().getOutputControlStateRequestCount());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getRulesCount()}.
   * <p>
   * Method under test: {@link ProtoConfig#getRulesCount()}
   */
  @Test
  @DisplayName("Test ProtoConfig getRulesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoConfig.getRulesCount()"})
  void testProtoConfigGetRulesCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoConfig.getDefaultInstance().getRulesCount());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getSerializedSize()}.
   * <p>
   * Method under test: {@link ProtoConfig#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoConfig getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoConfig.getSerializedSize()"})
  void testProtoConfigGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoConfig.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getTimeEndpoint()}.
   * <p>
   * Method under test: {@link ProtoConfig#getTimeEndpoint()}
   */
  @Test
  @DisplayName("Test ProtoConfig getTimeEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConfig.getTimeEndpoint()"})
  void testProtoConfigGetTimeEndpoint() {
    // Arrange, Act and Assert
    assertEquals("", ProtoConfig.getDefaultInstance().getTimeEndpoint());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getTimeEndpointBytes()}.
   * <p>
   * Method under test: {@link ProtoConfig#getTimeEndpointBytes()}
   */
  @Test
  @DisplayName("Test ProtoConfig getTimeEndpointBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoConfig.getTimeEndpointBytes()"})
  void testProtoConfigGetTimeEndpointBytes() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();

    // Act
    ByteString actualTimeEndpointBytes = defaultInstance.getTimeEndpointBytes();

    // Assert
    ByteString byteString = actualTimeEndpointBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getApnBytes());
    assertEquals(byteString, defaultInstance.getApnPasswordBytes());
    assertEquals(byteString, defaultInstance.getApnUserNameBytes());
    assertEquals(byteString, defaultInstance.getCloudTokenBytes());
    assertEquals(byteString, defaultInstance.getConfigurationEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataServerIpBytes());
    assertEquals(byteString, defaultInstance.getDeviceInfoEndpointBytes());
    assertEquals(byteString, actualTimeEndpointBytes);
    assertSame(byteString, defaultInstance.getEncryptionKey());
    assertSame(byteString, defaultInstance.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getUpdateServerIp()}.
   * <p>
   * Method under test: {@link ProtoConfig#getUpdateServerIp()}
   */
  @Test
  @DisplayName("Test ProtoConfig getUpdateServerIp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConfig.getUpdateServerIp()"})
  void testProtoConfigGetUpdateServerIp() {
    // Arrange, Act and Assert
    assertEquals("", ProtoConfig.getDefaultInstance().getUpdateServerIp());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#getUpdateServerIpBytes()}.
   * <p>
   * Method under test: {@link ProtoConfig#getUpdateServerIpBytes()}
   */
  @Test
  @DisplayName("Test ProtoConfig getUpdateServerIpBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoConfig.getUpdateServerIpBytes()"})
  void testProtoConfigGetUpdateServerIpBytes() {
    // Arrange
    ProtoConfig defaultInstance = ProtoConfig.getDefaultInstance();

    // Act
    ByteString actualUpdateServerIpBytes = defaultInstance.getUpdateServerIpBytes();

    // Assert
    ByteString byteString = actualUpdateServerIpBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getApnBytes());
    assertEquals(byteString, defaultInstance.getApnPasswordBytes());
    assertEquals(byteString, defaultInstance.getApnUserNameBytes());
    assertEquals(byteString, defaultInstance.getCloudTokenBytes());
    assertEquals(byteString, defaultInstance.getConfigurationEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataEndpointBytes());
    assertEquals(byteString, defaultInstance.getDataServerIpBytes());
    assertEquals(byteString, defaultInstance.getDeviceInfoEndpointBytes());
    assertEquals(byteString, actualUpdateServerIpBytes);
    assertSame(byteString, defaultInstance.getEncryptionKey());
    assertSame(byteString, defaultInstance.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#hasBleAdvertisingPeriod()}.
   * <p>
   * Method under test: {@link ProtoConfig#hasBleAdvertisingPeriod()}
   */
  @Test
  @DisplayName("Test ProtoConfig hasBleAdvertisingPeriod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoConfig.hasBleAdvertisingPeriod()"})
  void testProtoConfigHasBleAdvertisingPeriod() {
    // Arrange, Act and Assert
    assertFalse(ProtoConfig.getDefaultInstance().hasBleAdvertisingPeriod());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#hasCalibrationParametersRequest()}.
   * <p>
   * Method under test: {@link ProtoConfig#hasCalibrationParametersRequest()}
   */
  @Test
  @DisplayName("Test ProtoConfig hasCalibrationParametersRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoConfig.hasCalibrationParametersRequest()"})
  void testProtoConfigHasCalibrationParametersRequest() {
    // Arrange, Act and Assert
    assertFalse(ProtoConfig.getDefaultInstance().hasCalibrationParametersRequest());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#isInitialized()}.
   * <p>
   * Method under test: {@link ProtoConfig#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoConfig isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoConfig.isInitialized()"})
  void testProtoConfigIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProtoConfig.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseDelimitedFrom(InputStream)"})
  void testProtoConfigParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoConfigParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoConfig actualParseDelimitedFromResult = ProtoConfig.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    ByteString expectedSerialNumber = actualParseDelimitedFromResult.getEncryptionKey();
    assertSame(expectedSerialNumber, actualParseDelimitedFromResult.getSerialNumber());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoConfigParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoConfig actualParseDelimitedFromResult = ProtoConfig.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    ByteString expectedSerialNumber = actualParseDelimitedFromResult.getEncryptionKey();
    assertSame(expectedSerialNumber, actualParseDelimitedFromResult.getSerialNumber());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoConfigParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoConfigParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ProtoConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoConfigParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoConfigParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseDelimitedFrom(InputStream)"})
  void testProtoConfigParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoConfig.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseDelimitedFrom(InputStream)"})
  void testProtoConfigParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoConfig actualParseDelimitedFromResult = ProtoConfig.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    ByteString expectedSerialNumber = actualParseDelimitedFromResult.getEncryptionKey();
    assertSame(expectedSerialNumber, actualParseDelimitedFromResult.getSerialNumber());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseDelimitedFrom(InputStream)"})
  void testProtoConfigParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoConfig actualParseDelimitedFromResult = ProtoConfig.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    ByteString expectedSerialNumber = actualParseDelimitedFromResult.getEncryptionKey();
    assertSame(expectedSerialNumber, actualParseDelimitedFromResult.getSerialNumber());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseDelimitedFrom(InputStream)"})
  void testProtoConfigParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseDelimitedFrom(InputStream)"})
  void testProtoConfigParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ProtoConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(byte[])"})
  void testProtoConfigParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoConfig actualParseFromResult = ProtoConfig.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getApn());
    assertEquals("", actualParseFromResult.getApnPassword());
    assertEquals("", actualParseFromResult.getApnUserName());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getConfigurationEndpoint());
    assertEquals("", actualParseFromResult.getDataEndpoint());
    assertEquals("", actualParseFromResult.getDataServerIp());
    assertEquals("", actualParseFromResult.getDeviceInfoEndpoint());
    assertEquals("", actualParseFromResult.getModemUpdateRequest());
    assertEquals("", actualParseFromResult.getTimeEndpoint());
    assertEquals("", actualParseFromResult.getUpdateServerIp());
    assertEquals(0, actualParseFromResult.getAckInterval());
    assertEquals(0, actualParseFromResult.getBleTurnoffTime());
    assertEquals(0, actualParseFromResult.getBleTxPowerLevel());
    assertEquals(0, actualParseFromResult.getCalendarsCount());
    assertEquals(0, actualParseFromResult.getCellularConfigParamsCount());
    assertEquals(0, actualParseFromResult.getChannelTypesCount());
    assertEquals(0, actualParseFromResult.getCloudTokenCoapOption());
    assertEquals(0, actualParseFromResult.getCloudTokenConfig());
    assertEquals(0, actualParseFromResult.getCurrentTime());
    assertEquals(0, actualParseFromResult.getDataServerPort());
    assertEquals(0, actualParseFromResult.getDisableModemRequest());
    assertEquals(0, actualParseFromResult.getDnsServerIpCount());
    assertEquals(0, actualParseFromResult.getDnsTtlConfig());
    assertEquals(0, actualParseFromResult.getErrorTimestamp());
    assertEquals(0, actualParseFromResult.getErrorsCount());
    assertEquals(0, actualParseFromResult.getHash());
    assertEquals(0, actualParseFromResult.getHashTimestamp());
    assertEquals(0, actualParseFromResult.getLedConfigCount());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseFromResult.getModemBandsMask());
    assertEquals(0, actualParseFromResult.getNetworkTroubleshooting());
    assertEquals(0, actualParseFromResult.getOutputControlStateRequestCount());
    assertEquals(0, actualParseFromResult.getPayloadSignatureCoapOption());
    assertEquals(0, actualParseFromResult.getPayloadSplitInfo());
    assertEquals(0, actualParseFromResult.getPlmnSelection());
    assertEquals(0, actualParseFromResult.getRulesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSupervisionPeriod());
    assertEquals(0, actualParseFromResult.getTransferLimit());
    assertEquals(0, actualParseFromResult.getTransferLimitTimer());
    assertEquals(0, actualParseFromResult.getTransmissionInterval());
    assertEquals(0, actualParseFromResult.getUpdateServerPortCoap());
    assertEquals(0, actualParseFromResult.getUpdateServerPortUdp());
    assertFalse(actualParseFromResult.getAcceptWithoutTesting());
    assertFalse(actualParseFromResult.getMemoryResetRequest());
    assertFalse(actualParseFromResult.getRequestConfiguration());
    assertFalse(actualParseFromResult.getRequestDeviceInfo());
    assertFalse(actualParseFromResult.getRequestFwUpdate());
    assertFalse(actualParseFromResult.getRequestRuntimeErrorsClear());
    assertFalse(actualParseFromResult.hasBleAdvertisingPeriod());
    assertFalse(actualParseFromResult.hasCalibrationParametersRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ProtoCalendar> calendarsList = actualParseFromResult.getCalendarsList();
    assertTrue(calendarsList.isEmpty());
    List<Integer> cellularConfigParamsList = actualParseFromResult.getCellularConfigParamsList();
    assertTrue(cellularConfigParamsList.isEmpty());
    assertTrue(actualParseFromResult.getChannelTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(calendarsList, actualParseFromResult.getCalendarsOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getChannelTypesValueList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getRulesList());
    assertSame(calendarsList, actualParseFromResult.getRulesOrBuilderList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getDnsServerIpList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getErrorsList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getLedConfigList());
    ByteString expectedSerialNumber = actualParseFromResult.getEncryptionKey();
    assertSame(expectedSerialNumber, actualParseFromResult.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(ByteBuffer)"})
  void testProtoConfigParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoConfig actualParseFromResult = ProtoConfig.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getApn());
    assertEquals("", actualParseFromResult.getApnPassword());
    assertEquals("", actualParseFromResult.getApnUserName());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getConfigurationEndpoint());
    assertEquals("", actualParseFromResult.getDataEndpoint());
    assertEquals("", actualParseFromResult.getDataServerIp());
    assertEquals("", actualParseFromResult.getDeviceInfoEndpoint());
    assertEquals("", actualParseFromResult.getModemUpdateRequest());
    assertEquals("", actualParseFromResult.getTimeEndpoint());
    assertEquals("", actualParseFromResult.getUpdateServerIp());
    assertEquals(0, actualParseFromResult.getAckInterval());
    assertEquals(0, actualParseFromResult.getBleTurnoffTime());
    assertEquals(0, actualParseFromResult.getBleTxPowerLevel());
    assertEquals(0, actualParseFromResult.getCalendarsCount());
    assertEquals(0, actualParseFromResult.getCellularConfigParamsCount());
    assertEquals(0, actualParseFromResult.getChannelTypesCount());
    assertEquals(0, actualParseFromResult.getCloudTokenCoapOption());
    assertEquals(0, actualParseFromResult.getCloudTokenConfig());
    assertEquals(0, actualParseFromResult.getCurrentTime());
    assertEquals(0, actualParseFromResult.getDataServerPort());
    assertEquals(0, actualParseFromResult.getDisableModemRequest());
    assertEquals(0, actualParseFromResult.getDnsServerIpCount());
    assertEquals(0, actualParseFromResult.getDnsTtlConfig());
    assertEquals(0, actualParseFromResult.getErrorTimestamp());
    assertEquals(0, actualParseFromResult.getErrorsCount());
    assertEquals(0, actualParseFromResult.getHash());
    assertEquals(0, actualParseFromResult.getHashTimestamp());
    assertEquals(0, actualParseFromResult.getLedConfigCount());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseFromResult.getModemBandsMask());
    assertEquals(0, actualParseFromResult.getNetworkTroubleshooting());
    assertEquals(0, actualParseFromResult.getOutputControlStateRequestCount());
    assertEquals(0, actualParseFromResult.getPayloadSignatureCoapOption());
    assertEquals(0, actualParseFromResult.getPayloadSplitInfo());
    assertEquals(0, actualParseFromResult.getPlmnSelection());
    assertEquals(0, actualParseFromResult.getRulesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSupervisionPeriod());
    assertEquals(0, actualParseFromResult.getTransferLimit());
    assertEquals(0, actualParseFromResult.getTransferLimitTimer());
    assertEquals(0, actualParseFromResult.getTransmissionInterval());
    assertEquals(0, actualParseFromResult.getUpdateServerPortCoap());
    assertEquals(0, actualParseFromResult.getUpdateServerPortUdp());
    assertFalse(actualParseFromResult.getAcceptWithoutTesting());
    assertFalse(actualParseFromResult.getMemoryResetRequest());
    assertFalse(actualParseFromResult.getRequestConfiguration());
    assertFalse(actualParseFromResult.getRequestDeviceInfo());
    assertFalse(actualParseFromResult.getRequestFwUpdate());
    assertFalse(actualParseFromResult.getRequestRuntimeErrorsClear());
    assertFalse(actualParseFromResult.hasBleAdvertisingPeriod());
    assertFalse(actualParseFromResult.hasCalibrationParametersRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ProtoCalendar> calendarsList = actualParseFromResult.getCalendarsList();
    assertTrue(calendarsList.isEmpty());
    List<Integer> cellularConfigParamsList = actualParseFromResult.getCellularConfigParamsList();
    assertTrue(cellularConfigParamsList.isEmpty());
    assertTrue(actualParseFromResult.getChannelTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(calendarsList, actualParseFromResult.getCalendarsOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getChannelTypesValueList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getRulesList());
    assertSame(calendarsList, actualParseFromResult.getRulesOrBuilderList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getDnsServerIpList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getErrorsList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getLedConfigList());
    ByteString expectedSerialNumber = actualParseFromResult.getEncryptionKey();
    assertSame(expectedSerialNumber, actualParseFromResult.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testProtoConfigParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ProtoConfig actualParseFromResult = ProtoConfig.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getApn());
    assertEquals("", actualParseFromResult.getApnPassword());
    assertEquals("", actualParseFromResult.getApnUserName());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getConfigurationEndpoint());
    assertEquals("", actualParseFromResult.getDataEndpoint());
    assertEquals("", actualParseFromResult.getDataServerIp());
    assertEquals("", actualParseFromResult.getDeviceInfoEndpoint());
    assertEquals("", actualParseFromResult.getModemUpdateRequest());
    assertEquals("", actualParseFromResult.getTimeEndpoint());
    assertEquals("", actualParseFromResult.getUpdateServerIp());
    assertEquals(0, actualParseFromResult.getAckInterval());
    assertEquals(0, actualParseFromResult.getBleTurnoffTime());
    assertEquals(0, actualParseFromResult.getBleTxPowerLevel());
    assertEquals(0, actualParseFromResult.getCalendarsCount());
    assertEquals(0, actualParseFromResult.getCellularConfigParamsCount());
    assertEquals(0, actualParseFromResult.getChannelTypesCount());
    assertEquals(0, actualParseFromResult.getCloudTokenCoapOption());
    assertEquals(0, actualParseFromResult.getCloudTokenConfig());
    assertEquals(0, actualParseFromResult.getCurrentTime());
    assertEquals(0, actualParseFromResult.getDataServerPort());
    assertEquals(0, actualParseFromResult.getDisableModemRequest());
    assertEquals(0, actualParseFromResult.getDnsServerIpCount());
    assertEquals(0, actualParseFromResult.getDnsTtlConfig());
    assertEquals(0, actualParseFromResult.getErrorTimestamp());
    assertEquals(0, actualParseFromResult.getErrorsCount());
    assertEquals(0, actualParseFromResult.getHash());
    assertEquals(0, actualParseFromResult.getHashTimestamp());
    assertEquals(0, actualParseFromResult.getLedConfigCount());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseFromResult.getModemBandsMask());
    assertEquals(0, actualParseFromResult.getNetworkTroubleshooting());
    assertEquals(0, actualParseFromResult.getOutputControlStateRequestCount());
    assertEquals(0, actualParseFromResult.getPayloadSignatureCoapOption());
    assertEquals(0, actualParseFromResult.getPayloadSplitInfo());
    assertEquals(0, actualParseFromResult.getPlmnSelection());
    assertEquals(0, actualParseFromResult.getRulesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSupervisionPeriod());
    assertEquals(0, actualParseFromResult.getTransferLimit());
    assertEquals(0, actualParseFromResult.getTransferLimitTimer());
    assertEquals(0, actualParseFromResult.getTransmissionInterval());
    assertEquals(0, actualParseFromResult.getUpdateServerPortCoap());
    assertEquals(0, actualParseFromResult.getUpdateServerPortUdp());
    assertFalse(actualParseFromResult.getAcceptWithoutTesting());
    assertFalse(actualParseFromResult.getMemoryResetRequest());
    assertFalse(actualParseFromResult.getRequestConfiguration());
    assertFalse(actualParseFromResult.getRequestDeviceInfo());
    assertFalse(actualParseFromResult.getRequestFwUpdate());
    assertFalse(actualParseFromResult.getRequestRuntimeErrorsClear());
    assertFalse(actualParseFromResult.hasBleAdvertisingPeriod());
    assertFalse(actualParseFromResult.hasCalibrationParametersRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ProtoCalendar> calendarsList = actualParseFromResult.getCalendarsList();
    assertTrue(calendarsList.isEmpty());
    List<Integer> cellularConfigParamsList = actualParseFromResult.getCellularConfigParamsList();
    assertTrue(cellularConfigParamsList.isEmpty());
    assertTrue(actualParseFromResult.getChannelTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(calendarsList, actualParseFromResult.getCalendarsOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getChannelTypesValueList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getRulesList());
    assertSame(calendarsList, actualParseFromResult.getRulesOrBuilderList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getDnsServerIpList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getErrorsList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getLedConfigList());
    ByteString expectedSerialNumber = actualParseFromResult.getEncryptionKey();
    assertSame(expectedSerialNumber, actualParseFromResult.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoConfigParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoConfig actualParseFromResult = ProtoConfig.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getApn());
    assertEquals("", actualParseFromResult.getApnPassword());
    assertEquals("", actualParseFromResult.getApnUserName());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getConfigurationEndpoint());
    assertEquals("", actualParseFromResult.getDataEndpoint());
    assertEquals("", actualParseFromResult.getDataServerIp());
    assertEquals("", actualParseFromResult.getDeviceInfoEndpoint());
    assertEquals("", actualParseFromResult.getModemUpdateRequest());
    assertEquals("", actualParseFromResult.getTimeEndpoint());
    assertEquals("", actualParseFromResult.getUpdateServerIp());
    assertEquals(0, actualParseFromResult.getAckInterval());
    assertEquals(0, actualParseFromResult.getBleTurnoffTime());
    assertEquals(0, actualParseFromResult.getBleTxPowerLevel());
    assertEquals(0, actualParseFromResult.getCalendarsCount());
    assertEquals(0, actualParseFromResult.getCellularConfigParamsCount());
    assertEquals(0, actualParseFromResult.getChannelTypesCount());
    assertEquals(0, actualParseFromResult.getCloudTokenCoapOption());
    assertEquals(0, actualParseFromResult.getCloudTokenConfig());
    assertEquals(0, actualParseFromResult.getCurrentTime());
    assertEquals(0, actualParseFromResult.getDataServerPort());
    assertEquals(0, actualParseFromResult.getDisableModemRequest());
    assertEquals(0, actualParseFromResult.getDnsServerIpCount());
    assertEquals(0, actualParseFromResult.getDnsTtlConfig());
    assertEquals(0, actualParseFromResult.getErrorTimestamp());
    assertEquals(0, actualParseFromResult.getErrorsCount());
    assertEquals(0, actualParseFromResult.getHash());
    assertEquals(0, actualParseFromResult.getHashTimestamp());
    assertEquals(0, actualParseFromResult.getLedConfigCount());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseFromResult.getModemBandsMask());
    assertEquals(0, actualParseFromResult.getNetworkTroubleshooting());
    assertEquals(0, actualParseFromResult.getOutputControlStateRequestCount());
    assertEquals(0, actualParseFromResult.getPayloadSignatureCoapOption());
    assertEquals(0, actualParseFromResult.getPayloadSplitInfo());
    assertEquals(0, actualParseFromResult.getPlmnSelection());
    assertEquals(0, actualParseFromResult.getRulesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSupervisionPeriod());
    assertEquals(0, actualParseFromResult.getTransferLimit());
    assertEquals(0, actualParseFromResult.getTransferLimitTimer());
    assertEquals(0, actualParseFromResult.getTransmissionInterval());
    assertEquals(0, actualParseFromResult.getUpdateServerPortCoap());
    assertEquals(0, actualParseFromResult.getUpdateServerPortUdp());
    assertFalse(actualParseFromResult.getAcceptWithoutTesting());
    assertFalse(actualParseFromResult.getMemoryResetRequest());
    assertFalse(actualParseFromResult.getRequestConfiguration());
    assertFalse(actualParseFromResult.getRequestDeviceInfo());
    assertFalse(actualParseFromResult.getRequestFwUpdate());
    assertFalse(actualParseFromResult.getRequestRuntimeErrorsClear());
    assertFalse(actualParseFromResult.hasBleAdvertisingPeriod());
    assertFalse(actualParseFromResult.hasCalibrationParametersRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ProtoCalendar> calendarsList = actualParseFromResult.getCalendarsList();
    assertTrue(calendarsList.isEmpty());
    List<Integer> cellularConfigParamsList = actualParseFromResult.getCellularConfigParamsList();
    assertTrue(cellularConfigParamsList.isEmpty());
    assertTrue(actualParseFromResult.getChannelTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(calendarsList, actualParseFromResult.getCalendarsOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getChannelTypesValueList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getRulesList());
    assertSame(calendarsList, actualParseFromResult.getRulesOrBuilderList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getDnsServerIpList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getErrorsList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getLedConfigList());
    ByteString expectedSerialNumber = actualParseFromResult.getEncryptionKey();
    assertSame(expectedSerialNumber, actualParseFromResult.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(ByteString)"})
  void testProtoConfigParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoConfig actualParseFromResult = ProtoConfig.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getApn());
    assertEquals("", actualParseFromResult.getApnPassword());
    assertEquals("", actualParseFromResult.getApnUserName());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getConfigurationEndpoint());
    assertEquals("", actualParseFromResult.getDataEndpoint());
    assertEquals("", actualParseFromResult.getDataServerIp());
    assertEquals("", actualParseFromResult.getDeviceInfoEndpoint());
    assertEquals("", actualParseFromResult.getModemUpdateRequest());
    assertEquals("", actualParseFromResult.getTimeEndpoint());
    assertEquals("", actualParseFromResult.getUpdateServerIp());
    assertEquals(0, actualParseFromResult.getAckInterval());
    assertEquals(0, actualParseFromResult.getBleTurnoffTime());
    assertEquals(0, actualParseFromResult.getBleTxPowerLevel());
    assertEquals(0, actualParseFromResult.getCalendarsCount());
    assertEquals(0, actualParseFromResult.getCellularConfigParamsCount());
    assertEquals(0, actualParseFromResult.getChannelTypesCount());
    assertEquals(0, actualParseFromResult.getCloudTokenCoapOption());
    assertEquals(0, actualParseFromResult.getCloudTokenConfig());
    assertEquals(0, actualParseFromResult.getCurrentTime());
    assertEquals(0, actualParseFromResult.getDataServerPort());
    assertEquals(0, actualParseFromResult.getDisableModemRequest());
    assertEquals(0, actualParseFromResult.getDnsServerIpCount());
    assertEquals(0, actualParseFromResult.getDnsTtlConfig());
    assertEquals(0, actualParseFromResult.getErrorTimestamp());
    assertEquals(0, actualParseFromResult.getErrorsCount());
    assertEquals(0, actualParseFromResult.getHash());
    assertEquals(0, actualParseFromResult.getHashTimestamp());
    assertEquals(0, actualParseFromResult.getLedConfigCount());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseFromResult.getModemBandsMask());
    assertEquals(0, actualParseFromResult.getNetworkTroubleshooting());
    assertEquals(0, actualParseFromResult.getOutputControlStateRequestCount());
    assertEquals(0, actualParseFromResult.getPayloadSignatureCoapOption());
    assertEquals(0, actualParseFromResult.getPayloadSplitInfo());
    assertEquals(0, actualParseFromResult.getPlmnSelection());
    assertEquals(0, actualParseFromResult.getRulesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSupervisionPeriod());
    assertEquals(0, actualParseFromResult.getTransferLimit());
    assertEquals(0, actualParseFromResult.getTransferLimitTimer());
    assertEquals(0, actualParseFromResult.getTransmissionInterval());
    assertEquals(0, actualParseFromResult.getUpdateServerPortCoap());
    assertEquals(0, actualParseFromResult.getUpdateServerPortUdp());
    assertFalse(actualParseFromResult.getAcceptWithoutTesting());
    assertFalse(actualParseFromResult.getMemoryResetRequest());
    assertFalse(actualParseFromResult.getRequestConfiguration());
    assertFalse(actualParseFromResult.getRequestDeviceInfo());
    assertFalse(actualParseFromResult.getRequestFwUpdate());
    assertFalse(actualParseFromResult.getRequestRuntimeErrorsClear());
    assertFalse(actualParseFromResult.hasBleAdvertisingPeriod());
    assertFalse(actualParseFromResult.hasCalibrationParametersRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ProtoCalendar> calendarsList = actualParseFromResult.getCalendarsList();
    assertTrue(calendarsList.isEmpty());
    List<Integer> cellularConfigParamsList = actualParseFromResult.getCellularConfigParamsList();
    assertTrue(cellularConfigParamsList.isEmpty());
    assertTrue(actualParseFromResult.getChannelTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getApnBytes());
    assertEquals(byteString, actualParseFromResult.getApnPasswordBytes());
    assertEquals(byteString, actualParseFromResult.getApnUserNameBytes());
    assertEquals(byteString, actualParseFromResult.getCloudTokenBytes());
    assertEquals(byteString, actualParseFromResult.getConfigurationEndpointBytes());
    assertEquals(byteString, actualParseFromResult.getDataEndpointBytes());
    assertEquals(byteString, actualParseFromResult.getDataServerIpBytes());
    assertEquals(byteString, actualParseFromResult.getDeviceInfoEndpointBytes());
    assertSame(calendarsList, actualParseFromResult.getCalendarsOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getChannelTypesValueList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getRulesList());
    assertSame(calendarsList, actualParseFromResult.getRulesOrBuilderList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getDnsServerIpList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getErrorsList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getLedConfigList());
    assertSame(byteString, actualParseFromResult.getEncryptionKey());
    assertSame(byteString, actualParseFromResult.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoConfigParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoConfig actualParseFromResult = ProtoConfig.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getApn());
    assertEquals("", actualParseFromResult.getApnPassword());
    assertEquals("", actualParseFromResult.getApnUserName());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getConfigurationEndpoint());
    assertEquals("", actualParseFromResult.getDataEndpoint());
    assertEquals("", actualParseFromResult.getDataServerIp());
    assertEquals("", actualParseFromResult.getDeviceInfoEndpoint());
    assertEquals("", actualParseFromResult.getModemUpdateRequest());
    assertEquals("", actualParseFromResult.getTimeEndpoint());
    assertEquals("", actualParseFromResult.getUpdateServerIp());
    assertEquals(0, actualParseFromResult.getAckInterval());
    assertEquals(0, actualParseFromResult.getBleTurnoffTime());
    assertEquals(0, actualParseFromResult.getBleTxPowerLevel());
    assertEquals(0, actualParseFromResult.getCalendarsCount());
    assertEquals(0, actualParseFromResult.getCellularConfigParamsCount());
    assertEquals(0, actualParseFromResult.getChannelTypesCount());
    assertEquals(0, actualParseFromResult.getCloudTokenCoapOption());
    assertEquals(0, actualParseFromResult.getCloudTokenConfig());
    assertEquals(0, actualParseFromResult.getCurrentTime());
    assertEquals(0, actualParseFromResult.getDataServerPort());
    assertEquals(0, actualParseFromResult.getDisableModemRequest());
    assertEquals(0, actualParseFromResult.getDnsServerIpCount());
    assertEquals(0, actualParseFromResult.getDnsTtlConfig());
    assertEquals(0, actualParseFromResult.getErrorTimestamp());
    assertEquals(0, actualParseFromResult.getErrorsCount());
    assertEquals(0, actualParseFromResult.getHash());
    assertEquals(0, actualParseFromResult.getHashTimestamp());
    assertEquals(0, actualParseFromResult.getLedConfigCount());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseFromResult.getModemBandsMask());
    assertEquals(0, actualParseFromResult.getNetworkTroubleshooting());
    assertEquals(0, actualParseFromResult.getOutputControlStateRequestCount());
    assertEquals(0, actualParseFromResult.getPayloadSignatureCoapOption());
    assertEquals(0, actualParseFromResult.getPayloadSplitInfo());
    assertEquals(0, actualParseFromResult.getPlmnSelection());
    assertEquals(0, actualParseFromResult.getRulesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSupervisionPeriod());
    assertEquals(0, actualParseFromResult.getTransferLimit());
    assertEquals(0, actualParseFromResult.getTransferLimitTimer());
    assertEquals(0, actualParseFromResult.getTransmissionInterval());
    assertEquals(0, actualParseFromResult.getUpdateServerPortCoap());
    assertEquals(0, actualParseFromResult.getUpdateServerPortUdp());
    assertFalse(actualParseFromResult.getAcceptWithoutTesting());
    assertFalse(actualParseFromResult.getMemoryResetRequest());
    assertFalse(actualParseFromResult.getRequestConfiguration());
    assertFalse(actualParseFromResult.getRequestDeviceInfo());
    assertFalse(actualParseFromResult.getRequestFwUpdate());
    assertFalse(actualParseFromResult.getRequestRuntimeErrorsClear());
    assertFalse(actualParseFromResult.hasBleAdvertisingPeriod());
    assertFalse(actualParseFromResult.hasCalibrationParametersRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ProtoCalendar> calendarsList = actualParseFromResult.getCalendarsList();
    assertTrue(calendarsList.isEmpty());
    List<Integer> cellularConfigParamsList = actualParseFromResult.getCellularConfigParamsList();
    assertTrue(cellularConfigParamsList.isEmpty());
    assertTrue(actualParseFromResult.getChannelTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getApnBytes());
    assertEquals(byteString, actualParseFromResult.getApnPasswordBytes());
    assertEquals(byteString, actualParseFromResult.getApnUserNameBytes());
    assertEquals(byteString, actualParseFromResult.getCloudTokenBytes());
    assertEquals(byteString, actualParseFromResult.getConfigurationEndpointBytes());
    assertEquals(byteString, actualParseFromResult.getDataEndpointBytes());
    assertEquals(byteString, actualParseFromResult.getDataServerIpBytes());
    assertEquals(byteString, actualParseFromResult.getDeviceInfoEndpointBytes());
    assertSame(calendarsList, actualParseFromResult.getCalendarsOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getChannelTypesValueList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getRulesList());
    assertSame(calendarsList, actualParseFromResult.getRulesOrBuilderList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getDnsServerIpList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getErrorsList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getLedConfigList());
    assertSame(byteString, actualParseFromResult.getEncryptionKey());
    assertSame(byteString, actualParseFromResult.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(CodedInputStream)"})
  void testProtoConfigParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoConfig actualParseFromResult = ProtoConfig.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getApn());
    assertEquals("", actualParseFromResult.getApnPassword());
    assertEquals("", actualParseFromResult.getApnUserName());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getConfigurationEndpoint());
    assertEquals("", actualParseFromResult.getDataEndpoint());
    assertEquals("", actualParseFromResult.getDataServerIp());
    assertEquals("", actualParseFromResult.getDeviceInfoEndpoint());
    assertEquals("", actualParseFromResult.getModemUpdateRequest());
    assertEquals("", actualParseFromResult.getTimeEndpoint());
    assertEquals("", actualParseFromResult.getUpdateServerIp());
    assertEquals(0, actualParseFromResult.getAckInterval());
    assertEquals(0, actualParseFromResult.getBleTurnoffTime());
    assertEquals(0, actualParseFromResult.getBleTxPowerLevel());
    assertEquals(0, actualParseFromResult.getCalendarsCount());
    assertEquals(0, actualParseFromResult.getCellularConfigParamsCount());
    assertEquals(0, actualParseFromResult.getChannelTypesCount());
    assertEquals(0, actualParseFromResult.getCloudTokenCoapOption());
    assertEquals(0, actualParseFromResult.getCloudTokenConfig());
    assertEquals(0, actualParseFromResult.getCurrentTime());
    assertEquals(0, actualParseFromResult.getDataServerPort());
    assertEquals(0, actualParseFromResult.getDisableModemRequest());
    assertEquals(0, actualParseFromResult.getDnsServerIpCount());
    assertEquals(0, actualParseFromResult.getDnsTtlConfig());
    assertEquals(0, actualParseFromResult.getErrorTimestamp());
    assertEquals(0, actualParseFromResult.getErrorsCount());
    assertEquals(0, actualParseFromResult.getHash());
    assertEquals(0, actualParseFromResult.getHashTimestamp());
    assertEquals(0, actualParseFromResult.getLedConfigCount());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseFromResult.getModemBandsMask());
    assertEquals(0, actualParseFromResult.getNetworkTroubleshooting());
    assertEquals(0, actualParseFromResult.getOutputControlStateRequestCount());
    assertEquals(0, actualParseFromResult.getPayloadSignatureCoapOption());
    assertEquals(0, actualParseFromResult.getPayloadSplitInfo());
    assertEquals(0, actualParseFromResult.getPlmnSelection());
    assertEquals(0, actualParseFromResult.getRulesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSupervisionPeriod());
    assertEquals(0, actualParseFromResult.getTransferLimit());
    assertEquals(0, actualParseFromResult.getTransferLimitTimer());
    assertEquals(0, actualParseFromResult.getTransmissionInterval());
    assertEquals(0, actualParseFromResult.getUpdateServerPortCoap());
    assertEquals(0, actualParseFromResult.getUpdateServerPortUdp());
    assertFalse(actualParseFromResult.getAcceptWithoutTesting());
    assertFalse(actualParseFromResult.getMemoryResetRequest());
    assertFalse(actualParseFromResult.getRequestConfiguration());
    assertFalse(actualParseFromResult.getRequestDeviceInfo());
    assertFalse(actualParseFromResult.getRequestFwUpdate());
    assertFalse(actualParseFromResult.getRequestRuntimeErrorsClear());
    assertFalse(actualParseFromResult.hasBleAdvertisingPeriod());
    assertFalse(actualParseFromResult.hasCalibrationParametersRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ProtoCalendar> calendarsList = actualParseFromResult.getCalendarsList();
    assertTrue(calendarsList.isEmpty());
    List<Integer> cellularConfigParamsList = actualParseFromResult.getCellularConfigParamsList();
    assertTrue(cellularConfigParamsList.isEmpty());
    assertTrue(actualParseFromResult.getChannelTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(calendarsList, actualParseFromResult.getCalendarsOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getChannelTypesValueList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getRulesList());
    assertSame(calendarsList, actualParseFromResult.getRulesOrBuilderList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getDnsServerIpList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getErrorsList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getLedConfigList());
    ByteString expectedSerialNumber = actualParseFromResult.getEncryptionKey();
    assertSame(expectedSerialNumber, actualParseFromResult.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoConfigParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoConfig actualParseFromResult = ProtoConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getApn());
    assertEquals("", actualParseFromResult.getApnPassword());
    assertEquals("", actualParseFromResult.getApnUserName());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getConfigurationEndpoint());
    assertEquals("", actualParseFromResult.getDataEndpoint());
    assertEquals("", actualParseFromResult.getDataServerIp());
    assertEquals("", actualParseFromResult.getDeviceInfoEndpoint());
    assertEquals("", actualParseFromResult.getModemUpdateRequest());
    assertEquals("", actualParseFromResult.getTimeEndpoint());
    assertEquals("", actualParseFromResult.getUpdateServerIp());
    assertEquals(0, actualParseFromResult.getAckInterval());
    assertEquals(0, actualParseFromResult.getBleTurnoffTime());
    assertEquals(0, actualParseFromResult.getBleTxPowerLevel());
    assertEquals(0, actualParseFromResult.getCalendarsCount());
    assertEquals(0, actualParseFromResult.getCellularConfigParamsCount());
    assertEquals(0, actualParseFromResult.getChannelTypesCount());
    assertEquals(0, actualParseFromResult.getCloudTokenCoapOption());
    assertEquals(0, actualParseFromResult.getCloudTokenConfig());
    assertEquals(0, actualParseFromResult.getCurrentTime());
    assertEquals(0, actualParseFromResult.getDataServerPort());
    assertEquals(0, actualParseFromResult.getDisableModemRequest());
    assertEquals(0, actualParseFromResult.getDnsServerIpCount());
    assertEquals(0, actualParseFromResult.getDnsTtlConfig());
    assertEquals(0, actualParseFromResult.getErrorTimestamp());
    assertEquals(0, actualParseFromResult.getErrorsCount());
    assertEquals(0, actualParseFromResult.getHash());
    assertEquals(0, actualParseFromResult.getHashTimestamp());
    assertEquals(0, actualParseFromResult.getLedConfigCount());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseFromResult.getModemBandsMask());
    assertEquals(0, actualParseFromResult.getNetworkTroubleshooting());
    assertEquals(0, actualParseFromResult.getOutputControlStateRequestCount());
    assertEquals(0, actualParseFromResult.getPayloadSignatureCoapOption());
    assertEquals(0, actualParseFromResult.getPayloadSplitInfo());
    assertEquals(0, actualParseFromResult.getPlmnSelection());
    assertEquals(0, actualParseFromResult.getRulesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSupervisionPeriod());
    assertEquals(0, actualParseFromResult.getTransferLimit());
    assertEquals(0, actualParseFromResult.getTransferLimitTimer());
    assertEquals(0, actualParseFromResult.getTransmissionInterval());
    assertEquals(0, actualParseFromResult.getUpdateServerPortCoap());
    assertEquals(0, actualParseFromResult.getUpdateServerPortUdp());
    assertFalse(actualParseFromResult.getAcceptWithoutTesting());
    assertFalse(actualParseFromResult.getMemoryResetRequest());
    assertFalse(actualParseFromResult.getRequestConfiguration());
    assertFalse(actualParseFromResult.getRequestDeviceInfo());
    assertFalse(actualParseFromResult.getRequestFwUpdate());
    assertFalse(actualParseFromResult.getRequestRuntimeErrorsClear());
    assertFalse(actualParseFromResult.hasBleAdvertisingPeriod());
    assertFalse(actualParseFromResult.hasCalibrationParametersRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ProtoCalendar> calendarsList = actualParseFromResult.getCalendarsList();
    assertTrue(calendarsList.isEmpty());
    List<Integer> cellularConfigParamsList = actualParseFromResult.getCellularConfigParamsList();
    assertTrue(cellularConfigParamsList.isEmpty());
    assertTrue(actualParseFromResult.getChannelTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(calendarsList, actualParseFromResult.getCalendarsOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getChannelTypesValueList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getRulesList());
    assertSame(calendarsList, actualParseFromResult.getRulesOrBuilderList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getDnsServerIpList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getErrorsList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getLedConfigList());
    ByteString expectedSerialNumber = actualParseFromResult.getEncryptionKey();
    assertSame(expectedSerialNumber, actualParseFromResult.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(InputStream)"})
  void testProtoConfigParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ProtoConfig actualParseFromResult = ProtoConfig.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedSerialNumber = actualParseFromResult.getEncryptionKey();
    assertSame(expectedSerialNumber, actualParseFromResult.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoConfigParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ProtoConfig actualParseFromResult = ProtoConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getApn());
    assertEquals("", actualParseFromResult.getApnPassword());
    assertEquals("", actualParseFromResult.getApnUserName());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals("", actualParseFromResult.getConfigurationEndpoint());
    assertEquals("", actualParseFromResult.getDataEndpoint());
    assertEquals("", actualParseFromResult.getDataServerIp());
    assertEquals("", actualParseFromResult.getDeviceInfoEndpoint());
    assertEquals("", actualParseFromResult.getModemUpdateRequest());
    assertEquals("", actualParseFromResult.getTimeEndpoint());
    assertEquals("", actualParseFromResult.getUpdateServerIp());
    assertEquals(0, actualParseFromResult.getAckInterval());
    assertEquals(0, actualParseFromResult.getBleTurnoffTime());
    assertEquals(0, actualParseFromResult.getBleTxPowerLevel());
    assertEquals(0, actualParseFromResult.getCalendarsCount());
    assertEquals(0, actualParseFromResult.getCellularConfigParamsCount());
    assertEquals(0, actualParseFromResult.getChannelTypesCount());
    assertEquals(0, actualParseFromResult.getCloudTokenCoapOption());
    assertEquals(0, actualParseFromResult.getCloudTokenConfig());
    assertEquals(0, actualParseFromResult.getCurrentTime());
    assertEquals(0, actualParseFromResult.getDataServerPort());
    assertEquals(0, actualParseFromResult.getDisableModemRequest());
    assertEquals(0, actualParseFromResult.getDnsServerIpCount());
    assertEquals(0, actualParseFromResult.getDnsTtlConfig());
    assertEquals(0, actualParseFromResult.getErrorTimestamp());
    assertEquals(0, actualParseFromResult.getErrorsCount());
    assertEquals(0, actualParseFromResult.getHash());
    assertEquals(0, actualParseFromResult.getHashTimestamp());
    assertEquals(0, actualParseFromResult.getLedConfigCount());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseFromResult.getModemBandsMask());
    assertEquals(0, actualParseFromResult.getNetworkTroubleshooting());
    assertEquals(0, actualParseFromResult.getOutputControlStateRequestCount());
    assertEquals(0, actualParseFromResult.getPayloadSignatureCoapOption());
    assertEquals(0, actualParseFromResult.getPayloadSplitInfo());
    assertEquals(0, actualParseFromResult.getPlmnSelection());
    assertEquals(0, actualParseFromResult.getRulesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSupervisionPeriod());
    assertEquals(0, actualParseFromResult.getTransferLimit());
    assertEquals(0, actualParseFromResult.getTransferLimitTimer());
    assertEquals(0, actualParseFromResult.getTransmissionInterval());
    assertEquals(0, actualParseFromResult.getUpdateServerPortCoap());
    assertEquals(0, actualParseFromResult.getUpdateServerPortUdp());
    assertFalse(actualParseFromResult.getAcceptWithoutTesting());
    assertFalse(actualParseFromResult.getMemoryResetRequest());
    assertFalse(actualParseFromResult.getRequestConfiguration());
    assertFalse(actualParseFromResult.getRequestDeviceInfo());
    assertFalse(actualParseFromResult.getRequestFwUpdate());
    assertFalse(actualParseFromResult.getRequestRuntimeErrorsClear());
    assertFalse(actualParseFromResult.hasBleAdvertisingPeriod());
    assertFalse(actualParseFromResult.hasCalibrationParametersRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ProtoCalendar> calendarsList = actualParseFromResult.getCalendarsList();
    assertTrue(calendarsList.isEmpty());
    List<Integer> cellularConfigParamsList = actualParseFromResult.getCellularConfigParamsList();
    assertTrue(cellularConfigParamsList.isEmpty());
    assertTrue(actualParseFromResult.getChannelTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(calendarsList, actualParseFromResult.getCalendarsOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getChannelTypesValueList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestList());
    assertSame(calendarsList, actualParseFromResult.getOutputControlStateRequestOrBuilderList());
    assertSame(calendarsList, actualParseFromResult.getRulesList());
    assertSame(calendarsList, actualParseFromResult.getRulesOrBuilderList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getDnsServerIpList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getErrorsList());
    assertSame(cellularConfigParamsList, actualParseFromResult.getLedConfigList());
    ByteString expectedSerialNumber = actualParseFromResult.getEncryptionKey();
    assertSame(expectedSerialNumber, actualParseFromResult.getSerialNumber());
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoConfigParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoConfigParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(InputStream)"})
  void testProtoConfigParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(InputStream)"})
  void testProtoConfigParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoConfig {@link ProtoConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoConfig parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoConfig ProtoConfig.parseFrom(InputStream)"})
  void testProtoConfigParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ProtoConfig actualParseFromResult = ProtoConfig.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedSerialNumber = actualParseFromResult.getEncryptionKey();
    assertSame(expectedSerialNumber, actualParseFromResult.getSerialNumber());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#equals(Object)}, and {@link ProtoOutputControlState#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoOutputControlState#equals(Object)}
   *   <li>{@link ProtoOutputControlState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoOutputControlState equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoOutputControlState.equals(Object)", "int ProtoOutputControlState.hashCode()"})
  void testProtoOutputControlStateEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoOutputControlState defaultInstance = ProtoOutputControlState.getDefaultInstance();
    ProtoOutputControlState defaultInstance2 = ProtoOutputControlState.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#equals(Object)}, and {@link ProtoOutputControlState#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoOutputControlState#equals(Object)}
   *   <li>{@link ProtoOutputControlState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoOutputControlState equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoOutputControlState.equals(Object)", "int ProtoOutputControlState.hashCode()"})
  void testProtoOutputControlStateEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProtoOutputControlState defaultInstance = ProtoOutputControlState.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoOutputControlState#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoOutputControlState.equals(Object)", "int ProtoOutputControlState.hashCode()"})
  void testProtoOutputControlStateEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoOutputControlState.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoOutputControlState#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoOutputControlState.equals(Object)", "int ProtoOutputControlState.hashCode()"})
  void testProtoOutputControlStateEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoOutputControlState.getDefaultInstance(), null);
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoOutputControlState#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoOutputControlState.equals(Object)", "int ProtoOutputControlState.hashCode()"})
  void testProtoOutputControlStateEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoOutputControlState.getDefaultInstance(), "Different type to ProtoOutputControlState");
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.getDefaultInstanceForType()"})
  void testProtoOutputControlStateGetDefaultInstanceForType() {
    // Arrange
    ProtoOutputControlState defaultInstance = ProtoOutputControlState.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#getSerializedSize()}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoOutputControlState.getSerializedSize()"})
  void testProtoOutputControlStateGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoOutputControlState.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#isInitialized()}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoOutputControlState.isInitialized()"})
  void testProtoOutputControlStateIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProtoOutputControlState.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseDelimitedFrom(InputStream)"})
  void testProtoOutputControlStateParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoOutputControlState actualParseDelimitedFromResult = ProtoOutputControlState.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getChannelIndex());
    assertEquals(0, actualParseDelimitedFromResult.getChannelState());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseDelimitedFrom(InputStream)"})
  void testProtoOutputControlStateParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoOutputControlState.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoOutputControlState ProtoOutputControlState.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoOutputControlStateParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoOutputControlState actualParseDelimitedFromResult = ProtoOutputControlState.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getChannelIndex());
    assertEquals(0, actualParseDelimitedFromResult.getChannelState());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoOutputControlState ProtoOutputControlState.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoOutputControlStateParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoOutputControlState.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoOutputControlState ProtoOutputControlState.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoOutputControlStateParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoOutputControlState.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoOutputControlState ProtoOutputControlState.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoOutputControlStateParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoOutputControlState.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseDelimitedFrom(InputStream)"})
  void testProtoOutputControlStateParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoOutputControlState.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseDelimitedFrom(InputStream)"})
  void testProtoOutputControlStateParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoOutputControlState.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(byte[])"})
  void testProtoOutputControlStateParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoOutputControlState actualParseFromResult = ProtoOutputControlState.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getChannelIndex());
    assertEquals(0, actualParseFromResult.getChannelState());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(ByteBuffer)"})
  void testProtoOutputControlStateParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoOutputControlState actualParseFromResult = ProtoOutputControlState.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getChannelIndex());
    assertEquals(0, actualParseFromResult.getChannelState());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testProtoOutputControlStateParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ProtoOutputControlState actualParseFromResult = ProtoOutputControlState.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getChannelIndex());
    assertEquals(0, actualParseFromResult.getChannelState());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoOutputControlStateParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoOutputControlState actualParseFromResult = ProtoOutputControlState.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getChannelIndex());
    assertEquals(0, actualParseFromResult.getChannelState());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(ByteString)"})
  void testProtoOutputControlStateParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoOutputControlState actualParseFromResult = ProtoOutputControlState.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getChannelIndex());
    assertEquals(0, actualParseFromResult.getChannelState());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoOutputControlStateParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoOutputControlState actualParseFromResult = ProtoOutputControlState.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getChannelIndex());
    assertEquals(0, actualParseFromResult.getChannelState());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(CodedInputStream)"})
  void testProtoOutputControlStateParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoOutputControlState actualParseFromResult = ProtoOutputControlState.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getChannelIndex());
    assertEquals(0, actualParseFromResult.getChannelState());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProtoOutputControlState ProtoOutputControlState.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoOutputControlStateParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoOutputControlState actualParseFromResult = ProtoOutputControlState.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getChannelIndex());
    assertEquals(0, actualParseFromResult.getChannelState());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(InputStream)"})
  void testProtoOutputControlStateParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ProtoOutputControlState actualParseFromResult = ProtoOutputControlState
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(InputStream)"})
  void testProtoOutputControlStateParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoOutputControlState.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoOutputControlStateParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ProtoOutputControlState actualParseFromResult = ProtoOutputControlState.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getChannelIndex());
    assertEquals(0, actualParseFromResult.getChannelState());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoOutputControlStateParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoOutputControlState.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoOutputControlStateParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoOutputControlState.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(InputStream)"})
  void testProtoOutputControlStateParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoOutputControlState.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoOutputControlState {@link ProtoOutputControlState#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoOutputControlState#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoOutputControlState parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoOutputControlState ProtoOutputControlState.parseFrom(InputStream)"})
  void testProtoOutputControlStateParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ProtoOutputControlState actualParseFromResult = ProtoOutputControlState.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }
}
