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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal.EnumLiteMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.coap.ConfigProtos.ProtoConfig;
import org.thingsboard.server.gen.transport.coap.MeasurementTypeProtos.MeasurementType;

class MeasurementTypeProtosDiffblueTest {
  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_AMBIENT_LIGHT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_AMBIENT_LIGHT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeAmbientLight() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_AMBIENT_LIGHT,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_AMBIENT_LIGHT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeAtmosphericPressure() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE, MeasurementType.forNumber(3));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_BREATH_VOC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_BREATH_VOC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeBreathVoc() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_BREATH_VOC,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_BREATH_VOC_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CELLULAR_GATEWAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CELLULAR_GATEWAY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCellularGateway() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CELLULAR_GATEWAY,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_CELLULAR_GATEWAY_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CH4_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CH4_GAS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCh4Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CH4_GAS,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_CH4_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CO2_EQUIVALENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CO2_EQUIVALENT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCo2Equivalent() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CO2_EQUIVALENT,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_CO2_EQUIVALENT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CO2_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CO2_GAS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCo2Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CO2_GAS,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_CO2_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CO_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CO_GAS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCoGas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CO_GAS,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_CO_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CURRENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CURRENT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCurrent() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CURRENT,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_CURRENT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CURRENT_PRECISE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CURRENT_PRECISE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCurrentPrecise() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_DIFFERENTIAL_PRESSURE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_DIFFERENTIAL_PRESSURE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeDifferentialPressure() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_DIFFERENTIAL_PRESSURE, MeasurementType.forNumber(4));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_DISTANCE_MM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_DISTANCE_MM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeDistanceMm() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_DISTANCE_MM,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_DISTANCE_MM_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeElecMeterAccMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeElecMeterAccMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ELECTRICITY_METER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_ELECTRICITY_METER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeElectricityMeter() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_ELECTRICITY_METER,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_ELECTRICITY_METER_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_H2S_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_H2S_GAS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeH2sGas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_H2S_GAS,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_H2S_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_HIGH_PRESSURE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_HIGH_PRESSURE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeHighPressure() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_HIGH_PRESSURE,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_HIGH_PRESSURE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_HUMIDITY_ACCURATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_HUMIDITY_ACCURATE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeHumidityAccurate() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_HUMIDITY_ACCURATE,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_HUMIDITY_ACCURATE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_NH3_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_NH3_GAS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeNh3Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NH3_GAS,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_NH3_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_NO2_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_NO2_GAS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeNo2Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO2_GAS,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_NO2_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_NOISE_LEVEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_NOISE_LEVEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeNoiseLevel() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NOISE_LEVEL,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_NOISE_LEVEL_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_OUTPUT_CONTROL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_OUTPUT_CONTROL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeOutputControl() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PERCENTAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PERCENTAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePercentage() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PERCENTAGE,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_PERCENTAGE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PM_1_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PM_1_0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePm10() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PM_1_0,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_PM_1_0_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PM_2_5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PM_2_5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePm25() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PM_2_5,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_PM_2_5_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PM_10_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PM_10_0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePm100() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PM_10_0,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_PM_10_0_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePulseCntAccMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePulseCntAccMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePulseCntAccWideMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MINOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePulseCntAccWideMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MINOR,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_SOIL_MOISTURE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_SOIL_MOISTURE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeSoilMoisture() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_SOIL_MOISTURE,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_SOIL_MOISTURE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_STATIC_IAQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_STATIC_IAQ'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeStaticIaq() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_STATIC_IAQ,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_STATIC_IAQ_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_VOLTAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_VOLTAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeVoltage() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_VOLTAGE,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_VOLTAGE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_WATER_METER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_WATER_METER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeWaterMeter() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_WATER_METER,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_WATER_METER_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeWaterMeterAccMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_WATER_METER_ACC_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_WATER_METER_ACC_MINOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeWaterMeterAccMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MINOR,
        MeasurementType.forNumber(MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when eight; then return 'MEASUREMENT_TYPE_PULSE_CNT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_whenEight_thenReturnMeasurementTypePulseCnt() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT, MeasurementType.forNumber(8));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_OK_ALARM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when five; then return 'MEASUREMENT_TYPE_OK_ALARM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_whenFive_thenReturnMeasurementTypeOkAlarm() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_OK_ALARM, MeasurementType.forNumber(5));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when minus one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MeasurementType.forNumber(-1));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_TEMPERATURE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when one; then return 'MEASUREMENT_TYPE_TEMPERATURE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_whenOne_thenReturnMeasurementTypeTemperature() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_TEMPERATURE, MeasurementType.forNumber(1));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_FLOODING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when seven; then return 'MEASUREMENT_TYPE_FLOODING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_whenSeven_thenReturnMeasurementTypeFlooding() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_FLOODING, MeasurementType.forNumber(7));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_IAQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when six; then return 'MEASUREMENT_TYPE_IAQ'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_whenSix_thenReturnMeasurementTypeIaq() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_IAQ, MeasurementType.forNumber(6));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_HUMIDITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when two; then return 'MEASUREMENT_TYPE_HUMIDITY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_whenTwo_thenReturnMeasurementTypeHumidity() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_HUMIDITY, MeasurementType.forNumber(2));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_NO_SENSOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when zero; then return 'MEASUREMENT_TYPE_NO_SENSOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.forNumber(int)"})
  void testMeasurementTypeForNumber_whenZero_thenReturnMeasurementTypeNoSensor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, MeasurementType.forNumber(0));
  }

  /**
   * Test MeasurementType {@link MeasurementType#getDescriptor()}.
   * <p>
   * Method under test: {@link MeasurementType#getDescriptor()}
   */
  @Test
  @DisplayName("Test MeasurementType getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor MeasurementType.getDescriptor()"})
  void testMeasurementTypeGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = MeasurementType.getDescriptor();

    // Assert
    assertEquals("MeasurementType", actualDescriptor.getFullName());
    assertEquals("MeasurementType", actualDescriptor.getName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isClosed());
    assertEquals(ProtoConfig.DNS_TTL_CONFIG_FIELD_NUMBER, actualDescriptor.getValues().size());
  }

  /**
   * Test MeasurementType {@link MeasurementType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link MeasurementType#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test MeasurementType getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor MeasurementType.getDescriptorForType()"})
  void testMeasurementTypeGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = MeasurementType.MEASUREMENT_TYPE_NO_SENSOR.getDescriptorForType();

    // Assert
    assertEquals("MeasurementType", actualDescriptorForType.getFullName());
    assertEquals("MeasurementType", actualDescriptorForType.getName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertFalse(actualDescriptorForType.isClosed());
    assertEquals(ProtoConfig.DNS_TTL_CONFIG_FIELD_NUMBER, actualDescriptorForType.getValues().size());
  }

  /**
   * Test MeasurementType {@link MeasurementType#getNumber()}.
   * <ul>
   *   <li>Given {@code MEASUREMENT_TYPE_NO_SENSOR}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#getNumber()}
   */
  @Test
  @DisplayName("Test MeasurementType getNumber(); given 'MEASUREMENT_TYPE_NO_SENSOR'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MeasurementType.getNumber()"})
  void testMeasurementTypeGetNumber_givenMeasurementTypeNoSensor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, MeasurementType.MEASUREMENT_TYPE_NO_SENSOR.getNumber());
  }

  /**
   * Test MeasurementType {@link MeasurementType#getNumber()}.
   * <ul>
   *   <li>Given {@link MeasurementType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#getNumber()}
   */
  @Test
  @DisplayName("Test MeasurementType getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MeasurementType.getNumber()"})
  void testMeasurementTypeGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MeasurementType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test MeasurementType {@link MeasurementType#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code MEASUREMENT_TYPE_NO_SENSOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test MeasurementType getValueDescriptor(); then return Name is 'MEASUREMENT_TYPE_NO_SENSOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor MeasurementType.getValueDescriptor()"})
  void testMeasurementTypeGetValueDescriptor_thenReturnNameIsMeasurementTypeNoSensor() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = MeasurementType.MEASUREMENT_TYPE_NO_SENSOR.getValueDescriptor();

    // Assert
    assertEquals("MEASUREMENT_TYPE_NO_SENSOR", actualValueDescriptor.getName());
    assertEquals("MeasurementType.MEASUREMENT_TYPE_NO_SENSOR", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test MeasurementType {@link MeasurementType#getValueDescriptor()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test MeasurementType getValueDescriptor(); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor MeasurementType.getValueDescriptor()"})
  void testMeasurementTypeGetValueDescriptor_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> MeasurementType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_WATER_METER,
        actualInternalGetValueMapResult.findValueByNumber(MeasurementType.MEASUREMENT_TYPE_WATER_METER_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap2() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_TEMPERATURE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap3() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_HUMIDITY, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap4() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE,
        actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap5() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_DIFFERENTIAL_PRESSURE,
        actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap6() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_OK_ALARM, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap7() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap8() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_IAQ, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap9() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_FLOODING, actualInternalGetValueMapResult.findValueByNumber(7));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap10() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT, actualInternalGetValueMapResult.findValueByNumber(8));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap11() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_ELECTRICITY_METER,
        actualInternalGetValueMapResult.findValueByNumber(MeasurementType.MEASUREMENT_TYPE_ELECTRICITY_METER_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap12() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_SOIL_MOISTURE,
        actualInternalGetValueMapResult.findValueByNumber(MeasurementType.MEASUREMENT_TYPE_SOIL_MOISTURE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap13() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CO_GAS,
        actualInternalGetValueMapResult.findValueByNumber(MeasurementType.MEASUREMENT_TYPE_CO_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap14() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO2_GAS,
        actualInternalGetValueMapResult.findValueByNumber(MeasurementType.MEASUREMENT_TYPE_NO2_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap15() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_H2S_GAS,
        actualInternalGetValueMapResult.findValueByNumber(MeasurementType.MEASUREMENT_TYPE_H2S_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap16() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_AMBIENT_LIGHT,
        actualInternalGetValueMapResult.findValueByNumber(MeasurementType.MEASUREMENT_TYPE_AMBIENT_LIGHT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap17() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PM_1_0,
        actualInternalGetValueMapResult.findValueByNumber(MeasurementType.MEASUREMENT_TYPE_PM_1_0_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap18() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PM_2_5,
        actualInternalGetValueMapResult.findValueByNumber(MeasurementType.MEASUREMENT_TYPE_PM_2_5_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber minus one is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap(); then return findValueByNumber minus one is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MeasurementType.internalGetValueMap()"})
  void testMeasurementTypeInternalGetValueMap_thenReturnFindValueByNumberMinusOneIsNull() {
    // Arrange and Act
    EnumLiteMap<MeasurementType> actualInternalGetValueMapResult = MeasurementType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(-1));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_DIFFERENTIAL_PRESSURE, MeasurementType.valueOf(4));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue2() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MINOR,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue3() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_AMBIENT_LIGHT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_AMBIENT_LIGHT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeAmbientLight() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_AMBIENT_LIGHT,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_AMBIENT_LIGHT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeAtmosphericPressure() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE, MeasurementType.valueOf(3));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_BREATH_VOC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_BREATH_VOC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeBreathVoc() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_BREATH_VOC,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_BREATH_VOC_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CELLULAR_GATEWAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CELLULAR_GATEWAY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCellularGateway() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CELLULAR_GATEWAY,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_CELLULAR_GATEWAY_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CH4_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CH4_GAS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCh4Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CH4_GAS,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_CH4_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CO2_EQUIVALENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CO2_EQUIVALENT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCo2Equivalent() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CO2_EQUIVALENT,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_CO2_EQUIVALENT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CO2_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CO2_GAS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCo2Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CO2_GAS,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_CO2_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CO_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CO_GAS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCoGas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CO_GAS,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_CO_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CURRENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CURRENT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCurrent() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CURRENT,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_CURRENT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CURRENT_PRECISE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CURRENT_PRECISE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCurrentPrecise() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_DISTANCE_MM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_DISTANCE_MM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeDistanceMm() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_DISTANCE_MM,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_DISTANCE_MM_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeElecMeterAccMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeElecMeterAccMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ELECTRICITY_METER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_ELECTRICITY_METER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeElectricityMeter() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_ELECTRICITY_METER,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_ELECTRICITY_METER_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_H2S_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_H2S_GAS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeH2sGas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_H2S_GAS,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_H2S_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_HIGH_PRESSURE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_HIGH_PRESSURE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeHighPressure() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_HIGH_PRESSURE,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_HIGH_PRESSURE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_HUMIDITY_ACCURATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_HUMIDITY_ACCURATE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeHumidityAccurate() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_HUMIDITY_ACCURATE,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_HUMIDITY_ACCURATE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_NH3_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_NH3_GAS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeNh3Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NH3_GAS,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_NH3_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_NO2_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_NO2_GAS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeNo2Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO2_GAS,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_NO2_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_NOISE_LEVEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_NOISE_LEVEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeNoiseLevel() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NOISE_LEVEL,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_NOISE_LEVEL_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_OUTPUT_CONTROL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_OUTPUT_CONTROL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeOutputControl() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PERCENTAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_PERCENTAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypePercentage() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PERCENTAGE,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_PERCENTAGE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PM_1_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_PM_1_0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypePm10() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PM_1_0,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_PM_1_0_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PM_2_5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_PM_2_5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypePm25() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PM_2_5,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_PM_2_5_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PM_10_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_PM_10_0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypePm100() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PM_10_0,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_PM_10_0_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypePulseCntAccMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypePulseCntAccMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_SOIL_MOISTURE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_SOIL_MOISTURE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeSoilMoisture() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_SOIL_MOISTURE,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_SOIL_MOISTURE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_STATIC_IAQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_STATIC_IAQ'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeStaticIaq() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_STATIC_IAQ,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_STATIC_IAQ_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_VOLTAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_VOLTAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeVoltage() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_VOLTAGE,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_VOLTAGE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_WATER_METER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_WATER_METER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeWaterMeter() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_WATER_METER,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_WATER_METER_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeWaterMeterAccMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_WATER_METER_ACC_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_WATER_METER_ACC_MINOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeWaterMeterAccMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MINOR,
        MeasurementType.valueOf(MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when eight; then return 'MEASUREMENT_TYPE_PULSE_CNT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_whenEight_thenReturnMeasurementTypePulseCnt() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_PULSE_CNT, MeasurementType.valueOf(8));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_OK_ALARM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when five; then return 'MEASUREMENT_TYPE_OK_ALARM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_whenFive_thenReturnMeasurementTypeOkAlarm() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_OK_ALARM, MeasurementType.valueOf(5));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when minus one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MeasurementType.valueOf(-1));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_TEMPERATURE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when one; then return 'MEASUREMENT_TYPE_TEMPERATURE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_whenOne_thenReturnMeasurementTypeTemperature() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_TEMPERATURE, MeasurementType.valueOf(1));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_FLOODING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when seven; then return 'MEASUREMENT_TYPE_FLOODING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_whenSeven_thenReturnMeasurementTypeFlooding() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_FLOODING, MeasurementType.valueOf(7));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_IAQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when six; then return 'MEASUREMENT_TYPE_IAQ'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_whenSix_thenReturnMeasurementTypeIaq() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_IAQ, MeasurementType.valueOf(6));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_HUMIDITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when two; then return 'MEASUREMENT_TYPE_HUMIDITY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_whenTwo_thenReturnMeasurementTypeHumidity() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_HUMIDITY, MeasurementType.valueOf(2));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_NO_SENSOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when zero; then return 'MEASUREMENT_TYPE_NO_SENSOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType MeasurementType.valueOf(int)"})
  void testMeasurementTypeValueOfWithValue_whenZero_thenReturnMeasurementTypeNoSensor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, MeasurementType.valueOf(0));
  }
}
