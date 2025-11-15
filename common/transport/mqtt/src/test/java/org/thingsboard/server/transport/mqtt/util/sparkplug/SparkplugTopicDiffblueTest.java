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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SparkplugTopicDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return DeviceId is {@code 42}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugTopic#SparkplugTopic(String, String, String, String, SparkplugMessageType)}
   *   <li>{@link SparkplugTopic#getDeviceId()}
   *   <li>{@link SparkplugTopic#getEdgeNodeId()}
   *   <li>{@link SparkplugTopic#getGroupId()}
   *   <li>{@link SparkplugTopic#getNamespace()}
   *   <li>{@link SparkplugTopic#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return DeviceId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SparkplugTopic.<init>(String, String, String, String, SparkplugMessageType)",
      "void SparkplugTopic.<init>(String, String, String, SparkplugMessageType)", "String SparkplugTopic.getDeviceId()",
      "String SparkplugTopic.getEdgeNodeId()", "String SparkplugTopic.getGroupId()",
      "String SparkplugTopic.getNamespace()", "SparkplugMessageType SparkplugTopic.getType()"})
  void testGettersAndSetters_thenReturnDeviceIdIs42() {
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
   * Test getters and setters.
   * <ul>
   *   <li>Then return DeviceId is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugTopic#SparkplugTopic(String, String, String, SparkplugMessageType)}
   *   <li>{@link SparkplugTopic#getDeviceId()}
   *   <li>{@link SparkplugTopic#getEdgeNodeId()}
   *   <li>{@link SparkplugTopic#getGroupId()}
   *   <li>{@link SparkplugTopic#getNamespace()}
   *   <li>{@link SparkplugTopic#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return DeviceId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SparkplugTopic.<init>(String, String, String, String, SparkplugMessageType)",
      "void SparkplugTopic.<init>(String, String, String, SparkplugMessageType)", "String SparkplugTopic.getDeviceId()",
      "String SparkplugTopic.getEdgeNodeId()", "String SparkplugTopic.getGroupId()",
      "String SparkplugTopic.getNamespace()", "SparkplugMessageType SparkplugTopic.getType()"})
  void testGettersAndSetters_thenReturnDeviceIdIsNull() {
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
   * Test {@link SparkplugTopic#SparkplugTopic(SparkplugTopic, SparkplugMessageType, String)}.
   * <ul>
   *   <li>Then return DeviceId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugTopic#SparkplugTopic(SparkplugTopic, SparkplugMessageType, String)}
   */
  @Test
  @DisplayName("Test new SparkplugTopic(SparkplugTopic, SparkplugMessageType, String); then return DeviceId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SparkplugTopic.<init>(SparkplugTopic, SparkplugMessageType, String)"})
  void testNewSparkplugTopic_thenReturnDeviceIdIs42() {
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

  /**
   * Test {@link SparkplugTopic#SparkplugTopic(SparkplugTopic, SparkplugMessageType)}.
   * <ul>
   *   <li>Then return EdgeNodeId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugTopic#SparkplugTopic(SparkplugTopic, SparkplugMessageType)}
   */
  @Test
  @DisplayName("Test new SparkplugTopic(SparkplugTopic, SparkplugMessageType); then return EdgeNodeId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SparkplugTopic.<init>(SparkplugTopic, SparkplugMessageType)"})
  void testNewSparkplugTopic_thenReturnEdgeNodeIdIs42() {
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
   * Test {@link SparkplugTopic#toString()}.
   * <ul>
   *   <li>Then return {@code //42/NBIRTH/42/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugTopic#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '//42/NBIRTH/42/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SparkplugTopic.toString()"})
  void testToString_thenReturn42Nbirth4242() {
    // Arrange, Act and Assert
    assertEquals("//42/NBIRTH/42/42",
        (new SparkplugTopic("/", "42", "42", "42", SparkplugMessageType.NBIRTH)).toString());
  }

  /**
   * Test {@link SparkplugTopic#toString()}.
   * <ul>
   *   <li>Then return {@code Namespace/42/NBIRTH/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugTopic#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Namespace/42/NBIRTH/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SparkplugTopic.toString()"})
  void testToString_thenReturnNamespace42Nbirth42() {
    // Arrange, Act and Assert
    assertEquals("Namespace/42/NBIRTH/42",
        (new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH)).toString());
  }

  /**
   * Test {@link SparkplugTopic#isType(SparkplugMessageType)}.
   * <p>
   * Method under test: {@link SparkplugTopic#isType(SparkplugMessageType)}
   */
  @Test
  @DisplayName("Test isType(SparkplugMessageType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugTopic.isType(SparkplugMessageType)"})
  void testIsType() {
    // Arrange, Act and Assert
    assertFalse((new SparkplugTopic("Namespace", "42", "42", null)).isType(SparkplugMessageType.NBIRTH));
  }

  /**
   * Test {@link SparkplugTopic#isType(SparkplugMessageType)}.
   * <p>
   * Method under test: {@link SparkplugTopic#isType(SparkplugMessageType)}
   */
  @Test
  @DisplayName("Test isType(SparkplugMessageType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugTopic.isType(SparkplugMessageType)"})
  void testIsType2() {
    // Arrange, Act and Assert
    assertFalse(
        (new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NDEATH)).isType(SparkplugMessageType.NBIRTH));
  }

  /**
   * Test {@link SparkplugTopic#isType(SparkplugMessageType)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugTopic#isType(SparkplugMessageType)}
   */
  @Test
  @DisplayName("Test isType(SparkplugMessageType); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugTopic.isType(SparkplugMessageType)"})
  void testIsType_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH)).isType(SparkplugMessageType.NBIRTH));
  }

  /**
   * Test {@link SparkplugTopic#isNode()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugTopic#isNode()}
   */
  @Test
  @DisplayName("Test isNode(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugTopic.isNode()"})
  void testIsNode_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SparkplugTopic("Namespace", "42", "42", "42", SparkplugMessageType.NBIRTH)).isNode());
  }

  /**
   * Test {@link SparkplugTopic#isNode()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugTopic#isNode()}
   */
  @Test
  @DisplayName("Test isNode(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugTopic.isNode()"})
  void testIsNode_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH)).isNode());
  }

  /**
   * Test {@link SparkplugTopic#getNodeDeviceName()}.
   * <p>
   * Method under test: {@link SparkplugTopic#getNodeDeviceName()}
   */
  @Test
  @DisplayName("Test getNodeDeviceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SparkplugTopic.getNodeDeviceName()"})
  void testGetNodeDeviceName() {
    // Arrange, Act and Assert
    assertEquals("42", (new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH)).getNodeDeviceName());
  }

  /**
   * Test {@link SparkplugTopic#getNodeDeviceName()}.
   * <p>
   * Method under test: {@link SparkplugTopic#getNodeDeviceName()}
   */
  @Test
  @DisplayName("Test getNodeDeviceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SparkplugTopic.getNodeDeviceName()"})
  void testGetNodeDeviceName2() {
    // Arrange, Act and Assert
    assertEquals("42",
        (new SparkplugTopic("Namespace", "42", "42", "42", SparkplugMessageType.NBIRTH)).getNodeDeviceName());
  }
}
