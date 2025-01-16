package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class DeviceConnectivityConfigurationDiffblueTest {
  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}, and
   * {@link DeviceConnectivityConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceConnectivityConfiguration#equals(Object)}
   *   <li>{@link DeviceConnectivityConfiguration#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceConnectivityConfiguration deviceConnectivityConfiguration = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration.setConnectivity(new HashMap<>());

    DeviceConnectivityConfiguration deviceConnectivityConfiguration2 = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration2.setConnectivity(new HashMap<>());

    // Act and Assert
    assertEquals(deviceConnectivityConfiguration, deviceConnectivityConfiguration2);
    int expectedHashCodeResult = deviceConnectivityConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, deviceConnectivityConfiguration2.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}, and
   * {@link DeviceConnectivityConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceConnectivityConfiguration#equals(Object)}
   *   <li>{@link DeviceConnectivityConfiguration#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceConnectivityConfiguration deviceConnectivityConfiguration = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration.setConnectivity(new HashMap<>());

    // Act and Assert
    assertEquals(deviceConnectivityConfiguration, deviceConnectivityConfiguration);
    int expectedHashCodeResult = deviceConnectivityConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, deviceConnectivityConfiguration.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityConfiguration#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    HashMap<String, DeviceConnectivityInfo> connectivity = new HashMap<>();
    connectivity.put("foo", deviceConnectivityInfo);

    DeviceConnectivityConfiguration deviceConnectivityConfiguration = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration.setConnectivity(connectivity);

    DeviceConnectivityConfiguration deviceConnectivityConfiguration2 = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration2.setConnectivity(new HashMap<>());

    // Act and Assert
    assertNotEquals(deviceConnectivityConfiguration, deviceConnectivityConfiguration2);
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityConfiguration#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    HashMap<String, DeviceConnectivityInfo> connectivity = new HashMap<>();
    connectivity.computeIfPresent("foo", mock(BiFunction.class));
    connectivity.put("foo", deviceConnectivityInfo);

    DeviceConnectivityConfiguration deviceConnectivityConfiguration = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration.setConnectivity(connectivity);

    DeviceConnectivityConfiguration deviceConnectivityConfiguration2 = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration2.setConnectivity(new HashMap<>());

    // Act and Assert
    assertNotEquals(deviceConnectivityConfiguration, deviceConnectivityConfiguration2);
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityConfiguration#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceConnectivityConfiguration deviceConnectivityConfiguration = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration.setConnectivity(new HashMap<>());

    // Act and Assert
    assertNotEquals(deviceConnectivityConfiguration, null);
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityConfiguration#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceConnectivityConfiguration deviceConnectivityConfiguration = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration.setConnectivity(new HashMap<>());

    // Act and Assert
    assertNotEquals(deviceConnectivityConfiguration, "Different type to DeviceConnectivityConfiguration");
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#getConnectivity(String)} with
   * {@code String}.
   * <ul>
   *   <li>Given {@link DeviceConnectivityConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityConfiguration#getConnectivity(String)}
   */
  @Test
  public void testGetConnectivityWithString_givenDeviceConnectivityConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DeviceConnectivityConfiguration()).getConnectivity("Protocol"));
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#getConnectivity(String)} with
   * {@code String}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityConfiguration#getConnectivity(String)}
   */
  @Test
  public void testGetConnectivityWithString_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, DeviceConnectivityInfo> connectivity = new HashMap<>();
    connectivity.computeIfPresent("foo", mock(BiFunction.class));

    DeviceConnectivityConfiguration deviceConnectivityConfiguration = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration.setConnectivity(connectivity);

    // Act and Assert
    assertNull(deviceConnectivityConfiguration.getConnectivity("Protocol"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceConnectivityConfiguration#setConnectivity(Map)}
   *   <li>{@link DeviceConnectivityConfiguration#toString()}
   *   <li>{@link DeviceConnectivityConfiguration#getConnectivity()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    DeviceConnectivityConfiguration deviceConnectivityConfiguration = new DeviceConnectivityConfiguration();
    HashMap<String, DeviceConnectivityInfo> connectivity = new HashMap<>();

    // Act
    deviceConnectivityConfiguration.setConnectivity(connectivity);
    String actualToStringResult = deviceConnectivityConfiguration.toString();
    Map<String, DeviceConnectivityInfo> actualConnectivity = deviceConnectivityConfiguration.getConnectivity();

    // Assert that nothing has changed
    assertEquals("DeviceConnectivityConfiguration(connectivity={})", actualToStringResult);
    assertTrue(actualConnectivity.isEmpty());
    assertSame(connectivity, actualConnectivity);
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#isEnabled(String)}.
   * <ul>
   *   <li>Given {@link DeviceConnectivityConfiguration} (default constructor).</li>
   *   <li>When {@code Protocol}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityConfiguration#isEnabled(String)}
   */
  @Test
  public void testIsEnabled_givenDeviceConnectivityConfiguration_whenProtocol_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DeviceConnectivityConfiguration()).isEnabled("Protocol"));
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#isEnabled(String)}.
   * <ul>
   *   <li>Given {@link DeviceConnectivityInfo} (default constructor) Enabled is
   * {@code false}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityConfiguration#isEnabled(String)}
   */
  @Test
  public void testIsEnabled_givenDeviceConnectivityInfoEnabledIsFalse_when42_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(false);
    deviceConnectivityInfo.setHost("Host");
    deviceConnectivityInfo.setPort("org.thingsboard.server.dao.device.DeviceConnectivityInfo");

    HashMap<String, DeviceConnectivityInfo> connectivity = new HashMap<>();
    connectivity.put("42", deviceConnectivityInfo);
    connectivity.computeIfPresent("foo", mock(BiFunction.class));

    DeviceConnectivityConfiguration deviceConnectivityConfiguration = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration.setConnectivity(connectivity);

    // Act and Assert
    assertFalse(deviceConnectivityConfiguration.isEnabled("42"));
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#isEnabled(String)}.
   * <ul>
   *   <li>Given {@link DeviceConnectivityInfo} (default constructor) Enabled is
   * {@code true}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityConfiguration#isEnabled(String)}
   */
  @Test
  public void testIsEnabled_givenDeviceConnectivityInfoEnabledIsTrue_when42_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("Host");
    deviceConnectivityInfo.setPort("org.thingsboard.server.dao.device.DeviceConnectivityInfo");

    HashMap<String, DeviceConnectivityInfo> connectivity = new HashMap<>();
    connectivity.put("42", deviceConnectivityInfo);
    connectivity.computeIfPresent("foo", mock(BiFunction.class));

    DeviceConnectivityConfiguration deviceConnectivityConfiguration = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration.setConnectivity(connectivity);

    // Act and Assert
    assertTrue(deviceConnectivityConfiguration.isEnabled("42"));
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#isEnabled(String)}.
   * <ul>
   *   <li>When {@code Protocol}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityConfiguration#isEnabled(String)}
   */
  @Test
  public void testIsEnabled_whenProtocol_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, DeviceConnectivityInfo> connectivity = new HashMap<>();
    connectivity.computeIfPresent("foo", mock(BiFunction.class));

    DeviceConnectivityConfiguration deviceConnectivityConfiguration = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration.setConnectivity(connectivity);

    // Act and Assert
    assertFalse(deviceConnectivityConfiguration.isEnabled("Protocol"));
  }
}
