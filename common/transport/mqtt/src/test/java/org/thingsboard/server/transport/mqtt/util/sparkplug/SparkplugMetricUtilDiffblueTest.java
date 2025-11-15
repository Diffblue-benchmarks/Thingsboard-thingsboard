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
package org.thingsboard.server.transport.mqtt.util.sparkplug;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Metric;
import org.thingsboard.server.transport.mqtt.util.sparkplug.SparkplugMetricUtil.File;

class SparkplugMetricUtilDiffblueTest {
  /**
   * Test {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return Datatype is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}
   */
  @Test
  @DisplayName("Test createMetric(Object, long, String, MetricDataType); when 'A'; then return Datatype is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric SparkplugMetricUtil.createMetric(Object, long, String, MetricDataType)"})
  void testCreateMetric_whenA_thenReturnDatatypeIsOne() throws ThingsboardException {
    // Arrange and Act
    Metric actualCreateMetricResult = SparkplugMetricUtil.createMetric((byte) 'A', 1L, "Key", MetricDataType.Int8);

    // Assert
    assertEquals(1, actualCreateMetricResult.getDatatype());
    assertEquals(65, actualCreateMetricResult.getIntValue());
  }

  /**
   * Test {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return Datatype is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}
   */
  @Test
  @DisplayName("Test createMetric(Object, long, String, MetricDataType); when forty-two; then return Datatype is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric SparkplugMetricUtil.createMetric(Object, long, String, MetricDataType)"})
  void testCreateMetric_whenFortyTwo_thenReturnDatatypeIsThree() throws ThingsboardException {
    // Arrange and Act
    Metric actualCreateMetricResult = SparkplugMetricUtil.createMetric(42, 1L, "Key", MetricDataType.Int32);

    // Assert
    assertEquals(3, actualCreateMetricResult.getDatatype());
    assertEquals(42, actualCreateMetricResult.getIntValue());
  }

  /**
   * Test {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}.
   * <ul>
   *   <li>When {@code Unknown}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}
   */
  @Test
  @DisplayName("Test createMetric(Object, long, String, MetricDataType); when 'Unknown'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric SparkplugMetricUtil.createMetric(Object, long, String, MetricDataType)"})
  void testCreateMetric_whenUnknown_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> SparkplugMetricUtil.createMetric(null, 1L, "Key", MetricDataType.Unknown));
  }

  /**
   * Test File getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link File#File(SparkplugMetricUtil)}
   *   <li>{@link File#setBytes(byte[])}
   *   <li>{@link File#setFileName(String)}
   *   <li>{@link File#toString()}
   *   <li>{@link File#getBytes()}
   *   <li>{@link File#getFileName()}
   * </ul>
   */
  @Test
  @DisplayName("Test File getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void File.<init>(SparkplugMetricUtil)", "byte[] File.getBytes()", "String File.getFileName()",
      "void File.setBytes(byte[])", "void File.setFileName(String)", "String File.toString()"})
  void testFileGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    File actualFile = (new SparkplugMetricUtil()).new File();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    actualFile.setBytes(bytes);
    actualFile.setFileName("foo.txt");
    String actualToStringResult = actualFile.toString();
    byte[] actualBytes = actualFile.getBytes();

    // Assert
    assertEquals("File [fileName=foo.txt, bytes=[65, 88, 65, 88, 65, 88, 65, 88]]", actualToStringResult);
    assertEquals("foo.txt", actualFile.getFileName());
    assertSame(bytes, actualBytes);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBytes);
  }

  /**
   * Test File {@link File#File(SparkplugMetricUtil, String, byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return FileName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link File#File(SparkplugMetricUtil, String, byte[])}
   */
  @Test
  @DisplayName("Test File new File(SparkplugMetricUtil, String, byte[]); when 'A'; then return FileName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void File.<init>(SparkplugMetricUtil, String, byte[])"})
  void testFileNewFile_whenA_thenReturnFileNameIsNull() throws UnsupportedEncodingException {
    // Arrange and Act
    File actualFile = (new SparkplugMetricUtil()).new File(null, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualFile.getFileName());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualFile.getBytes());
  }

  /**
   * Test File {@link File#File(SparkplugMetricUtil, String, byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return FileName is {@code foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link File#File(SparkplugMetricUtil, String, byte[])}
   */
  @Test
  @DisplayName("Test File new File(SparkplugMetricUtil, String, byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return FileName is 'foo.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void File.<init>(SparkplugMetricUtil, String, byte[])"})
  void testFileNewFile_whenAxaxaxaxBytesIsUtf8_thenReturnFileNameIsFooTxt() throws UnsupportedEncodingException {
    // Arrange
    SparkplugMetricUtil sparkplugMetricUtil = new SparkplugMetricUtil();

    // Act
    File actualFile = sparkplugMetricUtil.new File("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("foo.txt", actualFile.getFileName());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualFile.getBytes());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   * <ul>
   *   <li>When {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when '0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SparkplugMetricUtil.validatedValueJsonByTypeMetric(String, MetricDataType)"})
  void testValidatedValueJsonByTypeMetric_when0() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("0", MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SparkplugMetricUtil.validatedValueJsonByTypeMetric(String, MetricDataType)"})
  void testValidatedValueJsonByTypeMetric_when42() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("42", MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   * <ul>
   *   <li>When {@code Array Node Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when 'Array Node Str'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SparkplugMetricUtil.validatedValueJsonByTypeMetric(String, MetricDataType)"})
  void testValidatedValueJsonByTypeMetric_whenArrayNodeStr() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("Array Node Str", MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   * <ul>
   *   <li>When {@code DataSet}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when 'DataSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SparkplugMetricUtil.validatedValueJsonByTypeMetric(String, MetricDataType)"})
  void testValidatedValueJsonByTypeMetric_whenDataSet() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("Array Node Str", MetricDataType.DataSet);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SparkplugMetricUtil.validatedValueJsonByTypeMetric(String, MetricDataType)"})
  void testValidatedValueJsonByTypeMetric_whenEmptyString() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil.validatedValueJsonByTypeMetric("",
        MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   * <ul>
   *   <li>When {@code Int8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when 'Int8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SparkplugMetricUtil.validatedValueJsonByTypeMetric(String, MetricDataType)"})
  void testValidatedValueJsonByTypeMetric_whenInt8() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("Array Node Str", MetricDataType.Int8);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }
}
