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
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SessionLimitsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SessionLimits#equals(Object)}
   *   <li>{@link SessionLimits#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    sessionLimits2
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertEquals(sessionLimits, sessionLimits2);
    int expectedHashCodeResult = sessionLimits.hashCode();
    assertEquals(expectedHashCodeResult, sessionLimits2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SessionLimits#equals(Object)}
   *   <li>{@link SessionLimits#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    GatewaySessionLimits gatewaySessionLimits = mock(GatewaySessionLimits.class);
    when(gatewaySessionLimits.getRateLimits())
        .thenReturn(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    when(gatewaySessionLimits.getMaxInflightMessages()).thenReturn(3);
    when(gatewaySessionLimits.getMaxPayloadSize()).thenReturn(3);
    when(gatewaySessionLimits.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(gatewaySessionLimits).setMaxInflightMessages(anyInt());
    doNothing().when(gatewaySessionLimits).setMaxPayloadSize(anyInt());
    doNothing().when(gatewaySessionLimits).setRateLimits(Mockito.<SessionLimits.SessionRateLimits>any());
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertEquals(sessionLimits, gatewaySessionLimits);
    int notExpectedHashCodeResult = sessionLimits.hashCode();
    assertNotEquals(notExpectedHashCodeResult, gatewaySessionLimits.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SessionLimits#equals(Object)}
   *   <li>{@link SessionLimits#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertEquals(sessionLimits, sessionLimits);
    int expectedHashCodeResult = sessionLimits.hashCode();
    assertEquals(expectedHashCodeResult, sessionLimits.hashCode());
  }

  /**
   * Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    gatewaySessionLimits.setGatewayRateLimits(
        new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(gatewaySessionLimits, sessionLimits);
  }

  /**
   * Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(1);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    sessionLimits2
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, sessionLimits2);
  }

  /**
   * Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(1);
    sessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    sessionLimits2
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, sessionLimits2);
  }

  /**
   * Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits(null, "Telemetry Messages", "Telemetry Data Points"));

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    sessionLimits2
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, sessionLimits2);
  }

  /**
   * Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(null);

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    sessionLimits2
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, sessionLimits2);
  }

  /**
   * Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    gatewaySessionLimits.setGatewayRateLimits(
        new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, gatewaySessionLimits);
  }

  /**
   * Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, null);
  }

  /**
   * Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits
        .setRateLimits(new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, "Different type to SessionLimits");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SessionLimits}
   *   <li>{@link SessionLimits#setMaxInflightMessages(int)}
   *   <li>{@link SessionLimits#setMaxPayloadSize(int)}
   *   <li>{@link SessionLimits#setRateLimits(SessionLimits.SessionRateLimits)}
   *   <li>{@link SessionLimits#toString()}
   *   <li>{@link SessionLimits#getMaxInflightMessages()}
   *   <li>{@link SessionLimits#getMaxPayloadSize()}
   *   <li>{@link SessionLimits#getRateLimits()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SessionLimits actualSessionLimits = new SessionLimits();
    actualSessionLimits.setMaxInflightMessages(3);
    actualSessionLimits.setMaxPayloadSize(3);
    SessionLimits.SessionRateLimits rateLimits = new SessionLimits.SessionRateLimits("Messages", "Telemetry Messages",
        "Telemetry Data Points");

    actualSessionLimits.setRateLimits(rateLimits);
    String actualToStringResult = actualSessionLimits.toString();
    int actualMaxInflightMessages = actualSessionLimits.getMaxInflightMessages();
    int actualMaxPayloadSize = actualSessionLimits.getMaxPayloadSize();

    // Assert that nothing has changed
    assertEquals(
        "SessionLimits(maxPayloadSize=3, maxInflightMessages=3, rateLimits=SessionRateLimits[messages=Messages,"
            + " telemetryMessages=Telemetry Messages, telemetryDataPoints=Telemetry Data Points])",
        actualToStringResult);
    assertEquals(3, actualMaxInflightMessages);
    assertEquals(3, actualMaxPayloadSize);
    assertSame(rateLimits, actualSessionLimits.getRateLimits());
  }
}
