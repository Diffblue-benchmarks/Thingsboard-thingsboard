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
package org.thingsboard.server.transport.coap.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbCoapObservationStateDiffblueTest {
  /**
   * Test {@link TbCoapObservationState#equals(Object)}, and {@link
   * TbCoapObservationState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCoapObservationState#equals(Object)}
   *   <li>{@link TbCoapObservationState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapObservationState.equals(Object)",
    "int TbCoapObservationState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    TbCoapObservationState tbCoapObservationState =
        new TbCoapObservationState(new CoapExchange(exchange), "ABC123");

    // Act and Assert
    assertEquals(tbCoapObservationState, tbCoapObservationState);
    int expectedHashCodeResult = tbCoapObservationState.hashCode();
    assertEquals(expectedHashCodeResult, tbCoapObservationState.hashCode());
  }

  /**
   * Test {@link TbCoapObservationState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapObservationState.equals(Object)",
    "int TbCoapObservationState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    TbCoapObservationState tbCoapObservationState =
        new TbCoapObservationState(new CoapExchange(exchange), "ABC123");
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertNotEquals(
        tbCoapObservationState, new TbCoapObservationState(new CoapExchange(exchange2), "ABC123"));
  }

  /**
   * Test {@link TbCoapObservationState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapObservationState.equals(Object)",
    "int TbCoapObservationState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbCoapObservationState tbCoapObservationState = new TbCoapObservationState(null, "ABC123");
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertNotEquals(
        tbCoapObservationState, new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
  }

  /**
   * Test {@link TbCoapObservationState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapObservationState.equals(Object)",
    "int TbCoapObservationState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbCoapObservationState tbCoapObservationState = new TbCoapObservationState(null, "ABC123");

    // Act and Assert
    assertNotEquals(tbCoapObservationState, new TbCoapObservationState(null, "ABC123"));
  }

  /**
   * Test {@link TbCoapObservationState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapObservationState.equals(Object)",
    "int TbCoapObservationState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbCoapObservationState tbCoapObservationState = new TbCoapObservationState(null, "Token");

    // Act and Assert
    assertNotEquals(tbCoapObservationState, new TbCoapObservationState(null, "ABC123"));
  }

  /**
   * Test {@link TbCoapObservationState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapObservationState.equals(Object)",
    "int TbCoapObservationState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbCoapObservationState tbCoapObservationState = new TbCoapObservationState(null, null);

    // Act and Assert
    assertNotEquals(tbCoapObservationState, new TbCoapObservationState(null, "ABC123"));
  }

  /**
   * Test {@link TbCoapObservationState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapObservationState.equals(Object)",
    "int TbCoapObservationState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbCoapObservationState tbCoapObservationState = new TbCoapObservationState(null, null);
    TbCoapObservationState tbCoapObservationState2 = new TbCoapObservationState(null, null);

    // Act and Assert
    assertNotEquals(tbCoapObservationState, tbCoapObservationState2);
  }

  /**
   * Test {@link TbCoapObservationState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapObservationState.equals(Object)",
    "int TbCoapObservationState.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertNotEquals(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"), null);
  }

  /**
   * Test {@link TbCoapObservationState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapObservationState.equals(Object)",
    "int TbCoapObservationState.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertNotEquals(
        new TbCoapObservationState(new CoapExchange(exchange), "ABC123"),
        "Different type to TbCoapObservationState");
  }

  /**
   * Test {@link TbCoapObservationState#TbCoapObservationState(CoapExchange, String)}.
   *
   * <p>Method under test: {@link TbCoapObservationState#TbCoapObservationState(CoapExchange,
   * String)}
   */
  @Test
  @DisplayName("Test new TbCoapObservationState(CoapExchange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCoapObservationState.<init>(CoapExchange, String)"})
  void testNewTbCoapObservationState() {
    // Arrange
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange2 = new CoapExchange(exchange);

    // Act
    TbCoapObservationState actualTbCoapObservationState =
        new TbCoapObservationState(exchange2, "ABC123");

    // Assert
    assertEquals("ABC123", actualTbCoapObservationState.getToken());
    assertNull(actualTbCoapObservationState.getObserveRelation());
    assertEquals(0, actualTbCoapObservationState.getObserveCounter().get());
    assertSame(exchange2, actualTbCoapObservationState.getExchange());
  }
}
