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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.adaptor.AdaptorException;

class MetricDataTypeDiffblueTest {
  /**
   * Method under test: {@link MetricDataType#checkType(Object)}
   */
  @Test
  void testCheckType() throws AdaptorException {
    // Arrange, Act and Assert
    assertThrows(AdaptorException.class, () -> MetricDataType.Int8.checkType("Value"));
  }

  /**
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  void testFromInteger() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Int8, MetricDataType.fromInteger(1));
    assertEquals(MetricDataType.Int16, MetricDataType.fromInteger(2));
    assertEquals(MetricDataType.Int32, MetricDataType.fromInteger(3));
    assertEquals(MetricDataType.Int64, MetricDataType.fromInteger(4));
    assertEquals(MetricDataType.UInt8, MetricDataType.fromInteger(5));
    assertEquals(MetricDataType.UInt16, MetricDataType.fromInteger(6));
    assertEquals(MetricDataType.UInt32, MetricDataType.fromInteger(7));
    assertEquals(MetricDataType.UInt64, MetricDataType.fromInteger(8));
    assertEquals(MetricDataType.Float, MetricDataType.fromInteger(9));
    assertEquals(MetricDataType.Double, MetricDataType.fromInteger(10));
    assertEquals(MetricDataType.Boolean, MetricDataType.fromInteger(11));
    assertEquals(MetricDataType.String, MetricDataType.fromInteger(12));
    assertEquals(MetricDataType.DateTime, MetricDataType.fromInteger(13));
    assertEquals(MetricDataType.Text, MetricDataType.fromInteger(14));
    assertEquals(MetricDataType.UUID, MetricDataType.fromInteger(15));
    assertEquals(MetricDataType.DataSet, MetricDataType.fromInteger(Short.SIZE));
    assertEquals(MetricDataType.Bytes, MetricDataType.fromInteger(17));
    assertEquals(MetricDataType.File, MetricDataType.fromInteger(18));
    assertEquals(MetricDataType.Template, MetricDataType.fromInteger(19));
    assertEquals(MetricDataType.Unknown, MetricDataType.fromInteger(0));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetricDataType#getClazz()}
   *   <li>{@link MetricDataType#toIntValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    MetricDataType valueOfResult = MetricDataType.valueOf("Int8");

    // Act
    Class<?> actualClazz = valueOfResult.getClazz();

    // Assert
    assertEquals(1, valueOfResult.toIntValue());
    Class<Byte> expectedClazz = Byte.class;
    assertEquals(expectedClazz, actualClazz);
  }
}
