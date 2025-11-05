package org.thingsboard.server.transport.mqtt.util.sparkplug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SparkplugTopicDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return DeviceId is {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugTopic#SparkplugTopic(String, String, String, String,
   *       SparkplugMessageType)}
   *   <li>{@link SparkplugTopic#getDeviceId()}
   *   <li>{@link SparkplugTopic#getEdgeNodeId()}
   *   <li>{@link SparkplugTopic#getGroupId()}
   *   <li>{@link SparkplugTopic#getNamespace()}
   *   <li>{@link SparkplugTopic#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return DeviceId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugTopic.<init>(String, String, String, String, SparkplugMessageType)",
    "void SparkplugTopic.<init>(String, String, String, SparkplugMessageType)",
    "String SparkplugTopic.getDeviceId()",
    "String SparkplugTopic.getEdgeNodeId()",
    "String SparkplugTopic.getGroupId()",
    "String SparkplugTopic.getNamespace()",
    "SparkplugMessageType SparkplugTopic.getType()"
  })
  void testGettersAndSetters_thenReturnDeviceIdIs42() {
    // Arrange and Act
    SparkplugTopic actualSparkplugTopic =
        new SparkplugTopic("Namespace", "42", "42", "42", SparkplugMessageType.NBIRTH);
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
   *
   * <ul>
   *   <li>Then return DeviceId is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugTopic.<init>(String, String, String, String, SparkplugMessageType)",
    "void SparkplugTopic.<init>(String, String, String, SparkplugMessageType)",
    "String SparkplugTopic.getDeviceId()",
    "String SparkplugTopic.getEdgeNodeId()",
    "String SparkplugTopic.getGroupId()",
    "String SparkplugTopic.getNamespace()",
    "SparkplugMessageType SparkplugTopic.getType()"
  })
  void testGettersAndSetters_thenReturnDeviceIdIsNull() {
    // Arrange and Act
    SparkplugTopic actualSparkplugTopic =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);
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
   *
   * <ul>
   *   <li>Then return DeviceId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopic#SparkplugTopic(SparkplugTopic,
   * SparkplugMessageType, String)}
   */
  @Test
  @DisplayName(
      "Test new SparkplugTopic(SparkplugTopic, SparkplugMessageType, String); then return DeviceId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SparkplugTopic.<init>(SparkplugTopic, SparkplugMessageType, String)"})
  void testNewSparkplugTopic_thenReturnDeviceIdIs42() {
    // Arrange
    SparkplugTopic sparkplugTopic =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    // Act
    SparkplugTopic actualSparkplugTopic =
        new SparkplugTopic(sparkplugTopic, SparkplugMessageType.NBIRTH, "42");

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
   *
   * <ul>
   *   <li>Then return EdgeNodeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopic#SparkplugTopic(SparkplugTopic,
   * SparkplugMessageType)}
   */
  @Test
  @DisplayName(
      "Test new SparkplugTopic(SparkplugTopic, SparkplugMessageType); then return EdgeNodeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SparkplugTopic.<init>(SparkplugTopic, SparkplugMessageType)"})
  void testNewSparkplugTopic_thenReturnEdgeNodeIdIs42() {
    // Arrange
    SparkplugTopic sparkplugTopic =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    // Act
    SparkplugTopic actualSparkplugTopic =
        new SparkplugTopic(sparkplugTopic, SparkplugMessageType.NBIRTH);

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
   *
   * <ul>
   *   <li>Then return {@code //42/NBIRTH/42/42}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopic#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '//42/NBIRTH/42/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SparkplugTopic.toString()"})
  void testToString_thenReturn42Nbirth4242() {
    // Arrange
    SparkplugTopic sparkplugTopic =
        new SparkplugTopic("/", "42", "42", "42", SparkplugMessageType.NBIRTH);

    // Act and Assert
    assertEquals("//42/NBIRTH/42/42", sparkplugTopic.toString());
  }

  /**
   * Test {@link SparkplugTopic#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Namespace/42/NBIRTH/42}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopic#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Namespace/42/NBIRTH/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SparkplugTopic.toString()"})
  void testToString_thenReturnNamespace42Nbirth42() {
    // Arrange
    SparkplugTopic sparkplugTopic =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    // Act and Assert
    assertEquals("Namespace/42/NBIRTH/42", sparkplugTopic.toString());
  }

  /**
   * Test {@link SparkplugTopic#isType(SparkplugMessageType)}.
   *
   * <p>Method under test: {@link SparkplugTopic#isType(SparkplugMessageType)}
   */
  @Test
  @DisplayName("Test isType(SparkplugMessageType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugTopic.isType(SparkplugMessageType)"})
  void testIsType() {
    // Arrange
    SparkplugTopic sparkplugTopic =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NDEATH);

    // Act and Assert
    assertFalse(sparkplugTopic.isType(SparkplugMessageType.NBIRTH));
  }

  /**
   * Test {@link SparkplugTopic#isType(SparkplugMessageType)}.
   *
   * <ul>
   *   <li>Given {@link SparkplugTopic#SparkplugTopic(SparkplugTopic, SparkplugMessageType)} with
   *       sparkplugTopic is {@link SparkplugTopic#SparkplugTopic(String, String, String,
   *       SparkplugMessageType)} and type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopic#isType(SparkplugMessageType)}
   */
  @Test
  @DisplayName(
      "Test isType(SparkplugMessageType); given SparkplugTopic(SparkplugTopic, SparkplugMessageType) with sparkplugTopic is SparkplugTopic(String, String, String, SparkplugMessageType) and type is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugTopic.isType(SparkplugMessageType)"})
  void testIsType_givenSparkplugTopicWithSparkplugTopicIsSparkplugTopicAndTypeIsNull() {
    // Arrange
    SparkplugTopic sparkplugTopic =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);
    SparkplugTopic sparkplugTopic2 = new SparkplugTopic(sparkplugTopic, null);

    // Act and Assert
    assertFalse(sparkplugTopic2.isType(SparkplugMessageType.NBIRTH));
  }

  /**
   * Test {@link SparkplugTopic#isType(SparkplugMessageType)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopic#isType(SparkplugMessageType)}
   */
  @Test
  @DisplayName("Test isType(SparkplugMessageType); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugTopic.isType(SparkplugMessageType)"})
  void testIsType_thenReturnTrue() {
    // Arrange
    SparkplugTopic sparkplugTopic =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    // Act and Assert
    assertTrue(sparkplugTopic.isType(SparkplugMessageType.NBIRTH));
  }

  /**
   * Test {@link SparkplugTopic#isNode()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopic#isNode()}
   */
  @Test
  @DisplayName("Test isNode(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugTopic.isNode()"})
  void testIsNode_thenReturnFalse() {
    // Arrange
    SparkplugTopic sparkplugTopic =
        new SparkplugTopic("Namespace", "42", "42", "42", SparkplugMessageType.NBIRTH);

    // Act and Assert
    assertFalse(sparkplugTopic.isNode());
  }

  /**
   * Test {@link SparkplugTopic#isNode()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugTopic#isNode()}
   */
  @Test
  @DisplayName("Test isNode(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugTopic.isNode()"})
  void testIsNode_thenReturnTrue() {
    // Arrange
    SparkplugTopic sparkplugTopic =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    // Act and Assert
    assertTrue(sparkplugTopic.isNode());
  }

  /**
   * Test {@link SparkplugTopic#getNodeDeviceName()}.
   *
   * <p>Method under test: {@link SparkplugTopic#getNodeDeviceName()}
   */
  @Test
  @DisplayName("Test getNodeDeviceName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SparkplugTopic.getNodeDeviceName()"})
  void testGetNodeDeviceName() {
    // Arrange
    SparkplugTopic sparkplugTopic =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    // Act and Assert
    assertEquals("42", sparkplugTopic.getNodeDeviceName());
  }

  /**
   * Test {@link SparkplugTopic#getNodeDeviceName()}.
   *
   * <p>Method under test: {@link SparkplugTopic#getNodeDeviceName()}
   */
  @Test
  @DisplayName("Test getNodeDeviceName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SparkplugTopic.getNodeDeviceName()"})
  void testGetNodeDeviceName2() {
    // Arrange
    SparkplugTopic sparkplugTopic =
        new SparkplugTopic("Namespace", "42", "42", "42", SparkplugMessageType.NBIRTH);

    // Act and Assert
    assertEquals("42", sparkplugTopic.getNodeDeviceName());
  }
}
