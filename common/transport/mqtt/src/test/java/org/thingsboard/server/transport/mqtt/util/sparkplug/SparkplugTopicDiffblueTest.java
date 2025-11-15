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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SparkplugTopicDiffblueTest {
  /**
   * Method under test: {@link SparkplugTopic#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("Namespace/42/NBIRTH/42",
        (new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH)).toString());
    assertEquals("//42/NBIRTH/42/42",
        (new SparkplugTopic("/", "42", "42", "42", SparkplugMessageType.NBIRTH)).toString());
  }

  /**
   * Method under test: {@link SparkplugTopic#isType(SparkplugMessageType)}
   */
  @Test
  void testIsType() {
    // Arrange, Act and Assert
    assertTrue(
        (new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH)).isType(SparkplugMessageType.NBIRTH));
    assertFalse((new SparkplugTopic("Namespace", "42", "42", null)).isType(SparkplugMessageType.NBIRTH));
    assertFalse(
        (new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NDEATH)).isType(SparkplugMessageType.NBIRTH));
  }

  /**
   * Method under test: {@link SparkplugTopic#isNode()}
   */
  @Test
  void testIsNode() {
    // Arrange, Act and Assert
    assertTrue((new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH)).isNode());
    assertFalse((new SparkplugTopic("Namespace", "42", "42", "42", SparkplugMessageType.NBIRTH)).isNode());
  }

  /**
   * Method under test: {@link SparkplugTopic#getNodeDeviceName()}
   */
  @Test
  void testGetNodeDeviceName() {
    // Arrange, Act and Assert
    assertEquals("42", (new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH)).getNodeDeviceName());
    assertEquals("42",
        (new SparkplugTopic("Namespace", "42", "42", "42", SparkplugMessageType.NBIRTH)).getNodeDeviceName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SparkplugTopic#SparkplugTopic(String, String, String, String, SparkplugMessageType)}
   *   <li>{@link SparkplugTopic#getDeviceId()}
   *   <li>{@link SparkplugTopic#getEdgeNodeId()}
   *   <li>{@link SparkplugTopic#getGroupId()}
   *   <li>{@link SparkplugTopic#getNamespace()}
   *   <li>{@link SparkplugTopic#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SparkplugTopic actualSparkplugTopic = new SparkplugTopic("Namespace", "42", "42", "42",
        SparkplugMessageType.NBIRTH);
    String actualDeviceId = actualSparkplugTopic.getDeviceId();
    String actualEdgeNodeId = actualSparkplugTopic.getEdgeNodeId();
    String actualGroupId = actualSparkplugTopic.getGroupId();
    String actualNamespace = actualSparkplugTopic.getNamespace();

    // Assert
    assertEquals("42", actualDeviceId);
    assertEquals("42", actualEdgeNodeId);
    assertEquals("42", actualGroupId);
    assertEquals("Namespace", actualNamespace);
    assertEquals(SparkplugMessageType.NBIRTH, actualSparkplugTopic.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SparkplugTopic#SparkplugTopic(String, String, String, SparkplugMessageType)}
   *   <li>{@link SparkplugTopic#getDeviceId()}
   *   <li>{@link SparkplugTopic#getEdgeNodeId()}
   *   <li>{@link SparkplugTopic#getGroupId()}
   *   <li>{@link SparkplugTopic#getNamespace()}
   *   <li>{@link SparkplugTopic#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    SparkplugTopic actualSparkplugTopic = new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);
    String actualDeviceId = actualSparkplugTopic.getDeviceId();
    String actualEdgeNodeId = actualSparkplugTopic.getEdgeNodeId();
    String actualGroupId = actualSparkplugTopic.getGroupId();
    String actualNamespace = actualSparkplugTopic.getNamespace();

    // Assert
    assertEquals("42", actualEdgeNodeId);
    assertEquals("42", actualGroupId);
    assertEquals("Namespace", actualNamespace);
    assertNull(actualDeviceId);
    assertEquals(SparkplugMessageType.NBIRTH, actualSparkplugTopic.getType());
  }

  /**
   * Method under test:
   * {@link SparkplugTopic#SparkplugTopic(SparkplugTopic, SparkplugMessageType)}
   */
  @Test
  void testNewSparkplugTopic() {
    // Arrange and Act
    SparkplugTopic actualSparkplugTopic = new SparkplugTopic(
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH), SparkplugMessageType.NBIRTH);

    // Assert
    assertEquals("42", actualSparkplugTopic.getEdgeNodeId());
    assertEquals("42", actualSparkplugTopic.getGroupId());
    assertEquals("42", actualSparkplugTopic.getNodeDeviceName());
    assertEquals("Namespace", actualSparkplugTopic.getNamespace());
    assertNull(actualSparkplugTopic.getDeviceId());
    assertEquals(SparkplugMessageType.NBIRTH, actualSparkplugTopic.getType());
    assertTrue(actualSparkplugTopic.isNode());
  }

  /**
   * Method under test:
   * {@link SparkplugTopic#SparkplugTopic(SparkplugTopic, SparkplugMessageType, String)}
   */
  @Test
  void testNewSparkplugTopic2() {
    // Arrange and Act
    SparkplugTopic actualSparkplugTopic = new SparkplugTopic(
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH), SparkplugMessageType.NBIRTH, "42");

    // Assert
    assertEquals("42", actualSparkplugTopic.getDeviceId());
    assertEquals("42", actualSparkplugTopic.getEdgeNodeId());
    assertEquals("42", actualSparkplugTopic.getGroupId());
    assertEquals("42", actualSparkplugTopic.getNodeDeviceName());
    assertEquals("Namespace", actualSparkplugTopic.getNamespace());
    assertEquals(SparkplugMessageType.NBIRTH, actualSparkplugTopic.getType());
    assertFalse(actualSparkplugTopic.isNode());
  }
}
