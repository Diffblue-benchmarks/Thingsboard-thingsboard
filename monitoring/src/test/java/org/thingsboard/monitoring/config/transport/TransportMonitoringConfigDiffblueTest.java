package org.thingsboard.monitoring.config.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class TransportMonitoringConfigDiffblueTest {
  /**
   * Test {@link TransportMonitoringConfig#canEqual(Object)}.
   * <ul>
   *   <li>When {@link CoapTransportMonitoringConfig} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when CoapTransportMonitoringConfig (default constructor); then return 'true'")
  void testCanEqual_whenCoapTransportMonitoringConfig_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();

    // Act and Assert
    assertTrue(coapTransportMonitoringConfig.canEqual(new CoapTransportMonitoringConfig()));
  }

  /**
   * Test {@link TransportMonitoringConfig#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  void testCanEqual_whenOther_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CoapTransportMonitoringConfig()).canEqual("Other"));
  }

  /**
   * Test {@link TransportMonitoringConfig#equals(Object)}, and
   * {@link TransportMonitoringConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportMonitoringConfig#equals(Object)}
   *   <li>{@link TransportMonitoringConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();
    CoapTransportMonitoringConfig coapTransportMonitoringConfig2 = new CoapTransportMonitoringConfig();

    // Act and Assert
    assertEquals(coapTransportMonitoringConfig, coapTransportMonitoringConfig2);
    int expectedHashCodeResult = coapTransportMonitoringConfig.hashCode();
    assertEquals(expectedHashCodeResult, coapTransportMonitoringConfig2.hashCode());
  }

  /**
   * Test {@link TransportMonitoringConfig#equals(Object)}, and
   * {@link TransportMonitoringConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportMonitoringConfig#equals(Object)}
   *   <li>{@link TransportMonitoringConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();
    coapTransportMonitoringConfig.setTargets(new ArrayList<>());

    CoapTransportMonitoringConfig coapTransportMonitoringConfig2 = new CoapTransportMonitoringConfig();
    coapTransportMonitoringConfig2.setTargets(new ArrayList<>());

    // Act and Assert
    assertEquals(coapTransportMonitoringConfig, coapTransportMonitoringConfig2);
    int expectedHashCodeResult = coapTransportMonitoringConfig.hashCode();
    assertEquals(expectedHashCodeResult, coapTransportMonitoringConfig2.hashCode());
  }

  /**
   * Test {@link TransportMonitoringConfig#equals(Object)}, and
   * {@link TransportMonitoringConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportMonitoringConfig#equals(Object)}
   *   <li>{@link TransportMonitoringConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();

    // Act and Assert
    assertEquals(coapTransportMonitoringConfig, coapTransportMonitoringConfig);
    int expectedHashCodeResult = coapTransportMonitoringConfig.hashCode();
    assertEquals(expectedHashCodeResult, coapTransportMonitoringConfig.hashCode());
  }

  /**
   * Test {@link TransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CoapTransportMonitoringConfig(), 1);
  }

  /**
   * Test {@link TransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();

    // Act and Assert
    assertNotEquals(coapTransportMonitoringConfig, new MqttTransportMonitoringConfig());
  }

  /**
   * Test {@link TransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();
    coapTransportMonitoringConfig.setTargets(new ArrayList<>());

    // Act and Assert
    assertNotEquals(coapTransportMonitoringConfig, new CoapTransportMonitoringConfig());
  }

  /**
   * Test {@link TransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();
    coapTransportMonitoringConfig.setRequestTimeoutMs(10);

    // Act and Assert
    assertNotEquals(coapTransportMonitoringConfig, new CoapTransportMonitoringConfig());
  }

  /**
   * Test {@link TransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();

    CoapTransportMonitoringConfig coapTransportMonitoringConfig2 = new CoapTransportMonitoringConfig();
    coapTransportMonitoringConfig2.setTargets(new ArrayList<>());

    // Act and Assert
    assertNotEquals(coapTransportMonitoringConfig, coapTransportMonitoringConfig2);
  }

  /**
   * Test {@link TransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceConfig device = mock(DeviceConfig.class);
    doNothing().when(device).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(device).setId(Mockito.<String>any());
    doNothing().when(device).setName(Mockito.<String>any());
    device.setCredentials(new DeviceCredentials());
    device.setId("42");
    device.setName("Name");
    TransportMonitoringTarget transportMonitoringTarget = mock(TransportMonitoringTarget.class);
    doNothing().when(transportMonitoringTarget).setDevice(Mockito.<DeviceConfig>any());
    doNothing().when(transportMonitoringTarget).setQueue(Mockito.<String>any());
    doNothing().when(transportMonitoringTarget).setBaseUrl(Mockito.<String>any());
    doNothing().when(transportMonitoringTarget).setCheckDomainIps(anyBoolean());
    transportMonitoringTarget.setBaseUrl("https://example.org/example");
    transportMonitoringTarget.setCheckDomainIps(true);
    transportMonitoringTarget.setDevice(device);
    transportMonitoringTarget.setQueue("Queue");

    ArrayList<TransportMonitoringTarget> targets = new ArrayList<>();
    targets.add(transportMonitoringTarget);

    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();
    coapTransportMonitoringConfig.setTargets(targets);

    // Act and Assert
    assertNotEquals(coapTransportMonitoringConfig, new CoapTransportMonitoringConfig());
  }

  /**
   * Test {@link TransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CoapTransportMonitoringConfig(), null);
  }

  /**
   * Test {@link TransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CoapTransportMonitoringConfig(), "Different type to TransportMonitoringConfig");
  }

  /**
   * Test {@link TransportMonitoringConfig#getRequestTimeoutMs()}.
   * <p>
   * Method under test: {@link TransportMonitoringConfig#getRequestTimeoutMs()}
   */
  @Test
  @DisplayName("Test getRequestTimeoutMs()")
  void testGetRequestTimeoutMs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new CoapTransportMonitoringConfig()).getRequestTimeoutMs());
  }

  /**
   * Test {@link TransportMonitoringConfig#getTargets()}.
   * <p>
   * Method under test: {@link TransportMonitoringConfig#getTargets()}
   */
  @Test
  @DisplayName("Test getTargets()")
  void testGetTargets() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CoapTransportMonitoringConfig()).getTargets());
  }

  /**
   * Test {@link TransportMonitoringConfig#setRequestTimeoutMs(int)}.
   * <p>
   * Method under test: {@link TransportMonitoringConfig#setRequestTimeoutMs(int)}
   */
  @Test
  @DisplayName("Test setRequestTimeoutMs(int)")
  void testSetRequestTimeoutMs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();

    // Act
    coapTransportMonitoringConfig.setRequestTimeoutMs(10);

    // Assert
    assertEquals(10, coapTransportMonitoringConfig.getRequestTimeoutMs());
  }

  /**
   * Test {@link TransportMonitoringConfig#setTargets(List)}.
   * <p>
   * Method under test: {@link TransportMonitoringConfig#setTargets(List)}
   */
  @Test
  @DisplayName("Test setTargets(List)")
  void testSetTargets() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();

    DeviceConfig device = new DeviceConfig();
    device.setCredentials(new DeviceCredentials());
    device.setId("");
    device.setName("Name");

    TransportMonitoringTarget transportMonitoringTarget = new TransportMonitoringTarget();
    transportMonitoringTarget.setBaseUrl("https://example.org/example");
    transportMonitoringTarget.setCheckDomainIps(true);
    transportMonitoringTarget.setDevice(device);
    transportMonitoringTarget.setQueue("Queue");

    DeviceConfig device2 = new DeviceConfig();
    device2.setCredentials(new DeviceCredentials());
    device2.setId("");
    device2.setName("org.thingsboard.monitoring.config.transport.DeviceConfig");

    TransportMonitoringTarget transportMonitoringTarget2 = new TransportMonitoringTarget();
    transportMonitoringTarget2.setBaseUrl("Base Url");
    transportMonitoringTarget2.setCheckDomainIps(false);
    transportMonitoringTarget2.setDevice(device2);
    transportMonitoringTarget2.setQueue("org.thingsboard.monitoring.config.transport.TransportMonitoringTarget");

    ArrayList<TransportMonitoringTarget> targets = new ArrayList<>();
    targets.add(transportMonitoringTarget2);
    targets.add(transportMonitoringTarget);

    // Act
    coapTransportMonitoringConfig.setTargets(targets);

    // Assert
    assertSame(targets, coapTransportMonitoringConfig.getTargets());
  }

  /**
   * Test {@link TransportMonitoringConfig#setTargets(List)}.
   * <ul>
   *   <li>Given {@link TransportMonitoringTarget} (default constructor) BaseUrl is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringConfig#setTargets(List)}
   */
  @Test
  @DisplayName("Test setTargets(List); given TransportMonitoringTarget (default constructor) BaseUrl is 'https://example.org/example'")
  void testSetTargets_givenTransportMonitoringTargetBaseUrlIsHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();

    DeviceConfig device = new DeviceConfig();
    device.setCredentials(new DeviceCredentials());
    device.setId("");
    device.setName("Name");

    TransportMonitoringTarget transportMonitoringTarget = new TransportMonitoringTarget();
    transportMonitoringTarget.setBaseUrl("https://example.org/example");
    transportMonitoringTarget.setCheckDomainIps(true);
    transportMonitoringTarget.setDevice(device);
    transportMonitoringTarget.setQueue("Queue");

    ArrayList<TransportMonitoringTarget> targets = new ArrayList<>();
    targets.add(transportMonitoringTarget);

    // Act
    coapTransportMonitoringConfig.setTargets(targets);

    // Assert
    assertSame(targets, coapTransportMonitoringConfig.getTargets());
  }

  /**
   * Test {@link TransportMonitoringConfig#setTargets(List)}.
   * <ul>
   *   <li>Then calls {@link TransportMonitoringTarget#setBaseUrl(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringConfig#setTargets(List)}
   */
  @Test
  @DisplayName("Test setTargets(List); then calls setBaseUrl(String)")
  void testSetTargets_thenCallsSetBaseUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();

    DeviceConfig device = new DeviceConfig();
    device.setCredentials(new DeviceCredentials());
    device.setId("");
    device.setName("Name");
    TransportMonitoringTarget transportMonitoringTarget = mock(TransportMonitoringTarget.class);
    doNothing().when(transportMonitoringTarget).setBaseUrl(Mockito.<String>any());
    doNothing().when(transportMonitoringTarget).setCheckDomainIps(anyBoolean());
    doNothing().when(transportMonitoringTarget).setDevice(Mockito.<DeviceConfig>any());
    doNothing().when(transportMonitoringTarget).setQueue(Mockito.<String>any());
    transportMonitoringTarget.setBaseUrl("https://example.org/example");
    transportMonitoringTarget.setCheckDomainIps(true);
    transportMonitoringTarget.setDevice(device);
    transportMonitoringTarget.setQueue("Queue");

    ArrayList<TransportMonitoringTarget> targets = new ArrayList<>();
    targets.add(transportMonitoringTarget);

    // Act
    coapTransportMonitoringConfig.setTargets(targets);

    // Assert
    verify(transportMonitoringTarget).setBaseUrl(eq("https://example.org/example"));
    verify(transportMonitoringTarget).setCheckDomainIps(eq(true));
    verify(transportMonitoringTarget).setDevice(isA(DeviceConfig.class));
    verify(transportMonitoringTarget).setQueue(eq("Queue"));
    assertSame(targets, coapTransportMonitoringConfig.getTargets());
  }

  /**
   * Test {@link TransportMonitoringConfig#setTargets(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportMonitoringConfig#setTargets(List)}
   */
  @Test
  @DisplayName("Test setTargets(List); when ArrayList()")
  void testSetTargets_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CoapTransportMonitoringConfig coapTransportMonitoringConfig = new CoapTransportMonitoringConfig();
    ArrayList<TransportMonitoringTarget> targets = new ArrayList<>();

    // Act
    coapTransportMonitoringConfig.setTargets(targets);

    // Assert
    assertSame(targets, coapTransportMonitoringConfig.getTargets());
  }

  /**
   * Test {@link TransportMonitoringConfig#toString()}.
   * <p>
   * Method under test: {@link TransportMonitoringConfig#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("TransportMonitoringConfig(targets=null, requestTimeoutMs=0)",
        (new CoapTransportMonitoringConfig()).toString());
  }
}
