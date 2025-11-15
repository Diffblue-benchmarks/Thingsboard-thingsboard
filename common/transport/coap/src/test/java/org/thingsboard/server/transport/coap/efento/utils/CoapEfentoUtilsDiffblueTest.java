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
package org.thingsboard.server.transport.coap.efento.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonObject;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.coap.MeasurementTypeProtos;
import org.thingsboard.server.gen.transport.coap.MeasurementTypeProtos.MeasurementType;

class CoapEfentoUtilsDiffblueTest {
  /**
   * Test {@link CoapEfentoUtils#convertByteArrayToString(byte[])}.
   * <p>
   * Method under test: {@link CoapEfentoUtils#convertByteArrayToString(byte[])}
   */
  @Test
  @DisplayName("Test convertByteArrayToString(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CoapEfentoUtils.convertByteArrayToString(byte[])"})
  void testConvertByteArrayToString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", CoapEfentoUtils.convertByteArrayToString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CoapEfentoUtils#convertTimestampToUtcString(long)}.
   * <p>
   * Method under test: {@link CoapEfentoUtils#convertTimestampToUtcString(long)}
   */
  @Test
  @DisplayName("Test convertTimestampToUtcString(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CoapEfentoUtils.convertTimestampToUtcString(long)"})
  void testConvertTimestampToUtcString() {
    // Arrange, Act and Assert
    assertEquals("1970-01-01 00:00:00 UTC", CoapEfentoUtils.convertTimestampToUtcString(10L));
  }

  /**
   * Test {@link CoapEfentoUtils#setDefaultMeasurements(String, boolean, long, long, long, long)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoUtils#setDefaultMeasurements(String, boolean, long, long, long, long)}
   */
  @Test
  @DisplayName("Test setDefaultMeasurements(String, boolean, long, long, long, long); when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject CoapEfentoUtils.setDefaultMeasurements(String, boolean, long, long, long, long)"})
  void testSetDefaultMeasurements_when42() {
    // Arrange and Act
    JsonObject actualSetDefaultMeasurementsResult = CoapEfentoUtils.setDefaultMeasurements("42", true, 1L, 1L, 1L, 1L);

    // Assert
    assertEquals(6, actualSetDefaultMeasurementsResult.size());
    assertFalse(actualSetDefaultMeasurementsResult.isJsonArray());
    assertFalse(actualSetDefaultMeasurementsResult.isJsonNull());
    assertFalse(actualSetDefaultMeasurementsResult.isJsonPrimitive());
    assertFalse(actualSetDefaultMeasurementsResult.isEmpty());
    assertTrue(actualSetDefaultMeasurementsResult.isJsonObject());
    assertSame(actualSetDefaultMeasurementsResult, actualSetDefaultMeasurementsResult.getAsJsonObject());
  }

  /**
   * Test {@link CoapEfentoUtils#setDefaultMeasurements(String, boolean, long, long, long, long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoUtils#setDefaultMeasurements(String, boolean, long, long, long, long)}
   */
  @Test
  @DisplayName("Test setDefaultMeasurements(String, boolean, long, long, long, long); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject CoapEfentoUtils.setDefaultMeasurements(String, boolean, long, long, long, long)"})
  void testSetDefaultMeasurements_whenNull() {
    // Arrange and Act
    JsonObject actualSetDefaultMeasurementsResult = CoapEfentoUtils.setDefaultMeasurements(null, false, 1L, 1L, 1L, 1L);

    // Assert
    assertEquals(6, actualSetDefaultMeasurementsResult.size());
    assertFalse(actualSetDefaultMeasurementsResult.isJsonArray());
    assertFalse(actualSetDefaultMeasurementsResult.isJsonNull());
    assertFalse(actualSetDefaultMeasurementsResult.isJsonPrimitive());
    assertFalse(actualSetDefaultMeasurementsResult.isEmpty());
    assertTrue(actualSetDefaultMeasurementsResult.isJsonObject());
    assertSame(actualSetDefaultMeasurementsResult, actualSetDefaultMeasurementsResult.getAsJsonObject());
  }

  /**
   * Test {@link CoapEfentoUtils#isBinarySensor(MeasurementType)}.
   * <ul>
   *   <li>When {@code MEASUREMENT_TYPE_NO_SENSOR}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoUtils#isBinarySensor(MeasurementType)}
   */
  @Test
  @DisplayName("Test isBinarySensor(MeasurementType); when 'MEASUREMENT_TYPE_NO_SENSOR'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoapEfentoUtils.isBinarySensor(MeasurementType)"})
  void testIsBinarySensor_whenMeasurementTypeNoSensor_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CoapEfentoUtils.isBinarySensor(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR));
  }

  /**
   * Test {@link CoapEfentoUtils#isBinarySensor(MeasurementType)}.
   * <ul>
   *   <li>When {@link MeasurementType#MEASUREMENT_TYPE_FLOODING}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoUtils#isBinarySensor(MeasurementType)}
   */
  @Test
  @DisplayName("Test isBinarySensor(MeasurementType); when MEASUREMENT_TYPE_FLOODING; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoapEfentoUtils.isBinarySensor(MeasurementType)"})
  void testIsBinarySensor_whenMeasurement_type_flooding_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CoapEfentoUtils.isBinarySensor(MeasurementType.MEASUREMENT_TYPE_FLOODING));
  }

  /**
   * Test {@link CoapEfentoUtils#isBinarySensor(MeasurementType)}.
   * <ul>
   *   <li>When {@link MeasurementType#MEASUREMENT_TYPE_OK_ALARM}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoUtils#isBinarySensor(MeasurementType)}
   */
  @Test
  @DisplayName("Test isBinarySensor(MeasurementType); when MEASUREMENT_TYPE_OK_ALARM; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoapEfentoUtils.isBinarySensor(MeasurementType)"})
  void testIsBinarySensor_whenMeasurement_type_ok_alarm_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CoapEfentoUtils.isBinarySensor(MeasurementType.MEASUREMENT_TYPE_OK_ALARM));
  }

  /**
   * Test {@link CoapEfentoUtils#isBinarySensor(MeasurementType)}.
   * <ul>
   *   <li>When {@link MeasurementType#MEASUREMENT_TYPE_OUTPUT_CONTROL}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoUtils#isBinarySensor(MeasurementType)}
   */
  @Test
  @DisplayName("Test isBinarySensor(MeasurementType); when MEASUREMENT_TYPE_OUTPUT_CONTROL; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoapEfentoUtils.isBinarySensor(MeasurementType)"})
  void testIsBinarySensor_whenMeasurement_type_output_control_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CoapEfentoUtils.isBinarySensor(MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL));
  }

  /**
   * Test {@link CoapEfentoUtils#isSensorError(int)}.
   * <ul>
   *   <li>When {@code 8355840}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoUtils#isSensorError(int)}
   */
  @Test
  @DisplayName("Test isSensorError(int); when '8355840'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoapEfentoUtils.isSensorError(int)"})
  void testIsSensorError_when8355840_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CoapEfentoUtils.isSensorError(8355840));
  }

  /**
   * Test {@link CoapEfentoUtils#isSensorError(int)}.
   * <ul>
   *   <li>When {@code 8388608}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoUtils#isSensorError(int)}
   */
  @Test
  @DisplayName("Test isSensorError(int); when '8388608'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoapEfentoUtils.isSensorError(int)"})
  void testIsSensorError_when8388608_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CoapEfentoUtils.isSensorError(8388608));
  }

  /**
   * Test {@link CoapEfentoUtils#isSensorError(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoUtils#isSensorError(int)}
   */
  @Test
  @DisplayName("Test isSensorError(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoapEfentoUtils.isSensorError(int)"})
  void testIsSensorError_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CoapEfentoUtils.isSensorError(1));
  }
}
