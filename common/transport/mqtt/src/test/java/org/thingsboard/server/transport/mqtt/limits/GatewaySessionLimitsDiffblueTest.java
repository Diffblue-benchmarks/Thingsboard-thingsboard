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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.mqtt.limits.SessionLimits.SessionRateLimits;

class GatewaySessionLimitsDiffblueTest {
  /**
   * Test {@link GatewaySessionLimits#equals(Object)}, and {@link GatewaySessionLimits#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GatewaySessionLimits#equals(Object)}
   *   <li>{@link GatewaySessionLimits#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GatewaySessionLimits.equals(Object)",
    "int GatewaySessionLimits.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    SessionRateLimits gatewayRateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits.setGatewayRateLimits(gatewayRateLimits);
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits.setRateLimits(rateLimits);

    GatewaySessionLimits gatewaySessionLimits2 = new GatewaySessionLimits();
    SessionRateLimits gatewayRateLimits2 =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits2.setGatewayRateLimits(gatewayRateLimits2);
    gatewaySessionLimits2.setMaxInflightMessages(3);
    gatewaySessionLimits2.setMaxPayloadSize(3);
    SessionRateLimits rateLimits2 =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits2.setRateLimits(rateLimits2);

    // Act and Assert
    assertEquals(gatewaySessionLimits, gatewaySessionLimits2);
    assertEquals(gatewaySessionLimits.hashCode(), gatewaySessionLimits2.hashCode());
  }

  /**
   * Test {@link GatewaySessionLimits#equals(Object)}, and {@link GatewaySessionLimits#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GatewaySessionLimits#equals(Object)}
   *   <li>{@link GatewaySessionLimits#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GatewaySessionLimits.equals(Object)",
    "int GatewaySessionLimits.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    gatewaySessionLimits.setGatewayRateLimits(null);
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits.setRateLimits(rateLimits);

    GatewaySessionLimits gatewaySessionLimits2 = new GatewaySessionLimits();
    gatewaySessionLimits2.setGatewayRateLimits(null);
    gatewaySessionLimits2.setMaxInflightMessages(3);
    gatewaySessionLimits2.setMaxPayloadSize(3);
    SessionRateLimits rateLimits2 =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits2.setRateLimits(rateLimits2);

    // Act and Assert
    assertEquals(gatewaySessionLimits, gatewaySessionLimits2);
    assertEquals(gatewaySessionLimits.hashCode(), gatewaySessionLimits2.hashCode());
  }

  /**
   * Test {@link GatewaySessionLimits#equals(Object)}, and {@link GatewaySessionLimits#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GatewaySessionLimits#equals(Object)}
   *   <li>{@link GatewaySessionLimits#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GatewaySessionLimits.equals(Object)",
    "int GatewaySessionLimits.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    SessionRateLimits gatewayRateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits.setGatewayRateLimits(gatewayRateLimits);
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits.setRateLimits(rateLimits);

    // Act and Assert
    assertEquals(gatewaySessionLimits, gatewaySessionLimits);
    int expectedHashCodeResult = gatewaySessionLimits.hashCode();
    assertEquals(expectedHashCodeResult, gatewaySessionLimits.hashCode());
  }

  /**
   * Test {@link GatewaySessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GatewaySessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GatewaySessionLimits.equals(Object)",
    "int GatewaySessionLimits.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    gatewaySessionLimits.setGatewayRateLimits(null);
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits.setRateLimits(rateLimits);

    GatewaySessionLimits gatewaySessionLimits2 = new GatewaySessionLimits();
    SessionRateLimits gatewayRateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits2.setGatewayRateLimits(gatewayRateLimits);
    gatewaySessionLimits2.setMaxInflightMessages(3);
    gatewaySessionLimits2.setMaxPayloadSize(3);
    SessionRateLimits rateLimits2 =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits2.setRateLimits(rateLimits2);

    // Act and Assert
    assertNotEquals(gatewaySessionLimits, gatewaySessionLimits2);
  }

  /**
   * Test {@link GatewaySessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GatewaySessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GatewaySessionLimits.equals(Object)",
    "int GatewaySessionLimits.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    SessionRateLimits gatewayRateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits.setGatewayRateLimits(gatewayRateLimits);
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits.setRateLimits(rateLimits);

    GatewaySessionLimits gatewaySessionLimits2 = new GatewaySessionLimits();
    gatewaySessionLimits2.setGatewayRateLimits(null);
    gatewaySessionLimits2.setMaxInflightMessages(3);
    gatewaySessionLimits2.setMaxPayloadSize(3);
    SessionRateLimits rateLimits2 =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits2.setRateLimits(rateLimits2);

    // Act and Assert
    assertNotEquals(gatewaySessionLimits, gatewaySessionLimits2);
  }

  /**
   * Test {@link GatewaySessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GatewaySessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GatewaySessionLimits.equals(Object)",
    "int GatewaySessionLimits.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    SessionRateLimits gatewayRateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits.setGatewayRateLimits(gatewayRateLimits);
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits.setRateLimits(rateLimits);

    // Act and Assert
    assertNotEquals(gatewaySessionLimits, null);
  }

  /**
   * Test {@link GatewaySessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GatewaySessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GatewaySessionLimits.equals(Object)",
    "int GatewaySessionLimits.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    SessionRateLimits gatewayRateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits.setGatewayRateLimits(gatewayRateLimits);
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    gatewaySessionLimits.setRateLimits(rateLimits);

    // Act and Assert
    assertNotEquals(gatewaySessionLimits, "Different type to GatewaySessionLimits");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GatewaySessionLimits}
   *   <li>{@link GatewaySessionLimits#setGatewayRateLimits(SessionRateLimits)}
   *   <li>{@link GatewaySessionLimits#toString()}
   *   <li>{@link GatewaySessionLimits#getGatewayRateLimits()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GatewaySessionLimits.<init>()",
    "SessionRateLimits GatewaySessionLimits.getGatewayRateLimits()",
    "void GatewaySessionLimits.setGatewayRateLimits(SessionRateLimits)",
    "String GatewaySessionLimits.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GatewaySessionLimits actualGatewaySessionLimits = new GatewaySessionLimits();
    SessionRateLimits gatewayRateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    actualGatewaySessionLimits.setGatewayRateLimits(gatewayRateLimits);
    String actualToStringResult = actualGatewaySessionLimits.toString();
    SessionRateLimits actualGatewayRateLimits = actualGatewaySessionLimits.getGatewayRateLimits();

    // Assert
    assertEquals(
        "GatewaySessionLimits(gatewayRateLimits=SessionRateLimits[messages=Messages, telemetryMessages=Telemetry"
            + " Messages, telemetryDataPoints=Telemetry Data Points])",
        actualToStringResult);
    assertNull(actualGatewaySessionLimits.getRateLimits());
    assertEquals(0, actualGatewaySessionLimits.getMaxInflightMessages());
    assertEquals(0, actualGatewaySessionLimits.getMaxPayloadSize());
    assertSame(gatewayRateLimits, actualGatewayRateLimits);
  }
}
