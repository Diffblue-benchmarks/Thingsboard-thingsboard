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
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ParametersAnalyzeResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParametersAnalyzeResult#equals(Object)}
   *   <li>{@link ParametersAnalyzeResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    parametersAnalyzeResult.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult.setPathPostParametersDel(new HashSet<>());

    ParametersAnalyzeResult parametersAnalyzeResult2 = new ParametersAnalyzeResult();
    parametersAnalyzeResult2.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult2.setPathPostParametersDel(new HashSet<>());

    // Act and Assert
    assertEquals(parametersAnalyzeResult, parametersAnalyzeResult2);
    int expectedHashCodeResult = parametersAnalyzeResult.hashCode();
    assertEquals(expectedHashCodeResult, parametersAnalyzeResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParametersAnalyzeResult#equals(Object)}
   *   <li>{@link ParametersAnalyzeResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    parametersAnalyzeResult.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult.setPathPostParametersDel(new HashSet<>());

    // Act and Assert
    assertEquals(parametersAnalyzeResult, parametersAnalyzeResult);
    int expectedHashCodeResult = parametersAnalyzeResult.hashCode();
    assertEquals(expectedHashCodeResult, parametersAnalyzeResult.hashCode());
  }

  /**
   * Method under test: {@link ParametersAnalyzeResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<String> pathPostParametersAdd = new HashSet<>();
    pathPostParametersAdd.add("foo");

    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    parametersAnalyzeResult.setPathPostParametersAdd(pathPostParametersAdd);
    parametersAnalyzeResult.setPathPostParametersDel(new HashSet<>());

    ParametersAnalyzeResult parametersAnalyzeResult2 = new ParametersAnalyzeResult();
    parametersAnalyzeResult2.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult2.setPathPostParametersDel(new HashSet<>());

    // Act and Assert
    assertNotEquals(parametersAnalyzeResult, parametersAnalyzeResult2);
  }

  /**
   * Method under test: {@link ParametersAnalyzeResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<String> pathPostParametersDel = new HashSet<>();
    pathPostParametersDel.add("foo");

    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    parametersAnalyzeResult.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult.setPathPostParametersDel(pathPostParametersDel);

    ParametersAnalyzeResult parametersAnalyzeResult2 = new ParametersAnalyzeResult();
    parametersAnalyzeResult2.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult2.setPathPostParametersDel(new HashSet<>());

    // Act and Assert
    assertNotEquals(parametersAnalyzeResult, parametersAnalyzeResult2);
  }

  /**
   * Method under test: {@link ParametersAnalyzeResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    parametersAnalyzeResult.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult.setPathPostParametersDel(new HashSet<>());

    // Act and Assert
    assertNotEquals(parametersAnalyzeResult, null);
  }

  /**
   * Method under test: {@link ParametersAnalyzeResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    parametersAnalyzeResult.setPathPostParametersAdd(new HashSet<>());
    parametersAnalyzeResult.setPathPostParametersDel(new HashSet<>());

    // Act and Assert
    assertNotEquals(parametersAnalyzeResult, "Different type to ParametersAnalyzeResult");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParametersAnalyzeResult#setPathPostParametersAdd(Set)}
   *   <li>{@link ParametersAnalyzeResult#setPathPostParametersDel(Set)}
   *   <li>{@link ParametersAnalyzeResult#toString()}
   *   <li>{@link ParametersAnalyzeResult#getPathPostParametersAdd()}
   *   <li>{@link ParametersAnalyzeResult#getPathPostParametersDel()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ParametersAnalyzeResult parametersAnalyzeResult = new ParametersAnalyzeResult();
    HashSet<String> pathPostParametersAdd = new HashSet<>();

    // Act
    parametersAnalyzeResult.setPathPostParametersAdd(pathPostParametersAdd);
    HashSet<String> pathPostParametersDel = new HashSet<>();
    parametersAnalyzeResult.setPathPostParametersDel(pathPostParametersDel);
    String actualToStringResult = parametersAnalyzeResult.toString();
    Set<String> actualPathPostParametersAdd = parametersAnalyzeResult.getPathPostParametersAdd();
    Set<String> actualPathPostParametersDel = parametersAnalyzeResult.getPathPostParametersDel();

    // Assert that nothing has changed
    assertEquals("ParametersAnalyzeResult(pathPostParametersAdd=[], pathPostParametersDel=[])", actualToStringResult);
    assertTrue(actualPathPostParametersAdd.isEmpty());
    assertTrue(actualPathPostParametersDel.isEmpty());
    assertSame(pathPostParametersAdd, actualPathPostParametersAdd);
    assertSame(pathPostParametersDel, actualPathPostParametersDel);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ParametersAnalyzeResult}
   */
  @Test
  void testNewParametersAnalyzeResult() {
    // Arrange and Act
    ParametersAnalyzeResult actualParametersAnalyzeResult = new ParametersAnalyzeResult();

    // Assert
    assertTrue(actualParametersAnalyzeResult.getPathPostParametersAdd().isEmpty());
    assertTrue(actualParametersAnalyzeResult.getPathPostParametersDel().isEmpty());
  }
}
