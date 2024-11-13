package org.thingsboard.monitoring.config.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class TransportMonitoringTargetDiffblueTest {
  /**
   * Test {@link TransportMonitoringTarget#getDeviceId()}.
   * <ul>
   *   <li>Given {@link DeviceConfig} (default constructor) Credentials is
   * {@link DeviceCredentials#DeviceCredentials()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringTarget#getDeviceId()}
   */
  @Test
  @DisplayName("Test getDeviceId(); given DeviceConfig (default constructor) Credentials is DeviceCredentials(); then return 'null'")
  void testGetDeviceId_givenDeviceConfigCredentialsIsDeviceCredentials_thenReturnNull() {
    // Arrange
    DeviceConfig device = new DeviceConfig();
    device.setCredentials(new DeviceCredentials());
    device.setId("");
    device.setName("Name");

    TransportMonitoringTarget transportMonitoringTarget = new TransportMonitoringTarget();
    transportMonitoringTarget.setDevice(device);

    // Act and Assert
    assertNull(transportMonitoringTarget.getDeviceId());
  }

  /**
   * Test {@link TransportMonitoringTarget#getQueue()}.
   * <ul>
   *   <li>Given {@link TransportMonitoringTarget} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringTarget#getQueue()}
   */
  @Test
  @DisplayName("Test getQueue(); given TransportMonitoringTarget (default constructor)")
  void testGetQueue_givenTransportMonitoringTarget() {
    // Arrange, Act and Assert
    assertEquals("Main", (new TransportMonitoringTarget()).getQueue());
  }

  /**
   * Test {@link TransportMonitoringTarget#getQueue()}.
   * <ul>
   *   <li>Given {@link TransportMonitoringTarget} (default constructor) Queue is
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringTarget#getQueue()}
   */
  @Test
  @DisplayName("Test getQueue(); given TransportMonitoringTarget (default constructor) Queue is empty string")
  void testGetQueue_givenTransportMonitoringTargetQueueIsEmptyString() {
    // Arrange
    TransportMonitoringTarget transportMonitoringTarget = new TransportMonitoringTarget();
    transportMonitoringTarget.setQueue("");

    // Act and Assert
    assertEquals("Main", transportMonitoringTarget.getQueue());
  }

  /**
   * Test {@link TransportMonitoringTarget#getQueue()}.
   * <ul>
   *   <li>Given {@link TransportMonitoringTarget} (default constructor) Queue is
   * {@code Main}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringTarget#getQueue()}
   */
  @Test
  @DisplayName("Test getQueue(); given TransportMonitoringTarget (default constructor) Queue is 'Main'")
  void testGetQueue_givenTransportMonitoringTargetQueueIsMain() {
    // Arrange
    TransportMonitoringTarget transportMonitoringTarget = new TransportMonitoringTarget();
    transportMonitoringTarget.setQueue("Main");

    // Act and Assert
    assertEquals("Main", transportMonitoringTarget.getQueue());
  }

  /**
   * Test {@link TransportMonitoringTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceConfig device = mock(DeviceConfig.class);
    doNothing().when(device).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(device).setId(Mockito.<String>any());
    doNothing().when(device).setName(Mockito.<String>any());
    device.setCredentials(new DeviceCredentials());
    device.setId("42");
    device.setName("Name");

    TransportMonitoringTarget transportMonitoringTarget = new TransportMonitoringTarget();
    transportMonitoringTarget.setBaseUrl("https://example.org/example");
    transportMonitoringTarget.setCheckDomainIps(true);
    transportMonitoringTarget.setDevice(device);
    transportMonitoringTarget.setQueue("Queue");
    DeviceConfig device2 = mock(DeviceConfig.class);
    doNothing().when(device2).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(device2).setId(Mockito.<String>any());
    doNothing().when(device2).setName(Mockito.<String>any());
    device2.setCredentials(new DeviceCredentials());
    device2.setId("42");
    device2.setName("Name");

    TransportMonitoringTarget transportMonitoringTarget2 = new TransportMonitoringTarget();
    transportMonitoringTarget2.setBaseUrl("https://example.org/example");
    transportMonitoringTarget2.setCheckDomainIps(true);
    transportMonitoringTarget2.setDevice(device2);
    transportMonitoringTarget2.setQueue("Queue");

    // Act and Assert
    assertNotEquals(transportMonitoringTarget, transportMonitoringTarget2);
  }

  /**
   * Test {@link TransportMonitoringTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceConfig device = mock(DeviceConfig.class);
    doNothing().when(device).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(device).setId(Mockito.<String>any());
    doNothing().when(device).setName(Mockito.<String>any());
    device.setCredentials(new DeviceCredentials());
    device.setId("42");
    device.setName("Name");

    TransportMonitoringTarget transportMonitoringTarget = new TransportMonitoringTarget();
    transportMonitoringTarget.setBaseUrl("Base Url");
    transportMonitoringTarget.setCheckDomainIps(true);
    transportMonitoringTarget.setDevice(device);
    transportMonitoringTarget.setQueue("Queue");
    DeviceConfig device2 = mock(DeviceConfig.class);
    doNothing().when(device2).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(device2).setId(Mockito.<String>any());
    doNothing().when(device2).setName(Mockito.<String>any());
    device2.setCredentials(new DeviceCredentials());
    device2.setId("42");
    device2.setName("Name");

    TransportMonitoringTarget transportMonitoringTarget2 = new TransportMonitoringTarget();
    transportMonitoringTarget2.setBaseUrl("https://example.org/example");
    transportMonitoringTarget2.setCheckDomainIps(true);
    transportMonitoringTarget2.setDevice(device2);
    transportMonitoringTarget2.setQueue("Queue");

    // Act and Assert
    assertNotEquals(transportMonitoringTarget, transportMonitoringTarget2);
  }

  /**
   * Test {@link TransportMonitoringTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceConfig device = mock(DeviceConfig.class);
    doNothing().when(device).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(device).setId(Mockito.<String>any());
    doNothing().when(device).setName(Mockito.<String>any());
    device.setCredentials(new DeviceCredentials());
    device.setId("42");
    device.setName("Name");

    TransportMonitoringTarget transportMonitoringTarget = new TransportMonitoringTarget();
    transportMonitoringTarget.setBaseUrl(null);
    transportMonitoringTarget.setCheckDomainIps(true);
    transportMonitoringTarget.setDevice(device);
    transportMonitoringTarget.setQueue("Queue");
    DeviceConfig device2 = mock(DeviceConfig.class);
    doNothing().when(device2).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(device2).setId(Mockito.<String>any());
    doNothing().when(device2).setName(Mockito.<String>any());
    device2.setCredentials(new DeviceCredentials());
    device2.setId("42");
    device2.setName("Name");

    TransportMonitoringTarget transportMonitoringTarget2 = new TransportMonitoringTarget();
    transportMonitoringTarget2.setBaseUrl("https://example.org/example");
    transportMonitoringTarget2.setCheckDomainIps(true);
    transportMonitoringTarget2.setDevice(device2);
    transportMonitoringTarget2.setQueue("Queue");

    // Act and Assert
    assertNotEquals(transportMonitoringTarget, transportMonitoringTarget2);
  }

  /**
   * Test {@link TransportMonitoringTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceConfig device = mock(DeviceConfig.class);
    doNothing().when(device).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(device).setId(Mockito.<String>any());
    doNothing().when(device).setName(Mockito.<String>any());
    device.setCredentials(new DeviceCredentials());
    device.setId("42");
    device.setName("Name");

    TransportMonitoringTarget transportMonitoringTarget = new TransportMonitoringTarget();
    transportMonitoringTarget.setBaseUrl("https://example.org/example");
    transportMonitoringTarget.setCheckDomainIps(false);
    transportMonitoringTarget.setDevice(device);
    transportMonitoringTarget.setQueue("Queue");
    DeviceConfig device2 = mock(DeviceConfig.class);
    doNothing().when(device2).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(device2).setId(Mockito.<String>any());
    doNothing().when(device2).setName(Mockito.<String>any());
    device2.setCredentials(new DeviceCredentials());
    device2.setId("42");
    device2.setName("Name");

    TransportMonitoringTarget transportMonitoringTarget2 = new TransportMonitoringTarget();
    transportMonitoringTarget2.setBaseUrl("https://example.org/example");
    transportMonitoringTarget2.setCheckDomainIps(true);
    transportMonitoringTarget2.setDevice(device2);
    transportMonitoringTarget2.setQueue("Queue");

    // Act and Assert
    assertNotEquals(transportMonitoringTarget, transportMonitoringTarget2);
  }

  /**
   * Test {@link TransportMonitoringTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceConfig device = mock(DeviceConfig.class);
    doNothing().when(device).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(device).setId(Mockito.<String>any());
    doNothing().when(device).setName(Mockito.<String>any());
    device.setCredentials(new DeviceCredentials());
    device.setId("42");
    device.setName("Name");

    TransportMonitoringTarget transportMonitoringTarget = new TransportMonitoringTarget();
    transportMonitoringTarget.setBaseUrl(null);
    transportMonitoringTarget.setCheckDomainIps(true);
    transportMonitoringTarget.setDevice(device);
    transportMonitoringTarget.setQueue("Queue");
    DeviceConfig device2 = mock(DeviceConfig.class);
    doNothing().when(device2).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(device2).setId(Mockito.<String>any());
    doNothing().when(device2).setName(Mockito.<String>any());
    device2.setCredentials(new DeviceCredentials());
    device2.setId("42");
    device2.setName("Name");

    TransportMonitoringTarget transportMonitoringTarget2 = new TransportMonitoringTarget();
    transportMonitoringTarget2.setBaseUrl(null);
    transportMonitoringTarget2.setCheckDomainIps(true);
    transportMonitoringTarget2.setDevice(device2);
    transportMonitoringTarget2.setQueue("Queue");

    // Act and Assert
    assertNotEquals(transportMonitoringTarget, transportMonitoringTarget2);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TransportMonitoringTarget}
   *   <li>{@link TransportMonitoringTarget#setBaseUrl(String)}
   *   <li>{@link TransportMonitoringTarget#setCheckDomainIps(boolean)}
   *   <li>{@link TransportMonitoringTarget#setQueue(String)}
   *   <li>{@link TransportMonitoringTarget#toString()}
   *   <li>{@link TransportMonitoringTarget#getBaseUrl()}
   *   <li>{@link TransportMonitoringTarget#getDevice()}
   *   <li>{@link TransportMonitoringTarget#isCheckDomainIps()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TransportMonitoringTarget actualTransportMonitoringTarget = new TransportMonitoringTarget();
    actualTransportMonitoringTarget.setBaseUrl("https://example.org/example");
    actualTransportMonitoringTarget.setCheckDomainIps(true);
    actualTransportMonitoringTarget.setQueue("Queue");
    String actualToStringResult = actualTransportMonitoringTarget.toString();
    String actualBaseUrl = actualTransportMonitoringTarget.getBaseUrl();
    actualTransportMonitoringTarget.getDevice();

    // Assert that nothing has changed
    assertEquals(
        "TransportMonitoringTarget(baseUrl=https://example.org/example, device=null, queue=Queue, checkDomainIps"
            + "=true)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualBaseUrl);
    assertTrue(actualTransportMonitoringTarget.isCheckDomainIps());
  }
}
