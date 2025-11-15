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
package org.thingsboard.server.transport.mqtt.limits;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class GatewaySessionLimitsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GatewaySessionLimits#equals(Object)}
   *   <li>{@link GatewaySessionLimits#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    gatewaySessionLimits.setGatewayRateLimits(
        new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    GatewaySessionLimits gatewaySessionLimits2 = new GatewaySessionLimits();
    gatewaySessionLimits2.setGatewayRateLimits(
        new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits2.setMaxInflightMessages(3);
    gatewaySessionLimits2.setMaxPayloadSize(3);
    gatewaySessionLimits2
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertEquals(gatewaySessionLimits, gatewaySessionLimits2);
    int expectedHashCodeResult = gatewaySessionLimits.hashCode();
    assertEquals(expectedHashCodeResult, gatewaySessionLimits2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GatewaySessionLimits#equals(Object)}
   *   <li>{@link GatewaySessionLimits#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    gatewaySessionLimits.setGatewayRateLimits(null);
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    GatewaySessionLimits gatewaySessionLimits2 = new GatewaySessionLimits();
    gatewaySessionLimits2.setGatewayRateLimits(null);
    gatewaySessionLimits2.setMaxInflightMessages(3);
    gatewaySessionLimits2.setMaxPayloadSize(3);
    gatewaySessionLimits2
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertEquals(gatewaySessionLimits, gatewaySessionLimits2);
    int expectedHashCodeResult = gatewaySessionLimits.hashCode();
    assertEquals(expectedHashCodeResult, gatewaySessionLimits2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GatewaySessionLimits#equals(Object)}
   *   <li>{@link GatewaySessionLimits#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    gatewaySessionLimits.setGatewayRateLimits(
        new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertEquals(gatewaySessionLimits, gatewaySessionLimits);
    int expectedHashCodeResult = gatewaySessionLimits.hashCode();
    assertEquals(expectedHashCodeResult, gatewaySessionLimits.hashCode());
  }

  /**
   * Method under test: {@link GatewaySessionLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    gatewaySessionLimits
        .setGatewayRateLimits(new SessionLimits.SessionRateLimits(null, "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    GatewaySessionLimits gatewaySessionLimits2 = new GatewaySessionLimits();
    gatewaySessionLimits2.setGatewayRateLimits(
        new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits2.setMaxInflightMessages(3);
    gatewaySessionLimits2.setMaxPayloadSize(3);
    gatewaySessionLimits2
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(gatewaySessionLimits, gatewaySessionLimits2);
  }

  /**
   * Method under test: {@link GatewaySessionLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    gatewaySessionLimits.setGatewayRateLimits(null);
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    GatewaySessionLimits gatewaySessionLimits2 = new GatewaySessionLimits();
    gatewaySessionLimits2.setGatewayRateLimits(
        new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits2.setMaxInflightMessages(3);
    gatewaySessionLimits2.setMaxPayloadSize(3);
    gatewaySessionLimits2
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(gatewaySessionLimits, gatewaySessionLimits2);
  }

  /**
   * Method under test: {@link GatewaySessionLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    gatewaySessionLimits.setGatewayRateLimits(
        new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(gatewaySessionLimits, null);
  }

  /**
   * Method under test: {@link GatewaySessionLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    gatewaySessionLimits.setGatewayRateLimits(
        new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(gatewaySessionLimits, "Different type to GatewaySessionLimits");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GatewaySessionLimits}
   *   <li>
   * {@link GatewaySessionLimits#setGatewayRateLimits(SessionLimits.SessionRateLimits)}
   *   <li>{@link GatewaySessionLimits#toString()}
   *   <li>{@link GatewaySessionLimits#getGatewayRateLimits()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GatewaySessionLimits actualGatewaySessionLimits = new GatewaySessionLimits();
    SessionLimits.SessionRateLimits gatewayRateLimits = new SessionLimits.SessionRateLimits("Messages",
        "Telemetry Messages", "Telemetry Data Points");

    actualGatewaySessionLimits.setGatewayRateLimits(gatewayRateLimits);
    String actualToStringResult = actualGatewaySessionLimits.toString();
    SessionLimits.SessionRateLimits actualGatewayRateLimits = actualGatewaySessionLimits.getGatewayRateLimits();

    // Assert that nothing has changed
    assertEquals(
        "GatewaySessionLimits(gatewayRateLimits=SessionRateLimits[messages=Messages, telemetryMessages=Telemetry"
            + " Messages, telemetryDataPoints=Telemetry Data Points])",
        actualToStringResult);
    assertEquals(0, actualGatewaySessionLimits.getMaxInflightMessages());
    assertEquals(0, actualGatewaySessionLimits.getMaxPayloadSize());
    assertSame(gatewayRateLimits, actualGatewayRateLimits);
  }
}
