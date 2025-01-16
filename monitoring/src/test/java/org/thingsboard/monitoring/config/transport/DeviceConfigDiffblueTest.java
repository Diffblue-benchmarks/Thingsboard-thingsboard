package org.thingsboard.monitoring.config.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class DeviceConfigDiffblueTest {
  /**
   * Test {@link DeviceConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceConfig deviceConfig = new DeviceConfig();
    deviceConfig.setCredentials(mock(DeviceCredentials.class));
    deviceConfig.setId("");
    deviceConfig.setName("Name");

    DeviceConfig deviceConfig2 = new DeviceConfig();
    deviceConfig2.setCredentials(new DeviceCredentials());
    deviceConfig2.setId("");
    deviceConfig2.setName("Name");

    // Act and Assert
    assertNotEquals(deviceConfig, deviceConfig2);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceConfig}
   *   <li>{@link DeviceConfig#setCredentials(DeviceCredentials)}
   *   <li>{@link DeviceConfig#setName(String)}
   *   <li>{@link DeviceConfig#toString()}
   *   <li>{@link DeviceConfig#getCredentials()}
   *   <li>{@link DeviceConfig#getId()}
   *   <li>{@link DeviceConfig#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceConfig actualDeviceConfig = new DeviceConfig();
    DeviceCredentials credentials = new DeviceCredentials();
    actualDeviceConfig.setCredentials(credentials);
    actualDeviceConfig.setName("Name");
    String actualToStringResult = actualDeviceConfig.toString();
    DeviceCredentials actualCredentials = actualDeviceConfig.getCredentials();
    actualDeviceConfig.getId();

    // Assert that nothing has changed
    assertEquals("DeviceConfig(id=null, name=Name, credentials=DeviceCredentials [deviceId=null, credentialsType=null,"
        + " credentialsId=null, credentialsValue=null, createdTime=0, id=null])", actualToStringResult);
    assertEquals("Name", actualDeviceConfig.getName());
    assertSame(credentials, actualCredentials);
  }
}
