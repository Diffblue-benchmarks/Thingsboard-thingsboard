package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DeviceConnectivityConfigurationDiffblueTest {
  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}, and {@link DeviceConnectivityConfiguration#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceConnectivityConfiguration.equals(Object)",
      "int DeviceConnectivityConfiguration.hashCode()"})
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
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}, and {@link DeviceConnectivityConfiguration#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceConnectivityConfiguration.equals(Object)",
      "int DeviceConnectivityConfiguration.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceConnectivityConfiguration.equals(Object)",
      "int DeviceConnectivityConfiguration.hashCode()"})
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
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityConfiguration#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceConnectivityConfiguration.equals(Object)",
      "int DeviceConnectivityConfiguration.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceConnectivityConfiguration.equals(Object)",
      "int DeviceConnectivityConfiguration.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceConnectivityConfiguration deviceConnectivityConfiguration = new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration.setConnectivity(new HashMap<>());

    // Act and Assert
    assertNotEquals(deviceConnectivityConfiguration, "Different type to DeviceConnectivityConfiguration");
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#getConnectivity(String)} with {@code String}.
   * <p>
   * Method under test: {@link DeviceConnectivityConfiguration#getConnectivity(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceConnectivityInfo DeviceConnectivityConfiguration.getConnectivity(String)"})
  public void testGetConnectivityWithString() {
    // Arrange, Act and Assert
    assertNull((new DeviceConnectivityConfiguration()).getConnectivity("Protocol"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DeviceConnectivityConfiguration.getConnectivity()",
      "void DeviceConnectivityConfiguration.setConnectivity(Map)", "String DeviceConnectivityConfiguration.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    DeviceConnectivityConfiguration deviceConnectivityConfiguration = new DeviceConnectivityConfiguration();
    HashMap<String, DeviceConnectivityInfo> connectivity = new HashMap<>();

    // Act
    deviceConnectivityConfiguration.setConnectivity(connectivity);
    String actualToStringResult = deviceConnectivityConfiguration.toString();
    Map<String, DeviceConnectivityInfo> actualConnectivity = deviceConnectivityConfiguration.getConnectivity();

    // Assert
    assertEquals("DeviceConnectivityConfiguration(connectivity={})", actualToStringResult);
    assertTrue(actualConnectivity.isEmpty());
    assertSame(connectivity, actualConnectivity);
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#isEnabled(String)}.
   * <p>
   * Method under test: {@link DeviceConnectivityConfiguration#isEnabled(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceConnectivityConfiguration.isEnabled(String)"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertFalse((new DeviceConnectivityConfiguration()).isEnabled("Protocol"));
  }
}
