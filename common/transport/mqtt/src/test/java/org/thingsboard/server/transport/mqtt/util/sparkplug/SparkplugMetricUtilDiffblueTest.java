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
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto;

class SparkplugMetricUtilDiffblueTest {
  /**
   * Method under test:
   * {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}
   */
  @Test
  void testCreateMetric() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> SparkplugMetricUtil.createMetric(null, 1L, "Key", MetricDataType.Unknown));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugMetricUtil.File#File(SparkplugMetricUtil)}
   *   <li>{@link SparkplugMetricUtil.File#setBytes(byte[])}
   *   <li>{@link SparkplugMetricUtil.File#setFileName(String)}
   *   <li>{@link SparkplugMetricUtil.File#toString()}
   *   <li>{@link SparkplugMetricUtil.File#getBytes()}
   *   <li>{@link SparkplugMetricUtil.File#getFileName()}
   * </ul>
   */
  @Test
  void testFileGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    SparkplugMetricUtil.File actualFile = (new SparkplugMetricUtil()).new File();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    actualFile.setBytes(bytes);
    actualFile.setFileName("foo.txt");
    String actualToStringResult = actualFile.toString();
    byte[] actualBytes = actualFile.getBytes();

    // Assert that nothing has changed
    assertEquals("File [fileName=foo.txt, bytes=[65, 88, 65, 88, 65, 88, 65, 88]]", actualToStringResult);
    assertEquals("foo.txt", actualFile.getFileName());
    assertSame(bytes, actualBytes);
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil.File#File(SparkplugMetricUtil, String, byte[])}
   */
  @Test
  void testFileNewFile() throws UnsupportedEncodingException {
    // Arrange
    SparkplugMetricUtil sparkplugMetricUtil = new SparkplugMetricUtil();

    // Act
    SparkplugMetricUtil.File actualFile = sparkplugMetricUtil.new File("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("foo.txt", actualFile.getFileName());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualFile.getBytes());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil.File#File(SparkplugMetricUtil, String, byte[])}
   */
  @Test
  void testFileNewFile2() throws UnsupportedEncodingException {
    // Arrange and Act
    SparkplugMetricUtil.File actualFile = (new SparkplugMetricUtil()).new File(null,
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualFile.getFileName());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualFile.getBytes());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#fromSparkplugBMetricToKeyValueProto(String, SparkplugBProto.Payload.Metric)}
   */
  @Test
  void testFromSparkplugBMetricToKeyValueProto() throws ThingsboardException {
    // Arrange and Act
    Optional<TransportProtos.KeyValueProto> actualFromSparkplugBMetricToKeyValueProtoResult = SparkplugMetricUtil
        .fromSparkplugBMetricToKeyValueProto("Key", SparkplugBProto.Payload.Metric.getDefaultInstance());

    // Assert
    assertFalse(actualFromSparkplugBMetricToKeyValueProtoResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#fromSparkplugBMetricToKeyValueProto(String, SparkplugBProto.Payload.Metric)}
   */
  @Test
  void testFromSparkplugBMetricToKeyValueProto2() throws ThingsboardException {
    // Arrange and Act
    Optional<TransportProtos.KeyValueProto> actualFromSparkplugBMetricToKeyValueProtoResult = SparkplugMetricUtil
        .fromSparkplugBMetricToKeyValueProto("", SparkplugBProto.Payload.Metric.getDefaultInstance());

    // Assert
    assertFalse(actualFromSparkplugBMetricToKeyValueProtoResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  void testGetTsKvProto() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> SparkplugMetricUtil.getTsKvProto(null, null, 1L));
    assertThrows(ThingsboardException.class, () -> SparkplugMetricUtil.getTsKvProto("Key", null, 1L));
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValueByTypeMetric() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Int8);

    // Assert
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValueByTypeMetric2() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValueByTypeMetric3() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Boolean);

    // Assert
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValueByTypeMetric4() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.DateTime);

    // Assert
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValueByTypeMetric5() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Float);

    // Assert
    assertEquals(0.0f, ((Float) actualValidatedValueByTypeMetricResult.get()).floatValue());
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValueByTypeMetric6() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Double);

    // Assert
    assertEquals(0.0d, ((Double) actualValidatedValueByTypeMetricResult.get()).doubleValue());
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValueByTypeMetric7() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.String);

    // Assert
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
    String expectedString = Boolean.FALSE.toString();
    assertEquals(expectedString, actualValidatedValueByTypeMetricResult.get());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  void testValidatedValueJsonByTypeMetric() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("Array Node Str", MetricDataType.Int8);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  void testValidatedValueJsonByTypeMetric2() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("Array Node Str", MetricDataType.DataSet);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  void testValidatedValueJsonByTypeMetric3() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("Array Node Str", MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  void testValidatedValueJsonByTypeMetric4() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("0", MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  void testValidatedValueJsonByTypeMetric5() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("42", MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  void testValidatedValueJsonByTypeMetric6() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil.validatedValueJsonByTypeMetric("",
        MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValuePrimitiveByTypeMetric() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Int8);

    // Assert
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValuePrimitiveByTypeMetric2() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(),
            MetricDataType.Boolean);

    // Assert
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValuePrimitiveByTypeMetric3() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(),
            MetricDataType.DateTime);

    // Assert
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValuePrimitiveByTypeMetric4() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Float);

    // Assert
    assertEquals(0.0f, ((Float) actualValidatedValuePrimitiveByTypeMetricResult.get()).floatValue());
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValuePrimitiveByTypeMetric5() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Double);

    // Assert
    assertEquals(0.0d, ((Double) actualValidatedValuePrimitiveByTypeMetricResult.get()).doubleValue());
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValuePrimitiveByTypeMetric6() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.String);

    // Assert
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
    String expectedString = Boolean.FALSE.toString();
    assertEquals(expectedString, actualValidatedValuePrimitiveByTypeMetricResult.get());
  }

  /**
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  void testValidatedValuePrimitiveByTypeMetric7() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(),
            MetricDataType.DataSet);

    // Assert
    assertFalse(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }
}
