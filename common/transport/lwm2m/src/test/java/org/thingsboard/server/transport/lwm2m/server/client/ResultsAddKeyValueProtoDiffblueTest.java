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
package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;

class ResultsAddKeyValueProtoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResultsAddKeyValueProto#equals(Object)}
   *   <li>{@link ResultsAddKeyValueProto#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto.setResultTelemetries(new ArrayList<>());

    ResultsAddKeyValueProto resultsAddKeyValueProto2 = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto2.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto2.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertEquals(resultsAddKeyValueProto, resultsAddKeyValueProto2);
    int expectedHashCodeResult = resultsAddKeyValueProto.hashCode();
    assertEquals(expectedHashCodeResult, resultsAddKeyValueProto2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResultsAddKeyValueProto#equals(Object)}
   *   <li>{@link ResultsAddKeyValueProto#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertEquals(resultsAddKeyValueProto, resultsAddKeyValueProto);
    int expectedHashCodeResult = resultsAddKeyValueProto.hashCode();
    assertEquals(expectedHashCodeResult, resultsAddKeyValueProto.hashCode());
  }

  /**
   * Method under test: {@link ResultsAddKeyValueProto#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<TransportProtos.KeyValueProto> resultAttributes = new ArrayList<>();
    resultAttributes.add(TransportProtos.KeyValueProto.getDefaultInstance());

    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(resultAttributes);
    resultsAddKeyValueProto.setResultTelemetries(new ArrayList<>());

    ResultsAddKeyValueProto resultsAddKeyValueProto2 = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto2.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto2.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertNotEquals(resultsAddKeyValueProto, resultsAddKeyValueProto2);
  }

  /**
   * Method under test: {@link ResultsAddKeyValueProto#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<TransportProtos.KeyValueProto> resultTelemetries = new ArrayList<>();
    resultTelemetries.add(TransportProtos.KeyValueProto.getDefaultInstance());

    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto.setResultTelemetries(resultTelemetries);

    ResultsAddKeyValueProto resultsAddKeyValueProto2 = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto2.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto2.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertNotEquals(resultsAddKeyValueProto, resultsAddKeyValueProto2);
  }

  /**
   * Method under test: {@link ResultsAddKeyValueProto#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertNotEquals(resultsAddKeyValueProto, null);
  }

  /**
   * Method under test: {@link ResultsAddKeyValueProto#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertNotEquals(resultsAddKeyValueProto, "Different type to ResultsAddKeyValueProto");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ResultsAddKeyValueProto}
   *   <li>{@link ResultsAddKeyValueProto#setResultAttributes(List)}
   *   <li>{@link ResultsAddKeyValueProto#setResultTelemetries(List)}
   *   <li>{@link ResultsAddKeyValueProto#toString()}
   *   <li>{@link ResultsAddKeyValueProto#getResultAttributes()}
   *   <li>{@link ResultsAddKeyValueProto#getResultTelemetries()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ResultsAddKeyValueProto actualResultsAddKeyValueProto = new ResultsAddKeyValueProto();
    ArrayList<TransportProtos.KeyValueProto> resultAttributes = new ArrayList<>();
    actualResultsAddKeyValueProto.setResultAttributes(resultAttributes);
    ArrayList<TransportProtos.KeyValueProto> resultTelemetries = new ArrayList<>();
    actualResultsAddKeyValueProto.setResultTelemetries(resultTelemetries);
    String actualToStringResult = actualResultsAddKeyValueProto.toString();
    List<TransportProtos.KeyValueProto> actualResultAttributes = actualResultsAddKeyValueProto.getResultAttributes();
    List<TransportProtos.KeyValueProto> actualResultTelemetries = actualResultsAddKeyValueProto.getResultTelemetries();

    // Assert that nothing has changed
    assertEquals("ResultsAddKeyValueProto(resultAttributes=[], resultTelemetries=[])", actualToStringResult);
    assertTrue(actualResultAttributes.isEmpty());
    assertTrue(actualResultTelemetries.isEmpty());
    assertSame(resultAttributes, actualResultAttributes);
    assertSame(resultTelemetries, actualResultTelemetries);
  }
}
