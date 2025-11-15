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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class SparkplugRpcRequestHeaderDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugRpcRequestHeader#equals(Object)}
   *   <li>{@link SparkplugRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SparkplugRpcRequestHeader sparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader.setMessageType("Message Type");
    sparkplugRpcRequestHeader.setMetricName("Metric Name");
    sparkplugRpcRequestHeader.setValue("Value");

    SparkplugRpcRequestHeader sparkplugRpcRequestHeader2 = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader2.setMessageType("Message Type");
    sparkplugRpcRequestHeader2.setMetricName("Metric Name");
    sparkplugRpcRequestHeader2.setValue("Value");

    // Act and Assert
    assertEquals(sparkplugRpcRequestHeader, sparkplugRpcRequestHeader2);
    int expectedHashCodeResult = sparkplugRpcRequestHeader.hashCode();
    assertEquals(expectedHashCodeResult, sparkplugRpcRequestHeader2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugRpcRequestHeader#equals(Object)}
   *   <li>{@link SparkplugRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SparkplugRpcRequestHeader sparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader.setMessageType(null);
    sparkplugRpcRequestHeader.setMetricName("Metric Name");
    sparkplugRpcRequestHeader.setValue("Value");

    SparkplugRpcRequestHeader sparkplugRpcRequestHeader2 = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader2.setMessageType(null);
    sparkplugRpcRequestHeader2.setMetricName("Metric Name");
    sparkplugRpcRequestHeader2.setValue("Value");

    // Act and Assert
    assertEquals(sparkplugRpcRequestHeader, sparkplugRpcRequestHeader2);
    int expectedHashCodeResult = sparkplugRpcRequestHeader.hashCode();
    assertEquals(expectedHashCodeResult, sparkplugRpcRequestHeader2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugRpcRequestHeader#equals(Object)}
   *   <li>{@link SparkplugRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SparkplugRpcRequestHeader sparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader.setMessageType("Message Type");
    sparkplugRpcRequestHeader.setMetricName(null);
    sparkplugRpcRequestHeader.setValue("Value");

    SparkplugRpcRequestHeader sparkplugRpcRequestHeader2 = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader2.setMessageType("Message Type");
    sparkplugRpcRequestHeader2.setMetricName(null);
    sparkplugRpcRequestHeader2.setValue("Value");

    // Act and Assert
    assertEquals(sparkplugRpcRequestHeader, sparkplugRpcRequestHeader2);
    int expectedHashCodeResult = sparkplugRpcRequestHeader.hashCode();
    assertEquals(expectedHashCodeResult, sparkplugRpcRequestHeader2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugRpcRequestHeader#equals(Object)}
   *   <li>{@link SparkplugRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SparkplugRpcRequestHeader sparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader.setMessageType("Message Type");
    sparkplugRpcRequestHeader.setMetricName("Metric Name");
    sparkplugRpcRequestHeader.setValue(null);

    SparkplugRpcRequestHeader sparkplugRpcRequestHeader2 = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader2.setMessageType("Message Type");
    sparkplugRpcRequestHeader2.setMetricName("Metric Name");
    sparkplugRpcRequestHeader2.setValue(null);

    // Act and Assert
    assertEquals(sparkplugRpcRequestHeader, sparkplugRpcRequestHeader2);
    int expectedHashCodeResult = sparkplugRpcRequestHeader.hashCode();
    assertEquals(expectedHashCodeResult, sparkplugRpcRequestHeader2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugRpcRequestHeader#equals(Object)}
   *   <li>{@link SparkplugRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SparkplugRpcRequestHeader sparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader.setMessageType("Message Type");
    sparkplugRpcRequestHeader.setMetricName("Metric Name");
    sparkplugRpcRequestHeader.setValue("Value");

    // Act and Assert
    assertEquals(sparkplugRpcRequestHeader, sparkplugRpcRequestHeader);
    int expectedHashCodeResult = sparkplugRpcRequestHeader.hashCode();
    assertEquals(expectedHashCodeResult, sparkplugRpcRequestHeader.hashCode());
  }

  /**
   * Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SparkplugRpcRequestHeader sparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader.setMessageType("Metric Name");
    sparkplugRpcRequestHeader.setMetricName("Metric Name");
    sparkplugRpcRequestHeader.setValue("Value");

    SparkplugRpcRequestHeader sparkplugRpcRequestHeader2 = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader2.setMessageType("Message Type");
    sparkplugRpcRequestHeader2.setMetricName("Metric Name");
    sparkplugRpcRequestHeader2.setValue("Value");

    // Act and Assert
    assertNotEquals(sparkplugRpcRequestHeader, sparkplugRpcRequestHeader2);
  }

  /**
   * Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SparkplugRpcRequestHeader sparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader.setMessageType(null);
    sparkplugRpcRequestHeader.setMetricName("Metric Name");
    sparkplugRpcRequestHeader.setValue("Value");

    SparkplugRpcRequestHeader sparkplugRpcRequestHeader2 = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader2.setMessageType("Message Type");
    sparkplugRpcRequestHeader2.setMetricName("Metric Name");
    sparkplugRpcRequestHeader2.setValue("Value");

    // Act and Assert
    assertNotEquals(sparkplugRpcRequestHeader, sparkplugRpcRequestHeader2);
  }

  /**
   * Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SparkplugRpcRequestHeader sparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader.setMessageType("Message Type");
    sparkplugRpcRequestHeader.setMetricName("Message Type");
    sparkplugRpcRequestHeader.setValue("Value");

    SparkplugRpcRequestHeader sparkplugRpcRequestHeader2 = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader2.setMessageType("Message Type");
    sparkplugRpcRequestHeader2.setMetricName("Metric Name");
    sparkplugRpcRequestHeader2.setValue("Value");

    // Act and Assert
    assertNotEquals(sparkplugRpcRequestHeader, sparkplugRpcRequestHeader2);
  }

  /**
   * Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SparkplugRpcRequestHeader sparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader.setMessageType("Message Type");
    sparkplugRpcRequestHeader.setMetricName(null);
    sparkplugRpcRequestHeader.setValue("Value");

    SparkplugRpcRequestHeader sparkplugRpcRequestHeader2 = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader2.setMessageType("Message Type");
    sparkplugRpcRequestHeader2.setMetricName("Metric Name");
    sparkplugRpcRequestHeader2.setValue("Value");

    // Act and Assert
    assertNotEquals(sparkplugRpcRequestHeader, sparkplugRpcRequestHeader2);
  }

  /**
   * Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SparkplugRpcRequestHeader sparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader.setMessageType("Message Type");
    sparkplugRpcRequestHeader.setMetricName("Message Type");
    sparkplugRpcRequestHeader.setValue("Value");

    SparkplugRpcRequestHeader sparkplugRpcRequestHeader2 = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader2.setMessageType("Message Type");
    sparkplugRpcRequestHeader2.setMetricName("Metric Name");
    sparkplugRpcRequestHeader2.setValue(sparkplugRpcRequestHeader);

    SparkplugRpcRequestHeader sparkplugRpcRequestHeader3 = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader3.setMessageType("Message Type");
    sparkplugRpcRequestHeader3.setMetricName("Metric Name");
    sparkplugRpcRequestHeader3.setValue("Value");

    // Act and Assert
    assertNotEquals(sparkplugRpcRequestHeader2, sparkplugRpcRequestHeader3);
  }

  /**
   * Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SparkplugRpcRequestHeader sparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader.setMessageType("Message Type");
    sparkplugRpcRequestHeader.setMetricName("Metric Name");
    sparkplugRpcRequestHeader.setValue(null);

    SparkplugRpcRequestHeader sparkplugRpcRequestHeader2 = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader2.setMessageType("Message Type");
    sparkplugRpcRequestHeader2.setMetricName("Metric Name");
    sparkplugRpcRequestHeader2.setValue("Value");

    // Act and Assert
    assertNotEquals(sparkplugRpcRequestHeader, sparkplugRpcRequestHeader2);
  }

  /**
   * Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SparkplugRpcRequestHeader sparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader.setMessageType("Message Type");
    sparkplugRpcRequestHeader.setMetricName("Metric Name");
    sparkplugRpcRequestHeader.setValue("Value");

    // Act and Assert
    assertNotEquals(sparkplugRpcRequestHeader, null);
  }

  /**
   * Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SparkplugRpcRequestHeader sparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    sparkplugRpcRequestHeader.setMessageType("Message Type");
    sparkplugRpcRequestHeader.setMetricName("Metric Name");
    sparkplugRpcRequestHeader.setValue("Value");

    // Act and Assert
    assertNotEquals(sparkplugRpcRequestHeader, "Different type to SparkplugRpcRequestHeader");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SparkplugRpcRequestHeader}
   *   <li>{@link SparkplugRpcRequestHeader#setMessageType(String)}
   *   <li>{@link SparkplugRpcRequestHeader#setMetricName(String)}
   *   <li>{@link SparkplugRpcRequestHeader#setValue(Object)}
   *   <li>{@link SparkplugRpcRequestHeader#toString()}
   *   <li>{@link SparkplugRpcRequestHeader#getMessageType()}
   *   <li>{@link SparkplugRpcRequestHeader#getMetricName()}
   *   <li>{@link SparkplugRpcRequestHeader#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SparkplugRpcRequestHeader actualSparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    actualSparkplugRpcRequestHeader.setMessageType("Message Type");
    actualSparkplugRpcRequestHeader.setMetricName("Metric Name");
    actualSparkplugRpcRequestHeader.setValue("Value");
    String actualToStringResult = actualSparkplugRpcRequestHeader.toString();
    String actualMessageType = actualSparkplugRpcRequestHeader.getMessageType();
    String actualMetricName = actualSparkplugRpcRequestHeader.getMetricName();

    // Assert that nothing has changed
    assertEquals("Message Type", actualMessageType);
    assertEquals("Metric Name", actualMetricName);
    assertEquals("SparkplugRpcRequestHeader(messageType=Message Type, metricName=Metric Name, value=Value)",
        actualToStringResult);
    assertEquals("Value", actualSparkplugRpcRequestHeader.getValue());
  }
}
