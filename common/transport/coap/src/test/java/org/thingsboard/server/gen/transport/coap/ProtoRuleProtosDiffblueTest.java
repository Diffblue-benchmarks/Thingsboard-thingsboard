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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.coap.ConfigProtos.ProtoConfig;
import org.thingsboard.server.gen.transport.coap.ProtoRuleProtos.Action;
import org.thingsboard.server.gen.transport.coap.ProtoRuleProtos.CalendarType;
import org.thingsboard.server.gen.transport.coap.ProtoRuleProtos.Condition;
import org.thingsboard.server.gen.transport.coap.ProtoRuleProtos.LogicOperator;
import org.thingsboard.server.gen.transport.coap.ProtoRuleProtos.ProtoCalendar;
import org.thingsboard.server.gen.transport.coap.ProtoRuleProtos.ProtoRule;

class ProtoRuleProtosDiffblueTest {
  /**
   * Test Action {@link Action#forNumber(int)}.
   * <ul>
   *   <li>When {@link ProtoConfig#DNS_SERVER_IP_FIELD_NUMBER}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#forNumber(int)}
   */
  @Test
  @DisplayName("Test Action forNumber(int); when DNS_SERVER_IP_FIELD_NUMBER; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Action Action.forNumber(int)"})
  void testActionForNumber_whenDns_server_ip_field_number_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Action.forNumber(ProtoConfig.DNS_SERVER_IP_FIELD_NUMBER));
  }

  /**
   * Test Action {@link Action#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code ACTION_FAST_ADVERTISING_MODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#forNumber(int)}
   */
  @Test
  @DisplayName("Test Action forNumber(int); when four; then return 'ACTION_FAST_ADVERTISING_MODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Action Action.forNumber(int)"})
  void testActionForNumber_whenFour_thenReturnActionFastAdvertisingMode() {
    // Arrange, Act and Assert
    assertEquals(Action.ACTION_FAST_ADVERTISING_MODE, Action.forNumber(4));
  }

  /**
   * Test Action {@link Action#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code ACTION_TRIGGER_TRANSMISSION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#forNumber(int)}
   */
  @Test
  @DisplayName("Test Action forNumber(int); when one; then return 'ACTION_TRIGGER_TRANSMISSION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Action Action.forNumber(int)"})
  void testActionForNumber_whenOne_thenReturnActionTriggerTransmission() {
    // Arrange, Act and Assert
    assertEquals(Action.ACTION_TRIGGER_TRANSMISSION, Action.forNumber(1));
  }

  /**
   * Test Action {@link Action#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code ACTION_TRIGGER_TRANSMISSION_WITH_ACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#forNumber(int)}
   */
  @Test
  @DisplayName("Test Action forNumber(int); when three; then return 'ACTION_TRIGGER_TRANSMISSION_WITH_ACK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Action Action.forNumber(int)"})
  void testActionForNumber_whenThree_thenReturnActionTriggerTransmissionWithAck() {
    // Arrange, Act and Assert
    assertEquals(Action.ACTION_TRIGGER_TRANSMISSION_WITH_ACK, Action.forNumber(3));
  }

  /**
   * Test Action {@link Action#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code ACTION_NO_ACTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#forNumber(int)}
   */
  @Test
  @DisplayName("Test Action forNumber(int); when two; then return 'ACTION_NO_ACTION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Action Action.forNumber(int)"})
  void testActionForNumber_whenTwo_thenReturnActionNoAction() {
    // Arrange, Act and Assert
    assertEquals(Action.ACTION_NO_ACTION, Action.forNumber(2));
  }

  /**
   * Test Action {@link Action#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code ACTION_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#forNumber(int)}
   */
  @Test
  @DisplayName("Test Action forNumber(int); when zero; then return 'ACTION_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Action Action.forNumber(int)"})
  void testActionForNumber_whenZero_thenReturnActionUnspecified() {
    // Arrange, Act and Assert
    assertEquals(Action.ACTION_UNSPECIFIED, Action.forNumber(0));
  }

  /**
   * Test Action {@link Action#getDescriptor()}.
   * <p>
   * Method under test: {@link Action#getDescriptor()}
   */
  @Test
  @DisplayName("Test Action getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor Action.getDescriptor()"})
  void testActionGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = Action.getDescriptor();

    // Assert
    assertEquals("Action", actualDescriptor.getFullName());
    assertEquals("Action", actualDescriptor.getName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getIndex());
    assertEquals(5, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }

  /**
   * Test Action {@link Action#getDescriptorForType()}.
   * <p>
   * Method under test: {@link Action#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test Action getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor Action.getDescriptorForType()"})
  void testActionGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = Action.ACTION_UNSPECIFIED.getDescriptorForType();

    // Assert
    assertEquals("Action", actualDescriptorForType.getFullName());
    assertEquals("Action", actualDescriptorForType.getName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(2, actualDescriptorForType.getIndex());
    assertEquals(5, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test Action {@link Action#getNumber()}.
   * <ul>
   *   <li>Given {@code ACTION_UNSPECIFIED}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#getNumber()}
   */
  @Test
  @DisplayName("Test Action getNumber(); given 'ACTION_UNSPECIFIED'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Action.getNumber()"})
  void testActionGetNumber_givenActionUnspecified_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Action.ACTION_UNSPECIFIED.getNumber());
  }

  /**
   * Test Action {@link Action#getNumber()}.
   * <ul>
   *   <li>Given {@link Action#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#getNumber()}
   */
  @Test
  @DisplayName("Test Action getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Action.getNumber()"})
  void testActionGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Action.UNRECOGNIZED.getNumber());
  }

  /**
   * Test Action {@link Action#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link Action#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test Action getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor Action.getValueDescriptor()"})
  void testActionGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> Action.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test Action {@link Action#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code ACTION_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test Action getValueDescriptor(); then return Name is 'ACTION_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor Action.getValueDescriptor()"})
  void testActionGetValueDescriptor_thenReturnNameIsActionUnspecified() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = Action.ACTION_UNSPECIFIED.getValueDescriptor();

    // Assert
    assertEquals("ACTION_UNSPECIFIED", actualValueDescriptor.getName());
    assertEquals("Action.ACTION_UNSPECIFIED", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test Action {@link Action#internalGetValueMap()}.
   * <p>
   * Method under test: {@link Action#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Action internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Action.internalGetValueMap()"})
  void testActionInternalGetValueMap() {
    // Arrange and Act
    EnumLiteMap<Action> actualInternalGetValueMapResult = Action.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER));
  }

  /**
   * Test Action {@link Action#internalGetValueMap()}.
   * <p>
   * Method under test: {@link Action#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Action internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Action.internalGetValueMap()"})
  void testActionInternalGetValueMap2() {
    // Arrange and Act
    EnumLiteMap<Action> actualInternalGetValueMapResult = Action.internalGetValueMap();

    // Assert
    assertEquals(Action.ACTION_TRIGGER_TRANSMISSION, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test Action {@link Action#internalGetValueMap()}.
   * <p>
   * Method under test: {@link Action#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Action internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Action.internalGetValueMap()"})
  void testActionInternalGetValueMap3() {
    // Arrange and Act
    EnumLiteMap<Action> actualInternalGetValueMapResult = Action.internalGetValueMap();

    // Assert
    assertEquals(Action.ACTION_TRIGGER_TRANSMISSION_WITH_ACK, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test Action {@link Action#internalGetValueMap()}.
   * <p>
   * Method under test: {@link Action#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Action internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Action.internalGetValueMap()"})
  void testActionInternalGetValueMap4() {
    // Arrange and Act
    EnumLiteMap<Action> actualInternalGetValueMapResult = Action.internalGetValueMap();

    // Assert
    assertEquals(Action.ACTION_FAST_ADVERTISING_MODE, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test Action {@link Action#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code ACTION_NO_ACTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Action internalGetValueMap(); then return findValueByNumber two is 'ACTION_NO_ACTION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Action.internalGetValueMap()"})
  void testActionInternalGetValueMap_thenReturnFindValueByNumberTwoIsActionNoAction() {
    // Arrange and Act
    EnumLiteMap<Action> actualInternalGetValueMapResult = Action.internalGetValueMap();

    // Assert
    assertEquals(Action.ACTION_NO_ACTION, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test Action {@link Action#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code ACTION_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Action internalGetValueMap(); then return findValueByNumber zero is 'ACTION_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Action.internalGetValueMap()"})
  void testActionInternalGetValueMap_thenReturnFindValueByNumberZeroIsActionUnspecified() {
    // Arrange and Act
    EnumLiteMap<Action> actualInternalGetValueMapResult = Action.internalGetValueMap();

    // Assert
    assertEquals(Action.ACTION_UNSPECIFIED, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test Action {@link Action#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When {@link ProtoConfig#DNS_SERVER_IP_FIELD_NUMBER}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#valueOf(int)}
   */
  @Test
  @DisplayName("Test Action valueOf(int) with 'value'; when DNS_SERVER_IP_FIELD_NUMBER; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Action Action.valueOf(int)"})
  void testActionValueOfWithValue_whenDns_server_ip_field_number_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Action.valueOf(ProtoConfig.DNS_SERVER_IP_FIELD_NUMBER));
  }

  /**
   * Test Action {@link Action#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code ACTION_FAST_ADVERTISING_MODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#valueOf(int)}
   */
  @Test
  @DisplayName("Test Action valueOf(int) with 'value'; when four; then return 'ACTION_FAST_ADVERTISING_MODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Action Action.valueOf(int)"})
  void testActionValueOfWithValue_whenFour_thenReturnActionFastAdvertisingMode() {
    // Arrange, Act and Assert
    assertEquals(Action.ACTION_FAST_ADVERTISING_MODE, Action.valueOf(4));
  }

  /**
   * Test Action {@link Action#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code ACTION_TRIGGER_TRANSMISSION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#valueOf(int)}
   */
  @Test
  @DisplayName("Test Action valueOf(int) with 'value'; when one; then return 'ACTION_TRIGGER_TRANSMISSION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Action Action.valueOf(int)"})
  void testActionValueOfWithValue_whenOne_thenReturnActionTriggerTransmission() {
    // Arrange, Act and Assert
    assertEquals(Action.ACTION_TRIGGER_TRANSMISSION, Action.valueOf(1));
  }

  /**
   * Test Action {@link Action#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code ACTION_TRIGGER_TRANSMISSION_WITH_ACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#valueOf(int)}
   */
  @Test
  @DisplayName("Test Action valueOf(int) with 'value'; when three; then return 'ACTION_TRIGGER_TRANSMISSION_WITH_ACK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Action Action.valueOf(int)"})
  void testActionValueOfWithValue_whenThree_thenReturnActionTriggerTransmissionWithAck() {
    // Arrange, Act and Assert
    assertEquals(Action.ACTION_TRIGGER_TRANSMISSION_WITH_ACK, Action.valueOf(3));
  }

  /**
   * Test Action {@link Action#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code ACTION_NO_ACTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#valueOf(int)}
   */
  @Test
  @DisplayName("Test Action valueOf(int) with 'value'; when two; then return 'ACTION_NO_ACTION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Action Action.valueOf(int)"})
  void testActionValueOfWithValue_whenTwo_thenReturnActionNoAction() {
    // Arrange, Act and Assert
    assertEquals(Action.ACTION_NO_ACTION, Action.valueOf(2));
  }

  /**
   * Test Action {@link Action#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code ACTION_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Action#valueOf(int)}
   */
  @Test
  @DisplayName("Test Action valueOf(int) with 'value'; when zero; then return 'ACTION_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Action Action.valueOf(int)"})
  void testActionValueOfWithValue_whenZero_thenReturnActionUnspecified() {
    // Arrange, Act and Assert
    assertEquals(Action.ACTION_UNSPECIFIED, Action.valueOf(0));
  }

  /**
   * Test CalendarType {@link CalendarType#forNumber(int)}.
   * <ul>
   *   <li>When {@link ProtoConfig#DNS_SERVER_IP_FIELD_NUMBER}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CalendarType#forNumber(int)}
   */
  @Test
  @DisplayName("Test CalendarType forNumber(int); when DNS_SERVER_IP_FIELD_NUMBER; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CalendarType CalendarType.forNumber(int)"})
  void testCalendarTypeForNumber_whenDns_server_ip_field_number_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(CalendarType.forNumber(ProtoConfig.DNS_SERVER_IP_FIELD_NUMBER));
  }

  /**
   * Test CalendarType {@link CalendarType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code CALENDAR_TYPE_DISABLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CalendarType#forNumber(int)}
   */
  @Test
  @DisplayName("Test CalendarType forNumber(int); when one; then return 'CALENDAR_TYPE_DISABLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CalendarType CalendarType.forNumber(int)"})
  void testCalendarTypeForNumber_whenOne_thenReturnCalendarTypeDisabled() {
    // Arrange, Act and Assert
    assertEquals(CalendarType.CALENDAR_TYPE_DISABLED, CalendarType.forNumber(1));
  }

  /**
   * Test CalendarType {@link CalendarType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code CALENDAR_TYPE_WEEK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CalendarType#forNumber(int)}
   */
  @Test
  @DisplayName("Test CalendarType forNumber(int); when two; then return 'CALENDAR_TYPE_WEEK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CalendarType CalendarType.forNumber(int)"})
  void testCalendarTypeForNumber_whenTwo_thenReturnCalendarTypeWeek() {
    // Arrange, Act and Assert
    assertEquals(CalendarType.CALENDAR_TYPE_WEEK, CalendarType.forNumber(2));
  }

  /**
   * Test CalendarType {@link CalendarType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code CALENDAR_TYPE_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CalendarType#forNumber(int)}
   */
  @Test
  @DisplayName("Test CalendarType forNumber(int); when zero; then return 'CALENDAR_TYPE_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CalendarType CalendarType.forNumber(int)"})
  void testCalendarTypeForNumber_whenZero_thenReturnCalendarTypeUnspecified() {
    // Arrange, Act and Assert
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, CalendarType.forNumber(0));
  }

  /**
   * Test CalendarType {@link CalendarType#getDescriptor()}.
   * <p>
   * Method under test: {@link CalendarType#getDescriptor()}
   */
  @Test
  @DisplayName("Test CalendarType getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor CalendarType.getDescriptor()"})
  void testCalendarTypeGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = CalendarType.getDescriptor();

    // Assert
    assertEquals("CalendarType", actualDescriptor.getFullName());
    assertEquals("CalendarType", actualDescriptor.getName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }

  /**
   * Test CalendarType {@link CalendarType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link CalendarType#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test CalendarType getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor CalendarType.getDescriptorForType()"})
  void testCalendarTypeGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = CalendarType.CALENDAR_TYPE_UNSPECIFIED.getDescriptorForType();

    // Assert
    assertEquals("CalendarType", actualDescriptorForType.getFullName());
    assertEquals("CalendarType", actualDescriptorForType.getName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(3, actualDescriptorForType.getIndex());
    assertEquals(3, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test CalendarType {@link CalendarType#getNumber()}.
   * <ul>
   *   <li>Given {@code CALENDAR_TYPE_UNSPECIFIED}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CalendarType#getNumber()}
   */
  @Test
  @DisplayName("Test CalendarType getNumber(); given 'CALENDAR_TYPE_UNSPECIFIED'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CalendarType.getNumber()"})
  void testCalendarTypeGetNumber_givenCalendarTypeUnspecified_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, CalendarType.CALENDAR_TYPE_UNSPECIFIED.getNumber());
  }

  /**
   * Test CalendarType {@link CalendarType#getNumber()}.
   * <ul>
   *   <li>Given {@link CalendarType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CalendarType#getNumber()}
   */
  @Test
  @DisplayName("Test CalendarType getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CalendarType.getNumber()"})
  void testCalendarTypeGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CalendarType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test CalendarType {@link CalendarType#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code CALENDAR_TYPE_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CalendarType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test CalendarType getValueDescriptor(); then return Name is 'CALENDAR_TYPE_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor CalendarType.getValueDescriptor()"})
  void testCalendarTypeGetValueDescriptor_thenReturnNameIsCalendarTypeUnspecified() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = CalendarType.CALENDAR_TYPE_UNSPECIFIED.getValueDescriptor();

    // Assert
    assertEquals("CALENDAR_TYPE_UNSPECIFIED", actualValueDescriptor.getName());
    assertEquals("CalendarType.CALENDAR_TYPE_UNSPECIFIED", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test CalendarType {@link CalendarType#getValueDescriptor()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CalendarType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test CalendarType getValueDescriptor(); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor CalendarType.getValueDescriptor()"})
  void testCalendarTypeGetValueDescriptor_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> CalendarType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test CalendarType {@link CalendarType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link CalendarType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test CalendarType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap CalendarType.internalGetValueMap()"})
  void testCalendarTypeInternalGetValueMap() {
    // Arrange and Act
    EnumLiteMap<CalendarType> actualInternalGetValueMapResult = CalendarType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER));
  }

  /**
   * Test CalendarType {@link CalendarType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link CalendarType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test CalendarType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap CalendarType.internalGetValueMap()"})
  void testCalendarTypeInternalGetValueMap2() {
    // Arrange and Act
    EnumLiteMap<CalendarType> actualInternalGetValueMapResult = CalendarType.internalGetValueMap();

    // Assert
    assertEquals(CalendarType.CALENDAR_TYPE_DISABLED, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test CalendarType {@link CalendarType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link CalendarType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test CalendarType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap CalendarType.internalGetValueMap()"})
  void testCalendarTypeInternalGetValueMap3() {
    // Arrange and Act
    EnumLiteMap<CalendarType> actualInternalGetValueMapResult = CalendarType.internalGetValueMap();

    // Assert
    assertEquals(CalendarType.CALENDAR_TYPE_WEEK, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test CalendarType {@link CalendarType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link CalendarType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test CalendarType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap CalendarType.internalGetValueMap()"})
  void testCalendarTypeInternalGetValueMap4() {
    // Arrange and Act
    EnumLiteMap<CalendarType> actualInternalGetValueMapResult = CalendarType.internalGetValueMap();

    // Assert
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test CalendarType {@link CalendarType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When {@link ProtoConfig#DNS_SERVER_IP_FIELD_NUMBER}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CalendarType#valueOf(int)}
   */
  @Test
  @DisplayName("Test CalendarType valueOf(int) with 'value'; when DNS_SERVER_IP_FIELD_NUMBER; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CalendarType CalendarType.valueOf(int)"})
  void testCalendarTypeValueOfWithValue_whenDns_server_ip_field_number_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(CalendarType.valueOf(ProtoConfig.DNS_SERVER_IP_FIELD_NUMBER));
  }

  /**
   * Test CalendarType {@link CalendarType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code CALENDAR_TYPE_DISABLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CalendarType#valueOf(int)}
   */
  @Test
  @DisplayName("Test CalendarType valueOf(int) with 'value'; when one; then return 'CALENDAR_TYPE_DISABLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CalendarType CalendarType.valueOf(int)"})
  void testCalendarTypeValueOfWithValue_whenOne_thenReturnCalendarTypeDisabled() {
    // Arrange, Act and Assert
    assertEquals(CalendarType.CALENDAR_TYPE_DISABLED, CalendarType.valueOf(1));
  }

  /**
   * Test CalendarType {@link CalendarType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code CALENDAR_TYPE_WEEK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CalendarType#valueOf(int)}
   */
  @Test
  @DisplayName("Test CalendarType valueOf(int) with 'value'; when two; then return 'CALENDAR_TYPE_WEEK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CalendarType CalendarType.valueOf(int)"})
  void testCalendarTypeValueOfWithValue_whenTwo_thenReturnCalendarTypeWeek() {
    // Arrange, Act and Assert
    assertEquals(CalendarType.CALENDAR_TYPE_WEEK, CalendarType.valueOf(2));
  }

  /**
   * Test CalendarType {@link CalendarType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code CALENDAR_TYPE_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CalendarType#valueOf(int)}
   */
  @Test
  @DisplayName("Test CalendarType valueOf(int) with 'value'; when zero; then return 'CALENDAR_TYPE_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CalendarType CalendarType.valueOf(int)"})
  void testCalendarTypeValueOfWithValue_whenZero_thenReturnCalendarTypeUnspecified() {
    // Arrange, Act and Assert
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, CalendarType.valueOf(0));
  }

  /**
   * Test Condition {@link Condition#forNumber(int)}.
   * <ul>
   *   <li>When {@link ProtoConfig#DNS_SERVER_IP_FIELD_NUMBER}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#forNumber(int)}
   */
  @Test
  @DisplayName("Test Condition forNumber(int); when DNS_SERVER_IP_FIELD_NUMBER; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.forNumber(int)"})
  void testConditionForNumber_whenDns_server_ip_field_number_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Condition.forNumber(ProtoConfig.DNS_SERVER_IP_FIELD_NUMBER));
  }

  /**
   * Test Condition {@link Condition#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code CONDITION_BINARY_CHANGE_STATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#forNumber(int)}
   */
  @Test
  @DisplayName("Test Condition forNumber(int); when five; then return 'CONDITION_BINARY_CHANGE_STATE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.forNumber(int)"})
  void testConditionForNumber_whenFive_thenReturnConditionBinaryChangeState() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_BINARY_CHANGE_STATE, Condition.forNumber(5));
  }

  /**
   * Test Condition {@link Condition#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code CONDITION_DIFF_THRESHOLD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#forNumber(int)}
   */
  @Test
  @DisplayName("Test Condition forNumber(int); when four; then return 'CONDITION_DIFF_THRESHOLD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.forNumber(int)"})
  void testConditionForNumber_whenFour_thenReturnConditionDiffThreshold() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_DIFF_THRESHOLD, Condition.forNumber(4));
  }

  /**
   * Test Condition {@link Condition#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code CONDITION_DISABLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#forNumber(int)}
   */
  @Test
  @DisplayName("Test Condition forNumber(int); when one; then return 'CONDITION_DISABLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.forNumber(int)"})
  void testConditionForNumber_whenOne_thenReturnConditionDisabled() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_DISABLED, Condition.forNumber(1));
  }

  /**
   * Test Condition {@link Condition#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code CONDITION_ON_MEASUREMENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#forNumber(int)}
   */
  @Test
  @DisplayName("Test Condition forNumber(int); when seven; then return 'CONDITION_ON_MEASUREMENT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.forNumber(int)"})
  void testConditionForNumber_whenSeven_thenReturnConditionOnMeasurement() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_ON_MEASUREMENT, Condition.forNumber(7));
  }

  /**
   * Test Condition {@link Condition#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code CONDITION_LOGIC_OPERATOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#forNumber(int)}
   */
  @Test
  @DisplayName("Test Condition forNumber(int); when six; then return 'CONDITION_LOGIC_OPERATOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.forNumber(int)"})
  void testConditionForNumber_whenSix_thenReturnConditionLogicOperator() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_LOGIC_OPERATOR, Condition.forNumber(6));
  }

  /**
   * Test Condition {@link Condition#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code CONDITION_LOW_THRESHOLD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#forNumber(int)}
   */
  @Test
  @DisplayName("Test Condition forNumber(int); when three; then return 'CONDITION_LOW_THRESHOLD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.forNumber(int)"})
  void testConditionForNumber_whenThree_thenReturnConditionLowThreshold() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_LOW_THRESHOLD, Condition.forNumber(3));
  }

  /**
   * Test Condition {@link Condition#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code CONDITION_HIGH_THRESHOLD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#forNumber(int)}
   */
  @Test
  @DisplayName("Test Condition forNumber(int); when two; then return 'CONDITION_HIGH_THRESHOLD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.forNumber(int)"})
  void testConditionForNumber_whenTwo_thenReturnConditionHighThreshold() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_HIGH_THRESHOLD, Condition.forNumber(2));
  }

  /**
   * Test Condition {@link Condition#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code CONDITION_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#forNumber(int)}
   */
  @Test
  @DisplayName("Test Condition forNumber(int); when zero; then return 'CONDITION_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.forNumber(int)"})
  void testConditionForNumber_whenZero_thenReturnConditionUnspecified() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_UNSPECIFIED, Condition.forNumber(0));
  }

  /**
   * Test Condition {@link Condition#getDescriptor()}.
   * <p>
   * Method under test: {@link Condition#getDescriptor()}
   */
  @Test
  @DisplayName("Test Condition getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor Condition.getDescriptor()"})
  void testConditionGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = Condition.getDescriptor();

    // Assert
    assertEquals("Condition", actualDescriptor.getFullName());
    assertEquals("Condition", actualDescriptor.getName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(8, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }

  /**
   * Test Condition {@link Condition#getDescriptorForType()}.
   * <p>
   * Method under test: {@link Condition#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test Condition getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor Condition.getDescriptorForType()"})
  void testConditionGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = Condition.CONDITION_UNSPECIFIED.getDescriptorForType();

    // Assert
    assertEquals("Condition", actualDescriptorForType.getFullName());
    assertEquals("Condition", actualDescriptorForType.getName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(8, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test Condition {@link Condition#getNumber()}.
   * <ul>
   *   <li>Given {@code CONDITION_UNSPECIFIED}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#getNumber()}
   */
  @Test
  @DisplayName("Test Condition getNumber(); given 'CONDITION_UNSPECIFIED'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Condition.getNumber()"})
  void testConditionGetNumber_givenConditionUnspecified_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Condition.CONDITION_UNSPECIFIED.getNumber());
  }

  /**
   * Test Condition {@link Condition#getNumber()}.
   * <ul>
   *   <li>Given {@link Condition#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#getNumber()}
   */
  @Test
  @DisplayName("Test Condition getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Condition.getNumber()"})
  void testConditionGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Condition.UNRECOGNIZED.getNumber());
  }

  /**
   * Test Condition {@link Condition#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link Condition#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test Condition getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor Condition.getValueDescriptor()"})
  void testConditionGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> Condition.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test Condition {@link Condition#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code CONDITION_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test Condition getValueDescriptor(); then return Name is 'CONDITION_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor Condition.getValueDescriptor()"})
  void testConditionGetValueDescriptor_thenReturnNameIsConditionUnspecified() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = Condition.CONDITION_UNSPECIFIED.getValueDescriptor();

    // Assert
    assertEquals("CONDITION_UNSPECIFIED", actualValueDescriptor.getName());
    assertEquals("Condition.CONDITION_UNSPECIFIED", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test Condition {@link Condition#internalGetValueMap()}.
   * <p>
   * Method under test: {@link Condition#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Condition internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Condition.internalGetValueMap()"})
  void testConditionInternalGetValueMap() {
    // Arrange and Act
    EnumLiteMap<Condition> actualInternalGetValueMapResult = Condition.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER));
  }

  /**
   * Test Condition {@link Condition#internalGetValueMap()}.
   * <p>
   * Method under test: {@link Condition#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Condition internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Condition.internalGetValueMap()"})
  void testConditionInternalGetValueMap2() {
    // Arrange and Act
    EnumLiteMap<Condition> actualInternalGetValueMapResult = Condition.internalGetValueMap();

    // Assert
    assertEquals(Condition.CONDITION_DISABLED, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test Condition {@link Condition#internalGetValueMap()}.
   * <p>
   * Method under test: {@link Condition#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Condition internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Condition.internalGetValueMap()"})
  void testConditionInternalGetValueMap3() {
    // Arrange and Act
    EnumLiteMap<Condition> actualInternalGetValueMapResult = Condition.internalGetValueMap();

    // Assert
    assertEquals(Condition.CONDITION_HIGH_THRESHOLD, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test Condition {@link Condition#internalGetValueMap()}.
   * <p>
   * Method under test: {@link Condition#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Condition internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Condition.internalGetValueMap()"})
  void testConditionInternalGetValueMap4() {
    // Arrange and Act
    EnumLiteMap<Condition> actualInternalGetValueMapResult = Condition.internalGetValueMap();

    // Assert
    assertEquals(Condition.CONDITION_LOW_THRESHOLD, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test Condition {@link Condition#internalGetValueMap()}.
   * <p>
   * Method under test: {@link Condition#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Condition internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Condition.internalGetValueMap()"})
  void testConditionInternalGetValueMap5() {
    // Arrange and Act
    EnumLiteMap<Condition> actualInternalGetValueMapResult = Condition.internalGetValueMap();

    // Assert
    assertEquals(Condition.CONDITION_DIFF_THRESHOLD, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test Condition {@link Condition#internalGetValueMap()}.
   * <p>
   * Method under test: {@link Condition#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Condition internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Condition.internalGetValueMap()"})
  void testConditionInternalGetValueMap6() {
    // Arrange and Act
    EnumLiteMap<Condition> actualInternalGetValueMapResult = Condition.internalGetValueMap();

    // Assert
    assertEquals(Condition.CONDITION_BINARY_CHANGE_STATE, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Test Condition {@link Condition#internalGetValueMap()}.
   * <p>
   * Method under test: {@link Condition#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Condition internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Condition.internalGetValueMap()"})
  void testConditionInternalGetValueMap7() {
    // Arrange and Act
    EnumLiteMap<Condition> actualInternalGetValueMapResult = Condition.internalGetValueMap();

    // Assert
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test Condition {@link Condition#internalGetValueMap()}.
   * <p>
   * Method under test: {@link Condition#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Condition internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Condition.internalGetValueMap()"})
  void testConditionInternalGetValueMap8() {
    // Arrange and Act
    EnumLiteMap<Condition> actualInternalGetValueMapResult = Condition.internalGetValueMap();

    // Assert
    assertEquals(Condition.CONDITION_LOGIC_OPERATOR, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Test Condition {@link Condition#internalGetValueMap()}.
   * <p>
   * Method under test: {@link Condition#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test Condition internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap Condition.internalGetValueMap()"})
  void testConditionInternalGetValueMap9() {
    // Arrange and Act
    EnumLiteMap<Condition> actualInternalGetValueMapResult = Condition.internalGetValueMap();

    // Assert
    assertEquals(Condition.CONDITION_ON_MEASUREMENT, actualInternalGetValueMapResult.findValueByNumber(7));
  }

  /**
   * Test Condition {@link Condition#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When {@link ProtoConfig#DNS_SERVER_IP_FIELD_NUMBER}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#valueOf(int)}
   */
  @Test
  @DisplayName("Test Condition valueOf(int) with 'value'; when DNS_SERVER_IP_FIELD_NUMBER; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.valueOf(int)"})
  void testConditionValueOfWithValue_whenDns_server_ip_field_number_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Condition.valueOf(ProtoConfig.DNS_SERVER_IP_FIELD_NUMBER));
  }

  /**
   * Test Condition {@link Condition#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code CONDITION_BINARY_CHANGE_STATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#valueOf(int)}
   */
  @Test
  @DisplayName("Test Condition valueOf(int) with 'value'; when five; then return 'CONDITION_BINARY_CHANGE_STATE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.valueOf(int)"})
  void testConditionValueOfWithValue_whenFive_thenReturnConditionBinaryChangeState() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_BINARY_CHANGE_STATE, Condition.valueOf(5));
  }

  /**
   * Test Condition {@link Condition#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code CONDITION_DIFF_THRESHOLD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#valueOf(int)}
   */
  @Test
  @DisplayName("Test Condition valueOf(int) with 'value'; when four; then return 'CONDITION_DIFF_THRESHOLD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.valueOf(int)"})
  void testConditionValueOfWithValue_whenFour_thenReturnConditionDiffThreshold() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_DIFF_THRESHOLD, Condition.valueOf(4));
  }

  /**
   * Test Condition {@link Condition#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code CONDITION_DISABLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#valueOf(int)}
   */
  @Test
  @DisplayName("Test Condition valueOf(int) with 'value'; when one; then return 'CONDITION_DISABLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.valueOf(int)"})
  void testConditionValueOfWithValue_whenOne_thenReturnConditionDisabled() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_DISABLED, Condition.valueOf(1));
  }

  /**
   * Test Condition {@link Condition#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code CONDITION_ON_MEASUREMENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#valueOf(int)}
   */
  @Test
  @DisplayName("Test Condition valueOf(int) with 'value'; when seven; then return 'CONDITION_ON_MEASUREMENT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.valueOf(int)"})
  void testConditionValueOfWithValue_whenSeven_thenReturnConditionOnMeasurement() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_ON_MEASUREMENT, Condition.valueOf(7));
  }

  /**
   * Test Condition {@link Condition#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code CONDITION_LOGIC_OPERATOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#valueOf(int)}
   */
  @Test
  @DisplayName("Test Condition valueOf(int) with 'value'; when six; then return 'CONDITION_LOGIC_OPERATOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.valueOf(int)"})
  void testConditionValueOfWithValue_whenSix_thenReturnConditionLogicOperator() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_LOGIC_OPERATOR, Condition.valueOf(6));
  }

  /**
   * Test Condition {@link Condition#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code CONDITION_LOW_THRESHOLD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#valueOf(int)}
   */
  @Test
  @DisplayName("Test Condition valueOf(int) with 'value'; when three; then return 'CONDITION_LOW_THRESHOLD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.valueOf(int)"})
  void testConditionValueOfWithValue_whenThree_thenReturnConditionLowThreshold() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_LOW_THRESHOLD, Condition.valueOf(3));
  }

  /**
   * Test Condition {@link Condition#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code CONDITION_HIGH_THRESHOLD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#valueOf(int)}
   */
  @Test
  @DisplayName("Test Condition valueOf(int) with 'value'; when two; then return 'CONDITION_HIGH_THRESHOLD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.valueOf(int)"})
  void testConditionValueOfWithValue_whenTwo_thenReturnConditionHighThreshold() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_HIGH_THRESHOLD, Condition.valueOf(2));
  }

  /**
   * Test Condition {@link Condition#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code CONDITION_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Condition#valueOf(int)}
   */
  @Test
  @DisplayName("Test Condition valueOf(int) with 'value'; when zero; then return 'CONDITION_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition Condition.valueOf(int)"})
  void testConditionValueOfWithValue_whenZero_thenReturnConditionUnspecified() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_UNSPECIFIED, Condition.valueOf(0));
  }

  /**
   * Test LogicOperator {@link LogicOperator#forNumber(int)}.
   * <ul>
   *   <li>When {@link ProtoConfig#DNS_SERVER_IP_FIELD_NUMBER}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test LogicOperator forNumber(int); when DNS_SERVER_IP_FIELD_NUMBER; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicOperator LogicOperator.forNumber(int)"})
  void testLogicOperatorForNumber_whenDns_server_ip_field_number_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LogicOperator.forNumber(ProtoConfig.DNS_SERVER_IP_FIELD_NUMBER));
  }

  /**
   * Test LogicOperator {@link LogicOperator#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code LOGIC_OPERATOR_AND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test LogicOperator forNumber(int); when one; then return 'LOGIC_OPERATOR_AND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicOperator LogicOperator.forNumber(int)"})
  void testLogicOperatorForNumber_whenOne_thenReturnLogicOperatorAnd() {
    // Arrange, Act and Assert
    assertEquals(LogicOperator.LOGIC_OPERATOR_AND, LogicOperator.forNumber(1));
  }

  /**
   * Test LogicOperator {@link LogicOperator#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code LOGIC_OPERATOR_OR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test LogicOperator forNumber(int); when two; then return 'LOGIC_OPERATOR_OR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicOperator LogicOperator.forNumber(int)"})
  void testLogicOperatorForNumber_whenTwo_thenReturnLogicOperatorOr() {
    // Arrange, Act and Assert
    assertEquals(LogicOperator.LOGIC_OPERATOR_OR, LogicOperator.forNumber(2));
  }

  /**
   * Test LogicOperator {@link LogicOperator#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code LOGIC_OPERATOR_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicOperator#forNumber(int)}
   */
  @Test
  @DisplayName("Test LogicOperator forNumber(int); when zero; then return 'LOGIC_OPERATOR_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicOperator LogicOperator.forNumber(int)"})
  void testLogicOperatorForNumber_whenZero_thenReturnLogicOperatorUnspecified() {
    // Arrange, Act and Assert
    assertEquals(LogicOperator.LOGIC_OPERATOR_UNSPECIFIED, LogicOperator.forNumber(0));
  }

  /**
   * Test LogicOperator {@link LogicOperator#getDescriptor()}.
   * <p>
   * Method under test: {@link LogicOperator#getDescriptor()}
   */
  @Test
  @DisplayName("Test LogicOperator getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor LogicOperator.getDescriptor()"})
  void testLogicOperatorGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = LogicOperator.getDescriptor();

    // Assert
    assertEquals("LogicOperator", actualDescriptor.getFullName());
    assertEquals("LogicOperator", actualDescriptor.getName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }

  /**
   * Test LogicOperator {@link LogicOperator#getDescriptorForType()}.
   * <p>
   * Method under test: {@link LogicOperator#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test LogicOperator getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor LogicOperator.getDescriptorForType()"})
  void testLogicOperatorGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = LogicOperator.LOGIC_OPERATOR_UNSPECIFIED.getDescriptorForType();

    // Assert
    assertEquals("LogicOperator", actualDescriptorForType.getFullName());
    assertEquals("LogicOperator", actualDescriptorForType.getName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(1, actualDescriptorForType.getIndex());
    assertEquals(3, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test LogicOperator {@link LogicOperator#getNumber()}.
   * <ul>
   *   <li>Given {@code LOGIC_OPERATOR_UNSPECIFIED}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicOperator#getNumber()}
   */
  @Test
  @DisplayName("Test LogicOperator getNumber(); given 'LOGIC_OPERATOR_UNSPECIFIED'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LogicOperator.getNumber()"})
  void testLogicOperatorGetNumber_givenLogicOperatorUnspecified_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, LogicOperator.LOGIC_OPERATOR_UNSPECIFIED.getNumber());
  }

  /**
   * Test LogicOperator {@link LogicOperator#getNumber()}.
   * <ul>
   *   <li>Given {@link LogicOperator#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicOperator#getNumber()}
   */
  @Test
  @DisplayName("Test LogicOperator getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LogicOperator.getNumber()"})
  void testLogicOperatorGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> LogicOperator.UNRECOGNIZED.getNumber());
  }

  /**
   * Test LogicOperator {@link LogicOperator#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code LOGIC_OPERATOR_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicOperator#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test LogicOperator getValueDescriptor(); then return Name is 'LOGIC_OPERATOR_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor LogicOperator.getValueDescriptor()"})
  void testLogicOperatorGetValueDescriptor_thenReturnNameIsLogicOperatorUnspecified() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = LogicOperator.LOGIC_OPERATOR_UNSPECIFIED.getValueDescriptor();

    // Assert
    assertEquals("LOGIC_OPERATOR_UNSPECIFIED", actualValueDescriptor.getName());
    assertEquals("LogicOperator.LOGIC_OPERATOR_UNSPECIFIED", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test LogicOperator {@link LogicOperator#getValueDescriptor()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicOperator#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test LogicOperator getValueDescriptor(); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor LogicOperator.getValueDescriptor()"})
  void testLogicOperatorGetValueDescriptor_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> LogicOperator.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test LogicOperator {@link LogicOperator#internalGetValueMap()}.
   * <p>
   * Method under test: {@link LogicOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test LogicOperator internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap LogicOperator.internalGetValueMap()"})
  void testLogicOperatorInternalGetValueMap() {
    // Arrange and Act
    EnumLiteMap<LogicOperator> actualInternalGetValueMapResult = LogicOperator.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER));
  }

  /**
   * Test LogicOperator {@link LogicOperator#internalGetValueMap()}.
   * <p>
   * Method under test: {@link LogicOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test LogicOperator internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap LogicOperator.internalGetValueMap()"})
  void testLogicOperatorInternalGetValueMap2() {
    // Arrange and Act
    EnumLiteMap<LogicOperator> actualInternalGetValueMapResult = LogicOperator.internalGetValueMap();

    // Assert
    assertEquals(LogicOperator.LOGIC_OPERATOR_AND, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test LogicOperator {@link LogicOperator#internalGetValueMap()}.
   * <p>
   * Method under test: {@link LogicOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test LogicOperator internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap LogicOperator.internalGetValueMap()"})
  void testLogicOperatorInternalGetValueMap3() {
    // Arrange and Act
    EnumLiteMap<LogicOperator> actualInternalGetValueMapResult = LogicOperator.internalGetValueMap();

    // Assert
    assertEquals(LogicOperator.LOGIC_OPERATOR_OR, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test LogicOperator {@link LogicOperator#internalGetValueMap()}.
   * <p>
   * Method under test: {@link LogicOperator#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test LogicOperator internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap LogicOperator.internalGetValueMap()"})
  void testLogicOperatorInternalGetValueMap4() {
    // Arrange and Act
    EnumLiteMap<LogicOperator> actualInternalGetValueMapResult = LogicOperator.internalGetValueMap();

    // Assert
    assertEquals(LogicOperator.LOGIC_OPERATOR_UNSPECIFIED, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test LogicOperator {@link LogicOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When {@link ProtoConfig#DNS_SERVER_IP_FIELD_NUMBER}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test LogicOperator valueOf(int) with 'value'; when DNS_SERVER_IP_FIELD_NUMBER; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicOperator LogicOperator.valueOf(int)"})
  void testLogicOperatorValueOfWithValue_whenDns_server_ip_field_number_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LogicOperator.valueOf(ProtoConfig.DNS_SERVER_IP_FIELD_NUMBER));
  }

  /**
   * Test LogicOperator {@link LogicOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code LOGIC_OPERATOR_AND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test LogicOperator valueOf(int) with 'value'; when one; then return 'LOGIC_OPERATOR_AND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicOperator LogicOperator.valueOf(int)"})
  void testLogicOperatorValueOfWithValue_whenOne_thenReturnLogicOperatorAnd() {
    // Arrange, Act and Assert
    assertEquals(LogicOperator.LOGIC_OPERATOR_AND, LogicOperator.valueOf(1));
  }

  /**
   * Test LogicOperator {@link LogicOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code LOGIC_OPERATOR_OR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test LogicOperator valueOf(int) with 'value'; when two; then return 'LOGIC_OPERATOR_OR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicOperator LogicOperator.valueOf(int)"})
  void testLogicOperatorValueOfWithValue_whenTwo_thenReturnLogicOperatorOr() {
    // Arrange, Act and Assert
    assertEquals(LogicOperator.LOGIC_OPERATOR_OR, LogicOperator.valueOf(2));
  }

  /**
   * Test LogicOperator {@link LogicOperator#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code LOGIC_OPERATOR_UNSPECIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicOperator#valueOf(int)}
   */
  @Test
  @DisplayName("Test LogicOperator valueOf(int) with 'value'; when zero; then return 'LOGIC_OPERATOR_UNSPECIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicOperator LogicOperator.valueOf(int)"})
  void testLogicOperatorValueOfWithValue_whenZero_thenReturnLogicOperatorUnspecified() {
    // Arrange, Act and Assert
    assertEquals(LogicOperator.LOGIC_OPERATOR_UNSPECIFIED, LogicOperator.valueOf(0));
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#equals(Object)}, and {@link ProtoCalendar#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoCalendar#equals(Object)}
   *   <li>{@link ProtoCalendar#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoCalendar equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoCalendar.equals(Object)", "int ProtoCalendar.hashCode()"})
  void testProtoCalendarEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoCalendar defaultInstance = ProtoCalendar.getDefaultInstance();
    ProtoCalendar defaultInstance2 = ProtoCalendar.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#equals(Object)}, and {@link ProtoCalendar#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoCalendar#equals(Object)}
   *   <li>{@link ProtoCalendar#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoCalendar equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoCalendar.equals(Object)", "int ProtoCalendar.hashCode()"})
  void testProtoCalendarEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProtoCalendar defaultInstance = ProtoCalendar.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalendar#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoCalendar equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoCalendar.equals(Object)", "int ProtoCalendar.hashCode()"})
  void testProtoCalendarEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoCalendar.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalendar#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoCalendar equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoCalendar.equals(Object)", "int ProtoCalendar.hashCode()"})
  void testProtoCalendarEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoCalendar.getDefaultInstance(), null);
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalendar#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoCalendar equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoCalendar.equals(Object)", "int ProtoCalendar.hashCode()"})
  void testProtoCalendarEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoCalendar.getDefaultInstance(), "Different type to ProtoCalendar");
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ProtoCalendar#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoCalendar getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.getDefaultInstanceForType()"})
  void testProtoCalendarGetDefaultInstanceForType() {
    // Arrange
    ProtoCalendar defaultInstance = ProtoCalendar.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#getParametersCount()}.
   * <p>
   * Method under test: {@link ProtoCalendar#getParametersCount()}
   */
  @Test
  @DisplayName("Test ProtoCalendar getParametersCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoCalendar.getParametersCount()"})
  void testProtoCalendarGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoCalendar.getDefaultInstance().getParametersCount());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#getSerializedSize()}.
   * <p>
   * Method under test: {@link ProtoCalendar#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoCalendar getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoCalendar.getSerializedSize()"})
  void testProtoCalendarGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoCalendar.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#getType()}.
   * <p>
   * Method under test: {@link ProtoCalendar#getType()}
   */
  @Test
  @DisplayName("Test ProtoCalendar getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CalendarType ProtoCalendar.getType()"})
  void testProtoCalendarGetType() {
    // Arrange, Act and Assert
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, ProtoCalendar.getDefaultInstance().getType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#isInitialized()}.
   * <p>
   * Method under test: {@link ProtoCalendar#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoCalendar isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoCalendar.isInitialized()"})
  void testProtoCalendarIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProtoCalendar.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseDelimitedFrom(InputStream)"})
  void testProtoCalendarParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoCalendar actualParseDelimitedFromResult = ProtoCalendar.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getParametersCount());
    assertEquals(0, actualParseDelimitedFromResult.getRuleMask());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getTypeValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseDelimitedFromResult.getType());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getParametersList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseDelimitedFrom(InputStream)"})
  void testProtoCalendarParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoCalendar.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalendarParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoCalendar actualParseDelimitedFromResult = ProtoCalendar.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getParametersCount());
    assertEquals(0, actualParseDelimitedFromResult.getRuleMask());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getTypeValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseDelimitedFromResult.getType());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getParametersList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalendarParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoCalendar.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalendarParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoCalendar.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalendar#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalendarParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoCalendar.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalendar#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseDelimitedFrom(InputStream)"})
  void testProtoCalendarParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoCalendar.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalendar#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseDelimitedFrom(InputStream)"})
  void testProtoCalendarParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoCalendar.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(byte[])"})
  void testProtoCalendarParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getRuleMask());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(ByteBuffer)"})
  void testProtoCalendarParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getRuleMask());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testProtoCalendarParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getRuleMask());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoCalendarParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getRuleMask());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoCalendarParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getRuleMask());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoCalendarParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getRuleMask());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(ByteString)"})
  void testProtoCalendarParseFromWithByteString_givenCodedInputStreamReadTagReturnFour() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getRuleMask());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(ByteString)"})
  void testProtoCalendarParseFromWithByteString_givenCodedInputStreamReadTagReturnZero() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getRuleMask());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(CodedInputStream)"})
  void testProtoCalendarParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getRuleMask());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoCalendarParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getRuleMask());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoCalendarParseFromWithCodedInputStreamExtensionRegistryLite_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getRuleMask());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(CodedInputStream)"})
  void testProtoCalendarParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getRuleMask());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(InputStream)"})
  void testProtoCalendarParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(InputStream)"})
  void testProtoCalendarParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoCalendar.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalendarParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getRuleMask());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(CalendarType.CALENDAR_TYPE_UNSPECIFIED, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalendarParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoCalendar.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoCalendarParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoCalendar.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(InputStream)"})
  void testProtoCalendarParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoCalendar.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoCalendar {@link ProtoCalendar#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoCalendar#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoCalendar parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoCalendar ProtoCalendar.parseFrom(InputStream)"})
  void testProtoCalendarParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ProtoCalendar actualParseFromResult = ProtoCalendar.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#equals(Object)}, and {@link ProtoRule#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoRule#equals(Object)}
   *   <li>{@link ProtoRule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoRule equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoRule.equals(Object)", "int ProtoRule.hashCode()"})
  void testProtoRuleEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoRule defaultInstance = ProtoRule.getDefaultInstance();
    ProtoRule defaultInstance2 = ProtoRule.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoRule {@link ProtoRule#equals(Object)}, and {@link ProtoRule#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoRule#equals(Object)}
   *   <li>{@link ProtoRule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoRule equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoRule.equals(Object)", "int ProtoRule.hashCode()"})
  void testProtoRuleEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProtoRule defaultInstance = ProtoRule.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoRule {@link ProtoRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoRule equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoRule.equals(Object)", "int ProtoRule.hashCode()"})
  void testProtoRuleEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoRule.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoRule {@link ProtoRule#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoRule equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoRule.equals(Object)", "int ProtoRule.hashCode()"})
  void testProtoRuleEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoRule.getDefaultInstance(), null);
  }

  /**
   * Test ProtoRule {@link ProtoRule#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoRule equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoRule.equals(Object)", "int ProtoRule.hashCode()"})
  void testProtoRuleEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoRule.getDefaultInstance(), "Different type to ProtoRule");
  }

  /**
   * Test ProtoRule {@link ProtoRule#getAction()}.
   * <p>
   * Method under test: {@link ProtoRule#getAction()}
   */
  @Test
  @DisplayName("Test ProtoRule getAction()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Action ProtoRule.getAction()"})
  void testProtoRuleGetAction() {
    // Arrange, Act and Assert
    assertEquals(Action.ACTION_UNSPECIFIED, ProtoRule.getDefaultInstance().getAction());
  }

  /**
   * Test ProtoRule {@link ProtoRule#getCondition()}.
   * <p>
   * Method under test: {@link ProtoRule#getCondition()}
   */
  @Test
  @DisplayName("Test ProtoRule getCondition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition ProtoRule.getCondition()"})
  void testProtoRuleGetCondition() {
    // Arrange, Act and Assert
    assertEquals(Condition.CONDITION_UNSPECIFIED, ProtoRule.getDefaultInstance().getCondition());
  }

  /**
   * Test ProtoRule {@link ProtoRule#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ProtoRule#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoRule getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.getDefaultInstanceForType()"})
  void testProtoRuleGetDefaultInstanceForType() {
    // Arrange
    ProtoRule defaultInstance = ProtoRule.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#getParametersCount()}.
   * <p>
   * Method under test: {@link ProtoRule#getParametersCount()}
   */
  @Test
  @DisplayName("Test ProtoRule getParametersCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoRule.getParametersCount()"})
  void testProtoRuleGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoRule.getDefaultInstance().getParametersCount());
  }

  /**
   * Test ProtoRule {@link ProtoRule#getSerializedSize()}.
   * <p>
   * Method under test: {@link ProtoRule#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoRule getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoRule.getSerializedSize()"})
  void testProtoRuleGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoRule.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoRule {@link ProtoRule#isInitialized()}.
   * <p>
   * Method under test: {@link ProtoRule#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoRule isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoRule.isInitialized()"})
  void testProtoRuleIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProtoRule.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoRule#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRule parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseDelimitedFrom(InputStream)"})
  void testProtoRuleParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoRule actualParseDelimitedFromResult = ProtoRule.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getActionValue());
    assertEquals(0, actualParseDelimitedFromResult.getChannelMask());
    assertEquals(0, actualParseDelimitedFromResult.getConditionValue());
    assertEquals(0, actualParseDelimitedFromResult.getParametersCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseDelimitedFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseDelimitedFromResult.getCondition());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getParametersList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoRule#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRule parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuleParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoRule actualParseDelimitedFromResult = ProtoRule.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getActionValue());
    assertEquals(0, actualParseDelimitedFromResult.getChannelMask());
    assertEquals(0, actualParseDelimitedFromResult.getConditionValue());
    assertEquals(0, actualParseDelimitedFromResult.getParametersCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseDelimitedFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseDelimitedFromResult.getCondition());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getParametersList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoRule#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRule parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuleParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoRule.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRule parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuleParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoRule.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRule parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuleParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoRule.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRule parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseDelimitedFrom(InputStream)"})
  void testProtoRuleParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoRule.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRule parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseDelimitedFrom(InputStream)"})
  void testProtoRuleParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoRule.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRule parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseDelimitedFrom(InputStream)"})
  void testProtoRuleParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoRule.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(ByteBuffer)"})
  void testProtoRuleParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActionValue());
    assertEquals(0, actualParseFromResult.getChannelMask());
    assertEquals(0, actualParseFromResult.getConditionValue());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseFromResult.getCondition());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testProtoRuleParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActionValue());
    assertEquals(0, actualParseFromResult.getChannelMask());
    assertEquals(0, actualParseFromResult.getConditionValue());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseFromResult.getCondition());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoRuleParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActionValue());
    assertEquals(0, actualParseFromResult.getChannelMask());
    assertEquals(0, actualParseFromResult.getConditionValue());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseFromResult.getCondition());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoRuleParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActionValue());
    assertEquals(0, actualParseFromResult.getChannelMask());
    assertEquals(0, actualParseFromResult.getConditionValue());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseFromResult.getCondition());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoRuleParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActionValue());
    assertEquals(0, actualParseFromResult.getChannelMask());
    assertEquals(0, actualParseFromResult.getConditionValue());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseFromResult.getCondition());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(ByteString)"})
  void testProtoRuleParseFromWithByteString_givenCodedInputStreamReadTagReturnFour() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActionValue());
    assertEquals(0, actualParseFromResult.getChannelMask());
    assertEquals(0, actualParseFromResult.getConditionValue());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseFromResult.getCondition());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(ByteString)"})
  void testProtoRuleParseFromWithByteString_givenCodedInputStreamReadTagReturnZero() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActionValue());
    assertEquals(0, actualParseFromResult.getChannelMask());
    assertEquals(0, actualParseFromResult.getConditionValue());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseFromResult.getCondition());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(byte[])"})
  void testProtoRuleParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActionValue());
    assertEquals(0, actualParseFromResult.getChannelMask());
    assertEquals(0, actualParseFromResult.getConditionValue());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseFromResult.getCondition());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoRuleParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActionValue());
    assertEquals(0, actualParseFromResult.getChannelMask());
    assertEquals(0, actualParseFromResult.getConditionValue());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseFromResult.getCondition());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoRuleParseFromWithCodedInputStreamExtensionRegistryLite_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActionValue());
    assertEquals(0, actualParseFromResult.getChannelMask());
    assertEquals(0, actualParseFromResult.getConditionValue());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseFromResult.getCondition());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(CodedInputStream)"})
  void testProtoRuleParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActionValue());
    assertEquals(0, actualParseFromResult.getChannelMask());
    assertEquals(0, actualParseFromResult.getConditionValue());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseFromResult.getCondition());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>When {@link CodedInputStream} {@link CodedInputStream#readTag()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(CodedInputStream) with 'CodedInputStream'; when CodedInputStream readTag() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(CodedInputStream)"})
  void testProtoRuleParseFromWithCodedInputStream_whenCodedInputStreamReadTagReturnZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActionValue());
    assertEquals(0, actualParseFromResult.getChannelMask());
    assertEquals(0, actualParseFromResult.getConditionValue());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseFromResult.getCondition());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(InputStream)"})
  void testProtoRuleParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuleParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActionValue());
    assertEquals(0, actualParseFromResult.getChannelMask());
    assertEquals(0, actualParseFromResult.getConditionValue());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Action.ACTION_UNSPECIFIED, actualParseFromResult.getAction());
    assertEquals(Condition.CONDITION_UNSPECIFIED, actualParseFromResult.getCondition());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getParametersList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuleParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoRule.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoRuleParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoRule.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(InputStream)"})
  void testProtoRuleParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoRule.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(InputStream)"})
  void testProtoRuleParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoRule.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoRule {@link ProtoRule#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoRule#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoRule parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoRule ProtoRule.parseFrom(InputStream)"})
  void testProtoRuleParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ProtoRule actualParseFromResult = ProtoRule.parseFrom((InputStream) null);

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }
}
