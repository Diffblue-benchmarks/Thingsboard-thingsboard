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
import com.google.gson.JsonObject;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.coap.MeasurementTypeProtos;

class CoapEfentoUtilsDiffblueTest {
  /**
   * Method under test: {@link CoapEfentoUtils#convertByteArrayToString(byte[])}
   */
  @Test
  void testConvertByteArrayToString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", CoapEfentoUtils.convertByteArrayToString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CoapEfentoUtils#convertTimestampToUtcString(long)}
   */
  @Test
  void testConvertTimestampToUtcString() {
    // Arrange, Act and Assert
    assertEquals("1970-01-01 00:00:00 UTC", CoapEfentoUtils.convertTimestampToUtcString(10L));
  }

  /**
   * Method under test:
   * {@link CoapEfentoUtils#setDefaultMeasurements(String, boolean, long, long, long, long)}
   */
  @Test
  void testSetDefaultMeasurements() {
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
   * Method under test:
   * {@link CoapEfentoUtils#setDefaultMeasurements(String, boolean, long, long, long, long)}
   */
  @Test
  void testSetDefaultMeasurements2() {
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
   * Method under test:
   * {@link CoapEfentoUtils#isBinarySensor(MeasurementTypeProtos.MeasurementType)}
   */
  @Test
  void testIsBinarySensor() {
    // Arrange, Act and Assert
    assertFalse(CoapEfentoUtils.isBinarySensor(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR));
    assertTrue(CoapEfentoUtils.isBinarySensor(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OK_ALARM));
    assertTrue(CoapEfentoUtils.isBinarySensor(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_FLOODING));
    assertTrue(CoapEfentoUtils.isBinarySensor(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL));
  }

  /**
   * Method under test: {@link CoapEfentoUtils#isSensorError(int)}
   */
  @Test
  void testIsSensorError() {
    // Arrange, Act and Assert
    assertFalse(CoapEfentoUtils.isSensorError(1));
    assertTrue(CoapEfentoUtils.isSensorError(8355840));
    assertFalse(CoapEfentoUtils.isSensorError(8388608));
  }
}
