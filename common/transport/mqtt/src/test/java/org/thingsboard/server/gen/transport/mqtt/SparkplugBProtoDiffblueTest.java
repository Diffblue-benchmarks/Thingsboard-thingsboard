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
package org.thingsboard.server.gen.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.DataSet;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.DataSet.DataSetValue;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.MetaData;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Metric;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Metric.ValueCase;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.PropertyValue;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Template;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Template.Parameter;

class SparkplugBProtoDiffblueTest {
  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link
   * DataSet.DataSetValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code BOOLEAN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); then return 'BOOLEAN_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"
  })
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.BOOLEAN_VALUE, DataSetValue.ValueCase.forNumber(5));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link
   * DataSet.DataSetValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); then return 'DOUBLE_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"
  })
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.DOUBLE_VALUE, DataSetValue.ValueCase.forNumber(4));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link
   * DataSet.DataSetValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code EXTENSION_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); then return 'EXTENSION_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"
  })
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_thenReturnExtensionValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.EXTENSION_VALUE, DataSetValue.ValueCase.forNumber(7));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link
   * DataSet.DataSetValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); then return 'FLOAT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"
  })
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.FLOAT_VALUE, DataSetValue.ValueCase.forNumber(3));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link
   * DataSet.DataSetValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); then return 'STRING_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"
  })
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.STRING_VALUE, DataSetValue.ValueCase.forNumber(6));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link
   * DataSet.DataSetValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code VALUE_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); then return 'VALUE_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"
  })
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, DataSetValue.ValueCase.forNumber(0));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link
   * DataSet.DataSetValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"
  })
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DataSetValue.ValueCase.forNumber(42));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link
   * DataSet.DataSetValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code INT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); when one; then return 'INT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"
  })
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_whenOne_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.INT_VALUE, DataSetValue.ValueCase.forNumber(1));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link
   * DataSet.DataSetValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); when two; then return 'LONG_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"
  })
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_whenTwo_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.LONG_VALUE, DataSetValue.ValueCase.forNumber(2));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#getNumber()}.
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#getNumber()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataSet.DataSetValue.ValueCase.getNumber()"})
  void testPayload_DataSet_DataSetValue_ValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, DataSetValue.ValueCase.valueOf("INT_VALUE").getNumber());
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.BOOLEAN_VALUE, DataSetValue.ValueCase.valueOf(5));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue2() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.EXTENSION_VALUE, DataSetValue.ValueCase.valueOf(7));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'DOUBLE_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.DOUBLE_VALUE, DataSetValue.ValueCase.valueOf(4));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'FLOAT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.FLOAT_VALUE, DataSetValue.ValueCase.valueOf(3));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code INT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'INT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.INT_VALUE, DataSetValue.ValueCase.valueOf(1));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'LONG_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.LONG_VALUE, DataSetValue.ValueCase.valueOf(2));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DataSetValue.ValueCase.valueOf(42));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'STRING_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.STRING_VALUE, DataSetValue.ValueCase.valueOf(6));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code VALUE_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'VALUE_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, DataSetValue.ValueCase.valueOf(0));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code BOOLEAN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'BOOLEAN_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.BOOLEAN_VALUE, ValueCase.forNumber(Metric.BOOLEAN_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code BYTES_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'BYTES_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnBytesValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.BYTES_VALUE, ValueCase.forNumber(Metric.BYTES_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code DATASET_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'DATASET_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnDatasetValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DATASET_VALUE, ValueCase.forNumber(Metric.DATASET_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'DOUBLE_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DOUBLE_VALUE, ValueCase.forNumber(Metric.DOUBLE_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code EXTENSION_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'EXTENSION_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnExtensionValue() {
    // Arrange, Act and Assert
    assertEquals(
        ValueCase.EXTENSION_VALUE, ValueCase.forNumber(Metric.EXTENSION_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'FLOAT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.FLOAT_VALUE, ValueCase.forNumber(Metric.FLOAT_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code INT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'INT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.INT_VALUE, ValueCase.forNumber(Metric.INT_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'LONG_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.LONG_VALUE, ValueCase.forNumber(Metric.LONG_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'STRING_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.STRING_VALUE, ValueCase.forNumber(Metric.STRING_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code TEMPLATE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'TEMPLATE_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnTemplateValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.TEMPLATE_VALUE, ValueCase.forNumber(Metric.TEMPLATE_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ValueCase.forNumber(42));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code VALUE_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Metric_ValueCase forNumber(int); when zero; then return 'VALUE_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_whenZero_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.VALUE_NOT_SET, ValueCase.forNumber(0));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#getNumber()}.
   *
   * <p>Method under test: {@link ValueCase#getNumber()}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ValueCase.getNumber()"})
  void testPayload_Metric_ValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(Metric.INT_VALUE_FIELD_NUMBER, ValueCase.valueOf("INT_VALUE").getNumber());
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code BOOLEAN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'BOOLEAN_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.BOOLEAN_VALUE, ValueCase.valueOf(Metric.BOOLEAN_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code BYTES_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'BYTES_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnBytesValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.BYTES_VALUE, ValueCase.valueOf(Metric.BYTES_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code DATASET_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'DATASET_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnDatasetValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DATASET_VALUE, ValueCase.valueOf(Metric.DATASET_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'DOUBLE_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DOUBLE_VALUE, ValueCase.valueOf(Metric.DOUBLE_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code EXTENSION_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'EXTENSION_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnExtensionValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.EXTENSION_VALUE, ValueCase.valueOf(Metric.EXTENSION_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'FLOAT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.FLOAT_VALUE, ValueCase.valueOf(Metric.FLOAT_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code INT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'INT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.INT_VALUE, ValueCase.valueOf(Metric.INT_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'LONG_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.LONG_VALUE, ValueCase.valueOf(Metric.LONG_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'STRING_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.STRING_VALUE, ValueCase.valueOf(Metric.STRING_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code TEMPLATE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'TEMPLATE_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnTemplateValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.TEMPLATE_VALUE, ValueCase.valueOf(Metric.TEMPLATE_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Metric_ValueCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ValueCase.valueOf(42));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code VALUE_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Metric_ValueCase valueOf(int) with 'value'; when zero; then return 'VALUE_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_whenZero_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.VALUE_NOT_SET, ValueCase.valueOf(0));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code EXTENSION_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase forNumber(int); then return 'EXTENSION_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_thenReturnExtensionValue() {
    // Arrange, Act and Assert
    assertEquals(
        PropertyValue.ValueCase.EXTENSION_VALUE,
        PropertyValue.ValueCase.forNumber(Metric.LONG_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code PROPERTYSET_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase forNumber(int); then return 'PROPERTYSET_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_thenReturnPropertysetValue() {
    // Arrange, Act and Assert
    assertEquals(
        PropertyValue.ValueCase.PROPERTYSET_VALUE,
        PropertyValue.ValueCase.forNumber(MetaData.EXTENSIONS_FIELD_NUMBER));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code PROPERTYSETS_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase forNumber(int); then return 'PROPERTYSETS_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_thenReturnPropertysetsValue() {
    // Arrange, Act and Assert
    assertEquals(
        PropertyValue.ValueCase.PROPERTYSETS_VALUE,
        PropertyValue.ValueCase.forNumber(Metric.INT_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code STRING_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase forNumber(int); when eight; then return 'STRING_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenEight_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.STRING_VALUE, PropertyValue.ValueCase.forNumber(8));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase forNumber(int); when five; then return 'FLOAT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenFive_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.FLOAT_VALUE, PropertyValue.ValueCase.forNumber(5));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PropertyValue.ValueCase.forNumber(42));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase forNumber(int); when four; then return 'LONG_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenFour_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.LONG_VALUE, PropertyValue.ValueCase.forNumber(4));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code BOOLEAN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase forNumber(int); when seven; then return 'BOOLEAN_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenSeven_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.BOOLEAN_VALUE, PropertyValue.ValueCase.forNumber(7));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase forNumber(int); when six; then return 'DOUBLE_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenSix_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.DOUBLE_VALUE, PropertyValue.ValueCase.forNumber(6));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code INT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase forNumber(int); when three; then return 'INT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenThree_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.INT_VALUE, PropertyValue.ValueCase.forNumber(3));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code VALUE_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase forNumber(int); when zero; then return 'VALUE_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenZero_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, PropertyValue.ValueCase.forNumber(0));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#getNumber()}.
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#getNumber()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PropertyValue.ValueCase.getNumber()"})
  void testPayload_PropertyValue_ValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(3, PropertyValue.ValueCase.valueOf("INT_VALUE").getNumber());
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code
   * value}.
   *
   * <ul>
   *   <li>Then return {@code BOOLEAN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'BOOLEAN_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.BOOLEAN_VALUE, PropertyValue.ValueCase.valueOf(7));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code
   * value}.
   *
   * <ul>
   *   <li>Then return {@code DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'DOUBLE_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.DOUBLE_VALUE, PropertyValue.ValueCase.valueOf(6));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code
   * value}.
   *
   * <ul>
   *   <li>Then return {@code EXTENSION_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'EXTENSION_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnExtensionValue() {
    // Arrange, Act and Assert
    assertEquals(
        PropertyValue.ValueCase.EXTENSION_VALUE,
        PropertyValue.ValueCase.valueOf(Metric.LONG_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code
   * value}.
   *
   * <ul>
   *   <li>Then return {@code FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'FLOAT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.FLOAT_VALUE, PropertyValue.ValueCase.valueOf(5));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code
   * value}.
   *
   * <ul>
   *   <li>Then return {@code PROPERTYSET_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'PROPERTYSET_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnPropertysetValue() {
    // Arrange, Act and Assert
    assertEquals(
        PropertyValue.ValueCase.PROPERTYSET_VALUE,
        PropertyValue.ValueCase.valueOf(MetaData.EXTENSIONS_FIELD_NUMBER));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code
   * value}.
   *
   * <ul>
   *   <li>Then return {@code PROPERTYSETS_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'PROPERTYSETS_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnPropertysetsValue() {
    // Arrange, Act and Assert
    assertEquals(
        PropertyValue.ValueCase.PROPERTYSETS_VALUE,
        PropertyValue.ValueCase.valueOf(Metric.INT_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code
   * value}.
   *
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'STRING_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.STRING_VALUE, PropertyValue.ValueCase.valueOf(8));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code
   * value}.
   *
   * <ul>
   *   <li>Then return {@code VALUE_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'VALUE_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, PropertyValue.ValueCase.valueOf(0));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code
   * value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PropertyValue.ValueCase.valueOf(42));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code
   * value}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; when four; then return 'LONG_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_whenFour_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.LONG_VALUE, PropertyValue.ValueCase.valueOf(4));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code
   * value}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code INT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; when three; then return 'INT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_whenThree_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.INT_VALUE, PropertyValue.ValueCase.valueOf(3));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code BOOLEAN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase forNumber(int); then return 'BOOLEAN_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.BOOLEAN_VALUE, Parameter.ValueCase.forNumber(7));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code EXTENSION_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase forNumber(int); then return 'EXTENSION_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_thenReturnExtensionValue() {
    // Arrange, Act and Assert
    assertEquals(
        Parameter.ValueCase.EXTENSION_VALUE,
        Parameter.ValueCase.forNumber(MetaData.EXTENSIONS_FIELD_NUMBER));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase forNumber(int); then return 'STRING_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.STRING_VALUE, Parameter.ValueCase.forNumber(8));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase forNumber(int); when five; then return 'FLOAT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_whenFive_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.FLOAT_VALUE, Parameter.ValueCase.forNumber(5));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase forNumber(int); when forty-two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Parameter.ValueCase.forNumber(42));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase forNumber(int); when four; then return 'LONG_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_whenFour_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.LONG_VALUE, Parameter.ValueCase.forNumber(4));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase forNumber(int); when six; then return 'DOUBLE_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_whenSix_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.DOUBLE_VALUE, Parameter.ValueCase.forNumber(6));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code INT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase forNumber(int); when three; then return 'INT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_whenThree_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.INT_VALUE, Parameter.ValueCase.forNumber(3));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code VALUE_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase forNumber(int); when zero; then return 'VALUE_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_whenZero_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, Parameter.ValueCase.forNumber(0));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#getNumber()}.
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#getNumber()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Template.Parameter.ValueCase.getNumber()"})
  void testPayload_Template_Parameter_ValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(3, Parameter.ValueCase.valueOf("INT_VALUE").getNumber());
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue() {
    // Arrange, Act and Assert
    assertEquals(
        Parameter.ValueCase.EXTENSION_VALUE,
        Parameter.ValueCase.valueOf(MetaData.EXTENSIONS_FIELD_NUMBER));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code BOOLEAN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'BOOLEAN_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.BOOLEAN_VALUE, Parameter.ValueCase.valueOf(7));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'DOUBLE_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.DOUBLE_VALUE, Parameter.ValueCase.valueOf(6));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'FLOAT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.FLOAT_VALUE, Parameter.ValueCase.valueOf(5));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code INT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'INT_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.INT_VALUE, Parameter.ValueCase.valueOf(3));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'LONG_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.LONG_VALUE, Parameter.ValueCase.valueOf(4));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Parameter.ValueCase.valueOf(42));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'STRING_VALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.STRING_VALUE, Parameter.ValueCase.valueOf(8));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)}
   * with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code VALUE_NOT_SET}.
   * </ul>
   *
   * <p>Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName(
      "Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'VALUE_NOT_SET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, Parameter.ValueCase.valueOf(0));
  }
}
