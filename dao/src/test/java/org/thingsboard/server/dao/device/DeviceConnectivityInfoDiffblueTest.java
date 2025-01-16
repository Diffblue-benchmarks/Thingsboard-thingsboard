package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DeviceConnectivityInfoDiffblueTest {
  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}, and
   * {@link DeviceConnectivityInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceConnectivityInfo#equals(Object)}
   *   <li>{@link DeviceConnectivityInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
    int expectedHashCodeResult = deviceConnectivityInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceConnectivityInfo2.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}, and
   * {@link DeviceConnectivityInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceConnectivityInfo#equals(Object)}
   *   <li>{@link DeviceConnectivityInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost(null);
    deviceConnectivityInfo.setPort("Port");

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost(null);
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
    int expectedHashCodeResult = deviceConnectivityInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceConnectivityInfo2.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}, and
   * {@link DeviceConnectivityInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceConnectivityInfo#equals(Object)}
   *   <li>{@link DeviceConnectivityInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort(null);

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort(null);

    // Act and Assert
    assertEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
    int expectedHashCodeResult = deviceConnectivityInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceConnectivityInfo2.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}, and
   * {@link DeviceConnectivityInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceConnectivityInfo#equals(Object)}
   *   <li>{@link DeviceConnectivityInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    // Act and Assert
    assertEquals(deviceConnectivityInfo, deviceConnectivityInfo);
    int expectedHashCodeResult = deviceConnectivityInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceConnectivityInfo.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(false);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("Port");
    deviceConnectivityInfo.setPort("Port");

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost(null);
    deviceConnectivityInfo.setPort("Port");

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("localhost");

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort(null);

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, null);
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, "Different type to DeviceConnectivityInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceConnectivityInfo}
   *   <li>{@link DeviceConnectivityInfo#setEnabled(boolean)}
   *   <li>{@link DeviceConnectivityInfo#setHost(String)}
   *   <li>{@link DeviceConnectivityInfo#setPort(String)}
   *   <li>{@link DeviceConnectivityInfo#toString()}
   *   <li>{@link DeviceConnectivityInfo#getHost()}
   *   <li>{@link DeviceConnectivityInfo#getPort()}
   *   <li>{@link DeviceConnectivityInfo#isEnabled()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DeviceConnectivityInfo actualDeviceConnectivityInfo = new DeviceConnectivityInfo();
    actualDeviceConnectivityInfo.setEnabled(true);
    actualDeviceConnectivityInfo.setHost("localhost");
    actualDeviceConnectivityInfo.setPort("Port");
    String actualToStringResult = actualDeviceConnectivityInfo.toString();
    String actualHost = actualDeviceConnectivityInfo.getHost();
    String actualPort = actualDeviceConnectivityInfo.getPort();

    // Assert that nothing has changed
    assertEquals("DeviceConnectivityInfo(enabled=true, host=localhost, port=Port)", actualToStringResult);
    assertEquals("Port", actualPort);
    assertEquals("localhost", actualHost);
    assertTrue(actualDeviceConnectivityInfo.isEnabled());
  }
}
