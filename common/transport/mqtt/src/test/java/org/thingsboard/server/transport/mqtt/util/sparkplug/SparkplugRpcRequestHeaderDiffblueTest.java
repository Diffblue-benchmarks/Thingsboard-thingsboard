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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SparkplugRpcRequestHeaderDiffblueTest {
  /**
   * Test {@link SparkplugRpcRequestHeader#equals(Object)}, and {@link
   * SparkplugRpcRequestHeader#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugRpcRequestHeader#equals(Object)}
   *   <li>{@link SparkplugRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcRequestHeader.equals(Object)",
    "int SparkplugRpcRequestHeader.hashCode()"
  })
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
    assertEquals(sparkplugRpcRequestHeader.hashCode(), sparkplugRpcRequestHeader2.hashCode());
  }

  /**
   * Test {@link SparkplugRpcRequestHeader#equals(Object)}, and {@link
   * SparkplugRpcRequestHeader#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugRpcRequestHeader#equals(Object)}
   *   <li>{@link SparkplugRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcRequestHeader.equals(Object)",
    "int SparkplugRpcRequestHeader.hashCode()"
  })
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
    assertEquals(sparkplugRpcRequestHeader.hashCode(), sparkplugRpcRequestHeader2.hashCode());
  }

  /**
   * Test {@link SparkplugRpcRequestHeader#equals(Object)}, and {@link
   * SparkplugRpcRequestHeader#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugRpcRequestHeader#equals(Object)}
   *   <li>{@link SparkplugRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcRequestHeader.equals(Object)",
    "int SparkplugRpcRequestHeader.hashCode()"
  })
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
    assertEquals(sparkplugRpcRequestHeader.hashCode(), sparkplugRpcRequestHeader2.hashCode());
  }

  /**
   * Test {@link SparkplugRpcRequestHeader#equals(Object)}, and {@link
   * SparkplugRpcRequestHeader#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugRpcRequestHeader#equals(Object)}
   *   <li>{@link SparkplugRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcRequestHeader.equals(Object)",
    "int SparkplugRpcRequestHeader.hashCode()"
  })
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
    assertEquals(sparkplugRpcRequestHeader.hashCode(), sparkplugRpcRequestHeader2.hashCode());
  }

  /**
   * Test {@link SparkplugRpcRequestHeader#equals(Object)}, and {@link
   * SparkplugRpcRequestHeader#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugRpcRequestHeader#equals(Object)}
   *   <li>{@link SparkplugRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcRequestHeader.equals(Object)",
    "int SparkplugRpcRequestHeader.hashCode()"
  })
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
   * Test {@link SparkplugRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcRequestHeader.equals(Object)",
    "int SparkplugRpcRequestHeader.hashCode()"
  })
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
   * Test {@link SparkplugRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcRequestHeader.equals(Object)",
    "int SparkplugRpcRequestHeader.hashCode()"
  })
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
   * Test {@link SparkplugRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcRequestHeader.equals(Object)",
    "int SparkplugRpcRequestHeader.hashCode()"
  })
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
   * Test {@link SparkplugRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcRequestHeader.equals(Object)",
    "int SparkplugRpcRequestHeader.hashCode()"
  })
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
   * Test {@link SparkplugRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcRequestHeader.equals(Object)",
    "int SparkplugRpcRequestHeader.hashCode()"
  })
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
   * Test {@link SparkplugRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcRequestHeader.equals(Object)",
    "int SparkplugRpcRequestHeader.hashCode()"
  })
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
   * Test {@link SparkplugRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcRequestHeader.equals(Object)",
    "int SparkplugRpcRequestHeader.hashCode()"
  })
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
   * Test {@link SparkplugRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcRequestHeader.equals(Object)",
    "int SparkplugRpcRequestHeader.hashCode()"
  })
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugRpcRequestHeader.<init>()",
    "String SparkplugRpcRequestHeader.getMessageType()",
    "String SparkplugRpcRequestHeader.getMetricName()",
    "Object SparkplugRpcRequestHeader.getValue()",
    "void SparkplugRpcRequestHeader.setMessageType(String)",
    "void SparkplugRpcRequestHeader.setMetricName(String)",
    "void SparkplugRpcRequestHeader.setValue(Object)",
    "String SparkplugRpcRequestHeader.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SparkplugRpcRequestHeader actualSparkplugRpcRequestHeader = new SparkplugRpcRequestHeader();
    actualSparkplugRpcRequestHeader.setMessageType("Message Type");
    actualSparkplugRpcRequestHeader.setMetricName("Metric Name");
    actualSparkplugRpcRequestHeader.setValue("Value");
    String actualToStringResult = actualSparkplugRpcRequestHeader.toString();
    String actualMessageType = actualSparkplugRpcRequestHeader.getMessageType();
    String actualMetricName = actualSparkplugRpcRequestHeader.getMetricName();

    // Assert
    assertEquals("Message Type", actualMessageType);
    assertEquals("Metric Name", actualMetricName);
    assertEquals(
        "SparkplugRpcRequestHeader(messageType=Message Type, metricName=Metric Name, value=Value)",
        actualToStringResult);
    assertEquals("Value", actualSparkplugRpcRequestHeader.getValue());
  }
}
