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
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.Test;

class TbCoapObservationStateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbCoapObservationState#equals(Object)}
   *   <li>{@link TbCoapObservationState#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbCoapObservationState tbCoapObservationState = new TbCoapObservationState(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        "ABC123");

    // Act and Assert
    assertEquals(tbCoapObservationState, tbCoapObservationState);
    int expectedHashCodeResult = tbCoapObservationState.hashCode();
    assertEquals(expectedHashCodeResult, tbCoapObservationState.hashCode());
  }

  /**
   * Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbCoapObservationState tbCoapObservationState = new TbCoapObservationState(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        "ABC123");

    // Act and Assert
    assertNotEquals(tbCoapObservationState,
        new TbCoapObservationState(
            new CoapExchange(
                new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
            "ABC123"));
  }

  /**
   * Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbCoapObservationState tbCoapObservationState = new TbCoapObservationState(null, "ABC123");

    // Act and Assert
    assertNotEquals(tbCoapObservationState,
        new TbCoapObservationState(
            new CoapExchange(
                new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
            "ABC123"));
  }

  /**
   * Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbCoapObservationState tbCoapObservationState = new TbCoapObservationState(null, "ABC123");

    // Act and Assert
    assertNotEquals(tbCoapObservationState, new TbCoapObservationState(null, "ABC123"));
  }

  /**
   * Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbCoapObservationState tbCoapObservationState = new TbCoapObservationState(null, "Token");

    // Act and Assert
    assertNotEquals(tbCoapObservationState, new TbCoapObservationState(null, "ABC123"));
  }

  /**
   * Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbCoapObservationState tbCoapObservationState = new TbCoapObservationState(null, null);

    // Act and Assert
    assertNotEquals(tbCoapObservationState, new TbCoapObservationState(null, "ABC123"));
  }

  /**
   * Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbCoapObservationState tbCoapObservationState = new TbCoapObservationState(null, null);

    // Act and Assert
    assertNotEquals(tbCoapObservationState, new TbCoapObservationState(null, null));
  }

  /**
   * Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCoapObservationState(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        "ABC123"), null);
  }

  /**
   * Method under test: {@link TbCoapObservationState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCoapObservationState(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        "ABC123"), "Different type to TbCoapObservationState");
  }

  /**
   * Method under test:
   * {@link TbCoapObservationState#TbCoapObservationState(CoapExchange, String)}
   */
  @Test
  void testNewTbCoapObservationState() {
    // Arrange
    CoapExchange exchange = new CoapExchange(
        new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class)));

    // Act
    TbCoapObservationState actualTbCoapObservationState = new TbCoapObservationState(exchange, "ABC123");

    // Assert
    assertEquals("ABC123", actualTbCoapObservationState.getToken());
    assertNull(actualTbCoapObservationState.getObserveRelation());
    assertSame(exchange, actualTbCoapObservationState.getExchange());
  }
}
