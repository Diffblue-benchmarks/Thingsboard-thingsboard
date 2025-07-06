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

class CoapDeviceTransportConfigurationDiffblueTest {
  /**
   * Test {@link CoapDeviceTransportConfiguration#put(String, Object)}.
   *
   * <p>Method under test: {@link CoapDeviceTransportConfiguration#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapDeviceTransportConfiguration.put(String, Object)"})
  void testPut() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration =
        new CoapDeviceTransportConfiguration();

    // Act
    coapDeviceTransportConfiguration.put("Name", "Value");

    // Assert
    Map<String, Object> properties = coapDeviceTransportConfiguration.getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}, and {@link
   * CoapDeviceTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CoapDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link CoapDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CoapDeviceTransportConfiguration.equals(Object)",
    "int CoapDeviceTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration =
        new CoapDeviceTransportConfiguration();
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration2 =
        new CoapDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(coapDeviceTransportConfiguration, coapDeviceTransportConfiguration2);
    int expectedHashCodeResult = coapDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, coapDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}, and {@link
   * CoapDeviceTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CoapDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link CoapDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CoapDeviceTransportConfiguration.equals(Object)",
    "int CoapDeviceTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration =
        new CoapDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(coapDeviceTransportConfiguration, coapDeviceTransportConfiguration);
    int expectedHashCodeResult = coapDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, coapDeviceTransportConfiguration.hashCode());
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CoapDeviceTransportConfiguration.equals(Object)",
    "int CoapDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration =
        new CoapDeviceTransportConfiguration();
    coapDeviceTransportConfiguration.put("Name", "Value");

    // Act and Assert
    assertNotEquals(coapDeviceTransportConfiguration, new CoapDeviceTransportConfiguration());
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CoapDeviceTransportConfiguration.equals(Object)",
    "int CoapDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CoapDeviceTransportConfiguration(), null);
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CoapDeviceTransportConfiguration.equals(Object)",
    "int CoapDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CoapDeviceTransportConfiguration(),
        "Different type to CoapDeviceTransportConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CoapDeviceTransportConfiguration}
   *   <li>{@link CoapDeviceTransportConfiguration#setProperties(Map)}
   *   <li>{@link CoapDeviceTransportConfiguration#toString()}
   *   <li>{@link CoapDeviceTransportConfiguration#getProperties()}
   *   <li>{@link CoapDeviceTransportConfiguration#getType()}
   *   <li>{@link CoapDeviceTransportConfiguration#properties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void CoapDeviceTransportConfiguration.<init>()",
    "Map CoapDeviceTransportConfiguration.getProperties()",
    "DeviceTransportType CoapDeviceTransportConfiguration.getType()",
    "Map CoapDeviceTransportConfiguration.properties()",
    "void CoapDeviceTransportConfiguration.setProperties(Map)",
    "String CoapDeviceTransportConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    CoapDeviceTransportConfiguration actualCoapDeviceTransportConfiguration =
        new CoapDeviceTransportConfiguration();
    HashMap<String, Object> properties = new HashMap<>();
    actualCoapDeviceTransportConfiguration.setProperties(properties);
    String actualToStringResult = actualCoapDeviceTransportConfiguration.toString();
    Map<String, Object> actualProperties = actualCoapDeviceTransportConfiguration.getProperties();
    DeviceTransportType actualType = actualCoapDeviceTransportConfiguration.getType();
    Map<String, Object> actualPropertiesResult =
        actualCoapDeviceTransportConfiguration.properties();

    // Assert
    assertEquals("CoapDeviceTransportConfiguration(properties={})", actualToStringResult);
    assertNull(actualCoapDeviceTransportConfiguration.getEdrxCycle());
    assertNull(actualCoapDeviceTransportConfiguration.getPagingTransmissionWindow());
    assertNull(actualCoapDeviceTransportConfiguration.getPsmActivityTimer());
    assertNull(actualCoapDeviceTransportConfiguration.getPowerMode());
    assertEquals(DeviceTransportType.COAP, actualType);
    assertTrue(actualProperties.isEmpty());
    assertSame(properties, actualProperties);
    assertSame(properties, actualPropertiesResult);
  }
}
