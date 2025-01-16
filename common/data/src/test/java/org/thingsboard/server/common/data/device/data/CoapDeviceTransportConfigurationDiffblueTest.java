package org.thingsboard.server.common.data.device.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;

class CoapDeviceTransportConfigurationDiffblueTest {
  /**
   * Test {@link CoapDeviceTransportConfiguration#put(String, Object)}.
   * <ul>
   *   <li>Given {@link CoapDeviceTransportConfiguration} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapDeviceTransportConfiguration#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object); given CoapDeviceTransportConfiguration (default constructor)")
  void testPut_givenCoapDeviceTransportConfiguration() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration = new CoapDeviceTransportConfiguration();

    // Act
    coapDeviceTransportConfiguration.put("Name", "Value");

    // Assert
    Map<String, Object> properties = coapDeviceTransportConfiguration.getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#put(String, Object)}.
   * <ul>
   *   <li>Then {@link CoapDeviceTransportConfiguration} (default constructor)
   * Properties is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapDeviceTransportConfiguration#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object); then CoapDeviceTransportConfiguration (default constructor) Properties is HashMap()")
  void testPut_thenCoapDeviceTransportConfigurationPropertiesIsHashMap() {
    // Arrange
    HashMap<String, Object> properties = new HashMap<>();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration = new CoapDeviceTransportConfiguration();
    coapDeviceTransportConfiguration.setProperties(properties);

    // Act
    coapDeviceTransportConfiguration.put("Name", "Value");

    // Assert
    Map<String, Object> properties2 = coapDeviceTransportConfiguration.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Value", properties2.get("Name"));
    assertSame(properties, properties2);
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}, and
   * {@link CoapDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CoapDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link CoapDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration = new CoapDeviceTransportConfiguration();
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration2 = new CoapDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(coapDeviceTransportConfiguration, coapDeviceTransportConfiguration2);
    int expectedHashCodeResult = coapDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, coapDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}, and
   * {@link CoapDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CoapDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link CoapDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration = new CoapDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(coapDeviceTransportConfiguration, coapDeviceTransportConfiguration);
    int expectedHashCodeResult = coapDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, coapDeviceTransportConfiguration.hashCode());
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration = new CoapDeviceTransportConfiguration();
    coapDeviceTransportConfiguration.put("Name", "Value");

    // Act and Assert
    assertNotEquals(coapDeviceTransportConfiguration, new CoapDeviceTransportConfiguration());
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CoapDeviceTransportConfiguration(), null);
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CoapDeviceTransportConfiguration(), "Different type to CoapDeviceTransportConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link CoapDeviceTransportConfiguration}
   *   <li>{@link CoapDeviceTransportConfiguration#setProperties(Map)}
   *   <li>{@link CoapDeviceTransportConfiguration#toString()}
   *   <li>{@link CoapDeviceTransportConfiguration#getProperties()}
   *   <li>{@link CoapDeviceTransportConfiguration#getType()}
   *   <li>{@link CoapDeviceTransportConfiguration#properties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    CoapDeviceTransportConfiguration actualCoapDeviceTransportConfiguration = new CoapDeviceTransportConfiguration();
    HashMap<String, Object> properties = new HashMap<>();
    actualCoapDeviceTransportConfiguration.setProperties(properties);
    String actualToStringResult = actualCoapDeviceTransportConfiguration.toString();
    Map<String, Object> actualProperties = actualCoapDeviceTransportConfiguration.getProperties();
    DeviceTransportType actualType = actualCoapDeviceTransportConfiguration.getType();
    Map<String, Object> actualPropertiesResult = actualCoapDeviceTransportConfiguration.properties();

    // Assert that nothing has changed
    assertEquals("CoapDeviceTransportConfiguration(properties={})", actualToStringResult);
    assertEquals(DeviceTransportType.COAP, actualType);
    assertTrue(actualProperties.isEmpty());
    assertSame(properties, actualProperties);
    assertSame(properties, actualPropertiesResult);
  }
}
