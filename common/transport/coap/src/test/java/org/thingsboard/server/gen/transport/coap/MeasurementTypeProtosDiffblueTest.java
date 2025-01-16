package org.thingsboard.server.gen.transport.coap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.coap.MeasurementTypeProtos.MeasurementType;

class MeasurementTypeProtosDiffblueTest {
  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_AMBIENT_LIGHT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_AMBIENT_LIGHT'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeAmbientLight() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_AMBIENT_LIGHT,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_AMBIENT_LIGHT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeAtmosphericPressure() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE,
        MeasurementTypeProtos.MeasurementType.forNumber(3));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_BREATH_VOC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_BREATH_VOC'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeBreathVoc() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_BREATH_VOC,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_BREATH_VOC_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CELLULAR_GATEWAY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CELLULAR_GATEWAY'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCellularGateway() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CELLULAR_GATEWAY,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CELLULAR_GATEWAY_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CH4_GAS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CH4_GAS'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCh4Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CH4_GAS, MeasurementTypeProtos.MeasurementType
        .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CH4_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CO2_EQUIVALENT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CO2_EQUIVALENT'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCo2Equivalent() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO2_EQUIVALENT,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO2_EQUIVALENT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CO2_GAS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CO2_GAS'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCo2Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO2_GAS, MeasurementTypeProtos.MeasurementType
        .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO2_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CO_GAS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CO_GAS'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCoGas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO_GAS, MeasurementTypeProtos.MeasurementType
        .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CURRENT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CURRENT'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCurrent() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT, MeasurementTypeProtos.MeasurementType
        .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CURRENT_PRECISE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_CURRENT_PRECISE'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeCurrentPrecise() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_DIFFERENTIAL_PRESSURE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_DIFFERENTIAL_PRESSURE'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeDifferentialPressure() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_DIFFERENTIAL_PRESSURE,
        MeasurementTypeProtos.MeasurementType.forNumber(4));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_DISTANCE_MM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_DISTANCE_MM'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeDistanceMm() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_DISTANCE_MM,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_DISTANCE_MM_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeElecMeterAccMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeElecMeterAccMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ELECTRICITY_METER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_ELECTRICITY_METER'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeElectricityMeter() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELECTRICITY_METER,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELECTRICITY_METER_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_H2S_GAS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_H2S_GAS'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeH2sGas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_H2S_GAS, MeasurementTypeProtos.MeasurementType
        .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_H2S_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_HIGH_PRESSURE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_HIGH_PRESSURE'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeHighPressure() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HIGH_PRESSURE,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HIGH_PRESSURE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_HUMIDITY_ACCURATE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_HUMIDITY_ACCURATE'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeHumidityAccurate() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HUMIDITY_ACCURATE,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HUMIDITY_ACCURATE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_NH3_GAS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_NH3_GAS'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeNh3Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NH3_GAS, MeasurementTypeProtos.MeasurementType
        .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NH3_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_NO2_GAS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_NO2_GAS'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeNo2Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO2_GAS, MeasurementTypeProtos.MeasurementType
        .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO2_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_NOISE_LEVEL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_NOISE_LEVEL'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeNoiseLevel() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NOISE_LEVEL,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NOISE_LEVEL_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_OUTPUT_CONTROL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_OUTPUT_CONTROL'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeOutputControl() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PERCENTAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PERCENTAGE'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePercentage() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PERCENTAGE,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PERCENTAGE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PM_1_0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PM_1_0'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePm10() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_1_0, MeasurementTypeProtos.MeasurementType
        .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_1_0_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PM_2_5}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PM_2_5'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePm25() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_2_5, MeasurementTypeProtos.MeasurementType
        .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_2_5_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PM_10_0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PM_10_0'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePm100() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_10_0, MeasurementTypeProtos.MeasurementType
        .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_10_0_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePulseCntAccMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePulseCntAccMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePulseCntAccWideMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MINOR'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypePulseCntAccWideMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MINOR,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_SOIL_MOISTURE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_SOIL_MOISTURE'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeSoilMoisture() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_SOIL_MOISTURE,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_SOIL_MOISTURE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_STATIC_IAQ}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_STATIC_IAQ'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeStaticIaq() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_STATIC_IAQ,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_STATIC_IAQ_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_VOLTAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_VOLTAGE'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeVoltage() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_VOLTAGE, MeasurementTypeProtos.MeasurementType
        .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_VOLTAGE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_WATER_METER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_WATER_METER'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeWaterMeter() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeWaterMeterAccMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_WATER_METER_ACC_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); then return 'MEASUREMENT_TYPE_WATER_METER_ACC_MINOR'")
  void testMeasurementTypeForNumber_thenReturnMeasurementTypeWaterMeterAccMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MINOR,
        MeasurementTypeProtos.MeasurementType
            .forNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when eight; then return 'MEASUREMENT_TYPE_PULSE_CNT'")
  void testMeasurementTypeForNumber_whenEight_thenReturnMeasurementTypePulseCnt() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT,
        MeasurementTypeProtos.MeasurementType.forNumber(8));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_OK_ALARM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when five; then return 'MEASUREMENT_TYPE_OK_ALARM'")
  void testMeasurementTypeForNumber_whenFive_thenReturnMeasurementTypeOkAlarm() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OK_ALARM,
        MeasurementTypeProtos.MeasurementType.forNumber(5));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when minus one; then return 'null'")
  void testMeasurementTypeForNumber_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MeasurementTypeProtos.MeasurementType.forNumber(-1));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_TEMPERATURE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when one; then return 'MEASUREMENT_TYPE_TEMPERATURE'")
  void testMeasurementTypeForNumber_whenOne_thenReturnMeasurementTypeTemperature() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_TEMPERATURE,
        MeasurementTypeProtos.MeasurementType.forNumber(1));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_FLOODING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when seven; then return 'MEASUREMENT_TYPE_FLOODING'")
  void testMeasurementTypeForNumber_whenSeven_thenReturnMeasurementTypeFlooding() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_FLOODING,
        MeasurementTypeProtos.MeasurementType.forNumber(7));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_IAQ}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when six; then return 'MEASUREMENT_TYPE_IAQ'")
  void testMeasurementTypeForNumber_whenSix_thenReturnMeasurementTypeIaq() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_IAQ,
        MeasurementTypeProtos.MeasurementType.forNumber(6));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_HUMIDITY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when two; then return 'MEASUREMENT_TYPE_HUMIDITY'")
  void testMeasurementTypeForNumber_whenTwo_thenReturnMeasurementTypeHumidity() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HUMIDITY,
        MeasurementTypeProtos.MeasurementType.forNumber(2));
  }

  /**
   * Test MeasurementType {@link MeasurementType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_NO_SENSOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#forNumber(int)}
   */
  @Test
  @DisplayName("Test MeasurementType forNumber(int); when zero; then return 'MEASUREMENT_TYPE_NO_SENSOR'")
  void testMeasurementTypeForNumber_whenZero_thenReturnMeasurementTypeNoSensor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR,
        MeasurementTypeProtos.MeasurementType.forNumber(0));
  }

  /**
   * Test MeasurementType {@link MeasurementType#getDescriptor()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#getDescriptor()}
   */
  @Test
  @DisplayName("Test MeasurementType getDescriptor()")
  void testMeasurementTypeGetDescriptor() {
    // Arrange and Act
    Descriptors.EnumDescriptor actualDescriptor = MeasurementTypeProtos.MeasurementType.getDescriptor();

    // Assert
    DescriptorProtos.EnumDescriptorProto toProtoResult = actualDescriptor.toProto();
    DescriptorProtos.EnumDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    DescriptorProtos.EnumOptions options = actualDescriptor.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    Descriptors.FileDescriptor file = actualDescriptor.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = options.getDescriptorForType();
    DescriptorProtos.MessageOptions options3 = descriptorForType.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.EnumValueDescriptor> values = actualDescriptor.getValues();
    assertEquals(ConfigProtos.ProtoConfig.DNS_TTL_CONFIG_FIELD_NUMBER, values.size());
    Descriptors.EnumValueDescriptor getResult = values.get(0);
    DescriptorProtos.EnumValueOptions options4 = getResult.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.EnumValueDescriptorProto toProtoResult7 = getResult.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.EnumValueDescriptor getResult2 = values.get(1);
    DescriptorProtos.EnumValueDescriptorProto toProtoResult8 = getResult2.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    Descriptors.EnumValueDescriptor getResult3 = values.get(2);
    DescriptorProtos.EnumValueDescriptorProto toProtoResult9 = getResult3.toProto();
    assertEquals("", toProtoResult9.getInitializationErrorString());
    Descriptors.EnumValueDescriptor getResult4 = values
        .get(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE);
    DescriptorProtos.EnumValueDescriptorProto toProtoResult10 = getResult4.toProto();
    assertEquals("", toProtoResult10.getInitializationErrorString());
    Descriptors.EnumValueDescriptor getResult5 = values
        .get(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE);
    DescriptorProtos.EnumValueDescriptorProto toProtoResult11 = getResult5.toProto();
    assertEquals("", toProtoResult11.getInitializationErrorString());
    Descriptors.EnumValueDescriptor getResult6 = values
        .get(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR_VALUE);
    DescriptorProtos.EnumValueDescriptorProto toProtoResult12 = getResult6.toProto();
    assertEquals("", toProtoResult12.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options2.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", toProtoResult2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options2.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options2.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options2.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options2.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options2.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options2.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options2.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options2.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("", file.getPackage());
    assertEquals("EnumDescriptorProto", toProtoResult4.getName());
    assertEquals("EnumDescriptorProto", descriptorForType2.getName());
    assertEquals("EnumOptions", toProtoResult3.getName());
    assertEquals("EnumOptions", descriptorForType.getName());
    Descriptors.Descriptor descriptorForType5 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType5.getName());
    assertEquals("FileDescriptorProto", toProtoResult6.getName());
    assertEquals("FileDescriptorProto", descriptorForType4.getName());
    assertEquals("FileOptions", toProtoResult5.getName());
    assertEquals("FileOptions", descriptorForType3.getName());
    assertEquals("MEASUREMENT_TYPE_CURRENT_PRECISE", toProtoResult10.getName());
    assertEquals("MEASUREMENT_TYPE_CURRENT_PRECISE", getResult4.getName());
    assertEquals("MEASUREMENT_TYPE_HUMIDITY", toProtoResult9.getName());
    assertEquals("MEASUREMENT_TYPE_HUMIDITY", getResult3.getName());
    assertEquals("MEASUREMENT_TYPE_NO_SENSOR", toProtoResult7.getName());
    assertEquals("MEASUREMENT_TYPE_NO_SENSOR", getResult.getName());
    assertEquals("MEASUREMENT_TYPE_OUTPUT_CONTROL", toProtoResult11.getName());
    assertEquals("MEASUREMENT_TYPE_OUTPUT_CONTROL", getResult5.getName());
    assertEquals("MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR", toProtoResult12.getName());
    assertEquals("MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR", getResult6.getName());
    assertEquals("MEASUREMENT_TYPE_TEMPERATURE", toProtoResult8.getName());
    assertEquals("MEASUREMENT_TYPE_TEMPERATURE", getResult2.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("MeasurementType", nameBytes.toStringUtf8());
    assertEquals("MeasurementType", toProtoResult.getName());
    assertEquals("MeasurementType", actualDescriptor.getFullName());
    assertEquals("MeasurementType", actualDescriptor.getName());
    assertEquals("MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE", getResult4.getFullName());
    assertEquals("MeasurementType.MEASUREMENT_TYPE_HUMIDITY", getResult3.getFullName());
    assertEquals("MeasurementType.MEASUREMENT_TYPE_NO_SENSOR", getResult.getFullName());
    assertEquals("MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL", getResult5.getFullName());
    assertEquals("MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR", getResult6.getFullName());
    assertEquals("MeasurementType.MEASUREMENT_TYPE_TEMPERATURE", getResult2.getFullName());
    ByteString javaOuterClassnameBytes = options2.getJavaOuterClassnameBytes();
    assertEquals("MeasurementTypeProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MeasurementTypeProtos", options2.getJavaOuterClassname());
    Descriptors.Descriptor descriptorForType6 = sourceCodeInfo.getDescriptorForType();
    assertEquals("SourceCodeInfo", descriptorForType6.getName());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    Descriptors.FieldDescriptor getResult7 = fields.get(0);
    assertEquals("allowAlias", getResult7.getJsonName());
    assertEquals("allow_alias", getResult7.getName());
    Descriptors.FieldDescriptor getResult8 = fields.get(1);
    assertEquals("deprecated", getResult8.getJsonName());
    assertEquals("deprecated", getResult8.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("efento/proto_measurement_types.proto", nameBytes2.toStringUtf8());
    assertEquals("efento/proto_measurement_types.proto", toProtoResult2.getName());
    assertEquals("efento/proto_measurement_types.proto", file.getFullName());
    assertEquals("efento/proto_measurement_types.proto", file.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.EnumDescriptorProto", descriptorForType2.getFullName());
    assertEquals("google.protobuf.EnumOptions", descriptorForType.getFullName());
    assertEquals("google.protobuf.EnumOptions.allow_alias", getResult7.getFullName());
    assertEquals("google.protobuf.EnumOptions.deprecated", getResult8.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType3.getFullName());
    assertEquals("google.protobuf.SourceCodeInfo", descriptorForType6.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options2.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.transport.coap", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.transport.coap", options2.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(actualDescriptor.getContainingType());
    assertNull(getResult7.getContainingOneof());
    assertNull(getResult8.getContainingOneof());
    Descriptors.FieldDescriptor getResult9 = fields.get(3);
    assertNull(getResult9.getContainingOneof());
    assertNull(getResult7.getRealContainingOneof());
    assertNull(getResult8.getRealContainingOneof());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult5.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, defaultInstanceForType.getValueCount());
    assertEquals(0, options.getSerializedSize());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, toProtoResult7.getNumber());
    assertEquals(0, options4.getSerializedSize());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, toProtoResult2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getNumber());
    assertEquals(0, getResult7.getIndex());
    UnknownFieldSet unknownFields = options.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(1, toProtoResult5.getEnumTypeCount());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNestedTypeCount());
    assertEquals(1, toProtoResult3.getReservedRangeCount());
    assertEquals(1, toProtoResult5.getReservedRangeCount());
    assertEquals(1, toProtoResult8.getNumber());
    assertEquals(1, toProtoResult2.getEnumTypeCount());
    assertEquals(1, descriptorForType4.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult2.getNumber());
    assertEquals(1, getResult8.getIndex());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    assertEquals(1, descriptorForType3.getEnumTypes().size());
    assertEquals(1, descriptorForType2.getNestedTypes().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    assertEquals(1226, toProtoResult5.getSerializedSize());
    assertEquals(1540, toProtoResult.getSerializedSize());
    assertEquals(1657, toProtoResult2.getSerializedSize());
    assertEquals(2, toProtoResult9.getNumber());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult3.getNumber());
    assertEquals(2, getResult7.getNumber());
    assertEquals(2, toProtoResult.getAllFields().size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options2.getAllFields();
    assertEquals(2, allFields.size());
    assertEquals(3, getResult8.getNumber());
    assertEquals(337, toProtoResult3.getSerializedSize());
    assertEquals(355, toProtoResult4.getSerializedSize());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult3.getFieldCount());
    assertEquals(5, toProtoResult4.getFieldCount());
    assertEquals(5, descriptorForType2.getFields().size());
    assertEquals(6, descriptorForType2.getIndex());
    assertEquals(66, options2.getSerializedSize());
    assertEquals(664, toProtoResult6.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options2.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult7.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult8.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult7.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult8.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult7.getLiteType());
    assertEquals(WireFormat.FieldType.BOOL, getResult8.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult7.getLiteJavaType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult8.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(options.getAllowAlias());
    assertFalse(options.getDeprecated());
    assertFalse(options.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.hasAllowAlias());
    assertFalse(options.hasDeprecated());
    assertFalse(options.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.hasFeatures());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult9.hasOptions());
    assertFalse(toProtoResult10.hasOptions());
    assertFalse(toProtoResult11.hasOptions());
    assertFalse(toProtoResult12.hasOptions());
    assertFalse(options4.getDebugRedact());
    assertFalse(options4.getDeprecated());
    assertFalse(options4.hasDebugRedact());
    assertFalse(options4.hasDeprecated());
    assertFalse(options4.hasFeatures());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(toProtoResult2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options2.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options2.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options2.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options2.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options2.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options2.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options2.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options2.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options2.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options2.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options2.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options2.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options2.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options2.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options2.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options2.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options2.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options2.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options2.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options2.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options2.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options2.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options2.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options2.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options2.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options2.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options2.hasSwiftPrefix());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options3.getMapEntry());
    assertFalse(options3.getMessageSetWireFormat());
    assertFalse(options3.getNoStandardDescriptorAccessor());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasMapEntry());
    assertFalse(options3.hasMessageSetWireFormat());
    assertFalse(options3.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType6.isExtendable());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(descriptorForType4.isExtendable());
    assertFalse(actualDescriptor.isClosed());
    assertFalse(getResult7.hasDefaultValue());
    assertFalse(getResult7.isExtension());
    assertFalse(getResult8.isExtension());
    assertFalse(getResult7.isMapField());
    assertFalse(getResult8.isMapField());
    assertFalse(getResult7.isPackable());
    assertFalse(getResult8.isPackable());
    assertFalse(getResult7.isPacked());
    assertFalse(getResult8.isPacked());
    assertFalse(getResult7.isRepeated());
    assertFalse(getResult8.isRepeated());
    assertFalse(getResult7.isRequired());
    assertFalse(getResult8.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult9.hasName());
    assertTrue(toProtoResult10.hasName());
    assertTrue(toProtoResult11.hasName());
    assertTrue(toProtoResult12.hasName());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult9.hasNumber());
    assertTrue(toProtoResult10.hasNumber());
    assertTrue(toProtoResult11.hasNumber());
    assertTrue(toProtoResult12.hasNumber());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(toProtoResult9.isInitialized());
    assertTrue(toProtoResult10.isInitialized());
    assertTrue(toProtoResult11.isInitialized());
    assertTrue(toProtoResult12.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options2.getCcEnableArenas());
    assertTrue(options2.hasJavaOuterClassname());
    assertTrue(options2.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType5.isExtendable());
    assertTrue(descriptorForType.isExtendable());
    assertTrue(descriptorForType3.isExtendable());
    assertTrue(getResult8.hasDefaultValue());
    assertTrue(getResult7.hasOptionalKeyword());
    assertTrue(getResult8.hasOptionalKeyword());
    assertTrue(getResult7.hasPresence());
    assertTrue(getResult8.hasPresence());
    assertTrue(getResult7.isOptional());
    assertTrue(getResult8.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = syntaxBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType2.findInitializationErrors().isEmpty());
    assertTrue(sourceCodeInfo.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType3.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType4.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType4.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType4.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType4.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType4.getRealOneofs().isEmpty());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertTrue(dependencies.isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getMessageTypes().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType2.getAllFields().isEmpty());
    assertTrue(sourceCodeInfo.getAllFields().isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType3.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = options.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType3.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options2.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options2.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options2.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options2.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options2.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options2.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options2.getSwiftPrefixBytes());
    assertEquals(dependencies, options3.findInitializationErrors());
    assertEquals(dependencies, toProtoResult3.findInitializationErrors());
    assertEquals(dependencies, toProtoResult4.findInitializationErrors());
    assertEquals(dependencies, toProtoResult5.findInitializationErrors());
    assertEquals(dependencies, toProtoResult6.findInitializationErrors());
    assertEquals(dependencies, options4.findInitializationErrors());
    assertEquals(dependencies, toProtoResult7.findInitializationErrors());
    assertEquals(dependencies, toProtoResult8.findInitializationErrors());
    assertEquals(dependencies, toProtoResult9.findInitializationErrors());
    assertEquals(dependencies, toProtoResult10.findInitializationErrors());
    assertEquals(dependencies, toProtoResult11.findInitializationErrors());
    assertEquals(dependencies, toProtoResult12.findInitializationErrors());
    assertEquals(dependencies, descriptorForType6.getEnumTypes());
    assertEquals(dependencies, descriptorForType5.getExtensions());
    assertEquals(dependencies, descriptorForType6.getExtensions());
    assertEquals(dependencies, descriptorForType5.getNestedTypes());
    assertEquals(dependencies, descriptorForType5.getOneofs());
    assertEquals(dependencies, descriptorForType6.getOneofs());
    assertEquals(dependencies, descriptorForType5.getRealOneofs());
    assertEquals(dependencies, descriptorForType6.getRealOneofs());
    assertEquals(dependencies, file2.getDependencies());
    assertEquals(dependencies, file2.getExtensions());
    assertEquals(dependencies, file2.getPublicDependencies());
    assertEquals(dependencies, file2.getServices());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, options4.getAllFields());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields2, options4.getAllFieldsRaw());
    assertEquals(allFields, options2.getAllFieldsRaw());
    assertEquals(ConfigProtos.ProtoConfig.DNS_TTL_CONFIG_FIELD_NUMBER, toProtoResult.getValueCount());
    List<DescriptorProtos.EnumValueDescriptorProto> valueList = toProtoResult.getValueList();
    assertEquals(ConfigProtos.ProtoConfig.DNS_TTL_CONFIG_FIELD_NUMBER, valueList.size());
    assertEquals(ConfigProtos.ProtoConfig.MODEM_UPDATE_REQUEST_FIELD_NUMBER, toProtoResult12.getSerializedSize());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_BREATH_VOC_VALUE,
        toProtoResult7.getSerializedSize());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CH4_GAS_VALUE, descriptorForType6.getIndex());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO2_EQUIVALENT_VALUE,
        toProtoResult9.getSerializedSize());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE,
        toProtoResult10.getNumber());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE, getResult4.getIndex());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE, getResult4.getNumber());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_H2S_GAS_VALUE, descriptorForType.getIndex());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HIGH_PRESSURE_VALUE,
        toProtoResult5.getFieldCount());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HIGH_PRESSURE_VALUE,
        descriptorForType3.getFields().size());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO2_GAS_VALUE, toProtoResult6.getFieldCount());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO2_GAS_VALUE,
        descriptorForType4.getFields().size());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NOISE_LEVEL_VALUE,
        descriptorForType5.getIndex());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE,
        toProtoResult11.getNumber());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE, getResult5.getIndex());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE, getResult5.getNumber());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PERCENTAGE_VALUE,
        toProtoResult8.getSerializedSize());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR_VALUE,
        toProtoResult10.getSerializedSize());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR_VALUE,
        toProtoResult11.getSerializedSize());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR_VALUE,
        toProtoResult12.getNumber());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR_VALUE,
        getResult6.getIndex());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR_VALUE,
        getResult6.getNumber());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER_VALUE,
        descriptorForType3.getIndex());
    assertEquals('M', iteratorResult.next().byteValue());
    assertEquals('M', iteratorResult4.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('e', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult5.next().byteValue());
    List<DescriptorProtos.DescriptorProto.ExtensionRange> expectedExtensionRangeOrBuilderList = toProtoResult5
        .getExtensionRangeList();
    assertSame(expectedExtensionRangeOrBuilderList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(valueList, toProtoResult.getValueOrBuilderList());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options4.getFeatures());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getValueList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getValueOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions defaultInstanceForType4 = defaultInstanceForType3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, defaultInstanceForType2.getOptions());
    assertSame(defaultInstanceForType4, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(file2, descriptorForType5.getFile());
    assertSame(file2, descriptorForType6.getFile());
    assertSame(file2, descriptorForType2.getFile());
    assertSame(file2, descriptorForType3.getFile());
    assertSame(file2, descriptorForType4.getFile());
    assertSame(file2, getResult7.getFile());
    assertSame(file2, getResult8.getFile());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options3, descriptorForType6.getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(options, defaultInstanceForType.getOptions());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(toProtoResult, enumTypeList.get(0));
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult8.getOptions());
    assertSame(options4, toProtoResult9.getOptions());
    assertSame(options4, toProtoResult10.getOptions());
    assertSame(options4, toProtoResult11.getOptions());
    assertSame(options4, toProtoResult12.getOptions());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, toProtoResult8.getOptionsOrBuilder());
    assertSame(options4, toProtoResult9.getOptionsOrBuilder());
    assertSame(options4, toProtoResult10.getOptionsOrBuilder());
    assertSame(options4, toProtoResult11.getOptionsOrBuilder());
    assertSame(options4, toProtoResult12.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult7, valueList.get(0));
    assertSame(toProtoResult8, valueList.get(1));
    assertSame(toProtoResult10,
        valueList.get(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE));
    assertSame(toProtoResult11,
        valueList.get(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE));
    assertSame(options2, toProtoResult2.getOptions());
    assertSame(options2, toProtoResult2.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType2, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType3, defaultInstanceForType3.getDescriptorForType());
    assertSame(descriptorForType4, defaultInstanceForType2.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, toProtoResult9.getUnknownFields());
    assertSame(unknownFields, toProtoResult10.getUnknownFields());
    assertSame(unknownFields, toProtoResult11.getUnknownFields());
    assertSame(unknownFields, toProtoResult12.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(actualDescriptor, getResult.getType());
    assertSame(actualDescriptor, getResult2.getType());
    assertSame(actualDescriptor, getResult3.getType());
    assertSame(actualDescriptor, getResult4.getType());
    assertSame(actualDescriptor, getResult5.getType());
    assertSame(actualDescriptor, getResult6.getType());
    assertSame(actualDescriptor, enumTypes.get(0));
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Test MeasurementType {@link MeasurementType#getDescriptorForType()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test MeasurementType getDescriptorForType()")
  void testMeasurementTypeGetDescriptorForType() {
    // Arrange and Act
    Descriptors.EnumDescriptor actualDescriptorForType = MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR
        .getDescriptorForType();

    // Assert
    DescriptorProtos.EnumDescriptorProto toProtoResult = actualDescriptorForType.toProto();
    DescriptorProtos.EnumDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    DescriptorProtos.EnumOptions options = actualDescriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    Descriptors.FileDescriptor file = actualDescriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = options.getDescriptorForType();
    DescriptorProtos.MessageOptions options3 = descriptorForType.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.EnumValueDescriptor> values = actualDescriptorForType.getValues();
    assertEquals(ConfigProtos.ProtoConfig.DNS_TTL_CONFIG_FIELD_NUMBER, values.size());
    Descriptors.EnumValueDescriptor getResult = values.get(0);
    DescriptorProtos.EnumValueOptions options4 = getResult.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.EnumValueDescriptorProto toProtoResult7 = getResult.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.EnumValueDescriptor getResult2 = values.get(1);
    DescriptorProtos.EnumValueDescriptorProto toProtoResult8 = getResult2.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    Descriptors.EnumValueDescriptor getResult3 = values.get(2);
    DescriptorProtos.EnumValueDescriptorProto toProtoResult9 = getResult3.toProto();
    assertEquals("", toProtoResult9.getInitializationErrorString());
    Descriptors.EnumValueDescriptor getResult4 = values
        .get(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE);
    DescriptorProtos.EnumValueDescriptorProto toProtoResult10 = getResult4.toProto();
    assertEquals("", toProtoResult10.getInitializationErrorString());
    Descriptors.EnumValueDescriptor getResult5 = values
        .get(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE);
    DescriptorProtos.EnumValueDescriptorProto toProtoResult11 = getResult5.toProto();
    assertEquals("", toProtoResult11.getInitializationErrorString());
    Descriptors.EnumValueDescriptor getResult6 = values
        .get(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR_VALUE);
    DescriptorProtos.EnumValueDescriptorProto toProtoResult12 = getResult6.toProto();
    assertEquals("", toProtoResult12.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options2.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", toProtoResult2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options2.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options2.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options2.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options2.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options2.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options2.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options2.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options2.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("", file.getPackage());
    assertEquals("EnumDescriptorProto", toProtoResult4.getName());
    assertEquals("EnumDescriptorProto", descriptorForType2.getName());
    assertEquals("EnumOptions", toProtoResult3.getName());
    assertEquals("EnumOptions", descriptorForType.getName());
    Descriptors.Descriptor descriptorForType5 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType5.getName());
    assertEquals("FileDescriptorProto", toProtoResult6.getName());
    assertEquals("FileDescriptorProto", descriptorForType4.getName());
    assertEquals("FileOptions", toProtoResult5.getName());
    assertEquals("FileOptions", descriptorForType3.getName());
    assertEquals("MEASUREMENT_TYPE_CURRENT_PRECISE", toProtoResult10.getName());
    assertEquals("MEASUREMENT_TYPE_CURRENT_PRECISE", getResult4.getName());
    assertEquals("MEASUREMENT_TYPE_HUMIDITY", toProtoResult9.getName());
    assertEquals("MEASUREMENT_TYPE_HUMIDITY", getResult3.getName());
    assertEquals("MEASUREMENT_TYPE_NO_SENSOR", toProtoResult7.getName());
    assertEquals("MEASUREMENT_TYPE_NO_SENSOR", getResult.getName());
    assertEquals("MEASUREMENT_TYPE_OUTPUT_CONTROL", toProtoResult11.getName());
    assertEquals("MEASUREMENT_TYPE_OUTPUT_CONTROL", getResult5.getName());
    assertEquals("MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR", toProtoResult12.getName());
    assertEquals("MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR", getResult6.getName());
    assertEquals("MEASUREMENT_TYPE_TEMPERATURE", toProtoResult8.getName());
    assertEquals("MEASUREMENT_TYPE_TEMPERATURE", getResult2.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("MeasurementType", nameBytes.toStringUtf8());
    assertEquals("MeasurementType", toProtoResult.getName());
    assertEquals("MeasurementType", actualDescriptorForType.getFullName());
    assertEquals("MeasurementType", actualDescriptorForType.getName());
    assertEquals("MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE", getResult4.getFullName());
    assertEquals("MeasurementType.MEASUREMENT_TYPE_HUMIDITY", getResult3.getFullName());
    assertEquals("MeasurementType.MEASUREMENT_TYPE_NO_SENSOR", getResult.getFullName());
    assertEquals("MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL", getResult5.getFullName());
    assertEquals("MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR", getResult6.getFullName());
    assertEquals("MeasurementType.MEASUREMENT_TYPE_TEMPERATURE", getResult2.getFullName());
    ByteString javaOuterClassnameBytes = options2.getJavaOuterClassnameBytes();
    assertEquals("MeasurementTypeProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MeasurementTypeProtos", options2.getJavaOuterClassname());
    Descriptors.Descriptor descriptorForType6 = sourceCodeInfo.getDescriptorForType();
    assertEquals("SourceCodeInfo", descriptorForType6.getName());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    Descriptors.FieldDescriptor getResult7 = fields.get(0);
    assertEquals("allowAlias", getResult7.getJsonName());
    assertEquals("allow_alias", getResult7.getName());
    Descriptors.FieldDescriptor getResult8 = fields.get(1);
    assertEquals("deprecated", getResult8.getJsonName());
    assertEquals("deprecated", getResult8.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("efento/proto_measurement_types.proto", nameBytes2.toStringUtf8());
    assertEquals("efento/proto_measurement_types.proto", toProtoResult2.getName());
    assertEquals("efento/proto_measurement_types.proto", file.getFullName());
    assertEquals("efento/proto_measurement_types.proto", file.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.EnumDescriptorProto", descriptorForType2.getFullName());
    assertEquals("google.protobuf.EnumOptions", descriptorForType.getFullName());
    assertEquals("google.protobuf.EnumOptions.allow_alias", getResult7.getFullName());
    assertEquals("google.protobuf.EnumOptions.deprecated", getResult8.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType3.getFullName());
    assertEquals("google.protobuf.SourceCodeInfo", descriptorForType6.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options2.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.transport.coap", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.transport.coap", options2.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(actualDescriptorForType.getContainingType());
    assertNull(getResult7.getContainingOneof());
    assertNull(getResult8.getContainingOneof());
    Descriptors.FieldDescriptor getResult9 = fields.get(3);
    assertNull(getResult9.getContainingOneof());
    assertNull(getResult7.getRealContainingOneof());
    assertNull(getResult8.getRealContainingOneof());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult5.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, defaultInstanceForType.getValueCount());
    assertEquals(0, options.getSerializedSize());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, toProtoResult7.getNumber());
    assertEquals(0, options4.getSerializedSize());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, toProtoResult2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult.getNumber());
    assertEquals(0, getResult7.getIndex());
    UnknownFieldSet unknownFields = options.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(1, toProtoResult5.getEnumTypeCount());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNestedTypeCount());
    assertEquals(1, toProtoResult3.getReservedRangeCount());
    assertEquals(1, toProtoResult5.getReservedRangeCount());
    assertEquals(1, toProtoResult8.getNumber());
    assertEquals(1, toProtoResult2.getEnumTypeCount());
    assertEquals(1, descriptorForType4.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult2.getNumber());
    assertEquals(1, getResult8.getIndex());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    assertEquals(1, descriptorForType3.getEnumTypes().size());
    assertEquals(1, descriptorForType2.getNestedTypes().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    assertEquals(1226, toProtoResult5.getSerializedSize());
    assertEquals(1540, toProtoResult.getSerializedSize());
    assertEquals(1657, toProtoResult2.getSerializedSize());
    assertEquals(2, toProtoResult9.getNumber());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult3.getNumber());
    assertEquals(2, getResult7.getNumber());
    assertEquals(2, toProtoResult.getAllFields().size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options2.getAllFields();
    assertEquals(2, allFields.size());
    assertEquals(3, getResult8.getNumber());
    assertEquals(337, toProtoResult3.getSerializedSize());
    assertEquals(355, toProtoResult4.getSerializedSize());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult3.getFieldCount());
    assertEquals(5, toProtoResult4.getFieldCount());
    assertEquals(5, descriptorForType2.getFields().size());
    assertEquals(6, descriptorForType2.getIndex());
    assertEquals(66, options2.getSerializedSize());
    assertEquals(664, toProtoResult6.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options2.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult7.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult8.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult7.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult8.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult7.getLiteType());
    assertEquals(WireFormat.FieldType.BOOL, getResult8.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult7.getLiteJavaType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult8.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(options.getAllowAlias());
    assertFalse(options.getDeprecated());
    assertFalse(options.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.hasAllowAlias());
    assertFalse(options.hasDeprecated());
    assertFalse(options.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.hasFeatures());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult9.hasOptions());
    assertFalse(toProtoResult10.hasOptions());
    assertFalse(toProtoResult11.hasOptions());
    assertFalse(toProtoResult12.hasOptions());
    assertFalse(options4.getDebugRedact());
    assertFalse(options4.getDeprecated());
    assertFalse(options4.hasDebugRedact());
    assertFalse(options4.hasDeprecated());
    assertFalse(options4.hasFeatures());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(toProtoResult2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options2.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options2.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options2.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options2.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options2.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options2.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options2.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options2.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options2.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options2.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options2.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options2.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options2.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options2.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options2.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options2.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options2.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options2.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options2.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options2.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options2.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options2.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options2.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options2.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options2.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options2.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options2.hasSwiftPrefix());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options3.getMapEntry());
    assertFalse(options3.getMessageSetWireFormat());
    assertFalse(options3.getNoStandardDescriptorAccessor());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasMapEntry());
    assertFalse(options3.hasMessageSetWireFormat());
    assertFalse(options3.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType6.isExtendable());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(descriptorForType4.isExtendable());
    assertFalse(actualDescriptorForType.isClosed());
    assertFalse(getResult7.hasDefaultValue());
    assertFalse(getResult7.isExtension());
    assertFalse(getResult8.isExtension());
    assertFalse(getResult7.isMapField());
    assertFalse(getResult8.isMapField());
    assertFalse(getResult7.isPackable());
    assertFalse(getResult8.isPackable());
    assertFalse(getResult7.isPacked());
    assertFalse(getResult8.isPacked());
    assertFalse(getResult7.isRepeated());
    assertFalse(getResult8.isRepeated());
    assertFalse(getResult7.isRequired());
    assertFalse(getResult8.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult9.hasName());
    assertTrue(toProtoResult10.hasName());
    assertTrue(toProtoResult11.hasName());
    assertTrue(toProtoResult12.hasName());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult9.hasNumber());
    assertTrue(toProtoResult10.hasNumber());
    assertTrue(toProtoResult11.hasNumber());
    assertTrue(toProtoResult12.hasNumber());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(toProtoResult9.isInitialized());
    assertTrue(toProtoResult10.isInitialized());
    assertTrue(toProtoResult11.isInitialized());
    assertTrue(toProtoResult12.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options2.getCcEnableArenas());
    assertTrue(options2.hasJavaOuterClassname());
    assertTrue(options2.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType5.isExtendable());
    assertTrue(descriptorForType.isExtendable());
    assertTrue(descriptorForType3.isExtendable());
    assertTrue(getResult8.hasDefaultValue());
    assertTrue(getResult7.hasOptionalKeyword());
    assertTrue(getResult8.hasOptionalKeyword());
    assertTrue(getResult7.hasPresence());
    assertTrue(getResult8.hasPresence());
    assertTrue(getResult7.isOptional());
    assertTrue(getResult8.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = syntaxBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType2.findInitializationErrors().isEmpty());
    assertTrue(sourceCodeInfo.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType3.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType4.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType4.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType4.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType4.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType4.getRealOneofs().isEmpty());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertTrue(dependencies.isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getMessageTypes().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType2.getAllFields().isEmpty());
    assertTrue(sourceCodeInfo.getAllFields().isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType3.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = options.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType3.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options2.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options2.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options2.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options2.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options2.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options2.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options2.getSwiftPrefixBytes());
    assertEquals(dependencies, options3.findInitializationErrors());
    assertEquals(dependencies, toProtoResult3.findInitializationErrors());
    assertEquals(dependencies, toProtoResult4.findInitializationErrors());
    assertEquals(dependencies, toProtoResult5.findInitializationErrors());
    assertEquals(dependencies, toProtoResult6.findInitializationErrors());
    assertEquals(dependencies, options4.findInitializationErrors());
    assertEquals(dependencies, toProtoResult7.findInitializationErrors());
    assertEquals(dependencies, toProtoResult8.findInitializationErrors());
    assertEquals(dependencies, toProtoResult9.findInitializationErrors());
    assertEquals(dependencies, toProtoResult10.findInitializationErrors());
    assertEquals(dependencies, toProtoResult11.findInitializationErrors());
    assertEquals(dependencies, toProtoResult12.findInitializationErrors());
    assertEquals(dependencies, descriptorForType6.getEnumTypes());
    assertEquals(dependencies, descriptorForType5.getExtensions());
    assertEquals(dependencies, descriptorForType6.getExtensions());
    assertEquals(dependencies, descriptorForType5.getNestedTypes());
    assertEquals(dependencies, descriptorForType5.getOneofs());
    assertEquals(dependencies, descriptorForType6.getOneofs());
    assertEquals(dependencies, descriptorForType5.getRealOneofs());
    assertEquals(dependencies, descriptorForType6.getRealOneofs());
    assertEquals(dependencies, file2.getDependencies());
    assertEquals(dependencies, file2.getExtensions());
    assertEquals(dependencies, file2.getPublicDependencies());
    assertEquals(dependencies, file2.getServices());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, options4.getAllFields());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields2, options4.getAllFieldsRaw());
    assertEquals(allFields, options2.getAllFieldsRaw());
    assertEquals(ConfigProtos.ProtoConfig.DNS_TTL_CONFIG_FIELD_NUMBER, toProtoResult.getValueCount());
    List<DescriptorProtos.EnumValueDescriptorProto> valueList = toProtoResult.getValueList();
    assertEquals(ConfigProtos.ProtoConfig.DNS_TTL_CONFIG_FIELD_NUMBER, valueList.size());
    assertEquals(ConfigProtos.ProtoConfig.MODEM_UPDATE_REQUEST_FIELD_NUMBER, toProtoResult12.getSerializedSize());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_BREATH_VOC_VALUE,
        toProtoResult7.getSerializedSize());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CH4_GAS_VALUE, descriptorForType6.getIndex());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO2_EQUIVALENT_VALUE,
        toProtoResult9.getSerializedSize());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE,
        toProtoResult10.getNumber());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE, getResult4.getIndex());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE, getResult4.getNumber());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_H2S_GAS_VALUE, descriptorForType.getIndex());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HIGH_PRESSURE_VALUE,
        toProtoResult5.getFieldCount());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HIGH_PRESSURE_VALUE,
        descriptorForType3.getFields().size());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO2_GAS_VALUE, toProtoResult6.getFieldCount());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO2_GAS_VALUE,
        descriptorForType4.getFields().size());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NOISE_LEVEL_VALUE,
        descriptorForType5.getIndex());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE,
        toProtoResult11.getNumber());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE, getResult5.getIndex());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE, getResult5.getNumber());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PERCENTAGE_VALUE,
        toProtoResult8.getSerializedSize());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR_VALUE,
        toProtoResult10.getSerializedSize());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR_VALUE,
        toProtoResult11.getSerializedSize());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR_VALUE,
        toProtoResult12.getNumber());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR_VALUE,
        getResult6.getIndex());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR_VALUE,
        getResult6.getNumber());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER_VALUE,
        descriptorForType3.getIndex());
    assertEquals('M', iteratorResult.next().byteValue());
    assertEquals('M', iteratorResult4.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('e', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult5.next().byteValue());
    List<DescriptorProtos.DescriptorProto.ExtensionRange> expectedExtensionRangeOrBuilderList = toProtoResult5
        .getExtensionRangeList();
    assertSame(expectedExtensionRangeOrBuilderList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(valueList, toProtoResult.getValueOrBuilderList());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options4.getFeatures());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getValueList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getValueOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions defaultInstanceForType4 = defaultInstanceForType3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, defaultInstanceForType2.getOptions());
    assertSame(defaultInstanceForType4, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(file2, descriptorForType5.getFile());
    assertSame(file2, descriptorForType6.getFile());
    assertSame(file2, descriptorForType2.getFile());
    assertSame(file2, descriptorForType3.getFile());
    assertSame(file2, descriptorForType4.getFile());
    assertSame(file2, getResult7.getFile());
    assertSame(file2, getResult8.getFile());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options3, descriptorForType6.getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(options, defaultInstanceForType.getOptions());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(toProtoResult, enumTypeList.get(0));
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult8.getOptions());
    assertSame(options4, toProtoResult9.getOptions());
    assertSame(options4, toProtoResult10.getOptions());
    assertSame(options4, toProtoResult11.getOptions());
    assertSame(options4, toProtoResult12.getOptions());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, toProtoResult8.getOptionsOrBuilder());
    assertSame(options4, toProtoResult9.getOptionsOrBuilder());
    assertSame(options4, toProtoResult10.getOptionsOrBuilder());
    assertSame(options4, toProtoResult11.getOptionsOrBuilder());
    assertSame(options4, toProtoResult12.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult7, valueList.get(0));
    assertSame(toProtoResult8, valueList.get(1));
    assertSame(toProtoResult10,
        valueList.get(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE));
    assertSame(toProtoResult11,
        valueList.get(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE));
    assertSame(options2, toProtoResult2.getOptions());
    assertSame(options2, toProtoResult2.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType2, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType3, defaultInstanceForType3.getDescriptorForType());
    assertSame(descriptorForType4, defaultInstanceForType2.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, toProtoResult9.getUnknownFields());
    assertSame(unknownFields, toProtoResult10.getUnknownFields());
    assertSame(unknownFields, toProtoResult11.getUnknownFields());
    assertSame(unknownFields, toProtoResult12.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(actualDescriptorForType, getResult.getType());
    assertSame(actualDescriptorForType, getResult2.getType());
    assertSame(actualDescriptorForType, getResult3.getType());
    assertSame(actualDescriptorForType, getResult4.getType());
    assertSame(actualDescriptorForType, getResult5.getType());
    assertSame(actualDescriptorForType, getResult6.getType());
    assertSame(actualDescriptorForType, enumTypes.get(0));
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Test MeasurementType {@link MeasurementType#getNumber()}.
   * <ul>
   *   <li>Given {@code MEASUREMENT_TYPE_NO_SENSOR}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#getNumber()}
   */
  @Test
  @DisplayName("Test MeasurementType getNumber(); given 'MEASUREMENT_TYPE_NO_SENSOR'; then return zero")
  void testMeasurementTypeGetNumber_givenMeasurementTypeNoSensor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR.getNumber());
  }

  /**
   * Test MeasurementType {@link MeasurementType#getNumber()}.
   * <ul>
   *   <li>Given {@link MeasurementType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#getNumber()}
   */
  @Test
  @DisplayName("Test MeasurementType getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  void testMeasurementTypeGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MeasurementTypeProtos.MeasurementType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test MeasurementType {@link MeasurementType#getValueDescriptor()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test MeasurementType getValueDescriptor(); then throw IllegalStateException")
  void testMeasurementTypeGetValueDescriptor_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> MeasurementTypeProtos.MeasurementType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER, actualInternalGetValueMapResult
        .findValueByNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_TEMPERATURE,
        actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HUMIDITY,
        actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE,
        actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_DIFFERENTIAL_PRESSURE,
        actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap6() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OK_ALARM,
        actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap7() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR,
        actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap8() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_IAQ,
        actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap9() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_FLOODING,
        actualInternalGetValueMapResult.findValueByNumber(7));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap10() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT,
        actualInternalGetValueMapResult.findValueByNumber(8));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap11() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELECTRICITY_METER,
        actualInternalGetValueMapResult
            .findValueByNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELECTRICITY_METER_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap12() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_SOIL_MOISTURE, actualInternalGetValueMapResult
        .findValueByNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_SOIL_MOISTURE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap13() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO_GAS, actualInternalGetValueMapResult
        .findValueByNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap14() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO2_GAS, actualInternalGetValueMapResult
        .findValueByNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO2_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap15() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_H2S_GAS, actualInternalGetValueMapResult
        .findValueByNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_H2S_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap16() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_AMBIENT_LIGHT, actualInternalGetValueMapResult
        .findValueByNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_AMBIENT_LIGHT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap17() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_1_0, actualInternalGetValueMapResult
        .findValueByNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_1_0_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap()")
  void testMeasurementTypeInternalGetValueMap18() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_2_5, actualInternalGetValueMapResult
        .findValueByNumber(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_2_5_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber minus one is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementTypeProtos.MeasurementType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test MeasurementType internalGetValueMap(); then return findValueByNumber minus one is 'null'")
  void testMeasurementTypeInternalGetValueMap_thenReturnFindValueByNumberMinusOneIsNull() {
    // Arrange and Act
    Internal.EnumLiteMap<MeasurementTypeProtos.MeasurementType> actualInternalGetValueMapResult = MeasurementTypeProtos.MeasurementType
        .internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(-1));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'")
  void testMeasurementTypeValueOfWithValue() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_DIFFERENTIAL_PRESSURE,
        MeasurementTypeProtos.MeasurementType.valueOf(4));
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MINOR,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MINOR_VALUE));
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_WIDE_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_AMBIENT_LIGHT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_AMBIENT_LIGHT'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeAmbientLight() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_AMBIENT_LIGHT,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_AMBIENT_LIGHT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeAtmosphericPressure() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ATMOSPHERIC_PRESSURE,
        MeasurementTypeProtos.MeasurementType.valueOf(3));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_BREATH_VOC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_BREATH_VOC'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeBreathVoc() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_BREATH_VOC,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_BREATH_VOC_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CELLULAR_GATEWAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CELLULAR_GATEWAY'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCellularGateway() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CELLULAR_GATEWAY,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CELLULAR_GATEWAY_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CH4_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CH4_GAS'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCh4Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CH4_GAS, MeasurementTypeProtos.MeasurementType
        .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CH4_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CO2_EQUIVALENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CO2_EQUIVALENT'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCo2Equivalent() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO2_EQUIVALENT,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO2_EQUIVALENT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CO2_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CO2_GAS'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCo2Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO2_GAS, MeasurementTypeProtos.MeasurementType
        .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO2_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CO_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CO_GAS'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCoGas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO_GAS, MeasurementTypeProtos.MeasurementType
        .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CO_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CURRENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CURRENT'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCurrent() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT, MeasurementTypeProtos.MeasurementType
        .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_CURRENT_PRECISE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_CURRENT_PRECISE'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeCurrentPrecise() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_CURRENT_PRECISE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_DISTANCE_MM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_DISTANCE_MM'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeDistanceMm() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_DISTANCE_MM,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_DISTANCE_MM_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeElecMeterAccMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeElecMeterAccMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELEC_METER_ACC_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_ELECTRICITY_METER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_ELECTRICITY_METER'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeElectricityMeter() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELECTRICITY_METER,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_ELECTRICITY_METER_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_H2S_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_H2S_GAS'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeH2sGas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_H2S_GAS, MeasurementTypeProtos.MeasurementType
        .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_H2S_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_HIGH_PRESSURE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_HIGH_PRESSURE'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeHighPressure() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HIGH_PRESSURE,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HIGH_PRESSURE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_HUMIDITY_ACCURATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_HUMIDITY_ACCURATE'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeHumidityAccurate() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HUMIDITY_ACCURATE,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HUMIDITY_ACCURATE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_NH3_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_NH3_GAS'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeNh3Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NH3_GAS, MeasurementTypeProtos.MeasurementType
        .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NH3_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_NO2_GAS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_NO2_GAS'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeNo2Gas() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO2_GAS, MeasurementTypeProtos.MeasurementType
        .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO2_GAS_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_NOISE_LEVEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_NOISE_LEVEL'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeNoiseLevel() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NOISE_LEVEL,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NOISE_LEVEL_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_OUTPUT_CONTROL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_OUTPUT_CONTROL'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeOutputControl() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OUTPUT_CONTROL_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PERCENTAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_PERCENTAGE'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypePercentage() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PERCENTAGE,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PERCENTAGE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PM_1_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_PM_1_0'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypePm10() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_1_0, MeasurementTypeProtos.MeasurementType
        .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_1_0_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PM_2_5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_PM_2_5'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypePm25() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_2_5, MeasurementTypeProtos.MeasurementType
        .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_2_5_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PM_10_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_PM_10_0'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypePm100() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_10_0, MeasurementTypeProtos.MeasurementType
        .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PM_10_0_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypePulseCntAccMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypePulseCntAccMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT_ACC_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_SOIL_MOISTURE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_SOIL_MOISTURE'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeSoilMoisture() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_SOIL_MOISTURE,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_SOIL_MOISTURE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_STATIC_IAQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_STATIC_IAQ'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeStaticIaq() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_STATIC_IAQ,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_STATIC_IAQ_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_VOLTAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_VOLTAGE'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeVoltage() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_VOLTAGE, MeasurementTypeProtos.MeasurementType
        .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_VOLTAGE_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_WATER_METER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_WATER_METER'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeWaterMeter() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeWaterMeterAccMajor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MAJOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code MEASUREMENT_TYPE_WATER_METER_ACC_MINOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; then return 'MEASUREMENT_TYPE_WATER_METER_ACC_MINOR'")
  void testMeasurementTypeValueOfWithValue_thenReturnMeasurementTypeWaterMeterAccMinor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MINOR,
        MeasurementTypeProtos.MeasurementType
            .valueOf(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_WATER_METER_ACC_MINOR_VALUE));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_PULSE_CNT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when eight; then return 'MEASUREMENT_TYPE_PULSE_CNT'")
  void testMeasurementTypeValueOfWithValue_whenEight_thenReturnMeasurementTypePulseCnt() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_PULSE_CNT,
        MeasurementTypeProtos.MeasurementType.valueOf(8));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_OK_ALARM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when five; then return 'MEASUREMENT_TYPE_OK_ALARM'")
  void testMeasurementTypeValueOfWithValue_whenFive_thenReturnMeasurementTypeOkAlarm() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_OK_ALARM,
        MeasurementTypeProtos.MeasurementType.valueOf(5));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when minus one; then return 'null'")
  void testMeasurementTypeValueOfWithValue_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MeasurementTypeProtos.MeasurementType.valueOf(-1));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_TEMPERATURE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when one; then return 'MEASUREMENT_TYPE_TEMPERATURE'")
  void testMeasurementTypeValueOfWithValue_whenOne_thenReturnMeasurementTypeTemperature() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_TEMPERATURE,
        MeasurementTypeProtos.MeasurementType.valueOf(1));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_FLOODING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when seven; then return 'MEASUREMENT_TYPE_FLOODING'")
  void testMeasurementTypeValueOfWithValue_whenSeven_thenReturnMeasurementTypeFlooding() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_FLOODING,
        MeasurementTypeProtos.MeasurementType.valueOf(7));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_IAQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when six; then return 'MEASUREMENT_TYPE_IAQ'")
  void testMeasurementTypeValueOfWithValue_whenSix_thenReturnMeasurementTypeIaq() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_IAQ,
        MeasurementTypeProtos.MeasurementType.valueOf(6));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_HUMIDITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when two; then return 'MEASUREMENT_TYPE_HUMIDITY'")
  void testMeasurementTypeValueOfWithValue_whenTwo_thenReturnMeasurementTypeHumidity() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_HUMIDITY,
        MeasurementTypeProtos.MeasurementType.valueOf(2));
  }

  /**
   * Test MeasurementType {@link MeasurementType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code MEASUREMENT_TYPE_NO_SENSOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementTypeProtos.MeasurementType#valueOf(int)}
   */
  @Test
  @DisplayName("Test MeasurementType valueOf(int) with 'value'; when zero; then return 'MEASUREMENT_TYPE_NO_SENSOR'")
  void testMeasurementTypeValueOfWithValue_whenZero_thenReturnMeasurementTypeNoSensor() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR,
        MeasurementTypeProtos.MeasurementType.valueOf(0));
  }
}
