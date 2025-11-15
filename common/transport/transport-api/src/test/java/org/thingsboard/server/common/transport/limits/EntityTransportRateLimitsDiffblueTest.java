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
package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class EntityTransportRateLimitsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTransportRateLimits#equals(Object)}
   *   <li>{@link EntityTransportRateLimits#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityTransportRateLimits entityTransportRateLimits = new EntityTransportRateLimits(null, null, null);
    EntityTransportRateLimits entityTransportRateLimits2 = new EntityTransportRateLimits(null, null, null);

    // Act and Assert
    assertEquals(entityTransportRateLimits, entityTransportRateLimits2);
    int expectedHashCodeResult = entityTransportRateLimits.hashCode();
    assertEquals(expectedHashCodeResult, entityTransportRateLimits2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTransportRateLimits#equals(Object)}
   *   <li>{@link EntityTransportRateLimits#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DummyTransportRateLimit regularMsgRateLimit = new DummyTransportRateLimit();
    DummyTransportRateLimit telemetryMsgRateLimit = new DummyTransportRateLimit();
    EntityTransportRateLimits entityTransportRateLimits = new EntityTransportRateLimits(regularMsgRateLimit,
        telemetryMsgRateLimit, new DummyTransportRateLimit());

    // Act and Assert
    assertEquals(entityTransportRateLimits, entityTransportRateLimits);
    int expectedHashCodeResult = entityTransportRateLimits.hashCode();
    assertEquals(expectedHashCodeResult, entityTransportRateLimits.hashCode());
  }

  /**
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DummyTransportRateLimit regularMsgRateLimit = new DummyTransportRateLimit();
    DummyTransportRateLimit telemetryMsgRateLimit = new DummyTransportRateLimit();
    EntityTransportRateLimits entityTransportRateLimits = new EntityTransportRateLimits(regularMsgRateLimit,
        telemetryMsgRateLimit, new DummyTransportRateLimit());
    DummyTransportRateLimit regularMsgRateLimit2 = new DummyTransportRateLimit();
    DummyTransportRateLimit telemetryMsgRateLimit2 = new DummyTransportRateLimit();

    // Act and Assert
    assertNotEquals(entityTransportRateLimits,
        new EntityTransportRateLimits(regularMsgRateLimit2, telemetryMsgRateLimit2, new DummyTransportRateLimit()));
  }

  /**
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DummyTransportRateLimit telemetryMsgRateLimit = new DummyTransportRateLimit();
    EntityTransportRateLimits entityTransportRateLimits = new EntityTransportRateLimits(null, telemetryMsgRateLimit,
        new DummyTransportRateLimit());
    DummyTransportRateLimit regularMsgRateLimit = new DummyTransportRateLimit();
    DummyTransportRateLimit telemetryMsgRateLimit2 = new DummyTransportRateLimit();

    // Act and Assert
    assertNotEquals(entityTransportRateLimits,
        new EntityTransportRateLimits(regularMsgRateLimit, telemetryMsgRateLimit2, new DummyTransportRateLimit()));
  }

  /**
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TransportRateLimit regularMsgRateLimit = mock(TransportRateLimit.class);
    DummyTransportRateLimit telemetryMsgRateLimit = new DummyTransportRateLimit();
    EntityTransportRateLimits entityTransportRateLimits = new EntityTransportRateLimits(regularMsgRateLimit,
        telemetryMsgRateLimit, new DummyTransportRateLimit());
    DummyTransportRateLimit regularMsgRateLimit2 = new DummyTransportRateLimit();
    DummyTransportRateLimit telemetryMsgRateLimit2 = new DummyTransportRateLimit();

    // Act and Assert
    assertNotEquals(entityTransportRateLimits,
        new EntityTransportRateLimits(regularMsgRateLimit2, telemetryMsgRateLimit2, new DummyTransportRateLimit()));
  }

  /**
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DummyTransportRateLimit telemetryMsgRateLimit = new DummyTransportRateLimit();
    EntityTransportRateLimits entityTransportRateLimits = new EntityTransportRateLimits(null, telemetryMsgRateLimit,
        new DummyTransportRateLimit());
    DummyTransportRateLimit telemetryMsgRateLimit2 = new DummyTransportRateLimit();

    // Act and Assert
    assertNotEquals(entityTransportRateLimits,
        new EntityTransportRateLimits(null, telemetryMsgRateLimit2, new DummyTransportRateLimit()));
  }

  /**
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityTransportRateLimits entityTransportRateLimits = new EntityTransportRateLimits(null, null,
        new DummyTransportRateLimit());
    DummyTransportRateLimit telemetryMsgRateLimit = new DummyTransportRateLimit();

    // Act and Assert
    assertNotEquals(entityTransportRateLimits,
        new EntityTransportRateLimits(null, telemetryMsgRateLimit, new DummyTransportRateLimit()));
  }

  /**
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityTransportRateLimits entityTransportRateLimits = new EntityTransportRateLimits(null, null,
        new DummyTransportRateLimit());

    // Act and Assert
    assertNotEquals(entityTransportRateLimits,
        new EntityTransportRateLimits(null, null, new DummyTransportRateLimit()));
  }

  /**
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityTransportRateLimits entityTransportRateLimits = new EntityTransportRateLimits(null, null, null);

    // Act and Assert
    assertNotEquals(entityTransportRateLimits,
        new EntityTransportRateLimits(null, null, new DummyTransportRateLimit()));
  }

  /**
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DummyTransportRateLimit regularMsgRateLimit = new DummyTransportRateLimit();
    DummyTransportRateLimit telemetryMsgRateLimit = new DummyTransportRateLimit();

    // Act and Assert
    assertNotEquals(
        new EntityTransportRateLimits(regularMsgRateLimit, telemetryMsgRateLimit, new DummyTransportRateLimit()), null);
  }

  /**
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DummyTransportRateLimit regularMsgRateLimit = new DummyTransportRateLimit();
    DummyTransportRateLimit telemetryMsgRateLimit = new DummyTransportRateLimit();

    // Act and Assert
    assertNotEquals(
        new EntityTransportRateLimits(regularMsgRateLimit, telemetryMsgRateLimit, new DummyTransportRateLimit()),
        "Different type to EntityTransportRateLimits");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityTransportRateLimits#EntityTransportRateLimits(TransportRateLimit, TransportRateLimit, TransportRateLimit)}
   *   <li>
   * {@link EntityTransportRateLimits#setRegularMsgRateLimit(TransportRateLimit)}
   *   <li>
   * {@link EntityTransportRateLimits#setTelemetryDataPointsRateLimit(TransportRateLimit)}
   *   <li>
   * {@link EntityTransportRateLimits#setTelemetryMsgRateLimit(TransportRateLimit)}
   *   <li>{@link EntityTransportRateLimits#toString()}
   *   <li>{@link EntityTransportRateLimits#getRegularMsgRateLimit()}
   *   <li>{@link EntityTransportRateLimits#getTelemetryDataPointsRateLimit()}
   *   <li>{@link EntityTransportRateLimits#getTelemetryMsgRateLimit()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    DummyTransportRateLimit regularMsgRateLimit = new DummyTransportRateLimit();
    DummyTransportRateLimit telemetryMsgRateLimit = new DummyTransportRateLimit();

    // Act
    EntityTransportRateLimits actualEntityTransportRateLimits = new EntityTransportRateLimits(regularMsgRateLimit,
        telemetryMsgRateLimit, new DummyTransportRateLimit());
    DummyTransportRateLimit regularMsgRateLimit2 = new DummyTransportRateLimit();
    actualEntityTransportRateLimits.setRegularMsgRateLimit(regularMsgRateLimit2);
    DummyTransportRateLimit telemetryDataPointsRateLimit = new DummyTransportRateLimit();
    actualEntityTransportRateLimits.setTelemetryDataPointsRateLimit(telemetryDataPointsRateLimit);
    DummyTransportRateLimit telemetryMsgRateLimit2 = new DummyTransportRateLimit();
    actualEntityTransportRateLimits.setTelemetryMsgRateLimit(telemetryMsgRateLimit2);
    actualEntityTransportRateLimits.toString();
    TransportRateLimit actualRegularMsgRateLimit = actualEntityTransportRateLimits.getRegularMsgRateLimit();
    TransportRateLimit actualTelemetryDataPointsRateLimit = actualEntityTransportRateLimits
        .getTelemetryDataPointsRateLimit();
    TransportRateLimit actualTelemetryMsgRateLimit = actualEntityTransportRateLimits.getTelemetryMsgRateLimit();

    // Assert that nothing has changed
    assertTrue(actualRegularMsgRateLimit instanceof DummyTransportRateLimit);
    assertTrue(actualTelemetryDataPointsRateLimit instanceof DummyTransportRateLimit);
    assertTrue(actualTelemetryMsgRateLimit instanceof DummyTransportRateLimit);
    assertSame(regularMsgRateLimit2, actualRegularMsgRateLimit);
    assertSame(telemetryDataPointsRateLimit, actualTelemetryDataPointsRateLimit);
    assertSame(telemetryMsgRateLimit2, actualTelemetryMsgRateLimit);
  }
}
