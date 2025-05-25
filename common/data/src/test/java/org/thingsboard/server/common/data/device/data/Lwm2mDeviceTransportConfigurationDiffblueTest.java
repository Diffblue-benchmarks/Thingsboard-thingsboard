package org.thingsboard.server.common.data.device.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;

class Lwm2mDeviceTransportConfigurationDiffblueTest {
  /**
   * Test {@link Lwm2mDeviceTransportConfiguration#put(String, Object)}.
   * <p>
   * Method under test: {@link Lwm2mDeviceTransportConfiguration#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Lwm2mDeviceTransportConfiguration.put(String, Object)"})
  void testPut() {
    // Arrange
    Lwm2mDeviceTransportConfiguration lwm2mDeviceTransportConfiguration = new Lwm2mDeviceTransportConfiguration();

    // Act
    lwm2mDeviceTransportConfiguration.put("Name", "Value");

    // Assert
    Map<String, Object> properties = lwm2mDeviceTransportConfiguration.getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
  }

  /**
   * Test {@link Lwm2mDeviceTransportConfiguration#equals(Object)}, and {@link Lwm2mDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Lwm2mDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Lwm2mDeviceTransportConfiguration.equals(Object)",
      "int Lwm2mDeviceTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Lwm2mDeviceTransportConfiguration lwm2mDeviceTransportConfiguration = new Lwm2mDeviceTransportConfiguration();
    Lwm2mDeviceTransportConfiguration lwm2mDeviceTransportConfiguration2 = new Lwm2mDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(lwm2mDeviceTransportConfiguration, lwm2mDeviceTransportConfiguration2);
    int expectedHashCodeResult = lwm2mDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link Lwm2mDeviceTransportConfiguration#equals(Object)}, and {@link Lwm2mDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Lwm2mDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Lwm2mDeviceTransportConfiguration.equals(Object)",
      "int Lwm2mDeviceTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Lwm2mDeviceTransportConfiguration lwm2mDeviceTransportConfiguration = new Lwm2mDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(lwm2mDeviceTransportConfiguration, lwm2mDeviceTransportConfiguration);
    int expectedHashCodeResult = lwm2mDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceTransportConfiguration.hashCode());
  }

  /**
   * Test {@link Lwm2mDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Lwm2mDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Lwm2mDeviceTransportConfiguration.equals(Object)",
      "int Lwm2mDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Lwm2mDeviceTransportConfiguration lwm2mDeviceTransportConfiguration = new Lwm2mDeviceTransportConfiguration();
    lwm2mDeviceTransportConfiguration.put("Name", "Value");

    // Act and Assert
    assertNotEquals(lwm2mDeviceTransportConfiguration, new Lwm2mDeviceTransportConfiguration());
  }

  /**
   * Test {@link Lwm2mDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Lwm2mDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Lwm2mDeviceTransportConfiguration.equals(Object)",
      "int Lwm2mDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Lwm2mDeviceTransportConfiguration(), null);
  }

  /**
   * Test {@link Lwm2mDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Lwm2mDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Lwm2mDeviceTransportConfiguration.equals(Object)",
      "int Lwm2mDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Lwm2mDeviceTransportConfiguration(), "Different type to Lwm2mDeviceTransportConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Lwm2mDeviceTransportConfiguration}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#setProperties(Map)}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#toString()}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#getProperties()}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#getType()}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#properties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Lwm2mDeviceTransportConfiguration.<init>()",
      "Map Lwm2mDeviceTransportConfiguration.getProperties()",
      "DeviceTransportType Lwm2mDeviceTransportConfiguration.getType()",
      "Map Lwm2mDeviceTransportConfiguration.properties()", "void Lwm2mDeviceTransportConfiguration.setProperties(Map)",
      "String Lwm2mDeviceTransportConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    Lwm2mDeviceTransportConfiguration actualLwm2mDeviceTransportConfiguration = new Lwm2mDeviceTransportConfiguration();
    HashMap<String, Object> properties = new HashMap<>();
    actualLwm2mDeviceTransportConfiguration.setProperties(properties);
    String actualToStringResult = actualLwm2mDeviceTransportConfiguration.toString();
    Map<String, Object> actualProperties = actualLwm2mDeviceTransportConfiguration.getProperties();
    DeviceTransportType actualType = actualLwm2mDeviceTransportConfiguration.getType();
    Map<String, Object> actualPropertiesResult = actualLwm2mDeviceTransportConfiguration.properties();

    // Assert
    assertEquals("Lwm2mDeviceTransportConfiguration(properties={})", actualToStringResult);
    assertNull(actualLwm2mDeviceTransportConfiguration.getEdrxCycle());
    assertNull(actualLwm2mDeviceTransportConfiguration.getPagingTransmissionWindow());
    assertNull(actualLwm2mDeviceTransportConfiguration.getPsmActivityTimer());
    assertNull(actualLwm2mDeviceTransportConfiguration.getPowerMode());
    assertEquals(DeviceTransportType.LWM2M, actualType);
    assertTrue(actualProperties.isEmpty());
    assertSame(properties, actualProperties);
    assertSame(properties, actualPropertiesResult);
  }
}
