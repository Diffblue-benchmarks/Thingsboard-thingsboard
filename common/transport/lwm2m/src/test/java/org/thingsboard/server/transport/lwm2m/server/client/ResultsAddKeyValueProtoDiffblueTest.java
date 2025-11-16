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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueProto;

class ResultsAddKeyValueProtoDiffblueTest {
  /**
   * Test {@link ResultsAddKeyValueProto#equals(Object)}, and {@link
   * ResultsAddKeyValueProto#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResultsAddKeyValueProto#equals(Object)}
   *   <li>{@link ResultsAddKeyValueProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResultsAddKeyValueProto.equals(Object)",
    "int ResultsAddKeyValueProto.hashCode()"
  })
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
    assertEquals(resultsAddKeyValueProto.hashCode(), resultsAddKeyValueProto2.hashCode());
  }

  /**
   * Test {@link ResultsAddKeyValueProto#equals(Object)}, and {@link
   * ResultsAddKeyValueProto#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResultsAddKeyValueProto#equals(Object)}
   *   <li>{@link ResultsAddKeyValueProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResultsAddKeyValueProto.equals(Object)",
    "int ResultsAddKeyValueProto.hashCode()"
  })
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
   * Test {@link ResultsAddKeyValueProto#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResultsAddKeyValueProto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResultsAddKeyValueProto.equals(Object)",
    "int ResultsAddKeyValueProto.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertNotEquals(resultsAddKeyValueProto, null);
  }

  /**
   * Test {@link ResultsAddKeyValueProto#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResultsAddKeyValueProto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResultsAddKeyValueProto.equals(Object)",
    "int ResultsAddKeyValueProto.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ResultsAddKeyValueProto resultsAddKeyValueProto = new ResultsAddKeyValueProto();
    resultsAddKeyValueProto.setResultAttributes(new ArrayList<>());
    resultsAddKeyValueProto.setResultTelemetries(new ArrayList<>());

    // Act and Assert
    assertNotEquals(resultsAddKeyValueProto, "Different type to ResultsAddKeyValueProto");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResultsAddKeyValueProto.<init>()",
    "List ResultsAddKeyValueProto.getResultAttributes()",
    "List ResultsAddKeyValueProto.getResultTelemetries()",
    "void ResultsAddKeyValueProto.setResultAttributes(List)",
    "void ResultsAddKeyValueProto.setResultTelemetries(List)",
    "String ResultsAddKeyValueProto.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ResultsAddKeyValueProto actualResultsAddKeyValueProto = new ResultsAddKeyValueProto();
    ArrayList<KeyValueProto> resultAttributes = new ArrayList<>();
    actualResultsAddKeyValueProto.setResultAttributes(resultAttributes);
    ArrayList<KeyValueProto> resultTelemetries = new ArrayList<>();
    actualResultsAddKeyValueProto.setResultTelemetries(resultTelemetries);
    String actualToStringResult = actualResultsAddKeyValueProto.toString();
    List<KeyValueProto> actualResultAttributes =
        actualResultsAddKeyValueProto.getResultAttributes();
    List<KeyValueProto> actualResultTelemetries =
        actualResultsAddKeyValueProto.getResultTelemetries();

    // Assert
    assertEquals(
        "ResultsAddKeyValueProto(resultAttributes=[], resultTelemetries=[])", actualToStringResult);
    assertTrue(actualResultAttributes.isEmpty());
    assertTrue(actualResultTelemetries.isEmpty());
    assertSame(resultAttributes, actualResultAttributes);
    assertSame(resultTelemetries, actualResultTelemetries);
  }
}
