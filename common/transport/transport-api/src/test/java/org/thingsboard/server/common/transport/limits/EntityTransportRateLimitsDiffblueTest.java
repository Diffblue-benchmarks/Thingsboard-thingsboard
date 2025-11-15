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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityTransportRateLimitsDiffblueTest {
  /**
   * Test {@link EntityTransportRateLimits#equals(Object)}, and {@link EntityTransportRateLimits#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTransportRateLimits#equals(Object)}
   *   <li>{@link EntityTransportRateLimits#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTransportRateLimits.equals(Object)", "int EntityTransportRateLimits.hashCode()"})
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
   * Test {@link EntityTransportRateLimits#equals(Object)}, and {@link EntityTransportRateLimits#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTransportRateLimits#equals(Object)}
   *   <li>{@link EntityTransportRateLimits#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTransportRateLimits.equals(Object)", "int EntityTransportRateLimits.hashCode()"})
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
   * Test {@link EntityTransportRateLimits#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTransportRateLimits.equals(Object)", "int EntityTransportRateLimits.hashCode()"})
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
   * Test {@link EntityTransportRateLimits#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTransportRateLimits.equals(Object)", "int EntityTransportRateLimits.hashCode()"})
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
   * Test {@link EntityTransportRateLimits#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTransportRateLimits.equals(Object)", "int EntityTransportRateLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
   * Test {@link EntityTransportRateLimits#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTransportRateLimits.equals(Object)", "int EntityTransportRateLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityTransportRateLimits entityTransportRateLimits = new EntityTransportRateLimits(null, null,
        new DummyTransportRateLimit());
    DummyTransportRateLimit telemetryMsgRateLimit = new DummyTransportRateLimit();

    // Act and Assert
    assertNotEquals(entityTransportRateLimits,
        new EntityTransportRateLimits(null, telemetryMsgRateLimit, new DummyTransportRateLimit()));
  }

  /**
   * Test {@link EntityTransportRateLimits#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTransportRateLimits.equals(Object)", "int EntityTransportRateLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityTransportRateLimits entityTransportRateLimits = new EntityTransportRateLimits(null, null,
        new DummyTransportRateLimit());

    // Act and Assert
    assertNotEquals(entityTransportRateLimits,
        new EntityTransportRateLimits(null, null, new DummyTransportRateLimit()));
  }

  /**
   * Test {@link EntityTransportRateLimits#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTransportRateLimits.equals(Object)", "int EntityTransportRateLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityTransportRateLimits entityTransportRateLimits = new EntityTransportRateLimits(null, null, null);

    // Act and Assert
    assertNotEquals(entityTransportRateLimits,
        new EntityTransportRateLimits(null, null, new DummyTransportRateLimit()));
  }

  /**
   * Test {@link EntityTransportRateLimits#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTransportRateLimits.equals(Object)", "int EntityTransportRateLimits.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DummyTransportRateLimit regularMsgRateLimit = new DummyTransportRateLimit();
    DummyTransportRateLimit telemetryMsgRateLimit = new DummyTransportRateLimit();

    // Act and Assert
    assertNotEquals(
        new EntityTransportRateLimits(regularMsgRateLimit, telemetryMsgRateLimit, new DummyTransportRateLimit()), null);
  }

  /**
   * Test {@link EntityTransportRateLimits#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTransportRateLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTransportRateLimits.equals(Object)", "int EntityTransportRateLimits.hashCode()"})
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTransportRateLimits#EntityTransportRateLimits(TransportRateLimit, TransportRateLimit, TransportRateLimit)}
   *   <li>{@link EntityTransportRateLimits#setRegularMsgRateLimit(TransportRateLimit)}
   *   <li>{@link EntityTransportRateLimits#setTelemetryDataPointsRateLimit(TransportRateLimit)}
   *   <li>{@link EntityTransportRateLimits#setTelemetryMsgRateLimit(TransportRateLimit)}
   *   <li>{@link EntityTransportRateLimits#toString()}
   *   <li>{@link EntityTransportRateLimits#getRegularMsgRateLimit()}
   *   <li>{@link EntityTransportRateLimits#getTelemetryDataPointsRateLimit()}
   *   <li>{@link EntityTransportRateLimits#getTelemetryMsgRateLimit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void EntityTransportRateLimits.<init>(TransportRateLimit, TransportRateLimit, TransportRateLimit)",
      "TransportRateLimit EntityTransportRateLimits.getRegularMsgRateLimit()",
      "TransportRateLimit EntityTransportRateLimits.getTelemetryDataPointsRateLimit()",
      "TransportRateLimit EntityTransportRateLimits.getTelemetryMsgRateLimit()",
      "void EntityTransportRateLimits.setRegularMsgRateLimit(TransportRateLimit)",
      "void EntityTransportRateLimits.setTelemetryDataPointsRateLimit(TransportRateLimit)",
      "void EntityTransportRateLimits.setTelemetryMsgRateLimit(TransportRateLimit)",
      "java.lang.String EntityTransportRateLimits.toString()"})
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

    // Assert
    assertTrue(actualRegularMsgRateLimit instanceof DummyTransportRateLimit);
    assertTrue(actualTelemetryDataPointsRateLimit instanceof DummyTransportRateLimit);
    assertTrue(actualTelemetryMsgRateLimit instanceof DummyTransportRateLimit);
    assertSame(regularMsgRateLimit2, actualRegularMsgRateLimit);
    assertSame(telemetryDataPointsRateLimit, actualTelemetryDataPointsRateLimit);
    assertSame(telemetryMsgRateLimit2, actualTelemetryMsgRateLimit);
  }
}
