package org.thingsboard.server.common.data.device.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;

class MqttDeviceTransportConfigurationDiffblueTest {
  /**
   * Test {@link MqttDeviceTransportConfiguration#put(String, Object)}.
   *
   * <p>Method under test: {@link MqttDeviceTransportConfiguration#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttDeviceTransportConfiguration.put(String, Object)"})
  void testPut() {
    // Arrange
    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration =
        new MqttDeviceTransportConfiguration();

    // Act
    mqttDeviceTransportConfiguration.put("Name", "Value");

    // Assert
    Map<String, Object> properties = mqttDeviceTransportConfiguration.getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
  }

  /**
   * Test {@link MqttDeviceTransportConfiguration#equals(Object)}, and {@link
   * MqttDeviceTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link MqttDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MqttDeviceTransportConfiguration.equals(Object)",
    "int MqttDeviceTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration =
        new MqttDeviceTransportConfiguration();
    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration2 =
        new MqttDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(mqttDeviceTransportConfiguration, mqttDeviceTransportConfiguration2);
    int expectedHashCodeResult = mqttDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, mqttDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link MqttDeviceTransportConfiguration#equals(Object)}, and {@link
   * MqttDeviceTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link MqttDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MqttDeviceTransportConfiguration.equals(Object)",
    "int MqttDeviceTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration =
        new MqttDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(mqttDeviceTransportConfiguration, mqttDeviceTransportConfiguration);
    int expectedHashCodeResult = mqttDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, mqttDeviceTransportConfiguration.hashCode());
  }

  /**
   * Test {@link MqttDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MqttDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MqttDeviceTransportConfiguration.equals(Object)",
    "int MqttDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration =
        new MqttDeviceTransportConfiguration();
    mqttDeviceTransportConfiguration.put("Name", "Value");

    // Act and Assert
    assertNotEquals(mqttDeviceTransportConfiguration, new MqttDeviceTransportConfiguration());
  }

  /**
   * Test {@link MqttDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MqttDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MqttDeviceTransportConfiguration.equals(Object)",
    "int MqttDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration =
        new MqttDeviceTransportConfiguration();
    mqttDeviceTransportConfiguration.put("Name", new MqttDeviceTransportConfiguration());

    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration2 =
        new MqttDeviceTransportConfiguration();
    mqttDeviceTransportConfiguration2.put("Name", "Value");

    // Act and Assert
    assertNotEquals(mqttDeviceTransportConfiguration, mqttDeviceTransportConfiguration2);
  }

  /**
   * Test {@link MqttDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MqttDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MqttDeviceTransportConfiguration.equals(Object)",
    "int MqttDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttDeviceTransportConfiguration(), null);
  }

  /**
   * Test {@link MqttDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MqttDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MqttDeviceTransportConfiguration.equals(Object)",
    "int MqttDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new MqttDeviceTransportConfiguration(),
        "Different type to MqttDeviceTransportConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MqttDeviceTransportConfiguration}
   *   <li>{@link MqttDeviceTransportConfiguration#setProperties(Map)}
   *   <li>{@link MqttDeviceTransportConfiguration#toString()}
   *   <li>{@link MqttDeviceTransportConfiguration#getProperties()}
   *   <li>{@link MqttDeviceTransportConfiguration#getType()}
   *   <li>{@link MqttDeviceTransportConfiguration#properties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttDeviceTransportConfiguration.<init>()",
    "Map MqttDeviceTransportConfiguration.getProperties()",
    "DeviceTransportType MqttDeviceTransportConfiguration.getType()",
    "Map MqttDeviceTransportConfiguration.properties()",
    "void MqttDeviceTransportConfiguration.setProperties(Map)",
    "String MqttDeviceTransportConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    MqttDeviceTransportConfiguration actualMqttDeviceTransportConfiguration =
        new MqttDeviceTransportConfiguration();
    HashMap<String, Object> properties = new HashMap<>();
    actualMqttDeviceTransportConfiguration.setProperties(properties);
    String actualToStringResult = actualMqttDeviceTransportConfiguration.toString();
    Map<String, Object> actualProperties = actualMqttDeviceTransportConfiguration.getProperties();
    DeviceTransportType actualType = actualMqttDeviceTransportConfiguration.getType();
    Map<String, Object> actualPropertiesResult =
        actualMqttDeviceTransportConfiguration.properties();

    // Assert
    assertEquals("MqttDeviceTransportConfiguration(properties={})", actualToStringResult);
    assertEquals(DeviceTransportType.MQTT, actualType);
    assertTrue(actualProperties.isEmpty());
    assertSame(properties, actualProperties);
    assertSame(properties, actualPropertiesResult);
  }
}
