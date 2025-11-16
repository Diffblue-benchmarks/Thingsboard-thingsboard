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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.mqtt.limits.SessionLimits.SessionRateLimits;

class SessionLimitsDiffblueTest {
  /**
   * Test {@link SessionLimits#equals(Object)}, and {@link SessionLimits#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionLimits#equals(Object)}
   *   <li>{@link SessionLimits#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    sessionLimits.setRateLimits(rateLimits);

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    SessionRateLimits rateLimits2 =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    sessionLimits2.setRateLimits(rateLimits2);

    // Act and Assert
    assertEquals(sessionLimits, sessionLimits2);
    assertEquals(sessionLimits.hashCode(), sessionLimits2.hashCode());
  }

  /**
   * Test {@link SessionLimits#equals(Object)}, and {@link SessionLimits#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionLimits#equals(Object)}
   *   <li>{@link SessionLimits#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(null);

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    sessionLimits2.setRateLimits(null);

    // Act and Assert
    assertEquals(sessionLimits, sessionLimits2);
    assertEquals(sessionLimits.hashCode(), sessionLimits2.hashCode());
  }

  /**
   * Test {@link SessionLimits#equals(Object)}, and {@link SessionLimits#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionLimits#equals(Object)}
   *   <li>{@link SessionLimits#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    sessionLimits.setRateLimits(rateLimits);

    // Act and Assert
    assertEquals(sessionLimits, sessionLimits);
    int expectedHashCodeResult = sessionLimits.hashCode();
    assertEquals(expectedHashCodeResult, sessionLimits.hashCode());
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(1);
    sessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    sessionLimits.setRateLimits(rateLimits);

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    SessionRateLimits rateLimits2 =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    sessionLimits2.setRateLimits(rateLimits2);

    // Act and Assert
    assertNotEquals(sessionLimits, sessionLimits2);
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(1);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    sessionLimits.setRateLimits(rateLimits);

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    SessionRateLimits rateLimits2 =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    sessionLimits2.setRateLimits(rateLimits2);

    // Act and Assert
    assertNotEquals(sessionLimits, sessionLimits2);
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(null);

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    sessionLimits2.setRateLimits(rateLimits);

    // Act and Assert
    assertNotEquals(sessionLimits, sessionLimits2);
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    sessionLimits.setRateLimits(rateLimits);

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    sessionLimits2.setRateLimits(null);

    // Act and Assert
    assertNotEquals(sessionLimits, sessionLimits2);
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    sessionLimits.setRateLimits(rateLimits);

    // Act and Assert
    assertNotEquals(sessionLimits, null);
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    sessionLimits.setRateLimits(rateLimits);

    // Act and Assert
    assertNotEquals(sessionLimits, "Different type to SessionLimits");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SessionLimits}
   *   <li>{@link SessionLimits#setMaxInflightMessages(int)}
   *   <li>{@link SessionLimits#setMaxPayloadSize(int)}
   *   <li>{@link SessionLimits#setRateLimits(SessionRateLimits)}
   *   <li>{@link SessionLimits#toString()}
   *   <li>{@link SessionLimits#getMaxInflightMessages()}
   *   <li>{@link SessionLimits#getMaxPayloadSize()}
   *   <li>{@link SessionLimits#getRateLimits()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SessionLimits.<init>()",
    "int SessionLimits.getMaxInflightMessages()",
    "int SessionLimits.getMaxPayloadSize()",
    "SessionRateLimits SessionLimits.getRateLimits()",
    "void SessionLimits.setMaxInflightMessages(int)",
    "void SessionLimits.setMaxPayloadSize(int)",
    "void SessionLimits.setRateLimits(SessionRateLimits)",
    "String SessionLimits.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SessionLimits actualSessionLimits = new SessionLimits();
    actualSessionLimits.setMaxInflightMessages(3);
    actualSessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");
    actualSessionLimits.setRateLimits(rateLimits);
    String actualToStringResult = actualSessionLimits.toString();
    int actualMaxInflightMessages = actualSessionLimits.getMaxInflightMessages();
    int actualMaxPayloadSize = actualSessionLimits.getMaxPayloadSize();

    // Assert
    assertEquals(
        "SessionLimits(maxPayloadSize=3, maxInflightMessages=3, rateLimits=SessionRateLimits[messages=Messages,"
            + " telemetryMessages=Telemetry Messages, telemetryDataPoints=Telemetry Data Points])",
        actualToStringResult);
    assertEquals(3, actualMaxInflightMessages);
    assertEquals(3, actualMaxPayloadSize);
    assertSame(rateLimits, actualSessionLimits.getRateLimits());
  }
}
