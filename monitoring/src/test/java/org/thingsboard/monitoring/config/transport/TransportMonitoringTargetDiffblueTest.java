/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.monitoring.config.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class TransportMonitoringTargetDiffblueTest {
  /**
   * Test {@link TransportMonitoringTarget#getDeviceId()}.
   *
   * <ul>
   *   <li>Given {@link DeviceConfig} (default constructor) Credentials is {@link
   *       DeviceCredentials#DeviceCredentials()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TransportMonitoringTarget#getDeviceId()}
   */
  @Test
  @DisplayName(
      "Test getDeviceId(); given DeviceConfig (default constructor) Credentials is DeviceCredentials(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.UUID TransportMonitoringTarget.getDeviceId()"})
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
   *
   * <ul>
   *   <li>Given {@link TransportMonitoringTarget} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TransportMonitoringTarget#getQueue()}
   */
  @Test
  @DisplayName("Test getQueue(); given TransportMonitoringTarget (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransportMonitoringTarget.getQueue()"})
  void testGetQueue_givenTransportMonitoringTarget() {
    // Arrange, Act and Assert
    assertEquals("Main", new TransportMonitoringTarget().getQueue());
  }

  /**
   * Test {@link TransportMonitoringTarget#getQueue()}.
   *
   * <ul>
   *   <li>Given {@link TransportMonitoringTarget} (default constructor) Queue is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TransportMonitoringTarget#getQueue()}
   */
  @Test
  @DisplayName(
      "Test getQueue(); given TransportMonitoringTarget (default constructor) Queue is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransportMonitoringTarget.getQueue()"})
  void testGetQueue_givenTransportMonitoringTargetQueueIsEmptyString() {
    // Arrange
    TransportMonitoringTarget transportMonitoringTarget = new TransportMonitoringTarget();
    transportMonitoringTarget.setQueue("");

    // Act and Assert
    assertEquals("Main", transportMonitoringTarget.getQueue());
  }

  /**
   * Test {@link TransportMonitoringTarget#getQueue()}.
   *
   * <ul>
   *   <li>Given {@link TransportMonitoringTarget} (default constructor) Queue is {@code Main}.
   * </ul>
   *
   * <p>Method under test: {@link TransportMonitoringTarget#getQueue()}
   */
  @Test
  @DisplayName(
      "Test getQueue(); given TransportMonitoringTarget (default constructor) Queue is 'Main'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransportMonitoringTarget.getQueue()"})
  void testGetQueue_givenTransportMonitoringTargetQueueIsMain() {
    // Arrange
    TransportMonitoringTarget transportMonitoringTarget = new TransportMonitoringTarget();
    transportMonitoringTarget.setQueue("Main");

    // Act and Assert
    assertEquals("Main", transportMonitoringTarget.getQueue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TransportMonitoringTarget.<init>()",
    "String TransportMonitoringTarget.getBaseUrl()",
    "DeviceConfig TransportMonitoringTarget.getDevice()",
    "boolean TransportMonitoringTarget.isCheckDomainIps()",
    "void TransportMonitoringTarget.setBaseUrl(String)",
    "void TransportMonitoringTarget.setCheckDomainIps(boolean)",
    "void TransportMonitoringTarget.setDevice(DeviceConfig)",
    "void TransportMonitoringTarget.setQueue(String)",
    "String TransportMonitoringTarget.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TransportMonitoringTarget actualTransportMonitoringTarget = new TransportMonitoringTarget();
    actualTransportMonitoringTarget.setBaseUrl("https://example.org/example");
    actualTransportMonitoringTarget.setCheckDomainIps(true);
    actualTransportMonitoringTarget.setQueue("Queue");
    String actualToStringResult = actualTransportMonitoringTarget.toString();
    String actualBaseUrl = actualTransportMonitoringTarget.getBaseUrl();
    DeviceConfig actualDevice = actualTransportMonitoringTarget.getDevice();

    // Assert
    assertEquals(
        "TransportMonitoringTarget(baseUrl=https://example.org/example, device=null, queue=Queue, checkDomainIps"
            + "=true)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualBaseUrl);
    assertNull(actualDevice);
    assertTrue(actualTransportMonitoringTarget.isCheckDomainIps());
  }
}
